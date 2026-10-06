package rockstar.client;

import moscow.rockstar.mixin.accessors.FireworkRocketEntityAccessor;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.EventOnTravelPost;
import pyrock.events.player.EventUpdatePostTick;
import pyrock.events.render.HudRenderEvent;
import rockstar.client.FreeCameraModule;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;

@ModuleInfo(name="Grim Glide", category=ModuleCategory.MOVEMENT, III_method_a89e5834="modules.descriptions.grim_glide")
public class GrimGlideModule
extends Module {
    private final ModeSetting I_field_bbe33e6c = new ModeSetting(this, "modules.settings.grim_glide.mode");
    private final ModeSetting.Nested1_42765c60 I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "RWFlag");
    private final ModeSetting.Nested1_42765c60 i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "ReallyWorld");
    private final ModeSetting.Nested1_42765c60 II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.grim_glide.mode.normal");
    private final BooleanSetting I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.grim_glide.climb").I_method_decd82b5();
    private final ModeSetting i_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.grim_glide.climb_trigger", () -> !this.I_field_ba20ca4c.i_method_9b12da03());
    private final ModeSetting.Nested1_42765c60 Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.grim_glide.climb_trigger.on_jump");
    private final ModeSetting.Nested1_42765c60 iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.grim_glide.climb_trigger.always");
    private boolean I_field_5a;
    private boolean i_field_5a;
    private int I_field_49;
    private boolean II_field_5a;
    private int i_field_49;
    private boolean Ii_field_5a;
    private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = receivePacketEvent -> {
        if (receivePacketEvent.getPacket() instanceof PlayerPositionLookS2CPacket) {
            this.I_field_49 = 2;
            this.II_field_5a = true;
        }
    };
    private final IiIIIiII_Class69<SendPacketEvent> i_field_3d936f41 = sendPacketEvent -> {
        if (!this.II_field_500d0627.isSelected() || this.Ii_field_5a || !(sendPacketEvent.getPacket() instanceof PlayerMoveC2SPacket)) {
            return;
        }
        if (GrimGlideModule.I_field_3a9bda27.player != null && GrimGlideModule.I_field_3a9bda27.player.isGliding() && this.I_field_49 == 0 && !this.II_field_5a) {
            this.Ii_field_5a = true;
            try {
                GrimGlideModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.OnGroundOnly(true, true));
            }
            finally {
                this.Ii_field_5a = false;
            }
            sendPacketEvent.cancel();
        }
        this.II_field_5a = false;
    };
    private final IiIIIiII_Class69<EventOnTravelPost> II_field_3d936f41 = eventOnTravelPost -> {
        double d;
        if (!this.II_field_500d0627.isSelected() || GrimGlideModule.I_field_3a9bda27.player == null || !GrimGlideModule.I_field_3a9bda27.player.isGliding()) {
            return;
        }
        Vec3d vec3d = GrimGlideModule.I_field_3a9bda27.player.getVelocity();
        Vec3d vec3d2 = GrimGlideModule.I_field_3a9bda27.player.getRotationVector();
        float f = GrimGlideModule.I_field_3a9bda27.player.getPitch() * ((float)Math.PI / 180);
        double d2 = Math.sqrt(vec3d2.x * vec3d2.x + vec3d2.z * vec3d2.z);
        double d3 = Math.sqrt(vec3d.x * vec3d.x + vec3d.z * vec3d.z);
        boolean bl = vec3d.y <= 0.0;
        double d4 = bl && GrimGlideModule.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.SLOW_FALLING) ? 0.01 : 0.08;
        double d5 = MathHelper.cos((float)f);
        d5 *= d5;
        vec3d = vec3d.add(0.0, d4 * (-1.0 + d5 * 0.75), 0.0);
        if (vec3d.y < 0.0 && d2 > 0.0) {
            d = vec3d.y * -0.1 * d5;
            vec3d = vec3d.add(vec3d2.x * d / d2, d, vec3d2.z * d / d2);
        }
        if (f < 0.0f && d2 > 0.0) {
            d = d3 * (double)(-MathHelper.sin((float)f)) * 0.04;
            vec3d = vec3d.add(-vec3d2.x * d / d2, d * 3.2, -vec3d2.z * d / d2);
        }
        if (d2 > 0.0) {
            vec3d = vec3d.add((vec3d2.x / d2 * d3 - vec3d.x) * 0.1, 0.0, (vec3d2.z / d2 * d3 - vec3d.z) * 0.1);
        }
        d = Math.toRadians(GrimGlideModule.I_field_3a9bda27.player.getYaw());
        double d6 = -Math.sin(d);
        double d7 = Math.cos(d);
        if (this.I_field_49 >= 1) {
            eventOnTravelPost.setOldVelocity(vec3d.multiply(0.99, (double)0.98f, 0.99).add(d6 * 0.09, 0.03, d7 * 0.09));
        } else {
            eventOnTravelPost.setOldVelocity(vec3d.multiply(0.3, 0.3, 0.3));
        }
    };
    private final IiIIIiII_Class69<HudRenderEvent> Ii_field_3d936f41 = hudRenderEvent -> {
        if (!this.i_field_500d0627.isSelected() || GrimGlideModule.I_field_3a9bda27.player == null || !GrimGlideModule.I_field_3a9bda27.player.isGliding()) {
            return;
        }
        if (!this.II_field_5a) {
            IiiiiiiII_Class253.I_method_7a0e1161(GrimGlideModule.I_field_3a9bda27.player.age % 2 == 0 ? 1.6f : 0.35f);
        } else {
            IiiiiiiII_Class253.I_method_1cb61e3f();
        }
    };
    private final IiIIIiII_Class69<EventUpdatePostTick> iI_field_3d936f41 = eventUpdatePostTick -> {
        if (!this.I_field_500d0627.isSelected() || GrimGlideModule.I_field_3a9bda27.player == null || GrimGlideModule.I_field_3a9bda27.world == null || !GrimGlideModule.I_field_3a9bda27.player.isGliding()) {
            return;
        }
        if (this.IiI_method_9eeab1f0() || this.Iii_method_9ef93dd0()) {
            return;
        }
        ++this.i_field_49;
        if (this.i_field_49 % 4 != 0) {
            return;
        }
        if (this.I_method_589a509a() > 49.0) {
            if (!this.I_field_5a) {
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)"\u0421\u0431\u0440\u043e\u0441\u044c \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c, \u043c\u0430\u043b\u044b\u0448\u043a\u0430"));
                this.I_field_5a = true;
            }
            return;
        }
        this.I_field_5a = false;
        float f = GrimGlideModule.I_field_3a9bda27.player.getYaw();
        double d = 0.01;
        double d2 = this.I_method_589a509a();
        float f2 = iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c) ? 50.0f : 64.0f;
        if (d2 >= (double)f2) {
            d = 0.0;
        }
        double d3 = -Math.sin(Math.toRadians(f)) * d;
        double d4 = Math.cos(Math.toRadians(f)) * d;
        GrimGlideModule.I_field_3a9bda27.player.setVelocity(d3 * (double)iIIiiiiiI_Class319.I_method_b56b22f(0.5, 1.15f), GrimGlideModule.I_field_3a9bda27.player.getVelocity().y - (double)0.01f, d4 * (double)iIIiiiiiI_Class319.I_method_b56b22f(0.5, 0.9f));
    };

    @Override
    public void II_method_6642fd22() {
        if (GrimGlideModule.I_field_3a9bda27.player == null || GrimGlideModule.I_field_3a9bda27.world == null) {
            return;
        }
        if (this.I_field_49 > 0) {
            --this.I_field_49;
        }
        if (!this.I_field_500d0627.isSelected()) {
            return;
        }
        if (!GrimGlideModule.I_field_3a9bda27.player.isGliding()) {
            this.i_field_5a = false;
            return;
        }
        if (!this.I_field_ba20ca4c.i_method_9b12da03()) {
            return;
        }
        if (this.Ii_field_500d0627.isSelected() && !GrimGlideModule.I_field_3a9bda27.options.jumpKey.isPressed()) {
            this.i_field_5a = false;
            return;
        }
        double d = this.I_method_589a509a();
        if (this.i_field_5a) {
            if (d >= (double)18.9f) {
                this.i_field_5a = false;
            }
        } else if (d < 14.0) {
            this.i_field_5a = true;
        }
        float f = !this.i_field_5a && GrimGlideModule.I_field_3a9bda27.player.getY() >= 320.0 ? 0.0f : (this.i_field_5a ? 60.0f : -60.0f);
        FreeCameraModule iIIiIIiii_Class40 = RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class);
        float f2 = iIIiIIiii_Class40 != null && iIIiIIiii_Class40.isEnabled() ? iIIiIIiii_Class40.I_method_a5535715().I_method_14534e0f() : GrimGlideModule.I_field_3a9bda27.player.getYaw();
        RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(new iiIIiIIii_Class404(f2, f), iiIIiIIIi_Class402.i_field_32e0c64c, 25.0f, 1.0f, 2.0f, iiIIiIiiI_Class407.I_field_32efc66c);
    }

    @Override
    public void onEnable() {
        this.I_field_5a = false;
        this.i_field_49 = 0;
        this.i_field_5a = false;
        this.I_field_49 = 0;
        this.II_field_5a = false;
        this.Ii_field_5a = false;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        IiiiiiiII_Class253.I_method_1cb61e3f();
        this.I_field_5a = false;
        this.i_field_49 = 0;
        this.i_field_5a = false;
        this.I_field_49 = 0;
        this.II_field_5a = false;
        this.Ii_field_5a = false;
        super.onDisable();
    }

    private double I_method_589a509a() {
        double d = GrimGlideModule.I_field_3a9bda27.player.getX() - GrimGlideModule.I_field_3a9bda27.player.prevX;
        double d2 = GrimGlideModule.I_field_3a9bda27.player.getZ() - GrimGlideModule.I_field_3a9bda27.player.prevZ;
        return (double)Math.round(Math.sqrt(d * d + d2 * d2) * 2000.0) / 100.0;
    }

    private boolean IiI_method_9eeab1f0() {
        return GrimGlideModule.I_field_3a9bda27.player.isUsingItem() && GrimGlideModule.I_field_3a9bda27.player.getActiveItem().isOf(Items.FIREWORK_ROCKET);
    }

    private boolean Iii_method_9ef93dd0() {
        return !GrimGlideModule.I_field_3a9bda27.world.getEntitiesByClass(FireworkRocketEntity.class, GrimGlideModule.I_field_3a9bda27.player.getBoundingBox().expand(2.0), fireworkRocketEntity -> ((FireworkRocketEntityAccessor)(Object)fireworkRocketEntity).getShooter() == GrimGlideModule.I_field_3a9bda27.player).isEmpty();
    }
}

