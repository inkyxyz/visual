package globals.client.crypto;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicLong;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ClientCrypto {
   private static final int AES_KEY_LEN = 32;
   private static final int NONCE_LEN = 12;
   private static final int GCM_TAG_BITS = 128;
   private static final String RSA_TRANSFORM = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
   private static final byte[] INFO_C2S = "globals:c2s".getBytes(StandardCharsets.UTF_8);
   private static final byte[] INFO_S2C = "globals:s2c".getBytes(StandardCharsets.UTF_8);
   private final PublicKey serverKey;
   private byte[] sendKey;
   private byte[] recvKey;
   private final AtomicLong sendCounter = new AtomicLong(0L);
   private final AtomicLong recvHighWater = new AtomicLong(-1L);

   public ClientCrypto(String var1) {
      try {
         byte[] var2 = Base64.getDecoder().decode(var1.trim());
         this.serverKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(var2));
      } catch (Exception var3) {
         throw new IllegalStateException("Bad server public key", var3);
      }
   }

   public String wrapMaster() {
      if (this.sendKey != null) {
         throw new IllegalStateException(
            "ClientCrypto \u0443\u0436\u0435 \u0438\u043d\u0438\u0446\u0438\u0430\u043b\u0438\u0437\u0438\u0440\u043e\u0432\u0430\u043d \u2014 \u043f\u043e\u0432\u0442\u043e\u0440\u043d\u044b\u0439 wrapMaster \u0437\u0430\u043f\u0440\u0435\u0449\u0451\u043d"
         );
      } else {
         byte[] var1 = new byte[32];
         new SecureRandom().nextBytes(var1);
         this.sendKey = hkdf(var1, INFO_C2S);
         this.recvKey = hkdf(var1, INFO_S2C);

         try {
            Cipher var2 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            var2.init(1, this.serverKey);
            return Base64.getEncoder().encodeToString(var2.doFinal(var1));
         } catch (Exception var3) {
            throw new IllegalStateException("RSA wrap failed", var3);
         }
      }
   }

   public ClientCrypto.Nested1_11c7cefe encrypt(byte[] var1) {
      long var2 = this.sendCounter.getAndIncrement();
      byte[] var4 = gcm(1, this.sendKey, var2, var1);
      return new ClientCrypto.Nested1_11c7cefe(var2, Base64.getEncoder().encodeToString(var4));
   }

   public byte[] decrypt(long var1, String var3) {
      if (var1 <= this.recvHighWater.get()) {
         return null;
      } else {
         try {
            byte[] var4 = gcm(2, this.recvKey, var1, Base64.getDecoder().decode(var3));
            this.recvHighWater.updateAndGet(var2 -> Math.max(var2, var1));
            return var4;
         } catch (Exception var5) {
            return null;
         }
      }
   }

   private static byte[] gcm(int var0, byte[] var1, long var2, byte[] var4) {
      try {
         byte[] var5 = ByteBuffer.allocate(12).putInt(0).putLong(var2).array();
         Cipher var6 = Cipher.getInstance("AES/GCM/NoPadding");
         var6.init(var0, new SecretKeySpec(var1, "AES"), new GCMParameterSpec(128, var5));
         return var6.doFinal(var4);
      } catch (Exception var7) {
         throw new IllegalStateException("GCM " + (var0 == 1 ? "encrypt" : "decrypt") + " failed", var7);
      }
   }

   private static byte[] hkdf(byte[] var0, byte[] var1) {
      try {
         Mac var2 = Mac.getInstance("HmacSHA256");
         var2.init(new SecretKeySpec(new byte[32], "HmacSHA256"));
         byte[] var3 = var2.doFinal(var0);
         var2.init(new SecretKeySpec(var3, "HmacSHA256"));
         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         byte[] var5 = new byte[0];

         for (int var6 = 1; var4.size() < 32; var6++) {
            var2.reset();
            var2.update(var5);
            var2.update(var1);
            var2.update((byte)var6);
            var5 = var2.doFinal();
            var4.write(var5, 0, var5.length);
         }

         return Arrays.copyOf(var4.toByteArray(), 32);
      } catch (Exception var7) {
         throw new IllegalStateException("HKDF failed", var7);
      }
   }

   public static final class Nested1_11c7cefe {
      private final long n;
      private final String ct;

      public Nested1_11c7cefe(long var1, String var3) {
         this.n = var1;
         this.ct = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_11c7cefe[n=" + this.n() + ", ct=" + this.ct() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.n());
         result = 31 * result + java.util.Objects.hashCode(this.ct());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ClientCrypto.Nested1_11c7cefe other = (ClientCrypto.Nested1_11c7cefe) var1;
         return java.util.Objects.equals(this.n(), other.n())
            && java.util.Objects.equals(this.ct(), other.ct());
      }

      public long n() {
         return this.n;
      }

      public String ct() {
         return this.ct;
      }
   }
}
