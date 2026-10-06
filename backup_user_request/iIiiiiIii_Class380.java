package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;

public final class iIiiiiIii_Class380 implements AutoCloseable {
   private static iIiiiiIii_Class380 I_field_4503526c;
   private static boolean i_field_5a;
   private static final iIiiiiiII_Class381 I_field_4511624c = new iIiiiiiII_Class381();
   public static boolean I_field_5a = false;
   private final iIiiiiIii_Class380 i_field_4503526c;
   private final iIiiiiiII_Class381 i_field_4511624c;
   private final List<iIiiiiIii_Class380.Nested1_cdc047c9> I_field_7865b31 = new ArrayList<>();
   private final Map<iIiiiiIii_Class380.Nested1_cdc043e9, List<iIiiiiIii_Class380.Nested1_cdc04409>> I_field_a567c40b = new LinkedHashMap<>();
   private final Map<iIiiiiIii_Class380.Nested1_cdc043e9, List<iIiiiiIii_Class380.Nested1_cdc04409>> i_field_a567c40b = new LinkedHashMap<>();
   private final Map<IIiiii_Class16, List<iIiiiiIii_Class380.Nested1_cdc047e9>> II_field_a567c40b = new LinkedHashMap<>();
   private final Map<IIiiii_Class16, List<iIiiiiIii_Class380.Nested1_dd58c860>> Ii_field_a567c40b = new LinkedHashMap<>();
   private final Map<iIiiiiIii_Class380.Nested1_ea483980, List<iIiiiiIii_Class380.Nested1_ea4839a0>> iI_field_a567c40b = new LinkedHashMap<>();
   private final List<iIiiiiIii_Class380.Nested1_dd58c880> i_field_7865b31 = new ArrayList<>();
   private int I_field_49;

   private iIiiiiIii_Class380(boolean var1) {
      this.i_field_4503526c = I_field_4503526c;
      if (var1) {
         iIiiiiiII_Class381 var2 = I_field_4503526c != null && I_field_4503526c.i_field_4511624c == I_field_4511624c
            ? new iIiiiiiII_Class381()
            : I_field_4511624c;
         this.i_field_4511624c = var2.i_method_881d0de3() ? var2 : null;
         if (this.i_field_4511624c != null) {
            this.i_field_4511624c.I_method_880e81ff();
         }
      } else {
         this.i_field_4511624c = null;
      }

      I_field_4503526c = this;
   }

   public static iIiiiiIii_Class380 I_method_848d9af5() {
      return new iIiiiiIii_Class380(false);
   }

   public static iIiiiiIii_Class380 i_method_9a230ed5() {
      return new iIiiiiIii_Class380(true);
   }

   public static iIiiiiIii_Class380 II_method_752e8438() {
      return I_field_4503526c;
   }

   public static void I_method_5f4b621f() {
      if (I_field_4503526c != null) {
         boolean var0 = I_field_4503526c.i_field_4511624c != null;
         I_field_4503526c.iI_method_8bf2c942();
         if (var0) {
            iIiiiIiII_Class373.i_method_ff8f2dbf();
         }
      }
   }

   public static void i_method_5f59edff() {
      if (I_field_4503526c != null) {
         if (I_field_4503526c.i_field_4511624c != null) {
            I_field_4503526c.iiI_method_f438467f();
         } else {
            I_field_4503526c.iI_method_8bf2c942();
         }
      }
   }

   public static boolean I_method_5f4b6223() {
      return I_field_4503526c != null && I_field_4503526c.i_field_4511624c != null;
   }

   public static boolean i_method_5f59ee03() {
      return I_field_4503526c != null && !I_field_4503526c.iI_method_8bf2c946();
   }

   public boolean II_method_8a2fd926() {
      return this.i_field_4511624c != null;
   }

   public void I_method_593b2a9f(float var1, float var2, float var3, float var4) {
      if (this.i_field_4511624c != null) {
         this.i_field_4511624c.I_method_29ab5a7f(var1, var2, var3, var4);
      }
   }

   public void II_method_8a2fd922() {
      if (this.i_field_4511624c != null) {
         this.i_field_4511624c.i_method_881d0ddf();
      }
   }

   public static void Ii_method_8a3e6502() {
      RenderSystem.enableBlend();
      if (I_field_5a) {
         RenderSystem.blendFuncSeparate(SrcFactor.SRC_ALPHA, DstFactor.ONE_MINUS_SRC_ALPHA, SrcFactor.ONE, DstFactor.ONE_MINUS_SRC_ALPHA);
      } else {
         RenderSystem.defaultBlendFunc();
      }
   }

   public static boolean Ii_method_8a3e6506() {
      return i_field_5a;
   }

   public void I_method_a5119c30(Matrix4f var1, float var2, float var3, float var4, float var5, ColorRGBA var6) {
      if (!I_method_ba084e63(var4, var5) && !I_method_80c2fc44(var6)) {
         int var7 = this.I_method_8a2154b7(var6.getRGB());
         if ((var7 >>> 24 & 0xFF) != 0) {
            this.iIi_method_f283e23f();
            this.I_field_7865b31.add(new iIiiiiIii_Class380.Nested1_cdc047c9(new Matrix4f(var1), var2, var3, var4, var5, var7));
         }
      }
   }

   public void I_method_7da1308(Matrix4f var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, ColorRGBA var7) {
      this.I_method_1bf11cc8(var1, var2, var3, var4, var5, var6, 0.5F, 2.0F, var7);
   }

   public void I_method_10bfca4a(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, IIiii_Class8 var7, ColorRGBA var8) {
      this.I_method_1bf11cc8(var1, var2, var3, var4, var5, I_method_786096cf(var7, var6 / 2.0F), 0.5F, var6, var8);
   }

   public void i_method_10ab962a(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, IIiii_Class8 var7, ColorRGBA var8) {
      this.I_method_1bf11cc8(var1, var2, var3, var4, var5, I_method_786096cf(var7, 3.0F), var6, 2.0F, var8);
   }

   public void II_method_dc0a434d(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, IIiii_Class8 var7, ColorRGBA var8) {
      this.I_method_82460b8a(var1, var2, var3, var4, var5, var6, var7, 2.0F, 1.0F, var8);
   }

