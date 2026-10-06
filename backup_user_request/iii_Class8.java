package rockstar.client;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import net.minecraft.client.util.math.MatrixStack;
import pyrock.utility.render.ColorRGBA;

public class iii_Class8 extends iiI_Class7 {
   private final List<iiI_Class7> I_field_7865b31 = new ArrayList<>();
   private iII_Class5 I_field_b583e68c;
   private float I_field_46;
   private IIII I_field_f935fcc1;
   private int I_field_49;
   private boolean I_field_5a;
   private IIi_Class2 I_field_b5755e8c;
   private IIIi_Class2 I_field_f93600a1;
   private boolean i_field_5a;
   private boolean II_field_5a;
   private float i_field_46;
   private float II_field_46;
   private float Ii_field_46;
   private float iI_field_46;
   private Function<iii_Class8, ColorRGBA> I_field_aad1658;
   private IIiii_Class8 I_field_2d98a52c;
   private float ii_field_46;
   private iii_Class8.Nested1_b548540 I_field_65f5a247;
   private float III_field_46;
   private float IIi_field_46;
   private boolean Ii_field_5a;
   private float IiI_field_46;
   private float Iii_field_46;
   private float iII_field_46;
   private float iIi_field_46;
   private float iiI_field_46;
   private float iii_field_46;
   private float IIII_field_46;
   private float IIIi_field_46;
   private final IiII_Class5 I_field_f94488a1;

   public iii_Class8() {
      this.I_field_b583e68c = iII_Class5.I_field_b583e68c;
      this.I_field_46 = 0.0F;
      this.I_field_f935fcc1 = IIII.I_field_f935fcc1;
      this.I_field_49 = 1;
      this.I_field_5a = false;
      this.I_field_b5755e8c = IIi_Class2.Ii_field_b5755e8c;
      this.I_field_f93600a1 = IIIi_Class2.I_field_f93600a1;
      this.i_field_5a = false;
      this.II_field_5a = false;
      this.i_field_46 = 0.0F;
      this.II_field_46 = 0.0F;
      this.Ii_field_46 = 0.0F;
      this.iI_field_46 = 24.0F;
      this.I_field_2d98a52c = IIiii_Class8.I_field_2d98a52c;
      this.ii_field_46 = 0.0F;
      this.IiI_field_46 = 0.0F;
      this.Iii_field_46 = 0.0F;
      this.iII_field_46 = 0.0F;
      this.iIi_field_46 = 0.0F;
      this.I_field_f94488a1 = new IiII_Class5(this);
   }

   public iii_Class8 I_method_3301fdd(iII_Class5 var1) {
      this.I_field_b583e68c = var1 == null ? iII_Class5.I_field_b583e68c : var1;
      return this;
   }

   public iii_Class8 I_method_485bccf5() {
      return this.I_method_3301fdd(iII_Class5.I_field_b583e68c);
   }

   public iii_Class8 i_method_c88da8d5() {
      return this.I_method_3301fdd(iII_Class5.II_field_b583e68c);
   }

   public iii_Class8 I_method_70a38517(float var1) {
      this.I_field_46 = var1;
      return this;
   }

   public iii_Class8 I_method_7e2bb176(IIII var1) {
      this.I_field_f935fcc1 = var1 == null ? IIII.I_field_f935fcc1 : var1;
      return this;
   }

   public iii_Class8 i_method_f6ad2537(float var1) {
      this.I_field_f935fcc1 = IIII.I_method_14640aa3(var1);
      return this;
   }

   public iii_Class8 I_method_5152d135(float var1, float var2) {
      this.I_field_f935fcc1 = IIII.I_method_b1e865cb(var1, var2);
      return this;
   }

   public iii_Class8 I_method_4f3850da(int var1) {
      this.I_field_49 = Math.max(1, var1);
      return this;
   }

   public iii_Class8 II_method_3b06fa38() {
      this.I_field_5a = true;
      return this;
   }

   public iii_Class8 I_method_3c837e2b(boolean var1) {
      this.I_field_5a = var1;
      return this;
   }

   public iii_Class8 I_method_483797dd(IIi_Class2 var1) {
      this.I_field_b5755e8c = var1 == null ? IIi_Class2.Ii_field_b5755e8c : var1;
      return this;
   }

   public iii_Class8 I_method_fe5d8d56(IIIi_Class2 var1) {
      this.I_field_f93600a1 = var1 == null ? IIIi_Class2.I_field_f93600a1 : var1;
      return this;
   }

   public iii_Class8 Ii_method_bb38d618() {
      this.i_field_5a = true;
      return this;
   }

   public iii_Class8 i_method_c28d1e4b(boolean var1) {
      this.i_field_5a = var1;
      return this;
   }

   public iii_Class8 II_method_d35e0034(float var1) {
      this.iI_field_46 = var1;
      return this;
   }

   public iii_Class8 iI_method_c1109a58() {
      this.II_field_5a = true;
      return this;
   }

   public iii_Class8 II_method_9f3df948(boolean var1) {
      this.II_field_5a = var1;
      return this;
   }

   public iii_Class8 Ii_method_5967a054(float var1) {
      this.Ii_field_46 = Math.max(0.0F, var1);
      return this;
   }

   public iii_Class8 I_method_3987f136(IiIi_Class6 var1) {
      this.I_field_f94488a1.I_method_5809826a(var1);
      return this;
   }

   public iii_Class8 I_method_b65baecb(Consumer<IiII_Class5> var1) {
      if (var1 != null) {
         var1.accept(this.I_field_f94488a1);
      }

      return this;
   }

   public IiII_Class5 I_method_c15a6b58() {
      return this.I_field_f94488a1;
   }

   public iii_Class8 I_method_e53800a9(Function<iii_Class8, ColorRGBA> var1) {
      this.I_field_aad1658 = var1;
      return this;
   }

