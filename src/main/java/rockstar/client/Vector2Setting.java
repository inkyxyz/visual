package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import net.minecraft.util.math.Vec2f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IIII;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIII_Class9;
import rockstar.client.iII_Class5;
import rockstar.client.iiII_Class13;
import rockstar.client.iii_Class8;

public class Vector2Setting
extends AbstractSetting {
    private Vec2f I_field_5bba09cd = Vec2f.ZERO;
    private Vec2f i_field_5bba09cd = new Vec2f(1.0f, 1.0f);

    public Vector2Setting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2, @Nullable BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public Vector2Setting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @Nullable BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public Vector2Setting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2) {
        super(iIiiiIIiI_Class115, string);
    }

    public Vector2Setting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public Vector2Setting I_method_d8522ef5(float f, float f2) {
        return this.I_method_f4aeac5e(new Vec2f(f, f2));
    }

    public Vector2Setting i_method_de5a2ad5(float f, float f2) {
        return this.i_method_4362bc7e(new Vec2f(f, f2));
    }

    public Vector2Setting I_method_f4aeac5e(Vec2f vec2f) {
        if (this.I_field_5bba09cd.equals(vec2f)) {
            return this;
        }
        this.notifyChanged();
        this.I_field_5bba09cd = vec2f;
        return this;
    }

    public Vector2Setting i_method_4362bc7e(Vec2f vec2f) {
        if (this.i_field_5bba09cd.equals(vec2f)) {
            return this;
        }
        this.notifyChanged();
        this.i_field_5bba09cd = vec2f;
        return this;
    }

    public IiiiIiiII_Class237 I_method_71834715() {
        return IiiiIiiII_Class237.I_method_ae57f375(this.I_field_5bba09cd.x, 1.0f - this.I_field_5bba09cd.y, this.i_field_5bba09cd.x, 1.0f - this.i_field_5bba09cd.y);
    }

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("start_x", (Number)Float.valueOf(this.I_field_5bba09cd.x));
        jsonObject.addProperty("start_y", (Number)Float.valueOf(this.I_field_5bba09cd.y));
        jsonObject.addProperty("end_x", (Number)Float.valueOf(this.i_field_5bba09cd.x));
        jsonObject.addProperty("end_y", (Number)Float.valueOf(this.i_field_5bba09cd.y));
        return jsonObject;
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.has("start_x") && !this.i_method_875a14ae(jsonObject.get("start_x")) || jsonObject.has("start_y") && !this.i_method_875a14ae(jsonObject.get("start_y")) || jsonObject.has("end_x") && !this.i_method_875a14ae(jsonObject.get("end_x")) || jsonObject.has("end_y") && !this.i_method_875a14ae(jsonObject.get("end_y"))) {
            return;
        }
        float f = this.I_field_5bba09cd.x;
        float f2 = this.I_field_5bba09cd.y;
        float f3 = this.i_field_5bba09cd.x;
        float f4 = this.i_field_5bba09cd.y;
        if (jsonObject.has("start_x") && jsonObject.has("start_y")) {
            f = jsonObject.get("start_x").getAsFloat();
            f2 = jsonObject.get("start_y").getAsFloat();
        }
        if (jsonObject.has("end_x") && jsonObject.has("end_y")) {
            f3 = jsonObject.get("end_x").getAsFloat();
            f4 = jsonObject.get("end_y").getAsFloat();
        }
        if (!(Float.isFinite(f) && Float.isFinite(f2) && Float.isFinite(f3) && Float.isFinite(f4))) {
            return;
        }
        this.I_method_f4aeac5e(new Vec2f(f, f2));
        this.i_method_4362bc7e(new Vec2f(f3, f4));
    }

    private boolean i_method_875a14ae(JsonElement jsonElement) {
        return jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber() && Float.isFinite(jsonElement.getAsFloat());
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return false;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return jsonObject.has("start_x") && this.i_method_875a14ae(jsonObject.get("start_x")) && jsonObject.has("start_y") && this.i_method_875a14ae(jsonObject.get("start_y")) && jsonObject.has("end_x") && this.i_method_875a14ae(jsonObject.get("end_x")) && jsonObject.has("end_y") && this.i_method_875a14ae(jsonObject.get("end_y"));
    }

    @Override
    public iii_Class8 createComponent() {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f);
        iii_Class8 iii_Class82 = new iii_Class8().I_method_8939bffd(new iiII_Class13(iIiIIi_Class10, () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0f, 0.0f, 0.0f, 0.0f)).III_method_9dc17555();
        return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_70a38517(6.0f).I_method_8939bffd(iii_Class82).I_method_8939bffd(new iIII_Class9(this::I_method_7430e9b6, this::i_method_18296d96, this::I_method_f4aeac5e, this::i_method_4362bc7e).II_method_2007f54d(IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.25f)).i_method_ee6a66c3(6.0f).I_method_bb4ccecb());
    }

    @Generated
    public Vec2f I_method_7430e9b6() {
        return this.I_field_5bba09cd;
    }

    @Generated
    public Vec2f i_method_18296d96() {
        return this.i_field_5bba09cd;
    }
}

