import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BuildFullPlayingCards {

    private static final int W = 512;
    private static final int H = 720;

    public static void main(String[] args) throws Exception {
        File outDir = new File("c:/Users/Admin-HP/Desktop/rockstar-client-src/src/main/resources/assets/rockstar/textures/cards");
        outDir.mkdirs();

        // Standard 4 Aces
        save(renderStandardCard("A", "SPADES", true), new File(outDir, "ace_spades.png"));
        save(renderStandardCard("A", "HEARTS", true), new File(outDir, "ace_hearts.png"));
        save(renderStandardCard("A", "DIAMONDS", true), new File(outDir, "ace_diamonds.png"));
        save(renderStandardCard("A", "CLUBS", true), new File(outDir, "ace_clubs.png"));

        // Kings
        save(renderCourtCard("K", "SPADES", "King of Spades"), new File(outDir, "king_spades.png"));
        save(renderCourtCard("K", "HEARTS", "King of Hearts"), new File(outDir, "king_hearts.png"));
        save(renderCourtCard("K", "DIAMONDS", "King of Diamonds"), new File(outDir, "king_diamonds.png"));
        save(renderCourtCard("K", "CLUBS", "King of Clubs"), new File(outDir, "king_clubs.png"));

        // Queens
        save(renderCourtCard("Q", "SPADES", "Queen of Spades"), new File(outDir, "queen_spades.png"));
        save(renderCourtCard("Q", "HEARTS", "Queen of Hearts"), new File(outDir, "queen_hearts.png"));
        save(renderCourtCard("Q", "DIAMONDS", "Queen of Diamonds"), new File(outDir, "queen_diamonds.png"));
        save(renderCourtCard("Q", "CLUBS", "Queen of Clubs"), new File(outDir, "queen_clubs.png"));

        // Jacks
        save(renderCourtCard("J", "SPADES", "Jack of Spades"), new File(outDir, "jack_spades.png"));
        save(renderCourtCard("J", "HEARTS", "Jack of Hearts"), new File(outDir, "jack_hearts.png"));
        save(renderCourtCard("J", "DIAMONDS", "Jack of Diamonds"), new File(outDir, "jack_diamonds.png"));
        save(renderCourtCard("J", "CLUBS", "Jack of Clubs"), new File(outDir, "jack_clubs.png"));

        // 10 of Spades
        save(renderTenCard("SPADES"), new File(outDir, "ten_spades.png"));

        // Jokers
        save(renderJokerCard(true), new File(outDir, "joker.png"));
        save(renderJokerCard(true), new File(outDir, "joker_red.png"));
        save(renderJokerCard(false), new File(outDir, "joker_black.png"));

        // Decks / Backs
        save(renderRoyalGoldBack(), new File(outDir, "card_back.png"));
        save(renderBicycleClassicBack(), new File(outDir, "card_back_bicycle.png"));
        save(renderCyberNeonBack(), new File(outDir, "card_back_cyber.png"));
        save(renderDarkArcaneBack(), new File(outDir, "card_back_arcane.png"));

        System.out.println("Generated all 23 HD Playing Cards successfully!");
    }

    private static void save(BufferedImage img, File file) throws Exception {
        ImageIO.write(img, "png", file);
        System.out.println("Saved: " + file.getName() + " (" + file.length() + " bytes)");
    }

    private static BufferedImage createBaseCard() {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Card Shape with rounded corners
        RoundRectangle2D cardShape = new RoundRectangle2D.Float(8, 8, W - 16, H - 16, 36, 36);

        // Subtle parchment gradient
        GradientPaint bgGrad = new GradientPaint(0, 0, new Color(254, 253, 250), 0, H, new Color(242, 238, 230));
        g.setPaint(bgGrad);
        g.fill(cardShape);

        // Outer crisp card borders
        g.setColor(new Color(210, 205, 195));
        g.setStroke(new BasicStroke(3.0f));
        g.draw(cardShape);

        // Inner ornate border
        RoundRectangle2D innerBorder = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 24, 24);
        g.setColor(new Color(160, 150, 135, 160));
        g.setStroke(new BasicStroke(1.5f));
        g.draw(innerBorder);

        // Very thin micro border
        RoundRectangle2D microBorder = new RoundRectangle2D.Float(28, 28, W - 56, H - 56, 20, 20);
        g.setColor(new Color(180, 170, 155, 90));
        g.setStroke(new BasicStroke(0.8f));
        g.draw(microBorder);

        g.dispose();
        return img;
    }

    private static BufferedImage renderStandardCard(String rank, String suit, boolean isAce) {
        BufferedImage img = createBaseCard();
        Graphics2D g = img.createGraphics();
        setupHints(g);

        Color suitCol = getSuitColor(suit);

        // Corners: Top-Left and Bottom-Right
        drawCorner(g, rank, suit, suitCol, 36, 40, false);
        drawCorner(g, rank, suit, suitCol, W - 36, H - 40, true);

        if (isAce) {
            // Giant Ornate Center Suit
            drawLargeSuit(g, suit, suitCol, W / 2, H / 2 - 10, 180);

            // Subtle filigree glow
            g.setColor(new Color(200, 170, 100, 130));
            g.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 22));
            drawCentered(g, "AGRAVITY POKER", W / 2, H / 2 + 150);

            // Flourish lines under text
            g.setStroke(new BasicStroke(1.2f));
            g.drawLine(W / 2 - 90, H / 2 + 165, W / 2 + 90, H / 2 + 165);
            drawDiamond(g, W / 2, H / 2 + 165, 8, new Color(200, 170, 100));
        }

        g.dispose();
        return img;
    }

    private static BufferedImage renderTenCard(String suit) {
        BufferedImage img = createBaseCard();
        Graphics2D g = img.createGraphics();
        setupHints(g);

        Color suitCol = getSuitColor(suit);
        drawCorner(g, "10", suit, suitCol, 36, 40, false);
        drawCorner(g, "10", suit, suitCol, W - 36, H - 40, true);

        // 10 pips arrangement: 4 left column, 4 right column, 2 center column
        int[] rowsY = {110, 210, 310, 410, 510, 610};
        int leftX = 145;
        int rightX = W - 145;
        int midX = W / 2;

        drawLargeSuit(g, suit, suitCol, leftX, 130, 44);
        drawLargeSuit(g, suit, suitCol, rightX, 130, 44);
        drawLargeSuit(g, suit, suitCol, leftX, 270, 44);
        drawLargeSuit(g, suit, suitCol, rightX, 270, 44);
        drawLargeSuit(g, suit, suitCol, midX, 200, 44);

        // Bottom half inverted
        drawInvertedSuit(g, suit, suitCol, midX, 520, 44);
        drawInvertedSuit(g, suit, suitCol, leftX, 450, 44);
        drawInvertedSuit(g, suit, suitCol, rightX, 450, 44);
        drawInvertedSuit(g, suit, suitCol, leftX, 590, 44);
        drawInvertedSuit(g, suit, suitCol, rightX, 590, 44);

        g.dispose();
        return img;
    }

    private static BufferedImage renderCourtCard(String rank, String suit, String title) {
        BufferedImage img = createBaseCard();
        Graphics2D g = img.createGraphics();
        setupHints(g);

        Color suitCol = getSuitColor(suit);
        drawCorner(g, rank, suit, suitCol, 36, 40, false);
        drawCorner(g, rank, suit, suitCol, W - 36, H - 40, true);

        // Court Box Frame (Center mirror)
        int boxW = 280;
        int boxH = 430;
        int boxX = (W - boxW) / 2;
        int boxY = (H - boxH) / 2;

        g.setColor(new Color(250, 245, 235));
        g.fillRoundRect(boxX, boxY, boxW, boxH, 12, 12);
        g.setColor(new Color(170, 140, 85, 220));
        g.setStroke(new BasicStroke(2.0f));
        g.drawRoundRect(boxX, boxY, boxW, boxH, 12, 12);

        // Gold inner frame
        g.setColor(new Color(215, 185, 110, 160));
        g.drawRoundRect(boxX + 5, boxY + 5, boxW - 10, boxH - 10, 8, 8);

        // Split line across middle
        g.setColor(new Color(170, 140, 85, 180));
        g.setStroke(new BasicStroke(1.2f));
        g.drawLine(boxX + 10, H / 2, boxX + boxW - 10, H / 2);

        // Render Top Half Portrait
        renderCourtHalf(g, rank, suit, suitCol, W / 2, H / 2 - 105, 1.0);

        // Render Bottom Half Inverted Portrait
        renderCourtHalf(g, rank, suit, suitCol, W / 2, H / 2 + 105, -1.0);

        // Decorative Court Ribbon Banner across center
        int banW = 210;
        int banH = 26;
        int banX = (W - banW) / 2;
        int banY = (H - banH) / 2;
        g.setColor(new Color(28, 28, 34, 235));
        g.fillRoundRect(banX, banY, banW, banH, 6, 6);
        g.setColor(new Color(215, 185, 110));
        g.setStroke(new BasicStroke(1.2f));
        g.drawRoundRect(banX, banY, banW, banH, 6, 6);

        g.setFont(new Font("Serif", Font.BOLD, 13));
        g.setColor(new Color(245, 230, 180));
        drawCentered(g, title.toUpperCase(), W / 2, banY + 18);

        g.dispose();
        return img;
    }

    private static void renderCourtHalf(Graphics2D g, String rank, String suit, Color suitCol, int cx, int cy, double scaleY) {
        AffineTransform old = g.getTransform();
        g.translate(cx, cy);
        if (scaleY < 0) {
            g.scale(1.0, -1.0);
        }

        // Royal Robe
        Color robeCol = suitCol.equals(new Color(214, 24, 43)) ? new Color(170, 25, 40) : new Color(30, 45, 80);
        g.setColor(robeCol);
        Path2D robe = new Path2D.Float();
        robe.moveTo(-60, 95);
        robe.lineTo(-45, -20);
        robe.lineTo(45, -20);
        robe.lineTo(60, 95);
        robe.closePath();
        g.fill(robe);

        // Gold ermine trim
        g.setColor(new Color(230, 195, 95));
        g.setStroke(new BasicStroke(4.0f));
        g.draw(robe);

        // Royal Head / Face silhouette
        g.setColor(new Color(248, 230, 212));
        g.fillOval(-25, -55, 50, 50);
        g.setColor(new Color(180, 140, 100));
        g.setStroke(new BasicStroke(1.5f));
        g.drawOval(-25, -55, 50, 50);

        // Hair / Beard
        if ("K".equals(rank)) {
            // Crown
            drawCrown(g, 0, -68, 55, 30, new Color(230, 195, 80));
            // Scepter in right hand
            g.setColor(new Color(230, 195, 80));
            g.fillRect(35, -40, 6, 80);
            drawDiamond(g, 38, -44, 10, new Color(214, 24, 43));
        } else if ("Q".equals(rank)) {
            // Tiara
            drawTiara(g, 0, -64, 46, 24, new Color(230, 195, 80));
            // Scepter with pearl
            g.setColor(new Color(230, 195, 80));
            g.fillRect(-42, -30, 5, 75);
            g.setColor(Color.WHITE);
            g.fillOval(-46, -38, 13, 13);
        } else { // Jack
            // Cap with feather
            drawJesterCap(g, 0, -62, 50, 24, new Color(40, 80, 140));
            // Halberd / Sword
            g.setColor(new Color(180, 185, 195));
            g.fillRect(36, -35, 5, 80);
            drawDiamond(g, 38, -40, 8, new Color(230, 195, 80));
        }

        // Small suit emblem on chest
        drawLargeSuit(g, suit, suitCol, 0, 30, 34);

        g.setTransform(old);
    }

    private static BufferedImage renderJokerCard(boolean isRed) {
        BufferedImage img = createBaseCard();
        Graphics2D g = img.createGraphics();
        setupHints(g);

        Color mainCol = isRed ? new Color(214, 24, 43) : new Color(30, 30, 36);

        // Corner text: "JOKER" vertically
        drawJokerCorner(g, mainCol, 32, 45, false);
        drawJokerCorner(g, mainCol, W - 32, H - 45, true);

        // Center Jester / Joker Emblem
        int cx = W / 2;
        int cy = H / 2;

        // Radiating starburst rays
        for (int a = 0; a < 360; a += 30) {
            double rad = Math.toRadians(a);
            int x2 = cx + (int) (Math.cos(rad) * 140);
            int y2 = cy + (int) (Math.sin(rad) * 140);
            g.setColor(new Color(215, 185, 110, 45));
            g.setStroke(new BasicStroke(2.0f));
            g.drawLine(cx, cy, x2, y2);
        }

        // Big gold circle
        g.setColor(new Color(245, 240, 225));
        g.fillOval(cx - 105, cy - 105, 210, 210);
        g.setColor(new Color(215, 185, 110));
        g.setStroke(new BasicStroke(3.0f));
        g.drawOval(cx - 105, cy - 105, 210, 210);

        // Jester Hat & Mask
        drawJesterFigure(g, cx, cy, isRed);

        g.setFont(new Font("Serif", Font.BOLD, 22));
        g.setColor(mainCol);
        drawCentered(g, isRed ? "THE RED JOKER" : "THE BLACK JOKER", cx, cy + 145);

        g.dispose();
        return img;
    }

    private static void drawJesterFigure(Graphics2D g, int cx, int cy, boolean isRed) {
        Color c1 = isRed ? new Color(214, 24, 43) : new Color(40, 40, 48);
        Color c2 = new Color(225, 190, 80);

        // 3-point jester hat
        Path2D hat1 = new Path2D.Float();
        hat1.moveTo(cx - 30, cy - 10);
        hat1.quadTo(cx - 75, cy - 50, cx - 80, cy - 25);
        hat1.lineTo(cx - 20, cy + 10);
        hat1.closePath();
        g.setColor(c1);
        g.fill(hat1);

        Path2D hat2 = new Path2D.Float();
        hat2.moveTo(cx - 20, cy - 20);
        hat2.quadTo(cx, cy - 90, cx, cy - 85);
        hat2.lineTo(cx + 20, cy - 20);
        hat2.closePath();
        g.setColor(c2);
        g.fill(hat2);

        Path2D hat3 = new Path2D.Float();
        hat3.moveTo(cx + 30, cy - 10);
        hat3.quadTo(cx + 75, cy - 50, cx + 80, cy - 25);
        hat3.lineTo(cx + 20, cy + 10);
        hat3.closePath();
        g.setColor(c1);
        g.fill(hat3);

        // Golden bells on tips
        g.setColor(new Color(245, 215, 95));
        g.fillOval(cx - 86, cy - 30, 14, 14);
        g.fillOval(cx - 7, cy - 92, 14, 14);
        g.fillOval(cx + 72, cy - 30, 14, 14);

        // Mask Face
        g.setColor(new Color(250, 245, 238));
        g.fillOval(cx - 28, cy - 10, 56, 56);
        g.setColor(new Color(180, 150, 100));
        g.setStroke(new BasicStroke(1.5f));
        g.drawOval(cx - 28, cy - 10, 56, 56);

        // Smile
        g.setColor(c1);
        g.setStroke(new BasicStroke(2.5f));
        g.drawArc(cx - 16, cy + 14, 32, 16, 200, 140);
        // Eyes
        drawDiamond(g, cx - 12, cy + 8, 8, c1);
        drawDiamond(g, cx + 12, cy + 8, 8, c1);
    }

    private static BufferedImage renderRoyalGoldBack() {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        setupHints(g);

        RoundRectangle2D cardShape = new RoundRectangle2D.Float(8, 8, W - 16, H - 16, 36, 36);
        g.setPaint(new GradientPaint(0, 0, new Color(14, 16, 24), W, H, new Color(24, 20, 36)));
        g.fill(cardShape);

        // Outer gold border
        g.setColor(new Color(215, 185, 95));
        g.setStroke(new BasicStroke(3.5f));
        g.draw(cardShape);

        // Inner ornate border
        RoundRectangle2D inner = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 22, 22);
        g.setColor(new Color(180, 145, 75, 180));
        g.setStroke(new BasicStroke(1.8f));
        g.draw(inner);

        // Guilloche lattice pattern
        g.setColor(new Color(215, 185, 95, 35));
        g.setStroke(new BasicStroke(1.0f));
        for (int x = 30; x < W - 30; x += 22) {
            g.drawLine(x, 30, x + 60, H - 30);
            g.drawLine(x, H - 30, x + 60, 30);
        }

        // Center Royal Baroque Mandala
        int cx = W / 2;
        int cy = H / 2;
        g.setColor(new Color(215, 185, 95, 80));
        g.drawOval(cx - 110, cy - 110, 220, 220);
        g.drawOval(cx - 85, cy - 85, 170, 170);

        // 12-point starburst
        for (int i = 0; i < 12; i++) {
            double a = Math.toRadians(i * 30);
            int x1 = cx + (int) (Math.cos(a) * 45);
            int y1 = cy + (int) (Math.sin(a) * 45);
            int x2 = cx + (int) (Math.cos(a) * 85);
            int y2 = cy + (int) (Math.sin(a) * 85);
            g.setColor(new Color(245, 215, 115, 180));
            g.drawLine(x1, y1, x2, y2);
        }

        // Center Gold Medallion
        g.setColor(new Color(20, 18, 28));
        g.fillOval(cx - 48, cy - 48, 96, 96);
        g.setColor(new Color(235, 200, 105));
        g.setStroke(new BasicStroke(2.0f));
        g.drawOval(cx - 48, cy - 48, 96, 96);

        // Agravity Emblem: Letter 'A' with wings & star
        g.setFont(new Font("Serif", Font.BOLD, 42));
        g.setColor(new Color(245, 220, 130));
        drawCentered(g, "A", cx, cy + 15);

        // Banner text
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.setColor(new Color(200, 170, 95, 200));
        drawCentered(g, "AGRAVITY", cx, cy + 140);
        drawCentered(g, "ROYAL EDITION", cx, cy + 158);

        g.dispose();
        return img;
    }

    private static BufferedImage renderBicycleClassicBack() {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        setupHints(g);

        RoundRectangle2D cardShape = new RoundRectangle2D.Float(8, 8, W - 16, H - 16, 36, 36);
        // Classic Bicycle Crimson Red
        g.setColor(new Color(168, 22, 35));
        g.fill(cardShape);

        // Crisp White Border like authentic Bicycle deck
        g.setColor(new Color(250, 248, 245));
        g.setStroke(new BasicStroke(4.0f));
        g.draw(cardShape);

        RoundRectangle2D innerWhite = new RoundRectangle2D.Float(26, 26, W - 52, H - 52, 20, 20);
        g.setColor(new Color(250, 248, 245, 220));
        g.setStroke(new BasicStroke(2.0f));
        g.draw(innerWhite);

        // Classic Victorian filigree waves
        int cx = W / 2;
        int cy = H / 2;
        g.setColor(new Color(255, 255, 255, 45));
        g.setStroke(new BasicStroke(1.2f));
        for (int r = 20; r < 200; r += 16) {
            g.drawOval(cx - r, cy - r, r * 2, r * 2);
        }

        // Dual Cupid / Angel Medallions
        g.setColor(new Color(250, 248, 245));
        g.fillOval(cx - 50, cy - 130, 100, 100);
        g.fillOval(cx - 50, cy + 30, 100, 100);

        g.setColor(new Color(168, 22, 35));
        g.setFont(new Font("Serif", Font.BOLD, 22));
        drawCentered(g, "POKER", cx, cy - 75);
        drawCentered(g, "CLASSIC", cx, cy + 85);

        g.dispose();
        return img;
    }

    private static BufferedImage renderCyberNeonBack() {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        setupHints(g);

        RoundRectangle2D cardShape = new RoundRectangle2D.Float(8, 8, W - 16, H - 16, 36, 36);
        g.setColor(new Color(10, 12, 20));
        g.fill(cardShape);

        // Holographic Cyan / Magenta border
        g.setColor(new Color(0, 240, 255));
        g.setStroke(new BasicStroke(3.0f));
        g.draw(cardShape);

        RoundRectangle2D inner = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 22, 22);
        g.setColor(new Color(255, 0, 128, 180));
        g.setStroke(new BasicStroke(1.8f));
        g.draw(inner);

        // Hexagon / Cyber Grid
        g.setColor(new Color(0, 240, 255, 30));
        g.setStroke(new BasicStroke(1.0f));
        for (int y = 40; y < H - 40; y += 30) {
            g.drawLine(30, y, W - 30, y);
        }
        for (int x = 40; x < W - 40; x += 30) {
            g.drawLine(x, 40, x, H - 40);
        }

        // Center Cyber Core
        int cx = W / 2;
        int cy = H / 2;
        g.setColor(new Color(16, 20, 32));
        g.fillOval(cx - 65, cy - 65, 130, 130);
        g.setColor(new Color(0, 240, 255));
        g.setStroke(new BasicStroke(2.5f));
        g.drawOval(cx - 65, cy - 65, 130, 130);
        g.setColor(new Color(255, 0, 128));
        g.drawOval(cx - 45, cy - 45, 90, 90);

        g.setFont(new Font("Monospaced", Font.BOLD, 20));
        g.setColor(new Color(0, 255, 240));
        drawCentered(g, "CYBER", cx, cy - 6);
        g.setColor(new Color(255, 0, 128));
        drawCentered(g, "CARD", cx, cy + 18);

        g.dispose();
        return img;
    }

    private static BufferedImage renderDarkArcaneBack() {
        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        setupHints(g);

        RoundRectangle2D cardShape = new RoundRectangle2D.Float(8, 8, W - 16, H - 16, 36, 36);
        g.setColor(new Color(12, 10, 14));
        g.fill(cardShape);

        // Blood gold border
        g.setColor(new Color(190, 35, 45));
        g.setStroke(new BasicStroke(3.5f));
        g.draw(cardShape);

        RoundRectangle2D inner = new RoundRectangle2D.Float(24, 24, W - 48, H - 48, 22, 22);
        g.setColor(new Color(210, 160, 60, 160));
        g.setStroke(new BasicStroke(1.5f));
        g.draw(inner);

        // Arcane runes and pentagram in center
        int cx = W / 2;
        int cy = H / 2;
        g.setColor(new Color(190, 35, 45, 140));
        g.setStroke(new BasicStroke(2.0f));
        g.drawOval(cx - 85, cy - 85, 170, 170);

        // 5-point star
        int points = 5;
        int r = 85;
        int[] px = new int[points];
        int[] py = new int[points];
        for (int i = 0; i < points; i++) {
            double a = Math.toRadians(i * (360.0 / points) - 90);
            px[i] = cx + (int) (Math.cos(a) * r);
            py[i] = cy + (int) (Math.sin(a) * r);
        }
        for (int i = 0; i < points; i++) {
            int next = (i + 2) % points;
            g.drawLine(px[i], py[i], px[next], py[next]);
        }

        g.setFont(new Font("Serif", Font.BOLD, 18));
        g.setColor(new Color(210, 160, 60));
        drawCentered(g, "ARCANE TAROT", cx, cy + 130);

        g.dispose();
        return img;
    }

    // --- HELPER DRAWING UTILS ---

    private static void setupHints(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }

    private static Color getSuitColor(String suit) {
        if ("HEARTS".equals(suit) || "DIAMONDS".equals(suit)) {
            return new Color(214, 24, 43); // vivid crimson
        } else {
            return new Color(24, 24, 28); // obsidian black
        }
    }

    private static void drawCorner(Graphics2D g, String rank, String suit, Color col, int x, int y, boolean invert) {
        AffineTransform old = g.getTransform();
        g.translate(x, y);
        if (invert) {
            g.rotate(Math.PI);
        }

        g.setColor(col);
        g.setFont(new Font("Serif", Font.BOLD, 46));
        g.drawString(rank, 0, 0);

        drawLargeSuit(g, suit, col, 14, 34, 26);

        g.setTransform(old);
    }

    private static void drawJokerCorner(Graphics2D g, Color col, int x, int y, boolean invert) {
        AffineTransform old = g.getTransform();
        g.translate(x, y);
        if (invert) {
            g.rotate(Math.PI);
        }

        g.setColor(col);
        g.setFont(new Font("Serif", Font.BOLD, 18));
        String text = "JOKER";
        for (int i = 0; i < text.length(); i++) {
            g.drawString(String.valueOf(text.charAt(i)), 0, i * 20);
        }

        drawDiamond(g, 7, text.length() * 20 + 8, 8, col);

        g.setTransform(old);
    }

    private static void drawLargeSuit(Graphics2D g, String suit, Color col, int cx, int cy, int size) {
        g.setColor(col);
        switch (suit) {
            case "SPADES" -> drawSpade(g, cx, cy, size);
            case "HEARTS" -> drawHeart(g, cx, cy, size);
            case "DIAMONDS" -> drawDiamondSuit(g, cx, cy, size);
            case "CLUBS" -> drawClub(g, cx, cy, size);
        }
    }

    private static void drawInvertedSuit(Graphics2D g, String suit, Color col, int cx, int cy, int size) {
        AffineTransform old = g.getTransform();
        g.translate(cx, cy);
        g.rotate(Math.PI);
        drawLargeSuit(g, suit, col, 0, 0, size);
        g.setTransform(old);
    }

    private static void drawSpade(Graphics2D g, int cx, int cy, int s) {
        Path2D p = new Path2D.Float();
        p.moveTo(cx, cy - s / 2.0);
        p.curveTo(cx + s * 0.45, cy - s * 0.15, cx + s * 0.5, cy + s * 0.25, cx, cy + s * 0.35);
        p.curveTo(cx - s * 0.5, cy + s * 0.25, cx - s * 0.45, cy - s * 0.15, cx, cy - s / 2.0);
        p.closePath();
        g.fill(p);

        // Spade Stem
        Path2D stem = new Path2D.Float();
        stem.moveTo(cx - s * 0.08, cy + s * 0.25);
        stem.lineTo(cx - s * 0.16, cy + s * 0.5);
        stem.lineTo(cx + s * 0.16, cy + s * 0.5);
        stem.lineTo(cx + s * 0.08, cy + s * 0.25);
        stem.closePath();
        g.fill(stem);
    }

    private static void drawHeart(Graphics2D g, int cx, int cy, int s) {
        Path2D p = new Path2D.Float();
        p.moveTo(cx, cy + s * 0.45);
        p.curveTo(cx - s * 0.55, cy + s * 0.15, cx - s * 0.55, cy - s * 0.35, cx - s * 0.24, cy - s * 0.45);
        p.curveTo(cx - s * 0.05, cy - s * 0.5, cx, cy - s * 0.25, cx, cy - s * 0.20);
        p.curveTo(cx, cy - s * 0.25, cx + s * 0.05, cy - s * 0.5, cx + s * 0.24, cy - s * 0.45);
        p.curveTo(cx + s * 0.55, cy - s * 0.35, cx + s * 0.55, cy + s * 0.15, cx, cy + s * 0.45);
        p.closePath();
        g.fill(p);
    }

    private static void drawDiamondSuit(Graphics2D g, int cx, int cy, int s) {
        Path2D p = new Path2D.Float();
        p.moveTo(cx, cy - s * 0.52);
        p.lineTo(cx + s * 0.38, cy);
        p.lineTo(cx, cy + s * 0.52);
        p.lineTo(cx - s * 0.38, cy);
        p.closePath();
        g.fill(p);
    }

    private static void drawClub(Graphics2D g, int cx, int cy, int s) {
        int r = (int) (s * 0.24);
        g.fillOval(cx - r, cy - (int)(s * 0.38), r * 2, r * 2);
        g.fillOval(cx - (int)(s * 0.35), cy - (int)(s * 0.05), r * 2, r * 2);
        g.fillOval(cx + (int)(s * 0.35) - r * 2, cy - (int)(s * 0.05), r * 2, r * 2);

        // Stem
        Path2D stem = new Path2D.Float();
        stem.moveTo(cx - s * 0.08, cy);
        stem.lineTo(cx - s * 0.16, cy + s * 0.45);
        stem.lineTo(cx + s * 0.16, cy + s * 0.45);
        stem.lineTo(cx + s * 0.08, cy);
        stem.closePath();
        g.fill(stem);
    }

    private static void drawCrown(Graphics2D g, int x, int y, int w, int h, Color col) {
        g.setColor(col);
        Path2D crown = new Path2D.Float();
        crown.moveTo(x - w / 2, y + h / 2);
        crown.lineTo(x - w / 2, y - h / 4);
        crown.lineTo(x - w / 4, y);
        crown.lineTo(x, y - h / 2);
        crown.lineTo(x + w / 4, y);
        crown.lineTo(x + w / 2, y - h / 4);
        crown.lineTo(x + w / 2, y + h / 2);
        crown.closePath();
        g.fill(crown);
    }

    private static void drawTiara(Graphics2D g, int x, int y, int w, int h, Color col) {
        g.setColor(col);
        Path2D tiara = new Path2D.Float();
        tiara.moveTo(x - w / 2, y + h / 2);
        tiara.quadTo(x, y - h / 2, x + w / 2, y + h / 2);
        tiara.closePath();
        g.fill(tiara);
        g.setColor(Color.WHITE);
        g.fillOval(x - 3, y - h / 2 - 3, 6, 6);
    }

    private static void drawJesterCap(Graphics2D g, int x, int y, int w, int h, Color col) {
        g.setColor(col);
        g.fillArc(x - w / 2, y - h / 2, w, h * 2, 0, 180);
    }

    private static void drawDiamond(Graphics2D g, int cx, int cy, int size, Color col) {
        g.setColor(col);
        Path2D d = new Path2D.Float();
        d.moveTo(cx, cy - size / 2.0);
        d.lineTo(cx + size / 2.0, cy);
        d.lineTo(cx, cy + size / 2.0);
        d.lineTo(cx - size / 2.0, cy);
        d.closePath();
        g.fill(d);
    }

    private static void drawCentered(Graphics2D g, String text, int cx, int cy) {
        FontMetrics fm = g.getFontMetrics();
        int x = cx - fm.stringWidth(text) / 2;
        int y = cy - fm.getHeight() / 2 + fm.getAscent();
        g.drawString(text, x, y);
    }
}