   public void I_method_2490fb48(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, IIiii_Class8 var8, ColorRGBA var9) {
      this.I_method_82460b8a(var1, var2, var3, var4, var5, var6, I_method_786096cf(var8, var7 / 2.0F), var7, 0.5F, var9);
   }

   public void I_method_893c7e7b(IIiiii_Class16 var1, String var2, float var3, Matrix4f var4, float var5, float var6, float var7, int var8) {
      if (var1 != null && var2 != null && !var2.isEmpty()) {
         int var9 = this.I_method_8a2154b7(var8);
         if ((var9 >>> 24 & 0xFF) != 0) {
            this.iIi_method_f283e23f();
            this.II_field_a567c40b
               .computeIfAbsent(var1, var0 -> new ArrayList<>())
               .add(new iIiiiiIii_Class380.Nested1_cdc047e9(new Matrix4f(var4), var2, var3, var5, var6, var7, var9));
         }
      }
   }

   public boolean I_method_b28fcfbd(
      IIiiii_Class16 var1,
      String var2,
      float var3,
      Matrix4f var4,
      float var5,
      float var6,
      float var7,
      int var8,
      float var9,
      float var10,
      boolean var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17
   ) {
      if (this.i_field_4511624c == null) {
         return false;
      } else if (var1 != null && var2 != null && !var2.isEmpty()) {
         int var18 = this.I_method_8a2154b7(var8);
         if ((var18 >>> 24 & 0xFF) == 0) {
            return true;
         } else {
            this.iiI_method_f438467f();
            this.i_field_4511624c
               .I_method_3aadd82b(new Matrix4f(var4), var1, var2, var3, var5, var6, var7, var18, var9, var10, var11, var12, var13, var14, var15, var16, var17);
            return true;
         }
      } else {
         return true;
      }
   }

   public boolean I_method_873c50e1(
      Matrix4f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      IIiii_Class8 var6,
      float var7,
      float var8,
      ColorRGBA var9,
      ColorRGBA var10,
      ColorRGBA var11,
      ColorRGBA var12,
      boolean var13
   ) {
      if (this.i_field_4511624c == null) {
         return false;
      } else {
         this.iiI_method_f438467f();
         this.i_field_4511624c
            .I_method_f79783fd(
               new Matrix4f(var1),
               var2,
               var3,
               var4,
               var5,
               var6,
               var7,
               var8,
               this.I_method_8a2154b7(var9.getRGB()),
               this.I_method_8a2154b7(var10.getRGB()),
               this.I_method_8a2154b7(var11.getRGB()),
               this.I_method_8a2154b7(var12.getRGB()),
               var13
            );
         return true;
      }
   }

   public void I_method_5a775f88(String var1, float var2, float var3, float var4, Matrix4f var5, ColorRGBA var6) {
      if (var1 != null && !(var4 <= 0.0F) && !I_method_80c2fc44(var6) && IIiiII_Class13.I_method_6bd3fa70()) {
         Integer var7 = IIiiII_Class13.I_method_d04bdedd(var1);
         if (var7 != null) {
            int var8 = this.I_method_8a2154b7(var6.getRGB());
            if ((var8 >>> 24 & 0xFF) != 0) {
               IIiiii_Class16 var9 = IIiiII_Class13.I_method_a9f1134b();
               if (var9 != null) {
                  this.iIi_method_f283e23f();
                  this.i_method_fab6cbd2(var9, var7, var2, var3, var4, var5, var8);
               }
            }
         }
      }
   }

   public void I_method_3fa37ff2(IIiiii_Class16 var1, int var2, float var3, float var4, float var5, Matrix4f var6, int var7) {
      if (var1 != null && !(var5 <= 0.0F)) {
         int var8 = this.I_method_8a2154b7(var7);
         if ((var8 >>> 24 & 0xFF) != 0) {
            this.iIi_method_f283e23f();
            this.i_method_fab6cbd2(var1, var2, var3, var4, var5, var6, var8);
         }
      }
   }

   public void I_method_51cad0d5(
      int var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, ColorRGBA var11
   ) {
      if (var1 != 0 && !I_method_ba084e63(var5, var6) && !I_method_80c2fc44(var11)) {
         int var12 = this.I_method_8a2154b7(var11.getRGB());
         if ((var12 >>> 24 & 0xFF) != 0) {
            this.ii_method_8c015522();
            this.Iii_method_bdabbe7f();
            if (!this.i_field_7865b31.isEmpty() && this.I_field_49 != var1) {
               this.iII_method_f275565f();
            }

            this.I_field_49 = var1;
            this.i_field_7865b31.add(new iIiiiiIii_Class380.Nested1_dd58c880(new Matrix4f(var2), var3, var4, var5, var6, var7, var8, var9, var10, var12));
         }
      }
   }

   public void I_method_6b23ad5(
      int var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17,
      float var18,
      ColorRGBA var19
   ) {
      this.I_method_5ad8b6a1(var1, true, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19);
   }

   public void I_method_1f4737a9(
      int var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17,
      ColorRGBA var18
   ) {
      this.I_method_5ad8b6a1(var1, false, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, 2.0F, var18);
   }

   private void i_method_fab6cbd2(IIiiii_Class16 var1, int var2, float var3, float var4, float var5, Matrix4f var6, int var7) {
      this.Ii_field_a567c40b
         .computeIfAbsent(var1, var0 -> new ArrayList<>())
         .add(new iIiiiiIii_Class380.Nested1_dd58c860(new Matrix4f(var6), var2, var3, var4, var5, var7));
   }

   public void iI_method_8bf2c942() {
      if (this.i_field_4511624c != null) {
         if (!i_field_5a) {
            i_field_5a = true;

            try {
               this.iiI_method_f438467f();
               this.i_field_4511624c.II_method_79d0b542();
            } finally {
               i_field_5a = false;
            }
         }
      } else if (!i_field_5a && !this.iI_method_8bf2c946()) {
         i_field_5a = true;
         float[] var1 = (float[])RenderSystem.getShaderColor().clone();

         try {
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            this.I_method_6c38c0e(this.I_field_a567c40b, false);
            this.III_method_bbda427f();
            this.I_method_6c38c0e(this.i_field_a567c40b, true);
            this.IIi_method_bbe8ce5f();
            this.IiI_method_bd9d329f();
            this.Iii_method_bdabbe7f();
            this.iII_method_f275565f();
         } finally {
            RenderSystem.setShaderColor(var1[0], var1[1], var1[2], var1[3]);
            this.IIiI_method_c13ff4e2();
            i_field_5a = false;
         }
      }
   }

