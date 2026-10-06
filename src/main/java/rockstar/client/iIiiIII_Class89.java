package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.iIiIiiI_Class87;
import rockstar.client.iIiIiii_Class88;

public class iIiiIII_Class89 {
    private final List<iIiIiii_Class88> I_field_7865b31 = new ArrayList<iIiIiii_Class88>();

    public synchronized void I_method_337d8ee7(iIiIiii_Class88 iIiIiii_Class882) {
        this.I_field_7865b31.add(iIiIiii_Class882);
    }

    public synchronized void I_method_336f0307(iIiIiiI_Class87 iIiIiiI_Class872) {
        this.I_field_7865b31.add(iIiIiiI_Class872);
    }

    public synchronized boolean I_method_337d8eeb(iIiIiii_Class88 iIiIiii_Class882) {
        return this.I_field_7865b31.remove(iIiIiii_Class882);
    }

    public synchronized boolean I_method_336f030b(iIiIiiI_Class87 iIiIiiI_Class872) {
        return this.I_field_7865b31.remove(iIiIiiI_Class872);
    }

    @ApiStatus.Internal
    public synchronized <T> void I_method_f42361b7(T t, T t2) {
        if (!Objects.equals(t, t2)) {
            for (iIiIiii_Class88 iIiIiii_Class882 : this.I_field_7865b31) {
                iIiIiii_Class882.onChange(t, t2);
            }
        }
    }
}

