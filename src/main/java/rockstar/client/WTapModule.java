package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import pyrock.events.game.PostAttackEvent;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "W-Tap",
    category = ModuleCategory.COMBAT,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.wtap"
)
public class WTapModule extends Module {
    private final BooleanSetting onlyGround = new BooleanSetting(this, "modules.settings.only_ground").I_method_decd82b5();
    private final SliderSetting resetTicks = new SliderSetting(this, "modules.settings.reset_ticks")
        .I_method_c8c9a7d7(1.0F)
        .i_method_65e2aff7(3.0F)
        .II_method_b0f56334(1.0F)
        .Ii_method_4e0e6b54(1.0F);

    private int ticksLeft = 0;
    private boolean forwardReleased = false;

    private final IiIIIiII_Class69<PostAttackEvent> onPostAttack = event -> {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        if (this.onlyGround.i_method_9b12da03() && !mc.player.isOnGround()) return;

        this.ticksLeft = (int) this.resetTicks.Ii_method_a20abcd2();
        mc.options.forwardKey.setPressed(false);
        this.forwardReleased = true;
    };

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        if (this.ticksLeft > 0) {
            this.ticksLeft--;
            if (this.ticksLeft == 0 && this.forwardReleased) {
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.options != null && mc.getWindow() != null) {
                    boolean isPhysicalDown = InputUtil.isKeyPressed(mc.getWindow().getHandle(), mc.options.forwardKey.getDefaultKey().getCode());
                    mc.options.forwardKey.setPressed(isPhysicalDown);
                }
                this.forwardReleased = false;
            }
        }
    };

    public WTapModule() {
    }

    @Override
    public void onDisable() {
        if (this.forwardReleased) {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.options != null && mc.getWindow() != null) {
                boolean isPhysicalDown = InputUtil.isKeyPressed(mc.getWindow().getHandle(), mc.options.forwardKey.getDefaultKey().getCode());
                mc.options.forwardKey.setPressed(isPhysicalDown);
            }
            this.forwardReleased = false;
        }
        this.ticksLeft = 0;
    }

    @Override
    public String i_method_bf522194() {
        return "Сброс спринта клавишей W при ударе для нанесения максимального откидывания.";
    }
}
