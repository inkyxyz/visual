package rockstar.client;

import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIIiiI_Class7;
import rockstar.client.IIIiii_Class8;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiiIiIii_Class364;

public class iIiiiiIIi_Class378
implements iIIiIIiIi_Class294 {
    private static final float I_field_46 = 0.07f;
    private static final float i_field_46 = 0.0224f;
    private static final float II_field_46 = 0.0152f;
    private static final float Ii_field_46 = -0.0091f;
    private static final float iI_field_46 = 0.0134f;
    private static final float ii_field_46 = 160.0f;
    private static final float III_field_46 = 5.0f;
    private static final float IIi_field_46 = 3.5f;
    private final iIiiIiIii_Class364 I_field_e683e8c = new iIiiIiIii_Class364();
    private final IIIiiI_Class7 I_field_83b91221 = new IIIiiI_Class7();
    private final IIIiii_Class8.Nested1_b512cb53 I_field_79cb4c7c = new IIIiii_Class8.Nested1_b512cb53();
    private final Matrix4f I_field_d754d74 = new Matrix4f();

    public iIiiiiIIi_Class378() {
        this.I_field_83b91221.I_method_800d826c();
    }

    public void I_method_a0d76775(Camera camera, Matrix4f matrix4f, Matrix4f matrix4f2, ColorRGBA colorRGBA, float f, float f2, float f3, float f4, boolean bl) {
        this.I_field_79cb4c7c.I_field_49 = this.I_field_e683e8c.I_method_d61d3e32();
        if (this.I_field_79cb4c7c.I_field_49 == 0) {
            return;
        }
        this.I_field_79cb4c7c.I_field_5a = bl;
        this.I_field_79cb4c7c.IIiI_field_46 = bl ? 3.5f : 5.0f;
        Vec3d vec3d = camera.getPos();
        this.I_field_79cb4c7c.I_field_46 = iIiiiiIIi_Class378.I_method_31798571(vec3d.x, 1152.0f);
        this.I_field_79cb4c7c.i_field_46 = (float)vec3d.y;
        this.I_field_79cb4c7c.II_field_46 = iIiiiiIIi_Class378.I_method_31798571(vec3d.z, 1152.0f);
        this.I_field_79cb4c7c.Ii_field_46 = colorRGBA.getRed() / 255.0f;
        this.I_field_79cb4c7c.iI_field_46 = colorRGBA.getGreen() / 255.0f;
        this.I_field_79cb4c7c.ii_field_46 = colorRGBA.getBlue() / 255.0f;
        this.I_field_79cb4c7c.iII_field_46 = f * 0.07f;
        this.I_field_79cb4c7c.IIII_field_46 = 0.75f - f2 * 0.55f;
        this.I_field_79cb4c7c.iIi_field_46 = f3;
        this.I_field_79cb4c7c.iiI_field_46 = f4;
        this.I_field_79cb4c7c.IIIi_field_46 = 0.0034722222f;
        this.I_field_79cb4c7c.iii_field_46 = Math.min(160.0f, (float)((Integer)iIiiiiIIi_Class378.I_field_3a9bda27.options.getViewDistance().getValue()).intValue() * 16.0f);
        double d = (double)(System.currentTimeMillis() % 3600000L) / 1000.0;
        this.I_field_79cb4c7c.III_field_46 = iIiiiiIIi_Class378.I_method_31798571((double)0.0224f * d, 288.0f);
        this.I_field_79cb4c7c.IIi_field_46 = iIiiiiIIi_Class378.I_method_31798571((double)0.0152f * d, 288.0f);
        this.I_field_79cb4c7c.IiI_field_46 = iIiiiiIIi_Class378.I_method_31798571((double)-0.0091f * d, 1152.0f);
        this.I_field_79cb4c7c.Iii_field_46 = iIiiiiIIi_Class378.I_method_31798571((double)0.0134f * d, 1152.0f);
        this.I_field_d754d74.set((Matrix4fc)matrix4f2).mul((Matrix4fc)matrix4f).invert();
        this.I_field_83b91221.I_method_76c1437e(this.I_field_d754d74, this.I_field_79cb4c7c);
    }

    private static float I_method_31798571(double d, float f) {
        return (float)(d - Math.floor(d / (double)f) * (double)f);
    }
}

