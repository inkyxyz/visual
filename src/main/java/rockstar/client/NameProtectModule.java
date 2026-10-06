package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.player.PlayerEntity;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Name Protect",
   category = ModuleCategory.UTILS,
   III_method_a89e5834 = "modules.descriptions.name_protect"
)
public class NameProtectModule extends Module {
   private TextSetting I_field_731802cc;
   private BooleanSetting I_field_ba20ca4c;
   private TextSetting i_field_731802cc;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private static final int I_field_49 = 66;
   private static final Pattern I_field_5fd3861f = Pattern.compile(
      "(\u0410\u043d\u0430\u0440\u0445\u0438[\u044f\u0438]\\s*(?:PvP\\s*)?(?:[#\u2116:\\-]|\\s)+)(\\d{1,4})", 66
   );
   private static final Pattern i_field_5fd3861f = Pattern.compile(
      "((?:\u041b\u0430\u0439\u0442|Lite|\u041a\u043b\u0430\u0441\u0441\u0438\u043a|Classic|Classik)\\s+\u0410\u043d\u0430\u0440\u0445\u0438[\u044f\u0438]\\s*[#\u2116:\\-]?\\s*|(?:\u041b\u0430\u0439\u0442|Lite|\u041a\u043b\u0430\u0441\u0441\u0438\u043a|Classic|Classik)\\s*[#\u2116]\\s*)(\\d{1,4})",
      66
   );
   private static final Pattern II_field_5fd3861f = Pattern.compile("(?:play\\.)?holyworld(?:\\.[a-z0-9_.-]+)*", 66);
   private static final Pattern Ii_field_5fd3861f = Pattern.compile("(?:play\\.)?hollyworld(?:\\.[a-z0-9_.-]+)*", 66);
   private static final Pattern iI_field_5fd3861f = Pattern.compile("playhw(?:\\.[a-z0-9_.-]+)*", 66);
   private static final Pattern ii_field_5fd3861f = Pattern.compile("Holy\\s*World|HolyWorld|HollyWorld", 66);
   private static final Pattern III_field_5fd3861f = Pattern.compile("/(?:anarchy|an|lite|classik|classic)\\s*[#\u2116\\-]?\\s*\\d{1,4}", 66);
   private static final Pattern IIi_field_5fd3861f = Pattern.compile("\\b(?:anarchy|an|lite|classik|classic)\\s*[#\u2116\\-]?\\s*\\d{1,4}\\b", 66);
   private static final Pattern IiI_field_5fd3861f = Pattern.compile("\\b(?:Lite|Classic|Classik)\\b", 66);
   private static final Pattern Iii_field_5fd3861f = Pattern.compile(
      "(?<![\u0410-\u042f\u0430-\u044f\u0401\u0451])(?:\u041b\u0430\u0439\u0442|\u041a\u043b\u0430\u0441\u0441\u0438\u043a)(?![\u0410-\u042f\u0430-\u044f\u0401\u0451])",
      66
   );
   private static final Pattern iII_field_5fd3861f = Pattern.compile("\u0410\u043d\u0430\u0440\u0445\u0438[\u044f\u0438]", 66);
   private static final Pattern iIi_field_5fd3861f = Pattern.compile("\\bAnarchy\\b", 66);
   private static final Pattern iiI_field_5fd3861f = Pattern.compile(
      "(?<![A-Za-z0-9_-])(?:(?:[a-z0-9-]+\\.)+[a-z]{2,63}|(?:\\d{1,3}\\.){3}\\d{1,3})(?::\\d{1,5})?(?![A-Za-z0-9_-])", 66
   );
   private static final Pattern iii_field_5fd3861f = Pattern.compile(
      "(?<![\\d.-])-?\\d{1,8}(?:\\.\\d+)?(?:\\s*(?:,|/|;|\\s)\\s*)-?\\d{1,8}(?:\\.\\d+)?(?:\\s*(?:,|/|;|\\s)\\s*)-?\\d{1,8}(?:\\.\\d+)?(?![\\d.])"
   );
   private static final Pattern IIII_field_5fd3861f = Pattern.compile("(?:(?:[xXyYzZ])\\s*[:=]\\s*-?\\d{1,8}(?:\\.\\d+)?\\s*[,;/]?\\s*){3}");
   private static final Pattern IIIi_field_5fd3861f = Pattern.compile(
      "((?:\u0410\u043d\u0430\u0440\u0445\u0438[\u044f\u0438]|Anarchy|\u041b\u0430\u0439\u0442|Lite|\u041a\u043b\u0430\u0441\u0441\u0438\u043a|Classic|Classik|\u0413\u0440\u0438\u0444(?:\u0435\u0440\u0441\u043a\u0438\u0439)?)\\s*(?:PvP\\s*)?(?:[#\u2116:\\-]|\\s)+)(\\d{1,4})",
      66
   );
   private final Set<String> I_field_a56a8dc5 = new HashSet<>();
   private final Map<String, String> I_field_a567c40b = new HashMap<>();
   private String I_field_523beb0a = "";
   private int i_field_49 = -1;
   private Pattern IIiI_field_5fd3861f;
   private boolean I_field_5a = true;

