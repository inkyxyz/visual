package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.SectionSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;

public class IiiiIIIii_Class228
extends IiiIiiIii_Class220<SectionSetting> {
    private static final float III_field_46 = 10.0f;
    private static final float IIi_field_46 = 19.0f;
    private static final float IiI_field_46 = 3.0f;

    public IiiiIIIii_Class228(SectionSetting iIiiiiIii_Class124, iI_Class3 iI_Class32) {
        super(iIiiiiIii_Class124, iI_Class32);
    }

    @Override
    public void I_method_575ca63f() {
        this.II_field_46 = 13.0f;
        this.Ii_field_46 = 8.0f;
        super.I_method_575ca63f();
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        float f = this.I_field_46 + 8.0f;
        float f2 = this.i_field_46 + 15.0f;
        float f3 = this.II_field_46 - 16.0f;
        float f4 = this.Ii_field_46 - 20.0f;
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        if (this.I_method_7ae26dde(iII) && ((SectionSetting)this.I_field_ba11c26c).isVisible() && this.I_method_c4c8e2f8().I_method_7ae26dde(iII)) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        IIiIIi_Class10 iIiIIi_Class10 = (((SectionSetting)this.I_field_ba11c26c).i_method_9b12da03() ? IIiIiI_Class11.II_field_857c0621 : IIiIiI_Class11.Ii_field_857c0621).I_method_3a2d5e3(8 + ((SectionSetting)this.I_field_ba11c26c).I_method_23922e32());
        if (!((SectionSetting)this.I_field_ba11c26c).i_method_9b12da03()) {
            this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((SectionSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + 10.0f, this.i_field_46 + iIIiIIIiI_Class291.I_method_ef5e7a8f(iIiIIi_Class10.I_method_a649725c(), 19.0f) - 0.5f - 0.5f * (float)((SectionSetting)this.I_field_ba11c26c).I_method_23922e32(), f3, IiiiiIIIi_Class242.iI_method_8e08d3b1(), 0.7f, 0.99f);
        }
    }

    @Override
    public void Ii_method_6b12c484(III iII) {
        if (!((SectionSetting)this.I_field_ba11c26c).i_method_9b12da03()) {
            return;
        }
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8 + ((SectionSetting)this.I_field_ba11c26c).I_method_23922e32());
        float f = this.I_field_46 + 8.0f;
        float f2 = this.II_field_46 - 16.0f;
        float f3 = 0.0f;
        for (String string : this.I_method_8f26d4c7(iIiIIi_Class10, f2 - 10.0f)) {
            iII.drawText(iIiIIi_Class10, string, this.I_field_46 + 10.0f + (((SectionSetting)this.I_field_ba11c26c).II_method_4ec29106() ? f2 / 2.0f - iIiIIi_Class10.I_method_2c375926(string) / 2.0f - 1.0f : 0.0f), this.i_field_46 + iIIiIIIiI_Class291.I_method_ef5e7a8f(iIiIIi_Class10.I_method_a649725c(), 19.0f) - 0.5f - 0.5f * (float)((SectionSetting)this.I_field_ba11c26c).I_method_23922e32() + f3, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.75f * RenderSystem.getShaderColor()[3]));
            f3 += iIiIIi_Class10.I_method_a649725c() + 3.0f;
        }
    }

    @Override
    public void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    public float Ii_method_2047ead7() {
        if (!((SectionSetting)this.I_field_ba11c26c).i_method_9b12da03()) {
            this.Ii_field_46 = 18.0f;
            return 18.0f;
        }
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8 + ((SectionSetting)this.I_field_ba11c26c).I_method_23922e32());
        int n = this.I_method_8f26d4c7(iIiIIi_Class10, this.II_field_46 - 26.0f).size();
        this.Ii_field_46 = Math.max(18.0f, 19.0f + (float)Math.max(0, n - 1) * (iIiIIi_Class10.I_method_a649725c() + 3.0f) + 2.0f);
        return this.Ii_field_46;
    }

    private List<String> I_method_8f26d4c7(IIiIIi_Class10 iIiIIi_Class10, float f) {
        String[] stringArray = IiIiIIII_Class81.I_method_f25a980a(((SectionSetting)this.I_field_ba11c26c).getName()).split(" ");
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = 0;
        f = Math.max(1.0f, f);
        for (String string : stringArray) {
            if (!arrayList.isEmpty() && iIiIIi_Class10.I_method_2c375926((String)arrayList.get(n) + " " + string) > f) {
                ++n;
            }
            if (arrayList.size() - 1 < n) {
                arrayList.add(string);
                continue;
            }
            arrayList.set(n, (String)arrayList.get(n) + " " + string);
        }
        return arrayList;
    }
}

