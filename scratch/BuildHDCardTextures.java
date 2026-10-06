package scratch;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BuildHDCardTextures {

    public static void main(String[] args) throws Exception {
        File outDir = new File("src/main/resources/assets/rockstar/textures/cards");
        outDir.mkdirs();

        int W = 512;
        int H = 720;

        generateAceSpades(new File(outDir, "ace_spades.png"), W, H);
        generateKingHearts(new File(outDir, "king_hearts.png"), W, H);
        generateQueenDiamonds(new File(outDir, "queen_diamonds.png"), W, H);
        generateJackClubs(new File(outDir, "jack_clubs.png"), W, H);
        generateTenSpades(new File(outDir, "ten_spades.png"), W, H);
        generateJoker(new File(outDir, "joker.png"), W, H);
        generateCardBack(new File(outDir, "card_back.png"), W, H);

        System.out.println("All 7 HD 512x720 Card Textures successfully generated in " + outDir.getAbsolutePath());
    }

    private static Graphics2D createGraphics(BufferedImage img) {
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        return g;
    }

    private static void drawCardBase(Graphics2D g, int W, int H) {
        g.setComposite(AlphaComposite.Src);
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, W, H);
        g.setComposite(AlphaComposite.SrcOver);

        RoundRectangle2D cardShape = new RoundRectangle2D.Float(8, 8, W - 16, H - 16, 44, 44);

        // Soft ambient golden shadow
        g.setColor(new Color(212, 175, 55, 60));
        g.setStroke(new BasicStroke(6.0f));
        g.draw(cardShape);

        // Card Face Gradient (Lustrous Pearl Ivory)
        GradientPaint gp = new GradientPaint(0, 0, new Color(254, 254, 255), 0, H, new Color(236, 238, 245));
        g.setPaint(gp);
        g.fill(cardShape);

        // Outer Dark Trim
        g.setColor(new Color(30, 32, 40, 230));
        g.setStroke(new BasicStroke(3.0f));
        g.draw(cardShape);

        // Luxury Dual Gold Foil Border
        RoundRectangle2D innerBorder1 = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 30, 30);
        g.setColor(new Color(212, 175, 55, 230));
        g.setStroke(new BasicStroke(3.5f));
        g.draw(innerBorder1);

        RoundRectangle2D innerBorder2 = new RoundRectangle2D.Float(32, 32, W - 64, H - 64, 22, 22);
        g.setColor(new Color(212, 175, 55, 110));
        g.setStroke(new BasicStroke(1.5f));
        g.draw(innerBorder2);

        // Corner Corner Ornaments
        drawCornerOrnaments(g, W, H);
    }

    private static void drawCornerOrnaments(Graphics2D g, int W, int H) {
        g.setColor(new Color(212, 175, 55, 180));
        g.setStroke(new BasicStroke(1.5f));
        int[][] corners = {{32, 32}, {W - 32, 32}, {32, H - 32}, {W - 32, H - 32}};
        int r = 10;
        for (int[] c : corners) {
            g.drawOval(c[0] - r, c[1] - r, r * 2, r * 2);
            g.fillOval(c[0] - 3, c[1] - 3, 6, 6);
        }
    }

    private static void drawIndices(Graphics2D g, String rank, String suitSymbol, Color col, int W, int H) {
        g.setColor(col);
        Font fontRank = new Font("Serif", Font.BOLD, 52);
        Font fontSuit = new Font("SansSerif", Font.PLAIN, 44);

        // Top Left
        g.setFont(fontRank);
        g.drawString(rank, 46, 88);
        g.setFont(fontSuit);
        g.drawString(suitSymbol, 48, 134);

        // Bottom Right (Inverted)
        AffineTransform old = g.getTransform();
        g.translate(W, H);
        g.rotate(Math.PI);
        g.setFont(fontRank);
        g.drawString(rank, 46, 88);
        g.setFont(fontSuit);
        g.drawString(suitSymbol, 48, 134);
        g.setTransform(old);
    }

    // 1. Ace of Spades (Masterpiece with AGRAVITY Ribbon)
    private static void generateAceSpades(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color black = new Color(20, 22, 28);
        drawIndices(g, "A", "♠", black, W, H);

        int cx = W / 2;
        int cy = H / 2 - 20;

        // Giant Royal Ace Spade with internal engraving
        drawSpade(g, cx, cy, 140, black, new Color(218, 165, 32));

        // Intricate Inner Golden Filigree in Spade
        drawCrown(g, cx, cy - 40, 50, new Color(255, 215, 0));

        // AGRAVITY Ribbon at bottom
        drawRibbonBanner(g, cx, cy + 185, 280, 48, "AGRAVITY", new Color(20, 24, 34), new Color(212, 175, 55));

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 2. King of Hearts
    private static void generateKingHearts(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color red = new Color(220, 25, 45);
        drawIndices(g, "K", "♥", red, W, H);

        int cx = W / 2;
        int cy = H / 2 - 30;

        // King Crown & Large Heart
        drawCrown(g, cx, cy - 110, 85, new Color(225, 185, 45));
        drawHeart(g, cx, cy + 10, 115, red, new Color(255, 215, 0));

        drawRibbonBanner(g, cx, cy + 185, 280, 44, "KING OF HEARTS", new Color(180, 20, 35), new Color(255, 220, 80));

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 3. Queen of Diamonds
    private static void generateQueenDiamonds(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color red = new Color(230, 25, 50);
        drawIndices(g, "Q", "♦", red, W, H);

        int cx = W / 2;
        int cy = H / 2 - 30;

        drawCrown(g, cx, cy - 105, 75, new Color(225, 185, 45));
        drawDiamond(g, cx, cy + 15, 120, red, new Color(255, 225, 90));

        drawRibbonBanner(g, cx, cy + 185, 300, 44, "QUEEN OF DIAMONDS", new Color(180, 20, 35), new Color(255, 220, 80));

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 4. Jack of Clubs
    private static void generateJackClubs(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color black = new Color(20, 22, 28);
        drawIndices(g, "J", "♣", black, W, H);

        int cx = W / 2;
        int cy = H / 2 - 30;

        drawClub(g, cx, cy, 120, black, new Color(218, 165, 32));
        drawCrown(g, cx, cy - 105, 65, new Color(200, 160, 40));

        drawRibbonBanner(g, cx, cy + 185, 280, 44, "JACK OF CLUBS", new Color(25, 28, 38), new Color(212, 175, 55));

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 5. Ten of Spades
    private static void generateTenSpades(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color black = new Color(20, 22, 28);
        drawIndices(g, "10", "♠", black, W, H);

        int cx = W / 2;
        int cy = H / 2;
        int[][] pips = {
            {cx - 90, cy - 180}, {cx + 90, cy - 180},
            {cx, cy - 100},
            {cx - 90, cy - 30}, {cx + 90, cy - 30},
            {cx - 90, cy + 90}, {cx + 90, cy + 90},
            {cx, cy + 30},
            {cx - 90, cy + 190}, {cx + 90, cy + 190}
        };
        for (int[] p : pips) {
            drawSpade(g, p[0], p[1], 30, black, new Color(212, 175, 55));
        }

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 6. Joker
    private static void generateJoker(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color purple = new Color(145, 45, 230);
        drawIndices(g, "★", "J", purple, W, H);

        int cx = W / 2;
        int cy = H / 2 - 25;

        // Radiant starburst rays
        g.setColor(new Color(255, 215, 0, 90));
        g.setStroke(new BasicStroke(2.0f));
        for (int i = 0; i < 24; i++) {
            double ang = (i * Math.PI * 2) / 24;
            int x2 = cx + (int)(Math.cos(ang) * 140);
            int y2 = cy + (int)(Math.sin(ang) * 140);
            g.drawLine(cx, cy, x2, y2);
        }

        drawJesterHat(g, cx, cy, 110);
        drawRibbonBanner(g, cx, cy + 185, 260, 44, "J O K E R", new Color(60, 20, 90), new Color(255, 215, 0));

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 7. Card Back (Ultra-Luxury Baroque Mandala with Agravity Star)
    private static void generateCardBack(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);

        RoundRectangle2D cardShape = new RoundRectangle2D.Float(8, 8, W - 16, H - 16, 44, 44);
        g.setColor(new Color(15, 17, 24));
        g.fill(cardShape);

        // Deep Royal Sapphire Gradient
        RoundRectangle2D innerBack = new RoundRectangle2D.Float(20, 20, W - 40, H - 40, 32, 32);
        GradientPaint bgPaint = new GradientPaint(0, 0, new Color(14, 20, 42), W, H, new Color(38, 12, 54));
        g.setPaint(bgPaint);
        g.fill(innerBack);

        // Double Gold Border
        g.setColor(new Color(212, 175, 55, 240));
        g.setStroke(new BasicStroke(4.0f));
        g.draw(innerBack);

        RoundRectangle2D filigree = new RoundRectangle2D.Float(32, 32, W - 64, H - 64, 24, 24);
        g.setColor(new Color(212, 175, 55, 130));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(filigree);

        // Intricate Guilloche Diamond Lattice Pattern
        g.setColor(new Color(255, 215, 0, 50));
        g.setStroke(new BasicStroke(1.2f));
        int step = 28;
        for (int x = 40; x < W - 30; x += step) {
            for (int y = 40; y < H - 30; y += step) {
                g.drawPolygon(
                    new int[]{x, x + step / 2, x, x - step / 2},
                    new int[]{y - step / 2, y, y + step / 2, y},
                    4
                );
            }
        }

        // Center Medallion
        int cx = W / 2;
        int cy = H / 2;
        g.setColor(new Color(12, 15, 24, 240));
        g.fillOval(cx - 95, cy - 95, 190, 190);
        g.setColor(new Color(212, 175, 55));
        g.setStroke(new BasicStroke(4.0f));
        g.drawOval(cx - 95, cy - 95, 190, 190);
        g.setStroke(new BasicStroke(2.0f));
        g.drawOval(cx - 82, cy - 82, 164, 164);

        // Center 12-point Agravity Star & Emblems
        drawStar(g, cx, cy, 60, 28, new Color(255, 220, 90));
        drawCrown(g, cx, cy - 5, 28, new Color(212, 175, 55));

        // Top & Bottom Gold Banners with "AGRAVITY"
        Font fontBrand = new Font("Serif", Font.BOLD, 22);
        g.setFont(fontBrand);
        g.setColor(new Color(235, 195, 75));
        FontMetrics fm = g.getFontMetrics();
        String brand = "AGRAVITY";
        g.drawString(brand, cx - fm.stringWidth(brand) / 2, cy - 115);
        g.drawString(brand, cx - fm.stringWidth(brand) / 2, cy + 135);

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    private static void drawRibbonBanner(Graphics2D g, int cx, int cy, int w, int h, String text, Color bg, Color border) {
        RoundRectangle2D rect = new RoundRectangle2D.Float(cx - w / 2, cy - h / 2, w, h, 14, 14);
        g.setColor(bg);
        g.fill(rect);
        g.setColor(border);
        g.setStroke(new BasicStroke(2.0f));
        g.draw(rect);

        g.setFont(new Font("Serif", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        g.drawString(text, cx - fm.stringWidth(text) / 2, cy + 7);
    }

    private static void drawSpade(Graphics2D g, int x, int y, int size, Color fill, Color outline) {
        Path2D p = new Path2D.Float();
        p.moveTo(x, y - size);
        p.curveTo(x + size * 0.9, y - size * 0.2, x + size * 0.9, y + size * 0.45, x, y + size * 0.45);
        p.curveTo(x - size * 0.9, y + size * 0.45, x - size * 0.9, y - size * 0.2, x, y - size);
        p.closePath();

        p.moveTo(x - size * 0.15, y + size * 0.4);
        p.lineTo(x - size * 0.35, y + size * 0.85);
        p.lineTo(x + size * 0.35, y + size * 0.85);
        p.lineTo(x + size * 0.15, y + size * 0.4);
        p.closePath();

        g.setColor(fill);
        g.fill(p);
        if (outline != null) {
            g.setColor(outline);
            g.setStroke(new BasicStroke(3.0f));
            g.draw(p);
        }
    }

    private static void drawHeart(Graphics2D g, int x, int y, int size, Color fill, Color outline) {
        Path2D p = new Path2D.Float();
        p.moveTo(x, y + size * 0.7);
        p.curveTo(x - size * 1.1, y + size * 0.1, x - size * 0.9, y - size * 0.7, x, y - size * 0.3);
        p.curveTo(x + size * 0.9, y - size * 0.7, x + size * 1.1, y + size * 0.1, x, y + size * 0.7);
        p.closePath();

        g.setColor(fill);
        g.fill(p);
        if (outline != null) {
            g.setColor(outline);
            g.setStroke(new BasicStroke(3.0f));
            g.draw(p);
        }
    }

    private static void drawDiamond(Graphics2D g, int x, int y, int size, Color fill, Color outline) {
        Path2D p = new Path2D.Float();
        p.moveTo(x, y - size);
        p.lineTo(x + size * 0.7, y);
        p.lineTo(x, y + size);
        p.lineTo(x - size * 0.7, y);
        p.closePath();

        g.setColor(fill);
        g.fill(p);
        if (outline != null) {
            g.setColor(outline);
            g.setStroke(new BasicStroke(3.0f));
            g.draw(p);
        }
    }

    private static void drawClub(Graphics2D g, int x, int y, int size, Color fill, Color outline) {
        int r = (int)(size * 0.42);
        g.setColor(fill);
        g.fillOval(x - r, y - (int)(size * 0.8), r * 2, r * 2);
        g.fillOval(x - (int)(size * 0.75), y - (int)(size * 0.2), r * 2, r * 2);
        g.fillOval(x + (int)(size * 0.75) - r * 2, y - (int)(size * 0.2), r * 2, r * 2);
        g.fillOval(x - r / 2, y - (int)(size * 0.35), r, r);

        Path2D stem = new Path2D.Float();
        stem.moveTo(x - size * 0.15, y - size * 0.1);
        stem.lineTo(x - size * 0.32, y + size * 0.65);
        stem.lineTo(x + size * 0.32, y + size * 0.65);
        stem.lineTo(x + size * 0.15, y - size * 0.1);
        stem.closePath();
        g.fill(stem);

        if (outline != null) {
            g.setColor(outline);
            g.setStroke(new BasicStroke(3.0f));
            g.drawOval(x - r, y - (int)(size * 0.8), r * 2, r * 2);
            g.drawOval(x - (int)(size * 0.75), y - (int)(size * 0.2), r * 2, r * 2);
            g.drawOval(x + (int)(size * 0.75) - r * 2, y - (int)(size * 0.2), r * 2, r * 2);
            g.draw(stem);
        }
    }

    private static void drawCrown(Graphics2D g, int x, int y, int size, Color col) {
        Path2D p = new Path2D.Float();
        p.moveTo(x - size, y + size * 0.4);
        p.lineTo(x - size * 0.8, y - size * 0.4);
        p.lineTo(x - size * 0.4, y);
        p.lineTo(x, y - size * 0.55);
        p.lineTo(x + size * 0.4, y);
        p.lineTo(x + size * 0.8, y - size * 0.4);
        p.lineTo(x + size, y + size * 0.4);
        p.closePath();

        g.setColor(col);
        g.fill(p);
        g.setColor(new Color(255, 235, 140));
        g.setStroke(new BasicStroke(2.5f));
        g.draw(p);

        g.setColor(Color.RED);
        g.fillOval(x - 5, (int)(y - size * 0.55) - 5, 10, 10);
        g.setColor(Color.CYAN);
        g.fillOval((int)(x - size * 0.8) - 5, (int)(y - size * 0.4) - 5, 10, 10);
        g.fillOval((int)(x + size * 0.8) - 5, (int)(y - size * 0.4) - 5, 10, 10);
    }

    private static void drawJesterHat(Graphics2D g, int x, int y, int size) {
        Path2D p = new Path2D.Float();
        p.moveTo(x - size, y + size * 0.5);
        p.curveTo(x - size * 1.2, y - size * 0.2, x - size * 0.8, y - size * 0.8, x - size * 0.7, y - size * 0.6);
        p.curveTo(x - size * 0.4, y - size * 0.2, x - size * 0.3, y - size * 0.7, x, y - size * 0.9);
        p.curveTo(x + size * 0.3, y - size * 0.7, x + size * 0.4, y - size * 0.2, x + size * 0.7, y - size * 0.6);
        p.curveTo(x + size * 0.8, y - size * 0.8, x + size * 1.2, y - size * 0.2, x + size, y + size * 0.5);
        p.closePath();

        g.setColor(new Color(180, 50, 200));
        g.fill(p);
        g.setColor(new Color(255, 215, 0));
        g.setStroke(new BasicStroke(3.0f));
        g.draw(p);

        g.setColor(new Color(255, 215, 0));
        g.fillOval((int)(x - size * 0.7) - 8, (int)(y - size * 0.6) - 8, 16, 16);
        g.fillOval(x - 8, (int)(y - size * 0.9) - 8, 16, 16);
        g.fillOval((int)(x + size * 0.7) - 8, (int)(y - size * 0.6) - 8, 16, 16);
    }

    private static void drawStar(Graphics2D g, int cx, int cy, int rOut, int rIn, Color col) {
        int points = 8;
        Path2D p = new Path2D.Float();
        for (int i = 0; i < points * 2; i++) {
            double ang = (i * Math.PI) / points - Math.PI / 2;
            int r = (i % 2 == 0) ? rOut : rIn;
            int x = cx + (int)(Math.cos(ang) * r);
            int y = cy + (int)(Math.sin(ang) * r);
            if (i == 0) p.moveTo(x, y);
            else p.lineTo(x, y);
        }
        p.closePath();
        g.setColor(col);
        g.fill(p);
    }
}
