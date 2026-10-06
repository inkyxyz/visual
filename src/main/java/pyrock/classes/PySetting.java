package pyrock.classes;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.Setting;
import rockstar.client.Vector2Setting;
import rockstar.client.KeybindSetting;
import rockstar.client.RegistryListSetting;
import rockstar.client.BooleanSetting;
import rockstar.client.ButtonSetting;
import rockstar.client.ColorSetting;
import rockstar.client.GradientColorSetting;
import rockstar.client.SectionSetting;
import rockstar.client.ModeSetting;
import rockstar.client.VectorRangeSetting;
import rockstar.client.RangeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.TextSetting;
import rockstar.client.TimeSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIIIiIiI_Class267;

public class PySetting {
    private final Setting s;

    public PySetting(Setting iIiiiIIII_Class113) {
        this.s = iIiiiIIII_Class113;
    }

    public Setting raw() {
        return this.s;
    }

    public String rawName() {
        return this.s.getName();
    }

    public String name() {
        return IiIiIIII_Class81.I_method_f25a980a(this.s.getName());
    }

    public boolean visible() {
        return this.s.isVisible();
    }

    public String type() {
        if (this.s instanceof BooleanSetting) {
            return "boolean";
        }
        if (this.s instanceof SliderSetting) {
            return "slider";
        }
        if (this.s instanceof RangeSetting) {
            return "range";
        }
        if (this.s instanceof ModeSetting) {
            return "mode";
        }
        if (this.s instanceof MultiSelectSetting) {
            return "select";
        }
        if (this.s instanceof ColorSetting) {
            return "color";
        }
        if (this.s instanceof ButtonSetting) {
            return "button";
        }
        if (this.s instanceof KeybindSetting) {
            return "bind";
        }
        if (this.s instanceof TextSetting) {
            return "text";
        }
        if (this.s instanceof TimeSetting) {
            return "time";
        }
        if (this.s instanceof GradientColorSetting) {
            return "gradient";
        }
        if (this.s instanceof VectorRangeSetting) {
            return "position";
        }
        if (this.s instanceof Vector2Setting) {
            return "bezier";
        }
        if (this.s instanceof RegistryListSetting) {
            return "blocks";
        }
        if (this.s instanceof SectionSetting) {
            return "info";
        }
        return "other";
    }

    public boolean boolGet() {
        return ((BooleanSetting)this.s).i_method_9b12da03();
    }

    public void boolToggle() {
        ((BooleanSetting)this.s).toggle();
    }

    public void boolSet(boolean bl) {
        ((BooleanSetting)this.s).I_method_4e1408b5(bl);
    }

    public float numGet() {
        return ((SliderSetting)this.s).Ii_method_a20abcd2();
    }

    public void numSet(float f) {
        ((SliderSetting)this.s).Ii_method_4e0e6b54(f);
    }

    public float numMin() {
        return ((SliderSetting)this.s).I_method_b2a48e2f();
    }

    public float numMax() {
        return ((SliderSetting)this.s).i_method_b2b31a0f();
    }

    public float numStep() {
        return ((SliderSetting)this.s).II_method_a1fc30f2();
    }

    public String[] options() {
        ArrayList<String> arrayList;
        block3: {
            Object object;
            block2: {
                arrayList = new ArrayList<String>();
                object = this.s;
                if (!(object instanceof ModeSetting)) break block2;
                ModeSetting iIiiiiiII_Class125 = (ModeSetting)object;
                for (ModeSetting.Nested1_42765c60 nested1_42765c60 : iIiiiiiII_Class125.I_method_e1d4a248()) {
                    arrayList.add(nested1_42765c60.getName());
                }
                break block3;
            }
            object = this.s;
            if (!(object instanceof MultiSelectSetting)) break block3;
            MultiSelectSetting iIiiiiiii_Class128 = (MultiSelectSetting)object;
            for (MultiSelectSetting.Nested1_42856060 nested1_42856060 : iIiiiiiii_Class128.I_method_45aaa648()) {
                arrayList.add(nested1_42856060.getName());
            }
        }
        return arrayList.toArray(new String[0]);
    }

