package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIiii_Class280;
import rockstar.client.iIiiIIiIi_Class358;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iIiiiiIII_Class377;
import rockstar.client.Module;

@ModuleInfo(name="PositionPredict", category=ModuleCategory.VISUALS)
public class PositionPredictModule
extends Module {
    private SliderSetting I_field_73178e8c;
    private SliderSetting i_field_73178e8c;
    private SliderSetting II_field_73178e8c;
    private SliderSetting Ii_field_73178e8c;
    private BooleanSetting I_field_ba20ca4c;
    private BooleanSetting i_field_ba20ca4c;
    private BooleanSetting II_field_ba20ca4c;
    private BooleanSetting Ii_field_ba20ca4c;
    private BooleanSetting iI_field_ba20ca4c;
    private final iIIIiIiii_Class280.Nested1_55d7eba9 I_field_98687ce6 = new iIIIiIiii_Class280.Nested1_55d7eba9();
    private iIIIiIiii_Class280.Nested1_55d7ef89 I_field_9868f506;
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> {
        float f;
        iIIIiIiii_Class280.Nested1_55d7ef89 nested1_55d7ef89 = this.I_field_9868f506;
        if (nested1_55d7ef89 == null) {
            return;
        }
        MatrixStack matrixStack = render3DEvent.getMatrices();
        matrixStack.push();
        iIiiiIIiI_Class371.I_method_642c0895(true);
        iIiiiIIiI_Class371.i_method_49a476f1(matrixStack);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        BufferBuilder bufferBuilder = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        double d = 1.0E-6;
        for (iIIIiIiii_Class280.Nested1_55d7efa9 nested1_55d7efa9 : nested1_55d7ef89.I_method_7d967456()) {
            d = Math.max(d, nested1_55d7efa9.I_method_b1d2759f());
        }
        if (this.Ii_field_ba20ca4c.i_method_9b12da03()) {
            for (iIIIiIiii_Class280.Nested1_55d7efa9 nested1_55d7efa9 : nested1_55d7ef89.I_method_7d967456()) {
                f = (float)(25.0 + 165.0 * (nested1_55d7efa9.I_method_b1d2759f() / d));
                ColorRGBA colorRGBA = IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(f);
                List<Vec3d> list = nested1_55d7efa9.I_method_10b52476();
                for (int i = 0; i < list.size() - 1; ++i) {
                    iIiiIIiIi_Class358.I_method_d5d64e01(matrixStack, bufferBuilder, list.get(i), list.get(i + 1), colorRGBA);
                }
            }
        }
        if (this.iI_field_ba20ca4c.i_method_9b12da03()) {
            for (iIIIiIiii_Class280.Nested1_55d7efa9 nested1_55d7efa9 : nested1_55d7ef89.I_method_7d967456()) {
                if (nested1_55d7efa9.I_method_b1d275b5()) {
                    this.I_method_2668c359(matrixStack, bufferBuilder, nested1_55d7efa9.I_method_93a62ac5(), IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(200.0f));
                    continue;
                }
                f = (float)(20.0 + 120.0 * (nested1_55d7efa9.I_method_b1d2759f() / d));
                this.I_method_2668c359(matrixStack, bufferBuilder, nested1_55d7efa9.I_method_93a62ac5(), IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(f));
            }
        }
        iIiiIIiIi_Class358.I_method_d5d64e01(matrixStack, bufferBuilder, nested1_55d7ef89.Ii_method_c7f8870a(), nested1_55d7ef89.II_method_2400032a(), IiiiiIIIi_Class242.i_field_d0c8ec5.withAlpha(190.0f));
        this.I_method_2e371ff3(matrixStack, bufferBuilder, nested1_55d7ef89.I_method_dc69e58b(), IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(220.0f));
        this.I_method_2e371ff3(matrixStack, bufferBuilder, nested1_55d7ef89.II_method_2400032a(), IiiiiIIIi_Class242.i_field_d0c8ec5.withAlpha(255.0f));
        iIiiiIIiI_Class371.I_method_c59155f0(bufferBuilder);
        iIiiiIIiI_Class371.I_method_a0226e1f();
        matrixStack.pop();
    };
    private final IiIIIiII_Class69<PreHudRenderEvent> i_field_3d936f41 = preHudRenderEvent -> {
        iIIIiIiii_Class280.Nested1_55d7ef89 nested1_55d7ef89 = this.I_field_9868f506;
        if (nested1_55d7ef89 == null) {
            return;
        }
        Vec2f vec2f = iIiiiiIII_Class377.I_method_211fc242(nested1_55d7ef89.II_method_2400032a());
        if (vec2f == null) {
            return;
        }
        CustomDrawContext customDrawContext = preHudRenderEvent.getContext();
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0f);
        String string = String.format("%.0f%% \u00b7 %dt \u00b7 %d", nested1_55d7ef89.I_method_7b3761bf(), nested1_55d7ef89.i_method_7b45eda4(), nested1_55d7ef89.I_method_7b3761c4());
        customDrawContext.drawCenteredText(iIiIIi_Class10, string, vec2f.x, vec2f.y - iIiIIi_Class10.I_method_a649725c() - 2.0f, IiiiiIIIi_Class242.i_field_d0c8ec5);
    };

    public PositionPredictModule() {
        this.I_field_73178e8c = new SliderSetting(this, "ticks").I_method_c8c9a7d7(1.0f).i_method_65e2aff7(40.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(10.0f).I_method_d41e7abf(" t");
        this.i_field_73178e8c = new SliderSetting(this, "directions").I_method_c8c9a7d7(4.0f).i_method_65e2aff7(16.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(8.0f);
        this.II_field_73178e8c = new SliderSetting(this, "branch_interval").I_method_c8c9a7d7(1.0f).i_method_65e2aff7(20.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(4.0f).I_method_d41e7abf(" t");
        this.Ii_field_73178e8c = new SliderSetting(this, "hitchance").I_method_c8c9a7d7(0.0f).i_method_65e2aff7(100.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(100.0f).I_method_d41e7abf("%");
        this.I_field_ba20ca4c = new BooleanSetting(this, "jump_branches").I_method_decd82b5();
        this.i_field_ba20ca4c = new BooleanSetting(this, "predict_self").I_method_decd82b5();
        this.II_field_ba20ca4c = new BooleanSetting(this, "nearest_fallback").I_method_decd82b5();
        this.Ii_field_ba20ca4c = new BooleanSetting(this, "render_cloud").I_method_decd82b5();
        this.iI_field_ba20ca4c = new BooleanSetting(this, "render_boxes").I_method_decd82b5();
    }

    @Override
    public void onDisable() {
        this.I_field_9868f506 = null;
        this.I_field_98687ce6.I_method_de6ff9b1();
    }

    @Override
    public void II_method_6642fd22() {
        Vec3d vec3d;
        this.I_field_9868f506 = null;
        if (PositionPredictModule.I_field_3a9bda27.player == null || PositionPredictModule.I_field_3a9bda27.world == null) {
            return;
        }
        LivingEntity livingEntity = this.I_method_4570e32c();
        if (livingEntity == null) {
            this.I_field_98687ce6.I_method_de6ff9b1();
            return;
        }
        this.I_field_98687ce6.I_method_24bde9f5((Entity)livingEntity);
        int n = (int)this.I_field_73178e8c.Ii_method_a20abcd2();
        Vec3d vec3d2 = vec3d = this.i_field_ba20ca4c.i_method_9b12da03() ? iIIIiIiii_Class280.I_method_3b62bd7e(n) : PositionPredictModule.I_field_3a9bda27.player.getEyePos();
        if (vec3d == null) {
            vec3d = PositionPredictModule.I_field_3a9bda27.player.getEyePos();
        }
        iIIIiIiii_Class280.Nested1_23cd28a0 nested1_23cd28a0 = new iIIIiIiii_Class280.Nested1_23cd28a0(n, (int)this.i_field_73178e8c.Ii_method_a20abcd2(), (int)this.II_field_73178e8c.Ii_method_a20abcd2(), this.I_field_ba20ca4c.i_method_9b12da03(), 64.0, 96);
        this.I_field_9868f506 = iIIIiIiii_Class280.I_method_56de63cf((Entity)livingEntity, this.I_field_98687ce6.i_method_b67f94b(), this.I_field_98687ce6.I_method_de6ff9a4(), vec3d, (double)this.Ii_field_73178e8c.Ii_method_a20abcd2() / 100.0, nested1_23cd28a0);
    }

    private LivingEntity I_method_4570e32c() {
        LivingEntity livingEntity = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
        if (livingEntity != null && livingEntity.isAlive() && livingEntity != PositionPredictModule.I_field_3a9bda27.player) {
            return livingEntity;
        }
        if (!this.II_field_ba20ca4c.i_method_9b12da03()) {
            return null;
        }
        PlayerEntity playerEntity = null;
        double d = Double.MAX_VALUE;
        for (PlayerEntity playerEntity2 : PositionPredictModule.I_field_3a9bda27.world.getPlayers()) {
            double d2;
            if (playerEntity2 == PositionPredictModule.I_field_3a9bda27.player || !playerEntity2.isAlive() || !((d2 = playerEntity2.squaredDistanceTo((Entity)PositionPredictModule.I_field_3a9bda27.player)) < d)) continue;
            d = d2;
            playerEntity = playerEntity2;
        }
        return playerEntity;
    }

    private void I_method_2668c359(MatrixStack matrixStack, BufferBuilder bufferBuilder, Box box, ColorRGBA colorRGBA) {
        double d = box.minX;
        double d2 = box.minY;
        double d3 = box.minZ;
        double d4 = box.maxX;
        double d5 = box.maxY;
        double d6 = box.maxZ;
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d, d2, d3, d4, d2, d3, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d4, d2, d3, d4, d2, d6, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d4, d2, d6, d, d2, d6, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d, d2, d6, d, d2, d3, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d, d5, d3, d4, d5, d3, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d4, d5, d3, d4, d5, d6, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d4, d5, d6, d, d5, d6, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d, d5, d6, d, d5, d3, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d, d2, d3, d, d5, d3, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d4, d2, d3, d4, d5, d3, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d4, d2, d6, d4, d5, d6, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, d, d2, d6, d, d5, d6, colorRGBA);
    }

    private void I_method_2e371ff3(MatrixStack matrixStack, BufferBuilder bufferBuilder, Vec3d vec3d, ColorRGBA colorRGBA) {
        double d = 0.18;
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, vec3d.x - d, vec3d.y, vec3d.z, vec3d.x + d, vec3d.y, vec3d.z, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, vec3d.x, vec3d.y - d, vec3d.z, vec3d.x, vec3d.y + d, vec3d.z, colorRGBA);
        this.I_method_54ea5fc1(matrixStack, bufferBuilder, vec3d.x, vec3d.y, vec3d.z - d, vec3d.x, vec3d.y, vec3d.z + d, colorRGBA);
    }

    private void I_method_54ea5fc1(MatrixStack matrixStack, BufferBuilder bufferBuilder, double d, double d2, double d3, double d4, double d5, double d6, ColorRGBA colorRGBA) {
        iIiiIIiIi_Class358.I_method_d5d64e01(matrixStack, bufferBuilder, new Vec3d(d, d2, d3), new Vec3d(d4, d5, d6), colorRGBA);
    }
}

