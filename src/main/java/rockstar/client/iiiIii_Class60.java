package rockstar.client;

import java.net.Proxy;

public enum iiiIii_Class60 {
    I_field_58cff641,
    i_field_58cff641,
    II_field_58cff641;


    public static iiiIii_Class60 I_method_6dae3bf1(Proxy.Type type) {
        switch (type) {
            case HTTP: {
                return I_field_58cff641;
            }
            case SOCKS: {
                return II_field_58cff641;
            }
        }
        throw new IllegalArgumentException("Unknown proxy type: " + type.name());
    }
}

