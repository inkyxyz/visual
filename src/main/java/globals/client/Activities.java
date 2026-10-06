package globals.client;

import rockstar.client.IiIiIIII_Class81;

public final class Activities {
    public static final String MAIN_MENU = "main_menu";
    public static final String SINGLEPLAYER = "singleplayer";
    public static final String MULTIPLAYER = "multiplayer";
    public static final String OFFLINE = "offline";
    public static final String WEBSITE = "website";
    private static final char ARG = '|';

    private Activities() {
    }

    public static String multiplayer(String string) {
        return string == null || string.isBlank() ? MULTIPLAYER : "multiplayer|" + string;
    }

    public static boolean offline(String string) {
        return Activities.is(string, OFFLINE, "rocknet.status.offline.id");
    }

    public static boolean mainMenu(String string) {
        return Activities.is(string, MAIN_MENU, "rocknet.status.main_menu.id");
    }

    public static boolean website(String string) {
        return Activities.is(string, WEBSITE, "rocknet.status.website.id");
    }

    public static boolean singleplayer(String string) {
        return Activities.is(string, SINGLEPLAYER, "rocknet.activity.singleplayer");
    }

    public static boolean onServer(String string) {
        return !Activities.offline(string) && !Activities.mainMenu(string) && !Activities.website(string) && !Activities.singleplayer(string);
    }

    public static String translate(String string) {
        if (string == null || string.isBlank()) {
            return "";
        }
        int n = string.indexOf(124);
        String string2 = n < 0 ? string : string.substring(0, n);
        String string3 = n < 0 ? "" : string.substring(n + 1);
        return switch (string2) {
            case MAIN_MENU -> IiIiIIII_Class81.I_method_f25a980a("rocknet.activity.main_menu");
            case SINGLEPLAYER -> IiIiIIII_Class81.I_method_f25a980a("rocknet.activity.singleplayer");
            case MULTIPLAYER -> {
                if (string3.isBlank()) {
                    yield IiIiIIII_Class81.I_method_f25a980a("rocknet.activity.online");
                }
                yield IiIiIIII_Class81.I_method_1410d1e5("rocknet.activity.multiplayer", string3);
            }
            case OFFLINE -> IiIiIIII_Class81.I_method_f25a980a("rocknet.status.offline");
            case WEBSITE -> IiIiIIII_Class81.I_method_f25a980a("rocknet.status.website");
            default -> Activities.legacy(string);
        };
    }

    private static String legacy(String string) {
        if (string.equals(IiIiIIII_Class81.I_method_f25a980a("rocknet.status.offline.id"))) {
            return IiIiIIII_Class81.I_method_f25a980a("rocknet.status.offline");
        }
        if (string.equals(IiIiIIII_Class81.I_method_f25a980a("rocknet.status.main_menu.id"))) {
            return IiIiIIII_Class81.I_method_f25a980a("rocknet.status.main_menu");
        }
        if (string.equals(IiIiIIII_Class81.I_method_f25a980a("rocknet.status.website.id"))) {
            return IiIiIIII_Class81.I_method_f25a980a("rocknet.status.website");
        }
        return string;
    }

    private static boolean is(String string, String string2, String string3) {
        return string != null && (string.equals(string2) || string.equals(IiIiIIII_Class81.I_method_f25a980a(string3)));
    }
}

