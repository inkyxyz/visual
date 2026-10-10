package moscow.rockstar.mixin.minecraft.client.gui.widget;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiII_Class13;
import rockstar.client.IiiiiIIIi_Class242;

@Mixin(value = {SliderWidget.class})
public abstract class SliderWidgetMixin extends ClickableWidget {
    @Shadow
    protected double value;

    @Unique
    private float rockstar$hoverAnim = 0.0F;

    public SliderWidgetMixin(int x, int y, int width, int height, Text message) {
        super(x, y, width, height, message);
    }

    @Inject(method = "renderWidget", at = @At("HEAD"), cancellable = true)
    private void rockstar$renderMatteSlider(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ci.cancel();

        boolean isHovered = mouseX >= this.getX() && mouseX <= this.getX() + this.getWidth() &&
                            mouseY >= this.getY() && mouseY <= this.getY() + this.getHeight();

        float target = (isHovered && this.active) ? 1.0F : 0.0F;
        this.rockstar$hoverAnim += (target - this.rockstar$hoverAnim) * 0.22F;
        if (this.rockstar$hoverAnim < 0.001F) this.rockstar$hoverAnim = 0.0F;
        if (this.rockstar$hoverAnim > 0.999F) this.rockstar$hoverAnim = 1.0F;

        CustomDrawContext custom = (context instanceof CustomDrawContext cdc) ? cdc : new CustomDrawContext(context);

        float bx = (float) this.getX();
        float by = (float) this.getY();
        float bw = (float) this.getWidth();
        float bh = (float) this.getHeight();

        float rad = Math.min(bh / 2.0F, 8.0F);
        IIiii_Class8 radObj = IIiii_Class8.I_method_893b2757(rad);
        ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
        float widgetAlpha = this.alpha;

        // 1. Subtle drop shadow
        if (this.rockstar$hoverAnim > 0.01F) {
            custom.drawShadow(bx + 1.0F, by + bh - 1.0F, bw - 2.0F, 4.0F, 8.0F, radObj, new ColorRGBA(0.0F, 0.0F, 0.0F, 50.0F * this.rockstar$hoverAnim * widgetAlpha));
        }

        // 2. Liquid Frosted Glass Base
        ColorRGBA trackBase = this.active ?
            new ColorRGBA(20.0F, 24.0F, 34.0F, (105.0F + 30.0F * this.rockstar$hoverAnim) * widgetAlpha) :
            new ColorRGBA(16.0F, 18.0F, 24.0F, 65.0F * widgetAlpha);
        custom.drawRoundedRect(bx, by, bw, bh, radObj, trackBase);

        // 3. Top Specular Glass Sheen
        IIiii_Class8 topRad = new IIiii_Class8(rad, rad, 1.0F, 1.0F);
        float glossAlpha = (this.active ? (14.0F + 14.0F * this.rockstar$hoverAnim) : 5.0F) * widgetAlpha;
        custom.drawRoundedRect(bx + 1.0F, by + 1.0F, bw - 2.0F, bh * 0.40F, topRad, new ColorRGBA(255.0F, 255.0F, 255.0F, glossAlpha));

        // 4. Frosted Border
        ColorRGBA borderCol = this.active ?
            (this.rockstar$hoverAnim > 0.01F ? themeAccent.withAlpha((70.0F + 60.0F * this.rockstar$hoverAnim) * widgetAlpha) : new ColorRGBA(255.0F, 255.0F, 255.0F, 26.0F * widgetAlpha)) :
            new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F * widgetAlpha);
        custom.drawRoundedBorder(bx, by, bw, bh, 1.0F, radObj, borderCol);

        // 5. Slim Track Bar & Thumb at the bottom
        float clampedVal = (float) Math.max(0.0, Math.min(1.0, this.value));
        float trackX = bx + 8.0F;
        float trackH = 3.5F;
        float trackY = by + bh - trackH - 3.5F;
        float trackW = bw - 16.0F;
        IIiii_Class8 trackRad = IIiii_Class8.I_method_893b2757(trackH / 2.0F);