   @Override
   public void close() {
      this.iI_method_8bf2c942();
      if (I_field_4503526c == this) {
         I_field_4503526c = this.i_field_4503526c;
      }
   }

   private void I_method_1bf11cc8(Matrix4f var1, float var2, float var3, float var4, float var5, IIiii_Class8 var6, float var7, float var8, ColorRGBA var9) {
      if (!I_method_ba084e63(var4, var5) && !I_method_80c2fc44(var9)) {
         int var10 = this.I_method_8a2154b7(var9.getRGB());
         if ((var10 >>> 24 & 0xFF) != 0) {
            this.iIi_method_f283e23f();
            iIiiiiIii_Class380.Nested1_cdc043e9 var11 = iIiiiiIii_Class380.Nested1_cdc043e9.I_method_1e9d8fc7(var6, var7, var8);
            this.I_field_a567c40b
               .computeIfAbsent(var11, var0 -> new ArrayList<>())
               .add(new iIiiiiIii_Class380.Nested1_cdc04409(new Matrix4f(var1), var2, var3, var4, var5, var10));
         }
      }
   }

   private void I_method_82460b8a(
      Matrix4f var1, float var2, float var3, float var4, float var5, float var6, IIiii_Class8 var7, float var8, float var9, ColorRGBA var10
   ) {
      if (!I_method_ba084e63(var4, var5) && !(var6 <= 0.0F) && !I_method_80c2fc44(var10)) {
         int var11 = this.I_method_8a2154b7(var10.getRGB());
         if ((var11 >>> 24 & 0xFF) != 0) {
            this.iIi_method_f283e23f();
            iIiiiiIii_Class380.Nested1_cdc043e9 var12 = iIiiiiIii_Class380.Nested1_cdc043e9.I_method_fb7b2107(var7, var6, 0.5F, var9, var8);
            this.i_field_a567c40b
               .computeIfAbsent(var12, var0 -> new ArrayList<>())
               .add(new iIiiiiIii_Class380.Nested1_cdc04409(new Matrix4f(var1), var2, var3, var4, var5, var11));
         }
      }
   }

   private void I_method_5ad8b6a1(
      int var1,
      boolean var2,
      Matrix4f var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17,
      float var18,
      float var19,
      ColorRGBA var20
   ) {
      if (var1 != 0 && !I_method_ba084e63(var6, var7) && !I_method_ba084e63(var12, var13) && !I_method_80c2fc44(var20)) {
         int var21 = this.I_method_8a2154b7(var20.getRGB());
         if ((var21 >>> 24 & 0xFF) != 0) {
            this.ii_method_8c015522();
            this.iII_method_f275565f();
            iIiiiiIii_Class380.Nested1_ea483980 var22 = new iIiiiiIii_Class380.Nested1_ea483980(
               var1, var2, var12, var13, var14, var15, var16, var17, var18, var19
            );
            this.iI_field_a567c40b
               .computeIfAbsent(var22, var0 -> new ArrayList<>())
               .add(new iIiiiiIii_Class380.Nested1_ea4839a0(new Matrix4f(var3), var4, var5, var6, var7, var8, var9, var10, var11, var21));
         }
      }
   }

   private void ii_method_8c015522() {
      if (!this.ii_method_8c015526() && !i_field_5a) {
         if (this.i_field_4511624c != null) {
            this.iii_method_f446d25f();
         } else {
            i_field_5a = true;
            float[] var1 = (float[])RenderSystem.getShaderColor().clone();

            try {
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               this.I_method_6c38c0e(this.I_field_a567c40b, false);
               this.III_method_bbda427f();
               this.I_method_6c38c0e(this.i_field_a567c40b, true);
               this.IIi_method_bbe8ce5f();
               this.IiI_method_bd9d329f();
               this.IIii_method_c14e80c2();
            } finally {
               RenderSystem.setShaderColor(var1[0], var1[1], var1[2], var1[3]);
               i_field_5a = false;
            }
         }
      }
   }

   private void III_method_bbda427f() {
      if (!this.I_field_7865b31.isEmpty()) {
         Ii_method_8a3e6502();
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder var1 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

         for (iIiiiiIii_Class380.Nested1_cdc047c9 var3 : this.I_field_7865b31) {
            var1.vertex(var3.I_field_d754d74, var3.I_field_46, var3.i_field_46 + var3.Ii_field_46, 0.0F).color(var3.I_field_49);
            var1.vertex(var3.I_field_d754d74, var3.I_field_46 + var3.II_field_46, var3.i_field_46 + var3.Ii_field_46, 0.0F).color(var3.I_field_49);
            var1.vertex(var3.I_field_d754d74, var3.I_field_46 + var3.II_field_46, var3.i_field_46, 0.0F).color(var3.I_field_49);
            var1.vertex(var3.I_field_d754d74, var3.I_field_46, var3.i_field_46, 0.0F).color(var3.I_field_49);
         }

         BuiltBuffer var4 = var1.endNullable();
         if (var4 != null) {
            BufferRenderer.drawWithGlobalProgram(var4);
         }

         RenderSystem.disableBlend();
      }
   }

