package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

public class iiIIIIii_Class196 extends iI_Class3 {
   private static final int I_field_49 = 15728880;
   private static final float iI_field_46 = 32.0F;
   private static final float ii_field_46 = 28.0F;
   private static final float III_field_46 = 11.0F;
   private static final float IIi_field_46 = 16.0F;
   private static final int i_field_49 = 7;
   private static final float IiI_field_46 = 0.45F;
   private static final float Iii_field_46 = 0.5F;
   private static final int II_field_49 = 44;
   private static final float iII_field_46 = 6.0F;
   private static final float iIi_field_46 = 1.5F;
   private static final float iiI_field_46 = 0.5522848F;
   private static final float iii_field_46 = 0.56F;
   private static final float IIII_field_46 = -0.52F;
   private static final float IIIi_field_46 = -0.72F;
   private static final float[] I_field_b4b = new float[]{0.0F, 0.0F, 0.0F};
   private iiIIIIii_Class196.Nested1_1032e5d6 I_field_39e1ab71;
   private iiIIIIii_Class196.Nested1_f843b4f3 I_field_8e4119dc;
   private float IIiI_field_46;
   private float IIii_field_46;
   private float IiII_field_46;
   private float IiIi_field_46;
   private float IiiI_field_46;
   private boolean I_field_5a;
   private final ItemStack I_field_f2735522;
   private float[] i_field_b4b;
   private int Ii_field_49;
   private final IiiiIiIii_Class236 I_field_dc7facc;
   private final IiiiIiIii_Class236[] I_field_a8159991;
   private final IiiiIiIii_Class236[] i_field_a8159991;
   private final IiiiIiIii_Class236[] II_field_a8159991;
   private final IiiiIiIii_Class236[] Ii_field_a8159991;
   private float Iiii_field_46;
   private float iIII_field_46;
   private float iIIi_field_46;
   private boolean i_field_5a;
   private final IiiiIiIii_Class236 i_field_dc7facc;
   private float[] II_field_b4b;
   private final float[] Ii_field_b4b;
   private final float[] iI_field_b4b;
   private final float[] ii_field_b4b;
   private boolean II_field_5a;
   private float[] III_field_b4b;
   private float iIiI_field_46;
   private float iIii_field_46;
   private float iiII_field_46;
   private float iiIi_field_46;
   private boolean Ii_field_5a;
   private boolean iI_field_5a;
   private int iI_field_49;
   private double I_field_44;
   private double i_field_44;
   private float iiiI_field_46;
   private float iiii_field_46;
   private Vec2f I_field_5bba09cd;
   private final float[] IIi_field_b4b;
   private final float[] IiI_field_b4b;
   private final float[] Iii_field_b4b;
   private final Deque<float[]> I_field_db650847;
   private final Deque<float[]> i_field_db650847;
   private float[] iII_field_b4b;
   private final Matrix4f I_field_d754d74;
   private Vec2f i_field_5bba09cd;
   private final Vec2f[] I_field_c4e0be12;
   private final Vec2f[][] I_field_8090926d;
   private final float[] iIi_field_b4b;
   private final float[] iiI_field_b4b;
   private float IIIII_field_46;
   private final float[] iii_field_b4b;
   private final float[] IIII_field_b4b;
   private float IIIIi_field_46;
   private float IIIiI_field_46;
   private final IiiiIiIii_Class236 II_field_dc7facc;
   private static final ColorRGBA[] I_field_c75745ca = new ColorRGBA[]{ColorRGBA.RED, ColorRGBA.GREEN, ColorRGBA.BLUE};
   private static final float[] IIIi_field_b4b = new float[]{
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 2.0F
   };

   public iiIIIIii_Class196() {
      this.I_field_39e1ab71 = iiIIIIii_Class196.Nested1_1032e5d6.I_field_39e1ab71;
      this.I_field_8e4119dc = iiIIIIii_Class196.Nested1_f843b4f3.I_field_8e4119dc;
      this.IIiI_field_46 = 22.0F;
      this.IIii_field_46 = -12.0F;
      this.IiII_field_46 = 120.0F;
      this.I_field_5a = false;
      this.I_field_f2735522 = new ItemStack(Items.NETHERITE_SWORD);
      this.I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
      this.I_field_a8159991 = I_method_92a1e12f(180L);
      this.i_field_a8159991 = I_method_92a1e12f(220L);
      this.II_field_a8159991 = I_method_92a1e12f(180L);
      this.Ii_field_a8159991 = I_method_92a1e12f(220L);
      this.i_field_5a = false;
      this.i_field_dc7facc = new IiiiIiIii_Class236(260L, IiiiIiiII_Class237.III_field_dd60aac);
      this.Ii_field_b4b = new float[3];
      this.iI_field_b4b = new float[3];
      this.ii_field_b4b = new float[2];
      this.II_field_5a = false;
      this.Ii_field_5a = false;
      this.iI_field_5a = false;
      this.iI_field_49 = -1;
      this.I_field_5bba09cd = Vec2f.ZERO;
      this.IIi_field_b4b = new float[3];
      this.IiI_field_b4b = new float[3];
      this.Iii_field_b4b = new float[3];
      this.I_field_db650847 = new ArrayDeque<>();
      this.i_field_db650847 = new ArrayDeque<>();
      this.I_field_d754d74 = new Matrix4f();
      this.i_field_5bba09cd = Vec2f.ZERO;
      this.I_field_c4e0be12 = new Vec2f[]{Vec2f.ZERO, Vec2f.ZERO, Vec2f.ZERO};
      this.I_field_8090926d = new Vec2f[3][44];
      this.iIi_field_b4b = new float[3];
      this.iiI_field_b4b = new float[3];
      this.iii_field_b4b = new float[3];
      this.IIII_field_b4b = new float[3];
      this.II_field_dc7facc = new IiiiIiIii_Class236(180L, IiiiIiiII_Class237.III_field_dd60aac);
   }

   private static IiiiIiIii_Class236[] I_method_92a1e12f(long var0) {
      IiiiIiIii_Class236[] var2 = new IiiiIiIii_Class236[3];

      for (int var3 = 0; var3 < 3; var3++) {
         var2[var3] = new IiiiIiIii_Class236(var0, IiiiIiiII_Class237.III_field_dd60aac);
      }

      return var2;
   }

