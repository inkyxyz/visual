package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import rockstar.client.IIiiii_Class16;
import rockstar.client.IiIIIi_Class18;
import rockstar.client.iIiiiiIiI_Class379;

public class iIiiiiiii_Class384
extends iIiiiiIiI_Class379 {
    protected IIiiii_Class16 I_field_857c0621;
    private float I_field_46;
    private float i_field_46;
    private float II_field_46;
    private float Ii_field_46;

    public iIiiiiiii_Class384(VertexFormat vertexFormat, IIiiii_Class16 iIiiii_Class16, float f, float f2, float f3, float f4) {
        super(VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        this.I_field_857c0621 = iIiiii_Class16;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.II_field_46 = f3;
        this.Ii_field_46 = f4;
    }

    @Override
    public void II_method_ed687102() {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        ShaderProgram shaderProgram = IiIIIi_Class18.I_method_fb4921e0(0.0f);
        shaderProgram.getUniform("EnableFadeout").set(1);
        shaderProgram.getUniform("FadeoutStart").set(this.I_field_46);
        shaderProgram.getUniform("FadeoutEnd").set(this.i_field_46);
        shaderProgram.getUniform("MaxWidth").set(this.II_field_46);
        shaderProgram.getUniform("TextPosX").set(this.Ii_field_46);
        this.I_method_28b04e3f();
        IiIIIi_Class18.I_method_a6e9b62c();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        this.i_method_28beda1f();
    }
}

