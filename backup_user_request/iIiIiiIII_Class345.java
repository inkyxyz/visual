package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class iIiIiiIII_Class345 {
    private static final double I_field_44 = 0.08;
    private static final double i_field_44 = 0.98;
    private static final double II_field_44 = 0.546;
    private static final double Ii_field_44 = 0.05;
    private static final double iI_field_44 = Math.PI * 2;
    private final List<Vec3d> I_field_7865b31 = new ArrayList<Vec3d>();
    private final List<Long> i_field_7865b31 = new ArrayList<Long>();
    private int I_field_49 = -1;
    private Vec3d I_field_5bba0d50 = Vec3d.ZERO;
    private Vec3d i_field_5bba0d50 = Vec3d.ZERO;
    private Vec3d II_field_5bba0d50 = Vec3d.ZERO;

    public void I_method_b1940601(LivingEntity livingEntity, float f, int n) {
        if (livingEntity == null) {
            this.I_method_ef528dff();
            return;
        }
        int n2 = livingEntity.getId();
        if (n2 != this.I_field_49) {
            this.I_field_49 = n2;
            this.I_method_ef528dff();
        }
        double d = livingEntity.prevX + (livingEntity.getX() - livingEntity.prevX) * (double)f;
        double d2 = livingEntity.prevY + (livingEntity.getY() - livingEntity.prevY) * (double)f;
        double d3 = livingEntity.prevZ + (livingEntity.getZ() - livingEntity.prevZ) * (double)f;
        Vec3d vec3d = new Vec3d(d, d2, d3);
        long l = System.currentTimeMillis();
        this.I_field_7865b31.add(vec3d);
        this.i_field_7865b31.add(l);
        while (this.I_field_7865b31.size() > n) {
            this.I_field_7865b31.removeFirst();
            this.i_field_7865b31.removeFirst();
        }
        this.i_method_ef6119df();
    }

    private void i_method_ef6119df() {
        if (this.I_field_7865b31.size() < 2) {
            this.i_field_5bba0d50 = Vec3d.ZERO;
            this.II_field_5bba0d50 = Vec3d.ZERO;
            return;
        }
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        for (int i = 1; i < this.I_field_7865b31.size(); ++i) {
            arrayList.add(this.I_field_7865b31.get(i).subtract(this.I_field_7865b31.get(i - 1)));
        }
        this.i_field_5bba0d50 = (Vec3d)arrayList.getLast();
        if (arrayList.size() >= 2) {
            ArrayList<Vec3d> arrayList2 = new ArrayList<Vec3d>();
            for (int i = 1; i < arrayList.size(); ++i) {
                arrayList2.add(((Vec3d)arrayList.get(i)).subtract((Vec3d)arrayList.get(i - 1)));
            }
            Vec3d vec3d = Vec3d.ZERO;
            double d = 0.0;
            for (int i = 0; i < arrayList2.size(); ++i) {
                double d2 = Math.pow(0.85, arrayList2.size() - 1 - i);
                vec3d = vec3d.add(((Vec3d)arrayList2.get(i)).multiply(d2));
                d += d2;
            }
            this.II_field_5bba0d50 = d > 0.0 ? vec3d.multiply(1.0 / d) : Vec3d.ZERO;
        }
    }

    public Vec3d I_method_5cd2f842(LivingEntity livingEntity, int n, float f, boolean bl, boolean bl2, int n2) {
        Vec3d vec3d;
        if (livingEntity == null || n <= 0) {
            return new Vec3d(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
        }
        double d = livingEntity.prevX + (livingEntity.getX() - livingEntity.prevX) * (double)f;
        double d2 = livingEntity.prevY + (livingEntity.getY() - livingEntity.prevY) * (double)f;
        double d3 = livingEntity.prevZ + (livingEntity.getZ() - livingEntity.prevZ) * (double)f;
        Vec3d vec3d2 = new Vec3d(d, d2, d3);
        Vec3d vec3d3 = Vec3d.ZERO;
        if (bl && this.I_field_7865b31.size() >= 3) {
            vec3d3 = vec3d3.add(this.I_method_7e1c55e(n));
        }
        if (bl2 && this.I_field_7865b31.size() >= 5 && (vec3d = this.I_method_bf3b11d9(n, n2)) != null) {
            vec3d3 = vec3d3.multiply(0.6).add(vec3d.multiply(0.4));
        }
        if ((vec3d = this.I_method_6f8df13f(livingEntity, n)) != null) {
            vec3d3 = vec3d3.multiply(0.7).add(vec3d.multiply(0.3));
        }
        this.I_field_5bba0d50 = vec3d2.add(vec3d3);
        return this.I_field_5bba0d50;
    }

    private Vec3d I_method_7e1c55e(int n) {
        double d = (double)n * 0.05;
        return this.i_field_5bba0d50.multiply((double)n).add(this.II_field_5bba0d50.multiply(0.5 * d * d));
    }

    private Vec3d I_method_bf3b11d9(int n, int n2) {
        int n3 = Math.min(this.I_field_7865b31.size(), n2);
        if (n3 < 5) {
            return null;
        }
        if (this.I_method_faffa4e8(n3)) {
            return this.i_method_47221db9(n, n3);
        }
        if (this.i_method_fcc29508(n3)) {
            return this.i_field_5bba0d50.multiply((double)n);
        }
        Vec3d vec3d = Vec3d.ZERO;
        double d = 0.0;
        for (int i = 1; i < n3; ++i) {
            Vec3d vec3d2 = this.I_field_7865b31.get(i).subtract(this.I_field_7865b31.get(i - 1));
            double d2 = Math.pow(0.9, n3 - i);
            vec3d = vec3d.add(vec3d2.multiply(d2));
            d += d2;
        }
        return d > 0.0 ? vec3d.multiply((double)n / d) : Vec3d.ZERO;
    }

    private boolean I_method_faffa4e8(int n) {
        if (n < 5) {
            return false;
        }
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (int i = 2; i < n; ++i) {
            Vec3d vec3d = this.I_field_7865b31.get(i - 1).subtract(this.I_field_7865b31.get(i - 2));
            Vec3d vec3d2 = this.I_field_7865b31.get(i).subtract(this.I_field_7865b31.get(i - 1));
            double d = Math.atan2(vec3d2.z, vec3d2.x) - Math.atan2(vec3d.z, vec3d.x);
            d = iIiIiiIII_Class345.I_method_faff920d(d);
            arrayList.add(Math.abs(d));
        }
        double d = arrayList.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double d3 = arrayList.stream().mapToDouble(d2 -> Math.pow(d2 - d, 2.0)).average().orElse(1.0);
        return d3 < 0.1 && d > 0.05;
    }

    private Vec3d i_method_47221db9(int n, int n2) {
        Vec3d vec3d = this.i_method_e2f9bd7e(n2);
        Vec3d vec3d2 = this.I_field_7865b31.get(n2 - 1);
        Vec3d vec3d3 = this.I_field_7865b31.get(n2 - 2);
        double d = Math.atan2(vec3d2.z - vec3d.z, vec3d2.x - vec3d.x);
        double d2 = Math.atan2(vec3d3.z - vec3d.z, vec3d3.x - vec3d.x);
        double d3 = iIiIiiIII_Class345.I_method_faff920d(d - d2);
        double d4 = vec3d2.subtract(vec3d).horizontalLength();
        double d5 = d + d3 * (double)n;
        double d6 = vec3d.x + d4 * Math.cos(d5);
        double d7 = vec3d.z + d4 * Math.sin(d5);
        double d8 = vec3d2.y + this.i_field_5bba0d50.y * (double)n;
        return new Vec3d(d6 - vec3d2.x, d8 - vec3d2.y, d7 - vec3d2.z);
    }

    private Vec3d i_method_e2f9bd7e(int n) {
        if (n < 3) {
            return this.I_field_7865b31.get(n - 1);
        }
        Vec3d vec3d = this.I_field_7865b31.get(n - 3);
        Vec3d vec3d2 = this.I_field_7865b31.get(n - 2);
        Vec3d vec3d3 = this.I_field_7865b31.get(n - 1);
        double d = 2.0 * (vec3d.x * (vec3d2.z - vec3d3.z) + vec3d2.x * (vec3d3.z - vec3d.z) + vec3d3.x * (vec3d.z - vec3d2.z));
        if (Math.abs(d) < 0.001) {
            return vec3d2;
        }
        double d2 = ((vec3d.x * vec3d.x + vec3d.z * vec3d.z) * (vec3d2.z - vec3d3.z) + (vec3d2.x * vec3d2.x + vec3d2.z * vec3d2.z) * (vec3d3.z - vec3d.z) + (vec3d3.x * vec3d3.x + vec3d3.z * vec3d3.z) * (vec3d.z - vec3d2.z)) / d;
        double d3 = ((vec3d.x * vec3d.x + vec3d.z * vec3d.z) * (vec3d3.x - vec3d2.x) + (vec3d2.x * vec3d2.x + vec3d2.z * vec3d2.z) * (vec3d.x - vec3d3.x) + (vec3d3.x * vec3d3.x + vec3d3.z * vec3d3.z) * (vec3d2.x - vec3d.x)) / d;
        return new Vec3d(d2, vec3d2.y, d3);
    }

    private boolean i_method_fcc29508(int n) {
        double d;
        Vec3d vec3d;
        if (n < 3) {
            return false;
        }
        Vec3d vec3d2 = this.I_field_7865b31.get(n - 1).subtract(this.I_field_7865b31.get(n - 2));
        double d2 = vec3d2.dotProduct(vec3d = this.I_field_7865b31.get(n - 2).subtract(this.I_field_7865b31.get(n - 3)));
        double d3 = Math.acos(MathHelper.clamp((double)(d2 / (d = vec3d2.length() * vec3d.length() + 0.001)), (double)-1.0, (double)1.0));
        return d3 < 0.15;
    }

    private Vec3d I_method_6f8df13f(LivingEntity livingEntity, int n) {
        if (!(livingEntity instanceof PlayerEntity)) {
            return null;
        }
        PlayerEntity playerEntity = (PlayerEntity)livingEntity;
        double d = playerEntity.getVelocity().x;
        double d2 = playerEntity.getVelocity().y;
        double d3 = playerEntity.getVelocity().z;
        boolean bl = playerEntity.isOnGround();
        Vec3d vec3d = Vec3d.ZERO;
        for (int i = 0; i < n; ++i) {
            d2 -= 0.08;
            if (bl) {
                d *= 0.546;
                d3 *= 0.546;
            } else {
                d *= 0.98;
                d3 *= 0.98;
            }
            vec3d = vec3d.add(d, d2, d3);
            if (!(vec3d.y < livingEntity.getY() - (double)livingEntity.getHeight())) continue;
            bl = true;
            d2 = 0.0;
        }
        return vec3d;
    }

    private static double I_method_faff920d(double d) {
        if ((d %= Math.PI * 2) < -Math.PI) {
            d += Math.PI * 2;
        }
        if (d > Math.PI) {
            d -= Math.PI * 2;
        }
        return d;
    }

    public void I_method_ef528dff() {
        this.I_field_7865b31.clear();
        this.i_field_7865b31.clear();
        this.I_field_49 = -1;
        this.I_field_5bba0d50 = Vec3d.ZERO;
        this.i_field_5bba0d50 = Vec3d.ZERO;
        this.II_field_5bba0d50 = Vec3d.ZERO;
    }

    @Generated
    public Vec3d I_method_33840d39() {
        return this.I_field_5bba0d50;
    }

    @Generated
    public Vec3d i_method_d77c9119() {
        return this.i_field_5bba0d50;
    }

    @Generated
    public Vec3d II_method_b02ad13c() {
        return this.II_field_5bba0d50;
    }
}

