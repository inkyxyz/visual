package rockstar.client;

import lombok.Generated;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import rockstar.client.iIIiIIiIi_Class294;

public final class iIiiiiIII_Class377
implements iIIiIIiIi_Class294 {
    private static Matrix4f I_field_d754d74;
    private static Matrix4f i_field_d754d74;

    public static void I_method_29c8dc1f(Matrix4f matrix4f, Matrix4f matrix4f2) {
        I_field_d754d74 = new Matrix4f((Matrix4fc)matrix4f);
        i_field_d754d74 = new Matrix4f((Matrix4fc)matrix4f2);
    }

    public static Vec2f I_method_211fc242(Vec3d vec3d) {
        Camera camera = iIiiiiIII_Class377.I_field_3a9bda27.gameRenderer.getCamera();
        Vec3d vec3d2 = vec3d.subtract(camera.getPos());
        Vector4f vector4f = new Vector4f((float)vec3d2.x, (float)vec3d2.y, (float)vec3d2.z, 1.0f);
        vector4f.mul((Matrix4fc)I_field_d754d74).mul((Matrix4fc)i_field_d754d74);
        if (vector4f.w <= 0.0f) {
            return null;
        }
        Vector4f vector4f2 = vector4f.div(vector4f.w);
        float f = (vector4f2.x + 1.0f) / 2.0f * (float)I_field_3a9bda27.getWindow().getScaledWidth();
        float f2 = (1.0f - vector4f2.y) / 2.0f * (float)I_field_3a9bda27.getWindow().getScaledHeight();
        return new Vec2f(f, f2);
    }

    public static Vec2f i_method_d90ec262(Vec3d vec3d) {
        if (i_field_d754d74 == null) {
            return null;
        }
        Camera camera = iIiiiiIII_Class377.I_field_3a9bda27.gameRenderer.getCamera();
        float f = camera.getYaw() * ((float)Math.PI / 180);
        float f2 = camera.getPitch() * ((float)Math.PI / 180);
        double d = MathHelper.cos((float)f);
        double d2 = MathHelper.sin((float)f);
        double d3 = MathHelper.cos((float)f2);
        double d4 = MathHelper.sin((float)f2);
        Vec3d vec3d2 = new Vec3d(-d2 * d3, -d4, d * d3);
        Vec3d vec3d3 = new Vec3d(-d, 0.0, -d2);
        Vec3d vec3d4 = vec3d3.crossProduct(vec3d2);
        double d5 = vec3d.dotProduct(vec3d2);
        if (d5 <= 1.0E-4) {
            return null;
        }
        double d6 = (double)i_field_d754d74.m00() * vec3d.dotProduct(vec3d3) / d5;
        double d7 = (double)i_field_d754d74.m11() * vec3d.dotProduct(vec3d4) / d5;
        return new Vec2f((float)((d6 + 1.0) / 2.0 * (double)I_field_3a9bda27.getWindow().getScaledWidth()), (float)((1.0 - d7) / 2.0 * (double)I_field_3a9bda27.getWindow().getScaledHeight()));
    }

    public static Vec3d I_method_689b1a13(Entity entity, float f) {
        return new Vec3d(MathHelper.lerp((double)f, (double)entity.prevX, (double)entity.getX()), MathHelper.lerp((double)f, (double)entity.prevY, (double)entity.getY()), MathHelper.lerp((double)f, (double)entity.prevZ, (double)entity.getZ()));
    }

    public static Vec3d I_method_156f92bb(Vec3d vec3d, Vec3d vec3d2, float f) {
        return new Vec3d(MathHelper.lerp((double)f, (double)vec3d.x, (double)vec3d2.getX()), MathHelper.lerp((double)f, (double)vec3d.y, (double)vec3d2.getY()), MathHelper.lerp((double)f, (double)vec3d.z, (double)vec3d2.getZ()));
    }

    @Generated
    private iIiiiiIII_Class377() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

