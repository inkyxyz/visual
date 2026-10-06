package rockstar.client;

import java.util.List;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

public final class iiIiiiIiI_Class443 {
   static final Set<String> I_field_a56a8dc5 = Set.of("stop", "cancel", "\u0441\u0442\u043e\u043f", "\u043e\u0442\u043c\u0435\u043d\u0430");

   public IIIiiIIi_Class26 I_method_39336d58() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "fill",
            var1 -> var1.i_method_cfe1a061("commands.fill.description")
               .I_method_b3f941e4("\u0437\u0430\u043f\u043e\u043b\u043d\u0438\u0442\u044c")
               .i_method_3d6e11d9(
                  "block",
                  var1x -> var1x.I_method_2619a44a(
                     new IIiIIIII_Class33() {
                        @Override
                        public IIiIIIIi_Class34 validate(String var1) {
                           if (iiIiiiIiI_Class443.I_field_a56a8dc5.contains(var1.toLowerCase())) {
                              return IIiIIIIi_Class34.I_method_12fc454a(null);
                           } else {
                              Block var2 = iiIiiiIII_Class441.I_method_b7c8d0a3(var1);
                              if (var2 == null) {
                                 return IIiIIIIi_Class34.I_method_c9d442bc(
                                    "\u0411\u043b\u043e\u043a \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d: " + var1
                                 );
                              } else {
                                 return (IIiIIIIi_Class34)(var2.asItem() == Items.AIR
                                    ? IIiIIIIi_Class34.I_method_c9d442bc(
                                       "\u042d\u0442\u043e\u0442 \u0431\u043b\u043e\u043a \u043d\u0435\u043b\u044c\u0437\u044f \u043f\u043e\u0441\u0442\u0430\u0432\u0438\u0442\u044c: "
                                          + var1
                                    )
                                    : IIiIIIIi_Class34.I_method_12fc454a(var2));
                              }
                           }
                        }

                        @Override
                        public List<String> suggestions(String var1) {
                           return iiIiiiIII_Class441.I_method_d63beb71(var1, "stop");
                        }
                     }
                  )
               )
               .I_method_16f05c8a(this::I_method_9f3d6340)
         )
         .I_method_9111538b();
   }

   private void I_method_9f3d6340(IIIiiIii_Class28 var1) {
      Block var2 = (Block)var1.I_method_557e5bfb().get(0);
      if (var2 == null) {
         iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7d4e61ff();
         iiiIIIIii_Class452.I_method_15375629(
            "\u0417\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0435 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e"
         );
      } else {
         iiIiiIIii_Class436 var3 = iiIiiIIii_Class436.I_method_29e64b35();
         if (!var3.I_method_b0e9a643()) {
            iiiIIIIii_Class452.i_method_e5eeaa09(
               "\u0421\u043d\u0430\u0447\u0430\u043b\u0430 \u0432\u044b\u0434\u0435\u043b\u0438 \u043e\u0431\u043b\u0430\u0441\u0442\u044c: \u0441\u043c\u043e\u0442\u0440\u0438 \u043d\u0430 \u0431\u043b\u043e\u043a \u0438 \u0436\u043c\u0438 .newton sel (\u043d\u0443\u0436\u043d\u043e 2 \u0443\u0433\u043b\u0430)"
            );
         } else {
            BlockPos var4 = var3.II_method_79a4af8e();
            BlockPos var5 = var3.Ii_method_ee9f1fae();
            iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(new iiiiIIIIi_Class482(var4, var5, var2));
            iiiIIIIii_Class452.I_method_15375629(
               "\u0417\u0430\u043f\u043e\u043b\u043d\u044f\u0435\u043c \u043e\u0431\u043b\u0430\u0441\u0442\u044c "
                  + I_method_f9f0ab87(var4)
                  + " \u2014 "
                  + I_method_f9f0ab87(var5)
                  + " \u0431\u043b\u043e\u043a\u043e\u043c "
                  + var2
            );
         }
      }
   }

   private static String I_method_f9f0ab87(BlockPos var0) {
      return var0.getX() + ", " + var0.getY() + ", " + var0.getZ();
   }
}
