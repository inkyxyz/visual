package moscow.rockstar.mixin.minecraft.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.game.RotateCameraEvent;
import pyrock.events.player.EventOnMovePost;
import pyrock.events.player.TraceEvent;
import rockstar.client.NoPushModule;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiIiiIiI_Class347;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiiIIi_Class410;
import rockstar.client.BackTrackModule;
import rockstar.client.HitboxesModule;

@Mixin({Entity.class})
public abstract class EntityMixin implements iIIiIIiIi_Class294, iIiIiiIiI_Class347 {
   @Shadow
   private Box field_6005;
   @Unique
   private List<BackTrackModule.Nested1_cb97a4f3> backTracks;

   @Shadow
   public abstract Vec3d method_5836(float var1);

   @Shadow
   public abstract Vec3d method_5828(float var1);

   @Shadow
   public abstract float method_36454();

   @Shadow
   public abstract float method_36455();

   @Inject(
      method = {"raycast"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRaycast(double var1, float var3, boolean var4, CallbackInfoReturnable<HitResult> var5) {
      TraceEvent var6 = new TraceEvent(this.method_36454(), this.method_36455());
      RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(var6);
      if (var6.isCancelled()) {
         Vec3d var7 = this.method_5836(var3);
         Vec3d var8 = this.getCustomLook(var6.getPitch(), var6.getYaw());
         Vec3d var9 = var7.add(var8.multiply(var1));
         BlockHitResult var10 = ((Entity)(Object)this)
            .getWorld()
            .raycast(new RaycastContext(var7, var9, ShapeType.OUTLINE, var4 ? FluidHandling.ANY : FluidHandling.NONE, (Entity)(Object)this));
         var5.setReturnValue(var10);
      }
   }

   private Vec3d getCustomLook(float var1, float var2) {
      float var3 = var1 * (float) (Math.PI / 180.0);
      float var4 = -var2 * (float) (Math.PI / 180.0);
      float var5 = (float)Math.cos(var4);
      float var6 = (float)Math.sin(var4);
      float var7 = (float)Math.cos(var3);
      float var8 = (float)Math.sin(var3);
      return new Vec3d(var6 * var7, -var8, var5 * var7);
   }

   @ModifyExpressionValue(
      method = {"move"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/Entity;isControlledByPlayer()Z"
      )}
   )
   public boolean fixFalldistanceValue(boolean var1) {
      return (Object)this == I_field_3a9bda27.player ? false : var1;
   }

   @WrapOperation(
      method = {"move"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/Entity;fall(DZLnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)V"
      )}
   )
   private void rockstar$fallDistanceOnly(Entity var1, double var2, boolean var4, BlockState var5, BlockPos var6, Operation<Void> var7) {
      if (var1 != I_field_3a9bda27.player) {
         var7.call(new Object[]{var1, var2, var4, var5, var6});
      } else {
         if (var4) {
            var1.fallDistance = 0.0F;
         } else if (var2 < 0.0) {
            var1.fallDistance -= (float)var2;
         }
      }
   }

   @Inject(
      method = {"isGlowing"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isGlowing(CallbackInfoReturnable<Boolean> var1) {
      RemovalsModule var2 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
      if (var2.isEnabled() && var2.IIIi_method_3db26873().isSelected()) {
         var1.setReturnValue(false);
      }
   }

   @Inject(
      method = {"onBubbleColumnCollision", "onBubbleColumnSurfaceCollision"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void removePushFromBubbleColumns(boolean var1, CallbackInfo var2) {
      NoPushModule var3 = RockstarClient.getInstance().getModuleManager().getModule(NoPushModule.class);
      if ((Object)this == I_field_3a9bda27.player && var3.isEnabled() && var3.II_method_3cacc0b3().isSelected()) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"getBoundingBox"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public final void getBoundingBox(CallbackInfoReturnable<Box> var1) {
      HitboxesModule var2 = RockstarClient.getInstance().getModuleManager().getModule(HitboxesModule.class);
      Entity var3 = (Entity)(Object)this;
      if (var3 instanceof LivingEntity var4 && var2 != null && var2.isEnabled() && var2.I_method_3d2a075(var4) && var3.getId() != I_field_3a9bda27.player.getId()) {
         var1.setReturnValue(
            new Box(
               this.field_6005.minX - var2.I_method_79b78f62().Ii_method_a20abcd2(),
               this.field_6005.minY,
               this.field_6005.minZ - var2.I_method_79b78f62().Ii_method_a20abcd2(),
               this.field_6005.maxX + var2.I_method_79b78f62().Ii_method_a20abcd2(),
               this.field_6005.maxY,
               this.field_6005.maxZ + var2.I_method_79b78f62().Ii_method_a20abcd2()
            )
         );
      }
   }

   @Redirect(
      method = {"updateVelocity"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/Entity;getYaw()F"
      )
   )
   public float movementCorrection(Entity var1) {
      iiIIiIiII_Class405 var2 = RockstarClient.I_field_502d1741.I_method_58785402();
      iiIIiiIIi_Class410 var3 = var2.I_method_fcdff2d5();
      return var3 != null && var3.I_method_384472d5().I_method_778be603() && var1 instanceof ClientPlayerEntity
         ? var2.II_method_f098f858().I_method_14534e0f()
         : var1.getYaw();
   }

   @Inject(
      method = {"updateVelocity"},
      at = {@At("TAIL")}
   )
   private void rockstar$onMovePost(float var1, Vec3d var2, CallbackInfo var3) {
      Entity var4 = (Entity)(Object)this;
      if (I_field_3a9bda27.player != null && var4.getId() == I_field_3a9bda27.player.getId()) {
         RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new EventOnMovePost(var1, var2));
      }
   }

   @Override
   public List<BackTrackModule.Nested1_cb97a4f3> rockstar2_0$getBackTracks() {
      if (this.backTracks == null) {
         this.backTracks = new ArrayList<>();
      }

      return this.backTracks;
   }

   @Inject(
      method = {"changeLookDirection"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onChangeLookDirection(double var1, double var3, CallbackInfo var5) {
      if ((Object)this == I_field_3a9bda27.player) {
         RotateCameraEvent var6 = new RotateCameraEvent((float)(var1 * 0.15F), (float)(var3 * 0.15F));
         RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(var6);
         if (var6.isCancelled()) {
            var5.cancel();
         }
      }
   }
}
