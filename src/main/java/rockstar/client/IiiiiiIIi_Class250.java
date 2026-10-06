package rockstar.client;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import java.util.Map;

public interface IiiiiiIIi_Class250
extends StdCallLibrary {
    public static final IiiiiiIIi_Class250 INSTANCE = (IiiiiiIIi_Class250)Native.load((String)"dwmapi", IiiiiiIIi_Class250.class, (Map)W32APIOptions.DEFAULT_OPTIONS);

    public void DwmSetWindowAttribute(WinDef.HWND var1, WinDef.DWORD var2, WinDef.LPVOID var3, WinDef.DWORD var4);
}

