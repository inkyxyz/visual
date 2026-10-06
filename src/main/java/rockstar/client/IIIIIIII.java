package rockstar.client;

import com.mojang.authlib.GameProfile;
import lombok.Generated;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.NetworkPhase;
import net.minecraft.network.listener.ClientLoginPacketListener;
import net.minecraft.network.packet.c2s.login.EnterConfigurationC2SPacket;
import net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket;
import net.minecraft.network.packet.s2c.common.CookieRequestS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginCompressionS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginDisconnectS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginHelloS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginQueryRequestS2CPacket;
import net.minecraft.network.packet.s2c.login.LoginSuccessS2CPacket;
import net.minecraft.network.state.ConfigurationStates;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;

public class IIIIIIII implements ClientLoginPacketListener {
   private final iiiiiIi_Class126 I_field_c2f14fac;
   private final iiiiiii_Class128 I_field_c2f1c7cc;
   private GameProfile I_field_123e6599;

   public IIIIIIII(iiiiiIi_Class126 var1, iiiiiii_Class128 var2) {
      this.I_field_c2f14fac = var1;
      this.I_field_c2f1c7cc = var2;
   }

   public void onHello(LoginHelloS2CPacket packet) {
      this.I_field_c2f14fac.I_method_11fccc69("Server requires online mode authentication");
      this.I_field_c2f14fac.I_method_dc5c5f();
   }

   public void onSuccess(LoginSuccessS2CPacket packet) {
      this.I_field_123e6599 = packet.profile();
      iiiiiII_Class125 var2 = new iiiiiII_Class125(this.I_field_c2f14fac, this.I_field_c2f1c7cc, this.I_field_123e6599);
      this.I_field_c2f14fac.I_method_b3d92748().transitionInbound(ConfigurationStates.S2C, var2);
      this.I_field_c2f14fac.I_method_b3d92748().send(EnterConfigurationC2SPacket.INSTANCE);
      this.I_field_c2f14fac.I_method_b3d92748().transitionOutbound(ConfigurationStates.C2S);
      this.I_field_c2f14fac.I_method_38bbdf67(iiiiiiI_Class127.Ii_field_c2f1c3ec);
      RockstarClient.I_field_ab0f6068.info("Bot {} logged in successfully", this.I_field_c2f1c7cc.I_method_7b75de01());
   }

   public void onDisconnect(LoginDisconnectS2CPacket packet) {
      String var2 = packet.getReason().getString();
      this.I_field_c2f14fac.I_method_11fccc69("Login failed: " + var2);
      RockstarClient.I_field_ab0f6068.warn("Bot {} login disconnect: {}", this.I_field_c2f1c7cc.I_method_7b75de01(), var2);
   }

   public void onCompression(LoginCompressionS2CPacket packet) {
      this.I_field_c2f14fac.I_method_1aafa284(packet.getCompressionThreshold());
   }

   public void onQueryRequest(LoginQueryRequestS2CPacket packet) {
      this.I_field_c2f14fac.I_method_b3d92748().send(new LoginQueryResponseC2SPacket(packet.queryId(), null));
   }

   public void onCookieRequest(CookieRequestS2CPacket packet) {
   }

   public void onDisconnected(DisconnectionInfo info) {
      this.I_field_c2f14fac.I_method_11fccc69("Disconnected during login: " + info.reason().getString());
      this.I_field_c2f14fac.I_method_38bbdf67(iiiiiiI_Class127.I_field_c2f1c3ec);
   }

   public boolean isConnectionOpen() {
      return this.I_field_c2f14fac.I_method_b3d92748() != null && this.I_field_c2f14fac.I_method_b3d92748().isOpen();
   }

   public NetworkPhase getPhase() {
      return NetworkPhase.LOGIN;
   }

   public void addCustomCrashReportInfo(CrashReport report, CrashReportSection section) {
      section.add("Bot", this.I_field_c2f1c7cc.I_method_7b75de01());
      section.add("Connection State", this.I_field_c2f14fac.I_method_f12cd4f5().toString());
   }

   @Generated
   public iiiiiIi_Class126 I_method_5c4e1222() {
      return this.I_field_c2f14fac;
   }

   @Generated
   public iiiiiii_Class128 I_method_5c4e8a42() {
      return this.I_field_c2f1c7cc;
   }

   @Generated
   public GameProfile I_method_ff2e1263() {
      return this.I_field_123e6599;
   }
}
