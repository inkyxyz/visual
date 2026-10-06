package rockstar.client;

import net.minecraft.client.network.ClientPlayerEntity;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIiIIII_Class465;

public class iiiIiiIiI_Class475
extends iiiIiIIII_Class465 {
    private static final int I_field_49 = 40;
    private final int i_field_49;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private int II_field_49;
    private double Ii_field_44 = Double.NaN;

    public iiiIiiIiI_Class475(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIiIIi_Class458 iiiIIiIIi_Class4583) {
        super(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583);
        this.i_field_49 = (int)Math.round(this.Ii_method_ada7c510()) - 1;
    }

    @Override
    protected double i_method_373409cd() {
        return this.i_field_49 <= 1 ? 2.5 : 4.0;
    }

    @Override
    public boolean I_method_37257e03() {
        return false;
    }

    @Override
    public boolean i_method_373409e3() {
        return this.I_field_5a;
    }

    @Override
    public boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 iiiIIIiIi_Class4542) {
        int n;
        int n2;
        int n3;
        if (this.i_field_fa2e3e6c.i_method_6d2ed9f2() != this.I_field_fa2e3e6c.i_method_6d2ed9f2()) {
            return false;
        }
        int n4 = this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12();
        int n5 = this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15();
        if (n4 != 0 && n5 != 0) {
            return false;
        }
        int n6 = Math.abs(n4) + Math.abs(n5);
        if (n6 < 2 || n6 > 3) {
            return false;
        }
        double d = iiiIIIiIi_Class4542.I_method_ca82d452(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2(), this.I_field_fa2e3e6c.II_method_36f86d15());
        double d2 = iiiIIIiIi_Class4542.I_method_ca82d452(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        if (Double.isNaN(d) || Double.isNaN(d2)) {
            return false;
        }
        if (Math.abs(d2 - d) > 0.3) {
            return false;
        }
        int n7 = Integer.signum(n4);
        int n8 = Integer.signum(n5);
        for (n3 = 1; n3 < n6; ++n3) {
            n2 = this.I_field_fa2e3e6c.I_method_6d204e12() + n7 * n3;
            n = this.I_field_fa2e3e6c.II_method_36f86d15() + n8 * n3;
            if (iiiIIIiIi_Class4542.IiI_method_5d0a23e8(n2, this.I_field_fa2e3e6c.i_method_6d2ed9f2(), n)) {
                return false;
            }
            if (!iiiIIIiIi_Class4542.I_method_ca82d468(n2, this.I_field_fa2e3e6c.i_method_6d2ed9f2(), n)) {
                return false;
            }
            if (!iiiIIIiIi_Class4542.I_method_ca82d468(n2, this.I_field_fa2e3e6c.i_method_6d2ed9f2() + 1, n)) {
                return false;
            }
            for (int i = this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 1; i >= this.I_field_fa2e3e6c.i_method_6d2ed9f2() - 4; --i) {
                if (!iiiIIIiIi_Class4542.ii_method_b822e605(n2, i, n)) continue;
                return false;
            }
        }
        if (!iiiIIIiIi_Class4542.I_method_7085e723(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.II_method_36f86d15(), this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.II_method_36f86d15(), Math.max(d, d2) + 0.05, d + 2.1)) {
            return false;
        }
        n3 = this.i_field_fa2e3e6c.I_method_6d204e12() + n7;
        n2 = this.i_field_fa2e3e6c.II_method_36f86d15() + n8;
        int n9 = n = iiiIIIiIi_Class4542.IiI_method_5d0a23e8(n3, this.i_field_fa2e3e6c.i_method_6d2ed9f2(), n2) && Math.abs(iiiIIIiIi_Class4542.I_method_ca82d452(n3, this.i_field_fa2e3e6c.i_method_6d2ed9f2(), n2) - d2) <= 0.62 ? 1 : 0;
        if (this.i_field_49 >= 2 && n == 0) {
            return false;
        }
        this.I_field_5a = this.i_field_49 >= 2;
        this.I_method_3ca01ff(d, d2);
        return true;
    }

    @Override
    public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
        double d;
        ClientPlayerEntity clientPlayerEntity = iiiIiiIiI_Class475.I_method_855d7990();
        if (clientPlayerEntity == null) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        double d2 = clientPlayerEntity.getY();
        if (d2 < Math.min(this.i_field_44, this.II_field_44) - 1.5 && !clientPlayerEntity.isTouchingWater()) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        double d3 = this.Ii_method_ada7c510();
        double d4 = this.i_method_3a6515cd(clientPlayerEntity.getX(), clientPlayerEntity.getZ());
        if (clientPlayerEntity.isOnGround() && this.i_field_5a && d4 > d3 - 0.75 && Math.abs(d2 - this.II_field_44) < 0.7) {
            return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
        }
        this.i_method_3a6515df((double)this.i_field_fa2e3e6c.I_method_6d204e12() + 0.5, (double)this.i_field_fa2e3e6c.II_method_36f86d15() + 0.5);
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiiIiI_Class475.I_method_20116ef5();
        iiIiiiiii_Class4482.i_method_7fcac895(false);
        iiIiiiiii_Class4482.II_method_44ae3612(false);
        iiIiiiiii_Class4482.Ii_method_46712632(false);
        iiIiiiiii_Class4482.ii_method_7d0c3a12(false);
        if (!clientPlayerEntity.isOnGround()) {
            this.Ii_field_44 = Double.NaN;
            double d5 = d3 - d4;
            iiIiiiiii_Class4482.iI_method_7b4949f2(false);
            if (this.I_field_5a) {
                boolean bl = d5 > 0.4;
                iiIiiiiii_Class4482.I_method_7e07d875(bl);
                iiIiiiiii_Class4482.i_method_7fcac895(false);
                iiIiiiiii_Class4482.III_method_52d38c15(bl);
            } else {
                iiIiiiiii_Class4482.III_method_52d38c15(false);
                if (d5 > 1.0) {
                    iiIiiiiii_Class4482.I_method_7e07d875(true);
                    iiIiiiiii_Class4482.i_method_7fcac895(false);
                } else if (d5 > 0.35) {
                    iiIiiiiii_Class4482.I_method_7e07d875(false);
                    iiIiiiiii_Class4482.i_method_7fcac895(false);
                } else {
                    iiIiiiiii_Class4482.I_method_7e07d875(false);
                    iiIiiiiii_Class4482.i_method_7fcac895(true);
                }
            }
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        double d6 = this.I_method_3ca01ed(clientPlayerEntity.getX(), clientPlayerEntity.getZ());
        double d7 = Double.isNaN(this.Ii_field_44) ? this.II_method_ad993930() : d4 - this.Ii_field_44;
        this.Ii_field_44 = d4;
        if (d6 > 0.45 || d4 < -0.4) {
            this.i_method_3a6515df((double)this.I_field_fa2e3e6c.I_method_6d204e12() + 0.5, (double)this.I_field_fa2e3e6c.II_method_36f86d15() + 0.5);
            iiIiiiiii_Class4482.I_method_7e07d875(true);
            iiIiiiiii_Class4482.III_method_52d38c15(false);
            iiIiiiiii_Class4482.iI_method_7b4949f2(false);
            if (++this.II_field_49 >= 40) {
                return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
            }
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        double d8 = this.I_field_5a ? 0.18 : 0.11;
        double d9 = this.I_field_5a ? 10.0 : 0.24;
        double d10 = d = this.I_field_5a ? 0.25 : 0.1;
        if (d7 > d9 && d4 > -0.2) {
            this.I_method_d724943a(iiIiiiiii_Class4482, iiiIiIIII_Class465.Nested1_33b73880.II_field_86e7ae07);
            iiIiiiiii_Class4482.iI_method_7b4949f2(false);
            if (++this.II_field_49 >= 40) {
                return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
            }
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        if (d7 >= d8 && d7 <= d9 && d4 + d7 >= d && d4 >= d - 0.35) {
            iiIiiiiii_Class4482.I_method_7e07d875(true);
            iiIiiiiii_Class4482.III_method_52d38c15(this.I_field_5a);
            iiIiiiiii_Class4482.iI_method_7b4949f2(true);
            this.i_field_5a = true;
            this.II_field_49 = 0;
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        if (d4 > d + 0.1 && d7 < d8) {
            this.I_method_d724943a(iiIiiiiii_Class4482, iiiIiIIII_Class465.Nested1_33b73880.Ii_field_86e7ae07);
            iiIiiiiii_Class4482.iI_method_7b4949f2(false);
            if (++this.II_field_49 >= 40) {
                return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
            }
            return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
        }
        iiIiiiiii_Class4482.I_method_7e07d875(true);
        iiIiiiiii_Class4482.III_method_52d38c15(this.I_field_5a);
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        this.II_field_49 = 0;
        return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
    }

    @Override
    public void I_method_37257dff() {
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiiIiI_Class475.I_method_20116ef5();
        iiIiiiiii_Class4482.I_method_7e07d875(false);
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
        this.i_field_5a = false;
        this.II_field_49 = 0;
    }
}

