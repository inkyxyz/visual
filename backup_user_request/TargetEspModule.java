package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
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
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import pyrock.events.game.AfterAttackEvent;
import pyrock.events.game.AttackEvent;
import pyrock.events.game.PostAttackEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Target ESP",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = false,
   III_method_a89e5834 = "modules.descriptions.target_esp"
)
public class TargetEspModule extends Module {
   private static final int I_field_49 = 60;
   private static final int i_field_49 = 30;
   private static final float I_field_46 = 1.0F;
   private static final float i_field_46 = 3.5F;
   private static final float II_field_46 = 1.0F;

   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627; // Souls
   private ModeSetting.Nested1_42765c60 i_field_500d0627; // Crystals
   private ModeSetting.Nested1_42765c60 II_field_500d0627; // Circle
   private ModeSetting.Nested1_42765c60 Ii_field_500d0627; // Jello
   private ModeSetting.Nested1_42765c60 modeCardsSequential;
   private ModeSetting.Nested1_42765c60 modeCardsTriple;
   private ModeSetting.Nested1_42765c60 modeCardsTrio;
   private SliderSetting cardSpeedSetting;
   private SliderSetting cardScaleSetting;
   private SliderSetting cardCountSetting;
   private BooleanSetting cardFoilSetting;

   private ModeSetting cardDeckSetting;
   private ModeSetting.Nested1_42765c60 deckUnoCards;
   private ModeSetting.Nested1_42765c60 deckClassicPoker;
   private ModeSetting.Nested1_42765c60 deckRoyalFlush;
   private ModeSetting.Nested1_42765c60 deckAcesOnly;
   private ModeSetting.Nested1_42765c60 deckCourtCards;
   private ModeSetting.Nested1_42765c60 deckJokersWild;

   private ModeSetting cardBackSetting;
   private ModeSetting.Nested1_42765c60 backMeshRed;
   private ModeSetting.Nested1_42765c60 backMeshBlue;
   private ModeSetting.Nested1_42765c60 backUno;
   private ModeSetting.Nested1_42765c60 backBicycle;
   private ModeSetting.Nested1_42765c60 backRoyalGold;
   private ModeSetting.Nested1_42765c60 backCyberNeon;
   private ModeSetting.Nested1_42765c60 backDarkArcane;

   private BooleanSetting Ii_field_ba20ca4c; // lighting / trails
   private BooleanSetting II_field_ba20ca4c; // theme.sync
   private ColorSetting I_field_bbd4b66c;

