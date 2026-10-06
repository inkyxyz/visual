package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IiIiIIIiI_Class163;
import rockstar.client.IiIiIIiII_Class165;
import rockstar.client.IiIiIiIIi_Class170;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiiI_Class295;

public class IiIiIIIIi_Class162 {
    private final List<IiIiIIIiI_Class163> I_field_7865b31 = new ArrayList<IiIiIIIiI_Class163>();

    public void I_method_c0a9659d(CustomDrawContext customDrawContext) {
        for (IiIiIIIiI_Class163 iiIiIIIiI_Class163 : this.I_field_7865b31) {
            if (!iiIiIIIiI_Class163.I_method_b5673aa3()) continue;
            float f = iiIiIIIiI_Class163.I_method_9c247570() == IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7 ? iiIiIIIiI_Class163.I_method_b5673a8f() - 0.5f : 0.0f;
            float f2 = iiIiIIIiI_Class163.I_method_9c247570() == IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7 ? iiIiIIIiI_Class163.I_method_b5673a8f() - 0.5f : 0.0f;
            float f3 = iiIiIIIiI_Class163.I_method_9c247570() == IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7 ? 1.0f : iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f();
            float f4 = iiIiIIIiI_Class163.I_method_9c247570() == IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7 ? 1.0f : iIIiIIiiI_Class295.I_field_73c6d26c.i_method_805d6def();
            customDrawContext.drawRect(f, f2, f3, f4, ColorRGBA.WHITE.mulAlpha(0.3f));
        }
    }

    public void I_method_4f3ae65f() {
        this.I_field_7865b31.clear();
        this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7, 0.0f));
        this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7, iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() * 0.5f));
        this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7, iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f()));
        this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7, 0.0f));
        this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7, iIIiIIiiI_Class295.I_field_73c6d26c.i_method_805d6def() * 0.5f));
        this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7, iIIiIIiiI_Class295.I_field_73c6d26c.i_method_805d6def()));
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : RockstarClient.getInstance().I_method_35687482().III_method_812fc188()) {
            if (!iiIiIIiII_Class165.isShowing() || iiIiIIiII_Class165.isDragging() || iiIiIIiII_Class165 instanceof IiIiiIIII_Class177 || iiIiIIiII_Class165 instanceof IiIiIiIIi_Class170) continue;
            this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7, iiIiIIiII_Class165.y));
            this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7, iiIiIIiII_Class165.y + iiIiIIiII_Class165.height * 0.5f));
            this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7, iiIiIIiII_Class165.y + iiIiIIiII_Class165.height));
            this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7, iiIiIIiII_Class165.x));
            this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7, iiIiIIiII_Class165.x + iiIiIIiII_Class165.width * 0.5f));
            this.I_field_7865b31.add(new IiIiIIIiI_Class163(IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7, iiIiIIiII_Class165.x + iiIiIIiII_Class165.width));
        }
    }

    @Generated
    public List<IiIiIIIiI_Class163> I_method_18838208() {
        return this.I_field_7865b31;
    }
}

