package rockstar.client;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import ua.mintantileak.spk.Compile;

public class IIiIIiii_Class40 implements iIIiIIiIi_Class294 {
   private final Map<String, IIIiIIII_Class17> I_field_a567c40b = new ConcurrentHashMap<>();
   private final AtomicReference<Thread> I_field_c74d0693 = new AtomicReference<>();
   private final AtomicBoolean I_field_1232aa16 = new AtomicBoolean(false);

   public IIIiiIIi_Class26 I_method_f1f86bab() {
      return IIIiiIiI_Class27.I_method_209cd841("bot")
         .I_method_b3f941e4("bots")
         .i_method_cfe1a061("commands.bot.description")
         .i_method_3d6e11d9(
            "action",
            var0 -> {
               var0.I_method_a44fe164(
                  "help",
                  "join",
                  "connect",
                  "connectwithport",
                  "connectfast",
                  "start",
                  "stop",
                  "leave",
                  "clear",
                  "stopall",
                  "list",
                  "jump",
                  "sneak",
                  "attack",
                  "use",
                  "drop",
                  "slot",
                  "goto",
                  "follow",
                  "idle",
                  "patrol",
                  "tp",
                  "info",
                  "chat",
                  "say",
                  "cmd",
                  "password",
                  "pay",
                  "antiafk",
                  "rejoin",
                  "control",
                  "return",
                  "tapemouse",
                  "rebreak",
                  "instantrebreak",
                  "rebreakrejoin",
                  "mining",
                  "autojoingrief",
                  "proxy"
               );
               var0.I_method_f005ecf3(
                  "help",
                  "join",
                  "connect",
                  "connectwithport",
                  "connectfast",
                  "start",
                  "stop",
                  "clear",
                  "list",
                  "jump",
                  "sneak",
                  "attack",
                  "use",
                  "drop",
                  "slot",
                  "goto",
                  "follow",
                  "idle",
                  "patrol",
                  "tp",
                  "info",
                  "chat",
                  "cmd",
                  "password",
                  "pay",
                  "antiafk",
                  "rejoin",
                  "control",
                  "return",
                  "tapemouse",
                  "rebreak",
                  "instantrebreak",
                  "rebreakrejoin",
                  "mining",
                  "autojoingrief",
                  "proxy"
               );
            }
         )
         .i_method_3d6e11d9("args", var0 -> var0.I_method_e930dfcb().i_method_132d6feb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a))
         .I_method_16f05c8a(this::I_method_ff182f4d)
         .I_method_9111538b();
   }

   @Compile
   private void I_method_ff182f4d(IIIiiIii_Class28 var1) {
      String var2 = ((String)var1.I_method_557e5bfb().get(0)).toLowerCase(Locale.ROOT);
      List var3 = this.I_method_cf097f5a(var1);
      IIIIIIIi_Class2 var4 = IIIIIIIi_Class2.I_method_70b3dfcb();
      switch (var2) {
         case "help":
            this.i_method_a1d240ac();
            break;
         case "join":
            this.I_method_935cce1e(var4, var3);
            break;
         case "connect":
            this.I_method_1e2729bd(var3);
            break;
         case "connectwithport":
            this.i_method_1261f59d(var3);
            break;
         case "connectfast":
            this.Ii_method_2ca26ae6(var3);
            break;
         case "start":
            this.II_method_38679f06(var3);
            break;
         case "leave":
         case "stop":
            this.I_method_abc1ec68(var4, var3, var2);
            break;
         case "stopall":
         case "clear":
            this.I_method_64683b2d(var4);
            break;
         case "list":
            this.i_method_79fdaf0d(var4);
            break;
         case "jump":
            this.II_method_a9916936(var4);
            break;
         case "sneak":
            this.Ii_method_bf26dd16(var4);
            break;
         case "attack":
            this.i_method_c24e81fe(var4, var3);
            break;
         case "use":
            this.iI_method_46aa7156(var4);
            break;
         case "drop":
            this.ii_method_5c3fe536(var4);
            break;
         case "slot":
            this.II_method_c262ca27(var4, var3);
            break;
         case "goto":
            this.Ii_method_f1547e07(var4, var3);
            break;
         case "follow":
            this.iI_method_71a79247(var4, var3);
            break;
         case "idle":
            this.ii_method_a0994627(var4, var3);
            break;
         case "patrol":
            this.iiI_method_5cb5533e(var4, var3);
            break;
         case "tp":
            this.III_method_98dfc4d(var4);
            break;
         case "info":
            this.iii_method_8ba7071e(var4, var3);
            break;
         case "say":
         case "chat":
            this.IIII_method_f9936d07(var4, var3);
            break;
         case "cmd":
            this.IIIi_method_288520e7(var4, var3);
            break;
         case "password":
            this.IIiI_method_a8d83527(var4, var3);
            break;
         case "pay":
            this.IIii_method_d7c9e907(var4, var3);
            break;
         case "antiafk":
            this.IiII_method_32e7a8e7(var4, var3);
            break;
         case "rejoin":
            this.IiIi_method_61d95cc7(var4, var3);
            break;
         case "control":
            this.IiiI_method_e22c7107(var4, var3);
            break;
         case "return":
            this.IIi_method_1f23702d(var4);
            break;
         case "mining":
            this.III_method_741c4f3e(var4, var3);
            break;
         case "tapemouse":
            this.IIi_method_a30e031e(var4, var3);
            break;
         case "rebreak":
            this.IiI_method_2361175e(var4, var3);
            break;
         case "instantrebreak":
            this.Iii_method_5252cb3e(var4, var3);
            break;
         case "rebreakrejoin":
            this.iII_method_ad708b1e(var4, var3);
            break;
         case "autojoingrief":
            this.iIi_method_dc623efe(var4, var3);
            break;
         case "proxy":
            this.i_method_db011776(
               "\u042d\u0442\u0430 reborn-\u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u0437\u0430\u0432\u044f\u0437\u0430\u043d\u0430 \u043d\u0430 BotWorld/BotPlayer \u0438\u0437 \u0441\u0442\u0430\u0440\u043e\u0433\u043e \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u0438 \u0432 1.21.4 headless-\u043f\u043e\u0440\u0442\u0435 \u043f\u043e\u043a\u0430 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u043d\u0430"
            );
            break;
         default:
            this.i_method_db011776(IiIiIIII_Class81.I_method_f25a980a("commands.bot.unknown_action"));
      }
   }

   private List<String> I_method_cf097f5a(IIIiiIii_Class28 var1) {
      if (var1.I_method_557e5bfb().size() >= 2 && var1.I_method_557e5bfb().get(1) != null) {
         Object var2 = var1.I_method_557e5bfb().get(1);
         if (var2 instanceof List var3) {
            ArrayList var4 = new ArrayList();

            for (Object var6 : var3) {
               if (var6 != null) {
                  var4.add(String.valueOf(var6));
               }
            }

            return var4;
         } else {
            return List.of(String.valueOf(var2));
         }
      } else {
         return List.of();
      }
   }

   private void I_method_935cce1e(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(IiIiIIII_Class81.I_method_f25a980a("commands.bot.nickname_required"));
      } else {
         iiiiiii_Class128 var3;
         if (var2.size() >= 2) {
            var3 = IIIIIiII_Class5.I_method_5014d936((String)var2.get(0), (String)var2.get(1));
         } else {
            var3 = var1.I_method_cb3796ec((String)var2.get(0));
         }

         if (var3 == null) {
            this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.already_exists", var2.get(0)));
         } else {
            this.I_method_a49c396(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.joining", var2.get(0)));
         }
      }
   }

   private void I_method_1e2729bd(List<String> var1) {
      if (var1.size() < 2) {
         this.i_method_db011776("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot connect <\u043d\u0438\u043a> <ip[:port]>");
      } else {
         iiiiiii_Class128 var2 = IIIIIiII_Class5.I_method_5014d936((String)var1.get(0), (String)var1.get(1));
         if (var2 == null) {
            this.i_method_db011776(
               "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0431\u043e\u0442\u0430 "
                  + (String)var1.get(0)
            );
         } else {
            this.I_method_a49c396(
               "\u0411\u043e\u0442 "
                  + (String)var1.get(0)
                  + " \u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0430\u0435\u0442\u0441\u044f \u043a "
                  + (String)var1.get(1)
            );
         }
      }
   }

   private void i_method_1261f59d(List<String> var1) {
      if (var1.size() < 3) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot connectwithport <\u043d\u0438\u043a> <ip> <\u043f\u043e\u0440\u0442>"
         );
      } else {
         Integer var2 = this.I_method_4955e93d((String)var1.get(2));
         if (var2 != null && var2 >= 1 && var2 <= 65535) {
            iiiiiii_Class128 var3 = IIIIIiII_Class5.I_method_50214bb9((String)var1.get(0), (String)var1.get(1), var2);
            if (var3 == null) {
               this.i_method_db011776(
                  "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0431\u043e\u0442\u0430 "
                     + (String)var1.get(0)
               );
            } else {
               this.I_method_a49c396(
                  "\u0411\u043e\u0442 "
                     + (String)var1.get(0)
                     + " \u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0430\u0435\u0442\u0441\u044f \u043a "
                     + (String)var1.get(1)
                     + ":"
                     + var2
               );
            }
         } else {
            this.i_method_db011776("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u043f\u043e\u0440\u0442: " + (String)var1.get(2));
         }
      }
   }

   private void II_method_38679f06(List<String> var1) {
      if (var1.isEmpty()) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot start <\u043a\u043e\u043b-\u0432\u043e> <ip[:port]> \u0438\u043b\u0438 .bot start stop|pause|unpause"
         );
      } else {
         String var2 = ((String)var1.get(0)).toLowerCase(Locale.ROOT);
         switch (var2) {
            case "stop":
               IIIIIiII_Class5.I_method_31cae0ac();
               this.I_method_a49c396(
                  "\u041e\u0447\u0435\u0440\u0435\u0434\u044c \u0437\u0430\u043f\u0443\u0441\u043a\u0430 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u0430"
               );
               break;
            case "pause":
               this.I_method_a49c396(
                  IIIIIiII_Class5.I_method_31cae0b0()
                     ? "\u041e\u0447\u0435\u0440\u0435\u0434\u044c \u0437\u0430\u043f\u0443\u0441\u043a\u0430 \u043f\u043e\u0441\u0442\u0430\u0432\u043b\u0435\u043d\u0430 \u043d\u0430 \u043f\u0430\u0443\u0437\u0443"
                     : "\u041e\u0447\u0435\u0440\u0435\u0434\u044c \u0443\u0436\u0435 \u043d\u0430 \u043f\u0430\u0443\u0437\u0435"
               );
               break;
            case "unpause":
               this.I_method_a49c396(
                  IIIIIiII_Class5.i_method_31d96c90()
                     ? "\u041e\u0447\u0435\u0440\u0435\u0434\u044c \u0437\u0430\u043f\u0443\u0441\u043a\u0430 \u0432\u043e\u0437\u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0430"
                     : "\u041e\u0447\u0435\u0440\u0435\u0434\u044c \u043d\u0435 \u0431\u044b\u043b\u0430 \u043d\u0430 \u043f\u0430\u0443\u0437\u0435"
               );
               break;
            default:
               if (var1.size() < 2) {
                  this.i_method_db011776(
                     "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot start <\u043a\u043e\u043b-\u0432\u043e> <ip[:port]>"
                  );
                  return;
               }

               Integer var4 = this.I_method_4955e93d((String)var1.get(0));
               if (var4 == null || var4 < 1) {
                  this.i_method_db011776(
                     "\u041d\u0435\u0432\u0435\u0440\u043d\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0431\u043e\u0442\u043e\u0432"
                  );
                  return;
               }

               IIIIIiII_Class5.I_method_7f329e1(var4, (String)var1.get(1));
               this.I_method_a49c396(
                  "\u0417\u0430\u043f\u0443\u0441\u043a\u0430\u044e " + var4 + " \u0431\u043e\u0442\u043e\u0432 \u043d\u0430 " + (String)var1.get(1)
               );
         }
      }
   }

   private void Ii_method_2ca26ae6(List<String> var1) {
      if (var1.size() == 1 && ((String)var1.get(0)).equalsIgnoreCase("stop")) {
         this.I_method_a1c3b4cc();
      } else if (var1.size() < 3) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot connectfast <\u0444\u0430\u0439\u043b> <ip[:port]> <\u0438\u043d\u0442\u0435\u0440\u0432\u0430\u043b_\u0441\u0435\u043a>"
         );
      } else if (this.I_field_c74d0693.get() != null && this.I_field_c74d0693.get().isAlive()) {
         this.i_method_db011776(
            "\u041c\u0430\u0441\u0441\u043e\u0432\u044b\u0439 \u0437\u0430\u043f\u0443\u0441\u043a \u0443\u0436\u0435 \u0430\u043a\u0442\u0438\u0432\u0435\u043d. \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 .bot connectfast stop"
         );
      } else {
         Path var2 = Path.of((String)var1.get(0));
         Integer var3 = this.I_method_4955e93d((String)var1.get(2));
         if (var3 != null && var3 >= 1) {
            List var4;
            try {
               var4 = Files.readAllLines(var2, StandardCharsets.UTF_8)
                  .stream()
                  .map(String::trim)
                  .filter(var0 -> !var0.isEmpty() && !var0.startsWith("#"))
                  .toList();
            } catch (Exception var6) {
               this.i_method_db011776(
                  "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c \u0444\u0430\u0439\u043b: "
                     + var6.getMessage()
               );
               return;
            }

            if (var4.isEmpty()) {
               this.i_method_db011776(
                  "\u0424\u0430\u0439\u043b \u043d\u0435 \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u0442 \u043d\u0438\u043a\u0438 \u0431\u043e\u0442\u043e\u0432"
               );
            } else {
               this.I_field_1232aa16.set(false);
               Thread var5 = new Thread(() -> this.I_method_8e29fd9c(var4, (String)var1.get(1), var3), "Rockstar-BotConnectFast");
               var5.setDaemon(true);
               this.I_field_c74d0693.set(var5);
               var5.start();
               this.I_method_a49c396(
                  "\u0417\u0430\u043f\u0443\u0441\u043a "
                     + var4.size()
                     + " \u0431\u043e\u0442\u043e\u0432 \u0441 \u0438\u043d\u0442\u0435\u0440\u0432\u0430\u043b\u043e\u043c "
                     + var3
                     + " \u0441\u0435\u043a"
               );
            }
         } else {
            this.i_method_db011776("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0438\u043d\u0442\u0435\u0440\u0432\u0430\u043b");
         }
      }
   }

   private void I_method_8e29fd9c(List<String> var1, String var2, int var3) {
      int var4 = 0;

      try {
         for (String var6 : var1) {
            if (this.I_field_1232aa16.get()) {
               this.I_method_a49c396(
                  "\u041c\u0430\u0441\u0441\u043e\u0432\u044b\u0439 \u0437\u0430\u043f\u0443\u0441\u043a \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d. \u0417\u0430\u043f\u0443\u0449\u0435\u043d\u043e: "
                     + var4
               );
               return;
            }

            IIIIIiII_Class5.I_method_5014d936(var6, var2);
            this.I_method_a49c396("\u0417\u0430\u043f\u0443\u0449\u0435\u043d \u0431\u043e\u0442 " + var6 + " (" + ++var4 + "/" + var1.size() + ")");
            Thread.sleep(var3 * 1000L);
         }

         this.I_method_a49c396(
            "\u0412\u0441\u0435 \u0431\u043e\u0442\u044b \u0438\u0437 \u0444\u0430\u0439\u043b\u0430 \u0437\u0430\u043f\u0443\u0449\u0435\u043d\u044b: " + var4
         );
      } catch (InterruptedException var10) {
         Thread.currentThread().interrupt();
         this.I_method_a49c396(
            "\u041c\u0430\u0441\u0441\u043e\u0432\u044b\u0439 \u0437\u0430\u043f\u0443\u0441\u043a \u043f\u0440\u0435\u0440\u0432\u0430\u043d. \u0417\u0430\u043f\u0443\u0449\u0435\u043d\u043e: "
               + var4
         );
      } finally {
         this.I_field_c74d0693.set(null);
         this.I_field_1232aa16.set(false);
      }
   }

   private void I_method_a1c3b4cc() {
      Thread var1 = this.I_field_c74d0693.get();
      if (var1 != null && var1.isAlive()) {
         this.I_field_1232aa16.set(true);
         var1.interrupt();
         this.I_method_a49c396(
            "\u041e\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u043c\u0430\u0441\u0441\u043e\u0432\u043e\u0433\u043e \u0437\u0430\u043f\u0443\u0441\u043a\u0430..."
         );
      } else {
         this.i_method_db011776(
            "\u041c\u0430\u0441\u0441\u043e\u0432\u044b\u0439 \u0437\u0430\u043f\u0443\u0441\u043a \u043d\u0435 \u0430\u043a\u0442\u0438\u0432\u0435\u043d"
         );
      }
   }

   private void I_method_abc1ec68(IIIIIIIi_Class2 var1, List<String> var2, String var3) {
      if (var2.isEmpty()) {
         var1.i_method_470b35e8(iiiiiii_Class128::IiI_method_c7667cff);
         this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.action.stop"));
      } else {
         String var4 = (String)var2.get(0);
         Optional var5 = var1.I_method_ad974b8f(var4);
         if (var5.isEmpty()) {
            this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var4));
         } else {
            var1.I_method_1f192f76(var4);
            this.I_method_a49c396(
               var3.equals("stop")
                  ? "\u0411\u043e\u0442 " + var4 + " \u0431\u044b\u043b \u043e\u0442\u043a\u043b\u044e\u0447\u0435\u043d"
                  : IiIiIIII_Class81.I_method_1410d1e5("commands.bot.left", var4)
            );
         }
      }
   }

   private void I_method_64683b2d(IIIIIIIi_Class2 var1) {
      int var2 = var1.I_method_6c40589f();
      var1.I_method_6c4058ac();
      this.I_method_a49c396(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.cleared", var2));
   }

   private void i_method_79fdaf0d(IIIIIIIi_Class2 var1) {
      Collection var2 = var1.I_method_350a479b();
      if (var2.isEmpty()) {
         this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.no_bots"));
      } else {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.list_header", var2.size())));

         for (iiiiiii_Class128 var4 : (Iterable<iiiiiii_Class128>)(Iterable<?>)var2) {
            String var5 = var4.Ii_method_16f24ea6()
               ? "\u00a7a" + IiIiIIII_Class81.I_method_f25a980a("commands.bot.status.connected")
               : "\u00a7c" + var4.I_method_8e45dd15().name();
            String var6 = var4.I_method_e2514398() == null ? "Idle" : var4.I_method_e2514398().I_method_dcc0dd54();
            String var7 = var1.Ii_method_ec176ea3(var4.I_method_7b75de01()) ? " \u00a7a[TapeMouse]" : "";
            iIIIIIIii_Class260.I_method_468cf607(Text.of("\u00a77- \u00a7f" + var4.I_method_7b75de01() + " \u00a77[" + var5 + "\u00a77] \u00a78" + var6 + var7));
         }
      }
   }

   private void II_method_a9916936(IIIIIIIi_Class2 var1) {
      var1.i_method_470b35e8(iiiiiii_Class128::II_method_16e3c2c2);
      this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.action.jump"));
   }

   private void Ii_method_bf26dd16(IIIIIIIi_Class2 var1) {
      var1.i_method_470b35e8(iiiiiii_Class128::iI_method_18a6b2e2);
      this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.action.sneak"));
   }

   private void i_method_c24e81fe(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         var1.i_method_470b35e8(iiiiiii_Class128::ii_method_18b53ec2);
         this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.action.attack"));
      } else {
         String var3 = (String)var2.get(0);
         if (var3.equalsIgnoreCase("stopall")) {
            var1.i_method_470b35e8(var0 -> var0.I_method_b8ab1d60(new IIIIiiIi_Class14()));
            this.I_method_a49c396(
               "\u0410\u0442\u0430\u043a\u0430 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u0430 \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else if (var3.equalsIgnoreCase("stop") && var2.size() >= 2) {
            var1.I_method_ad974b8f((String)var2.get(1)).ifPresent(var0 -> var0.I_method_b8ab1d60(new IIIIiiIi_Class14()));
            this.I_method_a49c396(
               "\u0410\u0442\u0430\u043a\u0430 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u0430 \u0443 " + (String)var2.get(1)
            );
         } else if (var2.size() < 2) {
            this.i_method_db011776(
               "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot attack <\u0431\u043e\u0442|all|stop|stopall> <\u0446\u0435\u043b\u044c>"
            );
         } else {
            String var4 = (String)var2.get(1);
            if (var3.equalsIgnoreCase("all")) {
               var1.i_method_470b35e8(var1x -> var1x.I_method_b8ab1d60(new IIIIIiiI_Class7(var4, var1x.I_method_e08ecf78().IIi_method_e80835ba())));
               this.I_method_a49c396("\u0412\u0441\u0435 \u0431\u043e\u0442\u044b \u0430\u0442\u0430\u043a\u0443\u044e\u0442 " + var4);
            } else {
               Optional var5 = var1.I_method_ad974b8f(var3);
               if (var5.isEmpty()) {
                  this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
               } else {
                  ((iiiiiii_Class128)var5.get())
                     .I_method_b8ab1d60(new IIIIIiiI_Class7(var4, ((iiiiiii_Class128)var5.get()).I_method_e08ecf78().IIi_method_e80835ba()));
                  this.I_method_a49c396("\u0411\u043e\u0442 " + var3 + " \u0430\u0442\u0430\u043a\u0443\u0435\u0442 " + var4);
               }
            }
         }
      }
   }

   private void iI_method_46aa7156(IIIIIIIi_Class2 var1) {
      var1.i_method_470b35e8(iiiiiii_Class128::III_method_c5a38cdf);
      this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.action.use"));
   }

   private void ii_method_5c3fe536(IIIIIIIi_Class2 var1) {
      var1.i_method_470b35e8(var0 -> var0.II_method_c5954852(false));
      this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.action.drop"));
   }

   private void II_method_c262ca27(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(IiIiIIII_Class81.I_method_f25a980a("commands.bot.slot_required"));
      } else {
         Integer var3 = this.I_method_4955e93d((String)var2.get(0));
         if (var3 != null && var3 >= 0 && var3 <= 8) {
            var1.i_method_470b35e8(var1x -> var1x.i_method_18982e84(var3));
            this.I_method_a49c396(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.action.slot", var3));
         } else {
            this.i_method_db011776(IiIiIIII_Class81.I_method_f25a980a("commands.bot.invalid_slot"));
         }
      }
   }

   private void Ii_method_f1547e07(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.size() == 3) {
         this.I_method_b1d5b94b(var1, (String)var2.get(0), (String)var2.get(1), (String)var2.get(2));
      } else if (var2.size() < 4) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot goto <\u0431\u043e\u0442|all> <x> <y> <z>"
         );
      } else {
         String var3 = (String)var2.get(0);
         Integer var4 = this.I_method_4955e93d((String)var2.get(1));
         Integer var5 = this.I_method_4955e93d((String)var2.get(2));
         Integer var6 = this.I_method_4955e93d((String)var2.get(3));
         if (var4 == null || var5 == null || var6 == null) {
            this.i_method_db011776(IiIiIIII_Class81.I_method_f25a980a("commands.bot.invalid_coords"));
         } else if (var3.equalsIgnoreCase("all")) {
            var1.i_method_470b35e8(var3x -> var3x.I_method_b8ab1d60(new IIIIiiII_Class13(var4.intValue(), var5.intValue(), var6.intValue())));
            this.I_method_a49c396(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.action.goto", var4, var5, var6));
         } else {
            Optional var7 = var1.I_method_ad974b8f(var3);
            if (var7.isEmpty()) {
               this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
            } else {
               ((iiiiiii_Class128)var7.get()).I_method_b8ab1d60(new IIIIiiII_Class13(var4.intValue(), var5.intValue(), var6.intValue()));
               this.I_method_a49c396("\u0411\u043e\u0442 " + var3 + " \u0438\u0434\u0451\u0442 \u043a " + var4 + ", " + var5 + ", " + var6);
            }
         }
      }
   }

   private void I_method_b1d5b94b(IIIIIIIi_Class2 var1, String var2, String var3, String var4) {
      Integer var5 = this.I_method_4955e93d(var2);
      Integer var6 = this.I_method_4955e93d(var3);
      Integer var7 = this.I_method_4955e93d(var4);
      if (var5 != null && var6 != null && var7 != null) {
         var1.i_method_470b35e8(var3x -> var3x.I_method_b8ab1d60(new IIIIiiII_Class13(var5.intValue(), var6.intValue(), var7.intValue())));
         this.I_method_a49c396(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.action.goto", var5, var6, var7));
      } else {
         this.i_method_db011776(IiIiIIII_Class81.I_method_f25a980a("commands.bot.invalid_coords"));
      }
   }

   private void iI_method_71a79247(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         if (I_field_3a9bda27.player != null) {
            var1.i_method_470b35e8(var0 -> var0.I_method_b8ab1d60(new IIIIiIii_Class12(I_field_3a9bda27.player, var0.I_method_e08ecf78().I_method_907c0ba())));
            this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.action.follow"));
         }
      } else {
         String var3 = (String)var2.get(0);
         if (var3.equalsIgnoreCase("stopall")) {
            var1.i_method_470b35e8(var0 -> var0.I_method_b8ab1d60(new IIIIiiIi_Class14()));
            this.I_method_a49c396(
               "\u0421\u043b\u0435\u0434\u043e\u0432\u0430\u043d\u0438\u0435 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else if (var3.equalsIgnoreCase("stop") && var2.size() >= 2) {
            var1.I_method_ad974b8f((String)var2.get(1)).ifPresent(var0 -> var0.I_method_b8ab1d60(new IIIIiiIi_Class14()));
            this.I_method_a49c396(
               "\u0421\u043b\u0435\u0434\u043e\u0432\u0430\u043d\u0438\u0435 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e \u0443 "
                  + (String)var2.get(1)
            );
         } else if (var2.size() < 2) {
            this.i_method_db011776(
               "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot follow <\u0431\u043e\u0442|all|stop|stopall> <\u0446\u0435\u043b\u044c>"
            );
         } else {
            String var4 = (String)var2.get(1);
            if (var3.equalsIgnoreCase("all")) {
               var1.i_method_470b35e8(var1x -> var1x.I_method_b8ab1d60(new IIIIiIii_Class12(var4, var1x.I_method_e08ecf78().I_method_907c0ba())));
               this.I_method_a49c396("\u0412\u0441\u0435 \u0431\u043e\u0442\u044b \u0441\u043b\u0435\u0434\u0443\u044e\u0442 \u0437\u0430 " + var4);
            } else {
               Optional var5 = var1.I_method_ad974b8f(var3);
               if (var5.isEmpty()) {
                  this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
               } else {
                  ((iiiiiii_Class128)var5.get())
                     .I_method_b8ab1d60(new IIIIiIii_Class12(var4, ((iiiiiii_Class128)var5.get()).I_method_e08ecf78().I_method_907c0ba()));
                  this.I_method_a49c396("\u0411\u043e\u0442 " + var3 + " \u0441\u043b\u0435\u0434\u0443\u0435\u0442 \u0437\u0430 " + var4);
               }
            }
         }
      }
   }

   private void ii_method_a0994627(IIIIIIIi_Class2 var1, List<String> var2) {
      if (!var2.isEmpty() && !((String)var2.get(0)).equalsIgnoreCase("all")) {
         Optional var3 = var1.I_method_ad974b8f((String)var2.get(0));
         if (var3.isEmpty()) {
            this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var2.get(0)));
         } else {
            ((iiiiiii_Class128)var3.get()).I_method_b8ab1d60(new IIIIiiIi_Class14());
            this.I_method_a49c396("\u0411\u043e\u0442 " + (String)var2.get(0) + " \u043f\u0435\u0440\u0435\u0432\u0435\u0434\u0451\u043d \u0432 idle");
         }
      } else {
         var1.i_method_470b35e8(var0 -> var0.I_method_b8ab1d60(new IIIIiiIi_Class14()));
         this.I_method_a49c396("\u0412\u0441\u0435 \u0431\u043e\u0442\u044b \u043f\u0435\u0440\u0435\u0432\u0435\u0434\u0435\u043d\u044b \u0432 idle");
      }
   }

   private void III_method_741c4f3e(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot mining <\u0431\u043e\u0442|all|stop|stopall> <minecraft:block>"
         );
      } else {
         String var3 = (String)var2.get(0);
         if (var3.equalsIgnoreCase("stopall")) {
            var1.i_method_470b35e8(var0 -> var0.I_method_b8ab1d60(new IIIIiiIi_Class14()));
            this.I_method_a49c396(
               "Mining \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else if (var3.equalsIgnoreCase("stop") && var2.size() >= 2) {
            var1.I_method_ad974b8f((String)var2.get(1)).ifPresent(var0 -> var0.I_method_b8ab1d60(new IIIIiiIi_Class14()));
            this.I_method_a49c396("Mining \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 " + (String)var2.get(1));
         } else if (var2.size() < 2) {
            this.i_method_db011776(
               "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot mining <\u0431\u043e\u0442|all|stop|stopall> <minecraft:block>"
            );
         } else {
            Block var4 = this.I_method_3e134b90((String)var2.get(1));
            if (var4 == null || var4 == Blocks.AIR) {
               this.i_method_db011776("\u0411\u043b\u043e\u043a " + (String)var2.get(1) + " \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d");
            } else if (var3.equalsIgnoreCase("all")) {
               var1.i_method_470b35e8(var2x -> var2x.I_method_b8ab1d60(this.I_method_6e056219(var4)));
               this.I_method_a49c396(
                  "\u0412\u0441\u0435 \u0431\u043e\u0442\u044b \u0434\u043e\u0431\u044b\u0432\u0430\u044e\u0442 " + Registries.BLOCK.getId(var4)
               );
            } else {
               Optional var5 = var1.I_method_ad974b8f(var3);
               if (var5.isEmpty()) {
                  this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
               } else {
                  ((iiiiiii_Class128)var5.get()).I_method_b8ab1d60(this.I_method_6e056219(var4));
                  this.I_method_a49c396("\u0411\u043e\u0442 " + var3 + " \u0434\u043e\u0431\u044b\u0432\u0430\u0435\u0442 " + Registries.BLOCK.getId(var4));
               }
            }
         }
      }
   }

   private IIIIiiii_Class16 I_method_6e056219(Block var1) {
      IIIIiiii_Class16 var2 = new IIIIiiii_Class16();
      var2.I_method_ba4b5abe(var1);
      return var2;
   }

   private Block I_method_3e134b90(String var1) {
      String var2 = var1 == null ? "" : var1.trim().toLowerCase(Locale.ROOT);
      if (var2.isBlank()) {
         return null;
      } else {
         if (!var2.contains(":")) {
            var2 = "minecraft:" + var2;
         }

         Identifier var3 = Identifier.tryParse(var2);
         return var3 != null && Registries.BLOCK.containsId(var3) ? (Block)Registries.BLOCK.get(var3) : null;
      }
   }

   private void IIi_method_a30e031e(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.size() < 2) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot tapemouse add|remove <\u0431\u043e\u0442>"
         );
      } else {
         String var3 = ((String)var2.get(0)).toLowerCase(Locale.ROOT);
         String var4 = (String)var2.get(1);
         switch (var3) {
            case "add":
               if (var1.i_method_efd0835a(var4)) {
                  this.I_method_a49c396("\u0411\u043e\u0442 " + var4 + " \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d \u0432 TapeMouse");
               } else {
                  this.i_method_db011776(
                     "\u0411\u043e\u0442 "
                        + var4
                        + " \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d, \u043d\u0435 \u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d \u0438\u043b\u0438 \u0443\u0436\u0435 \u0432 TapeMouse"
                  );
               }
               break;
            case "remove":
               if (var1.II_method_1b601ac3(var4)) {
                  this.I_method_a49c396("\u0411\u043e\u0442 " + var4 + " \u0443\u0434\u0430\u043b\u0451\u043d \u0438\u0437 TapeMouse");
               } else {
                  this.i_method_db011776("\u0411\u043e\u0442 " + var4 + " \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d \u0432 TapeMouse");
               }
               break;
            default:
               this.i_method_db011776(
                  "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot tapemouse add|remove <\u0431\u043e\u0442>"
               );
         }
      }
   }

   private void IiI_method_2361175e(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot rebreak <\u0431\u043e\u0442|all|stop|stopall>"
         );
      } else {
         String var3 = (String)var2.get(0);
         if (var3.equalsIgnoreCase("stopall")) {
            var1.i_method_470b35e8(var1x -> {
               if (this.I_method_17de777e(var1x)) {
                  var1x.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            });
            this.I_method_a49c396(
               "Rebreak \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else if (var3.equalsIgnoreCase("stop") && var2.size() >= 2) {
            var1.I_method_ad974b8f((String)var2.get(1)).ifPresent(var1x -> {
               if (this.I_method_17de777e(var1x)) {
                  var1x.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            });
            this.I_method_a49c396("Rebreak \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 " + (String)var2.get(1));
         } else if (var3.equalsIgnoreCase("all")) {
            var1.i_method_470b35e8(var0 -> var0.I_method_b8ab1d60(new IIIIiIIi_Class10()));
            this.I_method_a49c396("Rebreak \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432");
         } else {
            Optional var4 = var1.I_method_ad974b8f(var3);
            if (var4.isEmpty()) {
               this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
            } else {
               ((iiiiiii_Class128)var4.get()).I_method_b8ab1d60(new IIIIiIIi_Class10());
               this.I_method_a49c396("Rebreak \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0443 " + var3);
            }
         }
      }
   }

   private void Iii_method_5252cb3e(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot instantrebreak <\u0431\u043e\u0442|all|stop|stopall>"
         );
      } else {
         String var3 = (String)var2.get(0);
         if (var3.equalsIgnoreCase("stopall")) {
            var1.i_method_470b35e8(var0 -> {
               if (var0.I_method_e2514398() instanceof IIIIiiiI_Class15) {
                  var0.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            });
            this.I_method_a49c396(
               "InstantRebreak \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else if (var3.equalsIgnoreCase("stop") && var2.size() >= 2) {
            var1.I_method_ad974b8f((String)var2.get(1)).ifPresent(var0 -> {
               if (var0.I_method_e2514398() instanceof IIIIiiiI_Class15) {
                  var0.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            });
            this.I_method_a49c396("InstantRebreak \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 " + (String)var2.get(1));
         } else if (var3.equalsIgnoreCase("all")) {
            var1.i_method_470b35e8(var0 -> var0.I_method_b8ab1d60(new IIIIiiiI_Class15()));
            this.I_method_a49c396("InstantRebreak \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432");
         } else {
            Optional var4 = var1.I_method_ad974b8f(var3);
            if (var4.isEmpty()) {
               this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
            } else {
               ((iiiiiii_Class128)var4.get()).I_method_b8ab1d60(new IIIIiiiI_Class15());
               this.I_method_a49c396("InstantRebreak \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0443 " + var3);
            }
         }
      }
   }

   private void iII_method_ad708b1e(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot rebreakrejoin <\u0431\u043e\u0442|all|stop|stopall> <\u043d\u043e\u043c\u0435\u0440_\u0433\u0440\u0438\u0444\u0430>"
         );
      } else {
         String var3 = (String)var2.get(0);
         if (var3.equalsIgnoreCase("stopall")) {
            var1.i_method_470b35e8(var0 -> {
               if (var0.I_method_e2514398() instanceof IIIIiIiI_Class11) {
                  var0.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            });
            this.I_method_a49c396(
               "RebreakRejoin \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else if (var3.equalsIgnoreCase("stop") && var2.size() >= 2) {
            var1.I_method_ad974b8f((String)var2.get(1)).ifPresent(var0 -> {
               if (var0.I_method_e2514398() instanceof IIIIiIiI_Class11) {
                  var0.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            });
            this.I_method_a49c396("RebreakRejoin \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 " + (String)var2.get(1));
         } else if (var2.size() < 2) {
            this.i_method_db011776(
               "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot rebreakrejoin <\u0431\u043e\u0442|all|stop|stopall> <\u043d\u043e\u043c\u0435\u0440_\u0433\u0440\u0438\u0444\u0430>"
            );
         } else {
            Integer var4 = this.I_method_4955e93d((String)var2.get(1));
            if (var4 == null || var4 < 1) {
               this.i_method_db011776("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u043d\u043e\u043c\u0435\u0440 \u0433\u0440\u0438\u0444\u0430");
            } else if (var3.equalsIgnoreCase("all")) {
               var1.i_method_470b35e8(var1x -> var1x.I_method_b8ab1d60(new IIIIiIiI_Class11(var4)));
               this.I_method_a49c396(
                  "RebreakRejoin \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432, \u0433\u0440\u0438\u0444 #"
                     + var4
               );
            } else {
               Optional var5 = var1.I_method_ad974b8f(var3);
               if (var5.isEmpty()) {
                  this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
               } else {
                  ((iiiiiii_Class128)var5.get()).I_method_b8ab1d60(new IIIIiIiI_Class11(var4));
                  this.I_method_a49c396("RebreakRejoin \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0443 " + var3 + ", \u0433\u0440\u0438\u0444 #" + var4);
               }
            }
         }
      }
   }

   private boolean I_method_17de777e(iiiiiii_Class128 var1) {
      return var1 != null
         && (
            var1.I_method_e2514398() instanceof IIIIiIIi_Class10
               || var1.I_method_e2514398() instanceof IIIIiIiI_Class11
               || var1.I_method_e2514398() instanceof IIIIiiiI_Class15
         );
   }

   private void iIi_method_dc623efe(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot autojoingrief <\u0431\u043e\u0442|all|stop|stopall> <\u043d\u043e\u043c\u0435\u0440_\u0433\u0440\u0438\u0444\u0430> [\u0438\u043d\u0442\u0435\u0440\u0432\u0430\u043b_\u0441\u0435\u043a]"
         );
      } else {
         String var3 = (String)var2.get(0);
         if (var3.equalsIgnoreCase("stopall")) {
            var1.i_method_470b35e8(var0 -> {
               if (var0.I_method_e2514398() instanceof IIIIIiii_Class8) {
                  var0.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            });
            this.I_method_a49c396(
               "AutoJoinGrief \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else if (var3.equalsIgnoreCase("stop") && var2.size() >= 2) {
            var1.I_method_ad974b8f((String)var2.get(1)).ifPresent(var0 -> {
               if (var0.I_method_e2514398() instanceof IIIIIiii_Class8) {
                  var0.I_method_b8ab1d60(new IIIIiiIi_Class14());
               }
            });
            this.I_method_a49c396("AutoJoinGrief \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0443 " + (String)var2.get(1));
         } else if (var2.size() < 2) {
            this.i_method_db011776(
               "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot autojoingrief <\u0431\u043e\u0442|all|stop|stopall> <\u043d\u043e\u043c\u0435\u0440_\u0433\u0440\u0438\u0444\u0430> [\u0438\u043d\u0442\u0435\u0440\u0432\u0430\u043b_\u0441\u0435\u043a]"
            );
         } else {
            Integer var4 = this.I_method_4955e93d((String)var2.get(1));
            Integer var5 = var2.size() >= 3 ? this.I_method_4955e93d((String)var2.get(2)) : 1;
            if (var4 != null && var4 >= 1 && var5 != null && var5 >= 1) {
               if (var3.equalsIgnoreCase("all")) {
                  int var11 = 0;
                  long var7 = Math.max(250L, Math.min(2000L, var5.intValue() * 250L));

                  for (iiiiiii_Class128 var10 : var1.I_method_350a479b()) {
                     if (var10.Ii_method_16f24ea6()) {
                        var10.I_method_b8ab1d60(new IIIIIiii_Class8(var4, var5, var11 * var7));
                        var11++;
                     }
                  }

                  this.I_method_a49c396(
                     "AutoJoinGrief \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0443 "
                        + var11
                        + " \u0431\u043e\u0442\u043e\u0432, \u0433\u0440\u0438\u0444 #"
                        + var4
                  );
               } else {
                  Optional var6 = var1.I_method_ad974b8f(var3);
                  if (var6.isEmpty()) {
                     this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
                  } else {
                     ((iiiiiii_Class128)var6.get()).I_method_b8ab1d60(new IIIIIiii_Class8(var4, var5));
                     this.I_method_a49c396("AutoJoinGrief \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0443 " + var3 + ", \u0433\u0440\u0438\u0444 #" + var4);
                  }
               }
            } else {
               this.i_method_db011776(
                  "\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u043d\u043e\u043c\u0435\u0440 \u0433\u0440\u0438\u0444\u0430 \u0438\u043b\u0438 \u0438\u043d\u0442\u0435\u0440\u0432\u0430\u043b"
               );
            }
         }
      }
   }

   private void iiI_method_5cb5533e(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.size() < 2) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot patrol add|clear|start <\u0431\u043e\u0442>"
         );
      } else if (I_field_3a9bda27.player != null) {
         String var3 = ((String)var2.get(0)).toLowerCase(Locale.ROOT);
         String var4 = (String)var2.get(1);
         Optional var5 = var1.I_method_ad974b8f(var4);
         if (var5.isEmpty()) {
            this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var4));
         } else {
            IIIiIIII_Class17 var6 = this.I_field_a567c40b.computeIfAbsent(var4.toLowerCase(Locale.ROOT), var0 -> new IIIiIIII_Class17());
            switch (var3) {
               case "add":
                  var6.I_method_aed3ef5e(I_field_3a9bda27.player.getPos());
                  this.I_method_a49c396(
                     "\u0422\u043e\u0447\u043a\u0430 \u043f\u0430\u0442\u0440\u0443\u043b\u044f \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d\u0430 \u0434\u043b\u044f "
                        + var4
                  );
                  break;
               case "clear":
                  var6.I_method_bed368ac();
                  this.I_method_a49c396(
                     "\u0422\u043e\u0447\u043a\u0438 \u043f\u0430\u0442\u0440\u0443\u043b\u044f \u043e\u0447\u0438\u0449\u0435\u043d\u044b \u0434\u043b\u044f "
                        + var4
                  );
                  break;
               case "start":
                  if (var6.I_method_bed368b0()) {
                     this.i_method_db011776(
                        "\u0423 \u0431\u043e\u0442\u0430 "
                           + var4
                           + " \u043d\u0435\u0442 \u0442\u043e\u0447\u0435\u043a \u043f\u0430\u0442\u0440\u0443\u043b\u044f"
                     );
                     return;
                  }

                  ((iiiiiii_Class128)var5.get()).I_method_b8ab1d60(var6);
                  this.I_method_a49c396("\u0411\u043e\u0442 " + var4 + " \u043d\u0430\u0447\u0430\u043b \u043f\u0430\u0442\u0440\u0443\u043b\u044c");
                  break;
               default:
                  this.i_method_db011776(
                     "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot patrol add|clear|start <\u0431\u043e\u0442>"
                  );
            }
         }
      }
   }

   private void III_method_98dfc4d(IIIIIIIi_Class2 var1) {
      if (I_field_3a9bda27.player != null) {
         Vec3d var2 = I_field_3a9bda27.player.getPos();
         var1.i_method_470b35e8(var1x -> var1x.i_method_530c2fbf(var2.x, var2.y, var2.z));
         this.I_method_a49c396(IiIiIIII_Class81.I_method_f25a980a("commands.bot.action.tp"));
      }
   }

   private void iii_method_8ba7071e(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(IiIiIIII_Class81.I_method_f25a980a("commands.bot.nickname_required"));
      } else {
         Optional var3 = var1.I_method_ad974b8f((String)var2.get(0));
         if (var3.isEmpty()) {
            this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var2.get(0)));
         } else {
            iiiiiii_Class128 var4 = (iiiiiii_Class128)var3.get();
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.info.header", var4.I_method_7b75de01())));
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.info.status", var4.I_method_8e45dd15().name())));
            iIIIIIIii_Class260.I_method_468cf607(
               Text.of("Behavior: " + (var4.I_method_e2514398() == null ? "Idle" : var4.I_method_e2514398().I_method_dcc0dd54()))
            );
            iIIIIIIii_Class260.I_method_468cf607(
               Text.of(
                  "World: chunks="
                     + var4.I_method_1729e358().II_method_99aeb9aa().size()
                     + ", entities="
                     + var4.I_method_1729e358().I_method_513459e1().size()
                     + ", players="
                     + var4.I_method_1729e358().i_method_e3709dc1().size()
                     + ", blocks="
                     + var4.I_method_1729e358().I_method_9235e49f()
               )
            );
            iIIIIIIii_Class260.I_method_468cf607(
               Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.info.health", var4.I_method_e09ce338().II_method_a4679445()))
            );
            iIIIIIIii_Class260.I_method_468cf607(
               Text.of(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.info.food", var4.I_method_e09ce338().I_method_6865f47f()))
            );
            Vec3d var5 = var4.I_method_e09ce338().I_method_d573f06();
            iIIIIIIii_Class260.I_method_468cf607(
               Text.of(
                  IiIiIIII_Class81.I_method_1410d1e5(
                     "commands.bot.info.position", String.format("%.1f", var5.x), String.format("%.1f", var5.y), String.format("%.1f", var5.z)
                  )
               )
            );
         }
      }
   }

   private void IIII_method_f9936d07(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot chat [\u043d\u0438\u043a|all] <\u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435>"
         );
      } else {
         String var3 = (String)var2.get(0);
         Optional var4 = var1.I_method_ad974b8f(var3);
         if (var3.equalsIgnoreCase("all") && var2.size() >= 2) {
            String var8 = String.join(" ", var2.subList(1, var2.size()));
            var1.i_method_470b35e8(var1x -> var1x.I_method_98066c89(var8));
            this.I_method_a49c396(
               "\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e \u043e\u0442 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else if (var4.isPresent() && var2.size() >= 2) {
            String var7 = String.join(" ", var2.subList(1, var2.size()));
            ((iiiiiii_Class128)var4.get()).I_method_98066c89(var7);
            this.I_method_a49c396(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.action.say", var3));
         } else {
            String var5 = String.join(" ", var2);
            Optional var6 = var1.I_method_b088ba99();
            if (var6.isPresent() && ((iiiiiii_Class128)var6.get()).Ii_method_16f24ea6()) {
               ((iiiiiii_Class128)var6.get()).I_method_98066c89(var5);
               this.I_method_a49c396(
                  "\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e \u043e\u0442 \u0443\u043f\u0440\u0430\u0432\u043b\u044f\u0435\u043c\u043e\u0433\u043e \u0431\u043e\u0442\u0430 "
                     + ((iiiiiii_Class128)var6.get()).I_method_7b75de01()
               );
            } else {
               var1.i_method_470b35e8(var1x -> var1x.I_method_98066c89(var5));
               this.I_method_a49c396(
                  "\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e \u043e\u0442 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
               );
            }
         }
      }
   }

   private void IIIi_method_288520e7(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.size() < 2) {
         this.i_method_db011776(IiIiIIII_Class81.I_method_f25a980a("commands.bot.cmd_usage"));
      } else {
         String var3 = (String)var2.get(0);
         String var4 = String.join(" ", var2.subList(1, var2.size()));
         if (var3.equalsIgnoreCase("all")) {
            var1.i_method_470b35e8(var1x -> var1x.i_method_68bdc069(var4.startsWith("/") ? var4.substring(1) : var4));
            this.I_method_a49c396(
               "\u041a\u043e\u043c\u0430\u043d\u0434\u0430 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0430 \u043e\u0442 \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
            );
         } else {
            Optional var5 = var1.I_method_ad974b8f(var3);
            if (var5.isEmpty()) {
               this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
            } else {
               ((iiiiiii_Class128)var5.get()).i_method_68bdc069(var4.startsWith("/") ? var4.substring(1) : var4);
               this.I_method_a49c396(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.action.cmd", var3));
            }
         }
      }
   }

   private void IIiI_method_a8d83527(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot password <\u043f\u0430\u0440\u043e\u043b\u044c>"
         );
      } else {
         var1.II_method_1b601abf((String)var2.get(0));
         this.I_method_a49c396(
            "\u041f\u0430\u0440\u043e\u043b\u044c \u0434\u043b\u044f \u0431\u043e\u0442\u043e\u0432 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d: "
               + (String)var2.get(0)
         );
      }
   }

   private void IIii_method_d7c9e907(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.size() < 2) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot pay <\u043d\u0438\u043a|all> <\u043a\u043e\u043c\u0443>"
         );
      } else {
         String var3 = (String)var2.get(0);
         String var4 = (String)var2.get(1);
         if (var3.equalsIgnoreCase("all")) {
            var1.i_method_470b35e8(var2x -> {
               var1.I_method_8219a7c0(var2x.I_method_7b75de01(), var4);
               var2x.I_method_98066c89("/balance");
            });
            this.I_method_a49c396(
               "\u0417\u0430\u043f\u0440\u043e\u0441 \u0431\u0430\u043b\u0430\u043d\u0441\u0430 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d \u0432\u0441\u0435\u043c \u0431\u043e\u0442\u0430\u043c"
            );
         } else {
            Optional var5 = var1.I_method_ad974b8f(var3);
            if (var5.isEmpty()) {
               this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
            } else {
               var1.I_method_8219a7c0(((iiiiiii_Class128)var5.get()).I_method_7b75de01(), var4);
               ((iiiiiii_Class128)var5.get()).I_method_98066c89("/balance");
               this.I_method_a49c396(
                  "\u0417\u0430\u043f\u0440\u043e\u0441 \u0431\u0430\u043b\u0430\u043d\u0441\u0430 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d \u0431\u043e\u0442\u0443 "
                     + var3
               );
            }
         }
      }
   }

   private void IiII_method_32e7a8e7(IIIIIIIi_Class2 var1, List<String> var2) {
      if (!var2.isEmpty() && !((String)var2.get(0)).equalsIgnoreCase("status")) {
         String var3 = ((String)var2.get(0)).toLowerCase(Locale.ROOT);
         switch (var3) {
            case "enable":
               var1.I_method_1bcb6fa8(true);
               var1.i_method_1d8e5fc8(true);
               this.I_method_a49c396("Anti-AFK \u0432\u043a\u043b\u044e\u0447\u0435\u043d");
               break;
            case "disable":
               var1.I_method_1bcb6fa8(false);
               var1.i_method_1d8e5fc8(false);
               this.I_method_a49c396("Anti-AFK \u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d");
               break;
            case "setcommand":
               if (var2.size() < 2) {
                  this.i_method_db011776(
                     "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot antiafk setcommand <\u043a\u043e\u043c\u0430\u043d\u0434\u0430>"
                  );
                  return;
               }

               var1.i_method_efd08356(String.join(" ", var2.subList(1, var2.size())));
               this.I_method_a49c396("Anti-AFK \u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0430");
               break;
            case "setinterval":
               if (var2.size() < 2) {
                  this.i_method_db011776(
                     "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot antiafk setinterval <\u043c\u0438\u043d\u0443\u0442\u044b>"
                  );
                  return;
               }

               Integer var6 = this.I_method_4955e93d((String)var2.get(1));
               if (var6 == null || var6 < 1) {
                  this.i_method_db011776("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0438\u043d\u0442\u0435\u0440\u0432\u0430\u043b");
                  return;
               }

               var1.I_method_1bcb2fd7(var6);
               this.I_method_a49c396("Anti-AFK \u0438\u043d\u0442\u0435\u0440\u0432\u0430\u043b: " + var6 + " \u043c\u0438\u043d");
               break;
            case "walk":
               if (var2.size() < 2) {
                  this.i_method_db011776("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot antiafk walk enable|disable");
                  return;
               }

               boolean var5 = ((String)var2.get(1)).equalsIgnoreCase("enable") || ((String)var2.get(1)).equalsIgnoreCase("on");
               var1.i_method_1d8e5fc8(var5);
               this.I_method_a49c396(
                  "Anti-AFK walk " + (var5 ? "\u0432\u043a\u043b\u044e\u0447\u0435\u043d" : "\u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d")
               );
               break;
            default:
               this.i_method_db011776(
                  "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot antiafk enable|disable|status|setcommand|setinterval|walk"
               );
         }
      } else {
         this.I_method_a49c396(
            "Anti-AFK: "
               + (var1.I_method_6c4058b0() ? "\u0432\u043a\u043b\u044e\u0447\u0435\u043d" : "\u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d")
               + ", walk: "
               + (var1.i_method_6c4ee490() ? "\u0432\u043a\u043b\u044e\u0447\u0435\u043d" : "\u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d")
               + ", command: "
               + var1.I_method_70b457eb().Ii_method_98dae14b()
               + ", interval: "
               + var1.I_method_70b457eb().iIi_method_1ea349a0() / 60000L
               + " \u043c\u0438\u043d"
         );
      }
   }

   private void IiIi_method_61d95cc7(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.size() < 2) {
         this.i_method_db011776(
            "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot rejoin enable|disable <\u043d\u0438\u043a|all> [\u0442\u0438\u043a\u0438]"
         );
      } else {
         boolean var3 = ((String)var2.get(0)).equalsIgnoreCase("enable");
         if (!var3 && !((String)var2.get(0)).equalsIgnoreCase("disable")) {
            this.i_method_db011776(
               "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot rejoin enable|disable <\u043d\u0438\u043a|all> [\u0442\u0438\u043a\u0438]"
            );
         } else {
            String var4 = (String)var2.get(1);
            Integer var5 = var2.size() >= 3 ? this.I_method_4955e93d((String)var2.get(2)) : var1.I_method_70b457eb().iIi_method_1ea3499f();
            if (var5 == null || var5 < 1) {
               this.i_method_db011776("\u041d\u0435\u0432\u0435\u0440\u043d\u0430\u044f \u0437\u0430\u0434\u0435\u0440\u0436\u043a\u0430 rejoin");
            } else if (var4.equalsIgnoreCase("all")) {
               var1.I_method_8c13b5c8(var2x -> {
                  var2x.iI_method_fc305c32(var3);
                  var2x.II_method_c5950881(var5);
               });
               this.I_method_a49c396(
                  "Rejoin "
                     + (var3 ? "\u0432\u043a\u043b\u044e\u0447\u0435\u043d" : "\u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d")
                     + " \u0434\u043b\u044f \u0432\u0441\u0435\u0445 \u0431\u043e\u0442\u043e\u0432"
               );
            } else {
               Optional var6 = var1.I_method_ad974b8f(var4);
               if (var6.isEmpty()) {
                  this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var4));
               } else {
                  ((iiiiiii_Class128)var6.get()).iI_method_fc305c32(var3);
                  ((iiiiiii_Class128)var6.get()).II_method_c5950881(var5);
                  this.I_method_a49c396(
                     "Rejoin "
                        + (var3 ? "\u0432\u043a\u043b\u044e\u0447\u0435\u043d" : "\u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d")
                        + " \u0434\u043b\u044f "
                        + var4
                  );
               }
            }
         }
      }
   }

   private void IiiI_method_e22c7107(IIIIIIIi_Class2 var1, List<String> var2) {
      if (var2.isEmpty()) {
         this.i_method_db011776("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .bot control <\u043d\u0438\u043a>");
      } else {
         String var3 = (String)var2.get(0);
         if (!var1.I_method_1f192f7a(var3)) {
            this.i_method_db011776(IiIiIIII_Class81.I_method_1410d1e5("commands.bot.not_found", var3));
         } else {
            this.I_method_a49c396(
               "Packet-control \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0434\u043b\u044f "
                  + var3
                  + ". WASD/\u043c\u044b\u0448\u044c/attack/use/drop \u0443\u043f\u0440\u0430\u0432\u043b\u044f\u044e\u0442 \u0431\u043e\u0442\u043e\u043c; .bot return \u0432\u0435\u0440\u043d\u0451\u0442 \u043e\u0431\u044b\u0447\u043d\u044b\u0439 \u0440\u0435\u0436\u0438\u043c"
            );
         }
      }
   }

   private void IIi_method_1f23702d(IIIIIIIi_Class2 var1) {
      if (var1.II_method_1bd9b439()) {
         this.I_method_a49c396(
            "\u0423\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0431\u043e\u0442\u043e\u043c \u043e\u0442\u043a\u043b\u044e\u0447\u0435\u043d\u043e"
         );
      } else {
         this.I_method_a49c396(
            "\u0421\u0435\u0439\u0447\u0430\u0441 \u043d\u0438 \u043e\u0434\u0438\u043d \u0431\u043e\u0442 \u043d\u0435 \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u0441\u044f \u0432 \u0440\u0443\u0447\u043d\u043e\u043c \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0438"
         );
      }
   }

   private void i_method_a1d240ac() {
      iIIIIIIii_Class260.I_method_468cf607(
         Text.of(
            "\u0411\u043e\u0442\u044b: .bot connect <\u043d\u0438\u043a> <ip[:port]>, .bot start <count> <ip[:port]>, .bot stop <\u043d\u0438\u043a>, .bot clear, .bot list"
         )
      );
      iIIIIIIii_Class260.I_method_468cf607(
         Text.of(
            "\u041f\u043e\u0432\u0435\u0434\u0435\u043d\u0438\u0435: .bot follow <\u0431\u043e\u0442|all> <\u0446\u0435\u043b\u044c>, .bot attack <\u0431\u043e\u0442|all> <\u0446\u0435\u043b\u044c>, .bot mining <\u0431\u043e\u0442|all> <block>, .bot rebreak <\u0431\u043e\u0442|all>, .bot instantrebreak <\u0431\u043e\u0442|all>, .bot goto <\u0431\u043e\u0442|all> <x> <y> <z>"
         )
      );
      iIIIIIIii_Class260.I_method_468cf607(
         Text.of(
            "\u041f\u0440\u043e\u0447\u0435\u0435: .bot autojoingrief <\u0431\u043e\u0442|all> <\u0433\u0440\u0438\u0444>, .bot tapemouse add|remove <\u0431\u043e\u0442>, .bot control <\u043d\u0438\u043a>, .bot return, .bot chat <\u043d\u0438\u043a|all> <msg>, .bot antiafk enable|disable|status"
         )
      );
   }

   private Integer I_method_4955e93d(String var1) {
      try {
         return Integer.parseInt(var1);
      } catch (NumberFormatException var3) {
         return null;
      }
   }

   private void I_method_a49c396(String var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      Runnable var3 = () -> iIIIIIIii_Class260.I_method_468cf607(Text.of(var1));
      if (var2.isOnThread()) {
         var3.run();
      } else {
         var2.execute(var3);
      }
   }

   private void i_method_db011776(String var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      Runnable var3 = () -> iIIIIIIii_Class260.II_method_e8fd4864(Text.of(var1));
      if (var2.isOnThread()) {
         var3.run();
      } else {
         var2.execute(var3);
      }
   }
}
