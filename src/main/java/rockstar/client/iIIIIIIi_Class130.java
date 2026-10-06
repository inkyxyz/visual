package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiiI_Class119;
import rockstar.client.IiiiiIII_Class121;
import rockstar.client.IiiiiIiI_Class123;
import rockstar.client.iIiiIIIii_Class356;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iIiiiiIII_Class377;

public class iIIIIIIi_Class130
extends IiiiIiiI_Class119 {
    private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(52.0f, 199.0f, 89.0f);
    private static boolean I_field_5a = false;
    private static boolean i_field_5a = false;
    private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.friend_markers");
    private final ModeSetting I_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "esp.friend_markers.type", () -> !this.i_method_d0cacf11(IiiiiIII_Class121.II_field_12aa4f81));
    private final ModeSetting.Nested1_42765c60 I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "esp.friend_markers.heads");
    private final ModeSetting.Nested1_42765c60 i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "esp.friend_markers.sims").select();
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> {
        if (!this.i_method_d0cacf11(IiiiiIII_Class121.II_field_12aa4f81)) {
            return;
        }
        if (!this.i_field_500d0627.isSelected()) {
            return;
        }
        iIiiiIIiI_Class371.I_method_642c0895(true);
        MatrixStack matrixStack = render3DEvent.getMatrices();
        BufferBuilder bufferBuilder = iIiiIIIii_Class356.I_method_c596047e();
        for (AbstractClientPlayerEntity abstractClientPlayerEntity : iIIIIIIi_Class130.I_field_3a9bda27.world.getPlayers()) {
            if (!RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(abstractClientPlayerEntity.getName().getString()) || abstractClientPlayerEntity == iIIIIIIi_Class130.I_field_3a9bda27.player) continue;
            matrixStack.push();
            iIiiiIIiI_Class371.I_method_7d461059(matrixStack, iIiiiiIII_Class377.I_method_689b1a13((Entity)abstractClientPlayerEntity, render3DEvent.getTickDelta()));
            float f = 0.1f;
            iIiiIIIii_Class356.I_method_8d941781(matrixStack, bufferBuilder, 0.0f, abstractClientPlayerEntity.getHeight() + 0.4f, 0.0f, f, I_field_d0c8ec5.withAlpha(255.0f));
            matrixStack.pop();
        }
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        iIiiiIIiI_Class371.I_method_a0226e1f();
    };

    public iIIIIIIi_Class130() {
        super("friend_markers", IiiiiIiI_Class123.I_field_12aac7a1);
        this.I_method_52f623aa(IiiiiIII_Class121.II_field_12aa4f81);
    }

    @Override
    public boolean I_method_bb355b31(IiiiiIII_Class121 iiiiiIII_Class121) {
        return iiiiiIII_Class121 == IiiiiIII_Class121.II_field_12aa4f81;
    }

    @Override
    public void I_method_d9976c2e(III iII, Entity entity, float f, float f2, IiiiiIiI_Class123 iiiiiIiI_Class123, IiiiiIII_Class121 iiiiiIII_Class121) {
        if (iiiiiIII_Class121 != IiiiiIII_Class121.II_field_12aa4f81) {
            return;
        }
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        LivingEntity livingEntity = (LivingEntity)entity;
        if (!this.i_field_500d0627.isSelected()) {
            return;
        }
        MatrixStack matrixStack = iII.getMatrices();
        matrixStack.push();
        matrixStack.translate(f, f2 - livingEntity.getHeight() * 15.0f, 50.0f);
        matrixStack.scale(48.0f, 48.0f, -100.0f);
        RenderSystem.disableDepthTest();
        RenderSystem.enableBlend();
        BufferBuilder bufferBuilder = iIiiIIIii_Class356.I_method_c596047e();
        iIiiIIIii_Class356.I_method_8d941781(matrixStack, bufferBuilder, 0.0f, 0.0f, 0.0f, 0.1f, I_field_d0c8ec5.withAlpha(255.0f));
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        RenderSystem.enableDepthTest();
        matrixStack.pop();
    }

    public boolean i_method_3cafb4b0() {
        return this.i_method_d0cacf11(IiiiiIII_Class121.II_field_12aa4f81) && this.I_field_500d0627.isSelected();
    }

    @Generated
    public BooleanSetting I_method_957dab42() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public ModeSetting I_method_97401f62() {
        return this.I_field_bbe33e6c;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 I_method_c7b5819d() {
        return this.I_field_500d0627;
    }

    @Generated
    public ModeSetting.Nested1_42765c60 i_method_cdbd7d7d() {
        return this.i_field_500d0627;
    }

    @Generated
    public IiIIIiII_Class69<Render3DEvent> I_method_973b978b() {
        return this.I_field_3d936f41;
    }

    @Generated
    public static boolean II_method_5792e819() {
        return I_field_5a;
    }

    @Generated
    public static void I_method_5784a388(boolean bl) {
        I_field_5a = bl;
    }

    @Generated
    public static boolean Ii_method_57a173f9() {
        return i_field_5a;
    }

    @Generated
    public static void i_method_594793a8(boolean bl) {
        i_field_5a = bl;
    }
}

