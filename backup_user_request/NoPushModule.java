package rockstar.client;

import lombok.Generated;
import rockstar.client.MultiSelectSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="No Push", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.no_push")
public class NoPushModule
extends Module {
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;

    public NoPushModule() {
        this.IiI_method_e2a1badf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_e2a1badf() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.no_push.remove_from");
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.no_push.remove_from.entities", "modules.settings.no_push.remove_from.entities.description").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.no_push.remove_from.fluids", "modules.settings.no_push.remove_from.fluids.description");
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.no_push.remove_from.bubble_columns", "modules.settings.no_push.remove_from.bubble_columns.description");
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.no_push.remove_from.blocks", "modules.settings.no_push.remove_from.blocks.description").select();
    }

    @Generated
    public MultiSelectSetting I_method_96dcb35() {
        return this.I_field_bbe3ba6c;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 I_method_652784b0() {
        return this.I_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 i_method_6b2f8090() {
        return this.i_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 II_method_3cacc0b3() {
        return this.II_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 Ii_method_42b4bc93() {
        return this.Ii_field_51de8227;
    }
}

