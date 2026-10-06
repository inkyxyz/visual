package rockstar.client;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.texture.NativeImage;

public final class iIIIIiiII_Class269 {
    public static String I_method_82ac9197(String string) throws IOException {
        URL uRL = new URL(string);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(10000);
        try (InputStream inputStream = httpURLConnection.getInputStream();){
            String string2 = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return string2;
        }
    }

    public static String i_method_a2cb79b7(String string) {
        Pattern pattern = Pattern.compile("\"url\"\\s*:\\s*\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(string);
        return matcher.find() ? matcher.group(1).replace("\\/", "/") : null;
    }

    public static NativeImage I_method_97bf3255(BufferedImage bufferedImage, boolean bl) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        NativeImage nativeImage = new NativeImage(n, n2, true);
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                int n3 = bufferedImage.getRGB(j, i);
                nativeImage.setColorArgb(j, i, n3);
            }
        }
        return nativeImage;
    }

    @Generated
    private iIIIIiiII_Class269() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

