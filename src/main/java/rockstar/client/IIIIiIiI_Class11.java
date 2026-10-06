package rockstar.client;

import rockstar.client.IIIIIiii_Class8;
import rockstar.client.IIIIiIII_Class9;
import rockstar.client.IIIIiIIi_Class10;
import rockstar.client.IIIIiiIi_Class14;
import rockstar.client.iiiiiii_Class128;

public class IIIIiIiI_Class11
implements IIIIiIII_Class9 {
    private final IIIIIiii_Class8 I_field_416e4f61;
    private int I_field_49;
    private boolean I_field_5a;

    public IIIIiIiI_Class11(int n) {
        this.I_field_416e4f61 = new IIIIIiii_Class8(n, 1);
    }

    @Override
    public void I_method_f2de637a(iiiiiii_Class128 iiiiiii_Class1282) {
        if (iiiiiii_Class1282 == null || !iiiiiii_Class1282.Ii_method_16f24ea6()) {
            return;
        }
        if (this.I_field_5a) {
            iiiiiii_Class1282.Iii_method_c77508df();
            ++this.I_field_49;
            if (this.I_field_49 >= Math.max(1, iiiiiii_Class1282.I_method_e08ecf78().ii_method_19d0cc08())) {
                iiiiiii_Class1282.I_method_b8ab1d60(new IIIIiIIi_Class10());
            }
            return;
        }
        this.I_field_416e4f61.I_method_f2de637a(iiiiiii_Class1282);
        if (iiiiiii_Class1282.I_method_e2514398() instanceof IIIIiiIi_Class14) {
            this.I_field_5a = true;
            this.I_field_49 = 0;
            iiiiiii_Class1282.I_method_b8ab1d60(this);
        }
    }

    @Override
    public String I_method_dcc0dd54() {
        return "CyclicRebreakWithRejoin";
    }
}

