package rockstar.client;

import java.util.List;
import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import rockstar.client.IIIiII_Class5;
import rockstar.client.IiiIi_Class14;

public class IIIiIi_Class6
extends IiiIi_Class14 {
    public static final int I_field_49 = 18;
    private GlUniform I_field_e7180c72;
    private GlUniform i_field_e7180c72;
    private GlUniform II_field_e7180c72;
    private final GlUniform[] I_field_39911637 = new GlUniform[18];

    public IIIiIi_Class6(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    @Override
    protected void I_method_e7207e6c() {
        this.I_field_e7180c72 = this.I_method_cb7dbe45("Count");
        this.i_field_e7180c72 = this.I_method_cb7dbe45("Aspect");
        this.II_field_e7180c72 = this.I_method_cb7dbe45("Strength");
        for (int i = 0; i < 18; ++i) {
            this.I_field_39911637[i] = this.I_method_cb7dbe45("Lens" + i);
        }
        super.I_method_e7207e6c();
    }

    public void I_method_5c86001d(float f, float f2, List<IIIiII_Class5.Nested1_b503c753> list) {
        int n = Math.min(list.size(), 18);
        if (this.I_field_e7180c72 != null) {
            this.I_field_e7180c72.set((float)n);
        }
        if (this.i_field_e7180c72 != null) {
            this.i_field_e7180c72.set(f);
        }
        if (this.II_field_e7180c72 != null) {
            this.II_field_e7180c72.set(f2);
        }
        for (int i = 0; i < n; ++i) {
            IIIiII_Class5.Nested1_b503c753 nested1_b503c753 = list.get(i);
            if (this.I_field_39911637[i] == null) continue;
            this.I_field_39911637[i].set(nested1_b503c753.I_method_198cd837(), nested1_b503c753.i_method_199b6417(), nested1_b503c753.II_method_181d27ea(), nested1_b503c753.Ii_method_182bb3ca());
        }
    }
}

