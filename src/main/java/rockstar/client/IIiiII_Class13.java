package rockstar.client;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public final class IIiiII_Class13 {
   private static final int I_field_49 = 57344;
   private static final String I_field_523beb0a = "icons/font";
   private static final IIiiii_Class16 I_field_857c0621 = IIiiii_Class16.I_method_c0662d41("icons");
   private static Map<String, Integer> I_field_a567c40b = Collections.emptyMap();

   private IIiiII_Class13() {
   }

   public static IIiiii_Class16 I_method_a9f1134b() {
      return I_field_857c0621;
   }

   public static boolean I_method_6bd3fa70() {
      return !I_field_a567c40b.isEmpty();
   }

   public static Integer I_method_d04bdedd(String var0) {
      return I_field_a567c40b.get(var0);
   }

   public static boolean I_method_e72fe13a(String var0) {
      return I_field_a567c40b.containsKey(var0);
   }

   public static Set<String> I_method_629c295b() {
      return I_field_a567c40b.keySet();
   }

   public static synchronized void I_method_6bd3fa6c() {
      try {
         Map var0 = MinecraftClient.getInstance().getResourceManager().findResources("icons/font", var0x -> var0x.getPath().endsWith(".svg"));
         TreeMap var1 = new TreeMap();
         var0.forEach((var1x, var2x) -> {
            if (((net.minecraft.util.Identifier)var1x).getNamespace().equals(RockstarClient.II_field_523beb0a)) {
               String var3x = ((net.minecraft.util.Identifier)var1x).getPath();
               var1.put(var3x.substring("icons/font".length() + 1, var3x.length() - 4), var1x);
            }
         });
         HashMap var2 = new HashMap();
         int var3 = 57344;

         for (Entry var5 : (Iterable<Entry>)(Iterable<?>)var1.entrySet()) {
            try (InputStream var6 = MinecraftClient.getInstance().getResourceManager().open((Identifier)var5.getValue())) {
               String var7 = new String(var6.readAllBytes(), StandardCharsets.UTF_8);
               I_field_857c0621.I_method_49bd623f(var3, IiIiiI_Class23.I_method_8219f141(var7));
               var2.put((String)var5.getKey(), var3++);
            } catch (Exception var11) {
               RockstarClient.I_field_ab0f6068
                  .warn("[icons] \u043d\u0435 \u0440\u0430\u0437\u0431\u0438\u0440\u0430\u0435\u0442\u0441\u044f {}: {}", var5.getValue(), var11.toString());
            }
         }

         I_field_a567c40b = var2;
         RockstarClient.I_field_ab0f6068
            .info("[icons] \u0440\u0430\u0437\u043e\u0431\u0440\u0430\u043d\u043e \u0437\u043d\u0430\u0447\u043a\u043e\u0432: {}", var2.size());
      } catch (Throwable var12) {
         RockstarClient.I_field_ab0f6068
            .error(
               "[icons] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u0437\u043d\u0430\u0447\u043a\u0438: {}",
               var12.toString()
            );
      }
   }
}
