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

        // Center Stage Carousel
        float carouselCY = (this.height - 75.0F) / 2.0F + 14.0F;
        float cardW = 144.0F;
        float cardH = 168.0F;
        float spacing = 164.0F;
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

        // Section Navigation Pill Bar at Top
        float topSecY = carouselCY - cardH / 2.0F - 32.0F;
        boolean selectedIsPinned = this.rockstar$isPinnedServerSelected();
        float secBarW = 224.0F;
        float secBarH = 22.0F;
        float secBarX = cx - secBarW / 2.0F;
        rockstar.client.IIiii_Class8 radSec = rockstar.client.IIiii_Class8.I_method_893b2757(secBarH / 2.0F);

        custom.drawBlurredRect(secBarX, topSecY, secBarW, secBarH, 12.0F, 2.5F, radSec, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedRect(secBarX, topSecY, secBarW, secBarH, radSec, new pyrock.utility.render.ColorRGBA(12.0F, 14.0F, 22.0F, 190.0F));
        custom.drawRoundedBorder(secBarX, topSecY, secBarW, secBarH, 1.0F, radSec, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));

        float tabW = secBarW / 2.0F;
        // Active section indicator pill
        float activeTabX = selectedIsPinned ? secBarX : secBarX + tabW;
        custom.drawRoundedRect(activeTabX + 2.0F, topSecY + 2.0F, tabW - 4.0F, secBarH - 4.0F, rockstar.client.IIiii_Class8.I_method_893b2757((secBarH - 4.0F) / 2.0F), new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 36.0F));
        custom.drawRoundedBorder(activeTabX + 2.0F, topSecY + 2.0F, tabW - 4.0F, secBarH - 4.0F, 0.8F, rockstar.client.IIiii_Class8.I_method_893b2757((secBarH - 4.0F) / 2.0F), new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 90.0F));

        String tab1 = "★ ЗАКРЕПЛЕННЫЕ";
        String tab2 = "≡ ВСЕ СЕРВЕРЫ";
        float t1W = badgeFont.I_method_2c375926(tab1);
        float t2W = badgeFont.I_method_2c375926(tab2);
        custom.drawText(badgeFont, tab1, secBarX + (tabW - t1W) / 2.0F, topSecY + 7.0F, selectedIsPinned ? pyrock.utility.render.ColorRGBA.WHITE : new pyrock.utility.render.ColorRGBA(160.0F, 170.0F, 190.0F, 160.0F));
        custom.drawText(badgeFont, tab2, secBarX + tabW + (tabW - t2W) / 2.0F, topSecY + 7.0F, !selectedIsPinned ? pyrock.utility.render.ColorRGBA.WHITE : new pyrock.utility.render.ColorRGBA(160.0F, 170.0F, 190.0F, 160.0F));

        net.minecraft.util.Identifier unknownIcon = net.minecraft.util.Identifier.ofVanilla("textures/misc/unknown_server.png");

        // Render Carousel Cards (Matte & Glass design, Square avatar, Monochrome sleek buttons)
        for (int i = 0; i < count; i++) {
            float rel = (float) i - this.rockstar$carouselScroll;
            if (Math.abs(rel) > 2.8F) continue;

            ServerInfo info = serverList.get(i);
            boolean isPinned = rockstar.client.iIIIiiIiI_Class283.I_method_8f9b3f84(info);
            float cardCX = cx + rel * spacing;
            float distFromCenter = Math.abs(rel);
            boolean isCenter = (i == this.rockstar$selectedIndex);
            float cardScale = isCenter ? 1.05F : Math.max(0.90F, 1.0F - distFromCenter * 0.08F);
            float alpha = Math.max(0.40F, 1.0F - distFromCenter * 0.30F);

            float curW = cardW * cardScale;
            float curH = cardH * cardScale;
            float cardX = cardCX - curW / 2.0F;
            float cardY = carouselCY - curH / 2.0F;

            rockstar.client.IIiii_Class8 radCard = rockstar.client.IIiii_Class8.I_method_893b2757(12.0F);

            custom.drawShadow(cardX, cardY, curW, curH, 18.0F, radCard, pyrock.utility.render.ColorRGBA.BLACK.withAlpha(140.0F * alpha));
            if (isCenter) {
                custom.drawBlurredRect(cardX, cardY, curW, curH, 16.0F, 4.0F, radCard, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));
            }
            pyrock.utility.render.ColorRGBA cardBg = isCenter
                ? new pyrock.utility.render.ColorRGBA(12.0F, 16.0F, 26.0F, 240.0F)
                : new pyrock.utility.render.ColorRGBA(10.0F, 12.0F, 20.0F, 200.0F * alpha);
            custom.drawRoundedRect(cardX, cardY, curW, curH, radCard, cardBg);

            // Clean white border theme
            pyrock.utility.render.ColorRGBA cardBorder = isCenter
                ? new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 220.0F)
                : new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F * alpha);
            custom.drawRoundedBorder(cardX, cardY, curW, curH, isCenter ? 1.4F : 0.8F, radCard, cardBorder);

            // 1. Server Name at TOP
            String sName = info.name != null ? info.name : "Minecraft Server";
            float snW = titleFont.I_method_2c375926(sName);
            if (snW > curW - 16.0F) {
                while (sName.length() > 3 && titleFont.I_method_2c375926(sName + "...") > curW - 16.0F) {
                    sName = sName.substring(0, sName.length() - 1);
                }
                sName = sName + "...";
                snW = titleFont.I_method_2c375926(sName);
            }
            float nameY = cardY + 10.0F * cardScale;
            custom.drawText(titleFont, sName, cardCX - snW / 2.0F, nameY, pyrock.utility.render.ColorRGBA.WHITE.withAlpha(255.0F * alpha));

            // Pinned Section Badge on Card
            if (isPinned) {
                String pinText = "★";
                float pW = badgeFont.I_method_2c375926(pinText);
                custom.drawText(badgeFont, pinText, cardX + curW - pW - 8.0F, nameY, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, 220.0F * alpha));
            }

            // 2. Large Square Server Avatar with Rounded Corners
            float avatarSize = 92.0F * cardScale;
            float avatarX = cardCX - avatarSize / 2.0F;
            float avatarY = cardY + 26.0F * cardScale;
            rockstar.client.IIiii_Class8 radAvatar = rockstar.client.IIiii_Class8.I_method_893b2757(10.0F);

            custom.drawRoundedRect(avatarX, avatarY, avatarSize, avatarSize, radAvatar, new pyrock.utility.render.ColorRGBA(18.0F, 22.0F, 34.0F, 210.0F * alpha));
            custom.drawTexture(unknownIcon, avatarX + 4.0F, avatarY + 4.0F, avatarSize - 8.0F, avatarSize - 8.0F, pyrock.utility.render.ColorRGBA.WHITE.withAlpha(255.0F * alpha));
            custom.drawRoundedBorder(avatarX, avatarY, avatarSize, avatarSize, 1.0F, radAvatar, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (isCenter ? 140.0F : 50.0F) * alpha));

            // 3. Monochromatic Frosted Action Buttons at Bottom (Play & Edit) - No garish colors!
            float btnBarY = avatarY + avatarSize + 8.0F;
            float btnGap = 8.0F;
            float btnW = (curW - 20.0F - btnGap) / 2.0F;
            float btnH = 30.0F;
            rockstar.client.IIiii_Class8 radBtn = rockstar.client.IIiii_Class8.I_method_893b2757(6.0F);

            // Left Pod: Play Button (Monochrome Frosted Glass)
            float playX = cardX + 10.0F;
            boolean playHov = isCenter && (mouseX >= playX && mouseX <= playX + btnW && mouseY >= btnBarY && mouseY <= btnBarY + btnH);
            custom.drawRoundedRect(playX, btnBarY, btnW, btnH, radBtn, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (playHov ? 35.0F : 14.0F) * alpha));
            custom.drawRoundedBorder(playX, btnBarY, btnW, btnH, 0.9F, radBtn, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (playHov ? 180.0F : 40.0F) * alpha));

            float circleSize = 22.0F;
            float circleX = playX + (btnW - circleSize) / 2.0F;
            float circleY = btnBarY + (btnH - circleSize) / 2.0F;
            rockstar.client.IIiii_Class8 radCircle = rockstar.client.IIiii_Class8.I_method_893b2757(circleSize / 2.0F);
            custom.drawRoundedRect(circleX, circleY, circleSize, circleSize, radCircle, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (playHov ? 50.0F : 22.0F) * alpha));
            custom.drawRoundedBorder(circleX, circleY, circleSize, circleSize, 0.8F, radCircle, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (playHov ? 210.0F : 70.0F) * alpha));
            custom.drawIcon("play", circleX + 5.0F, circleY + 5.0F, 12.0F, pyrock.utility.render.ColorRGBA.WHITE.withAlpha(255.0F * alpha));

            // Right Pod: Edit Button (Monochrome Frosted Glass)
            float editX = playX + btnW + btnGap;
            boolean editHov = isCenter && (mouseX >= editX && mouseX <= editX + btnW && mouseY >= btnBarY && mouseY <= btnBarY + btnH);
            custom.drawRoundedRect(editX, btnBarY, btnW, btnH, radBtn, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (editHov ? 35.0F : 14.0F) * alpha));
            custom.drawRoundedBorder(editX, btnBarY, btnW, btnH, 0.9F, radBtn, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (editHov ? 180.0F : 40.0F) * alpha));

            float eCircleX = editX + (btnW - circleSize) / 2.0F;
            float eCircleY = btnBarY + (btnH - circleSize) / 2.0F;
            custom.drawRoundedRect(eCircleX, eCircleY, circleSize, circleSize, radCircle, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (editHov ? 50.0F : 22.0F) * alpha));
            custom.drawRoundedBorder(eCircleX, eCircleY, circleSize, circleSize, 0.8F, radCircle, new pyrock.utility.render.ColorRGBA(255.0F, 255.0F, 255.0F, (editHov ? 210.0F : 70.0F) * alpha));
            custom.drawIcon("setting", eCircleX + 4.5F, eCircleY + 4.5F, 13.0F, pyrock.utility.render.ColorRGBA.WHITE.withAlpha(240.0F * alpha));
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;
        if (count > 0) {
            if (verticalAmount > 0) {
                this.rockstar$selectedIndex = Math.max(0, this.rockstar$selectedIndex - 1);
                this.rockstar$syncSelectedToVanilla();
                return true;
            } else if (verticalAmount < 0) {
                this.rockstar$selectedIndex = Math.min(count - 1, this.rockstar$selectedIndex + 1);
                this.rockstar$syncSelectedToVanilla();
                return true;
            }
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
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

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;
        float carouselCY = (this.height - 75.0F) / 2.0F + 8.0F;
        float cardW = 144.0F;
        float cardH = 168.0F;
        float spacing = 164.0F;
        float cx = this.width / 2.0F;

        for (int i = 0; i < count; i++) {
            float rel = (float) i - this.rockstar$carouselScroll;
            if (Math.abs(rel) > 2.8F) continue;
            float cardCX = cx + rel * spacing;
            boolean isCenter = (i == this.rockstar$selectedIndex);
            float cardScale = isCenter ? 1.05F : 1.0F;
            float curW = cardW * cardScale;
            float curH = cardH * cardScale;
            float cardX = cardCX - curW / 2.0F;
            float cardY = carouselCY - curH / 2.0F;

            if (mouseX >= cardX && mouseX <= cardX + curW && mouseY >= cardY && mouseY <= cardY + curH) {
                if (isCenter) {
                    float avatarSize = 92.0F * cardScale;
                    float avatarY = cardY + 26.0F * cardScale;
                    float btnBarY = avatarY + avatarSize + 8.0F;
                    float btnGap = 8.0F;
                    float btnW = (curW - 20.0F - btnGap) / 2.0F;
                    float btnH = 30.0F;
                    float playX = cardX + 10.0F;
                    float editX = playX + btnW + btnGap;

                    // Play Button Click
                    if (mouseX >= playX && mouseX <= playX + btnW && mouseY >= btnBarY && mouseY <= btnBarY + btnH) {
                        if (this.field_3041 != null && this.field_3041.active) {
                            this.field_3041.onPress();
                            return true;
                        }
                    }

                    // Edit Button Click
                    if (mouseX >= editX && mouseX <= editX + btnW && mouseY >= btnBarY && mouseY <= btnBarY + btnH) {
                        if (this.field_3047 != null && this.field_3047.active) {
                            this.field_3047.onPress();
                            return true;
                        }
                    }
                }

                long now = System.currentTimeMillis();
                boolean isDouble = (this.rockstar$lastClickedIndex == i && (now - this.rockstar$lastClickTime) < 350L);
                this.rockstar$lastClickTime = now;
                this.rockstar$lastClickedIndex = i;
                this.rockstar$selectedIndex = i;
                this.rockstar$syncSelectedToVanilla();

                if (isDouble && this.field_3041 != null && this.field_3041.active) {
                    this.field_3041.onPress();
                }
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
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

