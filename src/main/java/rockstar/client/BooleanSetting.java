package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiI_Class7;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iII_Class5;
import rockstar.client.iIIiIiIII_Class297;
import rockstar.client.iiII_Class13;
import rockstar.client.iii_Class8;

public class BooleanSetting
extends AbstractSetting
implements iIIiIiIII_Class297 {
    private boolean I_field_5a;

    public BooleanSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public BooleanSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public BooleanSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2) {
        super(iIiiiIIiI_Class115, string);
    }

    public BooleanSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public BooleanSetting I_method_a4d009eb(boolean bl) {
        this.I_method_4e1408b5(bl);
        return this;
    }

    public BooleanSetting I_method_decd82b5() {
        this.I_method_4e1408b5(true);
        return this;
    }

    public void I_method_4e1408b5(boolean bl) {
        if (this.I_field_5a == bl) {
            return;
        }
        this.notifyChanged();
        this.I_field_5a = bl;
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive(Boolean.valueOf(this.I_field_5a));
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return;
        }
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
            this.I_method_4e1408b5(jsonElement.getAsBoolean());
            return;
        }
        if (jsonElement.isJsonObject()) {
            JsonElement jsonElement2;
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement3 = jsonElement2 = jsonObject.has("enabled") ? jsonObject.get("enabled") : jsonObject.get("value");
            if (jsonElement2 != null && jsonElement2.isJsonPrimitive() && jsonElement2.getAsJsonPrimitive().isBoolean()) {
                this.I_method_4e1408b5(jsonElement2.getAsBoolean());
            }
        }
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return false;
        }
        if (jsonElement.isJsonPrimitive()) {
            return jsonElement.getAsJsonPrimitive().isBoolean();
        }
        if (!jsonElement.isJsonObject()) {
            return false;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = jsonObject.has("enabled") ? jsonObject.get("enabled") : jsonObject.get("value");
        return jsonElement2 != null && jsonElement2.isJsonPrimitive() && jsonElement2.getAsJsonPrimitive().isBoolean();
    }

    @Override
    public iii_Class8 createComponent() {
        return new iii_Class8().IiI_method_31d4c97(18.0f).I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_8939bffd(new IIiiI_Class7(this::i_method_9b12da03).i_method_c4678f15(() -> IiiiiIIIi_Class242.IIi_field_d0c8ec5).size(13.0f, 8.0f).minSize(13.0f, 8.0f).snapSize()).I_method_70a38517(5.0f).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_c0ca36f3(this::toggle).I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c);
    }

    @Override
    public void toggle() {
        this.I_method_4e1408b5(!this.I_field_5a);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Generated
    public boolean i_method_9b12da03() {
        return this.I_field_5a;
    }
}