   public iii_Class8 I_method_56ebe256(ColorRGBA var1) {
      this.I_field_aad1658 = var1x -> var1;
      return this;
   }

   public iii_Class8 iI_method_e886414(float var1) {
      this.I_field_2d98a52c = IIiii_Class8.I_method_893b2757(var1);
      return this;
   }

   public iii_Class8 I_method_ce2a4afd(IIiii_Class8 var1) {
      this.I_field_2d98a52c = var1 == null ? IIiii_Class8.I_field_2d98a52c : var1;
      return this;
   }

   public iii_Class8 ii_method_94920434(float var1) {
      this.ii_field_46 = var1;
      return this;
   }

   @Override
   protected float backdropRadius() {
      return this.I_field_2d98a52c.I_method_b483cecf();
   }

   @Override
   protected IIiii_Class8 shapeRadius() {
      return this.I_field_2d98a52c;
   }

   @Override
   protected float shapeSquircle() {
      return this.ii_field_46;
   }

   public iii_Class8 III_method_c7f2e8b7(float var1) {
      super.blur(var1);
      return this;
   }

   public iii_Class8 I_method_86b33674(float var1, ColorRGBA var2) {
      super.blur(var1, var2);
      return this;
   }

   public iii_Class8 ii_method_41427638() {
      super.glass();
      return this;
   }

   public iii_Class8 I_method_1d32ca49(float var1, boolean var2) {
      super.glass(var1, var2);
      return this;
   }

   public iii_Class8 I_method_f136b1d8(iii_Class8.Nested1_b548540 var1) {
      this.I_field_65f5a247 = var1;
      return this;
   }

   public List<iiI_Class7> I_method_38e5328() {
      return this.I_field_7865b31;
   }

   public iii_Class8 I_method_84672d76(IIii_Class4 var1) {
      super.motion(var1);
      return this;
   }

   public iii_Class8 IIi_method_4dfc88d7(float var1) {
      super.width(var1);
      return this;
   }

   public iii_Class8 IiI_method_31d4c97(float var1) {
      super.height(var1);
      return this;
   }

   public iii_Class8 i_method_8c7d3515(float var1, float var2) {
      super.size(var1, var2);
      return this;
   }

   public iii_Class8 II_method_45e7b9b8(float var1, float var2) {
      super.minSize(var1, var2);
      return this;
   }

   public iii_Class8 Ii_method_81121d98(float var1, float var2) {
      super.maxSize(var1, var2);
      return this;
   }

   public iii_Class8 Iii_method_8926ecb7(float var1) {
      super.minWidth(var1);
      return this;
   }

   public iii_Class8 iII_method_f21500d7(float var1) {
      super.minHeight(var1);
      return this;
   }

   public iii_Class8 III_method_9dc17555() {
      super.fillWidth();
      return this;
   }

   public iii_Class8 IIi_method_1df35135() {
      super.fillHeight();
      return this;
   }

   public iii_Class8 IiI_method_23cb1575() {
      super.fill();
      return this;
   }

   public iii_Class8 iI_method_7009d1d8(float var1, float var2) {
      super.at(var1, var2);
      return this;
   }

   public iii_Class8 I_method_3f5fb576(IiiI_Class7 var1) {
      super.enter(var1);
      return this;
   }

   public iii_Class8 i_method_6e516956(IiiI_Class7 var1) {
      super.exit(var1);
      return this;
   }

   public iii_Class8 II_method_32b63e79(IiiI_Class7 var1) {
      super.transition(var1);
      return this;
   }

   public iii_Class8 i_method_b358e156(IIii_Class4 var1) {
      super.lifeMotion(var1);
      return this;
   }

   public iii_Class8 I_method_c0ca36f3(Runnable var1) {
      super.onClick(var1);
      return this;
   }

   public iii_Class8 i_method_5db1deeb(Consumer<IiIII_Class9> var1) {
      super.onClick(var1);
      return this;
   }

   public iii_Class8 I_method_b60c4df8(iiI_Class7.Nested1_b540d20 var1) {
      super.onClick(var1);
      return this;
   }

   public iii_Class8 Ii_method_25479968(boolean var1) {
      super.interactive(var1);
      return this;
   }

   public iii_Class8 Iii_method_a3fcf155() {
      super.modal();
      return this;
   }

   public iii_Class8 I_method_8361fbbd(iIi_Class6 var1) {
      super.draggable(var1);
      return this;
   }

   public iii_Class8 iI_method_da685d28(boolean var1) {
      super.draggable(var1);
      return this;
   }

   public iii_Class8 I_method_9680b4fd(iIIIiIIIi_Class274 var1) {
      super.cursor(var1);
      return this;
   }

   public iii_Class8 II_method_77bdb679(IIii_Class4 var1) {
      super.hoverMotion(var1);
      return this;
   }

   public iii_Class8 iII_method_d8ebd935() {
      super.center();
      return this;
   }

   public iii_Class8 iIi_method_591db515() {
      super.centerX();
      return this;
   }

   public iii_Class8 iiI_method_5ef57955() {
      super.centerY();
      return this;
   }

   public iii_Class8 I_method_879bc687(BooleanSupplier var1) {
      super.visibleWhen(var1);
      return this;
   }

   public iii_Class8 I_method_c8bfcd88(BooleanSupplier var1, IIii_Class4 var2) {
      super.visibleWhen(var1, var2);
      return this;
   }

   public iii_Class8 I_method_e16e9925(BooleanSupplier var1, IiiiIiiII_Class237 var2, long var3) {
      super.visibleWhen(var1, var2, var3);
      return this;
   }

   public iii_Class8 i_method_48153267(BooleanSupplier var1) {
      super.snapPosition(var1);
      return this;
   }

   public iii_Class8 iii_method_df275535() {
      super.snapPosition();
      return this;
   }

