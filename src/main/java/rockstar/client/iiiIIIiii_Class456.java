package rockstar.client;

import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;

public final class iiiIIIiii_Class456 {
   private final iiiIIIiiI_Class455 I_field_f87a4e6c;
   @Nullable
   private final iiiIIiiii_Class464 I_field_fa3d426c;
   private int I_field_49 = 0;
   private static final int i_field_49 = 60;
   private static final double I_field_44 = 0.9;
   private double i_field_44;
   private double II_field_44;
   private double Ii_field_44;
   private int II_field_49 = -1;
   private int Ii_field_49;
   private boolean I_field_5a;

   public iiiIIIiii_Class456(iiiIIIiiI_Class455 var1, @Nullable iiiIIiiii_Class464 var2) {
      this.I_field_f87a4e6c = var1;
      this.I_field_fa3d426c = var2;
   }

   public iiiIIIiii_Class456.Nested1_98c1c480 I_method_a5c86c30() {
      if (this.I_field_f87a4e6c.i_method_6a8fca68().isEmpty()) {
         return iiiIIIiii_Class456.Nested1_98c1c480.i_field_c32ea207;
      } else if (this.I_field_49 >= this.I_field_f87a4e6c.i_method_6a8fca68().size()) {
         return iiiIIIiii_Class456.Nested1_98c1c480.i_field_c32ea207;
      } else {
         this.i_method_7d8dfddf();
         if (this.I_field_49 >= this.I_field_f87a4e6c.i_method_6a8fca68().size()) {
            return iiiIIIiii_Class456.Nested1_98c1c480.i_field_c32ea207;
         } else {
            ClientPlayerEntity var1 = MinecraftClient.getInstance().player;
            if (var1 != null && this.I_method_820e0f06(var1)) {
               this.I_field_f87a4e6c.i_method_6a8fca68().get(this.I_field_49).I_method_37257dff();
               this.II_method_327dc542();
               return iiiIIIiii_Class456.Nested1_98c1c480.II_field_c32ea207;
            } else {
               this.I_method_7d7f71ff();
               int var2 = 16;

               while (var2-- > 0) {
                  iiiIiIIII_Class465 var3 = this.I_field_f87a4e6c.i_method_6a8fca68().get(this.I_field_49);
                  iiiIiIIII_Class465.Nested1_33b738a0 var4 = var3.I_method_8cdd8810();
                  switch (var4) {
                     case I_field_86e7b1e7:
                        return iiiIIIiii_Class456.Nested1_98c1c480.I_field_c32ea207;
                     case i_field_86e7b1e7:
                        this.I_field_49++;
                        if (this.I_field_49 >= this.I_field_f87a4e6c.i_method_6a8fca68().size()) {
                           return iiiIIIiii_Class456.Nested1_98c1c480.i_field_c32ea207;
                        }

                        this.I_method_7d7f71ff();
                        break;
                     case II_field_86e7b1e7:
                        var3.I_method_37257dff();
                        return iiiIIIiii_Class456.Nested1_98c1c480.II_field_c32ea207;
                  }
               }

               return iiiIIIiii_Class456.Nested1_98c1c480.I_field_c32ea207;
            }
         }
      }
   }

   private void I_method_7d7f71ff() {
      int var1 = Math.min(this.I_field_49 + 6, this.I_field_f87a4e6c.i_method_6a8fca68().size());

      for (int var2 = this.I_field_49; var2 < var1; var2++) {
         iiiIiIIII_Class465 var3 = this.I_field_f87a4e6c.i_method_6a8fca68().get(var2);
         iiiIiIIII_Class465 var4 = var2 + 1 < this.I_field_f87a4e6c.i_method_6a8fca68().size() ? this.I_field_f87a4e6c.i_method_6a8fca68().get(var2 + 1) : null;
         var3.I_method_6d6ea8a7(var4);
      }
   }

