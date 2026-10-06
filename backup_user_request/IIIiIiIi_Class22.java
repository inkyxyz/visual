package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.util.BufferAllocator;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

public final class IIIiIiIi_Class22 implements iIIiIIiIi_Class294 {
   private static final IIIiIiiI_Class23 I_field_78095f61 = new IIIiIiiI_Class23();
   static final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(true);
   private static final int Ii_field_49 = 30;
   private static final int iI_field_49 = 256;
   public static final int I_field_49 = 0;
   public static final int i_field_49 = 1;
   public static final int II_field_49 = 2;
   static final int[] I_field_b4e = new int[1024];
   static final int[] i_field_b4e = new int[256];
   static int ii_field_49;
   static int III_field_49 = 2;
   private static final List<IIIiIiIi_Class22.Nested1_85037d33> I_field_7865b31 = new ArrayList<>();
   private static Immediate I_field_c522eb8e;
   private static boolean I_field_5a;
   static boolean i_field_5a;
   static boolean II_field_5a;
   private static boolean Ii_field_5a;
   private static boolean iI_field_5a;
   private static boolean ii_field_5a;
   private static int IIi_field_49;
   private static final int IiI_field_49 = 3;
   static int Iii_field_49;

   private IIIiIiIi_Class22() {
   }

   public static boolean I_method_f1941870() {
      return I_field_5a;
   }

   public static boolean i_method_f1a2a450() {
      return II_field_5a;
   }

   public static boolean II_method_40fdec79() {
      return I_field_5a && i_field_5a && !II_field_5a && !iI_field_5a;
   }

   public static void I_method_40efa7e8(boolean var0) {
      ii_field_5a = var0;
   }

   public static void I_method_4d8e94ea(Runnable var0) {
      iI_field_5a = true;

      try {
         var0.run();
      } finally {
         iI_field_5a = false;
      }
   }

   public static void I_method_f194186c() {
      I_field_78095f61.i_method_57cef88c();
      I_field_5a = false;
      i_field_5a = false;
      ii_field_49 = 0;
   }

   public static void i_method_f1a2a44c() {
      ii_field_49 = 0;
      I_field_7865b31.clear();
      i_field_5a = false;
      NameProtectModule var0 = I_method_850d2e2();
      if (var0 != null) {
         var0.IiI_method_e72bc27f();
      }

      Ii_method_410c7855();
      if (I_field_5a) {
         Framebuffer var1 = I_field_3a9bda27.getFramebuffer();
         if (var1 != null && var1.textureWidth > 0 && var1.textureHeight > 0) {
            try {
               I_field_cb35e4c.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
               I_field_cb35e4c.I_method_53fdf4b5(true);
               var1.beginWrite(false);
               i_field_5a = true;
            } catch (Throwable var3) {
               RockstarClient.I_field_ab0f6068
                  .error(
                     "[CaptureBypass] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0441\u043b\u043e\u0439 \u0437\u0430\u043f\u043b\u0430\u0442\u043e\u043a",
                     var3
                  );
               i_field_5a = false;
            }
         }
      }
   }

