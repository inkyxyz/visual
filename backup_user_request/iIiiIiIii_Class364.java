package rockstar.client;

import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import rockstar.client.iIIiIIiIi_Class294;

public class iIiiIiIii_Class364
implements iIIiIIiIi_Class294 {
    public static final float I_field_46 = 288.0f;
    public static final float i_field_46 = 0.25f;
    public static final float II_field_46 = 1152.0f;
    private static final int I_field_49 = 512;
    private static final int i_field_49 = 16;
    private static final int II_field_49 = 4;
    private static final int Ii_field_49 = 2;
    private static final int iI_field_49 = 3;
    private static final float Ii_field_46 = 0.6f;
    private static final float iI_field_46 = 0.45f;
    private static final int ii_field_49 = 7919;
    private NativeImageBackedTexture I_field_d7800ed2;
    private volatile NativeImage I_field_cb9f726f;
    private boolean I_field_5a;

    public int I_method_d61d3e32() {
        if (this.I_field_d7800ed2 != null) {
            return this.I_field_d7800ed2.getGlId();
        }
        NativeImage nativeImage = this.I_field_cb9f726f;
        if (nativeImage != null) {
            this.I_field_cb9f726f = null;
            this.I_field_d7800ed2 = new NativeImageBackedTexture(nativeImage);
            this.I_field_d7800ed2.setFilter(true, false);
            return this.I_field_d7800ed2.getGlId();
        }
        if (!this.I_field_5a) {
            this.I_field_5a = true;
            Thread thread = new Thread(this::I_method_d61d3e3f, "rockstar-fog-noise");
            thread.setDaemon(true);
            thread.start();
        }
        return 0;
    }

    private void I_method_d61d3e3f() {
        NativeImage nativeImage = new NativeImage(512, 512, false);
        for (int i = 0; i < 512; ++i) {
            for (int j = 0; j < 512; ++j) {
                float f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.6f;
                int n = 16;
                for (int k = 0; k < 4; ++k) {
                    f = iIiiIiIii_Class364.I_method_22cc2f6f(j, i, n, k * 131);
                    f2 += f * f5;
                    f3 += (k < 2 ? f : 0.5f) * f5;
                    f4 += f5;
                    f5 *= 0.45f;
                    n <<= 1;
                }
                float f6 = 0.0f;
                f = 0.0f;
                f5 = 0.6f;
                n = 16;
                for (int k = 0; k < 3; ++k) {
                    f6 += iIiiIiIii_Class364.I_method_22cc2f6f(j, i, n, 7919 + k * 131) * f5;
                    f += f5;
                    f5 *= 0.45f;
                    n <<= 1;
                }
                nativeImage.setColorArgb(j, i, 0xFF000000 | iIiiIiIii_Class364.I_method_ed8af154(f2 / f4) << 16 | iIiiIiIii_Class364.I_method_ed8af154(f3 / f4) << 8 | iIiiIiIii_Class364.I_method_ed8af154(f6 / f));
            }
        }
        this.I_field_cb9f726f = nativeImage;
    }

    private static float I_method_22cc2f6f(int n, int n2, int n3, int n4) {
        float f = (float)(n * n3) / 512.0f;
        float f2 = (float)(n2 * n3) / 512.0f;
        int n5 = (int)Math.floor(f);
        int n6 = (int)Math.floor(f2);
        float f3 = iIiiIiIii_Class364.I_method_ed8af151(f - (float)n5);
        float f4 = iIiiIiIii_Class364.I_method_ed8af151(f2 - (float)n6);
        int n7 = n3 - 1;
        int n8 = n5 & n7;
        int n9 = n5 + 1 & n7;
        int n10 = n6 & n7;
        int n11 = n6 + 1 & n7;
        float f5 = iIiiIiIii_Class364.I_method_b6a11511(iIiiIiIii_Class364.I_method_b6ccc3f4(n8, n10, n4), iIiiIiIii_Class364.I_method_b6ccc3f4(n9, n10, n4), f3);
        float f6 = iIiiIiIii_Class364.I_method_b6a11511(iIiiIiIii_Class364.I_method_b6ccc3f4(n8, n11, n4), iIiiIiIii_Class364.I_method_b6ccc3f4(n9, n11, n4), f3);
        return iIiiIiIii_Class364.I_method_b6a11511(f5, f6, f4);
    }

    private static float I_method_b6ccc3f4(int n, int n2, int n3) {
        int n4 = n * 374761393 + n2 * 668265263 + n3 * 1274126177;
        n4 = (n4 ^ n4 >>> 13) * 1274126177;
        n4 ^= n4 >>> 16;
        return (float)(n4 & 0xFFFFFF) / 1.6777215E7f;
    }

    private static float I_method_ed8af151(float f) {
        return f * f * (3.0f - 2.0f * f);
    }

    private static float I_method_b6a11511(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    private static int I_method_ed8af154(float f) {
        return Math.max(0, Math.min(255, Math.round(f * 255.0f)));
    }
}

