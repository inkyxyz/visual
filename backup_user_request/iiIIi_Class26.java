package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IiiIi_Class14;

public class iiIIi_Class26
extends IiiIi_Class14 {
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;
    private GlUniform II_field_e7180c72;

    public iiIIi_Class26(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    public void I_method_86be3e5e(float f, ColorRGBA colorRGBA, float f2, float f3) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(f);
        }
        if (this.i_field_e7180c72 != null && colorRGBA != null) {
            this.i_field_e7180c72.set(colorRGBA.getRed() / 255.0f, colorRGBA.getGreen() / 255.0f, colorRGBA.getBlue() / 255.0f);
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(f2, f3);
        }
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("Time");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("Accent");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("ItemCenter");
        super.I_method_e7207e6c();
    }
}

