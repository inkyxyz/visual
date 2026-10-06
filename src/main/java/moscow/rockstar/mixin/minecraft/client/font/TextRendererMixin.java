package moscow.rockstar.mixin.minecraft.client.font;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.text.OrderedText;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.NameProtectModule;
import rockstar.client.IIIiIiIi_Class22;
import rockstar.client.IIIiIiii_Class24;
import rockstar.client.IIIiiIII_Class25;
import rockstar.client.RockstarClient;

@Mixin(value={TextRenderer.class})
public abstract class TextRendererMixin {
    @Inject(method={"drawInternal(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;IIZ)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$splitPlainText(String string, float f, float f2, int n, boolean bl, Matrix4f matrix4f, VertexConsumerProvider vertexConsumerProvider, TextRenderer.TextLayerType textLayerType, int n2, int n3, boolean bl2, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (IIIiiIII_Class25.I_method_476148d0() || !IIIiIiIi_Class22.II_method_40fdec79()) {
            return;
        }
        NameProtectModule iIIIiIiII_Class21 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
        if (iIIIiIiII_Class21 == null || !iIIIiIiII_Class21.I_method_46b601a7(string)) {
            return;
        }
        String string2 = iIIIiIiII_Class21.i_method_a8235dd7(string);
        if (string2.equals(string)) {
            return;
        }
        callbackInfoReturnable.setReturnValue(IIIiiIII_Class25.I_method_694f9124((TextRenderer)(Object)this, string, string2, f, f2, n, bl, matrix4f, textLayerType, n2, n3, bl2));
    }

    @Inject(method={"drawInternal(Lnet/minecraft/text/OrderedText;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;IIZ)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$splitStyledText(OrderedText orderedText, float f, float f2, int n, boolean bl, Matrix4f matrix4f, VertexConsumerProvider vertexConsumerProvider, TextRenderer.TextLayerType textLayerType, int n2, int n3, boolean bl2, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (IIIiiIII_Class25.I_method_476148d0() || !IIIiIiIi_Class22.II_method_40fdec79()) {
            return;
        }
        NameProtectModule iIIIiIiII_Class21 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
        if (iIIIiIiII_Class21 == null || !iIIIiIiII_Class21.I_method_46b601a7(IIIiIiii_Class24.I_method_9dcc0c2b(orderedText))) {
            return;
        }
        OrderedText orderedText2 = IIIiIiii_Class24.I_method_a505dd22(orderedText, iIIIiIiII_Class21);
        if (orderedText2 == null) {
            return;
        }
        callbackInfoReturnable.setReturnValue(IIIiiIII_Class25.I_method_cee191d6((TextRenderer)(Object)this, orderedText, orderedText2, f, f2, n, bl, matrix4f, textLayerType, n2, n3, bl2));
    }

    @Inject(method={"drawWithOutline"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$maskOutlinedText(OrderedText orderedText, float f, float f2, int n, int n2, Matrix4f matrix4f, VertexConsumerProvider vertexConsumerProvider, int n3, CallbackInfo callbackInfo) {
        if (IIIiiIII_Class25.I_method_476148d0() || !IIIiIiIi_Class22.II_method_40fdec79()) {
            return;
        }
        NameProtectModule iIIIiIiII_Class21 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
        if (iIIIiIiII_Class21 == null || !iIIIiIiII_Class21.I_method_46b601a7(IIIiIiii_Class24.I_method_9dcc0c2b(orderedText))) {
            return;
        }
        OrderedText orderedText2 = IIIiIiii_Class24.I_method_a505dd22(orderedText, iIIIiIiII_Class21);
        if (orderedText2 == null) {
            return;
        }
        IIIiiIII_Class25.I_method_259e47d8((TextRenderer)(Object)this, orderedText2, f, f2, n, n2, matrix4f, vertexConsumerProvider, n3);
        callbackInfo.cancel();
    }
}

