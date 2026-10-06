package rockstar.client;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import pyrock.events.game.WorldChangeEvent;

public class IIIIIIIi_Class2 {
   private static IIIIIIIi_Class2 I_field_415f4b61;
   private final Map<String, iiiiiii_Class128> I_field_a567c40b = new ConcurrentHashMap<>();
   private final IIIIIIii_Class4 I_field_415fc381 = new IIIIIIii_Class4();
   private final Map<String, IIIIIIIi_Class2.Nested1_e67924f3> i_field_a567c40b = new ConcurrentHashMap<>();
   private final Set<String> I_field_a56a8dc5 = ConcurrentHashMap.newKeySet();
   private final Map<String, Long> II_field_a567c40b = new ConcurrentHashMap<>();
   private final Pattern I_field_5fd3861f = Pattern.compile("(?:(?:\u0431\u0430\u043b\u0430\u043d\u0441)|balance)\\s*[:=]?\\s*\\$?\\s*([\\d\\s.,]+)", 66);
   private final ScheduledExecutorService I_field_47254ffa = Executors.newScheduledThreadPool(2, new ThreadFactory() {
      private int I_field_49;

      @Override
      public synchronized Thread newThread(Runnable var1) {
         Thread var2 = new Thread(var1, "Rockstar-BotManager-" + ++this.I_field_49);
         var2.setDaemon(true);
         return var2;
      }
   });
   private long I_field_4a;
   private boolean I_field_5a = true;
   private volatile iiiiiii_Class128 I_field_c2f1c7cc;
   private final IiIIIiII_Class69<WorldChangeEvent> I_field_3d936f41 = var1 -> this.II_method_1bd9b435();

   private IIIIIIIi_Class2() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public static IIIIIIIi_Class2 I_method_70b3dfcb() {
      if (I_field_415f4b61 == null) {
         I_field_415f4b61 = new IIIIIIIi_Class2();
      }

      return I_field_415f4b61;
   }

   public iiiiiii_Class128 I_method_cb3796ec(String var1) {
      IIIIIIIi_Class2.Nested1_e6792513 var2 = this.I_method_133acfa6();
      return var2 == null ? null : this.I_method_9e1ed3b9(var1, var2.I_method_ba0260f9(), var2.I_method_838c127a());
   }

   public iiiiiii_Class128 I_method_9e1ed3b9(String var1, String var2, int var3) {
      if (var1 != null && !var1.isBlank() && var2 != null && !var2.isBlank()) {
         String var4 = this.I_method_8302dfea(var1);
         if (this.I_field_a567c40b.containsKey(var4)) {
            return null;
         } else {
            IIIIIIii_Class4 var5 = new IIIIIIii_Class4();
            var5.I_method_4d38374d(this.I_field_415fc381);
            iiiiiii_Class128 var6 = new iiiiiii_Class128(var1, var5);
            String var7 = var2.trim();
            var6.I_method_8e4568d5()
               .i_method_46ae1315(
                  var2x -> {
                     if (this.I_field_415fc381.II_method_17ff5019()) {
                        RockstarClient.getInstance()
                           .I_method_5cb1af22()
                           .I_method_67864747(
                              new iiiIIIi_Class114(
                                 iiiIIII_Class113.I_field_c11fcfcc,
                                 IiIiIIII_Class81.I_method_f25a980a("bot.notification.title"),
                                 IiIiIIII_Class81.I_method_1410d1e5("bot.notification.connected", var1)
                              )
                           );
                     }
                  }
               );
            var6.I_method_8e4568d5()
               .I_method_8bb692f5(
                  var3x -> {
                     RockstarClient.I_field_ab0f6068.error("Bot {} error: {}", var1, var3x);
                     this.I_field_a567c40b.remove(var4);
                     if (this.I_field_415fc381.II_method_17ff5019()) {
                        RockstarClient.getInstance()
                           .I_method_5cb1af22()
                           .I_method_67864747(
                              new iiiIIIi_Class114(
                                 iiiIIII_Class113.i_field_c11fcfcc,
                                 IiIiIIII_Class81.I_method_f25a980a("bot.notification.title"),
                                 IiIiIIII_Class81.I_method_1410d1e5("bot.notification.error", var1, var3x)
                              )
                           );
                     }
                  }
               );
            var6.I_method_8e4568d5()
               .II_method_813cdb52(
                  var4x -> {
                     this.I_field_a567c40b.remove(var4);
                     if (var6.iI_method_18a6b2e6() && !var6.ii_method_18b53ec6()) {
                        this.I_method_cef7ef9a(var6);
                     }

                     if (this.I_field_415fc381.II_method_17ff5019()) {
                        RockstarClient.getInstance()
                           .I_method_5cb1af22()
                           .I_method_67864747(
                              new iiiIIIi_Class114(
                                 iiiIIII_Class113.i_field_c11fcfcc,
                                 IiIiIIII_Class81.I_method_f25a980a("bot.notification.title"),
                                 IiIiIIII_Class81.I_method_1410d1e5("bot.notification.disconnected", var1)
                              )
                           );
                     }
                  }
               );
            this.I_field_a567c40b.put(var4, var6);
            var6.I_method_68c7979a(var7, var3);
            return var6;
         }
      } else {
         return null;
      }
   }

