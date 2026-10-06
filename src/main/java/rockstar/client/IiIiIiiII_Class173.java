package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.screen.ChatScreen;
import pyrock.events.client.ModuleToggledEvent;
import rockstar.client.III;
import rockstar.client.IIII;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.MenuModule;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.BooleanSetting;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIIIIIII_Class129;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiIIiII_Class165;
import rockstar.client.ModuleEntry;
import rockstar.client.IiIii_Class12;
import rockstar.client.IiIiiiII_Class93;
import rockstar.client.RockstarClient;
import rockstar.client.IiiI_Class7;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public class IiIiIiiII_Class173
extends IiIiIIiII_Class165 {
    private final BooleanSetting I_field_ba20ca4c = new BooleanSetting(this, "hud.always_display");
    private final IiIIIIIII_Class129 I_field_73178aac = new IiIIIIIII_Class129(this, "hud.uniform_width");
    private boolean I_field_5a;
    private iii_Class8 I_field_b584628c;
    private iiI_Class7 I_field_b5845eac;
    private final Map<ModuleEntry, iiI_Class7> I_field_a567c40b = new HashMap<ModuleEntry, iiI_Class7>();
    private final List<ModuleEntry> I_field_7865b31 = new ArrayList<ModuleEntry>();
    private List<ModuleEntry> i_field_7865b31 = List.of();
    private final IiiI_Class7 I_field_f94500c1 = (f, iiI_Class72, nested1_28a19593) -> {
        nested1_28a19593.I_field_46 = f;
        nested1_28a19593.i_field_46 = (this.I_field_5a ? 6.0f : -6.0f) * (1.0f - f);
    };
    private final IiIIIiII_Class69<ModuleToggledEvent> I_field_3d936f41 = moduleToggledEvent -> this.I_method_1325b3b4(moduleToggledEvent.getModule().getModule(), false);
    private final IiIIIiII_Class69<IiIiiiII_Class93> i_field_3d936f41 = iiIiiiII_Class93 -> this.I_method_1325b3b4(iiIiiiII_Class93.I_method_b7215beb(), true);

    public IiIiIiiII_Class173() {
        super("hud.keybinds", "keyboard");
        this.I_method_9d534e7f();
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    @Override
    protected iii_Class8 build() {
        this.I_field_a567c40b.clear();
        this.i_field_7865b31 = List.of();
        this.I_field_b584628c = new iii_Class8().I_method_485bccf5().I_method_483797dd(this.I_method_a94fe35()).I_method_70a38517(1.0f);
        this.I_field_b5845eac = new iii_Class8().i_method_c88da8d5().I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_70a38517(3.0f).IiI_method_31d4c97(11.0f).I_method_7e2bb176(IIII.i_method_4f8e6e83(3.0f)).I_method_f136b1d8((iII, iii_Class82) -> {
            iII.drawClientRect(iii_Class82.x(), iii_Class82.y(), iii_Class82.w(), iii_Class82.h(), this.animation.I_method_6ac4da6f(), this.dragAnim.I_method_6ac4da6f(), 3.0f, 3.0f);
            iII.drawSquircle(iii_Class82.x(), iii_Class82.y(), 23.0f, iii_Class82.h(), 3.0f, IIiii_Class8.I_method_893b2757(3.0f), new IiIii_Class12(IiiiiIIIi_Class242.Iii_field_d0c8ec5.mulAlpha(0.1f), IiiiiIIIi_Class242.Iii_field_d0c8ec5.mulAlpha(0.0f)));
        }).I_method_8939bffd(new Iii_Class4().size(7.0f, 7.0f).interactive(false).icon("keyboard", 7.0f, IiiiiIIIi_Class242.ii_field_d0c8ec5)).I_method_8939bffd(new Iii_Class4().interactive(false).text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.name), iii_Class4 -> IiiiiIIIi_Class242.iII_field_d0c8ec5));
        this.I_field_b584628c.I_method_8939bffd(this.I_field_b5845eac);
        this.I_method_9d534e7f();
        this.I_method_d173435(true);
        return this.I_field_b584628c;
    }

    private iiI_Class7 I_method_30787876(ModuleEntry iiIiiIii_Class922) {
        iiI_Class7 iiI_Class72 = this.I_field_a567c40b.computeIfAbsent(iiIiiIii_Class922, iiIiiIii_Class92 -> new iii_Class8().i_method_c88da8d5().I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_70a38517(1.0f).II_method_32b63e79(this.I_field_f94500c1).I_method_8939bffd(new Iii_Class4().interactive(false).fillWidth().height(10.0f).radius(2.0f).padding(IIII.i_method_4f8e6e83(3.0f)).background(iii_Class4 -> IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.889f)).text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f), iiIiiIii_Class92::getName, iii_Class4 -> IiiiiIIIi_Class242.iII_field_d0c8ec5)).I_method_8939bffd(new Iii_Class4().interactive(false).height(10.0f).radius(2.0f).padding(IIII.i_method_4f8e6e83(3.0f)).background(iii_Class4 -> IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.94f)).textAlign(IIi_Class2.i_field_b5755e8c).text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f), () -> iIIIIiIiI_Class267.I_method_a937749c(iiIiiIii_Class92.getKeybind()), iii_Class4 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f))));
        if (iiI_Class72.phase() == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866 || iiI_Class72.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866 || iiI_Class72.phase() == iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
            iiI_Class72.beginEnter(0.0f);
        }
        return iiI_Class72;
    }

    private void I_method_d173435(boolean bl) {
        if (!bl && this.I_field_7865b31.equals(this.i_field_7865b31)) {
            return;
        }
        this.i_field_7865b31 = List.copyOf(this.I_field_7865b31);
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0f);
        HashMap<ModuleEntry, Float> hashMap = new HashMap<ModuleEntry, Float>();
        for (ModuleEntry iiIiiIii_Class922 : this.I_field_7865b31) {
            hashMap.put(iiIiiIii_Class922, Float.valueOf(iIiIIi_Class10.I_method_2c375926(iiIiiIii_Class922.getName()) + iIiIIi_Class10.I_method_2c375926(iIIIIiIiI_Class267.I_method_a937749c(iiIiiIii_Class922.getKeybind()))));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.I_field_b5845eac);
        this.I_field_7865b31.stream().sorted(Comparator.comparingDouble(iiIiiIii_Class92 -> ((Float)hashMap.get(iiIiiIii_Class92)).floatValue()).reversed()).forEach(iiIiiIii_Class92 -> arrayList.add(this.I_method_30787876((ModuleEntry)iiIiiIii_Class92)));
        this.I_field_b584628c.II_method_244860a9(arrayList);
    }

    private void I_method_9d534e7f() {
        this.I_field_7865b31.clear();
        for (ModuleEntry iiIiiIii_Class92 : RockstarClient.getInstance().getModuleManager().getModules()) {
            if (!this.I_method_a5c76324(iiIiiIii_Class92)) continue;
            this.I_field_7865b31.add(iiIiiIii_Class92);
        }
    }

    private void I_method_1325b3b4(ModuleEntry iiIiiIii_Class92, boolean bl) {
        boolean bl2;
        boolean bl3 = this.I_method_a5c76324(iiIiiIii_Class92);
        if (!(bl3 != (bl2 = this.I_field_7865b31.contains(iiIiiIii_Class92)) || bl && bl3)) {
            return;
        }
        if (bl3 && !bl2) {
            this.I_field_7865b31.add(iiIiiIii_Class92);
        } else if (!bl3) {
            this.I_field_7865b31.remove(iiIiiIii_Class92);
        }
        if (this.I_field_b584628c != null) {
            this.I_method_d173435(bl);
        }
    }

    private boolean I_method_a5c76324(ModuleEntry iiIiiIii_Class92) {
        return !(iiIiiIii_Class92 instanceof MenuModule) && iiIiiIii_Class92.isEnabled() && iiIiiIii_Class92.getKeybind() != -1;
    }

    @Override
    public void update(III iII) {
        boolean bl = this.I_field_5a = this.x + this.width / 2.0f >= iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() / 2.0f;
        if (this.I_field_b584628c != null) {
            this.I_field_b584628c.I_method_483797dd(this.I_method_a94fe35());
        }
        super.update(iII);
    }

    private IIi_Class2 I_method_a94fe35() {
        return this.I_field_73178aac.i_method_9b12da03() ? IIi_Class2.Ii_field_b5755e8c : (this.I_field_5a ? IIi_Class2.II_field_b5755e8c : IIi_Class2.I_field_b5755e8c);
    }

    @Override
    public boolean show() {
        return this.I_field_ba20ca4c.i_method_9b12da03() || IiIiIiiII_Class173.I_field_3a9bda27.currentScreen instanceof ChatScreen || !this.I_field_7865b31.isEmpty();
    }
}

