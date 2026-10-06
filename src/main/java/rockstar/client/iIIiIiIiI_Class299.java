package rockstar.client;

import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import org.jetbrains.annotations.NotNull;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiii_Class312;
import rockstar.client.iIIiiiIiI_Class315;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.iIIiiiiII_Class317;
import rockstar.client.iIIiiiiIi_Class318;

public final class iIIiIiIiI_Class299
implements iIIiIIiIi_Class294 {
    public static iIIiiiIii_Class316 I_method_6602651a(int n) {
        return new iIIiiiIii_Class316(n);
    }

    public static iIIiiiiII_Class317 I_method_661074fa(int n) {
        return new iIIiiiiII_Class317(n);
    }

    public static iIIiiiIiI_Class315 I_method_6602613a(int n) {
        return new iIIiiiIiI_Class315(n);
    }

    public static iIIiiiIiI_Class315 I_method_d0255f95() {
        return iIIiIiIiI_Class299.I_method_6602613a(3);
    }

    public static iIIiiiIiI_Class315 i_method_e5bad375() {
        return iIIiIiIiI_Class299.I_method_6602613a(2);
    }

    public static iIIiiiIiI_Class315 II_method_28f80c18() {
        return iIIiIiIiI_Class299.I_method_6602613a(1);
    }

    public static iIIiiiIiI_Class315 Ii_method_3e8d7ff8() {
        return iIIiIiIiI_Class299.I_method_6602613a(0);
    }

    public static iIIiiiiIi_Class318 I_method_d0337735() {
        return new iIIiiiiIi_Class318();
    }

    public static boolean I_method_dd6aa5eb(Item item) {
        return iIIiIiIiI_Class299.I_method_d0337735().I_method_7a83ae0b(item);
    }

    public static boolean I_method_656a3052(Predicate<ItemStack> predicate) {
        return iIIiIiIiI_Class299.I_method_d0337735().I_method_ed513c32(predicate);
    }

    public static boolean I_method_a94d7e83() {
        return iIIiIiIiI_Class299.I_method_d0337735().I_method_dfe89263();
    }

    public static void I_method_2e11f97f(iIIiIiIii_Class300 iIIiIiIii_Class3002, iIIiIiIii_Class300 iIIiIiIii_Class3003) {
        if (I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        iIIiIiIii_Class3002.i_method_dff71e3f();
        iIIiIiIii_Class3003.i_method_dff71e3f();
        if (!iIIiIiIii_Class3003.I_method_dfe89263()) {
            iIIiIiIii_Class3002.i_method_dff71e3f();
        }
        I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new CloseHandledScreenC2SPacket(0));
    }

    public static void I_method_8062c464(int n) {
        if (I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
    }

    public static void I_method_8bf63b1f(int n, int n2) {
        iIIiIiIiI_Class299.I_method_f2d1db95(n, n2, false);
    }

    public static void I_method_f2d1db95(int n, int n2, boolean bl) {
        if (I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n, 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n2, 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
        if (bl) {
            iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n, 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
        }
    }

    public static void i_method_c2914eff(int n, int n2) {
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.playerScreenHandler.syncId, iIIiIiIiI_Class299.I_method_8062c457(n), 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.playerScreenHandler.syncId, iIIiIiIiI_Class299.I_method_8062c457(n2), 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.playerScreenHandler.syncId, iIIiIiIiI_Class299.I_method_8062c457(n), 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
    }

    public static void II_method_295080a2(int n, int n2) {
        if (I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n, 1, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n2, 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
    }

    public static void Ii_method_5feb9482(int n, int n2) {
        if (I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n, 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n2, 1, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n, 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
    }

    public static void iI_method_c617e8c2(int n, int n2) {
        if (I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        iIIiIiIiI_Class299.I_field_3a9bda27.interactionManager.clickSlot(iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.syncId, n, n2, SlotActionType.SWAP, (PlayerEntity)iIIiIiIiI_Class299.I_field_3a9bda27.player);
    }

    public static boolean I_method_b0d9ff60(iIIiIiIii_Class300 iIIiIiIii_Class3002, int n) {
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiIiIiI_Class299.I_method_6602651a(n);
        iIIiIiIiI_Class299.I_method_2e11f97f(iIIiIiIii_Class3002, iIIiiiIii_Class3162);
        return true;
    }

    public static boolean i_method_b6e1fb40(iIIiIiIii_Class300 iIIiIiIii_Class3002, int n) {
        iIIiiiIiI_Class315 iIIiiiIiI_Class3152 = iIIiIiIiI_Class299.I_method_6602613a(n);
        iIIiIiIiI_Class299.I_method_2e11f97f(iIIiIiIii_Class3002, iIIiiiIiI_Class3152);
        return true;
    }

    public static void I_method_50070487(iIIiIiIii_Class300 iIIiIiIii_Class3002) {
        iIIiiiiIi_Class318 iIIiiiiIi_Class3182 = iIIiIiIiI_Class299.I_method_d0337735();
        iIIiIiIiI_Class299.I_method_2e11f97f(iIIiIiIii_Class3002, iIIiiiiIi_Class3182);
    }

    @NotNull
    public static iIIiiiIii_Class316 I_method_d0256375() {
        if (iIIiIiIiI_Class299.I_field_3a9bda27.player == null || iIIiIiIiI_Class299.I_field_3a9bda27.player.getInventory() == null) {
            return new iIIiiiIii_Class316(0);
        }
        return iIIiIiIiI_Class299.I_method_6602651a(iIIiIiIiI_Class299.I_field_3a9bda27.player.getInventory().selectedSlot);
    }

    public static void i_method_8225b484(int n) {
        if (iIIiIiIiI_Class299.I_field_3a9bda27.player == null || iIIiIiIiI_Class299.I_field_3a9bda27.player.getInventory() == null || I_field_3a9bda27.getNetworkHandler() == null || iIIiIiIiI_Class299.I_method_d0256375().II_method_b9cf08f5() == n) {
            return;
        }
        if (n < 0 || n > 8) {
            throw new IllegalArgumentException("Hotbar slot ID must be between 0 and 8");
        }
        iIIiIiIiI_Class299.I_field_3a9bda27.player.getInventory().selectedSlot = n;
    }

    public static void II_method_8db84281(int n) {
        if (iIIiIiIiI_Class299.I_field_3a9bda27.player == null || iIIiIiIiI_Class299.I_field_3a9bda27.player.getInventory() == null || I_field_3a9bda27.getNetworkHandler() == null || iIIiIiIiI_Class299.I_method_d0256375().II_method_b9cf08f5() == n) {
            return;
        }
        if (n < 0 || n > 8) {
            throw new IllegalArgumentException("Hotbar slot ID must be between 0 and 8");
        }
        I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(iIIiIiIiI_Class299.I_field_3a9bda27.player.getInventory().selectedSlot));
    }

    public static void I_method_4c2ca067(iIIiiiIii_Class316 iIIiiiIii_Class3162) {
        iIIiIiIiI_Class299.i_method_8225b484(iIIiiiIii_Class3162.II_method_b9cf08f5());
    }

    public static boolean i_method_767360b(Item item) {
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = (iIIiiiIii_Class316)new iIIiiIiii_Class312().I_method_5d34dd7d(item);
        if (iIIiiiIii_Class3162 != null) {
            iIIiIiIiI_Class299.I_method_4c2ca067(iIIiiiIii_Class3162);
            return true;
        }
        return false;
    }

    public static int I_method_656a3041(Predicate<ItemStack> predicate) {
        if (iIIiIiIiI_Class299.I_field_3a9bda27.player == null || iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler == null) {
            return -1;
        }
        for (int i = 0; i < iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.slots.size(); ++i) {
            ItemStack itemStack = iIIiIiIiI_Class299.I_field_3a9bda27.player.currentScreenHandler.getSlot(i).getStack();
            if (!predicate.test(itemStack)) continue;
            return i;
        }
        return -1;
    }

    public static int I_method_dd6aa5da(Item item) {
        return iIIiIiIiI_Class299.I_method_656a3041(itemStack -> itemStack.getItem() == item);
    }

    private static int I_method_8062c457(int n) {
        if (n >= 0 && n <= 8) {
            return 36 + n;
        }
        return n;
    }

    @Generated
    private iIIiIiIiI_Class299() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

