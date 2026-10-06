package rockstar.client;

import dev.redstones.mediaplayerinfo.IMediaSession;
import dev.redstones.mediaplayerinfo.MediaInfo;
import dev.redstones.mediaplayerinfo.MediaPlayerInfo;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Generated;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pyrock.utility.render.ColorRGBA;

public class iiIiIIIiI_Class419 implements iIIiIIiIi_Class294 {
   private static final Logger I_field_ab0f6068 = LoggerFactory.getLogger("rockstar-lyrics");
   private final Thread I_field_72a5fc31;
   private final AtomicReference<IMediaSession> I_field_c74d0693 = new AtomicReference<>();
   private volatile ColorRGBA I_field_d0c8ec5 = ColorRGBA.WHITE;
   private static final AtomicInteger I_field_bc9b37c0 = new AtomicInteger();
   private volatile Identifier I_field_6a3d6525;
   private String I_field_523beb0a = "";
   private int I_field_49;
   private int i_field_49;
   private static final long I_field_4a = 1500L;
   private volatile long i_field_4a;
   private static final int II_field_49 = 128;
   private static final Executor I_field_54ff24dc = I_method_49211fcf("rockstar-track-lyrics");
   private static final Executor i_field_54ff24dc = I_method_49211fcf("rockstar-track-metadata");
   private final Map<String, iiIiIIIii_Class420> I_field_a567c40b = new ConcurrentHashMap<>();
   private final Map<String, Float> i_field_a567c40b = new ConcurrentHashMap<>();
   private static final long II_field_4a = 15000L;
   private static final int Ii_field_49 = 3;
   private volatile long Ii_field_4a;
   private volatile int iI_field_49;
   private volatile boolean I_field_5a;
   private final Object I_field_5f790d9c = new Object();
   private volatile iiIiIIIii_Class420 I_field_990d92ac = iiIiIIIii_Class420.I_method_6b642b75();
   private volatile String i_field_523beb0a = "";
   private volatile float I_field_46;
   private volatile long iI_field_4a = -1L;
   private volatile long ii_field_4a;
   private volatile boolean i_field_5a;

   private static Executor I_method_49211fcf(String var0) {
      return Executors.newSingleThreadExecutor(var1 -> {
         Thread var2 = new Thread(var1, var0);
         var2.setDaemon(true);
         var2.setPriority(1);
         return var2;
      });
   }

   public iiIiIIIiI_Class419() {
      this.I_field_72a5fc31 = new Thread(() -> {
         while (!Thread.currentThread().isInterrupted()) {
            try {
               long start = System.currentTimeMillis();
               this.I_method_f1206e7f();
               long targetDelay = this.I_field_c74d0693.get() == null ? 800L : 120L;
               long elapsed = System.currentTimeMillis() - start;
               long toSleep = Math.max(50L, targetDelay - elapsed);
               Thread.sleep(toSleep);
            } catch (InterruptedException var5) {
               Thread.currentThread().interrupt();
               break;
            } catch (Throwable t) {
               try {
                  Thread.sleep(1000L);
               } catch (InterruptedException ie) {
                  Thread.currentThread().interrupt();
                  break;
               }
            }
         }
      }, "rockstar-media-poll");
      this.I_field_72a5fc31.setDaemon(true);
      this.I_field_72a5fc31.setPriority(1);
      this.I_field_72a5fc31.start();
   }

