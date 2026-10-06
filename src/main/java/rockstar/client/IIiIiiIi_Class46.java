package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import net.minecraft.text.Text;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIIiiiIi_Class30;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import ua.mintantileak.spk.Compile;

public class IIiIiiIi_Class46 {
    public IIIiiIIi_Class26 I_method_8fe8f3ab() {
        return IIIiiIiI_Class27.I_method_fa8865f9("help", iIIiiIiI_Class27 -> iIIiiIiI_Class27.I_method_b3f941e4("\u043f\u043e\u043c\u043e\u0449\u044c", "\u043a\u043e\u043c\u0430\u043d\u0434\u044b", "commands", "helpme").i_method_cfe1a061("commands.help.description").I_method_16f05c8a(this::I_method_1f38a74d)).I_method_9111538b();
    }

    @Compile
    private void I_method_1f38a74d(IIIiiIii_Class28 iIIiiIii_Class28) {
        ArrayList<IIIiiIIi_Class26> arrayList = new ArrayList<IIIiiIIi_Class26>(RockstarClient.getInstance().I_method_b4d046cb().I_method_cafa303b());
        IIIiiiIi_Class30 iIIiiiIi_Class30 = RockstarClient.getInstance().I_method_b4d046cb();
        arrayList.sort(Comparator.comparing(iIIiiIRockstarClient6 -> iIIiiIRockstarClient6.I_method_84c7081b().getFirst(), String.CASE_INSENSITIVE_ORDER));
        ArrayList<String> arrayList2 = new ArrayList<String>();
        int n = 1;
        for (IIIiiIIi_Class26 iIIiiIRockstarClient62 : arrayList) {
            if (!iIIiiiIi_Class30.i_method_45f7c6d1(iIIiiIRockstarClient62)) continue;
            arrayList2.add(String.format("%d) %s%s - %s", n++, iIIiiiIi_Class30.I_method_80ea594(), iIIiiIRockstarClient62.I_method_84c7081b().getFirst(), IiIiIIII_Class81.I_method_f25a980a(iIIiiIRockstarClient62.I_method_82050574())));
        }
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.help.list", String.join((CharSequence)"\n", arrayList2))));
    }
}

