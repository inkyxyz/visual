package rockstar.client;

import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class iIIIiiIIi_Class282 {
   private static final int I_field_49 = 13;
   private static final int i_field_49 = 0;
   private static final int II_field_49 = 1;
   private static final int Ii_field_49 = 2;
   private static final int iI_field_49 = 3;
   private static final int ii_field_49 = 4;
   private static final int III_field_49 = 5;
   private static final int IIi_field_49 = 6;
   private static final int IiI_field_49 = 7;
   private static final int Iii_field_49 = 8;
   private static final int iII_field_49 = 9;
   private static final int iIi_field_49 = 10;
   private static final int iiI_field_49 = 11;
   private static final int iii_field_49 = 12;
   private static final int IIII_field_49 = 160;
   private static final int IIIi_field_49 = 16;
   private iIIIiiIII_Class281 I_field_ac15d26c;
   private boolean I_field_5a;
   private final Map<Integer, ArrayDeque<iIIIiiIIi_Class282.Nested1_5896c080>> I_field_a567c40b = new HashMap<>();

   public boolean I_method_2fb8f603() {
      this.II_method_c774c142();
      return this.I_field_ac15d26c != null;
   }

   public void I_method_2fb8f5ff() {
      this.I_field_5a = false;
      this.I_field_ac15d26c = null;
      this.II_method_c774c142();
   }

   private void II_method_c774c142() {
      if (this.I_field_ac15d26c == null && !this.I_field_5a) {
         this.I_field_5a = true;
         this.I_field_ac15d26c = iIIIiiIII_Class281.I_method_d792ae54(I_method_97ffd496());
      }
   }

   public static Path I_method_97ffd496() {
      return MinecraftClient.getInstance().runDirectory.toPath().resolve("Rockstar").resolve("posnet").resolve("model.posnet");
   }

   public void I_method_9240fd88(Iterable<? extends PlayerEntity> var1) {
      HashSet var2 = new HashSet();

      for (PlayerEntity var4 : var1) {
         if (var4.isAlive()) {
            var2.add(var4.getId());
            int var5 = (var4.isOnGround() ? 1 : 0) | (var4.isSneaking() ? 2 : 0) | (var4.isSprinting() ? 4 : 0) | (var4.isGliding() ? 8 : 0);
            ArrayDeque var6 = this.I_field_a567c40b.computeIfAbsent(var4.getId(), var0 -> new ArrayDeque<>());
            var6.addLast(new iIIIiiIIi_Class282.Nested1_5896c080(var4.getX(), var4.getY(), var4.getZ(), var4.getYaw(), var4.getPitch(), var5));

            while (var6.size() > 160) {
               var6.removeFirst();
            }
         }
      }

      this.I_field_a567c40b.keySet().removeIf(var1x -> !var2.contains(var1x));
   }

   public void i_method_2fc781df() {
      this.I_field_a567c40b.clear();
   }

   public iIIIiiIIi_Class282.Nested1_ba414fc9 I_method_65f033cd(PlayerEntity var1, int var2) {
      this.II_method_c774c142();
      if (this.I_field_ac15d26c != null && var1 != null) {
         ArrayDeque<iIIIiiIIi_Class282.Nested1_5896c080> var3 = this.I_field_a567c40b.get(var1.getId());
         if (var3 != null && var3.size() >= 16) {
            if (var2 <= 0) {
               var2 = Math.max(1, this.I_field_ac15d26c.III_field_49);
            }

            iIIIiiIIi_Class282.Nested1_5896c080[] var4 = var3.toArray(new iIIIiiIIi_Class282.Nested1_5896c080[0]);
            int var5 = var4.length;
            int var6 = var5 - 1;
            int var7 = Math.min(var6, Math.max(16, this.I_field_ac15d26c.ii_field_49));
            int var8 = var6 - var7;
            float[][] var9 = new float[var7][13];

            for (int var10 = 0; var10 < var7; var10++) {
               var9[var10] = I_method_d00cafe2(var4[var8 + var10], var4[var8 + var10 + 1]);
            }

            iIIIiiIII_Class281.Nested1_58964860 var41 = this.I_field_ac15d26c.I_method_a8c54853(var9, var2);
            iIIIiiIIi_Class282.Nested1_5896c080 var11 = var4[var5 - 1];
            Vec3d var12 = new Vec3d(var11.I_field_44, var11.i_field_44, var11.II_field_44);
            Box var13 = var1.getBoundingBox();
            double var14 = (var13.maxX - var13.minX) / 2.0;
            double var16 = var13.maxY - var13.minY;
            int var18 = var41.I_field_b49.length;
            ArrayList<iIIIiiIIi_Class282.Nested1_5896c0a0> var19 = new ArrayList<>(var18);
            double var20 = 0.0;
            double var22 = 0.0;
            double var24 = 0.0;
            double var26 = -1.0;
            Vec3d var28 = var12;

            for (int var29 = 0; var29 < var18; var29++) {
               ArrayList<Vec3d> var30 = new ArrayList<>(var2 + 1);
               var30.add(var12);
               double var31 = var11.I_field_44;
               double var33 = var11.i_field_44;
               double var35 = var11.II_field_44;

               for (int var37 = 0; var37 < var2; var37++) {
                  var31 += var41.I_field_2abeab[var29][var37][0];
                  var33 += var41.I_field_2abeab[var29][var37][1];
                  var35 += var41.I_field_2abeab[var29][var37][2];
                  var30.add(new Vec3d(var31, var33, var35));
               }

               Vec3d var43 = new Vec3d(var31, var33, var35);
               Box var38 = new Box(var31 - var14, var33, var35 - var14, var31 + var14, var33 + var16, var35 + var14);
               double var39 = var41.I_field_b49[var29];
               var19.add(new iIIIiiIIi_Class282.Nested1_5896c0a0(var30, var43, var38, var39));
               var20 += var43.x * var39;
               var22 += var43.y * var39;
               var24 += var43.z * var39;
               if (var39 > var26) {
                  var26 = var39;
                  var28 = var43;
               }
            }

            var19.sort((var0, var1x) -> Double.compare(var1x.I_method_4b52a708(), var0.I_method_4b52a708()));
            Vec3d var42 = new Vec3d(var20, var22, var24);
            return new iIIIiiIIi_Class282.Nested1_ba414fc9(var19, var12, var28, var42, var2);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private static float[] I_method_d00cafe2(iIIIiiIIi_Class282.Nested1_5896c080 var0, iIIIiiIIi_Class282.Nested1_5896c080 var1) {
      float[] var2 = new float[13];
      double var3 = var1.I_field_44 - var0.I_field_44;
      double var5 = var1.i_field_44 - var0.i_field_44;
      double var7 = var1.II_field_44 - var0.II_field_44;
      var2[0] = (float)var3;
      var2[1] = (float)var5;
      var2[2] = (float)var7;
      var2[3] = (float)Math.hypot(var3, var7);
      var2[4] = (var1.I_field_49 & 1) != 0 ? 1.0F : 0.0F;
      var2[5] = (var1.I_field_49 & 2) != 0 ? 1.0F : 0.0F;
      var2[6] = (var1.I_field_49 & 4) != 0 ? 1.0F : 0.0F;
      var2[7] = (var1.I_field_49 & 8) != 0 ? 1.0F : 0.0F;
      double var9 = Math.toRadians(var1.I_field_46);
      double var11 = Math.toRadians(var1.i_field_46);
      var2[8] = (float)Math.sin(var9);
      var2[9] = (float)Math.cos(var9);
      var2[10] = (float)(I_method_c7662a0d(var1.I_field_46 - var0.I_field_46) / 180.0);
      var2[11] = (float)Math.sin(var11);
      var2[12] = (float)Math.cos(var11);
      return var2;
   }

   private static double I_method_c7662a0d(double var0) {
      var0 %= 360.0;
      if (var0 > 180.0) {
         var0 -= 360.0;
      }

      if (var0 < -180.0) {
         var0 += 360.0;
      }

      return var0;
   }

   static final class Nested1_5896c080 {
      final double I_field_44;
      final double i_field_44;
      final double II_field_44;
      final float I_field_46;
      final float i_field_46;
      final int I_field_49;

      Nested1_5896c080(double var1, double var3, double var5, float var7, float var8, int var9) {
         this.I_field_44 = var1;
         this.i_field_44 = var3;
         this.II_field_44 = var5;
         this.I_field_46 = var7;
         this.i_field_46 = var8;
         this.I_field_49 = var9;
      }
   }

   public static final class Nested1_5896c0a0 {
      private final List<Vec3d> I_field_7865b31;
      private final Vec3d I_field_5bba0d50;
      private final Box I_field_bdfefbea;
      private final double I_field_44;

      public Nested1_5896c0a0(List<Vec3d> var1, Vec3d var2, Box var3, double var4) {
         this.I_field_7865b31 = var1;
         this.I_field_5bba0d50 = var2;
         this.I_field_bdfefbea = var3;
         this.I_field_44 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_5896c0a0[path=" + this.I_field_7865b31 + ", endPos=" + this.I_field_5bba0d50 + ", endBox=" + this.I_field_bdfefbea + ", weight=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_bdfefbea);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIiiIIi_Class282.Nested1_5896c0a0 other = (iIIIiiIIi_Class282.Nested1_5896c0a0) var1;
         return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_bdfefbea, other.I_field_bdfefbea)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public List<Vec3d> I_method_b780d3ed() {
         return this.I_field_7865b31;
      }

      public Vec3d I_method_7f9f8514() {
         return this.I_field_5bba0d50;
      }

      public Box I_method_29a794ae() {
         return this.I_field_bdfefbea;
      }

      public double I_method_4b52a708() {
         return this.I_field_44;
      }
   }

   public static final class Nested1_ba414fc9 {
      private final List<iIIIiiIIi_Class282.Nested1_5896c0a0> I_field_7865b31;
      private final Vec3d I_field_5bba0d50;
      private final Vec3d i_field_5bba0d50;
      private final Vec3d II_field_5bba0d50;
      private final int I_field_49;

      public Nested1_ba414fc9(List<iIIIiiIIi_Class282.Nested1_5896c0a0> var1, Vec3d var2, Vec3d var3, Vec3d var4, int var5) {
         this.I_field_7865b31 = var1;
         this.I_field_5bba0d50 = var2;
         this.i_field_5bba0d50 = var3;
         this.II_field_5bba0d50 = var4;
         this.I_field_49 = var5;
      }

      @Override
      public final String toString() {
         return "Nested1_ba414fc9[hypotheses=" + this.I_field_7865b31 + ", basePos=" + this.I_field_5bba0d50 + ", mostLikelyEnd=" + this.i_field_5bba0d50 + ", meanEnd=" + this.II_field_5bba0d50 + ", steps=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIiiIIi_Class282.Nested1_ba414fc9 other = (iIIIiiIIi_Class282.Nested1_ba414fc9) var1;
         return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.i_field_5bba0d50, other.i_field_5bba0d50)
            && java.util.Objects.equals(this.II_field_5bba0d50, other.II_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public List<iIIIiiIIi_Class282.Nested1_5896c0a0> I_method_15cd3496() {
         return this.I_field_7865b31;
      }

      public Vec3d I_method_dc529d4b() {
         return this.I_field_5bba0d50;
      }

      public Vec3d i_method_804b212b() {
         return this.i_field_5bba0d50;
      }

      public Vec3d II_method_212e436a() {
         return this.II_field_5bba0d50;
      }

      public int I_method_aee02984() {
         return this.I_field_49;
      }
   }
}
