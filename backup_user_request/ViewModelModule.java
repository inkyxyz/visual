package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Consumer;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import pyrock.events.render.ChatRenderEvent;
import pyrock.events.render.HandRenderEvent;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.window.ChatClickEvent;
import pyrock.events.window.ChatReleaseEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "View Model",
   category = ModuleCategory.VISUALS,
   III_method_a89e5834 = "modules.descriptions.view_model"
)
public class ViewModelModule extends Module {
   public static boolean I_field_5a;
   private static final int I_field_49 = 15728880;
   private static final float I_field_46 = 0.4F;
   private static final int i_field_49 = 16;
   static final float[] I_field_b4b = new float[16];
   static final float[] i_field_b4b = new float[16];
   VectorRangeSetting I_field_bbe3424c;
   VectorRangeSetting i_field_bbe3424c;
   SliderSetting I_field_73178e8c;
   SliderSetting i_field_73178e8c;
   private BooleanSetting I_field_ba20ca4c;
   private ButtonSetting I_field_bbd4b28c;
   private final ViewModelModule.Nested1_448e4880 I_field_90f29e07 = new ViewModelModule.Nested1_448e4880();
   private final ViewModelModule.Nested1_448e4880 i_field_90f29e07 = new ViewModelModule.Nested1_448e4880();
   private float i_field_46;
   private float II_field_46;
   Arm I_field_3260204c;
   private float Ii_field_46;
   private float iI_field_46;
   private float ii_field_46;
   private float III_field_46;
   private boolean i_field_5a;
   private final IiIIIiII_Class69<HandRenderEvent> I_field_3d936f41 = new IiIIIiII_Class69<HandRenderEvent>() {
      public void onEvent(HandRenderEvent var1) {
         MatrixStack var2 = var1.getMatrices();
         boolean var3 = var1.getArm() == Arm.RIGHT;
         float var4 = ViewModelModule.this.I_field_73178e8c.Ii_method_a20abcd2() - 1.0F;
         float var5 = ViewModelModule.this.i_field_73178e8c.Ii_method_a20abcd2() - 1.0F;
         if (var3) {
            var2.translate(
               ViewModelModule.this.I_field_bbe3424c.I_method_82f061ef() - var5,
               -ViewModelModule.this.I_field_bbe3424c.i_method_82feedcf() + var5 / 2.0F,
               var5
            );
         } else {
            var2.translate(
               ViewModelModule.this.i_field_bbe3424c.I_method_82f061ef() + var4,
               -ViewModelModule.this.i_field_bbe3424c.i_method_82feedcf() + var4 / 2.0F,
               var4
            );
         }

         if (ViewModelModule.this.Iii_method_32815263()) {
            ViewModelModule.this.I_method_a2c7be1d(var1);
         } else {
            ViewModelModule.this.I_field_3260204c = null;
         }
      }

      @Override
      public int I_method_f12c6485() {
         return 1;
      }
   };
   private final IiIIIiII_Class69<ChatRenderEvent> i_field_3d936f41 = var1 -> {
      if (!this.Iii_method_32815263()) {
         this.I_field_3260204c = null;
      } else {
         Vector2f var2 = iIIiIIIiI_Class291.I_method_81637b4f();
         if (this.I_field_3260204c != null) {
            this.I_method_2edde23f(var2.getX(), var2.getY());
         }

         if (this.I_method_2f2f6430() != null) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
         }
      }
   };
   private final IiIIIiII_Class69<PreHudRenderEvent> II_field_3d936f41 = var1 -> {
      ViewModelModule.Nested1_448e4880 var2 = this.Iii_method_32815263() ? this.I_method_2f2f6430() : null;
      this.I_method_ec0eccf2(this.I_field_90f29e07, var2 == this.I_field_90f29e07);
      this.I_method_ec0eccf2(this.i_field_90f29e07, var2 == this.i_field_90f29e07);
   };
   private final IiIIIiII_Class69<ChatClickEvent> Ii_field_3d936f41 = var1 -> {
      if (this.Iii_method_32815263() && var1.getButton() == 0 && !this.I_method_2edde243(var1.getX(), var1.getY())) {
         ViewModelModule.Nested1_448e4880 var2 = this.I_method_99a9e830(var1.getX(), var1.getY());
         if (var2 != null) {
            this.I_field_3260204c = var2 == this.I_field_90f29e07 ? Arm.RIGHT : Arm.LEFT;
            VectorRangeSetting var3 = this.I_method_600a7f01(this.I_field_3260204c);
            this.Ii_field_46 = var1.getX();
            this.iI_field_46 = var1.getY();
            this.ii_field_46 = var3.I_method_82f061ef();
            this.III_field_46 = var3.i_method_82feedcf();
         }
      }
   };
   private final IiIIIiII_Class69<ChatReleaseEvent> iI_field_3d936f41 = var1 -> this.I_field_3260204c = null;

   public ViewModelModule() {
      this.IiI_method_3272c67f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_3272c67f() {
      this.i_field_bbe3424c = new VectorRangeSetting(this, "modules.settings.view_model.off_translate_x")
         .II_method_90cdcab4(-2.0F)
         .Ii_method_2de6d2d4(2.0F)
         .iI_method_96d5c694(-2.0F)
         .ii_method_33eeceb4(2.0F)
         .I_method_f30816f5(0.0F, 0.0F);
      this.I_field_bbe3424c = new VectorRangeSetting(this, "modules.settings.view_model.main_translate_x")
         .II_method_90cdcab4(-2.0F)
         .Ii_method_2de6d2d4(2.0F)
         .iI_method_96d5c694(-2.0F)
         .ii_method_33eeceb4(2.0F)
         .I_method_f30816f5(0.0F, 0.0F);
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.view_model.size_left")
         .I_method_c8c9a7d7(0.1F)
         .i_method_65e2aff7(1.5F)
         .II_method_b0f56334(0.025F)
         .Ii_method_4e0e6b54(1.0F);
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.view_model.size_right")
         .I_method_c8c9a7d7(0.1F)
         .i_method_65e2aff7(1.5F)
         .II_method_b0f56334(0.025F)
         .Ii_method_4e0e6b54(1.0F);
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.view_model.chat_edit").I_method_a4d009eb(true);
      this.I_field_bbd4b28c = new ButtonSetting(this, "modules.settings.view_model.reset").I_method_f05556b3(this::Iii_method_3281525f);
   }

   private void I_method_2ae0881d(String var1, Exception var2) {
      if (!this.i_field_5a) {
         this.i_field_5a = true;
         RockstarClient.I_field_ab0f6068.error("[viewmodel] {}", var1, var2);
      }
   }

   private void Iii_method_3281525f() {
      try (IIiiiIIIi_Class114.Nested1_39013fc9 var1 = IIiiiIIIi_Class114.I_method_fd3033bd()) {
         this.I_field_bbe3424c.I_method_886cd63f(0.0F, 0.0F);
         this.i_field_bbe3424c.I_method_886cd63f(0.0F, 0.0F);
         this.i_field_73178e8c.I_method_a1eda161(1.0F);
         this.I_field_73178e8c.I_method_a1eda161(1.0F);
      }

      this.I_field_3260204c = null;
   }

   void I_method_a2c7be1d(HandRenderEvent var1) {
      Matrix4f var2 = this.I_method_a3c302dd().mul(var1.getMatrices().peek().getPositionMatrix());
      float var3 = -0.72F;
      Vector2f var4 = this.I_method_ae548081(var2, 0.0F, 0.0F, var3);
      Vector2f var5 = this.I_method_ae548081(var2, 1.0F, 0.0F, var3);
      Vector2f var6 = this.I_method_ae548081(var2, 0.0F, 1.0F, var3);
      if (var4 != null && var5 != null && var6 != null) {
         this.i_field_46 = Math.abs(var5.getX() - var4.getX());
         this.II_field_46 = Math.abs(var6.getY() - var4.getY());
      }
   }

   private Matrix4f I_method_a3c302dd() {
      return new Matrix4f(RenderSystem.getProjectionMatrix()).mul(RenderSystem.getModelViewMatrix());
   }

   private Vector2f I_method_ae548081(Matrix4f var1, float var2, float var3, float var4) {
      Vector4f var5 = new Vector4f(var2, var3, var4, 1.0F);
      var1.transform(var5);
      return var5.w <= 1.0E-4F
         ? null
         : new Vector2f(
            (var5.x / var5.w * 0.5F + 0.5F) * I_field_73c6d26c.I_method_804ee20f(), (0.5F - var5.y / var5.w * 0.5F) * I_field_73c6d26c.i_method_805d6def()
         );
   }

   public void I_method_92672641(
      ItemRenderer var1,
      LivingEntity var2,
      ItemStack var3,
      ModelTransformationMode var4,
      boolean var5,
      MatrixStack var6,
      World var7,
      int var8,
      int var9,
      int var10
   ) {
      if (this.Iii_method_32815263() && var3 != null && !var3.isEmpty()) {
         if (var4 == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND || var4 == ModelTransformationMode.FIRST_PERSON_LEFT_HAND) {
            ViewModelModule.Nested1_448e4880 var11 = var4 == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND ? this.I_field_90f29e07 : this.i_field_90f29e07;
            MatrixStack var12 = new MatrixStack();
            var12.multiplyPositionMatrix(var6.peek().getPositionMatrix());
            var11.I_method_a30616b4(this.I_method_a3c302dd());

            try {
               var1.renderItem(var2, var3, var4, var5, var12, var11, var7, var8, var9, var10);
            } catch (Exception var14) {
               this.I_method_2ae0881d("shape probe failed for " + var3.getItem(), var14);
            }

            var11.I_method_1e350b3a();
            this.I_method_20f1a012(var11, var9x -> {
               MatrixStack var10x = new MatrixStack();
               var10x.multiplyPositionMatrix(var6.peek().getPositionMatrix());
               var1.renderItem(var2, var3, var4, var5, var10x, var9x, var7, 15728880, var9, var10);
            });
         }
      }
   }

   public void I_method_a0ebf03d(Arm var1, MatrixStack var2) {
      if (this.Iii_method_32815263()) {
         ClientPlayerEntity var3 = I_field_3a9bda27.player;
         if (var3 != null) {
            if (I_field_3a9bda27.getEntityRenderDispatcher().getRenderer(var3) instanceof PlayerEntityRenderer var4) {
               ViewModelModule.Nested1_448e4880 var11 = var1 == Arm.RIGHT ? this.I_field_90f29e07 : this.i_field_90f29e07;
               MatrixStack var6 = new MatrixStack();
               var6.multiplyPositionMatrix(var2.peek().getPositionMatrix());
               Identifier var7 = var3.getSkinTextures().texture();
               boolean var8 = var3.isPartVisible(var1 == Arm.LEFT ? PlayerModelPart.LEFT_SLEEVE : PlayerModelPart.RIGHT_SLEEVE);
               var11.I_method_a30616b4(this.I_method_a3c302dd());

               try {
                  this.I_method_331df806(var4, var1, var6, var11, var7, var8);
               } catch (Exception var10) {
               }

               var11.I_method_1e350b3a();
               this.I_method_20f1a012(var11, var6x -> {
                  MatrixStack var7x = new MatrixStack();
                  var7x.multiplyPositionMatrix(var2.peek().getPositionMatrix());
                  this.I_method_331df806(var4, var1, var7x, var6x, var7, var8);
               });
            }
         }
      }
   }

   private void I_method_331df806(PlayerEntityRenderer var1, Arm var2, MatrixStack var3, VertexConsumerProvider var4, Identifier var5, boolean var6) {
      if (var2 == Arm.LEFT) {
         var1.renderLeftArm(var3, var4, 15728880, var5, var6);
      } else {
         var1.renderRightArm(var3, var4, 15728880, var5, var6);
      }
   }

   private void I_method_20f1a012(ViewModelModule.Nested1_448e4880 var1, Consumer<Immediate> var2) {
      Immediate var3 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
      var3.draw();
      I_field_5a = true;
      var1.I_field_cb35e4c.I_method_53fdf4b5(true);

      try {
         var2.accept(var3);
         var3.draw();
         var1.I_field_5a = true;
      } catch (Exception var5) {
         this.I_method_2ae0881d("capture failed", var5);
      }

      var1.I_field_cb35e4c.i_method_766109df();
      I_field_5a = false;
   }

   private ViewModelModule.Nested1_448e4880 I_method_2f2f6430() {
      if (this.I_field_3260204c != null) {
         return this.I_method_c83d817c(this.I_field_3260204c);
      } else {
         Vector2f var1 = iIIiIIIiI_Class291.I_method_81637b4f();
         return this.I_method_99a9e830(var1.getX(), var1.getY());
      }
   }

   public boolean I_method_acdecd65(float var1, float var2, float var3) {
      if (this.Iii_method_32815263() && var3 != 0.0F) {
         Arm var4 = this.I_field_3260204c;
         if (var4 == null) {
            ViewModelModule.Nested1_448e4880 var5 = this.I_method_99a9e830(var1, var2);
            if (var5 == null || this.I_method_2edde243(var1, var2)) {
               return false;
            }

            var4 = var5 == this.I_field_90f29e07 ? Arm.RIGHT : Arm.LEFT;
         }

         SliderSetting var6 = this.I_method_173ecb41(var4);
         var6.I_method_a1eda161(var6.Ii_method_a20abcd2() + var3 * var6.II_method_a1fc30f2() * 2.0F);
         return true;
      } else {
         return false;
      }
   }

   private void I_method_2edde23f(float var1, float var2) {
      if (!(this.i_field_46 <= 0.001F) && !(this.II_field_46 <= 0.001F)) {
         this.I_method_600a7f01(this.I_field_3260204c)
            .I_method_886cd63f(this.ii_field_46 + (var1 - this.Ii_field_46) / this.i_field_46, this.III_field_46 + (var2 - this.iI_field_46) / this.II_field_46);
      }
   }

   private void I_method_ec0eccf2(ViewModelModule.Nested1_448e4880 var1, boolean var2) {
      float var3 = var1.I_field_dc7facc.I_method_edd6dd11(var2 && var1.I_method_1e350b3e() ? 1.0F : 0.0F);
      if (!(var3 <= 0.01F) && var1.I_field_5a) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         boolean var4 = GL11.glIsEnabled(2929);
         this.I_method_5ef6b8a7(var1.I_field_cb35e4c);
         RenderSystem.setShaderTexture(0, var1.I_field_cb35e4c.getColorAttachment());
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.4F * var3);
         iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, I_field_73c6d26c.I_method_804ee20f(), I_field_73c6d26c.i_method_805d6def());
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         if (var4) {
            RenderSystem.enableDepthTest();
         }
      }
   }

   private void I_method_5ef6b8a7(iIiiIIiII_Class357 var1) {
      var1.beginWrite(true);
      RenderSystem.enableBlend();
      GlStateManager._blendFuncSeparate(772, 0, 0, 1);
      RenderSystem.disableDepthTest();
      RenderSystem.disableCull();
      RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      float var2 = I_field_73c6d26c.I_method_804ee20f();
      float var3 = I_field_73c6d26c.i_method_805d6def();
      int var4 = ColorRGBA.WHITE.getRGB();
      BufferBuilder var5 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      var5.vertex(0.0F, 0.0F, 0.0F).color(var4);
      var5.vertex(0.0F, var3, 0.0F).color(var4);
      var5.vertex(var2, var3, 0.0F).color(var4);
      var5.vertex(var2, 0.0F, 0.0F).color(var4);
      BufferRenderer.drawWithGlobalProgram(var5.end());
      RenderSystem.defaultBlendFunc();
      I_field_3a9bda27.getFramebuffer().beginWrite(true);
   }

   private ViewModelModule.Nested1_448e4880 I_method_99a9e830(double var1, double var3) {
      boolean var5 = this.I_field_90f29e07.I_method_652c1cbe((float)var1, (float)var3);
      boolean var6 = this.i_field_90f29e07.I_method_652c1cbe((float)var1, (float)var3);
      if (var5 && var6) {
         return this.I_field_90f29e07.I_method_652b2c68(var1, var3) <= this.i_field_90f29e07.I_method_652b2c68(var1, var3)
            ? this.I_field_90f29e07
            : this.i_field_90f29e07;
      } else if (var5) {
         return this.I_field_90f29e07;
      } else {
         return var6 ? this.i_field_90f29e07 : null;
      }
   }

   private boolean I_method_2edde243(float var1, float var2) {
      if (var2 > I_field_73c6d26c.i_method_805d6def() - 16.0F) {
         return true;
      } else {
         IiIiIIIii_Class164 var3 = RockstarClient.getInstance().I_method_35687482();
         if (var3 == null) {
            return false;
         } else {
            for (IiIIiiIii_Class156 var5 : var3.IIi_method_367bf9a8()) {
               if (var5.II_method_c3e648e6() && var5.I_method_a74dc6d0(var1, var2)) {
                  return true;
               }
            }

            for (IiIiIIiII_Class165 var7 : var3.III_method_812fc188()) {
               if (var7.isDragging() || var7.isShowing() && var7.isHovered(var1, var2)) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   public boolean IiI_method_3272c683() {
      return this.isEnabled() && this.I_field_ba20ca4c.i_method_9b12da03() && I_field_3a9bda27.currentScreen instanceof ChatScreen;
   }

   boolean Iii_method_32815263() {
      return this.IiI_method_3272c683();
   }

   private ViewModelModule.Nested1_448e4880 I_method_c83d817c(Arm var1) {
      return var1 == Arm.RIGHT ? this.I_field_90f29e07 : this.i_field_90f29e07;
   }

   private VectorRangeSetting I_method_600a7f01(Arm var1) {
      return var1 == Arm.RIGHT ? this.I_field_bbe3424c : this.i_field_bbe3424c;
   }

   private SliderSetting I_method_173ecb41(Arm var1) {
      return var1 == Arm.RIGHT ? this.i_field_73178e8c : this.I_field_73178e8c;
   }

   static {
      for (int var0 = 0; var0 < 16; var0++) {
         double var1 = (Math.PI * 2) * var0 / 16.0;
         I_field_b4b[var0] = (float)Math.cos(var1);
         i_field_b4b[var0] = (float)Math.sin(var1);
      }
   }

   static final class Nested1_448e4880 implements VertexConsumerProvider {
      private static final float I_field_46 = 3.0F;
      final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(220L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
      private final float[] I_field_b4b = new float[16];
      final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0F);
      private final Map<RenderLayer, ViewModelModule.Nested1_448e48a0> I_field_a567c40b = new IdentityHashMap<>();
      private Matrix4f I_field_d754d74;
      private float i_field_46;
      private float II_field_46;
      private float Ii_field_46;
      private float iI_field_46;
      private int I_field_49;
      private long I_field_4a;
      boolean I_field_5a;

      void I_method_a30616b4(Matrix4f var1) {
         this.I_field_d754d74 = var1;
         this.I_field_49 = 0;
         this.I_field_5a = false;
         this.i_field_46 = Float.MAX_VALUE;
         this.II_field_46 = Float.MAX_VALUE;
         this.Ii_field_46 = -Float.MAX_VALUE;
         this.iI_field_46 = -Float.MAX_VALUE;
         Arrays.fill(this.I_field_b4b, -Float.MAX_VALUE);
      }

      void I_method_1e350b3a() {
         this.I_field_d754d74 = null;
         if (this.I_field_49 >= 3) {
            this.I_field_4a = System.currentTimeMillis();
         }
      }

      boolean I_method_1e350b3e() {
         return this.I_field_49 >= 3 && System.currentTimeMillis() - this.I_field_4a < 250L;
      }

      boolean I_method_652c1cbe(float var1, float var2) {
         return this.I_method_1e350b3e() && this.I_method_4057e24a(var1, var2, 0.0F);
      }

      private boolean I_method_4057e24a(float var1, float var2, float var3) {
         for (int var4 = 0; var4 < 16; var4++) {
            if (var1 * ViewModelModule.I_field_b4b[var4] + var2 * ViewModelModule.i_field_b4b[var4] > this.I_field_b4b[var4] + 3.0F + var3) {
               return false;
            }
         }

         return true;
      }

      double I_method_652b2c68(double var1, double var3) {
         double var5 = var1 - this.I_method_1e350b2a();
         double var7 = var3 - (this.II_field_46 + this.iI_field_46) / 2.0F;
         return var5 * var5 + var7 * var7;
      }

      private float I_method_1e350b2a() {
         return (this.i_field_46 + this.Ii_field_46) / 2.0F;
      }

      public VertexConsumer getBuffer(RenderLayer var1) {
         return this.I_field_a567c40b.computeIfAbsent(var1, var1x -> new ViewModelModule.Nested1_448e48a0(this));
      }

      void I_method_4057e246(float var1, float var2, float var3) {
         Matrix4f var4 = this.I_field_d754d74;
         if (var4 != null) {
            float var5 = var4.m00() * var1 + var4.m10() * var2 + var4.m20() * var3 + var4.m30();
            float var6 = var4.m01() * var1 + var4.m11() * var2 + var4.m21() * var3 + var4.m31();
            float var7 = var4.m03() * var1 + var4.m13() * var2 + var4.m23() * var3 + var4.m33();
            if (!(var7 <= 1.0E-4F)) {
               float var8 = (var5 / var7 * 0.5F + 0.5F) * iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f();
               float var9 = (0.5F - var6 / var7 * 0.5F) * iIIiIIiiI_Class295.I_field_73c6d26c.i_method_805d6def();

               for (int var10 = 0; var10 < 16; var10++) {
                  float var11 = var8 * ViewModelModule.I_field_b4b[var10] + var9 * ViewModelModule.i_field_b4b[var10];
                  if (var11 > this.I_field_b4b[var10]) {
                     this.I_field_b4b[var10] = var11;
                  }
               }

               if (var8 < this.i_field_46) {
                  this.i_field_46 = var8;
               }

               if (var8 > this.Ii_field_46) {
                  this.Ii_field_46 = var8;
               }

               if (var9 < this.II_field_46) {
                  this.II_field_46 = var9;
               }

               if (var9 > this.iI_field_46) {
                  this.iI_field_46 = var9;
               }

               this.I_field_49++;
            }
         }
      }
   }

   static final class Nested1_448e48a0 implements VertexConsumer {
      private final ViewModelModule.Nested1_448e4880 I_field_90f29e07;

      Nested1_448e48a0(ViewModelModule.Nested1_448e4880 var1) {
         this.I_field_90f29e07 = var1;
      }

      public VertexConsumer vertex(float x, float y, float z) {
         this.I_field_90f29e07.I_method_4057e246(x, y, z);
         return this;
      }

      public VertexConsumer color(int red, int green, int blue, int alpha) {
         return this;
      }

      public VertexConsumer texture(float u, float v) {
         return this;
      }

      public VertexConsumer overlay(int u, int v) {
         return this;
      }

      public VertexConsumer light(int u, int v) {
         return this;
      }

      public VertexConsumer normal(float x, float y, float z) {
         return this;
      }

      @Override
      public final String toString() {
         return "Nested1_448e48a0[shape=" + this.I_field_90f29e07 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_90f29e07);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ViewModelModule.Nested1_448e48a0 other = (ViewModelModule.Nested1_448e48a0) var1;
         return java.util.Objects.equals(this.I_field_90f29e07, other.I_field_90f29e07);
      }

      public ViewModelModule.Nested1_448e4880 I_method_8bb4aecb() {
         return this.I_field_90f29e07;
      }
   }
}
