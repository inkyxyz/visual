package rockstar.client;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import rockstar.client.IiIIiiIi_Class78;

public final class IiIIiiiI_Class79 {
    public static final String I_field_523beb0a = "RSV1:";
    private static final String i_field_523beb0a = "AES/CBC/PKCS5Padding";
    private static final int I_field_49 = 16;
    private static final String II_field_523beb0a = "/assets/rockstar/lang/ru_ru.lang";
    private static volatile Boolean I_field_1d5e853;

    private IiIIiiiI_Class79() {
    }

    public static boolean I_method_9fd2e39a(String string) {
        return string != null && string.startsWith(I_field_523beb0a);
    }

    public static boolean I_method_4d54d4d0() {
        Boolean bl = I_field_1d5e853;
        if (bl != null) {
            return bl;
        }
        boolean bl2 = false;
        try (InputStream inputStream = IiIIiiiI_Class79.class.getResourceAsStream(II_field_523beb0a);){
            if (inputStream != null) {
                byte[] byArray = inputStream.readNBytes(I_field_523beb0a.length());
                bl2 = I_field_523beb0a.equals(new String(byArray, StandardCharsets.UTF_8));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        I_field_1d5e853 = bl2;
        return bl2;
    }

    public static String I_method_90a3efca(String string) {
        if (!IiIIiiiI_Class79.I_method_9fd2e39a(string)) {
            return string;
        }
        byte[] byArray = IiIIiiIi_Class78.I_method_fde791d1();
        if (byArray == null) {
            throw new IllegalStateException();
        }
        try {
            byte[] byArray2 = Base64.getDecoder().decode(string.substring(I_field_523beb0a.length()));
            if (byArray2.length <= 16) {
                throw new IllegalStateException();
            }
            byte[] byArray3 = new byte[16];
            System.arraycopy(byArray2, 0, byArray3, 0, 16);
            byte[] byArray4 = new byte[byArray2.length - 16];
            System.arraycopy(byArray2, 16, byArray4, 0, byArray4.length);
            Cipher cipher = Cipher.getInstance(i_field_523beb0a);
            cipher.init(2, (Key)new SecretKeySpec(byArray, "AES"), new IvParameterSpec(byArray3));
            return new String(cipher.doFinal(byArray4), StandardCharsets.UTF_8);
        }
        catch (IllegalStateException illegalStateException) {
            throw illegalStateException;
        }
        catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
    }
}

