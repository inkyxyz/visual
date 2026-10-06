package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "CompanionPets",
    category = ModuleCategory.PLAYER,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.companion_pets"
)
public class CompanionPetsModule extends Module {

    private final ModeSetting petSetting;
    private final ModeSetting.Nested1_42765c60 petPhoenix;
    private final ModeSetting.Nested1_42765c60 petDragon;
    private final ModeSetting.Nested1_42765c60 petBoth;

    private final SliderSetting petScale;
    private final SliderSetting hoverRadius;
    private final SliderSetting hoverHeight;
    private final BooleanSetting syncTheme;
    private final ColorSetting primaryColor;
    private final ColorSetting accentColor;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public CompanionPetsModule() {
        this.petSetting = new ModeSetting(this, "Pet Type");
        this.petPhoenix = new ModeSetting.Nested1_42765c60(this.petSetting, "Феникс").select();
        this.petDragon = new ModeSetting.Nested1_42765c60(this.petSetting, "Кибер-Дракон");
        this.petBoth = new ModeSetting.Nested1_42765c60(this.petSetting, "Оба Питомца");

        this.petScale = new SliderSetting(this, "Scale")
            .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(2.2F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

        this.hoverRadius = new SliderSetting(this, "Distance")
            .I_method_c8c9a7d7(0.6F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.15F);

        this.hoverHeight = new SliderSetting(this, "Height")
            .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(2.2F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(0.95F);

        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.primaryColor = new ColorSetting(this, "Primary Color").I_method_a62f5dd6(new ColorRGBA(255.0F, 195.0F, 60.0F, 255.0F));
        this.accentColor = new ColorSetting(this, "Accent Color").I_method_a62f5dd6(new ColorRGBA(255.0F, 80.0F, 50.0F, 255.0F));
    }

    private void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null || mc.player == null) return;

        AbstractClientPlayerEntity player = mc.player;
        if (player.isInvisible()) return;

        float tickDelta = mc.getRenderTickCounter().getTickDelta(true);
        Vec3d camPos = mc.gameRenderer.getCamera().getPos();

        double px = MathHelper.lerp((double)tickDelta, player.lastRenderX, player.getX());
        double py = MathHelper.lerp((double)tickDelta, player.lastRenderY, player.getY());
        double pz = MathHelper.lerp((double)tickDelta, player.lastRenderZ, player.getZ());
        float bodyYaw = MathHelper.lerp(tickDelta, player.prevBodyYaw, player.bodyYaw);

        float time = (System.currentTimeMillis() % 1000000L) / 1000.0F;

        ColorRGBA themeCol = this.syncTheme.i_method_9b12da03() ? IiiiiIIIi_Class242.I_method_7df8e08e() : this.primaryColor.I_method_bde5f08e();
        ColorRGBA accentCol = this.accentColor.I_method_bde5f08e();
        int prim = themeCol.getRGB();
        int acc = accentCol.getRGB();

        float scale = this.petScale.Ii_method_a20abcd2();
        float rad = this.hoverRadius.Ii_method_a20abcd2();
        float baseH = this.hoverHeight.Ii_method_a20abcd2();

        MatrixStack m = event.getMatrices();
        m.push();

        try {
            m.translate(px - camPos.x, py - camPos.y, pz - camPos.z);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-bodyYaw + 180.0F));

            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.disableCull();
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

            BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

            boolean doPhoenix = this.petPhoenix.isSelected() || this.petBoth.isSelected();
            boolean doDragon = this.petDragon.isSelected() || this.petBoth.isSelected();

