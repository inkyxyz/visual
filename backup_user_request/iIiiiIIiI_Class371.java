package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Predicate;
import lombok.Generated;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIiIIIii_Class164;
import rockstar.client.IiIiIiIIi_Class170;
import rockstar.client.RockstarClient;
import rockstar.client.IiiII_Class13;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;

public final class iIiiiIIiI_Class371
implements iIIiIIiIi_Class294,
iIIiIIiii_Class296 {
    private static final int I_field_49 = 20;
    private static final int i_field_49 = 3;

    public static void I_method_4f407679(CustomDrawContext customDrawContext, int n, ColorRGBA colorRGBA) {
        float f;
        float f2;
        if (n < 0 || n > 8 || iIiiiIIiI_Class371.I_field_3a9bda27.player == null) {
            return;
        }
        RenderSystem.enableBlend();
        int n2 = I_field_3a9bda27.getWindow().getScaledWidth();
        int n3 = I_field_3a9bda27.getWindow().getScaledHeight();
        float f3 = IiIiIiIIi_Class170.I_method_d7c8c66f();
        if (iIiiiIIiI_Class371.I_method_a0226e23()) {
            float f4 = (float)n2 / 2.0f - 101.0f;
            float f5 = (float)n3 - 30.0f - f3;
            f2 = f4 + 6.0f + (float)n * 21.5f;
            f = f5 + 5.5f;
        } else {
            int n4 = n2 / 2 - 91;
            float f6 = (float)(n3 - 22) - f3;
            f2 = n4 + n * 20 + 3;
            f = f6 + 3.0f;
        }
        customDrawContext.drawRoundedRect(f2, f, 18.0f, 18.0f, IIiii_Class8.I_method_893b2757(4.0f), new IiiII_Class13(colorRGBA.mulAlpha(0.0f), colorRGBA));
    }

    private static boolean I_method_a0226e23() {
        IiIiIIIii_Class164 iiIiIIIii_Class164 = RockstarClient.getInstance().I_method_35687482();
        if (iiIiIIIii_Class164 == null) {
            return false;
        }
        IiIiIiIIi_Class170 iiIiIiIIi_Class170 = iiIiIIIii_Class164.I_method_3a63b5();
        return iiIiIiIIi_Class170 != null && iiIiIiIIi_Class170.isShowing() && iiIiIiIIi_Class170.show();
    }

    public static boolean I_method_9d0fd75a(CustomDrawContext customDrawContext, Item item, ColorRGBA colorRGBA) {
        if (iIiiiIIiI_Class371.I_field_3a9bda27.player == null) {
            return false;
        }
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = iIiiiIIiI_Class371.I_field_3a9bda27.player.getInventory().getStack(i);
            if (itemStack.getItem() != item) continue;
            iIiiiIIiI_Class371.I_method_4f407679(customDrawContext, i, colorRGBA);
            return true;
        }
        return false;
    }

    public static boolean I_method_54c364d7(CustomDrawContext customDrawContext, Predicate<ItemStack> predicate, ColorRGBA colorRGBA) {
        if (iIiiiIIiI_Class371.I_field_3a9bda27.player == null) {
            return false;
        }
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = iIiiiIIiI_Class371.I_field_3a9bda27.player.getInventory().getStack(i);
            if (itemStack.isEmpty() || !predicate.test(itemStack)) continue;
            iIiiiIIiI_Class371.I_method_4f407679(customDrawContext, i, colorRGBA);
            return true;
        }
        return false;
    }

    public static int I_method_9d0fd749(CustomDrawContext customDrawContext, Item item, ColorRGBA colorRGBA) {
        if (iIiiiIIiI_Class371.I_field_3a9bda27.player == null) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = iIiiiIIiI_Class371.I_field_3a9bda27.player.getInventory().getStack(i);
            if (itemStack.getItem() != item) continue;
            iIiiiIIiI_Class371.I_method_4f407679(customDrawContext, i, colorRGBA);
            ++n;
        }
        return n;
    }

    public static int I_method_54c364c6(CustomDrawContext customDrawContext, Predicate<ItemStack> predicate, ColorRGBA colorRGBA) {
        if (iIiiiIIiI_Class371.I_field_3a9bda27.player == null) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = iIiiiIIiI_Class371.I_field_3a9bda27.player.getInventory().getStack(i);
            if (itemStack.isEmpty() || !predicate.test(itemStack)) continue;
            iIiiiIIiI_Class371.I_method_4f407679(customDrawContext, i, colorRGBA);
            ++n;
        }
        return n;
    }

    public static void I_method_6a1c0f0f(MatrixStack matrixStack, float f, float f2, float f3) {
        matrixStack.push();
        matrixStack.translate(f, f2, 0.0f);
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f3));
        matrixStack.translate(-f, -f2, 0.0f);
    }

    public static void i_method_db7fc72f(MatrixStack matrixStack, float f, float f2, float f3) {
        matrixStack.push();
        matrixStack.translate(f, f2, 150.0f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f3));
        matrixStack.translate(-f, -f2, -150.0f);
    }

    public static void II_method_e18635ac(MatrixStack matrixStack, float f, float f2, float f3) {
        matrixStack.push();
        matrixStack.translate(f, f2, 0.0f);
        matrixStack.scale(f3, f3, 1.0f);
        matrixStack.translate(-f, -f2, 0.0f);
    }

    public static void I_method_10503b11(MatrixStack matrixStack) {
        matrixStack.pop();
    }

    public static void i_method_49a476f1(MatrixStack matrixStack) {
        Camera camera = iIiiiIIiI_Class371.I_field_3a9bda27.gameRenderer.getCamera();
        Vec3d vec3d = camera.getPos();
        Vec3d vec3d2 = Vec3d.ZERO.subtract(vec3d);
        matrixStack.translate(vec3d2.getX(), vec3d2.getY(), vec3d2.getZ());
    }

    public static void I_method_7d461059(MatrixStack matrixStack, Vec3d vec3d) {
        Camera camera = iIiiiIIiI_Class371.I_field_3a9bda27.gameRenderer.getCamera();
        Vec3d vec3d2 = camera.getPos();
        Vec3d vec3d3 = vec3d.subtract(vec3d2);
        matrixStack.translate(vec3d3.getX(), vec3d3.getY(), vec3d3.getZ());
    }

    public static void I_method_642c0895(boolean bl) {
        RenderSystem.enableBlend();
        RenderSystem.disableCull();
        RenderSystem.disableDepthTest();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask((boolean)false);
        if (bl) {
            RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.SRC_ALPHA, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE);
        } else {
            RenderSystem.defaultBlendFunc();
        }
    }

    public static void I_method_a0226e1f() {
        RenderSystem.depthMask((boolean)true);
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.enableCull();
    }

    public static void I_method_c59155f0(BufferBuilder bufferBuilder) {
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
    }

    @Generated
    private iIiiiIIiI_Class371() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