   private void I_method_f1206e7f() {
      try {
         List<IMediaSession> var1 = MediaPlayerInfo.INSTANCE.getMediaSessions();
         IMediaSession var2 = var1.stream()
            .filter(var0 -> var0.getMedia() != null && (!var0.getMedia().getTitle().isEmpty() || !var0.getMedia().getArtist().isEmpty()))
            .findFirst()
            .orElse(null);
         if (var2 == null && !var1.isEmpty()) {
            var2 = var1.get(0);
         }
         if (var2 == null && System.currentTimeMillis() - this.i_field_4a < 1500L) {
            return;
         }

         if (var2 != null) {
            this.i_field_4a = System.currentTimeMillis();
         }

         this.I_field_c74d0693.set(var2);
         if (var2 != null) {
            MediaInfo var3 = var2.getMedia();
            String var4 = var3.getArtist() == null || var3.getArtist().isBlank() ? "Аудио" : var3.getArtist();
            String var5 = var3.getTitle() == null || var3.getTitle().isBlank() ? "Трек" : var3.getTitle();
            String var6 = var4 + " - " + var5;
            this.i_field_5a = var3.isPlaying();
            long var7 = var3.getPosition();
            if (var7 != this.iI_field_4a) {
               this.iI_field_4a = var7;
               this.ii_field_4a = System.currentTimeMillis();
            }

            boolean var9;
            synchronized (this.I_field_5f790d9c) {
               var9 = !var6.equals(this.i_field_523beb0a);
               if (var9) {
                  this.i_field_523beb0a = var6;
                  this.I_field_990d92ac = iiIiIIIii_Class420.I_method_6b642b75();
                  this.I_field_46 = 0.0F;
               }
            }

            if (!var9
               && this.I_field_990d92ac.I_method_27bb8263()
               && !this.I_field_5a
               && this.iI_field_49 < 3
               && System.currentTimeMillis() >= this.Ii_field_4a) {
               this.I_method_4312df47(var6, var4, var5, var3.getDuration());
            }

            if (var9) {
               this.iI_field_49 = 0;
               this.Ii_field_4a = 0L;
               if (!this.I_field_5a) {
                  this.I_method_4312df47(var6, var4, var5, var3.getDuration());
               }

               i_field_54ff24dc.execute(() -> {
                  if (var6.equals(this.i_field_523beb0a)) {
                     Float var5x = this.i_field_a567c40b.get(var6);
                     if (var5x == null) {
                        var5x = iiIIiiiiI_Class415.I_method_bf267941(var4, var5, var3.getDuration());
                        if (this.i_field_a567c40b.size() > 64) {
                           this.i_field_a567c40b.clear();
                        }

                        this.i_field_a567c40b.put(var6, var5x);
                     }

                     if (var5x > 0.0F) {
                        synchronized (this.I_field_5f790d9c) {
                           if (var6.equals(this.i_field_523beb0a)) {
                              this.I_field_46 = var5x;
                           }
                        }
                     }
                  }
               });
            }

            this.I_method_163ac7c4(var6, var3.getArtworkPng(), var2.getOwner() != null && var2.getOwner().toLowerCase(Locale.ROOT).contains("spotify"));
         } else {
            this.i_field_5a = false;
            this.I_method_163ac7c4("", null, false);
         }
      } catch (Exception var13) {
      }
   }

   private void I_method_4312df47(String var1, String var2, String var3, long var4) {
      int var6 = ++this.iI_field_49;
      I_field_ab0f6068.info(
         "[lyrics] \u0441\u0442\u0430\u0432\u043b\u044e \u0432 \u043e\u0447\u0435\u0440\u0435\u0434\u044c \u00ab{}\u00bb, \u043f\u043e\u043f\u044b\u0442\u043a\u0430 {}/{}",
         new Object[]{var1, var6, 3}
      );
      this.Ii_field_4a = System.currentTimeMillis() + 15000L;
      this.I_field_5a = true;
      I_field_54ff24dc.execute(
         () -> {
            try {
               if (!var1.equals(this.i_field_523beb0a)) {
                  I_field_ab0f6068.info(
                     "[lyrics] \u00ab{}\u00bb \u043e\u0442\u043c\u0435\u043d\u0451\u043d: \u0438\u0433\u0440\u0430\u0435\u0442 \u0443\u0436\u0435 \u00ab{}\u00bb",
                     var1,
                     this.i_field_523beb0a
                  );
                  return;
               }

               iiIiIIIii_Class420 var7 = this.I_field_a567c40b.get(var1);
               if (var7 != null) {
                  I_field_ab0f6068.info(
                     "[lyrics] \u00ab{}\u00bb \u0443\u0436\u0435 \u0432 \u043a\u044d\u0448\u0435: {} \u0441\u0442\u0440\u043e\u043a",
                     var1,
                     var7.I_method_13376608().size()
                  );
               }

               iiIiIIIii_Class420 var8 = var7 != null ? var7 : iiIiIIiII_Class421.I_method_4e490be7(var2, var3, var4);
               if (var8 == null) {
                  var8 = iiIiIIIii_Class420.I_method_6b642b75();
               }

               if (var8.I_method_27bb8263()) {
                  if (var6 >= 3) {
                     this.I_method_3532263d(var1, var8);
                  }

                  return;
               }

               this.I_method_3532263d(var1, var8);
               synchronized (this.I_field_5f790d9c) {
                  if (var1.equals(this.i_field_523beb0a)) {
                     this.I_field_990d92ac = var8;
                  }
               }
            } finally {
               this.I_field_5a = false;
            }
         }
      );
   }

