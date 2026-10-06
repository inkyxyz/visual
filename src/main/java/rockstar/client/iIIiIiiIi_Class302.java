package rockstar.client;

import lombok.Generated;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiIii_Class316;

public final class iIIiIiiIi_Class302
implements iIIiIIiIi_Class294 {
    public static void I_method_fe0755c5(iIIiiiIii_Class316 iIIiiiIii_Class3162, Runnable runnable) {
        if (iIIiiiIii_Class3162 == null || runnable == null || iIIiIiiIi_Class302.I_field_3a9bda27.player == null || I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        int n = iIIiIiiIi_Class302.I_field_3a9bda27.player.getInventory().selectedSlot;
        if (iIIiiiIii_Class3162.II_method_b9cf08f5() == n) {
            runnable.run();
            return;
        }
        I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(iIIiiiIii_Class3162.II_method_b9cf08f5()));
        try {
            runnable.run();
        }
        finally {
            I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(n));
        }
    }

    @Generated
    private iIIiIiiIi_Class302() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

