package rockstar.client;

import globals.client.ui.RocknetMenu;
import lombok.Generated;
import net.minecraft.client.gui.screen.Screen;
import rockstar.client.SoundsModule;
import rockstar.client.KeybindSetting;
import rockstar.client.ModeSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import rockstar.client.iiIiIIIII_Class417;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Globals Menu", category=ModuleCategory.INTERFACE, defaultKey=345)
public class GlobalsMenuModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private ModeSetting i_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 iI_field_500d0627;
    private ModeSetting.Nested1_42765c60 ii_field_500d0627;
    private KeybindSetting I_field_ba20522c;

    public GlobalsMenuModule() {
        this.IiI_method_89b30a9f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_89b30a9f() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.globals.visibility");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.globals.visibility.all").select();
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.globals.visibility.friends");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.globals.visibility.none");
        this.i_field_bbe33e6c = new ModeSetting(this, "modules.settings.globals.notifications");
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.globals.notifications.all").select();
        this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.globals.notifications.friends");
        this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.globals.notifications.none");
        this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.globals.snowball_bind").I_method_4288e15a(71);
    }

    @Override
    public void onEnable() {
        if (GlobalsMenuModule.I_field_3a9bda27.currentScreen instanceof RocknetMenu) {
            return;
        }
        RocknetMenu rocknetMenu = RockstarClient.getInstance().I_method_449a4cbc();
        if (rocknetMenu == null) {
            return;
        }
        I_field_3a9bda27.setScreen((Screen)rocknetMenu);
        SoundsModule iIIIiIiii_Class24 = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
        if (iIIIiIiii_Class24.isEnabled()) {
            iiIiIIIII_Class417.I_field_34b2ba6c.I_method_87d2e181(iIIIiIiii_Class24.I_method_45ee5ef());
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        if (GlobalsMenuModule.I_field_3a9bda27.currentScreen instanceof RocknetMenu) {
            I_field_3a9bda27.setScreen(null);
            RockstarClient.getInstance().I_method_449a4cbc().setClosing(true);
        }
        super.onDisable();
    }

    public void I_method_3bc3ba29(String string) {
        RockstarClient.getInstance().I_method_cd3d46d0().updateVisibility(string);
    }

    public boolean IiI_method_89b30aa3() {
        return !this.i_field_bbe33e6c.I_method_ce989e26(this.ii_field_500d0627);
    }

    public boolean I_method_77f0bc99(boolean bl) {
        if (this.i_field_bbe33e6c.I_method_ce989e26(this.ii_field_500d0627)) {
            return false;
        }
        if (this.i_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)) {
            return true;
        }
        return this.i_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627) && bl;
    }

    @Generated
    public ModeSetting I_method_d97b5ef5() {
        return this.I_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 I_method_681f2870() {
        return this.I_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 i_method_6e272450() {
        return this.i_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 II_method_cf361cf3() {
        return this.II_field_500d0627;
    }

    @Generated
    public ModeSetting i_method_ef10d2d5() {
        return this.i_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 Ii_method_d53e18d3() {
        return this.Ii_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 iI_method_8a2d9d13() {
        return this.iI_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 ii_method_903598f3() {
        return this.ii_field_500d0627;
    }

    @Generated
    public KeybindSetting I_method_d7b872b5() {
        return this.I_field_ba20522c;
    }
}

