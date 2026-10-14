package rockstar.client;

import net.minecraft.client.MinecraftClient;
import pyrock.events.game.PostAttackEvent;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "Auto Shift Tap",
    category = ModuleCategory.COMBAT,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.autoshifttap"
)
public class AutoShiftTapModule extends Module {
    private final BooleanSetting onlyGround = new BooleanSetting(this, "modules.settings.only_ground").I_method_decd82b5();
    private final SliderSetting durationTicks = new SliderSetting(this, "modules.settings.duration_ticks")
        .I_method_c8c9a7d7(1.0F)
        .i_method_65e2aff7(4.0F)
        .II_method_b0f56334(1.0F)
        .Ii_method_4e0e6b54(2.0F);

    private int shiftTicks = 0;
    private boolean forcedShift = false;

    private final IiIIIiII_Class69<PostAttackEvent> onPostAttack = event -> {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        if (this.onlyGround.i_method_9b12da03() && !mc.player.isOnGround()) return;

        this.shiftTicks = (int) this.durationTicks.Ii_method_a20abcd2();
        mc.options.sneakKey.setPressed(true);
        this.forcedShift = true;
    };

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        if (this.shiftTicks > 0) {
            this.shiftTicks--;
            if (this.shiftTicks == 0 && this.forcedShift) {
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.options != null) {
                    mc.options.sneakKey.setPressed(false);
                }
                this.forcedShift = false;
            }
        }
    };

    public AutoShiftTapModule() {
    }

    @Override
    public void onDisable() {
        if (this.forcedShift) {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.options != null) {
                mc.options.sneakKey.setPressed(false);
            }
            this.forcedShift = false;
        }
        this.shiftTicks = 0;
    }

    @Override
    public String i_method_bf522194() {
        return "Автоматический микро-присед (Shift) при ударе для резкого сброса отдачи и комбо.";
    }
}
