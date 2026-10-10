package rockstar.client;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import pyrock.events.game.GameTickEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import rockstar.client.AntiAimModule;
import rockstar.client.AssistModule;
import rockstar.client.AuctionModule;
import rockstar.client.AutoAcceptModule;
import rockstar.client.AutoAuthModule;
import rockstar.client.AutoBuyModule;
import rockstar.client.AutoDuelsModule;
import rockstar.client.AutoJoinModule;
import rockstar.client.AutoResellModule;
import rockstar.client.BaseFinderModule;
import rockstar.client.DeathCordsModule;
import rockstar.client.EffectRemoverModule;
import rockstar.client.FastItemUseModule;
import rockstar.client.GlobalsMenuModule;
import rockstar.client.InventoryBuilderModule;
import rockstar.client.InventoryCleanerModule;
import rockstar.client.ItemPickupModule;
import rockstar.client.KtLeaveModule;
import rockstar.client.NameProtectModule;
import rockstar.client.PanicModule;
import rockstar.client.RussianRouletteModule;
import rockstar.client.SoundsModule;
import rockstar.client.TestModule;
import rockstar.client.WebUtilsModule;
import rockstar.client.AutoEatModule;
import rockstar.client.AutoFarmModule;
import rockstar.client.AutoInvisibleModule;
import rockstar.client.AutoLeaveModule;
import rockstar.client.AutoShulkerModule;
import rockstar.client.AutoSwapModule;
import rockstar.client.BlinkModule;
import rockstar.client.BootsSwapModule;
import rockstar.client.ClanUpgradeModule;
import rockstar.client.ClickThroughModule;
import rockstar.client.ElytraUtilsModule;
import rockstar.client.FreeCameraModule;
import rockstar.client.GuiMoveModule;
import rockstar.client.InventoryUtilsModule;
import rockstar.client.MiddleClickModule;
import rockstar.client.MineHelperModule;
import rockstar.client.NoDelayModule;
import rockstar.client.NoFallModule;
import rockstar.client.NoInteractModule;
import rockstar.client.NoPushModule;
import rockstar.client.NoRotateModule;
import rockstar.client.NukerModule;
import rockstar.client.PlayerUtilsModule;
import rockstar.client.ScaffoldModule;
import rockstar.client.StealerModule;
import rockstar.client.TargetPearlModule;
import rockstar.client.TrackerModule;
import rockstar.client.AmbienceModule;
import rockstar.client.AntiInvisibleModule;
import rockstar.client.BeautifullyModule;
import rockstar.client.CustomFogModule;
import rockstar.client.DonateEffectsModule;
import rockstar.client.EspModule;
import rockstar.client.InterfaceModule;
import rockstar.client.KillEffectsModule;
import rockstar.client.MenuModule;
import rockstar.client.ObjectInfoModule;
import rockstar.client.PredictionModule;
import rockstar.client.RemovalsModule;
import rockstar.client.SoundEspModule;
import rockstar.client.StorageEspModule;
import rockstar.client.SwingAnimationModule;
import rockstar.client.TntTimerModule;
import rockstar.client.TargetEspModule;
import rockstar.client.ViewModelModule;
import rockstar.client.WardenHelperModule;
import rockstar.client.WaypointsModule;
import rockstar.client.WorldModule;
import rockstar.client.XRayModule;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleEntry;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIII_Class257;
import rockstar.client.iiIIiIiI_Class203;
import rockstar.client.Module;
import rockstar.client.AimAssistModule;
import rockstar.client.AimBotModule;
import rockstar.client.AntiBotModule;
import rockstar.client.AuraModule;
import rockstar.client.AutoAnchorModule;
import rockstar.client.AutoArmorModule;
import rockstar.client.AutoExplosionModule;
import rockstar.client.AutoPotionModule;
import rockstar.client.AutoSoupModule;
import rockstar.client.AutoThrowModule;
import rockstar.client.AutoTotemModule;
import rockstar.client.BackTrackModule;
import rockstar.client.CriticalsModule;
import rockstar.client.ElytraTargetModule;
import rockstar.client.HitboxesModule;
import rockstar.client.KnockbackTweaksModule;
import rockstar.client.TriggerBotModule;
import rockstar.client.VelocityModule;
import rockstar.client.AirStuckModule;
import rockstar.client.AutoSprintModule;
import rockstar.client.ElytraStrafeModule;
import rockstar.client.FlightModule;
import rockstar.client.GrimGlideModule;
import rockstar.client.HighJumpModule;
import rockstar.client.NoSlowModule;
import rockstar.client.SpeedModule;
import rockstar.client.SpiderModule;
import rockstar.client.StrafeModule;
import rockstar.client.SuperFireworkModule;
import rockstar.client.TimerModule;
import rockstar.client.WaterSpeedModule;
import rockstar.client.AdminskyModule;
import ua.mintantileak.spk.Compile;

