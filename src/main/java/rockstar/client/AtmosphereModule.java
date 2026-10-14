package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Atmosphere",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.atmosphere"
)
public class AtmosphereModule extends Module {
    private final ModeSetting mode = new ModeSetting(this, "modules.settings.atmosphere.mode");
    private final ModeSetting.Nested1_42765c60 modeDawn;
    private final ModeSetting.Nested1_42765c60 modeDay;
    private final ModeSetting.Nested1_42765c60 modeDusk;
    private final ModeSetting.Nested1_42765c60 modeNight;
    private final ModeSetting.Nested1_42765c60 modeDust;
    private final ModeSetting.Nested1_42765c60 modeSnow;
    private final ModeSetting.Nested1_42765c60 modeAsh;
    private final ModeSetting.Nested1_42765c60 modeCustom;

    private final SliderSetting density = new SliderSetting(this, "modules.settings.atmosphere.density")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(3.0F)
        .II_method_b0f56334(0.1F)
        .Ii_method_4e0e6b54(1.0F);

    private final SliderSetting scatterHeight = new SliderSetting(this, "modules.settings.atmosphere.scatter_height")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(320.0F)
        .II_method_b0f56334(5.0F)
        .Ii_method_4e0e6b54(64.0F);

    private final SliderSetting godRays = new SliderSetting(this, "modules.settings.atmosphere.god_rays")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(3.0F)
        .II_method_b0f56334(0.1F)
        .Ii_method_4e0e6b54(1.0F);

    private final SliderSetting softness = new SliderSetting(this, "modules.settings.atmosphere.softness")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(3.0F)
        .II_method_b0f56334(0.1F)
        .Ii_method_4e0e6b54(1.0F);

    private final ColorSetting dawnColor = new ColorSetting(this, "modules.settings.atmosphere.dawn_color")
        .I_method_a62f5dd6(new ColorRGBA(255.0F, 175.0F, 120.0F, 200.0F));

    private final ColorSetting fogColor = new ColorSetting(this, "modules.settings.atmosphere.fog_color")
        .I_method_a62f5dd6(new ColorRGBA(180.0F, 200.0F, 240.0F, 160.0F));

    private final SliderSetting haze = new SliderSetting(this, "modules.settings.atmosphere.haze")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(3.0F)
        .II_method_b0f56334(0.1F)
        .Ii_method_4e0e6b54(1.0F);

    private final SliderSetting vignette = new SliderSetting(this, "modules.settings.atmosphere.vignette")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(3.0F)
        .II_method_b0f56334(0.1F)
        .Ii_method_4e0e6b54(1.0F);

    private final ModeSetting timeOfDay = new ModeSetting(this, "modules.settings.atmosphere.time");
    private final ModeSetting.Nested1_42765c60 timeServer;
    private final ModeSetting.Nested1_42765c60 timeDay;
    private final ModeSetting.Nested1_42765c60 timeSunset;
    private final ModeSetting.Nested1_42765c60 timeNight;
    private final ModeSetting.Nested1_42765c60 timeMidnight;
    private final ModeSetting.Nested1_42765c60 timeCycle;

    private final ModeSetting weatherMode = new ModeSetting(this, "modules.settings.atmosphere.weather");
    private final ModeSetting.Nested1_42765c60 weatherServer;
    private final ModeSetting.Nested1_42765c60 weatherClear;
    private final ModeSetting.Nested1_42765c60 weatherRain;
    private final ModeSetting.Nested1_42765c60 weatherThunder;

