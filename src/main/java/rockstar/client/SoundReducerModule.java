package rockstar.client;

import net.minecraft.client.sound.SoundInstance;
import net.minecraft.util.Identifier;

@ModuleInfo(
    name = "Sound Reducer",
    category = ModuleCategory.UTILS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.sound_reducer"
)
public class SoundReducerModule extends Module {
    private final BooleanSetting mutePortals;
    private final BooleanSetting muteExplosions;
    private final BooleanSetting muteLightning;
    private final BooleanSetting muteAnvils;
    private final BooleanSetting muteTotems;

    public SoundReducerModule() {
        this.mutePortals = new BooleanSetting(this, "modules.settings.mute_portals").I_method_decd82b5();
        this.muteExplosions = new BooleanSetting(this, "modules.settings.mute_explosions");
        this.muteLightning = new BooleanSetting(this, "modules.settings.mute_lightning").I_method_decd82b5();
        this.muteAnvils = new BooleanSetting(this, "modules.settings.mute_anvils").I_method_decd82b5();
        this.muteTotems = new BooleanSetting(this, "modules.settings.mute_totems");
    }

    public boolean shouldMute(SoundInstance soundInstance) {
        if (soundInstance == null || soundInstance.getId() == null) return false;
        String path = soundInstance.getId().getPath().toLowerCase();

        if (this.mutePortals.i_method_9b12da03() && (path.contains("portal") || path.contains("nether_portal"))) {
            return true;
        }
        if (this.muteExplosions.i_method_9b12da03() && (path.contains("explode") || path.contains("explosion") || path.contains("tnt"))) {
            return true;
        }
        if (this.muteLightning.i_method_9b12da03() && (path.contains("lightning") || path.contains("thunder"))) {
            return true;
        }
        if (this.muteAnvils.i_method_9b12da03() && path.contains("anvil")) {
            return true;
        }
        if (this.muteTotems.i_method_9b12da03() && path.contains("totem")) {
            return true;
        }
        return false;
    }

    @Override
    public String i_method_bf522194() {
        return "Отключение громких и раздражающих звуков (порталы, молнии, наковальни, тотемы).";
    }
}
