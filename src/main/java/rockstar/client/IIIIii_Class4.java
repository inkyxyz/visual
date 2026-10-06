package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iIIiIIiii_Class296;

public class IIIIii_Class4
extends IiiIi_Class14
implements iIIiIIiii_Class296 {
    private GlUniform I_field_e7180c72;

    public IIIIii_Class4(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    public void I_method_25bc6fcc(int n, int n2) {
        float f = n > 0 ? 1.0f / (float)n : 0.0f;
        float f2 = n2 > 0 ? 1.0f / (float)n2 : 0.0f;
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("Resolution");
        super.I_method_e7207e6c();
    }
}

