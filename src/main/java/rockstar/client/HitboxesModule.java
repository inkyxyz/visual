package rockstar.client;

import lombok.Generated;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiIiI_Class139;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Hitboxes", category=ModuleCategory.COMBAT, III_method_a89e5834="modules.descriptions.hitboxes")
public class HitboxesModule
extends Module {
    private SliderSetting I_field_73178e8c;
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 III_field_51de8227;

    public HitboxesModule() {
        this.IiI_method_f828c1ec();
    }

    @Compile(obfuscation=4)
    private void IiI_method_f828c1ec() {
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.hitboxes.size").I_method_c8c9a7d7(0.0f).i_method_65e2aff7(1.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(0.3f);
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.hitboxes.targets");
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.hitboxes.targets.players").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.hitboxes.targets.animals").select();
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.hitboxes.targets.mobs").select();
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.hitboxes.targets.invisibles").select();
        this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.hitboxes.targets.naked_players").select();
        this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "rockUsers");
        this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.hitboxes.targets.friends");
    }

    public boolean I_method_3d2a075(LivingEntity livingEntity) {
        if (livingEntity == null) {
            return false;
        }
        IiIIIiIiI_Class139 iiIIIiIiI_Class139 = new IiIIIiIiI_Class139.Nested1_a87537e0().I_method_1f3a928b(this.I_field_51de8227.isSelected()).i_method_da3212ab(this.i_field_51de8227.isSelected()).II_method_9a5032be(this.II_field_51de8227.isSelected()).iI_method_3e48b69e(this.Ii_field_51de8227.isSelected()).ii_method_f94036be(this.iI_field_51de8227.isSelected()).III_method_81ee98eb(this.III_field_51de8227.isSelected()).Ii_method_5547b2de(this.ii_field_51de8227.isSelected()).I_method_7ebd8d70();
        if (livingEntity instanceof ClientPlayerEntity) {
            return false;
        }
        if (livingEntity.isDead()) {
            return false;
        }
        if (RockstarClient.getInstance().i_method_e8604970()) {
            return false;
        }
        return iiIIIiIiI_Class139.I_method_b72bafcb((Entity)livingEntity);
    }

    @Generated
    public SliderSetting I_method_79b78f62() {
        return this.I_field_73178e8c;
    }
}

