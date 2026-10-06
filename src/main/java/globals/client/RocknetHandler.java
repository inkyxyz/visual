package globals.client;

import globals.client.Activities;
import globals.client.Information;
import globals.client.WorldKey;
import globals.client.ui.RocknetMenu;
import globals.shared.proto.Packets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.minecraft.client.MinecraftClient;
import pyrock.events.game.GameTickEvent;
import pyrock.events.game.InternalAttackEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.player.InputEvent;
import pyrock.events.render.HudRenderEvent;
import rockstar.client.III;
import rockstar.client.GlobalsMenuModule;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiiIii_Class252;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;
import ua.mintantileak.profile.Profile;

public class RocknetHandler
implements iIIiIIiIi_Class294 {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private String lastVisibility = "all";
    private static volatile String lastJoinedServer;
    private static volatile long lastOnServerAt;
    private static final long REJOIN_GAP_MS = 60000L;
    private static volatile String lastWorldStamp;
    private final IiIIIiII_Class69<HudRenderEvent> handleGlobals = hudRenderEvent -> {
        RocknetMenu rocknetMenu = RockstarClient.getInstance().I_method_449a4cbc();
        if (rocknetMenu == null) {
            RockstarClient.getInstance().I_method_d0f1adb4(new RocknetMenu());
            return;
        }
        rocknetMenu.getMenuAnimation().I_method_edd6dd11(rocknetMenu.isClosing() ? 0.0f : 1.0f);
        if (!(RocknetHandler.I_field_3a9bda27.currentScreen instanceof RocknetMenu)) {
            RockstarClient.getInstance().getModuleManager().getModule(GlobalsMenuModule.class).disable();
        }
        if (rocknetMenu.getMenuAnimation().I_method_6ac4da6f() > 0.1f && !(RocknetHandler.I_field_3a9bda27.currentScreen instanceof RocknetMenu) && rocknetMenu.isClosing()) {
            III iII = III.I_method_5728d20f(hudRenderEvent.getContext(), -1, -1, MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false));
            rocknetMenu.render(iII);
        }
        this.checkVisibilityChange();
    };
    private final IiIIIiII_Class69<WorldChangeEvent> worldChange = worldChangeEvent -> {
        IiiiiiIii_Class252.I_method_f3f2fe5f();
        RocknetHandler.send();
    };
    private final IiIIIiII_Class69<GameTickEvent> worldStamp = gameTickEvent -> {
        if (RocknetHandler.I_field_3a9bda27.player == null || RocknetHandler.I_field_3a9bda27.player.age % 20 != 0) {
            return;
        }
        if (!I_field_3a9bda27.isInSingleplayer()) {
            lastOnServerAt = System.currentTimeMillis();
        }
        if (!WorldKey.local().stamp().equals(lastWorldStamp)) {
            RocknetHandler.send();
        }
    };
    private final IiIIIiII_Class69<InputEvent> onMove = inputEvent -> {
        if (Information.isFreezed()) {
            inputEvent.setSneak(false);
            inputEvent.setJump(false);
            inputEvent.setForward(0.0f);
            inputEvent.setStrafe(0.0f);
        }
    };
    private final IiIIIiII_Class69<InternalAttackEvent> onAttack = internalAttackEvent -> {
        if (Information.isFreezed()) {
            internalAttackEvent.cancel();
        }
    };

    public RocknetHandler() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    private String getVisibilityValue(GlobalsMenuModule iIIIIiiIi_Class14) {
        if (iIIIIiiIi_Class14 == null || iIIIIiiIi_Class14.I_method_d97b5ef5() == null) {
            return "all";
        }
        if (iIIIIiiIi_Class14.I_method_d97b5ef5().I_method_ce989e26(iIIIIiiIi_Class14.I_method_681f2870())) {
            return "all";
        }
        if (iIIIIiiIi_Class14.I_method_d97b5ef5().I_method_ce989e26(iIIIIiiIi_Class14.i_method_6e272450())) {
            return "friends";
        }
        if (iIIIIiiIi_Class14.I_method_d97b5ef5().I_method_ce989e26(iIIIIiiIi_Class14.II_method_cf361cf3())) {
            return "none";
        }
        return "all";
    }

    private void checkVisibilityChange() {
        GlobalsMenuModule iIIIIiiIi_Class14 = RockstarClient.getInstance().getModuleManager().getModule(GlobalsMenuModule.class);
        if (iIIIIiiIi_Class14 == null) {
            return;
        }
        String string = this.getVisibilityValue(iIIIIiiIi_Class14);
        if (!string.equals(this.lastVisibility)) {
            this.lastVisibility = string;
            RockstarClient.getInstance().I_method_cd3d46d0().updateVisibility(string);
        }
    }

    public static void send() {
        executor.submit(() -> {
            String string;
            WorldKey worldKey = WorldKey.local();
            lastWorldStamp = worldKey.stamp();
            GlobalsMenuModule iIIIIiiIi_Class14 = RockstarClient.getInstance().getModuleManager().getModule(GlobalsMenuModule.class);
            String string2 = "all";
            if (iIIIIiiIi_Class14 != null) {
                if (iIIIIiiIi_Class14.I_method_d97b5ef5().I_method_ce989e26(iIIIIiiIi_Class14.I_method_681f2870())) {
                    string2 = "all";
                } else if (iIIIIiiIi_Class14.I_method_d97b5ef5().I_method_ce989e26(iIIIIiiIi_Class14.i_method_6e272450())) {
                    string2 = "friends";
                } else if (iIIIIiiIi_Class14.I_method_d97b5ef5().I_method_ce989e26(iIIIIiiIi_Class14.II_method_cf361cf3())) {
                    string2 = "none";
                }
            }
            RockstarClient.getInstance().I_method_cd3d46d0().info(I_field_3a9bda27.getSession().getUsername(), String.valueOf(worldKey.anarchy()), worldKey.server(), iIIIiiiII_Class285.i_method_be2f04a1(), worldKey.world(), string2, Profile.getUsername());
            String string3 = iIIIiiiII_Class285.I_method_2b105481();
            if (!I_field_3a9bda27.isInSingleplayer() && string3 != null && !string3.equals("single")) {
                boolean bl;
                string = iIIIiiiII_Class285.I_method_da38608b(false);
                boolean bl2 = bl = System.currentTimeMillis() - lastOnServerAt > 60000L;
                if (!(string == null || string.isBlank() || !bl && string.equals(lastJoinedServer))) {
                    lastJoinedServer = string;
                    lastOnServerAt = System.currentTimeMillis();
                    RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_3422a40(string, iIIIiiiII_Class285.i_method_be2f04a1(), string3, I_field_3a9bda27.getSession().getUsername(), "Rockstar".toLowerCase()));
                }
            } else {
                lastJoinedServer = null;
            }
            string = "main_menu";
            if (RocknetHandler.I_field_3a9bda27.world != null) {
                string = I_field_3a9bda27.isInSingleplayer() ? "singleplayer" : Activities.multiplayer(iIIIiiiII_Class285.I_method_da38608b(false));
            }
            RockstarClient.getInstance().I_method_cd3d46d0().update(string);
        });
    }

    static {
        lastWorldStamp = "";
    }
}

