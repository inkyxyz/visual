package rockstar.client;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.Generated;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MatrixUtil;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiiiiIii_Class380;

public final class iIiiiIiII_Class373
implements iIIiIIiii_Class296 {
    private static final Deque<Nested1_a871a0a0> I_field_db650847 = new ArrayDeque<Nested1_a871a0a0>();
    private static final Deque<Boolean> i_field_db650847 = new ArrayDeque<Boolean>();
    private static boolean I_field_5a;

    private static void I_method_ff9e3622(Nested1_a871a0a0 nested1_a871a0a0) {
        int n = I_field_587075c2.getFramebufferHeight();
        double d = I_field_587075c2.getScaleFactor();
        float f = nested1_a871a0a0.I_field_46 * (float)d;
        float f2 = nested1_a871a0a0.i_field_46 * (float)d;
        float f3 = (nested1_a871a0a0.I_field_46 + nested1_a871a0a0.II_field_46) * (float)d;
        float f4 = (nested1_a871a0a0.i_field_46 + nested1_a871a0a0.Ii_field_46) * (float)d;
        int n2 = (int)Math.floor(f);
        int n3 = (int)Math.floor((double)n - Math.ceil(f4) + 0.5);
        int n4 = (int)Math.max(0.0f, (float)((int)Math.ceil(f3) - n2));
        int n5 = (int)Math.max(0.0f, (float)((int)Math.ceil(f4) - (int)Math.floor(f2)) - 1.0f);
        GL11.glEnable((int)3089);
        GL11.glScissor((int)n2, (int)n3, (int)n4, (int)n5);
    }

    public static void I_method_594a8a5f(float f, float f2, float f3, float f4) {
        Nested1_a871a0a0 nested1_a871a0a0 = new Nested1_a871a0a0(f, f2, f3, f4);
        iIiiiIiII_Class373.i_method_ba95b642(nested1_a871a0a0);
    }

    public static void I_method_d5a5ee51(MatrixStack matrixStack, float f, float f2, float f3, float f4) {
        Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        Nested1_a871a0a0 nested1_a871a0a0 = new Nested1_a871a0a0(f, f2, f3, f4).I_method_4d36cf65(matrix4f);
        iIiiiIiII_Class373.i_method_ba95b642(nested1_a871a0a0);
    }

    public static void I_method_51bc4c6f(Matrix4f matrix4f, float f, float f2, float f3, float f4) {
        Nested1_a871a0a0 nested1_a871a0a0 = new Nested1_a871a0a0(f, f2, f3, f4);
        if (matrix4f != null) {
            nested1_a871a0a0 = nested1_a871a0a0.I_method_4d36cf65(matrix4f);
        }
        iIiiiIiII_Class373.i_method_ba95b642(nested1_a871a0a0);
    }

    private static void i_method_ba95b642(Nested1_a871a0a0 nested1_a871a0a0) {
        boolean bl = iIiiiiIii_Class380.I_method_5f4b6223();
        if (bl) {
            iIiiiiIii_Class380.i_method_5f59edff();
        } else {
            iIiiiiIii_Class380.I_method_5f4b621f();
        }
        if (!I_field_db650847.isEmpty()) {
            nested1_a871a0a0 = iIiiiIiII_Class373.I_method_37ff0ed0(I_field_db650847.peek(), nested1_a871a0a0);
        }
        I_field_db650847.push(nested1_a871a0a0);
        i_field_db650847.push(bl);
        if (bl) {
            iIiiiiIii_Class380.II_method_752e8438().I_method_593b2a9f(nested1_a871a0a0.I_field_46, nested1_a871a0a0.i_field_46, nested1_a871a0a0.II_field_46, nested1_a871a0a0.Ii_field_46);
            if (I_field_5a) {
                iIiiiIiII_Class373.I_method_ff9e3622(nested1_a871a0a0);
            }
        } else {
            iIiiiIiII_Class373.I_method_ff9e3622(nested1_a871a0a0);
        }
    }

    public static void I_method_ff80a1df() {
        boolean bl;
        boolean bl2 = bl = !i_field_db650847.isEmpty() && i_field_db650847.peek() != false;
        if (bl) {
            iIiiiiIii_Class380.i_method_5f59edff();
        } else {
            iIiiiiIii_Class380.I_method_5f4b621f();
        }
        if (!I_field_db650847.isEmpty()) {
            I_field_db650847.pop();
        }
        if (!i_field_db650847.isEmpty()) {
            i_field_db650847.pop();
        }
        if (bl && iIiiiiIii_Class380.II_method_752e8438() != null) {
            iIiiiiIii_Class380.II_method_752e8438().II_method_8a2fd922();
        }
        if (!I_field_db650847.isEmpty()) {
            if (!bl || I_field_5a) {
                iIiiiIiII_Class373.I_method_ff9e3622(I_field_db650847.peek());
            }
        } else {
            GL11.glDisable((int)3089);
            I_field_5a = false;
        }
    }

    public static void i_method_ff8f2dbf() {
        if (I_field_db650847.isEmpty() || i_field_db650847.isEmpty() || !i_field_db650847.peek().booleanValue()) {
            return;
        }
        iIiiiIiII_Class373.I_method_ff9e3622(I_field_db650847.peek());
        I_field_5a = true;
    }

    public static void II_method_f0a29162() {
        if (!I_field_5a) {
            return;
        }
        GL11.glDisable((int)3089);
        I_field_5a = false;
    }

    private static Nested1_a871a0a0 I_method_37ff0ed0(Nested1_a871a0a0 nested1_a871a0a0, Nested1_a871a0a0 nested1_a871a0a02) {
        float f = Math.max(nested1_a871a0a0.I_method_1143c70a(), nested1_a871a0a02.I_method_1143c70a());
        float f2 = Math.max(nested1_a871a0a0.i_method_115252ea(), nested1_a871a0a02.i_method_115252ea());
        float f3 = Math.min(nested1_a871a0a0.II_method_17441377(), nested1_a871a0a02.II_method_17441377());
        float f4 = Math.min(nested1_a871a0a0.Ii_method_17529f57(), nested1_a871a0a02.Ii_method_17529f57());
        float f5 = Math.max(0.0f, f3 - f);
        float f6 = Math.max(0.0f, f4 - f2);
        return new Nested1_a871a0a0(f, f2, f5, f6);
    }

    public static boolean I_method_ff80a1e3() {
        return !I_field_db650847.isEmpty();
    }

    public static void Ii_method_f0b11d42() {
        if (iIiiiiIii_Class380.I_method_5f4b6223()) {
            iIiiiiIii_Class380.i_method_5f59edff();
        } else {
            iIiiiiIii_Class380.I_method_5f4b621f();
        }
        if (iIiiiiIii_Class380.II_method_752e8438() != null) {
            for (Boolean bl : i_field_db650847) {
                if (!bl.booleanValue()) continue;
                iIiiiiIii_Class380.II_method_752e8438().II_method_8a2fd922();
            }
        }
        I_field_db650847.clear();
        i_field_db650847.clear();
        I_field_5a = false;
        GL11.glDisable((int)3089);
    }

    public static int I_method_ff80a1d2() {
        return I_field_db650847.size();
    }

    @Deprecated
    public static void i_method_5570263f(float f, float f2, float f3, float f4) {
        iIiiiIiII_Class373.I_method_594a8a5f(f, f2, f3, f4);
    }

    @Deprecated
    public static void I_method_eaeef751(float f, float f2, float f3, float f4, MatrixStack matrixStack) {
        if (matrixStack != null) {
            iIiiiIiII_Class373.I_method_d5a5ee51(matrixStack, f, f2, f3, f4);
        } else {
            iIiiiIiII_Class373.I_method_594a8a5f(f, f2, f3, f4);
        }
    }

    @Deprecated
    public static void I_method_e18e336f(float f, float f2, float f3, float f4, Matrix4f matrix4f) {
        iIiiiIiII_Class373.I_method_51bc4c6f(matrix4f, f, f2, f3, f4);
    }

    @Deprecated
    public static void iI_method_f2658182() {
        iIiiiIiII_Class373.I_method_ff80a1df();
    }

    @Generated
    private iIiiiIiII_Class373() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static class Nested1_a871a0a0 {
        final float I_field_46;
        final float i_field_46;
        final float II_field_46;
        final float Ii_field_46;

        Nested1_a871a0a0(float f, float f2, float f3, float f4) {
            this.I_field_46 = f;
            this.i_field_46 = f2;
            this.II_field_46 = f3;
            this.Ii_field_46 = f4;
        }

        float I_method_1143c70a() {
            return this.I_field_46;
        }

        float i_method_115252ea() {
            return this.i_field_46;
        }

        float II_method_17441377() {
            return this.I_field_46 + this.II_field_46;
        }

        float Ii_method_17529f57() {
            return this.i_field_46 + this.Ii_field_46;
        }

        Nested1_a871a0a0 I_method_4d36cf65(Matrix4f matrix4f) {
            if (MatrixUtil.isIdentity((Matrix4f)matrix4f)) {
                return new Nested1_a871a0a0(this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46);
            }
            Vector3f vector3f = new Vector3f(this.I_field_46, this.i_field_46, 0.0f);
            Vector3f vector3f2 = new Vector3f(this.I_field_46 + this.II_field_46, this.i_field_46 + this.Ii_field_46, 0.0f);
            matrix4f.transformPosition(vector3f);
            matrix4f.transformPosition(vector3f2);
            return new Nested1_a871a0a0(vector3f.x, vector3f.y, vector3f2.x - vector3f.x, vector3f2.y - vector3f.y);
        }
    }
}

