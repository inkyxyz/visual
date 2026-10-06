package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import rockstar.client.IIiiii_Class16;
import rockstar.client.IiIIIi_Class18;
import rockstar.client.iIiiiiIiI_Class379;
import rockstar.client.iIiiiiIii_Class380;

public class iiIIIIIIi_Class386
extends iIiiiiIiI_Class379 {
    protected IIiiii_Class16 I_field_857c0621;

    public iiIIIIIIi_Class386(VertexFormat vertexFormat, IIiiii_Class16 iIiiii_Class16) {
        super(VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        this.I_field_857c0621 = iIiiii_Class16;
    }

    @Override
    public void II_method_ed687102() {
        float f = 0.0f;
        float f2 = 0.5f;
        float f3 = 0.0f;
        iIiiiiIii_Class380.Ii_method_8a3e6502();
        RenderSystem.disableCull();
        ShaderProgram shaderProgram = IiIIIi_Class18.I_method_fb4921e0(f);
        shaderProgram.getUniform("EnableFadeout").set(0);
        this.I_method_28b04e3f();
        IiIIIi_Class18.I_method_a6e9b62c();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        this.i_method_28beda1f();
    }
}

