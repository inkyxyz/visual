package moscow.rockstar.mixin.minecraft.client;

import net.minecraft.client.Keyboard;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.window.CharTypedEvent;
import pyrock.events.window.KeyEvent;
import pyrock.events.window.KeyPressEvent;
import rockstar.client.MenuModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIiiIi_Class270;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={Keyboard.class})
public class KeyboardMixin
implements iIIiIIiIi_Class294 {
    @Inject(method={"onKey"}, at={@At(value="HEAD")}, cancellable=true)
    public void triggerKeyEvent(long l, int n, int n2, int n3, int n4, CallbackInfo callbackInfo) {
        if (n == -1) {
            return;
        }
        if (n != 292 && GLFW.glfwGetKey((long)l, (int)292) == 1) {
            return;
        }
        if (n3 == 0) {
            MenuModule.II_method_c39aca01(n);
        }
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new KeyPressEvent(n3, n));
        KeyEvent keyEvent = new KeyEvent(n, n2, n3, n4);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(keyEvent);
        if (keyEvent.isCancelled() && !this.isEscapeHatch(n, n2)) {
            callbackInfo.cancel();
            return;
        }
        if (n == 46 && n3 == 1 && (n4 & 8) != 0) {
            iIIIIiiIi_Class270.I_method_b35dc8a5(l);
            return;
        }
        if (KeyboardMixin.I_field_3a9bda27.currentScreen != null) {
            return;
        }
        if (n == 46 && n3 == 1) {
            I_field_3a9bda27.setScreen((Screen)new ChatScreen(""));
        }
    }

    @Inject(method={"onChar"}, at={@At(value="HEAD")}, cancellable=true)
    private void triggerCharEvent(long l, int n, int n2, CallbackInfo callbackInfo) {
        CharTypedEvent charTypedEvent = new CharTypedEvent(n, n2);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(charTypedEvent);
        if (charTypedEvent.isCancelled()) {
            callbackInfo.cancel();
            return;
        }
        if (RockstarClient.getInstance().I_method_35687482() != null) {
            for (char c : Character.toChars(n)) {
                if (RockstarClient.getInstance().I_method_35687482().I_method_f4b450e9(c, n2)) continue;
                return;
            }
            callbackInfo.cancel();
        }
    }

    @Unique
    private boolean isEscapeHatch(int n, int n2) {
        if (n == 256 || n == 46) {
            return true;
        }
        if (KeyboardMixin.I_field_3a9bda27.options == null) {
            return false;
        }
        return KeyboardMixin.I_field_3a9bda27.options.chatKey.matchesKey(n, n2) || KeyboardMixin.I_field_3a9bda27.options.commandKey.matchesKey(n, n2);
    }
}

