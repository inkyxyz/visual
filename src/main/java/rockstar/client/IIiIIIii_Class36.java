package rockstar.client;

import java.util.Map;
import net.minecraft.text.Text;
import rockstar.client.AutoAuthModule;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import ua.mintantileak.spk.Compile;

public class IIiIIIii_Class36 {
    @Compile
    public IIIiiIIi_Class26 I_method_3700eb8b() {
        return IIIiiIiI_Class27.I_method_fa8865f9("auth", iIIiiIiI_Class27 -> iIIiiIiI_Class27.I_method_b3f941e4("autoAuth", "\u043f\u0430\u0440\u043e\u043b\u0438", "passwords").i_method_cfe1a061("commands.auth.description").I_method_16f05c8a(this::I_method_5b1fab6d)).I_method_9111538b();
    }

    @Compile
    private void I_method_5b1fab6d(IIIiiIii_Class28 iIIiiIii_Class28) {
        Map<String, String> map = RockstarClient.getInstance().getModuleManager().getModule(AutoAuthModule.class).i_method_cfdbf9f4();
        int n = 1;
        if (map.isEmpty()) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.auth.empty")));
            return;
        }
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.auth.passwords")));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String string = entry.getKey();
            String string2 = entry.getValue();
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)(n++ + ") " + IiIiIIII_Class81.I_method_f25a980a("commands.auth.nick") + " " + string + " | " + IiIiIIII_Class81.I_method_f25a980a("commands.auth.password") + string2)));
        }
    }
}