   @Override
   public void snapSubtree() {
      super.snapSubtree();

      for (iiI_Class7 var2 : this.I_field_7865b31) {
         var2.snapSubtree();
      }
   }

   public iii_Class8 IIII_method_92565dd8() {
      super.animatePosition();
      return this;
   }

   public iii_Class8 II_method_65e0ce4a(BooleanSupplier var1) {
      super.sticky(var1);
      return this;
   }

   public iii_Class8 IIIi_method_128839b8() {
      super.sticky();
      return this;
   }

   public iii_Class8 IIiI_method_185ffdf8() {
      super.collapse();
      return this;
   }

   public iii_Class8 ii_method_6071fd48(boolean var1) {
      super.collapse(var1);
      return this;
   }

   public iii_Class8 I_method_da231891(String var1, BooleanSupplier var2) {
      super.bind(var1, var2);
      return this;
   }

   public iii_Class8 I_method_95c84f8e(String var1, iiI_Class7.Nested1_b540d40 var2) {
      super.bind(var1, var2);
      return this;
   }

   public iii_Class8 I_method_350d9c12(String var1, BooleanSupplier var2, IIii_Class4 var3) {
      super.bind(var1, var2, var3);
      return this;
   }

   public iii_Class8 I_method_404ac74f(String var1, iiI_Class7.Nested1_b540d40 var2, IIii_Class4 var3) {
      super.bind(var1, var2, var3);
      return this;
   }

   public iii_Class8 I_method_408c11ff(String var1, BooleanSupplier var2, long var3) {
      super.bind(var1, var2, var3);
      return this;
   }

   public iii_Class8 I_method_f98dbaa2(String var1, iiI_Class7.Nested1_b540d40 var2, long var3) {
      super.bind(var1, var2, var3);
      return this;
   }

   public iii_Class8 I_method_b0c67900(String var1, IIii_Class4 var2) {
      super.signalMotion(var1, var2);
      return this;
   }

   public iii_Class8 I_method_8939bffd(iiI_Class7 var1) {
      if (var1 != null && var1 != this) {
         var1.parent = this;
         var1.beginEnter(0.0F);
         this.I_field_7865b31.add(var1);
         return this;
      } else {
         return this;
      }
   }

   public iii_Class8 I_method_ef221966(List<? extends iiI_Class7> var1) {
      for (iiI_Class7 var3 : var1) {
         this.I_method_8939bffd(var3);
      }

      return this;
   }

   public iii_Class8 i_method_dd52101d(iiI_Class7 var1) {
      if (var1 != null && this.I_field_7865b31.contains(var1)) {
         var1.beginExit(0.0F);
      }

      return this;
   }

   public void I_method_814bf93f() {
      for (iiI_Class7 var2 : this.I_field_7865b31) {
         var2.beginExit(0.0F);
      }
   }

   public iii_Class8 i_method_d2e03546(List<? extends iiI_Class7> var1) {
      for (iiI_Class7 var3 : this.I_field_7865b31) {
         var3.parent = null;
      }

      this.I_field_7865b31.clear();
      this.i_field_46 = this.II_field_46 = 0.0F;
      if (var1 != null) {
         this.I_method_ef221966(var1);
      }

      return this;
   }

   public iii_Class8 II_method_244860a9(List<? extends iiI_Class7> var1) {
      IdentityHashMap var2 = new IdentityHashMap();

      for (iiI_Class7 var4 : var1) {
         var2.put(var4, Boolean.TRUE);
      }

      ArrayList var10 = new ArrayList();
      int var11 = 0;

      for (iiI_Class7 var6 : this.I_field_7865b31) {
         if (var6.phase() != iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866 && !var2.containsKey(var6)) {
            var11++;
         }
      }

      int var12 = 0;

      for (iiI_Class7 var7 : this.I_field_7865b31) {
         if (var7.phase() != iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866 && !var2.containsKey(var7)) {
            var7.beginExit(this.I_method_5e4105cf(var12++, var11));
            var10.add(var7);
         }
      }

      IdentityHashMap var14 = new IdentityHashMap();

      for (iiI_Class7 var8 : this.I_field_7865b31) {
         var14.put(var8, Boolean.TRUE);
      }

      int var16 = var1.size();

      for (int var17 = 0; var17 < var16; var17++) {
         iiI_Class7 var9 = (iiI_Class7)var1.get(var17);
         if (var14.containsKey(var9)) {
            if (var9.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866 || var9.phase() == iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
               var9.parent = this;
               var9.beginEnter(this.I_method_5e4105cf(var17, var16));
            } else if (var9.phase() == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866) {
               var9.beginEnter(this.I_method_5e4105cf(var17, var16));
            }

            var10.add(var9);
         } else {
            var9.parent = this;
            var9.beginEnter(this.I_method_5e4105cf(var17, var16));
            var10.add(var9);
         }
      }

      this.I_field_7865b31.clear();
      this.I_field_7865b31.addAll(var10);
      this.II_field_46 = 0.0F;
      return this;
   }

   private float I_method_5e4105cf(int var1, int var2) {
      return !(this.Ii_field_46 <= 0.0F) && var2 > 1 ? this.Ii_field_46 * ((float)var1 / (var2 - 1)) : 0.0F;
   }

   @Override
   public float desiredW() {
      return this.explicitW ? this.clampW(this.prefW) : this.clampW(this.IiI_field_46 >= 0.0F ? this.iII_method_290cf90a() : this.prefW);
   }

   @Override
   protected float rawDesiredH() {
      return this.explicitH ? this.clampH(this.prefH) : this.clampH(this.iIi_method_b76657aa());
   }

   private float iII_method_290cf90a() {
      return (this.I_field_b583e68c.I_method_ade97d43() ? this.Iii_field_46 : this.IiI_field_46) + this.I_field_f935fcc1.I_method_b35d9ffc();
   }

