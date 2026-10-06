package rockstar.client;

import java.util.function.Predicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIiIiI_Class299;

public abstract class iIIiIiIii_Class300
implements iIIiIIiIi_Class294 {
    public abstract ItemStack I_method_7b7e0bb9();

    public abstract int I_method_dfe89252();

    public int i_method_dff71e32() {
        if (iIIiIiIii_Class300.I_field_3a9bda27.player == null || iIIiIiIii_Class300.I_field_3a9bda27.player.currentScreenHandler == null) {
            return 0;
        }
        return iIIiIiIii_Class300.I_field_3a9bda27.player.currentScreenHandler.syncId;
    }

    public Item I_method_158af795() {
        return this.I_method_7b7e0bb9().getItem();
    }

    public boolean I_method_dfe89263() {
        return this.I_method_7b7e0bb9().isEmpty();
    }

    public boolean I_method_7a83ae0b(Item item) {
        return this.I_method_7b7e0bb9().getItem() == item;
    }

    public boolean I_method_ed513c32(Predicate<ItemStack> predicate) {
        return predicate.test(this.I_method_7b7e0bb9());
    }

    public void I_method_afe84a7(iIIiIiIii_Class300 iIIiIiIii_Class3002) {
        iIIiIiIiI_Class299.I_method_2e11f97f(this, iIIiIiIii_Class3002);
    }

    public void I_method_dfe8925f() {
        iIIiIiIiI_Class299.I_method_50070487(this);
    }

    public void i_method_dff71e3f() {
        if (iIIiIiIii_Class300.I_field_3a9bda27.interactionManager == null) {
            return;
        }
        iIIiIiIii_Class300.I_field_3a9bda27.interactionManager.clickSlot(this.i_method_dff71e32(), this.I_method_dfe89252(), 0, SlotActionType.PICKUP, (PlayerEntity)iIIiIiIii_Class300.I_field_3a9bda27.player);
    }
}

