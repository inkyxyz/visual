package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

public class iIIiIiii_Class152 {
   private final List<IiiIiiIii_Class220<?>> I_field_7865b31 = new ArrayList<>();
   private final ButtonSetting I_field_bbd4b28c;
   private final iI_Class3 I_field_502d8b81;
   private final iIiIIiII_Class165 I_field_66c31ba1;
   private boolean I_field_5a = false;

   public iIIiIiii_Class152(iIiIIiII_Class165 var1, Runnable var2) {
      this.I_field_66c31ba1 = var1;
      this.I_field_502d8b81 = new iI_Class3() {
         @Override
         protected void i_method_bdd4e0ec(III var1) {
         }
      };

      for (Setting var4 : var1.getSettings()) {
         IiiIiiIii_Class220 var5 = iIIiIIIiI_Class291.I_method_ddfca5e(var4, this.I_field_502d8b81);
         if (var5 != null) {
            this.I_field_7865b31.add(var5);
         }
      }

      this.I_field_bbd4b28c = new ButtonSetting(new IIiiiIIiI_Class115() {
         private final List<Setting> I_field_7865b31 = new ArrayList<>();

         @Override
         public List<Setting> getSettings() {
            return this.I_field_7865b31;
         }
      }, "macro.delete").I_method_f05556b3(var2);
      IiiIiiIii_Class220 var6 = iIIiIIIiI_Class291.I_method_ddfca5e(this.I_field_bbd4b28c, this.I_field_502d8b81);
      if (var6 != null) {
         this.I_field_7865b31.add(var6);
      }
   }

   public int I_method_5ebc509f() {
      return this.I_field_66c31ba1.I_method_75fee8ff();
   }

   public void I_method_78ce37d7(int var1) {
      this.I_field_66c31ba1.I_method_49deab77(var1);
   }

   public float I_method_5ebc509c() {
      float var1 = 0.0F;

      for (IiiIiiIii_Class220 var3 : this.I_field_7865b31) {
         var1 += var3.Ii_method_2047ead7();
      }

      return var1;
   }

   public boolean I_method_5ebc50b0() {
      return this.I_field_5a;
   }

   public void I_method_78ce77a8(boolean var1) {
      this.I_field_5a = var1;
   }

   @Generated
   public List<IiiIiiIii_Class220<?>> I_method_35a0941b() {
      return this.I_field_7865b31;
   }

   @Generated
   public ButtonSetting I_method_7e08a362() {
      return this.I_field_bbd4b28c;
   }

   @Generated
   public iI_Class3 I_method_34d3f6b() {
      return this.I_field_502d8b81;
   }

   @Generated
   public iIiIIiII_Class165 I_method_5c82b80b() {
      return this.I_field_66c31ba1;
   }
}
