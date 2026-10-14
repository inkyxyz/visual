package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec2f;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.Rect;

public class IiiIIiIiI_Class203 extends Rect {
    private final String I_field_523beb0a;
    private final float I_field_46;
    private final Runnable I_field_bac0a97e;
    private final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(58.0f, 58.0f, 58.0f);
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(400L, 0.0f, IiiiIiiII_Class237.I_field_dd60aac);
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
    private float smoothHover = 0.0F;

    public void renderIcon(III iII, float f, boolean isHovered) {
        this.smoothHover += ((isHovered ? 1.0F : 0.0F) - this.smoothHover) * 0.22F;
        float alpha = f;
        float scale = 1.0F + 0.08F * this.smoothHover;

        float iconSize = 16.0F * scale;
        float ix = this.x + 18.0F;
        float iy = this.y + (this.height - iconSize) / 2.0F;

        boolean isQuit = this.I_field_523beb0a.toLowerCase().contains("quit");
        if (this.smoothHover > 0.01F) {
            ColorRGBA glow = isQuit
                ? new ColorRGBA(255.0F, 40.0F, 65.0F, 150.0F * this.smoothHover * alpha)
                : IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(90.0F * this.smoothHover * alpha);
            iII.drawBlurredRect(ix - 3.0F, iy - 3.0F, iconSize + 6.0F, iconSize + 6.0F, 8.0F, IIiii_Class8.I_method_893b2757((iconSize + 6.0F) / 2.0F), glow);
        }

        ColorRGBA col;
        if (isQuit) {
            col = isHovered ? ColorRGBA.WHITE : new ColorRGBA(255.0F, 220.0F, 225.0F, 225.0F * alpha);
        } else {
            col = isHovered ? ColorRGBA.WHITE : ColorRGBA.WHITE.withAlpha(200.0F * alpha);
        }
        drawVectorIcon(iII, this.I_field_523beb0a, ix, iy, iconSize, col);
    }

