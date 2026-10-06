package rockstar.client;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import net.minecraft.text.Text;
import ua.mintantileak.spk.Compile;

public final class IIiIiIIi_Class42 {
   private static final IIiIIIII_Class33 I_field_de26afa1 = new IIiIIIII_Class33() {
      @Override
      public IIiIIIIi_Class34 validate(String var1) {
         return IIiIIIIi_Class34.I_method_12fc454a(var1);
      }

      @Override
      public List<String> suggestions(String var1) {
         String var2 = var1.toLowerCase();
         return RockstarClient.getInstance().I_method_5198232b().i_method_f9096ffb().stream().filter(var1x -> var1x.toLowerCase().startsWith(var2)).toList();
      }
   };

   public IIIiiIIi_Class26 I_method_d4f1738b() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "config",
            var1 -> var1.I_method_b3f941e4("cfg", "\u043a\u0444\u0433", "\u043a\u043e\u043d\u0444\u0438\u0433")
               .i_method_cfe1a061("commands.config.description")
               .i_method_3d6e11d9(
                  "action",
                  var0 -> var0.I_method_2619a44a(
                        var0x -> IIiIiIIi_Class42.Nested1_1939d4b3.I_method_94625634(var0x)
                            .map(var1x -> (IIiIIIIi_Class34)IIiIIIIi_Class34.I_method_12fc454a(var1x))
                           .orElseGet(() -> IIiIIIIi_Class34.I_method_c9d442bc(IiIiIIII_Class81.I_method_f25a980a("commands.config.invalid_action")))
                     )
                     .I_method_b539159d(IIiIiIIi_Class42.Nested1_1939d4b3.I_method_ab2c2080())
               )
               .i_method_3d6e11d9("id", var0 -> var0.I_method_e930dfcb().I_method_2619a44a(I_field_de26afa1))
               .i_method_3d6e11d9("arg", var0 -> var0.I_method_e930dfcb().I_method_2619a44a(I_field_de26afa1))
               .I_method_16f05c8a(this::I_method_7b40236d)
         )
         .I_method_9111538b();
   }

   @Compile
   public void I_method_7b40236d(IIIiiIii_Class28 var1) {
      IIiIiIIi_Class42.Nested1_1939d4b3 var2 = (IIiIiIIi_Class42.Nested1_1939d4b3)var1.I_method_557e5bfb().get(0);
      String var3 = (String)var1.I_method_557e5bfb().get(1);
      String var4 = (String)var1.I_method_557e5bfb().get(2);
      if (var2 != IIiIiIIi_Class42.Nested1_1939d4b3.ii_field_8c0ef21c && var4 != null) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.too_many_args")));
      } else {
         IIiiiiiI_Class63 var5 = RockstarClient.getInstance().I_method_5198232b();
         switch (var2) {
            case I_field_8c0ef21c:
               var5.I_method_ce5aebb6(var3);
               break;
            case i_field_8c0ef21c:
               var5.Ii_method_250d3a5f(var3);
               break;
            case II_field_8c0ef21c:
               var5.ii_method_21906bf5();
               break;
            case Ii_field_8c0ef21c:
               var5.i_method_9f123f96(var3);
               break;
            case iI_field_8c0ef21c:
               var5.iI_method_2181e015();
               break;
            case ii_field_8c0ef21c:
               var5.I_method_cd7cd400(var3, var4);
               break;
            case III_field_8c0ef21c:
               var5.iI_method_9a890e9f(var3);
               break;
            case IIi_field_8c0ef21c:
               var5.II_method_5455e67f(var3);
         }
      }
   }

   static enum Nested1_1939d4b3 {
      I_field_8c0ef21c("save", "create", "add", "\u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c", "\u044b\u0444\u043c\u0443"),
      i_field_8c0ef21c("remove", "delete", "del", "\u0443\u0434\u0430\u043b\u0438\u0442\u044c", "\u0432\u0443\u0434\u0443\u0435\u0443"),
      II_field_8c0ef21c("list", "\u0434\u0448\u044b\u0435"),
      Ii_field_8c0ef21c("load", "use", "enable", "\u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c", "true", "\u0434\u0449\u0444\u0432"),
      iI_field_8c0ef21c("reset", "restore", "\u0441\u0431\u0440\u043e\u0441", "\u0441\u0431\u0440\u043e\u0441\u0438\u0442\u044c"),
      ii_field_8c0ef21c("rename", "\u043f\u0435\u0440\u0435\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u0442\u044c"),
      III_field_8c0ef21c(
         "duplicate",
         "copy",
         "\u0434\u0443\u0431\u043b\u0438\u0440\u043e\u0432\u0430\u0442\u044c",
         "\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c"
      ),
      IIi_field_8c0ef21c(
         "undo", "\u043e\u0442\u043a\u0430\u0442", "\u043e\u0442\u043a\u0430\u0442\u0438\u0442\u044c", "\u0432\u0435\u0440\u043d\u0443\u0442\u044c"
      );

      private final List<String> I_field_7865b31;

      private Nested1_1939d4b3(String... var3) {
         this.I_field_7865b31 = Arrays.stream(var3).map(String::toLowerCase).toList();
      }

      @Compile
      public static Optional<IIiIiIIi_Class42.Nested1_1939d4b3> I_method_94625634(String var0) {
         String var1 = var0.toLowerCase();
         return Arrays.stream(values()).filter(var1x -> var1x.I_field_7865b31.contains(var1)).findFirst();
      }

      @Compile
      public static List<String> I_method_ab2c2080() {
         return Arrays.stream(values()).map(var0 -> var0.I_field_7865b31.getFirst()).toList();
      }
   }
}
