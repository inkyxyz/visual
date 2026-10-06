package moscow.rockstar.mixin.minecraft.world.explosion;

import java.util.List;
import moscow.rockstar.mixin.accessors.ExplosionImplAccessor;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.ExplosionImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.game.AncientDebrisEvent;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={ExplosionImpl.class})
public abstract class ExplosionImplMixin
implements iIIiIIiIi_Class294 {
    @Inject(method={"explode"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/explosion/ExplosionImpl;damageEntities()V", shift=At.Shift.AFTER)})
    private void onAfterDamageEntities(CallbackInfo callbackInfo) {
        ExplosionImpl explosionImpl = (ExplosionImpl)(Object)this;
        List<BlockPos> list = ((ExplosionImplAccessor)(Object)explosionImpl).invokeGetBlocksToDestroy();
        List<BlockPos> list2 = list.stream().filter(blockPos -> explosionImpl.getWorld().getBlockState(blockPos).isOf(Blocks.ANCIENT_DEBRIS)).toList();
        if (!list2.isEmpty() && explosionImpl.getWorld().getRegistryKey() == World.NETHER) {
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new AncientDebrisEvent(list2, explosionImpl.getPosition()));
        }
    }
}

