package moscow.rockstar.mixin.minecraft.client.network;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import globals.client.snowball.FakeFrozenTicksAccess;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.game.CloseScreenEvent;
import pyrock.events.player.ClientPlayerTickEndEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.EventMotion;
import pyrock.events.player.EventUpdatePostTick;
import pyrock.events.player.SlowDownEvent;
import rockstar.client.InventoryUtilsModule;
import rockstar.client.NoPushModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIiIII_Class265;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiIiiIii_Class348;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.AuraModule;
import rockstar.client.TriggerBotModule;
import rockstar.client.AutoSprintModule;
import rockstar.client.SpeedModule;

@Mixin(value={ClientPlayerEntity.class})
public class ClientPlayerEntityMixin
implements FakeFrozenTicksAccess,
iIIiIIiIi_Class294,
iIiIiiIii_Class348 {
    @Unique
    private int groundTicks;
    @Unique
    private int rockstar$fakeFrozenTicks;
    @Unique
    private EventMotion rockstar$motionEvent;
    @Unique
    private AuraModule aura;

    @Shadow
    private void method_46742() {
    }

    @Unique
    private AuraModule rockstar$aura() {
        if (this.aura == null) {
            this.aura = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
        }
        return this.aura;
    }

    @Redirect(method={"tickMovement"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;setSprinting(Z)V"))
    private void rockstar$keepBounceSprint(ClientPlayerEntity clientPlayerEntity, boolean bl) {
        if (!bl && SpeedModule.I_method_dbdeabf9(clientPlayerEntity)) {
            return;
        }
        clientPlayerEntity.setSprinting(bl);
    }

    @Redirect(method={"tickMovement"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z"), require=0)
    private boolean onIsUsingItemRedirect(ClientPlayerEntity clientPlayerEntity) {
        SlowDownEvent slowDownEvent = new SlowDownEvent();
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(slowDownEvent);
        return clientPlayerEntity.isUsingItem() && clientPlayerEntity.getVehicle() == null && !slowDownEvent.isCancelled();
    }

    @ModifyExpressionValue(method={"tickMovement"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/option/KeyBinding;isPressed()Z")})
    public boolean unpressSprintKey(boolean bl) {
        if (this.shouldPreventAuraSprint((ClientPlayerEntity)(Object)this)) {
            return false;
        }
        return bl;
    }

    @ModifyExpressionValue(method={"tickMovement"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;canSprint()Z")})
    private boolean disallowSprinting(boolean bl) {
        if (this.shouldPreventAuraSprint((ClientPlayerEntity)(Object)this)) {
            return false;
        }
        return bl;
    }

    @Inject(method={"canStartSprinting"}, at={@At(value="HEAD")}, cancellable=true)
    private void preventSprintStart(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (iIIIIiIII_Class265.I_method_eacbd82b((Entity)((ClientPlayerEntity)(Object)this))) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method={"sendSprintingPacket"}, at={@At(value="HEAD")})
    private void resetSprintBeforePacket(CallbackInfo callbackInfo) {
        ClientPlayerEntity clientPlayerEntity = (ClientPlayerEntity)(Object)this;
        if (iIIIIiIII_Class265.I_method_eacbd82b((Entity)clientPlayerEntity)) {
            ClientPlayerEntityMixin.I_field_3a9bda27.options.sprintKey.setPressed(false);
            clientPlayerEntity.setSprinting(false);
            if (this.rockstar$motionEvent != null) {
                this.rockstar$motionEvent.setSprinting(false);
            }
        }
    }

    @Inject(method={"sendSprintingPacket"}, at={@At(value="TAIL")})
    private void markSprintResetSynced(CallbackInfo callbackInfo) {
        iIIIIiIII_Class265.I_method_eacbd827((Entity)((ClientPlayerEntity)(Object)this));
    }

    @ModifyExpressionValue(method={"canSprint"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/player/HungerManager;getFoodLevel()I")})
    private int ignoreHungerForAutoSprint(int n) {
        AutoSprintModule iiiIiiiI_Class2392 = RockstarClient.getInstance().getModuleManager().getModule(AutoSprintModule.class);
        if (iiiIiiiI_Class2392.isEnabled() && iiiIiiiI_Class2392.I_method_68cbaf82().i_method_9b12da03()) {
            return 20;
        }
        return n;
    }

    @WrapWithCondition(method={"closeScreen"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/MinecraftClient;setScreen(Lnet/minecraft/client/gui/screen/Screen;)V")})
    private boolean preventCloseScreen(MinecraftClient minecraftClient, Screen screen) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new CloseScreenEvent(screen));
        return true;
    }

    @Inject(method={"pushOutOfBlocks"}, at={@At(value="HEAD")}, cancellable=true)
    public void removePushOutFromBlocks(double d, double d2, CallbackInfo callbackInfo) {
        NoPushModule iIIiIiiii_Class48 = RockstarClient.getInstance().getModuleManager().getModule(NoPushModule.class);
        if (iIIiIiiii_Class48.isEnabled() && iIIiIiiii_Class48.Ii_method_42b4bc93().isSelected()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    public void triggerTickEvent(CallbackInfo callbackInfo) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ClientPlayerTickEvent());
    }

    @Inject(method={"tick"}, at={@At(value="RETURN")})
    public void triggerTickEndEvent(CallbackInfo callbackInfo) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ClientPlayerTickEndEvent());
        this.rockstar$finishMotionEvent(false);
    }

    @Inject(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/AbstractClientPlayerEntity;tick()V", shift=At.Shift.AFTER)})
    public void triggerUpdatePostTickEvent(CallbackInfo callbackInfo) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new EventUpdatePostTick());
    }

    @Inject(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;sendSneakingPacket()V", shift=At.Shift.BEFORE)})
    private void rockstar$createMotionEventBeforeActionPackets(CallbackInfo callbackInfo) {
        this.rockstar$getMotionEvent((ClientPlayerEntity)(Object)this);
    }

    @Inject(method={"tickMovement"}, at={@At(value="HEAD")})
    public void updateOnGroundTicks(CallbackInfo callbackInfo) {
        ClientPlayerEntity clientPlayerEntity = (ClientPlayerEntity)(Object)this;
        if (iIIIIiIII_Class265.I_method_eacbd82b((Entity)clientPlayerEntity)) {
            ClientPlayerEntityMixin.I_field_3a9bda27.options.sprintKey.setPressed(false);
            clientPlayerEntity.setSprinting(false);
            if (iIIIIiIII_Class265.i_method_a5c3584b((Entity)clientPlayerEntity)) {
                this.method_46742();
            }
        }
        this.groundTicks = ClientPlayerEntityMixin.I_field_3a9bda27.player != null && ClientPlayerEntityMixin.I_field_3a9bda27.player.isOnGround() ? ++this.groundTicks : 0;
    }

    @Inject(method={"sendSneakingPacket"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$cancelSneakingPacket(CallbackInfo callbackInfo) {
        if (this.rockstar$motionEvent != null && this.rockstar$motionEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Redirect(method={"sendSneakingPacket"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;isSneaking()Z"))
    private boolean rockstar$replaceSneakingState(ClientPlayerEntity clientPlayerEntity) {
        return this.rockstar$motionEvent != null ? this.rockstar$motionEvent.isSneaking() : clientPlayerEntity.isSneaking();
    }

    @Inject(method={"sendSprintingPacket"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$cancelSprintingPacket(CallbackInfo callbackInfo) {
        if (this.rockstar$motionEvent != null && this.rockstar$motionEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Redirect(method={"sendSprintingPacket"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;isSprinting()Z"))
    private boolean rockstar$replaceSprintingState(ClientPlayerEntity clientPlayerEntity) {
        return this.rockstar$motionEvent != null ? this.rockstar$motionEvent.isSprinting() : clientPlayerEntity.isSprinting();
    }

    @Inject(method={"sendMovementPackets"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$cancelMovementPackets(CallbackInfo callbackInfo) {
        EventMotion eventMotion = this.rockstar$getMotionEvent((ClientPlayerEntity)(Object)this);
        if (eventMotion.isCancelled()) {
            this.rockstar$finishMotionEvent(false);
            callbackInfo.cancel();
        }
    }

    @Redirect(method={"sendMovementPackets"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getX()D"))
    public double replaceMovePacketX(ClientPlayerEntity clientPlayerEntity) {
        return this.rockstar$getMotionEvent(clientPlayerEntity).getX();
    }

    @Redirect(method={"sendMovementPackets"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getY()D"))
    public double replaceMovePacketY(ClientPlayerEntity clientPlayerEntity) {
        return this.rockstar$getMotionEvent(clientPlayerEntity).getY();
    }

    @Redirect(method={"sendMovementPackets"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getZ()D"))
    public double replaceMovePacketZ(ClientPlayerEntity clientPlayerEntity) {
        return this.rockstar$getMotionEvent(clientPlayerEntity).getZ();
    }

    @Redirect(method={"sendMovementPackets"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getYaw()F"))
    public float replaceMovePacketYaw(ClientPlayerEntity clientPlayerEntity) {
        float f = this.rockstar$getMotionEvent(clientPlayerEntity).getYaw();
        RockstarClient.getInstance().I_method_58785402().Ii_method_62e6c38().I_method_7616dd81(f);
        return f;
    }

    @Redirect(method={"sendMovementPackets"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getPitch()F"))
    public float replaceMovePacketPitch(ClientPlayerEntity clientPlayerEntity) {
        float f = this.rockstar$getMotionEvent(clientPlayerEntity).getPitch();
        RockstarClient.getInstance().I_method_58785402().Ii_method_62e6c38().i_method_77d9cda1(f);
        return f;
    }

    @Redirect(method={"sendMovementPackets"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;isOnGround()Z"))
    public boolean replaceMovePacketGround(ClientPlayerEntity clientPlayerEntity) {
        return this.rockstar$getMotionEvent(clientPlayerEntity).isOnGround();
    }

    @Unique
    private EventMotion rockstar$getMotionEvent(ClientPlayerEntity clientPlayerEntity) {
        if (this.rockstar$motionEvent != null) {
            return this.rockstar$motionEvent;
        }
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiII_Class4052.III_method_aa8d2b35();
        float f2 = iiIIiIIii_Class4042 != null ? iiIIiIIii_Class4042.I_method_14534e0f() : (iiIIiIiII_Class4052.I_method_3d166e03() ? clientPlayerEntity.getYaw() : iiIIiIiII_Class4052.II_method_f098f858().I_method_14534e0f());
        float f3 = iiIIiIIii_Class4042 != null ? iiIIiIIii_Class4042.i_method_1461d9ef() : (iiIIiIiII_Class4052.I_method_3d166e03() ? clientPlayerEntity.getPitch() : iiIIiIiII_Class4052.II_method_f098f858().i_method_1461d9ef());
        this.rockstar$motionEvent = new EventMotion(clientPlayerEntity.getX(), clientPlayerEntity.getY(), clientPlayerEntity.getZ(), f2, f3, clientPlayerEntity.isOnGround(), clientPlayerEntity.isSneaking(), clientPlayerEntity.isSprinting());
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(this.rockstar$motionEvent);
        return this.rockstar$motionEvent;
    }

    @Inject(method={"sendMovementPackets"}, at={@At(value="TAIL")})
    private void rockstar$clearInteractItemRotation(CallbackInfo callbackInfo) {
        this.rockstar$finishMotionEvent(true);
    }

    @Unique
    private void rockstar$finishMotionEvent(boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = this.rockstar$motionEvent != null;
        if (this.rockstar$motionEvent != null) {
            if (bl && !this.rockstar$motionEvent.isCancelled()) {
                this.rockstar$motionEvent.markSent();
            }
            this.rockstar$motionEvent = null;
        }
        if (bl2 || bl) {
            RockstarClient.getInstance().I_method_58785402().iI_method_61073f84(null);
        }
    }

    @Inject(method={"dropSelectedItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void onDropSelectedItem(boolean bl, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        InventoryUtilsModule iIIiIiIIi_Class42 = RockstarClient.getInstance().getModuleManager().getModule(InventoryUtilsModule.class);
        if (iIIiIiIIi_Class42.isEnabled() && iIIiIiIIi_Class42.i_method_8307c90().isSelected() && iIIiIiIIi_Class42.I_method_e5974888(ClientPlayerEntityMixin.I_field_3a9bda27.player.getInventory().selectedSlot)) {
            callbackInfoReturnable.setReturnValue(false);
            callbackInfoReturnable.cancel();
        }
    }

    @Override
    public int rockstar$getOnGroundTicks() {
        return this.groundTicks;
    }

    @Override
    public void rockstar$syncSprinting() {
        this.method_46742();
    }

    @Override
    public int rockstar$getFakeFrozenTicks() {
        return this.rockstar$fakeFrozenTicks;
    }

    @Override
    public void rockstar$setFakeFrozenTicks(int n) {
        this.rockstar$fakeFrozenTicks = Math.max(0, n);
    }

    @Unique
    private boolean shouldPreventAuraSprint(ClientPlayerEntity clientPlayerEntity) {
        TriggerBotModule iiIiiiiI_Class2232 = RockstarClient.getInstance().getModuleManager().getModule(TriggerBotModule.class);
        AuraModule iiIiIIRockstarClient102 = this.rockstar$aura();
        return iIIIIiIII_Class265.I_method_eacbd82b((Entity)clientPlayerEntity) || iiIiIIRockstarClient102 != null && iiIiIIRockstarClient102.isEnabled() && iiIiIIRockstarClient102.Iii_method_ce986db0() || iiIiiiiI_Class2232.isEnabled() && iiIiiiiI_Class2232.IiI_method_80b6a210();
    }
}
