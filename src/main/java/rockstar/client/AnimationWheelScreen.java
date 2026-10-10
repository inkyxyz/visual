package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.sound.SoundEvents;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class AnimationWheelScreen extends ii_Class4 {

    private static final AnimationWheelModule.CustomAnimation[][] PAGES = {
        {
            AnimationWheelModule.CustomAnimation.FLOSS,
            AnimationWheelModule.CustomAnimation.TAKE_THE_L,
            AnimationWheelModule.CustomAnimation.DEFAULT_DANCE,
            AnimationWheelModule.CustomAnimation.ORANGE_JUSTICE,
            AnimationWheelModule.CustomAnimation.GRIDDY,
            AnimationWheelModule.CustomAnimation.HYPE,
            AnimationWheelModule.CustomAnimation.BACKFLIP,
            AnimationWheelModule.CustomAnimation.WAVE,
            AnimationWheelModule.CustomAnimation.CLAP,
            AnimationWheelModule.CustomAnimation.T_POSE
        },
        {
            AnimationWheelModule.CustomAnimation.FLEX,
            AnimationWheelModule.CustomAnimation.FACEPALM,
            AnimationWheelModule.CustomAnimation.SALUTE,
            AnimationWheelModule.CustomAnimation.BOW,
            AnimationWheelModule.CustomAnimation.LAUGH,
            AnimationWheelModule.CustomAnimation.SHRUG,
            AnimationWheelModule.CustomAnimation.DAB,
            AnimationWheelModule.CustomAnimation.SIT,
            AnimationWheelModule.CustomAnimation.SPIN,
            AnimationWheelModule.CustomAnimation.NONE
        }
    };

    private static final String[][] PAGE_RARITIES = {
        {
            "Эпический танец",
            "Легендарный танец",
            "Классический танец",
            "Редкий танец",
            "Эпический танец",
            "Эпический танец",
            "Акробатика",
            "Приветствие",
            "Аплодисменты",
            "Особая поза"
        },
        {
            "Флекс мышцами",
            "Фейспалм жест",
            "Воинское приветствие",
            "Глубокий поклон",
            "Искренний смех",
            "Пожатие плечами",
            "Дэб движение",
            "Релакс поза",
            "Сальто-вертушка",
            "Сбросить анимацию"
        }
    };

    private static final String[] PAGE_TITLES = {
        "Танцы & Движения",
        "Эмоции & Позы"
    };

    private static int currentPage = 0;
    private float openAnim = 0.0F;
    private int hoveredIndex = -1;
    private int lastSoundSlot = -1;
    private final float[] hoverAnims = new float[10];

    public AnimationWheelScreen() {
    }

    public static void nextPage() {
        currentPage = (currentPage + 1) % PAGES.length;
    }

    public static void prevPage() {
        currentPage = (currentPage - 1 + PAGES.length) % PAGES.length;
    }

    @Override
    public void render(III var1) {
        int mx = var1.I_method_b1c3e152();
        int my = var1.i_method_b1d26d32();
        float delta = var1.I_method_b1c3e14f();

        // Smooth opening zoom animation
        this.openAnim += (1.0F - this.openAnim) * 0.28F;

        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;

        // Dark ambient vignette backdrop
        var1.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(4.0F, 6.0F, 10.0F, 175.0F * this.openAnim));

        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        IIiIIi_Class10 font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.5F);
        IIiIIi_Class10 boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.5F);
        IIiIIi_Class10 tagFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F);
        IIiIIi_Class10 subFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
        IIiIIi_Class10 badgeFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F);

        float dx = mx - cx;
        float dy = my - cy;
        double dist = Math.sqrt(dx * dx + dy * dy);
        double mouseAngle = Math.atan2(dy, dx);

        AnimationWheelModule.CustomAnimation[] activeSlots = PAGES[currentPage];
        String[] activeRarities = PAGE_RARITIES[currentPage];

        // Determine hovered slot in radial coordinate space
        // Top slot (index 0) starts straight up at -90 degrees (-PI/2)
        this.hoveredIndex = -1;
        if (dist > 45.0 && dist < 170.0) {
            double normAngle = mouseAngle + Math.PI / 2.0;
            if (normAngle < 0) normAngle += Math.PI * 2.0;
            double sectorSize = (Math.PI * 2.0) / activeSlots.length;
            int idx = (int) Math.round(normAngle / sectorSize) % activeSlots.length;
            this.hoveredIndex = idx;
        }

        // Play subtle tick sound when moving to a new slot
        if (this.hoveredIndex != this.lastSoundSlot && this.hoveredIndex >= 0) {
            if (MinecraftClient.getInstance().player != null) {
                MinecraftClient.getInstance().player.playSound(SoundEvents.UI_HUD_BUBBLE_POP, 0.4F, 1.35F);
            }
            this.lastSoundSlot = this.hoveredIndex;
        } else if (this.hoveredIndex < 0) {
            this.lastSoundSlot = -1;
        }

        // Update smooth hover animations for each sector
        for (int i = 0; i < activeSlots.length; i++) {
            float target = (i == this.hoveredIndex) ? 1.0F : 0.0F;
            this.hoverAnims[i] += (target - this.hoverAnims[i]) * 0.28F;
        }

        var1.getMatrices().push();
        var1.getMatrices().translate(cx, cy, 0.0F);
        var1.getMatrices().scale(this.openAnim, this.openAnim, 1.0F);
        var1.getMatrices().translate(-cx, -cy, 0.0F);

        // Page switcher header above the wheel
        float pageBarW = 190.0F;
        float pageBarH = 24.0F;
        float pageBarX = cx - pageBarW / 2.0F;
        float pageBarY = cy - 182.0F;
        var1.drawRoundedRect(pageBarX, pageBarY, pageBarW, pageBarH, IIiii_Class8.I_method_893b2757(pageBarH / 2.0F), new ColorRGBA(14.0F, 17.0F, 26.0F, 220.0F));
        var1.drawRoundedBorder(pageBarX, pageBarY, pageBarW, pageBarH, 1.0F, IIiii_Class8.I_method_893b2757(pageBarH / 2.0F), theme.withAlpha(120.0F));

        String pageLabel = "◀  " + PAGE_TITLES[currentPage] + " (" + (currentPage + 1) + "/" + PAGES.length + ")  ▶";
        float plW = subFont.I_method_2c375926(pageLabel);
        var1.drawText(subFont, pageLabel, cx - plW / 2.0F, pageBarY + 8.0F, ColorRGBA.WHITE);

        String pageHint = "[ Q / E или Колёсико мыши для смены страницы ]";
        float phW = tagFont.I_method_2c375926(pageHint);
        var1.drawText(tagFont, pageHint, cx - phW / 2.0F, pageBarY - 11.0F, new ColorRGBA(160.0F, 170.0F, 190.0F, 180.0F));

        // Ambient outer glow behind hovered wedge
        if (this.hoveredIndex >= 0) {
            double activeAngle = (this.hoveredIndex * (Math.PI * 2.0 / activeSlots.length)) - Math.PI / 2.0;
            float glowX = cx + (float) Math.cos(activeAngle) * 115.0F;
            float glowY = cy + (float) Math.sin(activeAngle) * 115.0F;
            var1.drawBlurredRect(glowX - 45.0F, glowY - 30.0F, 90.0F, 60.0F, 28.0F, 5.0F, IIiii_Class8.I_method_893b2757(16.0F), theme.withAlpha(120.0F * this.hoverAnims[this.hoveredIndex]));
        }

        // ========================================================
        // 1. RENDER TRUE CURVED RADIAL PIE SECTORS (TESSELLATED)
        // ========================================================
        float baseRIn = 52.0F;
        float baseROut = 142.0F;
        double sectorSpan = (Math.PI * 2.0) / activeSlots.length;
        double gapRad = Math.toRadians(3.2); // Sleek divider gap between sectors

        var1.draw(); // Flush 2D batch
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        BufferBuilder buf = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        Matrix4f mat = var1.getMatrices().peek().getPositionMatrix();

        for (int i = 0; i < activeSlots.length; i++) {
            double midA = (i * sectorSpan) - Math.PI / 2.0;
            double startA = midA - (sectorSpan / 2.0) + (gapRad / 2.0);
            double endA = midA + (sectorSpan / 2.0) - (gapRad / 2.0);

            float hProg = this.hoverAnims[i];
            boolean isCurActive = (AnimationWheelModule.getActiveAnimation() == activeSlots[i]);

            float curRIn = baseRIn - 2.0F * hProg;
            float curROut = baseROut + 8.0F * hProg;

            // Sector fill colors
            ColorRGBA inCol;
            ColorRGBA outCol;
            if (hProg > 0.05F) {
                // Hovered: vibrant theme gradient illumination
                inCol = theme.withAlpha(150.0F + 80.0F * hProg);
                outCol = theme.withAlpha(200.0F + 55.0F * hProg);
            } else if (isCurActive) {
                // Currently playing animation
                inCol = new ColorRGBA(28.0F, 34.0F, 50.0F, 220.0F);
                outCol = theme.withAlpha(140.0F);
            } else {
                // Sleek dark frosted glass wedge
                inCol = new ColorRGBA(12.0F, 14.0F, 20.0F, 190.0F);
                outCol = new ColorRGBA(18.0F, 22.0F, 32.0F, 215.0F);
            }

            renderSector(mat, buf, cx, cy, curRIn, curROut, startA, endA, inCol, outCol);

            // Outer curved rim border
            ColorRGBA rimCol;
            float rimThickness;
            if (hProg > 0.05F) {
                rimCol = ColorRGBA.WHITE.withAlpha(200.0F + 55.0F * hProg);
                rimThickness = 2.4F;
            } else if (isCurActive) {
                rimCol = theme.withAlpha(200.0F);
                rimThickness = 1.8F;
            } else {
                rimCol = new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F);
                rimThickness = 1.2F;
            }
            renderSectorRim(mat, buf, cx, cy, curROut, startA, endA, rimThickness, rimCol);

            // Inner curved border
            ColorRGBA innerBorderCol = (hProg > 0.05F) ? ColorRGBA.WHITE.withAlpha(180.0F * hProg) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F);
            renderSectorInnerRim(mat, buf, cx, cy, curRIn, startA, endA, 1.0F, innerBorderCol);
        }

        BufferRenderer.drawWithGlobalProgram(buf.end());
        RenderSystem.disableBlend();

        // ========================================================
        // 2. RENDER LABELS & BADGES INSIDE EACH SECTOR
        // ========================================================
        for (int i = 0; i < activeSlots.length; i++) {
            double midA = (i * sectorSpan) - Math.PI / 2.0;
            float hProg = this.hoverAnims[i];
            boolean isCurActive = (AnimationWheelModule.getActiveAnimation() == activeSlots[i]);

            float curROut = baseROut + 8.0F * hProg;
            float midR = (baseRIn + curROut) / 2.0F + 4.0F * hProg;

            float secX = cx + (float) Math.cos(midA) * midR;
            float secY = cy + (float) Math.sin(midA) * midR;

            // Slot number pill badge near inner edge
            float badgeR = baseRIn + 15.0F + 2.0F * hProg;
            float bX = cx + (float) Math.cos(midA) * badgeR;
            float bY = cy + (float) Math.sin(midA) * badgeR;
            float bSz = 14.0F;

            ColorRGBA bBg = (hProg > 0.05F) ? ColorRGBA.WHITE.withAlpha(220.0F) : (isCurActive ? theme : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
            ColorRGBA bText = (hProg > 0.05F) ? new ColorRGBA(10.0F, 12.0F, 18.0F, 255.0F) : ColorRGBA.WHITE;
            var1.drawRoundedRect(bX - bSz / 2.0F, bY - bSz / 2.0F, bSz, bSz, IIiii_Class8.I_method_893b2757(bSz / 2.0F), bBg);
            String slotNumStr = String.valueOf(i + 1);
            float snW = badgeFont.I_method_2c375926(slotNumStr);
            var1.drawText(badgeFont, slotNumStr, bX - snW / 2.0F, bY - 4.0F, bText);

            // Emote Name in center of sector
            String slotTitle = activeSlots[i].getTitle();
            float textW = font.I_method_2c375926(slotTitle);
            float textH = font.I_method_a649725c();

            ColorRGBA textCol = (hProg > 0.05F) ? ColorRGBA.WHITE : (isCurActive ? theme : new ColorRGBA(220.0F, 225.0F, 238.0F, 230.0F));
            var1.drawText(font, slotTitle, secX - textW / 2.0F, secY - textH / 2.0F, textCol);

            // Category tag under name
            String catText = activeSlots[i].getCategory();
            float catW = tagFont.I_method_2c375926(catText);
            ColorRGBA catCol = (hProg > 0.05F) ? ColorRGBA.WHITE.withAlpha(200.0F) : new ColorRGBA(160.0F, 170.0F, 195.0F, 160.0F);
            var1.drawText(tagFont, catText, secX - catW / 2.0F, secY + textH / 2.0F + 1.0F, catCol);
        }

        // ========================================================
        // 3. CENTER HUB (FORTNITE CORE WITH DYNAMIC PREVIEW)
        // ========================================================
        float centerR = 48.0F;
        IIiii_Class8 radCenter = IIiii_Class8.I_method_893b2757(centerR);

        // Core frosted glass backdrop & glowing border
        var1.drawBlurredRect(cx - centerR, cy - centerR, centerR * 2.0F, centerR * 2.0F, 22.0F, 5.0F, radCenter, theme.withAlpha(110.0F));
        var1.drawRoundedRect(cx - centerR, cy - centerR, centerR * 2.0F, centerR * 2.0F, radCenter, new ColorRGBA(9.0F, 11.0F, 17.0F, 250.0F));
        var1.drawRoundedBorder(cx - centerR, cy - centerR, centerR * 2.0F, centerR * 2.0F, 1.8F, radCenter, theme);

        // Inner decorative circle ring
        float innerRingR = centerR - 6.0F;
        var1.drawRoundedBorder(cx - innerRingR, cy - innerRingR, innerRingR * 2.0F, innerRingR * 2.0F, 0.8F, IIiii_Class8.I_method_893b2757(innerRingR), new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        // Center hub display content
        if (this.hoveredIndex >= 0 && this.hoveredIndex < activeSlots.length) {
            AnimationWheelModule.CustomAnimation hoveredAnim = activeSlots[this.hoveredIndex];

            // Slot badge indicator (e.g. "СЛОТ #1")
            String slotLabel = "СЛОТ #" + (this.hoveredIndex + 1);
            float slW = tagFont.I_method_2c375926(slotLabel);
            var1.drawText(tagFont, slotLabel, cx - slW / 2.0F, cy - 26.0F, theme);

            // Bold Emote Name
            String title = hoveredAnim.getTitle().toUpperCase();
            float titleW = boldFont.I_method_2c375926(title);
            var1.drawText(boldFont, title, cx - titleW / 2.0F, cy - 12.0F, ColorRGBA.WHITE);

            // Rarity / Description pill
            String rarity = activeRarities[this.hoveredIndex];
            float rw = tagFont.I_method_2c375926(rarity);
            float pillW = rw + 12.0F;
            float pillH = 13.0F;
            var1.drawRoundedRect(cx - pillW / 2.0F, cy + 4.0F, pillW, pillH, IIiii_Class8.I_method_893b2757(pillH / 2.0F), theme.withAlpha(50.0F));
            var1.drawRoundedBorder(cx - pillW / 2.0F, cy + 4.0F, pillW, pillH, 0.8F, IIiii_Class8.I_method_893b2757(pillH / 2.0F), theme.withAlpha(160.0F));
            var1.drawText(tagFont, rarity, cx - rw / 2.0F, cy + 6.5F, theme);

            // Action prompt
            String hint = "[ Отпустите B ]";
            float hintW = subFont.I_method_2c375926(hint);
            var1.drawText(subFont, hint, cx - hintW / 2.0F, cy + 22.0F, new ColorRGBA(220.0F, 225.0F, 240.0F, 220.0F));
        } else {
            // Idle hub state (center emblem)
            String star = "★";
            float starW = boldFont.I_method_2c375926(star);
            var1.drawText(boldFont, star, cx - starW / 2.0F, cy - 24.0F, theme);

            String mainTitle = "ЭМОЦИИ";
            float mtW = boldFont.I_method_2c375926(mainTitle);
            var1.drawText(boldFont, mainTitle, cx - mtW / 2.0F, cy - 8.0F, ColorRGBA.WHITE);

            String sub = "20 движений";
            float subW = tagFont.I_method_2c375926(sub);
            var1.drawText(tagFont, sub, cx - subW / 2.0F, cy + 7.0F, theme.withAlpha(200.0F));

            String guide = "Стр. " + (currentPage + 1) + " / " + PAGES.length;
            float guideW = subFont.I_method_2c375926(guide);
            var1.drawText(subFont, guide, cx - guideW / 2.0F, cy + 21.0F, new ColorRGBA(160.0F, 170.0F, 190.0F, 170.0F));
        }

        // ========================================================
        // 4. DIRECTIONAL COMPASS NEEDLE
        // ========================================================
        if (dist > 18.0) {
            float needleDist = centerR + 1.0F;
            float nX = cx + (float) Math.cos(mouseAngle) * needleDist;
            float nY = cy + (float) Math.sin(mouseAngle) * needleDist;

            float pAngle1 = (float) (mouseAngle + Math.PI / 2.0);
            float pAngle2 = (float) (mouseAngle - Math.PI / 2.0);
            float baseW = 5.0F;
            float tipLen = 7.0F;

            float tipX = cx + (float) Math.cos(mouseAngle) * (needleDist + tipLen);
            float tipY = cy + (float) Math.sin(mouseAngle) * (needleDist + tipLen);
            float b1X = nX + (float) Math.cos(pAngle1) * baseW;
            float b1Y = nY + (float) Math.sin(pAngle1) * baseW;
            float b2X = nX + (float) Math.cos(pAngle2) * baseW;
            float b2Y = nY + (float) Math.sin(pAngle2) * baseW;

            // Draw directional pointer triangle
            var1.draw();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
            BufferBuilder nBuf = Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
            Matrix4f nMat = var1.getMatrices().peek().getPositionMatrix();

            ColorRGBA pointerCol = (this.hoveredIndex >= 0) ? ColorRGBA.WHITE : theme;
            nBuf.vertex(nMat, b1X, b1Y, 0.0F).color(pointerCol.getRed() / 255.0F, pointerCol.getGreen() / 255.0F, pointerCol.getBlue() / 255.0F, pointerCol.getAlpha() / 255.0F);
            nBuf.vertex(nMat, tipX, tipY, 0.0F).color(pointerCol.getRed() / 255.0F, pointerCol.getGreen() / 255.0F, pointerCol.getBlue() / 255.0F, pointerCol.getAlpha() / 255.0F);
            nBuf.vertex(nMat, b2X, b2Y, 0.0F).color(pointerCol.getRed() / 255.0F, pointerCol.getGreen() / 255.0F, pointerCol.getBlue() / 255.0F, pointerCol.getAlpha() / 255.0F);

            BufferRenderer.drawWithGlobalProgram(nBuf.end());
            RenderSystem.disableBlend();
        }

        var1.getMatrices().pop();
    }

    private static void renderSector(Matrix4f mat, BufferBuilder buf, float cx, float cy, float rIn, float rOut, double startAngle, double endAngle, ColorRGBA innerCol, ColorRGBA outerCol) {
        int subSegs = 12;
        float inR = innerCol.getRed() / 255.0F;
        float inG = innerCol.getGreen() / 255.0F;
        float inB = innerCol.getBlue() / 255.0F;
        float inA = innerCol.getAlpha() / 255.0F;

        float outR = outerCol.getRed() / 255.0F;
        float outG = outerCol.getGreen() / 255.0F;
        float outB = outerCol.getBlue() / 255.0F;
        float outA = outerCol.getAlpha() / 255.0F;

        for (int s = 0; s < subSegs; s++) {
            double a1 = startAngle + (endAngle - startAngle) * ((double) s / subSegs);
            double a2 = startAngle + (endAngle - startAngle) * ((double) (s + 1) / subSegs);

            float cos1 = (float) Math.cos(a1);
            float sin1 = (float) Math.sin(a1);
            float cos2 = (float) Math.cos(a2);
            float sin2 = (float) Math.sin(a2);

            float inX1 = cx + cos1 * rIn;
            float inY1 = cy + sin1 * rIn;
            float inX2 = cx + cos2 * rIn;
            float inY2 = cy + sin2 * rIn;

            float outX1 = cx + cos1 * rOut;
            float outY1 = cy + sin1 * rOut;
            float outX2 = cx + cos2 * rOut;
            float outY2 = cy + sin2 * rOut;

            buf.vertex(mat, inX1, inY1, 0.0F).color(inR, inG, inB, inA);
            buf.vertex(mat, inX2, inY2, 0.0F).color(inR, inG, inB, inA);
            buf.vertex(mat, outX2, outY2, 0.0F).color(outR, outG, outB, outA);
            buf.vertex(mat, outX1, outY1, 0.0F).color(outR, outG, outB, outA);
        }
    }

    private static void renderSectorRim(Matrix4f mat, BufferBuilder buf, float cx, float cy, float rOut, double startAngle, double endAngle, float thickness, ColorRGBA rimCol) {
        int subSegs = 12;
        float rOutInner = rOut - thickness;
        float r = rimCol.getRed() / 255.0F;
        float g = rimCol.getGreen() / 255.0F;
        float b = rimCol.getBlue() / 255.0F;
        float a = rimCol.getAlpha() / 255.0F;

        for (int s = 0; s < subSegs; s++) {
            double a1 = startAngle + (endAngle - startAngle) * ((double) s / subSegs);
            double a2 = startAngle + (endAngle - startAngle) * ((double) (s + 1) / subSegs);

            float cos1 = (float) Math.cos(a1);
            float sin1 = (float) Math.sin(a1);
            float cos2 = (float) Math.cos(a2);
            float sin2 = (float) Math.sin(a2);

            float inX1 = cx + cos1 * rOutInner;
            float inY1 = cy + sin1 * rOutInner;
            float inX2 = cx + cos2 * rOutInner;
            float inY2 = cy + sin2 * rOutInner;

            float outX1 = cx + cos1 * rOut;
            float outY1 = cy + sin1 * rOut;
            float outX2 = cx + cos2 * rOut;
            float outY2 = cy + sin2 * rOut;

            buf.vertex(mat, inX1, inY1, 0.0F).color(r, g, b, a);
            buf.vertex(mat, inX2, inY2, 0.0F).color(r, g, b, a);
            buf.vertex(mat, outX2, outY2, 0.0F).color(r, g, b, a);
            buf.vertex(mat, outX1, outY1, 0.0F).color(r, g, b, a);
        }
    }

    private static void renderSectorInnerRim(Matrix4f mat, BufferBuilder buf, float cx, float cy, float rIn, double startAngle, double endAngle, float thickness, ColorRGBA rimCol) {
        int subSegs = 12;
        float rInOuter = rIn + thickness;
        float r = rimCol.getRed() / 255.0F;
        float g = rimCol.getGreen() / 255.0F;
        float b = rimCol.getBlue() / 255.0F;
        float a = rimCol.getAlpha() / 255.0F;

        for (int s = 0; s < subSegs; s++) {
            double a1 = startAngle + (endAngle - startAngle) * ((double) s / subSegs);
            double a2 = startAngle + (endAngle - startAngle) * ((double) (s + 1) / subSegs);

            float cos1 = (float) Math.cos(a1);
            float sin1 = (float) Math.sin(a1);
            float cos2 = (float) Math.cos(a2);
            float sin2 = (float) Math.sin(a2);

            float inX1 = cx + cos1 * rIn;
            float inY1 = cy + sin1 * rIn;
            float inX2 = cx + cos2 * rIn;
            float inY2 = cy + sin2 * rIn;

            float outX1 = cx + cos1 * rInOuter;
            float outY1 = cy + sin1 * rInOuter;
            float outX2 = cx + cos2 * rInOuter;
            float outY2 = cy + sin2 * rInOuter;

            buf.vertex(mat, inX1, inY1, 0.0F).color(r, g, b, a);
            buf.vertex(mat, inX2, inY2, 0.0F).color(r, g, b, a);
            buf.vertex(mat, outX2, outY2, 0.0F).color(r, g, b, a);
            buf.vertex(mat, outX1, outY1, 0.0F).color(r, g, b, a);
        }
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        float cx = this.width / 2.0F;
        float cy = this.height / 2.0F;
        float pageBarW = 190.0F;
        float pageBarH = 24.0F;
        float pageBarX = cx - pageBarW / 2.0F;
        float pageBarY = cy - 182.0F;

        if (mouseX >= pageBarX && mouseX <= pageBarX + pageBarW && mouseY >= pageBarY && mouseY <= pageBarY + pageBarH) {
            if (mouseX < cx) {
                prevPage();
            } else {
                nextPage();
            }
            if (MinecraftClient.getInstance().player != null) {
                MinecraftClient.getInstance().player.playSound(SoundEvents.UI_BUTTON_CLICK.value(), 0.5F, 1.2F);
            }
            return;
        }

        AnimationWheelModule.CustomAnimation[] activeSlots = PAGES[currentPage];
        if (this.hoveredIndex >= 0 && this.hoveredIndex < activeSlots.length) {
            AnimationWheelModule.playAnimation(activeSlots[this.hoveredIndex]);
            this.close();
        }
    }

    @Override
    public void onMouseReleased(double mouseX, double mouseY, IiIII_Class9 button) {
        AnimationWheelModule.CustomAnimation[] activeSlots = PAGES[currentPage];
        if (this.hoveredIndex >= 0 && this.hoveredIndex < activeSlots.length) {
            AnimationWheelModule.playAnimation(activeSlots[this.hoveredIndex]);
            this.close();
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (verticalAmount > 0) {
            prevPage();
            if (MinecraftClient.getInstance().player != null) {
                MinecraftClient.getInstance().player.playSound(SoundEvents.UI_BUTTON_CLICK.value(), 0.35F, 1.4F);
            }
            return true;
        } else if (verticalAmount < 0) {
            nextPage();
            if (MinecraftClient.getInstance().player != null) {
                MinecraftClient.getInstance().player.playSound(SoundEvents.UI_BUTTON_CLICK.value(), 0.35F, 1.4F);
            }
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        int wheelKey = AnimationWheelModule.getInstance() != null ? AnimationWheelModule.getInstance().getWheelKey() : GLFW.GLFW_KEY_B;
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            this.close();
            return true;
        }
        if (keyCode == GLFW.GLFW_KEY_A || keyCode == GLFW.GLFW_KEY_LEFT || keyCode == GLFW.GLFW_KEY_Q) {
            prevPage();
            return true;
        }
        if (keyCode == GLFW.GLFW_KEY_D || keyCode == GLFW.GLFW_KEY_RIGHT || keyCode == GLFW.GLFW_KEY_E) {
            nextPage();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        int wheelKey = AnimationWheelModule.getInstance() != null ? AnimationWheelModule.getInstance().getWheelKey() : GLFW.GLFW_KEY_B;
        // Releasing the animation wheel key (B) executes the currently hovered emote (Fortnite style!)
        if (wheelKey > 0 && keyCode == wheelKey) {
            AnimationWheelModule.CustomAnimation[] activeSlots = PAGES[currentPage];
            if (this.hoveredIndex >= 0 && this.hoveredIndex < activeSlots.length) {
                AnimationWheelModule.playAnimation(activeSlots[this.hoveredIndex]);
            }
            this.close();
            return true;
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }
}
