package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec2f;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.AutoFarmModule;
import rockstar.client.IIIiiiIii_Class60;
import rockstar.client.IIiIIIIiI_Class67;
import rockstar.client.IIiIIIIii_Class68;
import rockstar.client.IIiIIIiII_Class69;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiI_Class3;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIIii_Class180;
import rockstar.client.ModuleManager;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public class IiIiiiiII_Class189
extends IiIiiIIii_Class180
implements iIIiIIiIi_Class294 {
    private static final float I_field_46 = 138.0f;
    private static final float i_field_46 = 15.0f;
    private static final float II_field_46 = 128.0f;
    private static final float Ii_field_46 = 10.0f;
    private static final float iI_field_46 = 7.0f;
    private static final float ii_field_46 = 8.0f;
    private static final float III_field_46 = 4.0f;
    private static final float IIi_field_46 = 7.0f;
    private static final float IiI_field_46 = 9.0f;
    private static final float Iii_field_46 = 10.0f;
    private static final float iII_field_46 = 24.0f;
    private static final float iIi_field_46 = 6.0f;
    private static final float iiI_field_46 = 38.0f;
    private static final float iii_field_46 = 46.0f;
    private static final float IIII_field_46 = 6.0f;
    private static final float IIIi_field_46 = 0.62f;
    private static final String I_field_523beb0a = "  ";
    private static final float IIiI_field_46 = 7.0f;
    private static final float IIii_field_46 = 78.0f;
    private static final float IiII_field_46 = 54.0f;
    private static final float IiIi_field_46 = 7.0f;
    private static final float IiiI_field_46 = 71.0f;
    private static final float Iiii_field_46 = 6.0f;
    private static final int I_field_49 = 16;
    private static final int i_field_49 = 3;
    private static final int II_field_49 = 6;
    private static final float iIII_field_46 = 0.25f;
    private static final float iIIi_field_46 = 0.75f;
    private iii_Class8 I_field_b584628c;

    public IiIiiiiII_Class189(MultiSelectSetting iIiiiiiii_Class128) {
        super(iIiiiiiii_Class128, "auto_farm");
    }

    public iii_Class8 I_method_155e185d(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        if (this.I_field_b584628c == null) {
            this.I_field_b584628c = new Nested1_4316a020(iiIiiIIII_Class177);
        }
        return this.I_field_b584628c;
    }

    @Override
    public boolean canShow() {
        AutoFarmModule iIIIiiiIi_Class30 = this.I_method_5786c715();
        return iIIIiiiIi_Class30 != null && iIIIiiiIi_Class30.isEnabled() && IiiiiiiII_Class253.i_method_1cc4aa23();
    }

    void I_method_2b6e35c9(III iII, ItemStack itemStack, float f, float f2, float f3, float f4) {
        if (itemStack == null || itemStack.isEmpty() || f4 <= 0.02f) {
            return;
        }
        float[] fArray = (float[])RenderSystem.getShaderColor().clone();
        RenderSystem.setShaderColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)(fArray[3] * f4));
        iII.drawItem(itemStack, f, f2, f3 / 16.0f);
        RenderSystem.setShaderColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
    }

    void I_method_165da491(III iII, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, float f3, ColorRGBA colorRGBA) {
        if (string == null || string.isBlank() || f3 <= 1.0f) {
            return;
        }
        if (iIiIIi_Class10.I_method_2c375926(string) <= f3 + 0.5f) {
            iII.drawText(iIiIIi_Class10, string, f, f2, colorRGBA);
            return;
        }
        iII.drawFadeText(iIiIIi_Class10, string, f, f2, colorRGBA, 0.0f, Math.min(7.0f, f3), f3);
    }

    static float I_method_817ff3fa(IIiIIi_Class10 iIiIIi_Class10, String string) {
        if (string == null || string.isEmpty()) {
            return 0.0f;
        }
        float f = 0.0f;
        for (int i = 0; i < string.length(); ++i) {
            f += IiIiiiiII_Class189.I_method_eb6ca2d(iIiIIi_Class10, string.charAt(i));
        }
        return f;
    }

    static float I_method_eb6ca2d(IIiIIi_Class10 iIiIIi_Class10, char c) {
        return c >= '0' && c <= '9' ? IiIiiiiII_Class189.I_method_ade4da30(iIiIIi_Class10) : iIiIIi_Class10.I_method_22e53781(c);
    }

    private static float I_method_ade4da30(IIiIIi_Class10 iIiIIi_Class10) {
        float f = 0.0f;
        for (char c = '0'; c <= '9'; c = (char)(c + '\u0001')) {
            f = Math.max(f, iIiIIi_Class10.I_method_22e53781(c));
        }
        return f;
    }

    float I_method_a9ad4131(float f) {
        double d = I_field_3a9bda27.getWindow().getScaleFactor();
        return d <= 0.0 ? f : (float)((double)Math.round((double)f * d) / d);
    }

    String I_method_bdadac21() {
        IIIiiiIii_Class60 iIIiiiIii_Class60 = this.I_method_f4401b75();
        if (iIIiiiIii_Class60 == null) {
            return "";
        }
        String string = iIIiiiIii_Class60.I_method_57286715().I_method_12d0e881();
        String string2 = iIIiiiIii_Class60.I_method_e8739c21();
        return string2 == null || string2.isBlank() ? string : string + " " + string2;
    }

    ItemStack I_method_f2112bb9() {
        IIIiiiIii_Class60 iIIiiiIii_Class60 = this.I_method_f4401b75();
        ItemStack itemStack = iIIiiiIii_Class60 == null ? ItemStack.EMPTY : iIIiiiIii_Class60.I_method_907017b9();
        return itemStack == null || itemStack.isEmpty() ? new ItemStack((ItemConvertible)Items.WHEAT) : itemStack;
    }

    IIiIIIiII_Class69 I_method_1b4e5b15() {
        IIIiiiIii_Class60 iIIiiiIii_Class60 = this.I_method_f4401b75();
        return iIIiiiIii_Class60 == null ? IIiIIIiII_Class69.I_field_e6bdd24c : iIIiiiIii_Class60.I_method_5736ef15();
    }

    IIiIIIIii_Class68 I_method_1b404b35() {
        IIIiiiIii_Class60 iIIiiiIii_Class60 = this.I_method_f4401b75();
        return iIIiiiIii_Class60 == null ? IIiIIIIii_Class68.I_field_e6afc26c : iIIiiiIii_Class60.I_method_18285b35();
    }

    IIiIIIIiI_Class67 I_method_1b404755() {
        AutoFarmModule iIIIiiiIi_Class30 = this.I_method_5786c715();
        return iIIIiiiIi_Class30 == null ? null : iIIIiiiIi_Class30.I_method_8c2eeaf5();
    }

    IIIiiiIii_Class60 I_method_f4401b75() {
        AutoFarmModule iIIIiiiIi_Class30 = this.I_method_5786c715();
        return iIIIiiiIi_Class30 == null ? null : iIIIiiiIi_Class30.I_method_652ebf15();
    }

    private AutoFarmModule I_method_5786c715() {
        ModuleManager iiIiiiIi_Class94 = RockstarClient.getInstance().getModuleManager();
        return iiIiiiIi_Class94 == null ? null : iiIiiiIi_Class94.getModule(AutoFarmModule.class);
    }

    final class Nested1_4316a020
    extends iii_Class8 {
        private final IiIiiIIII_Class177 I_field_467a06ac;
        private final Nested1_4316a040 I_field_63753e47 = new Nested1_4316a040();

        Nested1_4316a020(IiIiiIIII_Class177 iiIiiIIII_Class177) {
            this.I_field_467a06ac = iiIiiIIII_Class177;
            this.i_method_8c7d3515(48.0f, 15.0f);
            this.Ii_method_25479968(false);
            this.iii_method_df275535();
            this.snapSize();
        }

        @Override
        protected void measure() {
            this.prefW = this.I_field_467a06ac.II_method_97ffcce6() ? 138.0f : this.iII_method_290cf90a();
            this.prefH = this.I_field_467a06ac.II_method_97ffcce6() ? 78.0f : 15.0f;
        }

        @Override
        protected void onTick(float f, float f2, float f3) {
            super.onTick(f, f2, f3);
            this.I_field_63753e47.I_method_8bc44b86(f);
        }

        @Override
        protected void drawSelf(III iII, float f) {
            IIiIIIIiI_Class67 iIiIIIIiI_Class67 = IiIiiiiII_Class189.this.I_method_1b404755();
            if (iIiIIIIiI_Class67 == null) {
                return;
            }
            float f2 = this.I_field_467a06ac.I_method_c3480795().I_method_6ac4da6f();
            float f3 = this.x();
            float f4 = this.y();
            float f5 = this.w();
            this.I_field_63753e47.I_method_f9b88ac4(IIiIIIIiI_Class67.i_method_46fbfebb(iIiIIIIiI_Class67.I_method_3ea4be33()));
            this.I_method_daf7fecc(iII, f3, f4, f2, f);
            if (f2 < 0.999f) {
                this.I_method_591b5a06(iII, iIiIIIIiI_Class67, f3, f4, f5, f2, f);
            }
            if (f2 > 0.001f) {
                this.i_method_b9c7a26(iII, iIiIIIIiI_Class67, f3, f4, f5, f2, f);
            }
        }

        @Override
        protected void drawChildren(III iII, float f) {
        }

        private void I_method_daf7fecc(III iII, float f, float f2, float f3, float f4) {
            float f5 = iIIiiiiiI_Class319.I_method_5f7ff5cf(8.0, 10.0, f3);
            float f6 = f + iIIiiiiiI_Class319.I_method_5f7ff5cf(7.0, 10.0, f3);
            float f7 = f2 + iIIiiiiiI_Class319.I_method_5f7ff5cf(this.I_method_eefce356(8.0f), 9.0, f3);
            if (this.I_method_eefce36a(f3)) {
                f6 = IiIiiiiII_Class189.this.I_method_a9ad4131(f6);
                f7 = IiIiiiiII_Class189.this.I_method_a9ad4131(f7);
            }
            IiIiiiiII_Class189.this.I_method_2b6e35c9(iII, IiIiiiiII_Class189.this.I_method_f2112bb9(), f6, f7, f5, f4);
        }

        private boolean I_method_eefce36a(float f) {
            return f <= 0.002f && Math.abs(this.w() - this.prefW) <= 0.05f;
        }

        private float I_method_eefce356(float f) {
            return (15.0f - f) / 2.0f;
        }

        private float I_method_48589e6b(IIiIIi_Class10 iIiIIi_Class10) {
            return 9.0f + (10.0f - iIiIIi_Class10.I_method_a649725c()) / 2.0f;
        }

        private void I_method_591b5a06(III iII, IIiIIIIiI_Class67 iIiIIIIiI_Class67, float f, float f2, float f3, float f4, float f5) {
            float f6 = f5 * (1.0f - f4);
            if (f6 <= 0.004f) {
                return;
            }
            IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
            ColorRGBA colorRGBA = IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * f6);
            float f7 = f + 7.0f + 8.0f + 4.0f;
            float f8 = f2 + this.I_method_eefce356(iIiIIi_Class10.I_method_a649725c());
            String string = this.I_method_ac066446();
            float f9 = IiIiiiiII_Class189.I_method_817ff3fa(iIiIIi_Class10, string);
            float f10 = IiIiiiiII_Class189.I_method_817ff3fa(iIiIIi_Class10, this.I_field_63753e47.I_method_f2398c66());
            float f11 = f + f3 - 7.0f - f10;
            IiIiiiiII_Class189.this.I_method_165da491(iII, iIiIIi_Class10, string, f7, f8, f11 - f7, colorRGBA);
            this.I_field_63753e47.I_method_e5052d92(iII, iIiIIi_Class10, Math.min(f7 + f9, f11), f8, colorRGBA);
        }

        private String I_method_ac066446() {
            String string = IiIiiiiII_Class189.this.I_method_bdadac21();
            return string.isBlank() ? "" : string + IiIiiiiII_Class189.I_field_523beb0a;
        }

        private void i_method_b9c7a26(III iII, IIiIIIIiI_Class67 iIiIIIIiI_Class67, float f, float f2, float f3, float f4, float f5) {
            float f6 = f5 * f4;
            if (f6 <= 0.004f) {
                return;
            }
            ColorRGBA colorRGBA = IiiiiIIIi_Class242.iI_method_8e08d3b1();
            IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
            this.i_method_950508da(iII, iIiIIIIiI_Class67, f, f2, f3, f6);
            String string = IiIiIIII_Class81.I_method_f25a980a("hud.dynamic_island.statuses.auto_farm");
            float f7 = IiIiiiiII_Class189.I_method_817ff3fa(iIiIIi_Class10, this.I_field_63753e47.I_method_f2398c66());
            float f8 = f + 10.0f + 10.0f + 4.0f;
            this.I_field_63753e47.I_method_e5052d92(iII, iIiIIi_Class10, f + f3 - 10.0f - f7, f2 + this.I_method_48589e6b(iIiIIi_Class10), colorRGBA.withAlpha(255.0f * f6));
            IiIiiiiII_Class189.this.I_method_165da491(iII, iIiIIi_Class10, string, f8, f2 + this.I_method_48589e6b(iIiIIi_Class10), f + f3 - 10.0f - f7 - 6.0f - f8, colorRGBA.withAlpha(255.0f * f6));
            this.i_method_4f48eec(iII, f, f2, f3, f6);
            this.I_method_6e3aacfa(iII, iIiIIIIiI_Class67, f, f2, f3, f6);
        }

        private void i_method_4f48eec(III iII, float f, float f2, float f3, float f4) {
            float f5;
            IIIiiiIii_Class60 iIIiiiIii_Class60 = IiIiiiiII_Class189.this.I_method_f4401b75();
            if (iIIiiiIii_Class60 == null) {
                return;
            }
            IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f);
            ColorRGBA colorRGBA = IiiiiIIIi_Class242.i_method_5dfec6e();
            float f6 = f2 + 24.0f;
            float f7 = f + f3 - 10.0f;
            String string = IiIiiiiII_Class189.this.I_method_bdadac21();
            float f8 = f5 = string.isBlank() ? 0.0f : iIiIIi_Class10.I_method_2c375926(string);
            if (f5 > 0.0f) {
                iII.drawText(iIiIIi_Class10, string, f7 - f5, f6, colorRGBA.withAlpha(153.0f * f4));
            }
            float f9 = f + 10.0f;
            float f10 = f7 - f5 - (f5 > 0.0f ? 6.0f : 0.0f) - f9;
            IiIiiiiII_Class189.this.I_method_165da491(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(iIIiiiIii_Class60.getName()), f9, f6, f10, colorRGBA.withAlpha(255.0f * f4));
        }

        private void I_method_6e3aacfa(III iII, IIiIIIIiI_Class67 iIiIIIIiI_Class67, float f, float f2, float f3, float f4) {
            IIiIIIiII_Class69 iIiIIIiII_Class69 = IiIiiiiII_Class189.this.I_method_1b4e5b15();
            float f5 = f + 10.0f;
            float f6 = f + f3 / 2.0f + 2.0f;
            this.I_method_89762a01(iII, f5, f2, iIiIIIiII_Class69.I_method_52a76081(), IIiIIIIiI_Class67.I_method_879a4a1(iIiIIIIiI_Class67.Ii_method_96108cd6()), IiiiiIIIi_Class242.iI_method_8e08d3b1(), f4);
            long l = iIiIIIIiI_Class67.iI_method_97c4f116();
            this.I_method_89762a01(iII, f6, f2, IiIiIIII_Class81.I_method_f25a980a("modules.auto_farm.stats.income"), IIiIIIIiI_Class67.I_method_7644aadb(l), l < 0L ? IiiiiIIIi_Class242.I_field_d0c8ec5 : IiiiiIIIi_Class242.iI_method_8e08d3b1(), f4);
        }

        private void I_method_89762a01(III iII, float f, float f2, String string, String string2, ColorRGBA colorRGBA, float f3) {
            ColorRGBA colorRGBA2 = IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(158.1f * f3);
            iII.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), string, f, f2 + 38.0f, colorRGBA2);
            iII.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0f), string2, f, f2 + 46.0f, colorRGBA.withAlpha(255.0f * f3));
        }

        private void i_method_950508da(III iII, IIiIIIIiI_Class67 iIiIIIIiI_Class67, float f, float f2, float f3, float f4) {
            float f5 = f + 6.0f;
            float f6 = Math.max(1.0f, f3 - 12.0f);
            float f7 = f2 + 71.0f;
            float f8 = 3.0f;
            iII.drawRoundedRect(f5 + f8, f7 - 0.25f, Math.max(1.0f, f6 - 6.0f), 0.5f, IIiii_Class8.I_method_893b2757(0.25f), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(30.599998f * f4));
            float[] fArray = this.I_method_6aaaf7f5(iIiIIIIiI_Class67);
            if (fArray.length < 2) {
                return;
            }
            float f9 = 0.0f;
            for (float f10 : fArray) {
                f9 = Math.max(f9, f10);
            }
            if (f9 <= 0.0f) {
                f9 = 1.0f;
            }
            float f11 = 17.0f;
            float f12 = (f6 - 6.0f) / (float)(fArray.length - 1);
            Vec2f[] vec2fArray = new Vec2f[fArray.length];
            for (int i = 0; i < fArray.length; ++i) {
                vec2fArray[i] = new Vec2f(f5 + f8 + f12 * (float)i, f7 - f11 * (fArray[i] / f9));
            }
            ColorRGBA colorRGBA = IiiiiIIIi_Class242.i_method_5dfec6e();
            this.I_method_a632a9c3(iII, vec2fArray, f7, colorRGBA, f4);
            this.I_method_c76216e1(iII, vec2fArray, f5, f2 + 54.0f - 2.0f, f6, f11 + 4.0f, colorRGBA.withAlpha(191.25f * f4));
            Vec2f vec2f = vec2fArray[vec2fArray.length - 1];
            iII.drawRoundedRect(vec2f.x - 1.5f, vec2f.y - 1.5f, 3.0f, 3.0f, IIiii_Class8.I_method_893b2757(1.5f), colorRGBA.withAlpha(255.0f * f4));
        }

        private void I_method_a632a9c3(III iII, Vec2f[] vec2fArray, float f, ColorRGBA colorRGBA, float f2) {
            int n = (vec2fArray.length - 1) * 6 + 1;
            float[] fArray = new float[n];
            float[] fArray2 = new float[n];
            int n2 = 0;
            for (int i = 0; i < vec2fArray.length - 1; ++i) {
                Vec2f[] vec2fArray2 = this.I_method_92450af1(vec2fArray, i);
                for (int j = 0; j < 6; ++j) {
                    float f3 = (float)j / 6.0f;
                    fArray[n2] = (float)iIIiiiiiI_Class319.I_method_7f6601cd(f3, vec2fArray[i].x, vec2fArray2[0].x, vec2fArray2[1].x, vec2fArray[i + 1].x);
                    fArray2[n2] = (float)iIIiiiiiI_Class319.I_method_7f6601cd(f3, vec2fArray[i].y, vec2fArray2[0].y, vec2fArray2[1].y, vec2fArray[i + 1].y);
                    ++n2;
                }
            }
            fArray[n2] = vec2fArray[vec2fArray.length - 1].x;
            fArray2[n2] = vec2fArray[vec2fArray.length - 1].y;
            iII.drawAreaGradient(fArray, fArray2, f, colorRGBA.withAlpha(63.75f * f2), colorRGBA.withAlpha(0.0f));
        }

        private Vec2f[] I_method_92450af1(Vec2f[] vec2fArray, int n) {
            Vec2f vec2f = vec2fArray[Math.max(0, n - 1)];
            Vec2f vec2f2 = vec2fArray[n];
            Vec2f vec2f3 = vec2fArray[n + 1];
            Vec2f vec2f4 = vec2fArray[Math.min(vec2fArray.length - 1, n + 2)];
            return new Vec2f[]{new Vec2f(vec2f2.x + (vec2f3.x - vec2f.x) / 6.0f, vec2f2.y + (vec2f3.y - vec2f.y) / 6.0f), new Vec2f(vec2f3.x - (vec2f4.x - vec2f2.x) / 6.0f, vec2f3.y - (vec2f4.y - vec2f2.y) / 6.0f)};
        }

        private void I_method_c76216e1(III iII, Vec2f[] vec2fArray, float f, float f2, float f3, float f4, ColorRGBA colorRGBA) {
            for (int i = 0; i < vec2fArray.length - 1; ++i) {
                Vec2f vec2f = vec2fArray[i];
                Vec2f vec2f2 = vec2fArray[i + 1];
                Vec2f[] vec2fArray2 = this.I_method_92450af1(vec2fArray, i);
                Vec2f vec2f3 = vec2fArray2[0];
                Vec2f vec2f4 = vec2fArray2[1];
                float f5 = Math.max(f, Math.min(Math.min(vec2f.x, vec2f2.x), Math.min(vec2f3.x, vec2f4.x)) - 2.0f);
                float f6 = Math.min(f + f3, Math.max(Math.max(vec2f.x, vec2f2.x), Math.max(vec2f3.x, vec2f4.x)) + 2.0f);
                float f7 = Math.max(f2, Math.min(Math.min(vec2f.y, vec2f2.y), Math.min(vec2f3.y, vec2f4.y)) - 2.0f);
                float f8 = Math.min(f2 + f4, Math.max(Math.max(vec2f.y, vec2f2.y), Math.max(vec2f3.y, vec2f4.y)) + 2.0f);
                iII.drawSmoothBezier(f5, f7, f6 - f5, f8 - f7, vec2f, vec2f3, vec2f4, vec2f2, 1.0f, colorRGBA);
            }
        }

        private float[] I_method_6aaaf7f5(IIiIIIIiI_Class67 iIiIIIIiI_Class67) {
            int n;
            int n2;
            int n3;
            long[] lArray = iIiIIIIiI_Class67.I_method_59b9753e(IiIiiiiII_Class189.this.I_method_1b404b35());
            if (lArray.length < 2) {
                return new float[0];
            }
            int n4 = Math.min(16, lArray.length);
            float[] fArray = new float[n4];
            for (int i = 0; i < n4; ++i) {
                n3 = (int)((long)(i + 1) * (long)lArray.length / (long)n4);
                n2 = (int)((long)i * (long)lArray.length / (long)n4);
                if (n3 <= n2) {
                    n3 = n2 + 1;
                }
                long l = 0L;
                for (n = n2; n < n3 && n < lArray.length; ++n) {
                    l += lArray[n];
                }
                fArray[i] = (float)l / (float)(n3 - n2);
            }
            float[] fArray2 = new float[n4];
            n2 = Math.max(0, 1);
            for (n3 = 0; n3 < n4; ++n3) {
                float f = 0.0f;
                int n5 = 0;
                for (n = n3 - n2; n <= n3 + n2; ++n) {
                    if (n < 0 || n >= n4) continue;
                    f += fArray[n];
                    ++n5;
                }
                fArray2[n3] = n5 == 0 ? fArray[n3] : f / (float)n5;
            }
            return fArray2;
        }

        private float iII_method_290cf90a() {
            IIiIIIIiI_Class67 iIiIIIIiI_Class67 = IiIiiiiII_Class189.this.I_method_1b404755();
            if (iIiIIIIiI_Class67 == null) {
                return 22.0f;
            }
            IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
            float f = 19.0f + IiIiiiiII_Class189.I_method_817ff3fa(iIiIIi_Class10, this.I_method_ac066446()) + IiIiiiiII_Class189.I_method_817ff3fa(iIiIIi_Class10, IIiIIIIiI_Class67.i_method_46fbfebb(iIiIIIIiI_Class67.I_method_3ea4be33())) + 7.0f;
            return Math.min(f, 128.0f);
        }
    }

    static final class Nested1_4316a040 {
        private static final float I_field_46 = 4.0f;
        private static final int I_field_49 = 400;
        private final List<Nested2_d7ef94e5> I_field_7865b31 = new ArrayList<Nested2_d7ef94e5>();
        private String I_field_523beb0a = "";

        Nested1_4316a040() {
        }

        String I_method_f2398c66() {
            return this.I_field_523beb0a;
        }

        void I_method_f9b88ac4(String string) {
            if (string == null) {
                string = "";
            }
            if (string.equals(this.I_field_523beb0a)) {
                return;
            }
            boolean bl = string.length() != this.I_field_523beb0a.length();
            this.I_field_523beb0a = string;
            while (this.I_field_7865b31.size() < string.length()) {
                this.I_field_7865b31.add(new Nested2_d7ef94e5());
            }
            while (this.I_field_7865b31.size() > string.length()) {
                this.I_field_7865b31.remove(this.I_field_7865b31.size() - 1);
            }
            for (int i = 0; i < string.length(); ++i) {
                Nested2_d7ef94e5 nested2_d7ef94e5 = this.I_field_7865b31.get(i);
                char c = string.charAt(i);
                if (c == nested2_d7ef94e5.i_field_43) continue;
                nested2_d7ef94e5.I_field_43 = bl ? (char)'\u0000' : nested2_d7ef94e5.i_field_43;
                nested2_d7ef94e5.i_field_43 = c;
                nested2_d7ef94e5.I_field_b575d2cc.i_method_84a13e41(bl ? 1.0f : 0.0f);
                if (bl) continue;
                nested2_d7ef94e5.I_field_b575d2cc.I_method_82de4e21(1.0f);
            }
        }

        void I_method_8bc44b86(float f) {
            for (Nested2_d7ef94e5 nested2_d7ef94e5 : this.I_field_7865b31) {
                nested2_d7ef94e5.I_field_b575d2cc.Ii_method_dc72325e(f);
            }
        }

        void I_method_e5052d92(III iII, IIiIIi_Class10 iIiIIi_Class10, float f, float f2, ColorRGBA colorRGBA) {
            float f3 = f;
            for (Nested2_d7ef94e5 nested2_d7ef94e5 : this.I_field_7865b31) {
                float f4 = nested2_d7ef94e5.I_field_b575d2cc.I_method_4e8b496f();
                this.I_method_92add46f(iII, iIiIIi_Class10, nested2_d7ef94e5.I_field_43, f3, f2, colorRGBA, 1.0f - f4, 4.0f * f4);
                this.I_method_92add46f(iII, iIiIIi_Class10, nested2_d7ef94e5.i_field_43, f3, f2, colorRGBA, f4, 4.0f * (f4 - 1.0f));
                f3 += IiIiiiiII_Class189.I_method_eb6ca2d(iIiIIi_Class10, nested2_d7ef94e5.i_field_43);
            }
        }

        private void I_method_92add46f(III iII, IIiIIi_Class10 iIiIIi_Class10, char c, float f, float f2, ColorRGBA colorRGBA, float f3, float f4) {
            if (c == '\u0000' || f3 <= 0.004f) {
                return;
            }
            iII.drawText(iIiIIi_Class10, String.valueOf(c), f, f2 + f4, colorRGBA.withAlpha(colorRGBA.getAlpha() * f3));
        }

        static final class Nested2_d7ef94e5 {
            char I_field_43;
            char i_field_43;
            final IiI_Class3 I_field_b575d2cc = new IiI_Class3(1.0f, IIii_Class4.I_method_3682ece9(400L, IiiiIiiII_Class237.I_field_dd60aac));

            Nested2_d7ef94e5() {
            }
        }
    }
}

