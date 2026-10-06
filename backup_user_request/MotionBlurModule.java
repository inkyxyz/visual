package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import pyrock.events.game.WorldChangeEvent;

@ModuleInfo(
    name = "Motion Blur",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.motion_blur"
)
public class MotionBlurModule extends Module {
    private static SimpleFramebuffer accumFboA;
    private static SimpleFramebuffer accumFboB;
    private static boolean needsClear = true;

    // Shader state
    private static int programId = 0;
    private static int locCurrentFrame = -1;
    private static int locAccumFrame = -1;
    private static int locBlurStrength = -1;
    private static int quadVao = 0;
    private static int quadVbo = 0;
    private static boolean shaderInitialized = false;

    private static final float[] QUAD_VERTICES = new float[] {
        -1.0f, -1.0f,  0.0f, 0.0f,
         1.0f, -1.0f,  1.0f, 0.0f,
         1.0f,  1.0f,  1.0f, 1.0f,
        -1.0f,  1.0f,  0.0f, 1.0f
    };

    private static final String VERTEX_SHADER =
        "#version 150\n" +
        "in vec2 Position;\n" +
        "in vec2 UV;\n" +
        "out vec2 TexCoord;\n" +
        "void main() {\n" +
        "    gl_Position = vec4(Position, 0.0, 1.0);\n" +
        "    TexCoord = UV;\n" +
        "}\n";

    private static final String FRAGMENT_SHADER =
        "#version 150\n" +
        "uniform sampler2D CurrentFrame;\n" +
        "uniform sampler2D AccumFrame;\n" +
        "uniform float BlurStrength;\n" +
        "in vec2 TexCoord;\n" +
        "out vec4 OutColor;\n" +
        "void main() {\n" +
        "    vec4 curr = texture(CurrentFrame, TexCoord);\n" +
        "    vec4 accum = texture(AccumFrame, TexCoord);\n" +
        "    OutColor = vec4(mix(curr.rgb, accum.rgb, BlurStrength), 1.0);\n" +
        "}\n";

    private SliderSetting blurStrength;

    private final IiIIIiII_Class69<WorldChangeEvent> worldChangeListener = var1 -> {
        needsClear = true;
    };

    public MotionBlurModule() {
        this.blurStrength = new SliderSetting(this, "Strength")
            .I_method_c8c9a7d7(0.05F)
            .i_method_65e2aff7(0.95F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(0.50F);
    }

    @Override
    public void onEnable() {
        needsClear = true;
    }

    @Override
    public void onDisable() {
        needsClear = true;
        if (accumFboA != null) {
            accumFboA.delete();
            accumFboA = null;
        }
        if (accumFboB != null) {
            accumFboB.delete();
            accumFboB = null;
        }
    }

    @Override
    public String i_method_bf522194() {
        return "Плавное кинематографичное размытие движения в 3D мире без замыливания интерфейса.";
    }

    private static void initShader() {
        if (shaderInitialized) return;
        try {
            int vShader = GlStateManager.glCreateShader(35633); // GL_VERTEX_SHADER
            GlStateManager.glShaderSource(vShader, VERTEX_SHADER);
            GlStateManager.glCompileShader(vShader);
            if (GlStateManager.glGetShaderi(vShader, 35713) == 0) { // GL_COMPILE_STATUS
                String log = GlStateManager.glGetShaderInfoLog(vShader, 2048);
                GlStateManager.glDeleteShader(vShader);
                System.err.println("[MotionBlur] Vertex compile error: " + log);
                return;
            }

            int fShader = GlStateManager.glCreateShader(35632); // GL_FRAGMENT_SHADER
            GlStateManager.glShaderSource(fShader, FRAGMENT_SHADER);
            GlStateManager.glCompileShader(fShader);
            if (GlStateManager.glGetShaderi(fShader, 35713) == 0) {
                String log = GlStateManager.glGetShaderInfoLog(fShader, 2048);
                GlStateManager.glDeleteShader(vShader);
                GlStateManager.glDeleteShader(fShader);
                System.err.println("[MotionBlur] Fragment compile error: " + log);
                return;
            }

            programId = GlStateManager.glCreateProgram();
            GlStateManager.glAttachShader(programId, vShader);
            GlStateManager.glAttachShader(programId, fShader);
            GlStateManager._glBindAttribLocation(programId, 0, "Position");
            GlStateManager._glBindAttribLocation(programId, 1, "UV");
            GlStateManager.glLinkProgram(programId);
            GlStateManager.glDeleteShader(vShader);
            GlStateManager.glDeleteShader(fShader);

            if (GlStateManager.glGetProgrami(programId, 35714) == 0) { // GL_LINK_STATUS
                String log = GlStateManager.glGetProgramInfoLog(programId, 2048);
                GlStateManager.glDeleteProgram(programId);
                programId = 0;
                System.err.println("[MotionBlur] Link error: " + log);
                return;
            }

            locCurrentFrame = GlStateManager._glGetUniformLocation(programId, "CurrentFrame");
            locAccumFrame = GlStateManager._glGetUniformLocation(programId, "AccumFrame");
            locBlurStrength = GlStateManager._glGetUniformLocation(programId, "BlurStrength");

            quadVao = GlStateManager._glGenVertexArrays();
            quadVbo = GlStateManager._glGenBuffers();
            GlStateManager._glBindVertexArray(quadVao);
            GlStateManager._glBindBuffer(34962, quadVbo);
            GL15.glBufferData(34962, QUAD_VERTICES, 35044); // GL_STATIC_DRAW
            GL20.glEnableVertexAttribArray(0);
            GL20.glVertexAttribPointer(0, 2, 5126, false, 16, 0L);
            GL20.glEnableVertexAttribArray(1);
            GL20.glVertexAttribPointer(1, 2, 5126, false, 16, 8L);
            GlStateManager._glBindBuffer(34962, 0);
            GlStateManager._glBindVertexArray(0);

            shaderInitialized = true;
        } catch (Throwable t) {
            System.err.println("[MotionBlur] Shader init error: " + t);
        }
    }

    public static void onRenderWorldEnd() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.player == null || mc.world == null) {
            return;
        }
        MotionBlurModule mod = RockstarClient.getInstance() != null && RockstarClient.getInstance().getModuleManager() != null
            ? RockstarClient.getInstance().getModuleManager().getModule(MotionBlurModule.class)
            : null;
        if (mod == null || !mod.isEnabled()) {
            return;
        }
        Framebuffer mainFbo = mc.getFramebuffer();
        if (mainFbo == null || mainFbo.textureWidth <= 0 || mainFbo.textureHeight <= 0) {
            return;
        }

