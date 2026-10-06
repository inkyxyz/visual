package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIII;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.AbstractSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iII_Class5;
import rockstar.client.iiIIIiiIi_Class398;
import rockstar.client.iiII_Class13;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public class ModeSetting
extends AbstractSetting {
    final List<Nested1_42765c60> I_field_7865b31 = new ArrayList<Nested1_42765c60>();
    private Nested1_42765c60 I_field_500d0627;

    public ModeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public ModeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, @NotNull BooleanSupplier booleanSupplier) {
        super(iIiiiIIiI_Class115, string, booleanSupplier);
    }

    public ModeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string, String string2) {
        super(iIiiiIIiI_Class115, string);
    }

    public ModeSetting(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
        super(iIiiiIIiI_Class115, string);
    }

    public void I_method_ce989e22(Nested1_42765c60 nested1_42765c60) {
        this.I_field_7865b31.add(nested1_42765c60);
        if (this.I_field_500d0627 == null) {
            this.I_field_500d0627 = nested1_42765c60;
        }
    }

    public void I_method_15e42ca0(String ... stringArray) {
        String string = this.I_field_500d0627 == null ? null : this.I_field_500d0627.getName();
        this.I_field_7865b31.clear();
        this.I_field_500d0627 = null;
        if (stringArray == null) {
            return;
        }
        for (String string2 : stringArray) {
            new Nested1_42765c60(this, string2);
        }
        if (string != null) {
            for (Nested1_42765c60 nested1_42765c60 : this.I_field_7865b31) {
                if (!nested1_42765c60.getName().equalsIgnoreCase(string)) continue;
                this.I_field_500d0627 = nested1_42765c60;
                return;
            }
        }
        if (!this.I_field_7865b31.isEmpty()) {
            this.I_field_500d0627 = this.I_field_7865b31.getFirst();
        }
    }

    public boolean isSelected(String string) {
        return this.I_method_1544ce2d(string);
    }

    public boolean I_method_1544ce2d(String string) {
        return this.I_field_500d0627 != null && this.I_field_500d0627.getName().equalsIgnoreCase(string);
    }

    public boolean I_method_ce989e26(Nested1_42765c60 nested1_42765c60) {
        return this.I_field_500d0627 == nested1_42765c60;
    }

    public void i_method_89901e42(Nested1_42765c60 nested1_42765c60) {
        if (this.I_field_500d0627 == nested1_42765c60) {
            return;
        }
        this.I_field_500d0627 = nested1_42765c60;
        this.notifyChanged();
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive(this.I_field_500d0627 == null ? "" : this.I_field_500d0627.getName());
    }

    public Nested1_42765c60 I_method_f2573c70() {
        List<Nested1_42765c60> list = this.I_field_7865b31.stream().filter(Nested1_42765c60::isSelected).toList();
        if (!list.isEmpty()) {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
        return null;
    }

    @Override
    public void fromJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            return;
        }
        String string = jsonElement.getAsString();
        for (Nested1_42765c60 nested1_42765c60 : this.I_field_7865b31) {
            if (!nested1_42765c60.getName().equalsIgnoreCase(string)) continue;
            this.I_field_500d0627 = nested1_42765c60;
            break;
        }
    }

    @Override
    public boolean isValidJson(JsonElement jsonElement) {
        if (jsonElement == null || !jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            return false;
        }
        String string = jsonElement.getAsString();
        return this.I_field_7865b31.stream().anyMatch(nested1_42765c60 -> nested1_42765c60.getName().equalsIgnoreCase(string));
    }

    @Override
    public iii_Class8 createComponent() {
        iii_Class8 iii_Class82 = new iii_Class8().I_method_8939bffd(new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a)).I_method_6da713d1(iiII_Class132 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75f + 0.25f * iiII_Class132.hover())).i_method_6b618aeb().fill()).I_method_70a38517(6.0f).I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0f, 0.0f, 0.0f, 0.0f)).III_method_9dc17555();
        iii_Class8 iii_Class83 = new iii_Class8(){
            private final IdentityHashMap<Nested1_42765c60, iiI_Class7> I_field_af8d717 = new IdentityHashMap();
            private List<Nested1_42765c60> I_field_7865b31;
            {
                for (Nested1_42765c60 nested1_42765c60 : ModeSetting.this.I_field_7865b31) {
                    Iii_Class4 iii_Class4 = nested1_42765c60.buildComponent();
                    this.I_field_af8d717.put(nested1_42765c60, iii_Class4);
                    this.I_method_8939bffd(iii_Class4);
                }
                this.I_field_7865b31 = new ArrayList<Nested1_42765c60>(ModeSetting.this.I_field_7865b31);
            }

            @Override
            protected void onTick(float f, float f2, float f3) {
                if (!ModeSetting.I_method_3fec2a05(this.I_field_7865b31, ModeSetting.this.I_field_7865b31)) {
                    ArrayList<iiI_Class7> arrayList = new ArrayList<iiI_Class7>(ModeSetting.this.I_field_7865b31.size());
                    for (Nested1_42765c60 nested1_42765c602 : ModeSetting.this.I_field_7865b31) {
                        arrayList.add(this.I_field_af8d717.computeIfAbsent(nested1_42765c602, Nested1_42765c60::buildComponent));
                    }
                    this.I_field_af8d717.keySet().removeIf(nested1_42765c60 -> !ModeSetting.this.I_field_7865b31.contains(nested1_42765c60));
                    this.II_method_244860a9(arrayList);
                    this.I_field_7865b31 = new ArrayList<Nested1_42765c60>(ModeSetting.this.I_field_7865b31);
                }
                super.onTick(f, f2, f3);
            }
        }.I_method_3301fdd(iII_Class5.II_field_b583e68c).I_method_70a38517(2.0f).III_method_9dc17555().I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0f, 0.0f, 5.0f, 0.0f)).II_method_3b06fa38();
        return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_70a38517(5.0f).I_method_8939bffd(iii_Class82).I_method_8939bffd(iii_Class83);
    }

    static boolean I_method_3fec2a05(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) == list2.get(i)) continue;
            return false;
        }
        return true;
    }

    @Generated
    public List<Nested1_42765c60> I_method_e1d4a248() {
        return this.I_field_7865b31;
    }

    @Generated
    public Nested1_42765c60 i_method_f85f3850() {
        return this.I_field_500d0627;
    }

    public static class Nested1_42765c60 {
        private final ModeSetting parent;
        private final String name;
        private final String description;
        private final IiiiIiIii_Class236 hoverAnimation = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
        private final IiiiIiIii_Class236 activeAnimation = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
        private final BooleanSupplier hideCondition;
        private iiIIIiiIi_Class398 enablePenis;
        private iiIIIiiIi_Class398 disablePenis;
        private iiIIIiiIi_Class398 currentPenis;
        private boolean lastState;

        public Nested1_42765c60(ModeSetting iIiiiiiII_Class125, String string) {
            this(iIiiiiiII_Class125, string, "", () -> false);
        }

        public Nested1_42765c60(ModeSetting iIiiiiiII_Class125, String string, String string2) {
            this(iIiiiiiII_Class125, string, string2, () -> false);
        }

        public Nested1_42765c60(ModeSetting iIiiiiiII_Class125, String string, String string2, BooleanSupplier booleanSupplier) {
            this.parent = iIiiiiiII_Class125;
            this.name = string;
            this.description = string2;
            this.hideCondition = booleanSupplier;
            iIiiiiiII_Class125.I_method_ce989e22(this);
        }

        public boolean isHidden() {
            return this.hideCondition != null && this.hideCondition.getAsBoolean();
        }

        public Nested1_42765c60 select() {
            this.parent.i_method_89901e42(this);
            return this;
        }

        public boolean isSelected() {
            return this.parent.i_method_f85f3850() == this;
        }

        public Iii_Class4 buildComponent() {
            return new Iii_Class4().bind("selected", this::isSelected, IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.III_field_dd60aac)).text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), () -> IiIiIIII_Class81.I_method_f25a980a(this.name), iii_Class4 -> IiiiiIIIi_Class242.I_method_35ed8eaf(Nested1_42765c60.background(iii_Class4)).mulAlpha(0.75f + 0.25f * iii_Class4.sig("selected"))).textAlign(IIi_Class2.i_field_b5755e8c).background(Nested1_42765c60::background).radius(2.5f).padding(IIII.I_method_14640aa3(3.0f)).cursor(iIIIiIIIi_Class274.i_field_aa52e62c).onClick(this::select);
        }

        private static ColorRGBA background(Iii_Class4 iii_Class4) {
            return IiiiiIIIi_Class242.IIi_field_d0c8ec5.mix(IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.2f * iii_Class4.hover()).mix(IiiiiIIIi_Class242.ii_field_d0c8ec5.mix(IiiiiIIIi_Class242.IIi_field_d0c8ec5, 0.2f * iii_Class4.hover()), iii_Class4.sig("selected"));
        }

        public String toString() {
            return this.name;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null || object.getClass() != this.getClass()) {
                return false;
            }
            Nested1_42765c60 nested1_42765c60 = (Nested1_42765c60)object;
            return Objects.equals(this.parent, nested1_42765c60.parent) && Objects.equals(this.name, nested1_42765c60.name) && Objects.equals(this.description, nested1_42765c60.description);
        }

        public int hashCode() {
            return Objects.hash(this.parent, this.name, this.description);
        }

        @Generated
        public void setEnablePenis(iiIIIiiIi_Class398 iiIIIiiIi_Class3982) {
            this.enablePenis = iiIIIiiIi_Class3982;
        }

        @Generated
        public void setDisablePenis(iiIIIiiIi_Class398 iiIIIiiIi_Class3982) {
            this.disablePenis = iiIIIiiIi_Class3982;
        }

        @Generated
        public void setCurrentPenis(iiIIIiiIi_Class398 iiIIIiiIi_Class3982) {
            this.currentPenis = iiIIIiiIi_Class3982;
        }

        @Generated
        public void setLastState(boolean bl) {
            this.lastState = bl;
        }

        @Generated
        public ModeSetting getParent() {
            return this.parent;
        }

        @Generated
        public String getName() {
            return this.name;
        }

        @Generated
        public String getDescription() {
            return this.description;
        }

        @Generated
        public IiiiIiIii_Class236 getHoverAnimation() {
            return this.hoverAnimation;
        }

        @Generated
        public IiiiIiIii_Class236 getActiveAnimation() {
            return this.activeAnimation;
        }

        @Generated
        public BooleanSupplier getHideCondition() {
            return this.hideCondition;
        }

        @Generated
        public iiIIIiiIi_Class398 getEnablePenis() {
            return this.enablePenis;
        }

        @Generated
        public iiIIIiiIi_Class398 getDisablePenis() {
            return this.disablePenis;
        }

        @Generated
        public iiIIIiiIi_Class398 getCurrentPenis() {
            return this.currentPenis;
        }

        @Generated
        public boolean isLastState() {
            return this.lastState;
        }
    }
}

