package rockstar.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rockstar.client.IIiiIiIIi_Class106;
import rockstar.client.RockstarClient;

public final class IIiiIiIII_Class105 {
    private static final Set<String> I_field_a56a8dc5 = ConcurrentHashMap.newKeySet();
    private static final ExecutorService I_field_331d0885 = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Script-Pip");
        thread.setDaemon(true);
        return thread;
    });

    private IIiiIiIII_Class105() {
    }

    public static void I_method_781d7d50(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        File file = new File(IIiiIiIIi_Class106.I_method_1233012e(), "python.exe");
        if (!file.exists()) {
            return;
        }
        for (String string : list) {
            String string2;
            if (string == null || (string2 = string.trim()).isEmpty() || string2.startsWith("-") || !I_field_a56a8dc5.add(string2.toLowerCase(Locale.ROOT))) continue;
            I_field_331d0885.submit(() -> IIiiIiIII_Class105.I_method_97b5b5e0(file, string2));
        }
    }

    private static void I_method_97b5b5e0(File file, String string) {
        try {
            Process process = new ProcessBuilder(file.getAbsolutePath(), "-m", "pip", "install", string, "--no-warn-script-location").redirectErrorStream(true).start();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));){
                String string2;
                while ((string2 = bufferedReader.readLine()) != null) {
                    RockstarClient.I_field_ab0f6068.info("[pip] {}", (Object)string2);
                }
            }
            int n = process.waitFor();
            if (n == 0) {
                RockstarClient.I_field_ab0f6068.info("[Scripts] \u0431\u0438\u0431\u043b\u0438\u043e\u0442\u0435\u043a\u0430 '{}' \u0433\u043e\u0442\u043e\u0432\u0430", (Object)string);
            } else {
                RockstarClient.I_field_ab0f6068.warn("[Scripts] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c '{}' (pip \u043a\u043e\u0434 {})", (Object)string, (Object)n);
                I_field_a56a8dc5.remove(string.toLowerCase(Locale.ROOT));
            }
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[Scripts] \u043e\u0448\u0438\u0431\u043a\u0430 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0438 '{}'", (Object)string, (Object)exception);
            I_field_a56a8dc5.remove(string.toLowerCase(Locale.ROOT));
        }
    }
}

