package pyrock.utility.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import pyrock.events.render.Render3DEvent;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIiIi_Class246;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiii_Class296;
import rockstar.client.iIiiIIiII_Class357;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiiIii_Class380;

public final class PyShader implements AutoCloseable, iIIiIIiIi_Class294, iIIiIIiii_Class296 {
   public static final int MAX_PER_SCRIPT = 32;
   private static final int MAX_SOURCE_LENGTH = 262144;
   private static final Matrix4f IDENTITY = new Matrix4f();
   private static final long START = System.nanoTime();
   private static final int POSITION_UV = 5;
   private static final int POSITION_UV_COLOR = 9;
   private static final int MAX_VERTICES = 262144;
   private static int meshVao;
   private static int meshVbo;
   private static iIiiIIiII_Class357 scratch;
   private static String header;
   private static String vertexHeader;
   private static final Pattern IMPORT = Pattern.compile("(?m)^[ \\t]*#moj_import[ \\t]*<rockstar:([\\w.]+)>[ \\t]*$");
   private final String name;
   private final String vertexSource;
   private final String fragmentSource;
   private final Map<String, Integer> locations = new HashMap<>();
   private final Map<String, float[]> floats = new LinkedHashMap<>();
   private final Map<String, int[]> ints = new LinkedHashMap<>();
   private final Map<String, Matrix4f> matrices = new LinkedHashMap<>();
   private final Map<Integer, Object> textures = new LinkedHashMap<>();
   private int programId;
   private boolean disposed;

   public PyShader(String var1, String var2, String var3) {
      if (var3 != null && !var3.isBlank()) {
         if (var3.length() <= 262144 && (var2 == null || var2.length() <= 262144)) {
            if (!RenderSystem.isOnRenderThread()) {
               throw new IllegalStateException(
                  "\u0448\u0435\u0439\u0434\u0435\u0440 \u043a\u043e\u043c\u043f\u0438\u043b\u0438\u0440\u0443\u0435\u0442\u0441\u044f \u0442\u043e\u043b\u044c\u043a\u043e \u043d\u0430 \u0433\u043b\u0430\u0432\u043d\u043e\u043c \u043f\u043e\u0442\u043e\u043a\u0435 \u0438\u0433\u0440\u044b"
               );
            } else {
               this.name = var1 != null && !var1.isBlank() ? var1 : "shader";
               this.vertexSource = var2 != null && !var2.isBlank() ? var2 : defaultVertex();
               this.fragmentSource = var3;
               guardEndlessLoop(this.vertexSource);
               guardEndlessLoop(this.fragmentSource);
               this.programId = this.link(this.prepare(this.vertexSource, false), this.prepare(this.fragmentSource, true));
            }
         } else {
            throw new IllegalArgumentException("shader source is too large");
         }
      } else {
         throw new IllegalArgumentException("shader needs a fragment source");
      }
   }

   public String name() {
      return this.name;
   }

   public String vertexSource() {
      return this.vertexSource;
   }

   public String fragmentSource() {
      return this.fragmentSource;
   }

   public boolean valid() {
      return !this.disposed && this.programId != 0;
   }

   public PyShader set(String var1, float var2) {
      this.floats.put(var1, new float[]{var2});
      return this;
   }

   public PyShader set(String var1, float var2, float var3) {
      this.floats.put(var1, new float[]{var2, var3});
      return this;
   }

   public PyShader set(String var1, float var2, float var3, float var4) {
      this.floats.put(var1, new float[]{var2, var3, var4});
      return this;
   }

   public PyShader set(String var1, float var2, float var3, float var4, float var5) {
      this.floats.put(var1, new float[]{var2, var3, var4, var5});
      return this;
   }

   public PyShader setInt(String var1, int var2) {
      this.ints.put(var1, new int[]{var2});
      return this;
   }

   public PyShader setMatrix(String var1, Matrix4f var2) {
      if (var2 != null) {
         this.matrices.put(var1, new Matrix4f(var2));
      }

      return this;
   }

   public PyShader setColor(String var1, ColorRGBA var2) {
      return var2 == null ? this : this.set(var1, var2.getRed() / 255.0F, var2.getGreen() / 255.0F, var2.getBlue() / 255.0F, var2.getAlpha() / 255.0F);
   }

