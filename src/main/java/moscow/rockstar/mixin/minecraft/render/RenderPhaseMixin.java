package moscow.rockstar.mixin.minecraft.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.IIIiIiIi_Class22;
import rockstar.client.ViewModelModule;
import rockstar.client.IiiiiIii_Class124;
import rockstar.client.Iiiiiiii_Class128;
import rockstar.client.iIIIIIII_Class129;
import rockstar.client.iIIIIIiI_Class131;

@Environment(value=EnvType.CLIENT)
@Mixin(value={RenderPhase.class})
public abstract class RenderPhaseMixin {
    @Inject(method={"startDrawing"}, at={@At(value="HEAD")}, cancellable=true)
    private void chams$skipTargetStart(CallbackInfo callbackInfo) {
        if (this.chams$capturingElsewhere() && (Object)(Object)(Object)(Object)(Object)(Object)this instanceof RenderPhase.Target) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"endDrawing"}, at={@At(value="HEAD")}, cancellable=true)
    private void chams$skipTargetEnd(CallbackInfo callbackInfo) {
        if (this.chams$capturingElsewhere() && (Object)(Object)(Object)(Object)(Object)(Object)this instanceof RenderPhase.Target) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private boolean chams$capturingElsewhere() {
        return iIIIIIiI_Class131.I_field_5a || iIIIIIiI_Class131.i_field_5a || iIIIIIII_Class129.I_field_5a || Iiiiiiii_Class128.I_field_5a || IiiiiIii_Class124.I_field_5a || ViewModelModule.I_field_5a || IIIiIiIi_Class22.i_method_f1a2a450();
    }
}

