package moscow.rockstar.mixin.minecraft.client.gui.screen.multiplayer;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.option.ServerList;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiiIiI_Class283;

@Mixin(value={MultiplayerScreen.class})
public abstract class MultiplayerScreenMixin
extends Screen {
    @Shadow
    protected MultiplayerServerListWidget field_3043;
    @Shadow
    private ButtonWidget field_3041;
    @Shadow
    private ButtonWidget field_3047;

    @Shadow
    public abstract ServerList method_2529();

    @Shadow
    protected abstract void method_20121();

    @Unique private float rockstar$carouselScroll = 0.0F;
    @Unique private int rockstar$selectedIndex = 0;
    @Unique private long rockstar$lastFrameTime = 0L;
    @Unique private long rockstar$lastClickTime = 0L;
    @Unique private int rockstar$lastClickedIndex = -1;

    protected MultiplayerScreenMixin(Text text) {
        super(text);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void rockstar$syncPinnedServer(CallbackInfo callbackInfo) {
        if (this.field_3043 != null) {
            this.field_3043.visible = false;
        }

        if (this.client == null || RockstarClient.I_field_502d1741.i_method_e8604970()) {
            return;
        }
        iIIIiiIiI_Class283.I_method_35a51568(this.client, this.method_2529(), this::rockstar$reloadServerListWidget);

        java.util.List<net.minecraft.client.gui.Element> children = ((moscow.rockstar.mixin.accessors.ScreenAccessor)this).getChildren();
        java.util.List<net.minecraft.client.gui.widget.ClickableWidget> bottomButtons = new java.util.ArrayList<>();
        for (net.minecraft.client.gui.Element elem : children) {
            if (elem instanceof net.minecraft.client.gui.widget.ClickableWidget widget && widget.getY() >= this.height - 65) {
                bottomButtons.add(widget);
            }
        }
        if (bottomButtons.size() >= 7) {
            bottomButtons.sort((a, b) -> {
                if (Math.abs(a.getY() - b.getY()) <= 6) {
                    return Integer.compare(a.getX(), b.getX());
                }
                return Integer.compare(a.getY(), b.getY());
            });
            int totalW = Math.min(this.width - 32, 540);
            int startX = (this.width - totalW) / 2;
            int gap = 8;
            int h = 24;

            int row1W = (totalW - gap * 2) / 3;
            int row1Y = this.height - 56;
            for (int i = 0; i < 3 && i < bottomButtons.size(); i++) {
                net.minecraft.client.gui.widget.ClickableWidget b = bottomButtons.get(i);
                b.setWidth(row1W);
                b.setHeight(h);
                b.setX(startX + i * (row1W + gap));
                b.setY(row1Y);
            }

            int row2W = (totalW - gap * 3) / 4;
            int row2Y = this.height - 28;
            for (int i = 3; i < 7 && i < bottomButtons.size(); i++) {
                net.minecraft.client.gui.widget.ClickableWidget b = bottomButtons.get(i);
                b.setWidth(row2W);
                b.setHeight(h);
                b.setX(startX + (i - 3) * (row2W + gap));
                b.setY(row2Y);
            }
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void rockstar$renderPS5Carousel(net.minecraft.client.gui.DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        rockstar.client.III custom = rockstar.client.III.I_method_5728d20f(drawContext, mouseX, mouseY, delta);
        long now = System.currentTimeMillis();
        if (this.rockstar$lastFrameTime == 0L) this.rockstar$lastFrameTime = now;
        float dt = Math.min(0.05F, (float)(now - this.rockstar$lastFrameTime) / 1000.0F);
        this.rockstar$lastFrameTime = now;

        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;

        if (count > 0) {
            this.rockstar$selectedIndex = Math.max(0, Math.min(count - 1, this.rockstar$selectedIndex));
            this.rockstar$carouselScroll += ((float)this.rockstar$selectedIndex - this.rockstar$carouselScroll) * 0.18F;
        }

        pyrock.utility.render.ColorRGBA theme = rockstar.client.IiiiiIIIi_Class242.I_method_7df8e08e();
        rockstar.client.IIiIIi_Class10 headerFont = rockstar.client.IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F);
        rockstar.client.IIiIIi_Class10 titleFont = rockstar.client.IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.5F);
        rockstar.client.IIiIIi_Class10 subFont = rockstar.client.IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5F);
        rockstar.client.IIiIIi_Class10 badgeFont = rockstar.client.IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);

        // Minimalist Top Bar (PlayStation style header)
        float topY = 16.0F;
        float leftX = 24.0F;
        custom.drawRoundedRect(leftX, topY, 4.0F, 14.0F, rockstar.client.IIiii_Class8.I_method_893b2757(2.0F), theme);
        custom.drawText(headerFont, "СЕТЕВАЯ ИГРА", leftX + 10.0F, topY + 1.0F, pyrock.utility.render.ColorRGBA.WHITE);

        String countPill = count + " СЕРВЕРОВ • PLAYSTATION UI";
        float cpW = subFont.I_method_2c375926(countPill);
        float cpX = leftX + 10.0F + headerFont.I_method_2c375926("СЕТЕВАЯ ИГРА") + 12.0F;
        custom.drawRoundedRect(cpX, topY + 1.0F, cpW + 10.0F, 12.0F, rockstar.client.IIiii_Class8.I_method_893b2757(6.0F), theme.withAlpha(45.0F));
        custom.drawRoundedBorder(cpX, topY + 1.0F, cpW + 10.0F, 12.0F, 0.8F, rockstar.client.IIiii_Class8.I_method_893b2757(6.0F), theme.withAlpha(140.0F));
        custom.drawText(subFont, countPill, cpX + 5.0F, topY + 3.5F, theme);

        // Center Stage Carousel
        float carouselCY = (this.height - 75.0F) / 2.0F + 8.0F;
        float cardW = 148.0F;
        float cardH = 188.0F;
        float spacing = 168.0F;
        float cx = this.width / 2.0F;

        if (count == 0) {
            float emptyW = 280.0F;
            float emptyH = 120.0F;
            float emptyX = cx - emptyW / 2.0F;
            float emptyY = carouselCY - emptyH / 2.0F;
            custom.drawBlurredRect(emptyX, emptyY, emptyW, emptyH, 20.0F, 4.0F, rockstar.client.IIiii_Class8.I_method_893b2757(12.0F), theme.withAlpha(60.0F));
            custom.drawRoundedRect(emptyX, emptyY, emptyW, emptyH, rockstar.client.IIiii_Class8.I_method_893b2757(12.0F), new pyrock.utility.render.ColorRGBA(12.0F, 14.0F, 22.0F, 220.0F));
            custom.drawRoundedBorder(emptyX, emptyY, emptyW, emptyH, 1.0F, rockstar.client.IIiii_Class8.I_method_893b2757(12.0F), theme.withAlpha(140.0F));
            String emptyTitle = "Нет добавленных серверов";
            float etW = titleFont.I_method_2c375926(emptyTitle);
            custom.drawText(titleFont, emptyTitle, cx - etW / 2.0F, carouselCY - 16.0F, pyrock.utility.render.ColorRGBA.WHITE);
            String emptySub = "Используйте кнопку [Добавить] внизу чтобы добавить сервер";
            float esW = subFont.I_method_2c375926(emptySub);
            custom.drawText(subFont, emptySub, cx - esW / 2.0F, carouselCY + 6.0F, new pyrock.utility.render.ColorRGBA(160.0F, 170.0F, 190.0F, 200.0F));
            return;
        }

        // Render Carousel Cards
        for (int i = 0; i < count; i++) {
            float rel = (float) i - this.rockstar$carouselScroll;
            if (Math.abs(rel) > 2.8F) continue;

            ServerInfo info = serverList.get(i);
            float cardCX = cx + rel * spacing;
            float distFromCenter = Math.abs(rel);
            boolean isCenter = (i == this.rockstar$selectedIndex);
            float cardScale = isCenter ? 1.06F : Math.max(0.90F, 1.0F - distFromCenter * 0.08F);
            float alpha = Math.max(0.40F, 1.0F - distFromCenter * 0.30F);

            float curW = cardW * cardScale;
            float curH = cardH * cardScale;
            float cardX = cardCX - curW / 2.0F;
            float cardY = carouselCY - curH / 2.0F;

            rockstar.client.IIiii_Class8 radCard = rockstar.client.IIiii_Class8.I_method_893b2757(10.0F);

            custom.drawShadow(cardX, cardY, curW, curH, 18.0F, radCard, pyrock.utility.render.ColorRGBA.BLACK.withAlpha(140.0F * alpha));
            if (isCenter) {
                custom.drawBlurredRect(cardX, cardY, curW, curH, 20.0F, 4.0F, radCard, theme.withAlpha(120.0F));
            }
            pyrock.utility.render.ColorRGBA cardBg = isCenter
                ? new pyrock.utility.render.ColorRGBA(14.0F, 18.0F, 30.0F, 235.0F)
                : new pyrock.utility.render.ColorRGBA(10.0F, 12.0F, 20.0F, 200.0F * alpha);
            custom.drawRoundedRect(cardX, cardY, curW, curH, radCard, cardBg);

            pyrock.utility.render.ColorRGBA cardBorder = isCenter
                ? theme.withAlpha(240.0F)
                : new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F * alpha);
            custom.drawRoundedBorder(cardX, cardY, curW, curH, isCenter ? 1.5F : 0.8F, radCard, cardBorder);

            // Server Index Badge
            String idxBadge = "#" + (i + 1);
            custom.drawRoundedRect(cardX + 8.0F, cardY + 8.0F, 22.0F, 11.0F, rockstar.client.IIiii_Class8.I_method_893b2757(4.0F), theme.withAlpha(isCenter ? 180.0F : 70.0F * alpha));
            custom.drawText(badgeFont, idxBadge, cardX + 11.0F, cardY + 9.5F, pyrock.utility.render.ColorRGBA.WHITE.withAlpha(255.0F * alpha));

            // Server Icon Pod (Center top)
            float iconPodSize = 42.0F;
            float iconPodX = cardCX - iconPodSize / 2.0F;
            float iconPodY = cardY + 24.0F;
            rockstar.client.IIiii_Class8 radIcon = rockstar.client.IIiii_Class8.I_method_893b2757(8.0F);
            custom.drawRoundedRect(iconPodX, iconPodY, iconPodSize, iconPodSize, radIcon, theme.withAlpha(35.0F * alpha));
            custom.drawRoundedBorder(iconPodX, iconPodY, iconPodSize, iconPodSize, 0.8F, radIcon, theme.withAlpha(120.0F * alpha));
            custom.drawIcon("planet", iconPodX + 11.0F, iconPodY + 11.0F, 20.0F, isCenter ? theme : pyrock.utility.render.ColorRGBA.WHITE.withAlpha(200.0F * alpha));

            // Server Name
            String sName = info.name != null ? info.name : "Minecraft Server";
            float snW = titleFont.I_method_2c375926(sName);
            if (snW > curW - 16.0F) {
                while (sName.length() > 3 && titleFont.I_method_2c375926(sName + "...") > curW - 16.0F) {
                    sName = sName.substring(0, sName.length() - 1);
                }
                sName = sName + "...";
                snW = titleFont.I_method_2c375926(sName);
            }
            custom.drawText(titleFont, sName, cardCX - snW / 2.0F, iconPodY + iconPodSize + 10.0F, pyrock.utility.render.ColorRGBA.WHITE.withAlpha(255.0F * alpha));

            // Server Address Pill
            String sAddr = info.address != null ? info.address : "";
            float saW = subFont.I_method_2c375926(sAddr);
            if (saW > curW - 20.0F) {
                while (sAddr.length() > 3 && subFont.I_method_2c375926(sAddr + "...") > curW - 20.0F) {
                    sAddr = sAddr.substring(0, sAddr.length() - 1);
                }
                sAddr = sAddr + "...";
                saW = subFont.I_method_2c375926(sAddr);
            }
            float pillW = saW + 12.0F;
            float pillH = 12.0F;
            custom.drawRoundedRect(cardCX - pillW / 2.0F, iconPodY + iconPodSize + 25.0F, pillW, pillH, rockstar.client.IIiii_Class8.I_method_893b2757(6.0F), new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 15.0F * alpha));
            custom.drawText(subFont, sAddr, cardCX - saW / 2.0F, iconPodY + iconPodSize + 27.5F, new pyrock.utility.render.ColorRGBA(200.0F, 210.0F, 230.0F, 210.0F * alpha));

            // Bottom Badges: Ping
            float badgeY = cardY + curH - 22.0F;
            String pingTxt = info.ping > 0 ? (info.ping + " ms") : "Пинг...";
            float pW = subFont.I_method_2c375926(pingTxt);
            pyrock.utility.render.ColorRGBA pingCol = info.ping <= 80 ? new pyrock.utility.render.ColorRGBA(52.0F, 199.0F, 89.0F, 255.0F * alpha) : (info.ping <= 180 ? new pyrock.utility.render.ColorRGBA(255.0F, 204.0F, 0.0F, 255.0F * alpha) : new pyrock.utility.render.ColorRGBA(255.0F, 69.0F, 58.0F, 255.0F * alpha));

            custom.drawRoundedRect(cardX + 8.0F, badgeY, pW + 12.0F, 14.0F, rockstar.client.IIiii_Class8.I_method_893b2757(7.0F), pingCol.withAlpha(35.0F * alpha));
            custom.drawRoundedBorder(cardX + 8.0F, badgeY, pW + 12.0F, 14.0F, 0.7F, rockstar.client.IIiii_Class8.I_method_893b2757(7.0F), pingCol.withAlpha(160.0F * alpha));
            custom.drawText(subFont, pingTxt, cardX + 14.0F, badgeY + 3.5F, pingCol);

            if (isCenter) {
                String joinPrompt = "[ Enter для входа ]";
                float jw = subFont.I_method_2c375926(joinPrompt);
                custom.drawText(subFont, joinPrompt, cardCX - jw / 2.0F, cardY + curH + 6.0F, theme);
            }
        }
    }

    @Inject(method={"mouseScrolled"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$onMouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<Boolean> cir) {
        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;
        if (count > 0) {
            if (verticalAmount > 0) {
                this.rockstar$selectedIndex = Math.max(0, this.rockstar$selectedIndex - 1);
                this.rockstar$syncSelectedToVanilla();
                cir.setReturnValue(true);
            } else if (verticalAmount < 0) {
                this.rockstar$selectedIndex = Math.min(count - 1, this.rockstar$selectedIndex + 1);
                this.rockstar$syncSelectedToVanilla();
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(method={"keyPressed"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$onKeyPressed(int keyCode, int scanCode, int modifiers, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<Boolean> cir) {
        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;
        if (count > 0) {
            if (keyCode == GLFW.GLFW_KEY_LEFT || keyCode == GLFW.GLFW_KEY_A) {
                this.rockstar$selectedIndex = Math.max(0, this.rockstar$selectedIndex - 1);
                this.rockstar$syncSelectedToVanilla();
                cir.setReturnValue(true);
            } else if (keyCode == GLFW.GLFW_KEY_RIGHT || keyCode == GLFW.GLFW_KEY_D) {
                this.rockstar$selectedIndex = Math.min(count - 1, this.rockstar$selectedIndex + 1);
                this.rockstar$syncSelectedToVanilla();
                cir.setReturnValue(true);
            } else if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                if (this.field_3041 != null && this.field_3041.active) {
                    this.field_3041.onPress();
                    cir.setReturnValue(true);
                }
            }
        }
    }

    @Inject(method={"mouseClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$onMouseClicked(double mouseX, double mouseY, int button, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<Boolean> cir) {
        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;
        float carouselCY = (this.height - 75.0F) / 2.0F + 8.0F;
        float cardW = 148.0F;
        float cardH = 188.0F;
        float spacing = 168.0F;
        float cx = this.width / 2.0F;

        for (int i = 0; i < count; i++) {
            float rel = (float) i - this.rockstar$carouselScroll;
            if (Math.abs(rel) > 2.8F) continue;
            float cardCX = cx + rel * spacing;
            float curW = cardW;
            float curH = cardH;
            float cardX = cardCX - curW / 2.0F;
            float cardY = carouselCY - curH / 2.0F;

            if (mouseX >= cardX && mouseX <= cardX + curW && mouseY >= cardY && mouseY <= cardY + curH) {
                long now = System.currentTimeMillis();
                boolean isDouble = (this.rockstar$lastClickedIndex == i && (now - this.rockstar$lastClickTime) < 350L);
                this.rockstar$lastClickTime = now;
                this.rockstar$lastClickedIndex = i;
                this.rockstar$selectedIndex = i;
                this.rockstar$syncSelectedToVanilla();

                if (isDouble && this.field_3041 != null && this.field_3041.active) {
                    this.field_3041.onPress();
                }
                cir.setReturnValue(true);
                return;
            }
        }
    }

    @Unique
    private void rockstar$syncSelectedToVanilla() {
        if (this.field_3043 != null && this.rockstar$selectedIndex >= 0 && this.rockstar$selectedIndex < this.field_3043.children().size()) {
            this.field_3043.setSelected(this.field_3043.children().get(this.rockstar$selectedIndex));
            this.method_20121();
        }
    }

    @Inject(method={"updateButtonActivationStates"}, at={@At(value="TAIL")})
    private void rockstar$lockPinnedButtons(CallbackInfo callbackInfo) {
        if (!this.rockstar$isPinnedServerSelected()) {
            return;
        }
        this.field_3041.active = false;
        this.field_3047.active = false;
    }

    @Inject(method={"removeEntry"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$preventPinnedRemoval(boolean bl, CallbackInfo callbackInfo) {
        if (!bl || this.client == null || !this.rockstar$isPinnedServerSelected() || RockstarClient.I_field_502d1741.i_method_e8604970()) {
            return;
        }
        this.client.setScreen((Screen)((MultiplayerScreen)(Object)this));
        callbackInfo.cancel();
    }

    @Inject(method={"editEntry"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$preventPinnedEdit(boolean bl, CallbackInfo callbackInfo) {
        if (!bl || this.client == null || !this.rockstar$isPinnedServerSelected()) {
            return;
        }
        this.client.setScreen((Screen)((MultiplayerScreen)(Object)this));
        callbackInfo.cancel();
    }

    @Unique
    private void rockstar$reloadServerListWidget() {
        if (this.client == null || this.client.currentScreen != this || this.field_3043 == null || RockstarClient.I_field_502d1741.i_method_e8604970()) {
            return;
        }
        this.field_3043.setServers(this.method_2529());
        this.method_20121();
    }

    @Unique
    private boolean rockstar$isPinnedServerSelected() {
        if (this.field_3043 == null) {
            return false;
        }
        MultiplayerServerListWidget.Entry entry = (MultiplayerServerListWidget.Entry)(Object)this.field_3043.getSelectedOrNull();
        if (!(entry instanceof MultiplayerServerListWidget.ServerEntry)) {
            return false;
        }
        MultiplayerServerListWidget.ServerEntry serverEntry = (MultiplayerServerListWidget.ServerEntry)entry;
        ServerInfo serverInfo = serverEntry.getServer();
        return iIIIiiIiI_Class283.I_method_8f9b3f84(serverInfo);
    }
}

