package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.Sprite;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiIiiiiI_Class95;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iIiiiiIiI_Class379;
import rockstar.client.iiIIIIIIi_Class386;

public class IIiiIIiII_Class101
extends IIiIiiiiI_Class95 {
    private final String I_field_523beb0a;
    private final String i_field_523beb0a;
    private final ItemStack I_field_f2735522;
    private final RegistryEntry<StatusEffect> I_field_3b804775;
    private final ColorRGBA I_field_d0c8ec5;

    public IIiiIIiII_Class101(String string, ItemStack itemStack) {
        super(2500L);
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = null;
        this.I_field_f2735522 = itemStack.copy();
        this.I_field_3b804775 = null;
        this.I_field_d0c8ec5 = null;
    }

    public IIiiIIiII_Class101(String string, String string2, ItemStack itemStack) {
        super(2500L);
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
        this.I_field_f2735522 = itemStack.copy();
        this.I_field_3b804775 = null;
        Integer n = itemStack.getRarity().getFormatting().getColorValue();
        this.I_field_d0c8ec5 = n != null ? ColorRGBA.fromInt(n) : new ColorRGBA(255.0f, 85.0f, 85.0f);
    }

    public IIiiIIiII_Class101(String string, String string2, ItemStack itemStack, ColorRGBA colorRGBA) {
        super(2500L);
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
        this.I_field_f2735522 = itemStack.copy();
        this.I_field_3b804775 = null;
        this.I_field_d0c8ec5 = colorRGBA;
    }

    public IIiiIIiII_Class101(String string, String string2, RegistryEntry<StatusEffect> registryEntry) {
        super(2500L);
        this.I_field_523beb0a = string;
        this.i_field_523beb0a = string2;
        this.I_field_f2735522 = null;
        this.I_field_3b804775 = registryEntry;
        this.I_field_d0c8ec5 = ColorRGBA.fromInt(((StatusEffect)registryEntry.value()).getColor());
    }

    @Override
    public final void I_method_df9d7d83(CustomDrawContext customDrawContext, float f) {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
        float f2 = this.i_field_523beb0a != null && this.I_field_523beb0a.contains(this.i_field_523beb0a) ? iIiIIi_Class10.I_method_2c375926(this.I_field_523beb0a) : iIiIIi_Class10.I_method_2c375926(this.I_field_523beb0a);
        float f3 = f2 + 26.0f;
        this.II_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.Ii_field_dd60aac);
        this.II_field_dc7facc.I_method_edd6ec25(300L);
        float f4 = (float)customDrawContext.getScaledWindowWidth() / 2.0f - f3 / 2.0f;
        float f5 = (float)customDrawContext.getScaledWindowHeight() - 90.0f - this.II_field_dc7facc.I_method_edd6dd11(f);
        float f6 = 20.0f;
        float f7 = 10.0f;
        float f8 = 5.0f;
        float f9 = this.I_field_dc7facc.I_method_6ac4da6f();
        int n = (int)(255.0f * f9);
        iIiiiIIiI_Class371.II_method_e18635ac(customDrawContext.getMatrices(), f4 + f3 / 2.0f, f5 + f6 / 2.0f, 0.5f + 0.5f * f9);
        if (InterfaceModule.Iii_method_c4da86a3()) {
            customDrawContext.drawLiquidGlass(f4, f5, f3, f6, 7.0f, 0.08f, IIiii_Class8.I_method_893b2757(7.0f), ColorRGBA.WHITE.withAlpha(255.0f * f9 * InterfaceModule.I_method_fdcdb22f()));
            customDrawContext.drawSquircle(f4, f5, f3, f6, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(255.0f * iIIiiiiiI_Class319.I_method_5f7ff5cf(IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(), IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(), InterfaceModule.I_method_fdcdb22f()) * f9));
        } else {
            customDrawContext.drawBlurredRect(f4, f5, f3, f6, 45.0f, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), ColorRGBA.WHITE.withAlpha(255.0f * f9 * InterfaceModule.i_method_fddc3e0f()));
            customDrawContext.drawSquircle(f4, f5, f3, f6, 7.0f, IIiii_Class8.I_method_893b2757(7.0f), new ColorRGBA(0.0f, 0.0f, 0.0f).withAlpha((int)(140.25f * f9)));
        }
        float f10 = f4 + f8;
        float f11 = f5 + (f6 - f7) / 2.0f;
        float f12 = RenderSystem.getShaderColor()[3];
        if (this.I_field_3b804775 != null) {
            Sprite sprite = MinecraftClient.getInstance().getStatusEffectSpriteManager().getSprite(this.I_field_3b804775);
            customDrawContext.drawTexture(sprite.getAtlasId(), f10, f11, f7, f7, sprite.getMinU(), sprite.getMaxU(), sprite.getMinV(), sprite.getMaxV(), ColorRGBA.WHITE.withAlpha(255.0f * f9));
        } else if (this.I_field_f2735522 != null) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f9);
            iIiiiIIiI_Class371.II_method_e18635ac(customDrawContext.getMatrices(), f10, f11, f7 / 16.0f);
            customDrawContext.drawItem(this.I_field_f2735522, (int)f10, (int)f11);
            iIiiiIIiI_Class371.I_method_10503b11(customDrawContext.getMatrices());
            DiffuseLighting.disableGuiDepthLighting();
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f12);
            RenderSystem.disableBlend();
        }
        float f13 = f4 + f7 + 10.0f;
        float f14 = f5 + (f6 - iIiIIi_Class10.I_method_a649725c()) / 2.0f;
        iiIIIIIIi_Class386 iiIIIIIIi_Class3862 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, iIiIIi_Class10.I_method_36d49b4b());
        ColorRGBA colorRGBA = ColorRGBA.WHITE.withAlpha(n);
        if (this.i_field_523beb0a != null && this.I_field_d0c8ec5 != null) {
            int n2 = this.I_field_523beb0a.indexOf(this.i_field_523beb0a);
            if (n2 != -1) {
                String string = this.I_field_523beb0a.substring(0, n2);
                String string2 = this.I_field_523beb0a.substring(n2 + this.i_field_523beb0a.length());
                float f15 = f13;
                if (!string.isEmpty()) {
                    customDrawContext.drawText(iIiIIi_Class10, string, f15, f14, colorRGBA);
                    f15 += iIiIIi_Class10.I_method_2c375926(string);
                }
                customDrawContext.drawText(iIiIIi_Class10, this.i_field_523beb0a, f15, f14, this.I_field_d0c8ec5.withAlpha(n));
                f15 += iIiIIi_Class10.I_method_2c375926(this.i_field_523beb0a);
                if (!string2.isEmpty()) {
                    customDrawContext.drawText(iIiIIi_Class10, string2, f15, f14, colorRGBA);
                }
            } else {
                customDrawContext.drawText(iIiIIi_Class10, this.I_field_523beb0a, f13, f14, colorRGBA);
            }
        } else {
            customDrawContext.drawText(iIiIIi_Class10, this.I_field_523beb0a, f13, f14, colorRGBA);
        }
        ((iIiiiiIiI_Class379)iiIIIIIIi_Class3862).II_method_ed687102();
        iIiiiIIiI_Class371.I_method_10503b11(customDrawContext.getMatrices());
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }
}