        if (!shaderInitialized) {
            initShader();
            if (!shaderInitialized) return;
        }

        int width = mainFbo.textureWidth;
        int height = mainFbo.textureHeight;

        if (accumFboA == null || accumFboA.textureWidth != width || accumFboA.textureHeight != height) {
            if (accumFboA != null) accumFboA.delete();
            if (accumFboB != null) accumFboB.delete();
            accumFboA = new SimpleFramebuffer(width, height, false);
            accumFboA.setTexFilter(9729); // GL_LINEAR
            accumFboB = new SimpleFramebuffer(width, height, false);
            accumFboB.setTexFilter(9729); // GL_LINEAR
            needsClear = true;
        }

        float blur = MathHelper.clamp(mod.blurStrength.Ii_method_a20abcd2(), 0.05F, 0.95F);

        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.disableCull();

        try {
            GlStateManager._glUseProgram(programId);

            if (needsClear) {
                // Populate accum buffer with current scene directly
                accumFboA.beginWrite(true);
                if (locCurrentFrame >= 0) GL20.glUniform1i(locCurrentFrame, 0);
                if (locAccumFrame >= 0) GL20.glUniform1i(locAccumFrame, 0);
                if (locBlurStrength >= 0) GL20.glUniform1f(locBlurStrength, 0.0F);

                GlStateManager._activeTexture(33984);
                GlStateManager._bindTexture(mainFbo.getColorAttachment());

                GlStateManager._glBindVertexArray(quadVao);
                GL11.glDrawArrays(GL11.GL_TRIANGLE_FAN, 0, 4);
                GlStateManager._glBindVertexArray(0);

                accumFboA.endWrite();
                needsClear = false;
            } else {
                // Pass 1: Blend current frame + previous accum buffer into accumFboB
                accumFboB.beginWrite(true);
                if (locCurrentFrame >= 0) GL20.glUniform1i(locCurrentFrame, 0);
                if (locAccumFrame >= 0) GL20.glUniform1i(locAccumFrame, 1);
                if (locBlurStrength >= 0) GL20.glUniform1f(locBlurStrength, blur);

                GlStateManager._activeTexture(33984);
                GlStateManager._bindTexture(mainFbo.getColorAttachment());

                GlStateManager._activeTexture(33985);
                GlStateManager._bindTexture(accumFboA.getColorAttachment());

                GlStateManager._glBindVertexArray(quadVao);
                GL11.glDrawArrays(GL11.GL_TRIANGLE_FAN, 0, 4);
                GlStateManager._glBindVertexArray(0);

                accumFboB.endWrite();

                // Pass 2: Blit accumFboB to mainFbo so user sees it
                mainFbo.beginWrite(true);
                if (locCurrentFrame >= 0) GL20.glUniform1i(locCurrentFrame, 0);
                if (locBlurStrength >= 0) GL20.glUniform1f(locBlurStrength, 0.0F);

                GlStateManager._activeTexture(33984);
                GlStateManager._bindTexture(accumFboB.getColorAttachment());

                GlStateManager._glBindVertexArray(quadVao);
                GL11.glDrawArrays(GL11.GL_TRIANGLE_FAN, 0, 4);
                GlStateManager._glBindVertexArray(0);

                mainFbo.endWrite();

                // Ping-pong swap
                SimpleFramebuffer temp = accumFboA;
                accumFboA = accumFboB;
                accumFboB = temp;
            }

            GlStateManager._activeTexture(33985);
            GlStateManager._bindTexture(0);
            GlStateManager._activeTexture(33984);
            GlStateManager._bindTexture(0);
            GlStateManager._glUseProgram(0);
        } catch (Throwable t) {
            System.err.println("[MotionBlur] Render error: " + t);
        } finally {
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.enableCull();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            mainFbo.beginWrite(true);
        }
    }
}
