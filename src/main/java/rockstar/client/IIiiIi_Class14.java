package rockstar.client;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.text.Style;
import pyrock.utility.render.ColorRGBA;

public class IIiiIi_Class14 {
   private static final Map<Integer, String> I_field_a567c40b = new HashMap<>();
   private static final Map<Integer, Integer> i_field_a567c40b = new HashMap<>();
   private static final Map<String, String> II_field_a567c40b = new HashMap<>();
   private static final Map<String, Integer> Ii_field_a567c40b = new HashMap<>();
   private static final int[] I_field_b4e = new int[]{
      42240,
      42244,
      42248,
      42258,
      42262,
      42272,
      42276,
      42280,
      42336,
      42290,
      42294,
      42308,
      42326,
      42312,
      42304,
      42322,
      42249,
      42259,
      42263,
      42273,
      42277,
      42281,
      42291,
      42295,
      42241,
      42245
   };

   public static String I_method_4201b49(int var0) {
      return I_field_a567c40b.get(var0);
   }

   public static boolean I_method_ab732e3b(int var0) {
      for (int var4 : I_field_b4e) {
         if (var4 == var0) {
            return true;
         }
      }

      return false;
   }

   public static String I_method_873464a(String var0) {
      return II_field_a567c40b.getOrDefault(var0, var0);
   }

   public static void I_method_aab60d60(String var0, String var1) {
      II_field_a567c40b.put(var0, var1);
   }

   public static boolean I_method_12acef87(int var0, Style var1) {
      if (var0 == 97 && var1 != null && var1.getFont() != null) {
         String var2 = var1.getFont().toString();
         return II_field_a567c40b.containsKey(var2);
      } else {
         return false;
      }
   }

   public static String I_method_a08c6048(Style var0) {
      if (var0 != null && var0.getFont() != null) {
         String var1 = var0.getFont().toString();
         return II_field_a567c40b.get(var1);
      } else {
         return null;
      }
   }

   public static int I_method_6761bd09(String var0) {
      return Ii_field_a567c40b.getOrDefault(var0, -1);
   }

   public static int I_method_84d64d5d(String var0, float var1) {
      int var2 = I_method_6761bd09(var0);
      return var2 == -1 ? -1 : ColorRGBA.applyOpacity(var2, var1).getRGB();
   }

   public static int I_method_7b38064d(int var0, int var1, int var2, float var3, int var4) {
      boolean var5 = false;

      for (int var9 : I_field_b4e) {
         if (var9 == var0) {
            var5 = true;
            break;
         }
      }

      Integer var10 = var5 ? i_field_a567c40b.get(var0) : null;
      if (var10 == null) {
         return ColorRGBA.applyOpacity(var4, var3).getRGB();
      } else {
         float var11 = var2 > 1 ? (float)var1 / (var2 - 1) : 0.0F;
         ColorRGBA var12 = ColorRGBA.fromInt(var10).mix(ColorRGBA.darken(var10, 0.8F), var11);
         return ColorRGBA.applyOpacity(var12.getRGB(), var3).getRGB();
      }
   }

