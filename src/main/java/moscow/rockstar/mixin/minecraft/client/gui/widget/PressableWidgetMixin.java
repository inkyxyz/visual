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

        // 2. Determine layout: Separate icon pod vs button pill
        String rawText = this.getMessage().getString();
        String lower = rawText.toLowerCase().trim();
        BadgeStyle badge = BadgeStyle.getBadgeStyle(lower);

        int colonIdx = rawText.indexOf(':');
        boolean isToggle = lower.contains(": on") || lower.contains(": off") ||
                           lower.contains(": \u0432\u043a\u043b") || lower.contains(": \u0432\u044b\u043a\u043b") ||
                           lower.endsWith(" on") || lower.endsWith(" off");
        boolean isToggleOn = lower.contains(": on") || lower.contains(": \u0432\u043a\u043b") || lower.endsWith(" on");
        boolean isKeyValue = colonIdx > 0 && !isToggle;
        boolean isNav = rawText.trim().endsWith("...") || (lower.contains("setting") && !isKeyValue) || (lower.contains("\u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a") && !isKeyValue);
        boolean isCenteredAction = bw < 88.0F || lower.equals("done") || lower.equals("\u0433\u043e\u0442\u043e\u0432\u043e") ||
                                   lower.equals("cancel") || lower.equals("\u043e\u0442\u043c\u0435\u043d\u0430") ||
                                   lower.equals("back") || lower.equals("\u043d\u0430\u0437\u0430\u0434") ||
                                   lower.equals("reset") || lower.equals("\u0441\u0431\u0440\u043e\u0441");

        boolean showBadge = !isCenteredAction && bw >= 90.0F && bh >= 18.0F;

        // Decoupled icon pod position and main button body bounds
        float podSize = Math.max(20.0F, Math.min(bh - 2.0F, 24.0F));
        float podX = bx + 2.0F;
        float podY = animY + (bh - podSize) / 2.0F;

        float pillX = showBadge ? (podX + podSize + 5.0F) : bx;
        float pillW = showBadge ? (bw - (pillX - bx) - 2.0F) : bw;

        IIiii_Class8 topRad = new IIiii_Class8(rad, rad, 1.0F, 1.0F);

        // --- Render Separated Standalone Icon Pod ---
        if (showBadge) {
            IIiii_Class8 podRad = IIiii_Class8.I_method_893b2757(Math.min(7.0F, podSize / 2.8F));

            // Pod Drop Shadow & Frosted Glass Base
            if (this.rockstar$hoverAnim > 0.01F) {
                custom.drawShadow(podX, podY + podSize - 2.0F, podSize, 4.0F, 8.0F, podRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 65.0F * this.rockstar$hoverAnim * btnAlpha));
            }
            ColorRGBA podBase = this.active ?
                new ColorRGBA(24.0F, 28.0F, 38.0F, (120.0F + 35.0F * this.rockstar$hoverAnim) * btnAlpha) :
                new ColorRGBA(16.0F, 18.0F, 24.0F, 75.0F * btnAlpha);
            custom.drawRoundedRect(podX, podY, podSize, podSize, podRad, podBase);

            // Icon Accent Sheen
            custom.drawRoundedRect(podX + 1.0F, podY + 1.0F, podSize - 2.0F, podSize * 0.40F, podRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F * btnAlpha));

            // Pod Border
            ColorRGBA podBorder = this.active ?
                (this.rockstar$hoverAnim > 0.01F ? themeAccent.withAlpha((90.0F + 60.0F * this.rockstar$hoverAnim) * btnAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F * btnAlpha)) :
                new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F * btnAlpha);
            custom.drawRoundedBorder(podX, podY, podSize, podSize, 1.0F, podRad, podBorder);

            // Inner Gradient Glyph Icon
            float glyphSz = Math.max(12.0F, podSize - 4.0F);
            float glyphX = podX + (podSize - glyphSz) / 2.0F;
            float glyphY = podY + (podSize - glyphSz) / 2.0F;
            custom.drawIcon(badge.icon, glyphX, glyphY, glyphSz, this.active ? (this.rockstar$hoverAnim > 0.01F ? ColorRGBA.WHITE : new ColorRGBA(235.0F, 240.0F, 252.0F, 235.0F * btnAlpha)) : new ColorRGBA(140.0F, 145.0F, 155.0F, 140.0F * btnAlpha));
        }

        // --- Render Main Button Liquid Glass Pill ---
        if (this.rockstar$hoverAnim > 0.01F) {
            float shadowAlpha = (35.0F + 75.0F * this.rockstar$hoverAnim) * btnAlpha;
            custom.drawShadow(pillX + 1.0F, animY + bh - 1.0F, pillW - 2.0F, 5.0F, 12.0F, radObj, new ColorRGBA(0.0F, 0.0F, 0.0F, shadowAlpha));
        }

        ColorRGBA glassBase;
        if (this.active) {
            float baseA = (105.0F + 30.0F * this.rockstar$hoverAnim) * btnAlpha;
            glassBase = new ColorRGBA(20.0F, 24.0F, 34.0F, baseA);
        } else {
            glassBase = new ColorRGBA(16.0F, 18.0F, 24.0F, 65.0F * btnAlpha);
        }
        custom.drawRoundedRect(pillX, animY, pillW, bh, radObj, glassBase);

        // Hover Glow Sheen
        if (this.active && this.rockstar$hoverAnim > 0.01F) {
            custom.drawRoundedRect(pillX, animY, pillW, bh, radObj, themeAccent.withAlpha(35.0F * this.rockstar$hoverAnim * btnAlpha));
        }

        // Specular Top Sheen
        float glossAlpha = (this.active ? (14.0F + 14.0F * this.rockstar$hoverAnim) : 5.0F) * btnAlpha;
        custom.drawRoundedRect(pillX + 1.0F, animY + 1.0F, pillW - 2.0F, bh * 0.40F, topRad, new ColorRGBA(255.0F, 255.0F, 255.0F, glossAlpha));

        // Frosted Border
        ColorRGBA borderCol;
        if (this.active) {
            borderCol = this.rockstar$hoverAnim > 0.01F ?
                themeAccent.withAlpha((70.0F + 70.0F * this.rockstar$hoverAnim) * btnAlpha) :
                new ColorRGBA(255.0F, 255.0F, 255.0F, 26.0F * btnAlpha);
        } else {
            borderCol = new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F * btnAlpha);
        }
        custom.drawRoundedBorder(pillX, animY, pillW, bh, 1.0F, radObj, borderCol);

        // --- Render Label & Controls with Zero Overlap Clamping ---
        IIiIIi_Class10 font = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F);
            }
        } catch (Throwable ignored) {
        }

        if (font != null) {
            if (isCenteredAction) {
                float textW = font.I_method_2c375926(rawText);
                float textX = pillX + (pillW - textW) / 2.0F;
                ColorRGBA textCol = this.active ?
                    (this.rockstar$hoverAnim > 0.01F ? ColorRGBA.WHITE : new ColorRGBA(235.0F, 240.0F, 250.0F, 245.0F * btnAlpha)) :
                    new ColorRGBA(130.0F, 135.0F, 145.0F, 140.0F * btnAlpha);
                custom.drawText(font, rawText, textX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, textCol);
            } else {
                float labelX = pillX + 10.0F;
                ColorRGBA textCol = this.active ?
                    (this.rockstar$hoverAnim > 0.01F ? ColorRGBA.WHITE : new ColorRGBA(240.0F, 244.0F, 252.0F, 245.0F * btnAlpha)) :
                    new ColorRGBA(130.0F, 135.0F, 145.0F, 140.0F * btnAlpha);

                if (isToggle) {
                    float togglePillW = 28.0F, togglePillH = 15.0F;
                    float togglePillX = pillX + pillW - togglePillW - 7.0F;
                    float togglePillY = animY + (bh - togglePillH) / 2.0F;

                    // Text width protection: truncate with ellipsis so text NEVER passes behind toggle
                    String title = (colonIdx > 0) ? rawText.substring(0, colonIdx).trim() : rawText.trim();
                    float maxTitleW = togglePillX - labelX - 8.0F;
                    if (maxTitleW > 12.0F && font.I_method_2c375926(title) > maxTitleW) {
                        while (title.length() > 2 && font.I_method_2c375926(title + "...") > maxTitleW) {
                            title = title.substring(0, title.length() - 1);
                        }
                        title = title + "...";
                    }
                    custom.drawText(font, title, labelX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, textCol);

                    // Authentic Apple iOS Control Center Green Pill Toggle
                    IIiii_Class8 toggleRad = IIiii_Class8.I_method_893b2757(togglePillH / 2.0F);
                    ColorRGBA toggleBg = isToggleOn ?
                        new ColorRGBA(52.0F, 199.0F, 89.0F, 245.0F * btnAlpha) :
                        new ColorRGBA(55.0F, 60.0F, 72.0F, 220.0F * btnAlpha);
                    custom.drawRoundedRect(togglePillX, togglePillY, togglePillW, togglePillH, toggleRad, toggleBg);

                    // Knob thumb
                    float thumbSz = togglePillH - 3.0F;
                    float thumbX = isToggleOn ? (togglePillX + togglePillW - thumbSz - 1.5F) : (togglePillX + 1.5F);
                    custom.drawShadow(thumbX, togglePillY + 1.5F, thumbSz, thumbSz, 3.0F, IIiii_Class8.I_method_893b2757(thumbSz / 2.0F), new ColorRGBA(0.0F, 0.0F, 0.0F, 70.0F * btnAlpha));
                    custom.drawRoundedRect(thumbX, togglePillY + 1.5F, thumbSz, thumbSz, IIiii_Class8.I_method_893b2757(thumbSz / 2.0F), ColorRGBA.WHITE.mulAlpha(btnAlpha));
                } else if (isKeyValue) {
                    String title = rawText.substring(0, colonIdx).trim();
                    String val = rawText.substring(colonIdx + 1).trim();

                    float valW = font.I_method_2c375926(val);
                    float valX = pillX + pillW - valW - 9.0F;
                    float maxTitleW = valX - labelX - 8.0F;
                    if (maxTitleW > 12.0F && font.I_method_2c375926(title) > maxTitleW) {
                        while (title.length() > 2 && font.I_method_2c375926(title + "...") > maxTitleW) {
                            title = title.substring(0, title.length() - 1);
                        }
                        title = title + "...";
                    }

                    custom.drawText(font, title, labelX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, textCol);
                    ColorRGBA valCol = new ColorRGBA(165.0F, 175.0F, 195.0F, 220.0F * btnAlpha);
                    custom.drawText(font, val, valX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, valCol);
                } else {
                    float maxTitleW = (isNav ? (pillX + pillW - 18.0F) : (pillX + pillW - 10.0F)) - labelX;
                    String title = rawText;
                    if (maxTitleW > 12.0F && font.I_method_2c375926(title) > maxTitleW) {
                        while (title.length() > 2 && font.I_method_2c375926(title + "...") > maxTitleW) {
                            title = title.substring(0, title.length() - 1);
                        }
                        title = title + "...";
                    }
                    custom.drawText(font, title, labelX, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, textCol);

                    if (isNav) {
                        ColorRGBA chevronCol = new ColorRGBA(165.0F, 172.0F, 188.0F, 170.0F * btnAlpha);
                        custom.drawText(font, ">", pillX + pillW - 12.0F, animY + (bh - font.I_method_a649725c()) / 2.0F + 1.0F, chevronCol);
                    }
                }
            }
        } else {
            TextRenderer tr = MinecraftClient.getInstance().textRenderer;
            int textY = (int) (animY + (bh - 8.0F) / 2.0F);
            context.drawCenteredTextWithShadow(tr, this.getMessage(), (int) (pillX + pillW / 2.0F), textY, this.active ? 0xFFFFFF : 0x888888);
        }

        if (pressedTransform) {
            custom.getMatrices().pop();
        }
    }
}
