package rockstar.client;

import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Chams",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.chams"
)
public class ChamsModule extends Module {
    private final BooleanSetting throughWalls = new BooleanSetting(this, "modules.settings.chams.through_walls").I_method_decd82b5();
    private final BooleanSetting syncTheme = new BooleanSetting(this, "modules.settings.chams.sync_theme").I_method_decd82b5();
    private final ColorSetting visibleColor = new ColorSetting(this, "modules.settings.chams.visible_color")
        .I_method_a62f5dd6(new ColorRGBA(16.0F, 185.0F, 129.0F, 200.0F));
    private final ColorSetting hiddenColor = new ColorSetting(this, "modules.settings.chams.hidden_color")
        .I_method_a62f5dd6(new ColorRGBA(239.0F, 68.0F, 68.0F, 160.0F));
    private final SliderSetting fillAlpha = new SliderSetting(this, "modules.settings.chams.fill_alpha")
        .I_method_c8c9a7d7(0.1F)
        .i_method_65e2aff7(1.0F)
        .II_method_b0f56334(0.05F)
        .Ii_method_4e0e6b54(0.65F);

    public ChamsModule() {
    }

    public boolean isThroughWalls() {
        return this.throughWalls.i_method_9b12da03();
    }

    public ColorRGBA getVisibleColor() {
        if (this.syncTheme.i_method_9b12da03()) {
            return IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(this.fillAlpha.Ii_method_a20abcd2() * 255.0F);
        }
        return this.visibleColor.I_method_bde5f08e().withAlpha(this.fillAlpha.Ii_method_a20abcd2() * 255.0F);
    }

    public ColorRGBA getHiddenColor() {
        return this.hiddenColor.I_method_bde5f08e().withAlpha(this.fillAlpha.Ii_method_a20abcd2() * 180.0F);
    }
}
