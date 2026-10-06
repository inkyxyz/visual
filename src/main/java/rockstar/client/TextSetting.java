package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;
import rockstar.client.IIII;
import rockstar.client.IIiII_Class5;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iII_Class5;
import rockstar.client.iiII_Class13;
import rockstar.client.iii_Class8;

public class TextSetting
extends AbstractSetting {
    private static final Pattern I_field_5fd3861f = Pattern.compile("\\X");
    private String i_field_523beb0a;
    private boolean I_field_5a;
    private int I_field_49;

    public TextSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public TextSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public TextSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2) {
        super(iIiiiIIiI_Class115, string);
    }

    public TextSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public final TextSetting I_method_104de33f(String string) {
        String string2 = this.I_method_b1b92d37(string);
        if (Objects.equals(this.i_field_523beb0a, string2)) {
            return this;
        }
        this.notifyChanged();
        this.i_field_523beb0a = string2;
        return this;
    }

    public void I_method_79680a89(String string) {
        this.I_method_104de33f(string);
    }

    public final TextSetting I_method_2dbacd5a(int n) {
        this.I_field_49 = n;
        this.i_field_523beb0a = this.I_method_b1b92d37(this.i_field_523beb0a);
        return this;
    }

    private String I_method_b1b92d37(String string) {
        if (this.I_field_49 <= 0 || string == null) {
            return string;
        }
        Matcher matcher = I_field_5fd3861f.matcher(string);
        int n = 0;
        while (matcher.find()) {
            if (++n <= this.I_field_49) continue;
            return string.substring(0, matcher.start());
        }
        return string;
    }

    public final TextSetting I_method_ec08f9eb(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    @Override
    public final JsonElement toJson() {
        return new JsonPrimitive(this.i_field_523beb0a);
    }

    @Override
    public final void fromJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            return;
        }
        this.I_method_104de33f(jsonElement.getAsString());
    }

    @Override
    public iii_Class8 createComponent() {
        iii_Class8 iii_Class82 = new iii_Class8().I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0f, 0.0f, 0.0f, 0.0f)).III_method_9dc17555();
        return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_70a38517(4.0f).I_method_8939bffd(iii_Class82).I_method_8939bffd(new IIiII_Class5(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), this.i_field_523beb0a, this::I_method_104de33f).I_method_9d6eab6b(this.I_field_5a).i_method_5ba67a(this.I_field_49).I_method_fc398af5(() -> IiIiIIII_Class81.I_method_f25a980a("type_text")).I_method_e5f33669(iIiII_Class5 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5).I_method_49a8a757(4.0f).i_method_e2c562d5().Ii_method_3f6d8e94(15.0f));
    }

    @Generated
    public String II_method_da016c1e() {
        return this.i_field_523beb0a;
    }

    @Generated
    public boolean i_method_9b12da03() {
        return this.I_field_5a;
    }

    @Generated
    public int I_method_18d0e272() {
        return this.I_field_49;
    }
}

