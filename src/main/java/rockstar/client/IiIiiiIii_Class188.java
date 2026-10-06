package rockstar.client;

import java.util.Random;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIiIiI_Class75;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.ii_Class4;
import ua.mintantileak.spk.Compile;

public class IiIiiiIii_Class188
extends ii_Class4
implements iIIiIIiIi_Class294,
iIIiIIiiI_Class295 {
    private static final Random I_field_6ece06ac = new Random();
    private float I_field_46;
    private float i_field_46;
    private float II_field_46;
    private float Ii_field_46;
    private float iI_field_46;
    private float ii_field_46;
    private float III_field_46;
    private final float[] I_field_b4b = new float[3];
    private int I_field_49;
    private int i_field_49;
    private boolean I_field_5a;
    private long I_field_4a;
    private final IiIiiIIII_Class177 I_field_467a06ac = RockstarClient.getInstance().I_method_35687482().I_method_35128395();

    @Compile(obfuscation=4)
    protected final void init() {
        this.i_method_fdccde5f();
        this.I_method_fdbe527f();
        this.I_field_4a = System.nanoTime();
    }

    private void I_method_fdbe527f() {
        float f = I_field_73c6d26c.i_method_805d6def() / 2.0f;
        this.i_field_46 = f + 160.0f - 18.0f - 7.0f;
        this.II_field_46 = this.I_field_46 = I_field_73c6d26c.I_method_804ee20f() / 2.0f;
        this.II_method_ba1af4c2();
    }

    private void i_method_fdccde5f() {
        this.I_field_49 = 0;
        this.i_field_49 = 3;
        this.I_field_5a = false;
        this.I_field_b4b[2] = 0.0f;
        this.I_field_b4b[1] = 0.0f;
        this.I_field_b4b[0] = 0.0f;
    }

    private void II_method_ba1af4c2() {
        this.Ii_field_46 = this.I_field_46 = (this.II_field_46 = I_field_73c6d26c.I_method_804ee20f() / 2.0f);
        this.iI_field_46 = this.i_field_46 - 7.0f - 10.0f;
        this.ii_field_46 = (I_field_6ece06ac.nextFloat() * 2.0f - 1.0f) * 70.0f;
        this.III_field_46 = -170.0f;
    }

    @Override
    public final void render(III iII) {
        long l = System.nanoTime();
        float f = MathHelper.clamp((float)((float)(l - this.I_field_4a) / 1.0E9f), (float)0.0f, (float)0.05f);
        this.I_field_4a = l;
        this.I_method_79fcf1a5(f, iII);
        this.I_method_51cbab07(iII);
    }

    private void I_method_79fcf1a5(float f, III iII) {
        float f2 = I_field_73c6d26c.I_method_804ee20f();
        float f3 = I_field_73c6d26c.i_method_805d6def();
        float f4 = f2 / 2.0f - 140.0f + 18.0f;
        float f5 = f2 / 2.0f + 140.0f - 18.0f;
        float f6 = f3 / 2.0f - 160.0f + 18.0f;
        float f7 = f3 / 2.0f + 160.0f - 18.0f;
        for (int i = 0; i < this.I_field_b4b.length; ++i) {
            this.I_field_b4b[i] = Math.max(0.0f, this.I_field_b4b[i] - f * (1.2f + (float)i * 0.4f));
        }
        float f8 = MathHelper.clamp((float)iII.I_method_b1c3e152(), (float)(f4 + 48.0f), (float)(f5 - 48.0f));
        if (!this.I_field_5a) {
            this.I_field_46 += (f8 - this.I_field_46) * Math.min(1.0f, f * 16.0f);
        }
        if (this.I_field_5a) {
            return;
        }
        float f9 = this.Ii_field_46;
        float f10 = this.iI_field_46;
        this.Ii_field_46 += this.ii_field_46 * f;
        this.iI_field_46 += this.III_field_46 * f;
        if (this.Ii_field_46 - 6.0f < f4 || this.Ii_field_46 + 6.0f > f5) {
            float f11 = this.ii_field_46 = this.Ii_field_46 - 6.0f < f4 ? Math.abs(this.ii_field_46) : -Math.abs(this.ii_field_46);
        }
        if (this.iI_field_46 - 6.0f < f6) {
            this.III_field_46 = Math.abs(this.III_field_46);
        }
        this.I_method_ba0c6521(f6);
        this.I_method_8780a6bf(f9, f10);
        if (this.iI_field_46 - 6.0f > f7) {
            if (--this.i_field_49 <= 0) {
                this.I_field_5a = true;
                this.I_field_b4b[2] = 1.0f;
                this.iI_method_bbdde4e2();
            } else {
                this.II_method_ba1af4c2();
            }
        }
    }

    private void I_method_ba0c6521(float f) {
        float f2;
        if (this.I_field_467a06ac == null) {
            return;
        }
        float f3 = this.I_field_467a06ac.getX();
        float f4 = this.I_field_467a06ac.getY();
        float f5 = this.I_field_467a06ac.getWidth();
        float f6 = this.I_field_467a06ac.getHeight();
        float f7 = f4 + f6;
        if (this.iI_field_46 - 6.0f <= f7 && this.iI_field_46 + 6.0f >= f4 && Math.abs(this.Ii_field_46 - (f2 = MathHelper.clamp((float)this.Ii_field_46, (float)f3, (float)(f3 + f5)))) <= 7.5f && this.III_field_46 < 0.0f) {
            this.iI_field_46 = f7 + 6.0f;
            this.III_field_46 = Math.abs(this.III_field_46) + Math.min(90.0f, (float)this.I_field_49 * 2.5f);
            this.ii_field_46 += (this.Ii_field_46 - (f3 + f5 / 2.0f)) / (f5 / 2.0f) * 45.0f;
            ++this.I_field_49;
            this.I_field_b4b[0] = 1.0f;
            this.I_field_b4b[2] = 0.75f;
        }
    }

    private void Ii_method_ba2980a2() {
        float f = this.i_field_46 - 7.0f;
        if (this.iI_field_46 + 6.0f >= f && this.iI_field_46 - 6.0f <= this.i_field_46 + 7.0f && this.Ii_field_46 >= this.I_field_46 - 45.0f && this.Ii_field_46 <= this.I_field_46 + 45.0f && this.III_field_46 > 0.0f) {
            this.iI_field_46 = f - 6.0f;
            this.III_field_46 = -Math.abs(this.III_field_46) - Math.min(80.0f, (float)this.I_field_49 * 2.0f);
            this.ii_field_46 = MathHelper.clamp((float)(this.ii_field_46 + (this.Ii_field_46 - this.I_field_46) / 45.0f * 60.0f), (float)-180.0f, (float)180.0f);
            this.I_field_b4b[1] = 1.0f;
        }
    }

    private void I_method_51cbab07(III iII) {
        float f = I_field_73c6d26c.I_method_804ee20f();
        float f2 = I_field_73c6d26c.i_method_805d6def();
        float f3 = f / 2.0f - 140.0f;
        float f4 = f2 / 2.0f - 160.0f;
        ColorRGBA colorRGBA = IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(220.0f);
        ColorRGBA colorRGBA2 = new ColorRGBA(20.0f, 24.0f, 36.0f, 200 + (int)(this.I_field_b4b[2] * 30.0f));
        iII.drawSquircle(f3, f4, 280.0f, 320.0f, 8.0f, IIiii_Class8.I_method_893b2757(24.0f), colorRGBA2);
        ColorRGBA colorRGBA3 = colorRGBA.mix(ColorRGBA.WHITE, 0.25f).withAlpha(240.0f);
        ColorRGBA colorRGBA4 = colorRGBA3.mix(ColorRGBA.WHITE, this.I_field_b4b[1] * 0.7f);
        iII.drawLiquidGlass(this.I_field_46 - 45.0f, this.i_field_46 - 7.0f, 90.0f, 14.0f, 8.0f, 1.0f, IIiii_Class8.I_method_893b2757(7.0f), colorRGBA4);
        iII.drawLiquidGlass(this.Ii_field_46 - 6.0f, this.iI_field_46 - 6.0f, 12.0f, 12.0f, 8.0f, 1.0f, IIiii_Class8.I_method_893b2757(6.0f), ColorRGBA.WHITE.mix(IiiiiIIIi_Class242.i_method_5dfec6e(), 0.3f));
        this.I_method_14790268(iII, colorRGBA, f4);
        if (this.I_field_467a06ac != null) {
            this.I_field_467a06ac.render(iII);
        }
    }

    private void I_method_14790268(III iII, ColorRGBA colorRGBA, float f) {
        IiIIiIiI_Class75 iiIIiIiI_Class75 = (IiIIiIiI_Class75)RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("client");
        float f2 = I_field_73c6d26c.I_method_804ee20f();
        if (iiIIiIiI_Class75 != null) {
            iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5f), "Games: " + iiIIiIiI_Class75.i_method_513dc4bf() + "   |   Best: " + iiIIiIiI_Class75.I_method_512f38df(), f2 / 2.0f, f + 338.0f, ColorRGBA.WHITE.mulAlpha(0.6f));
        }
        iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), "Score", f2 / 2.0f - 60.0f, f + 6.0f, ColorRGBA.WHITE.mulAlpha(0.75f));
        iII.drawCenteredText(IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(12.0f), String.valueOf(this.I_field_49), f2 / 2.0f - 60.0f, f + 22.0f, colorRGBA);
        iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), "Lives", f2 / 2.0f + 60.0f, f + 6.0f, ColorRGBA.WHITE.mulAlpha(0.75f));
        iII.drawCenteredText(IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(12.0f), String.valueOf(Math.max(this.i_field_49, 0)), f2 / 2.0f + 60.0f, f + 22.0f, colorRGBA);
        if (this.I_field_5a) {
            float f3 = f2 / 2.0f;
            float f4 = f + 160.0f;
            iII.drawBlurredRect(f3 - 90.0f, f4 - 40.0f, 180.0f, 80.0f, 35.0f, IIiii_Class8.I_method_893b2757(18.0f), new ColorRGBA(12.0f, 14.0f, 22.0f, 200.0f));
            iII.drawCenteredText(IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(10.0f), "Game Over", f3, f4 - 14.0f, ColorRGBA.WHITE);
            iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5f), "Score: " + this.I_field_49, f3, f4, ColorRGBA.WHITE);
            iII.drawCenteredText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5f), "Click to play again", f3, f4 + 10.0f, ColorRGBA.WHITE.mulAlpha(0.85f));
        }
    }

    private void I_method_8780a6bf(float f, float f2) {
        float f3 = 45.0f;
        float f4 = this.i_field_46 - 7.0f;
        float f5 = this.i_field_46 + 7.0f;
        if (this.III_field_46 > 0.0f) {
            float f6;
            float f7;
            float f8 = f2 + 6.0f;
            float f9 = this.iI_field_46 + 6.0f;
            if (f8 <= f4 && f9 >= f4 && f9 != f8 && (f7 = MathHelper.lerp((float)(f6 = MathHelper.clamp((float)((f4 - f8) / (f9 - f8)), (float)0.0f, (float)1.0f)), (float)f, (float)this.Ii_field_46)) >= this.I_field_46 - f3 && f7 <= this.I_field_46 + f3) {
                this.Ii_field_46 = f7;
                this.iI_field_46 = f4 - 6.0f;
                this.i_method_be1bba9f(f7, f3);
                return;
            }
        }
        if (this.iI_field_46 + 6.0f >= f4 && this.iI_field_46 - 6.0f <= f5 && this.Ii_field_46 >= this.I_field_46 - f3 && this.Ii_field_46 <= this.I_field_46 + f3 && this.III_field_46 > 0.0f) {
            this.iI_field_46 = f4 - 6.0f;
            this.i_method_be1bba9f(this.Ii_field_46, f3);
        }
    }

    private void i_method_be1bba9f(float f, float f2) {
        this.III_field_46 = -Math.abs(this.III_field_46) - Math.min(80.0f, (float)this.I_field_49 * 2.0f);
        this.ii_field_46 = MathHelper.clamp((float)(this.ii_field_46 + (f - this.I_field_46) / f2 * 60.0f), (float)-180.0f, (float)180.0f);
        this.I_field_b4b[1] = 1.0f;
    }

    private void iI_method_bbdde4e2() {
        IiIIiIiI_Class75 iiIIiIiI_Class75 = (IiIIiIiI_Class75)RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("client");
        if (iiIIiIiI_Class75 == null) {
            return;
        }
        iiIIiIiI_Class75.i_method_d67b47b7(iiIIiIiI_Class75.i_method_513dc4bf() + 1);
        if (this.I_field_49 > iiIIiIiI_Class75.I_method_512f38df()) {
            iiIIiIiI_Class75.I_method_d4b85797(this.I_field_49);
        }
        RockstarClient.getInstance().I_method_7a4c3f0b().II_method_d8a14015();
    }

    @Override
    public final void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (this.I_field_5a && iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
            this.i_method_fdccde5f();
            this.I_method_fdbe527f();
        }
        super.onMouseClicked(d, d2, iiIII_Class9);
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }

    public final boolean shouldPause() {
        return false;
    }
}

