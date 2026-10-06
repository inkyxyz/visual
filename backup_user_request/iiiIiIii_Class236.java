package rockstar.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import lombok.SneakyThrows;
import net.minecraft.client.MinecraftClient;
import rockstar.client.IIiiIiIIi_Class106;
import rockstar.client.IiIIiiiI_Class79;
import rockstar.client.RockstarClient;
import rockstar.client.iiiIiiII_Class237;

public final class iiiIiIii_Class236 {
    private static final String I_field_523beb0a = "assets/rockstar/neuro/trainer/";
    private static final String i_field_523beb0a = "common.py";
    private static final String II_field_523beb0a = "train_aura.py";
    private static final String Ii_field_523beb0a = "https://download.pytorch.org/whl/cpu";
    private static final String iI_field_523beb0a = "https://pypi.org/simple";
    private static volatile boolean I_field_5a;
    private static volatile boolean i_field_5a;
    private static volatile String ii_field_523beb0a;

    private iiiIiIii_Class236() {
    }

    public static void I_method_f4c1750c() {
        if (I_field_5a) {
            return;
        }
        I_field_5a = true;
        Thread thread = new Thread(iiiIiIii_Class236::i_method_f4d000ec, "Neuro-Trainer-Setup");
        thread.setDaemon(true);
        thread.start();
    }

    private static void i_method_f4d000ec() {
        File file = iiiIiIii_Class236.I_method_a38de381();
        if (file == null) {
            return;
        }
        if (iiiIiIii_Class236.i_method_f4d000f0()) {
            RockstarClient.I_field_ab0f6068.info("[Neuro] \u0442\u0440\u0435\u043d\u0435\u0440 \u0433\u043e\u0442\u043e\u0432: numpy \u0438 torch \u043d\u0430 \u043c\u0435\u0441\u0442\u0435");
            return;
        }
        iiiIiIii_Class236.I_method_ed0eb983(file);
    }

    private static void I_method_ed0eb983(File file) {
        i_field_5a = true;
        try {
            if (!iiiIiIii_Class236.II_method_a37c23d9() && !iiiIiIii_Class236.I_method_805c9ec0(file, "numpy")) {
                return;
            }
            if (!iiiIiIii_Class236.Ii_method_a38aafb9()) {
                RockstarClient.I_field_ab0f6068.info("[Neuro] \u043a\u0430\u0447\u0430\u044e torch \u0434\u043b\u044f \u0442\u0440\u0435\u043d\u0435\u0440\u0430 (~200 \u041c\u0411, \u0440\u0430\u0437\u043e\u0432\u043e)");
                if (!iiiIiIii_Class236.I_method_805c9ec0(file, "torch", "--index-url", Ii_field_523beb0a, "--extra-index-url", iI_field_523beb0a)) {
                    return;
                }
            }
            if (iiiIiIii_Class236.i_method_f4d000f0()) {
                RockstarClient.I_field_ab0f6068.info("[Neuro] \u0437\u0430\u0432\u0438\u0441\u0438\u043c\u043e\u0441\u0442\u0438 \u0442\u0440\u0435\u043d\u0435\u0440\u0430 \u043d\u0430 \u043c\u0435\u0441\u0442\u0435, \u043e\u0431\u0443\u0447\u0435\u043d\u0438\u0435 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e");
                ii_field_523beb0a = null;
            }
        }
        finally {
            i_field_5a = false;
        }
    }

