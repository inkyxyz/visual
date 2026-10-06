package rockstar.client;

import moscow.rockstar.mixin.accessors.TextRendererInvoker;
import moscow.rockstar.mixin.accessors.TextRendererStyledInvoker;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.text.OrderedText;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import rockstar.client.IIIiIiIi_Class22;

public final class IIIiiIII_Class25 {
    private static boolean I_field_5a;

    private IIIiiIII_Class25() {
    }

    public static boolean I_method_476148d0() {
        return I_field_5a;
    }

    public static int I_method_694f9124(final TextRenderer textRenderer, final String string, final String string2, final float f, final float f2, final int n, final boolean bl, Matrix4f matrix4f, final TextRenderer.TextLayerType textLayerType, final int n2, final int n3, final boolean bl2) {
        final TextRendererInvoker textRendererInvoker = (TextRendererInvoker)textRenderer;
        final Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)matrix4f);
        IIIiIiIi_Class22.I_method_9e8f326c(new IIIiIiIi_Class22.Nested1_85037d53(){

            @Override
            public int[] I_method_5aed677d() {
                return IIIiIiIi_Class22.I_method_3eff6066(matrix4f2, f, f2, Math.max(textRenderer.getWidth(string), textRenderer.getWidth(string2)));
            }

            @Override
            public void I_method_2eee247() {
                IIIiiIII_Class25.i_method_a271b12a(() -> textRendererInvoker.rockstar$drawInternal(string, f, f2, n, bl, matrix4f2, (VertexConsumerProvider)IIIiIiIi_Class22.I_method_93e36b38(), textLayerType, n2, n3, bl2));
            }

            @Override
            public void i_method_2fd6e27() {
                IIIiiIII_Class25.i_method_a271b12a(() -> textRendererInvoker.rockstar$drawInternal(string2, f, f2, n, bl, matrix4f2, (VertexConsumerProvider)IIIiIiIi_Class22.I_method_93e36b38(), textLayerType, n2, n3, bl2));
            }
        });
        return (int)(f + (float)textRenderer.getWidth(string)) + (bl ? 1 : 0);
    }

    public static int I_method_cee191d6(final TextRenderer textRenderer, final OrderedText orderedText, final OrderedText orderedText2, final float f, final float f2, final int n, final boolean bl, Matrix4f matrix4f, final TextRenderer.TextLayerType textLayerType, final int n2, final int n3, final boolean bl2) {
        final TextRendererStyledInvoker textRendererStyledInvoker = (TextRendererStyledInvoker)textRenderer;
        final Matrix4f matrix4f2 = new Matrix4f((Matrix4fc)matrix4f);
        IIIiIiIi_Class22.I_method_9e8f326c(new IIIiIiIi_Class22.Nested1_85037d53(){

            @Override
            public int[] I_method_5aed677d() {
                return IIIiIiIi_Class22.I_method_3eff6066(matrix4f2, f, f2, Math.max(textRenderer.getWidth(orderedText), textRenderer.getWidth(orderedText2)));
            }

            @Override
            public void I_method_2eee247() {
                IIIiiIII_Class25.i_method_a271b12a(() -> textRendererStyledInvoker.rockstar$drawInternal(orderedText, f, f2, n, bl, matrix4f2, (VertexConsumerProvider)IIIiIiIi_Class22.I_method_93e36b38(), textLayerType, n2, n3, bl2));
            }

            @Override
            public void i_method_2fd6e27() {
                IIIiiIII_Class25.i_method_a271b12a(() -> textRendererStyledInvoker.rockstar$drawInternal(orderedText2, f, f2, n, bl, matrix4f2, (VertexConsumerProvider)IIIiIiIi_Class22.I_method_93e36b38(), textLayerType, n2, n3, bl2));
            }
        });
        return (int)(f + (float)textRenderer.getWidth(orderedText)) + (bl ? 1 : 0);
    }

    public static void I_method_259e47d8(TextRenderer textRenderer, OrderedText orderedText, float f, float f2, int n, int n2, Matrix4f matrix4f, VertexConsumerProvider vertexConsumerProvider, int n3) {
        IIIiiIII_Class25.I_method_223fd54a(() -> textRenderer.drawWithOutline(orderedText, f, f2, n, n2, matrix4f, vertexConsumerProvider, n3));
    }

    private static void I_method_223fd54a(Runnable runnable) {
        I_field_5a = true;
        try {
            runnable.run();
        }
        finally {
            I_field_5a = false;
        }
    }

    static void i_method_a271b12a(Runnable runnable) {
        IIIiiIII_Class25.I_method_223fd54a(() -> {
            runnable.run();
            IIIiIiIi_Class22.I_method_93e36b38().draw();
        });
    }
}

