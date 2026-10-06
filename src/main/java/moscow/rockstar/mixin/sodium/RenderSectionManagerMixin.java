package moscow.rockstar.mixin.sodium;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import rockstar.client.CustomFogModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;

@Pseudo
@Mixin(targets={"net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager"}, remap=false)
public class RenderSectionManagerMixin
implements iIIiIIiIi_Class294 {
    @ModifyReturnValue(method={"getEffectiveRenderDistance(Lnet/minecraft/client/render/Fog;)F", "getEffectiveRenderDistance(Lnet/minecraft/class_9958;)F"}, at={@At(value="RETURN")}, require=0)
    private float keepRenderDistance(float f) {
        if (RenderSectionManagerMixin.I_field_3a9bda27.options == null || RenderSectionManagerMixin.I_field_3a9bda27.gameRenderer == null) {
            return f;
        }
        CustomFogModule iIiIIiIII_Class73 = RockstarClient.getInstance().getModuleManager().getModule(CustomFogModule.class);
        if (iIiIIiIII_Class73 == null || !iIiIIiIII_Class73.I_method_1c4312c4(RenderSectionManagerMixin.I_field_3a9bda27.gameRenderer.getCamera())) {
            return f;
        }
        return Math.max(f, (float)RenderSectionManagerMixin.I_field_3a9bda27.options.getClampedViewDistance() * 16.0f);
    }
}

