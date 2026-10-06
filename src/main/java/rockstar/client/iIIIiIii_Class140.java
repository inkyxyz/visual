package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIII_Class137;
import rockstar.client.iIIIiiII_Class141;
import rockstar.client.iIIiIIIii_Class292;
import rockstar.client.iIiiiIiII_Class373;

public class iIIIiIii_Class140
implements iIIIiiII_Class141 {
    private final String I_field_523beb0a;
    private final ItemStack I_field_f2735522;
    private final List<iIIIiiII_Class141> I_field_7865b31 = new ArrayList<iIIIiiII_Class141>();
    private boolean I_field_5a;
    private float I_field_46;
    private float i_field_46;
    private float II_field_46;
    private final iIIiIIIii_Class292 I_field_107fb28c = new iIIiIIIii_Class292();

    public iIIIiIii_Class140(String string, ItemStack itemStack) {
        this.I_field_523beb0a = string;
        this.I_field_f2735522 = itemStack;
    }

    public iIIIiIii_Class140(String string) {
        this(string, new ItemStack((ItemConvertible)Items.ENCHANTED_BOOK));
    }

    public void I_method_b6966fad(iIIIiiII_Class141 iIIIiiII_Class1412) {
        this.I_field_7865b31.add(iIIIiiII_Class1412);
    }

    @Override
    public float I_method_c52f08dc() {
        if (!this.I_field_5a) {
            return 20.0f;
        }
        float f = 0.0f;
        for (iIIIiiII_Class141 iIIIiiII_Class1412 : this.I_field_7865b31) {
            f += iIIIiiII_Class1412.I_method_c52f08dc();
        }
        return 20.0f + Math.min(f, 100.0f);
    }

    @Override
    public void I_method_bc6592c6(III iII, float f, float f2, float f3) {
        this.I_field_46 = f2;
        this.i_field_46 = f;
        this.II_field_46 = f3;
        this.i_method_739f86c6(iII, f, f2, f3);
        if (this.I_field_5a && !this.I_field_7865b31.isEmpty()) {
            float f4 = f2 + 23.0f;
            float f5 = 100.0f;
            float f6 = this.iI_method_dea997e5();
            this.I_field_107fb28c.i_method_95bee5ff(-(f6 - f5));
            this.I_field_107fb28c.I_method_575ab23f();
            float f7 = Math.min(f6, f5);
            iIiiiIiII_Class373.I_method_594a8a5f(f, f4, f3, f7);
            float f8 = f4 - (float)this.I_field_107fb28c.I_method_575ab22d();
            for (iIIIiiII_Class141 iIIIiiII_Class1412 : this.I_field_7865b31) {
                iIIIiiII_Class1412.I_method_bc6592c6(iII, f, f8, f3);
                f8 += iIIIiiII_Class1412.I_method_c52f08dc();
            }
            iIiiiIiII_Class373.I_method_ff80a1df();
        }
    }

    private void i_method_739f86c6(III iII, float f, float f2, float f3) {
        iII.drawRoundedRect(f, f2, f3, 20.0f, IIiii_Class8.I_method_893b2757(4.0f), IiiiiIIIi_Class242.Ii_method_a0f56f71());
        iII.getMatrices().push();
        iII.getMatrices().translate(0.0f, 0.0f, 200.0f);
        iII.drawBatchItem(this.I_field_f2735522, f + 4.0f, f2 + 4.0f, 0.75f);
        iII.getMatrices().pop();
        iII.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), this.I_field_523beb0a, f + 22.0f, f2 + 8.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
    }

    private float iI_method_dea997e5() {
        float f = 0.0f;
        for (iIIIiiII_Class141 iIIIiiII_Class1412 : this.I_field_7865b31) {
            f += iIIIiiII_Class1412.I_method_c52f08dc();
        }
        return f;
    }

    public void I_method_dcd810b2(double d) {
        if (this.I_field_5a) {
            this.I_field_107fb28c.I_method_93fbf5df(d);
        }
    }

    @Override
    public boolean I_method_dd6e4c7a(iIIIiIII_Class137 iIIIiIII_Class1372, double d, double d2, int n) {
        if (d2 < (double)(this.I_field_46 + 20.0f)) {
            this.I_field_5a = !this.I_field_5a;
            return true;
        }
        if (this.I_field_5a) {
            float f = this.I_field_46 + 20.0f - (float)this.I_field_107fb28c.I_method_575ab22d();
            for (iIIIiiII_Class141 iIIIiiII_Class1412 : this.I_field_7865b31) {
                if (d2 >= (double)f && d2 < (double)(f + iIIIiiII_Class1412.I_method_c52f08dc())) {
                    return iIIIiiII_Class1412.I_method_dd6e4c7a(iIIIiIII_Class1372, d, d2, n);
                }
                f += iIIIiiII_Class1412.I_method_c52f08dc();
            }
        }
        return true;
    }

    @Generated
    public String I_method_edaa3d14() {
        return this.I_field_523beb0a;
    }

    @Generated
    public ItemStack I_method_2214e82c() {
        return this.I_field_f2735522;
    }

    @Generated
    public List<iIIIiiII_Class141> I_method_e995a7bb() {
        return this.I_field_7865b31;
    }

    @Generated
    public boolean I_method_61f67110() {
        return this.I_field_5a;
    }

    @Generated
    public float i_method_6204fcdc() {
        return this.I_field_46;
    }

    @Generated
    public float II_method_dce6a7c5() {
        return this.i_field_46;
    }

    @Generated
    public float Ii_method_dcf533a5() {
        return this.II_field_46;
    }

    @Generated
    public iIIiIIIii_Class292 I_method_81ec0bc2() {
        return this.I_field_107fb28c;
    }
}

