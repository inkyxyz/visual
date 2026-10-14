package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import pyrock.utility.render.ColorRGBA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Modern Apple / Liquid Glass World Loading Screen Renderer.
 * Provides cinematic world generation and connection animations.
 */
public class WorldLoadingScreenHelper {

    private static float animatedProgress = 0.0F;
    private static long startTime = 0L;
    private static final List<LoadingSparkle> sparkles = new ArrayList<>();
    private static final Random RNG = new Random(42);

    private static class LoadingSparkle {
        float x, y, size, speed, alpha, baseAlpha;
        float phase;

        void reset(float w, float h) {
            this.x = RNG.nextFloat() * w;
            this.y = h + RNG.nextFloat() * 40.0F;
            this.size = 1.5F + RNG.nextFloat() * 2.5F;
            this.speed = 0.4F + RNG.nextFloat() * 0.9F;
            this.baseAlpha = 70.0F + RNG.nextFloat() * 120.0F;
            this.phase = RNG.nextFloat() * 6.28F;
        }

        void update(float w, float h) {
            this.y -= this.speed;
            this.phase += 0.04F;
            this.alpha = this.baseAlpha * (0.6F + 0.4F * (float)Math.sin(this.phase));
            if (this.y < -10.0F) {
                reset(w, h);
            }
        }
    }

    public static void renderLoadingScreen(III custom, int width, int height, float rawProgress, String titleText, String statusText) {
        long now = System.currentTimeMillis();
        if (startTime == 0L) {
            startTime = now;
            sparkles.clear();
            for (int i = 0; i < 35; i++) {
                LoadingSparkle s = new LoadingSparkle();
                s.reset(width, height);
                s.y = RNG.nextFloat() * height; // initial scatter
                sparkles.add(s);
            }
        }

        float elapsedSec = (now - startTime) / 1000.0F;

        // Smoothly interpolate progress towards target (or simulate smooth flow if rawProgress <= 0)
        float targetProg = rawProgress > 0.0F ? MathHelper.clamp(rawProgress, 0.0F, 1.0F) : Math.min(0.92F, elapsedSec * 0.28F);
        animatedProgress += (targetProg - animatedProgress) * 0.12F;

        // 1. Unified Background (Wallpaper or ambient)
        ThemeAndBackgroundManager.getInstance().renderActiveBackground(custom, width, height, width / 2.0F, height / 2.0F);

        // 2. Ambient Floating Sparkles
        for (LoadingSparkle s : sparkles) {
            s.update(width, height);
            custom.drawRoundedRect(s.x, s.y, s.size, s.size, IIiii_Class8.I_method_893b2757(s.size / 2.0F),
                ColorRGBA.WHITE.withAlpha(s.alpha));
        }

        float cx = width / 2.0F;
        float cy = height / 2.0F;
        ColorRGBA theme = ThemeAndBackgroundManager.getInstance().getThemeColor();
        ColorRGBA themeSec = ThemeAndBackgroundManager.getInstance().getThemeSecondaryColor();

        // 3. Central Apple Liquid Glass Card (340 x 210)
        float cardW = 340.0F;
        float cardH = 210.0F;
        float cardX = cx - cardW / 2.0F;
        float cardY = cy - cardH / 2.0F;
        IIiii_Class8 cardRad = IIiii_Class8.I_method_893b2757(20.0F);

        // Ambient theme glow behind card
        float pulse = (float)Math.sin(elapsedSec * 2.5F) * 0.15F + 0.85F;
        custom.drawShadow(cardX, cardY, cardW, cardH, 28.0F, cardRad, theme.withAlpha(55.0F * pulse));
        custom.drawBlurredRect(cardX, cardY, cardW, cardH, 20.0F, 4.0F, cardRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 12.0F));
        custom.drawRoundedRect(cardX, cardY, cardW, cardH, cardRad, new ColorRGBA(14.0F, 18.0F, 28.0F, 215.0F));
        custom.drawRoundedBorder(cardX, cardY, cardW, cardH, 0.9F, cardRad, theme.withAlpha(140.0F + 50.0F * pulse));

        // Top specular gleam line
        custom.drawRoundedRect(cardX + 16.0F, cardY + 1.5F, cardW - 32.0F, 1.0F, IIiii_Class8.I_method_893b2757(0.5F),
            new ColorRGBA(255.0F, 255.0F, 255.0F, 45.0F));

        // 4. Animated Concentric Orbiting Spinner & Icon (Top center of card)
        float iconCenterY = cardY + 54.0F;
        float outerRingRadius = 24.0F;

        // Outer pulsing orbital ring
        custom.drawRoundedBorder(cx - outerRingRadius, iconCenterY - outerRingRadius, outerRingRadius * 2.0F, outerRingRadius * 2.0F,
            1.2F, IIiii_Class8.I_method_893b2757(outerRingRadius), theme.withAlpha(65.0F * pulse));

        // 4 Rotating orbital dots around the ring
        for (int i = 0; i < 4; i++) {
            double angle = elapsedSec * 3.2 + i * (Math.PI / 2.0);
            float dotX = cx + (float)Math.cos(angle) * outerRingRadius - 2.5F;
            float dotY = iconCenterY + (float)Math.sin(angle) * outerRingRadius - 2.5F;
            float dotAlpha = 140.0F + 100.0F * (float)Math.sin(angle);
            custom.drawRoundedRect(dotX, dotY, 5.0F, 5.0F, IIiii_Class8.I_method_893b2757(2.5F), themeSec.withAlpha(dotAlpha));
        }

