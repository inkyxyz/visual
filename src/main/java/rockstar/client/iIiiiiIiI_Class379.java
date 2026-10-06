package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat;
import org.joml.Matrix4f;
import rockstar.client.IIiii_Class8;
import rockstar.client.iIiiiiIii_Class380;

public abstract class iIiiiiIiI_Class379 {
    protected static iIiiiiIiI_Class379 I_field_45034e8c;
    private final iIiiiiIiI_Class379 i_field_45034e8c;
    protected BufferBuilder I_field_152af1f5;

    public iIiiiiIiI_Class379(VertexFormat vertexFormat) {
        iIiiiiIii_Class380.I_method_5f4b621f();
        this.i_field_45034e8c = I_field_45034e8c;
        this.I_field_152af1f5 = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.QUADS, vertexFormat);
        I_field_45034e8c = this;
    }

    protected void I_method_28b04e3f() {
        BuiltBuffer builtBuffer = this.I_field_152af1f5.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
    }

    public boolean I_method_27af5b70(Matrix4f matrix4f, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, int n) {
        return false;
    }

    protected void i_method_28beda1f() {
        if (I_field_45034e8c == this) {
            I_field_45034e8c = this.i_field_45034e8c;
        }
    }

    public abstract void II_method_ed687102();

    @Generated
    public iIiiiiIiI_Class379 I_method_7e859b35() {
        return this.i_field_45034e8c;
    }

    @Generated
    public BufferBuilder I_method_b8b8cc9e() {
        return this.I_field_152af1f5;
    }

    @Generated
    public static iIiiiiIiI_Class379 i_method_941b0f15() {
        return I_field_45034e8c;
    }
}

