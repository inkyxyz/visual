package rockstar.client;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import jep.ClassEnquirer;
import jep.JepConfig;
import jep.MainInterpreter;
import jep.PyConfig;
import jep.SharedInterpreter;
import pyrock.McBridge;
import rockstar.client.IIiiIiIii_Class108;
import rockstar.client.IIiiIiiII_Class109;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;

public final class IIiiIiIIi_Class106 {
    private static volatile Thread I_field_72a5fc31;
    private static volatile boolean I_field_5a;
    private static volatile boolean i_field_5a;
    private static volatile String I_field_523beb0a;
    private static SharedInterpreter I_field_9b01432c;
    private static volatile boolean II_field_5a;

    private IIiiIiIIi_Class106() {
    }

    public static String I_method_681c3841() {
        return I_field_523beb0a;
    }

    public static File I_method_1233012e() {
        return new File(IiIIiIII_Class73.I_field_3a58077, "runtime/python");
    }

    public static void I_method_fd9ca23f() {
        if (I_field_72a5fc31 == null) {
            I_field_72a5fc31 = Thread.currentThread();
        }
    }

    public static boolean I_method_fd9ca243() {
        File file = IIiiIiIIi_Class106.i_method_d3560b77(IIiiIiIIi_Class106.I_method_1233012e());
        return file != null && file.exists();
    }

    public static boolean i_method_fdab2e23() {
        return i_field_5a;
    }

    public static boolean II_method_b6069d06() {
        return II_field_5a;
    }

    public static boolean Ii_method_b61528e6() {
        return Thread.currentThread() == I_field_72a5fc31;
    }

    public static void I_method_430af73d(Runnable runnable) {
        if (I_field_72a5fc31 == null || IIiiIiIIi_Class106.Ii_method_b61528e6()) {
            runnable.run();
        } else {
            iIIiIIiIi_Class294.I_field_3a9bda27.execute(runnable);
        }
    }

    public static SharedInterpreter I_method_f423a055() {
        if (!I_field_5a) {
            IIiiIiIIi_Class106.i_method_fdab2e1f();
        }
        return I_field_9b01432c;
    }

    private static synchronized void i_method_fdab2e1f() {
        if (I_field_5a) {
            return;
        }
        File file = IIiiIiIIi_Class106.I_method_1233012e();
        File file2 = IIiiIiIIi_Class106.i_method_d3560b77(file);
        if (file2 == null || !file2.exists()) {
            RockstarClient.I_field_ab0f6068.warn("[Python] jep native \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d \u0432 {} \u2014 \u0436\u0434\u0451\u043c \u0437\u0430\u0433\u0440\u0443\u0437\u043a\u0438 \u0440\u0430\u043d\u0442\u0430\u0439\u043c\u0430", (Object)file.getAbsolutePath());
            return;
        }
        I_field_5a = true;
        if (I_field_72a5fc31 == null) {
            I_field_72a5fc31 = Thread.currentThread();
        }
        try {
            II_field_5a = true;
            File file3 = IIiiIiIIi_Class106.I_method_363d0357(file);
            if (file3 != null) {
                System.load(file3.getAbsolutePath());
            }
            MainInterpreter.setJepLibraryPath((String)file2.getAbsolutePath());
            PyConfig pyConfig = new PyConfig();
            pyConfig.setPythonHome(file.getAbsolutePath());
            MainInterpreter.setInitParams((PyConfig)pyConfig);
            JepConfig jepConfig = new JepConfig();
            jepConfig.addIncludePaths(new String[]{new File(file, "Lib/site-packages").getAbsolutePath(), new File(file, "scripts-lib").getAbsolutePath()});
            jepConfig.redirectStdout((OutputStream)System.out);
            jepConfig.redirectStdErr((OutputStream)System.err);
            jepConfig.setClassLoader((ClassLoader)new IIiiIiiII_Class109(McBridge.class.getClassLoader()));
            jepConfig.setClassEnquirer((ClassEnquirer)new IIiiIiIii_Class108());
            SharedInterpreter.setConfig((JepConfig)jepConfig);
            I_field_9b01432c = new SharedInterpreter();
            I_field_9b01432c.exec(IIiiIiIIi_Class106.i_method_fb3ae861());
            i_field_5a = true;
            RockstarClient.I_field_ab0f6068.info("[Python] CPython \u0438\u043d\u0438\u0446\u0438\u0430\u043b\u0438\u0437\u0438\u0440\u043e\u0432\u0430\u043d ({})", (Object)file.getAbsolutePath());
        }
        catch (Throwable throwable) {
            i_field_5a = false;
            I_field_523beb0a = throwable.getMessage() != null ? throwable.getMessage() : throwable.getClass().getSimpleName();
            RockstarClient.I_field_ab0f6068.error("[Python] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0438\u043d\u0438\u0446\u0438\u0430\u043b\u0438\u0437\u0438\u0440\u043e\u0432\u0430\u0442\u044c CPython", throwable);
        }
    }

    private static File I_method_363d0357(File file2) {
        File[] fileArray = file2.listFiles((file, string) -> string.matches("python3\\d+\\.dll"));
        return fileArray != null && fileArray.length > 0 ? fileArray[0] : null;
    }

    private static File i_method_d3560b77(File file) {
        String string = System.getProperty("os.name", "").toLowerCase();
        String string2 = string.contains("win") ? "jep.dll" : (string.contains("mac") ? "libjep.jnilib" : "libjep.so");
        File file2 = new File(file, string2);
        if (file2.exists()) {
            return file2;
        }
        return new File(file, "Lib/site-packages/jep/" + string2);
    }

    private static String i_method_fb3ae861() throws Exception {
        try (InputStream inputStream = McBridge.class.getResourceAsStream("/rockstar/prelude.py");){
            if (inputStream == null) {
                throw new IllegalStateException("/rockstar/prelude.py \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d \u0432 \u0440\u0435\u0441\u0443\u0440\u0441\u0430\u0445");
            }
            String string = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return string;
        }
    }
}

