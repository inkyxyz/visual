package rockstar.client;

import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IIIIiIII_Class9;
import rockstar.client.iiiiiii_Class128;

public class IIIIiIii_Class12
implements IIIIiIII_Class9 {
    private final String I_field_523beb0a;
    private final Entity I_field_77e0818c;
    private final double I_field_44;

    public IIIIiIii_Class12(String string, double d) {
        this.I_field_523beb0a = string;
        this.I_field_77e0818c = null;
        this.I_field_44 = d;
    }

    public IIIIiIii_Class12(Entity entity, double d) {
        this.I_field_523beb0a = entity == null ? null : entity.getName().getString();
        this.I_field_77e0818c = entity;
        this.I_field_44 = d;
    }

    @Override
    public void I_method_f2de637a(iiiiiii_Class128 iiiiiii_Class1282) {
        Entity entity = this.i_method_b19e0102();
        if (iiiiiii_Class1282 == null || entity == null || entity.isRemoved()) {
            iiiiiii_Class1282.Iii_method_c77508df();
            return;
        }
        Vec3d vec3d = entity.getPos();
        iiiiiii_Class1282.I_method_b644c79f(vec3d.x, vec3d.y + (double)entity.getStandingEyeHeight(), vec3d.z);
        if (iiiiiii_Class1282.i_method_3794d139(vec3d) > this.I_field_44) {
            iiiiiii_Class1282.I_method_331eac73(vec3d, this.I_field_44);
        } else {
            iiiiiii_Class1282.Iii_method_c77508df();
        }
    }

    private Entity i_method_b19e0102() {
        if (this.I_field_77e0818c != null && !this.I_field_77e0818c.isRemoved()) {
            return this.I_field_77e0818c;
        }
        if (this.I_field_523beb0a == null || this.I_field_523beb0a.isBlank()) {
            return null;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null) {
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
        return "Follow " + (this.I_field_523beb0a == null ? "target" : this.I_field_523beb0a);
    }

    @Generated
    public String i_method_6b337954() {
        return this.I_field_523beb0a;
    }

    @Generated
    public Entity I_method_ab960522() {
        return this.I_field_77e0818c;
    }

    @Generated
    public double I_method_9195a0da() {
        return this.I_field_44;
    }
}

