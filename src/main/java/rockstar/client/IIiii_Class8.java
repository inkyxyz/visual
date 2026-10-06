package rockstar.client;


public final class IIiii_Class8 {
   private final float I_field_46;
   private final float i_field_46;
   private final float II_field_46;
   private final float Ii_field_46;
   public static final IIiii_Class8 I_field_2d98a52c = new IIiii_Class8(0.0F, 0.0F, 0.0F, 0.0F);

   public IIiii_Class8(float var1, float var2, float var3, float var4) {
      this.I_field_46 = var1;
      this.i_field_46 = var2;
      this.II_field_46 = var3;
      this.Ii_field_46 = var4;
   }

   public static IIiii_Class8 I_method_893b2757(float var0) {
      return new IIiii_Class8(var0, var0, var0, var0);
   }

   public static IIiii_Class8 i_method_b35d3f77(float var0) {
      return new IIiii_Class8(var0, 0.0F, 0.0F, 0.0F);
   }

   public static IIiii_Class8 II_method_c7fa6e74(float var0) {
      return new IIiii_Class8(0.0F, var0, 0.0F, 0.0F);
   }

   public static IIiii_Class8 Ii_method_f21c8694(float var0) {
      return new IIiii_Class8(0.0F, 0.0F, var0, 0.0F);
   }

   public static IIiii_Class8 iI_method_e21b5a54(float var0) {
      return new IIiii_Class8(0.0F, 0.0F, 0.0F, var0);
   }

   public static IIiii_Class8 I_method_9bff0335(float var0, float var1) {
      return new IIiii_Class8(var0, var1, 0.0F, 0.0F);
   }

   public static IIiii_Class8 i_method_b61fef15(float var0, float var1) {
      return new IIiii_Class8(0.0F, 0.0F, var1, var0);
   }

   public static IIiii_Class8 II_method_35289fb8(float var0, float var1) {
      return new IIiii_Class8(var0, 0.0F, 0.0F, var1);
   }

   public static IIiii_Class8 Ii_method_4f498b98(float var0, float var1) {
      return new IIiii_Class8(0.0F, var0, var1, 0.0F);
   }

   @Override
   public String toString() {
      return "BorderRadius{topLeftRadius="
         + this.I_field_46
         + ", topRightRadius="
         + this.i_field_46
         + ", bottomRightRadius="
         + this.II_field_46
         + ", bottomLeftRadius="
         + this.Ii_field_46
         + "}";
   }

   @Override
   public final int hashCode() {
      int result = 0;
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
      IIiii_Class8 other = (IIiii_Class8) var1;
      return java.util.Objects.equals(this.I_field_46, other.I_field_46)
         && java.util.Objects.equals(this.i_field_46, other.i_field_46)
         && java.util.Objects.equals(this.II_field_46, other.II_field_46)
         && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46);
   }

   public float I_method_b483cecf() {
      return this.I_field_46;
   }

   public float i_method_b4925aaf() {
      return this.i_field_46;
   }

   public float II_method_dc050452() {
      return this.II_field_46;
   }

   public float Ii_method_dc139032() {
      return this.Ii_field_46;
   }
}
