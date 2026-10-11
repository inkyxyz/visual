package rockstar.client;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class SnakeScreen extends ii_Class4 {
    private final Screen parentScreen;

    private static final int COLS = 22;
    private static final int ROWS = 18;
    private static int highScore = 0;

    private enum Direction { UP, DOWN, LEFT, RIGHT }

    private final LinkedList<Point> snake = new LinkedList<>();
    private Point food = new Point(5, 5);
    private Direction dir = Direction.RIGHT;
    private Direction nextDir = Direction.RIGHT;

    private boolean isGameOver = false;
    private boolean isPaused = false;
    private int score = 0;
    private long lastStepTime = 0L;
    private long stepIntervalMs = 120L;

    private static class FoodSpark {
        float x, y, vx, vy, alpha, size;
        ColorRGBA col;
    }
    private final List<FoodSpark> sparks = new ArrayList<>();
    private final Random random = new Random();

    public SnakeScreen(Screen parentScreen) {
        this.parentScreen = parentScreen;
        resetGame();
    }

    private void resetGame() {
        this.snake.clear();
        int startX = COLS / 2;
        int startY = ROWS / 2;
        this.snake.add(new Point(startX, startY));
        this.snake.add(new Point(startX - 1, startY));
        this.snake.add(new Point(startX - 2, startY));

        this.dir = Direction.RIGHT;
        this.nextDir = Direction.RIGHT;
        this.score = 0;
        this.stepIntervalMs = 125L;
        this.isGameOver = false;
        this.isPaused = false;
        this.sparks.clear();
        spawnFood();
    }

    private void spawnFood() {
        while (true) {
            int fx = random.nextInt(COLS);
            int fy = random.nextInt(ROWS);
            boolean onSnake = false;
            for (Point p : snake) {
                if (p.x == fx && p.y == fy) {
                    onSnake = true;
                    break;
                }
            }
            if (!onSnake) {
                this.food = new Point(fx, fy);
                break;
            }
        }
    }

    private void updateGame() {
        if (isGameOver || isPaused) return;

        long now = System.currentTimeMillis();
        if (now - lastStepTime < stepIntervalMs) return;
        lastStepTime = now;

        dir = nextDir;
        Point head = snake.getFirst();
        int nx = head.x;
        int ny = head.y;

        switch (dir) {
            case UP -> ny--;
            case DOWN -> ny++;
            case LEFT -> nx--;
            case RIGHT -> nx++;
        }

        // Wall collision
        if (nx < 0 || nx >= COLS || ny < 0 || ny >= ROWS) {
            isGameOver = true;
            UISoundManager.playError();
            if (score > highScore) highScore = score;
            return;
        }

        // Self collision
        for (Point p : snake) {
            if (p.x == nx && p.y == ny) {
                isGameOver = true;
                UISoundManager.playError();
                if (score > highScore) highScore = score;
                return;
            }
        }

        Point newHead = new Point(nx, ny);
        snake.addFirst(newHead);

        // Check food collision
        if (nx == food.x && ny == food.y) {
            score += 10;
            if (score > highScore) highScore = score;
            UISoundManager.playButtonClick();
            stepIntervalMs = Math.max(65L, 125L - (score / 30) * 5L);

            // Spawn sparks
            for (int s = 0; s < 18; s++) {
                FoodSpark sp = new FoodSpark();
                sp.x = (float) food.x;
                sp.y = (float) food.y;
                double a = random.nextDouble() * Math.PI * 2.0;
                float spd = (float)(1.5 + random.nextDouble() * 3.5);
                sp.vx = (float) Math.cos(a) * spd;
                sp.vy = (float) Math.sin(a) * spd;
                sp.size = (float)(2.0 + random.nextDouble() * 2.5);
                sp.alpha = 1.0F;
                sp.col = (random.nextBoolean()) ? new ColorRGBA(255.0F, 59.0F, 48.0F) : new ColorRGBA(255.0F, 214.0F, 10.0F);
                sparks.add(sp);
            }
            spawnFood();
        } else {
            snake.removeLast();
        }
    }

    @Override
    public void render(III custom) {
        updateGame();

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

        float cellSize = 17.0F;
        float boardW = COLS * cellSize;
        float boardH = ROWS * cellSize;
        float boardX = (this.width - boardW) / 2.0F;
        float boardY = (this.height - boardH) / 2.0F + 14.0F;

        // Container Window Frame
        float pad = 14.0F;
        float frameX = boardX - pad;
        float frameY = boardY - pad - 26.0F;
        float frameW = boardW + pad * 2.0F;
        float frameH = boardH + pad * 2.0F + 26.0F;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(16.0F);

        custom.drawShadow(frameX, frameY, frameW, frameH, 28.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
        custom.drawBlurredRect(frameX, frameY, frameW, frameH, 20.0F, 4.0F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 14.0F));
        custom.drawRoundedRect(frameX, frameY, frameW, frameH, rad, new ColorRGBA(16.0F, 18.0F, 26.0F, 130.0F));
        custom.drawRoundedBorder(frameX, frameY, frameW, frameH, 0.5F, rad, IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(90.0F));

        // Top Bar: Title & Scores
        if (boldFont != null) {
            custom.drawText(boldFont, "🐍 ЗМЕЙКА (SNAKE)", frameX + 16.0F, frameY + 10.0F, ColorRGBA.WHITE);
        }
        if (font != null) {
            String scoreStr = "Счёт: " + score + "   |   Рекорд: " + highScore;
            float sw = font.I_method_2c375926(scoreStr);
            custom.drawText(font, scoreStr, frameX + frameW - sw - 36.0F, frameY + 12.0F, IiiiiIIIi_Class242.I_method_7df8e08e());
        }

        // Close button (X) top right
        float closeX = frameX + frameW - 24.0F;
        float closeY = frameY + 8.0F;
        custom.drawIcon("xmark", closeX + 2.0F, closeY + 2.0F, 12.0F, ColorRGBA.WHITE);

        // Board Background & Grid
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(8.0F);
        custom.drawRoundedRect(boardX, boardY, boardW, boardH, bRad, new ColorRGBA(10.0F, 12.0F, 18.0F, 160.0F));
        custom.drawRoundedBorder(boardX, boardY, boardW, boardH, 0.5F, bRad, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

        // Grid lines (subtle check pattern)
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if ((r + c) % 2 == 0) {
                    custom.drawRect(boardX + c * cellSize, boardY + r * cellSize, cellSize, cellSize, new ColorRGBA(255.0F, 255.0F, 255.0F, 6.0F));
                }
            }
        }

        // Draw Food (Pulsing glowing orb)
        float pulse = (float) Math.sin(System.currentTimeMillis() * 0.008) * 0.5F + 0.5F;
        float fx = boardX + food.x * cellSize + cellSize / 2.0F;
        float fy = boardY + food.y * cellSize + cellSize / 2.0F;
        float foodR = (cellSize * 0.38F) + pulse * 1.5F;
        ColorRGBA foodCol = new ColorRGBA(255.0F, 59.0F, 48.0F);
        custom.drawBlurredRect(fx - foodR * 1.4F, fy - foodR * 1.4F, foodR * 2.8F, foodR * 2.8F, 10.0F, IIiii_Class8.I_method_893b2757(foodR * 1.4F), foodCol.withAlpha(120.0F));
        custom.drawRoundedRect(fx - foodR, fy - foodR, foodR * 2.0F, foodR * 2.0F, IIiii_Class8.I_method_893b2757(foodR), foodCol);

        // Draw Sparks
        float dt = 0.016F;
        for (int i = sparks.size() - 1; i >= 0; i--) {
            FoodSpark sp = sparks.get(i);
            sp.x += sp.vx * dt;
            sp.y += sp.vy * dt;
            sp.alpha -= dt * 1.8F;
            if (sp.alpha <= 0.0F) {
                sparks.remove(i);
                continue;
            }
            float px = boardX + sp.x * cellSize + cellSize / 2.0F;
            float py = boardY + sp.y * cellSize + cellSize / 2.0F;
            custom.drawRoundedRect(px - sp.size / 2.0F, py - sp.size / 2.0F, sp.size, sp.size, IIiii_Class8.I_method_893b2757(sp.size / 2.0F), sp.col.withAlpha(255.0F * sp.alpha));
        }

        // Draw Snake Body
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        int count = snake.size();
        int idx = 0;
        for (Point p : snake) {
            float sx = boardX + p.x * cellSize + 1.0F;
            float sy = boardY + p.y * cellSize + 1.0F;
            float segSz = cellSize - 2.0F;

            float ratio = (float) idx / Math.max(1, count - 1);
            ColorRGBA segCol = (idx == 0)
                ? ColorRGBA.WHITE.mix(theme, 0.40F)
                : theme.mix(new ColorRGBA(80.0F, 40.0F, 220.0F), ratio);

            IIiii_Class8 segRad = IIiii_Class8.I_method_893b2757(idx == 0 ? 5.0F : 4.0F);
            custom.drawRoundedRect(sx, sy, segSz, segSz, segRad, segCol);

            // Head details: cute eyes
            if (idx == 0) {
                float eyeR = 2.0F;
                float ex1 = sx + 4.0F, ey1 = sy + 4.0F;
                float ex2 = sx + segSz - 4.0F, ey2 = sy + segSz - 4.0F;
                if (dir == Direction.UP || dir == Direction.DOWN) {
                    ey1 = ey2 = (dir == Direction.UP ? sy + 3.0F : sy + segSz - 3.0F);
                    ex1 = sx + 4.0F;
                    ex2 = sx + segSz - 4.0F;
                } else {
                    ex1 = ex2 = (dir == Direction.LEFT ? sx + 3.0F : sx + segSz - 3.0F);
                    ey1 = sy + 4.0F;
                    ey2 = sy + segSz - 4.0F;
                }
                custom.drawRoundedRect(ex1 - eyeR / 2.0F, ey1 - eyeR / 2.0F, eyeR, eyeR, IIiii_Class8.I_method_893b2757(eyeR / 2.0F), ColorRGBA.BLACK);
                custom.drawRoundedRect(ex2 - eyeR / 2.0F, ey2 - eyeR / 2.0F, eyeR, eyeR, IIiii_Class8.I_method_893b2757(eyeR / 2.0F), ColorRGBA.BLACK);
            }
            idx++;
        }

        // Overlays: Game Over or Paused
        if (isGameOver) {
            custom.drawRoundedRect(boardX, boardY, boardW, boardH, bRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 180.0F));
            if (boldFont != null) {
                String overTxt = "ИГРА ОКОНЧЕНА!";
                float ow = boldFont.I_method_2c375926(overTxt);
                custom.drawText(boldFont, overTxt, boardX + (boardW - ow) / 2.0F, boardY + boardH / 2.0F - 24.0F, new ColorRGBA(255.0F, 59.0F, 48.0F));
            }
            if (font != null) {
                String finalStr = "Ваш результат: " + score;
                float fw = font.I_method_2c375926(finalStr);
                custom.drawText(font, finalStr, boardX + (boardW - fw) / 2.0F, boardY + boardH / 2.0F - 4.0F, ColorRGBA.WHITE);

                String restStr = "Нажмите [ R ] чтобы перезапустить";
                float rw = font.I_method_2c375926(restStr);
                custom.drawText(font, restStr, boardX + (boardW - rw) / 2.0F, boardY + boardH / 2.0F + 16.0F, theme);
            }
        } else if (isPaused) {
            custom.drawRoundedRect(boardX, boardY, boardW, boardH, bRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 160.0F));
            if (boldFont != null) {
                String pauseTxt = "ПАУЗА";
                float pw = boldFont.I_method_2c375926(pauseTxt);
                custom.drawText(boldFont, pauseTxt, boardX + (boardW - pw) / 2.0F, boardY + boardH / 2.0F - 12.0F, ColorRGBA.WHITE);
            }
            if (subFont != null) {
                String pSub = "Нажмите Пробел для продолжения";
                float psw = subFont.I_method_2c375926(pSub);
                custom.drawText(subFont, pSub, boardX + (boardW - psw) / 2.0F, boardY + boardH / 2.0F + 10.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));
            }
        }

        // Bottom Controls Hint
        if (subFont != null) {
            String hint = "Управление: WASD / Стрелки   |   Пауза: Пробел   |   Рестарт: R   |   Выход: ESC";
            float hw = subFont.I_method_2c375926(hint);
            custom.drawText(subFont, hint, frameX + (frameW - hw) / 2.0F, frameY + frameH - 18.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 140.0F));
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

        if (keyCode == GLFW.GLFW_KEY_SPACE) {
            if (!isGameOver) {
                isPaused = !isPaused;
            }
            return true;
        }

        if (!isGameOver && !isPaused) {
            if ((keyCode == GLFW.GLFW_KEY_W || keyCode == GLFW.GLFW_KEY_UP) && dir != Direction.DOWN) {
                nextDir = Direction.UP;
            } else if ((keyCode == GLFW.GLFW_KEY_S || keyCode == GLFW.GLFW_KEY_DOWN) && dir != Direction.UP) {
                nextDir = Direction.DOWN;
            } else if ((keyCode == GLFW.GLFW_KEY_A || keyCode == GLFW.GLFW_KEY_LEFT) && dir != Direction.RIGHT) {
                nextDir = Direction.LEFT;
            } else if ((keyCode == GLFW.GLFW_KEY_D || keyCode == GLFW.GLFW_KEY_RIGHT) && dir != Direction.LEFT) {
                nextDir = Direction.RIGHT;
            }
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void onMouseClicked(double mouseX, double mouseY, IiIII_Class9 button) {
        float cellSize = 17.0F;
        float boardW = COLS * cellSize;
        float frameW = boardW + 28.0F;
        float frameX = (this.width - boardW) / 2.0F - 14.0F;
        float frameY = (this.height - (ROWS * cellSize)) / 2.0F + 14.0F - 40.0F;

        // Close button click
        float closeX = frameX + frameW - 24.0F;
        float closeY = frameY + 8.0F;
        if (mouseX >= closeX - 4.0F && mouseX <= closeX + 16.0F && mouseY >= closeY && mouseY <= closeY + 20.0F) {
            UISoundManager.playButtonClick();
            if (MinecraftClient.getInstance() != null) {
                MinecraftClient.getInstance().setScreen(this.parentScreen);
            }
        }
    }
}
