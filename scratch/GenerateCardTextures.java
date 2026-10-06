package scratch;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GenerateCardTextures {

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

        System.out.println("Card PNGs generated successfully in " + outDir.getAbsolutePath());
    }

    private static Graphics2D createGraphics(BufferedImage img) {
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        return g;
    }

    private static void drawCardBase(Graphics2D g, int W, int H) {
        // Transparent clear
        g.setComposite(AlphaComposite.Src);
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, W, H);
        g.setComposite(AlphaComposite.SrcOver);

        RoundRectangle2D cardShape = new RoundRectangle2D.Float(4, 4, W - 8, H - 8, 22, 22);

        // Soft dropshadow / outer glow border
        g.setColor(new Color(180, 160, 120, 120));
        g.setStroke(new BasicStroke(3.5f));
        g.draw(cardShape);

        // Card Face Gradient (Ivory parchment)
        GradientPaint gp = new GradientPaint(0, 0, new Color(252, 252, 254), 0, H, new Color(238, 240, 246));
        g.setPaint(gp);
        g.fill(cardShape);

        // Inner Golden Foil Border
        RoundRectangle2D innerBorder = new RoundRectangle2D.Float(14, 14, W - 28, H - 28, 14, 14);
        g.setColor(new Color(212, 175, 55, 200));
        g.setStroke(new BasicStroke(1.8f));
        g.draw(innerBorder);

        // Subtle thin hairline border
        RoundRectangle2D hairline = new RoundRectangle2D.Float(18, 18, W - 36, H - 36, 10, 10);
        g.setColor(new Color(212, 175, 55, 90));
        g.setStroke(new BasicStroke(0.8f));
        g.draw(hairline);
    }

    private static void drawIndices(Graphics2D g, String rank, String suitSymbol, Color col, int W, int H) {
        g.setColor(col);
        Font fontRank = new Font("SansSerif", Font.BOLD, 26);
        Font fontSuit = new Font("SansSerif", Font.PLAIN, 22);

        // Top Left
        g.setFont(fontRank);
        g.drawString(rank, 24, 44);
        g.setFont(fontSuit);
        g.drawString(suitSymbol, 24, 68);

        // Bottom Right (Inverted)
        AffineTransform old = g.getTransform();
        g.translate(W, H);
        g.rotate(Math.PI);
        g.setFont(fontRank);
        g.drawString(rank, 24, 44);
        g.setFont(fontSuit);
        g.drawString(suitSymbol, 24, 68);
        g.setTransform(old);
    }

    // 1. Ace of Spades
    private static void generateAceSpades(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color black = new Color(20, 22, 28);
        drawIndices(g, "A", "♠", black, W, H);

        // Center Large Ornate Spade
        int cx = W / 2;
        int cy = H / 2;
        drawSpade(g, cx, cy, 65, black, new Color(218, 165, 32));

        // Decorative Banner text
        g.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
        g.setColor(new Color(180, 140, 40));
        String label = "ROCKSTAR";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(label, cx - fm.stringWidth(label) / 2, cy + 95);

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 2. King of Hearts
    private static void generateKingHearts(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color red = new Color(215, 30, 45);
        drawIndices(g, "K", "♥", red, W, H);

        int cx = W / 2;
        int cy = H / 2;
        drawHeart(g, cx, cy - 20, 52, red, new Color(255, 215, 0));

        // King Crown & Heraldry
        drawCrown(g, cx, cy - 75, 48, new Color(220, 180, 40));

        g.setFont(new Font("Serif", Font.BOLD, 15));
        g.setColor(red);
        String label = "KING OF HEARTS";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(label, cx - fm.stringWidth(label) / 2, cy + 85);

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 3. Queen of Diamonds
    private static void generateQueenDiamonds(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color red = new Color(225, 25, 45);
        drawIndices(g, "Q", "♦", red, W, H);

        int cx = W / 2;
        int cy = H / 2;
        drawDiamond(g, cx, cy - 15, 55, red, new Color(255, 220, 80));
        drawCrown(g, cx, cy - 72, 40, new Color(220, 180, 40));

        g.setFont(new Font("Serif", Font.BOLD, 14));
        g.setColor(red);
        String label = "QUEEN OF DIAMONDS";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(label, cx - fm.stringWidth(label) / 2, cy + 85);

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
        int cy = H / 2;
        drawClub(g, cx, cy - 15, 52, black, new Color(218, 165, 32));

        g.setFont(new Font("Serif", Font.BOLD, 14));
        g.setColor(new Color(60, 60, 70));
        String label = "JACK OF CLUBS";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(label, cx - fm.stringWidth(label) / 2, cy + 85);

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
        // Symmetrical 10 pips layout
        int[][] pips = {
            {cx - 45, cy - 90}, {cx + 45, cy - 90},
            {cx, cy - 50},
            {cx - 45, cy - 15}, {cx + 45, cy - 15},
            {cx - 45, cy + 45}, {cx + 45, cy + 45},
            {cx, cy + 15},
            {cx - 45, cy + 95}, {cx + 45, cy + 95}
        };
        for (int[] p : pips) {
            drawSpade(g, p[0], p[1], 15, black, null);
        }

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 6. Joker
    private static void generateJoker(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);
        drawCardBase(g, W, H);
        Color purple = new Color(138, 43, 226);
        drawIndices(g, "★", "J", purple, W, H);

        int cx = W / 2;
        int cy = H / 2;

        // Jester Hat & Starburst
        g.setColor(new Color(255, 215, 0, 140));
        for (int i = 0; i < 12; i++) {
            double ang = (i * Math.PI * 2) / 12;
            int x2 = cx + (int)(Math.cos(ang) * 60);
            int y2 = cy + (int)(Math.sin(ang) * 60);
            g.drawLine(cx, cy, x2, y2);
        }

        drawJesterHat(g, cx, cy - 10, 55);

        g.setFont(new Font("Serif", Font.BOLD, 18));
        g.setColor(purple);
        String label = "J O K E R";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(label, cx - fm.stringWidth(label) / 2, cy + 85);

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // 7. Card Back (Royal Baroque Mandala)
    private static void generateCardBack(File file, int W, int H) throws Exception {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = createGraphics(img);

        RoundRectangle2D cardShape = new RoundRectangle2D.Float(4, 4, W - 8, H - 8, 22, 22);
        g.setColor(new Color(20, 22, 28));
        g.fill(cardShape);

        // Outer white margin
        RoundRectangle2D innerBack = new RoundRectangle2D.Float(12, 12, W - 24, H - 24, 16, 16);
        GradientPaint bgPaint = new GradientPaint(0, 0, new Color(18, 24, 48), W, H, new Color(34, 14, 52));
        g.setPaint(bgPaint);
        g.fill(innerBack);

        // Gold border
        g.setColor(new Color(212, 175, 55, 220));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(innerBack);

        RoundRectangle2D filigree = new RoundRectangle2D.Float(18, 18, W - 36, H - 36, 12, 12);
        g.setColor(new Color(212, 175, 55, 120));
        g.setStroke(new BasicStroke(1.0f));
        g.draw(filigree);

        // Guilloche diamond lattice
        g.setColor(new Color(255, 215, 0, 45));
        g.setStroke(new BasicStroke(1.0f));
        int step = 16;
        for (int x = 20; x < W - 20; x += step) {
            for (int y = 20; y < H - 20; y += step) {
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
        g.setColor(new Color(15, 18, 26, 230));
        g.fillOval(cx - 45, cy - 45, 90, 90);
        g.setColor(new Color(212, 175, 55));
        g.setStroke(new BasicStroke(2.2f));
        g.drawOval(cx - 45, cy - 45, 90, 90);
        g.drawOval(cx - 38, cy - 38, 76, 76);

        // Center Rockstar Star
        drawStar(g, cx, cy, 26, 12, new Color(255, 220, 90));

        g.dispose();
        ImageIO.write(img, "PNG", file);
    }

    // Shapes helpers
    private static void drawSpade(Graphics2D g, int x, int y, int size, Color fill, Color outline) {
        Path2D p = new Path2D.Float();
        p.moveTo(x, y - size);
        p.curveTo(x + size * 0.9, y - size * 0.2, x + size * 0.9, y + size * 0.45, x, y + size * 0.45);
        p.curveTo(x - size * 0.9, y + size * 0.45, x - size * 0.9, y - size * 0.2, x, y - size);
        p.closePath();

        // Stem
        p.moveTo(x - size * 0.15, y + size * 0.4);
        p.lineTo(x - size * 0.35, y + size * 0.85);
        p.lineTo(x + size * 0.35, y + size * 0.85);
        p.lineTo(x + size * 0.15, y + size * 0.4);
        p.closePath();

        g.setColor(fill);
        g.fill(p);
        if (outline != null) {
            g.setColor(outline);
            g.setStroke(new BasicStroke(1.8f));
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
            g.setStroke(new BasicStroke(1.8f));
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
            g.setStroke(new BasicStroke(1.8f));
            g.draw(p);
        }
    }

    private static void drawClub(Graphics2D g, int x, int y, int size, Color fill, Color outline) {
        int r = (int)(size * 0.42);
        g.setColor(fill);
        // 3 leaves
        g.fillOval(x - r, y - (int)(size * 0.8), r * 2, r * 2);
        g.fillOval(x - (int)(size * 0.75), y - (int)(size * 0.2), r * 2, r * 2);
        g.fillOval(x + (int)(size * 0.75) - r * 2, y - (int)(size * 0.2), r * 2, r * 2);

        // Center filler
        g.fillOval(x - r / 2, y - (int)(size * 0.35), r, r);

        // Stem
        Path2D stem = new Path2D.Float();
        stem.moveTo(x - size * 0.15, y - size * 0.1);
        stem.lineTo(x - size * 0.32, y + size * 0.65);
        stem.lineTo(x + size * 0.32, y + size * 0.65);
        stem.lineTo(x + size * 0.15, y - size * 0.1);
        stem.closePath();
        g.fill(stem);

        if (outline != null) {
            g.setColor(outline);
            g.setStroke(new BasicStroke(1.6f));
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
        g.setStroke(new BasicStroke(1.5f));
        g.draw(p);

        // Jewels
        g.setColor(Color.RED);
        g.fillOval(x - 3, (int)(y - size * 0.55) - 3, 6, 6);
        g.setColor(Color.CYAN);
        g.fillOval((int)(x - size * 0.8) - 3, (int)(y - size * 0.4) - 3, 6, 6);
        g.fillOval((int)(x + size * 0.8) - 3, (int)(y - size * 0.4) - 3, 6, 6);
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
        g.setStroke(new BasicStroke(2.0f));
        g.draw(p);

        // Bells
        g.setColor(new Color(255, 215, 0));
        g.fillOval((int)(x - size * 0.7) - 5, (int)(y - size * 0.6) - 5, 10, 10);
        g.fillOval(x - 5, (int)(y - size * 0.9) - 5, 10, 10);
        g.fillOval((int)(x + size * 0.7) - 5, (int)(y - size * 0.6) - 5, 10, 10);
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
