package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import rockstar.client.IiiIi_Class14;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiiIiI_Class379;

public class iiIIIIiiI_Class391
extends iIiiiiIiI_Class379 {
    private final IiiIi_Class14 I_field_2f5b1d2c = iIiiIIiii_Class360.I_method_b2dd8215();
    private final float I_field_46;
    private final float i_field_46;

    public iiIIIIiiI_Class391(float f) {
        super(VertexFormats.POSITION_COLOR);
        this.I_field_46 = 0.5f;
        this.i_field_46 = f;
    }

    @Override
    public void II_method_ed687102() {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        this.I_field_2f5b1d2c.I_method_33f6c16b();
        this.I_field_2f5b1d2c.I_method_cb7dbe45("Smoothness").set(this.I_field_46);
        this.I_field_2f5b1d2c.I_method_cb7dbe45("CornerSmoothness").set(this.i_field_46);
        BuiltBuffer builtBuffer = this.I_method_b8b8cc9e().endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        this.i_method_28beda1f();
    }

    public void I_method_f92c6454(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
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
}

