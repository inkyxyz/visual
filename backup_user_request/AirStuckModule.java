package rockstar.client;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.EventMotion;
import pyrock.events.player.InputEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Air Stuck", category=ModuleCategory.MOVEMENT)
public class AirStuckModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private BooleanSetting I_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private BooleanSetting i_field_ba20ca4c;
    private BooleanSetting II_field_ba20ca4c;
    private double I_field_44 = Double.NaN;
    private boolean I_field_5a;
    private Vec3d I_field_5bba0d50 = Vec3d.ZERO;
    private Vec3d i_field_5bba0d50 = Vec3d.ZERO;
    private boolean i_field_5a;
    private final Queue<Packet<?>> I_field_f2700bf6 = new ConcurrentLinkedQueue();
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private boolean II_field_5a;
    private final IiIIIiII_Class69<InputEvent> I_field_3d936f41 = inputEvent -> {
        if (AirStuckModule.I_field_3a9bda27.player == null || !this.i_field_500d0627.isSelected() && !this.II_field_500d0627.isSelected()) {
            return;
        }
        inputEvent.setForward(0.0f);
        inputEvent.setStrafe(0.0f);
        inputEvent.setJump(false);
        inputEvent.setSneak(false);
        inputEvent.setSprint(false);
    };
    private final IiIIIiII_Class69<EventMotion> i_field_3d936f41 = eventMotion -> {
        if (!this.I_field_500d0627.isSelected() || !this.I_field_5a || AirStuckModule.I_field_3a9bda27.player == null) {
            return;
        }
        eventMotion.setX(this.I_field_5bba0d50.x);
        eventMotion.setY(this.I_field_5bba0d50.y);
        eventMotion.setZ(this.I_field_5bba0d50.z);
        eventMotion.setOnGround(false);
        AirStuckModule.I_field_3a9bda27.player.fallDistance = 0.0f;
    };
    private final IiIIIiII_Class69<SendPacketEvent> II_field_3d936f41 = sendPacketEvent -> {
        PlayerActionC2SPacket playerActionC2SPacket;
        boolean bl;
        if (AirStuckModule.I_field_3a9bda27.player == null || this.i_field_5a) {
            return;
        }
        if (this.II_field_500d0627.isSelected()) {
            if (!(sendPacketEvent.getPacket() instanceof PlayerMoveC2SPacket)) {
                this.I_field_f2700bf6.add(sendPacketEvent.getPacket());
            }
            sendPacketEvent.cancel();
            return;
        }
        if (this.i_field_500d0627.isSelected()) {
            if (sendPacketEvent.getPacket() instanceof PlayerMoveC2SPacket) {
                sendPacketEvent.cancel();
            }
            return;
        }
        if (!this.I_field_5a) {
            return;
        }
        if (sendPacketEvent.getPacket() instanceof PlayerMoveC2SPacket) {
            sendPacketEvent.cancel();
            return;
        }
        Packet<?> packet = sendPacketEvent.getPacket();
        boolean bl2 = bl = packet instanceof PlayerActionC2SPacket && (playerActionC2SPacket = (PlayerActionC2SPacket)packet).getAction() == PlayerActionC2SPacket.Action.RELEASE_USE_ITEM;
        if (sendPacketEvent.getPacket() instanceof PlayerInteractItemC2SPacket || bl) {
            this.i_field_5a = true;
            try {
                AirStuckModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.LookAndOnGround(AirStuckModule.I_field_3a9bda27.player.getYaw(), AirStuckModule.I_field_3a9bda27.player.getPitch(), false, AirStuckModule.I_field_3a9bda27.player.horizontalCollision));
            }
            finally {
                this.i_field_5a = false;
            }
        }
    };
    private final IiIIIiII_Class69<WorldChangeEvent> Ii_field_3d936f41 = worldChangeEvent -> {
        this.I_field_f2700bf6.clear();
        this.II_field_5a = false;
        this.disable();
    };

    public AirStuckModule() {
        this.IiI_method_ce7a820c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_ce7a820c() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.air_stuck.mode");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.air_stuck.mode.normal");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.air_stuck.mode.reallyworld");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.air_stuck.mode.funtime");
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.air_stuck.change_aura_distance");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.air_stuck.aura_distance", () -> !this.I_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(2.0f).i_method_65e2aff7(6.0f).II_method_b0f56334(0.1f).Ii_method_4e0e6b54(3.0f).I_method_bfc3b958(f -> " %s".formatted(IiIiIIII_Class81.I_method_f25a980a("block")) + iIIIIiIiI_Class267.i_method_c309455f(f));
        this.i_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.air_stuck.catch_moment", () -> !this.I_field_500d0627.isSelected()).I_method_decd82b5();
        this.II_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.air_stuck.fall_check", () -> !this.II_field_500d0627.isSelected()).I_method_decd82b5();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.I_field_5a = false;
        this.I_field_5bba0d50 = Vec3d.ZERO;
        this.I_field_44 = Double.NaN;
        this.i_field_5bba0d50 = Vec3d.ZERO;
        this.I_field_f2700bf6.clear();
        this.I_field_991c1e8c.I_method_23e11e3f();
        this.II_field_5a = false;
        if (AirStuckModule.I_field_3a9bda27.player == null) {
            return;
        }
        if (this.II_field_500d0627.isSelected()) {
            if (this.II_field_ba20ca4c.i_method_9b12da03() && AirStuckModule.I_field_3a9bda27.player.isOnGround()) {
                iIIIIIIii_Class260.II_method_e8fd4864((Text)Text.literal((String)IiIiIIII_Class81.I_method_f25a980a("modules.messages.air_stuck.air_required")));
                this.disable();
                return;
            }
            this.i_field_5bba0d50 = AirStuckModule.I_field_3a9bda27.player.getVelocity();
            AirStuckModule.I_field_3a9bda27.player.setNoGravity(true);
            this.II_field_5a = true;
            return;
        }
        if (this.i_field_500d0627.isSelected()) {
            this.i_field_5bba0d50 = AirStuckModule.I_field_3a9bda27.player.getVelocity();
            AirStuckModule.I_field_3a9bda27.player.setNoGravity(true);
            return;
        }
        if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            this.I_field_44 = AirStuckModule.I_field_3a9bda27.player.isOnGround() ? Double.NaN : AirStuckModule.I_field_3a9bda27.player.getY();
            return;
        }
        this.I_field_44 = AirStuckModule.I_field_3a9bda27.player.getY();
        this.Iii_method_ce890dec();
    }

    @Override
    public void onDisable() {
        if (AirStuckModule.I_field_3a9bda27.player != null) {
            Packet<?> packet;
            if (this.II_field_5a) {
                AirStuckModule.I_field_3a9bda27.player.setVelocity(this.i_field_5bba0d50);
            } else if (this.i_field_500d0627.isSelected() && !AirStuckModule.I_field_3a9bda27.player.isOnGround()) {
                AirStuckModule.I_field_3a9bda27.player.setVelocity(this.i_field_5bba0d50);
            }
            if (this.II_field_5a || this.i_field_500d0627.isSelected()) {
                AirStuckModule.I_field_3a9bda27.player.setNoGravity(false);
            }
            while ((packet = this.I_field_f2700bf6.poll()) != null) {
                if (I_field_3a9bda27.getNetworkHandler() == null) continue;
                I_field_3a9bda27.getNetworkHandler().sendPacket(packet);
            }
        } else {
            this.I_field_f2700bf6.clear();
        }
        this.I_field_5a = false;
        this.I_field_44 = Double.NaN;
        this.I_field_5bba0d50 = Vec3d.ZERO;
        this.i_field_5bba0d50 = Vec3d.ZERO;
        this.II_field_5a = false;
        super.onDisable();
    }

    public float I_method_541fa8bc() {
        return this.isEnabled() && this.I_field_ba20ca4c.i_method_9b12da03() ? this.I_field_73178e8c.Ii_method_a20abcd2() : 0.0f;
    }

    @Override
    public void II_method_6642fd22() {
        if (AirStuckModule.I_field_3a9bda27.player == null) {
            this.I_field_5a = false;
            this.I_field_44 = Double.NaN;
            super.II_method_6642fd22();
            return;
        }
        if (AirStuckModule.I_field_3a9bda27.player.isDead()) {
            this.disable();
            return;
        }
        if (this.II_field_500d0627.isSelected()) {
            if (this.I_field_991c1e8c.I_method_58432069(28000L)) {
                iIIIIIIii_Class260.II_method_e8fd4864((Text)Text.literal((String)IiIiIIII_Class81.I_method_f25a980a("modules.messages.air_stuck.timeout")));
                this.disable();
                return;
            }
            AirStuckModule.I_field_3a9bda27.player.setVelocity(Vec3d.ZERO);
            AirStuckModule.I_field_3a9bda27.player.setNoGravity(true);
            AirStuckModule.I_field_3a9bda27.player.fallDistance = 0.0f;
            super.II_method_6642fd22();
            return;
        }
        if (this.i_field_500d0627.isSelected()) {
            AirStuckModule.I_field_3a9bda27.player.setVelocity(Vec3d.ZERO);
            AirStuckModule.I_field_3a9bda27.player.setNoGravity(true);
            AirStuckModule.I_field_3a9bda27.player.fallDistance = 0.0f;
            super.II_method_6642fd22();
            return;
        }
        if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            double d = AirStuckModule.I_field_3a9bda27.player.getY();
            if (AirStuckModule.I_field_3a9bda27.player.isOnGround()) {
                this.I_field_44 = Double.NaN;
                this.I_field_5a = false;
            } else if (!this.I_field_5a) {
                if (Double.isNaN(this.I_field_44)) {
                    this.I_field_44 = d;
                } else if (d > this.I_field_44) {
                    this.I_field_44 = d;
                } else if (d < this.I_field_44) {
                    this.Iii_method_ce890dec();
                }
            }
        }
        if (this.I_field_5a) {
            AirStuckModule.I_field_3a9bda27.player.setVelocity(Vec3d.ZERO);
            AirStuckModule.I_field_3a9bda27.player.setPosition(this.I_field_5bba0d50);
            AirStuckModule.I_field_3a9bda27.player.fallDistance = 0.0f;
            if (AirStuckModule.I_field_3a9bda27.player.input != null) {
                AirStuckModule.I_field_3a9bda27.player.input.movementForward = 0.0f;
                AirStuckModule.I_field_3a9bda27.player.input.movementSideways = 0.0f;
            }
        }
        super.II_method_6642fd22();
    }

    private void Iii_method_ce890dec() {
        if (AirStuckModule.I_field_3a9bda27.player == null) {
            return;
        }
        this.I_field_5a = true;
        this.I_field_5bba0d50 = AirStuckModule.I_field_3a9bda27.player.getPos();
        this.I_field_44 = AirStuckModule.I_field_3a9bda27.player.getY();
    }
}