public class ModuleManager {
    private final Map<Class<? extends ModuleEntry>, ModuleEntry> I_field_a567c40b = new IdentityHashMap<Class<? extends ModuleEntry>, ModuleEntry>();
    private final List<ModuleEntry> I_field_7865b31 = new ArrayList<ModuleEntry>();
    private static int I_field_49;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;
    private final IiIIIiII_Class69<HudRenderEvent> i_field_3d936f41;
    private final IiIIIiII_Class69<KeyPressEvent> II_field_3d936f41 = keyPressEvent -> {
        if (MinecraftClient.getInstance().currentScreen != null) {
            return;
        }
        if (keyPressEvent.getAction() != 1) {
            return;
        }
        int n = iIIIIIIII_Class257.I_method_e761de12();
        for (ModuleEntry iiIiiIii_Class92 : this.getModules()) {
            if (!iiIiiIii_Class92.isAvailable() || !iIIIIIIII_Class257.I_method_37b59828(iiIiiIii_Class92.getKeybind(), keyPressEvent.getKey(), n)) continue;
            iiIiiIii_Class92.toggle();
        }
    };
    private final IiIIIiII_Class69<MouseEvent> Ii_field_3d936f41 = mouseEvent -> {
        if (MinecraftClient.getInstance().currentScreen != null) {
            return;
        }
        if (mouseEvent.getAction() != 1) {
            return;
        }
        int n = iIIIIIIII_Class257.I_method_e761de12();
        for (ModuleEntry iiIiiIii_Class92 : this.getModules()) {
            if (!iiIiiIii_Class92.isAvailable() || !iIIIIIIII_Class257.I_method_37b59828(iiIiiIii_Class92.getKeybind(), mouseEvent.getButton(), n)) continue;
            iiIiiIii_Class92.toggle();
        }
    };
    private final IiIIIiII_Class69<GameTickEvent> iI_field_3d936f41 = gameTickEvent -> {
        if (!Module.ii_method_af18f3f9()) {
            return;
        }
        for (ModuleEntry iiIiiIii_Class92 : this.getModules()) {
            if (!iiIiiIii_Class92.isEnabled() || iiIiiIii_Class92.isAvailable()) continue;
            iiIiiIii_Class92.setEnabled(false, true);
        }
    };

    public static void I_method_7056a46c() {
        ++I_field_49;
    }

