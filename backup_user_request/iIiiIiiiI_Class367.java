package rockstar.client;

import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiiIiiii_Class368;

public class iIiiIiiiI_Class367
implements iIIiIIiIi_Class294 {
    private long I_field_4a = System.nanoTime();
    private int I_field_49;
    private final boolean I_field_5a;
    private int i_field_49 = 0;
    private long i_field_4a = 0L;

    public iIiiIiiiI_Class367(boolean bl) {
        this.I_field_5a = bl;
        this.I_field_49 = 0;
    }

    public void I_method_dd5a7d15(int n, iIiiIiiii_Class368 ... iIiiIiiii_Class368Array) {
        if (this.i_field_49 != n) {
            this.i_field_4a = 1000000000L / (long)n;
            this.i_field_49 = n;
        }
        long l = System.nanoTime();
        long l2 = l - this.I_field_4a;
        this.I_field_49 += (int)(l2 / this.i_field_4a);
        this.I_field_4a += (long)this.I_field_49 * this.i_field_4a;
        this.I_field_49 = Math.min(this.I_field_49, this.I_field_5a ? Math.min(this.i_field_49, I_field_3a9bda27.getCurrentFps()) : this.i_field_49);
        while (this.I_field_49 > 0) {
            for (iIiiIiiii_Class368 iIiiIiiii_Class3682 : iIiiIiiii_Class368Array) {
                iIiiIiiii_Class3682.I_method_d242da1f();
            }
            --this.I_field_49;
        }
    }
}

