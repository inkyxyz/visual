package rockstar.client;

import net.minecraft.client.MinecraftClient;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "Tape Mouse",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.tape_mouse"
)
public class TapeMouseModule extends Module {
    private final ModeSetting mouseMode = new ModeSetting(this, "modules.settings.tape_mouse.mode");
    private final ModeSetting.Nested1_42765c60 attackMode = new ModeSetting.Nested1_42765c60(this.mouseMode, "Attack").select();
    private final ModeSetting.Nested1_42765c60 useMode = new ModeSetting.Nested1_42765c60(this.mouseMode, "Use");
    private final BooleanSetting pauseInScreen = new BooleanSetting(this, "modules.settings.tape_mouse.pause_in_screen").I_method_decd82b5();
    private final SliderSetting clickDelay = new SliderSetting(this, "modules.settings.tape_mouse.delay")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(10.0F)
        .II_method_b0f56334(1.0F)
        .Ii_method_4e0e6b54(0.0F);

    private int delayTicks = 0;

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        if (this.pauseInScreen.i_method_9b12da03() && mc.currentScreen != null) return;

        if (this.delayTicks > 0) {
            this.delayTicks--;
            return;
        }

        this.delayTicks = (int) this.clickDelay.Ii_method_a20abcd2();
        if (this.attackMode.isSelected()) {
            mc.options.attackKey.setPressed(true);
        } else {
            mc.options.useKey.setPressed(true);
        }
    };

    public TapeMouseModule() {
    }

    @Override
    public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.options != null) {
            mc.options.attackKey.setPressed(false);
            mc.options.useKey.setPressed(false);
        }
        this.delayTicks = 0;
    }

    @Override
    public String i_method_bf522194() {
        return "Автоматическое зажатие левой или правой кнопки мыши для АФК-копания или фарма.";
    }
}
