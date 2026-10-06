package rockstar.client;

import lombok.Generated;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import rockstar.client.iIIiIIiIi_Class294;

public class iIIIiIiiI_Class279 {
    private final ClientPlayerEntity I_field_2a2f51e7;
    private double I_field_44;
    private double i_field_44;
    private double II_field_44;
    private double Ii_field_44;
    private double iI_field_44;
    private double ii_field_44;
    private final float I_field_46;
    private int I_field_49;

    public iIIIiIiiI_Class279(ClientPlayerEntity clientPlayerEntity, double d, double d2, double d3, double d4, double d5, double d6, float f) {
        this.I_field_2a2f51e7 = clientPlayerEntity;
        this.I_field_44 = d;
        this.i_field_44 = d2;
        this.II_field_44 = d3;
        this.Ii_field_44 = d4;
        this.iI_field_44 = d5;
        this.ii_field_44 = d6;
        this.I_field_46 = f;
        this.I_field_49 = 0;
    }

    public static iIIIiIiiI_Class279 I_method_5a6fa1f8(ClientPlayerEntity clientPlayerEntity) {
        return new iIIIiIiiI_Class279(clientPlayerEntity, clientPlayerEntity.getPos().getX(), clientPlayerEntity.getPos().getY(), clientPlayerEntity.getPos().getZ(), clientPlayerEntity.getVelocity().x, clientPlayerEntity.getVelocity().y, clientPlayerEntity.getVelocity().z, clientPlayerEntity.getYaw());
    }

    public boolean I_method_262421a5(float f) {
        double d = this.iI_field_44;
        d *= 0.98;
        return (d -= 0.08) <= (double)(-f);
    }

    public boolean I_method_9e608586(float f, int n) {
        double d = this.iI_field_44;
        for (int i = 0; i < n; ++i) {
            d *= 0.98;
            if (!((d -= 0.08) <= (double)(-f))) continue;
            return true;
        }
        return false;
    }

    public int I_method_2db0dd85(float f, int n, boolean bl) {
        float f2;
        int n2 = 0;
        if (bl && (f2 = iIIiIIiIi_Class294.I_field_3a9bda27.player.getAttackCooldownProgress(0.0f)) < 0.8f) {
            double d = iIIiIIiIi_Class294.I_field_3a9bda27.player.getAttributeValue(EntityAttributes.ATTACK_SPEED);
            float f3 = (float)(20.0 / d);
            n2 = (int)Math.ceil(f3 * (1.0f - f2));
        }
        double d = this.Ii_field_44;
        double d2 = this.iI_field_44;
        double d3 = this.ii_field_44;
        double d4 = this.I_field_44;
        double d5 = this.i_field_44;
        double d6 = this.II_field_44;
        for (int i = 0; i < n; ++i) {
            d4 += d;
            d5 += d2;
            d6 += d3;
            d2 -= 0.08;
            d *= 0.91;
            d2 *= 0.98;
            d3 *= 0.91;
            if (!(d2 <= (double)(-f)) || i < n2) continue;
            return i;
        }
        return n;
    }

    @Generated
    public iIIIiIiiI_Class279 I_method_96cee6d5(double d) {
        this.I_field_44 = d;
        return this;
    }

    @Generated
    public iIIIiIiiI_Class279 i_method_33e7eef5(double d) {
        this.i_field_44 = d;
        return this;
    }

    @Generated
    public iIIIiIiiI_Class279 II_method_d79b49b2(double d) {
        this.II_field_44 = d;
        return this;
    }

    @Generated
    public iIIIiIiiI_Class279 Ii_method_74b451d2(double d) {
        this.Ii_field_44 = d;
        return this;
    }

    @Generated
    public iIIIiIiiI_Class279 iI_method_dda34592(double d) {
        this.iI_field_44 = d;
        return this;
    }

    @Generated
    public iIIIiIiiI_Class279 ii_method_7abc4db2(double d) {
        this.ii_field_44 = d;
        return this;
    }

    @Generated
    public iIIIiIiiI_Class279 I_method_655e5d5a(int n) {
        this.I_field_49 = n;
        return this;
    }
}

