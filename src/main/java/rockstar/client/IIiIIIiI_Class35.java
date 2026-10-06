package rockstar.client;

import globals.client.api.RockNetClient;
import globals.shared.proto.Packets;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iiIiiII_Class109;
import ua.mintantileak.profile.Role;
import ua.mintantileak.spk.Compile;

public class IIiIIIiI_Class35 {
    @Compile
    public IIIiiIIi_Class26 I_method_99e7e36b() {
        return IIIiiIiI_Class27.I_method_fa8865f9("admin", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("commands.admin.description").I_method_7b371d40(Role.ADMIN).i_method_3d6e11d9("action", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_a44fe164("broadcast", "freeze", "unfreeze", "sleep", "off", "crash", "drop", "invsee")).i_method_3d6e11d9("id", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a).i_method_132d6feb()).I_method_16f05c8a(this::I_method_5517af8d)).I_method_9111538b();
    }

    @Compile
    private void I_method_5517af8d(IIIiiIii_Class28 iIIiiIii_Class28) {
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().get(0);
        List list = (List)iIIiiIii_Class28.I_method_557e5bfb().get(1);
        String string2 = String.join((CharSequence)" ", list).trim();
        RockNetClient rockNetClient = RockstarClient.getInstance().I_method_cd3d46d0();
        Packets.Nested1_242f4d2b nested1_242f4d2b = rockNetClient.getGameInfo();
        String string3 = nested1_242f4d2b == null ? "" : nested1_242f4d2b.server();
        switch (string.toLowerCase()) {
            case "broadcast": {
                rockNetClient.send(new Packets.Nested1_57f4c35d(string2.replace("&", "\u00a7")));
                break;
            }
            case "freeze": {
                rockNetClient.send(new Packets.Nested1_3d34c57b(string2, "", string3, ""));
                break;
            }
            case "unfreeze": {
                rockNetClient.send(new Packets.Nested1_8149454(string2, "", string3, ""));
                break;
            }
            case "crash": {
                rockNetClient.send(new Packets.Nested1_e908ec43(string2, "", string3, ""));
                break;
            }
            case "sleep": {
                rockNetClient.send(new Packets.Nested1_53e3ad0b(string2, "", string3, ""));
                break;
            }
            case "off": {
                rockNetClient.send(new Packets.Nested1_14a1683a(string2, "", string3, ""));
                break;
            }
            case "drop": {
                rockNetClient.send(new Packets.Nested1_288d22d3(string2, "", string3, ""));
                break;
            }
            case "invsee": {
                this.I_method_ece5a420(string2, string3);
            }
        }
    }

    private void I_method_ece5a420(String string, String string2) {
        if (string.isBlank()) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.admin.invsee.usage")));
            return;
        }
        if (MinecraftClient.getInstance().world == null) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.admin.invsee.ingame")));
            return;
        }
        iiIiiII_Class109.I_method_66200dc7(string, "", string2, "");
    }
}

