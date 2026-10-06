package rockstar.client;

import java.util.List;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import rockstar.client.BaseFinderModule;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import ua.mintantileak.spk.Compile;

public class IIiIIiIi_Class38 {
    public IIIiiIIi_Class26 I_method_ebf06fcb() {
        return IIIiiIiI_Class27.I_method_fa8865f9("base", iIIiiIiI_Class27 -> iIIiiIiI_Class27.i_method_cfe1a061("Base Finder list").i_method_3d6e11d9("action", iIIiiiii_Class32 -> {
            iIIiiiii_Class32.I_method_a44fe164("list", "clear", "remove", "delete", "del");
            iIIiiiii_Class32.I_method_f005ecf3("list", "clear", "remove");
        }).i_method_3d6e11d9("target", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().i_method_132d6feb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a)).I_method_16f05c8a(this::I_method_4420af2d)).I_method_9111538b();
    }

    @Compile
    private void I_method_4420af2d(IIIiiIii_Class28 iIIiiIii_Class28) {
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().get(0);
        BaseFinderModule iIIIIiIIi_Class10 = RockstarClient.getInstance().getModuleManager().getModule(BaseFinderModule.class);
        switch (string.toLowerCase()) {
            case "list": {
                this.I_method_1fc0461a(iIIIIiIIi_Class10);
                break;
            }
            case "clear": {
                this.i_method_bcd94e3a(iIIIIiIIi_Class10);
                break;
            }
            case "remove": 
            case "delete": 
            case "del": {
                this.I_method_eea35f0b(iIIIIiIIi_Class10, this.I_method_95b5437a(iIIiiIii_Class28));
            }
        }
    }

    private void I_method_1fc0461a(BaseFinderModule iIIIIiIIi_Class10) {
        List<BaseFinderModule.Nested1_1f390040> list = iIIIIiIIi_Class10.I_method_436a0e28();
        if (list.isEmpty()) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)"\u0411\u0430\u0437\u044b \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u044b."));
            return;
        }
        for (int i = 0; i < list.size(); ++i) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)BaseFinderModule.I_method_f5302abe(list.get(i))));
        }
    }

    private void i_method_bcd94e3a(BaseFinderModule iIIIIiIIi_Class10) {
        int n = iIIIIiIIi_Class10.II_method_ef7120f5();
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)("\u041e\u0447\u0438\u0449\u0435\u043d\u043e \u0431\u0430\u0437: " + n)));
    }

    private void I_method_eea35f0b(BaseFinderModule iIIIIiIIi_Class10, List<String> list) {
        BaseFinderModule.Nested1_1f390040 nested1_1f390040;
        if (list.isEmpty()) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)"\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: .base remove <\u0411\u0430\u0437\u0430-1|1|x y z>"));
            return;
        }
        BaseFinderModule.Nested1_1f390040 nested1_1f3900402 = nested1_1f390040 = this.I_method_d7f401a1(list) ? iIIIIiIIi_Class10.I_method_c93ef96a(new BlockPos(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)))) : iIIIIiIIi_Class10.I_method_5a6c99ba(String.join((CharSequence)" ", list));
        if (nested1_1f390040 == null) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)"\u0411\u0430\u0437\u0430 \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u0430."));
            return;
        }
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)("\u0423\u0434\u0430\u043b\u0435\u043d\u0430 " + BaseFinderModule.I_method_f5302abe(nested1_1f390040))));
    }

    private boolean I_method_d7f401a1(List<String> list) {
        if (list.size() != 3) {
            return false;
        }
        for (String string : list) {
            if (this.I_method_8440237a(string)) continue;
            return false;
        }
        return true;
    }

    private boolean I_method_8440237a(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private List<String> I_method_95b5437a(IIIiiIii_Class28 iIIiiIii_Class28) {
        if (iIIiiIii_Class28.I_method_557e5bfb().size() <= 1 || iIIiiIii_Class28.I_method_557e5bfb().get(1) == null) {
            return List.of();
        }
        return ((List)iIIiiIii_Class28.I_method_557e5bfb().get(1)).stream().map(String::valueOf).toList();
    }
}