   private void I_method_3532263d(String var1, iiIiIIIii_Class420 var2) {
      if (this.I_field_a567c40b.size() > 64) {
         this.I_field_a567c40b.clear();
      }

      this.I_field_a567c40b.put(var1, var2);
   }

   public Identifier I_method_2b1658e() {
      return this.I_field_6a3d6525;
   }

   private void I_method_163ac7c4(String var1, byte[] var2, boolean var3) {
      int var4 = var2 != null && var2.length != 0 ? Arrays.hashCode(var2) : 0;
      if (var4 != 0 || !var1.equals(this.I_field_523beb0a)) {
         if (var4 == this.I_field_49) {
            this.I_field_523beb0a = var1;
         } else if (var4 != this.i_field_49) {
            this.i_field_49 = var4;
         } else {
            this.I_field_523beb0a = var1;
            this.I_field_49 = var4;
            if (var4 == 0) {
               this.I_method_67ab8991(null, ColorRGBA.WHITE);
            } else {
               try {
                  NativeImage var5 = NativeImage.read(var2);
                  if (var3) {
                     var5 = this.I_method_1dfe9317(var5);
                  }

                  ColorRGBA var6 = this.I_method_96793884(var5, 16);
                  this.I_method_67ab8991(this.I_method_da2c4f90(var5, 128), var6);
               } catch (RuntimeException | IOException var7) {
                  this.I_method_67ab8991(null, ColorRGBA.WHITE);
               }
            }
         }
      }
   }

   private NativeImage I_method_da2c4f90(NativeImage var1, int var2) {
      int var3 = var1.getWidth();
      int var4 = var1.getHeight();
      if (Math.max(var3, var4) <= var2) {
         return var1;
      } else {
         float var5 = (float)var2 / Math.max(var3, var4);
         NativeImage var6 = new NativeImage(var1.getFormat(), Math.max(1, Math.round(var3 * var5)), Math.max(1, Math.round(var4 * var5)), false);
         var1.resizeSubRectTo(0, 0, var3, var4, var6);
         var1.close();
         return var6;
      }
   }

   private NativeImage I_method_1dfe9317(NativeImage var1) {
      int var2 = var1.getWidth();
      int var3 = var1.getHeight();
      int var4 = (int)(var2 * 0.11);
      int var5 = var2 - var4 * 2;
      int var6 = var3 - (int)(var3 * 0.22);
      if (var5 > 0 && var6 > 0) {
         NativeImage var7 = new NativeImage(var1.getFormat(), var5, var6, false);

         for (int var8 = 0; var8 < var6; var8++) {
            for (int var9 = 0; var9 < var5; var9++) {
               var7.setColorArgb(var9, var8, var1.getColorArgb(var9 + var4, var8));
            }
         }

         var1.close();
         return var7;
      } else {
         return var1;
      }
   }

   private void I_method_67ab8991(NativeImage var1, ColorRGBA var2) {
      Identifier var3 = var1 == null ? null : RockstarClient.id("temp/artwork_" + I_field_bc9b37c0.incrementAndGet());
      I_field_3a9bda27.execute(() -> {
         Identifier var4 = this.I_field_6a3d6525;
         if (var1 != null) {
            I_field_3a9bda27.getTextureManager().registerTexture(var3, new NativeImageBackedTexture(var1));
         }

         this.I_field_6a3d6525 = var3;
         this.I_field_d0c8ec5 = var2;
         if (var4 != null) {
            I_field_3a9bda27.getTextureManager().destroyTexture(var4);
         }
      });
   }

