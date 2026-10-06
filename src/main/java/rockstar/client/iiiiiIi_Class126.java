package rockstar.client;

import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.function.Consumer;
import lombok.Generated;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.login.LoginHelloC2SPacket;
import net.minecraft.network.state.LoginStates;
import net.minecraft.text.Text;
import net.minecraft.util.profiler.MultiValueDebugSampleLogImpl;

public class iiiiiIi_Class126 {
   private final iiiiiii_Class128 I_field_c2f1c7cc;
   private ClientConnection I_field_e1978b71;
   private iiiiiiI_Class127 I_field_c2f1c3ec;
   private Consumer<String> I_field_f9f609fa;
   private Consumer<Void> i_field_f9f609fa;
   private Consumer<String> II_field_f9f609fa;
   private long I_field_4a;
   private long i_field_4a;

   public iiiiiIi_Class126(iiiiiii_Class128 var1) {
      this.I_field_c2f1c3ec = iiiiiiI_Class127.I_field_c2f1c3ec;
      this.I_field_4a = 0L;
      this.i_field_4a = 0L;
      this.I_field_c2f1c7cc = var1;
   }

   public void I_method_2d9d33ba(String var1, int var2) {
      if (this.I_field_c2f1c3ec == iiiiiiI_Class127.I_field_c2f1c3ec) {
         this.I_field_c2f1c3ec = iiiiiiI_Class127.i_field_c2f1c3ec;

         try {
            InetSocketAddress var3 = new InetSocketAddress(var1, var2);
            this.I_field_e1978b71 = ClientConnection.connect(var3, false, (MultiValueDebugSampleLogImpl)null);
            IIIIIIII var4 = new IIIIIIII(this, this.I_field_c2f1c7cc);
            this.I_field_e1978b71.connect(var1, var2, LoginStates.C2S, LoginStates.S2C, var4, false);
            UUID var5 = UUID.nameUUIDFromBytes(("OfflinePlayer:" + this.I_field_c2f1c7cc.I_method_7b75de01()).getBytes());
            this.I_field_e1978b71.send(new LoginHelloC2SPacket(this.I_field_c2f1c7cc.I_method_7b75de01(), var5));
            this.I_field_c2f1c3ec = iiiiiiI_Class127.II_field_c2f1c3ec;
         } catch (Exception var6) {
            this.I_field_c2f1c3ec = iiiiiiI_Class127.I_field_c2f1c3ec;
            if (this.I_field_f9f609fa != null) {
               this.I_field_f9f609fa.accept("Connection failed: " + var6.getMessage());
            }

            RockstarClient.I_field_ab0f6068.error("Bot {} failed to connect: {}", this.I_field_c2f1c7cc.I_method_7b75de01(), var6.getMessage());
         }
      }
   }

   public void I_method_dc5c5f() {
      if (this.I_field_e1978b71 != null && this.I_field_e1978b71.isOpen()) {
         this.I_field_c2f1c3ec = iiiiiiI_Class127.ii_field_c2f1c3ec;
         this.I_field_e1978b71.disconnect(Text.literal("Bot disconnected"));
      }

      this.i_method_e2b42049("Disconnected");
   }

   public void I_method_f0d1c168(Packet<?> var1) {
      if (this.I_field_e1978b71 != null && this.I_field_e1978b71.isOpen() && this.I_field_c2f1c3ec.II_method_7a1c5aa6()) {
         this.I_field_e1978b71.send(var1);
      }
   }

   public boolean I_method_dc5c63() {
      return this.I_field_e1978b71 != null && this.I_field_e1978b71.isOpen() && this.I_field_c2f1c3ec == iiiiiiI_Class127.iI_field_c2f1c3ec;
   }

   public void i_method_eae83f() {
      if (this.I_field_e1978b71 != null) {
         this.I_field_e1978b71.tick();
         if (!this.I_field_e1978b71.isOpen() && this.I_field_c2f1c3ec != iiiiiiI_Class127.I_field_c2f1c3ec) {
            this.i_method_e2b42049("Connection lost");
         }
      }
   }

   public void I_method_1aafa284(int var1) {
      if (this.I_field_e1978b71 != null && !this.I_field_e1978b71.isLocal()) {
         this.I_field_e1978b71.setCompressionThreshold(var1, false);
      }
   }

   public void I_method_8bb692f5(Consumer<String> var1) {
      this.I_field_f9f609fa = var1;
   }

   public void i_method_46ae1315(Consumer<Void> var1) {
      this.i_field_f9f609fa = var1;
   }

   public void II_method_813cdb52(Consumer<String> var1) {
      this.II_field_f9f609fa = var1;
   }

   void II_method_1abe26e2() {
      this.I_field_c2f1c3ec = iiiiiiI_Class127.iI_field_c2f1c3ec;
      this.I_field_c2f1c7cc.I_method_1729e358().I_method_9235e4ac();
      if (this.i_field_f9f609fa != null) {
         this.i_field_f9f609fa.accept(null);
      }
   }

   void I_method_11fccc69(String var1) {
      if (this.I_field_f9f609fa != null) {
         this.I_field_f9f609fa.accept(var1);
      }
   }

   void i_method_e2b42049(String var1) {
      if (this.I_field_c2f1c3ec != iiiiiiI_Class127.I_field_c2f1c3ec) {
         this.I_field_c2f1c3ec = iiiiiiI_Class127.I_field_c2f1c3ec;
         this.I_field_c2f1c7cc.I_method_1729e358().i_method_9244708c();
         if (this.II_field_f9f609fa != null) {
            this.II_field_f9f609fa.accept(var1);
         }
      }
   }

   @Generated
   public iiiiiii_Class128 I_method_f12cd8d5() {
      return this.I_field_c2f1c7cc;
   }

   @Generated
   public ClientConnection I_method_b3d92748() {
      return this.I_field_e1978b71;
   }

   @Generated
   public iiiiiiI_Class127 I_method_f12cd4f5() {
      return this.I_field_c2f1c3ec;
   }

   @Generated
   public Consumer<String> I_method_82bf6e83() {
      return this.I_field_f9f609fa;
   }

   @Generated
   public Consumer<Void> i_method_88c76a63() {
      return this.i_field_f9f609fa;
   }

   @Generated
   public Consumer<String> II_method_1f502686() {
      return this.II_field_f9f609fa;
   }

   @Generated
   public long I_method_dc5c53() {
      return this.I_field_4a;
   }

   @Generated
   public long i_method_eae833() {
      return this.i_field_4a;
   }

   @Generated
   public void I_method_38bbdf67(iiiiiiI_Class127 var1) {
      this.I_field_c2f1c3ec = var1;
   }
}
