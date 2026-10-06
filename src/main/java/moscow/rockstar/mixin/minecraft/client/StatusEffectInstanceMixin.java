package moscow.rockstar.mixin.minecraft.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IiIIiIiIi_Class150;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIiIiiiIi_Class350;

@Mixin(value={StatusEffectInstance.class})
public class StatusEffectInstanceMixin
implements iIiIiiiIi_Class350 {
    @Unique
    private IiiiIiIii_Class236 potionStatusAnimation;
    @Unique
    private IiIIiIiIi_Class150 timeAnimation;

    @Inject(method={"<init>(Lnet/minecraft/registry/entry/RegistryEntry;IIZZZLnet/minecraft/entity/effect/StatusEffectInstance;)V"}, at={@At(value="TAIL")})
    public void onInit(RegistryEntry<?> registryEntry, int n, int n2, boolean bl, boolean bl2, boolean bl3, StatusEffectInstance statusEffectInstance, CallbackInfo callbackInfo) {
        if (MinecraftClient.getInstance() == null || MinecraftClient.getInstance().player == null) {
            return;
        }
        this.timeAnimation = new IiIIiIiIi_Class150(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), 3.0f, 300L, IiiiIiiII_Class237.III_field_dd60aac);
    }

    @Override
    public IiiiIiIii_Class236 rockstar$getAnimPotion() {
        if (this.potionStatusAnimation == null) {
            this.potionStatusAnimation = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
        }
        return this.potionStatusAnimation;
    }

    @Override
    public IiIIiIiIi_Class150 rockstar$getTimeAnimation() {
        return this.timeAnimation;
    }
}

