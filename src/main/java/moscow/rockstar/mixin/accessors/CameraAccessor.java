package moscow.rockstar.mixin.accessors;

import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Camera.class})
public interface CameraAccessor {
    @Accessor(value="thirdPerson")
    public void setThirdPerson(boolean var1);

    @Accessor(value="cameraY")
    public float getCameraY();

    @Accessor(value="lastCameraY")
    public float getLastCameraY();

    @Invoker(value="setPos")
    public void invokeSetPos(Vec3d var1);

    @Invoker(value="setRotation")
    public void invokeSetRotation(float var1, float var2);

    @Invoker(value="moveBy")
    public void invokeMoveBy(float var1, float var2, float var3);

    @Invoker(value="clipToSpace")
    public float invokeClipToSpace(float var1);
}

