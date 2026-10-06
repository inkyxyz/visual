package rockstar.client;

import java.util.List;
import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

public class iiiii_Class32 extends IiiIi_Class14 {
   public static final int I_field_49 = 48;
   private GlUniform I_field_e7180c72;
   private GlUniform i_field_e7180c72;
   private final GlUniform[] I_field_39911637 = new GlUniform[48];
   private final GlUniform[] i_field_39911637 = new GlUniform[48];

   public iiiii_Class32(Identifier var1) {
      super(var1, VertexFormats.POSITION_TEXTURE_COLOR);
   }

   @Override
   protected void I_method_e7207e6c() {
      this.I_field_e7180c72 = this.I_method_cb7dbe45("InvViewProj");
      this.i_field_e7180c72 = this.I_method_cb7dbe45("Ambient");

      for (int var1 = 0; var1 < 48; var1++) {
         this.I_field_39911637[var1] = this.I_method_cb7dbe45("L" + var1 + "Pos");
         this.i_field_39911637[var1] = this.I_method_cb7dbe45("L" + var1 + "Col");
      }

      super.I_method_e7207e6c();
   }

   public void I_method_5801b5a2(Matrix4f var1, float var2, List<iiiii_Class32.Nested1_88680fa0> var3) {
      if (this.I_field_e7180c72 != null) {
         this.I_field_e7180c72.set(var1);
      }

      if (this.i_field_e7180c72 != null) {
         this.i_field_e7180c72.set(var2);
      }

      for (int var4 = 0; var4 < 48; var4++) {
         iiiii_Class32.Nested1_88680fa0 var5 = var4 < var3.size() ? (iiiii_Class32.Nested1_88680fa0)var3.get(var4) : null;
         if (this.I_field_39911637[var4] != null) {
            if (var5 == null) {
               this.I_field_39911637[var4].set(0.0F, 0.0F, 0.0F, 0.0F);
            } else {
               this.I_field_39911637[var4].set(var5.I_method_24fab80a(), var5.i_method_250943ea(), var5.II_method_7a6b4277(), var5.Ii_method_7a79ce57());
            }
         }

         if (this.i_field_39911637[var4] != null) {
            if (var5 == null) {
               this.i_field_39911637[var4].set(0.0F, 0.0F, 0.0F, 0.0F);
            } else {
               this.i_field_39911637[var4].set(var5.iI_method_7c2e3297(), var5.ii_method_7c3cbe77(), var5.III_method_d30c05aa(), var5.IIi_method_d31a918a());
            }
         }
      }
   }

   public static final class Nested1_88680fa0 {
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final float Ii_field_46;
      private final float iI_field_46;
      private final float ii_field_46;
      private final float III_field_46;
      private final float IIi_field_46;

      public Nested1_88680fa0(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
         this.iI_field_46 = var5;
         this.ii_field_46 = var6;
         this.III_field_46 = var7;
         this.IIi_field_46 = var8;
      }

      @Override
      public final String toString() {
         return "Nested1_88680fa0[x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", z=" + this.II_field_46 + ", radius=" + this.Ii_field_46 + ", r=" + this.iI_field_46 + ", g=" + this.ii_field_46 + ", b=" + this.III_field_46 + ", intensity=" + this.IIi_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.III_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.IIi_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiiii_Class32.Nested1_88680fa0 other = (iiiii_Class32.Nested1_88680fa0) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46)
            && java.util.Objects.equals(this.III_field_46, other.III_field_46)
            && java.util.Objects.equals(this.IIi_field_46, other.IIi_field_46);
      }

      public float I_method_24fab80a() {
         return this.I_field_46;
      }

      public float i_method_250943ea() {
         return this.i_field_46;
      }

      public float II_method_7a6b4277() {
         return this.II_field_46;
      }

      public float Ii_method_7a79ce57() {
         return this.Ii_field_46;
      }

      public float iI_method_7c2e3297() {
         return this.iI_field_46;
      }

      public float ii_method_7c3cbe77() {
         return this.ii_field_46;
      }

      public float III_method_d30c05aa() {
         return this.III_field_46;
      }

      public float IIi_method_d31a918a() {
         return this.IIi_field_46;
      }
   }
}
