package rockstar.client;

import java.util.Locale;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.ModeSetting;
import rockstar.client.TextSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIiIi_Class262;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.iiiIIII_Class113;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Join", category=ModuleCategory.OTHER, III_method_a89e5834="modules.descriptions.auto_join")
public class AutoJoinModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private TextSetting I_field_731802cc;
    private static final long I_field_4a = 300L;
    private static final long i_field_4a = 1500L;
    private static final long II_field_4a = 2500L;
    private static final long Ii_field_4a = 8000L;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
    private final iiIiIIiii_Class424 II_field_991c1e8c = new iiIiIIiii_Class424();
    private final iiIiIIiii_Class424 Ii_field_991c1e8c = new iiIiIIiii_Class424();
    private long iI_field_4a;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> this.Iii_method_75b91e7f();
    private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41 = receivePacketEvent -> {
        Object object = receivePacketEvent.getPacket();
        if (!(object instanceof GameMessageS2CPacket)) {
            return;
        }
        GameMessageS2CPacket gameMessageS2CPacket = (GameMessageS2CPacket)object;
        if (!(iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c) || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c))) {
            return;
        }
        object = gameMessageS2CPacket.content().getString().toLowerCase(Locale.ROOT);
        if (this.I_method_97ab422d((String)object)) {
            this.i_field_5a = false;
            if (this.I_field_500d0627.isSelected()) {
                this.I_method_eae7f885(2500L);
            } else {
                this.i_field_991c1e8c.I_method_23e11e3f();
            }
            if (!this.II_field_5a) {
                this.II_field_5a = true;
                RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.II_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("auto_join.retry"), IiIiIIII_Class81.I_method_f25a980a("auto_join.retry.desc"));
            }
            return;
        }
        if (this.i_field_500d0627.isSelected() && (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) ? ((String)object).contains(IiIiIIII_Class81.I_method_f25a980a("auto_join.already_connected_ft")) : ((String)object).contains(IiIiIIII_Class81.I_method_f25a980a("auto_join.already_connected")))) {
            this.disable();
        }
    };
    private final IiIIIiII_Class69<WorldChangeEvent> II_field_3d936f41 = worldChangeEvent -> {
        if (this.I_field_500d0627.isSelected()) {
            this.I_method_eae7f885(1500L);
            return;
        }
        if (this.i_field_5a) {
            this.disable();
        }
    };

    public AutoJoinModule() {
        this.IiI_method_75aa929f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_75aa929f() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_join.mode");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_join.mode.duels_st").select();
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_join.mode.grief");
        this.I_field_731802cc = new TextSetting((IIiiiIIiI_Class115)this, "modules.settings.auto_join.anarchy_number", this.I_field_500d0627::isSelected).I_method_104de33f("306").I_method_ec08f9eb(true);
    }

    @Compile(obfuscation=1)
    private void Iii_method_75b91e7f() {
        Object object;
        Object object2;
        if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c) && this.I_field_500d0627.isSelected()) {
            iIIiiIiII_Class309<iIIiiiIii_Class316> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695();
            if (this.iI_field_4a > 0L) {
                if (!this.Ii_field_991c1e8c.I_method_58432069(this.iI_field_4a)) {
                    return;
                }
                this.iI_field_4a = 0L;
            }
            if (iIIiiIiII_Class3092.I_method_5d34dd7d(Items.DIAMOND_SWORD) != null || iIIIiiiII_Class285.I_method_f5437e03()) {
                this.iII_method_aa82b65f();
                return;
            }
            if (!this.I_field_991c1e8c.I_method_58432069(300L)) {
                return;
            }
            object2 = AutoJoinModule.I_field_3a9bda27.player.currentScreenHandler;
            if (object2 instanceof GenericContainerScreenHandler) {
                object = (GenericContainerScreenHandler)object2;
                if (AutoJoinModule.I_field_3a9bda27.currentScreen != null && AutoJoinModule.I_field_3a9bda27.currentScreen.getTitle().getString().contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
                    AutoJoinModule.I_field_3a9bda27.interactionManager.clickSlot(((GenericContainerScreenHandler)object).syncId, 13, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)AutoJoinModule.I_field_3a9bda27.player);
                    this.i_field_5a = true;
                    this.I_method_eae7f885(8000L);
                    this.I_field_991c1e8c.I_method_23e11e3f();
                    return;
                }
            }
            if ((object = iIIiiIiII_Class3092.I_method_5d34dd7d(Items.COMPASS)) != null) {
                AutoJoinModule.I_field_3a9bda27.player.getInventory().selectedSlot = ((iIIiiiIii_Class316)object).II_method_b9cf08f5();
                AutoJoinModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(AutoJoinModule.I_field_3a9bda27.world, n -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, n, AutoJoinModule.I_field_3a9bda27.player.getYaw(), AutoJoinModule.I_field_3a9bda27.player.getPitch()));
                this.I_field_991c1e8c.I_method_23e11e3f();
            }
        }
        if (this.i_field_500d0627.isSelected()) {
            int n2 = this.II_method_eaf67915();
            if (n2 <= 0) {
                this.disable();
                return;
            }
            if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)) {
                if (iIIIiiiII_Class285.I_method_f5437df2() != n2 || !this.i_field_5a) {
                    if (!this.i_field_991c1e8c.I_method_58432069(500L)) {
                        return;
                    }
                    AutoJoinModule.I_field_3a9bda27.player.networkHandler.sendChatCommand("an" + this.I_field_731802cc.II_method_da016c1e());
                    this.i_field_5a = true;
                    this.i_field_991c1e8c.I_method_23e11e3f();
                } else {
                    this.disable();
                }
            }
            if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c)) {
                if (iIIIiiiII_Class285.Ii_field_49 == n2 && this.i_field_5a) {
                    this.disable();
                    return;
                }
                if (!this.II_field_991c1e8c.I_method_58432069(300L)) {
                    return;
                }
                if (!this.I_field_5a) {
                    if (iIIIIIiIi_Class262.I_method_1a228de3()) {
                        this.I_field_5a = true;
                        this.II_field_991c1e8c.I_method_23e11e3f();
                    }
                    return;
                }
                object2 = AutoJoinModule.I_field_3a9bda27.player.currentScreenHandler;
                if (object2 instanceof GenericContainerScreenHandler) {
                    object = (GenericContainerScreenHandler)object2;
                    if (AutoJoinModule.I_field_3a9bda27.currentScreen != null) {
                        object2 = AutoJoinModule.I_field_3a9bda27.currentScreen.getTitle().getString();
                        if (iIIIIIiIi_Class262.I_method_17a99ded((String)object2)) {
                            int n3 = iIIIIIiIi_Class262.I_method_d70844be((GenericContainerScreenHandler)object, true);
                            if (n3 != -1) {
                                iIIIIIiIi_Class262.I_method_d70804fa((GenericContainerScreenHandler)object, n3);
                                this.II_field_991c1e8c.I_method_23e11e3f();
                            }
                            return;
                        }
                        if (iIIIIIiIi_Class262.I_method_dd8ad20f((String)object2, true)) {
                            iIIIIIiIi_Class262.Nested1_86f734a0 nested1_86f734a0 = iIIIIIiIi_Class262.I_method_3309b8b5((GenericContainerScreenHandler)object, (String)object2, n2, true);
                            if (nested1_86f734a0 == iIIIIIiIi_Class262.Nested1_86f734a0.II_field_9ba735e7) {
                                this.II_field_991c1e8c.I_method_23e11e3f();
                                this.i_field_5a = true;
                            } else if (nested1_86f734a0 == iIIIIIiIi_Class262.Nested1_86f734a0.i_field_9ba735e7) {
                                this.II_field_991c1e8c.I_method_23e11e3f();
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean I_method_97ab422d(String string) {
        return string.contains("\u0441\u0435\u0440\u0432\u0435\u0440 \u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d") || string.contains("\u0441\u0435\u0440\u0432\u0435\u0440 \u043f\u0435\u0440\u0435\u043f\u043e\u043b\u043d\u0435\u043d") || string.contains("\u043d\u0435\u0442 \u0441\u0432\u043e\u0431\u043e\u0434\u043d\u044b\u0445 \u0441\u043b\u043e\u0442\u043e\u0432") || string.contains("\u043a\u0438\u043a\u043d\u0443\u0442\u044b \u043f\u0440\u0438 \u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0438") || string.contains("\u0441\u0435\u0440\u0432\u0435\u0440 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d");
    }

    private void I_method_eae7f885(long l) {
        this.iI_field_4a = l;
        this.Ii_field_991c1e8c.I_method_23e11e3f();
    }

    private void iII_method_aa82b65f() {
        RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.I_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("auto_join.success"), IiIiIIII_Class81.I_method_f25a980a("auto_join.success.desc"));
        this.disable();
    }

    private int II_method_eaf67915() {
        try {
            return Integer.parseInt(this.I_field_731802cc.II_method_da016c1e());
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    @Override
    public void onEnable() {
        this.I_field_5a = false;
        this.i_field_5a = false;
        this.II_field_5a = false;
        this.iI_field_4a = 0L;
        this.I_field_991c1e8c.I_method_23e11e3f();
        this.i_field_991c1e8c.I_method_23e11e3f();
        this.II_field_991c1e8c.I_method_23e11e3f();
        this.Ii_field_991c1e8c.I_method_23e11e3f();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.I_field_5a = false;
        this.i_field_5a = false;
        this.II_field_5a = false;
        this.iI_field_4a = 0L;
        this.II_field_991c1e8c.I_method_23e11e3f();
        super.onDisable();
    }
}