   private float iIi_method_b76657aa() {
      return (this.I_field_b583e68c.I_method_ade97d43() ? this.IiI_field_46 : this.Iii_field_46) + this.I_field_f935fcc1.i_method_b36c2bdc();
   }

   @Override
   protected void measure() {
      if (this.II_field_5a) {
         this.II_method_57518862();
      } else {
         boolean var1 = this.I_field_b583e68c.I_method_ade97d43();
         int var2 = Math.max(1, this.I_field_49);
         ArrayList var3 = new ArrayList(this.I_field_7865b31.size());

         for (iiI_Class7 var5 : this.I_field_7865b31) {
            if (var5.phase() != iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
               var5.measure();
               if (var5.inFlow()) {
                  var3.add(var5);
               }
            }
         }

         int var13 = var3.size();
         if (var13 == 0) {
            this.IiI_field_46 = 0.0F;
            this.Iii_field_46 = 0.0F;
         } else if (this.I_field_5a) {
            float var15 = var1
               ? this.h.I_method_4e8b496f() - this.I_field_f935fcc1.i_method_b36c2bdc()
               : this.w.I_method_4e8b496f() - this.I_field_f935fcc1.I_method_b35d9ffc();
            if (var15 <= 0.0F) {
               var15 = Float.MAX_VALUE;
            }

            this.I_method_7e6464b8(var3, var1, var15, false, 0.0F, 0.0F);
         } else {
            int var14 = (var13 + var2 - 1) / var2;
            float[] var6 = new float[var14];
            float var7 = 0.0F;

            for (int var8 = 0; var8 < var13; var8++) {
               iiI_Class7 var9 = (iiI_Class7)var3.get(var8);
               int var10 = var8 / var2;
               float var11 = var1 ? var9.desiredH() : var9.desiredW();
               float var12 = var1 ? var9.desiredW() : var9.desiredH();
               var6[var10] = Math.max(var6[var10], var11);
               var7 = Math.max(var7, var12);
            }

            float var16 = (var14 - 1) * this.I_field_46;

            for (float var20 : var6) {
               var16 += var20;
            }

            this.IiI_field_46 = var16;
            this.Iii_field_46 = var2 * var7 + (var2 - 1) * this.I_field_46;
         }
      }
   }

   @Override
   protected void onTick(float var1, float var2, float var3) {
      this.I_field_7865b31.removeIf(var0 -> var0.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866);
      if (this.phase == iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
         this.Ii_field_5a = false;
      } else {
         if (this.Ii_field_5a) {
            float var4 = this.x.I_method_4e8b496f() - this.III_field_46;
            float var5 = this.y.I_method_4e8b496f() - this.IIi_field_46;
            if (var4 != 0.0F || var5 != 0.0F) {
               for (iiI_Class7 var7 : this.I_field_7865b31) {
                  var7.rideWith(var4, var5);
               }
            }
         }

         this.III_field_46 = this.x.I_method_4e8b496f();
         this.IIi_field_46 = this.y.I_method_4e8b496f();
         this.Ii_field_5a = true;
         if (this.inFlow()) {
            this.iI_method_59147882();
         }

         boolean var13 = this.epochSnap();
         if (!this.explicitW && !this.fillW) {
            float var14 = this.clampW(this.iII_method_290cf90a());
            if (var13) {
               this.w.i_method_84a13e41(var14);
            } else {
               this.w.I_method_82de4e21(var14);
            }
         }

         if (!this.explicitH && !this.fillH) {
            float var15 = this.clampH(this.iIi_method_b76657aa());
            if (var13) {
               this.h.i_method_84a13e41(var15);
            } else {
               this.h.I_method_82de4e21(var15);
            }
         }

         if (this.i_field_5a) {
            float var16 = Math.max(0.0F, this.IiI_field_46 - this.iII_field_46);
            this.II_field_46 = Math.max(0.0F, Math.min(this.II_field_46, var16));
            if (var13) {
               this.i_field_46 = this.II_field_46;
            } else {
               this.i_field_46 = this.i_field_46 + (this.II_field_46 - this.i_field_46) * Math.min(1.0F, var1 * 0.02F);
            }

            if (Math.abs(this.II_field_46 - this.i_field_46) < 0.05F) {
               this.i_field_46 = this.II_field_46;
            }
         } else {
            this.i_field_46 = this.II_field_46 = 0.0F;
         }

         boolean var17 = this.I_field_b583e68c.I_method_ade97d43();
         float var18 = 0.0F;

         for (iiI_Class7 var8 : this.I_field_7865b31) {
            if (var8.inFlow() && var8.isSticky()) {
               var18 += var17 ? var8.h() : var8.w();
            }
         }

         this.iIi_field_46 = var18;
         float var20 = var2;
         float var21 = var3;
         if (var17) {
            var21 = var3 + this.i_field_46;
         } else {
            var20 = var2 + this.i_field_46;
         }

         boolean var9 = this.hoverable && this.inFlow();
         int var10 = this.I_method_814bf932();

         for (int var11 = 0; var11 < this.I_field_7865b31.size(); var11++) {
            iiI_Class7 var12 = this.I_field_7865b31.get(var11);
            var12.hoverable = var9 && var11 >= var10 && this.I_method_7829c28b(var12, var2, var3);
            if (var12.isSticky()) {
               var12.tick(var1, var2, var3);
            } else {
               var12.tick(var1, var20, var21);
            }
         }

         this.I_field_f94488a1.I_method_9a6c9c54(var1, var2, var3);
      }
   }

   private int I_method_814bf932() {
      for (int var1 = this.I_field_7865b31.size() - 1; var1 >= 0; var1--) {
         iiI_Class7 var2 = this.I_field_7865b31.get(var1);
         if (var2.isModal() && var2.inFlow()) {
            return var1;
         }
      }

      return 0;
   }

