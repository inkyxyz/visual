package rockstar.client;

import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.game.SoundEvent;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;

public class IiiIII_Class25 {
    public static void I_method_41814ae7(SoundInstance soundInstance, CallbackInfo callbackInfo) {
        String string;
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.IIiI_method_f2a1ecb3().isSelected() && (soundInstance.getId().equals((Object)SoundEvents.BLOCK_BEACON_ACTIVATE.id()) || soundInstance.getId().equals((Object)SoundEvents.BLOCK_BEACON_AMBIENT.id()) || soundInstance.getId().equals((Object)SoundEvents.BLOCK_BEACON_POWER_SELECT.id()) || soundInstance.getId().equals((Object)SoundEvents.BLOCK_BEACON_DEACTIVATE.id()))) {
            callbackInfo.cancel();
        }
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.IiII_method_dba2f073().isSelected() && (soundInstance.getId().equals((Object)SoundEvents.WEATHER_RAIN.id()) || soundInstance.getId().equals((Object)SoundEvents.WEATHER_RAIN_ABOVE.id()) || soundInstance.getId().equals((Object)SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER.id()))) {
            callbackInfo.cancel();
        }
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.IIii_method_f8a9e893().isSelected() && (soundInstance.getId().equals((Object)SoundEvents.ENTITY_PARROT_IMITATE_PHANTOM.id()) || soundInstance.getId().equals((Object)SoundEvents.ENTITY_PHANTOM_AMBIENT.id()) || soundInstance.getId().equals((Object)SoundEvents.ENTITY_PHANTOM_BITE.id()) || soundInstance.getId().equals((Object)SoundEvents.ENTITY_PHANTOM_FLAP.id()) || soundInstance.getId().equals((Object)SoundEvents.ENTITY_PHANTOM_DEATH.id()) || soundInstance.getId().equals((Object)SoundEvents.ENTITY_PHANTOM_HURT.id()) || soundInstance.getId().equals((Object)SoundEvents.ENTITY_PHANTOM_SWOOP.id()))) {
            callbackInfo.cancel();
        }
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.IiIi_method_e1aaec53().isSelected() && (string = soundInstance.getId().getPath()).contains("water")) {
            callbackInfo.cancel();
        }
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.IiiI_method_969a7093().isSelected() && (string = soundInstance.getId().getPath()).contains("lava")) {
            callbackInfo.cancel();
        }
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new SoundEvent(soundInstance));
    }
}

