package rockstar.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import rockstar.client.RockstarClient;

public final class iIIIIIIiI_Class259 {
    private iIIIIIIiI_Class259() {
    }

    public static Optional<Path> I_method_5504c626() {
        Optional<Path> optional = iIIIIIIiI_Class259.i_method_9b37ee46();
        if (optional.isPresent()) {
            return optional;
        }
        if (iIIIIIIiI_Class259.I_method_84294643()) {
            return iIIIIIIiI_Class259.Ii_method_6e57c6a3().filter(iIIIIIIiI_Class259::I_method_75d40262);
        }
        return Optional.empty();
    }

    private static Optional<Path> i_method_9b37ee46() {
        Optional<Path> optional = iIIIIIIiI_Class259.I_method_27801425(iIIIIIIiI_Class259.I_method_1a2ac7ee());
        if (optional.isPresent()) {
            return optional;
        }
        return iIIIIIIiI_Class259.II_method_28249e83().flatMap(iIIIIIIiI_Class259::I_method_5217fa7).filter(path -> Files.isDirectory(path, new LinkOption[0]));
    }

    private static Optional<Path> I_method_27801425(Set<Path> set) {
        return set.stream().map(iIIIIIIiI_Class259::I_method_5217fa7).flatMap(Optional::stream).filter(path -> Files.isDirectory(path, new LinkOption[0])).max(Comparator.comparingInt(iIIIIIIiI_Class259::I_method_75d40251));
    }

    private static Set<Path> I_method_1a2ac7ee() {
        LinkedHashSet<Path> linkedHashSet = new LinkedHashSet<Path>();
        for (Path path : iIIIIIIiI_Class259.I_method_2acd6628()) {
            linkedHashSet.add(path.resolve("legacy.properties"));
        }
        return linkedHashSet;
    }

