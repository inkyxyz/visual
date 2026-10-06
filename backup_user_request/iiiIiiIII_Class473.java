package rockstar.client;

import net.minecraft.client.network.ClientPlayerEntity;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIiIIII_Class465;

public class iiiIiiIII_Class473
extends iiiIiIIII_Class465 {
    private int I_field_49;
    private double Ii_field_44 = Double.NaN;

    public iiiIiiIII_Class473(iiiIIiIIi_Class458 iiiIIiIIi_Class4582, iiiIIiIIi_Class458 iiiIIiIIi_Class4583) {
        super(iiiIIiIIi_Class4582, iiiIIiIIi_Class4583);
    }

    @Override
    protected double i_method_373409cd() {
        return 1.4142;
    }

    @Override
    public boolean I_method_a7f2ac8b(iiiIIIiIi_Class454 iiiIIIiIi_Class4542) {
        boolean bl;
        if (this.i_field_fa2e3e6c.i_method_6d2ed9f2() != this.I_field_fa2e3e6c.i_method_6d2ed9f2()) {
            return false;
        }
        if (Math.abs(this.i_field_fa2e3e6c.I_method_6d204e12() - this.I_field_fa2e3e6c.I_method_6d204e12()) != 1 || Math.abs(this.i_field_fa2e3e6c.II_method_36f86d15() - this.I_field_fa2e3e6c.II_method_36f86d15()) != 1) {
            return false;
        }
        double d = iiiIIIiIi_Class4542.I_method_ca82d452(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.i_method_6d2ed9f2(), this.I_field_fa2e3e6c.II_method_36f86d15());
        double d2 = iiiIIIiIi_Class4542.I_method_ca82d452(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15());
        if (Double.isNaN(d) || Double.isNaN(d2)) {
            return false;
        }
        if (Math.abs(d2 - d) > 0.62) {
            return false;
        }
        boolean bl2 = iiiIIIiIi_Class4542.I_method_ca82d468(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.I_field_fa2e3e6c.II_method_36f86d15()) && iiiIIIiIi_Class4542.I_method_ca82d468(this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.I_field_fa2e3e6c.II_method_36f86d15());
        boolean bl3 = bl = iiiIIIiIi_Class4542.I_method_ca82d468(this.I_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2(), this.i_field_fa2e3e6c.II_method_36f86d15()) && iiiIIIiIi_Class4542.I_method_ca82d468(this.I_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.i_method_6d2ed9f2() + 1, this.i_field_fa2e3e6c.II_method_36f86d15());
        if (!bl2 || !bl) {
            return false;
        }
        this.I_method_3ca01ff(d, d2);
        double d3 = Math.max(d, d2);
        return iiiIIIiIi_Class4542.I_method_7085e723(this.I_field_fa2e3e6c.I_method_6d204e12(), this.I_field_fa2e3e6c.II_method_36f86d15(), this.i_field_fa2e3e6c.I_method_6d204e12(), this.i_field_fa2e3e6c.II_method_36f86d15(), d3 + 0.05, d3 + 1.8);
    }

    @Override
    public iiiIiIIII_Class465.Nested1_33b738a0 I_method_8cdd8810() {
        ClientPlayerEntity clientPlayerEntity = iiiIiiIII_Class473.I_method_855d7990();
        if (clientPlayerEntity == null) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        double d = clientPlayerEntity.getY();
        if (this.i_method_af4d9243(0.4) && Math.abs(d - this.II_field_44) < 0.7) {
            return iiiIiIIII_Class465.Nested1_33b738a0.i_field_86e7b1e7;
        }
        if (d < Math.min(this.i_field_44, this.II_field_44) - 1.2 && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.isClimbing()) {
            return iiiIiIIII_Class465.Nested1_33b738a0.II_field_86e7b1e7;
        }
        this.i_method_af4d923f(0.9);
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiiIII_Class473.I_method_20116ef5();
        iiIiiiiii_Class4482.iI_method_7b4949f2(false);
        double d2 = this.i_method_3a6515cd(clientPlayerEntity.getX(), clientPlayerEntity.getZ());
        double d3 = Double.isNaN(this.Ii_field_44) ? 1.0 : d2 - this.Ii_field_44;
        this.Ii_field_44 = d2;
        this.I_field_49 = clientPlayerEntity.horizontalCollision && clientPlayerEntity.isOnGround() && d3 < 0.01 ? ++this.I_field_49 : 0;
        if (this.I_field_2f065e4c != null && !this.I_field_2f065e4c.I_method_37257e03()) {
            this.I_method_d724943a(iiIiiiiii_Class4482, this.I_field_2f065e4c.i_method_373409e3() ? iiiIiIIII_Class465.Nested1_33b73880.I_field_86e7ae07 : iiiIiIIII_Class465.Nested1_33b73880.i_field_86e7ae07);
        } else {
            this.I_method_d724943a(iiIiiiiii_Class4482, iiiIiIIII_Class465.Nested1_33b73880.I_field_86e7ae07);
            this.I_method_42025ce7(iiIiiiiii_Class4482);
        }
        if (this.I_field_49 > 3) {
            this.i_method_df1b6507(iiIiiiiii_Class4482);
            if (this.I_field_49 % 7 == 0) {
                iiIiiiiii_Class4482.iI_method_7b4949f2(true);
            }
        }
        if (this.II_method_ad993946()) {
            iiIiiiiii_Class4482.iI_method_7b4949f2(true);
        }
        return iiiIiIIII_Class465.Nested1_33b738a0.I_field_86e7b1e7;
    }

    @Override
    public void I_method_37257dff() {
        this.I_field_49 = 0;
        this.Ii_field_44 = Double.NaN;
        iiIiiiiii_Class448 iiIiiiiii_Class4482 = iiiIiiIII_Class473.I_method_20116ef5();
        iiIiiiiii_Class4482.I_method_7e07d875(false);
        iiIiiiiii_Class4482.i_method_7fcac895(false);
        iiIiiiiii_Class4482.III_method_52d38c15(false);
        iiIiiiiii_Class4482.II_method_44ae3612(false);
        iiIiiiiii_Class4482.Ii_method_46712632(false);
    }
}

