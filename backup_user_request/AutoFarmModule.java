package rockstar.client;

import lombok.Generated;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.ScreenHandler;
import pyrock.events.window.KeyPressEvent;
import rockstar.client.IIIiiIiii_Class56;
import rockstar.client.IIIiiiIII_Class57;
import rockstar.client.IIIiiiIiI_Class59;
import rockstar.client.IIIiiiIii_Class60;
import rockstar.client.IIIiiiiII_Class61;
import rockstar.client.IIIiiiiIi_Class62;
import rockstar.client.IIIiiiiiI_Class63;
import rockstar.client.IIIiiiiii_Class64;
import rockstar.client.IIiIIIIII_Class65;
import rockstar.client.IIiIIIIiI_Class67;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Farm", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.auto_farm")
public class AutoFarmModule
extends Module {
    private final IIiIIIIiI_Class67 I_field_e6afbe8c = new IIiIIIIiI_Class67(this::I_method_652ebf15);
    private ModeSetting I_field_bbe33e6c;
    private IIIiiIiii_Class56 I_field_bdfb2e6c;
    private IIiIIIIII_Class65 I_field_e6af466c;
    private IIIiiiiii_Class64 I_field_bfbe1e8c;
    private IIIiiiiiI_Class63 I_field_bfbe1aac;
    private IIIiiiIiI_Class59 I_field_bfaf8ecc;
    private IIIiiiiIi_Class62 I_field_bfbda66c;
    private IIIiiiiII_Class61 I_field_bfbda28c;
    private IIIiiiIII_Class57 I_field_bfaf16ac;
    private IIIiiiIii_Class60 I_field_bfaf92ac;
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = keyPressEvent -> {
        if (keyPressEvent.getKey() != 256 || keyPressEvent.getAction() != 1) {
            return;
        }
        if (!(AutoFarmModule.I_field_3a9bda27.currentScreen instanceof HandledScreen) || AutoFarmModule.I_field_3a9bda27.player == null) {
            return;
        }
        ScreenHandler screenHandler = AutoFarmModule.I_field_3a9bda27.player.currentScreenHandler;
        if (screenHandler != null && screenHandler != AutoFarmModule.I_field_3a9bda27.player.playerScreenHandler) {
            this.disable();
        }
    };

    public AutoFarmModule() {
        this.IiI_method_7fe7b67f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_7fe7b67f() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_farm.mode");
        this.I_field_bdfb2e6c = new IIIiiIiii_Class56(this, this.I_field_bbe33e6c);
        this.I_field_e6af466c = new IIiIIIIII_Class65(this, this.I_field_bbe33e6c);
        this.I_field_bfbe1e8c = new IIIiiiiii_Class64(this, this.I_field_bbe33e6c);
        this.I_field_bfbe1aac = new IIIiiiiiI_Class63(this, this.I_field_bbe33e6c);
        this.I_field_bfaf8ecc = new IIIiiiIiI_Class59(this, this.I_field_bbe33e6c);
        this.I_field_bfbda66c = new IIIiiiiIi_Class62(this, this.I_field_bbe33e6c);
        this.I_field_bfbda28c = new IIIiiiiII_Class61(this, this.I_field_bbe33e6c);
        this.I_field_bfaf16ac = new IIIiiiIII_Class57(this, this.I_field_bbe33e6c);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.I_field_bfaf92ac = this.i_method_7ac432f5();
        this.I_field_e6afbe8c.I_method_3ea4be3f();
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this.I_field_e6afbe8c);
        if (this.I_field_bfaf92ac != null) {
            RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this.I_field_bfaf92ac);
            this.I_field_bfaf92ac.I_method_a0f53e1f();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.I_field_e6afbe8c.i_method_3eb34a1f();
        RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this.I_field_e6afbe8c);
        if (this.I_field_bfaf92ac != null) {
            this.I_field_bfaf92ac.i_method_a103c9ff();
            RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this.I_field_bfaf92ac);
            this.I_field_bfaf92ac = null;
        }
    }

    @Override
    public void II_method_6642fd22() {
        super.II_method_6642fd22();
        this.I_field_e6afbe8c.II_method_96020102();
        IIIiiiIii_Class60 iIIiiiIii_Class60 = this.i_method_7ac432f5();
        if (iIIiiiIii_Class60 != this.I_field_bfaf92ac) {
            if (this.I_field_bfaf92ac != null) {
                this.I_field_bfaf92ac.i_method_a103c9ff();
                RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this.I_field_bfaf92ac);
            }
            this.I_field_bfaf92ac = iIIiiiIii_Class60;
            if (this.I_field_bfaf92ac != null) {
                RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this.I_field_bfaf92ac);
                this.I_field_bfaf92ac.I_method_a0f53e1f();
            }
        }
        if (this.I_field_bfaf92ac != null) {
            this.I_field_bfaf92ac.Ii_method_7e704cc2();
        }
    }

    private IIIiiiIii_Class60 i_method_7ac432f5() {
        IIIiiiIii_Class60 iIIiiiIii_Class60;
        ModeSetting.Nested1_42765c60 nested1_42765c60 = this.I_field_bbe33e6c.i_method_f85f3850();
        return nested1_42765c60 instanceof IIIiiiIii_Class60 ? (iIIiiiIii_Class60 = (IIIiiiIii_Class60)nested1_42765c60) : null;
    }

    public IIIiiiIii_Class60 I_method_652ebf15() {
        return this.I_field_bfaf92ac;
    }

    @Generated
    public IIiIIIIiI_Class67 I_method_8c2eeaf5() {
        return this.I_field_e6afbe8c;
    }
}