   private static void Ii_method_410c7855() {
      NameProtectModule var0 = I_method_850d2e2();
      boolean var1 = var0 != null && var0.isEnabled() && var0.II_method_150838().i_method_9b12da03();
      boolean var2 = var1
         && !I_field_3a9bda27.getWindow().isFullscreen()
         && !I_field_78095f61.i_method_57cef890()
         && (I_field_78095f61.I_method_57c06cb0() || I_field_78095f61.II_method_a05c2039());
      if (var1 && !var2 && !Ii_field_5a) {
         Ii_field_5a = true;
         RockstarClient.I_field_ab0f6068
            .warn(
               "[CaptureBypass] \u043f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u0439 \u0441\u043b\u043e\u0439 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d: {}",
               I_field_3a9bda27.getWindow().isFullscreen()
                  ? "\u0438\u0433\u0440\u0430 \u0432 \u043f\u043e\u043b\u043d\u043e\u044d\u043a\u0440\u0430\u043d\u043d\u043e\u043c \u0440\u0435\u0436\u0438\u043c\u0435"
                  : "\u0441\u0438\u0441\u0442\u0435\u043c\u0430 \u043d\u0435 \u0443\u043c\u0435\u0435\u0442 \u0432\u044b\u0440\u0435\u0437\u0430\u0442\u044c \u043e\u043a\u043d\u0430 \u0438\u0437 \u0437\u0430\u0445\u0432\u0430\u0442\u0430 (\u043d\u0443\u0436\u043d\u0430 Windows 10 2004+)"
            );
      }

      if (var2) {
         Ii_field_5a = false;
      }

      if (var2 != I_field_5a) {
         I_field_5a = var2;
         if (!var2) {
            I_field_78095f61.I_method_57c06cac();
         }

         if (I_field_3a9bda27.inGameHud != null) {
            I_field_3a9bda27.inGameHud.getChatHud().reset();
         }
      }
   }

   public static void II_method_40fdec75() {
      if (!i_field_5a) {
         if (!I_field_78095f61.i_method_57cef890()) {
            I_field_78095f61.I_method_57c06cac();
         }
      } else {
         i_field_5a = false;

         try {
            iI_method_42c0dc95();
            if (ii_field_49 == 0) {
               if (++IIi_field_49 > 30) {
                  I_field_78095f61.I_method_57c06cac();
                  return;
               }
            } else {
               IIi_field_49 = 0;
               ii_method_42cf6875();
            }

            Framebuffer var0 = I_field_3a9bda27.getFramebuffer();
            I_field_78095f61.I_method_b8ccbf5e(I_field_cb35e4c.getColorAttachment(), I_field_b4e, ii_field_49, var0.textureWidth, var0.textureHeight);
         } finally {
            GlStateManager._glBindFramebuffer(36160, 0);
         }
      }
   }

   public static Immediate I_method_93e36b38() {
      if (I_field_c522eb8e == null) {
         I_field_c522eb8e = VertexConsumerProvider.immediate(new BufferAllocator(1536));
      }

      return I_field_c522eb8e;
   }

   public static int[] I_method_3eff6066(Matrix4f var0, float var1, float var2, float var3) {
      return I_method_a0f921e2(var0, var1 - 1.0F, var2 - 1.0F, var1 + var3 + 2.0F, var2 + 10.0F);
   }

   public static boolean I_method_9e8f326c(IIIiIiIi_Class22.Nested1_85037d53 var0) {
      if (II_method_40fdec79() && I_field_7865b31.size() < 256) {
         I_field_7865b31.add(new IIIiIiIi_Class22.Nested1_85037d33(var0, I_method_2bae96e7()));
         return true;
      } else {
         return false;
      }
   }

   public static void I_method_40ef6817(int var0) {
      if (!I_field_7865b31.isEmpty()) {
         ArrayList var1 = new ArrayList<>(I_field_7865b31);
         I_field_7865b31.clear();
         III_field_49 = var0;
         I_method_f82eeab7(var1, IIIiIiIi_Class22.Nested1_85037d33::I_method_cc53ce67);
         I_method_f82eeab7(var1, IIIiIiIi_Class22.Nested1_85037d33::i_method_cc625a47);
         I_method_f82eeab7(var1, IIIiIiIi_Class22.Nested1_85037d33::II_method_be34f5da);
      }
   }

   private static void I_method_f82eeab7(List<IIIiIiIi_Class22.Nested1_85037d33> var0, Consumer<IIIiIiIi_Class22.Nested1_85037d33> var1) {
      for (IIIiIiIi_Class22.Nested1_85037d33 var3 : var0) {
         try {
            var1.accept(var3);
         } catch (Throwable var5) {
            RockstarClient.I_field_ab0f6068
               .error(
                  "[CaptureBypass] \u043e\u0442\u043b\u043e\u0436\u0435\u043d\u043d\u0430\u044f \u0437\u0430\u043f\u043b\u0430\u0442\u043a\u0430 \u043d\u0435 \u043b\u0435\u0433\u043b\u0430",
                  var5
               );
         }
      }
   }

