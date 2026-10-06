package rockstar.client;

import java.util.regex.Pattern;
import lombok.Generated;
import rockstar.client.IiIiIIII_Class81;

public final class IiIiIIiI_Class83 {
    private static final Pattern I_field_5fd3861f = Pattern.compile("\\|");

    public static String I_method_d9078808(long l) {
        long l2 = Math.max(0L, (System.currentTimeMillis() - l) / 1000L);
        if (l2 < 60L) {
            return IiIiIIII_Class81.I_method_f25a980a("rocknet.time.just_now");
        }
        long l3 = l2 / 60L;
        if (l3 < 60L) {
            return IiIiIIiI_Class83.I_method_2a470052("rocknet.time.minutes", l3);
        }
        long l4 = l3 / 60L;
        if (l4 < 24L) {
            return IiIiIIiI_Class83.I_method_2a470052("rocknet.time.hours", l4);
        }
        long l5 = l4 / 24L;
        if (l5 < 7L) {
            return IiIiIIiI_Class83.I_method_2a470052("rocknet.time.days", l5);
        }
        if (l5 < 30L) {
            return IiIiIIiI_Class83.I_method_2a470052("rocknet.time.weeks", l5 / 7L);
        }
        if (l5 < 365L) {
            return IiIiIIiI_Class83.I_method_2a470052("rocknet.time.months", l5 / 30L);
        }
        return IiIiIIiI_Class83.I_method_2a470052("rocknet.time.years", l5 / 365L);
    }

    private static String I_method_2a470052(String string, long l) {
        return IiIiIIII_Class81.I_method_1410d1e5("rocknet.time.ago", IiIiIIiI_Class83.i_method_e051c32(IiIiIIII_Class81.I_method_f25a980a(string), l));
    }

    private static String i_method_e051c32(String string, long l) {
        String[] stringArray = I_field_5fd3861f.split(string);
        return String.format(stringArray[IiIiIIiI_Class83.I_method_1bf165c0(stringArray.length, l)], l);
    }

    private static int I_method_1bf165c0(int n, long l) {
        if (n < 3) {
            return l == 1L ? 0 : n - 1;
        }
        long l2 = l % 10L;
        long l3 = l % 100L;
        if (l2 == 1L && l3 != 11L) {
            return 0;
        }
        if (l2 >= 2L && l2 <= 4L && (l3 < 10L || l3 >= 20L)) {
            return 1;
        }
        return 2;
    }

    @Generated
    private IiIiIIiI_Class83() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

