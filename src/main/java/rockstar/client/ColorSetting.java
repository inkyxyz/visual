package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiI_Class3;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIiiIii_Class156;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iII_Class5;
import rockstar.client.iIiI_Class11;
import rockstar.client.iIii_Class12;
import rockstar.client.iiII_Class13;
import rockstar.client.iii_Class8;

public class ColorSetting
extends AbstractSetting {
    private ColorRGBA I_field_d0c8ec5;
    private boolean I_field_5a = true;
    private transient iIii_Class12 I_field_faf968e1;

    public ColorSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public ColorSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public ColorSetting I_method_a62f5dd6(ColorRGBA colorRGBA) {
        this.I_method_edc01840(colorRGBA);
        return this;
    }

    public void I_method_edc01840(ColorRGBA colorRGBA) {
        if (Objects.equals(this.I_field_d0c8ec5, colorRGBA)) {
            return;
        }
        this.notifyChanged();
        this.I_field_d0c8ec5 = colorRGBA;
    }

    public ColorSetting I_method_af5a85eb(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("r", (Number)Float.valueOf(this.I_field_d0c8ec5.getRed()));
        jsonObject.addProperty("g", (Number)Float.valueOf(this.I_field_d0c8ec5.getGreen()));
        jsonObject.addProperty("b", (Number)Float.valueOf(this.I_field_d0c8ec5.getBlue()));
        jsonObject.addProperty("a", (Number)Float.valueOf(this.I_field_d0c8ec5.getAlpha()));
        return jsonObject;
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (!(this.I_method_2f023659(jsonObject, "r") && this.I_method_2f023659(jsonObject, "g") && this.I_method_2f023659(jsonObject, "b") && this.I_method_2f023659(jsonObject, "a"))) {
            return;
        }
        double d = jsonObject.get("r").getAsDouble();
        double d2 = jsonObject.get("g").getAsDouble();
        double d3 = jsonObject.get("b").getAsDouble();
        double d4 = jsonObject.get("a").getAsDouble();
        if (!(Double.isFinite(d) && Double.isFinite(d2) && Double.isFinite(d3) && Double.isFinite(d4))) {
            return;
        }
        this.I_method_edc01840(new ColorRGBA(this.I_method_528e70b7((int)d), this.I_method_528e70b7((int)d2), this.I_method_528e70b7((int)d3), this.I_method_528e70b7((int)d4)));
    }

    private boolean I_method_2f023659(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && jsonObject.get(string).isJsonPrimitive() && jsonObject.get(string).getAsJsonPrimitive().isNumber() && Double.isFinite(jsonObject.get(string).getAsDouble());
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return false;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return this.I_method_2f023659(jsonObject, "r") && this.I_method_2f023659(jsonObject, "g") && this.I_method_2f023659(jsonObject, "b") && this.I_method_2f023659(jsonObject, "a");
    }

    private int I_method_528e70b7(int n) {
        return MathHelper.clamp((int)n, (int)0, (int)255);
    }

    @Override
    public iii_Class8 createComponent() {
        return new iii_Class8().IiI_method_31d4c97(17.0f).I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_8939bffd(new iIiI_Class11(this::I_method_bde5f08e).I_method_cf493dcb(10.0f, 10.0f).interactive(false)).I_method_70a38517(5.0f).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_b60c4df8((iiIII_Class9, f, f2) -> {
            if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                this.II_method_529cf522();
            }
        }).I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c);
    }

    public void i_method_86d951ff() {
        if (this.I_field_faf968e1 != null && this.I_field_faf968e1.alive()) {
            this.I_field_faf968e1.close();
        }
    }

    private void II_method_529cf522() {
        iIii_Class12 iIii_Class122;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (this.I_field_faf968e1 != null && this.I_field_faf968e1.alive()) {
            return;
        }
        double d = minecraftClient.getWindow().getScaleFactor();
        float f = (float)(minecraftClient.mouse.getX() / d);
        float f2 = (float)(minecraftClient.mouse.getY() / d);
        ColorRGBA colorRGBA = this.I_field_d0c8ec5 != null ? this.I_field_d0c8ec5 : ColorRGBA.WHITE;
        iIii_Class12 iIii_Class123 = new iIii_Class12(f, f2, this.I_field_5a, colorRGBA, IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a), this::I_method_a62f5dd6);
        Screen screen = minecraftClient.currentScreen;
        if (screen instanceof IIiI_Class3) {
            IIiI_Class3 iIiI_Class3 = (IIiI_Class3)screen;
            iIii_Class122 = iIiI_Class3.openWindow(iIii_Class123);
        } else {
            iIii_Class122 = IiIIiiIii_Class156.I_method_82b97efd(iIii_Class123);
        }
        this.I_field_faf968e1 = iIii_Class122;
    }

    @Generated
    public ColorRGBA I_method_bde5f08e() {
        return this.I_field_d0c8ec5;
    }

    @Generated
    public boolean i_method_9b12da03() {
        return this.I_field_5a;
    }

    @Generated
    public iIii_Class12 I_method_fe0b4ab8() {
        return this.I_field_faf968e1;
    }
}

