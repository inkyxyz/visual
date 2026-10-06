package moscow.rockstar.mixin.minecraft.client.render;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.ObjectAllocator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.profiler.Profilers;
import net.minecraft.world.BlockRenderView;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.render.Render3DEvent;
import rockstar.client.AmbienceModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiiIIIIi_Class354;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiIiIII_Class361;

@Mixin(value={WorldRenderer.class})
public abstract class WorldRendererMixin
implements iIIiIIiIi_Class294 {
    private MatrixStack renderEventStack;

    private MatrixStack rockstar$renderEventStack() {
        if (this.renderEventStack == null) {
            this.renderEventStack = new MatrixStack();
        }
        return this.renderEventStack;
    }

    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void render(ObjectAllocator objectAllocator, RenderTickCounter renderTickCounter, boolean bl, Camera camera, GameRenderer gameRenderer, Matrix4f matrix4f, Matrix4f matrix4f2, CallbackInfo callbackInfo) {
        Profilers.get().swap(RockstarClient.II_field_523beb0a + "_renderWorld");
        this.applyWetWorld(camera, matrix4f, matrix4f2, renderTickCounter.getTickDelta(false));
        this.applySaturation();
        MatrixStack matrixStack = this.rockstar$renderEventStack();
        matrixStack.push();
        matrixStack.multiplyPositionMatrix(matrix4f);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new Render3DEvent(matrixStack, matrix4f, matrix4f2, camera, renderTickCounter.getTickDelta(false)));
        matrixStack.pop();
    }

    @Inject(method={"getLightmapCoordinates(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)I"}, at={@At(value="RETURN")}, cancellable=true)
    private static void applyDynamicLight(BlockRenderView blockRenderView, BlockState blockState, BlockPos blockPos, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue(iIiiIIIIi_Class354.I_method_4661a45d(blockPos, iIiiIiIII_Class361.I_method_fe9701d(blockPos, callbackInfoReturnable.getReturnValueI())));
    }

    private void applyWetWorld(Camera camera, Matrix4f matrix4f, Matrix4f matrix4f2, float f) {
        AmbienceModule iIiIIIiIi_Class70 = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        if (iIiIIIiIi_Class70 == null || !iIiIIIiIi_Class70.IIII_method_bb5ac906()) {
            return;
        }
        if (iIiiIIiii_Class360.I_field_856cfe41 == null || WorldRendererMixin.I_field_3a9bda27.world == null || camera == null || !camera.isReady()) {
            return;
        }
        iIiiIIiii_Class360.I_field_856cfe41.I_method_49242388(iIiIIIiIi_Class70.I_method_7a5208f2(matrix4f, matrix4f2, camera, f));
    }

    private void applySaturation() {
        AmbienceModule iIiIIIiIi_Class70 = RockstarClient.getInstance().getModuleManager().getModule(AmbienceModule.class);
        if (iIiIIIiIi_Class70 == null || !iIiIIIiIi_Class70.iii_method_5f7f8623()) {
            return;
        }
        if (iIiiIIiii_Class360.I_field_83aa1201 == null) {
            return;
        }
        Vector3f vector3f = iIiIIIiIi_Class70.i_method_c1bfe21a();
        iIiiIIiii_Class360.I_field_83aa1201.I_method_5a664c(iIiIIIiIi_Class70.i_method_d4ac91af(), vector3f.x, vector3f.y, vector3f.z, iIiIIIiIi_Class70.II_method_bf31ad52(), iIiIIIiIi_Class70.Ii_method_bf403932(), iIiIIIiIi_Class70.iI_method_c0f49d72(), iIiIIIiIi_Class70.ii_method_c1032952());
    }
}

