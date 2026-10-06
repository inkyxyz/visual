package moscow.rockstar.mixin.minecraft.client.render;

import net.minecraft.client.render.Fog;
import net.minecraft.client.render.FrameGraphBuilder;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={WorldRenderer.class})
public abstract class WeatherRendererMixin
implements iIIiIIiIi_Class294 {
    @Inject(method={"renderWeather"}, at={@At(value="HEAD")})
    private void onRenderWeather(FrameGraphBuilder frameGraphBuilder, Vec3d vec3d, float f, Fog fog, CallbackInfo callbackInfo) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.IIII_method_37aa6c93().isSelected() && WeatherRendererMixin.I_field_3a9bda27.world != null) {
            WeatherRendererMixin.I_field_3a9bda27.world.setRainGradient(0.0f);
            WeatherRendererMixin.I_field_3a9bda27.world.setThunderGradient(0.0f);
        }
    }
}

