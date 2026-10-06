package rockstar.client;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.util.PlayerInput;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiIi_Class158;

public class iIiIIIII_Class161
implements iIIiiiIi_Class158 {
    private boolean I_field_5a = false;

    @Override
    public void I_method_4a82c8ac() {
        if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null && iIIiIIiIi_Class294.I_field_3a9bda27.player.isOnGround()) {
            PlayerInput playerInput = iIIiIIiIi_Class294.I_field_3a9bda27.player.input.playerInput;
            iIIiIIiIi_Class294.I_field_3a9bda27.player.input.playerInput = new PlayerInput(playerInput.forward(), playerInput.backward(), playerInput.left(), playerInput.right(), playerInput.jump(), playerInput.sneak(), playerInput.sprint());
            iIIiIIiIi_Class294.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerInputC2SPacket(iIIiIIiIi_Class294.I_field_3a9bda27.player.input.playerInput));
            iIIiIIiIi_Class294.I_field_3a9bda27.player.jump();
        }
        this.I_field_5a = true;
    }

    @Override
    public boolean I_method_4a82c8b0() {
        return this.I_field_5a;
    }

    @Override
    public void i_method_4a91548c() {
        this.I_field_5a = false;
    }
}

