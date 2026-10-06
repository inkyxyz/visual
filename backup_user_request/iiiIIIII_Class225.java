package rockstar.client;

import lombok.Generated;
import net.minecraft.SharedConstants;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import rockstar.client.ModeSetting;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.iiIIiiIII_Class409;
import rockstar.client.iiiIIIIi_Class226;
import rockstar.client.iiiIIiII_Class229;
import ua.mintantileak.spk.Compile;

public class iiiIIIII_Class225
extends iiiIIIIi_Class226 {
    private static final int I_field_49 = 755;
    private static final int i_field_49 = 765;
    private iiIIiIIii_Class404 I_field_32e13e6c = iiIIiIIii_Class404.I_field_32e13e6c;
    private int II_field_49 = -1;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private boolean II_field_5a;

    public iiiIIIII_Class225(ModeSetting iIiiiiiII_Class125) {
        super(iIiiiiiII_Class125, "ReallyWorld");
    }

    @Override
    @Compile(obfuscation=1)
    public void rotate(iiIIiIiII_Class405 iiIIiIiII_Class4052, float f, boolean bl, boolean bl2, iiIIiIIIi_Class402 iiIIiIIIi_Class4022, LivingEntity livingEntity) {
        iiIIiIIii_Class404 iiIIiIIii_Class4042;
        if (!this.i_method_98dfa4d0()) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)"\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0432\u0435\u0440\u0441\u0438\u044e \u043e\u0442 1.17 \u0434\u043e 1.20.4"));
            this.aura().disable();
            this.i_field_5a = false;
            this.II_method_8160fbf5();
            return;
        }
        this.I_field_32e13e6c = iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_a2bb2af5(livingEntity, this.aura());
        this.i_field_5a = this.i_method_f90fe855(livingEntity);
        if (this.i_field_5a) {
            this.I_method_b643919a(iiIIiIiII_Class4052);
            this.i_method_98dfa4cc();
            return;
        }
        this.II_method_8160fbf5();
        iiIIiIiII_Class4052.I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class4022, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.II_field_32efc66c);
    }

    @Override
    public boolean canAttack() {
        LivingEntity livingEntity;
        LivingEntity livingEntity2;
        Entity entity = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815();
        LivingEntity livingEntity3 = livingEntity2 = entity instanceof LivingEntity ? (livingEntity = (LivingEntity)entity) : null;
        if (iiiIIIII_Class225.I_field_3a9bda27.player == null || iiiIIIII_Class225.I_field_3a9bda27.world == null || livingEntity2 == null) {
            this.II_method_8160fbf5();
            return false;
        }
        this.i_field_5a = this.i_method_f90fe855(livingEntity2);
        if (!this.i_field_5a) {
            this.II_method_8160fbf5();
            return true;
        }
        if (this.I_field_5a && this.II_field_49 == livingEntity2.getId()) {
            if (this.I_method_d8f10035(livingEntity2)) {
                this.I_method_98d118ec();
                return true;
            }
            this.I_method_d8f10031(livingEntity2);
            return false;
        }
        this.I_method_d8f10031(livingEntity2);
        return false;
    }

    @Override
    public void attack() {
        this.II_method_8160fbf5();
    }

    @Override
    public void targetNull() {
        this.i_field_5a = false;
        this.II_method_8160fbf5();
    }

    public boolean I_method_98d118f0() {
        return this.i_field_5a;
    }

    public boolean I_method_d8f10035(LivingEntity livingEntity) {
        return this.i_field_5a && (iIIiiiiiI_Class319.I_method_9b00cfe4(this.aura().I_method_af0f42().Ii_method_a20abcd2(), this.I_field_32e13e6c.I_method_14534e0f(), this.I_field_32e13e6c.i_method_1461d9ef(), (Entity)iiiIIIII_Class225.I_field_3a9bda27.player, (Entity)livingEntity, this.aura().I_method_ca3480b()) || !this.aura().iI_method_fafed1ab().i_method_9b12da03() || this.aura().I_method_ca34beb().I_method_746a540b() != null && this.aura().I_method_ca34beb().I_method_cb91c89f() > 1);
    }

    private boolean i_method_f90fe855(LivingEntity livingEntity) {
        if (livingEntity == null || iiiIIIII_Class225.I_field_3a9bda27.player == null) {
            return false;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_a2bb2af5(livingEntity, this.aura());
        return !iIIiiiiiI_Class319.I_method_9b00cfe4(this.aura().I_method_af0f42().Ii_method_a20abcd2(), iiIIiIIii_Class4042.I_method_14534e0f(), iiIIiIIii_Class4042.i_method_1461d9ef(), (Entity)iiiIIIII_Class225.I_field_3a9bda27.player, (Entity)livingEntity, iiiIIiII_Class229.I_field_62e8b781);
    }

    private void I_method_d8f10031(LivingEntity livingEntity) {
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_a2bb2af5(livingEntity, this.aura());
        this.I_field_32e13e6c = iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_565091b5(RockstarClient.getInstance().I_method_58785402().I_method_fb1d7ad5(), iiIIiIIii_Class4042);
        this.II_field_49 = livingEntity.getId();
        this.I_field_5a = true;
        this.I_method_98d118ec();
    }

    private void I_method_98d118ec() {
        iiiIIIII_Class225.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.Full(iiiIIIII_Class225.I_field_3a9bda27.player.getX(), iiiIIIII_Class225.I_field_3a9bda27.player.getY(), iiiIIIII_Class225.I_field_3a9bda27.player.getZ(), this.I_field_32e13e6c.I_method_14534e0f(), this.I_field_32e13e6c.i_method_1461d9ef(), iiiIIIII_Class225.I_field_3a9bda27.player.isOnGround(), iiiIIIII_Class225.I_field_3a9bda27.player.horizontalCollision));
        iiiIIIII_Class225.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, this.I_field_32e13e6c.I_method_14534e0f(), this.I_field_32e13e6c.i_method_1461d9ef()));
    }

    private void i_method_98dfa4cc() {
        this.II_field_5a = !this.II_field_5a;
        iiiIIIII_Class225.I_field_3a9bda27.player.setYaw(iiiIIIII_Class225.I_field_3a9bda27.player.getYaw() + (this.II_field_5a ? 0.1f : -0.1f));
    }

    private void I_method_b643919a(iiIIiIiII_Class405 iiIIiIiII_Class4052) {
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiII_Class4052.I_method_fb1d7ad5();
        iiIIiIiII_Class4052.I_method_3c0f88c7(null);
        iiIIiIiII_Class4052.I_method_3c00fce7(iiIIiiIII_Class409.I_field_34a3b28c);
        iiIIiIiII_Class4052.i_method_3e2418e7(iiIIiIIii_Class4042);
        iiIIiIiII_Class4052.II_method_5aff43a4(iiIIiIIii_Class4042);
        iiIIiIiII_Class4052.Ii_method_f8184bc4(iiIIiIIii_Class4042);
    }

    private void II_method_8160fbf5() {
        this.I_field_5a = false;
        this.II_field_49 = -1;
    }

    private boolean i_method_98dfa4d0() {
        int n = this.I_method_98d118df();
        return n >= 755 && n <= 765;
    }

    private int I_method_98d118df() {
        Integer n = this.I_method_8dced513();
        if (n != null) {
            return n;
        }
        return SharedConstants.getGameVersion().getProtocolVersion();
    }

    private Integer I_method_8dced513() {
        try {
            Integer n;
            Class<?> clazz = Class.forName("com.viaversion.viafabricplus.ViaFabricPlus");
            Object object = clazz.getMethod("getImpl", new Class[0]).invoke(null, new Object[0]);
            Object object2 = object.getClass().getMethod("getTargetVersion", new Class[0]).invoke(object, new Object[0]);
            Object object3 = object2.getClass().getMethod("getVersion", new Class[0]).invoke(object2, new Object[0]);
            return object3 instanceof Integer ? (n = (Integer)object3) : null;
        }
        catch (LinkageError | ReflectiveOperationException | RuntimeException throwable) {
            return null;
        }
    }

    @Generated
    public iiIIiIIii_Class404 I_method_a7842782() {
        return this.I_field_32e13e6c;
    }
}

