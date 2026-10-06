package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iIIiIIiii_Class296;
import ua.mintantileak.spk.Compile;

public class iiiII_Class29
extends IiiIi_Class14
implements iIIiIIiii_Class296 {
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;
    private GlUniform II_field_e7180c72;
    private GlUniform Ii_field_e7180c72;
    private GlUniform iI_field_e7180c72;

    public iiiII_Class29(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Compile
    public void I_method_68cdecc1(float f) {
        this.i_field_e7180c72.set(f);
        this.I_field_e7180c72.set(1.0f / (float)I_field_587075c2.getScaledWidth(), 1.0f / (float)I_field_587075c2.getScaledHeight());
        this.II_field_e7180c72.set(1.0f);
        this.Ii_field_e7180c72.set(0.0f);
        this.iI_field_e7180c72.set(1.0f, 1.0f, 1.0f);
    }

    public void I_method_6d1420e1(float f, int n, int n2) {
        this.i_field_e7180c72.set(f);
        float f2 = n > 0 ? 1.0f / (float)n : 0.0f;
        float f3 = n2 > 0 ? 1.0f / (float)n2 : 0.0f;
        this.I_field_e7180c72.set(f2, f3);
        this.II_field_e7180c72.set(1.0f);
        this.Ii_field_e7180c72.set(0.0f);
        this.iI_field_e7180c72.set(1.0f, 1.0f, 1.0f);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("Resolution");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("Offset");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("Saturation");
        this.Ii_field_e7180c72 = this.I_method_cb7dbe45("TintIntensity");
        this.iI_field_e7180c72 = this.I_method_cb7dbe45("TintColor");
        super.I_method_e7207e6c();
    }
}

