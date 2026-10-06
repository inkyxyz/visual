package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.gui.screen.Screen;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import rockstar.client.ButtonSetting;
import rockstar.client.IiIIIIii_Class68;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIIII_Class257;
import rockstar.client.iIIiIiiI_Class151;
import rockstar.client.iIiIIiII_Class165;
import rockstar.client.iIiIIiiI_Class167;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Macro Menu", category=ModuleCategory.OTHER)
public class MacroMenuModule
extends Module {
    private ButtonSetting I_field_bbd4b28c;
    private final List<iIiIIiII_Class165> I_field_7865b31 = iIiIIiiI_Class167.I_method_57a2a7bb();
    private final List<iIiIIiII_Class165> i_field_7865b31 = new ArrayList<iIiIIiII_Class165>(this.I_field_7865b31);
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = keyPressEvent -> {
        if (keyPressEvent.getAction() != 1) {
            return;
        }
        if (MacroMenuModule.I_field_3a9bda27.currentScreen != null) {
            return;
        }
        this.II_method_e0dfa621(keyPressEvent.getKey());
    };
    private final IiIIIiII_Class69<MouseEvent> i_field_3d936f41 = mouseEvent -> {
        if (mouseEvent.getAction() != 1) {
            return;
        }
        if (MacroMenuModule.I_field_3a9bda27.currentScreen != null) {
            return;
        }
        this.II_method_e0dfa621(mouseEvent.getButton());
    };

    public MacroMenuModule() {
        this.IiI_method_e2b11a9f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_e2b11a9f() {
        this.I_field_bbd4b28c = new ButtonSetting(this, "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u043c\u0435\u043d\u044e").I_method_f05556b3(() -> I_field_3a9bda27.setScreen((Screen)new iIIiIiiI_Class151()));
    }

    private void II_method_e0dfa621(int n) {
        for (iIiIIiII_Class165 iIiIIiII_Class1652 : this.i_field_7865b31) {
            if (!iIiIIiII_Class1652.I_method_75fee910() || !iIIIIIIII_Class257.I_method_967132c3(iIiIIiII_Class1652.I_method_75fee8ff(), n)) continue;
            IiIIIIii_Class68.I_field_108dc26c.I_method_a4f79a60(iIiIIiII_Class1652.I_method_db7f702c().getItem(), iIiIIiII_Class1652::I_method_b921bd52, iIiIIiII_Class1652.i_method_1f641154());
            return;
        }
    }

    public final void i_method_f42084f0(List<iIiIIiII_Class165> list) {
        this.i_field_7865b31.clear();
        this.i_field_7865b31.addAll(list);
    }

    @Generated
    public List<iIiIIiII_Class165> I_method_19f92648() {
        return this.I_field_7865b31;
    }

    @Generated
    public List<iIiIIiII_Class165> i_method_cf455e68() {
        return this.i_field_7865b31;
    }
}

