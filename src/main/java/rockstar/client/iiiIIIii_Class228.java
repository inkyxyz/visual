package rockstar.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIiII_Class245;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.iiiIIIIi_Class226;
import ua.mintantileak.spk.Compile;

public class iiiIIIii_Class228
extends iiiIIIIi_Class226 {
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final Nested1_98c0c5f6 I_field_c30fcf51 = new Nested1_98c0c5f6();
    private long I_field_4a;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c() == null && !this.I_field_991c1e8c.I_method_58432069(this.I_field_4a) && this.aura().I_method_497abf22().i_method_f85f3850() instanceof iiiIIIii_Class228) {
            iiIIiIIii_Class404 iiIIiIIii_Class4042 = RockstarClient.getInstance().I_method_58785402().I_method_fb1d7ad5();
            iiIIiIIii_Class4042 = iiIIiIIii_Class4042.I_method_c50b8f35(iIIiiiiiI_Class319.iI_method_330da892(-8.0f, 5.0f), iIIiiiiiI_Class319.iI_method_330da892(-5.0f, 8.0f));
            float f = iIIiiiiiI_Class319.iI_method_330da892(65.0f, 95.0f);
            float f2 = iIIiiiiiI_Class319.iI_method_330da892(30.0f, 45.0f);
            RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.Ii_field_32e0c64c, f, f2, 90.0f, iiIIiIiiI_Class407.II_field_32efc66c);
        }
    };

    public iiiIIIii_Class228(ModeSetting iIiiiiiII_Class125) {
        super(iIiiiiiII_Class125, "SpookyTime");
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    @Override
    @Compile(obfuscation=1)
    public void rotate(iiIIiIiII_Class405 iiIIiIiII_Class4052, float f, boolean bl, boolean bl2, iiIIiIIIi_Class402 iiIIiIIIi_Class4022, LivingEntity livingEntity) {
        if (livingEntity == null || iiiIIIii_Class228.I_field_3a9bda27.player == null) {
            return;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = this.I_field_c30fcf51.I_method_73d28343(livingEntity, iiIIiIiII_Class4052.i_method_10b2eeb5());
        iiIIiIiII_Class4052.I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class4022, 180.0f, 180.0f, 90.0f, iiIIiIiiI_Class407.II_field_32efc66c);
        this.I_field_991c1e8c.I_method_23e11e3f();
        this.I_field_4a = (long)iIIiiiiiI_Class319.iI_method_330da892(700.0f, 1000.0f);
    }

    @Override
    public void attack() {
        LivingEntity livingEntity = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
        if (livingEntity != null) {
            this.I_field_c30fcf51.I_method_f0404a99(livingEntity);
        }
    }

    @Override
    public void targetNull() {
        this.I_field_c30fcf51.I_method_b0648784();
    }

    @Override
    public boolean canAttack() {
        LivingEntity livingEntity = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
        if (livingEntity == null || iiiIIIii_Class228.I_field_3a9bda27.player == null) {
            return false;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
        return this.I_field_c30fcf51.I_method_9badd631(livingEntity, this.aura().I_method_af0f42().Ii_method_a20abcd2(), 58.0f, iiIIiIIii_Class4042);
    }

    final class Nested1_98c0c5f6 {
        private static final String I_field_523beb0a = "/assets/rockstar/ml/rotation/profile.json";
        private static final Gson I_field_fbd77e28 = new GsonBuilder().create();
        private final Nested1_98c0c616 I_field_c30fd331 = new Nested1_98c0c616();
        private final Nested1_f46950d3 I_field_16cef9fc = new Nested1_f46950d3();
        private Nested1_f46950b3 I_field_16cef61c = this.I_method_c85d622e();

        Nested1_98c0c5f6() {
        }

        iiIIiIIii_Class404 I_method_73d28343(LivingEntity livingEntity, iiIIiIIii_Class404 iiIIiIIii_Class4042) {
            this.i_method_b0731364();
            Vec3d vec3d = this.I_method_1ec94053(livingEntity);
            Vec3d vec3d2 = iIIiIIiIi_Class294.I_field_3a9bda27.player.getEyePos();
            Vec3d vec3d3 = vec3d.subtract(vec3d2);
            Vec3d vec3d4 = this.I_method_92b5a291(vec3d3, livingEntity);
            float f = (float)Math.toDegrees(Math.atan2(vec3d4.z, vec3d4.x)) - 90.0f;
            float f2 = (float)(-Math.toDegrees(Math.atan2(vec3d4.y, Math.hypot(vec3d4.x, vec3d4.z))));
            float f3 = MathHelper.wrapDegrees((float)(f - iiIIiIIii_Class4042.I_method_14534e0f()));
            float f4 = MathHelper.wrapDegrees((float)(f2 - iiIIiIIii_Class4042.i_method_1461d9ef()));
            float f5 = this.i_method_b0731354();
            float f6 = (float)(this.I_field_16cef61c.rotation.I_field_44 * (double)f5);
            float f7 = (float)(this.I_field_16cef61c.rotation.i_field_44 * (double)f5);
            float f8 = MathHelper.clamp((float)f3, (float)(-f6), (float)f6);
            float f9 = MathHelper.clamp((float)f4, (float)(-f7), (float)f7);
            float f10 = (float)this.I_field_16cef61c.rotation.II_field_44;
            f8 *= f10;
            f9 *= f10;
            float f11 = (float)(this.I_field_16cef61c.rotation.Ii_field_44 * (double)this.II_method_5c3b604d());
            this.I_field_c30fd331.I_field_46 = f8 += this.I_method_296dae74(-f11, f11);
            this.I_field_c30fd331.i_field_46 = f9 += this.I_method_296dae74(-f11, f11);
            return new iiIIiIIii_Class404(iiIIiIIii_Class4042.I_method_14534e0f() + f8, MathHelper.clamp((float)(iiIIiIIii_Class4042.i_method_1461d9ef() + f9), (float)-90.0f, (float)90.0f));
        }

        boolean I_method_9badd631(LivingEntity livingEntity, float f, float f2, iiIIiIIii_Class404 iiIIiIIii_Class4042) {
            this.i_method_b0731364();
            long l = System.currentTimeMillis();
            if (this.I_field_c30fd331.I_field_966247a3 != livingEntity) {
                if (l - this.I_field_c30fd331.I_field_4a < (long)this.I_field_16cef61c.attack_pattern.ii_field_49) {
                    return false;
                }
                this.I_field_c30fd331.I_field_966247a3 = livingEntity;
                this.I_field_c30fd331.I_field_4a = l;
            }
            if (iIIiIIiIi_Class294.I_field_3a9bda27.player.distanceTo((Entity)livingEntity) > f) {
                return false;
            }
            Vec3d vec3d = iiIIiIIii_Class4042.I_method_cbcdd559().normalize();
            Vec3d vec3d2 = livingEntity.getBoundingBox().getCenter().subtract(iIIiIIiIi_Class294.I_field_3a9bda27.player.getEyePos());
            if (vec3d2.lengthSquared() > 1.0E-6 && vec3d.dotProduct(vec3d2.normalize()) < Math.cos(Math.toRadians(f2))) {
                return false;
            }
            return this.I_method_17c97f4f(livingEntity, l);
        }

        private boolean I_method_17c97f4f(LivingEntity livingEntity, long l) {
            long l2;
            float f = livingEntity.getHealth();
            float f2 = iIIiIIiIi_Class294.I_field_3a9bda27.player.getHealth();
            double d = iIIiIIiIi_Class294.I_field_3a9bda27.player.distanceTo((Entity)livingEntity);
            double d2 = 0.5;
            if (f < 6.0f) {
                d2 += 0.3;
            }
            if (f < 3.0f) {
                d2 += 0.4;
            }
            if (f2 < 8.0f) {
                d2 += 0.2;
            }
            if (f2 < 4.0f) {
                d2 += 0.3;
            }
            if (d < 2.0) {
                d2 += 0.2;
            }
            if (d > 4.0) {
                d2 -= 0.2;
            }
            if ((l2 = l - this.I_field_c30fd331.II_field_4a) < 150L) {
                d2 -= 0.3;
            }
            if (this.I_field_c30fd331.I_field_5a) {
                if (this.I_field_c30fd331.i_field_49 >= this.I_field_16cef61c.attack_pattern.I_field_49 || l > this.I_field_c30fd331.i_field_4a) {
                    this.I_field_c30fd331.I_field_5a = false;
                    d2 -= 0.4;
                } else {
                    d2 += 0.3;
                }
            }
            if (ThreadLocalRandom.current().nextDouble() < this.I_field_16cef61c.human_mimic.i_field_44) {
                d2 -= 0.5;
            }
            if (this.I_field_16cef61c.human_mimic.I_field_5a && f <= 0.5f) {
                d2 -= 0.8;
            }
            return d2 > 0.6;
        }

        private long I_method_b0648778() {
            this.i_method_b0731364();
            float f = this.I_method_b0648774();
            float f2 = (float)this.I_field_16cef61c.attack_pattern.Ii_field_49 * f;
            float f3 = (float)this.I_field_16cef61c.attack_pattern.iI_field_49 * f;
            long l = (long)ThreadLocalRandom.current().nextDouble(f2, f3);
            return Math.max(20L, l += (long)ThreadLocalRandom.current().nextInt(-8, 8));
        }

        private float I_method_b0648774() {
            float f = 1.0f;
            if (iIIiIIiIi_Class294.I_field_3a9bda27.player.getHealth() < 6.0f) {
                f *= 0.85f;
            }
            if (System.currentTimeMillis() - this.I_field_c30fd331.II_field_4a > 15000L) {
                f *= 1.15f;
            }
            return MathHelper.clamp((float)f, (float)0.7f, (float)1.4f);
        }

        private Vec3d I_method_1ec94053(LivingEntity livingEntity) {
            String string;
            Box box = IiiiiIiII_Class245.I_method_96435a81((Entity)livingEntity, iiiIIIii_Class228.this.aura().I_method_d798ad5d().isSelected());
            double d = switch (string = this.I_field_16cef61c.attack_pattern.I_field_523beb0a) {
                case "head" -> 0.85;
                case "chest" -> 0.65;
                case "health" -> {
                    if (livingEntity.getHealth() < 8.0f) {
                        yield 0.85;
                    }
                    yield 0.55;
                }
                default -> 0.65;
            };
            d += ThreadLocalRandom.current().nextDouble(-0.07, 0.07);
            d = MathHelper.clamp((double)d, (double)0.05, (double)0.95);
            return new Vec3d(box.minX + (box.maxX - box.minX) * (0.3 + ThreadLocalRandom.current().nextDouble(0.4)), box.minY + (box.maxY - box.minY) * d, box.minZ + (box.maxZ - box.minZ) * (0.3 + ThreadLocalRandom.current().nextDouble(0.4)));
        }

        private Vec3d I_method_92b5a291(Vec3d vec3d, LivingEntity livingEntity) {
            Vec3d vec3d2 = livingEntity.getVelocity();
            float f = (float)(this.I_field_16cef61c.rotation.iI_field_44 * 0.1);
            return new Vec3d(vec3d.x + vec3d2.x * (double)f, vec3d.y, vec3d.z + vec3d2.z * (double)f);
        }

        private float i_method_b0731354() {
            float f = 1.0f;
            if (iIIiIIiIi_Class294.I_field_3a9bda27.player.getHealth() < 6.0f) {
                f *= 1.3f;
            }
            if (this.I_field_c30fd331.I_field_5a) {
                f *= 1.2f;
            }
            return MathHelper.clamp((float)f, (float)0.6f, (float)1.5f);
        }

        private float II_method_5c3b604d() {
            float f = 1.0f;
            if (iIIiIIiIi_Class294.I_field_3a9bda27.player.hurtTime > 0) {
                f *= 2.5f;
            }
            if (this.I_field_c30fd331.I_field_5a) {
                f *= 1.3f;
            }
            return MathHelper.clamp((float)f, (float)0.5f, (float)3.0f);
        }

        void I_method_f0404a99(LivingEntity livingEntity) {
            long l;
            this.i_method_b0731364();
            this.I_field_c30fd331.II_field_4a = l = System.currentTimeMillis();
            if (!this.I_field_c30fd331.I_field_5a) {
                this.I_field_c30fd331.I_field_5a = true;
                this.I_field_c30fd331.i_field_49 = 0;
                int n = ThreadLocalRandom.current().nextInt(this.I_field_16cef61c.attack_pattern.i_field_49, this.I_field_16cef61c.attack_pattern.II_field_49);
                this.I_field_c30fd331.i_field_4a = l + (long)n;
            }
            ++this.I_field_c30fd331.i_field_49;
            this.I_field_16cef9fc.I_field_7865b31.add(l);
            this.I_field_16cef9fc.I_field_7865b31.removeIf(l2 -> l - l2 > 1000L);
            this.I_field_16cef9fc.I_field_46 = this.I_field_16cef9fc.I_field_7865b31.size();
            this.i_method_105f32b9(livingEntity);
        }

        private void i_method_105f32b9(LivingEntity livingEntity) {
            float f;
            if (livingEntity instanceof PlayerEntity && (f = livingEntity.getHealth()) > 12.0f && this.I_field_c30fd331.I_field_b4b[this.I_field_c30fd331.I_field_49] < 5.0f) {
                this.I_field_16cef61c.attack_pattern.I_field_523beb0a = "head";
            }
        }

        private int I_method_b0648777() {
            this.i_method_b0731364();
            return ThreadLocalRandom.current().nextInt(this.I_field_16cef61c.human_mimic.I_field_49, this.I_field_16cef61c.human_mimic.i_field_49);
        }

        private boolean I_method_b0648788() {
            this.i_method_b0731364();
            return ThreadLocalRandom.current().nextDouble() < this.I_field_16cef61c.human_mimic.I_field_44;
        }

        void I_method_b0648784() {
            this.I_field_c30fd331.I_field_966247a3 = null;
        }

        private void i_method_b0731364() {
            if (this.I_field_16cef61c == null || this.I_field_16cef61c.attack_pattern == null || this.I_field_16cef61c.human_mimic == null || this.I_field_16cef61c.rotation == null) {
                this.I_field_16cef61c = this.i_method_65766a4e();
            }
        }

        /*
         * Enabled aggressive exception aggregation
         */
        private Nested1_f46950b3 I_method_c85d622e() {
            try (InputStream inputStream = iiiIIIii_Class228.class.getResourceAsStream(I_field_523beb0a);){
                Nested1_f46950b3 nested1_f46950b3;
                if (inputStream == null) {
                    Nested1_f46950b3 nested1_f46950b32 = this.i_method_65766a4e();
                    return nested1_f46950b32;
                }
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));){
                    Nested1_f46950b3 nested1_f46950b33 = (Nested1_f46950b3)I_field_fbd77e28.fromJson((Reader)bufferedReader, Nested1_f46950b3.class);
                    nested1_f46950b3 = nested1_f46950b33 == null ? this.i_method_65766a4e() : nested1_f46950b33;
                }
                return nested1_f46950b3;
            }
            catch (Exception exception) {
                return this.i_method_65766a4e();
            }
        }

        private Nested1_f46950b3 i_method_65766a4e() {
            Nested1_f46950b3 nested1_f46950b3 = new Nested1_f46950b3();
            nested1_f46950b3.name = "AggressivePlayer";
            nested1_f46950b3.version = 1.0;
            nested1_f46950b3.attack_pattern = new Nested1_f46950b3.Nested2_7f57f498();
            nested1_f46950b3.attack_pattern.I_field_49 = 5;
            nested1_f46950b3.attack_pattern.i_field_49 = 120;
            nested1_f46950b3.attack_pattern.II_field_49 = 280;
            nested1_f46950b3.attack_pattern.I_field_44 = 12.0;
            nested1_f46950b3.attack_pattern.i_field_44 = 18.5;
            nested1_f46950b3.attack_pattern.II_field_44 = 0.85;
            nested1_f46950b3.attack_pattern.Ii_field_49 = 32;
            nested1_f46950b3.attack_pattern.iI_field_49 = 67;
            nested1_f46950b3.attack_pattern.I_field_523beb0a = "head";
            nested1_f46950b3.attack_pattern.ii_field_49 = 180;
            nested1_f46950b3.human_mimic = new Nested1_f46950b3.Nested2_7f57f4b8();
            nested1_f46950b3.human_mimic.I_field_49 = 55;
            nested1_f46950b3.human_mimic.i_field_49 = 130;
            nested1_f46950b3.human_mimic.I_field_44 = 0.21;
            nested1_f46950b3.human_mimic.i_field_44 = 0.07;
            nested1_f46950b3.human_mimic.I_field_5a = false;
            nested1_f46950b3.rotation = new Nested1_f46950b3.Nested2_6ba69eb1();
            nested1_f46950b3.rotation.I_field_44 = 110.0;
            nested1_f46950b3.rotation.i_field_44 = 58.0;
            nested1_f46950b3.rotation.II_field_44 = 0.68;
            nested1_f46950b3.rotation.Ii_field_44 = 0.35;
            nested1_f46950b3.rotation.iI_field_44 = 0.52;
            return nested1_f46950b3;
        }

        private float I_method_296dae74(float f, float f2) {
            return (float)ThreadLocalRandom.current().nextDouble(f, f2);
        }
    }

    static final class Nested1_f46950b3 {
        String name;
        double version;
        Nested2_7f57f498 attack_pattern;
        Nested2_7f57f4b8 human_mimic;
        Nested2_6ba69eb1 rotation;

        Nested1_f46950b3() {
        }

        static final class Nested2_6ba69eb1 {
            double I_field_44;
            double i_field_44;
            double II_field_44;
            double Ii_field_44;
            double iI_field_44;

            Nested2_6ba69eb1() {
            }
        }

        static final class Nested2_7f57f4b8 {
            int I_field_49;
            int i_field_49;
            double I_field_44;
            double i_field_44;
            boolean I_field_5a;

            Nested2_7f57f4b8() {
            }
        }

        static final class Nested2_7f57f498 {
            int I_field_49;
            int i_field_49;
            int II_field_49;
            double I_field_44;
            double i_field_44;
            double II_field_44;
            int Ii_field_49;
            int iI_field_49;
            String I_field_523beb0a;
            int ii_field_49;

            Nested2_7f57f498() {
            }
        }
    }

    static final class Nested1_f46950d3 {
        private long I_field_4a;
        private boolean I_field_5a;
        private int I_field_49;
        private long i_field_4a;
        float I_field_46 = 10.0f;
        final List<Long> I_field_7865b31 = new ArrayList<Long>();

        Nested1_f46950d3() {
        }
    }

    static final class Nested1_98c0c616 {
        float I_field_46;
        float i_field_46;
        final float[] I_field_b4b = new float[20];
        int I_field_49;
        long I_field_4a;
        private String I_field_523beb0a = "health";
        boolean I_field_5a;
        int i_field_49;
        long i_field_4a;
        long II_field_4a;
        LivingEntity I_field_966247a3;
        private final Map<String, Float> I_field_a567c40b = new ConcurrentHashMap<String, Float>();

        Nested1_98c0c616() {
        }
    }
}

