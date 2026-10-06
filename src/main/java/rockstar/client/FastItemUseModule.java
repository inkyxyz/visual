package rockstar.client;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIiIiIIi_Class298;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Fast Item Use", category=ModuleCategory.OTHER, III_method_a89e5834="modules.descriptions.fast_item_use")
public class FastItemUseModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private BooleanSetting II_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (this.i_field_ba20ca4c.i_method_9b12da03() && this.IiI_method_8d8d6ec3()) {
            this.Iii_method_8d9bfa9f();
        }
        if (this.I_field_ba20ca4c.i_method_9b12da03() && this.Iii_method_8d9bfaa3()) {
            this.Iii_method_8d9bfa9f();
        }
        if (this.II_field_ba20ca4c.i_method_9b12da03() && this.iII_method_c2659283()) {
            this.Iii_method_8d9bfa9f();
        }
    };

    public FastItemUseModule() {
        this.IiI_method_8d8d6ebf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_8d8d6ebf() {
        this.I_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.fast_item_use.bow", "modules.settings.fast_item_use.bow.description").I_method_decd82b5();
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.fast_item_use.trident", "modules.settings.fast_item_use.trident.description").I_method_decd82b5();
        this.II_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.fast_item_use.crossbow", "modules.settings.fast_item_use.crossbow.description").I_method_decd82b5();
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.fast_item_use.delay").Ii_method_4e0e6b54(10.0f).i_method_65e2aff7(20.0f).I_method_c8c9a7d7(1.0f).II_method_b0f56334(1.0f);
    }

    private void Iii_method_8d9bfa9f() {
        if (FastItemUseModule.I_field_3a9bda27.player == null) {
            return;
        }
        FastItemUseModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, FastItemUseModule.I_field_3a9bda27.player.getHorizontalFacing()));
        FastItemUseModule.I_field_3a9bda27.player.stopUsingItem();
    }

    private boolean IiI_method_8d8d6ec3() {
        if (FastItemUseModule.I_field_3a9bda27.player == null) {
            return false;
        }
        ItemStack itemStack = FastItemUseModule.I_field_3a9bda27.player.getMainHandStack();
        return itemStack.getItem() == Items.TRIDENT && iIIiIiIIi_Class298.I_method_7ea237bf(itemStack, (RegistryKey<Enchantment>)Enchantments.RIPTIDE) > 0 && FastItemUseModule.I_field_3a9bda27.player.isUsingItem() && (float)FastItemUseModule.I_field_3a9bda27.player.getItemUseTime() >= this.I_field_73178e8c.Ii_method_a20abcd2() && FastItemUseModule.I_field_3a9bda27.player.getAttackCooldownProgress(0.5f) > 0.92f;
    }

    private boolean Iii_method_8d9bfaa3() {
        if (FastItemUseModule.I_field_3a9bda27.player == null) {
            return false;
        }
        return FastItemUseModule.I_field_3a9bda27.player.getMainHandStack().getItem() == Items.BOW && FastItemUseModule.I_field_3a9bda27.player.isUsingItem() && (float)FastItemUseModule.I_field_3a9bda27.player.getItemUseTime() >= this.I_field_73178e8c.Ii_method_a20abcd2();
    }

    private boolean iII_method_c2659283() {
        if (FastItemUseModule.I_field_3a9bda27.player == null) {
            return false;
        }
        return FastItemUseModule.I_field_3a9bda27.player.getMainHandStack().getItem() == Items.CROSSBOW && FastItemUseModule.I_field_3a9bda27.player.isUsingItem() && (float)FastItemUseModule.I_field_3a9bda27.player.getItemUseTime() >= this.I_field_73178e8c.Ii_method_a20abcd2();
    }
}