   private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.IiI_field_dd60aac);
   private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(70L, 0.0F, IiiiIiiII_Class237.Iii_field_dd60aac);
   private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(100L, 0.0F, IiiiIiiII_Class237.iIiI_field_dd60aac);
   private final IiiiIiIii_Class236 Ii_field_dc7facc = new IiiiIiIii_Class236(250L, 0.0F, IiiiIiiII_Class237.IiI_field_dd60aac);
   private float Ii_field_46 = 1.0F;
   private LivingEntity I_field_966247a3;
   private long lastAttackTargetTime = 0L;
   private final IIIiII_Class5 I_field_83b89a01 = new IIIiII_Class5();
   private Vec2f I_field_5bba09cd = Vec2f.ZERO;
   private final IiiiIiIii_Class236 iI_field_dc7facc = new IiiiIiIii_Class236(250L, IiiiIiiII_Class237.IiI_field_dd60aac);
   private final IiiiIiIii_Class236 ii_field_dc7facc = new IiiiIiIii_Class236(150L, IiiiIiiII_Class237.IiI_field_dd60aac);
   private final IiiiIiIii_Class236 III_field_dc7facc = new IiiiIiIii_Class236(150L, IiiiIiiII_Class237.IiI_field_dd60aac);
   private final IiiiIiIii_Class236 IIi_field_dc7facc = new IiiiIiIii_Class236(350L, IiiiIiiII_Class237.IiI_field_dd60aac);
   private final IiiiIiIii_Class236 IiI_field_dc7facc = new IiiiIiIii_Class236(350L, IiiiIiiII_Class237.IiI_field_dd60aac);
   private final IiiiIiIii_Class236 Iii_field_dc7facc = new IiiiIiIii_Class236(250L, IiiiIiiII_Class237.I_field_dd60aac);

   private void lockTarget(Entity entity) {
      if (entity instanceof LivingEntity living && living != I_field_3a9bda27.player && !living.isInvisible()) {
         this.I_field_966247a3 = living;
         this.lastAttackTargetTime = System.currentTimeMillis();
      }
   }

   private final IiIIIiII_Class69<AfterAttackEvent> afterAttackListener = var1 -> this.lockTarget(var1.getEntity());
   private final IiIIIiII_Class69<PostAttackEvent> postAttackListener = var1 -> this.lockTarget(var1.getEntity());
   private final IiIIIiII_Class69<AttackEvent> attackListener = var1 -> this.lockTarget(var1.getEntity());

   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1 -> {
      if (IiiiiiiII_Class253.i_method_1cc4aa23()) {
         LivingEntity var3 = null;
         if (I_field_3a9bda27.targetedEntity instanceof LivingEntity var5) {
            if (!var5.isInvisible() && I_field_3a9bda27.player != null && I_field_3a9bda27.player.distanceTo(var5) <= 12.0F) {
               var3 = var5;
            }
         } else if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            Vec3d cameraPos = I_field_3a9bda27.player.getCameraPosVec(1.0F);
            Vec3d rot = I_field_3a9bda27.player.getRotationVec(1.0F);
            Vec3d reach = cameraPos.add(rot.multiply(6.0));
            double closest = Double.MAX_VALUE;
            for (Entity e : I_field_3a9bda27.world.getEntities()) {
               if (e instanceof LivingEntity living && e != I_field_3a9bda27.player && !e.isInvisible() && I_field_3a9bda27.player.distanceTo(living) <= 6.0F) {
                  net.minecraft.util.math.Box box = e.getBoundingBox().expand(0.3);
                  java.util.Optional<Vec3d> hit = box.raycast(cameraPos, reach);
                  if (hit.isPresent()) {
                     double dist = cameraPos.squaredDistanceTo(hit.get());
                     if (dist < closest) {
                        closest = dist;
                        var3 = living;
                     }
                  }
               }
            }
         }

         if (var3 != null) {
            this.I_field_966247a3 = var3;
            this.lastAttackTargetTime = System.currentTimeMillis();
         } else if (this.I_field_966247a3 != null) {
            if (System.currentTimeMillis() - this.lastAttackTargetTime < 3500L
                && this.I_field_966247a3.isAlive()
                && !this.I_field_966247a3.isRemoved()
                && I_field_3a9bda27.player != null
                && I_field_3a9bda27.player.distanceTo(this.I_field_966247a3) <= 14.0F) {
               var3 = this.I_field_966247a3;
            } else {
               this.I_field_966247a3 = null;
            }
         }

         this.Ii_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.IiI_field_dd60aac);
         this.Ii_field_dc7facc.I_method_edd6ec25(350L);
         this.I_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.III_field_dd60aac);
         this.I_field_dc7facc.I_method_edd72835(var3 != null);
         this.i_field_dc7facc.I_method_edd6dd11(this.i_field_dc7facc.I_method_6ac4da6f() + 10.0F + 50.0F);
         if (this.i_field_dc7facc.I_method_6ac4da6f() > Float.MAX_VALUE || Float.isNaN(this.i_field_dc7facc.I_method_6ac4da6f())) {
            this.i_field_dc7facc.I_method_edd6dd21(0.0F);
         }

         if (this.I_field_966247a3 != null && (this.I_field_966247a3.isInvisible() || (I_field_3a9bda27.player != null && I_field_3a9bda27.player.distanceTo(this.I_field_966247a3) > 16.0F))) {
            this.I_field_966247a3 = null;
         }

         if (this.I_field_966247a3 != null && this.I_field_dc7facc.I_method_6ac4da6f() != 0.0F) {
            this.II_field_dc7facc.I_method_edd72835(this.I_field_966247a3.hurtTime > 0);
            this.i_method_ca75e9ff(var1);
            MatrixStack var7 = var1.getMatrices();
            var7.push();
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
            RenderSystem.disableCull();
            RenderSystem.depthMask(false);
            RenderSystem.enableDepthTest();
            RenderSystem.depthFunc(515);
            this.Ii_field_46 = 1.0F;
            var7.push();
            this.I_method_469aa82c(var7, this.I_field_966247a3);
            var7.pop();

            RenderSystem.depthMask(true);
            RenderSystem.setShaderTexture(0, 0);
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
            RenderSystem.disableDepthTest();
            var7.pop();
         }
      }
   };

   @Compile(
      obfuscation = 4
   )
   private boolean isCardMode() {
      return (this.modeCardsSequential != null && this.modeCardsSequential.isSelected())
          || (this.modeCardsTriple != null && this.modeCardsTriple.isSelected())
          || (this.modeCardsTrio != null && this.modeCardsTrio.isSelected());
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_a798725f() {
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.target_esp.mode");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.target_esp.mode.jello").select();
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.target_esp.mode.circle");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.target_esp.mode.souls");
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.target_esp.mode.crystals");
      this.modeCardsSequential = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "Cards Sequential");
      this.modeCardsTriple = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "Cards Triple");
      this.modeCardsTrio = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "Cards Trio");

      this.cardSpeedSetting = new SliderSetting(this, "Card Speed", () -> !this.isCardMode())
         .I_method_c8c9a7d7(0.5F)
         .i_method_65e2aff7(4.0F)
         .II_method_b0f56334(0.1F)
         .Ii_method_4e0e6b54(1.5F);

      this.cardScaleSetting = new SliderSetting(this, "Card Scale", () -> !this.isCardMode())
         .I_method_c8c9a7d7(0.4F)
         .i_method_65e2aff7(2.5F)
         .II_method_b0f56334(0.1F)
         .Ii_method_4e0e6b54(1.0F);

      this.cardCountSetting = new SliderSetting(this, "Card Count", () -> !this.isCardMode())
         .I_method_c8c9a7d7(3.0F)
         .i_method_65e2aff7(12.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(5.0F);

      this.cardFoilSetting = new BooleanSetting(this, "Card Foil", () -> !this.isCardMode()).I_method_decd82b5();

      this.cardDeckSetting = new ModeSetting(this, "Card Deck", () -> !this.isCardMode());
      this.deckUnoCards = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Uno Cards");
      this.deckClassicPoker = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Classic Poker").select();
      this.deckRoyalFlush = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Royal Flush");
      this.deckAcesOnly = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Aces Only");
      this.deckCourtCards = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Court Cards");
      this.deckJokersWild = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Jokers Wild");

      this.cardBackSetting = new ModeSetting(this, "Card Back", () -> !this.isCardMode());
      this.backMeshRed = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Classic Mesh (Red)").select();
      this.backMeshBlue = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Classic Mesh (Blue)");
      this.backUno = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Uno Classic");
      this.backBicycle = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Bicycle Classic");
      this.backRoyalGold = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Royal Gold");
      this.backCyberNeon = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Cyber Neon");
      this.backDarkArcane = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Dark Arcane");

      this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.target_esp.lighting").I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(this, "theme.sync").I_method_decd82b5();
      this.I_field_bbd4b66c = new ColorSetting(this, "modules.settings.target_esp.color", this.II_field_ba20ca4c::i_method_9b12da03)
         .I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e());
   }

   private Identifier[] getActiveDeck() {
      if (this.cardDeckSetting != null) {
         if (this.cardDeckSetting.isSelected("Uno Cards")) return CardRenderHelper.UNO_CARDS;
         if (this.cardDeckSetting.isSelected("Royal Flush")) return CardRenderHelper.ROYAL_FLUSH_CARDS;
         if (this.cardDeckSetting.isSelected("Aces Only")) return CardRenderHelper.ACES;
         if (this.cardDeckSetting.isSelected("Court Cards")) return CardRenderHelper.COURT_CARDS;
         if (this.cardDeckSetting.isSelected("Jokers Wild")) return CardRenderHelper.JOKERS;
         if (this.cardDeckSetting.isSelected("Classic Poker")) return CardRenderHelper.ALL_CARDS;
         if (this.cardDeckSetting.i_method_f85f3850() != null) {
            return CardRenderHelper.getDeckCards(this.cardDeckSetting.i_method_f85f3850().getName());
         }
      }
      return CardRenderHelper.ALL_CARDS;
   }

   private Identifier getActiveBack() {
      if (this.cardBackSetting != null) {
         if (this.cardBackSetting.isSelected("Uno Classic")) return CardRenderHelper.CARD_BACK_UNO;
         if (this.cardBackSetting.isSelected("Classic Mesh (Blue)")) return CardRenderHelper.CARD_BACK_MESH_BLUE;
         if (this.cardBackSetting.isSelected("Classic Mesh (Red)")) return CardRenderHelper.CARD_BACK_MESH;
         if (this.cardBackSetting.isSelected("Bicycle Classic")) return CardRenderHelper.CARD_BACK_BICYCLE;
         if (this.cardBackSetting.isSelected("Royal Gold")) return CardRenderHelper.CARD_BACK_ROYAL;
         if (this.cardBackSetting.isSelected("Cyber Neon")) return CardRenderHelper.CARD_BACK_CYBER;
         if (this.cardBackSetting.isSelected("Dark Arcane")) return CardRenderHelper.CARD_BACK_ARCANE;
         if (this.cardBackSetting.i_method_f85f3850() != null) {
            return CardRenderHelper.getDeckBack(this.cardBackSetting.i_method_f85f3850().getName());
         }
      }
      return CardRenderHelper.CARD_BACK_MESH;
   }

   public TargetEspModule() {
      this.IiI_method_a798725f();
      this.I_field_83b89a01.I_method_e3461a4c();
   }

   private void I_method_469aa82c(MatrixStack var1, LivingEntity var2) {
      if (this.modeCardsSequential != null && this.modeCardsSequential.isSelected()) {
         this.renderCardsSequential(var1, var2);
      } else if (this.modeCardsTriple != null && this.modeCardsTriple.isSelected()) {
         this.renderCardsTriple(var1, var2);
      } else if (this.modeCardsTrio != null && this.modeCardsTrio.isSelected()) {
         this.renderCardsTrio(var1, var2);
      } else if (this.I_field_500d0627 != null && this.I_field_500d0627.isSelected()) {
         this.iI_method_f071a629(var1, var2); // Souls
      } else if (this.i_field_500d0627 != null && this.i_field_500d0627.isSelected()) {
         this.Ii_method_e0011269(var1, var2); // Crystals
      } else if (this.II_field_500d0627 != null && this.II_field_500d0627.isSelected()) {
         this.II_method_f085da49(var1, var2); // Circle
      } else {
         this.renderJelloEsp(var1, var2); // Jello
      }
   }

   // 1. Original Jello
   private void renderJelloEsp(MatrixStack var1, LivingEntity var2) {
      Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
      ColorRGBA var4 = this.II_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
      Identifier var5 = RockstarClient.id("textures/bloom.png");
      float var6 = this.I_field_966247a3.getWidth() * 1.45F;
      var1.push();
      iIiiiIIiI_Class371.I_method_7d461059(var1, this.I_method_acb0d958(this.I_field_966247a3));
      RenderSystem.setShaderTexture(0, var5);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      float var8 = 0.0F;
      float var9 = this.I_field_dc7facc.I_method_6ac4da6f();

      for (int var10 = 0; var10 < 360; var10 += 2) {
         float var11 = Math.max(0.5F, 0.7F - 0.2F * var8 + 0.2F - 0.2F * var9);
         double var12 = (var10 + this.i_field_dc7facc.I_method_6ac4da6f()) * (float) (Math.PI / 180.0);
         float var14 = (float)(iIIiiiiiI_Class319.I_method_a586e9cd(var12) * var6 * var11);
         float var15 = (float)(iIIiiiiiI_Class319.i_method_a749d9ed(var12) * var6 * var11);
         float var16 = var2.getHeight() / 1.75F
            + (float)(var2.getHeight() / 2.0F * iIIiiiiiI_Class319.I_method_a586e9cd(Math.toRadians(this.i_field_dc7facc.I_method_6ac4da6f() / 1.5F + 30.0F)));
         float var17 = 0.2F;
         float var18 = 0.8F;
         float var19 = 0.2F;

         for (int var20 = 0; var20 < 15; var20++) {
            var16 = var2.getHeight() / 1.75F
               + (float)(var2.getHeight() / 2.0F * iIIiiiiiI_Class319.I_method_a586e9cd(Math.toRadians(this.i_field_dc7facc.I_method_6ac4da6f() / 1.5F + var20 * 2.0F)));
            var1.push();
            var1.translate(var14, var16, var15);
            var1.multiply(var3.getRotation());
            iIiiIIiii_Class360.I_method_a9f124df(
               var1,
               var7,
               -var19 / 2.0F,
               -var19 / 2.0F,
               -var17 / 2.0F,
               var19,
               var19,
               var4.withAlpha(var4.getAlpha() * var9 * (var20 / 15.0F) * 0.05F * this.Ii_field_46)
            );
            var1.pop();
         }
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var7);
      var1.pop();
      var1.push();
      iIiiiIIiI_Class371.I_method_7d461059(var1, this.I_method_acb0d958(this.I_field_966247a3));
      RenderSystem.setShaderTexture(0, RockstarClient.id("textures/glowing.png"));
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

      for (int var22 = 0; var22 < 360; var22 += 2) {
         float var23 = Math.max(0.5F, 0.7F - 0.2F * var8 + 0.2F - 0.2F * var9);
         double var24 = (var22 + this.i_field_dc7facc.I_method_6ac4da6f()) * (float) (Math.PI / 180.0);
         float var25 = (float)(iIIiiiiiI_Class319.I_method_a586e9cd(var24) * var6 * var23);
         float var26 = (float)(iIIiiiiiI_Class319.i_method_a749d9ed(var24) * var6 * var23);
         float var28 = var2.getHeight() / 1.75F
            + (float)(var2.getHeight() / 2.0F * iIIiiiiiI_Class319.I_method_a586e9cd(Math.toRadians(this.i_field_dc7facc.I_method_6ac4da6f() / 1.5F + 30.0F)));
         float var29 = 0.2F;
         float var30 = 0.2F;
         float var31 = 0.2F;
         var1.push();
         var1.translate(var25, var28, var26);
         var1.multiply(var3.getRotation());
         iIiiIIiii_Class360.I_method_a9f124df(
            var1, var7, -var30 / 2.0F, -var30 / 2.0F, -var29 / 2.0F, var30, var30, var4.withAlpha(var4.getAlpha() * var9 * 0.2F * this.Ii_field_46)
         );
         var1.pop();
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var7);
      var1.pop();
   }

   // 2. Original Circle
   private void II_method_f085da49(MatrixStack var1, LivingEntity var2) {
      Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
      ColorRGBA var4 = this.II_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
      Identifier var5 = RockstarClient.id("textures/glowing.png");
      float var6 = this.I_field_966247a3.getWidth() * 1.5F;
      iIiiiIIiI_Class371.I_method_7d461059(var1, this.I_method_acb0d958(this.I_field_966247a3));
      RenderSystem.setShaderTexture(0, var5);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      float var8 = this.II_field_dc7facc.I_method_6ac4da6f();
      float var9 = this.I_field_dc7facc.I_method_6ac4da6f();

      for (int var10 = 0; var10 < 360; var10 += 2) {
         if (var10 / 45 % 2 != 0) {
            float var11 = Math.max(0.5F, 0.7F - 0.2F * var8 + 0.2F - 0.2F * var9);
            double var12 = (var10 + this.i_field_dc7facc.I_method_6ac4da6f()) * (float) (Math.PI / 180.0);
            float var14 = (float)(iIIiiiiiI_Class319.I_method_a586e9cd(var12) * var6 * var11);
            float var15 = (float)(iIIiiiiiI_Class319.i_method_a749d9ed(var12) * var6 * var11);
            float var16 = var2.getHeight() / 1.75F
               + (float)(var2.getHeight() / 2.0F * iIIiiiiiI_Class319.I_method_a586e9cd(Math.toRadians(this.i_field_dc7facc.I_method_6ac4da6f() / 2.0F)));
            float var17 = 0.3F;
            float var18 = 0.8F;
            var1.push();
            var1.translate(var14, var16, var15);
            var1.multiply(var3.getRotation());
            iIiiIIiii_Class360.I_method_a9f124df(
               var1, var7, -var18 / 2.0F, -var18 / 2.0F, -var17 / 2.0F, var18, var18, var4.withAlpha(var4.getAlpha() * var9 * 0.03F * this.Ii_field_46)
            );
            iIiiIIiii_Class360.I_method_a9f124df(
               var1, var7, -var17 / 2.0F, -var17 / 2.0F, -var17 / 2.0F, var17, var17, var4.withAlpha(var4.getAlpha() * var9 * 0.7F * this.Ii_field_46)
            );
            var1.pop();
         }
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var7);
   }

   // 3. Original Crystals
   private void Ii_method_e0011269(MatrixStack var1, LivingEntity var2) {
      Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
      Vec3d var4 = var3.getPos();
      ColorRGBA var5 = this.II_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
      float var6 = this.I_field_966247a3.getWidth() * 1.5F;
      iIiiiIIiI_Class371.I_method_7d461059(var1, this.I_method_acb0d958(this.I_field_966247a3));
      BufferBuilder var7 = iIiiIIIii_Class356.I_method_c596047e();

      for (int var8 = 0; var8 < 360; var8 += 20) {
         float var9 = 1.2F - 0.5F * this.I_field_dc7facc.I_method_6ac4da6f();
         float var10 = (float)(
            iIIiiiiiI_Class319.I_method_a586e9cd((float)Math.toRadians(var8 + this.i_field_dc7facc.I_method_6ac4da6f() * 0.3F)) * var6 * var9
         );
         float var11 = (float)(
            iIIiiiiiI_Class319.i_method_a749d9ed((float)Math.toRadians(var8 + this.i_field_dc7facc.I_method_6ac4da6f() * 0.3F)) * var6 * var9
         );
         float var12 = 0.1F;
         var1.push();
         var1.translate(var10, 0.1F + var2.getHeight() * Math.abs(iIIiiiiiI_Class319.I_method_a586e9cd(var8)), var11);
         Vec3d var13 = this.I_method_acb0d958(this.I_field_966247a3).add(var10, 1.0, var11);
         Vec3d var14 = var2.getPos().add(0.0, var2.getHeight() / 2.0, 0.0);
         Vector3f var15 = new Vector3f((float)(var14.x - var13.x), (float)(var14.y - var13.y), (float)(var14.z - var13.z)).normalize();
         Vector3f var16 = new Vector3f(0.0F, 1.0F, 0.0F);
         Quaternionf var17 = new Quaternionf().rotationTo(var16, var15);
         var1.multiply(var17);
         iIiiIIIii_Class356.I_method_8d941781(
            var1, var7, 0.0F, 0.0F, 0.0F, var12, var5.withAlpha(255.0F * this.I_field_dc7facc.I_method_6ac4da6f() * this.Ii_field_46)
         );
         var1.pop();
      }

      BufferRenderer.drawWithGlobalProgram(var7.end());
      Identifier var18 = RockstarClient.id("textures/bloom.png");
      RenderSystem.setShaderTexture(0, var18);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var19 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      float var20 = 1.0F;

      for (int var21 = 0; var21 < 360; var21 += 20) {
         float var22 = 1.2F - 0.5F * this.I_field_dc7facc.I_method_6ac4da6f();
         float var23 = (float)(
            iIIiiiiiI_Class319.I_method_a586e9cd((float)Math.toRadians(var21 + this.i_field_dc7facc.I_method_6ac4da6f() * 0.3F)) * var6 * var22
         );
         float var24 = (float)(
            iIIiiiiiI_Class319.i_method_a749d9ed((float)Math.toRadians(var21 + this.i_field_dc7facc.I_method_6ac4da6f() * 0.3F)) * var6 * var22
         );
         float var25 = 0.1F;
         var1.push();
         var1.translate(var23, 0.1F + var2.getHeight() * Math.abs(iIIiiiiiI_Class319.I_method_a586e9cd(var21)), var24);
         var1.multiply(var3.getRotation());
         iIiiIIiii_Class360.I_method_a9f124df(
            var1,
            var19,
            -var20 / 2.0F,
            -var20 / 2.0F,
            0.0,
            var20,
            var20,
            var5.withAlpha(255.0F * this.I_field_dc7facc.I_method_6ac4da6f() * 0.2F * this.Ii_field_46)
         );
         var1.pop();
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var19);
   }

   // 4. Original Souls
   private void iI_method_f071a629(MatrixStack var1, LivingEntity var2) {
      Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
      ColorRGBA var4 = this.II_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
      Identifier var5 = RockstarClient.id("textures/glowing.png");
      float var6 = this.I_field_966247a3.getWidth() * 1.5F;
      RenderSystem.setShaderTexture(0, var5);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      iIiiiIIiI_Class371.I_method_7d461059(var1, this.I_method_acb0d958(this.I_field_966247a3));
      byte var8 = 2;
      byte var9 = 0;
      byte var10 = 0;
      int var11 = 0;

      for (int var12 = 0; var12 < 360; var12 += var8) {
         float var13 = 0.23F + 0.005F * var9;
         float var14 = 0.7F + 0.005F * var9;
         if (var10 > 0) {
            var10 -= var8;
         } else {
            var9 += var8;
            if (var9 > 50) {
               var10 = 100;
               var9 = 0;
               var11++;
            } else {
               float var15 = Math.max(0.5F, 1.2F - 0.5F * this.I_field_dc7facc.I_method_6ac4da6f());
               float var16 = (float)(
                  iIIiiiiiI_Class319.I_method_a586e9cd((float)Math.toRadians(var12 + this.i_field_dc7facc.I_method_6ac4da6f() * 1.0F)) * var6 * var15
               );
               float var17 = (float)(
                  iIIiiiiiI_Class319.i_method_a749d9ed((float)Math.toRadians(var12 + this.i_field_dc7facc.I_method_6ac4da6f() * 1.0F)) * var6 * var15
               );
               var1.push();
               var1.translate(
                  var16,
                  this.I_field_966247a3.getHeight() / 1.5F
                     + this.I_field_966247a3.getHeight() / 3.0F
                     * iIIiiiiiI_Class319.I_method_a586e9cd(Math.toRadians(var12 / 2.0F + this.i_field_dc7facc.I_method_6ac4da6f() / 5.0F)),
                  var17
               );
               var1.multiply(var3.getRotation());
               iIiiIIiii_Class360.I_method_a9f124df(
                  var1,
                  var7,
                  -var14 / 2.0F,
                  -var14 / 2.0F,
                  -var13 / 2.0F,
                  var14,
                  var14,
                  var4.withAlpha(var4.getAlpha() * this.I_field_dc7facc.I_method_6ac4da6f() * 0.02F * this.Ii_field_46)
               );
               iIiiIIiii_Class360.I_method_a9f124df(
                  var1,
                  var7,
                  -var13 / 2.0F,
                  -var13 / 2.0F,
                  -var13 / 2.0F,
                  var13,
                  var13,
                  var4.withAlpha(var4.getAlpha() * this.I_field_dc7facc.I_method_6ac4da6f() * 0.5F * this.Ii_field_46)
               );
               var1.pop();
            }
         }
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var7);
   }

   // 5. Classic Marker (crosshair / target reticle picture facing camera)
   private void renderMarkerEsp(MatrixStack var1, LivingEntity var2) {
      Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
      ColorRGBA var4 = this.II_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
      Identifier var5 = RockstarClient.id("textures/target_marker.png");
      float anim = this.i_field_dc7facc.I_method_6ac4da6f();
      float alphaFade = this.I_field_dc7facc.I_method_6ac4da6f();
      float height = var2.getHeight() * 0.55F;
      float pulse = 1.0F + 0.08F * (float) Math.sin(Math.toRadians(anim * 3.0F));
      float size = Math.max(0.7F, var2.getWidth() * 1.5F) * pulse;

      var1.push();
      iIiiiIIiI_Class371.I_method_7d461059(var1, this.I_method_acb0d958(this.I_field_966247a3));
      var1.translate(0.0, height, 0.0);
      var1.multiply(var3.getRotation());
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)(anim * 0.8F)));

      RenderSystem.setShaderTexture(0, var5);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      iIiiIIiii_Class360.I_method_a9f124df(
         var1, var7, -size / 2.0F, -size / 2.0F, 0.0, size, size,
         var4.withAlpha(var4.getAlpha() * alphaFade * this.Ii_field_46)
      );
      iIiiiIIiI_Class371.I_method_c59155f0(var7);
      var1.pop();
   }

   // Trails / Lighting
   private void i_method_ca75e9ff(Render3DEvent var1) {
      if (this.Ii_field_ba20ca4c.i_method_9b12da03()) {
         if (iIiiIIiii_Class360.I_field_65f6a54c != null) {
            float var2 = 1.0F * this.I_field_dc7facc.I_method_6ac4da6f();
            if (!(var2 <= 0.001F)) {
               List var3 = this.I_method_74a20029(this.I_field_966247a3);
               if (!var3.isEmpty()) {
                  ColorRGBA var4 = this.II_field_ba20ca4c.i_method_9b12da03()
                     ? IiiiiIIIi_Class242.i_method_5dfec6e()
                     : this.I_field_bbd4b66c.I_method_bde5f08e();
                  float var5 = var4.getRed() / 255.0F;
                  float var6 = var4.getGreen() / 255.0F;
                  float var7 = var4.getBlue() / 255.0F;
                  float var8 = var2 / var3.size();
                  Vec3d var9 = var1.getCamera().getPos();
                  Vec3d var10 = this.I_method_acb0d958(this.I_field_966247a3);
                  ArrayList var11 = new ArrayList(var3.size());

                  for (Vec3d var13 : (Iterable<Vec3d>)(Iterable<?>)var3) {
                     var11.add(
                        new iiiii_Class32.Nested1_88680fa0(
                           (float)(var10.x + var13.x - var9.x),
                           (float)(var10.y + var13.y - var9.y),
                           (float)(var10.z + var13.z - var9.z),
                           3.5F,
                           var5,
                           var6,
                           var7,
                           var8
                        )
                     );
                  }

                  Matrix4f var14 = new Matrix4f(var1.getProjectionMatrix()).mul(var1.getPositionMatrix()).invert();
                  iIiiIIiii_Class360.I_field_65f6a54c.I_method_6b5b11c2(var14, 1.0F, var11);
               }
            }
         }
      }
   }

   private List<Vec3d> I_method_74a20029(LivingEntity var1) {
      float var2 = this.I_field_dc7facc.I_method_6ac4da6f();
      float var3 = this.i_field_dc7facc.I_method_6ac4da6f();
      double var4 = Math.max(0.1, (double)var1.getHeight());
      ArrayList var6 = new ArrayList(6);
      if (this.i_field_500d0627 != null && this.i_field_500d0627.isSelected()) {
         double var21 = var1.getWidth() * 1.5 * (1.2 - 0.5 * var2);

         for (int var22 = 0; var22 < 360; var22 += 60) {
            double var24 = Math.toRadians(var22 + var3 * 0.3);
            var6.add(
               new Vec3d(
                  iIIiiiiiI_Class319.I_method_a586e9cd(var24) * var21,
                  0.1 + var4 * Math.abs(iIIiiiiiI_Class319.I_method_a586e9cd(var22)),
                  iIIiiiiiI_Class319.i_method_a749d9ed(var24) * var21
               )
            );
         }

         return var6;
      } else if (this.I_field_500d0627 != null && this.I_field_500d0627.isSelected()) {
         double var20 = var1.getWidth() * 1.5 * Math.max(0.5, 1.2 - 0.5 * var2);

         for (int var9 = 0; var9 < 360; var9 += 60) {
            double var23 = Math.toRadians(var9 + var3);
            var6.add(
               new Vec3d(
                  iIIiiiiiI_Class319.I_method_a586e9cd(var23) * var20,
                  var4 / 1.5 + var4 / 3.0 * iIIiiiiiI_Class319.I_method_a586e9cd(Math.toRadians(var9 / 2.0 + var3 / 5.0)),
                  iIIiiiiiI_Class319.i_method_a749d9ed(var23) * var20
               )
            );
         }

         return var6;
      } else {
         boolean var7 = this.Ii_field_500d0627 != null && this.Ii_field_500d0627.isSelected();
         double var8 = var7 ? 0.0 : this.II_field_dc7facc.I_method_6ac4da6f();
         double var10 = var1.getWidth() * (var7 ? 1.45 : 1.5) * Math.max(0.5, 0.7 - 0.2 * var8 + 0.2 - 0.2 * var2);
         double var12 = var7 ? var3 / 1.5 + 30.0 : var3 / 2.0;
         double var14 = var4 / 1.75 + var4 / 2.0 * iIIiiiiiI_Class319.I_method_a586e9cd(Math.toRadians(var12));
         int var16 = var7 ? 30 : 15;

         for (int var17 = 0; var17 < 360; var17 += var16) {
            if (var7 || var17 / 45 % 2 != 0) {
               double var18 = Math.toRadians(var17 + var3);
               var6.add(new Vec3d(iIIiiiiiI_Class319.I_method_a586e9cd(var18) * var10, var14, iIIiiiiiI_Class319.i_method_a749d9ed(var18) * var10));
            }
         }

         return var6;
      }
   }

   private Vec3d I_method_acb0d958(LivingEntity var1) {
      float var2 = MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false);
      return new Vec3d(
         MathHelper.lerp(var2, var1.prevX, var1.getX()), MathHelper.lerp(var2, var1.prevY, var1.getY()), MathHelper.lerp(var2, var1.prevZ, var1.getZ())
      );
   }

   // =========================================================================
   // CARD TARGET ESP: SEQUENTIAL, TRIPLE TIER, AND TRIO WAVE
   // =========================================================================

   private void renderCardsSequential(MatrixStack m, LivingEntity target) {
      Camera cam = I_field_3a9bda27.gameRenderer.getCamera();
      Vec3d targetPos = this.I_method_acb0d958(target);
      float speed = this.cardSpeedSetting != null ? this.cardSpeedSetting.Ii_method_a20abcd2() : 1.5F;
      float cardScale = this.cardScaleSetting != null ? this.cardScaleSetting.Ii_method_a20abcd2() : 1.0F;
      long now = System.currentTimeMillis();
      float time = (now % 1000000L) * 0.002F * speed;

      float radius = target.getWidth() * 1.55F + 0.35F;
      int cardCount = this.cardCountSetting != null ? Math.max(2, (int)this.cardCountSetting.Ii_method_a20abcd2()) : 5;
      Identifier[] deck = getActiveDeck();
      Identifier back = getActiveBack();

      m.push();
      iIiiiIIiI_Class371.I_method_7d461059(m, targetPos);

      for (int i = 0; i < cardCount; i++) {
         double angle = time + (i * 2.0 * Math.PI / cardCount);
         float cx = (float)(Math.cos(angle) * radius);
         float cz = (float)(Math.sin(angle) * radius);
         float cy = target.getHeight() * 0.50F + (float)Math.sin(time * 2.5 + i) * 0.12F;

         m.push();
         m.translate(cx, cy, cz);
         float cardYaw = (float)Math.toDegrees(-angle) + 90.0F;
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(cardYaw));
         m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.sin(time * 3.0 + i) * 10.0F));

         CardRenderHelper.renderCard(m, 0.44F * cardScale, 0.62F * cardScale, deck[i % deck.length], back, 1.0F, true);
         m.pop();
      }
      m.pop();
   }

   private void renderCardsTriple(MatrixStack m, LivingEntity target) {
      Vec3d targetPos = this.I_method_acb0d958(target);
      float speed = this.cardSpeedSetting != null ? this.cardSpeedSetting.Ii_method_a20abcd2() : 1.5F;
      float cardScale = this.cardScaleSetting != null ? this.cardScaleSetting.Ii_method_a20abcd2() : 1.0F;
      long now = System.currentTimeMillis();
      float time = (now % 1000000L) * 0.002F * speed;

      float radius = target.getWidth() * 1.45F + 0.30F;

      m.push();
      iIiiiIIiI_Class371.I_method_7d461059(m, targetPos);

      // 3 Tiers of Cards: Top (+H*0.8), Mid (+H*0.5, opposite dir), Bot (+H*0.2)
      float[] tierHeights = new float[]{target.getHeight() * 0.82F, target.getHeight() * 0.50F, target.getHeight() * 0.18F};
      float[] tierDir = new float[]{1.0F, -1.0F, 1.0F};
      int cardsPerTier = this.cardCountSetting != null ? Math.max(2, (int)this.cardCountSetting.Ii_method_a20abcd2()) : 4;
      Identifier[] deck = getActiveDeck();
      Identifier back = getActiveBack();

      for (int tier = 0; tier < 3; tier++) {
         float curY = tierHeights[tier];
         float dir = tierDir[tier];

         for (int i = 0; i < cardsPerTier; i++) {
            double angle = (time * dir) + (i * 2.0 * Math.PI / cardsPerTier);
            float cx = (float)(Math.cos(angle) * radius);
            float cz = (float)(Math.sin(angle) * radius);

            m.push();
            m.translate(cx, curY, cz);
            float cardYaw = (float)Math.toDegrees(-angle) + 90.0F;
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(cardYaw));

            CardRenderHelper.renderCard(m, 0.38F * cardScale, 0.54F * cardScale, deck[(tier * 4 + i) % deck.length], back, 1.0F, true);
            m.pop();
         }
      }
      m.pop();
   }

   private void renderCardsTrio(MatrixStack m, LivingEntity target) {
      Vec3d targetPos = this.I_method_acb0d958(target);
      float speed = this.cardSpeedSetting != null ? this.cardSpeedSetting.Ii_method_a20abcd2() : 1.5F;
      float cardScale = this.cardScaleSetting != null ? this.cardScaleSetting.Ii_method_a20abcd2() : 1.0F;
      long now = System.currentTimeMillis();
      float time = (now % 1000000L) * 0.0024F * speed;

      float radius = target.getWidth() * 1.5F + 0.35F;
      int cardCount = this.cardCountSetting != null ? Math.max(2, (int)this.cardCountSetting.Ii_method_a20abcd2()) : 3;
      Identifier[] deck = getActiveDeck();
      Identifier back = getActiveBack();

      m.push();
      iIiiiIIiI_Class371.I_method_7d461059(m, targetPos);

      for (int i = 0; i < cardCount; i++) {
         double angle = time + (i * 2.0 * Math.PI / cardCount);
         float cx = (float)(Math.cos(angle) * radius);
         float cz = (float)(Math.sin(angle) * radius);
         // Smooth continuous vertical roller-coaster wave
         float cy = target.getHeight() * 0.50F + (float)Math.sin(angle * 2.0) * (target.getHeight() * 0.40F);

         m.push();
         m.translate(cx, cy, cz);
         float cardYaw = (float)Math.toDegrees(-angle) + 90.0F;
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(cardYaw));
         m.multiply(RotationAxis.POSITIVE_X.rotationDegrees((float)Math.cos(angle * 2.0) * 22.0F));

         CardRenderHelper.renderCard(m, 0.46F * cardScale, 0.65F * cardScale, deck[i % deck.length], back, 1.0F, true);
         m.pop();
      }
      m.pop();
   }

   private static void draw3DCard(BufferBuilder buf, Matrix4f mat, float w, float h, int suit) {
      float hw = w * 0.5F;
      float hh = h * 0.5F;
      int cardWhite = 0xFFFFFFFF;
      int cardBorder = 0xFF222222;
      int suitColor = (suit == 0 || suit == 3) ? 0xFF181818 : 0xFFDC143C; // Spades/Clubs = black, Hearts/Diamonds = crimson

      // Front Face
      buf.vertex(mat, -hw, -hh, 0.0F).color(cardWhite);
      buf.vertex(mat, hw, -hh, 0.0F).color(cardWhite);
      buf.vertex(mat, hw, hh, 0.0F).color(cardWhite);
      buf.vertex(mat, -hw, hh, 0.0F).color(cardWhite);

      // Card Border
      float bw = 0.015F;
      buf.vertex(mat, -hw, -hh, 0.001F).color(cardBorder);
      buf.vertex(mat, hw, -hh, 0.001F).color(cardBorder);
      buf.vertex(mat, hw, -hh + bw, 0.001F).color(cardBorder);
      buf.vertex(mat, -hw, -hh + bw, 0.001F).color(cardBorder);

      buf.vertex(mat, -hw, hh - bw, 0.001F).color(cardBorder);
      buf.vertex(mat, hw, hh - bw, 0.001F).color(cardBorder);
      buf.vertex(mat, hw, hh, 0.001F).color(cardBorder);
      buf.vertex(mat, -hw, hh, 0.001F).color(cardBorder);

      // Center Suit Diamond/Symbol
      float sw = hw * 0.45F;
      float sh = hh * 0.45F;
      buf.vertex(mat, 0.0F, sh, 0.002F).color(suitColor);
      buf.vertex(mat, sw, 0.0F, 0.002F).color(suitColor);
      buf.vertex(mat, 0.0F, -sh, 0.002F).color(suitColor);
      buf.vertex(mat, -sw, 0.0F, 0.002F).color(suitColor);

      // Back Face
      int backColor = 0xFF8B0000;
      int backGold = 0xFFFFD700;
      buf.vertex(mat, -hw, -hh, -0.001F).color(backColor);
      buf.vertex(mat, hw, -hh, -0.001F).color(backColor);
      buf.vertex(mat, hw, hh, -0.001F).color(backColor);
      buf.vertex(mat, -hw, hh, -0.001F).color(backColor);

      buf.vertex(mat, 0.0F, hh * 0.65F, -0.002F).color(backGold);
      buf.vertex(mat, hw * 0.65F, 0.0F, -0.002F).color(backGold);
      buf.vertex(mat, 0.0F, -hh * 0.65F, -0.002F).color(backGold);
      buf.vertex(mat, -hw * 0.65F, 0.0F, -0.002F).color(backGold);
   }

   @Override
   public void II_method_6642fd22() {
      super.II_method_6642fd22();
   }
}
