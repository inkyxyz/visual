package rockstar.client;

import net.minecraft.client.MinecraftClient;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Sky Shader",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.sky_shader"
)
public class SkyShaderModule extends Module {
    private ModeSetting modeSetting;
    private ModeSetting.Nested1_42765c60 modeGalaxy;
    private ModeSetting.Nested1_42765c60 modeSpace;
    private ModeSetting.Nested1_42765c60 modeNebula;
    private ModeSetting.Nested1_42765c60 modeCaustic;
    private ModeSetting.Nested1_42765c60 modeRadiant;
    private ModeSetting.Nested1_42765c60 modeSunset;

    private SliderSetting brightnessSetting;
    private SliderSetting speedSetting;
    private BooleanSetting hideStars;
    private BooleanSetting hideSunMoon;
    private BooleanSetting darkBackground;
    private BooleanSetting syncTheme;
    private ColorSetting skyColor;

    public SkyShaderModule() {
        this.modeSetting = new ModeSetting(this, "Shader");
        this.modeGalaxy = new ModeSetting.Nested1_42765c60(this.modeSetting, "Galaxy").select();
        this.modeSpace = new ModeSetting.Nested1_42765c60(this.modeSetting, "Space");
        this.modeNebula = new ModeSetting.Nested1_42765c60(this.modeSetting, "Nebula");
        this.modeCaustic = new ModeSetting.Nested1_42765c60(this.modeSetting, "Caustic");
        this.modeRadiant = new ModeSetting.Nested1_42765c60(this.modeSetting, "Radiant");
        this.modeSunset = new ModeSetting.Nested1_42765c60(this.modeSetting, "Sunset");

        this.brightnessSetting = new SliderSetting(this, "Brightness")
            .I_method_c8c9a7d7(0.1F)
            .i_method_65e2aff7(1.0F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(1.0F);

        this.speedSetting = new SliderSetting(this, "Speed")
            .I_method_c8c9a7d7(0.1F)
            .i_method_65e2aff7(3.0F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.0F);

        this.hideStars = new BooleanSetting(this, "Hide Stars").I_method_decd82b5();
        this.hideSunMoon = new BooleanSetting(this, "Hide Sun/Moon");
        this.darkBackground = new BooleanSetting(this, "Dark Sky").I_method_decd82b5();
        this.syncTheme = new BooleanSetting(this, "Sync Theme");
        this.skyColor = new ColorSetting(this, "Color").I_method_a62f5dd6(new ColorRGBA(255.0F, 255.0F, 255.0F, 255.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Кастомные шейдерные эффекты неба (Galaxy, Space, Nebula, Caustic, Radiant, Sunset).";
    }

    /**
     * Renders the active shader on the sky dome using the client's native shader pipeline.
     * Called directly from SkyRenderingMixin during sky rendering.
     */
    public void renderSky() {
        float speed = this.speedSetting.Ii_method_a20abcd2();
        float time = (float)(System.currentTimeMillis() % 100000000L) / 1000.0F * speed;
        float alpha = this.brightnessSetting.Ii_method_a20abcd2();

        ColorRGBA tint = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.skyColor.I_method_bde5f08e();

        if (this.modeGalaxy.isSelected()) {
            if (iIiiIIiii_Class360.I_field_64252d2c != null) {
                iIiiiIiIi_Class374.I_method_3dd93e98(iIiiIIiii_Class360.I_field_64252d2c, tint, time, alpha);
            }
        } else if (this.modeSpace.isSelected()) {
            if (iIiiIIiii_Class360.i_field_64252d2c != null) {
                iIiiiIiIi_Class374.I_method_3dd93e98(iIiiIIiii_Class360.i_field_64252d2c, tint, time, alpha);
            }
        } else if (this.modeNebula.isSelected()) {
            if (iIiiIIiii_Class360.I_field_83aa8641 != null) {
                iIiiiIiIi_Class374.I_method_9c2060ff(iIiiIIiii_Class360.I_field_83aa8641, tint, time, alpha);
            }
        } else if (this.modeCaustic.isSelected()) {
            if (iIiiIIiii_Class360.Ii_field_83aa8641 != null) {
                iIiiiIiIi_Class374.I_method_9c2060ff(iIiiIIiii_Class360.Ii_field_83aa8641, tint, time, alpha);
            }
        } else if (this.modeRadiant.isSelected()) {
            if (iIiiIIiii_Class360.II_field_83aa8641 != null) {
                iIiiiIiIi_Class374.I_method_9c2060ff(iIiiIIiii_Class360.II_field_83aa8641, tint, time, alpha);
            }
        } else if (this.modeSunset.isSelected()) {
            if (iIiiIIiii_Class360.i_field_83aa8641 != null) {
                iIiiiIiIi_Class374.I_method_9c2060ff(iIiiIIiii_Class360.i_field_83aa8641, tint, time, alpha);
            }
        }
    }

    public boolean isHideStars() {
        return this.hideStars.i_method_9b12da03();
    }

    public boolean isHideSunMoon() {
        return this.hideSunMoon != null && this.hideSunMoon.i_method_9b12da03();
    }

    public boolean isDarkBackground() {
        return this.darkBackground == null || this.darkBackground.i_method_9b12da03();
    }
}
