package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class MinesweeperScreen extends ii_Class4 {
    private final Screen parentScreen;

    private static final int COLS = 12;
    private static final int ROWS = 12;
    private static final int MINES = 18;

    private static class Cell {
        boolean isMine;
        boolean isRevealed;
        boolean isFlagged;
        int adjacentMines;
    }

    private final Cell[][] grid = new Cell[ROWS][COLS];
    private boolean firstClickDone = false;
    private boolean isGameOver = false;
    private boolean isWon = false;
    private long startTime = 0L;
    private long elapsedSec = 0L;
    private final Random random = new Random();

    public MinesweeperScreen(Screen parentScreen) {
        this.parentScreen = parentScreen;
        resetGame();
    }

    private void resetGame() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                grid[r][c] = new Cell();
            }
        }
        firstClickDone = false;
        isGameOver = false;
        isWon = false;
        startTime = 0L;
        elapsedSec = 0L;
    }

    private void placeMines(int safeR, int safeC) {
        int placed = 0;
        while (placed < MINES) {
            int r = random.nextInt(ROWS);
            int c = random.nextInt(COLS);
            if (grid[r][c].isMine) continue;
            if (Math.abs(r - safeR) <= 1 && Math.abs(c - safeC) <= 1) continue; // Keep surrounding safe

            grid[r][c].isMine = true;
            placed++;
        }

        // Calculate adjacent counts
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c].isMine) continue;
                int count = 0;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nr = r + dr, nc = c + dc;
                        if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && grid[nr][nc].isMine) {
                            count++;
                        }
                    }
                }
                grid[r][c].adjacentMines = count;
            }
        }
    }

    private void reveal(int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS) return;
        Cell cell = grid[r][c];
        if (cell.isRevealed || cell.isFlagged) return;

        cell.isRevealed = true;

        if (cell.isMine) {
            isGameOver = true;
            UISoundManager.playError();
            // Reveal all mines
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (grid[i][j].isMine) grid[i][j].isRevealed = true;
                }
            }
            return;
        }

        // Flood fill empty neighbors
        if (cell.adjacentMines == 0) {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr != 0 || dc != 0) {
                        reveal(r + dr, c + dc);
                    }
                }
            }
        }

        checkWinCondition();
    }

    private void checkWinCondition() {
        if (isGameOver) return;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!grid[r][c].isMine && !grid[r][c].isRevealed) {
                    return; // Still unrevealed non-mines
                }
            }
        }
        isWon = true;
        UISoundManager.playButtonClick();
        // Flag all mines automatically
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c].isMine) grid[r][c].isFlagged = true;
            }
        }
    }

    private int getRemainingMines() {
        int flags = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c].isFlagged) flags++;
            }
        }
        return MINES - flags;
    }

    @Override
    public void render(III custom) {
        if (firstClickDone && !isGameOver && !isWon) {
            elapsedSec = (System.currentTimeMillis() - startTime) / 1000L;
        }

        // Dark frosted backdrop
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(0.0F, 0.0F, 0.0F, 190.0F));

        IIiIIi_Class10 boldFont = null;
        IIiIIi_Class10 font = null;
        IIiIIi_Class10 subFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                boldFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(10.0F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
            }
        } catch (Throwable ignored) {}

        float cellSize = 20.0F;
        float boardW = COLS * cellSize;
        float boardH = ROWS * cellSize;
        float boardX = (this.width - boardW) / 2.0F;
        float boardY = (this.height - boardH) / 2.0F + 16.0F;

        // Container Window Frame
        float pad = 14.0F;
        float topHeaderH = 34.0F;
        float frameX = boardX - pad;
        float frameY = boardY - pad - topHeaderH;
        float frameW = boardW + pad * 2.0F;
        float frameH = boardH + pad * 2.0F + topHeaderH + 18.0F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(16.0F);

        custom.drawShadow(frameX, frameY, frameW, frameH, 28.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
        custom.drawBlurredRect(frameX, frameY, frameW, frameH, 20.0F, 4.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));
        custom.drawRoundedRect(frameX, frameY, frameW, frameH, rad, new ColorRGBA(16.0F, 18.0F, 26.0F, 130.0F));
        custom.drawRoundedBorder(frameX, frameY, frameW, frameH, 0.5F, rad, IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(90.0F));

        // Header: Mines Counter (Left), Smiley Button (Center), Timer (Right)
        float headerY = frameY + 10.0F;
        String mineStr = String.format("💣 %02d", Math.max(0, getRemainingMines()));
        if (boldFont != null) {
            custom.drawText(boldFont, mineStr, frameX + 16.0F, headerY + 4.0F, new ColorRGBA(255.0F, 69.0F, 58.0F));
        }

        // Smiley reset button in center
        float smileSz = 26.0F;
        float smileX = frameX + (frameW - smileSz) / 2.0F;
        float smileY = headerY;
        IIiii_Class8 sRad = IIiii_Class8.I_method_893b2757(smileSz / 2.0F);
        custom.drawRoundedRect(smileX, smileY, smileSz, smileSz, sRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));
        custom.drawRoundedBorder(smileX, smileY, smileSz, smileSz, 0.5F, sRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));

        String smileSym = isWon ? "😎" : (isGameOver ? "😵" : "🙂");
        if (font != null) {
            float sw = font.I_method_2c375926(smileSym);
            custom.drawText(font, smileSym, smileX + (smileSz - sw) / 2.0F, smileY + 6.0F, ColorRGBA.WHITE);
        }

        // Timer (Right)
        String timeStr = String.format("⏱ %03d", Math.min(999L, elapsedSec));
        if (boldFont != null) {
            float tw = boldFont.I_method_2c375926(timeStr);
            custom.drawText(boldFont, timeStr, frameX + frameW - tw - 36.0F, headerY + 4.0F, new ColorRGBA(52.0F, 199.0F, 89.0F));
        }

        // Close button (X)
        float closeX = frameX + frameW - 24.0F;
        custom.drawIcon("xmark", closeX + 2.0F, headerY + 2.0F, 12.0F, ColorRGBA.WHITE);

        // Board Backdrop
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(8.0F);
        custom.drawRoundedRect(boardX, boardY, boardW, boardH, bRad, new ColorRGBA(10.0F, 12.0F, 18.0F, 160.0F));
        custom.drawRoundedBorder(boardX, boardY, boardW, boardH, 0.5F, bRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

        // Draw Cells
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                Cell cell = grid[r][c];
                float cx = boardX + c * cellSize + 1.0F;
                float cy = boardY + r * cellSize + 1.0F;
                float cSz = cellSize - 2.0F;
                IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(3.5F);

                if (!cell.isRevealed) {
                    // Unrevealed tile
                    ColorRGBA tileCol = new ColorRGBA(36.0F, 42.0F, 56.0F, 255.0F);
                    custom.drawRoundedRect(cx, cy, cSz, cSz, cRad, tileCol);
                    custom.drawRoundedBorder(cx, cy, cSz, cSz, 0.8F, cRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));

                    if (cell.isFlagged && font != null) {
                        float fw = font.I_method_2c375926("🚩");
                        custom.drawText(font, "🚩", cx + (cSz - fw) / 2.0F, cy + 3.0F, new ColorRGBA(255.0F, 59.0F, 48.0F));
                    }
                } else {
                    // Revealed tile
                    if (cell.isMine) {
                        custom.drawRoundedRect(cx, cy, cSz, cSz, cRad, new ColorRGBA(235.0F, 55.0F, 50.0F, 255.0F));
                        if (font != null) {
                            float mw = font.I_method_2c375926("💣");
                            custom.drawText(font, "💣", cx + (cSz - mw) / 2.0F, cy + 3.0F, ColorRGBA.WHITE);
                        }
                    } else {
                        custom.drawRoundedRect(cx, cy, cSz, cSz, cRad, new ColorRGBA(18.0F, 22.0F, 30.0F, 255.0F));
                        if (cell.adjacentMines > 0 && font != null) {
                            String numStr = String.valueOf(cell.adjacentMines);
                            ColorRGBA numCol = switch (cell.adjacentMines) {
                                case 1 -> new ColorRGBA(59.0F, 130.0F, 246.0F); // Blue
                                case 2 -> new ColorRGBA(34.0F, 197.0F, 94.0F);  // Green
                                case 3 -> new ColorRGBA(239.0F, 68.0F, 68.0F);  // Red
                                case 4 -> new ColorRGBA(168.0F, 85.0F, 247.0F); // Purple
                                case 5 -> new ColorRGBA(249.0F, 115.0F, 22.0F); // Orange
                                default -> new ColorRGBA(6.0F, 182.0F, 212.0F); // Cyan
                            };
                            float nw = font.I_method_2c375926(numStr);
                            custom.drawText(font, numStr, cx + (cSz - nw) / 2.0F, cy + 4.0F, numCol);
                        }
                    }
                }
            }
        }

        // Win or Game Over Banners
        if (isWon && boldFont != null) {
            String winTxt = "🎉 ПОБЕДА! ВЫ РАЗМИНИРОВАЛИ ВСЁ!";
            float ww = boldFont.I_method_2c375926(winTxt);
            custom.drawText(boldFont, winTxt, frameX + (frameW - ww) / 2.0F, frameY + frameH - 18.0F, new ColorRGBA(52.0F, 199.0F, 89.0F));
        } else if (subFont != null) {
            String hint = "ЛКМ: Открыть   |   ПКМ: Флаг 🚩   |   Смайлик / R: Рестарт   |   ESC: Выход";
            float hw = subFont.I_method_2c375926(hint);
            custom.drawText(subFont, hint, frameX + (frameW - hw) / 2.0F, frameY + frameH - 18.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
        }
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        float cellSize = 20.0F;
        float boardW = COLS * cellSize;
        float boardH = ROWS * cellSize;
        float boardX = (this.width - boardW) / 2.0F;
        float boardY = (this.height - boardH) / 2.0F + 16.0F;

        float frameW = boardW + 28.0F;
        float frameX = boardX - 14.0F;
        float frameY = boardY - 14.0F - 34.0F;

        // Close button click
        float closeX = frameX + frameW - 24.0F;
        float closeY = frameY + 10.0F;
        if (mouseX >= closeX - 4.0F && mouseX <= closeX + 16.0F && mouseY >= closeY && mouseY <= closeY + 20.0F) {
            UISoundManager.playButtonClick();
            if (MinecraftClient.getInstance() != null) {
                MinecraftClient.getInstance().setScreen(this.parentScreen);
            }
            return;
        }

        // Smiley button click
        float smileSz = 26.0F;
        float smileX = frameX + (frameW - smileSz) / 2.0F;
        float smileY = frameY + 10.0F;
        if (mouseX >= smileX && mouseX <= smileX + smileSz && mouseY >= smileY && mouseY <= smileY + smileSz) {
            UISoundManager.playButtonClick();
            resetGame();
            return;
        }

        // Grid clicks
        if (mouseX >= boardX && mouseX < boardX + boardW && mouseY >= boardY && mouseY < boardY + boardH) {
            if (isGameOver || isWon) return;

            int c = (int)((mouseX - boardX) / cellSize);
            int r = (int)((mouseY - boardY) / cellSize);
            if (r < 0 || r >= ROWS || c < 0 || c >= COLS) return;

            if (button.I_method_6d899712() == 0) { // Left Click
                if (!firstClickDone) {
                    firstClickDone = true;
                    startTime = System.currentTimeMillis();
                    placeMines(r, c);
                }
                reveal(r, c);
                UISoundManager.playButtonClick();
            } else if (button.I_method_6d899712() == 1) { // Right Click (Flag)
                if (firstClickDone && !grid[r][c].isRevealed) {
                    grid[r][c].isFlagged = !grid[r][c].isFlagged;
                    UISoundManager.playButtonClick();
                    checkWinCondition();
                }
            }
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            if (MinecraftClient.getInstance() != null) {
                MinecraftClient.getInstance().setScreen(this.parentScreen);
            }
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_R) {
            resetGame();
            return true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