    public AtmosphereModule() {
        this.modeDawn = new ModeSetting.Nested1_42765c60(this.mode, "Dawn");
        this.modeDay = new ModeSetting.Nested1_42765c60(this.mode, "Day");
        this.modeDusk = new ModeSetting.Nested1_42765c60(this.mode, "Dusk");
        this.modeNight = new ModeSetting.Nested1_42765c60(this.mode, "Night");
        this.modeDust = new ModeSetting.Nested1_42765c60(this.mode, "Dust");
        this.modeSnow = new ModeSetting.Nested1_42765c60(this.mode, "Snow");
        this.modeAsh = new ModeSetting.Nested1_42765c60(this.mode, "Ash");
        this.modeCustom = new ModeSetting.Nested1_42765c60(this.mode, "Custom");
        this.modeDawn.select();

        this.timeServer = new ModeSetting.Nested1_42765c60(this.timeOfDay, "Server");
        this.timeDay = new ModeSetting.Nested1_42765c60(this.timeOfDay, "Day");
        this.timeSunset = new ModeSetting.Nested1_42765c60(this.timeOfDay, "Sunset");
        this.timeNight = new ModeSetting.Nested1_42765c60(this.timeOfDay, "Night");
        this.timeMidnight = new ModeSetting.Nested1_42765c60(this.timeOfDay, "Midnight");
        this.timeCycle = new ModeSetting.Nested1_42765c60(this.timeOfDay, "Cycle");
        this.timeServer.select();

        this.weatherServer = new ModeSetting.Nested1_42765c60(this.weatherMode, "Server");
        this.weatherClear = new ModeSetting.Nested1_42765c60(this.weatherMode, "Clear");
        this.weatherRain = new ModeSetting.Nested1_42765c60(this.weatherMode, "Rain");
        this.weatherThunder = new ModeSetting.Nested1_42765c60(this.weatherMode, "Thunder");
        this.weatherServer.select();
    }

    public ColorRGBA getActiveFogColor() {
        if (this.modeDawn.isSelected()) {
            return new ColorRGBA(255.0F, 160.0F, 110.0F, 190.0F);
        } else if (this.modeDay.isSelected()) {
            return new ColorRGBA(210.0F, 230.0F, 255.0F, 140.0F);
        } else if (this.modeDusk.isSelected()) {
            return new ColorRGBA(230.0F, 110.0F, 90.0F, 200.0F);
        } else if (this.modeNight.isSelected()) {
            return new ColorRGBA(20.0F, 30.0F, 55.0F, 220.0F);
        } else if (this.modeDust.isSelected()) {
            return new ColorRGBA(200.0F, 150.0F, 90.0F, 210.0F);
        } else if (this.modeSnow.isSelected()) {
            return new ColorRGBA(240.0F, 245.0F, 255.0F, 230.0F);
        } else if (this.modeAsh.isSelected()) {
            return new ColorRGBA(70.0F, 70.0F, 75.0F, 220.0F);
        }
        return this.fogColor.I_method_bde5f08e();
    }

    public long getOverrideTimeOfDay(long serverTime) {
        if (!this.isEnabled()) return serverTime;
        if (this.timeDay.isSelected()) return 1000L;
        if (this.timeSunset.isSelected()) return 12000L;
        if (this.timeNight.isSelected()) return 18000L;
        if (this.timeMidnight.isSelected()) return 21000L;
        if (this.timeCycle.isSelected()) {
            return (System.currentTimeMillis() * 5L) % 24000L;
        }
        return serverTime;
    }

    public Float getOverrideRainGradient() {
        if (!this.isEnabled() || this.weatherServer.isSelected()) return null;
        if (this.weatherClear.isSelected()) return 0.0F;
        if (this.weatherRain.isSelected() || this.weatherThunder.isSelected()) return 1.0F;
        return null;
    }

    public Float getOverrideThunderGradient() {
        if (!this.isEnabled() || this.weatherServer.isSelected()) return null;
        if (this.weatherThunder.isSelected()) return 1.0F;
        return 0.0F;
    }

    public float getDensity() {
        return this.density.Ii_method_a20abcd2();
    }

    public float getScatterHeight() {
        return this.scatterHeight.Ii_method_a20abcd2();
    }

    public float getGodRays() {
        return this.godRays.Ii_method_a20abcd2();
    }

    public float getSoftness() {
        return this.softness.Ii_method_a20abcd2();
    }

    public float getHaze() {
        return this.haze.Ii_method_a20abcd2();
    }

    public float getVignette() {
        return this.vignette.Ii_method_a20abcd2();
    }
}
