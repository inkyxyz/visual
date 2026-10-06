package moscow.rockstar.mixin.minecraft.render.item;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.render.HandRenderEvent;
import rockstar.client.SwingAnimationModule;
import rockstar.client.ViewModelModule;
import rockstar.client.ModuleManager;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiii_Class120;
import rockstar.client.IiiiiIii_Class124;
import rockstar.client.IiiiiiiI_Class127;
import rockstar.client.Iiiiiiii_Class128;
import rockstar.client.iIIIIIII_Class129;
import rockstar.client.iIIIIIiI_Class131;
import rockstar.client.iIiiIiIII_Class361;

@Mixin({HeldItemRenderer.class})
public abstract class HeldItemRendererMixin {
   @Shadow
   @Final
   private ItemRenderer field_4044;
   @Shadow
   private ItemStack field_4047;
   @Shadow
   private ItemStack field_4048;
   @Shadow
   private float field_4043;
   @Shadow
   private float field_4053;
   @Shadow
   private float field_4052;
   @Shadow
   private float field_4051;
   @Unique
   private static boolean rockstar$handRenderHijacked;
   @Unique
   private static boolean rockstar$firstPersonItemRendered;
   @Unique
   private static boolean rockstar$tookOverHandRender;
   @Unique
   private static boolean rockstar$decoratingHeldItem;

   @Shadow
   protected abstract void method_3218(MatrixStack var1, float var2, Arm var3, ItemStack var4, PlayerEntity var5);

   @Shadow
   protected abstract void method_49340(MatrixStack var1, float var2, Arm var3, ItemStack var4, PlayerEntity var5, float var6);

   @Shadow
   protected abstract void method_3228(
      AbstractClientPlayerEntity var1,
      float var2,
      float var3,
      Hand var4,
      float var5,
      ItemStack var6,
      float var7,
      MatrixStack var8,
      VertexConsumerProvider var9,
      int var10
   );

   @ModifyVariable(
      method = {"renderFirstPersonItem"},
      at = @At("HEAD"),
      argsOnly = true,
      ordinal = 0
   )
   private int rockstar$applyDynamicLight(int var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      return var2.player == null ? var1 : iIiiIiIII_Class361.I_method_fe9701d(BlockPos.ofFloored(var2.player.getEyePos()), var1);
   }


