package rockstar.client;

import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import rockstar.client.iIIiIIiIi_Class294;

public class iIIIIiIIi_Class266
implements iIIiIIiIi_Class294 {
    private double I_field_44;
    private double i_field_44;
    private int I_field_49;
    private int i_field_49;

    public double I_method_36867479(boolean bl, boolean bl2, boolean bl3, float f) {
        float f2;
        if (iIIIIiIIi_Class266.I_field_3a9bda27.player == null || iIIIIiIIi_Class266.I_field_3a9bda27.world == null) {
            return 0.0;
        }
        ClientPlayerEntity clientPlayerEntity = iIIIIiIIi_Class266.I_field_3a9bda27.player;
        boolean bl4 = clientPlayerEntity.isOnGround();
        boolean bl5 = clientPlayerEntity.getVelocity().y > 0.0;
        float f3 = this.I_method_6fe372d2(clientPlayerEntity);
        float f4 = this.i_method_1739a2f2(clientPlayerEntity);
        float f5 = f2 = clientPlayerEntity.hasStatusEffect(StatusEffects.JUMP_BOOST) && clientPlayerEntity.isUsingItem() ? 0.88f : 0.91f;
        if (bl4) {
            f2 = f4;
        }
        float f6 = 0.16277136f / (f2 * f2 * f2);
        float f7 = bl4 ? f3 * f6 - (bl5 ? 4.0f : 0.0133f) : (bl && bl2 && (bl3 || iIIIIiIIi_Class266.I_field_3a9bda27.options.jumpKey.isPressed()) ? f - 0.25f : 0.0255f);
        boolean bl6 = false;
        double d = this.I_field_44 + (double)f7;
        double d2 = 0.0;
        if (clientPlayerEntity.isUsingItem() && !bl5) {
            double d3 = this.I_field_44 + (double)(f7 * 0.25f);
            double d4 = clientPlayerEntity.getVelocity().y;
            if (d4 != 0.0 && Math.abs(d4) < 0.08) {
                d3 += 0.055;
            }
            if (d > (d2 = Math.max(0.043, d3))) {
                bl6 = true;
                ++this.i_field_49;
            } else {
                this.i_field_49 = Math.max(this.i_field_49 - 1, 0);
            }
        } else {
            this.i_field_49 = 0;
        }
        d = this.i_field_49 > 3 ? d2 - (clientPlayerEntity.hasStatusEffect(StatusEffects.JUMP_BOOST) && clientPlayerEntity.isUsingItem() ? 0.3 : 0.019) : Math.max(bl6 ? 0.0 : 0.25, d) - (this.I_field_49++ % 2 == 0 ? 0.001 : 0.002);
        this.i_field_44 = f2;
        return d;
    }

    public void I_method_2acfd1ff(double d) {
        this.I_field_44 = d * this.i_field_44;
    }

    public void I_method_a68ad21f() {
        this.I_field_44 = 0.0;
        this.i_field_44 = 0.0;
        this.I_field_49 = 0;
        this.i_field_49 = 0;
    }

    private float I_method_6fe372d2(ClientPlayerEntity clientPlayerEntity) {
        boolean bl = clientPlayerEntity.isSprinting();
        clientPlayerEntity.setSprinting(false);
        float f = (float)clientPlayerEntity.getAttributeValue(EntityAttributes.MOVEMENT_SPEED) * 1.3f;
        clientPlayerEntity.setSprinting(bl);
        return f;
    }

    private float i_method_1739a2f2(ClientPlayerEntity clientPlayerEntity) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        mutable.set(clientPlayerEntity.getX(), clientPlayerEntity.getBoundingBox().minY - 1.0, clientPlayerEntity.getZ());
        Block block = clientPlayerEntity.getWorld().getBlockState((BlockPos)mutable).getBlock();
        return block.getSlipperiness() * 0.91f;
    }

    @Generated
    public double I_method_a68ad20d() {
        return this.I_field_44;
    }

    @Generated
    public double i_method_a6995ded() {
        return this.i_field_44;
    }

    @Generated
    public int I_method_a68ad212() {
        return this.I_field_49;
    }

    @Generated
    public int i_method_a6995df2() {
        return this.i_field_49;
    }
}

