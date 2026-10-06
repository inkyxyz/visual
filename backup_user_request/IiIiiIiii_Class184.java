package rockstar.client;

import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIiiI_Class183;
import rockstar.client.IiIiiiIII_Class185;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.iiI_Class7;

public abstract class IiIiiIiii_Class184
extends MultiSelectSetting.Nested1_42856060
implements iIIiIIiiI_Class295 {
    protected IiIiiIiiI_Class183 size = new IiIiiIiiI_Class183(48.0f, 15.0f, 7.0f);
    protected final IiiiIiIii_Class236 animation = new IiiiIiIii_Class236(500L, IiiiIiiII_Class237.Ii_field_dd60aac);
    private iiI_Class7 element;

    public IiIiiIiii_Class184(MultiSelectSetting iIiiiiiii_Class128, String string) {
        this(iIiiiiiii_Class128, string, true);
    }

    public IiIiiIiii_Class184(MultiSelectSetting iIiiiiiii_Class128, String string, boolean bl) {
        super(iIiiiiiii_Class128, (String)(bl ? "hud.dynamic_island.statuses." + string : IiIiiIiii_Class184.sanitizeName(string)));
        this.select();
    }

    public final iiI_Class7 element(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        if (this.element == null) {
            this.element = new IiIiiiIII_Class185(this, iiIiiIIII_Class177);
        }
        return this.element;
    }

    public boolean isExpandable() {
        return false;
    }

    public boolean drawsOwnBackground() {
        return false;
    }

    public void prepare(IiIiiIIII_Class177 iiIiiIIII_Class177) {
    }

    public iiI_Class7 content(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        return null;
    }

    public float radius(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        return 7.0f;
    }

    public void render(III iII, IiIiiIIII_Class177 iiIiiIIII_Class177, float f, float f2, float f3, float f4, float f5) {
    }

    public void click(float f, float f2, int n) {
    }

    public abstract boolean canShow();

    public ColorRGBA getColor() {
        return IiiiiIIIi_Class242.II_method_190e6391();
    }

    private static String sanitizeName(String string) {
        return string == null || string.isBlank() ? "Script Status" : string.trim();
    }

    @Generated
    public IiIiiIiiI_Class183 getSize() {
        return this.size;
    }

    @Generated
    public IiiiIiIii_Class236 getAnimation() {
        return this.animation;
    }

    @Generated
    public iiI_Class7 getElement() {
        return this.element;
    }
}

