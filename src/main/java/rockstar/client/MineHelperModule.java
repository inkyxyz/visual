package rockstar.client;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.util.Hand;
import pyrock.events.game.StartBreakBlockEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.window.KeyPressEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.KeybindSetting;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.iiiIIII_Class113;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Mine Helper", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.mine_helper")
public class MineHelperModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    public SliderSetting I_field_73178e8c;
    private BooleanSetting i_field_ba20ca4c;
    private BooleanSetting II_field_ba20ca4c;
    private KeybindSetting I_field_ba20522c;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private boolean I_field_5a;
    private boolean i_field_5a = false;
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = keyPressEvent -> {
        if (this.I_field_ba20522c.I_method_51ee2d08(keyPressEvent.getKey()) && keyPressEvent.getAction() == 1) {
            this.I_field_5a = true;
        }
    };
    private final IiIIIiII_Class69<StartBreakBlockEvent> i_field_3d936f41 = startBreakBlockEvent -> {
        if (MineHelperModule.I_field_3a9bda27.player == null) {
            return;
        }
        ItemStack itemStack = MineHelperModule.I_field_3a9bda27.player.getMainHandStack();
        if (!this.i_method_31efd385(itemStack)) {
            return;
        }
        double d = this.I_method_8df74f8f(itemStack);
        if (!this.I_field_ba20ca4c.i_method_9b12da03() || d >= (double)this.I_field_73178e8c.Ii_method_a20abcd2()) {
            return;
        }
        startBreakBlockEvent.cancel();
        this.I_method_8df74fa1(itemStack);
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> II_field_3d936f41 = clientPlayerTickEvent -> {
        if (MineHelperModule.I_field_3a9bda27.player == null || !this.I_field_5a) {
            return;
        }
        ItemStack itemStack = MineHelperModule.I_field_3a9bda27.player.getMainHandStack();
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
        if (this.I_method_8df74f8f(itemStack) >= 30.0) {
            this.I_field_5a = false;
            return;
        }
        if (this.i_method_31efd385(itemStack) && this.IiI_method_59739703()) {
            iiIIiIiII_Class4052.I_method_1acbf705(new iiIIiIIii_Class404(MineHelperModule.I_field_3a9bda27.player.getYaw(), 88.0f), iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0f, 80.0f, 80.0f, iiIIiIiiI_Class407.iI_field_32efc66c);
            if (this.I_field_991c1e8c.I_method_58432069(70L)) {
                MineHelperModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(MineHelperModule.I_field_3a9bda27.world, n -> new PlayerInteractItemC2SPacket(Hand.OFF_HAND, n, iiIIiIiII_Class4052.Ii_method_62e6c38().I_method_14534e0f(), 90.0f));
                this.I_field_991c1e8c.I_method_23e11e3f();
            }
        }
    };

    public MineHelperModule() {
        this.IiI_method_597396ff();
    }

    @Compile(obfuscation=4)
    private void IiI_method_597396ff() {
        this.I_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.mine_helper.save_pickaxe", "modules.settings.mine_helper.save_pickaxe.description").I_method_decd82b5();
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.mine_helper.percent").II_method_b0f56334(1.0f).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(70.0f).Ii_method_4e0e6b54(10.0f).I_method_d41e7abf("%");
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.mine_helper.auto_replace", "modules.settings.mine_helper.auto_replace.description");
        this.II_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.mine_helper.auto_repair", "modules.settings.mine_helper.auto_repair.description");
        this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.mine_helper.fix_key", () -> !this.II_field_ba20ca4c.i_method_9b12da03());
    }

    @Compile
    private void I_method_8df74fa1(ItemStack itemStack) {
        boolean bl = false;
        if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            bl = this.I_method_8df74fa5(itemStack);
        }
        if (!bl && this.I_field_991c1e8c.I_method_58432069(800L)) {
            RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.i_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("mine_helper.pickaxe_almost_broken"), IiIiIIII_Class81.I_method_f25a980a("mine_helper.no_replacement"));
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
    }

    private boolean IiI_method_59739703() {
        if (MineHelperModule.I_field_3a9bda27.player.getOffHandStack().getItem() == Items.EXPERIENCE_BOTTLE) {
            this.i_field_5a = false;
            return true;
        }
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_77fa4424(itemStack -> itemStack.getItem() == Items.EXPERIENCE_BOTTLE);
        if (iIIiIiIii_Class3002 == null) {
            if (!this.i_field_5a) {
                RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.i_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("mine_helper.no_bottles"), IiIiIIII_Class81.I_method_f25a980a("mine_helper.need_bottles"));
                this.i_field_5a = true;
            }
            return false;
        }
        iIIiIiIiI_Class299.I_method_2e11f97f(iIIiIiIii_Class3002, iIIiIiIiI_Class299.I_method_d0337735());
        return true;
    }

    @Compile
    private boolean I_method_8df74fa5(ItemStack itemStack) {
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = this.I_method_8f002e17(itemStack);
        if (iIIiiiIii_Class3162 == null) {
            return false;
        }
        iIIiIiIiI_Class299.I_method_4c2ca067(iIIiiiIii_Class3162);
        if (this.I_field_991c1e8c.I_method_58432069(800L)) {
            ItemStack itemStack2 = iIIiiiIii_Class3162.I_method_7b7e0bb9();
            RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.I_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("mine_helper.pickaxe_swap"), IiIiIIII_Class81.I_method_1410d1e5("mine_helper.pickaxe_swapped", this.I_method_8df74f8f(itemStack), this.I_method_8df74f8f(itemStack2)));
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
        return true;
    }

    @Compile
    private iIIiiiIii_Class316 I_method_8f002e17(ItemStack itemStack) {
        double d = this.I_method_8df74f8f(itemStack);
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = null;
        double d2 = d;
        for (int i = 0; i < 9; ++i) {
            double d3;
            iIIiiiIii_Class316 iIIiiiIii_Class3163 = iIIiIiIiI_Class299.I_method_6602651a(i);
            ItemStack itemStack2 = iIIiiiIii_Class3163.I_method_7b7e0bb9();
            if (!this.i_method_31efd385(itemStack2) || !((d3 = this.I_method_8df74f8f(itemStack2)) > d2)) continue;
            d2 = d3;
            iIIiiiIii_Class3162 = iIIiiiIii_Class3163;
        }
        return iIIiiiIii_Class3162;
    }

    private boolean i_method_31efd385(ItemStack itemStack) {
        return itemStack != null && itemStack.isDamageable() && itemStack.getItem() instanceof PickaxeItem;
    }

    private double I_method_8df74f8f(ItemStack itemStack) {
        return (double)(itemStack.getMaxDamage() - itemStack.getDamage()) / (double)itemStack.getMaxDamage() * 100.0;
    }

    @Override
    public void onDisable() {
        this.I_field_5a = false;
        this.i_field_5a = false;
    }
}

