package rockstar.client;

import lombok.Generated;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.text.Text;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIIiII_Class101;
import rockstar.client.IiiIIiIi_Class102;
import rockstar.client.IiiIIiii_Class104;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIiIIiii_Class424;

public class IiiIiIII_Class105
implements iIIiIIiIi_Class294 {
    private static IiiIiIII_Class105 I_field_dc0f3ba1;
    private final IiiIIiii_Class104 I_field_da5b5361 = new IiiIIiii_Class104();
    private boolean I_field_5a;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = receivePacketEvent -> {
        if (this.I_field_da5b5361.i_method_9806ec90()) {
            return;
        }
        Packet<?> packet = receivePacketEvent.getPacket();
        if (packet instanceof GameMessageS2CPacket) {
            GameMessageS2CPacket gameMessageS2CPacket = (GameMessageS2CPacket)packet;
            this.I_field_da5b5361.I_method_1fdf3776(gameMessageS2CPacket.content().getString());
        }
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41 = clientPlayerTickEvent -> {
        if (IiiIiIII_Class105.I_field_3a9bda27.player == null || IiiIiIII_Class105.I_field_3a9bda27.world == null) {
            return;
        }
        if (this.I_field_da5b5361.i_method_9806ec90()) {
            return;
        }
        this.I_field_da5b5361.I_method_97f860ac();
        if (this.I_field_da5b5361.i_method_9806ec90()) {
            this.I_field_5a = true;
        }
    };

    private IiiIiIII_Class105() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    public static IiiIiIII_Class105 I_method_f24c7cb() {
        if (I_field_dc0f3ba1 == null) {
            I_field_dc0f3ba1 = new IiiIiIII_Class105();
        }
        return I_field_dc0f3ba1;
    }

    public boolean I_method_50fe28f0() {
        return !this.I_field_da5b5361.i_method_9806ec90();
    }

    public boolean i_method_510cb4d0() {
        boolean bl = this.I_field_5a;
        this.I_field_5a = false;
        return bl;
    }

    public double I_method_89b6fa4(String string) {
        return this.I_field_da5b5361.I_method_1fdf3764(string);
    }

    public boolean II_method_ced5ebf9() {
        if (IiiIIiIi_Class102.I_method_2a0b303b().isEmpty()) {
            iIIIIIIii_Class260.i_method_70898627(Text.of((String)"\u0421\u043f\u0438\u0441\u043e\u043a \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432 \u043f\u0443\u0441\u0442!"));
            return false;
        }
        if (this.I_method_50fe28f0()) {
            iIIIIIIii_Class260.i_method_70898627(Text.of((String)"\u041f\u0430\u0440\u0441\u0438\u043d\u0433 \u0443\u0436\u0435 \u0438\u0434\u0451\u0442."));
            return false;
        }
        this.I_field_5a = false;
        this.I_field_991c1e8c.I_method_23e11e3f();
        this.I_field_da5b5361.I_method_3848159d(IiiIIiIi_Class102.I_method_2a0b303b());
        return this.I_method_50fe28f0();
    }

    public boolean Ii_method_cee477d9() {
        if (!IiiIIiII_Class101.i_method_c4a47090()) {
            this.I_field_991c1e8c.I_method_23e11e3f();
            return false;
        }
        if (this.I_method_50fe28f0()) {
            return false;
        }
        if (IiiIIiIi_Class102.I_method_2a0b303b().isEmpty()) {
            return false;
        }
        if (!this.I_field_991c1e8c.I_method_58432069(IiiIIiII_Class101.II_method_ce35a829())) {
            return false;
        }
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)"\u0410\u0432\u0442\u043e\u043f\u0430\u0440\u0441: \u043e\u0431\u043d\u043e\u0432\u043b\u044f\u044e \u0446\u0435\u043d\u044b \u0440\u044b\u043d\u043a\u0430\u2026"));
        return this.II_method_ced5ebf9();
    }

    public long I_method_50fe28e0() {
        if (this.I_method_50fe28f0()) {
            return 0L;
        }
        return Math.max(0L, IiiIIiII_Class101.II_method_ce35a829() - this.I_field_991c1e8c.I_method_23e11e33());
    }

    @Generated
    public IiiIIiii_Class104 I_method_d70df8b() {
        return this.I_field_da5b5361;
    }
}

