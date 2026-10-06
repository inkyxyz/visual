package rockstar.client;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;
import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.math.Vec3d;
import pyrock.utility.render.ColorRGBA;

public class IiIiiiiii_Class192 extends IiIiiiIiI_Class187 implements iIIiIIiIi_Class294 {
   private final Pattern I_field_5fd3861f = Pattern.compile("(\\d{1,2}):(\\d{2})");
   private IiIiiiiii_Class192.Nested1_218ee029 I_field_43901866;
   private long I_field_4a;
   private Vec3d I_field_5bba0d50;
   private IiIiiiiii_Class192.Nested1_218ee029 i_field_43901866;
   private boolean I_field_5a;

   public IiIiiiiii_Class192(MultiSelectSetting var1) {
      super(var1, "mine");
   }

   @Override
   public final void prepare(IiIiiIIII_Class177 var1) {
      if (!this.I_method_f9e3ee63()) {
         this.I_field_5a = false;
         super.prepare(var1);
      } else {
         IiIiiiiii_Class192.Nested1_218ee029 var2 = this.I_method_a62cf2fd();
         if (var2 == null) {
            var2 = this.I_method_13eb761a(this.I_method_e41961e6(iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c)));
         }

         if (var2 == null) {
            super.prepare(var1);
         } else {
            this.I_method_44ddbec5(
               var2.i_method_2d6c6104() + ":",
               "",
               var2.II_method_7e6bc843(),
               var2.I_method_95b708a2().I_method_b36d9066(),
               var2.I_method_95b708a2().I_method_182805e9()
            );
            super.prepare(var1);
         }
      }
   }

   @Override
   public final boolean canShow() {
      this.I_field_5a = false;
      if (!this.I_method_f9e3ee63()) {
         return false;
      } else {
         IiIiiiiii_Class192.Nested1_218ee029 var1 = this.I_method_13eb761a(
            this.I_method_e41961e6(iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c))
         );
         this.i_field_43901866 = var1;
         this.I_field_5a = true;
         return var1 != null;
      }
   }

   private IiIiiiiii_Class192.Nested1_218ee029 I_method_a62cf2fd() {
      if (!this.I_field_5a) {
         return null;
      } else {
         this.I_field_5a = false;
         return this.i_field_43901866;
      }
   }

   private boolean I_method_f9e3ee63() {
      return I_field_3a9bda27.world != null && I_field_3a9bda27.player != null;
   }

   private IiIiiiiii_Class192.Nested1_218ee029 I_method_13eb761a(IiIiiiiii_Class192.Nested1_4325a420 var1) {
      long var2 = System.currentTimeMillis();
      if (var1 != null && !var1.I_field_7865b31.isEmpty()) {
         IiIiiiiii_Class192.Nested1_218ee029 var4 = this.I_method_71cd55ac(var1.I_field_7865b31);
         if (var4 != null) {
            this.I_field_43901866 = var4;
            this.I_field_4a = var2;
            this.I_field_5bba0d50 = var1.I_field_5bba0d50;
            return var4;
         }
      }

      if (!this.i_method_f9f27a43()) {
         return null;
      } else if (this.I_field_5bba0d50 != null && this.I_method_5caf734f(this.I_field_5bba0d50)) {
         int var6 = (int)((var2 - this.I_field_4a) / 1000L);
         int var5 = this.I_field_43901866.I_method_2d5dd524() - var6;
         if (var5 <= 0) {
            this.I_field_43901866 = null;
            this.I_field_5bba0d50 = null;
            return null;
         } else {
            return new IiIiiiiii_Class192.Nested1_218ee029(var5 / 60, var5 % 60, this.I_field_43901866.I_method_95b708a2());
         }
      } else {
         return null;
      }
   }

   private IiIiiiiii_Class192.Nested1_4325a420 I_method_e41961e6(boolean var1) {
      List var2 = this.I_method_35a97a08();
      if (var2.isEmpty()) {
         return null;
      } else {
         ArmorStandEntity var3 = this.I_method_86a3c9be(var1, var2);
         if (var3 == null) {
            return null;
         } else {
            Vec3d var4 = var3.getPos();
            List var5 = var2.stream()
               .filter(var2x -> this.I_method_cdee50cd(((net.minecraft.entity.Entity)var2x).getPos(), var4) <= 64.0)
               .sorted(Comparator.comparingDouble(var0 -> -((net.minecraft.util.math.BlockPos)var0).getY()))
               .toList();
            return new IiIiiiiii_Class192.Nested1_4325a420(var4, var5);
         }
      }
   }

   private ArmorStandEntity I_method_86a3c9be(boolean var1, List<ArmorStandEntity> var2) {
      if (var2.isEmpty()) {
         return null;
      } else {
         List var3 = var1
            ? List.of(
               "\u0448\u0430\u0445\u0442\u0430",
               "\u043e\u0441\u0442\u0430\u043b\u043e\u0441\u044c",
               "\u043e\u0431\u044b\u0447\u043d\u0430\u044f",
               "\u0440\u0435\u0434\u043a\u0430\u044f",
               "\u044d\u043f\u0438\u0447\u0435\u0441\u043a\u0430\u044f",
               "\u043b\u0435\u0433\u0435\u043d\u0434\u0430\u0440\u043d\u0430\u044f",
               "\u043c\u0438\u0444\u0438\u0447\u0435\u0441\u043a\u0430\u044f"
            )
            : List.of(
               "\u0430\u0432\u0442\u043e-\u0448\u0430\u0445\u0442\u0430",
               "\u0448\u0430\u0445\u0442\u0430",
               "\u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0430\u044f",
               "\u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u0435",
               "\u043e\u0441\u0442\u0430\u043b\u043e\u0441\u044c"
            );
         return var2.stream().filter(var2x -> {
            String var3x = var2x.getCustomName().getString().toLowerCase(Locale.ROOT);
            return this.I_method_a303de6d(var3x) ? false : var3.stream().anyMatch(value -> var3x.contains((CharSequence)value));
         }).min(Comparator.comparingDouble(this::I_method_f75470fb)).orElse(null);
      }
   }

   private List<ArmorStandEntity> I_method_35a97a08() {
      return StreamSupport.<Entity>stream(I_field_3a9bda27.world.getEntities().spliterator(), false)
         .filter(var0 -> var0 instanceof ArmorStandEntity)
         .map(var0 -> (ArmorStandEntity)var0)
         .filter(var0 -> var0.isAlive() && var0.getCustomName() != null)
         .filter(var1 -> this.I_method_5caf734f(var1.getPos()))
         .toList();
   }

   private IiIiiiiii_Class192.Nested1_218ee029 I_method_71cd55ac(List<ArmorStandEntity> var1) {
      String var2 = null;
      IiIiiiiii_Class192.Nested1_4325a440 var3 = IiIiiiiii_Class192.Nested1_4325a440.I_field_6546ba47;

      for (int var4 = 0; var4 < var1.size(); var4++) {
         String var5 = ((ArmorStandEntity)var1.get(var4)).getCustomName().getString().toLowerCase(Locale.ROOT);
         if (!this.I_method_a303de6d(var5) && var5.contains("\u0442\u0435\u043a\u0443\u0449")) {
            IiIiiiiii_Class192.Nested1_4325a440 var6 = IiIiiiiii_Class192.Nested1_4325a440.I_method_5a7aefb5(var5);
            if (var6 != null) {
               var3 = var6;
               break;
            }

            if (var4 + 1 < var1.size()) {
               IiIiiiiii_Class192.Nested1_4325a440 var7 = IiIiiiiii_Class192.Nested1_4325a440.I_method_5a7aefb5(
                  ((ArmorStandEntity)var1.get(var4 + 1)).getCustomName().getString()
               );
               if (var7 != null) {
                  var3 = var7;
                  break;
               }
            }
         }
      }

      if (var3 == IiIiiiiii_Class192.Nested1_4325a440.I_field_6546ba47) {
         for (ArmorStandEntity var13 : var1) {
            String var15 = var13.getCustomName().getString().toLowerCase(Locale.ROOT);
            IiIiiiiii_Class192.Nested1_4325a440 var17 = IiIiiiiii_Class192.Nested1_4325a440.I_method_5a7aefb5(var15);
            if (var17 != null) {
               var3 = var17;
               break;
            }
         }
      }

      for (ArmorStandEntity var14 : var1) {
         String var16 = var14.getCustomName().getString().toLowerCase(Locale.ROOT);
         Matcher var18 = this.I_field_5fd3861f.matcher(var16);
         if (var18.find()) {
            var2 = var18.group();
            break;
         }

         if (var16.contains("\u043e\u0441\u0442\u0430\u043b\u043e\u0441\u044c")) {
            int var8 = this.I_method_8725d2f0(var16, "", "\u043c\u0438\u043d.");
            int var9 = this.I_method_8725d2f0(var16, "\u043c\u0438\u043d.", "\u0441\u0435\u043a.");
            if (var8 >= 0 && var9 >= 0) {
               var2 = String.format("%d:%02d", var8, var9);
               break;
            }
         }
      }

      if (var2 == null) {
         return null;
      } else {
         String[] var12 = var2.split(":");
         return new IiIiiiiii_Class192.Nested1_218ee029(Integer.parseInt(var12[0]), Integer.parseInt(var12[1]), var3);
      }
   }

   private boolean I_method_a303de6d(String var1) {
      return var1.contains("\u044d\u043d\u0434\u0430")
         || var1.contains("\u0430\u0434\u0430")
         || var1.contains("\u044d\u043d\u0434")
         || var1.contains("\u0430\u0434");
   }

   private int I_method_8725d2f0(String var1, String var2, String var3) {
      try {
         int var4 = var2.isEmpty() ? 0 : var1.indexOf(var2) + var2.length();
         int var5 = var1.indexOf(var3, var4);
         if (var4 >= 0 && var5 > var4) {
            String var6 = var1.substring(var4, var5).replaceAll("[^0-9]", "");
            return var6.isEmpty() ? -1 : Integer.parseInt(var6);
         }
      } catch (Exception var7) {
      }

      return -1;
   }

   private boolean i_method_f9f27a43() {
      if (this.I_field_43901866 == null) {
         return false;
      } else {
         int var1 = (int)((System.currentTimeMillis() - this.I_field_4a) / 1000L);
         return this.I_field_43901866.I_method_2d5dd524() - var1 > 0;
      }
   }

   private boolean I_method_5caf734f(Vec3d var1) {
      return this.I_method_cdee50cd(var1, I_field_3a9bda27.player.getPos()) <= 900.0;
   }

   private double I_method_f75470fb(ArmorStandEntity var1) {
      return this.I_method_cdee50cd(var1.getPos(), I_field_3a9bda27.player.getPos());
   }

   private double I_method_cdee50cd(Vec3d var1, Vec3d var2) {
      double var3 = var1.x - var2.x;
      double var5 = var1.z - var2.z;
      return var3 * var3 + var5 * var5;
   }

   static final class Nested1_218ee029 {
      private final int I_field_49;
      private final int i_field_49;
      private final IiIiiiiii_Class192.Nested1_4325a440 I_field_6546ba47;

      Nested1_218ee029(int var1, int var2, IiIiiiiii_Class192.Nested1_4325a440 var3) {
         this.I_field_49 = var1;
         this.i_field_49 = var2;
         this.I_field_6546ba47 = var3;
      }

      public int I_method_2d5dd524() {
         return this.I_field_49 * 60 + this.i_field_49;
      }

      @Override
      public final String toString() {
         return "Nested1_218ee029[minutes=" + this.I_field_49 + ", seconds=" + this.i_field_49 + ", type=" + this.I_field_6546ba47 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_6546ba47);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiiiiii_Class192.Nested1_218ee029 other = (IiIiiiiii_Class192.Nested1_218ee029) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.I_field_6546ba47, other.I_field_6546ba47);
      }

      public int i_method_2d6c6104() {
         return this.I_field_49;
      }

      public int II_method_7e6bc843() {
         return this.i_field_49;
      }

      public IiIiiiiii_Class192.Nested1_4325a440 I_method_95b708a2() {
         return this.I_field_6546ba47;
      }
   }

   static final class Nested1_4325a420 {
      final Vec3d I_field_5bba0d50;
      final List<ArmorStandEntity> I_field_7865b31;

      Nested1_4325a420(Vec3d var1, List<ArmorStandEntity> var2) {
         this.I_field_5bba0d50 = var1;
         this.I_field_7865b31 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_4325a420[anchorPos=" + this.I_field_5bba0d50 + ", stands=" + this.I_field_7865b31 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiiiiii_Class192.Nested1_4325a420 other = (IiIiiiiii_Class192.Nested1_4325a420) var1;
         return java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31);
      }

      public Vec3d I_method_c8e9f194() {
         return this.I_field_5bba0d50;
      }

      public List<ArmorStandEntity> I_method_bd3af76d() {
         return this.I_field_7865b31;
      }
   }

   static enum Nested1_4325a440 {
      I_field_6546ba47("\u041e\u0431\u044b\u0447\u043d\u0430\u044f", new ColorRGBA(243.0F, 151.0F, 250.0F)),
      i_field_6546ba47("\u0420\u0435\u0434\u043a\u0430\u044f", new ColorRGBA(243.0F, 151.0F, 250.0F)),
      II_field_6546ba47("\u042d\u043f\u0438\u0447\u0435\u0441\u043a\u0430\u044f", new ColorRGBA(231.0F, 0.0F, 250.0F)),
      Ii_field_6546ba47("\u041b\u0435\u0433\u0435\u043d\u0434\u0430\u0440\u043d\u0430\u044f", new ColorRGBA(0.0F, 128.0F, 250.0F)),
      iI_field_6546ba47("\u041c\u0438\u0444\u0438\u0447\u0435\u0441\u043a\u0430\u044f", new ColorRGBA(252.0F, 84.0F, 252.0F));

      private final String I_field_523beb0a;
      private final ColorRGBA I_field_d0c8ec5;

      public static IiIiiiiii_Class192.Nested1_4325a440 I_method_5a7aefb5(String var0) {
         if (var0 == null) {
            return null;
         } else {
            String var1 = var0.toLowerCase(Locale.ROOT);
            if (!var1.contains("\u044d\u043d\u0434\u0430")
               && !var1.contains("\u0430\u0434\u0430")
               && !var1.contains("\u044d\u043d\u0434")
               && !var1.contains("\u0430\u0434")) {
               for (IiIiiiiii_Class192.Nested1_4325a440 var5 : values()) {
                  if (var1.contains(var5.I_field_523beb0a.toLowerCase(Locale.ROOT))) {
                     return var5;
                  }
               }

               return null;
            } else {
               return null;
            }
         }
      }

      @Generated
      public String I_method_b36d9066() {
         return this.I_field_523beb0a;
      }

      @Generated
      public ColorRGBA I_method_182805e9() {
         return this.I_field_d0c8ec5;
      }

      @Generated
      private Nested1_4325a440(String var3, ColorRGBA var4) {
         this.I_field_523beb0a = var3;
         this.I_field_d0c8ec5 = var4;
      }
   }
}