    private void drawVectorIcon(III iII, String path, float x, float y, float size, ColorRGBA col) {
        String lower = path.toLowerCase();
        float cx = x + size / 2.0F;
        float cy = y + size / 2.0F;

        if (lower.contains("single")) {
            // Elegant Minecraft Isometric Block Icon
            float s = size * 0.36F;
            float topY = cy - s * 0.85F;
            float midY = cy + s * 0.12F;
            float botY = cy + s * 1.05F;
            float leftX = cx - s * 0.95F;
            float rightX = cx + s * 0.95F;
            float midL = cy - s * 0.36F;
            float botL = cy + s * 0.58F;

            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
            BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
            Matrix4f mat = iII.getMatrices().peek().getPositionMatrix();

            int cTop = col.getRGB();
            int cLeft = col.withAlpha(col.getAlpha() * 0.72F).getRGB();
            int cRight = col.withAlpha(col.getAlpha() * 0.50F).getRGB();

            // Top Face (Rhombus)
            bb.vertex(mat, cx, topY, 0.0F).color(cTop);
            bb.vertex(mat, leftX, midL, 0.0F).color(cTop);
            bb.vertex(mat, cx, midY, 0.0F).color(cTop);

            bb.vertex(mat, cx, topY, 0.0F).color(cTop);
            bb.vertex(mat, cx, midY, 0.0F).color(cTop);
            bb.vertex(mat, rightX, midL, 0.0F).color(cTop);

            // Left Face (Parallelogram)
            bb.vertex(mat, leftX, midL, 0.0F).color(cLeft);
            bb.vertex(mat, leftX, botL, 0.0F).color(cLeft);
            bb.vertex(mat, cx, botY, 0.0F).color(cLeft);

            bb.vertex(mat, leftX, midL, 0.0F).color(cLeft);
            bb.vertex(mat, cx, botY, 0.0F).color(cLeft);
            bb.vertex(mat, cx, midY, 0.0F).color(cLeft);

            // Right Face (Parallelogram)
            bb.vertex(mat, cx, midY, 0.0F).color(cRight);
            bb.vertex(mat, cx, botY, 0.0F).color(cRight);
            bb.vertex(mat, rightX, botL, 0.0F).color(cRight);

            bb.vertex(mat, cx, midY, 0.0F).color(cRight);
            bb.vertex(mat, rightX, botL, 0.0F).color(cRight);
            bb.vertex(mat, rightX, midL, 0.0F).color(cRight);

            BuiltBuffer built = bb.endNullable();
            if (built != null) BufferRenderer.drawWithGlobalProgram(built);
        } else if (lower.contains("multi")) {
            // Minimalist Twin Silhouette / Network
            float r1 = size * 0.16F;
            // Primary user (left)
            float u1x = cx - size * 0.16F;
            float u1y = cy - size * 0.14F;
            iII.drawRoundedRect(u1x - r1, u1y - r1, r1 * 2.0F, r1 * 2.0F, IIiii_Class8.I_method_893b2757(r1), col);
            // Torso arc
            iII.drawRoundedRect(u1x - size * 0.26F, u1y + r1 + 2.0F, size * 0.52F, size * 0.24F, IIiii_Class8.I_method_893b2757(2.5F), col);

            // Secondary user (right offset)
            float r2 = size * 0.13F;
            float u2x = cx + size * 0.22F;
            float u2y = cy - size * 0.18F;
            ColorRGBA col2 = col.withAlpha(col.getAlpha() * 0.70F);
            iII.drawRoundedRect(u2x - r2, u2y - r2, r2 * 2.0F, r2 * 2.0F, IIiii_Class8.I_method_893b2757(r2), col2);
            iII.drawRoundedRect(u2x - size * 0.18F, u2y + r2 + 2.0F, size * 0.38F, size * 0.20F, IIiii_Class8.I_method_893b2757(2.0F), col2);
        } else if (lower.contains("alt")) {
            // Minimalist Profile Switcher Avatar
            float headR = size * 0.22F;
            float headY = cy - size * 0.15F;
            iII.drawRoundedRect(cx - headR, headY - headR, headR * 2.0F, headR * 2.0F, IIiii_Class8.I_method_893b2757(headR), col);

            // Smooth minimalist torso arc
            float torsoW = size * 0.72F;
            float torsoH = size * 0.26F;
            float torsoY = headY + headR + 2.5F;
            iII.drawRoundedRect(cx - torsoW / 2.0F, torsoY, torsoW, torsoH, IIiii_Class8.I_method_893b2757(3.5F), col);

            // Micro swap indicator dot
            iII.drawRoundedRect(cx + headR + 1.0F, headY - 1.0F, 2.5F, 2.5F, IIiii_Class8.I_method_893b2757(1.25F), IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(col.getAlpha()));
        } else if (lower.contains("settings")) {
            // Minimalist Sliders / Preferences Controls
            float lineW = size * 0.76F;
            float lineH = 1.8F;
            float lx = cx - lineW / 2.0F;

            // Top slider line + knob
            float y1 = cy - size * 0.25F;
            iII.drawRoundedRect(lx, y1, lineW, lineH, IIiii_Class8.I_method_893b2757(0.9F), col.withAlpha(col.getAlpha() * 0.65F));
            float knob1X = lx + lineW * 0.28F;
            iII.drawRoundedRect(knob1X - 2.5F, y1 - 2.0F, 5.0F, 5.8F, IIiii_Class8.I_method_893b2757(1.5F), col);

            // Bottom slider line + knob
            float y2 = cy + size * 0.25F;
            iII.drawRoundedRect(lx, y2, lineW, lineH, IIiii_Class8.I_method_893b2757(0.9F), col.withAlpha(col.getAlpha() * 0.65F));
            float knob2X = lx + lineW * 0.72F;
            iII.drawRoundedRect(knob2X - 2.5F, y2 - 2.0F, 5.0F, 5.8F, IIiii_Class8.I_method_893b2757(1.5F), col);
        } else if (lower.contains("quit")) {
            // Stylish Minimalist Close Cross (✕) with smooth rounded caps
            float armLen = size * 0.54F;
            float thickness = 1.9F;

            MatrixStack matrices = iII.getMatrices();
            matrices.push();
            matrices.translate(cx, cy, 0.0F);
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45.0F));

            IIiii_Class8 capRad = IIiii_Class8.I_method_893b2757(thickness / 2.0F);

            // Horizontal & vertical bars rotated 45° = clean geometric ✕
            iII.drawRoundedRect(-armLen / 2.0F, -thickness / 2.0F, armLen, thickness, capRad, col);
            iII.drawRoundedRect(-thickness / 2.0F, -armLen / 2.0F, thickness, armLen, capRad, col);

