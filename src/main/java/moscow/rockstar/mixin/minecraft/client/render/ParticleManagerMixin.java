package moscow.rockstar.mixin.minecraft.client.render;

import net.minecraft.block.BlockState;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;

@Mixin(value={ParticleManager.class})
public abstract class ParticleManagerMixin {
    @Inject(method={"addBlockBreakParticles"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAddBlockBreakParticles(BlockPos blockPos, BlockState blockState, CallbackInfo callbackInfo) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.III_method_bfd4dcd0().isSelected()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"addBlockBreakingParticles"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAddBlockBreakingParticles(BlockPos blockPos, Direction direction, CallbackInfo callbackInfo) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.III_method_bfd4dcd0().isSelected()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"addParticle"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAddParticle(ParticleEffect particleEffect, double d, double d2, double d3, double d4, double d5, double d6, CallbackInfoReturnable<Particle> callbackInfoReturnable) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (iIiIiIIiI_Class83.isEnabled() && iIiIiIIiI_Class83.IIII_method_37aa6c93().isSelected() && particleEffect.getType() == ParticleTypes.RAIN) {
            callbackInfoReturnable.cancel();
        }
        rockstar.client.MaceEffectsModule maceMod = RockstarClient.getInstance().getModuleManager().getModule(rockstar.client.MaceEffectsModule.class);
        if (maceMod != null && maceMod.shouldCancelVanillaParticles()) {
            net.minecraft.particle.ParticleType<?> type = particleEffect.getType();
            if (type == ParticleTypes.GUST_EMITTER_LARGE
                || type == ParticleTypes.GUST_EMITTER_SMALL
                || type == ParticleTypes.GUST
                || type == ParticleTypes.SMALL_GUST
                || type == ParticleTypes.DUST_PLUME
                || type == ParticleTypes.DUST_PILLAR
                || type == ParticleTypes.TRIAL_SPAWNER_DETECTION_OMINOUS) {
                callbackInfoReturnable.cancel();
            }
        }
    }

    @Inject(method = "addEmitter(Lnet/minecraft/entity/Entity;Lnet/minecraft/particle/ParticleEffect;)V", at = @At("HEAD"), cancellable = true)
    private void onAddEmitter(net.minecraft.entity.Entity entity, ParticleEffect particleEffect, CallbackInfo ci) {
        rockstar.client.MaceEffectsModule maceMod = RockstarClient.getInstance().getModuleManager().getModule(rockstar.client.MaceEffectsModule.class);
        if (maceMod != null && maceMod.shouldCancelVanillaParticles()) {
            net.minecraft.particle.ParticleType<?> type = particleEffect.getType();
            if (type == ParticleTypes.GUST_EMITTER_LARGE
                || type == ParticleTypes.GUST_EMITTER_SMALL
                || type == ParticleTypes.GUST
                || type == ParticleTypes.SMALL_GUST
                || type == ParticleTypes.DUST_PLUME
                || type == ParticleTypes.DUST_PILLAR) {
                ci.cancel();
            }
        }
    }

    @Inject(method = "addEmitter(Lnet/minecraft/entity/Entity;Lnet/minecraft/particle/ParticleEffect;I)V", at = @At("HEAD"), cancellable = true)
    private void onAddEmitterInt(net.minecraft.entity.Entity entity, ParticleEffect particleEffect, int maxAge, CallbackInfo ci) {
        rockstar.client.MaceEffectsModule maceMod = RockstarClient.getInstance().getModuleManager().getModule(rockstar.client.MaceEffectsModule.class);
        if (maceMod != null && maceMod.shouldCancelVanillaParticles()) {
            net.minecraft.particle.ParticleType<?> type = particleEffect.getType();
            if (type == ParticleTypes.GUST_EMITTER_LARGE
                || type == ParticleTypes.GUST_EMITTER_SMALL
                || type == ParticleTypes.GUST
                || type == ParticleTypes.SMALL_GUST
                || type == ParticleTypes.DUST_PLUME
                || type == ParticleTypes.DUST_PILLAR) {
                ci.cancel();
            }
        }
    }
}

