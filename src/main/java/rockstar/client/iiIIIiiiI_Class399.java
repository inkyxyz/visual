package rockstar.client;

import net.minecraft.util.Identifier;

public final class iiIIIiiiI_Class399 {
   private final Identifier I_field_6a3d6525;
   private final float I_field_46;
   private final float i_field_46;
   private final float II_field_46;
   private final float Ii_field_46;
   private final int I_field_49;
   private final int i_field_49;

   public iiIIIiiiI_Class399(Identifier var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      this.I_field_6a3d6525 = var1;
      this.I_field_46 = var2;
      this.i_field_46 = var3;
      this.II_field_46 = var4;
      this.Ii_field_46 = var5;
      this.I_field_49 = var6;
      this.i_field_49 = var7;
   }

   @Override
   public final String toString() {
      return "iiIIIiiiI_Class399[texture=" + this.I_field_6a3d6525 + ", u1=" + this.I_field_46 + ", v1=" + this.i_field_46 + ", u2=" + this.II_field_46 + ", v2=" + this.Ii_field_46 + ", width=" + this.I_field_49 + ", height=" + this.i_field_49 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.I_field_6a3d6525);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
      result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
      result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
      result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
      result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      iiIIIiiiI_Class399 other = (iiIIIiiiI_Class399) var1;
      return java.util.Objects.equals(this.I_field_6a3d6525, other.I_field_6a3d6525)
         && java.util.Objects.equals(this.I_field_46, other.I_field_46)
         && java.util.Objects.equals(this.i_field_46, other.i_field_46)
         && java.util.Objects.equals(this.II_field_46, other.II_field_46)
         && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
         && java.util.Objects.equals(this.I_field_49, other.I_field_49)
         && java.util.Objects.equals(this.i_field_49, other.i_field_49);
   }

   public Identifier I_method_b91e816e() {
      return this.I_field_6a3d6525;
   }

   public float I_method_d93d924f() {
      return this.I_field_46;
   }

   public float i_method_d94c1e2f() {
      return this.i_field_46;
   }

   public float II_method_4e83b0d2() {
      return this.II_field_46;
   }

   public float Ii_method_4e923cb2() {
      return this.Ii_field_46;
   }

   public int I_method_d93d9252() {
      return this.I_field_49;
   }

   public int i_method_d94c1e32() {
      return this.i_field_49;
   }
}
