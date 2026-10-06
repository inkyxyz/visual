package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.iiiIiiI_Class119;

public class iiiIiII_Class117
extends iiiIiiI_Class119 {
    private final RegistryEntry<StatusEffect> I_field_3b804775;

    public iiiIiII_Class117(String string, RegistryEntry<StatusEffect> registryEntry) {
        super(string, null, ColorRGBA.fromInt(((StatusEffect)registryEntry.value()).getColor()));
        this.I_field_3b804775 = registryEntry;
    }

    public iiiIiII_Class117 I_method_4164eabf(String string) {
        this.i_field_523beb0a = string;
        return this;
    }

    public iiiIiII_Class117 I_method_57ff3b56(ColorRGBA colorRGBA) {
        this.I_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Override
    protected void I_method_3b7cb03(CustomDrawContext customDrawContext, float f, float f2, float f3) {
        Sprite sprite = MinecraftClient.getInstance().getStatusEffectSpriteManager().getSprite(this.I_field_3b804775);
        customDrawContext.drawTexture(sprite.getAtlasId(), f, f2, 10.0f, 10.0f, sprite.getMinU(), sprite.getMaxU(), sprite.getMinV(), sprite.getMaxV(), ColorRGBA.WHITE.withAlpha(255.0f * f3));
    }
}

