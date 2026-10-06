package rockstar.client;

import lombok.Generated;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import pyrock.utility.render.ColorRGBA;

public final class iIIIIIIii_Class260 implements iIIiIIiIi_Class294 {
   private static final Text I_field_33c1784c = Text.literal("[%s]".formatted("Agravity"))
      .styled(var0 -> var0.withColor(new ColorRGBA(140.0F, 80.0F, 255.0F).getRGB()));

   public static void I_method_8e5dab64(iIIIIIIii_Class260.Nested1_8542d060 var0, Text var1) {
      I_method_3d5873f0(var0, var1, true);
   }

   public static void I_method_468cf607(Text var0) {
      if (I_field_3a9bda27.player != null) {
         I_method_3d5873f0(iIIIIIIii_Class260.Nested1_8542d060.II_field_66cf1227, var0, false);
      }
   }

   public static void i_method_70898627(Text var0) {
      I_method_3d5873f0(iIIIIIIii_Class260.Nested1_8542d060.I_field_66cf1227, var0, false);
   }

   public static void II_method_e8fd4864(Text var0) {
      I_method_3d5873f0(iIIIIIIii_Class260.Nested1_8542d060.i_field_66cf1227, var0, false);
   }

   private static void I_method_3d5873f0(iIIIIIIii_Class260.Nested1_8542d060 var0, Text var1, boolean var2) {
      if (I_field_3a9bda27.player != null) {
         MutableText var3 = Text.literal("").append(var1.copy()).styled(var1x -> var1x.withColor(var0.I_method_3169edc9().getRGB()));
         I_field_3a9bda27.player.sendMessage(I_field_33c1784c.copy().append(" ").append(var3), var2);
      }
   }

   public static void Ii_method_12f9d884(Text var0) {
      if (I_field_3a9bda27.player != null) {
         I_field_3a9bda27.player.sendMessage(var0, false);
      }
   }

   @Generated
   private iIIIIIIii_Class260() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static enum Nested1_8542d060 {
      I_field_66cf1227("Warning", new ColorRGBA(247.0F, 206.0F, 59.0F)),
      i_field_66cf1227("Error", new ColorRGBA(242.0F, 79.0F, 68.0F)),
      II_field_66cf1227("Info", new ColorRGBA(87.0F, 126.0F, 255.0F));

      private final String I_field_523beb0a;
      private final ColorRGBA I_field_d0c8ec5;

      @Generated
      public String I_method_9e54e486() {
         return this.I_field_523beb0a;
      }

      @Generated
      public ColorRGBA I_method_3169edc9() {
         return this.I_field_d0c8ec5;
      }

      @Generated
      private Nested1_8542d060(String var3, ColorRGBA var4) {
         this.I_field_523beb0a = var3;
         this.I_field_d0c8ec5 = var4;
      }
   }
}