        // Inner glowing core sphere (layered holographic cyber-sphere)
        float coreRadius = 18.0F;
        custom.drawShadow(cx - coreRadius, iconCenterY - coreRadius, coreRadius * 2.0F, coreRadius * 2.0F, 16.0F,
            IIiii_Class8.I_method_893b2757(coreRadius), theme.withAlpha(140.0F * pulse));
        custom.drawRoundedRect(cx - coreRadius, iconCenterY - coreRadius, coreRadius * 2.0F, coreRadius * 2.0F,
            IIiii_Class8.I_method_893b2757(coreRadius), new ColorRGBA(22.0F, 30.0F, 48.0F, 235.0F));
        custom.drawRoundedBorder(cx - coreRadius, iconCenterY - coreRadius, coreRadius * 2.0F, coreRadius * 2.0F,
            1.0F, IIiii_Class8.I_method_893b2757(coreRadius), theme.withAlpha(220.0F));

        // Holographic latitude ring
        custom.drawRoundedBorder(cx - coreRadius + 2.0F, iconCenterY - 7.0F, (coreRadius - 2.0F) * 2.0F, 14.0F,
            0.8F, IIiii_Class8.I_method_893b2757(7.0F), themeSec.withAlpha(150.0F));

        // Specular 3D gleam at top-left of sphere
        custom.drawRoundedRect(cx - 10.0F, iconCenterY - 12.0F, 8.0F, 4.0F, IIiii_Class8.I_method_893b2757(2.0F),
            new ColorRGBA(255.0F, 255.0F, 255.0F, 150.0F));

        // Glowing world texture emblem
        custom.drawIcon("hud/world", cx - 12.0F, iconCenterY - 12.0F, 24.0F, ColorRGBA.WHITE);

        // 5. Title & Status Text
        IIiIIi_Class10 boldFont = IIiIiI_Class11.i_field_857c0621 != null ? IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F) : null;
        IIiIIi_Class10 subFont = IIiIiI_Class11.II_field_857c0621 != null ? IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F) : null;

        String mainTitle = titleText != null && !titleText.isEmpty() ? titleText : "Загрузка мира";
        if (boldFont != null) {
            float tw = boldFont.I_method_2c375926(mainTitle);
            custom.drawText(boldFont, mainTitle, cx - tw / 2.0F, cardY + 98.0F, ColorRGBA.WHITE);
        }

        // Animated dots for status
        int dotCount = (int)(elapsedSec * 2.5F) % 4;
        String dots = ".".repeat(dotCount);
        String subStatus = (statusText != null && !statusText.isEmpty() ? statusText : "Подготовка чанков и местности") + dots;
        if (subFont != null) {
            float sw = subFont.I_method_2c375926(subStatus);
            custom.drawText(subFont, subStatus, cx - sw / 2.0F, cardY + 118.0F, new ColorRGBA(190.0F, 210.0F, 240.0F, 200.0F));
        }

        // 6. Liquid Progress Bar & Shimmer
        float barW = 250.0F;
        float barH = 6.0F;
        float barX = cx - barW / 2.0F;
        float barY = cardY + 144.0F;
        IIiii_Class8 barRad = IIiii_Class8.I_method_893b2757(barH / 2.0F);

        // Bar track
        custom.drawRoundedRect(barX, barY, barW, barH, barRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));
        custom.drawRoundedBorder(barX, barY, barW, barH, 0.5F, barRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F));

        // Bar fill
        float fillW = barW * animatedProgress;
        if (fillW > 4.0F) {
            custom.drawShadow(barX, barY, fillW, barH, 8.0F, barRad, theme.withAlpha(95.0F));
            custom.drawRoundedRect(barX, barY, fillW, barH, barRad, theme);

            // Moving shimmer beam
            float shimmerPos = ((elapsedSec * 180.0F) % (barW + 40.0F)) - 20.0F;
            if (shimmerPos < fillW) {
                float shmW = Math.min(24.0F, fillW - shimmerPos);
                if (shmW > 0.0F && shimmerPos >= 0.0F) {
                    custom.drawRoundedRect(barX + shimmerPos, barY, shmW, barH, barRad,
                        new ColorRGBA(255.0F, 255.0F, 255.0F, 120.0F));
                }
            }
        }

        // 7. Progress Percentage Pill Badge
        int pctInt = (int)(animatedProgress * 100.0F);
        String pctStr = pctInt + "%";
        if (subFont != null) {
            float pw = subFont.I_method_2c375926(pctStr);
            float badgeW = pw + 16.0F;
            float badgeH = 17.0F;
            float badgeX = cx - badgeW / 2.0F;
            float badgeY = barY + 18.0F;
            IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(badgeH / 2.0F);

            custom.drawRoundedRect(badgeX, badgeY, badgeW, badgeH, bRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
            custom.drawRoundedBorder(badgeX, badgeY, badgeW, badgeH, 0.6F, bRad, theme.withAlpha(120.0F));
            custom.drawText(subFont, pctStr, badgeX + (badgeW - pw) / 2.0F, badgeY + 4.5F, themeSec);
        }
    }
}
