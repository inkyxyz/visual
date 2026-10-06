package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.util.math.MatrixStack;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiiIiI_Class379;

public class iiIIIIIiI_Class387
extends iIiiiiIiI_Class379 {
    private final MatrixStack I_field_555d9472;

    public iiIIIIIiI_Class387(VertexFormat vertexFormat, MatrixStack matrixStack) {
        super(vertexFormat);
        this.I_field_555d9472 = matrixStack;
    }

    @Override
    public void II_method_ed687102() {
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.enableBlend();
        this.I_method_28b04e3f();
        iIiiIIiii_Class360.III_method_b23d625f();
        RenderSystem.setShaderTexture((int)0, (int)0);
        this.i_method_28beda1f();
    }

    @Generated
    public MatrixStack I_method_79f172c9() {
        return this.I_field_555d9472;
    }
}