   private iiIIIIiI_Class195 I_method_9abdcfeb() {
      return this.I_field_39e1ab71 == iiIIIIii_Class196.Nested1_1032e5d6.i_field_39e1ab71
         ? RockstarClient.getInstance().I_method_11732eb().i_method_beb2642b()
         : RockstarClient.getInstance().I_method_11732eb().I_method_94b5d40b();
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   protected void i_method_bdd4e0ec(III var1) {
      if (!this.i_field_5a && I_field_3a9bda27.player != null) {
         this.i_method_cfabc8ac();
      }

      this.III_method_5f2025ec();
      this.Ii_method_2427dff5();
      if (this.II_field_5a) {
         this.i_field_dc7facc.I_method_edd72835(true);
         float var2 = this.i_field_dc7facc.I_method_6ac4da6f();
         this.Iiii_field_46 = this.Ii_field_b4b[0] + (this.iI_field_b4b[0] - this.Ii_field_b4b[0]) * var2;
         this.iIII_field_46 = this.Ii_field_b4b[1] + (this.iI_field_b4b[1] - this.Ii_field_b4b[1]) * var2;
         this.iIIi_field_46 = this.Ii_field_b4b[2] + (this.iI_field_b4b[2] - this.Ii_field_b4b[2]) * var2;
         this.IiIi_field_46 = this.ii_field_b4b[0] * (1.0F - var2);
         this.IiiI_field_46 = this.ii_field_b4b[1] * (1.0F - var2);
         if (var2 >= 1.0F) {
            this.II_field_5a = false;
            this.II_field_b4b = null;
         }
      }

      if (this.iI_field_5a && this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc) {
         float[] var5 = this.I_method_4d9ff62a(this.II_method_5f112f6c());
         this.Iiii_field_46 = this.IIi_field_b4b[0] - var5[0];
         this.iIII_field_46 = this.IIi_field_b4b[1] - var5[1];
         this.iIIi_field_46 = this.IIi_field_b4b[2] - var5[2];
      }

      this.I_field_dc7facc.I_method_edd72835(true);
      float var6 = Math.min(1.0F, this.I_field_dc7facc.I_method_6ac4da6f());
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var6);
      iIiiiIIiI_Class371.II_method_e18635ac(
         var1.getMatrices(),
         this.I_field_46 + this.II_field_46 / 2.0F,
         this.i_field_46 + this.Ii_field_46 / 2.0F,
         0.5F + this.I_field_dc7facc.I_method_6ac4da6f() * 0.5F
      );
      this.iI_method_d5910711(var1);
      this.ii_method_5b9aa731(var1);
      this.iIiI_field_46 = this.I_field_46;
      this.iIii_field_46 = this.i_field_46 + 32.0F;
      this.iiII_field_46 = this.II_field_46;
      this.iiIi_field_46 = this.Ii_field_46 - 32.0F - 28.0F;
      float var3 = this.iIiI_field_46 + this.iiII_field_46 / 2.0F;
      float var4 = this.iIii_field_46 + this.iiIi_field_46 / 2.0F;
      iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), this.iIiI_field_46, this.iIii_field_46, this.iiII_field_46, this.iiIi_field_46);
      if (I_field_3a9bda27.player != null) {
         this.I_method_3b0bcc5a(var1, var3, var4);
         if (this.I_field_39e1ab71 != iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71) {
            this.Ii_method_20704351(var1);
         }
      }

      iIiiiIiII_Class373.I_method_ff80a1df();
      this.III_method_c6cc2dba(var1);
      iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_3b0bcc5a(III var1, float var2, float var3) {
      float[] var4 = this.II_method_5f112f6c();
      float var5 = var4[0];
      float var6 = var4[1];
      float var7 = var4[2];
      float var8 = var4[3];
      float var9 = var4[4];
      float var10 = var4[5];
      float var11 = var4[6];
      float var12 = var4[7];
      float var13 = var4[8];
      MatrixStack var14 = var1.getMatrices();
      var14.push();
      var14.translate(var2 + this.IiIi_field_46, var3 + this.IiiI_field_46, 250.0F);
      var14.scale(this.IiII_field_46, -this.IiII_field_46, this.IiII_field_46);
      var14.multiply(new Quaternionf().rotateX((float)Math.toRadians(this.IIii_field_46)).rotateY((float)Math.toRadians(this.IIiI_field_46)));
      var14.translate(this.Iiii_field_46, this.iIII_field_46, this.iIIi_field_46);
      this.I_field_d754d74.set(var14.peek().getPositionMatrix());
      var14.translate(var5, var6, var7);
      var14.translate(var8, var9, var10);
      var14.multiply(new Quaternionf().rotationXYZ((float)Math.toRadians(var11), (float)Math.toRadians(var12), (float)Math.toRadians(var13)));
      var14.translate(-var5, -var6, -var7);
      var14.translate(0.56F, -0.52F, -0.72F);
      RenderSystem.enableBlend();
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(true);
      RenderSystem.disableCull();
      GL11.glClear(256);
      HeldItemRenderer var15 = I_field_3a9bda27.getEntityRenderDispatcher().getHeldItemRenderer();
      Immediate var16 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();

      try {
         var15.renderItem(I_field_3a9bda27.player, this.I_field_f2735522, ModelTransformationMode.FIRST_PERSON_RIGHT_HAND, false, var14, var16, 15728880);
         var16.draw();
      } catch (Exception var18) {
      }

      RenderSystem.enableCull();
      var14.pop();
   }

   @Compile(
      obfuscation = 1
   )
   private void Ii_method_20704351(III var1) {
      float[] var2 = this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.II_field_8e4119dc
         ? this.I_method_240a5d95()
         : this.I_method_4d9ff62a(this.II_method_5f112f6c());
      if (!this.iI_field_5a && !this.Ii_field_5a && !this.II_field_5a) {
         Vec2f var3 = this.I_method_e84db06b(var2[0], var2[1], var2[2]);
         if (var3.x < this.iIiI_field_46
            || var3.x > this.iIiI_field_46 + this.iiII_field_46
            || var3.y < this.iIii_field_46
            || var3.y > this.iIii_field_46 + this.iiIi_field_46) {
            this.II_method_24195415();
         }
      }

      this.i_field_5bba09cd = this.I_method_e84db06b(var2[0], var2[1], var2[2]);
      if (this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc) {
         for (int var6 = 0; var6 < 3; var6++) {
            this.I_field_8090926d[var6] = this.I_method_46aad539(var2[0], var2[1], var2[2], var6);
         }
      } else {
         this.I_field_c4e0be12[0] = this.I_method_e84db06b(var2[0] + 0.45F, var2[1], var2[2]);
         this.I_field_c4e0be12[1] = this.I_method_e84db06b(var2[0], var2[1] + 0.45F, var2[2]);
         this.I_field_c4e0be12[2] = this.I_method_e84db06b(var2[0], var2[1], var2[2] + 0.45F);
      }

      int var7 = this.iI_field_5a ? this.iI_field_49 : this.I_method_5d4d417f(var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
      if (var7 >= 0 || this.iI_field_5a) {
         iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
      }

      RenderSystem.disableDepthTest();
      iIiiiiIii_Class380.I_method_5f4b621f();
      if (this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc) {
         for (int var4 = 0; var4 < 3; var4++) {
            this.I_method_8c4da6c1(var1, var2, var4, I_field_c75745ca[var4].mulAlpha(var4 == var7 ? 1.0F : 0.6F));
         }
      } else {
         for (int var8 = 0; var8 < 3; var8++) {
            this.I_method_b46cad45(var1, this.i_field_5bba09cd, this.I_field_c4e0be12[var8], I_field_c75745ca[var8].mulAlpha(var8 == var7 ? 1.0F : 0.7F));
         }
      }

      boolean var9 = this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.II_field_8e4119dc;
      float var5 = var9 ? 2.5F : 1.5F;
      var1.drawRoundedRect(
         this.i_field_5bba09cd.x - var5,
         this.i_field_5bba09cd.y - var5,
         var5 * 2.0F,
         var5 * 2.0F,
         IIiii_Class8.I_method_893b2757(var5),
         (var9 ? IiiiiIIIi_Class242.i_method_5dfec6e() : IiiiiIIIi_Class242.Ii_field_d0c8ec5).mulAlpha(0.9F)
      );
      RenderSystem.enableDepthTest();
   }

   private void I_method_b46cad45(III var1, Vec2f var2, Vec2f var3, ColorRGBA var4) {
      this.i_method_a2680925(var1, var2, var3, var4);
      float var5 = (float)Math.atan2(var3.y - var2.y, var3.x - var2.x);
      float var6 = 4.0F;
      this.i_method_a2680925(var1, var3, new Vec2f(var3.x - var6 * (float)Math.cos(var5 - 0.42F), var3.y - var6 * (float)Math.sin(var5 - 0.42F)), var4);
      this.i_method_a2680925(var1, var3, new Vec2f(var3.x - var6 * (float)Math.cos(var5 + 0.42F), var3.y - var6 * (float)Math.sin(var5 + 0.42F)), var4);
   }

   private void i_method_a2680925(III var1, Vec2f var2, Vec2f var3, ColorRGBA var4) {
      float var5 = (var3.x - var2.x) / 3.0F;
      float var6 = (var3.y - var2.y) / 3.0F;
      this.I_method_ae0ff3a5(var1, var2, new Vec2f(var2.x + var5, var2.y + var6), new Vec2f(var2.x + 2.0F * var5, var2.y + 2.0F * var6), var3, var4);
   }

   private void I_method_ae0ff3a5(III var1, Vec2f var2, Vec2f var3, Vec2f var4, Vec2f var5, ColorRGBA var6) {
      float var7 = 3.5F;
      float var8 = Math.min(Math.min(var2.x, var3.x), Math.min(var4.x, var5.x)) - var7;
      float var9 = Math.min(Math.min(var2.y, var3.y), Math.min(var4.y, var5.y)) - var7;
      float var10 = Math.max(Math.max(var2.x, var3.x), Math.max(var4.x, var5.x)) + var7;
      float var11 = Math.max(Math.max(var2.y, var3.y), Math.max(var4.y, var5.y)) + var7;
      var1.drawSmoothBezier(var8, var9, var10 - var8, var11 - var9, var2, var3, var4, var5, 1.5F, var6);
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_8c4da6c1(III var1, float[] var2, int var3, ColorRGBA var4) {
      Vector3f var5 = I_method_bf79212(var3);
      Vector3f var6 = i_method_522aba32(var3);
      Vector3f var7 = new Vector3f(var2[0], var2[1], var2[2]);
      float var8 = 0.2761424F;

      for (int var9 = 0; var9 < 4; var9++) {
         double var10 = var9 * Math.PI / 2.0;
         double var12 = var10 + (Math.PI / 2);
         Vector3f var14 = I_method_377fa57a(var7, var5, var6, var10);
         Vector3f var15 = I_method_377fa57a(var7, var5, var6, var12);
         Vector3f var16 = I_method_db29516d(var5, var6, var10);
         Vector3f var17 = I_method_db29516d(var5, var6, var12);
         this.I_method_ae0ff3a5(
            var1,
            this.I_method_e84db06b(var14.x, var14.y, var14.z),
            this.I_method_e84db06b(var14.x + var16.x * var8, var14.y + var16.y * var8, var14.z + var16.z * var8),
            this.I_method_e84db06b(var15.x - var17.x * var8, var15.y - var17.y * var8, var15.z - var17.z * var8),
            this.I_method_e84db06b(var15.x, var15.y, var15.z),
            var4
         );
      }
   }

   private static Vector3f I_method_bf79212(int var0) {
      return var0 == 0 ? new Vector3f(0.0F, 1.0F, 0.0F) : (var0 == 1 ? new Vector3f(0.0F, 0.0F, 1.0F) : new Vector3f(1.0F, 0.0F, 0.0F));
   }

   private static Vector3f i_method_522aba32(int var0) {
      return var0 == 0 ? new Vector3f(0.0F, 0.0F, 1.0F) : (var0 == 1 ? new Vector3f(1.0F, 0.0F, 0.0F) : new Vector3f(0.0F, 1.0F, 0.0F));
   }

   private static Vector3f I_method_377fa57a(Vector3f var0, Vector3f var1, Vector3f var2, double var3) {
      float var5 = (float)Math.cos(var3) * 0.5F;
      float var6 = (float)Math.sin(var3) * 0.5F;
      return new Vector3f(var0.x + var1.x * var5 + var2.x * var6, var0.y + var1.y * var5 + var2.y * var6, var0.z + var1.z * var5 + var2.z * var6);
   }

   private static Vector3f I_method_db29516d(Vector3f var0, Vector3f var1, double var2) {
      float var4 = (float)Math.cos(var2);
      float var5 = (float)Math.sin(var2);
      return new Vector3f(-var0.x * var5 + var1.x * var4, -var0.y * var5 + var1.y * var4, -var0.z * var5 + var1.z * var4);
   }

   private Vec2f[] I_method_46aad539(float var1, float var2, float var3, int var4) {
      Vec2f[] var5 = new Vec2f[44];

      for (int var6 = 0; var6 < 44; var6++) {
         double var7 = (Math.PI * 2) * var6 / 44.0;
         float var9 = 0.5F * (float)Math.cos(var7);
         float var10 = 0.5F * (float)Math.sin(var7);
         float var11;
         float var12;
         float var13;
         switch (var4) {
            case 0:
               var11 = 0.0F;
               var12 = var9;
               var13 = var10;
               break;
            case 1:
               var11 = var10;
               var12 = 0.0F;
               var13 = var9;
               break;
            default:
               var11 = var9;
               var12 = var10;
               var13 = 0.0F;
         }

         var5[var6] = this.I_method_e84db06b(var1 + var11, var2 + var12, var3 + var13);
      }

      return var5;
   }

   private Vec2f I_method_e84db06b(float var1, float var2, float var3) {
      Vector4f var4 = new Vector4f(var1, var2, var3, 1.0F);
      this.I_field_d754d74.transform(var4);
      return new Vec2f(var4.x, var4.y);
   }

   private float[] I_method_240a5d95() {
      float[] var1 = this.II_method_5f112f6c();
      return new float[]{var1[0] + var1[3], var1[1] + var1[4], var1[2] + var1[5]};
   }

   private float[] I_method_4d9ff62a(float[] var1) {
      float[] var2 = this.i_method_25cd4db5();
      Vector3f var3 = new Vector3f(0.56F + var2[0] - var1[0], -0.52F + var2[1] - var1[1], -0.72F + var2[2] - var1[2]);
      new Quaternionf().rotationXYZ((float)Math.toRadians(var1[6]), (float)Math.toRadians(var1[7]), (float)Math.toRadians(var1[8])).transform(var3);
      return new float[]{var1[0] + var1[3] + var3.x, var1[1] + var1[4] + var3.y, var1[2] + var1[5] + var3.z};
   }

   private float[] i_method_25cd4db5() {
      if (this.i_field_b4b != null) {
         return this.i_field_b4b;
      } else if (I_field_3a9bda27.player == null) {
         return I_field_b4b;
      } else {
         iiIIIIii_Class196.Nested1_f843b4d3 var1 = new iiIIIIii_Class196.Nested1_f843b4d3();

         try {
            I_field_3a9bda27.getEntityRenderDispatcher()
               .getHeldItemRenderer()
               .renderItem(
                  I_field_3a9bda27.player,
                  this.I_field_f2735522,
                  ModelTransformationMode.FIRST_PERSON_RIGHT_HAND,
                  false,
                  new MatrixStack(),
                  var1x -> var1,
                  15728880
               );
         } catch (Exception var3) {
         }

         this.i_field_b4b = var1.I_method_4805fefa();
         if (this.i_field_b4b == null && ++this.Ii_field_49 > 20) {
            this.i_field_b4b = I_field_b4b;
         }

         return this.i_field_b4b != null ? this.i_field_b4b : I_field_b4b;
      }
   }

   private float[] I_method_eeb3cb14(iiIIIIiI_Class195 var1) {
      float[] var2 = this.i_method_8bccd334(var1);
      float[] var3 = this.I_method_4d9ff62a(var2);
      return this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.II_field_8e4119dc
            && this.I_field_39e1ab71 != iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71
         ? new float[]{-(var3[0] + var2[0] + var2[3]) / 2.0F, -(var3[1] + var2[1] + var2[4]) / 2.0F, -(var3[2] + var2[2] + var2[5]) / 2.0F}
         : new float[]{-var3[0], -var3[1], -var3[2]};
   }

   private float[] i_method_8bccd334(iiIIIIiI_Class195 var1) {
      return new float[]{
         var1.I_method_2db787a2().Ii_method_a20abcd2(),
         var1.i_method_434cfb82().Ii_method_a20abcd2(),
         var1.II_method_8ae3216b().Ii_method_a20abcd2(),
         var1.Ii_method_a078954b().Ii_method_a20abcd2(),
         var1.iI_method_27fc298b().Ii_method_a20abcd2(),
         var1.ii_method_3d919d6b().Ii_method_a20abcd2(),
         var1.III_method_d32ac0c2().Ii_method_a20abcd2(),
         var1.IIi_method_e8c034a2().Ii_method_a20abcd2(),
         var1.IiI_method_7043c8e2().Ii_method_a20abcd2()
      };
   }

   private void i_method_cfabc8ac() {
      float[] var1 = this.I_method_eeb3cb14(this.I_method_9abdcfeb());
      this.Iiii_field_46 = var1[0];
      this.iIII_field_46 = var1[1];
      this.iIIi_field_46 = var1[2];
      this.IiIi_field_46 = this.IiiI_field_46 = 0.0F;
      this.i_field_5a = this.i_field_b4b != null;
      this.II_field_5a = false;
   }

   private void I_method_882fe55f(iiIIIIii_Class196.Nested1_1032e5d6 var1) {
      float[] var2 = this.II_method_5f112f6c();
      this.I_field_39e1ab71 = var1;
      this.II_method_24195415();
      this.II_field_b4b = var2;
   }

   private void II_method_24195415() {
      this.Ii_field_b4b[0] = this.Iiii_field_46;
      this.Ii_field_b4b[1] = this.iIII_field_46;
      this.Ii_field_b4b[2] = this.iIIi_field_46;
      float[] var1 = this.I_method_eeb3cb14(this.I_method_9abdcfeb());
      this.iI_field_b4b[0] = var1[0];
      this.iI_field_b4b[1] = var1[1];
      this.iI_field_b4b[2] = var1[2];
      this.ii_field_b4b[0] = this.IiIi_field_46;
      this.ii_field_b4b[1] = this.IiiI_field_46;
      this.II_field_b4b = null;
      this.i_field_5a = true;
      this.II_field_5a = true;
      this.i_field_dc7facc.I_method_edd6dd21(0.0F);
   }

   private void Ii_method_2427dff5() {
      float[] var1 = this.i_method_8bccd334(this.I_method_9abdcfeb());
      boolean var2 = this.III_field_b4b != null && !Arrays.equals(var1, this.III_field_b4b);
      this.III_field_b4b = var1;
      if (var2 && !this.iI_field_5a && !this.II_field_5a && this.I_field_39e1ab71 != iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71) {
         this.II_method_24195415();
      }
   }

   private float[] II_method_5f112f6c() {
      if (this.I_field_39e1ab71 == iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71) {
         iiIIIiIi_Class198 var5 = RockstarClient.getInstance().I_method_11732eb().I_method_417b4cc3(this.iI_method_25dc4425());
         return new float[]{
            var5.I_method_2efb707c(),
            var5.i_method_2f09fc5c(),
            var5.II_method_b0819845(),
            var5.Ii_method_b0902425(),
            var5.iI_method_b2448865(),
            var5.ii_method_b2531445(),
            var5.III_method_5fc0699c(),
            var5.IIi_method_5fcef57c(),
            var5.IiI_method_618359bc()
         };
      } else {
         float[] var1 = this.i_method_8bccd334(this.I_method_9abdcfeb());
         if (this.II_field_5a && this.II_field_b4b != null) {
            float var2 = this.i_field_dc7facc.I_method_6ac4da6f();
            float[] var3 = new float[9];

            for (int var4 = 0; var4 < 9; var4++) {
               var3[var4] = this.II_field_b4b[var4] + (var1[var4] - this.II_field_b4b[var4]) * var2;
            }

            return var3;
         } else {
            return var1;
         }
      }
   }

   private float iI_method_25dc4425() {
      float var1 = RockstarClient.getInstance().I_method_11732eb().I_method_78c80362().Ii_method_a20abcd2();
      long var2 = (long)Math.max(100.0F, 300.0F * var1);
      long var4 = 500L;
      long var6 = System.currentTimeMillis() % (var2 + var4);
      return var6 >= var2 ? 0.0F : (float)var6 / (float)var2;
   }

   private void iI_method_d5910711(III var1) {
      var1.drawShadow(
         this.I_field_46,
         this.i_field_46,
         this.II_field_46,
         this.Ii_field_46,
         25.0F,
         IIiii_Class8.I_method_893b2757(11.0F),
         IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F)
      );
      var1.drawBlurredRect(
         this.I_field_46,
         this.i_field_46,
         this.II_field_46,
         this.Ii_field_46,
         5.0F,
         3.0F,
         IIiii_Class8.I_method_893b2757(11.0F),
         IiiiiIIIi_Class242.Ii_field_d0c8ec5
      );
      var1.drawSquircle(
         this.I_field_46,
         this.i_field_46,
         this.II_field_46,
         this.Ii_field_46,
         3.0F,
         IIiii_Class8.I_method_893b2757(11.0F),
         IiiiiIIIi_Class242.III_field_d0c8ec5
      );
      var1.drawSquircleBorder(
         this.I_field_46,
         this.i_field_46,
         this.II_field_46,
         this.Ii_field_46,
         0.5F,
         3.0F,
         IIiii_Class8.I_method_893b2757(11.0F),
         IiiiiIIIi_Class242.IiI_field_d0c8ec5
      );
   }

   @Compile(
      obfuscation = 1
   )
   private void ii_method_5b9aa731(III var1) {
      var1.drawText(
         IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(7.0F),
         IiIiIIII_Class81.I_method_f25a980a("swing.editor"),
         this.I_field_46 + 9.0F,
         this.i_field_46 + 8.5F,
         IiiiiIIIi_Class242.iI_method_8e08d3b1()
      );
      String[] var2 = new String[]{
         IiIiIIII_Class81.I_method_f25a980a("swing.start"),
         IiIiIIII_Class81.I_method_f25a980a("swing.end"),
         IiIiIIII_Class81.I_method_f25a980a("swing.preview")
      };
      iiIIIIii_Class196.Nested1_1032e5d6[] var3 = new iiIIIIii_Class196.Nested1_1032e5d6[]{
         iiIIIIii_Class196.Nested1_1032e5d6.I_field_39e1ab71,
         iiIIIIii_Class196.Nested1_1032e5d6.i_field_39e1ab71,
         iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71
      };
      float[] var4 = new float[3];
      float var5 = -8.0F;

      for (int var6 = 0; var6 < 3; var6++) {
         var4[var6] = IIiIiI_Class11.II_field_857c0621.I_method_c000b13a(var2[var6], 7.0F);
         var5 += var4[var6] + 8.0F;
      }

      float var11 = this.I_field_46 + this.II_field_46 / 2.0F - var5 / 2.0F;
      this.IIIII_field_46 = this.i_field_46 + 20.0F;

      for (int var7 = 0; var7 < 3; var7++) {
         boolean var8 = this.I_field_39e1ab71 == var3[var7];
         boolean var9 = iIIiIIIiI_Class291.I_method_c3fabb03(
            var11 - 4.0F, this.IIIII_field_46, var4[var7] + 8.0F, 11.0, var1.I_method_b1c3e152(), var1.i_method_b1d26d32()
         );
         this.I_field_a8159991[var7].I_method_edd72835(var9);
         this.i_field_a8159991[var7].I_method_edd72835(var8);
         ColorRGBA var10 = IiiiiIIIi_Class242.iI_method_8e08d3b1()
            .mulAlpha(0.45F + 0.35F * this.I_field_a8159991[var7].I_method_6ac4da6f())
            .mix(IiiiiIIIi_Class242.i_method_5dfec6e(), this.i_field_a8159991[var7].I_method_6ac4da6f());
         var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), var2[var7], var11, this.IIIII_field_46, var10);
         if (var9) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
         }

         this.iIi_field_b4b[var7] = var11 - 4.0F;
         this.iiI_field_b4b[var7] = var4[var7] + 8.0F;
         var11 += var4[var7] + 8.0F;
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void III_method_c6cc2dba(III var1) {
      float var2 = 6.0F;
      float var3 = 9.0F;
      this.IIIIi_field_46 = this.i_field_46 + this.Ii_field_46 - 28.0F + 2.0F;
      this.IIIiI_field_46 = this.I_field_46 + this.II_field_46 - 9.0F - 16.0F;
      boolean var4 = iIIiIIIiI_Class291.I_method_c3fabb03(
         this.IIIiI_field_46, this.IIIIi_field_46, 16.0, 16.0, var1.I_method_b1c3e152(), var1.i_method_b1d26d32()
      );
      this.II_field_dc7facc.I_method_edd72835(var4);
      ColorRGBA var5 = IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.5F + 0.4F * this.II_field_dc7facc.I_method_6ac4da6f());
      if (IIiiII_Class13.I_method_e72fe13a("clean")) {
         var1.drawIcon("clean", this.IIIiI_field_46 + (16.0F - var3) / 2.0F, this.IIIIi_field_46 + (16.0F - var3) / 2.0F, var3, var5);
      } else {
         var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), "C", this.IIIiI_field_46 + 8.0F - 2.0F, this.IIIIi_field_46 + 8.0F - 3.0F, var5);
      }

      if (var4) {
         iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
      }

      if (this.I_field_39e1ab71 != iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71) {
         String[] var6 = new String[]{"swing/position", "swing/rotation", "swing/anchor"};
         String[] var7 = new String[]{"M", "R", "P"};
         iiIIIIii_Class196.Nested1_f843b4f3[] var8 = new iiIIIIii_Class196.Nested1_f843b4f3[]{
            iiIIIIii_Class196.Nested1_f843b4f3.I_field_8e4119dc,
            iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc,
            iiIIIIii_Class196.Nested1_f843b4f3.II_field_8e4119dc
         };
         float var9 = 48.0F + 2.0F * var2;
         float var10 = this.I_field_46 + this.II_field_46 / 2.0F - var9 / 2.0F;

         for (int var11 = 0; var11 < 3; var11++) {
            boolean var12 = this.I_field_8e4119dc == var8[var11];
            boolean var13 = iIIiIIIiI_Class291.I_method_c3fabb03(var10, this.IIIIi_field_46, 16.0, 16.0, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
            this.II_field_a8159991[var11].I_method_edd72835(var13);
            this.Ii_field_a8159991[var11].I_method_edd72835(var12);
            ColorRGBA var14 = IiiiiIIIi_Class242.iI_method_8e08d3b1()
               .mulAlpha(0.5F + 0.4F * this.II_field_a8159991[var11].I_method_6ac4da6f())
               .mix(IiiiiIIIi_Class242.i_method_5dfec6e(), this.Ii_field_a8159991[var11].I_method_6ac4da6f());
            if (IIiiII_Class13.I_method_e72fe13a(var6[var11])) {
               var1.drawIcon(var6[var11], var10 + (16.0F - var3) / 2.0F, this.IIIIi_field_46 + (16.0F - var3) / 2.0F, var3, var14);
            } else {
               var1.drawText(
                  IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), var7[var11], var10 + 8.0F - 2.0F, this.IIIIi_field_46 + 8.0F - 3.0F, var14
               );
            }

            if (var13) {
               iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }

            this.iii_field_b4b[var11] = var10;
            this.IIII_field_b4b[var11] = 16.0F;
            var10 += 16.0F + var2;
         }
      }
   }

   private int I_method_5d4d417f(double var1, double var3) {
      int var5 = -1;
      float var6 = 6.0F;
      if (this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc) {
         for (int var7 = 0; var7 < 3; var7++) {
            for (Vec2f var11 : this.I_field_8090926d[var7]) {
               float var12 = I_method_3f10067c(var1, var3, var11.x, var11.y);
               if (var12 < var6) {
                  var6 = var12;
                  var5 = var7;
               }
            }
         }
      } else {
         for (int var13 = 0; var13 < 3; var13++) {
            float var14 = I_method_50f5bbdc((float)var1, (float)var3, this.i_field_5bba09cd, this.I_field_c4e0be12[var13]);
            if (var14 < var6) {
               var6 = var14;
               var5 = var13;
            }
         }
      }

      return var5;
   }

   private boolean i_method_93e85570(double var1, double var3) {
      return iIIiIIIiI_Class291.I_method_c3f86263(this.I_field_46, this.i_field_46 + 32.0F, this.II_field_46, this.Ii_field_46 - 32.0F - 28.0F, var1, var3);
   }

   private boolean I_method_cf9d3cd0() {
      return GLFW.glfwGetKey(I_field_3a9bda27.getWindow().getHandle(), 32) == 1;
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   public void I_method_400ceaa7(double var1, double var3, IiIII_Class9 var5) {
      if ((var5 == IiIII_Class9.II_field_2f4c8d6c || var5 == IiIII_Class9.I_field_2f4c8d6c && this.I_method_cf9d3cd0()) && this.i_method_93e85570(var1, var3)) {
         this.I_field_5a = true;
      } else if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
         iiIIIIii_Class196.Nested1_1032e5d6[] var6 = new iiIIIIii_Class196.Nested1_1032e5d6[]{
            iiIIIIii_Class196.Nested1_1032e5d6.I_field_39e1ab71,
            iiIIIIii_Class196.Nested1_1032e5d6.i_field_39e1ab71,
            iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71
         };

         for (int var7 = 0; var7 < 3; var7++) {
            if (iIIiIIIiI_Class291.I_method_c3f86263(this.iIi_field_b4b[var7], this.IIIII_field_46, this.iiI_field_b4b[var7], 11.0, var1, var3)) {
               if (var6[var7] != this.I_field_39e1ab71) {
                  if (var6[var7] == iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71) {
                     this.I_field_39e1ab71 = iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71;
                     this.II_method_24195415();
                  } else {
                     this.I_method_882fe55f(var6[var7]);
                  }
               }

               return;
            }
         }

         if (iIIiIIIiI_Class291.I_method_c3f86263(this.IIIiI_field_46, this.IIIIi_field_46, 16.0, 16.0, var1, var3)) {
            this.ii_method_25ead015();
         } else {
            if (this.I_field_39e1ab71 != iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71) {
               iiIIIIii_Class196.Nested1_f843b4f3[] var10 = new iiIIIIii_Class196.Nested1_f843b4f3[]{
                  iiIIIIii_Class196.Nested1_f843b4f3.I_field_8e4119dc,
                  iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc,
                  iiIIIIii_Class196.Nested1_f843b4f3.II_field_8e4119dc
               };

               for (int var8 = 0; var8 < 3; var8++) {
                  if (iIIiIIIiI_Class291.I_method_c3f86263(this.iii_field_b4b[var8], this.IIIIi_field_46, this.IIII_field_b4b[var8], 16.0, var1, var3)) {
                     this.I_method_1d392b28(var10[var8]);
                     return;
                  }
               }
            }

            if (this.i_method_93e85570(var1, var3)) {
               int var11 = this.I_field_39e1ab71 == iiIIIIii_Class196.Nested1_1032e5d6.II_field_39e1ab71 ? -1 : this.I_method_5d4d417f(var1, var3);
               if (var11 >= 0) {
                  this.iI_field_5a = true;
                  this.II_field_5a = false;
                  this.iI_field_49 = var11;
                  this.I_field_44 = var1;
                  this.i_field_44 = var3;
                  this.iiiI_field_46 = this.I_method_240acfa7(var11);
                  iiIIIIiI_Class195 var12 = this.I_method_9abdcfeb();
                  this.IiI_field_b4b[0] = var12.I_method_2db787a2().Ii_method_a20abcd2();
                  this.IiI_field_b4b[1] = var12.i_method_434cfb82().Ii_method_a20abcd2();
                  this.IiI_field_b4b[2] = var12.II_method_8ae3216b().Ii_method_a20abcd2();
                  this.Iii_field_b4b[0] = var12.Ii_method_a078954b().Ii_method_a20abcd2();
                  this.Iii_field_b4b[1] = var12.iI_method_27fc298b().Ii_method_a20abcd2();
                  this.Iii_field_b4b[2] = var12.ii_method_3d919d6b().Ii_method_a20abcd2();
                  if (this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc) {
                     this.I_field_5bba09cd = this.i_field_5bba09cd;
                     this.iiii_field_46 = (float)Math.atan2(var3 - this.I_field_5bba09cd.y, var1 - this.I_field_5bba09cd.x);
                     float[] var9 = this.I_method_4d9ff62a(this.II_method_5f112f6c());
                     this.IIi_field_b4b[0] = this.Iiii_field_46 + var9[0];
                     this.IIi_field_b4b[1] = this.iIII_field_46 + var9[1];
                     this.IIi_field_b4b[2] = this.iIIi_field_46 + var9[2];
                  }
               } else {
                  this.Ii_field_5a = true;
               }
            }
         }
      }
   }

   @Override
   public void i_method_6a097ac7(double var1, double var3, IiIII_Class9 var5) {
      this.iI_field_5a = false;
      this.Ii_field_5a = false;
      this.I_field_5a = false;
      this.iI_field_49 = -1;
   }

   public void I_method_19999dda(double var1, double var3, IiIII_Class9 var5, double var6, double var8) {
      if (this.I_field_5a) {
         this.IiIi_field_46 += (float)var6;
         this.IiiI_field_46 += (float)var8;
      } else if (this.Ii_field_5a) {
         this.IIiI_field_46 += (float)var6 * 0.6F;
         this.IIii_field_46 = MathHelper.clamp(this.IIii_field_46 + (float)var8 * 0.6F, -89.0F, 89.0F);
      } else if (this.iI_field_5a && this.iI_field_49 >= 0) {
         if (this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc) {
            float var10 = (float)Math.atan2(var3 - this.I_field_5bba09cd.y, var1 - this.I_field_5bba09cd.x);
            float var11 = (float)Math.toDegrees(I_method_240ac464(var10 - this.iiii_field_46));
            this.i_method_93eaa2c9(this.iI_field_49, this.iiiI_field_46 + var11);
         } else {
            Vec2f var14 = new Vec2f(
               this.I_field_c4e0be12[this.iI_field_49].x - this.i_field_5bba09cd.x, this.I_field_c4e0be12[this.iI_field_49].y - this.i_field_5bba09cd.y
            );
            float var15 = (float)Math.sqrt(var14.x * var14.x + var14.y * var14.y);
            if (var15 < 0.001F) {
               return;
            }

            float var12 = (float)((var1 - this.I_field_44) * var14.x + (var3 - this.i_field_44) * var14.y) / var15;
            float var13 = var12 * (0.45F / var15);
            if (this.I_field_8e4119dc == iiIIIIii_Class196.Nested1_f843b4f3.I_field_8e4119dc) {
               this.i_method_93eaa2c9(this.iI_field_49, this.iiiI_field_46 + var13);
            } else {
               this.I_method_5d4f8ee9(this.iI_field_49, var13);
            }
         }

         this.iI_method_25dc4435();
      }
   }

   private void I_method_5d4f8ee9(int var1, float var2) {
      iiIIIIiI_Class195 var3 = this.I_method_9abdcfeb();
      Quaternionf var4 = new Quaternionf()
         .rotationXYZ(
            (float)Math.toRadians(var3.III_method_d32ac0c2().Ii_method_a20abcd2()),
            (float)Math.toRadians(var3.IIi_method_e8c034a2().Ii_method_a20abcd2()),
            (float)Math.toRadians(var3.IiI_method_7043c8e2().Ii_method_a20abcd2())
         )
         .conjugate();
      Vector3f var5 = new Vector3f();
      if (var1 == 0) {
         var5.x = var2;
      } else if (var1 == 1) {
         var5.y = var2;
      } else {
         var5.z = var2;
      }

      Vector3f var6 = var4.transform(new Vector3f(var5));
      var3.I_method_2db787a2().I_method_a1eda161(this.IiI_field_b4b[0] + var6.x);
      var3.i_method_434cfb82().I_method_a1eda161(this.IiI_field_b4b[1] + var6.y);
      var3.II_method_8ae3216b().I_method_a1eda161(this.IiI_field_b4b[2] + var6.z);
      var3.Ii_method_a078954b().I_method_a1eda161(this.Iii_field_b4b[0] + (var5.x - var6.x));
      var3.iI_method_27fc298b().I_method_a1eda161(this.Iii_field_b4b[1] + (var5.y - var6.y));
      var3.ii_method_3d919d6b().I_method_a1eda161(this.Iii_field_b4b[2] + (var5.z - var6.z));
   }

   private void iI_method_25dc4435() {
      if (Screen.hasShiftDown() || Screen.hasControlDown()) {
         iiIIIIiI_Class195 var1 = this.I_method_9abdcfeb();
         iiIIIIiI_Class195 var2 = this.I_field_39e1ab71 == iiIIIIii_Class196.Nested1_1032e5d6.i_field_39e1ab71
            ? RockstarClient.getInstance().I_method_11732eb().I_method_94b5d40b()
            : RockstarClient.getInstance().I_method_11732eb().i_method_beb2642b();
         switch (this.I_field_8e4119dc) {
            case I_field_8e4119dc:
               var2.Ii_method_a078954b().I_method_a1eda161(var1.Ii_method_a078954b().Ii_method_a20abcd2());
               var2.iI_method_27fc298b().I_method_a1eda161(var1.iI_method_27fc298b().Ii_method_a20abcd2());
               var2.ii_method_3d919d6b().I_method_a1eda161(var1.ii_method_3d919d6b().Ii_method_a20abcd2());
               break;
            case i_field_8e4119dc:
               var2.III_method_d32ac0c2().I_method_a1eda161(var1.III_method_d32ac0c2().Ii_method_a20abcd2());
               var2.IIi_method_e8c034a2().I_method_a1eda161(var1.IIi_method_e8c034a2().Ii_method_a20abcd2());
               var2.IiI_method_7043c8e2().I_method_a1eda161(var1.IiI_method_7043c8e2().Ii_method_a20abcd2());
               break;
            case II_field_8e4119dc:
               var2.I_method_2db787a2().I_method_a1eda161(var1.I_method_2db787a2().Ii_method_a20abcd2());
               var2.i_method_434cfb82().I_method_a1eda161(var1.i_method_434cfb82().Ii_method_a20abcd2());
               var2.II_method_8ae3216b().I_method_a1eda161(var1.II_method_8ae3216b().Ii_method_a20abcd2());
               var2.Ii_method_a078954b().I_method_a1eda161(var1.Ii_method_a078954b().Ii_method_a20abcd2());
               var2.iI_method_27fc298b().I_method_a1eda161(var1.iI_method_27fc298b().Ii_method_a20abcd2());
               var2.ii_method_3d919d6b().I_method_a1eda161(var1.ii_method_3d919d6b().Ii_method_a20abcd2());
         }
      }
   }

   @Override
   public void I_method_6b0ad25f(double var1, double var3, double var5, double var7) {
      if (this.i_method_93e85570(var1, var3)) {
         float var9 = MathHelper.clamp(this.IiII_field_46 * (1.0F + (float)var7 * 0.1F), 30.0F, 280.0F);
         float var10 = this.IiII_field_46 == 0.0F ? 1.0F : var9 / this.IiII_field_46;
         float var11 = this.iIiI_field_46 + this.iiII_field_46 / 2.0F + this.IiIi_field_46;
         float var12 = this.iIii_field_46 + this.iiIi_field_46 / 2.0F + this.IiiI_field_46;
         this.IiIi_field_46 += ((float)var1 - var11) * (1.0F - var10);
         this.IiiI_field_46 += ((float)var3 - var12) * (1.0F - var10);
         this.IiII_field_46 = var9;
      }
   }

   @Override
   public void I_method_c1acbc24(int var1, int var2, int var3) {
      if (Screen.hasControlDown()) {
         if (var1 == 90) {
            this.IIi_method_5f2eb1cc();
         } else if (var1 == 89) {
            this.IiI_method_60e3160c();
         }
      } else {
         switch (var1) {
            case 70:
               this.i_method_cfabc8ac();
               break;
            case 71:
               this.I_method_1d392b28(iiIIIIii_Class196.Nested1_f843b4f3.I_field_8e4119dc);
               break;
            case 82:
               this.I_method_1d392b28(iiIIIIii_Class196.Nested1_f843b4f3.i_field_8e4119dc);
               break;
            case 84:
               this.I_method_1d392b28(iiIIIIii_Class196.Nested1_f843b4f3.II_field_8e4119dc);
         }
      }
   }

   private void I_method_1d392b28(iiIIIIii_Class196.Nested1_f843b4f3 var1) {
      if (this.I_field_8e4119dc != var1) {
         this.I_field_8e4119dc = var1;
         this.II_method_24195415();
      }
   }

   private SliderSetting I_method_82e4f6ad(int var1) {
      iiIIIIiI_Class195 var2 = this.I_method_9abdcfeb();

      return switch (this.I_field_8e4119dc) {
         case I_field_8e4119dc -> var1 == 0 ? var2.Ii_method_a078954b() : (var1 == 1 ? var2.iI_method_27fc298b() : var2.ii_method_3d919d6b());
         case i_field_8e4119dc -> var1 == 0 ? var2.III_method_d32ac0c2() : (var1 == 1 ? var2.IIi_method_e8c034a2() : var2.IiI_method_7043c8e2());
         case II_field_8e4119dc -> var1 == 0 ? var2.I_method_2db787a2() : (var1 == 1 ? var2.i_method_434cfb82() : var2.II_method_8ae3216b());
      };
   }

   private float I_method_240acfa7(int var1) {
      return this.I_method_82e4f6ad(var1).Ii_method_a20abcd2();
   }

   private void i_method_93eaa2c9(int var1, float var2) {
      this.I_method_82e4f6ad(var1).I_method_a1eda161(var2);
   }

   private void ii_method_25ead015() {
      this.I_method_5d57bd97(IIIi_field_b4b);
   }

   private float[] Ii_method_60d41f8c() {
      iiIIIIIi_Class194 var1 = RockstarClient.getInstance().I_method_11732eb();
      iiIIIIiI_Class195 var2 = var1.I_method_94b5d40b();
      iiIIIIiI_Class195 var3 = var1.i_method_beb2642b();
      Vec2f var4 = var1.I_method_bfd0c322().I_method_7430e9b6();
      Vec2f var5 = var1.I_method_bfd0c322().i_method_18296d96();
      return new float[]{
         var2.I_method_2db787a2().Ii_method_a20abcd2(),
         var2.i_method_434cfb82().Ii_method_a20abcd2(),
         var2.II_method_8ae3216b().Ii_method_a20abcd2(),
         var2.Ii_method_a078954b().Ii_method_a20abcd2(),
         var2.iI_method_27fc298b().Ii_method_a20abcd2(),
         var2.ii_method_3d919d6b().Ii_method_a20abcd2(),
         var2.III_method_d32ac0c2().Ii_method_a20abcd2(),
         var2.IIi_method_e8c034a2().Ii_method_a20abcd2(),
         var2.IiI_method_7043c8e2().Ii_method_a20abcd2(),
         var3.I_method_2db787a2().Ii_method_a20abcd2(),
         var3.i_method_434cfb82().Ii_method_a20abcd2(),
         var3.II_method_8ae3216b().Ii_method_a20abcd2(),
         var3.Ii_method_a078954b().Ii_method_a20abcd2(),
         var3.iI_method_27fc298b().Ii_method_a20abcd2(),
         var3.ii_method_3d919d6b().Ii_method_a20abcd2(),
         var3.III_method_d32ac0c2().Ii_method_a20abcd2(),
         var3.IIi_method_e8c034a2().Ii_method_a20abcd2(),
         var3.IiI_method_7043c8e2().Ii_method_a20abcd2(),
         var4.x,
         var4.y,
         var5.x,
         var5.y,
         var1.I_method_bfd13f22().i_method_9b12da03() ? 1.0F : 0.0F,
         var1.I_method_78c80362().Ii_method_a20abcd2()
      };
   }

   private void I_method_5d57bd97(float[] var1) {
      iiIIIIIi_Class194 var2 = RockstarClient.getInstance().I_method_11732eb();
      iiIIIIiI_Class195 var3 = var2.I_method_94b5d40b();
      iiIIIIiI_Class195 var4 = var2.i_method_beb2642b();
      var3.I_method_2db787a2().I_method_a1eda161(var1[0]);
      var3.i_method_434cfb82().I_method_a1eda161(var1[1]);
      var3.II_method_8ae3216b().I_method_a1eda161(var1[2]);
      var3.Ii_method_a078954b().I_method_a1eda161(var1[3]);
      var3.iI_method_27fc298b().I_method_a1eda161(var1[4]);
      var3.ii_method_3d919d6b().I_method_a1eda161(var1[5]);
      var3.III_method_d32ac0c2().I_method_a1eda161(var1[6]);
      var3.IIi_method_e8c034a2().I_method_a1eda161(var1[7]);
      var3.IiI_method_7043c8e2().I_method_a1eda161(var1[8]);
      var4.I_method_2db787a2().I_method_a1eda161(var1[9]);
      var4.i_method_434cfb82().I_method_a1eda161(var1[10]);
      var4.II_method_8ae3216b().I_method_a1eda161(var1[11]);
      var4.Ii_method_a078954b().I_method_a1eda161(var1[12]);
      var4.iI_method_27fc298b().I_method_a1eda161(var1[13]);
      var4.ii_method_3d919d6b().I_method_a1eda161(var1[14]);
      var4.III_method_d32ac0c2().I_method_a1eda161(var1[15]);
      var4.IIi_method_e8c034a2().I_method_a1eda161(var1[16]);
      var4.IiI_method_7043c8e2().I_method_a1eda161(var1[17]);
      var2.I_method_bfd0c322().I_method_f4aeac5e(new Vec2f(var1[18], var1[19])).i_method_4362bc7e(new Vec2f(var1[20], var1[21]));
      var2.I_method_bfd13f22().I_method_a4d009eb(var1[22] != 0.0F);
      var2.I_method_78c80362().I_method_a1eda161(var1[23]);
   }

   private void III_method_5f2025ec() {
      float[] var1 = this.Ii_method_60d41f8c();
      if (this.iII_field_b4b == null) {
         this.iII_field_b4b = var1;
      } else if (!this.i_method_cfabc8b0()) {
         if (!Arrays.equals(var1, this.iII_field_b4b)) {
            this.I_field_db650847.push(this.iII_field_b4b);
            this.i_field_db650847.clear();
            this.iII_field_b4b = var1;
         }
      }
   }

   private boolean i_method_cfabc8b0() {
      long var1 = I_field_3a9bda27.getWindow().getHandle();
      return GLFW.glfwGetMouseButton(var1, 0) == 1 || GLFW.glfwGetMouseButton(var1, 1) == 1 || GLFW.glfwGetMouseButton(var1, 2) == 1;
   }

   private void IIi_method_5f2eb1cc() {
      if (!this.I_field_db650847.isEmpty()) {
         this.i_field_db650847.push(this.Ii_method_60d41f8c());
         this.I_method_5d57bd97(this.I_field_db650847.pop());
         this.iII_field_b4b = this.Ii_method_60d41f8c();
      }
   }

   private void IiI_method_60e3160c() {
      if (!this.i_field_db650847.isEmpty()) {
         this.I_field_db650847.push(this.Ii_method_60d41f8c());
         this.I_method_5d57bd97(this.i_field_db650847.pop());
         this.iII_field_b4b = this.Ii_method_60d41f8c();
      }
   }

   private static float I_method_3f10067c(double var0, double var2, float var4, float var5) {
      double var6 = var0 - var4;
      double var8 = var2 - var5;
      return (float)Math.sqrt(var6 * var6 + var8 * var8);
   }

   private static float I_method_50f5bbdc(float var0, float var1, Vec2f var2, Vec2f var3) {
      float var4 = var3.x - var2.x;
      float var5 = var3.y - var2.y;
      float var6 = var0 - var2.x;
      float var7 = var1 - var2.y;
      float var8 = var4 * var4 + var5 * var5;
      float var9 = var8 < 1.0E-5F ? 0.0F : MathHelper.clamp((var6 * var4 + var7 * var5) / var8, 0.0F, 1.0F);
      float var10 = var2.x + var9 * var4;
      float var11 = var2.y + var9 * var5;
      float var12 = var0 - var10;
      float var13 = var1 - var11;
      return (float)Math.sqrt(var12 * var12 + var13 * var13);
   }

   private static float I_method_240ac464(float var0) {
      while (var0 > Math.PI) {
         var0 -= (float) (Math.PI * 2);
      }

      while (var0 < -Math.PI) {
         var0 += (float) (Math.PI * 2);
      }

      return var0;
   }

   static enum Nested1_1032e5d6 {
      I_field_39e1ab71,
      i_field_39e1ab71,
      II_field_39e1ab71;
   }

   static final class Nested1_f843b4d3 implements VertexConsumer {
      private float I_field_46 = Float.MAX_VALUE;
      private float i_field_46 = Float.MAX_VALUE;
      private float II_field_46 = Float.MAX_VALUE;
      private float Ii_field_46 = -Float.MAX_VALUE;
      private float iI_field_46 = -Float.MAX_VALUE;
      private float ii_field_46 = -Float.MAX_VALUE;

      public VertexConsumer vertex(float x, float y, float z) {
         this.I_field_46 = Math.min(this.I_field_46, x);
         this.i_field_46 = Math.min(this.i_field_46, y);
         this.II_field_46 = Math.min(this.II_field_46, z);
         this.Ii_field_46 = Math.max(this.Ii_field_46, x);
         this.iI_field_46 = Math.max(this.iI_field_46, y);
         this.ii_field_46 = Math.max(this.ii_field_46, z);
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

      float[] I_method_4805fefa() {
         return this.I_field_46 > this.Ii_field_46
            ? null
            : new float[]{
               (this.I_field_46 + this.Ii_field_46) / 2.0F, (this.i_field_46 + this.iI_field_46) / 2.0F, (this.II_field_46 + this.ii_field_46) / 2.0F
            };
      }
   }

   static enum Nested1_f843b4f3 {
      I_field_8e4119dc,
      i_field_8e4119dc,
      II_field_8e4119dc;
   }
}
