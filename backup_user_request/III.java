package rockstar.client;

import lombok.Generated;
import net.minecraft.client.gui.DrawContext;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IIiii_Class8;
import rockstar.client.iIiiIIiii_Class360;

public class III
extends CustomDrawContext {
    private int I_field_49;
    private int i_field_49;
    private final float I_field_46;

    public void setMousePos(int mouseX, int mouseY) {
        this.I_field_49 = mouseX;
        this.i_field_49 = mouseY;
    }

    protected III(DrawContext drawContext, int n, int n2, float f) {
        super(drawContext);
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.I_field_46 = f;
    }

    public static III I_method_5728d20f(DrawContext drawContext, int n, int n2, float f) {
        return new III(drawContext, n, n2, f);
    }

    public void I_method_b16fbb95(int n, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_63dda827(this.getMatrices(), n, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, iIiii_Class8, colorRGBA);
    }

    @Generated
    public int I_method_b1c3e152() {
        return this.I_field_49;
    }

    @Generated
    public int i_method_b1d26d32() {
        return this.i_field_49;
    }

    @Generated
    public float I_method_b1c3e14f() {
        return this.I_field_46;
    }
}

