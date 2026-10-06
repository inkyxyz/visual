package rockstar.client;

import java.util.ArrayList;
import java.util.function.UnaryOperator;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;

public final class IIIiIiii_Class24 {
   private static final StringBuilder I_field_46108671 = new StringBuilder(256);

   private IIIiIiii_Class24() {
   }

   public static CharSequence I_method_9dcc0c2b(OrderedText var0) {
      I_field_46108671.setLength(0);
      var0.accept((var0x, var1, var2) -> {
         I_field_46108671.appendCodePoint(var2);
         return true;
      });
      return I_field_46108671;
   }

   public static OrderedText I_method_a505dd22(OrderedText var0, NameProtectModule var1) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      var0.accept((var2x, var3x, var4x) -> {
         if (var3.isEmpty() || !((Style)var2.getLast()).equals(var3x)) {
            var2.add(var3x);
            var3.add(new StringBuilder());
         }

         ((StringBuilder)var3.getLast()).appendCodePoint(var4x);
         return true;
      });
      if (var3.isEmpty()) {
         return null;
      } else {
         UnaryOperator<String> var4 = var1::i_method_a8235dd7;
         ArrayList var5 = new ArrayList(var3.size());
         StringBuilder var6 = new StringBuilder();
         boolean var7 = false;

         for (int var8 = 0; var8 < var3.size(); var8++) {
            String var9 = ((StringBuilder)var3.get(var8)).toString();
            String var10 = var4.apply(var9);
            var7 |= !var10.equals(var9);
            var6.append(var10);
            var5.add(OrderedText.styledForwardsVisitedString(var10, (Style)var2.get(var8)));
         }

         if (!var7) {
            return null;
         } else {
            String var11 = var6.toString();
            return !var4.apply(var11).equals(var11)
               ? OrderedText.styledForwardsVisitedString(var4.apply(var11), (Style)var2.getFirst())
               : OrderedText.concat(var5);
         }
      }
   }
}
