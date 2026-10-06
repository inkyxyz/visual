package rockstar.client;

import net.minecraft.client.network.ClientPlayerEntity;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIiIIII_Class465;

public class iiiIiIiii_Class472
extends iiiIiIIII_Class465 {
    public iiiIiIiii_Class472(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIiIIi_Class458 iiiIIiIIi_Class4583) {
        super(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583);
    }

    @Override
    protected double i_method_373409cd() {
        return 1.0;
    }

    @Override
    public boolean I_method_37257e03() {
        return false;
    }

    @Override
    public boolean i_method_373409e3() {
        return false;
    }

    @Override
    public boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 iiiIIIiIi_Class4542) {
        double d;
        int n = this.i_field_fa2e3e6c.i_method_6d2ed9f2() - this.I_field_fa2e3e6c.i_method_6d2ed9f2();
        if (n > 0 || n < -1) {
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
        if ((d = d2 - d3) <= 0.62 || d > 1.3) {
            return false;
        }
        this.I_method_3ca01ff(d2, d3);
        return iiiIIIiIi_Class4542.I_method_7085e723(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.II_method_36f86d15(), this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.II_method_36f86d15(), d2 + 0.05, d2 + 1.8);
    }

    @Override
    public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
        double d;
        double d2;
        ClientPlayerEntity clientPlayerEntity = iiiIiIiii_Class472.I_method_855d7990();
        if (clientPlayerEntity == null) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        double d3 = clientPlayerEntity.getY();
        if (this.i_method_af4d9243(0.45) && d3 <= this.II_field_44 + 0.15 && (clientPlayerEntity.isOnGround() || clientPlayerEntity.isTouchingWater())) {
            return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
        }
        if (d3 < this.II_field_44 - 1.2 && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.isClimbing()) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiIiii_Class472.I_method_20116ef5();
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        if (clientPlayerEntity.isOnGround() && d3 > this.II_field_44 + 0.5) {
            this.i_method_3a6515df((double)this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5, (double)this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
            this.I_method_d724943a(iiIiiiiii_Class4482, iiiIiIIII_Class465.Nested1_33b73880.i_field_86e7ae07);
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        float f = this.i_method_373409cf();
        if (!Float.isNaN(f)) {
            iiiIiIiii_Class472.I_method_3caf23f(f, 0.0f);
        }
        if ((d2 = this.i_method_3a6515cd(clientPlayerEntity.getX(), clientPlayerEntity.getZ())) < (d = this.Ii_method_ada7c510()) - 0.25) {
            this.I_method_d724943a(iiIiiiiii_Class4482, iiiIiIIII_Class465.Nested1_33b73880.i_field_86e7ae07);
        } else if (d2 > d + 0.25) {
            this.I_method_d724943a(iiIiiiiii_Class4482, iiiIiIIII_Class465.Nested1_33b73880.Ii_field_86e7ae07);
        } else {
            this.I_method_d724943a(iiIiiiiii_Class4482, iiiIiIIII_Class465.Nested1_33b73880.II_field_86e7ae07);
        }
        return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
    }

    @Override
    public void I_method_37257dff() {
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiIiii_Class472.I_method_20116ef5();
        iiIiiiiii_Class4482.I_method_7e07d875(false);
        iiIiiiiii_Class4482.i_method_7fcac895(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
    }
}

