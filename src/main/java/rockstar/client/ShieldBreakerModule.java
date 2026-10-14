package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import pyrock.events.game.AttackEvent;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
    name = "Shield Breaker",
    category = ModuleCategory.COMBAT,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.shield_breaker"
)
public class ShieldBreakerModule extends Module {
    private final BooleanSetting autoSwitchBack = new BooleanSetting(this, "modules.settings.shield_breaker.auto_switch_back").I_method_decd82b5();
    private int originalSlot = -1;
    private int resetTimer = 0;

    private final IiIIIiII_Class69<AttackEvent> onAttack = event -> {
        if (!(event.getEntity() instanceof PlayerEntity target)) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        if (target.isBlocking()) {
            int axeSlot = this.findAxeSlot();
            if (axeSlot != -1 && axeSlot != mc.player.getInventory().selectedSlot) {
                this.originalSlot = mc.player.getInventory().selectedSlot;
                mc.player.getInventory().selectedSlot = axeSlot;
                this.resetTimer = 3;
            }
        }
    };

    private final IiIIIiII_Class69<ClientPlayerTickEvent> onTick = event -> {
        if (this.resetTimer > 0) {
            this.resetTimer--;
            if (this.resetTimer == 0 && this.autoSwitchBack.i_method_9b12da03() && this.originalSlot != -1) {
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.player != null) {
                    mc.player.getInventory().selectedSlot = this.originalSlot;
                }
                this.originalSlot = -1;
            }
        }
    };

    public ShieldBreakerModule() {
    }

    private int findAxeSlot() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return -1;
        for (int i = 0; i < 9; i++) {
            ItemStack stack = mc.player.getInventory().getStack(i);
            if (!stack.isEmpty() && stack.getItem() instanceof AxeItem) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onDisable() {
        if (this.originalSlot != -1) {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.player != null) {
                mc.player.getInventory().selectedSlot = this.originalSlot;
            }
            this.originalSlot = -1;
        }
        this.resetTimer = 0;
    }

    @Override
    public String i_method_bf522194() {
        return "Автоматический выбор топора при ударе по блокирующему щитом игроку с возвратом оружия.";
    }
}
