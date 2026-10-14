package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "No Web",
    category = ModuleCategory.MOVEMENT,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.noweb"
)
public class NoWebModule extends Module {
    private final SliderSetting horizontalSpeed = new SliderSetting(this, "modules.settings.horizontal_speed")
        .I_method_c8c9a7d7(1.0F)
        .i_method_65e2aff7(5.0F)
        .II_method_b0f56334(0.2F)
        .Ii_method_4e0e6b54(2.5F);

    private final SliderSetting verticalSpeed = new SliderSetting(this, "modules.settings.vertical_speed")
        .I_method_c8c9a7d7(1.0F)
        .i_method_65e2aff7(5.0F)
        .II_method_b0f56334(0.2F)
        .Ii_method_4e0e6b54(2.0F);

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        // When inside cobweb or slow block
        // Minecraft checks inBlock
        Vec3d vel = mc.player.getVelocity();
        if (mc.player.horizontalCollision || Math.abs(vel.y) < 0.05) {
            // Boost if slowed by web
        }
    };

    public NoWebModule() {
    }

    public float getHMultiplier() {
        return this.horizontalSpeed.Ii_method_a20abcd2();
    }

    public float getVMultiplier() {
        return this.verticalSpeed.Ii_method_a20abcd2();
    }

    @Override
    public String i_method_bf522194() {
        return "Устраняет замедление при прохождении через паутину.";
    }
}
