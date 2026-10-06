package rockstar.client;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import moscow.rockstar.mixin.accessors.DrawContextAccessor;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import pyrock.utility.render.ColorRGBA;

public class iIIi_Class10<T> extends iiI_Class7 {
   private final Supplier<List<T>> I_field_11b14ee4;
   private final Function<T, ItemStack> I_field_aad1658;
   private final Predicate<T> I_field_93e25d0f;
   private final Consumer<T> I_field_f9f609fa;
   private float I_field_46 = 20.0F;
   private float i_field_46 = 2.0F;
   private float II_field_46 = 0.9F;
   private float Ii_field_46 = 4.0F;
   private float iI_field_46 = 2.0F;
   private float ii_field_46 = -1.0F;
   private Consumer<T> i_field_f9f609fa;
   private int I_field_49;
   private Function<iIIi_Class10<T>, ColorRGBA> i_field_aad1658 = var0 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5;
   private Function<iIIi_Class10<T>, ColorRGBA> II_field_aad1658 = var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.7F);
   private Function<iIIi_Class10<T>, ColorRGBA> Ii_field_aad1658 = var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5;
   private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(0.0F, IIii_Class4.I_method_3682ece9(260L, IiiiIiiII_Class237.IIii_field_dd60aac));
   private float III_field_46 = 0.0F;
   private float IIi_field_46 = 0.0F;
   private final Map<T, float[]> I_field_a567c40b = new IdentityHashMap<>();

   public iIIi_Class10(Supplier<List<T>> var1, Function<T, ItemStack> var2, Predicate<T> var3, Consumer<T> var4) {
      this.I_field_11b14ee4 = var1;
      this.I_field_aad1658 = var2;
      this.I_field_93e25d0f = var3;
      this.I_field_f9f609fa = var4;
      this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
   }

   public iIIi_Class10<T> I_method_4a1219ef(Consumer<T> var1) {
      this.i_field_f9f609fa = var1;
      return this;
   }

   public iIIi_Class10<T> I_method_c1659f40(int var1) {
      this.I_field_49 = var1;
      return this;
   }

   public iIIi_Class10<T> I_method_cd60f2a3(float var1) {
      this.I_field_46 = var1;
      return this;
   }

   public iIIi_Class10<T> i_method_88b5683(float var1) {
      this.i_field_46 = var1;
      return this;
   }

   public iIIi_Class10<T> II_method_a30a96ac(float var1) {
      this.II_field_46 = var1;
      return this;
   }

   public iIIi_Class10<T> Ii_method_de34fa8c(float var1) {
      this.Ii_field_46 = var1;
      return this;
   }

   public iIIi_Class10<T> iI_method_cd2caecc(float var1) {
      this.iI_field_46 = var1;
      return this;
   }

   public iIIi_Class10<T> ii_method_85712ac(float var1) {
      this.ii_field_46 = var1;
      return this;
   }

   public iIIi_Class10<T> I_method_dc0cc944(ColorRGBA var1) {
      this.i_field_aad1658 = var1x -> var1;
      return this;
   }

   public iIIi_Class10<T> I_method_f6c003d1(Function<iIIi_Class10<T>, ColorRGBA> var1) {
      this.i_field_aad1658 = var1;
      return this;
   }

   public iIIi_Class10<T> i_method_79afad24(ColorRGBA var1) {
      this.II_field_aad1658 = var1x -> var1;
      return this;
   }

   public iIIi_Class10<T> II_method_6ebc094d(ColorRGBA var1) {
      this.Ii_field_aad1658 = var1x -> var1;
      return this;
   }

   public iIIi_Class10<T> III_method_829573c3(float var1) {
      super.width(var1);
      return this;
   }

   public iIIi_Class10<T> IIi_method_bdbfd7a3(float var1) {
      super.height(var1);
      return this;
   }

   public iIIi_Class10<T> I_method_e56eeacb() {
      super.fillWidth();
      return this;
   }

   public iIIi_Class10<T> i_method_6b788aeb() {
      super.fillHeight();
      return this;
   }

   private float I_method_728693fc() {
      return this.I_field_46 - this.i_field_46 * 2.0F;
   }

   private int I_method_de4c5527(float var1) {
      return Math.max(1, (int)Math.floor((var1 - this.iI_field_46 * 2.0F) / this.I_field_46));
   }

   private int I_method_eb3eb8ff(float var1, float var2) {
      float var3 = this.x();
      float var4 = this.y();
      float var5 = this.w();
      float var6 = this.h();
      if (!(var1 < var3) && !(var1 > var3 + var5) && !(var2 < var4) && !(var2 > var4 + var6)) {
         List var7 = this.I_field_11b14ee4.get();
         int var8 = this.I_method_de4c5527(var5);
         float var9 = var8 * this.I_field_46;
         float var10 = var3 + (var5 - var9) / 2.0F;
         float var11 = var1 - var10;
         float var12 = var2 - var4 - this.iI_field_46 + this.I_field_b575d2cc.I_method_4e8b496f();
         if (!(var11 < 0.0F) && !(var12 < 0.0F)) {
            int var13 = (int)(var11 / this.I_field_46);
            int var14 = (int)(var12 / this.I_field_46);
            if (var13 >= 0 && var13 < var8) {
               int var15 = var14 * var8 + var13;
               return var15 >= 0 && var15 < var7.size() ? var15 : -1;
            } else {
               return -1;
            }
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   @Override
   protected void measure() {
      float var1 = this.w();
      float var2 = this.ii_field_46 > 0.0F ? this.ii_field_46 : var1;
      if (var1 < 4.0F) {
         if (!this.explicitH) {
            this.prefH = this.ii_field_46 > 0.0F ? this.ii_field_46 : 110.0F;
         }
      } else {
         int var3 = this.I_method_de4c5527(var1);
         int var4 = this.I_field_11b14ee4.get().size();
         int var5 = Math.max(1, (int)Math.ceil((float)var4 / var3));
         this.IIi_field_46 = var5 * this.I_field_46 + this.iI_field_46 * 2.0F;
         if (!this.explicitH) {
            this.prefH = Math.min(this.IIi_field_46, var2);
         }
      }
   }

   @Override
   protected void onTick(float var1, float var2, float var3) {
      float var4 = Math.max(0.0F, this.IIi_field_46 - this.h());
      this.III_field_46 = Math.max(0.0F, Math.min(this.III_field_46, var4));
      this.I_field_b575d2cc.I_method_82de4e21(this.III_field_46);
      this.I_field_b575d2cc.Ii_method_dc72325e(var1);
      int var5 = this.inFlow() && this.contains(var2, var3) ? this.I_method_eb3eb8ff(var2, var3) : -1;
      List var6 = this.I_field_11b14ee4.get();
      if (this.i_field_f9f609fa != null) {
         this.i_field_f9f609fa.accept((T)(var5 >= 0 && var5 < var6.size() ? var6.get(var5) : null));
      }

      float var7 = Math.min(1.0F, var1 / 1000.0F * 12.0F);

      for (int var8 = 0; var8 < var6.size(); var8++) {
         Object var9 = var6.get(var8);
         float[] var10 = this.I_method_627904f9((T)var9);
         float var11 = this.I_field_93e25d0f.test((T)var9) ? 1.0F : 0.0F;
         float var12 = var8 == var5 ? 1.0F : 0.0F;
         var10[0] += (var11 - var10[0]) * var7;
         var10[1] += (var12 - var10[1]) * var7;
      }
   }

   private float[] I_method_627904f9(T var1) {
      float[] var2 = this.I_field_a567c40b.get(var1);
      if (var2 == null) {
         var2 = new float[]{this.I_field_93e25d0f.test((T)var1) ? 1.0F : 0.0F, 0.0F};
         this.I_field_a567c40b.put((T)var1, var2);
      }

      return var2;
   }

   @Override
   protected void drawSelf(III var1, float var2) {
      List var3 = this.I_field_11b14ee4.get();
      int var4 = var3.size();
      float var5 = this.x();
      float var6 = this.y();
      float var7 = this.w();
      float var8 = this.h();
      int var9 = this.I_method_de4c5527(var7);
      float var10 = var9 * this.I_field_46;
      float var11 = var5 + (var7 - var10) / 2.0F;
      float var12 = this.I_field_b575d2cc.I_method_4e8b496f();
      float var13 = this.I_method_728693fc();
      IIiii_Class8 var14 = IIiii_Class8.I_method_893b2757(this.Ii_field_46);
      MatrixStack var15 = var1.getMatrices();
      iIiiiIiII_Class373.I_method_d5a5ee51(var15, var5, var6, var7, var8);
      ColorRGBA var16 = this.i_field_aad1658.apply(this);
      ColorRGBA var17 = this.II_field_aad1658.apply(this);

      for (int var18 = 0; var18 < var4; var18++) {
         float var19 = var11 + var18 % var9 * this.I_field_46;
         float var20 = var6 + this.iI_field_46 + var18 / var9 * this.I_field_46 - var12;
         if (!(var20 + this.I_field_46 < var6) && !(var20 > var6 + var8)) {
            float[] var21 = this.I_method_627904f9((T)var3.get(var18));
            ColorRGBA var22 = var16.mix(var17, var21[0]).mulAlpha(1.0F + 0.22F * var21[1]);
            var1.drawRoundedRect(var19 + this.i_field_46, var20 + this.i_field_46, var13, var13, var14, var22);
         }
      }

      if (this.I_field_49 != 0) {
         var15.push();
         var15.translate(0.0F, 0.0F, this.I_field_49);
      }

      for (int var23 = 0; var23 < var4; var23++) {
         float var25 = var11 + var23 % var9 * this.I_field_46;
         float var27 = var6 + this.iI_field_46 + var23 / var9 * this.I_field_46 - var12;
         if (!(var27 + this.I_field_46 < var6) && !(var27 > var6 + var8)) {
            float var29 = var25 + this.i_field_46 + var13 / 2.0F;
            float var31 = var27 + this.i_field_46 + var13 / 2.0F;
            iIiiiIIiI_Class371.II_method_e18635ac(var15, var29, var31, this.II_field_46 * var2);
            var1.drawBatchItem(this.I_field_aad1658.apply((T)var3.get(var23)), var29 - 8.0F, var31 - 8.0F);
            iIiiiIIiI_Class371.I_method_10503b11(var15);
            DiffuseLighting.disableGuiDepthLighting();
         }
      }

      if (this.I_field_49 != 0) {
         var15.pop();
      }

      ((DrawContextAccessor)(Object)var1).getVertexConsumers().draw();
      ColorRGBA var24 = this.Ii_field_aad1658.apply(this);

      for (int var26 = 0; var26 < var4; var26++) {
         float[] var28 = this.I_method_627904f9((T)var3.get(var26));
         if (!(var28[1] <= 0.01F)) {
            float var30 = var11 + var26 % var9 * this.I_field_46;
            float var32 = var6 + this.iI_field_46 + var26 / var9 * this.I_field_46 - var12;
            if (!(var32 + this.I_field_46 < var6) && !(var32 > var6 + var8)) {
               var1.drawRoundedBorder(var30 + this.i_field_46, var32 + this.i_field_46, var13, var13, 1.2F, var14, var24.mulAlpha(0.6F * var28[1]));
            }
         }
      }

      iIiiiIiII_Class373.I_method_ff80a1df();
   }

   @Override
   public boolean mouseClicked(float var1, float var2, IiIII_Class9 var3) {
      if (!this.inFlow() || !this.contains(var1, var2)) {
         return false;
      } else if (var3 != IiIII_Class9.I_field_2f4c8d6c) {
         return false;
      } else {
         int var4 = this.I_method_eb3eb8ff(var1, var2);
         if (var4 < 0) {
            return false;
         } else {
            this.I_field_f9f609fa.accept(this.I_field_11b14ee4.get().get(var4));
            return true;
         }
      }
   }

   @Override
   public boolean mouseScrolled(float var1, float var2, float var3, float var4) {
      if (this.inFlow() && this.contains(var1, var2)) {
         float var5 = Math.max(0.0F, this.IIi_field_46 - this.h());
         if (var5 <= 0.5F) {
            return false;
         } else {
            this.III_field_46 = Math.max(0.0F, Math.min(this.III_field_46 - var4 * 22.0F, var5));
            return true;
         }
      } else {
         return false;
      }
   }
}
