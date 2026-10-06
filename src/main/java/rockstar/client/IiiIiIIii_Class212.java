package rockstar.client;

import rockstar.client.III;
import rockstar.client.IIIIi_Class2;
import rockstar.client.IIiI_Class3;
import rockstar.client.IiIII_Class9;
import rockstar.client.Iii_Class4;
import rockstar.client.iiI_Class7;

public class IiiIiIIii_Class212
extends IIiI_Class3 {
    private final iiI_Class7 I_field_b5845eac = new Iii_Class4().size(0.0f, 0.0f).interactive(false);
    private IIIIi_Class2 I_field_2d89a12c;

    @Override
    public void init() {
        super.init();
        this.clearRoots();
        this.I_field_2d89a12c = new IIIIi_Class2(this.I_field_b5845eac, (iiIiiIii_Class92, iIiiiIIII_Class113) -> {}).I_method_5a9bd0bd(null);
        this.add(this.I_field_2d89a12c);
        this.I_field_2d89a12c.ii_method_59230462();
    }

    @Override
    public void render(III iII) {
        super.render(iII);
        if (this.I_field_2d89a12c != null && !this.I_field_2d89a12c.i_method_1ba556c3()) {
            this.close();
        }
    }

    @Override
    public void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
        super.onMouseClicked(d, d2, iiIII_Class9);
        if (this.I_field_2d89a12c != null) {
            this.I_field_2d89a12c.I_method_911c871f((float)d, (float)d2);
        }
    }
}