            if (doPhoenix) {
                // Hover at right shoulder
                float phx = rad * 0.95F;
                float phz = 0.25F + (float)Math.sin(time * 1.5F) * 0.12F;
                float phy = baseH + (float)Math.sin(time * 2.8F) * 0.10F;

                m.push();
                m.translate(phx, phy, phz);
                m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.sin(time * 1.2F) * 15.0F));
                m.scale(scale * 0.45F, scale * 0.45F, scale * 0.45F);
                renderPhoenixPet(m, buf, time, prim, acc);
                m.pop();
            }

            if (doDragon) {
                // Hover at left shoulder
                float drx = -rad * 0.95F;
                float drz = 0.25F + (float)Math.sin(time * 1.5F + 2.0F) * 0.12F;
                float dry = baseH + (float)Math.sin(time * 2.4F + 1.5F) * 0.10F;

                m.push();
                m.translate(drx, dry, drz);
                m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)Math.sin(time * 1.2F + 1.8F) * 15.0F));
                m.scale(scale * 0.45F, scale * 0.45F, scale * 0.45F);
                renderDragonPet(m, buf, time, prim, acc);
                m.pop();
            }

            BuiltBuffer built = buf.endNullable();
            if (built != null) {
                BufferRenderer.drawWithGlobalProgram(built);
            }
        } finally {
            RenderSystem.depthMask(true);
            RenderSystem.enableCull();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            m.pop();
        }
    }

    // --- 1. ASTRAL PHOENIX PET ---
    private static void renderPhoenixPet(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();

        int gold = 0xFFFFD700;
        int flame = 0xFFFF4500;
        int eye = 0xFFFFFFFF;

        // Central Body
        drawOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.18F, 0.26F, 0.18F, gold);
        drawOctahedron(buf, mat, 0.0F, 0.0F, 0.0F, 0.10F, 0.16F, 0.10F, flame);

        // Head & Beak
        drawOctahedron(buf, mat, 0.0F, 0.28F, 0.08F, 0.12F, 0.14F, 0.12F, gold);
        drawBox(buf, mat, 0.0F, 0.26F, 0.20F, 0.04F, 0.04F, 0.12F, flame); // beak

        // Blinking / Glowing Eyes
        drawBox(buf, mat, -0.06F, 0.30F, 0.12F, 0.03F, 0.03F, 0.03F, eye);
        drawBox(buf, mat, 0.06F, 0.30F, 0.12F, 0.03F, 0.03F, 0.03F, eye);

        // Head Feather Crest
        float crestWave = (float)Math.sin(time * 3.5F) * 0.04F;
        drawFeather(buf, mat, 0.0F, 0.38F, 0.0F, 0.0F, 0.58F + crestWave, -0.15F, 0.06F, gold, flame);

        // Flapping Mini-Wings
        float flapAngle = (float)Math.sin(time * 6.5F) * 26.0F;

        // Right Wing
        m.push();
        m.translate(0.12, 0.04, 0.0);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-flapAngle));
        Matrix4f rMat = m.peek().getPositionMatrix();
        drawFeather(buf, rMat, 0.0F, 0.0F, 0.0F, 0.36F, 0.22F, 0.0F, 0.09F, gold, flame);
        drawFeather(buf, rMat, 0.0F, 0.0F, 0.0F, 0.44F, 0.08F, 0.0F, 0.08F, gold, flame);
        drawFeather(buf, rMat, 0.0F, 0.0F, 0.0F, 0.34F, -0.10F, 0.0F, 0.07F, gold, flame);
        m.pop();

        // Left Wing
        m.push();
        m.translate(-0.12, 0.04, 0.0);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(flapAngle));
        Matrix4f lMat = m.peek().getPositionMatrix();
        drawFeather(buf, lMat, 0.0F, 0.0F, 0.0F, -0.36F, 0.22F, 0.0F, 0.09F, gold, flame);
        drawFeather(buf, lMat, 0.0F, 0.0F, 0.0F, -0.44F, 0.08F, 0.0F, 0.08F, gold, flame);
        drawFeather(buf, lMat, 0.0F, 0.0F, 0.0F, -0.34F, -0.10F, 0.0F, 0.07F, gold, flame);
        m.pop();

        // 3 Elegant Sweeping Tail Feathers
        for (int t = -1; t <= 1; t++) {
            float tailWave = (float)Math.sin(time * 4.0F + t * 0.8F) * 0.06F;
            drawFeather(buf, mat, t * 0.04F, -0.15F, -0.06F, t * 0.10F, -0.55F + tailWave, -0.28F, 0.07F, gold, flame);
        }

        // Floating Celestial Ring
        drawGlowingRing(buf, mat, 0.30F, 0.015F, 24, flame);
    }

    // --- 2. CYBER DRAGON PET ---
    private static void renderDragonPet(MatrixStack m, BufferBuilder buf, float time, int prim, int acc) {
        Matrix4f mat = m.peek().getPositionMatrix();

        int darkArmor = 0xFF1C1E26;
        int neon = acc;
        int eyeLed = 0xFF00FFCC;

        // Armored Body Segments
        drawBox(buf, mat, 0.0F, 0.0F, 0.0F, 0.20F, 0.22F, 0.30F, darkArmor);
        drawOctahedron(buf, mat, 0.0F, 0.12F, 0.0F, 0.04F, 0.04F, 0.04F, neon); // spine light

        // Head with Horns
        drawBox(buf, mat, 0.0F, 0.14F, 0.22F, 0.16F, 0.16F, 0.20F, darkArmor);
        // Horns
        drawTapered(buf, mat, -0.07F, 0.22F, 0.16F, 0.025F, -0.15F, 0.36F, 0.02F, 0.005F, neon);
        drawTapered(buf, mat, 0.07F, 0.22F, 0.16F, 0.025F, 0.15F, 0.36F, 0.02F, 0.005F, neon);

        // LED Visor / Eyes
        drawBox(buf, mat, -0.06F, 0.16F, 0.31F, 0.035F, 0.025F, 0.02F, eyeLed);
        drawBox(buf, mat, 0.06F, 0.16F, 0.31F, 0.035F, 0.025F, 0.02F, eyeLed);

        // Flapping Mecha Wings
        float wingFlap = (float)Math.sin(time * 5.8F) * 28.0F;

        // Right Wing
        m.push();
        m.translate(0.12, 0.08, 0.0);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-wingFlap));
        Matrix4f rMat = m.peek().getPositionMatrix();
        drawBox(buf, rMat, 0.16F, 0.06F, 0.0F, 0.28F, 0.03F, 0.03F, darkArmor);
        drawTapered(buf, rMat, 0.16F, 0.06F, 0.0F, 0.02F, 0.44F, 0.26F, 0.0F, 0.005F, neon);
        drawTapered(buf, rMat, 0.30F, 0.06F, 0.0F, 0.02F, 0.50F, 0.12F, 0.0F, 0.005F, neon);
        drawTapered(buf, rMat, 0.28F, 0.02F, 0.0F, 0.02F, 0.42F, -0.10F, 0.0F, 0.005F, neon);
        m.pop();

        // Left Wing
        m.push();
        m.translate(-0.12, 0.08, 0.0);
        m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(wingFlap));
        Matrix4f lMat = m.peek().getPositionMatrix();
        drawBox(buf, lMat, -0.16F, 0.06F, 0.0F, 0.28F, 0.03F, 0.03F, darkArmor);
        drawTapered(buf, lMat, -0.16F, 0.06F, 0.0F, 0.02F, -0.44F, 0.26F, 0.0F, 0.005F, neon);
        drawTapered(buf, lMat, -0.30F, 0.06F, 0.0F, 0.02F, -0.50F, 0.12F, 0.0F, 0.005F, neon);
        drawTapered(buf, lMat, -0.28F, 0.02F, 0.0F, 0.02F, -0.42F, -0.10F, 0.0F, 0.005F, neon);
        m.pop();

        // Articulated Tail
        float tailSway = (float)Math.sin(time * 3.5F) * 0.08F;
        drawBox(buf, mat, tailSway * 0.5F, -0.04F, -0.22F, 0.08F, 0.08F, 0.18F, darkArmor);
        drawBox(buf, mat, tailSway * 1.0F, -0.06F, -0.38F, 0.06F, 0.06F, 0.16F, darkArmor);
        drawOctahedron(buf, mat, tailSway * 1.5F, -0.08F, -0.52F, 0.04F, 0.06F, 0.08F, neon); // tail blade
    }

    // --- 3D PRIMITIVE HELPERS ---
    private static void drawBox(BufferBuilder b, Matrix4f m, float cx, float cy, float cz, float sx, float sy, float sz, int col) {
        float hx = sx * 0.5F, hy = sy * 0.5F, hz = sz * 0.5F;
        b.vertex(m, cx - hx, cy - hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz + hz).color(col);

        b.vertex(m, cx - hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz - hz).color(col);

        b.vertex(m, cx - hx, cy + hy, cz - hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz - hz).color(col);

        b.vertex(m, cx - hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz + hz).color(col);
        b.vertex(m, cx - hx, cy - hy, cz + hz).color(col);

        b.vertex(m, cx + hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz - hz).color(col);
        b.vertex(m, cx + hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx + hx, cy - hy, cz + hz).color(col);

        b.vertex(m, cx - hx, cy - hy, cz - hz).color(col);
        b.vertex(m, cx - hx, cy - hy, cz + hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz + hz).color(col);
        b.vertex(m, cx - hx, cy + hy, cz - hz).color(col);
    }

    private static void drawOctahedron(BufferBuilder b, Matrix4f m, float cx, float cy, float cz, float rx, float ry, float rz, int col) {
        b.vertex(m, cx, cy + ry, cz).color(col);
        b.vertex(m, cx + rx, cy, cz).color(col);
        b.vertex(m, cx, cy, cz + rz).color(col);
        b.vertex(m, cx - rx, cy, cz).color(col);

        b.vertex(m, cx, cy - ry, cz).color(col);
        b.vertex(m, cx - rx, cy, cz).color(col);
        b.vertex(m, cx, cy, cz + rz).color(col);
        b.vertex(m, cx + rx, cy, cz).color(col);

        b.vertex(m, cx, cy + ry, cz).color(col);
        b.vertex(m, cx, cy, cz - rz).color(col);
        b.vertex(m, cx + rx, cy, cz).color(col);
        b.vertex(m, cx, cy, cz + rz).color(col);

        b.vertex(m, cx, cy - ry, cz).color(col);
        b.vertex(m, cx, cy, cz + rz).color(col);
        b.vertex(m, cx + rx, cy, cz).color(col);
        b.vertex(m, cx, cy, cz - rz).color(col);
    }

    private static void drawFeather(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float x2, float y2, float z2, float w, int rootCol, int tipCol) {
        float dx = x2 - x1, dy = y2 - y1;
        float len = (float)Math.sqrt(dx * dx + dy * dy);
        if (len < 0.001F) return;
        float nx = -dy / len * w * 0.5F;
        float ny = dx / len * w * 0.5F;

        b.vertex(m, x1 - nx, y1 - ny, z1).color(rootCol);
        b.vertex(m, x1 + nx, y1 + ny, z1).color(rootCol);
        b.vertex(m, x2 + nx * 0.1F, y2 + ny * 0.1F, z2).color(tipCol);
        b.vertex(m, x2 - nx * 0.1F, y2 - ny * 0.1F, z2).color(tipCol);
    }

    private static void drawTapered(BufferBuilder b, Matrix4f m, float x1, float y1, float z1, float r1, float x2, float y2, float z2, float r2, int col) {
        float dx = x2 - x1, dy = y2 - y1;
        float len = (float)Math.sqrt(dx * dx + dy * dy);
        if (len < 0.001F) return;
        float nx = -dy / len;
        float ny = dx / len;

        b.vertex(m, x1 - nx * r1, y1 - ny * r1, z1).color(col);
        b.vertex(m, x1 + nx * r1, y1 + ny * r1, z1).color(col);
        b.vertex(m, x2 + nx * r2, y2 + ny * r2, z2).color(col);
        b.vertex(m, x2 - nx * r2, y2 - ny * r2, z2).color(col);
    }

    private static void drawGlowingRing(BufferBuilder b, Matrix4f m, float radius, float thickness, int segs, int col) {
        float dTheta = (float)(Math.PI * 2.0 / segs);
        for (int i = 0; i < segs; i++) {
            float t1 = i * dTheta;
            float t2 = (i + 1) * dTheta;
            float c1 = (float)Math.cos(t1), s1 = (float)Math.sin(t1);
            float c2 = (float)Math.cos(t2), s2 = (float)Math.sin(t2);

            b.vertex(m, c1 * (radius - thickness), 0.0F, s1 * (radius - thickness)).color(col);
            b.vertex(m, c1 * (radius + thickness), 0.0F, s1 * (radius + thickness)).color(col);
            b.vertex(m, c2 * (radius + thickness), 0.0F, s2 * (radius + thickness)).color(col);
            b.vertex(m, c2 * (radius - thickness), 0.0F, s2 * (radius - thickness)).color(col);
        }
    }
}
