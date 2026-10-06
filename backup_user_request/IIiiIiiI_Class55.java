package rockstar.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.ClickEvent.Action;
import net.minecraft.util.Formatting;
import ua.mintantileak.spk.Compile;

public final class IIiiIiiI_Class55 {
   @Compile
   public IIIiiIIi_Class26 I_method_2ff75bab() {
      List var1 = RockstarClient.getInstance().I_method_a90eb842().i_method_619cb248().stream().map(IIiiIIiii_Class104::I_method_332d5061).toList();
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "script",
            var2 -> var2.I_method_b3f941e4("py", "python")
               .i_method_cfe1a061("commands.lua.description")
               .i_method_3d6e11d9(
                  "action",
                  var0 -> var0.I_method_2619a44a(
                        var0x -> IIiiIiiI_Class55.Nested1_81372cd3.I_method_d65f8654(var0x)
                            .map(var1x -> (IIiIIIIi_Class34)IIiIIIIi_Class34.I_method_12fc454a(var1x))
                           .orElseGet(() -> IIiIIIIi_Class34.I_method_c9d442bc(IiIiIIII_Class81.I_method_f25a980a("commands.config.invalid_action")))
                     )
                     .I_method_b539159d(IIiiIiiI_Class55.Nested1_81372cd3.I_method_5a2c28a0())
               )
               .i_method_3d6e11d9("id", var1xx -> var1xx.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a).I_method_b539159d(var1))
               .I_method_16f05c8a(this::I_method_80f73f4d)
         )
         .I_method_9111538b();
   }

   @Compile
   private void I_method_80f73f4d(IIIiiIii_Class28 var1) {
      IIiiIiiI_Class55.Nested1_81372cd3 var2 = (IIiiIiiI_Class55.Nested1_81372cd3)var1.I_method_557e5bfb().get(0);
      String var3 = (String)var1.I_method_557e5bfb().get(1);
      var2.I_method_650fc8eb().accept(var3);
   }

   static enum Nested1_81372cd3 {
      I_field_23bc9dfc("save", "\u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c", "\u044b\u0444\u043c\u0443"),
      i_field_23bc9dfc("create", "add"),
      II_field_23bc9dfc("remove", "delete", "del", "\u0443\u0434\u0430\u043b\u0438\u0442\u044c", "\u0432\u0443\u0434\u0443\u0435\u0443"),
      Ii_field_23bc9dfc("list", "\u0434\u0448\u044b\u0435"),
      iI_field_23bc9dfc("load", "use", "enable", "\u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c", "true", "\u0434\u0449\u0444\u0432"),
      ii_field_23bc9dfc("unload", "disable", "off", "false"),
      III_field_23bc9dfc("reload", "update"),
      IIi_field_23bc9dfc("toggle"),
      IiI_field_23bc9dfc("install", "pip", "i"),
      Iii_field_23bc9dfc("dir", "direction");

      private final List<String> I_field_7865b31;

      private Nested1_81372cd3(String... var3) {
         this.I_field_7865b31 = Arrays.stream(var3).map(String::toLowerCase).toList();
      }

      @Compile
      Consumer<String> I_method_650fc8eb() {
         return switch (this) {
            case I_field_23bc9dfc -> this::I_method_669f88d1;
            case i_field_23bc9dfc -> this::i_method_3756dcb1;
            case II_field_23bc9dfc -> this::Ii_method_955c40a4;
            case Ii_field_23bc9dfc -> var1 -> this.I_method_291ce2c7();
            case iI_field_23bc9dfc -> this::iI_method_ad814e4;
            case ii_field_23bc9dfc -> this::ii_method_db8f68c4;
            case III_field_23bc9dfc -> var1 -> this.i_method_292b6ea7();
            case IIi_field_23bc9dfc -> this::II_method_c4a4ecc4;
            case IiI_field_23bc9dfc -> this::III_method_274c0731;
            case Iii_field_23bc9dfc -> var0 -> {
               try {
                  File var1 = new File(IiIIiIII_Class73.I_field_3a58077, "scripts");
                  String[] var2 = new String[]{"explorer", var1.getAbsolutePath()};
                  Runtime.getRuntime().exec(var2);
               } catch (Exception var3) {
                  RockstarClient.I_field_ab0f6068.error(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.dir.error", var3.getMessage()));
               }
            };
         };
      }

      @Compile
      private void I_method_669f88d1(String var1) {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.lua.save.edit_directly")));
      }

      @Compile
      private void i_method_3756dcb1(String var1) {
         if (var1 != null) {
            IIiiIIiiI_Class103 var2 = RockstarClient.getInstance().I_method_a90eb842();
            Optional var3 = var2.i_method_619cb248().stream().filter(var1x -> var1x.I_method_332d5061().equals(var1)).findFirst();
            if (var3.isPresent()) {
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.create.exists", var1)));
            } else {
               IIiiIIiii_Class104 var4 = new IIiiIIiii_Class104(var1);
               if (var4.I_method_c8d5294e().exists()) {
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.create.exists", var1)));
                  return;
               }

               var2.i_method_619cb248().add(var4.i_method_35e0d6d5());
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.create.success", var1)));
            }
         }
      }

      private void I_method_291ce2c7() {
         IIiiIIiiI_Class103 var1 = RockstarClient.getInstance().I_method_a90eb842();
         if (var1.i_method_619cb248().isEmpty()) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.lua.not_found_list")));
         } else {
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.lua.list")));
            int var2 = 1;

            for (IIiiIIiii_Class104 var4 : var1.i_method_619cb248()) {
               String var5 = var4.I_method_332d5061();
               String var6 = ".py toggle \"" + var5.replace("\"", "\\\"") + "\"";
               MutableText var7 = Text.literal("[" + var2++ + "] ")
                  .setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY)))
                  .append(Text.literal(var5).setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.WHITE))));
               if (var4.II_method_b18bf526()) {
                  var7.append(
                     Text.literal(" " + IiIiIIII_Class81.I_method_f25a980a("status.enabled"))
                        .setStyle(
                           Style.EMPTY
                              .withColor(TextColor.fromFormatting(Formatting.GREEN))
                              .withClickEvent(new ClickEvent(Action.RUN_COMMAND, var6))
                              .withHoverEvent(
                                 new HoverEvent(
                                    net.minecraft.text.HoverEvent.Action.SHOW_TEXT, Text.literal(IiIiIIII_Class81.I_method_f25a980a("python.hover_disable"))
                                 )
                              )
                        )
                  );
               } else {
                  var7.append(
                     Text.literal(" " + IiIiIIII_Class81.I_method_f25a980a("status.disabled"))
                        .setStyle(
                           Style.EMPTY
                              .withColor(TextColor.fromFormatting(Formatting.RED))
                              .withClickEvent(new ClickEvent(Action.RUN_COMMAND, var6))
                              .withHoverEvent(
                                 new HoverEvent(
                                    net.minecraft.text.HoverEvent.Action.SHOW_TEXT, Text.literal(IiIiIIII_Class81.I_method_f25a980a("python.hover_enable"))
                                 )
                              )
                        )
                  );
               }

               iIIIIIIii_Class260.Ii_method_12f9d884(var7);
            }
         }
      }

      @Compile
      private void II_method_c4a4ecc4(String var1) {
         if (var1 != null) {
            IIiiIIiiI_Class103 var2 = RockstarClient.getInstance().I_method_a90eb842();
            Optional var3 = var2.i_method_619cb248().stream().filter(var1x -> var1x.I_method_332d5061().equals(var1)).findFirst();
            if (var3.isPresent()) {
               var2.I_method_8a6291ab(var1, !((IIiiIIiii_Class104)var3.get()).II_method_b18bf526());
               this.I_method_291ce2c7();
            } else {
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.not_found", var1)));
            }
         }
      }

      @Compile
      private void Ii_method_955c40a4(String var1) {
         if (var1 != null) {
            IIiiIIiiI_Class103 var2 = RockstarClient.getInstance().I_method_a90eb842();
            Optional var3 = var2.i_method_619cb248().stream().filter(var1x -> var1x.I_method_332d5061().equals(var1)).findFirst();
            if (var3.isPresent()) {
               if (((IIiiIIiii_Class104)var3.get()).i_method_e0a5203()) {
                  var2.I_method_8a6291ab(var1, false);
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.delete.success", var1)));
               } else {
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.delete.error", var1)));
               }
            } else {
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.not_found", var1)));
            }
         }
      }

      @Compile
      private void iI_method_ad814e4(String var1) {
         if (var1 != null) {
            IIiiIIiiI_Class103 var2 = RockstarClient.getInstance().I_method_a90eb842();
            Optional var3 = var2.i_method_619cb248().stream().filter(var1x -> var1x.I_method_332d5061().equals(var1)).findFirst();
            if (var3.isPresent()) {
               var2.I_method_8a6291ab(var1, true);
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.load.success", var1)));
            } else {
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.not_found", var1)));
            }
         }
      }

      @Compile
      private void ii_method_db8f68c4(String var1) {
         if (var1 != null) {
            IIiiIIiiI_Class103 var2 = RockstarClient.getInstance().I_method_a90eb842();
            Optional var3 = var2.i_method_619cb248().stream().filter(var1x -> var1x.I_method_332d5061().equals(var1)).findFirst();
            if (var3.isPresent()) {
               if (((IIiiIIiii_Class104)var3.get()).II_method_b18bf526()) {
                  var2.I_method_8a6291ab(var1, false);
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.unload.success", var1)));
               } else {
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.unload.not_loaded", var1)));
               }
            } else {
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.lua.not_found", var1)));
            }
         }
      }

      @Compile
      private void i_method_292b6ea7() {
         IIiiIIiiI_Class103 var1 = RockstarClient.getInstance().I_method_a90eb842();
         var1.II_method_14c48d02();
      }

      @Compile
      private void III_method_274c0731(String var1) {
         if (var1 == null) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("python.pip.usage")));
         } else {
            File var2 = new File(IIiiIiIIi_Class106.I_method_1233012e(), "python.exe");
            if (!var2.exists()) {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("python.runtime_missing")));
            } else {
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("python.pip.installing", var1)));
               Thread var3 = new Thread(
                  () -> {
                     String var2x = "";
                     int var3x = -1;

                     try {
                        Process var4 = new ProcessBuilder(var2.getAbsolutePath(), "-m", "pip", "install", var1, "--no-warn-script-location")
                           .redirectErrorStream(true)
                           .start();

                        String var6;
                        try (BufferedReader var5 = new BufferedReader(new InputStreamReader(var4.getInputStream(), StandardCharsets.UTF_8))) {
                           while ((var6 = var5.readLine()) != null) {
                              RockstarClient.I_field_ab0f6068.info("[pip] {}", var6);
                              if (var6.startsWith("Successfully installed") || var6.startsWith("ERROR")) {
                                 var2x = var6;
                              }
                           }
                        }

                        var3x = var4.waitFor();
                     } catch (Exception var10) {
                        var2x = var10.getMessage() != null ? var10.getMessage() : var10.getClass().getSimpleName();
                     }

                     int var11 = var3x;
                     String var12 = var2x;
                     iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> {
                        if (var11 == 0) {
                           iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("python.pip.done", var1)));
                        } else {
                           iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_1410d1e5("python.pip.fail", var1, var12)));
                        }
                     });
                  },
                  "pip-install-" + var1
               );
               var3.setDaemon(true);
               var3.start();
            }
         }
      }

      @Compile
      static Optional<IIiiIiiI_Class55.Nested1_81372cd3> I_method_d65f8654(String var0) {
         String var1 = var0.toLowerCase();
         return Arrays.stream(values()).filter(var1x -> var1x.I_field_7865b31.contains(var1)).findFirst();
      }

      @Compile
      static List<String> I_method_5a2c28a0() {
         return Arrays.stream(values()).map(var0 -> var0.I_field_7865b31.getFirst()).toList();
      }
   }
}
