package rockstar.client;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.MinecraftClient;

public final class IiIiIiiI_Class87 {
   private static final String I_field_523beb0a = "assets/rockstar/mcp/scripting/";
   private static final Map<String, String> I_field_a567c40b = new LinkedHashMap<>();
   private static final Map<String, String> i_field_a567c40b = new ConcurrentHashMap<>();

   private IiIiIiiI_Class87() {
   }

   public static String I_method_d6803100(String var0, String var1) {
      String var2 = I_method_872f140a(var0);
      if (!I_field_a567c40b.containsKey(var2)) {
         throw new IiIiiIII_Class89.Nested1_426908f3(
            "\u043d\u0435\u0442 \u0440\u0430\u0437\u0434\u0435\u043b\u0430 \""
               + var0
               + "\"; \u0435\u0441\u0442\u044c: "
               + String.join(", ", I_field_a567c40b.keySet())
         );
      } else {
         Object var3 = i_field_a567c40b.computeIfAbsent(var2, IiIiIiiI_Class87::i_method_a74dfc2a);
         String var4 = "";
         if (var1 != null && !var1.isBlank()) {
            IiIiIiiI_Class87.Nested1_d9f7113 var5 = I_method_db92ac32((String)var3, var1.trim());
            var3 = var5.I_method_1a27acf9();
            var4 = var5.i_method_ad465d19();
         }

         StringBuilder var6 = new StringBuilder();
         var6.append(
               "# \u0421\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a \u043f\u043e \u0441\u043a\u0440\u0438\u043f\u0442\u0430\u043c Rockstar \u2014 \u0440\u0430\u0437\u0434\u0435\u043b \u00ab"
            )
            .append(var2)
            .append("\u00bb\n\n");
         var6.append(
            "\u0420\u0430\u0437\u0434\u0435\u043b\u044b \u044d\u0442\u043e\u0433\u043e \u0438\u043d\u0441\u0442\u0440\u0443\u043c\u0435\u043d\u0442\u0430 (\u0437\u0430\u043f\u0440\u0430\u0448\u0438\u0432\u0430\u0439 \u043d\u0443\u0436\u043d\u044b\u0439 \u0442\u0435\u043c \u0436\u0435 script_api):\n"
         );
         I_field_a567c40b.forEach((var1x, var2x) -> var6.append("- `").append(var1x).append("` \u2014 ").append(var2x).append('\n'));
         var6.append(
            "\n\u0412\u0441\u0451, \u0447\u0435\u0433\u043e \u0432 \u0441\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a\u0435 \u043d\u0435\u0442, \u0432 \u043a\u043b\u0438\u0435\u043d\u0442\u0435 \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442: \u043c\u0435\u0442\u043e\u0434\u044b \u0438 \u0441\u043e\u0431\u044b\u0442\u0438\u044f \u043d\u0435 \u0432\u044b\u0434\u0443\u043c\u044b\u0432\u0430\u0439, \u0430 \u0441\u0432\u0435\u0440\u044f\u0439 \u0441 \u043d\u0443\u0436\u043d\u044b\u043c \u0440\u0430\u0437\u0434\u0435\u043b\u043e\u043c.\n"
         );
         if (!var4.isEmpty()) {
            var6.append(var4).append('\n');
         }

         var6.append("\n---\n\n");
           return var6.toString() + var3;
      }
   }

