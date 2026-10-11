package rockstar.client;

import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import rockstar.client.SoundsModule;
import rockstar.client.KeybindSetting;
import rockstar.client.ModeSetting;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiIIiiiI_Class207;
import rockstar.client.IiiIiIIII_Class209;
import rockstar.client.IiiIiIiiI_Class215;
import rockstar.client.IiiIiIiii_Class216;
import rockstar.client.iIIIIIIII_Class257;
import rockstar.client.Module;
import rockstar.client.iiIiIIIII_Class417;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Menu", category=ModuleCategory.INTERFACE, defaultKey=344, III_method_a89e5834="modules.descriptions.menu")
public class MenuModule
extends Module {
    private static final IiiIiIIII_Class209 I_field_a5d83a6c = new IiiIiIIII_Class209();
    private KeybindSetting I_field_ba20522c;
    private SliderSetting guiScale;
    private SliderSetting toastDuration;
    private BooleanSetting hitSoundsSetting;
    private BooleanSetting uiSoundsSetting;
    private Screen I_field_bf52cf84;
    private static boolean I_field_5a;

    public MenuModule() {
        this.Iii_method_c57aca5f();
    }

    @Compile(obfuscation=4)
    private void Iii_method_c57aca5f() {
        this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.menu.hide_key").I_method_4288e15a(342);
        this.guiScale = new SliderSetting(this, "GUI Scale")
            .I_method_c8c9a7d7(0.7F)
            .i_method_65e2aff7(1.4F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(1.0F);

        this.toastDuration = new SliderSetting(this, "Время подсказок")
            .I_method_c8c9a7d7(1.0F)
            .i_method_65e2aff7(10.0F)
            .II_method_b0f56334(0.5F)
            .Ii_method_4e0e6b54(4.0F);

        this.hitSoundsSetting = new BooleanSetting(this, "Hit Sounds") {
            @Override
            public void I_method_4e1408b5(boolean bl) {
                super.I_method_4e1408b5(bl);
                if (RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null) {
                    HitSoundsModule hs = RockstarClient.getInstance().getModuleManager().getModule(HitSoundsModule.class);
                    if (hs != null) hs.setEnabled(bl, false);
                }
            }
        }.I_method_a4d009eb(true);

        this.uiSoundsSetting = new BooleanSetting(this, "UI Sounds") {
            @Override
            public void I_method_4e1408b5(boolean bl) {
                super.I_method_4e1408b5(bl);
                if (RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null) {
                    UISoundsModule us = RockstarClient.getInstance().getModuleManager().getModule(UISoundsModule.class);
                    if (us != null) us.setEnabled(bl, false);
                }
            }
        }.I_method_a4d009eb(true);
    }

    @Override
    public void onEnable() {
        if (MenuModule.I_field_3a9bda27.currentScreen instanceof IiiIiIiiI_Class215) {
            return;
        }
        this.I_field_bf52cf84 = this.I_method_83034dbb();
        I_field_5a = true;
        I_field_3a9bda27.setScreen(this.I_field_bf52cf84);
        SoundsModule iIIIiIiii_Class24 = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
        if (iIIIiIiii_Class24.isEnabled()) {
            iiIiIIIII_Class417.I_field_34b2ba6c.I_method_87d2e181(iIIIiIiii_Class24.I_method_45ee5ef());
        }
        super.onEnable();
    }

    public Screen I_method_83034dbb() {
        IiiIIiiiI_Class207 iiiIIiiiI_Class207 = RockstarClient.getInstance().I_method_96982062();
        IiiIIiiiI_Class207 iiiIIiiiI_Class2072 = iiiIIiiiI_Class207 instanceof IiiIiIiiI_Class215 ? iiiIIiiiI_Class207 : new IiiIiIiiI_Class215();
        RockstarClient.getInstance().I_method_577f3d5a(iiiIIiiiI_Class2072);
        return iiiIIiiiI_Class2072;
    }

    public static boolean I_method_48514ce8(int n) {
        return !I_field_5a && MenuModule.i_method_4a143d08(n);
    }

    public static void II_method_c39aca01(int n) {
        MenuModule iIiIIiiIi_Class78 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
        if (iIiIIiiIi_Class78 != null && iIIIIIIII_Class257.I_method_4da58b7(iIiIIiiIi_Class78.getKeybind()) == n) {
            I_field_5a = false;
        }
    }

    private static boolean i_method_4a143d08(int n) {
        MenuModule iIiIIiiIi_Class78 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
        return iIiIIiiIi_Class78 != null && iIIIIIIII_Class257.I_method_967132c3(iIiIIiiIi_Class78.getKeybind(), n);
    }

    public static void IiI_method_c56c3e7f() {
        MenuModule iIiIIiiIi_Class78 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
        MinecraftClient.getInstance().setScreen(iIiIIiiIi_Class78.I_method_83034dbb());
    }

    @Override
    public void onDisable() {
        I_field_5a = false;
        if (MenuModule.I_field_3a9bda27.currentScreen == this.I_field_bf52cf84) {
            I_field_3a9bda27.setScreen(null);
        }
        super.onDisable();
    }

    @Generated
    public ModeSetting.Nested1_42765c60 I_method_4bdd4450() {
        return null;
    }

    @Generated
    public KeybindSetting I_method_20c0695() {
        return this.I_field_ba20522c;
    }
    public float getGuiScale() {
        return this.guiScale != null ? this.guiScale.Ii_method_a20abcd2() : 1.0F;
    }

    public float getToastDuration() {
        return this.toastDuration != null ? this.toastDuration.Ii_method_a20abcd2() : 4.0F;
    }

    public SliderSetting getGuiScaleSetting() {
        return this.guiScale;
    }
}