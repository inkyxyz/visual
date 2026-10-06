package moscow.rockstar.mixin.minecraft.client.gui.widget;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.BadgeStyle;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiII_Class13;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.RockstarClient;
import rockstar.client.UISoundManager;

@Mixin(value = {PressableWidget.class})
public abstract class PressableWidgetMixin extends ClickableWidget {
    @Unique
    private float rockstar$hoverAnim = 0.0F;
    @Unique
    private float rockstar$pressAnim = 0.0F;

    public PressableWidgetMixin(int x, int y, int width, int height, Text message) {
        super(x, y, width, height, message);
    }

    @Inject(method = "onClick", at = @At("HEAD"))
    private void rockstar$playClickSound(double mouseX, double mouseY, CallbackInfo ci) {
        UISoundManager.playButtonClick();
    }

    @Inject(method = "renderWidget", at = @At("HEAD"), cancellable = true)
    private void rockstar$renderLiquidGlassButton(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ci.cancel();

        boolean isHovered = mouseX >= this.getX() && mouseX <= this.getX() + this.getWidth() &&
                            mouseY >= this.getY() && mouseY <= this.getY() + this.getHeight();

        long windowHandle = MinecraftClient.getInstance().getWindow().getHandle();
        boolean isMouseDown = org.lwjgl.glfw.GLFW.glfwGetMouseButton(windowHandle, org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
        boolean isHeld = isHovered && isMouseDown && this.active;

        float target = (isHovered && this.active) ? 1.0F : 0.0F;
        this.rockstar$hoverAnim += (target - this.rockstar$hoverAnim) * 0.24F;
        if (this.rockstar$hoverAnim < 0.001F) this.rockstar$hoverAnim = 0.0F;
        if (this.rockstar$hoverAnim > 0.999F) this.rockstar$hoverAnim = 1.0F;

        float pressTarget = isHeld ? 1.0F : 0.0F;
        this.rockstar$pressAnim += (pressTarget - this.rockstar$pressAnim) * 0.35F;
        if (this.rockstar$pressAnim < 0.001F) this.rockstar$pressAnim = 0.0F;
        if (this.rockstar$pressAnim > 0.999F) this.rockstar$pressAnim = 1.0F;

        CustomDrawContext custom = (context instanceof CustomDrawContext cdc) ? cdc : new CustomDrawContext(context);

        float bx = (float) this.getX();
        float by = (float) this.getY();
        float bw = (float) this.getWidth();
        float bh = (float) this.getHeight();

        // 3D elevation lift on hover, compression down when holding
        float lift = -2.2F * this.rockstar$hoverAnim + 3.2F * this.rockstar$pressAnim;
        float animY = by + lift;
        float rad = Math.min(bh / 2.0F, 10.0F);
        IIiii_Class8 radObj = IIiii_Class8.I_method_893b2757(rad);

        boolean pressedTransform = this.rockstar$pressAnim > 0.005F;
        if (pressedTransform) {
            float pressScale = 1.0F - 0.045F * this.rockstar$pressAnim;
            float cx = bx + bw / 2.0F;
            float cyCoord = animY + bh / 2.0F;
            custom.getMatrices().push();
            custom.getMatrices().translate(cx, cyCoord, 0.0F);
            custom.getMatrices().scale(pressScale, pressScale, 1.0F);
            custom.getMatrices().translate(-cx, -cyCoord, 0.0F);
        }

        float btnAlpha = this.alpha;
        ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();

        // 1. 3D Drop Shadow expanding with elevation
        if (this.rockstar$hoverAnim > 0.01F) {
            float shadowAlpha = (30.0F + 80.0F * this.rockstar$hoverAnim) * btnAlpha;
            custom.drawShadow(bx + 1.0F, animY + bh - 1.0F, bw - 2.0F, 5.0F, 12.0F, radObj, new ColorRGBA(0.0F, 0.0F, 0.0F, shadowAlpha));
        }

        // 2. iOS Liquid Frosted Glass Base Body
        ColorRGBA glassBase;
        if (this.active) {
            float baseA = (105.0F + 30.0F * this.rockstar$hoverAnim) * btnAlpha;
            glassBase = new ColorRGBA(20.0F, 24.0F, 34.0F, baseA);
        } else {
            glassBase = new ColorRGBA(16.0F, 18.0F, 24.0F, 65.0F * btnAlpha);
        }
        custom.drawRoundedRect(bx, animY, bw, bh, radObj, glassBase);

        // 3. Hover Accent Glow
        if (this.active && this.rockstar$hoverAnim > 0.01F) {
            custom.drawRoundedRect(bx, animY, bw, bh, radObj, themeAccent.withAlpha(35.0F * this.rockstar$hoverAnim * btnAlpha));
        }

        // 4. Specular Glass Highlight Sheen (iOS Liquid Glass reflection)
        IIiii_Class8 topRad = new IIiii_Class8(rad, rad, 1.0F, 1.0F);
        float glossAlpha = (this.active ? (14.0F + 14.0F * this.rockstar$hoverAnim) : 5.0F) * btnAlpha;
        custom.drawRoundedRect(bx + 1.0F, animY + 1.0F, bw - 2.0F, bh * 0.40F, topRad, new ColorRGBA(255.0F, 255.0F, 255.0F, glossAlpha));

        // 5. Liquid Glass Frosted Border
        ColorRGBA borderCol;
        if (this.active) {
            if (this.rockstar$hoverAnim > 0.01F) {
                borderCol = themeAccent.withAlpha((70.0F + 70.0F * this.rockstar$hoverAnim) * btnAlpha);
            } else {
                borderCol = new ColorRGBA(255.0F, 255.0F, 255.0F, 26.0F * btnAlpha);
            }
        } else {
            borderCol = new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F * btnAlpha);
        }
        custom.drawRoundedBorder(bx, animY, bw, bh, 1.0F, radObj, borderCol);

        // 6. iOS Inset Grouped Cell: Squircle Icon Badge, Label, Toggle/Chevron
        String rawText = this.getMessage().getString();
        String lower = rawText.toLowerCase().trim();
        BadgeStyle badge = BadgeStyle.getBadgeStyle(lower);

        IIiIIi_Class10 font = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F);
            }
        } catch (Throwable ignored) {
        }

        boolean isToggle = lower.contains(": on") || lower.contains(": off") ||
                           lower.contains(": \u0432\u043a\u043b") || lower.contains(": \u0432\u044b\u043a\u043b") ||
                           lower.endsWith(" on") || lower.endsWith(" off");
        boolean isToggleOn = lower.contains(": on") || lower.contains(": \u0432\u043a\u043b") || lower.endsWith(" on");
        int colonIdx = rawText.indexOf(':');
        boolean isKeyValue = colonIdx > 0 && !isToggle;
        boolean isNav = rawText.trim().endsWith("...") || (lower.contains("setting") && !isKeyValue) || (lower.contains("\u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a") && !isKeyValue);
        boolean isCenteredAction = bw < 88.0F || lower.equals("done") || lower.equals("\u0433\u043e\u0442\u043e\u0432\u043e") ||
                                   lower.equals("cancel") || lower.equals("\u043e\u0442\u043c\u0435\u043d\u0430") ||
                                   lower.equals("back") || lower.equals("\u043d\u0430\u0437\u0430\u0434") ||
                                   lower.equals("reset") || lower.equals("\u0441\u0431\u0440\u043e\u0441");

        float badgeSize = Math.max(10.0F, Math.min(bh - 8.0F, 16.0F));
        IIiii_Class8 badgeRad = IIiii_Class8.I_method_893b2757(Math.min(4.0F, badgeSize / 3.0F));
        boolean showBadge = !isCenteredAction && bw >= 75.0F && bh >= 18.0F;

        if (font != null) {
            if (isCenteredAction) {
                // Centered button for action buttons (Done, Cancel, Back, Reset, etc.)
                float textW = font.I_method_2c375926(rawText);
                float textX = bx + (bw - textW) / 2.0F;
                ColorRGBA textCol = this.active ?
                    (this.rockstar$hoverAnim > 0.01F ? ColorRGBA.WHITE : new ColorRGBA(235.0F, 240.0F, 250.0F, 245.0F * btnAlpha)) :
                    new ColorRGBA(130.0F, 135.0F, 145.0F, 140.0F * btnAlpha);
                custom.drawText(font, rawText, textX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, textCol);
            } else {
                // iOS Inset Row: Badge on left, label, and right-side toggle / value / chevron
                float labelX = bx + 8.0F;
                if (showBadge) {
                    float badgeX = bx + 6.0F;
                    float badgeY = animY + (bh - badgeSize) / 2.0F;

                    // Draw Apple iOS Squircle Badge
                    custom.drawRoundedRect(badgeX, badgeY, badgeSize, badgeSize, badgeRad, new IiiII_Class13(badge.top.mulAlpha(btnAlpha * 0.9F), badge.bot.mulAlpha(btnAlpha * 0.9F)));
                    float iconSz = Math.max(6.0F, badgeSize - 5.0F);
                    custom.drawIcon(badge.icon, badgeX + (badgeSize - iconSz) / 2.0F, badgeY + (badgeSize - iconSz) / 2.0F, iconSz, ColorRGBA.WHITE.mulAlpha(btnAlpha));
                    labelX = badgeX + badgeSize + 7.0F;
                }

                ColorRGBA textCol = this.active ?
                    (this.rockstar$hoverAnim > 0.01F ? ColorRGBA.WHITE : new ColorRGBA(240.0F, 244.0F, 252.0F, 245.0F * btnAlpha)) :
                    new ColorRGBA(130.0F, 135.0F, 145.0F, 140.0F * btnAlpha);

                if (isToggle) {
                    // Extract title before colon
                    String title = (colonIdx > 0) ? rawText.substring(0, colonIdx).trim() : rawText.trim();
                    custom.drawText(font, title, labelX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, textCol);

                    // Draw authentic iOS Pill Toggle Switch
                    float pillW = 26.0F, pillH = 14.0F;
                    float pillX = bx + bw - pillW - 7.0F;
                    float pillY = animY + (bh - pillH) / 2.0F;
                    IIiii_Class8 pillRad = IIiii_Class8.I_method_893b2757(pillH / 2.0F);
                    ColorRGBA pillBg = isToggleOn ?
                        new ColorRGBA(52.0F, 199.0F, 89.0F, 235.0F * btnAlpha) :
                        new ColorRGBA(58.0F, 62.0F, 72.0F, 200.0F * btnAlpha);
                    custom.drawRoundedRect(pillX, pillY, pillW, pillH, pillRad, pillBg);
                    float thumbSz = pillH - 3.0F;
                    float thumbX = isToggleOn ? (pillX + pillW - thumbSz - 1.5F) : (pillX + 1.5F);
                    custom.drawRoundedRect(thumbX, pillY + 1.5F, thumbSz, thumbSz, IIiii_Class8.I_method_893b2757(thumbSz / 2.0F), ColorRGBA.WHITE.mulAlpha(btnAlpha));
                } else if (isKeyValue) {
                    // Split Title and Value like iOS Settings
                    String title = rawText.substring(0, colonIdx).trim();
                    String val = rawText.substring(colonIdx + 1).trim();
                    custom.drawText(font, title, labelX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, textCol);

                    float valW = font.I_method_2c375926(val);
                    float valX = bx + bw - valW - 9.0F;
                    ColorRGBA valCol = new ColorRGBA(165.0F, 175.0F, 195.0F, 220.0F * btnAlpha);
                    custom.drawText(font, val, valX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, valCol);
                } else {
                    custom.drawText(font, rawText, labelX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, textCol);

                    if (isNav) {
                        // iOS Chevron Arrow '›' on the right
                        ColorRGBA chevronCol = new ColorRGBA(165.0F, 172.0F, 188.0F, 170.0F * btnAlpha);
                        custom.drawText(font, ">", bx + bw - 12.0F, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, chevronCol);
                    }
                }
            }
        } else {
            TextRenderer tr = MinecraftClient.getInstance().textRenderer;
            int textY = (int) (animY + (bh - 8.0F) / 2.0F);
            context.drawCenteredTextWithShadow(tr, this.getMessage(), (int) (bx + bw / 2.0F), textY, this.active ? 0xFFFFFF : 0x888888);
        }

        if (pressedTransform) {
            custom.getMatrices().pop();
        }
    }
}