   private static String I_method_872f140a(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.trim().toLowerCase(Locale.ROOT).replace('\\', '/');
         int var2 = var1.lastIndexOf(47);
         if (var2 >= 0) {
            var1 = var1.substring(var2 + 1);
         }

         return var1.endsWith(".md") ? var1.substring(0, var1.length() - 3) : var1;
      } else {
         return "basics";
      }
   }

   private static boolean I_method_8fd1b75a(String var0) {
      String var1 = var0.replace("#", "").trim();
      return var1.isEmpty() || !Character.isDigit(var1.charAt(0));
   }

   private static IiIiIiiI_Class87.Nested1_d9f7113 I_method_db92ac32(String var0, String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);
      String[] var3 = var0.split("(?m)^(?=## )");
      if (var3.length < 2) {
         return new IiIiIiiI_Class87.Nested1_d9f7113(var0, "");
      } else {
         StringBuilder var4 = new StringBuilder(var3[0]);
         ArrayList var5 = new ArrayList();
         int var6 = 0;

         for (int var7 = 1; var7 < var3.length; var7++) {
            String var8 = var3[var7];
            String var9 = var8.substring(0, var8.indexOf(10) < 0 ? var8.length() : var8.indexOf(10)).trim();
            var5.add(var9);
            if (var8.toLowerCase(Locale.ROOT).contains(var2)) {
               var4.append(var8);
               var6++;
            } else if (I_method_8fd1b75a(var9)) {
               var4.append(var8);
            }
         }

         return var6 == 0
            ? new IiIiIiiI_Class87.Nested1_d9f7113(
               "\u041f\u043e \u0437\u0430\u043f\u0440\u043e\u0441\u0443 \u00ab"
                  + var1
                  + "\u00bb \u0432 \u044d\u0442\u043e\u043c \u0440\u0430\u0437\u0434\u0435\u043b\u0435 \u043d\u0438\u0447\u0435\u0433\u043e \u043d\u0435\u0442. \u0415\u0433\u043e \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u044b:\n\n- "
                  + String.join("\n- ", var5)
                  + "\n\n\u0417\u0430\u043f\u0440\u043e\u0441\u0438 \u0440\u0430\u0437\u0434\u0435\u043b \u0431\u0435\u0437 query \u0438\u043b\u0438 \u043f\u043e\u0438\u0449\u0438 \u0432 \u0434\u0440\u0443\u0433\u043e\u043c.",
               ""
            )
            : new IiIiIiiI_Class87.Nested1_d9f7113(
               var4.toString(),
               "\n\u041f\u043e\u043a\u0430\u0437\u0430\u043d\u044b \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u044b \u0441\u043e \u0441\u043b\u043e\u0432\u043e\u043c \u00ab"
                  + var1
                  + "\u00bb ("
                  + var6
                  + " \u0438\u0437 "
                  + (var3.length - 1)
                  + "). \u0411\u0435\u0437 query \u043f\u0440\u0438\u0434\u0451\u0442 \u0440\u0430\u0437\u0434\u0435\u043b \u0446\u0435\u043b\u0438\u043a\u043e\u043c."
            );
      }
   }

   private static String i_method_a74dfc2a(String var0) {
      try {
         Path var1 = MinecraftClient.getInstance()
            .runDirectory
            .toPath()
            .resolve("../src/main/resources/assets/rockstar/mcp/scripting/" + var0 + ".md")
            .normalize();
         if (Files.isRegularFile(var1)) {
            return Files.readString(var1, StandardCharsets.UTF_8);
         }
      } catch (Exception var5) {
         RockstarClient.I_field_ab0f6068
            .warn(
               "[MCP] \u0441\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a \u0438\u0437 \u0440\u0435\u043f\u043e\u0437\u0438\u0442\u043e\u0440\u0438\u044f \u043d\u0435 \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u043d: {}",
               var5.getMessage()
            );
      }

      try {
         String var2;
         try (InputStream var8 = IiIiIiiI_Class87.class.getClassLoader().getResourceAsStream("assets/rockstar/mcp/scripting/" + var0 + ".md")) {
            if (var8 == null) {
               throw new IllegalStateException("\u0432 jar \u043d\u0435\u0442 " + var0 + ".md");
            }

            var2 = new String(var8.readAllBytes(), StandardCharsets.UTF_8);
         }

         return var2;
      } catch (Exception var7) {
         throw new IiIiiIII_Class89.Nested1_426908f3(
            "\u0441\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a \u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f: " + var7.getMessage()
         );
      }
   }

   static {
      I_field_a567c40b.put(
         "basics",
         "\u0441 \u0447\u0435\u0433\u043e \u043d\u0430\u0447\u0438\u043d\u0430\u0442\u044c: \u0443\u0441\u0442\u0440\u043e\u0439\u0441\u0442\u0432\u043e \u0441\u043a\u0440\u0438\u043f\u0442\u0430, \u0441\u043a\u0435\u043b\u0435\u0442, \u043d\u0435\u0439\u043c\u0441\u043f\u0435\u0439\u0441, \u0433\u043b\u0430\u0432\u043d\u044b\u0435 \u0433\u0440\u0430\u0431\u043b\u0438, \u0447\u0435\u043a-\u043b\u0438\u0441\u0442"
      );
      I_field_a567c40b.put(
         "api",
         "\u043f\u043e\u043b\u043d\u044b\u0439 \u0441\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a: \u043c\u043e\u0434\u0443\u043b\u0438, \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438, \u043c\u0438\u0440 \u0438 \u0438\u0433\u0440\u043e\u043a, Newton, \u043a\u043e\u043c\u0430\u043d\u0434\u044b, Aura, \u0440\u0438\u0441\u043e\u0432\u0430\u043d\u0438\u0435"
      );
      I_field_a567c40b.put(
         "events",
         "\u0432\u0441\u0435 \u0441\u043e\u0431\u044b\u0442\u0438\u044f: \u043e\u0442\u043c\u0435\u043d\u044f\u0435\u043c\u043e\u0441\u0442\u044c, \u043f\u043e\u043b\u044f \u043e\u0431\u044a\u0435\u043a\u0442\u0430, \u043f\u0440\u0438\u043c\u0435\u0440 \u043f\u043e\u0434\u043f\u0438\u0441\u043a\u0438"
      );
      I_field_a567c40b.put(
         "ui",
         "HUD, Dynamic Island, \u044d\u043a\u0440\u0430\u043d\u044b, ui-\u0431\u0438\u043b\u0434\u0435\u0440, 2D-\u0440\u0438\u0441\u043e\u0432\u0430\u043d\u0438\u0435"
      );
      I_field_a567c40b.put(
         "recipes",
         "\u0433\u043e\u0442\u043e\u0432\u044b\u0435 \u0441\u043a\u0440\u0438\u043f\u0442\u044b \u0446\u0435\u043b\u0438\u043a\u043e\u043c: HUD, ESP, \u043c\u0435\u043d\u044e, \u0444\u043e\u043d\u043e\u0432\u044b\u0439 \u043f\u043e\u0442\u043e\u043a, storage, \u0441\u0432\u043e\u044f \u0440\u043e\u0442\u0430\u0446\u0438\u044f"
      );
   }

   static final class Nested1_d9f7113 {
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;

      Nested1_d9f7113(String var1, String var2) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_d9f7113[text=" + this.I_field_523beb0a + ", note=" + this.i_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiIiiI_Class87.Nested1_d9f7113 other = (IiIiIiiI_Class87.Nested1_d9f7113) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a);
      }

      public String I_method_1a27acf9() {
         return this.I_field_523beb0a;
      }

      public String i_method_ad465d19() {
         return this.i_field_523beb0a;
      }
   }
}