   private void I_method_6c38c0e(Map<iIiiiiIii_Class380.Nested1_cdc043e9, List<iIiiiiIii_Class380.Nested1_cdc04409>> var1, boolean var2) {
      if (!var1.isEmpty()) {
         Ii_method_8a3e6502();
         RenderSystem.disableCull();
         IiIIIi_Class18.I_method_d904a8f7(0, 2, 3);
         RenderSystem.setShaderTexture(1, 0);

         for (Entry var4 : var1.entrySet()) {
            iIiiiiIii_Class380.Nested1_cdc043e9 var5 = (iIiiiiIii_Class380.Nested1_cdc043e9)var4.getKey();
            ShaderProgram var6 = iIiiIIiii_Class360.II_field_2f5b1d2c.I_method_33f6c16b();
            var6.getUniform("Radius").set(var5.I_field_46, var5.i_field_46, var5.II_field_46, var5.Ii_field_46);
            var6.getUniform("RectSmoothness").set(var5.III_field_46);
            var6.getUniform("CornerSmoothness").set(var5.IIi_field_46);
            var6.getUniform("BorderThickness").set(var5.iI_field_46);
            var6.getUniform("BorderSmoothness").set(var5.ii_field_46, var5.III_field_46);
            var6.getUniform("TextThickness").set(0.0F);
            var6.getUniform("HeadSize").set(0.0F, 0.0F);
            var6.getUniform("HeadRadius").set(0.0F, 0.0F, 0.0F, 0.0F);
            var6.getUniform("HeadSmoothness").set(0.5F);
            BufferBuilder var7 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);

            for (iIiiiiIii_Class380.Nested1_cdc04409 var9 : (Iterable<iIiiiiIii_Class380.Nested1_cdc04409>)(Iterable<?>)(List)var4.getValue()) {
               this.I_method_e7b9374a(var7, var9, var5.III_field_46, var2);
            }

            BuiltBuffer var10 = var7.endNullable();
            if (var10 != null) {
               BufferRenderer.drawWithGlobalProgram(var10);
            }
         }

         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.setShaderTexture(1, 0);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      }
   }

   private void IIi_method_bbe8ce5f() {
      if (!this.II_field_a567c40b.isEmpty()) {
         Ii_method_8a3e6502();
         RenderSystem.disableCull();
         ShaderProgram var1 = IiIIIi_Class18.I_method_fb4921e0(0.0F);
         var1.getUniform("EnableFadeout").set(0);
         var1.getUniform("FadeoutStart").set(0.0F);
         var1.getUniform("FadeoutEnd").set(1.0F);
         var1.getUniform("FadeinStart").set(0.0F);
         var1.getUniform("FadeinEnd").set(0.0F);
         var1.getUniform("MaxWidth").set(0.0F);
         var1.getUniform("TextPosX").set(0.0F);
         BufferBuilder var2 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);

         for (Entry var4 : this.II_field_a567c40b.entrySet()) {
            IIiiii_Class16 var5 = (IIiiii_Class16)var4.getKey();

            for (iIiiiiIii_Class380.Nested1_cdc047e9 var7 : (Iterable<iIiiiiIii_Class380.Nested1_cdc047e9>)(Iterable<?>)(List)var4.getValue()) {
               var5.I_method_5811d2b(
                  var7.I_field_d754d74, var2, var7.I_field_523beb0a, var7.I_field_46, var7.i_field_46, var7.II_field_46, var7.Ii_field_46, var7.I_field_49
               );
            }
         }

         BuiltBuffer var8 = var2.endNullable();
         if (var8 != null) {
            BufferRenderer.drawWithGlobalProgram(var8);
         }

         IiIIIi_Class18.I_method_a6e9b62c();
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      }
   }

   private void IiI_method_bd9d329f() {
      for (Entry var2 : this.Ii_field_a567c40b.entrySet()) {
         IIiiii_Class16 var3 = (IIiiii_Class16)var2.getKey();
         Ii_method_8a3e6502();
         RenderSystem.disableCull();
         ShaderProgram var4 = IiIIIi_Class18.I_method_fb4921e0(0.0F);
         var4.getUniform("EnableFadeout").set(0);
         var4.getUniform("FadeoutStart").set(0.0F);
         var4.getUniform("FadeoutEnd").set(1.0F);
         var4.getUniform("FadeinStart").set(0.0F);
         var4.getUniform("FadeinEnd").set(0.0F);
         var4.getUniform("MaxWidth").set(0.0F);
         var4.getUniform("TextPosX").set(0.0F);
         BufferBuilder var5 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);

         for (iIiiiiIii_Class380.Nested1_dd58c860 var7 : (Iterable<iIiiiiIii_Class380.Nested1_dd58c860>)(Iterable<?>)(List)var2.getValue()) {
            var3.I_method_b398d2fc(var7.I_field_d754d74, var5, var7.I_field_49, var7.I_field_46, var7.i_field_46, var7.II_field_46, var7.i_field_49);
         }

         BuiltBuffer var8 = var5.endNullable();
         if (var8 != null) {
            BufferRenderer.drawWithGlobalProgram(var8);
         }

         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      }
   }

   private void Iii_method_bdabbe7f() {
      if (!this.iI_field_a567c40b.isEmpty()) {
         if (this.i_field_4511624c != null) {
            this.IIII_method_bf7d04c2();
         } else {
            boolean var1 = i_field_5a;
            i_field_5a = true;
            float[] var2 = (float[])RenderSystem.getShaderColor().clone();

            try {
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

               for (Entry var4 : this.iI_field_a567c40b.entrySet()) {
                  iIiiIIiii_Class360.I_method_35d20793(
                     (iIiiiiIii_Class380.Nested1_ea483980)var4.getKey(), (List<iIiiiiIii_Class380.Nested1_ea4839a0>)var4.getValue()
                  );
               }

               this.iI_field_a567c40b.clear();
            } finally {
               RenderSystem.setShaderColor(var2[0], var2[1], var2[2], var2[3]);
               i_field_5a = var1;
            }
         }
      }
   }

   private void iII_method_f275565f() {
      if (!this.i_field_7865b31.isEmpty()) {
         if (this.i_field_4511624c != null) {
            this.IIIi_method_bf8b90a2();
         } else {
            boolean var1 = i_field_5a;
            i_field_5a = true;
            float[] var2 = (float[])RenderSystem.getShaderColor().clone();

            try {
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               Ii_method_8a3e6502();
               RenderSystem.disableCull();
               RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
               RenderSystem.setShaderTexture(0, this.I_field_49);
               BufferBuilder var3 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

               for (iIiiiiIii_Class380.Nested1_dd58c880 var5 : this.i_field_7865b31) {
                  var3.vertex(var5.I_field_d754d74, var5.I_field_46, var5.i_field_46, 0.0F).texture(var5.iI_field_46, var5.ii_field_46).color(var5.I_field_49);
                  var3.vertex(var5.I_field_d754d74, var5.I_field_46, var5.i_field_46 + var5.Ii_field_46, 0.0F)
                     .texture(var5.iI_field_46, var5.IIi_field_46)
                     .color(var5.I_field_49);
                  var3.vertex(var5.I_field_d754d74, var5.I_field_46 + var5.II_field_46, var5.i_field_46 + var5.Ii_field_46, 0.0F)
                     .texture(var5.III_field_46, var5.IIi_field_46)
                     .color(var5.I_field_49);
                  var3.vertex(var5.I_field_d754d74, var5.I_field_46 + var5.II_field_46, var5.i_field_46, 0.0F)
                     .texture(var5.III_field_46, var5.ii_field_46)
                     .color(var5.I_field_49);
               }

               BuiltBuffer var9 = var3.endNullable();
               if (var9 != null) {
                  BufferRenderer.drawWithGlobalProgram(var9);
               }

               RenderSystem.setShaderTexture(0, 0);
               RenderSystem.enableCull();
               RenderSystem.disableBlend();
               this.i_field_7865b31.clear();
               this.I_field_49 = 0;
            } finally {
               RenderSystem.setShaderColor(var2[0], var2[1], var2[2], var2[3]);
               i_field_5a = var1;
            }
         }
      }
   }

   private void iIi_method_f283e23f() {
      this.Iii_method_bdabbe7f();
      this.iII_method_f275565f();
   }

   private void I_method_e7b9374a(BufferBuilder var1, iIiiiiIii_Class380.Nested1_cdc04409 var2, float var3, boolean var4) {
      float var5 = -var3 / 2.0F + var3 * 2.0F;
      float var6 = var3 / 2.0F + var3;
      float var7 = var2.I_field_46 - var5 / 2.0F;
      float var8 = var2.i_field_46 - var6 / 2.0F;
      float var9 = var2.II_field_46 + var5;
      float var10 = var2.Ii_field_46 + var6;
      float var11 = var4 ? -var2.II_field_46 - 4.0F : var2.II_field_46;
      float var12 = var2.Ii_field_46;
      var1.vertex(var2.I_field_d754d74, var7, var8, 0.0F).texture(var11, var12).color(var2.I_field_49).light(0);
      var1.vertex(var2.I_field_d754d74, var7, var8 + var10, 0.0F).texture(var11, var12).color(var2.I_field_49).light(0);
      var1.vertex(var2.I_field_d754d74, var7 + var9, var8 + var10, 0.0F).texture(var11, var12).color(var2.I_field_49).light(0);
      var1.vertex(var2.I_field_d754d74, var7 + var9, var8, 0.0F).texture(var11, var12).color(var2.I_field_49).light(0);
   }

   private boolean iI_method_8bf2c946() {
      return this.ii_method_8c015526()
         && this.iI_field_a567c40b.isEmpty()
         && this.i_field_7865b31.isEmpty()
         && (this.i_field_4511624c == null || !this.i_field_4511624c.I_method_880e8203());
   }

   private void iiI_method_f438467f() {
      if (this.i_field_4511624c != null) {
         this.iii_method_f446d25f();
         this.IIII_method_bf7d04c2();
         this.IIIi_method_bf8b90a2();
      }
   }

   private void iii_method_f446d25f() {
      if (this.i_field_4511624c != null && !this.ii_method_8c015526()) {
         for (Entry var2 : this.I_field_a567c40b.entrySet()) {
            iIiiiiIii_Class380.Nested1_cdc043e9 var3 = (iIiiiiIii_Class380.Nested1_cdc043e9)var2.getKey();
            IIiii_Class8 var4 = I_method_4cac995b(var3);

            for (iIiiiiIii_Class380.Nested1_cdc04409 var6 : (Iterable<iIiiiiIii_Class380.Nested1_cdc04409>)(Iterable<?>)(List)var2.getValue()) {
               this.i_field_4511624c
                  .I_method_ad25e5b7(
                     var6.I_field_d754d74,
                     var6.I_field_46,
                     var6.i_field_46,
                     var6.II_field_46,
                     var6.Ii_field_46,
                     var4,
                     var3.III_field_46,
                     var3.IIi_field_46,
                     var6.I_field_49,
                     var6.I_field_49,
                     var6.I_field_49,
                     var6.I_field_49
                  );
            }
         }

         for (iIiiiiIii_Class380.Nested1_cdc047c9 var11 : this.I_field_7865b31) {
            this.i_field_4511624c
               .I_method_6bfb18f(
                  var11.I_field_d754d74,
                  var11.I_field_46,
                  var11.i_field_46,
                  var11.II_field_46,
                  var11.Ii_field_46,
                  var11.I_field_49,
                  var11.I_field_49,
                  var11.I_field_49,
                  var11.I_field_49
               );
         }

         for (Entry var12 : this.i_field_a567c40b.entrySet()) {
            iIiiiiIii_Class380.Nested1_cdc043e9 var15 = (iIiiiiIii_Class380.Nested1_cdc043e9)var12.getKey();
            IIiii_Class8 var18 = I_method_4cac995b(var15);

            for (iIiiiiIii_Class380.Nested1_cdc04409 var24 : (Iterable<iIiiiiIii_Class380.Nested1_cdc04409>)(Iterable<?>)(List)var12.getValue()) {
               this.i_field_4511624c
                  .I_method_cb9bc32c(
                     var24.I_field_d754d74,
                     var24.I_field_46,
                     var24.i_field_46,
                     var24.II_field_46,
                     var24.Ii_field_46,
                     var18,
                     var15.iI_field_46,
                     var15.ii_field_46,
                     var15.III_field_46,
                     var15.IIi_field_46,
                     var24.I_field_49
                  );
            }
         }

         for (Entry var13 : this.II_field_a567c40b.entrySet()) {
            IIiiii_Class16 var16 = (IIiiii_Class16)var13.getKey();

            for (iIiiiiIii_Class380.Nested1_cdc047e9 var22 : (Iterable<iIiiiiIii_Class380.Nested1_cdc047e9>)(Iterable<?>)(List)var13.getValue()) {
               this.i_field_4511624c
                  .I_method_3aadd82b(
                     var22.I_field_d754d74,
                     var16,
                     var22.I_field_523beb0a,
                     var22.I_field_46,
                     var22.i_field_46,
                     var22.II_field_46,
                     var22.Ii_field_46,
                     var22.I_field_49,
                     0.0F,
                     0.5F,
                     false,
                     0.0F,
                     0.0F,
                     0.0F,
                     1.0F,
                     0.0F,
                     0.0F
                  );
            }
         }

         for (Entry var14 : this.Ii_field_a567c40b.entrySet()) {
            IIiiii_Class16 var17 = (IIiiii_Class16)var14.getKey();

            for (iIiiiiIii_Class380.Nested1_dd58c860 var23 : (Iterable<iIiiiiIii_Class380.Nested1_dd58c860>)(Iterable<?>)(List)var14.getValue()) {
               this.i_field_4511624c
                  .I_method_d87f0f16(var23.I_field_d754d74, var17, var23.I_field_49, var23.I_field_46, var23.i_field_46, var23.II_field_46, var23.i_field_49);
            }
         }

         this.IIii_method_c14e80c2();
      }
   }

   private void IIII_method_bf7d04c2() {
      if (this.i_field_4511624c != null && !this.iI_field_a567c40b.isEmpty()) {
         for (Entry var2 : this.iI_field_a567c40b.entrySet()) {
            iIiiiiIii_Class380.Nested1_ea483980 var3 = (iIiiiiIii_Class380.Nested1_ea483980)var2.getKey();
            IIiii_Class8 var4 = new IIiii_Class8(var3.II_field_46, var3.iI_field_46, var3.ii_field_46, var3.Ii_field_46);

            for (iIiiiiIii_Class380.Nested1_ea4839a0 var6 : (Iterable<iIiiiiIii_Class380.Nested1_ea4839a0>)(Iterable<?>)(List)var2.getValue()) {
               this.i_field_4511624c
                  .I_method_e9dfd3f1(
                     var6.I_field_d754d74,
                     var3.I_field_49,
                     var6.I_field_46,
                     var6.i_field_46,
                     var6.II_field_46,
                     var6.Ii_field_46,
                     var3.I_field_46,
                     var3.i_field_46,
                     var4,
                     var3.III_field_46,
                     var3.IIi_field_46,
                     var6.iI_field_46,
                     var6.ii_field_46,
                     var6.III_field_46,
                     var6.IIi_field_46,
                     var6.I_field_49
                  );
            }
         }

         this.iI_field_a567c40b.clear();
      }
   }

   private void IIIi_method_bf8b90a2() {
      if (this.i_field_4511624c != null && !this.i_field_7865b31.isEmpty()) {
         for (iIiiiiIii_Class380.Nested1_dd58c880 var2 : this.i_field_7865b31) {
            this.i_field_4511624c
               .I_method_911c746f(
                  var2.I_field_d754d74,
                  this.I_field_49,
                  var2.I_field_46,
                  var2.i_field_46,
                  var2.II_field_46,
                  var2.Ii_field_46,
                  var2.iI_field_46,
                  var2.ii_field_46,
                  var2.III_field_46,
                  var2.IIi_field_46,
                  var2.I_field_49
               );
         }

         this.i_field_7865b31.clear();
         this.I_field_49 = 0;
      }
   }

   private static IIiii_Class8 I_method_4cac995b(iIiiiiIii_Class380.Nested1_cdc043e9 var0) {
      return new IIiii_Class8(var0.I_field_46, var0.II_field_46, var0.Ii_field_46, var0.i_field_46);
   }

   private boolean ii_method_8c015526() {
      return this.I_field_7865b31.isEmpty()
         && this.I_field_a567c40b.isEmpty()
         && this.i_field_a567c40b.isEmpty()
         && this.II_field_a567c40b.isEmpty()
         && this.Ii_field_a567c40b.isEmpty();
   }

   private void IIiI_method_c13ff4e2() {
      this.IIii_method_c14e80c2();
      this.iI_field_a567c40b.clear();
      this.i_field_7865b31.clear();
      this.I_field_49 = 0;
   }

   private void IIii_method_c14e80c2() {
      this.I_field_7865b31.clear();
      this.I_field_a567c40b.clear();
      this.i_field_a567c40b.clear();
      this.II_field_a567c40b.clear();
      this.Ii_field_a567c40b.clear();
   }

   private int I_method_8a2154b7(int var1) {
      float[] var2 = RenderSystem.getShaderColor();
      int var3 = var1 >>> 24 & 0xFF;
      int var4 = var1 >>> 16 & 0xFF;
      int var5 = var1 >>> 8 & 0xFF;
      int var6 = var1 & 0xFF;
      int var7 = this.I_method_8a214974(var3 * var2[3]);
      int var8 = this.I_method_8a214974(var4 * var2[0]);
      int var9 = this.I_method_8a214974(var5 * var2[1]);
      int var10 = this.I_method_8a214974(var6 * var2[2]);
      return var7 << 24 | var8 << 16 | var9 << 8 | var10;
   }

   private int I_method_8a214974(float var1) {
      return Math.max(0, Math.min(255, Math.round(var1)));
   }

   private static boolean I_method_ba084e63(float var0, float var1) {
      return var0 <= 0.0F || var1 <= 0.0F;
   }

   private static boolean I_method_80c2fc44(ColorRGBA var0) {
      return var0 == null || var0.getAlpha() <= 0.5F;
   }

   private static IIiii_Class8 I_method_786096cf(IIiii_Class8 var0, float var1) {
      return new IIiii_Class8(
         var0.I_method_b483cecf() * var1, var0.i_method_b4925aaf() * var1, var0.II_method_dc050452() * var1, var0.Ii_method_dc139032() * var1
      );
   }

   static final class Nested1_cdc043e9 {
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final float iI_field_46;
      final float ii_field_46;
      final float III_field_46;
      final float IIi_field_46;

      private Nested1_cdc043e9(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.II_field_46 = var3;
         this.Ii_field_46 = var4;
         this.iI_field_46 = var5;
         this.ii_field_46 = var6;
         this.III_field_46 = var7;
         this.IIi_field_46 = var8;
      }

      static iIiiiiIii_Class380.Nested1_cdc043e9 I_method_1e9d8fc7(IIiii_Class8 var0, float var1, float var2) {
         return new iIiiiiIii_Class380.Nested1_cdc043e9(
            var0.I_method_b483cecf(), var0.Ii_method_dc139032(), var0.i_method_b4925aaf(), var0.II_method_dc050452(), 0.0F, var1, var1, var2
         );
      }

      static iIiiiiIii_Class380.Nested1_cdc043e9 I_method_fb7b2107(IIiii_Class8 var0, float var1, float var2, float var3, float var4) {
         return new iIiiiiIii_Class380.Nested1_cdc043e9(
            var0.I_method_b483cecf(), var0.Ii_method_dc139032(), var0.i_method_b4925aaf(), var0.II_method_dc050452(), var1, var2, var3, var4
         );
      }

      @Override
      public final String toString() {
         return "Nested1_cdc043e9[topLeft=" + this.I_field_46 + ", bottomLeft=" + this.i_field_46 + ", topRight=" + this.II_field_46 + ", bottomRight=" + this.Ii_field_46 + ", thickness=" + this.iI_field_46 + ", internalSmoothness=" + this.ii_field_46 + ", externalSmoothness=" + this.III_field_46 + ", cornerSmoothness=" + this.IIi_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.III_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.IIi_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiIii_Class380.Nested1_cdc043e9 other = (iIiiiiIii_Class380.Nested1_cdc043e9) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46)
            && java.util.Objects.equals(this.III_field_46, other.III_field_46)
            && java.util.Objects.equals(this.IIi_field_46, other.IIi_field_46);
      }

      public float I_method_af34c961() {
         return this.I_field_46;
      }

      public float i_method_af435541() {
         return this.i_field_46;
      }

      public float II_method_37735c00() {
         return this.II_field_46;
      }

      public float Ii_method_3781e7e0() {
         return this.Ii_field_46;
      }

      public float iI_method_39364c20() {
         return this.iI_field_46;
      }

      public float ii_method_3944d800() {
         return this.ii_field_46;
      }

      public float III_method_b7071d41() {
         return this.III_field_46;
      }

      public float IIi_method_b715a921() {
         return this.IIi_field_46;
      }
   }

   static final class Nested1_cdc04409 {
      final Matrix4f I_field_d754d74;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final int I_field_49;

      Nested1_cdc04409(Matrix4f var1, float var2, float var3, float var4, float var5, int var6) {
         this.I_field_d754d74 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.I_field_49 = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_cdc04409[matrix=" + this.I_field_d754d74 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", width=" + this.II_field_46 + ", height=" + this.Ii_field_46 + ", rgba=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiIii_Class380.Nested1_cdc04409 other = (iIiiiiIii_Class380.Nested1_cdc04409) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Matrix4f I_method_cf9401af() {
         return this.I_field_d754d74;
      }

      public float I_method_e5cfdd41() {
         return this.I_field_46;
      }

      public float i_method_e5de6921() {
         return this.i_field_46;
      }

      public float II_method_d43ac420() {
         return this.II_field_46;
      }

      public float Ii_method_d4495000() {
         return this.Ii_field_46;
      }

      public int I_method_e5cfdd44() {
         return this.I_field_49;
      }
   }

   static final class Nested1_cdc047c9 {
      final Matrix4f I_field_d754d74;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final int I_field_49;

      Nested1_cdc047c9(Matrix4f var1, float var2, float var3, float var4, float var5, int var6) {
         this.I_field_d754d74 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.I_field_49 = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_cdc047c9[matrix=" + this.I_field_d754d74 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", width=" + this.II_field_46 + ", height=" + this.Ii_field_46 + ", rgba=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiIii_Class380.Nested1_cdc047c9 other = (iIiiiiIii_Class380.Nested1_cdc047c9) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Matrix4f I_method_d56bc5ef() {
         return this.I_field_d754d74;
      }

      public float I_method_4bfc3181() {
         return this.I_field_46;
      }

      public float i_method_4c0abd61() {
         return this.i_field_46;
      }

      public float II_method_3398f7e0() {
         return this.II_field_46;
      }

      public float Ii_method_33a783c0() {
         return this.Ii_field_46;
      }

      public int I_method_4bfc3184() {
         return this.I_field_49;
      }
   }

   static final class Nested1_cdc047e9 {
      final Matrix4f I_field_d754d74;
      final String I_field_523beb0a;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final int I_field_49;

      Nested1_cdc047e9(Matrix4f var1, String var2, float var3, float var4, float var5, float var6, int var7) {
         this.I_field_d754d74 = var1;
         this.I_field_523beb0a = var2;
         this.I_field_46 = var3;
         this.i_field_46 = var4;
         this.II_field_46 = var5;
         this.Ii_field_46 = var6;
         this.I_field_49 = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_cdc047e9[matrix=" + this.I_field_d754d74 + ", text=" + this.I_field_523beb0a + ", size=" + this.I_field_46 + ", x=" + this.i_field_46 + ", y=" + this.II_field_46 + ", z=" + this.Ii_field_46 + ", rgba=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiIii_Class380.Nested1_cdc047e9 other = (iIiiiiIii_Class380.Nested1_cdc047e9) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Matrix4f I_method_559da1cf() {
         return this.I_field_d754d74;
      }

      public String I_method_7dda1f4f() {
         return this.I_field_523beb0a;
      }

      public float I_method_82974561() {
         return this.I_field_46;
      }

      public float i_method_82a5d141() {
         return this.i_field_46;
      }

      public float II_method_d0606000() {
         return this.II_field_46;
      }

      public float Ii_method_d06eebe0() {
         return this.Ii_field_46;
      }

      public int I_method_82974564() {
         return this.I_field_49;
      }
   }

   static final class Nested1_dd58c860 {
      final Matrix4f I_field_d754d74;
      final int I_field_49;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final int i_field_49;

      Nested1_dd58c860(Matrix4f var1, int var2, float var3, float var4, float var5, int var6) {
         this.I_field_d754d74 = var1;
         this.I_field_49 = var2;
         this.I_field_46 = var3;
         this.i_field_46 = var4;
         this.II_field_46 = var5;
         this.i_field_49 = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_dd58c860[matrix=" + this.I_field_d754d74 + ", codepoint=" + this.I_field_49 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", size=" + this.II_field_46 + ", rgba=" + this.i_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiIii_Class380.Nested1_dd58c860 other = (iIiiiiIii_Class380.Nested1_dd58c860) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49);
      }

      public Matrix4f I_method_272e8b78() {
         return this.I_field_d754d74;
      }

      public int I_method_a95f774d() {
         return this.I_field_49;
      }

      public float I_method_a95f774a() {
         return this.I_field_46;
      }

      public float i_method_a96e032a() {
         return this.i_field_46;
      }

      public float II_method_829e6b37() {
         return this.II_field_46;
      }

      public int i_method_a96e032d() {
         return this.i_field_49;
      }
   }

   static final class Nested1_dd58c880 {
      final Matrix4f I_field_d754d74;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final float iI_field_46;
      final float ii_field_46;
      final float III_field_46;
      final float IIi_field_46;
      final int I_field_49;

      Nested1_dd58c880(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10) {
         this.I_field_d754d74 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.iI_field_46 = var6;
         this.ii_field_46 = var7;
         this.III_field_46 = var8;
         this.IIi_field_46 = var9;
         this.I_field_49 = var10;
      }

      @Override
      public final String toString() {
         return "Nested1_dd58c880[matrix=" + this.I_field_d754d74 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", width=" + this.II_field_46 + ", height=" + this.Ii_field_46 + ", u1=" + this.iI_field_46 + ", v1=" + this.ii_field_46 + ", u2=" + this.III_field_46 + ", v2=" + this.IIi_field_46 + ", rgba=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.III_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.IIi_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiIii_Class380.Nested1_dd58c880 other = (iIiiiiIii_Class380.Nested1_dd58c880) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46)
            && java.util.Objects.equals(this.III_field_46, other.III_field_46)
            && java.util.Objects.equals(this.IIi_field_46, other.IIi_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Matrix4f I_method_a7606758() {
         return this.I_field_d754d74;
      }

      public float I_method_dffa8b2a() {
         return this.I_field_46;
      }

      public float i_method_e009170a() {
         return this.i_field_46;
      }

      public float II_method_1f65d357() {
         return this.II_field_46;
      }

      public float Ii_method_1f745f37() {
         return this.Ii_field_46;
      }

      public float iI_method_2128c377() {
         return this.iI_field_46;
      }

      public float ii_method_21374f57() {
         return this.ii_field_46;
      }

      public float III_method_cd6390ca() {
         return this.III_field_46;
      }

      public float IIi_method_cd721caa() {
         return this.IIi_field_46;
      }

      public int I_method_dffa8b2d() {
         return this.I_field_49;
      }
   }

   public static final class Nested1_ea483980 {
      final int I_field_49;
      private final boolean I_field_5a;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final float iI_field_46;
      final float ii_field_46;
      final float III_field_46;
      final float IIi_field_46;

      public Nested1_ea483980(int var1, boolean var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
         this.I_field_49 = var1;
         this.I_field_5a = var2;
         this.I_field_46 = var3;
         this.i_field_46 = var4;
         this.II_field_46 = var5;
         this.Ii_field_46 = var6;
         this.iI_field_46 = var7;
         this.ii_field_46 = var8;
         this.III_field_46 = var9;
         this.IIi_field_46 = var10;
      }

      @Override
      public final String toString() {
         return "Nested1_ea483980[textureId=" + this.I_field_49 + ", squircle=" + this.I_field_5a + ", width=" + this.I_field_46 + ", height=" + this.i_field_46 + ", topLeft=" + this.II_field_46 + ", bottomLeft=" + this.Ii_field_46 + ", topRight=" + this.iI_field_46 + ", bottomRight=" + this.ii_field_46 + ", smoothness=" + this.III_field_46 + ", cornerSmoothness=" + this.IIi_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.III_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.IIi_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiIii_Class380.Nested1_ea483980 other = (iIiiiiIii_Class380.Nested1_ea483980) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46)
            && java.util.Objects.equals(this.III_field_46, other.III_field_46)
            && java.util.Objects.equals(this.IIi_field_46, other.IIi_field_46);
      }

      public int I_method_6409ba2d() {
         return this.I_field_49;
      }

      public boolean I_method_6409ba3e() {
         return this.I_field_5a;
      }

      public float I_method_6409ba2a() {
         return this.I_field_46;
      }

      public float i_method_6418460a() {
         return this.i_field_46;
      }

      public float II_method_1d3c8457() {
         return this.II_field_46;
      }

      public float Ii_method_1d4b1037() {
         return this.Ii_field_46;
      }

      public float iI_method_1eff7477() {
         return this.iI_field_46;
      }

      public float ii_method_1f0e0057() {
         return this.ii_field_46;
      }

      public float III_method_8a62ffca() {
         return this.III_field_46;
      }

      public float IIi_method_8a718baa() {
         return this.IIi_field_46;
      }
   }

   public static final class Nested1_ea4839a0 {
      final Matrix4f I_field_d754d74;
      final float I_field_46;
      final float i_field_46;
      final float II_field_46;
      final float Ii_field_46;
      final float iI_field_46;
      final float ii_field_46;
      final float III_field_46;
      final float IIi_field_46;
      final int I_field_49;

      public Nested1_ea4839a0(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10) {
         this.I_field_d754d74 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
         this.Ii_field_46 = var5;
         this.iI_field_46 = var6;
         this.ii_field_46 = var7;
         this.III_field_46 = var8;
         this.IIi_field_46 = var9;
         this.I_field_49 = var10;
      }

      @Override
      public final String toString() {
         return "Nested1_ea4839a0[matrix=" + this.I_field_d754d74 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", width=" + this.II_field_46 + ", height=" + this.Ii_field_46 + ", u1=" + this.iI_field_46 + ", v1=" + this.ii_field_46 + ", u2=" + this.III_field_46 + ", v2=" + this.IIi_field_46 + ", rgba=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.iI_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.ii_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.III_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.IIi_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiiIii_Class380.Nested1_ea4839a0 other = (iIiiiiIii_Class380.Nested1_ea4839a0) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.Ii_field_46, other.Ii_field_46)
            && java.util.Objects.equals(this.iI_field_46, other.iI_field_46)
            && java.util.Objects.equals(this.ii_field_46, other.ii_field_46)
            && java.util.Objects.equals(this.III_field_46, other.III_field_46)
            && java.util.Objects.equals(this.IIi_field_46, other.IIi_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Matrix4f I_method_add3b238() {
         return this.I_field_d754d74;
      }

      public float I_method_9aa4ce0a() {
         return this.I_field_46;
      }

      public float i_method_9ab359ea() {
         return this.i_field_46;
      }

      public float II_method_ba03ec77() {
         return this.II_field_46;
      }

      public float Ii_method_ba127857() {
         return this.Ii_field_46;
      }

      public float iI_method_bbc6dc97() {
         return this.iI_field_46;
      }

      public float ii_method_bbd56877() {
         return this.ii_field_46;
      }

      public float III_method_86889baa() {
         return this.III_field_46;
      }

      public float IIi_method_8697278a() {
         return this.IIi_field_46;
      }

      public int I_method_9aa4ce0d() {
         return this.I_field_49;
      }
   }
}
