package rockstar.client;

import java.util.List;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public final class iiIiiiiiI_Class447 {
   static final Set<String> I_field_a56a8dc5 = Set.of("clear", "reset", "\u0441\u0431\u0440\u043e\u0441", "\u043e\u0447\u0438\u0441\u0442\u0438\u0442\u044c");
   static final Object I_field_5f790d9c = new Object();
   private static final double I_field_44 = 256.0;

   public IIIiiIIi_Class26 I_method_f42aed78() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "sel",
            var1 -> var1.i_method_cfe1a061("commands.sel.description")
               .I_method_b3f941e4("pos", "\u0432\u044b\u0434\u0435\u043b\u0438\u0442\u044c")
               .i_method_3d6e11d9("args", var1x -> var1x.i_method_132d6feb().I_method_e930dfcb().I_method_2619a44a(new IIiIIIII_Class33() {
                  @Override
                  public IIiIIIIi_Class34 validate(String var1) {
                     if (iiIiiiiiI_Class447.I_field_a56a8dc5.contains(var1.toLowerCase())) {
                        return IIiIIIIi_Class34.I_method_12fc454a(iiIiiiiiI_Class447.I_field_5f790d9c);
                     } else {
                        try {
                           return IIiIIIIi_Class34.I_method_12fc454a(Integer.parseInt(var1));
                        } catch (NumberFormatException var3) {
                           return IIiIIIIi_Class34.I_method_c9d442bc("'" + var1 + "' \u043d\u0435 \u0447\u0438\u0441\u043b\u043e \u0438 \u043d\u0435 'clear'");
                        }
                     }
                  }

                  @Override
                  public List<String> suggestions(String var1) {
                     return "clear".startsWith(var1.toLowerCase()) ? List.of("clear") : List.of();
                  }
               }))
               .I_method_16f05c8a(this::I_method_4335e720)
         )
         .I_method_9111538b();
   }

   private void I_method_4335e720(IIIiiIii_Class28 var1) {
      List var2 = (List)var1.I_method_557e5bfb().get(0);
      iiIiiIIii_Class436 var3 = iiIiiIIii_Class436.I_method_29e64b35();
      if (var2 != null && var2.stream().anyMatch(var0 -> var0 == I_field_5f790d9c)) {
         var3.I_method_b0e9a63f();
         iiiIIIIii_Class452.I_method_15375629("\u0412\u044b\u0434\u0435\u043b\u0435\u043d\u0438\u0435 \u0441\u0431\u0440\u043e\u0448\u0435\u043d\u043e");
      } else {
         BlockPos var4;
         if (var2 != null && !var2.isEmpty()) {
            List var5 = var2.stream().filter(Integer.class::isInstance).map(Integer.class::cast).toList();
            if (var5.size() != 3) {
               iiiIIIIii_Class452.i_method_e5eeaa09(
                  "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .newton sel | .newton sel <x> <y> <z> | .newton sel clear"
               );
               return;
            }

            var4 = new BlockPos((Integer)var5.get(0), (Integer)var5.get(1), (Integer)var5.get(2));
         } else {
            var4 = I_method_b31999d1();
            if (var4 == null) {
               iiiIIIIii_Class452.i_method_e5eeaa09("\u041d\u0435 \u0441\u043c\u043e\u0442\u0440\u0438\u0448\u044c \u043d\u0430 \u0431\u043b\u043e\u043a");
               return;
            }
         }

         int var10 = var3.I_method_9d7525ec(var4);
         if (var3.I_method_b0e9a643()) {
            BlockPos var6 = var3.II_method_79a4af8e();
            BlockPos var7 = var3.Ii_method_ee9f1fae();
            long var8 = (long)(var7.getX() - var6.getX() + 1) * (var7.getY() - var6.getY() + 1) * (var7.getZ() - var6.getZ() + 1);
            iiiIIIIii_Class452.I_method_15375629(
               "\u0423\u0433\u043e\u043b "
                  + var10
                  + ": "
                  + I_method_10aa43a7(var4)
                  + " \u2014 \u043e\u0431\u043b\u0430\u0441\u0442\u044c \u0432\u044b\u0434\u0435\u043b\u0435\u043d\u0430 ("
                  + var8
                  + " \u0431\u043b\u043e\u043a\u043e\u0432). .newton cleararea / .newton fill"
            );
         } else {
            iiiIIIIii_Class452.I_method_15375629(
               "\u0423\u0433\u043e\u043b "
                  + var10
                  + ": "
                  + I_method_10aa43a7(var4)
                  + " \u2014 \u043f\u043e\u0441\u0442\u0430\u0432\u044c \u0432\u0442\u043e\u0440\u043e\u0439 \u0443\u0433\u043e\u043b"
            );
         }
      }
   }

   private static String I_method_10aa43a7(BlockPos var0) {
      return var0.getX() + ", " + var0.getY() + ", " + var0.getZ();
   }

   private static BlockPos I_method_b31999d1() {
      MinecraftClient var0 = MinecraftClient.getInstance();
      if (var0.player != null && var0.world != null) {
         Vec3d var1 = var0.player.getEyePos();
         Vec3d var2 = var0.player.getRotationVec(1.0F);
         Vec3d var3 = var1.add(var2.multiply(256.0));
         RaycastContext var4 = new RaycastContext(var1, var3, ShapeType.OUTLINE, FluidHandling.NONE, var0.player);
         BlockHitResult var5 = var0.world.raycast(var4);
         return var5.getType() != Type.BLOCK ? null : var5.getBlockPos();
      } else {
         return null;
      }
   }
}
