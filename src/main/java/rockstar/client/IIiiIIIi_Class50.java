package rockstar.client;

import java.util.Locale;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.ClickEvent.Action;
import net.minecraft.util.Formatting;
import ua.mintantileak.spk.Compile;

public final class IIiiIIIi_Class50 {
   @Compile
   public IIIiiIIi_Class26 I_method_c10e7cb() {
      return IIIiiIiI_Class27.I_method_fa8865f9("mcp", var1 -> var1.i_method_cfe1a061("commands.mcp.description").i_method_3d6e11d9("action", var0 -> {
         var0.I_method_e930dfcb();
         var0.I_method_a44fe164("status", "url", "token", "restart", "stop", "start");
         var0.I_method_f005ecf3("status", "url", "token", "restart", "stop", "start");
      }).I_method_16f05c8a(this::I_method_280f372d)).I_method_9111538b();
   }

   @Compile
   private void I_method_280f372d(IIIiiIii_Class28 var1) {
      String var2 = !var1.I_method_557e5bfb().isEmpty() && var1.I_method_557e5bfb().getFirst() != null
         ? String.valueOf(var1.I_method_557e5bfb().getFirst()).toLowerCase(Locale.ROOT)
         : "status";
      IiIiiIII_Class89 var3 = IiIiiIII_Class89.I_method_fc295fcb();
      switch (var2) {
         case "stop":
            var3.II_method_75379835();
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.mcp.stopped")));
            break;
         case "start":
         case "restart":
            try {
               var3.Ii_method_75462415();
               this.I_method_af6bdf0d(var3);
            } catch (Exception var7) {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.mcp.error", String.valueOf(var7.getMessage()))));
            }
            break;
         case "token":
            String var6 = var3.II_method_59592d0b();
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.mcp.token_rotated")));
            this.I_method_605023c0(IiIiIIII_Class81.I_method_f25a980a("commands.mcp.token"), var6);
            break;
         case "url":
            this.I_method_605023c0(IiIiIIII_Class81.I_method_f25a980a("commands.mcp.url"), var3.i_method_f8ed1d94());
            break;
         default:
            this.I_method_af6bdf0d(var3);
      }
   }

   private void I_method_af6bdf0d(IiIiiIII_Class89 var1) {
      if (!var1.I_method_3d95f4b0()) {
         iIIIIIIii_Class260.i_method_70898627(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.mcp.offline")));
      } else {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.mcp.online", var1.I_method_3d95f49f())));
         this.I_method_605023c0(IiIiIIII_Class81.I_method_f25a980a("commands.mcp.url"), var1.i_method_f8ed1d94());
         this.I_method_605023c0(IiIiIIII_Class81.I_method_f25a980a("commands.mcp.token"), var1.I_method_65ce6d74());
         iIIIIIIii_Class260.I_method_468cf607(
            Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.mcp.file", IiIiiIII_Class89.I_method_84ddc7e1().getAbsolutePath()))
         );
      }
   }

   private void I_method_605023c0(String var1, String var2) {
      iIIIIIIii_Class260.Ii_method_12f9d884(
         Text.literal(var1 + ": ")
            .setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY)))
            .append(
               Text.literal(var2)
                  .setStyle(
                     Style.EMPTY
                        .withColor(TextColor.fromFormatting(Formatting.AQUA))
                        .withClickEvent(new ClickEvent(Action.COPY_TO_CLIPBOARD, var2))
                        .withHoverEvent(
                           new HoverEvent(net.minecraft.text.HoverEvent.Action.SHOW_TEXT, Text.literal(IiIiIIII_Class81.I_method_f25a980a("commands.mcp.copy")))
                        )
                  )
            )
      );
   }
}