   iII_Class5 I_method_485b50f5() {
      return this.I_field_b583e68c;
   }

   boolean I_method_814bf943() {
      return this.i_field_5a && this.IiI_field_46 > this.iII_field_46 + 0.5F;
   }

   float I_method_814bf92f() {
      return this.iiI_field_46;
   }

   float i_method_815a850f() {
      return this.iii_field_46;
   }

   float II_method_a84225f2() {
      return this.IIII_field_46;
   }

   float Ii_method_a850b1d2() {
      return this.IIIi_field_46;
   }

   float iI_method_aa051612() {
      return this.iII_field_46;
   }

   float ii_method_aa13a1f2() {
      return this.iIi_field_46;
   }

   float III_method_6011918f() {
      return this.IiI_field_46;
   }

   float IIi_method_60201d6f() {
      return this.i_field_46;
   }

   float IiI_method_61d481af() {
      return Math.max(0.0F, this.IiI_field_46 - this.iII_field_46);
   }

   void I_method_a8339661(float var1) {
      float var2 = this.IiI_method_61d481af();
      this.i_field_46 = Math.max(0.0F, Math.min(var1, var2));
      this.II_field_46 = this.i_field_46;
   }

   public float Iii_method_61e30d8f() {
      return this.i_field_46;
   }

   public void i_method_815a851f() {
      this.II_field_46 = 0.0F;
      this.I_field_f94488a1.I_method_af833bec();
   }

   public void i_method_a9f68681(float var1) {
      if (this.i_field_5a) {
         this.i_field_46 = this.II_field_46 = Math.max(0.0F, var1);
         this.I_field_f94488a1.I_method_af833bec();
      }
   }

   public void I_method_356cb059(iiI_Class7 var1, float var2) {
      if (this.i_field_5a && var1 != null) {
         boolean var3 = this.I_field_b583e68c.I_method_ade97d43();
         float var4 = var3 ? this.y.I_method_4e8b496f() + this.I_field_f935fcc1.I_field_46 : this.x.I_method_4e8b496f() + this.I_field_f935fcc1.Ii_field_46;
         float var5 = (var3 ? var1.y() : var1.x()) - var4;
         this.II_field_46 = Math.max(0.0F, Math.min(var5 - this.iIi_field_46 - var2, this.IiI_method_61d481af()));
         this.I_field_f94488a1.I_method_af833bec();
      }
   }

   private boolean I_method_7829c28b(iiI_Class7 var1, float var2, float var3) {
      if (!this.i_field_5a) {
         return true;
      } else {
         boolean var4 = this.I_field_b583e68c.I_method_ade97d43();
         float var5 = var1.isSticky() ? 0.0F : this.iIi_field_46;
         float var6 = this.iiI_field_46 + (var4 ? 0.0F : var5);
         float var7 = this.iii_field_46 + (var4 ? var5 : 0.0F);
         float var8 = this.IIII_field_46 - (var4 ? 0.0F : var5);
         float var9 = this.IIIi_field_46 - (var4 ? var5 : 0.0F);
         return var2 >= var6 && var2 <= var6 + var8 && var3 >= var7 && var3 <= var7 + var9;
      }
   }

   private void II_method_57518862() {
      float var1 = 0.0F;
      float var2 = 0.0F;

      for (iiI_Class7 var4 : this.I_field_7865b31) {
         if (var4.phase() != iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
            var4.measure();
            if (var4.inFlow()) {
               var1 = Math.max(var1, var4.desiredH());
               var2 = Math.max(var2, var4.desiredW());
            }
         }
      }

      this.IiI_field_46 = var1;
      this.Iii_field_46 = var2;
   }

   private void Ii_method_57601442() {
      float var1 = this.x.I_method_4e8b496f() + this.I_field_f935fcc1.Ii_field_46;
      float var2 = this.y.I_method_4e8b496f() + this.I_field_f935fcc1.I_field_46;
      float var3 = Math.max(0.0F, this.w.I_method_4e8b496f() - this.I_field_f935fcc1.I_method_b35d9ffc());
      float var4 = Math.max(0.0F, this.h.I_method_4e8b496f() - this.I_field_f935fcc1.i_method_b36c2bdc());
      this.iII_field_46 = var4;
      this.iiI_field_46 = var1;
      this.iii_field_46 = var2;
      this.IIII_field_46 = var3;
      this.IIIi_field_46 = var4;
      boolean var5 = this.I_method_a833e179(true);
      boolean var6 = this.I_method_a833e179(false);
      float var7 = 0.0F;
      float var8 = 0.0F;

      for (iiI_Class7 var10 : this.I_field_7865b31) {
         if (var10.inFlow()) {
            float var11 = !var10.fillW && this.I_field_b5755e8c != IIi_Class2.Ii_field_b5755e8c
               ? (var5 ? var10.desiredW() : Math.min(var3, var10.desiredW()))
               : var3;
            float var12 = var10.fillH ? var4 : (var6 ? var10.desiredH() : Math.min(var4, var10.desiredH()));
            if (this.snappedThisFrame()) {
               var10.forceSnap();
            }

            var10.setSlot(var1, var2, var11, var12);
            var7 = Math.max(var7, var12);
            var8 = Math.max(var8, var11);
         }
      }

      this.IiI_field_46 = var7;
      this.Iii_field_46 = var8;
   }

   private boolean I_method_a833e179(boolean var1) {
      return var1 ? !this.explicitW && !this.fillW && this.maxW == Float.MAX_VALUE : !this.explicitH && !this.fillH && this.maxH == Float.MAX_VALUE;
   }

   private boolean i_method_a9f6d199(boolean var1) {
      return var1 ? !this.explicitH && !this.fillH && this.maxH == Float.MAX_VALUE : !this.explicitW && !this.fillW && this.maxW == Float.MAX_VALUE;
   }

