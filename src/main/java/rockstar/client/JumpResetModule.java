package rockstar.client;

import net.minecraft.client.MinecraftClient;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "Jump Reset",
    category = ModuleCategory.COMBAT,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.jumpreset"
)
public class JumpResetModule extends Module {
    private final BooleanSetting useChance = new BooleanSetting(this, "modules.settings.use_chance").I_method_decd82b5();
    private final SliderSetting chance = new SliderSetting(this, "modules.settings.chance")
        .I_method_c8c9a7d7(10.0F)
        .i_method_65e2aff7(100.0F)
        .II_method_b0f56334(5.0F)
        .Ii_method_4e0e6b54(100.0F);

    private int lastHurtTime = 0;
    private boolean jumpHeld = false;

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        if (this.jumpHeld) {
            this.jumpHeld = false;
            mc.options.jumpKey.setPressed(false);
        }

        int currentHurt = mc.player.hurtTime;
        if (currentHurt > this.lastHurtTime && currentHurt > 0) {
            if (mc.player.isOnGround() && !mc.player.isRiding() && !mc.player.isSubmergedInWater()) {
                if (!this.useChance.i_method_9b12da03() || Math.random() * 100.0 <= this.chance.Ii_method_a20abcd2()) {
                    mc.options.jumpKey.setPressed(true);
                    this.jumpHeld = true;
                }
            }
        }
        this.lastHurtTime = currentHurt;
    };

    public JumpResetModule() {
    }

    @Override
    public void onDisable() {
        if (this.jumpHeld) {
            this.jumpHeld = false;
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.options != null) {
                mc.options.jumpKey.setPressed(false);
            }
        }
        this.lastHurtTime = 0;
    }

    @Override
    public String i_method_bf522194() {
        return "Автоматический прыжок в момент получения урона для значительного снижения отдачи.";
    }
}
