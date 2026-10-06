package moscow.rockstar.mixin.minecraft.client.network;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.client.network.ClientConnectionState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.network.packet.s2c.play.ItemPickupAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.ParticleS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRespawnS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldEventS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.game.PickupEvent;
import pyrock.events.game.WorldChangeEvent;
import rockstar.client.XRayModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiiIii_Class252;
import rockstar.client.iIIIIiiiI_Class271;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.AirStuckModule;

@Mixin(value={ClientPlayNetworkHandler.class})
public abstract class ClientPlayNetworkHandlerMixin
extends ClientCommonNetworkHandler
implements iIIiIIiIi_Class294 {
    @Unique
    private iiIIiIIii_Class404 oldRotation;

    protected ClientPlayNetworkHandlerMixin(MinecraftClient minecraftClient, ClientConnection clientConnection, ClientConnectionState clientConnectionState) {
        super(minecraftClient, clientConnection, clientConnectionState);
    }

    @Inject(method={"onItemPickupAnimation"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/world/ClientWorld;getEntityById(I)Lnet/minecraft/entity/Entity;", ordinal=0)})
    private void onItemPickupAnimation(ItemPickupAnimationS2CPacket itemPickupAnimationS2CPacket, CallbackInfo callbackInfo) {
        Entity entity = this.client.world.getEntityById(itemPickupAnimationS2CPacket.getEntityId());
        Entity entity2 = this.client.world.getEntityById(itemPickupAnimationS2CPacket.getCollectorEntityId());
        if (entity instanceof ItemEntity) {
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new PickupEvent(entity2, ((ItemEntity)entity).getStack(), itemPickupAnimationS2CPacket.getStackAmount()));
        }
    }

    @Inject(method={"onBlockEntityUpdate"}, at={@At(value="TAIL")})
    private void onBlockEntityUpdate(BlockEntityUpdateS2CPacket blockEntityUpdateS2CPacket, CallbackInfo callbackInfo) {
        if (ClientPlayNetworkHandlerMixin.I_field_3a9bda27.world == null) {
            return;
        }
        BlockPos blockPos = blockEntityUpdateS2CPacket.getPos();
        iIIIIiiiI_Class271.I_method_a0466594(ClientPlayNetworkHandlerMixin.I_field_3a9bda27.world.getBlockEntity(blockPos));
    }

    @Inject(method={"onChunkData"}, at={@At(value="TAIL")})
    private void onChunkData(ChunkDataS2CPacket chunkDataS2CPacket, CallbackInfo callbackInfo) {
        if (ClientPlayNetworkHandlerMixin.I_field_3a9bda27.world == null) {
            return;
        }
        WorldChunk worldChunk = ClientPlayNetworkHandlerMixin.I_field_3a9bda27.world.getChunk(chunkDataS2CPacket.getChunkX(), chunkDataS2CPacket.getChunkZ());
        worldChunk.getBlockEntities().values().forEach(iIIIIiiiI_Class271::I_method_a0466594);
        XRayModule iModuleManager = RockstarClient.getInstance().getModuleManager().getModule(XRayModule.class);
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (iModuleManager == null || !iModuleManager.isEnabled() || minecraftClient.world == null) {
            return;
        }
        new Thread(() -> iModuleManager.I_method_216ef8a0(worldChunk)).start();
    }

    @Inject(method={"onGameJoin"}, at={@At(value="TAIL")})
    private void onGameJoin(GameJoinS2CPacket gameJoinS2CPacket, CallbackInfo callbackInfo) {
        iIIIIiiiI_Class271.I_method_8dcc23f();
        IiiiiiIii_Class252.I_method_f3f2fe5f();
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new WorldChangeEvent());
    }

    @Inject(method={"onPlayerRespawn"}, at={@At(value="TAIL")})
    private void rockstar$onPlayerRespawn(PlayerRespawnS2CPacket playerRespawnS2CPacket, CallbackInfo callbackInfo) {
        iIIIIiiiI_Class271.I_method_8dcc23f();
        IiiiiiIii_Class252.I_method_f3f2fe5f();
        AirStuckModule iiiIiiRockstarClient382 = RockstarClient.getInstance().getModuleManager().getModule(AirStuckModule.class);
        if (iiiIiiRockstarClient382 != null) {
            iiiIiiRockstarClient382.disable();
        }
    }

    @Inject(method={"onPlayerPositionLook"}, at={@At(value="HEAD")})
    public void savePlayerRotation(PlayerPositionLookS2CPacket playerPositionLookS2CPacket, CallbackInfo callbackInfo) {
        if (ClientPlayNetworkHandlerMixin.I_field_3a9bda27.player == null) {
            return;
        }
        this.oldRotation = new iiIIiIIii_Class404(ClientPlayNetworkHandlerMixin.I_field_3a9bda27.player.getYaw(), ClientPlayNetworkHandlerMixin.I_field_3a9bda27.player.getPitch());
    }

    @Inject(method={"onPlayerPositionLook"}, at={@At(value="RETURN")})
    public void modifyPlayerRotation(PlayerPositionLookS2CPacket playerPositionLookS2CPacket, CallbackInfo callbackInfo) {
        if (ClientPlayNetworkHandlerMixin.I_field_3a9bda27.player == null) {
            return;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = new iiIIiIIii_Class404(playerPositionLookS2CPacket.change().yaw(), playerPositionLookS2CPacket.change().pitch());
    }

    @Inject(method = "onParticle", at = @At("HEAD"), cancellable = true)
    private void onParticlePacket(ParticleS2CPacket packet, CallbackInfo ci) {
        rockstar.client.MaceEffectsModule maceMod = RockstarClient.getInstance().getModuleManager().getModule(rockstar.client.MaceEffectsModule.class);
        if (maceMod != null && maceMod.shouldCancelVanillaParticles() && packet.getParameters() != null) {
            net.minecraft.particle.ParticleType<?> type = packet.getParameters().getType();
            if (type == ParticleTypes.GUST_EMITTER_LARGE
                || type == ParticleTypes.GUST_EMITTER_SMALL
                || type == ParticleTypes.GUST
                || type == ParticleTypes.SMALL_GUST
                || type == ParticleTypes.DUST_PLUME
                || type == ParticleTypes.DUST_PILLAR
                || type == ParticleTypes.TRIAL_SPAWNER_DETECTION_OMINOUS) {
                ci.cancel();
            }
        }
    }

    @Inject(method = "onWorldEvent", at = @At("HEAD"), cancellable = true)
    private void onWorldEventPacket(WorldEventS2CPacket packet, CallbackInfo ci) {
        rockstar.client.MaceEffectsModule maceMod = RockstarClient.getInstance().getModuleManager().getModule(rockstar.client.MaceEffectsModule.class);
        if (maceMod != null && maceMod.shouldCancelVanillaParticles()) {
            if (packet.getEventId() == 2013) { // WorldEvents.SMASH_ATTACK
                ci.cancel();
            }
        }
    }
}

