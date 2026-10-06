package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import rockstar.client.ModuleEntry;
import rockstar.client.RockstarClient;

public class iiIiIIiiI_Class423 {
    private static final String I_field_523beb0a = "wss://api.deepgram.com/v1/listen?model=nova-2&language=ru&encoding=linear16&sample_rate=16000&interim_results=true&punctuate=true&smart_format=true&endpointing=1000";
    private final String i_field_523beb0a;
    private final OkHttpClient I_field_c872e00;
    private WebSocket I_field_1d93ec60;
    private TargetDataLine I_field_16bc3ff2;
    private Thread I_field_72a5fc31;
    private volatile boolean I_field_5a;
    private Consumer<String> I_field_f9f609fa = string -> {};
    private Consumer<String> i_field_f9f609fa = string -> {};

    public iiIiIIiiI_Class423(String string2) {
        this.i_field_523beb0a = Objects.requireNonNull(string2, "apiKey");
        this.I_field_c872e00 = new OkHttpClient.Builder().readTimeout(0L, TimeUnit.MILLISECONDS).build();
    }

    public iiIiIIiiI_Class423 I_method_a004268b(Consumer<String> consumer) {
        this.I_field_f9f609fa = consumer != null ? consumer : string -> {};
        return this;
    }

    public iiIiIIiiI_Class423 i_method_b6bdbeab(Consumer<String> consumer) {
        this.i_field_f9f609fa = consumer != null ? consumer : string -> {};
        return this;
    }

    public void I_method_ed460a5f() throws Exception {
        if (this.I_field_5a) {
            return;
        }
        this.I_field_5a = true;
        StringBuilder stringBuilder = new StringBuilder(I_field_523beb0a);
        for (ModuleEntry iiIiiIii_Class92 : RockstarClient.getInstance().getModuleManager().getModules()) {
            stringBuilder.append("&keywords=" + iiIiiIii_Class92.getName() + ":5");
        }
        Request request = new Request.Builder().url(stringBuilder.toString()).addHeader("Authorization", "Token " + this.i_field_523beb0a).build();
        this.I_field_1d93ec60 = this.I_field_c872e00.newWebSocket(request, new WebSocketListener(){

            public void onOpen(WebSocket webSocket, Response response) {
                try {
                    iiIiIIiiI_Class423.this.I_method_bd5475b(webSocket);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    iiIiIIiiI_Class423.this.i_method_ed54963f();
                }
            }

            public void onMessage(WebSocket webSocket, String string) {
                iiIiIIiiI_Class423.this.I_method_e496fa69(string);
            }

            public void onMessage(WebSocket webSocket, ByteString byteString) {
            }

            public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
                System.err.println("[Deepgram] WS failure: " + String.valueOf(throwable));
                iiIiIIiiI_Class423.this.i_method_ed54963f();
            }

            public void onClosing(WebSocket webSocket, int n, String string) {
                webSocket.close(1000, null);
            }

            public void onClosed(WebSocket webSocket, int n, String string) {
            }
        });
    }

    public void i_method_ed54963f() {
        this.I_field_5a = false;
        try {
            if (this.I_field_1d93ec60 != null) {
                this.I_field_1d93ec60.send("{\"type\":\"CloseStream\"}");
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (this.I_field_72a5fc31 != null) {
                this.I_field_72a5fc31.join(500L);
                this.I_field_72a5fc31 = null;
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        try {
            if (this.I_field_16bc3ff2 != null) {
                this.I_field_16bc3ff2.stop();
                this.I_field_16bc3ff2.close();
                this.I_field_16bc3ff2 = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            if (this.I_field_1d93ec60 != null) {
                this.I_field_1d93ec60.close(1000, "bye");
                this.I_field_1d93ec60 = null;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    void I_method_bd5475b(WebSocket webSocket) throws Exception {
        AudioFormat audioFormat = new AudioFormat(16000.0f, 16, 1, true, false);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
        this.I_field_16bc3ff2 = (TargetDataLine)AudioSystem.getLine(info);
        this.I_field_16bc3ff2.open(audioFormat);
        this.I_field_16bc3ff2.start();
        this.I_field_72a5fc31 = new Thread(() -> {
            byte[] byArray = new byte[3200];
            long l = System.currentTimeMillis();
            while (this.I_field_5a && this.I_field_16bc3ff2.isOpen()) {
                int n = this.I_field_16bc3ff2.read(byArray, 0, byArray.length);
                if (n > 0) {
                    webSocket.send(ByteString.of((byte[])byArray, (int)0, (int)n));
                    l = System.currentTimeMillis();
                }
                if (System.currentTimeMillis() - l <= 4000L) continue;
                webSocket.send("{\"type\":\"KeepAlive\"}");
                l = System.currentTimeMillis();
            }
        }, "Deepgram-MicPump");
        this.I_field_72a5fc31.setDaemon(true);
        this.I_field_72a5fc31.start();
    }

    void I_method_e496fa69(String string) {
        try {
            JsonObject jsonObject = JsonParser.parseString((String)string).getAsJsonObject();
            if (!jsonObject.has("type") || !"Results".equals(jsonObject.get("type").getAsString())) {
                return;
            }
            boolean bl = jsonObject.has("is_final") && jsonObject.get("is_final").getAsBoolean();
            JsonObject jsonObject2 = jsonObject.getAsJsonObject("channel");
            if (jsonObject2 == null) {
                return;
            }
            JsonArray jsonArray = jsonObject2.getAsJsonArray("alternatives");
            if (jsonArray == null || jsonArray.size() == 0) {
                return;
            }
            String string2 = jsonArray.get(0).getAsJsonObject().get("transcript").getAsString();
            if (string2 == null || string2.isBlank()) {
                return;
            }
            if (bl) {
                this.i_field_f9f609fa.accept(string2);
            } else {
                this.I_field_f9f609fa.accept(string2);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

