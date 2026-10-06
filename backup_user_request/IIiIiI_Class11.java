package rockstar.client;

import lombok.Generated;
import rockstar.client.IIiiii_Class16;

public final class IIiIiI_Class11 {
    public static final IIiiii_Class16 I_field_857c0621 = IIiiii_Class16.I_method_6047f1b7("bold", "bold");
    public static final IIiiii_Class16 i_field_857c0621 = IIiiii_Class16.I_method_6047f1b7("medium", "medium");
    public static final IIiiii_Class16 II_field_857c0621 = IIiiii_Class16.I_method_6047f1b7("regular", "regular");
    public static final IIiiii_Class16 Ii_field_857c0621 = IIiiii_Class16.I_method_6047f1b7("semibold", "semi_bold");
    public static final IIiiii_Class16 iI_field_857c0621 = IIiiii_Class16.I_method_6047f1b7("light", "light");
    public static final IIiiii_Class16 ii_field_857c0621 = IIiiii_Class16.I_method_6047f1b7("roundbold", "round");
    public static final IIiiii_Class16 JETBRAINS = IIiiii_Class16.I_method_6047f1b7("jetbrains", "jetbrains");
    public static final IIiiii_Class16 III_field_857c0621 = IIiiii_Class16.I_method_e983174b();

    public static final String[] FONT_PRESETS = new String[]{
        "Inter", "Medium", "SemiBold", "Bold", "Round", "JetBrains", "Light"
    };
    private static int activeFontIndex = 0;

    public static String getActiveFontName() {
        return FONT_PRESETS[activeFontIndex];
    }

    public static int getActiveFontIndex() {
        return activeFontIndex;
    }

    public static void cycleFont(int direction) {
        activeFontIndex = (activeFontIndex + direction) % FONT_PRESETS.length;
        if (activeFontIndex < 0) {
            activeFontIndex += FONT_PRESETS.length;
        }
        applyFontPreset(FONT_PRESETS[activeFontIndex]);
    }

    public static void setFontIndex(int index) {
        if (index < 0 || index >= FONT_PRESETS.length) return;
        activeFontIndex = index;
        applyFontPreset(FONT_PRESETS[activeFontIndex]);
    }

    public static void applyFontPreset(String name) {
        try {
            IIiiii_Class16 source = switch (name.toLowerCase()) {
                case "medium" -> i_field_857c0621;
                case "bold" -> I_field_857c0621;
                case "semibold" -> Ii_field_857c0621;
                case "round" -> ii_field_857c0621;
                case "light" -> iI_field_857c0621;
                case "jetbrains" -> JETBRAINS;
                default -> null; // Inter / Regular
            };
            if (source != null) {
                java.awt.Font f = source.getFont();
                if (f != null) {
                    II_field_857c0621.I_method_20decac8(f);
                    i_field_857c0621.I_method_20decac8(f);
                }
            } else {
                II_field_857c0621.I_method_3f36766c();
                i_field_857c0621.I_method_3f36766c();
            }
        } catch (Throwable ignored) {
        }
    }
    private static final String I_field_523beb0a = " !?.,:;-\u2013\u2014()[]{}<>/\\|+*=%#@&\"'`~^_$0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\u0430\u0431\u0432\u0433\u0434\u0435\u0451\u0436\u0437\u0438\u0439\u043a\u043b\u043c\u043d\u043e\u043f\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447\u0448\u0449\u044a\u044b\u044c\u044d\u044e\u044f\u0410\u0411\u0412\u0413\u0414\u0415\u0401\u0416\u0417\u0418\u0419\u041a\u041b\u041c\u041d\u041e\u041f\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427\u0428\u0429\u042a\u042b\u042c\u042d\u042e\u042f";

    public static void I_method_c75c6ac() {
        Thread thread = new Thread(() -> {
            for (IIiiii_Class16 iIiiii_Class16 : new IIiiii_Class16[]{II_field_857c0621, i_field_857c0621, Ii_field_857c0621, I_field_857c0621}) {
                iIiiii_Class16.I_method_ed6b5d36(I_field_523beb0a);
            }
        }, "rockstar-font-warmup");
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
    }

    public static void i_method_c84528c() {
        I_field_857c0621.I_method_3f36766c();
        i_field_857c0621.I_method_3f36766c();
        II_field_857c0621.I_method_3f36766c();
        Ii_field_857c0621.I_method_3f36766c();
        iI_field_857c0621.I_method_3f36766c();
        ii_field_857c0621.I_method_3f36766c();
        IIiIiI_Class11.I_method_c75c6ac();
    }

    public static IIiiii_Class16 I_method_1fee2501(String string) {
        return switch (string.toLowerCase()) {
            case "noto" -> III_field_857c0621;
            case "bold" -> I_field_857c0621;
            case "medium" -> i_field_857c0621;
            case "light" -> iI_field_857c0621;
            case "semibold" -> Ii_field_857c0621;
            case "roundbold" -> ii_field_857c0621;
            default -> II_field_857c0621;
        };
    }

    @Generated
    private IIiIiI_Class11() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

