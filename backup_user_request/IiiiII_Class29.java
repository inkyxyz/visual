package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Nonnull;
import rockstar.client.IiiIii_Class28;
import rockstar.client.IiiiIi_Class30;
import rockstar.client.IiiiiI_Class31;

public class IiiiII_Class29 {
    private final JsonElement I_field_8d18826f;

    public static IiiiII_Class29 I_method_f548a31a(JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            return new IiiiIi_Class30(jsonElement.getAsJsonObject());
        }
        if (jsonElement instanceof JsonArray) {
            return new IiiIii_Class28(jsonElement.getAsJsonArray());
        }
        if (jsonElement instanceof JsonPrimitive) {
            return new IiiiiI_Class31(jsonElement.getAsJsonPrimitive());
        }
        return new IiiiII_Class29(jsonElement);
    }

    protected IiiiII_Class29(@Nonnull JsonElement jsonElement) {
        this.I_field_8d18826f = jsonElement;
    }

    @Nonnull
    public JsonElement I_method_8ac2b365() {
        return this.I_field_8d18826f;
    }

    public IiiiII_Class29 I_method_9b832b4b() {
        return IiiiII_Class29.I_method_f548a31a(this.I_field_8d18826f.deepCopy());
    }

    public boolean i_method_f510aa30() {
        return this.I_field_8d18826f.isJsonObject();
    }

    public boolean II_method_ab50a299() {
        return this.I_field_8d18826f.isJsonArray();
    }

    public boolean Ii_method_ab5f2e79() {
        return this.I_field_8d18826f.isJsonPrimitive();
    }

    public boolean iI_method_ad1392b9() {
        return this.I_field_8d18826f.isJsonNull();
    }

    public IiiiIi_Class30 I_method_9b832f2b() {
        if (this instanceof IiiiIi_Class30) {
            return (IiiiIi_Class30)this;
        }
        return new IiiiIi_Class30(this.I_field_8d18826f.getAsJsonObject());
    }

    public IiiIii_Class28 i_method_c597338b() {
        if (this instanceof IiiIii_Class28) {
            return (IiiIii_Class28)this;
        }
        return new IiiIii_Class28(this.I_field_8d18826f.getAsJsonArray());
    }

    public IiiiiI_Class31 I_method_9b83a36b() {
        if (this instanceof IiiiiI_Class31) {
            return (IiiiiI_Class31)this;
        }
        return new IiiiiI_Class31(this.I_field_8d18826f.getAsJsonPrimitive());
    }

    public boolean ii_method_ad221e99() {
        return this.I_field_8d18826f.getAsBoolean();
    }

    public byte I_method_f5021e38() {
        return this.I_field_8d18826f.getAsByte();
    }

    public short I_method_f5021e49() {
        return this.I_field_8d18826f.getAsShort();
    }

    public int i_method_f510aa1f() {
        return this.I_field_8d18826f.getAsInt();
    }

    public long I_method_f5021e40() {
        return this.I_field_8d18826f.getAsLong();
    }

    public float I_method_f5021e3c() {
        return this.I_field_8d18826f.getAsFloat();
    }

    public double I_method_f5021e3a() {
        return this.I_field_8d18826f.getAsDouble();
    }

    public BigInteger I_method_2e476681() {
        return this.I_field_8d18826f.getAsBigInteger();
    }

    public BigDecimal I_method_2e0216ce() {
        return this.I_field_8d18826f.getAsBigDecimal();
    }

    public Number I_method_2532a39c() {
        return this.I_field_8d18826f.getAsNumber();
    }

    public String I_method_2c46b7d4() {
        return this.I_field_8d18826f.getAsString();
    }

    public String toString() {
        return this.I_field_8d18826f.toString();
    }

    public boolean equals(Object object) {
        if (object instanceof IiiiII_Class29) {
            return this.I_field_8d18826f.equals(((IiiiII_Class29)object).I_field_8d18826f);
        }
        if (object instanceof JsonElement) {
            return this.I_field_8d18826f.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.I_field_8d18826f.hashCode();
    }
}