   public PyShader texture(int var1, Object var2) {
      if (var1 >= 0 && var1 <= 7) {
         if (var2 == null) {
            this.textures.remove(var1);
         } else {
            this.textures.put(var1, var2);
         }

         return this;
      } else {
         throw new IllegalArgumentException("texture unit out of range: " + var1);
      }
   }

   public void rect(DrawContext var1, float var2, float var3, float var4, float var5) {
      if (this.valid() && !(var4 <= 0.0F) && !(var5 <= 0.0F)) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         Matrix4f var6 = var1 == null ? IDENTITY : var1.getMatrices().peek().getPositionMatrix();
         float[] var7 = this.quad(var6, var2, var3, var4, var5, 0.0F, 0.0F, 1.0F, 1.0F);
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         this.bind();
         this.builtin("Size", var4, var5);
         this.builtin("ModelViewMat", RenderSystem.getModelViewMatrix());
         this.builtin("ProjMat", RenderSystem.getProjectionMatrix());
         this.applyUniforms();
         drawQuad(var7);
         this.unbind();
         RenderSystem.disableBlend();
      }
   }

   public void fullscreen(Render3DEvent var1) {
      if (this.valid()) {
         Framebuffer var2 = I_field_3a9bda27.getFramebuffer();
         if (var2 != null) {
            int var3 = I_field_587075c2.getScaledWidth();
            int var4 = I_field_587075c2.getScaledHeight();
            if (var3 > 0 && var4 > 0) {
               if (scratch == null) {
                  scratch = new iIiiIIiII_Class357(false).I_method_cc37aab5();
               }

               RenderSystem.disableBlend();
               RenderSystem.depthMask(false);
               RenderSystem.backupProjectionMatrix();
               RenderSystem.setProjectionMatrix(new Matrix4f().setOrtho(0.0F, var3, var4, 0.0F, 1000.0F, 21000.0F), ProjectionType.ORTHOGRAPHIC);
               Matrix4fStack var5 = RenderSystem.getModelViewStack();
               var5.pushMatrix();
               var5.identity().translate(0.0F, 0.0F, -11000.0F);

               try {
                  scratch.I_method_53fdf4b5(false);
                  this.bind();
                  this.builtin("Size", var3, var4);
                  this.builtin("ModelViewMat", RenderSystem.getModelViewMatrix());
                  this.builtin("ProjMat", RenderSystem.getProjectionMatrix());
                  if (var1 != null) {
                     this.builtin("InvViewProj", new Matrix4f(var1.getProjectionMatrix()).mul(var1.getPositionMatrix()).invert());
                     if (var1.getCamera() != null) {
                        Vector3f var6 = var1.getCamera().getPos().toVector3f();
                        this.builtin("CamPos", var6.x, var6.y, var6.z);
                     }
                  }

                  this.bindTexture(0, var2.getColorAttachment());
                  if (var2.getDepthAttachment() != 0) {
                     this.bindTexture(1, var2.getDepthAttachment());
                  }

                  this.applyUniforms();
                  drawQuad(this.quad(IDENTITY, 0.0F, 0.0F, var3, var4, 0.0F, 1.0F, 1.0F, 0.0F));
                  this.unbind();
                  scratch.i_method_766109df();
                  RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                  scratch.beginRead();
                  RenderSystem.setShaderTexture(0, scratch.getColorAttachment());
                  iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, var3, var4);
                  scratch.endRead();
                  RenderSystem.setShaderTexture(0, 0);
               } finally {
                  var5.popMatrix();
                  RenderSystem.restoreProjectionMatrix();
                  RenderSystem.depthMask(true);
                  RenderSystem.enableBlend();
                  RenderSystem.defaultBlendFunc();
               }
            }
         }
      }
   }

   public void quad3d(Render3DEvent var1, double var2, double var4, double var6, float var8, float var9, String var10, boolean var11, boolean var12) {
      if (this.valid() && var1 != null && var1.getCamera() != null && !(var8 <= 0.0F) && !(var9 <= 0.0F)) {
         Vector3f var13 = var1.getCamera().getPos().toVector3f().negate().add((float)var2, (float)var4, (float)var6);
         Vector3f var14 = new Vector3f();
         Vector3f var15 = new Vector3f();
         this.axes(var1, var10, var14, var15);
         var14.mul(var8 * 0.5F);
         var15.mul(var9 * 0.5F);
         Matrix4f var16 = var1.getMatrices().peek().getPositionMatrix();
         float[] var17 = new float[20];
         this.corner(var17, 0, var16, var13, var14, var15, -1.0F, 1.0F, 0.0F, 0.0F);
         this.corner(var17, 5, var16, var13, var14, var15, -1.0F, -1.0F, 0.0F, 1.0F);
         this.corner(var17, 10, var16, var13, var14, var15, 1.0F, 1.0F, 1.0F, 0.0F);
         this.corner(var17, 15, var16, var13, var14, var15, 1.0F, -1.0F, 1.0F, 1.0F);
         RenderSystem.enableBlend();
         if (var11) {
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
         } else {
            RenderSystem.defaultBlendFunc();
         }

         RenderSystem.disableCull();
         RenderSystem.depthMask(false);
         if (var12) {
            RenderSystem.enableDepthTest();
         } else {
            RenderSystem.disableDepthTest();
         }

         this.bind();
         this.builtin("Size", var8, var9);
         this.builtin("ModelViewMat", RenderSystem.getModelViewMatrix());
         this.builtin("ProjMat", RenderSystem.getProjectionMatrix());
         this.builtin("InvViewProj", new Matrix4f(var1.getProjectionMatrix()).mul(var1.getPositionMatrix()).invert());
         this.applyUniforms();
         drawQuad(var17);
         this.unbind();
         RenderSystem.depthMask(true);
         RenderSystem.enableDepthTest();
         RenderSystem.enableCull();
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
      }
   }

   public void mesh3d(
      Render3DEvent var1, Object var2, double var3, double var5, double var7, String var9, boolean var10, boolean var11, boolean var12, boolean var13
   ) {
      if (this.valid() && var1 != null && var1.getCamera() != null) {
         float[] var14 = floats(var2);
         int var15 = var10 ? 9 : 5;
         if (var14.length >= var15) {
            if (var14.length / var15 > 262144) {
               throw new IllegalArgumentException(
                  "\u0432 \u043c\u0435\u0448\u0435 \u0431\u043e\u043b\u044c\u0448\u0435 262144 \u0432\u0435\u0440\u0448\u0438\u043d"
               );
            } else {
               Vec3d var16 = var1.getCamera().getPos();
               Matrix4f var17 = new Matrix4f(RenderSystem.getModelViewMatrix())
                  .mul(var1.getMatrices().peek().getPositionMatrix())
                  .translate((float)(var3 - var16.x), (float)(var5 - var16.y), (float)(var7 - var16.z));
               RenderSystem.enableBlend();
               if (var11) {
                  RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
               } else {
                  RenderSystem.defaultBlendFunc();
               }

               if (var13) {
                  RenderSystem.enableCull();
               } else {
                  RenderSystem.disableCull();
               }

               RenderSystem.depthMask(false);
               if (var12) {
                  RenderSystem.enableDepthTest();
               } else {
                  RenderSystem.disableDepthTest();
               }

               this.bind();
               this.builtin("Size", 1.0F, 1.0F);
               this.builtin("ModelViewMat", var17);
               this.builtin("ProjMat", RenderSystem.getProjectionMatrix());
               this.builtin("InvViewProj", new Matrix4f(var1.getProjectionMatrix()).mul(var1.getPositionMatrix()).invert());
               this.applyUniforms();
               draw(var14, var15, primitive(var9));
               this.unbind();
               RenderSystem.depthMask(true);
               RenderSystem.enableDepthTest();
               RenderSystem.enableCull();
               RenderSystem.defaultBlendFunc();
               RenderSystem.disableBlend();
            }
         }
      }
   }

   public void mesh2d(DrawContext var1, Object var2, String var3, boolean var4) {
      if (this.valid()) {
         float[] var5 = floats(var2);
         int var6 = var4 ? 9 : 5;
         if (var5.length >= var6) {
            if (var5.length / var6 > 262144) {
               throw new IllegalArgumentException(
                  "\u0432 \u043c\u0435\u0448\u0435 \u0431\u043e\u043b\u044c\u0448\u0435 262144 \u0432\u0435\u0440\u0448\u0438\u043d"
               );
            } else {
               iIiiiiIii_Class380.I_method_5f4b621f();
               Matrix4f var7 = new Matrix4f(RenderSystem.getModelViewMatrix());
               if (var1 != null) {
                  var7.mul(var1.getMatrices().peek().getPositionMatrix());
               }

               RenderSystem.enableBlend();
               RenderSystem.defaultBlendFunc();
               this.bind();
               this.builtin("Size", I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
               this.builtin("ModelViewMat", var7);
               this.builtin("ProjMat", RenderSystem.getProjectionMatrix());
               this.applyUniforms();
               draw(var5, var6, primitive(var3));
               this.unbind();
               RenderSystem.disableBlend();
            }
         }
      }
   }

   @Override
   public void close() {
      this.dispose();
   }

   public void dispose() {
      if (!this.disposed) {
         this.disposed = true;
         int var1 = this.programId;
         this.programId = 0;
         if (var1 != 0) {
            if (RenderSystem.isOnRenderThread()) {
               GlStateManager.glDeleteProgram(var1);
            } else {
               I_field_3a9bda27.execute(() -> GlStateManager.glDeleteProgram(var1));
            }
         }
      }
   }

   private void axes(Render3DEvent var1, String var2, Vector3f var3, Vector3f var4) {
      String var5 = var2 == null ? "billboard" : var2.toLowerCase();
      switch (var5) {
         case "ground":
         case "floor":
         case "flat":
            var3.set(1.0F, 0.0F, 0.0F);
            var4.set(0.0F, 0.0F, 1.0F);
            break;
         case "wall":
         case "upright":
         case "yaw":
            float var9 = (float)Math.toRadians(var1.getCamera().getYaw());
            var3.set(-((float)Math.cos(var9)), 0.0F, -((float)Math.sin(var9)));
            var4.set(0.0F, 1.0F, 0.0F);
            break;
         default:
            Quaternionf var8 = var1.getCamera().getRotation();
            var3.set(1.0F, 0.0F, 0.0F).rotate(var8);
            var4.set(0.0F, 1.0F, 0.0F).rotate(var8);
      }
   }

   private void corner(float[] var1, int var2, Matrix4f var3, Vector3f var4, Vector3f var5, Vector3f var6, float var7, float var8, float var9, float var10) {
      Vector4f var11 = new Vector4f(
            var4.x + var5.x * var7 + var6.x * var8, var4.y + var5.y * var7 + var6.y * var8, var4.z + var5.z * var7 + var6.z * var8, 1.0F
         )
         .mul(var3);
      var1[var2] = var11.x;
      var1[var2 + 1] = var11.y;
      var1[var2 + 2] = var11.z;
      var1[var2 + 3] = var9;
      var1[var2 + 4] = var10;
   }

   private float[] quad(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      float[] var10 = new float[20];
      this.point(var10, 0, var1, var2, var3, var6, var7);
      this.point(var10, 5, var1, var2, var3 + var5, var6, var9);
      this.point(var10, 10, var1, var2 + var4, var3, var8, var7);
      this.point(var10, 15, var1, var2 + var4, var3 + var5, var8, var9);
      return var10;
   }

   private void point(float[] var1, int var2, Matrix4f var3, float var4, float var5, float var6, float var7) {
      Vector4f var8 = new Vector4f(var4, var5, 0.0F, 1.0F).mul(var3);
      var1[var2] = var8.x;
      var1[var2 + 1] = var8.y;
      var1[var2 + 2] = var8.z;
      var1[var2 + 3] = var6;
      var1[var2 + 4] = var7;
   }

   private void bind() {
      GlStateManager._glUseProgram(this.programId);
      this.builtin("Time", (float)((System.nanoTime() - START) / 1.0E9 % 3600.0));
      this.builtin("Resolution", I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
      this.builtin("GuiScale", (float)I_field_587075c2.getScaleFactor());
      this.builtin(
         "MousePos",
         (float)(I_field_3a9bda27.mouse.getX() * I_field_587075c2.getScaledWidth() / Math.max(1, I_field_587075c2.getWidth())),
         (float)(I_field_3a9bda27.mouse.getY() * I_field_587075c2.getScaledHeight() / Math.max(1, I_field_587075c2.getHeight()))
      );
   }

   private void unbind() {
      GlStateManager._glBindVertexArray(0);
      GlStateManager._glUseProgram(0);
      GlStateManager._activeTexture(33984);
   }

   private void applyUniforms() {
      for (Entry var2 : this.textures.entrySet()) {
         this.bindTexture((Integer)var2.getKey(), this.glId(var2.getValue()));
      }

      for (Entry var8 : this.floats.entrySet()) {
         int var3 = this.location((String)var8.getKey());
         if (var3 >= 0) {
            float[] var4 = (float[])var8.getValue();
            switch (var4.length) {
               case 1:
                  GL20.glUniform1f(var3, var4[0]);
                  break;
               case 2:
                  GL20.glUniform2f(var3, var4[0], var4[1]);
                  break;
               case 3:
                  GL20.glUniform3f(var3, var4[0], var4[1], var4[2]);
                  break;
               default:
                  GL20.glUniform4f(var3, var4[0], var4[1], var4[2], var4[3]);
            }
         }
      }

      for (Entry var9 : this.ints.entrySet()) {
         int var11 = this.location((String)var9.getKey());
         if (var11 >= 0) {
            GL20.glUniform1i(var11, ((int[])var9.getValue())[0]);
         }
      }

      for (Entry var10 : this.matrices.entrySet()) {
         int var12 = this.location((String)var10.getKey());
         if (var12 >= 0) {
            GL20.glUniformMatrix4fv(var12, false, ((Matrix4f)var10.getValue()).get(new float[16]));
         }
      }
   }

   private void bindTexture(int var1, int var2) {
      if (var2 > 0) {
         GlStateManager._activeTexture(33984 + var1);
         GlStateManager._bindTexture(var2);
         int var3 = this.location("Sampler" + var1);
         if (var3 >= 0) {
            GL20.glUniform1i(var3, var1);
         }

         GlStateManager._activeTexture(33984);
      }
   }

   private int glId(Object var1) {
      if (var1 instanceof Integer var5) {
         return var5;
      } else if (var1 instanceof PyDynamicTexture var4) {
         return this.glId(var4.identifier());
      } else if (var1 instanceof Identifier var2) {
         AbstractTexture var3 = I_field_3a9bda27.getTextureManager().getTexture(var2);
         return var3 == null ? 0 : var3.getGlId();
      } else {
         return 0;
      }
   }

   private void builtin(String var1, float var2) {
      int var3 = this.location(var1);
      if (var3 >= 0) {
         GL20.glUniform1f(var3, var2);
      }
   }

   private void builtin(String var1, float var2, float var3) {
      int var4 = this.location(var1);
      if (var4 >= 0) {
         GL20.glUniform2f(var4, var2, var3);
      }
   }

   private void builtin(String var1, float var2, float var3, float var4) {
      int var5 = this.location(var1);
      if (var5 >= 0) {
         GL20.glUniform3f(var5, var2, var3, var4);
      }
   }

   private void builtin(String var1, Matrix4f var2) {
      int var3 = this.location(var1);
      if (var3 >= 0) {
         GL20.glUniformMatrix4fv(var3, false, var2.get(new float[16]));
      }
   }

   private int location(String var1) {
      return this.locations.computeIfAbsent(var1, var1x -> GlStateManager._glGetUniformLocation(this.programId, var1x));
   }

   private static void drawQuad(float[] var0) {
      draw(var0, 5, 5);
   }

   private static void draw(float[] var0, int var1, int var2) {
      int var3 = var0.length / var1;
      if (var3 > 0) {
         if (!RenderSystem.isOnRenderThread()) {
            throw new IllegalStateException(
               "\u0448\u0435\u0439\u0434\u0435\u0440 \u0440\u0438\u0441\u0443\u0435\u0442\u0441\u044f \u0442\u043e\u043b\u044c\u043a\u043e \u043d\u0430 \u0433\u043b\u0430\u0432\u043d\u043e\u043c \u043f\u043e\u0442\u043e\u043a\u0435 \u0438\u0433\u0440\u044b"
            );
         } else {
            if (meshVao == 0) {
               meshVao = GlStateManager._glGenVertexArrays();
               meshVbo = GlStateManager._glGenBuffers();
            }

            GlStateManager._glBindVertexArray(meshVao);
            GlStateManager._glBindBuffer(34962, meshVbo);
            GL15.glBufferData(34962, var0, 35048);
            int var4 = var1 * 4;
            GL20.glEnableVertexAttribArray(0);
            GL20.glVertexAttribPointer(0, 3, 5126, false, var4, 0L);
            GL20.glEnableVertexAttribArray(1);
            GL20.glVertexAttribPointer(1, 2, 5126, false, var4, 12L);
            if (var1 >= 9) {
               GL20.glEnableVertexAttribArray(2);
               GL20.glVertexAttribPointer(2, 4, 5126, false, var4, 20L);
            } else {
               GL20.glDisableVertexAttribArray(2);
               GL20.glVertexAttrib4f(2, 255.0F, 255.0F, 255.0F, 255.0F);
            }

            GL11.glDrawArrays(var2, 0, var3);
            GlStateManager._glBindBuffer(34962, 0);
         }
      }
   }

   private static int primitive(String var0) {
      String var1 = var0 == null ? "triangles" : var0.toLowerCase();

      return switch (var1) {
         case "triangle_strip", "strip" -> 5;
         case "triangle_fan", "fan" -> 6;
         case "lines" -> 1;
         case "line_strip" -> 3;
         case "line_loop" -> 2;
         case "points" -> 0;
         case "triangles", "tris" -> 4;
         default -> throw new IllegalArgumentException(
            "\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0440\u0435\u0436\u0438\u043c \u043f\u0440\u0438\u043c\u0438\u0442\u0438\u0432\u0430: "
               + var0
         );
      };
   }

   private static float[] floats(Object var0) {
      if (var0 == null) {
         return new float[0];
      } else if (var0 instanceof float[] var8) {
         return var8;
      } else if (var0 instanceof byte[] var7) {
         FloatBuffer var10 = ByteBuffer.wrap(var7).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
         float[] var12 = new float[var10.remaining()];
         var10.get(var12);
         return var12;
      } else if (!(var0 instanceof double[] var1)) {
         if (var0 instanceof List var6) {
            float[] var9 = new float[var6.size()];

            for (int var11 = 0; var11 < var9.length; var11++) {
               if (!(var6.get(var11) instanceof Number var5)) {
                  throw new IllegalArgumentException(
                     "\u0432\u0435\u0440\u0448\u0438\u043d\u044b \u043c\u0435\u0448\u0430 \u044d\u0442\u043e \u0447\u0438\u0441\u043b\u0430"
                  );
               }

               var9[var11] = var5.floatValue();
            }

            return var9;
         } else {
            throw new IllegalArgumentException(
               "\u0432\u0435\u0440\u0448\u0438\u043d\u044b \u043c\u0435\u0448\u0430: \u043f\u043b\u043e\u0441\u043a\u0438\u0439 \u0441\u043f\u0438\u0441\u043e\u043a \u0447\u0438\u0441\u0435\u043b \u0438\u043b\u0438 array('f').tobytes()"
            );
         }
      } else {
         float[] var2 = new float[var1.length];

         for (int var3 = 0; var3 < var1.length; var3++) {
            var2[var3] = (float)var1[var3];
         }

         return var2;
      }
   }

   private int link(String var1, String var2) {
      int var3 = this.compile(35633, var1, "vertex");

      int var4;
      try {
         var4 = this.compile(35632, var2, "fragment");
      } catch (RuntimeException var7) {
         GlStateManager.glDeleteShader(var3);
         throw var7;
      }

      int var5 = GlStateManager.glCreateProgram();
      GlStateManager.glAttachShader(var5, var3);
      GlStateManager.glAttachShader(var5, var4);
      GlStateManager._glBindAttribLocation(var5, 0, "Position");
      GlStateManager._glBindAttribLocation(var5, 1, "UV");
      GlStateManager.glLinkProgram(var5);
      GlStateManager.glDeleteShader(var3);
      GlStateManager.glDeleteShader(var4);
      if (GlStateManager.glGetProgrami(var5, 35714) == 0) {
         String var6 = GlStateManager.glGetProgramInfoLog(var5, 4096);
         GlStateManager.glDeleteProgram(var5);
         throw new RuntimeException(
            "\u0448\u0435\u0439\u0434\u0435\u0440 "
               + this.name
               + " \u043d\u0435 \u0441\u043b\u0438\u043d\u043a\u043e\u0432\u0430\u043b\u0441\u044f: "
               + var6.trim()
         );
      } else {
         return var5;
      }
   }

   private int compile(int var1, String var2, String var3) {
      int var4 = GlStateManager.glCreateShader(var1);
      GlStateManager.glShaderSource(var4, var2);
      GlStateManager.glCompileShader(var4);
      if (GlStateManager.glGetShaderi(var4, 35713) == 0) {
         String var5 = GlStateManager.glGetShaderInfoLog(var4, 4096);
         GlStateManager.glDeleteShader(var4);
         throw new RuntimeException(
            "\u0448\u0435\u0439\u0434\u0435\u0440 "
               + this.name
               + " ("
               + var3
               + ") \u043d\u0435 \u0441\u043e\u0431\u0440\u0430\u043b\u0441\u044f: "
               + var5.trim()
         );
      } else {
         return var4;
      }
   }

   private String prepare(String var1, boolean var2) {
      return hasVersion(var1) ? var1 : (var2 ? this.fragmentHeader() : "#version 150\n") + "\n#line 0\n" + var1;
   }

   private boolean ownVertex() {
      return this.vertexSource.equals(defaultVertex());
   }

   private static boolean hasVersion(String var0) {
      int var1 = 0;
      int var2 = var0.length();

      while (var1 < var2) {
         char var3 = var0.charAt(var1);
         if (Character.isWhitespace(var3)) {
            var1++;
         } else if (var3 != '/' || var1 + 1 >= var2 || var0.charAt(var1 + 1) != '/') {
            if (var3 != '/' || var1 + 1 >= var2 || var0.charAt(var1 + 1) != '*') {
               return var0.startsWith("#version", var1);
            }

            int var5 = var0.indexOf("*/", var1 + 2);
            if (var5 < 0) {
               return false;
            }

            var1 = var5 + 2;
         } else {
            int var4 = var0.indexOf(10, var1);
            if (var4 < 0) {
               return false;
            }

            var1 = var4 + 1;
         }
      }

      return false;
   }

   private String fragmentHeader() {
      if (header == null) {
         header = resource("shaders/scripts/header.fsh") + "\n" + glsl("shaders/include/common.glsl");
      }

      return this.ownVertex() ? header + "\nin vec4 VertexColor;\n" : header;
   }

   private static String glsl(String var0) {
      Matcher var1 = IMPORT.matcher(resource(var0));
      StringBuilder var2 = new StringBuilder();

      while (var1.find()) {
         var1.appendReplacement(var2, Matcher.quoteReplacement(glsl("shaders/include/" + var1.group(1))));
      }

      return var1.appendTail(var2).toString();
   }

   private static String defaultVertex() {
      if (vertexHeader == null) {
         vertexHeader = resource("shaders/scripts/vertex.vsh");
      }

      return vertexHeader;
   }

   private static String resource(String var0) {
      try {
         return IiiiiIiIi_Class246.I_method_a1486a60(RockstarClient.id(var0));
      } catch (Throwable var2) {
         throw new IllegalStateException(
            "\u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f \u0440\u0435\u0441\u0443\u0440\u0441 \u0448\u0435\u0439\u0434\u0435\u0440\u0430 "
               + var0,
            var2
         );
      }
   }

   private static void guardEndlessLoop(String var0) {
      String var1 = var0.replaceAll("\\s+", "");
      if (var1.contains("while(true)") || var1.contains("for(;;)")) {
         throw new IllegalArgumentException(
            "\u0431\u0435\u0441\u043a\u043e\u043d\u0435\u0447\u043d\u044b\u0439 \u0446\u0438\u043a\u043b \u0432 \u0448\u0435\u0439\u0434\u0435\u0440\u0435 \u043f\u043e\u0432\u0435\u0441\u0438\u0442 \u0432\u0438\u0434\u0435\u043e\u0434\u0440\u0430\u0439\u0432\u0435\u0440: \u0434\u0430\u0439\u0442\u0435 \u0441\u0447\u0451\u0442\u0447\u0438\u043a\u0443 \u0446\u0438\u043a\u043b\u0430 \u043f\u0440\u0435\u0434\u0435\u043b"
         );
      }
   }
}
