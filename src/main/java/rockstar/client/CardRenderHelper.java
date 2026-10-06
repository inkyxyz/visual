package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;

public class CardRenderHelper {

    public static boolean globalCardGlow = false;
    public static ColorRGBA globalGlowColor = null;

    // 4 ACES
    public static final Identifier ACE_SPADES = RockstarClient.id("textures/cards/ace_spades.png");
    public static final Identifier ACE_HEARTS = RockstarClient.id("textures/cards/ace_hearts.png");
    public static final Identifier ACE_DIAMONDS = RockstarClient.id("textures/cards/ace_diamonds.png");
    public static final Identifier ACE_CLUBS = RockstarClient.id("textures/cards/ace_clubs.png");

    // 4 KINGS
    public static final Identifier KING_SPADES = RockstarClient.id("textures/cards/king_spades.png");
    public static final Identifier KING_HEARTS = RockstarClient.id("textures/cards/king_hearts.png");
    public static final Identifier KING_DIAMONDS = RockstarClient.id("textures/cards/king_diamonds.png");
    public static final Identifier KING_CLUBS = RockstarClient.id("textures/cards/king_clubs.png");

    // 4 QUEENS
    public static final Identifier QUEEN_SPADES = RockstarClient.id("textures/cards/queen_spades.png");
    public static final Identifier QUEEN_HEARTS = RockstarClient.id("textures/cards/queen_hearts.png");
    public static final Identifier QUEEN_DIAMONDS = RockstarClient.id("textures/cards/queen_diamonds.png");
    public static final Identifier QUEEN_CLUBS = RockstarClient.id("textures/cards/queen_clubs.png");

    // 4 JACKS
    public static final Identifier JACK_SPADES = RockstarClient.id("textures/cards/jack_spades.png");
    public static final Identifier JACK_HEARTS = RockstarClient.id("textures/cards/jack_hearts.png");
    public static final Identifier JACK_DIAMONDS = RockstarClient.id("textures/cards/jack_diamonds.png");
    public static final Identifier JACK_CLUBS = RockstarClient.id("textures/cards/jack_clubs.png");

    // NUMERICAL & SPECIAL
    public static final Identifier TEN_SPADES = RockstarClient.id("textures/cards/ten_spades.png");
    public static final Identifier JOKER_RED = RockstarClient.id("textures/cards/joker_red.png");
    public static final Identifier JOKER_BLACK = RockstarClient.id("textures/cards/joker_black.png");
    public static final Identifier JOKER = RockstarClient.id("textures/cards/joker.png");

    // 7 DECK BACKS
    public static final Identifier CARD_BACK_MESH = RockstarClient.id("textures/cards/card_back_mesh.png");
    public static final Identifier CARD_BACK_MESH_BLUE = RockstarClient.id("textures/cards/card_back_mesh_blue.png");
    public static final Identifier CARD_BACK_UNO = RockstarClient.id("textures/cards/card_back_uno.png");
    public static final Identifier CARD_BACK_BICYCLE = RockstarClient.id("textures/cards/card_back_bicycle.png");
    public static final Identifier CARD_BACK_ROYAL = RockstarClient.id("textures/cards/card_back.png");
    public static final Identifier CARD_BACK_CYBER = RockstarClient.id("textures/cards/card_back_cyber.png");
    public static final Identifier CARD_BACK_ARCANE = RockstarClient.id("textures/cards/card_back_arcane.png");
    public static final Identifier CARD_BACK = CARD_BACK_MESH;

    // UNO CARDS
    public static final Identifier UNO_RED = RockstarClient.id("textures/cards/uno_red.png");
    public static final Identifier UNO_BLUE = RockstarClient.id("textures/cards/uno_blue.png");
    public static final Identifier UNO_GREEN = RockstarClient.id("textures/cards/uno_green.png");
    public static final Identifier UNO_YELLOW = RockstarClient.id("textures/cards/uno_yellow.png");
    public static final Identifier UNO_DRAW2 = RockstarClient.id("textures/cards/uno_draw2.png");
    public static final Identifier UNO_DRAW4 = RockstarClient.id("textures/cards/uno_draw4.png");
    public static final Identifier UNO_REVERSE = RockstarClient.id("textures/cards/uno_reverse.png");
    public static final Identifier UNO_SKIP = RockstarClient.id("textures/cards/uno_skip.png");
    public static final Identifier UNO_WILD = RockstarClient.id("textures/cards/uno_wild.png");

