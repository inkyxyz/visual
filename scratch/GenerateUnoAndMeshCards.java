import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GenerateUnoAndMeshCards {

    private static final int W = 512;
    private static final int H = 720;
    private static final File OUT_DIR = new File("src/main/resources/assets/rockstar/textures/cards");

    public static void main(String[] args) throws Exception {
        OUT_DIR.mkdirs();

        generateClassicMeshBack(new File(OUT_DIR, "card_back_mesh.png"), new Color(195, 20, 30), new Color(130, 10, 18));
        generateClassicMeshBack(new File(OUT_DIR, "card_back_mesh_blue.png"), new Color(20, 60, 175), new Color(10, 35, 110));
        generateUnoBack(new File(OUT_DIR, "card_back_uno.png"));

        // Uno Face Cards
        generateUnoCard(new File(OUT_DIR, "uno_red.png"), new Color(237, 28, 36), "7", "7");
        generateUnoCard(new File(OUT_DIR, "uno_blue.png"), new Color(0, 114, 188), "5", "5");
        generateUnoCard(new File(OUT_DIR, "uno_green.png"), new Color(0, 166, 81), "3", "3");
        generateUnoCard(new File(OUT_DIR, "uno_yellow.png"), new Color(255, 222, 23), "9", "9");
        generateUnoReverse(new File(OUT_DIR, "uno_reverse.png"), new Color(237, 28, 36));
        generateUnoSkip(new File(OUT_DIR, "uno_skip.png"), new Color(0, 114, 188));
        generateUnoDrawTwo(new File(OUT_DIR, "uno_draw2.png"), new Color(0, 166, 81));
        generateUnoWild(new File(OUT_DIR, "uno_wild.png"));
        generateUnoDrawFour(new File(OUT_DIR, "uno_draw4.png"));

        System.out.println("All Uno & Classic Mesh cards generated successfully!");
    }

    // 1. Classic Diamond Lattice / Crosshatch Mesh Card Back (Bee / Bicycle style)
    private static void generateClassicMeshBack(File file, Color mainCol, Color darkCol) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // White card stock with rounded corners
        RoundRectangle2D.Float cardShape = new RoundRectangle2D.Float(10, 10, W - 20, H - 20, 36, 36);
        g.setColor(new Color(250, 248, 242));
        g.fill(cardShape);

        // Inner border inset
        int margin = 32;
        RoundRectangle2D.Float innerArea = new RoundRectangle2D.Float(margin, margin, W - margin * 2, H - margin * 2, 22, 22);

        // Clip to inner area for diamond mesh pattern
        Shape oldClip = g.getClip();
        g.setClip(innerArea);

        // Background
        g.setColor(mainCol);
        g.fill(innerArea);

        // Draw diamond lattice crosshatch grid
        g.setColor(darkCol);
        g.setStroke(new BasicStroke(2.2f));

        int step = 20;
        for (int d = -H; d < W + H; d += step) {
            g.drawLine(d, 0, d + H, H);
            g.drawLine(d, H, d + H, 0);
        }

        // Finer inner cross lines for genuine Bee casino mesh
        g.setColor(new Color(255, 255, 255, 45));
        g.setStroke(new BasicStroke(1.2f));
        for (int d = -H + step / 2; d < W + H; d += step) {
            g.drawLine(d, 0, d + H, H);
            g.drawLine(d, H, d + H, 0);
        }

        g.setClip(oldClip);

        // Double border frame
        g.setColor(mainCol);
        g.setStroke(new BasicStroke(4.0f));
        g.draw(innerArea);

        RoundRectangle2D.Float outerLine = new RoundRectangle2D.Float(margin - 8, margin - 8, (W - margin * 2) + 16, (H - margin * 2) + 16, 26, 26);
        g.setStroke(new BasicStroke(2.0f));
        g.draw(outerLine);

        // Thin outer card border
        g.setColor(new Color(200, 195, 185));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(cardShape);

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 2. Iconic UNO Card Back
    private static void generateUnoBack(File file) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Black card stock with rounded corners
        RoundRectangle2D.Float cardShape = new RoundRectangle2D.Float(8, 8, W - 16, H - 16, 42, 42);
        g.setColor(new Color(22, 22, 24));
        g.fill(cardShape);

        // White border
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(14.0f));
        g.draw(new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 32, 32));

        // Center tilted Red Oval
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(W / 2.0, H / 2.0);
        g2.rotate(Math.toRadians(-28.0));

        // Red oval with drop shadow and yellow edge
        g2.setColor(new Color(255, 222, 23));
        g2.fill(new Ellipse2D.Float(-235, -125, 470, 250));

        g2.setColor(new Color(237, 28, 36));
        g2.fill(new Ellipse2D.Float(-220, -112, 440, 224));

        // "UNO" bold letters
        Font font = new Font("Arial Black", Font.BOLD, 128);
        g2.setFont(font);

        // Black drop shadow
        g2.setColor(Color.BLACK);
        g2.drawString("UNO", -145, 48);

        // White outline
        g2.setColor(Color.WHITE);
        g2.drawString("UNO", -148, 44);

        // Yellow fill
        g2.setColor(new Color(255, 222, 23));
        g2.drawString("UNO", -150, 42);

        g2.dispose();

        // Edge border
        g.setColor(new Color(80, 80, 85));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(cardShape);

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 3. Base UNO Numbered Card
    private static void generateUnoCard(File file, Color bgColor, String num, String cornerNum) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // White card base
        RoundRectangle2D.Float cardShape = new RoundRectangle2D.Float(10, 10, W - 20, H - 20, 38, 38);
        g.setColor(Color.WHITE);
        g.fill(cardShape);

        // Color inner background
        RoundRectangle2D.Float inner = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 28, 28);
        g.setColor(bgColor);
        g.fill(inner);

        // Tilted white center oval
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(W / 2.0, H / 2.0);
        g2.rotate(Math.toRadians(-28.0));

        g2.setColor(Color.WHITE);
        g2.fill(new Ellipse2D.Float(-185, -100, 370, 200));

        // Big center number in card color with black shadow
        Font bigFont = new Font("Arial Black", Font.BOLD, 175);
        g2.setFont(bigFont);
        FontMetrics fm = g2.getFontMetrics();
        int textW = fm.stringWidth(num);

        g2.setColor(new Color(0, 0, 0, 70));
        g2.drawString(num, -textW / 2 + 6, 62);

        g2.setColor(bgColor);
        g2.drawString(num, -textW / 2, 58);
        g2.dispose();

        // Corner numbers
        Font cornerFont = new Font("Arial Black", Font.BOLD, 68);
        g.setFont(cornerFont);
        g.setColor(Color.WHITE);

        // Top-left
        g.drawString(cornerNum, 40, 95);

        // Bottom-right rotated
        Graphics2D g3 = (Graphics2D) g.create();
        g3.translate(W - 40, H - 45);
        g3.rotate(Math.PI);
        g3.setFont(cornerFont);
        g3.setColor(Color.WHITE);
        g3.drawString(cornerNum, 0, 0);
        g3.dispose();

        // Subtle border
        g.setColor(new Color(210, 210, 210));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(cardShape);

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 4. UNO Reverse Card
    private static void generateUnoReverse(File file, Color bgColor) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // White card base
        RoundRectangle2D.Float cardShape = new RoundRectangle2D.Float(10, 10, W - 20, H - 20, 38, 38);
        g.setColor(Color.WHITE);
        g.fill(cardShape);

        // Color inner
        RoundRectangle2D.Float inner = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 28, 28);
        g.setColor(bgColor);
        g.fill(inner);

        // Tilted white center oval
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(W / 2.0, H / 2.0);
        g2.rotate(Math.toRadians(-28.0));
        g2.setColor(Color.WHITE);
        g2.fill(new Ellipse2D.Float(-185, -100, 370, 200));

        // Draw reverse double curved arrows in center
        drawReverseArrows(g2, 0, 0, 1.25f, bgColor);
        g2.dispose();

        // Draw small corner reverse icons
        drawReverseArrows(g, 62, 75, 0.45f, Color.WHITE);
        Graphics2D g3 = (Graphics2D) g.create();
        g3.translate(W - 62, H - 75);
        g3.rotate(Math.PI);
        drawReverseArrows(g3, 0, 0, 0.45f, Color.WHITE);
        g3.dispose();

        g.setColor(new Color(210, 210, 210));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(cardShape);
        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    private static void drawReverseArrows(Graphics2D g, int cx, int cy, float s, Color col) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(cx, cy);
        g2.scale(s, s);
        g2.setColor(col);

        // Arrow 1 (top curving right)
        g2.setStroke(new BasicStroke(16.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(new Arc2D.Float(-55, -45, 110, 90, 30, 140, Arc2D.OPEN));
        // Arrowhead
        Polygon p1 = new Polygon(new int[]{35, 62, 52}, new int[]{-45, -20, 2}, 3);
        g2.fill(p1);

        // Arrow 2 (bottom curving left)
        g2.draw(new Arc2D.Float(-55, -45, 110, 90, 210, 140, Arc2D.OPEN));
        Polygon p2 = new Polygon(new int[]{-35, -62, -52}, new int[]{45, 20, -2}, 3);
        g2.fill(p2);

        g2.dispose();
    }

    // 5. UNO Skip Card
    private static void generateUnoSkip(File file, Color bgColor) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D.Float cardShape = new RoundRectangle2D.Float(10, 10, W - 20, H - 20, 38, 38);
        g.setColor(Color.WHITE);
        g.fill(cardShape);

        RoundRectangle2D.Float inner = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 28, 28);
        g.setColor(bgColor);
        g.fill(inner);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(W / 2.0, H / 2.0);
        g2.rotate(Math.toRadians(-28.0));
        g2.setColor(Color.WHITE);
        g2.fill(new Ellipse2D.Float(-185, -100, 370, 200));

        // Prohibition circle in center
        drawProhibitionIcon(g2, 0, 0, 75, bgColor);
        g2.dispose();

        // Corner icons
        drawProhibitionIcon(g, 62, 75, 26, Color.WHITE);
        Graphics2D g3 = (Graphics2D) g.create();
        g3.translate(W - 62, H - 75);
        g3.rotate(Math.PI);
        drawProhibitionIcon(g3, 0, 0, 26, Color.WHITE);
        g3.dispose();

        g.setColor(new Color(210, 210, 210));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(cardShape);
        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    private static void drawProhibitionIcon(Graphics2D g, int cx, int cy, int r, Color col) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(col);
        float th = r * 0.28f;
        g2.setStroke(new BasicStroke(th));
        g2.draw(new Ellipse2D.Float(cx - r, cy - r, r * 2, r * 2));
        double angle = Math.toRadians(45);
        int dx = (int)(Math.cos(angle) * r);
        int dy = (int)(Math.sin(angle) * r);
        g2.drawLine(cx - dx, cy - dy, cx + dx, cy + dy);
        g2.dispose();
    }

    // 6. UNO +2 Card
    private static void generateUnoDrawTwo(File file, Color bgColor) throws Exception {
        generateUnoCard(file, bgColor, "+2", "+2");
    }

    // 7. UNO Wild Card (4 colors quadrant)
    private static void generateUnoWild(File file) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // White card base
        RoundRectangle2D.Float cardShape = new RoundRectangle2D.Float(10, 10, W - 20, H - 20, 38, 38);
        g.setColor(Color.WHITE);
        g.fill(cardShape);

        // Black inner background
        RoundRectangle2D.Float inner = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 28, 28);
        g.setColor(new Color(22, 22, 24));
        g.fill(inner);

        // Tilted center oval split into 4 colors
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(W / 2.0, H / 2.0);
        g2.rotate(Math.toRadians(-28.0));

        Shape oval = new Ellipse2D.Float(-185, -100, 370, 200);
        g2.setClip(oval);

        // 4 Quadrants
        g2.setColor(new Color(237, 28, 36)); // Red
        g2.fillRect(-185, -100, 185, 100);
        g2.setColor(new Color(0, 114, 188)); // Blue
        g2.fillRect(0, -100, 185, 100);
        g2.setColor(new Color(255, 222, 23)); // Yellow
        g2.fillRect(-185, 0, 185, 100);
        g2.setColor(new Color(0, 166, 81)); // Green
        g2.fillRect(0, 0, 185, 100);

        g2.setClip(null);
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(8.0f));
        g2.draw(oval);

        // Center "WILD" text
        Font font = new Font("Arial Black", Font.BOLD, 52);
        g2.setFont(font);
        FontMetrics fm = g2.getFontMetrics();
        int tw = fm.stringWidth("WILD");
        g2.setColor(Color.BLACK);
        g2.drawString("WILD", -tw / 2 + 3, 21);
        g2.setColor(Color.WHITE);
        g2.drawString("WILD", -tw / 2, 18);
        g2.dispose();

        // Corner 4-color oval icons
        drawMiniWildIcon(g, 62, 75, 22);
        Graphics2D g3 = (Graphics2D) g.create();
        g3.translate(W - 62, H - 75);
        g3.rotate(Math.PI);
        drawMiniWildIcon(g3, 0, 0, 22);
        g3.dispose();

        g.setColor(new Color(100, 100, 100));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(cardShape);
        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    private static void drawMiniWildIcon(Graphics2D g, int cx, int cy, int r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(cx, cy);
        Shape oval = new Ellipse2D.Float(-r, -r * 0.7f, r * 2, r * 1.4f);
        g2.setClip(oval);
        g2.setColor(new Color(237, 28, 36)); g2.fillRect(-r, (int)(-r * 0.7f), r, (int)(r * 0.7f));
        g2.setColor(new Color(0, 114, 188)); g2.fillRect(0, (int)(-r * 0.7f), r, (int)(r * 0.7f));
        g2.setColor(new Color(255, 222, 23)); g2.fillRect(-r, 0, r, (int)(r * 0.7f));
        g2.setColor(new Color(0, 166, 81)); g2.fillRect(0, 0, r, (int)(r * 0.7f));
        g2.setClip(null);
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3.0f));
        g2.draw(oval);
        g2.dispose();
    }

    // 8. UNO +4 Card
    private static void generateUnoDrawFour(File file) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        RoundRectangle2D.Float cardShape = new RoundRectangle2D.Float(10, 10, W - 20, H - 20, 38, 38);
        g.setColor(Color.WHITE);
        g.fill(cardShape);

        RoundRectangle2D.Float inner = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 28, 28);
        g.setColor(new Color(22, 22, 24));
        g.fill(inner);

        // Center 4 colored overlapping cards
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(W / 2.0, H / 2.0);

        Color[] cols = {
            new Color(237, 28, 36),
            new Color(0, 114, 188),
            new Color(255, 222, 23),
            new Color(0, 166, 81)
        };
        int[][] cardOffsets = {{-55, -45}, {-20, -65}, {15, -40}, {45, -15}};

        for (int i = 0; i < 4; i++) {
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(cardOffsets[i][0] - 3, cardOffsets[i][1] - 3, 66, 106, 12, 12);
            g2.setColor(cols[i]);
            g2.fillRoundRect(cardOffsets[i][0], cardOffsets[i][1], 60, 100, 10, 10);
        }

        // Bold "+4" text
        Font font = new Font("Arial Black", Font.BOLD, 120);
        g2.setFont(font);
        g2.setColor(Color.BLACK);
        g2.drawString("+4", -78, 102);
        g2.setColor(Color.WHITE);
        g2.drawString("+4", -80, 100);
        g2.dispose();

        // Corner "+4" text
        Font cornerFont = new Font("Arial Black", Font.BOLD, 60);
        g.setFont(cornerFont);
        g.setColor(Color.WHITE);
        g.drawString("+4", 38, 92);

        Graphics2D g3 = (Graphics2D) g.create();
        g3.translate(W - 38, H - 45);
        g3.rotate(Math.PI);
        g3.setFont(cornerFont);
        g3.setColor(Color.WHITE);
        g3.drawString("+4", 0, 0);
        g3.dispose();

        g.setColor(new Color(100, 100, 100));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(cardShape);
        g.dispose();
        ImageIO.write(img, "PNG", file);
    }
}
