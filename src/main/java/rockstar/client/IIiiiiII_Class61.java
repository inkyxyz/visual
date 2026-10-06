package rockstar.client;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.ClickEvent.Action;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.PreHudRenderEvent;
import ua.mintantileak.spk.Compile;

public class IIiiiiII_Class61 implements iIIiIIiIi_Class294, iIIiIIiiI_Class295 {
   private final IiIIIiII_Class69<PreHudRenderEvent> I_field_3d936f41 = new IiIIIiII_Class69<PreHudRenderEvent>() {
      public void onEvent(PreHudRenderEvent var1) {
         MatrixStack var2 = var1.getContext().getMatrices();
         IIiiiiII_Class61.this.I_method_8658c81(var1, var2);
      }

      @Override
      public int I_method_f12c6485() {
         return 1;
      }
   };

   public IIiiiiII_Class61() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public final IIIiiIIi_Class26 I_method_cde7e3ab() {
      return IIIiiIiI_Class27.I_method_209cd841("waypoint")
         .I_method_b3f941e4("way", "gps")
         .i_method_cfe1a061("commands.way.description")
         .i_method_3d6e11d9("action", var0 -> {
            var0.I_method_a44fe164("add", "remove", "del", "clear", "list");
            var0.I_method_f005ecf3("add", "remove", "clear", "list");
         })
         .i_method_3d6e11d9("name", var0 -> var0.I_method_e930dfcb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a))
         .i_method_3d6e11d9("x", var1 -> var1.I_method_e930dfcb().I_method_2619a44a(this::I_method_4a49041))
         .i_method_3d6e11d9("y", var1 -> var1.I_method_e930dfcb().I_method_2619a44a(this::I_method_4a49041))
         .i_method_3d6e11d9("z", var1 -> var1.I_method_e930dfcb().I_method_2619a44a(this::I_method_4a49041))
         .I_method_16f05c8a(this::I_method_a117b74d)
         .I_method_9111538b();
   }

   private IIiIIIIi_Class34 I_method_4a49041(String var1) {
      try {
         Integer.parseInt(var1);
         return IIiIIIIi_Class34.I_method_12fc454a(var1);
      } catch (NumberFormatException var3) {
         return IIiIIIIi_Class34.I_method_c9d442bc(IiIiIIII_Class81.I_method_f25a980a("commands.way.error_number"));
      }
   }

   @Compile
   private void I_method_a117b74d(IIIiiIii_Class28 var1) {
      String var2 = this.I_method_f0fae60a(var1, 0);
      String var3 = this.I_method_f0fae60a(var1, 1);
      String var4 = this.I_method_f0fae60a(var1, 2);
      String var5 = this.I_method_f0fae60a(var1, 3);
      String var6 = this.I_method_f0fae60a(var1, 4);
      IiIIiIIII_Class145 var7 = RockstarClient.getInstance().I_method_cf3ba442();
      if (var2 == null) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.way.help")));
      } else {
         String var8 = var2.toLowerCase();
         switch (var8) {
            case "add":
               this.I_method_68034822(var7, var3, var4, var5, var6);
               break;
            case "remove":
            case "del":
               String var10 = this.I_method_5713ba2c(var3, var4, var5, var6);
               String var11 = this.i_method_97e16fea(var10);
               if (var11 == null || var11.isBlank()) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.way.error_name")));
                  return;
               }

               var7.I_method_d7f5649(var11);
               break;
            case "clear":
               var7.I_method_5379e3f();
               break;
            case "list":
               if (var7.I_method_173f1fee().isEmpty()) {
                  iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.way.list_empty")));
                  return;
               }

               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.way.list_header")));
               var7.I_method_173f1fee().forEach(var1x -> iIIIIIIii_Class260.Ii_method_12f9d884(this.I_method_f56bb12c(var1x.getKey(), var1x.getValue())));
         }
      }
   }

   private String I_method_5713ba2c(String var1, String var2, String var3, String var4) {
      if (var1 == null) {
         return null;
      } else if (var1.startsWith("b64:")) {
         return var1;
      } else if (var2 == null && var3 == null && var4 == null) {
         return var1;
      } else {
         StringBuilder var5 = new StringBuilder();
         var5.append(var1);
         if (var2 != null) {
            var5.append(" ").append(var2);
         }

         if (var3 != null) {
            var5.append(" ").append(var3);
         }

         if (var4 != null) {
            var5.append(" ").append(var4);
         }

         return var5.toString().trim();
      }
   }

   private void I_method_68034822(IiIIiIIII_Class145 var1, String var2, String var3, String var4, String var5) {
      IIiiiiII_Class61.Nested1_b7c3b4d3 var6 = this.I_method_4c7b4eb0(var1, var2, var3, var4, var5);
      if (var6 != null) {
         var1.I_method_b71837ba(var6.I_method_719aa0b9(), var6.I_method_3d255aba(), var6.i_method_3d33e69a(), var6.II_method_6794f56d());
      }
   }

   private IIiiiiII_Class61.Nested1_b7c3b4d3 I_method_4c7b4eb0(IiIIiIIII_Class145 var1, String var2, String var3, String var4, String var5) {
      int var6 = I_field_3a9bda27.player.getBlockX();
      int var7 = I_field_3a9bda27.player.getBlockY();
      int var8 = I_field_3a9bda27.player.getBlockZ();
      IIiiiiII_Class61.Nested1_40b2e5d6 var9 = this.I_method_42ee893d(var1, var2, var3, var4, var5);
      IIiiiiII_Class61.Nested1_b7c3b4f3 var10 = this.I_method_4ac03c6c(var9.I_method_3d5c4223(), var6, var7, var8);
      return var10 == null
         ? null
         : new IIiiiiII_Class61.Nested1_b7c3b4d3(var9.I_method_6a33dd7c(), var10.I_method_73c06e9a(), var10.i_method_73cefa7a(), var10.II_method_45c5d8d());
   }

   private IIiiiiII_Class61.Nested1_40b2e5d6 I_method_42ee893d(IiIIiIIII_Class145 var1, String var2, String var3, String var4, String var5) {
      if (this.I_method_25e9c0f8(var2, var3, var4, var5)) {
         return new IIiiiiII_Class61.Nested1_40b2e5d6(this.I_method_be8aa5e6(var1), List.of());
      } else {
         return this.I_method_254efbe4(var2, var3)
            ? new IIiiiiII_Class61.Nested1_40b2e5d6(this.I_method_be8aa5e6(var1), this.I_method_d0eb8ad3(var2, var3, var4, var5))
            : new IIiiiiII_Class61.Nested1_40b2e5d6(this.I_method_4ce583dc(var1, var2), this.I_method_724a9b5d(var3, var4, var5));
      }
   }

   private boolean I_method_25e9c0f8(String var1, String var2, String var3, String var4) {
      return var1 == null && var2 == null && var3 == null && var4 == null;
   }

   private boolean I_method_254efbe4(String var1, String var2) {
      return this.I_method_48514b9a(var1) && this.I_method_48514b9a(var2);
   }

   private String I_method_4ce583dc(IiIIiIIII_Class145 var1, String var2) {
      return var2 != null && !var2.isBlank() ? var2 : this.I_method_be8aa5e6(var1);
   }

   private List<String> I_method_d0eb8ad3(String var1, String var2, String var3, String var4) {
      ArrayList var5 = new ArrayList(4);
      this.I_method_b395c647(var5, var1);
      this.I_method_b395c647(var5, var2);
      this.I_method_b395c647(var5, var3);
      this.I_method_b395c647(var5, var4);
      return var5;
   }

   private List<String> I_method_724a9b5d(String var1, String var2, String var3) {
      ArrayList var4 = new ArrayList(3);
      this.I_method_b395c647(var4, var1);
      this.I_method_b395c647(var4, var2);
      this.I_method_b395c647(var4, var3);
      return var4;
   }

   private void I_method_b395c647(List<String> var1, String var2) {
      if (var2 != null) {
         var1.add(var2);
      }
   }

   private IIiiiiII_Class61.Nested1_b7c3b4f3 I_method_4ac03c6c(List<String> var1, int var2, int var3, int var4) {
      try {
         return switch (var1.size()) {
            case 0 -> new IIiiiiII_Class61.Nested1_b7c3b4f3(var2, var3, var4);
            default -> {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.way.help")));
               yield null;
            }
            case 2 -> new IIiiiiII_Class61.Nested1_b7c3b4f3(Integer.parseInt((String)var1.get(0)), var3, Integer.parseInt((String)var1.get(1)));
            case 3 -> new IIiiiiII_Class61.Nested1_b7c3b4f3(
               Integer.parseInt((String)var1.get(0)), Integer.parseInt((String)var1.get(1)), Integer.parseInt((String)var1.get(2))
            );
         };
      } catch (NumberFormatException var6) {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.way.error_numbers")));
         return null;
      }
   }

   private boolean I_method_48514b9a(String var1) {
      if (var1 == null) {
         return false;
      } else {
         try {
            Integer.parseInt(var1);
            return true;
         } catch (NumberFormatException var3) {
            return false;
         }
      }
   }

   private String I_method_be8aa5e6(IiIIiIIII_Class145 var1) {
      int var2 = 1;

      while (var1.I_method_d7f564d("\u041c\u0435\u0442\u043a\u0430 " + var2)) {
         var2++;
      }

      return "\u041c\u0435\u0442\u043a\u0430 " + var2;
   }

   private String I_method_77c287ca(String var1) {
      return var1 == null ? "" : "b64:" + Base64.getUrlEncoder().withoutPadding().encodeToString(var1.getBytes(StandardCharsets.UTF_8));
   }

   private String i_method_97e16fea(String var1) {
      if (var1 == null) {
         return null;
      } else {
         if (var1.startsWith("b64:")) {
            try {
               byte[] var2 = Base64.getUrlDecoder().decode(var1.substring("b64:".length()));
               return new String(var2, StandardCharsets.UTF_8);
            } catch (IllegalArgumentException var3) {
            }
         }

         return var1;
      }
   }

   private String I_method_f0fae60a(IIIiiIii_Class28 var1, int var2) {
      if (var1 != null && var1.I_method_557e5bfb() != null) {
         if (var1.I_method_557e5bfb().size() <= var2) {
            return null;
         } else {
            Object var3 = var1.I_method_557e5bfb().get(var2);
            return var3 instanceof String ? (String)var3 : null;
         }
      } else {
         return null;
      }
   }

   private MutableText I_method_f56bb12c(String var1, Vec3d var2) {
      int var3 = (int)Math.round(var2.x);
      int var4 = (int)Math.round(var2.y);
      int var5 = (int)Math.round(var2.z);
      String var6 = ".waypoint remove " + this.I_method_77c287ca(var1);
      MutableText var7 = Text.literal(var1)
         .setStyle(
            Style.EMPTY
               .withColor(TextColor.fromFormatting(Formatting.AQUA))
               .withClickEvent(new ClickEvent(Action.RUN_COMMAND, var6))
               .withHoverEvent(
                  new HoverEvent(net.minecraft.text.HoverEvent.Action.SHOW_TEXT, Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.way.list_hover")))
               )
         );
      MutableText var8 = Text.literal(IiIiIIII_Class81.I_method_1410d1e5("commands.way.list_coordinates", var3, var4, var5))
         .setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY)));
      return Text.literal("- ").setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY))).append(var7).append(" ").append(var8);
   }

   void I_method_8658c81(PreHudRenderEvent var1, MatrixStack var2) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         for (Entry var4 : RockstarClient.getInstance().I_method_cf3ba442().I_method_173f1fee()) {
            String var5 = (String)var4.getKey();
            Vec3d var6 = (Vec3d)var4.getValue();
            Vec3d var7 = var6.add(0.0, 0.5, 0.0);
            Vec2f var8 = iIiiiiIII_Class377.I_method_211fc242(var7);
            if (var8 != null) {
               float var9 = (float)I_field_3a9bda27.player.getPos().distanceTo(var6.add(0.5, 0.5, 0.5));
               float var10 = MathHelper.clamp(1.1F - var9 / 100.0F, 0.6F, 1.1F);
               var2.push();
               var2.translate(var8.x, var8.y, 0.0F);
               var2.scale(var10, var10, 1.0F);
               IiIIiIIiI_Class147.I_method_856ade58(var1.getContext(), var5, var9, IiiiiIIIi_Class242.i_method_5dfec6e(), 1.0F);
               var2.pop();
            }
         }
      }
   }

   static final class Nested1_40b2e5d6 {
      private final String I_field_523beb0a;
      private final List<String> I_field_7865b31;

      Nested1_40b2e5d6(String var1, List<String> var2) {
         this.I_field_523beb0a = var1;
         this.I_field_7865b31 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_40b2e5d6[name=" + this.I_field_523beb0a + ", cords=" + this.I_field_7865b31 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiiiII_Class61.Nested1_40b2e5d6 other = (IIiiiiII_Class61.Nested1_40b2e5d6) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31);
      }

      public String I_method_6a33dd7c() {
         return this.I_field_523beb0a;
      }

      public List<String> I_method_3d5c4223() {
         return this.I_field_7865b31;
      }
   }

   static final class Nested1_b7c3b4d3 {
      private final String I_field_523beb0a;
      private final int I_field_49;
      private final int i_field_49;
      private final int II_field_49;

      Nested1_b7c3b4d3(String var1, int var2, int var3, int var4) {
         this.I_field_523beb0a = var1;
         this.I_field_49 = var2;
         this.i_field_49 = var3;
         this.II_field_49 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_b7c3b4d3[name=" + this.I_field_523beb0a + ", x=" + this.I_field_49 + ", y=" + this.i_field_49 + ", z=" + this.II_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiiiII_Class61.Nested1_b7c3b4d3 other = (IIiiiiII_Class61.Nested1_b7c3b4d3) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49);
      }

      public String I_method_719aa0b9() {
         return this.I_field_523beb0a;
      }

      public int I_method_3d255aba() {
         return this.I_field_49;
      }

      public int i_method_3d33e69a() {
         return this.i_field_49;
      }

      public int II_method_6794f56d() {
         return this.II_field_49;
      }
   }

   static final class Nested1_b7c3b4f3 {
      private final int I_field_49;
      private final int i_field_49;
      private final int II_field_49;

      Nested1_b7c3b4f3(int var1, int var2, int var3) {
         this.I_field_49 = var1;
         this.i_field_49 = var2;
         this.II_field_49 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_b7c3b4f3[x=" + this.I_field_49 + ", y=" + this.i_field_49 + ", z=" + this.II_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIiiiiII_Class61.Nested1_b7c3b4f3 other = (IIiiiiII_Class61.Nested1_b7c3b4f3) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49);
      }

      public int I_method_73c06e9a() {
         return this.I_field_49;
      }

      public int i_method_73cefa7a() {
         return this.i_field_49;
      }

      public int II_method_45c5d8d() {
         return this.II_field_49;
      }
   }
}
