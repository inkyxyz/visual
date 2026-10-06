package rockstar.client;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import globals.client.Information;
import java.io.File;
import java.nio.file.Files;
import lombok.Generated;
import net.coobird.thumbnailator.Thumbnails;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.glfw.GLFWDropCallbackI;
import ua.mintantileak.spk.Compile;

public final class IIiiiiii_Class64 implements iIIiIIiIi_Class294 {
   private static boolean I_field_5a;

   @Compile(
      obfuscation = 4
   )
   public static void I_method_b37fb8cc() {
      if (!I_field_5a) {
         I_field_5a = true;
         long var0 = I_field_3a9bda27.getWindow().getHandle();
         GLFWDropCallbackI[] var2 = new GLFWDropCallbackI[1];
         GLFWDropCallbackI var3 = (var1, var3x, var4) -> {
            if (var2[0] != null) {
               var2[0].invoke(var1, var3x, var4);
            }

            for (int var6 = 0; var6 < var3x; var6++) {
               String var7 = GLFWDropCallback.getName(var4, var6);
               I_method_4e8cc796(var7);
            }
         };
         var2[0] = GLFW.glfwSetDropCallback(var0, var3);
      }
   }

   private static void I_method_4e8cc796(String var0) {
      try {
         File var1 = new File(var0);
         if (!var1.isFile()) {
            return;
         }

         if (var1.getName().endsWith(".rock")) {
            JsonElement var2 = JsonParser.parseString(Files.readString(var1.toPath()));
            if (!var2.isJsonObject()) {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("config.delete_error")));
               return;
            }

            String var3 = var1.getName().substring(0, var1.getName().lastIndexOf(46));
            RockstarClient.getInstance().I_method_5198232b().I_method_a9011662(var3, var2.getAsJsonObject());
            iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("config.loaded", var3)));
            RockstarClient.getInstance()
               .I_method_5cb1af22()
               .I_method_8ee48d11(iiiIIII_Class113.I_field_c11fcfcc, Text.translatable("configs.loaded").getString());
         }

         if (var1.getName().endsWith(".png") && Information.getPreferUser() != null) {
            if (!var1.exists()) {
               System.err.println("File not selected or missing.");
               return;
            }

            if (Information.getPreferUser().password() == null) {
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("rocknet.avatar.site_only")));
               return;
            }

            File var7 = new File(System.getProperty("java.io.tmpdir"));
            File var8 = new File(var7, "avatar.png");
            Thumbnails.of(new File[]{var1}).size(36, 36).toFile(var8);
            HttpRequest var4 = HttpRequest.post("https://api.rockstar.moscow/minecraft/v1/auth/avatar.php");
            var4.part("login", Information.getPreferUser().username());
            var4.part("password", Information.getPreferUser().password());
            var4.part("avatar", "avatar.png", var8);
            int var5 = var4.code();
            System.out.println("Upload status: " + var5);
            if (var5 == 200) {
               System.out.println(var4.body());
            }

            Information.clearAvatars();
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }
   }

   @Generated
   private IIiiiiii_Class64() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
