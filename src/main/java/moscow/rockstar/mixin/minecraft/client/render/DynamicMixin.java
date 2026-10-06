package moscow.rockstar.mixin.minecraft.client.render;

import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.IiiiiiiII_Class253;

@Mixin(value={RenderTickCounter.Dynamic.class})
public class DynamicMixin {
    @Shadow
    private float field_51958;
    @Shadow
    private float field_51959;
    @Shadow
    private long field_51962;
    @Final
    @Shadow
    private float field_51964;

    @Inject(at={@At(value="FIELD", target="Lnet/minecraft/client/render/RenderTickCounter$Dynamic;prevTimeMillis:J", opcode=181, ordinal=0)}, method={"beginRenderTick(J)I"}, cancellable=true)
    public void onBeginRenderTick(long l, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (IiiiiiiII_Class253.I_method_1cb61e2f() == 1.0f) {
            return;
        }
        this.field_51958 = (float)(l - this.field_51962) / this.field_51964 * IiiiiiiII_Class253.I_method_1cb61e2f();
        this.field_51962 = l;
        this.field_51959 += this.field_51958;
        int n = (int)this.field_51959;
        this.field_51959 -= (float)n;
        callbackInfoReturnable.setReturnValue(n);
    }
}