   public void I_method_1f192f76(String var1) {
      String var2 = this.I_method_8302dfea(var1);
      this.I_field_a56a8dc5.remove(var2);
      this.II_field_a567c40b.remove(var2);
      iiiiiii_Class128 var3 = this.I_field_a567c40b.remove(var2);
      if (var3 != null) {
         var3.I_method_9da3c47f();
      }
   }

   public void I_method_6c4058ac() {
      for (iiiiiii_Class128 var2 : this.I_field_a567c40b.values()) {
         var2.I_method_9da3c47f();
      }

      this.I_field_a567c40b.clear();
   }

   public Optional<iiiiiii_Class128> I_method_ad974b8f(String var1) {
      return Optional.ofNullable(this.I_field_a567c40b.get(this.I_method_8302dfea(var1)));
   }

   public Collection<iiiiiii_Class128> I_method_350a479b() {
      return Collections.unmodifiableCollection(this.I_field_a567c40b.values());
   }

   public int I_method_6c40589f() {
      return this.I_field_a567c40b.size();
   }

   public void i_method_6c4ee48c() {
      if (this.I_field_c2f1c7cc != null && !this.I_field_c2f1c7cc.Ii_method_16f24ea6()) {
         this.II_method_1bd9b439();
      }

      for (iiiiiii_Class128 var2 : this.I_field_a567c40b.values()) {
         var2.i_method_9db2505f();
      }

      this.ii_method_1dab3035();
      this.Ii_method_1be84015();
      this.iI_method_1d9ca455();
   }

   public void II_method_1bd9b435() {
      this.II_method_1bd9b439();
      this.I_method_6c4058ac();
   }

   public void I_method_8c13b5c8(Consumer<iiiiiii_Class128> var1) {
      this.I_field_a567c40b.values().forEach(var1);
   }

   public void i_method_470b35e8(Consumer<iiiiiii_Class128> var1) {
      this.I_field_a567c40b.values().stream().filter(iiiiiii_Class128::Ii_method_16f24ea6).forEach(var1);
   }

   public void I_method_1bcb6fa8(boolean var1) {
      this.I_field_415fc381.Ii_method_e9ae557f(var1);
   }

   public boolean I_method_6c4058b0() {
      return this.I_field_415fc381.Ii_method_180ddbf9();
   }

   public void i_method_1d8e5fc8(boolean var1) {
      this.I_field_415fc381.iI_method_1e86793f(var1);
      this.I_field_4a = System.currentTimeMillis();
      this.I_field_5a = true;
   }

   public boolean i_method_6c4ee490() {
      return this.I_field_415fc381.iI_method_19c24039();
   }

