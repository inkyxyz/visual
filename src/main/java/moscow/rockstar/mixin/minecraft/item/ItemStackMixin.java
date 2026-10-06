package moscow.rockstar.mixin.minecraft.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.game.FinishEatEvent;
import rockstar.client.RockstarClient;

@Mixin(value={ItemStack.class})
public abstract class ItemStackMixin {
    @Inject(method={"finishUsing"}, at={@At(value="TAIL")})
    private void onFinishUsing(World world, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> callbackInfoReturnable) {
        if (!world.isClient) {
            return;
        }
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)livingEntity;
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new FinishEatEvent(playerEntity, (ItemStack)(Object)this));
        }
    }
}

