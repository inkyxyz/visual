package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.Vector2Setting;
import rockstar.client.GradientColorSetting;
import rockstar.client.TimeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiIiIiIi_Class214;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.IiiiiiIiI_Class251;
import rockstar.client.Module;
import rockstar.client.SpeedModule;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Test", category=ModuleCategory.OTHER, staffOnly=true)
public class TestModule
extends Module {
    private GradientColorSetting I_field_bbd52aac;
    private Vector2Setting I_field_ba204e4c;
    private TimeSetting I_field_731806ac;
    private TimeSetting i_field_731806ac;
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> {
        MatrixStack matrixStack = render3DEvent.getMatrices();
        Camera camera = TestModule.I_field_3a9bda27.gameRenderer.getCamera();
        Vec3d vec3d = camera.getPos();
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.blendFunc((GlStateManager.SrcFactor)GlStateManager.SrcFactor.SRC_ALPHA, (GlStateManager.DstFactor)GlStateManager.DstFactor.ONE);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        BufferBuilder bufferBuilder = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        SpeedModule iiiiIiII_Class2452 = RockstarClient.getInstance().getModuleManager().getModule(SpeedModule.class);
        for (AbstractClientPlayerEntity abstractClientPlayerEntity : TestModule.I_field_3a9bda27.world.getPlayers()) {
            if (TestModule.I_field_3a9bda27.player == abstractClientPlayerEntity) continue;
            IiiiiiIiI_Class251.I_method_23c9a2f9(matrixStack, bufferBuilder, abstractClientPlayerEntity.getBoundingBox().offset(abstractClientPlayerEntity.getPos().add(abstractClientPlayerEntity.getPos().subtract(new Vec3d(abstractClientPlayerEntity.prevX, abstractClientPlayerEntity.prevY, abstractClientPlayerEntity.prevZ)).multiply((double)iiiiIiII_Class2452.I_method_139a0762().Ii_method_a20abcd2()))).offset(-abstractClientPlayerEntity.getX(), -abstractClientPlayerEntity.getY(), -abstractClientPlayerEntity.getZ()).offset(-vec3d.getX(), -vec3d.getY(), -vec3d.getZ()), IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(100.0f));
        }
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    };
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(1000L, IiiiIiiII_Class237.IIIi_field_dd60aac);
    private final IiIIIiII_Class69<HudRenderEvent> i_field_3d936f41 = hudRenderEvent -> {
        CustomDrawContext customDrawContext = hudRenderEvent.getContext();
        this.I_field_dc7facc.i_method_6ad3665f();
        float f = 10.0f + this.I_field_dc7facc.I_method_6ac4da6f() * 340.0f;
        customDrawContext.drawIcon("cube", 100.0f, 100.0f, f, ColorRGBA.WHITE);
    };

    public TestModule() {
        this.IiI_method_fa93f6bf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_fa93f6bf() {
        this.I_field_bbd52aac = new GradientColorSetting(this, "\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0439 \u0433\u0440\u0430\u0434\u0438\u0435\u043d\u0442").I_method_1119eb95(IiiiiIIIi_Class242.ii_field_d0c8ec5, IiiiiIIIi_Class242.ii_field_d0c8ec5);
        this.I_field_ba204e4c = new Vector2Setting(this, "\u041a\u0443\u0440\u0432\u0430 \u0435\u0431\u0430\u043d\u0430\u044f");
        this.I_field_731806ac = new TimeSetting(this, "\u0412\u0440\u0435\u043c\u044f").II_method_7fd80f7(7680);
        this.i_field_731806ac = new TimeSetting(this, "\u0412\u0440\u0435\u043c\u044f \u0431\u0435\u0437 \u0447\u0430\u0441\u043e\u0432").I_method_a7007deb(false).II_method_7fd80f7(90);
    }

    @Override
    public void onEnable() {
        if (TestModule.I_field_3a9bda27.currentScreen == null && TestModule.I_field_3a9bda27.world == null) {
            return;
        }
        I_field_3a9bda27.setScreen((Screen)new IiiIiIiIi_Class214());
    }

    @Override
    public void onDisable() {
        if (TestModule.I_field_3a9bda27.currentScreen instanceof IiiIiIiIi_Class214) {
            I_field_3a9bda27.setScreen(null);
        }
    }
}

