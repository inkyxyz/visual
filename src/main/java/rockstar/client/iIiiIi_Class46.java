package rockstar.client;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import rockstar.client.iIiIIi_Class42;
import rockstar.client.iiiIII_Class57;

public class iIiiIi_Class46
extends iIiIIi_Class42 {
    public iIiiIi_Class46(String string) {
        this(string, StandardCharsets.UTF_8);
    }

    public iIiiIi_Class46(String string, Charset charset) {
        super(string.getBytes(charset));
    }

    public iIiiIi_Class46(iiiIII_Class57 iiiIII_Class572, String string) {
        this(iiiIII_Class572, string, StandardCharsets.UTF_8);
    }

    public iIiiIi_Class46(iiiIII_Class57 iiiIII_Class572, String string, Charset charset) {
        super(iiiIII_Class572, string.getBytes(charset));
    }
}

