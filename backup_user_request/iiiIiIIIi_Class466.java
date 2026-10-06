package rockstar.client;

import net.minecraft.client.network.ClientPlayerEntity;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIiIIII_Class465;

public class iiiIiIIIi_Class466
extends iiiIiIIII_Class465 {
    public iiiIiIIIi_Class466(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIiIIi_Class458 iiiIIiIIi_Class4583) {
        super(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583);
    }

    @Override
    protected double i_method_373409cd() {
        return 1.6;
    }

    @Override
    public int I_method_37257df2() {
        return 80;
    }

    @Override
    public boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 iiiIIIiIi_Class4542) {
        double d;
        int n = this.i_field_fa2e3e6c.i_method_6d2ed9f2() - this.I_field_fa2e3e6c.i_method_6d2ed9f2();
        if (n < 0 || n > 1) {
            return false;
        }
        if (Math.abs(this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12()) + Math.abs(this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15()) != 1) {
            return false;
        }
        double d2 = iiiIIIiIi_Class4542.I_method_ca82d452(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2(), this.I_field_fa2e3e6c.II_method_36f86d15());
        double d3 = iiiIIIiIi_Class4542.I_method_ca82d452(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        if (Double.isNaN(d3)) {
            return false;
        }
        if (Double.isNaN(d2)) {
            d2 = this.I_field_fa2e3e6c.i_method_6d2ed9f2();
        }
        if ((d = d3 - d2) <= 0.62 || d > 1.3) {
            return false;
        }
        this.I_method_3ca01ff(d2, d3);
        return iiiIIIiIi_Class4542.I_method_7085e723(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.II_method_36f86d15(), this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.II_method_36f86d15(), d3 + 0.05, d3 + 1.8);
    }

    @Override
    public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = iiiIiIIIi_Class466.I_method_855d7990();
        if (clientPlayerEntity == null) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        double d = clientPlayerEntity.getY();
        if (this.i_method_af4d9243(0.4) && d >= this.II_field_44 - 0.1) {
            return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
        }
        if (d < this.i_field_44 - 1.2 && !clientPlayerEntity.isClimbing() && !clientPlayerEntity.isTouchingWater()) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        double d2 = (double)this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5;
        double d3 = (double)this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5;
        double d4 = d2 - clientPlayerEntity.getX();
        double d5 = d3 - clientPlayerEntity.getZ();
        this.i_method_3a6515df(d2, d3);
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiIIIi_Class466.I_method_20116ef5();
        this.I_method_d724943a(iiIiiiiii_Class4482, iiiIiIIII_Class465.Nested1_33b73880.i_field_86e7ae07);
        boolean bl2 = bl = d < this.II_field_44 - 0.1;
        if (clientPlayerEntity.isTouchingWater()) {
            iiIiiiiii_Class4482.iI_method_7b4949f2(bl);
        } else {
            boolean bl3 = clientPlayerEntity.horizontalCollision || Math.hypot(d4, d5) < 1.05;
            iiIiiiiii_Class4482.iI_method_7b4949f2(bl && clientPlayerEntity.isOnGround() && bl3);
        }
        return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
    }

    @Override
    public void I_method_37257dff() {
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiIIIi_Class466.I_method_20116ef5();
        iiIiiiiii_Class4482.I_method_7e07d875(false);
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
    }
}

