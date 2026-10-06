package rockstar.client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIiiII_Class269;
import rockstar.client.iIIiIIiIi_Class294;

public final class iiiIiii_Class120 {
    private static final String I_field_523beb0a = "image/mainmenu/fallback.jpg";
    private static final Map<String, Identifier> I_field_a567c40b = new ConcurrentHashMap<String, Identifier>();
    private static final Map<String, Float> i_field_a567c40b = new ConcurrentHashMap<String, Float>();
    private static final Set<String> I_field_a56a8dc5 = ConcurrentHashMap.newKeySet();
    private static final ExecutorService I_field_331d0885 = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Rockstar-AssetPack");
        thread.setDaemon(true);
        return thread;
    });
    private static volatile Identifier I_field_6a3d6525;

    private iiiIiii_Class120() {
    }

    public static File I_method_110e330e() {
        return new File(IiIIiIII_Class73.I_field_3a58077, "assets");
    }

    public static boolean I_method_6de4546d(String string) {
        if (I_field_a567c40b.containsKey(string)) {
            return true;
        }
        iiiIiii_Class120.I_method_601d95f8(string);
        return false;
    }

    public static Identifier I_method_601d95f8(String string) {
        Identifier identifier = I_field_a567c40b.get(string);
        if (identifier != null) {
            return identifier;
        }
        File file = iiiIiii_Class120.I_method_d1dfa344(string);
        if (file != null && I_field_a56a8dc5.add(string)) {
            I_field_331d0885.execute(() -> iiiIiii_Class120.I_method_88f4f220(string, file));
        } else if (file == null && I_field_a56a8dc5.add(string)) {
            I_field_331d0885.execute(() -> {
                try {
                    for (String ext : new String[]{".jpg", ".png"}) {
                        InputStream is = iiiIiii_Class120.class.getResourceAsStream("/assets/rockstar/" + string + ext);
                        if (is != null) {
                            BufferedImage img = ImageIO.read(is);
                            if (img != null) {
                                iiiIiii_Class120.I_method_f65f1ff1(string, img, RockstarClient.id("pack/" + string + ".png"));
                                return;
                            }
                        }
                    }
                } catch (Throwable t) {
                    I_field_a56a8dc5.remove(string);
                }
            });
        }
        return iiiIiii_Class120.I_method_3b1b536e();
    }

    public static float I_method_6de45459(String string) {
        return i_field_a567c40b.getOrDefault(string, Float.valueOf(0.0f)).floatValue();
    }

    public static void I_method_1515e45f() {
        ArrayList<Identifier> arrayList = new ArrayList<Identifier>(I_field_a567c40b.values());
        I_field_a567c40b.clear();
        i_field_a567c40b.clear();
        I_field_a56a8dc5.clear();
        iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> arrayList.forEach(identifier -> iIIiIIiIi_Class294.I_field_3a9bda27.getTextureManager().destroyTexture(identifier)));
    }

    private static void I_method_88f4f220(String string, File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            if (bufferedImage == null) {
                RockstarClient.I_field_ab0f6068.warn("[Assets] \u043d\u0435 \u043f\u043e\u043d\u044f\u043b \u0444\u043e\u0440\u043c\u0430\u0442 {}", (Object)file);
                return;
            }
            iiiIiii_Class120.I_method_f65f1ff1(string, bufferedImage, RockstarClient.id("pack/" + string + ".png"));
        }
        catch (Throwable throwable) {
            RockstarClient.I_field_ab0f6068.warn("[Assets] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c {}: {}", (Object)file, (Object)throwable.toString());
            I_field_a56a8dc5.remove(string);
        }
    }

    private static Identifier I_method_3b1b536e() {
        Identifier identifier = I_field_6a3d6525;
        if (identifier != null) {
            return identifier;
        }
        I_field_6a3d6525 = identifier = RockstarClient.id("pack/fallback.png");
        try (InputStream inputStream = iiiIiii_Class120.class.getResourceAsStream("/assets/rockstar/image/mainmenu/fallback.jpg");){
            BufferedImage bufferedImage;
            if (inputStream != null && (bufferedImage = ImageIO.read(inputStream)) != null) {
                iiiIiii_Class120.I_method_f65f1ff1(I_field_523beb0a, bufferedImage, identifier);
            }
        }
        catch (Throwable throwable) {
            RockstarClient.I_field_ab0f6068.warn("[Assets] \u0432\u0441\u0442\u0440\u043e\u0435\u043d\u043d\u0430\u044f \u0437\u0430\u0433\u043b\u0443\u0448\u043a\u0430 \u043d\u0435 \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u043b\u0430\u0441\u044c: {}", (Object)throwable.toString());
        }
        return identifier;
    }

    private static void I_method_f65f1ff1(String string, BufferedImage bufferedImage, Identifier identifier) {
        NativeImage nativeImage = iIIIIiiII_Class269.I_method_97bf3255(bufferedImage, false);
        float f = (float)bufferedImage.getWidth() / (float)Math.max(1, bufferedImage.getHeight());
        iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> {
            iIIiIIiIi_Class294.I_field_3a9bda27.getTextureManager().registerTexture(identifier, (AbstractTexture)new NativeImageBackedTexture(nativeImage));
            i_field_a567c40b.put(string, Float.valueOf(f));
            I_field_a567c40b.put(string, identifier);
            I_field_a56a8dc5.remove(string);
        });
    }

    private static File I_method_d1dfa344(String string) {
        for (String string2 : new String[]{".jpg", ".png"}) {
            File file = new File(iiiIiii_Class120.I_method_110e330e(), string + string2);
            if (!file.isFile()) continue;
            return file;
        }
        return null;
    }
}

