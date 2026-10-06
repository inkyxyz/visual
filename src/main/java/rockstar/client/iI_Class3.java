package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.Rect;
import rockstar.client.III;
import rockstar.client.IiIII_Class9;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iIIiIIiIi_Class294;

public abstract class iI_Class3
implements iIIiIIiIi_Class294 {
    protected float I_field_46;
    protected float i_field_46;
    protected float II_field_46;
    protected float Ii_field_46;

    protected iI_Class3() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void I_method_7ae26dda(III iII) {
        this.II_method_b98d0c44(iII);
        this.i_method_bdd4e0ec(iII);
    }

    protected abstract void i_method_bdd4e0ec(III var1);

    public void I_method_575ca63f() {
    }

    public void II_method_b98d0c44(III iII) {
    }

    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
    }

    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
    }

    public void I_method_c1acbc24(int n, int n2, int n3) {
    }

    public boolean I_method_b71e84c9(char c, int n) {
        return false;
    }

    public void I_method_6b0ad25f(double d, double d2, double d3, double d4) {
    }

    public void I_method_a74dc6cc(float f, float f2) {
        this.I_field_46 = f;
        this.i_field_46 = f2;
    }

    public void I_method_b043bcc(float f, float f2, float f3, float f4) {
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.II_field_46 = f3;
        this.Ii_field_46 = f4;
    }

    public void I_method_5020b42(Rect rect) {
        this.I_field_46 = rect.getX();
        this.i_field_46 = rect.getY();
        this.II_field_46 = rect.getWidth();
        this.Ii_field_46 = rect.getHeight();
    }

    public boolean I_method_a74dc6d0(float f, float f2) {
        return iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46, f, f2);
    }

    public boolean I_method_a74cd690(double d, double d2) {
        return iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46, d, d2);
    }

    public boolean I_method_7ae26dde(III iII) {
        return this.I_method_a74dc6d0(iII.I_method_b1c3e152(), iII.i_method_b1d26d32());
    }

    @Generated
    public float I_method_4e7e11bc() {
        return this.I_field_46;
    }

    @Generated
    public float i_method_4e8c9d9c() {
        return this.i_field_46;
    }

    @Generated
    public float II_method_c7206932() {
        return this.II_field_46;
    }

    @Generated
    public float Ii_method_2047ead7() {
        return this.Ii_field_46;
    }

    @Generated
    public void I_method_81448f74(float f) {
        this.I_field_46 = f;
    }

    @Generated
    public void i_method_83077f94(float f) {
        this.i_field_46 = f;
    }

    @Generated
    public void II_method_a9112b4b(float f) {
        this.II_field_46 = f;
    }

    @Generated
    public void Ii_method_aad41b6b(float f) {
        this.Ii_field_46 = f;
    }

    @Generated
    protected iI_Class3(float f, float f2, float f3, float f4) {
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.II_field_46 = f3;
        this.Ii_field_46 = f4;
    }
}