   private static void iI_method_42c0dc95() {
      boolean var0 = I_field_3a9bda27.getOverlay() != null || I_field_3a9bda27.currentScreen != null && !(I_field_3a9bda27.currentScreen instanceof ChatScreen);
      if (var0) {
         int var1 = 0;

         for (int var2 = 0; var2 < ii_field_49; var2++) {
            if (i_field_b4e[var2] == 2) {
               System.arraycopy(I_field_b4e, var2 * 4, I_field_b4e, var1 * 4, 4);
               i_field_b4e[var1] = i_field_b4e[var2];
               var1++;
            }
         }

         ii_field_49 = var1;
      }
   }

   public static void I_method_3ee425f8(int[] var0, Runnable var1) {
      if (var0 != null && II_method_40fdec79() && ii_field_49 < 256) {
         Framebuffer var2 = I_field_3a9bda27.getFramebuffer();
         boolean var3 = GL11.glIsEnabled(3089);
         int[] var4 = new int[4];
         GL11.glGetIntegerv(3088, var4);
         II_field_5a = true;

         try {
            iIiiiiIii_Class380.I_method_5f4b621f();
            I_method_dd063c7a(var0);
            I_field_cb35e4c.beginWrite(false);
            GlStateManager._enableScissorTest();
            GlStateManager._scissorBox(var0[0], var0[1], var0[2], var0[3]);
            var1.run();
            int var5 = ii_field_49 * 4;
            I_field_b4e[var5] = var0[0];
            I_field_b4e[var5 + 1] = var0[1];
            I_field_b4e[var5 + 2] = var0[2];
            I_field_b4e[var5 + 3] = var0[3];
            i_field_b4e[ii_field_49] = ii_field_5a ? 2 : 1;
            ii_field_49++;
         } catch (Throwable var9) {
            RockstarClient.I_field_ab0f6068
               .error("[CaptureBypass] \u0437\u0430\u043f\u043b\u0430\u0442\u043a\u0430 \u043d\u0435 \u043b\u0435\u0433\u043b\u0430", var9);
         } finally {
            var2.beginWrite(false);
            if (var3) {
               GlStateManager._enableScissorTest();
               GlStateManager._scissorBox(var4[0], var4[1], var4[2], var4[3]);
            } else {
               GlStateManager._disableScissorTest();
            }

            II_field_5a = false;
         }
      }
   }

   static void I_method_dd063c7a(int[] var0) {
      Framebuffer var1 = I_field_3a9bda27.getFramebuffer();
      GlStateManager._glBindFramebuffer(36008, var1.fbo);
      GlStateManager._glBindFramebuffer(36009, I_field_cb35e4c.fbo);
      GL30.glBlitFramebuffer(var0[0], var0[1], var0[0] + var0[2], var0[1] + var0[3], var0[0], var0[1], var0[0] + var0[2], var0[1] + var0[3], 16640, 9728);
   }

   public static String I_method_7f49082a(String var0) {
      if (II_method_40fdec79() && var0 != null && !var0.isEmpty()) {
         NameProtectModule var1 = I_method_850d2e2();
         if (var1 != null && var1.i_method_60d6ed87(var0)) {
            String var2 = var1.i_method_a8235dd7(var0);
            return var2.equals(var0) ? var0 : var2;
         } else {
            return var0;
         }
      } else {
         return var0;
      }
   }

   public static int[] I_method_db730cdc(int[] var0, int[] var1) {
      if (var0 == null) {
         return var1;
      } else if (var1 == null) {
         return var0;
      } else {
         int var2 = Math.min(var0[0], var1[0]);
         int var3 = Math.min(var0[1], var1[1]);
         int var4 = Math.max(var0[0] + var0[2], var1[0] + var1[2]);
         int var5 = Math.max(var0[1] + var0[3], var1[1] + var1[3]);
         return new int[]{var2, var3, var4 - var2, var5 - var3};
      }
   }

