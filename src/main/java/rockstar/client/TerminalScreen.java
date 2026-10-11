package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.MultiSelectSetting;
import rockstar.client.ModeSetting;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.Setting;
import rockstar.client.ModuleEntry;
import rockstar.client.UISoundManager;

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
 * Interactive Hacker / Developer Terminal Screen for Rockstar Client.
 * Supports command parsing, module & parameter auto-suggestions with toggle switches (тумблеры / аксы),
 * and built-in SSH remote shell connections.
 */
public class TerminalScreen extends Screen {

    public static class LogLine {
        public final String time;
        public final String text;
        public final ColorRGBA color;

        public LogLine(String text, ColorRGBA color) {
            this.time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            this.text = text;
            this.color = color;
        }
    }

    public static class Suggestion {
        public final String display;
        public final String insertText;
        public final String badge;
        public final boolean isActive;
        public final Runnable action;

        public Suggestion(String display, String insertText, String badge, boolean isActive, Runnable action) {
            this.display = display;
            this.insertText = insertText;
            this.badge = badge;
            this.isActive = isActive;
            this.action = action;
        }
    }

    private static final List<LogLine> HISTORY = new ArrayList<>();
    private static final List<String> COMMAND_HISTORY = new ArrayList<>();

    static {
        if (HISTORY.isEmpty()) {
            ColorRGBA cAccent = new ColorRGBA(139.0F, 92.0F, 246.0F, 255.0F);
            ColorRGBA cDim = new ColorRGBA(160.0F, 175.0F, 205.0F, 220.0F);
            HISTORY.add(new LogLine("  ____           _        _               _____                   _             _ ", cAccent));
            HISTORY.add(new LogLine(" |  _ \\ ___  ___| | _____| |_ __ _ _ __  |_   _|__ _ __ _ __ ___ (_)_ __   __ _| |", cAccent));
            HISTORY.add(new LogLine(" | |_) / _ \\/ __| |/ / __| __/ _` | '__|   | |/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` | |", cAccent));
            HISTORY.add(new LogLine(" |  _ < (_) \\__ \\   <\\__ \\ || (_| | |      | |  __/ |  | | | | | | | | | | (_| | |", cAccent));
            HISTORY.add(new LogLine(" |_| \\_\\___/|___/_|\\_\\___/\\__\\__,_|_|      |_|\\___|_|  |_| |_| |_|_|_| |_|\\__,_|_|", cAccent));
            HISTORY.add(new LogLine("Welcome to Rockstar Terminal v2.0. Type 'help' for commands, 'shell off' for CS GUI.", cDim));
            HISTORY.add(new LogLine("Configure any function settings and toggle parameters directly from suggestions.", cDim));
        }
    }

    private String currentInput = "";
    private int historyIndex = -1;
    private float scrollY = 0.0F;

    // Active SSH Session state
    private Socket sshSocket = null;
    private OutputStream sshOut = null;
    private BufferedReader sshIn = null;
    private Thread sshReaderThread = null;
    private String sshRemoteTarget = null;

    public TerminalScreen() {
        super(Text.literal("Terminal"));
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(null);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        III custom = III.I_method_5728d20f(context, mouseX, mouseY, delta);
        ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();

        // 1. Dark frosted backdrop
        custom.drawRect(0.0F, 0.0F, this.width, this.height, new ColorRGBA(0.0F, 0.0F, 0.0F, 170.0F));
        custom.drawBlurredRect(0.0F, 0.0F, this.width, this.height, 22.0F, 3.0F, IIiii_Class8.I_method_893b2757(0.0F), new ColorRGBA(theme.getRed(), theme.getGreen(), theme.getBlue(), 8.0F));

        // 2. Terminal Window Frame (macOS / Linux Hacker Aesthetic)
        float winW = Math.min(680.0F, this.width - 48.0F);
        float winH = Math.min(440.0F, this.height - 48.0F);
        float winX = (this.width - winW) / 2.0F;
        float winY = (this.height - winH) / 2.0F;
        IIiii_Class8 winRad = IIiii_Class8.I_method_893b2757(12.0F);

        // Window drop shadow & background
        custom.drawShadow(winX, winY, winW, winH, 28.0F, winRad, new ColorRGBA(0.0F, 0.0F, 0.0F, 120.0F));
        custom.drawBlurredRect(winX, winY, winW, winH, 18.0F, 4.0F, winRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 240.0F));
        custom.drawRoundedRect(winX, winY, winW, winH, winRad, new ColorRGBA(13.0F, 16.0F, 23.0F, 245.0F));
        custom.drawRoundedBorder(winX, winY, winW, winH, 1.0F, winRad, theme.withAlpha(140.0F));