   public ColorRGBA I_method_96793884(NativeImage var1, int var2) {
      int var3 = var1.getWidth();
      int var4 = var1.getHeight();
      long var5 = 0L;
      long var7 = 0L;
      long var9 = 0L;
      long var11 = 0L;
      int var13 = 0;
      int var14 = 0;

      while (var14 < var4) {
         for (int var15 = 0; var15 < var3; var15 += var2) {
            int var16 = var1.getColorArgb(var15, var14);
            int var17 = var16 >> 24 & 0xFF;
            if (var17 != 0) {
               var5 += var17;
               var7 += var16 >> 16 & 0xFF;
               var9 += var16 >> 8 & 0xFF;
               var11 += var16 & 0xFF;
               var13++;
            }
         }

         var14 += var2;
      }

      if (var13 == 0) {
         return ColorRGBA.WHITE;
      } else {
         float var18 = 50.0F;
         return new ColorRGBA((float)var7 / var13 + var18, (float)var9 / var13 + var18, (float)var11 / var13 + var18);
      }
   }

   public double I_method_f1206e6d() {
      if (this.iI_field_4a < 0L) {
         return 0.0;
      } else if (!this.i_field_5a) {
         return this.iI_field_4a;
      } else {
         long var1 = System.currentTimeMillis() - this.ii_field_4a;
         return this.iI_field_4a + Math.min(var1, 30000L) / 1000.0;
      }
   }

   public iiIiIIIiI_Class419.Nested1_a961800 I_method_7effc530() {
      IMediaSession var1 = this.I_field_c74d0693.get();
      if (var1 == null) {
         return null;
      } else {
         try {
            MediaInfo var2 = var1.getMedia();
            if (var2 == null) {
               return null;
            } else {
               String var3 = var2.getTitle() == null || var2.getTitle().isBlank() ? "Трек" : var2.getTitle();
               String var4 = var2.getArtist() == null || var2.getArtist().isBlank() ? "Аудио" : var2.getArtist();
               String var5 = var4 + " - " + var3;
               String var6 = Objects.requireNonNullElse(var1.getOwner(), "");
               long var7 = Math.max(0L, var2.getDuration());
               synchronized (this.I_field_5f790d9c) {
                  boolean var10 = var5.equals(this.i_field_523beb0a);
                  double var11 = var10 ? this.I_method_f1206e6d() : var2.getPosition();
                  var11 = Math.max(0.0, var7 > 0L ? Math.min(var11, (double)var7) : var11);
                  iiIiIIIii_Class420 retLyrics = this.I_field_990d92ac;
                  if ((retLyrics == null || retLyrics.I_method_27bb8263()) && this.I_field_a567c40b != null) {
                     retLyrics = this.I_field_a567c40b.get(var5);
                  }
                  if (retLyrics == null) {
                     retLyrics = iiIiIIIii_Class420.I_method_6b642b75();
                  }
                  if (retLyrics.I_method_27bb8263() && !this.I_field_5a && this.iI_field_49 < 3 && System.currentTimeMillis() >= this.Ii_field_4a) {
                     this.I_method_4312df47(var5, var4, var3, var7);
                  }
                  return new iiIiIIIiI_Class419.Nested1_a961800(
                     var3,
                     var4,
                     var6,
                     var2.isPlaying(),
                     var11,
                     var7,
                     var10 ? this.I_field_46 : 0.0F,
                     this.I_field_d0c8ec5,
                     this.I_field_6a3d6525,
                     retLyrics
                  );
               }
            }
         } catch (Exception var15) {
            return null;
         }
      }
   }

   public boolean I_method_f1206e83() {
      return this.I_field_c74d0693.get() != null;
   }

