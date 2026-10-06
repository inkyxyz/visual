package rockstar.client;

import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;
import net.minecraft.text.Text;
import ua.mintantileak.profile.Profile;
import ua.mintantileak.profile.Role;
import ua.mintantileak.spk.Compile;

public class IIIiiiIi_Class30 {
   private final List<IIIiiIIi_Class26> I_field_7865b31 = new ArrayList<>();
   private String I_field_523beb0a = ".";

   @Compile
   public final void I_method_306252ed(IIIiiIIi_Class26 var1) {
      this.I_field_7865b31.add(var1);
   }

   public final boolean I_method_306252f1(IIIiiIIi_Class26 var1) {
      return this.I_field_7865b31.remove(var1);
   }

   @Compile
   public final void I_method_7a21f88c() {
      this.I_method_306252ed(new IIiIiIIi_Class42().I_method_d4f1738b()); // .config / .cfg
      this.I_method_306252ed(new IIiiiiII_Class61().I_method_cde7e3ab()); // .waypoint
   }

   public final List<IIIiiIIi_Class26> I_method_cafa303b() {
      return Collections.unmodifiableList(this.I_field_7865b31);
   }

   public final boolean i_method_45f7c6d1(IIIiiIIi_Class26 var1) {
      List var2 = var1.Ii_method_9140c992();
      if (var2 != null && !var2.isEmpty()) {
         Role var3 = Profile.getRole();

         for (Role var5 : (Iterable<Role>)(Iterable<?>)var2) {
            if (var5 == var3) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public final boolean I_method_9e86975a(String var1) {
      if (var1.startsWith(this.I_field_523beb0a) && !RockstarClient.I_field_502d1741.i_method_e8604970()) {
         String var2 = var1.substring(this.I_field_523beb0a.length()).trim();
         if (var2.isEmpty()) {
            return true;
         } else {
            String[] var3 = I_method_367b81a5(var2);
            if (var3.length == 0) {
               return true;
            } else {
               if (var3[0].equalsIgnoreCase("fr") || var3[0].equalsIgnoreCase("friend")) {
                  IiIIiiII_Class77 friendMgr = RockstarClient.getInstance().I_method_7a5acaeb();
                  if (var3.length < 2) {
                     iIIIIIIii_Class260.I_method_468cf607(Text.of("§7[§aFriends§7] §fКоманды: §e.fr add <ник> §7| §e.fr remove <ник> §7| §e.fr list §7| §e.fr clear §7| §e.fr protect"));
                     return true;
                  }
                  String sub = var3[1].toLowerCase();
                  switch (sub) {
                     case "add" -> {
                        if (var3.length < 3) {
                           iIIIIIIii_Class260.II_method_e8fd4864(Text.of("§7[§cFriends§7] §fУкажите ник: §e.fr add <ник>"));
                        } else {
                           friendMgr.I_method_19c94376(var3[2].trim());
                        }
                     }
                     case "remove", "del", "delete" -> {
                        if (var3.length < 3) {
                           iIIIIIIii_Class260.II_method_e8fd4864(Text.of("§7[§cFriends§7] §fУкажите ник: §e.fr remove <ник>"));
                        } else {
                           friendMgr.i_method_ea809756(var3[2].trim());
                        }
                     }
                     case "list" -> {
                        List<String> list = friendMgr.I_method_dbf3f81b();
                        if (list.isEmpty()) {
                           iIIIIIIii_Class260.I_method_468cf607(Text.of("§7[§aFriends§7] §fСписок друзей пуст."));
                        } else {
                           String names = String.join("§7, §a", list);
                           iIIIIIIii_Class260.I_method_468cf607(Text.of("§7[§aFriends§7] §fДрузья (§e" + list.size() + "§f): §a" + names));
                        }
                     }
                     case "clear" -> {
                        friendMgr.I_method_b08d6cac();
                     }
                     case "protect", "friendlyfire", "damage" -> {
                        boolean cur = friendMgr.isFriendlyFireProtection();
                        friendMgr.setFriendlyFireProtection(!cur);
                        iIIIIIIii_Class260.I_method_468cf607(Text.of("§7[§aFriends§7] §fЗащита друзей: " + (!cur ? "§aВКЛЮЧЕНА (урон заблокирован)" : "§cВЫКЛЮЧЕНА (урон наносится)")));
                     }
                     default -> {
                        iIIIIIIii_Class260.II_method_e8fd4864(Text.of("§7[§cFriends§7] §fНеизвестное действие: §e" + sub + "§f. Доступно: §eadd, remove, list, clear, protect"));
                     }
                  }
                  return true;
               }
               if (var3[0].equalsIgnoreCase("font") || var3[0].equalsIgnoreCase("fonts")) {
                  if (var3.length < 2) {
                     iIIIIIIii_Class260.I_method_468cf607(Text.of("§7[§6Font§7] §fДоступные шрифты: §eInter, Medium, SemiBold, Bold, Round, JetBrains, Light"));
                     return true;
                  }
                  String chosen = var3[1].trim();
                  IIiIiI_Class11.applyFontPreset(chosen);
                  iIIIIIIii_Class260.I_method_468cf607(Text.of("§7[§6Font§7] §fШрифт переключен на: §a" + chosen));
                  return true;
               }
               List var4 = Arrays.asList(var3);
               IIIiiiIi_Class30.Nested1_bb9e9113 var5 = this.I_method_d8687123(var4, null, 0, true);
               if (var5 == null) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.unknown")));
                  return false;
               } else if (!var5.I_method_68ea268b()) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.no_access")));
                  return false;
               } else {
                  IIIiiIIi_Class26 var6 = var5.I_method_a902d250();
                  int var7 = var5.I_method_68ea267a();
                  if (!var6.I_method_7dfc5cb0()) {
                     iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.not_executable")));
                     return false;
                  } else {
                     List var8 = this.I_method_d6b15df6(var6, var3, var7);
                     if (var8 == null) {
                        return true;
                     } else {
                        var6.I_method_2830e7cb().execute(new IIIiiIii_Class28(var6, var8));
                        return true;
                     }
                  }
               }
            }
         }
      } else {
         return false;
      }
   }

   private IIIiiiIi_Class30.Nested1_bb9e9113 I_method_d8687123(List<String> var1, IIIiiIIi_Class26 var2, int var3, boolean var4) {
      List var5 = var2 == null ? this.I_field_7865b31 : var2.II_method_dbf49172();
      if (var3 >= var1.size()) {
         return this.I_method_e58ae134(var2, var3 - 1, var4);
      } else {
         String var6 = (String)var1.get(var3);

         for (IIIiiIIi_Class26 var8 : (Iterable<IIIiiIIi_Class26>)(Iterable<?>)var5) {
            for (String var10 : var8.I_method_84c7081b()) {
               if (var10.equalsIgnoreCase(var6)) {
                  boolean var11 = var4 && this.i_method_45f7c6d1(var8);
                  IIIiiiIi_Class30.Nested1_bb9e9113 var12 = this.I_method_d8687123(var1, var8, var3 + 1, var11);
                  if (var12 != null) {
                     return var12;
                  }

                  return new IIIiiiIi_Class30.Nested1_bb9e9113(var8, var3, var11);
               }
            }
         }

         return this.I_method_e58ae134(var2, var3 - 1, var4);
      }
   }

   private IIIiiiIi_Class30.Nested1_bb9e9113 I_method_e58ae134(IIIiiIIi_Class26 var1, int var2, boolean var3) {
      return var1 != null ? new IIIiiiIi_Class30.Nested1_bb9e9113(var1, var2, var3) : null;
   }

   private List<Object> I_method_d6b15df6(IIIiiIIi_Class26 var1, String[] var2, int var3) {
      List var4 = var1.i_method_3a13403b();
      ArrayList var5 = new ArrayList();
      int var6 = var3 + 1;
      int var7 = var2.length;

      for (IIIiiiiI_Class31 var9 : (Iterable<IIIiiiiI_Class31>)(Iterable<?>)var4) {
         if (var9.i_method_e05cd8b0()) {
            ArrayList var13 = new ArrayList();

            for (int var11 = var6; var11 < var7; var11++) {
               IIiIIIIi_Class34 var12 = var9.I_method_b07233eb().validate(var2[var11]);
               if (var12 instanceof IIiIIIIi_Class34.Nested1_e29ec0d3) {
                  return null;
               }

               var13.add(((IIiIIIIi_Class34.Nested1_e29ec0f3)var12).I_method_dcd4f76b());
            }

            if (var9.I_method_e04e4cd0() && var13.isEmpty()) {
               IIiIIIIi_Class34.I_method_c9d442bc("Missing value for argument '" + var9.I_method_420d5954() + "'");
               return null;
            }

            var5.add(var13);
            return var5;
         }

         if (var6 >= var7) {
            if (var9.I_method_e04e4cd0()) {
               IIiIIIIi_Class34.I_method_c9d442bc("Missing value for argument '" + var9.I_method_420d5954() + "'");
               return null;
            }

            var5.add(null);
         } else {
            IIiIIIIi_Class34 var10 = var9.I_method_b07233eb().validate(var2[var6]);
            if (var10 instanceof IIiIIIIi_Class34.Nested1_e29ec0d3) {
               return null;
            }

            var5.add(((IIiIIIIi_Class34.Nested1_e29ec0f3)var10).I_method_dcd4f76b());
            var6++;
         }
      }

      if (var6 < var7) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.too_many_args")));
         return null;
      } else {
         return var5;
      }
   }

