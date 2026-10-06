package rockstar.client;

import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIIiiiii_Class32;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.MenuModule;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleEntry;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIiIIii_Class212;
import rockstar.client.iIIIIIIIi_Class258;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIIIiIiI_Class267;
import ua.mintantileak.spk.Compile;

public class IIiIIiiI_Class39 {
    public IIIiiIIi_Class26 I_method_54df638b() {
        List<String> list = RockstarClient.getInstance().getModuleManager().getModules().stream().map(iiIiiIii_Class92 -> iiIiiIii_Class92.getName().replace(" ", "")).toList();
        List<String> list2 = iIIIIIIIi_Class258.I_method_ed34c268();
        return IIIiiIiI_Class27.I_method_fa8865f9("bind", iIIiiIiI_Class27 -> iIIiiIiI_Class27.I_method_b3f941e4("binds", "\u0431\u0438\u043d\u0434").i_method_cfe1a061("commands.bind.description")).i_method_3d6e11d9("action", iIIiiiii_Class32 -> {
            iIIiiiii_Class32.I_method_a44fe164("add", "create", "remove", "delete", "list", "clear");
            iIIiiiii_Class32.I_method_f005ecf3("add", "remove", "list", "clear");
        }).i_method_3d6e11d9("module", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIIiiiii_Class32.I_field_de26afa1).I_method_b539159d(list)).i_method_3d6e11d9("key", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(string -> string.isBlank() ? IIiIIIIi_Class34.I_method_c9d442bc("key is empty") : IIiIIIIi_Class34.I_method_12fc454a(string)).I_method_b539159d(list2)).I_method_16f05c8a(this::I_method_f910336d).I_method_9111538b();
    }

    @Compile
    private void I_method_f910336d(IIIiiIii_Class28 iIIiiIii_Class28) {
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().getFirst();
        ModuleEntry iiIiiIii_Class92 = (ModuleEntry)iIIiiIii_Class28.I_method_557e5bfb().get(1);
        String string2 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(2);
        if (string.equalsIgnoreCase("clear")) {
            for (ModuleEntry iiIiiIii_Class922 : RockstarClient.getInstance().getModuleManager().getModules()) {
                if (iiIiiIii_Class922 instanceof MenuModule || iiIiiIii_Class922.getKeybind() == -1) continue;
                iiIiiIii_Class922.setKeybind(-1);
            }
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.bind.clear")));
        }
        if (string.equalsIgnoreCase("list")) {
            this.I_method_6b28a0ec();
            return;
        }
        if (string.equalsIgnoreCase("add") || string.equalsIgnoreCase("create")) {
            if (string2 == null) {
                iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.bind.create.key_not")));
                return;
            }
            int n = iIIIIIIIi_Class258.I_method_dc7f39fc(string2);
            if (n == -1) {
                iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)(IiIiIIII_Class81.I_method_f25a980a("commands.bind.create.key_unknow") + string2)));
                return;
            }
            iiIiiIii_Class92.setKeybind(n);
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)(IiIiIIII_Class81.I_method_f25a980a("commands.bind.create.download") + " " + iIIIIiIiI_Class267.I_method_a937749c(n))));
        } else if (string.equalsIgnoreCase("remove") || string.equalsIgnoreCase("delete")) {
            if (iiIiiIii_Class92 == null) {
                iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.bind.module_required")));
                return;
            }
            iiIiiIii_Class92.setKeybind(-1);
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)(IiIiIIII_Class81.I_method_f25a980a("commands.bind.delete") + " " + iiIiiIii_Class92.getName())));
        }
    }

    private void I_method_6b28a0ec() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        minecraftClient.send(() -> minecraftClient.setScreen((Screen)new IiiIiIIii_Class212()));
    }
}

