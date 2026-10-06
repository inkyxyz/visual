package rockstar.client;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.network.packet.c2s.play.CommandExecutionC2SPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import rockstar.client.IiiiiIIii_Class244;
import rockstar.client.iIIiIIiIi_Class294;

public final class IiiiiIIiI_Class243
implements iIIiIIiIi_Class294 {
    private static final long I_field_4a = 20000L;
    private static final long i_field_4a = 600000L;
    private static final long II_field_4a = 250L;
    private static final int I_field_49 = 3;
    private static final int i_field_49 = 16;
    private static final int II_field_49 = Integer.MIN_VALUE;
    private static final Pattern I_field_5fd3861f = Pattern.compile("^(?:ah|auc|auction|\u0430\u0443\u043a\u0446\u0438\u043e\u043d)(?:\\s+(.*))?$", 66);
    private static final Pattern i_field_5fd3861f = Pattern.compile("^(?:donmarket|dmarket|\u0434\u043e\u043d\u043c\u0430\u0440\u043a\u0435\u0442)(?:\\s+.*)?$", 66);
    private static final String[] I_field_6dccaaa5 = new String[]{"search", "find", "s", "\u043f\u043e\u0438\u0441\u043a"};
    private static final Map<String, Long> I_field_a567c40b = new LinkedHashMap<String, Long>();
    private static volatile String I_field_523beb0a = "";
    private static volatile String i_field_523beb0a = "";
    private static volatile long Ii_field_4a = -4611686018427387904L;
    private static volatile boolean I_field_5a;
    private static volatile int Ii_field_49;
    private static String II_field_523beb0a;
    private static boolean i_field_5a;
    private static long iI_field_4a;

    public static void I_method_c378d368(Packet<?> packet) {
        ChatMessageC2SPacket chatMessageC2SPacket;
        String string;
        if (packet instanceof CommandExecutionC2SPacket) {
            CommandExecutionC2SPacket commandExecutionC2SPacket = (CommandExecutionC2SPacket)packet;
            IiiiiIIiI_Class243.I_method_d31afa69(commandExecutionC2SPacket.command());
            return;
        }
        if (packet instanceof ChatMessageC2SPacket && (string = (chatMessageC2SPacket = (ChatMessageC2SPacket)packet).chatMessage()) != null && string.startsWith("/")) {
            IiiiiIIiI_Class243.I_method_d31afa69(string.substring(1));
        }
    }

    private static void I_method_d31afa69(String string) {
        if (string == null) {
            return;
        }
        String string2 = string.trim();
        if (string2.startsWith("/")) {
            string2 = string2.substring(1).trim();
        }
        if (string2.isEmpty()) {
            return;
        }
        Matcher matcher = I_field_5fd3861f.matcher(string2);
        if (matcher.matches()) {
            I_field_523beb0a = string2;
            i_field_523beb0a = IiiiiIIiI_Class243.I_method_e407f957(matcher.group(1));
            I_field_5a = false;
            IiiiiIIiI_Class243.I_method_34ca0a5f();
            return;
        }
        if (i_field_5fd3861f.matcher(string2).matches()) {
            I_field_523beb0a = string2;
            i_field_523beb0a = "";
            I_field_5a = true;
            IiiiiIIiI_Class243.I_method_34ca0a5f();
        }
    }

    private static void I_method_34ca0a5f() {
        Ii_field_4a = System.currentTimeMillis();
        Ii_field_49 = Integer.MIN_VALUE;
    }

    private static String I_method_e407f957(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.trim();
        String string3 = string2.toLowerCase(Locale.ROOT);
        for (String string4 : I_field_6dccaaa5) {
            if (string3.equals(string4)) {
                return "";
            }
            if (!string3.startsWith(string4 + " ")) continue;
            return string2.substring(string4.length()).trim();
        }
        return "";
    }

    public static String I_method_a6a81421() {
        return i_field_523beb0a;
    }

    private static boolean i_method_34d89643() {
        return System.currentTimeMillis() - Ii_field_4a <= 20000L;
    }

    public static boolean I_method_d31afa6d(String string) {
        Screen screen = IiiiiIIiI_Class243.I_field_3a9bda27.currentScreen;
        if (!(screen instanceof HandledScreen)) {
            return false;
        }
        HandledScreen handledScreen = (HandledScreen)screen;
        if (!IiiiiIIii_Class244.I_method_780d5977(handledScreen.getTitle().getString()).equals(string)) {
            return false;
        }
        return IiiiiIIiI_Class243.I_method_2dd93383(handledScreen);
    }

    public static boolean I_method_2dd93383(HandledScreen<?> handledScreen) {
        if (handledScreen == null || handledScreen.getScreenHandler() == null) {
            return false;
        }
        String string = IiiiiIIii_Class244.I_method_780d5977(handledScreen.getTitle().getString());
        int n = handledScreen.getScreenHandler().syncId;
        String string2 = n + " " + string;
        long l = System.currentTimeMillis();
        if (string2.equals(II_field_523beb0a) && (i_field_5a || l - iI_field_4a < 250L)) {
            return i_field_5a;
        }
        boolean bl = IiiiiIIiI_Class243.I_method_6653c16e(handledScreen, string, n, l);
        II_field_523beb0a = string2;
        i_field_5a = bl;
        iI_field_4a = l;
        if (bl) {
            IiiiiIIiI_Class243.I_method_9044c97b(string, l);
        }
        return bl;
    }

    public static boolean I_method_34ca0a63() {
        Object object = IiiiiIIiI_Class243.I_field_3a9bda27.currentScreen;
        if (!(object instanceof HandledScreen)) {
            return false;
        }
        HandledScreen handledScreen = (HandledScreen)object;
        object = IiiiiIIii_Class244.I_method_780d5977(handledScreen.getTitle().getString());
        if (IiiiiIIii_Class244.i_method_24042a2d((String)object)) {
            return true;
        }
        if (!I_field_5a || !IiiiiIIiI_Class243.i_method_34d89643()) {
            return false;
        }
        return IiiiiIIiI_Class243.I_method_2dd93383(handledScreen) && Ii_field_49 == handledScreen.getScreenHandler().syncId;
    }

    private static boolean I_method_6653c16e(HandledScreen<?> handledScreen, String string, int n, long l) {
        if (IiiiiIIii_Class244.I_method_534cd64d(string)) {
            return true;
        }
        if (IiiiiIIiI_Class243.I_method_9044c97f(string, l)) {
            return true;
        }
        if (!IiiiiIIiI_Class243.i_method_cb7c1763(handledScreen)) {
            return false;
        }
        if (IiiiiIIiI_Class243.I_method_2a7f52c4(n, l)) {
            return true;
        }
        int n2 = IiiiiIIiI_Class243.I_method_2dd93372(handledScreen);
        if (n2 <= 0) {
            return false;
        }
        return IiiiiIIiI_Class243.i_method_a3d24e4d(string) || n2 >= 3;
    }

    private static boolean i_method_a3d24e4d(String string) {
        return string.startsWith(":");
    }

    public static boolean i_method_cb7c1763(HandledScreen<?> handledScreen) {
        GenericContainerScreenHandler genericContainerScreenHandler;
        ScreenHandler screenHandler = handledScreen.getScreenHandler();
        return screenHandler instanceof GenericContainerScreenHandler && (genericContainerScreenHandler = (GenericContainerScreenHandler)screenHandler).getRows() >= 5;
    }

    private static boolean I_method_2a7f52c4(int n, long l) {
        if (l - Ii_field_4a > 20000L) {
            return false;
        }
        if (Ii_field_49 == Integer.MIN_VALUE) {
            Ii_field_49 = n;
        }
        return Ii_field_49 == n;
    }

    private static int I_method_2dd93372(HandledScreen<?> handledScreen) {
        ScreenHandler screenHandler = handledScreen.getScreenHandler();
        int n = screenHandler.slots.size() - 36;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            LoreComponent loreComponent;
            Slot slot = screenHandler.getSlot(i);
            if (slot == null || !slot.hasStack() || (loreComponent = (LoreComponent)slot.getStack().get(DataComponentTypes.LORE)) == null || loreComponent.lines().isEmpty() || IiiiiIIii_Class244.I_method_6e254d24(loreComponent.lines()) <= 0L || ++n2 < 3) continue;
            return n2;
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void I_method_9044c97b(String string, long l) {
        if (string.isEmpty()) {
            return;
        }
        Map<String, Long> map = I_field_a567c40b;
        synchronized (map) {
            I_field_a567c40b.remove(string);
            I_field_a567c40b.put(string, l);
            while (I_field_a567c40b.size() > 16) {
                Iterator<String> iterator = I_field_a567c40b.keySet().iterator();
                iterator.next();
                iterator.remove();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean I_method_9044c97f(String string, long l) {
        if (string.isEmpty()) {
            return false;
        }
        Map<String, Long> map = I_field_a567c40b;
        synchronized (map) {
            Long l2 = I_field_a567c40b.get(string);
            if (l2 == null) {
                return false;
            }
            if (l - l2 > 600000L) {
                I_field_a567c40b.remove(string);
                return false;
            }
            return true;
        }
    }

    @Generated
    private IiiiiIIiI_Class243() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        Ii_field_49 = Integer.MIN_VALUE;
        II_field_523beb0a = "";
    }
}

