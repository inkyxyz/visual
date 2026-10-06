package globals.client.snowball;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import globals.client.WorldKey;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.GlobalsMenuModule;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iiIiIIiii_Class424;

public class SnowballManager implements iIIiIIiIi_Class294 {
   private static SnowballManager instance;
   private final List<GlowSnowball> snowballs = new CopyOnWriteArrayList<>();
   private final List<SnowParticle> particles = new CopyOnWriteArrayList<>();
   private static final Identifier BLOOM_TEXTURE = RockstarClient.id("textures/bloom.png");
   private static final float PARTICLE_SIZE = 0.25F;
   private static final float PARTICLE_BIG_SIZE = 0.5F;
   private static final float SPHERE_RADIUS = 0.1F;
   private static final int PARTICLE_COUNT = 50;
   private static final int DEBRIS_PARTICLE_COUNT = 150;
   private static final float DEBRIS_SIZE = 0.15F;
   private static final float DEBRIS_BIG_SIZE = 0.3F;
   private static final int TARGET_FROZEN_TICKS = 139;
   private static final int FREEZE_RAMP_SPEED = 20;
   private static final double[] SPHERE_X = new double[50];
   private static final double[] SPHERE_Y = new double[50];
   private static final double[] SPHERE_Z = new double[50];
   private static final iiIiIIiii_Class424 timer = new iiIiIIiii_Class424();
   private int targetFrozenTicks = 0;
   public final IiIIIiII_Class69<KeyPressEvent> onKeyPress = var1 -> {
      if (var1.getAction() == 1) {
         if (I_field_3a9bda27.currentScreen == null) {
            GlobalsMenuModule var2 = RockstarClient.getInstance().getModuleManager().getModule(GlobalsMenuModule.class);
            if (var2.I_method_d7b872b5().I_method_51ee2d08(var1.getKey())) {
               this.throwSnowball();
            }
         }
      }
   };
   private final IiIIIiII_Class69<MouseEvent> onMouseEvent = var1 -> {
      if (I_field_3a9bda27.currentScreen == null) {
         GlobalsMenuModule var2 = RockstarClient.getInstance().getModuleManager().getModule(GlobalsMenuModule.class);
         if (var2.I_method_d7b872b5().I_method_51ee2d08(var1.getButton())) {
            this.throwSnowball();
         }
      }
   };
   public final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = var1 -> this.tick();
   public final IiIIIiII_Class69<Render3DEvent> onRender3D = var1 -> this.render3D(var1.getMatrices(), var1.getTickDelta());

   public static SnowballManager getInstance() {
      if (instance == null) {
         instance = new SnowballManager();
      }

      return instance;
   }

   public void register() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public void throwSnowball() {
      if (I_field_3a9bda27.player != null && timer.I_method_58432069(500L)) {
         Vec3d var1 = I_field_3a9bda27.player.getEyePos();
         Vec3d var2 = I_field_3a9bda27.player.getRotationVec(1.0F);
         Packets.Nested1_242f4d2b var3 = RockstarClient.getInstance().I_method_cd3d46d0().getGameInfo();
         if (var3 != null) {
            RockstarClient.getInstance()
               .I_method_cd3d46d0()
               .send(
                  new Packets.Nested1_c59442a1(
                     new Packets.Nested1_3834b16e(var1.x, var1.y, var1.z), new Packets.Nested1_3834b16e(var2.x, var2.y, var2.z), "", var3.server(), var3.hash()
                  )
               );
            timer.I_method_23e11e3f();
         }
      }
   }

   public void onSnowballReceived(Packets.Nested1_2a2d6379 var1) {
      if (I_field_3a9bda27.player != null) {
         if (var1.author().gameInfo() != null) {
            String var2 = var1.author().gameInfo().nickname();
            if (var2 != null && !var2.isEmpty()) {
               if (WorldKey.sameWorld(var1.author().gameInfo())) {
                  Vec3d var3 = new Vec3d(var1.position().x(), var1.position().y(), var1.position().z());
                  Vec3d var4 = new Vec3d(var1.direction().x(), var1.direction().y(), var1.direction().z());
                  this.snowballs.add(new GlowSnowball(var3, var4, var2));
               }
            }
         }
      }
   }

   private void spawnDebrisParticles(GlowSnowball var1) {
      Vec3d var2 = var1.getPosition();
      Vec3d var3 = var1.getVelocity();

      for (int var4 = 0; var4 < 150; var4++) {
         double var5 = Math.acos(1.0 - 2.0 * (var4 + 0.5) / 150.0);
         double var7 = Math.PI * (1.0 + Math.sqrt(5.0)) * var4;
         double var9 = 0.1F * iIIiiiiiI_Class319.I_method_a586e9cd(var5) * iIIiiiiiI_Class319.i_method_a749d9ed(var7);
         double var11 = 0.1F * iIIiiiiiI_Class319.I_method_a586e9cd(var5) * iIIiiiiiI_Class319.I_method_a586e9cd(var7);
         double var13 = 0.1F * iIIiiiiiI_Class319.i_method_a749d9ed(var5);
         Vec3d var15 = var2.add(var9, var11, var13);
         this.particles.add(new SnowParticle(var15, var3, 0.1F));
      }
   }

