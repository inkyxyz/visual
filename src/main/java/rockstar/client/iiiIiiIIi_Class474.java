package rockstar.client;

import net.minecraft.client.network.ClientPlayerEntity;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIiIIII_Class465;

public class iiiIiiIIi_Class474
extends iiiIiIIII_Class465 {
    public static final int I_field_49 = 3;
    public static final int i_field_49 = 12;
    private boolean I_field_5a;

    public iiiIiiIIi_Class474(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIiIIi_Class458 iiiIIiIIi_Class4583) {
        super(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583);
    }

    @Override
    protected double i_method_373409cd() {
        int n = this.I_field_fa2e3e6c.i_method_6d2ed9f2() - this.i_field_fa2e3e6c.i_method_6d2ed9f2();
        return 1.2 + (double)n * 0.15;
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
        int n = this.I_field_fa2e3e6c.i_method_6d2ed9f2() - this.i_field_fa2e3e6c.i_method_6d2ed9f2();
        if (n < 2 || n > 12) {
            return false;
        }
        if (Math.abs(this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12()) + Math.abs(this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15()) != 1) {
            return false;
        }
        double d = iiiIIIiIi_Class4542.I_method_ca82d452(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2(), this.I_field_fa2e3e6c.II_method_36f86d15());
        if (Double.isNaN(d)) {
            d = this.I_field_fa2e3e6c.i_method_6d2ed9f2();
        }
        if (!iiiIIIiIi_Class4542.I_method_7085e723(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.II_method_36f86d15(), this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.II_method_36f86d15(), d + 0.05, d + 1.8)) {
            return false;
        }
        for (int i = this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 1; i > this.i_field_fa2e3e6c.i_method_6d2ed9f2(); --i) {
            if (iiiIIIiIi_Class4542.IIi_method_fdabf028(this.i_field_fa2e3e6c.I_method_6d204e12(), i, this.i_field_fa2e3e6c.II_method_36f86d15())) continue;
            return false;
        }
        this.I_field_5a = iiiIIIiIi_Class4542.II_method_1f35e205(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        if (this.I_field_5a) {
            if (iiiIIIiIi_Class4542.ii_method_b822e605(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() - 1, this.i_field_fa2e3e6c.II_method_36f86d15())) {
                return false;
            }
            this.I_method_3ca01ff(d, this.i_field_fa2e3e6c.i_method_6d2ed9f2());
            return true;
        }
        if (n > 3) {
            return false;
        }
        double d2 = iiiIIIiIi_Class4542.I_method_ca82d452(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        if (Double.isNaN(d2)) {
            return false;
        }
        this.I_method_3ca01ff(d, d2);
        return true;
    }

    @Override
    public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
        double d;
        double d2;
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = iiiIiiIIi_Class474.I_method_855d7990();
        if (clientPlayerEntity == null) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        double d3 = clientPlayerEntity.getY();
        double d4 = clientPlayerEntity.getX() - ((double)this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5);
        double d5 = clientPlayerEntity.getZ() - ((double)this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
        double d6 = Math.hypot(d4, d5);
        boolean bl2 = bl = clientPlayerEntity.isOnGround() || clientPlayerEntity.isTouchingWater();
        if (bl && d3 <= this.II_field_44 + 1.0 && d6 < 0.6) {
            return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
        }
        if (d3 < this.II_field_44 - 1.5 && !clientPlayerEntity.isTouchingWater()) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiiIIi_Class474.I_method_20116ef5();
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        iiIiiiiii_Class4482.ii_method_7d0c3a12(false);
        iiIiiiiii_Class4482.II_method_44ae3612(false);
        iiIiiiiii_Class4482.Ii_method_46712632(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
        if (clientPlayerEntity.isOnGround() && d3 > this.II_field_44 + 1.5) {
            this.i_method_3a6515df((double)this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5, (double)this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
            iiIiiiiii_Class4482.i_method_7fcac895(false);
            iiIiiiiii_Class4482.I_method_7e07d875(true);
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        float f = this.i_method_373409cf();
        if (!Float.isNaN(f)) {
            iiiIiiIIi_Class474.I_method_3caf23f(f, 0.0f);
        }
        if ((d2 = this.i_method_3a6515cd(clientPlayerEntity.getX(), clientPlayerEntity.getZ())) < (d = this.Ii_method_ada7c510()) - 0.25) {
            iiIiiiiii_Class4482.I_method_7e07d875(true);
            iiIiiiiii_Class4482.i_method_7fcac895(false);
        } else if (d2 > d + 0.3) {
            iiIiiiiii_Class4482.I_method_7e07d875(false);
            iiIiiiiii_Class4482.i_method_7fcac895(true);
        } else {
            iiIiiiiii_Class4482.I_method_7e07d875(false);
            iiIiiiiii_Class4482.i_method_7fcac895(false);
        }
        return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
    }

    @Override
    public void I_method_37257dff() {
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiiIIi_Class474.I_method_20116ef5();
        iiIiiiiii_Class4482.I_method_7e07d875(false);
        iiIiiiiii_Class4482.i_method_7fcac895(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
    }
}

