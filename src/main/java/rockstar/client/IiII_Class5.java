package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Function;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiI_Class3;
import rockstar.client.IiIi_Class6;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iii_Class8;

public class IiII_Class5 {
    private final iii_Class8 I_field_b584628c;
    private float I_field_46 = 3.0f;
    private float i_field_46 = 1.5f;
    private float II_field_46 = 0.0f;
    private float Ii_field_46 = 0.0f;
    private float iI_field_46 = 16.0f;
    private float ii_field_46 = -1.0f;
    private float III_field_46 = 900.0f;
    private IiIi_Class6 I_field_f9448c81 = IiIi_Class6.I_field_f9448c81;
    private Function<IiII_Class5, ColorRGBA> I_field_aad1658 = iiII_Class5 -> ColorRGBA.WHITE.withAlpha(0.0f);
    private Function<IiII_Class5, ColorRGBA> i_field_aad1658 = iiII_Class5 -> ColorRGBA.WHITE.withAlpha(255.0f * (0.32f + 0.28f * iiII_Class5.I_method_af833bdc() + 0.3f * iiII_Class5.i_method_af91c7bc()));
    private Nested1_289309b3 I_field_ba44971c;
    private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(0.0f, IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.IIii_field_dd60aac));
    private final IiI_Class3 i_field_b575d2cc = new IiI_Class3(0.0f, IIii_Class4.iI_field_f93678c1);
    private float IIi_field_46 = 0.0f;
    private boolean I_field_5a = false;
    private float IiI_field_46 = 0.0f;
    private boolean i_field_5a = true;
    private float Iii_field_46;
    private float iII_field_46;
    private float iIi_field_46;
    private float iiI_field_46;
    private float iii_field_46;
    private float IIII_field_46;
    private float IIIi_field_46;
    private float IIiI_field_46;
    private float IIii_field_46;
    private float IiII_field_46;
    private float IiIi_field_46;

    public IiII_Class5(iii_Class8 iii_Class82) {
        this.I_field_b584628c = iii_Class82;
    }

    public IiII_Class5 I_method_5809826a(IiIi_Class6 iiIi_Class6) {
        this.I_field_f9448c81 = iiIi_Class6 == null ? IiIi_Class6.I_field_f9448c81 : iiIi_Class6;
        return this;
    }

    public IiII_Class5 I_method_2a080a63(float f) {
        this.I_field_46 = Math.max(1.0f, f);
        return this;
    }

    public IiII_Class5 i_method_65326e43(float f) {
        this.i_field_46 = f;
        return this;
    }

    public IiII_Class5 II_method_e6aaaac(float f) {
        this.II_field_46 = this.Ii_field_46 = f;
        return this;
    }

    public IiII_Class5 I_method_4f0ff9cb(float f, float f2) {
        this.II_field_46 = f;
        this.Ii_field_46 = f2;
        return this;
    }

    public IiII_Class5 Ii_method_49950e8c(float f) {
        this.iI_field_46 = Math.max(4.0f, f);
        return this;
    }

    public IiII_Class5 iI_method_388cc2cc(float f) {
        this.ii_field_46 = f;
        return this;
    }

    public IiII_Class5 ii_method_73b726ac(float f) {
        this.III_field_46 = Math.max(0.0f, f);
        return this;
    }

    public IiII_Class5 I_method_552a8b91(Function<IiII_Class5, ColorRGBA> function) {
        this.I_field_aad1658 = function;
        return this;
    }

    public IiII_Class5 I_method_2fbc6104(ColorRGBA colorRGBA) {
        this.I_field_aad1658 = iiII_Class5 -> colorRGBA;
        return this;
    }

    public IiII_Class5 i_method_989a5f71(Function<IiII_Class5, ColorRGBA> function) {
        this.i_field_aad1658 = function;
        return this;
    }

    public IiII_Class5 i_method_cd5f44e4(ColorRGBA colorRGBA) {
        this.i_field_aad1658 = iiII_Class5 -> colorRGBA;
        return this;
    }

    public IiII_Class5 I_method_e260bd2f(Nested1_289309b3 nested1_289309b3) {
        this.I_field_ba44971c = nested1_289309b3;
        return this;
    }

    public float I_method_af833bdc() {
        return this.i_field_b575d2cc.I_method_4e8b496f();
    }

    public float i_method_af91c7bc() {
        return this.I_field_5a ? 1.0f : 0.0f;
    }

    public float II_method_40f338e5() {
        return this.I_field_b575d2cc.I_method_4e8b496f();
    }

    public boolean I_method_af833bf0() {
        return this.i_field_5a;
    }

    public float Ii_method_4101c4c5() {
        return this.ii_field_46 < 0.0f ? this.I_field_46 / 2.0f - 0.5f : this.ii_field_46;
    }

    public float iI_method_42b62905() {
        return this.iii_field_46;
    }

    public float ii_method_42c4b4e5() {
        return this.IIII_field_46;
    }

    public float III_method_dd82dcfc() {
        return this.IIIi_field_46;
    }

    public float IIi_method_dd9168dc() {
        return this.IIiI_field_46;
    }

    public float IiI_method_df45cd1c() {
        return this.Iii_field_46;
    }

    public float Iii_method_df5458fc() {
        return this.iII_field_46;
    }

    public float iII_method_141df0dc() {
        return this.iIi_field_46;
    }

    public float iIi_method_142c7cbc() {
        return this.iiI_field_46;
    }

    public IiIi_Class6 I_method_cdff8aab() {
        return this.I_field_f9448c81;
    }

    void I_method_af833bec() {
        this.IIi_field_46 = this.III_field_46;
    }

    void I_method_9a6c9c54(float f, float f2, float f3) {
        boolean bl;
        boolean bl2 = bl = this.I_field_b584628c.I_method_814bf943() && this.I_field_f9448c81 != IiIi_Class6.II_field_f9448c81;
        if (bl) {
            this.II_method_40f338f5();
        }
        boolean bl3 = bl && this.I_method_86b682f0(f2, f3, this.iii_field_46, this.IIII_field_46, this.IIIi_field_46, this.IIiI_field_46);
        boolean bl4 = bl && this.I_method_dbb0e8f0(f2, f3);
        this.i_field_b575d2cc.I_method_82de4e21(bl3 ? 1.0f : 0.0f);
        if (this.IIi_field_46 > 0.0f) {
            this.IIi_field_46 = Math.max(0.0f, this.IIi_field_46 - f);
        }
        if (this.I_field_5a && !iIIiIIIiI_Class291.I_method_f734a088(0)) {
            this.I_field_5a = false;
        }
        if (this.I_field_5a) {
            this.I_method_dbb0e8ec(f2, f3);
        }
        boolean bl5 = this.I_field_f9448c81 == IiIi_Class6.i_field_f9448c81 || this.IIi_field_46 > 0.0f || bl4 || this.I_field_5a;
        this.I_field_b575d2cc.I_method_82de4e21(bl && bl5 ? 1.0f : 0.0f);
        this.I_field_b575d2cc.Ii_method_dc72325e(f);
        this.i_field_b575d2cc.Ii_method_dc72325e(f);
    }

    private void II_method_40f338f5() {
        this.i_field_5a = this.I_field_b584628c.I_method_485b50f5().I_method_ade97d43();
        float f = this.I_field_b584628c.I_method_814bf92f();
        float f2 = this.I_field_b584628c.i_method_815a850f();
        float f3 = this.I_field_b584628c.II_method_a84225f2();
        float f4 = this.I_field_b584628c.Ii_method_a850b1d2();
        float f5 = this.I_field_b584628c.ii_method_aa13a1f2();
        float f6 = Math.max(0.0f, this.I_field_b584628c.iI_method_aa051612() - f5);
        float f7 = Math.max(0.0f, this.I_field_b584628c.III_method_6011918f() - f5);
        float f8 = this.I_field_b584628c.IiI_method_61d481af();
        this.IIii_field_46 = Math.max(0.0f, f6 - this.II_field_46 - this.Ii_field_46);
        float f9 = this.IiII_field_46 = f7 > 0.0f ? Math.max(this.iI_field_46, this.IIii_field_46 * (f6 / f7)) : this.IIii_field_46;
        if (this.IiII_field_46 > this.IIii_field_46) {
            this.IiII_field_46 = this.IIii_field_46;
        }
        float f10 = this.IIii_field_46 - this.IiII_field_46;
        float f11 = f8 > 0.0f ? IiII_Class5.I_method_9a6c9c44(this.I_field_b584628c.IIi_method_60201d6f() / f8, 0.0f, 1.0f) : 0.0f;
        this.IiIi_field_46 = f11 * f10;
        if (this.i_field_5a) {
            this.iIi_field_46 = this.I_field_46;
            this.iiI_field_46 = this.IIii_field_46;
            this.Iii_field_46 = f + f3 - this.I_field_46 - this.i_field_46;
            this.iII_field_46 = f2 + f5 + this.II_field_46;
            this.iii_field_46 = this.Iii_field_46;
            this.IIII_field_46 = this.iII_field_46 + this.IiIi_field_46;
            this.IIIi_field_46 = this.I_field_46;
            this.IIiI_field_46 = this.IiII_field_46;
        } else {
            this.iIi_field_46 = this.IIii_field_46;
            this.iiI_field_46 = this.I_field_46;
            this.Iii_field_46 = f + f5 + this.II_field_46;
            this.iII_field_46 = f2 + f4 - this.I_field_46 - this.i_field_46;
            this.iii_field_46 = this.Iii_field_46 + this.IiIi_field_46;
            this.IIII_field_46 = this.iII_field_46;
            this.IIIi_field_46 = this.IiII_field_46;
            this.IIiI_field_46 = this.I_field_46;
        }
    }

    private void I_method_dbb0e8ec(float f, float f2) {
        float f3 = this.IIii_field_46 - this.IiII_field_46;
        float f4 = (this.i_field_5a ? f2 - this.iII_field_46 : f - this.Iii_field_46) - this.IiI_field_46;
        f4 = IiII_Class5.I_method_9a6c9c44(f4, 0.0f, f3);
        float f5 = f3 > 0.0f ? f4 / f3 : 0.0f;
        this.I_field_b584628c.I_method_a8339661(f5 * this.I_field_b584628c.IiI_method_61d481af());
        this.IIi_field_46 = this.III_field_46;
    }

    void I_method_ea088746(III iII, float f) {
        if (this.I_field_f9448c81 == IiIi_Class6.II_field_f9448c81 || !this.I_field_b584628c.I_method_814bf943()) {
            return;
        }
        float f2 = this.I_field_b575d2cc.I_method_4e8b496f();
        if (f2 <= 0.01f) {
            return;
        }
        this.II_method_40f338f5();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)(f * f2));
        if (this.I_field_ba44971c != null) {
            this.I_field_ba44971c.I_method_635fd780(iII, this);
        } else {
            ColorRGBA colorRGBA;
            float f3 = this.Ii_method_4101c4c5();
            ColorRGBA colorRGBA2 = this.I_field_aad1658.apply(this);
            if (colorRGBA2 != null && colorRGBA2.getAlpha() > 0.0f) {
                iII.drawRoundedRect(this.Iii_field_46, this.iII_field_46, this.iIi_field_46, this.iiI_field_46, IIiii_Class8.I_method_893b2757(f3), colorRGBA2);
            }
            if ((colorRGBA = this.i_field_aad1658.apply(this)) != null && colorRGBA.getAlpha() > 0.0f) {
                iII.drawRoundedRect(this.iii_field_46, this.IIII_field_46, this.IIIi_field_46, this.IIiI_field_46, IIiii_Class8.I_method_893b2757(f3), colorRGBA);
            }
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f);
    }

    boolean I_method_9a6ce76c(float f, float f2, boolean bl) {
        if (!bl || this.I_field_f9448c81 == IiIi_Class6.II_field_f9448c81 || !this.I_field_b584628c.I_method_814bf943()) {
            return false;
        }
        if (this.I_field_b575d2cc.I_method_4e8b496f() < 0.05f && !this.I_method_dbb0e8f0(f, f2)) {
            return false;
        }
        this.II_method_40f338f5();
        if (this.I_method_86b682f0(f, f2, this.iii_field_46, this.IIII_field_46, this.IIIi_field_46, this.IIiI_field_46)) {
            this.I_field_5a = true;
            this.IiI_field_46 = this.i_field_5a ? f2 - this.IIII_field_46 : f - this.iii_field_46;
            this.IIi_field_46 = this.III_field_46;
            return true;
        }
        if (this.I_method_86b682f0(f, f2, this.Iii_field_46, this.iII_field_46, this.iIi_field_46, this.iiI_field_46)) {
            float f3 = this.i_field_5a ? f2 - this.iII_field_46 : f - this.Iii_field_46;
            float f4 = IiII_Class5.I_method_9a6c9c44(f3 / Math.max(1.0f, this.IIii_field_46), 0.0f, 1.0f);
            this.I_field_b584628c.I_method_a8339661(f4 * this.I_field_b584628c.IiI_method_61d481af());
            this.IIi_field_46 = this.III_field_46;
            return true;
        }
        return false;
    }

    void i_method_af91c7cc() {
        this.I_field_5a = false;
    }

    private boolean I_method_86b682f0(float f, float f2, float f3, float f4, float f5, float f6) {
        return f >= f3 && f <= f3 + f5 && f2 >= f4 && f2 <= f4 + f6;
    }

    private boolean I_method_dbb0e8f0(float f, float f2) {
        float f3 = this.I_field_46 + this.i_field_46 + 6.0f;
        if (this.i_field_5a) {
            float f4 = Math.max(this.Iii_field_46 + this.iIi_field_46, this.Iii_field_46 + this.iIi_field_46 + this.i_field_46);
            return f >= Math.min(this.Iii_field_46, this.Iii_field_46 - f3) && f <= f4 && f2 >= this.iII_field_46 && f2 <= this.iII_field_46 + this.IIii_field_46;
        }
        float f5 = Math.max(this.iII_field_46 + this.iiI_field_46, this.iII_field_46 + this.iiI_field_46 + this.i_field_46);
        return f2 >= Math.min(this.iII_field_46, this.iII_field_46 - f3) && f2 <= f5 && f >= this.Iii_field_46 && f <= this.Iii_field_46 + this.IIii_field_46;
    }

    private static float I_method_9a6c9c44(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static interface Nested1_289309b3 {
        public void I_method_635fd780(III var1, IiII_Class5 var2);
    }
}

