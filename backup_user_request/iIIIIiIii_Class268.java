package rockstar.client;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPVOID;
import com.sun.jna.ptr.IntByReference;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFWNativeWin32;

public final class iIIIIiIii_Class268 {
   private static final int I_field_49 = 20;
   private static final int i_field_49 = 4;
   private static final boolean I_field_5a = Ii_method_271290e6();
   private static HWND I_field_164e1efc;
   private static iIIIIiIii_Class268.Nested1_bbdde440 I_field_3967a47 = null;

   private static boolean Ii_method_271290e6() {
      String var0 = System.getProperty("os.name");
      return var0 != null && var0.toLowerCase().contains("windows");
   }

   public static void I_method_43523a3f() {
      I_method_c3e59222(iIIIIiIii_Class268.Nested1_bbdde440.i_field_3967a47);
   }

   public static void i_method_4360c61f() {
      I_method_c3e59222(iIIIIiIii_Class268.Nested1_bbdde440.I_field_3967a47);
   }

   public static void II_method_27040502() {
      iIIIIiIii_Class268.Nested1_bbdde440 var0 = I_field_3967a47 == iIIIIiIii_Class268.Nested1_bbdde440.i_field_3967a47
         ? iIIIIiIii_Class268.Nested1_bbdde440.I_field_3967a47
         : iIIIIiIii_Class268.Nested1_bbdde440.i_field_3967a47;
      I_method_c3e59222(var0);
   }

   public static boolean I_method_43523a43() {
      return I_field_5a;
   }

   public static boolean i_method_4360c623() {
      return I_field_3967a47 == iIIIIiIii_Class268.Nested1_bbdde440.i_field_3967a47;
   }

   public static boolean II_method_27040506() {
      return I_field_3967a47 == iIIIIiIii_Class268.Nested1_bbdde440.I_field_3967a47;
   }

   private static void I_method_c3e59222(iIIIIiIii_Class268.Nested1_bbdde440 var0) {
      if (I_field_5a && var0 != null) {
         try {
            Ii_method_271290e2();
            IntByReference var1 = new IntByReference(var0.I_method_a710c76d());
            LPVOID var2 = new LPVOID(var1.getPointer());
            IiiiiiIIi_Class250.INSTANCE.DwmSetWindowAttribute(I_field_164e1efc, new DWORD(20L), var2, new DWORD(4L));
            I_field_3967a47 = var0;
         } catch (Exception var3) {
            throw new RuntimeException("Failed to apply title bar theme: " + var0, var3);
         }
      }
   }

   private static void Ii_method_271290e2() {
      if (I_field_164e1efc == null) {
         MinecraftClient var0 = MinecraftClient.getInstance();
         if (var0 != null && var0.getWindow() != null) {
            long var1 = var0.getWindow().getHandle();
            long var3 = GLFWNativeWin32.glfwGetWin32Window(var1);
            I_field_164e1efc = new HWND(Pointer.createConstant(var3));
         } else {
            throw new IllegalStateException("MinecraftClient window is not available");
         }
      }
   }

   @Generated
   private iIIIIiIii_Class268() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static enum Nested1_bbdde440 {
      I_field_3967a47(0),
      i_field_3967a47(1);

      private final int I_field_49;

      @Generated
      public int I_method_a710c76d() {
         return this.I_field_49;
      }

      @Generated
      private Nested1_bbdde440(int var3) {
         this.I_field_49 = var3;
      }
   }
}