    public String[] optionLabels() {
        String[] stringArray = this.options();
        String[] stringArray2 = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray2[i] = IiIiIIII_Class81.I_method_f25a980a(stringArray[i]);
        }
        return stringArray2;
    }

    public int modeIndex() {
        ModeSetting iIiiiiiII_Class125 = (ModeSetting)this.s;
        List<ModeSetting.Nested1_42765c60> list = iIiiiiiII_Class125.I_method_e1d4a248();
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) != iIiiiiiII_Class125.i_method_f85f3850()) continue;
            return i;
        }
        return -1;
    }

    public void modeSelect(int n) {
        ModeSetting iIiiiiiII_Class125 = (ModeSetting)this.s;
        if (n >= 0 && n < iIiiiiiII_Class125.I_method_e1d4a248().size()) {
            iIiiiiiII_Class125.I_method_e1d4a248().get(n).select();
        }
    }

    public boolean selOn(int n) {
        MultiSelectSetting iIiiiiiii_Class128 = (MultiSelectSetting)this.s;
        return n >= 0 && n < iIiiiiiii_Class128.I_method_45aaa648().size() && iIiiiiiii_Class128.I_method_45aaa648().get(n).isSelected();
    }

    public void selToggle(int n) {
        MultiSelectSetting iIiiiiiii_Class128 = (MultiSelectSetting)this.s;
        if (n >= 0 && n < iIiiiiiii_Class128.I_method_45aaa648().size()) {
            iIiiiiiii_Class128.I_method_45aaa648().get(n).toggle();
        }
    }

    public int selCount() {
        return ((MultiSelectSetting)this.s).i_method_faf6de68().size();
    }

    public ColorRGBA colorGet() {
        return ((ColorSetting)this.s).I_method_bde5f08e();
    }

    public void colorSet(ColorRGBA colorRGBA) {
        ((ColorSetting)this.s).I_method_a62f5dd6(colorRGBA);
    }

    public void click() {
        Runnable runnable = ((ButtonSetting)this.s).I_method_7db574f5();
        if (runnable != null) {
            runnable.run();
        }
    }

    public int bindKey() {
        return ((KeybindSetting)this.s).I_method_fa6281d2();
    }

    public String bindName() {
        return iIIIIiIiI_Class267.I_method_a937749c(((KeybindSetting)this.s).I_method_fa6281d2());
    }

    public void bindSet(int n) {
        ((KeybindSetting)this.s).I_method_51ee2d04(n);
    }

    public String textGet() {
        String string = ((TextSetting)this.s).II_method_da016c1e();
        return string == null ? "" : string;
    }

    public void textSet(String string) {
        ((TextSetting)this.s).I_method_104de33f(string);
    }

    public int timeGet() {
        return ((TimeSetting)this.s).III_method_2626c6b2();
    }

    public void timeSet(int n) {
        ((TimeSetting)this.s).I_method_9e134884(n);
    }

    public long timeMillis() {
        return ((TimeSetting)this.s).I_method_4f6bf653();
    }

    public int timeTicks() {
        return ((TimeSetting)this.s).Ii_method_9e3058b5();
    }

    public String timeFormatted() {
        return ((TimeSetting)this.s).II_method_5a3347fe();
    }

    public ColorRGBA gradientFirst() {
        return ((GradientColorSetting)this.s).I_method_b3b144ce();
    }

    public ColorRGBA gradientSecond() {
        return ((GradientColorSetting)this.s).i_method_3b9850ae();
    }

    public void gradientSet(ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        ((GradientColorSetting)this.s).I_method_1119eb95(colorRGBA, colorRGBA2);
    }

    public float posX() {
        return ((VectorRangeSetting)this.s).I_method_82f061ef();
    }

    public float posY() {
        return ((VectorRangeSetting)this.s).i_method_82feedcf();
    }

    public void posSet(float f, float f2) {
        ((VectorRangeSetting)this.s).I_method_f30816f5(f, f2);
    }

    public float bezierEase(float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        IiiiIiiII_Class237 iiiiIiiII_Class237 = ((Vector2Setting)this.s).I_method_71834715();
        return iiiiIiiII_Class237 == null ? f2 : iiiiIiiII_Class237.ease(f2, 0.0f, 1.0f, 1.0f);
    }

    public List<String> blocksSelected() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Identifier identifier : ((RegistryListSetting)this.s).I_method_12270fce()) {
            arrayList.add(identifier.toString());
        }
        return arrayList;
    }

    public boolean blockSelected(String string) {
        Identifier identifier = PySetting.blockId(string);
        return identifier != null && ((RegistryListSetting)this.s).I_method_c9a44a24(identifier);
    }

    public void blockToggle(String string) {
        Identifier identifier = PySetting.blockId(string);
        if (identifier == null) {
            return;
        }
        RegistryListSetting iIiiiIiiI_Class119 = (RegistryListSetting)this.s;
        if (iIiiiIiiI_Class119.I_method_c9a44a24(identifier)) {
            iIiiiIiiI_Class119.I_method_bcc5858b((Block)Registries.BLOCK.get(identifier));
        } else {
            iIiiiIiiI_Class119.I_method_568307b6(identifier);
        }
    }

    private static Identifier blockId(String string) {
        if (string == null || string.isBlank()) {
            return null;
        }
        String string2 = string.trim();
        return Identifier.tryParse((String)(string2.indexOf(58) < 0 ? "minecraft:" + string2 : string2));
    }
}

