package rockstar.client;

import net.minecraft.text.Text;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIIiiiIi_Class30;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import ua.mintantileak.spk.Compile;

public class IIiiIiIi_Class54 {
    @Compile
    public IIIiiIIi_Class26 I_method_c70867eb() {
        return IIIiiIiI_Class27.I_method_fa8865f9("prefix", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.prefix.description").i_method_3d6e11d9("action", iIIiiiii_Class32 -> {
            iIIiiiii_Class32.I_method_e930dfcb().I_method_a44fe164("list", "clear", "default", "reset", "set", "create");
            iIIiiiii_Class32.I_method_f005ecf3("list", "reset", "set");
        }).i_method_3d6e11d9("new", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(string -> string.length() > 1 ? IIiIIIIi_Class34.I_method_c9d442bc(IiIiIIII_Class81.I_method_f25a980a("commands.prefix.invalid_length")) : IIiIIIIi_Class34.I_method_12fc454a(string))).I_method_16f05c8a(this::I_method_cc07bb0d)).I_method_9111538b();
    }

    @Compile
    private void I_method_cc07bb0d(IIIiiIii_Class28 iIIiiIii_Class28) {
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().get(0);
        String string2 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(1);
        IIIiiiIi_Class30 iIIiiiIi_Class30 = RockstarClient.getInstance().I_method_b4d046cb();
        String string3 = iIIiiiIi_Class30.I_method_80ea594();
        if (string == null) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.prefix.current", string3)));
            return;
        }
        switch (string.toLowerCase()) {
            case "list": {
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.prefix.current", string3)));
                break;
            }
            case "clear": 
            case "default": 
            case "reset": {
                iIIiiiIi_Class30.I_method_9e869756(".");
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.prefix.reset")));
                break;
            }
            case "set": 
            case "create": {
                if (string2 == null || string2.isEmpty()) {
                    iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.prefix.empty")));
                    return;
                }
                iIIiiiIi_Class30.I_method_9e869756(string2);
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.prefix.set", string2)));
            }
        }
    }
}