   private static void ii_method_42cf6875() {
      I_field_cb35e4c.beginWrite(false);
      RenderSystem.colorMask(false, false, false, true);
      RenderSystem.clearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager._enableScissorTest();

      for (int var0 = 0; var0 < ii_field_49; var0++) {
         int var1 = var0 * 4;
         GlStateManager._scissorBox(I_field_b4e[var1], I_field_b4e[var1 + 1], I_field_b4e[var1 + 2], I_field_b4e[var1 + 3]);
         RenderSystem.clear(16384);
      }

      GlStateManager._disableScissorTest();
      RenderSystem.colorMask(true, true, true, true);
      I_field_3a9bda27.getFramebuffer().beginWrite(false);
   }

   public static int[] I_method_a0f921e2(Matrix4f var0, float var1, float var2, float var3, float var4) {
      Framebuffer var5 = I_field_3a9bda27.getFramebuffer();
      int var6 = var5.textureWidth;
      int var7 = var5.textureHeight;
      if (var6 > 0 && var7 > 0) {
         Matrix4f var8 = RenderSystem.getModelViewMatrix();
         Matrix4f var9 = RenderSystem.getProjectionMatrix();
         float var10 = Float.MAX_VALUE;
         float var11 = Float.MAX_VALUE;
         float var12 = -Float.MAX_VALUE;
         float var13 = -Float.MAX_VALUE;

         for (int var14 = 0; var14 < 4; var14++) {
            Vector4f var15 = new Vector4f((var14 & 1) == 0 ? var1 : var3, (var14 & 2) == 0 ? var2 : var4, 0.0F, 1.0F);
            var0.transform(var15);
            var8.transform(var15);
            var9.transform(var15);
            if (var15.w <= 1.0E-5F) {
               return null;
            }

            float var16 = (var15.x / var15.w * 0.5F + 0.5F) * var6;
            float var17 = (var15.y / var15.w * 0.5F + 0.5F) * var7;
            var10 = Math.min(var10, var16);
            var11 = Math.min(var11, var17);
            var12 = Math.max(var12, var16);
            var13 = Math.max(var13, var17);
         }

         int var19 = Math.max(0, (int)Math.floor(var10));
         int var20 = Math.max(0, (int)Math.floor(var11));
         int var21 = Math.min(var6, (int)Math.ceil(var12));
         int var22 = Math.min(var7, (int)Math.ceil(var13));
         if (GL11.glIsEnabled(3089)) {
            int[] var18 = new int[4];
            GL11.glGetIntegerv(3088, var18);
            var19 = Math.max(var19, var18[0]);
            var20 = Math.max(var20, var18[1]);
            var21 = Math.min(var21, var18[0] + var18[2]);
            var22 = Math.min(var22, var18[1] + var18[3]);
         }

         return var21 > var19 && var22 > var20 ? new int[]{var19, var20, var21 - var19, var22 - var20} : null;
      } else {
         return null;
      }
   }

   private static NameProtectModule I_method_850d2e2() {
      try {
         return RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
      } catch (Throwable var1) {
         return null;
      }
   }

   private static IIIiIiIi_Class22.Nested1_1b6c2976 I_method_2bae96e7() {
      boolean var0 = GL11.glIsEnabled(3089);
      int[] var1 = new int[4];
      GL11.glGetIntegerv(3088, var1);
      int[] var2 = new int[4];
      GL11.glGetIntegerv(2978, var2);
      return new IIIiIiIi_Class22.Nested1_1b6c2976(
         new Matrix4f(RenderSystem.getProjectionMatrix()), RenderSystem.getProjectionType(), new Matrix4f(RenderSystem.getModelViewMatrix()), var0, var1, var2
      );
   }

