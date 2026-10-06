package rockstar.client;

import java.io.BufferedWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.AttackEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiiIIiii_Class232;
import rockstar.client.iiiIiiII_Class237;

public final class iiiIiIiI_Class235 {
    private static final int i_field_49 = 60;
    private static final int II_field_49 = 40;
    private static final double I_field_44 = 5.0;
    private static final int Ii_field_49 = 256;
    private static final String I_field_523beb0a = "t,gcd,clean,yaw,pitch,dyaw,dpitch,has,tid,rx,ry,rz,bw,bh,dist,vis,on,atk,hp,ground,sprint\n";
    private static final int iI_field_49 = "t,gcd,clean,yaw,pitch,dyaw,dpitch,has,tid,rx,ry,rz,bw,bh,dist,vis,on,atk,hp,ground,sprint\n".split(",").length;
    private static final double[] I_field_b49 = new double[]{0.2, 0.5, 0.8};
    private static final double[] i_field_b49 = new double[]{0.15, 0.4, 0.65, 0.9};
    private static final double[] II_field_b49 = new double[]{0.2, 0.5, 0.8};
    private final MinecraftClient I_field_3a9bda27 = MinecraftClient.getInstance();
    private BufferedWriter I_field_b49f6881;
    private Path I_field_46b864df;
    private String i_field_523beb0a = "session";
    private boolean I_field_5a;
    private int ii_field_49;
    private int III_field_49;
    private int IIi_field_49;
    private int IiI_field_49;
    private int Iii_field_49;
    private int iII_field_49 = -1;
    private int iIi_field_49 = -1;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private float I_field_46;
    private float i_field_46;
    private final IiIIIiII_Class69<AttackEvent> I_field_3d936f41 = attackEvent -> {
        LivingEntity livingEntity;
        if (!this.I_field_5a) {
            return;
        }
        Entity entity = attackEvent.getEntity();
        if (entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity) != this.I_field_3a9bda27.player) {
            this.iII_field_49 = livingEntity.getId();
            this.iIi_field_49 = this.III_field_49;
            this.i_field_5a = true;
        }
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41 = clientPlayerTickEvent -> {
        if (this.I_field_3a9bda27.player == null || this.I_field_3a9bda27.world == null || this.I_field_b49f6881 == null) {
            return;
        }
        ++this.III_field_49;
        boolean bl = RockstarClient.getInstance().I_method_58785402().I_method_3d166e03();
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
        float f = iiIIiIIii_Class4042.I_method_14534e0f();
        float f2 = iiIIiIIii_Class4042.i_method_1461d9ef();
        float f3 = this.II_field_5a ? MathHelper.wrapDegrees((float)(f - this.I_field_46)) : 0.0f;
        float f4 = this.II_field_5a ? f2 - this.i_field_46 : 0.0f;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.II_field_5a = true;
        LivingEntity livingEntity = this.I_method_8c20f2f9();
        if (livingEntity == null) {
            if (this.IiI_field_49-- > 0) {
                this.I_method_884e7c75(bl, f, f2, f3, f4, null);
            }
            this.i_field_5a = false;
        } else {
            this.IiI_field_49 = 40;
            this.I_method_884e7c75(bl, f, f2, f3, f4, livingEntity);
        }
    };
    public static final int I_field_49 = 12000;
    private static final double i_field_44 = 1200.0;

