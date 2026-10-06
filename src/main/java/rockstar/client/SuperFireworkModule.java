package rockstar.client;

import lombok.Generated;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.FireworkEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.ModeSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Super Firework", category=ModuleCategory.MOVEMENT, III_method_a89e5834="modules.descriptions.elytra_motion")
public class SuperFireworkModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private SliderSetting I_field_73178e8c;
    private final IiIIIiII_Class69<FireworkEvent> I_field_3d936f41 = fireworkEvent -> {
        double d;
        double d2;
        iiIIiIIii_Class404 iiIIiIIii_Class4042;
        if (fireworkEvent.getEntity() != SuperFireworkModule.I_field_3a9bda27.player || SuperFireworkModule.I_field_3a9bda27.player == null) {
            return;
        }
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
        if (iiIIiIiII_Class4052 == null) {
            return;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4043 = iiIIiIIii_Class4042 = iiIIiIiII_Class4052.I_method_3d166e03() ? iiIIiIiII_Class4052.I_method_fb1d7ad5() : iiIIiIiII_Class4052.II_method_f098f858();
        if (iiIIiIIii_Class4042 == null) {
            return;
        }
        Vec3d vec3d = iiIIiIIii_Class4042.I_method_cbcdd559();
        if (this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)) {
            double d3;
            d2 = d3 = this.I_method_307c65e8(iiIIiIIii_Class4042);
            d = d3;
        } else if (!this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
            float f = this.I_method_3f63a884(iiIIiIIii_Class4042.I_method_14534e0f());
            float f2 = Math.abs(iiIIiIIii_Class4042.i_method_1461d9ef());
            d2 = this.I_method_324981a3(f, f2, this.I_field_bbe33e6c.i_method_f85f3850());
            d = this.i_method_d6179c3(f2, f, this.I_field_bbe33e6c.i_method_f85f3850());
        } else {
            d2 = this.I_field_73178e8c.Ii_method_a20abcd2();
            d = this.I_field_73178e8c.Ii_method_a20abcd2();
        }
        Vec3d vec3d2 = this.I_method_1f5c0da6(fireworkEvent.getVelocity(), vec3d, d2, d);
        fireworkEvent.setVelocity(vec3d2);
    };

    @Compile(obfuscation=4)
    private void IiI_method_b0a6b5ec() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.elytra_motion.algorithm");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.elytra_motion.algorithm.default").select();
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.elytra_motion.algorithm.custom");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.elytra_motion.algorithm.advanced");
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.elytra_motion.algorithm.advanced-stable");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.elytra_motion.custom_strength", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)).I_method_c8c9a7d7(1.5f).i_method_65e2aff7(2.5f).II_method_b0f56334(0.025f).Ii_method_4e0e6b54(1.78f);
    }

    public SuperFireworkModule() {
        this.IiI_method_b0a6b5ec();
    }

    private Vec3d I_method_1f5c0da6(Vec3d vec3d, Vec3d vec3d2, double d, double d2) {
        double d3 = 0.1;
        return vec3d.add(vec3d2.x * d3 + (vec3d2.x * d - vec3d.x) * 0.5, vec3d2.y * d3 + (vec3d2.y * d2 - vec3d.y) * 0.5, vec3d2.z * d3 + (vec3d2.z * d - vec3d.z) * 0.5);
    }

    private double I_method_307c65e8(iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        double d;
        float f = iiIIiIIii_Class4042.I_method_14534e0f();
        float f2 = iiIIiIIii_Class4042.i_method_1461d9ef();
        double d2 = 1.49;
        double d3 = SuperFireworkModule.I_method_3f63a882(f);
        if (f2 >= -45.0f && f2 <= 20.0f) {
            double d4 = -10.0;
            double d5 = (double)f2 - d4;
            d = 1.0 + 0.05 * Math.exp(-(d5 * d5) / 800.0);
        } else if (f2 > 20.0f) {
            double d6 = (double)f2 - 20.0;
            d = 1.0 - Math.min(0.35, d6 / 70.0 * 0.35);
        } else {
            double d7 = (double)Math.abs(f2) - 45.0;
            d = 1.0 - Math.min(0.3, d7 / 45.0 * 0.3);
        }
        return Math.clamp(d3 * d, 0.65, 1.49);
    }

    private static double I_method_3f63a882(float f) {
        double d = Math.abs(f % 360.0f);
        if (d > 180.0) {
            d = 360.0 - d;
        }
        double d2 = Math.abs(d - 45.0);
        double d3 = Math.abs(d - 135.0);
        double d4 = Math.min(d2, d3);
        double d5 = 0.47 * Math.exp(-(d4 * d4) / 288.0);
        return 1.0 + d5;
    }

    private float I_method_3f63a884(float f) {
        float f2 = f % 180.0f;
        if (f2 > 90.0f) {
            f2 -= 180.0f;
        } else if (f2 < -90.0f) {
            f2 += 180.0f;
        }
        return Math.abs(f2);
    }

    private double I_method_324981a3(float f, float f2, ModeSetting.Nested1_42765c60 nested1_42765c60) {
        int n = (int)Math.ceil(f);
        double d = f2 >= 40.0f && f2 <= 50.0f ? 2.0 : (f2 >= 38.0f && f2 <= 52.0f ? 1.98 : (f2 >= 32.0f && f2 <= 58.0f ? 1.97 : (n == 33 || n == 57 || f2 == 33.0f || f2 == 57.0f ? 1.964 : (n == 34 || n == 56 || f2 == 34.0f || f2 == 56.0f ? 1.964 : (n == 35 || n == 55 || f2 == 35.0f || f2 == 55.0f ? 1.965 : (n == 36 || n == 54 || f2 == 36.0f || f2 == 54.0f ? 1.965 : (n == 37 || n == 53 || f2 == 37.0f || f2 == 53.0f ? 1.966 : (n == 38 || n == 52 || f2 == 38.0f || f2 == 52.0f ? 1.966 : (n == 39 || n == 51 || f2 == 39.0f || f2 == 51.0f ? 1.966 : (n == 40 || n == 50 || f2 == 40.0f || f2 == 50.0f ? 1.967 : (n == 41 || n == 49 || f2 == 41.0f || f2 == 49.0f ? 1.968 : (n == 42 || n == 48 || f2 == 42.0f || f2 == 48.0f ? 1.969 : (n == 43 || n == 47 || f2 == 43.0f || f2 == 47.0f ? 1.969 : (n == 44 || n == 46 || f2 == 44.0f || f2 == 46.0f ? 1.9695 : (n == 45 || f2 == 45.0f ? 1.9695 : (n >= 29 && n <= 61 || f2 >= 29.0f && f2 <= 61.0f ? 1.963 : (n >= 27 && n <= 63 || f2 >= 27.0f && f2 <= 63.0f ? 1.84 : (n >= 26 && n <= 64 || f2 >= 26.0f && f2 <= 64.0f ? 1.8 : (n >= 15 && n <= 75 || f2 >= 15.0f && f2 <= 75.0f ? 1.74 : (n >= 13 && n <= 77 || f2 >= 13.0f && f2 <= 77.0f ? 1.7 : (n >= 12 && n <= 78 || f2 >= 12.0f && f2 <= 78.0f ? 1.671 : 1.626)))))))))))))))))))));
        if (d < 1.9 && f2 > 10.0f) {
            d += 0.05;
        }
        return d * (double)(nested1_42765c60 == this.Ii_field_500d0627 ? 0.98f : 1.0f);
    }

    private double i_method_d6179c3(float f, float f2, ModeSetting.Nested1_42765c60 nested1_42765c60) {
        double d = f >= 30.0f && f <= 40.0f ? 2.0 * (double)(nested1_42765c60 == this.Ii_field_500d0627 ? 0.95f : 1.0f) : (f >= 35.0f && f <= 45.0f ? 1.99 * (double)(nested1_42765c60 == this.Ii_field_500d0627 ? 0.95f : 1.0f) : (f >= 40.0f && f <= 50.0f ? 1.97 * (double)(nested1_42765c60 == this.Ii_field_500d0627 ? 0.95f : 1.0f) : (f >= 50.0f && f <= 60.0f ? 1.96 * (double)(nested1_42765c60 == this.Ii_field_500d0627 ? 0.95f : 1.0f) : (f >= 51.0f && f <= 61.0f ? 1.89 * (double)(nested1_42765c60 == this.Ii_field_500d0627 ? 0.98f : 1.0f) : (f >= 52.0f && f <= 65.0f ? 1.7 : 1.6)))));
        return d;
    }

    @Generated
    public ModeSetting I_method_1d653342() {
        return this.I_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 I_method_58e51d7d() {
        return this.I_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 i_method_5eed195d() {
        return this.i_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 II_method_f72ec986() {
        return this.II_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 Ii_method_fd36c566() {
        return this.Ii_field_500d0627;
    }

    @Generated
    public SliderSetting I_method_d4998362() {
        return this.I_field_73178e8c;
    }
}

