package rockstar.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public final class iIIIiIIii_Class276 {
    private static final int I_field_49 = 15;
    private static final double I_field_44 = -0.08;
    private static final double i_field_44 = 0.99;
    private static final double II_field_44 = 0.98;
    private static final double Ii_field_44 = 0.99;
    private static final double iI_field_44 = 0.06;
    private static final double ii_field_44 = 0.1;
    private static final long I_field_4a = 30000L;
    private static final Map<UUID, List<Nested1_220a3880>> I_field_a567c40b = new ConcurrentHashMap<UUID, List<Nested1_220a3880>>();
    private static final Map<UUID, Nested1_220a38a0> i_field_a567c40b = new ConcurrentHashMap<UUID, Nested1_220a38a0>();
    private static final Map<UUID, Integer> II_field_a567c40b = new ConcurrentHashMap<UUID, Integer>();
    private static long i_field_4a = System.currentTimeMillis();

    public static Vec3d I_method_77201e0e(PlayerEntity playerEntity) {
        if (playerEntity == null) {
            return Vec3d.ZERO;
        }
        iIIIiIIii_Class276.I_method_1695194(playerEntity);
        if (!iIIIiIIii_Class276.I_method_1695198(playerEntity)) {
            return playerEntity.getPos();
        }
        int n = iIIIiIIii_Class276.I_method_1695187(playerEntity);
        return iIIIiIIii_Class276.I_method_37c7cf29(playerEntity, n);
    }

    public static void I_method_1695194(PlayerEntity playerEntity) {
        if (playerEntity == null) {
            return;
        }
        UUID uUID2 = playerEntity.getUuid();
        long l = System.currentTimeMillis();
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null) {
            return;
        }
        double d = playerEntity.distanceTo((Entity)minecraftClient.player);
        Nested1_220a3880 nested1_220a3880 = new Nested1_220a3880(playerEntity.getPos(), playerEntity.getVelocity(), playerEntity.getPitch(), playerEntity.getYaw(), playerEntity.isGliding(), l, d);
        List list = I_field_a567c40b.computeIfAbsent(uUID2, uUID -> new ArrayList());
        list.add(nested1_220a3880);
        if (list.size() > 15) {
            list.removeFirst();
        }
        iIIIiIIii_Class276.I_method_229d5fce(uUID2, nested1_220a3880);
        iIIIiIIii_Class276.I_method_3a5db8a5(l);
    }

    public static boolean I_method_1695198(PlayerEntity playerEntity) {
        if (!playerEntity.isGliding()) {
            return false;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.player == null) {
            return false;
        }
        UUID uUID = playerEntity.getUuid();
        List<Nested1_220a3880> list = I_field_a567c40b.get(uUID);
        if (list == null || list.size() < 3) {
            return false;
        }
        boolean bl = iIIIiIIii_Class276.I_method_157b2cf4(list);
        boolean bl2 = iIIIiIIii_Class276.I_method_e8bddaed(playerEntity, (PlayerEntity)minecraftClient.player);
        boolean bl3 = iIIIiIIii_Class276.i_method_305b0578(playerEntity);
        int n = 0;
        if (bl) {
            ++n;
        }
        if (bl2) {
            ++n;
        }
        if (bl3) {
            ++n;
        }
        return n >= 2;
    }

    private static boolean I_method_157b2cf4(List<Nested1_220a3880> list) {
        if (list.size() < 3) {
            return false;
        }
        int n = Math.min(5, list.size());
        List<Nested1_220a3880> list2 = list.subList(list.size() - n, list.size());
        int n2 = 0;
        for (int i = 1; i < list2.size(); ++i) {
            if (!(list2.get((int)i).I_field_44 > list2.get((int)(i - 1)).I_field_44)) continue;
            ++n2;
        }
        return n2 >= (list2.size() - 1) / 2;
    }

    private static boolean I_method_e8bddaed(PlayerEntity playerEntity, PlayerEntity playerEntity2) {
        Vec3d vec3d;
        Vec3d vec3d2 = playerEntity.getPos();
        Vec3d vec3d3 = playerEntity2.getPos();
        Vec3d vec3d4 = playerEntity.getVelocity();
        Vec3d vec3d5 = vec3d2.subtract(vec3d3).normalize();
        double d = vec3d5.dotProduct(vec3d = vec3d4.normalize());
        return d > 0.3;
    }

    private static boolean i_method_305b0578(PlayerEntity playerEntity) {
        double d = playerEntity.getVelocity().length();
        return d > 0.8;
    }

    private static Vec3d I_method_37c7cf29(PlayerEntity playerEntity, int n) {
        Vec3d vec3d = playerEntity.getPos();
        Vec3d vec3d2 = playerEntity.getVelocity();
        float f = playerEntity.getPitch();
        float f2 = playerEntity.getYaw();
        boolean bl = playerEntity.isGliding();
        for (int i = 0; i < n; ++i) {
            if (bl) {
                vec3d = iIIIiIIii_Class276.I_method_91874bf9(vec3d, vec3d2, f, f2);
                vec3d2 = iIIIiIIii_Class276.I_method_bce74325(vec3d2, f, f2);
                continue;
            }
            vec3d2 = vec3d2.add(0.0, -0.08, 0.0).multiply(0.98);
            vec3d = vec3d.add(vec3d2);
        }
        return vec3d;
    }

    private static Vec3d I_method_91874bf9(Vec3d vec3d, Vec3d vec3d2, float f, float f2) {
        return vec3d.add(vec3d2);
    }

    private static Vec3d I_method_bce74325(Vec3d vec3d, float f, float f2) {
        double d;
        double d2 = vec3d.x;
        double d3 = vec3d.y;
        double d4 = vec3d.z;
        float f3 = (float)Math.toRadians(f);
        float f4 = (float)Math.toRadians(f2);
        Vec3d vec3d2 = new Vec3d(-Math.sin(f4) * Math.cos(f3), -Math.sin(f3), Math.cos(f4) * Math.cos(f3));
        double d5 = Math.sqrt(d2 * d2 + d4 * d4);
        double d6 = Math.sqrt(vec3d2.x * vec3d2.x + vec3d2.z * vec3d2.z);
        float f5 = (float)Math.cos(f3);
        float f6 = f5 * f5;
        if ((d3 += -0.08 + (double)f6 * 0.06) < 0.0 && d6 > 0.0) {
            d = d3 * -0.1 * (double)f6;
            d3 += d;
            d2 += vec3d2.x * d / d6;
            d4 += vec3d2.z * d / d6;
        }
        if (f < 0.0f && d6 > 0.0) {
            d = d5 * -Math.sin(f3) * 0.04;
            d3 += d * 3.2;
            d2 -= vec3d2.x * d / d6;
            d4 -= vec3d2.z * d / d6;
        }
        if (d6 > 0.0) {
            d2 += (vec3d2.x / d6 * d5 - d2) * 0.1;
            d4 += (vec3d2.z / d6 * d5 - d4) * 0.1;
        }
        return new Vec3d(d2 *= 0.99, d3 *= 0.98, d4 *= 0.99);
    }

    private static int I_method_1695187(PlayerEntity playerEntity) {
        UUID uUID = playerEntity.getUuid();
        if (II_field_a567c40b.containsKey(uUID)) {
            return II_field_a567c40b.get(uUID);
        }
        int n = iIIIiIIii_Class276.i_method_305b0567(playerEntity);
        List<Nested1_220a3880> list = I_field_a567c40b.get(uUID);
        if (list == null || list.size() < 3) {
            return n;
        }
        double d = iIIIiIIii_Class276.I_method_157b2cde(list);
        double d2 = iIIIiIIii_Class276.i_method_9b5f8be(list);
        if (playerEntity.isGliding()) {
            double d3 = playerEntity.getVelocity().length();
            if (d3 > 2.0) {
                n += Math.min(4, (int)(d3 * 1.2));
            }
            if (d2 > 30.0) {
                n += 2;
            }
        }
        return Math.max(1, Math.min(15, n));
    }

    private static int i_method_305b0567(PlayerEntity playerEntity) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        int n = 100;
        if (minecraftClient.getNetworkHandler() != null) {
            try {
                PlayerListEntry playerListEntry = minecraftClient.getNetworkHandler().getPlayerListEntry(playerEntity.getUuid());
                if (playerListEntry != null) {
                    n = playerListEntry.getLatency();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        int n2 = Math.max(1, n / 50);
        int n3 = 2;
        return n2 + n3;
    }

    private static double I_method_157b2cde(List<Nested1_220a3880> list) {
        if (list.size() < 2) {
            return 0.0;
        }
        double[] dArray = list.stream().mapToDouble(nested1_220a3880 -> nested1_220a3880.i_field_5bba0d50.length()).toArray();
        double d = Arrays.stream(dArray).average().orElse(0.0);
        double d3 = Arrays.stream(dArray).map(d2 -> Math.pow(d2 - d, 2.0)).average().orElse(0.0);
        return Math.sqrt(d3);
    }

    private static double i_method_9b5f8be(List<Nested1_220a3880> list) {
        if (list.size() < 2) {
            return 0.0;
        }
        double d = 0.0;
        for (int i = 1; i < list.size(); ++i) {
            Nested1_220a3880 nested1_220a3880 = list.get(i - 1);
            Nested1_220a3880 nested1_220a38802 = list.get(i);
            double d2 = Math.abs(nested1_220a38802.i_field_46 - nested1_220a3880.i_field_46);
            double d3 = Math.abs(nested1_220a38802.I_field_46 - nested1_220a3880.I_field_46);
            if (d2 > 180.0) {
                d2 = 360.0 - d2;
            }
            d += Math.sqrt(d2 * d2 + d3 * d3);
        }
        return d / (double)(list.size() - 1);
    }

    private static void I_method_229d5fce(UUID uUID2, Nested1_220a3880 nested1_220a3880) {
        Nested1_220a38a0 nested1_220a38a0 = i_field_a567c40b.computeIfAbsent(uUID2, uUID -> new Nested1_220a38a0());
        nested1_220a38a0.I_method_6f3932e7(nested1_220a3880);
    }

    private static void I_method_3a5db8a5(long l) {
        if (l - i_field_4a < 30000L) {
            return;
        }
        i_field_4a = l;
        I_field_a567c40b.entrySet().removeIf(entry -> {
            List<Nested1_220a3880> list = (List<Nested1_220a3880>)entry.getValue();
            list.removeIf(nested1_220a3880 -> l - nested1_220a3880.I_field_4a > 30000L);
            return list.isEmpty();
        });
        i_field_a567c40b.entrySet().removeIf(entry -> l - ((Nested1_220a38a0)entry.getValue()).I_field_4a > 30000L);
    }

    @Generated
    private iIIIiIIii_Class276() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static class Nested1_220a3880 {
        public final Vec3d I_field_5bba0d50;
        public final Vec3d i_field_5bba0d50;
        public final float I_field_46;
        public final float i_field_46;
        public final boolean I_field_5a;
        public final long I_field_4a;
        public final double I_field_44;

        public Nested1_220a3880(Vec3d vec3d, Vec3d vec3d2, float f, float f2, boolean bl, long l, double d) {
            this.I_field_5bba0d50 = vec3d;
            this.i_field_5bba0d50 = vec3d2;
            this.I_field_46 = f;
            this.i_field_46 = f2;
            this.I_field_5a = bl;
            this.I_field_4a = l;
            this.I_field_44 = d;
        }
    }

    static class Nested1_220a38a0 {
        private double I_field_44 = 0.0;
        private int I_field_49 = 0;
        long I_field_4a = System.currentTimeMillis();

        Nested1_220a38a0() {
        }

        public void I_method_6f3932e7(Nested1_220a3880 nested1_220a3880) {
            double d = nested1_220a3880.i_field_5bba0d50.length();
            this.I_field_44 = (this.I_field_44 * (double)this.I_field_49 + d) / (double)(this.I_field_49 + 1);
            ++this.I_field_49;
            this.I_field_4a = System.currentTimeMillis();
        }
    }
}
