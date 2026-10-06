package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public class IiiiiiII_Class125 extends IiiiIiiI_Class119 {
   private static final Identifier I_field_6a3d6525 = RockstarClient.id("textures/arrow.png");
   private static final float I_field_46 = 35.0F;
   private static IiiiiIII_Class121 I_field_12aa4f81;
   private static IiiiiIiI_Class123 I_field_12aac7a1;
   private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.arrows");
   private final BooleanSetting i_field_ba20ca4c = this.I_method_61f9c255(
      (var0, var1x) -> new BooleanSetting(var0, "esp.arrows.lines", () -> !var1x.i_method_9b12da03())
   );
   private final BooleanSetting II_field_ba20ca4c = this.I_method_61f9c255(
      (var0, var1x) -> new BooleanSetting(var0, "theme.sync", () -> !var1x.i_method_9b12da03()).I_method_decd82b5()
   );
   private final ColorSetting I_field_bbd4b66c = this.I_method_96c36dc8(
      "theme.sync",
      (var0, var1x, var2x) -> new ColorSetting(var0, "esp.arrows.color", () -> !var1x.i_method_9b12da03() || var2x.i_method_9b12da03())
         .I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e())
   );
   private final SliderSetting I_field_73178e8c = this.I_method_96c36dc8(
      "esp.arrows.lines",
      (var0, var1x, var2x) -> new SliderSetting(var0, "esp.arrows.distance", () -> !var1x.i_method_9b12da03() || var2x.i_method_9b12da03())
         .II_method_b0f56334(0.1F)
         .I_method_c8c9a7d7(1.5F)
         .i_method_65e2aff7(10.0F)
         .Ii_method_4e0e6b54(5.0F)
   );
   private final BooleanSetting Ii_field_ba20ca4c = this.I_method_96c36dc8(
      "esp.arrows.lines",
      (var0, var1x, var2x) -> new BooleanSetting(
         var0, "esp.arrows.hide_on_screen", "esp.arrows.hide_on_screen.desc", () -> !var1x.i_method_9b12da03() || var2x.i_method_9b12da03()
      )
   );
   private BooleanSetting iI_field_ba20ca4c;
   private final Map<Integer, IiiiiiII_Class125.Nested1_405194f3> I_field_a567c40b = new HashMap<>();
   private final IiIIIiII_Class69<PreHudRenderEvent> I_field_3d936f41 = var1x -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && this.I_method_ea8b70b0()) {
         boolean var2x = false;

         for (Entity var4x : I_field_3a9bda27.world.getEntities()) {
            if (this.I_method_955700de(var4x) && !this.i_method_504e80fe(var4x)) {
               var2x = true;
               break;
            }
         }

         if (!var2x) {
            this.I_method_f3eb9494(var1x.getTickDelta());
         } else {
            for (Entity var12 : I_field_3a9bda27.world.getEntities()) {
               if (this.I_method_955700de(var12) && !this.i_method_504e80fe(var12)) {
                  boolean var5 = this.II_method_60a47df5(var12) && this.I_method_1589822a(var12, var1x.getTickDelta());
                  int var6 = var12.getId();
                  IiiiiiII_Class125.Nested1_405194f3 var7 = this.I_field_a567c40b.get(var6);
                  if (var7 == null) {
                     if (var5) {
                        continue;
                     }

                     var7 = new IiiiiiII_Class125.Nested1_405194f3();
                     this.I_field_a567c40b.put(var6, var7);
                  }

                  var7.I_field_5a = var5;
                  var7.I_field_46 = this.I_method_15898216(var12, var1x.getTickDelta());
                  var7.I_field_d0c8ec5 = this.I_method_69a07f49(var12);
                  var7.i_field_46 = this.I_method_955700ca(var12);
               }
            }

            this.I_method_f3eb9494(var1x.getTickDelta());
            CustomDrawContext var11 = var1x.getContext();
            MatrixStack var13 = var11.getMatrices();
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
            RenderSystem.disableCull();
            var13.push();
            var13.translate(I_field_73c6d26c.I_method_804ee20f() / 2.0F, I_field_73c6d26c.i_method_805d6def() / 2.0F, 0.0F);
            iiIIIIIiI_Class387 var14 = new iiIIIIIiI_Class387(VertexFormats.POSITION_TEXTURE_COLOR, var13);

            for (Entry var16 : this.I_field_a567c40b.entrySet()) {
               IiiiiiII_Class125.Nested1_405194f3 var8 = (IiiiiiII_Class125.Nested1_405194f3)var16.getValue();
               float var9 = var8.I_field_dc7facc.I_method_6ac4da6f();
               if (!(var9 <= 0.0F)) {
                  iIiiiIIiI_Class371.I_method_6a1c0f0f(var13, 0.0F, 0.0F, var8.I_field_46);
                  iIiiiIIiI_Class371.II_method_e18635ac(var13, 0.0F, 0.0F, 2.0F - var9);
                  var11.drawTexture(I_field_6a3d6525, -17.5F, -17.5F + var8.i_field_46 * 10.0F, 35.0F, 35.0F, var8.I_field_d0c8ec5.mulAlpha(var9));
                  iIiiiIIiI_Class371.I_method_10503b11(var13);
                  iIiiiIIiI_Class371.I_method_10503b11(var13);
               }
            }

            var14.II_method_ed687102();
            var13.pop();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
         }
      }
   };
   private final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41 = var1x -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && this.I_method_ea8b70b0()) {
         boolean var2x = false;

         for (Entity var4x : I_field_3a9bda27.world.getEntities()) {
            if (this.I_method_955700de(var4x) && this.i_method_504e80fe(var4x)) {
               var2x = true;
               break;
            }
         }

         if (var2x) {
            MatrixStack var11 = var1x.getMatrices();
            iIiiiIIiI_Class371.I_method_642c0895(false);
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
            BufferBuilder var12 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

            for (Entity var6 : I_field_3a9bda27.world.getEntities()) {
               if (this.I_method_955700de(var6) && this.i_method_504e80fe(var6)) {
                  Vec3d var7 = iIiiiiIII_Class377.I_method_689b1a13(var6, var1x.getTickDelta());
                  ColorRGBA var8 = this.I_method_69a07f49(var6);
                  float var9 = var6 instanceof LivingEntity var10 ? var10.getHeight() / 2.0F : 0.25F;
                  iIiiIIiIi_Class358.I_method_3f08a433(var11, var12, var7.add(0.0, var9, 0.0), var8);
               }
            }

            iIiiiIIiI_Class371.I_method_c59155f0(var12);
            iIiiiIIiI_Class371.I_method_a0226e1f();
         }
      }
   };

   public IiiiiiII_Class125() {
      super(
         "arrows",
         IiiiiIiI_Class123.I_field_12aac7a1,
         IiiiiIiI_Class123.i_field_12aac7a1,
         IiiiiIiI_Class123.II_field_12aac7a1,
         IiiiiIiI_Class123.Ii_field_12aac7a1
      );
      this.I_method_52f623aa(
         new IiiiiIII_Class121[]{IiiiiIII_Class121.I_field_12aa4f81, IiiiiIII_Class121.II_field_12aa4f81, IiiiiIII_Class121.Ii_field_12aa4f81}
      );
      BooleanSetting var1 = this.I_method_d00eb663(IiiiiIII_Class121.I_field_12aa4f81);
      this.iI_field_ba20ca4c = new BooleanSetting(this, "esp.arrows.hide_naked", () -> !var1.i_method_9b12da03());
      this.IiI_method_98a1721()
         .computeIfAbsent("esp.arrows.hide_naked", var0 -> new HashMap<>())
         .put(IiiiiIII_Class121.I_field_12aa4f81, this.iI_field_ba20ca4c);
      BooleanSetting var2 = this.I_method_62f3944d("theme.sync", IiiiiIII_Class121.II_field_12aa4f81);
      if (var2 != null) {
         var2.I_method_4e1408b5(false);
      }

      BooleanSetting var3 = this.I_method_62f3944d("theme.sync", IiiiiIII_Class121.Ii_field_12aa4f81);
      if (var3 != null) {
         var3.I_method_4e1408b5(false);
      }

      ColorSetting var4 = this.I_method_62f3944d("esp.arrows.color", IiiiiIII_Class121.II_field_12aa4f81);
      if (var4 != null) {
         var4.I_method_a62f5dd6(new ColorRGBA(52.0F, 199.0F, 88.0F));
      }
   }

   @Override
   public boolean I_method_bb355b31(IiiiiIII_Class121 var1) {
      return var1 != IiiiiIII_Class121.i_field_12aa4f81;
   }

   public boolean I_method_955700de(Entity var1) {
      if (var1 instanceof PlayerEntity var2) {
         if (var2 == I_field_3a9bda27.player) {
            return false;
         } else if (RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var2.getName().getString())) {
            return this.i_method_d0cacf11(IiiiiIII_Class121.II_field_12aa4f81);
         } else {
            return !this.i_method_d0cacf11(IiiiiIII_Class121.I_field_12aa4f81)
               ? false
               : !this.iI_field_ba20ca4c.i_method_9b12da03() || !this.I_method_321c1405(var2);
         }
      } else if (var1 instanceof HostileEntity) {
         return this.i_method_d28dbf31(IiiiiIiI_Class123.i_field_12aac7a1);
      } else if (var1 instanceof AnimalEntity) {
         return this.i_method_d28dbf31(IiiiiIiI_Class123.II_field_12aac7a1);
      } else {
         return var1 instanceof ItemEntity ? this.i_method_d28dbf31(IiiiiIiI_Class123.Ii_field_12aac7a1) : false;
      }
   }

   private boolean I_method_321c1405(PlayerEntity var1) {
      for (ItemStack var3 : var1.getAllArmorItems()) {
         if (var3 != null && !var3.isEmpty()) {
            return false;
         }
      }

      return true;
   }

   private IiiiiIII_Class121 I_method_95642236(PlayerEntity var1) {
      if (var1 == I_field_3a9bda27.player) {
         return IiiiiIII_Class121.i_field_12aa4f81;
      } else {
         return RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var1.getName().getString())
            ? IiiiiIII_Class121.II_field_12aa4f81
            : IiiiiIII_Class121.I_field_12aa4f81;
      }
   }

   private ColorRGBA I_method_69a07f49(Entity var1) {
      BooleanSetting var2;
      ColorSetting var3;
      if (var1 instanceof PlayerEntity var4) {
         IiiiiIII_Class121 var5 = I_field_12aa4f81 != null ? I_field_12aa4f81 : this.I_method_95642236(var4);
         var2 = this.I_method_62f3944d("theme.sync", var5);
         var3 = this.I_method_62f3944d("esp.arrows.color", var5);
      } else if (var1 instanceof HostileEntity) {
         IiiiiIiI_Class123 var6 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.i_field_12aac7a1;
         var2 = this.I_method_c9c6d("theme.sync", var6);
         var3 = this.I_method_c9c6d("esp.arrows.color", var6);
      } else if (var1 instanceof AnimalEntity) {
         IiiiiIiI_Class123 var7 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.II_field_12aac7a1;
         var2 = this.I_method_c9c6d("theme.sync", var7);
         var3 = this.I_method_c9c6d("esp.arrows.color", var7);
      } else {
         if (!(var1 instanceof ItemEntity)) {
            return IiiiiIIIi_Class242.i_method_5dfec6e();
         }

         IiiiiIiI_Class123 var8 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.Ii_field_12aac7a1;
         var2 = this.I_method_c9c6d("theme.sync", var8);
         var3 = this.I_method_c9c6d("esp.arrows.color", var8);
      }

      return var2 != null && var2.i_method_9b12da03()
         ? IiiiiIIIi_Class242.i_method_5dfec6e()
         : (var3 != null ? var3.I_method_bde5f08e() : IiiiiIIIi_Class242.i_method_5dfec6e());
   }

   private float I_method_955700ca(Entity var1) {
      SliderSetting var2;
      if (var1 instanceof PlayerEntity var3) {
         IiiiiIII_Class121 var4 = I_field_12aa4f81 != null ? I_field_12aa4f81 : this.I_method_95642236(var3);
         var2 = this.I_method_62f3944d("esp.arrows.distance", var4);
      } else if (var1 instanceof HostileEntity) {
         IiiiiIiI_Class123 var5 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.i_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.distance", var5);
      } else if (var1 instanceof AnimalEntity) {
         IiiiiIiI_Class123 var6 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.II_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.distance", var6);
      } else {
         if (!(var1 instanceof ItemEntity)) {
            return 3.3F;
         }

         IiiiiIiI_Class123 var7 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.Ii_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.distance", var7);
      }

      return var2 != null ? var2.Ii_method_a20abcd2() : 3.3F;
   }

   private boolean i_method_504e80fe(Entity var1) {
      BooleanSetting var2;
      if (var1 instanceof PlayerEntity var3) {
         IiiiiIII_Class121 var4 = I_field_12aa4f81 != null ? I_field_12aa4f81 : this.I_method_95642236(var3);
         var2 = this.I_method_62f3944d("esp.arrows.lines", var4);
      } else if (var1 instanceof HostileEntity) {
         IiiiiIiI_Class123 var5 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.i_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.lines", var5);
      } else if (var1 instanceof AnimalEntity) {
         IiiiiIiI_Class123 var6 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.II_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.lines", var6);
      } else {
         if (!(var1 instanceof ItemEntity)) {
            return false;
         }

         IiiiiIiI_Class123 var7 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.Ii_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.lines", var7);
      }

      return var2 != null && var2.i_method_9b12da03();
   }

   private boolean II_method_60a47df5(Entity var1) {
      BooleanSetting var2;
      if (var1 instanceof PlayerEntity var3) {
         IiiiiIII_Class121 var4 = I_field_12aa4f81 != null ? I_field_12aa4f81 : this.I_method_95642236(var3);
         var2 = this.I_method_62f3944d("esp.arrows.hide_on_screen", var4);
      } else if (var1 instanceof HostileEntity) {
         IiiiiIiI_Class123 var5 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.i_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.hide_on_screen", var5);
      } else if (var1 instanceof AnimalEntity) {
         IiiiiIiI_Class123 var6 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.II_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.hide_on_screen", var6);
      } else {
         if (!(var1 instanceof ItemEntity)) {
            return false;
         }

         IiiiiIiI_Class123 var7 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.Ii_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.arrows.hide_on_screen", var7);
      }

      return var2 != null && var2.i_method_9b12da03();
   }

   private boolean I_method_1589822a(Entity var1, float var2) {
      Vec3d var3 = iIiiiiIII_Class377.I_method_689b1a13(var1, var2);
      float var4 = var1.getWidth() / 2.0F;
      float var5 = var1.getHeight();
      float var6 = Float.MAX_VALUE;
      float var7 = Float.MAX_VALUE;
      float var8 = -Float.MAX_VALUE;
      float var9 = -Float.MAX_VALUE;
      boolean var10 = false;

      for (int var11 = 0; var11 < 8; var11++) {
         Vec2f var12 = iIiiiiIII_Class377.I_method_211fc242(
            var3.add((var11 & 1) == 0 ? -var4 : var4, (var11 & 2) == 0 ? 0.0 : var5, (var11 & 4) == 0 ? -var4 : var4)
         );
         if (var12 != null) {
            var10 = true;
            var6 = Math.min(var6, var12.x);
            var8 = Math.max(var8, var12.x);
            var7 = Math.min(var7, var12.y);
            var9 = Math.max(var9, var12.y);
         }
      }

      return !var10 ? false : var8 >= 0.0F && var6 <= I_field_73c6d26c.I_method_804ee20f() && var9 >= 0.0F && var7 <= I_field_73c6d26c.i_method_805d6def();
   }

   private void I_method_f3eb9494(float var1) {
      Iterator var2 = this.I_field_a567c40b.entrySet().iterator();

      while (var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         int var4 = (Integer)var3.getKey();
         IiiiiiII_Class125.Nested1_405194f3 var5 = (IiiiiiII_Class125.Nested1_405194f3)var3.getValue();
         Entity var6 = I_field_3a9bda27.world.getEntityById(var4);
         boolean var7 = var6 != null && this.I_method_955700de(var6) && !this.i_method_504e80fe(var6) && !var5.I_field_5a;
         var5.I_field_dc7facc.I_method_edd6ec25(500L);
         var5.I_field_dc7facc.I_method_edd72835(var7);
         if (!var7 && var5.I_field_dc7facc.I_method_6ac4da6f() == 0.0F) {
            var2.remove();
         }
      }
   }

   private float I_method_15898216(Entity var1, float var2) {
      Vec3d var3 = iIiiiiIII_Class377.I_method_689b1a13(var1, var2);
      Vec3d var4 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
      double var5 = var3.x - var4.x;
      double var7 = var3.z - var4.z;
      float var9 = I_field_3a9bda27.gameRenderer.getCamera().getYaw();
      double var10 = Math.toDegrees(Math.atan2(var7, var5));
      return (float)(var10 - (var9 - 90.0F));
   }

   @Generated
   public BooleanSetting I_method_159c5322() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting i_method_2b31c702() {
      return this.i_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting II_method_4c82c56b() {
      return this.II_field_ba20ca4c;
   }

   @Generated
   public ColorSetting I_method_17503f42() {
      return this.I_field_bbd4b66c;
   }

   @Generated
   public SliderSetting I_method_ce931762() {
      return this.I_field_73178e8c;
   }

   @Generated
   public BooleanSetting Ii_method_6218394b() {
      return this.Ii_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting iI_method_e99bcd8b() {
      return this.iI_field_ba20ca4c;
   }

   @Generated
   public Map<Integer, IiiiiiII_Class125.Nested1_405194f3> iII_method_884f22e1() {
      return this.I_field_a567c40b;
   }

   @Generated
   public IiIIIiII_Class69<PreHudRenderEvent> I_method_6b873ab() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<Render3DEvent> i_method_30b503cb() {
      return this.i_field_3d936f41;
   }

   @Generated
   public static void I_method_db55d32d(IiiiiIII_Class121 var0) {
      I_field_12aa4f81 = var0;
   }

   @Generated
   public static IiiiiIII_Class121 I_method_dbcf53eb() {
      return I_field_12aa4f81;
   }

   @Generated
   public static void I_method_dd18c34d(IiiiiIiI_Class123 var0) {
      I_field_12aac7a1 = var0;
   }

   @Generated
   public static IiiiiIiI_Class123 I_method_dbcfcc0b() {
      return I_field_12aac7a1;
   }

   static class Nested1_405194f3 {
      IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.I_field_dd60aac);
      boolean I_field_5a;
      float I_field_46;
      ColorRGBA I_field_d0c8ec5 = IiiiiIIIi_Class242.i_method_5dfec6e();
      float i_field_46 = 3.3F;
   }
}
