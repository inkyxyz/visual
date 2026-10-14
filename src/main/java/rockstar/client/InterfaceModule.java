package rockstar.client;

import pyrock.utility.render.ColorRGBA;
import net.minecraft.client.MinecraftClient;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIiIIIii_Class164;
import rockstar.client.IiIiIIiII_Class165;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iII_Class5;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.Module;
import rockstar.client.iii_Class8;
import ua.mintantileak.spk.Compile;

import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(name="Interface", category=ModuleCategory.INTERFACE, iI_method_476ab839=true, ii_method_47794419=true)
public class InterfaceModule
extends Module {
    private final Map<IiIiIIiII_Class165, MultiSelectSetting.Nested1_42856060> I_field_a567c40b = new IdentityHashMap<IiIiIIiII_Class165, MultiSelectSetting.Nested1_42856060>();
    private MultiSelectSetting I_field_bbe3ba6c;
    private BooleanSetting separateThemes;
    private ModeSetting inGameThemePreset;
    private ModeSetting menuThemePreset;
    private ModeSetting visualStyle;
    private ModeSetting fontSetting;
    private ModeSetting menuObjectSetting;
    private ModeSetting hudStyle;
    private ModeSetting.Nested1_42765c60 hudStyleModern;
    private ModeSetting.Nested1_42765c60 hudStyleCyber;
    private ColorSetting accentColorSetting;
    private BooleanSetting liquidGlassSetting;
    private SliderSetting hudScale;
    private SliderSetting glassOpacity;
    private SliderSetting blurStrength;
    private SliderSetting borderGlow;
    private SliderSetting cornerRadius;
    private BooleanSetting islandVisualizer;
    private BooleanSetting hitSoundsSetting;
    private BooleanSetting uiSoundsSetting;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> tickListener = event -> this.updateTheme();

    public InterfaceModule() {
        this.IiI_method_c4cbfabf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_c4cbfabf() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.interface.elements"){

            @Override
            public JsonElement toJson() {
                return new JsonObject();
            }

            @Override
            public void fromJson(JsonElement jsonElement) {
            }

            @Override
            public boolean isValidJson(JsonElement jsonElement) {
                return jsonElement != null && jsonElement.isJsonObject();
            }

            @Override
            public iii_Class8 createComponent() {
                InterfaceModule.this.Iii_method_c4da869f();
                iii_Class8 iii_Class82 = super.createComponent().III_method_9dc17555();
                return new iii_Class8(){

                    @Override
                    protected void onTick(float f, float f2, float f3) {
                        InterfaceModule.this.Iii_method_c4da869f();
                        super.onTick(f, f2, f3);
                    }
                }.I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_8939bffd(iii_Class82);
            }
        };

        this.separateThemes = new BooleanSetting(this, "Separate Menu/Game Themes").I_method_decd82b5();

        this.inGameThemePreset = new ModeSetting(this, "In-Game Theme");
        new ModeSetting.Nested1_42765c60(this.inGameThemePreset, "Cyan Glow").select();
        new ModeSetting.Nested1_42765c60(this.inGameThemePreset, "Purple Neon");
        new ModeSetting.Nested1_42765c60(this.inGameThemePreset, "Sunset Orange");
        new ModeSetting.Nested1_42765c60(this.inGameThemePreset, "Emerald Green");
        new ModeSetting.Nested1_42765c60(this.inGameThemePreset, "Rose Pink");
        new ModeSetting.Nested1_42765c60(this.inGameThemePreset, "Ice Blue");
        new ModeSetting.Nested1_42765c60(this.inGameThemePreset, "Custom");

        this.menuThemePreset = new ModeSetting(this, "Menu Theme", this.separateThemes::i_method_9b12da03);
        new ModeSetting.Nested1_42765c60(this.menuThemePreset, "Purple Neon").select();
        new ModeSetting.Nested1_42765c60(this.menuThemePreset, "Cyan Glow");
        new ModeSetting.Nested1_42765c60(this.menuThemePreset, "Sunset Orange");
        new ModeSetting.Nested1_42765c60(this.menuThemePreset, "Emerald Green");
        new ModeSetting.Nested1_42765c60(this.menuThemePreset, "Rose Pink");
        new ModeSetting.Nested1_42765c60(this.menuThemePreset, "Ice Blue");
        new ModeSetting.Nested1_42765c60(this.menuThemePreset, "Custom");

        this.visualStyle = new ModeSetting(this, "Visual Style");
        new ModeSetting.Nested1_42765c60(this.visualStyle, "Liquid Glass").select();
        new ModeSetting.Nested1_42765c60(this.visualStyle, "Tactical Cyber");
        this.hudStyle = new ModeSetting(this, "HUD Style");
        this.hudStyleModern = new ModeSetting.Nested1_42765c60(this.hudStyle, "Liquid Glass").select();
        this.hudStyleCyber = new ModeSetting.Nested1_42765c60(this.hudStyle, "Tactical Cyber");
        this.accentColorSetting = new ColorSetting(this, "Accent Color").I_method_a62f5dd6(new ColorRGBA(171.0F, 254.0F, 255.0F));
        this.liquidGlassSetting = new BooleanSetting(this, "Liquid Glass").I_method_decd82b5();
        this.hudScale = new SliderSetting(this, "HUD Scale")
            .I_method_c8c9a7d7(0.6F)
            .i_method_65e2aff7(1.5F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(1.0F);
        this.glassOpacity = new SliderSetting(this, "HUD Opacity")
            .I_method_c8c9a7d7(0.2F)
            .i_method_65e2aff7(1.0F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(0.55F);
        this.blurStrength = new SliderSetting(this, "Blur Strength")
            .I_method_c8c9a7d7(5.0F)
            .i_method_65e2aff7(50.0F)
            .II_method_b0f56334(1.0F)
            .Ii_method_4e0e6b54(25.0F);
        this.borderGlow = new SliderSetting(this, "Border Glow")
            .I_method_c8c9a7d7(0.0F)
            .i_method_65e2aff7(1.0F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(0.65F);
        this.cornerRadius = new SliderSetting(this, "Corner Radius")
            .I_method_c8c9a7d7(2.0F)
            .i_method_65e2aff7(16.0F)
            .II_method_b0f56334(1.0F)
            .Ii_method_4e0e6b54(7.0F);
        this.islandVisualizer = new BooleanSetting(this, "Island Visualizer").I_method_decd82b5();
        this.fontSetting = new ModeSetting(this, "Font");
        new ModeSetting.Nested1_42765c60(this.fontSetting, "Inter").select();
        new ModeSetting.Nested1_42765c60(this.fontSetting, "Medium");
        new ModeSetting.Nested1_42765c60(this.fontSetting, "SemiBold");
        new ModeSetting.Nested1_42765c60(this.fontSetting, "Bold");
        new ModeSetting.Nested1_42765c60(this.fontSetting, "Round");
        new ModeSetting.Nested1_42765c60(this.fontSetting, "JetBrains");
        new ModeSetting.Nested1_42765c60(this.fontSetting, "Light");

        this.menuObjectSetting = new ModeSetting(this, "Menu 3D Object");
        new ModeSetting.Nested1_42765c60(this.menuObjectSetting, "Crystal").select();
        new ModeSetting.Nested1_42765c60(this.menuObjectSetting, "Sphere");
        new ModeSetting.Nested1_42765c60(this.menuObjectSetting, "Rings");
        new ModeSetting.Nested1_42765c60(this.menuObjectSetting, "Black Hole");
        new ModeSetting.Nested1_42765c60(this.menuObjectSetting, "Disabled");

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

        this.updateTheme();
        this.Iii_method_c4da869f();
    }

    public static String getMenuObjectType() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        if (mod != null && mod.menuObjectSetting != null && mod.menuObjectSetting.i_method_f85f3850() != null) {
            return mod.menuObjectSetting.i_method_f85f3850().getName();
        }
        return "Crystal";
    }

    public static void cycleMenuObject() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        if (mod != null && mod.menuObjectSetting != null) {
            List<ModeSetting.Nested1_42765c60> list = mod.menuObjectSetting.I_field_7865b31;
            if (list != null && !list.isEmpty()) {
                int curr = list.indexOf(mod.menuObjectSetting.i_method_f85f3850());
                int next = (curr + 1) % list.size();
                list.get(next).select();
            }
        }
    }

    public static void checkTheme() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        if (mod != null) {
            mod.updateTheme();
        }
    }

    private String lastAppliedFont = "";

    public void updateTheme() {
        if (this.fontSetting != null && this.fontSetting.i_method_f85f3850() != null) {
            String currentFont = this.fontSetting.i_method_f85f3850().getName();
            if (!currentFont.equalsIgnoreCase(this.lastAppliedFont)) {
                this.lastAppliedFont = currentFont;
                IIiIiI_Class11.applyFontPreset(currentFont);
            }
        }

        MinecraftClient mc = MinecraftClient.getInstance();
        boolean inMenu = (mc.world == null || mc.currentScreen instanceof IiiIIiIii_Class204);
        ModeSetting activePreset = (this.separateThemes != null && this.separateThemes.i_method_9b12da03() && inMenu)
            ? this.menuThemePreset
            : this.inGameThemePreset;

        ColorRGBA col = this.accentColorSetting != null ? this.accentColorSetting.I_method_bde5f08e() : null;
        if (activePreset != null) {
            if (activePreset.isSelected("Cyan Glow")) {
                col = new ColorRGBA(171.0F, 254.0F, 255.0F);
            } else if (activePreset.isSelected("Purple Neon")) {
                col = new ColorRGBA(180.0F, 100.0F, 255.0F);
            } else if (activePreset.isSelected("Sunset Orange")) {
                col = new ColorRGBA(255.0F, 128.0F, 40.0F);
            } else if (activePreset.isSelected("Emerald Green")) {
                col = new ColorRGBA(40.0F, 255.0F, 140.0F);
            } else if (activePreset.isSelected("Rose Pink")) {
                col = new ColorRGBA(255.0F, 90.0F, 160.0F);
            } else if (activePreset.isSelected("Ice Blue")) {
                col = new ColorRGBA(100.0F, 185.0F, 255.0F);
            } else if (activePreset.isSelected("Custom")) {
                col = this.accentColorSetting != null ? this.accentColorSetting.I_method_bde5f08e() : new ColorRGBA(171.0F, 254.0F, 255.0F);
            }
        }
        if (col != null) {
            ColorRGBA full = col.withAlpha(255.0F);
            if (!full.equals(IiiiiIIIi_Class242.I_method_7df8e08e())) {
                IiiiiIIIi_Class242.I_method_300b2840(full);
            }
        }
    }

    void Iii_method_c4da869f() {
        List<MultiSelectSetting.Nested1_42856060> list;
        IiIiIIIii_Class164 iiIiIIIii_Class164 = RockstarClient.getInstance().I_method_35687482();
        if (iiIiIIIii_Class164 == null || this.I_field_bbe3ba6c == null) {
            return;
        }
        List<IiIiIIiII_Class165> list2 = iiIiIIIii_Class164.III_method_812fc188();
        List<MultiSelectSetting.Nested1_42856060> list3 = this.I_field_bbe3ba6c.I_method_45aaa648();
        if (!this.I_method_11cc0e25(list3, list2)) {
            list = new ArrayList<MultiSelectSetting.Nested1_42856060>(list2.size());
            for (IiIiIIiII_Class165 object : list2) {
                list.add(this.I_field_a567c40b.computeIfAbsent(object, iiIiIIiII_Class165 -> new Nested1_a7d56c40(this.I_field_bbe3ba6c, (IiIiIIiII_Class165)iiIiIIiII_Class165)));
            }
            this.I_field_a567c40b.keySet().removeIf(iiIiIIiII_Class165 -> !list2.contains(iiIiIIiII_Class165));
            list3.clear();
            list3.addAll(list);
        }
        list = this.I_field_bbe3ba6c.i_method_faf6de68();
        list.removeIf(nested1_42856060 -> !list3.contains(nested1_42856060));
        for (MultiSelectSetting.Nested1_42856060 nested1_428560602 : list3) {
            boolean bl = nested1_428560602.isSelected();
            if (bl == list.contains(nested1_428560602)) continue;
            if (bl) {
                list.add(nested1_428560602);
                continue;
            }
            list.remove(nested1_428560602);
        }
    }

    private boolean I_method_11cc0e25(List<MultiSelectSetting.Nested1_42856060> list, List<IiIiIIiII_Class165> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list2.size(); ++i) {
            if (this.I_field_a567c40b.get(list2.get(i)) == list.get(i)) continue;
            return false;
        }
        return true;
    }

    public static boolean IiI_method_c4cbfac3() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        return mod == null || mod.liquidGlassSetting == null || mod.liquidGlassSetting.i_method_9b12da03();
    }

    public static String getVisualStyle() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        if (mod != null && mod.visualStyle != null && mod.visualStyle.i_method_f85f3850() != null) {
            return mod.visualStyle.i_method_f85f3850().getName();
        }
        return "Liquid Glass";
    }

    public static String getHudStyle() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        if (mod != null && mod.hudStyle != null && mod.hudStyle.i_method_f85f3850() != null) {
            return mod.hudStyle.i_method_f85f3850().getName();
        }
        return "Liquid Glass";
    }

    public static boolean isCyberHud() {
        return "Tactical Cyber".equalsIgnoreCase(getHudStyle());
    }

    public static boolean isGlitchMatrixHud() {
        return "Glitch Matrix".equalsIgnoreCase(getHudStyle());
    }

    public static boolean isAnimeNeonHud() {
        return "Anime Neon".equalsIgnoreCase(getHudStyle());
    }

    public static boolean isMinimalModernHud() {
        return "Minimal Modern".equalsIgnoreCase(getHudStyle());
    }

    public static boolean isSteampunkHud() {
        return "Steampunk Brass".equalsIgnoreCase(getHudStyle());
    }

    public static boolean isCrimsonBloodHud() {
        return "Crimson Blood".equalsIgnoreCase(getHudStyle());
    }

    public static boolean isRoyalGoldHud() {
        return "Royal Gold".equalsIgnoreCase(getHudStyle());
    }

    public static boolean isAmethystDreamHud() {
        return "Amethyst Dream".equalsIgnoreCase(getHudStyle());
    }

    public static boolean isVaporwaveHud() {
        return "Vaporwave".equalsIgnoreCase(getHudStyle());
    }

    public float getHudScale() {
        return this.hudScale != null ? this.hudScale.Ii_method_a20abcd2() : 1.0F;
    }

    public static float getGlassOpacity() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        return mod != null && mod.glassOpacity != null ? mod.glassOpacity.Ii_method_a20abcd2() : 0.85F;
    }

    public static float getBlurStrength() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        return mod != null && mod.blurStrength != null ? mod.blurStrength.Ii_method_a20abcd2() : 25.0F;
    }

    public static float getBorderGlow() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        return mod != null && mod.borderGlow != null ? mod.borderGlow.Ii_method_a20abcd2() : 0.65F;
    }

    public static float getCornerRadius() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        return mod != null && mod.cornerRadius != null ? mod.cornerRadius.Ii_method_a20abcd2() : 7.0F;
    }

    public static boolean isIslandVisualizer() {
        InterfaceModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class)
            : null;
        return mod == null || mod.islandVisualizer == null || mod.islandVisualizer.i_method_9b12da03();
    }

    public static float I_method_fdcdb22f() {
        return IiI_method_c4cbfac3() ? 1.0f : 0.0f;
    }

    public static float i_method_fddc3e0f() {
        return 1.0f;
    }

    public static float II_method_bbf78cf2() {
        return 0.79f;
    }

    public static float Ii_method_bc0618d2() {
        return 12.0f;
    }

    public static float iI_method_bdba7d12() {
        return 2.0f;
    }

    public static float ii_method_bdc908f2() {
        return 1.0f;
    }

    public static boolean Iii_method_c4da86a3() {
        return IiI_method_c4cbfac3();
    }

    public static boolean iII_method_f9a41e83() {
        return true;
    }

    @Generated
    public Map<IiIiIIiII_Class165, MultiSelectSetting.Nested1_42856060> i_method_7dbae14() {
        return this.I_field_a567c40b;
    }

    @Generated
    public MultiSelectSetting I_method_1ace6b15() {
        return this.I_field_bbe3ba6c;
    }

    static final class Nested1_a7d56c40
    extends MultiSelectSetting.Nested1_42856060 {
        private final IiIiIIiII_Class165 I_field_fed7eac;

        Nested1_a7d56c40(MultiSelectSetting iIiiiiiii_Class128, IiIiIIiII_Class165 iiIiIIiII_Class165) {
            super(iIiiiiiii_Class128, iiIiIIiII_Class165.getName());
            this.I_field_fed7eac = iiIiIIiII_Class165;
        }

        @Override
        public boolean isSelected() {
            return this.I_field_fed7eac.isShowing();
        }

        @Override
        public MultiSelectSetting.Nested1_42856060 toggle() {
            boolean bl;
            boolean bl2 = bl = !this.I_field_fed7eac.isShowing();
            if (bl && this.I_field_fed7eac.getX() == 0.0f && this.I_field_fed7eac.getY() == 0.0f) {
                this.I_field_fed7eac.pos(iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() / 2.0f, iIIiIIiiI_Class295.I_field_73c6d26c.i_method_805d6def() / 2.0f);
            }
            this.I_field_fed7eac.setShowing(bl);
            if (bl) {
                this.select();
            } else {
                this.deselect();
            }
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            return this;
        }
    }
}

