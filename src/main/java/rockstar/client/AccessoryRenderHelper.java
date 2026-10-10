package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;

public class AccessoryRenderHelper {

    public static final Identifier TEX_SHURIKEN = RockstarClient.id("textures/accessories/shuriken.png");

    public static void applyHeadAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float headYaw, float headPitch, float bodyYaw, float scale, float yOffset) {
        boolean sneak = player.isSneaking();
        double forward = sneak ? 0.24 : 0.0;
        double radYaw = Math.toRadians(bodyYaw);
        double headX = ix - Math.sin(radYaw) * forward;
        double headZ = iz + Math.cos(radYaw) * forward;
        double headY = iy + (sneak ? 1.34 : 1.66) + yOffset;

        m.translate(headX, headY, headZ);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - headYaw));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-headPitch));
        m.translate(0.0, 0.14, 0.0);
        m.scale(scale, scale, scale);
    }

    public static void applyFaceAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float headYaw, float headPitch, float bodyYaw, float scale, float yOffset) {
        boolean sneak = player.isSneaking();
        double forward = sneak ? 0.24 : 0.0;
        double radYaw = Math.toRadians(bodyYaw);
        double headX = ix - Math.sin(radYaw) * forward;
        double headZ = iz + Math.cos(radYaw) * forward;
        double headY = iy + (sneak ? 1.34 : 1.66) + yOffset;

        m.translate(headX, headY, headZ);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - headYaw));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-headPitch));
        m.translate(0.0, 0.0, 0.0);
        m.scale(scale, scale, scale);
    }

    public static void applyTorsoAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float bodyYaw, float scale, float yOffset) {
        boolean sneak = player.isSneaking();
        double torsoY = iy + (sneak ? 0.76 : 1.02);
        m.translate(ix, torsoY, iz);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - bodyYaw));
        if (sneak) {
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(28.6F));
            m.translate(0.0, 0.0, 0.06);
        }
        m.translate(0.0, yOffset, 0.0);
        m.scale(scale, scale, scale);
    }

    public static void applyOrbitAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float bodyYaw, float scale, float radius, float yOffset) {
        boolean sneak = player.isSneaking();
        double waistY = iy + (sneak ? 0.62 : 0.82);
        m.translate(ix, waistY, iz);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - bodyYaw));
        if (sneak) {
            m.translate(0.0, 0.0, 0.10);
        }
        m.translate(0.0, yOffset, 0.0);
        m.scale(scale * radius, scale, scale * radius);
    }

    public static void applyPetAnchor(MatrixStack m, ClientPlayerEntity player, double ix, double iy, double iz, float bodyYaw, float scale, float dist, float yOffset) {
        boolean sneak = player.isSneaking();
        double shoulderY = iy + (sneak ? 0.88 : 1.18);
        m.translate(ix, shoulderY, iz);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - bodyYaw));
        if (sneak) {
            m.translate(0.0, 0.0, 0.08);
        }
        m.translate(-0.35 * (dist - 1.0), yOffset, -0.20 * (dist - 1.0));
        m.scale(scale, scale, scale);
    }
    public static int shade(int argb, float factor) {
        int a = (argb >> 24) & 0xFF;
        int r = Math.min(255, (int)(((argb >> 16) & 0xFF) * factor));
        int g = Math.min(255, (int)(((argb >> 8) & 0xFF) * factor));
        int b = Math.min(255, (int)((argb & 0xFF) * factor));
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    public static void drawQuad(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, int col) {
        b.vertex(m, x1, y1, z1).color(col);
        b.vertex(m, x2, y2, z2).color(col);
        b.vertex(m, x3, y3, z3).color(col);
        b.vertex(m, x4, y4, z4).color(col);
    }

    public static void draw3DTriangle(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, int col) {
        int c1 = shade(col, 1.0F), c2 = shade(col, 0.85F), c3 = shade(col, 0.70F);
        b.vertex(m, x1, y1, z1).color(c1);
        b.vertex(m, x2, y2, z2).color(c2);
        b.vertex(m, x3, y3, z3).color(c3);
        b.vertex(m, x1, y1, z1).color(c1);
    }

    // 1. True 3D Box (Cuboid) with 6 shaded planar faces
    public static void draw3DBox(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float x2, float y2, float z2, int col) {
        int cTop = shade(col, 1.00F);
        int cFront = shade(col, 0.88F);
        int cBack = shade(col, 0.82F);
        int cLeft = shade(col, 0.72F);
        int cRight = shade(col, 0.72F);
        int cBot = shade(col, 0.55F);

        // Top (+Y)
        b.vertex(m, x1, y2, z1).color(cTop);
        b.vertex(m, x1, y2, z2).color(cTop);
        b.vertex(m, x2, y2, z2).color(cTop);
        b.vertex(m, x2, y2, z1).color(cTop);

        // Bottom (-Y)
        b.vertex(m, x1, y1, z2).color(cBot);
        b.vertex(m, x1, y1, z1).color(cBot);
        b.vertex(m, x2, y1, z1).color(cBot);
        b.vertex(m, x2, y1, z2).color(cBot);

        // Front (-Z)
        b.vertex(m, x1, y2, z1).color(cFront);
        b.vertex(m, x2, y2, z1).color(cFront);
        b.vertex(m, x2, y1, z1).color(cFront);
        b.vertex(m, x1, y1, z1).color(cFront);

        // Back (+Z)
        b.vertex(m, x2, y2, z2).color(cBack);
        b.vertex(m, x1, y2, z2).color(cBack);
        b.vertex(m, x1, y1, z2).color(cBack);
        b.vertex(m, x2, y1, z2).color(cBack);

        // Left (-X)
        b.vertex(m, x1, y2, z2).color(cLeft);
        b.vertex(m, x1, y2, z1).color(cLeft);
        b.vertex(m, x1, y1, z1).color(cLeft);
        b.vertex(m, x1, y1, z2).color(cLeft);

        // Right (+X)
        b.vertex(m, x2, y2, z1).color(cRight);
        b.vertex(m, x2, y2, z2).color(cRight);
        b.vertex(m, x2, y1, z2).color(cRight);
        b.vertex(m, x2, y1, z1).color(cRight);
    }

    // 2. True 3D Triangular Ear Wedge: full 3D solid with thickness, outer fur, and recessed inner pad
    public static void draw3DEarWedge(BufferBuilder b, Matrix4f m, float w, float h, float thickness, int furCol, int innerPadCol) {
        float hw = w * 0.5F;
        float zFront = -thickness * 0.5F;
        float zBack = thickness * 0.5F;

        int cFurTop = shade(furCol, 1.0F);
        int cFurFront = shade(furCol, 0.88F);
        int cFurBack = shade(furCol, 0.80F);
        int cFurSide = shade(furCol, 0.70F);
        int cPad = shade(innerPadCol, 0.95F);

        // Back slope face (outer fur)
        b.vertex(m, -hw, 0.0F, zBack).color(cFurBack);
        b.vertex(m, hw, 0.0F, zBack).color(cFurBack);
        b.vertex(m, 0.0F, h, zBack * 0.3F).color(cFurTop);
        b.vertex(m, 0.0F, h, zBack * 0.3F).color(cFurTop);

        // Front border face (outer fur rim)
        b.vertex(m, 0.0F, h, zFront * 0.3F).color(cFurTop);
        b.vertex(m, hw, 0.0F, zFront).color(cFurFront);
        b.vertex(m, -hw, 0.0F, zFront).color(cFurFront);
        b.vertex(m, 0.0F, h, zFront * 0.3F).color(cFurTop);

        // Recessed inner ear pad (3D indented inward towards z = 0)
        float ihw = hw * 0.68F;
        float ih = h * 0.74F;
        b.vertex(m, 0.0F, ih + 0.02F, 0.0F).color(cPad);
        b.vertex(m, ihw, 0.02F, zFront * 0.25F).color(cPad);
        b.vertex(m, -ihw, 0.02F, zFront * 0.25F).color(cPad);
        b.vertex(m, 0.0F, ih + 0.02F, 0.0F).color(cPad);

        // Left outer side wall
        b.vertex(m, -hw, 0.0F, zBack).color(cFurSide);
        b.vertex(m, 0.0F, h, zBack * 0.3F).color(cFurTop);
        b.vertex(m, 0.0F, h, zFront * 0.3F).color(cFurTop);
        b.vertex(m, -hw, 0.0F, zFront).color(cFurSide);

        // Right outer side wall
        b.vertex(m, hw, 0.0F, zFront).color(cFurSide);
        b.vertex(m, 0.0F, h, zFront * 0.3F).color(cFurTop);
        b.vertex(m, 0.0F, h, zBack * 0.3F).color(cFurTop);
        b.vertex(m, hw, 0.0F, zBack).color(cFurSide);

        // Bottom base face (rests firmly on skull)
        b.vertex(m, -hw, 0.0F, zFront).color(shade(furCol, 0.55F));
        b.vertex(m, hw, 0.0F, zFront).color(shade(furCol, 0.55F));
        b.vertex(m, hw, 0.0F, zBack).color(shade(furCol, 0.55F));
        b.vertex(m, -hw, 0.0F, zBack).color(shade(furCol, 0.55F));
    }

    // 3. True 3D 4-sided Tapered Segment (for curved horns, tail segments, tentacles)
    public static void draw3DTaperedSegment(BufferBuilder b, Matrix4f m,
                                            float x1, float y1, float z1, float r1,
                                            float x2, float y2, float z2, float r2,
                                            int col1, int col2) {
        int c1Top = shade(col1, 1.0F), c2Top = shade(col2, 1.0F);
        int c1Bot = shade(col1, 0.55F), c2Bot = shade(col2, 0.55F);
        int c1Side = shade(col1, 0.75F), c2Side = shade(col2, 0.75F);

        // Top face
        b.vertex(m, x1 - r1, y1 + r1, z1 - r1).color(c1Top);
        b.vertex(m, x1 + r1, y1 + r1, z1 - r1).color(c1Top);
        b.vertex(m, x2 + r2, y2 + r2, z2 - r2).color(c2Top);
        b.vertex(m, x2 - r2, y2 + r2, z2 - r2).color(c2Top);

        // Bottom face
        b.vertex(m, x2 - r2, y2 - r2, z2 + r2).color(c2Bot);
        b.vertex(m, x2 + r2, y2 - r2, z2 + r2).color(c2Bot);
        b.vertex(m, x1 + r1, y1 - r1, z1 + r1).color(c1Bot);
        b.vertex(m, x1 - r1, y1 - r1, z1 + r1).color(c1Bot);

        // Front face
        b.vertex(m, x1 - r1, y1 - r1, z1 - r1).color(c1Side);
        b.vertex(m, x1 + r1, y1 - r1, z1 - r1).color(c1Side);
        b.vertex(m, x2 + r2, y2 - r2, z2 - r2).color(c2Side);
        b.vertex(m, x2 - r2, y2 - r2, z2 - r2).color(c2Side);

        // Back face
        b.vertex(m, x2 - r2, y2 + r2, z2 + r2).color(c2Side);
        b.vertex(m, x2 + r2, y2 + r2, z2 + r2).color(c2Side);
        b.vertex(m, x1 + r1, y1 + r1, z1 + r1).color(c1Side);
        b.vertex(m, x1 - r1, y1 + r1, z1 + r1).color(c1Side);
    }

    // 4. True 3D 8-faceted Octahedron Gemstone (Double Pyramid with 8 distinct lit planar triangular faces)
    public static void draw3DOctahedron(BufferBuilder b, Matrix4f m, float cx, float cy, float cz, float rx, float ry, float rz, int color) {
        int cTop = shade(color, 1.00F);
        int cMidF = shade(color, 0.90F);
        int cMidR = shade(color, 0.80F);
        int cMidB = shade(color, 0.70F);
        int cMidL = shade(color, 0.60F);
        int cBot = shade(color, 0.45F);

        float topY = cy + ry;
        float botY = cy - ry;

        float fx = cx, fz = cz - rz;       // Front
        float rxP = cx + rx, rzP = cz;    // Right
        float bx = cx, bz = cz + rz;       // Back
        float lx = cx - rx, lz = cz;       // Left

        // Top 4 Triangular Facets
        b.vertex(m, cx, topY, cz).color(cTop);
        b.vertex(m, rxP, cy, rzP).color(cMidF);
        b.vertex(m, fx, cy, fz).color(cMidF);
        b.vertex(m, cx, topY, cz).color(cTop);

        b.vertex(m, cx, topY, cz).color(cTop);
        b.vertex(m, bx, cy, bz).color(cMidR);
        b.vertex(m, rxP, cy, rzP).color(cMidR);
        b.vertex(m, cx, topY, cz).color(cTop);

        b.vertex(m, cx, topY, cz).color(cTop);
        b.vertex(m, lx, cy, lz).color(cMidB);
        b.vertex(m, bx, cy, bz).color(cMidB);
        b.vertex(m, cx, topY, cz).color(cTop);

        b.vertex(m, cx, topY, cz).color(cTop);
        b.vertex(m, fx, cy, fz).color(cMidL);
        b.vertex(m, lx, cy, lz).color(cMidL);
        b.vertex(m, cx, topY, cz).color(cTop);

        // Bottom 4 Triangular Facets
        b.vertex(m, cx, botY, cz).color(cBot);
        b.vertex(m, fx, cy, fz).color(cMidF);
        b.vertex(m, rxP, cy, rzP).color(cMidF);
        b.vertex(m, cx, botY, cz).color(cBot);

        b.vertex(m, cx, botY, cz).color(cBot);
        b.vertex(m, rxP, cy, rzP).color(cMidR);
        b.vertex(m, bx, cy, bz).color(cMidR);
        b.vertex(m, cx, botY, cz).color(cBot);

        b.vertex(m, cx, botY, cz).color(cBot);
        b.vertex(m, bx, cy, bz).color(cMidB);
        b.vertex(m, lx, cy, lz).color(cMidB);
        b.vertex(m, cx, botY, cz).color(cBot);

        b.vertex(m, cx, botY, cz).color(cBot);
        b.vertex(m, lx, cy, lz).color(cMidL);
        b.vertex(m, fx, cy, fz).color(cMidL);
        b.vertex(m, cx, botY, cz).color(cBot);
    }

    // 5. True 3D Cylinder / Prism Drum with shaded sides and endcaps
    public static void draw3DCylinder(BufferBuilder b, Matrix4f m, float cx, float cy, float cz, float r, float h, int segs, int color) {
        int cTop = shade(color, 1.0F);
        int cBot = shade(color, 0.55F);
        float y1 = cy;
        float y2 = cy + h;

        for (int i = 0; i < segs; i++) {
            double a1 = (Math.PI * 2.0 * i) / segs;
            double a2 = (Math.PI * 2.0 * (i + 1)) / segs;
            float cos1 = (float)Math.cos(a1), sin1 = (float)Math.sin(a1);
            float cos2 = (float)Math.cos(a2), sin2 = (float)Math.sin(a2);

            float x1 = cx + cos1 * r, z1 = cz + sin1 * r;
            float x2 = cx + cos2 * r, z2 = cz + sin2 * r;

            float light = 0.65F + 0.35F * Math.max(0.0F, cos1);
            int cSide = shade(color, light);

            // Wall quad
            b.vertex(m, x1, y2, z1).color(cSide);
            b.vertex(m, x2, y2, z2).color(cSide);
            b.vertex(m, x2, y1, z2).color(cSide);
            b.vertex(m, x1, y1, z1).color(cSide);

            // Top disc
            b.vertex(m, cx, y2, cz).color(cTop);
            b.vertex(m, x1, y2, z1).color(cTop);
            b.vertex(m, x2, y2, z2).color(cTop);
            b.vertex(m, cx, y2, cz).color(cTop);

            // Bottom disc
            b.vertex(m, cx, y1, cz).color(cBot);
            b.vertex(m, x2, y1, z2).color(cBot);
            b.vertex(m, x1, y1, z1).color(cBot);
            b.vertex(m, cx, y1, cz).color(cBot);
        }
    }

    // 6. True 3D Volumetric Ring (Torus Band) with outer wall, inner wall, and top/bottom rims
    public static void draw3DRing(BufferBuilder b, Matrix4f m, float cx, float cy, float cz, float rOuter, float rInner, float h, int segs, int color) {
        int cTop = shade(color, 1.0F);
        int cBot = shade(color, 0.55F);
        float y1 = cy;
        float y2 = cy + h;

        for (int i = 0; i < segs; i++) {
            double a1 = (Math.PI * 2.0 * i) / segs;
            double a2 = (Math.PI * 2.0 * (i + 1)) / segs;
            float c1 = (float)Math.cos(a1), s1 = (float)Math.sin(a1);
            float c2 = (float)Math.cos(a2), s2 = (float)Math.sin(a2);

            // Outer wall
            float light = 0.65F + 0.35F * Math.max(0.0F, c1);
            int cOuter = shade(color, light);
            b.vertex(m, cx + c1 * rOuter, y2, cz + s1 * rOuter).color(cOuter);
            b.vertex(m, cx + c2 * rOuter, y2, cz + s2 * rOuter).color(cOuter);
            b.vertex(m, cx + c2 * rOuter, y1, cz + s2 * rOuter).color(cOuter);
            b.vertex(m, cx + c1 * rOuter, y1, cz + s1 * rOuter).color(cOuter);

            // Inner wall
            int cInner = shade(color, light * 0.75F);
            b.vertex(m, cx + c2 * rInner, y2, cz + s2 * rInner).color(cInner);
            b.vertex(m, cx + c1 * rInner, y2, cz + s1 * rInner).color(cInner);
            b.vertex(m, cx + c1 * rInner, y1, cz + s1 * rInner).color(cInner);
            b.vertex(m, cx + c2 * rInner, y1, cz + s2 * rInner).color(cInner);

            // Top rim
            b.vertex(m, cx + c1 * rOuter, y2, cz + s1 * rOuter).color(cTop);
            b.vertex(m, cx + c1 * rInner, y2, cz + s1 * rInner).color(cTop);
            b.vertex(m, cx + c2 * rInner, y2, cz + s2 * rInner).color(cTop);
            b.vertex(m, cx + c2 * rOuter, y2, cz + s2 * rOuter).color(cTop);

            // Bottom rim
            b.vertex(m, cx + c1 * rOuter, y1, cz + s1 * rOuter).color(cBot);
            b.vertex(m, cx + c2 * rOuter, y1, cz + s2 * rOuter).color(cBot);
            b.vertex(m, cx + c2 * rInner, y1, cz + s2 * rInner).color(cBot);
            b.vertex(m, cx + c1 * rInner, y1, cz + s1 * rInner).color(cBot);
        }
    }

    // =========================================================================
    // 20 TRUE 3D VOLUMETRIC ACCESSORIES
    // =========================================================================

    // 1. CAT EARS: Solid 3D triangular wedges with thickness & recessed pink fluff pad
    public static void renderCatEars(MatrixStack m, BufferBuilder buf, int color, float t) {
        float twitchL = (float)Math.sin(t * 3.0) * 0.015F;
        float twitchR = (float)Math.cos(t * 3.5) * 0.015F;
        int furCol = color;
        int padCol = 0xFFFF8FA8; // Vibrant soft pink inner ear pad

        // Left Ear: Outward roll (+Z), outward yaw (-Y)
        m.push();
        m.translate(-0.19F, 0.16F + twitchL, -0.02F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(18.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-15.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-6.0F));
        draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.22F, 0.26F, 0.08F, furCol, padCol);
        m.pop();

        // Right Ear: Outward roll (-Z), outward yaw (+Y)
        m.push();
        m.translate(0.19F, 0.16F + twitchR, -0.02F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-18.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(15.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-6.0F));
        draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.22F, 0.26F, 0.08F, furCol, padCol);
        m.pop();
    }

    // 2. FOX EARS: Fluffy 3D wedge ears with orange coat, white fluff pad, and black tip cap
    public static void renderFoxEars(MatrixStack m, BufferBuilder buf, int color, float t) {
        float sway = (float)Math.sin(t * 2.5) * 0.02F;
        int furCol = 0xFFD8641C; // Vivid fox orange
        int padCol = 0xFFF5EFEB; // Cream white inner ear
        int tipCol = 0xFF1C1412; // Midnight black tip

        // Left Fox Ear
        m.push();
        m.translate(-0.21F + sway, 0.16F, -0.03F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(24.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-18.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-6.0F));
        draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.25F, 0.32F, 0.09F, furCol, padCol);
        // Black tip wedge cap
        m.translate(0.0F, 0.22F, 0.0F);
        draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.12F, 0.10F, 0.08F, tipCol, tipCol);
        m.pop();

        // Right Fox Ear
        m.push();
        m.translate(0.21F - sway, 0.16F, -0.03F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-24.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(18.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-6.0F));
        draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.25F, 0.32F, 0.09F, furCol, padCol);
        m.translate(0.0F, 0.22F, 0.0F);
        draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.12F, 0.10F, 0.08F, tipCol, tipCol);
        m.pop();
    }

    // 3. BUNNY EARS: Articulated 3D rounded prisms with bounce physics & inner groove
    public static void renderBunnyEars(MatrixStack m, BufferBuilder buf, int color, float t) {
        float bounce = (float)Math.sin(t * 3.5) * 0.035F;
        float bend = (float)Math.cos(t * 2.8) * 5.0F;
        int furCol = 0xFFF2EFEA; // Soft cream bunny fur
        int padCol = 0xFFFF9BB0; // Inset pink ear canal

        // Left Bunny Ear (2 3D segments)
        m.push();
        m.translate(-0.14F, 0.15F + bounce, -0.03F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(12.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-8.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-8.0F));
        // Lower stalk
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.055F, 0.0F, -0.035F, 0.055F, 0.22F, 0.035F, furCol);
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.035F, 0.02F, -0.040F, 0.035F, 0.20F, -0.030F, padCol);
        // Upper drooping ear segment
        m.translate(0.0F, 0.22F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(bend));
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.050F, 0.0F, -0.030F, 0.050F, 0.20F, 0.030F, furCol);
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.030F, 0.01F, -0.035F, 0.030F, 0.18F, -0.025F, padCol);
        m.pop();

        // Right Bunny Ear
        m.push();
        m.translate(0.14F, 0.15F + bounce, -0.03F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-12.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(8.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-8.0F));
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.055F, 0.0F, -0.035F, 0.055F, 0.22F, 0.035F, furCol);
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.035F, 0.02F, -0.040F, 0.035F, 0.20F, -0.030F, padCol);
        m.translate(0.0F, 0.22F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(bend));
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.050F, 0.0F, -0.030F, 0.050F, 0.20F, 0.030F, furCol);
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.030F, 0.01F, -0.035F, 0.030F, 0.18F, -0.025F, padCol);
        m.pop();
    }

    // 4. DEMON HORNS: 4-segmented 3D curved tapered horns sweeping outward and backward
    public static void renderDemonHorns(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int cBase = 0xFF140E18; // Obsidian black
        int cMid1 = 0xFF2A1224;
        int cMid2 = 0xFF581024;
        int cTip = 0xFFFF2A20;  // Glowing crimson/lava tip

        // Left Horn
        m.push();
        m.translate(-0.16F, 0.12F, -0.08F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(24.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-18.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(14.0F));
        Matrix4f matL = m.peek().getPositionMatrix();
        draw3DTaperedSegment(buf, matL, 0, 0, 0, 0.065F, -0.04F, 0.08F, -0.01F, 0.055F, cBase, cMid1);
        draw3DTaperedSegment(buf, matL, -0.04F, 0.08F, -0.01F, 0.055F, -0.09F, 0.16F, 0.02F, 0.045F, cMid1, cMid2);
        draw3DTaperedSegment(buf, matL, -0.09F, 0.16F, 0.02F, 0.045F, -0.13F, 0.24F, 0.07F, 0.030F, cMid2, cTip);
        draw3DTaperedSegment(buf, matL, -0.13F, 0.24F, 0.07F, 0.030F, -0.16F, 0.31F, 0.13F, 0.005F, cTip, cTip);
        m.pop();

        // Right Horn
        m.push();
        m.translate(0.16F, 0.12F, -0.08F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-24.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(18.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(14.0F));
        Matrix4f matR = m.peek().getPositionMatrix();
        draw3DTaperedSegment(buf, matR, 0, 0, 0, 0.065F, 0.04F, 0.08F, -0.01F, 0.055F, cBase, cMid1);
        draw3DTaperedSegment(buf, matR, 0.04F, 0.08F, -0.01F, 0.055F, 0.09F, 0.16F, 0.02F, 0.045F, cMid1, cMid2);
        draw3DTaperedSegment(buf, matR, 0.09F, 0.16F, 0.02F, 0.045F, 0.13F, 0.24F, 0.07F, 0.030F, cMid2, cTip);
        draw3DTaperedSegment(buf, matR, 0.13F, 0.24F, 0.07F, 0.030F, 0.16F, 0.31F, 0.13F, 0.005F, cTip, cTip);
        m.pop();
    }

    // 5. ROYAL CROWN: Imperial 3D octagonal gold band + 8 3D spires with embedded jewels
    public static void renderRoyalCrown(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        float bob = (float)Math.sin(t * 2.2) * 0.025F;
        int gold = 0xFFFFD700;
        int ruby = 0xFFFF2040;
        int emerald = 0xFF20E060;

        m.push();
        m.translate(0.0F, 0.20F + bob, 0.0F);
        Matrix4f mat = m.peek().getPositionMatrix();

        // 3D Octagonal Gold Band (outer radius 0.28, inner radius 0.24, height 0.06)
        draw3DRing(buf, mat, 0, 0, 0, 0.28F, 0.24F, 0.06F, 8, gold);

        // 8 Upright 3D Golden Spires crowned with 3D Gemstones
        for (int i = 0; i < 8; i++) {
            double a = (Math.PI * 2.0 * i) / 8;
            float cx = (float)Math.cos(a) * 0.26F;
            float cz = (float)Math.sin(a) * 0.26F;
            boolean major = (i % 2 == 0);
            float h = major ? 0.14F : 0.09F;
            int gem = major ? ruby : emerald;

            m.push();
            m.translate(cx, 0.06F, cz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) + 90.0F));
            draw3DEarWedge(buf, m.peek().getPositionMatrix(), major ? 0.08F : 0.06F, h, 0.035F, gold, gold);
            // 3D Gemstone at spire peak
            draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, h + 0.02F, 0.0F, 0.025F, 0.032F, 0.025F, gem);
            m.pop();
        }
        m.pop();
    }

    // 6. TOP HAT: Victorian silk cylinder top hat with 3D brim, crown, and silk ribbon
    public static void renderTopHat(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int felt = 0xFF222428; // Deep charcoal silk felt
        int ribbon = accCol;
        int buckle = 0xFFFFD700;

        m.push();
        m.translate(0.0F, 0.16F, -0.02F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(5.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-8.0F));
        Matrix4f mat = m.peek().getPositionMatrix();

        // 3D Flat Brim
        draw3DCylinder(buf, mat, 0, 0, 0, 0.36F, 0.025F, 12, felt);
        // 3D Tall Crown
        draw3DCylinder(buf, mat, 0, 0.025F, 0, 0.23F, 0.28F, 12, felt);
        // 3D Silk Ribbon Band
        draw3DRing(buf, mat, 0, 0.026F, 0, 0.238F, 0.228F, 0.06F, 12, ribbon);
        // 3D Gold Buckle Box on front of ribbon
        draw3DBox(buf, mat, -0.03F, 0.035F, -0.245F, 0.03F, 0.075F, -0.235F, buckle);
        m.pop();
    }

    // 7. CYBER VISOR: 3-panel angular 3D visor wrap with temporal ear mounts & animated scanline
    public static void renderCyberVisor(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int glass = 0xEE102838;
        int frame = 0xFF181C24;
        int scan = 0xFF00FFEA;

        m.push();
        m.translate(0.0F, 0.0F, -0.02F);
        Matrix4f mat = m.peek().getPositionMatrix();

        // Center 3D Glass Faceplate over eyes
        draw3DBox(buf, mat, -0.16F, -0.05F, -0.28F, 0.16F, 0.05F, -0.255F, glass);

        // Left Temple Wing
        m.push();
        m.translate(-0.16F, 0.0F, -0.265F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(42.0F));
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.14F, -0.045F, -0.01F, 0.0F, 0.045F, 0.01F, frame);
        // Ear clamp
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.16F, -0.055F, -0.02F, -0.12F, 0.055F, 0.02F, accCol);
        m.pop();

        // Right Temple Wing
        m.push();
        m.translate(0.16F, 0.0F, -0.265F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-42.0F));
        draw3DBox(buf, m.peek().getPositionMatrix(), 0.0F, -0.045F, -0.01F, 0.14F, 0.045F, 0.01F, frame);
        draw3DBox(buf, m.peek().getPositionMatrix(), 0.12F, -0.055F, -0.02F, 0.16F, 0.055F, 0.02F, accCol);
        m.pop();

        // Animated 3D Holographic HUD Laser Beam
        float scanX = (float)Math.sin(t * 4.0) * 0.12F;
        draw3DBox(buf, mat, scanX - 0.02F, -0.04F, -0.285F, scanX + 0.02F, 0.04F, -0.278F, scan);
        m.pop();
    }

    // 8. VALKYRIE WINGS: Layered 3D feather winglets with thickness & golden temple brackets
    public static void renderValkyrieWings(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        float flap = (float)Math.sin(t * 4.5) * 12.0F;
        int gold = 0xFFFFD700;
        int feather = 0xFFF5F8FA;

        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.26F, 0.08F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(side * (18.0F + flap)));
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-side * 22.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // Golden temple mount block
            draw3DBox(buf, mat, -0.03F, -0.03F, -0.03F, 0.03F, 0.03F, 0.03F, gold);

            // 3 Stepped 3D Feather Blades
            draw3DEarWedge(buf, mat, 0.10F, 0.32F, 0.045F, feather, gold);
            m.push();
            m.translate(side * 0.04F, 0.02F, -0.02F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(side * 15.0F));
            draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.08F, 0.24F, 0.035F, feather, gold);
            m.pop();

            m.push();
            m.translate(side * 0.07F, 0.04F, -0.04F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(side * 28.0F));
            draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.07F, 0.18F, 0.030F, feather, gold);
            m.pop();

            m.pop();
        }
    }

    // 9. HEADPHONES: Arched 3D headband + dual cylindrical earcups + RGB LED + mic boom
    public static void renderHeadphones(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int plastic = 0xFF202226;
        int cushion = 0xFF141416;
        int led = accCol;

        Matrix4f mat = m.peek().getPositionMatrix();

        // 3D Arched Headband (6 connected curved rectangular segments)
        int segs = 6;
        for (int i = 0; i < segs; i++) {
            double a1 = Math.PI * (0.15 + (0.70 * i) / segs);
            double a2 = Math.PI * (0.15 + (0.70 * (i + 1)) / segs);
            float x1 = (float)Math.cos(a1) * 0.28F, y1 = 0.06F + (float)Math.sin(a1) * 0.22F;
            float x2 = (float)Math.cos(a2) * 0.28F, y2 = 0.06F + (float)Math.sin(a2) * 0.22F;
            draw3DBox(buf, mat, Math.min(x1, x2) - 0.015F, Math.min(y1, y2) - 0.015F, -0.035F,
                                Math.max(x1, x2) + 0.015F, Math.max(y1, y2) + 0.015F, 0.035F, plastic);
        }

        // Left & Right 3D Cylindrical Earcups with Leather Cushions
        for (int side = -1; side <= 1; side += 2) {
            float cx = side * 0.28F;
            // Cushion
            draw3DBox(buf, mat, cx - 0.03F, -0.08F, -0.08F, cx + 0.03F, 0.08F, 0.08F, cushion);
            // Outer cup housing
            draw3DBox(buf, mat, cx + side * 0.03F, -0.09F, -0.09F, cx + side * 0.07F, 0.09F, 0.09F, plastic);
            // RGB LED ring
            draw3DBox(buf, mat, cx + side * 0.071F, -0.05F, -0.05F, cx + side * 0.076F, 0.05F, 0.05F, led);
        }

        // 3D Microphone Boom from Left Earcup toward Mouth
        draw3DBox(buf, mat, -0.28F, -0.08F, -0.14F, -0.26F, -0.06F, 0.0F, plastic);
        draw3DBox(buf, mat, -0.26F, -0.11F, -0.22F, -0.14F, -0.07F, -0.18F, plastic);
        // Foam windscreen mic tip
        draw3DBox(buf, mat, -0.14F, -0.12F, -0.25F, -0.08F, -0.06F, -0.19F, cushion);
    }

    // 10. TACTICAL MASK: 3D angular respirator faceplate + dual cheek filters + exhaust vent
    public static void renderTacticalMask(MatrixStack m, BufferBuilder buf, int mainCol, int accCol) {
        int armor = 0xFF1C2026;
        int filter = 0xFF353C48;
        int vent = 0xFF121418;

        Matrix4f mat = m.peek().getPositionMatrix();

        // Central 3D Angular Respirator Faceplate over Mouth & Nose
        draw3DBox(buf, mat, -0.14F, -0.16F, -0.32F, 0.14F, 0.02F, -0.26F, armor);

        // Dual 3D Filtration Canisters on Cheeks
        draw3DCylinder(buf, mat, -0.16F, -0.11F, -0.26F, 0.055F, 0.06F, 8, filter);
        draw3DCylinder(buf, mat, 0.16F, -0.11F, -0.26F, 0.055F, 0.06F, 8, filter);

        // Center 3D Exhaust Valve
        draw3DCylinder(buf, mat, 0.0F, -0.15F, -0.33F, 0.045F, 0.03F, 8, vent);

        // Cheek Fastening Straps
        draw3DBox(buf, mat, -0.26F, -0.08F, -0.24F, -0.14F, -0.05F, -0.22F, vent);
        draw3DBox(buf, mat, 0.14F, -0.08F, -0.24F, 0.26F, -0.05F, -0.22F, vent);
    }

    // 11. DEVIL TAIL: Articulated 3D vertebrae spine with waving physics & barbed 3D spade tip
    public static void renderDevilTail(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int spineCol = 0xFF8A141C;
        int tipCol = 0xFFFF2030;
        int segs = 7;

        Matrix4f mat = m.peek().getPositionMatrix();
        float prevX = 0.0F, prevY = -0.30F, prevZ = 0.18F;
        float prevR = 0.045F;

        for (int i = 1; i <= segs; i++) {
            float frac = (float)i / segs;
            float swish = (float)Math.sin(t * 3.5F + frac * 2.8F) * (0.04F + frac * 0.22F);
            float curX = swish;
            float curY = -0.30F - frac * 0.38F + (float)Math.cos(t * 2.2F + frac) * 0.05F;
            float curZ = 0.18F + frac * 0.28F;
            float curR = prevR * 0.88F;

            draw3DTaperedSegment(buf, mat, prevX, prevY, prevZ, prevR, curX, curY, curZ, curR, spineCol, spineCol);
            prevX = curX; prevY = curY; prevZ = curZ; prevR = curR;
        }

        // 3D Barbed Devil Spade Arrowhead Tip
        m.push();
        m.translate(prevX, prevY, prevZ);
        draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.07F, 0.09F, 0.05F, tipCol);
        m.pop();
    }

    // 12. FLOATING SWORDS: 3 massive 3D spectral blades with hilt, crossguard, and diamond blade
    public static void renderFloatingSwords(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int blade = 0xFFE0F4FF;
        int guard = 0xFFFFD700;
        int hilt = 0xFF181A20;
        int swords = 3;

        for (int i = 0; i < swords; i++) {
            double a = (Math.PI * 2.0 * i / swords) + t * 1.5;
            float sx = (float)Math.cos(a) * 0.52F;
            float sz = (float)Math.sin(a) * 0.52F;
            float sy = 0.08F + (float)Math.sin(t * 2.8 + i * 2.0) * 0.08F;

            m.push();
            m.translate(sx, sy, sz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) + 90.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(15.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // 3D Pommel
            draw3DOctahedron(buf, mat, 0, 0.24F, 0, 0.025F, 0.025F, 0.025F, guard);
            // 3D Hilt
            draw3DCylinder(buf, mat, 0, 0.16F, 0, 0.015F, 0.08F, 6, hilt);
            // 3D Crossguard
            draw3DBox(buf, mat, -0.09F, 0.14F, -0.018F, 0.09F, 0.16F, 0.018F, guard);
            // 3D Diamond Blade (double-edged with fuller)
            draw3DBox(buf, mat, -0.035F, -0.28F, -0.010F, 0.035F, 0.14F, 0.010F, blade);
            // 3D Tapered Blade Tip
            draw3DTaperedSegment(buf, mat, 0, -0.28F, 0, 0.035F, 0, -0.38F, 0, 0.002F, blade, blade);
            m.pop();
        }
    }

    // 13. WIZARD HAT: 3D wide octagonal floppy brim + 3D conical trunk bending backward
    public static void renderWizardHat(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int felt = 0xFF1C1438; // Arcane midnight purple
        int ribbon = 0xFFFFD700;

        m.push();
        m.translate(0.0F, 0.16F, -0.02F);
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-6.0F));
        Matrix4f mat = m.peek().getPositionMatrix();

        // 3D Wide Floppy Brim
        draw3DCylinder(buf, mat, 0, 0, 0, 0.44F, 0.03F, 12, felt);
        // 3D Conical Trunk Section 1
        draw3DTaperedSegment(buf, mat, 0, 0.03F, 0, 0.24F, 0, 0.18F, 0.02F, 0.17F, felt, felt);
        // 3D Leather Ribbon
        draw3DRing(buf, mat, 0, 0.031F, 0, 0.245F, 0.235F, 0.05F, 12, ribbon);
        // 3D Conical Trunk Section 2 (bending back)
        draw3DTaperedSegment(buf, mat, 0, 0.18F, 0.02F, 0.17F, 0, 0.32F, 0.08F, 0.09F, felt, felt);
        // 3D Conical Trunk Section 3 (floppy tip)
        draw3DTaperedSegment(buf, mat, 0, 0.32F, 0.08F, 0.09F, 0, 0.38F, 0.18F, 0.01F, felt, felt);
        m.pop();
    }

    // 14. BUTTERFLY: Full 3D animated companion butterfly fluttering around shoulder
    public static void renderButterfly(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        float flutter = (float)Math.sin(t * 14.0) * 35.0F;
        int body = 0xFF1A141A;
        int wingTop = 0xFFFF4090;
        int wingBot = 0xFF50D0FF;

        m.push();
        m.translate(0.35F, 0.28F + (float)Math.sin(t * 3.0) * 0.05F, -0.15F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 45.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // 3D Thorax & Abdomen
        draw3DBox(buf, mat, -0.015F, -0.015F, -0.06F, 0.015F, 0.015F, 0.06F, body);

        // Left Wings
        m.push();
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-flutter));
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.18F, 0.0F, -0.05F, 0.0F, 0.005F, 0.05F, wingTop);
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.14F, 0.0F, 0.04F, 0.0F, 0.005F, 0.11F, wingBot);
        m.pop();

        // Right Wings
        m.push();
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(flutter));
        draw3DBox(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, -0.05F, 0.18F, 0.005F, 0.05F, wingTop);
        draw3DBox(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.04F, 0.14F, 0.005F, 0.11F, wingBot);
        m.pop();
        m.pop();
    }

    // 15. FLOWER WREATH: 3D leafy green vine ring + 8 distinct 3D blooming flowers
    public static void renderFlowerWreath(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int vine = 0xFF2A7832;
        int flower1 = 0xFFFF6895;
        int flower2 = 0xFFFFDF40;

        m.push();
        m.translate(0.0F, 0.18F, 0.0F);
        Matrix4f mat = m.peek().getPositionMatrix();

        // 3D Vine Ring around head
        draw3DRing(buf, mat, 0, 0, 0, 0.28F, 0.25F, 0.04F, 12, vine);

        // 8 3D Blooming Flowers
        for (int i = 0; i < 8; i++) {
            double a = (Math.PI * 2.0 * i) / 8;
            float fx = (float)Math.cos(a) * 0.27F;
            float fz = (float)Math.sin(a) * 0.27F;
            int petCol = (i % 2 == 0) ? flower1 : flower2;

            m.push();
            m.translate(fx, 0.02F, fz);
            // 3D Pollen Center
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.02F, -0.02F, -0.02F, 0.02F, 0.02F, 0.02F, 0xFFFFE030);
            // 4 Radial 3D Petals
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.05F, -0.015F, -0.015F, 0.05F, 0.015F, 0.015F, petCol);
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.015F, -0.015F, -0.05F, 0.015F, 0.015F, 0.05F, petCol);
            m.pop();
        }
        m.pop();
    }

    // 16. SHURIKENS: 4 spinning textured ninja stars orbiting rapidly
    public static void renderShurikens(MatrixStack m, BufferBuilder buf, int color, float t) {
        int stars = 4;
        float spin = t * 750.0F;

        for (int i = 0; i < stars; i++) {
            double a = (Math.PI * 2.0 * i / stars) + t * 2.2;
            float sx = (float)Math.cos(a) * 0.48F;
            float sz = (float)Math.sin(a) * 0.48F;
            float sy = 0.08F + (float)Math.sin(t * 3.2 + i * 1.5) * 0.06F;

            m.push();
            m.translate(sx, sy, sz);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(spin));
            drawCrossVolumeTex(buf, m, 0.0F, 0.0F, 0.0F, 0.28F, 0.28F, color);
            m.pop();
        }
    }

    public static void drawCrossVolumeTex(BufferBuilder buf, MatrixStack m, float cx, float cy, float cz, float w, float h, int color) {
        Matrix4f mat = m.peek().getPositionMatrix();
        float hw = w * 0.5F;
        float hh = h * 0.5F;
        // Quad 1: XY plane
        buf.vertex(mat, cx - hw, cy - hh, cz).texture(0.0F, 1.0F).color(color);
        buf.vertex(mat, cx + hw, cy - hh, cz).texture(1.0F, 1.0F).color(color);
        buf.vertex(mat, cx + hw, cy + hh, cz).texture(1.0F, 0.0F).color(color);
        buf.vertex(mat, cx - hw, cy + hh, cz).texture(0.0F, 0.0F).color(color);

        // Quad 2: ZY plane
        buf.vertex(mat, cx, cy - hh, cz - hw).texture(0.0F, 1.0F).color(color);
        buf.vertex(mat, cx, cy - hh, cz + hw).texture(1.0F, 1.0F).color(color);
        buf.vertex(mat, cx, cy + hh, cz + hw).texture(1.0F, 0.0F).color(color);
        buf.vertex(mat, cx, cy + hh, cz - hw).texture(0.0F, 0.0F).color(color);
    }

    // 17. FLOATING CRYSTALS: 6 pure 3D faceted Octahedron gemstones orbiting in fluid physics!
    public static void renderFloatingCrystals(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int count = 6;
        for (int i = 0; i < count; i++) {
            double a = (Math.PI * 2.0 * i / count) + t * 1.4;
            float cx = (float)Math.cos(a) * 0.45F;
            float cz = (float)Math.sin(a) * 0.45F;
            float cy = 0.08F + (float)Math.sin(t * 3.0 + i * 1.05) * 0.08F;

            m.push();
            m.translate(cx, cy, cz);
            // Smooth 3D tumbling rotation
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 120.0F + i * 60.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0F));

            int col = (i % 2 == 0) ? mainCol : accCol;
            // True 8-faceted 3D Octahedron Gemstone!
            draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.065F, 0.13F, 0.065F, col);
            m.pop();
        }
    }

    // 18. NINJA BANDANA: 3D fabric forehead band + metallic crest plate + waving ribbons
    public static void renderNinjaBandana(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int fabric = 0xFF1C2028;
        int metal = 0xFFD8E2EC;

        Matrix4f mat = m.peek().getPositionMatrix();

        // 3D Forehead Fabric Band
        draw3DBox(buf, mat, -0.22F, 0.02F, -0.28F, 0.22F, 0.09F, -0.25F, fabric);
        // 3D Metallic Leaf Protector Plate
        draw3DBox(buf, mat, -0.10F, 0.03F, -0.292F, 0.10F, 0.08F, -0.278F, metal);

        // Dual Waving 3D Trailing Cloth Ribbons (+Z behind skull)
        float wave1 = (float)Math.sin(t * 5.0) * 0.04F;
        float wave2 = (float)Math.cos(t * 4.2) * 0.04F;

        m.push();
        m.translate(-0.04F, 0.05F, 0.26F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(wave1 * 60.0F));
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.04F, -0.28F, -0.01F, 0.04F, 0.0F, 0.01F, fabric);
        m.pop();

        m.push();
        m.translate(0.04F, 0.05F, 0.26F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(wave2 * 60.0F));
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.04F, -0.32F, -0.01F, 0.04F, 0.0F, 0.01F, fabric);
        m.pop();
    }

    // 19. HOLY RELIC: 3D solar halo ring + 3D radiant cross + 3 revolving orbital gemstones
    public static void renderHolyRelic(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        float bob = (float)Math.sin(t * 2.2) * 0.03F;
        int gold = 0xFFFFD700;
        int holy = 0xFFFFF8E0;

        m.push();
        m.translate(0.0F, 0.28F + bob, 0.0F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 35.0F));
        Matrix4f mat = m.peek().getPositionMatrix();

        // 3D Solar Halo Ring
        draw3DRing(buf, mat, 0, 0, 0, 0.32F, 0.28F, 0.035F, 16, gold);

        // Center 3D Radiant Cross
        draw3DBox(buf, mat, -0.03F, -0.16F, -0.02F, 0.03F, 0.16F, 0.02F, holy);
        draw3DBox(buf, mat, -0.12F, -0.02F, -0.02F, 0.12F, 0.04F, 0.02F, holy);

        // 3 Floating 3D Satellite Gemstones revolving in orbit
        for (int i = 0; i < 3; i++) {
            double a = (Math.PI * 2.0 * i / 3) + t * 2.5;
            float gx = (float)Math.cos(a) * 0.40F;
            float gz = (float)Math.sin(a) * 0.40F;
            draw3DOctahedron(buf, mat, gx, 0.0F, gz, 0.035F, 0.045F, 0.035F, accCol);
        }
        m.pop();
    }

    // 20. DROID PET: 3D robotic companion with chassis, glowing optic lens, and thrusters
    public static void renderDroidPet(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        float hoverY = (float)Math.sin(t * 3.0) * 0.06F;
        int armor = 0xFFE8EEF5;
        int dark = 0xFF22262E;
        int eye = 0xFF00FFEA;

        m.push();
        m.translate(0.42F, 0.22F + hoverY, 0.15F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 25.0F));

        Matrix4f mat = m.peek().getPositionMatrix();

        // 3D Drone Body (Octagonal Drum Chassis)
        draw3DCylinder(buf, mat, 0, -0.08F, 0, 0.12F, 0.16F, 8, armor);

        // 3D Glowing Optic Eye
        draw3DOctahedron(buf, mat, 0, 0.0F, -0.125F, 0.04F, 0.04F, 0.04F, eye);

        // Dual 3D Propulsion Thrusters
        draw3DCylinder(buf, mat, -0.14F, -0.06F, 0, 0.035F, 0.10F, 6, dark);
        draw3DCylinder(buf, mat, 0.14F, -0.06F, 0, 0.035F, 0.10F, 6, dark);

        // Dual 3D Sensor Antennae
        draw3DBox(buf, mat, -0.05F, 0.08F, 0, -0.04F, 0.18F, 0.01F, dark);
        draw3DBox(buf, mat, 0.04F, 0.08F, 0, 0.05F, 0.18F, 0.01F, dark);
        m.pop();
    }

    // ==========================================
    // 10 BRAND NEW 3D VOLUMETRIC ACCESSORIES
    // ==========================================

    // 21. SUSANOO RIBS: Ethereal chakra ribs wrapping around torso with spinal vertebrae
    public static void renderSusanooRibs(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int ribCount = 4;
        float breath = (float)Math.sin(t * 3.0) * 0.015F;
        int ribCol = shade(mainCol, 1.15F);
        int spineCol = shade(accCol, 0.9F);

        // Central Spine column
        for (int i = 0; i < 5; i++) {
            float sy = -0.30F + i * 0.12F;
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.04F, sy - 0.04F, 0.20F, 0.04F, sy + 0.04F, 0.28F, spineCol);
        }

        // Rib pairs arching forward
        for (int i = 0; i < ribCount; i++) {
            float ry = -0.22F + i * 0.11F;
            float span = 0.26F + breath + (i == 1 || i == 2 ? 0.04F : 0.0F);

            // Left Rib (3 segments curving around +X)
            m.push();
            m.translate(0.0F, ry, 0.24F);
            draw3DBox(buf, m.peek().getPositionMatrix(), 0.04F, -0.02F, -0.02F, span, 0.02F, 0.02F, ribCol);
            m.translate(span, 0.0F, 0.0F);
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.02F, -0.02F, -0.32F, 0.02F, 0.02F, 0.02F, ribCol);
            m.translate(0.0F, 0.0F, -0.32F);
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.12F, -0.018F, -0.02F, 0.02F, 0.018F, 0.02F, ribCol);
            m.pop();

            // Right Rib (3 segments curving around -X)
            m.push();
            m.translate(0.0F, ry, 0.24F);
            draw3DBox(buf, m.peek().getPositionMatrix(), -span, -0.02F, -0.02F, -0.04F, 0.02F, 0.02F, ribCol);
            m.translate(-span, 0.0F, 0.0F);
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.02F, -0.02F, -0.32F, 0.02F, 0.02F, 0.02F, ribCol);
            m.translate(0.0F, 0.0F, -0.32F);
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.02F, -0.018F, -0.02F, 0.12F, 0.018F, 0.02F, ribCol);
            m.pop();
        }
    }

    // 22. DRAGON HORNS: Segmented curved draconic horns sweeping back from forehead
    public static void renderDragonHorns(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int hornBase = shade(mainCol, 0.85F);
        int hornTip = shade(accCol, 1.25F);

        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.22F, 0.14F, -0.15F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-side * 25.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-20.0F));

            // Segment 1 (Base)
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.045F, 0.0F, -0.045F, 0.045F, 0.12F, 0.045F, hornBase);
            m.translate(0.0F, 0.11F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-25.0F));
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(side * 10.0F));

            // Segment 2 (Mid)
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.035F, 0.0F, -0.035F, 0.035F, 0.12F, 0.035F, hornBase);
            m.translate(0.0F, 0.11F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-35.0F));

            // Segment 3 (Upper)
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.025F, 0.0F, -0.025F, 0.025F, 0.10F, 0.025F, hornTip);
            m.translate(0.0F, 0.09F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-30.0F));

            // Segment 4 (Sharp Tip)
            draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.04F, 0.12F, 0.02F, hornTip, hornTip);
            m.pop();
        }
    }

    // 23. SAMURAI KASA: Traditional Japanese ronin conical straw hat with rim
    public static void renderSamuraiKasa(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int straw = 0xFFD8BC88;
        int darkStraw = 0xFF9E8457;
        int cord = accCol;

        m.push();
        m.translate(0.0F, 0.22F, 0.0F);

        int sides = 12;
        float rRim = 0.58F;
        float rPeak = 0.04F;
        float hPeak = 0.18F;

        Matrix4f mat = m.peek().getPositionMatrix();
        for (int i = 0; i < sides; i++) {
            double a1 = (Math.PI * 2.0 * i) / sides;
            double a2 = (Math.PI * 2.0 * (i + 1)) / sides;
            float x1 = (float)Math.cos(a1) * rRim, z1 = (float)Math.sin(a1) * rRim;
            float x2 = (float)Math.cos(a2) * rRim, z2 = (float)Math.sin(a2) * rRim;
            float px1 = (float)Math.cos(a1) * rPeak, pz1 = (float)Math.sin(a1) * rPeak;
            float px2 = (float)Math.cos(a2) * rPeak, pz2 = (float)Math.sin(a2) * rPeak;

            int c = (i % 2 == 0) ? straw : darkStraw;
            drawQuad(buf, mat, x1, 0.0F, z1, x2, 0.0F, z2, px2, hPeak, pz2, px1, hPeak, pz1, c);
        }

        // Top Knot Knob
        draw3DBox(buf, mat, -0.045F, hPeak, -0.045F, 0.045F, hPeak + 0.06F, 0.045F, cord);
        // Outer Rim Ring
        draw3DBox(buf, mat, -0.60F, -0.015F, -0.015F, 0.60F, 0.015F, 0.015F, darkStraw);
        draw3DBox(buf, mat, -0.015F, -0.015F, -0.60F, 0.015F, 0.015F, 0.60F, darkStraw);
        m.pop();
    }

    // 24. CYBER BLADES: Floating mechanical energy blade pods hovering at sides
    public static void renderCyberBlades(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int chassis = 0xFF22262E;
        int neon = mainCol;
        float bob = (float)Math.sin(t * 3.5F) * 0.03F;

        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.44F, 0.10F + bob, 0.05F);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(side * 15.0F));
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-side * 18.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // Mechanical mounting bracket
            draw3DBox(buf, mat, -0.04F, -0.05F, -0.05F, 0.04F, 0.05F, 0.05F, chassis);
            // Energy blade 1 (Upper forward)
            m.push();
            m.translate(0.0F, 0.06F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0F));
            draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.06F, 0.32F, 0.018F, neon, accCol);
            m.pop();
            // Energy blade 2 (Lower swept back)
            m.push();
            m.translate(0.0F, -0.06F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-45.0F));
            draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.05F, 0.26F, 0.016F, neon, accCol);
            m.pop();

            m.pop();
        }
    }

    // 25. PHOENIX AURA: Swirling flame ribbons and floating plumage prisms around torso
    public static void renderPhoenixAura(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int flames = 6;
        for (int i = 0; i < flames; i++) {
            double a = (Math.PI * 2.0 * i / flames) + t * 2.5;
            float r = 0.40F + (float)Math.sin(t * 4.0 + i) * 0.06F;
            float fx = (float)Math.cos(a) * r;
            float fz = (float)Math.sin(a) * r;
            float fy = -0.15F + (float)Math.sin(t * 3.0 + i * 1.2) * 0.15F;

            m.push();
            m.translate(fx, fy, fz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) + 90.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(35.0F));

            int col = (i % 2 == 0) ? mainCol : accCol;
            draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.04F, 0.16F, 0.04F, col);
            m.pop();
        }
    }

    // 26. PORTAL RING: Stargate void portal floating behind back with rotating glyphs
    public static void renderPortalRing(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int chassis = 0xFF1E222A;
        m.push();
        m.translate(0.0F, 0.05F, 0.36F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(t * 30.0F));

        int segs = 12;
        float r = 0.46F;
        Matrix4f mat = m.peek().getPositionMatrix();
        for (int i = 0; i < segs; i++) {
            double a = (Math.PI * 2.0 * i) / segs;
            float sx = (float)Math.cos(a) * r;
            float sy = (float)Math.sin(a) * r;
            m.push();
            m.translate(sx, sy, 0.0F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.toDegrees(a)));
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.06F, -0.02F, -0.02F, 0.06F, 0.02F, 0.02F, chassis);
            if (i % 3 == 0) {
                draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.025F, 0.05F, 0.025F, accCol);
            }
            m.pop();
        }
        // Inner portal vortex core
        draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.12F, 0.12F, 0.03F, mainCol);
        m.pop();
    }

    // 27. GHOST PET: Cute floating spirit companion bobbing gently over shoulder
    public static void renderGhostPet(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        float gx = 0.44F;
        float gy = 0.32F + (float)Math.sin(t * 3.0) * 0.06F;
        float gz = 0.18F + (float)Math.cos(t * 2.2) * 0.05F;

        int ghostWhite = 0xFFEFF6FF;
        int ghostEye = 0xFF1A1C24;
        int ghostGlow = mainCol;

        m.push();
        m.translate(gx, gy, gz);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.sin(t * 2.5) * 15.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Head / Body
        draw3DBox(buf, mat, -0.07F, -0.06F, -0.07F, 0.07F, 0.08F, 0.07F, ghostWhite);
        // Cute dark eyes
        draw3DBox(buf, mat, -0.05F, 0.01F, -0.075F, -0.02F, 0.04F, -0.07F, ghostEye);
        draw3DBox(buf, mat, 0.02F, 0.01F, -0.075F, 0.05F, 0.04F, -0.07F, ghostEye);
        // Tiny arms
        draw3DBox(buf, mat, -0.095F, -0.02F, -0.03F, -0.07F, 0.01F, 0.03F, ghostWhite);
        draw3DBox(buf, mat, 0.07F, -0.02F, -0.03F, 0.095F, 0.01F, 0.03F, ghostWhite);
        // Undulating wavy tail
        float tailWag = (float)Math.sin(t * 5.0) * 0.03F;
        draw3DBox(buf, mat, -0.04F + tailWag, -0.12F, -0.04F, 0.04F + tailWag, -0.06F, 0.04F, ghostGlow);
        m.pop();
    }

    // 28. KITSUNE MASK: Traditional painted fox mask resting tilted on side of head
    public static void renderKitsuneMask(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int maskWhite = 0xFFF8F9FA;
        int redPaint = 0xFFD62828;
        int blackPaint = 0xFF141414;

        m.push();
        m.translate(0.24F, 0.16F, -0.16F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(42.0F));
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-15.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Mask face plate
        draw3DBox(buf, mat, -0.09F, -0.11F, -0.02F, 0.09F, 0.08F, 0.02F, maskWhite);
        // Fox Snout
        draw3DBox(buf, mat, -0.035F, -0.08F, -0.06F, 0.035F, -0.02F, -0.02F, maskWhite);
        draw3DBox(buf, mat, -0.015F, -0.03F, -0.065F, 0.015F, -0.015F, -0.055F, blackPaint);
        // Eye slits
        draw3DBox(buf, mat, -0.07F, 0.0F, -0.025F, -0.025F, 0.02F, -0.015F, redPaint);
        draw3DBox(buf, mat, 0.025F, 0.0F, -0.025F, 0.07F, 0.02F, -0.015F, redPaint);
        // Fox Ears
        m.push();
        m.translate(-0.06F, 0.08F, 0.0F);
        draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.04F, 0.09F, 0.02F, maskWhite, redPaint);
        m.pop();
        m.push();
        m.translate(0.06F, 0.08F, 0.0F);
        draw3DEarWedge(buf, m.peek().getPositionMatrix(), 0.04F, 0.09F, 0.02F, maskWhite, redPaint);
        m.pop();
        // Hanging red tassel
        draw3DBox(buf, mat, -0.095F, -0.20F, 0.0F, -0.085F, -0.08F, 0.01F, redPaint);
        m.pop();
    }

    // 29. GLITCH CROWN: Floating segmented holographic cyber-crown with digital jitter
    public static void renderGlitchCrown(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int spires = 5;
        float r = 0.28F;
        int neon1 = mainCol;
        int neon2 = accCol;

        m.push();
        m.translate(0.0F, 0.26F, 0.0F);

        for (int i = 0; i < spires; i++) {
            double a = (Math.PI * 2.0 * i / spires) + t * 0.4;
            float jitter = ((float)Math.sin(t * 20.0F + i * 3.0F)) * 0.015F;
            float h = (i % 2 == 0) ? 0.22F : 0.14F;
            float sx = (float)Math.cos(a) * (r + jitter);
            float sz = (float)Math.sin(a) * (r + jitter);

            m.push();
            m.translate(sx, 0.0F, sz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) + 90.0F));
            int col = (i % 2 == 0) ? neon1 : neon2;
            draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, h * 0.5F, 0.0F, 0.035F, h, 0.02F, col);
            m.pop();
        }
        m.pop();
    }

    // 30. ASTRAL ORBS: 5 celestial glowing orbs revolving on inclined gyroscope orbit
    public static void renderAstralOrbs(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int count = 5;
        m.push();
        m.translate(0.0F, 0.10F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0F));
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.sin(t) * 15.0F));

        for (int i = 0; i < count; i++) {
            double a = (Math.PI * 2.0 * i / count) + t * 1.8;
            float r = 0.46F;
            float ox = (float)Math.cos(a) * r;
            float oz = (float)Math.sin(a) * r;
            float oy = (float)Math.sin(t * 3.0 + i) * 0.06F;

            m.push();
            m.translate(ox, oy, oz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 120.0F));
            int col = (i % 2 == 0) ? mainCol : accCol;
            draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.045F, 0.09F, 0.045F, col);
            // Miniature orbital ring
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.07F, -0.005F, -0.07F, 0.07F, 0.005F, 0.07F, shade(col, 1.2F));
            m.pop();
        }
        m.pop();
    }

    // =========================================================================
    // 20 BRAND-NEW ACCESSORY RENDER IMPLEMENTATIONS (31 TO 50)
    // =========================================================================

    // 31. DEMON WINGS & TAIL: Spiked bat wing frame and articulated spade tail
    public static void renderDemonWingsTail(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int boneCol = 0xFF221118;
        int membCol = mainCol;
        int bloodCol = accCol;

        // Folded Spiked Bat Wings on back
        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.16F, 0.08F, 0.14F);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(side * -25.0F));
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(side * 18.0F + (float)Math.sin(t * 2.0) * 4.0F));
            Matrix4f mat = m.peek().getPositionMatrix();
            // Wing main strut
            draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.0F, 0.025F, side * 0.28F, 0.22F, 0.04F, 0.015F, boneCol, boneCol);
            // Wing membrane facet
            drawQuad(buf, mat, 0.0F, 0.0F, 0.0F, side * 0.28F, 0.22F, 0.04F, side * 0.32F, -0.06F, 0.02F, 0.0F, -0.08F, 0.0F, membCol);
            // Spiked claw tip
            draw3DOctahedron(buf, mat, side * 0.28F, 0.22F, 0.04F, 0.02F, 0.04F, 0.02F, bloodCol);
            m.pop();
        }

        // Spiked Devil Tail
        m.push();
        m.translate(0.0F, -0.32F, 0.14F);
        int tailSegs = 7;
        float prevX = 0.0F, prevY = 0.0F, prevZ = 0.0F;
        for (int i = 0; i < tailSegs; i++) {
            float frac = (float) i / tailSegs;
            float sway = (float) Math.sin(t * 3.5 + i * 0.6) * (0.04F + frac * 0.08F);
            float curX = sway;
            float curY = prevY - 0.06F;
            float curZ = prevZ + 0.05F + frac * 0.04F;
            draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), prevX, prevY, prevZ, 0.025F * (1.0F - frac * 0.5F), curX, curY, curZ, 0.020F * (1.0F - frac * 0.5F), boneCol, membCol);
            prevX = curX; prevY = curY; prevZ = curZ;
        }
        // Spade arrowhead tip
        m.translate(prevX, prevY, prevZ);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.sin(t * 4.0) * 15.0F));
        draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, -0.03F, 0.02F, 0.045F, 0.07F, 0.015F, bloodCol);
        m.pop();
    }

    // 32. CROWN OF THORNS: Intertwined bramble vine circlet with blood ruby sparks
    public static void renderCrownOfThorns(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int thornWood = 0xFF2D1E18;
        int rubyGlow = accCol;
        int count = 16;
        float r = 0.24F;

        m.push();
        m.translate(0.0F, 0.08F, 0.0F);
        Matrix4f mat = m.peek().getPositionMatrix();

        // Dual intertwined vine rings
        for (int i = 0; i < count; i++) {
            double a1 = (Math.PI * 2.0 * i) / count;
            double a2 = (Math.PI * 2.0 * (i + 1)) / count;
            float c1 = (float)Math.cos(a1), s1 = (float)Math.sin(a1);
            float c2 = (float)Math.cos(a2), s2 = (float)Math.sin(a2);

            float yWave1 = (float)Math.sin(i * 1.5) * 0.02F;
            float yWave2 = (float)Math.sin((i + 1) * 1.5) * 0.02F;

            // Vine 1
            draw3DTaperedSegment(buf, mat, c1 * r, yWave1, s1 * r, 0.012F, c2 * r, yWave2, s2 * r, 0.012F, thornWood, thornWood);
            // Vine 2 (twisted phase)
            draw3DTaperedSegment(buf, mat, c1 * (r + 0.015F), -yWave1, s1 * (r + 0.015F), 0.010F, c2 * (r + 0.015F), -yWave2, s2 * (r + 0.015F), 0.010F, shade(thornWood, 0.85F), thornWood);

            // Protruding thorns
            if (i % 2 == 0) {
                float tx = c1 * (r + 0.04F);
                float tz = s1 * (r + 0.04F);
                float ty = yWave1 + 0.035F;
                draw3DTaperedSegment(buf, mat, c1 * r, yWave1, s1 * r, 0.008F, tx, ty, tz, 0.002F, thornWood, shade(thornWood, 1.4F));
            }
            // Blood ruby droplets
            if (i % 4 == 1) {
                float spark = 0.8F + 0.4F * (float)Math.sin(t * 5.0 + i);
                draw3DOctahedron(buf, mat, c1 * (r + 0.01F), yWave1 - 0.02F, s1 * (r + 0.01F), 0.012F * spark, 0.022F * spark, 0.012F * spark, rubyGlow);
            }
        }
        m.pop();
    }

    // 33. VALKYRIE TIARA: Nordic golden winged forehead tiara with glowing sapphire crest
    public static void renderValkyrieTiara(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int goldCol = 0xFFFFD700;
        int gemCol = mainCol;

        m.push();
        m.translate(0.0F, 0.03F, -0.22F);
        Matrix4f mat = m.peek().getPositionMatrix();

        // Brow circlet band
        draw3DBox(buf, mat, -0.16F, -0.015F, 0.0F, 0.16F, 0.015F, 0.02F, goldCol);
        // Center crown peak
        draw3DTaperedSegment(buf, mat, 0.0F, 0.015F, -0.01F, 0.03F, 0.0F, 0.09F, -0.01F, 0.008F, goldCol, shade(goldCol, 1.2F));
        // Center sapphire gemstone
        draw3DOctahedron(buf, mat, 0.0F, 0.035F, -0.02F, 0.025F, 0.040F, 0.020F, gemCol);

        // Side sweeping Valkyrie wings
        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.16F, 0.0F, 0.04F);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(side * 45.0F));
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(side * 20.0F));
            for (int f = 0; f < 3; f++) {
                float fLen = 0.12F + f * 0.05F;
                float fOffset = f * 0.035F;
                draw3DBox(buf, m.peek().getPositionMatrix(), side * 0.01F, fOffset, 0.0F, side * (0.01F + fLen), fOffset + 0.025F, 0.01F, (f % 2 == 0) ? goldCol : 0xFFFFFFFF);
            }
            m.pop();
        }
        m.pop();
    }

    // 34. SHOGUN MASK: Oni demon battle mask with fangs and armor plates
    public static void renderShogunMask(MatrixStack m, BufferBuilder buf, int mainCol, int accCol) {
        int plateBlack = 0xFF18181C;
        int goldTrim = 0xFFE5A93B;
        int fangWhite = 0xFFFFFFF0;
        int redAccent = accCol;

        m.push();
        m.translate(0.0F, -0.08F, -0.22F);
        Matrix4f mat = m.peek().getPositionMatrix();

        // Main jaw faceplate
        draw3DBox(buf, mat, -0.11F, -0.08F, 0.0F, 0.11F, 0.02F, 0.025F, plateBlack);
        // Nose bridge armor
        draw3DBox(buf, mat, -0.035F, 0.02F, -0.02F, 0.035F, 0.07F, 0.02F, plateBlack);
        // Menacing red mouth slit
        draw3DBox(buf, mat, -0.07F, -0.035F, -0.01F, 0.07F, -0.015F, 0.005F, redAccent);

        // Golden Demon Tusks / Fangs
        for (int side = -1; side <= 1; side += 2) {
            // Lower tusks curving up
            draw3DTaperedSegment(buf, mat, side * 0.055F, -0.06F, -0.015F, 0.012F, side * 0.065F, 0.01F, -0.025F, 0.003F, goldTrim, fangWhite);
            // Cheek armor flange
            draw3DBox(buf, mat, side * 0.10F, -0.06F, -0.01F, side * 0.14F, 0.01F, 0.02F, goldTrim);
        }
        m.pop();
    }

    // 35. CYBER VISOR V2: Panoramic HUD visor with scrolling targeting reticle and hex matrix
    public static void renderCyberVisorV2(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int frameDark = 0xFF0D1117;
        int neonCyan = mainCol;
        int targetRed = accCol;

        m.push();
        m.translate(0.0F, 0.0F, -0.22F);
        Matrix4f mat = m.peek().getPositionMatrix();

        // Curved wrap visor glass
        draw3DBox(buf, mat, -0.18F, -0.04F, -0.02F, 0.18F, 0.04F, 0.01F, neonCyan);
        // Upper & lower carbon frame strips
        draw3DBox(buf, mat, -0.19F, 0.04F, -0.025F, 0.19F, 0.055F, 0.015F, frameDark);
        draw3DBox(buf, mat, -0.19F, -0.055F, -0.025F, 0.19F, -0.04F, 0.015F, frameDark);

        // Side cyber earpieces
        for (int side = -1; side <= 1; side += 2) {
            draw3DBox(buf, mat, side * 0.19F, -0.045F, -0.02F, side * 0.23F, 0.045F, 0.04F, frameDark);
            draw3DOctahedron(buf, mat, side * 0.21F, 0.0F, 0.01F, 0.015F, 0.015F, 0.015F, neonCyan);
        }

        // Animated scanning target reticle
        float scanX = (float)Math.sin(t * 3.0) * 0.10F;
        draw3DBox(buf, mat, scanX - 0.015F, -0.025F, -0.025F, scanX + 0.015F, 0.025F, -0.015F, targetRed);
        m.pop();
    }

    // 36. HALO CROSS: Floating radiant golden cross with spinning outer sun halo ring
    public static void renderHaloCross(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int goldCol = 0xFFFFD700;
        int glowCol = mainCol;

        m.push();
        m.translate(0.0F, 0.38F + (float)Math.sin(t * 2.5) * 0.03F, 0.0F);

        // Spinning Sun Halo Ring
        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 60.0F));
        draw3DRing(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.18F, 0.15F, 0.015F, 24, glowCol);
        // 4 Radiant cardinal starburst rays
        for (int i = 0; i < 4; i++) {
            m.push();
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(i * 90.0F));
            draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.19F, 0.0F, 0.0F, 0.035F, 0.012F, 0.012F, goldCol);
            m.pop();
        }
        m.pop();

        // Sacred Cross in the center
        Matrix4f crossMat = m.peek().getPositionMatrix();
        // Vertical shaft
        draw3DBox(buf, crossMat, -0.018F, -0.15F, -0.012F, 0.018F, 0.15F, 0.012F, goldCol);
        // Horizontal crossbeam
        draw3DBox(buf, crossMat, -0.09F, 0.02F, -0.012F, 0.09F, 0.06F, 0.012F, goldCol);
        // Center gem
        draw3DOctahedron(buf, crossMat, 0.0F, 0.04F, 0.0F, 0.025F, 0.025F, 0.025F, accCol);
        m.pop();
    }

    // 37. ANGEL HALO TWIN: Twin concentric tilted divine halos counter-rotating
    public static void renderAngelHaloTwin(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int goldCol = 0xFFFFEA60;
        int lightCol = mainCol;

        m.push();
        m.translate(0.0F, 0.28F + (float)Math.sin(t * 2.2) * 0.025F, 0.0F);

        // Lower Halo: tilted forward 15°, spinning clockwise
        m.push();
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(15.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 45.0F));
        draw3DRing(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.32F, 0.28F, 0.02F, 28, goldCol);
        m.pop();

        // Upper Halo: tilted backward 15°, spinning counter-clockwise
        m.push();
        m.translate(0.0F, 0.09F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-15.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-t * 60.0F));
        draw3DRing(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.22F, 0.18F, 0.018F, 24, lightCol);
        m.pop();

        m.pop();
    }

    // 38. ANIME AHOGE: Iconic bouncy single hair strand looping dynamically with physics
    public static void renderAnimeAhoge(MatrixStack m, BufferBuilder buf, int mainCol, float t) {
        int hairCol = mainCol;
        float bounce = (float)Math.sin(t * 5.0) * 12.0F;
        float sway = (float)Math.cos(t * 3.8) * 9.0F;

        m.push();
        m.translate(0.0F, 0.18F, -0.04F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(sway));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(bounce));

        // 4 articulated curved strand segments
        float x1 = 0.0F, y1 = 0.0F, z1 = 0.0F;
        float x2 = 0.03F, y2 = 0.12F, z2 = -0.02F;
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), x1, y1, z1, 0.016F, x2, y2, z2, 0.014F, hairCol, hairCol);

        float x3 = 0.08F, y3 = 0.22F, z3 = -0.05F;
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), x2, y2, z2, 0.014F, x3, y3, z3, 0.011F, hairCol, hairCol);

        float x4 = 0.04F, y4 = 0.28F, z4 = -0.02F;
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), x3, y3, z3, 0.011F, x4, y4, z4, 0.007F, hairCol, hairCol);

        float x5 = -0.02F, y5 = 0.26F, z5 = 0.02F;
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), x4, y4, z4, 0.007F, x5, y5, z5, 0.002F, hairCol, hairCol);

        m.pop();
    }

    // 39. NEKO PAWS: Floating plush cute cat paws beside hands that bob and swat
    public static void renderNekoPaws(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int furWhite = 0xFFFDFDFD;
        int padPink = 0xFFFF94B8;

        for (int side = -1; side <= 1; side += 2) {
            m.push();
            float swatY = (float)Math.sin(t * 3.5 + side) * 0.04F;
            float swatPitch = (float)Math.cos(t * 3.0 + side) * 10.0F;
            m.translate(side * 0.38F, -0.15F + swatY, 0.06F);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(side * -18.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(swatPitch));

            Matrix4f mat = m.peek().getPositionMatrix();
            // Main paw body mitten
            draw3DBox(buf, mat, -0.07F, -0.08F, -0.04F, 0.07F, 0.06F, 0.04F, furWhite);
            // Main central pad
            draw3DOctahedron(buf, mat, 0.0F, -0.02F, -0.045F, 0.035F, 0.030F, 0.010F, padPink);
            // 3 cute toe pads
            draw3DOctahedron(buf, mat, -0.04F, 0.03F, -0.045F, 0.015F, 0.015F, 0.008F, padPink);
            draw3DOctahedron(buf, mat, 0.0F, 0.045F, -0.045F, 0.015F, 0.015F, 0.008F, padPink);
            draw3DOctahedron(buf, mat, 0.04F, 0.03F, -0.045F, 0.015F, 0.015F, 0.008F, padPink);

            m.pop();
        }
    }

    // 40. SAMURAI KATANAS: Dual crossed traditional katanas in lacquered scabbards on back
    public static void renderSamuraiKatanas(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int sayaBlack = 0xFF141416;
        int goldTsuba = 0xFFD4AF37;
        int wrapWhite = 0xFFECECEC;
        int tasselRed = accCol;

        for (int i = 0; i < 2; i++) {
            float rotZ = (i == 0) ? -38.0F : 38.0F;
            float zOff = 0.16F + i * 0.03F;

            m.push();
            m.translate(0.0F, 0.02F, zOff);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rotZ));
            Matrix4f mat = m.peek().getPositionMatrix();

            // Long curved scabbard (saya)
            draw3DBox(buf, mat, -0.018F, -0.55F, -0.012F, 0.018F, 0.12F, 0.012F, sayaBlack);
            // Saya gold tip (kojiri)
            draw3DBox(buf, mat, -0.02F, -0.57F, -0.014F, 0.02F, -0.54F, 0.014F, goldTsuba);
            // Golden circular handguard (tsuba)
            draw3DBox(buf, mat, -0.05F, 0.12F, -0.05F, 0.05F, 0.135F, 0.05F, goldTsuba);
            // Wrapped handle (tsuka)
            draw3DBox(buf, mat, -0.016F, 0.135F, -0.010F, 0.016F, 0.34F, 0.010F, wrapWhite);
            // Handle endcap (kashira)
            draw3DBox(buf, mat, -0.018F, 0.34F, -0.012F, 0.018F, 0.36F, 0.012F, goldTsuba);
            // Hanging decorative tassel
            draw3DBox(buf, mat, -0.008F, 0.36F, -0.005F, 0.008F, 0.44F, 0.005F, tasselRed);
            m.pop();
        }
    }

    // 41. REAPER SCYTHE: Massive curved war scythe slung diagonally on back with glowing soul blade
    public static void renderReaperScythe(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int staffDark = 0xFF1C1D22;
        int metalSilver = 0xFF9E9E9E;
        int soulGlow = mainCol;

        m.push();
        m.translate(0.0F, 0.05F, 0.18F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-42.0F));
        Matrix4f mat = m.peek().getPositionMatrix();

        // 2-meter long sturdy war shaft
        draw3DBox(buf, mat, -0.016F, -0.75F, -0.016F, 0.016F, 0.65F, 0.016F, staffDark);
        // Steel grip collars
        draw3DBox(buf, mat, -0.02F, -0.10F, -0.02F, 0.02F, 0.10F, 0.02F, metalSilver);
        // Scythe head mounting block
        draw3DBox(buf, mat, -0.03F, 0.62F, -0.03F, 0.03F, 0.70F, 0.03F, metalSilver);

        // Wicked curved soul blade
        m.push();
        m.translate(0.0F, 0.68F, 0.0F);
        // Segment 1 (forward spur)
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.025F, 0.32F, 0.10F, 0.0F, 0.020F, metalSilver, soulGlow);
        // Segment 2 (curving downwards into crescent)
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), 0.32F, 0.10F, 0.0F, 0.020F, 0.58F, -0.16F, 0.0F, 0.012F, soulGlow, soulGlow);
        // Segment 3 (deadly razor tip)
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), 0.58F, -0.16F, 0.0F, 0.012F, 0.68F, -0.42F, 0.0F, 0.002F, soulGlow, shade(soulGlow, 1.4F));
        m.pop();

        m.pop();
    }

    // 42. SCI-FI SHOULDER CANNONS: Dual articulated pulse cannons with laser targeting beams
    public static void renderSciFiShoulderCannons(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int carbonArmor = 0xFF1B1E24;
        int gunMetal = 0xFF434955;
        int plasmaGlow = mainCol;
        int laserRed = accCol;

        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.24F, 0.12F, 0.10F);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(side * 12.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-6.0F));
            Matrix4f mat = m.peek().getPositionMatrix();

            // Mounting bracket
            draw3DBox(buf, mat, -0.035F, -0.04F, -0.03F, 0.035F, 0.0F, 0.03F, carbonArmor);
            // Cannon body
            draw3DBox(buf, mat, -0.03F, 0.0F, -0.14F, 0.03F, 0.05F, 0.08F, gunMetal);
            // Dual muzzle barrels
            draw3DCylinder(buf, mat, -0.015F, 0.025F, -0.22F, 0.012F, 0.08F, 8, carbonArmor);
            draw3DCylinder(buf, mat, 0.015F, 0.025F, -0.22F, 0.012F, 0.08F, 8, carbonArmor);
            // Glowing heatsink vents
            draw3DBox(buf, mat, -0.032F, 0.015F, -0.06F, 0.032F, 0.035F, 0.04F, plasmaGlow);
            // Red laser targeting beam line
            draw3DTaperedSegment(buf, mat, 0.0F, 0.025F, -0.24F, 0.003F, 0.0F, 0.025F, -1.80F, 0.001F, laserRed, laserRed);

            m.pop();
        }
    }

    // 43. ENERGY SHIELD ARM: Floating hexagonal hard-light riot shield on left arm
    public static void renderEnergyShieldArm(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int hardLight = mainCol;
        int frameDark = 0xFF141A24;
        int pulseCol = accCol;

        m.push();
        m.translate(-0.36F, -0.05F, 0.02F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-25.0F));
        Matrix4f mat = m.peek().getPositionMatrix();

        // Forearm bracket generator module
        draw3DBox(buf, mat, -0.04F, -0.10F, -0.04F, 0.04F, 0.10F, 0.04F, frameDark);
        draw3DOctahedron(buf, mat, -0.045F, 0.0F, 0.0F, 0.02F, 0.04F, 0.02F, pulseCol);

        // Large hexagonal energy shield plate
        float sw = 0.28F, sh = 0.38F;
        drawQuad(buf, mat, -0.06F, -sh, -sw * 0.5F, -0.06F, -sh, sw * 0.5F, -0.06F, sh, sw * 0.8F, -0.06F, sh, -sw * 0.8F, hardLight);
        // Energy border lines
        draw3DBox(buf, mat, -0.065F, -sh, -sw * 0.5F, -0.055F, sh, -sw * 0.5F + 0.015F, pulseCol);
        draw3DBox(buf, mat, -0.065F, -sh, sw * 0.5F - 0.015F, -0.055F, sh, sw * 0.5F, pulseCol);
        m.pop();
    }

    // 44. CYBER TAIL MECH: Heavy articulated segmented robotic tail with glowing neon LED joints
    public static void renderCyberTailMech(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int chromeMetal = 0xFF353942;
        int neonCore = mainCol;
        int sparkTip = accCol;

        m.push();
        m.translate(0.0F, -0.32F, 0.14F);

        int segs = 8;
        float px = 0.0F, py = 0.0F, pz = 0.0F;

        for (int i = 0; i < segs; i++) {
            float frac = (float) i / segs;
            float sway = (float)Math.sin(t * 3.0 + i * 0.7) * (0.03F + frac * 0.07F);
            float cx = sway;
            float cy = py - 0.05F;
            float cz = pz + 0.06F + frac * 0.03F;

            Matrix4f mat = m.peek().getPositionMatrix();
            // Articulated cyber vertebra
            draw3DBox(buf, mat, px - 0.035F * (1.0F - frac * 0.4F), py - 0.02F, pz - 0.02F, px + 0.035F * (1.0F - frac * 0.4F), py + 0.02F, pz + 0.02F, chromeMetal);
            // Glowing neon ball joint
            draw3DOctahedron(buf, mat, (px + cx) * 0.5F, (py + cy) * 0.5F, (pz + cz) * 0.5F, 0.016F, 0.016F, 0.016F, neonCore);

            px = cx; py = cy; pz = cz;
        }

        // Stinger electrode tip
        m.translate(px, py, pz);
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), -0.015F, 0.0F, 0.0F, 0.008F, -0.025F, -0.05F, 0.03F, 0.002F, chromeMetal, sparkTip);
        draw3DTaperedSegment(buf, m.peek().getPositionMatrix(), 0.015F, 0.0F, 0.0F, 0.008F, 0.025F, -0.05F, 0.03F, 0.002F, chromeMetal, sparkTip);
        m.pop();
    }

    // 45. TENTACLE PLUMES: 4 sinuous void tentacles emerging from upper shoulder blades
    public static void renderTentaclePlumes(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int voidDark = 0xFF110818;
        int voidPurple = mainCol;
        int nodeGlow = accCol;

        for (int i = 0; i < 4; i++) {
            float side = (i % 2 == 0) ? -1.0F : 1.0F;
            float vert = (i < 2) ? 0.08F : -0.08F;

            m.push();
            m.translate(side * 0.14F, vert, 0.14F);

            int segs = 6;
            float px = 0.0F, py = 0.0F, pz = 0.0F;

            for (int s = 0; s < segs; s++) {
                float waveX = (float)Math.sin(t * 3.2 + s * 0.9 + i) * 0.06F;
                float waveY = (float)Math.cos(t * 2.8 + s * 0.8 + i) * 0.05F;
                float cx = px + side * 0.04F + waveX;
                float cy = py + 0.06F + waveY;
                float cz = pz + 0.07F;

                float r1 = 0.028F * (1.0F - (float)s / segs);
                float r2 = 0.028F * (1.0F - (float)(s + 1) / segs);

                Matrix4f mat = m.peek().getPositionMatrix();
                draw3DTaperedSegment(buf, mat, px, py, pz, r1, cx, cy, cz, r2, voidDark, voidPurple);
                // Glowing suction node
                if (s % 2 == 0) {
                    draw3DOctahedron(buf, mat, cx, cy, cz + r2, 0.008F, 0.008F, 0.008F, nodeGlow);
                }

                px = cx; py = cy; pz = cz;
            }
            m.pop();
        }
    }

    // 46. MAGIC CIRCLE RING: Intricate rotating arcane magic seal behind player
    public static void renderMagicCircleRing(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int runeCol = mainCol;
        int innerCol = accCol;
        int segs = 32;

        m.push();
        m.translate(0.0F, 0.0F, 0.22F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(t * 35.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Outer concentric ring
        draw3DRing(buf, mat, 0.0F, 0.0F, 0.0F, 0.48F, 0.46F, 0.01F, segs, runeCol);
        // Middle ring
        draw3DRing(buf, mat, 0.0F, 0.0F, 0.0F, 0.36F, 0.345F, 0.01F, segs, innerCol);
        // Hexagram / Star of David inner struts
        for (int k = 0; k < 6; k++) {
            double a1 = (Math.PI * 2.0 * k) / 6.0;
            double a2 = (Math.PI * 2.0 * ((k + 2) % 6)) / 6.0;
            float x1 = (float)Math.cos(a1) * 0.34F, y1 = (float)Math.sin(a1) * 0.34F;
            float x2 = (float)Math.cos(a2) * 0.34F, y2 = (float)Math.sin(a2) * 0.34F;
            draw3DTaperedSegment(buf, mat, x1, y1, 0.0F, 0.006F, x2, y2, 0.0F, 0.006F, innerCol, runeCol);
        }
        // Center arcane power gem
        draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.05F, 0.05F, 0.03F, runeCol);
        m.pop();
    }

    // 47. FLOATING RUNES: 6 ancient runic stone tablets orbiting in a protective hexagon
    public static void renderFloatingRunes(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int stoneGrey = 0xFF2A2E38;
        int runeNeon = mainCol;
        int count = 6;
        float r = 0.52F;

        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 30.0F));

        for (int i = 0; i < count; i++) {
            double a = (Math.PI * 2.0 * i) / count;
            float rx = (float)Math.cos(a) * r;
            float rz = (float)Math.sin(a) * r;
            float ry = (float)Math.sin(t * 2.5 + i * 1.2) * 0.08F;

            m.push();
            m.translate(rx, ry, rz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) + 90.0F));
            Matrix4f mat = m.peek().getPositionMatrix();

            // Heavy carved stone tablet
            draw3DBox(buf, mat, -0.045F, -0.08F, -0.015F, 0.045F, 0.08F, 0.015F, stoneGrey);
            // Glowing carved runic cross inscription
            draw3DBox(buf, mat, -0.008F, -0.05F, -0.018F, 0.008F, 0.05F, -0.012F, runeNeon);
            draw3DBox(buf, mat, -0.025F, -0.008F, -0.018F, 0.025F, 0.008F, -0.012F, runeNeon);
            m.pop();
        }
        m.pop();
    }

    // 48. FLOATING DAGGERS: Ring of 8 crystalline throwing daggers spinning point-down
    public static void renderFloatingDaggers(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int bladeSilver = 0xFFE0E5EC;
        int glowCol = mainCol;
        int count = 8;
        float r = 0.44F;

        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-t * 65.0F));

        for (int i = 0; i < count; i++) {
            double a = (Math.PI * 2.0 * i) / count;
            float dx = (float)Math.cos(a) * r;
            float dz = (float)Math.sin(a) * r;
            float dy = (float)Math.sin(t * 3.5 + i) * 0.05F;

            m.push();
            m.translate(dx, dy, dz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) + 90.0F));
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(12.0F)); // Tilt slightly outwards
            Matrix4f mat = m.peek().getPositionMatrix();

            // Point-down dagger blade
            draw3DTaperedSegment(buf, mat, 0.0F, 0.08F, 0.0F, 0.015F, 0.0F, -0.12F, 0.0F, 0.002F, bladeSilver, glowCol);
            // Golden crossguard
            draw3DBox(buf, mat, -0.035F, 0.075F, -0.01F, 0.035F, 0.09F, 0.01F, accCol);
            // Dagger hilt & pommel
            draw3DBox(buf, mat, -0.008F, 0.09F, -0.008F, 0.008F, 0.15F, 0.008F, 0xFF222222);
            draw3DOctahedron(buf, mat, 0.0F, 0.16F, 0.0F, 0.012F, 0.012F, 0.012F, accCol);
            m.pop();
        }
        m.pop();
    }

    // 49. CHAKRA SPHERES: 5 Truth-Seeking dark matter spheres floating in an arc behind back
    public static void renderChakraSpheres(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int darkCore = 0xFF0E0E12;
        int auraGlow = mainCol;
        int count = 5;

        m.push();
        m.translate(0.0F, 0.12F, 0.22F);

        for (int i = 0; i < count; i++) {
            float frac = (float)i / (count - 1);
            float a = (frac - 0.5F) * 1.8F; // Arc angle
            float sx = (float)Math.sin(a) * 0.38F;
            float sy = (float)Math.cos(a) * 0.28F - 0.10F + (float)Math.sin(t * 3.0 + i) * 0.03F;

            m.push();
            m.translate(sx, sy, 0.0F);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 90.0F + i * 45.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(t * 60.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // Solid dark matter core
            draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.045F, 0.045F, 0.045F, darkCore);
            // Concentric outer aura ring
            draw3DBox(buf, mat, -0.065F, -0.005F, -0.065F, 0.065F, 0.005F, 0.065F, auraGlow);
            m.pop();
        }
        m.pop();
    }

    // 50. PLANETARY RINGS: Dual tilted celestial rings (like Saturn) spinning around waist
    public static void renderPlanetaryRings(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int ringCol1 = mainCol;
        int ringCol2 = accCol;
        int moonCol = 0xFFFFFFFF;
        int segs = 32;

        m.push();
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(24.0F));
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(12.0F));
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 20.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Inner dense planetary ring
        draw3DRing(buf, mat, 0.0F, 0.0F, 0.0F, 0.44F, 0.40F, 0.008F, segs, ringCol1);
        // Outer shimmering ring
        draw3DRing(buf, mat, 0.0F, 0.0F, 0.0F, 0.54F, 0.48F, 0.006F, segs, ringCol2);

        // 3 Orbiting moonlet specks
        for (int m_idx = 0; m_idx < 3; m_idx++) {
            double ma = (Math.PI * 2.0 * m_idx / 3.0) + t * (0.8 + m_idx * 0.4);
            float mx = (float)Math.cos(ma) * (0.46F + m_idx * 0.04F);
            float mz = (float)Math.sin(ma) * (0.46F + m_idx * 0.04F);
            draw3DOctahedron(buf, mat, mx, 0.0F, mz, 0.015F, 0.015F, 0.015F, moonCol);
        }
        m.pop();
    }

    // =========================================================================
    // NEW 20 VOLUMETRIC 3D ACCESSORY IMPLEMENTATIONS (TOTAL 70 ACCESSORIES!)
    // =========================================================================

    // 51. STEAMPUNK GOGGLES: Brass double-cylinder goggles on forehead with amber lenses & ocular loupe
    public static void renderSteampunkGoggles(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int brassCol = 0xFFD4A347;
        int leatherCol = 0xFF4A2A14;
        int lensCol = 0xFFFFA020;
        int glassReflection = 0xAAFFFFFF;

        m.push();
        m.translate(0.0F, 0.08F, 0.22F);

        Matrix4f mat = m.peek().getPositionMatrix();
        // Leather strap around head
        draw3DBox(buf, mat, -0.27F, -0.02F, -0.46F, 0.27F, 0.02F, 0.02F, leatherCol);

        // Left Brass Eye Cylinder
        draw3DCylinder(buf, mat, -0.09F, -0.04F, 0.0F, 0.045F, 0.055F, 14, brassCol);
        draw3DOctahedron(buf, mat, -0.09F, 0.0F, 0.055F, 0.038F, 0.038F, 0.005F, lensCol);
        draw3DOctahedron(buf, mat, -0.07F, 0.02F, 0.058F, 0.012F, 0.012F, 0.004F, glassReflection);

        // Right Brass Eye Cylinder
        draw3DCylinder(buf, mat, 0.09F, -0.04F, 0.0F, 0.045F, 0.055F, 14, brassCol);
        draw3DOctahedron(buf, mat, 0.09F, 0.0F, 0.055F, 0.038F, 0.038F, 0.005F, lensCol);
        draw3DOctahedron(buf, mat, 0.11F, 0.02F, 0.058F, 0.012F, 0.012F, 0.004F, glassReflection);

        // Center Brass Bridge
        draw3DBox(buf, mat, -0.045F, -0.01F, 0.02F, 0.045F, 0.01F, 0.045F, shade(brassCol, 1.1F));

        // Articulated Magnifying Loupe Arm on Right Eye
        draw3DTaperedSegment(buf, mat, 0.135F, 0.0F, 0.03F, 0.006F, 0.165F, 0.05F, 0.07F, 0.005F, brassCol, brassCol);
        draw3DCylinder(buf, mat, 0.165F, 0.025F, 0.07F, 0.022F, 0.025F, 10, shade(brassCol, 1.15F));
        draw3DOctahedron(buf, mat, 0.165F, 0.038F, 0.095F, 0.018F, 0.018F, 0.004F, 0xFF40E0D0); // Cyan targeting lens
        m.pop();
    }

    // 52. SHINIGAMI MASK: Bleach Hollow bone skull mask with jagged black markings & crimson pupil
    public static void renderShinigamiMask(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int boneWhite = 0xFFFAF6EE;
        int voidBlack = 0xFF141018;
        int eyeCrimson = 0xFFFF1838;

        m.push();
        m.translate(-0.14F, -0.02F, 0.20F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-18.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Mask main cranial cheek shell
        draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.09F, 0.13F, 0.05F, boneWhite);

        // Hollow Eye Socket & Glowing Crimson Pupil
        draw3DOctahedron(buf, mat, 0.02F, 0.03F, 0.045F, 0.026F, 0.022F, 0.015F, voidBlack);
        float eyePulse = 0.85F + 0.15F * (float)Math.sin(t * 5.0);
        draw3DOctahedron(buf, mat, 0.02F, 0.03F, 0.055F, 0.012F * eyePulse, 0.012F * eyePulse, 0.008F, eyeCrimson);

        // Jagged Black Hollow Jaw Markings (Teeth / Void Stripes)
        for (int i = 0; i < 4; i++) {
            float y = -0.03F - i * 0.022F;
            draw3DBox(buf, mat, -0.03F, y, 0.04F, 0.05F, y + 0.012F, 0.055F, voidBlack);
        }

        // Curved Hollow Bone Crest Horn arching over ear
        draw3DTaperedSegment(buf, mat, -0.04F, 0.08F, 0.01F, 0.018F, -0.09F, 0.20F, -0.06F, 0.004F, boneWhite, voidBlack);
        draw3DTaperedSegment(buf, mat, -0.02F, 0.06F, 0.02F, 0.012F, -0.06F, 0.15F, -0.04F, 0.003F, voidBlack, boneWhite);
        m.pop();
    }

    // 53. SAMURAI KABUTO: Black lacquered helmet dome with massive golden crescent moon crest (maedate)
    public static void renderSamuraiKabuto(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int helmetBlack = 0xFF181B22;
        int goldCrest = 0xFFFFD700;
        int redLacing = 0xFFBA1828;

        m.push();
        m.translate(0.0F, 0.22F, 0.0F);

        Matrix4f mat = m.peek().getPositionMatrix();
        // Helmet Dome (Hachi)
        draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.28F, 0.16F, 0.28F, helmetBlack);
        draw3DBox(buf, mat, -0.27F, -0.06F, -0.27F, 0.27F, -0.02F, 0.27F, redLacing);

        // Golden Crescent Moon Crest (Maedate) arching high over forehead
        m.push();
        m.translate(0.0F, 0.08F, 0.25F);
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(14.0F));
        Matrix4f crestMat = m.peek().getPositionMatrix();
        draw3DOctahedron(buf, crestMat, 0.0F, 0.0F, 0.0F, 0.035F, 0.035F, 0.02F, goldCrest);
        // Left Moon Horn
        draw3DTaperedSegment(buf, crestMat, 0.0F, 0.0F, 0.0F, 0.025F, -0.22F, 0.20F, -0.02F, 0.004F, goldCrest, shade(goldCrest, 1.15F));
        // Right Moon Horn
        draw3DTaperedSegment(buf, crestMat, 0.0F, 0.0F, 0.0F, 0.025F, 0.22F, 0.20F, -0.02F, 0.004F, goldCrest, shade(goldCrest, 1.15F));
        m.pop();

        // Cheek Turnback Plates (Fukikaeshi)
        draw3DBox(buf, mat, -0.29F, -0.08F, 0.10F, -0.26F, 0.04F, 0.24F, helmetBlack);
        draw3DOctahedron(buf, mat, -0.275F, -0.02F, 0.17F, 0.015F, 0.015F, 0.01F, goldCrest);
        draw3DBox(buf, mat, 0.26F, -0.08F, 0.10F, 0.29F, 0.04F, 0.24F, helmetBlack);
        draw3DOctahedron(buf, mat, 0.275F, -0.02F, 0.17F, 0.015F, 0.015F, 0.01F, goldCrest);
        m.pop();
    }

    // 54. FROSTBITE HORNS: Translucent jagged arctic ice horns with freezing crystal spikes
    public static void renderFrostbiteHorns(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int iceCore = 0xDD7CE7FF;
        int iceGlaze = 0xAAFFFFFF;
        int frostDeep = 0xEE1E7CC8;

        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.16F, 0.16F, 0.08F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-side * 28.0F));
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(side * 18.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-15.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // Horn Root
            draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.0F, 0.038F, side * 0.08F, 0.16F, -0.06F, 0.026F, frostDeep, iceCore);
            // Mid Arch
            draw3DTaperedSegment(buf, mat, side * 0.08F, 0.16F, -0.06F, 0.026F, side * 0.14F, 0.32F, -0.16F, 0.014F, iceCore, iceGlaze);
            // Sharp Frozen Tip
            draw3DTaperedSegment(buf, mat, side * 0.14F, 0.32F, -0.16F, 0.014F, side * 0.18F, 0.44F, -0.25F, 0.003F, iceGlaze, 0xFFFFFFFF);

            // 2 Jagged Crystal Thorns protruding from horn side
            draw3DOctahedron(buf, mat, side * 0.06F, 0.12F, -0.03F, 0.018F, 0.04F, 0.018F, iceGlaze);
            draw3DOctahedron(buf, mat, side * 0.12F, 0.26F, -0.11F, 0.014F, 0.035F, 0.014F, iceCore);
            m.pop();
        }
    }

    // 55. SOLAR ECLIPSE CROWN: Pitch-black celestial sun disc surrounded by 12 radiating golden coronal rays
    public static void renderSolarEclipseCrown(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int blackSun = 0xFF05050A;
        int coronaGold = 0xFFFFCA28;
        int coronaOuter = 0xAAFF6A00;

        m.push();
        m.translate(0.0F, 0.40F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 30.0F));
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(6.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Central Black Eclipse Disc
        draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.12F, 0.02F, 0.12F, blackSun);

        // 12 Radiating Golden Solar Flare Rays
        int rays = 12;
        float pulse = 1.0F + 0.14F * (float)Math.sin(t * 4.0);
        for (int i = 0; i < rays; i++) {
            double a = (Math.PI * 2.0 * i) / rays;
            float cos = (float)Math.cos(a), sin = (float)Math.sin(a);
            float innerR = 0.12F;
            float outerR = (0.24F + ((i % 2 == 0) ? 0.08F : 0.0F)) * pulse;

            draw3DTaperedSegment(buf, mat, cos * innerR, 0.0F, sin * innerR, 0.016F, cos * outerR, 0.0F, sin * outerR, 0.002F, coronaGold, coronaOuter);
        }
        m.pop();
    }

    // 56. SUSANOO ARMOR: Massive glowing spectral samurai pauldrons hovering over both shoulders
    public static void renderSusanooArmor(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int spectralCol = mainCol;
        int flameTrim = accCol;

        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.36F, 0.04F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-side * 18.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // 4 Layered Tiered Shoulder Plates (Sode)
            for (int layer = 0; layer < 4; layer++) {
                float y = -layer * 0.075F;
                float w = 0.18F - layer * 0.015F;
                float d = 0.22F - layer * 0.015F;
                draw3DBox(buf, mat, -w * 0.5F, y - 0.035F, -d * 0.5F, w * 0.5F, y + 0.035F, d * 0.5F, spectralCol);
                draw3DBox(buf, mat, -w * 0.5F - 0.008F, y - 0.038F, -d * 0.5F - 0.008F, w * 0.5F + 0.008F, y - 0.020F, d * 0.5F + 0.008F, flameTrim);
            }

            // Upward-pointing ethereal spirit flame spikes
            for (int sp = -1; sp <= 1; sp++) {
                float pulse = (float)Math.sin(t * 4.0 + sp) * 0.03F;
                draw3DTaperedSegment(buf, mat, sp * 0.06F, 0.04F, 0.0F, 0.020F, sp * 0.08F, 0.24F + pulse, 0.0F, 0.003F, spectralCol, flameTrim);
            }
            m.pop();
        }
    }

    // 57. CYBER KATANA BACK: Futuristic high-frequency rail-katana diagonally mounted with battery cells
    public static void renderCyberKatanaBack(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int carbonScabbard = 0xFF141720;
        int titaniumHilt = 0xFFC0C8D8;
        int neonRail = accCol;
        int batteryCell = mainCol;

        m.push();
        m.translate(0.0F, 0.02F, 0.18F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-42.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Carbon-Fiber Scabbard Body
        draw3DBox(buf, mat, -0.025F, -0.55F, -0.015F, 0.025F, 0.20F, 0.015F, carbonScabbard);
        // Glowing Neon Edge Rail
        draw3DBox(buf, mat, 0.023F, -0.52F, -0.008F, 0.028F, 0.18F, 0.008F, neonRail);

        // High-Voltage Battery Cell at Scabbard Throat
        draw3DBox(buf, mat, -0.035F, 0.08F, -0.022F, 0.035F, 0.18F, 0.022F, shade(carbonScabbard, 1.2F));
        draw3DOctahedron(buf, mat, 0.0F, 0.13F, 0.023F, 0.014F, 0.03F, 0.008F, batteryCell);

        // Tsuba Handguard
        draw3DBox(buf, mat, -0.05F, 0.20F, -0.035F, 0.05F, 0.22F, 0.035F, titaniumHilt);

        // Tsuka Corded Handle
        draw3DTaperedSegment(buf, mat, 0.0F, 0.22F, 0.0F, 0.018F, 0.0F, 0.50F, 0.0F, 0.015F, carbonScabbard, titaniumHilt);
        // Pommel Ring
        draw3DRing(buf, mat, 0.0F, 0.51F, 0.0F, 0.03F, 0.02F, 0.01F, 12, neonRail);
        m.pop();
    }

    // 58. KITSUNE NINE TAILS: 9 majestic articulated ethereal fox tails spreading in fan behind player
    public static void renderKitsuneNineTails(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int tailFur = 0xFFFDFCF9;
        int tailTip = accCol;
        int tails = 9;

        m.push();
        m.translate(0.0F, -0.32F, 0.16F);

        for (int i = 0; i < tails; i++) {
            float frac = (float)i / (tails - 1);
            float spreadAngle = (frac - 0.5F) * 135.0F;
            float wave = (float)Math.sin(t * 2.8 + i * 0.55);

            m.push();
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(spreadAngle * 0.4F));
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(spreadAngle));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0F + wave * 6.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // Tail Segment 1 (Root)
            draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.0F, 0.030F, 0.0F, 0.15F, 0.05F, 0.048F, tailFur, tailFur);
            // Tail Segment 2 (Mid Fluff)
            draw3DTaperedSegment(buf, mat, 0.0F, 0.15F, 0.05F, 0.048F, 0.0F, 0.32F, 0.12F, 0.056F, tailFur, tailFur);
            // Tail Segment 3 (Upper Arch)
            draw3DTaperedSegment(buf, mat, 0.0F, 0.32F, 0.12F, 0.056F, 0.0F, 0.48F, 0.15F, 0.042F, tailFur, tailTip);
            // Tail Segment 4 (Glowing Ethereal Tip)
            draw3DTaperedSegment(buf, mat, 0.0F, 0.48F, 0.15F, 0.042F, 0.0F, 0.62F, 0.18F, 0.005F, tailTip, 0xFFFFFFFF);
            m.pop();
        }
        m.pop();
    }

    // 59. DRAGON SKULL SHOULDER: Weathered dragon cranium with sharp fangs & backward curved horns on left shoulder
    public static void renderDragonSkullShoulder(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int skullBone = 0xFFE8E2D0;
        int hornDark = 0xFF352B28;
        int eyeFire = 0xFFFF4010;

        m.push();
        m.translate(-0.35F, 0.08F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-45.0F));
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-15.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Dragon Cranium Dome
        draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.12F, 0.10F, 0.15F, skullBone);
        // Snout
        draw3DTaperedSegment(buf, mat, 0.0F, -0.02F, 0.05F, 0.065F, 0.0F, -0.06F, 0.22F, 0.035F, skullBone, shade(skullBone, 0.85F));

        // Sharp Dragon Fangs
        draw3DTaperedSegment(buf, mat, -0.025F, -0.07F, 0.18F, 0.008F, -0.025F, -0.11F, 0.18F, 0.001F, 0xFFFFFFFF, 0xFFFFFFFF);
        draw3DTaperedSegment(buf, mat, 0.025F, -0.07F, 0.18F, 0.008F, 0.025F, -0.11F, 0.18F, 0.001F, 0xFFFFFFFF, 0xFFFFFFFF);

        // Glowing Fiery Dragon Eyes
        draw3DOctahedron(buf, mat, -0.05F, 0.02F, 0.06F, 0.015F, 0.012F, 0.015F, eyeFire);
        draw3DOctahedron(buf, mat, 0.05F, 0.02F, 0.06F, 0.015F, 0.012F, 0.015F, eyeFire);

        // Twin Backward-Swept Dragon Horns
        draw3DTaperedSegment(buf, mat, -0.06F, 0.06F, -0.04F, 0.025F, -0.15F, 0.20F, -0.22F, 0.004F, hornDark, shade(hornDark, 0.7F));
        draw3DTaperedSegment(buf, mat, 0.06F, 0.06F, -0.04F, 0.025F, 0.15F, 0.20F, -0.22F, 0.004F, hornDark, shade(hornDark, 0.7F));
        m.pop();
    }

    // 60. NEON CYBER SPINE: External cybernetic spine vertebrae running down back with data pulses
    public static void renderNeonCyberSpine(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int chromeMetal = 0xFF2B3240;
        int conduitCol = mainCol;
        int packetCol = 0xFFFFFFFF;
        int vertebrae = 7;

        m.push();
        m.translate(0.0F, 0.16F, 0.15F);

        Matrix4f mat = m.peek().getPositionMatrix();
        // Central continuous conduit line
        draw3DBox(buf, mat, -0.008F, -vertebrae * 0.075F, -0.005F, 0.008F, 0.02F, 0.005F, conduitCol);

        for (int i = 0; i < vertebrae; i++) {
            float y = -i * 0.075F;
            // Vertebra block
            draw3DBox(buf, mat, -0.035F, y - 0.022F, -0.015F, 0.035F, y + 0.022F, 0.015F, chromeMetal);
            // Lateral rib anchors
            draw3DBox(buf, mat, -0.065F, y - 0.008F, -0.012F, 0.065F, y + 0.008F, 0.012F, shade(chromeMetal, 0.85F));

            // Data Pulse Traveling Down Spine
            float packetPhase = ((t * 4.0F + i * 0.4F) % vertebrae);
            if (Math.abs(packetPhase - i) < 0.8F) {
                draw3DOctahedron(buf, mat, 0.0F, y, 0.018F, 0.016F, 0.016F, 0.012F, packetCol);
            }
        }
        m.pop();
    }

    // 61. DEMONIC GREATSWORD: Colossal Berserk-style iron slab blade strapped across the back
    public static void renderDemonicGreatsword(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int darkIron = 0xFF1C1E24;
        int bloodFuller = 0xFF990A1A;
        int leatherGrip = 0xFF3D2518;
        int pommelIron = 0xFF454B58;

        m.push();
        m.translate(0.0F, -0.10F, 0.20F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-32.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Massive Slab Blade (Length 1.25m, Width 0.22m, Thickness 0.035m)
        draw3DBox(buf, mat, -0.10F, -0.65F, -0.018F, 0.10F, 0.35F, 0.018F, darkIron);
        // Beveled Blade Tip
        draw3DTriangle(buf, mat, -0.10F, -0.65F, 0.0F, 0.10F, -0.65F, 0.0F, 0.0F, -0.78F, 0.0F, darkIron);

        // Central Glowing Blood Channel (Fuller)
        draw3DBox(buf, mat, -0.02F, -0.60F, -0.020F, 0.02F, 0.30F, 0.020F, bloodFuller);

        // Heavy Iron Crossguard
        draw3DBox(buf, mat, -0.15F, 0.35F, -0.030F, 0.15F, 0.40F, 0.030F, shade(darkIron, 1.3F));

        // Long Two-Handed Leather Grip
        draw3DTaperedSegment(buf, mat, 0.0F, 0.40F, 0.0F, 0.022F, 0.0F, 0.72F, 0.0F, 0.018F, leatherGrip, leatherGrip);

        // Counterweight Pommel
        draw3DOctahedron(buf, mat, 0.0F, 0.75F, 0.0F, 0.035F, 0.035F, 0.035F, pommelIron);
        m.pop();
    }

    // 62. ARCHANGEL HALO: Triple-ring gyro-stabilized concentric angelic halo hovering above head
    public static void renderArchangelHalo(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int goldRing = 0xFFFFD700;
        int whiteLight = 0xFFFFFFFF;
        int divineGlow = mainCol;

        m.push();
        m.translate(0.0F, 0.48F, 0.0F);

        // Ring 1 (Outer, rotating horizontal)
        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 35.0F));
        draw3DRing(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.38F, 0.35F, 0.010F, 24, goldRing);
        m.pop();

        // Ring 2 (Mid, tilted 35 deg, rotating on Z)
        m.push();
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(35.0F));
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-t * 45.0F));
        draw3DRing(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.28F, 0.25F, 0.008F, 20, divineGlow);
        m.pop();

        // Ring 3 (Inner, tilted -35 deg, rotating on X)
        m.push();
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-35.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(t * 55.0F));
        draw3DRing(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.18F, 0.16F, 0.008F, 16, goldRing);
        m.pop();

        // Central Floating Radiant Holy Star Octahedron
        float starPulse = 0.85F + 0.25F * (float)Math.sin(t * 4.0);
        draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.035F * starPulse, 0.055F * starPulse, 0.035F * starPulse, whiteLight);
        m.pop();
    }

    // 63. FLOATING GRIMOIRE: Ancient open magical spellbook floating beside shoulder with turning glowing pages
    public static void renderFloatingGrimoire(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int bookCover = 0xFF5C1420;
        int goldEmboss = 0xFFFFD700;
        int parchment = 0xFFF8EED8;
        int runicGlow = accCol;

        float bob = (float)Math.sin(t * 2.2) * 0.04F;
        m.push();
        m.translate(-0.48F, 0.12F + bob, 0.15F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(35.0F + (float)Math.sin(t * 1.5) * 8.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(20.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Book Spine
        draw3DBox(buf, mat, -0.015F, -0.16F, -0.02F, 0.015F, 0.16F, 0.02F, goldEmboss);

        // Left Open Cover (Tilted -35 deg)
        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-35.0F));
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.22F, -0.16F, -0.012F, 0.0F, 0.16F, 0.0F, bookCover);
        draw3DBox(buf, m.peek().getPositionMatrix(), -0.20F, -0.14F, 0.0F, -0.02F, 0.14F, 0.018F, parchment);
        m.pop();

        // Right Open Cover (Tilted +35 deg)
        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(35.0F));
        draw3DBox(buf, m.peek().getPositionMatrix(), 0.0F, -0.16F, -0.012F, 0.22F, 0.16F, 0.0F, bookCover);
        draw3DBox(buf, m.peek().getPositionMatrix(), 0.02F, -0.14F, 0.0F, 0.20F, 0.14F, 0.018F, parchment);
        m.pop();

        // Floating Arcane Runic Seal hovering above pages
        m.push();
        m.translate(0.0F, 0.04F, 0.08F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(t * 60.0F));
        draw3DRing(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.09F, 0.08F, 0.005F, 12, runicGlow);
        draw3DOctahedron(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.025F, 0.025F, 0.025F, runicGlow);
        m.pop();
        m.pop();
    }

    // 64. BLOOD THORN AURA: Swirling crimson blood thorn brambles with floating blood gems
    public static void renderBloodThornAura(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int thornVine = 0xFF350812;
        int bloodGem = 0xFFFF1838;
        int strands = 3;

        m.push();
        for (int s = 0; s < strands; s++) {
            float phase = s * (float)(Math.PI * 2.0 / strands);
            m.push();
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 40.0F + s * 120.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            int nodes = 8;
            for (int n = 0; n < nodes; n++) {
                float frac = (float)n / nodes;
                float r = 0.45F + (float)Math.sin(frac * Math.PI) * 0.08F;
                float y = (frac - 0.5F) * 0.75F;
                float a = frac * (float)Math.PI * 1.5F + phase;

                float x1 = (float)Math.cos(a) * r;
                float z1 = (float)Math.sin(a) * r;
                float x2 = (float)Math.cos(a + 0.25F) * r;
                float z2 = (float)Math.sin(a + 0.25F) * r;

                // Vine segment
                draw3DTaperedSegment(buf, mat, x1, y, z1, 0.018F, x2, y + 0.09F, z2, 0.016F, thornVine, thornVine);

                // Protruding Thorn Spike
                if (n % 2 == 0) {
                    draw3DOctahedron(buf, mat, x1 * 1.08F, y + 0.02F, z1 * 1.08F, 0.012F, 0.035F, 0.012F, thornVine);
                }
                // Floating Blood Drop Gem
                if (n == 4) {
                    draw3DOctahedron(buf, mat, x1 * 1.15F, y + 0.05F, z1 * 1.15F, 0.022F, 0.035F, 0.022F, bloodGem);
                }
            }
            m.pop();
        }
        m.pop();
    }

    // 65. FLOATING KUNAI RING: 8 floating throwing kunai daggers spinning in a lethal orbital circle around waist
    public static void renderFloatingKunaiRing(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int steelBlade = 0xFFD8E2EC;
        int darkWrap = 0xFF181820;
        int glowEdge = accCol;
        int kunaiCount = 8;

        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 110.0F));

        for (int i = 0; i < kunaiCount; i++) {
            float a = (float)(Math.PI * 2.0 * i / kunaiCount);
            float r = 0.52F;
            float kx = (float)Math.cos(a) * r;
            float kz = (float)Math.sin(a) * r;
            float waveY = (float)Math.sin(t * 4.0 + i) * 0.03F;

            m.push();
            m.translate(kx, waveY, kz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) + 90.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // Leaf-shaped Kunai Blade
            draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.06F, 0.028F, 0.006F, 0.065F, steelBlade);
            // Glowing Core Channel
            draw3DBox(buf, mat, -0.005F, -0.003F, 0.02F, 0.005F, 0.003F, 0.08F, glowEdge);
            // Handle with black wrapping
            draw3DBox(buf, mat, -0.010F, -0.008F, -0.045F, 0.010F, 0.008F, 0.0F, darkWrap);
            // Pommel Ring
            draw3DRing(buf, mat, 0.0F, 0.0F, -0.065F, 0.022F, 0.014F, 0.006F, 10, steelBlade);
            m.pop();
        }
        m.pop();
    }

    // 66. ARCANE ORBITAL SHIELDS: 3 hexagonal holographic forcefield barriers rotating defensively
    public static void renderArcaneOrbitalShields(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int barrierGlow = mainCol;
        int borderHex = accCol;
        int shields = 3;

        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-t * 25.0F));

        for (int i = 0; i < shields; i++) {
            float a = (float)(Math.PI * 2.0 * i / shields);
            float r = 0.65F;
            float sx = (float)Math.cos(a) * r;
            float sz = (float)Math.sin(a) * r;
            float sy = (float)Math.sin(t * 2.5 + i * 2.0) * 0.04F;

            m.push();
            m.translate(sx, sy, sz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) - 90.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // Hexagonal Shield Barrier Plate
            draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.16F, 0.22F, 0.012F, barrierGlow);
            // Outer Protective Hex Border Frame
            draw3DBox(buf, mat, -0.17F, -0.23F, -0.008F, 0.17F, 0.23F, 0.008F, borderHex);
            // Center Core Energy Crystal
            draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.015F, 0.035F, 0.045F, 0.015F, 0xFFFFFFFF);
            m.pop();
        }
        m.pop();
    }

    // 67. CYBER HOVER DRONE: Tactical quad-rotor surveillance drone hovering over shoulder with spinning rotors
    public static void renderCyberHoverDrone(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int chassisMetal = 0xFF1C222E;
        int rotorBlade = 0xFF8A95A5;
        int sensorEye = 0xFF00F0FF;
        int navLight = 0xFFFF2040;

        float bob = (float)Math.sin(t * 3.0) * 0.04F;
        m.push();
        m.translate(0.55F, 0.28F + bob, 0.25F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-25.0F + (float)Math.sin(t * 1.2) * 10.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Central Aerodynamic Chassis
        draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.08F, 0.035F, 0.10F, chassisMetal);
        // Forward Camera Sensor Eye
        draw3DOctahedron(buf, mat, 0.0F, -0.01F, 0.095F, 0.022F, 0.022F, 0.015F, sensorEye);

        // 4 Outrigger Arms with Spinning Rotors
        float rotorSpin = t * 900.0F;
        float[][] armOffsets = new float[][]{
            {-0.09F, 0.09F}, {0.09F, 0.09F}, {-0.09F, -0.09F}, {0.09F, -0.09F}
        };

        for (int i = 0; i < 4; i++) {
            float ax = armOffsets[i][0], az = armOffsets[i][1];
            draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.0F, 0.010F, ax, 0.015F, az, 0.008F, chassisMetal, chassisMetal);
            // Rotor Motor Hub
            draw3DCylinder(buf, mat, ax, 0.015F, az, 0.012F, 0.015F, 8, chassisMetal);

            // Spinning Twin-Blade Rotor
            m.push();
            m.translate(ax, 0.03F, az);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotorSpin + i * 45.0F));
            draw3DBox(buf, m.peek().getPositionMatrix(), -0.065F, -0.002F, -0.008F, 0.065F, 0.002F, 0.008F, rotorBlade);
            m.pop();
        }

        // Flashing Strobe LED
        if ((int)(t * 4.0) % 2 == 0) {
            draw3DOctahedron(buf, mat, 0.0F, 0.035F, -0.08F, 0.010F, 0.010F, 0.010F, navLight);
        }
        m.pop();
    }

    // 68. VOID SINGULARITY PET: Miniature floating black hole companion with swirling violet accretion disk
    public static void renderVoidSingularityPet(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int eventHorizon = 0xFF000000;
        int accretionViolet = 0xDD8B2BE2;
        int accretionCyan = 0xAA00F5FF;

        float bob = (float)Math.sin(t * 2.5) * 0.05F;
        m.push();
        m.translate(-0.52F, 0.25F + bob, 0.20F);

        // Swirling Accretion Disc (Tilted 30 deg)
        m.push();
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(35.0F));
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(t * 80.0F));
        Matrix4f discMat = m.peek().getPositionMatrix();
        draw3DRing(buf, discMat, 0.0F, 0.0F, 0.0F, 0.14F, 0.07F, 0.006F, 24, accretionViolet);
        draw3DRing(buf, discMat, 0.0F, 0.0F, 0.0F, 0.17F, 0.13F, 0.004F, 24, accretionCyan);
        m.pop();

        // Gravitational Lensing Photon Ring
        m.push();
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-t * 60.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-45.0F));
        draw3DRing(buf, m.peek().getPositionMatrix(), 0.0F, 0.0F, 0.0F, 0.095F, 0.085F, 0.004F, 20, 0xCCFFFFFF);
        m.pop();

        // Absolute Black Event Horizon Sphere
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.055F, 0.055F, 0.055F, eventHorizon);

        // Relativistic Polar Jet Cones
        float jetPulse = 0.8F + 0.3F * (float)Math.sin(t * 12.0);
        draw3DTaperedSegment(buf, mat, 0.0F, 0.05F, 0.0F, 0.015F, 0.0F, 0.16F * jetPulse, 0.0F, 0.002F, accretionCyan, 0xFFFFFFFF);
        draw3DTaperedSegment(buf, mat, 0.0F, -0.05F, 0.0F, 0.015F, 0.0F, -0.16F * jetPulse, 0.0F, 0.002F, accretionCyan, 0xFFFFFFFF);
        m.pop();
    }

    // 69. GIGA DRILL ARM: Heavy mechanical spiral mining drill mounted on right forearm that spins dynamically
    public static void renderGigaDrillArm(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int industrialSteel = 0xFF353C48;
        int hazardGold = 0xFFE0A010;
        int drillChrome = 0xFFD8E0EE;

        m.push();
        m.translate(0.38F, -0.15F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(20.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        // Mounting Arm Collar with Hazard Bands
        draw3DCylinder(buf, mat, 0.0F, -0.06F, -0.08F, 0.08F, 0.14F, 14, industrialSteel);
        draw3DBox(buf, mat, -0.09F, -0.07F, -0.02F, 0.09F, -0.05F, 0.02F, hazardGold);

        // High-Speed Spinning Conical Spiral Drill
        float drillSpin = t * 450.0F;
        m.push();
        m.translate(0.0F, 0.0F, 0.06F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(drillSpin));

        Matrix4f drillMat = m.peek().getPositionMatrix();
        // 3 Spiral Conical Flute Segments tapering to sharp point
        draw3DTaperedSegment(buf, drillMat, 0.0F, 0.0F, 0.0F, 0.075F, 0.0F, 0.0F, 0.20F, 0.050F, drillChrome, shade(drillChrome, 0.85F));
        draw3DTaperedSegment(buf, drillMat, 0.0F, 0.0F, 0.20F, 0.050F, 0.0F, 0.0F, 0.38F, 0.025F, drillChrome, shade(drillChrome, 0.85F));
        draw3DTaperedSegment(buf, drillMat, 0.0F, 0.0F, 0.38F, 0.025F, 0.0F, 0.0F, 0.52F, 0.003F, drillChrome, 0xFFFFFFFF);

        // Spiral Flute Ribs on Drill Bit
        for (int r = 0; r < 3; r++) {
            float fa = (float)(Math.PI * 2.0 * r / 3.0);
            float fx1 = (float)Math.cos(fa) * 0.075F, fy1 = (float)Math.sin(fa) * 0.075F;
            float fx2 = (float)Math.cos(fa + 1.2F) * 0.025F, fy2 = (float)Math.sin(fa + 1.2F) * 0.025F;
            draw3DTaperedSegment(buf, drillMat, fx1, fy1, 0.02F, 0.012F, fx2, fy2, 0.36F, 0.004F, hazardGold, hazardGold);
        }
        m.pop();
        m.pop();
    }

    // 70. HOLOGRAPHIC WINGS MINI: Floating digital particle mini-wings detached from back fluttering rapidly
    public static void renderHolographicWingsMini(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        int holoCyan = 0xCC00F5FF;
        int holoPink = 0xCCFF1493;

        m.push();
        m.translate(0.0F, 0.04F, 0.16F);

        float flutter = (float)Math.sin(t * 12.0) * 22.0F;

        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.08F, 0.0F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-side * (30.0F + flutter)));
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(side * 12.0F));

            Matrix4f mat = m.peek().getPositionMatrix();
            // 4 Detached Floating Holographic Polygonal Feathers
            for (int f_idx = 0; f_idx < 4; f_idx++) {
                float yOff = f_idx * 0.06F;
                float xOff = f_idx * 0.08F;
                float w = 0.035F;
                int col = (f_idx % 2 == 0) ? holoCyan : holoPink;

                draw3DTaperedSegment(buf, mat, xOff * 0.5F, yOff * 0.5F, 0.0F, w, xOff + 0.16F, yOff + 0.12F, 0.0F, 0.004F, col, 0xEEFFFFFF);
            }
            m.pop();
        }
        m.pop();
    }

    // 71. LUCKY DICE: True 3D tumbling ivory cube with 1-6 pip dots on faces rolling in mid-air
    public static void renderLuckyDice(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float time) {
        m.push();
        m.translate(0.0, 0.42 + Math.sin(time * 3.0) * 0.06, 0.0);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(time * 110.0F));
        m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(time * 85.0F));
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(time * 65.0F));

        Matrix4f mat = m.peek().getPositionMatrix();
        float s = 0.11F;
        int ivory = 0xFFF2EFE9;
        int darkPip = 0xFF181818;
        int acePip = 0xFFDC143C;

        draw3DBox(buf, mat, -s, -s, -s, s, s, s, ivory);

        // Top Face (+Y): 1 Pip (Ace - Crimson)
        drawPipQuad(buf, mat, 0.0F, s + 0.002F, 0.0F, 0.022F, 0.022F, 'Y', acePip);

        // Bottom Face (-Y): 6 Pips (Black)
        float po = s * 0.48F;
        drawPipQuad(buf, mat, -po, -s - 0.002F, -po, 0.016F, 0.016F, 'Y', darkPip);
        drawPipQuad(buf, mat, -po, -s - 0.002F, 0.0F, 0.016F, 0.016F, 'Y', darkPip);
        drawPipQuad(buf, mat, -po, -s - 0.002F, po, 0.016F, 0.016F, 'Y', darkPip);
        drawPipQuad(buf, mat, po, -s - 0.002F, -po, 0.016F, 0.016F, 'Y', darkPip);
        drawPipQuad(buf, mat, po, -s - 0.002F, 0.0F, 0.016F, 0.016F, 'Y', darkPip);
        drawPipQuad(buf, mat, po, -s - 0.002F, po, 0.016F, 0.016F, 'Y', darkPip);

        // Front Face (-Z): 2 Pips (Diagonal, Black)
        drawPipQuad(buf, mat, -po, po, -s - 0.002F, 0.016F, 0.016F, 'Z', darkPip);
        drawPipQuad(buf, mat, po, -po, -s - 0.002F, 0.016F, 0.016F, 'Z', darkPip);

        // Back Face (+Z): 5 Pips (4 corners + center, Black)
        drawPipQuad(buf, mat, -po, po, s + 0.002F, 0.016F, 0.016F, 'Z', darkPip);
        drawPipQuad(buf, mat, po, po, s + 0.002F, 0.016F, 0.016F, 'Z', darkPip);
        drawPipQuad(buf, mat, 0.0F, 0.0F, s + 0.002F, 0.016F, 0.016F, 'Z', darkPip);
        drawPipQuad(buf, mat, -po, -po, s + 0.002F, 0.016F, 0.016F, 'Z', darkPip);
        drawPipQuad(buf, mat, po, -po, s + 0.002F, 0.016F, 0.016F, 'Z', darkPip);

        // Right Face (+X): 3 Pips (Diagonal, Black)
        drawPipQuad(buf, mat, s + 0.002F, po, -po, 0.016F, 0.016F, 'X', darkPip);
        drawPipQuad(buf, mat, s + 0.002F, 0.0F, 0.0F, 0.016F, 0.016F, 'X', darkPip);
        drawPipQuad(buf, mat, s + 0.002F, -po, po, 0.016F, 0.016F, 'X', darkPip);

        // Left Face (-X): 4 Pips (4 corners, Black)
        drawPipQuad(buf, mat, -s - 0.002F, po, -po, 0.016F, 0.016F, 'X', darkPip);
        drawPipQuad(buf, mat, -s - 0.002F, po, po, 0.016F, 0.016F, 'X', darkPip);
        drawPipQuad(buf, mat, -s - 0.002F, -po, -po, 0.016F, 0.016F, 'X', darkPip);
        drawPipQuad(buf, mat, -s - 0.002F, -po, po, 0.016F, 0.016F, 'X', darkPip);

        m.pop();
    }

    public static void drawPipQuad(BufferBuilder b, Matrix4f m, float cx, float cy, float cz, float hw, float hh, char plane, int col) {
        if (plane == 'Y') {
            b.vertex(m, cx - hw, cy, cz - hh).color(col);
            b.vertex(m, cx + hw, cy, cz - hh).color(col);
            b.vertex(m, cx + hw, cy, cz + hh).color(col);
            b.vertex(m, cx - hw, cy, cz + hh).color(col);
        } else if (plane == 'Z') {
            b.vertex(m, cx - hw, cy - hh, cz).color(col);
            b.vertex(m, cx + hw, cy - hh, cz).color(col);
            b.vertex(m, cx + hw, cy + hh, cz).color(col);
            b.vertex(m, cx - hw, cy + hh, cz).color(col);
        } else {
            b.vertex(m, cx, cy - hh, cz - hw).color(col);
            b.vertex(m, cx, cy + hh, cz - hw).color(col);
            b.vertex(m, cx, cy + hh, cz + hw).color(col);
            b.vertex(m, cx, cy - hh, cz + hw).color(col);
        }
    }

    // 72. CYBER HORNS: Sharp neon angular mecha horns
    public static void renderCyberHorns(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.22F, -0.04F);
        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.16F, 0.0F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-side * 28.0F));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(15.0F));
            Matrix4f mat = m.peek().getPositionMatrix();
            draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.0F, 0.04F, side * 0.08F, 0.14F, -0.06F, 0.025F, 0xFF1C1C24, mainCol);
            draw3DTaperedSegment(buf, mat, side * 0.08F, 0.14F, -0.06F, 0.025F, side * 0.18F, 0.30F, -0.12F, 0.005F, mainCol, accCol);
            m.pop();
        }
        m.pop();
    }

    // 73. ONI MASK: Traditional horned demon mask with golden fangs
    public static void renderOniMask(MatrixStack m, BufferBuilder buf, int mainCol, int accCol) {
        m.push();
        m.translate(0.0F, 0.10F, -0.22F);
        Matrix4f mat = m.peek().getPositionMatrix();
        int crimson = 0xFF9E1B1B;
        int gold = 0xFFFFD700;
        int white = 0xFFFFFFFF;
        draw3DBox(buf, mat, -0.16F, -0.12F, -0.04F, 0.16F, 0.10F, 0.0F, crimson);
        // Golden horns
        draw3DTaperedSegment(buf, mat, -0.12F, 0.08F, -0.02F, 0.025F, -0.18F, 0.22F, -0.04F, 0.005F, gold, gold);
        draw3DTaperedSegment(buf, mat, 0.12F, 0.08F, -0.02F, 0.025F, 0.18F, 0.22F, -0.04F, 0.005F, gold, gold);
        // Fangs
        draw3DBox(buf, mat, -0.08F, -0.14F, -0.05F, -0.05F, -0.09F, -0.02F, white);
        draw3DBox(buf, mat, 0.05F, -0.14F, -0.05F, 0.08F, -0.09F, -0.02F, white);
        m.pop();
    }

    // 74. CYBER GOGGLES HUD: High-tech holographic visor with HUD optics
    public static void renderCyberGogglesHUD(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.14F, -0.22F);
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.18F, -0.04F, -0.03F, 0.18F, 0.04F, 0.02F, 0xFF1A1A22);
        draw3DBox(buf, mat, -0.15F, -0.03F, -0.04F, -0.02F, 0.03F, -0.02F, mainCol);
        draw3DBox(buf, mat, 0.02F, -0.03F, -0.04F, 0.15F, 0.03F, -0.02F, mainCol);
        float pulse = (float)Math.sin(t * 6.0) * 0.01F;
        draw3DBox(buf, mat, -0.12F, -0.01F, -0.045F - pulse, -0.05F, 0.01F, -0.035F, accCol);
        draw3DBox(buf, mat, 0.05F, -0.01F, -0.045F - pulse, 0.12F, 0.01F, -0.035F, accCol);
        m.pop();
    }

    // 75. STAR CIRCLET: Constellation tiara with 5 hovering star shards
    public static void renderStarCirclet(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.22F, 0.0F);
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.18F, -0.01F, -0.18F, 0.18F, 0.01F, 0.18F, 0xFFE0C068);
        for (int i = 0; i < 5; i++) {
            double ang = (Math.PI * 2.0 * i / 5.0) + (t * 0.8);
            float sx = (float)Math.cos(ang) * 0.22F;
            float sz = (float)Math.sin(ang) * 0.22F;
            float sy = (float)Math.sin(t * 3.0 + i) * 0.03F + 0.04F;
            draw3DBox(buf, mat, sx - 0.02F, sy - 0.02F, sz - 0.02F, sx + 0.02F, sy + 0.02F, sz + 0.02F, mainCol);
        }
        m.pop();
    }

    // 76. PHANTOM CROWN: Floating dark amethyst crown with spectral flames
    public static void renderPhantomCrown(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.32F + Math.sin(t * 2.0) * 0.03, 0.0F);
        Matrix4f mat = m.peek().getPositionMatrix();
        int darkPurple = 0xFF350A4E;
        for (int i = 0; i < 6; i++) {
            double a = (Math.PI * 2.0 * i / 6.0);
            float cx = (float)Math.cos(a) * 0.16F;
            float cz = (float)Math.sin(a) * 0.16F;
            draw3DTaperedSegment(buf, mat, cx, 0.0F, cz, 0.025F, cx * 1.2F, 0.14F, cz * 1.2F, 0.005F, darkPurple, accCol);
        }
        m.pop();
    }

    // 77. DRAGON EYES BAND: Forehead band with glowing third dragon eye
    public static void renderDragonEyesBand(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.18F, -0.21F);
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.17F, -0.02F, 0.0F, 0.17F, 0.02F, 0.02F, 0xFF2A2A2A);
        // Vertical dragon eye
        draw3DBox(buf, mat, -0.03F, -0.04F, -0.015F, 0.03F, 0.04F, 0.0F, 0xFFFF8C00);
        draw3DBox(buf, mat, -0.008F, -0.035F, -0.02F, 0.008F, 0.035F, -0.01F, 0xFF000000);
        m.pop();
    }

    // 78. CHRONO MONOCLE: Steampunk brass monocle with spinning cogs
    public static void renderChronoMonocle(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.09F, 0.12F, -0.22F);
        Matrix4f mat = m.peek().getPositionMatrix();
        int brass = 0xFFCD7F32;
        draw3DCylinder(buf, mat, 0.0F, 0.0F, 0.0F, 0.05F, 0.015F, 12, brass);
        draw3DBox(buf, mat, -0.035F, -0.035F, -0.005F, 0.035F, 0.035F, 0.005F, 0x8888EEFF);
        m.push();
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(t * 120.0F));
        Matrix4f gMat = m.peek().getPositionMatrix();
        draw3DBox(buf, gMat, -0.04F, -0.005F, -0.01F, 0.04F, 0.005F, 0.0F, brass);
        draw3DBox(buf, gMat, -0.005F, -0.04F, -0.01F, 0.005F, 0.04F, 0.0F, brass);
        m.pop();
        m.pop();
    }

    // 79. CYBER GAUNTLET RIGHT: Armored mech right forearm gauntlet
    public static void renderCyberGauntletRight(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.08F, -0.20F, -0.08F, 0.08F, 0.06F, 0.08F, 0xFF22262E);
        draw3DBox(buf, mat, -0.09F, -0.16F, -0.09F, 0.09F, -0.12F, 0.09F, mainCol);
        draw3DBox(buf, mat, -0.03F, -0.10F, -0.10F, 0.03F, -0.04F, -0.07F, accCol);
        m.pop();
    }

    // 80. CYBER GAUNTLET LEFT: Armored mech left forearm gauntlet
    public static void renderCyberGauntletLeft(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.08F, -0.20F, -0.08F, 0.08F, 0.06F, 0.08F, 0xFF22262E);
        draw3DBox(buf, mat, -0.09F, -0.16F, -0.09F, 0.09F, -0.12F, 0.09F, mainCol);
        draw3DBox(buf, mat, -0.03F, -0.10F, -0.10F, 0.03F, -0.04F, -0.07F, accCol);
        m.pop();
    }

    // 81. FLAME CESTUS: Burning spiked fist weapon tracking arm swings
    public static void renderFlameCestus(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.09F, -0.24F, -0.09F, 0.09F, -0.02F, 0.09F, 0xFF4A1A1A);
        // Spikes on knuckles
        for (int i = -1; i <= 1; i++) {
            draw3DTaperedSegment(buf, mat, i * 0.05F, -0.24F, -0.08F, 0.02F, i * 0.06F, -0.32F, -0.10F, 0.005F, 0xFFFF4500, 0xFFFFD700);
        }
        m.pop();
    }

    // 82. SHIELD BRACER: Armored buckler shield on forearm
    public static void renderShieldBracer(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, 0.08F, -0.18F, -0.12F, 0.11F, 0.06F, 0.12F, 0xFF2F3542);
        draw3DBox(buf, mat, 0.11F, -0.12F, -0.08F, 0.12F, 0.00F, 0.08F, mainCol);
        m.pop();
    }

    // 83. HERMES WINGS BOOTS: Feathered winged ankles fluttering with leg motion
    public static void renderHermesWingsBoots(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, -0.22F, 0.08F);
        float flutter = (float)Math.sin(t * 10.0) * 20.0F;
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(flutter));
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.0F, 0.02F, 0.12F, 0.14F, 0.08F, 0.004F, 0xFFFFD700, 0xFFFFFFFF);
        draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.0F, 0.02F, -0.12F, 0.14F, 0.08F, 0.004F, 0xFFFFD700, 0xFFFFFFFF);
        m.pop();
    }

    // 84. HOVER BOOTS: High-tech anti-grav soles on boots
    public static void renderHoverBoots(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, -0.30F, 0.0F);
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.08F, -0.04F, -0.12F, 0.08F, 0.02F, 0.12F, 0xFF1F2421);
        draw3DBox(buf, mat, -0.06F, -0.05F, -0.10F, 0.06F, -0.03F, 0.10F, mainCol);
        m.pop();
    }

    // 85. SHADOW GREAVES: Obsidian spiked shin guards tracking legs
    public static void renderShadowGreaves(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.08F, -0.26F, -0.09F, 0.08F, 0.02F, 0.08F, 0xFF121216);
        draw3DTaperedSegment(buf, mat, 0.0F, 0.02F, -0.08F, 0.025F, 0.0F, 0.08F, -0.12F, 0.005F, accCol, accCol);
        m.pop();
    }

    // 86. PLASMA CANNON BACK: Twin heavy cannons over shoulders
    public static void renderPlasmaCannonBack(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.18F, 0.14F);
        Matrix4f mat = m.peek().getPositionMatrix();
        for (int side = -1; side <= 1; side += 2) {
            float cx = side * 0.22F;
            draw3DBox(buf, mat, cx - 0.04F, -0.04F, -0.04F, cx + 0.04F, 0.04F, 0.24F, 0xFF2A2D34);
            draw3DBox(buf, mat, cx - 0.03F, -0.03F, -0.18F, cx + 0.03F, 0.03F, -0.04F, 0xFF1B1D22);
            draw3DBox(buf, mat, cx - 0.02F, -0.02F, -0.20F, cx + 0.02F, 0.02F, -0.18F, mainCol);
        }
        m.pop();
    }

    // 87. CYBER JETPACK: Dual-nozzle rocket thrusters on spine
    public static void renderCyberJetpack(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.06F, 0.18F);
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.14F, -0.12F, 0.0F, 0.14F, 0.14F, 0.08F, 0xFF262A33);
        for (int side = -1; side <= 1; side += 2) {
            draw3DCylinder(buf, mat, side * 0.10F, -0.18F, 0.04F, 0.045F, 0.18F, 12, 0xFF1A1C22);
            draw3DBox(buf, mat, side * 0.10F - 0.03F, -0.22F, 0.01F, side * 0.10F + 0.03F, -0.18F, 0.07F, accCol);
        }
        m.pop();
    }

    // 88. TITAN PAULDRONS: Massive tiered shoulder armor
    public static void renderTitanPauldrons(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.22F, 0.0F);
        Matrix4f mat = m.peek().getPositionMatrix();
        for (int side = -1; side <= 1; side += 2) {
            float cx = side * 0.32F;
            draw3DBox(buf, mat, cx - 0.10F, -0.04F, -0.10F, cx + 0.10F, 0.08F, 0.10F, 0xFF3D3D48);
            draw3DTaperedSegment(buf, mat, cx, 0.08F, 0.0F, 0.04F, cx + side * 0.08F, 0.20F, 0.0F, 0.008F, mainCol, accCol);
        }
        m.pop();
    }

    // 89. TAROT CARDS ORBIT: 4 hovering tarot cards revolving with suit symbols
    public static void renderTarotCardsOrbit(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        float radius = 0.65F;
        int count = 4;
        for (int i = 0; i < count; i++) {
            double ang = (Math.PI * 2.0 * i / count) + (t * 0.9);
            float cx = (float)Math.cos(ang) * radius;
            float cz = (float)Math.sin(ang) * radius;
            float cy = (float)Math.sin(t * 2.5 + i) * 0.06F;

            m.push();
            m.translate(cx, cy, cz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-ang) + 90.0F));
            Matrix4f mat = m.peek().getPositionMatrix();
            draw3DBox(buf, mat, -0.06F, -0.09F, -0.002F, 0.06F, 0.09F, 0.002F, 0xFFFFFFFF);
            draw3DBox(buf, mat, -0.05F, -0.08F, 0.003F, 0.05F, 0.08F, 0.004F, 0xFF151515);
            draw3DBox(buf, mat, -0.02F, -0.03F, 0.005F, 0.02F, 0.03F, 0.006F, accCol);
            m.pop();
        }
        m.pop();
    }

    // 90. QUANTUM CUBES: 6 miniature tesseracts orbiting in 3D
    public static void renderQuantumCubes(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        int count = 6;
        for (int i = 0; i < count; i++) {
            double a = (Math.PI * 2.0 * i / count) + (t * 1.2);
            float qx = (float)Math.cos(a) * 0.70F;
            float qz = (float)Math.sin(a) * 0.70F;
            float qy = (float)Math.sin(a * 2.0 + t) * 0.16F;

            m.push();
            m.translate(qx, qy, qz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 180.0F + i * 30.0F));
            Matrix4f mat = m.peek().getPositionMatrix();
            draw3DBox(buf, mat, -0.035F, -0.035F, -0.035F, 0.035F, 0.035F, 0.035F, mainCol);
            draw3DBox(buf, mat, -0.02F, -0.02F, -0.02F, 0.02F, 0.02F, 0.02F, accCol);
            m.pop();
        }
        m.pop();
    }

    // 91. PHOENIX FEATHERS ORBIT: 8 burning golden feather blades revolving
    public static void renderPhoenixFeathersOrbit(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        int count = 8;
        float r = 0.60F;
        for (int i = 0; i < count; i++) {
            double a = (Math.PI * 2.0 * i / count) + (t * 1.4);
            float fx = (float)Math.cos(a) * r;
            float fz = (float)Math.sin(a) * r;

            m.push();
            m.translate(fx, (float)Math.sin(t * 3.0 + i) * 0.05F, fz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.toDegrees(-a) + 90.0F));
            Matrix4f mat = m.peek().getPositionMatrix();
            draw3DTaperedSegment(buf, mat, -0.05F, 0.0F, 0.0F, 0.02F, 0.05F, 0.04F, 0.0F, 0.003F, 0xFFFF4500, 0xFFFFD700);
            m.pop();
        }
        m.pop();
    }

    // 92. DRAGON PEARLS: 3 elemental pearls spiraling in a helix
    public static void renderDragonPearls(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        int[] pearlCols = new int[]{0xFFFF2A2A, 0xFF00E5FF, 0xFFFFDF00};
        for (int i = 0; i < 3; i++) {
            double a = (Math.PI * 2.0 * i / 3.0) + (t * 1.8);
            float px = (float)Math.cos(a) * 0.55F;
            float pz = (float)Math.sin(a) * 0.55F;
            float py = (float)Math.sin(a * 2.0) * 0.22F;

            m.push();
            m.translate(px, py, pz);
            Matrix4f mat = m.peek().getPositionMatrix();
            draw3DBox(buf, mat, -0.04F, -0.04F, -0.04F, 0.04F, 0.04F, 0.04F, pearlCols[i]);
            m.pop();
        }
        m.pop();
    }

    // 93. ARCANE PENTAGRAM: Rotating arcane pentagram ring at waist
    public static void renderArcanePentagram(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, -0.08F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(t * 40.0F));
        Matrix4f mat = m.peek().getPositionMatrix();
        float r = 0.55F;
        int points = 5;
        for (int i = 0; i < points; i++) {
            double a1 = (Math.PI * 2.0 * i / points);
            double a2 = (Math.PI * 2.0 * ((i + 2) % points) / points);
            float x1 = (float)Math.cos(a1) * r, z1 = (float)Math.sin(a1) * r;
            float x2 = (float)Math.cos(a2) * r, z2 = (float)Math.sin(a2) * r;
            draw3DTaperedSegment(buf, mat, x1, 0.0F, z1, 0.012F, x2, 0.0F, z2, 0.012F, mainCol, accCol);
        }
        m.pop();
    }

    // 94. VOID RIFT RING: Distorted gravitational accretion ring
    public static void renderVoidRiftRing(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.02F, 0.0F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-t * 60.0F));
        Matrix4f mat = m.peek().getPositionMatrix();
        int segs = 16;
        float r = 0.58F;
        for (int i = 0; i < segs; i++) {
            double a = (Math.PI * 2.0 * i / segs);
            float rx = (float)Math.cos(a) * r;
            float rz = (float)Math.sin(a) * r;
            draw3DBox(buf, mat, rx - 0.025F, -0.015F, rz - 0.025F, rx + 0.025F, 0.015F, rz + 0.025F, (i % 2 == 0) ? 0xFF0D0221 : accCol);
        }
        m.pop();
    }

    // 95. SOLAR FLARE HALO: Blazing sun corona disk behind upper body
    public static void renderSolarFlareHalo(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.0F, 0.20F, 0.16F);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(t * 45.0F));
        Matrix4f mat = m.peek().getPositionMatrix();
        for (int i = 0; i < 12; i++) {
            double a = (Math.PI * 2.0 * i / 12.0);
            float rInner = 0.28F;
            float rOuter = 0.44F + (float)Math.sin(t * 8.0 + i) * 0.05F;
            float x1 = (float)Math.cos(a) * rInner, y1 = (float)Math.sin(a) * rInner;
            float x2 = (float)Math.cos(a) * rOuter, y2 = (float)Math.sin(a) * rOuter;
            draw3DTaperedSegment(buf, mat, x1, y1, 0.0F, 0.025F, x2, y2, 0.0F, 0.005F, 0xFFFF4500, 0xFFFFD700);
        }
        m.pop();
    }

    // 96. CYBER FOX PET: Robotic fox companion hovering beside shoulder
    public static void renderCyberFoxPet(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.55F, 0.15F + Math.sin(t * 2.2) * 0.08, 0.10F);
        Matrix4f mat = m.peek().getPositionMatrix();
        int bodyCol = 0xFF2C3E50;
        int neonCol = mainCol;
        // Head & body
        draw3DBox(buf, mat, -0.06F, -0.06F, -0.08F, 0.06F, 0.06F, 0.08F, bodyCol);
        // Snout
        draw3DBox(buf, mat, -0.03F, -0.05F, -0.14F, 0.03F, 0.00F, -0.08F, 0xFF1A252F);
        // Ears
        draw3DTaperedSegment(buf, mat, -0.04F, 0.06F, -0.02F, 0.02F, -0.06F, 0.14F, -0.02F, 0.005F, bodyCol, neonCol);
        draw3DTaperedSegment(buf, mat, 0.04F, 0.06F, -0.02F, 0.02F, 0.06F, 0.14F, -0.02F, 0.005F, bodyCol, neonCol);
        // Tail
        float tailWag = (float)Math.sin(t * 6.0) * 0.04F;
        draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.08F, 0.025F, tailWag, 0.10F, 0.20F, 0.008F, bodyCol, accCol);
        m.pop();
    }

    // 97. DRAGON WHELP PET: Baby dragon companion with flapping wings
    public static void renderDragonWhelpPet(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(-0.55F, 0.18F + Math.sin(t * 2.5) * 0.08, 0.10F);
        Matrix4f mat = m.peek().getPositionMatrix();
        int dCol = 0xFF8B0000;
        draw3DBox(buf, mat, -0.06F, -0.06F, -0.08F, 0.06F, 0.06F, 0.08F, dCol);
        draw3DBox(buf, mat, -0.04F, 0.0F, -0.14F, 0.04F, 0.05F, -0.08F, dCol);
        // Wings flapping
        float wingFlap = (float)Math.sin(t * 12.0) * 35.0F;
        for (int side = -1; side <= 1; side += 2) {
            m.push();
            m.translate(side * 0.06F, 0.04F, 0.0F);
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(side * wingFlap));
            Matrix4f wMat = m.peek().getPositionMatrix();
            draw3DTaperedSegment(buf, wMat, 0.0F, 0.0F, 0.0F, 0.02F, side * 0.16F, 0.08F, -0.04F, 0.005F, dCol, 0xFFFF4500);
            m.pop();
        }
        m.pop();
    }

    // 98. SPIRIT WISP PET: Ethereal soul flame orb with trailing tail
    public static void renderSpiritWispPet(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(0.50F + Math.cos(t * 1.5) * 0.12, 0.25F + Math.sin(t * 2.8) * 0.10, -0.10F);
        Matrix4f mat = m.peek().getPositionMatrix();
        int wispCyan = 0xEE00F5FF;
        draw3DBox(buf, mat, -0.05F, -0.05F, -0.05F, 0.05F, 0.05F, 0.05F, wispCyan);
        draw3DTaperedSegment(buf, mat, 0.0F, 0.0F, 0.0F, 0.04F, (float)Math.sin(t * 4.0) * 0.05F, -0.14F, 0.06F, 0.005F, wispCyan, 0x00FFFFFF);
        m.pop();
    }

    // 99. CYBER SKULL PET: Floating chrome skull with glowing red visor
    public static void renderCyberSkullPet(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        m.translate(-0.50F, 0.22F + Math.sin(t * 2.0) * 0.06, -0.12F);
        m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(20.0F + (float)Math.sin(t * 1.8) * 15.0F));
        Matrix4f mat = m.peek().getPositionMatrix();
        int chrome = 0xFFD8D8E0;
        draw3DBox(buf, mat, -0.07F, -0.06F, -0.07F, 0.07F, 0.06F, 0.07F, chrome);
        draw3DBox(buf, mat, -0.05F, -0.10F, -0.05F, 0.05F, -0.06F, 0.02F, 0xFF9E9EA8);
        draw3DBox(buf, mat, -0.06F, -0.01F, -0.075F, 0.06F, 0.02F, -0.065F, 0xFFFF0033);
        m.pop();
    }

    // 100. SLIME COMPANION: Bouncing translucent jelly companion
    public static void renderSlimeCompanion(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        m.push();
        float bounce = (float)Math.abs(Math.sin(t * 4.0)) * 0.12F;
        float squish = 1.0F + (float)Math.cos(t * 8.0) * 0.15F;
        m.translate(0.48F, 0.10F + bounce, 0.15F);
        m.scale(1.0F / squish, squish, 1.0F / squish);
        Matrix4f mat = m.peek().getPositionMatrix();
        int slimeGreen = 0xCC00FF7F;
        int darkGreen = 0xEE008B45;
        draw3DBox(buf, mat, -0.07F, -0.07F, -0.07F, 0.07F, 0.07F, 0.07F, slimeGreen);
        draw3DBox(buf, mat, -0.04F, -0.04F, -0.04F, 0.04F, 0.04F, 0.04F, darkGreen);
        // Cute eyes
        draw3DBox(buf, mat, -0.04F, 0.01F, -0.075F, -0.02F, 0.04F, -0.065F, 0xFF000000);
        draw3DBox(buf, mat, 0.02F, 0.01F, -0.075F, 0.04F, 0.04F, -0.065F, 0xFF000000);
        m.pop();
    }


    // 59. NEBULA CAPE: Ethereal flowing starlight cloak with cosmic dust particles
    public static void renderNebulaCape(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int layers = 6;
        for (int l = 0; l < layers; l++) {
            float yTop = 0.38F - l * 0.14F;
            float yBot = yTop - 0.14F;
            float width = 0.22F + l * 0.035F;
            float wave = (float)Math.sin(t * 2.5F + l * 0.6F) * (0.02F + l * 0.015F);
            float zPos = -0.16F - (l * 0.035F) - wave;
            int alpha = (int)(220 * (1.0F - (l * 0.11F)));
            int col = (mainCol & 0x00FFFFFF) | (alpha << 24);
            draw3DBox(buf, mat, -width, yBot, zPos, width, yTop, zPos + 0.016F, col);
            if (l % 2 == 0) {
                draw3DBox(buf, mat, -width * 0.6F, yBot + 0.05F, zPos - 0.008F, -width * 0.6F + 0.025F, yBot + 0.075F, zPos + 0.02F, 0xFFFFFFFF);
                draw3DBox(buf, mat, width * 0.6F - 0.025F, yBot + 0.03F, zPos - 0.008F, width * 0.6F, yBot + 0.055F, zPos + 0.02F, accCol);
            }
        }
    }

    // 60. CELESTIAL AEGIS BACK: Massive rotating golden fortress shield with runic inlays
    public static void renderCelestialAegisBack(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int gold = 0xFFFFD700;
        int darkBronze = 0xFF3D2E12;
        draw3DBox(buf, mat, -0.20F, 0.08F, -0.20F, 0.20F, 0.52F, -0.16F, darkBronze);
        draw3DBox(buf, mat, -0.16F, 0.12F, -0.21F, 0.16F, 0.48F, -0.17F, gold);
        draw3DBox(buf, mat, -0.22F, 0.44F, -0.22F, 0.22F, 0.54F, -0.17F, mainCol);
        draw3DBox(buf, mat, -0.14F, 0.00F, -0.22F, 0.14F, 0.10F, -0.17F, mainCol);
        float pulse = (float)Math.sin(t * 3.5F) * 0.015F;
        draw3DBox(buf, mat, -0.06F - pulse, 0.24F - pulse, -0.23F, 0.06F + pulse, 0.36F + pulse, -0.19F, accCol);
    }

    // 61. ARCANE RUNE CLOAK: Orbiting floating runic tablets linked by light arcs
    public static void renderArcaneRuneCloak(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int tablets = 8;
        for (int i = 0; i < tablets; i++) {
            double angle = (Math.PI * 2.0 * i) / tablets + (t * 0.8F);
            float rx = (float)Math.cos(angle) * 0.36F;
            float rz = (float)Math.sin(angle) * 0.30F - 0.05F;
            float ry = 0.20F + (float)Math.sin(t * 2.0F + i) * 0.06F;
            draw3DBox(buf, mat, rx - 0.035F, ry - 0.055F, rz - 0.012F, rx + 0.035F, ry + 0.055F, rz + 0.012F, 0xFF1A1C28);
            draw3DBox(buf, mat, rx - 0.022F, ry - 0.035F, rz - 0.016F, rx + 0.022F, ry + 0.035F, rz + 0.016F, accCol);
        }
    }

    // 62. CYBER BATTERY PACK: Heavy sci-fi reactor core with animated pulsing LED fuel rods & exhaust vents
    public static void renderCyberBatteryPack(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int chassis = 0xFF14171F;
        int titanium = 0xFF4A5265;
        draw3DBox(buf, mat, -0.18F, 0.10F, -0.24F, 0.18F, 0.46F, -0.16F, chassis);
        draw3DBox(buf, mat, -0.15F, 0.13F, -0.25F, 0.15F, 0.43F, -0.20F, titanium);
        for (int c = 0; c < 3; c++) {
            float cx = -0.10F + c * 0.10F;
            float fuelPulse = 0.5F + 0.5F * (float)Math.sin(t * 5.0F + c * 1.5F);
            int cellCol = (fuelPulse > 0.5F) ? accCol : mainCol;
            draw3DBox(buf, mat, cx - 0.025F, 0.16F, -0.27F, cx + 0.025F, 0.40F, -0.23F, cellCol);
        }
        draw3DBox(buf, mat, -0.16F, 0.46F, -0.22F, -0.06F, 0.52F, -0.18F, 0xFF0B0D12);
        draw3DBox(buf, mat, 0.06F, 0.46F, -0.22F, 0.16F, 0.52F, -0.18F, 0xFF0B0D12);
    }

    // 63. ASTRAL CONSTELLATION RIBS: Glowing cosmic ribcage armor
    public static void renderAstralConstellationRibs(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int ribs = 5;
        for (int r = 0; r < ribs; r++) {
            float ry = 0.12F + r * 0.075F;
            float curve = 0.20F + (float)Math.sin(r * 0.7F) * 0.05F;
            float pulse = (float)Math.sin(t * 3.0F + r) * 0.01F;
            draw3DBox(buf, mat, -curve - pulse, ry, -0.14F, -0.04F, ry + 0.025F, 0.12F, mainCol);
            draw3DBox(buf, mat, -curve - pulse - 0.02F, ry - 0.01F, 0.02F, -curve - pulse + 0.01F, ry + 0.035F, 0.06F, 0xFFFFFFFF);
            draw3DBox(buf, mat, 0.04F, ry, -0.14F, curve + pulse, ry + 0.025F, 0.12F, mainCol);
            draw3DBox(buf, mat, curve + pulse - 0.01F, ry - 0.01F, 0.02F, curve + pulse + 0.02F, ry + 0.035F, 0.06F, 0xFFFFFFFF);
        }
        draw3DBox(buf, mat, -0.025F, 0.08F, -0.16F, 0.025F, 0.50F, -0.13F, accCol);
    }

    // 64. DRAGON BONE WINGS: Skeletal dragon rib wings with glowing marrow fire
    public static void renderDragonBoneWings(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int boneCol = 0xFFEDE7D8;
        int darkBone = 0xFF5A4D3B;
        float flap = (float)Math.sin(t * 4.0F) * 0.06F;
        draw3DBox(buf, mat, -0.42F - flap, 0.30F, -0.18F, -0.06F, 0.36F, -0.14F, boneCol);
        draw3DBox(buf, mat, -0.62F - flap * 1.5F, 0.44F, -0.22F, -0.38F, 0.49F, -0.16F, boneCol);
        draw3DBox(buf, mat, -0.58F - flap * 1.4F, 0.16F, -0.20F, -0.36F, 0.20F, -0.15F, darkBone);
        draw3DBox(buf, mat, -0.46F - flap, 0.04F, -0.18F, -0.28F, 0.08F, -0.14F, darkBone);
        draw3DBox(buf, mat, -0.54F - flap * 1.2F, 0.32F, -0.19F, -0.18F, 0.34F, -0.17F, accCol);

        draw3DBox(buf, mat, 0.06F, 0.30F, -0.18F, 0.42F + flap, 0.36F, -0.14F, boneCol);
        draw3DBox(buf, mat, 0.38F, 0.44F, -0.22F, 0.62F + flap * 1.5F, 0.49F, -0.16F, boneCol);
        draw3DBox(buf, mat, 0.36F, 0.16F, -0.20F, 0.58F + flap * 1.4F, 0.20F, -0.15F, darkBone);
        draw3DBox(buf, mat, 0.28F, 0.04F, -0.18F, 0.46F + flap, 0.08F, -0.14F, darkBone);
        draw3DBox(buf, mat, 0.18F, 0.32F, -0.19F, 0.54F + flap * 1.2F, 0.34F, -0.17F, accCol);
    }

    // 58. QUANTUM SINGULARITY ORB: Miniature event-horizon black hole with spinning rings
    public static void renderQuantumSingularityOrb(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        draw3DBox(buf, mat, -0.07F, 0.48F, -0.25F, 0.07F, 0.62F, -0.11F, 0xFF050508);
        draw3DBox(buf, mat, -0.05F, 0.50F, -0.23F, 0.05F, 0.60F, -0.13F, 0xFF000000);
        float r1 = 0.13F;
        float rPulse = (float)Math.sin(t * 4.0F) * 0.015F;
        draw3DBox(buf, mat, -r1 - rPulse, 0.54F, -r1 - 0.18F, r1 + rPulse, 0.56F, r1 - 0.18F, accCol);
        draw3DBox(buf, mat, -0.10F, 0.50F, -0.10F - 0.18F, 0.10F, 0.60F, 0.10F - 0.18F, mainCol);
    }

    // 97. PHOENIX CREST CROWN: Blazing multi-tiered crown plume with animated fire tips
    public static void renderPhoenixCrestCrown(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int gold = 0xFFFFD700;
        int ruby = 0xFFFF2200;
        int amber = 0xFFFFB300;
        draw3DBox(buf, mat, -0.26F, 0.22F, -0.26F, 0.26F, 0.27F, 0.26F, gold);
        float flap1 = (float)Math.sin(t * 5.0F) * 0.03F;
        draw3DBox(buf, mat, -0.04F, 0.27F, -0.28F, 0.04F, 0.52F + flap1, -0.24F, ruby);
        draw3DBox(buf, mat, -0.02F, 0.50F + flap1, -0.27F, 0.02F, 0.60F + flap1 * 1.5F, -0.25F, amber);
        draw3DBox(buf, mat, -0.16F, 0.25F, -0.27F, -0.08F, 0.44F + flap1 * 0.7F, -0.24F, amber);
        draw3DBox(buf, mat, 0.08F, 0.25F, -0.27F, 0.16F, 0.44F + flap1 * 0.7F, -0.24F, amber);
    }

    // 98. CHRONO RELIC CLOCK: Floating ancient astrolabe timepiece with turning gears
    public static void renderChronoRelicClock(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int brass = 0xFFC5A059;
        int darkBrass = 0xFF4A3B1F;
        int gold = 0xFFFFD700;
        float bob = (float)Math.sin(t * 2.5F) * 0.04F;
        draw3DBox(buf, mat, 0.35F, 0.25F + bob, -0.10F, 0.65F, 0.55F + bob, 0.00F, brass);
        draw3DBox(buf, mat, 0.38F, 0.28F + bob, -0.11F, 0.62F, 0.52F + bob, -0.01F, darkBrass);
        float hourA = t * 1.5F;
        float minA = t * 6.0F;
        float hx = (float)Math.cos(hourA) * 0.07F;
        float hy = (float)Math.sin(hourA) * 0.07F;
        draw3DBox(buf, mat, 0.50F, 0.40F + bob, -0.13F, 0.50F + hx, 0.40F + bob + hy, -0.09F, 0xFFFFFFFF);
        float mx = (float)Math.cos(minA) * 0.10F;
        float my = (float)Math.sin(minA) * 0.10F;
        draw3DBox(buf, mat, 0.50F, 0.40F + bob, -0.13F, 0.50F + mx, 0.40F + bob + my, -0.09F, accCol);
        float pend = (float)Math.sin(t * 3.0F) * 0.05F;
        draw3DBox(buf, mat, 0.49F + pend, 0.12F + bob, -0.06F, 0.51F + pend, 0.25F + bob, -0.04F, brass);
        draw3DBox(buf, mat, 0.47F + pend, 0.08F + bob, -0.07F, 0.53F + pend, 0.14F + bob, -0.03F, gold);
    }

    // 99. SPIRIT FOX LANTERN: Floating ethereal Japanese shinto lantern trailing spirit will-o-wisps
    public static void renderSpiritFoxLantern(MatrixStack m, BufferBuilder buf, int mainCol, int accCol, float t) {
        Matrix4f mat = m.peek().getPositionMatrix();
        int cedar = 0xFF5D2E16;
        int paper = 0xFFFFF5E6;
        float bob = (float)Math.sin(t * 2.0F) * 0.05F;
        draw3DBox(buf, mat, -0.58F, 0.48F + bob, 0.12F, -0.38F, 0.54F + bob, 0.32F, cedar);
        float flicker = 0.85F + 0.15F * (float)Math.sin(t * 12.0F);
        int glow = (accCol & 0x00FFFFFF) | ((int)(255 * flicker) << 24);
        draw3DBox(buf, mat, -0.55F, 0.30F + bob, 0.15F, -0.41F, 0.48F + bob, 0.29F, paper);
        draw3DBox(buf, mat, -0.52F, 0.34F + bob, 0.18F, -0.44F, 0.44F + bob, 0.26F, glow);
        draw3DBox(buf, mat, -0.57F, 0.26F + bob, 0.13F, -0.39F, 0.30F + bob, 0.31F, cedar);
        float o1x = -0.48F + (float)Math.cos(t * 3.0F) * 0.08F;
        float o1y = 0.20F + bob + (float)Math.sin(t * 3.0F) * 0.06F;
        draw3DBox(buf, mat, o1x - 0.02F, o1y - 0.02F, 0.22F - 0.02F, o1x + 0.02F, o1y + 0.02F, 0.22F + 0.02F, 0xFF00FFCC);
    }

}
