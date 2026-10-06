package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class iiIiIIIIi_Class418 {
   private static final Logger I_field_ab0f6068 = LoggerFactory.getLogger("rockstar-lyrics");
   private static final String I_field_523beb0a = "https://genius.com/api/search/song?per_page=10&q=";
   private static final String i_field_523beb0a = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36";

   public static String I_method_9799592d(String var0, String var1) {
      if (var0 != null && var1 != null && !var0.isBlank() && !var1.isBlank()) {
         try {
            iiIiIIIIi_Class418.Nested1_a880440 var2 = I_method_9b0bc844(var0, var1);
            if (var2 == null) {
               I_field_ab0f6068.info("[lyrics] genius: {} - {} \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d", var0, var1);
               return null;
            }

            return iI_method_886c9fb4(var2.I_field_523beb0a);
         } catch (IOException var3) {
            I_field_ab0f6068.warn("[lyrics] genius \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d: {}", var3.toString());
         } catch (Exception var4) {
            I_field_ab0f6068.warn("[lyrics] genius: {}", var4.toString());
         }

         return null;
      } else {
         return null;
      }
   }

   private static iiIiIIIIi_Class418.Nested1_a880440 I_method_9b0bc844(String var0, String var1) throws IOException {
      LinkedHashSet var2 = new LinkedHashSet();
      var2.add(var0 + " " + var1);
      String var3 = II_method_a4ae83d4(var1);
      if (!var3.equals(var1)) {
         var2.add(var0 + " " + var3);
      }

      iiIiIIIIi_Class418.Nested1_a880440 var4 = null;
      int var5 = -1;

      for (String var7 : (Iterable<String>)(Iterable<?>)var2) {
         JsonObject var8 = I_method_9eff9b59("https://genius.com/api/search/song?per_page=10&q=" + Ii_method_c4cd6bf4(var7));

         for (JsonObject var10 : I_method_c187617c(var8)) {
            int var11 = I_method_b6f0a8f2(var10, var0, var1);
            String var12 = I_method_84b73acb(var10, "url");
            if (!var12.isBlank() && var11 > var5) {
               var5 = var11;
               var4 = new iiIiIIIIi_Class418.Nested1_a880440(var12);
            }
         }

         if (var5 >= 250) {
            break;
         }
      }

      return var5 >= 100 ? var4 : null;
   }

   private static JsonObject I_method_9eff9b59(String var0) throws IOException {
      iIiIiiiiI_Class351.Nested1_e2f5a480 var1 = iIiIiiiiI_Class351.I_method_59510627(
         var0,
         "User-Agent",
         "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36",
         "Accept-Language",
         "ru,en-US;q=0.9,en;q=0.8",
         "Accept",
         "application/json, text/plain, */*",
         "Referer",
         "https://genius.com/"
      );
      if (!var1.I_method_66072f3e()) {
         return null;
      } else {
         try {
            return JsonParser.parseString(var1.I_method_23a3e0a6()).getAsJsonObject();
         } catch (Exception var3) {
            return null;
         }
      }
   }

   private static List<JsonObject> I_method_c187617c(JsonObject var0) {
      ArrayList var1 = new ArrayList();
      if (var0 == null) {
         return var1;
      } else {
         JsonObject var2 = var0.getAsJsonObject("response");
         if (var2 == null) {
            return var1;
         } else {
            I_method_ba501e3e(var2.getAsJsonArray("hits"), var1);
            JsonArray var3 = var2.getAsJsonArray("sections");
            if (var3 != null) {
               for (JsonElement var5 : var3) {
                  if (var5.isJsonObject()) {
                     I_method_ba501e3e(var5.getAsJsonObject().getAsJsonArray("hits"), var1);
                  }
               }
            }

            return var1;
         }
      }
   }

   private static void I_method_ba501e3e(JsonArray var0, List<JsonObject> var1) {
      if (var0 != null) {
         for (JsonElement var3 : var0) {
            if (var3.isJsonObject()) {
               JsonObject var4 = var3.getAsJsonObject().getAsJsonObject("result");
               if (var4 != null) {
                  var1.add(var4);
               }
            }
         }
      }
   }

   private static int I_method_b6f0a8f2(JsonObject var0, String var1, String var2) {
      String var3 = i_method_995bc597(var2);
      String var4 = i_method_995bc597(I_method_84b73acb(var0, "title"));
      if (!var3.isEmpty() && !var4.isEmpty()) {
         short var5;
         if (var4.equals(var3)) {
            var5 = 160;
         } else if (!var4.startsWith(var3) && !var4.contains(var3)) {
            if (!var3.contains(var4)) {
               return -1;
            }

            var5 = 90;
         } else {
            var5 = 125;
         }

         String var6 = I_method_84b73acb(var0, "artist_names");
         if (var6.isBlank()) {
            JsonObject var7 = var0.getAsJsonObject("primary_artist");
            var6 = I_method_84b73acb(var7, "name");
         }

         String var10 = i_method_995bc597(var1);
         String var8 = i_method_995bc597(var6);
         short var9 = 0;
         if (!var10.isEmpty() && var8.equals(var10)) {
            var9 = 140;
         } else if (!var10.isEmpty() && (var8.contains(var10) || var10.contains(var8))) {
            var9 = 100;
         }

         if (var8.startsWith("genius ") && var9 == 0) {
            var9 -= 100;
         }

         return var5 + var9;
      } else {
         return -1;
      }
   }

   private static String I_method_84b73acb(JsonObject var0, String var1) {
      if (var0 != null && var0.has(var1) && !var0.get(var1).isJsonNull()) {
         try {
            return var0.get(var1).getAsString();
         } catch (Exception var3) {
            return "";
         }
      } else {
         return "";
      }
   }

   private static String i_method_995bc597(String var0) {
      if (var0 == null) {
         return "";
      } else {
         String var1 = Normalizer.normalize(var0, Form.NFKD)
            .replaceAll("\\p{M}+", "")
            .toLowerCase(Locale.ROOT)
            .replace('\u0451', '\u0435')
            .replaceAll("[^\\p{L}\\p{N}]+", " ")
            .trim();
         return var1.replaceAll("\\s+", " ");
      }
   }

   private static String II_method_a4ae83d4(String var0) {
      return var0 == null
         ? ""
         : var0.replaceAll("(?i)\\s*[\\[(](feat\\.?|ft\\.?|featuring|prod\\.?|with)\\b.*?[\\])]", "")
            .replaceAll("(?i)\\s*[-\u2013\u2014]\\s*(remaster(?:ed)?|live|radio edit|single version|official audio).*$", "")
            .trim();
   }

   private static String Ii_method_c4cd6bf4(String var0) {
      return URLEncoder.encode(var0, StandardCharsets.UTF_8);
   }

   private static String iI_method_886c9fb4(String var0) throws IOException {
      iIiIiiiiI_Class351.Nested1_e2f5a480 var1 = iIiIiiiiI_Class351.I_method_59510627(
         var0,
         "User-Agent",
         "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36",
         "Accept-Language",
         "ru,en-US;q=0.9,en;q=0.8",
         "Accept",
         "text/html,application/xhtml+xml"
      );
      return var1.I_method_66072f3e() ? I_method_793cdd77(var1.I_method_23a3e0a6()) : null;
   }

   static String I_method_793cdd77(String var0) {
      if (var0 != null && !var0.isBlank()) {
         Document var1 = Jsoup.parse(var0);
         Elements var2 = var1.select("[data-lyrics-container=true]");
         if (var2.isEmpty()) {
            var2 = var1.select("div[class*=Lyrics__Container]");
         }

         StringBuilder var3 = new StringBuilder();

         for (Element var5 : var2) {
            Element var6 = var5.clone();
            var6.select("[data-exclude-from-selection], button, script, style, svg").remove();

            for (Element var8 : var6.select("br")) {
               var8.after(new TextNode("\n"));
               var8.remove();
            }

            String var9 = ii_method_a88b87d4(var6.wholeText());
            if (!var9.isBlank()) {
               if (!var3.isEmpty()) {
                  var3.append("\n\n");
               }

               var3.append(var9);
            }
         }

         return var3.isEmpty() ? null : var3.toString();
      } else {
         return null;
      }
   }

   private static String ii_method_a88b87d4(String var0) {
      String[] var1 = var0.replace('\u00a0', ' ').replace("\r", "").split("\n", -1);
      StringBuilder var2 = new StringBuilder();
      boolean var3 = true;

      for (String var7 : var1) {
         String var8 = var7.strip().replaceAll("[ \\t]+", " ");
         if (var8.isEmpty()) {
            if (!var3 && !var2.isEmpty()) {
               var2.append('\n');
               var3 = true;
            }
         } else {
            if (!var2.isEmpty() && !var3) {
               var2.append('\n');
            }

            var2.append(var8);
            var3 = false;
         }
      }

      return var2.toString().strip();
   }

   static final class Nested1_a880440 {
      final String I_field_523beb0a;

      Nested1_a880440(String var1) {
         this.I_field_523beb0a = var1;
      }

      @Override
      public final String toString() {
         return "Nested1_a880440[url=" + this.I_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiIiIIIIi_Class418.Nested1_a880440 other = (iiIiIIIIi_Class418.Nested1_a880440) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a);
      }

      public String I_method_7ec7f066() {
         return this.I_field_523beb0a;
      }
   }
}
