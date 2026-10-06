package moscow.rockstar.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.SkyRendering;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.AmbienceModule;
import rockstar.client.RockstarClient;
import rockstar.client.SkyShaderModule;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIii_Class20;
import rockstar.client.iIiiiIiIi_Class374;

@Mixin(value={SkyRendering.class})
public class SkyRenderingMixin {
    @Redirect(method={"renderSky"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/systems/RenderSystem;setShaderColor(FFFF)V", ordinal=0))
    private void redirectSkyShaderColor(float f, float f2, float f3, float f4) {
        SkyShaderModule skyShader = SkyRenderingMixin.rockstar$skyShader();
        if (skyShader != null && skyShader.isEnabled() && skyShader.isDarkBackground()) {
            RenderSystem.setShaderColor(0.0f, 0.0f, 0.0f, 1.0f);
            return;
        }
        RenderSystem.setShaderColor(f, f2, f3, f4);
    }

    @Inject(method={"renderSky"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderCustomSkybox(float f, float f2, float f3, CallbackInfo callbackInfo) {
        SkyShaderModule skyShader = SkyRenderingMixin.rockstar$skyShader();
        if (skyShader != null && skyShader.isEnabled()) {
            // Let renderSky execute its base dome pass, shader renders on RETURN
            return;
        }

        AmbienceModule iIiIIIiIi_Class70 = SkyRenderingMixin.rockstar$ambience();
        if (iIiIIIiIi_Class70 == null || (!iIiIIIiIi_Class70.iiI_method_5f70fa43() && !iIiIIIiIi_Class70.isPresetActive())) {
            return;
        }
        if (!iIiIIIiIi_Class70.iII_method_5dae0a23() && !iIiIIIiIi_Class70.isPresetActive()) {
            return;
        }
        iIiiiIiIi_Class374.I_method_9f06b7ff(iIiIIIiIi_Class70.I_method_92d7d4ee(), SkyRenderingMixin.rockstar$skyTint(iIiIIIiIi_Class70));
        if (iIiIIIiIi_Class70.iIi_method_5dbc9603()) {
            SkyRenderingMixin.rockstar$renderShader(iIiIIIiIi_Class70);
        }
        callbackInfo.cancel();
    }

    @Inject(method={"renderSky"}, at={@At(value="RETURN")})
    private void rockstar$renderShaderOverVanillaSky(float f, float f2, float f3, CallbackInfo callbackInfo) {
        SkyShaderModule skyShader = SkyRenderingMixin.rockstar$skyShader();
        if (skyShader != null && skyShader.isEnabled()) {
            skyShader.renderSky();
            return;
        }

        AmbienceModule iIiIIIiIi_Class70 = SkyRenderingMixin.rockstar$ambience();
        if (iIiIIIiIi_Class70 == null || !iIiIIIiIi_Class70.iiI_method_5f70fa43()) {
            return;
        }
        if (iIiIIIiIi_Class70.iII_method_5dae0a23() || !iIiIIIiIi_Class70.iIi_method_5dbc9603()) {
            return;
        }
        SkyRenderingMixin.rockstar$renderShader(iIiIIIiIi_Class70);
    }

    @Inject(method={"renderSun"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$hideSun(float f, net.minecraft.client.render.VertexConsumerProvider vertexConsumerProvider, net.minecraft.client.util.math.MatrixStack matrixStack, CallbackInfo callbackInfo) {
        SkyShaderModule skyShader = SkyRenderingMixin.rockstar$skyShader();
        if (skyShader != null && skyShader.isEnabled() && skyShader.isHideSunMoon()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderMoon"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$hideMoon(int i, float f, net.minecraft.client.render.VertexConsumerProvider vertexConsumerProvider, net.minecraft.client.util.math.MatrixStack matrixStack, CallbackInfo callbackInfo) {
        SkyShaderModule skyShader = SkyRenderingMixin.rockstar$skyShader();
        if (skyShader != null && skyShader.isEnabled() && skyShader.isHideSunMoon()) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private static SkyShaderModule rockstar$skyShader() {
        if (RockstarClient.getInstance().getModuleManager() == null) {
            return null;
        }
        return RockstarClient.getInstance().getModuleManager().getModule(SkyShaderModule.class);
    }

    @Unique
    private static AmbienceModule rockstar$ambience() {
        if (RockstarClient.getInstance().getModuleManager() == null) {
            return null;
        }
        return RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
    }

    @Unique
    private static ColorRGBA rockstar$skyTint(AmbienceModule iIiIIIiIi_Class70) {
        if (iIiIIIiIi_Class70.isPresetActive()) {
            return iIiIIIiIi_Class70.getPresetSkyColor();
        }
        return iIiIIIiIi_Class70.I_method_d8b45030().isSelected() ? (iIiIIIiIi_Class70.I_method_26f48695().i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : iIiIIIiIi_Class70.I_method_28a872b5().I_method_bde5f08e()) : ColorRGBA.WHITE;
    }

    @Unique
    private static void rockstar$renderShader(AmbienceModule iIiIIIiIi_Class70) {
        float f = (float)(System.currentTimeMillis() % 100000000L) / 1000.0f;
        iIIii_Class20 iIIii_Class202 = iIiIIIiIi_Class70.I_method_7acc75f5();
        if (iIIii_Class202 != null) {
            iIiiiIiIi_Class374.I_method_3dd93e98(iIIii_Class202, SkyRenderingMixin.rockstar$skyTint(iIiIIIiIi_Class70), f, iIiIIIiIi_Class70.III_method_2712f62f());
        } else {
            iIiiiIiIi_Class374.I_method_9c2060ff(iIiIIIiIi_Class70.I_method_41ec5698(), SkyRenderingMixin.rockstar$skyTint(iIiIIIiIi_Class70), f, iIiIIIiIi_Class70.III_method_2712f62f());
        }
    }

    @Inject(method={"close"}, at={@At(value="HEAD")})
    private void closeCustomSkybox(CallbackInfo callbackInfo) {
        iIiiiIiIi_Class374.I_method_361bb5bf();
    }

    @Redirect(method={"renderStars"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/systems/RenderSystem;setShaderColor(FFFF)V", ordinal=0))
    private void redirectStarColor(float f, float f2, float f3, float f4) {
        SkyShaderModule skyShader = SkyRenderingMixin.rockstar$skyShader();
        if (skyShader != null && skyShader.isEnabled() && skyShader.isHideStars()) {
            RenderSystem.setShaderColor(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }

        if (RockstarClient.getInstance().getModuleManager() == null) {
            RenderSystem.setShaderColor((float)f, (float)f2, (float)f3, (float)f4);
            return;
        }
        AmbienceModule iIiIIIiIi_Class70 = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        if (iIiIIIiIi_Class70 == null) {
            RenderSystem.setShaderColor((float)f, (float)f2, (float)f3, (float)f4);
            return;
        }
        ColorRGBA colorRGBA;
        ColorRGBA colorRGBA2 = colorRGBA = iIiIIIiIi_Class70.I_method_26f48695().i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : iIiIIIiIi_Class70.II_method_67e4ec78().I_method_bde5f08e();
        if (iIiIIIiIi_Class70.isEnabled() && iIiIIIiIi_Class70.II_method_3ab96533().isSelected()) {
            RenderSystem.setShaderColor((float)(colorRGBA.getRed() / 255.0f), (float)(colorRGBA.getGreen() / 255.0f), (float)(colorRGBA.getBlue() / 255.0f), (float)(colorRGBA.getAlpha() / 255.0f));
        } else {
            RenderSystem.setShaderColor((float)f, (float)f2, (float)f3, (float)f4);
        }
    }
}

