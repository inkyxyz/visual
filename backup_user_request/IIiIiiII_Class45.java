package rockstar.client;

import java.util.List;
import net.minecraft.text.Text;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IiIIiiII_Class77;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import ua.mintantileak.spk.Compile;

public class IIiIiiII_Class45 {
    public IIIiiIIi_Class26 I_method_f2cfeb8b() {
        return IIIiiIiI_Class27.I_method_fa8865f9("friend", iIIiiIiI_Class27 -> iIIiiIiI_Class27.I_method_b3f941e4("friends").i_method_cfe1a061("commands.friends.description").i_method_3d6e11d9("action", iIIiiiii_Class32 -> {
            iIIiiiii_Class32.I_method_a44fe164("add", "remove", "del", "delete", "clear", "list");
            iIIiiiii_Class32.I_method_f005ecf3("add", "remove", "clear", "list");
        }).i_method_3d6e11d9("id", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a)).I_method_16f05c8a(this::I_method_1930ab6d)).I_method_9111538b();
    }

    @Compile
    private void I_method_1930ab6d(IIIiiIii_Class28 iIIiiIii_Class28) {
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().get(0);
        String string2 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(1);
        IiIIiiII_Class77 iiIIiiII_Class77 = RockstarClient.getInstance().I_method_7a5acaeb();
        switch (string.toLowerCase()) {
            case "add": {
                iiIIiiII_Class77.I_method_19c94376(string2);
                break;
            }
            case "remove": 
            case "del": 
            case "delete": {
                iiIIiiII_Class77.i_method_ea809756(string2);
                break;
            }
            case "clear": {
                iiIIiiII_Class77.I_method_b08d6cac();
                break;
            }
            case "list": {
                this.I_method_56ef18ec();
            }
        }
    }

    @Compile
    private void I_method_56ef18ec() {
        List<String> list = RockstarClient.getInstance().I_method_7a5acaeb().I_method_dbf3f81b();
        if (list.isEmpty()) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.friends.empty")));
            return;
        }
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.friends.list")));
        for (int i = 0; i < list.size(); ++i) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.friends.list_item", i + 1, list.get(i))));
        }
    }
}

