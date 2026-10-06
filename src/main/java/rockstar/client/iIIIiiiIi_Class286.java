package rockstar.client;

import java.util.Arrays;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.util.math.MathHelper;
import pyrock.events.network.ReceivePacketEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;

public class iIIIiiiIi_Class286 {
    private final float[] I_field_b4b = new float[20];
    private int I_field_49 = 0;
    private long I_field_4a = -1L;
    private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = receivePacketEvent -> {
        if (!(receivePacketEvent.getPacket() instanceof WorldTimeUpdateS2CPacket)) {
            return;
        }
        if (this.I_field_4a != -1L) {
            float f = (float)(System.nanoTime() - this.I_field_4a) / 1.0E9f;
            this.I_field_b4b[this.I_field_49 % this.I_field_b4b.length] = MathHelper.clamp((float)(20.0f / f), (float)0.0f, (float)20.0f);
            ++this.I_field_49;
        }
        this.I_field_4a = System.nanoTime();
    };

    public iIIIiiiIi_Class286() {
        Arrays.fill(this.I_field_b4b, 0.0f);
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    public float I_method_2bde91cf() {
        float f = 0.0f;
        float f2 = 0.0f;
        for (float f3 : this.I_field_b4b) {
            if (!(f3 > 0.0f)) continue;
            f2 += f3;
            f += 1.0f;
        }
        return MathHelper.clamp((float)(f2 / f), (float)0.0f, (float)20.0f);
    }
}

