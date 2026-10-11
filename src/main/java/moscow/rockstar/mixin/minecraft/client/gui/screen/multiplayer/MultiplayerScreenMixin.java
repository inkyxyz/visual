package moscow.rockstar.mixin.minecraft.client.gui.screen.multiplayer;

import java.util.List;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.MinecraftClient;
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

    protected MultiplayerScreenMixin(Text text) {
        super(text);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void rockstar$initCleanUI(CallbackInfo callbackInfo) {
        if (this.field_3043 != null) {
            this.field_3043.visible = false;
        }

        // Hide vanilla buttons and capture references for our modern toolbar
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
                headerFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(15.0F);
                titleFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.5F);
                smallFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F);
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
            String hint = count > 0 ? "Нажмите «Запустить» для входа • Настройки для смены IP" : "Добавьте свой сервер для игры";
            float hw = subFont.I_method_2c375926(hint);
            custom.drawText(subFont, hint, cx - hw / 2.0F, 34.0F, new ColorRGBA(180.0F, 195.0F, 220.0F, 190.0F));
        }

        // Carousel Center Stage
        float carouselCY = (this.height - 40.0F) / 2.0F - 4.0F;
        float cardW = 208.0F;
        float cardH = 216.0F;
        float spacing = 236.0F;

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
                String emptySub = "Нажмите [ + Добавить сервер ] внизу экрана";
                float esW = subFont.I_method_2c375926(emptySub);
                custom.drawText(subFont, emptySub, cx - esW / 2.0F, carouselCY + 8.0F, new ColorRGBA(160.0F, 175.0F, 200.0F, 200.0F));
            }
        } else {
            Identifier unknownIcon = Identifier.ofVanilla("textures/misc/unknown_server.png");
            Identifier defaultBanner = RockstarClient.id("image/mainmenu/wallpaper2.jpg");

            for (int i = 0; i < count; i++) {
                float rel = (float) i - this.rockstar$carouselScroll;
                if (Math.abs(rel) > 2.8F) continue;

                ServerInfo info = serverList.get(i);
                float cardCX = cx + rel * spacing;
                float dist = Math.abs(rel);
                boolean isCenter = (i == this.rockstar$selectedIndex);
                float scale = isCenter ? 1.04F : Math.max(0.88F, 1.0F - dist * 0.08F);
                float alpha = Math.max(0.35F, 1.0F - dist * 0.28F);

                float curW = cardW * scale;
                float curH = cardH * scale;
                float cardX = cardCX - curW / 2.0F;
                float cardY = carouselCY - curH / 2.0F;

                IIiii_Class8 radCard = IIiii_Class8.I_method_893b2757(16.0F);

                // --- 1. MATTE FROSTED SEMI-GLASS CARD BODY ---
                custom.drawShadow(cardX, cardY, curW, curH, 20.0F, radCard, ColorRGBA.BLACK.withAlpha(160.0F * alpha));
                if (isCenter) {
                    custom.drawBlurredRect(cardX, cardY, curW, curH, 16.0F, 4.0F, radCard, new ColorRGBA(52.0F, 199.0F, 245.0F, 40.0F));
                }
                ColorRGBA cardBg = isCenter
                    ? new ColorRGBA(16.0F, 22.0F, 34.0F, 245.0F)
                    : new ColorRGBA(13.0F, 17.0F, 27.0F, 210.0F * alpha);
                custom.drawRoundedRect(cardX, cardY, curW, curH, radCard, cardBg);

                // Specular Border
                ColorRGBA cardBorder = isCenter
                    ? new ColorRGBA(52.0F, 199.0F, 245.0F, 240.0F)
                    : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F * alpha);
                custom.drawRoundedBorder(cardX, cardY, curW, curH, isCenter ? 1.5F : 1.0F, radCard, cardBorder);

                // --- 2. LARGE SERVER PICTURE / BANNER WITHOUT HARSH SQUARE EDGES ---
                float bannerPad = 6.0F * scale;
                float banX = cardX + bannerPad;
                float banY = cardY + bannerPad;
                float banW = curW - bannerPad * 2.0F;
                float banH = 96.0F * scale;
                IIiii_Class8 radBan = IIiii_Class8.I_method_893b2757(12.0F);

                // Render Banner Image
                custom.drawTexture(defaultBanner, banX, banY, banW, banH, ColorRGBA.WHITE.withAlpha(240.0F * alpha));

                // Smooth Gradient Fade on bottom of picture so edges seamlessly dissolve into card body
                float fadeH = 46.0F * scale;
                custom.drawRoundedRect(banX, banY + banH - fadeH, banW, fadeH, radBan, new ColorRGBA(16.0F, 22.0F, 34.0F, 215.0F * alpha));
                custom.drawRoundedBorder(banX, banY, banW, banH, 1.0F, radBan, new ColorRGBA(255.0F, 255.0F, 255.0F, (isCenter ? 120.0F : 40.0F) * alpha));

                // Server Icon in top-left of banner
                float iconSz = 32.0F * scale;
                custom.drawRoundedRect(banX + 6.0F, banY + 6.0F, iconSz, iconSz, IIiii_Class8.I_method_893b2757(8.0F), new ColorRGBA(10.0F, 14.0F, 24.0F, 220.0F * alpha));
                custom.drawTexture(unknownIcon, banX + 8.0F, banY + 8.0F, iconSz - 4.0F, iconSz - 4.0F, ColorRGBA.WHITE.withAlpha(255.0F * alpha));

                // Online Status Pill in top-right of banner
                if (subFont != null) {
                    custom.drawRoundedRect(banX + banW - 74.0F * scale, banY + 6.0F, 68.0F * scale, 16.0F * scale, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(10.0F, 14.0F, 24.0F, 210.0F * alpha));
                    custom.drawText(subFont, "🟢 840 • 18мс", banX + banW - 70.0F * scale, banY + 10.0F * scale, ColorRGBA.WHITE.withAlpha(255.0F * alpha));
                }

                // Server Name
                String sName = (info.name != null && !info.name.isEmpty()) ? info.name : "Minecraft Сервер";
                if (titleFont != null) {
                    if (sName.length() > 18) sName = sName.substring(0, 17) + "…";
                    float snW = titleFont.I_method_2c375926(sName);
                    custom.drawText(titleFont, sName, cardCX - snW / 2.0F, banY + banH + 6.0F * scale, ColorRGBA.WHITE.withAlpha(255.0F * alpha));
                }

                // Server IP Pill
                String ip = (info.address != null) ? info.address : "";
                if (subFont != null) {
                    if (ip.length() > 24) ip = ip.substring(0, 23) + "…";
                    float ipW = subFont.I_method_2c375926(ip);
                    float ipBoxW = ipW + 16.0F * scale;
                    float ipBoxX = cardCX - ipBoxW / 2.0F;
                    float ipBoxY = banY + banH + 22.0F * scale;
                    custom.drawRoundedRect(ipBoxX, ipBoxY, ipBoxW, 14.0F * scale, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(25.0F, 32.0F, 50.0F, 180.0F * alpha));
                    custom.drawText(subFont, ip, ipBoxX + 8.0F * scale, ipBoxY + 3.0F * scale, new ColorRGBA(52.0F, 199.0F, 245.0F, 230.0F * alpha));
                }

                // --- 3. THREE MATTE FROSTED ACTION BUTTONS ON CARD ---
                // [ ▶ Запустить ] (92px)  |  [ ⚙ Настройки ] (64px)  |  [ 🗑 ] (28px)
                float btnRowY = cardY + curH - 34.0F * scale;
                float btnRowH = 24.0F * scale;
                IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(6.0F);

                float btn1W = 88.0F * scale;
                float btn2W = 66.0F * scale;
                float btn3W = 28.0F * scale;
                float gap = 5.0F * scale;

                float startBtnsX = cardCX - (btn1W + btn2W + btn3W + gap * 2.0F) / 2.0F;
                float b1X = startBtnsX;
                float b2X = b1X + btn1W + gap;
                float b3X = b2X + btn2W + gap;

                // Button 1: [ ▶ Запустить ] (Launches / Connects directly!)
                boolean b1Hov = isCenter && (mouseX >= b1X && mouseX <= b1X + btn1W && mouseY >= btnRowY && mouseY <= btnRowY + btnRowH);
                custom.drawShadow(b1X, btnRowY, btn1W, btnRowH, 8.0F, bRad, new ColorRGBA(52.0F, 199.0F, 245.0F, 100.0F * alpha));
                custom.drawRoundedRect(b1X, btnRowY, btn1W, btnRowH, bRad, new ColorRGBA(0.0F, 122.0F, 255.0F, (b1Hov ? 255.0F : 210.0F) * alpha));
                custom.drawRoundedBorder(b1X, btnRowY, btn1W, btnRowH, 1.0F, bRad, ColorRGBA.WHITE.withAlpha((b1Hov ? 255.0F : 120.0F) * alpha));
                if (subFont != null) {
                    custom.drawText(subFont, "▶ Запустить", b1X + 12.0F * scale, btnRowY + 6.5F * scale, ColorRGBA.WHITE.withAlpha(255.0F * alpha));
                }

                // Button 2: [ ⚙ Настройки ] (Opens server settings / IP edit directly!)
                boolean b2Hov = isCenter && (mouseX >= b2X && mouseX <= b2X + btn2W && mouseY >= btnRowY && mouseY <= btnRowY + btnRowH);
                custom.drawRoundedRect(b2X, btnRowY, btn2W, btnRowH, bRad, new ColorRGBA(30.0F, 38.0F, 56.0F, (b2Hov ? 255.0F : 200.0F) * alpha));
                custom.drawRoundedBorder(b2X, btnRowY, btn2W, btnRowH, 1.0F, bRad, new ColorRGBA(255.0F, 255.0F, 255.0F, (b2Hov ? 200.0F : 60.0F) * alpha));
                if (subFont != null) {
                    custom.drawText(subFont, "⚙ IP / Инфо", b2X + 8.0F * scale, btnRowY + 6.5F * scale, ColorRGBA.WHITE.withAlpha(255.0F * alpha));
                }

                // Button 3: [ 🗑 ] (Deletes server!)
                boolean b3Hov = isCenter && (mouseX >= b3X && mouseX <= b3X + btn3W && mouseY >= btnRowY && mouseY <= btnRowY + btnRowH);
                custom.drawRoundedRect(b3X, btnRowY, btn3W, btnRowH, bRad, new ColorRGBA(235.0F, 55.0F, 50.0F, (b3Hov ? 240.0F : 180.0F) * alpha));
                custom.drawRoundedBorder(b3X, btnRowY, btn3W, btnRowH, 1.0F, bRad, new ColorRGBA(255.0F, 255.0F, 255.0F, (b3Hov ? 220.0F : 60.0F) * alpha));
                custom.drawIcon("trash", b3X + (btn3W - 10.0F * scale) / 2.0F, btnRowY + (btnRowH - 10.0F * scale) / 2.0F, 10.0F * scale, ColorRGBA.WHITE.withAlpha(255.0F * alpha));
            }
        }

        // --- 4. FLOATING MATTE FROSTED TOOLBAR AT BOTTOM (NO UGLY VANILLA BUTTONS!) ---
        float bY = this.height - 36.0F;
        float bH = 24.0F;
        String[] actions = new String[]{ "+ Добавить сервер", "🔗 Прямой IP", "⟳ Обновить", "✕ Назад" };
        float barStartX = cx - 220.0F;
        float actW = 104.0F;
        float actGap = 8.0F;

        for (int a = 0; a < 4; a++) {
            float ax = barStartX + a * (actW + actGap);
            boolean aHov = (mouseX >= ax && mouseX <= ax + actW && mouseY >= bY && mouseY <= bY + bH);
            IIiii_Class8 aRad = IIiii_Class8.I_method_893b2757(8.0F);

            custom.drawShadow(ax, bY, actW, bH, 10.0F, aRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 80.0F));
            custom.drawBlurredRect(ax, bY, actW, bH, 12.0F, 2.0F, aRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
            custom.drawRoundedRect(ax, bY, actW, bH, aRad, new ColorRGBA(22.0F, 28.0F, 42.0F, aHov ? 245.0F : 190.0F));
            custom.drawRoundedBorder(ax, bY, actW, bH, 1.0F, aRad, aHov ? new ColorRGBA(52.0F, 199.0F, 245.0F, 220.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));
            if (subFont != null) {
                float aw = subFont.I_method_2c375926(actions[a]);
                custom.drawText(subFont, actions[a], ax + (actW - aw) / 2.0F, bY + 6.5F, aHov ? ColorRGBA.WHITE : new ColorRGBA(200.0F, 215.0F, 235.0F, 220.0F));
            }
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
    private void rockstar$onKeyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
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
                this.rockstar$syncSelectedToVanilla();
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

        // 1. Handle Bottom Floating Toolbar Action Buttons
        float bY = this.height - 36.0F;
        float bH = 24.0F;
        float barStartX = cx - 220.0F;
        float actW = 104.0F;
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

        // 2. Handle Carousel Server Card & Specific Functional Buttons
        ServerList serverList = this.method_2529();
        int count = serverList != null ? serverList.size() : 0;
        float carouselCY = (this.height - 40.0F) / 2.0F - 4.0F;
        float cardW = 208.0F;
        float cardH = 216.0F;
        float spacing = 236.0F;

        for (int i = 0; i < count; i++) {
            float rel = (float) i - this.rockstar$carouselScroll;
            if (Math.abs(rel) > 2.8F) continue;
            float cardCX = cx + rel * spacing;
            boolean isCenter = (i == this.rockstar$selectedIndex);
            float scale = isCenter ? 1.04F : 1.0F;
            float curW = cardW * scale;
            float curH = cardH * scale;
            float cardX = cardCX - curW / 2.0F;
            float cardY = carouselCY - curH / 2.0F;

            float btnRowY = cardY + curH - 34.0F * scale;
            float btnRowH = 24.0F * scale;
            float btn1W = 88.0F * scale;
            float btn2W = 66.0F * scale;
            float btn3W = 28.0F * scale;
            float gap = 5.0F * scale;

            float startBtnsX = cardCX - (btn1W + btn2W + btn3W + gap * 2.0F) / 2.0F;
            float b1X = startBtnsX;
            float b2X = b1X + btn1W + gap;
            float b3X = b2X + btn2W + gap;

            if (isCenter) {
                // Button 1: [ ▶ Запустить ] -> Launches / Connects immediately!
                if (mouseX >= b1X && mouseX <= b1X + btn1W && mouseY >= btnRowY && mouseY <= btnRowY + btnRowH) {
                    UISoundManager.playButtonClick();
                    this.rockstar$selectedIndex = i;
                    this.rockstar$syncSelectedToVanilla();
                    if (this.field_3041 != null && this.field_3041.active) {
                        this.field_3041.onPress();
                    }
                    return true;
                }

                // Button 2: [ ⚙ Настройки ] -> Opens Edit Server Screen directly!
                if (mouseX >= b2X && mouseX <= b2X + btn2W && mouseY >= btnRowY && mouseY <= btnRowY + btnRowH) {
                    UISoundManager.playButtonClick();
                    this.rockstar$selectedIndex = i;
                    this.rockstar$syncSelectedToVanilla();
                    if (this.field_3047 != null && this.field_3047.active) {
                        this.field_3047.onPress();
                    }
                    return true;
                }

                // Button 3: [ 🗑 Удалить ] -> Triggers delete!
                if (mouseX >= b3X && mouseX <= b3X + btn3W && mouseY >= btnRowY && mouseY <= btnRowY + btnRowH) {
                    UISoundManager.playButtonClick();
                    this.rockstar$selectedIndex = i;
                    this.rockstar$syncSelectedToVanilla();
                    if (this.rockstar$btnDelete != null && this.rockstar$btnDelete.active) {
                        this.rockstar$btnDelete.onPress();
                    }
                    return true;
                }
            }

            // Clicking any card selects it, and double clicking launches it!
            if (mouseX >= cardX && mouseX <= cardX + curW && mouseY >= cardY && mouseY <= cardY + curH) {
                UISoundManager.playButtonClick();
                this.rockstar$selectedIndex = i;
                this.rockstar$syncSelectedToVanilla();
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

    @Unique
    private void rockstar$reloadServerListWidget() {
        if (this.client == null || this.client.currentScreen != this || this.field_3043 == null || RockstarClient.I_field_502d1741.i_method_e8604970()) {
            return;
        }
        this.field_3043.setServers(this.method_2529());
        this.method_20121();
    }
}
