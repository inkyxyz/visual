package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Locale;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import org.jetbrains.annotations.NotNull;
import rockstar.client.IIII;
import rockstar.client.IIIII;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiIiiii_Class112;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iII_Class5;
import rockstar.client.iiII_Class13;
import rockstar.client.iii_Class8;

public class VectorRangeSetting
extends AbstractSetting {
    private float I_field_46;
    private float i_field_46;
    private float II_field_46 = -1.0f;
    private float Ii_field_46 = 1.0f;
    private float iI_field_46 = -1.0f;
    private float ii_field_46 = 1.0f;
    private float III_field_46;
    private float IIi_field_46;
    private IIiiIiiii_Class112<Vec2f> I_field_8548a68c = vec2f -> vec2f;

    public VectorRangeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public VectorRangeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public VectorRangeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public VectorRangeSetting I_method_78313b9d(IIiiIiiii_Class112<Vec2f> iIiiIiiii_Class112) {
        this.I_field_8548a68c = iIiiIiiii_Class112 == null ? vec2f -> vec2f : iIiiIiiii_Class112;
        this.I_method_886cd63f(this.I_field_46, this.i_field_46);
        return this;
    }

    public VectorRangeSetting I_method_50432fd7(float f) {
        this.I_method_886cd63f(f, this.i_field_46);
        return this;
    }

    public VectorRangeSetting i_method_ed5c37f7(float f) {
        this.I_method_886cd63f(this.I_field_46, f);
        return this;
    }

    public VectorRangeSetting I_method_f30816f5(float f, float f2) {
        this.I_method_886cd63f(f, f2);
        return this;
    }

    public VectorRangeSetting II_method_90cdcab4(float f) {
        this.II_field_46 = f;
        this.i_method_82feeddf();
        return this;
    }

    public VectorRangeSetting Ii_method_2de6d2d4(float f) {
        this.Ii_field_46 = f;
        this.i_method_82feeddf();
        return this;
    }

    public VectorRangeSetting iI_method_96d5c694(float f) {
        this.iI_field_46 = f;
        this.i_method_82feeddf();
        return this;
    }

    public VectorRangeSetting ii_method_33eeceb4(float f) {
        this.ii_field_46 = f;
        this.i_method_82feeddf();
        return this;
    }

    public VectorRangeSetting III_method_61968b77(float f) {
        this.III_field_46 = MathHelper.clamp((float)f, (float)this.II_field_46, (float)this.Ii_field_46);
        return this;
    }

    public VectorRangeSetting IIi_method_feaf9397(float f) {
        this.IIi_field_46 = MathHelper.clamp((float)f, (float)this.iI_field_46, (float)this.ii_field_46);
        return this;
    }

    public Vec2f I_method_1c36ddb6() {
        return new Vec2f(this.I_field_46, this.i_field_46);
    }

    public Vec2f i_method_c02f6196() {
        return new Vec2f(this.III_field_46, this.IIi_field_46);
    }

    public void I_method_886cd63f(float f, float f2) {
        Vec2f vec2f = this.I_field_8548a68c.changed(new Vec2f(f, f2));
        float f3 = MathHelper.clamp((float)vec2f.x, (float)this.II_field_46, (float)this.Ii_field_46);
        float f4 = MathHelper.clamp((float)vec2f.y, (float)this.iI_field_46, (float)this.ii_field_46);
        if (this.I_field_46 == f3 && this.i_field_46 == f4) {
            return;
        }
        this.notifyChanged();
        this.I_field_46 = f3;
        this.i_field_46 = f4;
    }

    public void I_method_7cef5ce8(Vec2f vec2f) {
        this.I_method_886cd63f(vec2f.x, vec2f.y);
    }

    private void i_method_82feeddf() {
        this.I_method_886cd63f(this.I_field_46, this.i_field_46);
        this.III_method_61968b77(this.III_field_46);
        this.IIi_method_feaf9397(this.IIi_field_46);
    }

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("x", (Number)Float.valueOf(this.I_field_46));
        jsonObject.addProperty("y", (Number)Float.valueOf(this.i_field_46));
        jsonObject.addProperty("bind_x", (Number)Float.valueOf(this.III_field_46));
        jsonObject.addProperty("bind_y", (Number)Float.valueOf(this.IIi_field_46));
        return jsonObject;
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.has("x") && !this.i_method_8cc5a0ae(jsonObject.get("x")) || jsonObject.has("y") && !this.i_method_8cc5a0ae(jsonObject.get("y")) || jsonObject.has("bind_x") && !this.i_method_8cc5a0ae(jsonObject.get("bind_x")) || jsonObject.has("bind_y") && !this.i_method_8cc5a0ae(jsonObject.get("bind_y"))) {
            return;
        }
        float f = this.I_field_46;
        float f2 = this.i_field_46;
        float f3 = this.III_field_46;
        float f4 = this.IIi_field_46;
        if (jsonObject.has("x")) {
            f = jsonObject.get("x").getAsFloat();
        }
        if (jsonObject.has("y")) {
            f2 = jsonObject.get("y").getAsFloat();
        }
        if (jsonObject.has("bind_x")) {
            f3 = jsonObject.get("bind_x").getAsFloat();
        }
        if (jsonObject.has("bind_y")) {
            f4 = jsonObject.get("bind_y").getAsFloat();
        }
        if (!(Float.isFinite(f) && Float.isFinite(f2) && Float.isFinite(f3) && Float.isFinite(f4))) {
            return;
        }
        this.I_method_886cd63f(f, f2);
        this.III_method_61968b77(f3);
        this.IIi_method_feaf9397(f4);
    }

    private boolean i_method_8cc5a0ae(JsonElement jsonElement) {
        return jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber() && Float.isFinite(jsonElement.getAsFloat());
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return false;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return jsonObject.has("x") && this.i_method_8cc5a0ae(jsonObject.get("x")) && jsonObject.has("y") && this.i_method_8cc5a0ae(jsonObject.get("y")) && jsonObject.has("bind_x") && this.i_method_8cc5a0ae(jsonObject.get("bind_x")) && jsonObject.has("bind_y") && this.i_method_8cc5a0ae(jsonObject.get("bind_y"));
    }

    @Override
    public iii_Class8 createComponent() {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f);
        iii_Class8 iii_Class82 = new iii_Class8().I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0f, 0.0f, 0.0f, 0.0f)).III_method_9dc17555();
        return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_70a38517(6.0f).I_method_8939bffd(iii_Class82).I_method_8939bffd(new IIIII(this::I_method_82f061ef, this::i_method_82feedcf, this::I_method_886cd63f, this.II_field_46, this.Ii_field_46, this.iI_field_46, this.ii_field_46).I_method_ac811357(2.0f).I_method_76d22d74(iIiIIi_Class10, () -> String.format(Locale.ROOT, "%.2f : %.2f", Float.valueOf(this.I_method_82f061ef()), Float.valueOf(this.i_method_82feedcf()))).I_method_91f6ff35());
    }

    @Generated
    public float I_method_82f061ef() {
        return this.I_field_46;
    }

    @Generated
    public float i_method_82feedcf() {
        return this.i_field_46;
    }

    @Generated
    public float II_method_db2ad532() {
        return this.II_field_46;
    }

    @Generated
    public float Ii_method_db396112() {
        return this.Ii_field_46;
    }

    @Generated
    public float iI_method_dcedc552() {
        return this.iI_field_46;
    }

    @Generated
    public float ii_method_dcfc5132() {
        return this.ii_field_46;
    }

    @Generated
    public float III_method_8a3eca4f() {
        return this.III_field_46;
    }

    @Generated
    public float IIi_method_8a4d562f() {
        return this.IIi_field_46;
    }

    @Generated
    public IIiiIiiii_Class112<Vec2f> I_method_ca15d6f5() {
        return this.I_field_8548a68c;
    }
}

