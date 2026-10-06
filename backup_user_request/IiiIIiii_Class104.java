package rockstar.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lombok.Generated;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public class IiiIIiii_Class104 implements iIIiIIiIi_Class294 {
   private final Map<String, String> I_field_a567c40b = Map.of(
      "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f",
      "\u0422\u0430\u043b\u0438\u0441\u043c\u0430\u043d \u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f",
      "\u0412\u0438\u0445\u0440\u044f",
      "\u0412\u0438\u0445\u0440\u044c",
      "\u0420\u0430\u0437\u0434\u043e\u0440\u0430",
      "\u0420\u0430\u0437\u0434\u043e\u0440",
      "\u0422\u0438\u0440\u0430\u043d\u0430",
      "\u0422\u0438\u0440\u0430\u043d"
   );
   private static final long I_field_4a = 900L;
   private static final long i_field_4a = 3000L;
   private static final int I_field_49 = 3;
   private IiiIIiii_Class104.Nested1_6cfe1cf3 I_field_b0d3b1dc;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final Map<String, List<Long>> i_field_a567c40b;
   private final Map<String, Double> II_field_a567c40b;
   private List<IiiIIiIi_Class102.Nested1_6cef9133> I_field_7865b31;
   private int i_field_49;
   private int II_field_49;
   private int Ii_field_49;
   private static final String[] I_field_6dccaaa5 = new String[]{
      "\u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u043d\u0430 \u0432 \u0440\u0435\u0436\u0438\u043c\u0435 afk",
      "\u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u044d\u0442\u043e \u0432 \u044d\u0442\u043e\u043c \u043c\u0435\u0441\u0442\u0435",
      "\u0437\u0430\u043f\u0440\u0435\u0449\u0451\u043d\u043d\u044b\u0435 \u0441\u0438\u043c\u0432\u043e\u043b\u044b",
      "\u0437\u0430\u043f\u0440\u0435\u0449\u0435\u043d\u043d\u044b\u0435 \u0441\u0438\u043c\u0432\u043e\u043b\u044b"
   };
   private String I_field_523beb0a;

   public IiiIIiii_Class104() {
      this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.I_field_b0d3b1dc;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_a567c40b = new HashMap<>();
      this.II_field_a567c40b = new HashMap<>();
      this.I_field_7865b31 = new ArrayList<>();
      this.i_field_49 = 0;
      this.II_field_49 = 0;
      this.Ii_field_49 = 0;
   }

   public void I_method_3848159d(List<IiiIIiIi_Class102.Nested1_6cef9133> var1) {
      this.I_field_7865b31 = new ArrayList<>(var1);
      if (!this.I_field_7865b31.isEmpty()) {
         this.i_field_a567c40b.clear();
         this.II_field_a567c40b.clear();
         this.I_field_523beb0a = null;
         this.i_field_49 = 0;
         this.II_field_49 = 0;
         this.Ii_field_49 = 0;
         this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.i_field_b0d3b1dc;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   public void I_method_97f860ac() {
      switch (this.I_field_b0d3b1dc) {
         case I_field_b0d3b1dc:
         default:
            break;
         case i_field_b0d3b1dc:
            this.i_method_9806ec8c();
            break;
         case II_field_b0d3b1dc:
            this.Ii_method_67313815();
            break;
         case Ii_field_b0d3b1dc:
            this.iI_method_68e59c55();
            break;
         case iI_field_b0d3b1dc:
            this.ii_method_68f42835();
            break;
         case ii_field_b0d3b1dc:
            this.III_method_7d41d1cc();
      }
   }

   private void i_method_9806ec8c() {
      if (this.i_field_49 >= this.I_field_7865b31.size()) {
         if (I_field_3a9bda27.currentScreen != null) {
            I_field_3a9bda27.player.closeHandledScreen();
         }

         this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.ii_field_b0d3b1dc;
         this.IIi_method_7d505dac();
      } else {
         if (this.I_field_991c1e8c.I_method_58432069(900L)) {
            IiiIIiIi_Class102.Nested1_6cef9133 var1 = this.I_field_7865b31.get(this.i_field_49);
            if (I_field_3a9bda27.currentScreen instanceof HandledScreen) {
               I_field_3a9bda27.player.closeHandledScreen();
            }

            I_field_3a9bda27.player.networkHandler.sendChatCommand("ah search " + this.I_method_97c862d8(var1));
            this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.II_field_b0d3b1dc;
            this.I_field_991c1e8c.I_method_23e11e3f();
            this.II_field_49 = 0;
            this.Ii_field_49++;
         }
      }
   }

   private String I_method_97c862d8(IiiIIiIi_Class102.Nested1_6cef9133 var1) {
      if (var1.I_method_96d2f519() == null) {
         return Iiiiiiiii_Class256.I_method_e0e8875f(var1.I_method_2478c0b1());
      } else {
         String var2 = var1.I_method_96d2f519();
         if (this.I_field_a567c40b.containsKey(var2)) {
            return this.I_field_a567c40b.get(var2);
         } else {
            IiiiiIiii_Class248.Nested1_95187080 var3 = IiiiiIiii_Class248.I_method_7613ca72(var1.I_method_2478c0b1());
            if (var3 != null) {
               String var4 = var3.I_method_2310f504(var1.I_method_2478c0b1());
               if (var4 != null && var4.toLowerCase().contains(var2.toLowerCase())) {
                  return var4;
               }
            }

            return var2;
         }
      }
   }

   public void I_method_1fdf3776(String var1) {
      if (this.I_field_b0d3b1dc != IiiIIiii_Class104.Nested1_6cfe1cf3.I_field_b0d3b1dc && var1 != null) {
         String var2 = var1.toLowerCase(Locale.ROOT);

         for (String var6 : I_field_6dccaaa5) {
            if (var2.contains(var6)) {
               this.I_field_523beb0a = var1.trim();
               return;
            }
         }
      }
   }

   private void II_method_6722ac35() {
      this.I_field_523beb0a = null;
      this.I_field_7865b31.clear();
      this.i_field_49 = 0;
      this.Ii_field_49 = 0;
      if (I_field_3a9bda27.currentScreen != null) {
         I_field_3a9bda27.player.closeHandledScreen();
      }

      this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.I_field_b0d3b1dc;
   }

   private void Ii_method_67313815() {
      if (this.I_field_523beb0a != null) {
         iIIIIIIii_Class260.i_method_70898627(
            Text.of(
               "\u0421\u0435\u0440\u0432\u0435\u0440 \u043d\u0435 \u0434\u0430\u0451\u0442 \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0430\u0443\u043a\u0446\u0438\u043e\u043d: \u00ab"
                  + this.I_field_523beb0a
                  + "\u00bb \u2014 \u043f\u0430\u0440\u0441\u0438\u043d\u0433 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d"
            )
         );
         this.II_method_6722ac35();
      } else if (I_field_3a9bda27.currentScreen instanceof HandledScreen var1 && IiiiiIIii_Class244.II_method_6da14e50(var1.getTitle().getString())) {
         if (this.I_field_991c1e8c.I_method_58432069(300L)) {
            this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.Ii_field_b0d3b1dc;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      } else if (this.I_field_991c1e8c.I_method_58432069(3000L)) {
         if (this.Ii_field_49 >= 3) {
            IiiIIiIi_Class102.Nested1_6cef9133 var3 = this.I_field_7865b31.get(this.i_field_49);
            iIIIIIIii_Class260.i_method_70898627(
               Text.of(
                  IiiIIiIi_Class102.I_method_dcb516f8(var3)
                     + ": \u0430\u0443\u043a\u0446\u0438\u043e\u043d \u043d\u0435 \u043e\u0442\u043a\u0440\u044b\u043b\u0441\u044f \u043f\u043e \u0437\u0430\u043f\u0440\u043e\u0441\u0443 \u00ab"
                     + this.I_method_97c862d8(var3)
                     + "\u00bb \u2014 \u043f\u0440\u043e\u043f\u0443\u0441\u043a\u0430\u044e"
               )
            );
            this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.iI_field_b0d3b1dc;
            this.I_field_991c1e8c.I_method_23e11e3f();
         } else {
            this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.i_field_b0d3b1dc;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void iI_method_68e59c55() {
      if (I_field_3a9bda27.currentScreen instanceof HandledScreen var1 && IiiiiIIii_Class244.II_method_6da14e50(var1.getTitle().getString())) {
         if (this.I_field_991c1e8c.I_method_58432069(200L)) {
            this.I_method_6588ae0c(var1);
            this.II_field_49++;
            if (this.II_field_49 >= 4) {
               this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.iI_field_b0d3b1dc;
               this.I_field_991c1e8c.I_method_23e11e3f();
            } else {
               I_field_3a9bda27.interactionManager.clickSlot(var1.getScreenHandler().syncId, 49, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      } else {
         this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.iI_field_b0d3b1dc;
      }
   }

   private void ii_method_68f42835() {
      if (this.I_field_991c1e8c.I_method_58432069(200L)) {
         this.IiI_method_7f04c1ec();
         this.i_field_49++;
         this.Ii_field_49 = 0;
         if (I_field_3a9bda27.currentScreen != null) {
            I_field_3a9bda27.player.closeHandledScreen();
         }

         this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.i_field_b0d3b1dc;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void III_method_7d41d1cc() {
      if (I_field_3a9bda27.currentScreen != null) {
         I_field_3a9bda27.player.closeHandledScreen();
      }

      this.I_field_b0d3b1dc = IiiIIiii_Class104.Nested1_6cfe1cf3.I_field_b0d3b1dc;
   }

   private void IIi_method_7d505dac() {
      iIIIIIIii_Class260.I_method_468cf607(Text.of("\u0426\u0435\u043d\u044b \u0440\u044b\u043d\u043a\u0430 (\u0437\u0430 1 \u0448\u0442):"));

      for (IiiIIiIi_Class102.Nested1_6cef9133 var2 : this.I_field_7865b31) {
         String var3 = IiiIIiIi_Class102.I_method_dcb516f8(var2);
         long var4 = (long)this.II_field_a567c40b.getOrDefault(var2.i_method_29f1a539(), 0.0).doubleValue();
         if (var4 <= 0L) {
            iIIIIIIii_Class260.I_method_468cf607(
               Text.of(var3 + " \u2014 \u043d\u0435\u0442 \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0435\u043d\u0438\u0439")
            );
         } else {
            String var6 = var3 + " \u2014 \u0440\u044b\u043d\u043e\u043a " + iIIiiiiiI_Class319.I_method_10212adb(var4);
            if (var2.I_method_b49c50b() == IiiIIiIi_Class102.Nested1_6cef9113.i_field_af10c1bc) {
               long var7 = (long)(var4 * (1.0 - var2.I_method_18d43a55() / 100.0));
               var6 = var6
                  + ", \u0437\u0430\u043a\u0443\u043f\u043a\u0430 \u0434\u043e "
                  + iIIiiiiiI_Class319.I_method_10212adb(var7)
                  + " (-"
                  + (int)var2.I_method_18d43a55()
                  + "%)";
            }

            iIIIIIIii_Class260.I_method_468cf607(Text.of(var6));
         }
      }
   }

   private void I_method_6588ae0c(HandledScreen<?> var1) {
      IiiIIiIi_Class102.Nested1_6cef9133 var2 = this.I_field_7865b31.get(this.i_field_49);
      String var3 = var2.i_method_29f1a539();
      this.i_field_a567c40b.putIfAbsent(var3, new ArrayList<>());
      List var4 = this.i_field_a567c40b.get(var3);
      IiiiiIIii_Class244.Nested1_93558060 var5 = IiiiiIIii_Class244.I_method_d5e31775(var1, false, null);

      for (IiiiiIIii_Class244.Nested1_93558040 var7 : var5.I_method_b92233ad()) {
         if (IiiIIiIi_Class102.I_method_f3d9980e(var7.I_method_5a4ac7e(), var2)) {
            int var8 = Math.max(1, var7.i_method_1609374d());
            long var9 = var7.I_method_15faab6e() / var8;
            var4.add(var9);
         }
      }
   }

   private void IiI_method_7f04c1ec() {
      String var1 = this.I_field_7865b31.get(this.i_field_49).i_method_29f1a539();
      List var2 = this.i_field_a567c40b.get(var1);
      if (var2 != null && !var2.isEmpty()) {
         ArrayList var3 = new ArrayList(var2);
         var3.sort((left, right) -> ((Long)left).compareTo((Long)right));
         int var4 = Math.max(1, var3.size() / 2);
         List var5 = var3.subList(0, var4);
         int var8 = var5.size();
         double var6;
         if (var8 % 2 == 0) {
            var6 = ((Long)var5.get(var8 / 2 - 1) + (Long)var5.get(var8 / 2)) / 2.0;
         } else {
            var6 = ((Long)var5.get(var8 / 2)).longValue();
         }

         this.II_field_a567c40b.put(var1, var6);
      } else {
         this.II_field_a567c40b.put(var1, 0.0);
      }
   }

   public double I_method_4c1122c3(IiiiiIIii_Class244.Nested1_93558040 var1) {
      for (IiiIIiIi_Class102.Nested1_6cef9133 var3 : this.I_field_7865b31) {
         if (IiiIIiIi_Class102.I_method_f3d9980e(var1.I_method_5a4ac7e(), var3)) {
            return this.II_field_a567c40b.getOrDefault(var3.i_method_29f1a539(), 0.0);
         }
      }

      return 0.0;
   }

   public double I_method_1fdf3764(String var1) {
      return var1 == null ? 0.0 : this.II_field_a567c40b.getOrDefault(var1, 0.0);
   }

   public boolean I_method_97f860b0() {
      return this.I_field_b0d3b1dc == IiiIIiii_Class104.Nested1_6cfe1cf3.ii_field_b0d3b1dc;
   }

   public boolean i_method_9806ec90() {
      return this.I_field_b0d3b1dc == IiiIIiii_Class104.Nested1_6cfe1cf3.I_field_b0d3b1dc;
   }

   @Generated
   public IiiIIiii_Class104.Nested1_6cfe1cf3 I_method_26d7cbc6() {
      return this.I_field_b0d3b1dc;
   }

   public static enum Nested1_6cfe1cf3 {
      I_field_b0d3b1dc,
      i_field_b0d3b1dc,
      II_field_b0d3b1dc,
      Ii_field_b0d3b1dc,
      iI_field_b0d3b1dc,
      ii_field_b0d3b1dc;
   }
}
