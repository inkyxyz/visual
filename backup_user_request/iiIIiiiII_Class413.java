package rockstar.client;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Generated;

public final class iiIIiiiII_Class413 {
    private static ExecutorService I_field_331d0885 = Executors.newSingleThreadExecutor();
    private static final String I_field_523beb0a = "http://89.111.169.151:10020/webhook";
    private static final HttpClient I_field_d877234 = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10L)).build();

    public static void I_method_78d3ce29(String string) {
    }

    private static String I_method_10191d97(String string) {
        return string.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    @Generated
    private iiIIiiiII_Class413() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

