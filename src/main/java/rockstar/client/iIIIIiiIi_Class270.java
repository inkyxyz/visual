package rockstar.client;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import java.util.Map;
import org.lwjgl.glfw.GLFWNativeWin32;

public final class iIIIIiiIi_Class270 {
    private static long I_field_4a;
    private static long i_field_4a;

    private iIIIIiiIi_Class270() {
    }

    public static void I_method_b35dc8a5(long l) {
        if (!Platform.isWindows()) {
            return;
        }
        I_field_4a = l;
        i_field_4a = System.nanoTime() + 60000000000L;
    }

    public static void I_method_a2b06dff() {
        if (!Platform.isWindows() || I_field_4a == 0L) {
            return;
        }
        if (System.nanoTime() > i_field_4a) {
            I_field_4a = 0L;
            return;
        }
        try {
            Pointer pointer = Pointer.createConstant((long)GLFWNativeWin32.glfwGetWin32Window((long)I_field_4a));
            Pointer pointer2 = Nested1_bd924880.INSTANCE.ImmGetContext(pointer);
            if (pointer2 == null) {
                return;
            }
            try {
                if (Nested1_bd924880.INSTANCE.ImmGetCompositionStringW(pointer2, 8, Pointer.NULL, 0) > 0) {
                    Nested1_bd924880.INSTANCE.ImmNotifyIME(pointer2, 21, 1, 0);
                }
            }
            finally {
                Nested1_bd924880.INSTANCE.ImmReleaseContext(pointer, pointer2);
            }
        }
        catch (LinkageError | RuntimeException throwable) {
            I_field_4a = 0L;
        }
    }

    static interface Nested1_bd924880
    extends StdCallLibrary {
        public static final Nested1_bd924880 INSTANCE = (Nested1_bd924880)Native.load((String)"imm32", Nested1_bd924880.class, (Map)W32APIOptions.DEFAULT_OPTIONS);

        public Pointer ImmGetContext(Pointer var1);

        public boolean ImmReleaseContext(Pointer var1, Pointer var2);

        public boolean ImmNotifyIME(Pointer var1, int var2, int var3, int var4);

        public int ImmGetCompositionStringW(Pointer var1, int var2, Pointer var3, int var4);
    }
}