   static final class Nested1_1b6c2976 {
      private final Matrix4f I_field_d754d74;
      private final ProjectionType I_field_6acce748;
      private final Matrix4f i_field_d754d74;
      private final boolean I_field_5a;
      private final int[] I_field_b4e;
      private final int[] i_field_b4e;

      Nested1_1b6c2976(Matrix4f var1, ProjectionType var2, Matrix4f var3, boolean var4, int[] var5, int[] var6) {
         this.I_field_d754d74 = var1;
         this.I_field_6acce748 = var2;
         this.i_field_d754d74 = var3;
         this.I_field_5a = var4;
         this.I_field_b4e = var5;
         this.i_field_b4e = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_1b6c2976[projection=" + this.I_field_d754d74 + ", projectionType=" + this.I_field_6acce748 + ", modelView=" + this.i_field_d754d74 + ", scissorEnabled=" + this.I_field_5a + ", scissorBox=" + this.I_field_b4e + ", viewport=" + this.i_field_b4e + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_6acce748);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_d754d74);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_b4e);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_b4e);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiIiIi_Class22.Nested1_1b6c2976 other = (IIIiIiIi_Class22.Nested1_1b6c2976) var1;
         return java.util.Objects.equals(this.I_field_d754d74, other.I_field_d754d74)
            && java.util.Objects.equals(this.I_field_6acce748, other.I_field_6acce748)
            && java.util.Objects.equals(this.i_field_d754d74, other.i_field_d754d74)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_b4e, other.I_field_b4e)
            && java.util.Objects.equals(this.i_field_b4e, other.i_field_b4e);
      }

      public Matrix4f I_method_30051a2() {
         return this.I_field_d754d74;
      }

      public ProjectionType I_method_b139c176() {
         return this.I_field_6acce748;
      }

      public Matrix4f i_method_d3b7a582() {
         return this.i_field_d754d74;
      }

      public boolean I_method_eacb5408() {
         return this.I_field_5a;
      }

      public int[] I_method_6e9f2d60() {
         return this.I_field_b4e;
      }

      public int[] i_method_70621d80() {
         return this.i_field_b4e;
      }
   }

   static final class Nested1_85037d33 {
      private final IIIiIiIi_Class22.Nested1_85037d53 I_field_997a5d7c;
      private final IIIiIiIi_Class22.Nested1_1b6c2976 I_field_95d0dbd1;
      private int[] I_field_b4e;
      private Matrix4f I_field_d754d74;
      private ProjectionType I_field_6acce748;
      private final int[] i_field_b4e = new int[4];

      Nested1_85037d33(IIIiIiIi_Class22.Nested1_85037d53 var1, IIIiIiIi_Class22.Nested1_1b6c2976 var2) {
         this.I_field_997a5d7c = var1;
         this.I_field_95d0dbd1 = var2;
      }

      void I_method_cc53ce67() {
         if (IIIiIiIi_Class22.i_field_5a) {
            this.Ii_method_be4381ba();

            try {
               this.I_field_b4e = this.I_field_997a5d7c.I_method_5aed677d();
               if (this.I_field_b4e != null && IIIiIiIi_Class22.ii_field_49 < 256) {
                  IIIiIiIi_Class22.I_method_dd063c7a(this.I_field_b4e);
                  int var1 = IIIiIiIi_Class22.ii_field_49 * 4;
                  IIIiIiIi_Class22.I_field_b4e[var1] = this.I_field_b4e[0];
                  IIIiIiIi_Class22.I_field_b4e[var1 + 1] = this.I_field_b4e[1];
                  IIIiIiIi_Class22.I_field_b4e[var1 + 2] = this.I_field_b4e[2];
                  IIIiIiIi_Class22.I_field_b4e[var1 + 3] = this.I_field_b4e[3];
                  IIIiIiIi_Class22.i_field_b4e[IIIiIiIi_Class22.ii_field_49] = IIIiIiIi_Class22.III_field_49;
                  IIIiIiIi_Class22.ii_field_49++;
                  return;
               }

               this.I_field_b4e = null;
            } finally {
               this.iI_method_bff7e5fa();
            }
         }
      }

