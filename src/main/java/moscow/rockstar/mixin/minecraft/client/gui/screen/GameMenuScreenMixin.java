package moscow.rockstar.mixin.minecraft.client.gui.screen;

import javax.annotation.Nullable;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.realms.gui.screen.RealmsMainScreen;
import net.minecraft.text.Text;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;

@Mixin(value={GameMenuScreen.class})
public class GameMenuScreenMixin
extends Screen
implements iIIiIIiIi_Class294 {
    @Shadow
    @Nullable
    private ButtonWidget field_40792;

    protected GameMenuScreenMixin(Text text) {
        super(text);
    }

    @Inject(method={"initWidgets"}, at={@At(value="TAIL")})
    private void reconnectButton(CallbackInfo callbackInfo) {
        if (RockstarClient.I_field_502d1741.i_method_e8604970()) {
            return;
        }
        if (I_field_3a9bda27.isInSingleplayer()) {
            return;
        }
        if (this.field_40792 == null) {
            return;
        }
        Text text = Text.of((String)IiIiIIII_Class81.I_method_f25a980a("inventory.button.reconnect"));
        int n = 204;
        int n2 = this.field_40792.getX() + this.field_40792.getWidth() / 2 - n / 2;
        int n3 = this.field_40792.getY() + this.field_40792.getHeight() + (iIIIiiiII_Class285.I_method_dbbac60d("aresmine") ? 44 : 4);
        ButtonWidget buttonWidget2 = ButtonWidget.builder((Text)text, buttonWidget -> this.reconnect()).dimensions(n2, n3, n, 20).build();
        ((ScreenAccessor)((Object)this)).invokeAddDrawableChild(buttonWidget2);
    }

    @Unique
    private void reconnect() {
        ServerInfo serverInfo;
        if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) && GameMenuScreenMixin.I_field_3a9bda27.world.getDifficulty() == Difficulty.HARD) {
            try {
                GameMenuScreenMixin.I_field_3a9bda27.player.networkHandler.sendChatCommand(".rct");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if ((serverInfo = I_field_3a9bda27.getCurrentServerEntry()) == null) {
            return;
        }
        ServerAddress serverAddress = ServerAddress.parse((String)serverInfo.address);
        I_field_3a9bda27.getAbuseReportContext().tryShowDraftScreen(I_field_3a9bda27, (Screen)(Object)this, this::disconnect, true);
        new Thread(() -> {
            try {
                Thread.sleep(1200L);
            }
            catch (Exception exception) {
                // empty catch block
            }
            I_field_3a9bda27.execute(() -> ConnectScreen.connect((Screen)new MultiplayerScreen((Screen)new TitleScreen()), (MinecraftClient)I_field_3a9bda27, (ServerAddress)serverAddress, (ServerInfo)serverInfo, (boolean)false, null));
        }).start();
    }

    @Unique
    private void disconnect() {
        ServerInfo serverInfo = I_field_3a9bda27.getCurrentServerEntry();
        GameMenuScreenMixin.I_field_3a9bda27.world.disconnect();
        I_field_3a9bda27.disconnect();
        TitleScreen titleScreen = new TitleScreen();
        if (serverInfo != null && serverInfo.isRealm()) {
            I_field_3a9bda27.setScreen((Screen)new RealmsMainScreen((Screen)titleScreen));
        } else {
            I_field_3a9bda27.setScreen((Screen)new MultiplayerScreen((Screen)titleScreen));
        }
    }
}

