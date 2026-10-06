package rockstar.client;

import com.google.gson.JsonElement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

public final class IIiiiIIIi_Class114 {
   static final Deque<IIiiiIIIi_Class114.Nested1_a18d080> I_field_db650847 = new ArrayDeque<>();
   static final Deque<IIiiiIIIi_Class114.Nested1_a18d080> i_field_db650847 = new ArrayDeque<>();
   static IIiiiIIIi_Class114.Nested1_39013fc9 I_field_1a69acc6;
   private static boolean I_field_5a;

   private IIiiiIIIi_Class114() {
   }

   public static void I_method_d0b91cc7(Setting var0) {
      if (!I_field_5a && var0 != null) {
         Screen var1 = I_method_c0d24dbb();
         if (var1 != null) {
            JsonElement var2;
            try {
               var2 = var0.toJson().deepCopy();
            } catch (RuntimeException var6) {
               return;
            }

            if (I_field_1a69acc6 != null) {
               I_field_1a69acc6.I_method_9a823ed8(var1, var0, var2);
            } else {
               long var3 = System.currentTimeMillis();
               IIiiiIIIi_Class114.Nested1_a18d080 var5 = I_field_db650847.peekFirst();
               if (var5 == null
                  || var5.I_method_76f9420() != var1
                  || var5.I_method_903c33cd().size() != 1
                  || var5.I_method_903c33cd().get(0).I_method_b80dac30() != var0
                  || var3 - var5.I_method_51ff832e() >= 350L) {
                  I_method_77cadd9f(
                     I_field_db650847, new IIiiiIIIi_Class114.Nested1_a18d080(var1, List.of(new IIiiiIIIi_Class114.Nested1_a18d0a0(var0, var2)), var3)
                  );
                  i_field_db650847.clear();
               }
            }
         }
      }
   }

   public static IIiiiIIIi_Class114.Nested1_39013fc9 I_method_fd3033bd() {
      return I_field_1a69acc6 == null ? new IIiiiIIIi_Class114.Nested1_39013fc9() : IIiiiIIIi_Class114.Nested1_39013fc9.I_field_1a69acc6;
   }

   public static boolean I_method_fe3ce603() {
      return I_method_fa6764d4(I_field_db650847, i_field_db650847, null);
   }

   public static boolean i_method_fe4b71e3() {
      return I_method_fa6764d4(i_field_db650847, I_field_db650847, null);
   }

   public static boolean I_method_d27c0ceb(IIiiiIIiI_Class115 var0) {
      return I_method_fa6764d4(I_field_db650847, i_field_db650847, var0 == null ? null : List.of(var0));
   }

   public static boolean i_method_6f95150b(IIiiiIIiI_Class115 var0) {
      return I_method_fa6764d4(i_field_db650847, I_field_db650847, var0 == null ? null : List.of(var0));
   }

   public static boolean I_method_84059a74(Collection<? extends IIiiiIIiI_Class115> var0) {
      return I_method_fa6764d4(I_field_db650847, i_field_db650847, var0);
   }

   public static boolean i_method_bf2ffe54(Collection<? extends IIiiiIIiI_Class115> var0) {
      return I_method_fa6764d4(i_field_db650847, I_field_db650847, var0);
   }

   public static boolean II_method_79242fc8(IIiiiIIiI_Class115 var0) {
      return I_method_23f2997(I_field_db650847, var0 == null ? null : List.of(var0));
   }

   public static boolean Ii_method_163d37e8(IIiiiIIiI_Class115 var0) {
      return I_method_23f2997(i_field_db650847, var0 == null ? null : List.of(var0));
   }

   public static boolean II_method_57206177(Collection<? extends IIiiiIIiI_Class115> var0) {
      return I_method_23f2997(I_field_db650847, var0);
   }

   public static boolean Ii_method_924ac557(Collection<? extends IIiiiIIiI_Class115> var0) {
      return I_method_23f2997(i_field_db650847, var0);
   }

   public static long I_method_d27c0cdb(IIiiiIIiI_Class115 var0) {
      return I_method_23f2987(I_field_db650847, var0 == null ? null : List.of(var0));
   }

   public static long i_method_6f9514fb(IIiiiIIiI_Class115 var0) {
      return I_method_23f2987(i_field_db650847, var0 == null ? null : List.of(var0));
   }

