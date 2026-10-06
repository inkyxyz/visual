package globals.client.auth;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import globals.client.auth.Session;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import rockstar.client.IiIIiIII_Class73;

final class SessionStore {
    private static final File FILE = new File(IiIIiIII_Class73.I_field_3a58077, "session.json");
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int NONCE_BYTES = 12;
    private static final int TAG_BITS = 128;

    private SessionStore() {
    }

    static Session load() {
        if (!FILE.exists()) {
            return null;
        }
        try {
            JsonObject jsonObject = JsonParser.parseString((String)Files.readString(FILE.toPath(), StandardCharsets.UTF_8)).getAsJsonObject();
            String string = SessionStore.decrypt(jsonObject.get("data").getAsString());
            JsonObject jsonObject2 = JsonParser.parseString((String)string).getAsJsonObject();
            return new Session(null, jsonObject2.get("refresh").getAsString(), 0L, jsonObject2.has("username") ? jsonObject2.get("username").getAsString() : null, jsonObject2.has("uid") ? Integer.valueOf(jsonObject2.get("uid").getAsInt()) : null, jsonObject2.has("role") ? jsonObject2.get("role").getAsString() : null);
        }
        catch (Exception exception) {
            return null;
        }
    }

    static void save(Session session) {
        if (session == null || session.refresh() == null) {
            return;
        }
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("refresh", session.refresh());
            if (session.username() != null) {
                jsonObject.addProperty("username", session.username());
            }
            if (session.uid() != null) {
                jsonObject.addProperty("uid", (Number)session.uid());
            }
            if (session.role() != null) {
                jsonObject.addProperty("role", session.role());
            }
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("v", (Number)1);
            jsonObject2.addProperty("data", SessionStore.encrypt(jsonObject.toString()));
            IiIIiIII_Class73.I_method_3b2973c6(FILE, (JsonElement)jsonObject2);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static void clear() {
        try {
            Files.deleteIfExists(FILE.toPath());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static boolean exists() {
        return FILE.exists();
    }

    private static String encrypt(String string) throws Exception {
        byte[] byArray = new byte[12];
        RANDOM.nextBytes(byArray);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, (Key)SessionStore.key(), new GCMParameterSpec(128, byArray));
        byte[] byArray2 = cipher.doFinal(string.getBytes(StandardCharsets.UTF_8));
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return Base64.getEncoder().encodeToString(byArray3);
    }

    private static String decrypt(String string) throws Exception {
        byte[] byArray = Base64.getDecoder().decode(string);
        byte[] byArray2 = new byte[12];
        System.arraycopy(byArray, 0, byArray2, 0, 12);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, (Key)SessionStore.key(), new GCMParameterSpec(128, byArray2));
        byte[] byArray3 = cipher.doFinal(byArray, 12, byArray.length - 12);
        return new String(byArray3, StandardCharsets.UTF_8);
    }

    private static SecretKeySpec key() throws Exception {
        String string = String.join((CharSequence)"|", String.valueOf(System.getProperty("user.name")), String.valueOf(System.getenv("COMPUTERNAME")), String.valueOf(System.getenv("USERDOMAIN")), IiIIiIII_Class73.I_field_3a58077.getAbsolutePath());
        byte[] byArray = MessageDigest.getInstance("SHA-256").digest(string.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(byArray, "AES");
    }
}

