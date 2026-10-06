package pyrock.events.render;

import lombok.Generated;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="render_3d")
public class Render3DEvent
extends IiIIIIIi_Class66 {
    private final MatrixStack matrices;
    private final Matrix4f positionMatrix;
    private final Matrix4f projectionMatrix;
    private final Camera camera;
    private final float tickDelta;

    @Generated
    public MatrixStack getMatrices() {
        return this.matrices;
    }

    @Generated
    public Matrix4f getPositionMatrix() {
        return this.positionMatrix;
    }

    @Generated
    public Matrix4f getProjectionMatrix() {
        return this.projectionMatrix;
    }

    @Generated
    public Camera getCamera() {
        return this.camera;
    }

    @Generated
    public float getTickDelta() {
        return this.tickDelta;
    }

    @Generated
    public Render3DEvent(MatrixStack matrixStack, Matrix4f matrix4f, Matrix4f matrix4f2, Camera camera, float f) {
        this.matrices = matrixStack;
        this.positionMatrix = matrix4f;
        this.projectionMatrix = matrix4f2;
        this.camera = camera;
        this.tickDelta = f;
    }
}

