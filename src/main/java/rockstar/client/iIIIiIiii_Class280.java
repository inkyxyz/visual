package rockstar.client;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public final class iIIIiIiii_Class280 {
   private static final double I_field_44 = 0.12;
   private static final double i_field_44 = 8.0;
   private static final int I_field_49 = 16;

   private iIIIiIiii_Class280() {
   }

   public static iIIIiIiii_Class280.Nested1_55d7ef89 I_method_56de63cf(
      Entity var0, Vec3d var1, int var2, Vec3d var3, double var4, iIIIiIiii_Class280.Nested1_23cd28a0 var6
   ) {
      World var7 = var0.getWorld();
      Vec3d var8 = var0.getPos();
      boolean var9 = var0.isOnGround();
      boolean var10 = var0.isSneaking();
      boolean var11 = var0.isSprinting();
      double var12 = var0.getWidth();
      double var14 = var0.getHeight();
      double var16 = Math.hypot(var1.x, var1.z);
      boolean var18 = var16 > 0.048;
      float var19 = var18 ? (float)Math.toDegrees(Math.atan2(-var1.x, var1.z)) : var0.getYaw();
      int var20 = Math.max(1, var6.i_method_89ebcaed());
      int var21 = Math.max(1, var6.II_method_b1d99b7a());
      ArrayList var22 = new ArrayList();
      var22.add(var8);
      List var23 = new ArrayList();
      var23.add(new iIIIiIiii_Class280.Nested1_55d7ebc9(new iiiIiiiiI_Class479(var8, var1, var9, var11, var10, var19, var7), 1.0, var19, var22));
      int var24 = 0;

      for (boolean var25 = true; var24 < var6.I_method_89dd3f0d(); var25 = false) {
         int var26 = Math.min(var21, var6.I_method_89dd3f0d() - var24);
         var23 = I_method_e08801b4(var23, 16);
         ArrayList var27 = new ArrayList();

         for (iIIIiIiii_Class280.Nested1_55d7ebc9 var29 : (Iterable<iIIIiIiii_Class280.Nested1_55d7ebc9>)(Iterable<?>)var23) {
            double var30 = Math.hypot(var29.I_field_30d8526c.i_field_5bba0d50.x, var29.I_field_30d8526c.i_field_5bba0d50.z);
            double var32 = var25 ? Math.min(0.9, 0.05 + 0.85 * I_method_c2eb822d(var2 / 8.0)) : 0.06;
            double var34 = 1.0 - var32;
            boolean var36 = var6.I_method_89dd3f1e() && var29.I_field_30d8526c.I_field_5a;
            double var37 = var36 ? var34 * 0.12 : 0.0;
            double var39 = var34 - var37;
            double var41 = 1.5 + var30 * 10.0;
            double[] var43 = new double[var20];
            double var44 = 0.0;

            for (int var46 = 0; var46 < var20; var46++) {
               double var47 = var46 * ((Math.PI * 2) / var20);
               var43[var46] = Math.exp(var41 * Math.cos(var47));
               var44 += var43[var46];
            }

            var27.add(
               I_method_663412dd(var29, var26, var29.I_field_46, iIIIiIiii_Class280.Nested1_23cd28c0.I_field_998fc5c7, var29.I_field_44 * var32, var12, var14)
            );

            for (int var70 = 0; var70 < var20; var70++) {
               float var71 = var29.I_field_46 + var70 * (360.0F / var20);
               var27.add(
                  I_method_663412dd(
                     var29, var26, var71, iIIIiIiii_Class280.Nested1_23cd28c0.i_field_998fc5c7, var29.I_field_44 * var39 * var43[var70] / var44, var12, var14
                  )
               );
            }

            if (var36) {
               var27.add(
                  I_method_663412dd(
                     var29, var26, var29.I_field_46, iIIIiIiii_Class280.Nested1_23cd28c0.II_field_998fc5c7, var29.I_field_44 * var37, var12, var14
                  )
               );
            }
         }

         List var51 = I_method_e08801b4(var27, var6.Ii_method_b1e8275a());
         I_method_95ad08d0(var51);
         var23 = var51;
         var24 += var26;
      }

      ArrayList var50 = new ArrayList(var23.size());
      iIIIiIiii_Class280.Nested1_55d7ebc9 var52 = null;

      for (iIIIiIiii_Class280.Nested1_55d7ebc9 var55 : (Iterable<iIIIiIiii_Class280.Nested1_55d7ebc9>)(Iterable<?>)var23) {
         if (var52 == null || var55.I_field_44 > var52.I_field_44) {
            var52 = var55;
         }
      }

      ArrayList var54 = new ArrayList(var23.size());
      double[] var56 = new double[var23.size()];
      Vec3d var57 = var8;

      for (int var31 = 0; var31 < var23.size(); var31++) {
         iIIIiIiii_Class280.Nested1_55d7ebc9 var59 = (iIIIiIiii_Class280.Nested1_55d7ebc9)var23.get(var31);
         Box var33 = I_method_733982df(var59.I_field_30d8526c.I_field_5bba0d50, var12, var14);
         boolean var61 = var59 == var52;
         var50.add(new iIIIiIiii_Class280.Nested1_55d7efa9(var59.I_field_7865b31, var59.I_field_30d8526c.I_field_5bba0d50, var33, var59.I_field_44, var61));
         var54.add(var33);
         var56[var31] = var59.I_field_44;
         if (var61) {
            var57 = var33.getCenter();
         }
      }

      Vec3d var58 = var57;
      double var60 = -1.0;
      double var62 = Double.MAX_VALUE;

      for (Box var65 : (Iterable<Box>)(Iterable<?>)var54) {
         Vec3d var38 = var65.getCenter();
         double var67 = I_method_6f3a9fb3(var3, var38, var54, var56, var6.I_method_89dd3f08());
         double var69 = var38.squaredDistanceTo(var57);
         if (var67 > var60 + 1.0E-6 || Math.abs(var67 - var60) <= 1.0E-6 && var69 < var62) {
            var60 = var67;
            var62 = var69;
            var58 = var38;
         }
      }

      double var64 = I_method_c2eb822d(var4);
      Vec3d var66 = var57.add(var58.subtract(var57).multiply(var64));
      double var68 = I_method_6f3a9fb3(var3, var66, var54, var56, var6.I_method_89dd3f08());
      return new iIIIiIiii_Class280.Nested1_55d7ef89(var50, var57, var58, var66, var68, var54.size(), var6.I_method_89dd3f0d(), var3);
   }

   public static Vec3d I_method_3b62bd7e(int var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      if (var2 == null || var1.world == null) {
         return null;
      } else if (var0 <= 0) {
         return var2.getEyePos();
      } else {
         Vec3d var3 = new Vec3d(var2.getX() - var2.prevX, var2.getY() - var2.prevY, var2.getZ() - var2.prevZ);
         double var4 = Math.hypot(var3.x, var3.z);
         boolean var6 = var4 > 0.048;
         float var7 = var6 ? (float)Math.toDegrees(Math.atan2(-var3.x, var3.z)) : var2.getYaw();
         double var8 = var2.getEyePos().y - var2.getY();
         iiiIiiiiI_Class479 var10 = new iiiIiiiiI_Class479(var2.getPos(), var3, var2.isOnGround(), var2.isSprinting(), var2.isSneaking(), var7, var1.world);
         iiiIiiiiI_Class479.Nested1_6c23c860 var11 = var6
            ? iiiIiiiiI_Class479.Nested1_6c23c860.I_field_5c0d1a27
            : iiiIiiiiI_Class479.Nested1_6c23c860.Ii_field_5c0d1a27;

         for (int var12 = 0; var12 < var0; var12++) {
            var10.I_method_13e11e22(var11);
         }

         return var10.I_field_5bba0d50.add(0.0, var8, 0.0);
      }
   }

   private static iIIIiIiii_Class280.Nested1_55d7ebc9 I_method_663412dd(
      iIIIiIiii_Class280.Nested1_55d7ebc9 var0, int var1, float var2, iIIIiIiii_Class280.Nested1_23cd28c0 var3, double var4, double var6, double var8
   ) {
      iIIIiIiii_Class280.Nested1_55d7ebc9 var10 = var0.I_method_efc0216b();
      var10.I_field_44 = var4;
      var10.I_field_46 = var2;
      var10.I_field_30d8526c.I_field_46 = var2;

      for (int var11 = 0; var11 < var1; var11++) {
         iiiIiiiiI_Class479.Nested1_6c23c860 var12 = switch (var3) {
            case I_field_998fc5c7 -> iiiIiiiiI_Class479.Nested1_6c23c860.Ii_field_5c0d1a27;
            case i_field_998fc5c7 -> iiiIiiiiI_Class479.Nested1_6c23c860.I_field_5c0d1a27;
            case II_field_998fc5c7 -> var11 == 0 && var10.I_field_30d8526c.I_field_5a
               ? iiiIiiiiI_Class479.Nested1_6c23c860.i_field_5c0d1a27
               : iiiIiiiiI_Class479.Nested1_6c23c860.I_field_5c0d1a27;
         };
         var10.I_field_30d8526c.I_method_13e11e22(var12);
         var10.I_field_7865b31.add(var10.I_field_30d8526c.I_field_5bba0d50);
      }

      return var10;
   }

   private static double I_method_6f3a9fb3(Vec3d var0, Vec3d var1, List<Box> var2, double[] var3, double var4) {
      Vec3d var6 = var1.subtract(var0);
      if (var6.lengthSquared() < 1.0E-9) {
         return 0.0;
      } else {
         Vec3d var7 = var0.add(var6.normalize().multiply(var4));
         double var8 = 0.0;

         for (int var10 = 0; var10 < var2.size(); var10++) {
            if (((Box)var2.get(var10)).raycast(var0, var7).isPresent()) {
               var8 += var3[var10];
            }
         }

         return var8;
      }
   }

   private static List<iIIIiIiii_Class280.Nested1_55d7ebc9> I_method_e08801b4(List<iIIIiIiii_Class280.Nested1_55d7ebc9> var0, int var1) {
      if (var0.size() <= var1) {
         return var0;
      } else {
         var0.sort(Comparator.<iIIIiIiii_Class280.Nested1_55d7ebc9>comparingDouble(var0x -> var0x.I_field_44).reversed());
         return new ArrayList<>(var0.subList(0, var1));
      }
   }

   private static void I_method_95ad08d0(List<iIIIiIiii_Class280.Nested1_55d7ebc9> var0) {
      double var1 = 0.0;

      for (iIIIiIiii_Class280.Nested1_55d7ebc9 var4 : var0) {
         var1 += var4.I_field_44;
      }

      if (!(var1 <= 0.0)) {
         for (iIIIiIiii_Class280.Nested1_55d7ebc9 var6 : var0) {
            var6.I_field_44 /= var1;
         }
      }
   }

   private static Box I_method_733982df(Vec3d var0, double var1, double var3) {
      double var5 = var1 / 2.0;
      return new Box(var0.x - var5, var0.y, var0.z - var5, var0.x + var5, var0.y + var3, var0.z + var5);
   }

   private static double I_method_c2eb822d(double var0) {
      return var0 < 0.0 ? 0.0 : Math.min(var0, 1.0);
   }

   public static final class Nested1_23cd28a0 {
      private final int I_field_49;
      private final int i_field_49;
      private final int II_field_49;
      private final boolean I_field_5a;
      private final double I_field_44;
      private final int Ii_field_49;

      public Nested1_23cd28a0(int var1, int var2, int var3, boolean var4, double var5, int var7) {
         this.I_field_49 = var1;
         this.i_field_49 = var2;
         this.II_field_49 = var3;
         this.I_field_5a = var4;
         this.I_field_44 = var5;
         this.Ii_field_49 = var7;
      }

      public static iIIIiIiii_Class280.Nested1_23cd28a0 I_method_e06ef2ab() {
         return new iIIIiIiii_Class280.Nested1_23cd28a0(10, 8, 4, true, 64.0, 96);
      }

      @Override
      public final String toString() {
         return "Nested1_23cd28a0[ticks=" + this.I_field_49 + ", directions=" + this.i_field_49 + ", branchInterval=" + this.II_field_49 + ", allowJump=" + this.I_field_5a + ", rayRange=" + this.I_field_44 + ", maxLeaves=" + this.Ii_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIiIiii_Class280.Nested1_23cd28a0 other = (iIIIiIiii_Class280.Nested1_23cd28a0) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.Ii_field_49, other.Ii_field_49);
      }

      public int I_method_89dd3f0d() {
         return this.I_field_49;
      }

      public int i_method_89ebcaed() {
         return this.i_field_49;
      }

      public int II_method_b1d99b7a() {
         return this.II_field_49;
      }

      public boolean I_method_89dd3f1e() {
         return this.I_field_5a;
      }

      public double I_method_89dd3f08() {
         return this.I_field_44;
      }

      public int Ii_method_b1e8275a() {
         return this.Ii_field_49;
      }
   }

   static enum Nested1_23cd28c0 {
      I_field_998fc5c7,
      i_field_998fc5c7,
      II_field_998fc5c7;
   }

   public static final class Nested1_55d7eba9 {
      private static final int I_field_49 = 20;
      private static final double I_field_44 = 0.02;
      private int i_field_49 = -1;
      private final Deque<Vec3d> I_field_db650847 = new ArrayDeque<>();
      private Vec3d I_field_5bba0d50 = Vec3d.ZERO;
      private int II_field_49 = 0;

      public void I_method_24bde9f5(Entity var1) {
         if (var1 == null) {
            this.I_method_de6ff9b1();
         } else {
            if (var1.getId() != this.i_field_49) {
               this.i_field_49 = var1.getId();
               this.I_field_db650847.clear();
               this.II_field_49 = 0;
               this.I_field_5bba0d50 = Vec3d.ZERO;
            }

            Vec3d var2 = var1.getPos();
            if (!this.I_field_db650847.isEmpty()) {
               this.I_field_5bba0d50 = var2.subtract(this.I_field_db650847.peekLast());
               double var3 = Math.hypot(this.I_field_5bba0d50.x, this.I_field_5bba0d50.z);
               if (var3 < 0.02) {
                  this.II_field_49++;
               } else {
                  this.II_field_49 = 0;
               }
            }

            this.I_field_db650847.addLast(var2);

            while (this.I_field_db650847.size() > 20) {
               this.I_field_db650847.removeFirst();
            }
         }
      }

      public void I_method_de6ff9b1() {
         this.i_field_49 = -1;
         this.I_field_db650847.clear();
         this.I_field_5bba0d50 = Vec3d.ZERO;
         this.II_field_49 = 0;
      }

      public Vec3d I_method_676f756b() {
         return this.I_field_5bba0d50;
      }

      public Vec3d i_method_b67f94b() {
         if (this.I_field_db650847.size() < 2) {
            return this.I_field_5bba0d50;
         } else {
            Vec3d[] var1 = this.I_field_db650847.toArray(new Vec3d[0]);
            int var2 = var1.length;
            int var3 = Math.min(5, var2 - 1);
            Vec3d var4 = Vec3d.ZERO;

            for (int var5 = var2 - var3; var5 < var2; var5++) {
               var4 = var4.add(var1[var5].subtract(var1[var5 - 1]));
            }

            return var4.multiply(1.0 / var3);
         }
      }

      public int I_method_de6ff9a4() {
         return this.II_field_49;
      }
   }

   static final class Nested1_55d7ebc9 {
      iiiIiiiiI_Class479 I_field_30d8526c;
      double I_field_44;
      float I_field_46;
      List<Vec3d> I_field_7865b31;

      Nested1_55d7ebc9(iiiIiiiiI_Class479 var1, double var2, float var4, List<Vec3d> var5) {
         this.I_field_30d8526c = var1;
         this.I_field_44 = var2;
         this.I_field_46 = var4;
         this.I_field_7865b31 = var5;
      }

      iIIIiIiii_Class280.Nested1_55d7ebc9 I_method_efc0216b() {
         return new iIIIiIiii_Class280.Nested1_55d7ebc9(
            this.I_field_30d8526c.I_method_b9779af5(), this.I_field_44, this.I_field_46, new ArrayList<>(this.I_field_7865b31)
         );
      }
   }

   public static final class Nested1_55d7ef89 {
      private final List<iIIIiIiii_Class280.Nested1_55d7efa9> I_field_7865b31;
      private final Vec3d I_field_5bba0d50;
      private final Vec3d i_field_5bba0d50;
      private final Vec3d II_field_5bba0d50;
      private final double I_field_44;
      private final int I_field_49;
      private final int i_field_49;
      private final Vec3d Ii_field_5bba0d50;

      public Nested1_55d7ef89(List<iIIIiIiii_Class280.Nested1_55d7efa9> var1, Vec3d var2, Vec3d var3, Vec3d var4, double var5, int var7, int var8, Vec3d var9) {
         this.I_field_7865b31 = var1;
         this.I_field_5bba0d50 = var2;
         this.i_field_5bba0d50 = var3;
         this.II_field_5bba0d50 = var4;
         this.I_field_44 = var5;
         this.I_field_49 = var7;
         this.i_field_49 = var8;
         this.Ii_field_5bba0d50 = var9;
      }

      public double I_method_7b3761bf() {
         return this.I_field_44 * 100.0;
      }

      @Override
      public final String toString() {
         return "Nested1_55d7ef89[trajectories=" + this.I_field_7865b31 + ", mostLikelyPoint=" + this.I_field_5bba0d50 + ", maxCoveragePoint=" + this.i_field_5bba0d50 + ", aimPoint=" + this.II_field_5bba0d50 + ", coverage=" + this.I_field_44 + ", variants=" + this.I_field_49 + ", ticks=" + this.i_field_49 + ", eyePos=" + this.Ii_field_5bba0d50 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_5bba0d50);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIiIiii_Class280.Nested1_55d7ef89 other = (iIIIiIiii_Class280.Nested1_55d7ef89) var1;
         return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.i_field_5bba0d50, other.i_field_5bba0d50)
            && java.util.Objects.equals(this.II_field_5bba0d50, other.II_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.Ii_field_5bba0d50, other.Ii_field_5bba0d50);
      }

      public List<iIIIiIiii_Class280.Nested1_55d7efa9> I_method_7d967456() {
         return this.I_field_7865b31;
      }

      public Vec3d I_method_dc69e58b() {
         return this.I_field_5bba0d50;
      }

      public Vec3d i_method_8062696b() {
         return this.i_field_5bba0d50;
      }

      public Vec3d II_method_2400032a() {
         return this.II_field_5bba0d50;
      }

      public double i_method_7b45ed9f() {
         return this.I_field_44;
      }

      public int I_method_7b3761c4() {
         return this.I_field_49;
      }

      public int i_method_7b45eda4() {
         return this.i_field_49;
      }

      public Vec3d Ii_method_c7f8870a() {
         return this.Ii_field_5bba0d50;
      }
   }

   public static final class Nested1_55d7efa9 {
      private final List<Vec3d> I_field_7865b31;
      private final Vec3d I_field_5bba0d50;
      private final Box I_field_bdfefbea;
      private final double I_field_44;
      private final boolean I_field_5a;

      public Nested1_55d7efa9(List<Vec3d> var1, Vec3d var2, Box var3, double var4, boolean var6) {
         this.I_field_7865b31 = var1;
         this.I_field_5bba0d50 = var2;
         this.I_field_bdfefbea = var3;
         this.I_field_44 = var4;
         this.I_field_5a = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_55d7efa9[path=" + this.I_field_7865b31 + ", endPos=" + this.I_field_5bba0d50 + ", endBox=" + this.I_field_bdfefbea + ", probability=" + this.I_field_44 + ", mostLikely=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_bdfefbea);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIiIiii_Class280.Nested1_55d7efa9 other = (iIIIiIiii_Class280.Nested1_55d7efa9) var1;
         return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_bdfefbea, other.I_field_bdfefbea)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public List<Vec3d> I_method_10b52476() {
         return this.I_field_7865b31;
      }

      public Vec3d I_method_6450f16b() {
         return this.I_field_5bba0d50;
      }

      public Box I_method_93a62ac5() {
         return this.I_field_bdfefbea;
      }

      public double I_method_b1d2759f() {
         return this.I_field_44;
      }

      public boolean I_method_b1d275b5() {
         return this.I_field_5a;
      }
   }
}
