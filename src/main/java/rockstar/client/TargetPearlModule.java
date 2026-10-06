package rockstar.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIIii_Class68;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Target Pearl", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.target_pearl")
public class TargetPearlModule
extends Module {
    private static final double I_field_44 = 1.5;
    private static final double i_field_44 = 0.03;
    private static final double II_field_44 = 0.99;
    private static final int I_field_49 = 200;
    private SliderSetting I_field_73178e8c;
    private SliderSetting i_field_73178e8c;
    private SliderSetting II_field_73178e8c;
    private SliderSetting Ii_field_73178e8c;
    private SliderSetting iI_field_73178e8c;
    private SliderSetting ii_field_73178e8c;
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private Vec3d I_field_5bba0d50;
    private iiIIiIIii_Class404 I_field_32e13e6c;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        this.I_field_5bba0d50 = null;
        this.I_field_32e13e6c = null;
        if (TargetPearlModule.I_field_3a9bda27.player == null || TargetPearlModule.I_field_3a9bda27.world == null) {
            return;
        }
        if (TargetPearlModule.I_field_3a9bda27.currentScreen != null) {
            return;
        }
        if (TargetPearlModule.I_field_3a9bda27.player.isUsingItem()) {
            return;
        }
        if (IiIIIIii_Class68.I_field_108dc26c.I_method_801dd223()) {
            return;
        }
        if (this.i_field_ba20ca4c.i_method_9b12da03() && !TargetPearlModule.I_field_3a9bda27.player.getMainHandStack().isOf(Items.ENDER_PEARL) && !TargetPearlModule.I_field_3a9bda27.player.getOffHandStack().isOf(Items.ENDER_PEARL)) {
            return;
        }
        if (!this.IiI_method_b3b22e83()) {
            return;
        }
        EnderPearlEntity enderPearlEntity = this.I_method_307756();
        if (enderPearlEntity == null) {
            return;
        }
        Vec3d vec3d = this.I_method_ef681bc2(enderPearlEntity);
        if (vec3d == null) {
            return;
        }
        double d = TargetPearlModule.I_field_3a9bda27.player.getEyePos().distanceTo(vec3d);
        if (d < (double)this.i_field_73178e8c.Ii_method_a20abcd2() || d > (double)this.II_field_73178e8c.Ii_method_a20abcd2()) {
            return;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = this.I_method_c8bda581(vec3d);
        if (iiIIiIIii_Class4042 == null) {
            return;
        }
        this.I_field_5bba0d50 = vec3d;
        this.I_field_32e13e6c = iiIIiIIii_Class4042;
        float f = this.Ii_field_73178e8c.Ii_method_a20abcd2();
        RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.Ii_field_32e0c64c, f, f, f, iiIIiIiiI_Class407.Ii_field_32efc66c);
        if (!this.I_field_991c1e8c.I_method_58432069((long)this.ii_field_73178e8c.Ii_method_a20abcd2())) {
            return;
        }
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
        if (iiIIiIiII_Class4052.II_method_f098f858().I_method_24e31c97(iiIIiIIii_Class4042) > this.iI_field_73178e8c.Ii_method_a20abcd2()) {
            return;
        }
        IiIIIIii_Class68.I_field_108dc26c.I_method_ee61a647(Items.ENDER_PEARL);
        this.I_field_991c1e8c.I_method_23e11e3f();
    };

    public TargetPearlModule() {
        this.IiI_method_b3b22e7f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_b3b22e7f() {
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.target_pearl.track_range").I_method_c8c9a7d7(10.0f).i_method_65e2aff7(80.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(50.0f).I_method_bfc3b958(f -> " m");
        this.i_field_73178e8c = new SliderSetting(this, "modules.settings.target_pearl.min_landing").I_method_c8c9a7d7(2.0f).i_method_65e2aff7(15.0f).II_method_b0f56334(0.5f).Ii_method_4e0e6b54(4.0f).I_method_bfc3b958(f -> " m");
        this.II_field_73178e8c = new SliderSetting(this, "modules.settings.target_pearl.max_landing").I_method_c8c9a7d7(10.0f).i_method_65e2aff7(80.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(45.0f).I_method_bfc3b958(f -> " m");
        this.Ii_field_73178e8c = new SliderSetting(this, "modules.settings.target_pearl.aim_speed").I_method_c8c9a7d7(40.0f).i_method_65e2aff7(180.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(180.0f);
        this.iI_field_73178e8c = new SliderSetting(this, "modules.settings.target_pearl.max_angle").I_method_c8c9a7d7(0.5f).i_method_65e2aff7(20.0f).II_method_b0f56334(0.5f).Ii_method_4e0e6b54(5.0f).I_method_bfc3b958(f -> "\u00b0");
        this.ii_field_73178e8c = new SliderSetting(this, "modules.settings.target_pearl.cooldown").I_method_c8c9a7d7(0.0f).i_method_65e2aff7(1000.0f).II_method_b0f56334(25.0f).Ii_method_4e0e6b54(50.0f).I_method_bfc3b958(f -> " ms");
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.target_pearl.own_pearls");
        this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.target_pearl.only_holding");
    }

    @Override
    public void onEnable() {
        this.I_field_991c1e8c.I_method_23e11e3f();
        this.I_field_5bba0d50 = null;
        this.I_field_32e13e6c = null;
    }

    private boolean IiI_method_b3b22e83() {
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        return iIIiiIiII_Class3092.I_method_77fa4424(itemStack -> itemStack != null && !itemStack.isEmpty() && itemStack.isOf(Items.ENDER_PEARL)) != null;
    }

    private EnderPearlEntity I_method_307756() {
        EnderPearlEntity enderPearlEntity = null;
        double d = Double.MAX_VALUE;
        float f = this.I_field_73178e8c.Ii_method_a20abcd2() * this.I_field_73178e8c.Ii_method_a20abcd2();
        for (Entity entity : TargetPearlModule.I_field_3a9bda27.world.getEntities()) {
            double d2;
            if (!(entity instanceof EnderPearlEntity)) continue;
            EnderPearlEntity enderPearlEntity2 = (EnderPearlEntity)entity;
            if (!this.I_field_ba20ca4c.i_method_9b12da03() && enderPearlEntity2.getOwner() == TargetPearlModule.I_field_3a9bda27.player || enderPearlEntity2.isRemoved() || (d2 = enderPearlEntity2.squaredDistanceTo((Entity)TargetPearlModule.I_field_3a9bda27.player)) > (double)f || !(d2 < d)) continue;
            d = d2;
            enderPearlEntity = enderPearlEntity2;
        }
        return enderPearlEntity;
    }

    private Vec3d I_method_ef681bc2(EnderPearlEntity enderPearlEntity) {
        Vec3d vec3d = enderPearlEntity.getPos();
        Vec3d vec3d2 = enderPearlEntity.getVelocity();
        for (int i = 0; i < 200; ++i) {
            Vec3d vec3d3 = vec3d.add(vec3d2);
            BlockHitResult blockHitResult = TargetPearlModule.I_field_3a9bda27.world.raycast(new RaycastContext(vec3d, vec3d3, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)enderPearlEntity));
            if (blockHitResult.getType() == HitResult.Type.BLOCK) {
                return blockHitResult.getPos();
            }
            vec3d2 = vec3d2.multiply(0.99).add(0.0, -0.03, 0.0);
            vec3d = vec3d3;
            if (!(vec3d.y < (double)(TargetPearlModule.I_field_3a9bda27.world.getBottomY() - 16))) continue;
            return null;
        }
        return null;
    }

    private iiIIiIIii_Class404 I_method_c8bda581(Vec3d vec3d) {
        Vec3d vec3d2 = TargetPearlModule.I_field_3a9bda27.player.getEyePos();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.hypot(d, d3);
        if (d4 < 0.001) {
            return null;
        }
        float f = (float)(Math.toDegrees(Math.atan2(d3, d)) - 90.0);
        Float f2 = this.I_method_a610b048(d4, d2);
        if (f2 == null) {
            return null;
        }
        return new iiIIiIIii_Class404(f, f2.floatValue());
    }

    private Float I_method_a610b048(double d, double d2) {
        float f;
        float f2 = Float.NaN;
        double d3 = Double.MAX_VALUE;
        for (f = -89.0f; f <= 60.0f; f += 1.0f) {
            double d4;
            Double d5 = this.I_method_86f0017f(d, f);
            if (d5 == null || !((d4 = Math.abs(d5 - d2)) < d3)) continue;
            d3 = d4;
            f2 = f;
        }
        if (Float.isNaN(f2)) {
            return null;
        }
        f = f2 - 1.0f;
        float f3 = f2 + 1.0f;
        for (float f4 = f; f4 <= f3; f4 += 0.05f) {
            double d6;
            Double d7 = this.I_method_86f0017f(d, f4);
            if (d7 == null || !((d6 = Math.abs(d7 - d2)) < d3)) continue;
            d3 = d6;
            f2 = f4;
        }
        if (d3 > 1.5) {
            return null;
        }
        return Float.valueOf(MathHelper.clamp((float)f2, (float)-90.0f, (float)90.0f));
    }

    private Double I_method_86f0017f(double d, float f) {
        double d2 = Math.toRadians(f);
        double d3 = Math.cos(d2);
        double d4 = d3 * 1.5;
        double d5 = -Math.sin(d2) * 1.5;
        if (d4 <= 1.0E-4) {
            return null;
        }
        double d6 = 0.0;
        double d7 = 0.0;
        for (int i = 0; i < 200; ++i) {
            double d8 = d6;
            double d9 = d7;
            d6 += d4;
            d7 += d5;
            if (d6 >= d) {
                double d10 = (d - d8) / d4;
                return d9 + d5 * d10;
            }
            d4 *= 0.99;
            d5 = d5 * 0.99 - 0.03;
        }
        return null;
    }
}