        // Track background groove
        custom.drawRoundedRect(trackX, trackY, trackW, trackH, trackRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F * widgetAlpha));

        // Track fill
        float fillW = Math.max(trackH, trackW * clampedVal);
        if (this.active && fillW > 0.0F) {
            ColorRGBA fillCol = themeAccent.withAlpha((190.0F + 50.0F * this.rockstar$hoverAnim) * widgetAlpha);
            custom.drawRoundedRect(trackX, trackY, fillW, trackH, trackRad, fillCol);
        }

        // Circular Thumb Knob sliding along track
        float thumbR = 4.0F;
        float thumbCx = trackX + trackW * clampedVal;
        float thumbCy = trackY + trackH / 2.0F;
        IIiii_Class8 thumbRad = IIiii_Class8.I_method_893b2757(thumbR);

        if (this.active) {
            custom.drawShadow(thumbCx - thumbR, thumbCy - thumbR, thumbR * 2.0F, thumbR * 2.0F, 4.0F, thumbRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F * widgetAlpha));
            custom.drawRoundedRect(thumbCx - thumbR, thumbCy - thumbR, thumbR * 2.0F, thumbR * 2.0F, thumbRad, ColorRGBA.WHITE.mulAlpha(widgetAlpha));
            custom.drawRoundedBorder(thumbCx - thumbR, thumbCy - thumbR, thumbR * 2.0F, thumbR * 2.0F, 0.9F, thumbRad, themeAccent.mulAlpha(widgetAlpha));
        } else {
            custom.drawRoundedRect(thumbCx - thumbR, thumbCy - thumbR, thumbR * 2.0F, thumbR * 2.0F, thumbRad, new ColorRGBA(140.0F, 145.0F, 155.0F, 160.0F * widgetAlpha));
        }

        // 6. Content Row: Mini Badge, Label (left), Value (right) - crystal clear in upper area
        String rawText = this.getMessage().getString();
        String lower = rawText.toLowerCase().trim();
        int colonIdx = rawText.indexOf(':');


        String badgeIcon = null;
        ColorRGBA badgeTop = new ColorRGBA(255.0F, 149.0F, 0.0F, 255.0F);
        ColorRGBA badgeBot = new ColorRGBA(255.0F, 59.0F, 48.0F, 255.0F);

        if (lower.contains("sound") || lower.contains("music") || lower.contains("volume") || lower.contains("master") || lower.contains("\u0437\u0432\u0443\u043a") || lower.contains("\u043c\u0443\u0437\u044b\u043a") || lower.contains("\u0433\u0440\u043e\u043c\u043a\u043e\u0441\u0442")) {
            badgeIcon = "music";
            badgeTop = new ColorRGBA(255.0F, 149.0F, 0.0F, 255.0F);
            badgeBot = new ColorRGBA(255.0F, 59.0F, 48.0F, 255.0F);
        } else if (lower.contains("fov") || lower.contains("\u043f\u043e\u043b\u0435") || lower.contains("\u0437\u0440\u0435\u043d")) {
            badgeIcon = "category/visuals";
            badgeTop = new ColorRGBA(52.0F, 199.0F, 89.0F, 255.0F);
            badgeBot = new ColorRGBA(40.0F, 170.0F, 70.0F, 255.0F);
        } else if (lower.contains("sens") || lower.contains("\u0447\u0443\u0432\u0441\u0442\u0432")) {
            badgeIcon = "keyboard";
            badgeTop = new ColorRGBA(175.0F, 82.0F, 222.0F, 255.0F);
            badgeBot = new ColorRGBA(88.0F, 86.0F, 214.0F, 255.0F);
        }

        // Only show badge when a distinct icon matches and button is wide enough
        boolean showBadge = badgeIcon != null && bw > 85.0F && bh >= 18.0F;
        float badgeSize = 9.5F;
        float badgeX = bx + 7.0F;
        float badgeY = by + 2.5F;
        IIiii_Class8 badgeRad = IIiii_Class8.I_method_893b2757(2.5F);

        if (showBadge) {
            custom.drawRoundedRect(badgeX, badgeY, badgeSize, badgeSize, badgeRad, new IiiII_Class13(badgeTop.mulAlpha(widgetAlpha * 0.9F), badgeBot.mulAlpha(widgetAlpha * 0.9F)));
            float iconSz = 6.0F;
            custom.drawIcon(badgeIcon, badgeX + (badgeSize - iconSz) / 2.0F, badgeY + (badgeSize - iconSz) / 2.0F, iconSz, ColorRGBA.WHITE.mulAlpha(widgetAlpha));
        }

        IIiIIi_Class10 font = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.5F);
            }
        } catch (Throwable ignored) {
        }

        if (font != null) {
            float labelX = showBadge ? (badgeX + badgeSize + 5.0F) : (bx + 8.0F);
            float textY = by + 3.0F;
            ColorRGBA labelCol = this.active ?
                (this.rockstar$hoverAnim > 0.01F ? ColorRGBA.WHITE : new ColorRGBA(240.0F, 245.0F, 255.0F, 245.0F * widgetAlpha)) :
                new ColorRGBA(135.0F, 140.0F, 150.0F, 140.0F * widgetAlpha);

            if (colonIdx > 0) {
                String label = rawText.substring(0, colonIdx).trim();
                String val = rawText.substring(colonIdx + 1).trim();

                float valW = font.I_method_2c375926(val);
                float valX = bx + bw - valW - 8.0F;

                float maxLabelW = valX - labelX - 8.0F;
                if (maxLabelW > 12.0F && font.I_method_2c375926(label) > maxLabelW) {
                    while (label.length() > 2 && font.I_method_2c375926(label + "...") > maxLabelW) {
                        label = label.substring(0, label.length() - 1);
                    }
                    label = label + "...";
                }

                custom.drawText(font, label, labelX, textY, labelCol);

                ColorRGBA valCol = new ColorRGBA(180.0F, 192.0F, 215.0F, 235.0F * widgetAlpha);
                custom.drawText(font, val, valX, textY, valCol);
            } else {
                float maxLabelW = bx + bw - labelX - 8.0F;
                String label = rawText;
                if (maxLabelW > 12.0F && font.I_method_2c375926(label) > maxLabelW) {
                    while (label.length() > 2 && font.I_method_2c375926(label + "...") > maxLabelW) {
                        label = label.substring(0, label.length() - 1);
                    }
                    label = label + "...";
                }
                custom.drawText(font, label, labelX, textY, labelCol);
            }
        } else {
            TextRenderer tr = MinecraftClient.getInstance().textRenderer;
            int textY = (int) (by + 2.0F);
            context.drawCenteredTextWithShadow(tr, this.getMessage(), (int) (bx + bw / 2.0F), textY, this.active ? 0xFFFFFF : 0x888888);
        }
    }
}
