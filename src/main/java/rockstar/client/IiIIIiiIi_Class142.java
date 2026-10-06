package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Objects;
import lombok.Generated;
import pyrock.utility.render.ColorRGBA;

public class IiIIIiiIi_Class142 {
    private ColorRGBA I_field_d0c8ec5;
    private ColorRGBA i_field_d0c8ec5;
    private ColorRGBA II_field_d0c8ec5;
    private ColorRGBA Ii_field_d0c8ec5;
    private ColorRGBA iI_field_d0c8ec5;
    private ColorRGBA ii_field_d0c8ec5;
    private ColorRGBA III_field_d0c8ec5;
    private ColorRGBA IIi_field_d0c8ec5;
    private float I_field_46;
    private float i_field_46;
    private float II_field_46;
    private float Ii_field_46;
    private float iI_field_46;
    private float ii_field_46;
    private float III_field_46;
    private float IIi_field_46;
    private float IiI_field_46;
    private float Iii_field_46;

    public JsonObject I_method_1acf19a3() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("accent", (JsonElement)this.I_field_d0c8ec5.toJson());
        jsonObject.add("background", (JsonElement)this.i_field_d0c8ec5.toJson());
        jsonObject.add("additional", (JsonElement)this.II_field_d0c8ec5.toJson());
        jsonObject.add("text", (JsonElement)this.Ii_field_d0c8ec5.toJson());
        jsonObject.add("outline", (JsonElement)this.iI_field_d0c8ec5.toJson());
        jsonObject.add("flat", (JsonElement)this.ii_field_d0c8ec5.toJson());
        jsonObject.add("icons", (JsonElement)this.III_field_d0c8ec5.toJson());
        jsonObject.add("enabledModules", (JsonElement)this.IIi_field_d0c8ec5.toJson());
        jsonObject.addProperty("hudRounding", (Number)Float.valueOf(this.I_field_46));
        jsonObject.addProperty("blurOffset", (Number)Float.valueOf(this.i_field_46));
        jsonObject.addProperty("hudAlpha", (Number)Float.valueOf(this.II_field_46));
        jsonObject.addProperty("disalphaGlass", (Number)Float.valueOf(this.Ii_field_46));
        jsonObject.addProperty("glassPower", (Number)Float.valueOf(this.iI_field_46));
        jsonObject.addProperty("glassStreng", (Number)Float.valueOf(this.ii_field_46));
        jsonObject.addProperty("many", (Number)Float.valueOf(this.IIi_field_46));
        jsonObject.addProperty("padding", (Number)Float.valueOf(this.III_field_46));
        jsonObject.addProperty("splitters", (Number)Float.valueOf(this.IiI_field_46));
        jsonObject.addProperty("albomColor", (Number)Float.valueOf(this.Iii_field_46));
        return jsonObject;
    }

    public static IiIIIiiIi_Class142 I_method_3f43a761(JsonObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        float f = jsonObject.has("hudRounding") ? jsonObject.get("hudRounding").getAsFloat() : 0.0f;
        float f2 = jsonObject.has("blurOffset") ? jsonObject.get("blurOffset").getAsFloat() : 0.0f;
        float f3 = jsonObject.has("hudAlpha") ? jsonObject.get("hudAlpha").getAsFloat() : 0.0f;
        float f4 = jsonObject.has("disalphaGlass") ? jsonObject.get("disalphaGlass").getAsFloat() : 0.0f;
        float f5 = jsonObject.has("glassPower") ? jsonObject.get("glassPower").getAsFloat() : 0.0f;
        float f6 = jsonObject.has("glassStreng") ? jsonObject.get("glassStreng").getAsFloat() : 0.0f;
        float f7 = jsonObject.has("many") ? jsonObject.get("many").getAsFloat() : 0.0f;
        float f8 = jsonObject.has("padding") ? jsonObject.get("padding").getAsFloat() : 0.0f;
        float f9 = jsonObject.has("splitters") ? jsonObject.get("splitters").getAsFloat() : 0.0f;
        float f10 = jsonObject.has("albomColor") ? jsonObject.get("albomColor").getAsFloat() : 0.0f;
        ColorRGBA colorRGBA = jsonObject.has("accent") ? ColorRGBA.fromJson(jsonObject.getAsJsonObject("accent")) : new ColorRGBA(0.0f, 0.0f, 0.0f, 0.0f);
        ColorRGBA colorRGBA2 = jsonObject.has("background") ? ColorRGBA.fromJson(jsonObject.getAsJsonObject("background")) : new ColorRGBA(0.0f, 0.0f, 0.0f, 0.0f);
        ColorRGBA colorRGBA3 = jsonObject.has("additional") ? ColorRGBA.fromJson(jsonObject.getAsJsonObject("additional")) : new ColorRGBA(0.0f, 0.0f, 0.0f, 0.0f);
        ColorRGBA colorRGBA4 = jsonObject.has("text") ? ColorRGBA.fromJson(jsonObject.getAsJsonObject("text")) : new ColorRGBA(255.0f, 255.0f, 255.0f, 255.0f);
        ColorRGBA colorRGBA5 = jsonObject.has("outline") ? ColorRGBA.fromJson(jsonObject.getAsJsonObject("outline")) : new ColorRGBA(0.0f, 0.0f, 0.0f, 0.0f);
        ColorRGBA colorRGBA6 = jsonObject.has("flat") ? ColorRGBA.fromJson(jsonObject.getAsJsonObject("flat")) : new ColorRGBA(0.0f, 0.0f, 0.0f, 0.0f);
        ColorRGBA colorRGBA7 = jsonObject.has("icons") ? ColorRGBA.fromJson(jsonObject.getAsJsonObject("icons")) : colorRGBA4;
        ColorRGBA colorRGBA8 = jsonObject.has("enabledModules") ? ColorRGBA.fromJson(jsonObject.getAsJsonObject("enabledModules")) : colorRGBA4;
        return new IiIIIiiIi_Class142(colorRGBA, colorRGBA2, colorRGBA3, colorRGBA4, colorRGBA5, colorRGBA6, colorRGBA7, colorRGBA8, f, f2, f3, f4, f5, f6, f8, f7, f9, f10);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        IiIIIiiIi_Class142 iiIIIiiIi_Class142 = (IiIIIiiIi_Class142)object;
        return Float.compare(this.I_field_46, iiIIIiiIi_Class142.I_field_46) == 0 && Float.compare(this.i_field_46, iiIIIiiIi_Class142.i_field_46) == 0 && Float.compare(this.II_field_46, iiIIIiiIi_Class142.II_field_46) == 0 && Float.compare(this.Ii_field_46, iiIIIiiIi_Class142.Ii_field_46) == 0 && Float.compare(this.iI_field_46, iiIIIiiIi_Class142.iI_field_46) == 0 && Float.compare(this.ii_field_46, iiIIIiiIi_Class142.ii_field_46) == 0 && Float.compare(this.III_field_46, iiIIIiiIi_Class142.III_field_46) == 0 && Float.compare(this.IIi_field_46, iiIIIiiIi_Class142.IIi_field_46) == 0 && Float.compare(this.IiI_field_46, iiIIIiiIi_Class142.IiI_field_46) == 0 && Float.compare(this.Iii_field_46, iiIIIiiIi_Class142.Iii_field_46) == 0 && Objects.equals(this.I_field_d0c8ec5, iiIIIiiIi_Class142.I_field_d0c8ec5) && Objects.equals(this.i_field_d0c8ec5, iiIIIiiIi_Class142.i_field_d0c8ec5) && Objects.equals(this.II_field_d0c8ec5, iiIIIiiIi_Class142.II_field_d0c8ec5) && Objects.equals(this.Ii_field_d0c8ec5, iiIIIiiIi_Class142.Ii_field_d0c8ec5) && Objects.equals(this.iI_field_d0c8ec5, iiIIIiiIi_Class142.iI_field_d0c8ec5) && Objects.equals(this.ii_field_d0c8ec5, iiIIIiiIi_Class142.ii_field_d0c8ec5) && Objects.equals(this.III_field_d0c8ec5, iiIIIiiIi_Class142.III_field_d0c8ec5) && Objects.equals(this.IIi_field_d0c8ec5, iiIIIiiIi_Class142.IIi_field_d0c8ec5);
    }

    public int hashCode() {
        return Objects.hash(this.I_field_d0c8ec5, this.i_field_d0c8ec5, this.II_field_d0c8ec5, this.Ii_field_d0c8ec5, this.iI_field_d0c8ec5, this.ii_field_d0c8ec5, this.III_field_d0c8ec5, this.IIi_field_d0c8ec5, Float.valueOf(this.I_field_46), Float.valueOf(this.i_field_46), Float.valueOf(this.II_field_46), Float.valueOf(this.Ii_field_46), Float.valueOf(this.iI_field_46), Float.valueOf(this.ii_field_46), Float.valueOf(this.III_field_46), Float.valueOf(this.IIi_field_46), Float.valueOf(this.IiI_field_46), Float.valueOf(this.Iii_field_46));
    }

    public IiIIIiiIi_Class142 I_method_b2a01335() {
        return new IiIIIiiIi_Class142(this.I_field_d0c8ec5, this.i_field_d0c8ec5, this.II_field_d0c8ec5, this.Ii_field_d0c8ec5, this.iI_field_d0c8ec5, this.ii_field_d0c8ec5, this.III_field_d0c8ec5, this.IIi_field_d0c8ec5, this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46, this.iI_field_46, this.ii_field_46, this.III_field_46, this.IIi_field_46, this.IiI_field_46, this.Iii_field_46);
    }

    @Generated
    public ColorRGBA I_method_35ab4ae() {
        return this.I_field_d0c8ec5;
    }

    @Generated
    public ColorRGBA i_method_8b41c08e() {
        return this.i_field_d0c8ec5;
    }

    @Generated
    public ColorRGBA II_method_3fe71371() {
        return this.II_field_d0c8ec5;
    }

    @Generated
    public ColorRGBA Ii_method_c7ce1f51() {
        return this.Ii_field_d0c8ec5;
    }

    @Generated
    public ColorRGBA iI_method_b4e18391() {
        return this.iI_field_d0c8ec5;
    }

    @Generated
    public ColorRGBA ii_method_3cc88f71() {
        return this.ii_field_d0c8ec5;
    }

    @Generated
    public ColorRGBA III_method_94e68d0e() {
        return this.III_field_d0c8ec5;
    }

    @Generated
    public ColorRGBA IIi_method_1ccd98ee() {
        return this.IIi_field_d0c8ec5;
    }

    @Generated
    public float I_method_37580a2f() {
        return this.I_field_46;
    }

    @Generated
    public float i_method_3766960f() {
        return this.i_field_46;
    }

    @Generated
    public float II_method_b3b834f2() {
        return this.II_field_46;
    }

    @Generated
    public float Ii_method_b3c6c0d2() {
        return this.Ii_field_46;
    }

    @Generated
    public float iI_method_b57b2512() {
        return this.iI_field_46;
    }

    @Generated
    public float ii_method_b589b0f2() {
        return this.ii_field_46;
    }

    @Generated
    public float III_method_c35d628f() {
        return this.III_field_46;
    }

    @Generated
    public float IIi_method_c36bee6f() {
        return this.IIi_field_46;
    }

    @Generated
    public float IiI_method_c52052af() {
        return this.IiI_field_46;
    }

    @Generated
    public float Iii_method_c52ede8f() {
        return this.Iii_field_46;
    }

    @Generated
    public IiIIIiiIi_Class142 I_method_751559d6(ColorRGBA colorRGBA) {
        this.I_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 i_method_e705e1f6(ColorRGBA colorRGBA) {
        this.i_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 II_method_f0f6d933(ColorRGBA colorRGBA) {
        this.II_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 Ii_method_62e76153(ColorRGBA colorRGBA) {
        this.Ii_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 iI_method_bd175513(ColorRGBA colorRGBA) {
        this.iI_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 ii_method_2f07dd33(ColorRGBA colorRGBA) {
        this.ii_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 III_method_f1454576(ColorRGBA colorRGBA) {
        this.III_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 IIi_method_6335cd96(ColorRGBA colorRGBA) {
        this.IIi_field_d0c8ec5 = colorRGBA;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 I_method_2d9a27d7(float f) {
        this.I_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 i_method_cab32ff7(float f) {
        this.i_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 II_method_afa85b34(float f) {
        this.II_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 Ii_method_4cc16354(float f) {
        this.Ii_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 iI_method_b5b05714(float f) {
        this.iI_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 ii_method_52c95f34(float f) {
        this.ii_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 III_method_6f609377(float f) {
        this.III_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 IIi_method_c799b97(float f) {
        this.IIi_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 IiI_method_75688f57(float f) {
        this.IiI_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142 Iii_method_12819777(float f) {
        this.Iii_field_46 = f;
        return this;
    }

    @Generated
    public IiIIIiiIi_Class142(ColorRGBA colorRGBA, ColorRGBA colorRGBA2, ColorRGBA colorRGBA3, ColorRGBA colorRGBA4, ColorRGBA colorRGBA5, ColorRGBA colorRGBA6, ColorRGBA colorRGBA7, ColorRGBA colorRGBA8, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.I_field_d0c8ec5 = colorRGBA;
        this.i_field_d0c8ec5 = colorRGBA2;
        this.II_field_d0c8ec5 = colorRGBA3;
        this.Ii_field_d0c8ec5 = colorRGBA4;
        this.iI_field_d0c8ec5 = colorRGBA5;
        this.ii_field_d0c8ec5 = colorRGBA6;
        this.III_field_d0c8ec5 = colorRGBA7;
        this.IIi_field_d0c8ec5 = colorRGBA8;
        this.I_field_46 = f;
        this.i_field_46 = f2;
        this.II_field_46 = f3;
        this.Ii_field_46 = f4;
        this.iI_field_46 = f5;
        this.ii_field_46 = f6;
        this.III_field_46 = f7;
        this.IIi_field_46 = f8;
        this.IiI_field_46 = f9;
        this.Iii_field_46 = f10;
    }
}

