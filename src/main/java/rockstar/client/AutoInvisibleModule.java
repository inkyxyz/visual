package rockstar.client;

import java.util.Map;
import java.util.TreeMap;
import lombok.Generated;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.SlotActionType;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.BooleanSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIiII_Class261;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiiIi_Class318;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Invisible", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.auto_invisible")
public class AutoInvisibleModule
extends Module {
    private final Map<String, StatusEffectInstance> I_field_a567c40b = new TreeMap<String, StatusEffectInstance>();
    private boolean I_field_5a;
    private BooleanSetting I_field_ba20ca4c;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> this.Iii_method_c5e869f();

    public AutoInvisibleModule() {
        this.IiI_method_c4ffabf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_c4ffabf() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auto_invisible.pre_drink");
    }

    @Compile(obfuscation=1)
    private void Iii_method_c5e869f() {
        boolean bl;
        boolean bl2 = AutoInvisibleModule.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.INVISIBILITY);
        StatusEffectInstance statusEffectInstance = bl2 ? AutoInvisibleModule.I_field_3a9bda27.player.getStatusEffect(StatusEffects.INVISIBILITY) : null;
        boolean bl3 = bl = !bl2;
        if (this.I_field_ba20ca4c.i_method_9b12da03() && statusEffectInstance != null && statusEffectInstance.getDuration() <= 200) {
            bl = true;
        }
        if (bl) {
            ItemStack itemStack = AutoInvisibleModule.I_field_3a9bda27.player.getOffHandStack();
            boolean bl4 = this.I_method_801c9365(itemStack);
            iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
            iIIiIiIii_Class300 iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_77fa4424(this::I_method_801c9365);
            iIIiiiiIi_Class318 iIIiiiiIi_Class3182 = new iIIiiiiIi_Class318();
            if (iIIiIiIii_Class3002 != null && !bl4) {
                iIIiIiIiI_Class299.I_method_2e11f97f(iIIiIiIii_Class3002, iIIiiiiIi_Class3182);
            }
            if (bl4) {
                this.I_field_5a = true;
                AutoInvisibleModule.I_field_3a9bda27.options.useKey.setPressed(true);
            }
        } else if (this.I_field_5a) {
            AutoInvisibleModule.I_field_3a9bda27.options.useKey.setPressed(false);
            this.I_field_5a = false;
            ItemStack itemStack = AutoInvisibleModule.I_field_3a9bda27.player.getOffHandStack();
            if (itemStack.getItem() == Items.GLASS_BOTTLE) {
                AutoInvisibleModule.I_field_3a9bda27.interactionManager.clickSlot(0, 45, 1, SlotActionType.THROW, (PlayerEntity)AutoInvisibleModule.I_field_3a9bda27.player);
            }
        }
    }

    private boolean I_method_801c9365(ItemStack itemStack) {
        return iIIIIIiII_Class261.I_method_afec1b5a(itemStack, (RegistryEntry<StatusEffect>)StatusEffects.INVISIBILITY);
    }

    @Generated
    public Map<String, StatusEffectInstance> i_method_295fae14() {
        return this.I_field_a567c40b;
    }
}

