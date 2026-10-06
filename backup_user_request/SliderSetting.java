package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
import rockstar.client.IIII;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIIii_Class4;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiIiiii_Class112;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iII_Class5;
import rockstar.client.iiII_Class13;
import rockstar.client.iii_Class8;
import rockstar.client.iiii_Class16;

public class SliderSetting
extends AbstractSetting {
    protected float I_field_46;
    protected float i_field_46;
    protected float II_field_46;
    protected float Ii_field_46;
    private Nested1_71cc1040 I_field_b6dce47 = f -> "";
    private IIiiIiiii_Class112<Float> I_field_8548a68c = f -> f;

    public SliderSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public SliderSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public SliderSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2) {
        super(iIiiiIIiI_Class115, string);
    }

    public SliderSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public SliderSetting I_method_c8c9a7d7(float f) {
        this.I_field_46 = f;
        return this;
    }

    public SliderSetting i_method_65e2aff7(float f) {
        this.i_field_46 = f;
        return this;
    }

    public SliderSetting II_method_b0f56334(float f) {
        this.II_field_46 = f;
        return this;
    }

    public SliderSetting I_method_bfc3b958(Nested1_71cc1040 nested1_71cc1040) {
        this.I_field_b6dce47 = nested1_71cc1040;
        return this;
    }

    public SliderSetting I_method_d41e7abf(String string) {
        this.I_field_b6dce47 = f -> string;
        return this;
    }

    public SliderSetting I_method_a8d4839d(IIiiIiiii_Class112<Float> iIiiIiiii_Class112) {
        this.I_field_8548a68c = iIiiIiiii_Class112;
        return this;
    }

    public SliderSetting Ii_method_4e0e6b54(float f) {
        this.I_method_a1eda161(f);
        return this;
    }

    public String II_method_d429a7de() {
        return this.I_field_b6dce47.apply(this.Ii_method_a20abcd2()).contains(" ") ? " " + IiIiIIII_Class81.I_method_f25a980a(this.I_field_b6dce47.apply(this.Ii_method_a20abcd2()).replace(" ", "")) : IiIiIIII_Class81.I_method_f25a980a(this.I_field_b6dce47.apply(this.Ii_method_a20abcd2()));
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive((Number)Float.valueOf(this.Ii_field_46));
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        float f;
        if (jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber() && Float.isFinite(f = jsonElement.getAsFloat())) {
            this.I_method_a1eda161(f);
        }
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        return jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber() && Float.isFinite(jsonElement.getAsFloat());
    }

    public void I_method_a1eda161(float f) {
        float f2 = MathHelper.clamp((float)((float)((double)Math.round((double)(f = this.I_field_8548a68c.changed(Float.valueOf(f)).floatValue()) * (1.0 / (double)this.II_field_46)) / (1.0 / (double)this.II_field_46))), (float)this.I_field_46, (float)this.i_field_46);
        if (this.Ii_field_46 == f2) {
            return;
        }
        this.notifyChanged();
        this.Ii_field_46 = f2;
    }

    @Override
    public iii_Class8 createComponent() {
        iii_Class8 iii_Class82 = new iii_Class8().I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_8939bffd(new iiii_Class16(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), this::Ii_method_a20abcd2, this::I_method_a1eda161, this.I_field_46, this.i_field_46).I_method_c389f5c5(() -> iIIIIiIiI_Class267.I_method_230e44c1(this.Ii_method_a20abcd2())).i_method_6f9c9a5(this::II_method_d429a7de).I_method_46f30bd1(iiii_Class162 -> IiiiiIIIi_Class242.ii_field_d0c8ec5)).I_method_70a38517(6.0f).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0f, 0.0f, 0.0f, 0.0f)).III_method_9dc17555();
        return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_70a38517(5.0f).I_method_8939bffd(iii_Class82).I_method_8939bffd(new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).III_method_9dc17555().I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0f, 0.0f, 4.0f, 0.0f)).I_method_8939bffd(new IIIii_Class4(this::Ii_method_a20abcd2, this::I_method_a1eda161, this.I_method_b2a48e2f(), this.i_method_b2b31a0f()).I_method_ec139357(this.II_method_a1fc30f2()).I_method_d614f735().ii_method_626eab4(6.0f).i_method_1635ab77(3.0f).II_method_c1e3e6b4(3.0f).Ii_method_ec05fed4(1.5f).I_method_1f4f9269(iIIii_Class4 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5).i_method_49da3a89(iIIii_Class4 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(1.0f - 0.25f * iIIii_Class4.hover())).I_method_f6d86b76(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.II_field_dd60aac))));
    }

    @Generated
    public float I_method_b2a48e2f() {
        return this.I_field_46;
    }

    @Generated
    public float i_method_b2b31a0f() {
        return this.i_field_46;
    }

    @Generated
    public float II_method_a1fc30f2() {
        return this.II_field_46;
    }

    @Generated
    public float Ii_method_a20abcd2() {
        return this.Ii_field_46;
    }

    @Generated
    public IIiiIiiii_Class112<Float> I_method_43ef3335() {
        return this.I_field_8548a68c;
    }

    public static interface Nested1_71cc1040 {
        public String apply(float var1);
    }
}