            matrices.pop();
        } else if (lower.contains("desktop")) {
            // Minimalist Desktop / Monitor Icon
            float monW = size * 0.76F;
            float monH = size * 0.50F;
            float monX = cx - monW / 2.0F;
            float monY = cy - size * 0.35F;
            iII.drawRoundedBorder(monX, monY, monW, monH, 1.2F, IIiii_Class8.I_method_893b2757(2.5F), col);
            // Stand stem & base
            iII.drawRect(cx - 1.0F, monY + monH, 2.0F, size * 0.16F, col);
            float baseW = size * 0.44F;
            iII.drawRoundedRect(cx - baseW / 2.0F, monY + monH + size * 0.14F, baseW, 1.5F, IIiii_Class8.I_method_893b2757(0.7F), col);
        } else {
            iII.drawTexture(RockstarClient.id(path), x, y, size, size, col);
        }
    }

    public void I_method_b0823999(III iII, float f) {
        boolean bl = this.hovered(iII.I_method_b1c3e152(), iII.i_method_b1d26d32()) && f > 0.1f;
        if (bl && f > 0.5f) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
        }
        this.i_field_dc7facc.I_method_edd72835(bl);
        float radius = 7.0f;
        float alpha = f;
        float hover = this.i_field_dc7facc.I_method_6ac4da6f();
        IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(radius);
        boolean isQuit = this.I_field_523beb0a.toLowerCase().contains("quit");

        if (isQuit) {
            // Red Frosted Glass Exit Button
            if (hover > 0.01F) {
                iII.drawBlurredRect(this.x - 3.0F, this.y - 3.0F, this.width + 6.0F, this.height + 6.0F, 12.0F, IIiii_Class8.I_method_893b2757((this.width + 6.0F) / 2.0F), new ColorRGBA(255.0F, 35.0F, 60.0F, 140.0F * hover * alpha));
            }
            iII.drawBlurredRect(this.x, this.y, this.width, this.height, 8.0F, rad, ColorRGBA.WHITE.withAlpha(35.0F * alpha));

            ColorRGBA redGlassFill = bl
                ? new ColorRGBA(225.0F, 35.0F, 55.0F, (0.42F + 0.38F * hover) * 255.0F * alpha)
                : new ColorRGBA(210.0F, 32.0F, 50.0F, (0.18F * alpha + 0.15F * hover * alpha) * 255.0F);
            iII.drawRoundedRect(this.x, this.y, this.width, this.height, rad, redGlassFill);

            ColorRGBA redGlassBorder = bl
                ? new ColorRGBA(255.0F, 110.0F, 130.0F, 240.0F * alpha)
                : new ColorRGBA(255.0F, 85.0F, 105.0F, 110.0F * alpha);
            iII.drawRoundedBorder(this.x, this.y, this.width, this.height, 1.2F, rad, redGlassBorder);
        } else {
            iII.drawBlurredRect(this.x, this.y, this.width, this.height, 8.0F, rad, ColorRGBA.WHITE.withAlpha(35.0F * alpha));
            ColorRGBA glassFill = new ColorRGBA(255.0F, 255.0F, 255.0F, (0.08F * alpha + 0.14F * hover * alpha) * 255.0F);
            iII.drawRoundedRect(this.x, this.y, this.width, this.height, rad, glassFill);
            ColorRGBA glassBorder = new ColorRGBA(255.0F, 255.0F, 255.0F, (0.16F * alpha + 0.35F * hover * alpha) * 255.0F);
            iII.drawRoundedBorder(this.x, this.y, this.width, this.height, 1.0F, rad, glassBorder);
        }
        renderIcon(iII, f, bl);
    }

    public void I_method_f3cf064(double d, double d2, int n) {
        if (this.hovered(d, d2) && n == 0) {
            this.I_field_bac0a97e.run();
        }
    }

    private String label = "";

    public IiiIIiIiI_Class203(String string, String label, float f, Runnable runnable) {
        this.I_field_523beb0a = string;
        this.label = label != null ? label : "";
        this.I_field_46 = f;
        this.I_field_bac0a97e = runnable;
    }

    public IiiIIiIiI_Class203(String string, float f, Runnable runnable) {
        this(string, "", f, runnable);
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIconPath() {
        return this.I_field_523beb0a;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_86c997b5() {
        return this.I_field_dc7facc;
    }
}
