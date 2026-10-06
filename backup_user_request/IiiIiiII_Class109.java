package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.item.ItemStack;
import pyrock.utility.render.ColorRGBA;

public class IiiIiiII_Class109 {
   private final float I_field_46 = 10.0F;
   private final float i_field_46 = 24.0F;
   private final float II_field_46 = 5.0F;
   private final List<IiiIiiII_Class109.Nested1_a38a2cd3> I_field_7865b31 = new ArrayList<>();
   private float Ii_field_46;
   private float iI_field_46;
   private float ii_field_46;
   private float III_field_46;
   private float IIi_field_46 = 20.0F;
   private float IiI_field_46 = 0.0F;
   private float Iii_field_46 = 0.0F;

   public boolean I_method_c0b98dde(III var1, float var2, float var3, float var4, float var5) {
      this.Ii_field_46 = var2;
      this.iI_field_46 = var3;
      this.ii_field_46 = var4;
      this.III_field_46 = var5;
      this.I_method_4d23c4cc();
      this.i_method_4d3250ac();
      if (this.I_field_7865b31.isEmpty()) {
         return false;
      } else {
         this.I_method_c0b98dda(var1, var2, var3, var4, var5);
         var1.drawText(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
            "\u0421\u043a\u0443\u043f\u043a\u0430",
            var2 + 10.0F,
            var3 + 10.0F,
            IiiiiIIIi_Class242.Ii_field_d0c8ec5
         );
         this.I_method_baac445a(var1, var2, var3);
         return true;
      }
   }

   public void I_method_4d23c4cc() {
      this.I_field_7865b31.clear();
      IiiIIiIi_Class102.I_method_2a0b303b()
         .stream()
         .filter(var0 -> var0.I_method_2478c0b1() != null && !var0.I_method_2478c0b1().isEmpty())
         .forEach(
            var1 -> this.I_field_7865b31
               .add(
                  new IiiIiiII_Class109.Nested1_a38a2cd3(
                     var1.I_method_2478c0b1(),
                     var1.I_method_18d43a5b(),
                     var1.I_method_96d2f519(),
                     var1.i_method_29f1a539(),
                     var1.I_method_b49c50b(),
                     var1.I_method_18d43a55()
                  )
               )
         );
   }

