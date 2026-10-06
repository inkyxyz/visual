package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import pyrock.events.render.HudRenderEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Custom Cursor",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.custom_cursor"
)
public class CustomCursorModule extends Module {
    private ModeSetting styleSetting;
    private ModeSetting.Nested1_42765c60 styleCross;
    private ModeSetting.Nested1_42765c60 styleDot;
    private ModeSetting.Nested1_42765c60 styleCircle;
    private ModeSetting.Nested1_42765c60 styleChevron;
    private ModeSetting.Nested1_42765c60 styleDiamond;

    private SliderSetting sizeSetting;
    private SliderSetting gapSetting;
    private SliderSetting thicknessSetting;
    private BooleanSetting dynamicSpread;
    private BooleanSetting dotCenter;
    private BooleanSetting syncTheme;
    private ColorSetting customColor;

    private float currentSpread = 0.0F;
    private final IiIIIiII_Class69<HudRenderEvent> hudRenderEvent = this::onRenderHud;

    public CustomCursorModule() {
        this.initSettings();
    }

    private void initSettings() {
        this.styleSetting = new ModeSetting(this, "modules.settings.cursor.style");
        this.styleCross = new ModeSetting.Nested1_42765c60(this.styleSetting, "Cross").select();
        this.styleDot = new ModeSetting.Nested1_42765c60(this.styleSetting, "Dot");
        this.styleCircle = new ModeSetting.Nested1_42765c60(this.styleSetting, "Circle");
        this.styleChevron = new ModeSetting.Nested1_42765c60(this.styleSetting, "Chevron");
        this.styleDiamond = new ModeSetting.Nested1_42765c60(this.styleSetting, "Diamond");

        this.sizeSetting = new SliderSetting(this, "Size")
            .I_method_c8c9a7d7(2.0F)
            .i_method_65e2aff7(16.0F)
            .II_method_b0f56334(0.5F)
            .Ii_method_4e0e6b54(6.0F);

        this.gapSetting = new SliderSetting(this, "Gap")
            .I_method_c8c9a7d7(0.5F)
            .i_method_65e2aff7(12.0F)
            .II_method_b0f56334(0.5F)
            .Ii_method_4e0e6b54(3.0F);

        this.thicknessSetting = new SliderSetting(this, "Thickness")
            .I_method_c8c9a7d7(1.0F)
            .i_method_65e2aff7(4.0F)
            .II_method_b0f56334(0.5F)
            .Ii_method_4e0e6b54(1.5F);

        this.dynamicSpread = new BooleanSetting(this, "Dynamic Spread").I_method_decd82b5();
        this.dotCenter = new BooleanSetting(this, "Center Dot").I_method_decd82b5();
        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.customColor = new ColorSetting(this, "Color").I_method_a62f5dd6(new ColorRGBA(255.0F, 255.0F, 255.0F, 240.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Кастомизация прицела и курсора с плавными анимациями, стилями и индикатором удара.";
    }

    private void onRenderHud(HudRenderEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null || mc.world == null) return;
        if (mc.options.hudHidden) return;

        float targetSpread = 0.0F;
        if (this.dynamicSpread.i_method_9b12da03()) {
            boolean moving = player.getVelocity().horizontalLengthSquared() > 0.001;
            boolean attacking = player.handSwingProgress > 0.0F;
            if (attacking) {
                targetSpread = 4.5F;
            } else if (moving) {
                targetSpread = 2.0F;
            }
        }
        this.currentSpread += (targetSpread - this.currentSpread) * 0.25F;

        int screenW = mc.getWindow().getScaledWidth();
        int screenH = mc.getWindow().getScaledHeight();
        float cx = screenW / 2.0F;
        float cy = screenH / 2.0F;

        III context = III.I_method_5728d20f(event.getContext(), -1, -1, event.getTickDelta());

        ColorRGBA color = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.customColor.I_method_bde5f08e();

        float size = this.sizeSetting.Ii_method_a20abcd2();
        float gap = this.gapSetting.Ii_method_a20abcd2() + this.currentSpread;
        float thick = this.thicknessSetting.Ii_method_a20abcd2();
        float halfThick = thick / 2.0F;

        if (this.dotCenter.i_method_9b12da03()) {
            context.drawRoundedRect(cx - halfThick, cy - halfThick, thick, thick, IIiii_Class8.I_method_893b2757(halfThick), color);
        }

        if (this.styleCross.isSelected()) {
            context.drawRoundedRect(cx - gap - size, cy - halfThick, size, thick, IIiii_Class8.I_method_893b2757(0.5F), color);
            context.drawRoundedRect(cx + gap, cy - halfThick, size, thick, IIiii_Class8.I_method_893b2757(0.5F), color);
            context.drawRoundedRect(cx - halfThick, cy - gap - size, thick, size, IIiii_Class8.I_method_893b2757(0.5F), color);
            context.drawRoundedRect(cx - halfThick, cy + gap, thick, size, IIiii_Class8.I_method_893b2757(0.5F), color);
        } else if (this.styleDot.isSelected()) {
            float dotR = size * 0.5F;
            context.drawRoundedRect(cx - dotR, cy - dotR, dotR * 2.0F, dotR * 2.0F, IIiii_Class8.I_method_893b2757(dotR), color);
        } else if (this.styleCircle.isSelected()) {
            float r = gap + size * 0.5F;
            context.drawRoundedBorder(cx - r, cy - r, r * 2.0F, r * 2.0F, thick, IIiii_Class8.I_method_893b2757(r), color);
        } else if (this.styleChevron.isSelected()) {
            context.drawRoundedRect(cx - gap - size, cy - halfThick, size, thick, IIiii_Class8.I_method_893b2757(0.5F), color);
            context.drawRoundedRect(cx + gap, cy - halfThick, size, thick, IIiii_Class8.I_method_893b2757(0.5F), color);
            context.drawRoundedRect(cx - halfThick, cy + gap, thick, size * 0.8F, IIiii_Class8.I_method_893b2757(0.5F), color);
        } else if (this.styleDiamond.isSelected()) {
            float d = gap + size * 0.6F;
            context.drawRoundedBorder(cx - d, cy - d, d * 2.0F, d * 2.0F, thick, IIiii_Class8.I_method_893b2757(1.5F), color);
        }
    }
}