   private static String[] I_method_367b81a5(String var0) {
      List var1 = I_method_896fc43a(var0, 0);
      String[] var2 = new String[var1.size()];

      for (int var3 = 0; var3 < var2.length; var3++) {
         var2[var3] = ((IIIiiiIi_Class30.Nested1_bb9e9133)var1.get(var3)).I_method_2841f519();
      }

      return var2;
   }

   private static List<IIIiiiIi_Class30.Nested1_bb9e9133> I_method_896fc43a(String var0, int var1) {
      ArrayList var2 = new ArrayList();
      StringBuilder var3 = new StringBuilder();
      int var4 = -1;
      boolean var5 = false;

      for (int var6 = 0; var6 < var0.length(); var6++) {
         char var7 = var0.charAt(var6);
         if (var5) {
            if (var7 == '\\' && var6 + 1 < var0.length() && var0.charAt(var6 + 1) == '"') {
               var3.append('"');
               var6++;
            } else if (var7 == '"') {
               var5 = false;
            } else {
               var3.append(var7);
            }
         } else if (var7 == '"') {
            var5 = true;
            if (var4 < 0) {
               var4 = var6;
            }
         } else if (Character.isWhitespace(var7)) {
            if (var4 >= 0) {
               var2.add(new IIIiiiIi_Class30.Nested1_bb9e9133(var3.toString(), var1 + var4, var1 + var6));
               var3.setLength(0);
               var4 = -1;
            }
         } else {
            var3.append(var7);
            if (var4 < 0) {
               var4 = var6;
            }
         }
      }

      if (var4 >= 0) {
         var2.add(new IIIiiiIi_Class30.Nested1_bb9e9133(var3.toString(), var1 + var4, var1 + var0.length()));
      }

      return var2;
   }