   private void iI_method_59147882() {
      if (this.II_field_5a) {
         this.Ii_method_57601442();
      } else {
         boolean var1 = this.I_field_b583e68c.I_method_ade97d43();
         float var2 = this.x.I_method_4e8b496f() + this.I_field_f935fcc1.Ii_field_46;
         float var3 = this.y.I_method_4e8b496f() + this.I_field_f935fcc1.I_field_46;
         float var4 = Math.max(0.0F, this.w.I_method_4e8b496f() - this.I_field_f935fcc1.I_method_b35d9ffc());
         float var5 = Math.max(0.0F, this.h.I_method_4e8b496f() - this.I_field_f935fcc1.i_method_b36c2bdc());
         float var6 = var1 ? var5 : var4;
         float var7 = var1 ? var4 : var5;
         this.iII_field_46 = var6;
         this.iiI_field_46 = var2;
         this.iii_field_46 = var3;
         this.IIII_field_46 = var4;
         this.IIIi_field_46 = var5;
         int var8 = Math.max(1, this.I_field_49);
         float var9 = (var7 - (var8 - 1) * this.I_field_46) / var8;
         if (var9 < 0.0F) {
            var9 = 0.0F;
         }

         ArrayList var10 = new ArrayList(this.I_field_7865b31.size());

         for (iiI_Class7 var12 : this.I_field_7865b31) {
            if (var12.inFlow()) {
               var10.add(var12);
            }
         }

         int var43 = var10.size();
         if (var43 == 0) {
            this.IiI_field_46 = 0.0F;
            this.Iii_field_46 = 0.0F;
         } else if (this.I_field_5a) {
            this.I_method_7e6464b8(var10, var1, var6, true, var2, var3);
         } else {
            int var44 = (var43 + var8 - 1) / var8;
            float[] var13 = new float[var44];
            float var14 = 0.0F;

            for (int var15 = 0; var15 < var43; var15++) {
               iiI_Class7 var16 = (iiI_Class7)var10.get(var15);
               int var17 = var15 / var8;
               float var18 = var1 ? var16.desiredH() : var16.desiredW();
               float var19 = var1 ? var16.desiredW() : var16.desiredH();
               var13[var17] = Math.max(var13[var17], var18);
               var14 = Math.max(var14, var19);
            }

            float var45 = (var44 - 1) * this.I_field_46;

            for (float var53 : var13) {
               var45 += var53;
            }

            this.IiI_field_46 = var45;
            this.Iii_field_46 = var8 * (this.I_field_b5755e8c == IIi_Class2.Ii_field_b5755e8c ? var9 : var14) + (var8 - 1) * this.I_field_46;
            if (!this.explicitW && !this.fillW && !this.explicitH && !this.fillH) {
               this.Iii_field_46 = var8 * var14 + (var8 - 1) * this.I_field_46;
            }

            float var47 = Math.max(0.0F, var6 - var45);
            int var49 = 0;
            if (var8 == 1) {
               for (iiI_Class7 var54 : (Iterable<iiI_Class7>)(Iterable<?>)var10) {
                  if (var1 ? var54.fillH : var54.fillW) {
                     var49++;
                  }
               }
            }

            float var52 = var49 > 0 && var47 > 0.0F ? var47 / var49 : 0.0F;
            if (var52 > 0.0F) {
               var47 = 0.0F;
            }

            float var55 = 1.0F;
            if (var8 == 1 && var49 > 0 && var45 > var6 && !this.i_method_a9f6d199(var1)) {
               float var20 = 0.0F;

               for (iiI_Class7 var22 : (Iterable<iiI_Class7>)(Iterable<?>)var10) {
                  if (var1 ? var22.fillH : var22.fillW) {
                     var20 += var1 ? var22.desiredH() : var22.desiredW();
                  }
               }

               float var57 = var45 - var6;
               if (var20 > 0.0F) {
                  var55 = Math.max(0.0F, (var20 - var57) / var20);
                  this.IiI_field_46 = var45 - Math.min(var57, var20);
               }
            }

            float var56 = 0.0F;
            float var58 = 0.0F;
            switch (this.I_field_f93600a1) {
               case i_field_f93600a1:
                  var56 = var47 / 2.0F;
                  break;
               case II_field_f93600a1:
                  var56 = var47;
                  break;
               case Ii_field_f93600a1:
                  var58 = var44 > 1 ? var47 / (var44 - 1) : 0.0F;
                  break;
               case iI_field_f93600a1:
                  var58 = var47 / var44;
                  var56 = var58 / 2.0F;
                  break;
               case ii_field_f93600a1:
                  var58 = var47 / (var44 + 1);
                  var56 = var58;
            }

            boolean var59 = this.I_method_a833e179(var1);
            float var23 = var56;

            for (int var24 = 0; var24 < var43; var24++) {
               iiI_Class7 var25 = (iiI_Class7)var10.get(var24);
               int var26 = var24 / var8;
               int var27 = var24 % var8;
               boolean var28 = var1 ? var25.fillW : var25.fillH;
               boolean var29 = var1 ? var25.fillH : var25.fillW;
               float var30 = var1 ? var25.desiredW() : var25.desiredH();
               float var31 = var27 * (var9 + this.I_field_46);
               float var32 = !var28 && this.I_field_b5755e8c != IIi_Class2.Ii_field_b5755e8c ? (var59 ? var30 : Math.min(var9, var30)) : var9;

               float var33 = switch (this.I_field_b5755e8c) {
                  case i_field_b5755e8c -> (var9 - var32) / 2.0F;
                  case II_field_b5755e8c -> var9 - var32;
                  default -> 0.0F;
               };
               float var34 = var31 + var33;
               float var35 = var29 ? var52 : 0.0F;
               float var36 = var29 ? var13[var26] * var55 : var13[var26];
               float var37 = var29 ? var36 + var35 : (var1 ? var25.desiredH() : var25.desiredW());
               float var38 = var23;
               if (this.I_field_b583e68c.II_method_f552206()) {
                  var38 = var6 - var23 - var37;
               }

               float var39;
               float var40;
               float var41;
               float var42;
               if (var1) {
                  var39 = var2 + var34;
                  var40 = var3 + var38;
                  var41 = var32;
                  var42 = var37;
               } else {
                  var39 = var2 + var38;
                  var40 = var3 + var34;
                  var41 = var37;
                  var42 = var32;
               }

               if (this.snappedThisFrame()) {
                  var25.forceSnap();
               }

               var25.setSlot(var39, var40, var41, var42);
               if (var27 == var8 - 1 || var24 == var43 - 1) {
                  var23 += var36 + var35 + this.I_field_46 + var58;
               }
            }
         }
      }
   }

