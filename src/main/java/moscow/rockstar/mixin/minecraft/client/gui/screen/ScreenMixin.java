package moscow.rockstar.mixin.minecraft.client.gui.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.IIIiIiIi_Class22;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={Screen.class})
public class ScreenMixin
implements iIIiIIiIi_Class294 {
    @org.spongepowered.asm.mixin.Unique private float rockstar$openProgress = 0.0F;
    @org.spongepowered.asm.mixin.Unique private long rockstar$lastFrameTime = 0L;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void rockstar$markScreenRender(net.minecraft.client.gui.DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo callbackInfo) {
        IIIiIiIi_Class22.I_method_40efa7e8(true);
        long now = System.currentTimeMillis();
        if (this.rockstar$lastFrameTime == 0L) {
            this.rockstar$lastFrameTime = now;
            rockstar.client.UISoundManager.playScreenOpen();
        }
        float dt = Math.min(0.05F, (float)(now - this.rockstar$lastFrameTime) / 1000.0F);
        this.rockstar$lastFrameTime = now;
        this.rockstar$openProgress = Math.min(1.0F, this.rockstar$openProgress + dt * 6.5F);

        float ease = 1.0F - (float)Math.pow(1.0F - this.rockstar$openProgress, 3.0);
        float scale = 0.94F + 0.06F * ease;

        Screen self = (Screen)(Object)this;
        drawContext.getMatrices().push();
        float cx = self.width / 2.0F;
        float cy = self.height / 2.0F;
        drawContext.getMatrices().translate(cx, cy, 0.0F);
        drawContext.getMatrices().scale(scale, scale, 1.0F);
        drawContext.getMatrices().translate(-cx, -cy, 0.0F);
    }

    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void rockstar$unmarkScreenRender(net.minecraft.client.gui.DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo callbackInfo) {
        drawContext.getMatrices().pop();
        IIIiIiIi_Class22.I_method_40efa7e8(false);
    }

    @Inject(method={"renderBackground"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$renderCustom3DBackground(net.minecraft.client.gui.DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        Screen self = (Screen)(Object)this;
        String screenClass = self.getClass().getName();
        if (self instanceof net.minecraft.client.gui.screen.option.GameOptionsScreen
                || self instanceof net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen
                || screenClass.contains("MultiplayerScreen")
                || screenClass.contains("SelectWorldScreen")
                || screenClass.contains("CreateWorldScreen")
                || screenClass.contains("EditWorldScreen")
                || screenClass.contains("AddServerScreen")
                || screenClass.contains("DirectConnectScreen")
                || screenClass.contains("EditServerScreen")
                || screenClass.contains("OptionsScreen")
                || screenClass.contains("PackScreen")
                || screenClass.contains("LanguageOptionsScreen")
                || screenClass.contains("VideoOptionsScreen")
                || screenClass.contains("SoundOptionsScreen")
                || screenClass.contains("AccessibilityOptionsScreen")
                || screenClass.contains("ChatOptionsScreen")
                || screenClass.contains("MouseOptionsScreen")
                || screenClass.contains("KeybindsScreen")) {
            ci.cancel();
            rockstar.client.III custom = rockstar.client.III.I_method_5728d20f(drawContext, mouseX, mouseY, delta);
            rockstar.client.IiiIIiIii_Class204.renderWallpaperBackground(custom, self.width, self.height, (float)mouseX, (float)mouseY);
            custom.drawRect(0.0F, 0.0F, (float)self.width, (float)self.height, new pyrock.utility.render.ColorRGBA(6.0F, 8.0F, 14.0F, 120.0F));
            if (self instanceof net.minecraft.client.gui.screen.option.OptionsScreen) {
                rockstar.client.OptionsScreenCards.renderCards(custom);
            }
        }
    }

    @Inject(method={"handleTextClick"}, at={@At(value="HEAD")}, cancellable=true)
    private void onHandleTextClick(Style style, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        String string;
        ClickEvent clickEvent = style.getClickEvent();
        if (clickEvent != null && clickEvent.getAction() == ClickEvent.Action.RUN_COMMAND && (string = clickEvent.getValue()).startsWith(RockstarClient.getInstance().I_method_b4d046cb().I_method_80ea594())) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            if (minecraftClient.player != null) {
                RockstarClient.getInstance().I_method_b4d046cb().I_method_9e86975a(string);
                callbackInfoReturnable.setReturnValue(true);
                callbackInfoReturnable.cancel();
            }
        }
    }
}

