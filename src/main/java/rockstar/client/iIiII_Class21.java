package rockstar.client;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iIIiIIiii_Class296;
import ua.mintantileak.spk.Compile;

public class iIiII_Class21
extends IiiIi_Class14
implements iIIiIIiii_Class296 {
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;
    private GlUniform II_field_e7180c72;
    private GlUniform Ii_field_e7180c72;
    private GlUniform iI_field_e7180c72;

    public iIiII_Class21(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Compile
    public void I_method_df9fc8e1(float f) {
        this.i_field_e7180c72.set(f);
        this.I_field_e7180c72.set(1.0f / (float)I_field_587075c2.getScaledWidth(), 1.0f / (float)I_field_587075c2.getScaledHeight());
    }

    public void I_method_76df7501(float f, int n, int n2) {
        this.i_field_e7180c72.set(f);
        float f2 = n > 0 ? 1.0f / (float)n : 0.0f;
        float f3 = n2 > 0 ? 1.0f / (float)n2 : 0.0f;
        this.I_field_e7180c72.set(f2, f3);
    }

    public void I_method_3ce330c1(float f, int n, int n2, float f2, float f3) {
        this.I_method_76df7501(f, n, n2);
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(f2);
        }
        if (this.Ii_field_e7180c72 != null) {
            this.Ii_field_e7180c72.set(f3);
        }
    }

    public void I_method_90e6fc81(float f, int n, int n2, float f2, float f3, float f4, float f5) {
        this.I_method_3ce330c1(f, n, n2, f2, f3);
        if (this.iI_field_e7180c72 != null) {
            this.iI_field_e7180c72.set(f4, f5);
        }
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("Resolution");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("Offset");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("OutlineStrength");
        this.Ii_field_e7180c72 = this.I_method_cb7dbe45("OutlineRadius");
        this.iI_field_e7180c72 = this.I_method_cb7dbe45("GlowOffset");
        super.I_method_e7207e6c();
    }
}

