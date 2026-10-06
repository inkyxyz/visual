package rockstar.client;

import java.util.Locale;
import lombok.Generated;
import net.minecraft.item.ItemStack;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.IiiIIiIi_Class102;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIIiII_Class261;
import rockstar.client.iIIiIIIiI_Class291;

public class IiiIiiIi_Class110 {
    private final float I_field_46 = 10.0f;
    private final float i_field_46 = 74.0f;
    private ItemStack I_field_f2735522;
    private ItemStack i_field_f2735522;
    private String I_field_523beb0a;
    private float II_field_46;
    private float Ii_field_46;
    private float iI_field_46;
    private float ii_field_46;
    private final IiIiIIIII_Class161 I_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f));
    private final IiIiIIIII_Class161 i_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f));
    private final IiIiIIIII_Class161 II_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f));
    private boolean I_field_5a;
    private IiiIIiIi_Class102.Nested1_6cef9113 I_field_af10c1bc = IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc;

    public IiiIiiIi_Class110() {
        this.I_field_fdef2cc.i_method_fd1e2055(true);
        this.I_field_fdef2cc.II_method_e557b20c("\u041c\u0430\u043a\u0441");
        this.I_field_fdef2cc.I_method_1d5afa89("25000");
        this.i_field_fdef2cc.i_method_fd1e2055(true);
        this.i_field_fdef2cc.II_method_e557b20c("\u0423\u0440\u043e\u0432\u0435\u043d\u044c");
        this.i_field_fdef2cc.I_method_1d5afa89("1");
        this.II_field_fdef2cc.i_method_fd1e2055(true);
        this.II_field_fdef2cc.II_method_e557b20c("\u041f\u0440\u043e\u0446\u0435\u043d\u0442");
        this.II_field_fdef2cc.I_method_1d5afa89("20");
    }

    public long I_method_83bed8a0() {
        return this.I_method_c3f7af6a(this.I_field_fdef2cc.I_method_d2579001());
    }

    public double I_method_83bed89a() {
        String string = this.II_field_fdef2cc.I_method_d2579001();
        if (string == null || string.trim().isEmpty()) {
            return 20.0;
        }
        try {
            return Double.parseDouble(string.trim());
        }
        catch (NumberFormatException numberFormatException) {
            return 20.0;
        }
    }

    public ItemStack I_method_9a45248c() {
        if (this.I_field_f2735522 == null) {
            return null;
        }
        if (!iIIIIIiII_Class261.I_method_64d24b25(this.I_field_f2735522)) {
            return this.I_field_f2735522;
        }
        String string = this.i_field_fdef2cc.I_method_d2579001();
        if (string == null || string.trim().isEmpty()) {
            return this.I_field_f2735522;
        }
        try {
            int n = Integer.parseInt(string.trim()) - 1;
            if (n < 0) {
                n = 0;
            }
            return iIIIIIiII_Class261.I_method_d98ef8f6(this.I_field_f2735522, n);
        }
        catch (NumberFormatException numberFormatException) {
            return this.I_field_f2735522;
        }
    }

    private long I_method_c3f7af6a(String string) {
        if (string == null) {
            return 0L;
        }
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        if (string2.isEmpty()) {
            return 0L;
        }
        try {
            return Long.parseLong(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return 0L;
        }
    }

    public void I_method_5fbe7677(int n, int n2, int n3) {
        this.I_field_fdef2cc.I_method_c1acbc24(n, n2, n3);
        this.i_field_fdef2cc.I_method_c1acbc24(n, n2, n3);
        this.II_field_fdef2cc.I_method_c1acbc24(n, n2, n3);
    }

    public void I_method_8f7703d2(char c, int n) {
        this.I_field_fdef2cc.I_method_b71e84c9(c, n);
        this.i_field_fdef2cc.I_method_b71e84c9(c, n);
        this.II_field_fdef2cc.I_method_b71e84c9(c, n);
    }

    public void I_method_a2cbd4ba(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_fdef2cc.i_method_6a097ac7(d, d2, iiIII_Class9);
        this.i_field_fdef2cc.i_method_6a097ac7(d, d2, iiIII_Class9);
        this.II_field_fdef2cc.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    public void I_method_5dd295fa(III iII, float f, float f2, float f3, float f4) {
        this.II_field_46 = f;
        this.Ii_field_46 = f2;
        this.iI_field_46 = f3;
        this.ii_field_46 = f4;
        this.i_method_87cf261a(iII, f, f2, f3, f4);
        if (this.I_field_f2735522 != null) {
            if (this.I_field_f2735522 != this.i_field_f2735522 && iIIIIIiII_Class261.I_method_64d24b25(this.I_field_f2735522)) {
                this.i_field_fdef2cc.I_method_1d5afa89(String.valueOf(iIIIIIiII_Class261.I_method_64d24b14(this.I_field_f2735522) + 1));
                this.i_field_f2735522 = this.I_field_f2735522;
            }
            this.I_method_30fcb2fa(iII);
            float f5 = this.I_method_30fcb2ea(iII);
            f5 = this.I_field_af10c1bc == IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc ? this.I_method_ee9a13f6(iII, f5) : this.i_method_29c477d6(iII, f5);
            if (iIIIIIiII_Class261.I_method_64d24b25(this.I_field_f2735522)) {
                f5 = this.II_method_5c0b32bf(iII, f5);
            }
            this.I_method_ee9a1406(iII, f5);
        }
    }

    private void I_method_30fcb2fa(III iII) {
        float f = this.II_field_46 + 10.0f;
        float f2 = this.Ii_field_46 + 10.0f;
        String string = this.I_field_523beb0a != null ? this.I_field_523beb0a : this.I_field_f2735522.getName().getString();
        iII.drawItem(this.I_field_f2735522, f, f2, 0.875f);
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), string, f + 18.0f, f2 + 4.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
    }

    private float I_method_30fcb2ea(III iII) {
        float f = this.II_field_46 + 10.0f;
        float f2 = this.Ii_field_46 + 34.0f;
        float f3 = (this.iI_field_46 - 20.0f - 4.0f) / 2.0f;
        float f4 = 16.0f;
        ColorRGBA colorRGBA = new ColorRGBA(255.0f, 1.0f, 1.0f);
        ColorRGBA colorRGBA2 = IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.6f);
        iII.drawRoundedRect(f, f2, f3, f4, IIiii_Class8.I_method_893b2757(3.0f), this.I_field_af10c1bc == IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc ? colorRGBA : colorRGBA2);
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), "\u0424\u0438\u043a\u0441", f + 8.0f, f2 + 5.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
        iII.drawRoundedRect(f + f3 + 4.0f, f2, f3, f4, IIiii_Class8.I_method_893b2757(3.0f), this.I_field_af10c1bc == IiiIIiIi_Class102.Nested1_6cef9113.i_field_af10c1bc ? colorRGBA : colorRGBA2);
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), "\u0420\u044b\u043d\u043e\u043a", f + f3 + 4.0f + 6.0f, f2 + 5.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
        return f2 + f4;
    }

    private float I_method_ee9a13f6(III iII, float f) {
        float f2 = this.II_field_46 + 10.0f;
        float f3 = this.iI_field_46 - 20.0f;
        float f4 = f + 10.0f;
        float f5 = f4 + IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c() + 4.0f;
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), "\u041c\u0430\u043a\u0441 \u0446\u0435\u043d\u0430", f2, f4, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.8f));
        iII.drawRoundedRect(f2, f5, f3, 14.0f, IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.6f));
        this.I_field_fdef2cc.I_method_b043bcc(f2 + 2.0f, f5, f3 - 2.0f, 14.0f);
        this.I_field_fdef2cc.I_method_13a617e0(IiiiiIIIi_Class242.iI_method_8e08d3b1());
        this.I_field_fdef2cc.I_method_7ae26dda(iII);
        return f5 + 14.0f;
    }

    private float i_method_29c477d6(III iII, float f) {
        float f2 = this.II_field_46 + 10.0f;
        float f3 = this.iI_field_46 - 20.0f;
        float f4 = f + 10.0f;
        float f5 = f4 + IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c() + 4.0f;
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), "\u041d\u0438\u0436\u0435 \u0440\u044b\u043d\u043a\u0430 %", f2, f4, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.8f));
        iII.drawRoundedRect(f2, f5, f3, 14.0f, IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.6f));
        this.II_field_fdef2cc.I_method_b043bcc(f2 + 2.0f, f5, f3 - 2.0f, 14.0f);
        this.II_field_fdef2cc.I_method_13a617e0(IiiiiIIIi_Class242.iI_method_8e08d3b1());
        this.II_field_fdef2cc.I_method_7ae26dda(iII);
        return f5 + 14.0f;
    }

    private float II_method_5c0b32bf(III iII, float f) {
        float f2 = this.II_field_46 + 10.0f;
        float f3 = this.iI_field_46 - 20.0f;
        float f4 = f + 10.0f;
        float f5 = f4 + IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c() + 4.0f;
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), "\u0423\u0440\u043e\u0432\u0435\u043d\u044c \u0437\u0435\u043b\u044c\u044f", f2, f4, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.8f));
        iII.drawRoundedRect(f2, f5, f3, 14.0f, IIiii_Class8.I_method_893b2757(3.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.6f));
        this.i_field_fdef2cc.I_method_b043bcc(f2 + 4.0f, f5, f3 - 8.0f, 14.0f);
        this.i_field_fdef2cc.I_method_13a617e0(IiiiiIIIi_Class242.iI_method_8e08d3b1());
        this.i_field_fdef2cc.I_method_7ae26dda(iII);
        return f5 + 14.0f;
    }

    private void I_method_ee9a1406(III iII, float f) {
        float f2 = this.II_field_46 + 10.0f;
        float f3 = f + 15.0f;
        iII.drawRoundedRect(f2, f3, 74.0f, 16.0f, IIiii_Class8.I_method_893b2757(2.0f), new ColorRGBA(255.0f, 1.0f, 1.0f));
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c", f2 + 10.0f, f3 + 4.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
    }

    public void i_method_ccc864da(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (iiIII_Class9 != IiIII_Class9.I_field_2f4c8d6c || this.I_field_f2735522 == null) {
            return;
        }
        float f = this.II_field_46 + 10.0f;
        float f2 = this.Ii_field_46 + 34.0f;
        float f3 = (this.iI_field_46 - 20.0f - 4.0f) / 2.0f;
        float f4 = 16.0f;
        if (iIIiIIIiI_Class291.I_method_c3f86263(f, f2, f3, f4, d, d2)) {
            this.I_field_af10c1bc = IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc;
            return;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(f + f3 + 4.0f, f2, f3, f4, d, d2)) {
            this.I_field_af10c1bc = IiiIIiIi_Class102.Nested1_6cef9113.i_field_af10c1bc;
            return;
        }
        this.I_field_fdef2cc.I_method_400ceaa7(d, d2, iiIII_Class9);
        this.II_field_fdef2cc.I_method_400ceaa7(d, d2, iiIII_Class9);
        if (iIIIIIiII_Class261.I_method_64d24b25(this.I_field_f2735522)) {
            this.i_field_fdef2cc.I_method_400ceaa7(d, d2, iiIII_Class9);
        }
        if (this.I_method_8f776570(d, d2)) {
            this.I_field_5a = true;
        }
    }

    private boolean I_method_8f776570(double d, double d2) {
        float f = this.Ii_field_46 + 34.0f + 16.0f + 10.0f + IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c() + 4.0f + 14.0f;
        if (iIIIIIiII_Class261.I_method_64d24b25(this.I_field_f2735522)) {
            f += 10.0f + IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f).I_method_a649725c() + 4.0f + 14.0f;
        }
        float f2 = this.II_field_46 + 10.0f;
        float f3 = f + 15.0f;
        return iIIiIIIiI_Class291.I_method_c3f86263(f2, f3, 74.0, 16.0, d, d2);
    }

    public boolean I_method_83bed8b0() {
        boolean bl = this.I_field_5a;
        this.I_field_5a = false;
        return bl;
    }

    private void i_method_87cf261a(III iII, float f, float f2, float f3, float f4) {
        iII.drawBlurredRect(f, f2, f3, f4, 45.0f, 5.0f, IIiii_Class8.I_method_893b2757(8.0f), ColorRGBA.WHITE.withAlpha(255.0f));
        iII.drawSquircle(f, f2, f3, f4, 2.0f, IIiii_Class8.I_method_893b2757(8.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2()));
    }

    @Generated
    public float I_method_83bed89c() {
        return this.I_field_46;
    }

    @Generated
    public float i_method_83cd647c() {
        return this.i_field_46;
    }

    @Generated
    public ItemStack i_method_553ca4ac() {
        return this.I_field_f2735522;
    }

    @Generated
    public ItemStack II_method_4ec281a3() {
        return this.i_field_f2735522;
    }

    @Generated
    public String I_method_220a0974() {
        return this.I_field_523beb0a;
    }

    @Generated
    public float II_method_f42b3425() {
        return this.II_field_46;
    }

    @Generated
    public float Ii_method_f439c005() {
        return this.Ii_field_46;
    }

    @Generated
    public float iI_method_f5ee2445() {
        return this.iI_field_46;
    }

    @Generated
    public float ii_method_f5fcb025() {
        return this.ii_field_46;
    }

    @Generated
    public IiIiIIIII_Class161 I_method_e97b6ba2() {
        return this.I_field_fdef2cc;
    }

    @Generated
    public IiIiIIIII_Class161 i_method_ff10df82() {
        return this.i_field_fdef2cc;
    }

    @Generated
    public IiIiIIIII_Class161 II_method_e83dfdeb() {
        return this.II_field_fdef2cc;
    }

    @Generated
    public boolean i_method_83cd6490() {
        return this.I_field_5a;
    }

    @Generated
    public IiiIIiIi_Class102.Nested1_6cef9113 I_method_90363a6() {
        return this.I_field_af10c1bc;
    }

    @Generated
    public void I_method_a5a07d0e(ItemStack itemStack) {
        this.I_field_f2735522 = itemStack;
    }

    @Generated
    public void i_method_499900ee(ItemStack itemStack) {
        this.i_field_f2735522 = itemStack;
    }

    @Generated
    public void I_method_c3f7af76(String string) {
        this.I_field_523beb0a = string;
    }

    @Generated
    public void I_method_f41ca494(float f) {
        this.II_field_46 = f;
    }

    @Generated
    public void i_method_f5df94b4(float f) {
        this.Ii_field_46 = f;
    }

    @Generated
    public void II_method_913bba2b(float f) {
        this.iI_field_46 = f;
    }

    @Generated
    public void Ii_method_92feaa4b(float f) {
        this.ii_field_46 = f;
    }

    @Generated
    public void I_method_f41cefa8(boolean bl) {
        this.I_field_5a = bl;
    }

    @Generated
    public void I_method_f6a166e8(IiiIIiIi_Class102.Nested1_6cef9113 nested1_6cef9113) {
        this.I_field_af10c1bc = nested1_6cef9113;
    }
}

