package rockstar.client;

@ModuleInfo(
    name = "Terminal",
    category = ModuleCategory.INTERFACE,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.terminal"
)
public class TerminalModule extends Module {

    private final SliderSetting windowScale = new SliderSetting(this, "Scale")
        .I_method_c8c9a7d7(0.7F)
        .i_method_65e2aff7(1.5F)
        .II_method_b0f56334(0.05F)
        .Ii_method_4e0e6b54(1.0F);

    public TerminalModule() {
    }

    @Override
    public void onEnable() {
        super.onEnable();
        TerminalOverlayWindow.getInstance().setScale(this.windowScale.getValue());
    }

    public float getWindowScale() {
        return this.windowScale.getValue();
    }
}
