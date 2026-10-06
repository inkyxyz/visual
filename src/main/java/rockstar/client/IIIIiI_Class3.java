package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IiiIi_Class14;

public class IIIIiI_Class3
extends IiiIi_Class14 {
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;

    public IIIIiI_Class3(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    public void I_method_5f74324b(float f, ColorRGBA colorRGBA) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(f);
        }
        if (this.i_field_e7180c72 != null && colorRGBA != null) {
            this.i_field_e7180c72.set(colorRGBA.getRed() / 255.0f, colorRGBA.getGreen() / 255.0f, colorRGBA.getBlue() / 255.0f);
        }
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("Time");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("Accent");
        super.I_method_e7207e6c();
    }
}

