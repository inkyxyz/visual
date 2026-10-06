package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIiIIiIi_Class294;

public class IiiiIiIiI_Class235
implements iIIiIIiIi_Class294 {
    private Vec3d I_field_5bba0d50;
    private Vec3d i_field_5bba0d50;
    private Vec3d II_field_5bba0d50;
    private float I_field_46 = 3.0f;
    private final Identifier I_field_6a3d6525;
    private int I_field_49;
    private int i_field_49 = 100;
    private double I_field_44 = 0.04;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private final IiiiIiIii_Class236 I_field_dc7facc;
    private final IiiiIiIii_Class236 i_field_dc7facc;
    private final ColorRGBA I_field_d0c8ec5;

    public IiiiIiIiI_Class235(Vec3d vec3d, Vec3d vec3d2, Identifier identifier, ColorRGBA colorRGBA) {
        this.I_field_5bba0d50 = vec3d;
        this.i_field_5bba0d50 = vec3d;
        this.II_field_5bba0d50 = vec3d2;
        this.I_field_6a3d6525 = identifier;
        this.I_field_d0c8ec5 = colorRGBA;
        this.I_field_49 = 0;
        long l = this.i_field_49 * 5;
        this.I_field_dc7facc = new IiiiIiIii_Class236(l, IiiiIiiII_Class237.IIIi_field_dd60aac);
        this.i_field_dc7facc = new IiiiIiIii_Class236(l, IiiiIiiII_Class237.Iii_field_dd60aac);
        this.I_field_5a = true;
    }

    public void I_method_3429c69f() {
        ++this.I_field_49;
        if (this.I_field_49 >= this.i_field_49) {
            this.i_method_3438527f();
        }
        this.i_field_5bba0d50 = this.I_field_5bba0d50;
        this.I_field_5bba0d50 = this.I_field_5bba0d50.add(this.II_field_5bba0d50);
    }

    public void I_method_dfdf8571(BufferBuilder bufferBuilder, Camera camera) {
        this.I_field_dc7facc.I_method_edd6dd11(this.I_method_3429c6a3() ? 0.0f : 1.0f);
        this.i_field_dc7facc.I_method_edd6dd11(this.I_method_3429c6a3() ? 0.0f : 1.0f);
        float f = 10.0f;
        ColorRGBA colorRGBA = ColorRGBA.fromInt(this.I_field_d0c8ec5.getRGB()).withAlpha(255.0f * this.I_field_dc7facc.I_method_6ac4da6f());
        RenderSystem.setShaderTexture((int)0, (Identifier)this.I_field_6a3d6525);
        MatrixStack matrixStack = new MatrixStack();
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(camera.getPitch()));
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(camera.getYaw() + 180.0f));
        Vec3d vec3d = this.I_method_adf88059(this.i_field_5bba0d50, this.I_field_5bba0d50);
        matrixStack.translate(vec3d.getX(), vec3d.getY(), vec3d.getZ());
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-camera.getYaw()));
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(camera.getPitch()));
        bufferBuilder.vertex(matrix4f, 0.0f, -f, 0.0f).texture(0.0f, 1.0f).color(colorRGBA.getRGB());
        bufferBuilder.vertex(matrix4f, -f, -f, 0.0f).texture(1.0f, 1.0f).color(colorRGBA.getRGB());
        bufferBuilder.vertex(matrix4f, -f, 0.0f, 0.0f).texture(1.0f, 0.0f).color(colorRGBA.getRGB());
        bufferBuilder.vertex(matrix4f, 0.0f, 0.0f, 0.0f).texture(0.0f, 0.0f).color(colorRGBA.getRGB());
    }

    public void I_method_4af6117f(double d, double d2, double d3) {
        this.I_field_5bba0d50 = new Vec3d(d, d2, d3);
    }

    public void i_method_e7bd799f(double d, double d2, double d3) {
        this.II_field_5bba0d50 = new Vec3d(d, d2, d3);
    }

    private void i_method_3438527f() {
        this.I_field_5a = false;
    }

    public boolean I_method_3429c6a3() {
        return !this.I_field_5a;
    }

    public boolean i_method_34385283() {
        return this.I_method_3429c6a3() && this.I_field_dc7facc.I_method_6ac4da6f() == 0.0f;
    }

    private Vec3d I_method_adf88059(Vec3d vec3d, Vec3d vec3d2) {
        double d = vec3d.getX() + (vec3d2.getX() - vec3d.getX()) * (double)IiiiIiIiI_Class235.i_method_3438526f() - IiiiIiIiI_Class235.I_field_3a9bda27.getEntityRenderDispatcher().camera.getPos().getX();
        double d2 = vec3d.getY() + (vec3d2.getY() - vec3d.getY()) * (double)IiiiIiIiI_Class235.i_method_3438526f() - IiiiIiIiI_Class235.I_field_3a9bda27.getEntityRenderDispatcher().camera.getPos().getY();
        double d3 = vec3d.getZ() + (vec3d2.getZ() - vec3d.getZ()) * (double)IiiiIiIiI_Class235.i_method_3438526f() - IiiiIiIiI_Class235.I_field_3a9bda27.getEntityRenderDispatcher().camera.getPos().getZ();
        return new Vec3d(d, d2, d3);
    }

    private static float i_method_3438526f() {
        return I_field_3a9bda27.getRenderTickCounter().getTickDelta(false);
    }

    @Generated
    public Vec3d I_method_a3666dd9() {
        return this.I_field_5bba0d50;
    }

    @Generated
    public Vec3d i_method_475ef1b9() {
        return this.i_field_5bba0d50;
    }

    @Generated
    public Vec3d II_method_3c94849c() {
        return this.II_field_5bba0d50;
    }

    @Generated
    public float I_method_3429c68f() {
        return this.I_field_46;
    }

    @Generated
    public Identifier I_method_b1e9c5ae() {
        return this.I_field_6a3d6525;
    }

    @Generated
    public int I_method_3429c692() {
        return this.I_field_49;
    }

    @Generated
    public int i_method_34385272() {
        return this.i_field_49;
    }

    @Generated
    public double I_method_3429c68d() {
        return this.I_field_44;
    }

    @Generated
    public boolean II_method_511e04a6() {
        return this.I_field_5a;
    }

    @Generated
    public boolean Ii_method_512c9086() {
        return this.i_field_5a;
    }

    @Generated
    public IiiiIiIii_Class236 I_method_fbc407d5() {
        return this.I_field_dc7facc;
    }

    @Generated
    public IiiiIiIii_Class236 i_method_11597bb5() {
        return this.i_field_dc7facc;
    }

    @Generated
    public ColorRGBA I_method_1b22f10e() {
        return this.I_field_d0c8ec5;
    }

    @Generated
    public void I_method_dbbe930b(Vec3d vec3d) {
        this.I_field_5bba0d50 = vec3d;
    }

    @Generated
    public void i_method_b6d68b2b(Vec3d vec3d) {
        this.i_field_5bba0d50 = vec3d;
    }

    @Generated
    public void II_method_685354a8(Vec3d vec3d) {
        this.II_field_5bba0d50 = vec3d;
    }

    @Generated
    public void I_method_510f7501(float f) {
        this.I_field_46 = f;
    }

    @Generated
    public void I_method_510f8044(int n) {
        this.I_field_49 = n;
    }

    @Generated
    public void i_method_52d27064(int n) {
        this.i_field_49 = n;
    }

    @Generated
    public void I_method_510f6d7f(double d) {
        this.I_field_44 = d;
    }

    @Generated
    public void I_method_510fc015(boolean bl) {
        this.I_field_5a = bl;
    }

    @Generated
    public void i_method_52d2b035(boolean bl) {
        this.i_field_5a = bl;
    }
}

