package rockstar.client;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Util;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class BrowserScreen extends ii_Class4 {
    private final Screen parentScreen;
    private String currentUrl;
    private String searchQuery;
    private boolean isEditingUrl = false;

    private static class WebResult {
        String title;
        String url;
        String snippet;

        WebResult(String title, String url, String snippet) {
            this.title = title;
            this.url = url;
            this.snippet = snippet;
        }
    }
    private final List<WebResult> results = new ArrayList<>();

    public BrowserScreen(Screen parentScreen, String query) {
        this.parentScreen = parentScreen;
        this.searchQuery = (query != null && !query.trim().isEmpty()) ? query.trim() : "";
        if (!this.searchQuery.isEmpty()) {
            this.currentUrl = "https://www.google.com/search?q=" + URLEncoder.encode(this.searchQuery, StandardCharsets.UTF_8);
        } else {
            this.currentUrl = "https://www.google.com";
        }
        buildResults();
    }

    private void buildResults() {
        this.results.clear();
        String q = this.searchQuery.toLowerCase();

        if (q.isEmpty()) {
            this.results.add(new WebResult("YouTube: Home", "https://youtube.com", "Смотрите любимые видео, слушайте музыку и делитесь контентом со всем миром."));
            this.results.add(new WebResult("Minecraft Wiki: Официальная база знаний", "https://minecraft.wiki", "Полное руководство по предметам, крафтам, мобам и механикам Minecraft 1.21."));
            this.results.add(new WebResult("Agravity Client: Документация и обновления", "https://agravity.dev", "Новое поколение кастомных визуалов, анимаций Roblox и оптимизации."));
            this.results.add(new WebResult("FunTime: Анархия и Гриферские сервера", "https://funtime.su", "Популярный анархо-сервер с уникальными ивентами, кланами и аукционами."));
            this.results.add(new WebResult("GitHub: Платформа разработчиков", "https://github.com", "Миллионы проектов с открытым исходным кодом, репозитории и инструменты."));
        } else {
            this.results.add(new WebResult(searchQuery + " — Поиск в Google", this.currentUrl, "Результаты поиска Google по запросу \"" + searchQuery + "\". Нажмите, чтобы открыть в браузере."));
            this.results.add(new WebResult(searchQuery + " | Minecraft Wiki", "https://minecraft.wiki/w/" + URLEncoder.encode(searchQuery, StandardCharsets.UTF_8), "Подробная информация, рецепты крафта и руководства из Minecraft Wiki."));
            this.results.add(new WebResult(searchQuery + " — Смотреть на YouTube", "https://youtube.com/results?search_query=" + URLEncoder.encode(searchQuery, StandardCharsets.UTF_8), "Видеоролики, летсплеи, гайды и стримы по вашему запросу."));
            this.results.add(new WebResult("Agravity Hub: Обсуждение " + searchQuery, "https://google.com/search?q=" + URLEncoder.encode(searchQuery, StandardCharsets.UTF_8), "Найти самые свежие материалы, советы и новости в интернете."));
        }
    }

    private void openInSystemBrowser(String url) {
        try {
            Util.getOperatingSystem().open(URI.create(url));
        } catch (Throwable ignored) {}
    }

    @Override
    public void render(III custom) {
        // Dark browser window backdrop
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(18.0F, 20.0F, 28.0F, 255.0F));

        IIiIIi_Class10 titleFont = null;
        IIiIIi_Class10 boldFont = null;
        IIiIIi_Class10 font = null;
        IIiIIi_Class10 subFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                titleFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(16.0F);
                boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(12.0F);
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(10.0F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
            }
        } catch (Throwable ignored) {}

        // --- 1. TOP BROWSER CHROME / TOOLBAR ---
        float barH = 44.0F;
        custom.drawRect(0.0F, 0.0F, (float)this.width, barH, new ColorRGBA(24.0F, 28.0F, 40.0F, 255.0F));
        custom.drawRect(0.0F, barH, (float)this.width, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));

        // Window controls (Back ◀, Forward ▶, Refresh 🔄)
        float navY = 12.0F;
        if (font != null) {
            custom.drawText(font, "◀", 16.0F, navY + 4.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));
            custom.drawText(font, "▶", 36.0F, navY + 4.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
            custom.drawText(font, "🔄", 56.0F, navY + 4.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 210.0F));
        }

        // URL / Address Pill
        float urlX = 84.0F;
        float urlW = this.width - 240.0F;
        float urlH = 28.0F;
        IIiii_Class8 urlRad = IIiii_Class8.I_method_893b2757(14.0F);
        custom.drawRoundedRect(urlX, 8.0F, urlW, urlH, urlRad, new ColorRGBA(14.0F, 16.0F, 24.0F, 255.0F));
        custom.drawRoundedBorder(urlX, 8.0F, urlW, urlH, 1.0F, urlRad, isEditingUrl ? IiiiiIIIi_Class242.I_method_7df8e08e() : new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F));

        // Lock / HTTPS icon & URL text
        if (font != null) {
            custom.drawText(font, "🔒", urlX + 10.0F, 14.0F, new ColorRGBA(52.0F, 199.0F, 89.0F));
            String dispUrl = isEditingUrl ? (searchQuery + ((System.currentTimeMillis() % 1000L < 500L) ? "|" : "")) : currentUrl;
            if (dispUrl.length() > 65) dispUrl = dispUrl.substring(0, 62) + "...";
            custom.drawText(font, dispUrl, urlX + 28.0F, 14.0F, ColorRGBA.WHITE);
        }

        // Open in Windows Browser Button
        float openBtnX = this.width - 146.0F;
        float btnW = 98.0F;
        float btnH = 26.0F;
        IIiii_Class8 btnRad = IIiii_Class8.I_method_893b2757(8.0F);
        custom.drawRoundedRect(openBtnX, 9.0F, btnW, btnH, btnRad, IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(220.0F));
        if (font != null) {
            String openTxt = "↗ В браузере";
            float ow = font.I_method_2c375926(openTxt);
            custom.drawText(font, openTxt, openBtnX + (btnW - ow) / 2.0F, 15.0F, ColorRGBA.WHITE);
        }

        // Close (✕) Button
        float closeX = this.width - 32.0F;
        if (boldFont != null) {
            custom.drawText(boldFont, "✕", closeX, 12.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 210.0F));
        }

        // --- 2. BROWSER VIEWPORT CONTENT ---
        float cx = this.width / 2.0F;

        // If Home / Empty Search -> Show Google Hero Logo & Shortcuts
        if (searchQuery.isEmpty()) {
            float heroY = 90.0F;
            if (titleFont != null) {
                // Multi-colored Google Letters
                float gX = cx - 55.0F;
                custom.drawText(titleFont, "G", gX, heroY, new ColorRGBA(66.0F, 133.0F, 244.0F));
                custom.drawText(titleFont, "o", gX + 16.0F, heroY, new ColorRGBA(234.0F, 67.0F, 53.0F));
                custom.drawText(titleFont, "o", gX + 30.0F, heroY, new ColorRGBA(251.0F, 188.0F, 5.0F));
                custom.drawText(titleFont, "g", gX + 44.0F, heroY, new ColorRGBA(66.0F, 133.0F, 244.0F));
                custom.drawText(titleFont, "l", gX + 58.0F, heroY, new ColorRGBA(52.0F, 168.0F, 83.0F));
                custom.drawText(titleFont, "e", gX + 66.0F, heroY, new ColorRGBA(234.0F, 67.0F, 53.0F));
            }

            // Big Center Search Input Box
            float sBoxW = Math.min(480.0F, this.width - 64.0F);
            float sBoxH = 40.0F;
            float sBoxX = cx - sBoxW / 2.0F;
            float sBoxY = heroY + 44.0F;
            IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(20.0F);
            custom.drawShadow(sBoxX, sBoxY, sBoxW, sBoxH, 20.0F, sRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F));
            custom.drawRoundedRect(sBoxX, sBoxY, sBoxW, sBoxH, sRad, new ColorRGBA(30.0F, 34.0F, 48.0F, 255.0F));
            custom.drawRoundedBorder(sBoxX, sBoxY, sBoxW, sBoxH, 1.2F, sRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 45.0F));

            if (font != null) {
                String searchPrompt = "🔍  Введите поисковый запрос и нажмите Enter...";
                custom.drawText(font, searchPrompt, sBoxX + 18.0F, sBoxY + 13.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 150.0F));
            }

            // Quick Shortcut Badges
            String[] pills = { "YouTube", "Minecraft Wiki", "FunTime", "VKontakte", "Discord", "GitHub" };
            float pStartX = cx - (pills.length * 70.0F) / 2.0F;
            float pY = sBoxY + 60.0F;
            for (int i = 0; i < pills.length; i++) {
                float px = pStartX + i * 72.0F;
                float pw = 66.0F;
                float ph = 26.0F;
                IIiii_Class8 pr = IIiii_Class8.I_method_893b2757(13.0F);
                custom.drawRoundedRect(px, pY, pw, ph, pr, new ColorRGBA(36.0F, 42.0F, 58.0F, 230.0F));
                custom.drawRoundedBorder(px, pY, pw, ph, 1.0F, pr, new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F));
                if (subFont != null) {
                    float tw = subFont.I_method_2c375926(pills[i]);
                    custom.drawText(subFont, pills[i], px + (pw - tw) / 2.0F, pY + 7.0F, ColorRGBA.WHITE);
                }
            }
        }

        // --- 3. SEARCH RESULTS LIST ---
        float resStartY = searchQuery.isEmpty() ? 275.0F : 62.0F;
        float cardW = Math.min(560.0F, this.width - 48.0F);
        float cardX = cx - cardW / 2.0F;

        int idx = 0;
        for (WebResult res : results) {
            float ry = resStartY + idx * 72.0F;
            if (ry + 64.0F > this.height) break;

            IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(10.0F);
            custom.drawRoundedRect(cardX, ry, cardW, 64.0F, cRad, new ColorRGBA(26.0F, 30.0F, 42.0F, 220.0F));
            custom.drawRoundedBorder(cardX, ry, cardW, 64.0F, 1.0F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

            if (subFont != null) {
                custom.drawText(subFont, res.url, cardX + 14.0F, ry + 8.0F, new ColorRGBA(156.0F, 163.0F, 175.0F));
            }
            if (boldFont != null) {
                custom.drawText(boldFont, res.title, cardX + 14.0F, ry + 22.0F, new ColorRGBA(147.0F, 197.0F, 253.0F));
            }
            if (subFont != null) {
                custom.drawText(subFont, res.snippet, cardX + 14.0F, ry + 42.0F, new ColorRGBA(209.0F, 213.0F, 219.0F));
            }
            idx++;
        }
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        // Close Button
        float closeX = this.width - 32.0F;
        if (mouseX >= closeX - 6.0F && mouseX <= closeX + 20.0F && mouseY >= 6.0F && mouseY <= 34.0F) {
            UISoundManager.playButtonClick();
            if (MinecraftClient.getInstance() != null) {
                MinecraftClient.getInstance().setScreen(this.parentScreen);
            }
            return;
        }

        // Open in Browser Button
        float openBtnX = this.width - 146.0F;
        if (mouseX >= openBtnX && mouseX <= openBtnX + 98.0F && mouseY >= 9.0F && mouseY <= 35.0F) {
            UISoundManager.playButtonClick();
            openInSystemBrowser(this.currentUrl);
            return;
        }

        // URL bar click (toggle editing)
        float urlX = 84.0F;
        float urlW = this.width - 240.0F;
        if (mouseX >= urlX && mouseX <= urlX + urlW && mouseY >= 8.0F && mouseY <= 36.0F) {
            isEditingUrl = true;
            return;
        } else {
            isEditingUrl = false;
        }

        // Search Results Clicks (Opens target link)
        float cx = this.width / 2.0F;
        float cardW = Math.min(560.0F, this.width - 48.0F);
        float cardX = cx - cardW / 2.0F;
        float resStartY = searchQuery.isEmpty() ? 275.0F : 62.0F;

        int idx = 0;
        for (WebResult res : results) {
            float ry = resStartY + idx * 72.0F;
            if (mouseX >= cardX && mouseX <= cardX + cardW && mouseY >= ry && mouseY <= ry + 64.0F) {
                UISoundManager.playButtonClick();
                openInSystemBrowser(res.url);
                return;
            }
            idx++;
        }

        // Quick Shortcuts
        if (searchQuery.isEmpty()) {
            float heroY = 90.0F;
            float sBoxH = 40.0F;
            float sBoxY = heroY + 44.0F;
            float pY = sBoxY + 60.0F;
            String[] urls = {
                "https://youtube.com", "https://minecraft.wiki", "https://funtime.su",
                "https://vk.com", "https://discord.com", "https://github.com"
            };
            float pStartX = cx - (urls.length * 70.0F) / 2.0F;
            for (int i = 0; i < urls.length; i++) {
                float px = pStartX + i * 72.0F;
                if (mouseX >= px && mouseX <= px + 66.0F && mouseY >= pY && mouseY <= pY + 26.0F) {
                    UISoundManager.playButtonClick();
                    openInSystemBrowser(urls[i]);
                    return;
                }
            }
        }
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (isEditingUrl) {
            if (chr >= 32 && chr != 127) {
                searchQuery += chr;
                return true;
            }
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            if (MinecraftClient.getInstance() != null) {
                MinecraftClient.getInstance().setScreen(this.parentScreen);
            }
            return true;
        }

        if (isEditingUrl) {
            if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !searchQuery.isEmpty()) {
                searchQuery = searchQuery.substring(0, searchQuery.length() - 1);
                return true;
            }
            if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
                isEditingUrl = false;
                if (!searchQuery.trim().isEmpty()) {
                    currentUrl = "https://www.google.com/search?q=" + URLEncoder.encode(searchQuery.trim(), StandardCharsets.UTF_8);
                } else {
                    currentUrl = "https://www.google.com";
                }
                buildResults();
                UISoundManager.playButtonClick();
                return true;
            }
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
