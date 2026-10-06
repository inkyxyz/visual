package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIIIII_Class257;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iII_Class5;
import rockstar.client.iiII_Class13;
import rockstar.client.iiiI_Class15;
import rockstar.client.iii_Class8;

public class KeybindSetting
extends AbstractSetting {
    private int I_field_49 = -1;

    public KeybindSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public KeybindSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public KeybindSetting I_method_4288e15a(int n) {
        this.I_method_51ee2d04(n);
        return this;
    }

    public void I_method_51ee2d04(int n) {
        if (this.I_field_49 == n) {
            return;
        }
        this.notifyChanged();
        this.I_field_49 = n;
    }

    public boolean I_method_51ee2d08(int n) {
        return this.isVisible() && iIIIIIIII_Class257.I_method_967132c3(this.I_field_49, n);
    }

    public boolean i_method_9b12da03() {
        return this.isVisible() && iIIIIIIII_Class257.II_method_98333a25(this.I_field_49);
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive((Number)this.I_field_49);
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        if (jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            this.I_method_51ee2d04(-1);
            int n = jsonElement.getAsInt();
            if (n != -1) {
                this.I_method_51ee2d04(n);
            }
        }
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isNumber()) {
            return false;
        }
        double d = jsonElement.getAsDouble();
        return Double.isFinite(d) && d >= -2.147483648E9 && d <= 2.147483647E9;
    }

    @Override
    public iii_Class8 createComponent() {
        iiiI_Class15 iiiI_Class152 = new iiiI_Class15(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), this::I_method_fa6281d2, this::I_method_51ee2d04);
        return new iii_Class8().IiI_method_31d4c97(17.0f).I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_8939bffd(iiiI_Class152).I_method_70a38517(5.0f).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_483797dd(IIi_Class2.i_field_b5755e8c).i_method_5db1deeb(iiiI_Class152::I_method_10341dfa).I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c);
    }

    @Generated
    public int I_method_fa6281d2() {
        return this.I_field_49;
    }
}

