package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import globals.client.Information;
import globals.shared.proto.Packets;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

public class IiiiiiIi_Class126 extends IiiiIiiI_Class119 {
   private static final Identifier I_field_6a3d6525 = RockstarClient.id("textures/bloom.png");
   private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.boxes");
   private final BooleanSetting i_field_ba20ca4c = this.I_method_61f9c255(
      (var0, var1) -> new BooleanSetting(var0, "theme.sync", () -> !var1.i_method_9b12da03()).I_method_decd82b5()
   );
   private final ColorSetting I_field_bbd4b66c = this.I_method_96c36dc8(
      "theme.sync",
      (var0, var1, var2) -> new ColorSetting(var0, "esp.boxes.color", () -> !var1.i_method_9b12da03() || var2.i_method_9b12da03())
         .I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e())
   );
   private final MultiSelectSetting I_field_bbe3ba6c = this.I_method_61f9c255((var0, var1) -> {
      MultiSelectSetting var2 = new MultiSelectSetting(var0, "esp.boxes.mode", () -> !var1.i_method_9b12da03());
      new MultiSelectSetting.Nested1_42856060(var2, "esp.boxes.mode.fill").select();
      new MultiSelectSetting.Nested1_42856060(var2, "esp.boxes.mode.outline").select();
      return var2;
   });
   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1 -> {
      if (this.I_method_ea8b70b0()) {
         MatrixStack var2 = var1.getMatrices();
         Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
         float var4 = var1.getTickDelta();
         RenderSystem.enableBlend();
         RenderSystem.disableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
         RenderSystem.depthMask(false);
         RenderSystem.setShaderTexture(0, I_field_6a3d6525);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         BufferBuilder var5 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

         for (Entity var7 : I_field_3a9bda27.world.getEntities()) {
            if (this.I_method_706ef8fe(var7)) {
               Vec3d var8 = iIiiiiIII_Class377.I_method_689b1a13(var7, var4);
               float var9 = (var7.getWidth() + var7.getHeight()) * 1.2F;
               ColorRGBA var10 = this.I_method_e1cff769(var7);
               if (this.I_method_dac99848(var7, "esp.boxes.mode.fill")) {
                  var2.push();
                  iIiiiIIiI_Class371.I_method_7d461059(var2, var8);
                  var2.translate(0.0F, var7.getHeight() / 4.0F, 0.0F);
                  var2.multiply(var3.getRotation());
                  iIiiIIiii_Class360.I_method_a9f124df(var2, var5, -var9 / 2.0F, -var9 / 2.0F, 0.0, var9, var9, var10.mulAlpha(0.5F));
                  var2.pop();
               } else {
                  var2.push();
                  iIiiiIIiI_Class371.I_method_7d461059(var2, var8);
                  var2.translate(0.0, var7.getHeight() / 3.0, 0.0);
                  var2.multiply(var3.getRotation());
                  iIiiIIiii_Class360.I_method_a9f124df(var2, var5, -var9 / 2.0F, -var9 / 2.0F, 0.0, var9, var9, var10.mulAlpha(0.5F));
                  var2.pop();
                  var2.push();
                  iIiiiIIiI_Class371.I_method_7d461059(var2, var8);
                  var2.translate(0.0, var7.getHeight() / 1.5, 0.0);
                  var2.multiply(var3.getRotation());
                  iIiiIIiii_Class360.I_method_a9f124df(var2, var5, -var9 / 2.0F, -var9 / 2.0F, 0.0, var9, var9, var10.mulAlpha(0.5F));
                  var2.pop();
               }
            }
         }

         iIiiiIIiI_Class371.I_method_c59155f0(var5);
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder var14 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

         for (Entity var17 : I_field_3a9bda27.world.getEntities()) {
            if (this.I_method_706ef8fe(var17)) {
               MultiSelectSetting var19 = this.I_method_9efb6e10(var17);
               float var21 = var17.getWidth() / 2.0F;
               Box var11 = new Box(-var21, 0.0, -var21, var21, var17.getHeight(), var21);
               var2.push();
               iIiiiIIiI_Class371.I_method_7d461059(var2, iIiiiiIII_Class377.I_method_689b1a13(var17, var4));
               boolean var12 = var19 != null && this.I_method_12dbe568(var19, "esp.boxes.mode.fill");
               ColorRGBA var13 = this.I_method_e1cff769(var17).mulAlpha(var12 && !this.I_method_12dbe568(var19, "esp.boxes.mode.outline") ? 0.35F : 0.1F);
               if (var12) {
                  iIiiIIiIi_Class358.I_method_b5d61e06(var2, var14, var11, var13, var13.mulAlpha(0.0F));
               } else {
                  iIiiIIiIi_Class358.i_method_5e35f7b9(var2, var14, var11, var13);
               }

               var2.pop();
            }
         }

         iIiiiIIiI_Class371.I_method_c59155f0(var14);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder var16 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

         for (Entity var20 : I_field_3a9bda27.world.getEntities()) {
            if (this.I_method_706ef8fe(var20)) {
               MultiSelectSetting var22 = this.I_method_9efb6e10(var20);
               float var23 = var20.getWidth() / 2.0F;
               Box var24 = new Box(-var23, 0.0, -var23, var23, var20.getHeight(), var23);
               var2.push();
               iIiiiIIiI_Class371.I_method_7d461059(var2, iIiiiiIII_Class377.I_method_689b1a13(var20, var4));
               ColorRGBA var25 = this.I_method_e1cff769(var20);
               if (var22 != null && this.I_method_12dbe568(var22, "esp.boxes.mode.outline")) {
                  iIiiIIiIi_Class358.i_method_c95b01e6(var2, var16, var24, var25, var25.mulAlpha(0.0F));
               } else {
                  iIiiIIiIi_Class358.Ii_method_c1caf816(var2, var16, var24, var25);
               }

               var2.pop();
            }
         }

         iIiiiIIiI_Class371.I_method_c59155f0(var16);
         RenderSystem.depthMask(true);
         RenderSystem.defaultBlendFunc();
         RenderSystem.enableCull();
         RenderSystem.enableDepthTest();
         RenderSystem.disableBlend();
      }
   };

   public IiiiiiIi_Class126() {
      super(
         "boxes",
         IiiiiIiI_Class123.I_field_12aac7a1,
         IiiiiIiI_Class123.i_field_12aac7a1,
         IiiiiIiI_Class123.II_field_12aac7a1,
         IiiiiIiI_Class123.Ii_field_12aac7a1
      );
   }

   @Override
   public void I_method_d9976c2e(III var1, Entity var2, float var3, float var4, IiiiiIiI_Class123 var5, IiiiiIII_Class121 var6) {
      float var7 = var2.getHeight();
      float var8 = var2.getWidth() / 2.0F;
      MatrixStack var9 = var1.getMatrices();
      ColorRGBA var10 = this.I_method_30dcc8dd(var5, var6);
      float var11 = IiiiiIIi_Class122.II_method_833ac25();
      float var12 = IiiiiIIi_Class122.Ii_method_8423805();
      float var13 = var2 instanceof LivingEntity ? IiiiiIIi_Class122.i_method_10d5ec7c() : 0.0F;
      float var14 = 45.0F;
      Quaternionf var15 = new Quaternionf().rotateZ((float) Math.PI).rotateX((float)Math.toRadians(var13));
      float var16 = (var8 + var7) * 1.4F;
      RenderSystem.enableBlend();
      RenderSystem.disableDepthTest();
      RenderSystem.disableCull();
      RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
      RenderSystem.depthMask(false);
      var9.push();
      var9.translate(var3, var4 + 36.0F, 50.0F);
      var9.scale(var11, var11, -var11);
      var9.multiply(var15);
      var9.translate(0.0F, -var12, 0.0F);
      RenderSystem.setShaderTexture(0, I_field_6a3d6525);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var17 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      if (this.I_method_dac99848(var2, "esp.boxes.mode.fill")) {
         iIiiIIiii_Class360.I_method_a9f124df(var9, var17, -var16 / 2.0F, -var7 / 5.0F - var16 / 2.0F, 0.0, var16, var16, var10.mulAlpha(0.5F));
      } else {
         iIiiIIiii_Class360.I_method_a9f124df(var9, var17, -var16 / 2.0F, var7 / 6.0F - var16 / 2.0F, 0.0, var16, var16, var10.mulAlpha(0.5F));
         iIiiIIiii_Class360.I_method_a9f124df(var9, var17, -var16 / 2.0F, -var7 / 6.0F - var16 / 2.0F, 0.0, var16, var16, var10.mulAlpha(0.5F));
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var17);
      RenderSystem.setShaderTexture(0, 0);
      var9.pop();
      var9.push();
      var9.translate(var3, var4 + 36.0F, 50.0F);
      var9.scale(var11, var11, -var11);
      var9.multiply(var15);
      var9.translate(0.0F, -var7 / 2.0F - var12, 0.0F);
      var9.translate(0.0F, var7 / 2.0F, 0.0F);
      var9.multiply(new Quaternionf().rotateY((float)Math.toRadians(var14)));
      var9.translate(0.0F, -var7 / 2.0F, 0.0F);
      Box var18 = new Box(-var8, 0.0, -var8, var8, var7, var8);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
      BufferBuilder var19 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      MultiSelectSetting var20 = this.I_method_9efb6e10(var2);
      boolean var21 = var20 != null && this.I_method_12dbe568(var20, "esp.boxes.mode.fill");
      ColorRGBA var22 = this.I_method_e1cff769(var2).mulAlpha(var21 && !this.I_method_12dbe568(var20, "esp.boxes.mode.outline") ? 0.35F : 0.1F);
      if (var21) {
         iIiiIIiIi_Class358.I_method_b5d61e06(var9, var19, var18, var22, var22.mulAlpha(0.0F));
      } else {
         iIiiIIiIi_Class358.i_method_5e35f7b9(var9, var19, var18, var22);
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var19);
      BufferBuilder var23 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      ColorRGBA var24 = this.I_method_e1cff769(var2);
      if (var20 != null && this.I_method_12dbe568(var20, "esp.boxes.mode.outline")) {
         iIiiIIiIi_Class358.i_method_c95b01e6(var9, var23, var18, var24, var24.mulAlpha(0.0F));
      } else {
         iIiiIIiIi_Class358.Ii_method_c1caf816(var9, var23, var18, var24);
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var23);
      var9.pop();
      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableCull();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
   }

   private ColorRGBA I_method_30dcc8dd(IiiiiIiI_Class123 var1, IiiiiIII_Class121 var2) {
      BooleanSetting var3;
      ColorSetting var4;
      if (var1 == IiiiiIiI_Class123.I_field_12aac7a1) {
         var3 = this.I_method_62f3944d("theme.sync", var2);
         var4 = this.I_method_62f3944d("esp.boxes.color", var2);
      } else {
         var3 = this.I_method_c9c6d("theme.sync", var1);
         var4 = this.I_method_c9c6d("esp.boxes.color", var1);
      }

      return var3 != null && var3.i_method_9b12da03()
         ? IiiiiIIIi_Class242.i_method_5dfec6e()
         : (var4 != null ? var4.I_method_bde5f08e() : IiiiiIIIi_Class242.i_method_5dfec6e());
   }

   private ColorRGBA I_method_e1cff769(Entity var1) {
      BooleanSetting var2;
      ColorSetting var3;
      if (var1 instanceof AbstractClientPlayerEntity var4) {
         IiiiiIII_Class121 var5 = this.I_method_9a5f3d64(var4);
         var2 = this.I_method_62f3944d("theme.sync", var5);
         var3 = this.I_method_62f3944d("esp.boxes.color", var5);
      } else if (var1 instanceof ItemEntity) {
         var2 = this.I_method_c9c6d("theme.sync", IiiiiIiI_Class123.Ii_field_12aac7a1);
         var3 = this.I_method_c9c6d("esp.boxes.color", IiiiiIiI_Class123.Ii_field_12aac7a1);
      } else if (var1 instanceof HostileEntity) {
         var2 = this.I_method_c9c6d("theme.sync", IiiiiIiI_Class123.i_field_12aac7a1);
         var3 = this.I_method_c9c6d("esp.boxes.color", IiiiiIiI_Class123.i_field_12aac7a1);
      } else {
         if (!(var1 instanceof AnimalEntity)) {
            return IiiiiIIIi_Class242.i_method_5dfec6e();
         }

         var2 = this.I_method_c9c6d("theme.sync", IiiiiIiI_Class123.II_field_12aac7a1);
         var3 = this.I_method_c9c6d("esp.boxes.color", IiiiiIiI_Class123.II_field_12aac7a1);
      }

      return var2 != null && var2.i_method_9b12da03()
         ? IiiiiIIIi_Class242.i_method_5dfec6e()
         : (var3 != null ? var3.I_method_bde5f08e() : IiiiiIIIi_Class242.i_method_5dfec6e());
   }

   private MultiSelectSetting I_method_9efb6e10(Entity var1) {
      if (var1 instanceof AbstractClientPlayerEntity var2) {
         return this.I_method_62f3944d("esp.boxes.mode", this.I_method_9a5f3d64(var2));
      } else if (var1 instanceof ItemEntity) {
         return this.I_method_c9c6d("esp.boxes.mode", IiiiiIiI_Class123.Ii_field_12aac7a1);
      } else if (var1 instanceof HostileEntity) {
         return this.I_method_c9c6d("esp.boxes.mode", IiiiiIiI_Class123.i_field_12aac7a1);
      } else {
         return var1 instanceof AnimalEntity ? this.I_method_c9c6d("esp.boxes.mode", IiiiiIiI_Class123.II_field_12aac7a1) : null;
      }
   }

   private boolean I_method_dac99848(Entity var1, String var2) {
      MultiSelectSetting var3 = this.I_method_9efb6e10(var1);
      return var3 != null && this.I_method_12dbe568(var3, var2);
   }

   private boolean I_method_12dbe568(MultiSelectSetting var1, String var2) {
      return var1.i_method_faf6de68().stream().anyMatch(var1x -> var1x.getName().equals(var2));
   }

   private boolean I_method_706ef8fe(Entity var1) {
      if (var1 instanceof AbstractClientPlayerEntity var2) {
         return var2 == I_field_3a9bda27.player && I_field_3a9bda27.options.getPerspective().isFirstPerson()
            ? false
            : this.i_method_d0cacf11(this.I_method_9a5f3d64(var2));
      } else if (var1 instanceof ItemEntity) {
         return this.i_method_d28dbf31(IiiiiIiI_Class123.Ii_field_12aac7a1);
      } else if (var1 instanceof HostileEntity) {
         return this.i_method_d28dbf31(IiiiiIiI_Class123.i_field_12aac7a1);
      } else {
         return var1 instanceof AnimalEntity ? this.i_method_d28dbf31(IiiiiIiI_Class123.II_field_12aac7a1) : false;
      }
   }

   private IiiiiIII_Class121 I_method_9a5f3d64(AbstractClientPlayerEntity var1) {
      if (var1 == I_field_3a9bda27.player) {
         return IiiiiIII_Class121.i_field_12aa4f81;
      } else {
         IiIIiiII_Class77 var2 = RockstarClient.getInstance().I_method_7a5acaeb();
         if (var2.I_method_19c9437a(var1.getName().getString())) {
            return IiiiiIII_Class121.II_field_12aa4f81;
         } else {
            for (Packets.Nested1_1da0dac9 var4 : Information.getVisiblePlayers()) {
               if (var4.gameInfo() != null && var4.gameInfo().nickname() != null && var4.gameInfo().nickname().equals(var1.getName().getString())) {
                  return IiiiiIII_Class121.Ii_field_12aa4f81;
               }
            }

            return IiiiiIII_Class121.I_field_12aa4f81;
         }
      }
   }
}