    private static boolean I_method_805c9ec0(File file, String ... stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>(List.of(file.getAbsolutePath(), "-m", "pip", "install"));
        arrayList.addAll(List.of(stringArray));
        arrayList.add("--no-warn-script-location");
        arrayList.add("--disable-pip-version-check");
        try {
            Process process = new ProcessBuilder(arrayList).redirectErrorStream(true).start();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));){
                String string;
                while ((string = bufferedReader.readLine()) != null) {
                    if (string.isBlank()) continue;
                    RockstarClient.I_field_ab0f6068.info("[Neuro][pip] {}", (Object)string.strip());
                }
            }
            int n = process.waitFor();
            if (n == 0) {
                return true;
            }
            ii_field_523beb0a = "pip " + stringArray[0] + " \u0432\u0435\u0440\u043d\u0443\u043b " + n;
            RockstarClient.I_field_ab0f6068.warn("[Neuro] {} \u043d\u0435 \u043f\u043e\u0441\u0442\u0430\u0432\u0438\u043b\u0441\u044f (\u043a\u043e\u0434 {})", (Object)stringArray[0], (Object)n);
        }
        catch (Exception exception) {
            ii_field_523beb0a = exception.getMessage();
            RockstarClient.I_field_ab0f6068.error("[Neuro] \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 {} \u0441\u043e\u0440\u0432\u0430\u043b\u0430\u0441\u044c", (Object)stringArray[0], (Object)exception);
        }
        return false;
    }

    public static Process I_method_621cbf21(File file, Path path, Path path2, String string) throws Exception {
        String string2 = iiiIiIii_Class236.i_method_c4e66934();
        ArrayList<String> arrayList = new ArrayList<String>(List.of(file.getAbsolutePath(), "-u", "-", "--data", path.toString(), "--out", path2.toString()));
        if (string != null) {
            arrayList.add("--epochs");
            arrayList.add(string);
        }
        ProcessBuilder processBuilder = new ProcessBuilder(arrayList).redirectErrorStream(true);
        processBuilder.environment().put("PYTHONIOENCODING", "utf-8");
        processBuilder.environment().put("PYTHONDONTWRITEBYTECODE", "1");
        Process process = processBuilder.start();
        try (OutputStream outputStream = process.getOutputStream();){
            outputStream.write(string2.getBytes(StandardCharsets.UTF_8));
        }
        return process;
    }

    private static String i_method_c4e66934() {
        String string = iiiIiIii_Class236.i_method_4e04faa(iiiIiIii_Class236.I_method_e4c1678a(i_field_523beb0a));
        String string2 = iiiIiIii_Class236.i_method_4e04faa(iiiIiIii_Class236.I_method_e4c1678a(II_field_523beb0a));
        String string3 = iiiIiIii_Class236.I_method_7288d869().toString().replace("\\", "\\\\");
        return "import base64, sys, types\n__rs_home = \"%s\"\n__rs_common = types.ModuleType(\"common\")\n__rs_common.__file__ = __rs_home + \"/common.py\"\nexec(compile(base64.b64decode(\"%s\").decode(\"utf-8\"), \"common.py\", \"exec\"),\n     __rs_common.__dict__)\nsys.modules[\"common\"] = __rs_common\n__rs_globals = {\"__name__\": \"__main__\", \"__file__\": __rs_home + \"/train_aura.py\"}\nexec(compile(base64.b64decode(\"%s\").decode(\"utf-8\"), \"train_aura.py\", \"exec\"),\n     __rs_globals)\n".formatted(string3, string, string2);
    }

    @SneakyThrows(IOException.class)
    private static String I_method_e4c1678a(String string) {
        String string2;
        block12: {
            Path path = MinecraftClient.getInstance().runDirectory.toPath().resolve("../tools/rotation-model/" + string).normalize();
            try {
                if (Files.isRegularFile(path, new LinkOption[0])) {
                    return Files.readString(path, StandardCharsets.UTF_8);
                }
            }
            catch (Exception exception) {
                RockstarClient.I_field_ab0f6068.warn("[Neuro] \u043d\u0435 \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c \u0442\u0440\u0435\u043d\u0435\u0440 \u0438\u0437 \u0440\u0435\u043f\u043e\u0437\u0438\u0442\u043e\u0440\u0438\u044f: {}", (Object)exception.getMessage());
            }
            InputStream inputStream = iiiIiIii_Class236.class.getClassLoader().getResourceAsStream(I_field_523beb0a + string);
            try {
                if (inputStream == null) {
                    throw new IllegalStateException("\u0432 jar \u043d\u0435\u0442 " + string);
                }
                string2 = IiIIiiiI_Class79.I_method_90a3efca(new String(inputStream.readAllBytes(), StandardCharsets.UTF_8));
                if (inputStream == null) break block12;
            }
            catch (Throwable throwable) {
                try {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    }
                    throw throwable;
                }
                catch (Exception exception) {
                    throw new IllegalStateException("\u0442\u0440\u0435\u043d\u0435\u0440 \u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f: " + exception.getMessage(), exception);
                }
            }
            inputStream.close();
        }
        return string2;
    }

    private static String i_method_4e04faa(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes(StandardCharsets.UTF_8));
    }

    public static boolean I_method_f4c17510() {
        return i_field_5a;
    }

    public static String I_method_31c7b914() {
        return ii_field_523beb0a;
    }

    public static boolean i_method_f4d000f0() {
        return iiiIiIii_Class236.II_method_a37c23d9() && iiiIiIii_Class236.Ii_method_a38aafb9();
    }

    public static boolean II_method_a37c23d9() {
        return iiiIiIii_Class236.I_method_abeff3da("numpy");
    }

    public static boolean Ii_method_a38aafb9() {
        return iiiIiIii_Class236.I_method_abeff3da("torch");
    }

    private static boolean I_method_abeff3da(String string) {
        File file = IIiiIiIIi_Class106.I_method_1233012e();
        return new File(file, "Lib/site-packages/" + string + "/__init__.py").isFile() || new File(file, "lib/python3.11/site-packages/" + string + "/__init__.py").isFile();
    }

    public static Path I_method_7288d869() {
        return iiiIiiII_Class237.I_method_db76ec89().resolve("trainer");
    }

    public static File I_method_a38de381() {
        File file = IIiiIiIIi_Class106.I_method_1233012e();
        File file2 = new File(file, "python.exe");
        if (file2.isFile()) {
            return file2;
        }
        File file3 = new File(file, "bin/python3");
        return file3.isFile() ? file3 : null;
    }
}
