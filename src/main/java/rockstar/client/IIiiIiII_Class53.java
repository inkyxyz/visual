package rockstar.client;

import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import net.minecraft.network.packet.c2s.play.RequestCommandCompletionsC2SPacket;
import net.minecraft.network.packet.s2c.play.CommandSuggestionsS2CPacket;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import pyrock.events.network.ReceivePacketEvent;
import ua.mintantileak.spk.Compile;

public class IIiiIiII_Class53 implements iIIiIIiIi_Class294 {
   private final Pattern I_field_5fd3861f = Pattern.compile("[A-Z0-9]\\w+");
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private boolean I_field_5a;
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_5a) {
         if (this.I_field_991c1e8c.I_method_58432069(10000L)) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.plugins.error")));
            this.I_field_5a = false;
         } else {
            if (var1.getPacket() instanceof CommandSuggestionsS2CPacket var2) {
               Suggestions var5 = var2.getSuggestions();
               this.I_field_5a = false;
               if (var5.getList().isEmpty()) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.plugins.empty")));
                  return;
               }

               Set var4 = this.I_method_c2713667(var5);
               if (var4.isEmpty()) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.plugins.client_error")));
                  return;
               }

               iIIIIIIii_Class260.I_method_468cf607(
                  Text.of(
                     IiIiIIII_Class81.I_method_f25a980a("commands.plugins.counts")
                        + " "
                        + var4.size()
                        + " "
                        + IiIiIIII_Class81.I_method_f25a980a("commands.plugins.find")
                  )
               );
               iIIIIIIii_Class260.I_method_468cf607(Text.of(String.join(", ", var4)));
            }
         }
      }
   };

   public IIiiIiII_Class53() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public IIIiiIIi_Class26 I_method_29ef5fcb() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "plugins",
            var1 -> var1.I_method_b3f941e4("plugin", "pl")
               .i_method_cfe1a061("commands.plugins.description")
               .i_method_3d6e11d9("command", IIIiiiii_Class32::I_method_e930dfcb)
               .I_method_16f05c8a(this::I_method_c5ffbf2d)
         )
         .I_method_9111538b();
   }

   @Compile
   private void I_method_c5ffbf2d(IIIiiIii_Class28 var1) {
      String var2 = "";
      if (!var1.I_method_557e5bfb().isEmpty()) {
         var2 = (String)var1.I_method_557e5bfb().getFirst();
      }

      String var3 = "/";
      if (var2 != null && !var2.isEmpty()) {
         var3 = var3 + var2;
      }

      this.I_field_991c1e8c.I_method_23e11e3f();
      this.I_field_5a = true;
      I_field_3a9bda27.getNetworkHandler().sendPacket(new RequestCommandCompletionsC2SPacket(0, var3));
   }

   @NotNull
   private Set<String> I_method_c2713667(Suggestions var1) {
      HashSet var2 = new HashSet();

      for (Suggestion var4 : var1.getList()) {
         String var5 = var4.getText();
         if (var5.contains(":")) {
            String[] var6 = var5.split(":");
            String var7 = var6[0].replaceAll("\\s*", "").replace("/", "");
            if (!var7.isEmpty() && !var7.equals("minecraft")) {
               var2.add(var7);
            }
         } else if (var5.matches(this.I_field_5fd3861f.pattern()) && !var5.startsWith("/")) {
            var2.add(var5);
         }
      }

      return var2;
   }
}
