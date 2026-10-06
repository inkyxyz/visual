package rockstar.client;

import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIiII_Class245;
import rockstar.client.IiiiiiIii_Class252;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.AuraModule;
import rockstar.client.SpeedModule;
import ua.mintantileak.spk.Compile;

public final class iiIIiIiIi_Class406
implements iIIiIIiIi_Class294 {
    @Compile(obfuscation=1)
    public static Vec3d I_method_396699c1(Entity entity) {
        Vec3d vec3d = iiIIiIiIi_Class406.I_field_3a9bda27.player.getEyePos();
        return new Vec3d(MathHelper.clamp((double)vec3d.x, (double)entity.getBoundingBox().minX, (double)entity.getBoundingBox().maxX), MathHelper.clamp((double)vec3d.y, (double)entity.getBoundingBox().minY, (double)entity.getBoundingBox().maxY), MathHelper.clamp((double)vec3d.z, (double)entity.getBoundingBox().minZ, (double)entity.getBoundingBox().maxZ));
    }

    @Compile(obfuscation=1)
    public static Vec3d I_method_47b889e6(LivingEntity livingEntity, Vec3d vec3d) {
        return iiIIiIiIi_Class406.I_method_396699c1((Entity)livingEntity).subtract(livingEntity.getPos()).add(vec3d);
    }

    @Compile(obfuscation=1)
    public static iiIIiIIii_Class404 I_method_bc8095a1(Vec3d vec3d) {
        double d = vec3d.getX();
        double d2 = vec3d.getY();
        double d3 = vec3d.getZ();
        double d4 = d - iiIIiIiIi_Class406.I_field_3a9bda27.player.getX();
        double d5 = d2 - (iiIIiIiIi_Class406.I_field_3a9bda27.player.getY() + (double)iiIIiIiIi_Class406.I_field_3a9bda27.player.getEyeHeight(iiIIiIiIi_Class406.I_field_3a9bda27.player.getPose()));
        double d6 = d3 - iiIIiIiIi_Class406.I_field_3a9bda27.player.getZ();
        double d7 = Math.sqrt(d4 * d4 + d6 * d6);
        float f = (float)Math.toDegrees(Math.atan2(d6, d4)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d5, d7)));
        return new iiIIiIIii_Class404(f, f2);
    }

    @Compile(obfuscation=1)
    public static iiIIiIIii_Class404 I_method_89bc9935(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = vec3d2.y - vec3d.y;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new iiIIiIIii_Class404(f, f2);
    }

    @Compile(obfuscation=1)
    public static float I_method_73b181cf() {
        double d = (Double)iiIIiIiIi_Class406.I_field_3a9bda27.options.getMouseSensitivity().getValue();
        double d2 = d * (double)0.6f + (double)0.2f;
        return (float)(d2 * d2 * d2 * (double)1.2f);
    }

    @NotNull
    @Compile(obfuscation=1)
    public static iiIIiIIii_Class404 I_method_565091b5(@NotNull iiIIiIIii_Class404 iiIIiIIii_Class4042, @NotNull iiIIiIIii_Class404 iiIIiIIii_Class4043) {
        float f = iiIIiIiIi_Class406.I_method_73b181cf();
        float f2 = MathHelper.wrapDegrees((float)(iiIIiIIii_Class4043.I_method_14534e0f() - iiIIiIIii_Class4042.I_method_14534e0f()));
        float f3 = iiIIiIIii_Class4043.i_method_1461d9ef() - iiIIiIIii_Class4042.i_method_1461d9ef();
        f2 = (float)Math.round(f2 / f) * f;
        f3 = (float)Math.round(f3 / f) * f;
        return new iiIIiIIii_Class404(iiIIiIIii_Class4042.I_method_14534e0f() + f2, MathHelper.clamp((float)(iiIIiIIii_Class4042.i_method_1461d9ef() + f3), (float)-90.0f, (float)90.0f));
    }

    @Compile(obfuscation=1)
    public static float I_method_4d657e0f(float f, float f2) {
        return iiIIiIiIi_Class406.I_method_565091b5(new iiIIiIIii_Class404(f, 0.0f), new iiIIiIIii_Class404(f2, 0.0f)).I_method_14534e0f();
    }

    @Compile(obfuscation=1)
    public static float i_method_840091ef(float f, float f2) {
        return iiIIiIiIi_Class406.I_method_565091b5(new iiIIiIIii_Class404(0.0f, f), new iiIIiIIii_Class404(0.0f, f2)).i_method_1461d9ef();
    }

    @Compile(obfuscation=1)
    public static int I_method_4d657e12(float f, float f2) {
        float f3 = iiIIiIiIi_Class406.I_method_73b181cf();
        return Math.round(MathHelper.wrapDegrees((float)(f2 - f)) / f3);
    }

    @Compile(obfuscation=1)
    public static int i_method_840091f2(float f, float f2) {
        float f3 = iiIIiIiIi_Class406.I_method_73b181cf();
        return Math.round((f2 - f) / f3);
    }

    @Compile(obfuscation=1)
    public static float II_method_95f3d8d2(float f, float f2) {
        float f3;
        for (f3 = f2 - f; f3 > 180.0f; f3 -= 360.0f) {
        }
        while (f3 < -180.0f) {
            f3 += 360.0f;
        }
        return f3;
    }

    @Compile(obfuscation=1)
    public static float I_method_5f4aad71(float f, float f2, float f3) {
        float f4;
        float f5 = f % 360.0f;
        if (f5 < 0.0f) {
            f5 += 360.0f;
        }
        if ((f4 = f2 % 360.0f) < 0.0f) {
            f4 += 360.0f;
        }
        int n = (int)(f / 360.0f);
        if (f < 0.0f && f % 360.0f != 0.0f) {
            --n;
        }
        float f6 = f4 + (float)(n * 360);
        float f7 = f4 - f5;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        if (f7 <= f3) {
            return f + f7;
        }
        float f8 = f6 - f;
        if (f8 > 180.0f) {
            f6 -= 360.0f;
        } else if (f8 < -180.0f) {
            f6 += 360.0f;
        }
        return f6;
    }

    @Compile(obfuscation=1)
    public static float Ii_method_cc8eecb2(float f, float f2) {
        float f3;
        float f4;
        float f5;
        float f6 = f % 360.0f;
        if (f6 < 0.0f) {
            f6 += 360.0f;
        }
        if ((f5 = f2 % 360.0f) < 0.0f) {
            f5 += 360.0f;
        }
        int n = (int)(f / 360.0f);
        if (f < 0.0f && f % 360.0f != 0.0f) {
            --n;
        }
        if ((f4 = (f3 = f5 + (float)(n * 360)) - f) > 180.0f) {
            f3 -= 360.0f;
        } else if (f4 < -180.0f) {
            f3 += 360.0f;
        }
        return f3;
    }

    @Compile(obfuscation=1)
    public static iiIIiIIii_Class404 I_method_a2bb2af5(LivingEntity livingEntity, AuraModule iiIiIIRockstarClient102) {
        Vec3d vec3d = IiiiiIiII_Class245.I_method_34612227((Entity)livingEntity, iiIiIIRockstarClient102.I_method_d798ad5d().isSelected());
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_bc8095a1(iiIIiIiIi_Class406.I_method_47b889e6(livingEntity, vec3d));
        if (iiIIiIiIi_Class406.I_field_3a9bda27.player.getEyePos().distanceTo(livingEntity.getEyePos()) < 3.0) {
            vec3d = IiiiiIiII_Class245.I_method_34612227((Entity)livingEntity, iiIiIIRockstarClient102.I_method_d798ad5d().isSelected()).add(0.0, (double)(livingEntity.getHeight() / 2.0f), 0.0);
            iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_bc8095a1(vec3d);
            if (RockstarClient.getInstance().getModuleManager().getModule(SpeedModule.class).isEnabled()) {
                Vec3d vec3d2 = IiiiiiIii_Class252.I_method_34ed4d41((Entity)livingEntity);
            }
        }
        if (iiIIiIIii_Class4042.i_method_1461d9ef() == (float)((int)iiIIiIIii_Class4042.i_method_1461d9ef())) {
            iiIIiIIii_Class4042.i_method_77d9cda1(Math.clamp(iiIIiIIii_Class4042.i_method_1461d9ef() + iIIiiiiiI_Class319.iI_method_330da892(-1.0f, 1.0f), -90.0f, 90.0f));
        }
        if (iiIIiIIii_Class4042.I_method_14534e0f() == (float)((int)iiIIiIIii_Class4042.I_method_14534e0f())) {
            iiIIiIIii_Class4042.I_method_7616dd81(iiIIiIIii_Class4042.I_method_14534e0f() + iIIiiiiiI_Class319.iI_method_330da892(-1.0f, 1.0f));
        }
        return iiIIiIIii_Class4042;
    }

    @Generated
    private iiIIiIiIi_Class406() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