    public static final Identifier[] UNO_CARDS = {
        UNO_RED, UNO_BLUE, UNO_GREEN, UNO_YELLOW,
        UNO_DRAW2, UNO_REVERSE, UNO_SKIP, UNO_WILD, UNO_DRAW4
    };

    public static final Identifier[] ROYAL_FLUSH_CARDS = {
        TEN_SPADES,
        JACK_CLUBS,
        QUEEN_DIAMONDS,
        KING_HEARTS,
        ACE_SPADES
    };

    public static final Identifier[] ACES = {
        ACE_SPADES,
        ACE_HEARTS,
        ACE_DIAMONDS,
        ACE_CLUBS
    };

    public static final Identifier[] KINGS = {
        KING_SPADES,
        KING_HEARTS,
        KING_DIAMONDS,
        KING_CLUBS
    };

    public static final Identifier[] QUEENS = {
        QUEEN_SPADES,
        QUEEN_HEARTS,
        QUEEN_DIAMONDS,
        QUEEN_CLUBS
    };

    public static final Identifier[] COURT_CARDS = {
        KING_SPADES,
        QUEEN_HEARTS,
        JACK_DIAMONDS,
        KING_HEARTS,
        QUEEN_SPADES,
        JACK_CLUBS,
        KING_DIAMONDS,
        QUEEN_DIAMONDS
    };

    public static final Identifier[] JOKERS = {
        JOKER_RED,
        JOKER_BLACK
    };

    public static final Identifier[] ALL_CARDS = {
        ACE_SPADES, ACE_HEARTS, ACE_DIAMONDS, ACE_CLUBS,
        KING_SPADES, KING_HEARTS, KING_DIAMONDS, KING_CLUBS,
        QUEEN_SPADES, QUEEN_HEARTS, QUEEN_DIAMONDS, QUEEN_CLUBS,
        JACK_SPADES, JACK_HEARTS, JACK_DIAMONDS, JACK_CLUBS,
        TEN_SPADES, JOKER_RED, JOKER_BLACK
    };

    public static Identifier getCardTexture(int index) {
        int idx = Math.abs(index) % ALL_CARDS.length;
        return ALL_CARDS[idx];
    }

    public static Identifier[] getDeckCards(String deckName) {
        if (deckName == null) return ALL_CARDS;
        String s = deckName.toLowerCase();
        if (s.contains("uno")) {
            return UNO_CARDS;
        } else if (s.contains("royal")) {
            return ROYAL_FLUSH_CARDS;
        } else if (s.contains("ace")) {
            return ACES;
        } else if (s.contains("court") || s.contains("royalty")) {
            return COURT_CARDS;
        } else if (s.contains("joker")) {
            return JOKERS;
        } else if (s.contains("king")) {
            return KINGS;
        }
        return ALL_CARDS;
    }

    public static Identifier getDeckBack(String styleName) {
        if (styleName == null) return CARD_BACK_MESH;
        String s = styleName.toLowerCase();
        if (s.contains("uno")) {
            return CARD_BACK_UNO;
        } else if (s.contains("blue")) {
            return CARD_BACK_MESH_BLUE;
        } else if (s.contains("bicycle")) {
            return CARD_BACK_BICYCLE;
        } else if (s.contains("cyber") || s.contains("neon")) {
            return CARD_BACK_CYBER;
        } else if (s.contains("arcane") || s.contains("dark") || s.contains("blood")) {
            return CARD_BACK_ARCANE;
        } else if (s.contains("royal") || s.contains("gold")) {
            return CARD_BACK_ROYAL;
        } else if (s.contains("mesh") || s.contains("сетк") || s.contains("lattice") || s.contains("classic")) {
            return CARD_BACK_MESH;
        }
        return CARD_BACK_MESH;
    }

    public static void renderCard(MatrixStack matrices, float width, float height, Identifier cardTexture, float alpha) {
        renderCard(matrices, width, height, cardTexture, CARD_BACK_MESH, alpha, true, globalCardGlow, globalGlowColor);
    }

    public static void renderCard(MatrixStack matrices, float width, float height, Identifier frontTex, Identifier backTex, float alpha, boolean doubleSided) {
        renderCard(matrices, width, height, frontTex, backTex, alpha, doubleSided, globalCardGlow, globalGlowColor);
    }