   @Inject(
      method = {"renderFirstPersonItem"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRenderFirstPersonItem(
      AbstractClientPlayerEntity var1,
      float var2,
      float var3,
      Hand var4,
      float var5,
      ItemStack var6,
      float var7,
      MatrixStack var8,
      VertexConsumerProvider var9,
      int var10,
      CallbackInfo var11
   ) {
      rockstar$firstPersonItemRendered = true;
      var10 = iIiiIiIII_Class361.I_method_fe9701d(BlockPos.ofFloored(var1.getEyePos()), var10);
      boolean var12 = var4 == Hand.MAIN_HAND;
      Arm var13 = var12 ? var1.getMainArm() : var1.getMainArm().getOpposite();
      boolean var14 = var13 == Arm.RIGHT;
      IiiiiIii_Class124.II_field_5a = !var14;
      var8.push();
      HandRenderEvent var15 = new HandRenderEvent(var13, var5, var6, var7, var8);
      RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(var15);
      if (var15.isCancelled()) {
         var11.cancel();
         float var16 = -0.4F * MathHelper.sin(MathHelper.sqrt(0.0F) * (float) Math.PI);
         float var17 = 0.2F * MathHelper.sin(MathHelper.sqrt(0.0F) * (float) (Math.PI * 2));
         float var18 = -0.2F * MathHelper.sin(0.0F);
         var8.translate((var13 == Arm.RIGHT ? 1 : -1) * var16, var17, var18);
         int var19 = var13 == Arm.RIGHT ? 1 : -1;
         var8.translate(var19 * 0.56F, -0.52F, -0.72F);
         if (!var6.isEmpty()) {
            HeldItemRenderer var20 = (HeldItemRenderer)(Object)this;
            ModelTransformationMode var21 = var14 ? ModelTransformationMode.FIRST_PERSON_RIGHT_HAND : ModelTransformationMode.FIRST_PERSON_LEFT_HAND;
            var20.renderItem(var1, var6, var21, !var14, var8, var9, var10);
         }

         var8.pop();
      }
   }

   @Inject(
      method = {"renderFirstPersonItem"},
      at = {@At("RETURN")}
   )
   private void onRenderFirstPersonItemEnd(
      AbstractClientPlayerEntity var1,
      float var2,
      float var3,
      Hand var4,
      float var5,
      ItemStack var6,
      float var7,
      MatrixStack var8,
      VertexConsumerProvider var9,
      int var10,
      CallbackInfo var11
   ) {
      var8.pop();
   }

   @WrapOperation(
      method = {"renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/item/ItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/world/World;III)V"
      )}
   )
   private void rockstar$decorateHeldItem(
      ItemRenderer var1,
      LivingEntity var2,
      ItemStack var3,
      ModelTransformationMode var4,
      boolean var5,
      MatrixStack var6,
      VertexConsumerProvider var7,
      World var8,
      int var9,
      int var10,
      int var11,
      Operation<Void> var12
   ) {
      if (!rockstar$decoratingHeldItem && IiiiiIii_Class124.i_field_5a && !ViewModelModule.I_field_5a && rockstar$isHeldInFirstPerson(var2, var4)) {
         ViewModelModule var13 = rockstar$viewModel();
         if (var13 != null) {
            var13.I_method_92672641(var1, var2, var3, var4, var5, var6, var8, var9, var10, var11);
         }
      }

      if (!rockstar$decoratingHeldItem && IiiiiIii_Class124.i_field_5a && rockstar$isHeldInFirstPerson(var2, var4)) {
         IiiiiIii_Class124.I_method_20b25b16(var3, var4, var5, var6);
         iIIIIIiI_Class131 var25 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
         iIIIIIII_Class129 var14 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIII_Class129.class);
         Iiiiiiii_Class128 var15 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(Iiiiiiii_Class128.class);
         boolean var16 = var25 != null && var25.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741);
         boolean var17 = var14 != null && var14.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741);
         boolean var18 = var15 != null && var15.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741);
         boolean var19 = var15 != null && var15.i_method_a9c2f090();
         if (!var19) {
            var12.call(new Object[]{var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11});
         }

         if (var16 || var17 || var18) {
            if (var2 instanceof AbstractClientPlayerEntity var20) {
               if (var7 instanceof Immediate var21) {
                  var21.draw();
               }

               HeldItemRenderer var26 = (HeldItemRenderer)(Object)this;
               rockstar$decoratingHeldItem = true;

               try {
                  if (var16) {
                     var25.I_method_eda90fc9(var26, var20, var3, var4, var5, var6, var9);
                  }

                  if (var17) {
                     var14.I_method_15ee37a9(var26, var20, var3, var4, var5, var6, var9);
                  }

                  if (var18) {
                     var15.I_method_38a5a769(var26, var20, var3, var4, var5, var6, var9);
                  }
               } finally {
                  rockstar$decoratingHeldItem = false;
               }
            }
         }
      } else {
         var12.call(new Object[]{var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11});
      }
   }

   @Inject(
      method = {"renderArmHoldingItem"},
      at = {@At("RETURN")}
   )
   private void rockstar$captureArmMask(MatrixStack var1, VertexConsumerProvider var2, int var3, float var4, float var5, Arm var6, CallbackInfo var7) {
      if (IiiiiIii_Class124.i_field_5a && !rockstar$decoratingHeldItem && !IiiiiIii_Class124.I_field_5a && !ViewModelModule.I_field_5a) {
         IiiiiIii_Class124.I_method_4209348a(var6, var1);
         ViewModelModule var8 = rockstar$viewModel();
         if (var8 != null) {
            var8.I_method_a0ebf03d(var6, var1);
         }
      }
   }

   @Unique
   private static ViewModelModule rockstar$viewModel() {
      ModuleManager var0 = RockstarClient.getInstance().getModuleManager();
      return var0 == null ? null : var0.getModule(ViewModelModule.class);
   }

   @Inject(
      method = {"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void rockstar$takeOverHandRender(float var1, MatrixStack var2, Immediate var3, ClientPlayerEntity var4, int var5, CallbackInfo var6) {
      rockstar$firstPersonItemRendered = false;
      rockstar$tookOverHandRender = false;
      IiiiiIii_Class124.I_method_ad8ec8cc();
      if (rockstar$handRenderHijacked && this.rockstar$needsHandRenderEvent()) {
         rockstar$tookOverHandRender = true;
         var6.cancel();
         float var7 = var4.getHandSwingProgress(var1);
         Hand var8 = var4.preferredHand == null ? Hand.MAIN_HAND : var4.preferredHand;
         float var9 = var4.getLerpedPitch(var1);
         float var10 = MathHelper.lerp(var1, var4.lastRenderPitch, var4.renderPitch);
         float var11 = MathHelper.lerp(var1, var4.lastRenderYaw, var4.renderYaw);
         float var12 = (var4.getYaw(var1) - var11) % 360.0F;
         var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees((var4.getPitch(var1) - var10) * 0.1F));
         var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var12 * 0.1F));
         boolean var13 = true;
         boolean var14 = true;
         ItemStack var15 = var4.getMainHandStack();
         ItemStack var16 = var4.getOffHandStack();
         if (var15.isOf(Items.BOW) || var16.isOf(Items.BOW) || var15.isOf(Items.CROSSBOW) || var16.isOf(Items.CROSSBOW)) {
            if (var4.isUsingItem()) {
               ItemStack var17 = var4.getActiveItem();
               Hand var18 = var4.getActiveHand();
               if (var17.isOf(Items.BOW) || var17.isOf(Items.CROSSBOW)) {
                  var13 = var18 == Hand.MAIN_HAND;
                  var14 = !var13;
               } else if (var18 == Hand.MAIN_HAND && rockstar$isChargedCrossbow(var16)) {
                  var14 = false;
               }
            } else if (rockstar$isChargedCrossbow(var15)) {
               var14 = false;
            }
         }

         if (var13) {
            float var19 = var8 == Hand.MAIN_HAND ? var7 : 0.0F;
            float var21 = 1.0F - MathHelper.lerp(var1, this.field_4053, this.field_4043);
            this.method_3228(var4, var1, var9, Hand.MAIN_HAND, var19, this.field_4047, var21, var2, var3, var5);
         }

         if (var14) {
            float var20 = var8 == Hand.OFF_HAND ? var7 : 0.0F;
            float var22 = 1.0F - MathHelper.lerp(var1, this.field_4051, this.field_4052);
            this.method_3228(var4, var1, var9, Hand.OFF_HAND, var20, this.field_4048, var22, var2, var3, var5);
         }

         var3.draw();
         IiiiiIii_Class124.II_method_4594815();
         IiiiiIii_Class124.i_method_ad9d54ac();
      }
   }

   @Inject(
      method = {"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider$Immediate;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"},
      at = {@At("RETURN")}
   )
   private void rockstar$detectHijackedHandRender(float var1, MatrixStack var2, Immediate var3, ClientPlayerEntity var4, int var5, CallbackInfo var6) {
      IiiiiIii_Class124.II_method_4594815();
      IiiiiIii_Class124.i_method_ad9d54ac();
      if (!rockstar$tookOverHandRender) {
         rockstar$handRenderHijacked = !rockstar$firstPersonItemRendered;
      }
   }

   @Unique
   private static boolean rockstar$isChargedCrossbow(ItemStack var0) {
      return var0.isOf(Items.CROSSBOW) && CrossbowItem.isCharged(var0);
   }

   @Unique
   private static boolean rockstar$isHeldInFirstPerson(LivingEntity var0, ModelTransformationMode var1) {
      return var0 instanceof ClientPlayerEntity
         && (var1 == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND || var1 == ModelTransformationMode.FIRST_PERSON_LEFT_HAND);
   }

   @Unique
   private boolean rockstar$needsHandRenderEvent() {
      ModuleManager var1 = RockstarClient.getInstance().getModuleManager();
      if (var1 == null) {
         return false;
      } else {
         ViewModelModule var2 = var1.getModule(ViewModelModule.class);
         if (var2 != null && var2.isEnabled()) {
            return true;
         } else {
            SwingAnimationModule var3 = var1.getModule(SwingAnimationModule.class);
            return var3 != null && var3.isEnabled() && var3.I_method_5f90eae5(this.field_4047);
         }
      }
   }
}
