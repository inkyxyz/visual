package rockstar.client;

import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pyrock.events.network.SendPacketEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIiI_Class403;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.iiIIiiIII_Class409;
import rockstar.client.iiIIiiIIi_Class410;
import rockstar.client.iiIIiiIiI_Class411;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

public class iiIIiIiII_Class405
implements iIIiIIiIi_Class294 {
    private final iiIIiiIiI_Class411 I_field_34a42aac;
    private iiIIiIIii_Class404 I_field_32e13e6c = iiIIiIIii_Class404.I_field_32e13e6c;
    private final iiIIiIIii_Class404 i_field_32e13e6c = iiIIiIIii_Class404.I_field_32e13e6c;
    private iiIIiIIii_Class404 II_field_32e13e6c = iiIIiIIii_Class404.I_field_32e13e6c;
    private iiIIiIIii_Class404 Ii_field_32e13e6c = iiIIiIIii_Class404.I_field_32e13e6c;
    private iiIIiiIII_Class409 I_field_34a3b28c = iiIIiiIII_Class409.I_field_34a3b28c;
    @Nullable
    private iiIIiiIIi_Class410 I_field_34a3b66c;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    @Nullable
    private iiIIiIIii_Class404 iI_field_32e13e6c;
    private final IiIIIiII_Class69<SendPacketEvent> I_field_3d936f41 = sendPacketEvent -> {
        Packet<?> packet;
        if (this.I_method_3d166e03() || !((packet = sendPacketEvent.getPacket()) instanceof PlayerInteractItemC2SPacket)) {
            return;
        }
        PlayerInteractItemC2SPacket playerInteractItemC2SPacket = (PlayerInteractItemC2SPacket)packet;
        if (this.iI_field_32e13e6c == null) {
            this.iI_field_32e13e6c = new iiIIiIIii_Class404(this.I_field_32e13e6c.I_method_14534e0f(), this.I_field_32e13e6c.i_method_1461d9ef());
        }
        this.i_field_32e13e6c.I_method_7616dd81(this.iI_field_32e13e6c.I_method_14534e0f());
        this.i_field_32e13e6c.i_method_77d9cda1(this.iI_field_32e13e6c.i_method_1461d9ef());
        if (playerInteractItemC2SPacket.getYaw() != this.iI_field_32e13e6c.I_method_14534e0f() || playerInteractItemC2SPacket.getPitch() != this.iI_field_32e13e6c.i_method_1461d9ef()) {
            sendPacketEvent.setPacket((Packet<?>)new PlayerInteractItemC2SPacket(playerInteractItemC2SPacket.getHand(), playerInteractItemC2SPacket.getSequence(), this.iI_field_32e13e6c.I_method_14534e0f(), this.iI_field_32e13e6c.i_method_1461d9ef()));
        }
    };

    public iiIIiIiII_Class405(iiIIiiIiI_Class411 iiIIiiIiI_Class4112) {
        this.I_field_34a42aac = iiIIiiIiI_Class4112;
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    @Compile(obfuscation=1)
    public boolean I_method_3d166e03() {
        return this.I_field_34a3b28c == iiIIiiIII_Class409.I_field_34a3b28c;
    }

    @ApiStatus.Internal
    @Compile(obfuscation=1)
    public void I_method_3d166dff() {
        this.II_field_32e13e6c = this.I_field_32e13e6c;
        if (this.I_field_34a3b66c == null) {
            this.I_field_32e13e6c = this.I_method_fb1d7ad5();
            return;
        }
        if (this.I_field_991c1e8c.I_method_58432069(70L)) {
            iiIIiIIiI_Class403 iiIIiIIiI_Class4032 = this.I_field_34a3b66c.I_method_3844e715();
            if (iiIIiIIiI_Class4032 == iiIIiIIiI_Class403.II_field_32e13a8c) {
                float f = Math.clamp(this.I_field_32e13e6c.i_method_1461d9ef(), -90.0f, 90.0f);
                float f2 = iiIIiIiII_Class405.I_method_513fe22f(this.I_field_32e13e6c.I_method_14534e0f(), f);
                this.I_field_32e13e6c = new iiIIiIIii_Class404(f2, f);
                this.I_field_34a3b28c = iiIIiiIII_Class409.I_field_34a3b28c;
                this.I_field_34a3b66c = null;
                return;
            }
            if (iiIIiIIiI_Class4032 == iiIIiIIiI_Class403.I_field_32e13a8c) {
                this.I_field_32e13e6c = this.I_method_fb1d7ad5();
                this.I_field_34a3b28c = iiIIiiIII_Class409.I_field_34a3b28c;
                this.I_field_34a3b66c = null;
                return;
            }
            if (this.I_method_fb1d7ad5().I_method_24e31c97(this.I_field_32e13e6c) < Math.max(0.1f, iiIIiIiIi_Class406.I_method_73b181cf())) {
                iiIIiIiII_Class405.I_method_513fe22f(this.I_field_32e13e6c.I_method_14534e0f(), this.I_field_32e13e6c.i_method_1461d9ef());
                this.I_field_34a3b28c = iiIIiiIII_Class409.I_field_34a3b28c;
                this.I_field_34a3b66c = null;
            } else {
                iiIIiIIii_Class404 iiIIiIIii_Class4042;
                this.I_field_34a3b28c = iiIIiiIII_Class409.II_field_34a3b28c;
                iiIIiIiII_Class405.I_field_3a9bda27.player.setYaw(iiIIiIiIi_Class406.I_method_4d657e0f(iiIIiIiII_Class405.I_field_3a9bda27.player.getYaw(), iiIIiIiIi_Class406.Ii_method_cc8eecb2(this.I_field_32e13e6c.I_method_14534e0f(), iiIIiIiII_Class405.I_field_3a9bda27.player.getYaw())));
                iiIIiIIii_Class404 iiIIiIIii_Class4043 = iiIIiIIii_Class4042 = this.I_field_34a3b66c.I_method_385376d5() == null ? null : this.I_field_34a3b66c.I_method_385376d5().returnStep(this.I_field_32e13e6c, this.I_method_fb1d7ad5());
                if (iiIIiIIii_Class4042 == null) {
                    float f = 5.0f;
                    float f3 = 88.0f;
                    if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)) {
                        f3 = 45.0f;
                    }
                    iiIIiIIii_Class4042 = new iiIIiIIii_Class404(iiIIiIiII_Class405.I_method_d6bccd51(this.I_field_32e13e6c.I_method_14534e0f(), this.I_method_fb1d7ad5().I_method_14534e0f(), iIIiiiiiI_Class319.iI_method_330da892(f, f3)), iiIIiIiII_Class405.I_method_d6bccd51(this.I_field_32e13e6c.i_method_1461d9ef(), this.I_method_fb1d7ad5().i_method_1461d9ef(), iIIiiiiiI_Class319.iI_method_330da892(f, f3) / iIIiiiiiI_Class319.iI_method_330da892(1.9f, 2.2f)));
                }
                this.I_field_32e13e6c = iiIIiIiIi_Class406.I_method_565091b5(this.I_field_32e13e6c, iiIIiIIii_Class4042);
            }
            return;
        }
        this.I_field_34a3b28c = iiIIiiIII_Class409.i_field_34a3b28c;
        this.II_method_65c64942();
    }

    @Compile(obfuscation=1)
    public void I_method_65b7b9a1(float f) {
        if (iiIIiIiII_Class405.I_field_3a9bda27.player == null) {
            return;
        }
        float f2 = iIIiiiiiI_Class319.I_method_5f7ff5cf(this.II_field_32e13e6c.I_method_14534e0f(), this.I_field_32e13e6c.I_method_14534e0f(), f);
        float f3 = this.II_field_32e13e6c.i_method_1461d9ef() + (this.I_field_32e13e6c.i_method_1461d9ef() - this.II_field_32e13e6c.i_method_1461d9ef()) * f;
        if (f3 <= -85.0f) {
            // empty if block
        }
        this.Ii_field_32e13e6c = new iiIIiIIii_Class404(f2, f3);
        if (RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() != null) {
            // empty if block
        }
    }

    @Compile(obfuscation=1)
    public void I_method_1acbf705(iiIIiIIii_Class404 iiIIiIIii_Class4042, iiIIiIIIi_Class402 iiIIiIIIi_Class4022, float f, float f2, float f3, iiIIiIiiI_Class407 iiIIiIiiI_Class4072) {
        this.I_method_3eb39c6f(iiIIiIIii_Class4042, iiIIiIIIi_Class4022, f, f2, f3, iiIIiIiiI_Class4072, true);
    }

    @Compile(obfuscation=1)
    public void I_method_3eb39c6f(iiIIiIIii_Class404 iiIIiIIii_Class4042, iiIIiIIIi_Class402 iiIIiIIIi_Class4022, float f, float f2, float f3, iiIIiIiiI_Class407 iiIIiIiiI_Class4072, boolean bl) {
        int n = iiIIiIiiI_Class4072.I_method_d9ddd612();
        if (this.I_field_34a3b66c == null || this.I_field_34a3b66c.I_method_19c612() <= n || this.I_field_34a3b28c != iiIIiiIII_Class409.i_field_34a3b28c) {
            iiIIiIIii_Class4042.I_method_7616dd81(iiIIiIiIi_Class406.Ii_method_cc8eecb2(this.I_field_34a3b66c == null ? this.I_method_fb1d7ad5().I_method_14534e0f() : this.I_field_34a3b66c.I_method_3844eaf5().I_method_14534e0f(), iiIIiIIii_Class4042.I_method_14534e0f()));
            this.I_field_34a3b66c = new iiIIiiIIi_Class410(iiIIiIIii_Class4042, iiIIiIIIi_Class4022, f, f2, f3, n, bl);
            this.I_field_991c1e8c.I_method_23e11e3f();
            this.I_field_34a3b28c = iiIIiiIII_Class409.i_field_34a3b28c;
            this.II_method_65c64942();
        }
    }

    @Compile(obfuscation=1)
    public void I_method_71abce81(iiIIiIIii_Class404 iiIIiIIii_Class4042, iiIIiIIIi_Class402 iiIIiIIIi_Class4022, float f, float f2, float f3) {
        this.I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class4022, f, f2, f3, iiIIiIiiI_Class407.i_field_32efc66c);
    }

    @Compile(obfuscation=1)
    public void I_method_51b78ff(iiIIiIIii_Class404 iiIIiIIii_Class4042, iiIIiIiiI_Class407 iiIIiIiiI_Class4072) {
        this.I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.i_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class4072);
    }

    @Compile(obfuscation=1)
    public void I_method_a10b10c7(iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        this.I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.i_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.i_field_32efc66c);
    }

    @Compile(obfuscation=1)
    public void i_method_3d24f9df() {
        if (this.I_field_34a3b66c != null && this.I_field_34a3b28c == iiIIiiIII_Class409.i_field_34a3b28c) {
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
    }

    public static float I_method_513fe22f(float f, float f2) {
        if (iiIIiIiII_Class405.I_field_3a9bda27.player == null) {
            return f;
        }
        float f3 = iiIIiIiII_Class405.I_field_3a9bda27.player.getYaw() + MathHelper.wrapDegrees((float)(f - iiIIiIiII_Class405.I_field_3a9bda27.player.getYaw()));
        float f4 = MathHelper.clamp((float)f2, (float)-90.0f, (float)90.0f);
        iiIIiIiII_Class405.I_field_3a9bda27.player.setYaw(f3);
        iiIIiIiII_Class405.I_field_3a9bda27.player.setPitch(f4);
        iiIIiIiII_Class405.I_field_3a9bda27.player.prevYaw = f3;
        iiIIiIiII_Class405.I_field_3a9bda27.player.prevPitch = f4;
        return f3;
    }

    @Compile(obfuscation=1)
    public static float I_method_d6bccd51(float f, float f2, float f3) {
        float f4 = iiIIiIiIi_Class406.II_method_95f3d8d2(f, f2);
        if (Math.abs(f4) <= f3) {
            return f + f4;
        }
        return f + Math.signum(f4) * f3;
    }

    @Compile(obfuscation=1)
    private void II_method_65c64942() {
        if (this.I_field_34a3b66c == null) {
            return;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = new iiIIiIIii_Class404(iiIIiIiII_Class405.I_method_d6bccd51(this.I_field_32e13e6c.I_method_14534e0f(), this.I_field_34a3b66c.I_method_3844eaf5().I_method_14534e0f(), this.I_field_34a3b66c.I_method_19c60f()), iiIIiIiII_Class405.I_method_d6bccd51(this.I_field_32e13e6c.i_method_1461d9ef(), this.I_field_34a3b66c.I_method_3844eaf5().i_method_1461d9ef(), this.I_field_34a3b66c.i_method_2851ef()));
        this.I_field_32e13e6c = this.I_field_34a3b66c.I_method_19c623() ? iiIIiIiIi_Class406.I_method_565091b5(this.I_field_32e13e6c, iiIIiIIii_Class4042) : iiIIiIIii_Class4042;
    }

    @Compile(obfuscation=1)
    public void I_method_89dfc0dd(Entity entity, long l, long l2, long l3, iiIIiIiiI_Class407 iiIIiIiiI_Class4072, iiIIiIIIi_Class402 iiIIiIIIi_Class4022) {
        if (entity == null || iiIIiIiII_Class405.I_field_3a9bda27.player == null) {
            return;
        }
        double d = entity.getX();
        double d2 = entity.getY() + (double)entity.getEyeHeight(entity.getPose());
        double d3 = entity.getZ();
        double d4 = d - iiIIiIiII_Class405.I_field_3a9bda27.player.getX();
        double d5 = d2 - (iiIIiIiII_Class405.I_field_3a9bda27.player.getY() + (double)iiIIiIiII_Class405.I_field_3a9bda27.player.getEyeHeight(iiIIiIiII_Class405.I_field_3a9bda27.player.getPose()));
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiII_Class405.I_method_b9b8d2f5(d3, d4, d5);
        this.I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class4022, l, l2, l3, iiIIiIiiI_Class4072);
    }

    @Compile(obfuscation=1)
    @NotNull
    private static iiIIiIIii_Class404 I_method_b9b8d2f5(double d, double d2, double d3) {
        double d4 = d - iiIIiIiII_Class405.I_field_3a9bda27.player.getZ();
        double d5 = Math.sqrt(d2 * d2 + d4 * d4);
        float f = (float)Math.toDegrees(Math.atan2(d4, d2)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d3, d5)));
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = new iiIIiIIii_Class404(f, f2);
        return iiIIiIIii_Class4042;
    }

    @Compile(obfuscation=1)
    public iiIIiIIii_Class404 I_method_3567e654(LivingEntity livingEntity) {
        return new iiIIiIIii_Class404(livingEntity.getYaw(), livingEntity.getPitch());
    }

    @Compile(obfuscation=1)
    public iiIIiIIii_Class404 I_method_fb1d7ad5() {
        if (iiIIiIiII_Class405.I_field_3a9bda27.player == null) {
            return iiIIiIIii_Class404.I_field_32e13e6c;
        }
        return this.I_method_3567e654((LivingEntity)iiIIiIiII_Class405.I_field_3a9bda27.player);
    }

    @Compile(obfuscation=1)
    public iiIIiIIii_Class404 i_method_10b2eeb5() {
        return this.I_field_34a3b28c == iiIIiiIII_Class409.I_field_34a3b28c ? this.I_method_fb1d7ad5() : this.II_method_f098f858();
    }

    @Generated
    public iiIIiiIiI_Class411 I_method_fce06715() {
        return this.I_field_34a42aac;
    }

    @Generated
    public iiIIiIIii_Class404 II_method_f098f858() {
        return this.I_field_32e13e6c;
    }

    @Generated
    public iiIIiIIii_Class404 Ii_method_62e6c38() {
        return this.i_field_32e13e6c;
    }

    @Generated
    public iiIIiIIii_Class404 iI_method_8db20078() {
        return this.II_field_32e13e6c;
    }

    @Generated
    public iiIIiIIii_Class404 ii_method_a3477458() {
        return this.Ii_field_32e13e6c;
    }

    @Generated
    public iiIIiiIII_Class409 I_method_fcdfeef5() {
        return this.I_field_34a3b28c;
    }

    @Generated
    public iiIiIIiii_Class424 I_method_61585af5() {
        return this.I_field_991c1e8c;
    }

    @Generated
    public IiIIIiII_Class69<SendPacketEvent> I_method_861981b8() {
        return this.I_field_3d936f41;
    }

    @Generated
    public void i_method_3e2418e7(iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        this.I_field_32e13e6c = iiIIiIIii_Class4042;
    }

    @Generated
    public void II_method_5aff43a4(iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        this.II_field_32e13e6c = iiIIiIIii_Class4042;
    }

    @Generated
    public void Ii_method_f8184bc4(iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        this.Ii_field_32e13e6c = iiIIiIIii_Class4042;
    }

    @Generated
    public void I_method_3c00fce7(iiIIiiIII_Class409 iiIIiiIII_Class4092) {
        this.I_field_34a3b28c = iiIIiiIII_Class4092;
    }

    @Generated
    public void I_method_3c0f88c7(@Nullable iiIIiiIIi_Class410 iiIIiiIIi_Class4102) {
        this.I_field_34a3b66c = iiIIiiIIi_Class4102;
    }

    @Nullable
    @Generated
    public iiIIiiIIi_Class410 I_method_fcdff2d5() {
        return this.I_field_34a3b66c;
    }

    @Nullable
    @Generated
    public iiIIiIIii_Class404 III_method_aa8d2b35() {
        return this.iI_field_32e13e6c;
    }

    @Generated
    public void iI_method_61073f84(@Nullable iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        this.iI_field_32e13e6c = iiIIiIIii_Class4042;
    }
}

