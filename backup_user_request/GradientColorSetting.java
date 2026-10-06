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

public class GradientColorSetting
extends AbstractSetting {
    private ColorRGBA I_field_d0c8ec5;
    private ColorRGBA i_field_d0c8ec5;
    private boolean I_field_5a = true;
    private transient iIii_Class12 I_field_faf968e1;
    private transient iIii_Class12 i_field_faf968e1;

    public GradientColorSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public GradientColorSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public GradientColorSetting I_method_1119eb95(ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        if (Objects.equals(this.I_field_d0c8ec5, colorRGBA) && Objects.equals(this.i_field_d0c8ec5, colorRGBA2)) {
            return this;
        }
        this.notifyChanged();
        this.I_field_d0c8ec5 = colorRGBA;
        this.i_field_d0c8ec5 = colorRGBA2;
        return this;
    }

    public GradientColorSetting I_method_3431d5d6(ColorRGBA colorRGBA) {
        this.I_method_b15f4c00(colorRGBA);
        return this;
    }

    public void I_method_b15f4c00(ColorRGBA colorRGBA) {
        if (Objects.equals(this.I_field_d0c8ec5, colorRGBA)) {
            return;
        }
        this.notifyChanged();
        this.I_field_d0c8ec5 = colorRGBA;
    }

    public GradientColorSetting i_method_a6225df6(ColorRGBA colorRGBA) {
        this.i_method_2659bc20(colorRGBA);
        return this;
    }

    public void i_method_2659bc20(ColorRGBA colorRGBA) {
        if (Objects.equals(this.i_field_d0c8ec5, colorRGBA)) {
            return;
        }
        this.notifyChanged();
        this.i_field_d0c8ec5 = colorRGBA;
    }

    public GradientColorSetting I_method_985bfdeb(boolean bl) {
        this.I_field_5a = bl;
        return this;
    }

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("first", (JsonElement)this.I_method_34ddc742(this.I_field_d0c8ec5));
        jsonObject.add("second", (JsonElement)this.I_method_34ddc742(this.i_field_d0c8ec5));
        return jsonObject;
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (!(jsonObject.has("first") && jsonObject.get("first").isJsonObject() && jsonObject.has("second") && jsonObject.get("second").isJsonObject())) {
            return;
        }
        ColorRGBA colorRGBA = this.I_method_96c97fa(jsonObject.getAsJsonObject("first"));
        ColorRGBA colorRGBA2 = this.I_method_96c97fa(jsonObject.getAsJsonObject("second"));
        if (colorRGBA != null && colorRGBA2 != null) {
            this.I_method_1119eb95(colorRGBA, colorRGBA2);
        }
    }

    private JsonObject I_method_34ddc742(ColorRGBA colorRGBA) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("r", (Number)Float.valueOf(colorRGBA.getRed()));
        jsonObject.addProperty("g", (Number)Float.valueOf(colorRGBA.getGreen()));
        jsonObject.addProperty("b", (Number)Float.valueOf(colorRGBA.getBlue()));
        jsonObject.addProperty("a", (Number)Float.valueOf(colorRGBA.getAlpha()));
        return jsonObject;
    }

    private ColorRGBA I_method_96c97fa(JsonObject jsonObject) {
        if (!(this.I_method_1b451a99(jsonObject, "r") && this.I_method_1b451a99(jsonObject, "g") && this.I_method_1b451a99(jsonObject, "b") && this.I_method_1b451a99(jsonObject, "a"))) {
            return null;
        }
        double d = jsonObject.get("r").getAsDouble();
        double d2 = jsonObject.get("g").getAsDouble();
        double d3 = jsonObject.get("b").getAsDouble();
        double d4 = jsonObject.get("a").getAsDouble();
        if (!(Double.isFinite(d) && Double.isFinite(d2) && Double.isFinite(d3) && Double.isFinite(d4))) {
            return null;
        }
        return new ColorRGBA(this.I_method_b1eca477((int)d), this.I_method_b1eca477((int)d2), this.I_method_b1eca477((int)d3), this.I_method_b1eca477((int)d4));
    }

    private boolean I_method_1b451a99(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && jsonObject.get(string).isJsonPrimitive() && jsonObject.get(string).getAsJsonPrimitive().isNumber() && Double.isFinite(jsonObject.get(string).getAsDouble());
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return false;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return jsonObject.has("first") && jsonObject.get("first").isJsonObject() && jsonObject.has("second") && jsonObject.get("second").isJsonObject() && this.I_method_96c97fa(jsonObject.getAsJsonObject("first")) != null && this.I_method_96c97fa(jsonObject.getAsJsonObject("second")) != null;
    }

    private int I_method_b1eca477(int n) {
        return MathHelper.clamp((int)n, (int)0, (int)255);
    }

    @Override
    public iii_Class8 createComponent() {
        iii_Class8 iii_Class82 = new iii_Class8().I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_70a38517(3.0f).I_method_8939bffd(new iIiI_Class11(this::I_method_b3b144ce).I_method_cf493dcb(10.0f, 10.0f).cursor(iIIIiIIIi_Class274.i_field_aa52e62c).onClick((iiIII_Class9, f, f2) -> {
            if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                this.I_method_b1ece455(true);
            }
        })).I_method_8939bffd(new iIiI_Class11(this::i_method_3b9850ae).I_method_cf493dcb(10.0f, 10.0f).cursor(iIIIiIIIi_Class274.i_field_aa52e62c).onClick((iiIII_Class9, f, f2) -> {
            if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                this.I_method_b1ece455(false);
            }
        }));
        return new iii_Class8().IiI_method_31d4c97(17.0f).I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_8939bffd(iii_Class82).I_method_70a38517(5.0f).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_483797dd(IIi_Class2.i_field_b5755e8c);
    }

    private void I_method_b1ece455(boolean bl) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        double d = minecraftClient.getWindow().getScaleFactor();
        float f = (float)(minecraftClient.mouse.getX() / d);
        float f2 = (float)(minecraftClient.mouse.getY() / d);
        if (bl) {
            if (this.I_field_faf968e1 != null && this.I_field_faf968e1.alive()) {
                return;
            }
            ColorRGBA colorRGBA = this.I_field_d0c8ec5 != null ? this.I_field_d0c8ec5 : ColorRGBA.WHITE;
            this.I_field_faf968e1 = GradientColorSetting.I_method_112851f7(new iIii_Class12(f, f2, this.I_field_5a, colorRGBA, IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a), this::I_method_3431d5d6));
        } else {
            if (this.i_field_faf968e1 != null && this.i_field_faf968e1.alive()) {
                return;
            }
            ColorRGBA colorRGBA = this.i_field_d0c8ec5 != null ? this.i_field_d0c8ec5 : ColorRGBA.WHITE;
            this.i_field_faf968e1 = GradientColorSetting.I_method_112851f7(new iIii_Class12(f, f2, this.I_field_5a, colorRGBA, IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a), this::i_method_a6225df6));
        }
    }

    private static iIii_Class12 I_method_112851f7(iIii_Class12 iIii_Class122) {
        iIii_Class12 iIii_Class123;
        Screen screen = MinecraftClient.getInstance().currentScreen;
        if (screen instanceof IIiI_Class3) {
            IIiI_Class3 iIiI_Class3 = (IIiI_Class3)screen;
            iIii_Class123 = iIiI_Class3.openWindow(iIii_Class122);
        } else {
            iIii_Class123 = IiIIiiIii_Class156.I_method_82b97efd(iIii_Class122);
        }
        return iIii_Class123;
    }

    @Generated
    public ColorRGBA I_method_b3b144ce() {
        return this.I_field_d0c8ec5;
    }

    @Generated
    public ColorRGBA i_method_3b9850ae() {
        return this.i_field_d0c8ec5;
    }

    @Generated
    public boolean i_method_9b12da03() {
        return this.I_field_5a;
    }

    @Generated
    public iIii_Class12 I_method_ee0a1e78() {
        return this.I_field_faf968e1;
    }

    @Generated
    public iIii_Class12 i_method_7413be98() {
        return this.i_field_faf968e1;
    }
}

