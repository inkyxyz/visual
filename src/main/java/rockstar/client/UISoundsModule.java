package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;

@ModuleInfo(
    name = "UISounds",
    category = ModuleCategory.INTERFACE,
    iI_method_476ab839 = true,
    III_method_a89e5834 = "modules.descriptions.uisounds"
)
public class UISoundsModule extends Module {
    private final SliderSetting volume = new SliderSetting(this, "Volume")
        .I_method_c8c9a7d7(10.0F)
        .i_method_65e2aff7(100.0F)
        .Ii_method_4e0e6b54(80.0F)
        .II_method_b0f56334(5.0F)
        .I_method_d41e7abf("%");

    private final SliderSetting pitch = new SliderSetting(this, "Pitch")
        .I_method_c8c9a7d7(0.5F)
        .i_method_65e2aff7(2.0F)
        .Ii_method_4e0e6b54(1.0F)
        .II_method_b0f56334(0.05F);

    private final BooleanSetting buttonClicks = new BooleanSetting(this, "Button Clicks").I_method_a4d009eb(true);
    private final BooleanSetting toggleSounds = new BooleanSetting(this, "Toggle Sounds").I_method_a4d009eb(true);
    private final BooleanSetting screenSounds = new BooleanSetting(this, "Screen Open").I_method_a4d009eb(true);
    private final BooleanSetting hudSounds = new BooleanSetting(this, "HUD Actions").I_method_a4d009eb(true);

    public UISoundsModule() {
    }

    public float getVolume() {
        return this.volume.Ii_method_a20abcd2() / 100.0F;
    }

    public float getPitch() {
        return this.pitch.Ii_method_a20abcd2();
    }

    public boolean isButtonClicks() {
        return this.buttonClicks.i_method_9b12da03();
    }

    public boolean isToggleSounds() {
        return this.toggleSounds.i_method_9b12da03();
    }

    public boolean isScreenSounds() {
        return this.screenSounds.i_method_9b12da03();
    }

    public boolean isHudSounds() {
        return this.hudSounds.i_method_9b12da03();
    }
}
