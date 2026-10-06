package rockstar.client;

import rockstar.client.III;
import rockstar.client.BooleanSetting;
import rockstar.client.IiiIIIiIi_Class198;
import rockstar.client.IiiIIIiiI_Class199;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;

public class IiiIIiIII_Class201
extends IiiIIIiIi_Class198 {
    private final IiiIIIiiI_Class199 I_field_6f4c2a8c;
    private final IiiIIIiiI_Class199 i_field_6f4c2a8c;
    private final BooleanSetting I_field_ba20ca4c;
    private final IiiiIiIii_Class236 I_field_dc7facc;

    public IiiIIiIII_Class201() {
        super("hud.player", "hud/player");
        this.I_field_6f4c2a8c = new IiiIIIiiI_Class199(this.I_field_bbe3ba6c, "FPS", "FPS");
        this.i_field_6f4c2a8c = new IiiIIIiiI_Class199(this.I_field_bbe3ba6c, "speed", "BPS");
        this.I_field_ba20ca4c = new BooleanSetting(this, "hud.player.speedY").I_method_decd82b5();
        this.I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.IIi_field_dd60aac);
        this.showing = false;
        this.pos(2.5f, 22.667f);
    }

    @Override
    public void update(III iII) {
        super.update(iII);
        double d = !this.I_field_ba20ca4c.i_method_9b12da03() ? Math.hypot(IiiIIiIII_Class201.I_field_3a9bda27.player.getX() - IiiIIiIII_Class201.I_field_3a9bda27.player.prevX, IiiIIiIII_Class201.I_field_3a9bda27.player.getZ() - IiiIIiIII_Class201.I_field_3a9bda27.player.prevZ) : Math.hypot(IiiIIiIII_Class201.I_field_3a9bda27.player.getY() - IiiIIiIII_Class201.I_field_3a9bda27.player.prevY, Math.hypot(IiiIIiIII_Class201.I_field_3a9bda27.player.getX() - IiiIIiIII_Class201.I_field_3a9bda27.player.prevX, IiiIIiIII_Class201.I_field_3a9bda27.player.getZ() - IiiIIiIII_Class201.I_field_3a9bda27.player.prevZ));
        this.i_field_6f4c2a8c.I_method_ca27e249(String.format("%.2f", d * 20.0).replace(",", "."));
        this.I_field_6f4c2a8c.I_method_ca27e249("" + Math.round(this.I_field_dc7facc.I_method_edd6dd11(I_field_3a9bda27.getCurrentFps())));
    }
}

