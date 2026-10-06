package rockstar.client;

import lombok.Generated;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import rockstar.client.BooleanSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiiI_Class119;
import rockstar.client.IiiiiIII_Class121;
import rockstar.client.IiiiiIiI_Class123;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iiIIIiiii_Class400;
import rockstar.client.iiIIiIIII_Class401;

public class iIIIIiiI_Class135
extends IiiiIiiI_Class119 {
    private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.taksa");
    private iiIIiIIII_Class401 I_field_32e0c26c;
    private final iiIIIiiii_Class400 I_field_fe17a68c = new iiIIIiiii_Class400();
    private float I_field_46 = 0.0f;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (!this.i_method_d0cacf11(IiiiiIII_Class121.i_field_12aa4f81)) {
            return;
        }
        if (iIIIIiiI_Class135.I_field_3a9bda27.player == null) {
            return;
        }
        this.I_field_fe17a68c.I_method_177929d4((PlayerEntity)iIIIIiiI_Class135.I_field_3a9bda27.player);
        this.I_field_fe17a68c.I_method_fd8a63f();
    };
    private final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41 = render3DEvent -> {
        if (!this.i_method_d0cacf11(IiiiiIII_Class121.i_field_12aa4f81)) {
            return;
        }
        if (iIIIIiiI_Class135.I_field_3a9bda27.player == null || iIIIIiiI_Class135.I_field_3a9bda27.world == null) {
            return;
        }
        if (this.I_field_32e0c26c == null) {
            this.I_field_32e0c26c = new iiIIiIIII_Class401(iiIIiIIII_Class401.I_method_5dbc5bf2().createModel());
        }
        this.I_field_46 += 0.05f;
        MatrixStack matrixStack = render3DEvent.getMatrices();
        VertexConsumerProvider.Immediate immediate = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
        VertexConsumer vertexConsumer = immediate.getBuffer(RenderLayer.getEntityTranslucent((Identifier)RockstarClient.id("textures/entity/taksa.png")));
        matrixStack.push();
        iIiiiIIiI_Class371.I_method_7d461059(matrixStack, this.I_field_fe17a68c.I_method_32823579());
        int n = Math.max(iIIIIiiI_Class135.I_field_3a9bda27.world.getLightLevel(iIIIIiiI_Class135.I_field_3a9bda27.player.getBlockPos()) - 5, 15);
        int n2 = n << 20 | n << 4;
        this.I_field_32e0c26c.I_method_3542feb7(matrixStack, vertexConsumer, n2, OverlayTexture.DEFAULT_UV, this.I_field_fe17a68c, this.I_field_46);
        matrixStack.pop();
        immediate.draw();
    };

    public iIIIIiiI_Class135() {
        super("taksa", IiiiiIiI_Class123.I_field_12aac7a1);
    }

    @Override
    public boolean I_method_bb355b31(IiiiiIII_Class121 iiiiiIII_Class121) {
        return iiiiiIII_Class121 == IiiiiIII_Class121.i_field_12aa4f81;
    }

    @Generated
    public BooleanSetting I_method_ee65b362() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public iiIIiIIII_Class401 I_method_6725ab82() {
        return this.I_field_32e0c26c;
    }

    @Generated
    public iiIIIiiii_Class400 I_method_325c8fa2() {
        return this.I_field_fe17a68c;
    }

    @Generated
    public float I_method_9ef318dc() {
        return this.I_field_46;
    }

    @Generated
    public IiIIIiII_Class69<ClientPlayerTickEvent> I_method_bb220b6b() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<Render3DEvent> i_method_e51e9b8b() {
        return this.i_field_3d936f41;
    }
}

