package moscow.rockstar.mixin.minecraft.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatInputSuggestor;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.game.SendMessageEvent;
import pyrock.events.render.ChatRenderEvent;
import pyrock.events.window.ChatClickEvent;
import pyrock.events.window.ChatKeyPressEvent;
import pyrock.events.window.ChatReleaseEvent;
import pyrock.events.window.ChatScrollEvent;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IIIiiiIi_Class30;
import rockstar.client.BeautifullyModule;
import rockstar.client.ViewModelModule;
import rockstar.client.ModuleManager;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={ChatScreen.class})
public class ChatScreenMixin
extends Screen
implements iIIiIIiIi_Class294 {
    @Shadow
    protected TextFieldWidget field_2382;
    @Shadow
    private ChatInputSuggestor field_21616;
    @Unique
    private long rockstar$openTime;
    @Unique
    private boolean rockstar$barShifted;

    protected ChatScreenMixin(Text text) {
        super(text);
    }

    @Inject(method={"init"}, at={@At(value="HEAD")})
    private void rockstar$startOpenAnimation(CallbackInfo callbackInfo) {
        this.rockstar$openTime = System.currentTimeMillis();
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/ChatHud;render(Lnet/minecraft/client/gui/DrawContext;IIIZ)V", shift=At.Shift.AFTER)})
    private void rockstar$pushInputAnimation(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        this.rockstar$barShifted = false;
        if (!BeautifullyModule.IiI_method_b163c683()) {
            return;
        }
        float f2 = (float)(System.currentTimeMillis() - this.rockstar$openTime) / 200.0f;
        if (f2 >= 1.0f || f2 < 0.0f) {
            return;
        }
        float f3 = IiiiIiiII_Class237.IIII_field_dd60aac.ease(f2, 0.0f, 1.0f, 1.0f);
        drawContext.draw();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f3);
        drawContext.getMatrices().push();
        drawContext.getMatrices().translate(0.0f, (1.0f - f3) * 16.0f, 0.0f);
        this.rockstar$barShifted = true;
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/util/math/MatrixStack;pop()V", ordinal=0, shift=At.Shift.AFTER)})
    private void rockstar$popInputAnimation(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!this.rockstar$barShifted) {
            return;
        }
        this.rockstar$barShifted = false;
        drawContext.draw();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        drawContext.getMatrices().pop();
    }

    @Inject(method={"sendMessage(Ljava/lang/String;Z)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendMessage(String string, boolean bl, CallbackInfo callbackInfo) {
        IIIiiiIi_Class30 iIIiiiIi_Class30 = RockstarClient.getInstance().I_method_b4d046cb();
        String string2 = iIIiiiIi_Class30.I_method_80ea594();
        if (!string2.isEmpty() && string.startsWith(string2 + string2)) {
            SendMessageEvent sendMessageEvent = new SendMessageEvent(string.substring(string2.length()));
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(sendMessageEvent);
            if (!sendMessageEvent.isCancelled()) {
                ChatScreenMixin.I_field_3a9bda27.player.networkHandler.sendChatMessage(sendMessageEvent.getMessage());
            }
            ChatScreenMixin.I_field_3a9bda27.inGameHud.getChatHud().addToMessageHistory(string);
            callbackInfo.cancel();
            return;
        }
        if (!string2.isEmpty() && string.startsWith(string2)) {
            iIIiiiIi_Class30.I_method_9e86975a(string);
            ChatScreenMixin.I_field_3a9bda27.inGameHud.getChatHud().addToMessageHistory(string);
            callbackInfo.cancel();
            return;
        }
        SendMessageEvent sendMessageEvent = new SendMessageEvent(string);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(sendMessageEvent);
        if (sendMessageEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"keyPressed(III)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void onTab(int n, int n2, int n3, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (RockstarClient.getInstance().I_method_35687482() != null && RockstarClient.getInstance().I_method_35687482().I_method_f4b70b23(n, n3)) {
            callbackInfoReturnable.setReturnValue(true);
            return;
        }
        if (n != 256 && RockstarClient.getInstance().I_method_35687482() != null && RockstarClient.getInstance().I_method_35687482().I_method_a22acbc8(n, n2, n3)) {
            callbackInfoReturnable.setReturnValue(true);
            return;
        }
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ChatKeyPressEvent(n, n2, n3));
    }

    @Inject(method={"render"}, at={@At(value="RETURN")})
    public void render(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ChatRenderEvent(CustomDrawContext.of(drawContext), f));
    }

    @Inject(method={"mouseClicked"}, at={@At(value="HEAD")})
    private void onMouseClick(double d, double d2, int n, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ChatClickEvent((float)d, (float)d2, n));
    }

    @Inject(method={"mouseScrolled"}, at={@At(value="HEAD")}, cancellable=true)
    private void onMouseScroll(double d, double d2, double d3, double d4, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        ViewModelModule iIiIiiIIi_Class90;
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ChatScrollEvent((float)d, (float)d2, (float)d3, (float)d4));
        ModuleManager iiIiiiIi_Class94 = RockstarClient.getInstance().getModuleManager();
        ViewModelModule iIiIiiIIi_Class902 = iIiIiiIIi_Class90 = iiIiiiIi_Class94 == null ? null : iiIiiiIi_Class94.getModule(ViewModelModule.class);
        if (iIiIiiIIi_Class90 != null && iIiIiiIIi_Class90.I_method_acdecd65((float)d, (float)d2, (float)d4)) {
            callbackInfoReturnable.setReturnValue(true);
        }
    }

    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ChatReleaseEvent((float)mouseX, (float)mouseY, button));
        return true;
    }
}

