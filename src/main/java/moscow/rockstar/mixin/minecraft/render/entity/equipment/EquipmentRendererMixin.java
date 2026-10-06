package moscow.rockstar.mixin.minecraft.render.entity.equipment;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.GlowRenderLayers;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.equipment.EquipmentRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.FreeCameraModule;
import rockstar.client.BeautifullyModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiiiI_Class127;
import rockstar.client.iIIIIIiI_Class131;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.HitColorModule;
import rockstar.client.Module;

@Mixin(value={EquipmentRenderer.class})
public abstract class EquipmentRendererMixin {
    @WrapOperation(method={"render(Lnet/minecraft/client/render/entity/equipment/EquipmentModel$LayerType;Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/client/model/Model;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/util/Identifier;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/RenderLayer;getArmorCutoutNoCull(Lnet/minecraft/util/Identifier;)Lnet/minecraft/client/render/RenderLayer;")})
    private RenderLayer rockstar$glowArmorLayer(Identifier identifier, Operation<RenderLayer> operation) {
        BeautifullyModule iIiIIIiii_Class72 = RockstarClient.getInstance().getModuleManager().getModule(BeautifullyModule.class);
        if (iIiIIIiii_Class72.isEnabled() && iIiIIIiii_Class72.I_method_b3cc4850().isSelected() && !iIiIIIiii_Class72.i_method_4b28ab15().I_method_6ac4da83() && RockstarClient.I_field_77e0818c == MinecraftClient.getInstance().player) {
            return RenderLayer.getItemEntityTranslucentCull((Identifier)identifier);
        }
        FreeCameraModule iIIiIIiii_Class40 = RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class);
        if (iIIiIIiii_Class40.Iii_method_4619eea3() && RockstarClient.I_field_77e0818c == MinecraftClient.getInstance().player) {
            return RenderLayer.getItemEntityTranslucentCull((Identifier)identifier);
        }
        if (!iIIIIIiI_Class131.I_field_5a) {
            return (RenderLayer)operation.call(new Object[]{identifier});
        }
        Entity entity = iIIIIIiI_Class131.I_field_77e0818c;
        if (entity == null) {
            return (RenderLayer)operation.call(new Object[]{identifier});
        }
        iIIIIIiI_Class131 iIIIIIiI_Class1312 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
        if (iIIIIIiI_Class1312 == null || !iIIIIIiI_Class1312.I_method_d2b4487e(entity)) {
            return (RenderLayer)operation.call(new Object[]{identifier});
        }
        if (iIIIIIiI_Class1312.I_method_6ef746e9(entity) == null) {
            return (RenderLayer)operation.call(new Object[]{identifier});
        }
        return GlowRenderLayers.get(identifier);
    }

    @WrapOperation(method={"render(Lnet/minecraft/client/render/entity/equipment/EquipmentModel$LayerType;Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/client/model/Model;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/util/Identifier;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/model/Model;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;III)V")})
    private void rockstar$glowArmorColor(Model model, MatrixStack matrixStack, VertexConsumer vertexConsumer, int n, int n2, int n3, Operation<Void> operation) {
        ColorRGBA colorRGBA;
        iIIiIIiIi_Class294 iIIiIIiRockstarClient942;
        Object object;
        if (iIIIIIiI_Class131.I_field_5a && (object = iIIIIIiI_Class131.I_field_77e0818c) != null && (iIIiIIiRockstarClient942 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class)) != null && ((iIIIIIiI_Class131)iIIiIIiRockstarClient942).I_method_d2b4487e((Entity)object) && (colorRGBA = ((iIIIIIiI_Class131)iIIiIIiRockstarClient942).I_method_6ef746e9((Entity)object)) != null) {
            n3 = colorRGBA.getRGB();
        }
        if (((Module)(object = RockstarClient.getInstance().getModuleManager().getModule(BeautifullyModule.class))).isEnabled() && ((BeautifullyModule)object).I_method_b3cc4850().isSelected() && !((BeautifullyModule)object).i_method_4b28ab15().I_method_6ac4da83() && RockstarClient.I_field_77e0818c == MinecraftClient.getInstance().player) {
            n3 = ColorRGBA.applyOpacity(n3, ((BeautifullyModule)object).i_method_4b28ab15().I_method_6ac4da6f()).getRGB();
        }
        if (((FreeCameraModule)(iIIiIIiRockstarClient942 = RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class))).Iii_method_4619eea3() && RockstarClient.I_field_77e0818c == MinecraftClient.getInstance().player) {
            n3 = ColorRGBA.applyOpacity(n3, ((FreeCameraModule)iIIiIIiRockstarClient942).I_method_17c71a2f()).getRGB();
        }
        HitColorModule hitColorMod = RockstarClient.getInstance().getModuleManager().getModule(HitColorModule.class);
        if (hitColorMod != null && hitColorMod.shouldTintArmor(RockstarClient.I_field_77e0818c)) {
            n3 = hitColorMod.getTintColor(RockstarClient.I_field_77e0818c);
        }
        operation.call(new Object[]{model, matrixStack, vertexConsumer, n, n2, n3});
    }
}

