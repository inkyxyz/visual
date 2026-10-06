package pyrock.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import jep.python.PyCallable;
import net.minecraft.util.Identifier;
import pyrock.classes.PySetting;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIIii_Class4;
import rockstar.client.IIiII_Class5;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiiI_Class7;
import rockstar.client.Setting;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIiiIIi_Class218;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIiI_Class11;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public class Ui {
   private final PyScreen screen;
   private final List<Node> collected = new ArrayList<>();

   public Ui(PyScreen var1) {
      this.screen = var1;
   }

   public Ui() {
      this.screen = null;
   }

   public void addRoot(Node var1) {
      if (this.screen != null) {
         this.screen.addRoot(var1);
      } else if (var1 != null) {
         this.collected.add(var1);
      }
   }

   public Node firstRoot() {
      return this.collected.isEmpty() ? null : this.collected.get(0);
   }

   public Node column() {
      return new Node(new iii_Class8().I_method_485bccf5());
   }

   public Node row() {
      return new Node(new iii_Class8().i_method_c88da8d5());
   }

   public Node node(iiI_Class7 var1) {
      return new Node(var1);
   }

   public Node text(String var1, float var2, String var3, Object var4) {
      IIiIIi_Class10 var5 = font(var3, var2);
      Iii_Class4 var6;
      if (var4 instanceof PyCallable var7) {
         var6 = new Iii_Class4().text(var5, var1, var1x -> callColor(var7));
      } else if (var4 instanceof ColorRGBA var8) {
         var6 = new Iii_Class4().text(var5, var1, var8);
      } else {
         var6 = new Iii_Class4().text(var5, var1, IiiiiIIIi_Class242.iII_field_d0c8ec5);
      }

      var6.interactive(false);
      return new Node(var6);
   }

   public Node textDyn(Object var1, float var2, String var3, Object var4) {
      IIiIIi_Class10 var5 = font(var3, var2);
      PyCallable var6 = (PyCallable)var1;
      Supplier var7 = () -> {
         try {
            Object var1x = var6.call(new Object[0]);
            return var1x == null ? "" : var1x.toString();
         } catch (Exception var2x) {
            return "";
         }
      };
      Iii_Class4 var8;
      if (var4 instanceof PyCallable var9) {
         var8 = new Iii_Class4().text(var5, var7, var1x -> callColor(var9));
      } else if (var4 instanceof ColorRGBA var10) {
         var8 = new Iii_Class4().text(var5, var7, var1x -> var10);
      } else {
         var8 = new Iii_Class4().text(var5, var7, var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5);
      }

      var8.interactive(false);
      return new Node(var8);
   }

   public Node button(String var1) {
      Iii_Class4 var2 = new Iii_Class4()
         .background(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.1F + 0.12F * var0.hover()))
         .text(font("medium", 8.0F), var1, IiiiiIIIi_Class242.iII_field_d0c8ec5)
         .radius(6.0F)
         .padding(5.0F, 10.0F);
      var2.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      return new Node(var2);
   }

   public Node switchWidget(PyCallable var1, PyCallable var2) {
      IIiiI_Class7 var3 = new IIiiI_Class7(() -> truthy(var1));
      var3.i_method_c4678f15(() -> IiiiiIIIi_Class242.IIi_field_d0c8ec5);
      var3.size(16.0F, 9.0F);
      var3.onClick(() -> {
         try {
            var2.call(new Object[]{!truthy(var1)});
         } catch (Exception var3x) {
            RockstarClient.I_field_ab0f6068.error("[PyUi] switch", var3x);
         }
      });
      return new Node(var3);
   }

   public Node toggle(String var1, PyCallable var2, PyCallable var3) {
      iii_Class8 var4 = new iii_Class8().i_method_c88da8d5();
      var4.III_method_9dc17555();
      var4.I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_70a38517(6.0F);
      var4.I_method_8939bffd(new Iii_Class4().text(font("medium", 8.0F), var1, IiiiiIIIi_Class242.iII_field_d0c8ec5).interactive(false));
      var4.I_method_8939bffd(this.switchWidget(var2, var3).element());
      return new Node(var4);
   }

   public Node sliderBar(PyCallable var1, PyCallable var2, float var3, float var4, float var5) {
      IIIii_Class4 var6 = new IIIii_Class4(() -> floatOf(var1), var1x -> {
         try {
            var2.call(new Object[]{var1x});
         } catch (Exception var3x) {
            RockstarClient.I_field_ab0f6068.error("[PyUi] slider", var3x);
         }
      }, var3, var4);
      if (var5 > 0.0F) {
         var6.I_method_ec139357(var5);
      }

      return new Node(var6);
   }

   public Node slider(String var1, float var2, float var3, float var4, PyCallable var5, float var6) {
      float[] var7 = new float[]{var4};
      IIIii_Class4 var8 = new IIIii_Class4(() -> var7[0], var2x -> {
         var7[0] = var2x;
         if (var5 != null) {
            try {
               var5.call(new Object[]{var2x});
            } catch (Exception var4x) {
               RockstarClient.I_field_ab0f6068.error("[PyUi] slider", var4x);
            }
         }
      }, var2, var3);
      var8.I_method_d614f735();
      if (var6 > 0.0F) {
         var8.I_method_ec139357(var6);
      }

      iii_Class8 var9 = new iii_Class8().i_method_c88da8d5();
      var9.III_method_9dc17555();
      var9.I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1).I_method_70a38517(6.0F);
      var9.I_method_8939bffd(new Iii_Class4().text(font("medium", 8.0F), var1, IiiiiIIIi_Class242.iII_field_d0c8ec5).interactive(false));
      var9.I_method_8939bffd(new Iii_Class4().text(font("medium", 8.0F), () -> fmt(var7[0]), var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5).interactive(false));
      iii_Class8 var10 = new iii_Class8().I_method_485bccf5();
      var10.III_method_9dc17555();
      var10.I_method_70a38517(3.0F);
      var10.I_method_8939bffd(var9);
      var10.I_method_8939bffd(var8);
      return new Node(var10);
   }

   public Node setting(Object var1) {
      if (var1 instanceof PySetting var2) {
         var1 = var2.raw();
      }

      return new Node(IiiIiiIIi_Class218.I_method_83bcc05d((Setting)var1));
   }

   public Node toggleC(PyCallable var1, PyCallable var2, ColorRGBA var3, ColorRGBA var4, ColorRGBA var5) {
      IIiiI_Class7 var6 = new IIiiI_Class7(() -> truthy(var1));
      if (var3 != null) {
         var6.I_method_f43b9cd6(var3);
      }

      if (var4 != null) {
         var6.i_method_af534f6(var4);
      }

      if (var5 != null) {
         var6.II_method_54754c33(var5);
      }

      var6.size(38.0F, 22.0F);
      var6.onClick(() -> {
         try {
            var2.call(new Object[0]);
         } catch (Exception var2x) {
            RockstarClient.I_field_ab0f6068.error("[PyUi] toggle", var2x);
         }
      });
      return new Node(var6);
   }

   public Node sliderC(
      PyCallable var1,
      PyCallable var2,
      float var3,
      float var4,
      float var5,
      ColorRGBA var6,
      ColorRGBA var7,
      ColorRGBA var8,
      ColorRGBA var9,
      float var10,
      float var11,
      float var12
   ) {
      IIIii_Class4 var13 = new IIIii_Class4(() -> floatOf(var1), var1x -> {
         try {
            var2.call(new Object[]{var1x});
         } catch (Exception var3x) {
            RockstarClient.I_field_ab0f6068.error("[PyUi] slider", var3x);
         }
      }, var3, var4);
      if (var5 > 0.0F) {
         var13.I_method_ec139357(var5);
      }

      if (var6 != null) {
         var13.I_method_d0f09cd6(var6);
      }

      if (var7 != null) {
         var13.i_method_e7aa34f6(var7);
      }

      if (var8 != null) {
         var13.II_method_10143c33(var8);
      }

      if (var9 != null) {
         var13.Ii_method_26cdd453(var9);
      }

      if (var10 >= 0.0F) {
         var13.II_method_c1e3e6b4(var10);
      }

      if (var11 >= 0.0F) {
         var13.Ii_method_ec05fed4(var11);
      }

      if (var12 > 0.0F) {
         var13.i_method_1635ab77(var12);
      }

      var13.I_method_d614f735();
      return new Node(var13);
   }

   public Node textInput(PyCallable var1, PyCallable var2, String var3, ColorRGBA var4, ColorRGBA var5) {
      String var6 = "";

      try {
         Object var7 = var1.call(new Object[0]);
         var6 = var7 == null ? "" : var7.toString();
      } catch (Exception var8) {
      }

      IIiII_Class5 var9 = new IIiII_Class5(font("regular", 7.0F), var6, var1x -> {
         try {
            var2.call(new Object[]{var1x});
         } catch (Exception var3x) {
            RockstarClient.I_field_ab0f6068.error("[PyUi] text", var3x);
         }
      });
      var9.i_method_459bf75f(var3 != null ? var3 : "");
      if (var4 != null) {
         var9.I_method_6c6d30d6(var4);
      }

      if (var5 != null) {
         var9.i_method_8326c8f6(var5);
      }

      var9.I_method_49a8a757(6.0F);
      var9.i_method_e2c562d5();
      var9.Ii_method_3f6d8e94(22.0F);
      return new Node(var9);
   }

   public Node swatch(PyCallable var1) {
      iIiI_Class11 var2 = new iIiI_Class11(() -> {
         try {
            return var1.call(new Object[0]) instanceof ColorRGBA var2x ? var2x : IiiiiIIIi_Class242.Ii_field_d0c8ec5;
         } catch (Exception var3) {
            return IiiiiIIIi_Class242.Ii_field_d0c8ec5;
         }
      });
      var2.I_method_cf493dcb(14.0F, 14.0F);
      var2.interactive(false);
      return new Node(var2);
   }

   public Node icon(String var1, float var2, ColorRGBA var3) {
      Iii_Class4 var4 = new Iii_Class4().icon(var1, var2, var3 != null ? var3 : IiiiiIIIi_Class242.iII_field_d0c8ec5);
      var4.size(var2, var2);
      return new Node(var4);
   }

   public Node image(Object var1, float var2, float var3, Object var4) {
      Identifier var5 = (Identifier)var1;
      Iii_Class4 var6 = new Iii_Class4();
      if (var4 instanceof PyCallable var7) {
         var6.image(var5, var2, var3, var1x -> callColor(var7));
      } else if (var4 instanceof ColorRGBA var8) {
         var6.image(var5, var2, var3, var8);
      } else {
         var6.image(var5, var2, var3, (ColorRGBA)null);
      }

      var6.size(var2, var2);
      var6.interactive(false);
      return new Node(var6);
   }

   public Node space(float var1) {
      return new Node(new Iii_Class4().size(var1, var1));
   }

   public Node divider() {
      Iii_Class4 var1 = new Iii_Class4().background(IiiiiIIIi_Class242.IiI_field_d0c8ec5);
      var1.fillWidth();
      var1.height(1.0F);
      return new Node(var1);
   }

   public ColorRGBA color(String var1) {
      if (var1 == null) {
         return IiiiiIIIi_Class242.iII_field_d0c8ec5;
      } else {
         String var2 = var1.toLowerCase();

         return switch (var2) {
            case "accent" -> IiiiiIIIi_Class242.ii_field_d0c8ec5;
            case "text" -> IiiiiIIIi_Class242.iII_field_d0c8ec5;
            case "background", "bg" -> IiiiiIIIi_Class242.II_method_190e6391();
            case "second" -> IiiiiIIIi_Class242.IIi_field_d0c8ec5;
            case "outline" -> IiiiiIIIi_Class242.IiI_field_d0c8ec5;
            case "white" -> IiiiiIIIi_Class242.Ii_field_d0c8ec5;
            default -> IiiiiIIIi_Class242.iII_field_d0c8ec5;
         };
      }
   }

   private static IIiIIi_Class10 font(String var0, float var1) {
      float var2 = var1 > 0.0F ? var1 : 8.0F;
      return IIiIiI_Class11.I_method_1fee2501(var0 == null ? "medium" : var0).I_method_3a2d5e3(var2);
   }

   private static String fmt(float var0) {
      return var0 == Math.rint(var0) ? String.valueOf((int)var0) : String.format("%.1f", var0);
   }

   private static boolean truthy(PyCallable var0) {
      try {
         return Boolean.TRUE.equals(var0.call(new Object[0]));
      } catch (Exception var2) {
         return false;
      }
   }

   private static float floatOf(PyCallable var0) {
      try {
         return var0.call(new Object[0]) instanceof Number var2 ? var2.floatValue() : 0.0F;
      } catch (Exception var3) {
         return 0.0F;
      }
   }

   private static ColorRGBA callColor(PyCallable var0) {
      try {
         return var0.call(new Object[0]) instanceof ColorRGBA var2 ? var2 : IiiiiIIIi_Class242.iII_field_d0c8ec5;
      } catch (Exception var3) {
         return IiiiiIIIi_Class242.iII_field_d0c8ec5;
      }
   }
}
