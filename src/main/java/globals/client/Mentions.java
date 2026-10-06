package globals.client;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Mentions {
   private static final Pattern MENTION = Pattern.compile("(?<![A-Za-z0-9_])@([A-Za-z0-9_]{3,20})");
   private static final Pattern TYPING = Pattern.compile("(?<![A-Za-z0-9_])@([A-Za-z0-9_]{0,20})$");

   private Mentions() {
   }

   public static boolean mentions(String var0, String var1) {
      if (var0 != null && var1 != null && !var1.isBlank() && var0.indexOf(64) >= 0) {
         Matcher var2 = MENTION.matcher(var0);

         while (var2.find()) {
            if (var2.group(1).equalsIgnoreCase(var1)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean mentionsMe(String var0) {
      GlobalsUser var1 = Information.getPreferUser();
      return var1 != null && mentions(var0, var1.username());
   }

   public static boolean isMe(String var0) {
      GlobalsUser var1 = Information.getPreferUser();
      return var1 != null && var1.username().equalsIgnoreCase(var0);
   }

   public static List<Mentions.Nested1_b5df6429> split(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         if (var0.indexOf(64) < 0) {
            return List.of(new Mentions.Nested1_b5df6429(var0, null));
         } else {
            ArrayList var1 = new ArrayList();
            Matcher var2 = MENTION.matcher(var0);

            int var3;
            for (var3 = 0; var2.find(); var3 = var2.end()) {
               if (var2.start() > var3) {
                  var1.add(new Mentions.Nested1_b5df6429(var0.substring(var3, var2.start()), null));
               }

               var1.add(new Mentions.Nested1_b5df6429(var2.group(), var2.group(1)));
            }

            if (var3 < var0.length()) {
               var1.add(new Mentions.Nested1_b5df6429(var0.substring(var3), null));
            }

            return var1;
         }
      } else {
         return List.of();
      }
   }

   public static boolean possible(String var0) {
      return var0 != null && var0.indexOf(64) >= 0;
   }

   public static String typed(String var0) {
      if (var0 != null && var0.indexOf(64) >= 0) {
         Matcher var1 = TYPING.matcher(var0);
         return var1.find() ? var1.group(1) : null;
      } else {
         return null;
      }
   }

   public static String complete(String var0, String var1) {
      if (var0 != null && var1 != null) {
         Matcher var2 = TYPING.matcher(var0);
         return !var2.find() ? var0 : var0.substring(0, var2.start()) + "@" + var1 + " ";
      } else {
         return var0;
      }
   }

   public static final class Nested1_b5df6429 {
      private final String text;
      private final String mention;

      public Nested1_b5df6429(String var1, String var2) {
         this.text = var1;
         this.mention = var2;
      }

      public boolean isMention() {
         return this.mention != null;
      }

      @Override
      public final String toString() {
         return "Nested1_b5df6429[text=" + this.text() + ", mention=" + this.mention() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.text());
         result = 31 * result + java.util.Objects.hashCode(this.mention());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Mentions.Nested1_b5df6429 other = (Mentions.Nested1_b5df6429) var1;
         return java.util.Objects.equals(this.text(), other.text())
            && java.util.Objects.equals(this.mention(), other.mention());
      }

      public String text() {
         return this.text;
      }

      public String mention() {
         return this.mention;
      }
   }
}
