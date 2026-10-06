package rockstar.client;

import java.util.List;
import net.minecraft.text.Text;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiiii_Class32;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleEntry;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import ua.mintantileak.spk.Compile;

public class IIiiiIiI_Class59 {
    @Compile
    public IIIiiIIi_Class26 I_method_18f85f6b() {
        List<String> list = RockstarClient.getInstance().getModuleManager().getModules().stream().map(iiIiiIii_Class92 -> iiIiiIii_Class92.getName().replace(" ", "")).toList();
        return IIIiiIiI_Class27.I_method_209cd841("toggle").I_method_b3f941e4("t").i_method_cfe1a061("commands.toggle.description").i_method_3d6e11d9("module", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_2619a44a(IIIiiiii_Class32.I_field_de26afa1).I_method_b539159d(list)).I_method_16f05c8a(iIIiiIii_Class28 -> {
            ModuleEntry iiIiiIii_Class92 = (ModuleEntry)iIIiiIii_Class28.I_method_557e5bfb().getFirst();
            iiIiiIii_Class92.toggle();
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.toggle." + (iiIiiIii_Class92.isEnabled() ? "enabled" : "disabled"), iiIiiIii_Class92.getName())));
        }).I_method_9111538b();
    }
}

