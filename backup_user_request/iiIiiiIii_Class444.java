package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public final class iiIiiiIii_Class444 {
   private static final Set<String> I_field_a56a8dc5 = Set.of(
      "elytra",
      "fly",
      "\u044d\u043b\u0438\u0442\u0440\u0430",
      "\u044d\u043b\u0438\u0442\u0440\u0443",
      "\u043f\u043e\u043b\u0451\u0442",
      "\u043f\u043e\u043b\u0435\u0442"
   );
   private static final Object I_field_5f790d9c = new Object();

   public IIIiiIIi_Class26 I_method_d64c7578() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "goto",
            var1 -> var1.i_method_cfe1a061("commands.goto.description")
               .i_method_3d6e11d9("coords", var0 -> var0.i_method_132d6feb().I_method_2619a44a(var0x -> {
                  if (I_field_a56a8dc5.contains(var0x.toLowerCase())) {
                     return IIiIIIIi_Class34.I_method_12fc454a(I_field_5f790d9c);
                  } else {
                     try {
                        return IIiIIIIi_Class34.I_method_12fc454a(Integer.parseInt(var0x));
                     } catch (NumberFormatException var2) {
                        return IIiIIIIi_Class34.I_method_c9d442bc("'" + var0x + "' \u043d\u0435 \u0447\u0438\u0441\u043b\u043e \u0438 \u043d\u0435 'elytra'");
                     }
                  }
               }))
               .I_method_16f05c8a(this::I_method_a5455f20)
         )
         .I_method_9111538b();
   }

   private void I_method_a5455f20(IIIiiIii_Class28 var1) {
      List var2 = (List)var1.I_method_557e5bfb().get(0);
      if (var2 != null && !var2.isEmpty()) {
         boolean var3 = false;
         ArrayList var4 = new ArrayList();

         for (Object var6 : var2) {
            if (var6 == I_field_5f790d9c) {
               var3 = true;
            } else if (var6 instanceof Number var7) {
               var4.add(var7.intValue());
            }
         }

         if (var4.size() != 2 && var4.size() != 3) {
            this.I_method_3977865f();
         } else {
            MinecraftClient var9 = MinecraftClient.getInstance();
            if (var9.player == null || var9.world == null) {
               iiiIIIIii_Class452.i_method_e5eeaa09("\u041d\u0435\u0442 \u043c\u0438\u0440\u0430/\u0438\u0433\u0440\u043e\u043a\u0430");
            } else if (var3) {
               int var11 = (Integer)var4.get(0);
               int var12 = (Integer)var4.get(var4.size() - 1);
               int var8 = var4.size() == 3 ? (Integer)var4.get(1) : (int)Math.round(var9.player.getY());
               iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(new iiiIiiiii_Class480(var11, var8, var12, var4.size() == 3));
               iiiIIIIii_Class452.I_method_15375629(
                  "\u041b\u0435\u0442\u0438\u043c \u043d\u0430 \u044d\u043b\u0438\u0442\u0440\u0435 \u043a "
                     + var11
                     + ", "
                     + (var4.size() == 3 ? var8 : "?")
                     + ", "
                     + var12
               );
            } else {
               Object var10;
               if (var4.size() == 2) {
                  var10 = new iiiIIiiIi_Class462((Integer)var4.get(0), (Integer)var4.get(1));
               } else {
                  var10 = new iiiIIiIii_Class460(new BlockPos((Integer)var4.get(0), (Integer)var4.get(1), (Integer)var4.get(2)));
               }

               iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(new iiiiIIIiI_Class483((iiiIIiiii_Class464)var10));
               iiiIIIIii_Class452.I_method_15375629(
                  "\u0418\u0434\u0451\u043c \u043a "
                     + (var4.size() == 2 ? var4.get(0) + ", ?, " + var4.get(1) : var4.get(0) + ", " + var4.get(1) + ", " + var4.get(2))
               );
            }
         }
      } else {
         this.I_method_3977865f();
      }
   }

   private void I_method_3977865f() {
      iiiIIIIii_Class452.i_method_e5eeaa09(
         "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .goto <x> <z> | <x> <y> <z> [elytra]"
      );
   }
}
