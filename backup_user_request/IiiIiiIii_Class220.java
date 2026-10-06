package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.Setting;
import rockstar.client.IiIIiiIii_Class156;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiiIiII_Class373;

public abstract class IiiIiiIii_Class220<T extends Setting>
extends iI_Class3 {
    private final iI_Class3 I_field_502d8b81;
    protected final T I_field_ba11c26c;
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.II_field_dd60aac);
    protected final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
    private float III_field_46;
    private boolean I_field_5a = true;
    private long I_field_4a = System.currentTimeMillis();
    private long i_field_4a;
    protected float iI_field_46;
    protected float ii_field_46;

    public IiiIiiIii_Class220(T t, iI_Class3 iI_Class32) {
        this.I_field_502d8b81 = iI_Class32;
        this.I_field_ba11c26c = t;
    }

    @Override
    public void II_method_b98d0c44(III iII) {
        String string = IiIiIIII_Class81.i_method_1279802a(this.I_field_ba11c26c.getDescriptionKey());
        if (this.I_field_502d8b81 instanceof IiIIiiIii_Class156 && this.I_method_7ae26dde(iII)) {
            RockstarClient.getInstance().I_method_35687482().I_method_23967689(IiIiIIII_Class81.I_method_f25a980a(string));
        }
        super.II_method_b98d0c44(iII);
    }

    @Override
    public void I_method_575ca63f() {
        super.I_method_575ca63f();
    }

    public float iI_method_960a0912() {
        return this.i_field_dc7facc.I_method_6ac4da6f();
    }

    public void Ii_method_6b12c484(III iII) {
    }

    public void iI_method_20338844(III iII) {
    }

    protected void I_method_2d447471(III iII, IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, float f3, ColorRGBA colorRGBA, float f4, float f5) {
        float f6;
        boolean bl;
        float f7 = Math.max(1.0f, f3);
        float f8 = iIiIIi_Class10.I_method_2c375926(string);
        long l = System.currentTimeMillis();
        boolean bl2 = this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32());
        float f9 = Math.max(0.0f, f8 - f7);
        float f10 = (float)(l - this.I_field_4a) / 1000.0f;
        this.I_field_4a = l;
        boolean bl3 = bl = bl2 && f9 > 0.0f;
        if (f9 <= 0.0f) {
            this.III_field_46 = 0.0f;
        } else if (bl) {
            this.III_field_46 = Math.min(this.III_field_46, f9);
            if (l >= this.i_field_4a) {
                f6 = f10 * 35.0f;
                if (this.I_field_5a) {
                    this.III_field_46 = Math.min(this.III_field_46 + f6, f9);
                    if (this.III_field_46 >= f9) {
                        this.I_field_5a = false;
                        this.i_field_4a = l + 600L;
                    }
                } else {
                    this.III_field_46 = Math.max(this.III_field_46 - f6, 0.0f);
                    if (this.III_field_46 <= 0.0f) {
                        this.I_field_5a = true;
                        this.i_field_4a = l + 600L;
                    }
                }
            }
        } else if (this.III_field_46 > 0.0f) {
            this.III_field_46 = Math.max(0.0f, this.III_field_46 - f10 * 35.0f);
            if (this.III_field_46 == 0.0f) {
                this.I_field_5a = true;
                this.i_field_4a = l;
            }
        }
        f6 = Math.max(this.Ii_field_46, iIiIIi_Class10.I_method_a649725c() + 4.0f);
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), f - 3.0f, this.i_field_46 - 3.0f, f7 + 6.0f, f6 + 6.0f);
        iII.pushMatrix();
        iII.getMatrices().translate(-this.III_field_46, 0.0f, 0.0f);
        iII.drawFadeoutText(iIiIIi_Class10, string, f, f2, colorRGBA, 0.95f, f5, f7);
        iII.popMatrix();
        iIiiiIiII_Class373.I_method_ff80a1df();
    }

    @Generated
    public iI_Class3 I_method_c4c8e2f8() {
        return this.I_field_502d8b81;
    }

    @Generated
    public T I_method_c1026715() {
        return this.I_field_ba11c26c;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_14b89f75() {
        return this.i_field_dc7facc;
    }

    @Generated
    public IiiiIiIii_Class236 i_method_2a4e1355() {
        return this.I_field_dc7facc;
    }

    @Generated
    public float ii_method_961894f2() {
        return this.III_field_46;
    }

    @Generated
    public boolean I_method_575ca643() {
        return this.I_field_5a;
    }

    @Generated
    public long I_method_575ca633() {
        return this.I_field_4a;
    }

    @Generated
    public long i_method_576b3213() {
        return this.i_field_4a;
    }

    @Generated
    public float III_method_f4aafe8f() {
        return this.iI_field_46;
    }

    @Generated
    public float IIi_method_f4b98a6f() {
        return this.ii_field_46;
    }

    @Generated
    public void iI_method_2b3782de(float f) {
        this.iI_field_46 = f;
    }

    @Generated
    public void ii_method_2cfa72fe(float f) {
        this.ii_field_46 = f;
    }
}

