package rockstar.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import pyrock.events.network.ReceivePacketEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.TextSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Auth", category=ModuleCategory.OTHER, III_method_a89e5834="modules.descriptions.auto_auth")
public class AutoAuthModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private TextSetting I_field_731802cc;
    private final Map<String, String> I_field_a567c40b = new HashMap<String, String>();
    private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = receivePacketEvent -> {
        Object object = receivePacketEvent.getPacket();
        if (object instanceof GameMessageS2CPacket) {
            GameMessageS2CPacket gameMessageS2CPacket = (GameMessageS2CPacket)object;
            if (AutoAuthModule.I_field_3a9bda27.player != null) {
                object = gameMessageS2CPacket.content().getString().toLowerCase();
                String string = iIIIIiIiI_Class267.I_method_fb167821();
                String string2 = this.I_field_ba20ca4c.i_method_9b12da03() ? string : this.I_field_731802cc.II_method_da016c1e();
                this.I_field_a567c40b.put(AutoAuthModule.I_field_3a9bda27.player.getDisplayName().getString(), " " + string);
                if (((String)object).contains("\u0437\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0443\u0439\u0442\u0435\u0441\u044c") || ((String)object).contains("/reg")) {
                    AutoAuthModule.I_field_3a9bda27.player.networkHandler.sendChatCommand(String.format("reg %s %s", string2, string2));
                } else if (((String)object).contains("\u0430\u0432\u0442\u043e\u0440\u0438\u0437\u0443\u0439\u0442\u0435\u0441\u044c") || ((String)object).contains("/login") || ((String)object).contains("/l") && ((String)object).matches("/l(\\s|$)")) {
                    AutoAuthModule.I_field_3a9bda27.player.networkHandler.sendChatCommand(String.format("l %s", string2));
                }
            }
        }
    };

    public AutoAuthModule() {
        this.IiI_method_f0f7169f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_f0f7169f() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auto_auth.random");
        this.I_field_731802cc = new TextSetting((IIiiiIIiI_Class115)this, "modules.settings.auto_auth.password", this.I_field_ba20ca4c::i_method_9b12da03).I_method_104de33f("123123");
    }

    public Map<String, String> i_method_cfdbf9f4() {
        return Collections.unmodifiableMap(this.I_field_a567c40b);
    }

    public void I_method_ee5917b3(String string, String string2) {
        this.I_field_a567c40b.put(string, string2);
    }
}