        // 3. Titlebar (Height: 32px)
        float titleBarH = 32.0F;
        custom.drawRoundedRect(winX, winY, winW, titleBarH, IIiii_Class8.I_method_893b2757(12.0F), new ColorRGBA(22.0F, 27.0F, 38.0F, 230.0F));
        custom.drawRect(winX, winY + titleBarH - 1.0F, winW, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 20.0F));

        // Traffic Light Controls (Red: Close, Yellow: Clear, Green: CS GUI / Shell Off)
        float dotY = winY + (titleBarH - 11.0F) / 2.0F;
        float dotR = 5.5F;
        IIiii_Class8 dotRad = IIiii_Class8.I_method_893b2757(dotR);

        // Red (Close)
        custom.drawRoundedRect(winX + 14.0F, dotY, dotR * 2, dotR * 2, dotRad, new ColorRGBA(255.0F, 95.0F, 87.0F, 255.0F));
        // Yellow (Clear)
        custom.drawRoundedRect(winX + 32.0F, dotY, dotR * 2, dotR * 2, dotRad, new ColorRGBA(254.0F, 188.0F, 46.0F, 255.0F));
        // Green (Switch to CS GUI)
        custom.drawRoundedRect(winX + 50.0F, dotY, dotR * 2, dotR * 2, dotRad, new ColorRGBA(40.0F, 200.0F, 64.0F, 255.0F));

        // Terminal Title Center
        String termTitle = (this.sshSocket != null && this.sshRemoteTarget != null)
            ? "ssh: " + this.sshRemoteTarget + " (connected)"
            : "rockstar@client: ~ (zsh / fish)";
        IIiIIi_Class10 font = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F);
        IIiIIi_Class10 monoFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);

        float tw = font.I_method_2c375926(termTitle);
        custom.drawText(font, termTitle, winX + (winW - tw) / 2.0F, winY + (titleBarH - 7.5F) / 2.0F, new ColorRGBA(210.0F, 225.0F, 245.0F, 220.0F));

        // 4. Output History Area
        float outX = winX + 14.0F;
        float outY = winY + titleBarH + 8.0F;
        float outW = winW - 28.0F;
        float promptH = 34.0F;
        float suggestionH = 36.0F;
        float outH = winH - titleBarH - promptH - suggestionH - 16.0F;

        custom.enableScissor((int)outX, (int)outY, (int)outW, (int)outH);

        float lineHeight = 11.5F;
        float totalLogHeight = HISTORY.size() * lineHeight;
        float maxScroll = Math.max(0.0F, totalLogHeight - outH);
        float currentScroll = Math.max(0.0F, Math.min(this.scrollY, maxScroll));

        float drawLogY = outY + outH - totalLogHeight + currentScroll;

        for (LogLine line : HISTORY) {
            if (drawLogY >= outY - lineHeight && drawLogY <= outY + outH + lineHeight) {
                // Dim timestamp
                custom.drawText(monoFont, line.time, outX, drawLogY, new ColorRGBA(100.0F, 115.0F, 140.0F, 160.0F));
                // Content text
                custom.drawText(monoFont, line.text, outX + 54.0F, drawLogY, line.color);
            }
            drawLogY += lineHeight;
        }

        custom.disableScissor();

        // 5. Suggestions Bar (Clickable Chips for Modules, Settings & Accessories/Toggles)
        float sugY = winY + winH - promptH - suggestionH - 4.0F;
        List<Suggestion> suggestions = this.computeSuggestions(this.currentInput);

        if (!suggestions.isEmpty()) {
            float chipX = winX + 14.0F;
            float chipH = 20.0F;
            float maxSugW = winW - 28.0F;

            custom.drawText(monoFont, "Подсказки:", chipX, sugY - 2.0F, new ColorRGBA(140.0F, 160.0F, 195.0F, 180.0F));
            float chipsRowY = sugY + 10.0F;

            for (int i = 0; i < Math.min(6, suggestions.size()); i++) {
                Suggestion sug = suggestions.get(i);
                float labelW = monoFont.I_method_2c375926(sug.display);
                float badgeW = !sug.badge.isEmpty() ? monoFont.I_method_2c375926(sug.badge) + 8.0F : 0.0F;
                float chipW = labelW + badgeW + 16.0F;

                if (chipX + chipW > winX + maxSugW) break;

                boolean chipHov = mouseX >= chipX && mouseX <= chipX + chipW && mouseY >= chipsRowY && mouseY <= chipsRowY + chipH;
                IIiii_Class8 cRad = IIiii_Class8.I_method_893b2757(5.0F);

                ColorRGBA cBg = sug.isActive
                    ? theme.withAlpha(chipHov ? 180.0F : 130.0F)
                    : (chipHov ? new ColorRGBA(40.0F, 48.0F, 66.0F, 220.0F) : new ColorRGBA(24.0F, 28.0F, 38.0F, 190.0F));

                custom.drawRoundedRect(chipX, chipsRowY, chipW, chipH, cRad, cBg);
                custom.drawRoundedBorder(chipX, chipsRowY, chipW, chipH, 0.7F, cRad, sug.isActive ? theme : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F));

                // Chip label
                custom.drawText(monoFont, sug.display, chipX + 8.0F, chipsRowY + 5.5F, ColorRGBA.WHITE);

                // Status badge (e.g. [ON], [OFF], [MODE])
                if (!sug.badge.isEmpty()) {
                    ColorRGBA badgeCol = sug.isActive ? new ColorRGBA(80.0F, 240.0F, 130.0F, 255.0F) : new ColorRGBA(240.0F, 90.0F, 90.0F, 220.0F);
                    custom.drawText(monoFont, sug.badge, chipX + 8.0F + labelW + 4.0F, chipsRowY + 5.5F, badgeCol);
                }

                chipX += chipW + 6.0F;
            }
        }

        // 6. Command Input Prompt Row
        float promptY = winY + winH - promptH - 4.0F;
        float promptW = winW - 24.0F;
        float pX = winX + 12.0F;
        IIiii_Class8 pRad = IIiii_Class8.I_method_893b2757(6.0F);

        custom.drawRoundedRect(pX, promptY, promptW, 26.0F, pRad, new ColorRGBA(18.0F, 22.0F, 32.0F, 220.0F));
        custom.drawRoundedBorder(pX, promptY, promptW, 26.0F, 0.8F, pRad, theme.withAlpha(160.0F));

        String promptPrefix = (this.sshSocket != null) ? "ssh> " : "❯ ";
        custom.drawText(monoFont, promptPrefix, pX + 10.0F, promptY + 8.5F, theme);

        float prefW = monoFont.I_method_2c375926(promptPrefix);
        String cursor = (System.currentTimeMillis() % 1000L < 500L) ? "▋" : "";
        custom.drawText(monoFont, this.currentInput + cursor, pX + 10.0F + prefW, promptY + 8.5F, ColorRGBA.WHITE);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        this.scrollY += (float) verticalAmount * 24.0F;
        if (this.scrollY < 0.0F) this.scrollY = 0.0F;
        return true;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        float winW = Math.min(680.0F, this.width - 48.0F);
        float winH = Math.min(440.0F, this.height - 48.0F);
        float winX = (this.width - winW) / 2.0F;
        float winY = (this.height - winH) / 2.0F;

        // Traffic Light buttons
        float titleBarH = 32.0F;
        float dotY = winY + (titleBarH - 11.0F) / 2.0F;
        float dotR = 5.5F;

        // Red: Close
        if (mouseX >= winX + 14.0F && mouseX <= winX + 14.0F + dotR * 2 && mouseY >= dotY && mouseY <= dotY + dotR * 2) {
            UISoundManager.playButtonClick();
            this.close();
            return true;
        }

        // Yellow: Clear
        if (mouseX >= winX + 32.0F && mouseX <= winX + 32.0F + dotR * 2 && mouseY >= dotY && mouseY <= dotY + dotR * 2) {
            UISoundManager.playButtonClick();
            HISTORY.clear();
            HISTORY.add(new LogLine("Terminal cleared.", new ColorRGBA(140.0F, 160.0F, 195.0F, 220.0F)));
            return true;
        }

        // Green: Switch back to CS GUI (shell off)
        if (mouseX >= winX + 50.0F && mouseX <= winX + 50.0F + dotR * 2 && mouseY >= dotY && mouseY <= dotY + dotR * 2) {
            UISoundManager.playButtonClick();
            this.executeCommand("shell off");
            return true;
        }

        // Check Suggestion Chip Clicks (Toggles & Autocompletes)
        float promptH = 34.0F;
        float suggestionH = 36.0F;
        float sugY = winY + winH - promptH - suggestionH - 4.0F;
        float chipsRowY = sugY + 10.0F;
        float chipH = 20.0F;

        List<Suggestion> suggestions = this.computeSuggestions(this.currentInput);
        if (!suggestions.isEmpty() && mouseY >= chipsRowY && mouseY <= chipsRowY + chipH) {
            float chipX = winX + 14.0F;
            float maxSugW = winW - 28.0F;
            IIiIIi_Class10 monoFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);

            for (int i = 0; i < Math.min(6, suggestions.size()); i++) {
                Suggestion sug = suggestions.get(i);
                float labelW = monoFont.I_method_2c375926(sug.display);
                float badgeW = !sug.badge.isEmpty() ? monoFont.I_method_2c375926(sug.badge) + 8.0F : 0.0F;
                float chipW = labelW + badgeW + 16.0F;

                if (chipX + chipW > winX + maxSugW) break;

                if (mouseX >= chipX && mouseX <= chipX + chipW) {
                    UISoundManager.playButtonClick();
                    if (sug.action != null) {
                        sug.action.run();
                    } else if (sug.insertText != null) {
                        this.currentInput = sug.insertText;
                    }
                    return true;
                }

                chipX += chipW + 6.0F;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            if (this.sshSocket != null) {
                this.closeSsh();
                return true;
            }
            this.close();
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_ENTER || keyCode == GLFW.GLFW_KEY_KP_ENTER) {
            if (!this.currentInput.trim().isEmpty()) {
                String cmd = this.currentInput;
                this.currentInput = "";
                this.historyIndex = -1;
                this.executeCommand(cmd);
            }
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_BACKSPACE) {
            if (!this.currentInput.isEmpty()) {
                this.currentInput = this.currentInput.substring(0, this.currentInput.length() - 1);
            }
            return true;
        }

        // Tab: Auto-complete first suggestion
        if (keyCode == GLFW.GLFW_KEY_TAB) {
            List<Suggestion> sugs = this.computeSuggestions(this.currentInput);
            if (!sugs.isEmpty()) {
                Suggestion first = sugs.get(0);
                if (first.action != null && this.currentInput.endsWith(first.insertText)) {
                    first.action.run();
                } else if (first.insertText != null) {
                    this.currentInput = first.insertText;
                }
                UISoundManager.playButtonClick();
            }
            return true;
        }

        // Up arrow: Command history back
        if (keyCode == GLFW.GLFW_KEY_UP) {
            if (!COMMAND_HISTORY.isEmpty()) {
                if (this.historyIndex == -1) {
                    this.historyIndex = COMMAND_HISTORY.size() - 1;
                } else if (this.historyIndex > 0) {
                    this.historyIndex--;
                }
                this.currentInput = COMMAND_HISTORY.get(this.historyIndex);
            }
            return true;
        }

        // Down arrow: Command history forward
        if (keyCode == GLFW.GLFW_KEY_DOWN) {
            if (this.historyIndex != -1) {
                if (this.historyIndex < COMMAND_HISTORY.size() - 1) {
                    this.historyIndex++;
                    this.currentInput = COMMAND_HISTORY.get(this.historyIndex);
                } else {
                    this.historyIndex = -1;
                    this.currentInput = "";
                }
            }
            return true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (Character.isDefined(chr) && chr >= 32) {
            this.currentInput += chr;
            return true;
        }
        return super.charTyped(chr, modifiers);
    }

    private void executeCommand(String rawCmd) {
        String cmd = rawCmd.trim();
        COMMAND_HISTORY.add(cmd);
        HISTORY.add(new LogLine("❯ " + cmd, ColorRGBA.WHITE));

        // If active SSH session, forward command to remote server
        if (this.sshSocket != null && this.sshOut != null) {
            if ("exit".equalsIgnoreCase(cmd) || "quit".equalsIgnoreCase(cmd)) {
                this.closeSsh();
                return;
            }
            try {
                this.sshOut.write((cmd + "\n").getBytes(StandardCharsets.UTF_8));
                this.sshOut.flush();
            } catch (Throwable t) {
                HISTORY.add(new LogLine("[SSH ERR] " + t.getMessage(), new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F)));
                this.closeSsh();
            }
            return;
        }

        String[] parts = cmd.split("\\s+");
        String first = parts[0].toLowerCase();

        switch (first) {
            case "help" -> {
                HISTORY.add(new LogLine("Available Commands:", new ColorRGBA(139.0F, 92.0F, 246.0F, 255.0F)));
                HISTORY.add(new LogLine("  <module>                       - Toggle module on/off", ColorRGBA.WHITE));
                HISTORY.add(new LogLine("  <module> <setting> <value>     - Configure parameter or accessory switch", ColorRGBA.WHITE));
                HISTORY.add(new LogLine("  list / ls                      - List all modules and states", ColorRGBA.WHITE));
                HISTORY.add(new LogLine("  get <module>                   - Inspect all settings of a module", ColorRGBA.WHITE));
                HISTORY.add(new LogLine("  shell off / shell on           - Toggle terminal mode back to CS GUI", ColorRGBA.WHITE));
                HISTORY.add(new LogLine("  ssh <user>@<host> [-p <port>]  - Connect to remote server directly in-game", ColorRGBA.WHITE));
                HISTORY.add(new LogLine("  clear                          - Clear terminal output history", ColorRGBA.WHITE));
            }
            case "clear" -> {
                HISTORY.clear();
            }
            case "shell" -> {
                if (parts.length > 1 && "off".equalsIgnoreCase(parts[1])) {
                    InterfaceModule.setTerminalMode(false);
                    HISTORY.add(new LogLine("[OK] Terminal Mode disabled. Opening CS GUI...", new ColorRGBA(80.0F, 230.0F, 120.0F, 255.0F)));
                    if (this.client != null) {
                        this.client.setScreen(new IiiIiIiiI_Class215());
                    }
                } else if (parts.length > 1 && "on".equalsIgnoreCase(parts[1])) {
                    InterfaceModule.setTerminalMode(true);
                    HISTORY.add(new LogLine("[OK] Terminal Mode enabled.", new ColorRGBA(80.0F, 230.0F, 120.0F, 255.0F)));
                } else {
                    HISTORY.add(new LogLine("Usage: shell on | shell off", new ColorRGBA(240.0F, 190.0F, 60.0F, 255.0F)));
                }
            }
            case "list", "ls", "modules" -> {
                if (RockstarClient.getInstance() == null || RockstarClient.getInstance().getModuleManager() == null) return;
                List<ModuleEntry> mods = RockstarClient.getInstance().getModuleManager().getModules();
                HISTORY.add(new LogLine("Modules (" + mods.size() + "):", new ColorRGBA(139.0F, 92.0F, 246.0F, 255.0F)));
                StringBuilder sb = new StringBuilder();
                for (ModuleEntry m : mods) {
                    String status = m.isEnabled() ? "[ON]" : "[OFF]";
                    sb.append(m.getName()).append(" ").append(status).append(", ");
                    if (sb.length() > 65) {
                        HISTORY.add(new LogLine("  " + sb.toString(), new ColorRGBA(180.0F, 200.0F, 230.0F, 220.0F)));
                        sb.setLength(0);
                    }
                }
                if (sb.length() > 0) {
                    HISTORY.add(new LogLine("  " + sb.toString(), new ColorRGBA(180.0F, 200.0F, 230.0F, 220.0F)));
                }
            }
            case "ssh" -> {
                if (parts.length < 2) {
                    HISTORY.add(new LogLine("Usage: ssh <user>@<host> [-p <port>]", new ColorRGBA(240.0F, 190.0F, 60.0F, 255.0F)));
                    return;
                }
                this.connectSsh(parts);
            }
            case "get" -> {
                if (parts.length < 2) {
                    HISTORY.add(new LogLine("Usage: get <module>", new ColorRGBA(240.0F, 190.0F, 60.0F, 255.0F)));
                    return;
                }
                ModuleEntry mod = this.findModule(parts[1]);
                if (mod == null) {
                    HISTORY.add(new LogLine("[ERR] Module '" + parts[1] + "' not found.", new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F)));
                    return;
                }
                HISTORY.add(new LogLine(mod.getName() + " Settings:", new ColorRGBA(139.0F, 92.0F, 246.0F, 255.0F)));
                for (Setting s : mod.getSettings()) {
                    HISTORY.add(new LogLine("  • " + s.getName() + " (" + s.getClass().getSimpleName() + ")", new ColorRGBA(200.0F, 220.0F, 245.0F, 220.0F)));
                }
            }
            default -> {
                // Try module toggle or module setting configuration
                ModuleEntry targetMod = this.findModule(parts[0]);
                if (targetMod != null) {
                    if (parts.length == 1) {
                        // Just module name: toggle it!
                        targetMod.setEnabled(!targetMod.isEnabled(), false);
                        String st = targetMod.isEnabled() ? "ENABLED" : "DISABLED";
                        ColorRGBA c = targetMod.isEnabled() ? new ColorRGBA(80.0F, 230.0F, 120.0F, 255.0F) : new ColorRGBA(240.0F, 80.0F, 80.0F, 255.0F);
                        HISTORY.add(new LogLine("[OK] " + targetMod.getName() + " is now " + st, c));
                    } else {
                        // Module with setting and value: e.g. Headwear "Headwear & Face" "Cat Ears"
                        this.handleSettingConfig(targetMod, cmd);
                    }
                } else {
                    HISTORY.add(new LogLine("[ERR] Unknown command or module: '" + parts[0] + "'. Type 'help' for info.", new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F)));
                }
            }
        }
    }

    private void handleSettingConfig(ModuleEntry mod, String fullCmd) {
        String[] tokens = parseArguments(fullCmd);
        if (tokens.length < 2) return;

        String settingQuery = tokens[1];
        Setting targetSetting = null;

        for (Setting s : mod.getSettings()) {
            if (s.getName().equalsIgnoreCase(settingQuery)) {
                targetSetting = s;
                break;
            }
        }
        if (targetSetting == null) {
            for (Setting s : mod.getSettings()) {
                if (s.getName().toLowerCase().contains(settingQuery.toLowerCase())) {
                    targetSetting = s;
                    break;
                }
            }
        }

        if (targetSetting == null) {
            HISTORY.add(new LogLine("[ERR] Setting '" + settingQuery + "' not found in " + mod.getName() + ".", new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F)));
            return;
        }

        String valToken = tokens.length > 2 ? tokens[2] : "";

        // 1. MultiSelectSetting (аксессуары / тумблеры выбора)
        if (targetSetting instanceof MultiSelectSetting ms) {
            MultiSelectSetting.Nested1_42856060 targetOption = null;
            for (MultiSelectSetting.Nested1_42856060 opt : ms.I_field_7865b31) {
                if (opt.getName().equalsIgnoreCase(valToken) || opt.getName().toLowerCase().contains(valToken.toLowerCase())) {
                    targetOption = opt;
                    break;
                }
            }
            if (targetOption != null) {
                boolean wasSelected = targetOption.isSelected();
                targetOption.toggle();
                boolean nowSelected = targetOption.isSelected();
                String st = nowSelected ? "ON" : "OFF";
                ColorRGBA c = nowSelected ? new ColorRGBA(80.0F, 230.0F, 120.0F, 255.0F) : new ColorRGBA(240.0F, 80.0F, 80.0F, 255.0F);
                HISTORY.add(new LogLine("[OK] " + mod.getName() + " > " + targetSetting.getName() + " > [" + targetOption.getName() + "]: " + st, c));
            } else {
                HISTORY.add(new LogLine("[ERR] Option '" + valToken + "' not found in " + targetSetting.getName() + ".", new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F)));
            }
            return;
        }

        // 2. BooleanSetting (тумблер)
        if (targetSetting instanceof BooleanSetting bs) {
            boolean nextVal;
            if ("toggle".equalsIgnoreCase(valToken) || valToken.isEmpty()) {
                nextVal = !bs.i_method_9b12da03();
            } else {
                nextVal = "true".equalsIgnoreCase(valToken) || "on".equalsIgnoreCase(valToken) || "1".equals(valToken);
            }
            bs.I_method_4e1408b5(nextVal);
            String st = nextVal ? "ON" : "OFF";
            ColorRGBA c = nextVal ? new ColorRGBA(80.0F, 230.0F, 120.0F, 255.0F) : new ColorRGBA(240.0F, 80.0F, 80.0F, 255.0F);
            HISTORY.add(new LogLine("[OK] " + mod.getName() + " > " + targetSetting.getName() + ": " + st, c));
            return;
        }

        // 3. ModeSetting
        if (targetSetting instanceof ModeSetting modeSet) {
            ModeSetting.Nested1_42765c60 targetMode = null;
            for (ModeSetting.Nested1_42765c60 m : modeSet.I_field_7865b31) {
                if (m.getName().equalsIgnoreCase(valToken) || m.getName().toLowerCase().contains(valToken.toLowerCase())) {
                    targetMode = m;
                    break;
                }
            }
            if (targetMode != null) {
                targetMode.select();
                HISTORY.add(new LogLine("[OK] " + mod.getName() + " > " + targetSetting.getName() + " set to " + targetMode.getName(), new ColorRGBA(80.0F, 230.0F, 120.0F, 255.0F)));
            } else {
                HISTORY.add(new LogLine("[ERR] Mode '" + valToken + "' not found.", new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F)));
            }
            return;
        }

        // 4. SliderSetting
        if (targetSetting instanceof SliderSetting ss) {
            try {
                float num = Float.parseFloat(valToken);
                ss.Ii_method_4e0e6b54(num);
                HISTORY.add(new LogLine("[OK] " + mod.getName() + " > " + targetSetting.getName() + " set to " + ss.Ii_method_a20abcd2(), new ColorRGBA(80.0F, 230.0F, 120.0F, 255.0F)));
            } catch (Exception e) {
                HISTORY.add(new LogLine("[ERR] Invalid number for slider: '" + valToken + "'", new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F)));
            }
        }
    }

    private List<Suggestion> computeSuggestions(String input) {
        List<Suggestion> list = new ArrayList<>();
        String trimmed = input.trim();
        String[] tokens = parseArguments(input);

        // State 0: Typing command or module name
        if (tokens.length <= 1 && !input.endsWith(" ")) {
            String q = tokens.length == 1 ? tokens[0].toLowerCase() : "";

            // System commands
            String[] cmds = { "help", "list", "shell off", "shell on", "clear", "ssh" };
            for (String c : cmds) {
                if (c.toLowerCase().startsWith(q)) {
                    list.add(new Suggestion(c, c + " ", "[CMD]", false, () -> this.currentInput = c + " "));
                }
            }

            // Matching modules
            if (RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null) {
                for (ModuleEntry m : RockstarClient.getInstance().getModuleManager().getModules()) {
                    if (m.getName().toLowerCase().startsWith(q)) {
                        String badge = m.isEnabled() ? "[ON]" : "[OFF]";
                        list.add(new Suggestion(m.getName(), m.getName() + " ", badge, m.isEnabled(), () -> this.currentInput = m.getName() + " "));
                    }
                }
            }
            return list;
        }

        // State 1: Module chosen, typing setting name
        ModuleEntry mod = this.findModule(tokens[0]);
        if (mod != null && (tokens.length == 1 || (tokens.length == 2 && !input.endsWith(" ")))) {
            String q = tokens.length == 2 ? tokens[1].toLowerCase() : "";
            for (Setting s : mod.getSettings()) {
                if (s.getName().toLowerCase().contains(q)) {
                    String badge = s.getClass().getSimpleName().replace("Setting", "");
                    String ins = tokens[0] + " \"" + s.getName() + "\" ";
                    list.add(new Suggestion(s.getName(), ins, "[" + badge + "]", false, () -> this.currentInput = ins));
                }
            }
            return list;
        }

        // State 2: Module and Setting chosen, typing values / toggling accessories
        if (mod != null && tokens.length >= 2) {
            String sQuery = tokens[1];
            Setting found = null;
            for (Setting s : mod.getSettings()) {
                if (s.getName().equalsIgnoreCase(sQuery) || s.getName().toLowerCase().contains(sQuery.toLowerCase())) {
                    found = s;
                    break;
                }
            }
            if (found == null) return list;
            final Setting targetSetting = found;

            if (targetSetting instanceof MultiSelectSetting ms) {
                // SUGGEST ACCESSORY SWITCHES / TUMBLERS! (например аксы выбирать)
                String optQuery = tokens.length >= 3 && !input.endsWith(" ") ? tokens[2].toLowerCase() : "";
                for (MultiSelectSetting.Nested1_42856060 opt : ms.I_field_7865b31) {
                    if (optQuery.isEmpty() || opt.getName().toLowerCase().contains(optQuery)) {
                        boolean sel = opt.isSelected();
                        String badge = sel ? "[ON]" : "[OFF]";
                        // Clicking this suggestion chip immediately toggles the accessory switch!
                        list.add(new Suggestion(opt.getName(), tokens[0] + " \"" + targetSetting.getName() + "\" \"" + opt.getName() + "\"", badge, sel, () -> {
                            opt.toggle();
                            this.executeCommand(tokens[0] + " \"" + targetSetting.getName() + "\" \"" + opt.getName() + "\"");
                        }));
                    }
                }
                return list;
            }

            if (targetSetting instanceof BooleanSetting bs) {
                boolean cur = bs.i_method_9b12da03();
                list.add(new Suggestion("toggle", tokens[0] + " \"" + targetSetting.getName() + "\" toggle", cur ? "[ON]" : "[OFF]", cur, () -> {
                    this.executeCommand(tokens[0] + " \"" + targetSetting.getName() + "\" toggle");
                }));
                list.add(new Suggestion("true", tokens[0] + " \"" + targetSetting.getName() + "\" true", "[ON]", cur, () -> {
                    this.executeCommand(tokens[0] + " \"" + targetSetting.getName() + "\" true");
                }));
                list.add(new Suggestion("false", tokens[0] + " \"" + targetSetting.getName() + "\" false", "[OFF]", !cur, () -> {
                    this.executeCommand(tokens[0] + " \"" + targetSetting.getName() + "\" false");
                }));
                return list;
            }

            if (targetSetting instanceof ModeSetting modeSet) {
                for (ModeSetting.Nested1_42765c60 m : modeSet.I_field_7865b31) {
                    boolean active = m.equals(modeSet.i_method_f85f3850());
                    list.add(new Suggestion(m.getName(), tokens[0] + " \"" + targetSetting.getName() + "\" \"" + m.getName() + "\"", active ? "[ACTIVE]" : "", active, () -> {
                        this.executeCommand(tokens[0] + " \"" + targetSetting.getName() + "\" \"" + m.getName() + "\"");
                    }));
                }
                return list;
            }
        }

        return list;
    }

    private ModuleEntry findModule(String name) {
        if (RockstarClient.getInstance() == null || RockstarClient.getInstance().getModuleManager() == null) return null;
        for (ModuleEntry m : RockstarClient.getInstance().getModuleManager().getModules()) {
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        for (ModuleEntry m : RockstarClient.getInstance().getModuleManager().getModules()) {
            if (m.getName().toLowerCase().contains(name.toLowerCase())) return m;
        }
        return null;
    }

    private static String[] parseArguments(String line) {
        List<String> list = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '\"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                if (current.length() > 0) {
                    list.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            list.add(current.toString());
        }
        return list.toArray(new String[0]);
    }

    private void connectSsh(String[] parts) {
        String target = parts[1];
        int port = 22;
        if (parts.length >= 4 && "-p".equalsIgnoreCase(parts[2])) {
            try {
                port = Integer.parseInt(parts[3]);
            } catch (Exception ignored) {}
        }

        String user = "root";
        String host = target;
        if (target.contains("@")) {
            String[] split = target.split("@", 2);
            user = split[0];
            host = split[1];
        }

        this.sshRemoteTarget = user + "@" + host + ":" + port;
        HISTORY.add(new LogLine("[SSH] Connecting to " + this.sshRemoteTarget + "...", new ColorRGBA(139.0F, 92.0F, 246.0F, 255.0F)));

        final String finalHost = host;
        final int finalPort = port;

        Thread connThread = new Thread(() -> {
            try {
                this.sshSocket = new Socket(finalHost, finalPort);
                this.sshSocket.setSoTimeout(0);
                this.sshOut = this.sshSocket.getOutputStream();
                this.sshIn = new BufferedReader(new InputStreamReader(this.sshSocket.getInputStream(), StandardCharsets.UTF_8));

                HISTORY.add(new LogLine("[SSH] Connected to " + this.sshRemoteTarget + ". Type commands or 'exit'.", new ColorRGBA(80.0F, 230.0F, 120.0F, 255.0F)));

                this.sshReaderThread = new Thread(() -> {
                    try {
                        String line;
                        while ((line = this.sshIn.readLine()) != null) {
                            HISTORY.add(new LogLine("[REMOTE] " + line, new ColorRGBA(210.0F, 230.0F, 255.0F, 240.0F)));
                        }
                    } catch (Throwable ignored) {
                    } finally {
                        this.closeSsh();
                    }
                }, "Rockstar-SSH-Reader");
                this.sshReaderThread.setDaemon(true);
                this.sshReaderThread.start();

            } catch (Throwable t) {
                HISTORY.add(new LogLine("[SSH ERR] Connection failed: " + t.getMessage(), new ColorRGBA(240.0F, 70.0F, 70.0F, 255.0F)));
                this.closeSsh();
            }
        }, "Rockstar-SSH-Connect");
        connThread.setDaemon(true);
        connThread.start();
    }

    private void closeSsh() {
        try {
            if (this.sshOut != null) this.sshOut.close();
            if (this.sshIn != null) this.sshIn.close();
            if (this.sshSocket != null) this.sshSocket.close();
        } catch (Throwable ignored) {}
        this.sshSocket = null;
        this.sshOut = null;
        this.sshIn = null;
        this.sshRemoteTarget = null;
        HISTORY.add(new LogLine("[SSH] Session closed. Returned to local shell.", new ColorRGBA(240.0F, 180.0F, 80.0F, 255.0F)));
    }
}