   private static boolean I_method_23f2997(Deque<IIiiiIIIi_Class114.Nested1_a18d080> var0, Collection<? extends IIiiiIIiI_Class115> var1) {
      Screen var2 = I_method_c0d24dbb();
      if (var2 == null) {
         return false;
      } else {
         for (IIiiiIIIi_Class114.Nested1_a18d080 var4 : var0) {
            if (var4.I_method_76f9420() == var2 && I_method_dbcfd257(var4, var1)) {
               return true;
            }
         }

         return false;
      }
   }

   private static long I_method_23f2987(Deque<IIiiiIIIi_Class114.Nested1_a18d080> var0, Collection<? extends IIiiiIIiI_Class115> var1) {
      Screen var2 = I_method_c0d24dbb();
      if (var2 == null) {
         return Long.MIN_VALUE;
      } else {
         for (IIiiiIIIi_Class114.Nested1_a18d080 var4 : var0) {
            if (var4.I_method_76f9420() == var2 && I_method_dbcfd257(var4, var1)) {
               return var4.I_method_51ff832e();
            }
         }

         return Long.MIN_VALUE;
      }
   }

   private static boolean I_method_fa6764d4(
      Deque<IIiiiIIIi_Class114.Nested1_a18d080> var0, Deque<IIiiiIIIi_Class114.Nested1_a18d080> var1, Collection<? extends IIiiiIIiI_Class115> var2
   ) {
      Screen var3 = I_method_c0d24dbb();
      if (var3 == null) {
         return false;
      } else {
         Iterator var4 = var0.iterator();

         while (var4.hasNext()) {
            IIiiiIIIi_Class114.Nested1_a18d080 var5 = (IIiiiIIIi_Class114.Nested1_a18d080)var4.next();
            if (var5.I_method_76f9420() == var3 && I_method_dbcfd257(var5, var2)) {
               var4.remove();
               ArrayList var6 = new ArrayList(var5.I_method_903c33cd().size());

               for (IIiiiIIIi_Class114.Nested1_a18d0a0 var8 : var5.I_method_903c33cd()) {
                  try {
                     var6.add(new IIiiiIIIi_Class114.Nested1_a18d0a0(var8.I_method_b80dac30(), var8.I_method_b80dac30().toJson().deepCopy()));
                  } catch (RuntimeException var13) {
                  }
               }

               boolean var15 = var6.size() != var5.I_method_903c33cd().size();

               for (int var16 = 0; !var15 && var16 < var6.size(); var16++) {
                  var15 = !((IIiiiIIIi_Class114.Nested1_a18d0a0)var6.get(var16))
                     .I_method_fbc10b33()
                     .equals(var5.I_method_903c33cd().get(var16).I_method_fbc10b33());
               }

               if (var15) {
                  I_field_5a = true;

                  try {
                     for (IIiiiIIIi_Class114.Nested1_a18d0a0 var9 : var5.I_method_903c33cd()) {
                        var9.I_method_b80dac30().fromJson(var9.I_method_fbc10b33().deepCopy());
                     }
                  } finally {
                     I_field_5a = false;
                  }

                  if (!var6.isEmpty()) {
                     I_method_77cadd9f(var1, new IIiiiIIIi_Class114.Nested1_a18d080(var3, var6, var5.I_method_51ff832e()));
                  }

                  return true;
               }
            }
         }

         return false;
      }
   }

   private static boolean I_method_dbcfd257(IIiiiIIIi_Class114.Nested1_a18d080 var0, Collection<? extends IIiiiIIiI_Class115> var1) {
      if (var1 == null) {
         return true;
      } else if (var1.isEmpty()) {
         return false;
      } else {
         for (IIiiiIIIi_Class114.Nested1_a18d0a0 var3 : var0.I_method_903c33cd()) {
            if (!(var3.I_method_b80dac30() instanceof AbstractSetting var4) || !var1.contains(var4.I_method_3ac66f15())) {
               return false;
            }
         }

         return true;
      }
   }

   static void I_method_77cadd9f(Deque<IIiiiIIIi_Class114.Nested1_a18d080> var0, IIiiiIIIi_Class114.Nested1_a18d080 var1) {
      var0.addFirst(var1);

      while (var0.size() > 100) {
         var0.removeLast();
      }
   }

   private static Screen I_method_c0d24dbb() {
      return MinecraftClient.getInstance().currentScreen;
   }

