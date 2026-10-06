package rockstar.client;

import globals.client.Information;
import globals.shared.proto.Packets;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiIiiiiI_Class95;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iIiiiIIiI_Class371;

public class IIiiIIIii_Class100
extends IIiIiiiiI_Class95 {
    private final Packets.Nested1_e38dcab6 I_field_16847991;
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;

    public IIiiIIIii_Class100(Packets.Nested1_e38dcab6 nested1_e38dcab6, String string) {
        super(5000L);
        this.I_field_16847991 = nested1_e38dcab6;
        this.I_field_523beb0a = nested1_e38dcab6.username();
        this.i_field_523beb0a = string;
    }

    @Override
    public final void I_method_df9d7d83(CustomDrawContext customDrawContext, float f) {
        String string = this.i_field_523beb0a.length() > 32 ? this.i_field_523beb0a.substring(0, 32) + " " : this.i_field_523beb0a;
        float f2 = Math.max(IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(this.I_field_523beb0a), IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f).I_method_2c375926(string));
        float f3 = f2 + 40.0f;
        this.II_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.Ii_field_dd60aac);
        this.II_field_dc7facc.I_method_edd6ec25(300L);
        float f4 = (float)customDrawContext.getScaledWindowWidth() - f3 - 8.0f;
        float f5 = (float)customDrawContext.getScaledWindowHeight() - 32.0f - this.II_field_dc7facc.I_method_edd6dd11(f);
        float f6 = 26.0f;
        int n = (int)(255.0f * this.I_field_dc7facc.I_method_6ac4da6f());
        iIiiiIIiI_Class371.II_method_e18635ac(customDrawContext.getMatrices(), f4 + f3 / 2.0f, f5 + 12.0f + f6 / 2.0f, 0.5f + 0.5f * this.I_field_dc7facc.I_method_6ac4da6f());
        if (InterfaceModule.Iii_method_c4da86a3()) {
            customDrawContext.drawLiquidGlass(f4, f5, f3, f6, 7.0f, 0.08f, IIiii_Class8.I_method_893b2757(7.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.I_field_dc7facc.I_method_6ac4da6f() * InterfaceModule.I_method_fdcdb22f()));
            customDrawContext.drawSquircle(f4, f5, f3, f6, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * iIIiiiiiI_Class319.I_method_5f7ff5cf(IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(), IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(), InterfaceModule.I_method_fdcdb22f()) * this.I_field_dc7facc.I_method_6ac4da6f()));
        } else {
            customDrawContext.drawBlurredRect(f4, f5, f3 + 2.0f, f6, 45.0f, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.I_field_dc7facc.I_method_6ac4da6f() * InterfaceModule.i_method_fddc3e0f()));
            customDrawContext.drawSquircle(f4, f5, f3 + 2.0f, f6, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), new ColorRGBA(0.0f, 0.0f, 0.0f).withAlpha((int)(140.25f * this.I_field_dc7facc.I_method_6ac4da6f())));
        }
        customDrawContext.drawRoundedTexture(Information.getAvatar(this.I_field_16847991.username()), f4 + f6 / 2.0f - 8.0f, f5 + f6 / 2.0f - 8.0f, 16.0f, 16.0f, IIiii_Class8.I_method_893b2757(4.0f), ColorRGBA.WHITE.withAlpha(n));
        customDrawContext.drawText(IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(7.0f), this.I_field_523beb0a, f4 + 27.0f, f5 + 7.0f, ColorRGBA.WHITE.withAlpha(n));
        if (string.length() > 32) {
            customDrawContext.drawFadeoutText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), string, f4 + 27.0f, f5 + 15.0f, ColorRGBA.WHITE.withAlpha(n), 0.7f, 1.0f, f3 - 27.0f - 6.0f);
        } else {
            customDrawContext.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), string, f4 + 27.0f, f5 + 15.0f, ColorRGBA.WHITE.withAlpha(n));
        }
        iIiiiIIiI_Class371.I_method_10503b11(customDrawContext.getMatrices());
    }
}

