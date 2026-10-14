package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

/**
 * Floating Overlay Terminal Window for ClickGUI.
 * Supports scaling, dragging, resizing, real system shell commands,
 * and direct live SSH / Socket connections to remote VDS / servers.
 */
public class TerminalOverlayWindow {

    private static final TerminalOverlayWindow INSTANCE = new TerminalOverlayWindow();

    public static TerminalOverlayWindow getInstance() {
        return INSTANCE;
    }

    // Window dimensions and position
    private float x = 60.0F;
    private float y = 50.0F;
    private float width = 480.0F;
    private float height = 290.0F;
    private float scale = 1.0F;

    // Dragging & Resizing state
    private boolean dragging = false;
    private float dragStartX = 0.0F;
    private float dragStartY = 0.0F;

    private boolean resizing = false;
    private float resizeStartX = 0.0F;
    private float resizeStartY = 0.0F;
    private float initialW = 480.0F;
    private float initialH = 290.0F;

    // Terminal execution state
    private Process activeProcess = null;
    private BufferedWriter processWriter = null;
    private Socket activeSocket = null;
    private BufferedWriter socketWriter = null;

    private String remotePrompt = null;
    private boolean isRemoteConnected = false;

    // Text & History
    private final List<String> lines = new ArrayList<>();
    private final List<String> commandHistory = new ArrayList<>();
    private int historyIndex = -1;
    private String currentInput = "";
    private float scrollOffset = 0.0F;

    private TerminalOverlayWindow() {
        this.lines.add("Rockstar Terminal [Version 2.0 - Shell & VDS Bridge]");
        this.lines.add("Type commands, 'ssh user@host', or 'connect host port' to connect.");
        this.lines.add("");
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float scale) {
        this.scale = MathHelper.clamp(scale, 0.65F, 1.6F);
    }

    public boolean isOpen() {
        try {
            if (RockstarClient.getInstance() == null || RockstarClient.getInstance().getModuleManager() == null) {
                return false;
            }
            TerminalModule mod = RockstarClient.getInstance().getModuleManager().getModule(TerminalModule.class);
            return mod != null && mod.isEnabled();
        } catch (Throwable ignored) {
            return false;
        }
    }

    public void closeWindow() {
        try {
            TerminalModule mod = RockstarClient.getInstance().getModuleManager().getModule(TerminalModule.class);
            if (mod != null && mod.isEnabled()) {
                mod.setEnabled(false, false);
            }
        } catch (Throwable ignored) {}
    }

    /**
     * Renders the terminal overlay window within ClickGUI.
     */
    public void render(III custom, int mouseX, int mouseY) {
        if (!this.isOpen()) return;

        MinecraftClient mc = MinecraftClient.getInstance();
        int winW = mc.getWindow().getScaledWidth();
        int winH = mc.getWindow().getScaledHeight();

        // Keep window partially inside viewport
        this.x = MathHelper.clamp(this.x, 10.0F, Math.max(10.0F, winW - 80.0F));
        this.y = MathHelper.clamp(this.y, 10.0F, Math.max(10.0F, winH - 60.0F));

        custom.getMatrices().push();
        custom.getMatrices().translate(this.x, this.y, 0.0F);
        custom.getMatrices().scale(this.scale, this.scale, 1.0F);

        float w = this.width;
        float h = this.height;
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(12.0F);

        // 1. Terminal Body & Shadow
        custom.drawShadow(0.0F, 0.0F, w, h, 16.0F, rad, new ColorRGBA(0.0F, 0.0F, 0.0F, 110.0F));
        custom.drawBlurredRect(0.0F, 0.0F, w, h, 20.0F, 3.0F, rad, new ColorRGBA(12.0F, 14.0F, 22.0F, 20.0F));
        custom.drawRoundedRect(0.0F, 0.0F, w, h, rad, new ColorRGBA(12.0F, 15.0F, 24.0F, 235.0F));
        custom.drawRoundedBorder(0.0F, 0.0F, w, h, 0.8F, rad, new ColorRGBA(255.0F, 255.0F, 255.0F, 28.0F));

        // 2. Header Bar
        float headerH = 28.0F;
        custom.drawRoundedRect(0.0F, 0.0F, w, headerH, new IIiii_Class8(12.0F, 12.0F, 0.0F, 0.0F), new ColorRGBA(18.0F, 22.0F, 34.0F, 245.0F));
        custom.drawRect(0.0F, headerH - 1.0F, w, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 16.0F));

