package pyrock.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jep.python.PyCallable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIIiiiIi_Class30;
import rockstar.client.IIiIIIII_Class33;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IIiiIiIIi_Class106;
import rockstar.client.ModuleEntry;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIiiiIII_Class441;

public class PyCommand {
   private final PyCommand root;
   private final IIiiIIiii_Class104 owner;
   private final String name;
   private final List<String> aliases = new ArrayList<>();
   private final List<PyCommand.Nested1_db2b9aea> args = new ArrayList<>();
   private final List<PyCommand> subs = new ArrayList<>();
   private String desc = "";
   @Nullable
   private PyCallable handler;
   @Nullable
   private IIIiiIIi_Class26 registered;

   public PyCommand(String var1) {
      this(var1, null);
   }

   private PyCommand(String var1, @Nullable PyCommand var2) {
      this.name = var1.toLowerCase(Locale.ROOT);
      this.root = var2 == null ? this : var2;
      this.owner = var2 == null ? IIiiIIiii_Class104.I_method_204b62f5() : var2.owner;
   }

   public PyCommand alias(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.aliases.add(var1.toLowerCase(Locale.ROOT));
      }

      return this;
   }

   public PyCommand desc(String var1) {
      this.desc = var1 == null ? "" : var1;
      return this;
   }

   public PyCommand handler(PyCallable var1) {
      this.handler = var1;
      return this;
   }

   public PyCommand arg(String var1, String var2, boolean var3, boolean var4, Object var5) {
      ArrayList var6 = null;
      PyCallable var7 = null;
      if (var5 instanceof PyCallable var8) {
         var7 = var8;
      } else if (var5 instanceof List var9) {
         var6 = new ArrayList();

         for (Object var11 : var9) {
            if (var11 != null) {
               var6.add(String.valueOf(var11));
            }
         }
      }

      this.args.add(new PyCommand.Nested1_db2b9aea(var1, var2 == null ? "str" : var2.toLowerCase(Locale.ROOT), var3, var4, var7, var6));
      return this;
   }

   public PyCommand sub(String var1) {
      PyCommand var2 = new PyCommand(var1, this.root);
      this.subs.add(var2);
      return var2;
   }

   public String name() {
      return this.name;
   }

   public PyCommand install() {
      if (this.root != this) {
         return this.root.install();
      } else {
         IIIiiiIi_Class30 var1 = RockstarClient.getInstance().I_method_b4d046cb();
         if (this.registered == null) {
            String var2 = this.firstTakenName(var1);
            if (var2 != null) {
               throw new IllegalStateException(
                  "\u043a\u043e\u043c\u0430\u043d\u0434\u0430 '"
                     + var2
                     + "' \u0443\u0436\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442 \u0432 \u043a\u043b\u0438\u0435\u043d\u0442\u0435"
               );
            }
         } else {
            var1.I_method_306252f1(this.registered);
         }

         this.registered = this.build();
         var1.I_method_306252ed(this.registered);
         IIiiIIiii_Class104.I_method_5edf8af6(this);
         return this;
      }
   }

   public boolean remove() {
      if (this.root != this) {
         return this.root.remove();
      } else if (this.registered == null) {
         return false;
      } else {
         RockstarClient.getInstance().I_method_b4d046cb().I_method_306252f1(this.registered);
         this.registered = null;
         return true;
      }
   }

   public boolean installed() {
      return this.root.registered != null;
   }

   @Nullable
   private String firstTakenName(IIIiiiIi_Class30 var1) {
      ArrayList var2 = new ArrayList();
      var2.add(this.name);
      var2.addAll(this.aliases);

      for (IIIiiIIi_Class26 var4 : var1.I_method_cafa303b()) {
         if (var4 != this.registered) {
            for (String var6 : var4.I_method_84c7081b()) {
               for (String var8 : (Iterable<String>)(Iterable<?>)var2) {
                  if (var6.equalsIgnoreCase(var8)) {
                     return var8;
                  }
               }
            }
         }
      }

      return null;
   }

   private IIIiiIIi_Class26 build() {
      IIIiiIiI_Class27 var1 = IIIiiIiI_Class27.I_method_209cd841(this.name).i_method_cfe1a061(this.desc);
      if (!this.aliases.isEmpty()) {
         var1.I_method_b3f941e4(this.aliases.toArray(new String[0]));
      }

      for (PyCommand.Nested1_db2b9aea var3 : this.args) {
         var1.i_method_3d6e11d9(var3.name(), var2 -> {
            if (!var3.required()) {
               var2.I_method_e930dfcb();
            }

            if (var3.vararg()) {
               var2.i_method_132d6feb();
            }

            var2.I_method_2619a44a(this.validator(var3));
         });
      }

      if (!this.subs.isEmpty()) {
         ArrayList<IIIiiIIi_Class26> var5 = new ArrayList<>();

         for (PyCommand var4 : this.subs) {
            var5.add(var4.build());
         }

         var1.I_method_9449fb2d(var5.toArray(new IIIiiIIi_Class26[0]));
      }

      var1.I_method_16f05c8a(this::execute);
      return var1.I_method_9111538b();
   }

   private void execute(IIIiiIii_Class28 var1) {
      if (this.handler == null) {
         iIIIIIIii_Class260.I_method_468cf607(Text.of(this.usage()));
      } else {
         ArrayList var2 = new ArrayList<>(var1.I_method_557e5bfb());
         if (IIiiIiIIi_Class106.Ii_method_b61528e6()) {
            this.call(var2);
         } else {
            iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> this.call(var2));
         }
      }
   }

   private void call(List<Object> var1) {
      if (this.handler != null && (this.owner == null || this.owner.II_method_b18bf526())) {
         try (AutoCloseable var2 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
            this.handler.call(new Object[]{this.name, var1});
         } catch (Exception var7) {
            String var3 = var7.getMessage();
            if (var3 != null && var3.contains(":")) {
               var3 = var3.substring(var3.indexOf(":") + 1).trim();
            }

            iIIIIIIii_Class260.II_method_e8fd4864(Text.of("[Python Error] " + var3));
            RockstarClient.I_field_ab0f6068.error("Python error in command '" + this.name + "':", var7);
         }
      }
   }

   private String usage() {
      StringBuilder var1 = new StringBuilder(RockstarClient.getInstance().I_method_b4d046cb().I_method_80ea594()).append(this.name);

      for (PyCommand var3 : this.subs) {
         var1.append(' ').append(var3.name);
      }

      for (PyCommand.Nested1_db2b9aea var5 : this.args) {
         var1.append(var5.required() ? " <" : " [").append(var5.name()).append((char)(var5.required() ? '>' : ']'));
      }

      return var1.toString();
   }

   private IIiIIIII_Class33 validator(final PyCommand.Nested1_db2b9aea var1) {
      return new IIiIIIII_Class33() {
         @Override
         public IIiIIIIi_Class34 validate(String var1x) {
            String var2 = var1.type();

            return (IIiIIIIi_Class34)(switch (var2) {
               case "int" -> {
                  IIiIIIIi_Class34.Nested1_e29ec0f3 var15;
                  try {
                     var15 = IIiIIIIi_Class34.I_method_12fc454a(Integer.parseInt(var1x));
                  } catch (NumberFormatException var7) {
                     IIiIIIIi_Class34.Nested1_e29ec0d3 var14 = IIiIIIIi_Class34.I_method_c9d442bc(
                        "'"
                           + var1x
                           + "' \u043d\u0435 \u0446\u0435\u043b\u043e\u0435 \u0447\u0438\u0441\u043b\u043e (\u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442 "
                           + var1.name()
                           + ")"
                     );
                     yield var14;
                  }

                  yield var15;
               }
               case "float", "number" -> {
                  IIiIIIIi_Class34.Nested1_e29ec0f3 var13;
                  try {
                     var13 = IIiIIIIi_Class34.I_method_12fc454a(Double.parseDouble(var1x));
                  } catch (NumberFormatException var6) {
                     IIiIIIIi_Class34.Nested1_e29ec0d3 var12 = IIiIIIIi_Class34.I_method_c9d442bc(
                        "'" + var1x + "' \u043d\u0435 \u0447\u0438\u0441\u043b\u043e (\u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442 " + var1.name() + ")"
                     );
                     yield var12;
                  }

                  yield var13;
               }
               case "bool" -> {
                  Boolean var5 = PyCommand.parseBool(var1x);
                  Object var11 = var5 == null
                     ? IIiIIIIi_Class34.I_method_c9d442bc(
                        "'" + var1x + "' \u043d\u0435 \u0434\u0430/\u043d\u0435\u0442 (\u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442 " + var1.name() + ")"
                     )
                     : IIiIIIIi_Class34.I_method_12fc454a(var5);
                  yield var11;
               }
               case "block" -> {
                  Object var10 = iiIiiiIII_Class441.I_method_b7c8d0a3(var1x) == null
                     ? IIiIIIIi_Class34.I_method_c9d442bc(
                        "\u0431\u043b\u043e\u043a\u0430 '" + var1x + "' \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442"
                     )
                     : IIiIIIIi_Class34.I_method_12fc454a(var1x);
                  yield var10;
               }
               case "module" -> {
                  if (PyCommand.findModule(var1x) == null) {
                     IIiIIIIi_Class34.Nested1_e29ec0d3 var8 = IIiIIIIi_Class34.I_method_c9d442bc(
                        "\u043c\u043e\u0434\u0443\u043b\u044f '" + var1x + "' \u043d\u0435\u0442 \u0432 \u043a\u043b\u0438\u0435\u043d\u0442\u0435"
                     );
                     yield var8;
                  } else {
                     IIiIIIIi_Class34.Nested1_e29ec0f3 var9 = IIiIIIIi_Class34.I_method_12fc454a(var1x);
                     yield var9;
                  }
               }
               default -> {
                  IIiIIIIi_Class34.Nested1_e29ec0f3 var4 = IIiIIIIi_Class34.I_method_12fc454a(var1x);
                  yield var4;
               }
            });
         }

         @Override
         public List<String> suggestions(String var1x) {
            String var2 = var1x == null ? "" : var1x.toLowerCase(Locale.ROOT);
            if (var1.suggest() != null) {
               return PyCommand.this.fromScript(var1.suggest(), var1x);
            } else if (var1.suggestions() != null) {
               return PyCommand.filter(var1.suggestions(), var2);
            } else {
               String var3 = var1.type();

               return switch (var3) {
                  case "player" -> PyCommand.filter(PyCommand.playerNames(), var2);
                  case "module" -> PyCommand.filter(PyCommand.moduleNames(), var2);
                  case "block" -> iiIiiiIII_Class441.I_method_d63beb71(var2);
                  case "bool" -> PyCommand.filter(List.of("true", "false"), var2);
                  default -> List.of();
               };
            }
         }
      };
   }

   List<String> fromScript(PyCallable var1, String var2) {
      if (this.owner != null && !this.owner.II_method_b18bf526()) {
         return List.of();
      } else if (!IIiiIiIIi_Class106.Ii_method_b61528e6()) {
         return List.of();
      } else {
         try {
            ArrayList var12;
            try (AutoCloseable var3 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
               Object var4 = var1.call(new Object[]{var2 == null ? "" : var2});
               ArrayList var5 = new ArrayList();
               if (var4 instanceof List) {
                  for (Object var8 : (List)var4) {
                     if (var8 != null) {
                        var5.add(String.valueOf(var8));
                     }
                  }
               }

               var12 = var5;
            }

            return var12;
         } catch (Exception var11) {
            return List.of();
         }
      }
   }

   static List<String> filter(List<String> var0, String var1) {
      ArrayList var2 = new ArrayList();

      for (String var4 : var0) {
         if (var4.toLowerCase(Locale.ROOT).startsWith(var1)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   static List<String> playerNames() {
      ArrayList var0 = new ArrayList();
      if (iIIiIIiIi_Class294.I_field_3a9bda27.world == null) {
         return var0;
      } else {
         for (PlayerEntity var2 : iIIiIIiIi_Class294.I_field_3a9bda27.world.getPlayers()) {
            var0.add(var2.getNameForScoreboard());
         }

         return var0;
      }
   }

   static List<String> moduleNames() {
      ArrayList var0 = new ArrayList();

      for (ModuleEntry var2 : RockstarClient.getInstance().getModuleManager().getModules()) {
         var0.add(var2.getName());
      }

      return var0;
   }

   @Nullable
   static ModuleEntry findModule(String var0) {
      for (ModuleEntry var2 : RockstarClient.getInstance().getModuleManager().getModules()) {
         if (var2.getName().equalsIgnoreCase(var0)) {
            return var2;
         }
      }

      return null;
   }

   @Nullable
   static Boolean parseBool(String var0) {
      String var1 = var0.toLowerCase(Locale.ROOT);

      return switch (var1) {
         case "true", "1", "on", "yes", "\u0434\u0430", "\u0432\u043a\u043b" -> Boolean.TRUE;
         case "false", "0", "off", "no", "\u043d\u0435\u0442", "\u0432\u044b\u043a\u043b" -> Boolean.FALSE;
         default -> null;
      };
   }

   static final class Nested1_db2b9aea {
      private final String name;
      private final String type;
      private final boolean required;
      private final boolean vararg;
      @Nullable
      private final PyCallable suggest;
      @Nullable
      private final List<String> suggestions;

      Nested1_db2b9aea(String var1, String var2, boolean var3, boolean var4, @Nullable PyCallable var5, @Nullable List<String> var6) {
         this.name = var1;
         this.type = var2;
         this.required = var3;
         this.vararg = var4;
         this.suggest = var5;
         this.suggestions = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_db2b9aea[name=" + this.name() + ", type=" + this.type() + ", required=" + this.required() + ", vararg=" + this.vararg() + ", suggest=" + this.suggest() + ", suggestions=" + this.suggestions() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.type());
         result = 31 * result + java.util.Objects.hashCode(this.required());
         result = 31 * result + java.util.Objects.hashCode(this.vararg());
         result = 31 * result + java.util.Objects.hashCode(this.suggest());
         result = 31 * result + java.util.Objects.hashCode(this.suggestions());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         PyCommand.Nested1_db2b9aea other = (PyCommand.Nested1_db2b9aea) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.type(), other.type())
            && java.util.Objects.equals(this.required(), other.required())
            && java.util.Objects.equals(this.vararg(), other.vararg())
            && java.util.Objects.equals(this.suggest(), other.suggest())
            && java.util.Objects.equals(this.suggestions(), other.suggestions());
      }

      public String name() {
         return this.name;
      }

      public String type() {
         return this.type;
      }

      public boolean required() {
         return this.required;
      }

      public boolean vararg() {
         return this.vararg;
      }

      @Nullable
      public PyCallable suggest() {
         return this.suggest;
      }

      @Nullable
      public List<String> suggestions() {
         return this.suggestions;
      }
   }
}
