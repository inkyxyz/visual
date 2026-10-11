package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Item Changer",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = false,
   III_method_a89e5834 = "modules.descriptions.item_changer"
)
public class ItemChangerModule extends Module {
   private static ItemChangerModule INSTANCE;

   private BooleanSetting swordEnabled;
   private ModeSetting swordModelSetting;
   private ModeSetting.Nested1_42765c60 swordCyberKatana;
   private ModeSetting.Nested1_42765c60 swordNebulaBlade;
   private ModeSetting.Nested1_42765c60 swordBloodScythe;
   private ModeSetting.Nested1_42765c60 swordDragonSlayer;
   private ModeSetting.Nested1_42765c60 swordTexture1;
   private ModeSetting.Nested1_42765c60 swordTexture2;
   private SliderSetting swordScaleSetting;
   private BooleanSetting swordGlowSetting;

   private BooleanSetting totemEnabled;
   private ModeSetting totemModelSetting;
   private ModeSetting.Nested1_42765c60 totemAgravityCrest;
   private ModeSetting.Nested1_42765c60 totemSeraphAngel;
   private ModeSetting.Nested1_42765c60 totemDemonSkull;
   private ModeSetting.Nested1_42765c60 totemCyberCube;
   private ModeSetting.Nested1_42765c60 totemGoldenRelic;
   private SliderSetting totemScaleSetting;
   private BooleanSetting totemGlowSetting;

   public ItemChangerModule() {
      INSTANCE = this;
      this.initSettings();
   }

   public static ItemChangerModule getInstance() {
      return INSTANCE;
   }

   @Compile(obfuscation = 4)
   private void initSettings() {
      this.swordEnabled = new BooleanSetting(this, "Свой меч").select();
      this.swordModelSetting = new ModeSetting(this, "Модель меча", () -> !this.swordEnabled.i_method_9b12da03());
      this.swordCyberKatana = new ModeSetting.Nested1_42765c60(this.swordModelSetting, "Cyber Katana").select();
      this.swordNebulaBlade = new ModeSetting.Nested1_42765c60(this.swordModelSetting, "Nebula Blade");
      this.swordBloodScythe = new ModeSetting.Nested1_42765c60(this.swordModelSetting, "Blood Scythe");
      this.swordDragonSlayer = new ModeSetting.Nested1_42765c60(this.swordModelSetting, "Dragon Slayer");
      this.swordTexture1 = new ModeSetting.Nested1_42765c60(this.swordModelSetting, "Texture Sword 1");
      this.swordTexture2 = new ModeSetting.Nested1_42765c60(this.swordModelSetting, "Texture Sword 2");

      this.swordScaleSetting = new SliderSetting(this, "Размер меча", () -> !this.swordEnabled.i_method_9b12da03())
         .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

      this.swordGlowSetting = new BooleanSetting(this, "Свечение меча", () -> !this.swordEnabled.i_method_9b12da03()).select();

      this.totemEnabled = new BooleanSetting(this, "Свой тотем").select();
      this.totemModelSetting = new ModeSetting(this, "Модель тотема", () -> !this.totemEnabled.i_method_9b12da03());
      this.totemAgravityCrest = new ModeSetting.Nested1_42765c60(this.totemModelSetting, "Agravity Crest").select();
      this.totemSeraphAngel = new ModeSetting.Nested1_42765c60(this.totemModelSetting, "Seraph Angel");
      this.totemDemonSkull = new ModeSetting.Nested1_42765c60(this.totemModelSetting, "Demon Skull");
      this.totemCyberCube = new ModeSetting.Nested1_42765c60(this.totemModelSetting, "Cyber Nexus Cube");
      this.totemGoldenRelic = new ModeSetting.Nested1_42765c60(this.totemModelSetting, "Golden Relic");

      this.totemScaleSetting = new SliderSetting(this, "Размер тотема", () -> !this.totemEnabled.i_method_9b12da03())
         .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.05F).Ii_method_4e0e6b54(1.0F);

