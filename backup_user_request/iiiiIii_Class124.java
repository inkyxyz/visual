package rockstar.client;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import moscow.rockstar.mixin.accessors.MinecraftClientAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.util.BufferAllocator;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

final class iiiiIii_Class124 {
   private static final int I_field_49 = 176;
   private static final int i_field_49 = 166;
   private static final int II_field_49 = 3;
   private static final int Ii_field_49 = 18;
   private static final int iI_field_49 = 8;
   private static final int ii_field_49 = 84;
   private static final int III_field_49 = 142;
   private static final int IIi_field_49 = 8;
   private static final int IiI_field_49 = 8;
   private static final int Iii_field_49 = 77;
   private static final int iII_field_49 = 62;

   private iiiiIii_Class124() {
   }

   static byte[] I_method_c64ba0bb(ClientPlayerEntity var0) throws IOException {
      MinecraftClient var1 = MinecraftClient.getInstance();
      short var2 = 528;
      short var3 = 498;
      SimpleFramebuffer var4 = new SimpleFramebuffer(var2, var3, true);
      NativeImage var5 = null;

      byte[] var25;
      try {
         var4.setClearColor(0.0F, 0.0F, 0.0F, 1.0F);
         var4.clear();
         RenderSystem.backupProjectionMatrix();
         RenderSystem.setProjectionMatrix(new Matrix4f().setOrtho(0.0F, var2, var3, 0.0F, 1000.0F, 21000.0F), ProjectionType.ORTHOGRAPHIC);
         Matrix4fStack var6 = RenderSystem.getModelViewStack();
         var6.pushMatrix();
         var6.identity().translate(0.0F, 0.0F, -11000.0F);
         Framebuffer var7 = var1.getFramebuffer();
         ((MinecraftClientAccessor)(Object)var1).setFramebuffer(var4);
         var4.beginWrite(true);

         try {
            BufferAllocator var8 = new BufferAllocator(2048);

            try {
               Immediate var9 = VertexConsumerProvider.immediate(var8);
               DrawContext var10 = new DrawContext(var1, var9);
               var10.getMatrices().push();
               var10.getMatrices().scale(3.0F, 3.0F, 1.0F);
               I_method_d3e0a76e(var10, var1, var0.getInventory());
               var10.getMatrices().pop();
               var10.draw();
            } catch (Throwable var22) {
               try {
                  var8.close();
               } catch (Throwable var21) {
                  var22.addSuppressed(var21);
               }

               throw var22;
            }

            var8.close();
         } finally {
            ((MinecraftClientAccessor)(Object)var1).setFramebuffer(var7);
            var4.endWrite();
            var6.popMatrix();
            RenderSystem.restoreProjectionMatrix();
            var7.beginWrite(true);
         }

         var5 = ScreenshotRecorder.takeScreenshot(var4);
         var25 = I_method_2dea25cf(var5);
      } finally {
         if (var5 != null) {
            var5.close();
         }

         var4.delete();
      }

      return var25;
   }

   private static void I_method_d3e0a76e(DrawContext var0, MinecraftClient var1, PlayerInventory var2) {
      var0.drawTexture(RenderLayer::getGuiTextured, HandledScreen.BACKGROUND_TEXTURE, 0, 0, 0.0F, 0.0F, 176, 166, 256, 256);

      for (int var3 = 0; var3 < var2.main.size(); var3++) {
         boolean var4 = var3 < 9;
         int var5 = var4 ? var3 : (var3 - 9) % 9;
         int var6 = var4 ? 0 : (var3 - 9) / 9;
         int var7 = 8 + var5 * 18;
         int var8 = var4 ? 142 : 84 + var6 * 18;
         I_method_b1495c30(var0, var1, (ItemStack)var2.main.get(var3), var7, var8);
      }

      for (int var9 = 0; var9 < var2.armor.size(); var9++) {
         ItemStack var10 = (ItemStack)var2.armor.get(var2.armor.size() - 1 - var9);
         I_method_b1495c30(var0, var1, var10, 8, 8 + var9 * 18);
      }

      if (!var2.offHand.isEmpty()) {
         I_method_b1495c30(var0, var1, (ItemStack)var2.offHand.getFirst(), 77, 62);
      }
   }

   private static void I_method_b1495c30(DrawContext var0, MinecraftClient var1, ItemStack var2, int var3, int var4) {
      if (var2 != null && !var2.isEmpty()) {
         var0.drawItem(var2, var3, var4);
         var0.drawStackOverlay(var1.textRenderer, var2, var3, var4);
      }
   }

   private static byte[] I_method_2dea25cf(NativeImage var0) throws IOException {
      BufferedImage var1 = new BufferedImage(var0.getWidth(), var0.getHeight(), 1);

      for (int var2 = 0; var2 < var0.getHeight(); var2++) {
         for (int var3 = 0; var3 < var0.getWidth(); var3++) {
            var1.setRGB(var3, var2, var0.getColorArgb(var3, var2));
         }
      }

      ByteArrayOutputStream var4 = new ByteArrayOutputStream(65536);
      if (!ImageIO.write(var1, "png", var4)) {
         throw new IOException("PNG encoder not available");
      } else {
         return var4.toByteArray();
      }
   }
}
