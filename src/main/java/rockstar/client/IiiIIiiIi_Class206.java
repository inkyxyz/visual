package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiiIiii_Class120;

public class IiiIIiiIi_Class206
implements iIIiIIiIi_Class294 {
    private static final String[] I_field_6dccaaa5 = new String[]{
        "image/mainmenu/wallpaper1",
        "image/mainmenu/wallpaper2",
        "image/mainmenu/wallpaper3",
        "image/mainmenu/wallpaper4",
        "image/mainmenu/wallpaper5",
        "image/mainmenu/wallpaper6",
        "image/mainmenu/wallpaper7",
        "image/mainmenu/wallpaper8",
        "image/mainmenu/wallpaper9",
        "image/mainmenu/wallpaper10",
        "image/mainmenu/wallpaper11",
        "image/mainmenu/wallpaper12",
        "image/mainmenu/wallpaper13",
        "image/mainmenu/wallpaper14",
        "image/mainmenu/wallpaper15",
        "image/mainmenu/wallpaper16",
        "image/mainmenu/wallpaper17",
        "image/mainmenu/wallpaper18",
        "image/mainmenu/wallpaper19",
        "image/mainmenu/wallpaper20"
    };
    private static final String[] i_field_6dccaaa5 = new String[]{
        "Twilight Lagoon",
        "Creeper Hollow",
        "Amber Windmill",
        "Coral Abyss",
        "Ancient Nether",
        "Twilight Castle",
        "Sakura Grove",
        "Lush Caves",
        "Snowy Taiga",
        "Sunset Campfire",
        "Celestial Nebula",
        "Solar Citadel",
        "Emerald Deep",
        "Crimson Forest",
        "End Void Islands",
        "Glacial Highlands",
        "Cyberpunk Metropolis",
        "Autumn Sanctuary",
        "Abyssal Trench",
        "Starlight Blossom"
    };
    private boolean I_field_5a;
    private float I_field_46;
    private int I_field_49;
    private float i_field_46;
    private int i_field_49;
    private float II_field_46 = 1.7777778f;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private double I_field_44;
    private double i_field_44;
    private double II_field_44;
    private float Ii_field_46;
    private int II_field_49 = 1;
    private int Ii_field_49 = 1;
    private long I_field_4a = System.currentTimeMillis();
    private int iI_field_49;

    public static int I_method_2d8cb612() {
        return I_field_6dccaaa5.length;
    }

    public static int i_method_2d9b41f2() {
        return I_field_6dccaaa5.length;
    }

    public IiiIIiiIi_Class206(int n) {
        this.I_field_49 = MathHelper.clamp((int)n, (int)0, (int)(I_field_6dccaaa5.length - 1));
        this.i_field_46 = this.I_field_49;
        this.i_field_49 = this.I_field_49;
    }

    public ColorRGBA getWallpaperAccentColor() {
        return switch (this.I_field_49) {
            case 0 -> new ColorRGBA(170.0F, 115.0F, 255.0F, 255.0F); // Twilight violet
            case 1 -> new ColorRGBA(80.0F, 255.0F, 130.0F, 255.0F);  // Radioactive Creeper Green
            case 2 -> new ColorRGBA(255.0F, 165.0F, 65.0F, 255.0F);  // Amber Windmill
            case 3 -> new ColorRGBA(70.0F, 230.0F, 255.0F, 255.0F);  // Coral Abyss cyan
            case 4 -> new ColorRGBA(255.0F, 85.0F, 60.0F, 255.0F);   // Ancient Nether Lava Red
            case 5 -> new ColorRGBA(130.0F, 110.0F, 240.0F, 255.0F); // Twilight Castle Royal Blue
            case 6 -> new ColorRGBA(255.0F, 140.0F, 200.0F, 255.0F); // Sakura Grove Blossom Pink
            case 7 -> new ColorRGBA(100.0F, 230.0F, 110.0F, 255.0F); // Lush Caves Green
            case 8 -> new ColorRGBA(120.0F, 210.0F, 255.0F, 255.0F); // Snowy Taiga Aurora Teal
            case 9 -> new ColorRGBA(255.0F, 150.0F, 50.0F, 255.0F);  // Sunset Campfire Warm Orange
            case 10 -> new ColorRGBA(190.0F, 90.0F, 255.0F, 255.0F);  // Celestial Nebula Cosmic Violet
            case 11 -> new ColorRGBA(255.0F, 200.0F, 60.0F, 255.0F);  // Solar Citadel Radiant Gold
            case 12 -> new ColorRGBA(0.0F, 245.0F, 180.0F, 255.0F);   // Emerald Deep Neon Mint
            case 13 -> new ColorRGBA(255.0F, 50.0F, 80.0F, 255.0F);   // Crimson Forest Nether Crimson
            case 14 -> new ColorRGBA(210.0F, 130.0F, 255.0F, 255.0F); // End Void Islands Ender Purple
            case 15 -> new ColorRGBA(140.0F, 225.0F, 255.0F, 255.0F); // Glacial Highlands Frost Sky Blue
            case 16 -> new ColorRGBA(0.0F, 235.0F, 255.0F, 255.0F);   // Cyberpunk Metropolis Electric Cyan
            case 17 -> new ColorRGBA(255.0F, 130.0F, 40.0F, 255.0F);  // Autumn Sanctuary Golden Amber
            case 18 -> new ColorRGBA(30.0F, 180.0F, 255.0F, 255.0F);  // Abyssal Trench Bioluminescent Deep Blue
            case 19 -> new ColorRGBA(255.0F, 105.0F, 180.0F, 255.0F); // Starlight Blossom Sakura Rose
            default -> new ColorRGBA(140.0F, 220.0F, 255.0F, 255.0F);
        };
    }

    public int getCurrentWallpaperIndex() {
        return this.I_field_49;
    }

    public boolean I_method_2d8cb623() {
        return this.I_field_5a || this.I_field_46 > 0.001f;
    }

    public void I_method_2d8cb61f() {
        this.I_field_5a = true;
        this.i_field_46 = this.I_field_49;
        this.i_field_49 = this.I_field_49;
        this.i_field_5a = false;
        this.II_field_5a = false;
    }

    public void i_method_2d9b41ff() {
        this.I_field_5a = false;
        this.i_field_5a = false;
        this.II_field_5a = false;
        this.i_field_49 = this.I_field_49;
    }

    public void I_method_493e8287(III iII, int n3, int n4, float f, float f2, float f3, float f4) {
        float f5;
        this.II_field_49 = Math.max(1, n3);
        this.Ii_field_49 = Math.max(1, n4);
        if (this.iI_field_49 < I_field_6dccaaa5.length) {
            if (!I_field_6dccaaa5[this.iI_field_49].startsWith("shader/")) {
                iiiIiii_Class120.I_method_601d95f8(I_field_6dccaaa5[this.iI_field_49]);
            }
            ++this.iI_field_49;
        }
        if (!I_field_6dccaaa5[this.I_field_49].startsWith("shader/") && (f5 = iiiIiii_Class120.I_method_6de45459(I_field_6dccaaa5[this.I_field_49])) > 0.0f) {
            this.II_field_46 = f5;
        } else {
            this.II_field_46 = 1.7777778f;
        }
        long l = System.currentTimeMillis();
        float f6 = Math.min(0.1f, (float)(l - this.I_field_4a) / 1000.0f);
        this.I_field_4a = l;
        float f7 = 1.0f - (float)Math.pow(9.0E-4f, f6);
        float f8 = this.I_field_5a ? 1.0f : 0.0f;
        this.I_field_46 += (f8 - this.I_field_46) * f7;
        if (Math.abs(f8 - this.I_field_46) < 8.0E-4f) {
            this.I_field_46 = f8;
        }
        float f9 = this.I_field_46;
        if (!this.II_field_5a) {
            this.i_field_46 += ((float)this.i_field_49 - this.i_field_46) * f7;
            if (Math.abs((float)this.i_field_49 - this.i_field_46) < 8.0E-4f) {
                this.i_field_46 = this.i_field_49;
            }
        }
        float f10 = this.I_method_fd460aaf(n3, n4) * iIIiiiiiI_Class319.I_method_5f7ff5cf(1.01f - 0.01f * f3, 1.0, f9) * (1.0f - 0.02f * f4);
        float f11 = this.i_method_33e11e8f(n3, n4);
        float f12 = iIIiiiiiI_Class319.I_method_5f7ff5cf(f10, f11, f9);
        float f13 = f12 / this.II_field_46;
        float f14 = iIIiiiiiI_Class319.I_method_5f7ff5cf(0.0, f11 * 1.08f, f9);
        float f15 = (float)n3 / 2.0f - f * (1.0f - f9);
        float f16 = (float)n4 / 2.0f - f2 * (1.0f - f9) - 4.0f * f9;
        float f17 = 18.0f * f9;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < I_field_6dccaaa5.length; ++i) {
            arrayList.add(i);
        }
        arrayList.sort((n, n2) -> Float.compare(Math.abs((float)n2.intValue() - this.i_field_46), Math.abs((float)n.intValue() - this.i_field_46)));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            int n5 = (Integer)iterator.next();
            float f18 = (float)n5 - this.i_field_46;
            float f19 = Math.abs(f18);
            if (f19 > 1.85f) continue;
            float f20 = Math.min(1.0f, f19);
            float f21 = 1.0f - 0.14f * f20;
            float f22 = f12 * f21;
            float f23 = f13 * f21;
            float f24 = f15 + f18 * f14 - f22 / 2.0f;
            float f25 = f16 - f23 / 2.0f;
            float f26 = Math.max(f9, Math.max(0.0f, 1.0f - f19 * 6.0f));
            float f27 = (1.0f - 0.4f * f20) * f26;
            if (f27 <= 0.003f) continue;
            IIiii_Class8 iIiii_Class8 = IIiii_Class8.I_method_893b2757(f17);
            if (f9 > 0.01f) {
                iII.drawShadow(f24, f25 + 6.0f * f9, f22, f23, 16.0f * f9, iIiii_Class8, ColorRGBA.BLACK.withAlpha(150.0f * f9 * f27));
            }
            if (I_field_6dccaaa5[n5].startsWith("shader/")) {
                renderProceduralShaderWallpaper(iII, n5, f24, f25, f22, f23, iIiii_Class8, f27, f9, f, f2);
            } else {
                iII.drawRoundedTexture(iiiIiii_Class120.I_method_601d95f8(I_field_6dccaaa5[n5]), f24, f25, f22, f23, iIiii_Class8, ColorRGBA.WHITE.withAlpha(255.0f * f27));
            }
            if (!(f20 > 0.003f)) continue;
            iII.drawRoundedRect(f24, f25, f22, f23, iIiii_Class8, ColorRGBA.BLACK.withAlpha(95.0f * f20 * f9));
        }
    }

    private void renderProceduralShaderWallpaper(III iII, int index, float x, float y, float w, float h, IIiii_Class8 radius, float alpha, float carouselProgress, float mouseXOffset, float mouseYOffset) {
        long now = System.currentTimeMillis();
        float time = (float)((now % 10000000L) / 1000.0);

        MatrixStack matrices = iII.getMatrices();
        matrices.push();
        Matrix4f mat = matrices.peek().getPositionMatrix();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        if (index == 4) {
            // --- 4. NEON CYBER GRID (Synthwave Outrun Retro Horizon) ---
            iII.drawRoundedRect(x, y, w, h, radius, new ColorRGBA(12.0F, 3.0F, 24.0F, 255.0F * alpha));

            float horizonY = y + h * 0.54F;
            float sunCX = x + w * 0.5F - mouseXOffset * 1.5F;
            float sunR = Math.min(w, h) * 0.22F;

            // Retro Sunset Sun
            iII.drawBlurredRect(sunCX - sunR, horizonY - sunR * 0.85F, sunR * 2.0F, sunR * 1.7F, 24.0F, IIiii_Class8.I_method_893b2757(sunR), new ColorRGBA(255.0F, 50.0F, 140.0F, 160.0F * alpha));
            iII.drawRoundedRect(sunCX - sunR * 0.85F, horizonY - sunR * 0.75F, sunR * 1.7F, sunR * 1.5F, IIiii_Class8.I_method_893b2757(sunR * 0.85F), new ColorRGBA(255.0F, 190.0F, 30.0F, 220.0F * alpha));

            // Perspective Grid Floor
            BufferBuilder gridBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
            int neonCyan = 0x00F0FF | (int)(220.0F * alpha) << 24;
            int neonPink = 0xFF007F | (int)(180.0F * alpha) << 24;

            float gridH = (y + h) - horizonY;
            float scroll = ((now % 1500L) / 1500.0F);
            int horizLines = 14;
            for (int i = 0; i <= horizLines; i++) {
                float norm = (float) (i + scroll) / horizLines;
                if (norm > 1.0F) norm -= 1.0F;
                float p = (float) Math.pow(norm, 2.4);
                float gy = horizonY + p * gridH;
                int col = (p > 0.5F ? neonCyan : neonPink);
                gridBuf.vertex(mat, x, gy, 0.0F).color(col);
                gridBuf.vertex(mat, x + w, gy, 0.0F).color(col);
            }

            int vertLines = 18;
            for (int v = -vertLines / 2; v <= vertLines / 2; v++) {
                float bx = sunCX + v * (w / (vertLines * 0.55F));
                gridBuf.vertex(mat, sunCX, horizonY, 0.0F).color(neonPink);
                gridBuf.vertex(mat, bx, y + h, 0.0F).color(neonCyan);
            }

            BuiltBuffer gb = gridBuf.endNullable();
            if (gb != null) BufferRenderer.drawWithGlobalProgram(gb);

        } else if (index == 5) {
            // --- 5. COSMIC WARPFIELD (Relativistic Hyperspace Tunnel) ---
            iII.drawRoundedRect(x, y, w, h, radius, new ColorRGBA(6.0F, 3.0F, 16.0F, 255.0F * alpha));

            float vcx = x + w * 0.5F - mouseXOffset * 2.0F;
            float vcy = y + h * 0.5F - mouseYOffset * 2.0F;

            float corePulse = (float) Math.sin(time * 3.0F) * 0.5F + 0.5F;
            float voidR = Math.min(w, h) * 0.16F * (0.9F + 0.1F * corePulse);
            iII.drawBlurredRect(vcx - voidR * 1.5F, vcy - voidR * 1.5F, voidR * 3.0F, voidR * 3.0F, 32.0F, IIiii_Class8.I_method_893b2757(voidR * 1.5F), new ColorRGBA(130.0F, 60.0F, 255.0F, 150.0F * alpha));

            BufferBuilder warpBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
            int starCount = 64;
            float maxR = (float) Math.hypot(w, h) * 0.65F;

            for (int s = 0; s < starCount; s++) {
                double ang = s * (Math.PI * 2.0 / starCount) + Math.sin(s * 7.1) * 0.2;
                float starSpeed = 0.35F + (float)((s * 13) % 10) * 0.08F;
                float distNorm = ((time * starSpeed + (float) s / starCount) % 1.0F);
                float dist = (float) Math.pow(distNorm, 1.8) * maxR;
                float streak = Math.max(3.0F, dist * 0.22F);

                float cos = (float) Math.cos(ang);
                float sin = (float) Math.sin(ang);

                float sx1 = vcx + cos * Math.max(voidR * 0.6F, dist - streak);
                float sy1 = vcy + sin * Math.max(voidR * 0.6F, dist - streak);
                float sx2 = vcx + cos * dist;
                float sy2 = vcy + sin * dist;

                int starCol = (s % 2 == 0 ? 0xE0AAFF : 0x70E000) & 0x00FFFFFF | (int)(255.0F * distNorm * alpha) << 24;
                warpBuf.vertex(mat, sx1, sy1, 0.0F).color(starCol);
                warpBuf.vertex(mat, sx2, sy2, 0.0F).color(0xFFFFFFFF & 0x00FFFFFF | (int)(255.0F * distNorm * alpha) << 24);
            }

            BuiltBuffer wb = warpBuf.endNullable();
            if (wb != null) BufferRenderer.drawWithGlobalProgram(wb);

        } else if (index == 6) {
            // --- 6. LIQUID AURORA (Undulating Ethereal Northern Lights) ---
            iII.drawRoundedRect(x, y, w, h, radius, new ColorRGBA(3.0F, 12.0F, 22.0F, 255.0F * alpha));

            BufferBuilder auroraBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            int segs = 32;
            float segW = w / segs;

            int[] auroraTopCols = {0x00F5D4, 0x06D6A0, 0x7209B7};
            int[] auroraBotCols = {0x0B192C, 0x1E3E62, 0x000000};

            for (int layer = 0; layer < 3; layer++) {
                float layerY = y + h * (0.28F + layer * 0.16F);
                float layerH = h * 0.38F;
                float lSpeed = 1.2F + layer * 0.5F;
                int topCol = auroraTopCols[layer] | (int)(170.0F * alpha) << 24;
                int botCol = auroraBotCols[layer] | (int)(10.0F * alpha) << 24;

                for (int s = 0; s < segs; s++) {
                    float x1 = x + s * segW;
                    float x2 = x1 + segW;

                    float wave1 = (float) Math.sin(time * lSpeed + s * 0.25F) * 28.0F + (float) Math.cos(time * 0.7F + s * 0.12F) * 16.0F;
                    float wave2 = (float) Math.sin(time * lSpeed + (s + 1) * 0.25F) * 28.0F + (float) Math.cos(time * 0.7F + (s + 1) * 0.12F) * 16.0F;

                    auroraBuf.vertex(mat, x1, layerY + wave1, 0.0F).color(topCol);
                    auroraBuf.vertex(mat, x2, layerY + wave2, 0.0F).color(topCol);
                    auroraBuf.vertex(mat, x2, layerY + wave2 + layerH, 0.0F).color(botCol);
                    auroraBuf.vertex(mat, x1, layerY + wave1 + layerH, 0.0F).color(botCol);
                }
            }

            BuiltBuffer ab = auroraBuf.endNullable();
            if (ab != null) BufferRenderer.drawWithGlobalProgram(ab);
        }

        RenderSystem.disableBlend();
        matrices.pop();
    }

    public void I_method_1146ee07(III iII, int n, int n2) {
        float f;
        float f2;
        float f3;
        float f4 = this.I_field_46;
        if (f4 <= 0.003f) {
            return;
        }
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(21.0f);
        float f5 = this.I_method_b87e5290(n, n2, iIiIIi_Class10) - 14.0f * (1.0f - f4);
        float f6 = 140.0f;
        for (int i = 0; i < I_field_6dccaaa5.length; ++i) {
            f3 = (float)i - this.i_field_46;
            if (Math.abs(f3) >= 1.0f) continue;
            f2 = 1.0f - Math.abs(f3);
            f2 *= f2;
            f = (float)n / 2.0f + f3 * f6;
            String string = IiIiIIII_Class81.I_method_f25a980a(i_field_6dccaaa5[i]);
            iII.drawCenteredTextWithShadow(iIiIIi_Class10, string, f, f5, ColorRGBA.WHITE.withAlpha(255.0f * f4 * f2), ColorRGBA.BLACK.withAlpha(130.0f * f4 * f2), 1.0f, 2.0f, 4.0f);
        }
        float f7 = (float)n2 - 26.0f;
        f3 = 10.0f;
        f2 = 6.0f;
        f = (float)n / 2.0f - (float)(I_field_6dccaaa5.length - 1) * f3 / 2.0f;
        for (int i = 0; i < I_field_6dccaaa5.length; ++i) {
            float f8 = 1.0f - Math.min(1.0f, Math.abs((float)i - this.i_field_46));
            float f9 = (0.3f + 0.7f * f8) * f4;
            iII.drawRoundedRect(f + (float)i * f3 - f2 / 2.0f, f7 - f2 / 2.0f, f2, f2, IIiii_Class8.I_method_893b2757(f2 / 2.0f), ColorRGBA.WHITE.withAlpha(255.0f * f9));
        }
    }

    public boolean I_method_ab3304c8(double d, double d2, int n) {
        if (!this.I_field_5a) {
            return false;
        }
        if (n == 1) {
            this.i_method_2d9b41ff();
            return true;
        }
        if (n != 0) {
            return true;
        }
        this.i_field_5a = true;
        this.II_field_5a = false;
        this.I_field_44 = d;
        this.i_field_44 = d2;
        this.II_field_44 = d;
        this.Ii_field_46 = this.i_field_46;
        return true;
    }

    public boolean i_method_47fa6ce8(double d, double d2, int n) {
        if (!this.I_field_5a || !this.i_field_5a || n != 0) {
            return this.I_field_5a;
        }
        if (Math.abs(d - this.I_field_44) > 4.0 || Math.abs(d2 - this.i_field_44) > 4.0) {
            this.II_field_5a = true;
        }
        if (this.II_field_5a) {
            float f = Math.max(1.0f, this.i_method_33e11e8f(this.II_field_49, this.Ii_field_49) * 1.16f);
            this.i_field_46 = MathHelper.clamp((float)(this.Ii_field_46 - (float)(d - this.II_field_44) / f), (float)0.0f, (float)((float)I_field_6dccaaa5.length - 1.0f));
            this.i_field_49 = MathHelper.clamp((int)Math.round(this.i_field_46), (int)0, (int)(I_field_6dccaaa5.length - 1));
        }
        return true;
    }

    public boolean II_method_5d11b2e5(double d, double d2, int n) {
        if (!this.I_field_5a || n != 0 || !this.i_field_5a) {
            this.i_field_5a = false;
            return this.I_field_5a;
        }
        this.i_field_5a = false;
        if (this.II_field_5a) {
            this.II_field_5a = false;
            this.i_field_49 = MathHelper.clamp((int)Math.round(this.i_field_46), (int)0, (int)(I_field_6dccaaa5.length - 1));
            return true;
        }
        int n2 = MathHelper.clamp((int)Math.round(this.i_field_46), (int)0, (int)(I_field_6dccaaa5.length - 1));
        float f = Math.max(1.0f, this.i_method_33e11e8f(this.II_field_49, this.Ii_field_49) * 1.16f);
        int n3 = MathHelper.clamp((int)Math.round(this.i_field_46 + (float)(d - (double)this.II_field_49 / 2.0) / f), (int)0, (int)(I_field_6dccaaa5.length - 1));
        if (n3 == n2 && this.I_method_fd43b223(d, d2)) {
            this.I_field_49 = n2;
            this.i_method_2d9b41ff();
        } else if (n3 != n2) {
            this.i_field_49 = n3;
        }
        return true;
    }

    public boolean I_method_840a6e03(double d) {
        if (!this.I_field_5a) {
            return false;
        }
        this.i_field_49 = MathHelper.clamp((int)(this.i_field_49 + (d > 0.0 ? -1 : 1)), (int)0, (int)(I_field_6dccaaa5.length - 1));
        return true;
    }

    public boolean I_method_840a80c8(int n) {
        if (!this.I_field_5a) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        int n2 = this.II_field_5a ? Math.round(this.i_field_46) : this.i_field_49;
        this.i_field_49 = MathHelper.clamp((int)(n2 + Integer.signum(n)), (int)0, (int)(I_field_6dccaaa5.length - 1));
        this.i_field_5a = false;
        this.II_field_5a = false;
        return true;
    }

    private boolean I_method_fd43b223(double d, double d2) {
        float f = this.i_method_33e11e8f(this.II_field_49, this.Ii_field_49);
        float f2 = f / this.II_field_46;
        float f3 = (float)this.II_field_49 / 2.0f;
        float f4 = (float)this.Ii_field_49 / 2.0f - 4.0f;
        return d >= (double)(f3 - f / 2.0f) && d <= (double)(f3 + f / 2.0f) && d2 >= (double)(f4 - f2 / 2.0f) && d2 <= (double)(f4 + f2 / 2.0f);
    }

    private float I_method_b87e5290(int n, int n2, IIiIIi_Class10 iIiIIi_Class10) {
        float f = (float)n2 / 2.0f - 4.0f - this.i_method_33e11e8f(n, n2) / this.II_field_46 / 2.0f;
        float f2 = Math.min(42.0f, (float)n2 * 0.13f);
        float f3 = f - iIiIIi_Class10.iI_method_24b6c285() - MathHelper.clamp((float)((float)n2 * 0.045f), (float)10.0f, (float)28.0f);
        return Math.max(6.0f, Math.min(f2, f3));
    }

    private float I_method_fd460aaf(int n, int n2) {
        float f;
        float f2;
        float f3 = (float)n / Math.max(1.0f, (float)n2);
        if (f3 > this.II_field_46) {
            f2 = n;
            f = (float)n / this.II_field_46;
        } else {
            f = n2;
            f2 = (float)n2 * this.II_field_46;
        }
        float f4 = 6.0f;
        float f5 = Math.max(((float)n + f4 * 2.0f) / f2, ((float)n2 + f4 * 2.0f) / f);
        f5 = Math.max(f5, 1.005f);
        return f2 * f5;
    }

    private float i_method_33e11e8f(int n, int n2) {
        float f = (float)n * 0.52f;
        float f2 = (float)n2 * 0.62f;
        if (f / this.II_field_46 > f2) {
            f = f2 * this.II_field_46;
        }
        return f;
    }

    @Generated
    public boolean i_method_2d9b4203() {
        return this.I_field_5a;
    }

    @Generated
    public float I_method_2d8cb60f() {
        return this.I_field_46;
    }

    @Generated
    public int II_method_84190515() {
        return this.I_field_49;
    }
}

