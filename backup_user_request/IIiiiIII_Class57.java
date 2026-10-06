package rockstar.client;

import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.List;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IiIIIIiii_Class136;
import rockstar.client.IiIIIiii_Class72;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import ua.mintantileak.spk.Compile;

public class IIiiiIII_Class57 {
    @Compile
    public IIIiiIIi_Class26 I_method_12f0638b() {
        return IIIiiIiI_Class27.I_method_fa8865f9("staff", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.staff.description").i_method_3d6e11d9("action", iIIiiiii_Class32 -> {
            iIIiiiii_Class32.I_method_a44fe164("add", "remove", "del", "dell", "delete", "clear", "list", "dir");
            iIIiiiii_Class32.I_method_f005ecf3("add", "remove", "clear", "list", "dir");
        }).i_method_3d6e11d9("first", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a)).i_method_3d6e11d9("second", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a)).I_method_16f05c8a(this::I_method_fd1f336d)).I_method_9111538b();
    }

    @Compile
    private void I_method_fd1f336d(IIIiiIii_Class28 iIIiiIii_Class28) {
        RockstarClient.getInstance().I_method_7a4c3f0b().I_method_de9edf96("staff");
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().get(0);
        String string2 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(1);
        String string3 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(2);
        IiIIIIiii_Class136 iiIIIIiii_Class136 = RockstarClient.getInstance().I_method_98af9842();
        switch (string.toLowerCase()) {
            case "add": {
                this.I_method_95f20dee(iiIIIIiii_Class136, string2, string3);
                break;
            }
            case "remove": 
            case "del": 
            case "dell": 
            case "delete": {
                iiIIIIiii_Class136.I_method_34c44a49(string2);
                break;
            }
            case "clear": {
                iiIIIIiii_Class136.I_method_4b91923f();
                break;
            }
            case "list": {
                this.I_method_bebf3dda(iiIIIIiii_Class136);
                break;
            }
            case "dir": {
                this.I_method_e3f7a0ec();
                break;
            }
            default: {
                iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.staff.unknown_action")));
            }
        }
    }

    private void I_method_e3f7a0ec() {
        try {
            Files.createDirectories(IiIIiIII_Class73.I_field_3a58077.toPath(), new FileAttribute[0]);
            IiIIIiii_Class72 iiIIIiii_Class72 = RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("staff");
            if (iiIIIiii_Class72 != null && !iiIIIiii_Class72.I_method_aa990001().exists()) {
                RockstarClient.getInstance().I_method_7a4c3f0b().i_method_6702f2ed(iiIIIiii_Class72);
            }
            Util.getOperatingSystem().open(IiIIiIII_Class73.I_field_3a58077.toURI());
        }
        catch (Exception exception) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.staff.dir_error", exception.getMessage())));
        }
    }

    private void I_method_95f20dee(IiIIIIiii_Class136 iiIIIIiii_Class136, String string, String string2) {
        if (string == null || string.isBlank()) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.staff.empty_name")));
            return;
        }
        if (string2 == null || string2.isBlank()) {
            iiIIIIiii_Class136.I_method_7460d3d3(string, "MODER");
            return;
        }
        iiIIIIiii_Class136.I_method_7460d3d3(string2, string);
    }

    private void I_method_bebf3dda(IiIIIIiii_Class136 iiIIIIiii_Class136) {
        List<IiIIIIiii_Class136.Nested1_739d8c40> list = iiIIIIiii_Class136.I_method_f4439a28();
        if (list.isEmpty()) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.staff.empty")));
            return;
        }
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.staff.list")));
        int n = 1;
        for (IiIIIIiii_Class136.Nested1_739d8c40 nested1_739d8c40 : list) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.staff.list_item", n++, nested1_739d8c40.i_method_a6a62886().isBlank() ? "MODER" : nested1_739d8c40.i_method_a6a62886(), nested1_739d8c40.I_method_13877866())));
        }
    }
}

