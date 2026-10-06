package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Trails",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.trails"
)
public class TrailsModule extends Module {

    // Trail breadcrumb with full player height
    private static class TrailPoint {
        final double x, y, z;
        final float height;
        long spawnTime;

        TrailPoint(double x, double y, double z, float height, long spawnTime) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.height = height;
            this.spawnTime = spawnTime;
        }
    }

    // 3D Liquid Floating Bubble with physical buoyancy, surface tension wobble, and pop
    private static class FluidBubble {
        double x, y, z;
        double vx, vy, vz;
        final float baseRadius;
        final float wobbleSpeed;
        final float wobblePhase;
        final long spawnTime;
        final long lifetime;
        final ColorRGBA color;

        FluidBubble(double x, double y, double z, float radius, ColorRGBA color, long spawnTime, long lifetime) {
            this.x = x;
            this.y = y;
            this.z = z;
            // Gentle upward buoyancy + soft fluid drift
            this.vx = (Math.random() - 0.5) * 0.008;
            this.vy = 0.012 + Math.random() * 0.014;
            this.vz = (Math.random() - 0.5) * 0.008;
            this.baseRadius = radius;
            this.wobbleSpeed = 3.5F + (float)Math.random() * 4.0F;
            this.wobblePhase = (float)(Math.random() * Math.PI * 2.0);
            this.spawnTime = spawnTime;
            this.lifetime = lifetime;
            this.color = color;
        }
    }

    private ModeSetting modeSetting;
    private ModeSetting.Nested1_42765c60 modeGradient;
    private ModeSetting.Nested1_42765c60 modeBubbles;
    private ModeSetting.Nested1_42765c60 modeNeon;

    private SliderSetting trailLifetimeSetting;
    private SliderSetting trailWidth;
    private SliderSetting trailAlpha;
    private BooleanSetting bubbleGravity;
    private BooleanSetting syncTheme;
    private ColorSetting colorSetting;

    private final LinkedList<TrailPoint> points = new LinkedList<>();
    private final List<FluidBubble> fluidBubbles = new ArrayList<>();
    private Vec3d lastRecordedPos = null;
    private long lastBubbleSpawnTime = 0L;

    private final IiIIIiII_Class69<Render3DEvent> renderListener = this::onRender3D;
    private final IiIIIiII_Class69<WorldChangeEvent> worldChangeListener = var1 -> {
        this.points.clear();
        this.fluidBubbles.clear();
        this.lastRecordedPos = null;
    };

    public TrailsModule() {
        this.modeSetting = new ModeSetting(this, "Mode");
        this.modeGradient = new ModeSetting.Nested1_42765c60(this.modeSetting, "Gradient").select();
        this.modeBubbles = new ModeSetting.Nested1_42765c60(this.modeSetting, "Bubbles");
        this.modeNeon = new ModeSetting.Nested1_42765c60(this.modeSetting, "Neon");

        this.bubbleGravity = new BooleanSetting(this, "Gravity", () -> !this.modeBubbles.isSelected());

        this.trailLifetimeSetting = new SliderSetting(this, "Lifetime (s)")
            .I_method_c8c9a7d7(0.4F)
            .i_method_65e2aff7(3.0F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.2F);

        this.trailWidth = new SliderSetting(this, "Full Height")
            .I_method_c8c9a7d7(0.5F)
            .i_method_65e2aff7(2.2F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.8F);

        this.trailAlpha = new SliderSetting(this, "Alpha")
            .I_method_c8c9a7d7(0.1F)
            .i_method_65e2aff7(1.0F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(0.75F);

        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.colorSetting = new ColorSetting(this, "Color").I_method_a62f5dd6(new ColorRGBA(0.0F, 220.0F, 255.0F, 240.0F));
    }

    @Override
    public String i_method_bf522194() {
        return "Full player-height vertical trails and true 3D fluid floating bubbles in movement.";
    }

    private long lastFrameTime = 0L;

    private void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null || mc.world == null) return;

        float td = mc.getRenderTickCounter().getTickDelta(false);
        double ix = MathHelper.lerp(td, player.prevX, player.getX());
        double iy = MathHelper.lerp(td, player.prevY, player.getY());
        double iz = MathHelper.lerp(td, player.prevZ, player.getZ());
        float playerHeight = this.trailWidth.Ii_method_a20abcd2();

        long now = System.currentTimeMillis();
        long deltaMs = this.lastFrameTime == 0L ? 16L : Math.min(100L, now - this.lastFrameTime);
        this.lastFrameTime = now;

        long maxLifeMs = (long)(this.trailLifetimeSetting.Ii_method_a20abcd2() * 1000.0F);

        // Check if player is actively moving
        double dx = player.getX() - player.prevX;
        double dy = player.getY() - player.prevY;
        double dz = player.getZ() - player.prevZ;
        boolean isMoving = (dx * dx + dz * dz > 0.0001) || Math.abs(dy) > 0.0001 ||
                           player.getVelocity().horizontalLengthSquared() > 0.0001;

        Vec3d currentPos = new Vec3d(ix, iy, iz);

        if (isMoving) {
            if (this.lastRecordedPos == null || this.lastRecordedPos.squaredDistanceTo(currentPos) > 0.002) {
                this.points.addFirst(new TrailPoint(ix, iy, iz, playerHeight, now));
                this.lastRecordedPos = currentPos;
            }

            // Spawn floating 3D fluid bubbles when in Bubbles mode
            if (this.modeBubbles.isSelected() && (now - this.lastBubbleSpawnTime > 55)) {
                this.lastBubbleSpawnTime = now;
                // Spawn 1-2 bubbles along player height
                for (int b = 0; b < 2; b++) {
                    double spawnY = iy + 0.15 + Math.random() * (playerHeight * 0.85);
                    double jitterX = (Math.random() - 0.5) * 0.40;
                    double jitterZ = (Math.random() - 0.5) * 0.40;
                    float radius = 0.07F + (float)Math.random() * 0.09F;
                    long bubbleLife = 900L + (long)(Math.random() * 700.0);

                    ColorRGBA baseCol = this.syncTheme.i_method_9b12da03()
                        ? IiiiiIIIi_Class242.I_method_7df8e08e()
                        : this.colorSetting.I_method_bde5f08e();

                    this.fluidBubbles.add(new FluidBubble(ix + jitterX, spawnY, iz + jitterZ, radius, baseCol, now, bubbleLife));
                }
            }
        } else {
            // Rapid fade out on standstill: accelerate decay so trail quickly dissolves when player stops
            this.lastRecordedPos = null;
            for (TrailPoint pt : this.points) {
                pt.spawnTime -= (long)(deltaMs * 3.5);
            }
        }

        // Decay and prune points older than maxLifeMs
        this.points.removeIf(pt -> (now - pt.spawnTime) >= maxLifeMs);

        // Update fluid bubbles
        Iterator<FluidBubble> bIter = this.fluidBubbles.iterator();
        while (bIter.hasNext()) {
            FluidBubble fb = bIter.next();
            long age = now - fb.spawnTime;
            if (age >= fb.lifetime) {
                bIter.remove();
                continue;
            }
            // Float up and drift (or fall under gravity)
            if (this.bubbleGravity != null && this.bubbleGravity.i_method_9b12da03()) {
                fb.vy -= 0.0016; // accelerate downward under gravity
            }
            fb.x += fb.vx;
            fb.y += fb.vy;
            fb.z += fb.vz;
        }

        // If in first-person view, do not render trails
        if (mc.options.getPerspective().isFirstPerson()) {
            return;
        }

        // If no active points or bubbles, nothing to render
        if (this.points.isEmpty() && this.fluidBubbles.isEmpty()) {
            return;
        }

        Vec3d cam = mc.gameRenderer.getCamera().getPos();
        MatrixStack matrices = event.getMatrices();
        matrices.push();
        try {
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
            RenderSystem.disableCull();
            RenderSystem.depthMask(false);
            RenderSystem.enableDepthTest();
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

            Matrix4f mat = matrices.peek().getPositionMatrix();

            if (this.modeBubbles.isSelected()) {
                renderFluidBubbles(mat, now, cam);
            } else if (this.modeNeon.isSelected()) {
                renderFullHeightNeon(mat, now, maxLifeMs, cam, isMoving, ix, iy, iz, playerHeight);
            } else {
                renderFullHeightGradient(mat, now, maxLifeMs, cam, isMoving, ix, iy, iz, playerHeight);
            }
        } finally {
            RenderSystem.depthMask(true);
            RenderSystem.enableCull();
            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            matrices.pop();
        }
    }

    // ==========================================
    // FULL-HEIGHT VERTICAL GRADIENT TRAIL
    // ==========================================
    private void renderFullHeightGradient(Matrix4f mat, long now, long maxLifeMs, Vec3d cam,
                                          boolean isMoving, double ix, double iy, double iz, float playerHeight) {
        if (this.points.isEmpty() && !isMoving) return;

        float userAlpha = this.trailAlpha.Ii_method_a20abcd2();
        TrailPoint[] pts = this.points.toArray(new TrailPoint[0]);
        int count = pts.length;

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int vertexCount = 0;

        // Prepend current real-time player position as seamless leading ribbon edge
        if (isMoving) {
            ColorRGBA leadCol = this.syncTheme.i_method_9b12da03()
                ? IiiiiIIIi_Class242.I_method_7df8e08e()
                : hueToRGBA((now * 0.08F) % 360.0F);
            int cTop = leadCol.withAlpha(leadCol.getAlpha() * userAlpha * 0.85F).getRGB();
            int cBot = leadCol.withAlpha(leadCol.getAlpha() * userAlpha * 0.50F).getRGB();
            float lx = (float)(ix - cam.x);
            float ly = (float)(iy - cam.y);
            float lz = (float)(iz - cam.z);
            bb.vertex(mat, lx, ly + playerHeight, lz).color(cTop);
            bb.vertex(mat, lx, ly, lz).color(cBot);
            vertexCount += 2;
        }

        for (int i = 0; i < count; i++) {
            TrailPoint p = pts[i];
            long age = now - p.spawnTime;
            float lifeFactor = 1.0F - MathHelper.clamp((float)age / (float)maxLifeMs, 0.0F, 1.0F);

            // Smooth cubic fade along trail
            float alpha = userAlpha * lifeFactor * lifeFactor;
            if (alpha <= 0.005F) continue;

            ColorRGBA col;
            if (this.syncTheme.i_method_9b12da03()) {
                col = IiiiiIIIi_Class242.I_method_7df8e08e();
            } else {
                float hue = ((float)i / count * 280.0F + (now * 0.08F)) % 360.0F;
                col = hueToRGBA(hue);
            }

            int colTop = col.withAlpha(col.getAlpha() * alpha * 0.75F).getRGB();
            int colBot = col.withAlpha(col.getAlpha() * alpha * 0.45F).getRGB();

            float px = (float)(p.x - cam.x);
            float py = (float)(p.y - cam.y);
            float pz = (float)(p.z - cam.z);
            float h = p.height;

            // Full-height vertical ribbon: Top (head) and Bottom (feet)
            bb.vertex(mat, px, py + h, pz).color(colTop);
            bb.vertex(mat, px, py, pz).color(colBot);
            vertexCount += 2;
        }

        if (vertexCount >= 3) {
            BuiltBuffer built = bb.endNullable();
            if (built != null) {
                BufferRenderer.drawWithGlobalProgram(built);
            }
        } else {
            bb.endNullable();
        }
    }

    // ==========================================
    // FULL-HEIGHT NEON CURTAIN TRAIL
    // ==========================================
    private void renderFullHeightNeon(Matrix4f mat, long now, long maxLifeMs, Vec3d cam,
                                      boolean isMoving, double ix, double iy, double iz, float playerHeight) {
        if (this.points.isEmpty() && !isMoving) return;

        float userAlpha = this.trailAlpha.Ii_method_a20abcd2();
        TrailPoint[] pts = this.points.toArray(new TrailPoint[0]);
        int count = pts.length;

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
        int vertexCount = 0;

        ColorRGBA baseCol = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.colorSetting.I_method_bde5f08e();

        // Leading edge attached to player
        if (isMoving) {
            int cTop = baseCol.withAlpha(baseCol.getAlpha() * userAlpha * 0.95F).getRGB();
            int cBot = baseCol.withAlpha(baseCol.getAlpha() * userAlpha * 0.60F).getRGB();
            float lx = (float)(ix - cam.x);
            float ly = (float)(iy - cam.y);
            float lz = (float)(iz - cam.z);
            bb.vertex(mat, lx, ly + playerHeight, lz).color(cTop);
            bb.vertex(mat, lx, ly, lz).color(cBot);
            vertexCount += 2;
        }

        for (int i = 0; i < count; i++) {
            TrailPoint p = pts[i];
            long age = now - p.spawnTime;
            float lifeFactor = 1.0F - MathHelper.clamp((float)age / (float)maxLifeMs, 0.0F, 1.0F);

            float alpha = userAlpha * lifeFactor;
            if (alpha <= 0.005F) continue;

            int cTop = baseCol.withAlpha(baseCol.getAlpha() * alpha * 0.85F).getRGB();
            int cBot = baseCol.withAlpha(baseCol.getAlpha() * alpha * 0.50F).getRGB();

            float px = (float)(p.x - cam.x);
            float py = (float)(p.y - cam.y);
            float pz = (float)(p.z - cam.z);
            float h = p.height;

            bb.vertex(mat, px, py + h, pz).color(cTop);
            bb.vertex(mat, px, py, pz).color(cBot);
            vertexCount += 2;
        }

        if (vertexCount >= 3) {
            BuiltBuffer built = bb.endNullable();
            if (built != null) {
                BufferRenderer.drawWithGlobalProgram(built);
            }
        } else {
            bb.endNullable();
        }
    }

    // ==========================================
    // TRUE 3D LIQUID FLOATING BUBBLES
    // ==========================================
    private void renderFluidBubbles(Matrix4f mat, long now, Vec3d cam) {
        if (this.fluidBubbles.isEmpty()) return;

        float userAlpha = this.trailAlpha.Ii_method_a20abcd2();

        // 3D UV Sphere geometry with 10 longitude slices x 6 latitude stacks
        int slices = 10;
        int stacks = 6;

        // Pre-count visible bubbles to ensure buffer is not empty
        int visibleBubbles = 0;
        for (FluidBubble b : this.fluidBubbles) {
            long age = now - b.spawnTime;
            if (age >= b.lifetime) continue;
            float prog = (float)age / (float)b.lifetime;
            float alphaFactor = prog < 0.15F ? (prog / 0.15F) : (prog < 0.82F ? 1.0F : (1.0F - (prog - 0.82F) / 0.18F));
            if (userAlpha * alphaFactor > 0.01F) {
                visibleBubbles++;
            }
        }
        if (visibleBubbles == 0) return;

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);

        for (FluidBubble b : this.fluidBubbles) {
            long age = now - b.spawnTime;
            float prog = (float)age / (float)b.lifetime;
            if (prog >= 1.0F) continue;

            // Surface tension fluid oscillation
            float wobble = (float)Math.sin((age * 0.001F) * b.wobbleSpeed + b.wobblePhase) * 0.12F;

            // Bubble lifecycle:
            // 0.0 to 0.15: expand from birth
            // 0.15 to 0.82: float and wobble
            // 0.82 to 1.0: expand fast and pop/dissolve
            float scale;
            float alphaFactor;

            if (prog < 0.15F) {
                scale = (prog / 0.15F);
                alphaFactor = scale;
            } else if (prog < 0.82F) {
                scale = 1.0F + wobble;
                alphaFactor = 1.0F;
            } else {
                // Popping expansion & fade
                float popProg = (prog - 0.82F) / 0.18F;
                scale = (1.0F + wobble) * (1.0F + popProg * 0.65F);
                alphaFactor = 1.0F - popProg;
            }

            float r = b.baseRadius * scale;
            float alpha = userAlpha * alphaFactor;
            if (alpha <= 0.01F) continue;

            float cx = (float)(b.x - cam.x);
            float cy = (float)(b.y - cam.y);
            float cz = (float)(b.z - cam.z);

            // Render faceted 3D fluid sphere
            for (int i = 0; i < stacks; i++) {
                double lat0 = Math.PI * (-0.5 + (double)i / stacks);
                double lat1 = Math.PI * (-0.5 + (double)(i + 1) / stacks);
                float y0 = (float)Math.sin(lat0);
                float r0 = (float)Math.cos(lat0);
                float y1 = (float)Math.sin(lat1);
                float r1 = (float)Math.cos(lat1);

                for (int j = 0; j < slices; j++) {
                    double lon0 = 2.0 * Math.PI * (double)j / slices;
                    double lon1 = 2.0 * Math.PI * (double)(j + 1) / slices;

                    float x00 = (float)Math.cos(lon0) * r0;
                    float z00 = (float)Math.sin(lon0) * r0;
                    float x10 = (float)Math.cos(lon0) * r1;
                    float z10 = (float)Math.sin(lon0) * r1;
                    float x01 = (float)Math.cos(lon1) * r0;
                    float z01 = (float)Math.sin(lon1) * r0;
                    float x11 = (float)Math.cos(lon1) * r1;
                    float z11 = (float)Math.sin(lon1) * r1;

                    // Normal-based fluid iridescent shading + top specular highlight
                    float normalY0 = y0;
                    float normalY1 = y1;

                    // Specular highlight on top-front face
                    float spec0 = Math.max(0.0F, (normalY0 + x00 * 0.5F)) * 0.45F;
                    float spec1 = Math.max(0.0F, (normalY1 + x10 * 0.5F)) * 0.45F;

                    ColorRGBA c0 = b.color.withAlpha(Math.min(255, (int)(b.color.getAlpha() * alpha * (0.45F + spec0))));
                    ColorRGBA c1 = b.color.withAlpha(Math.min(255, (int)(b.color.getAlpha() * alpha * (0.45F + spec1))));

                    int col0 = c0.getRGB();
                    int col1 = c1.getRGB();

                    // Quad -> 2 Triangles
                    bb.vertex(mat, cx + x00 * r, cy + y0 * r, cz + z00 * r).color(col0);
                    bb.vertex(mat, cx + x10 * r, cy + y1 * r, cz + z10 * r).color(col1);
                    bb.vertex(mat, cx + x11 * r, cy + y1 * r, cz + z11 * r).color(col1);

                    bb.vertex(mat, cx + x00 * r, cy + y0 * r, cz + z00 * r).color(col0);
                    bb.vertex(mat, cx + x11 * r, cy + y1 * r, cz + z11 * r).color(col1);
                    bb.vertex(mat, cx + x01 * r, cy + y0 * r, cz + z01 * r).color(col0);
                }
            }
        }
        BuiltBuffer built = bb.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }
    }

    private static ColorRGBA hueToRGBA(float hue) {
        float h = hue / 60.0F;
        int hi = (int)h % 6;
        float f = h - (int)h;
        float q = 1.0F - f;
        return switch (hi) {
            case 0 -> new ColorRGBA(255, (int)(f * 255), 0, 255);
            case 1 -> new ColorRGBA((int)(q * 255), 255, 0, 255);
            case 2 -> new ColorRGBA(0, 255, (int)(f * 255), 255);
            case 3 -> new ColorRGBA(0, (int)(q * 255), 255, 255);
            case 4 -> new ColorRGBA((int)(f * 255), 0, 255, 255);
            default -> new ColorRGBA(255, 0, (int)(q * 255), 255);
        };
    }
}