      void i_method_cc625a47() {
         if (this.I_field_b4e != null) {
            this.Ii_method_be4381ba();
            IIIiIiIi_Class22.II_field_5a = true;

            try {
               IIIiIiIi_Class22.I_field_cb35e4c.beginWrite(false);
               GlStateManager._enableScissorTest();
               GlStateManager._scissorBox(this.I_field_b4e[0], this.I_field_b4e[1], this.I_field_b4e[2], this.I_field_b4e[3]);
               this.I_field_997a5d7c.I_method_2eee247();
            } finally {
               iIIiIIiIi_Class294.I_field_3a9bda27.getFramebuffer().beginWrite(false);
               IIIiIiIi_Class22.II_field_5a = false;
               this.iI_method_bff7e5fa();
            }
         }
      }

      void II_method_be34f5da() {
         this.Ii_method_be4381ba();

         try {
            this.I_field_997a5d7c.i_method_2fd6e27();
         } finally {
            this.iI_method_bff7e5fa();
         }
      }

      private void Ii_method_be4381ba() {
         this.I_field_d754d74 = RenderSystem.getProjectionMatrix();
         this.I_field_6acce748 = RenderSystem.getProjectionType();
         RenderSystem.setProjectionMatrix(this.I_field_95d0dbd1.I_method_30051a2(), this.I_field_95d0dbd1.I_method_b139c176());
         GL11.glGetIntegerv(2978, this.i_field_b4e);
         int[] var1 = this.I_field_95d0dbd1.i_method_70621d80();
         if (!Arrays.equals(this.i_field_b4e, var1)) {
            RenderSystem.viewport(var1[0], var1[1], var1[2], var1[3]);
            if (IIIiIiIi_Class22.Iii_field_49 < 3) {
               IIIiIiIi_Class22.Iii_field_49++;
               RockstarClient.I_field_ab0f6068
                  .warn(
                     "[CaptureBypass] \u043e\u0431\u043b\u0430\u0441\u0442\u044c \u0432\u044b\u0432\u043e\u0434\u0430 \u0440\u0430\u0437\u044a\u0435\u0445\u0430\u043b\u0430\u0441\u044c: \u0431\u044b\u043b\u043e {}, \u0441\u0442\u0430\u043b\u043e {}",
                     Arrays.toString(var1),
                     Arrays.toString(this.i_field_b4e)
                  );
            }
         }

         Matrix4fStack var2 = RenderSystem.getModelViewStack();
         var2.pushMatrix();
         var2.set(this.I_field_95d0dbd1.i_method_d3b7a582());
         if (this.I_field_95d0dbd1.I_method_eacb5408()) {
            GlStateManager._enableScissorTest();
            GlStateManager._scissorBox(
               this.I_field_95d0dbd1.I_method_6e9f2d60()[0],
               this.I_field_95d0dbd1.I_method_6e9f2d60()[1],
               this.I_field_95d0dbd1.I_method_6e9f2d60()[2],
               this.I_field_95d0dbd1.I_method_6e9f2d60()[3]
            );
         } else {
            GlStateManager._disableScissorTest();
         }
      }

      private void iI_method_bff7e5fa() {
         GlStateManager._disableScissorTest();
         RenderSystem.getModelViewStack().popMatrix();
         RenderSystem.setProjectionMatrix(this.I_field_d754d74, this.I_field_6acce748);
         RenderSystem.viewport(this.i_field_b4e[0], this.i_field_b4e[1], this.i_field_b4e[2], this.i_field_b4e[3]);
      }
   }

   public interface Nested1_85037d53 {
      int[] I_method_5aed677d();

      void I_method_2eee247();

      void i_method_2fd6e27();
   }
}
