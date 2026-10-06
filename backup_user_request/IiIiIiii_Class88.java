package rockstar.client;

import com.google.gson.JsonObject;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.client.util.InputUtil.Type;
import org.lwjgl.glfw.GLFW;
import pyrock.events.window.CharTypedEvent;
import pyrock.events.window.KeyEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseButtonEvent;
import pyrock.events.window.MouseEvent;
import pyrock.events.window.MouseScrollEvent;
import pyrock.events.window.ScrollEvent;

public final class IiIiIiii_Class88 {
   private static final ScheduledExecutorService I_field_47254ffa = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Rockstar-MCP-Input");
      var1.setDaemon(true);
      return var1;
   });
   private static final ConcurrentLinkedQueue<CompletableFuture<NativeImage>> I_field_f9b6e186 = new ConcurrentLinkedQueue<>();
   private static volatile int I_field_49;
   private static volatile int i_field_49;

   private IiIiIiii_Class88() {
   }

   public static void I_method_84902c6c() {
      CompletableFuture var0;
      while ((var0 = I_field_f9b6e186.poll()) != null) {
         try {
            var0.complete(ScreenshotRecorder.takeScreenshot(iIIiIIiIi_Class294.I_field_3a9bda27.getFramebuffer()));
         } catch (Throwable var2) {
            var0.completeExceptionally(var2);
         }
      }
   }

   public static IiIiIiii_Class88.Nested1_d9fe933 I_method_3133ee93(int var0, String var1, float var2) {
      CompletableFuture var3 = new CompletableFuture();
      I_field_f9b6e186.add(var3);

      NativeImage var4;
      try {
         var4 = (NativeImage)var3.get(5L, TimeUnit.SECONDS);
      } catch (Exception var14) {
         I_field_f9b6e186.remove(var3);
         throw new IiIiiIII_Class89.Nested1_426908f3(
            -32603,
            "\u0438\u0433\u0440\u0430 \u043d\u0435 \u043e\u0442\u0434\u0430\u043b\u0430 \u043a\u0430\u0434\u0440 \u2014 \u043e\u043a\u043d\u043e \u0441\u0432\u0451\u0440\u043d\u0443\u0442\u043e \u0438\u043b\u0438 \u0438\u0433\u0440\u0430 \u043d\u0435 \u0440\u0438\u0441\u0443\u0435\u0442"
         );
      }

      IiIiIiii_Class88.Nested1_d9fe933 var19;
      try {
         int var5 = var4.getWidth();
         int var6 = var4.getHeight();
         BufferedImage var7 = new BufferedImage(var5, var6, 1);

         for (int var8 = 0; var8 < var6; var8++) {
            for (int var9 = 0; var9 < var5; var9++) {
               var7.setRGB(var9, var8, var4.getColorArgb(var9, var8));
            }
         }

         BufferedImage var16 = var7;
         if (var0 > 0 && var5 > var0) {
            int var17 = Math.max(1, Math.round(var6 * ((float)var0 / var5)));
            var16 = new BufferedImage(var0, var17, 1);
            Graphics2D var10 = var16.createGraphics();
            var10.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            var10.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            var10.drawImage(var7, 0, 0, var0, var17, null);
            var10.dispose();
         }

         I_field_49 = var16.getWidth();
         i_field_49 = var16.getHeight();
         boolean var18 = "png".equalsIgnoreCase(var1);
         var19 = new IiIiIiii_Class88.Nested1_d9fe933(
            var18 ? I_method_e4c4ffcc(var16) : I_method_b3e7700e(var16, var2),
            var18 ? "image/png" : "image/jpeg",
            var16.getWidth(),
            var16.getHeight(),
            var5,
            var6
         );
      } finally {
         var4.close();
      }

      return var19;
   }

   private static byte[] I_method_e4c4ffcc(BufferedImage var0) {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream(262144);
         if (!ImageIO.write(var0, "png", var1)) {
            throw new IiIiiIII_Class89.Nested1_426908f3(-32603, "\u043d\u0435\u0442 PNG-\u043a\u043e\u0434\u0438\u0440\u043e\u0432\u0449\u0438\u043a\u0430");
         } else {
            return var1.toByteArray();
         }
      } catch (Exception var2) {
         throw new IiIiiIII_Class89.Nested1_426908f3(
            -32603, "\u043d\u0435 \u0437\u0430\u043a\u043e\u0434\u0438\u0440\u043e\u0432\u0430\u043b PNG: " + var2.getMessage()
         );
      }
   }

   private static byte[] I_method_b3e7700e(BufferedImage var0, float var1) {
      Iterator var2 = ImageIO.getImageWritersByFormatName("jpeg");
      if (!var2.hasNext()) {
         return I_method_e4c4ffcc(var0);
      } else {
         ImageWriter var3 = (ImageWriter)var2.next();

         byte[] var18;
         try {
            ByteArrayOutputStream var4 = new ByteArrayOutputStream(131072);
            ImageWriteParam var5 = var3.getDefaultWriteParam();
            if (var5.canWriteCompressed()) {
               var5.setCompressionMode(2);
               var5.setCompressionQuality(Math.max(0.1F, Math.min(1.0F, var1)));
            }

            try (MemoryCacheImageOutputStream var6 = new MemoryCacheImageOutputStream(var4)) {
               var3.setOutput(var6);
               var3.write(null, new IIOImage(var0, null, null), var5);
            }

            var18 = var4.toByteArray();
         } catch (Exception var16) {
            throw new IiIiiIII_Class89.Nested1_426908f3(
               -32603, "\u043d\u0435 \u0437\u0430\u043a\u043e\u0434\u0438\u0440\u043e\u0432\u0430\u043b JPEG: " + var16.getMessage()
            );
         } finally {
            var3.dispose();
         }

         return var18;
      }
   }

   public static JsonObject I_method_2975ac1c(
      String var0, double var1, double var3, String var5, int var6, double var7, int var9, Double var10, Double var11, String var12
   ) {
      JsonObject var13 = new JsonObject();
      int var14 = I_method_10039329(var5);
      double[] var15 = I_method_ba7f7fa9(var1, var3, var12);
      var13.addProperty("guiX", I_method_d75c140(var15[0]));
      var13.addProperty("guiY", I_method_d75c140(var15[1]));
      String var16 = var0 == null ? "click" : var0.toLowerCase(Locale.ROOT);
      switch (var16) {
         case "move":
            I_method_aeb72bbc(var13, I_method_a142c930(var15[0], var15[1]));
            var13.addProperty("done", "\u043a\u0443\u0440\u0441\u043e\u0440 \u043f\u0435\u0440\u0435\u0434\u0432\u0438\u043d\u0443\u0442");
            break;
         case "click":
            I_method_aeb72bbc(var13, I_method_a142c930(var15[0], var15[1]));

            for (int var19 = 0; var19 < Math.max(1, var6); var19++) {
               I_method_5bc38e8c(var15[0], var15[1], var14, var9);
            }

            var13.addProperty("done", "\u043a\u043b\u0438\u043a " + I_method_acc1f169(var14) + " \u00d7" + Math.max(1, var6));
            break;
         case "drag":
            if (var10 == null || var11 == null) {
               throw new IiIiiIII_Class89.Nested1_426908f3("\u0434\u043b\u044f drag \u043d\u0443\u0436\u043d\u044b to_x \u0438 to_y");
            }

            double[] var18 = I_method_ba7f7fa9(var10, var11, var12);
            I_method_1c65fa97(var15[0], var15[1], var18[0], var18[1], var14);
            var13.addProperty(
               "done", "\u043f\u0435\u0440\u0435\u0442\u0430\u0449\u0435\u043d\u043e \u0432 " + I_method_d75c140(var18[0]) + ", " + I_method_d75c140(var18[1])
            );
            break;
         case "scroll":
            I_method_8716bc92(var15[0], var15[1], var7);
            var13.addProperty("done", "\u043f\u0440\u043e\u043a\u0440\u0443\u0442\u043a\u0430 " + var7);
            break;
         default:
            throw new IiIiiIII_Class89.Nested1_426908f3(
               "\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435 \u043c\u044b\u0448\u0438 \u0431\u044b\u0432\u0430\u0435\u0442 move, click, drag, scroll"
            );
      }

      var13.add("screen", IiIiiIIi_Class90.iI_method_5d7d01ad());
      return var13;
   }

   private static void I_method_aeb72bbc(JsonObject var0, boolean var1) {
      var0.addProperty("cursorMoved", var1);
      if (!var1) {
         var0.addProperty(
            "cursorNote",
            "\u043e\u043a\u043d\u043e \u0438\u0433\u0440\u044b \u043d\u0435 \u0432 \u0444\u043e\u043a\u0443\u0441\u0435 \u0438\u043b\u0438 \u043a\u0443\u0440\u0441\u043e\u0440 \u0437\u0430\u0445\u0432\u0430\u0447\u0435\u043d: \u043a\u043b\u0438\u043a \u0434\u043e\u0441\u0442\u0430\u0432\u043b\u0435\u043d \u043d\u0430\u043f\u0440\u044f\u043c\u0443\u044e, \u043d\u043e \u043d\u0430\u0432\u0435\u0434\u0435\u043d\u0438\u0435 (\u043f\u043e\u0434\u0441\u0432\u0435\u0442\u043a\u0430 \u043f\u043e\u0434 \u043a\u0443\u0440\u0441\u043e\u0440\u043e\u043c) \u043d\u0435 \u0441\u0440\u0430\u0431\u043e\u0442\u0430\u0435\u0442"
         );
      }
   }

   private static void I_method_5bc38e8c(double var0, double var2, int var4, int var5) {
      Screen var6 = iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen;
      RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseEvent(var4, 1));
      RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseButtonEvent(var4, 1, 0));
      if (var6 != null) {
         var6.mouseMoved(var0, var2);
         var6.mouseClicked(var0, var2, var4);
         if (var5 > 0) {
            I_method_d470cd15(var5, () -> var6.mouseReleased(var0, var2, var4));
         } else {
            var6.mouseReleased(var0, var2, var4);
         }

         RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseButtonEvent(var4, 0, 0));
      } else {
         Key var7 = Type.MOUSE.createFromCode(var4);
         KeyBinding.setKeyPressed(var7, true);
         KeyBinding.onKeyPressed(var7);
         if (var5 > 0) {
            I_method_d470cd15(var5, () -> {
               KeyBinding.setKeyPressed(var7, false);
               RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseButtonEvent(var4, 0, 0));
            });
         } else {
            KeyBinding.setKeyPressed(var7, false);
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseButtonEvent(var4, 0, 0));
         }
      }
   }

   private static void I_method_1c65fa97(double var0, double var2, double var4, double var6, int var8) {
      Screen var9 = iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen;
      if (var9 == null) {
         throw new IiIiiIII_Class89.Nested1_426908f3(
            "\u043f\u0435\u0440\u0435\u0442\u0430\u0441\u043a\u0438\u0432\u0430\u0442\u044c \u043d\u0435\u0447\u0435\u0433\u043e: \u043e\u0442\u043a\u0440\u044b\u0442\u043e\u0433\u043e \u044d\u043a\u0440\u0430\u043d\u0430 \u043d\u0435\u0442"
         );
      } else {
         I_method_a142c930(var0, var2);
         var9.mouseMoved(var0, var2);
         var9.mouseClicked(var0, var2, var8);
         byte var10 = 8;

         for (int var11 = 1; var11 <= var10; var11++) {
            double var12 = var0 + (var4 - var0) * var11 / var10;
            double var14 = var2 + (var6 - var2) * var11 / var10;
            var9.mouseDragged(var12, var14, var8, var12 - var0, var14 - var2);
            var9.mouseMoved(var12, var14);
         }

         I_method_a142c930(var4, var6);
         var9.mouseReleased(var4, var6, var8);
      }
   }

   private static void I_method_8716bc92(double var0, double var2, double var4) {
      RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new MouseScrollEvent(var4));
      RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ScrollEvent(0.0, var4));
      if (iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen != null) {
         iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen.mouseScrolled(var0, var2, 0.0, var4);
      }
   }

   private static boolean I_method_a142c930(double var0, double var2) {
      if (iIIiIIiIi_Class294.I_field_3a9bda27.mouse.isCursorLocked()) {
         return false;
      } else if (GLFW.glfwGetWindowAttrib(iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getHandle(), 131073) != 1) {
         return false;
      } else {
         double var4 = var0 * iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getWidth() / iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaledWidth();
         double var6 = var2 * iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getHeight() / iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaledHeight();
         GLFW.glfwSetCursorPos(iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getHandle(), var4, var6);
         if (iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen != null) {
            iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen.mouseMoved(var0, var2);
         }

         return true;
      }
   }

   public static JsonObject I_method_1ffe9e1a(String var0, String var1, String var2, List<String> var3, int var4) {
      JsonObject var5 = new JsonObject();
      String var6 = var0 == null ? "press" : var0.toLowerCase(Locale.ROOT);
      switch (var6) {
         case "press":
            int var8 = iIIIIIIIi_Class258.I_method_dc7f39fc(var1);
            if (var8 == -1) {
               throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435 \u0437\u043d\u0430\u044e \u043a\u043b\u0430\u0432\u0438\u0448\u0443 \"" + var1 + "\"");
            }

            I_method_875f8ab7(var8, I_method_49506150(var3), var4);
            var5.addProperty("done", "\u043d\u0430\u0436\u0430\u0442\u0430 " + var1);
            break;
         case "type":
            if (var2 == null || var2.isEmpty()) {
               throw new IiIiiIII_Class89.Nested1_426908f3("\u043d\u0435\u0447\u0435\u0433\u043e \u043f\u0435\u0447\u0430\u0442\u0430\u0442\u044c");
            }

            I_method_10039336(var2);
            var5.addProperty(
               "done", "\u043d\u0430\u043f\u0435\u0447\u0430\u0442\u0430\u043d\u043e " + var2.length() + " \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432"
            );
            break;
         default:
            throw new IiIiiIII_Class89.Nested1_426908f3(
               "\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435 \u043a\u043b\u0430\u0432\u0438\u0430\u0442\u0443\u0440\u044b \u0431\u044b\u0432\u0430\u0435\u0442 press \u0438\u043b\u0438 type"
            );
      }

      var5.add("screen", IiIiiIIi_Class90.iI_method_5d7d01ad());
      return var5;
   }

   private static void I_method_875f8ab7(int var0, int var1, int var2) {
      RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new KeyPressEvent(1, var0));
      RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new KeyEvent(var0, 0, 1, var1));
      Screen var3 = iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen;
      if (var3 != null) {
         var3.keyPressed(var0, 0, var1);
         Runnable var6 = () -> {
            var3.keyReleased(var0, 0, var1);
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new KeyPressEvent(0, var0));
         };
         if (var2 > 0) {
            I_method_d470cd15(var2, var6);
         } else {
            var6.run();
         }
      } else {
         Key var4 = InputUtil.fromKeyCode(var0, 0);
         KeyBinding.setKeyPressed(var4, true);
         KeyBinding.onKeyPressed(var4);
         Runnable var5 = () -> {
            KeyBinding.setKeyPressed(var4, false);
            RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new KeyPressEvent(0, var0));
         };
         if (var2 > 0) {
            I_method_d470cd15(var2, var5);
         } else {
            var5.run();
         }
      }
   }

   private static void I_method_10039336(String var0) {
      Screen var1 = iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen;

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new CharTypedEvent(var3, 0));
         if (var1 != null) {
            var1.charTyped(var3, 0);
         }
      }
   }

   private static double[] I_method_ba7f7fa9(double var0, double var2, String var4) {
      int var5 = iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getFramebufferWidth();
      int var6 = iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getFramebufferHeight();
      double var7 = iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaledWidth();
      double var9 = iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaledHeight();
      String var11 = var4 != null && !var4.isBlank() ? var4.toLowerCase(Locale.ROOT) : "image";

      return switch (var11) {
         case "gui" -> new double[]{var0, var2};
         case "pixels", "frame" -> new double[]{var0 * var7 / var5, var2 * var9 / var6};
         default -> {
            int var14 = I_field_49 > 0 ? I_field_49 : var5;
            int var15 = i_field_49 > 0 ? i_field_49 : var6;
            yield new double[]{var0 * var7 / var14, var2 * var9 / var15};
         }
      };
   }

   private static int I_method_10039329(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.toLowerCase(Locale.ROOT);

         return switch (var1) {
            case "right", "rmb", "2" -> 1;
            case "middle", "mmb", "3" -> 2;
            case "left", "lmb", "1", "0" -> 0;
            default -> throw new IiIiiIII_Class89.Nested1_426908f3(
               "\u043a\u043d\u043e\u043f\u043a\u0430 \u0431\u044b\u0432\u0430\u0435\u0442 left, right \u0438\u043b\u0438 middle"
            );
         };
      } else {
         return 0;
      }
   }

   private static String I_method_acc1f169(int var0) {
      return switch (var0) {
         case 1 -> "right";
         case 2 -> "middle";
         default -> "left";
      };
   }

   private static int I_method_49506150(List<String> var0) {
      byte var1 = 0;
      if (var0 == null) {
         return var1;
      } else {
         for (String var3 : var0) {
            String var4 = var3.toLowerCase(Locale.ROOT);

            var1 |= switch (var4) {
               case "shift" -> 1;
               case "ctrl", "control" -> 2;
               case "alt" -> 4;
               case "super", "win", "cmd" -> 8;
               default -> 0;
            };
         }

         return var1;
      }
   }

   private static void I_method_d470cd15(int var0, Runnable var1) {
      I_field_47254ffa.schedule(() -> iIIiIIiIi_Class294.I_field_3a9bda27.execute(var1), (long)Math.min(var0, 5000), TimeUnit.MILLISECONDS);
   }

   private static double I_method_d75c140(double var0) {
      return Math.round(var0 * 10.0) / 10.0;
   }

   public static final class Nested1_d9fe933 {
      private final byte[] I_field_b47;
      private final String I_field_523beb0a;
      private final int I_field_49;
      private final int i_field_49;
      private final int II_field_49;
      private final int Ii_field_49;

      public Nested1_d9fe933(byte[] var1, String var2, int var3, int var4, int var5, int var6) {
         this.I_field_b47 = var1;
         this.I_field_523beb0a = var2;
         this.I_field_49 = var3;
         this.i_field_49 = var4;
         this.II_field_49 = var5;
         this.Ii_field_49 = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_d9fe933[bytes=" + this.I_field_b47 + ", mime=" + this.I_field_523beb0a + ", width=" + this.I_field_49 + ", height=" + this.i_field_49 + ", frameWidth=" + this.II_field_49 + ", frameHeight=" + this.Ii_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_b47);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiIiii_Class88.Nested1_d9fe933 other = (IiIiIiii_Class88.Nested1_d9fe933) var1;
         return java.util.Objects.equals(this.I_field_b47, other.I_field_b47)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49)
            && java.util.Objects.equals(this.Ii_field_49, other.Ii_field_49);
      }

      public byte[] I_method_82c16b56() {
         return this.I_field_b47;
      }

      public String I_method_a0314d19() {
         return this.I_field_523beb0a;
      }

      public int I_method_909ae25a() {
         return this.I_field_49;
      }

      public int i_method_90a96e3a() {
         return this.i_field_49;
      }

      public int II_method_82d061cd() {
         return this.II_field_49;
      }

      public int Ii_method_82deedad() {
         return this.Ii_field_49;
      }
   }
}
