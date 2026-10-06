package moscow.rockstar.mixin.minecraft.client;

import net.minecraft.client.Mouse;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.window.MouseButtonEvent;
import pyrock.events.window.MouseEvent;
import pyrock.events.window.MouseMoveEvent;
import pyrock.events.window.MouseScrollEvent;
import pyrock.events.window.ScrollEvent;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={Mouse.class})
public class MouseMixin
implements iIIiIIiIi_Class294 {
    @Unique
    private double rockstar$lastCursorX;
    @Unique
    private double rockstar$lastCursorY;

    @Inject(method={"tick()V"}, at={@At(value="RETURN")})
    private void tick(CallbackInfo callbackInfo) {
        if (iIIIiIIiI_Class275.I_method_696f36b5() != iIIIiIIiI_Class275.i_method_7f04aa95()) {
            GLFW.glfwSetCursor((long)I_field_3a9bda27.getWindow().getHandle(), (long)iIIIiIIiI_Class275.I_method_696f36b5().I_method_a72b15d3());
        }
        iIIIiIIiI_Class275.i_method_84ed4087(iIIIiIIiI_Class275.I_method_696f36b5());
        iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.I_field_aa52e62c);
    }

    @Inject(method={"onMouseButton"}, at={@At(value="HEAD")}, cancellable=true)
    private void onMouseButton(long l, int n, int n2, int n3, CallbackInfo callbackInfo) {
        if (n2 == 1) {
            if (GLFW.glfwGetKey((long)l, (int)292) == 1) {
                return;
            }
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseEvent(n, n2));
        }
        MouseButtonEvent mouseButtonEvent = new MouseButtonEvent(n, n2, n3);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(mouseButtonEvent);
        if (mouseButtonEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onMouseScroll"}, at={@At(value="HEAD")}, cancellable=true)
    private void onMouseScroll(long l, double d, double d2, CallbackInfo callbackInfo) {
        if (d2 != 0.0) {
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseScrollEvent(d2));
        }
        ScrollEvent scrollEvent = new ScrollEvent(d, d2);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(scrollEvent);
        if (scrollEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onCursorPos"}, at={@At(value="HEAD")})
    private void onCursorPos(long l, double d, double d2, CallbackInfo callbackInfo) {
        if (l != I_field_3a9bda27.getWindow().getHandle()) {
            return;
        }
        double d3 = d - this.rockstar$lastCursorX;
        double d4 = d2 - this.rockstar$lastCursorY;
        this.rockstar$lastCursorX = d;
        this.rockstar$lastCursorY = d2;
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseMoveEvent(d, d2, d3, d4));
    }
}