   public IMediaSession I_method_9b92c97b() {
      return this.I_field_c74d0693.get();
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 != null && this.getClass() == var1.getClass()) {
         iiIiIIIiI_Class419 var2 = (iiIiIIIiI_Class419)var1;
         return Objects.equals(this.I_field_72a5fc31, var2.I_field_72a5fc31)
            && Objects.equals(this.I_method_9b92c97b(), var2.I_method_9b92c97b())
            && Objects.equals(this.I_field_d0c8ec5, var2.I_field_d0c8ec5)
            && Objects.equals(this.I_field_990d92ac, var2.I_field_990d92ac)
            && Objects.equals(this.i_field_523beb0a, var2.i_field_523beb0a);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.I_field_72a5fc31, this.I_method_9b92c97b(), this.I_field_d0c8ec5, this.I_field_990d92ac, this.i_field_523beb0a);
   }

   @Generated
   public Thread I_method_100c8528() {
      return this.I_field_72a5fc31;
   }

   @Generated
   public ColorRGBA I_method_588218ee() {
      return this.I_field_d0c8ec5;
   }

   @Generated
   public Object I_method_fcdf9693() {
      return this.I_field_5f790d9c;
   }

   @Generated
   public iiIiIIIii_Class420 I_method_655c2f95() {
      return this.I_field_990d92ac;
   }

   @Generated
   public String I_method_efa27401() {
      return this.i_field_523beb0a;
   }

   @Generated
   public float I_method_f1206e6f() {
      return this.I_field_46;
   }

   public static final class Nested1_a961800 {
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;
      private final String II_field_523beb0a;
      private final boolean I_field_5a;
      private final double I_field_44;
      private final long I_field_4a;
      private final float I_field_46;
      private final ColorRGBA I_field_d0c8ec5;
      private final Identifier I_field_6a3d6525;
      private final iiIiIIIii_Class420 I_field_990d92ac;

      public Nested1_a961800(
         String var1, String var2, String var3, boolean var4, double var5, long var7, float var9, ColorRGBA var10, Identifier var11, iiIiIIIii_Class420 var12
      ) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
         this.II_field_523beb0a = var3;
         this.I_field_5a = var4;
         this.I_field_44 = var5;
         this.I_field_4a = var7;
         this.I_field_46 = var9;
         this.I_field_d0c8ec5 = var10;
         this.I_field_6a3d6525 = var11;
         this.I_field_990d92ac = var12;
      }

      @Override
      public final String toString() {
         return "Nested1_a961800[title=" + this.I_field_523beb0a + ", artist=" + this.i_field_523beb0a + ", owner=" + this.II_field_523beb0a + ", playing=" + this.I_field_5a + ", positionSeconds=" + this.I_field_44 + ", durationSeconds=" + this.I_field_4a + ", bpm=" + this.I_field_46 + ", color=" + this.I_field_d0c8ec5 + ", artwork=" + this.I_field_6a3d6525 + ", lyrics=" + this.I_field_990d92ac + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d0c8ec5);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_6a3d6525);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_990d92ac);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiIiIIIiI_Class419.Nested1_a961800 other = (iiIiIIIiI_Class419.Nested1_a961800) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.II_field_523beb0a, other.II_field_523beb0a)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.I_field_d0c8ec5, other.I_field_d0c8ec5)
            && java.util.Objects.equals(this.I_field_6a3d6525, other.I_field_6a3d6525)
            && java.util.Objects.equals(this.I_field_990d92ac, other.I_field_990d92ac);
      }

      public String I_method_33e8b426() {
         return this.I_field_523beb0a;
      }

      public String i_method_c7076446() {
         return this.i_field_523beb0a;
      }

      public String II_method_4e87bc99() {
         return this.II_field_523beb0a;
      }

      public boolean I_method_1a22ebbe() {
         return this.I_field_5a;
      }

      public double I_method_1a22eba8() {
         return this.I_field_44;
      }

      public long I_method_1a22ebae() {
         return this.I_field_4a;
      }

      public float I_method_1a22ebaa() {
         return this.I_field_46;
      }

      public ColorRGBA I_method_5108ea29() {
         return this.I_field_d0c8ec5;
      }

      public Identifier I_method_77a14989() {
         return this.I_field_6a3d6525;
      }

      public iiIiIIIii_Class420 I_method_3abb4910() {
         return this.I_field_990d92ac;
      }
   }
}
