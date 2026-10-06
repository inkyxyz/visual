package rockstar.client;

import lombok.Generated;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ColorSetting;
import rockstar.client.RangeSetting;
import rockstar.client.SliderSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Custom Fog", category=ModuleCategory.VISUALS, iI_method_476ab839=true)
public class CustomFogModule
extends Module {
    private RangeSetting I_field_bbe3b68c;
    private BooleanSetting I_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private ColorSetting I_field_bbd4b66c;

    public CustomFogModule() {
        this.IiI_method_40187ebf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_40187ebf() {
        this.I_field_bbe3b68c = new RangeSetting(this, "modules.settings.custom_fog.distance").II_method_c7edb334(1.0f).Ii_method_6506bb54(100.0f).iI_method_cdf5af14(1.0f).ii_method_6b0eb734(40.0f).I_method_3944a7d7(1.0f).i_method_d65daff7(100.0f);
        this.I_field_ba20ca4c = new BooleanSetting(this, "theme.sync").I_method_decd82b5();
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.custom_fog.sync_alpha", () -> !this.I_field_ba20ca4c.i_method_9b12da03()).I_method_d41e7abf("%").I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(46.0f);
        this.I_field_bbd4b66c = new ColorSetting(this, "modules.settings.custom_fog.color", this.I_field_ba20ca4c::i_method_9b12da03).I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(118.0f)).I_method_af5a85eb(true);
    }

    public boolean I_method_1c4312c4(Camera camera) {
        if (!this.isEnabled() || CustomFogModule.I_field_3a9bda27.world == null || CustomFogModule.I_field_3a9bda27.player == null) {
            return false;
        }
        Entity entity = camera.getFocusedEntity();
        if (camera.getSubmersionType() == CameraSubmersionType.WATER) {
            return false;
        }
        if (camera.getSubmersionType() == CameraSubmersionType.LAVA) {
            return false;
        }
        if (camera.getSubmersionType() == CameraSubmersionType.POWDER_SNOW) {
            return false;
        }
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.hasStatusEffect(StatusEffects.BLINDNESS)) {
                return false;
            }
            if (livingEntity.hasStatusEffect(StatusEffects.NIGHT_VISION)) {
                return false;
            }
        }
        return true;
    }

    @Generated
    public RangeSetting I_method_59ceeb35() {
        return this.I_field_bbe3b68c;
    }

    @Generated
    public BooleanSetting I_method_580bfef5() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public SliderSetting I_method_1102c335() {
        return this.I_field_73178e8c;
    }

    @Generated
    public ColorSetting I_method_59bfeb15() {
        return this.I_field_bbd4b66c;
    }
}

