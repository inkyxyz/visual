package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iiIiI_Class27;

public class iiIii_Class28
extends IiiIi_Class14 {
    public static final int I_field_49 = 12;
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;
    private GlUniform II_field_e7180c72;
    private GlUniform Ii_field_e7180c72;
    private GlUniform iI_field_e7180c72;
    private GlUniform ii_field_e7180c72;

    public iiIii_Class28(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("InvViewProj");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("CircleCenter");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("WorldRadius");
        this.Ii_field_e7180c72 = this.I_method_cb7dbe45("Thickness");
        this.iI_field_e7180c72 = this.I_method_cb7dbe45("RingColor");
        this.ii_field_e7180c72 = this.I_method_cb7dbe45("Strength");
        super.I_method_e7207e6c();
    }

    public void I_method_9a795172(Matrix4f matrix4f, iiIiI_Class27.Nested1_86a4a760 nested1_86a4a760) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(matrix4f);
        }
        if (this.i_field_e7180c72 != null) {
            this.i_field_e7180c72.set(nested1_86a4a760.I_method_9fa6f84a(), nested1_86a4a760.i_method_9fb5842a(), nested1_86a4a760.II_method_55470a37());
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(nested1_86a4a760.Ii_method_55559617());
        }
        if (this.Ii_field_e7180c72 != null) {
            this.Ii_field_e7180c72.set(nested1_86a4a760.iI_method_5709fa57());
        }
        if (this.iI_field_e7180c72 != null) {
            this.iI_field_e7180c72.set(nested1_86a4a760.ii_method_57188637(), nested1_86a4a760.III_method_53a935ea(), nested1_86a4a760.IIi_method_53b7c1ca(), nested1_86a4a760.IiI_method_556c260a());
        }
        if (this.ii_field_e7180c72 != null) {
            this.ii_field_e7180c72.set(nested1_86a4a760.Iii_method_557ab1ea());
        }
    }
}

