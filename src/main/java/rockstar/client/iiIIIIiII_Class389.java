package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiiIiI_Class379;

public class iiIIIIiII_Class389
extends iIiiiiIiI_Class379 {
    private final IiiIi_Class14 I_field_2f5b1d2c = iIiiIIiii_Class360.I_field_2f5b1d2c;
    private float I_field_46 = 0.5f;

    public iiIIIIiII_Class389() {
        super(VertexFormats.POSITION_COLOR);
    }

    public iiIIIIiII_Class389 I_method_62c2bd7(float f) {
        this.I_field_46 = f;
        return this;
    }

    @Override
    public void II_method_ed687102() {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        this.I_field_2f5b1d2c.I_method_33f6c16b();
        this.I_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(this.I_field_46);
        BuiltBuffer builtBuffer = this.I_method_b8b8cc9e().endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        this.i_method_28beda1f();
    }

    public void I_method_1e146c34(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        this.I_field_2f5b1d2c.I_method_cb7dbe45("Size").set(f3, f4);
        this.I_field_2f5b1d2c.I_method_cb7dbe45("Radius").set(f5, f6, f7, f8);
        float f9 = -this.I_field_46 / 2.0f + this.I_field_46 * 2.0f;
        float f10 = this.I_field_46 / 2.0f + this.I_field_46;
        float f11 = f - f9 / 2.0f;
        float f12 = f2 - f10 / 2.0f;
        float f13 = f3 + f9;
        float f14 = f4 + f10;
        this.I_method_b8b8cc9e().vertex(matrix4f, f11, f12, 0.0f).color(n);
        this.I_method_b8b8cc9e().vertex(matrix4f, f11, f12 + f14, 0.0f).color(n);
        this.I_method_b8b8cc9e().vertex(matrix4f, f11 + f13, f12 + f14, 0.0f).color(n);
        this.I_method_b8b8cc9e().vertex(matrix4f, f11 + f13, f12, 0.0f).color(n);
    }

    @Override
    public boolean I_method_27af5b70(Matrix4f matrix4f, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, int n) {
        this.I_method_1e146c34(matrix4f, f, f2, f3, f4, iIiii_Class8.I_method_b483cecf(), iIiii_Class8.Ii_method_dc139032(), iIiii_Class8.i_method_b4925aaf(), iIiii_Class8.II_method_dc050452(), n);
        return true;
    }
}

