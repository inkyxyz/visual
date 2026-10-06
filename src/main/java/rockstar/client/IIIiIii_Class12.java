package rockstar.client;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import lombok.Generated;

public final class IIIiIii_Class12 {
    public static String I_method_e0ee66f7(String string) {
        return IIIiIii_Class12.I_method_9c5cafa9(string, StandardCharsets.UTF_8);
    }

    public static String I_method_9c5cafa9(String string, Charset charset) {
        return URLEncoder.encode(string, charset);
    }

    public static String i_method_10d4f17(String string) {
        return IIIiIii_Class12.i_method_544bafc9(string, StandardCharsets.UTF_8);
    }

    public static String i_method_544bafc9(String string, Charset charset) {
        return URLDecoder.decode(string, charset);
    }

    @Generated
    private IIIiIii_Class12() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