    public ModuleManager(IiIIIiII_Class69<ClientPlayerTickEvent> iiIIIiII_Class69, IiIIIiII_Class69<HudRenderEvent> iiIIIiII_Class692) {
        this.I_field_3d936f41 = iiIIIiII_Class69;
        this.i_field_3d936f41 = iiIIIiII_Class692;
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    @Compile(obfuscation=4)
    public final void registerModules() {
        this.registerModule(new MenuModule());
        this.registerModule(new WaypointsModule());
        this.registerModule(new RemovalsModule());
        this.registerModule(new AmbienceModule());
        this.registerModule(new SwingAnimationModule());
        this.registerModule(new BeautifullyModule());
        this.registerModule(new ViewModelModule());
        this.registerModule(new InterfaceModule());
        this.registerModule(new TargetEspModule());
        this.registerModule(new CustomFogModule());
        this.registerModule(new WorldModule());
        this.registerModule(new KillEffectsModule());
        this.registerModule(new DonateEffectsModule());
        this.registerModule(new DeathCordsModule());
        this.registerModule(new SoundsModule());
        this.registerModule(new HitSoundsModule());
        this.registerModule(new UISoundsModule());
        this.registerModule(new NameProtectModule());
        this.registerModule(new AutoSprintModule());
        this.registerModule(new WingsModule());
        this.registerModule(new CompanionPetsModule());
        this.registerModule(new HaloModule());
        this.registerModule(new JumpCircleModule());
        this.registerModule(new MotionBlurModule());
        this.registerModule(new HitBubbleModule());
        this.registerModule(new AspectRatioModule());
        this.registerModule(new SkyShaderModule());
        this.registerModule(new TrailsModule());
        this.registerModule(new HeadwearModule());
        this.registerModule(new BodyAccessoriesModule());
        this.registerModule(new MagicOrbitersModule());
        this.registerModule(new PetsModule());
        this.registerModule(new CardOrbitModule());
        this.registerModule(new CardHitEffectModule());
        this.registerModule(new CardTrailModule());
        this.registerModule(new HitColorModule());
        this.registerModule(new EzzVisualModule());
        this.registerModule(new DismembermentModule());
        this.registerModule(new MaceEffectsModule());
        this.registerModule(new TitlesModule());
        this.registerModule(new ItemPhysicsModule());
        this.registerModule(new AnimationWheelModule());
        this.registerModule(new ParticlesModule());
        this.registerModule(new BlockOverlayModule());
        this.registerModule(new WeatherAlertModule());
        this.registerModule(new ItemChangerModule());
        this.snapshotModuleSettings();
    }

    @Compile(obfuscation=1)
    public final void enableDefaultModules() {
        for (ModuleEntry iiIiiIii_Class92 : this.getModules()) {
            if (!iiIiiIii_Class92.isEnabledByDefault()) continue;
            iiIiiIii_Class92.enable();
        }
    }

    public final void registerModule(Module Module2) {
        this.I_field_a567c40b.put(Module2.getClass(), Module2);
        this.I_field_7865b31.add(Module2);
    }

    public final <T extends ModuleEntry> T getModuleByName(String string) {
        return (T)this.I_field_7865b31.stream().filter(iiIiiIii_Class92 -> iiIiiIii_Class92.getName().replace(" ", "").equalsIgnoreCase(string) || iiIiiIii_Class92.getName().equalsIgnoreCase(string)).findFirst().orElseThrow(() -> new iiIIiIiI_Class203(string));
    }

    public final <T extends ModuleEntry> T getModule(Class<T> clazz) {
        ModuleEntry entry = this.I_field_a567c40b.get(clazz);
        if (entry == null) {
            try {
                entry = clazz.getDeclaredConstructor().newInstance();
                this.I_field_a567c40b.put(clazz, entry);
            } catch (Throwable t) {
                return null;
            }
        }
        return (T) entry;
    }

    public final void snapshotModuleSettings() {
        for (ModuleEntry iiIiiIii_Class92 : this.getModules()) {
            if (!(iiIiiIii_Class92 instanceof Module)) continue;
            Module Module2 = (Module)iiIiiIii_Class92;
            Module2.III_method_fbb67e0c();
        }
    }

    @Generated
    public List<ModuleEntry> getModules() {
        return this.I_field_7865b31;
    }

    @Generated
    public static int I_method_7056a45f() {
        return I_field_49;
    }

    @Generated
    public IiIIIiII_Class69<ClientPlayerTickEvent> I_method_1bea6feb() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<HudRenderEvent> i_method_45e7000b() {
        return this.i_field_3d936f41;
    }
}

