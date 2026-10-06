package moscow.rockstar.mixin.minecraft.world;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.LightmapTextureManager;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.AmbienceModule;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;

@Mixin(value={LightmapTextureManager.class})
public class MixinLightmapTextureManager {
    @Shadow
    @Final
    private SimpleFramebuffer field_53101;
    @Shadow
    private boolean field_4135;
    @Unique
    private boolean rockstar$compositionWasActive;

    @Inject(method={"update"}, at={@At(value="HEAD")})
    private void rockstar$forceNightModeRefresh(float f, CallbackInfo callbackInfo) {
        AmbienceModule ambience = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        boolean active = ambience != null && ambience.isCompositionActive();
        if (active || this.rockstar$compositionWasActive) {
            this.field_4135 = true;
        }
        this.rockstar$compositionWasActive = active;
    }

    @Inject(method={"getDarknessFactor"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetDarknessFactor(float f, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        RemovalsModule removals = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (removals.isEnabled() && removals.iIi_method_69d55c90().isSelected()) {
            callbackInfoReturnable.setReturnValue(Float.valueOf(0.0f));
        }
    }

    @Inject(method={"update"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gl/SimpleFramebuffer;beginWrite(Z)V")})
    private void rockstar$applyNightModeUniforms(float f, CallbackInfo callbackInfo, @Local ShaderProgram shaderProgram) {
        AmbienceModule ambience = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        if (ambience == null || !ambience.isCompositionActive()) {
            shaderProgram.getUniformOrDefault("RockstarNightStrength").set(0.0f);
            shaderProgram.getUniformOrDefault("RockstarNightTint").set(1.0f, 1.0f, 1.0f);
            return;
        }
        Vector3f tint = ambience.getCompositionVector3f();
        float strength = ambience.getCompositionStrength();
        shaderProgram.getUniformOrDefault("RockstarNightTint").set(tint);
        shaderProgram.getUniformOrDefault("RockstarNightStrength").set(strength);
    }
}
