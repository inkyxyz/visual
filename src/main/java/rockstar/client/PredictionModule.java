package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SnowballItem;
import net.minecraft.item.TridentItem;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.lwjgl.opengl.GL30;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Prediction",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = true
)
public class PredictionModule extends Module {
   private final List<PredictionModule.Nested1_b0735fa9> I_field_7865b31 = new ArrayList<>();
   private final List<PredictionModule.Nested1_df334c0> i_field_7865b31 = new ArrayList<>();
   private final List<PredictionModule.Nested1_df334a0> II_field_7865b31 = new ArrayList<>();
   private MultiSelectSetting I_field_bbe3ba6c;
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private BooleanSetting Ii_field_ba20ca4c;
   private BooleanSetting iI_field_ba20ca4c;
   private BooleanSetting ii_field_ba20ca4c;
   private ColorSetting I_field_bbd4b66c;
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private Vec3d I_field_5bba0d50;
   private static final int I_field_49 = 4;
   private int i_field_49 = -1;
   private final IiIIIiII_Class69<SendPacketEvent> I_field_3d936f41 = var1 -> {
      if (var1.getPacket() instanceof PlayerInteractItemC2SPacket var2) {
         if (I_field_3a9bda27.player != null && this.I_field_32e13e6c != null) {
            ItemStack var9 = I_field_3a9bda27.player.getMainHandStack();
            if (this.I_method_788fa28b(var9.getItem())) {
               iiIIiIiII_Class405 var4 = RockstarClient.getInstance().I_method_58785402();
               if (var4 != null && !var4.I_method_3d166e03()) {
                  iiIIiIIii_Class404 var5 = var4.i_method_10b2eeb5();
                  float var6 = Math.abs(iiIIiIiIi_Class406.II_method_95f3d8d2(var5.I_method_14534e0f(), this.I_field_32e13e6c.I_method_14534e0f()));
                  float var7 = Math.abs(var5.i_method_1461d9ef() - this.I_field_32e13e6c.i_method_1461d9ef());
                  float var8 = 35.0F;
                  if (!(var6 > var8) && !(var7 > var8)) {
                     if (this.Ii_field_ba20ca4c.i_method_9b12da03() && !this.iI_field_ba20ca4c.i_method_9b12da03()) {
                        var4.I_method_1acbf705(
                           this.I_field_32e13e6c, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.iI_field_32efc66c
                        );
                     }
                  }
               }
            }
         }
      }
   };
   private final IiIIIiII_Class69<PreHudRenderEvent> i_field_3d936f41 = var1 -> {
      CustomDrawContext var2 = var1.getContext();
      MatrixStack var3 = var2.getMatrices();

      for (PredictionModule.Nested1_b0735fa9 var5 : this.I_field_7865b31) {
         if (var5.I_field_49 > 0 || var5.i_field_77e0818c != null) {
            Vec2f var6 = iIiiiiIII_Class377.I_method_211fc242(var5.I_field_7865b31.getLast());
            if (var6 != null) {
               float var7 = var6.x;
               float var8 = var6.y;
               IIiIIi_Class10 var9 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
               float var10 = var9.I_method_a649725c() + 6.0F;
               float var11 = -var10;
               String var12 = this.I_method_8b4f06f9(var5.I_field_77e0818c);
               var12 = this.I_method_8276dda6(var12.replace("] ", "").replace("[", ""), var5.I_field_49);

               ItemStack var13 = switch (var5.I_field_77e0818c) {
                  case ThrownItemEntity var16 -> var16.getStack();
                  case PersistentProjectileEntity var17 -> var17.getItemStack();
                  case ItemEntity var18 -> var18.getStack();
                  default -> Items.ARROW.getDefaultStack();
               };
               float var56 = (float)var5.I_field_7865b31.getLast().distanceTo(I_field_3a9bda27.player.getEyePos());
               float var58 = MathHelper.clamp(1.0F - var56 / 20.0F, 0.5F, 1.0F);
               var3.push();
               var3.translate(var7, var8, 0.0F);
               var3.scale(var58, var58, 1.0F);
               float var60 = var9.I_method_2c375926(var12) + 20.0F;
               var2.drawRect(-var60 / 2.0F, var11, var60, var10, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
               var2.drawItem(var13, -var60 / 2.0F, var11, 1.0F);
               var2.drawText(var9, var12, -var60 / 2.0F + 17.0F, var11 + 3.0F, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
               var11 += var10;
               if (var5.I_field_77e0818c instanceof ProjectileEntity var62 && var62.getOwner() instanceof AbstractClientPlayerEntity var65) {
                  String var70 = IiIiIIII_Class81.I_method_f25a980a("modules.prediction.from")
                     + " "
                     + (
                        var62.getOwner() == I_field_3a9bda27.player
                           ? IiIiIIII_Class81.I_method_f25a980a("modules.prediction.you")
                           : var62.getOwner().getName().getString()
                     );
                  float var20 = var9.I_method_2c375926(var70) + 22.0F;
                  var2.drawRect(-var20 / 2.0F, var11, var20, var10, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
                  var2.drawHead(var65, -var20 / 2.0F, var11, var10, IIiii_Class8.I_field_2d98a52c, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
                  var2.drawText(var9, var70, -var20 / 2.0F + 19.0F, var11 + 3.0F, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
                  var11 += var10;
               }

               if (var5.I_field_77e0818c instanceof PotionEntity var63) {
                  for (StatusEffectInstance var71 : iIIIIIiII_Class261.I_method_2d41c106(var63.getStack())) {
                     String var73 = ((StatusEffect)var71.getEffectType().value()).getName().getString();
                     int var21 = var71.getAmplifier();
                     int var22 = var71.getDuration();
                     String var23 = var21 > 0 ? " " + (var21 + 1) : "";
                     String var24 = this.I_method_a2ebfc1c(var22);
                     String var25 = var73 + var23 + " (" + var24 + ")";
                     float var26 = var9.I_method_2c375926(var25) + 6.0F;
                     var2.drawRect(-var26 / 2.0F, var11 + 5.0F, var26, var10, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
                     var2.drawText(
                        var9,
                        var25,
                        -var26 / 2.0F + 3.0F,
                        var11 + 8.0F,
                        ColorRGBA.fromInt(((StatusEffect)var71.getEffectType().value()).getColor()).withAlpha(255.0F)
                     );
                     var11 += var10;
                  }
               }

               var3.pop();
            }
         }
      }

      if (this.Ii_field_ba20ca4c.i_method_9b12da03()
         && this.I_field_5bba0d50 != null
         && this.I_method_788fa28b(I_field_3a9bda27.player.getMainHandStack().getItem())) {
         Vec3d var27 = I_field_3a9bda27.player.getCameraPosVec(var1.getTickDelta());
         iiIIiIIii_Class404 var30 = this.I_method_827842dd(var27, this.I_field_5bba0d50, I_field_3a9bda27.player.getMainHandStack().getItem());
         Vec2f var33 = var30 == null
            ? null
            : iIiiiiIII_Class377.i_method_d90ec262(I_field_3a9bda27.player.getRotationVector(var30.i_method_1461d9ef(), var30.I_method_14534e0f()));
         if (var33 != null) {
            iiIIiIiII_Class405 var36 = RockstarClient.getInstance().I_method_58785402();
            iiIIiIIii_Class404 var39 = var36 != null
               ? var36.II_method_f098f858()
               : new iiIIiIIii_Class404(I_field_3a9bda27.player.getYaw(), I_field_3a9bda27.player.getPitch());
            float var42 = Math.abs(iiIIiIiIi_Class406.II_method_95f3d8d2(var39.I_method_14534e0f(), var30.I_method_14534e0f()));
            float var45 = Math.abs(var39.i_method_1461d9ef() - var30.i_method_1461d9ef());
            ColorRGBA var48 = (var42 < 10.0F && var45 < 10.0F ? IiiiiIIIi_Class242.i_field_d0c8ec5 : IiiiiIIIi_Class242.Ii_field_d0c8ec5).withAlpha(200.0F);
            var3.push();
            var3.translate(var33.x, var33.y, 0.0F);
            float var51 = (float)(System.currentTimeMillis() % 2000L) / 2000.0F * 360.0F;
            var3.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var51));
            float var54 = 14.0F;
            var2.drawRect(-var54 / 2.0F, -0.75F, var54, 1.5F, var48);
            var2.drawRect(-0.75F, -var54 / 2.0F, 1.5F, var54, var48);
            var3.pop();
         }
      }

      for (PredictionModule.Nested1_df334a0 var31 : this.II_field_7865b31) {
         Vec3d var34 = var31.I_method_924e9114();
         Vec2f var37 = iIiiiiIII_Class377.I_method_211fc242(var34);
         if (var37 != null) {
            float var40 = var37.x;
            float var43 = var37.y;
            IIiIIi_Class10 var46 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
            float var49 = var46.I_method_a649725c() + 6.0F;
            float var52 = -var49;
            String var55 = var31.I_method_6f4898c6();
            ItemStack var57 = var31.I_method_911d48de();
            float var59 = (float)var34.distanceTo(I_field_3a9bda27.player.getEyePos());
            float var61 = MathHelper.clamp(1.0F - var59 / 20.0F, 0.5F, 1.0F);
            var3.push();
            var3.translate(var40, var43, 0.0F);
            var3.scale(var61, var61, 1.0F);
            float var64 = var46.I_method_2c375926(var55) + 20.0F;
            var2.drawRect(-var64 / 2.0F, var52, var64, var49, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
            var2.drawItem(var57, -var64 / 2.0F, var52, 1.0F);
            var2.drawText(var46, var55, -var64 / 2.0F + 17.0F, var52 + 3.0F, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
            var52 += var49;

            for (StatusEffectInstance var72 : iIIIIIiII_Class261.I_method_2d41c106(var57)) {
               String var74 = ((StatusEffect)var72.getEffectType().value()).getName().getString();
               int var75 = var72.getAmplifier();
               int var76 = var72.getDuration();
               String var77 = var75 > 0 ? " " + (var75 + 1) : "";
               String var78 = this.I_method_a2ebfc1c(var76);
               String var79 = var74 + var77 + " (" + var78 + ")";
               float var80 = var46.I_method_2c375926(var79) + 6.0F;
               var2.drawRect(-var80 / 2.0F, var52 + 5.0F, var80, var49, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
               var2.drawText(
                  var46,
                  var79,
                  -var80 / 2.0F + 3.0F,
                  var52 + 8.0F,
                  ColorRGBA.fromInt(((StatusEffect)var72.getEffectType().value()).getColor()).withAlpha(255.0F)
               );
               var52 += var49;
            }

            var3.pop();
         }
      }

      if (this.II_field_ba20ca4c.i_method_9b12da03()) {
         IIiIIi_Class10 var29 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(10.0F);
         float var32 = 0.0F;

         for (PredictionModule.Nested1_b0735fa9 var38 : this.I_field_7865b31) {
            if (var38.i_field_77e0818c == I_field_3a9bda27.player && !(var38.I_field_77e0818c instanceof EnderPearlEntity)) {
               String var41 = this.I_method_8276dda6(this.I_method_8b4f06f9(var38.I_field_77e0818c), var38.I_field_49);
               String var44 = IiIiIIII_Class81.I_method_1410d1e5("modules.prediction.warning", var41);
               var2.drawCenteredText(
                  var29,
                  var44,
                  I_field_73c6d26c.I_method_804ee20f() / 2.0F,
                  I_field_73c6d26c.i_method_805d6def() / 2.0F + 20.0F + var32,
                  IiiiiIIIi_Class242.Ii_field_d0c8ec5
               );
               var32 += var29.I_method_a649725c() + 3.0F;
            }
         }
      }
   };
   private final IiIIIiII_Class69<Render3DEvent> II_field_3d936f41 = var1 -> {
      ColorRGBA var2 = this.ii_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
      this.I_method_d32b95c1(var1.getTickDelta());
      MatrixStack var3 = var1.getMatrices();
      var3.push();
      iIiiiIIiI_Class371.I_method_642c0895(true);
      iIiiiIIiI_Class371.i_method_49a476f1(var3);
      RenderSystem.enableDepthTest();
      if (this.i_field_ba20ca4c.i_method_9b12da03()) {
         RenderSystem.disableDepthTest();
      }

      if (this.I_field_500d0627.isSelected()) {
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder var4 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

         for (PredictionModule.Nested1_b0735fa9 var6 : this.I_field_7865b31) {
            Vec3d var7 = var6.I_field_7865b31.getFirst();
            iIiiIIiIi_Class358.I_method_d5d64e01(var3, var4, iIiiiiIII_Class377.I_method_689b1a13(var6.I_field_77e0818c, var1.getTickDelta()), var7, var2);

            for (Vec3d var9 : var6.I_field_7865b31) {
               iIiiIIiIi_Class358.I_method_d5d64e01(var3, var4, var7, var9, var2);
               var7 = var9;
            }
         }

         iIiiiIIiI_Class371.I_method_c59155f0(var4);
      } else {
         Identifier var15 = RockstarClient.id("textures/bloom.png");
         RenderSystem.setShaderTexture(0, var15);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         BufferBuilder var17 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

         for (PredictionModule.Nested1_b0735fa9 var21 : this.I_field_7865b31) {
            Vec3d var24 = var21.I_field_7865b31.getFirst();
            Vec3d var27 = iIiiiiIII_Class377.I_method_689b1a13(var21.I_field_77e0818c, var1.getTickDelta());
            if (var27.distanceTo(I_field_3a9bda27.player.getEyePos()) > 2.0) {
               for (int var10 = 0; var10 < 10; var10++) {
                  float var11 = var10 / 10.0F;
                  Vec3d var12 = var27.add(var24.subtract(var27).multiply(var11));
                  this.I_method_5d625b6(var3, var12, var17, (float)var24.distanceTo(var27) / 3.0F, 1.0F);
                  this.I_method_5d625b6(var3, var12, var17, (float)var24.distanceTo(var27) * 2.0F, 0.05F);
               }
            }

            for (Vec3d var33 : var21.I_field_7865b31) {
               if (var33.distanceTo(I_field_3a9bda27.player.getEyePos()) > 2.0) {
                  for (int var36 = 0; var36 < 10; var36++) {
                     float var13 = var36 / 10.0F;
                     Vec3d var14 = var24.add(var33.subtract(var24).multiply(var13));
                     this.I_method_5d625b6(var3, var14, var17, (float)var33.distanceTo(var24) / 3.0F, 1.0F);
                     this.I_method_5d625b6(var3, var14, var17, (float)var33.distanceTo(var24) * 2.0F, 0.05F);
                  }
               }

               var24 = var33;
            }

            float var30 = 9.0F;
            if (var21.I_field_77e0818c instanceof PotionEntity) {
               var3.push();
               var3.translate(var21.I_field_7865b31.getLast());
               var3.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(-90.0F));
               iIiiIIiii_Class360.I_method_a9f124df(var3, var17, -var30 / 2.0F, -var30 / 2.0F, 0.0, var30, var30, var2.withAlpha(255.0F));
               var3.pop();
            }
         }

         iIiiiIIiI_Class371.I_method_c59155f0(var17);
      }

      float var16 = 1.0F;
      Identifier var18 = RockstarClient.id("textures/hit.png");
      this.I_method_7859a60(var18);
      RenderSystem.setShaderTexture(0, var18);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var20 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

      for (PredictionModule.Nested1_df334c0 var25 : this.i_field_7865b31) {
         if (var25.i_field_77e0818c == null) {
            var3.push();
            var3.translate(var25.I_field_51edcc0f.getPos());
            var3.multiply(var25.I_field_51edcc0f.getSide().getRotationQuaternion());
            var3.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(-90.0F));
            iIiiIIiii_Class360.I_method_a9f124df(var3, var20, -var16 / 2.0F, -var16 / 2.0F, 0.0, var16, var16, var2.withAlpha(255.0F));
            var3.pop();
         }
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var20);
      RenderSystem.enableBlend();
      RenderSystem.disableDepthTest();
      RenderSystem.disableCull();
      RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
      Camera var23 = I_field_3a9bda27.gameRenderer.getCamera();
      Vec3d var26 = var23.getPos();
      BufferBuilder var28 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

      for (PredictionModule.Nested1_df334c0 var34 : this.i_field_7865b31) {
         if (var34.i_field_77e0818c != null) {
            Box var37 = var34.i_field_77e0818c.getBoundingBox().offset(-var26.getX(), -var26.getY(), -var26.getZ());
            var3.push();
            var3.translate(var26.getX(), var26.getY(), var26.getZ());
            iIiiIIiIi_Class358.i_method_5e35f7b9(var3, var28, var37, var2.mulAlpha(0.5F));
            var3.pop();
         }
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var28);
      BufferBuilder var32 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

      for (PredictionModule.Nested1_df334c0 var38 : this.i_field_7865b31) {
         if (var38.i_field_77e0818c != null) {
            Box var39 = var38.i_field_77e0818c.getBoundingBox().offset(-var26.getX(), -var26.getY(), -var26.getZ());
            var3.push();
            var3.translate(var26.getX(), var26.getY(), var26.getZ());
            iIiiIIiIi_Class358.Ii_method_c1caf816(var3, var32, var39, var2);
            var3.pop();
         }
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var32);
      iIiiiIIiI_Class371.I_method_a0226e1f();
      var3.pop();
   };

   public PredictionModule() {
      this.IiI_method_95dc6e5f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_95dc6e5f() {
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.prediction.entities");
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.prediction.render_mode");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.prediction.render_mode.default");
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.prediction.render_mode.glow").select();
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.prediction.hand").I_method_decd82b5();
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.prediction.walls").I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.prediction.hud").I_method_decd82b5();
      this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.prediction.helper");
      this.iI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.prediction.assist", () -> !this.Ii_field_ba20ca4c.i_method_9b12da03());
      this.ii_field_ba20ca4c = new BooleanSetting(this, "theme.sync").I_method_decd82b5();
      this.I_field_bbd4b66c = new ColorSetting(this, "modules.settings.chams.color", this.ii_field_ba20ca4c::i_method_9b12da03)
         .I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e());
      new IiIIIIiII_Class133<Entity>(this.I_field_bbe3ba6c, "modules.settings.prediction.entities.pearls", var0 -> var0 instanceof EnderPearlEntity).select();
      new IiIIIIiII_Class133<Entity>(this.I_field_bbe3ba6c, "modules.settings.prediction.entities.tridents", var0 -> var0 instanceof TridentEntity).select();
      new IiIIIIiII_Class133<Entity>(this.I_field_bbe3ba6c, "modules.settings.prediction.entities.snowballs", var0 -> var0 instanceof SnowballEntity).select();
      new IiIIIIiII_Class133<Entity>(this.I_field_bbe3ba6c, "modules.settings.prediction.entities.arrows", var0 -> var0 instanceof ArrowEntity).select();
      new IiIIIIiII_Class133<Entity>(this.I_field_bbe3ba6c, "modules.settings.prediction.entities.potions", var0 -> var0 instanceof PotionEntity).select();
      new IiIIIIiII_Class133<>(this.I_field_bbe3ba6c, "modules.settings.prediction.entities.items", var0 -> var0 instanceof ItemEntity);
   }

   @Override
   public void II_method_6642fd22() {
      this.I_field_7865b31.clear();
      long var1 = System.currentTimeMillis();
      this.II_field_7865b31.removeIf(var2 -> var2.I_method_b23826ee(var1));

      for (Entity var4 : I_field_3a9bda27.world.getEntities()) {
         this.I_method_494f972d(var4, false);
      }

      this.Iii_method_95eafa3f();
   }

   private void I_method_d32b95c1(float var1) {
      this.i_field_7865b31.clear();
      if (this.I_field_ba20ca4c.i_method_9b12da03() && I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         iiIIiIIii_Class404 var2 = this.I_method_39ee9417(var1);
         ItemStack var3 = I_field_3a9bda27.player.getMainHandStack();
         ArrayList var4 = new ArrayList();
         Object var5 = null;
         if (var3.getItem() instanceof EnderPearlItem) {
            var5 = new EnderPearlEntity(I_field_3a9bda27.world, I_field_3a9bda27.player, var3);
         } else if (var3.getItem() instanceof TridentItem && I_field_3a9bda27.player.isUsingItem()) {
            var5 = new TridentEntity(I_field_3a9bda27.world, I_field_3a9bda27.player, var3);
         } else if (var3.getItem() instanceof SnowballItem) {
            var5 = new SnowballEntity(I_field_3a9bda27.world, I_field_3a9bda27.player, var3);
         } else if (var3.getItem() instanceof BowItem && I_field_3a9bda27.player.isUsingItem()) {
            ItemStack var11 = new ItemStack(Items.ARROW);
            var5 = new ArrowEntity(I_field_3a9bda27.world, I_field_3a9bda27.player, var11, var3);
         } else if (var3.getItem() instanceof CrossbowItem && CrossbowItem.isCharged(var3)) {
            boolean var6 = iIIiIiIIi_Class298.I_method_7ea237bf(var3, Enchantments.MULTISHOT) > 0;
            ItemStack var7 = new ItemStack(Items.ARROW);
            if (var6) {
               for (int var8 = 0; var8 < 3; var8++) {
                  ArrowEntity var9 = new ArrowEntity(I_field_3a9bda27.world, I_field_3a9bda27.player, var7, var3);
                  var4.add(var9);
               }
            } else {
               var5 = new ArrowEntity(I_field_3a9bda27.world, I_field_3a9bda27.player, var7, var3);
            }
         }

         if (var5 instanceof ProjectileEntity var12) {
            float var14 = 1.5F;
            if (var5 instanceof TridentEntity) {
               var14 = 2.5F;
            } else if (var5 instanceof ArrowEntity) {
               var14 = 3.0F;
            }

            this.I_method_b9ab4bee(var12, I_field_3a9bda27.player, var2.i_method_1461d9ef(), var2.I_method_14534e0f(), 0.0F, var14, 1.0F);
            this.I_method_8405ecc(var12, var1);
            this.I_method_494f972d(var12, true);
         }

         if (!var4.isEmpty()) {
            float var13 = 3.15F;
            float var15 = 10.0F;

            for (int var16 = 0; var16 < var4.size(); var16++) {
               ProjectileEntity var17 = (ProjectileEntity)var4.get(var16);
               float var10 = 0.0F;
               if (var16 == 0) {
                  var10 = -var15;
               } else if (var16 == 2) {
                  var10 = var15;
               }

               this.I_method_b9ab4bee(var17, I_field_3a9bda27.player, var2.i_method_1461d9ef(), var2.I_method_14534e0f() + var10, 0.0F, var13, 1.0F);
               this.I_method_8405ecc(var17, var1);
               this.I_method_494f972d(var17, true);
            }
         }
      }
   }

   private iiIIiIIii_Class404 I_method_39ee9417(float var1) {
      iiIIiIiII_Class405 var2 = RockstarClient.getInstance().I_method_58785402();
      return var2 != null && !var2.I_method_3d166e03()
         ? var2.ii_method_a3477458()
         : new iiIIiIIii_Class404(I_field_3a9bda27.player.getYaw(var1), I_field_3a9bda27.player.getPitch(var1));
   }

   private void I_method_8405ecc(ProjectileEntity var1, float var2) {
      Vec3d var3 = I_field_3a9bda27.player.getCameraPosVec(var2);
      var1.setPosition(var3.x, var3.y - 0.1, var3.z);
   }

   private void Iii_method_95eafa3f() {
      this.I_field_32e13e6c = null;
      this.I_field_5bba0d50 = null;
      if (this.Ii_field_ba20ca4c.i_method_9b12da03() && I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         Item var1 = I_field_3a9bda27.player.getMainHandStack().getItem();
         if (this.I_method_788fa28b(var1)) {
            iiIIiIiII_Class405 var2 = RockstarClient.getInstance().I_method_58785402();
            iiIIiIIii_Class404 var3 = var2.i_method_10b2eeb5();
            Vec3d var4 = I_field_3a9bda27.player.getEyePos();
            float var5 = Float.MAX_VALUE;
            iiIIiIIii_Class404 var6 = null;

            for (PredictionModule.Nested1_b0735fa9 var8 : this.I_field_7865b31) {
               if (var8.I_method_d81a4067() instanceof EnderPearlEntity) {
                  Vec3d var9 = this.I_method_b7d6f455(var8.I_method_fb389476().getLast(), var1);
                  iiIIiIIii_Class404 var10 = this.I_method_827842dd(var4, var9, var1);
                  if (var10 != null) {
                     float var11 = var10.I_method_24e31c97(var3);
                     if (var11 < var5) {
                        var5 = var11;
                        var6 = var10;
                        this.I_field_5bba0d50 = var9;
                     }
                  }
               }
            }

            for (PredictionModule.Nested1_df334c0 var14 : this.i_field_7865b31) {
               if (!var14.I_method_b839c6fe() && var14.I_method_5283aa30() instanceof EnderPearlEntity) {
                  Vec3d var16 = this.I_method_b7d6f455(var14.I_method_1a359cf4(), var1);
                  iiIIiIIii_Class404 var18 = this.I_method_827842dd(var4, var16, var1);
                  if (var18 != null) {
                     float var19 = var18.I_method_24e31c97(var3);
                     if (var19 < var5) {
                        var5 = var19;
                        var6 = var18;
                        this.I_field_5bba0d50 = var16;
                     }
                  }
               }
            }

            if (var6 != null) {
               this.I_field_32e13e6c = iiIIiIiIi_Class406.I_method_565091b5(var2.I_method_fb1d7ad5(), var6);
               if (this.iI_field_ba20ca4c.i_method_9b12da03()) {
                  iiIIiIIii_Class404 var13 = var2.II_method_f098f858();
                  float var15 = Math.abs(iiIIiIiIi_Class406.II_method_95f3d8d2(var13.I_method_14534e0f(), this.I_field_32e13e6c.I_method_14534e0f()));
                  float var17 = Math.abs(var13.i_method_1461d9ef() - this.I_field_32e13e6c.i_method_1461d9ef());
                  if (var15 < 10.0F && var17 < 10.0F) {
                     var2.I_method_1acbf705(
                        this.I_field_32e13e6c, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.iI_field_32efc66c
                     );
                  }
               }
            }
         }
      }
   }

   private Vec3d I_method_b7d6f455(Vec3d var1, Item var2) {
      if (!(var2 instanceof EnderPearlItem)) {
         return var1;
      } else {
         BlockPos var3 = BlockPos.ofFloored(var1);
         return new Vec3d(var3.getX() + 0.5, var3.getY() + 1.0, var3.getZ() + 0.5);
      }
   }

   private iiIIiIIii_Class404 I_method_827842dd(Vec3d var1, Vec3d var2, Item var3) {
      iiIIiIIii_Class404 var4 = iiIIiIiIi_Class406.I_method_89bc9935(var1, var2);
      if (var3 instanceof EnderPearlItem) {
         Float var10 = this.I_method_671266a8(var1, var2);
         return var10 != null && !Float.isNaN(var10) ? new iiIIiIIii_Class404(var4.I_method_14534e0f(), var10) : null;
      } else if (var3 instanceof TridentItem) {
         double var5 = var1.distanceTo(var2);
         double var7 = I_field_3a9bda27.player.getVelocity().y;
         float var9 = var4.i_method_1461d9ef() - (float)(var5 * 0.22F) + (float)(var7 * var5 * (var7 > 0.0 ? 0.5F : 1.0F));
         return new iiIIiIIii_Class404(var4.I_method_14534e0f(), var9);
      } else {
         return null;
      }
   }

   private Float I_method_671266a8(Vec3d var1, Vec3d var2) {
      double var3 = var2.x - var1.x;
      double var5 = var2.z - var1.z;
      double var7 = Math.hypot(var3, var5);
      if (var7 < 0.001) {
         return null;
      } else {
         double var9 = 6.125 * (var2.y - var1.y);
         double var11 = 0.05F * (0.05F * (var7 * var7) + var9);
         double var13 = 9.378906F - var11;
         if (var13 < 0.0) {
            return null;
         } else {
            double var15 = Math.sqrt(var13);
            double var17 = 3.0625 - var15;
            double var19 = Math.atan2(var17 * var17 + var15, 0.05F * var7);
            double var21 = Math.atan2(var17, 0.05F * var7);
            double var23 = Math.min(var19, var21);
            return (float)(-Math.toDegrees(var23));
         }
      }
   }

   private boolean I_method_788fa28b(Item var1) {
      return var1 instanceof EnderPearlItem || var1 instanceof TridentItem;
   }

   private void I_method_494f972d(Entity var1, boolean var2) {
      if (this.I_method_a786ac8b(var1)) {
         if (var1 instanceof ProjectileEntity var3 && var3.getOwner() == null) {
            List var4 = I_field_3a9bda27.world.getPlayers();
            if (!var4.isEmpty()) {
               var4.sort(Comparator.comparingDouble(var1x -> ((net.minecraft.entity.Entity)var1x).distanceTo(var3)));
               var3.setOwner((Entity)var4.getFirst());
            }
         }

         ArrayList var13 = new ArrayList();
         Vec3d var14 = var1.getPos();
         Vec3d var5 = var1.getVelocity();
         Entity var6 = null;
         int var7 = 0;
         BlockHitResult var8 = null;

         for (int var9 = 0; var9 < 150; var9++) {
            Vec3d var10 = this.I_method_de55185d(var1, var5);
            Vec3d var11 = var14.add(var10);
            var7 = var9;
            var8 = I_field_3a9bda27.world.raycast(new RaycastContext(var14, var11, ShapeType.COLLIDER, FluidHandling.NONE, var1));
            Entity var12 = this.I_method_cbecebd9(var1, var11);
            if (var12 != null) {
               var13.add(var11);
               var6 = var12;
               break;
            }

            if (var8.getType() != Type.MISS) {
               var13.add(var8.getPos());
               break;
            }

            var13.add(var11);
            var14 = var11;
            var5 = var10;
         }

         if (!var13.isEmpty()) {
            if (var2) {
               this.i_field_7865b31.add(new PredictionModule.Nested1_df334c0(var1, (Vec3d)var13.getLast(), var7, var6, var8, var2));
            } else {
               this.I_field_7865b31.add(new PredictionModule.Nested1_b0735fa9(var1, var13, var7, var6));
               if (var6 != null && var1 instanceof PotionEntity var15) {
                  this.I_method_f23b2b97(var15, var6, (Vec3d)var13.getLast());
               }
            }
         }
      }
   }

   public Vec3d I_method_3dbf0519() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         iiIIiIIii_Class404 var1 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
         float var2 = var1 != null ? var1.i_method_1461d9ef() : I_field_3a9bda27.player.getPitch();
         float var3 = var1 != null ? var1.I_method_14534e0f() : I_field_3a9bda27.player.getYaw();
         SnowballEntity var4 = new SnowballEntity(I_field_3a9bda27.world, I_field_3a9bda27.player, Items.SNOWBALL.getDefaultStack());
         this.I_method_b9ab4bee(var4, I_field_3a9bda27.player, var2, var3, 0.0F, 1.5F, 1.0F);
         return this.i_method_6dca95e1(var4);
      } else {
         return null;
      }
   }

   public Vec3d I_method_fbda0dc1(Entity var1) {
      return var1 != null && I_field_3a9bda27.world != null ? this.i_method_6dca95e1(var1) : null;
   }

   private Vec3d i_method_6dca95e1(Entity var1) {
      Vec3d var2 = var1.getPos();
      Vec3d var3 = var1.getVelocity();

      for (int var4 = 0; var4 < 150; var4++) {
         Vec3d var5 = this.I_method_de55185d(var1, var3);
         Vec3d var6 = var2.add(var5);
         BlockHitResult var7 = I_field_3a9bda27.world.raycast(new RaycastContext(var2, var6, ShapeType.COLLIDER, FluidHandling.NONE, var1));
         Entity var8 = this.I_method_cbecebd9(var1, var6);
         if (var8 != null) {
            return var6;
         }

         if (var7.getType() != Type.MISS) {
            return var7.getPos();
         }

         var2 = var6;
         var3 = var5;
      }

      return var2;
   }

   private void I_method_7859a60(Identifier var1) {
      AbstractTexture var2 = I_field_3a9bda27.getTextureManager().getTexture(var1);
      if (var2 != null) {
         if (var2.getGlId() != this.i_field_49) {
            this.i_field_49 = var2.getGlId();
            var2.bindTexture();
            GlStateManager._texParameter(3553, 33085, 4);
            GL30.glGenerateMipmap(3553);
         }

         var2.setFilter(true, true);
      }
   }

   private void I_method_5d625b6(MatrixStack var1, Vec3d var2, BufferBuilder var3, float var4, float var5) {
      ColorRGBA var6 = this.ii_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
      var1.push();
      var1.translate(var2);
      var1.multiply(I_field_3a9bda27.gameRenderer.getCamera().getRotation());
      iIiiIIiii_Class360.I_method_a9f124df(var1, var3, -var4 / 2.0F, -var4 / 2.0F, 0.0, var4, var4, var6.withAlpha(255.0F * var5));
      var1.pop();
   }

   private boolean I_method_a786ac8b(Entity var1) {
      boolean var2 = false;

      for (MultiSelectSetting.Nested1_42856060 var4 : this.I_field_bbe3ba6c.i_method_faf6de68()) {
         IiIIIIiII_Class133 var5 = (IiIIIIiII_Class133)var4;
         if (var5.I_method_e107945f(var1)) {
            var2 = true;
         }
      }

      return var1 instanceof TridentEntity var6 && var6.returnTimer > 0
         ? false
         : var2 && (Math.abs(var1.getVelocity().x + var1.getVelocity().z) > 0.01F || Math.abs(var1.getVelocity().y) > 0.2F);
   }

   private void I_method_f23b2b97(PotionEntity var1, Entity var2, Vec3d var3) {
      long var4 = System.currentTimeMillis() + 2000L;

      for (PredictionModule.Nested1_df334a0 var7 : this.II_field_7865b31) {
         if (var7.I_field_49 == var1.getId()) {
            var7.I_method_39ad3fa6(var2, var3, var4);
            return;
         }
      }

      String var8 = this.I_method_8b4f06f9(var1);
      PredictionModule.Nested1_df334a0 var9 = new PredictionModule.Nested1_df334a0(var1.getId(), var1.getStack().copy(), var8, var2, var3, var4);
      this.II_field_7865b31.add(var9);
   }

   private Entity I_method_cbecebd9(Entity var1, Vec3d var2) {
      Vec3d var3 = var1.getPos();
      Vec3d var4 = var2.subtract(var3);
      if (var4.lengthSquared() == 0.0) {
         return null;
      } else {
         EntityHitResult var5 = ProjectileUtil.raycast(
            var1,
            var3,
            var2,
            var1.getBoundingBox().stretch(var4).expand(0.5),
            var1x -> I_field_3a9bda27.player != var1x
               && var1x.isAlive()
               && !(var1x instanceof ItemEntity)
               && !(var1x instanceof SnowballEntity)
               && !(var1x instanceof ExperienceOrbEntity)
               && var1x != var1,
            var4.lengthSquared()
         );
         return var5 != null ? var5.getEntity() : null;
      }
   }

   private String I_method_8b4f06f9(Entity var1) {
      if (var1 instanceof EnderPearlEntity) {
         return Items.ENDER_PEARL.getName().getString();
      } else {
         return var1 instanceof PotionEntity var2 ? var2.getStack().getFormattedName().getString() : var1.getName().getString();
      }
   }

   private void I_method_38e34476(ProjectileEntity var1, double var2, double var4, double var6, float var8) {
      Vec3d var9 = this.I_method_97a75970(var1, var2, var4, var6, var8);
      var1.setVelocity(var9);
      var1.velocityDirty = true;
      double var10 = var9.horizontalLength();
      var1.setYaw((float)(MathHelper.atan2(var9.x, var9.z) * 180.0F / (float)Math.PI));
      var1.setPitch((float)(MathHelper.atan2(var9.y, var10) * 180.0F / (float)Math.PI));
      var1.prevYaw = var1.getYaw();
      var1.prevPitch = var1.getPitch();
   }

   private void I_method_b9ab4bee(ProjectileEntity var1, Entity var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = -MathHelper.sin(var4 * (float) (Math.PI / 180.0)) * MathHelper.cos(var3 * (float) (Math.PI / 180.0));
      float var9 = -MathHelper.sin((var3 + var5) * (float) (Math.PI / 180.0));
      float var10 = MathHelper.cos(var4 * (float) (Math.PI / 180.0)) * MathHelper.cos(var3 * (float) (Math.PI / 180.0));
      this.I_method_38e34476(var1, var8, var9, var10, var6);
      Vec3d var11 = var2.getMovement();
      var1.setVelocity(var1.getVelocity().add(var11.x, var2.isOnGround() ? 0.0 : var11.y, var11.z));
   }

   private Vec3d I_method_97a75970(ProjectileEntity var1, double var2, double var4, double var6, float var8) {
      return new Vec3d(var2, var4, var6).normalize().multiply(var8);
   }

   private Vec3d I_method_de55185d(Entity var1, Vec3d var2) {
      return var2.multiply(0.99).add(0.0, -var1.getFinalGravity(), 0.0);
   }

   private String I_method_8276dda6(String var1, int var2) {
      return var2 <= 0 ? var1 : var1 + "(" + iIIIIiIiI_Class267.i_method_f3c598a1(var2 / 20.0F) + " " + IiIiIIII_Class81.I_method_f25a980a("sec") + ")";
   }

   private String I_method_a2ebfc1c(int var1) {
      int var2 = var1 / 20;
      int var3 = var2 / 60;
      int var4 = var2 % 60;
      return var3 > 0 ? String.format("%d:%02d", var3, var4) : String.format("0:%02d", var4);
   }

   @Generated
   public List<PredictionModule.Nested1_b0735fa9> I_method_7363ea88() {
      return this.I_field_7865b31;
   }

   public static final class Nested1_b0735fa9 {
      final Entity I_field_77e0818c;
      final List<Vec3d> I_field_7865b31;
      final int I_field_49;
      final Entity i_field_77e0818c;

      public Nested1_b0735fa9(Entity var1, List<Vec3d> var2, int var3, Entity var4) {
         this.I_field_77e0818c = var1;
         this.I_field_7865b31 = var2;
         this.I_field_49 = var3;
         this.i_field_77e0818c = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_b0735fa9[entity=" + this.I_field_77e0818c + ", vectors=" + this.I_field_7865b31 + ", ticks=" + this.I_field_49 + ", collidedEntity=" + this.i_field_77e0818c + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_77e0818c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_77e0818c);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         PredictionModule.Nested1_b0735fa9 other = (PredictionModule.Nested1_b0735fa9) var1;
         return java.util.Objects.equals(this.I_field_77e0818c, other.I_field_77e0818c)
            && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_77e0818c, other.i_field_77e0818c);
      }

      public Entity I_method_d81a4067() {
         return this.I_field_77e0818c;
      }

      public List<Vec3d> I_method_fb389476() {
         return this.I_field_7865b31;
      }

      public int I_method_dedd05a4() {
         return this.I_field_49;
      }

      public Entity i_method_de223c47() {
         return this.i_field_77e0818c;
      }
   }

   static class Nested1_df334a0 {
      final int I_field_49;
      private final ItemStack I_field_f2735522;
      private final String I_field_523beb0a;
      private Entity I_field_77e0818c;
      private String i_field_523beb0a;
      private Vec3d I_field_5bba0d50;
      private long I_field_4a;

      Nested1_df334a0(int var1, ItemStack var2, String var3, Entity var4, Vec3d var5, long var6) {
         this.I_field_49 = var1;
         this.I_field_f2735522 = var2;
         this.I_field_523beb0a = var3;
         this.I_field_77e0818c = var4;
         this.i_field_523beb0a = var4.getName().getString();
         this.I_field_5bba0d50 = var5;
         this.I_field_4a = var6;
      }

      void I_method_39ad3fa6(Entity var1, Vec3d var2, long var3) {
         this.I_field_77e0818c = var1;
         this.i_field_523beb0a = var1.getName().getString();
         this.I_field_5bba0d50 = var2;
         this.I_field_4a = var3;
      }

      boolean I_method_b23826ee(long var1) {
         return var1 > this.I_field_4a;
      }

      Vec3d I_method_924e9114() {
         return this.I_field_77e0818c != null && this.I_field_77e0818c.isAlive()
            ? this.I_field_77e0818c.getBoundingBox().getCenter().add(0.0, this.I_field_77e0818c.getHeight() * 0.5, 0.0)
            : this.I_field_5bba0d50;
      }

      ItemStack I_method_911d48de() {
         return this.I_field_f2735522;
      }

      String I_method_6f4898c6() {
         return this.I_field_523beb0a + " -> " + this.i_field_523beb0a;
      }
   }

   static final class Nested1_df334c0 {
      private final Entity I_field_77e0818c;
      private final Vec3d I_field_5bba0d50;
      private final int I_field_49;
      final Entity i_field_77e0818c;
      final BlockHitResult I_field_51edcc0f;
      private final boolean I_field_5a;

      Nested1_df334c0(Entity var1, Vec3d var2, int var3, Entity var4, BlockHitResult var5, boolean var6) {
         this.I_field_77e0818c = var1;
         this.I_field_5bba0d50 = var2;
         this.I_field_49 = var3;
         this.i_field_77e0818c = var4;
         this.I_field_51edcc0f = var5;
         this.I_field_5a = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_df334c0[entity=" + this.I_field_77e0818c + ", pos=" + this.I_field_5bba0d50 + ", ticks=" + this.I_field_49 + ", collidedEntity=" + this.i_field_77e0818c + ", hitResult=" + this.I_field_51edcc0f + ", fromHand=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_77e0818c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_77e0818c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_51edcc0f);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         PredictionModule.Nested1_df334c0 other = (PredictionModule.Nested1_df334c0) var1;
         return java.util.Objects.equals(this.I_field_77e0818c, other.I_field_77e0818c)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_77e0818c, other.i_field_77e0818c)
            && java.util.Objects.equals(this.I_field_51edcc0f, other.I_field_51edcc0f)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public Entity I_method_5283aa30() {
         return this.I_field_77e0818c;
      }

      public Vec3d I_method_1a359cf4() {
         return this.I_field_5bba0d50;
      }

      public int I_method_b839c6ed() {
         return this.I_field_49;
      }

      public Entity i_method_588ba610() {
         return this.i_field_77e0818c;
      }

      public BlockHitResult I_method_9b4177b3() {
         return this.I_field_51edcc0f;
      }

      public boolean I_method_b839c6fe() {
         return this.I_field_5a;
      }
   }
}
