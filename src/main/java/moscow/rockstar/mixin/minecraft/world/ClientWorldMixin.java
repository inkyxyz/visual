package moscow.rockstar.mixin.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.game.EntityDeathEvent;
import rockstar.client.XRayModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiiIii_Class252;
import rockstar.client.IiiiiiiIi_Class254;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={ClientWorld.class})
public abstract class ClientWorldMixin
extends World
implements iIIiIIiIi_Class294 {
    protected ClientWorldMixin(MutableWorldProperties mutableWorldProperties, RegistryKey<World> registryKey, DynamicRegistryManager dynamicRegistryManager, RegistryEntry<DimensionType> registryEntry, boolean bl, boolean bl2, long l, int n) {
        super(mutableWorldProperties, registryKey, dynamicRegistryManager, registryEntry, bl, bl2, l, n);
    }

    @Inject(method={"handleBlockUpdate"}, at={@At(value="HEAD")})
    private void onHandleBlockUpdate(BlockPos blockPos, BlockState blockState, int n, CallbackInfo callbackInfo) {
        XRayModule iModuleManager = RockstarClient.getInstance().getModuleManager().getModule(XRayModule.class);
        if (iModuleManager == null || !iModuleManager.isEnabled()) {
            return;
        }
        Block block = blockState.getBlock();
        BlockPos blockPos2 = blockPos.toImmutable();
        if (iModuleManager.I_method_89f386b5().I_method_bcc5858f(block)) {
            iModuleManager.I_method_336cb38e().add(blockPos2);
        } else {
            iModuleManager.I_method_336cb38e().remove(blockPos2);
        }
    }

    @Inject(method={"removeEntity"}, at={@At(value="HEAD")})
    private void removeEntityEvent(int n, Entity.RemovalReason removalReason, CallbackInfo callbackInfo) {
        LivingEntity livingEntity;
        IiiiiiIii_Class252.I_method_8a6d4084(n);
        if (ClientWorldMixin.I_field_3a9bda27.player == null || ClientWorldMixin.I_field_3a9bda27.player.isRemoved()) {
            return;
        }
        if (ClientWorldMixin.I_field_3a9bda27.player.getId() == n) {
            return;
        }
        Entity entity = this.getEntityById(n);
        if (entity instanceof IiiiiiiIi_Class254) {
            return;
        }
        if (entity instanceof LivingEntity && ClientWorldMixin.I_field_3a9bda27.player.distanceTo((Entity)(livingEntity = (LivingEntity)entity)) < 6.0f && !ClientWorldMixin.I_field_3a9bda27.player.isDead() && IiiiiiIii_Class252.i_method_e51d8c2b(entity)) {
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new EntityDeathEvent(livingEntity));
        }
    }

}

