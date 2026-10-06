package moscow.rockstar.mixin.minecraft.client.gui.screen.multiplayer;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.client.network.ServerInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiiIiI_Class283;

@Mixin(value={MultiplayerServerListWidget.ServerEntry.class})
public abstract class MultiplayerServerListWidgetServerEntryMixin
extends MultiplayerServerListWidget.Entry {
    @Shadow
    @Final
    private ServerInfo field_19120;

    protected MultiplayerServerListWidgetServerEntryMixin() {
    }

    @Inject(method={"swapEntries"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$preventPinnedMove(int n, int n2, CallbackInfo callbackInfo) {
        if (iIIIiiIiI_Class283.I_method_8f9b3f84(this.field_19120)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void rockstar$drawMatteCardBackground(DrawContext drawContext, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta, CallbackInfo callbackInfo) {
        CustomDrawContext custom = (drawContext instanceof CustomDrawContext cdc) ? cdc : new CustomDrawContext(drawContext);
        boolean isPinned = iIIIiiIiI_Class283.I_method_8f9b3f84(this.field_19120);
        ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();

        float cx = x - 2.0F;
        float cy = y - 1.0F;
        float cw = entryWidth + 4.0F;
        float ch = entryHeight + 2.0F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(6.0F);

        // Matte card background
        ColorRGBA bg = hovered ?
            new ColorRGBA(22.0F, 26.0F, 38.0F, 195.0F) :
            new ColorRGBA(13.0F, 16.0F, 24.0F, 145.0F);
        custom.drawRoundedRect(cx, cy, cw, ch, rad, bg);

        // Thin border with accent highlight on hover or pinned
        ColorRGBA border = isPinned ?
            themeAccent.withAlpha(hovered ? 200.0F : 140.0F) :
            (hovered ? themeAccent.withAlpha(120.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
        custom.drawRoundedBorder(cx, cy, cw, ch, 1.0F, rad, border);

        if (isPinned) {
            // Subtle glowing pinned badge
            float badgeW = 44.0F;
            float badgeH = 10.0F;
            float bx = cx + cw - badgeW - 6.0F;
            float by = cy + 4.0F;
            IIiii_Class8 badgeRad = IIiii_Class8.I_method_893b2757(3.0F);
            custom.drawRoundedRect(bx, by, badgeW, badgeH, badgeRad, themeAccent.withAlpha(50.0F));
            custom.drawRoundedBorder(bx, by, badgeW, badgeH, 0.8F, badgeRad, themeAccent.withAlpha(160.0F));

            try {
                if (IIiIiI_Class11.i_field_857c0621 != null) {
                    IIiIIi_Class10 font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F);
                    custom.drawText(font, "★ PINNED", bx + 3.5F, by + 2.0F, ColorRGBA.WHITE);
                }
            } catch (Throwable ignored) {
            }
        }
    }
}
