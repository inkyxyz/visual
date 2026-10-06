package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.render.VertexFormats;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIiIiIi_Class150;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iIiiiiIiI_Class379;
import rockstar.client.iiIIIIIiI_Class387;
import rockstar.client.iiIIIiiIi_Class398;
import rockstar.client.iiIiIIiii_Class424;

public class IiiiIIiii_Class232
extends IiiIiiIii_Class220<MultiSelectSetting> {
    private IiIIiIiIi_Class150 I_field_a9c12e4c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private final Map<MultiSelectSetting.Nested1_42856060, Nested1_f8510840> I_field_a567c40b = new HashMap<MultiSelectSetting.Nested1_42856060, Nested1_f8510840>();
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private boolean I_field_5a;

    public IiiiIIiii_Class232(MultiSelectSetting iIiiiiiii_Class128, iI_Class3 iI_Class32) {
        super(iIiiiiiii_Class128, iI_Class32);
        ArrayList arrayList = new ArrayList();
        iIiiiiiii_Class128.I_method_45aaa648().forEach(nested1_42856060 -> {
            if (nested1_42856060.isSelected()) {
                arrayList.add(nested1_42856060);
            }
        });
        iIiiiiiii_Class128.i_method_faf6de68().clear();
        iIiiiiiii_Class128.i_method_faf6de68().addAll(arrayList);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        if (!this.I_field_5a) {
            for (MultiSelectSetting.Nested1_42856060 nested1_428560602 : ((MultiSelectSetting)this.I_field_ba11c26c).I_method_45aaa648()) {
                nested1_428560602.setEnablePenis(new iiIIIiiIi_Class398(RockstarClient.id("penises/check_enable.penis")));
                nested1_428560602.setDisablePenis(new iiIIIiiIi_Class398(RockstarClient.id("penises/check_disable.penis")));
                nested1_428560602.setLastState(nested1_428560602.isSelected());
                nested1_428560602.setCurrentPenis(nested1_428560602.isLastState() ? nested1_428560602.getEnablePenis() : nested1_428560602.getDisablePenis());
                if (nested1_428560602.isLastState()) {
                    nested1_428560602.getEnablePenis().I_method_73113e1f();
                    continue;
                }
                nested1_428560602.getDisablePenis().I_method_ef16f8c4(0);
                nested1_428560602.getDisablePenis().iI_method_f0e86d42();
            }
            this.I_field_5a = true;
        }
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 1.0f;
        float f3 = this.II_field_46 - 18.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        float f4 = 10.0f;
        float f5 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        float f6 = 19.0f;
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        long l = ((MultiSelectSetting)this.I_field_ba11c26c).I_method_45aaa648().stream().filter(nested1_42856060 -> !nested1_42856060.isHidden()).count();
        int n = Math.toIntExact(((MultiSelectSetting)this.I_field_ba11c26c).i_method_faf6de68().stream().filter(nested1_42856060 -> !nested1_42856060.isHidden()).count());
        String string = String.format(" %s", IiIiIIII_Class81.I_method_f25a980a("setting_of") + " " + l);
        if (this.I_field_a9c12e4c == null) {
            this.I_field_a9c12e4c = new IiIIiIiIi_Class150(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), 5.0f, 500L, IiiiIiiII_Class237.I_field_dd60aac);
        }
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((MultiSelectSetting)this.I_field_ba11c26c).getName()), this.I_field_46 + f4, f2 - 1.0f + iIIiIIIiI_Class291.I_method_ef5e7a8f(iIiIIi_Class10.I_method_a649725c(), f6), this.I_method_c4c8e2f8().II_method_c7206932() - f4 - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(string) - this.I_field_a9c12e4c.II_method_c7206932() - 10.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.8f, 1.0f);
        this.I_field_a9c12e4c.I_method_8cf9646a(false, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())));
        this.I_field_a9c12e4c.I_method_c711e4e4(n);
        this.I_field_a9c12e4c.I_method_a74dc6cc(f + f3 - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(string) - this.I_field_a9c12e4c.II_method_c7206932(), f2 - 1.0f + iIIiIIIiI_Class291.I_method_ef5e7a8f(f5, f6));
        this.I_field_a9c12e4c.I_method_7ae26dda(iII);
        iII.drawRoundedRect(f - 1.0f, f2 + 17.0f, f3 + 2.0f, 8.0f + this.IiI_method_bd31deaf(), IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(76.5f));
        float f7 = 0.0f;
        for (MultiSelectSetting.Nested1_42856060 object : ((MultiSelectSetting)this.I_field_ba11c26c).I_method_45aaa648()) {
            if (object.isHidden()) continue;
            boolean nested1_428560603 = object.isSelected();
            if (nested1_428560603 != object.isLastState()) {
                if (nested1_428560603) {
                    object.setCurrentPenis(object.getEnablePenis());
                } else {
                    object.setCurrentPenis(object.getDisablePenis());
                }
                object.getCurrentPenis().I_method_73113e1f();
                object.setLastState(nested1_428560603);
            }
            object.getCurrentPenis().i_method_731fc9ff();
            float f8 = this.I_field_51de8227 == object ? Math.clamp((float)(iII.i_method_b1d26d32() - 2), f2 + 18.0f, f2 + 20.0f + this.IiI_method_bd31deaf()) : f2 + 24.0f + f7;
            boolean bl = iIIiIIIiI_Class291.I_method_c3fabb03(f - 1.0f, f8 - 4.0f, f3 + 2.0f, 12.0, iII.I_method_b1c3e152(), iII.i_method_b1d26d32());
            object.getYAnim().I_method_df2f9087(IiiiIiiII_Class237.i_field_dd60aac);
            object.getYAnim().I_method_edd6dd11(f8 - f2);
            object.setYFactor(f8);
            if (bl && this.I_field_51de8227 != object && !object.isAlwaysEnabled() && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            object.getHoverAnimation().I_method_edd72835(bl);
            object.getActiveAnimation().I_method_edd72835(object.isSelected());
            if ((iIIiIIIiI_Class291.I_method_da20b32b(f, f8 - 2.0f, 17.0, 10.0, iII) || object == this.I_field_51de8227) && ((MultiSelectSetting)this.I_field_ba11c26c).i_method_9b12da03()) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.Ii_field_aa52e62c);
            }
            this.I_method_380df530(iII, object, IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), IiIiIIII_Class81.I_method_f25a980a(object.getName()), f + (float)(((MultiSelectSetting)this.I_field_ba11c26c).i_method_9b12da03() ? 18 : 7), f2 + object.getYAnim().I_method_6ac4da6f() + 0.5f, f3 - (float)(((MultiSelectSetting)this.I_field_ba11c26c).i_method_9b12da03() ? 30 : 19) - object.getActiveAnimation().I_method_6ac4da6f() * 9.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * object.getHoverAnimation().I_method_6ac4da6f() + 0.25f * object.getActiveAnimation().I_method_6ac4da6f())), bl);
            if (object.getActiveAnimation().I_method_6ac4da6f() > 0.0f || object.getCurrentPenis().i_method_731fca03()) {
                iIiiIIiii_Class360.I_method_e888eaca(iII.getMatrices(), object.getCurrentPenis().I_method_1f8cc735(), f + f3 - 11.0f - object.getActiveAnimation().I_method_6ac4da6f() * 2.0f, f2 + object.getYAnim().I_method_6ac4da6f(), 6.0f, 6.0f, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.1f + 0.9f * object.getActiveAnimation().I_method_6ac4da6f()));
            }
            f7 += 12.0f;
        }
        if (((MultiSelectSetting)this.I_field_ba11c26c).i_method_9b12da03()) {
            iiIIIIIiI_Class387 iiIIIIIiI_Class3872 = new iiIIIIIiI_Class387(VertexFormats.POSITION_TEXTURE_COLOR, iII.getMatrices());
            for (MultiSelectSetting.Nested1_42856060 nested1_428560602 : ((MultiSelectSetting)this.I_field_ba11c26c).I_method_45aaa648()) {
                if (nested1_428560602.isHidden()) continue;
                iII.drawIcon("hud/drag", f + 7.0f, f2 + nested1_428560602.getYAnim().I_method_6ac4da6f(), 6.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
            }
            ((iIiiiiIiI_Class379)iiIIIIIiI_Class3872).II_method_ed687102();
        }
        if (this.I_field_51de8227 != null && this.I_field_991c1e8c.I_method_58432069(100L) && ((MultiSelectSetting)this.I_field_ba11c26c).i_method_9b12da03()) {
            ((MultiSelectSetting)this.I_field_ba11c26c).notifyChanged();
            ((MultiSelectSetting)this.I_field_ba11c26c).I_method_45aaa648().sort(Comparator.comparingDouble(MultiSelectSetting.Nested1_42856060::getYFactor));
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
    }

    @Override
    public void Ii_method_6b12c484(III iII) {
        if (this.I_field_a9c12e4c == null) {
            return;
        }
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 1.0f;
        float f3 = this.II_field_46 - 18.0f;
        float f4 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c();
        float f5 = 19.0f;
        long l = ((MultiSelectSetting)this.I_field_ba11c26c).I_method_45aaa648().stream().filter(nested1_42856060 -> !nested1_42856060.isHidden()).count();
        String string = String.format(" %s", IiIiIIII_Class81.I_method_f25a980a("setting_of") + " " + l);
        iII.drawRightText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), string, f + f3, f2 - 1.0f + iIIiIIIiI_Class291.I_method_ef5e7a8f(f4, f5), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f()) * RenderSystem.getShaderColor()[3]));
    }

    private void I_method_380df530(III iII, MultiSelectSetting.Nested1_42856060 nested1_428560602, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, float f3, ColorRGBA colorRGBA, boolean bl) {
        float f4 = Math.max(1.0f, f3);
        float f5 = iIiIIi_Class10.I_method_2c375926(string);
        long l = System.currentTimeMillis();
        Nested1_f8510840 nested1_f8510840 = this.I_field_a567c40b.computeIfAbsent(nested1_428560602, nested1_42856060 -> new Nested1_f8510840());
        float f6 = Math.max(0.0f, f5 - f4);
        float f7 = (float)(l - nested1_f8510840.I_field_4a) / 1000.0f;
        nested1_f8510840.I_field_4a = l;
        if (f6 <= 0.0f) {
            nested1_f8510840.I_method_7590c28a(l);
        } else if (bl) {
            nested1_f8510840.I_field_46 = Math.min(nested1_f8510840.I_field_46, f6);
            if (l >= nested1_f8510840.i_field_4a) {
                float f8 = f7 * 35.0f;
                if (nested1_f8510840.I_field_5a) {
                    nested1_f8510840.I_field_46 = Math.min(nested1_f8510840.I_field_46 + f8, f6);
                    if (nested1_f8510840.I_field_46 >= f6) {
                        nested1_f8510840.I_field_5a = false;
                        nested1_f8510840.i_field_4a = l + 600L;
                    }
                } else {
                    nested1_f8510840.I_field_46 = Math.max(nested1_f8510840.I_field_46 - f8, 0.0f);
                    if (nested1_f8510840.I_field_46 <= 0.0f) {
                        nested1_f8510840.I_field_5a = true;
                        nested1_f8510840.i_field_4a = l + 600L;
                    }
                }
            }
        } else if (nested1_f8510840.I_field_46 > 0.0f) {
            nested1_f8510840.I_field_46 = Math.max(0.0f, nested1_f8510840.I_field_46 - f7 * 35.0f);
            if (nested1_f8510840.I_field_46 == 0.0f) {
                nested1_f8510840.I_field_5a = true;
                nested1_f8510840.i_field_4a = l;
            }
        }
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), f - 2.0f, f2 - 2.0f, f4 + 4.0f, iIiIIi_Class10.I_method_a649725c() + 4.0f);
        iII.pushMatrix();
        iII.getMatrices().translate(-nested1_f8510840.I_field_46, 0.0f, 0.0f);
        iII.drawFadeoutText(iIiIIi_Class10, string, f, f2, colorRGBA, bl && f6 > 0.0f ? 0.98f : 0.8f, 1.0f, f4 + nested1_f8510840.I_field_46);
        iII.popMatrix();
        iIiiiIiII_Class373.I_method_ff80a1df();
    }

    @Override
    public void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            return;
        }
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 1.0f;
        float f3 = 0.0f;
        for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : ((MultiSelectSetting)this.I_field_ba11c26c).I_method_45aaa648()) {
            if (nested1_42856060.isHidden()) continue;
            boolean bl = iIIiIIIiI_Class291.I_method_c3f86263(f - 1.0f, f2 + 20.0f + f3, this.II_field_46 - 2.0f, 12.0, d, d2);
            if (iIIiIIIiI_Class291.I_method_c3f86263(f, f2 + 22.0f + f3, 17.0, 10.0, d, d2) && ((MultiSelectSetting)this.I_field_ba11c26c).i_method_9b12da03()) {
                this.I_field_51de8227 = nested1_42856060;
            } else if (bl) {
                nested1_42856060.toggle();
            }
            f3 += 12.0f;
        }
        super.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    @Override
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_51de8227 = null;
        super.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = 31.0f + this.IiI_method_bd31deaf();
        return this.Ii_field_46;
    }

    private float IiI_method_bd31deaf() {
        float f = 0.0f;
        for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : ((MultiSelectSetting)this.I_field_ba11c26c).I_method_45aaa648()) {
            if (nested1_42856060.isHidden()) continue;
            f += 12.0f;
        }
        return f;
    }

    static class Nested1_f8510840 {
        float I_field_46;
        boolean I_field_5a = true;
        long I_field_4a = System.currentTimeMillis();
        long i_field_4a;

        Nested1_f8510840() {
        }

        void I_method_7590c28a(long l) {
            this.I_field_46 = 0.0f;
            this.I_field_5a = true;
            this.i_field_4a = l;
        }
    }
}