    private static Optional<Path> II_method_28249e83() {
        final AtomicReference atomicReference = new AtomicReference();
        for (final Path path : iIIIIIIiI_Class259.i_method_e0199e48()) {
            if (!Files.isDirectory(path, new LinkOption[0])) continue;
            try {
                Files.walkFileTree(path, Set.of(), 6, (FileVisitor<? super Path>)new SimpleFileVisitor<Path>(){

                    public FileVisitResult I_method_c07e1a3d(Path path2, BasicFileAttributes basicFileAttributes) {
                        if (!path.equals(path2) && iIIIIIIiI_Class259.i_method_f605de42(path2)) {
                            return FileVisitResult.SKIP_SUBTREE;
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    public FileVisitResult i_method_97c5125d(Path path2, BasicFileAttributes basicFileAttributes) {
                        String string = path2.getFileName().toString();
                        if (string.equalsIgnoreCase("legacy.properties") && iIIIIIIiI_Class259.I_method_5217fa7(path2).filter(path -> Files.isDirectory(path, new LinkOption[0])).isPresent()) {
                            atomicReference.set(path2);
                            return FileVisitResult.TERMINATE;
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    public FileVisitResult I_method_10b4ae53(Path path2, IOException iOException) {
                        return FileVisitResult.CONTINUE;
                    }

                });
            }
            catch (IOException iOException) {
                // empty catch block
            }
            if (atomicReference.get() == null) continue;
            return Optional.of((Path)atomicReference.get());
        }
        return Optional.empty();
    }

    static Optional<Path> I_method_5217fa7(Path path) {
        Object object;
        if (!Files.isRegularFile(path, new LinkOption[0])) {
            return Optional.empty();
        }
        Properties properties = new Properties();
        try {
            object = Files.newInputStream(path, new OpenOption[0]);
            try {
                properties.load((InputStream)object);
            }
            finally {
                if (object != null) {
                    ((InputStream)object).close();
                }
            }
        }
        catch (IOException iOException) {
            RockstarClient.I_field_ab0f6068.warn("Failed to read Legacy Launcher properties: {}", (Object)path, (Object)iOException);
            return Optional.empty();
        }
        object = properties.getProperty("minecraft.gamedir");
        if (object == null || ((String)object).isBlank()) {
            return Optional.empty();
        }
        try {
            Path path2 = path.toAbsolutePath().getParent();
            Path path3 = iIIIIIIiI_Class259.I_method_de9e868d(((String)object).trim(), path2);
            return Optional.of(path3.toAbsolutePath().normalize());
        }
        catch (RuntimeException runtimeException) {
            RockstarClient.I_field_ab0f6068.warn("Invalid Legacy Launcher minecraft.gamedir in {}", (Object)path, (Object)runtimeException);
            return Optional.empty();
        }
    }

    private static List<Path> I_method_2acd6628() {
        ArrayList<Path> arrayList = new ArrayList<Path>();
        Optional<Path> optional = iIIIIIIiI_Class259.iI_method_a8567a63();
        iIIIIIIiI_Class259.I_method_441e6ddc("APPDATA").ifPresent(path -> {
            arrayList.add(path.resolve("tlauncher"));
            arrayList.add(path.resolve(".tlauncher"));
            arrayList.add(path.resolve("Legacy Launcher"));
            arrayList.add(path.resolve("legacylauncher"));
        });
        iIIIIIIiI_Class259.I_method_441e6ddc("LOCALAPPDATA").ifPresent(path -> {
            arrayList.add(path.resolve("tlauncher"));
            arrayList.add(path.resolve(".tlauncher"));
            arrayList.add(path.resolve("Legacy Launcher"));
            arrayList.add(path.resolve("legacylauncher"));
        });
        iIIIIIIiI_Class259.I_method_441e6ddc("XDG_DATA_HOME").ifPresent(path -> arrayList.add(path.resolve("tlauncher")));
        iIIIIIIiI_Class259.I_method_441e6ddc("XDG_CONFIG_HOME").ifPresent(path -> arrayList.add(path.resolve("tlauncher")));
        optional.ifPresent(path -> {
            arrayList.add(path.resolve(".tlauncher"));
            arrayList.add(path.resolve("tlauncher"));
            arrayList.add(path.resolve("Legacy Launcher"));
            arrayList.add(path.resolve(".legacylauncher"));
            arrayList.add(path.resolve(".local").resolve("share").resolve("tlauncher"));
            arrayList.add(path.resolve(".config").resolve("tlauncher"));
            arrayList.add(path.resolve("Library").resolve("Application Support").resolve("tlauncher"));
            arrayList.add(path.resolve("AppData").resolve("Roaming").resolve("tlauncher"));
            arrayList.add(path.resolve("AppData").resolve("Roaming").resolve(".tlauncher"));
            arrayList.add(path.resolve("AppData").resolve("Local").resolve("tlauncher"));
            arrayList.add(path.resolve("AppData").resolve("Local").resolve(".tlauncher"));
        });
        return arrayList;
    }

    private static List<Path> i_method_e0199e48() {
        ArrayList<Path> arrayList = new ArrayList<Path>();
        iIIIIIIiI_Class259.I_method_441e6ddc("APPDATA").ifPresent(arrayList::add);
        iIIIIIIiI_Class259.I_method_441e6ddc("LOCALAPPDATA").ifPresent(arrayList::add);
        iIIIIIIiI_Class259.I_method_441e6ddc("XDG_DATA_HOME").ifPresent(arrayList::add);
        iIIIIIIiI_Class259.I_method_441e6ddc("XDG_CONFIG_HOME").ifPresent(arrayList::add);
        iIIIIIIiI_Class259.iI_method_a8567a63().ifPresent(path -> {
            arrayList.add(path.resolve("Library").resolve("Application Support"));
            arrayList.add(path.resolve("AppData").resolve("Roaming"));
            arrayList.add(path.resolve("AppData").resolve("Local"));
            arrayList.add(path.resolve(".local").resolve("share"));
            arrayList.add(path.resolve(".config"));
        });
        return arrayList;
    }

    private static boolean I_method_84294643() {
        for (Path path : iIIIIIIiI_Class259.I_method_2acd6628()) {
            if (!Files.isRegularFile(path.resolve("legacy.properties"), new LinkOption[0]) && !Files.isRegularFile(path.resolve("bin").resolve("legacy.jar"), new LinkOption[0])) continue;
            return true;
        }
        return false;
    }

    private static Optional<Path> Ii_method_6e57c6a3() {
        Optional<Path> optional = iIIIIIIiI_Class259.iI_method_a8567a63();
        if (optional.isEmpty()) {
            return Optional.empty();
        }
        String string = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
        if (string.contains("win")) {
            Optional<Path> optional2 = iIIIIIIiI_Class259.I_method_441e6ddc("APPDATA");
            return Optional.of(optional2.orElse(optional.get().resolve("AppData").resolve("Roaming")).resolve(".minecraft"));
        }
        if (string.contains("mac")) {
            return Optional.of(optional.get().resolve("Library").resolve("Application Support").resolve("minecraft"));
        }
        return Optional.of(optional.get().resolve(".minecraft"));
    }

    private static boolean I_method_75d40262(Path path) {
        return Files.isDirectory(path, new LinkOption[0]) && iIIIIIIiI_Class259.I_method_75d40251(path) > 0;
    }

    private static int I_method_75d40251(Path path) {
        String string2;
        int n = 0;
        for (String directoryName : (Iterable<String>)(Iterable<?>)List.of("versions", "resourcepacks", "mods", "saves", "assets", "libraries")) {
            if (!Files.isDirectory(path.resolve(directoryName), new LinkOption[0])) continue;
            n += 2;
        }
        for (String profileFileName : (Iterable<String>)(Iterable<?>)List.of("options.txt", "launcher_profiles.json", "tlauncher_profiles.json")) {
            if (!Files.isRegularFile(path.resolve(profileFileName), new LinkOption[0])) continue;
            n += 3;
        }
        Path path2 = path.getFileName();
        if (path2 != null && ((string2 = path2.toString().toLowerCase(Locale.ROOT)).equals("minecraft") || string2.equals(".minecraft"))) {
            ++n;
        }
        return n;
    }

    static boolean i_method_f605de42(Path path) {
        Path path2 = path.getFileName();
        if (path2 == null) {
            return false;
        }
        String string = path2.toString().toLowerCase(Locale.ROOT);
        return string.equals(".gradle") || string.equals(".m2") || string.equals(".git") || string.equals("node_modules") || string.equals("caches") || string.equals("cache") || string.equals("logs") || string.equals("build") || string.equals("target");
    }

    private static Path I_method_de9e868d(String string, Path path) {
        String string2 = iIIIIIIiI_Class259.i_method_89b71997(iIIIIIIiI_Class259.I_method_69983177(string));
        Path path2 = Path.of(string2, new String[0]);
        if (path2.isAbsolute()) {
            return path2;
        }
        return path.resolve(path2);
    }

    private static String I_method_69983177(String string) {
        if (string.equals("~")) {
            return iIIIIIIiI_Class259.iI_method_a8567a63().map(Path::toString).orElse(string);
        }
        if (string.startsWith("~/") || string.startsWith("~\\")) {
            return iIIIIIIiI_Class259.iI_method_a8567a63().map(path -> path.resolve(string.substring(2)).toString()).orElse(string);
        }
        return string;
    }

    private static String i_method_89b71997(String string) {
        String string2 = string;
        for (String string3 : System.getenv().keySet()) {
            String string4 = System.getenv(string3);
            if (string4 == null || string4.isBlank()) continue;
            string2 = string2.replace("%" + string3 + "%", string4);
            string2 = string2.replace("${" + string3 + "}", string4);
        }
        return string2;
    }

    private static Optional<Path> iI_method_a8567a63() {
        String string = System.getProperty("user.home");
        if (string == null || string.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(Path.of(string, new String[0]));
    }

    private static Optional<Path> I_method_441e6ddc(String string) {
        String string2 = System.getenv(string);
        if (string2 == null || string2.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(Path.of(string2, new String[0]));
    }
}