   private void I_method_c0b98dda(III var1, float var2, float var3, float var4, float var5) {
      var1.drawBlurredRect(var2, var3, var4, var5, 45.0F, 5.0F, IIiii_Class8.I_method_893b2757(8.0F), ColorRGBA.WHITE.withAlpha(255.0F));
      var1.drawSquircle(
         var2,
         var3,
         var4,
         var5,
         2.0F,
         IIiii_Class8.I_method_893b2757(8.0F),
         IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0F * IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2())
      );
   }

   public void I_method_baac445a(III var1, float var2, float var3) {
      float var4 = var2 + 10.0F;
      float var5 = var3 + 26.0F;
      float var6 = this.III_field_46 - 26.0F;
      int var7 = Math.max(1, (int)((this.ii_field_46 - 20.0F) / (16.0F + this.IIi_field_46)));
      float var8 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_a649725c() * 2.0F + 3.0F;
      float var9 = (16.0F - var8) / 2.0F;
      iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var2, var5, this.ii_field_46, var6);
      int var10 = 0;

      for (IiiIiiII_Class109.Nested1_a38a2cd3 var12 : this.I_field_7865b31) {
         if (!var12.I_method_b8247451().isEmpty()) {
            int var13 = var10 / var7;
            int var14 = var10 % var7;
            float var15 = var4 + var14 * (16.0F + this.IIi_field_46);
            float var16 = var5 + var13 * 24.0F - this.IiI_field_46;
            if (this.I_method_d704e778(var16, var5, var6)) {
               this.I_method_fa5703aa(var1, var12, var15, var16, var9);
            }

            var10++;
         }
      }

      iIiiiIiII_Class373.I_method_ff80a1df();
   }

   private void I_method_fa5703aa(III var1, IiiIiiII_Class109.Nested1_a38a2cd3 var2, float var3, float var4, float var5) {
      String var6 = var2.I_method_e4b718b9() != null ? var2.I_method_e4b718b9() : var2.I_method_b8247451().getName().getString();
      String var7;
      if (var2.I_method_9f8de0ab() == IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc) {
         var7 = "\u0434\u043e " + var2.I_method_82a9e2bb();
      } else {
         var7 = "-" + (int)var2.I_method_82a9e2b5() + "% \u0440\u044b\u043d\u043a\u0430";
      }

      var1.drawItem(var2.I_method_b8247451(), var3, var4, 1.0F);
      var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var6, var3 + 20.0F, var4 + var5, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
      var1.drawText(
         IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
         var7,
         var3 + 20.0F,
         var4 + var5 + IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_a649725c() + 3.0F,
         IiiiiIIIi_Class242.Ii_field_d0c8ec5
      );
   }

   private boolean I_method_d704e778(float var1, float var2, float var3) {
      return var1 + 24.0F >= var2 && var1 <= var2 + var3;
   }

   private void I_method_935416e9(int var1, float var2) {
      float var3 = this.I_field_7865b31.isEmpty() ? 0.0F : (float)(this.I_field_7865b31.size() + var1 - 1) / var1 * 24.0F;
      this.Iii_field_46 = Math.max(0.0F, var3 - var2);
      this.IiI_field_46 = Math.max(0.0F, Math.min(this.IiI_field_46, this.Iii_field_46));
   }

   private void i_method_4d3250ac() {
      float var1 = 0.0F;

      for (IiiIiiII_Class109.Nested1_a38a2cd3 var3 : this.I_field_7865b31) {
         if (!var3.I_method_b8247451().isEmpty()) {
            String var4 = var3.I_method_e4b718b9() != null ? var3.I_method_e4b718b9() : var3.I_method_b8247451().getName().getString();
            String var5;
            if (var3.I_method_9f8de0ab() == IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc) {
               var5 = "\u0434\u043e " + var3.I_method_82a9e2bb();
            } else {
               var5 = "-" + (int)var3.I_method_82a9e2b5() + "% \u0440\u044b\u043d\u043a\u0430";
            }

            float var6 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_2c375926(var4);
            float var7 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_2c375926(var5);
            var1 = Math.max(var1, Math.max(var6, var7));
         }
      }

      this.IIi_field_46 = 20.0F + var1 + 5.0F;
   }

   public float I_method_4d23c4bc() {
      if (this.I_field_7865b31.isEmpty()) {
         return 150.0F;
      } else {
         float var1 = 0.0F;

         for (IiiIiiII_Class109.Nested1_a38a2cd3 var3 : this.I_field_7865b31) {
            if (!var3.I_method_b8247451().isEmpty()) {
               String var4 = var3.I_method_e4b718b9() != null ? var3.I_method_e4b718b9() : var3.I_method_b8247451().getName().getString();
               String var5;
               if (var3.I_method_9f8de0ab() == IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc) {
                  var5 = "\u0434\u043e " + var3.I_method_82a9e2bb();
               } else {
                  var5 = "-" + (int)var3.I_method_82a9e2b5() + "% \u0440\u044b\u043d\u043a\u0430";
               }

               float var6 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_2c375926(var4);
               float var7 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_2c375926(var5);
               var1 = Math.max(var1, Math.max(var6, var7));
            }
         }

         float var8 = 36.0F + var1 + 5.0F;
         float var9 = 20.0F + var8;
         float var10 = 20.0F + var8 * 2.0F;
         return Math.max(var9, Math.min(var10, 300.0F));
      }
   }

   public void I_method_d6e7c832(double var1, double var3, double var5) {
      if (iIIiIIIiI_Class291.I_method_c3f86263(this.Ii_field_46, this.iI_field_46, this.ii_field_46, this.III_field_46, var1, var3)) {
         this.IiI_field_46 -= (float)var5 * 20.0F;
         this.IiI_field_46 = Math.max(0.0F, Math.min(this.IiI_field_46, this.Iii_field_46));
      }
   }

   public float I_method_57553c64(float var1) {
      int var2 = Math.max(1, (int)((this.ii_field_46 - 20.0F) / (16.0F + this.IIi_field_46)));
      if (this.I_field_7865b31.isEmpty()) {
         return Math.min(50.0F, var1);
      } else {
         int var3 = (this.I_field_7865b31.size() + var2 - 1) / var2;
         float var4 = 26.0F + var3 * 24.0F + 10.0F;
         return Math.min(var4, var1);
      }
   }

   public void I_method_5b2cc9a(double var1, double var3, IiIII_Class9 var5) {
      if (var5 == IiIII_Class9.i_field_2f4c8d6c) {
         int var6 = Math.max(1, (int)((this.ii_field_46 - 20.0F) / (16.0F + this.IIi_field_46)));
         float var7 = this.III_field_46 - 26.0F;
         int var8 = 0;

         for (IiiIiiII_Class109.Nested1_a38a2cd3 var10 : this.I_field_7865b31) {
            if (!var10.I_method_b8247451().isEmpty()) {
               int var11 = var8 / var6;
               int var12 = var8 % var6;
               float var13 = this.Ii_field_46 + 10.0F + var12 * (16.0F + this.IIi_field_46);
               float var14 = this.iI_field_46 + 26.0F + var11 * 24.0F - this.IiI_field_46;
               if (this.I_method_d704e778(var14, this.iI_field_46 + 26.0F, var7)
                  && iIIiIIIiI_Class291.I_method_c3f86263(var13, var14, 36.0F + this.IIi_field_46 - 5.0F, 24.0, var1, var3)) {
                  IiiIIiIi_Class102.I_method_99d59756(var10.i_method_77d5c8d9());
                  return;
               }

               var8++;
            }
         }
      }
   }

   @Generated
   public List<IiiIiiII_Class109.Nested1_a38a2cd3> I_method_171e5bfb() {
      return this.I_field_7865b31;
   }

   public static final class Nested1_a38a2cd3 {
      private final ItemStack I_field_f2735522;
      private final long I_field_4a;
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;
      private final IiiIIiIi_Class102.Nested1_6cef9113 I_field_af10c1bc;
      private final double I_field_44;

      public Nested1_a38a2cd3(ItemStack var1, long var2, String var4, String var5, IiiIIiIi_Class102.Nested1_6cef9113 var6, double var7) {
         this.I_field_f2735522 = var1;
         this.I_field_4a = var2;
         this.I_field_523beb0a = var4;
         this.i_field_523beb0a = var5;
         this.I_field_af10c1bc = var6;
         this.I_field_44 = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_a38a2cd3[item=" + this.I_field_f2735522 + ", maxPrice=" + this.I_field_4a + ", customName=" + this.I_field_523beb0a + ", id=" + this.i_field_523beb0a + ", mode=" + this.I_field_af10c1bc + ", percentage=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_af10c1bc);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiIiiII_Class109.Nested1_a38a2cd3 other = (IiiIiiII_Class109.Nested1_a38a2cd3) var1;
         return java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.I_field_af10c1bc, other.I_field_af10c1bc)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public ItemStack I_method_b8247451() {
         return this.I_field_f2735522;
      }

      public long I_method_82a9e2bb() {
         return this.I_field_4a;
      }

      public String I_method_e4b718b9() {
         return this.I_field_523beb0a;
      }

      public String i_method_77d5c8d9() {
         return this.i_field_523beb0a;
      }

      public IiiIIiIi_Class102.Nested1_6cef9113 I_method_9f8de0ab() {
         return this.I_field_af10c1bc;
      }

      public double I_method_82a9e2b5() {
         return this.I_field_44;
      }
   }
}
