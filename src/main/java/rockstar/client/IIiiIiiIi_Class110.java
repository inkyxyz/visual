package rockstar.client;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Set;
import rockstar.client.RockstarClient;

public final class IIiiIiiIi_Class110 {
    private static final String[] I_field_6dccaaa5 = new String[]{"sun.", "com.sun.", "jdk.", "java.lang.reflect.", "java.lang.invoke.", "java.lang.foreign.", "java.lang.instrument.", "java.lang.module.", "java.lang.classfile.", "java.security.", "javax.script.", "javax.tools.", "org.lwjgl.system.", "io.netty.util.internal.", "org.objectweb.asm", "net.bytebuddy", "javassist", "jep.", "moscow.rockstar.systems.python."};
    private static final Set<String> I_field_a56a8dc5 = Set.of("java.lang.Runtime", "java.lang.ProcessBuilder", "java.lang.Process", "java.lang.ProcessHandle", "java.lang.System", "java.lang.Class", "java.lang.ClassLoader", "java.lang.Thread", "java.lang.ThreadGroup", "java.lang.Module", "java.lang.ModuleLayer", "java.lang.SecurityManager", "java.net.URLClassLoader", "java.awt.Robot", "java.awt.Desktop");

    private IIiiIiiIi_Class110() {
    }

    public static void I_method_7b55be29(String string) {
        if (string == null || string.isEmpty()) {
            return;
        }
        String string2 = string.replace('/', '.');
        if (I_field_a56a8dc5.contains(string2)) {
            IIiiIiiIi_Class110.i_method_4c0d1209(string2);
        }
        for (String string3 : I_field_6dccaaa5) {
            if (!string2.startsWith(string3)) continue;
            IIiiIiiIi_Class110.i_method_4c0d1209(string2);
        }
    }

    public static void I_method_5f293afe(Class<?> clazz) {
        if (clazz == null) {
            return;
        }
        Class<?> clazz2 = clazz;
        while (clazz2.isArray()) {
            clazz2 = clazz2.getComponentType();
        }
        if (clazz2.isPrimitive()) {
            return;
        }
        IIiiIiiIi_Class110.I_method_7b55be29(clazz2.getName());
    }

    public static void I_method_b0ca9c87(Method method) {
        if (method == null) {
            return;
        }
        IIiiIiiIi_Class110.I_method_5f293afe(method.getDeclaringClass());
        IIiiIiiIi_Class110.I_method_5f293afe(method.getReturnType());
    }

    public static void I_method_3b535d4e(Field field) {
        if (field == null) {
            return;
        }
        IIiiIiiIi_Class110.I_method_5f293afe(field.getDeclaringClass());
        IIiiIiiIi_Class110.I_method_5f293afe(field.getType());
    }

    public static Object I_method_915a3057(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Class) {
            Class clazz = (Class)object;
            IIiiIiiIi_Class110.i_method_4c0d1209(clazz.getName());
        }
        if (object instanceof ClassLoader || object instanceof Member || object instanceof MethodHandle || object instanceof MethodHandles.Lookup || object instanceof VarHandle || object instanceof Runtime || object instanceof Process || object instanceof ProcessBuilder || object instanceof ProcessHandle || object instanceof Thread || object instanceof ThreadGroup || object instanceof Module) {
            IIiiIiiIi_Class110.i_method_4c0d1209(object.getClass().getName());
        }
        return object;
    }

    private static void i_method_4c0d1209(String string) {
        RockstarClient.I_field_ab0f6068.warn("[Scripts] \u0441\u043a\u0440\u0438\u043f\u0442\u0443 \u043e\u0442\u043a\u0430\u0437\u0430\u043d\u043e \u0432 \u0434\u043e\u0441\u0442\u0443\u043f\u0435 \u043a {}", (Object)string);
        throw new Nested1_a5af6c60("\u043a\u043b\u0430\u0441\u0441 " + string + " \u0437\u0430\u043a\u0440\u044b\u0442 \u0434\u043b\u044f \u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432");
    }

    public static final class Nested1_a5af6c60
    extends RuntimeException {
        Nested1_a5af6c60(String string) {
            super(string);
        }
    }
}

