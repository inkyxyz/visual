package rockstar.client;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;

public class IiiiiiiIi_Class254
extends OtherClientPlayerEntity {
    public static final String I_field_523beb0a = "13371337-1337-abcd-ef00-deadbeef1337";

    public IiiiiiiIi_Class254(ClientWorld clientWorld, GameProfile gameProfile) {
        super(clientWorld, gameProfile);
    }

    public void I_method_5351321f() {
        this.unsetRemoved();
        this.clientWorld.addEntity((Entity)this);
    }

    public void i_method_535fbdff() {
        this.clientWorld.removeEntity(this.getId(), Entity.RemovalReason.DISCARDED);
        this.onRemoved();
    }

    public void takeKnockback(double strength, double x, double z) {
    }
}

