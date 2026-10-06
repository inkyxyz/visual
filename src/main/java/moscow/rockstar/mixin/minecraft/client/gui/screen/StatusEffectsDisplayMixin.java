package moscow.rockstar.mixin.minecraft.client.gui.screen;

import java.util.Collection;
import net.minecraft.client.gui.screen.ingame.StatusEffectsDisplay;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import rockstar.client.IiiiiiiII_Class253;

@Mixin(value={StatusEffectsDisplay.class})
public class StatusEffectsDisplayMixin {
    @ModifyVariable(method={"drawStatusEffects(Lnet/minecraft/client/gui/DrawContext;II)V"}, at=@At(value="STORE"), ordinal=0)
    private Collection<StatusEffectInstance> rockstar$filterStatusEffects(Collection<StatusEffectInstance> collection) {
        return this.filterCollection(collection);
    }

    @Unique
    private Collection<StatusEffectInstance> filterCollection(Collection<StatusEffectInstance> collection) {
        return collection.stream().filter(statusEffectInstance -> !IiiiiiiII_Class253.I_method_d4e81454(statusEffectInstance)).toList();
    }
}

