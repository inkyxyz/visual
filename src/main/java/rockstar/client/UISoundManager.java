package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;

public class UISoundManager {
    public static void playButtonClick() {
        try {
            UISoundsModule uiSounds = RockstarClient.getInstance().getModuleManager().getModule(UISoundsModule.class);
            if (uiSounds != null && uiSounds.isEnabled() && uiSounds.isButtonClicks()) {
                float vol = uiSounds.getVolume();
                float pitch = uiSounds.getPitch();
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.getSoundManager() != null) {
                    mc.getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK.value(), pitch, vol));
                }
                return;
            }

            SoundsModule sounds = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
            if (sounds != null && sounds.isEnabled() && sounds.isUiSoundsEnabled()) {
                float vol = sounds.I_method_45ee5ef();
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.getSoundManager() != null) {
                    mc.getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK.value(), 1.0F, vol));
                }
            }
        } catch (Throwable ignored) {}
    }

    public static void playToggle(boolean on) {
        try {
            UISoundsModule uiSounds = RockstarClient.getInstance().getModuleManager().getModule(UISoundsModule.class);
            if (uiSounds != null && uiSounds.isEnabled() && uiSounds.isToggleSounds()) {
                float vol = uiSounds.getVolume();
                float pitch = uiSounds.getPitch() * (on ? 1.15F : 0.95F);
                iiIiIIIII_Class417.i_field_34b2ba6c.I_method_7289b65f(vol, pitch);
                return;
            }

            SoundsModule sounds = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
            if (sounds != null && sounds.isEnabled() && sounds.isUiSoundsEnabled()) {
                float vol = sounds.I_method_45ee5ef();
                iiIiIIIII_Class417.i_field_34b2ba6c.I_method_7289b65f(vol, on ? 1.15F : 0.95F);
            }
        } catch (Throwable ignored) {}
    }

    public static void playScreenOpen() {
        try {
            UISoundsModule uiSounds = RockstarClient.getInstance().getModuleManager().getModule(UISoundsModule.class);
            if (uiSounds != null && uiSounds.isEnabled() && uiSounds.isScreenSounds()) {
                float vol = uiSounds.getVolume();
                iiIiIIIII_Class417.I_field_34b2ba6c.I_method_87d2e181(vol);
                return;
            }

            SoundsModule sounds = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
            if (sounds != null && sounds.isEnabled() && sounds.isUiSoundsEnabled()) {
                float vol = sounds.I_method_45ee5ef();
                iiIiIIIII_Class417.I_field_34b2ba6c.I_method_87d2e181(vol);
            }
        } catch (Throwable ignored) {}
    }

    public static void playHudAction() {
        try {
            UISoundsModule uiSounds = RockstarClient.getInstance().getModuleManager().getModule(UISoundsModule.class);
            if (uiSounds != null && uiSounds.isEnabled() && uiSounds.isHudSounds()) {
                float vol = uiSounds.getVolume();
                iiIiIIIII_Class417.II_field_34b2ba6c.I_method_87d2e181(vol);
                return;
            }

            SoundsModule sounds = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
            if (sounds != null && sounds.isEnabled() && sounds.isUiSoundsEnabled()) {
                float vol = sounds.I_method_45ee5ef();
                iiIiIIIII_Class417.II_field_34b2ba6c.I_method_87d2e181(vol);
            }
        } catch (Throwable ignored) {}
    }
}
