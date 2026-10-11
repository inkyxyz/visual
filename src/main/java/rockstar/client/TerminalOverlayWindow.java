package rockstar.client;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Interactive Resizable & Scalable Floating Terminal / VPS Shell Window.
 * Renders as a 2nd window on top of ClickGUI.
 * Supports real SSH / VPS connections, real command execution, socket streaming, and zero clutter.
 */
public class TerminalOverlayWindow {

    public static class Line {
        public final String time;
        public final String text;
        public final ColorRGBA color;

        public Line(String text, ColorRGBA color) {
            this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            this.text = text;
            this.color = color;
        }
    }

    private static final List<Line> LINES = new ArrayList<>();
    private static final List<String> CMD_HISTORY = new ArrayList<>();
    private static int historyIdx = -1;

    // Window layout state
    private static float winX = -1.0F;
    private static float winY = -1.0F;
    private static float winW = 480.0F;
    private static float winH = 280.0F;
    private static float scale = 1.0F;

    // Drag & Resize state
    private static boolean isDragging = false;
    private static boolean isResizing = false;
    private static float dragOffX = 0.0F;
    private static float dragOffY = 0.0F;
    private static float resizeStartX = 0.0F;
    private static float resizeStartY = 0.0F;
    private static float resizeStartW = 0.0F;
    private static float resizeStartH = 0.0F;

    // Input & Scroll state
    private static String currentInput = "";
    private static float scrollY = 0.0F;
    private static boolean isFocused = true;

    // Active Remote Connection (SSH Process or Socket)
    private static Process activeProcess = null;
    private static OutputStream processOut = null;
    private static BufferedReader processIn = null;
    private static Thread stdoutThread = null;
    private static Socket activeSocket = null;
    private static String sessionTitle = "Local Shell";
    private static boolean isConnectedVds = false;

    static {
        ColorRGBA cAccent = new ColorRGBA(139.0F, 92.0F, 246.0F, 255.0F);
        ColorRGBA cDim = new ColorRGBA(160.0F, 175.0F, 205.0F, 220.0F);
        ColorRGBA cGreen = new ColorRGBA(52.0F, 211.0F, 153.0F, 255.0F);
        LINES.add(new Line("✦ Agravity VPS & Shell Terminal v2.5", cAccent));
        LINES.add(new Line("Real SSH client ready. Type 'help' for commands.", cDim));
        LINES.add(new Line("Example VPS connect: ssh root@194.87.12.34 -p 22", cGreen));
    }

    public static void render(III custom, int mx, int my) {
        MinecraftClient mc = MinecraftClient.getInstance();
        int screenW = mc.getWindow().getScaledWidth();
        int screenH = mc.getWindow().getScaledHeight();

        // Default initial placement (top right of screen)
        if (winX < 0 || winY < 0) {
            winX = Math.max(20.0F, screenW - (winW * scale) - 24.0F);
            winY = Math.max(20.0F, (screenH - (winH * scale)) / 2.0F - 30.0F);
        }

        // Clamp inside screen bounds
        float actualW = winW * scale;
        float actualH = winH * scale;
        winX = Math.max(4.0F, Math.min(screenW - actualW - 4.0F, winX));
        winY = Math.max(4.0F, Math.min(screenH - actualH - 4.0F, winY));

        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(10.0F * scale);

        // 1. Window Dropshadow & Glass Frame
        custom.drawShadow(winX, winY, actualW, actualH, 18.0F * scale, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 120.0F));
        custom.drawBlurredRect(winX, winY, actualW, actualH, 16.0F * scale, 3.0F, rad, new ColorRGBA(12.0F, 16.0F, 24.0F, 180.0F));
        custom.drawRoundedRect(winX, winY, actualW, actualH, rad, new ColorRGBA(12.0F, 16.0F, 24.0F, 235.0F));
        custom.drawRoundedBorder(winX, winY, actualW, actualH, 0.8F, rad, isFocused ? theme.withAlpha(150.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 25.0F));

