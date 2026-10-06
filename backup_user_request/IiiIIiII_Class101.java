package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

public final class IiiIIiII_Class101 {
    private static final List<Integer> I_field_7865b31 = new ArrayList<Integer>(List.of(Integer.valueOf(204), Integer.valueOf(205), Integer.valueOf(206), Integer.valueOf(207)));
    private static long I_field_4a = 80000L;
    private static long i_field_4a = 11000L;
    private static boolean I_field_5a = false;
    private static boolean i_field_5a = false;
    private static long II_field_4a = 300000L;

    public static List<Integer> I_method_96ec801b() {
        return List.copyOf(I_field_7865b31);
    }

    public static void I_method_ce2723d7(int n) {
        if (n > 0 && !I_field_7865b31.contains(n)) {
            I_field_7865b31.add(n);
        }
    }

    public static void i_method_cfea13f7(int n) {
        I_field_7865b31.remove((Object)n);
    }

    public static long I_method_c495e4a0() {
        return I_field_4a;
    }

    public static void I_method_ce272798(long l) {
        I_field_4a = Math.max(1000L, l);
    }

    public static long i_method_c4a47080() {
        return i_field_4a;
    }

    public static void i_method_cfea17b8(long l) {
        i_field_4a = Math.max(500L, l);
    }

    public static boolean I_method_c495e4b0() {
        return I_field_5a;
    }

    public static void I_method_ce2763a8(boolean bl) {
        I_field_5a = bl;
    }

    public static boolean i_method_c4a47090() {
        return i_field_5a;
    }

    public static void i_method_cfea53c8(boolean bl) {
        i_field_5a = bl;
    }

    public static long II_method_ce35a829() {
        return II_field_4a;
    }

    public static void II_method_f87fd52f(long l) {
        II_field_4a = Math.max(60000L, l);
    }

    @Generated
    private IiiIIiII_Class101() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

