package rockstar.client;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.nio.file.FileSystems;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pyrock.events.render.PreHudRenderEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Russian Roulette",
   category = ModuleCategory.OTHER,
   III_method_a89e5834 = "modules.descriptions.russian_roulette",
   enabledByDefault = true
)
public class RussianRouletteModule extends Module {
   private ModeSetting I_field_bbe33e6c;
   private RussianRouletteModule.Nested1_87365860 I_field_a34c8a27;
   private RussianRouletteModule.Nested1_87365860 i_field_a34c8a27;
   private final SecureRandom I_field_ec5bca73 = new SecureRandom();
   private volatile Identifier I_field_6a3d6525;
   private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(5000L, IiiiIiiII_Class237.IIIi_field_dd60aac);
   private volatile boolean I_field_5a;
   private final IiIIIiII_Class69<PreHudRenderEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_6a3d6525 != null) {
         if (this.I_field_dc7facc.I_method_6ac4da6f() == 1.0 && !this.I_field_5a) {
            this.I_field_5a = true;
         }

         this.I_field_dc7facc.I_method_edd6dd11(this.I_field_5a ? 0.0F : 1.0F);
      }
   };

   public RussianRouletteModule() {
      this.IiI_method_6fb9a29f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_6fb9a29f() {
      this.I_field_bbe33e6c = new ModeSetting(
         this, "modules.settings.russian_roulette.difficulty", "modules.settings.russian_roulette.difficulty.description"
      );
      this.I_field_a34c8a27 = new RussianRouletteModule.Nested1_87365860(this.I_field_bbe33e6c, "modules.settings.russian_roulette.easy") {
         @Override
         void I_method_32879872() {
            iIIiIIiIi_Class294.I_field_3a9bda27.stop();
         }
      };
      this.i_field_a34c8a27 = new RussianRouletteModule.Nested1_87365860(this.I_field_bbe33e6c, "modules.settings.russian_roulette.very_hard") {
         @Override
         void I_method_32879872() {
         }
      };
   }

   @Override
   public final void onEnable() {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         boolean var1 = this.Iii_method_6fc82e83();
         this.ii_method_a64671f2(var1);
         this.Iii_method_6fc82e7f();
         super.onEnable();
      }
   }

   private boolean Iii_method_6fc82e83() {
      int[] var1 = new int[6];
      Arrays.setAll(var1, var0 -> var0 == 5 ? 1 : 0);
      return var1[this.I_field_ec5bca73.nextInt(var1.length)] == 0;
   }

   private void ii_method_a64671f2(boolean var1) {
      boolean var2 = this.i_field_a34c8a27.isSelected();
      String var3 = var1 ? "rroulette.luck" : "rroulette.unlucky";
      iIIIIIIii_Class260.I_method_468cf607(
         Text.of(var2 ? IiIiIIII_Class81.I_method_f25a980a(var3 + ".prize") : IiIiIIII_Class81.I_method_f25a980a(var3 + ".simple"))
      );
      if (var2) {
         this.I_method_319a5229(var1 ? "https://4lapy.ru/journal/info/taksa-osobennosti-porody-kharakter-soderzhanie/" : "https://pornhub.com");
      }
   }

   private void Iii_method_6fc82e7f() {
      if (this.I_field_a34c8a27.isSelected()) {
         this.I_field_a34c8a27.I_method_32879872();
      }
   }

   private void I_method_319a5229(String var1) {
      CompletableFuture.runAsync(() -> {
         try {
            BitMatrix var2 = new MultiFormatWriter().encode(var1, BarcodeFormat.QR_CODE, 300, 300);
            BufferedImage var3 = MatrixToImageWriter.toBufferedImage(var2);
            NativeImage var4 = this.I_method_34d3f0e1(var3);
            String var5 = FileSystems.getDefault().getSeparator();
            I_field_3a9bda27.execute(() -> {
               if (this.I_field_6a3d6525 != null) {
                  I_field_3a9bda27.getTextureManager().destroyTexture(this.I_field_6a3d6525);
               }

               Identifier var3x = RockstarClient.id("temp" + var5 + "qr" + var5 + UUID.randomUUID());
               I_field_3a9bda27.getTextureManager().registerTexture(var3x, new NativeImageBackedTexture(var4));
               this.I_field_6a3d6525 = var3x;
               this.I_field_dc7facc.I_method_edd6dd11(1.0F);
               this.I_field_5a = false;
            });
         } catch (Exception var6) {
         }
      });
   }

   private NativeImage I_method_34d3f0e1(BufferedImage var1) {
      int var2 = var1.getWidth();
      int var3 = var1.getHeight();
      NativeImage var4 = new NativeImage(var2, var3, true);
      int[] var5 = var1.getRGB(0, 0, var2, var3, null, 0, var2);

      for (int var6 = 0; var6 < var5.length; var6++) {
         int var7 = var6 % var2;
         int var8 = var6 / var2;
         var4.setColorArgb(var7, var8, var5[var6]);
      }

      return var4;
   }

   @Generated
   public Identifier I_method_7702b12e() {
      return this.I_field_6a3d6525;
   }

   @Generated
   public IiiiIiIii_Class236 i_method_a2b42735() {
      return this.I_field_dc7facc;
   }

   @Generated
   public boolean IiI_method_6fb9a2a3() {
      return this.I_field_5a;
   }

   abstract static class Nested1_87365860 extends ModeSetting.Nested1_42765c60 {
      public Nested1_87365860(ModeSetting var1, String var2) {
         super(var1, var2);
      }

      abstract void I_method_32879872();
   }
}
