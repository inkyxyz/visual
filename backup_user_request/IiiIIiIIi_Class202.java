package rockstar.client;

import rockstar.client.III;
import rockstar.client.NameProtectModule;
import rockstar.client.BooleanSetting;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIIIiIi_Class198;
import rockstar.client.IiiIIIiiI_Class199;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIIiiiII_Class285;

public class IiiIIiIIi_Class202
extends IiiIIIiIi_Class198 {
    private final IiiIIIiiI_Class199 I_field_6f4c2a8c;
    private final IiiIIIiiI_Class199 i_field_6f4c2a8c;
    private final IiiIIIiiI_Class199 II_field_6f4c2a8c;
    private final BooleanSetting I_field_ba20ca4c;

    public IiiIIiIIi_Class202() {
        super("hud.world", "hud/world");
        this.I_field_6f4c2a8c = new IiiIIIiiI_Class199(this.I_field_bbe3ba6c, "coords");
        this.i_field_6f4c2a8c = new IiiIIIiiI_Class199(this.I_field_bbe3ba6c, "server");
        this.II_field_6f4c2a8c = new IiiIIIiiI_Class199(this.I_field_bbe3ba6c, "TPS", "TPS");
        this.I_field_ba20ca4c = new BooleanSetting(this, "hud.world.compact_server").I_method_decd82b5();
        this.showing = false;
        this.pos(2.5f, 4.175f);
    }

    @Override
    public void update(III iII) {
        super.update(iII);
        NameProtectModule iIIIiIiII_Class21 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
        if (iIIIiIiII_Class21 != null && iIIIiIiII_Class21.IiI_method_e72bc283()) {
            this.I_field_6f4c2a8c.I_method_c10e6bd3("\u2014 \u2014 \u2014", "\u2014 \u2014 \u2014");
            this.i_field_6f4c2a8c.I_method_c10e6bd3("\u2014", "\u2014");
            return;
        }
        String string = String.format("%s %s %s", Math.round(IiiIIiIIi_Class202.I_field_3a9bda27.player.getX()), Math.round(IiiIIiIIi_Class202.I_field_3a9bda27.player.getY()), Math.round(IiiIIiIIi_Class202.I_field_3a9bda27.player.getZ()));
        this.I_field_6f4c2a8c.I_method_c10e6bd3(string, string);
        this.i_field_6f4c2a8c.I_method_c10e6bd3(iIIIiiiII_Class285.I_method_da38608b(this.I_field_ba20ca4c.i_method_9b12da03()), iIIIiiiII_Class285.I_method_2b105481());
        this.II_field_6f4c2a8c.I_method_ca27e249(iIIIIiIiI_Class267.i_method_f3c598a1(RockstarClient.getInstance().I_method_d1ad67e2().I_method_2bde91cf()).replace(",", ".").replace(".0", ""));
    }
}

