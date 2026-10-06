package moscow.rockstar.mixin.minecraft.client.gui.screen;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.render.GameRendererEvent;
import rockstar.client.AspectRatioModule;
import rockstar.client.IIIiIiIi_Class22;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIiiIIiiI_Class359;
import rockstar.client.iIiiiiIII_Class377;
import rockstar.client.iiIIiIiII_Class405;

@Mixin(value={GameRenderer.class})
public abstract class GameRendererMixin {
    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/MinecraftClient;isFinishedLoading()Z", shift=At.Shift.AFTER)})
    public void triggerGameRendererEvent(RenderTickCounter renderTickCounter, boolean bl, CallbackInfo callbackInfo) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new GameRendererEvent());
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void rockstar$resetDrawCalls(RenderTickCounter renderTickCounter, boolean bl, CallbackInfo callbackInfo) {
        iIiiIIiiI_Class359.i_method_132871ff();
    }

    @Inject(method={"renderWorld"}, at={@At(value="RETURN")})
    private void rockstar$applyWorldPatches(RenderTickCounter renderTickCounter, CallbackInfo callbackInfo) {
        IIIiIiIi_Class22.I_method_40ef6817(0);
        rockstar.client.MotionBlurModule.onRenderWorldEnd();
    }

    @Redirect(method={"findCrosshairTarget"}, at=@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;getRotationVec(F)Lnet/minecraft/util/math/Vec3d;"))
    private Vec3d rockstar$useServerRotationForEntityRaytrace(Entity entity, float f) {
        if (entity != MinecraftClient.getInstance().player) {
            return entity.getRotationVec(f);
        }
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
        return iiIIiIiII_Class4052.I_method_3d166e03() ? entity.getRotationVec(f) : iiIIiIiII_Class4052.II_method_f098f858().I_method_cbcdd559();
    }

    @Inject(method={"renderWorld"}, at={@At(value="INVOKE_STRING", target="Lnet/minecraft/util/profiler/Profiler;swap(Ljava/lang/String;)V", args={"ldc=hand"})})
    private void onRenderWorld(RenderTickCounter renderTickCounter, CallbackInfo callbackInfo, @Local(ordinal=0) Matrix4f matrix4f, @Local(ordinal=2) Matrix4f matrix4f2, @Local(ordinal=1) float f, @Local MatrixStack matrixStack) {
        iIiiiiIII_Class377.I_method_29c8dc1f(matrix4f2, matrix4f);
    }

    @Inject(method={"tiltViewWhenHurt"}, at={@At(value="HEAD")}, cancellable=true)
    private void tiltViewWhenHurtHook(MatrixStack matrixStack, float f, CallbackInfo callbackInfo) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.I_method_b2404c70().isSelected()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"getBasicProjectionMatrix"}, at={@At(value="RETURN")}, cancellable=true)
    private void rockstar$modifyAspectRatio(float fov, CallbackInfoReturnable<Matrix4f> cir) {
        if (RockstarClient.getInstance().getModuleManager() != null) {
            AspectRatioModule mod = RockstarClient.getInstance().getModuleManager().getModule(AspectRatioModule.class);
            if (mod != null && mod.isEnabled()) {
                Matrix4f modified = mod.modifyProjection((Matrix4f)cir.getReturnValue(), fov);
                if (modified != null) {
                    cir.setReturnValue(modified);
                }
            }
        }
    }

    @Inject(method = {"renderBlur"}, at = {@At(value = "HEAD")}, cancellable = true)
    private void rockstar$cancelScreenBlur(CallbackInfo callbackInfo) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.currentScreen instanceof rockstar.client.IiiIIiiiI_Class207
            || client.currentScreen instanceof rockstar.client.IiiIiIiiI_Class215) {
            callbackInfo.cancel();
        }
    }
}

