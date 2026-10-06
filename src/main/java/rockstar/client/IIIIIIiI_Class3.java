package rockstar.client;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Pair;
import lombok.Generated;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.NetworkPhase;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.listener.TickablePacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.CommonPongC2SPacket;
import net.minecraft.network.packet.c2s.common.KeepAliveC2SPacket;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientStatusC2SPacket;
import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;
import net.minecraft.network.packet.s2c.common.CommonPingS2CPacket;
import net.minecraft.network.packet.s2c.common.CookieRequestS2CPacket;
import net.minecraft.network.packet.s2c.common.CustomPayloadS2CPacket;
import net.minecraft.network.packet.s2c.common.CustomReportDetailsS2CPacket;
import net.minecraft.network.packet.s2c.common.DisconnectS2CPacket;
import net.minecraft.network.packet.s2c.common.KeepAliveS2CPacket;
import net.minecraft.network.packet.s2c.common.ResourcePackRemoveS2CPacket;
import net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket;
import net.minecraft.network.packet.s2c.common.ServerLinksS2CPacket;
import net.minecraft.network.packet.s2c.common.ServerTransferS2CPacket;
import net.minecraft.network.packet.s2c.common.StoreCookieS2CPacket;
import net.minecraft.network.packet.s2c.common.SynchronizeTagsS2CPacket;
import net.minecraft.network.packet.s2c.play.AdvancementUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.BlockBreakingProgressS2CPacket;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.BlockEventS2CPacket;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.BossBarS2CPacket;
import net.minecraft.network.packet.s2c.play.BundleS2CPacket;
import net.minecraft.network.packet.s2c.play.ChatMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.ChatSuggestionsS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkBiomeDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkLoadDistanceS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkRenderDistanceCenterS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkSentS2CPacket;
import net.minecraft.network.packet.s2c.play.ClearTitleS2CPacket;
import net.minecraft.network.packet.s2c.play.CloseScreenS2CPacket;
import net.minecraft.network.packet.s2c.play.CommandSuggestionsS2CPacket;
import net.minecraft.network.packet.s2c.play.CommandTreeS2CPacket;
import net.minecraft.network.packet.s2c.play.CooldownUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.CraftFailedResponseS2CPacket;
import net.minecraft.network.packet.s2c.play.DamageTiltS2CPacket;
import net.minecraft.network.packet.s2c.play.DeathMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.DebugSampleS2CPacket;
import net.minecraft.network.packet.s2c.play.DifficultyS2CPacket;
import net.minecraft.network.packet.s2c.play.EndCombatS2CPacket;
import net.minecraft.network.packet.s2c.play.EnterCombatS2CPacket;
import net.minecraft.network.packet.s2c.play.EnterReconfigurationS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitiesDestroyS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityAttachS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityAttributesS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityEquipmentUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPassengersSetS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPositionSyncS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitySetHeadYawS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityStatusEffectS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityTrackerUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ExperienceBarUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ExperienceOrbSpawnS2CPacket;
import net.minecraft.network.packet.s2c.play.ExplosionS2CPacket;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.network.packet.s2c.play.HealthUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;
import net.minecraft.network.packet.s2c.play.ItemPickupAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.LightUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.LookAtS2CPacket;
import net.minecraft.network.packet.s2c.play.MapUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.MoveMinecartAlongTrackS2CPacket;
import net.minecraft.network.packet.s2c.play.NbtQueryResponseS2CPacket;
import net.minecraft.network.packet.s2c.play.OpenHorseScreenS2CPacket;
import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;
import net.minecraft.network.packet.s2c.play.OpenWrittenBookS2CPacket;
import net.minecraft.network.packet.s2c.play.OverlayMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.ParticleS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundFromEntityS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerAbilitiesS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerActionResponseS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerListHeaderS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRemoveS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRespawnS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRotationS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerSpawnPositionS2CPacket;
import net.minecraft.network.packet.s2c.play.ProfilelessChatMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.ProjectilePowerS2CPacket;
import net.minecraft.network.packet.s2c.play.RecipeBookAddS2CPacket;
import net.minecraft.network.packet.s2c.play.RecipeBookRemoveS2CPacket;
import net.minecraft.network.packet.s2c.play.RecipeBookSettingsS2CPacket;
import net.minecraft.network.packet.s2c.play.RemoveEntityStatusEffectS2CPacket;
import net.minecraft.network.packet.s2c.play.RemoveMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.ScoreboardDisplayS2CPacket;
import net.minecraft.network.packet.s2c.play.ScoreboardObjectiveUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ScoreboardScoreResetS2CPacket;
import net.minecraft.network.packet.s2c.play.ScoreboardScoreUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ScreenHandlerPropertyUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.SelectAdvancementTabS2CPacket;
import net.minecraft.network.packet.s2c.play.ServerMetadataS2CPacket;
import net.minecraft.network.packet.s2c.play.SetCameraEntityS2CPacket;
import net.minecraft.network.packet.s2c.play.SetCursorItemS2CPacket;
import net.minecraft.network.packet.s2c.play.SetPlayerInventoryS2CPacket;
import net.minecraft.network.packet.s2c.play.SetTradeOffersS2CPacket;
import net.minecraft.network.packet.s2c.play.SignEditorOpenS2CPacket;
import net.minecraft.network.packet.s2c.play.SimulationDistanceS2CPacket;
import net.minecraft.network.packet.s2c.play.StartChunkSendS2CPacket;
import net.minecraft.network.packet.s2c.play.StatisticsS2CPacket;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.network.packet.s2c.play.SynchronizeRecipesS2CPacket;
import net.minecraft.network.packet.s2c.play.TeamS2CPacket;
import net.minecraft.network.packet.s2c.play.TickStepS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.network.packet.s2c.play.UnloadChunkS2CPacket;
import net.minecraft.network.packet.s2c.play.UpdateSelectedSlotS2CPacket;
import net.minecraft.network.packet.s2c.play.UpdateTickRateS2CPacket;
import net.minecraft.network.packet.s2c.play.VehicleMoveS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderCenterChangedS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderInterpolateSizeS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderSizeChangedS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderWarningBlocksChangedS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderWarningTimeChangedS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldEventS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.network.packet.s2c.query.PingResultS2CPacket;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import rockstar.client.IIIIIIIi_Class2;
import rockstar.client.IIIIIiIi_Class6;
import rockstar.client.RockstarClient;
import rockstar.client.iiiiiIi_Class126;
import rockstar.client.iiiiiii_Class128;

