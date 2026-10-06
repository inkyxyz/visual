package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public final class iiiIiiiiI_Class479 {
   public static final double I_field_44 = 0.3;
   public static final double i_field_44 = 1.8;
   public Vec3d I_field_5bba0d50;
   public Vec3d i_field_5bba0d50;
   public boolean I_field_5a;
   public boolean i_field_5a;
   public boolean II_field_5a;
   public float I_field_46;
   private final World I_field_99614b46;

   public iiiIiiiiI_Class479(Vec3d var1, Vec3d var2, boolean var3, boolean var4, boolean var5, float var6, World var7) {
      this.I_field_5bba0d50 = var1;
      this.i_field_5bba0d50 = var2;
      this.I_field_5a = var3;
      this.i_field_5a = var4;
      this.II_field_5a = var5;
      this.I_field_46 = var6;
      this.I_field_99614b46 = var7;
   }

   public static iiiIiiiiI_Class479 I_method_fba92bd7(float var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayerEntity var2 = var1.player;
      return var2 != null && var1.world != null
         ? new iiiIiiiiI_Class479(var2.getPos(), var2.getVelocity(), var2.isOnGround(), var2.isSprinting(), var2.isSneaking(), var0, var1.world)
         : new iiiIiiiiI_Class479(Vec3d.ZERO, Vec3d.ZERO, false, false, false, var0, null);
   }

   public Box I_method_9bee4633() {
      return new Box(
         this.I_field_5bba0d50.x - 0.3,
         this.I_field_5bba0d50.y,
         this.I_field_5bba0d50.z - 0.3,
         this.I_field_5bba0d50.x + 0.3,
         this.I_field_5bba0d50.y + 1.8,
         this.I_field_5bba0d50.z + 0.3
      );
   }

   public void I_method_13e11e22(iiiIiiiiI_Class479.Nested1_6c23c860 var1) {
      if (this.I_field_99614b46 != null) {
         if (this.i_field_5a && var1.I_field_44 <= 0.0) {
            this.i_field_5a = false;
         }

         if (!this.i_field_5a && var1.i_field_5a && var1.I_field_44 > 0.0 && !this.II_field_5a) {
            this.i_field_5a = true;
         }

         this.II_field_5a = var1.II_field_5a;
         if (var1.I_field_5a && this.I_field_5a) {
            this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x, 0.42, this.i_field_5bba0d50.z);
            if (this.i_field_5a) {
               double var2 = Math.toRadians(this.I_field_46);
               this.i_field_5bba0d50 = this.i_field_5bba0d50.add(-Math.sin(var2) * 0.2, 0.0, Math.cos(var2) * 0.2);
            }

            this.I_field_5a = false;
         }

         double var24 = var1.i_field_44;
         double var4 = var1.I_field_44;
         double var6 = var24 * var24 + var4 * var4;
         if (var6 > 1.0E-6) {
            double var8 = 1.0 / Math.sqrt(var6);
            var24 *= var8;
            var4 *= var8;
            double var10 = this.I_field_5a ? (this.i_field_5a ? 0.13 : 0.1) : (this.i_field_5a ? 0.026 : 0.02);
            var24 *= var10;
            var4 *= var10;
            double var12 = Math.toRadians(this.I_field_46);
            double var14 = Math.sin(var12);
            double var16 = Math.cos(var12);
            double var18 = var24 * var16 - var4 * var14;
            double var20 = var4 * var16 + var24 * var14;
            this.i_field_5bba0d50 = this.i_field_5bba0d50.add(var18, 0.0, var20);
         }

         this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x, this.i_field_5bba0d50.y - 0.08, this.i_field_5bba0d50.z);
         Vec3d var29 = this.i_field_5bba0d50;
         Box var9 = this.I_method_9bee4633();
         double var33 = var29.y;
         Box var34 = var9.stretch(0.0, var33, 0.0);

         for (VoxelShape var36 : this.I_field_99614b46.getBlockCollisions(null, var34)) {
            var33 = var36.calculateMaxDistance(Axis.Y, var9, var33);
         }

         var9 = var9.offset(0.0, var33, 0.0);
         boolean var35 = var33 != var29.y;
         double var37 = var29.x;
         Box var38 = var9.stretch(var37, 0.0, 0.0);

         for (VoxelShape var40 : this.I_field_99614b46.getBlockCollisions(null, var38)) {
            var37 = var40.calculateMaxDistance(Axis.X, var9, var37);
         }

         var9 = var9.offset(var37, 0.0, 0.0);
         boolean var39 = var37 != var29.x;
         double var41 = var29.z;
         Box var42 = var9.stretch(0.0, 0.0, var41);

         for (VoxelShape var22 : this.I_field_99614b46.getBlockCollisions(null, var42)) {
            var41 = var22.calculateMaxDistance(Axis.Z, var9, var41);
         }

         var9 = var9.offset(0.0, 0.0, var41);
         boolean var43 = var41 != var29.z;
         this.I_field_5bba0d50 = new Vec3d((var9.minX + var9.maxX) * 0.5, var9.minY, (var9.minZ + var9.maxZ) * 0.5);
         if (var35) {
            if (var29.y < 0.0) {
               this.I_field_5a = true;
            }

            this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x, 0.0, this.i_field_5bba0d50.z);
         } else {
            this.I_field_5a = false;
         }

         if (var39) {
            this.i_field_5bba0d50 = new Vec3d(0.0, this.i_field_5bba0d50.y, this.i_field_5bba0d50.z);
         }

         if (var43) {
            this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x, this.i_field_5bba0d50.y, 0.0);
         }

         double var44 = this.I_field_5a ? 0.546 : 0.91;
         this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x * var44, this.i_field_5bba0d50.y * 0.98, this.i_field_5bba0d50.z * var44);
      }
   }

   public void I_method_b27d099d(int var1, iiiIiiiiI_Class479.Nested1_6c23c860 var2) {
      for (int var3 = 0; var3 < var1; var3++) {
         this.I_method_13e11e22(var2);
      }
   }

   public iiiIiiiiI_Class479 I_method_b9779af5() {
      return new iiiIiiiiI_Class479(
         this.I_field_5bba0d50, this.i_field_5bba0d50, this.I_field_5a, this.i_field_5a, this.II_field_5a, this.I_field_46, this.I_field_99614b46
      );
   }

   public static final class Nested1_6c23c860 {
      final double I_field_44;
      final double i_field_44;
      final boolean I_field_5a;
      final boolean i_field_5a;
      final boolean II_field_5a;
      public static final iiiIiiiiI_Class479.Nested1_6c23c860 I_field_5c0d1a27 = new iiiIiiiiI_Class479.Nested1_6c23c860(1.0, 0.0, false, true, false);
      public static final iiiIiiiiI_Class479.Nested1_6c23c860 i_field_5c0d1a27 = new iiiIiiiiI_Class479.Nested1_6c23c860(1.0, 0.0, true, true, false);
      public static final iiiIiiiiI_Class479.Nested1_6c23c860 II_field_5c0d1a27 = new iiiIiiiiI_Class479.Nested1_6c23c860(1.0, 0.0, false, false, false);
      public static final iiiIiiiiI_Class479.Nested1_6c23c860 Ii_field_5c0d1a27 = new iiiIiiiiI_Class479.Nested1_6c23c860(0.0, 0.0, false, false, false);

      public Nested1_6c23c860(double var1, double var3, boolean var5, boolean var6, boolean var7) {
         this.I_field_44 = var1;
         this.i_field_44 = var3;
         this.I_field_5a = var5;
         this.i_field_5a = var6;
         this.II_field_5a = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_6c23c860[forward=" + this.I_field_44 + ", strafe=" + this.i_field_44 + ", jump=" + this.I_field_5a + ", sprintKey=" + this.i_field_5a + ", sneak=" + this.II_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiiIiiiiI_Class479.Nested1_6c23c860 other = (iiiIiiiiI_Class479.Nested1_6c23c860) var1;
         return java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.i_field_44, other.i_field_44)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.i_field_5a, other.i_field_5a)
            && java.util.Objects.equals(this.II_field_5a, other.II_field_5a);
      }

      public double I_method_a1747748() {
         return this.I_field_44;
      }

      public double i_method_a1830328() {
         return this.i_field_44;
      }

      public boolean I_method_a174775e() {
         return this.I_field_5a;
      }

      public boolean i_method_a183033e() {
         return this.i_field_5a;
      }

      public boolean II_method_8d296b4b() {
         return this.II_field_5a;
      }
   }
}
