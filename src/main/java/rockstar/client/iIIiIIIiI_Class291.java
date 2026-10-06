package rockstar.client;

import lombok.Generated;
import net.minecraft.client.util.math.Vector2f;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.Rect;
import rockstar.client.III;
import rockstar.client.Setting;
import rockstar.client.Vector2Setting;
import rockstar.client.KeybindSetting;
import rockstar.client.RegistryListSetting;
import rockstar.client.BooleanSetting;
import rockstar.client.ButtonSetting;
import rockstar.client.ColorSetting;
import rockstar.client.GradientColorSetting;
import rockstar.client.SectionSetting;
import rockstar.client.ModeSetting;
import rockstar.client.VectorRangeSetting;
import rockstar.client.RangeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.TextSetting;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiIiiiII_Class221;
import rockstar.client.IiiIiiiIi_Class222;
import rockstar.client.IiiIiiiiI_Class223;
import rockstar.client.IiiIiiiii_Class224;
import rockstar.client.IiiiIIIII_Class225;
import rockstar.client.IiiiIIIIi_Class226;
import rockstar.client.IiiiIIIiI_Class227;
import rockstar.client.IiiiIIIii_Class228;
import rockstar.client.IiiiIIiII_Class229;
import rockstar.client.IiiiIIiIi_Class230;
import rockstar.client.IiiiIIiiI_Class231;
import rockstar.client.IiiiIIiii_Class232;
import rockstar.client.IiiiIiIII_Class233;
import rockstar.client.IiiiIiIIi_Class234;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.iI_Class3;

public final class iIIiIIIiI_Class291 {
    public static float I_method_ef5e7a8f(float f, float f2) {
        return (float)Math.ceil(f2 / 2.0f - f / 2.0f);
    }

    public static double I_method_ef5d8a4d(double d, double d2) {
        return Math.ceil(d2 / 2.0 - d / 2.0);
    }

    public static boolean I_method_c3fabb03(double d, double d2, double d3, double d4, int n, int n2) {
        return (double)n >= d && (double)n < d + d3 && (double)n2 >= d2 && (double)n2 < d2 + d4;
    }

    public static boolean I_method_da20b32b(double d, double d2, double d3, double d4, III iII) {
        return iIIiIIIiI_Class291.I_method_c3fabb03(d, d2, d3, d4, iII.I_method_b1c3e152(), iII.i_method_b1d26d32());
    }

    public static boolean I_method_4667d3d9(Rect rect, double d, double d2) {
        return iIIiIIIiI_Class291.I_method_c3f86263(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), d, d2);
    }

    public static boolean I_method_733d7064(iI_Class3 iI_Class32, double d, double d2) {
        return iIIiIIIiI_Class291.I_method_c3f86263(iI_Class32.I_method_4e7e11bc(), iI_Class32.i_method_4e8c9d9c(), iI_Class32.II_method_c7206932(), iI_Class32.Ii_method_2047ead7(), d, d2);
    }

    public static boolean I_method_c3f86263(double d, double d2, double d3, double d4, double d5, double d6) {
        return d5 >= d && d5 < d + d3 && d6 >= d2 && d6 < d2 + d4;
    }

    public static float I_method_a531f52f(float f, float f2, float f3, float f4, double d) {
        return (float)(Math.min(1.0, Math.max(0.0, (d - (double)f3) / (double)f4)) * (double)(f2 - f)) + f;
    }

    public static float i_method_2dbfd54f(float f, float f2, float f3, float f4, double d) {
        return (float)((d - (double)f3) / (double)f4 * (double)(f2 - f)) + f;
    }

    public static float I_method_fc7140f1(float f, float f2, float f3) {
        return (f - f2) / (f3 - f2);
    }

    public static Vector2f I_method_81637b4f() {
        return new Vector2f((float)(iIIiIIiIi_Class294.I_field_3a9bda27.mouse.getX() / iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20d()), (float)(iIIiIIiIi_Class294.I_field_3a9bda27.mouse.getY() / iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20d()));
    }

    public static boolean I_method_f734a088(int n) {
        return GLFW.glfwGetMouseButton((long)iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getHandle(), (int)n) == 1;
    }

    public static IiiIiiIii_Class220 I_method_ddfca5e(Setting iIiiiIIII_Class113, iI_Class3 iI_Class32) {
        IiiIiiIii_Class220 iiiIiiIii_Class220 = null;
        if (iIiiiIIII_Class113 instanceof BooleanSetting) {
            BooleanSetting iIiiiIiii_Class120 = (BooleanSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiIiiiii_Class224(iIiiiIiii_Class120, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof KeybindSetting) {
            KeybindSetting iIiiiIiIi_Class118 = (KeybindSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiIiiiIi_Class222(iIiiiIiIi_Class118, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof ColorSetting) {
            ColorSetting iIiiiiIIi_Class122 = (ColorSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIIIIi_Class226(iIiiiiIIi_Class122, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof GradientColorSetting) {
            GradientColorSetting iIiiiiIiI_Class123 = (GradientColorSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIIIiI_Class227(iIiiiiIiI_Class123, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof ModeSetting) {
            ModeSetting iIiiiiiII_Class125 = (ModeSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIIiII_Class229(iIiiiiiII_Class125, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof RangeSetting) {
            RangeSetting iIiiiiiiI_Class127 = (RangeSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIIiiI_Class231(iIiiiiiiI_Class127, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof VectorRangeSetting) {
            VectorRangeSetting iIiiiiiIi_Class126 = (VectorRangeSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIIiIi_Class230(iIiiiiiIi_Class126, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof Vector2Setting) {
            Vector2Setting iIiiiIiII_Class117 = (Vector2Setting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiIiiiII_Class221(iIiiiIiII_Class117, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof ButtonSetting) {
            ButtonSetting iIiiiiIII_Class121 = (ButtonSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIIIII_Class225(iIiiiiIII_Class121, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof RegistryListSetting) {
            RegistryListSetting iIiiiIiiI_Class119 = (RegistryListSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiIiiiiI_Class223(iIiiiIiiI_Class119, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof MultiSelectSetting) {
            MultiSelectSetting iIiiiiiii_Class128 = (MultiSelectSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIIiii_Class232(iIiiiiiii_Class128, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof SliderSetting) {
            SliderSetting iiIIIIIIi_Class130 = (SliderSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIiIII_Class233(iiIIIIIIi_Class130, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof TextSetting) {
            TextSetting iiIIIIIiI_Class131 = (TextSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIiIIi_Class234(iiIIIIIiI_Class131, iI_Class32);
        } else if (iIiiiIIII_Class113 instanceof SectionSetting) {
            SectionSetting iIiiiiIii_Class124 = (SectionSetting)iIiiiIIII_Class113;
            iiiIiiIii_Class220 = new IiiiIIIii_Class228(iIiiiiIii_Class124, iI_Class32);
        }
        if (iiiIiiIii_Class220 != null) {
            iiiIiiIii_Class220.I_method_575ca63f();
        }
        return iiiIiiIii_Class220;
    }

    @Generated
    private iIIiIIIiI_Class291() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