   public final CompletableFuture<Suggestions> I_method_c497dd67(String var1, int var2) {
      if (var1.startsWith(this.I_field_523beb0a) && var2 >= this.I_field_523beb0a.length() && !RockstarClient.I_field_502d1741.i_method_e8604970()) {
         String var3 = var1.substring(0, Math.min(var2, var1.length()));
         List var4 = I_method_896fc43a(var3.substring(this.I_field_523beb0a.length()), this.I_field_523beb0a.length());
         IIIiiiIi_Class30.Nested1_bb9e9133 var5 = !var4.isEmpty() && ((IIIiiiIi_Class30.Nested1_bb9e9133)var4.getLast()).i_method_9f93c63a() >= var3.length()
            ? (IIIiiiIi_Class30.Nested1_bb9e9133)var4.getLast()
            : null;
         boolean var6 = var5 == null;
         List var7 = this.I_field_7865b31;
         IIIiiIIi_Class26 var8 = null;
         int var9 = 0;

         for (int var10 = 0; var10 < var4.size(); var10++) {
            IIIiiIIi_Class26 var11 = this.I_method_1e3956d0(var7, ((IIIiiiIi_Class30.Nested1_bb9e9133)var4.get(var10)).I_method_2841f519());
            if (var11 == null) {
               break;
            }

            var8 = var11;
            var9 = var10 + 1;
            var7 = var11.II_method_dbf49172();
            if (var7.isEmpty()) {
               break;
            }
         }

         int var21 = var4.size() - var9;
         String var22 = var5 != null ? var5.I_method_2841f519() : "";
         int var12 = var5 != null ? var5.I_method_9f853a5a() : var2;
         StringRange var13 = StringRange.between(var12, var2);
         ArrayList var14 = new ArrayList();
         if (var8 == null) {
            String var15 = var22.toLowerCase();

            for (IIIiiIIi_Class26 var17 : (Iterable<IIIiiIIi_Class26>)(Iterable<?>)var7) {
               if (this.i_method_45f7c6d1(var17)) {
                  String var18 = var17.I_method_84c7081b().getFirst();
                  if (var18.toLowerCase().startsWith(var15)) {
                     I_method_3513aa43(var14, var13, var18);
                  }
               }
            }
         } else if (!var7.isEmpty() && (var21 == 0 || var21 == 1 && !var6)) {
            String var24 = var22.toLowerCase();

            for (IIIiiIIi_Class26 var28 : (Iterable<IIIiiIIi_Class26>)(Iterable<?>)var7) {
               if (this.i_method_45f7c6d1(var28)) {
                  String var30 = var28.I_method_84c7081b().getFirst();
                  if (var30.toLowerCase().startsWith(var24)) {
                     I_method_3513aa43(var14, var13, var30);
                  }
               }
            }
         } else {
            if (var21 == 0 && !var6) {
               return Suggestions.empty();
            }

            List var23 = var8.i_method_3a13403b();
            int var25 = var21 - (var6 ? 0 : 1);
            if (var25 < 0) {
               var25 = 0;
            }

            IIIiiiiI_Class31 var27 = null;
            if (var25 >= var23.size()) {
               if (!var23.isEmpty() && ((IIIiiiiI_Class31)var23.getLast()).i_method_e05cd8b0()) {
                  var27 = (IIIiiiiI_Class31)var23.getLast();
               }
            } else {
               var27 = (IIIiiiiI_Class31)var23.get(var25);
            }

            if (var27 != null && var27.I_method_b07233eb() != null) {
               String var29 = var22.toLowerCase();

               for (String var20 : var27.I_method_b07233eb().suggestions(var29)) {
                  I_method_3513aa43(var14, var13, var20);
               }
            }
         }

         return !var14.isEmpty() ? CompletableFuture.completedFuture(new Suggestions(var13, var14)) : Suggestions.empty();
      } else {
         return Suggestions.empty();
      }
   }

