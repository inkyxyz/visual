package globals.client.net;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;

public final class StompConnection {
    private static final char NUL = '\u0000';
    private static final String NUL_STR = String.valueOf('\u0000');
    private static final OkHttpClient CLIENT = new OkHttpClient.Builder().pingInterval(Duration.ofSeconds(15L)).build();
    private static final long HEARTBEAT_MS = 5000L;
    final Nested1_98864bfe handler;
    private volatile WebSocket ws;
    private final ScheduledExecutorService heartbeats = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Globals-Heartbeat");
        thread.setDaemon(true);
        return thread;
    });
    private volatile ScheduledFuture<?> heartbeatTask;

    public StompConnection(Nested1_98864bfe nested1_98864bfe) {
        this.handler = nested1_98864bfe;
    }

    public void connect(String string, final String string2) {
        Request request = new Request.Builder().url(string).build();
        this.ws = CLIENT.newWebSocket(request, new WebSocketListener(){

            public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
                linkedHashMap.put("accept-version", "1.2");
                linkedHashMap.put("heart-beat", "10000,10000");
                linkedHashMap.put("ticket", string2);
                webSocket.send(StompConnection.this.frame("CONNECT", linkedHashMap, null));
            }

            public void onMessage(@NotNull WebSocket webSocket, @NotNull String string) {
                StompConnection.this.onStompText(string);
            }

            public void onClosing(@NotNull WebSocket webSocket, int n, @NotNull String string) {
                webSocket.close(1000, null);
            }

            public void onClosed(@NotNull WebSocket webSocket, int n, @NotNull String string) {
                StompConnection.this.shutdownHeartbeats();
                StompConnection.this.handler.onClosed();
            }

            public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable throwable, Response response) {
                StompConnection.this.shutdownHeartbeats();
                StompConnection.this.handler.onError(throwable);
            }
        });
    }

    public void subscribe(String string, String string2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("id", string2);
        linkedHashMap.put("destination", string);
        this.sendFrame(this.frame("SUBSCRIBE", linkedHashMap, null));
    }

    public void sendJson(String string, String string2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("destination", string);
        linkedHashMap.put("content-type", "application/json");
        linkedHashMap.put("content-length", String.valueOf(string2.getBytes(StandardCharsets.UTF_8).length));
        this.sendFrame(this.frame("SEND", linkedHashMap, string2));
    }

    public void disconnect() {
        this.shutdownHeartbeats();
        WebSocket webSocket = this.ws;
        if (webSocket != null) {
            webSocket.close(1000, null);
        }
    }

    private void startHeartbeats() {
        this.stopHeartbeats();
        this.heartbeatTask = this.heartbeats.scheduleWithFixedDelay(() -> {
            WebSocket webSocket = this.ws;
            if (webSocket != null) {
                webSocket.send("\n");
            }
        }, 5000L, 5000L, TimeUnit.MILLISECONDS);
    }

    private void stopHeartbeats() {
        ScheduledFuture<?> scheduledFuture = this.heartbeatTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.heartbeatTask = null;
        }
    }

    void shutdownHeartbeats() {
        this.stopHeartbeats();
        this.heartbeats.shutdownNow();
    }

    private void sendFrame(String string) {
        WebSocket webSocket = this.ws;
        if (webSocket != null) {
            webSocket.send(string);
        }
    }

    void onStompText(String string) {
        block10: for (String string2 : string.split(NUL_STR)) {
            String string3 = string2.replaceFirst("^\\n+", "");
            if (string3.isEmpty()) continue;
            int n = string3.indexOf("\n\n");
            String string4 = n >= 0 ? string3.substring(0, n) : string3;
            String string5 = n >= 0 ? string3.substring(n + 2) : "";
            String[] stringArray = string4.split("\n");
            String string6 = stringArray[0];
            HashMap<String, String> hashMap = new HashMap<String, String>();
            for (int i = 1; i < stringArray.length; ++i) {
                int n2 = stringArray[i].indexOf(58);
                if (n2 <= 0) continue;
                hashMap.put(stringArray[i].substring(0, n2), stringArray[i].substring(n2 + 1));
            }
            switch (string6) {
                case "CONNECTED": {
                    this.startHeartbeats();
                    this.handler.onConnected();
                    continue block10;
                }
                case "MESSAGE": {
                    this.handler.onMessage(hashMap.getOrDefault("destination", ""), string5);
                    continue block10;
                }
                case "ERROR": {
                    this.handler.onError(new RuntimeException("STOMP ERROR: " + hashMap.getOrDefault("message", string5)));
                    continue block10;
                }
            }
        }
    }

    String frame(String string3, Map<String, String> map, String string4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3).append('\n');
        map.forEach((string, string2) -> stringBuilder.append((String)string).append(':').append((String)string2).append('\n'));
        stringBuilder.append('\n');
        if (string4 != null) {
            stringBuilder.append(string4);
        }
        stringBuilder.append('\u0000');
        return stringBuilder.toString();
    }

    public static interface Nested1_98864bfe {
        public void onConnected();

        public void onMessage(String var1, String var2);

        public void onClosed();

        public void onError(Throwable var1);
    }
}

