package rockstar.client;

@ModuleInfo(
    name = "Custom Nametags",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.nametags"
)
public class CustomNametagsModule extends Module {
    private final BooleanSetting showHealth = new BooleanSetting(this, "modules.settings.nametags.health").I_method_decd82b5();
    private final BooleanSetting showDistance = new BooleanSetting(this, "modules.settings.nametags.distance").I_method_decd82b5();
    private final BooleanSetting showArmor = new BooleanSetting(this, "modules.settings.nametags.armor").I_method_decd82b5();
    private final BooleanSetting showHeldItems = new BooleanSetting(this, "modules.settings.nametags.items").I_method_decd82b5();
    private final BooleanSetting coloredHealth = new BooleanSetting(this, "modules.settings.nametags.colored_hp").I_method_decd82b5();

    private final SliderSetting scale = new SliderSetting(this, "modules.settings.nametags.scale")
        .I_method_c8c9a7d7(0.5F)
        .i_method_65e2aff7(3.0F)
        .II_method_b0f56334(0.1F)
        .Ii_method_4e0e6b54(1.2F);

    private final SliderSetting bgOpacity = new SliderSetting(this, "modules.settings.nametags.bg_opacity")
        .I_method_c8c9a7d7(0.0F)
        .i_method_65e2aff7(100.0F)
        .II_method_b0f56334(5.0F)
        .Ii_method_4e0e6b54(60.0F);

    private final SliderSetting maxDistance = new SliderSetting(this, "modules.settings.nametags.max_dist")
        .I_method_c8c9a7d7(8.0F)
        .i_method_65e2aff7(128.0F)
        .II_method_b0f56334(4.0F)
        .Ii_method_4e0e6b54(64.0F);

    public CustomNametagsModule() {
    }

    public boolean shouldShowHealth() {
        return this.showHealth.i_method_9b12da03();
    }

    public boolean shouldShowDistance() {
        return this.showDistance.i_method_9b12da03();
    }

    public boolean shouldShowArmor() {
        return this.showArmor.i_method_9b12da03();
    }

    public boolean shouldShowHeldItems() {
        return this.showHeldItems.i_method_9b12da03();
    }

    public boolean isColoredHealth() {
        return this.coloredHealth.i_method_9b12da03();
    }

    public float getNametagScale() {
        return this.scale.Ii_method_a20abcd2();
    }

    public float getBackgroundOpacity() {
        return this.bgOpacity.Ii_method_a20abcd2() / 100.0F;
    }

    public float getMaxDistance() {
        return this.maxDistance.Ii_method_a20abcd2();
    }
}
