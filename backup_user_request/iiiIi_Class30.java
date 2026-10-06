package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import rockstar.client.IiiIi_Class14;

public class iiiIi_Class30
extends IiiIi_Class14 {
    private GlUniform I_field_e7180c72;

    public iiiIi_Class30(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    public void I_method_59554e1(float f) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(f);
        }
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("Floor");
        super.I_method_e7207e6c();
    }
}

