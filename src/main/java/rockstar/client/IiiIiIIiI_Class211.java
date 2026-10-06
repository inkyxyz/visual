package rockstar.client;

import java.util.List;
import net.minecraft.client.MinecraftClient;

public interface IiiIiIIiI_Class211 {
   String I_method_8c872841();

   float I_method_9833b22f();

   float i_method_98423e0f();

   boolean I_method_9833b243();

   float II_method_6e518cf2();

   float Ii_method_6e6018d2();

   List<IiiIiIIiI_Class211.Nested1_972f6c40> I_method_cb1d7a28();

   default float iI_method_70147d12() {
      return this.I_method_9833b243() ? Math.max(0.0F, 1.0F - this.i_method_98423e0f()) : Math.min(1.0F, Math.max(0.0F, this.I_method_9833b22f()));
   }

   static IiiIiIIiI_Class211 I_method_cba96335() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      if ((var0 == null ? null : var0.currentScreen) instanceof IiiIiIIiI_Class211 var3) {
         return var3;
      } else {
         IiiIiIiii_Class216 var2 = IiiIiIiii_Class216.I_method_75b872b5();
         return (IiiIiIIiI_Class211)(var2 != null ? var2 : IiiIiIiiI_Class215.I_method_6fb072f5());
      }
   }

   public static final class Nested1_972f6c40 {
      private final String I_field_523beb0a;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;

      public Nested1_972f6c40(String var1, float var2, float var3, float var4, float var5) {
         this.I_field_523beb0a = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
      }

      @Override
      public final String toString() {
         return "Nested1_972f6c40[name=" + this.I_field_523beb0a + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", w=" + this.II_field_46 + ", h=" + this.Ii_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiIiIIiI_Class211.Nested1_972f6c40 other = (IiiIiIIiI_Class211.Nested1_972f6c40) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
      }

      public String I_method_2a715866() {
         return this.I_field_523beb0a;
      }

      public float I_method_49743f6a() {
         return this.I_field_46;
      }

      public float i_method_4982cb4a() {
         return this.i_field_46;
      }

      public float II_method_e522a717() {
         return this.II_field_46;
      }

      public float Ii_method_e53132f7() {
         return this.Ii_field_46;
      }
   }
}
