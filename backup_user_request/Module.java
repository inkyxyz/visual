package rockstar.client;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import pyrock.classes.PyModule;
import pyrock.events.client.ModuleToggledEvent;
import rockstar.client.GlobalsMenuModule;
import rockstar.client.SoundsModule;
import rockstar.client.MenuModule;
import rockstar.client.Setting;
import rockstar.client.IiIIiiii_Class80;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleEntry;
import rockstar.client.IiIiiiII_Class93;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iiIiIIIII_Class417;
import rockstar.client.iiiIIII_Class113;
import ua.mintantileak.profile.Profile;
import ua.mintantileak.profile.Role;

public abstract class Module
implements ModuleEntry {
    private int I_field_49;
    private ModuleCategory I_field_75f1ef41;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private String I_field_523beb0a;
    private boolean Ii_field_5a;
    private boolean iI_field_5a;
    private List<Setting> I_field_7865b31 = new ArrayList<Setting>();
    private int i_field_49;
    private final Map<String, JsonElement> I_field_a567c40b = new HashMap<String, JsonElement>();
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);

    public Module() {
        ModuleInfo iiiIIIII_Class97 = this.getClass().getAnnotation(ModuleInfo.class);
        this.Ii_field_5a = iiiIIIII_Class97.iI_method_476ab839();
        this.iI_field_5a = iiiIIIII_Class97.ii_method_47794419();
        this.I_field_523beb0a = iiiIIIII_Class97.name();
        this.I_field_75f1ef41 = iiiIIIII_Class97.category();
        this.i_field_49 = this.I_field_49 = iiiIIIII_Class97.defaultKey();
        this.II_field_5a = iiiIIIII_Class97.staffOnly();
    }

    public Module(String string, ModuleCategory iiIiiiii_Class96, int n) {
        this.I_field_523beb0a = string;
        this.I_field_75f1ef41 = iiIiiiii_Class96;
        this.I_field_49 = n;
        this.i_field_49 = n;
    }

    @Override
    public final void toggle() {
        this.setEnabled(!this.I_field_5a, false);
    }

    @Override
    public boolean isAvailable() {
        return !this.II_field_5a || Module.iI_method_af0a6819();
    }

    public static boolean iI_method_af0a6819() {
        Role role = Profile.getRole();
        return role == Role.ADMIN || role == Role.OWNER;
    }

    public static boolean ii_method_af18f3f9() {
        return !Profile.getUsername().isEmpty();
    }

    @Override
    public final void setKeybind(int n) {
        if (this.I_field_49 == n) {
            return;
        }
        this.I_field_49 = n;
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new IiIiiiII_Class93(this));
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void II_method_6642fd22() {
    }

    @Override
    public final void disable() {
        this.setEnabled(false, false);
    }

    @Override
    public final void enable() {
        this.setEnabled(true, false);
    }

    @Override
    public final void setEnabled(boolean bl, boolean bl2) {
        if (!bl && this.iI_field_5a) {
            return;
        }
        if (this.I_field_5a == bl) {
            return;
        }
        if (bl && !this.isAvailable() && Module.ii_method_af18f3f9()) {
            return;
        }
        this.I_field_5a = bl;
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ModuleToggledEvent(new PyModule(this), this.I_field_5a));
        if (!(this instanceof MenuModule) && !(this instanceof GlobalsMenuModule) && RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class).isEnabled() && !bl2) {
            iiIiIIIII_Class417.i_field_34b2ba6c.I_method_7289b65f(RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class).I_method_45ee5ef(), this.I_field_5a ? 1.1f : 1.0f);
        }
        if (this.I_field_5a) {
            RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
            if (!(bl2 || this instanceof MenuModule || this instanceof GlobalsMenuModule)) {
                RockstarClient.getInstance().I_method_5cb1af22().I_method_8ee48d11(iiiIIII_Class113.I_field_c11fcfcc, this.I_field_523beb0a.replace(" ", "") + " " + IiIiIIII_Class81.I_method_f25a980a("enabled") + (IiIiIIII_Class81.I_method_21a4cfeb() == IiIIiiii_Class80.i_field_3f56db61 ? iIIIIiIiI_Class267.I_method_c7255d57(this.I_field_523beb0a) : ""));
            }
            this.onEnable();
        } else {
            RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this);
            if (!(bl2 || this instanceof MenuModule || this instanceof GlobalsMenuModule)) {
                RockstarClient.getInstance().I_method_5cb1af22().I_method_8ee48d11(iiiIIII_Class113.i_field_c11fcfcc, this.I_field_523beb0a.replace(" ", "") + " " + IiIiIIII_Class81.I_method_f25a980a("disabled") + (IiIiIIII_Class81.I_method_21a4cfeb() == IiIIiiii_Class80.i_field_3f56db61 ? iIIIIiIiI_Class267.I_method_c7255d57(this.I_field_523beb0a) : ""));
            }
            this.onDisable();
        }
    }

    public String I_method_b5cfb3aa(String string) {
        return "modules.settings." + this.getName().toLowerCase().replace(" ", "_") + "." + string;
    }

    public final void III_method_fbb67e0c() {
        this.i_field_49 = this.I_field_49;
        this.I_field_a567c40b.clear();
        for (Setting iIiiiIIII_Class113 : this.I_field_7865b31) {
            this.I_field_a567c40b.put(iIiiiIIII_Class113.getName(), iIiiiIIII_Class113.toJson());
        }
    }

    public final void IIi_method_fbc509ec() {
        this.setKeybind(this.i_field_49);
        for (Setting iIiiiIIII_Class113 : this.I_field_7865b31) {
            JsonElement jsonElement = this.I_field_a567c40b.get(iIiiiIIII_Class113.getName());
            if (jsonElement == null) continue;
            iIiiiIIII_Class113.fromJson(jsonElement);
        }
    }

    @Override
    @Generated
    public int getKeybind() {
        return this.I_field_49;
    }

    @Override
    @Generated
    public ModuleCategory getCategory() {
        return this.I_field_75f1ef41;
    }

    @Override
    @Generated
    public boolean isEnabled() {
        return this.I_field_5a;
    }

    @Override
    @Generated
    public boolean II_method_e249c39() {
        return this.i_field_5a;
    }

    @Generated
    public boolean III_method_fbb67e10() {
        return this.II_field_5a;
    }

    @Override
    @Generated
    public String getName() {
        return this.I_field_523beb0a;
    }

    @Override
    @Generated
    public boolean isEnabledByDefault() {
        return this.Ii_field_5a;
    }

    @Generated
    public boolean IIi_method_fbc509f0() {
        return this.iI_field_5a;
    }

    @Override
    @Generated
    public List<Setting> getSettings() {
        return this.I_field_7865b31;
    }

    @Generated
    public int i_method_5839a8bf() {
        return this.i_field_49;
    }

    @Generated
    public Map<String, JsonElement> I_method_7c822221() {
        return this.I_field_a567c40b;
    }

    @Override
    @Generated
    public IiiiIiIii_Class236 I_method_11500ba2() {
        return this.I_field_dc7facc;
    }

    @Generated
    public void I_method_cb78e72d(ModuleCategory iiIiiiii_Class96) {
        this.I_field_75f1ef41 = iiIiiiii_Class96;
    }

    @Generated
    public void I_method_ad393368(boolean bl) {
        this.I_field_5a = bl;
    }

    @Generated
    public void i_method_aefc2388(boolean bl) {
        this.i_field_5a = bl;
    }

    @Generated
    public void II_method_fba8397f(boolean bl) {
        this.II_field_5a = bl;
    }

    @Generated
    public void i_method_52aab796(String string) {
        this.I_field_523beb0a = string;
    }

    @Generated
    public void Ii_method_fd6b299f(boolean bl) {
        this.Ii_field_5a = bl;
    }

    @Generated
    public void iI_method_32434d5f(boolean bl) {
        this.iI_field_5a = bl;
    }

    @Generated
    public void I_method_3dfa51dd(List<Setting> list) {
        this.I_field_7865b31 = list;
    }

    @Generated
    public void i_method_aefbe3b7(int n) {
        this.i_field_49 = n;
    }
}

