package rockstar.client;

import lombok.Generated;
import net.minecraft.client.option.Perspective;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.RotateCameraEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.InputEvent;
import pyrock.events.render.HudRenderEvent;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.Module;
import rockstar.client.iiIiiIiIi_Class438;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Free Camera", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.free_camera")
public class FreeCameraModule
extends Module {
    private SliderSetting I_field_73178e8c;
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private BooleanSetting II_field_ba20ca4c;
    private double I_field_44;
    private double i_field_44;
    private double II_field_44;
    private Vec3d I_field_5bba0d50 = Vec3d.ZERO;
    private iiIIiIIii_Class404 I_field_32e13e6c = iiIIiIIii_Class404.I_field_32e13e6c;
    Perspective I_field_dbf4bfd5;
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(50L, IiiiIiiII_Class237.Iii_field_dd60aac);
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(50L, IiiiIiiII_Class237.Iii_field_dd60aac);
    private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(50L, IiiiIiiII_Class237.Iii_field_dd60aac);
    private static final IiiiIiiII_Class237 I_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.17, 0.85, 0.29, 0.99);
    private static final IiiiIiiII_Class237 i_field_dd60aac = IiiiIiiII_Class237.I_method_ae57f375(0.31, 0.87, 0.43, 0.94);
    private final IiiiIiIii_Class236 Ii_field_dc7facc = new IiiiIiIii_Class236(350L, I_field_dd60aac);
    private boolean I_field_5a = false;
    private Vec3d i_field_5bba0d50 = Vec3d.ZERO;
    private iiIIiIIii_Class404 i_field_32e13e6c = iiIIiIIii_Class404.I_field_32e13e6c;
    private final IiIIIiII_Class69<SendPacketEvent> I_field_3d936f41 = sendPacketEvent -> {
        if (this.i_field_ba20ca4c.i_method_9b12da03() && !this.iII_method_7ae38683() && sendPacketEvent.getPacket() instanceof PlayerMoveC2SPacket) {
            sendPacketEvent.cancel();
        }
    };
    private final IiIIIiII_Class69<HudRenderEvent> i_field_3d936f41 = hudRenderEvent -> {
        if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            Vec3d vec3d = this.I_method_a0ada979();
            int n = (int)vec3d.x - (int)this.I_field_5bba0d50.x;
            int n2 = (int)vec3d.y - (int)this.I_field_5bba0d50.y;
            int n3 = (int)vec3d.z - (int)this.I_field_5bba0d50.z;
            String string = "X: " + n + " Y: " + n2 + " Z: " + n3;
            IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(8.0f);
            hudRenderEvent.getContext().drawText(iIiIIi_Class10, Text.of((String)string), I_field_73c6d26c.I_method_804ee20f() / 2.0f - iIiIIi_Class10.I_method_2c375926(string) / 2.0f, I_field_73c6d26c.i_method_805d6def() / 2.0f - 20.0f);
        }
    };
    private final IiIIIiII_Class69<RotateCameraEvent> II_field_3d936f41 = rotateCameraEvent -> {
        this.I_field_32e13e6c.I_method_7616dd81(this.I_field_32e13e6c.I_method_14534e0f() + rotateCameraEvent.getDeltaYaw());
        this.I_field_32e13e6c.i_method_77d9cda1(MathHelper.clamp((float)(this.I_field_32e13e6c.i_method_1461d9ef() + rotateCameraEvent.getDeltaPitch()), (float)-90.0f, (float)90.0f));
        rotateCameraEvent.cancel();
    };
    private final IiIIIiII_Class69<InputEvent> Ii_field_3d936f41 = IiIIIiII_Class69.I_method_aec3ff5f(150, inputEvent -> {
        float f = this.I_field_73178e8c.Ii_method_a20abcd2();
        if (inputEvent.getForward() != 0.0f || inputEvent.getStrafe() != 0.0f) {
            double d = IiiiiiiII_Class253.I_method_2edb44cf(this.I_field_32e13e6c.I_method_14534e0f() + 90.0f, inputEvent.getForward(), inputEvent.getStrafe());
            float f2 = (float)Math.cos(d);
            float f3 = (float)Math.sin(d);
            this.I_field_44 += (double)(f2 *= f);
            this.II_field_44 += (double)(f3 *= f);
        }
        if (inputEvent.isJump()) {
            this.i_field_44 += (double)this.I_field_73178e8c.Ii_method_a20abcd2();
        } else if (inputEvent.isSneak()) {
            this.i_field_44 -= (double)this.I_field_73178e8c.Ii_method_a20abcd2();
        }
        inputEvent.setForward(0.0f);
        inputEvent.setStrafe(0.0f);
        inputEvent.setJump(false);
        inputEvent.setSneak(false);
    });

    public FreeCameraModule() {
        this.Iii_method_4619ee9f();
    }

    @Compile(obfuscation=4)
    private void Iii_method_4619ee9f() {
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.free_cam.speed").Ii_method_4e0e6b54(1.0f).i_method_65e2aff7(15.0f).I_method_c8c9a7d7(0.1f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(3.0f);
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.free_cam.display_coords");
        this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.free_cam.freeze").I_method_decd82b5();
        this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.free_cam.animation").I_method_decd82b5();
    }

    public Vec3d I_method_a0ada979() {
        return new Vec3d((double)this.I_field_dc7facc.I_method_edd6dd11((float)this.I_field_44), (double)this.i_field_dc7facc.I_method_edd6dd11((float)this.i_field_44), (double)this.II_field_dc7facc.I_method_edd6dd11((float)this.II_field_44));
    }

    public boolean IiI_method_460b62c3() {
        return this.isEnabled() || this.I_field_5a;
    }

    public float I_method_17c71a2f() {
        return MathHelper.clamp((float)this.Ii_field_dc7facc.I_method_6ac4da6f(), (float)0.0f, (float)1.0f);
    }

    public boolean Iii_method_4619eea3() {
        return this.IiI_method_460b62c3() && this.Ii_field_dc7facc.I_method_6ac4da6f() < 1.0f;
    }

    private Vec3d i_method_a17c753b(float f) {
        if (FreeCameraModule.I_field_3a9bda27.player == null) {
            return Vec3d.ZERO;
        }
        return FreeCameraModule.I_field_3a9bda27.player.getCameraPosVec(f);
    }

    private static float I_method_c59b911(float f, float f2, float f3) {
        float f4 = MathHelper.wrapDegrees((float)(f3 - f2));
        return f2 + f4 * f;
    }

    public void IiI_method_460b62bf() {
        if (this.I_field_5a && this.Ii_field_dc7facc.I_method_6ac4da83() && this.Ii_field_dc7facc.I_method_6ac4da6f() <= 0.001f) {
            this.I_field_5a = false;
            if (this.I_field_dbf4bfd5 != null) {
                FreeCameraModule.I_field_3a9bda27.options.setPerspective(this.I_field_dbf4bfd5);
                this.I_field_dbf4bfd5 = null;
            }
        }
    }

    public Vec3d I_method_c6647d1b(float f) {
        Vec3d vec3d = this.i_method_a17c753b(f);
        Vec3d vec3d2 = new Vec3d((double)this.I_field_dc7facc.I_method_edd6dd11((float)this.I_field_44), (double)this.i_field_dc7facc.I_method_edd6dd11((float)this.i_field_44), (double)this.II_field_dc7facc.I_method_edd6dd11((float)this.II_field_44));
        if (this.I_field_5a) {
            float f2 = this.Ii_field_dc7facc.I_method_edd6dd11(0.0f);
            return this.i_field_5bba0d50.lerp(vec3d, (double)(1.0f - f2));
        }
        float f3 = this.Ii_field_dc7facc.I_method_edd6dd11(1.0f);
        return vec3d.lerp(vec3d2, (double)f3);
    }

    public iiIIiIIii_Class404 I_method_4e394bb7(float f) {
        if (FreeCameraModule.I_field_3a9bda27.player == null) {
            return this.I_field_32e13e6c;
        }
        float f2 = MathHelper.lerp((float)f, (float)FreeCameraModule.I_field_3a9bda27.player.prevYaw, (float)FreeCameraModule.I_field_3a9bda27.player.getYaw());
        float f3 = MathHelper.lerp((float)f, (float)FreeCameraModule.I_field_3a9bda27.player.prevPitch, (float)FreeCameraModule.I_field_3a9bda27.player.getPitch());
        float f4 = this.Ii_field_dc7facc.I_method_6ac4da6f();
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = this.I_field_5a ? this.i_field_32e13e6c : new iiIIiIIii_Class404(f2, f3);
        iiIIiIIii_Class404 iiIIiIIii_Class4043 = this.I_field_5a ? new iiIIiIIii_Class404(f2, f3) : this.I_field_32e13e6c;
        float f5 = this.I_field_5a ? 1.0f - f4 : f4;
        float f6 = FreeCameraModule.I_method_c59b911(f5, iiIIiIIii_Class4042.I_method_14534e0f(), iiIIiIIii_Class4043.I_method_14534e0f());
        float f7 = MathHelper.lerp((float)f5, (float)iiIIiIIii_Class4042.i_method_1461d9ef(), (float)iiIIiIIii_Class4043.i_method_1461d9ef());
        return new iiIIiIIii_Class404(f6, f7);
    }

    private boolean iII_method_7ae38683() {
        return iiIiiIiIi_Class438.I_method_1047da03() && iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7d4e6203();
    }

    @Override
    public final void II_method_6642fd22() {
        FreeCameraModule.I_field_3a9bda27.options.setPerspective(Perspective.THIRD_PERSON_BACK);
        if (this.iII_method_7ae38683()) {
            this.I_field_5bba0d50 = FreeCameraModule.I_field_3a9bda27.player.getPos();
        } else if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            FreeCameraModule.I_field_3a9bda27.player.setVelocity(Vec3d.ZERO);
            FreeCameraModule.I_field_3a9bda27.player.setPosition(this.I_field_5bba0d50);
            if (FreeCameraModule.I_field_3a9bda27.player.input != null) {
                FreeCameraModule.I_field_3a9bda27.player.input.movementForward = 0.0f;
                FreeCameraModule.I_field_3a9bda27.player.input.movementSideways = 0.0f;
            }
        }
        super.II_method_6642fd22();
    }

    @Override
    public final void onEnable() {
        this.I_field_44 = FreeCameraModule.I_field_3a9bda27.player.getX();
        this.i_field_44 = FreeCameraModule.I_field_3a9bda27.player.getEyeY();
        this.II_field_44 = FreeCameraModule.I_field_3a9bda27.player.getZ();
        this.I_field_5bba0d50 = FreeCameraModule.I_field_3a9bda27.player.getPos();
        this.I_field_dc7facc.I_method_edd6dd21((float)this.I_field_44);
        this.i_field_dc7facc.I_method_edd6dd21((float)this.i_field_44);
        this.II_field_dc7facc.I_method_edd6dd21((float)this.II_field_44);
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = RockstarClient.getInstance().I_method_58785402().I_method_fb1d7ad5();
        this.I_field_32e13e6c = new iiIIiIIii_Class404(iiIIiIIii_Class4042.I_method_14534e0f(), MathHelper.clamp((float)iiIIiIIii_Class4042.i_method_1461d9ef(), (float)-90.0f, (float)90.0f));
        if (!this.I_field_5a) {
            this.I_field_dbf4bfd5 = FreeCameraModule.I_field_3a9bda27.options.getPerspective();
            if (this.I_field_dbf4bfd5 == null) {
                this.I_field_dbf4bfd5 = Perspective.FIRST_PERSON;
            }
        }
        this.I_field_5a = false;
        if (this.II_field_ba20ca4c.i_method_9b12da03()) {
            this.Ii_field_dc7facc.I_method_df2f9087(I_field_dd60aac);
            this.Ii_field_dc7facc.I_method_edd6ec25(350L);
            if (this.Ii_field_dc7facc.I_method_6ac4da6f() <= 0.0f) {
                this.Ii_field_dc7facc.I_method_edd6dd21(0.0f);
            }
        } else {
            this.Ii_field_dc7facc.I_method_edd6dd21(1.0f);
        }
    }

    @Override
    public final void onDisable() {
        if (!this.II_field_ba20ca4c.i_method_9b12da03()) {
            this.Ii_field_dc7facc.I_method_edd6dd21(0.0f);
            this.I_field_5a = false;
            if (this.I_field_dbf4bfd5 != null) {
                FreeCameraModule.I_field_3a9bda27.options.setPerspective(this.I_field_dbf4bfd5);
                this.I_field_dbf4bfd5 = null;
            }
            return;
        }
        this.I_field_5a = true;
        this.Ii_field_dc7facc.I_method_df2f9087(i_field_dd60aac);
        this.i_field_5bba0d50 = new Vec3d((double)this.I_field_dc7facc.I_method_6ac4da6f(), (double)this.i_field_dc7facc.I_method_6ac4da6f(), (double)this.II_field_dc7facc.I_method_6ac4da6f());
        this.i_field_32e13e6c = new iiIIiIIii_Class404(this.I_field_32e13e6c.I_method_14534e0f(), this.I_field_32e13e6c.i_method_1461d9ef());
        double d = this.i_field_5bba0d50.distanceTo(this.i_method_a17c753b(1.0f));
        long l = (long)MathHelper.clamp((double)(150.0 + d * 25.0), (double)180.0, (double)700.0);
        this.Ii_field_dc7facc.I_method_edd6ec25(l);
    }

    @Generated
    public Vec3d i_method_44a62d59() {
        return this.I_field_5bba0d50;
    }

    @Generated
    public iiIIiIIii_Class404 I_method_a5535715() {
        return this.I_field_32e13e6c;
    }
}

