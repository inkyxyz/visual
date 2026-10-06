package rockstar.client;

import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.ModeSetting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iiIIIiiIi_Class398;
import ua.mintantileak.spk.Compile;

public class IiiiIIiII_Class229
extends IiiIiiIii_Class220<ModeSetting> {
    private boolean I_field_5a;

    public IiiiIIiII_Class229(ModeSetting iIiiiiiII_Class125, iI_Class3 iI_Class32) {
        super(iIiiiiiII_Class125, iI_Class32);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        if (!this.I_field_5a) {
            for (ModeSetting.Nested1_42765c60 nested1_42765c60 : ((ModeSetting)this.I_field_ba11c26c).I_method_e1d4a248()) {
                this.I_method_70ccc602(nested1_42765c60);
            }
            this.I_field_5a = true;
        }
        float f = this.I_field_46 + 9.0f;
        float f2 = this.i_field_46 + 1.0f;
        float f3 = this.II_field_46 - 18.0f;
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        float f4 = 10.0f;
        float f5 = 19.0f;
        this.I_field_dc7facc.I_method_edd72835(this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()));
        this.I_method_2d447471(iII, iIiIIi_Class10, IiIiIIII_Class81.I_method_f25a980a(((ModeSetting)this.I_method_c1026715()).getName()), this.I_field_46 + f4, f2 - 1.0f + iIIiIIIiI_Class291.I_method_ef5e7a8f(iIiIIi_Class10.I_method_a649725c(), f5), this.I_method_c4c8e2f8().II_method_c7206932() - f4, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * this.I_field_dc7facc.I_method_6ac4da6f())), 0.8f, 1.0f);
        iII.drawRoundedRect(f - 1.0f, f2 + 17.0f, f3 + 2.0f, 8.0f + this.IiI_method_387e62af(), IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(76.5f));
        float f6 = 0.0f;
        for (ModeSetting.Nested1_42765c60 nested1_42765c60 : ((ModeSetting)this.I_field_ba11c26c).I_method_e1d4a248()) {
            if (nested1_42765c60.isHidden()) continue;
            this.I_method_70ccc602(nested1_42765c60);
            boolean bl = nested1_42765c60.isSelected();
            if (bl != nested1_42765c60.isLastState()) {
                if (bl) {
                    nested1_42765c60.setCurrentPenis(nested1_42765c60.getEnablePenis());
                } else {
                    nested1_42765c60.setCurrentPenis(nested1_42765c60.getDisablePenis());
                }
                nested1_42765c60.getCurrentPenis().I_method_73113e1f();
                nested1_42765c60.setLastState(bl);
            }
            nested1_42765c60.getCurrentPenis().i_method_731fc9ff();
            boolean bl2 = iIIiIIIiI_Class291.I_method_c3fabb03(f - 1.0f, f2 + 20.0f + f6, f3 + 2.0f, 12.0, iII.I_method_b1c3e152(), iII.i_method_b1d26d32());
            if (bl2 && (float)iII.i_method_b1d26d32() > this.III_method_f4aafe8f() && (float)iII.i_method_b1d26d32() < this.III_method_f4aafe8f() + this.IIi_method_f4b98a6f()) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            nested1_42765c60.getHoverAnimation().I_method_edd72835(bl2);
            nested1_42765c60.getActiveAnimation().I_method_edd72835(nested1_42765c60.isSelected());
            iII.drawFadeoutText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), IiIiIIII_Class81.I_method_f25a980a(nested1_42765c60.getName()), f + 7.0f, f2 + 24.5f + f6, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * nested1_42765c60.getHoverAnimation().I_method_6ac4da6f() + 0.25f * nested1_42765c60.getActiveAnimation().I_method_6ac4da6f())), 0.8f, 1.0f, f3 - 12.0f - nested1_42765c60.getActiveAnimation().I_method_6ac4da6f() * 10.0f);
            if (nested1_42765c60.getActiveAnimation().I_method_6ac4da6f() > 0.0f || nested1_42765c60.getCurrentPenis().i_method_731fca03()) {
                iIiiIIiii_Class360.I_method_e888eaca(iII.getMatrices(), nested1_42765c60.getCurrentPenis().I_method_1f8cc735(), f + f3 - 11.0f - nested1_42765c60.getActiveAnimation().I_method_6ac4da6f() * 2.0f, f2 + 24.0f + f6, 6.0f, 6.0f, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.1f + 0.9f * nested1_42765c60.getActiveAnimation().I_method_6ac4da6f()));
            }
            f6 += 12.0f;
        }
    }

    @Override
    public void iI_method_20338844(III iII) {
        float f = 0.5f;
        iII.drawRect(this.I_field_46, this.i_field_46 + this.Ii_field_46, this.II_field_46, f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(5.1f));
    }

    @Override
    @Compile
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c) {
            return;
        }
        float f = 0.0f;
        for (ModeSetting.Nested1_42765c60 nested1_42765c60 : ((ModeSetting)this.I_field_ba11c26c).I_method_e1d4a248()) {
            if (nested1_42765c60.isHidden()) continue;
            boolean bl = iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46 - 1.0f, this.i_field_46 + 20.0f + f, this.II_field_46 - 2.0f, 12.0, d, d2);
            if (bl) {
                nested1_42765c60.select();
            }
            f += 12.0f;
        }
        super.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    @Override
    public float Ii_method_2047ead7() {
        this.Ii_field_46 = 31.0f + this.IiI_method_387e62af();
        return this.Ii_field_46;
    }

    private float IiI_method_387e62af() {
        float f = 0.0f;
        for (ModeSetting.Nested1_42765c60 nested1_42765c60 : ((ModeSetting)this.I_field_ba11c26c).I_method_e1d4a248()) {
            if (nested1_42765c60.isHidden()) continue;
            f += 12.0f;
        }
        return f;
    }

    private void I_method_70ccc602(ModeSetting.Nested1_42765c60 nested1_42765c60) {
        if (nested1_42765c60.getEnablePenis() != null && nested1_42765c60.getDisablePenis() != null && nested1_42765c60.getCurrentPenis() != null) {
            return;
        }
        nested1_42765c60.setEnablePenis(new iiIIIiiIi_Class398(RockstarClient.id("penises/check_enable.penis")));
        nested1_42765c60.setDisablePenis(new iiIIIiiIi_Class398(RockstarClient.id("penises/check_disable.penis")));
        nested1_42765c60.setLastState(nested1_42765c60.isSelected());
        nested1_42765c60.setCurrentPenis(nested1_42765c60.isLastState() ? nested1_42765c60.getEnablePenis() : nested1_42765c60.getDisablePenis());
        if (nested1_42765c60.isLastState()) {
            nested1_42765c60.getEnablePenis().I_method_73113e1f();
        } else {
            nested1_42765c60.getDisablePenis().I_method_ef16f8c4(0);
            nested1_42765c60.getDisablePenis().iI_method_f0e86d42();
        }
    }
}

