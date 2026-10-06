package rockstar.client;

import java.util.List;
import java.util.Locale;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.ClickEvent.Action;
import net.minecraft.util.Formatting;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

public class IIiiIIII_Class49 {
   public final IIIiiIIi_Class26 I_method_6ef7dfab() {
      return IIIiiIiI_Class27.I_method_fa8865f9("macro", var0 -> var0.I_method_b3f941e4("macros").i_method_cfe1a061("commands.macro.description"))
         .i_method_3d6e11d9("action", var0 -> {
            var0.I_method_a44fe164("add", "remove", "delete", "list", "clear");
            var0.I_method_f005ecf3("add", "remove", "list", "clear");
         })
         .i_method_3d6e11d9("arguments", var0 -> var0.I_method_e930dfcb().i_method_132d6feb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a))
         .I_method_16f05c8a(this::I_method_22073b4d)
         .I_method_9111538b();
   }

   @Compile
   private void I_method_22073b4d(IIIiiIii_Class28 var1) {
      String var2 = (String)var1.I_method_557e5bfb().getFirst();
      List var3 = var1.I_method_557e5bfb().size() > 1 ? (List)var1.I_method_557e5bfb().get(1) : List.of();
      IiIiIiII_Class85 var4 = RockstarClient.getInstance().I_method_af32eeab();
      String var5 = var2.toLowerCase(Locale.ROOT);
      switch (var5) {
         case "add":
            this.I_method_868ca1de(var4, var3);
            break;
         case "remove":
         case "delete":
            this.i_method_b57e55be(var4, var3);
            break;
         case "list":
            this.I_method_43378eed(var4);
            break;
         case "clear":
            this.i_method_58cd02cd(var4);
      }
   }

   private void I_method_868ca1de(IiIiIiII_Class85 var1, List<String> var2) {
      if (var2.size() < 2) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.macro.error_arguments")));
      } else {
         IIiiIIII_Class49.Nested1_7f65b0d3 var3 = this.I_method_9aaa3c35(var2);
         if (var3 == null) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.macro.error_key")));
         } else {
            var1.I_method_2f3b428d(var3.I_method_2d579cb9(), var3.I_method_1760deba());
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            iIIIIIIii_Class260.I_method_468cf607(
               Text.of(
                  IiIiIIII_Class81.I_method_1410d1e5(
                     "commands.macro.added", var3.I_method_2d579cb9(), iIIIIiIiI_Class267.I_method_a937749c(var3.I_method_1760deba())
                  )
               )
            );
         }
      }
   }

   private void i_method_b57e55be(IiIiIiII_Class85 var1, List<String> var2) {
      if (var2.isEmpty()) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.macro.error_arguments")));
      } else {
         IIiiIIII_Class49.Nested1_7f65b0d3 var3 = this.I_method_9aaa3c35(var2);
         boolean var4;
         if (var3 != null) {
            var4 = var1.I_method_2f3b4291(var3.I_method_2d579cb9(), var3.I_method_1760deba());
            if (var4) {
               iIIIIIIii_Class260.I_method_468cf607(
                  Text.of(
                     IiIiIIII_Class81.I_method_1410d1e5(
                        "commands.macro.removed_specific", var3.I_method_2d579cb9(), iIIIIiIiI_Class267.I_method_a937749c(var3.I_method_1760deba())
                     )
                  )
               );
            }
         } else {
            String var5 = String.join(" ", var2);
            int var6 = iIIIIIIIi_Class258.I_method_dc7f39fc(var5);
            if (var6 != -1) {
               var4 = var1.I_method_7488d01b(var6);
               if (var4) {
                  iIIIIIIii_Class260.I_method_468cf607(
                     Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.macro.removed_key", iIIIIiIiI_Class267.I_method_a937749c(var6)))
                  );
               }
            } else {
               var4 = var1.I_method_9c8173a(var5);
               if (var4) {
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.macro.removed_command", var5)));
               }
            }
         }

         if (!var4) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.macro.not_found")));
         } else {
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
         }
      }
   }

   private void I_method_43378eed(IiIiIiII_Class85 var1) {
      List var2 = var1.I_method_e1cbbc5b();
      if (var2.isEmpty()) {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.macro.list_empty")));
      } else {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.macro.list_header")));
         int var3 = 1;

         for (IiIiIIii_Class84 var5 : (Iterable<IiIiIIii_Class84>)(Iterable<?>)var2) {
            String var6 = var5.I_method_f1090d94();
            String var7 = ".macro remove " + var6;
            MutableText var8 = Text.literal("[" + var3++ + "] ")
               .setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY)))
               .append(
                  Text.literal(var6 + " ")
                     .setStyle(
                        Style.EMPTY
                           .withColor(TextColor.fromRgb(new ColorRGBA(87.0F, 126.0F, 255.0F).getRGB()))
                           .withClickEvent(new ClickEvent(Action.RUN_COMMAND, var7))
                           .withHoverEvent(
                              new HoverEvent(
                                 net.minecraft.text.HoverEvent.Action.SHOW_TEXT, Text.literal(IiIiIIII_Class81.I_method_f25a980a("macro.hover_delete"))
                              )
                           )
                     )
               )
               .append(Text.literal("(" + iIIIIiIiI_Class267.I_method_a937749c(var5.I_method_886a907f()) + ")"))
               .setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY)));
            iIIIIIIii_Class260.Ii_method_12f9d884(var8);
         }
      }
   }

   private void i_method_58cd02cd(IiIiIiII_Class85 var1) {
      if (var1.I_method_e1cbbc5b().isEmpty()) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.macro.list_empty")));
      } else {
         var1.I_method_b12db06c();
         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.macro.cleared")));
      }
   }

   private IIiiIIII_Class49.Nested1_7f65b0d3 I_method_9aaa3c35(List<String> var1) {
      if (var1.isEmpty()) {
         return null;
      } else {
         int var2 = iIIIIIIIi_Class258.I_method_dc7f39fc((String)var1.getFirst());
         if (var2 != -1 && var1.size() > 1) {
            String var3 = String.join(" ", var1.subList(1, var1.size())).trim();
            if (!var3.isEmpty()) {
               return new IIiiIIII_Class49.Nested1_7f65b0d3(var3, var2);
            }
         }

         int var5 = iIIIIIIIi_Class258.I_method_dc7f39fc((String)var1.getLast());
         if (var5 != -1 && var1.size() > 1) {
            String var4 = String.join(" ", var1.subList(0, var1.size() - 1)).trim();
            if (!var4.isEmpty()) {
               return new IIiiIIII_Class49.Nested1_7f65b0d3(var4, var5);
            }
         }

         return null;
      }
   }

   static final class Nested1_7f65b0d3 {
      private final String I_field_523beb0a;
      private final int I_field_49;

      Nested1_7f65b0d3(String var1, int var2) {
         this.I_field_523beb0a = var1;
         this.I_field_49 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_7f65b0d3[command=" + this.I_field_523beb0a + ", keyCode=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiIIII_Class49.Nested1_7f65b0d3 other = (IIiiIIII_Class49.Nested1_7f65b0d3) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public String I_method_2d579cb9() {
         return this.I_field_523beb0a;
      }

      public int I_method_1760deba() {
         return this.I_field_49;
      }
   }
}
