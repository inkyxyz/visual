package rockstar.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import lombok.Generated;
import pyrock.events.client.LanguageChangedEvent;
import rockstar.client.IiIIiiiI_Class79;
import rockstar.client.IiIIiiii_Class80;
import rockstar.client.IiIiIIIi_Class82;
import rockstar.client.RockstarClient;
import ua.mintantileak.spk.Compile;

public final class IiIiIIII_Class81 {
    private static final IiIIiiii_Class80 I_field_3f56db61;
    private static IiIIiiii_Class80 i_field_3f56db61;
    private static final Map<String, String> I_field_a567c40b;
    private static boolean I_field_5a;
    private static final Map<String, String> i_field_a567c40b;

    public static void I_method_b508148c() {
        String string = "/assets/" + RockstarClient.II_field_523beb0a + "/lang/" + i_field_3f56db61.I_method_881af974() + ".lang";
        try {
            String string2;
            try (InputStream inputStream = IiIiIIII_Class81.class.getResourceAsStream(string);){
                if (inputStream == null) {
                    throw new RuntimeException("Language file not found: " + string);
                }
                string2 = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            }
            string2 = IiIIiiiI_Class79.I_method_90a3efca(string2.trim());
            I_field_5a = false;
            I_field_a567c40b.clear();
            int n = 0;
            for (String string3 : string2.split("\r?\n")) {
                ++n;
                String string4 = IiIiIIII_Class81.Ii_method_6f6703c1(string3).trim();
                if (string4.isEmpty()) continue;
                IiIiIIII_Class81.I_method_593372f7(string4, n, string);
            }
            I_field_5a = true;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to load translations for language: " + i_field_3f56db61.I_method_881af974(), iOException);
        }
    }

    public static void I_method_9b03faed(@Nonnull IiIIiiii_Class80 iiIIiiii_Class80) {
        i_field_3f56db61 = iiIIiiii_Class80;
        i_field_a567c40b.clear();
        IiIiIIII_Class81.I_method_b508148c();
        if (RockstarClient.getInstance() != null && RockstarClient.getInstance().I_method_7897deab() != null) {
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new LanguageChangedEvent(iiIIiiii_Class80.I_method_881af974()));
        }
    }

    public static void i_method_b516a06c() {
        i_field_a567c40b.clear();
    }

    public static String I_method_f25a980a(String string) {
        IiIiIIII_Class81.II_method_ec097455();
        return i_field_a567c40b.computeIfAbsent(string, IiIiIIII_Class81::II_method_4f481ba1);
    }

    public static String I_method_1410d1e5(String string, Object ... objectArray) {
        IiIiIIII_Class81.II_method_ec097455();
        String string2 = i_field_a567c40b.computeIfAbsent(string, IiIiIIII_Class81::II_method_4f481ba1);
        return String.format(string2, objectArray);
    }

    public static String i_method_1279802a(String string) {
        IiIiIIII_Class81.II_method_ec097455();
        String string2 = I_field_a567c40b.get(string);
        if (string2 != null) {
            return string2;
        }
        String string3 = IiIiIIIi_Class82.I_method_865ff82a(string);
        return string3 != null ? string3 : " ";
    }

    private static String II_method_4f481ba1(String string) {
        String string2 = I_field_a567c40b.get(string);
        if (string2 != null) {
            return string2;
        }
        String string3 = IiIiIIIi_Class82.I_method_865ff82a(string);
        return string3 != null ? string3 : string;
    }

    @Compile
    private static void I_method_593372f7(String string, int n, String string2) {
        int n2 = string.indexOf(61);
        if (n2 == -1) {
            RockstarClient.I_field_ab0f6068.warn("Warning: Invalid line format at line {} in {}: {}", new Object[]{n, string2, string});
            return;
        }
        String string3 = string.substring(0, n2).trim();
        String string4 = string.substring(n2 + 1).trim();
        if (string3.isEmpty()) {
            RockstarClient.I_field_ab0f6068.warn("Warning: Empty key at line {} in {}", (Object)n, (Object)string2);
            return;
        }
        I_field_a567c40b.put(string3, string4);
    }

    private static String Ii_method_6f6703c1(String string) {
        int n = string.indexOf("#");
        if (n != -1) {
            return string.substring(0, n);
        }
        return string;
    }

    private static void II_method_ec097455() {
        if (!I_field_5a) {
            IiIiIIII_Class81.I_method_b508148c();
        }
    }

    @Generated
    private IiIiIIII_Class81() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    @Generated
    public static IiIIiiii_Class80 I_method_21a4cfeb() {
        return i_field_3f56db61;
    }

    static {
        i_field_3f56db61 = I_field_3f56db61 = IiIIiiii_Class80.i_field_3f56db61;
        I_field_a567c40b = new HashMap<String, String>();
        i_field_a567c40b = new HashMap<String, String>();
    }
}