        // 2. Title Header Bar (draggable)
        float headerH = 26.0F * scale;
        IIiii_Class8 headerRad = new IIiii_Class8(10.0F * scale, 10.0F * scale, 0.0F, 0.0F);
        custom.drawRoundedRect(winX, winY, actualW, headerH, headerRad, new ColorRGBA(18.0F, 24.0F, 36.0F, 240.0F));
        custom.drawRect(winX, winY + headerH - 1.0F, actualW, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

        // Close button [✕]
        float closeSz = 14.0F * scale;
        float closeX = winX + 8.0F * scale;
        float closeY = winY + (headerH - closeSz) / 2.0F;
        boolean closeHov = (mx >= closeX && mx <= closeX + closeSz && my >= closeY && my <= closeY + closeSz);
        IIiii_Class8 cBtnRad = IIiii_Class8.I_method_893b2757(closeSz / 2.0F);
        custom.drawRoundedRect(closeX, closeY, closeSz, closeSz, cBtnRad, closeHov ? new ColorRGBA(239.0F, 68.0F, 68.0F, 220.0F) : new ColorRGBA(239.0F, 68.0F, 68.0F, 140.0F));
        custom.drawIcon("xmark", closeX + (closeSz - 6.0F * scale) / 2.0F, closeY + (closeSz - 6.0F * scale) / 2.0F, 6.0F * scale, ColorRGBA.WHITE);

        // Scale down [–] and Scale up [+] buttons
        float scaleBtnSz = 14.0F * scale;
        float scaleDownX = closeX + closeSz + 6.0F * scale;
        float scaleUpX = scaleDownX + scaleBtnSz + 4.0F * scale;
        boolean sDownHov = (mx >= scaleDownX && mx <= scaleDownX + scaleBtnSz && my >= closeY && my <= closeY + scaleBtnSz);
        boolean sUpHov = (mx >= scaleUpX && mx <= scaleUpX + scaleBtnSz && my >= closeY && my <= closeY + scaleBtnSz);
        custom.drawRoundedRect(scaleDownX, closeY, scaleBtnSz, scaleBtnSz, cBtnRad, sDownHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));
        custom.drawRoundedRect(scaleUpX, closeY, scaleBtnSz, scaleBtnSz, cBtnRad, sUpHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F));

        IIiIIi_Class10 tinyFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5F * scale);
        IIiIIi_Class10 font = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.2F * scale);
        IIiIIi_Class10 codeFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.8F * scale);

        if (tinyFont != null) {
            float mTw = tinyFont.I_method_2c375926("-");
            custom.drawText(tinyFont, "-", scaleDownX + (scaleBtnSz - mTw) / 2.0F, closeY + (scaleBtnSz - 6.5F * scale) / 2.0F, ColorRGBA.WHITE);
            float pTw = tinyFont.I_method_2c375926("+");
            custom.drawText(tinyFont, "+", scaleUpX + (scaleBtnSz - pTw) / 2.0F, closeY + (scaleBtnSz - 6.5F * scale) / 2.0F, ColorRGBA.WHITE);
        }

        // Title & Session indicator
        if (font != null) {
            String titleText = "✦ " + sessionTitle + " (" + (int)(scale * 100) + "%)";
            custom.drawText(font, titleText, scaleUpX + scaleBtnSz + 8.0F * scale, winY + (headerH - 7.2F * scale) / 2.0F, ColorRGBA.WHITE);
        }

        // Right side of Header: Connection Status Badge & Clear button
        float btnClearW = 44.0F * scale;
        float btnClearH = 16.0F * scale;
        float btnClearX = winX + actualW - btnClearW - 8.0F * scale;
        float btnClearY = winY + (headerH - btnClearH) / 2.0F;
        boolean clrHov = (mx >= btnClearX && mx <= btnClearX + btnClearW && my >= btnClearY && my <= btnClearY + btnClearH);
        IIiii_Class8 bRad = IIiii_Class8.I_method_893b2757(4.0F * scale);
        custom.drawRoundedRect(btnClearX, btnClearY, btnClearW, btnClearH, bRad, clrHov ? new ColorRGBA(255.0F, 255.0F, 255.0F, 36.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F));
        if (tinyFont != null) {
            float tw = tinyFont.I_method_2c375926("Очистить");
            custom.drawText(tinyFont, "Очистить", btnClearX + (btnClearW - tw) / 2.0F, btnClearY + (btnClearH - 6.5F * scale) / 2.0F, ColorRGBA.WHITE);
        }

        // Status pill badge
        float badgeW = isConnectedVds ? (88.0F * scale) : (68.0F * scale);
        float badgeX = btnClearX - badgeW - 6.0F * scale;
        ColorRGBA badgeColor = isConnectedVds ? new ColorRGBA(34.0F, 197.0F, 94.0F, 220.0F) : new ColorRGBA(96.0F, 165.0F, 250.0F, 220.0F);
        custom.drawRoundedRect(badgeX, btnClearY, badgeW, btnClearH, bRad, badgeColor.withAlpha(35.0F));
        custom.drawRoundedBorder(badgeX, btnClearY, badgeW, btnClearH, 0.5F, bRad, badgeColor.withAlpha(120.0F));
        // Status dot
        custom.drawRoundedRect(badgeX + 6.0F * scale, btnClearY + (btnClearH - 4.0F * scale) / 2.0F, 4.0F * scale, 4.0F * scale, IIiii_Class8.I_method_893b2757(2.0F * scale), badgeColor);
        if (tinyFont != null) {
            String bText = isConnectedVds ? "VDS Онлайн" : "Локальный";
            custom.drawText(tinyFont, bText, badgeX + 13.0F * scale, btnClearY + (btnClearH - 6.5F * scale) / 2.0F, ColorRGBA.WHITE);
        }

        // 3. Log Output Area (Scissor clipped)
        float bodyX = winX + 10.0F * scale;
        float bodyY = winY + headerH + 6.0F * scale;
        float bodyW = actualW - 20.0F * scale;
        float inputAreaH = 24.0F * scale;
        float bodyH = actualH - headerH - inputAreaH - 12.0F * scale;

        custom.enableScissor((int) bodyX, (int) bodyY, (int) (bodyX + bodyW), (int) (bodyY + bodyH));

        float lineH = 11.5F * scale;
        float totalLogH = LINES.size() * lineH;
        float maxScroll = Math.max(0.0F, totalLogH - bodyH);
        scrollY = Math.max(0.0F, Math.min(maxScroll, scrollY));

        float curY = bodyY + bodyH - totalLogH + scrollY;

        for (int i = 0; i < LINES.size(); i++) {
            Line line = LINES.get(i);
            if (curY + lineH >= bodyY && curY <= bodyY + bodyH + lineH) {
                if (codeFont != null) {
                    custom.drawText(codeFont, line.text, bodyX + 2.0F, curY, line.color);
                }
            }
            curY += lineH;
        }

        custom.disableScissor();

        // 4. Interactive Input Line Area
        float inY = winY + actualH - inputAreaH - 6.0F * scale;
        custom.drawRoundedRect(bodyX, inY, bodyW, inputAreaH, IIiii_Class8.I_method_893b2757(6.0F * scale), new ColorRGBA(18.0F, 24.0F, 36.0F, 200.0F));
        custom.drawRoundedBorder(bodyX, inY, bodyW, inputAreaH, 0.5F, IIiii_Class8.I_method_893b2757(6.0F * scale), isFocused ? theme.withAlpha(160.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

        String prompt = isConnectedVds ? "[root@vds:~]# " : "[user@rockstar:~$] ";
        float promptW = codeFont != null ? codeFont.I_method_2c375926(prompt) : (60.0F * scale);

        if (codeFont != null) {
            ColorRGBA promptCol = isConnectedVds ? new ColorRGBA(52.0F, 211.0F, 153.0F, 240.0F) : new ColorRGBA(168.0F, 85.0F, 247.0F, 240.0F);
            custom.drawText(codeFont, prompt, bodyX + 8.0F * scale, inY + (inputAreaH - 6.8F * scale) / 2.0F, promptCol);

            String cursor = isFocused && (System.currentTimeMillis() % 1000L < 500L) ? "▎" : "";
            String dispInput = currentInput + cursor;
            custom.drawText(codeFont, dispInput, bodyX + 8.0F * scale + promptW, inY + (inputAreaH - 6.8F * scale) / 2.0F, ColorRGBA.WHITE);
        }

        // 5. Corner Resize Grip Indicator (bottom-right)
        float gripSz = 12.0F * scale;
        float gripX = winX + actualW - gripSz - 2.0F;
        float gripY = winY + actualH - gripSz - 2.0F;
        boolean gripHov = (mx >= gripX && mx <= gripX + gripSz && my >= gripY && my <= gripY + gripSz);
        ColorRGBA gripCol = gripHov || isResizing ? theme : new ColorRGBA(255.0F, 255.0F, 255.0F, 50.0F);
        custom.drawRoundedRect(gripX + 6.0F * scale, gripY + 8.0F * scale, 4.0F * scale, 1.5F * scale, IIiii_Class8.I_method_893b2757(0.5F), gripCol);
        custom.drawRoundedRect(gripX + 3.0F * scale, gripY + 5.0F * scale, 7.0F * scale, 1.5F * scale, IIiii_Class8.I_method_893b2757(0.5F), gripCol);
        custom.drawRoundedRect(gripX, gripY + 2.0F * scale, 10.0F * scale, 1.5F * scale, IIiii_Class8.I_method_893b2757(0.5F), gripCol);
    }

    public static boolean mouseClicked(double mx, double my, int button) {
        float actualW = winW * scale;
        float actualH = winH * scale;

        // Check inside window bounds
        if (mx < winX || mx > winX + actualW || my < winY || my > winY + actualH) {
            isFocused = false;
            return false;
        }

        isFocused = true;
        float headerH = 26.0F * scale;

        // 1. Close button
        float closeSz = 14.0F * scale;
        float closeX = winX + 8.0F * scale;
        float closeY = winY + (headerH - closeSz) / 2.0F;
        if (mx >= closeX && mx <= closeX + closeSz && my >= closeY && my <= closeY + closeSz) {
            UISoundManager.playButtonClick();
            InterfaceModule.setTerminalMode(false);
            return true;
        }

        // 2. Scale down [–] button
        float scaleBtnSz = 14.0F * scale;
        float scaleDownX = closeX + closeSz + 6.0F * scale;
        if (mx >= scaleDownX && mx <= scaleDownX + scaleBtnSz && my >= closeY && my <= closeY + scaleBtnSz) {
            UISoundManager.playButtonClick();
            scale = Math.max(0.7F, Math.round((scale - 0.1F) * 10.0F) / 10.0F);
            return true;
        }

        // 3. Scale up [+] button
        float scaleUpX = scaleDownX + scaleBtnSz + 4.0F * scale;
        if (mx >= scaleUpX && mx <= scaleUpX + scaleBtnSz && my >= closeY && my <= closeY + scaleBtnSz) {
            UISoundManager.playButtonClick();
            scale = Math.min(1.5F, Math.round((scale + 0.1F) * 10.0F) / 10.0F);
            return true;
        }

        // 4. Clear button
        float btnClearW = 44.0F * scale;
        float btnClearH = 16.0F * scale;
        float btnClearX = winX + actualW - btnClearW - 8.0F * scale;
        float btnClearY = winY + (headerH - btnClearH) / 2.0F;
        if (mx >= btnClearX && mx <= btnClearX + btnClearW && my >= btnClearY && my <= btnClearY + btnClearH) {
            UISoundManager.playButtonClick();
            LINES.clear();
            LINES.add(new Line("✦ Buffer cleared.", new ColorRGBA(160.0F, 175.0F, 205.0F, 220.0F)));
            return true;
        }

        // 5. Corner Resize Grip
        float gripSz = 14.0F * scale;
        float gripX = winX + actualW - gripSz;
        float gripY = winY + actualH - gripSz;
        if (mx >= gripX && mx <= winX + actualW && my >= gripY && my <= winY + actualH) {
            isResizing = true;
            resizeStartX = (float) mx;
            resizeStartY = (float) my;
            resizeStartW = winW;
            resizeStartH = winH;
            return true;
        }

        // 6. Header Bar Drag
        if (my >= winY && my <= winY + headerH) {
            isDragging = true;
            dragOffX = (float) mx - winX;
            dragOffY = (float) my - winY;
            return true;
        }

        return true; // Click consumed by window
    }

    public static boolean mouseReleased(double mx, double my, int button) {
        if (isDragging || isResizing) {
            isDragging = false;
            isResizing = false;
            return true;
        }
        return false;
    }

    public static boolean mouseDragged(double mx, double my, int button, double dx, double dy) {
        if (isDragging) {
            winX = (float) mx - dragOffX;
            winY = (float) my - dragOffY;
            return true;
        }
        if (isResizing) {
            float dX = ((float) mx - resizeStartX) / scale;
            float dY = ((float) my - resizeStartY) / scale;
            winW = Math.max(340.0F, Math.min(800.0F, resizeStartW + dX));
            winH = Math.max(200.0F, Math.min(600.0F, resizeStartH + dY));
            return true;
        }
        return false;
    }

    public static boolean mouseScrolled(double mx, double my, double amount) {
        float actualW = winW * scale;
        float actualH = winH * scale;
        if (mx >= winX && mx <= winX + actualW && my >= winY && my <= winY + actualH) {
            scrollY += (float) (amount * 24.0F);
            return true;
        }
        return false;
    }

    public static boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (!isFocused) return false;

        boolean isCtrlDown = (modifiers & GLFW.GLFW_MOD_CONTROL) != 0;

        if (isCtrlDown) {
            if (keyCode == GLFW.GLFW_KEY_V) {
                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.keyboard != null) {
                    String clip = mc.keyboard.getClipboard();
                    if (clip != null && !clip.isEmpty()) {
                        currentInput += clip.replace("\r", "").replace("\n", " ");
                        return true;
                    }
                }
            } else if (keyCode == GLFW.GLFW_KEY_C) {
                // If in active process, send interrupt (Ctrl+C)
                if (processOut != null) {
                    try {
                        processOut.write(3); // ASCII ETX / Ctrl+C
                        processOut.flush();
                        LINES.add(new Line("^C", new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F)));
                    } catch (Throwable ignored) {}
                } else if (!currentInput.isEmpty()) {
                    MinecraftClient mc = MinecraftClient.getInstance();
                    if (mc.keyboard != null) {
                        mc.keyboard.setClipboard(currentInput);
                    }
                    currentInput = "";
                }
                return true;
            }
        }

        if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
            if (!currentInput.isEmpty()) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
            }
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_UP) {
            if (!CMD_HISTORY.isEmpty()) {
                if (historyIdx == -1) historyIdx = CMD_HISTORY.size() - 1;
                else if (historyIdx > 0) historyIdx--;
                currentInput = CMD_HISTORY.get(historyIdx);
            }
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_DOWN) {
            if (!CMD_HISTORY.isEmpty() && historyIdx != -1) {
                if (historyIdx < CMD_HISTORY.size() - 1) {
                    historyIdx++;
                    currentInput = CMD_HISTORY.get(historyIdx);
                } else {
                    historyIdx = -1;
                    currentInput = "";
                }
            }
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
            String cmd = currentInput.trim();
            if (!cmd.isEmpty()) {
                CMD_HISTORY.add(cmd);
                historyIdx = -1;
                executeCommand(cmd);
            } else if (processOut != null) {
                // Send empty enter to interactive shell
                try {
                    processOut.write("\n".getBytes(StandardCharsets.UTF_8));
                    processOut.flush();
                } catch (Throwable ignored) {}
            }
            currentInput = "";
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            isFocused = false;
            return true;
        }

        return false;
    }

    public static boolean charTyped(char chr, int modifiers) {
        if (!isFocused) return false;
        if (chr >= 32 && chr != 127) {
            currentInput += chr;
            return true;
        }
        return false;
    }

    private static void executeCommand(String cmd) {
        ColorRGBA cPrompt = isConnectedVds ? new ColorRGBA(52.0F, 211.0F, 153.0F, 255.0F) : new ColorRGBA(168.0F, 85.0F, 247.0F, 255.0F);
        ColorRGBA cDim = new ColorRGBA(160.0F, 175.0F, 205.0F, 220.0F);
        ColorRGBA cWarn = new ColorRGBA(251.0F, 191.0F, 36.0F, 255.0F);
        ColorRGBA cErr = new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F);

        LINES.add(new Line((isConnectedVds ? "root@vds:~# " : "user@rockstar:~$ ") + cmd, cPrompt));

        // If interactive process is active, write to process
        if (processOut != null) {
            try {
                processOut.write((cmd + "\n").getBytes(StandardCharsets.UTF_8));
                processOut.flush();
            } catch (Throwable t) {
                LINES.add(new Line("Error writing to process: " + t.getMessage(), cErr));
                disconnectActiveProcess();
            }
            return;
        }

        String[] parts = cmd.split("\\s+");
        String main = parts[0].toLowerCase();

        switch (main) {
            case "help" -> {
                LINES.add(new Line("✦ Доступные команды Shell:", cDim));
                LINES.add(new Line("  ssh <user>@<host> [-p <port>]  - Реальное подключение к VDS/VPS по SSH", cDim));
                LINES.add(new Line("  connect <host> <port>          - Прямое TCP подключение к серверу/сокетам", cDim));
                LINES.add(new Line("  ping <host>                    - Проверка пинга до хоста", cDim));
                LINES.add(new Line("  curl <url>                     - Быстрый сетевой запрос к URL", cDim));
                LINES.add(new Line("  scale <0.7 - 1.5>              - Изменить масштаб окна (напр: scale 1.2)", cDim));
                LINES.add(new Line("  clear                          - Очистить вывод терминала", cDim));
                LINES.add(new Line("  exit / disconnect              - Закрыть сессию или окно", cDim));
                LINES.add(new Line("  <любая системная команда>      - Выполнение реальных команд ОС (dir, ipconfig)", cDim));
            }
            case "clear", "cls" -> {
                LINES.clear();
            }
            case "scale" -> {
                if (parts.length > 1) {
                    try {
                        float s = Float.parseFloat(parts[1]);
                        scale = Math.max(0.7F, Math.min(1.5F, s));
                        LINES.add(new Line("Scale set to " + (int)(scale * 100) + "%", cDim));
                    } catch (Throwable t) {
                        LINES.add(new Line("Usage: scale <0.7 - 1.5>", cErr));
                    }
                } else {
                    LINES.add(new Line("Current scale: " + (int)(scale * 100) + "%", cDim));
                }
            }
            case "exit", "disconnect" -> {
                if (isConnectedVds || activeProcess != null) {
                    disconnectActiveProcess();
                    LINES.add(new Line("Disconnected from remote host.", cWarn));
                } else {
                    InterfaceModule.setTerminalMode(false);
                }
            }
            case "connect" -> {
                if (parts.length < 3) {
                    LINES.add(new Line("Usage: connect <host> <port>", cErr));
                    return;
                }
                String host = parts[1];
                int port;
                try {
                    port = Integer.parseInt(parts[2]);
                } catch (Throwable e) {
                    LINES.add(new Line("Invalid port: " + parts[2], cErr));
                    return;
                }
                connectSocketAsync(host, port);
            }
            case "ssh" -> {
                if (parts.length < 2) {
                    LINES.add(new Line("Usage: ssh <user>@<host> [-p <port>]", cErr));
                    return;
                }
                startSshProcessAsync(cmd);
            }
            default -> {
                // Execute real local system command via ProcessBuilder!
                executeLocalSystemCommand(cmd);
            }
        }
    }

    private static void startSshProcessAsync(String fullCmd) {
        ColorRGBA cInfo = new ColorRGBA(96.0F, 165.0F, 250.0F, 255.0F);
        ColorRGBA cErr = new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F);

        LINES.add(new Line("Initiating SSH connection: " + fullCmd + "...", cInfo));

        new Thread(() -> {
            try {
                // On Windows/Linux/Mac, launch ssh executable with unbuffered interactive flags
                List<String> commandList = new ArrayList<>();
                commandList.add("ssh");
                commandList.add("-o");
                commandList.add("StrictHostKeyChecking=accept-new");

                String[] tokens = fullCmd.split("\\s+");
                for (int i = 1; i < tokens.length; i++) {
                    commandList.add(tokens[i]);
                }

                ProcessBuilder pb = new ProcessBuilder(commandList);
                pb.redirectErrorStream(true);
                Process proc = pb.start();

                activeProcess = proc;
                processOut = proc.getOutputStream();
                processIn = new BufferedReader(new InputStreamReader(proc.getInputStream(), StandardCharsets.UTF_8));
                isConnectedVds = true;
                sessionTitle = "SSH: " + tokens[1];

                LINES.add(new Line("Connected. Interactive terminal attached.", new ColorRGBA(52.0F, 211.0F, 153.0F, 255.0F)));

                String l;
                while ((l = processIn.readLine()) != null) {
                    final String outLine = l;
                    LINES.add(new Line(outLine, ColorRGBA.WHITE));
                    if (LINES.size() > 500) LINES.remove(0);
                }

                LINES.add(new Line("Connection closed by remote host.", new ColorRGBA(251.0F, 191.0F, 36.0F, 255.0F)));
                disconnectActiveProcess();
            } catch (Throwable t) {
                LINES.add(new Line("SSH Failed: " + t.getMessage(), cErr));
                disconnectActiveProcess();
            }
        }, "Terminal-SSH-Worker").start();
    }

    private static void connectSocketAsync(String host, int port) {
        ColorRGBA cInfo = new ColorRGBA(96.0F, 165.0F, 250.0F, 255.0F);
        ColorRGBA cErr = new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F);

        LINES.add(new Line("Opening TCP connection to " + host + ":" + port + "...", cInfo));

        new Thread(() -> {
            try {
                Socket sock = new Socket(host, port);
                activeSocket = sock;
                processOut = sock.getOutputStream();
                processIn = new BufferedReader(new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8));
                isConnectedVds = true;
                sessionTitle = "TCP: " + host + ":" + port;

                LINES.add(new Line("TCP Socket connected.", new ColorRGBA(52.0F, 211.0F, 153.0F, 255.0F)));

                String l;
                while (!sock.isClosed() && (l = processIn.readLine()) != null) {
                    final String outLine = l;
                    LINES.add(new Line(outLine, ColorRGBA.WHITE));
                    if (LINES.size() > 500) LINES.remove(0);
                }

                LINES.add(new Line("Socket stream closed.", new ColorRGBA(251.0F, 191.0F, 36.0F, 255.0F)));
                disconnectActiveProcess();
            } catch (Throwable t) {
                LINES.add(new Line("Connect failed: " + t.getMessage(), cErr));
                disconnectActiveProcess();
            }
        }, "Terminal-Socket-Worker").start();
    }

    private static void executeLocalSystemCommand(String cmd) {
        new Thread(() -> {
            try {
                boolean isWindows = System.getProperty("os.name", "").toLowerCase().contains("win");
                ProcessBuilder pb = isWindows
                    ? new ProcessBuilder("cmd.exe", "/c", cmd)
                    : new ProcessBuilder("sh", "-c", cmd);
                pb.redirectErrorStream(true);
                Process proc = pb.start();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream(), isWindows ? "CP866" : "UTF-8"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        LINES.add(new Line(line, ColorRGBA.WHITE));
                        if (LINES.size() > 500) LINES.remove(0);
                    }
                }
                proc.waitFor();
            } catch (Throwable t) {
                LINES.add(new Line("Execution error: " + t.getMessage(), new ColorRGBA(239.0F, 68.0F, 68.0F, 255.0F)));
            }
        }, "Terminal-Local-Worker").start();
    }

    public static void disconnectActiveProcess() {
        isConnectedVds = false;
        sessionTitle = "Local Shell";
        if (activeProcess != null) {
            try {
                activeProcess.destroy();
            } catch (Throwable ignored) {}
            activeProcess = null;
        }
        if (activeSocket != null) {
            try {
                activeSocket.close();
            } catch (Throwable ignored) {}
            activeSocket = null;
        }
        processOut = null;
        processIn = null;
    }
}