      this.totemGlowSetting = new BooleanSetting(this, "Свечение тотема", () -> !this.totemEnabled.i_method_9b12da03()).select();
   }

   public static boolean shouldReplace(ItemStack stack) {
      if (INSTANCE == null || !INSTANCE.isEnabled()) return false;
      if (stack.isEmpty()) return false;
      if (INSTANCE.swordEnabled.i_method_9b12da03() && isSword(stack)) return true;
      if (INSTANCE.totemEnabled.i_method_9b12da03() && isTotem(stack)) return true;
      return false;
   }

   public static boolean isSword(ItemStack stack) {
      return stack.getItem() instanceof SwordItem || stack.isIn(ItemTags.SWORDS);
   }

   public static boolean isTotem(ItemStack stack) {
      return stack.isOf(Items.TOTEM_OF_UNDYING);
   }

   public static void renderCustomItem(
      ItemStack stack,
      ModelTransformationMode mode,
      boolean leftHanded,
      MatrixStack m,
      VertexConsumerProvider consumers,
      int light
   ) {
      if (INSTANCE == null) return;

      m.push();
      if (isSword(stack)) {
         renderSword(mode, leftHanded, m);
      } else if (isTotem(stack)) {
         renderTotem(mode, leftHanded, m);
      }
      m.pop();
   }

   private static void renderSword(ModelTransformationMode mode, boolean leftHanded, MatrixStack m) {
      float scale = INSTANCE.swordScaleSetting.Ii_method_a20abcd2();
      m.scale(scale, scale, scale);

      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();

      if (INSTANCE.swordTexture1.isSelected() || INSTANCE.swordTexture2.isSelected()) {
         // Texture mode
         Identifier tex = INSTANCE.swordTexture1.isSelected()
            ? RockstarClient.id("textures/swords/sword.png")
            : RockstarClient.id("textures/swords/sword2.png");
         RenderSystem.setShaderTexture(0, tex);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         Matrix4f mat = m.peek().getPositionMatrix();
         ColorRGBA col = ColorRGBA.WHITE;
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.5F, -0.5F, 0.0, 1.0F, 1.0F, col);
         BuiltBuffer built = buf.endNullable();
         if (built != null) BufferRenderer.drawWithGlobalProgram(built);
         return;
      }

      // Procedural 3D Sword models
      RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
      BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      Matrix4f mat = m.peek().getPositionMatrix();

      if (INSTANCE.swordCyberKatana.isSelected()) {
         // Cyber Katana: sleek neon cyan blade, dark titanium hilt, glowing edge
         int bladeCore = 0xFF00E5FF;
         int bladeEdge = 0xFFFFFFFF;
         int hiltDark = 0xFF1A1A24;
         int goldAccent = 0xFFFFD700;

         // Handle (Tsuka)
         drawBox(mat, buf, -0.04F, -0.38F, -0.04F, 0.08F, 0.28F, 0.08F, hiltDark);
         // Pommel jewel
         drawBox(mat, buf, -0.05F, -0.42F, -0.05F, 0.10F, 0.04F, 0.10F, goldAccent);
         // Guard (Tsuba)
         drawBox(mat, buf, -0.12F, -0.10F, -0.12F, 0.24F, 0.03F, 0.24F, goldAccent);
         // Blade
         drawBox(mat, buf, -0.03F, -0.07F, -0.015F, 0.06F, 0.95F, 0.03F, bladeCore);
         // Neon edge streak
         drawBox(mat, buf, 0.025F, -0.06F, -0.005F, 0.012F, 0.96F, 0.01F, bladeEdge);
      } else if (INSTANCE.swordNebulaBlade.isSelected()) {
         // Nebula Blade: galactic purple & starlight white
         int corePurple = 0xFF8A2BE2;
         int cosmicPink = 0xFFFF1493;
         int starWhite = 0xFFF0F8FF;
         int goldGuard = 0xFFFFDF00;

         drawBox(mat, buf, -0.04F, -0.35F, -0.04F, 0.08F, 0.25F, 0.08F, 0xFF221133);
         drawBox(mat, buf, -0.14F, -0.10F, -0.06F, 0.28F, 0.04F, 0.12F, goldGuard);
         drawBox(mat, buf, -0.05F, -0.06F, -0.02F, 0.10F, 0.92F, 0.04F, corePurple);
         drawBox(mat, buf, -0.02F, -0.05F, -0.025F, 0.04F, 0.90F, 0.05F, cosmicPink);
         drawBox(mat, buf, 0.04F, 0.10F, -0.005F, 0.02F, 0.70F, 0.01F, starWhite);
      } else if (INSTANCE.swordBloodScythe.isSelected()) {
         // Blood Scythe: obsidian staff, crimson curved blade
         int staffColor = 0xFF141414;
         int bloodRed = 0xFFDC143C;
         int bloodBright = 0xFFFF0033;

         drawBox(mat, buf, -0.035F, -0.45F, -0.035F, 0.07F, 1.25F, 0.07F, staffColor);
         drawBox(mat, buf, -0.08F, 0.75F, -0.03F, 0.65F, 0.12F, 0.06F, bloodRed);
         drawBox(mat, buf, 0.40F, 0.62F, -0.025F, 0.22F, 0.15F, 0.05F, bloodBright);
      } else {
         // Dragon Slayer: massive buster sword
         int steelDark = 0xFF36393E;
         int steelEdge = 0xFFC0C0C0;
         int goldInlay = 0xFFD4AF37;

         drawBox(mat, buf, -0.05F, -0.40F, -0.05F, 0.10F, 0.30F, 0.10F, 0xFF1C1C1C);
         drawBox(mat, buf, -0.18F, -0.10F, -0.08F, 0.36F, 0.06F, 0.16F, goldInlay);
         drawBox(mat, buf, -0.12F, -0.04F, -0.03F, 0.24F, 1.05F, 0.06F, steelDark);
         drawBox(mat, buf, -0.13F, -0.02F, -0.01F, 0.015F, 1.02F, 0.02F, steelEdge);
         drawBox(mat, buf, 0.115F, -0.02F, -0.01F, 0.015F, 1.02F, 0.02F, steelEdge);
      }

      BuiltBuffer built = buf.endNullable();
      if (built != null) BufferRenderer.drawWithGlobalProgram(built);
   }

   private static void renderTotem(ModelTransformationMode mode, boolean leftHanded, MatrixStack m) {
      float scale = INSTANCE.totemScaleSetting.Ii_method_a20abcd2();
      m.scale(scale, scale, scale);

      long now = System.currentTimeMillis();
      float bob = (float)Math.sin(now * 0.004) * 0.04F;
      m.translate(0.0, bob, 0.0);

      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
      BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      Matrix4f mat = m.peek().getPositionMatrix();

      if (INSTANCE.totemAgravityCrest.isSelected()) {
         // Agravity 3D Chevron Crest
         int gold = 0xFFFFD700;
         int cyan = 0xFF00F0FF;
         int white = 0xFFFFFFFF;

         // Central chevron wings
         drawBox(mat, buf, -0.16F, -0.16F, -0.03F, 0.32F, 0.32F, 0.06F, gold);
         drawBox(mat, buf, -0.12F, -0.12F, -0.04F, 0.24F, 0.24F, 0.08F, cyan);
         drawBox(mat, buf, -0.06F, -0.06F, -0.05F, 0.12F, 0.12F, 0.10F, white);
      } else if (INSTANCE.totemSeraphAngel.isSelected()) {
         // Seraph Angel: white gown, golden wings and halo
         int haloGold = 0xFFFFE066;
         int angelWhite = 0xFFF8F8FF;
         int wingCyan = 0xFF88EEFF;

         // Body
         drawBox(mat, buf, -0.08F, -0.22F, -0.06F, 0.16F, 0.36F, 0.12F, angelWhite);
         // Head
         drawBox(mat, buf, -0.06F, 0.15F, -0.06F, 0.12F, 0.12F, 0.12F, angelWhite);
         // Halo
         drawBox(mat, buf, -0.10F, 0.30F, -0.10F, 0.20F, 0.03F, 0.20F, haloGold);
         // Wings
         drawBox(mat, buf, -0.32F, 0.0F, 0.04F, 0.24F, 0.25F, 0.04F, wingCyan);
         drawBox(mat, buf, 0.08F, 0.0F, 0.04F, 0.24F, 0.25F, 0.04F, wingCyan);
      } else if (INSTANCE.totemDemonSkull.isSelected()) {
         // Demon Skull: dark obsidian skull, fiery horns
         int skullDark = 0xFF1C1420;
         int hornLava = 0xFFFF4500;
         int eyeGlow = 0xFFFF0033;

         drawBox(mat, buf, -0.12F, -0.12F, -0.12F, 0.24F, 0.24F, 0.24F, skullDark);
         drawBox(mat, buf, -0.08F, 0.02F, -0.13F, 0.04F, 0.04F, 0.02F, eyeGlow);
         drawBox(mat, buf, 0.04F, 0.02F, -0.13F, 0.04F, 0.04F, 0.02F, eyeGlow);
         // Horns
         drawBox(mat, buf, -0.18F, 0.10F, -0.06F, 0.07F, 0.18F, 0.08F, hornLava);
         drawBox(mat, buf, 0.11F, 0.10F, -0.06F, 0.07F, 0.18F, 0.08F, hornLava);
      } else if (INSTANCE.totemCyberCube.isSelected()) {
         // Cyber Nexus Cube: spinning holographic hypercube
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((now * 0.1F) % 360.0F));
         m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0F));
         int neonCyan = 0xFF00FFFF;
         int neonPink = 0xFFFF007F;
         drawBox(mat, buf, -0.12F, -0.12F, -0.12F, 0.24F, 0.24F, 0.24F, neonCyan);
         drawBox(mat, buf, -0.07F, -0.07F, -0.07F, 0.14F, 0.14F, 0.14F, neonPink);
      } else {
         // Golden Relic
         int relicGold = 0xFFFFD700;
         int emerald = 0xFF00FA9A;
         drawBox(mat, buf, -0.14F, -0.22F, -0.05F, 0.28F, 0.44F, 0.10F, relicGold);
         drawBox(mat, buf, -0.05F, -0.05F, -0.06F, 0.10F, 0.10F, 0.12F, emerald);
      }

      BuiltBuffer built = buf.endNullable();
      if (built != null) BufferRenderer.drawWithGlobalProgram(built);
   }

   private static void drawBox(Matrix4f mat, BufferBuilder buf, float x, float y, float z, float w, float h, float d, int color) {
      float x2 = x + w;
      float y2 = y + h;
      float z2 = z + d;

      // Down
      buf.vertex(mat, x, y, z).color(color);
      buf.vertex(mat, x2, y, z).color(color);
      buf.vertex(mat, x2, y, z2).color(color);
      buf.vertex(mat, x, y, z2).color(color);

      // Up
      buf.vertex(mat, x, y2, z).color(color);
      buf.vertex(mat, x, y2, z2).color(color);
      buf.vertex(mat, x2, y2, z2).color(color);
      buf.vertex(mat, x2, y2, z).color(color);

      // North
      buf.vertex(mat, x, y, z).color(color);
      buf.vertex(mat, x, y2, z).color(color);
      buf.vertex(mat, x2, y2, z).color(color);
      buf.vertex(mat, x2, y, z).color(color);

      // South
      buf.vertex(mat, x, y, z2).color(color);
      buf.vertex(mat, x2, y, z2).color(color);
      buf.vertex(mat, x2, y2, z2).color(color);
      buf.vertex(mat, x, y2, z2).color(color);

      // West
      buf.vertex(mat, x, y, z).color(color);
      buf.vertex(mat, x, y, z2).color(color);
      buf.vertex(mat, x, y2, z2).color(color);
      buf.vertex(mat, x, y2, z).color(color);

      // East
      buf.vertex(mat, x2, y, z).color(color);
      buf.vertex(mat, x2, y2, z).color(color);
      buf.vertex(mat, x2, y2, z2).color(color);
      buf.vertex(mat, x2, y, z2).color(color);
   }
}
