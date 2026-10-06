package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iII_Class5;
import rockstar.client.iii_Class8;

public class ButtonSetting
extends AbstractSetting {
    private Runnable I_field_bac0a97e = System.out::println;

    public ButtonSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public ButtonSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public ButtonSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2) {
        super(iIiiiIIiI_Class115, string);
    }

    public ButtonSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public ButtonSetting I_method_f05556b3(Runnable runnable) {
        this.I_field_bac0a97e = runnable;
        return this;
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive("\u0441\u0443\u043a\u0430 \u043a\u0430\u043a \u0441\u0434\u0435\u043b\u0430\u0442\u044c \u0442\u0430\u043a \u0447\u0442\u043e\u0431\u044b \u0434\u043b\u044f \u043d\u0435\u0433\u043e \u043d\u0435 \u0431\u044b\u043b\u043e \u043a\u0444\u0433");
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
    }

    @Override
    public iii_Class8 createComponent() {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_fe5d8d56(IIIi_Class2.i_field_f93600a1).IiI_method_31d4c97(18.0f).I_method_8939bffd(new Iii_Class4().fillWidth().height(16.0f).radius(6.0f).background(iii_Class4 -> IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.3f + 0.2f * iii_Class4.hover() + 0.1f * iii_Class4.press())).text(iIiIIi_Class10, () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a), iii_Class4 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iii_Class4.hover())).textAlign(IIi_Class2.i_field_b5755e8c).cursor(iIIIiIIIi_Class274.i_field_aa52e62c).onClick(() -> this.I_field_bac0a97e.run()));
    }

    @Generated
    public Runnable I_method_7db574f5() {
        return this.I_field_bac0a97e;
    }

    @Generated
    public void I_method_1d76073d(Runnable runnable) {
        this.I_field_bac0a97e = runnable;
    }
}

