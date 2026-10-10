package rockstar.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public class BrowserScreen extends ii_Class4 {
    private final Screen parentScreen;
    private final String initialQuery;

    private static JDialog browserDialog;
    private static JFXPanel jfxPanel;
    private static WebView webView;
    private static WebEngine webEngine;
    private static JTextField urlField;
    private static JLabel titleLabel;
    private static JProgressBar progressBar;
    private static boolean jfxInitialized = false;

    private static int lastWinX = -1, lastWinY = -1, lastWinW = -1, lastWinH = -1;

    public BrowserScreen(Screen parentScreen, String query) {
        this.parentScreen = parentScreen;
        this.initialQuery = query != null ? query.trim() : "";
    }

    @Override
    protected void init() {
        super.init();
        String targetUrl = resolveUrl(this.initialQuery);
        SwingUtilities.invokeLater(() -> openBrowser(targetUrl));
    }

    private void openBrowser(String initialUrl) {
        try {
            if (browserDialog == null) {
                initDialog();
            }

            // Sync bounds with Minecraft GLFW window
            syncWindowBounds();

            if (browserDialog != null) {
                browserDialog.setVisible(true);
                browserDialog.toFront();
                browserDialog.requestFocus();
            }

            if (urlField != null) {
                urlField.setText(initialUrl);
            }

            if (webEngine != null) {
                Platform.runLater(() -> {
                    try {
                        webEngine.load(initialUrl);
                    } catch (Throwable ignored) {}
                });
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void initDialog() {
        browserDialog = new JDialog();
        browserDialog.setUndecorated(true);
        browserDialog.setType(JFrame.Type.UTILITY);
        browserDialog.setAlwaysOnTop(true);
        browserDialog.getContentPane().setBackground(new Color(16, 18, 26));
        browserDialog.setLayout(new BorderLayout());

        // --- TOP TOOLBAR ---
        JPanel topBar = new JPanel();
        topBar.setBackground(new Color(20, 24, 34));
        topBar.setPreferredSize(new Dimension(800, 44));
        topBar.setLayout(new BorderLayout(8, 0));
        topBar.setBorder(new EmptyBorder(6, 12, 6, 12));

        // 1. Left Navigation Controls (Back, Forward, Reload, Home)
        JPanel leftNav = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        leftNav.setOpaque(false);

        // Agravity Logo Pill
        JLabel brandLabel = new JLabel(" Agravity ");
        brandLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        brandLabel.setForeground(new Color(168, 85, 247));
        brandLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(168, 85, 247, 100), 1, true),
            new EmptyBorder(2, 6, 2, 6)
        ));
        leftNav.add(brandLabel);

        JButton btnBack = createStyledButton("◀", "Назад", e -> {
            Platform.runLater(() -> {
                if (webEngine != null && webEngine.getHistory().getCurrentIndex() > 0) {
                    webEngine.getHistory().go(-1);
                }
            });
        });
        JButton btnFwd = createStyledButton("▶", "Вперед", e -> {
            Platform.runLater(() -> {
                if (webEngine != null && webEngine.getHistory().getCurrentIndex() < webEngine.getHistory().getEntries().size() - 1) {
                    webEngine.getHistory().go(1);
                }
            });
        });
        JButton btnReload = createStyledButton("↻", "Обновить", e -> {
            Platform.runLater(() -> {
                if (webEngine != null) webEngine.reload();
            });
        });
        JButton btnHome = createStyledButton("⌂", "Домой (Google)", e -> {
            Platform.runLater(() -> {
                if (webEngine != null) webEngine.load("https://www.google.com");
            });
        });

        leftNav.add(btnBack);
        leftNav.add(btnFwd);
        leftNav.add(btnReload);
        leftNav.add(btnHome);
        topBar.add(leftNav, BorderLayout.WEST);

        // 2. Center Omnibox / URL Field
        urlField = new JTextField();
        urlField.setBackground(new Color(28, 32, 46));
        urlField.setForeground(Color.WHITE);
        urlField.setCaretColor(new Color(168, 85, 247));
        urlField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        urlField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(55, 62, 85), 1, true),
            new EmptyBorder(4, 10, 4, 10)
        ));
        urlField.addActionListener(e -> {
            String text = urlField.getText();
            String target = resolveUrl(text);
            Platform.runLater(() -> {
                if (webEngine != null) webEngine.load(target);
            });
        });
        urlField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    closeFromBrowser();
                }
            }
        });
        topBar.add(urlField, BorderLayout.CENTER);

        // 3. Right Bookmarks & Close Button
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        rightPanel.setOpaque(false);

        JButton bmYt = createBookmarkButton("YouTube", new Color(239, 68, 68), "https://youtube.com");
        JButton bmVk = createBookmarkButton("VK", new Color(6, 182, 212), "https://vk.com");
        JButton bmWiki = createBookmarkButton("Wiki", new Color(16, 185, 129), "https://minecraft.wiki");
        JButton bmGh = createBookmarkButton("GitHub", new Color(148, 163, 184), "https://github.com");

        JButton btnClose = new JButton("✕");
        btnClose.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnClose.setForeground(Color.WHITE);
        btnClose.setBackground(new Color(239, 68, 68));
        btnClose.setFocusPainted(false);
        btnClose.setBorderPainted(false);
        btnClose.setPreferredSize(new Dimension(30, 26));
        btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClose.setToolTipText("Закрыть и вернуться в игру (Esc)");
        btnClose.addActionListener(e -> closeFromBrowser());

        rightPanel.add(bmYt);
        rightPanel.add(bmVk);
        rightPanel.add(bmWiki);
        rightPanel.add(bmGh);
        rightPanel.add(Box.createHorizontalStrut(6));
        rightPanel.add(btnClose);
        topBar.add(rightPanel, BorderLayout.EAST);

        // Top Wrapper with Bottom Progress Bar
        JPanel topWrapper = new JPanel(new BorderLayout());
        topWrapper.setBackground(new Color(20, 24, 34));
        topWrapper.add(topBar, BorderLayout.NORTH);

        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(800, 2));
        progressBar.setForeground(new Color(168, 85, 247));
        progressBar.setBackground(new Color(20, 24, 34));
        progressBar.setBorder(null);
        progressBar.setVisible(false);
        topWrapper.add(progressBar, BorderLayout.SOUTH);

        browserDialog.getContentPane().add(topWrapper, BorderLayout.NORTH);

        // --- CENTER JFX PANEL WITH WEBVIEW ---
        jfxPanel = new JFXPanel();
        browserDialog.getContentPane().add(jfxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            try {
                webView = new WebView();
                webView.setContextMenuEnabled(true);
                webEngine = webView.getEngine();
                webEngine.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");

                // Location Listener
                webEngine.locationProperty().addListener((obs, oldLoc, newLoc) -> {
                    if (newLoc != null) {
                        SwingUtilities.invokeLater(() -> {
                            if (urlField != null && !urlField.isFocusOwner()) {
                                urlField.setText(newLoc);
                            }
                        });
                    }
                });

                // Progress Listener
                webEngine.getLoadWorker().progressProperty().addListener((obs, oldVal, newVal) -> {
                    SwingUtilities.invokeLater(() -> {
                        if (progressBar != null) {
                            int prog = (int) (newVal.doubleValue() * 100);
                            progressBar.setValue(prog);
                            progressBar.setVisible(prog > 0 && prog < 100);
                        }
                    });
                });

                Scene scene = new Scene(webView);
                scene.setOnKeyPressed(event -> {
                    if (event.getCode() == javafx.scene.input.KeyCode.ESCAPE) {
                        closeFromBrowser();
                    }
                });
                jfxPanel.setScene(scene);
                jfxInitialized = true;
            } catch (Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private static JButton createStyledButton(String text, String tooltip, java.awt.event.ActionListener action) {
        JButton btn = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isRollover() ? new Color(50, 58, 80) : new Color(30, 36, 50));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 6, 6);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setForeground(Color.WHITE);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setPreferredSize(new Dimension(28, 26));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setToolTipText(tooltip);
        btn.addActionListener(action);
        return btn;
    }

    private static JButton createBookmarkButton(String title, Color accent, String url) {
        JButton btn = new JButton(title) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isRollover()) {
                    g2.setColor(new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), 60));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 6, 6);
                    g2.setColor(accent);
                    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 6, 6);
                } else {
                    g2.setColor(new Color(28, 34, 46));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 6, 6);
                }
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btn.setForeground(Color.WHITE);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setPreferredSize(new Dimension(btn.getFontMetrics(btn.getFont()).stringWidth(title) + 16, 26));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(e -> {
            if (urlField != null) urlField.setText(url);
            Platform.runLater(() -> {
                if (webEngine != null) webEngine.load(url);
            });
        });
        return btn;
    }

    private static void syncWindowBounds() {
        if (browserDialog == null) return;
        try {
            long handle = MinecraftClient.getInstance().getWindow().getHandle();
            int[] wx = new int[1], wy = new int[1], ww = new int[1], wh = new int[1];
            GLFW.glfwGetWindowPos(handle, wx, wy);
            GLFW.glfwGetWindowSize(handle, ww, wh);

            boolean isIconified = GLFW.glfwGetWindowAttrib(handle, GLFW.GLFW_ICONIFIED) != 0;
            if (isIconified) {
                if (browserDialog.isVisible()) browserDialog.setVisible(false);
                return;
            }

            int pad = 24;
            int targetX = wx[0] + pad;
            int targetY = wy[0] + pad;
            int targetW = Math.max(680, ww[0] - pad * 2);
            int targetH = Math.max(480, wh[0] - pad * 2);

            if (browserDialog.getX() != targetX || browserDialog.getY() != targetY ||
                browserDialog.getWidth() != targetW || browserDialog.getHeight() != targetH) {
                browserDialog.setBounds(targetX, targetY, targetW, targetH);
            }
        } catch (Throwable ignored) {}
    }

    private static String resolveUrl(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "https://www.google.com";
        }
        String s = input.trim();
        if (s.startsWith("http://") || s.startsWith("https://")) {
            return s;
        }
        if (!s.contains(" ") && (s.contains(".com") || s.contains(".ru") || s.contains(".net") ||
            s.contains(".org") || s.contains(".io") || s.contains(".gg") || s.contains(".su") ||
            s.contains(".to") || s.contains(".tv") || s.contains(".wiki") || s.contains(".dev"))) {
            return "https://" + s;
        }
        return "https://www.google.com/search?q=" + URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    private static void closeFromBrowser() {
        SwingUtilities.invokeLater(() -> {
            if (browserDialog != null) {
                browserDialog.setVisible(false);
            }
        });
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            mc.execute(() -> {
                if (mc.currentScreen instanceof BrowserScreen) {
                    BrowserScreen bs = (BrowserScreen) mc.currentScreen;
                    mc.setScreen(bs.parentScreen);
                }
            });
        }
    }

    @Override
    public void render(III custom) {
        // Keep browser dialog synced with Minecraft window
        syncWindowBounds();

        // Dark frosted backdrop behind browser window inside Minecraft
        custom.drawRect(0.0F, 0.0F, (float)this.width, (float)this.height, new ColorRGBA(12.0F, 14.0F, 20.0F, 245.0F));

        IIiIIi_Class10 font = null;
        IIiIIi_Class10 subFont = null;
        try {
            if (IIiIiI_Class11.i_field_857c0621 != null) {
                font = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F);
                subFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(9.0F);
            }
        } catch (Throwable ignored) {}

        if (font != null) {
            String title = "🌐 Встроенный браузер Agravity Web";
            float tw = font.I_method_2c375926(title);
            custom.drawText(font, title, ((float)this.width - tw) / 2.0F, 10.0F, ColorRGBA.WHITE);
        }
        if (subFont != null) {
            String hint = "Нажмите [Esc] или кнопку [✕] в браузере, чтобы вернуться в игру";
            float hw = subFont.I_method_2c375926(hint);
            custom.drawText(subFont, hint, ((float)this.width - hw) / 2.0F, (float)this.height - 18.0F, new ColorRGBA(255.0F, 255.0F, 255.0F, 160.0F));
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void close() {
        SwingUtilities.invokeLater(() -> {
            if (browserDialog != null) {
                browserDialog.setVisible(false);
            }
        });
        if (this.client != null) {
            this.client.setScreen(this.parentScreen);
        }
    }

    @Override
    public void removed() {
        super.removed();
        SwingUtilities.invokeLater(() -> {
            if (browserDialog != null) {
                browserDialog.setVisible(false);
            }
        });
    }
}
