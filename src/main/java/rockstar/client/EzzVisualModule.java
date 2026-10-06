package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "EzzVisual",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.ezz_visual"
)
public class EzzVisualModule extends Module {
    private BooleanSetting selfSetting;
    private SliderSetting angleSetting;
    private BooleanSetting surrenderWave;
    private BooleanSetting panicTremble;
    private BooleanSetting whiteFlag;
    private BooleanSetting cryingTears;
    private BooleanSetting overheadTag;
    private BooleanSetting cowerPosture;

    private final IiIIIiII_Class69<Render3DEvent> renderEvent = this::onRender3D;

    public EzzVisualModule() {
        this.selfSetting = new BooleanSetting(this, "Affect Self");
        this.angleSetting = new SliderSetting(this, "Surrender Angle")
            .I_method_c8c9a7d7(45.0F)
            .i_method_65e2aff7(165.0F) // Increased up to 165° for skyward surrender!
            .II_method_b0f56334(5.0F)
            .Ii_method_4e0e6b54(105.0F);
        this.surrenderWave = new BooleanSetting(this, "Surrender Wave").I_method_decd82b5();
        this.panicTremble = new BooleanSetting(this, "Panic Tremble").I_method_decd82b5();
        this.whiteFlag = new BooleanSetting(this, "White Flag").I_method_decd82b5();
        this.cryingTears = new BooleanSetting(this, "Crying Tears").I_method_decd82b5();
        this.overheadTag = new BooleanSetting(this, "Overhead Tag");
        this.cowerPosture = new BooleanSetting(this, "Cower Fear").I_method_decd82b5();
    }

    @Override
    public String i_method_bf522194() {
        return "Заставляет всех игроков поднять руки высоко вверх в позе сдачи с белым флагом, слезами и паникой.";
    }

    public boolean shouldAffectSelf() {
        return this.selfSetting != null && this.selfSetting.i_method_9b12da03();
    }

    public float getAngleRadians() {
        float deg = this.angleSetting != null ? this.angleSetting.Ii_method_a20abcd2() : 105.0F;
        return (float) Math.toRadians(-deg);
    }

    public boolean isSurrenderWave() {
        return this.surrenderWave != null && this.surrenderWave.i_method_9b12da03();
    }

    public boolean isPanicTremble() {
        return this.panicTremble != null && this.panicTremble.i_method_9b12da03();
    }

    public boolean isWhiteFlag() {
        return this.whiteFlag != null && this.whiteFlag.i_method_9b12da03();
    }

    public boolean isCryingTears() {
        return this.cryingTears != null && this.cryingTears.i_method_9b12da03();
    }

    public boolean isOverheadTag() {
        return this.overheadTag != null && this.overheadTag.i_method_9b12da03();
    }

    public boolean isCowerPosture() {
        return this.cowerPosture != null && this.cowerPosture.i_method_9b12da03();
    }

    private void onRender3D(Render3DEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null || mc.player == null) return;

        float tickDelta = mc.getRenderTickCounter().getTickDelta(false);
        Vec3d camPos = event.getCamera().getPos();
        float time = (mc.player.age + tickDelta) * 0.15F;

        MatrixStack matrices = event.getMatrices();

        for (AbstractClientPlayerEntity player : mc.world.getPlayers()) {
            if (player == null || !player.isAlive()) continue;
            if (player == mc.player && !shouldAffectSelf()) continue;

            double dx = MathHelper.lerp(tickDelta, player.prevX, player.getX()) - camPos.x;
            double dy = MathHelper.lerp(tickDelta, player.prevY, player.getY()) - camPos.y;
            double dz = MathHelper.lerp(tickDelta, player.prevZ, player.getZ()) - camPos.z;

            double distSq = dx * dx + dy * dy + dz * dz;
            if (distSq > 3600.0) continue; // within 60 blocks

            float bodyYaw = MathHelper.lerp(tickDelta, player.prevBodyYaw, player.bodyYaw);

            matrices.push();
            matrices.translate(dx, dy, dz);

            // 1. WHITE SURRENDER FLAG (attached precisely to player's raised right hand)
            if (isWhiteFlag()) {
                matrices.push();
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-bodyYaw + 180.0F));

                float armDeg = this.angleSetting != null ? this.angleSetting.Ii_method_a20abcd2() : 105.0F;
                double armRad = Math.toRadians(180.0F - armDeg);
                float waveOffset = isSurrenderWave() ? (float)Math.sin(time * 5.0F) * 0.08F : 0.0F;

                // Right shoulder is at X=-0.34, Y=1.38
                // Hand socket extends along arm rotation
                float handX = -0.34F - waveOffset * 0.5F;
                float handY = 1.38F + (float)Math.cos(armRad) * 0.62F;
                float handZ = -(float)Math.sin(armRad) * 0.55F;
                if (player.isSneaking()) {
                    handY -= 0.20F;
                    handZ += 0.10F;
                }

                matrices.translate(handX, handY, handZ);

