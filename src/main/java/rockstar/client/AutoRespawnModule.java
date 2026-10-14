package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "Auto Respawn",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.autorespawn"
)
public class AutoRespawnModule extends Module {
    private final SliderSetting delayMs = new SliderSetting(this, "modules.settings.delay_ms")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(1000.0F)
        .II_method_b0f56334(50.0F)
        .Ii_method_4e0e6b54(50.0F);

    private long deathTime = 0L;

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        if (mc.currentScreen instanceof DeathScreen || mc.player.isDead() || mc.player.getHealth() <= 0.0F) {
            long now = System.currentTimeMillis();
            if (this.deathTime == 0L) {
                this.deathTime = now;
            }
            if (now - this.deathTime >= (long) this.delayMs.Ii_method_a20abcd2()) {
                mc.player.requestRespawn();
                if (mc.currentScreen instanceof DeathScreen) {
                    mc.setScreen(null);
                }
                this.deathTime = 0L;
            }
        } else {
            this.deathTime = 0L;
        }
    };

    public AutoRespawnModule() {
    }

    @Override
    public String i_method_bf522194() {
        return "Автоматически и моментально возрождает персонажа после смерти.";
    }
}
