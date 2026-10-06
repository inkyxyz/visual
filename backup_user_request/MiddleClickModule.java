package rockstar.client;

import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import rockstar.client.KeybindSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIIIIii_Class68;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIIiiII_Class77;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Middle Click", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.middle_click")
public class MiddleClickModule
extends Module {
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private KeybindSetting I_field_ba20522c;
    private KeybindSetting i_field_ba20522c;
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = keyPressEvent -> this.I_method_59ba7f3f(keyPressEvent.getKey(), keyPressEvent.getAction());
    private final IiIIIiII_Class69<MouseEvent> i_field_3d936f41 = mouseEvent -> this.I_method_59ba7f3f(mouseEvent.getButton(), mouseEvent.getAction());

    public MiddleClickModule() {
        this.IiI_method_5d4dfb1f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_5d4dfb1f() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.middle_click.actions").I_method_702bd95a(1);
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.middle_click.pearl").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.middle_click.friend");
        this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.middle_click.friend_key", () -> !this.i_field_51de8227.isSelected());
        this.i_field_ba20522c = new KeybindSetting(this, "modules.settings.middle_click.pearl_key", () -> !this.I_field_51de8227.isSelected());
    }

    private void I_method_59ba7f3f(int n, int n2) {
        if (MiddleClickModule.I_field_3a9bda27.currentScreen == null && n2 == 1) {
            if (this.i_field_51de8227.isSelected() && this.I_field_ba20522c.I_method_51ee2d08(n)) {
                if (MiddleClickModule.I_field_3a9bda27.targetedEntity instanceof PlayerEntity) {
                    String string = MiddleClickModule.I_field_3a9bda27.targetedEntity.getName().getString();
                    IiIIiiII_Class77 iiIIiiII_Class77 = RockstarClient.getInstance().I_method_7a5acaeb();
                    if (iiIIiiII_Class77.I_method_19c9437a(string)) {
                        iiIIiiII_Class77.i_method_ea809756(string);
                    } else {
                        iiIIiiII_Class77.I_method_19c94376(string);
                    }
                } else if (MiddleClickModule.I_field_3a9bda27.targetedEntity instanceof SlimeEntity) {
                    iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("middle_click.slime_error")));
                }
            }
            if (this.I_field_51de8227.isSelected() && this.i_field_ba20522c.I_method_51ee2d08(n)) {
                IiIIIIii_Class68.I_field_108dc26c.I_method_ee61a647(Items.ENDER_PEARL);
            }
        }
    }
}

