package rockstar.client;

import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.InputEvent;

public final class iiIiiiiii_Class448 {
   boolean I_field_5a;
   boolean i_field_5a;
   boolean II_field_5a;
   boolean Ii_field_5a;
   boolean iI_field_5a;
   boolean ii_field_5a;
   boolean III_field_5a;
   boolean IIi_field_5a;
   private boolean IiI_field_5a;
   private final IiIIIiII_Class69<InputEvent> I_field_3d936f41 = new IiIIIiII_Class69<InputEvent>() {
      public void onEvent(InputEvent var1) {
         if (iiIiiiiii_Class448.this.IIi_field_5a) {
            float var2 = (iiIiiiiii_Class448.this.I_field_5a ? 1.0F : 0.0F) + (iiIiiiiii_Class448.this.i_field_5a ? -1.0F : 0.0F);
            float var3 = (iiIiiiiii_Class448.this.II_field_5a ? 1.0F : 0.0F) + (iiIiiiiii_Class448.this.Ii_field_5a ? -1.0F : 0.0F);
            var1.setForward(var2);
            var1.setStrafe(var3);
            var1.setJump(iiIiiiiii_Class448.this.iI_field_5a);
            var1.setSneak(iiIiiiiii_Class448.this.ii_field_5a);
            var1.setSprint(iiIiiiiii_Class448.this.III_field_5a);
         }
      }

      @Override
      public int I_method_f12c6485() {
         return 100;
      }
   };
   private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41 = var1 -> {
      if (this.IIi_field_5a && this.III_field_5a && this.I_field_5a) {
         this.II_method_7e161d02();
      } else if (this.IiI_field_5a) {
         this.Ii_method_7e24a8e2();
      }
   };

   public void I_method_7e07d875(boolean var1) {
      this.I_field_5a = var1;
   }

   public void i_method_7fcac895(boolean var1) {
      this.i_field_5a = var1;
   }

   public void II_method_44ae3612(boolean var1) {
      this.II_field_5a = var1;
   }

   public void Ii_method_46712632(boolean var1) {
      this.Ii_field_5a = var1;
   }

   public void iI_method_7b4949f2(boolean var1) {
      this.iI_field_5a = var1;
   }

   public void ii_method_7d0c3a12(boolean var1) {
      this.ii_field_5a = var1;
   }

   public void III_method_52d38c15(boolean var1) {
      this.III_field_5a = var1;
   }

   public void I_method_359d223f() {
      this.IIi_field_5a = true;
   }

   public void i_method_35abae1f() {
      this.IIi_field_5a = false;
      this.I_field_5a = this.i_field_5a = this.II_field_5a = this.Ii_field_5a = this.iI_field_5a = this.ii_field_5a = this.III_field_5a = false;
      this.Ii_method_7e24a8e2();
   }

   private void II_method_7e161d02() {
      if (!this.IiI_field_5a) {
         MinecraftClient var1 = MinecraftClient.getInstance();
         if (var1.options != null && var1.options.sprintKey != null) {
            var1.options.sprintKey.setPressed(true);
            this.IiI_field_5a = true;
         }
      }
   }

   private void Ii_method_7e24a8e2() {
      if (this.IiI_field_5a) {
         MinecraftClient var1 = MinecraftClient.getInstance();
         if (var1.options != null && var1.options.sprintKey != null) {
            var1.options.sprintKey.setPressed(false);
         }

         this.IiI_field_5a = false;
      }
   }

   public static iiIiiiiii_Class448 I_method_b7c1f75d(iiIiiIiIi_Class438 var0) {
      iiIiiiiii_Class448 var1 = new iiIiiiiii_Class448();
      var0.I_method_ab199998().I_method_2257cd48(var1);
      return var1;
   }

   @Generated
   public boolean I_method_359d2243() {
      return this.I_field_5a;
   }

   @Generated
   public boolean i_method_35abae23() {
      return this.i_field_5a;
   }

   @Generated
   public boolean II_method_7e161d06() {
      return this.II_field_5a;
   }

   @Generated
   public boolean Ii_method_7e24a8e6() {
      return this.Ii_field_5a;
   }

   @Generated
   public boolean iI_method_7fd90d26() {
      return this.iI_field_5a;
   }

   @Generated
   public boolean ii_method_7fe79906() {
      return this.ii_field_5a;
   }

   @Generated
   public boolean III_method_44bc7aa3() {
      return this.III_field_5a;
   }

   @Generated
   public boolean IIi_method_44cb0683() {
      return this.IIi_field_5a;
   }
}
