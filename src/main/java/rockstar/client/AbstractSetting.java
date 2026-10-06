package rockstar.client;

import java.util.function.BooleanSupplier;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;
import rockstar.client.Setting;
import rockstar.client.IIiiiIIIi_Class114;
import rockstar.client.IIiiiIIiI_Class115;

public abstract class AbstractSetting
implements Setting {
    protected final String I_field_523beb0a;
    private final IIiiiIIiI_Class115 I_field_ba123a8c;
    @NotNull
    private final BooleanSupplier I_field_7bf34412;

    public AbstractSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        this.I_field_ba123a8c = iIiiiIIiI_Class115;
        this.I_field_523beb0a = string;
        this.I_field_7bf34412 = booleanSupplier;
        this.registerWithOwner(iIiiiIIiI_Class115);
    }

    public AbstractSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        this(iIiiiIIiI_Class115, string, () -> false);
    }

    @Override
    public final void registerWithOwner(IIiiiIIiI_Class115 iIiiiIIiI_Class115) {
        if (iIiiiIIiI_Class115 != null && iIiiiIIiI_Class115.getSettings() != null) {
            iIiiiIIiI_Class115.getSettings().add(this);
        }
    }

    public final void notifyChanged() {
        IIiiiIIIi_Class114.I_method_d0b91cc7(this);
    }

    @Override
    public final String getDescriptionKey() {
        return this.getName() + ".description";
    }

    @Override
    @Generated
    public String getName() {
        return this.I_field_523beb0a;
    }

    @Generated
    public IIiiiIIiI_Class115 I_method_3ac66f15() {
        return this.I_field_ba123a8c;
    }

    @Override
    @NotNull
    @Generated
    public BooleanSupplier getHiddenCondition() {
        return this.I_field_7bf34412;
    }
}