   public NameProtectModule() {
      this.Iii_method_e73a4e5f();
   }

   @Compile(
      obfuscation = 4
   )
   private void Iii_method_e73a4e5f() {
      this.I_field_731802cc = new TextSetting(this, "modules.settings.name_protect.fake_name").I_method_104de33f("Player");
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.name_protect.hide_friends").I_method_decd82b5();
      this.i_field_731802cc = new TextSetting(this, "modules.settings.name_protect.friend_fake_name", () -> !this.I_field_ba20ca4c.i_method_9b12da03())
         .I_method_104de33f("Friend");
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.name_protect.streamer_mode");
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.name_protect.capture_bypass");
   }

   public boolean I_method_46b601a7(CharSequence var1) {
      if (var1 == null || var1.isEmpty()) {
         return false;
      } else if (this.i_field_ba20ca4c.i_method_9b12da03()) {
         return true;
      } else if (this.I_method_65d928b1(var1, I_field_3a9bda27.getSession().getUsername())) {
         return true;
      } else if (IiiiiiiII_Class253.i_method_1cc4aa23() && this.I_method_65d928b1(var1, I_field_3a9bda27.player.getDisplayName().getString())) {
         return true;
      } else {
         if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            for (String var3 : RockstarClient.getInstance().I_method_7a5acaeb().I_method_dbf3f81b()) {
               if (var3 != null && !var3.isEmpty() && this.I_method_65d928b1(var1, var3)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean IiI_method_e72bc283() {
      return this.isEnabled() && this.i_field_ba20ca4c.i_method_9b12da03();
   }

   public boolean i_method_60d6ed87(CharSequence var1) {
      if (!this.I_field_a56a8dc5.isEmpty() && this.I_method_46b601a7(var1)) {
         for (String var3 : this.I_field_a56a8dc5) {
            if (this.I_method_65d928b1(var1, var3)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public void IiI_method_e72bc27f() {
      this.I_field_a56a8dc5.clear();
   }

   private boolean I_method_65d928b1(CharSequence var1, String var2) {
      if (var2 != null && !var2.isEmpty() && var2.length() <= var1.length()) {
         if (var1 instanceof String var5) {
            return var5.contains(var2);
         } else {
            label32:
            for (int var3 = 0; var3 + var2.length() <= var1.length(); var3++) {
               for (int var4 = 0; var4 < var2.length(); var4++) {
                  if (var1.charAt(var3 + var4) != var2.charAt(var4)) {
                     continue label32;
                  }
               }

               return true;
            }

            return false;
         }
      } else {
         return false;
      }
   }

   public String i_method_a8235dd7(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         String var2 = I_field_3a9bda27.getSession().getUsername();
         String var3 = this.i_method_69c4818d(this.I_field_731802cc.II_method_da016c1e(), "Player");
         if (IiiiiiiII_Class253.i_method_1cc4aa23()) {
            var1 = var1.replace(I_field_3a9bda27.player.getDisplayName().getString(), var3);
         }

         var1 = var1.replace(var2, var3);
         if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            IiIIiiII_Class77 var4 = RockstarClient.getInstance().I_method_7a5acaeb();
            String var5 = this.i_method_69c4818d(this.i_field_731802cc.II_method_da016c1e(), "Friend");

            for (String var7 : var4.I_method_dbf3f81b()) {
               if (var7 != null && !var7.isEmpty()) {
                  var1 = var1.replace(var7, var5);
               }
            }
         }

         if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            var1 = this.Ii_method_8ef8dbb4(var1);
         }

         return var1;
      } else {
         return var1;
      }
   }

   public String II_method_6ed9f394(String var1) {
      if (var1 == null || var1.isEmpty()) {
         return var1;
      } else if (IIIiIiIi_Class22.I_method_f1941870()) {
         this.I_field_a56a8dc5.add(var1);
         return var1;
      } else {
         String var2 = this.IIIi_method_a409414(var1);
         if (!Objects.equals(var2, var1)) {
            return var2;
         } else if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            this.iII_method_1c03e63f();
            return this.Iii_method_66913557(var1);
         } else {
            return var1;
         }
      }
   }

   public String I_method_b743616d(String var1, String var2) {
      if (var1 == null || var1.isEmpty()) {
         return var1;
      } else if (IIIiIiIi_Class22.I_method_f1941870()) {
         return var1;
      } else if (var2 != null && !var2.isEmpty()) {
         String var3 = this.II_method_6ed9f394(var2);
         return !Objects.equals(var3, var2) ? this.I_method_71df0ba3(var1, var2, var3) : this.i_method_a8235dd7(var1);
      } else {
         return this.i_method_a8235dd7(var1);
      }
   }

   private String Ii_method_8ef8dbb4(String var1) {
      this.iII_method_1c03e63f();
      var1 = this.IIi_method_82d31977(var1);
      var1 = this.iI_method_52980f74(var1);
      var1 = this.I_method_3d57e3a6(var1, IIII_field_5fd3861f, "");
      var1 = this.I_method_3d57e3a6(var1, iii_field_5fd3861f, "\u2014");
      var1 = this.ii_method_72b6f794(var1);
      return this.iII_method_f6b99177(var1);
   }

   private String iI_method_52980f74(String var1) {
      String var2 = iIIIiiiII_Class285.I_method_2b105481();
      if (var2 != null && !var2.isBlank() && !var2.equalsIgnoreCase("single")) {
         var1 = var1.replace(var2, "server.local");
      }

      String var3 = iIIIiiiII_Class285.I_method_da38608b(false);
      if (var3 != null && var3.length() > 2 && !var3.equalsIgnoreCase("single")) {
         var1 = this.I_method_71df0ba3(var1, var3, "Server");
      }

      return this.I_method_3d57e3a6(var1, iiI_field_5fd3861f, "server.local");
   }

   private String ii_method_72b6f794(String var1) {
      Matcher var2 = IIIi_field_5fd3861f.matcher(var1);
      StringBuffer var3 = new StringBuffer();

      while (var2.find()) {
         var2.appendReplacement(var3, Matcher.quoteReplacement(var2.group(1) + "\u2014"));
      }

      var2.appendTail(var3);
      return this.III_method_62b43157(var3.toString());
   }

   private String III_method_62b43157(String var1) {
      int var2 = iIIIiiiII_Class285.I_method_f5437df2();
      if (var2 <= 0) {
         return var1;
      } else {
         var1 = this.I_method_62d86c46(var1, "#", var2, "\u2014");
         return this.I_method_62d86c46(var1, "\u2116", var2, "\u2014");
      }
   }

   private void iII_method_1c03e63f() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.player.networkHandler != null) {
         String var1 = iIIIiiiII_Class285.I_method_2b105481();
         if (!Objects.equals(this.I_field_523beb0a, var1)) {
            this.I_field_a567c40b.clear();
            this.I_field_523beb0a = var1;
            this.i_field_49 = -1;
            this.I_field_5a = true;
         }

         if (this.i_field_49 != I_field_3a9bda27.player.age) {
            this.i_field_49 = I_field_3a9bda27.player.age;

            for (PlayerListEntry var3 : I_field_3a9bda27.player.networkHandler.getPlayerList()) {
               String var4 = var3.getProfile().getName();
               String var5 = var3.getProfile().getId() != null ? var3.getProfile().getId().toString() : var4.toLowerCase(Locale.ROOT);
               this.I_method_1d4acb93(var4, var5);
            }

            if (I_field_3a9bda27.world != null) {
               for (PlayerEntity var7 : I_field_3a9bda27.world.getPlayers()) {
                  this.I_method_1d4acb93(var7.getName().getString(), var7.getUuidAsString());
               }
            }
         }
      } else {
         this.I_field_a567c40b.clear();
         this.I_field_523beb0a = "";
         this.i_field_49 = -1;
         this.I_field_5a = true;
      }
   }

   private void I_method_1d4acb93(String var1, String var2) {
      if (this.I_method_ab90b20d(var1) && !var1.equalsIgnoreCase(I_field_3a9bda27.getSession().getUsername())) {
         this.I_field_a567c40b.computeIfAbsent(var1, var2x -> {
            this.I_field_5a = true;
            return this.IiI_method_46724d37(var2);
         });
      }
   }

   private String IIi_method_82d31977(String var1) {
      Pattern var2 = this.i_method_8a68b0a8();
      if (var2 == null) {
         return var1;
      } else {
         Matcher var3 = var2.matcher(var1);
         if (!var3.find()) {
            return var1;
         } else {
            StringBuffer var4 = new StringBuffer();

            do {
               String var5 = var3.group();
               String var6 = this.I_field_a567c40b.get(var5);
               var3.appendReplacement(var4, Matcher.quoteReplacement(var6 != null ? var6 : var5));
            } while (var3.find());

            var3.appendTail(var4);
            return var4.toString();
         }
      }
   }

   private Pattern i_method_8a68b0a8() {
      if (this.I_field_5a) {
         this.IIiI_field_5fd3861f = this.II_method_7b564f0b();
         this.I_field_5a = false;
      }

      return this.IIiI_field_5fd3861f;
   }

   private Pattern II_method_7b564f0b() {
      if (this.I_field_a567c40b.isEmpty()) {
         return null;
      } else {
         ArrayList var1 = new ArrayList<>(this.I_field_a567c40b.keySet());
         var1.sort(Comparator.comparingInt(String::length).reversed());
         StringBuilder var2 = new StringBuilder("(?<![A-Za-z0-9_])(?:");

         for (int var3 = 0; var3 < var1.size(); var3++) {
            if (var3 > 0) {
               var2.append('|');
            }

            var2.append(Pattern.quote((String)var1.get(var3)));
         }

         var2.append(")(?![A-Za-z0-9_])");
         return Pattern.compile(var2.toString());
      }
   }

   private String IiI_method_46724d37(String var1) {
      int var2 = Math.floorMod(var1.hashCode(), 900) + 100;
      HashSet var3 = new HashSet<>(this.I_field_a567c40b.values());

      for (int var4 = 0; var4 < 900; var4++) {
         String var5 = "P" + var2;
         if (!var3.contains(var5)) {
            return var5;
         }

         if (++var2 > 999) {
            var2 = 100;
         }
      }

      return "P" + (this.I_field_a567c40b.size() + 1000);
   }

   private String Iii_method_66913557(String var1) {
      return this.I_method_ab90b20d(var1) && !var1.equalsIgnoreCase(I_field_3a9bda27.getSession().getUsername())
         ? this.I_field_a567c40b.computeIfAbsent(var1, var1x -> {
            this.I_field_5a = true;
            return this.IiI_method_46724d37(var1x.toLowerCase(Locale.ROOT));
         })
         : var1;
   }

   private String iII_method_f6b99177(String var1) {
      var1 = this.iIi_method_16d87997(var1);
      var1 = this.iiI_method_da77ad57(var1);
      var1 = this.iii_method_fa969577(var1);
      return this.IIII_method_ea21abf4(var1);
   }

   private String iIi_method_16d87997(String var1) {
      var1 = this.I_method_80a84430(var1, I_field_5fd3861f);
      var1 = this.I_method_80a84430(var1, i_field_5fd3861f);
      int var2 = iIIIiiiII_Class285.I_method_f5437df2();
      if (var2 > 0) {
         int var3 = this.I_method_ee9148d7(var2);
         var1 = this.I_method_62d86c46(var1, "#", var2, Integer.toString(var3));
         var1 = this.I_method_62d86c46(var1, "\u2116", var2, Integer.toString(var3));
      }

      return var1;
   }

   private String iiI_method_da77ad57(String var1) {
      var1 = this.I_method_3d57e3a6(var1, II_field_5fd3861f, "server.local");
      var1 = this.I_method_3d57e3a6(var1, Ii_field_5fd3861f, "server.local");
      var1 = this.I_method_3d57e3a6(var1, iI_field_5fd3861f, "server.local");
      return this.I_method_3d57e3a6(var1, ii_field_5fd3861f, "Server");
   }

   private String iii_method_fa969577(String var1) {
      var1 = this.I_method_3d57e3a6(var1, III_field_5fd3861f, "/server");
      return this.I_method_3d57e3a6(var1, IIi_field_5fd3861f, "server");
   }

   private String IIII_method_ea21abf4(String var1) {
      var1 = this.I_method_3d57e3a6(var1, IiI_field_5fd3861f, "PvP");
      var1 = this.I_method_3d57e3a6(var1, Iii_field_5fd3861f, "PvP");
      var1 = this.I_method_3d57e3a6(var1, iII_field_5fd3861f, "\u0420\u0435\u0436\u0438\u043c");
      return this.I_method_3d57e3a6(var1, iIi_field_5fd3861f, "Mode");
   }

   private String I_method_80a84430(String var1, Pattern var2) {
      Matcher var3 = var2.matcher(var1);
      StringBuffer var4 = new StringBuffer();

      while (var3.find()) {
         int var5 = this.I_method_ab90b1fc(var3.group(2));
         String var6 = var5 > 0 ? var3.group(1) + this.I_method_ee9148d7(var5) : var3.group(0);
         var3.appendReplacement(var4, Matcher.quoteReplacement(var6));
      }

      var3.appendTail(var4);
      return var4.toString();
   }

   private String I_method_62d86c46(String var1, String var2, int var3, String var4) {
      return !var1.contains(var2 + var3)
         ? var1
         : Pattern.compile(Pattern.quote(var2) + var3 + "(?!\\d)").matcher(var1).replaceAll(Matcher.quoteReplacement(var2 + var4));
   }

   private int I_method_ee9148d7(int var1) {
      return var1 + 5;
   }

   private String IIIi_method_a409414(String var1) {
      String var2 = I_field_3a9bda27.getSession().getUsername();
      if (var1.equals(var2)) {
         return this.i_method_69c4818d(this.I_field_731802cc.II_method_da016c1e(), "Player");
      } else if (IiiiiiiII_Class253.i_method_1cc4aa23() && var1.equals(I_field_3a9bda27.player.getDisplayName().getString())) {
         return this.i_method_69c4818d(this.I_field_731802cc.II_method_da016c1e(), "Player");
      } else {
         if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            IiIIiiII_Class77 var3 = RockstarClient.getInstance().I_method_7a5acaeb();

            for (String var5 : var3.I_method_dbf3f81b()) {
               if (var5 != null && !var5.isEmpty() && var5.equals(var1)) {
                  return this.i_method_69c4818d(this.i_field_731802cc.II_method_da016c1e(), "Friend");
               }
            }
         }

         return var1;
      }
   }

   private String I_method_3d57e3a6(String var1, Pattern var2, String var3) {
      return var2.matcher(var1).replaceAll(Matcher.quoteReplacement(var3));
   }

   private String I_method_71df0ba3(String var1, String var2, String var3) {
      return var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty() && var1.contains(var2)
         ? Pattern.compile("(?<![A-Za-z0-9_])" + Pattern.quote(var2) + "(?![A-Za-z0-9_])").matcher(var1).replaceAll(Matcher.quoteReplacement(var3))
         : var1;
   }

   private int I_method_ab90b1fc(String var1) {
      try {
         return Integer.parseInt(var1);
      } catch (NumberFormatException var3) {
         return -1;
      }
   }

   private boolean I_method_ab90b20d(String var1) {
      if (var1 != null && var1.length() >= 3 && var1.length() <= 16) {
         for (int var2 = 0; var2 < var1.length(); var2++) {
            char var3 = var1.charAt(var2);
            if ((var3 < 'A' || var3 > 'Z') && (var3 < 'a' || var3 > 'z') && (var3 < '0' || var3 > '9') && var3 != '_') {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private String i_method_69c4818d(String var1, String var2) {
      return var1 != null && !var1.isEmpty() ? var1 : var2;
   }

   @Generated
   public TextSetting I_method_37773b35() {
      return this.I_field_731802cc;
   }

   @Generated
   public BooleanSetting I_method_7e8002b5() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public TextSetting i_method_4d0caf15() {
      return this.i_field_731802cc;
   }

   @Generated
   public BooleanSetting i_method_94157695() {
      return this.i_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting II_method_150838() {
      return this.II_field_ba20ca4c;
   }

   @Generated
   public Set<String> I_method_bdd45bae() {
      return this.I_field_a56a8dc5;
   }

   @Generated
   public Map<String, String> i_method_500dd5d4() {
      return this.I_field_a567c40b;
   }

   @Generated
   public String II_method_c2a139e() {
      return this.I_field_523beb0a;
   }

   @Generated
   public int II_method_ee9fcd35() {
      return this.i_field_49;
   }

   @Generated
   public Pattern I_method_7047c4c8() {
      return this.IIiI_field_5fd3861f;
   }

   @Generated
   public boolean Iii_method_e73a4e63() {
      return this.I_field_5a;
   }
}
