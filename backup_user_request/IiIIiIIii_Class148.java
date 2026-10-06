package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.Rect;
import rockstar.client.iiIiIIiii_Class424;

public class IiIIiIIii_Class148
extends Rect {
    private Rect I_field_3946a376 = Rect.EMPTY;
    private Rect i_field_3946a376 = Rect.EMPTY;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private float I_field_46 = 0.0f;
    private float i_field_46 = 0.0f;
    private float II_field_46 = 0.0f;
    private float Ii_field_46 = 0.0f;
    private float iI_field_46 = 0.0f;
    private float ii_field_46 = 0.0f;
    private float III_field_46 = 0.0f;
    private final float IIi_field_46 = 0.8f;
    private final float IiI_field_46 = 8.0f;
    private float Iii_field_46 = 1.0f;
    private float iII_field_46 = 1.0f;
    private float iIi_field_46 = 1.0f;
    private float iiI_field_46 = 1.0f;
    private boolean I_field_5a = false;
    private boolean i_field_5a = false;

    public void I_method_9e30d2bf(float f, float f2, float f3, float f4) {
        this.I_method_c992203f(new Rect(f, f2, f3, f4), false);
    }

    public void I_method_27ea37f5(float f, float f2, float f3, float f4, boolean bl) {
        this.I_method_c992203f(new Rect(f, f2, f3, f4), bl);
    }

    public void I_method_9b25b935(Rect rect) {
        this.I_method_c992203f(rect, false);
    }

    public void I_method_c992203f(Rect rect, boolean bl) {
        float f;
        float f2;
        float f3;
        float f4;
        boolean bl2;
        float f5 = 0.3f;
        float f6 = 0.1f;
        float f7 = 15.0f;
        float f8 = 0.3f;
        float f9 = Math.min((float)this.I_field_991c1e8c.I_method_23e11e33() / 1000.0f, 0.033f);
        this.I_field_991c1e8c.I_method_23e11e3f();
        if (f9 < 0.001f) {
            return;
        }
        this.I_field_3946a376 = rect;
        this.II_field_46 = this.I_field_46;
        this.Ii_field_46 = this.i_field_46;
        float f10 = rect.getX() - this.i_field_3946a376.getX();
        float f11 = rect.getY() - this.i_field_3946a376.getY();
        float f12 = (float)Math.sqrt(f10 * f10 + f11 * f11);
        this.iI_field_46 = bl ? (this.iI_field_46 += f12) : 0.0f;
        this.I_field_46 = f10 / f9;
        this.i_field_46 = f11 / f9;
        this.I_field_46 = (float)((double)this.I_field_46 * Math.pow(f6, f9 * 60.0f));
        this.i_field_46 = (float)((double)this.i_field_46 * Math.pow(f6, f9 * 60.0f));
        float f13 = Math.abs(this.I_field_46);
        float f14 = Math.abs(this.i_field_46);
        float f15 = Math.abs(this.II_field_46);
        float f16 = Math.abs(this.Ii_field_46);
        boolean bl3 = bl2 = !bl || this.iI_field_46 > 5.0f;
        if (!bl && bl2) {
            f4 = Math.abs(this.I_field_46 - this.II_field_46);
            f3 = Math.abs(this.i_field_46 - this.Ii_field_46);
            if (f15 > 100.0f && f4 > 80.0f) {
                f2 = Math.signum(this.II_field_46);
                this.ii_field_46 = f2 * f15 * 0.8f * 0.01f;
            }
            if (f16 > 100.0f && f3 > 80.0f) {
                f2 = Math.signum(this.Ii_field_46);
                this.III_field_46 = f2 * f16 * 0.8f * 0.01f;
            }
        }
        this.ii_field_46 += (0.0f - this.ii_field_46) * f9 * 8.0f;
        this.III_field_46 += (0.0f - this.III_field_46) * f9 * 8.0f;
        if (Math.abs(this.ii_field_46) < 0.1f) {
            this.ii_field_46 = 0.0f;
        }
        if (Math.abs(this.III_field_46) < 0.1f) {
            this.III_field_46 = 0.0f;
        }
        if (f15 > 50.0f && f13 < 20.0f && bl2) {
            this.I_field_5a = true;
        }
        if (f16 > 50.0f && f14 < 20.0f && bl2) {
            this.i_field_5a = true;
        }
        if ((f13 > 5.0f || f14 > 5.0f) && bl2) {
            this.I_field_5a = false;
            this.i_field_5a = false;
            if (f13 > f14) {
                this.iIi_field_46 = 1.0f + f13 * f5 * 8.0E-4f;
                this.iiI_field_46 = Math.max(0.6f, 1.0f - f13 * f5 * 0.002f);
            } else {
                this.iIi_field_46 = Math.max(0.6f, 1.0f - f14 * f5 * 0.002f);
                this.iiI_field_46 = 1.0f + f14 * f5 * 8.0E-4f;
            }
        } else if ((this.I_field_5a || this.i_field_5a) && bl2) {
            if (this.I_field_5a) {
                this.iIi_field_46 = 1.0f - f8 * 0.3f;
                this.iiI_field_46 = 1.0f + f8 * 0.5f;
                if (Math.abs(this.Iii_field_46 - this.iIi_field_46) < 0.05f && Math.abs(this.iII_field_46 - this.iiI_field_46) < 0.05f) {
                    this.I_field_5a = false;
                }
            }
            if (this.i_field_5a) {
                this.iIi_field_46 = 1.0f + f8 * 0.5f;
                this.iiI_field_46 = 1.0f - f8 * 0.3f;
                if (Math.abs(this.Iii_field_46 - this.iIi_field_46) < 0.05f && Math.abs(this.iII_field_46 - this.iiI_field_46) < 0.05f) {
                    this.i_field_5a = false;
                }
            }
        } else {
            this.iIi_field_46 = 1.0f;
            this.iiI_field_46 = 1.0f;
        }
        this.Iii_field_46 += (this.iIi_field_46 - this.Iii_field_46) * f9 * f7;
        this.iII_field_46 += (this.iiI_field_46 - this.iII_field_46) * f9 * f7;
        f4 = rect.getWidth() * this.Iii_field_46;
        f3 = rect.getHeight() * this.iII_field_46;
        if (f13 > f14 && f13 > 5.0f && bl2) {
            f2 = this.I_field_46 > 0.0f ? rect.getWidth() - f4 : 0.0f;
            f = (rect.getHeight() - f3) * 0.5f;
        } else if (f14 > 5.0f && bl2) {
            f2 = (rect.getWidth() - f4) * 0.5f;
            f = this.i_field_46 > 0.0f ? rect.getHeight() - f3 : 0.0f;
        } else {
            f2 = (rect.getWidth() - f4) * 0.5f;
            f = (rect.getHeight() - f3) * 0.5f;
        }
        this.set(rect.getX() + f2 + this.ii_field_46, rect.getY() + f + this.III_field_46, f4, f3);
        this.i_field_3946a376 = new Rect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    public void I_method_d89a1a3f() {
        this.Iii_field_46 = 1.0f;
        this.iII_field_46 = 1.0f;
        this.iIi_field_46 = 1.0f;
        this.iiI_field_46 = 1.0f;
        this.I_field_46 = 0.0f;
        this.i_field_46 = 0.0f;
        this.II_field_46 = 0.0f;
        this.Ii_field_46 = 0.0f;
        this.I_field_5a = false;
        this.i_field_5a = false;
        this.iI_field_46 = 0.0f;
        this.ii_field_46 = 0.0f;
        this.III_field_46 = 0.0f;
        this.I_field_991c1e8c.I_method_23e11e3f();
    }

    @Generated
    public Rect I_method_68649fed() {
        return this.I_field_3946a376;
    }
}

