package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
import rockstar.client.IIII;
import rockstar.client.IIIiI_Class3;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iII_Class5;
import rockstar.client.iiII_Class13;
import rockstar.client.iii_Class8;
import rockstar.client.iiii_Class16;

public class RangeSetting
extends AbstractSetting {
    private float I_field_46;
    private float i_field_46;
    private float II_field_46;
    private float Ii_field_46;
    private float iI_field_46;
    private float ii_field_46 = Float.NaN;

    public RangeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public RangeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public RangeSetting I_method_3944a7d7(float f) {
        this.I_method_3a7a7961(f);
        return this;
    }

    public RangeSetting i_method_d65daff7(float f) {
        this.i_method_3c3d6981(f);
        return this;
    }

    public RangeSetting II_method_c7edb334(float f) {
        this.II_field_46 = f;
        return this;
    }

    public RangeSetting Ii_method_6506bb54(float f) {
        this.Ii_field_46 = f;
        return this;
    }

    public RangeSetting iI_method_cdf5af14(float f) {
        this.iI_field_46 = f;
        return this;
    }

    public RangeSetting ii_method_6b0eb734(float f) {
        this.ii_field_46 = f;
        if (this.i_field_46 < this.I_method_e91cb62f()) {
            this.i_field_46 = this.I_method_e91cb62f();
        }
        return this;
    }

    public float I_method_e91cb62f() {
        return Float.isNaN(this.ii_field_46) ? this.II_field_46 : this.ii_field_46;
    }

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("first", (Number)Float.valueOf(this.I_field_46));
        jsonObject.addProperty("second", (Number)Float.valueOf(this.i_field_46));
        return jsonObject;
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (!(!jsonObject.has("first") || jsonObject.get("first").isJsonPrimitive() && jsonObject.get("first").getAsJsonPrimitive().isNumber())) {
            return;
        }
        if (!(!jsonObject.has("second") || jsonObject.get("second").isJsonPrimitive() && jsonObject.get("second").getAsJsonPrimitive().isNumber())) {
            return;
        }
        float f = this.I_field_46;
        float f2 = this.i_field_46;
        if (jsonObject.has("first")) {
            f = jsonObject.get("first").getAsFloat();
        }
        if (jsonObject.has("second")) {
            f2 = jsonObject.get("second").getAsFloat();
        }
        if (!Float.isFinite(f) || !Float.isFinite(f2)) {
            return;
        }
        this.I_method_3a7a7961(f);
        this.i_method_3c3d6981(f2);
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return false;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return jsonObject.has("first") && jsonObject.get("first").isJsonPrimitive() && jsonObject.get("first").getAsJsonPrimitive().isNumber() && Float.isFinite(jsonObject.get("first").getAsFloat()) && jsonObject.has("second") && jsonObject.get("second").isJsonPrimitive() && jsonObject.get("second").getAsJsonPrimitive().isNumber() && Float.isFinite(jsonObject.get("second").getAsFloat());
    }

    public void I_method_3a7a7961(float f) {
        float f2 = (float)MathHelper.clamp((double)((double)Math.round((double)f * (1.0 / (double)this.iI_field_46)) / (1.0 / (double)this.iI_field_46)), (double)this.II_field_46, (double)this.Ii_field_46);
        if (this.I_field_46 == f2) {
            return;
        }
        this.notifyChanged();
        this.I_field_46 = f2;
    }

    public void i_method_3c3d6981(float f) {
        float f2 = (float)MathHelper.clamp((double)((double)Math.round((double)f * (1.0 / (double)this.iI_field_46)) / (1.0 / (double)this.iI_field_46)), (double)this.I_method_e91cb62f(), (double)this.Ii_field_46);
        if (this.i_field_46 == f2) {
            return;
        }
        this.notifyChanged();
        this.i_field_46 = f2;
    }

    @Override
    public iii_Class8 createComponent() {
        iii_Class8 iii_Class82 = new iii_Class8().I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_8939bffd(new iii_Class8().I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_70a38517(3.0f).I_method_8939bffd(new iiii_Class16(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), this::i_method_e92b420f, this::I_method_3a7a7961, this.II_field_46, this.Ii_field_46).I_method_c389f5c5(() -> iIIIIiIiI_Class267.I_method_230e44c1(this.i_method_e92b420f())).I_method_46f30bd1(iiii_Class162 -> IiiiiIIIi_Class242.ii_field_d0c8ec5)).I_method_8939bffd(new Iii_Class4().text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), "-", IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5f)).interactive(false)).I_method_8939bffd(new iiii_Class16(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), this::II_method_3a8908f2, this::i_method_3c3d6981, this.I_method_e91cb62f(), this.Ii_field_46).I_method_c389f5c5(() -> iIIIIiIiI_Class267.I_method_230e44c1(this.II_method_3a8908f2())).I_method_46f30bd1(iiii_Class162 -> IiiiiIIIi_Class242.ii_field_d0c8ec5))).I_method_70a38517(6.0f).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0f, 0.0f, 0.0f, 0.0f)).III_method_9dc17555();
        return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_70a38517(5.0f).I_method_8939bffd(iii_Class82).I_method_8939bffd(new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).III_method_9dc17555().I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0f, 0.0f, 4.0f, 0.0f)).I_method_8939bffd(new IIIiI_Class3(this::i_method_e92b420f, this::I_method_3a7a7961, this::II_method_3a8908f2, this::i_method_3c3d6981, this.II_field_46, this.Ii_field_46).I_method_c216ff57(this.iI_field_46).I_method_bbf40775().ii_method_f09172f4(6.0f).i_method_ec391777(3.0f).II_method_ac4e6ef4(3.0f).Ii_method_d6708714(1.5f).I_method_6cce6e69(iIIiI_Class3 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5).i_method_97591689(iIIiI_Class3 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(1.0f - 0.25f * iIIiI_Class3.hover())).I_method_c1a3a3b6(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.II_field_dd60aac))));
    }

    @Generated
    public float i_method_e92b420f() {
        return this.I_field_46;
    }

    @Generated
    public float II_method_3a8908f2() {
        return this.i_field_46;
    }

    @Generated
    public float Ii_method_3a9794d2() {
        return this.II_field_46;
    }

    @Generated
    public float iI_method_3c4bf912() {
        return this.Ii_field_46;
    }

    @Generated
    public float ii_method_3c5a84f2() {
        return this.iI_field_46;
    }
}

