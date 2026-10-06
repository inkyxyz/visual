package pyrock.classes;

import java.util.List;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import rockstar.client.iIIIIIIIi_Class258;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIiIIiIi_Class294;

public class PyKeys
implements iIIiIIiIi_Class294 {
    public int code(String string) {
        return iIIIIIIIi_Class258.I_method_dc7f39fc(string);
    }

    public String name(int n) {
        return iIIIIiIiI_Class267.I_method_a937749c(n);
    }

    public boolean down(Object object) {
        int n = this.toCode(object);
        if (n < 0) {
            return false;
        }
        long l = I_field_3a9bda27.getWindow().getHandle();
        if (n <= 7) {
            return GLFW.glfwGetMouseButton((long)l, (int)n) == 1;
        }
        return InputUtil.isKeyPressed((long)l, (int)n);
    }

    public boolean mouse(int n) {
        return GLFW.glfwGetMouseButton((long)I_field_3a9bda27.getWindow().getHandle(), (int)n) == 1;
    }

    public float x() {
        return (float)(PyKeys.I_field_3a9bda27.mouse.getX() / I_field_3a9bda27.getWindow().getScaleFactor());
    }

    public float y() {
        return (float)(PyKeys.I_field_3a9bda27.mouse.getY() / I_field_3a9bda27.getWindow().getScaleFactor());
    }

    public List<String> names() {
        return iIIIIIIIi_Class258.I_method_ed34c268();
    }

    private int toCode(Object object) {
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.intValue();
        }
        if (object instanceof String) {
            String string = (String)object;
            return iIIIIIIIi_Class258.I_method_dc7f39fc(string);
        }
        return -1;
    }
}

