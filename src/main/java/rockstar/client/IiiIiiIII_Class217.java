package rockstar.client;

import rockstar.client.III;
import rockstar.client.Setting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiiIiiIii_Class220;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iI_Class3;
import rockstar.client.iii_Class8;

public class IiiIiiIII_Class217
extends iii_Class8 {
    private static final iI_Class3 I_field_502d8b81 = new iI_Class3(){

        @Override
        protected void i_method_bdd4e0ec(III iII) {
        }
    };
    private final IiiIiiIii_Class220<?> I_field_a79ba68c;

    public IiiIiiIII_Class217(Setting iIiiiIIII_Class113) {
        this.I_field_a79ba68c = iIIiIIIiI_Class291.I_method_ddfca5e(iIiiiIIII_Class113, I_field_502d8b81);
        this.III_method_9dc17555();
        this.I_method_879bc687(iIiiiIIII_Class113::isVisible);
    }

    @Override
    public float desiredH() {
        return this.I_field_a79ba68c == null ? 0.0f : this.I_field_a79ba68c.Ii_method_2047ead7();
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
    }

    @Override
    protected void drawSelf(III iII, float f) {
        if (this.I_field_a79ba68c == null) {
            return;
        }
        this.I_field_a79ba68c.I_method_b043bcc(this.x(), this.y(), this.w(), this.I_field_a79ba68c.Ii_method_2047ead7());
        this.I_field_a79ba68c.iI_method_2b3782de(this.y());
        this.I_field_a79ba68c.ii_method_2cfa72fe(this.I_field_a79ba68c.Ii_method_2047ead7());
        this.I_field_a79ba68c.I_method_7ae26dda(iII);
    }

    @Override
    public boolean mouseClicked(float f, float f2, IiIII_Class9 iiIII_Class9) {
        if (this.I_field_a79ba68c == null || !this.contains(f, f2)) {
            return false;
        }
        this.I_field_a79ba68c.I_method_400ceaa7(f, f2, iiIII_Class9);
        return true;
    }

    @Override
    public void mouseReleased(float f, float f2, IiIII_Class9 iiIII_Class9) {
        if (this.I_field_a79ba68c != null) {
            this.I_field_a79ba68c.i_method_6a097ac7(f, f2, iiIII_Class9);
        }
        super.mouseReleased(f, f2, iiIII_Class9);
    }

    @Override
    public boolean mouseScrolled(float f, float f2, float f3, float f4) {
        return false;
    }
}

