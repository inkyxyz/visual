package rockstar.client;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.world.Difficulty;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.SendPacketEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Timer", category=ModuleCategory.MOVEMENT, III_method_a89e5834="modules.descriptions.timer")
public class TimerModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private SliderSetting I_field_73178e8c;
    private BooleanSetting I_field_ba20ca4c;
    private float I_field_46 = 100.0f;
    private float i_field_46 = 100.0f;
    private long I_field_4a;
    private final IiIIIiII_Class69<SendPacketEvent> I_field_3d936f41 = sendPacketEvent -> {
        if (this.I_field_ba20ca4c.i_method_9b12da03() && this.I_field_500d0627.isSelected() && sendPacketEvent.getPacket() instanceof PlayerMoveC2SPacket) {
            if (System.currentTimeMillis() - this.I_field_4a < 1000L) {
                float f = (float)(0.05 - (double)((float)(System.currentTimeMillis() - this.I_field_4a) / 1000.0f)) * 400.0f;
                this.I_field_46 -= Math.max(0.0f, f);
            }
            if (IiiiiiiII_Class253.I_method_1cb61e43()) {
                this.I_field_46 += 0.5f;
            }
            this.I_field_46 = Math.max(0.0f, Math.min(100.0f, this.I_field_46));
            this.I_field_4a = System.currentTimeMillis();
        }
    };
    private final IiIIIiII_Class69<WorldChangeEvent> i_field_3d936f41 = worldChangeEvent -> {
        if (this.I_field_ba20ca4c.i_method_9b12da03() && this.i_field_500d0627.isSelected()) {
            this.I_field_46 += 7.0f;
        }
    };

    public TimerModule() {
        this.IiI_method_3f5b6e2c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_3f5b6e2c() {
        this.I_field_bbe33e6c = new ModeSetting(this, "\u0420\u0435\u0436\u0438\u043c");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "\u041e\u0431\u044b\u0447\u043d\u044b\u0439");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "VonTam");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.timer.speed", this.i_field_500d0627::isSelected).II_method_b0f56334(0.1f).I_method_c8c9a7d7(0.1f).i_method_65e2aff7(15.0f).Ii_method_4e0e6b54(1.0f);
        this.I_field_ba20ca4c = new BooleanSetting(this, "\u0423\u043c\u043d\u044b\u0439");
    }

    @Override
    public void II_method_6642fd22() {
        if (this.I_field_500d0627.isSelected()) {
            if (this.I_field_ba20ca4c.i_method_9b12da03()) {
                IiiiiiiII_Class253.I_method_7a0e1161(this.I_field_46 > 10.0f ? this.I_field_73178e8c.Ii_method_a20abcd2() : 1.0f);
            } else {
                IiiiiiiII_Class253.I_method_7a0e1161(this.I_field_73178e8c.Ii_method_a20abcd2());
            }
        } else {
            if (!this.I_field_ba20ca4c.i_method_9b12da03() || this.I_field_46 > 10.0f) {
                TimerModule.I_field_3a9bda27.player.setVelocity(TimerModule.I_field_3a9bda27.player.getVelocity().x * 1.05, TimerModule.I_field_3a9bda27.player.getVelocity().y * (TimerModule.I_field_3a9bda27.player.fallDistance > 0.0f ? 1.05 : 1.0), TimerModule.I_field_3a9bda27.player.getVelocity().z * (double)1.05f);
            }
            if (TimerModule.I_field_3a9bda27.world.getDifficulty() == Difficulty.EASY) {
                this.I_field_46 = 100.0f;
            }
            this.I_field_46 += 0.006f;
            this.I_field_46 -= 2.5f;
            this.I_field_46 = Math.clamp(this.I_field_46, 0.0f, 100.0f);
        }
        super.II_method_6642fd22();
    }

    @Override
    public void onDisable() {
        IiiiiiiII_Class253.I_method_1cb61e3f();
        super.onDisable();
    }
}

