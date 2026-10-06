package rockstar.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class iiiiII_Class61
extends Authenticator {
    private final PasswordAuthentication I_field_fbc6a3f5;

    public iiiiII_Class61(String string, String string2) {
        this.I_field_fbc6a3f5 = new PasswordAuthentication(string, string2.toCharArray());
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return this.I_field_fbc6a3f5;
    }
}