   public void i_method_efd08356(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.I_field_415fc381.Ii_method_2741d27f(var1.trim());
      }
   }

   public void I_method_1bcb2fd7(int var1) {
      if (var1 > 0) {
         this.I_field_415fc381.iIi_method_b5c66298(TimeUnit.MINUTES.toMillis(var1));
      }
   }

   public void II_method_1b601abf(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.I_field_415fc381.II_method_568a7e9f(var1);
      }
   }

   public void Ii_method_ec176e9f(String var1) {
      this.I_method_ad974b8f(var1).ifPresent(var0 -> var0.I_method_b8ab1d60(new IIIIiiIi_Class14()));
   }

   public boolean I_method_1f192f7a(String var1) {
      Optional var2 = this.I_method_ad974b8f(var1);
      if (!var2.isEmpty() && ((iiiiiii_Class128)var2.get()).Ii_method_16f24ea6()) {
         this.II_method_1bd9b439();
         this.I_field_c2f1c7cc = (iiiiiii_Class128)var2.get();
         this.I_field_c2f1c7cc.I_method_b8ab1d60(new IIIIiiIi_Class14());
         if (!this.I_field_c2f1c7cc.I_method_1729df78().I_method_56b325f7(MinecraftClient.getInstance())) {
            this.I_field_c2f1c7cc = null;
            return false;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean II_method_1bd9b439() {
      if (this.I_field_c2f1c7cc == null) {
         return false;
      } else {
         this.I_field_c2f1c7cc.I_method_1729df78().I_method_56b325f3(MinecraftClient.getInstance());
         this.I_field_c2f1c7cc = null;
         return true;
      }
   }

   public Optional<iiiiiii_Class128> I_method_b088ba99() {
      return Optional.ofNullable(this.I_field_c2f1c7cc);
   }

   public boolean i_method_efd0835a(String var1) {
      Optional var2 = this.I_method_ad974b8f(var1);
      return !var2.isEmpty() && ((iiiiiii_Class128)var2.get()).Ii_method_16f24ea6() ? this.I_field_a56a8dc5.add(this.I_method_8302dfea(var1)) : false;
   }

   public boolean II_method_1b601ac3(String var1) {
      String var2 = this.I_method_8302dfea(var1);
      this.II_field_a567c40b.remove(var2);
      return this.I_field_a56a8dc5.remove(var2);
   }

   public boolean Ii_method_ec176ea3(String var1) {
      return this.I_field_a56a8dc5.contains(this.I_method_8302dfea(var1));
   }

   public void I_method_8219a7c0(String var1, String var2) {
      if (var1 != null && var2 != null && !var2.isBlank()) {
         this.i_field_a567c40b.put(this.I_method_8302dfea(var1), new IIIIIIIi_Class2.Nested1_e67924f3(var1, var2));
      }
   }

   public boolean I_method_ebbe26e8(iiiiiii_Class128 var1, String var2) {
      if (var1 != null && var2 != null) {
         IIIIIIIi_Class2.Nested1_e67924f3 var3 = this.i_field_a567c40b.get(this.I_method_8302dfea(var1.I_method_7b75de01()));
         if (var3 == null) {
            return false;
         } else {
            Long var4 = this.I_method_14852edf(var2);
            if (var4 == null) {
               return false;
            } else {
               this.i_field_a567c40b.remove(this.I_method_8302dfea(var1.I_method_7b75de01()));
               if (var4 > 0L && !var3.i_method_6ede8f9().equalsIgnoreCase(var1.I_method_7b75de01())) {
                  this.I_field_47254ffa.schedule(() -> var1.I_method_98066c89("/pay " + var3.i_method_6ede8f9() + " " + var4), 5L, TimeUnit.SECONDS);
                  return true;
               } else {
                  return true;
               }
            }
         }
      } else {
         return false;
      }
   }

   public static IIIIIIIi_Class2.Nested1_e6792513 I_method_1a7c0a9c(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.trim();
         int var2 = 25565;
         int var3 = var1.lastIndexOf(58);
         if (var3 > 0 && var3 < var1.length() - 1) {
            try {
               var2 = Integer.parseInt(var1.substring(var3 + 1));
               var1 = var1.substring(0, var3);
            } catch (NumberFormatException var5) {
            }
         }

         return !var1.isBlank() && var2 >= 1 && var2 <= 65535 ? new IIIIIIIi_Class2.Nested1_e6792513(var1, var2) : null;
      } else {
         return null;
      }
   }

   private void Ii_method_1be84015() {
      if (this.I_field_415fc381.Ii_method_180ddbf9()) {
         long var1 = System.currentTimeMillis();
         this.i_method_470b35e8(var3 -> {
            if (var3.I_method_16d54229(var1)) {
               var3.I_method_98066c89(this.I_field_415fc381.Ii_method_98dae14b());
               var3.I_method_16d54225(var1);
            }
         });
      }
   }

   private void iI_method_1d9ca455() {
      if (this.I_field_415fc381.iI_method_19c24039()) {
         long var1 = System.currentTimeMillis();
         if (var1 - this.I_field_4a >= this.I_field_415fc381.iiI_method_2057ade0()) {
            this.I_field_4a = var1;
            double var3 = this.I_field_415fc381.IIIiI_method_d3d8bb1a() * (this.I_field_5a ? 1.0 : -1.0);
            this.i_method_470b35e8(var2 -> var2.I_method_16d52b9f(var3));
            this.I_field_5a = !this.I_field_5a;
         }
      }
   }

   private void ii_method_1dab3035() {
      if (!this.I_field_a56a8dc5.isEmpty()) {
         long var1 = System.currentTimeMillis();
         this.I_field_a56a8dc5.removeIf(var3 -> {
            iiiiiii_Class128 var4 = this.I_field_a567c40b.get(var3);
            if (var4 != null && var4.Ii_method_16f24ea6()) {
               long var5 = this.II_field_a567c40b.getOrDefault(var3, 0L);
               if (var1 - var5 >= var4.I_method_e08ecf78().iI_method_19c24029()) {
                  var4.I_method_9da3c483();
                  this.II_field_a567c40b.put(var3, var1);
               }

               return false;
            } else {
               this.II_field_a567c40b.remove(var3);
               return true;
            }
         });
      }
   }

   private void I_method_cef7ef9a(iiiiiii_Class128 var1) {
      if (var1.i_method_e948e21() != null) {
         long var2 = Math.max(50L, var1.I_method_9da3c472() * 50L);
         this.I_field_47254ffa.schedule(() -> {
            if (!this.I_field_a567c40b.containsKey(this.I_method_8302dfea(var1.I_method_7b75de01()))) {
               iiiiiii_Class128 var2x = this.I_method_9e1ed3b9(var1.I_method_7b75de01(), var1.i_method_e948e21(), var1.i_method_9db25052());
               if (var2x != null) {
                  var2x.iI_method_fc305c32(true);
                  var2x.II_method_c5950881(var1.I_method_9da3c472());
               }
            }
         }, var2, TimeUnit.MILLISECONDS);
      }
   }

   private IIIIIIIi_Class2.Nested1_e6792513 I_method_133acfa6() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      return var1.getNetworkHandler() != null && var1.getCurrentServerEntry() != null ? I_method_1a7c0a9c(var1.getCurrentServerEntry().address) : null;
   }

   private Long I_method_14852edf(String var1) {
      Matcher var2 = this.I_field_5fd3861f.matcher(var1);
      if (!var2.find()) {
         return null;
      } else {
         String var3 = var2.group(1);
         if (var3 == null) {
            return null;
         } else {
            var3 = var3.replaceAll("[^0-9]", "");
            if (var3.isEmpty()) {
               return null;
            } else {
               try {
                  return Long.parseLong(var3);
               } catch (NumberFormatException var5) {
                  return null;
               }
            }
         }
      }
   }

   private String I_method_8302dfea(String var1) {
      return var1 == null ? "" : var1.trim().toLowerCase(Locale.ROOT);
   }

   @Generated
   public Map<String, iiiiiii_Class128> I_method_3de3cde1() {
      return this.I_field_a567c40b;
   }

   @Generated
   public IIIIIIii_Class4 I_method_70b457eb() {
      return this.I_field_415fc381;
   }

   static final class Nested1_e67924f3 {
      private final String I_field_523beb0a;
      private final String i_field_523beb0a;

      Nested1_e67924f3(String var1, String var2) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_e67924f3[botName=" + this.I_field_523beb0a + ", targetPlayer=" + this.i_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIIIIIi_Class2.Nested1_e67924f3 other = (IIIIIIIi_Class2.Nested1_e67924f3) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a);
      }

      public String I_method_73cf38d9() {
         return this.I_field_523beb0a;
      }

      public String i_method_6ede8f9() {
         return this.i_field_523beb0a;
      }
   }

   public static final class Nested1_e6792513 {
      private final String I_field_523beb0a;
      private final int I_field_49;

      public Nested1_e6792513(String var1, int var2) {
         this.I_field_523beb0a = var1;
         this.I_field_49 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_e6792513[address=" + this.I_field_523beb0a + ", port=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIIIIIi_Class2.Nested1_e6792513 other = (IIIIIIIi_Class2.Nested1_e6792513) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public String I_method_ba0260f9() {
         return this.I_field_523beb0a;
      }

      public int I_method_838c127a() {
         return this.I_field_49;
      }
   }
}
