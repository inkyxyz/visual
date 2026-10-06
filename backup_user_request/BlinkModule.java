package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.AfterAttackEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIiiIIiIi_Class358;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.AutoTotemModule;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Blink", category=ModuleCategory.PLAYER)
public class BlinkModule
extends Module {
    private final List<Packet<?>> I_field_7865b31 = new ArrayList();
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private BooleanSetting I_field_ba20ca4c;
    private SliderSetting I_field_73178e8c;
    private BooleanSetting i_field_ba20ca4c;
    private BooleanSetting II_field_ba20ca4c;
    private Vec3d I_field_5bba0d50;
    private boolean I_field_5a;
    private final IiIIIiII_Class69<SendPacketEvent> I_field_3d936f41 = this::onEvent;
    private final IiIIIiII_Class69<AfterAttackEvent> i_field_3d936f41 = afterAttackEvent -> {
        this.onDisable();
        this.onEnable();
        this.I_field_991c1e8c.I_method_23e11e3f();
    };
    private final IiIIIiII_Class69<Render3DEvent> II_field_3d936f41 = render3DEvent -> {
        if (this.i_field_ba20ca4c.i_method_9b12da03() && this.I_field_5bba0d50 != null && (BlinkModule.I_field_3a9bda27.options.getPerspective() != Perspective.FIRST_PERSON || !this.II_field_ba20ca4c.i_method_9b12da03())) {
            MatrixStack matrixStack = render3DEvent.getMatrices();
            BufferBuilder bufferBuilder = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
            Vec3d vec3d = BlinkModule.I_field_3a9bda27.gameRenderer.getCamera().getPos();
            matrixStack.push();
            RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
            RenderSystem.disableCull();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            iIiiIIiIi_Class358.Ii_method_c1caf816(matrixStack, bufferBuilder, BlinkModule.I_field_3a9bda27.player.getBoundingBox().offset(this.I_field_5bba0d50.subtract(BlinkModule.I_field_3a9bda27.player.getPos())).offset(-vec3d.x, -vec3d.y, -vec3d.z), ColorRGBA.WHITE.withAlpha(180.0f));
            BuiltBuffer builtBuffer = bufferBuilder.endNullable();
            if (builtBuffer != null) {
                BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
            }
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            matrixStack.pop();
        }
    };
    private final IiIIIiII_Class69<WorldChangeEvent> Ii_field_3d936f41 = worldChangeEvent -> this.disable();

    public BlinkModule() {
        this.IiI_method_c0b7a2ff();
    }

    @Compile(obfuscation=4)
    private void IiI_method_c0b7a2ff() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.blink.pulse");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.blink.time", () -> !this.I_field_ba20ca4c.i_method_9b12da03()).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(40.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(12.0f);
        this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.blink.display");
        this.II_field_ba20ca4c = new BooleanSetting((IIiiiIIiI_Class115)this, "modules.settings.blink.hide_first_person", () -> !this.i_field_ba20ca4c.i_method_9b12da03());
    }

    public void onEvent(SendPacketEvent sendPacketEvent) {
        if (this.I_field_5a || !IiiiiiiII_Class253.i_method_1cc4aa23() || RockstarClient.getInstance().getModuleManager().getModule(AutoTotemModule.class).Iii_method_6f0929f0()) {
            return;
        }
        this.I_field_7865b31.add(sendPacketEvent.getPacket());
        sendPacketEvent.cancel();
        if (this.I_field_ba20ca4c.i_method_9b12da03() && this.I_field_991c1e8c.I_method_58432069((long)(this.I_field_73178e8c.Ii_method_a20abcd2() * 50.0f))) {
            this.onDisable();
            this.onEnable();
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
    }

    @Override
    public void onEnable() {
        if (BlinkModule.I_field_3a9bda27.player == null) {
            return;
        }
        this.I_field_7865b31.clear();
        this.I_field_5bba0d50 = BlinkModule.I_field_3a9bda27.player.getPos();
        this.I_field_991c1e8c.I_method_23e11e3f();
        this.I_field_5a = false;
    }

    @Override
    public void onDisable() {
        if (BlinkModule.I_field_3a9bda27.player == null) {
            return;
        }
        this.I_field_5a = true;
        for (Packet<?> packet : this.I_field_7865b31) {
            BlinkModule.I_field_3a9bda27.player.networkHandler.sendPacket(packet);
        }
        this.I_field_5a = false;
        this.I_field_7865b31.clear();
        this.I_field_5bba0d50 = null;
    }

    @Generated
    public iiIiIIiii_Class424 I_method_618db775() {
        return this.I_field_991c1e8c;
    }

    @Generated
    public BooleanSetting I_method_82926335() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public SliderSetting I_method_3b892775() {
        return this.I_field_73178e8c;
    }
}
