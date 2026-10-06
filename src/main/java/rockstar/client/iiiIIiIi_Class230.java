package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import pyrock.events.game.InternalAttackEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import rockstar.client.BlinkModule;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiiIIiIi_Class358;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iiiIIiiI_Class231;

public class iiiIIiIi_Class230 {
    private int I_field_49;
    private iiiIIiiI_Class231 I_field_62e92fa1;
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> {
        if (iIIiIIiIi_Class294.I_field_3a9bda27.world == null || iIIiIIiIi_Class294.I_field_3a9bda27.player == null || this.I_field_62e92fa1 == null) {
            return;
        }
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.SRC_ALPHA, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE);
        RenderSystem.lineWidth((float)10.0f);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        render3DEvent.getMatrices().push();
        iIiiiIIiI_Class371.i_method_49a476f1(render3DEvent.getMatrices());
        BufferBuilder bufferBuilder = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        iIiiIIiIi_Class358.Ii_method_c1caf816(render3DEvent.getMatrices(), bufferBuilder, this.I_field_62e92fa1.I_method_f88afb80(), IiiiiIIIi_Class242.i_method_5dfec6e());
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        render3DEvent.getMatrices().pop();
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41 = clientPlayerTickEvent -> {
        LivingEntity livingEntity;
        LivingEntity livingEntity2;
        Entity entity = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815();
        LivingEntity livingEntity3 = livingEntity2 = entity instanceof LivingEntity ? (livingEntity = (LivingEntity)entity) : null;
        if (livingEntity2 != null && iIIiIIiIi_Class294.I_field_3a9bda27.player.fallDistance > 0.2f && iIIiIIiIi_Class294.I_field_3a9bda27.player.distanceTo((Entity)livingEntity2) < 3.2f && this.I_field_62e92fa1 == null) {
            this.I_field_62e92fa1 = new iiiIIiiI_Class231(iIIiIIiIi_Class294.I_field_3a9bda27.player.getPos(), iIIiIIiIi_Class294.I_field_3a9bda27.player.getVelocity(), RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5(), iIIiIIiIi_Class294.I_field_3a9bda27.player.isOnGround(), iIIiIIiIi_Class294.I_field_3a9bda27.player.getBoundingBox());
        }
        if (this.I_field_62e92fa1 != null && this.I_field_62e92fa1.I_method_23447f66().distanceTo(livingEntity2.getPos()) > 6.0 && iIIiIIiIi_Class294.I_field_3a9bda27.player.isOnGround()) {
            this.I_field_62e92fa1 = null;
            iIIiIIiIi_Class294.I_field_3a9bda27.player.setVelocity(this.I_field_62e92fa1.i_method_c73d0346());
            iIIiIIiIi_Class294.I_field_3a9bda27.player.setPosition(this.I_field_62e92fa1.I_method_23447f66());
            iIIiIIiIi_Class294.I_field_3a9bda27.player.setOnGround(this.I_field_62e92fa1.I_method_31be1cf0());
            this.I_field_49 = 0;
        }
        if (iIIiIIiIi_Class294.I_field_3a9bda27.player.isOnGround()) {
            // empty if block
        }
    };
    private final IiIIIiII_Class69<InternalAttackEvent> II_field_3d936f41 = internalAttackEvent -> {
        if (internalAttackEvent.isCancelled()) {
            return;
        }
        ++this.I_field_49;
    };
    private final IiIIIiII_Class69<SendPacketEvent> Ii_field_3d936f41 = sendPacketEvent -> {
        Packet<?> packet = sendPacketEvent.getPacket();
        if (this.I_field_62e92fa1 != null && (packet instanceof PlayerMoveC2SPacket || packet instanceof PlayerMoveC2SPacket.Full || packet instanceof PlayerMoveC2SPacket.PositionAndOnGround || packet instanceof PlayerMoveC2SPacket.LookAndOnGround || packet instanceof PlayerMoveC2SPacket.OnGroundOnly)) {
            sendPacketEvent.cancel();
        }
    };

    public void I_method_cb91c8ac() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    public void i_method_cba0548c() {
        if (this.I_field_62e92fa1 != null) {
            iIIiIIiIi_Class294.I_field_3a9bda27.player.setVelocity(this.I_field_62e92fa1.i_method_c73d0346());
            iIIiIIiIi_Class294.I_field_3a9bda27.player.setPosition(this.I_field_62e92fa1.I_method_23447f66());
            iIIiIIiIi_Class294.I_field_3a9bda27.player.setOnGround(this.I_field_62e92fa1.I_method_31be1cf0());
        }
        RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this);
        this.I_field_62e92fa1 = null;
        this.I_field_49 = 0;
    }

    private BlinkModule I_method_a5f4f3a2() {
        return RockstarClient.getInstance().getModuleManager().getModule(BlinkModule.class);
    }

    @Generated
    public int I_method_cb91c89f() {
        return this.I_field_49;
    }

    @Generated
    public iiiIIiiI_Class231 I_method_746a540b() {
        return this.I_field_62e92fa1;
    }
}

