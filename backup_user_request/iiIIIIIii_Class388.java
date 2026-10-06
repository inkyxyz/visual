package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.util.math.MatrixStack;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiiIiI_Class379;

public class iiIIIIIii_Class388
extends iIiiiiIiI_Class379 {
    private final MatrixStack I_field_555d9472;

    public iiIIIIIii_Class388(VertexFormat vertexFormat, MatrixStack matrixStack) {
        super(vertexFormat);
        this.I_field_555d9472 = matrixStack;
    }

    @Override
    public void II_method_ed687102() {
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        iIiiIIiii_Class360.ii_method_eecab942();
        this.I_method_28b04e3f();
        iIiiIIiii_Class360.III_method_b23d625f();
        this.i_method_28beda1f();
    }

    @Generated
    public MatrixStack I_method_6b24b2e9() {
        return this.I_field_555d9472;
    }
}

