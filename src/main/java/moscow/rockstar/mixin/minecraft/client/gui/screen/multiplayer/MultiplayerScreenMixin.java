package moscow.rockstar.mixin.minecraft.client.gui.screen.multiplayer;

import java.util.List;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.option.ServerList;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.RockstarClient;
import rockstar.client.UISoundManager;
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

    // Captured vanilla action buttons
    @Unique private ButtonWidget rockstar$btnAdd;
    @Unique private ButtonWidget rockstar$btnDirect;
    @Unique private ButtonWidget rockstar$btnRefresh;
    @Unique private ButtonWidget rockstar$btnDelete;

    // In-place Settings / Edit popup modal window (opened via ПКМ or Yellow Edit button)
    @Unique private boolean rockstar$modalOpen = false;
    @Unique private int rockstar$modalServerIdx = -1;

    protected MultiplayerScreenMixin(Text text) {
        super(text);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void rockstar$initCleanUI(CallbackInfo callbackInfo) {
        if (this.field_3043 != null) {
            this.field_3043.visible = false;
        }

        // Hide vanilla buttons and capture references for our modern toolbar & modal
        List<Element> children = ((ScreenAccessor)this).getChildren();
        for (Element elem : children) {
            if (elem instanceof ButtonWidget btn) {
                String text = btn.getMessage().getString().toLowerCase();
                if (text.contains("add") || text.contains("добавить")) {
                    this.rockstar$btnAdd = btn;
                } else if (text.contains("direct") || text.contains("прямое")) {
                    this.rockstar$btnDirect = btn;
                } else if (text.contains("refresh") || text.contains("обновить")) {
                    this.rockstar$btnRefresh = btn;
                } else if (text.contains("delete") || text.contains("удалить")) {
                    this.rockstar$btnDelete = btn;
                }
            }
            if (elem instanceof ClickableWidget widget) {
                widget.visible = false;
            }
        }

        if (this.client != null && !RockstarClient.I_field_502d1741.i_method_e8604970()) {
            iIIIiiIiI_Class283.I_method_35a51568(this.client, this.method_2529(), this::rockstar$reloadServerListWidget);
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void rockstar$renderCustomMultiplayer(DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        III custom = III.I_method_5728d20f(drawContext, mouseX, mouseY, delta);
        long now = System.currentTimeMillis();
        if (this.rockstar$lastFrameTime == 0L) this.rockstar$lastFrameTime = now;
        this.rockstar$lastFrameTime = now;

        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;

        if (count > 0) {
            this.rockstar$selectedIndex = Math.max(0, Math.min(count - 1, this.rockstar$selectedIndex));
            this.rockstar$carouselScroll += ((float)this.rockstar$selectedIndex - this.rockstar$carouselScroll) * 0.20F;
        }

        IIiIIi_Class10 headerFont = null;
        IIiIIi_Class10 titleFont = null;
        IIiIIi_Class10 subFont = null;
        IIiIIi_Class10 smallFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                headerFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(14.0F);
                titleFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(10.0F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
                smallFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
            }
        } catch (Throwable ignored) {}

        float cx = this.width / 2.0F;

        // Top Header
        if (headerFont != null) {
            String title = "ВЫБОР СЕРВЕРА";
            float tw = headerFont.I_method_2c375926(title);
            custom.drawText(headerFont, title, cx - tw / 2.0F, 18.0F, ColorRGBA.WHITE);
        }
        if (subFont != null) {
            String hint = count > 0 ? "ЛКМ — подключение | ПКМ — настройки сервера" : "Добавьте свой первый сервер";
            float hw = subFont.I_method_2c375926(hint);
            custom.drawText(subFont, hint, cx - hw / 2.0F, 34.0F, new ColorRGBA(180.0F, 195.0F, 220.0F, 190.0F));
        }

        // Carousel Center Stage
        float carouselCY = (this.height - 40.0F) / 2.0F - 4.0F;
        float cardW = 150.0F;
        float cardH = 155.0F;
        float spacing = 180.0F;

        if (count == 0) {
            float emptyW = 280.0F;
            float emptyH = 110.0F;
            float emptyX = cx - emptyW / 2.0F;
            float emptyY = carouselCY - emptyH / 2.0F;
            custom.drawBlurredRect(emptyX, emptyY, emptyW, emptyH, 20.0F, 4.0F, IIiii_Class8.I_method_893b2757(14.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
            custom.drawRoundedRect(emptyX, emptyY, emptyW, emptyH, IIiii_Class8.I_method_893b2757(14.0F), new ColorRGBA(14.0F, 18.0F, 28.0F, 225.0F));
            custom.drawRoundedBorder(emptyX, emptyY, emptyW, emptyH, 1.2F, IIiii_Class8.I_method_893b2757(14.0F), new ColorRGBA(0.0F, 122.0F, 255.0F, 160.0F));
            if (titleFont != null) {
                String emptyTitle = "Нет добавленных серверов";
                float etW = titleFont.I_method_2c375926(emptyTitle);
                custom.drawText(titleFont, emptyTitle, cx - etW / 2.0F, carouselCY - 14.0F, ColorRGBA.WHITE);
            }
            if (subFont != null) {
                String emptySub = "Нажмите [ Добавить ] внизу экрана";
                float esW = subFont.I_method_2c375926(emptySub);
                custom.drawText(subFont, emptySub, cx - esW / 2.0F, carouselCY + 8.0F, new ColorRGBA(160.0F, 175.0F, 200.0F, 200.0F));
            }
        } else {
            Identifier unknownIcon = Identifier.ofVanilla("textures/misc/unknown_server.png");

            for (int i = 0; i < count; i++) {
                float rel = (float) i - this.rockstar$carouselScroll;
                if (Math.abs(rel) > 2.8F) continue;

                ServerInfo info = serverList.get(i);
                float cardCX = cx + rel * spacing;
                float dist = Math.abs(rel);
                boolean isCenter = (i == this.rockstar$selectedIndex);
                float scale = isCenter ? 1.05F : Math.max(0.88F, 1.0F - dist * 0.08F);
                float alpha = Math.max(0.35F, 1.0F - dist * 0.28F);

                float curW = cardW * scale;
                float curH = cardH * scale;
                float cardX = cardCX - curW / 2.0F;
                float cardY = carouselCY - curH / 2.0F;

                IIiii_Class8 radCard = IIiii_Class8.I_method_893b2757(14.0F);

                // 1. Dark Rounded Card Body with Glowing Blue Border (Matching Paint Reference Photo 1)
                custom.drawShadow(cardX, cardY, curW, curH, 18.0F, radCard, ColorRGBA.BLACK.withAlpha(160.0F * alpha));
                if (isCenter) {
                    custom.drawBlurredRect(cardX, cardY, curW, curH, 16.0F, 4.0F, radCard, new ColorRGBA(0.0F, 122.0F, 255.0F, 40.0F));
                }
                ColorRGBA cardBg = isCenter
                    ? new ColorRGBA(15.0F, 22.0F, 36.0F, 245.0F)
                    : new ColorRGBA(12.0F, 16.0F, 26.0F, 205.0F * alpha);
                custom.drawRoundedRect(cardX, cardY, curW, curH, radCard, cardBg);

                // Vibrant Blue Border exactly like reference
                ColorRGBA cardBorder = isCenter
                    ? new ColorRGBA(0.0F, 122.0F, 255.0F, 245.0F)
                    : new ColorRGBA(0.0F, 122.0F, 255.0F, 80.0F * alpha);
                custom.drawRoundedBorder(cardX, cardY, curW, curH, isCenter ? 1.8F : 1.0F, radCard, cardBorder);

                // Server Name at Top of Card
                String sName = (info.name != null && !info.name.isEmpty()) ? info.name : "Minecraft Server";
                if (titleFont != null) {
                    if (sName.length() > 16) sName = sName.substring(0, 15) + "…";
                    float snW = titleFont.I_method_2c375926(sName);
                    custom.drawText(titleFont, sName, cardCX - snW / 2.0F, cardY + 10.0F * scale, ColorRGBA.WHITE.withAlpha(255.0F * alpha));
                }

                // Large Server Icon / Avatar in Center
                float avatarSz = 86.0F * scale;
                float avatarX = cardCX - avatarSz / 2.0F;
                float avatarY = cardY + 28.0F * scale;
                IIiii_Class8 radAvatar = IIiii_Class8.I_method_893b2757(10.0F);

                custom.drawRoundedRect(avatarX, avatarY, avatarSz, avatarSz, radAvatar, new ColorRGBA(20.0F, 26.0F, 42.0F, 220.0F * alpha));
                custom.drawTexture(unknownIcon, avatarX + 4.0F, avatarY + 4.0F, avatarSz - 8.0F, avatarSz - 8.0F, ColorRGBA.WHITE.withAlpha(255.0F * alpha));
                custom.drawRoundedBorder(avatarX, avatarY, avatarSz, avatarSz, 1.0F, radAvatar, new ColorRGBA(255.0F, 255.0F, 255.0F, (isCenter ? 160.0F : 50.0F) * alpha));

                // Server IP address at bottom of card
                if (smallFont != null) {
                    String ip = (info.address != null) ? info.address : "";
                    if (ip.length() > 22) ip = ip.substring(0, 21) + "…";
                    float ipW = smallFont.I_method_2c375926(ip);
                    custom.drawText(smallFont, ip, cardCX - ipW / 2.0F, cardY + curH - 18.0F * scale, new ColorRGBA(160.0F, 185.0F, 225.0F, 200.0F * alpha));
                }

                // 2. TWO BUTTONS DIRECTLY BENEATH THE CARD (Exact Match to Paint Drawing Photo 1)
                // Left: Blue circular Play button (▶)
                // Right: Yellow circular Edit/Pencil button (✏)
                float btnCenterY = cardY + curH + 22.0F * scale;
                float btnRadius = 15.0F * scale;
                float btnDiam = btnRadius * 2.0F;
                float btnGap = 16.0F * scale;

                float btn1CenterX = cardCX - btnRadius - btnGap / 2.0F;
                float btn2CenterX = cardCX + btnRadius + btnGap / 2.0F;

                IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(btnRadius);

                // Button 1 (Blue Play Circle)
                boolean b1Hov = isCenter && (Math.hypot(mouseX - btn1CenterX, mouseY - btnCenterY) <= btnRadius);
                custom.drawShadow(btn1CenterX - btnRadius, btnCenterY - btnRadius, btnDiam, btnDiam, 10.0F, bRad, new ColorRGBA(0.0F, 122.0F, 255.0F, 120.0F * alpha));
                custom.drawRoundedRect(btn1CenterX - btnRadius, btnCenterY - btnRadius, btnDiam, btnDiam, bRad, new ColorRGBA(0.0F, 122.0F, 255.0F, (b1Hov ? 255.0F : 230.0F) * alpha));
                custom.drawRoundedBorder(btn1CenterX - btnRadius, btnCenterY - btnRadius, btnDiam, btnDiam, 1.2F, bRad, ColorRGBA.WHITE.withAlpha((b1Hov ? 255.0F : 120.0F) * alpha));
                custom.drawIcon("play", btn1CenterX - 5.5F * scale, btnCenterY - 5.5F * scale, 12.0F * scale, ColorRGBA.WHITE.withAlpha(255.0F * alpha));

                // Button 2 (Yellow Pencil/Edit Circle)
                boolean b2Hov = isCenter && (Math.hypot(mouseX - btn2CenterX, mouseY - btnCenterY) <= btnRadius);
                custom.drawShadow(btn2CenterX - btnRadius, btnCenterY - btnRadius, btnDiam, btnDiam, 10.0F, bRad, new ColorRGBA(255.0F, 195.0F, 10.0F, 120.0F * alpha));
                custom.drawRoundedRect(btn2CenterX - btnRadius, btnCenterY - btnRadius, btnDiam, btnDiam, bRad, new ColorRGBA(255.0F, 195.0F, 10.0F, (b2Hov ? 255.0F : 230.0F) * alpha));
                custom.drawRoundedBorder(btn2CenterX - btnRadius, btnCenterY - btnRadius, btnDiam, btnDiam, 1.2F, bRad, ColorRGBA.WHITE.withAlpha((b2Hov ? 255.0F : 120.0F) * alpha));
                custom.drawIcon("setting", btn2CenterX - 6.0F * scale, btnCenterY - 6.0F * scale, 12.5F * scale, new ColorRGBA(20.0F, 24.0F, 34.0F, 240.0F * alpha));
            }
        }

        // Modern Bottom Action Bar (Non-vanilla clean buttons: Add, Direct, Refresh, Back)
        float bY = this.height - 34.0F;
        float bH = 22.0F;
        String[] actions = new String[]{ "+ Добавить сервер", "Прямое подключение", "Обновить", "Назад" };
        float barStartX = cx - 210.0F;
        float actW = 100.0F;
        float actGap = 8.0F;

        for (int a = 0; a < 4; a++) {
            float ax = barStartX + a * (actW + actGap);
            boolean aHov = (mouseX >= ax && mouseX <= ax + actW && mouseY >= bY && mouseY <= bY + bH);
            IIiii_Class8 aRad = IIiii_Class8.I_method_893b2757(6.0F);

            custom.drawRoundedRect(ax, bY, actW, bH, aRad, new ColorRGBA(20.0F, 24.0F, 36.0F, aHov ? 230.0F : 170.0F));
            custom.drawRoundedBorder(ax, bY, actW, bH, 0.9F, aRad, aHov ? new ColorRGBA(0.0F, 122.0F, 255.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));
            if (subFont != null) {
                float aw = subFont.I_method_2c375926(actions[a]);
                custom.drawText(subFont, actions[a], ax + (actW - aw) / 2.0F, bY + 6.0F, aHov ? ColorRGBA.WHITE : new ColorRGBA(200.0F, 210.0F, 230.0F, 210.0F));
            }
        }

        // In-Place Settings Modal Popup Window (Triggered by ПКМ or Yellow Edit button)
        if (this.rockstar$modalOpen && serverList != null && this.rockstar$modalServerIdx >= 0 && this.rockstar$modalServerIdx < count) {
            ServerInfo target = serverList.get(this.rockstar$modalServerIdx);

            // Modal Backdrop Dimming
            custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(0.0F, 0.0F, 0.0F, 150.0F));

            float mW = 250.0F;
            float mH = 175.0F;
            float mX = cx - mW / 2.0F;
            float mY = (this.height - mH) / 2.0F;
            IIiii_Class8 mRad = IIiii_Class8.I_method_893b2757(16.0F);

            custom.drawShadow(mX, mY, mW, mH, 24.0F, mRad, ColorRGBA.BLACK.withAlpha(200.0F));
            custom.drawBlurredRect(mX, mY, mW, mH, 18.0F, 4.0F, mRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
            custom.drawRoundedRect(mX, mY, mW, mH, mRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 245.0F));
            custom.drawRoundedBorder(mX, mY, mW, mH, 1.2F, mRad, new ColorRGBA(0.0F, 122.0F, 255.0F, 200.0F));

            if (titleFont != null) {
                String mTitle = "Настройки сервера";
                float mtw = titleFont.I_method_2c375926(mTitle);
                custom.drawText(titleFont, mTitle, cx - mtw / 2.0F, mY + 12.0F, ColorRGBA.WHITE);
            }

            if (subFont != null) {
                String targetName = target.name != null ? target.name : "Server";
                float tnw = subFont.I_method_2c375926(targetName);
                custom.drawText(subFont, targetName, cx - tnw / 2.0F, mY + 28.0F, new ColorRGBA(0.0F, 122.0F, 255.0F, 240.0F));

                String targetIp = target.address != null ? target.address : "";
                float tiw = subFont.I_method_2c375926(targetIp);
                custom.drawText(subFont, targetIp, cx - tiw / 2.0F, mY + 40.0F, new ColorRGBA(160.0F, 175.0F, 200.0F, 180.0F));
            }

            // 4 Modal Action Buttons
            String[] mBtns = new String[]{ "▶ Подключиться", "✏ Изменить сервер", "🗑 Удалить", "✕ Закрыть" };
            float mbW = mW - 28.0F;
            float mbH = 22.0F;
            float mbX = mX + 14.0F;
            float mbStartY = mY + 60.0F;

            for (int mb = 0; mb < 4; mb++) {
                float mby = mbStartY + mb * (mbH + 6.0F);
                boolean mbHov = (mouseX >= mbX && mouseX <= mbX + mbW && mouseY >= mby && mouseY <= mby + mbH);
                IIiii_Class8 mbRad = IIiii_Class8.I_method_893b2757(6.0F);

                ColorRGBA bg = (mb == 0)
                    ? new ColorRGBA(0.0F, 122.0F, 255.0F, mbHov ? 255.0F : 210.0F)
                    : (mb == 2 ? new ColorRGBA(235.0F, 55.0F, 50.0F, mbHov ? 240.0F : 190.0F) : new ColorRGBA(30.0F, 36.0F, 50.0F, mbHov ? 240.0F : 190.0F));
                custom.drawRoundedRect(mbX, mby, mbW, mbH, mbRad, bg);
                custom.drawRoundedBorder(mbX, mby, mbW, mbH, 1.0F, mbRad, mbHov ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

                if (subFont != null) {
                    float txtW = subFont.I_method_2c375926(mBtns[mb]);
                    custom.drawText(subFont, mBtns[mb], mbX + (mbW - txtW) / 2.0F, mby + 6.0F, ColorRGBA.WHITE);
                }
            }
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.rockstar$modalOpen) return true;
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
    private void rockstar$onKeyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if (this.rockstar$modalOpen) {
            if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
                this.rockstar$modalOpen = false;
                cir.setReturnValue(true);
            }
            return;
        }

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
        float cx = this.width / 2.0F;

        // 1. Handle Clicks inside In-Place Settings Modal
        if (this.rockstar$modalOpen) {
            float mW = 250.0F;
            float mH = 175.0F;
            float mX = cx - mW / 2.0F;
            float mY = (this.height - mH) / 2.0F;

            float mbW = mW - 28.0F;
            float mbH = 22.0F;
            float mbX = mX + 14.0F;
            float mbStartY = mY + 60.0F;

            for (int mb = 0; mb < 4; mb++) {
                float mby = mbStartY + mb * (mbH + 6.0F);
                if (mouseX >= mbX && mouseX <= mbX + mbW && mouseY >= mby && mouseY <= mby + mbH) {
                    UISoundManager.playButtonClick();
                    switch (mb) {
                        case 0 -> { // Connect
                            this.rockstar$modalOpen = false;
                            this.rockstar$syncSelectedToVanilla();
                            if (this.field_3041 != null && this.field_3041.active) this.field_3041.onPress();
                        }
                        case 1 -> { // Edit Server
                            this.rockstar$modalOpen = false;
                            this.rockstar$syncSelectedToVanilla();
                            if (this.field_3047 != null && this.field_3047.active) this.field_3047.onPress();
                        }
                        case 2 -> { // Delete Server
                            this.rockstar$modalOpen = false;
                            this.rockstar$syncSelectedToVanilla();
                            if (this.rockstar$btnDelete != null && this.rockstar$btnDelete.active) this.rockstar$btnDelete.onPress();
                        }
                        case 3 -> { // Close Modal
                            this.rockstar$modalOpen = false;
                        }
                    }
                    return true;
                }
            }

            // Click outside closes modal
            if (mouseX < mX || mouseX > mX + mW || mouseY < mY || mouseY > mY + mH) {
                this.rockstar$modalOpen = false;
                return true;
            }
            return true;
        }

        // 2. Handle Bottom Toolbar Action Buttons
        float bY = this.height - 34.0F;
        float bH = 22.0F;
        float barStartX = cx - 210.0F;
        float actW = 100.0F;
        float actGap = 8.0F;

        for (int a = 0; a < 4; a++) {
            float ax = barStartX + a * (actW + actGap);
            if (mouseX >= ax && mouseX <= ax + actW && mouseY >= bY && mouseY <= bY + bH) {
                UISoundManager.playButtonClick();
                switch (a) {
                    case 0 -> { // Add Server
                        if (this.rockstar$btnAdd != null) this.rockstar$btnAdd.onPress();
                    }
                    case 1 -> { // Direct Connect
                        if (this.rockstar$btnDirect != null) this.rockstar$btnDirect.onPress();
                    }
                    case 2 -> { // Refresh
                        this.rockstar$reloadServerListWidget();
                    }
                    case 3 -> { // Back
                        this.close();
                    }
                }
                return true;
            }
        }

        // 3. Handle Carousel Server Card & Buttons Click
        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;
        float carouselCY = (this.height - 40.0F) / 2.0F - 4.0F;
        float cardW = 150.0F;
        float cardH = 155.0F;
        float spacing = 180.0F;

        for (int i = 0; i < count; i++) {
            float rel = (float) i - this.rockstar$carouselScroll;
            if (Math.abs(rel) > 2.8F) continue;
            float cardCX = cx + rel * spacing;
            boolean isCenter = (i == this.rockstar$selectedIndex);
            float scale = isCenter ? 1.05F : 1.0F;
            float curW = cardW * scale;
            float curH = cardH * scale;
            float cardX = cardCX - curW / 2.0F;
            float cardY = carouselCY - curH / 2.0F;

            // Two circular action buttons under card
            float btnCenterY = cardY + curH + 22.0F * scale;
            float btnRadius = 15.0F * scale;
            float btnGap = 16.0F * scale;
            float btn1CenterX = cardCX - btnRadius - btnGap / 2.0F;
            float btn2CenterX = cardCX + btnRadius + btnGap / 2.0F;

            // Check Blue Play Button Click
            if (isCenter && Math.hypot(mouseX - btn1CenterX, mouseY - btnCenterY) <= btnRadius) {
                UISoundManager.playButtonClick();
                this.rockstar$selectedIndex = i;
                this.rockstar$syncSelectedToVanilla();
                if (this.field_3041 != null && this.field_3041.active) {
                    this.field_3041.onPress();
                }
                return true;
            }

            // Check Yellow Edit Button Click (Opens in-place Settings modal popup)
            if (isCenter && Math.hypot(mouseX - btn2CenterX, mouseY - btnCenterY) <= btnRadius) {
                UISoundManager.playButtonClick();
                this.rockstar$modalOpen = true;
                this.rockstar$modalServerIdx = i;
                return true;
            }

            // Check Card Click
            if (mouseX >= cardX && mouseX <= cardX + curW && mouseY >= cardY && mouseY <= cardY + curH) {
                this.rockstar$selectedIndex = i;
                this.rockstar$syncSelectedToVanilla();

                if (button == 1) { // ПКМ (Right-Click): Open in-place Settings modal window!
                    UISoundManager.playButtonClick();
                    this.rockstar$modalOpen = true;
                    this.rockstar$modalServerIdx = i;
                    return true;
                } else if (button == 0) { // ЛКМ (Left-Click): Connect to server immediately!
                    UISoundManager.playButtonClick();
                    if (this.field_3041 != null && this.field_3041.active) {
                        this.field_3041.onPress();
                    }
                    return true;
                }
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

    @Unique
    private void rockstar$reloadServerListWidget() {
        if (this.client == null || this.client.currentScreen != this || this.field_3043 == null || RockstarClient.I_field_502d1741.i_method_e8604970()) {
            return;
        }
        this.field_3043.setServers(this.method_2529());
        this.method_20121();
    }
}