public class IIIIIIiI_Class3
implements ClientPlayPacketListener,
TickablePacketListener {
    private final iiiiiIi_Class126 I_field_c2f14fac;
    private final iiiiiii_Class128 I_field_c2f1c7cc;
    private final IIIIIiIi_Class6 I_field_416dd741;
    private final GameProfile I_field_123e6599;

    public IIIIIIiI_Class3(iiiiiIi_Class126 iiiiiIi_Class1262, iiiiiii_Class128 iiiiiii_Class1282, GameProfile gameProfile) {
        this.I_field_c2f14fac = iiiiiIi_Class1262;
        this.I_field_c2f1c7cc = iiiiiii_Class1282;
        this.I_field_416dd741 = iiiiiii_Class1282.I_method_e09ce338();
        this.I_field_123e6599 = gameProfile;
    }

    public void tick() {
    }

    public void onGameJoin(GameJoinS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_f218e83(packet);
        this.I_field_416dd741.Ii_method_ea4e596e(packet.playerEntityId());
        RockstarClient.I_field_ab0f6068.info("Bot {} joined game with entity id {}", (Object)this.I_field_c2f1c7cc.I_method_7b75de01(), (Object)packet.playerEntityId());
    }

    public void onPlayerPositionLook(PlayerPositionLookS2CPacket packet) {
        PlayerPosition playerPosition = packet.change();
        this.I_field_416dd741.I_method_f21a8072(playerPosition.position().x, playerPosition.position().y, playerPosition.position().z);
        this.I_field_416dd741.I_method_e6c7f98c(playerPosition.yaw(), playerPosition.pitch());
        this.I_field_416dd741.II_method_e88ba91f(true);
        this.I_field_c2f1c7cc.Ii_method_c7583872(true);
        this.I_field_c2f1c7cc.I_method_1729e358().i_method_1f8cdacd(this.I_field_416dd741);
        this.I_field_c2f14fac.I_method_b3d92748().send((Packet)new TeleportConfirmC2SPacket(packet.teleportId()));
    }

    public void onHealthUpdate(HealthUpdateS2CPacket packet) {
        this.I_field_416dd741.II_method_e88b5e0b(packet.getHealth());
        this.I_field_416dd741.i_method_a61c0017(packet.getFood());
        if (this.I_field_416dd741.i_method_68748070() && this.I_field_c2f1c7cc.I_method_e08ecf78().i_method_9164cb0()) {
            this.I_field_c2f14fac.I_method_b3d92748().send((Packet)new ClientStatusC2SPacket(ClientStatusC2SPacket.Mode.PERFORM_RESPAWN));
        }
    }

    public void onKeepAlive(KeepAliveS2CPacket packet) {
        this.I_field_c2f14fac.I_method_b3d92748().send((Packet)new KeepAliveC2SPacket(packet.getId()));
    }

    public void onDisconnect(DisconnectS2CPacket packet) {
        String string = packet.reason().getString();
        this.I_field_c2f14fac.i_method_e2b42049("Disconnected: " + string);
        RockstarClient.I_field_ab0f6068.info("Bot {} disconnected: {}", (Object)this.I_field_c2f1c7cc.I_method_7b75de01(), (Object)string);
    }

    public void onPing(CommonPingS2CPacket packet) {
        this.I_field_c2f14fac.I_method_b3d92748().send((Packet)new CommonPongC2SPacket(packet.getParameter()));
    }

    public void onUpdateSelectedSlot(UpdateSelectedSlotS2CPacket packet) {
        this.I_field_416dd741.II_method_e88b694e(packet.slot());
    }

    public void onExperienceBarUpdate(ExperienceBarUpdateS2CPacket packet) {
        this.I_field_416dd741.I_method_f2390814(packet.getBarProgress(), packet.getExperienceLevel(), packet.getExperience());
    }

    public void onPlayerRespawn(PlayerRespawnS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_fe2dea98(packet);
        this.I_field_416dd741.i_method_6874806c();
        this.I_field_416dd741.II_method_e88b5e0b(20.0f);
    }

    public void onDeathMessage(DeathMessageS2CPacket packet) {
        if (this.I_field_c2f1c7cc.I_method_e08ecf78().i_method_9164cb0()) {
            this.I_field_c2f14fac.I_method_b3d92748().send((Packet)new ClientStatusC2SPacket(ClientStatusC2SPacket.Mode.PERFORM_RESPAWN));
        }
    }

    public void onScreenHandlerSlotUpdate(ScreenHandlerSlotUpdateS2CPacket packet) {
        if (packet.getSyncId() == 0) {
            this.I_field_416dd741.i_method_3b0b1739(packet.getSlot(), packet.getStack());
        } else {
            this.I_field_416dd741.I_method_727a05b9(packet.getSyncId(), packet.getRevision(), packet.getSlot(), packet.getStack());
        }
    }

    public void onInventory(InventoryS2CPacket packet) {
        if (packet.getSyncId() == 0) {
            this.I_field_416dd741.I_method_add1e97d(packet.getContents());
        } else {
            this.I_field_416dd741.I_method_996e96dd(packet.getSyncId(), packet.getRevision(), packet.getContents());
        }
    }

    public void onEntityVelocityUpdate(EntityVelocityUpdateS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_4f0f8510(packet);
    }

    public void onEntityPosition(EntityPositionS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_55e44c33(packet);
    }

    public void onEntityPositionSync(EntityPositionSyncS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_44d986ee(packet);
    }

    public void onCustomPayload(CustomPayloadS2CPacket packet) {
    }

    public void onResourcePackSend(ResourcePackSendS2CPacket packet) {
        this.I_field_c2f14fac.I_method_b3d92748().send((Packet)new ResourcePackStatusC2SPacket(packet.id(), ResourcePackStatusC2SPacket.Status.SUCCESSFULLY_LOADED));
    }

    public void onResourcePackRemove(ResourcePackRemoveS2CPacket packet) {
    }

    public void onSynchronizeTags(SynchronizeTagsS2CPacket packet) {
    }

    public void onStoreCookie(StoreCookieS2CPacket packet) {
    }

    public void onServerTransfer(ServerTransferS2CPacket packet) {
    }

    public void onCustomReportDetails(CustomReportDetailsS2CPacket packet) {
    }

    public void onServerLinks(ServerLinksS2CPacket packet) {
    }

    public void onCookieRequest(CookieRequestS2CPacket packet) {
    }

    public void onDisconnected(DisconnectionInfo info) {
        this.I_field_c2f14fac.i_method_e2b42049(info.reason().getString());
        RockstarClient.I_field_ab0f6068.info("Bot {} connection closed", (Object)this.I_field_c2f1c7cc.I_method_7b75de01());
    }

    public boolean isConnectionOpen() {
        return this.I_field_c2f14fac.I_method_b3d92748() != null && this.I_field_c2f14fac.I_method_b3d92748().isOpen();
    }

    public NetworkPhase getPhase() {
        return NetworkPhase.PLAY;
    }

    public void addCustomCrashReportInfo(CrashReport report, CrashReportSection section) {
        section.add("Bot", (Object)this.I_field_c2f1c7cc.I_method_7b75de01());
        section.add("Connection State", (Object)this.I_field_c2f14fac.I_method_f12cd4f5().toString());
    }

    public void onEntitySpawn(EntitySpawnS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_eb47a4a9(packet);
    }

    public void onExperienceOrbSpawn(ExperienceOrbSpawnS2CPacket packet) {
    }

    public void onScoreboardObjectiveUpdate(ScoreboardObjectiveUpdateS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_a09b06bf(packet);
    }

    public void onEntityAnimation(EntityAnimationS2CPacket packet) {
    }

    public void onDamageTilt(DamageTiltS2CPacket packet) {
    }

    public void onStatistics(StatisticsS2CPacket packet) {
    }

    public void onRecipeBookAdd(RecipeBookAddS2CPacket packet) {
    }

    public void onRecipeBookRemove(RecipeBookRemoveS2CPacket packet) {
    }

    public void onRecipeBookSettings(RecipeBookSettingsS2CPacket packet) {
    }

    public void onBlockBreakingProgress(BlockBreakingProgressS2CPacket packet) {
    }

    public void onSignEditorOpen(SignEditorOpenS2CPacket packet) {
    }

    public void onBlockEntityUpdate(BlockEntityUpdateS2CPacket packet) {
    }

    public void onBlockEvent(BlockEventS2CPacket packet) {
    }

    public void onBlockUpdate(BlockUpdateS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_fb917e07(packet);
    }

    public void onGameMessage(GameMessageS2CPacket packet) {
        IIIIIIIi_Class2.I_method_70b3dfcb().I_method_ebbe26e8(this.I_field_c2f1c7cc, packet.content().getString());
    }

    public void onChatMessage(ChatMessageS2CPacket packet) {
        if (packet.unsignedContent() != null) {
            IIIIIIIi_Class2.I_method_70b3dfcb().I_method_ebbe26e8(this.I_field_c2f1c7cc, packet.unsignedContent().getString());
        }
    }

    public void onProfilelessChatMessage(ProfilelessChatMessageS2CPacket packet) {
        IIIIIIIi_Class2.I_method_70b3dfcb().I_method_ebbe26e8(this.I_field_c2f1c7cc, packet.message().getString());
    }

    public void onRemoveMessage(RemoveMessageS2CPacket packet) {
    }

    public void onChunkDeltaUpdate(ChunkDeltaUpdateS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_98cc913b(packet);
    }

    public void onMapUpdate(MapUpdateS2CPacket packet) {
    }

    public void onCloseScreen(CloseScreenS2CPacket packet) {
        this.I_field_416dd741.I_method_a4590ff7(packet.getSyncId());
    }

    public void onOpenHorseScreen(OpenHorseScreenS2CPacket packet) {
        this.I_field_416dd741.I_method_8dfcca01(packet.getSyncId(), "Horse " + packet.getHorseId());
    }

    public void onScreenHandlerPropertyUpdate(ScreenHandlerPropertyUpdateS2CPacket packet) {
    }

    public void onEntityStatus(EntityStatusS2CPacket packet) {
    }

    public void onEntityAttach(EntityAttachS2CPacket packet) {
    }

    public void onEntityPassengersSet(EntityPassengersSetS2CPacket packet) {
    }

    public void onExplosion(ExplosionS2CPacket packet) {
    }

    public void onGameStateChange(GameStateChangeS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_c90226a0(packet);
    }

    public void onChunkData(ChunkDataS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_c57461c8(packet);
    }

    public void onChunkBiomeData(ChunkBiomeDataS2CPacket packet) {
    }

    public void onUnloadChunk(UnloadChunkS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_2881ff06(packet.pos());
    }

    public void onWorldEvent(WorldEventS2CPacket packet) {
    }

    public void onEntity(EntityS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_9de0826a(packet);
    }

    public void onMoveMinecartAlongTrack(MoveMinecartAlongTrackS2CPacket packet) {
    }

    public void onPlayerRotation(PlayerRotationS2CPacket packet) {
    }

    public void onParticle(ParticleS2CPacket packet) {
    }

    public void onPlayerAbilities(PlayerAbilitiesS2CPacket packet) {
        this.I_field_416dd741.I_method_7b63288c(packet.isInvulnerable(), packet.isFlying(), packet.allowFlying(), packet.isCreativeMode(), packet.getFlySpeed(), packet.getWalkSpeed());
    }

    public void onPlayerRemove(PlayerRemoveS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_221a8a0c(packet);
    }

    public void onPlayerList(PlayerListS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_41256e26(packet);
    }

    public void onEntitiesDestroy(EntitiesDestroyS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_f54b384a(packet);
    }

    public void onRemoveEntityStatusEffect(RemoveEntityStatusEffectS2CPacket packet) {
    }

    public void onEntitySetHeadYaw(EntitySetHeadYawS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_52b2db37(packet);
    }

    public void onScoreboardDisplay(ScoreboardDisplayS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_a371f11f(packet);
    }

    public void onEntityTrackerUpdate(EntityTrackerUpdateS2CPacket packet) {
    }

    public void onEntityEquipmentUpdate(EntityEquipmentUpdateS2CPacket packet) {
        if (packet.getEntityId() != this.I_field_416dd741.II_method_a4679448() && packet.getEntityId() != this.I_field_c2f1c7cc.I_method_1729e358().II_method_b495a828()) {
            return;
        }
        for (Pair pair : packet.getEquipmentList()) {
            this.I_field_416dd741.I_method_91c69b29((EquipmentSlot)pair.getFirst(), (ItemStack)pair.getSecond());
        }
    }

    public void onTeam(TeamS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_cd5650a4(packet);
    }

    public void onScoreboardScoreUpdate(ScoreboardScoreUpdateS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_f076c058(packet);
    }

    public void onScoreboardScoreReset(ScoreboardScoreResetS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_cb1a92d8(packet);
    }

    public void onPlayerSpawnPosition(PlayerSpawnPositionS2CPacket packet) {
    }

    public void onWorldTimeUpdate(WorldTimeUpdateS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_14617f9(packet);
    }

    public void onPlaySound(PlaySoundS2CPacket packet) {
    }

    public void onPlaySoundFromEntity(PlaySoundFromEntityS2CPacket packet) {
    }

    public void onItemPickupAnimation(ItemPickupAnimationS2CPacket packet) {
    }

    public void onUpdateTickRate(UpdateTickRateS2CPacket packet) {
    }

    public void onTickStep(TickStepS2CPacket packet) {
    }

    public void onEntityAttributes(EntityAttributesS2CPacket packet) {
    }

    public void onEntityStatusEffect(EntityStatusEffectS2CPacket packet) {
    }

    public void onEndCombat(EndCombatS2CPacket packet) {
    }

    public void onEnterCombat(EnterCombatS2CPacket packet) {
    }

    public void onDifficulty(DifficultyS2CPacket packet) {
    }

    public void onSetCameraEntity(SetCameraEntityS2CPacket packet) {
    }

    public void onWorldBorderInitialize(WorldBorderInitializeS2CPacket packet) {
    }

    public void onWorldBorderInterpolateSize(WorldBorderInterpolateSizeS2CPacket packet) {
    }

    public void onWorldBorderSizeChanged(WorldBorderSizeChangedS2CPacket packet) {
    }

    public void onWorldBorderWarningTimeChanged(WorldBorderWarningTimeChangedS2CPacket packet) {
    }

    public void onWorldBorderWarningBlocksChanged(WorldBorderWarningBlocksChangedS2CPacket packet) {
    }

    public void onWorldBorderCenterChanged(WorldBorderCenterChangedS2CPacket packet) {
    }

    public void onPlayerListHeader(PlayerListHeaderS2CPacket packet) {
    }

    public void onBossBar(BossBarS2CPacket packet) {
    }

    public void onCooldownUpdate(CooldownUpdateS2CPacket packet) {
    }

    public void onVehicleMove(VehicleMoveS2CPacket packet) {
    }

    public void onAdvancements(AdvancementUpdateS2CPacket packet) {
    }

    public void onSelectAdvancementTab(SelectAdvancementTabS2CPacket packet) {
    }

    public void onCraftFailedResponse(CraftFailedResponseS2CPacket packet) {
    }

    public void onCommandTree(CommandTreeS2CPacket packet) {
    }

    public void onStopSound(StopSoundS2CPacket packet) {
    }

    public void onCommandSuggestions(CommandSuggestionsS2CPacket packet) {
    }

    public void onSynchronizeRecipes(SynchronizeRecipesS2CPacket packet) {
    }

    public void onLookAt(LookAtS2CPacket packet) {
    }

    public void onNbtQueryResponse(NbtQueryResponseS2CPacket packet) {
    }

    public void onLightUpdate(LightUpdateS2CPacket packet) {
    }

    public void onOpenWrittenBook(OpenWrittenBookS2CPacket packet) {
    }

    public void onOpenScreen(OpenScreenS2CPacket packet) {
        this.I_field_416dd741.I_method_8dfcca01(packet.getSyncId(), packet.getName().getString());
    }

    public void onSetTradeOffers(SetTradeOffersS2CPacket packet) {
    }

    public void onChunkLoadDistance(ChunkLoadDistanceS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_3517ed99(packet);
    }

    public void onSimulationDistance(SimulationDistanceS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_286917a3(packet);
    }

    public void onChunkRenderDistanceCenter(ChunkRenderDistanceCenterS2CPacket packet) {
        this.I_field_c2f1c7cc.I_method_1729e358().I_method_6a0a14fe(packet);
    }

    public void onPlayerActionResponse(PlayerActionResponseS2CPacket packet) {
        this.I_field_416dd741.IiI_method_613f4eb7(packet.sequence());
    }

    public void onOverlayMessage(OverlayMessageS2CPacket packet) {
    }

    public void onSubtitle(SubtitleS2CPacket packet) {
    }

    public void onTitle(TitleS2CPacket packet) {
    }

    public void onTitleFade(TitleFadeS2CPacket packet) {
    }

    public void onTitleClear(ClearTitleS2CPacket packet) {
    }

    public void onServerMetadata(ServerMetadataS2CPacket packet) {
    }

    public void onChatSuggestions(ChatSuggestionsS2CPacket packet) {
    }

    public void onBundle(BundleS2CPacket packet) {
    }

    public void onEntityDamage(EntityDamageS2CPacket packet) {
    }

    public void onEnterReconfiguration(EnterReconfigurationS2CPacket packet) {
    }

    public void onStartChunkSend(StartChunkSendS2CPacket packet) {
    }

    public void onChunkSent(ChunkSentS2CPacket packet) {
    }

    public void onDebugSample(DebugSampleS2CPacket packet) {
    }

    public void onProjectilePower(ProjectilePowerS2CPacket packet) {
    }

    public void onSetCursorItem(SetCursorItemS2CPacket packet) {
        this.I_field_416dd741.i_method_a8ce14ce(packet.contents());
    }

    public void onSetPlayerInventory(SetPlayerInventoryS2CPacket packet) {
        this.I_field_416dd741.I_method_5ff31f19(packet.slot(), packet.contents());
    }

    public void onPingResult(PingResultS2CPacket packet) {
    }

    @Generated
    public iiiiiIi_Class126 I_method_f9671a42() {
        return this.I_field_c2f14fac;
    }

    @Generated
    public iiiiiii_Class128 I_method_f9679262() {
        return this.I_field_c2f1c7cc;
    }

    @Generated
    public IIIIIiIi_Class6 I_method_d9b15f6b() {
        return this.I_field_416dd741;
    }

    @Generated
    public GameProfile I_method_2981a643() {
        return this.I_field_123e6599;
    }
}