        // macOS Window Control Dots: Red, Yellow, Green
        custom.drawRoundedRect(10.0F, 9.0F, 10.0F, 10.0F, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(239.0F, 68.0F, 68.0F, 240.0F)); // Close
        custom.drawRoundedRect(25.0F, 9.0F, 10.0F, 10.0F, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(245.0F, 158.0F, 11.0F, 240.0F)); // Reset scale
        custom.drawRoundedRect(40.0F, 9.0F, 10.0F, 10.0F, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(16.0F, 185.0F, 129.0F, 240.0F)); // Scale max

        // Header Title
        String title = this.isRemoteConnected ? ("Terminal — " + this.remotePrompt) : "Terminal — VDS & System Shell";
        float titleW = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.2F).I_method_2c375926(title);
        custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.2F), title, (w - titleW) / 2.0F, 10.0F, new ColorRGBA(210.0F, 220.0F, 240.0F, 240.0F));

        // Scale controls in header: [-] [scale] [+]
        String scaleStr = String.format("%.1fx", this.scale);
        float scaleStrW = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F).I_method_2c375926(scaleStr);
        float ctrlX = w - 66.0F;
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), "-", ctrlX, 10.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), scaleStr, ctrlX + 10.0F, 10.0F, new ColorRGBA(140.0F, 180.0F, 255.0F, 220.0F));
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F), "+", ctrlX + 14.0F + scaleStrW, 10.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 180.0F));

        // 3. Terminal Content Viewport (Scissored)
        float contentX = 10.0F;
        float contentY = headerH + 6.0F;
        float contentW = w - 20.0F;
        float contentH = h - headerH - 30.0F;

        // Map viewport to screen coordinates considering scale
        int screenScissorX = (int) (this.x + contentX * this.scale);
        int screenScissorY = (int) (this.y + contentY * this.scale);
        int screenScissorW = (int) (contentW * this.scale);
        int screenScissorH = (int) (contentH * this.scale);

        custom.enableScissor(screenScissorX, screenScissorY, screenScissorX + screenScissorW, screenScissorY + screenScissorH);

        float lineHeight = 11.0F;
        float totalLinesH = (this.lines.size() + 1) * lineHeight;
        float maxScroll = Math.max(0.0F, totalLinesH - contentH);
        this.scrollOffset = MathHelper.clamp(this.scrollOffset, 0.0F, maxScroll);

        float curY = contentY + 2.0F - (maxScroll - this.scrollOffset);

        for (String line : this.lines) {
            if (curY + lineHeight >= contentY && curY <= contentY + contentH) {
                ColorRGBA col = line.startsWith("[ERR]")
                    ? new ColorRGBA(248.0F, 113.0F, 113.0F, 240.0F)
                    : (line.startsWith(">") ? new ColorRGBA(96.0F, 165.0F, 250.0F, 255.0F) : new ColorRGBA(226.0F, 232.0F, 240.0F, 220.0F));
                custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.8F), line, contentX, curY, col);
            }
            curY += lineHeight;
        }

        // Active Prompt & Input line inside scroll
        if (curY + lineHeight >= contentY && curY <= contentY + contentH + 12.0F) {
            String prompt = this.isRemoteConnected ? (this.remotePrompt + " $ ") : "[rockstar@shell ~]$ ";
            float promptW = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.8F).I_method_2c375926(prompt);
            custom.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.8F), prompt, contentX, curY, new ColorRGBA(52.0F, 211.0F, 153.0F, 255.0F));

            String cursor = (System.currentTimeMillis() % 1000L < 500L) ? "█" : "";
            custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.8F), this.currentInput + cursor, contentX + promptW, curY, ColorRGBA.WHITE);
        }

        custom.disableScissor();

        // 4. Bottom Resize Grip Icon (bottom-right)
        float gripSize = 10.0F;
        float gripX = w - gripSize - 4.0F;
        float gripY = h - gripSize - 4.0F;
        custom.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F), "◢", gripX, gripY, new ColorRGBA(255.0F, 255.0F, 255.0F, 70.0F));

        custom.getMatrices().pop();
    }

    public boolean mouseClicked(double mx, double my, int button) {
        if (!this.isOpen()) return false;

        float localMx = (float) ((mx - this.x) / this.scale);
        float localMy = (float) ((my - this.y) / this.scale);

        if (localMx < 0.0F || localMx > this.width || localMy < 0.0F || localMy > this.height) {
            return false;
        }

        // 1. macOS Header Buttons:
        if (localMy <= 28.0F) {
            // Red button: close window
            if (localMx >= 8.0F && localMx <= 22.0F && localMy >= 7.0F && localMy <= 21.0F) {
                this.closeWindow();
                return true;
            }
            // Yellow button: reset scale 1.0x
            if (localMx >= 23.0F && localMx <= 37.0F && localMy >= 7.0F && localMy <= 21.0F) {
                this.setScale(1.0F);
                return true;
            }
            // Green button: scale up
            if (localMx >= 38.0F && localMx <= 52.0F && localMy >= 7.0F && localMy <= 21.0F) {
                this.setScale(this.scale >= 1.2F ? 1.0F : 1.3F);
                return true;
            }

            // Scale +/- buttons in top-right
            float ctrlX = this.width - 66.0F;
            if (localMx >= ctrlX - 4.0F && localMx <= ctrlX + 8.0F) {
                this.setScale(this.scale - 0.1F);
                return true;
            }
            if (localMx >= ctrlX + 22.0F && localMx <= ctrlX + 38.0F) {
                this.setScale(this.scale + 0.1F);
                return true;
            }

            // Header drag
            this.dragging = true;
            this.dragStartX = (float) mx - this.x;
            this.dragStartY = (float) my - this.y;
            return true;
        }

        // 2. Bottom-Right Resize Grip
        if (localMx >= this.width - 16.0F && localMy >= this.height - 16.0F) {
            this.resizing = true;
            this.resizeStartX = (float) mx;
            this.resizeStartY = (float) my;
            this.initialW = this.width;
            this.initialH = this.height;
            return true;
        }

        return true; // Consume click inside window
    }

    public boolean mouseReleased(double mx, double my, int button) {
        this.dragging = false;
        this.resizing = false;
        return false;
    }

    public boolean mouseDragged(double mx, double my, int button, double deltaX, double deltaY) {
        if (!this.isOpen()) return false;

        if (this.dragging) {
            this.x = (float) mx - this.dragStartX;
            this.y = (float) my - this.dragStartY;
            return true;
        }

        if (this.resizing) {
            float dw = (float) (mx - this.resizeStartX) / this.scale;
            float dh = (float) (my - this.resizeStartY) / this.scale;
            this.width = MathHelper.clamp(this.initialW + dw, 320.0F, 800.0F);
            this.height = MathHelper.clamp(this.initialH + dh, 180.0F, 600.0F);
            return true;
        }

        return false;
    }

    public boolean mouseScrolled(double mx, double my, double horizontalAmount, double verticalAmount) {
        if (!this.isOpen()) return false;

        float localMx = (float) ((mx - this.x) / this.scale);
        float localMy = (float) ((my - this.y) / this.scale);

        if (localMx >= 0.0F && localMx <= this.width && localMy >= 0.0F && localMy <= this.height) {
            this.scrollOffset -= (float) (verticalAmount * 18.0);
            return true;
        }
        return false;
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (!this.isOpen()) return false;

        // Ctrl + C: Abort active process or socket connection
        if (keyCode == GLFW.GLFW_KEY_C && (modifiers & GLFW.GLFW_MOD_CONTROL) != 0) {
            this.abortActiveProcess();
            this.lines.add("^C");
            this.scrollOffset = 0.0F;
            return true;
        }

        // Enter: Execute command
        if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
            String cmd = this.currentInput.trim();
            this.currentInput = "";
            if (!cmd.isEmpty()) {
                this.commandHistory.add(cmd);
                this.historyIndex = this.commandHistory.size();
                this.executeCommand(cmd);
            }
            this.scrollOffset = 0.0F;
            return true;
        }

        // Backspace: Delete character
        if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
            if (!this.currentInput.isEmpty()) {
                this.currentInput = this.currentInput.substring(0, this.currentInput.length() - 1);
            }
            return true;
        }

        // History Navigation: Up / Down
        if (keyCode == GLFW.GLFW_KEY_UP) {
            if (!this.commandHistory.isEmpty() && this.historyIndex > 0) {
                this.historyIndex--;
                this.currentInput = this.commandHistory.get(this.historyIndex);
            }
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_DOWN) {
            if (!this.commandHistory.isEmpty() && this.historyIndex < this.commandHistory.size() - 1) {
                this.historyIndex++;
                this.currentInput = this.commandHistory.get(this.historyIndex);
            } else {
                this.historyIndex = this.commandHistory.size();
                this.currentInput = "";
            }
            return true;
        }

        return false;
    }

    public boolean charTyped(char chr, int modifiers) {
        if (!this.isOpen()) return false;
        if (Character.isDefined(chr) && chr >= 32) {
            this.currentInput += chr;
            return true;
        }
        return false;
    }

    /**
     * Executes real command: SSH, raw socket, ping, system shell commands.
     */
    private void executeCommand(String cmd) {
        String prompt = this.isRemoteConnected ? (this.remotePrompt + " $ ") : "> ";
        this.lines.add(prompt + cmd);

        // If active live SSH / shell process is running, send line to its stdin
        if (this.processWriter != null && this.activeProcess != null && this.activeProcess.isAlive()) {
            try {
                this.processWriter.write(cmd);
                this.processWriter.newLine();
                this.processWriter.flush();
                return;
            } catch (Throwable t) {
                this.lines.add("[ERR] Failed to send input: " + t.getMessage());
            }
        }

        // If active TCP socket is connected, send line to remote VDS socket
        if (this.socketWriter != null && this.activeSocket != null && !this.activeSocket.isClosed()) {
            try {
                this.socketWriter.write(cmd);
                this.socketWriter.newLine();
                this.socketWriter.flush();
                return;
            } catch (Throwable t) {
                this.lines.add("[ERR] Socket write error: " + t.getMessage());
            }
        }

        // Internal quick commands
        String[] parts = cmd.split("\\s+");
        String action = parts[0].toLowerCase();

        if (action.equals("cls") || action.equals("clear")) {
            this.lines.clear();
            return;
        }

        if (action.equals("exit")) {
            this.abortActiveProcess();
            this.lines.add("[INFO] Session closed.");
            return;
        }

        if (action.equals("scale") && parts.length > 1) {
            try {
                float sc = Float.parseFloat(parts[1]);
                this.setScale(sc);
                this.lines.add("[INFO] Scale set to " + this.scale);
                return;
            } catch (Throwable ignored) {}
        }

        // 1. Direct SSH Connection: ssh user@host [-p port]
        if (action.equals("ssh")) {
            this.startSshProcess(cmd);
            return;
        }

        // 2. Direct TCP Socket Connection to VDS/Server: connect <host> <port>
        if (action.equals("connect") && parts.length >= 3) {
            this.startSocketConnection(parts[1], parts[2]);
            return;
        }

        // 3. Fallback: Run real system command via local ProcessBuilder (cmd / powershell / sh)
        this.runLocalSystemCommand(cmd);
    }

    private void startSshProcess(String fullCmd) {
        Thread worker = new Thread(() -> {
            try {
                this.lines.add("[SSH] Spawning real SSH process...");
                ProcessBuilder pb = new ProcessBuilder();
                String os = System.getProperty("os.name", "").toLowerCase();
                if (os.contains("win")) {
                    pb.command("cmd.exe", "/c", fullCmd);
                } else {
                    pb.command("sh", "-c", fullCmd);
                }
                pb.redirectErrorStream(true);

                this.activeProcess = pb.start();
                this.processWriter = new BufferedWriter(new OutputStreamWriter(this.activeProcess.getOutputStream(), StandardCharsets.UTF_8));
                this.isRemoteConnected = true;
                this.remotePrompt = fullCmd.replace("ssh ", "").trim();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.activeProcess.getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        this.appendLine(line);
                    }
                }

                int exitCode = this.activeProcess.waitFor();
                this.appendLine("[SSH] Process exited with code " + exitCode);
            } catch (Throwable t) {
                this.appendLine("[ERR] SSH connection failed: " + t.getMessage());
            } finally {
                this.isRemoteConnected = false;
                this.remotePrompt = null;
                this.processWriter = null;
                this.activeProcess = null;
            }
        }, "Terminal-SSH-Worker");
        worker.setDaemon(true);
        worker.start();
    }

    private void startSocketConnection(String host, String portStr) {
        Thread worker = new Thread(() -> {
            try {
                int port = Integer.parseInt(portStr);
                this.appendLine("[NET] Connecting to " + host + ":" + port + "...");
                this.activeSocket = new Socket(host, port);
                this.socketWriter = new BufferedWriter(new OutputStreamWriter(this.activeSocket.getOutputStream(), StandardCharsets.UTF_8));
                this.isRemoteConnected = true;
                this.remotePrompt = host + ":" + port;
                this.appendLine("[NET] Connected successfully!");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.activeSocket.getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        this.appendLine(line);
                    }
                }
                this.appendLine("[NET] Connection closed by remote host.");
            } catch (Throwable t) {
                this.appendLine("[ERR] Connection failed: " + t.getMessage());
            } finally {
                this.isRemoteConnected = false;
                this.remotePrompt = null;
                this.socketWriter = null;
                if (this.activeSocket != null) {
                    try { this.activeSocket.close(); } catch (Throwable ignored) {}
                    this.activeSocket = null;
                }
            }
        }, "Terminal-Socket-Worker");
        worker.setDaemon(true);
        worker.start();
    }

    private void runLocalSystemCommand(String cmd) {
        Thread worker = new Thread(() -> {
            try {
                ProcessBuilder pb = new ProcessBuilder();
                String os = System.getProperty("os.name", "").toLowerCase();
                if (os.contains("win")) {
                    pb.command("cmd.exe", "/c", cmd);
                } else {
                    pb.command("sh", "-c", cmd);
                }
                pb.redirectErrorStream(true);

                this.activeProcess = pb.start();
                this.processWriter = new BufferedWriter(new OutputStreamWriter(this.activeProcess.getOutputStream(), StandardCharsets.UTF_8));

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.activeProcess.getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        this.appendLine(line);
                    }
                }

                int code = this.activeProcess.waitFor();
                if (code != 0) {
                    this.appendLine("[Exit: " + code + "]");
                }
            } catch (Throwable t) {
                this.appendLine("[ERR] Command failed: " + t.getMessage());
            } finally {
                this.processWriter = null;
                this.activeProcess = null;
            }
        }, "Terminal-Exec-Worker");
        worker.setDaemon(true);
        worker.start();
    }

    private synchronized void appendLine(String line) {
        if (line == null) return;
        // Strip ANSI escape codes if present
        String clean = line.replaceAll("\u001B\\[[;\\d]*m", "");
        this.lines.add(clean);
        if (this.lines.size() > 500) {
            this.lines.remove(0);
        }
    }

    private void abortActiveProcess() {
        if (this.activeProcess != null) {
            try {
                this.activeProcess.destroyForcibly();
            } catch (Throwable ignored) {}
            this.activeProcess = null;
        }
        if (this.activeSocket != null) {
            try {
                this.activeSocket.close();
            } catch (Throwable ignored) {}
            this.activeSocket = null;
        }
        this.isRemoteConnected = false;
        this.remotePrompt = null;
        this.processWriter = null;
        this.socketWriter = null;
    }
}