    public static void renderCard(MatrixStack matrices, float width, float height, Identifier frontTex, Identifier backTex, float alpha, boolean doubleSided, boolean glow, ColorRGBA glowColor) {
        if (alpha <= 0.01F) return;

        int a = (int)(Math.min(1.0F, Math.max(0.0F, alpha)) * 255.0F);
        if (a <= 0) return;
        int white = (a << 24) | 0x00FFFFFF;

        float hw = width * 0.5F;
        float hh = height * 0.5F;

        Matrix4f mat = matrices.peek().getPositionMatrix();

        Identifier effectiveFront = frontTex != null ? frontTex : ACE_SPADES;
        Identifier effectiveBack = backTex;
        if (effectiveBack == null) {
            if (effectiveFront.getPath().contains("uno")) {
                effectiveBack = CARD_BACK_UNO;
            } else {
                effectiveBack = CARD_BACK_MESH;
            }
        }

        // Determine whether front or back faces the camera using view-space normal
        float m20 = mat.m20();
        float m21 = mat.m21();
        float m22 = mat.m22();
        float m30 = mat.m30();
        float m31 = mat.m31();
        float m32 = mat.m32();
        float dot = -(m20 * m30 + m21 * m31 + m22 * m32);

        boolean isFrontFacing = !doubleSided || dot >= 0.0F;
        Identifier tex = isFrontFacing ? effectiveFront : effectiveBack;

        // 1. Render vibrant 3D playing card glow aura if enabled
        if (glow || globalCardGlow) {
            ColorRGBA gCol = glowColor != null ? glowColor : (globalGlowColor != null ? globalGlowColor : IiiiiIIIi_Class242.I_method_7df8e08e());
            int gAlpha = (int)(Math.min(1.0F, Math.max(0.0F, alpha)) * 255.0F);
            if (gAlpha > 0) {
                RenderSystem.enableBlend();
                RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE);
                RenderSystem.depthMask(false);
                RenderSystem.disableCull();

                RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
                float spread1 = Math.max(width, height) * 0.12F;
                int innerCol = gCol.withAlpha((int)(gAlpha * 0.55F)).getRGB();

                BufferBuilder glowBb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
                glowBb.vertex(mat, -hw - spread1, -hh - spread1, 0.001F).color(innerCol);
                glowBb.vertex(mat, hw + spread1, -hh - spread1, 0.001F).color(innerCol);
                glowBb.vertex(mat, hw + spread1, hh + spread1, 0.001F).color(innerCol);
                glowBb.vertex(mat, -hw - spread1, hh + spread1, 0.001F).color(innerCol);

                float spread2 = Math.max(width, height) * 0.28F;
                int outerCol = gCol.withAlpha((int)(gAlpha * 0.25F)).getRGB();
                glowBb.vertex(mat, -hw - spread2, -hh - spread2, 0.0005F).color(outerCol);
                glowBb.vertex(mat, hw + spread2, -hh - spread2, 0.0005F).color(outerCol);
                glowBb.vertex(mat, hw + spread2, hh + spread2, 0.0005F).color(outerCol);
                glowBb.vertex(mat, -hw - spread2, hh + spread2, 0.0005F).color(outerCol);

                BuiltBuffer glowBuilt = glowBb.endNullable();
                if (glowBuilt != null) {
                    BufferRenderer.drawWithGlobalProgram(glowBuilt);
                }

                RenderSystem.defaultBlendFunc();
                RenderSystem.depthMask(true);
            }
        }

        // 2. Render Card Face / Back
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();

        RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderTexture(0, tex);
        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        if (isFrontFacing) {
            bb.vertex(mat, -hw, -hh, 0.0F).texture(0.0F, 1.0F).color(white);
            bb.vertex(mat, hw, -hh, 0.0F).texture(1.0F, 1.0F).color(white);
            bb.vertex(mat, hw, hh, 0.0F).texture(1.0F, 0.0F).color(white);
            bb.vertex(mat, -hw, hh, 0.0F).texture(0.0F, 0.0F).color(white);
        } else {
            bb.vertex(mat, hw, -hh, 0.0F).texture(0.0F, 1.0F).color(white);
            bb.vertex(mat, -hw, -hh, 0.0F).texture(1.0F, 1.0F).color(white);
            bb.vertex(mat, -hw, hh, 0.0F).texture(1.0F, 0.0F).color(white);
            bb.vertex(mat, hw, hh, 0.0F).texture(0.0F, 0.0F).color(white);
        }
        BuiltBuffer built = bb.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }

        RenderSystem.enableCull();
    }
}
