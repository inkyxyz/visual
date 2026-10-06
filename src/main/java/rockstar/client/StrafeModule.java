package rockstar.client;

import net.minecraft.util.math.MathHelper;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIIIiIIi_Class266;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Strafe", category=ModuleCategory.MOVEMENT, III_method_a89e5834="modules.descriptions.strafe")
public class StrafeModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private final iIIIIiIIi_Class266 I_field_757ac26c = new iIIIIiIIi_Class266();
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        double d;
        if (StrafeModule.I_field_3a9bda27.player == null || StrafeModule.I_field_3a9bda27.world == null) {
            return;
        }
        if (!IiiiiiiII_Class253.I_method_1cb61e43() || StrafeModule.I_field_3a9bda27.player.isGliding() || StrafeModule.I_field_3a9bda27.player.isClimbing() || StrafeModule.I_field_3a9bda27.player.isTouchingWater()) {
            this.I_field_757ac26c.I_method_2acfd1ff(0.0);
            return;
        }
        if (this.I_field_ba20ca4c.i_method_9b12da03() && StrafeModule.I_field_3a9bda27.player.isOnGround() && !StrafeModule.I_field_3a9bda27.options.jumpKey.isPressed()) {
            StrafeModule.I_field_3a9bda27.player.jump();
        }
        if ((d = this.I_field_757ac26c.I_method_36867479(this.i_field_ba20ca4c.i_method_9b12da03(), StrafeModule.I_field_3a9bda27.player.hurtTime > 0, this.I_field_ba20ca4c.i_method_9b12da03(), this.I_field_73178e8c.Ii_method_a20abcd2())) <= 0.0) {
            return;
        }
        this.I_method_a29c38f2(d);
        double d2 = Math.hypot(StrafeModule.I_field_3a9bda27.player.getVelocity().x, StrafeModule.I_field_3a9bda27.player.getVelocity().z);
        this.I_field_757ac26c.I_method_2acfd1ff(d2);
    };

    public StrafeModule() {
        this.IiI_method_b4811a0c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_b4811a0c() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.strafe.auto_jump");
        this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.strafe.damage_boost");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.strafe.damage_speed", () -> !this.i_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(0.05f).i_method_65e2aff7(0.8f).II_method_b0f56334(0.01f).Ii_method_4e0e6b54(0.4f);
    }

    @Override
    public final void onDisable() {
        this.I_field_757ac26c.I_method_a68ad21f();
        super.onDisable();
    }

    private void I_method_a29c38f2(double d) {
        float f = StrafeModule.I_field_3a9bda27.player.input.movementForward;
        float f2 = StrafeModule.I_field_3a9bda27.player.input.movementSideways;
        float f3 = StrafeModule.I_field_3a9bda27.player.getYaw();
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += f > 0.0f ? -45.0f : 45.0f;
            } else if (f2 < 0.0f) {
                f3 += f > 0.0f ? 45.0f : -45.0f;
            }
            f2 = 0.0f;
            f = MathHelper.clamp((float)(f > 0.0f ? 1.0f : -1.0f), (float)-1.0f, (float)1.0f);
        }
        f2 = MathHelper.clamp((float)f2, (float)-1.0f, (float)1.0f);
        double d2 = Math.toRadians(f3 + 90.0f);
        double d3 = Math.sin(d2);
        double d4 = Math.cos(d2);
        double d5 = (double)f * d * d4 + (double)f2 * d * d3;
        double d6 = (double)f * d * d3 - (double)f2 * d * d4;
        StrafeModule.I_field_3a9bda27.player.setVelocity(d5, StrafeModule.I_field_3a9bda27.player.getVelocity().y, d6);
    }
}