   private IIIiiIIi_Class26 I_method_1e3956d0(List<IIIiiIIi_Class26> var1, String var2) {
      for (IIIiiIIi_Class26 var4 : var1) {
         if (this.i_method_45f7c6d1(var4)) {
            for (String var6 : var4.I_method_84c7081b()) {
               if (var6.equalsIgnoreCase(var2)) {
                  return var4;
               }
            }
         }
      }

      return null;
   }

   private static void I_method_3513aa43(List<Suggestion> var0, StringRange var1, String var2) {
      String var3 = I_method_dcd6340a(var2);

      for (Suggestion var5 : var0) {
         if (var5.getText().equalsIgnoreCase(var3)) {
            return;
         }
      }

      var0.add(new Suggestion(var1, var3));
   }

   private static String I_method_dcd6340a(String var0) {
      boolean var1 = false;

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         if (Character.isWhitespace(var3) || var3 == '"') {
            var1 = true;
            break;
         }
      }

      return !var1 ? var0 : "\"" + var0.replace("\"", "\\\"") + "\"";
   }

   @Generated
   public String I_method_80ea594() {
      return this.I_field_523beb0a;
   }

   @Generated
   public void I_method_9e869756(String var1) {
      this.I_field_523beb0a = var1;
   }

   static final class Nested1_bb9e9113 {
      private final IIIiiIIi_Class26 I_field_79bd4f61;
      private final int I_field_49;
      private final boolean I_field_5a;

      Nested1_bb9e9113(IIIiiIIi_Class26 var1, int var2, boolean var3) {
         this.I_field_79bd4f61 = var1;
         this.I_field_49 = var2;
         this.I_field_5a = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_bb9e9113[command=" + this.I_field_79bd4f61 + ", index=" + this.I_field_49 + ", accessible=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_79bd4f61);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiiiIi_Class30.Nested1_bb9e9113 other = (IIIiiiIi_Class30.Nested1_bb9e9113) var1;
         return java.util.Objects.equals(this.I_field_79bd4f61, other.I_field_79bd4f61)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public IIIiiIIi_Class26 I_method_a902d250() {
         return this.I_field_79bd4f61;
      }

      public int I_method_68ea267a() {
         return this.I_field_49;
      }

      public boolean I_method_68ea268b() {
         return this.I_field_5a;
      }
   }

   static final class Nested1_bb9e9133 {
      private final String I_field_523beb0a;
      private final int I_field_49;
      private final int i_field_49;

      Nested1_bb9e9133(String var1, int var2, int var3) {
         this.I_field_523beb0a = var1;
         this.I_field_49 = var2;
         this.i_field_49 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_bb9e9133[text=" + this.I_field_523beb0a + ", start=" + this.I_field_49 + ", end=" + this.i_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiiiIi_Class30.Nested1_bb9e9133 other = (IIIiiiIi_Class30.Nested1_bb9e9133) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49);
      }

      public String I_method_2841f519() {
         return this.I_field_523beb0a;
      }

      public int I_method_9f853a5a() {
         return this.I_field_49;
      }

      public int i_method_9f93c63a() {
         return this.i_field_49;
      }
   }
}
