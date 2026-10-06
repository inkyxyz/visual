package rockstar.client;

import lombok.NonNull;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;

public class IiiiIiiIi_Class238 {
    private static final IiiiIiiII_Class237 I_field_dd60aac = IiiiIiiII_Class237.IIIi_field_dd60aac;
    private final long I_field_4a;
    private final IiiiIiIii_Class236 I_field_dc7facc;
    private final IiiiIiIii_Class236 i_field_dc7facc;
    private final IiiiIiIii_Class236 II_field_dc7facc;
    private final IiiiIiIii_Class236 Ii_field_dc7facc;

    public IiiiIiiIi_Class238(long l, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_4a = l;
        this.I_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
        this.i_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
        this.II_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
        this.Ii_field_dc7facc = new IiiiIiIii_Class236(l, iiiiIiiII_Class237);
    }

    public IiiiIiiIi_Class238(long l) {
        this(l, I_field_dd60aac);
    }

    public IiiiIiiIi_Class238(long l, ColorRGBA colorRGBA, IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_4a = l;
        this.I_field_dc7facc = new IiiiIiIii_Class236(l, colorRGBA.getRed(), iiiiIiiII_Class237);
        this.i_field_dc7facc = new IiiiIiIii_Class236(l, colorRGBA.getGreen(), iiiiIiiII_Class237);
        this.II_field_dc7facc = new IiiiIiIii_Class236(l, colorRGBA.getBlue(), iiiiIiiII_Class237);
        this.Ii_field_dc7facc = new IiiiIiIii_Class236(l, colorRGBA.getAlpha(), iiiiIiiII_Class237);
    }

    public IiiiIiiIi_Class238(long l, ColorRGBA colorRGBA) {
        this(l, colorRGBA, I_field_dd60aac);
    }

    public void I_method_8895420(@NonNull ColorRGBA colorRGBA) {
        if (colorRGBA == null) {
            throw new NullPointerException("targetColor is marked non-null but is null");
        }
        this.I_field_dc7facc.I_method_edd6dd11(colorRGBA.getRed());
        this.i_field_dc7facc.I_method_edd6dd11(colorRGBA.getGreen());
        this.II_field_dc7facc.I_method_edd6dd11(colorRGBA.getBlue());
        this.Ii_field_dc7facc.I_method_edd6dd11(colorRGBA.getAlpha());
    }

    public ColorRGBA I_method_915b8ae() {
        return new ColorRGBA((int)this.I_field_dc7facc.I_method_6ac4da6f(), (int)this.i_field_dc7facc.I_method_6ac4da6f(), (int)this.II_field_dc7facc.I_method_6ac4da6f(), (int)this.Ii_field_dc7facc.I_method_6ac4da6f());
    }

    public void I_method_164f04c7(IiiiIiiII_Class237 iiiiIiiII_Class237) {
        this.I_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
        this.i_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
        this.II_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
        this.Ii_field_dc7facc.I_method_df2f9087(iiiiIiiII_Class237);
    }

    public void I_method_7a3f3065(long l) {
        this.I_field_dc7facc.I_method_edd6ec25(l);
        this.i_field_dc7facc.I_method_edd6ec25(l);
        this.II_field_dc7facc.I_method_edd6ec25(l);
        this.Ii_field_dc7facc.I_method_edd6ec25(l);
    }

    public void i_method_7d83c440(@NonNull ColorRGBA colorRGBA) {
        if (colorRGBA == null) {
            throw new NullPointerException("color is marked non-null but is null");
        }
        this.I_field_dc7facc.I_method_edd6dd21(colorRGBA.getRed());
        this.i_field_dc7facc.I_method_edd6dd21(colorRGBA.getGreen());
        this.II_field_dc7facc.I_method_edd6dd21(colorRGBA.getBlue());
        this.Ii_field_dc7facc.I_method_edd6dd21(colorRGBA.getAlpha());
    }
}

