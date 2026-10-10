package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Block Overlay",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = false,
   III_method_a89e5834 = "modules.descriptions.block_overlay"
)
public class BlockOverlayModule extends Module {
   private ModeSetting modeSetting;
   private ModeSetting.Nested1_42765c60 modeOutline;
   private ModeSetting.Nested1_42765c60 modeGradient;
   private ModeSetting.Nested1_42765c60 modeFullBox;
   private ModeSetting.Nested1_42765c60 modeCorners;
   private ModeSetting.Nested1_42765c60 modeFrostedGlass;
   private ModeSetting.Nested1_42765c60 modeNeonGrid;

   private SliderSetting fillAlphaSetting;
   private SliderSetting outlineAlphaSetting;
   private BooleanSetting smoothMorphSetting;
   private BooleanSetting depthTestSetting;
   private BooleanSetting syncTheme;
   private ColorSetting customColor;

   // Smooth morph animation coordinates
   private double curMinX, curMinY, curMinZ;
   private double curMaxX, curMaxY, curMaxZ;
   private boolean hasTarget = false;
   private float fadeAlpha = 0.0F;

   public BlockOverlayModule() {
      this.initSettings();
   }

   @Compile(obfuscation = 4)
   private void initSettings() {
      this.modeSetting = new ModeSetting(this, "Mode / Режим");
      this.modeOutline = new ModeSetting.Nested1_42765c60(this.modeSetting, "Outline / Контур");
      this.modeGradient = new ModeSetting.Nested1_42765c60(this.modeSetting, "Gradient / Градиент");
      this.modeFullBox = new ModeSetting.Nested1_42765c60(this.modeSetting, "Full Box / Заливка").select();
      this.modeCorners = new ModeSetting.Nested1_42765c60(this.modeSetting, "Corners / Уголки");
      this.modeFrostedGlass = new ModeSetting.Nested1_42765c60(this.modeSetting, "Frosted Glass / Стекло");
      this.modeNeonGrid = new ModeSetting.Nested1_42765c60(this.modeSetting, "Neon Grid / Сетка");

      this.fillAlphaSetting = new SliderSetting(this, "Fill Opacity / Прозрачность")
         .I_method_c8c9a7d7(0.0F).i_method_65e2aff7(1.0F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(0.35F);

      this.outlineAlphaSetting = new SliderSetting(this, "Outline Alpha / Яркость линий")
         .I_method_c8c9a7d7(0.0F).i_method_65e2aff7(1.0F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(0.85F);

      this.smoothMorphSetting = new BooleanSetting(this, "Smooth Morph / Плавный переход").select();
      this.depthTestSetting = new BooleanSetting(this, "Depth Test / Сквозь стены").I_method_decd82b5();
      this.syncTheme = new BooleanSetting(this, "theme.sync").select();
      this.customColor = new ColorSetting(this, "Color / Цвет", this.syncTheme::i_method_9b12da03)
         .I_method_a62f5dd6(new ColorRGBA(0.0F, 220.0F, 255.0F, 240.0F));
   }

   private final IiIIIiII_Class69<Render3DEvent> renderListener = event -> {
      MinecraftClient mc = MinecraftClient.getInstance();
      if (mc.world == null || mc.player == null) return;

      HitResult hit = mc.crosshairTarget;
      Box targetBox = null;

      if (hit instanceof BlockHitResult blockHit && hit.getType() == HitResult.Type.BLOCK) {
         BlockPos pos = blockHit.getBlockPos();
         BlockState state = mc.world.getBlockState(pos);
         if (!state.isAir()) {
            VoxelShape shape = state.getOutlineShape(mc.world, pos);
            if (!shape.isEmpty()) {
               targetBox = shape.getBoundingBox().offset(pos);
            }
         }
      }

      if (targetBox != null) {
         if (!this.hasTarget) {
            this.curMinX = targetBox.minX;
            this.curMinY = targetBox.minY;
            this.curMinZ = targetBox.minZ;
            this.curMaxX = targetBox.maxX;
            this.curMaxY = targetBox.maxY;
            this.curMaxZ = targetBox.maxZ;
            this.hasTarget = true;
         } else if (this.smoothMorphSetting != null && this.smoothMorphSetting.i_method_9b12da03()) {
            float lerpSpeed = 0.32F;
            this.curMinX += (targetBox.minX - this.curMinX) * lerpSpeed;
            this.curMinY += (targetBox.minY - this.curMinY) * lerpSpeed;
            this.curMinZ += (targetBox.minZ - this.curMinZ) * lerpSpeed;
            this.curMaxX += (targetBox.maxX - this.curMaxX) * lerpSpeed;
            this.curMaxY += (targetBox.maxY - this.curMaxY) * lerpSpeed;
            this.curMaxZ += (targetBox.maxZ - this.curMaxZ) * lerpSpeed;
         } else {
            this.curMinX = targetBox.minX;
            this.curMinY = targetBox.minY;
            this.curMinZ = targetBox.minZ;
            this.curMaxX = targetBox.maxX;
            this.curMaxY = targetBox.maxY;
            this.curMaxZ = targetBox.maxZ;
         }
         this.fadeAlpha = Math.min(1.0F, this.fadeAlpha + 0.15F);
      } else {
         this.fadeAlpha = Math.max(0.0F, this.fadeAlpha - 0.15F);
         if (this.fadeAlpha <= 0.01F) {
            this.hasTarget = false;
            return;
         }
      }

      ColorRGBA themeCol = (this.syncTheme != null && this.syncTheme.i_method_9b12da03())
         ? IiiiiIIIi_Class242.i_method_5dfec6e()
         : (this.customColor != null ? this.customColor.I_method_bde5f08e() : new ColorRGBA(0.0F, 220.0F, 255.0F, 240.0F));

      float fillA = (this.fillAlphaSetting != null ? this.fillAlphaSetting.Ii_method_a20abcd2() : 0.35F) * this.fadeAlpha;
      float lineA = (this.outlineAlphaSetting != null ? this.outlineAlphaSetting.Ii_method_a20abcd2() : 0.85F) * this.fadeAlpha;

      Camera cam = I_field_3a9bda27.gameRenderer.getCamera();
      Vec3d cpos = cam.getPos();
      MatrixStack m = event.getMatrices();

      m.push();
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE_MINUS_SRC_ALPHA);
      if (this.depthTestSetting != null && this.depthTestSetting.i_method_9b12da03()) {
         RenderSystem.enableDepthTest();
      } else {
         RenderSystem.disableDepthTest();
      }
      RenderSystem.disableCull();
      RenderSystem.depthMask(false);

      float x1 = (float)(this.curMinX - cpos.x);
      float y1 = (float)(this.curMinY - cpos.y);
      float z1 = (float)(this.curMinZ - cpos.z);
      float x2 = (float)(this.curMaxX - cpos.x);
      float y2 = (float)(this.curMaxY - cpos.y);
      float z2 = (float)(this.curMaxZ - cpos.z);

      Matrix4f mat = m.peek().getPositionMatrix();

      // Render Fill pass
      boolean renderFill = this.modeFullBox.isSelected() || this.modeGradient.isSelected() || this.modeFrostedGlass.isSelected();
      if (renderFill && fillA > 0.01F) {
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

         int cTop = themeCol.withAlpha(fillA * 255.0F).getRGB();
         int cBottom = this.modeGradient.isSelected()
            ? themeCol.withAlpha(fillA * 40.0F).getRGB()
            : (this.modeFrostedGlass.isSelected() ? themeCol.withAlpha(fillA * 180.0F).getRGB() : cTop);

         // Down face
         buf.vertex(mat, x1, y1, z1).color(cBottom);
         buf.vertex(mat, x2, y1, z1).color(cBottom);
         buf.vertex(mat, x2, y1, z2).color(cBottom);
         buf.vertex(mat, x1, y1, z2).color(cBottom);

         // Up face
         buf.vertex(mat, x1, y2, z1).color(cTop);
         buf.vertex(mat, x1, y2, z2).color(cTop);
         buf.vertex(mat, x2, y2, z2).color(cTop);
         buf.vertex(mat, x2, y2, z1).color(cTop);

         // North
         buf.vertex(mat, x1, y1, z1).color(cBottom);
         buf.vertex(mat, x1, y2, z1).color(cTop);
         buf.vertex(mat, x2, y2, z1).color(cTop);
         buf.vertex(mat, x2, y1, z1).color(cBottom);

         // South
         buf.vertex(mat, x1, y1, z2).color(cBottom);
         buf.vertex(mat, x2, y1, z2).color(cBottom);
         buf.vertex(mat, x2, y2, z2).color(cTop);
         buf.vertex(mat, x1, y2, z2).color(cTop);

         // West
         buf.vertex(mat, x1, y1, z1).color(cBottom);
         buf.vertex(mat, x1, y1, z2).color(cBottom);
         buf.vertex(mat, x1, y2, z2).color(cTop);
         buf.vertex(mat, x1, y2, z1).color(cTop);

         // East
         buf.vertex(mat, x2, y1, z1).color(cBottom);
         buf.vertex(mat, x2, y2, z1).color(cTop);
         buf.vertex(mat, x2, y2, z2).color(cTop);
         buf.vertex(mat, x2, y1, z2).color(cBottom);

         BuiltBuffer built = buf.endNullable();
         if (built != null) BufferRenderer.drawWithGlobalProgram(built);
      }

      // Render Line / Outline pass
      if (lineA > 0.01F) {
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
         int cLine = themeCol.withAlpha(lineA * 255.0F).getRGB();

         if (this.modeCorners.isSelected()) {
            // Corner brackets: 8 corners, 3 segments each
            float clen = Math.min(x2 - x1, Math.min(y2 - y1, z2 - z1)) * 0.28F;

            // (x1, y1, z1)
            drawCorner(mat, buf, x1, y1, z1, clen, clen, clen, cLine);
            // (x2, y1, z1)
            drawCorner(mat, buf, x2, y1, z1, -clen, clen, clen, cLine);
            // (x1, y1, z2)
            drawCorner(mat, buf, x1, y1, z2, clen, clen, -clen, cLine);
            // (x2, y1, z2)
            drawCorner(mat, buf, x2, y1, z2, -clen, clen, -clen, cLine);
            // (x1, y2, z1)
            drawCorner(mat, buf, x1, y2, z1, clen, -clen, clen, cLine);
            // (x2, y2, z1)
            drawCorner(mat, buf, x2, y2, z1, -clen, -clen, clen, cLine);
            // (x1, y2, z2)
            drawCorner(mat, buf, x1, y2, z2, clen, -clen, -clen, cLine);
            // (x2, y2, z2)
            drawCorner(mat, buf, x2, y2, z2, -clen, -clen, -clen, cLine);
         } else {
            // Full box 12 edges
            // Bottom 4 edges
            buf.vertex(mat, x1, y1, z1).color(cLine); buf.vertex(mat, x2, y1, z1).color(cLine);
            buf.vertex(mat, x2, y1, z1).color(cLine); buf.vertex(mat, x2, y1, z2).color(cLine);
            buf.vertex(mat, x2, y1, z2).color(cLine); buf.vertex(mat, x1, y1, z2).color(cLine);
            buf.vertex(mat, x1, y1, z2).color(cLine); buf.vertex(mat, x1, y1, z1).color(cLine);

            // Top 4 edges
            buf.vertex(mat, x1, y2, z1).color(cLine); buf.vertex(mat, x2, y2, z1).color(cLine);
            buf.vertex(mat, x2, y2, z1).color(cLine); buf.vertex(mat, x2, y2, z2).color(cLine);
            buf.vertex(mat, x2, y2, z2).color(cLine); buf.vertex(mat, x1, y2, z2).color(cLine);
            buf.vertex(mat, x1, y2, z2).color(cLine); buf.vertex(mat, x1, y2, z1).color(cLine);

            // 4 Vertical pillars
            buf.vertex(mat, x1, y1, z1).color(cLine); buf.vertex(mat, x1, y2, z1).color(cLine);
            buf.vertex(mat, x2, y1, z1).color(cLine); buf.vertex(mat, x2, y2, z1).color(cLine);
            buf.vertex(mat, x2, y1, z2).color(cLine); buf.vertex(mat, x2, y2, z2).color(cLine);
            buf.vertex(mat, x1, y1, z2).color(cLine); buf.vertex(mat, x1, y2, z2).color(cLine);

            if (this.modeNeonGrid.isSelected()) {
               // Internal wireframe cross on top face
               buf.vertex(mat, x1, y2, z1).color(cLine); buf.vertex(mat, x2, y2, z2).color(cLine);
               buf.vertex(mat, x1, y2, z2).color(cLine); buf.vertex(mat, x2, y2, z1).color(cLine);
            }
         }

         BuiltBuffer builtLines = buf.endNullable();
         if (builtLines != null) BufferRenderer.drawWithGlobalProgram(builtLines);
      }

      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
      RenderSystem.enableCull();
      RenderSystem.enableDepthTest();
      m.pop();
   };

   private static void drawCorner(Matrix4f mat, BufferBuilder buf, float x, float y, float z, float dx, float dy, float dz, int color) {
      buf.vertex(mat, x, y, z).color(color); buf.vertex(mat, x + dx, y, z).color(color);
      buf.vertex(mat, x, y, z).color(color); buf.vertex(mat, x, y + dy, z).color(color);
      buf.vertex(mat, x, y, z).color(color); buf.vertex(mat, x, y, z + dz).color(color);
   }
}
