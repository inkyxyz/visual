package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

@ModuleInfo(
    name = "Aspect Ratio",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.aspect_ratio"
)
public class AspectRatioModule extends Module {
    private SliderSetting widthStretch;
    private SliderSetting heightStretch;

    public AspectRatioModule() {
        this.widthStretch = new SliderSetting(this, "Width Stretch")
            .I_method_c8c9a7d7(0.5F)
            .i_method_65e2aff7(2.0F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(1.0F);

        this.heightStretch = new SliderSetting(this, "Height Stretch")
            .I_method_c8c9a7d7(0.5F)
            .i_method_65e2aff7(2.0F)
            .II_method_b0f56334(0.05F)
            .Ii_method_4e0e6b54(1.0F);
    }

    @Override
    public String i_method_bf522194() {
        return "Stretches the screen aspect ratio (like Stretched Res in CS).";
    }

    /**
     * Called from GameRendererMixin to modify the projection matrix.
     * Returns null if no modification is needed.
     */
    public Matrix4f modifyProjection(Matrix4f original, float fov) {
        float ws = this.widthStretch.Ii_method_a20abcd2();
        float hs = this.heightStretch.Ii_method_a20abcd2();
        if (Math.abs(ws - 1.0F) < 0.01F && Math.abs(hs - 1.0F) < 0.01F) {
            return null; // No modification
        }
        Matrix4f modified = new Matrix4f(original);
        modified.scale(ws, hs, 1.0F);
        return modified;
    }

    public float getWidthStretch() {
        return this.widthStretch.Ii_method_a20abcd2();
    }

    public float getHeightStretch() {
        return this.heightStretch.Ii_method_a20abcd2();
    }
}
