package rockstar.client;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.text.Text;

public class IIiiIIiI_Class51 implements iIIiIIiIi_Class294 {
   private static final int I_field_49 = 2;
   private static volatile boolean I_field_5a;

   public IIIiiIIi_Class26 I_method_74ffdb8b() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "neuro",
            var1 -> var1.I_method_b3f941e4("nr", "neurorotation")
               .i_method_cfe1a061("commands.neuro.description")
               .i_method_3d6e11d9(
                  "action",
                  var0 -> var0.I_method_e930dfcb()
                     .I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a)
                     .I_method_f005ecf3("record", "stop", "data", "train", "load", "list", "dir", "why")
               )
               .i_method_3d6e11d9("name", var0 -> var0.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a))
               .i_method_3d6e11d9(
                  "epochs", var0 -> var0.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a).I_method_f005ecf3("auto", "400", "800")
               )
               .I_method_16f05c8a(this::I_method_dcfebb6d)
         )
         .I_method_9111538b();
   }

   private void I_method_dcfebb6d(IIIiiIii_Class28 var1) {
      String var2 = (String)var1.I_method_557e5bfb().get(0);
      String var3 = (String)var1.I_method_557e5bfb().get(1);
      String var4 = (String)var1.I_method_557e5bfb().get(2);
      String var5 = var2 == null ? "status" : var2.toLowerCase(Locale.ROOT);
      switch (var5) {
         case "status":
            this.I_method_f83128ec();
            break;
         case "list":
            this.i_method_f83fb4cc();
            break;
         case "load":
            this.I_method_690e6fb6(var3);
            break;
         case "dir":
            this.II_method_e02ebf5();
            break;
         case "train":
            this.I_method_1bd75800(var3, var4);
            break;
         case "record":
         case "rec":
            this.i_method_39c5c396(var3);
            break;
         case "stop":
            this.iI_method_fc5dc15();
            break;
         case "data":
            this.ii_method_fd467f5();
            break;
         case "why":
            this.Ii_method_e1177d5();
            break;
         default:
            iI_method_56460a9f(
               "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .neuro <list|load|dir|train|record|stop|data|why> [\u0438\u043c\u044f] [\u044d\u043f\u043e\u0445\u0438|auto]"
            );
      }
   }

   private void I_method_f83128ec() {
      iiiIiiII_Class237 var1 = iiiIiiII_Class237.I_method_7d0c47cb();
      Ii_method_e0ca365f(
         "\u041c\u043e\u0434\u0435\u043b\u044c \u00a7b"
            + iiiIiiII_Class237.I_method_f16c5534()
            + "\u00a7r \u2014 "
            + (
               var1 == null
                  ? "\u00a7c\u043d\u0435 \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u043b\u0430\u0441\u044c\u00a7r"
                  : "\u0433\u043e\u0442\u043e\u0432\u0430"
            )
            + ", \u0432\u0441\u0435\u0433\u043e "
            + iiiIiiII_Class237.I_method_313f47db().size()
            + "."
      );
      int var2 = iiiIiIiI_Class235.i_method_be34ecff();
      iiiIiIiI_Class235 var3 = this.I_method_5fe0200b();
      String var4 = iiiIiIiI_Class235.i_method_9933ca09(var2);
      Ii_method_e0ca365f(
         "\u0417\u0430\u043f\u0438\u0441\u0430\u043d\u043e: \u00a7b"
            + iiiIiIiI_Class235.I_method_c87c7629(var2)
            + "\u00a7r \u0431\u043e\u044f ("
            + iiiIiIiI_Class235.II_method_4016a072(var2)
            + ")"
            + (
               var3 != null && var3.I_method_be266130()
                  ? " \u00a7c\u25cf \u043f\u0438\u0448\u0435\u0442\u0441\u044f " + var3.i_method_7eb34114() + "\u00a7r"
                  : ""
            )
      );
      if (var4 != null) {
         Ii_method_e0ca365f(
            "\u00a77\u0414\u043e \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u0445\u0432\u0430\u0442\u0430\u0435\u0442 \u0435\u0449\u0451 "
               + var4
               + " \u0437\u0430\u043f\u0438\u0441\u0438.\u00a7r"
         );
      }

      Ii_method_e0ca365f("\u0422\u0440\u0435\u043d\u0435\u0440: " + this.I_method_9afa4134());
   }

   private String I_method_9afa4134() {
      if (iiiIiIii_Class236.I_method_a38de381() == null) {
         return "\u00a77\u043d\u0435\u0442 \u043f\u0438\u0442\u043e\u043d-\u0440\u0430\u043d\u0442\u0430\u0439\u043c\u0430\u00a7r";
      } else if (iiiIiIii_Class236.i_method_f4d000f0()) {
         return "\u0433\u043e\u0442\u043e\u0432";
      } else {
         String var1 = iiiIiIii_Class236.II_method_a37c23d9() ? "torch" : "numpy \u0438 torch";
         if (iiiIiIii_Class236.I_method_f4c17510()) {
            return "\u00a7e\u043a\u0430\u0447\u0430\u0435\u0442\u0441\u044f " + var1 + " (~200 \u041c\u0411, \u0440\u0430\u0437\u043e\u0432\u043e)\u00a7r";
         } else {
            String var2 = iiiIiIii_Class236.I_method_31c7b914();
            return "\u00a7c\u043d\u0435\u0442 " + var1 + (var2 == null ? "" : ": " + var2) + "\u00a7r";
         }
      }
   }

   private void i_method_f83fb4cc() {
      List var1 = iiiIiiII_Class237.I_method_313f47db();
      Ii_method_e0ca365f("\u041c\u043e\u0434\u0435\u043b\u0435\u0439: \u00a7b" + var1.size() + "\u00a7r");

      for (String var3 : (Iterable<String>)(Iterable<?>)var1) {
         boolean var4 = var3.equals(iiiIiiII_Class237.I_method_f16c5534());
         boolean var5 = !Files.isRegularFile(iiiIiiII_Class237.I_method_9c2e0d7f(var3));
         Ii_method_e0ca365f(
            (var4 ? "\u00a7b > " : "\u00a77 \u00b7 ")
               + var3
               + (var5 ? " \u00a78(\u0432\u0441\u0442\u0440\u043e\u0435\u043d\u043d\u0430\u044f)" : "")
               + (var4 ? " \u00a78\u0430\u043a\u0442\u0438\u0432\u043d\u0430" : "")
               + "\u00a7r"
         );
      }
   }

   private void I_method_690e6fb6(String var1) {
      if (I_method_690e6fba(var1)) {
         iI_method_56460a9f("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .neuro load <\u0438\u043c\u044f>");
      } else if (!iiiIiiII_Class237.I_method_e0dedbba(var1)) {
         iI_method_56460a9f("\u041c\u043e\u0434\u0435\u043b\u0438 " + var1 + " \u043d\u0435\u0442. \u0421\u043f\u0438\u0441\u043e\u043a: .neuro list");
      } else {
         iiiIiiII_Class237.i_method_b1962f9a(var1);
         Ii_method_e0ca365f(
            iiiIiiII_Class237.I_method_7d0c47cb() == null
               ? "\u00a7c\u041c\u043e\u0434\u0435\u043b\u044c "
                  + var1
                  + " \u0432\u044b\u0431\u0440\u0430\u043d\u0430, \u043d\u043e \u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f\u00a7r"
               : "\u041c\u043e\u0434\u0435\u043b\u044c \u00a7b" + var1 + "\u00a7r \u0437\u0430\u0433\u0440\u0443\u0436\u0435\u043d\u0430."
         );
      }
   }

   private void II_method_e02ebf5() {
      Path var1 = iiiIiiII_Class237.I_method_db76ec89();

      try {
         Files.createDirectories(var1);
      } catch (Exception var3) {
      }

      if (I_field_3a9bda27.keyboard != null) {
         I_field_3a9bda27.keyboard.setClipboard(var1.toString());
      }

      if (this.I_method_2c74cc8f(var1)) {
         Ii_method_e0ca365f("\u041f\u0430\u043f\u043a\u0430 \u043c\u043e\u0434\u0435\u043b\u0435\u0439 \u043e\u0442\u043a\u0440\u044b\u0442\u0430: " + var1);
      } else {
         Ii_method_e0ca365f(
            "\u041f\u0430\u043f\u043a\u0430 \u043c\u043e\u0434\u0435\u043b\u0435\u0439: "
               + var1
               + " \u00a78(\u043f\u0443\u0442\u044c \u0432 \u0431\u0443\u0444\u0435\u0440\u0435)\u00a7r"
         );
      }
   }

   private boolean I_method_2c74cc8f(Path var1) {
      try {
         if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.OPEN)) {
            Desktop.getDesktop().open(var1.toFile());
            return true;
         }
      } catch (Exception var4) {
      }

      try {
         new ProcessBuilder("explorer.exe", var1.toString()).start();
         return true;
      } catch (Exception var3) {
         return false;
      }
   }

   private void i_method_39c5c396(String var1) {
      iiiIiIiI_Class235 var2 = this.I_method_5fe0200b();
      if (var2 == null) {
         iI_method_56460a9f("\u041c\u043e\u0434\u0443\u043b\u044c Aura \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d");
      } else if (var2.I_method_be266130()) {
         iI_method_56460a9f(
            "\u0423\u0436\u0435 \u043f\u0438\u0448\u0435\u0442\u0441\u044f "
               + var2.i_method_7eb34114()
               + ". \u041e\u0441\u0442\u0430\u043d\u043e\u0432\u0438: .neuro stop"
         );
      } else if (I_method_690e6fba(var1)) {
         iI_method_56460a9f("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .neuro record <\u0438\u043c\u044f>");
      } else {
         String var3 = var1.replaceAll("[^\\p{L}\\p{N}_.-]", "");
         if (var3.isEmpty()) {
            iI_method_56460a9f("\u041f\u043b\u043e\u0445\u043e\u0435 \u0438\u043c\u044f \u0434\u0430\u0442\u0430\u0441\u0435\u0442\u0430.");
         } else {
            int var4 = iiiIiIiI_Class235.I_method_2bbe17e9(var3);
            String var5 = var2.I_method_50bc076a(var3);
            if (var5 != null) {
               iI_method_56460a9f(var5);
            } else {
               Ii_method_e0ca365f(
                  "\u041f\u0438\u0448\u0443 \u00a7b"
                     + var3
                     + "\u00a7r"
                     + (
                        var4 > 0
                           ? " (\u0434\u043e\u0437\u0430\u043f\u0438\u0441\u044c, \u0442\u0430\u043c \u0443\u0436\u0435 "
                              + iiiIiIiI_Class235.I_method_c87c7629(var4)
                              + ")"
                           : ""
                     )
                     + ". \u0411\u0435\u0439 \u0440\u0443\u043a\u0430\u043c\u0438, \u0430\u0443\u0440\u0443 \u0438 \u0430\u0438\u043c-\u0430\u0441\u0441\u0438\u0441\u0442 \u0432\u044b\u043a\u043b\u044e\u0447\u0438. \u0421\u0442\u043e\u043f \u2014 .neuro stop"
               );
               String var6 = iiiIiIiI_Class235.i_method_9933ca09(iiiIiIiI_Class235.i_method_be34ecff());
               if (var6 != null) {
                  Ii_method_e0ca365f(
                     "\u00a77\u0414\u043e \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u044f \u043d\u0443\u0436\u043d\u043e \u0435\u0449\u0451 "
                        + var6
                        + " \u0431\u043e\u044f.\u00a7r"
                  );
               }
            }
         }
      }
   }

   private void Ii_method_e1177d5() {
      AuraModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
      if (var1 == null) {
         iI_method_56460a9f("\u041c\u043e\u0434\u0443\u043b\u044c Aura \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d");
      } else {
         Map var2 = var1.i_method_b59e69a1();
         if (var2.isEmpty()) {
            Ii_method_e0ca365f(
               "\u041f\u043e\u043a\u0430 \u043d\u0435\u0447\u0435\u0433\u043e \u043f\u043e\u043a\u0430\u0437\u0430\u0442\u044c \u2014 \u043f\u043e\u0434\u0435\u0440\u0438\u0441\u044c \u043d\u0435\u043c\u043d\u043e\u0433\u043e \u0441 \u0432\u043a\u043b\u044e\u0447\u0451\u043d\u043d\u043e\u0439 \u0430\u0443\u0440\u043e\u0439."
            );
         } else {
            Ii_method_e0ca365f(
               "\u00a7b\u041f\u043e\u0447\u0435\u043c\u0443 \u0443\u0434\u0430\u0440\u044b \u043d\u0435 \u043f\u0440\u043e\u0445\u043e\u0434\u044f\u0442\u00a7r (\u0441 \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0435\u0433\u043e \u0441\u0431\u0440\u043e\u0441\u0430):"
            );
            var2.entrySet()
               .stream()
               .sorted((var0, var1x) -> (Integer)((java.util.Map.Entry)var1x).getValue() - (Integer)((java.util.Map.Entry)var0).getValue())
               .limit(8L)
               .forEach(var0 -> Ii_method_e0ca365f("  " + (String)((java.util.Map.Entry)var0).getKey() + ": " + ((java.util.Map.Entry)var0).getValue()));
            var2.clear();
            Ii_method_e0ca365f("\u00a77\u0441\u0447\u0451\u0442\u0447\u0438\u043a\u0438 \u0441\u0431\u0440\u043e\u0448\u0435\u043d\u044b\u00a7r");
         }
      }
   }

   private void iI_method_fc5dc15() {
      iiiIiIiI_Class235 var1 = this.I_method_5fe0200b();
      Ii_method_e0ca365f(
         var1 == null ? "\u041c\u043e\u0434\u0443\u043b\u044c Aura \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d" : var1.I_method_eb9490f4()
      );
   }

   private void ii_method_fd467f5() {
      List var1 = iiiIiIiI_Class235.I_method_bbc3739b();
      if (var1.isEmpty()) {
         Ii_method_e0ca365f(
            "\u0414\u0430\u0442\u0430\u0441\u0435\u0442\u043e\u0432 \u043d\u0435\u0442. \u0417\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u2014 .neuro record <\u0438\u043c\u044f>"
         );
      } else {
         int var2 = iiiIiIiI_Class235.i_method_be34ecff();
         Ii_method_e0ca365f(
            "\u0414\u0430\u0442\u0430\u0441\u0435\u0442\u043e\u0432 \u00a7b"
               + var1.size()
               + "\u00a7r, \u0432\u0441\u0435\u0433\u043e \u00a7b"
               + iiiIiIiI_Class235.I_method_c87c7629(var2)
               + "\u00a7r \u0431\u043e\u044f ("
               + iiiIiIiI_Class235.II_method_4016a072(var2)
               + ")"
         );

         for (String var4 : (Iterable<String>)(Iterable<?>)var1) {
            Ii_method_e0ca365f("\u00a78 \u00b7 \u00a77" + var4 + "\u00a7r");
         }

         int var5 = iiiIiIiI_Class235.I_method_be26611f();
         if (var5 > 0) {
            Ii_method_e0ca365f(
               "\u00a77\u0411\u0438\u0442\u044b\u0435 \u0441\u0442\u0440\u043e\u043a\u0438 (\u0441\u043b\u0435\u0434\u044b \u0432\u044b\u043b\u0435\u0442\u043e\u0432 \u0432\u043e \u0432\u0440\u0435\u043c\u044f \u0437\u0430\u043f\u0438\u0441\u0438) \u0442\u0440\u0435\u043d\u0435\u0440 \u043f\u0440\u043e\u043f\u0443\u0441\u043a\u0430\u0435\u0442 \u0441\u0430\u043c.\u00a7r"
            );
         }

         String var6 = iiiIiIiI_Class235.i_method_9933ca09(var2);
         if (var6 != null) {
            Ii_method_e0ca365f(
               "\u00a77\u0414\u043e \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u0445\u0432\u0430\u0442\u0430\u0435\u0442 \u0435\u0449\u0451 "
                  + var6
                  + " \u0437\u0430\u043f\u0438\u0441\u0438.\u00a7r"
            );
         }
      }
   }

   private void I_method_1bd75800(String var1, String var2) {
      if (I_field_5a) {
         iI_method_56460a9f("\u041e\u0431\u0443\u0447\u0435\u043d\u0438\u0435 \u0443\u0436\u0435 \u0438\u0434\u0451\u0442.");
      } else {
         String var3 = I_method_690e6fba(var1) ? iiiIiiII_Class237.I_method_f16c5534() : var1;
         String var4 = var2 == null ? null : (var2.equalsIgnoreCase("auto") ? "0" : (var2.matches("\\d+") ? var2 : null));
         if (var2 != null && var4 == null) {
            iI_method_56460a9f("\u042d\u043f\u043e\u0445\u0438 \u2014 \u0447\u0438\u0441\u043b\u043e \u0438\u043b\u0438 auto.");
         } else {
            File var5 = iiiIiIii_Class236.I_method_a38de381();
            if (var5 == null) {
               iI_method_56460a9f(
                  "\u041f\u0438\u0442\u043e\u043d-\u0440\u0430\u043d\u0442\u0430\u0439\u043c \u0435\u0449\u0451 \u043d\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u2014 \u043e\u0431\u0443\u0447\u0430\u0442\u044c \u043d\u0435\u0447\u0435\u043c."
               );
               Ii_method_e0ca365f(
                  "\u00a77\u041e\u043d \u043a\u0430\u0447\u0430\u0435\u0442\u0441\u044f \u043f\u0440\u0438 \u0437\u0430\u043f\u0443\u0441\u043a\u0435 \u0432\u043c\u0435\u0441\u0442\u0435 \u0441\u043e \u0441\u043a\u0440\u0438\u043f\u0442\u0430\u043c\u0438; \u0437\u0430\u0439\u0434\u0438 \u043f\u043e\u0437\u0436\u0435.\u00a7r"
               );
            } else if (!iiiIiIii_Class236.i_method_f4d000f0()) {
               if (iiiIiIii_Class236.I_method_f4c17510()) {
                  iI_method_56460a9f(
                     "\u0415\u0449\u0451 \u043a\u0430\u0447\u0430\u044e\u0442\u0441\u044f numpy \u0438 torch \u0434\u043b\u044f \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u044f (~200 \u041c\u0411, \u0440\u0430\u0437\u043e\u0432\u043e). \u041f\u043e\u043f\u0440\u043e\u0431\u0443\u0439 \u0447\u0435\u0440\u0435\u0437 \u043f\u0430\u0440\u0443 \u043c\u0438\u043d\u0443\u0442."
                  );
               } else {
                  iI_method_56460a9f(
                     "\u0414\u043b\u044f \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u044f \u043d\u0443\u0436\u043d\u044b numpy \u0438 torch, \u0430 \u043e\u043d\u0438 \u043d\u0435 \u043f\u043e\u0441\u0442\u0430\u0432\u0438\u043b\u0438\u0441\u044c"
                        + (iiiIiIii_Class236.I_method_31c7b914() == null ? "" : ": " + iiiIiIii_Class236.I_method_31c7b914())
                  );
                  Ii_method_e0ca365f(
                     "\u00a77\u041f\u0435\u0440\u0435\u0437\u0430\u0439\u0434\u0438 \u0432 \u0438\u0433\u0440\u0443 \u2014 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0441\u0442\u0430\u0440\u0442\u0443\u0435\u0442 \u0441\u0430\u043c\u0430, \u043b\u043e\u0433 \u0432 latest.log.\u00a7r"
                  );
               }
            } else {
               int var6 = iiiIiIiI_Class235.i_method_be34ecff();
               String var7 = iiiIiIiI_Class235.i_method_9933ca09(var6);
               if (var7 != null) {
                  iI_method_56460a9f(
                     "\u041c\u0430\u043b\u043e \u0437\u0430\u043f\u0438\u0441\u0438: "
                        + iiiIiIiI_Class235.I_method_c87c7629(var6)
                        + " \u0431\u043e\u044f, \u043d\u0443\u0436\u043d\u043e \u0445\u043e\u0442\u044f \u0431\u044b "
                        + iiiIiIiI_Class235.I_method_c87c7629(12000)
                        + "."
                  );
                  Ii_method_e0ca365f("\u00a77\u0417\u0430\u043f\u0438\u0448\u0438 \u0435\u0449\u0451 " + var7 + ": .neuro record <\u0438\u043c\u044f>\u00a7r");
               } else {
                  I_field_5a = true;
                  Ii_method_e0ca365f(
                     "\u041e\u0431\u0443\u0447\u0435\u043d\u0438\u0435 \u043c\u043e\u0434\u0435\u043b\u0438 \u00a7b"
                        + var3
                        + "\u00a7r \u043f\u043e\u0448\u043b\u043e ("
                        + (
                           "0".equals(var4)
                              ? "\u0430\u0432\u0442\u043e, \u043f\u043e\u043a\u0430 \u043f\u0430\u0434\u0430\u0435\u0442 val"
                              : (var4 == null ? "400" : var4) + " \u044d\u043f\u043e\u0445"
                        )
                        + "). \u0418\u0433\u0440\u0430 \u043d\u0435 \u0437\u0430\u043c\u0440\u0451\u0442, \u043f\u0440\u043e\u0433\u0440\u0435\u0441\u0441 \u0431\u0443\u0434\u0435\u0442 \u0442\u0443\u0442."
                  );
                  Thread var8 = new Thread(
                     () -> this.I_method_5f49dcb5(var5, iiiIiiII_Class237.i_method_21aa14a9(), iiiIiiII_Class237.I_method_9c2e0d7f(var3), var3, var4),
                     "neuro-train"
                  );
                  var8.setDaemon(true);
                  var8.start();
               }
            }
         }
      }
   }

   private void I_method_5f49dcb5(File var1, Path var2, Path var3, String var4, String var5) {
      try {
         Files.createDirectories(var3.getParent());
         Process var6 = iiiIiIii_Class236.I_method_621cbf21(var1, var2, var3, var5);
         BufferedReader var7 = new BufferedReader(new InputStreamReader(var6.getInputStream(), StandardCharsets.UTF_8));

         String var8;
         try {
            while ((var8 = var7.readLine()) != null) {
               String var9 = var8.strip();
               if (!var9.isEmpty()) {
                  if (var9.startsWith("!! ")) {
                     this.II_method_1012e27f("\u00a7c" + var9.substring(3) + "\u00a7r");
                  } else if (var9.startsWith("! ")) {
                     this.II_method_1012e27f("\u00a7e" + var9.substring(2) + "\u00a7r");
                  } else {
                     this.II_method_1012e27f("\u00a77" + var9 + "\u00a7r");
                  }
               }
            }
         } catch (Throwable var16) {
            try {
               var7.close();
            } catch (Throwable var15) {
               var16.addSuppressed(var15);
            }

            throw var16;
         }

         var7.close();
         int var19 = var6.waitFor();
         if (var19 == 2) {
            return;
         }

         if (var19 == 0) {
            this.II_method_1012e27f("\u00a7a\u0413\u043e\u0442\u043e\u0432\u043e. \u0412\u043a\u043b\u044e\u0447\u0430\u044e " + var4 + ".\u00a7r");
            I_field_3a9bda27.execute(() -> iiiIiiII_Class237.i_method_b1962f9a(var4));
            return;
         }

         this.II_method_1012e27f("\u00a7c\u0422\u0440\u0435\u043d\u0435\u0440 \u0443\u043f\u0430\u043b, \u043a\u043e\u0434 " + var19 + ".\u00a7r");
      } catch (Exception var17) {
         this.II_method_1012e27f(
            "\u00a7c\u041e\u0431\u0443\u0447\u0435\u043d\u0438\u0435 \u0441\u043e\u0440\u0432\u0430\u043b\u043e\u0441\u044c: " + var17.getMessage() + "\u00a7r"
         );
         return;
      } finally {
         I_field_5a = false;
      }
   }

   private void II_method_1012e27f(String var1) {
      I_field_3a9bda27.execute(() -> Ii_method_e0ca365f(var1));
   }

   private iiiIiIiI_Class235 I_method_5fe0200b() {
      iiiIIiii_Class232 var1 = this.I_method_5e2bbfab();
      return var1 == null ? null : var1.I_method_7c26b42b();
   }

   private iiiIIiii_Class232 I_method_5e2bbfab() {
      AuraModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
      return var1 == null ? null : var1.I_method_ca3c40b();
   }

   private static boolean I_method_690e6fba(String var0) {
      return var0 == null || var0.isBlank();
   }

   private static void Ii_method_e0ca365f(String var0) {
      iIIIIIIii_Class260.I_method_468cf607(Text.of(var0));
   }

   private static void iI_method_56460a9f(String var0) {
      iIIIIIIii_Class260.II_method_e8fd4864(Text.of(var0));
   }
}
