package rockstar.client;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.zip.GZIPInputStream;
import lombok.SneakyThrows;
import java.util.zip.InflaterInputStream;
import javax.annotation.Nullable;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

public class iIIIiI_Class35 extends Iiiiii_Class32<iIIIiI_Class35> {
   private static final Map<String, iIIIiI_Class35.Nested1_af74ff13> I_field_a567c40b = new HashMap<>();
   private final URL I_field_6e7dda7f;
   private final int I_field_49;
   private final iIiIII_Class41 I_field_22346661;

   @Nullable
   private static iIIIiI_Class35.Nested1_af74ff13 I_method_5a72fcbf(String... var0) {
      for (String var4 : var0) {
         try {
            Class var5 = Class.forName(var4).asSubclass(InputStream.class);
            Constructor var6 = var5.getDeclaredConstructor(InputStream.class);
            return var2 -> {
               try {
                  return (InputStream)var6.newInstance(var2);
               } catch (Throwable var4x) {
                  throw new IOException("Failed to create decoder input stream of type " + var4, var4x);
               }
            };
         } catch (Throwable var7) {
         }
      }

      return null;
   }

   public iIIIiI_Class35(URL var1, int var2, byte[] var3, Map<String, List<String>> var4) {
      super(var4);
      this.I_field_6e7dda7f = var1;
      this.I_field_49 = var2;
      this.I_field_22346661 = new iIiIIi_Class42(
         this.I_method_a5598def("Content-Type").map(iiiIII_Class57::I_method_e6646141).orElse(iIIIii_Class36.iI_field_58cf7a41), var3
      );
   }

   public iIIIiI_Class35(URL var1, int var2, InputStream var3, Map<String, List<String>> var4) {
      super(var4);
      this.I_field_6e7dda7f = var1;
      this.I_field_49 = var2;
      this.I_field_22346661 = new iIiIii_Class44(
         this.I_method_a5598def("Content-Type").map(iiiIII_Class57::I_method_e6646141).orElse(iIIIii_Class36.iI_field_58cf7a41),
         var3,
         this.I_method_a5598def("Content-Length").map(var0 -> {
            try {
               return Integer.valueOf(var0);
            } catch (NumberFormatException var2x) {
               return -1;
            }
         }).orElse(-1)
      );
   }

   public iIIIiI_Class35(URL var1, int var2, iIiIII_Class41 var3, Map<String, List<String>> var4) {
      super(var4);
      this.I_field_6e7dda7f = var1;
      this.I_field_49 = var2;
      this.I_field_22346661 = var3;
   }

   public URL I_method_221617e9() {
      return this.I_field_6e7dda7f;
   }

   public int I_method_207e3e9f() {
      return this.I_field_49;
   }

   public String I_method_db436374() {
      return iIIiiI_Class39.I_field_a567c40b.getOrDefault(this.I_field_49, "Unknown");
   }

   public iIiIII_Class41 I_method_5d16674b() {
      return this.I_field_22346661;
   }

   public iIiIII_Class41 i_method_87387f6b() {
      return this.I_method_3c8daaaf(var0 -> I_field_a567c40b.get(var0.toLowerCase(Locale.ROOT)));
   }

   public iIiIII_Class41 I_method_3c8daaaf(iIIIiI_Class35.Nested1_af74fef3 var1) {
      String var2 = this.I_method_a5598def("Content-Encoding").orElse(null);
      if (var2 == null) {
         return this.I_field_22346661;
      } else {
         String[] var3 = var2.split(",\\s*");
         final ArrayList var4 = new ArrayList(var3.length);

         for (String var8 : var3) {
            iIIIiI_Class35.Nested1_af74ff13 var9 = var1.get(var8);
            if (var9 == null) {
               return this.I_field_22346661;
            }

            var4.add(var9);
         }

         this.I_method_6864f941("Content-Encoding");
         this.i_method_33057dd7("Original-Content-Encoding", var2);
         return new iIIiii_Class40(this.I_field_22346661) {
            @Override
            protected InputStream I_method_97542b37(InputStream var1) throws IOException {
               var1 = super.I_method_97542b37(var1);

               for (int var2x = var4.size() - 1; var2x >= 0; var2x--) {
                  var1 = ((iIIIiI_Class35.Nested1_af74ff13)var4.get(var2x)).map(var1);
               }

               return var1;
            }
         };
      }
   }

   @Deprecated
   @ScheduledForRemoval
   @SneakyThrows(IOException.class)
   public InputStream I_method_ce556baf() {
      return this.I_field_22346661.i_method_4e61bf8f();
   }

   @Deprecated
   @ScheduledForRemoval
   @SneakyThrows(IOException.class)
   public String i_method_6e621394() {
      return this.I_field_22346661.I_method_963beb74();
   }

   @Deprecated
   @ScheduledForRemoval
   @SneakyThrows(IOException.class)
   public String I_method_5ec3d9e6(Charset var1) {
      return this.I_field_22346661.I_method_e4a261e6(var1);
   }

   @Deprecated
   @ScheduledForRemoval
   public Optional<iiiIII_Class57> I_method_f7c51499() {
      return this.I_method_a5598def("Content-Type").map(iiiIII_Class57::I_method_e6646141);
   }

   static {
      I_field_a567c40b.put("identity", var0 -> var0);
      I_field_a567c40b.put("gzip", GZIPInputStream::new);
      I_field_a567c40b.put("x-gzip", GZIPInputStream::new);
      I_field_a567c40b.put("deflate", InflaterInputStream::new);
      I_field_a567c40b.put("br", I_method_5a72fcbf("com.aayushatharva.brotli4j.decoder.BrotliInputStream", "org.brotli.dec.BrotliInputStream"));
      I_field_a567c40b.put(
         "zstd",
         I_method_5a72fcbf("io.airlift.compress.zstd.ZstdInputStream", "io.airlift.compress.v3.zstd.ZstdInputStream", "com.github.luben.zstd.ZstdInputStream")
      );
   }

   @FunctionalInterface
   public interface Nested1_af74fef3 {
      @Nullable
      iIIIiI_Class35.Nested1_af74ff13 get(String var1);
   }

   @FunctionalInterface
   public interface Nested1_af74ff13 {
      InputStream map(InputStream var1) throws IOException;
   }
}
