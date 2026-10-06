package rockstar.client;

import net.minecraft.entity.Entity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.text.Text;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.ModeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIIIiIiI_Class139;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Leave", category=ModuleCategory.PLAYER)
public class AutoLeaveModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private SliderSetting I_field_73178e8c;
    private SliderSetting i_field_73178e8c;
    private SliderSetting II_field_73178e8c;
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
    private ModeSetting i_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 iI_field_500d0627;
    private ModeSetting.Nested1_42765c60 ii_field_500d0627;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private boolean I_field_5a;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (this.I_field_500d0627.isSelected()) {
            IiIIIiIiI_Class139 iiIIIiIiI_Class139 = new IiIIIiIiI_Class139.Nested1_a87537e0().I_method_1f3a928b(this.I_field_51de8227.isSelected()).II_method_9a5032be(this.i_field_51de8227.isSelected()).iI_method_3e48b69e(this.II_field_51de8227.isSelected()).ii_method_f94036be(this.Ii_field_51de8227.isSelected()).III_method_81ee98eb(this.ii_field_51de8227.isSelected()).Ii_method_5547b2de(this.iI_field_51de8227.isSelected()).I_method_7d0aed77(this.I_field_73178e8c.Ii_method_a20abcd2()).I_method_7ebd8d70();
            for (Entity entity : AutoLeaveModule.I_field_3a9bda27.world.getEntities()) {
                if (entity == null || entity == AutoLeaveModule.I_field_3a9bda27.player || AutoLeaveModule.I_field_3a9bda27.player == null || iIIIiiiII_Class285.I_field_5a || !iiIIIiIiI_Class139.I_method_b72bafcb(entity)) continue;
                if (this.Ii_field_500d0627.isSelected()) {
                    AutoLeaveModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("hub");
                } else if (this.iI_field_500d0627.isSelected()) {
                    AutoLeaveModule.I_field_3a9bda27.player.networkHandler.getConnection().disconnect(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("modules.auto_leave.near_player")));
                } else if (this.ii_field_500d0627.isSelected()) {
                    AutoLeaveModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("spawn");
                }
                this.toggle();
                break;
            }
        }
        if (this.i_field_500d0627.isSelected() && AutoLeaveModule.I_field_3a9bda27.player != null && AutoLeaveModule.I_field_3a9bda27.player.getHealth() + AutoLeaveModule.I_field_3a9bda27.player.getAbsorptionAmount() <= this.i_field_73178e8c.Ii_method_a20abcd2()) {
            if (this.Ii_field_500d0627.isSelected()) {
                AutoLeaveModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("hub");
            } else if (this.iI_field_500d0627.isSelected()) {
                AutoLeaveModule.I_field_3a9bda27.player.networkHandler.getConnection().disconnect(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("modules.auto_leave.low_health")));
            } else if (this.ii_field_500d0627.isSelected()) {
                AutoLeaveModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("spawn");
            }
            this.toggle();
        }
        if (!this.I_field_5a) {
            return;
        }
        if (this.I_field_991c1e8c.I_method_58432069((long)this.II_field_73178e8c.Ii_method_a20abcd2() * 1000L)) {
            AutoLeaveModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("an" + iIIIiiiII_Class285.i_field_49);
            this.I_field_5a = false;
        }
    };
    private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41 = receivePacketEvent -> {
        GameMessageS2CPacket gameMessageS2CPacket;
        Packet<?> packet = receivePacketEvent.getPacket();
        if (packet instanceof GameMessageS2CPacket && (gameMessageS2CPacket = (GameMessageS2CPacket)packet).content().getString().contains(IiIiIIII_Class81.I_method_f25a980a("modules.auto_leave.banned_word")) && this.II_field_500d0627.isSelected()) {
            AutoLeaveModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("hub");
            this.I_field_991c1e8c.I_method_23e11e3f();
            this.I_field_5a = true;
        }
    };

    public AutoLeaveModule() {
        this.IiI_method_875969f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_875969f() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_leave.leave");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_leave.leave.distance");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_leave.leave.health");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_leave.leave.ban");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.auto_leave.distance", () -> this.i_field_500d0627.isSelected() || this.II_field_500d0627.isSelected()).I_method_bfc3b958(f -> " %s".formatted(IiIiIIII_Class81.I_method_f25a980a("block")) + iIIIIiIiI_Class267.i_method_c309455f(f)).II_method_b0f56334(1.0f).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(150.0f).Ii_method_4e0e6b54(30.0f);
        this.i_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.auto_leave.health", () -> this.I_field_500d0627.isSelected() || this.II_field_500d0627.isSelected()).II_method_b0f56334(1.0f).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(20.0f).Ii_method_4e0e6b54(10.0f);
        this.II_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.auto_leave.delay", () -> !this.II_field_500d0627.isSelected() || this.I_field_500d0627.isSelected() || this.i_field_500d0627.isSelected()).I_method_d41e7abf(IiIiIIII_Class81.I_method_f25a980a("sec") + ".").II_method_b0f56334(1.0f).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(60.0f).Ii_method_4e0e6b54(40.0f);
        this.I_field_bbe3ba6c = new MultiSelectSetting((IIiiiIIiI_Class115)this, "targets", () -> this.i_field_500d0627.isSelected() || this.II_field_500d0627.isSelected());
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "players").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "mobs");
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "invisibles").select();
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "nakedPlayers").select();
        this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "rockUsers").select();
        this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "friends");
        this.i_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_leave.mode");
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_leave.mode.hub");
        this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_leave.mode.server");
        this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_leave.mode.spawn");
    }
}

