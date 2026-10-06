package pyrock.classes;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.classes.PyEspElement;
import rockstar.client.IiiiIiiI_Class119;
import rockstar.client.IiiiiiiI_Class127;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiiiiIII_Class377;

public class PyEsp
implements iIIiIIiIi_Class294 {
    public PyEspElement element(String string, String string2) {
        return new PyEspElement(string, string2);
    }

    public boolean enabled() {
        return IiiiiiiI_Class127.I_method_731950d0();
    }

    public List<String> elements() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (IiiiIiiI_Class119 iiiiIiiI_Class119 : IiiiiiiI_Class127.I_method_e1e653cb().I_method_6ddf4ffb()) {
            arrayList.add(iiiiIiiI_Class119.I_method_4b007174());
        }
        return arrayList;
    }

    public float[] toScreen(double d, double d2, double d3) {
        float[] fArray;
        Vec2f vec2f = iIiiiiIII_Class377.I_method_211fc242(new Vec3d(d, d2, d3));
        if (vec2f == null) {
            fArray = null;
        } else {
            float[] fArray2 = new float[2];
            fArray2[0] = vec2f.x;
            fArray = fArray2;
            fArray2[1] = vec2f.y;
        }
        return fArray;
    }
}