   public static final class Nested1_39013fc9 implements AutoCloseable {
      static final IIiiiIIIi_Class114.Nested1_39013fc9 I_field_1a69acc6 = new IIiiiIIIi_Class114.Nested1_39013fc9(true);
      private final IdentityHashMap<Setting, JsonElement> I_field_af8d717 = new IdentityHashMap<>();
      private Screen I_field_bf52cf84;
      private final boolean I_field_5a;
      private boolean i_field_5a;

      Nested1_39013fc9() {
         this(false);
         IIiiiIIIi_Class114.I_field_1a69acc6 = this;
      }

      private Nested1_39013fc9(boolean var1) {
         this.I_field_5a = var1;
      }

      void I_method_9a823ed8(Screen var1, Setting var2, JsonElement var3) {
         if (!this.I_field_5a && !this.i_field_5a && (this.I_field_bf52cf84 == null || this.I_field_bf52cf84 == var1)) {
            this.I_field_bf52cf84 = var1;
            this.I_field_af8d717.putIfAbsent(var2, var3);
         }
      }

      @Override
      public void close() {
         if (!this.I_field_5a && !this.i_field_5a) {
            this.i_field_5a = true;
            IIiiiIIIi_Class114.I_field_1a69acc6 = null;
            if (this.I_field_bf52cf84 != null && !this.I_field_af8d717.isEmpty()) {
               ArrayList var1 = new ArrayList(this.I_field_af8d717.size());

               for (Entry var3 : this.I_field_af8d717.entrySet()) {
                  var1.add(new IIiiiIIIi_Class114.Nested1_a18d0a0((Setting)var3.getKey(), (JsonElement)var3.getValue()));
               }

               IIiiiIIIi_Class114.I_method_77cadd9f(
                  IIiiiIIIi_Class114.I_field_db650847, new IIiiiIIIi_Class114.Nested1_a18d080(this.I_field_bf52cf84, var1, System.currentTimeMillis())
               );
               IIiiiIIIi_Class114.i_field_db650847.clear();
            }
         }
      }
   }

   static final class Nested1_a18d080 {
      private final Screen I_field_bf52cf84;
      private final List<IIiiiIIIi_Class114.Nested1_a18d0a0> I_field_7865b31;
      private final long I_field_4a;

      Nested1_a18d080(Screen var1, List<IIiiiIIIi_Class114.Nested1_a18d0a0> var2, long var3) {
         this.I_field_bf52cf84 = var1;
         this.I_field_7865b31 = var2;
         this.I_field_4a = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_a18d080[screen=" + this.I_field_bf52cf84 + ", snapshots=" + this.I_field_7865b31 + ", time=" + this.I_field_4a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_bf52cf84);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiiIIIi_Class114.Nested1_a18d080 other = (IIiiiIIIi_Class114.Nested1_a18d080) var1;
         return java.util.Objects.equals(this.I_field_bf52cf84, other.I_field_bf52cf84)
            && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a);
      }

      public Screen I_method_76f9420() {
         return this.I_field_bf52cf84;
      }

      public List<IIiiiIIIi_Class114.Nested1_a18d0a0> I_method_903c33cd() {
         return this.I_field_7865b31;
      }

      public long I_method_51ff832e() {
         return this.I_field_4a;
      }
   }

   static final class Nested1_a18d0a0 {
      private final Setting I_field_ba11c26c;
      private final JsonElement I_field_8d18826f;

      Nested1_a18d0a0(Setting var1, JsonElement var2) {
         this.I_field_ba11c26c = var1;
         this.I_field_8d18826f = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_a18d0a0[setting=" + this.I_field_ba11c26c + ", value=" + this.I_field_8d18826f + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_ba11c26c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_8d18826f);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiiIIIi_Class114.Nested1_a18d0a0 other = (IIiiiIIIi_Class114.Nested1_a18d0a0) var1;
         return java.util.Objects.equals(this.I_field_ba11c26c, other.I_field_ba11c26c)
            && java.util.Objects.equals(this.I_field_8d18826f, other.I_field_8d18826f);
      }

      public Setting I_method_b80dac30() {
         return this.I_field_ba11c26c;
      }

      public JsonElement I_method_fbc10b33() {
         return this.I_field_8d18826f;
      }
   }
}
