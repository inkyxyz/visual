package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.iIiiiiIii_Class380;
import rockstar.client.iiiIiiI_Class119;

public class iiiIiIi_Class118
extends iiiIiiI_Class119 {
    private final ItemStack I_field_f2735522;

    public iiiIiIi_Class118(String string, ItemStack itemStack) {
        super(string, null, null);
        this.I_field_f2735522 = itemStack.copy();
    }

    public iiiIiIi_Class118(String string, Item item) {
        super(string, null, null);
        this.I_field_f2735522 = item.getDefaultStack();
    }

    public iiiIiIi_Class118 I_method_7ab92a7f(String string) {
        this.i_field_523beb0a = string;
        if (this.I_field_d0c8ec5 == null) {
            Integer n = this.I_field_f2735522.getRarity().getFormatting().getColorValue();
            this.I_field_d0c8ec5 = n != null ? ColorRGBA.fromInt(n) : new ColorRGBA(255.0f, 85.0f, 85.0f);
        }
        return this;
    }

    public iiiIiIi_Class118 I_method_c9efc756(ColorRGBA colorRGBA) {
        this.I_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Override
    protected void I_method_3b7cb03(CustomDrawContext customDrawContext, float f, float f2, float f3) {
        float[] fArray = (float[])RenderSystem.getShaderColor().clone();
        boolean bl = GL11.glIsEnabled((int)3042);
        iIiiiiIii_Class380.I_method_5f4b621f();
        customDrawContext.draw();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f3);
        customDrawContext.drawItem(this.I_field_f2735522, f, f2, 0.625f);
        customDrawContext.draw();
        RenderSystem.setShaderColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
        if (!bl) {
            RenderSystem.disableBlend();
        }
    }
}

