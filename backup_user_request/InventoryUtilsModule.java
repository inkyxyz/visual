package rockstar.client;

import lombok.Generated;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Inventory Utils", category=ModuleCategory.PLAYER)
public class InventoryUtilsModule
extends Module {
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting i_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 IiI_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Iii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iII_field_51de8227;
    private BooleanSetting I_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
    private float I_field_46 = -1.0f;
    private boolean I_field_5a;

    public InventoryUtilsModule() {
        this.IiI_method_d0e5b6df();
    }

    @Compile(obfuscation=4)
    private void IiI_method_d0e5b6df() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.inv_utils.targets").I_method_702bd95a(1);
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.inv_utils.item_scroller").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.inv_utils.slot_lock").select();
        this.i_field_bbe3ba6c = new MultiSelectSetting((IIiiiIIiI_Class115)this, "modules.settings.slot_lock.lock", () -> !this.i_field_51de8227.isSelected()).I_method_702bd95a(1);
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot1").select();
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot2");
        this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot3");
        this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot4");
        this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot5");
        this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot6");
        this.IiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot7");
        this.Iii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot8");
        this.iII_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.slot_lock.lock.slot9");
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.slot_lock.only_pvp", "modules.settings.slot_lock.only_pvp.desc", () -> !this.i_field_51de8227.isSelected()).I_method_a4d009eb(false);
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.inv_utils.delay", () -> !this.I_field_51de8227.isSelected()).Ii_method_4e0e6b54(0.0f).i_method_65e2aff7(250.0f).I_method_c8c9a7d7(0.0f).II_method_b0f56334(1.0f).I_method_d41e7abf(" ms");
    }

    public boolean I_method_e5974888(int n) {
        MultiSelectSetting.Nested1_42856060[] nested1_42856060Array = new MultiSelectSetting.Nested1_42856060[]{this.II_field_51de8227, this.Ii_field_51de8227, this.iI_field_51de8227, this.ii_field_51de8227, this.III_field_51de8227, this.IIi_field_51de8227, this.IiI_field_51de8227, this.Iii_field_51de8227, this.iII_field_51de8227};
        if (this.I_field_ba20ca4c.i_method_9b12da03() && !iIIIiiiII_Class285.I_field_5a) {
            return false;
        }
        return n >= 0 && n < nested1_42856060Array.length && nested1_42856060Array[n].isSelected() && this.isEnabled();
    }

    @Generated
    public MultiSelectSetting I_method_aa7dc735() {
        return this.I_field_bbe3ba6c;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 I_method_22880b0() {
        return this.I_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 i_method_8307c90() {
        return this.i_field_51de8227;
    }

    @Generated
    public MultiSelectSetting i_method_c0133b15() {
        return this.i_field_bbe3ba6c;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 II_method_3fcb44b3() {
        return this.II_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 Ii_method_45d34093() {
        return this.Ii_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 iI_method_fac2c4d3() {
        return this.iI_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 ii_method_cac0b3() {
        return this.ii_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 III_method_b6810110() {
        return this.III_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 IIi_method_bc88fcf0() {
        return this.IIi_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 IiI_method_71788130() {
        return this.IiI_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 Iii_method_77807d10() {
        return this.Iii_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 iII_method_5a7984f0() {
        return this.iII_field_51de8227;
    }

    @Generated
    public BooleanSetting I_method_a8bad715() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public SliderSetting I_method_61b19b55() {
        return this.I_field_73178e8c;
    }

    @Generated
    public iiIiIIiii_Class424 I_method_87b62b55() {
        return this.I_field_991c1e8c;
    }

    @Generated
    public iiIiIIiii_Class424 i_method_9d4b9f35() {
        return this.i_field_991c1e8c;
    }

    @Generated
    public float I_method_767f64f() {
        return this.I_field_46;
    }

    @Generated
    public boolean IiI_method_d0e5b6e3() {
        return this.I_field_5a;
    }
}

