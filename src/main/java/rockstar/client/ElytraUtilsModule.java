package rockstar.client;

import java.util.function.Predicate;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.slot.SlotActionType;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import rockstar.client.GuiMoveModule;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.KeybindSetting;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIIii_Class68;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIiii_Class248;
import rockstar.client.IiiiiiIiI_Class251;
import rockstar.client.Iiiiiiiii_Class256;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIiIIi_Class298;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIiI_Class315;
import rockstar.client.iIiIiiIIi_Class346;
import rockstar.client.Module;
import rockstar.client.iiiIiIi_Class118;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Elytra Utils", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.elytra_utils")
public class ElytraUtilsModule
extends Module {
    private KeybindSetting I_field_ba20522c;
    private KeybindSetting i_field_ba20522c;
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private BooleanSetting II_field_ba20ca4c;
    private boolean I_field_5a;
    private Nested1_e6948c20 I_field_2fb4ce67;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        boolean bl;
        if (ElytraUtilsModule.I_field_3a9bda27.player.isGliding()) {
            this.I_field_5a = true;
        }
        GuiMoveModule iIIiIiIII_Class41 = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
        iIIiiiIiI_Class315 iIIiiiIiI_Class3152 = iIIiIiIiI_Class299.i_method_e5bad375();
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = this.I_method_9f62035d(iIIiiIiII_Class3092);
        iIIiIiIii_Class300 iIIiIiIii_Class3003 = iIIiiIiII_Class3092.I_method_5d34dd7d(Items.FIREWORK_ROCKET);
        boolean bl2 = bl = iIIiiiIiI_Class3152.I_method_158af795() == Items.ELYTRA;
        if (this.I_field_2fb4ce67 != null) {
            if (this.I_field_2fb4ce67.I_field_1242a2ac.I_method_dfe89252() >= 36 && this.I_field_2fb4ce67.I_field_1242a2ac.I_method_dfe89252() <= 44) {
                iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_2fb4ce67.i_field_1242a2ac.I_method_dfe89252(), this.I_field_2fb4ce67.I_field_1242a2ac.I_method_dfe89252() - 36);
                this.I_field_2fb4ce67 = null;
            } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
                if (this.I_field_2fb4ce67.I_field_49 == 0 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                    iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_2fb4ce67.I_field_1242a2ac.I_method_dfe89252(), 8);
                    iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_2fb4ce67.i_field_1242a2ac.I_method_dfe89252(), 8);
                    iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_2fb4ce67.I_field_1242a2ac.I_method_dfe89252(), 8);
                    ++this.I_field_2fb4ce67.I_field_49;
                } else if (this.I_field_2fb4ce67.I_field_49 == 1 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                    ++this.I_field_2fb4ce67.I_field_49;
                } else if (this.I_field_2fb4ce67.I_field_49 == 2 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                    ++this.I_field_2fb4ce67.I_field_49;
                }
            } else if (this.I_field_2fb4ce67.I_field_49 == 0 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_2fb4ce67.I_field_1242a2ac.I_method_dfe89252(), 8);
                ++this.I_field_2fb4ce67.I_field_49;
            } else if (this.I_field_2fb4ce67.I_field_49 == 1 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_2fb4ce67.i_field_1242a2ac.I_method_dfe89252(), 8);
                ++this.I_field_2fb4ce67.I_field_49;
            } else if (this.I_field_2fb4ce67.I_field_49 == 2 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_2fb4ce67.I_field_1242a2ac.I_method_dfe89252(), 8);
                ++this.I_field_2fb4ce67.I_field_49;
            }
            if (this.I_field_2fb4ce67 != null && this.I_field_2fb4ce67.I_field_49 >= 3) {
                this.I_field_2fb4ce67 = null;
            }
        }
        if (bl) {
            if (this.I_field_ba20ca4c.i_method_9b12da03() && ElytraUtilsModule.I_field_3a9bda27.player.isOnGround() && !ElytraUtilsModule.I_field_3a9bda27.options.jumpKey.isPressed()) {
                ElytraUtilsModule.I_field_3a9bda27.player.jump();
            }
            if (this.I_field_ba20ca4c.i_method_9b12da03() && !ElytraUtilsModule.I_field_3a9bda27.player.isInFluid() && ElytraUtilsModule.I_field_3a9bda27.player.isSprinting() && ElytraUtilsModule.I_field_3a9bda27.player.input.hasForwardMovement() && ElytraUtilsModule.I_field_3a9bda27.player.checkGliding()) {
                I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new ClientCommandC2SPacket((Entity)ElytraUtilsModule.I_field_3a9bda27.player, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
                if (this.i_field_ba20ca4c.i_method_9b12da03() && iIIiIiIii_Class3003 != null) {
                    IiIIIIii_Class68.I_field_108dc26c.I_method_ee61a647(Items.FIREWORK_ROCKET);
                }
            }
        }
        if (this.II_field_ba20ca4c.i_method_9b12da03() && ElytraUtilsModule.I_field_3a9bda27.player.isOnGround() && bl && this.I_field_5a && ElytraUtilsModule.I_field_3a9bda27.player.getGlidingTicks() > 18) {
            if (iIIiIiIii_Class3002 != null) {
                this.Iii_method_49f452bf();
            } else {
                ElytraUtilsModule.I_field_3a9bda27.interactionManager.clickSlot(0, 6, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)ElytraUtilsModule.I_field_3a9bda27.player);
            }
            this.I_field_5a = false;
        }
    };
    private final IiIIIiII_Class69<KeyPressEvent> i_field_3d936f41 = keyPressEvent -> {
        if (this.I_field_ba20522c.I_method_51ee2d08(keyPressEvent.getKey()) && keyPressEvent.getAction() == 1 && ElytraUtilsModule.I_field_3a9bda27.currentScreen == null) {
            this.Iii_method_49f452bf();
        }
        if (this.i_field_ba20522c.I_method_51ee2d08(keyPressEvent.getKey()) && keyPressEvent.getAction() == 1 && ElytraUtilsModule.I_field_3a9bda27.currentScreen == null && ElytraUtilsModule.I_field_3a9bda27.player.isGliding()) {
            if (this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)) {
                IiIIIIii_Class68.I_field_108dc26c.I_method_ee61a647(Items.FIREWORK_ROCKET);
            } else {
                IiiiiiIiI_Class251.I_method_eda5cd21(this.I_method_b9788dc6(Items.FIREWORK_ROCKET, itemStack -> true));
            }
        }
    };
    private final IiIIIiII_Class69<MouseEvent> II_field_3d936f41 = mouseEvent -> {
        if (this.I_field_ba20522c.I_method_51ee2d08(mouseEvent.getButton()) && mouseEvent.getAction() == 1 && ElytraUtilsModule.I_field_3a9bda27.currentScreen == null) {
            this.Iii_method_49f452bf();
        }
        if (this.i_field_ba20522c.I_method_51ee2d08(mouseEvent.getButton()) && mouseEvent.getAction() == 1 && ElytraUtilsModule.I_field_3a9bda27.currentScreen == null && ElytraUtilsModule.I_field_3a9bda27.player.isGliding()) {
            if (this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)) {
                IiIIIIii_Class68.I_field_108dc26c.I_method_ee61a647(Items.FIREWORK_ROCKET);
            } else {
                IiiiiiIiI_Class251.I_method_eda5cd21(this.I_method_b9788dc6(Items.FIREWORK_ROCKET, itemStack -> true));
            }
        }
    };

    public ElytraUtilsModule() {
        this.IiI_method_49e5c6df();
    }

    @Compile(obfuscation=4)
    private void IiI_method_49e5c6df() {
        this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.elytra_utils.swapKey");
        this.i_field_ba20522c = new KeybindSetting(this, "modules.settings.elytra_utils.fireworkKey");
        this.I_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.firework_swap_mode", () -> this.i_field_ba20522c.I_method_fa6281d2() == -1);
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.elytra_utils.firework_swap_mode.default");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.elytra_utils.firework_swap_mode.packet");
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.elytra_utils.auto_takeoff");
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.elytra_utils.auto_use", () -> !this.I_field_ba20ca4c.i_method_9b12da03()).I_method_decd82b5();
        this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.elytra_utils.chest_on_ground");
    }

    private iIIiIiIii_Class300 I_method_9f62035d(iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092) {
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = null;
        int n = Integer.MIN_VALUE;
        for (iIIiIiIii_Class300 iIIiIiIii_Class3003 : iIIiiIiII_Class3092.I_method_617d3e68()) {
            int n2;
            ArmorItem armorItem;
            Item item;
            ItemStack itemStack = iIIiIiIii_Class3003.I_method_7b7e0bb9();
            if (itemStack.isEmpty() || !((item = itemStack.getItem()) instanceof ArmorItem) || ((iIiIiiIIi_Class346)(armorItem = (ArmorItem)item)).rockstar$getType() != EquipmentType.CHESTPLATE || (n2 = this.I_method_c584cef9(armorItem, itemStack)) <= n) continue;
            n = n2;
            iIIiIiIii_Class3002 = iIIiIiIii_Class3003;
        }
        return iIIiIiIii_Class3002;
    }

    private int I_method_c584cef9(ArmorItem armorItem, ItemStack itemStack) {
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(itemStack);
        if (nested1_95187080 != null && "SunHelmet".equals(nested1_95187080.I_method_3665aca6())) {
            return Integer.MAX_VALUE;
        }
        ArmorMaterial armorMaterial = ((iIiIiiIIi_Class346)armorItem).rockstar$getMaterial();
        EquipmentType equipmentType = ((iIiIiiIIi_Class346)armorItem).rockstar$getType();
        int n = armorMaterial.defense().getOrDefault(equipmentType, 0);
        int n2 = (int)armorMaterial.toughness();
        int n3 = iIIiIiIIi_Class298.I_method_7ea237bf(itemStack, (RegistryKey<Enchantment>)Enchantments.PROTECTION);
        return n * 5 + n3 * 3 + n2;
    }

    private void Iii_method_49f452bf() {
        boolean bl;
        iIIiiiIiI_Class315 iIIiiiIiI_Class3152 = iIIiIiIiI_Class299.i_method_e5bad375();
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_77fa4424(itemStack -> itemStack.getItem() == Items.ELYTRA && !itemStack.willBreakNextUse());
        iIIiIiIii_Class300 iIIiIiIii_Class3003 = this.I_method_9f62035d(iIIiiIiII_Class3092);
        boolean bl2 = bl = iIIiiiIiI_Class3152.I_method_158af795() == Items.ELYTRA;
        if (this.I_field_2fb4ce67 != null) {
            return;
        }
        if (!bl && iIIiIiIii_Class3002 != null) {
            this.I_field_2fb4ce67 = new Nested1_e6948c20(iIIiIiIii_Class3002, iIIiiiIiI_Class3152);
            String string = Iiiiiiiii_Class256.i_method_524c3f7f(iIIiIiIii_Class3002.I_method_7b7e0bb9());
            RockstarClient.getInstance().I_method_5cb1af22().I_method_67864747(new iiiIiIi_Class118(IiIiIIII_Class81.I_method_1410d1e5("alerts.equipped", string), iIIiIiIii_Class3002.I_method_7b7e0bb9()).I_method_7ab92a7f(string));
        } else if (iIIiIiIii_Class3003 != null) {
            this.I_field_2fb4ce67 = new Nested1_e6948c20(iIIiIiIii_Class3003, iIIiiiIiI_Class3152);
            String string = Iiiiiiiii_Class256.i_method_524c3f7f(iIIiIiIii_Class3003.I_method_7b7e0bb9());
            RockstarClient.getInstance().I_method_5cb1af22().I_method_67864747(new iiiIiIi_Class118(IiIiIIII_Class81.I_method_1410d1e5("alerts.equipped", string), iIIiIiIii_Class3003.I_method_7b7e0bb9()).I_method_7ab92a7f(string));
        }
    }

    public float I_method_b9788dc6(Item item, Predicate<ItemStack> predicate) {
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        Predicate<ItemStack> predicate2 = itemStack -> itemStack != null && !itemStack.isEmpty() && itemStack.getItem() == item && predicate.test(itemStack);
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_77fa4424(stack -> this.I_method_80c9067e(predicate2, item, stack));
        if (iIIiIiIii_Class3002 == null) {
            iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_77fa4424(predicate2);
        }
        if (iIIiIiIii_Class3002 == null) {
            return iIIiIiIiI_Class299.I_method_d0256375().II_method_b9cf08f5() + 1;
        }
        int n = iIIiIiIii_Class3002.I_method_dfe89252();
        if (n >= 36 && n <= 44) {
            return n - 35;
        }
        return iIIiIiIiI_Class299.I_method_d0256375().II_method_b9cf08f5() + 1;
    }

    private boolean I_method_5bb6fb29(ItemStack itemStack, Item item) {
        if (itemStack == null || itemStack.isEmpty()) {
            return false;
        }
        if (itemStack.getItem() != item) {
            return false;
        }
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(itemStack);
        return nested1_95187080 != null && nested1_95187080.ii_method_e498f76b();
    }

    @Override
    public void onDisable() {
        this.I_field_5a = false;
    }

    @Override
    public void onEnable() {
        this.I_field_5a = false;
    }

    private /* synthetic */ boolean I_method_80c9067e(Predicate predicate, Item item, ItemStack itemStack) {
        return predicate.test(itemStack) && this.I_method_5bb6fb29(itemStack, item);
    }

    static class Nested1_e6948c20 {
        int I_field_49;
        final iIIiIiIii_Class300 I_field_1242a2ac;
        final iIIiIiIii_Class300 i_field_1242a2ac;

        Nested1_e6948c20(iIIiIiIii_Class300 iIIiIiIii_Class3002, iIIiIiIii_Class300 iIIiIiIii_Class3003) {
            this.I_field_1242a2ac = iIIiIiIii_Class3002;
            this.i_field_1242a2ac = iIIiIiIii_Class3003;
        }
    }
}