   private void I_method_7e6464b8(List<iiI_Class7> var1, boolean var2, float var3, boolean var4, float var5, float var6) {
      float var7 = 0.0F;
      float var8 = 0.0F;
      float var9 = 0.0F;
      float var10 = 0.0F;
      boolean var11 = true;

      for (iiI_Class7 var13 : var1) {
         float var14 = var2 ? var13.desiredH() : var13.desiredW();
         float var15 = var2 ? var13.desiredW() : var13.desiredH();
         float var16 = var11 ? 0.0F : var7 + this.I_field_46;
         if (!var11 && var16 + var14 > var3) {
            var8 += var9 + this.I_field_46;
            var9 = 0.0F;
            var16 = 0.0F;
            var11 = true;
         }

         if (var4) {
            float var17;
            float var18;
            float var19;
            float var20;
            if (var2) {
               var17 = var5 + var8;
               var18 = var6 + var16;
               var19 = var15;
               var20 = var14;
            } else {
               var17 = var5 + var16;
               var18 = var6 + var8;
               var19 = var14;
               var20 = var15;
            }

            if (this.snappedThisFrame()) {
               var13.forceSnap();
            }

            var13.setSlot(var17, var18, var19, var20);
         }

         var7 = var16 + var14;
         var9 = Math.max(var9, var15);
         var10 = Math.max(var10, var7);
         var11 = false;
      }

      this.IiI_field_46 = var10;
      this.Iii_field_46 = var8 + var9;
   }

   @Override
   protected void drawSelf(III var1, float var2) {
      if (this.I_field_aad1658 != null) {
         ColorRGBA var3 = this.I_field_aad1658.apply(this);
         if (var3 != null && var3.getAlpha() > 0.0F) {
            if (this.ii_field_46 > 0.0F) {
               var1.drawSquircle(
                  this.x.I_method_4e8b496f(),
                  this.y.I_method_4e8b496f(),
                  this.w.I_method_4e8b496f(),
                  this.h.I_method_4e8b496f(),
                  this.ii_field_46,
                  this.I_field_2d98a52c,
                  var3
               );
            } else {
               var1.drawRoundedRect(
                  this.x.I_method_4e8b496f(), this.y.I_method_4e8b496f(), this.w.I_method_4e8b496f(), this.h.I_method_4e8b496f(), this.I_field_2d98a52c, var3
               );
            }
         }
      }

      if (this.I_field_65f5a247 != null) {
         this.I_field_65f5a247.paint(var1, this);
      }
   }

   @Override
   protected void drawChildren(III var1, float var2) {
      boolean var3 = this.I_field_b583e68c.I_method_ade97d43();
      float var4 = this.x.I_method_4e8b496f() + this.I_field_f935fcc1.Ii_field_46;
      float var5 = this.y.I_method_4e8b496f() + this.I_field_f935fcc1.I_field_46;
      float var6 = Math.max(0.0F, this.w.I_method_4e8b496f() - this.I_field_f935fcc1.I_method_b35d9ffc());
      float var7 = Math.max(0.0F, this.h.I_method_4e8b496f() - this.I_field_f935fcc1.i_method_b36c2bdc());
      float var8 = 0.0F;
      boolean var9 = false;

      for (iiI_Class7 var11 : this.I_field_7865b31) {
         if (var11.inFlow() && var11.isSticky()) {
            var9 = true;
            var8 += var3 ? var11.h() : var11.w();
         }
      }

      boolean var23 = this.i_field_5a;
      MatrixStack var24 = var1.getMatrices();
      if (var23) {
         float var12 = var4 + (var3 ? 0.0F : var8);
         float var13 = var5 + (var3 ? var8 : 0.0F);
         float var14 = Math.max(0.0F, var6 - (var3 ? 0.0F : var8));
         float var15 = Math.max(0.0F, var7 - (var3 ? var8 : 0.0F));
         iIiiiIiII_Class373.I_method_d5a5ee51(var24, var12, var13, var14, var15);
      }

      boolean var25 = this.i_field_46 != 0.0F;
      if (var25) {
         var24.push();
         var24.translate(var3 ? 0.0F : -this.i_field_46, var3 ? -this.i_field_46 : 0.0F, 0.0F);
      }

      float var26 = this.i_field_46 - this.iI_field_46;
      float var27 = this.i_field_46 + this.iII_field_46 + 24.0F;
      boolean var28 = this.i_field_5a && var3;
      boolean var16 = DRAW_CLIP;
      float var17 = DRAW_CLIP_MIN;
      float var18 = DRAW_CLIP_MAX;
      if (var28) {
         DRAW_CLIP = true;
         DRAW_CLIP_MIN = var5 + this.i_field_46 - this.iI_field_46;
         DRAW_CLIP_MAX = var5 + this.i_field_46 + this.iII_field_46 + 24.0F;
      }

      for (iiI_Class7 var20 : this.I_field_7865b31) {
         if (!var20.isSticky()) {
            float var21 = var3 ? var20.y() - var5 : var20.x() - var4;
            float var22 = var3 ? var20.h() : var20.w();
            if (!this.i_field_5a || !(var21 + var22 < var26) && !(var21 > var27)) {
               var20.draw(var1, var2);
            }
         }
      }

      if (var28) {
         DRAW_CLIP = var16;
         DRAW_CLIP_MIN = var17;
         DRAW_CLIP_MAX = var18;
      }

      if (var25) {
         var24.pop();
      }

      if (var23) {
         iIiiiIiII_Class373.I_method_ff80a1df();
      }

      if (var9) {
         if (var23) {
            iIiiiIiII_Class373.I_method_d5a5ee51(var24, var4, var5, var6, var7);
         }

         for (iiI_Class7 var30 : this.I_field_7865b31) {
            if (var30.isSticky()) {
               var30.draw(var1, var2);
            }
         }

         if (var23) {
            iIiiiIiII_Class373.I_method_ff80a1df();
         }
      }

      this.I_field_f94488a1.I_method_ea088746(var1, var2);
   }

