package rockstar.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public final class IiIiiIIiI_Class179 extends iiI_Class7 {
   private static final Pattern I_field_5fd3861f = Pattern.compile("\\X");
   private static final Map<String, IiIiiIIiI_Class179.Nested1_ac72800> I_field_a567c40b = new HashMap<>();
   private static final IiIiiIIiI_Class179.Nested1_ac72800 I_field_91d5ae87 = new IiIiiIIiI_Class179.Nested1_ac72800(
      RockstarClient.id("textures/emoji/peace.png")
   );
   private final IIiIIi_Class10 I_field_856d0221;
   private final Supplier<String> I_field_11b14ee4;
   private final Supplier<ColorRGBA> i_field_11b14ee4;
   private final iiI_Class7.Nested1_b540d40 I_field_65e71a47;

   public IiIiiIIiI_Class179(IIiIIi_Class10 var1, Supplier<String> var2, Supplier<ColorRGBA> var3) {
      this(var1, var2, var3, () -> 0.0F);
   }

   public IiIiiIIiI_Class179(IIiIIi_Class10 var1, Supplier<String> var2, Supplier<ColorRGBA> var3, iiI_Class7.Nested1_b540d40 var4) {
      this.I_field_856d0221 = var1;
      this.I_field_11b14ee4 = var2;
      this.i_field_11b14ee4 = var3;
      this.I_field_65e71a47 = var4;
      this.interactive(false);
   }

   @Override
   protected void measure() {
      String var1 = this.I_method_7cab8401();
      if (!this.explicitW) {
         this.prefW = I_method_cc1ab81a(this.I_field_856d0221, var1);
      }

      if (!this.explicitH) {
         this.prefH = Math.max(this.I_field_856d0221.I_method_a649725c(), I_method_89fe6650(this.I_field_856d0221));
      }
   }

   @Override
   protected void drawSelf(III var1, float var2) {
      String var3 = this.I_method_7cab8401();
      if (!var3.isEmpty()) {
         I_method_d5fb8067(
            var1,
            this.I_field_856d0221,
            var3,
            this.x() + this.I_field_65e71a47.get(),
            this.y(),
            this.h(),
            this.i_field_11b14ee4 == null ? ColorRGBA.WHITE : this.i_field_11b14ee4.get()
         );
      }
   }

   public static float I_method_cc1ab81a(IIiIIi_Class10 var0, String var1) {
      if (var1 != null && !var1.isEmpty()) {
         Matcher var2 = I_field_5fd3861f.matcher(var1);
         float var3 = 0.0F;

         while (var2.find()) {
            String var4 = var2.group();
            var3 += i_method_8e3cda6d(var4)
               ? I_method_89fe6650(var0) + IIiiii_Class16.I_method_a798bec4(var0.iI_method_24b6c285())
               : var0.I_method_2c375926(var4);
         }

         return var3;
      } else {
         return 0.0F;
      }
   }

   public static boolean I_method_bd85868d(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         Matcher var1 = I_field_5fd3861f.matcher(var0);

         while (var1.find()) {
            if (i_method_8e3cda6d(var1.group())) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static void I_method_d5fb8067(CustomDrawContext var0, IIiIIi_Class10 var1, String var2, float var3, float var4, float var5, ColorRGBA var6) {
      if (var2 != null && !var2.isEmpty() && var6 != null) {
         Matcher var7 = I_field_5fd3861f.matcher(var2);
         float var8 = var3;

         while (var7.find()) {
            String var9 = var7.group();
            if (i_method_8e3cda6d(var9)) {
               float var10 = I_method_89fe6650(var1);
               I_method_9260ba3a(var9).I_method_81f7c1a2(var0, var8, var4 + (var5 - var10) / 2.0F, var10, var6.getAlpha());
               var8 += var10 + IIiiii_Class16.I_method_a798bec4(var1.iI_method_24b6c285());
            } else {
               var0.drawText(var1, var9, var8, var4 + (var5 - var1.I_method_a649725c()) / 2.0F, var6);
               var8 += var1.I_method_2c375926(var9);
            }
         }
      }
   }

   private static float I_method_89fe6650(IIiIIi_Class10 var0) {
      return var0.iI_method_24b6c285() * 1.4F;
   }

   private String I_method_7cab8401() {
      String var1 = this.I_field_11b14ee4 == null ? "" : this.I_field_11b14ee4.get();
      return var1 == null ? "" : var1;
   }

   private static boolean i_method_8e3cda6d(String var0) {
      return var0.codePoints()
         .anyMatch(
            var0x -> var0x == 169
               || var0x == 174
               || var0x == 8252
               || var0x == 8265
               || var0x == 8482
               || var0x == 8505
               || var0x == 12336
               || var0x == 12349
               || var0x == 12951
               || var0x == 12953
               || var0x >= 8960 && var0x <= 9215
               || var0x >= 9728 && var0x <= 10175
               || var0x >= 11008 && var0x <= 11263
               || var0x >= 126976 && var0x <= 129791
         );
   }

   private static IiIiiIIiI_Class179.Nested1_ac72800 I_method_9260ba3a(String var0) {
      if (!var0.equals("\u270c") && !var0.equals("\u270c\ufe0f")) {
         IiIiiIIiI_Class179.Nested1_ac72800 var1 = I_field_a567c40b.get(var0);
         if (var1 != null) {
            return var1;
         } else {
            Integer var2 = IiIiiIIIi_Class178.I_method_5f18c130(I_method_34c33137(var0));
            if (var2 != null) {
               var1 = IiIiiIIiI_Class179.Nested1_ac72800.I_method_409f423a(var2);
               I_field_a567c40b.put(var0, var1);
               return var1;
            } else {
               BufferedImage var3 = new BufferedImage(96, 96, 2);
               Graphics2D var4 = var3.createGraphics();
               var4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
               var4.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
               var4.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
               Font var5 = I_method_17ec7fed(var0);
               var4.setFont(var5);
               var4.setPaint(I_method_3118a5ec(var0));
               FontMetrics var6 = var4.getFontMetrics(var5);
               int var7 = var6.stringWidth(var0);
               var4.drawString(var0, (96 - var7) / 2.0F, (96 - var6.getHeight()) / 2.0F + var6.getAscent());
               var4.dispose();
               Identifier var8 = Identifier.of(
                  RockstarClient.II_field_523beb0a, "dynamic_island/emoji/" + UUID.nameUUIDFromBytes(var0.getBytes(StandardCharsets.UTF_8))
               );
               MinecraftClient.getInstance()
                  .getTextureManager()
                  .registerTexture(var8, new NativeImageBackedTexture(iIIIIiiII_Class269.I_method_97bf3255(var3, false)));
               var1 = new IiIiiIIiI_Class179.Nested1_ac72800(var8);
               I_field_a567c40b.put(var0, var1);
               return var1;
            }
         }
      } else {
         return I_field_91d5ae87;
      }
   }

   private static String I_method_34c33137(String var0) {
      StringBuilder var1 = new StringBuilder();
      var0.codePoints().filter(var0x -> var0x != 65038 && var0x != 65039).forEach(var1x -> {
         if (!var1.isEmpty()) {
            var1.append('-');
         }

         var1.append(Integer.toHexString(var1x));
      });
      return var1.toString();
   }

   private static Font I_method_17ec7fed(String var0) {
      for (String var4 : new String[]{"Apple Color Emoji", "Segoe UI Emoji", "Noto Color Emoji"}) {
         Font var5 = new Font(var4, 0, 76);
         if (var5.canDisplay(var0.codePointAt(0))) {
            return var5;
         }
      }

      return new Font("Dialog", 0, 76);
   }

   private static GradientPaint I_method_3118a5ec(String var0) {
      boolean var1 = var0.codePoints().anyMatch(var0x -> var0x == 10084 || var0x >= 128147 && var0x <= 128159);
      return var1
         ? new GradientPaint(12.0F, 12.0F, new Color(255, 115, 125), 84.0F, 84.0F, new Color(221, 38, 63))
         : new GradientPaint(12.0F, 12.0F, new Color(255, 235, 112), 84.0F, 84.0F, new Color(255, 157, 30));
   }

   static final class Nested1_ac72800 {
      private final Identifier I_field_6a3d6525;
      private final int I_field_49;

      Nested1_ac72800(Identifier var1) {
         this(var1, -1);
      }

      private Nested1_ac72800(Identifier var1, int var2) {
         this.I_field_6a3d6525 = var1;
         this.I_field_49 = var2;
      }

      static IiIiiIIiI_Class179.Nested1_ac72800 I_method_409f423a(int var0) {
         return new IiIiiIIiI_Class179.Nested1_ac72800(null, var0);
      }

      void I_method_81f7c1a2(CustomDrawContext var1, float var2, float var3, float var4, float var5) {
         if (this.I_field_49 >= 0) {
            IiIiiIIIi_Class178.I_method_529619e6(var1, this.I_field_49, var2, var3, var4, var5);
         } else {
            var1.drawTexture(this.I_field_6a3d6525, var2, var3, var4, var4, ColorRGBA.WHITE.withAlpha(var5));
         }
      }

      @Override
      public final String toString() {
         return "Nested1_ac72800[id=" + this.I_field_6a3d6525 + ", index=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_6a3d6525);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiiIIiI_Class179.Nested1_ac72800 other = (IiIiiIIiI_Class179.Nested1_ac72800) var1;
         return java.util.Objects.equals(this.I_field_6a3d6525, other.I_field_6a3d6525)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Identifier I_method_35563989() {
         return this.I_field_6a3d6525;
      }

      public int I_method_de1bdbad() {
         return this.I_field_49;
      }
   }
}
