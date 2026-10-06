package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import rockstar.client.IiiIi_Class14;

public class IIIiii_Class8
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

    public IIIiii_Class8(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("InvViewProj");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("CamPos");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("FogTint");
        this.Ii_field_e7180c72 = this.I_method_cb7dbe45("Flow");
        this.iI_field_e7180c72 = this.I_method_cb7dbe45("FlowPatch");
        this.ii_field_e7180c72 = this.I_method_cb7dbe45("Density");
        this.III_field_e7180c72 = this.I_method_cb7dbe45("LayerY");
        this.IIi_field_e7180c72 = this.I_method_cb7dbe45("Thickness");
        this.IiI_field_e7180c72 = this.I_method_cb7dbe45("MaxDistance");
        this.Iii_field_e7180c72 = this.I_method_cb7dbe45("Coverage");
        this.iII_field_e7180c72 = this.I_method_cb7dbe45("TileScale");
        this.iIi_field_e7180c72 = this.I_method_cb7dbe45("StepWorld");
        super.I_method_e7207e6c();
    }

    public void I_method_e824fb9e(Matrix4f matrix4f, Nested1_b512cb53 nested1_b512cb53) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(matrix4f);
        }
        if (this.i_field_e7180c72 != null) {
            this.i_field_e7180c72.set(nested1_b512cb53.I_field_46, nested1_b512cb53.i_field_46, nested1_b512cb53.II_field_46);
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(nested1_b512cb53.Ii_field_46, nested1_b512cb53.iI_field_46, nested1_b512cb53.ii_field_46);
        }
        if (this.Ii_field_e7180c72 != null) {
            this.Ii_field_e7180c72.set(nested1_b512cb53.III_field_46, nested1_b512cb53.IIi_field_46);
        }
        if (this.iI_field_e7180c72 != null) {
            this.iI_field_e7180c72.set(nested1_b512cb53.IiI_field_46, nested1_b512cb53.Iii_field_46);
        }
        if (this.ii_field_e7180c72 != null) {
            this.ii_field_e7180c72.set(nested1_b512cb53.iII_field_46);
        }
        if (this.III_field_e7180c72 != null) {
            this.III_field_e7180c72.set(nested1_b512cb53.iIi_field_46);
        }
        if (this.IIi_field_e7180c72 != null) {
            this.IIi_field_e7180c72.set(nested1_b512cb53.iiI_field_46);
        }
        if (this.IiI_field_e7180c72 != null) {
            this.IiI_field_e7180c72.set(nested1_b512cb53.iii_field_46);
        }
        if (this.Iii_field_e7180c72 != null) {
            this.Iii_field_e7180c72.set(nested1_b512cb53.IIII_field_46);
        }
        if (this.iII_field_e7180c72 != null) {
            this.iII_field_e7180c72.set(nested1_b512cb53.IIIi_field_46);
        }
        if (this.iIi_field_e7180c72 != null) {
            this.iIi_field_e7180c72.set(nested1_b512cb53.IIiI_field_46);
        }
    }

    public static final class Nested1_b512cb53 {
        public float I_field_46;
        public float i_field_46;
        public float II_field_46;
        public float Ii_field_46 = 1.0f;
        public float iI_field_46 = 1.0f;
        public float ii_field_46 = 1.0f;
        public float III_field_46;
        public float IIi_field_46;
        public float IiI_field_46;
        public float Iii_field_46;
        public float iII_field_46 = 0.35f;
        public float iIi_field_46 = 64.0f;
        public float iiI_field_46 = 10.0f;
        public float iii_field_46 = 96.0f;
        public float IIII_field_46 = 0.45f;
        public float IIIi_field_46 = 0.0034722222f;
        public float IIiI_field_46 = 4.5f;
        public int I_field_49;
        public boolean I_field_5a;
    }
}