    public String I_method_50bc076a(String string) {
        if (this.I_field_5a) {
            return "\u0417\u0430\u043f\u0438\u0441\u044c \u0443\u0436\u0435 \u0438\u0434\u0451\u0442: " + this.i_field_523beb0a;
        }
        try {
            boolean bl;
            Path path = iiiIiiII_Class237.i_method_21aa14a9();
            Files.createDirectories(path, new FileAttribute[0]);
            Path path2 = path.resolve(string + ".csv");
            boolean bl2 = bl = !Files.isRegularFile(path2, new LinkOption[0]) || Files.size(path2) == 0L;
            if (!bl) {
                iiiIiIiI_Class235.I_method_1db64cb(path2);
            }
            this.I_field_b49f6881 = Files.newBufferedWriter(path2, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            if (bl) {
                this.I_field_b49f6881.write(I_field_523beb0a);
            }
            this.I_field_46b864df = path2;
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[Neuro] \u043d\u0435 \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0434\u0430\u0442\u0430\u0441\u0435\u0442", (Throwable)exception);
            return "\u041d\u0435 \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0444\u0430\u0439\u043b " + string + ".csv";
        }
        this.i_field_523beb0a = string;
        this.Iii_field_49 = 0;
        this.IiI_field_49 = 0;
        this.IIi_field_49 = 0;
        this.ii_field_49 = 0;
        this.III_field_49 = 0;
        this.iIi_field_49 = -1;
        this.iII_field_49 = -1;
        this.II_field_5a = false;
        this.i_field_5a = false;
        this.I_field_5a = true;
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
        return null;
    }

    private static void I_method_1db64cb(Path path) {
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE);){
            long l = fileChannel.size();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)Math.min(l, 8192L));
            fileChannel.read(byteBuffer, l - (long)byteBuffer.capacity());
            byte[] byArray = byteBuffer.array();
            for (int i = byArray.length - 1; i >= 0; --i) {
                if (byArray[i] != 10) continue;
                long l2 = l - (long)byArray.length + (long)i + 1L;
                if (l2 < l) {
                    fileChannel.truncate(l2);
                }
                return;
            }
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.warn("[Neuro] \u043d\u0435 \u043f\u043e\u0434\u0440\u0435\u0437\u0430\u0442\u044c \u0445\u0432\u043e\u0441\u0442 \u0434\u0430\u0442\u0430\u0441\u0435\u0442\u0430: {}", (Object)exception.getMessage());
        }
    }

    public String I_method_eb9490f4() {
        if (!this.I_field_5a) {
            return "\u0417\u0430\u043f\u0438\u0441\u044c \u043d\u0435 \u0438\u0434\u0451\u0442.";
        }
        RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this);
        this.I_field_5a = false;
        this.I_method_be26612c();
        int n = this.I_field_46b864df == null ? this.ii_field_49 : iiiIiIiI_Class235.I_method_1db64be(this.I_field_46b864df);
        int n2 = iiiIiIiI_Class235.i_method_be34ecff();
        String string = iiiIiIiI_Class235.i_method_9933ca09(n2);
        return this.i_field_523beb0a + ".csv: +" + iiiIiIiI_Class235.I_method_c87c7629(this.ii_field_49) + " \u0437\u0430 \u0441\u0435\u0441\u0441\u0438\u044e, \u0432\u0441\u0435\u0433\u043e " + iiiIiIiI_Class235.I_method_c87c7629(n) + " (" + iiiIiIiI_Class235.II_method_4016a072(n) + "), \u0443\u0434\u0430\u0440\u043e\u0432 " + this.IIi_field_49 + (String)(string == null ? "" : ". \u0414\u043e \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u044f \u043d\u0435 \u0445\u0432\u0430\u0442\u0430\u0435\u0442 \u0435\u0449\u0451 " + string);
    }

    private LivingEntity I_method_8c20f2f9() {
        LivingEntity livingEntity;
        Entity entity;
        Vec3d vec3d = this.I_field_3a9bda27.player.getEyePos();
        if (this.iII_field_49 >= 0 && this.III_field_49 - this.iIi_field_49 <= 60 && (entity = this.I_field_3a9bda27.world.getEntityById(this.iII_field_49)) instanceof LivingEntity && (livingEntity = (LivingEntity)entity).isAlive() && iiiIIiii_Class232.I_method_60b14254(vec3d, livingEntity.getBoundingBox()) <= 5.0) {
            return livingEntity;
        }
        livingEntity = null;
        double d = 5.0;
        for (Entity entity2 : this.I_field_3a9bda27.world.getEntities()) {
            double d2;
            LivingEntity livingEntity2;
            if (!(entity2 instanceof LivingEntity) || (livingEntity2 = (LivingEntity)entity2) == this.I_field_3a9bda27.player || !livingEntity2.isAlive() || !((d2 = iiiIIiii_Class232.I_method_60b14254(vec3d, livingEntity2.getBoundingBox())) <= d) || !this.I_method_2324cff5(livingEntity2)) continue;
            d = d2;
            livingEntity = livingEntity2;
        }
        return livingEntity;
    }

    private void I_method_884e7c75(boolean bl, float f, float f2, float f3, float f4, LivingEntity livingEntity) {
        boolean bl2 = this.i_field_5a;
        this.i_field_5a = false;
        if (bl2) {
            ++this.IIi_field_49;
        }
        Vec3d vec3d = this.I_field_3a9bda27.player.getEyePos();
        Box box = livingEntity == null ? null : livingEntity.getBoundingBox();
        Vec3d vec3d2 = box == null ? Vec3d.ZERO : box.getCenter().subtract(vec3d);
        try {
            this.I_field_b49f6881.write(String.format(Locale.ROOT, "%d,%.6f,%d,%.4f,%.4f,%.4f,%.4f,%d,%d,%.4f,%.4f,%.4f,%.4f,%.4f,%.4f,%d,%d,%d,%.1f,%d,%d\n", this.III_field_49, Float.valueOf(iiIIiIiIi_Class406.I_method_73b181cf()), bl ? 1 : 0, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), livingEntity == null ? 0 : 1, livingEntity == null ? -1 : livingEntity.getId(), vec3d2.x, vec3d2.y, vec3d2.z, box == null ? 0.0 : box.getLengthX(), box == null ? 0.0 : box.getLengthY(), box == null ? -1.0 : iiiIIiii_Class232.I_method_60b14254(vec3d, box), livingEntity != null && this.I_method_2324cff5(livingEntity) ? 1 : 0, box != null && this.I_method_a634763c(f, f2, box) ? 1 : 0, bl2 ? 1 : 0, Float.valueOf(livingEntity == null ? -1.0f : livingEntity.getHealth()), this.I_field_3a9bda27.player.isOnGround() ? 1 : 0, this.I_field_3a9bda27.player.isSprinting() ? 1 : 0));
            ++this.ii_field_49;
            if (++this.Iii_field_49 >= 256) {
                this.Iii_field_49 = 0;
                this.I_field_b49f6881.flush();
            }
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[Neuro] \u043d\u0435 \u0437\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u0442\u0438\u043a \u0431\u043e\u044f", (Throwable)exception);
            this.I_method_be26612c();
        }
    }

    private boolean I_method_a634763c(float f, float f2, Box box) {
        Vec3d vec3d = this.I_field_3a9bda27.player.getEyePos();
        if (box.contains(vec3d)) {
            return true;
        }
        double d = Math.toRadians(f);
        double d2 = Math.toRadians(f2);
        double d3 = Math.cos(d2);
        Vec3d vec3d2 = new Vec3d(-Math.sin(d) * d3, -Math.sin(d2), Math.cos(d) * d3);
        return box.raycast(vec3d, vec3d.add(vec3d2.multiply(5.0))).isPresent();
    }

    private boolean I_method_2324cff5(LivingEntity livingEntity) {
        Box box = livingEntity.getBoundingBox();
        for (double d : I_field_b49) {
            for (double d2 : i_field_b49) {
                for (double d3 : II_field_b49) {
                    if (!iIIiiiiiI_Class319.I_method_de40276f(new Vec3d(MathHelper.lerp((double)d, (double)box.minX, (double)box.maxX), MathHelper.lerp((double)d2, (double)box.minY, (double)box.maxY), MathHelper.lerp((double)d3, (double)box.minZ, (double)box.maxZ)))) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private void I_method_be26612c() {
        try {
            if (this.I_field_b49f6881 != null) {
                this.I_field_b49f6881.flush();
                this.I_field_b49f6881.close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.I_field_b49f6881 = null;
    }

    public static String I_method_c87c7629(int n) {
        return String.format(Locale.ROOT, "%.1f \u043c\u0438\u043d", (double)n / 1200.0);
    }

    public static String i_method_9933ca09(int n) {
        return n >= 12000 ? null : iiiIiIiI_Class235.I_method_c87c7629(12000 - n);
    }

    public static String II_method_4016a072(int n) {
        if (n < 6000) {
            return "\u043c\u0430\u043b\u043e";
        }
        if (n < 18000) {
            return "\u043c\u0430\u043b\u043e\u0432\u0430\u0442\u043e";
        }
        if (n < 36000) {
            return "\u043d\u043e\u0440\u043c\u0430\u043b\u044c\u043d\u043e";
        }
        return "\u0445\u043e\u0440\u043e\u0448\u043e";
    }

    public static List<String> I_method_bbc3739b() {
        ArrayList<String> arrayList = new ArrayList<String>();
        try (Stream<Path> stream = Files.list(iiiIiiII_Class237.i_method_21aa14a9());){
            stream.filter(path -> path.getFileName().toString().endsWith(".csv")).sorted().forEach(path -> {
                int[] nArray = iiiIiIiI_Class235.I_method_39913579(path);
                arrayList.add(path.getFileName().toString().replaceFirst("\\.csv$", "") + " \u00b7 " + iiiIiIiI_Class235.I_method_c87c7629(nArray[0]) + " \u00b7 " + iiiIiIiI_Class235.II_method_4016a072(nArray[0]) + (String)(nArray[1] > 0 ? " \u00b7 \u00a7c\u0431\u0438\u0442\u044b\u0445 \u0441\u0442\u0440\u043e\u043a " + nArray[1] + "\u00a7r" : ""));
            });
        }
        catch (Exception exception) {
            // empty catch block
        }
        return arrayList;
    }

    public static int I_method_be26611f() {
        int n = 0;
        try (Stream<Path> stream = Files.list(iiiIiiII_Class237.i_method_21aa14a9());){
            for (Path path2 : stream.filter(path -> path.getFileName().toString().endsWith(".csv")).toList()) {
                n += iiiIiIiI_Class235.I_method_39913579(path2)[1];
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return n;
    }

    public static int I_method_2bbe17e9(String string) {
        Path path = iiiIiiII_Class237.i_method_21aa14a9().resolve(string + ".csv");
        return Files.isRegularFile(path, new LinkOption[0]) ? iiiIiIiI_Class235.I_method_1db64be(path) : 0;
    }

    public static int i_method_be34ecff() {
        int n = 0;
        try (Stream<Path> stream = Files.list(iiiIiiII_Class237.i_method_21aa14a9());){
            for (Path path2 : stream.filter(path -> path.getFileName().toString().endsWith(".csv")).toList()) {
                n += iiiIiIiI_Class235.I_method_1db64be(path2);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return n;
    }

    private static int I_method_1db64be(Path path) {
        return iiiIiIiI_Class235.I_method_39913579(path)[0];
    }

    private static int[] I_method_39913579(Path path) {
        int n = 0;
        int n2 = 0;
        try (Stream<String> stream = Files.lines(path);){
            Iterator iterator = stream.iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                if (string.isBlank() || string.startsWith("t,")) continue;
                ++n;
                int n3 = 1;
                for (int i = 0; i < string.length(); ++i) {
                    if (string.charAt(i) != ',') continue;
                    ++n3;
                }
                if (n3 == iI_field_49) continue;
                ++n2;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return new int[]{n, n2};
    }

    @Generated
    public String i_method_7eb34114() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean I_method_be266130() {
        return this.I_field_5a;
    }

    @Generated
    public int II_method_6b4bba8() {
        return this.ii_field_49;
    }
}

