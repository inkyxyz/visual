package pyrock;

import java.util.List;
import net.minecraft.text.Text;
import pyrock.classes.PyDynamicIsland;
import pyrock.classes.PyModule;
import pyrock.classes.PyMusic;
import pyrock.classes.settings.PyBooleanSetting;
import pyrock.classes.settings.PyButtonSetting;
import pyrock.classes.settings.PyColorSetting;
import pyrock.classes.settings.PyModeSetting;
import pyrock.classes.settings.PyRangeSetting;
import pyrock.classes.settings.PySelectSetting;
import pyrock.classes.settings.PySliderSetting;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.Setting;
import rockstar.client.BooleanSetting;
import rockstar.client.IIiii_Class8;
import rockstar.client.ButtonSetting;
import rockstar.client.ColorSetting;
import rockstar.client.ModeSetting;
import rockstar.client.RangeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleEntry;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIIiiiI_Class207;
import rockstar.client.IiiIiIIiI_Class211;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIiIi_Class294;

public class Client {
   public void msg(String var1) {
      iIIIIIIii_Class260.I_method_468cf607(Text.of(var1));
   }

   public void warn(String var1) {
      iIIIIIIii_Class260.i_method_70898627(Text.of(var1));
   }

   public void error(String var1) {
      iIIIIIIii_Class260.II_method_e8fd4864(Text.of(var1));
   }

   public void overlay(String var1) {
      iIIIIIIii_Class260.I_method_8e5dab64(iIIIIIIii_Class260.Nested1_8542d060.II_field_66cf1227, Text.of(var1));
   }

   public void cursor(String var1) {
      String var3 = var1.toLowerCase();

      iIIIiIIIi_Class274 var2 = switch (var3) {
         case "arrow", "default" -> iIIIiIIIi_Class274.I_field_aa52e62c;
         case "hand", "pointer" -> iIIIiIIIi_Class274.i_field_aa52e62c;
         case "text", "ibeam" -> iIIIiIIIi_Class274.iI_field_aa52e62c;
         case "crosshair" -> iIIIiIIIi_Class274.ii_field_aa52e62c;
         case "hresize", "horizontal" -> iIIIiIIIi_Class274.II_field_aa52e62c;
         case "vresize", "vertical" -> iIIIiIIIi_Class274.Ii_field_aa52e62c;
         case "block", "notallowed" -> iIIIiIIIi_Class274.III_field_aa52e62c;
         case "resize", "resizeall" -> iIIIiIIIi_Class274.IIi_field_aa52e62c;
         default -> iIIIiIIIi_Class274.I_field_aa52e62c;
      };
      iIIIiIIiI_Class275.I_method_e7d43867(var2);
   }

   public Object find(String var1, String var2) {
      ModuleEntry var3;
      try {
         var3 = RockstarClient.getInstance().getModuleManager().getModuleByName(var1);
      } catch (Exception var6) {
         return null;
      }

      if (var3 == null) {
         return null;
      } else if (var2 != null && !var2.isEmpty()) {
         for (Setting var5 : var3.getSettings()) {
            if (matchesSetting(var5, var2)) {
               return this.wrapSetting(var5);
            }
         }

         return null;
      } else {
         return new PyModule(var3);
      }
   }

   public PyDynamicIsland island() {
      return new PyDynamicIsland();
   }

   public PyDynamicIsland dynamicIsland() {
      return this.island();
   }

   public PyMusic music() {
      return new PyMusic();
   }

   public boolean menu_opened() {
      return iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen instanceof IiiIIiiiI_Class207
         || iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen instanceof IiiIiIIiI_Class211;
   }

   public float fontWidth(String var1, float var2, String var3) {
      return IIiIiI_Class11.I_method_1fee2501(var1).I_method_3a2d5e3(var2).I_method_2c375926(var3);
   }

   public float fontHeight(String var1, float var2) {
      return IIiIiI_Class11.I_method_1fee2501(var1).I_method_3a2d5e3(var2).I_method_a649725c();
   }

   public Object find(String var1) {
      return this.find(var1, null);
   }

   private static boolean matchesSetting(Setting var0, String var1) {
      String var2 = var0.getName();
      if (!looseEquals(var2, var1) && !looseEquals(IiIiIIII_Class81.I_method_f25a980a(var2), var1)) {
         int var3 = var2.lastIndexOf(46);
         return var3 >= 0 && var3 < var2.length() - 1 && looseEquals(var2.substring(var3 + 1), var1);
      } else {
         return true;
      }
   }

   private static boolean looseEquals(String var0, String var1) {
      return var0 != null && var1 != null ? var0.replace(" ", "").equalsIgnoreCase(var1.replace(" ", "")) : false;
   }

   private Object wrapSetting(Setting var1) {
      if (var1 instanceof BooleanSetting) {
         return new PyBooleanSetting((BooleanSetting)var1);
      } else if (var1 instanceof SliderSetting) {
         return new PySliderSetting((SliderSetting)var1);
      } else if (var1 instanceof ModeSetting) {
         return new PyModeSetting((ModeSetting)var1);
      } else if (var1 instanceof MultiSelectSetting) {
         return new PySelectSetting((MultiSelectSetting)var1);
      } else if (var1 instanceof RangeSetting) {
         return new PyRangeSetting((RangeSetting)var1);
      } else if (var1 instanceof ColorSetting) {
         return new PyColorSetting((ColorSetting)var1);
      } else {
         return var1 instanceof ButtonSetting ? new PyButtonSetting((ButtonSetting)var1) : null;
      }
   }

   public List<PyModule> modules() {
      return RockstarClient.getInstance().getModuleManager().getModules().stream().map(PyModule::new).toList();
   }

   public String gameDir() {
      return IiIIiIII_Class73.I_field_3a58077.getAbsolutePath();
   }

   public IIiii_Class8 border(double var1) {
      return IIiii_Class8.I_method_893b2757((float)var1);
   }

   public IIiii_Class8 border4(double var1, double var3, double var5, double var7) {
      return new IIiii_Class8((float)var1, (float)var3, (float)var5, (float)var7);
   }
}
