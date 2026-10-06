package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import rockstar.client.IiiIi_Class14;

public class Iiiii_Class16
extends IiiIi_Class14 {
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;
    private GlUniform II_field_e7180c72;
    private GlUniform Ii_field_e7180c72;
    private GlUniform iI_field_e7180c72;
    private GlUniform ii_field_e7180c72;
    private GlUniform III_field_e7180c72;
    private GlUniform IIi_field_e7180c72;
    private GlUniform IiI_field_e7180c72;
    private GlUniform Iii_field_e7180c72;
    private GlUniform iII_field_e7180c72;
    private GlUniform iIi_field_e7180c72;
    private GlUniform iiI_field_e7180c72;
    private GlUniform iii_field_e7180c72;

    public Iiiii_Class16(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("ViewProj");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("CamPos");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("CamRight");
        this.Ii_field_e7180c72 = this.I_method_cb7dbe45("CamUp");
        this.iI_field_e7180c72 = this.I_method_cb7dbe45("Motion");
        this.ii_field_e7180c72 = this.I_method_cb7dbe45("Cell");
        this.III_field_e7180c72 = this.I_method_cb7dbe45("Tint");
        this.IIi_field_e7180c72 = this.I_method_cb7dbe45("Time");
        this.IiI_field_e7180c72 = this.I_method_cb7dbe45("Size");
        this.Iii_field_e7180c72 = this.I_method_cb7dbe45("Drift");
        this.iII_field_e7180c72 = this.I_method_cb7dbe45("Flicker");
        this.iIi_field_e7180c72 = this.I_method_cb7dbe45("Stretch");
        this.iiI_field_e7180c72 = this.I_method_cb7dbe45("Roof");
        this.iii_field_e7180c72 = this.I_method_cb7dbe45("RoofSpan");
        super.I_method_e7207e6c();
    }

    public void I_method_bbaf5552(Matrix4f matrix4f, Nested1_eba0a780 nested1_eba0a780) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(matrix4f);
        }
        if (this.i_field_e7180c72 != null) {
            this.i_field_e7180c72.set(nested1_eba0a780.I_field_46, nested1_eba0a780.i_field_46, nested1_eba0a780.II_field_46);
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(nested1_eba0a780.Ii_field_46, nested1_eba0a780.iI_field_46, nested1_eba0a780.ii_field_46);
        }
        if (this.Ii_field_e7180c72 != null) {
            this.Ii_field_e7180c72.set(nested1_eba0a780.III_field_46, nested1_eba0a780.IIi_field_46, nested1_eba0a780.IiI_field_46);
        }
        if (this.iI_field_e7180c72 != null) {
            this.iI_field_e7180c72.set(nested1_eba0a780.Iii_field_46, nested1_eba0a780.iII_field_46, nested1_eba0a780.iIi_field_46);
        }
        if (this.ii_field_e7180c72 != null) {
            this.ii_field_e7180c72.set(nested1_eba0a780.iiI_field_46, nested1_eba0a780.iii_field_46, nested1_eba0a780.IIII_field_46);
        }
        if (this.III_field_e7180c72 != null) {
            this.III_field_e7180c72.set(nested1_eba0a780.IIIi_field_46, nested1_eba0a780.IIiI_field_46, nested1_eba0a780.IIii_field_46, nested1_eba0a780.IiII_field_46);
        }
        if (this.IIi_field_e7180c72 != null) {
            this.IIi_field_e7180c72.set(nested1_eba0a780.IiIi_field_46);
        }
        if (this.IiI_field_e7180c72 != null) {
            this.IiI_field_e7180c72.set(nested1_eba0a780.IiiI_field_46);
        }
        if (this.Iii_field_e7180c72 != null) {
            this.Iii_field_e7180c72.set(nested1_eba0a780.Iiii_field_46);
        }
        if (this.iII_field_e7180c72 != null) {
            this.iII_field_e7180c72.set(nested1_eba0a780.iIII_field_46);
        }
        if (this.iIi_field_e7180c72 != null) {
            this.iIi_field_e7180c72.set(nested1_eba0a780.iIIi_field_46);
        }
        if (this.iiI_field_e7180c72 != null) {
            this.iiI_field_e7180c72.set(nested1_eba0a780.iIiI_field_46, nested1_eba0a780.iIii_field_46, nested1_eba0a780.iiII_field_46, nested1_eba0a780.iiIi_field_46);
        }
        if (this.iii_field_e7180c72 != null) {
            this.iii_field_e7180c72.set(nested1_eba0a780.iiiI_field_46);
        }
    }

    public static final class Nested1_eba0a780 {
        public float I_field_46;
        public float i_field_46;
        public float II_field_46;
        public float Ii_field_46 = 1.0f;
        public float iI_field_46;
        public float ii_field_46;
        public float III_field_46;
        public float IIi_field_46 = 1.0f;
        public float IiI_field_46;
        public float Iii_field_46;
        public float iII_field_46 = -0.6f;
        public float iIi_field_46;
        public float iiI_field_46 = 48.0f;
        public float iii_field_46 = 32.0f;
        public float IIII_field_46 = 48.0f;
        public float IIIi_field_46 = 1.0f;
        public float IIiI_field_46 = 1.0f;
        public float IIii_field_46 = 1.0f;
        public float IiII_field_46 = 1.0f;
        public float IiIi_field_46;
        public float IiiI_field_46 = 0.12f;
        public float Iiii_field_46 = 0.6f;
        public float iIII_field_46;
        public float iIIi_field_46 = 1.0f;
        public float iIiI_field_46;
        public float iIii_field_46;
        public float iiII_field_46;
        public float iiIi_field_46;
        public float iiiI_field_46 = 192.0f;
    }
}

