package rockstar.client;

import net.minecraft.entity.effect.StatusEffects;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Effect Remover", category=ModuleCategory.OTHER)
public class EffectRemoverModule
extends Module {
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (EffectRemoverModule.I_field_3a9bda27.player == null) {
            return;
        }
        if (this.I_field_51de8227.isSelected()) {
            EffectRemoverModule.I_field_3a9bda27.player.removeStatusEffect(StatusEffects.LEVITATION);
        }
        if (this.i_field_51de8227.isSelected()) {
            EffectRemoverModule.I_field_3a9bda27.player.removeStatusEffect(StatusEffects.JUMP_BOOST);
        }
        if (this.II_field_51de8227.isSelected()) {
            EffectRemoverModule.I_field_3a9bda27.player.removeStatusEffect(StatusEffects.SLOW_FALLING);
        }
    };

    public EffectRemoverModule() {
        this.IiI_method_8912c6df();
    }

    @Compile(obfuscation=4)
    private void IiI_method_8912c6df() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.effect_remover.remove");
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.effect_remover.remove.levitation").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.effect_remover.remove.jump_boost").select();
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.effect_remover.remove.slow_fall").select();
    }
}

