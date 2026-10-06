package rockstar.client;

import lombok.Generated;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.Entity;
import rockstar.client.SliderSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIiIiiiII_Class349;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Anti Invisible", category=ModuleCategory.VISUALS, iI_method_476ab839=true)
public class AntiInvisibleModule
extends Module {
    private SliderSetting I_field_73178e8c;

    public AntiInvisibleModule() {
        this.IiI_method_b53e2a9f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_b53e2a9f() {
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.anti_invisible.opacity").I_method_c8c9a7d7(10.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(70.0f).I_method_bfc3b958(f -> "%");
    }

    public boolean I_method_e24c5ddb(EntityRenderState entityRenderState) {
        Entity entity = ((iIiIiiiII_Class349)entityRenderState).rockstar$getEntity();
        return entity.isInvisible();
    }

    @Generated
    public SliderSetting I_method_94dacf15() {
        return this.I_field_73178e8c;
    }
}

