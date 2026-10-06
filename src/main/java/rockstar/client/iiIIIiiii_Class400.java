package rockstar.client;

import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class iiIIIiiii_Class400 implements iIIiIIiIi_Class294 {
   private Vec3d I_field_5bba0d50;
   private Vec3d i_field_5bba0d50 = Vec3d.ZERO;
   private float Ii_field_46 = iIIiiiiiI_Class319.I_method_b56b22f(0.0, 360.0);
   private float iI_field_46;
   private float ii_field_46;
   private int I_field_49 = 50;
   private final IiiiIiiiI_Class239 I_field_dd682cc = new IiiiIiiiI_Class239();
   private final IiiiIiiiI_Class239 i_field_dd682cc = new IiiiIiiiI_Class239();
   private final IiiiIiiiI_Class239 II_field_dd682cc = new IiiiIiiiI_Class239();
   private final IiiiIiiiI_Class239 Ii_field_dd682cc = new IiiiIiiiI_Class239();
   private final IiiiIiiiI_Class239 iI_field_dd682cc = new IiiiIiiiI_Class239();
   private final IiiiIiiiI_Class239 ii_field_dd682cc = new IiiiIiiiI_Class239();
   private boolean I_field_5a;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private boolean i_field_5a;
   private boolean II_field_5a;
   private final iiIiIIiii_Class424 II_field_991c1e8c = new iiIiIIiii_Class424();
   public float I_field_46;
   public float i_field_46;
   public float II_field_46;
   private PlayerEntity I_field_88955355;

   public void I_method_fd8a63f() {
      if (this.I_field_88955355 != null) {
         Vec3d var1 = this.I_field_88955355.getPos();
         if (this.I_field_5bba0d50 == null || this.I_field_5bba0d50.distanceTo(var1) > 10.0) {
            this.I_field_5bba0d50 = var1;
            this.I_field_dd682cc.I_method_5a0dc1f2((float)this.I_field_5bba0d50.x, 1);
            this.i_field_dd682cc.I_method_5a0dc1f2((float)this.I_field_5bba0d50.y, 1);
            this.II_field_dd682cc.I_method_5a0dc1f2((float)this.I_field_5bba0d50.z, 1);
         }

         boolean var2 = this.I_method_e2f8de3(this.I_field_5bba0d50.x, this.I_field_5bba0d50.y - 0.1, this.I_field_5bba0d50.z);
         boolean var3 = this.I_method_e2f8de3(this.I_field_5bba0d50.x, this.I_field_5bba0d50.y + 0.11, this.I_field_5bba0d50.z);
         if (var2) {
            this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x, 0.0, this.i_field_5bba0d50.z);
            if (var3) {
               this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x, 0.42, this.i_field_5bba0d50.z);
            }
         } else {
            this.i_field_5bba0d50 = this.i_field_5bba0d50.add(0.0, -0.08, 0.0);
         }

         Vec3d var4 = this.I_field_5bba0d50.add(this.i_field_5bba0d50);
         if (this.I_method_e2f8de3(var4.x, var4.y - 0.01, var4.z) && this.i_field_5bba0d50.y < 0.0) {
            BlockPos var5 = BlockPos.ofFloored(var4.x, var4.y - 0.1, var4.z);
            var4 = new Vec3d(var4.x, var5.getY() + 1, var4.z);
            this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x, 0.0, this.i_field_5bba0d50.z);
         }

         LivingEntity var6 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var7 ? var7 : null;
         this.i_field_5a = var6 != null && this.I_field_88955355 instanceof ClientPlayerEntity;
         if (this.i_field_5a) {
            Box var12 = new Box(this.I_method_32823579().subtract(0.4, 0.0, 0.4), this.I_method_32823579().add(0.4, 0.4, 0.4));
            Box var8 = var6.getBoundingBox().expand(-0.1F, 0.0, -0.1F);
            this.i_field_5bba0d50 = this.i_field_5bba0d50.add(var6.getPos().subtract(var4).normalize().multiply(0.3));
            boolean var9 = var12.maxX > var8.minX
               && var12.maxY > var8.minY
               && var12.maxZ > var8.minZ
               && var12.minX < var8.maxX
               && var12.minY < var8.maxY
               && var12.minZ < var8.maxZ;
            if (var9) {
               this.i_field_5bba0d50 = this.i_field_5bba0d50.multiply(-1.0, 1.0, -1.0);
               this.II_field_5a = true;
               this.II_field_991c1e8c.I_method_23e11e3f();
            }

            if (var2 && this.i_field_991c1e8c.I_method_58432069(400L)) {
               this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x, 0.35, this.i_field_5bba0d50.z);
               var4 = var4.add(0.0, 0.35, 0.0);
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         } else if (var4.distanceTo(var1) > 2.0) {
            this.i_field_5bba0d50 = this.i_field_5bba0d50.add(var1.subtract(var4).normalize().multiply(0.1));
         }

         if (this.II_field_991c1e8c.I_method_58432069(500L)) {
            this.II_field_5a = false;
         }

         this.I_method_f1599fe(var6);
         this.I_field_5bba0d50 = var4;
         if (this.I_field_5bba0d50.distanceTo(var1) < 0.1F) {
            this.Ii_field_46 = iIIiiiiiI_Class319.I_method_b56b22f(0.0, 360.0);
            double var13 = -Math.sin(Math.toRadians(this.Ii_field_46)) * 0.1;
            double var14 = Math.cos(Math.toRadians(this.Ii_field_46)) * 0.1;
            this.i_field_5bba0d50 = this.i_field_5bba0d50.add(var13, 0.0, var14);
         }

         this.i_field_5bba0d50 = new Vec3d(this.i_field_5bba0d50.x * 0.9, this.i_field_5bba0d50.y, this.i_field_5bba0d50.z * 0.9);
         this.I_field_49 = 150;
         this.I_field_dd682cc.I_method_5a0dc1f2((float)this.I_field_5bba0d50.x, this.I_field_49);
         this.i_field_dd682cc.I_method_5a0dc1f2((float)this.I_field_5bba0d50.y, this.I_field_49);
         this.II_field_dd682cc.I_method_5a0dc1f2((float)this.I_field_5bba0d50.z, this.I_field_49);
         this.i_method_fe7321f();
         if (Math.abs(this.I_field_5bba0d50.x - this.I_field_dd682cc.I_method_304f626f()) > 0.1F
            || Math.abs(this.I_field_5bba0d50.z - this.II_field_dd682cc.I_method_304f626f()) > 0.1F) {
            this.I_field_991c1e8c.I_method_23e11e3f();
         }

         this.I_field_5a = this.I_field_991c1e8c.I_method_58432069(1000L);
      }
   }

   private void I_method_f1599fe(LivingEntity var1) {
      Vec3d var2 = this.I_field_88955355.getPos().add(0.0, this.I_field_88955355.getEyeHeight(this.I_field_88955355.getPose()), 0.0);
      if (var1 != null && this.I_field_88955355 instanceof ClientPlayerEntity) {
         var2 = var1.getPos().add(0.0, var1.getEyeHeight(var1.getPose()), 0.0);
         Vec3d var17 = this.I_method_32823579();
         double var4 = var2.x - var17.x;
         double var6 = var2.z - var17.z;
         this.iI_field_46 = (float)Math.toDegrees(Math.atan2(-var4, var6));
      } else if (Math.abs(this.i_field_5bba0d50.x) > 0.01 || Math.abs(this.i_field_5bba0d50.z) > 0.01) {
         double var3 = Math.toDegrees(Math.atan2(-this.i_field_5bba0d50.x, this.i_field_5bba0d50.z));
         this.iI_field_46 = (float)var3;
      }

      if (this.I_field_88955355 instanceof ClientPlayerEntity) {
         var2 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
      }

      float var18 = MathHelper.wrapDegrees(this.iI_field_46 - this.ii_field_46);
      this.ii_field_46 += var18 * 0.3F;
      this.ii_field_dd682cc.I_method_5a0dc1f2(this.ii_field_46, 80);
      Vec3d var19 = this.I_method_32823579();
      double var5 = var2.x - var19.x;
      double var7 = var2.y - var19.y;
      double var9 = var2.z - var19.z;
      double var11 = Math.sqrt(var5 * var5 + var9 * var9);
      float var13 = (float)Math.toDegrees(Math.atan2(-var5, var9));
      float var14 = (float)(-Math.toDegrees(Math.atan2(var7, var11)));
      float var15 = MathHelper.wrapDegrees(var13 - this.ii_field_dd682cc.I_method_304f626f());
      float var16 = this.I_field_5a ? 90.0F : 70.0F;
      var15 = MathHelper.clamp(var15, -var16, var16);
      var14 = MathHelper.clamp(var14, -30.0F, 30.0F);
      this.Ii_field_dd682cc.I_method_5a0dc1f2(var15, 100);
      this.iI_field_dd682cc.I_method_5a0dc1f2(var14, 100);
   }

   public void i_method_fe7321f() {
      this.I_field_46 = this.i_field_46;
      double var1 = this.I_field_dd682cc.I_method_304f626f() - this.I_field_5bba0d50.x;
      double var3 = 0.0;
      double var5 = this.II_field_dd682cc.I_method_304f626f() - this.I_field_5bba0d50.z;
      float var7 = MathHelper.sqrt((float)(var1 * var1 + var3 * var3 + var5 * var5)) * 4.0F;
      if (var7 > 1.0F) {
         var7 = 1.0F;
      }

      this.i_field_46 = this.i_field_46 + (var7 - this.i_field_46) * 0.4F;
      this.II_field_46 = this.II_field_46 + this.i_field_46;
   }

   private boolean I_method_e2f8de3(double var1, double var3, double var5) {
      if (I_field_3a9bda27.world == null) {
         return false;
      } else {
         BlockPos var7 = BlockPos.ofFloored(var1, var3, var5);
         BlockState var8 = I_field_3a9bda27.world.getBlockState(var7);
         return var8.isAir() ? false : !var8.getCollisionShape(I_field_3a9bda27.world, var7).isEmpty();
      }
   }

   public float I_method_fd8a62f() {
      return this.ii_field_dd682cc.I_method_304f626f();
   }

   public float i_method_fe7320f() {
      return this.Ii_field_dd682cc.I_method_304f626f();
   }

   public float II_method_eb4b18f2() {
      return this.iI_field_dd682cc.I_method_304f626f();
   }

   public Vec3d I_method_32823579() {
      return new Vec3d(this.I_field_dd682cc.I_method_304f626f(), this.i_field_dd682cc.I_method_304f626f(), this.II_field_dd682cc.I_method_304f626f());
   }

   @Generated
   public boolean I_method_fd8a643() {
      return this.I_field_5a;
   }

   @Generated
   public boolean i_method_fe73223() {
      return this.i_field_5a;
   }

   @Generated
   public boolean II_method_eb4b1906() {
      return this.II_field_5a;
   }

   @Generated
   public void I_method_177929d4(PlayerEntity var1) {
      this.I_field_88955355 = var1;
   }
}
