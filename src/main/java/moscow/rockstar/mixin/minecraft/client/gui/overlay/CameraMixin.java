package moscow.rockstar.mixin.minecraft.client.gui.overlay;

import moscow.rockstar.mixin.accessors.CameraAccessor;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.render.CameraUpdateEvent;
import rockstar.client.FreeCameraModule;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.AuraModule;
import rockstar.client.SpeedModule;

@Mixin(value={Camera.class})
public abstract class CameraMixin {
    @Shadow
    private Entity field_18711;
    @Shadow
    private boolean field_18719;
    @Shadow
    private float field_18721;
    @Shadow
    private float field_18722;
    @Unique
    private static final int rockstar$JITTER_FLIPS = 3;
    @Unique
    private static final int rockstar$RESET_TICKS = 10;
    @Unique
    private float rockstar$lastEyeHeight;
    @Unique
    private boolean rockstar$eyeHeightKnown;
    @Unique
    private float rockstar$heldEyeHeight;
    @Unique
    private int rockstar$eyeHeightFlips;
    @Unique
    private int rockstar$ticksSinceFlip;

    @Shadow
    public abstract void method_19322(Vec3d var1);

    @Shadow
    public abstract void method_19325(float var1, float var2);

    @Inject(method={"updateEyeHeight"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$stabilizeEyeHeight(CallbackInfo callbackInfo) {
        if (this.field_18711 == null) {
            return;
        }
        float f = CameraMixin.rockstar$eyeHeight(this.field_18711);
        if (!this.field_18711.isTouchingWater() || !CameraMixin.rockstar$auraOnHolyWorld()) {
            this.rockstar$eyeHeightKnown = false;
            this.rockstar$eyeHeightFlips = 0;
            this.rockstar$ticksSinceFlip = 0;
            this.rockstar$heldEyeHeight = f;
            this.field_18722 = this.field_18721;
            this.field_18721 += (f - this.field_18721) * 0.5f;
            callbackInfo.cancel();
            return;
        }
        if (!this.rockstar$eyeHeightKnown) {
            this.rockstar$eyeHeightKnown = true;
            this.rockstar$lastEyeHeight = f;
            this.rockstar$heldEyeHeight = f;
        }
        if (Math.abs(f - this.rockstar$lastEyeHeight) > 1.0E-4f) {
            this.rockstar$lastEyeHeight = f;
            this.rockstar$ticksSinceFlip = 0;
            ++this.rockstar$eyeHeightFlips;
        } else if (++this.rockstar$ticksSinceFlip >= 10) {
            this.rockstar$eyeHeightFlips = 0;
        }
        this.rockstar$heldEyeHeight = this.rockstar$eyeHeightFlips >= 3 ? Math.max(this.rockstar$heldEyeHeight, f) : f;
        this.field_18722 = this.field_18721;
        this.field_18721 += (this.rockstar$heldEyeHeight - this.field_18721) * 0.5f;
        callbackInfo.cancel();
    }

    @Unique
    private static boolean rockstar$auraOnHolyWorld() {
        AuraModule iiIiIIRockstarClient102 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
        return iiIiIIRockstarClient102 != null && iiIiIIRockstarClient102.isEnabled() && iIIIiiiII_Class285.Ii_method_b349c526();
    }

    @Unique
    private static float rockstar$eyeHeight(Entity entity) {
        if (entity == MinecraftClient.getInstance().player && entity.getPose() == EntityPose.GLIDING && SpeedModule.Iii_method_2c01c5d0()) {
            return entity.getDimensions(EntityPose.STANDING).eyeHeight();
        }
        return entity.getStandingEyeHeight();
    }

    @Inject(method={"getSubmersionType"}, at={@At(value="HEAD")}, cancellable=true)
    private void getSubmergedFluidState(CallbackInfoReturnable<CameraSubmersionType> callbackInfoReturnable) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (iIiIiIIiI_Class83 == null || !iIiIiIIiI_Class83.isEnabled()) {
            return;
        }
        if (iIiIiIIiI_Class83.IiI_method_7acc5cf0().isSelected()) {
            callbackInfoReturnable.setReturnValue(CameraSubmersionType.NONE);
            return;
        }
    }

    @Inject(method={"update"}, at={@At(value="TAIL")})
    private void onUpdate(BlockView blockView, Entity entity, boolean bl, boolean bl2, float f, CallbackInfo callbackInfo) {
        FreeCameraModule iIIiIIiii_Class40 = RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class);
        iIIiIIiii_Class40.IiI_method_460b62bf();
        if (iIIiIIiii_Class40.IiI_method_460b62c3()) {
            this.method_19322(iIIiIIiii_Class40.I_method_c6647d1b(f));
            iiIIiIIii_Class404 iiIIiIIii_Class4042 = iIIiIIiii_Class40.I_method_4e394bb7(f);
            this.method_19325(iiIIiIIii_Class4042.I_method_14534e0f(), iiIIiIIii_Class4042.i_method_1461d9ef());
            ((CameraAccessor)((Object)this)).setThirdPerson(true);
            return;
        }
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new CameraUpdateEvent((Camera)(Object)this, entity, bl, bl2, f));
    }
}