   private void i_method_7d8dfddf() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      if (var2 != null) {
         double var3 = var2.getX();
         double var5 = var2.getY();
         double var7 = var2.getZ();
         int var9 = 8;

         while (var9-- > 0 && this.I_field_49 + 1 < this.I_field_f87a4e6c.i_method_6a8fca68().size()) {
            iiiIiIIII_Class465 var10 = this.I_field_f87a4e6c.i_method_6a8fca68().get(this.I_field_49);
            iiiIiIIII_Class465 var11 = this.I_field_f87a4e6c.i_method_6a8fca68().get(this.I_field_49 + 1);
            double var12 = I_method_e3b1c095(var3, var5, var7, var10.i_method_5e5afeb5());
            double var14 = I_method_e3b1c095(var3, var5, var7, var11.I_method_48c58ad5());
            double var16 = I_method_e3b1c095(var3, var5, var7, var11.i_method_5e5afeb5());
            boolean var18 = var14 < 0.36;
            boolean var19 = var16 < 0.36;
            boolean var20 = var16 + 0.25 < var12;
            if (!var18 && !var19 && !var20) {
               break;
            }

            var10.I_method_37257dff();
            this.I_field_49++;
         }
      }
   }

   private boolean I_method_820e0f06(ClientPlayerEntity var1) {
      if (this.I_field_5a && this.I_field_49 == this.II_field_49) {
         double var2 = var1.getX() - this.i_field_44;
         double var4 = var1.getY() - this.II_field_44;
         double var6 = var1.getZ() - this.Ii_field_44;
         if (var2 * var2 + var4 * var4 + var6 * var6 > 0.81) {
            this.I_method_820e0f02(var1);
            return false;
         } else {
            iiiIiIIII_Class465 var8 = this.I_method_5aae9eb5();
            int var9 = Math.max(60, var8 != null ? var8.I_method_37257df2() : 0);
            return ++this.Ii_field_49 >= var9;
         }
      } else {
         this.I_method_820e0f02(var1);
         return false;
      }
   }

   private void I_method_820e0f02(ClientPlayerEntity var1) {
      this.i_field_44 = var1.getX();
      this.II_field_44 = var1.getY();
      this.Ii_field_44 = var1.getZ();
      this.II_field_49 = this.I_field_49;
      this.Ii_field_49 = 0;
      this.I_field_5a = true;
   }

   private void II_method_327dc542() {
      this.I_field_5a = false;
      this.II_field_49 = -1;
      this.Ii_field_49 = 0;
   }

   private static double I_method_e3b1c095(double var0, double var2, double var4, iiiIIiIIi_Class458 var6) {
      double var7 = var0 - (var6.I_method_6d204e12() + 0.5);
      double var9 = var2 - var6.i_method_6d2ed9f2();
      double var11 = var4 - (var6.II_method_36f86d15() + 0.5);
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public iiiIiIIII_Class465 I_method_5aae9eb5() {
      return this.I_field_49 >= this.I_field_f87a4e6c.i_method_6a8fca68().size() ? null : this.I_field_f87a4e6c.i_method_6a8fca68().get(this.I_field_49);
   }

   public void I_method_326f40e4(int var1) {
      iiiIiIIII_Class465 var2 = this.I_method_5aae9eb5();
      if (var2 != null) {
         var2.I_method_37257dff();
      }

      this.I_field_49 = Math.max(0, Math.min(var1, this.I_field_f87a4e6c.i_method_6a8fca68().size()));
      this.II_method_327dc542();
   }

   @Generated
   public iiiIIIiiI_Class455 I_method_24228ed5() {
      return this.I_field_f87a4e6c;
   }

   @Nullable
   @Generated
   public iiiIIiiii_Class464 I_method_25e582d5() {
      return this.I_field_fa3d426c;
   }

   @Generated
   public int I_method_7d7f71f2() {
      return this.I_field_49;
   }

   public static enum Nested1_98c1c480 {
      I_field_c32ea207,
      i_field_c32ea207,
      II_field_c32ea207;

      public static iiiIIIiii_Class456.Nested1_98c1c480[] I_method_74c2f28() {
         return values();
      }

      public static iiiIIIiii_Class456.Nested1_98c1c480 I_method_deb94f35(String var0) {
         return Enum.valueOf(iiiIIIiii_Class456.Nested1_98c1c480.class, var0);
      }
   }
}