   public void tick() {
      ArrayList var1 = new ArrayList();

      for (GlowSnowball var3 : this.snowballs) {
         var3.tick();
         if (var3.didHitPlayer()) {
            this.spawnDebrisParticles(var3);
            if (var3.didHitLocalPlayer() && I_field_3a9bda27.player != null) {
               this.targetFrozenTicks = 139;
            }
         }

         if (var3.didHitBlock()) {
            this.spawnDebrisParticles(var3);
         }

         if (var3.shouldRemove()) {
            var1.add(var3);
         }
      }

      this.snowballs.removeAll(var1);
      ArrayList var5 = new ArrayList();

      for (SnowParticle var4 : this.particles) {
         var4.tick();
         if (var4.shouldRemove()) {
            var5.add(var4);
         }
      }

      this.particles.removeAll(var5);
      if (I_field_3a9bda27.player instanceof FakeFrozenTicksAccess var7) {
         int var9 = var7.rockstar$getFakeFrozenTicks();
         if (this.targetFrozenTicks > 0) {
            if (var9 < this.targetFrozenTicks) {
               var7.rockstar$setFakeFrozenTicks(Math.min(var9 + 20, this.targetFrozenTicks));
            } else {
               this.targetFrozenTicks = 0;
            }
         } else if (var9 > 0) {
            var7.rockstar$setFakeFrozenTicks(var9 - 2);
         }
      }
   }

   public void render3D(MatrixStack var1, float var2) {
      if (!this.snowballs.isEmpty() || !this.particles.isEmpty()) {
         Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
         var1.push();
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
         RenderSystem.enableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.depthMask(false);
         RenderSystem.setShaderTexture(0, BLOOM_TEXTURE);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         BufferBuilder var4 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         ColorRGBA var5 = new ColorRGBA(180.0F, 220.0F, 255.0F, 255.0F);

         for (GlowSnowball var7 : this.snowballs) {
            if (!var7.isInsideAuthor()) {
               Vec3d var8 = var7.getRenderPos(var2);
               float var9 = var7.getAge() * 0.1F;
               float var10 = var7.getAlpha();
               double var11 = iIIiiiiiI_Class319.i_method_a749d9ed(var9);
               double var13 = iIIiiiiiI_Class319.I_method_a586e9cd(var9);

               for (int var15 = 0; var15 < 50; var15++) {
                  double var16 = SPHERE_X[var15] * var11 - SPHERE_Z[var15] * var13;
                  double var18 = SPHERE_X[var15] * var13 + SPHERE_Z[var15] * var11;
                  Vec3d var20 = var8.add(var16, SPHERE_Y[var15], var18);
                  var1.push();
                  iIiiiIIiI_Class371.I_method_7d461059(var1, var20);
                  var1.multiply(var3.getRotation());
                  iIiiIIiii_Class360.I_method_a9f124df(var1, var4, -0.125, -0.125, 0.0, 0.25, 0.25, var5.mulAlpha(0.9F * var10));
                  iIiiIIiii_Class360.I_method_a9f124df(var1, var4, -0.25, -0.25, 0.0, 0.5, 0.5, var5.mulAlpha(0.15F * var10));
                  var1.pop();
               }
            }
         }

         for (SnowParticle var22 : this.particles) {
            Vec3d var23 = var22.getRenderPos(var2);
            float var24 = var22.getAlpha();
            var1.push();
            iIiiiIIiI_Class371.I_method_7d461059(var1, var23);
            var1.multiply(var3.getRotation());
            iIiiIIiii_Class360.I_method_a9f124df(var1, var4, -0.075F, -0.075F, 0.0, 0.15F, 0.15F, var5.mulAlpha(0.9F * var24));
            iIiiIIiii_Class360.I_method_a9f124df(var1, var4, -0.15F, -0.15F, 0.0, 0.3F, 0.3F, var5.mulAlpha(0.15F * var24));
            var1.pop();
         }

         iIiiiIIiI_Class371.I_method_c59155f0(var4);
         RenderSystem.depthMask(true);
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.disableDepthTest();
         var1.pop();
      }
   }

   static {
      for (int var0 = 0; var0 < 50; var0++) {
         double var1 = Math.acos(1.0 - 2.0 * (var0 + 0.5) / 50.0);
         double var3 = Math.PI * (1.0 + Math.sqrt(5.0)) * var0;
         SPHERE_X[var0] = 0.1F * iIIiiiiiI_Class319.I_method_a586e9cd(var1) * iIIiiiiiI_Class319.i_method_a749d9ed(var3);
         SPHERE_Y[var0] = 0.1F * iIIiiiiiI_Class319.I_method_a586e9cd(var1) * iIIiiiiiI_Class319.I_method_a586e9cd(var3);
         SPHERE_Z[var0] = 0.1F * iIIiiiiiI_Class319.i_method_a749d9ed(var1);
      }
   }
}
