package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
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
        float ix = this.x + (this.width - iconSize) / 2.0F;
        float iy = this.y + (this.height - iconSize) / 2.0F;

        if (this.smoothHover > 0.01F) {
            ColorRGBA glow = IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(90.0F * this.smoothHover * alpha);
            iII.drawBlurredRect(ix - 3.0F, iy - 3.0F, iconSize + 6.0F, iconSize + 6.0F, 8.0F, IIiii_Class8.I_method_893b2757((iconSize + 6.0F) / 2.0F), glow);
        }

        ColorRGBA col = isHovered ? ColorRGBA.WHITE : ColorRGBA.WHITE.withAlpha(200.0F * alpha);
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
            // Minimalist Clean Power Ring & Bar
            float ringR = size * 0.36F;
            iII.drawRoundedBorder(cx - ringR, cy - ringR + 1.2F, ringR * 2.0F, ringR * 2.0F, 1.8F, IIiii_Class8.I_method_893b2757(ringR), col);

            // Clean gap cutout at top
            iII.drawRect(cx - 2.5F, cy - ringR - 1.0F, 5.0F, 4.0F, new ColorRGBA(18.0F, 20.0F, 26.0F, col.getAlpha()));

            // Power toggle pin
            float barW = 2.0F;
            float barH = size * 0.40F;
            iII.drawRoundedRect(cx - barW / 2.0F, cy - ringR - 1.2F, barW, barH, IIiii_Class8.I_method_893b2757(barW / 2.0F), ColorRGBA.WHITE.withAlpha(col.getAlpha()));
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
        if (InterfaceModule.IiI_method_c4cbfac3()) {
            iII.drawLiquidGlass(this.x - 1.0f, this.y - 1.0f, this.width + 2.0f, this.height + 2.0f, 7.0f, 0.08f, IIiii_Class8.I_method_893b2757(radius), ColorRGBA.WHITE.withAlpha(255.0f * alpha));
            iII.drawRoundedRect(this.x, this.y, this.width, this.height, IIiii_Class8.I_method_893b2757(radius), this.I_field_d0c8ec5.withAlpha(255.0f * (0.18f * alpha + 0.15f * hover * alpha)));
        } else {
            iII.drawRoundedRect(this.x, this.y, this.width, this.height, IIiii_Class8.I_method_893b2757(radius), this.I_field_d0c8ec5.withAlpha(255.0f * (0.33f * alpha + 0.2f * hover * alpha)));
        }
        renderIcon(iII, f, bl);
    }

    public void I_method_f3cf064(double d, double d2, int n) {
        if (this.hovered(d, d2) && n == 0) {
            this.I_field_bac0a97e.run();
        }
    }

    @Generated
    public IiiIIiIiI_Class203(String string, float f, Runnable runnable) {
        this.I_field_523beb0a = string;
        this.I_field_46 = f;
        this.I_field_bac0a97e = runnable;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_86c997b5() {
        return this.I_field_dc7facc;
    }
}
