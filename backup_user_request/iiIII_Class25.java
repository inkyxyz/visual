package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import rockstar.client.IiiIi_Class14;

public class iiIII_Class25
extends IiiIi_Class14 {
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;
    private GlUniform II_field_e7180c72;

    public iiIII_Class25(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("Time");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("Strength");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("Aspect");
        super.I_method_e7207e6c();
    }

    public void I_method_d07c6061(float f, float f2, float f3) {
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set(f);
        }
        if (this.i_field_e7180c72 != null) {
            this.i_field_e7180c72.set(f2);
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(f3);
        }
    }
}

