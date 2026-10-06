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
    public static final Identifier BLOOM_TEXTURE = RockstarClient.id("textures/bloom.png");

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

        // 1. Backlight Illumination: Smooth Radial Gradient Bloom & Edge Falloff (no harsh outlines)
        if (glow || globalCardGlow) {
            ColorRGBA gCol = glowColor != null ? glowColor : (globalGlowColor != null ? globalGlowColor : IiiiiIIIi_Class242.I_method_7df8e08e());
            float gAlpha = Math.min(1.0F, Math.max(0.0F, alpha));
            if (gAlpha > 0.01F) {
                RenderSystem.enableBlend();
                RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE);
                RenderSystem.depthMask(false);
                RenderSystem.disableCull();

                // 1A. Dual-Lobe Radial Light Bloom behind the card (smooth, undistorted light clouds)
                RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
                RenderSystem.setShaderTexture(0, BLOOM_TEXTURE);

                float maxDim = Math.max(width, height);
                float lobeSize = maxDim * 1.35F;
                float lobeHalf = lobeSize * 0.5F;
                float lobeOffsetY = height * 0.16F;
                int bloomColLobe = gCol.withAlpha((int)(gAlpha * 125.0F)).getRGB();

                BufferBuilder bloomBb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
                // Top lobe light
                bloomBb.vertex(mat, -lobeHalf, lobeOffsetY - lobeHalf, -0.003F).texture(0.0F, 0.0F).color(bloomColLobe);
                bloomBb.vertex(mat, lobeHalf, lobeOffsetY - lobeHalf, -0.003F).texture(1.0F, 0.0F).color(bloomColLobe);
                bloomBb.vertex(mat, lobeHalf, lobeOffsetY + lobeHalf, -0.003F).texture(1.0F, 1.0F).color(bloomColLobe);
                bloomBb.vertex(mat, -lobeHalf, lobeOffsetY + lobeHalf, -0.003F).texture(0.0F, 1.0F).color(bloomColLobe);

                // Bottom lobe light
                bloomBb.vertex(mat, -lobeHalf, -lobeOffsetY - lobeHalf, -0.003F).texture(0.0F, 0.0F).color(bloomColLobe);
                bloomBb.vertex(mat, lobeHalf, -lobeOffsetY - lobeHalf, -0.003F).texture(1.0F, 0.0F).color(bloomColLobe);
                bloomBb.vertex(mat, lobeHalf, -lobeOffsetY + lobeHalf, -0.003F).texture(1.0F, 1.0F).color(bloomColLobe);
                bloomBb.vertex(mat, -lobeHalf, -lobeOffsetY + lobeHalf, -0.003F).texture(0.0F, 1.0F).color(bloomColLobe);

                // Wide soft ambient aura centered behind card
                float auraSize = maxDim * 2.2F;
                float auraHalf = auraSize * 0.5F;
                int bloomColAura = gCol.withAlpha((int)(gAlpha * 65.0F)).getRGB();
                bloomBb.vertex(mat, -auraHalf, -auraHalf, -0.004F).texture(0.0F, 0.0F).color(bloomColAura);
                bloomBb.vertex(mat, auraHalf, -auraHalf, -0.004F).texture(1.0F, 0.0F).color(bloomColAura);
                bloomBb.vertex(mat, auraHalf, auraHalf, -0.004F).texture(1.0F, 1.0F).color(bloomColAura);
                bloomBb.vertex(mat, -auraHalf, auraHalf, -0.004F).texture(0.0F, 1.0F).color(bloomColAura);

                BuiltBuffer builtBloom = bloomBb.endNullable();
                if (builtBloom != null) {
                    BufferRenderer.drawWithGlobalProgram(builtBloom);
                }

                // 1B. Seamless 9-Slice Rounded Corner Glow (4 edge quads + 4 radial corner fans)
                RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
                float spread = maxDim * 0.25F;
                int edgeInner = gCol.withAlpha((int)(gAlpha * 140.0F)).getRGB();
                int edgeOuter = gCol.withAlpha(0).getRGB();
                float glowZ = -0.001F;

                BufferBuilder gradBb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);

                // --- 4 Straight Edge Strips ---
                // Top edge strip
                gradBb.vertex(mat, -hw, hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, hw, hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, hw, hh + spread, glowZ).color(edgeOuter);

                gradBb.vertex(mat, -hw, hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, hw, hh + spread, glowZ).color(edgeOuter);
                gradBb.vertex(mat, -hw, hh + spread, glowZ).color(edgeOuter);

                // Bottom edge strip
                gradBb.vertex(mat, -hw, -hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, -hw, -hh - spread, glowZ).color(edgeOuter);
                gradBb.vertex(mat, hw, -hh - spread, glowZ).color(edgeOuter);

                gradBb.vertex(mat, -hw, -hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, hw, -hh - spread, glowZ).color(edgeOuter);
                gradBb.vertex(mat, hw, -hh, glowZ).color(edgeInner);

                // Left edge strip
                gradBb.vertex(mat, -hw, -hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, -hw, hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, -hw - spread, hh, glowZ).color(edgeOuter);

                gradBb.vertex(mat, -hw, -hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, -hw - spread, hh, glowZ).color(edgeOuter);
                gradBb.vertex(mat, -hw - spread, -hh, glowZ).color(edgeOuter);

                // Right edge strip
                gradBb.vertex(mat, hw, -hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, hw + spread, -hh, glowZ).color(edgeOuter);
                gradBb.vertex(mat, hw + spread, hh, glowZ).color(edgeOuter);

                gradBb.vertex(mat, hw, -hh, glowZ).color(edgeInner);
                gradBb.vertex(mat, hw + spread, hh, glowZ).color(edgeOuter);
                gradBb.vertex(mat, hw, hh, glowZ).color(edgeInner);

                // --- 4 Smooth Radial Corner Fans ---
                final int CORNER_STEPS = 10;
                final float HALF_PI = (float)(Math.PI / 2.0);

                // Top-Right corner fan: origin (hw, hh), arc 0 -> PI/2
                for (int s = 0; s < CORNER_STEPS; s++) {
                    float a1 = s * HALF_PI / CORNER_STEPS;
                    float a2 = (s + 1) * HALF_PI / CORNER_STEPS;
                    float x1 = hw + spread * (float)Math.cos(a1);
                    float y1 = hh + spread * (float)Math.sin(a1);
                    float x2 = hw + spread * (float)Math.cos(a2);
                    float y2 = hh + spread * (float)Math.sin(a2);

                    gradBb.vertex(mat, hw, hh, glowZ).color(edgeInner);
                    gradBb.vertex(mat, x1, y1, glowZ).color(edgeOuter);
                    gradBb.vertex(mat, x2, y2, glowZ).color(edgeOuter);
                }

                // Top-Left corner fan: origin (-hw, hh), arc PI/2 -> PI
                for (int s = 0; s < CORNER_STEPS; s++) {
                    float a1 = HALF_PI + s * HALF_PI / CORNER_STEPS;
                    float a2 = HALF_PI + (s + 1) * HALF_PI / CORNER_STEPS;
                    float x1 = -hw + spread * (float)Math.cos(a1);
                    float y1 = hh + spread * (float)Math.sin(a1);
                    float x2 = -hw + spread * (float)Math.cos(a2);
                    float y2 = hh + spread * (float)Math.sin(a2);

                    gradBb.vertex(mat, -hw, hh, glowZ).color(edgeInner);
                    gradBb.vertex(mat, x1, y1, glowZ).color(edgeOuter);
                    gradBb.vertex(mat, x2, y2, glowZ).color(edgeOuter);
                }

                // Bottom-Left corner fan: origin (-hw, -hh), arc PI -> 3*PI/2
                for (int s = 0; s < CORNER_STEPS; s++) {
                    float a1 = (float)Math.PI + s * HALF_PI / CORNER_STEPS;
                    float a2 = (float)Math.PI + (s + 1) * HALF_PI / CORNER_STEPS;
                    float x1 = -hw + spread * (float)Math.cos(a1);
                    float y1 = -hh + spread * (float)Math.sin(a1);
                    float x2 = -hw + spread * (float)Math.cos(a2);
                    float y2 = -hh + spread * (float)Math.sin(a2);

                    gradBb.vertex(mat, -hw, -hh, glowZ).color(edgeInner);
                    gradBb.vertex(mat, x1, y1, glowZ).color(edgeOuter);
                    gradBb.vertex(mat, x2, y2, glowZ).color(edgeOuter);
                }

                // Bottom-Right corner fan: origin (hw, -hh), arc 3*PI/2 -> 2*PI
                for (int s = 0; s < CORNER_STEPS; s++) {
                    float a1 = 3.0F * HALF_PI + s * HALF_PI / CORNER_STEPS;
                    float a2 = 3.0F * HALF_PI + (s + 1) * HALF_PI / CORNER_STEPS;
                    float x1 = hw + spread * (float)Math.cos(a1);
                    float y1 = -hh + spread * (float)Math.sin(a1);
                    float x2 = hw + spread * (float)Math.cos(a2);
                    float y2 = -hh + spread * (float)Math.sin(a2);

                    gradBb.vertex(mat, hw, -hh, glowZ).color(edgeInner);
                    gradBb.vertex(mat, x1, y1, glowZ).color(edgeOuter);
                    gradBb.vertex(mat, x2, y2, glowZ).color(edgeOuter);
                }

                BuiltBuffer builtGrad = gradBb.endNullable();
                if (builtGrad != null) {
                    BufferRenderer.drawWithGlobalProgram(builtGrad);
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

        // 3. Card Surface Gradient Backlight Illumination (подсветка самой карты)
        if ((glow || globalCardGlow) && alpha > 0.01F) {
            ColorRGBA gCol = glowColor != null ? glowColor : (globalGlowColor != null ? globalGlowColor : IiiiiIIIi_Class242.I_method_7df8e08e());
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE);
            RenderSystem.depthMask(false);
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

            int topTint = gCol.withAlpha((int)(alpha * 65.0F)).getRGB();
            int botTint = gCol.withAlpha((int)(alpha * 15.0F)).getRGB();

            BufferBuilder tintBb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            tintBb.vertex(mat, -hw, -hh, 0.001F).color(botTint);
            tintBb.vertex(mat, hw, -hh, 0.001F).color(botTint);
            tintBb.vertex(mat, hw, hh, 0.001F).color(topTint);
            tintBb.vertex(mat, -hw, hh, 0.001F).color(topTint);
            BuiltBuffer tintBuilt = tintBb.endNullable();
            if (tintBuilt != null) {
                BufferRenderer.drawWithGlobalProgram(tintBuilt);
            }

            RenderSystem.defaultBlendFunc();
            RenderSystem.depthMask(true);
        }

        RenderSystem.enableCull();
    }
}
