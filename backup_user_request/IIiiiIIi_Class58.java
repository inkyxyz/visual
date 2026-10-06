package rockstar.client;

import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IiIIIiIIi_Class138;
import rockstar.client.RockstarClient;
import ua.mintantileak.spk.Compile;

public class IIiiiIIi_Class58 {
    @Compile
    public IIIiiIIi_Class26 I_method_b0096bab() {
        return IIIiiIiI_Class27.I_method_fa8865f9("target", iIIiiIiI_Class27 -> iIIiiIiI_Class27.I_method_b3f941e4("targets").i_method_cfe1a061("commands.target.description").i_method_3d6e11d9("action", iIIiiiii_Class32 -> {
            iIIiiiii_Class32.I_method_a44fe164("add", "remove", "del", "delete", "clear", "list");
            iIIiiiii_Class32.I_method_f005ecf3("add", "remove", "clear", "list");
        }).i_method_3d6e11d9("id", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a)).I_method_16f05c8a(this::I_method_3272f4d)).I_method_9111538b();
    }

    @Compile
    private void I_method_3272f4d(IIIiiIii_Class28 iIIiiIii_Class28) {
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().get(0);
        String string2 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(1);
        IiIIIiIIi_Class138 iiIIIiIIi_Class138 = RockstarClient.getInstance().I_method_9a638462();
        switch (string.toLowerCase()) {
            case "add": {
                iiIIIiIIi_Class138.I_method_9db25e69(string2);
                break;
            }
            case "remove": 
            case "del": 
            case "delete": {
                iiIIIiIIi_Class138.i_method_6e69b249(string2);
                break;
            }
            case "clear": {
                iiIIIiIIi_Class138.I_method_3b326e5f();
                break;
            }
            case "list": {
                iiIIIiIIi_Class138.i_method_3b40fa3f();
            }
        }
    }
}

