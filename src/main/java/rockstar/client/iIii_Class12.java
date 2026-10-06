package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.Rect;
import rockstar.client.III;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIIiIii_Class140;
import rockstar.client.IiIIiIiII_Class149;
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
import rockstar.client.iIi_Class6;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iiI_Class7;

public class iIii_Class12
extends iiI_Class7
implements iIIiIIiiI_Class295,
iIIiIIiii_Class296 {
    private final MinecraftClient I_field_3a9bda27 = MinecraftClient.getInstance();
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
    private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.Ii_field_dd60aac);
    private final IiiiIiiIi_Class238 I_field_dd60e8c = new IiiiIiiIi_Class238(300L);
    private final IiiiIiiIi_Class238 i_field_dd60e8c = new IiiiIiiIi_Class238(200L);
    private final IiiiIiIii_Class236 Ii_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 iI_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 ii_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final IiiiIiIii_Class236 III_field_dc7facc = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.II_field_dd60aac);
    private final String I_field_523beb0a;
    private final boolean I_field_5a;
    private final Consumer<ColorRGBA> I_field_f9f609fa;
    private float I_field_46 = 6.0f;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private boolean Ii_field_5a;
    private boolean iI_field_5a;
    private boolean ii_field_5a;
    private float i_field_46;
    private float II_field_46;
    private float Ii_field_46;
    private float iI_field_46;

    public iIii_Class12(float f2, float f3, boolean bl, ColorRGBA colorRGBA, String string, Consumer<ColorRGBA> consumer) {
        this.I_field_5a = bl;
        this.I_field_523beb0a = string;
        this.I_field_f9f609fa = consumer;
        this.i_field_dd60e8c.i_method_7d83c440(colorRGBA);
        this.size(143.0f, bl ? 160.0f : 136.0f);
        this.at(f2, f3);
        this.transition((f, iiI_Class72, nested1_28a19593) -> {
            nested1_28a19593.I_field_46 = Math.min(1.0f, f);
        });
        this.lifeMotion(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.Ii_field_dd60aac));
        this.draggable(iIi_Class6.i_field_b583ea6c);
        this.beginEnter(0.0f);
        this.I_method_8f9897d3(colorRGBA);
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        if (this.II_field_5a) {
            this.i_field_46 = iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, this.y() + 22.0f, 66.0f, f3);
        }
        if (this.Ii_field_5a) {
            this.II_field_46 = 1.0f - iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, this.x() + 6.0f, 114.0f, f2);
            this.Ii_field_46 = 1.0f - iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, this.y() + 20.0f, 70.0f, f3);
        }
        if (this.iI_field_5a) {
            this.iI_field_46 = iIIiIIIiI_Class291.I_method_a531f52f(0.0f, 1.0f, this.x() + 7.0f, 88.0f, f2);
        }
        float f4 = this.x();
        float f5 = this.y();
        if (f4 + this.w() + 5.0f > I_field_73c6d26c.I_method_804ee20f()) {
            f4 = I_field_73c6d26c.I_method_804ee20f() - this.w() - 5.0f;
        }
        if (f5 + this.h() + 5.0f > I_field_73c6d26c.i_method_805d6def()) {
            f5 = I_field_73c6d26c.i_method_805d6def() - this.h() - 5.0f;
        }
        if (f4 != this.x() || f5 != this.y()) {
            this.at(f4, f5);
        }
        IiIIiIiII_Class149.I_field_7865b31.removeIf(nested1_1055f060 -> nested1_1055f060.i_field_dc7facc.I_method_6ac4da6f() == 0.0f && !nested1_1055f060.I_field_5a);
        this.II_field_dc7facc.I_method_df2f9087(this.i_field_5a ? IiiiIiiII_Class237.I_field_dd60aac : IiiiIiiII_Class237.iI_field_dd60aac);
        this.II_field_dc7facc.I_method_edd72835(this.i_field_5a);
        this.I_field_dc7facc.I_method_edd72835(this.appear() >= 0.6f);
        this.i_field_dc7facc.I_method_edd72835(this.ii_field_5a);
        this.Ii_field_dc7facc.I_method_edd6dd11(this.i_field_46);
        this.iI_field_dc7facc.I_method_edd6dd11(1.0f - this.II_field_46);
        this.ii_field_dc7facc.I_method_edd6dd11(1.0f - this.Ii_field_46);
        this.III_field_dc7facc.I_method_edd6dd11(this.iI_field_46);
        this.I_field_dd60e8c.I_method_8895420(ColorRGBA.fromHSB(this.i_field_46, 1.0f, 1.0f));
        if (this.phase() != iiI_Class7.Nested1_5f2d9729.II_field_56fbb866 && this.I_field_f9f609fa != null) {
            this.I_field_f9f609fa.accept(this.I_method_6005b29b());
        }
    }

    @Override
    protected void drawSelf(III iII, float f) {
        float f2 = this.x();
        float f3 = this.y();
        float f4 = this.w();
        float f5 = this.h();
        boolean bl = RockstarClient.getInstance().I_method_9a720c62().I_method_ac8a0395() == IiIIIiIii_Class140.I_field_74daf6cc;
        ColorRGBA colorRGBA = IiiiiIIIi_Class242.III_field_d0c8ec5.withAlpha(255.0f * (bl ? 0.9f - 0.6f * InterfaceModule.I_method_fdcdb22f() : 0.7f));
        ColorRGBA colorRGBA2 = ColorRGBA.fromHSB(this.i_field_46, this.II_field_46, this.Ii_field_46);
        iIiiiIIiI_Class371.II_method_e18635ac(iII.getMatrices(), f2 + f4 / this.I_field_46, f3 + f5 / this.I_field_46, 0.5f + this.appear() * 0.5f);
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), f2 + 1.0f, f3 + 1.0f, f4 - 2.0f, f5 - 2.0f);
        iII.drawShadow(f2 - 5.0f, f3 - 5.0f, f4 + 10.0f, f5 + 10.0f, 15.0f, IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.BLACK.withAlpha(255.0f * (0.1f + 0.15f * this.i_field_dc7facc.I_method_6ac4da6f())));
        iIiiiIiII_Class373.I_method_ff80a1df();
        if (InterfaceModule.iII_method_f9a41e83()) {
            iII.drawBlurredRect(f2, f3, f4, f5, 45.0f, 7.0f, IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.appear() * InterfaceModule.i_method_fddc3e0f()));
        }
        if (InterfaceModule.Iii_method_c4da86a3()) {
            iII.drawLiquidGlass(f2, f3, f4, f5, 7.0f, 0.05f - 0.03f * this.i_field_dc7facc.I_method_6ac4da6f(), IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.appear() * InterfaceModule.I_method_fdcdb22f()));
        }
        iII.drawSquircle(f2, f3, f4, f5, 7.0f, IIiii_Class8.I_method_893b2757(6.0f), colorRGBA);
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), f2, f3, f4, f5);
        iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), this.I_field_523beb0a, f2 + f4 / 2.0f, f3 + 7.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
        iII.drawIcon("colorpicker/pipette", f2 + 7.0f, f3 + 6.0f, 8.0f);
        if (iIIiIIIiI_Class291.I_method_c3fabb03(f2 + 7.0f, f3 + 6.0f, 8.0, 8.0, iII.I_method_b1c3e152(), iII.i_method_b1d26d32())) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        iII.drawRoundedRect(f2 + f4 - 15.0f, f3 + 5.0f, 10.0f, 10.0f, IIiii_Class8.I_method_893b2757(5.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71());
        iII.drawIcon("xmark", f2 + f4 - 15.0f, f3 + 5.0f, 10.0f);
        if (iIIiIIIiI_Class291.I_method_c3fabb03(f2 + f4 - 15.0f, f3 + 5.0f, 10.0, 10.0, iII.I_method_b1c3e152(), iII.i_method_b1d26d32())) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        iII.drawRoundedTexture(RockstarClient.id("textures/hue.png"), f2 + f4 - 18.0f, f3 + 20.0f, 12.0f, 70.0f, IIiii_Class8.I_method_893b2757(4.0f));
        iII.drawRoundedRect(f2 + f4 - 16.0f, f3 + 22.0f + 64.0f * this.Ii_field_dc7facc.I_method_6ac4da6f(), 8.0f, 2.0f, IIiii_Class8.I_method_893b2757(0.2f), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
        if (iIIiIIIiI_Class291.I_method_da20b32b(f2 + f4 - 18.0f, f3 + 20.0f, 12.0, 70.0, iII) || this.II_field_5a) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.Ii_field_aa52e62c);
        }
        iII.drawRoundedRect(f2 + 6.0f, f3 + 20.0f, 114.0f, 70.0f, IIiii_Class8.I_method_893b2757(4.0f), IiIIi_Class10.I_method_cb8f4f75(this.I_field_dd60e8c.I_method_915b8ae(), IiiiiIIIi_Class242.iI_field_d0c8ec5, IiiiiIIIi_Class242.Ii_field_d0c8ec5, IiiiiIIIi_Class242.iI_field_d0c8ec5));
        iII.drawRoundedRect(f2 + 6.0f + 114.0f * this.iI_field_dc7facc.I_method_6ac4da6f() - 3.5f, f3 + 20.0f + 70.0f * this.ii_field_dc7facc.I_method_6ac4da6f() - 3.5f, 7.0f, 7.0f, IIiii_Class8.I_method_893b2757(2.5f), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
        iII.drawRoundedRect(f2 + 7.0f + 114.0f * this.iI_field_dc7facc.I_method_6ac4da6f() - 3.5f, f3 + 21.0f + 70.0f * this.ii_field_dc7facc.I_method_6ac4da6f() - 3.5f, 5.0f, 5.0f, IIiii_Class8.I_method_893b2757(1.5f), colorRGBA2);
        if (iIIiIIIiI_Class291.I_method_da20b32b(f2 + 6.0f, f3 + 20.0f, 114.0, 70.0, iII) || this.Ii_field_5a) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.ii_field_aa52e62c);
        }
        if (this.I_field_5a) {
            iII.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(5.0f), IiIiIIII_Class81.I_method_f25a980a("colorpicker.opacity").toUpperCase(), f2 + 6.0f, f3 + 95.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(191.25f));
            iII.drawRoundedTexture(RockstarClient.id("textures/empty.png"), f2 + 6.0f, f3 + 102.0f, 100.0f, 12.0f, IIiii_Class8.I_method_893b2757(5.0f));
            iII.drawRoundedRect(f2 + 6.0f - 0.5f, f3 + 102.0f - 0.5f, 101.0f, 13.0f, IIiii_Class8.I_method_893b2757(5.0f), new IiIii_Class12(colorRGBA2.withAlpha(0.0f), colorRGBA2));
            iII.drawRoundedRect(f2 + f4 - 32.0f, f3 + 102.0f, 26.0f, 12.0f, IIiii_Class8.I_method_893b2757(2.0f), IiiiiIIIi_Class242.IIi_field_d0c8ec5.withAlpha(255.0f));
            iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), (int)(this.iI_field_46 * 100.0f) + "%", f2 + f4 - 32.0f + 13.0f, f3 + 106.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
            iII.drawRoundedBorder(f2 + 7.0f + 88.0f * this.III_field_dc7facc.I_method_6ac4da6f(), f3 + 103.0f, 10.0f, 10.0f, 0.5f, IIiii_Class8.I_method_893b2757(4.0f), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
            iII.drawRoundedRect(f2 + 8.0f + 88.0f * this.III_field_dc7facc.I_method_6ac4da6f(), f3 + 104.0f, 8.0f, 8.0f, IIiii_Class8.I_method_893b2757(3.0f), this.I_method_6005b29b());
            if (iIIiIIIiI_Class291.I_method_da20b32b(f2 + 6.0f, f3 + 102.0f, 100.0, 12.0, iII) || this.iI_field_5a) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.II_field_aa52e62c);
            }
        }
        iII.drawRoundedRect(f2 + 6.0f, f3 + f5 - 36.0f, 29.0f, 29.0f, IIiii_Class8.I_method_893b2757(5.0f), this.I_method_6005b29b());
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (IiIIiIiII_Class149.Nested1_1055f060 object : IiIIiIiII_Class149.I_field_7865b31) {
            object.i_field_dc7facc.I_method_edd72835(object.I_field_5a);
            object.I_field_dc7facc.I_method_edd72835(object.I_field_d0c8ec5.getHue() == this.i_field_46 && object.I_field_d0c8ec5.getSaturation() == this.Ii_field_46 && object.I_field_d0c8ec5.getBrightness() == this.II_field_46);
            if (object.I_field_dc7facc.I_method_6ac4da6f() > 0.0f) {
                float f8 = object.I_field_dc7facc.I_method_6ac4da6f();
                iII.drawRoundedRect(f2 + 45.0f + f6, f3 + f5 - 36.0f + f7, 11.0f, 11.0f, IIiii_Class8.I_method_893b2757(4.5f), object.I_field_d0c8ec5.withAlpha(255.0f * object.i_field_dc7facc.I_method_6ac4da6f()));
                iII.drawRoundedBorder(f2 + 45.0f + f6 - 1.0f + 2.0f * f8, f3 + f5 - 36.0f + f7 - 1.0f + 2.0f * f8, 13.0f - 4.0f * f8, 13.0f - 4.0f * f8, 0.5f, IIiii_Class8.I_method_893b2757(6.5f - 2.0f * f8), IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(255.0f * object.i_field_dc7facc.I_method_6ac4da6f() * object.I_field_dc7facc.I_method_6ac4da6f()));
            } else {
                iII.drawRoundedRect(f2 + 45.0f + f6, f3 + f5 - 36.0f + f7, 11.0f, 11.0f, IIiii_Class8.I_method_893b2757(4.5f), object.I_field_d0c8ec5.withAlpha(255.0f * object.i_field_dc7facc.I_method_6ac4da6f()));
            }
            if (iIIiIIIiI_Class291.I_method_da20b32b(f2 + 45.0f + f6, f3 + f5 - 36.0f + f7, 11.0, 11.0, iII)) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            if (!(45.0f + (f6 += 20.0f * object.i_field_dc7facc.I_method_6ac4da6f()) > f4)) continue;
            f6 = 0.0f;
            f7 += 18.0f * object.i_field_dc7facc.I_method_6ac4da6f();
        }
        if (IiIIiIiII_Class149.I_field_7865b31.size() < 10) {
            iII.drawRoundedRect(f2 + 45.0f + f6, f3 + f5 - 36.0f + f7, 11.0f, 11.0f, IIiii_Class8.I_method_893b2757(4.5f), IiiiiIIIi_Class242.Ii_method_a0f56f71());
            iII.drawIcon("plus", f2 + 45.0f + f6, f3 + f5 - 36.0f + f7, 11.0f);
            if (iIIiIIIiI_Class291.I_method_da20b32b(f2 + 45.0f + f6, f3 + f5 - 36.0f + f7, 11.0, 11.0, iII)) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
        }
        iIiiiIiII_Class373.I_method_ff80a1df();
        iIiiiIIiI_Class371.I_method_10503b11(iII.getMatrices());
        if (this.II_field_dc7facc.I_method_6ac4da6f() > 0.0f) {
            Rect rect = new Rect(iII.I_method_b1c3e152(), iII.i_method_b1d26d32() + 10, 45.0f + IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f).I_method_2c375926(IiIiIIII_Class81.I_method_f25a980a("colorpicker.click_to_sample")), 30.0f);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)Math.min(1.0f, this.II_field_dc7facc.I_method_6ac4da6f()));
            iIiiiIIiI_Class371.II_method_e18635ac(iII.getMatrices(), rect.getX() + rect.getWidth() / 2.0f, rect.getY() + rect.getHeight() / 2.0f, 0.5f + this.II_field_dc7facc.I_method_6ac4da6f() * 0.5f);
            iII.drawBlurredRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), 45.0f, 7.0f, IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.WHITE.withAlpha(255.0f * this.II_field_dc7facc.I_method_6ac4da6f()));
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

    public ColorRGBA I_method_6005b29b() {
        this.i_field_dd60e8c.I_method_8895420(ColorRGBA.fromHSB(this.i_field_46, this.II_field_46, this.Ii_field_46).withAlpha(this.I_field_5a ? 255.0f * this.iI_field_46 : 255.0f));
        return this.i_field_dd60e8c.I_method_915b8ae();
    }

    private void I_method_8f9897d3(ColorRGBA colorRGBA) {
        this.i_field_46 = colorRGBA.getHue();
        this.II_field_46 = colorRGBA.getBrightness();
        this.Ii_field_46 = colorRGBA.getSaturation();
        this.iI_field_46 = colorRGBA.getAlpha() / 255.0f;
        this.i_field_dd60e8c.I_method_8895420(colorRGBA);
    }

    @Override
    public void close() {
        this.I_field_46 = 2.0f;
        this.lifeMotion(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.iI_field_dd60aac));
        this.i_field_5a = false;
        this.ii_field_5a = false;
        this.II_field_5a = false;
        this.Ii_field_5a = false;
        this.iI_field_5a = false;
        super.close();
    }

    @Override
    public boolean mouseClicked(float f, float f2, IiIII_Class9 iiIII_Class9) {
        if (this.phase() == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866 || this.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866) {
            return false;
        }
        float f3 = this.x();
        float f4 = this.y();
        float f5 = this.w();
        float f6 = this.h();
        if (this.i_field_5a) {
            if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                ColorRGBA colorRGBA = ColorRGBA.fromPixel((float)((double)f * I_field_73c6d26c.I_method_804ee20d()), (float)((double)I_field_587075c2.getHeight() - (double)f2 * I_field_73c6d26c.I_method_804ee20d()));
                this.I_method_8f9897d3(colorRGBA);
            }
            this.i_field_5a = false;
            return true;
        }
        boolean bl = IiIIiIiII_Class149.I_field_7865b31.size() < 10;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (IiIIiIiII_Class149.Nested1_1055f060 nested1_1055f060 : IiIIiIiII_Class149.I_field_7865b31) {
            if (iIIiIIIiI_Class291.I_method_c3f86263(f3 + 45.0f + f7, f4 + f6 - 36.0f + f8, 11.0, 11.0, f, f2)) {
                if (iiIII_Class9.I_method_6d899712() != 0) {
                    nested1_1055f060.I_field_5a = false;
                    RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
                } else {
                    this.I_method_8f9897d3(nested1_1055f060.I_field_d0c8ec5);
                }
                return true;
            }
            if (nested1_1055f060.I_field_d0c8ec5.getHue() == this.i_field_46 && nested1_1055f060.I_field_d0c8ec5.getSaturation() == this.Ii_field_46 && nested1_1055f060.I_field_d0c8ec5.getBrightness() == this.II_field_46) {
                bl = false;
            }
            if (!(45.0f + (f7 += 20.0f) > f5)) continue;
            f7 = 0.0f;
            f8 += 18.0f;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(f3 + 45.0f + f7, f4 + f6 - 36.0f + f8, 11.0, 11.0, f, f2) && bl) {
            IiIIiIiII_Class149.I_field_7865b31.add(new IiIIiIiII_Class149.Nested1_1055f060(this.I_method_6005b29b()));
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            return true;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(f3 + 7.0f, f4 + 6.0f, 8.0, 8.0, f, f2)) {
            this.i_field_5a = true;
            return true;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(f3 + f5 - 15.0f, f4 + 5.0f, 10.0, 10.0, f, f2)) {
            this.close();
            return true;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(f3 + f5 - 18.0f, f4 + 20.0f, 12.0, 70.0, f, f2)) {
            this.II_field_5a = true;
            return true;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(f3 + 6.0f, f4 + 20.0f, 114.0, 70.0, f, f2)) {
            this.Ii_field_5a = true;
            return true;
        }
        if (this.I_field_5a && iIIiIIIiI_Class291.I_method_c3f86263(f3 + 6.0f, f4 + 102.0f, 100.0, 12.0, f, f2)) {
            this.iI_field_5a = true;
            return true;
        }
        if (this.contains(f, f2)) {
            if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                this.ii_field_5a = true;
                return super.mouseClicked(f, f2, iiIII_Class9);
            }
            return false;
        }
        this.close();
        return false;
    }

    @Override
    public void mouseReleased(float f, float f2, IiIII_Class9 iiIII_Class9) {
        this.ii_field_5a = false;
        this.II_field_5a = false;
        this.Ii_field_5a = false;
        this.iI_field_5a = false;
        super.mouseReleased(f, f2, iiIII_Class9);
    }

    @Override
    public boolean keyPressed(int n, int n2, int n3) {
        if (Screen.isCopy((int)n)) {
            this.I_field_3a9bda27.keyboard.setClipboard(this.I_method_6005b29b().toHex());
            return true;
        }
        if (Screen.isPaste((int)n)) {
            try {
                this.I_method_8f9897d3(ColorRGBA.fromHex(this.I_field_3a9bda27.keyboard.getClipboard()));
            }
            catch (Exception exception) {
                // empty catch block
            }
            return true;
        }
        return super.keyPressed(n, n2, n3);
    }
}