   @Override
   public boolean mouseClicked(float var1, float var2, IiIII_Class9 var3) {
      if (!this.inFlow()) {
         return false;
      } else if (this.I_field_f94488a1.I_method_9a6ce76c(var1, var2, var3 == IiIII_Class9.I_field_2f4c8d6c)) {
         return true;
      } else if (!this.contains(var1, var2)) {
         return false;
      } else {
         int var4 = this.I_method_814bf932();

         for (int var5 = this.I_field_7865b31.size() - 1; var5 >= var4; var5--) {
            iiI_Class7 var6 = this.I_field_7865b31.get(var5);
            if (var6.inFlow() && var6.isSticky() && this.I_method_7829c28b(var6, var1, var2) && var6.mouseClicked(var1, var2, var3)) {
               return true;
            }
         }

         float var9 = var2;
         float var10 = var1;
         if (this.I_field_b583e68c.I_method_ade97d43()) {
            var9 = var2 + this.i_field_46;
         } else {
            var10 = var1 + this.i_field_46;
         }

         for (int var7 = this.I_field_7865b31.size() - 1; var7 >= var4; var7--) {
            iiI_Class7 var8 = this.I_field_7865b31.get(var7);
            if (var8.inFlow() && !var8.isSticky() && this.I_method_7829c28b(var8, var1, var2) && var8.mouseClicked(var10, var9, var3)) {
               return true;
            }
         }

         return super.mouseClicked(var1, var2, var3);
      }
   }

   @Override
   public void mouseReleased(float var1, float var2, IiIII_Class9 var3) {
      super.mouseReleased(var1, var2, var3);
      this.I_field_f94488a1.i_method_af91c7cc();
      float var4 = var2;
      float var5 = var1;
      if (this.I_field_b583e68c.I_method_ade97d43()) {
         var4 = var2 + this.i_field_46;
      } else {
         var5 = var1 + this.i_field_46;
      }

      for (iiI_Class7 var7 : this.I_field_7865b31) {
         if (var7.isSticky()) {
            var7.mouseReleased(var1, var2, var3);
         } else {
            var7.mouseReleased(var5, var4, var3);
         }
      }
   }

   @Override
   public boolean keyPressed(int var1, int var2, int var3) {
      if (!this.inFlow()) {
         return false;
      } else {
         int var4 = this.I_field_7865b31.size() - 1;

         for (int var5 = this.I_method_814bf932(); var4 >= var5; var4--) {
            if (this.I_field_7865b31.get(var4).keyPressed(var1, var2, var3)) {
               return true;
            }
         }

         return false;
      }
   }

   @Override
   public boolean keyReleased(int var1, int var2, int var3) {
      if (!this.inFlow()) {
         return false;
      } else {
         int var4 = this.I_field_7865b31.size() - 1;

         for (int var5 = this.I_method_814bf932(); var4 >= var5; var4--) {
            if (this.I_field_7865b31.get(var4).keyReleased(var1, var2, var3)) {
               return true;
            }
         }

         return false;
      }
   }

   @Override
   public boolean charTyped(char var1, int var2) {
      if (!this.inFlow()) {
         return false;
      } else {
         int var3 = this.I_field_7865b31.size() - 1;

         for (int var4 = this.I_method_814bf932(); var3 >= var4; var3--) {
            if (this.I_field_7865b31.get(var3).charTyped(var1, var2)) {
               return true;
            }
         }

         return false;
      }
   }

   @Override
   public boolean mouseScrolled(float var1, float var2, float var3, float var4) {
      if (this.inFlow() && this.contains(var1, var2)) {
         float var5 = var2;
         float var6 = var1;
         if (this.I_field_b583e68c.I_method_ade97d43()) {
            var5 = var2 + this.i_field_46;
         } else {
            var6 = var1 + this.i_field_46;
         }

         int var7 = this.I_method_814bf932();

         for (int var8 = this.I_field_7865b31.size() - 1; var8 >= var7; var8--) {
            iiI_Class7 var9 = this.I_field_7865b31.get(var8);
            float var10 = var9.isSticky() ? var1 : var6;
            float var11 = var9.isSticky() ? var2 : var5;
            if (var9.mouseScrolled(var10, var11, var3, var4)) {
               return true;
            }
         }

         if (var7 > 0) {
            return true;
         } else if (this.i_field_5a && this.IiI_field_46 > this.iII_field_46 + 0.5F) {
            float var12 = this.I_field_b583e68c.I_method_ade97d43() ? var4 : var3;
            this.II_field_46 -= var12 * 22.0F;
            this.I_field_f94488a1.I_method_af833bec();
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public interface Nested1_b548540 {
      void paint(III var1, iii_Class8 var2);
   }
}