   static {
      I_field_a567c40b.put(9889, "");
      I_field_a567c40b.put(9733, "");
      I_field_a567c40b.put(42240, "PLAYER");
      I_field_a567c40b.put(42244, "HERO");
      I_field_a567c40b.put(42248, "TITAN");
      I_field_a567c40b.put(42258, "AVENGER");
      I_field_a567c40b.put(42262, "OVERLORD");
      I_field_a567c40b.put(42272, "MAGISTER");
      I_field_a567c40b.put(42276, "IMPERATOR");
      I_field_a567c40b.put(42280, "DRAGON");
      I_field_a567c40b.put(42336, "D.HELPER");
      I_field_a567c40b.put(42290, "BULL");
      I_field_a567c40b.put(42294, "TIGER");
      I_field_a567c40b.put(42308, "DRACULA");
      I_field_a567c40b.put(42326, "BUNNY");
      I_field_a567c40b.put(42312, "COBRA");
      I_field_a567c40b.put(42304, "HYDRA");
      I_field_a567c40b.put(42322, "RABBIT");
      I_field_a567c40b.put(42249, "HELPER");
      I_field_a567c40b.put(42259, "ML.MODER");
      I_field_a567c40b.put(42263, "MODER");
      I_field_a567c40b.put(42273, "MODER+");
      I_field_a567c40b.put(42277, "ST.MODER");
      I_field_a567c40b.put(42281, "GL.MODER");
      I_field_a567c40b.put(42291, "ML.ADMIN");
      I_field_a567c40b.put(42295, "ADMIN");
      I_field_a567c40b.put(42241, "MEDIA");
      I_field_a567c40b.put(42245, "YT");
      I_field_a567c40b.put(1171, "F");
      I_field_a567c40b.put(1109, "S");
      I_field_a567c40b.put(42927, "Q");
      I_field_a567c40b.put(7424, "A");
      I_field_a567c40b.put(665, "B");
      I_field_a567c40b.put(7428, "C");
      I_field_a567c40b.put(7429, "D");
      I_field_a567c40b.put(7431, "E");
      I_field_a567c40b.put(42800, "F");
      I_field_a567c40b.put(610, "G");
      I_field_a567c40b.put(668, "H");
      I_field_a567c40b.put(618, "I");
      I_field_a567c40b.put(7434, "J");
      I_field_a567c40b.put(7435, "K");
      I_field_a567c40b.put(671, "L");
      I_field_a567c40b.put(7437, "M");
      I_field_a567c40b.put(628, "N");
      I_field_a567c40b.put(7439, "O");
      I_field_a567c40b.put(7448, "P");
      I_field_a567c40b.put(491, "Q");
      I_field_a567c40b.put(640, "R");
      I_field_a567c40b.put(7451, "T");
      I_field_a567c40b.put(7452, "U");
      I_field_a567c40b.put(42801, "S");
      I_field_a567c40b.put(7456, "V");
      I_field_a567c40b.put(7457, "W");
      I_field_a567c40b.put(7521, "X");
      I_field_a567c40b.put(655, "Y");
      I_field_a567c40b.put(7458, "Z");
      II_field_a567c40b.put("custom:groups/hydra", "\u0413\u0438\u0434\u0440\u0430");
      II_field_a567c40b.put("custom:groups/cerberus", "\u0426\u0435\u0440\u0431\u0435\u0440");
      II_field_a567c40b.put("custom:groups/triton", "\u0422\u0440\u0438\u0442\u043e\u043d");
      II_field_a567c40b.put("custom:groups/phoenix", "\u0424\u0435\u043d\u0438\u043a\u0441");
      II_field_a567c40b.put("custom:groups/pandar", "\u041f\u0430\u043d\u0434\u0430\u0440");
      II_field_a567c40b.put("custom:groups/heat", "\u0416\u0430\u0440\u0430");
      II_field_a567c40b.put("custom:groups/cold", "\u0425\u043e\u043b\u043e\u0434");
      II_field_a567c40b.put("custom:groups/kronos", "\u041a\u0440\u043e\u043d\u043e\u0441");
      II_field_a567c40b.put("custom:groups/summer", "\u041b\u0435\u0442\u043e");
      II_field_a567c40b.put("custom:groups/winter", "\u0417\u0438\u043c\u0430");
      II_field_a567c40b.put("custom:groups/phobos", "\u0424\u043e\u0431\u043e\u0441");
      II_field_a567c40b.put("custom:groups/ares", "\u0410\u0440\u0435\u0441");
      II_field_a567c40b.put("custom:groups/aristocrat", "\u0410\u0440\u0438\u0441\u0442\u043e\u043a\u0440\u0430\u0442");
      II_field_a567c40b.put("custom:groups/youtuber", "\u042e\u0442\u0443\u0431\u0435\u0440");
      II_field_a567c40b.put("custom:groups/helper", "\u0425\u0435\u043b\u043f\u0435\u0440");
      II_field_a567c40b.put("custom:groups/shelper", "\u0421\u0442 \u0425\u0435\u043b\u043f\u0435\u0440");
      II_field_a567c40b.put("custom:groups/moder", "\u041c\u043e\u0434\u0435\u0440");
      II_field_a567c40b.put("custom:groups/smoder", "\u0421\u0442 \u041c\u043e\u0434\u0435\u0440");
      II_field_a567c40b.put("custom:groups/admin", "\u0410\u0434\u043c\u0438\u043d");
      II_field_a567c40b.put("custom:groups/default", "\u0418\u0433\u0440\u043e\u043a");
      Ii_field_a567c40b.put("custom:groups/aristocrat", new ColorRGBA(100.0F, 149.0F, 237.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/ares", new ColorRGBA(255.0F, 215.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/phobos", new ColorRGBA(255.0F, 165.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/kronos", new ColorRGBA(139.0F, 0.0F, 139.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/pandar", new ColorRGBA(255.0F, 0.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/phoenix", new ColorRGBA(187.0F, 0.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/triton", new ColorRGBA(173.0F, 216.0F, 230.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/cerberus", new ColorRGBA(0.0F, 255.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/hydra", new ColorRGBA(144.0F, 238.0F, 144.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/admin", new ColorRGBA(255.0F, 0.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/helper", new ColorRGBA(184.0F, 134.0F, 11.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/shelper", new ColorRGBA(255.0F, 215.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/moder", new ColorRGBA(0.0F, 0.0F, 255.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/smoder", new ColorRGBA(65.0F, 105.0F, 225.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/heat", new ColorRGBA(255.0F, 69.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/cold", new ColorRGBA(135.0F, 206.0F, 250.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/summer", new ColorRGBA(255.0F, 215.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/winter", new ColorRGBA(240.0F, 248.0F, 255.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/youtuber", new ColorRGBA(255.0F, 0.0F, 0.0F).getRGB());
      Ii_field_a567c40b.put("custom:groups/default", new ColorRGBA(255.0F, 255.0F, 255.0F).getRGB());
      i_field_a567c40b.put(42240, new ColorRGBA(120.0F, 120.0F, 120.0F).getRGB());
      i_field_a567c40b.put(42244, new ColorRGBA(100.0F, 113.0F, 251.0F).getRGB());
      i_field_a567c40b.put(42248, new ColorRGBA(214.0F, 200.0F, 42.0F).getRGB());
      i_field_a567c40b.put(42258, new ColorRGBA(101.0F, 189.0F, 56.0F).getRGB());
      i_field_a567c40b.put(42262, new ColorRGBA(64.0F, 151.0F, 214.0F).getRGB());
      i_field_a567c40b.put(42272, new ColorRGBA(202.0F, 130.0F, 60.0F).getRGB());
      i_field_a567c40b.put(42276, new ColorRGBA(202.0F, 60.0F, 60.0F).getRGB());
      i_field_a567c40b.put(42280, new ColorRGBA(245.0F, 51.0F, 238.0F).getRGB());
      i_field_a567c40b.put(42336, new ColorRGBA(214.0F, 200.0F, 42.0F).getRGB());
      i_field_a567c40b.put(42290, new ColorRGBA(121.0F, 81.0F, 202.0F).getRGB());
      i_field_a567c40b.put(42294, new ColorRGBA(202.0F, 130.0F, 60.0F).getRGB());
      i_field_a567c40b.put(42308, new ColorRGBA(202.0F, 60.0F, 60.0F).getRGB());
      i_field_a567c40b.put(42326, new ColorRGBA(68.0F, 65.0F, 66.0F).getRGB());
      i_field_a567c40b.put(42312, new ColorRGBA(127.0F, 214.0F, 86.0F).getRGB());
      i_field_a567c40b.put(42304, new ColorRGBA(92.0F, 120.0F, 7.0F).getRGB());
      i_field_a567c40b.put(42322, new ColorRGBA(120.0F, 120.0F, 120.0F).getRGB());
      i_field_a567c40b.put(42249, new ColorRGBA(214.0F, 200.0F, 42.0F).getRGB());
      i_field_a567c40b.put(42259, new ColorRGBA(100.0F, 113.0F, 251.0F).getRGB());
      i_field_a567c40b.put(42263, new ColorRGBA(100.0F, 113.0F, 251.0F).getRGB());
      i_field_a567c40b.put(42273, new ColorRGBA(121.0F, 81.0F, 202.0F).getRGB());
      i_field_a567c40b.put(42277, new ColorRGBA(100.0F, 113.0F, 251.0F).getRGB());
      i_field_a567c40b.put(42281, new ColorRGBA(121.0F, 81.0F, 202.0F).getRGB());
      i_field_a567c40b.put(42291, new ColorRGBA(64.0F, 151.0F, 214.0F).getRGB());
      i_field_a567c40b.put(42295, new ColorRGBA(202.0F, 60.0F, 60.0F).getRGB());
      i_field_a567c40b.put(42241, new ColorRGBA(121.0F, 81.0F, 202.0F).getRGB());
      i_field_a567c40b.put(42245, new ColorRGBA(255.0F, 255.0F, 255.0F).getRGB());
   }
}
