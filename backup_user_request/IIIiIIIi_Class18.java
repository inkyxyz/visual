package rockstar.client;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import rockstar.client.IIIIIiIi_Class6;
import rockstar.client.iiiiiii_Class128;

public class IIIiIIIi_Class18
extends OtherClientPlayerEntity {
    public IIIiIIIi_Class18(ClientWorld clientWorld, GameProfile gameProfile) {
        super(clientWorld, gameProfile);
    }

    public void I_method_f56e7c8c() {
        this.unsetRemoved();
        this.clientWorld.addEntity((Entity)this);
    }

    public void i_method_f57d086c() {
        this.clientWorld.removeEntity(this.getId(), Entity.RemovalReason.DISCARDED);
        this.onRemoved();
    }

    public void I_method_aa0fe7ba(iiiiiii_Class128 iiiiiii_Class1282) {
        IIIIIiIi_Class6 iIIIIiIi_Class6 = iiiiiii_Class1282.I_method_e09ce338();
        this.refreshPositionAndAngles(iIIIIiIi_Class6.I_method_6865f47a(), iIIIIiIi_Class6.i_method_6874805a(), iIIIIiIi_Class6.II_method_a4679443(), iIIIIiIi_Class6.I_method_6865f47c(), iIIIIiIi_Class6.i_method_6874805c());
        this.setYaw(iIIIIiIi_Class6.I_method_6865f47c());
        this.setPitch(iIIIIiIi_Class6.i_method_6874805c());
        this.setHeadYaw(iIIIIiIi_Class6.I_method_6865f47c());
        this.setBodyYaw(iIIIIiIi_Class6.I_method_6865f47c());
        this.setOnGround(iIIIIiIi_Class6.III_method_e899edb0());
    }

    public boolean shouldRender(double distance) {
        return false;
    }
}

