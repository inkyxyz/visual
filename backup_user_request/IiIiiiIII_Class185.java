package rockstar.client;

import java.util.List;
import rockstar.client.III;
import rockstar.client.IIii_Class4;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIiii_Class184;
import rockstar.client.IiiI_Class7;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

final class IiIiiiIII_Class185
extends iii_Class8 {
    private final IiIiiIiii_Class184 I_field_46890e8c;
    private final IiIiiIIII_Class177 I_field_467a06ac;
    private iiI_Class7 I_field_b5845eac;

    IiIiiiIII_Class185(IiIiiIiii_Class184 iiIiiIiii_Class184, IiIiiIIII_Class177 iiIiiIIII_Class177) {
        this.I_field_46890e8c = iiIiiIiii_Class184;
        this.I_field_467a06ac = iiIiiIIII_Class177;
        this.iI_method_c1109a58().IiI_method_23cb1575().iii_method_df275535().snapSize().interactive(false).motion(IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.Ii_field_dd60aac)).lifeMotion(IIii_Class4.I_method_3682ece9(360L, IiiiIiiII_Class237.Ii_field_dd60aac)).enter(IiiI_Class7.II_field_f94500c1).exit(IiiI_Class7.II_field_f94500c1);
    }

    @Override
    protected void measure() {
        this.II_method_57518862();
        if (this.I_field_b5845eac == null) {
            this.prefW = this.I_field_46890e8c.getSize().I_field_46;
            this.prefH = this.I_field_46890e8c.getSize().i_field_46;
            return;
        }
        super.measure();
        this.I_field_46890e8c.getSize().I_method_77f2d69f(this.desiredW(), this.desiredH());
    }

    @Override
    protected void drawSelf(III iII, float f) {
        if (this.I_field_b5845eac == null) {
            this.I_field_46890e8c.render(iII, this.I_field_467a06ac, this.x(), this.y(), this.w(), this.h(), f);
        }
    }

    private void II_method_57518862() {
        iiI_Class7 iiI_Class72 = this.I_field_46890e8c.content(this.I_field_467a06ac);
        if (iiI_Class72 == this.I_field_b5845eac) {
            return;
        }
        this.I_field_b5845eac = iiI_Class72;
        if (this.I_field_b5845eac == null) {
            this.I_method_814bf93f();
        } else {
            this.II_method_244860a9(List.of(this.I_field_b5845eac));
        }
    }
}

