package rockstar.client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map.Entry;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;
import pyrock.events.player.ClientPlayerTickEvent;
import ua.mintantileak.spk.Compile;

public class IIiiIIii_Class52 implements iIIiIIiIi_Class294 {
   private final Queue<IIiiIIii_Class52.Nested1_7f74b4f3> I_field_f2700bf6 = new ArrayDeque<>();
   private IIiiIIii_Class52.Nested1_7f74b4f3 I_field_ed3019dc;
   private boolean I_field_5a;
   private int I_field_49 = -1;
   private int i_field_49;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_5a && this.I_field_ed3019dc != null && I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         Integer var2 = this.I_method_dcabfc6f(this.I_field_ed3019dc.I_field_ed3015fc);
         if (var2 != null && var2 == this.I_field_ed3019dc.I_method_d2af6e9a()) {
            int var3 = I_field_3a9bda27.getNetworkHandler().getPlayerList().size();
            if (var3 < 30) {
               this.i_method_2edac8ac();
            } else {
               if (var3 == this.I_field_49) {
                  this.i_field_49++;
               } else {
                  this.i_field_49 = 0;
                  this.I_field_49 = var3;
               }

               if (this.i_field_49 >= 20) {
                  this.I_method_6f3ce62f(this.I_field_ed3019dc.I_field_ed3015fc, this.I_field_ed3019dc.I_method_d2af6e9a());
                  this.I_method_2ecc3ccc();
               }
            }
         }
      }
   };

   public IIiiIIii_Class52() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public IIIiiIIi_Class26 I_method_1218e3ab() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "parse",
            var1 -> var1.I_method_b3f941e4("parser")
               .i_method_cfe1a061("commands.parse.description")
               .i_method_3d6e11d9("args", var0 -> var0.I_method_e930dfcb().i_method_132d6feb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a))
               .I_method_16f05c8a(this::I_method_e306b74d)
         )
         .I_method_9111538b();
   }

   @Compile
   private void I_method_e306b74d(IIIiiIii_Class28 var1) {
      List var2 = var1.I_method_557e5bfb().isEmpty() ? Collections.emptyList() : this.I_method_865c3b9f(var1.I_method_557e5bfb().getFirst());
      IIiiIIii_Class52.Nested1_7f74b4d3 var3 = IIiiIIii_Class52.Nested1_7f74b4d3.I_field_ed3015fc;
      ArrayList var4 = new ArrayList();
      if (!var2.isEmpty()) {
         IIiiIIii_Class52.Nested1_7f74b4d3 var5 = IIiiIIii_Class52.Nested1_7f74b4d3.I_method_9855a0a1((String)var2.getFirst());
         int var6 = 0;
         if (var5 != null) {
            var3 = var5;
            var6++;
         }

         for (int var7 = var6; var7 < var2.size(); var7++) {
            Integer var8 = this.I_method_1aba713d((String)var2.get(var7));
            if (var8 == null) {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of("Invalid server number: " + (String)var2.get(var7)));
               return;
            }

            var4.add(var8);
         }
      }

      if (!var4.isEmpty()) {
         this.I_method_1a9f9c39(var3, var4);
      } else {
         this.I_method_6f3ce62f(this.I_method_214dafca(var3), null);
      }
   }

   private List<String> I_method_865c3b9f(Object var1) {
      return var1 == null ? Collections.emptyList() : (List)var1;
   }

   private Integer I_method_1aba713d(String var1) {
      try {
         int var2 = Integer.parseInt(var1);
         return var2 > 0 ? var2 : null;
      } catch (Exception var3) {
         return null;
      }
   }

   private void I_method_1a9f9c39(IIiiIIii_Class52.Nested1_7f74b4d3 var1, List<Integer> var2) {
      if (this.I_field_5a) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of("Parser already running"));
      } else {
         this.I_field_f2700bf6.clear();
         IIiiIIii_Class52.Nested1_7f74b4d3 var3 = this.I_method_214dafca(var1);

         for (Integer var5 : var2) {
            this.I_field_f2700bf6.add(new IIiiIIii_Class52.Nested1_7f74b4f3(var3, var5));
         }

         this.I_field_5a = true;
         this.I_field_ed3019dc = null;
         this.I_method_2ecc3ccc();
      }
   }

   private void I_method_2ecc3ccc() {
      this.I_field_ed3019dc = this.I_field_f2700bf6.poll();
      this.i_method_2edac8ac();
      if (this.I_field_ed3019dc == null) {
         this.I_field_5a = false;
         iIIIIIIii_Class260.I_method_468cf607(Text.of("\u0412\u044b\u0434\u043e\u0445\u0441\u044f \u0438 \u0437\u0430\u043a\u043e\u043d\u0447\u0438\u043b."));
      } else {
         this.I_method_4f172b28(this.I_field_ed3019dc);
      }
   }

   private void I_method_4f172b28(IIiiIIii_Class52.Nested1_7f74b4f3 var1) {
      String var2 = RockstarClient.getInstance().I_method_b4d046cb().I_method_80ea594();
      StringBuilder var3 = new StringBuilder(var2).append("rct");
      if (var1.I_field_ed3015fc != IIiiIIii_Class52.Nested1_7f74b4d3.I_field_ed3015fc) {
         var3.append(" ").append(var1.I_field_ed3015fc.I_method_ee8ba0b9());
      }

      var3.append(" ").append(var1.I_field_49);
      RockstarClient.getInstance().I_method_b4d046cb().I_method_9e86975a(var3.toString());
   }

   private void i_method_2edac8ac() {
      this.I_field_49 = -1;
      this.i_field_49 = 0;
   }

   private void I_method_6f3ce62f(IIiiIIii_Class52.Nested1_7f74b4d3 var1, Integer var2) {
      if (I_field_3a9bda27.isInSingleplayer()) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of("\u0422\u044b \u0435\u0431\u043b\u0430\u043d ?"));
      } else if (I_field_3a9bda27.getNetworkHandler() != null && I_field_3a9bda27.getNetworkHandler().getServerInfo() != null) {
         File var3 = new File(IiIIiIII_Class73.I_field_3a58077, "parser");
         if (!var3.exists() && !var3.mkdirs()) {
            iIIIIIIii_Class260.II_method_e8fd4864(
               Text.of("\u0429\u0430 \u043f\u043e\u0434\u043e\u0436\u0434\u0438 \u043f\u0430\u043f\u043a\u0443 \u0441\u043e\u0437\u0434\u0430\u043c")
            );
         } else {
            String var4 = this.I_method_f2b387ca(I_field_3a9bda27.getNetworkHandler().getServerInfo().address);
            String var5 = this.I_method_e16e5251(var1, var2);
            File var6 = new File(new File(var3, var4), var5);
            if (!var6.exists() && !var6.mkdirs()) {
               iIIIIIIii_Class260.II_method_e8fd4864(
                  Text.of(
                     "\u041e\u0448\u0438\u0431\u043a\u0430 \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u043f\u0430\u043f\u043a\u0438 \u0430\u043d\u043a\u0438"
                  )
               );
            } else {
               Map var7 = this.I_method_ce615cf2(I_field_3a9bda27.getNetworkHandler().getPlayerList());
               if (var7.isEmpty()) {
                  iIIIIIIii_Class260.II_method_e8fd4864(
                     Text.of(
                        "\u0421\u0435\u0440\u0432\u0435\u0440 \u0438\u0441\u0441\u0443\u0435 \u043b\u0430\u0433\u0430\u0435\u0442 0 \u0442\u043f\u0441 \u0441\u0435\u0440\u0432\u0435\u0440 \u0447\u0442\u043e\u043b\u0435"
                     )
                  );
               } else {
                  try {
                     this.I_method_c1c0f143(var6);
                     this.I_method_199ddbe2(var6, var7);
                     iIIIIIIii_Class260.I_method_468cf607(
                        Text.of(
                           "\u0421\u043f\u0430\u0440\u0441\u0438\u043b "
                              + var7.values().stream().mapToInt(value -> ((List<?>)value).size()).sum()
                              + " \u0438\u0433\u0440\u043e\u043a\u043e\u0432"
                        )
                     );
                  } catch (Exception var9) {
                     iIIIIIIii_Class260.II_method_e8fd4864(Text.of("Save error: " + var9.getMessage()));
                  }
               }
            }
         }
      } else {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of("\u0421\u0435\u0440\u0432\u0435\u0440 \u043a\u0430\u043b\u043b"));
      }
   }

   private Map<String, List<String>> I_method_ce615cf2(Collection<PlayerListEntry> var1) {
      TreeMap<String, List<String>> var2 = new TreeMap<>();

      for (PlayerListEntry var4 : var1) {
         if (var4.getScoreboardTeam() != null) {
            String var5 = var4.getScoreboardTeam().getPrefix().getString().trim();
            if (var5.isBlank()) {
               var5 = "\u0411\u0435\u0437\u0414\u043e\u043d\u0430\u0442\u0430";
            }

            var2.computeIfAbsent(var5, var0 -> new ArrayList<>()).add(var4.getProfile().getName());
         }
      }

      return var2;
   }

   private void I_method_c1c0f143(File var1) throws IOException {
      File[] var2 = var1.listFiles((var0, var1x) -> var1x.endsWith(".txt"));
      if (var2 != null) {
         for (File var6 : var2) {
            if (!var6.delete()) {
               throw new IOException("Failed delete " + var6.getName());
            }
         }
      }
   }

   private void I_method_199ddbe2(File var1, Map<String, List<String>> var2) throws IOException {
      for (Entry var4 : var2.entrySet()) {
         File var5 = new File(var1, this.I_method_f2b387ca(this.i_method_12d26fea((String)var4.getKey())) + ".txt");

         try (FileWriter var6 = new FileWriter(var5)) {
            for (String var8 : (Iterable<String>)(Iterable<?>)(List)var4.getValue()) {
               var6.write(var8 + "\n");
            }
         }
      }
   }

   private String I_method_e16e5251(IIiiIIii_Class52.Nested1_7f74b4d3 var1, Integer var2) {
      int var3 = var2 != null ? var2 : Optional.ofNullable(this.I_method_dcabfc6f(var1)).orElse(-1);
      return var1.i_method_81aa50d9() + (var3 > 0 ? var3 : "unknown");
   }

   private String I_method_f2b387ca(String var1) {
      return var1.replace(':', '_').replaceAll("[\\\\/:*?\"<>|]", "_");
   }

   private String i_method_12d26fea(String var1) {
      return var1.replace("[", "").replace("]", "").trim().replaceAll("\\s+", "_").toLowerCase();
   }

   private IIiiIIii_Class52.Nested1_7f74b4d3 I_method_214dafca(IIiiIIii_Class52.Nested1_7f74b4d3 var1) {
      if (var1 != IIiiIIii_Class52.Nested1_7f74b4d3.I_field_ed3015fc) {
         return var1;
      } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c)) {
         return IIiiIIii_Class52.Nested1_7f74b4d3.II_field_ed3015fc;
      } else {
         return (
                  iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)
                     || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)
               )
               && iIIIiiiII_Class285.i_field_5a
            ? IIiiIIii_Class52.Nested1_7f74b4d3.II_field_ed3015fc
            : IIiiIIii_Class52.Nested1_7f74b4d3.i_field_ed3015fc;
      }
   }

   private Integer I_method_dcabfc6f(IIiiIIii_Class52.Nested1_7f74b4d3 var1) {
      return switch (var1) {
         case i_field_ed3015fc -> iIIIiiiII_Class285.i_field_49;
         case II_field_ed3015fc -> iIIIiiiII_Class285.Ii_field_49;
         default -> null;
      };
   }

   static enum Nested1_7f74b4d3 {
      I_field_ed3015fc("auto", "an"),
      i_field_ed3015fc("an", "an"),
      II_field_ed3015fc("grief", "grif");

      private final String I_field_523beb0a;
      private final String i_field_523beb0a;

      private Nested1_7f74b4d3(String var3, String var4) {
         this.I_field_523beb0a = var3;
         this.i_field_523beb0a = var4;
      }

      public String I_method_ee8ba0b9() {
         return this.I_field_523beb0a;
      }

      public String i_method_81aa50d9() {
         return this.i_field_523beb0a;
      }

      @Compile
      public static IIiiIIii_Class52.Nested1_7f74b4d3 I_method_9855a0a1(String var0) {
         if (var0 == null) {
            return null;
         } else {
            var0 = var0.toLowerCase();
            if (var0.startsWith("an")) {
               return i_field_ed3015fc;
            } else {
               return var0.startsWith("gr") ? II_field_ed3015fc : null;
            }
         }
      }
   }

   static final class Nested1_7f74b4f3 {
      final IIiiIIii_Class52.Nested1_7f74b4d3 I_field_ed3015fc;
      final int I_field_49;

      Nested1_7f74b4f3(IIiiIIii_Class52.Nested1_7f74b4d3 var1, int var2) {
         this.I_field_ed3015fc = var1;
         this.I_field_49 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_7f74b4f3[mode=" + this.I_field_ed3015fc + ", number=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_ed3015fc);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiIIii_Class52.Nested1_7f74b4f3 other = (IIiiIIii_Class52.Nested1_7f74b4f3) var1;
         return java.util.Objects.equals(this.I_field_ed3015fc, other.I_field_ed3015fc)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public IIiiIIii_Class52.Nested1_7f74b4d3 I_method_e86f3d0b() {
         return this.I_field_ed3015fc;
      }

      public int I_method_d2af6e9a() {
         return this.I_field_49;
      }
   }
}
