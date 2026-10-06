package rockstar.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import rockstar.client.IiiIiIi_Class54;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIII_Class57;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIii_Class60;
import rockstar.client.IiiiiII_Class61;
import rockstar.client.Iiiiiii_Class64;
import rockstar.client.iIIIII_Class33;

public class iIIIIIi_Class66
extends Iiiiiii_Class64 {
    private final Consumer<IiiiIII_Class57> I_field_f9f609fa;
    private final int I_field_49;

    public iIIIIIi_Class66(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55, Consumer<IiiiIII_Class57> consumer) {
        this(iIIIII_Class332, iiiIiiI_Class55, consumer, 300000);
    }

    public iIIIIIi_Class66(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55, Consumer<IiiiIII_Class57> consumer, int n) {
        super(iIIIII_Class332, iiiIiiI_Class55);
        this.I_field_f9f609fa = consumer;
        this.I_field_49 = n;
    }

    @Override
    public IiiiIIi_Class58 I_method_a2a3535() throws IOException, InterruptedException, TimeoutException {
        IiiiIII_Class57 iiiiIII_Class57 = this.I_method_b4e83d15();
        this.I_field_f9f609fa.accept(iiiiIII_Class57);
        return this.I_method_ddf941d(iiiiIII_Class57);
    }

    public IiiiIII_Class57 I_method_b4e83d15() throws IOException {
        return (IiiiIII_Class57)this.I_field_20717641.I_method_fc2df765(new IiiiIii_Class60(this.I_field_c50937ec));
    }

    public IiiiIIi_Class58 I_method_ddf941d(IiiiIII_Class57 iiiiIII_Class57) throws IOException, InterruptedException, TimeoutException {
        long l = System.currentTimeMillis();
        while (!iiiiIII_Class57.I_method_414434a3() && System.currentTimeMillis() - l <= (long)this.I_field_49) {
            try {
                return (IiiiIIi_Class58)this.I_field_20717641.I_method_fc2df765(new IiiiiII_Class61(this.I_field_c50937ec, iiiiIII_Class57));
            }
            catch (IiiIiIi_Class54 iiiIiIi_Class54) {
                if (iiiIiIi_Class54.I_method_2871836b().I_method_207e3e9f() == 400 && iiiIiIi_Class54.i_method_2836da01().equals("authorization_pending")) {
                    Thread.sleep(iiiiIII_Class57.i_method_d7f58c93());
                    continue;
                }
                throw iiiIiIi_Class54;
            }
        }
        throw new TimeoutException("Login timed out");
    }
}

