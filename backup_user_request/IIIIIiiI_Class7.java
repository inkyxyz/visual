package rockstar.client;

import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IIIIiIII_Class9;
import rockstar.client.iiiiiii_Class128;

public class IIIIIiiI_Class7
implements IIIIiIII_Class9 {
    private final String I_field_523beb0a;
    private final double I_field_44;
    private long I_field_4a;

    public IIIIIiiI_Class7(String string, double d) {
        this.I_field_523beb0a = string;
        this.I_field_44 = d;
    }

    @Override
    public void I_method_f2de637a(iiiiiii_Class128 iiiiiii_Class1282) {
        PlayerEntity playerEntity = this.I_method_a5da879f();
        if (iiiiiii_Class1282 == null || playerEntity == null || playerEntity.isRemoved()) {
            iiiiiii_Class1282.Iii_method_c77508df();
            return;
        }
        Vec3d vec3d = playerEntity.getPos();
        iiiiiii_Class1282.I_method_b644c79f(vec3d.x, vec3d.y + (double)playerEntity.getStandingEyeHeight(), vec3d.z);
        if (iiiiiii_Class1282.i_method_3794d139(vec3d) > this.I_field_44) {
            iiiiiii_Class1282.I_method_331eac73(vec3d, this.I_field_44 * 0.8);
            return;
        }
        iiiiiii_Class1282.Iii_method_c77508df();
        long l = System.currentTimeMillis();
        if (l - this.I_field_4a >= iiiiiii_Class1282.I_method_e08ecf78().I_method_907c0c0()) {
            iiiiiii_Class1282.I_method_c0c879e7((Entity)playerEntity);
            this.I_field_4a = l;
        }
    }

    private PlayerEntity I_method_a5da879f() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null || this.I_field_523beb0a == null || this.I_field_523beb0a.isBlank()) {
            return null;
        }
        for (PlayerEntity playerEntity : minecraftClient.world.getPlayers()) {
            if (!playerEntity.getName().getString().equalsIgnoreCase(this.I_field_523beb0a)) continue;
            return playerEntity;
        }
        return null;
    }

    @Override
    public String I_method_dcc0dd54() {
        return "Attack " + this.I_field_523beb0a;
    }

    @Generated
    public String i_method_6fdf8d74() {
        return this.I_field_523beb0a;
    }

    @Generated
    public double I_method_ce9248ba() {
        return this.I_field_44;
    }

    @Generated
    public long I_method_ce9248c0() {
        return this.I_field_4a;
    }
}

