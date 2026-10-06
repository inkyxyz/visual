package rockstar.client;

import lombok.Generated;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IIIiiiIi_Class30;
import rockstar.client.IiIIIiIi_Class70;
import rockstar.client.RockstarClient;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIiIiIii_Class428;
import rockstar.client.iiIiiIIiI_Class435;
import rockstar.client.iiIiiiiii_Class448;
import rockstar.client.iiiIIIiii_Class456;
import rockstar.client.iiiiIIiIi_Class486;
import rockstar.client.iiiiIIiii_Class488;
import rockstar.client.iiiiIiIII_Class489;
import rockstar.client.iiiiIiIIi_Class490;

public final class iiIiiIiIi_Class438 {
    private static iiIiiIiIi_Class438 I_field_cfb6ba4c;
    private final iiIiiiiii_Class448 I_field_d17a228c;
    private final iiiiIIiIi_Class486 I_field_9541424c;
    private final iiiiIIiii_Class488 I_field_9541ba6c;
    private final iiiiIiIII_Class489 I_field_96f5a2ac;
    private final iiiiIiIIi_Class490 I_field_96f5a68c;
    private final iiIiiIIiI_Class435 I_field_cfa8a2ac;
    @Nullable
    private iiiIIIiii_Class456 I_field_f87a524c;

    public static iiIiiIiIi_Class438 I_method_12f562b5() {
        if (I_field_cfb6ba4c == null) {
            throw new IllegalStateException("NewtonCore not initialized yet");
        }
        return I_field_cfb6ba4c;
    }

    public static boolean I_method_1047da03() {
        return I_field_cfb6ba4c != null;
    }

    public void I_method_49f9c0a7(@Nullable iiiIIIiii_Class456 iiiIIIiii_Class4562) {
        this.I_field_f87a524c = iiiIIIiii_Class4562;
    }

    public iiIiiIiIi_Class438() {
        I_field_cfb6ba4c = this;
        this.I_field_d17a228c = iiIiiiiii_Class448.I_method_b7c1f75d(this);
        this.I_field_9541424c = iiiiIIiIi_Class486.I_method_79402f5d(this);
        this.I_field_9541ba6c = iiiiIIiii_Class488.I_method_39ba135d(this);
        this.I_field_96f5a2ac = iiiiIiIII_Class489.I_method_9d54db5d(this);
        this.I_field_96f5a68c = iiiiIiIIi_Class490.I_method_b40e775d(this);
        this.I_field_cfa8a2ac = new iiIiiIIiI_Class435();
        iiIiIiIii_Class428.I_method_89900887(this.I_field_cfa8a2ac);
    }

    public IiIIIiIi_Class70 I_method_ab199998() {
        return RockstarClient.getInstance().I_method_7897deab();
    }

    public iiIIiIiII_Class405 I_method_762df6b5() {
        return RockstarClient.getInstance().I_method_58785402();
    }

    public IIIiiiIi_Class30 I_method_e75201b8() {
        return RockstarClient.getInstance().I_method_b4d046cb();
    }

    @Generated
    public iiIiiiiii_Class448 I_method_14b8caf5() {
        return this.I_field_d17a228c;
    }

    @Generated
    public iiiiIIiIi_Class486 I_method_d87feab5() {
        return this.I_field_9541424c;
    }

    @Generated
    public iiiiIIiii_Class488 I_method_d88062d5() {
        return this.I_field_9541ba6c;
    }

    @Generated
    public iiiiIiIII_Class489 I_method_da344b15() {
        return this.I_field_96f5a2ac;
    }

    @Generated
    public iiiiIiIIi_Class490 I_method_da344ef5() {
        return this.I_field_96f5a68c;
    }

    @Generated
    public iiIiiIIiI_Class435 I_method_12e74b15() {
        return this.I_field_cfa8a2ac;
    }

    @Nullable
    @Generated
    public iiiIIIiii_Class456 I_method_3bb8fab5() {
        return this.I_field_f87a524c;
    }
}

