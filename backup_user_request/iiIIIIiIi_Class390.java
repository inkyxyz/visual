package rockstar.client;

import lombok.Generated;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.util.math.MatrixStack;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiiIiI_Class379;

public class iiIIIIiIi_Class390
extends iIiiiiIiI_Class379 {
    private final MatrixStack I_field_555d9472;
    private final float I_field_46;
    private final float i_field_46;
    private final float II_field_46;
    private final IIiii_Class8 I_field_2d98a52c;

    public iiIIIIiIi_Class390(VertexFormat vertexFormat, MatrixStack matrixStack, float f, float f2, float f3, IIiii_Class8 iIiii_Class8) {
        super(vertexFormat);
        this.I_field_555d9472 = matrixStack;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.II_field_46 = f3;
        this.I_field_2d98a52c = iIiii_Class8;
    }

    @Override
    public void II_method_ed687102() {
        IiiIi_Class14 iiiIi_Class14 = iIiiIIiii_Class360.I_field_2f5b1d2c;
        iiiIi_Class14.I_method_33f6c16b();
        iiiIi_Class14.I_method_cb7dbe45("Size").set(this.I_field_46, this.i_field_46);
        iiiIi_Class14.I_method_cb7dbe45("Radius").set(this.I_field_2d98a52c.I_method_b483cecf() * 3.0f, this.I_field_2d98a52c.Ii_method_dc139032() * 3.0f, this.I_field_2d98a52c.i_method_b4925aaf() * 3.0f, this.I_field_2d98a52c.II_method_dc050452() * 3.0f);
        iiiIi_Class14.I_method_cb7dbe45("Smoothness").set(this.II_field_46);
        iIiiIIiii_Class360.ii_method_eecab942();
        this.I_method_28b04e3f();
        iIiiIIiii_Class360.III_method_b23d625f();
        this.i_method_28beda1f();
    }

    @Generated
    public MatrixStack I_method_a753a729() {
        return this.I_field_555d9472;
    }
}

