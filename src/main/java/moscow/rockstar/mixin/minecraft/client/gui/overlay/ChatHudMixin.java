package moscow.rockstar.mixin.minecraft.client.gui.overlay;

import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.gui.hud.MessageIndicator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.BeautifullyModule;
import rockstar.client.IiiiIiiII_Class237;

@Mixin(value={ChatHud.class})
public abstract class ChatHudMixin {
    @Unique
    private static final float ROCKSTAR_FADE_TICKS = 4.0f;
    @Unique
    private static final float ROCKSTAR_SHIFT = 12.0f;
    @Unique
    private static final float ROCKSTAR_BAR_HEIGHT = 16.0f;
    @Shadow
    @Final
    private List<ChatHudLine.Visible> field_2064;
    @Shadow
    private int field_2066;
    @Unique
    private static boolean rockstar$animate;
    @Unique
    private static float rockstar$tick;
    @Unique
    private static boolean rockstar$focused;
    @Unique
    private static boolean rockstar$wasFocused;
    @Unique
    private static long rockstar$openStart;
    @Unique
    private static long rockstar$closeStart;
    @Unique
    private static int rockstar$focusedLines;
    @Unique
    private static float rockstar$lineOpacity;
    @Unique
    private static float rockstar$lineAlpha;
    @Unique
    private static float rockstar$lineShift;
    @Unique
    private static int rockstar$linesBefore;
    @Unique
    private static float rockstar$slideLines;
    @Unique
    private static long rockstar$slideStart;
    @Unique
    private static boolean rockstar$shifted;

    @Shadow
    public abstract int method_44752();

    @Shadow
    public abstract double method_1814();

