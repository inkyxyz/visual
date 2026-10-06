package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.Setting;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iIIiIIIii_Class292;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iiIIIIIi_Class194;
import rockstar.client.iiIIIIiI_Class195;
import rockstar.client.iiIIIiii_Class200;
import rockstar.client.iiIIiIII_Class201;
import rockstar.client.iiIIiIIi_Class202;

public class iiIIIiiI_Class199
extends iI_Class3 {
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.I_field_dd60aac);
    private final iIIiIIIii_Class292 I_field_107fb28c = new iIIiIIIii_Class292();
    private final IiIiIIIII_Class161 I_field_fdef2cc;
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.i_field_dd60aac);

    public iiIIIiiI_Class199() {
        this.I_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f));
        this.I_field_fdef2cc.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("type_name"));
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        boolean bl;
        float f;
        iiIIIIIi_Class194 iiIIIIIi_Class1942 = RockstarClient.getInstance().I_method_11732eb();
        iiIIiIIi_Class202 iiIIiIRockstarClient022 = RockstarClient.getInstance().I_method_2da230b();
        List<iiIIiIII_Class201> list = iiIIiIRockstarClient022.I_method_43006bfb();
        float f2 = this.I_field_46 + 8.0f;
        float f3 = this.i_field_46 - 1.0f;
        float f4 = this.II_field_46 - 16.0f;
        this.I_field_107fb28c.I_method_575ab23f();
        iII.drawRoundedRect(f2 - 1.0f, f3 + 7.0f, f4 + 2.0f, 8.0f + this.Ii_field_46 - 46.0f, IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(76.5f));
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.Ii_field_46 - 46.0f);
        float f5 = 0.0f;
        for (iiIIIiii_Class200 object : RockstarClient.getInstance().I_method_11732eb().I_method_c2ce901b()) {
            f = (float)((double)(f3 + 14.0f + f5) - this.I_field_107fb28c.I_method_575ab22d());
            bl = iIIiIIIiI_Class291.I_method_da20b32b(f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.Ii_field_46 - 46.0f, iII) && iIIiIIIiI_Class291.I_method_c3fabb03(f2 - 1.0f, f - 4.0f, f4 + 2.0f, 12.0, iII.I_method_b1c3e152(), iII.i_method_b1d26d32());
            object.I_method_726873a2().I_method_edd72835(bl);
            object.i_method_87fde782().I_method_edd72835(Objects.equals(object.I_method_62860974(), iiIIIIIi_Class1942.I_method_5c4a8d74()));
            iII.drawFadeoutText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), IiIiIIII_Class81.I_method_f25a980a(object.I_method_62860974()), f2 + 7.0f, f + 0.5f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * object.I_method_726873a2().I_method_6ac4da6f() + 0.25f * object.i_method_87fde782().I_method_6ac4da6f())), 0.8f, 1.0f, f4 - 12.0f - object.i_method_87fde782().I_method_6ac4da6f() * 10.0f);
            if (bl) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            if (object.i_method_87fde782().I_method_6ac4da6f() >= 0.0f) {
                iII.drawIcon("check", f2 + f4 - 11.0f - object.i_method_87fde782().I_method_6ac4da6f() * 2.0f, f, 6.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(object.i_method_87fde782().I_method_6ac4da6f() * 255.0f));
            }
            f5 += 12.0f;
        }
        for (iiIIiIII_Class201 iiIIiIII_Class2012 : list) {
            if (iiIIiIII_Class2012.I_method_5141c934().equals("autosave")) continue;
            f = (float)((double)(f3 + 14.0f + f5) - this.I_field_107fb28c.I_method_575ab22d());
            bl = iIIiIIIiI_Class291.I_method_da20b32b(f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.Ii_field_46 - 46.0f, iII) && iIIiIIIiI_Class291.I_method_c3fabb03(f2 - 1.0f, f - 4.0f, f4 + 2.0f, 12.0, iII.I_method_b1c3e152(), iII.i_method_b1d26d32());
            iiIIiIII_Class2012.I_method_e8886be2().I_method_edd72835(bl);
            iiIIiIII_Class2012.i_method_fe1ddfc2().I_method_edd72835(Objects.equals(iiIIiIII_Class2012.I_method_5141c934(), iiIIIIIi_Class1942.I_method_5c4a8d74()));
            iII.drawFadeoutText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), iiIIiIII_Class2012.I_method_5141c934(), f2 + 7.0f + 10.0f * iiIIiIII_Class2012.I_method_e8886be2().I_method_6ac4da6f(), f + 0.5f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * (0.75f + 0.25f * iiIIiIII_Class2012.I_method_e8886be2().I_method_6ac4da6f() + 0.25f * iiIIiIII_Class2012.i_method_fe1ddfc2().I_method_6ac4da6f())), 0.8f, 1.0f, f4 - 12.0f - iiIIiIII_Class2012.i_method_fe1ddfc2().I_method_6ac4da6f() * 10.0f - 10.0f * iiIIiIII_Class2012.I_method_e8886be2().I_method_6ac4da6f());
            if (bl) {
                iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
            if (iiIIiIII_Class2012.I_method_e8886be2().I_method_6ac4da6f() >= 0.0f) {
                iII.drawIcon("trash", f2 + 7.0f * iiIIiIII_Class2012.I_method_e8886be2().I_method_6ac4da6f(), f, 6.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(iiIIiIII_Class2012.I_method_e8886be2().I_method_6ac4da6f() * 255.0f));
            }
            if (iiIIiIII_Class2012.i_method_fe1ddfc2().I_method_6ac4da6f() >= 0.0f) {
                iII.drawIcon("check", f2 + f4 - 11.0f - iiIIiIII_Class2012.i_method_fe1ddfc2().I_method_6ac4da6f() * 2.0f, f, 6.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(iiIIiIII_Class2012.i_method_fe1ddfc2().I_method_6ac4da6f() * 255.0f));
            }
            f5 += 12.0f;
        }
        iIiiiIiII_Class373.I_method_ff80a1df();
        iII.drawRoundedRect(f2 - 1.0f, f3 + this.Ii_field_46 - 25.0f, f4 + 2.0f, 20.0f, IIiii_Class8.I_method_893b2757(6.0f), IiiiiIIIi_Class242.II_method_190e6391().mulAlpha(0.3f));
        iII.drawIcon("plus", f2 + f4 - 2.0f * this.I_field_dc7facc.I_method_6ac4da6f() - 10.0f, f3 + this.Ii_field_46 - 25.0f + 6.0f, 8.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(this.I_field_dc7facc.I_method_6ac4da6f()));
        this.I_field_fdef2cc.I_method_b043bcc(f2 - 1.0f, f3 + this.Ii_field_46 - 25.0f, f4 + 2.0f - 12.0f, 20.0f);
        this.I_field_fdef2cc.iI_method_a8609f1e(1.0f);
        this.I_field_fdef2cc.I_method_7ae26dda(iII);
        this.I_field_dc7facc.I_method_edd72835(!this.I_field_fdef2cc.I_method_d2579001().isBlank());
        if (iIIiIIIiI_Class291.I_method_da20b32b(f2 + f4 - 2.0f - 10.0f, f3 + this.Ii_field_46 - 25.0f + 6.0f, 8.0, 8.0, iII) && this.I_field_dc7facc.I_method_6ac4da6f() > 0.0f) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        this.I_field_107fb28c.i_method_95bee5ff(-f5 + this.Ii_field_46 - 20.0f - 25.0f);
    }

    @Override
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        boolean bl;
        float f;
        this.I_field_fdef2cc.I_method_400ceaa7(d, d2, iiIII_Class9);
        iiIIIIIi_Class194 iiIIIIIi_Class1942 = RockstarClient.getInstance().I_method_11732eb();
        iiIIiIIi_Class202 iiIIiIRockstarClient022 = RockstarClient.getInstance().I_method_2da230b();
        List<iiIIiIII_Class201> list = iiIIiIRockstarClient022.I_method_43006bfb();
        float f2 = this.I_field_46 + 8.0f;
        float f3 = this.i_field_46 - 1.0f;
        float f4 = this.II_field_46 - 16.0f;
        float f5 = 0.0f;
        for (iiIIIiii_Class200 object : RockstarClient.getInstance().I_method_11732eb().I_method_c2ce901b()) {
            f = (float)((double)(f3 + 14.0f + f5) - this.I_field_107fb28c.I_method_575ab22d());
            boolean bl2 = bl = iIIiIIIiI_Class291.I_method_c3f86263(f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.Ii_field_46 - 46.0f, d, d2) && iIIiIIIiI_Class291.I_method_c3f86263(f2 - 1.0f, f - 4.0f, f4 + 2.0f, 12.0, d, d2);
            if (bl && iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                iiIIIIIi_Class1942.I_method_3912c30d(object);
            }
            f5 += 12.0f;
        }
        for (iiIIiIII_Class201 iiIIiIII_Class2012 : new ArrayList<iiIIiIII_Class201>(list)) {
            if (iiIIiIII_Class2012.I_method_5141c934().equals("autosave")) continue;
            f = (float)((double)(f3 + 14.0f + f5) - this.I_field_107fb28c.I_method_575ab22d());
            boolean bl3 = bl = iIIiIIIiI_Class291.I_method_c3f86263(f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.Ii_field_46 - 46.0f, d, d2) && iIIiIIIiI_Class291.I_method_c3f86263(f2 - 1.0f, f - 4.0f, f4 + 2.0f, 12.0, d, d2);
            if (bl && iIIiIIIiI_Class291.I_method_c3f86263(f2 + 7.0f, f, 6.0, 6.0, d, d2) && iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                iiIIiIII_Class2012.II_method_145a73f5();
            } else if (bl && iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                if (iiIIiIRockstarClient022.i_method_646d600b() != null) {
                    iiIIiIRockstarClient022.i_method_646d600b().i_method_84d72ccc();
                }
                iiIIIIIi_Class1942.I_method_d1c7ab76(iiIIiIII_Class2012.I_method_5141c934());
                iiIIiIII_Class2012.I_method_84c8a0ec();
            }
            f5 += 12.0f;
        }
        if (iIIiIIIiI_Class291.I_method_c3f86263(f2 + f4 - 2.0f - 10.0f, f3 + this.Ii_field_46 - 25.0f + 6.0f, 8.0, 8.0, d, d2) && !this.I_field_fdef2cc.I_method_d2579001().isBlank()) {
            this.i_method_953650ac();
        }
    }

    private void i_method_953650ac() {
        iiIIIIiI_Class195.Nested1_f8433cb3 nested1_f8433cb3;
        iiIIiIIi_Class202 iiIIiIRockstarClient022 = RockstarClient.getInstance().I_method_2da230b();
        iiIIIIIi_Class194 iiIIIIIi_Class1942 = RockstarClient.getInstance().I_method_11732eb();
        iiIIIIIi_Class1942.I_method_bfd0c322().I_method_d8522ef5(0.5f, 1.0f).i_method_de5a2ad5(0.5f, 0.0f);
        iiIIIIIi_Class1942.I_method_bfd13f22().I_method_a4d009eb(true);
        iiIIIIIi_Class1942.I_method_78c80362().I_method_a1eda161(2.0f);
        for (Setting iIiiiIIII_Class113 : RockstarClient.getInstance().I_method_11732eb().I_method_94b5d40b().getSettings()) {
            if (!(iIiiiIIII_Class113 instanceof iiIIIIiI_Class195.Nested1_f8433cb3)) continue;
            nested1_f8433cb3 = (iiIIIIiI_Class195.Nested1_f8433cb3)iIiiiIIII_Class113;
            nested1_f8433cb3.I_method_a1eda161(0.0f);
        }
        for (Setting iIiiiIIII_Class113 : RockstarClient.getInstance().I_method_11732eb().i_method_beb2642b().getSettings()) {
            if (!(iIiiiIIII_Class113 instanceof iiIIIIiI_Class195.Nested1_f8433cb3)) continue;
            nested1_f8433cb3 = (iiIIIIiI_Class195.Nested1_f8433cb3)iIiiiIIII_Class113;
            nested1_f8433cb3.I_method_a1eda161(0.0f);
        }
        iiIIIIIi_Class1942.I_method_d1c7ab76(this.I_field_fdef2cc.I_method_d2579001());
        iiIIiIRockstarClient022.I_method_fbe9c396(this.I_field_fdef2cc.I_method_d2579001());
        iiIIiIRockstarClient022.I_method_d4b21861(this.I_field_fdef2cc.I_method_d2579001()).I_method_84c8a0ec();
        this.I_field_fdef2cc.II_method_fb6974c2();
    }

    @Override
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_fdef2cc.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public void I_method_c1acbc24(int n, int n2, int n3) {
        if (n == 257 && !this.I_field_fdef2cc.I_method_d2579001().isBlank()) {
            this.i_method_953650ac();
            return;
        }
        this.I_field_fdef2cc.I_method_c1acbc24(n, n2, n3);
        if (this.I_method_a74dc6d0(iIIiIIIiI_Class291.I_method_81637b4f().getX(), iIIiIIIiI_Class291.I_method_81637b4f().getY())) {
            this.I_field_107fb28c.I_method_93fc08a4(n);
        }
    }

    @Override
    public boolean I_method_b71e84c9(char c, int n) {
        this.I_field_fdef2cc.I_method_b71e84c9(c, n);
        return super.I_method_b71e84c9(c, n);
    }

    @Override
    public void I_method_6b0ad25f(double d, double d2, double d3, double d4) {
        this.I_field_107fb28c.I_method_93fbf5df(d4);
    }

    @Override
    public float Ii_method_2047ead7() {
        iiIIiIIi_Class202 iiIIiIRockstarClient022 = RockstarClient.getInstance().I_method_2da230b();
        List<iiIIiIII_Class201> list = iiIIiIRockstarClient022.I_method_43006bfb();
        this.Ii_field_46 = this.i_field_dc7facc.I_method_edd6dd11(Math.min(list.size() * 12 + RockstarClient.getInstance().I_method_11732eb().I_method_c2ce901b().size() * 12 - 12, 182) + 46);
        return this.Ii_field_46;
    }
}

