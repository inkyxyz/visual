package rockstar.client;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IiiiiiIII_Class249;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIIIi_Class306;
import rockstar.client.iIIiiIIiI_Class307;
import rockstar.client.iIIiiIIii_Class308;

public class iIIiIiiii_Class304
implements iIIiIIiIi_Class294 {
    private static final int I_field_49 = 5;
    private final iIIiiIIIi_Class306 I_field_471a4e4c;
    private final iIIiiIIii_Class308 I_field_471ac66c;
    private iIIiiIIiI_Class307 I_field_471ac28c = iIIiiIIiI_Class307.I_field_471ac28c;
    private ItemStack I_field_f2735522 = ItemStack.EMPTY;
    private int i_field_49 = -1;
    private int II_field_49 = 0;
    private boolean I_field_5a = true;
    @Nullable
    private Nested1_b9c67040 I_field_c2bf6e47;
    private boolean i_field_5a;

    public void I_method_b55a1222(@Nullable Nested1_b9c67040 nested1_b9c67040) {
        this.I_field_c2bf6e47 = nested1_b9c67040;
    }

    public iIIiIiiii_Class304(iIIiiIIIi_Class306 iIIiiIIIi_Class3062, iIIiiIIii_Class308 iIIiiIIii_Class3082) {
        this.I_field_471a4e4c = Objects.requireNonNull(iIIiiIIIi_Class3062);
        this.I_field_471ac66c = Objects.requireNonNull(iIIiiIIii_Class3082);
    }

    public iIIiIiiii_Class304 I_method_83d381eb(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    public int I_method_357b2e1a(Item item) {
        return this.I_field_471a4e4c.I_method_986225fa(item);
    }

    public boolean I_method_dc0e2e43() {
        return this.I_field_471ac28c == iIIiiIIiI_Class307.i_field_471ac28c;
    }

    public void I_method_dc0e2e3f() {
        this.I_field_471ac28c = iIIiiIIiI_Class307.I_field_471ac28c;
        this.I_field_f2735522 = ItemStack.EMPTY;
        this.i_field_49 = -1;
        this.II_field_49 = 0;
        this.i_field_5a = false;
    }

    public void I_method_2fdedaee(Item item, boolean bl, Predicate<ItemStack> predicate, BooleanSupplier booleanSupplier) {
        boolean bl2;
        if (iIIiIiiii_Class304.I_field_3a9bda27.player == null || iIIiIiiii_Class304.I_field_3a9bda27.world == null || item == null) {
            return;
        }
        ItemStack itemStack = iIIiIiiii_Class304.I_field_3a9bda27.player.getOffHandStack();
        boolean bl3 = bl2 = itemStack.getItem() == item;
        if (bl) {
            if (!booleanSupplier.getAsBoolean()) {
                return;
            }
            this.I_method_ebb0bfe(item, bl2, itemStack, predicate);
            return;
        }
        if (this.I_field_471ac28c == iIIiiIIiI_Class307.I_field_471ac28c) {
            return;
        }
        if (!booleanSupplier.getAsBoolean()) {
            return;
        }
        this.I_method_15d80f61(itemStack);
    }

    private void I_method_ebb0bfe(Item item, boolean bl, ItemStack itemStack, Predicate<ItemStack> predicate) {
        if (bl && item == Items.TOTEM_OF_UNDYING) {
            int n = IiiiiiIII_Class249.I_method_9a86b74(itemStack);
            iIIiIiIii_Class300 iIIiIiIii_Class3002 = this.I_field_471a4e4c.i_method_9727c53d(item);
            if (iIIiIiIii_Class3002 == null) {
                this.I_field_471ac28c = iIIiiIIiI_Class307.i_field_471ac28c;
                return;
            }
            int n2 = IiiiiiIII_Class249.I_method_9a86b74(iIIiIiIii_Class3002.I_method_7b7e0bb9());
            if (n2 >= n) {
                this.I_field_471ac28c = iIIiiIIiI_Class307.i_field_471ac28c;
                return;
            }
            if (this.I_field_f2735522.isEmpty()) {
                this.I_field_f2735522 = itemStack.copy();
            }
            this.i_field_49 = -1;
            this.i_method_dc1cba1f();
            if (this.I_field_471ac66c.i_method_363aed0b(iIIiIiIii_Class3002)) {
                this.I_field_471ac28c = iIIiiIIiI_Class307.i_field_471ac28c;
                if (this.I_field_c2bf6e47 != null && iIIiIiiii_Class304.I_field_3a9bda27.player != null && item == Items.TOTEM_OF_UNDYING) {
                    this.I_field_c2bf6e47.I_method_13581b86(iIIiIiiii_Class304.I_field_3a9bda27.player.getHealth() + iIIiIiiii_Class304.I_field_3a9bda27.player.getAbsorptionAmount());
                }
            }
            return;
        }
        if (bl) {
            this.I_field_471ac28c = iIIiiIIiI_Class307.i_field_471ac28c;
            return;
        }
        if (!predicate.test(itemStack)) {
            return;
        }
        iIIiIiIii_Class300 iIIiIiIii_Class3003 = this.I_field_471a4e4c.i_method_9727c53d(item);
        if (iIIiIiIii_Class3003 == null) {
            return;
        }
        this.i_method_b9d09341(itemStack);
        this.i_field_49 = iIIiIiIii_Class3003.I_method_dfe89252();
        this.i_method_dc1cba1f();
        if (this.I_field_471ac66c.i_method_363aed0b(iIIiIiIii_Class3003)) {
            this.I_field_471ac28c = iIIiiIIiI_Class307.i_field_471ac28c;
            if (this.I_field_c2bf6e47 != null && iIIiIiiii_Class304.I_field_3a9bda27.player != null && item == Items.TOTEM_OF_UNDYING) {
                this.I_field_c2bf6e47.I_method_13581b86(iIIiIiiii_Class304.I_field_3a9bda27.player.getHealth() + iIIiIiiii_Class304.I_field_3a9bda27.player.getAbsorptionAmount());
            }
        }
    }

    private void I_method_15d80f61(ItemStack itemStack) {
        int n;
        int n2;
        if (this.I_field_f2735522.isEmpty()) {
            iIIiIiIii_Class300 iIIiIiIii_Class3002 = this.I_field_471a4e4c.I_method_6c9d1d1d(Items.TOTEM_OF_UNDYING);
            if (iIIiIiIii_Class3002 != null && itemStack.getItem() == Items.TOTEM_OF_UNDYING) {
                int n3 = IiiiiiIII_Class249.I_method_9a86b74(itemStack);
                int n4 = IiiiiiIII_Class249.I_method_9a86b74(iIIiIiIii_Class3002.I_method_7b7e0bb9());
                if (n4 > n3) {
                    this.i_method_dc1cba1f();
                    this.I_field_471ac66c.i_method_363aed0b(iIIiIiIii_Class3002);
                }
            }
            this.I_method_dc0e2e3f();
            return;
        }
        if (ItemStack.areEqual((ItemStack)itemStack, (ItemStack)this.I_field_f2735522)) {
            this.I_method_dc0e2e3f();
            return;
        }
        if (itemStack.getItem() == Items.TOTEM_OF_UNDYING && this.I_field_f2735522.getItem() == Items.TOTEM_OF_UNDYING && (n2 = IiiiiiIII_Class249.I_method_9a86b74(itemStack)) >= (n = IiiiiiIII_Class249.I_method_9a86b74(this.I_field_f2735522))) {
            this.I_method_dc0e2e3f();
            return;
        }
        if (this.I_field_471ac28c != iIIiiIIiI_Class307.II_field_471ac28c) {
            this.I_field_471ac28c = iIIiiIIiI_Class307.II_field_471ac28c;
            this.II_field_49 = 5;
            this.i_field_5a = false;
        }
        if (this.II_field_49-- <= 0) {
            this.I_method_dc0e2e3f();
            return;
        }
        iIIiIiIii_Class300 iIIiIiIii_Class3003 = this.I_method_438acf55();
        if (iIIiIiIii_Class3003 == null) {
            this.I_method_dc0e2e3f();
            return;
        }
        this.i_method_dc1cba1f();
        if (this.I_field_471ac66c.i_method_363aed0b(iIIiIiIii_Class3003) && this.I_field_c2bf6e47 != null && !this.i_field_5a && !this.I_field_f2735522.isEmpty()) {
            this.I_field_c2bf6e47.I_method_ae9b035c(this.I_field_f2735522);
            this.i_field_5a = true;
        }
    }

    private void i_method_b9d09341(ItemStack itemStack) {
        if (this.I_field_f2735522.isEmpty()) {
            this.I_field_f2735522 = itemStack.copy();
        }
    }

    private void i_method_dc1cba1f() {
        if (this.I_field_5a && iIIiIiiii_Class304.I_field_3a9bda27.player.isUsingItem()) {
            iIIiIiiii_Class304.I_field_3a9bda27.player.stopUsingItem();
        }
    }

    @Nullable
    private iIIiIiIii_Class300 I_method_438acf55() {
        iIIiIiIii_Class300 iIIiIiIii_Class3002;
        if (this.i_field_49 != -1 && (iIIiIiIii_Class3002 = this.I_field_471a4e4c.I_method_a7f495a(this.i_field_49)) != null) {
            if (ItemStack.areEqual((ItemStack)iIIiIiIii_Class3002.I_method_7b7e0bb9(), (ItemStack)this.I_field_f2735522)) {
                return iIIiIiIii_Class3002;
            }
            this.i_field_49 = -1;
        }
        return this.I_field_471a4e4c.I_method_b8c3b617(this.I_field_f2735522);
    }

    public static interface Nested1_b9c67040 {
        public void I_method_13581b86(float var1);

        public void I_method_ae9b035c(ItemStack var1);
    }
}

