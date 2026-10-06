package moscow.rockstar.mixin.minecraft.client.gui.overlay;

import globals.client.Information;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.NameProtectModule;
import rockstar.client.BeautifullyModule;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIiiIIiiI_Class359;
import rockstar.client.iIiiIIiii_Class360;

@Mixin(value={PlayerListHud.class})
public class PlayerListHudMixin {
    @Unique
    private static final Map<String, String> tabAvatarOwners = new HashMap<String, String>();
    @Unique
    private static final Set<String> tabPlayerNames = new HashSet<String>();
    @Unique
    private static int entryCount;
    @Unique
    private static String lastMatchedPlayer;
    @Unique
    private static int lastMatchedX;
    @Unique
    private static int lastMatchedY;

    @Inject(method={"collectPlayerEntries"}, at={@At(value="RETURN")}, cancellable=true)
    private void filterStreamerTabEntries(CallbackInfoReturnable<List<PlayerListEntry>> callbackInfoReturnable) {
        entryCount = ((List)callbackInfoReturnable.getReturnValue()).size();
        NameProtectModule iIIIiIiII_Class21 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
        if (iIIIiIiII_Class21 == null || !iIIIiIiII_Class21.isEnabled() || !iIIIiIiII_Class21.i_method_94157695().i_method_9b12da03()) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.getSession() == null) {
            return;
        }
        ArrayList<PlayerListEntry> arrayList = new ArrayList<PlayerListEntry>();
        for (PlayerListEntry playerListEntry : (Iterable<PlayerListEntry>)(Iterable<?>)(List)callbackInfoReturnable.getReturnValue()) {
            String string = playerListEntry.getProfile().getName();
            if (!string.equalsIgnoreCase(minecraftClient.getSession().getUsername()) && this.shouldHideStreamerTabEntry(playerListEntry)) continue;
            arrayList.add(playerListEntry);
        }
        callbackInfoReturnable.setReturnValue(arrayList);
        entryCount = arrayList.size();
    }

    @ModifyConstant(method={"render"}, constant={@Constant(intValue=20)})
    private int rockstar$rowsPerColumn(int n) {
        int n2 = BeautifullyModule.II_method_bb574935();
        if (n2 <= 0 || entryCount <= 0) {
            return n;
        }
        return Math.max(1, MathHelper.ceil((float)((float)entryCount / (float)n2)));
    }

    @Inject(method={"getPlayerName"}, at={@At(value="RETURN")}, cancellable=true)
    private void cleanStreamerTabName(PlayerListEntry playerListEntry, CallbackInfoReturnable<Text> callbackInfoReturnable) {
        NameProtectModule iIIIiIiII_Class21 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
        if (iIIIiIiII_Class21 == null || !iIIIiIiII_Class21.isEnabled() || !iIIIiIiII_Class21.i_method_94157695().i_method_9b12da03()) {
            return;
        }
        callbackInfoReturnable.setReturnValue(Text.literal((String)iIIIiIiII_Class21.II_method_6ed9f394(playerListEntry.getProfile().getName())));
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void onRenderHead(DrawContext drawContext, int n, Scoreboard scoreboard, ScoreboardObjective scoreboardObjective, CallbackInfo callbackInfo) {
        tabAvatarOwners.clear();
        tabPlayerNames.clear();
        lastMatchedPlayer = null;
        for (Packets.Nested1_1da0dac9 object : Information.getVisiblePlayers()) {
            if (object.gameInfo() == null || object.gameInfo().nickname() == null) continue;
            tabAvatarOwners.put(object.gameInfo().nickname(), object.username());
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (Information.getUser() != null && minecraftClient.getSession() != null) {
            tabAvatarOwners.put(minecraftClient.getSession().getUsername(), Information.getUser().username());
        }
        if (minecraftClient.player != null && minecraftClient.player.networkHandler != null) {
            for (PlayerListEntry playerListEntry : minecraftClient.player.networkHandler.getPlayerList()) {
                tabPlayerNames.add(playerListEntry.getProfile().getName());
            }
        }
    }

    @ModifyArg(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I"), index=2)
    private int modifyNameX(TextRenderer textRenderer, Text text, int n, int n2, int n3) {
        String string = text.getString();
        String string2 = this.findVisiblePlayerInText(string);
        if (string2 != null) {
            lastMatchedPlayer = string2;
            lastMatchedX = n;
            lastMatchedY = n2;
            return n + (!iIIIiiiII_Class285.Ii_method_b349c526() ? 10 : 0);
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I", shift=At.Shift.AFTER)})
    private void afterDrawName(DrawContext drawContext, int n, Scoreboard scoreboard, ScoreboardObjective scoreboardObjective, CallbackInfo callbackInfo) {
        if (lastMatchedPlayer == null) {
            return;
        }
        String string = tabAvatarOwners.get(lastMatchedPlayer);
        if (string == null) {
            return;
        }
        iIiiIIiiI_Class359.II_method_5031d522();
        try {
            iIiiIIiii_Class360.I_method_1c6a5031(drawContext.getMatrices(), Information.getAvatar(string), lastMatchedX, lastMatchedY, 8.0f, 8.0f, ColorRGBA.WHITE);
        }
        finally {
            iIiiIIiiI_Class359.Ii_method_50406102();
        }
        lastMatchedPlayer = null;
    }

    @Unique
    private String findVisiblePlayerInText(String string) {
        for (String string2 : tabAvatarOwners.keySet()) {
            if (!string.contains(string2) || !tabPlayerNames.contains(string2)) continue;
            return string2;
        }
        return null;
    }

    @Unique
    private boolean shouldHideStreamerTabEntry(PlayerListEntry playerListEntry) {
        String string = playerListEntry.getProfile().getName();
        int n = Objects.hash(string.toLowerCase(Locale.ROOT), playerListEntry.getProfile().getId(), iIIIiiiII_Class285.I_method_2b105481());
        return Math.floorMod(n, 4) == 0;
    }
}

