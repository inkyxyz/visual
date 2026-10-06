package rockstar.client;

import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.text.Text;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.BooleanSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIIiIIII_Class145;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Death Cords", category=ModuleCategory.UTILS, III_method_a89e5834="modules.descriptions.death_cords")
public class DeathCordsModule
extends Module {
    private boolean I_field_5a;
    private BooleanSetting I_field_ba20ca4c;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (DeathCordsModule.I_field_3a9bda27.currentScreen instanceof DeathScreen && DeathCordsModule.I_field_3a9bda27.player != null) {
            if (this.I_field_5a) {
                int n = (int)DeathCordsModule.I_field_3a9bda27.player.getX();
                int n2 = (int)DeathCordsModule.I_field_3a9bda27.player.getY();
                int n3 = (int)DeathCordsModule.I_field_3a9bda27.player.getZ();
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("death_cords.coords", n + " " + n2 + " " + n3)));
                if (this.I_field_ba20ca4c.i_method_9b12da03()) {
                    IiIIiIIII_Class145 iiIIiIIII_Class145 = RockstarClient.getInstance().I_method_cf3ba442();
                    if (iiIIiIIII_Class145.I_method_d7f564d("Death")) {
                        iiIIiIIII_Class145.I_method_d7f5649("Death");
                    }
                    iiIIiIIII_Class145.I_method_b71837ba("Death", n, n2, n3);
                }
                this.I_field_5a = false;
            }
        } else {
            this.I_field_5a = true;
        }
    };

    public DeathCordsModule() {
        this.IiI_method_8ced2aff();
    }

    @Compile(obfuscation=4)
    private void IiI_method_8ced2aff() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.death_cords.waypoint");
    }
}