                float flagWave = (float)Math.sin(time * 6.0F) * 18.0F;
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(20.0F));
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(flagWave));
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-15.0F));

                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                RenderSystem.disableCull();
                RenderSystem.enableDepthTest();
                RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

                BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
                Matrix4f mat = matrices.peek().getPositionMatrix();

                // Brown wooden flagpole
                int woodCol = 0xFF8B5A2B;
                buf.vertex(mat, -0.015F, -0.4F, -0.015F).color(woodCol);
                buf.vertex(mat, 0.015F, -0.4F, -0.015F).color(woodCol);
                buf.vertex(mat, 0.015F, 0.55F, 0.015F).color(woodCol);
                buf.vertex(mat, -0.015F, 0.55F, 0.015F).color(woodCol);

                // Pure White Waving Surrender Flag Cloth
                int flagWhite = 0xFFFFFFFF;
                int flagShade = 0xFFE0E0E0;
                float w1 = (float)Math.sin(time * 8.0) * 0.04F;
                float w2 = (float)Math.cos(time * 8.0) * 0.06F;

                buf.vertex(mat, 0.015F, 0.52F, 0.0F).color(flagWhite);
                buf.vertex(mat, 0.22F, 0.50F, w1).color(flagShade);
                buf.vertex(mat, 0.22F, 0.26F, w1).color(flagShade);
                buf.vertex(mat, 0.015F, 0.28F, 0.0F).color(flagWhite);

                buf.vertex(mat, 0.22F, 0.50F, w1).color(flagShade);
                buf.vertex(mat, 0.45F, 0.48F, w2).color(flagWhite);
                buf.vertex(mat, 0.45F, 0.24F, w2).color(flagWhite);
                buf.vertex(mat, 0.22F, 0.26F, w1).color(flagShade);

                BuiltBuffer built = buf.endNullable();
                if (built != null) {
                    BufferRenderer.drawWithGlobalProgram(built);
                }
                RenderSystem.enableCull();
                matrices.pop();
            }

            // 2. CRYING TEARS & SWEAT PARTICLES
            if (isCryingTears()) {
                matrices.push();
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-bodyYaw + 180.0F));
                float headY = player.getEyeHeight(player.getPose());
                matrices.translate(0.0, headY, -0.22);

                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                RenderSystem.disableCull();
                RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
                BufferBuilder bufTears = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
                Matrix4f matT = matrices.peek().getPositionMatrix();

                int tearCol = 0xFF00C8FF;
                int tearHead = 0xFFE0F7FF;

                // Streams of tears flowing from left and right eye
                for (int side = -1; side <= 1; side += 2) {
                    float tearDropY = -((player.age * 0.08F + (side > 0 ? 0.4F : 0.0F)) % 0.45F);
                    float eyeX = side * 0.12F;
                    // Falling tear droplet
                    bufTears.vertex(matT, eyeX - 0.015F, tearDropY + 0.03F, 0.0F).color(tearHead);
                    bufTears.vertex(matT, eyeX + 0.015F, tearDropY + 0.03F, 0.0F).color(tearHead);
                    bufTears.vertex(matT, eyeX + 0.015F, tearDropY, 0.0F).color(tearCol);
                    bufTears.vertex(matT, eyeX - 0.015F, tearDropY, 0.0F).color(tearCol);

                    // Panic sweat drops spraying outward
                    float sweatX = eyeX + side * 0.14F + (float)Math.sin(time * 12.0) * 0.02F;
                    float sweatY = 0.08F - ((player.age * 0.06F + side * 0.2F) % 0.25F);
                    bufTears.vertex(matT, sweatX - 0.012F, sweatY + 0.02F, 0.0F).color(tearHead);
                    bufTears.vertex(matT, sweatX + 0.012F, sweatY + 0.02F, 0.0F).color(tearHead);
                    bufTears.vertex(matT, sweatX + 0.012F, sweatY, 0.0F).color(tearCol);
                    bufTears.vertex(matT, sweatX - 0.012F, sweatY, 0.0F).color(tearCol);
                }

                BuiltBuffer builtT = bufTears.endNullable();
                if (builtT != null) {
                    BufferRenderer.drawWithGlobalProgram(builtT);
                }
                RenderSystem.enableCull();
                matrices.pop();
            }

            // 3. OVERHEAD SURRENDER TAG: "🏳️ I SURRENDER! 🏳️"
            if (isOverheadTag()) {
                matrices.push();
                float tagY = player.getHeight() + 0.55F + (float)Math.sin(time * 4.0F) * 0.04F;
                matrices.translate(0.0, tagY, 0.0);
                // Billboard facing camera
                matrices.multiply(event.getCamera().getRotation());
                matrices.scale(-0.025F, -0.025F, 0.025F);

                TextRenderer tr = mc.textRenderer;
                String tag = "🏳️ I SURRENDER! 🏳️";
                float tagW = tr.getWidth(tag);

                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                RenderSystem.enableDepthTest();

                // Text (rendered cleanly without any opaque black stripe background!)
                tr.draw(tag, -tagW * 0.5F, 0.0F, 0xFFFF5555, true, matrices.peek().getPositionMatrix(), mc.getBufferBuilders().getEntityVertexConsumers(), TextRenderer.TextLayerType.SEE_THROUGH, 0, 0xF000F0);
                mc.getBufferBuilders().getEntityVertexConsumers().draw();

                matrices.pop();
            }

            matrices.pop();
        }
    }
}
