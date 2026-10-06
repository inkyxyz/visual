package rockstar.client;

import com.mojang.authlib.GameProfile;
import java.util.Collections;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.NetworkPhase;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.listener.ClientConfigurationPacketListener;
import net.minecraft.network.packet.c2s.common.CommonPongC2SPacket;
import net.minecraft.network.packet.c2s.common.KeepAliveC2SPacket;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket.Status;
import net.minecraft.network.packet.c2s.config.ReadyC2SPacket;
import net.minecraft.network.packet.c2s.config.SelectKnownPacksC2SPacket;
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
import net.minecraft.network.packet.s2c.config.DynamicRegistriesS2CPacket;
import net.minecraft.network.packet.s2c.config.FeaturesS2CPacket;
import net.minecraft.network.packet.s2c.config.ReadyS2CPacket;
import net.minecraft.network.packet.s2c.config.ResetChatS2CPacket;
import net.minecraft.network.packet.s2c.config.SelectKnownPacksS2CPacket;
import net.minecraft.network.state.PlayStateFactories;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.registry.DynamicRegistryManager.Immutable;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;

public class iiiiiII_Class125 implements ClientConfigurationPacketListener {
   private final iiiiiIi_Class126 I_field_c2f14fac;
   private final iiiiiii_Class128 I_field_c2f1c7cc;
   private final GameProfile I_field_123e6599;
   private Immutable I_field_b2fbf0da;

   public iiiiiII_Class125(iiiiiIi_Class126 var1, iiiiiii_Class128 var2, GameProfile var3) {
      this.I_field_c2f14fac = var1;
      this.I_field_c2f1c7cc = var2;
      this.I_field_123e6599 = var3;
   }

   public void onReady(ReadyS2CPacket packet) {
      Immutable var2;
      if (this.I_field_b2fbf0da != null) {
         var2 = this.I_field_b2fbf0da;
      } else if (MinecraftClient.getInstance().world != null) {
         var2 = MinecraftClient.getInstance().world.getRegistryManager().toImmutable();
      } else {
         var2 = DynamicRegistryManager.of(Registries.REGISTRIES);
      }

      IIIIIIiI_Class3 var3 = new IIIIIIiI_Class3(this.I_field_c2f14fac, this.I_field_c2f1c7cc, this.I_field_123e6599);
      this.I_field_c2f14fac.I_method_b3d92748().transitionInbound(PlayStateFactories.S2C.bind(RegistryByteBuf.makeFactory(var2)), var3);
      this.I_field_c2f14fac.I_method_b3d92748().send(ReadyC2SPacket.INSTANCE);
      this.I_field_c2f14fac.I_method_b3d92748().transitionOutbound(PlayStateFactories.C2S.bind(RegistryByteBuf.makeFactory(var2)));
      this.I_field_c2f1c7cc.I_method_1da6a560(var3);
      this.I_field_c2f14fac.I_method_38bbdf67(iiiiiiI_Class127.iI_field_c2f1c3ec);
      this.I_field_c2f14fac.II_method_1abe26e2();
      RockstarClient.I_field_ab0f6068.info("Bot {} entered play state", this.I_field_c2f1c7cc.I_method_7b75de01());
   }

   public void onDynamicRegistries(DynamicRegistriesS2CPacket packet) {
   }

   public void onFeatures(FeaturesS2CPacket packet) {
   }

   public void onSelectKnownPacks(SelectKnownPacksS2CPacket packet) {
      this.I_field_c2f14fac.I_method_b3d92748().send(new SelectKnownPacksC2SPacket(Collections.emptyList()));
   }

   public void onResetChat(ResetChatS2CPacket packet) {
   }

   public void onKeepAlive(KeepAliveS2CPacket packet) {
      this.I_field_c2f14fac.I_method_b3d92748().send(new KeepAliveC2SPacket(packet.getId()));
   }

   public void onPing(CommonPingS2CPacket packet) {
      this.I_field_c2f14fac.I_method_b3d92748().send(new CommonPongC2SPacket(packet.getParameter()));
   }

   public void onCustomPayload(CustomPayloadS2CPacket packet) {
   }

   public void onDisconnect(DisconnectS2CPacket packet) {
      String var2 = packet.reason().getString();
      this.I_field_c2f14fac.I_method_11fccc69("Disconnected during configuration: " + var2);
      RockstarClient.I_field_ab0f6068.warn("Bot {} config disconnect: {}", this.I_field_c2f1c7cc.I_method_7b75de01(), var2);
   }

   public void onResourcePackSend(ResourcePackSendS2CPacket packet) {
      this.I_field_c2f14fac.I_method_b3d92748().send(new ResourcePackStatusC2SPacket(packet.id(), Status.SUCCESSFULLY_LOADED));
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
      this.I_field_c2f14fac.I_method_11fccc69("Disconnected during configuration: " + info.reason().getString());
      this.I_field_c2f14fac.I_method_38bbdf67(iiiiiiI_Class127.I_field_c2f1c3ec);
   }

   public boolean isConnectionOpen() {
      return this.I_field_c2f14fac.I_method_b3d92748() != null && this.I_field_c2f14fac.I_method_b3d92748().isOpen();
   }

   public NetworkPhase getPhase() {
      return NetworkPhase.CONFIGURATION;
   }

   public void addCustomCrashReportInfo(CrashReport report, CrashReportSection section) {
      section.add("Bot", this.I_field_c2f1c7cc.I_method_7b75de01());
      section.add("Connection State", this.I_field_c2f14fac.I_method_f12cd4f5().toString());
   }

   @Generated
   public iiiiiIi_Class126 I_method_db96ecd5() {
      return this.I_field_c2f14fac;
   }

   @Generated
   public iiiiiii_Class128 I_method_db9764f5() {
      return this.I_field_c2f1c7cc;
   }

   @Generated
   public GameProfile I_method_a18e5850() {
      return this.I_field_123e6599;
   }

   @Generated
   public Immutable I_method_6d7aaa03() {
      return this.I_field_b2fbf0da;
   }
}