    @Inject(method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V"}, at={@At(value="HEAD")})
    private void rockstar$rememberLineCount(Text text, MessageSignatureData messageSignatureData, MessageIndicator messageIndicator, CallbackInfo callbackInfo) {
        rockstar$linesBefore = this.field_2064.size();
    }

    @Inject(method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V"}, at={@At(value="TAIL")})
    private void rockstar$startSlide(Text text, MessageSignatureData messageSignatureData, MessageIndicator messageIndicator, CallbackInfo callbackInfo) {
        if (!BeautifullyModule.IiI_method_b163c683() || this.field_2066 > 0) {
            return;
        }
        int n = this.field_2064.size() - rockstar$linesBefore;
        if (n <= 0) {
            return;
        }
        rockstar$slideLines = Math.min(4, n);
        rockstar$slideStart = System.currentTimeMillis();
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void rockstar$beginRender(DrawContext drawContext, int n, int n2, int n3, boolean bl, CallbackInfo callbackInfo) {
        rockstar$animate = BeautifullyModule.IiI_method_b163c683();
        rockstar$tick = (float)n + MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false);
        rockstar$focused = bl;
        rockstar$lineOpacity = 1.0f;
        rockstar$lineAlpha = 1.0f;
        rockstar$lineShift = 0.0f;
        rockstar$shifted = false;
        if (bl != rockstar$wasFocused) {
            rockstar$wasFocused = bl;
            if (bl) {
                rockstar$openStart = System.currentTimeMillis();
            } else {
                rockstar$closeStart = System.currentTimeMillis();
            }
        }
        if (!rockstar$animate || rockstar$slideStart == Long.MIN_VALUE) {
            return;
        }
        float f = (float)(System.currentTimeMillis() - rockstar$slideStart) / 200.0f;
        if (f >= 1.0f || f < 0.0f) {
            return;
        }
        float f2 = 1.0f - IiiiIiiII_Class237.IIII_field_dd60aac.ease(f, 0.0f, 1.0f, 1.0f);
        float f3 = f2 * rockstar$slideLines * this.method_44752() * (float)this.method_1814();
        if (f3 <= 0.05f) {
            return;
        }
        drawContext.enableScissor(0, 0, drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight() - 40);
        drawContext.getMatrices().push();
        drawContext.getMatrices().translate(0.0f, f3, 0.0f);
        rockstar$shifted = true;
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void rockstar$endRender(DrawContext drawContext, int n, int n2, int n3, boolean bl, CallbackInfo callbackInfo) {
        if (rockstar$shifted) {
            rockstar$shifted = false;
            drawContext.getMatrices().pop();
            drawContext.disableScissor();
        }
        this.rockstar$drawClosingInput(drawContext);
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Ljava/util/List;get(I)Ljava/lang/Object;", ordinal=0))
    private Object rockstar$captureLine(List<ChatHudLine.Visible> list, int n) {
        float f;
        ChatHudLine.Visible visible = list.get(n);
        rockstar$lineOpacity = 1.0f;
        rockstar$lineAlpha = 1.0f;
        rockstar$lineShift = 0.0f;
        if (!rockstar$animate || !(visible instanceof ChatHudLine.Visible)) {
            return visible;
        }
        ChatHudLine.Visible visible2 = visible;
        float f2 = ChatHudMixin.rockstar$life(rockstar$tick - (float)visible2.addedTime());
        if (rockstar$focused) {
            rockstar$lineAlpha = f = MathHelper.lerp((float)ChatHudMixin.rockstar$openProgress(), (float)f2, (float)1.0f);
        } else {
            rockstar$lineOpacity = f = Math.max(f2, ChatHudMixin.rockstar$closeFade());
        }
        rockstar$lineShift = (1.0f - f) * 12.0f;
        return visible;
    }

    @ModifyConstant(method={"render"}, constant={@Constant(intValue=200)})
    private int rockstar$keepClosingLines(int n) {
        if (!rockstar$animate || rockstar$focused || ChatHudMixin.rockstar$closeFade() <= 0.0f) {
            return n;
        }
        return Integer.MAX_VALUE;
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/ChatHud;getMessageOpacityMultiplier(I)D"))
    private static double rockstar$messageOpacity(int n) {
        if (!rockstar$animate) {
            return ChatHudMixin.rockstar$life(n);
        }
        return rockstar$lineOpacity;
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/ChatHud;getVisibleLineCount()I"))
    private int rockstar$visibleLineCount(ChatHud chatHud) {
        int n = chatHud.getVisibleLineCount();
        if (rockstar$focused) {
            rockstar$focusedLines = n;
            return n;
        }
        if (!rockstar$animate || ChatHudMixin.rockstar$closeFade() <= 0.0f) {
            return n;
        }
        return Math.max(n, rockstar$focusedLines);
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=0))
    private void rockstar$fillLine(DrawContext drawContext, int n, int n2, int n3, int n4, int n5) {
        this.rockstar$fillAnimated(drawContext, n, n2, n3, n4, n5);
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=1))
    private void rockstar$fillIndicator(DrawContext drawContext, int n, int n2, int n3, int n4, int n5) {
        this.rockstar$fillAnimated(drawContext, n, n2, n3, n4, n5);
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)I", ordinal=0))
    private int rockstar$drawLine(DrawContext drawContext, TextRenderer textRenderer, OrderedText orderedText, int n, int n2, int n3) {
        if (!ChatHudMixin.rockstar$lineAnimated()) {
            return drawContext.drawTextWithShadow(textRenderer, orderedText, n, n2, n3);
        }
        int n4 = ChatHudMixin.rockstar$fade(n3);
        if (ChatHudMixin.rockstar$invisible(n4)) {
            return 0;
        }
        MatrixStack matrixStack = drawContext.getMatrices();
        matrixStack.translate(-rockstar$lineShift, 0.0f, 0.0f);
        int n5 = drawContext.drawTextWithShadow(textRenderer, orderedText, n, n2, n4);
        matrixStack.translate(rockstar$lineShift, 0.0f, 0.0f);
        return n5;
    }

    @Unique
    private void rockstar$fillAnimated(DrawContext drawContext, int n, int n2, int n3, int n4, int n5) {
        if (!ChatHudMixin.rockstar$lineAnimated()) {
            drawContext.fill(n, n2, n3, n4, n5);
            return;
        }
        int n6 = ChatHudMixin.rockstar$fade(n5);
        if (ChatHudMixin.rockstar$invisible(n6)) {
            return;
        }
        MatrixStack matrixStack = drawContext.getMatrices();
        matrixStack.translate(-rockstar$lineShift, 0.0f, 0.0f);
        drawContext.fill(n, n2, n3, n4, n6);
        matrixStack.translate(rockstar$lineShift, 0.0f, 0.0f);
    }

    @Unique
    private void rockstar$drawClosingInput(DrawContext drawContext) {
        if (!rockstar$animate || rockstar$focused) {
            return;
        }
        float f = ChatHudMixin.rockstar$closeFade();
        if (f <= 0.0f) {
            return;
        }
        int n = drawContext.getScaledWindowWidth();
        int n2 = drawContext.getScaledWindowHeight();
        int n3 = MinecraftClient.getInstance().options.getTextBackgroundColor(Integer.MIN_VALUE);
        int n4 = MathHelper.clamp((int)((int)((float)(n3 >>> 24) * f)), (int)0, (int)255);
        MatrixStack matrixStack = drawContext.getMatrices();
        matrixStack.push();
        matrixStack.translate(0.0f, (1.0f - f) * 16.0f, 0.0f);
        drawContext.fill(2, n2 - 14, n - 2, n2 - 2, n3 & 0xFFFFFF | n4 << 24);
        matrixStack.pop();
    }

    @Unique
    private static boolean rockstar$lineAnimated() {
        return rockstar$lineShift != 0.0f || rockstar$lineAlpha < 1.0f;
    }

    @Unique
    private static float rockstar$life(float f) {
        float f2 = MathHelper.clamp((float)((200.0f - f) / 4.0f), (float)0.0f, (float)1.0f);
        return f2 * f2;
    }

    @Unique
    private static float rockstar$openProgress() {
        if (rockstar$openStart == Long.MIN_VALUE) {
            return 1.0f;
        }
        float f = (float)(System.currentTimeMillis() - rockstar$openStart) / 200.0f;
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return IiiiIiiII_Class237.IIII_field_dd60aac.ease(f, 0.0f, 1.0f, 1.0f);
    }

    @Unique
    private static float rockstar$closeFade() {
        if (rockstar$closeStart == Long.MIN_VALUE) {
            return 0.0f;
        }
        float f = (float)(System.currentTimeMillis() - rockstar$closeStart) / 200.0f;
        if (f <= 0.0f) {
            return 1.0f;
        }
        if (f >= 1.0f) {
            return 0.0f;
        }
        return 1.0f - IiiiIiiII_Class237.IIII_field_dd60aac.ease(f, 0.0f, 1.0f, 1.0f);
    }

    @Unique
    private static boolean rockstar$invisible(int n) {
        return (n & 0xFC000000) == 0;
    }

    @Unique
    private static int rockstar$fade(int n) {
        if (rockstar$lineAlpha >= 1.0f) {
            return n;
        }
        int n2 = MathHelper.clamp((int)((int)((float)(n >>> 24) * rockstar$lineAlpha)), (int)0, (int)255);
        return n & 0xFFFFFF | n2 << 24;
    }

    static {
        rockstar$openStart = Long.MIN_VALUE;
        rockstar$closeStart = Long.MIN_VALUE;
        rockstar$lineOpacity = 1.0f;
        rockstar$lineAlpha = 1.0f;
        rockstar$slideStart = Long.MIN_VALUE;
    }
}
