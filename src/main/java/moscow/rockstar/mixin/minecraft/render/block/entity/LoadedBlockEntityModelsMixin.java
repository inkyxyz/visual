package moscow.rockstar.mixin.minecraft.render.block.entity;

import java.util.Map;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.LoadedBlockEntityModels;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.IiiiiIii_Class124;

@Mixin({LoadedBlockEntityModels.class})
public abstract class LoadedBlockEntityModelsMixin {
   @Shadow
   @Final
   private Map<Block, SpecialModelRenderer<?>> field_55270;

   @Inject(
      method = {"render"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void rockstar$renderHeldSkullWithProfile(
      Block var1, ModelTransformationMode var2, MatrixStack var3, VertexConsumerProvider var4, int var5, int var6, CallbackInfo var7
   ) {
      if (IiiiiIii_Class124.i_field_5a && var1 instanceof AbstractSkullBlock) {
         ProfileComponent var8 = rockstar$heldProfile(var1);
         if (var8 != null) {
            SpecialModelRenderer var9 = this.field_55270.get(var1);
            if (var9 != null) {
               var9.render(var8, var2, var3, var4, var5, var6, false);
               var7.cancel();
            }
         }
      }
   }

   @Unique
   private static ProfileComponent rockstar$heldProfile(Block var0) {
      ClientPlayerEntity var1 = MinecraftClient.getInstance().player;
      if (var1 == null) {
         return null;
      } else {
         ProfileComponent var2 = rockstar$profileOf(var1.getMainHandStack(), var0);
         return var2 != null ? var2 : rockstar$profileOf(var1.getOffHandStack(), var0);
      }
   }

   @Unique
   private static ProfileComponent rockstar$profileOf(ItemStack var0, Block var1) {
      return var0 != null && !var0.isEmpty() && Block.getBlockFromItem(var0.getItem()) == var1 ? (ProfileComponent)var0.get(DataComponentTypes.PROFILE) : null;
   }
}
