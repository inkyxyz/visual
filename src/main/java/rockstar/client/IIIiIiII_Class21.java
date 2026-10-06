package rockstar.client;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import java.util.Map;

public interface IIIiIiII_Class21
extends StdCallLibrary {
    public static final IIIiIiII_Class21 INSTANCE = (IIIiIiII_Class21)Native.load((String)"user32", IIIiIiII_Class21.class, (Map)W32APIOptions.DEFAULT_OPTIONS);
    public static final int WDA_NONE = 0;
    public static final int WDA_EXCLUDEFROMCAPTURE = 17;
    public static final int WS_EX_TRANSPARENT = 32;
    public static final int WS_EX_TOOLWINDOW = 128;
    public static final int WS_EX_NOACTIVATE = 0x8000000;

    public boolean SetWindowDisplayAffinity(WinDef.HWND var1, WinDef.DWORD var2);

    public static WinDef.HWND handle(long l) {
        return new WinDef.HWND(Pointer.createConstant((long)l));
    }

    public static boolean excludeFromCapture(long l) {
        try {
            return INSTANCE.SetWindowDisplayAffinity(IIIiIiII_Class21.handle(l), new WinDef.DWORD(17L));
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static void makeGhost(long l) {
        try {
            WinDef.HWND hWND = IIIiIiII_Class21.handle(l);
            int n = User32.INSTANCE.GetWindowLong(hWND, -20);
            User32.INSTANCE.SetWindowLong(hWND, -20, n | 0x80 | 0x8000000 | 0x20);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

