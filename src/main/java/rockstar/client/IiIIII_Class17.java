package rockstar.client;

import net.minecraft.client.render.VertexConsumer;
import org.joml.Matrix4f;

public final class IiIIII_Class17 {
    private static final float I_field_46 = 1.0f;
    private final int I_field_49;
    private final int i_field_49;
    private final float i_field_46;
    private final float II_field_46;
    private final float Ii_field_46;
    private final float iI_field_46;
    private final float ii_field_46;

    public IiIIII_Class17(int n, int n2, float f, float f2, float f3, float f4, float f5) {
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.i_field_46 = f;
        this.II_field_46 = f2;
        this.ii_field_46 = f3;
        this.Ii_field_46 = f4;
        this.iI_field_46 = f5;
    }

    public int I_method_704ea23f() {
        return this.I_field_49;
    }

    public int i_method_705d2e1f() {
        return this.i_field_49;
    }

    public float I_method_704ea23c() {
        return this.i_field_46;
    }

    public float i_method_705d2e1c() {
        return this.iI_field_46;
    }

    public float II_method_99949e85() {
        return this.ii_field_46;
    }

    public float Ii_method_99a32a65() {
        return this.II_field_46;
    }

    public float iI_method_9b578ea5() {
        return this.Ii_field_46;
    }

    public boolean I_method_704ea250() {
        return this.i_field_49 < 0;
    }

    public float I_method_99860ee4(float f) {
        return this.i_field_46 * f;
    }

    public float I_method_504b19e4(float f, float f2, float f3) {
        return f + this.i_method_cdd74b1c(f2, f3) * f2;
    }

    public float i_method_ed128204(float f, float f2, float f3) {
        return f - this.iI_method_23bbad65(f2, f3) * f2;
    }

    public static float I_method_bf203252(Matrix4f matrix4f) {
        float f = matrix4f.m00() * matrix4f.m11() - matrix4f.m01() * matrix4f.m10();
        float f2 = (float)Math.sqrt(Math.abs(f));
        return f2 > 1.0E-4f ? f2 : 1.0f;
    }

    public float i_method_9b48ff04(float f) {
        return this.I_method_973c373c(f, 1.0f);
    }

    public float I_method_973c373c(float f, float f2) {
        return 1.0f / (f * f2);
    }

    public float i_method_cdd74b1c(float f, float f2) {
        return this.II_field_46 - this.I_method_973c373c(f, f2);
    }

    public float II_method_86f44545(float f, float f2) {
        return this.Ii_field_46 + this.I_method_973c373c(f, f2);
    }

    public float Ii_method_bd8f5925(float f, float f2) {
        return this.ii_field_46 - this.I_method_973c373c(f, f2);
    }

    public float iI_method_23bbad65(float f, float f2) {
        return this.iI_field_46 + this.I_method_973c373c(f, f2);
    }

    public float ii_method_5a56c145(float f, float f2) {
        return (this.II_method_86f44545(f, f2) - this.i_method_cdd74b1c(f, f2)) * f;
    }

    public float III_method_8e3df85c(float f, float f2) {
        return (this.iI_method_23bbad65(f, f2) - this.Ii_method_bd8f5925(f, f2)) * f;
    }

    public float I_method_14765d05(Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float f2, float f3, float f4, int n) {
        return this.I_method_7a55ad3b(matrix4f, vertexConsumer, f, f2, f3, f4, n, 1.0f);
    }

    public float I_method_7a55ad3b(Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float f2, float f3, float f4, int n, float f5) {
        if (this.i_field_49 >= 0) {
            float f6 = Math.max(1.0f, f5) / (f * IiIIII_Class17.I_method_bf203252(matrix4f));
            float f7 = this.II_field_46 - f6;
            float f8 = this.Ii_field_46 + f6;
            float f9 = this.iI_field_46 + f6;
            float f10 = this.ii_field_46 - f6;
            float f11 = f2 + f7 * f;
            float f12 = f2 + f8 * f;
            float f13 = f3 - f9 * f;
            float f14 = f3 - f10 * f;
            vertexConsumer.vertex(matrix4f, f11, f13, f4).texture(f7, f9).color(n).light(this.II_method_99949e88());
            vertexConsumer.vertex(matrix4f, f11, f14, f4).texture(f7, f10).color(n).light(this.II_method_99949e88());
            vertexConsumer.vertex(matrix4f, f12, f14, f4).texture(f8, f10).color(n).light(this.II_method_99949e88());
            vertexConsumer.vertex(matrix4f, f12, f13, f4).texture(f8, f9).color(n).light(this.II_method_99949e88());
        }
        return this.i_field_46 * f;
    }

    public void I_method_4afb96f1(Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float f2, float f3, int n) {
        if (this.i_field_49 < 0) {
            return;
        }
        float f4 = 1.0f / (f3 * IiIIII_Class17.I_method_bf203252(matrix4f));
        float f5 = this.II_field_46 - f4;
        float f6 = this.Ii_field_46 + f4;
        float f7 = this.iI_field_46 + f4;
        float f8 = this.ii_field_46 - f4;
        float f9 = f + f5 * f3;
        float f10 = f + f6 * f3;
        float f11 = f2 + (1.0f - f7) * f3;
        float f12 = f2 + (1.0f - f8) * f3;
        vertexConsumer.vertex(matrix4f, f9, f11, 0.0f).texture(f5, f7).color(n).light(this.II_method_99949e88());
        vertexConsumer.vertex(matrix4f, f9, f12, 0.0f).texture(f5, f8).color(n).light(this.II_method_99949e88());
        vertexConsumer.vertex(matrix4f, f10, f12, 0.0f).texture(f6, f8).color(n).light(this.II_method_99949e88());
        vertexConsumer.vertex(matrix4f, f10, f11, 0.0f).texture(f6, f7).color(n).light(this.II_method_99949e88());
    }

    public int II_method_99949e88() {
        int n = this.i_field_49 + 1;
        return n & Short.MAX_VALUE | n >> 15 << 16;
    }
}

