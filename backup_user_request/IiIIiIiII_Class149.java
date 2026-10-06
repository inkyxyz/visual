package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Generated;
import net.minecraft.client.gui.screen.Screen;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.Rect;
import rockstar.client.III;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIIiIii_Class140;
import rockstar.client.IiIIi_Class10;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIii_Class12;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiIiiIi_Class238;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iIiiiIiII_Class373;
import ua.mintantileak.spk.Compile;

public class IiIIiIiII_Class149
extends iI_Class3
implements iIIiIIiiI_Class295,
iIIiIIiii_Class296 {
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.Ii_field_dd60aac);
    private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
    protected final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
    private final IiiiIiIii_Class236 Ii_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.Ii_field_dd60aac);
    private final IiiiIiiIi_Class238 I_field_dd60e8c = new IiiiIiiIi_Class238(300L);
    private final IiiiIiiIi_Class238 i_field_dd60e8c = new IiiiIiiIi_Class238(200L);
    private final String I_field_523beb0a;
    private boolean I_field_5a;
    private float iI_field_46;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private float ii_field_46;
    private float III_field_46;
    private boolean Ii_field_5a;
    private boolean iI_field_5a;
    private boolean ii_field_5a;
    private final boolean III_field_5a;
    private final IiiiIiIii_Class236 iI_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 ii_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 III_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 IIi_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private float IIi_field_46;
    private float IiI_field_46;
    private float Iii_field_46;
    private float iII_field_46;
    public static final List<Nested1_1055f060> I_field_7865b31 = new CopyOnWriteArrayList<Nested1_1055f060>(List.of(new Nested1_1055f060(new ColorRGBA(0.0f, 122.0f, 255.0f)), new Nested1_1055f060(new ColorRGBA(52.0f, 199.0f, 89.0f)), new Nested1_1055f060(new ColorRGBA(255.0f, 204.0f, 0.0f)), new Nested1_1055f060(new ColorRGBA(255.0f, 59.0f, 48.0f)), new Nested1_1055f060(new ColorRGBA(151.0f, 71.0f, 255.0f))));

    public IiIIiIiII_Class149(float f, float f2, float f3, boolean bl, ColorRGBA colorRGBA, String string) {
        super(f, f2, 143.0f, bl ? 160.0f : 136.0f);
        this.iI_field_46 = f3;
        this.III_field_5a = bl;
        this.I_field_5a = true;
        this.i_field_dd60e8c.i_method_7d83c440(colorRGBA);
        this.I_field_523beb0a = string;
        this.I_method_f24c2440(colorRGBA);
    }

    public static void I_method_9329a910(List<Nested1_1055f060> list) {
        I_field_7865b31.clear();
        I_field_7865b31.addAll(list);
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        if (this.Ii_field_5a) {
            this.IIi_field_46 = iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, this.i_field_46 + 22.0f, 66.0f, iII.i_method_b1d26d32());
        }
        if (this.iI_field_5a) {
            this.IiI_field_46 = 1.0f - iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, this.I_field_46 + 6.0f, 114.0f, iII.I_method_b1c3e152());
            this.Iii_field_46 = 1.0f - iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, this.i_field_46 + 20.0f, 70.0f, iII.i_method_b1d26d32());
        }
        if (this.ii_field_5a) {
            this.iII_field_46 = iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, this.I_field_46 + 7.0f, 88.0f, iII.I_method_b1c3e152());
        }
        if (this.i_field_5a) {
            this.I_field_46 = (float)iII.I_method_b1c3e152() - this.ii_field_46;
            this.i_field_46 = (float)iII.i_method_b1d26d32() - this.III_field_46;
        }
        if (this.I_field_46 + this.II_field_46 + 5.0f > I_field_73c6d26c.I_method_804ee20f()) {
            this.I_field_46 = I_field_73c6d26c.I_method_804ee20f() - this.II_field_46 - 5.0f;
        }
        if (this.i_field_46 + this.Ii_field_46 + 5.0f > I_field_73c6d26c.i_method_805d6def()) {
            this.i_field_46 = I_field_73c6d26c.i_method_805d6def() - this.Ii_field_46 - 5.0f;
        }
        I_field_7865b31.removeIf(nested1_1055f060 -> nested1_1055f060.i_field_dc7facc.I_method_6ac4da6f() == 0.0f && !nested1_1055f060.I_field_5a);
        this.Ii_field_dc7facc.I_method_df2f9087(this.II_field_5a ? IiiiIiiII_Class237.I_field_dd60aac : IiiiIiiII_Class237.iI_field_dd60aac);
        this.Ii_field_dc7facc.I_method_edd72835(this.II_field_5a);
        this.i_field_dc7facc.I_method_df2f9087(this.I_field_5a ? IiiiIiiII_Class237.I_field_dd60aac : IiiiIiiII_Class237.iI_field_dd60aac);
        this.i_field_dc7facc.I_method_edd72835(this.I_field_5a);
        this.II_field_dc7facc.I_method_edd72835(this.i_field_dc7facc.I_method_6ac4da6f() >= 0.6f);
        this.I_field_dc7facc.I_method_edd72835(this.i_field_5a);
        this.iI_field_dc7facc.I_method_edd6dd11(this.IIi_field_46);
        this.ii_field_dc7facc.I_method_edd6dd11(1.0f - this.IiI_field_46);
        this.III_field_dc7facc.I_method_edd6dd11(1.0f - this.Iii_field_46);
        this.IIi_field_dc7facc.I_method_edd6dd11(this.iII_field_46);
        this.I_field_dd60e8c.I_method_8895420(ColorRGBA.fromHSB(this.IIi_field_46, 1.0f, 1.0f));
        boolean bl = RockstarClient.getInstance().I_method_9a720c62().I_method_ac8a0395() == IiIIIiIii_Class140.I_field_74daf6cc;
        ColorRGBA colorRGBA = IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * (bl ? 0.9f - 0.6f * InterfaceModule.I_method_fdcdb22f() : 0.7f));
        ColorRGBA colorRGBA2 = ColorRGBA.fromHSB(this.IIi_field_46, this.IiI_field_46, this.Iii_field_46);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)Math.min(1.0f, this.i_field_dc7facc.I_method_6ac4da6f()));
        iIiiiIIiI_Class371.II_method_e18635ac(iII.getMatrices(), this.I_field_46 + this.II_field_46 / this.iI_field_46, this.i_field_46 + this.Ii_field_46 / this.iI_field_46, 0.5f + this.i_field_dc7facc.I_method_6ac4da6f() * 0.5f);
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), this.I_field_46 + 1.0f, this.i_field_46 + 1.0f, this.II_field_46 - 2.0f, this.Ii_field_46 - 2.0f);
        iII.drawShadow(this.I_field_46 - 5.0f, this.i_field_46 - 5.0f, this.II_field_46 + 10.0f, this.Ii_field_46 + 10.0f, 15.0f, IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.BLACK.withAlpha(255.0f * (0.1f + 0.15f * this.I_field_dc7facc.I_method_6ac4da6f())));
        iIiiiIiII_Class373.I_method_ff80a1df();
        if (InterfaceModule.iII_method_f9a41e83()) {
            iII.drawBlurredRect(this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46, 45.0f, 7.0f, IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.i_field_dc7facc.I_method_6ac4da6f() * InterfaceModule.i_method_fddc3e0f()));
        }
        if (InterfaceModule.Iii_method_c4da86a3()) {
            iII.drawLiquidGlass(this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46, 7.0f, 0.05f - 0.03f * this.I_field_dc7facc.I_method_6ac4da6f(), IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.i_field_dc7facc.I_method_6ac4da6f() * InterfaceModule.I_method_fdcdb22f()));
        }
        iII.drawSquircle(this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46, 7.0f, IIiii_Class8.I_method_893b2757(6.0f), colorRGBA);
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46);
        iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), this.I_field_523beb0a, this.I_field_46 + this.II_field_46 / 2.0f, this.i_field_46 + 7.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
        iII.drawIcon("colorpicker/pipette", this.I_field_46 + 7.0f, this.i_field_46 + 6.0f, 8.0f);
        if (iIIiIIIiI_Class291.I_method_c3fabb03(this.I_field_46 + 7.0f, this.i_field_46 + 6.0f, 8.0, 8.0, iII.I_method_b1c3e152(), iII.i_method_b1d26d32())) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        iII.drawRoundedRect(this.I_field_46 + this.II_field_46 - 15.0f, this.i_field_46 + 5.0f, 10.0f, 10.0f, IIiii_Class8.I_method_893b2757(5.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71());
        iII.drawIcon("xmark", this.I_field_46 + this.II_field_46 - 15.0f, this.i_field_46 + 5.0f, 10.0f);
        if (iIIiIIIiI_Class291.I_method_c3fabb03(this.I_field_46 + this.II_field_46 - 15.0f, this.i_field_46 + 5.0f, 10.0, 10.0, iII.I_method_b1c3e152(), iII.i_method_b1d26d32())) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        iII.drawRoundedTexture(RockstarClient.id("textures/hue.png"), this.I_field_46 + this.II_field_46 - 18.0f, this.i_field_46 + 20.0f, 12.0f, 70.0f, IIiii_Class8.I_method_893b2757(4.0f));
        iII.drawRoundedRect(this.I_field_46 + this.II_field_46 - 16.0f, this.i_field_46 + 22.0f + 64.0f * this.iI_field_dc7facc.I_method_6ac4da6f(), 8.0f, 2.0f, IIiii_Class8.I_method_893b2757(0.2f), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
        if (iIIiIIIiI_Class291.I_method_da20b32b(this.I_field_46 + this.II_field_46 - 18.0f, this.i_field_46 + 20.0f, 12.0, 70.0, iII) || this.Ii_field_5a) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.Ii_field_aa52e62c);
        }
        iII.drawRoundedRect(this.I_field_46 + 6.0f, this.i_field_46 + 20.0f, 114.0f, 70.0f, IIiii_Class8.I_method_893b2757(4.0f), IiIIi_Class10.I_method_cb8f4f75(this.I_field_dd60e8c.I_method_915b8ae(), IiiiiIIIi_Class242.iI_field_d0c8ec5, IiiiiIIIi_Class242.Ii_field_d0c8ec5, IiiiiIIIi_Class242.iI_field_d0c8ec5));
        iII.drawRoundedRect(this.I_field_46 + 6.0f + 114.0f * this.ii_field_dc7facc.I_method_6ac4da6f() - 3.5f, this.i_field_46 + 20.0f + 70.0f * this.III_field_dc7facc.I_method_6ac4da6f() - 3.5f, 7.0f, 7.0f, IIiii_Class8.I_method_893b2757(2.5f), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
        iII.drawRoundedRect(this.I_field_46 + 7.0f + 114.0f * this.ii_field_dc7facc.I_method_6ac4da6f() - 3.5f, this.i_field_46 + 21.0f + 70.0f * this.III_field_dc7facc.I_method_6ac4da6f() - 3.5f, 5.0f, 5.0f, IIiii_Class8.I_method_893b2757(1.5f), colorRGBA2);
        if (iIIiIIIiI_Class291.I_method_da20b32b(this.I_field_46 + 6.0f, this.i_field_46 + 20.0f, 114.0, 70.0, iII) || this.iI_field_5a) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.ii_field_aa52e62c);
        }
        if (this.III_field_5a) {
            iII.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(5.0f), IiIiIIII_Class81.I_method_f25a980a("colorpicker.opacity").toUpperCase(), this.I_field_46 + 6.0f, this.i_field_46 + 95.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(191.25f));
            iII.drawRoundedTexture(RockstarClient.id("textures/empty.png"), this.I_field_46 + 6.0f, this.i_field_46 + 102.0f, 100.0f, 12.0f, IIiii_Class8.I_method_893b2757(5.0f));
            iII.drawRoundedRect(this.I_field_46 + 6.0f - 0.5f, this.i_field_46 + 102.0f - 0.5f, 101.0f, 13.0f, IIiii_Class8.I_method_893b2757(5.0f), new IiIii_Class12(colorRGBA2.withAlpha(0.0f), colorRGBA2));
            iII.drawRoundedRect(this.I_field_46 + this.II_field_46 - 32.0f, this.i_field_46 + 102.0f, 26.0f, 12.0f, IIiii_Class8.I_method_893b2757(2.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha(255.0f));
            iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), (int)(this.iII_field_46 * 100.0f) + "%", this.I_field_46 + this.II_field_46 - 32.0f + 13.0f, this.i_field_46 + 106.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
            iII.drawRoundedBorder(this.I_field_46 + 7.0f + 88.0f * this.IIi_field_dc7facc.I_method_6ac4da6f(), this.i_field_46 + 103.0f, 10.0f, 10.0f, 0.5f, IIiii_Class8.I_method_893b2757(4.0f), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
            iII.drawRoundedRect(this.I_field_46 + 8.0f + 88.0f * this.IIi_field_dc7facc.I_method_6ac4da6f(), this.i_field_46 + 104.0f, 8.0f, 8.0f, IIiii_Class8.I_method_893b2757(3.0f), this.I_method_31a8648e());
            if (iIIiIIIiI_Class291.I_method_da20b32b(this.I_field_46 + 6.0f, this.i_field_46 + 102.0f, 100.0, 12.0, iII) || this.ii_field_5a) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.II_field_aa52e62c);
            }
        }
        iII.drawRoundedRect(this.I_field_46 + 6.0f, this.i_field_46 + this.Ii_field_46 - 36.0f, 29.0f, 29.0f, IIiii_Class8.I_method_893b2757(5.0f), this.I_method_31a8648e());
        float f = 0.0f;
        float f2 = 0.0f;
        for (Nested1_1055f060 object : I_field_7865b31) {
            object.i_field_dc7facc.I_method_edd72835(object.I_field_5a);
            object.I_field_dc7facc.I_method_edd72835(object.I_field_d0c8ec5.getHue() == this.IIi_field_46 && object.I_field_d0c8ec5.getSaturation() == this.Iii_field_46 && object.I_field_d0c8ec5.getBrightness() == this.IiI_field_46);
            if (object.I_field_dc7facc.I_method_6ac4da6f() > 0.0f) {
                float f3 = object.I_field_dc7facc.I_method_6ac4da6f();
                iII.drawRoundedRect(this.I_field_46 + 45.0f + f, this.i_field_46 + this.Ii_field_46 - 36.0f + f2, 11.0f, 11.0f, IIiii_Class8.I_method_893b2757(4.5f), object.I_field_d0c8ec5.withAlpha(255.0f * object.i_field_dc7facc.I_method_6ac4da6f()));
                iII.drawRoundedBorder(this.I_field_46 + 45.0f + f - 1.0f + 2.0f * f3, this.i_field_46 + this.Ii_field_46 - 36.0f + f2 - 1.0f + 2.0f * f3, 13.0f - 4.0f * f3, 13.0f - 4.0f * f3, 0.5f, IIiii_Class8.I_method_893b2757(6.5f - 2.0f * f3), IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(255.0f * object.i_field_dc7facc.I_method_6ac4da6f() * object.I_field_dc7facc.I_method_6ac4da6f()));
            } else {
                iII.drawRoundedRect(this.I_field_46 + 45.0f + f, this.i_field_46 + this.Ii_field_46 - 36.0f + f2, 11.0f, 11.0f, IIiii_Class8.I_method_893b2757(4.5f), object.I_field_d0c8ec5.withAlpha(255.0f * object.i_field_dc7facc.I_method_6ac4da6f()));
            }
            if (iIIiIIIiI_Class291.I_method_da20b32b(this.I_field_46 + 45.0f + f, this.i_field_46 + this.Ii_field_46 - 36.0f + f2, 11.0, 11.0, iII)) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            if (!(45.0f + (f += 20.0f * object.i_field_dc7facc.I_method_6ac4da6f()) > this.II_field_46)) continue;
            f = 0.0f;
            f2 += 18.0f * object.i_field_dc7facc.I_method_6ac4da6f();
        }
        if (I_field_7865b31.size() < 10) {
            iII.drawRoundedRect(this.I_field_46 + 45.0f + f, this.i_field_46 + this.Ii_field_46 - 36.0f + f2, 11.0f, 11.0f, IIiii_Class8.I_method_893b2757(4.5f), IiiiiIIIi_Class242.Ii_method_a0f56f71());
            iII.drawIcon("plus", this.I_field_46 + 45.0f + f, this.i_field_46 + this.Ii_field_46 - 36.0f + f2, 11.0f);
            if (iIIiIIIiI_Class291.I_method_da20b32b(this.I_field_46 + 45.0f + f, this.i_field_46 + this.Ii_field_46 - 36.0f + f2, 11.0, 11.0, iII)) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
        }
        iIiiiIiII_Class373.I_method_ff80a1df();
        iIiiiIIiI_Class371.I_method_10503b11(iII.getMatrices());
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (this.Ii_field_dc7facc.I_method_6ac4da6f() > 0.0f) {
            Rect rect = new Rect(iII.I_method_b1c3e152(), iII.i_method_b1d26d32() + 10, 45.0f + IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f).I_method_2c375926(IiIiIIII_Class81.I_method_f25a980a("colorpicker.click_to_sample")), 30.0f);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)Math.min(1.0f, this.Ii_field_dc7facc.I_method_6ac4da6f()));
            iIiiiIIiI_Class371.II_method_e18635ac(iII.getMatrices(), rect.getX() + rect.getWidth() / 2.0f, rect.getY() + rect.getHeight() / 2.0f, 0.5f + this.Ii_field_dc7facc.I_method_6ac4da6f() * 0.5f);
            iII.drawBlurredRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), 45.0f, 7.0f, IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.Ii_field_dc7facc.I_method_6ac4da6f()));
            iII.drawSquircle(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), 7.0f, IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * (bl ? 0.8f : 0.7f)));
            ColorRGBA colorRGBA3 = ColorRGBA.fromPixel((float)((double)iII.I_method_b1c3e152() * I_field_73c6d26c.I_method_804ee20d()), (float)((double)I_field_587075c2.getHeight() - (double)iII.i_method_b1d26d32() * I_field_73c6d26c.I_method_804ee20d()));
            iII.drawRoundedRect(rect.getX() + 5.0f, rect.getY() + 5.0f, rect.getHeight() - 10.0f, rect.getHeight() - 10.0f, IIiii_Class8.I_method_893b2757(5.0f), colorRGBA3);
            iII.drawIcon("colorpicker/click", rect.getX() + rect.getHeight(), rect.getY() + 16.0f, 6.0f);
            iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f), String.format("RGB %s %s %s", (int)colorRGBA3.getRed(), (int)colorRGBA3.getGreen(), (int)colorRGBA3.getBlue()), rect.getX() + rect.getHeight(), rect.getY() + 8.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
            iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f), IiIiIIII_Class81.I_method_f25a980a("colorpicker.click_to_sample"), rect.getX() + rect.getHeight() + 8.0f, rect.getY() + 17.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(200.0f));
            iIiiiIIiI_Class371.I_method_10503b11(iII.getMatrices());
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    public ColorRGBA I_method_31a8648e() {
        this.i_field_dd60e8c.I_method_8895420(ColorRGBA.fromHSB(this.IIi_field_46, this.IiI_field_46, this.Iii_field_46).withAlpha(this.III_field_5a ? 255.0f * this.iII_field_46 : 255.0f));
        return this.i_field_dd60e8c.I_method_915b8ae();
    }

    @Override
    public void I_method_c1acbc24(int n, int n2, int n3) {
        if (Screen.isCopy((int)n)) {
            IiIIiIiII_Class149.I_field_3a9bda27.keyboard.setClipboard(this.I_method_31a8648e().toHex());
        } else if (Screen.isPaste((int)n)) {
            String string = IiIIiIiII_Class149.I_field_3a9bda27.keyboard.getClipboard();
            try {
                this.I_method_f24c2440(ColorRGBA.fromHex(string));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        super.I_method_c1acbc24(n, n2, n3);
    }

    @Override
    @Compile(obfuscation=1)
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        boolean bl = I_field_7865b31.size() < 10;
        float f = 0.0f;
        float f2 = 0.0f;
        for (Nested1_1055f060 nested1_1055f060 : I_field_7865b31) {
            if (iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46 + 45.0f + f, this.i_field_46 + this.Ii_field_46 - 36.0f + f2, 11.0, 11.0, d, d2)) {
                if (iiIII_Class9.I_method_6d899712() != 0) {
                    nested1_1055f060.I_field_5a = false;
                    RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
                } else {
                    this.I_method_f24c2440(nested1_1055f060.I_field_d0c8ec5);
                }
                return;
            }
            if (nested1_1055f060.I_field_d0c8ec5.getHue() == this.IIi_field_46 && nested1_1055f060.I_field_d0c8ec5.getSaturation() == this.Iii_field_46 && nested1_1055f060.I_field_d0c8ec5.getBrightness() == this.IiI_field_46) {
                bl = false;
            }
            if (!(45.0f + (f += 20.0f) > this.II_field_46)) continue;
            f = 0.0f;
            f2 += 18.0f;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46 + 45.0f + f, this.i_field_46 + this.Ii_field_46 - 36.0f + f2, 11.0, 11.0, d, d2) && bl) {
            I_field_7865b31.add(new Nested1_1055f060(this.I_method_31a8648e()));
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            return;
        }
        if (iiIII_Class9.I_method_6d899712() != 0) {
            this.II_field_5a = false;
            return;
        }
        if (this.II_field_5a) {
            ColorRGBA colorRGBA = ColorRGBA.fromPixel((float)(d * I_field_73c6d26c.I_method_804ee20d()), (float)((double)I_field_587075c2.getHeight() - d2 * I_field_73c6d26c.I_method_804ee20d()));
            this.I_method_f24c2440(colorRGBA);
            this.II_field_5a = false;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46 + 7.0f, this.i_field_46 + 6.0f, 8.0, 8.0, d, d2)) {
            this.II_field_5a = true;
            return;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46 + this.II_field_46 - 15.0f, this.i_field_46 + 5.0f, 10.0, 10.0, d, d2)) {
            this.I_field_5a = false;
            this.iI_field_46 = 2.0f;
            return;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46 + this.II_field_46 - 18.0f, this.i_field_46 + 20.0f, 12.0, 70.0, d, d2)) {
            this.Ii_field_5a = true;
            return;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46 + 6.0f, this.i_field_46 + 20.0f, 114.0, 70.0, d, d2)) {
            this.iI_field_5a = true;
            return;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46 + 6.0f, this.i_field_46 + 102.0f, 100.0, 12.0, d, d2)) {
            this.ii_field_5a = true;
            return;
        }
        if (this.I_method_a74cd690(d, d2)) {
            this.i_field_5a = true;
            this.ii_field_46 = (float)(d - (double)this.I_field_46);
            this.III_field_46 = (float)(d2 - (double)this.i_field_46);
        }
    }

    @Override
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.i_field_5a = false;
        this.iI_field_5a = false;
        this.Ii_field_5a = false;
        this.ii_field_5a = false;
    }

    public void I_method_f24c2440(ColorRGBA colorRGBA) {
        this.IIi_field_46 = colorRGBA.getHue();
        this.IiI_field_46 = colorRGBA.getBrightness();
        this.Iii_field_46 = colorRGBA.getSaturation();
        this.iII_field_46 = colorRGBA.getAlpha() / 255.0f;
        this.i_field_dd60e8c.I_method_8895420(colorRGBA);
    }

    @Generated
    public IiiiIiIii_Class236 I_method_f2461b55() {
        return this.i_field_dc7facc;
    }

    @Generated
    public boolean I_method_15d3a23() {
        return this.I_field_5a;
    }

    @Generated
    public void I_method_2a4abc95(boolean bl) {
        this.I_field_5a = bl;
    }

    @Generated
    public boolean i_method_16bc603() {
        return this.i_field_5a;
    }

    @Generated
    public boolean II_method_2a590126() {
        return this.II_field_5a;
    }

    public static class Nested1_1055f060 {
        public final ColorRGBA I_field_d0c8ec5;
        public final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
        public final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
        public boolean I_field_5a = true;

        @Generated
        public Nested1_1055f060(ColorRGBA colorRGBA) {
            this.I_field_d0c8ec5 = colorRGBA;
        }

        @Generated
        public ColorRGBA I_method_79cacdc9() {
            return this.I_field_d0c8ec5;
        }

        @Generated
        public IiiiIiIii_Class236 I_method_79d2ccd0() {
            return this.I_field_dc7facc;
        }

        @Generated
        public IiiiIiIii_Class236 i_method_8f6840b0() {
            return this.i_field_dc7facc;
        }

        @Generated
        public boolean I_method_e5b4f5e() {
            return this.I_field_5a;
        }
    }
}

