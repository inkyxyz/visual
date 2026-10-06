package rockstar.client;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.AttackEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.GameRendererEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiIII_Class137;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIIIiIIi_Class138;
import rockstar.client.IiIIIiIiI_Class139;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iIiIIIIII_Class321;
import rockstar.client.iIiIiIiii_Class344;
import rockstar.client.iIiIiiIII_Class345;
import rockstar.client.Module;
import rockstar.client.iiiIIiii_Class232;
import rockstar.client.iiiIiIII_Class233;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Aim Assist", category=ModuleCategory.COMBAT, III_method_a89e5834="modules.descriptions.aim_assist")
public class AimAssistModule
extends Module {
    private static final Set<String> I_field_a56a8dc5 = Set.of("sword", "trident", "_axe", "mace", "stick", "pickaxe", "shovel");
    private static final double I_field_44 = Math.PI * 2;
    private static final float I_field_46 = 1.0E-4f;
    private static final float i_field_46 = 0.05f;
    private static final float II_field_46 = 90.0f;
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private SliderSetting I_field_73178e8c;
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
    private ModeSetting i_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 iI_field_500d0627;
    private ModeSetting II_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 III_field_500d0627;
    private ModeSetting.Nested1_42765c60 IIi_field_500d0627;
    private SliderSetting i_field_73178e8c;
    private SliderSetting II_field_73178e8c;
    private SliderSetting Ii_field_73178e8c;
    private SliderSetting iI_field_73178e8c;
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private SliderSetting ii_field_73178e8c;
    private SliderSetting III_field_73178e8c;
    private BooleanSetting II_field_ba20ca4c;
    private BooleanSetting Ii_field_ba20ca4c;
    private BooleanSetting iI_field_ba20ca4c;
    private SliderSetting IIi_field_73178e8c;
    private SliderSetting IiI_field_73178e8c;
    private SliderSetting Iii_field_73178e8c;
    private SliderSetting iII_field_73178e8c;
    private BooleanSetting ii_field_ba20ca4c;
    private BooleanSetting III_field_ba20ca4c;
    private SliderSetting iIi_field_73178e8c;
    private SliderSetting iiI_field_73178e8c;
    private SliderSetting iii_field_73178e8c;
    private BooleanSetting IIi_field_ba20ca4c;
    private SliderSetting IIII_field_73178e8c;
    private final iIiIiiIII_Class345 I_field_a83b6e4c = new iIiIiiIII_Class345();
    private final iIiIIIIII_Class321 I_field_6fdd6a4c = new iIiIIIIII_Class321();
    private final iiiIiIII_Class233 I_field_649d1bc1 = new iiiIiIII_Class233();
    private final float[] I_field_b4b = new float[2];
    private float Ii_field_46;
    private float iI_field_46;
    private float ii_field_46;
    private boolean I_field_5a;
    private LivingEntity I_field_966247a3;
    private LivingEntity i_field_966247a3;
    private long I_field_4a;
    private long i_field_4a;
    private long II_field_4a;
    private boolean i_field_5a = true;
    private boolean II_field_5a;
    private float III_field_46;
    private float IIi_field_46;
    private float IiI_field_46;
    private float Iii_field_46;
    private float iII_field_46;
    private float iIi_field_46;
    private float iiI_field_46;
    private float iii_field_46 = Float.NaN;
    private float IIII_field_46;
    private float IIIi_field_46;
    private float IIiI_field_46;
    private float IIii_field_46;
    private float IiII_field_46;
    private double i_field_44;
    private double II_field_44;
    private double Ii_field_44;
    private boolean Ii_field_5a;
    private double iI_field_44;
    private double ii_field_44;
    private double III_field_44;
    private float IiIi_field_46;
    private float IiiI_field_46;
    private float Iiii_field_46;
    private float iIII_field_46;
    private float iIIi_field_46;
    private float iIiI_field_46;
    private float iIii_field_46;
    private float iiII_field_46;
    private float iiIi_field_46;
    private boolean iI_field_5a;
    private float iiiI_field_46;
    private float iiii_field_46;
    private float IIIII_field_46;
    private float IIIIi_field_46;
    private float IIIiI_field_46;
    private float IIIii_field_46;
    private float IIiII_field_46;
    private float IIiIi_field_46;
    private float IIiiI_field_46;
    private float IIiii_field_46;
    private float IiIII_field_46;
    private boolean ii_field_5a;
    private float IiIIi_field_46;
    private float IiIiI_field_46;
    private float IiIii_field_46;
    private float IiiII_field_46;
    private long Ii_field_4a;
    private float IiiIi_field_46 = 0.15f;
    private boolean III_field_5a;
    private float IiiiI_field_46;
    private final float[] i_field_b4b = new float[2];
    private final float[] II_field_b4b = new float[2];
    private final float[] Ii_field_b4b = new float[2];
    private final double[] I_field_b49 = new double[3];
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (this.IIii_method_91022ed9()) {
            this.iII_method_bf5a19ec();
            return;
        }
        if (this.II_field_ba20ca4c.i_method_9b12da03() && !this.IiI_method_8a81f630()) {
            this.iII_method_bf5a19ec();
            return;
        }
        this.IIiI_method_90f3a2f5();
        this.IIii_method_91022ed5();
        this.IIIi_method_8f3f3eb5();
        if (this.Iii_method_8a908210()) {
            this.iIi_method_bf68a5cc();
            return;
        }
        if (this.I_field_966247a3 != null) {
            Vec3d vec3d = this.I_field_966247a3.getVelocity();
            if (vec3d.lengthSquared() > 1.0E-6) {
                this.I_field_a83b6e4c.I_method_b1940601(this.I_field_966247a3, this.II_method_990defe5(), 100);
            }
            if (this.I_field_ba20ca4c.i_method_9b12da03() && !this.II_field_5a) {
                this.IIi_field_46 += 0.05f;
                if (this.IIi_field_46 >= this.IiI_field_46) {
                    this.II_field_5a = true;
                }
            }
        }
    };
    private final IiIIIiII_Class69<GameRendererEvent> i_field_3d936f41 = gameRendererEvent -> {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        if (this.IIii_method_91022ed9() || AimAssistModule.I_field_3a9bda27.player == null) {
            return;
        }
        long l = System.nanoTime();
        float f9 = this.I_method_98ff6f48(l);
        this.II_field_4a = l;
        if (f9 < 1.0E-4f || f9 > 0.1f) {
            f9 = 0.016666668f;
        }
        if (this.Iii_method_8a908210()) {
            this.I_method_98ff6054(f9);
            return;
        }
        boolean bl = this.Ii_field_ba20ca4c.i_method_9b12da03();
        if (bl) {
            this.iii_method_c12b95ec();
        }
        this.IiII_field_46 = 0.0f;
        this.IIii_field_46 = 0.0f;
        if (this.IIiI_method_90f3a2f9()) {
            this.IIII_method_8f30b2d5();
            return;
        }
        Vec3d vec3d = AimAssistModule.I_field_3a9bda27.player.getEyePos();
        this.iI_field_44 = vec3d.x;
        this.ii_field_44 = vec3d.y;
        this.III_field_44 = vec3d.z;
        float f10 = this.II_method_990defe5();
        this.I_method_801a3f1(this.I_field_966247a3, f10, f9);
        float f11 = this.Ii_field_b4b[0];
        float f12 = this.Ii_field_b4b[1];
        if (!Float.isFinite(f11) || !Float.isFinite(f12)) {
            this.IIII_method_8f30b2d5();
            return;
        }
        float f13 = f11 * f11 + f12 * f12;
        if (f13 < 0.01f) {
            this.IIII_method_8f30b2d5();
            return;
        }
        float f14 = MathHelper.sqrt((float)f13);
        if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            f8 = this.i_method_9ac25064(AimAssistModule.I_field_3a9bda27.player.distanceTo((Entity)this.I_field_966247a3));
            f12 += f8;
        }
        f8 = this.I_method_9c60f421(this.I_field_966247a3);
        if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            f7 = this.II_method_8d5ebea5(f14, f8);
            f6 = Math.max(f7 / this.iI_field_73178e8c.Ii_method_a20abcd2(), 0.01f);
            this.i_method_7c22dacc(f14, f8, f9, f6);
            f5 = this.i_field_5a ? this.II_method_88b0765b(this.III_field_46) : this.i_method_bd8825bc(f11, f12);
            f4 = f14 / f6 * f5 * this.Ii_field_73178e8c.Ii_method_a20abcd2();
            f3 = f14 > 1.0E-4f ? 1.0f / f14 : 0.0f;
            f2 = MathHelper.clamp((float)(f11 * f3 * f4 * f9), (float)-20.0f, (float)20.0f);
            f = this.i_field_ba20ca4c.i_method_9b12da03() ? this.I_method_7ffd3edc(f12, f14, f8, f9) : 0.0f;
        } else {
            f7 = this.iI_field_73178e8c.Ii_method_a20abcd2() * this.Ii_field_73178e8c.Ii_method_a20abcd2() * 10.0f * f9;
            f6 = Math.min(f14 / 10.0f, 1.0f);
            f5 = f14 > 1.0E-4f ? 1.0f / f14 : 0.0f;
            f2 = f11 * f5 * f7 * f6;
            f = this.i_field_ba20ca4c.i_method_9b12da03() ? f12 * f5 * f7 * f6 * this.ii_field_73178e8c.Ii_method_a20abcd2() : 0.0f;
        }
        f7 = this.III_field_73178e8c.Ii_method_a20abcd2();
        f6 = this.I_method_86ed11dc(f14, f9);
        f5 = f7 * f6;
        if (f5 > 1.0E-4f) {
            this.I_method_7ffd3eec(f2, f, f5, f9);
            f4 = this.I_method_98ff6044(f9);
            f2 += this.i_field_b4b[0] + f4 * 0.5f;
            f += this.i_field_b4b[1] + f4 * 0.25f;
        }
        if (this.IIi_field_ba20ca4c.i_method_9b12da03()) {
            this.II_method_8d5ebeb5(f14, f9);
            f2 += this.IiIIi_field_46;
            f += this.IiIiI_field_46;
        }
        if (bl) {
            f2 = this.I_method_56b59344(f2, this.IIIi_field_46, f9);
            f = this.I_method_56b59344(f, this.IIiI_field_46, f9);
            if (this.iI_field_ba20ca4c.i_method_9b12da03() && !this.I_method_56b59358(f11, f12, f9)) {
                f = 0.0f;
                f2 = 0.0f;
            }
        }
        f4 = MathHelper.clamp((float)(1.0f - (float)Math.exp(-20.0f * f9)), (float)0.05f, (float)0.95f);
        this.Iii_field_46 = this.i_method_f37cfb64(this.Iii_field_46, f2, f4);
        this.iII_field_46 = this.i_method_f37cfb64(this.iII_field_46, f, f4 * 0.75f);
        f3 = Math.abs(f11) * 1.5f + 0.5f;
        float f15 = Math.abs(f12) * 1.5f + 0.5f;
        this.Iii_field_46 = MathHelper.clamp((float)this.Iii_field_46, (float)(-f3), (float)f3);
        this.iII_field_46 = MathHelper.clamp((float)this.iII_field_46, (float)(-f15), (float)f15);
        this.iiI_method_c11d0a0c();
        this.IIII_method_8f30b2d5();
    };
    private final IiIIIiII_Class69<AttackEvent> II_field_3d936f41 = attackEvent -> {
        LivingEntity livingEntity;
        Entity entity;
        if (this.Iii_method_8a908210() && (entity = attackEvent.getEntity()) instanceof LivingEntity && (livingEntity = (LivingEntity)entity) != AimAssistModule.I_field_3a9bda27.player) {
            this.I_field_649d1bc1.I_method_215ef90c();
        }
    };

    public AimAssistModule() {
        this.IiI_method_8a81f62c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_8a81f62c() {
        this.I_field_bbe33e6c = new ModeSetting(this, "aimassist.mode");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "aimassist.mode_normal").select();
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "aimassist.mode_neuro");
        this.I_field_73178e8c = new SliderSetting(this, "aimassist.neuro_strength", "aimassist.neuro_strength.desc", () -> !this.Iii_method_8a908210()).I_method_c8c9a7d7(0.1f).i_method_65e2aff7(1.0f).II_method_b0f56334(0.05f).Ii_method_4e0e6b54(1.0f);
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.aura.targets");
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.players").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.animals").select();
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.mobs").select();
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.invisibles").select();
        this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.nakedPlayers").select();
        this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.rockUsers");
        this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.friends");
        this.i_field_bbe33e6c = new ModeSetting(this, "aura.targets_sort");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "aura.ts_dist");
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "aura.ts_health");
        this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "aura.ts_fov").select();
        this.II_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "aimassist.target_lock_mode", this::Iii_method_8a908210);
        this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "aimassist.lock_off");
        this.III_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "aimassist.lock_on_attack");
        this.IIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "aimassist.lock_auto").select();
        this.i_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.lock_timeout", this::Iii_method_8a908210).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(10.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(5.0f);
        this.II_field_73178e8c = new SliderSetting(this, "modules.settings.aura.aimDistance").I_method_c8c9a7d7(3.0f).i_method_65e2aff7(10.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(4.5f);
        this.Ii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.strength", this::Iii_method_8a908210).I_method_c8c9a7d7(0.1f).i_method_65e2aff7(2.0f).II_method_b0f56334(0.01f).Ii_method_4e0e6b54(1.0f);
        this.iI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.aim_speed", this::Iii_method_8a908210).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(60.0f).II_method_b0f56334(0.5f).Ii_method_4e0e6b54(18.0f);
        this.I_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "aimassist.repit_aim", this::Iii_method_8a908210).I_method_a4d009eb(false);
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "aimassist.enable_vertical", this::Iii_method_8a908210).I_method_decd82b5();
        this.ii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "projectile.vertical_factor", this::iII_method_bf5a19f0).I_method_c8c9a7d7(0.1f).i_method_65e2aff7(1.5f).II_method_b0f56334(0.01f).Ii_method_4e0e6b54(0.4f);
        this.III_field_73178e8c = new SliderSetting(this, "aimassist.motor_noise", "motornoise.desc", this::Iii_method_8a908210).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(0.4f).II_method_b0f56334(0.01f).Ii_method_4e0e6b54(0.15f);
        this.II_field_ba20ca4c = new BooleanSetting(this, "aimassist.only_on_weapon").I_method_decd82b5();
        this.Ii_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "aimassist.yield_to_mouse", this::Iii_method_8a908210).I_method_a4d009eb(false);
        this.iI_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "aimassist.input_based", this::IIII_method_8f30b2d9).I_method_a4d009eb(false);
        this.IIi_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.input_threshold", this::IIIi_method_8f3f3eb9).I_method_c8c9a7d7(0.1f).i_method_65e2aff7(3.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(0.8f);
        this.IiI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.prediction_ticks", this::Iii_method_8a908210).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(3.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(2.0f);
        this.Iii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.velo_pr_ticks", this::Iii_method_8a908210).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(3.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(1.0f);
        this.iII_field_73178e8c = new SliderSetting(this, "aimassist.prediction_chance", "aimassist.prediction_chance.desc", this::Iii_method_8a908210).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(65.0f).I_method_d41e7abf(" %");
        this.ii_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "aimassist.multipoint", () -> this.Iii_method_8a908210() || !this.Ii_field_ba20ca4c.i_method_9b12da03()).I_method_a4d009eb(false);
        this.III_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "aimassist.mp_adaptive", this::iIi_method_bf68a5d0).I_method_decd82b5();
        this.iIi_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.mp_count", this::iiI_method_c11d0a10).I_method_c8c9a7d7(3.0f).i_method_65e2aff7(50.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(8.0f);
        this.iiI_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.mp_spread", this::iiI_method_c11d0a10).I_method_c8c9a7d7(0.2f).i_method_65e2aff7(2.0f).II_method_b0f56334(0.05f).Ii_method_4e0e6b54(0.7f);
        this.iii_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "aimassist.regen", this::iIi_method_bf68a5d0).I_method_c8c9a7d7(0.005f).i_method_65e2aff7(0.2f).II_method_b0f56334(0.005f).Ii_method_4e0e6b54(0.025f);
        this.IIi_field_ba20ca4c = new BooleanSetting(this, "aimassist.overshoot", "aimassist.overshoot.desc", this::Iii_method_8a908210).I_method_a4d009eb(true);
        this.IIII_field_73178e8c = new SliderSetting(this, "aimassist.overshoot_chance", "aimassist.overshoot_chance.desc", () -> this.Iii_method_8a908210() || !this.IIi_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.0f).i_method_65e2aff7(10.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(3.0f).I_method_d41e7abf(" %");
    }

    private boolean Iii_method_8a908210() {
        return this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627);
    }

    private boolean iII_method_bf5a19f0() {
        return this.Iii_method_8a908210() || !this.i_field_ba20ca4c.i_method_9b12da03();
    }

    private boolean iIi_method_bf68a5d0() {
        return this.Iii_method_8a908210() || !this.ii_field_ba20ca4c.i_method_9b12da03() || !this.Ii_field_ba20ca4c.i_method_9b12da03();
    }

    private boolean iiI_method_c11d0a10() {
        return this.iIi_method_bf68a5d0() || this.III_field_ba20ca4c.i_method_9b12da03();
    }

    private boolean iii_method_c12b95f0() {
        return this.II_field_bbe33e6c.I_method_ce989e26(this.ii_field_500d0627);
    }

    private boolean IIII_method_8f30b2d9() {
        return this.Iii_method_8a908210() || !this.Ii_field_ba20ca4c.i_method_9b12da03();
    }

    private boolean IIIi_method_8f3f3eb9() {
        return this.IIII_method_8f30b2d9() || !this.iI_field_ba20ca4c.i_method_9b12da03();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.I_field_5a = false;
        this.Iii_method_8a90820c();
        this.iII_method_bf5a19ec();
        this.I_field_a83b6e4c.I_method_ef528dff();
        this.I_field_6fdd6a4c.I_method_dd9689ff();
        IiIIIiIIi_Class138 iiIIIiIIi_Class138 = RockstarClient.getInstance().I_method_9a638462();
        if (iiIIIiIIi_Class138 != null) {
            iiIIIiIIi_Class138.II_method_2b2a54e2();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.iII_method_bf5a19ec();
        this.I_field_a83b6e4c.I_method_ef528dff();
        this.I_field_6fdd6a4c.I_method_dd9689ff();
        IiIIIiIIi_Class138 iiIIIiIIi_Class138 = RockstarClient.getInstance().I_method_9a638462();
        if (iiIIIiIIi_Class138 != null) {
            iiIIIiIIi_Class138.II_method_2b2a54e2();
        }
    }

    private void Iii_method_8a90820c() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        this.iiiI_field_46 = 0.1f + threadLocalRandom.nextFloat() * 0.5f;
        this.iiii_field_46 = (0.5f + threadLocalRandom.nextFloat() * 0.75f) * 2.0f;
        this.IIIII_field_46 = 0.5f + threadLocalRandom.nextFloat() * 0.5f;
        this.IIIIi_field_46 = 3.0f + threadLocalRandom.nextFloat() * 0.25f;
        this.IIIiI_field_46 = 0.5f + threadLocalRandom.nextFloat() * 0.7f;
        this.IIIii_field_46 = 0.08f + threadLocalRandom.nextFloat() * 0.12f;
        this.IIiII_field_46 = 0.018f + threadLocalRandom.nextFloat() * 0.005f;
        this.IIiIi_field_46 = 0.45f + threadLocalRandom.nextFloat() * 0.05f;
        this.IIiiI_field_46 = 2.0f + threadLocalRandom.nextFloat();
        this.IIiii_field_46 = 8.0f + threadLocalRandom.nextFloat() * 3.0f;
        this.IiIII_field_46 = 0.15f + threadLocalRandom.nextFloat() * 0.05f;
        this.iiII_field_46 = iIIiiiiiI_Class319.iI_method_330da892(this.IIIII_field_46, this.IIIIi_field_46);
        this.Iiii_field_46 = 0.3f + threadLocalRandom.nextFloat() * 0.4f;
        this.iIII_field_46 = 0.2f + threadLocalRandom.nextFloat() * 0.3f;
        this.iIIi_field_46 = 0.04f + threadLocalRandom.nextFloat() * 0.06f;
        this.I_field_6fdd6a4c.I_method_d53b1da1(0.05f + iIIiiiiiI_Class319.iI_method_330da892(-0.03f, 0.15f));
        this.IiiIi_field_46 = this.iii_field_73178e8c.Ii_method_a20abcd2();
    }

    private void iII_method_bf5a19ec() {
        this.i_field_966247a3 = null;
        this.I_field_966247a3 = null;
        this.III_field_46 = 0.0f;
        this.IiI_field_46 = 0.0f;
        this.IIi_field_46 = 0.0f;
        this.II_field_5a = false;
        this.Ii_field_5a = false;
        this.i_field_5a = true;
        this.iII_field_46 = 0.0f;
        this.Iii_field_46 = 0.0f;
        this.iiI_field_46 = 0.0f;
        this.iIi_field_46 = 0.0f;
        this.iii_field_46 = Float.NaN;
        this.IIII_field_46 = 0.0f;
        this.IIiI_field_46 = 0.0f;
        this.IIIi_field_46 = 0.0f;
        this.IiII_field_46 = 0.0f;
        this.IIii_field_46 = 0.0f;
        this.iiIi_field_46 = 0.0f;
        this.iIiI_field_46 = 0.0f;
        this.II_field_4a = 0L;
        this.I_field_4a = 0L;
        this.i_field_4a = 0L;
        this.Ii_field_44 = 0.0;
        this.II_field_44 = 0.0;
        this.i_field_44 = 0.0;
        this.Ii_field_4a = 0L;
        this.III_field_5a = false;
        this.ii_field_5a = false;
        this.IiIiI_field_46 = 0.0f;
        this.IiIIi_field_46 = 0.0f;
        this.IiiII_field_46 = 0.0f;
        this.IiIii_field_46 = 0.0f;
        this.IiiI_field_46 = 0.0f;
        this.IiIi_field_46 = 0.0f;
        this.i_field_b4b[1] = 0.0f;
        this.i_field_b4b[0] = 0.0f;
        this.I_field_649d1bc1.i_method_216d84ec();
        this.iI_field_46 = 0.0f;
        this.Ii_field_46 = 0.0f;
        this.ii_field_46 = 0.0f;
    }

    private void iIi_method_bf68a5cc() {
        if (this.I_field_966247a3 == null || AimAssistModule.I_field_3a9bda27.player == null || AimAssistModule.I_field_3a9bda27.world == null) {
            this.I_field_649d1bc1.i_method_216d84ec();
            this.iI_field_46 = 0.0f;
            this.Ii_field_46 = 0.0f;
            return;
        }
        if (!this.I_field_649d1bc1.I_method_215ef910()) {
            if (!this.I_field_5a) {
                this.I_field_5a = true;
                iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)"Aim Assist: \u043c\u043e\u0434\u0435\u043b\u044c \u043d\u0435\u0439\u0440\u043e \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u0430 \u2014 \u043e\u0431\u0443\u0447\u0438 \u0435\u0451 \u0447\u0435\u0440\u0435\u0437 .neuro"));
            }
            return;
        }
        if (!this.I_field_649d1bc1.I_method_8e4c985c(AimAssistModule.I_field_3a9bda27.player, AimAssistModule.I_field_3a9bda27.world, this.I_field_966247a3, iiiIIiii_Class232.I_method_685930bc(), this.I_field_b4b)) {
            return;
        }
        float f = this.I_field_73178e8c.Ii_method_a20abcd2();
        this.Ii_field_46 = MathHelper.clamp((float)(this.Ii_field_46 + this.I_field_b4b[0] * f), (float)-90.0f, (float)90.0f);
        this.iI_field_46 = MathHelper.clamp((float)(this.iI_field_46 + this.I_field_b4b[1] * f), (float)-90.0f, (float)90.0f);
        this.ii_field_46 = 0.0f;
    }

    private void I_method_98ff6054(float f) {
        if (AimAssistModule.I_field_3a9bda27.player == null) {
            return;
        }
        if (Math.abs(this.Ii_field_46) < 1.0E-4f && Math.abs(this.iI_field_46) < 1.0E-4f) {
            this.IIII_method_8f30b2d5();
            return;
        }
        this.ii_field_46 += f;
        float f2 = Math.max(0.05f - (this.ii_field_46 - f), f);
        float f3 = MathHelper.clamp((float)(f / f2), (float)0.0f, (float)1.0f);
        float f4 = this.Ii_field_46 * f3;
        float f5 = this.iI_field_46 * f3;
        this.Ii_field_46 -= f4;
        this.iI_field_46 -= f5;
        this.I_method_86ed11ec(f4, f5);
        this.IIII_method_8f30b2d5();
    }

    private void I_method_801a3f1(LivingEntity livingEntity, float f, float f2) {
        double d;
        double d2;
        float f3;
        double d3;
        Vec3d vec3d;
        if (livingEntity == null || AimAssistModule.I_field_3a9bda27.player == null) {
            this.Ii_field_b4b[1] = 0.0f;
            this.Ii_field_b4b[0] = 0.0f;
            return;
        }
        double d4 = MathHelper.lerp((double)f, (double)livingEntity.lastRenderX, (double)livingEntity.getX());
        double d5 = MathHelper.lerp((double)f, (double)livingEntity.lastRenderY, (double)livingEntity.getY());
        double d6 = MathHelper.lerp((double)f, (double)livingEntity.lastRenderZ, (double)livingEntity.getZ());
        int n = (int)this.IiI_field_73178e8c.Ii_method_a20abcd2();
        if (n > 0 && ThreadLocalRandom.current().nextFloat() < this.iII_field_73178e8c.Ii_method_a20abcd2() && (vec3d = this.I_field_a83b6e4c.i_method_d77c9119()) != null && (d3 = vec3d.lengthSquared()) > 1.0E-6) {
            d4 += vec3d.x * (double)n;
            d5 += vec3d.y * (double)n;
            d6 += vec3d.z * (double)n;
        }
        if ((f3 = AimAssistModule.I_field_3a9bda27.player.getAttackCooldownProgress(1.5f)) > 0.85f && !AimAssistModule.I_field_3a9bda27.player.isUsingItem() && (d2 = (d3 = livingEntity.getX() - this.iI_field_44) * d3 + (d = livingEntity.getZ() - this.III_field_44) * d) < 12.25 && d2 > 2.25) {
            float f4 = (f3 - 0.85f) / 0.15f;
            f4 *= f4;
            iIiIiIiii_Class344.I_method_d6afca12(this.I_field_b49, this.iI_field_44, this.III_field_44, AimAssistModule.I_field_3a9bda27.player.getYaw(), livingEntity, AimAssistModule.I_field_3a9bda27.player.isSprinting(), iIiIiIiii_Class344.I_method_7b914a6e((LivingEntity)AimAssistModule.I_field_3a9bda27.player), (int)this.Iii_field_73178e8c.Ii_method_a20abcd2());
            d4 -= this.I_field_b49[0] * (double)f4;
            d5 -= this.I_field_b49[1] * (double)f4;
            d6 -= this.I_field_b49[2] * (double)f4;
        }
        if (this.ii_field_ba20ca4c.i_method_9b12da03() && this.Ii_field_ba20ca4c.i_method_9b12da03()) {
            this.I_method_f81622ad(livingEntity, d4, d5, d6);
            double[] dArray = this.I_field_6fdd6a4c.I_method_d53ab6c0();
            if (dArray != null) {
                d3 = dArray[0];
                d = dArray[1];
                d2 = dArray[2];
            } else {
                d3 = d4;
                d = d5 + (double)(livingEntity.getHeight() * 0.5f);
                d2 = d6;
            }
        } else {
            d3 = d4;
        }
        d = d5 + (double)(livingEntity.getHeight() * 0.5f);
        d2 = d6;
        if (!this.Ii_field_5a) {
            this.i_field_44 = d3;
            this.II_field_44 = d;
            this.Ii_field_44 = d2;
            this.Ii_field_5a = true;
        } else {
            double d7 = MathHelper.clamp((double)(1.0 - Math.exp(-25.0 * (double)f2)), (double)0.05, (double)0.95);
            this.i_field_44 += (d3 - this.i_field_44) * d7;
            this.II_field_44 += (d - this.II_field_44) * d7;
            this.Ii_field_44 += (d2 - this.Ii_field_44) * d7;
        }
        double d8 = this.i_field_44 - this.iI_field_44;
        double d9 = this.II_field_44 - this.ii_field_44;
        double d10 = this.Ii_field_44 - this.III_field_44;
        double d11 = d8 * d8 + d10 * d10;
        double d12 = Math.sqrt(d11);
        if (d12 < (double)1.0E-4f && Math.abs(d9) < (double)1.0E-4f) {
            this.Ii_field_b4b[1] = 0.0f;
            this.Ii_field_b4b[0] = 0.0f;
            return;
        }
        float f5 = (float)Math.toDegrees(Math.atan2(d10, d8)) - 90.0f;
        float f6 = MathHelper.clamp((float)((float)(-Math.toDegrees(Math.atan2(d9, d12)))), (float)-90.0f, (float)90.0f);
        this.Ii_field_b4b[0] = MathHelper.wrapDegrees((float)(f5 - AimAssistModule.I_field_3a9bda27.player.getYaw()));
        this.Ii_field_b4b[1] = f6 - AimAssistModule.I_field_3a9bda27.player.getPitch();
    }

    private void iiI_method_c11d0a0c() {
        this.I_method_86ed11ec(this.Iii_field_46, this.iII_field_46);
    }

    private void I_method_86ed11ec(float f, float f2) {
        if (AimAssistModule.I_field_3a9bda27.player == null) {
            return;
        }
        this.i_method_bd8825cc(f, f2);
        float f3 = Float.isFinite(this.II_field_b4b[0]) ? this.II_field_b4b[0] : 0.0f;
        float f4 = Float.isFinite(this.II_field_b4b[1]) ? this.II_field_b4b[1] : 0.0f;
        float f5 = AimAssistModule.I_field_3a9bda27.player.getYaw() + f3;
        float f6 = MathHelper.clamp((float)(AimAssistModule.I_field_3a9bda27.player.getPitch() + f4), (float)-90.0f, (float)90.0f);
        AimAssistModule.I_field_3a9bda27.player.setYaw(f5);
        AimAssistModule.I_field_3a9bda27.player.setPitch(f6);
        AimAssistModule.I_field_3a9bda27.player.headYaw = f5;
        this.IIii_field_46 = f3;
        this.IiII_field_46 = f4;
    }

    private void i_method_bd8825cc(float f, float f2) {
        float f3 = this.I_method_1db5a4dc();
        if (f3 < 1.0E-4f) {
            this.II_field_b4b[0] = f;
            this.II_field_b4b[1] = f2;
            return;
        }
        this.iIi_field_46 += f;
        this.iiI_field_46 += f2;
        float f4 = (float)Math.round(this.iIi_field_46 / f3) * f3;
        float f5 = (float)Math.round(this.iiI_field_46 / f3) * f3;
        this.iIi_field_46 = MathHelper.clamp((float)(this.iIi_field_46 - f4), (float)(-f3 * 2.0f), (float)(f3 * 2.0f));
        this.iiI_field_46 = MathHelper.clamp((float)(this.iiI_field_46 - f5), (float)(-f3 * 2.0f), (float)(f3 * 2.0f));
        this.II_field_b4b[0] = f4;
        this.II_field_b4b[1] = f5;
    }

    private float I_method_1db5a4dc() {
        double d = (Double)AimAssistModule.I_field_3a9bda27.options.getMouseSensitivity().getValue();
        double d2 = d * 0.6 + 0.2;
        double d3 = d2 * d2 * d2 * 8.0;
        return (float)(d3 * 0.15);
    }

    private void I_method_7ffd3eec(float f, float f2, float f3, float f4) {
        float f5 = (float)Math.exp(-f4 / 0.04f);
        float f6 = this.i_method_1dc430bc();
        float f7 = this.i_method_1dc430bc();
        float f8 = MathHelper.sqrt((float)(f * f + f2 * f2)) + 1.0E-4f;
        float f9 = f3 * f8 * (1.0f - f5);
        float f10 = f / f8;
        float f11 = f2 / f8;
        float f12 = -f11;
        float f13 = f10;
        float f14 = f6 * f9;
        float f15 = f7 * f9 * 0.4f;
        this.i_field_b4b[0] = this.i_field_b4b[0] * f5 + f14 * f10 + f15 * f12;
        this.i_field_b4b[1] = this.i_field_b4b[1] * f5 + f14 * f11 + f15 * f13;
    }

    private float I_method_98ff6044(float f) {
        this.IiIi_field_46 += this.Iiii_field_46 * f;
        this.IiiI_field_46 += this.iIII_field_46 * f;
        if ((double)this.IiIi_field_46 > Math.PI * 2) {
            this.IiIi_field_46 -= (float)Math.PI * 2;
        }
        if ((double)this.IiiI_field_46 > Math.PI * 2) {
            this.IiiI_field_46 -= (float)Math.PI * 2;
        }
        return this.iIIi_field_46 * (0.6f * (float)Math.sin(this.IiIi_field_46) + 0.4f * (float)Math.sin(this.IiiI_field_46 * 1.618f));
    }

    private float i_method_1dc430bc() {
        if (this.III_field_5a) {
            this.III_field_5a = false;
            return this.IiiiI_field_46;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double d = Math.max(1.0E-10, threadLocalRandom.nextDouble());
        double d2 = threadLocalRandom.nextDouble();
        double d3 = Math.sqrt(-2.0 * Math.log(d));
        this.IiiiI_field_46 = (float)(d3 * Math.sin(Math.PI * 2 * d2));
        this.III_field_5a = true;
        return (float)(d3 * Math.cos(Math.PI * 2 * d2));
    }

    private float I_method_86ed11dc(float f, float f2) {
        this.iIii_field_46 += f2;
        if (this.iIii_field_46 >= this.iiII_field_46) {
            this.iI_field_5a = !this.iI_field_5a;
            this.iIii_field_46 = 0.0f;
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
            this.iiII_field_46 = this.iI_field_5a ? this.iiiI_field_46 + threadLocalRandom.nextFloat() * (this.iiii_field_46 - this.iiiI_field_46) : this.IIIII_field_46 + threadLocalRandom.nextFloat() * (this.IIIIi_field_46 - this.IIIII_field_46);
        }
        float f3 = this.iI_field_5a ? 7.0f : 2.5f;
        float f4 = this.iI_field_5a ? this.IIIiI_field_46 : this.IIIii_field_46;
        this.iIiI_field_46 += (f4 - this.iIiI_field_46) * (1.0f - (float)Math.exp(-f3 * f2));
        float f5 = this.iIiI_field_46;
        float f6 = this.IIiII_field_46 * (7.0f / Math.max(this.iI_field_73178e8c.Ii_method_a20abcd2(), 1.0f));
        this.iiIi_field_46 = MathHelper.clamp((float)(this.iiIi_field_46 + f2 * f6), (float)0.0f, (float)this.IIiIi_field_46);
        f5 += this.iiIi_field_46;
        if (f < this.IIiiI_field_46) {
            f5 *= this.IiIII_field_46;
        } else if (f < this.IIiii_field_46) {
            float f7 = (f - this.IIiiI_field_46) / (this.IIiii_field_46 - this.IIiiI_field_46);
            f5 *= this.IiIII_field_46 + (1.0f - this.IiIII_field_46) * f7;
        }
        return Math.max(f5, 0.0f);
    }

    private void II_method_8d5ebeb5(float f, float f2) {
        if (this.ii_field_5a) {
            this.IiIii_field_46 += f2;
            if (this.IiIii_field_46 >= this.IiiII_field_46) {
                this.ii_field_5a = false;
                this.IiIiI_field_46 = 0.0f;
                this.IiIIi_field_46 = 0.0f;
            }
            return;
        }
        if (f < 3.0f && f > 0.5f) {
            if (ThreadLocalRandom.current().nextFloat() < this.IIII_field_73178e8c.Ii_method_a20abcd2() * f2 * 20.0f) {
                this.ii_field_5a = true;
                this.IiIii_field_46 = 0.0f;
                this.IiiII_field_46 = 0.08f + ThreadLocalRandom.current().nextFloat() * 0.12f;
                float f3 = 1.0f + ThreadLocalRandom.current().nextFloat() * 2.0f;
                float f4 = ThreadLocalRandom.current().nextBoolean() ? 1.0f : -1.0f;
                this.IiIIi_field_46 = f4 * f3 * f2;
                this.IiIiI_field_46 = (ThreadLocalRandom.current().nextFloat() - 0.5f) * f3 * f2 * 0.3f;
            }
        } else {
            this.IiIiI_field_46 = 0.0f;
            this.IiIIi_field_46 = 0.0f;
        }
    }

    private float i_method_9ac25064(float f) {
        return -MathHelper.clamp((float)(f * 0.12f), (float)0.0f, (float)1.5f);
    }

    private void i_method_7c22dacc(float f, float f2, float f3, float f4) {
        if (f < 0.1f) {
            this.i_field_5a = false;
            this.III_field_46 = 1.0f;
            return;
        }
        if (!this.i_field_5a) {
            return;
        }
        this.III_field_46 += f3 / Math.max(f4 * 0.4f, 0.01f);
        if (this.III_field_46 >= 1.0f || f < f2 * 2.0f) {
            this.i_field_5a = false;
            this.III_field_46 = 1.0f;
        }
    }

    private float II_method_88b0765b(float f) {
        f = MathHelper.clamp((float)f, (float)0.0f, (float)1.0f);
        return 24.0f * f * f * (1.0f - f) * (1.0f - f);
    }

    private float i_method_bd8825bc(float f, float f2) {
        float f3 = MathHelper.sqrt((float)(f * f + f2 * f2));
        return f3 < 1.0E-4f ? 0.1f : 0.4f + 0.3f * Math.min(f3 / 5.0f, 1.0f);
    }

    private float I_method_7ffd3edc(float f, float f2, float f3, float f4) {
        float f5 = Math.abs(f);
        float f6 = f > 0.0f ? 0.4f : 0.8f;
        float f7 = this.ii_field_73178e8c.Ii_method_a20abcd2();
        if (f5 > 7.0f) {
            float f8 = this.II_method_8d5ebea5(f5, f3);
            float f9 = Math.max(f8 / (this.iI_field_73178e8c.Ii_method_a20abcd2() * 0.4f), 0.02f);
            return MathHelper.clamp((float)(Math.signum(f) * (f5 / f9) * 0.5f * f4 * this.Ii_field_73178e8c.Ii_method_a20abcd2() * f6 * f7), (float)-20.0f, (float)20.0f);
        }
        if (f5 > 0.3f) {
            return MathHelper.clamp((float)(f * 0.6f * f6 * f7 * f4 * 10.0f), (float)-20.0f, (float)20.0f);
        }
        return f * 2.0f * 0.4f * f6 * f7 * f4 * 10.0f;
    }

    private float II_method_8d5ebea5(float f, float f2) {
        if (f < 1.0E-4f) {
            return 0.0f;
        }
        return (float)(Math.log((double)(f / Math.max(f2, 0.1f)) + 1.0) / Math.log(2.0));
    }

    private float I_method_9c60f421(LivingEntity livingEntity) {
        if (livingEntity == null) {
            return 1.0f;
        }
        double d = livingEntity.getX() - this.iI_field_44;
        double d2 = livingEntity.getY() + (double)livingEntity.getHeight() * 0.5 - this.ii_field_44;
        double d3 = livingEntity.getZ() - this.III_field_44;
        double d4 = d * d + d2 * d2 + d3 * d3;
        double d5 = Math.max(Math.sqrt(d4), 0.5);
        return (float)Math.toDegrees(Math.atan2((double)livingEntity.getWidth() * 0.5, d5));
    }

    private void iii_method_c12b95ec() {
        if (!Float.isNaN(this.iii_field_46) && AimAssistModule.I_field_3a9bda27.player != null) {
            this.IIIi_field_46 = MathHelper.wrapDegrees((float)(AimAssistModule.I_field_3a9bda27.player.getYaw() - this.iii_field_46)) - this.IIii_field_46;
            this.IIiI_field_46 = AimAssistModule.I_field_3a9bda27.player.getPitch() - this.IIII_field_46 - this.IiII_field_46;
        } else {
            this.IIiI_field_46 = 0.0f;
            this.IIIi_field_46 = 0.0f;
        }
    }

    private void IIII_method_8f30b2d5() {
        if (AimAssistModule.I_field_3a9bda27.player != null) {
            this.iii_field_46 = AimAssistModule.I_field_3a9bda27.player.getYaw();
            this.IIII_field_46 = AimAssistModule.I_field_3a9bda27.player.getPitch();
        }
    }

    private float I_method_56b59344(float f, float f2, float f3) {
        float f4;
        if (Math.abs(f) < 1.0E-4f) {
            return f;
        }
        float f5 = f4 = f3 > 1.0E-4f ? f2 / f3 : 0.0f;
        if (Math.abs(f4) < 0.1f) {
            return f;
        }
        if (f > 0.0f == f4 > 0.0f) {
            return f * 0.95f;
        }
        float f6 = 1.0f - MathHelper.clamp((float)(Math.abs(f4) / Math.abs(f)), (float)0.0f, (float)0.8f);
        return f * f6;
    }

    private boolean I_method_56b59358(float f, float f2, float f3) {
        if (f3 < 1.0E-4f) {
            return false;
        }
        float f4 = this.IIIi_field_46 / f3;
        float f5 = this.IIiI_field_46 / f3;
        float f6 = this.IIi_field_73178e8c.Ii_method_a20abcd2();
        if (Math.abs(f4) < f6 && Math.abs(f5) < f6) {
            return false;
        }
        boolean bl = Math.signum(f) == Math.signum(f4) || Math.abs(f) < 0.5f;
        boolean bl2 = Math.signum(f2) == Math.signum(f5) || Math.abs(f2) < 0.5f;
        return bl || bl2;
    }

    private void I_method_f81622ad(LivingEntity livingEntity, double d, double d2, double d3) {
        long l;
        if (!this.ii_field_ba20ca4c.i_method_9b12da03() || livingEntity == null || AimAssistModule.I_field_3a9bda27.player == null || AimAssistModule.I_field_3a9bda27.world == null) {
            return;
        }
        long l2 = AimAssistModule.I_field_3a9bda27.world.getTime();
        if (l2 - this.Ii_field_4a < (l = Math.max(1L, (long)(this.iii_field_73178e8c.Ii_method_a20abcd2() * 20.0f)))) {
            return;
        }
        this.Ii_field_4a = l2;
        Vec3d vec3d = new Vec3d(d, d2, d3);
        this.I_field_6fdd6a4c.I_method_7321c2f8((int)this.iIi_field_73178e8c.Ii_method_a20abcd2(), this.iiI_field_73178e8c.Ii_method_a20abcd2(), this.III_field_ba20ca4c.i_method_9b12da03());
        this.I_field_6fdd6a4c.I_method_fd036888(vec3d, livingEntity, AimAssistModule.I_field_3a9bda27.player.getPos(), AimAssistModule.I_field_3a9bda27.player.distanceTo((Entity)livingEntity));
    }

    private void IIIi_method_8f3f3eb5() {
        boolean bl;
        if (this.I_field_966247a3 == null || AimAssistModule.I_field_3a9bda27.player == null || AimAssistModule.I_field_3a9bda27.world == null) {
            return;
        }
        Entity entity = AimAssistModule.I_field_3a9bda27.world.getEntityById(this.I_field_966247a3.getId());
        boolean bl2 = bl = entity != this.I_field_966247a3 || this.I_field_966247a3.distanceTo((Entity)AimAssistModule.I_field_3a9bda27.player) > this.II_field_73178e8c.Ii_method_a20abcd2() + 1.0f || this.I_field_966247a3.isDead() || this.I_field_966247a3.getHealth() <= 0.0f;
        if (bl) {
            if (this.i_field_966247a3 == this.I_field_966247a3) {
                this.i_field_966247a3 = null;
            }
            this.I_field_966247a3 = null;
            this.Ii_field_5a = false;
            this.I_field_4a = System.currentTimeMillis();
        }
    }

    private void IIiI_method_90f3a2f5() {
        if (this.iii_method_c12b95f0()) {
            this.i_field_966247a3 = null;
            return;
        }
        long l = System.currentTimeMillis();
        if (this.i_field_966247a3 != null && l - this.i_field_4a > (long)(this.i_field_73178e8c.Ii_method_a20abcd2() * 1000.0f)) {
            this.i_field_966247a3 = null;
        }
        if (this.II_field_bbe33e6c.I_method_ce989e26(this.III_field_500d0627) && this.i_field_966247a3 == null && AimAssistModule.I_field_3a9bda27.options.attackKey.isPressed() && this.I_field_966247a3 != null) {
            this.i_field_966247a3 = this.I_field_966247a3;
            this.i_field_4a = l;
        }
        if (this.II_field_bbe33e6c.I_method_ce989e26(this.IIi_field_500d0627) && this.i_field_966247a3 == null && this.I_field_966247a3 != null && l - this.I_field_4a < 500L) {
            this.i_field_966247a3 = this.I_field_966247a3;
            this.i_field_4a = l;
        }
        if (this.i_field_966247a3 != null && AimAssistModule.I_field_3a9bda27.player != null && (this.i_field_966247a3.isDead() || this.i_field_966247a3.getHealth() <= 0.0f || this.i_field_966247a3.distanceTo((Entity)AimAssistModule.I_field_3a9bda27.player) > this.II_field_73178e8c.Ii_method_a20abcd2())) {
            this.i_field_966247a3 = null;
        }
    }

    private void IIii_method_91022ed5() {
        boolean bl;
        LivingEntity livingEntity;
        if (AimAssistModule.I_field_3a9bda27.player == null) {
            return;
        }
        if (this.i_field_966247a3 != null && !this.iii_method_c12b95f0()) {
            this.I_field_966247a3 = this.i_field_966247a3;
            return;
        }
        IiIIIiIIi_Class138 iiIIIiIIi_Class138 = RockstarClient.getInstance().I_method_9a638462();
        if (iiIIIiIIi_Class138 == null) {
            return;
        }
        Entity entity = iiIIIiIIi_Class138.I_method_9c10f815();
        LivingEntity livingEntity2 = entity instanceof LivingEntity ? (livingEntity = (LivingEntity)entity) : null;
        boolean bl2 = bl = livingEntity2 == null || !livingEntity2.isAlive() || livingEntity2.distanceTo((Entity)AimAssistModule.I_field_3a9bda27.player) > this.II_field_73178e8c.Ii_method_a20abcd2();
        if (bl) {
            LivingEntity livingEntity3;
            iiIIIiIIi_Class138.I_method_aa3068e7(this.I_method_ae8b6802());
            Entity entity2 = iiIIIiIIi_Class138.I_method_9c10f815();
            LivingEntity livingEntity4 = livingEntity2 = entity2 instanceof LivingEntity ? (livingEntity3 = (LivingEntity)entity2) : null;
        }
        if (livingEntity2 != this.I_field_966247a3) {
            this.I_method_9c60f431(livingEntity2);
        }
    }

    private void I_method_9c60f431(LivingEntity livingEntity) {
        this.I_field_966247a3 = livingEntity;
        this.I_field_4a = System.currentTimeMillis();
        this.Ii_field_5a = false;
        this.Ii_field_44 = 0.0;
        this.II_field_44 = 0.0;
        this.i_field_44 = 0.0;
        this.IIi_field_46 = 0.0f;
        this.II_field_5a = false;
        this.IiI_field_46 = this.I_field_966247a3 != null ? this.i_method_bc7fdc41(this.I_field_966247a3) : 0.0f;
        this.i_field_5a = true;
        this.III_field_46 = 0.0f;
        this.Ii_field_4a = 0L;
        this.I_field_6fdd6a4c.I_method_dd9689ff();
        this.I_field_a83b6e4c.I_method_ef528dff();
        this.ii_field_5a = false;
        this.IiIiI_field_46 = 0.0f;
        this.IiIIi_field_46 = 0.0f;
        this.iII_field_46 = 0.0f;
        this.Iii_field_46 = 0.0f;
        this.i_field_b4b[1] = 0.0f;
        this.i_field_b4b[0] = 0.0f;
    }

    private float i_method_bc7fdc41(LivingEntity livingEntity) {
        double d;
        double d2;
        float f = 0.5f;
        if (AimAssistModule.I_field_3a9bda27.player == null || livingEntity == null) {
            return f;
        }
        double d3 = livingEntity.getX() - AimAssistModule.I_field_3a9bda27.player.getX();
        double d4 = d3 * d3 + (d2 = livingEntity.getY() - AimAssistModule.I_field_3a9bda27.player.getY()) * d2 + (d = livingEntity.getZ() - AimAssistModule.I_field_3a9bda27.player.getZ()) * d;
        if (d4 > (double)1.0E-4f) {
            double d5 = Math.sqrt(d4);
            Vec3d vec3d = AimAssistModule.I_field_3a9bda27.player.getRotationVector();
            float f2 = (float)((d3 * vec3d.x + d2 * vec3d.y + d * vec3d.z) / d5);
            f += (1.0f - MathHelper.clamp((float)f2, (float)-1.0f, (float)1.0f)) * 0.08f;
        }
        return f;
    }

    private IiIIIiIiI_Class139 I_method_ae8b6802() {
        return new IiIIIiIiI_Class139.Nested1_a87537e0().I_method_1f3a928b(this.I_field_51de8227.isSelected()).i_method_da3212ab(this.i_field_51de8227.isSelected()).II_method_9a5032be(this.II_field_51de8227.isSelected()).iI_method_3e48b69e(this.Ii_field_51de8227.isSelected()).ii_method_f94036be(this.iI_field_51de8227.isSelected()).III_method_81ee98eb(this.III_field_51de8227.isSelected()).Ii_method_5547b2de(this.ii_field_51de8227.isSelected()).I_method_7d0aed77(this.II_field_73178e8c.Ii_method_a20abcd2()).I_method_8fd609a4(this.i_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627) ? IiIIIiIII_Class137.i_field_c8f916f9 : (this.i_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627) ? IiIIIiIII_Class137.II_field_c8f916f9 : IiIIIiIII_Class137.I_field_c8f916f9)).I_method_7ebd8d70();
    }

    private boolean IIiI_method_90f3a2f9() {
        if (this.I_field_966247a3 == null || AimAssistModule.I_field_3a9bda27.player == null) {
            return true;
        }
        return this.I_field_ba20ca4c.i_method_9b12da03() && !this.II_field_5a;
    }

    private float I_method_98ff6f48(long l) {
        if (this.II_field_4a == 0L) {
            return 0.016666668f;
        }
        long l2 = l - this.II_field_4a;
        if (l2 <= 0L) {
            return 0.016666668f;
        }
        return Math.min((float)l2 / 1.0E9f, 0.1f);
    }

    private float II_method_990defe5() {
        try {
            return I_field_3a9bda27.getRenderTickCounter().getTickDelta(false);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            return 1.0f;
        }
    }

    private float i_method_f37cfb64(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    private boolean IIii_method_91022ed9() {
        return AimAssistModule.I_field_3a9bda27.player == null || AimAssistModule.I_field_3a9bda27.world == null || AimAssistModule.I_field_3a9bda27.player.isDead();
    }

    public boolean IiI_method_8a81f630() {
        if (AimAssistModule.I_field_3a9bda27.player == null) {
            return false;
        }
        ItemStack itemStack = AimAssistModule.I_field_3a9bda27.player.getStackInHand(Hand.MAIN_HAND);
        if (itemStack.isEmpty()) {
            return false;
        }
        Item item = itemStack.getItem();
        try {
            RegistryEntry.Reference reference = item.getRegistryEntry();
            if (reference != null) {
                String string = reference.getIdAsString();
                for (String string2 : I_field_a56a8dc5) {
                    if (!string.contains(string2)) continue;
                    return true;
                }
            }
        }
        catch (Exception exception) {
            String string = item.getName().getString().toLowerCase();
            for (String string3 : I_field_a56a8dc5) {
                if (!string.contains(string3)) continue;
                return true;
            }
        }
        return false;
    }

    @Generated
    public iiiIiIII_Class233 I_method_fb1eabeb() {
        return this.I_field_649d1bc1;
    }
}

