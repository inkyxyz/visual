package rockstar.client;

import rockstar.client.iiiiiii_Class128;

public interface IIIIiIII_Class9 {
    public void I_method_f2de637a(iiiiiii_Class128 var1);

    default public String I_method_dcc0dd54() {
        String string = this.getClass().getSimpleName();
        return string.endsWith("Behavior") ? string.substring(0, string.length() - "Behavior".length()) : string;
    }
}

