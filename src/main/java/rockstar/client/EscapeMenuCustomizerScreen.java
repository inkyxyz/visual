package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class EscapeMenuCustomizerScreen extends ii_Class4 {

    private final Screen parentScreen;

    public EscapeMenuCustomizerScreen(Screen parent) {
        this.parentScreen = parent;
    }

    public EscapeMenuCustomizerScreen() {
        this(null);
    }

    @Override
    public void render(III custom) {
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;

        // Dark frosted backdrop
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(10.0F, 14.0F, 22.0F, 195.0F));

        IIiIIi_Class10 font = null;
        IIiIIi_Class10 boldFont = null;
        IIiIIi_Class10 subFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.5F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
            }
        } catch (Throwable ignored) {}

        // Main Frosted Glass Dialog
        float cardW = Math.min(460.0F, this.width - 40.0F);
        float cardH = Math.min(380.0F, this.height - 40.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(14.0F);

        custom.drawShadow(cardX, cardY, cardW, cardH, 20.0F, cRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F));
        custom.drawBlurredRect(cardX, cardY, cardW, cardH, 22.0F, 3.0F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedRect(cardX, cardY, cardW, cardH, cRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 235.0F));
        custom.drawRoundedBorder(cardX, cardY, cardW, cardH, 1.2F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        // Header
        float hY = cardY + 12.0F;
        if (boldFont != null) {
            custom.drawText(boldFont, "⚙ Полная настройка Escape Меню", cardX + 16.0F, hY + 1.0F, ColorRGBA.WHITE);
        }

        // Close Button [✕]
        float closeW = 24.0F;
        float closeX = cardX + cardW - closeW - 14.0F;
        float closeY = hY - 2.0F;
        boolean closeHov = (custom.I_method_b1c3e152() >= closeX && custom.I_method_b1c3e152() <= closeX + closeW && custom.i_method_b1d26d32() >= closeY && custom.i_method_b1d26d32() <= closeY + closeW);
        custom.drawRoundedRect(closeX, closeY, closeW, closeW, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(239.0F, 68.0F, 68.0F, closeHov ? 240.0F : 140.0F));
        if (font != null) {
            custom.drawText(font, "✕", closeX + 8.0F, closeY + 6.0F, ColorRGBA.WHITE);
        }

        // Divider
        float divY = cardY + 38.0F;
        custom.drawRect(cardX + 16.0F, divY, cardW - 32.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();
        float itemY = divY + 10.0F;
        float itemH = 26.0F;
        float gap = 4.0F;

        // Toggle list items
        renderToggleItem(custom, cardX + 16.0F, itemY, cardW - 32.0F, itemH, "🎵 Виджет Медиаплеера", cfg.showMediaPlayer, font, subFont);
        itemY += itemH + gap;

        renderToggleItem(custom, cardX + 16.0F, itemY, cardW - 32.0F, itemH, "🧮 Виджет Калькулятора", cfg.showCalculator, font, subFont);
        itemY += itemH + gap;

        renderToggleItem(custom, cardX + 16.0F, itemY, cardW - 32.0F, itemH, "🔊 Ползунок громкости звука", cfg.showVolume, font, subFont);
        itemY += itemH + gap;

        renderToggleItem(custom, cardX + 16.0F, itemY, cardW - 32.0F, itemH, "📸 Быстрые плитки (Камера, Fullscreen)", cfg.showCamera, font, subFont);
        itemY += itemH + gap;

        renderToggleItem(custom, cardX + 16.0F, itemY, cardW - 32.0F, itemH, "🌦️ Виджет погоды и угрозы БПЛА", cfg.showWeatherAlerts, font, subFont);
        itemY += itemH + gap;

        renderToggleItem(custom, cardX + 16.0F, itemY, cardW - 32.0F, itemH, "🤖 Кнопка ИИ Помощника (Gemini)", cfg.showAIChat, font, subFont);
        itemY += itemH + gap;

        renderToggleItem(custom, cardX + 16.0F, itemY, cardW - 32.0F, itemH, "📝 Кнопка Заметок и координат", cfg.showNotes, font, subFont);
        itemY += itemH + gap;

        renderToggleItem(custom, cardX + 16.0F, itemY, cardW - 32.0F, itemH, "🎮 Мини-игры (Змейка / Сапёр)", cfg.showGames, font, subFont);
        itemY += itemH + gap;

        // Scope Selector: Регион тревог (Все / Украина / Россия)
        float scopeRowH = 28.0F;
        if (font != null) {
            custom.drawText(font, "Регион тревог БПЛА:", cardX + 20.0F, itemY + 8.0F, ColorRGBA.WHITE);
        }
        String[] scopes = {"Все", "Украина", "Россия"};
        float scX = cardX + 170.0F;
        for (String sc : scopes) {
            boolean isSel = cfg.alertScope.equals(sc);
            float btnW = 60.0F;
            boolean hov = (custom.I_method_b1c3e152() >= scX && custom.I_method_b1c3e152() <= scX + btnW && custom.i_method_b1d26d32() >= itemY + 4.0F && custom.i_method_b1d26d32() <= itemY + 4.0F + 20.0F);
            custom.drawRoundedRect(scX, itemY + 4.0F, btnW, 20.0F, IIiii_Class8.I_method_893b2757(4.0F), isSel ? new ColorRGBA(59.0F, 130.0F, 246.0F, 220.0F) : (hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 8.0F)));
            custom.drawRoundedBorder(scX, itemY + 4.0F, btnW, 20.0F, 1.0F, IIiii_Class8.I_method_893b2757(4.0F), isSel ? new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
            if (subFont != null) {
                float tw = subFont.I_method_2c375926(sc);
                custom.drawText(subFont, sc, scX + (btnW - tw) / 2.0F, itemY + 8.5F, ColorRGBA.WHITE);
            }
            scX += btnW + 6.0F;
        }
    }

    private void renderToggleItem(III custom, float x, float y, float w, float h, String title, boolean enabled, IIiIIi_Class10 font, IIiIIi_Class10 subFont) {
        boolean hov = (custom.I_method_b1c3e152() >= x && custom.I_method_b1c3e152() <= x + w && custom.i_method_b1d26d32() >= y && custom.i_method_b1d26d32() <= y + h);
        custom.drawRoundedRect(x, y, w, h, IIiii_Class8.I_method_893b2757(6.0F), hov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 4.0F));
        custom.drawRoundedBorder(x, y, w, h, 1.0F, IIiii_Class8.I_method_893b2757(6.0F), new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

        if (font != null) {
            custom.drawText(font, title, x + 10.0F, y + 7.5F, ColorRGBA.WHITE);
        }

        // Toggle Switch Pill
        float pillW = 34.0F;
        float pillH = 16.0F;
        float pillX = x + w - pillW - 10.0F;
        float pillY = y + (h - pillH) / 2.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(pillH / 2.0F);

        ColorRGBA pBg = enabled ? new ColorRGBA(16.0F, 185.0F, 129.0F, 230.0F) : new ColorRGBA(75.0F, 85.0F, 99.0F, 200.0F);
        custom.drawRoundedRect(pillX, pillY, pillW, pillH, pRad, pBg);

        float knobSz = 12.0F;
        float knobX = enabled ? (pillX + pillW - knobSz - 2.0F) : (pillX + 2.0F);
        float knobY = pillY + 2.0F;
        custom.drawRoundedRect(knobX, knobY, knobSz, knobSz, IIiii_Class8.I_method_893b2757(knobSz / 2.0F), ColorRGBA.WHITE);
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        if (button != IiIII_Class9.I_field_2f4c8d6c) return;

        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;
        float cardW = Math.min(460.0F, this.width - 40.0F);
        float cardH = Math.min(380.0F, this.height - 40.0F);
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        float hY = cardY + 12.0F;

        // Close Button
        float closeW = 24.0F;
        float closeX = cardX + cardW - closeW - 14.0F;
        float closeY = hY - 2.0F;
        if (mouseX >= closeX && mouseX <= closeX + closeW && mouseY >= closeY && mouseY <= closeY + closeW) {
            EscapeMenuConfig.getInstance().save();
            UISoundManager.playButtonClick();
            this.close();
            return;
        }

        EscapeMenuConfig cfg = EscapeMenuConfig.getInstance();
        float divY = cardY + 38.0F;
        float itemY = divY + 10.0F;
        float itemH = 26.0F;
        float gap = 4.0F;
        float w = cardW - 32.0F;
        float x = cardX + 16.0F;

        // 1. Media
        if (mouseX >= x && mouseX <= x + w && mouseY >= itemY && mouseY <= itemY + itemH) {
            cfg.showMediaPlayer = !cfg.showMediaPlayer;
            cfg.save();
            UISoundManager.playButtonClick();
            return;
        }
        itemY += itemH + gap;

        // 2. Calc
        if (mouseX >= x && mouseX <= x + w && mouseY >= itemY && mouseY <= itemY + itemH) {
            cfg.showCalculator = !cfg.showCalculator;
            cfg.save();
            UISoundManager.playButtonClick();
            return;
        }
        itemY += itemH + gap;

        // 3. Vol
        if (mouseX >= x && mouseX <= x + w && mouseY >= itemY && mouseY <= itemY + itemH) {
            cfg.showVolume = !cfg.showVolume;
            cfg.save();
            UISoundManager.playButtonClick();
            return;
        }
        itemY += itemH + gap;

        // 4. Quick tiles (Cam + Fullscreen)
        if (mouseX >= x && mouseX <= x + w && mouseY >= itemY && mouseY <= itemY + itemH) {
            cfg.showCamera = !cfg.showCamera;
            cfg.showFullscreen = cfg.showCamera;
            cfg.save();
            UISoundManager.playButtonClick();
            return;
        }
        itemY += itemH + gap;

        // 5. Weather & alerts
        if (mouseX >= x && mouseX <= x + w && mouseY >= itemY && mouseY <= itemY + itemH) {
            cfg.showWeatherAlerts = !cfg.showWeatherAlerts;
            cfg.save();
            UISoundManager.playButtonClick();
            return;
        }
        itemY += itemH + gap;

        // 6. AI Chat
        if (mouseX >= x && mouseX <= x + w && mouseY >= itemY && mouseY <= itemY + itemH) {
            cfg.showAIChat = !cfg.showAIChat;
            cfg.save();
            UISoundManager.playButtonClick();
            return;
        }
        itemY += itemH + gap;

        // 7. Notes
        if (mouseX >= x && mouseX <= x + w && mouseY >= itemY && mouseY <= itemY + itemH) {
            cfg.showNotes = !cfg.showNotes;
            cfg.save();
            UISoundManager.playButtonClick();
            return;
        }
        itemY += itemH + gap;

        // 8. Games
        if (mouseX >= x && mouseX <= x + w && mouseY >= itemY && mouseY <= itemY + itemH) {
            cfg.showGames = !cfg.showGames;
            cfg.save();
            UISoundManager.playButtonClick();
            return;
        }
        itemY += itemH + gap;

        // Scope Selector
        String[] scopes = {"Все", "Украина", "Россия"};
        float scX = cardX + 170.0F;
        for (String sc : scopes) {
            float btnW = 60.0F;
            if (mouseX >= scX && mouseX <= scX + btnW && mouseY >= itemY + 4.0F && mouseY <= itemY + 4.0F + 20.0F) {
                cfg.alertScope = sc;
                cfg.save();
                UISoundManager.playButtonClick();
                return;
            }
            scX += btnW + 6.0F;
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            EscapeMenuConfig.getInstance().save();
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void close() {
        EscapeMenuConfig.getInstance().save();
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            mc.setScreen(this.parentScreen);
        }
    }
}
