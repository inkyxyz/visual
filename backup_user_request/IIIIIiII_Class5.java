package rockstar.client;

import java.security.SecureRandom;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rockstar.client.IIIIIIIi_Class2;
import rockstar.client.iiiiiii_Class128;

public final class IIIIIiII_Class5 {
    private static final SecureRandom I_field_ec5bca73 = new SecureRandom();
    private static final ScheduledExecutorService I_field_47254ffa = Executors.newSingleThreadScheduledExecutor(new ThreadFactory(){

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Rockstar-BotStarter");
            thread.setDaemon(true);
            return thread;
        }
    });
    private static final AtomicBoolean I_field_1232aa16 = new AtomicBoolean(false);
    private static final AtomicBoolean i_field_1232aa16 = new AtomicBoolean(false);
    private static final AtomicLong I_field_1bd7cf1c = new AtomicLong();

    private IIIIIiII_Class5() {
    }

    public static iiiiiii_Class128 I_method_5014d936(String string, String string2) {
        IIIIIIIi_Class2.Nested1_e6792513 nested1_e6792513 = IIIIIIIi_Class2.I_method_1a7c0a9c(string2);
        return nested1_e6792513 == null ? null : IIIIIiII_Class5.I_method_50214bb9(string, nested1_e6792513.I_method_ba0260f9(), nested1_e6792513.I_method_838c127a());
    }

    public static iiiiiii_Class128 I_method_50214bb9(String string, String string2, int n) {
        return IIIIIIIi_Class2.I_method_70b3dfcb().I_method_9e1ed3b9(string, string2, n);
    }

    public static void I_method_7f329e1(int n, String string) {
        IIIIIIIi_Class2.Nested1_e6792513 nested1_e6792513 = IIIIIIIi_Class2.I_method_1a7c0a9c(string);
        if (nested1_e6792513 != null) {
            IIIIIiII_Class5.I_method_f6728542(n, nested1_e6792513.I_method_ba0260f9(), nested1_e6792513.I_method_838c127a());
        }
    }

    public static void I_method_f6728542(int n, String string, int n2) {
        if (n <= 0) {
            return;
        }
        IIIIIIIi_Class2 iIIIIIRockstarClient = IIIIIIIi_Class2.I_method_70b3dfcb();
        i_field_1232aa16.set(false);
        long l = I_field_1bd7cf1c.incrementAndGet();
        int n3 = Math.max(1, iIIIIIRockstarClient.I_method_70b457eb().iII_method_1e94bdbf());
        String string2 = iIIIIIRockstarClient.I_method_70b457eb().i_method_30091574();
        ConcurrentHashMap.KeySetView keySetView = ConcurrentHashMap.newKeySet();
        for (iiiiiii_Class128 iiiiiii_Class1282 : iIIIIIRockstarClient.I_method_350a479b()) {
            keySetView.add(iiiiiii_Class1282.I_method_7b75de01());
        }
        int n4 = 0;
        while (n4 < n) {
            int n5 = n4++;
            I_field_47254ffa.schedule(() -> {
                if (!IIIIIiII_Class5.I_method_791ab9c(l)) {
                    return;
                }
                String string3 = IIIIIiII_Class5.I_method_5985a446(string2, keySetView, n5);
                keySetView.add(string3);
                iIIIIIRockstarClient.I_method_9e1ed3b9(string3, string, n2);
            }, (long)n5 * (long)n3, TimeUnit.SECONDS);
        }
    }

    public static void I_method_31cae0ac() {
        i_field_1232aa16.set(true);
        I_field_1232aa16.set(false);
        I_field_1bd7cf1c.incrementAndGet();
    }

    public static boolean I_method_31cae0b0() {
        return I_field_1232aa16.compareAndSet(false, true);
    }

    public static boolean i_method_31d96c90() {
        return I_field_1232aa16.compareAndSet(true, false);
    }

    public static boolean II_method_7a02c39() {
        return I_field_1232aa16.get();
    }

    private static boolean I_method_791ab9c(long l) {
        while (I_field_1232aa16.get()) {
            if (i_field_1232aa16.get() || I_field_1bd7cf1c.get() != l) {
                return false;
            }
            try {
                Thread.sleep(150L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return !i_field_1232aa16.get() && I_field_1bd7cf1c.get() == l;
    }

    private static String I_method_5985a446(String string, Set<String> set, int n) {
        String string2;
        String string3;
        String string4 = string3 = string == null ? "Bot" : string.replaceAll("[^A-Za-z0-9_]", "");
        if (string3.isBlank()) {
            string3 = "Bot";
        }
        String string5 = String.valueOf(n % 1000);
        int n2 = 16 - string3.length();
        if (n2 <= string5.length()) {
            string3 = string3.substring(0, Math.max(1, 16 - string5.length() - 1));
            n2 = 16 - string3.length();
        }
        int n3 = Math.max(1, n2 - string5.length());
        int n4 = 0;
        while (set.contains(string2 = string3 + IIIIIiII_Class5.I_method_76d015a9(n3) + string5) && ++n4 < 25) {
        }
        return string2;
    }

    private static String I_method_76d015a9(int n) {
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(string.charAt(I_field_ec5bca73.nextInt(string.length())));
        }
        return stringBuilder.toString();
    }
}

