package pyrock.classes;

import java.util.Locale;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;

public class PyTheme {
    public ColorRGBA color(String string) {
        if (string == null) {
            return IiiiiIIIi_Class242.iII_field_d0c8ec5;
        }
        return switch (string.toLowerCase(Locale.ROOT)) {
            case "accent" -> IiiiiIIIi_Class242.ii_field_d0c8ec5;
            case "background", "bg" -> IiiiiIIIi_Class242.II_method_190e6391();
            case "second", "additional" -> IiiiiIIIi_Class242.IIi_field_d0c8ec5;
            case "outline", "border" -> IiiiiIIIi_Class242.IiI_field_d0c8ec5;
            case "shadow" -> IiiiiIIIi_Class242.Iii_field_d0c8ec5;
            case "on_accent", "onaccent" -> IiiiiIIIi_Class242.iIi_field_d0c8ec5;
            case "flat" -> IiiiiIIIi_Class242.ii_method_15efdf91();
            case "separator" -> IiiiiIIIi_Class242.IIi_method_68904cce();
            case "white" -> IiiiiIIIi_Class242.Ii_field_d0c8ec5;
            case "black" -> IiiiiIIIi_Class242.iI_field_d0c8ec5;
            default -> IiiiiIIIi_Class242.iII_field_d0c8ec5;
        };
    }

    public ColorRGBA accent() {
        return IiiiiIIIi_Class242.ii_field_d0c8ec5;
    }

    public ColorRGBA text() {
        return IiiiiIIIi_Class242.iII_field_d0c8ec5;
    }

    public ColorRGBA background() {
        return IiiiiIIIi_Class242.II_method_190e6391();
    }

    public ColorRGBA second() {
        return IiiiiIIIi_Class242.IIi_field_d0c8ec5;
    }

    public ColorRGBA outline() {
        return IiiiiIIIi_Class242.IiI_field_d0c8ec5;
    }

    public ColorRGBA onAccent() {
        return IiiiiIIIi_Class242.iIi_field_d0c8ec5;
    }

    public ColorRGBA readable(ColorRGBA colorRGBA) {
        return colorRGBA == null ? IiiiiIIIi_Class242.iII_field_d0c8ec5 : IiiiiIIIi_Class242.I_method_35ed8eaf(colorRGBA);
    }

    public void setAccent(ColorRGBA colorRGBA) {
        if (colorRGBA != null) {
            IiiiiIIIi_Class242.I_method_300b2840(colorRGBA);
        }
    }

    public String name() {
        try {
            return RockstarClient.getInstance().I_method_9a720c62().I_method_ac8a0395().name().toLowerCase(Locale.ROOT);
        }
        catch (Throwable throwable) {
            return "dark";
        }
    }

    public boolean dark() {
        return "dark".equals(this.name());
    }
}

