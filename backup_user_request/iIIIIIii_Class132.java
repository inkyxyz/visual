package rockstar.client;

import globals.client.Information;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import pyrock.events.game.GameTickEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ColorSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiiI_Class119;
import rockstar.client.IiiiiIII_Class121;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiIiI_Class123;
import rockstar.client.iiIiI_Class27;

public class iIIIIIii_Class132
extends IiiiIiiI_Class119 {
    private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.jump_circles");
    private final BooleanSetting i_field_ba20ca4c = this.I_method_61f9c255((iiiiIiiI_Class119, iIiiiIiii_Class120) -> new BooleanSetting((IIiiiIIiI_Class115)iiiiIiiI_Class119, "theme.sync", () -> !iIiiiIiii_Class120.i_method_9b12da03()).I_method_decd82b5());
    private final ColorSetting I_field_bbd4b66c = this.I_method_96c36dc8("theme.sync", (iiiiIiiI_Class119, iIiiiIiii_Class120, iIiiiIiii_Class1202) -> new ColorSetting(iiiiIiiI_Class119, "esp.jump_circles.color", () -> !iIiiiIiii_Class120.i_method_9b12da03() || iIiiiIiii_Class1202.i_method_9b12da03()).I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e()));
    private final SliderSetting I_field_73178e8c = this.I_method_61f9c255((iiiiIiiI_Class119, iIiiiIiii_Class120) -> new SliderSetting((IIiiiIIiI_Class115)iiiiIiiI_Class119, "esp.jump_circles.radius", () -> !iIiiiIiii_Class120.i_method_9b12da03()).I_method_c8c9a7d7(0.5f).i_method_65e2aff7(2.5f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(1.5f));
    private final SliderSetting i_field_73178e8c = this.I_method_61f9c255((iiiiIiiI_Class119, iIiiiIiii_Class120) -> new SliderSetting((IIiiiIIiI_Class115)iiiiIiiI_Class119, "esp.jump_circles.width", () -> !iIiiiIiii_Class120.i_method_9b12da03()).I_method_c8c9a7d7(0.05f).i_method_65e2aff7(1.5f).II_method_b0f56334(0.05f).Ii_method_4e0e6b54(1.0f));
    private final SliderSetting II_field_73178e8c = this.I_method_61f9c255((iiiiIiiI_Class119, iIiiiIiii_Class120) -> new SliderSetting((IIiiiIIiI_Class115)iiiiIiiI_Class119, "esp.jump_circles.strength", () -> !iIiiiIiii_Class120.i_method_9b12da03()).I_method_c8c9a7d7(0.1f).i_method_65e2aff7(2.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(2.0f));
    private final SliderSetting Ii_field_73178e8c = this.I_method_61f9c255((iiiiIiiI_Class119, iIiiiIiii_Class120) -> new SliderSetting((IIiiiIIiI_Class115)iiiiIiiI_Class119, "esp.jump_circles.expand", () -> !iIiiiIiii_Class120.i_method_9b12da03()).I_method_c8c9a7d7(100.0f).i_method_65e2aff7(800.0f).II_method_b0f56334(25.0f).Ii_method_4e0e6b54(800.0f));
    private final SliderSetting iI_field_73178e8c = this.I_method_61f9c255((iiiiIiiI_Class119, iIiiiIiii_Class120) -> new SliderSetting((IIiiiIIiI_Class115)iiiiIiiI_Class119, "esp.jump_circles.fade", () -> !iIiiiIiii_Class120.i_method_9b12da03()).I_method_c8c9a7d7(200.0f).i_method_65e2aff7(1500.0f).II_method_b0f56334(25.0f).Ii_method_4e0e6b54(1500.0f));
    private final CopyOnWriteArrayList<Nested1_6fb5d4b3> I_field_4588d803 = new CopyOnWriteArrayList();
    private final Map<UUID, Nested1_6fb5d4d3> I_field_a567c40b = new HashMap<UUID, Nested1_6fb5d4d3>();
    private final iiIiI_Class27 I_field_65e8196c = new iiIiI_Class27();
    private final IiIIIiII_Class69<GameTickEvent> I_field_3d936f41 = gameTickEvent -> {
        if (iIIIIIii_Class132.I_field_3a9bda27.world == null || iIIIIIii_Class132.I_field_3a9bda27.player == null) {
            return;
        }
        if (!this.I_method_ea8b70b0()) {
            return;
        }
        HashSet<UUID> hashSet = new HashSet<UUID>();
        for (PlayerEntity playerEntity : iIIIIIii_Class132.I_field_3a9bda27.world.getPlayers()) {
            IiiiiIII_Class121 iiiiiIII_Class121;
            boolean bl;
            UUID uUID = playerEntity.getUuid();
            hashSet.add(uUID);
            boolean bl2 = playerEntity.isOnGround();
            double d = playerEntity.getY();
            Nested1_6fb5d4d3 nested1_6fb5d4d3 = this.I_field_a567c40b.get(uUID);
            if (nested1_6fb5d4d3 == null) {
                this.I_field_a567c40b.put(uUID, new Nested1_6fb5d4d3(bl2, playerEntity.getX(), d, playerEntity.getZ(), d));
                continue;
            }
            if (bl2) {
                nested1_6fb5d4d3.i_field_44 = playerEntity.getX();
                nested1_6fb5d4d3.II_field_44 = d;
                nested1_6fb5d4d3.Ii_field_44 = playerEntity.getZ();
            }
            boolean bl3 = bl = d - nested1_6fb5d4d3.I_field_44 > 0.02 || playerEntity.getVelocity().y > 0.0;
            if (nested1_6fb5d4d3.I_field_5a && !bl2 && bl && this.i_method_d0cacf11(iiiiiIII_Class121 = iIIIIIii_Class132.I_method_abab91f6(playerEntity))) {
                this.I_method_627451f1(iiiiiIII_Class121, nested1_6fb5d4d3.i_field_44, this.I_method_10ee0800(nested1_6fb5d4d3.i_field_44, nested1_6fb5d4d3.II_field_44, nested1_6fb5d4d3.Ii_field_44), nested1_6fb5d4d3.Ii_field_44);
            }
            nested1_6fb5d4d3.I_field_5a = bl2;
            nested1_6fb5d4d3.I_field_44 = d;
        }
        this.I_field_a567c40b.keySet().retainAll(hashSet);
    };
    private final IiIIIiII_Class69<WorldChangeEvent> i_field_3d936f41 = worldChangeEvent -> {
        this.I_field_4588d803.clear();
        this.I_field_a567c40b.clear();
    };
    private final IiIIIiII_Class69<Render3DEvent> II_field_3d936f41 = render3DEvent -> {
        if (this.I_field_4588d803.isEmpty()) {
            return;
        }
        if (!this.I_method_ea8b70b0()) {
            this.i_method_d9771ccc();
            return;
        }
        List<iiIiI_Class27.Nested1_86a4a760> list = this.I_method_686b9fba(render3DEvent.getCamera());
        if (list.isEmpty()) {
            return;
        }
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)render3DEvent.getProjectionMatrix()).mul((Matrix4fc)render3DEvent.getPositionMatrix()).invert();
        this.I_field_65e8196c.I_method_338cb1a0(matrix4f, list);
    };

    public iIIIIIii_Class132() {
        super("jump_circles", IiiiiIiI_Class123.I_field_12aac7a1);
        this.I_method_52f623aa(IiiiiIII_Class121.i_field_12aa4f81);
        this.I_field_65e8196c.I_method_937f231f();
    }

    private void I_method_627451f1(IiiiiIII_Class121 iiiiiIII_Class121, double d, double d2, double d3) {
        ColorRGBA colorRGBA;
        BooleanSetting iIiiiIiii_Class120 = (BooleanSetting)this.I_method_62f3944d("theme.sync", iiiiiIII_Class121);
        ColorSetting iIiiiiIIi_Class122 = (ColorSetting)this.I_method_62f3944d("esp.jump_circles.color", iiiiiIII_Class121);
        SliderSetting iiIIIIIIi_Class130 = (SliderSetting)this.I_method_62f3944d("esp.jump_circles.radius", iiiiiIII_Class121);
        SliderSetting iiIIIIIIi_Class1302 = (SliderSetting)this.I_method_62f3944d("esp.jump_circles.width", iiiiiIII_Class121);
        SliderSetting iiIIIIIIi_Class1303 = (SliderSetting)this.I_method_62f3944d("esp.jump_circles.strength", iiiiiIII_Class121);
        SliderSetting iiIIIIIIi_Class1304 = (SliderSetting)this.I_method_62f3944d("esp.jump_circles.expand", iiiiiIII_Class121);
        SliderSetting iiIIIIIIi_Class1305 = (SliderSetting)this.I_method_62f3944d("esp.jump_circles.fade", iiiiiIII_Class121);
        if (iiIIIIIIi_Class130 == null || iiIIIIIIi_Class1302 == null || iiIIIIIIi_Class1303 == null || iiIIIIIIi_Class1304 == null || iiIIIIIIi_Class1305 == null) {
            return;
        }
        colorRGBA = iIiiiIiii_Class120 != null && iIiiiIiii_Class120.i_method_9b12da03()
            ? IiiiiIIIi_Class242.i_method_5dfec6e()
            : (iIiiiiIIi_Class122 != null ? iIiiiiIIi_Class122.I_method_bde5f08e() : null);
        if (colorRGBA == null) {
            colorRGBA = IiiiiIIIi_Class242.i_method_5dfec6e();
        }
        int n = colorRGBA.getRGB();
        float f = (float)(n >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n & 0xFF) / 255.0f;
        float f4 = (float)(n >>> 24 & 0xFF) / 255.0f;
        this.I_field_4588d803.add(new Nested1_6fb5d4b3(d, d2, d3, iiIIIIIIi_Class130.Ii_method_a20abcd2(), iiIIIIIIi_Class1302.Ii_method_a20abcd2(), (long)iiIIIIIIi_Class1304.Ii_method_a20abcd2(), (long)iiIIIIIIi_Class1305.Ii_method_a20abcd2(), iiIIIIIIi_Class1303.Ii_method_a20abcd2(), f, f2, f3, f4));
    }

    private double I_method_10ee0800(double d, double d2, double d3) {
        if (iIIIIIii_Class132.I_field_3a9bda27.world == null) {
            return d2 + 0.01;
        }
        BlockPos blockPos = BlockPos.ofFloored((double)d, (double)d2, (double)d3);
        double d4 = d - (double)blockPos.getX();
        double d5 = d3 - (double)blockPos.getZ();
        double d6 = Double.NEGATIVE_INFINITY;
        for (int i = blockPos.getY() + 1; i >= blockPos.getY() - 2; --i) {
            BlockPos blockPos2 = new BlockPos(blockPos.getX(), i, blockPos.getZ());
            BlockState blockState = iIIIIIii_Class132.I_field_3a9bda27.world.getBlockState(blockPos2);
            VoxelShape voxelShape = blockState.getOutlineShape((BlockView)iIIIIIii_Class132.I_field_3a9bda27.world, blockPos2);
            for (Box box : voxelShape.getBoundingBoxes()) {
                boolean bl;
                if (d4 < box.minX || d4 > box.maxX || d5 < box.minZ || d5 > box.maxZ) continue;
                double d7 = (double)blockPos2.getY() + box.maxY;
                boolean bl2 = Math.abs(d7 - d2) <= 0.01;
                boolean bl3 = bl = blockState.isOf(Blocks.SNOW) && d7 >= d2 - 0.01 && d7 <= d2 + 0.13;
                if (!bl2 && !bl || !(d7 > d6)) continue;
                d6 = d7;
            }
        }
        return (d6 == Double.NEGATIVE_INFINITY ? d2 : d6) + 0.01;
    }

    private void i_method_d9771ccc() {
        long l = System.currentTimeMillis();
        this.I_field_4588d803.removeIf(nested1_6fb5d4b3 -> l - nested1_6fb5d4b3.II_field_4a > nested1_6fb5d4b3.I_field_4a + nested1_6fb5d4b3.i_field_4a);
    }

    private List<iiIiI_Class27.Nested1_86a4a760> I_method_686b9fba(Camera camera) {
        ArrayList<iiIiI_Class27.Nested1_86a4a760> arrayList = new ArrayList<iiIiI_Class27.Nested1_86a4a760>();
        long l = System.currentTimeMillis();
        Vec3d vec3d = camera.getPos();
        this.I_field_4588d803.removeIf(nested1_6fb5d4b3 -> l - nested1_6fb5d4b3.II_field_4a > nested1_6fb5d4b3.I_field_4a + nested1_6fb5d4b3.i_field_4a);
        for (Nested1_6fb5d4b3 nested1_6fb5d4b32 : this.I_field_4588d803) {
            float f;
            float f2;
            float f3;
            float f4;
            if (arrayList.size() >= 12) break;
            long l2 = l - nested1_6fb5d4b32.II_field_4a;
            long l3 = nested1_6fb5d4b32.I_field_4a + nested1_6fb5d4b32.i_field_4a;
            if (l3 <= 0L) continue;
            if (l2 < nested1_6fb5d4b32.I_field_4a) {
                f4 = (float)l2 / (float)nested1_6fb5d4b32.I_field_4a;
                f3 = 1.0f - (1.0f - f4) * (1.0f - f4) * (1.0f - f4);
                f2 = nested1_6fb5d4b32.I_field_46 * f3;
                f = f3;
            } else {
                f4 = MathHelper.clamp((float)((float)(l2 - nested1_6fb5d4b32.I_field_4a) / (float)nested1_6fb5d4b32.i_field_4a), (float)0.0f, (float)1.0f);
                f2 = nested1_6fb5d4b32.I_field_46 * (1.0f + f4 * 0.18f);
                f3 = 1.0f - f4;
                f = f3 * f3;
            }
            if (f2 <= 0.001f || f <= 0.001f) continue;
            f4 = MathHelper.clamp((float)((float)l2 / (float)l3), (float)0.0f, (float)1.0f);
            f3 = nested1_6fb5d4b32.i_field_46 * (1.0f - 0.5f * f4);
            float f5 = nested1_6fb5d4b32.III_field_46 * f;
            float f6 = nested1_6fb5d4b32.II_field_46 * f;
            arrayList.add(new iiIiI_Class27.Nested1_86a4a760((float)(nested1_6fb5d4b32.I_field_44 - vec3d.x), (float)(nested1_6fb5d4b32.i_field_44 - vec3d.y), (float)(nested1_6fb5d4b32.II_field_44 - vec3d.z), f2, f3, nested1_6fb5d4b32.Ii_field_46, nested1_6fb5d4b32.iI_field_46, nested1_6fb5d4b32.ii_field_46, f5, f6));
        }
        return arrayList;
    }

    private static IiiiiIII_Class121 I_method_abab91f6(PlayerEntity playerEntity) {
        if (playerEntity == iIIIIIii_Class132.I_field_3a9bda27.player) {
            return IiiiiIII_Class121.i_field_12aa4f81;
        }
        if (RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(playerEntity.getName().getString())) {
            return IiiiiIII_Class121.II_field_12aa4f81;
        }
        if (iIIIIIii_Class132.I_method_3abc6c45(playerEntity)) {
            return IiiiiIII_Class121.Ii_field_12aa4f81;
        }
        return IiiiiIII_Class121.I_field_12aa4f81;
    }

    private static boolean I_method_3abc6c45(PlayerEntity playerEntity) {
        String string = playerEntity.getName().getString();
        for (Packets.Nested1_1da0dac9 nested1_1da0dac9 : Information.getVisiblePlayers()) {
            if (nested1_1da0dac9.gameInfo() == null || !string.equals(nested1_1da0dac9.gameInfo().nickname())) continue;
            return true;
        }
        return false;
    }

    @Generated
    public BooleanSetting I_method_50752b62() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public BooleanSetting i_method_660a9f42() {
        return this.i_field_ba20ca4c;
    }

    @Generated
    public ColorSetting I_method_52291782() {
        return this.I_field_bbd4b66c;
    }

    @Generated
    public SliderSetting I_method_96befa2() {
        return this.I_field_73178e8c;
    }

    @Generated
    public SliderSetting i_method_1f016382() {
        return this.i_field_73178e8c;
    }

    @Generated
    public SliderSetting II_method_25bbb96b() {
        return this.II_field_73178e8c;
    }

    @Generated
    public SliderSetting Ii_method_3b512d4b() {
        return this.Ii_field_73178e8c;
    }

    @Generated
    public SliderSetting iI_method_c2d4c18b() {
        return this.iI_field_73178e8c;
    }

    @Generated
    public CopyOnWriteArrayList<Nested1_6fb5d4b3> I_method_ff944d19() {
        return this.I_field_4588d803;
    }

    @Generated
    public Map<UUID, Nested1_6fb5d4d3> iII_method_438d4b21() {
        return this.I_field_a567c40b;
    }

    @Generated
    public iiIiI_Class27 I_method_20947582() {
        return this.I_field_65e8196c;
    }

    @Generated
    public IiIIIiII_Class69<GameTickEvent> I_method_9d43936b() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<WorldChangeEvent> i_method_c740238b() {
        return this.i_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<Render3DEvent> II_method_645eec82() {
        return this.II_field_3d936f41;
    }

    static final class Nested1_6fb5d4b3 {
        final double I_field_44;
        final double i_field_44;
        final double II_field_44;
        final float I_field_46;
        final float i_field_46;
        final long I_field_4a;
        final long i_field_4a;
        final float II_field_46;
        final float Ii_field_46;
        final float iI_field_46;
        final float ii_field_46;
        final float III_field_46;
        final long II_field_4a;

        Nested1_6fb5d4b3(double d, double d2, double d3, float f, float f2, long l, long l2, float f3, float f4, float f5, float f6, float f7) {
            this.I_field_44 = d;
            this.i_field_44 = d2;
            this.II_field_44 = d3;
            this.I_field_46 = f;
            this.i_field_46 = f2;
            this.I_field_4a = l;
            this.i_field_4a = l2;
            this.II_field_46 = f3;
            this.Ii_field_46 = f4;
            this.iI_field_46 = f5;
            this.ii_field_46 = f6;
            this.III_field_46 = f7;
            this.II_field_4a = System.currentTimeMillis();
        }
    }

    static final class Nested1_6fb5d4d3 {
        boolean I_field_5a;
        double I_field_44;
        double i_field_44;
        double II_field_44;
        double Ii_field_44;

        Nested1_6fb5d4d3(boolean bl, double d, double d2, double d3, double d4) {
            this.I_field_5a = bl;
            this.I_field_44 = d2;
            this.i_field_44 = d;
            this.II_field_44 = d4;
            this.Ii_field_44 = d3;
        }
    }
}
