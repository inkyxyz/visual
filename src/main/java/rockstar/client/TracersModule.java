package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Tracers",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.tracers"
)
public class TracersModule extends Module {
    private final BooleanSetting playersOnly = new BooleanSetting(this, "modules.settings.tracers.players_only").I_method_decd82b5();
    private final BooleanSetting syncTheme = new BooleanSetting(this, "modules.settings.tracers.sync_theme").I_method_decd82b5();
    private final ColorSetting customColor = new ColorSetting(this, "modules.settings.tracers.color")
        .I_method_a62f5dd6(new ColorRGBA(139.0F, 92.0F, 246.0F, 220.0F));
    private final SliderSetting lineWidth = new SliderSetting(this, "modules.settings.tracers.width")
        .I_method_c8c9a7d7(1.0F)
        .i_method_65e2aff7(4.0F)
        .II_method_b0f56334(0.5F)
        .Ii_method_4e0e6b54(1.5F);

    private final IiIIIiII_Class69<Render3DEvent> onRender3D = event -> {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null || mc.player == null) return;

        Camera camera = event.getCamera();
        Vec3d camPos = camera.getPos();
        ColorRGBA col = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.customColor.I_method_bde5f08e();

        MatrixStack matrices = event.getMatrices();
        matrices.push();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.lineWidth(this.lineWidth.Ii_method_a20abcd2());
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        Matrix4f mat = matrices.peek().getPositionMatrix();

        float r = col.getRed() / 255.0F;
        float g = col.getGreen() / 255.0F;
        float b = col.getBlue() / 255.0F;
        float a = col.getAlpha() / 255.0F;

        Vec3d lookVec = mc.player.getRotationVec(event.getTickDelta());
        float startX = (float) lookVec.x;
        float startY = (float) lookVec.y;
        float startZ = (float) lookVec.z;

        for (Entity entity : mc.world.getEntities()) {
            if (entity == mc.player) continue;
            if (this.playersOnly.i_method_9b12da03() && !(entity instanceof PlayerEntity)) continue;

            double targetX = entity.getX() - camPos.x;
            double targetY = entity.getY() + entity.getHeight() * 0.5 - camPos.y;
            double targetZ = entity.getZ() - camPos.z;

            bb.vertex(mat, startX, startY, startZ).color(r, g, b, a * 0.4F);
            bb.vertex(mat, (float) targetX, (float) targetY, (float) targetZ).color(r, g, b, a);
        }

        BuiltBuffer built = bb.endNullable();
        if (built != null) {
            BufferRenderer.drawWithGlobalProgram(built);
        }

        RenderSystem.enableDepthTest();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        matrices.pop();
    };

    public TracersModule() {
    }
}
