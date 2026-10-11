package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.AfterAttackEvent;
import pyrock.events.game.AttackEvent;
import pyrock.events.game.PostAttackEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Particles",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = false,
   III_method_a89e5834 = "modules.descriptions.particles"
)
public class ParticlesModule extends Module {
   private static final Random RANDOM = new Random();

   public static class CustomParticle {
      Vec3d pos;
      Vec3d vel;
      final float baseScale;
      final long startTime;
      final long duration;
      float rot;
      final float rotSpeed;
      final ColorRGBA color;
      final int type; // 0: Star, 1: Heart, 2: Spark, 3: Blood, 4: Rune, 5: Fire, 6: Neon Orb

      public CustomParticle(Vec3d pos, Vec3d vel, float baseScale, long duration, ColorRGBA color, int type) {
         this.pos = pos;
         this.vel = vel;
         this.baseScale = baseScale;
         this.startTime = System.currentTimeMillis();
         this.duration = duration;
         this.rot = RANDOM.nextFloat() * 360.0F;
         this.rotSpeed = (RANDOM.nextFloat() - 0.5F) * 360.0F;
         this.color = color;
         this.type = type;
      }

      public boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > this.duration;
      }

      public float getProgress() {
         return MathHelper.clamp((float)(System.currentTimeMillis() - this.startTime) / (float)this.duration, 0.0F, 1.0F);
      }
   }

   private final List<CustomParticle> activeParticles = new CopyOnWriteArrayList<>();

   private ModeSetting typeSetting;
   private ModeSetting.Nested1_42765c60 typeStars;
   private ModeSetting.Nested1_42765c60 typeHearts;
   private ModeSetting.Nested1_42765c60 typeSparks;
   private ModeSetting.Nested1_42765c60 typeBlood;
   private ModeSetting.Nested1_42765c60 typeRunes;
   private ModeSetting.Nested1_42765c60 typeFire;
   private ModeSetting.Nested1_42765c60 typeNeonOrbs;

   private BooleanSetting triggerHit;
   private BooleanSetting triggerTrail;
   private BooleanSetting triggerJump;
   private BooleanSetting triggerAmbient;

   private SliderSetting countSetting;
   private SliderSetting scaleSetting;
   private SliderSetting lifetimeSetting;
   private SliderSetting speedSetting;
   private BooleanSetting physicsGravity;
   private BooleanSetting syncTheme;
   private ColorSetting customColor;

   public ParticlesModule() {
      this.initSettings();
   }

   @Compile(obfuscation = 4)
   private void initSettings() {
      this.typeSetting = new ModeSetting(this, "Тип частиц");
      this.typeStars = new ModeSetting.Nested1_42765c60(this.typeSetting, "Звёзды").select();
      this.typeHearts = new ModeSetting.Nested1_42765c60(this.typeSetting, "Сердца");
      this.typeSparks = new ModeSetting.Nested1_42765c60(this.typeSetting, "Искры");
      this.typeBlood = new ModeSetting.Nested1_42765c60(this.typeSetting, "Кровь");
      this.typeRunes = new ModeSetting.Nested1_42765c60(this.typeSetting, "Руны");
      this.typeFire = new ModeSetting.Nested1_42765c60(this.typeSetting, "Огонь");
      this.typeNeonOrbs = new ModeSetting.Nested1_42765c60(this.typeSetting, "Сферы");

      this.triggerHit = new BooleanSetting(this, "При ударе").select();
      this.triggerTrail = new BooleanSetting(this, "При ходьбе").select();
      this.triggerJump = new BooleanSetting(this, "При прыжке").select();
      this.triggerAmbient = new BooleanSetting(this, "Вокруг игрока");

      this.countSetting = new SliderSetting(this, "Количество")
         .I_method_c8c9a7d7(1.0F).i_method_65e2aff7(24.0F).II_method_b0f56334(1.0F).Ii_method_4e0e6b54(6.0F);

      this.scaleSetting = new SliderSetting(this, "Размер")
         .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(0.8F);

      this.lifetimeSetting = new SliderSetting(this, "Время жизни (сек)")
         .I_method_c8c9a7d7(0.4F).i_method_65e2aff7(3.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.2F);

      this.speedSetting = new SliderSetting(this, "Скорость")
         .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(3.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

      this.physicsGravity = new BooleanSetting(this, "Гравитация").select();
      this.syncTheme = new BooleanSetting(this, "theme.sync").select();
      this.customColor = new ColorSetting(this, "Цвет", this.syncTheme::i_method_9b12da03)
         .I_method_a62f5dd6(new ColorRGBA(0.0F, 220.0F, 255.0F, 240.0F));
   }

   private int getSelectedTypeIndex() {
      if (this.typeHearts != null && this.typeHearts.isSelected()) return 1;
      if (this.typeSparks != null && this.typeSparks.isSelected()) return 2;
      if (this.typeBlood != null && this.typeBlood.isSelected()) return 3;
      if (this.typeRunes != null && this.typeRunes.isSelected()) return 4;
      if (this.typeFire != null && this.typeFire.isSelected()) return 5;
      if (this.typeNeonOrbs != null && this.typeNeonOrbs.isSelected()) return 6;
      return 0; // Stars
   }

   private ColorRGBA getActiveParticleColor(int typeIndex) {
      if (typeIndex == 3) {
         // Blood is always crimson / deep red
         return new ColorRGBA(220.0F + RANDOM.nextFloat() * 35.0F, 10.0F, 20.0F, 240.0F);
      }
      if (typeIndex == 5) {
         // Fire: vibrant yellow to orange gradient
         return new ColorRGBA(255.0F, 120.0F + RANDOM.nextFloat() * 120.0F, 20.0F, 240.0F);
      }
      if (this.syncTheme != null && this.syncTheme.i_method_9b12da03()) {
         return IiiiiIIIi_Class242.i_method_5dfec6e();
      }
      return this.customColor != null ? this.customColor.I_method_bde5f08e() : new ColorRGBA(0.0F, 230.0F, 255.0F, 240.0F);
   }

   public void spawnBurst(Vec3d origin, int count, float spreadSpeed) {
      if (!this.isEnabled()) return;
      int type = this.getSelectedTypeIndex();
      long durMs = (long)((this.lifetimeSetting != null ? this.lifetimeSetting.Ii_method_a20abcd2() : 1.2F) * 1000.0F);
      float baseSz = (this.scaleSetting != null ? this.scaleSetting.Ii_method_a20abcd2() : 0.8F) * 0.22F;

      for (int i = 0; i < count; i++) {
         double theta = RANDOM.nextDouble() * Math.PI * 2.0;
         double phi = (RANDOM.nextDouble() - 0.5) * Math.PI;
         float spd = (0.5F + RANDOM.nextFloat() * 1.5F) * spreadSpeed;

         double vx = Math.cos(phi) * Math.cos(theta) * spd;
         double vy = Math.sin(phi) * spd + (type == 5 ? 0.8 : 0.2);
         double vz = Math.cos(phi) * Math.sin(theta) * spd;

         Vec3d v = new Vec3d(vx, vy, vz);
         ColorRGBA col = this.getActiveParticleColor(type);
         this.activeParticles.add(new CustomParticle(origin, v, baseSz, durMs, col, type));
      }
   }

   private void onHitEntity(Entity entity) {
      if (this.triggerHit != null && this.triggerHit.i_method_9b12da03() && entity instanceof LivingEntity living) {
         int count = (int)(this.countSetting != null ? this.countSetting.Ii_method_a20abcd2() : 6.0F);
         float speed = this.speedSetting != null ? this.speedSetting.Ii_method_a20abcd2() : 1.0F;
         Vec3d hitPos = living.getPos().add(0.0, living.getHeight() * 0.55, 0.0);
         this.spawnBurst(hitPos, count, speed * 0.8F);
      }
   }

   private final IiIIIiII_Class69<AttackEvent> attackListener = event -> this.onHitEntity(event.getEntity());
   private final IiIIIiII_Class69<PostAttackEvent> postAttackListener = event -> this.onHitEntity(event.getEntity());
   private final IiIIIiII_Class69<AfterAttackEvent> afterAttackListener = event -> this.onHitEntity(event.getEntity());

   private boolean wasOnGround = true;

   private final IiIIIiII_Class69<ClientPlayerTickEvent> tickListener = event -> {
      if (!this.isEnabled()) return;
      MinecraftClient mc = MinecraftClient.getInstance();
      if (mc.player == null) return;

      // Jump trigger
      if (this.triggerJump != null && this.triggerJump.i_method_9b12da03()) {
         if (this.wasOnGround && !mc.player.isOnGround() && mc.player.getVelocity().y > 0.05) {
            Vec3d p = mc.player.getPos().add(0.0, 0.1, 0.0);
            this.spawnBurst(p, 8, 0.5F);
         }
      }
      this.wasOnGround = mc.player.isOnGround();

      // Walking Trail trigger
      if (this.triggerTrail != null && this.triggerTrail.i_method_9b12da03()) {
         if (mc.player.getVelocity().horizontalLengthSquared() > 0.005) {
            Vec3d trailPos = mc.player.getPos().add(
               (RANDOM.nextFloat() - 0.5) * 0.35,
               0.15 + (RANDOM.nextFloat() * 0.2),
               (RANDOM.nextFloat() - 0.5) * 0.35
            );
            this.spawnBurst(trailPos, 1, 0.2F);
         }
      }

      // Ambient trigger
      if (this.triggerAmbient != null && this.triggerAmbient.i_method_9b12da03()) {
         if (RANDOM.nextFloat() < 0.35F) {
            Vec3d ambPos = mc.player.getPos().add(
               (RANDOM.nextFloat() - 0.5) * 2.2,
               RANDOM.nextFloat() * 2.0,
               (RANDOM.nextFloat() - 0.5) * 2.2
            );
            this.spawnBurst(ambPos, 1, 0.1F);
         }
      }

      // Update particle physics
      boolean grav = this.physicsGravity != null && this.physicsGravity.i_method_9b12da03();
      for (CustomParticle cp : this.activeParticles) {
         cp.pos = cp.pos.add(cp.vel.multiply(0.05));
         double drag = 0.94;
         double gy = grav ? (cp.type == 5 ? 0.015 : -0.025) : 0.0;
         cp.vel = new Vec3d(cp.vel.x * drag, (cp.vel.y + gy) * drag, cp.vel.z * drag);
         cp.rot += cp.rotSpeed * 0.05F;
      }

      this.activeParticles.removeIf(CustomParticle::isExpired);
   };

   private final IiIIIiII_Class69<WorldChangeEvent> worldListener = event -> this.activeParticles.clear();

   private final IiIIIiII_Class69<Render3DEvent> renderListener = event -> {
      if (this.activeParticles.isEmpty()) return;

      Camera cam = I_field_3a9bda27.gameRenderer.getCamera();
      Vec3d camPos = cam.getPos();
      MatrixStack m = event.getMatrices();

      m.push();
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
      RenderSystem.enableDepthTest();
      RenderSystem.disableCull();
      RenderSystem.depthMask(false);

      Identifier bloomTex = RockstarClient.id("textures/bloom.png");
      RenderSystem.setShaderTexture(0, bloomTex);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

      for (CustomParticle p : this.activeParticles) {
         float prog = p.getProgress();
         float alpha = (prog < 0.2F) ? (prog / 0.2F) : (1.0F - (prog - 0.2F) / 0.8F);
         if (alpha <= 0.01F) continue;

         float curScale = p.baseScale * (0.8F + (1.0F - prog) * 0.4F);
         ColorRGBA col = p.color.withAlpha(p.color.getAlpha() * alpha);

         m.push();
         m.translate(p.pos.x - camPos.x, p.pos.y - camPos.y, p.pos.z - camPos.z);
         m.multiply(cam.getRotation());
         m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(p.rot));

         switch (p.type) {
            case 0 -> {
               // Star: 4-pointed cross star
               float starW = curScale * 0.35F;
               float starH = curScale * 1.5F;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -starW * 0.5F, -starH * 0.5F, 0.0, starW, starH, col);
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -starH * 0.5F, -starW * 0.5F, 0.0, starH, starW, col);
            }
            case 1 -> {
               // Heart: two lobes and a lower triangle
               float lobeSz = curScale * 0.65F;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -lobeSz * 0.8F, 0.0F, 0.0, lobeSz, lobeSz, col);
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.05F, 0.0F, 0.0, lobeSz, lobeSz, col);
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -curScale * 0.5F, -curScale * 0.65F, 0.0, curScale, curScale * 0.75F, col);
            }
            case 2 -> {
               // Spark: high aspect ratio streak
               float sparkW = curScale * 0.22F;
               float sparkH = curScale * 1.8F;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -sparkW * 0.5F, -sparkH * 0.5F, 0.0, sparkW, sparkH, col);
            }
            case 3 -> {
               // Blood droplet: round droplet with trailing splat
               float bSz = curScale * 0.9F;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -bSz * 0.5F, -bSz * 0.5F, 0.0, bSz, bSz, col);
            }
            case 4 -> {
               // Rune: diamond with hollow center glow
               float rSz = curScale * 1.1F;
               m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45.0F));
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -rSz * 0.5F, -rSz * 0.5F, 0.0, rSz, rSz, col);
            }
            case 5 -> {
               // Fire: rising teardrop ember
               float fSz = curScale * (1.2F - prog * 0.5F);
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -fSz * 0.5F, -fSz * 0.5F, 0.0, fSz, fSz * 1.3F, col);
            }
            default -> {
               // Neon Orb: soft circle
               float oSz = curScale * 1.2F;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -oSz * 0.5F, -oSz * 0.5F, 0.0, oSz, oSz, col);
            }
         }

         m.pop();
      }

      BuiltBuffer built = buf.endNullable();
      if (built != null) {
         BufferRenderer.drawWithGlobalProgram(built);
      }

      RenderSystem.depthMask(true);
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.disableBlend();
      RenderSystem.enableCull();
      RenderSystem.disableDepthTest();
      m.pop();
   };
}
