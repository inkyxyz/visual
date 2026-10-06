package moscow.rockstar.mixin.minecraft.client.gui.overlay;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Fog;
import net.minecraft.client.render.FogShape;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.CustomFogModule;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;

@Mixin(value={BackgroundRenderer.class})
public class BackgroundRendererMixin {
    @Inject(method={"getFogModifier(Lnet/minecraft/entity/Entity;F)Lnet/minecraft/client/render/BackgroundRenderer$StatusEffectFogModifier;"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onGetFogModifier(Entity entity, float f, CallbackInfoReturnable<Object> callbackInfoReturnable) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (!iIiIiIIiI_Class83.isEnabled()) {
            return;
        }
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.hasStatusEffect(StatusEffects.BLINDNESS)) {
                if (iIiIiIIiI_Class83.iII_method_63cd60b0().isSelected()) {
                    callbackInfoReturnable.setReturnValue(null);
                }
            } else if (livingEntity.hasStatusEffect(StatusEffects.DARKNESS) && iIiIiIIiI_Class83.iIi_method_69d55c90().isSelected()) {
                callbackInfoReturnable.setReturnValue(null);
            }
        }
    }

    @ModifyReturnValue(method={"applyFog"}, at={@At(value="RETURN")})
    private static Fog modifyFogProperties(Fog fog, @Local(argsOnly=true) Camera camera, @Local(argsOnly=true) BackgroundRenderer.FogType fogType, @Local(argsOnly=true, ordinal=0) float f) {
        CustomFogModule iIiIIiIII_Class73 = RockstarClient.getInstance().getModuleManager().getModule(CustomFogModule.class);
        if (iIiIIiIII_Class73.I_method_1c4312c4(camera) && fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
            float f2 = MathHelper.clamp((float)iIiIIiIII_Class73.I_method_59ceeb35().i_method_e92b420f(), (float)-8.0f, (float)f);
            float f3 = MathHelper.clamp((float)iIiIIiIII_Class73.I_method_59ceeb35().II_method_3a8908f2(), (float)0.0f, (float)f);
            ColorRGBA colorRGBA = iIiIIiIII_Class73.I_method_580bfef5().i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(iIiIIiIII_Class73.I_method_1102c335().Ii_method_a20abcd2() / 100.0f * 255.0f) : iIiIIiIII_Class73.I_method_59bfeb15().I_method_bde5f08e();
            FogShape fogShape = FogShape.SPHERE;
            float f4 = colorRGBA.getRed() / 255.0f;
            float f5 = colorRGBA.getGreen() / 255.0f;
            float f6 = colorRGBA.getBlue() / 255.0f;
            float f7 = colorRGBA.getAlpha() / 255.0f;
            return new Fog(f2, f3, fogShape, f4, f5, f6, f7);
        }
        if (RockstarClient.getInstance().getModuleManager() != null) {
            rockstar.client.AmbienceModule amb = RockstarClient.getInstance().getModuleManager().getModule(rockstar.client.AmbienceModule.class);
            if (amb != null && amb.isFogEnabled() && fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
                ColorRGBA fogCol = amb.getPresetFogColor();
                float f4 = fogCol.getRed() / 255.0f;
                float f5 = fogCol.getGreen() / 255.0f;
                float f6 = fogCol.getBlue() / 255.0f;
                float f7 = fogCol.getAlpha() / 255.0f;
                return new Fog(fog.start(), fog.end(), FogShape.SPHERE, f4, f5, f6, f7);
            }
        }
        return fog;
    }
}

