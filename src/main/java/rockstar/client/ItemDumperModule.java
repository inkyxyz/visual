package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Item Dumper",
   category = ModuleCategory.OTHER,
   III_method_a89e5834 = "modules.descriptions.item_dumper"
)
public class ItemDumperModule extends Module {
   private static final File I_field_3a58077 = new File(IiIIiIII_Class73.I_field_3a58077, "item_dump.json");
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private final Map<String, JsonObject> I_field_a567c40b = new LinkedHashMap<>();
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private boolean I_field_5a;

   public ItemDumperModule() {
      this.IiI_method_5dfd9e9f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_5dfd9e9f() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.item_dumper.only_custom");
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.item_dumper.alerts");
   }

   @Override
   public void onEnable() {
      this.I_field_a567c40b.clear();
      this.I_field_5a = false;
      iIIIIIIii_Class260.I_method_468cf607(
         Text.of(
            "\u0414\u0430\u043c\u043f \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432 \u043f\u0438\u0448\u0435\u0442\u0441\u044f \u0432 "
               + I_field_3a58077.getName()
               + ", \u043f\u043e\u0445\u043e\u0434\u0438 \u043f\u043e \u0430\u0443\u043a\u0446\u0438\u043e\u043d\u0443"
         )
      );
      super.onEnable();
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         if (this.I_field_991c1e8c.I_method_58432069(200L)) {
            this.I_field_991c1e8c.I_method_23e11e3f();
            if (I_field_3a9bda27.currentScreen instanceof HandledScreen) {
               ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
               if (var1 != null && var1 != I_field_3a9bda27.player.playerScreenHandler) {
                  int var2 = Math.max(0, var1.slots.size() - 36);

                  for (int var3 = 0; var3 < var2; var3++) {
                     this.I_method_c0afa741(var1.getSlot(var3).getStack());
                  }
               }
            }

            if (this.I_field_5a && this.i_field_991c1e8c.I_method_58432069(2000L)) {
               this.Iii_method_5e0c2a7f();
               this.I_field_5a = false;
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void I_method_c0afa741(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         List var2 = var1.getTooltip(TooltipContext.create(I_field_3a9bda27.world), I_field_3a9bda27.player, TooltipType.BASIC);
         NbtCompound var3 = Iiiiiiiii_Class256.I_method_a9db800a(var1);
         IiiiiIiii_Class248.Nested1_95187080 var4 = IiiiiIiii_Class248.I_method_7613ca72(var1);
         boolean var5 = var4 != null || var3 != null && !var3.isEmpty() || var1.hasEnchantments() || var2.size() > 1;
         if (!this.I_field_ba20ca4c.i_method_9b12da03() || var5) {
            String var6 = Registries.ITEM.getId(var1.getItem()).toString();
            String var7 = var1.getName().getString();
            String var8 = Iiiiiiiii_Class256.i_method_524c3f7f(var1);
            ArrayList var9 = new ArrayList();

            for (int var10 = 1; var10 < var2.size(); var10++) {
               String var11 = ((Text)var2.get(var10)).getString();
               if (!var11.isBlank()) {
                  var9.add(var11);
               }
            }

            String var16 = var6 + "|" + var7 + "|" + String.join("\u0001", var9);
            JsonObject var17 = this.I_field_a567c40b.get(var16);
            if (var17 != null) {
               var17.addProperty("seen", var17.get("seen").getAsInt() + 1);
            } else {
               JsonObject var12 = new JsonObject();
               var12.addProperty("id", var6);
               var12.addProperty("name", var7);
               var12.addProperty("clean", var8);
               var12.addProperty("count", var1.getCount());
               var12.addProperty("seen", 1);
               var12.addProperty("damageable", var1.isDamageable());
               if (var1.isDamageable()) {
                  var12.addProperty("damage", var1.getDamage());
                  var12.addProperty("maxDamage", var1.getMaxDamage());
               }

               JsonArray var13 = new JsonArray();

               for (String var15 : (Iterable<String>)(Iterable<?>)var9) {
                  var13.add(var15);
               }

               var12.add("lore", var13);
               if (var3 != null && !var3.isEmpty()) {
                  var12.addProperty("nbt", var3.toString());
               }

               if (var4 != null) {
                  JsonObject var18 = new JsonObject();
                  var18.addProperty("category", var4.I_method_7d1d70b().name());
                  var18.addProperty("display", var4.I_method_2310f504(var1));
                  if (var4.I_method_3665aca6() != null) {
                     var18.addProperty("type", var4.I_method_3665aca6());
                  }

                  if (var4.I_method_f2691022() != null) {
                     var18.addProperty("rank", var4.I_method_f2691022().name());
                  }

                  var18.addProperty("server", var4.I_method_f2690c42().name());
                  var12.add("detected", var18);
               }

               this.I_field_a567c40b.put(var16, var12);
               this.I_field_5a = true;
               if (this.i_field_ba20ca4c.i_method_9b12da03()) {
                  RockstarClient.getInstance().I_method_5cb1af22().I_method_67864747(new iiiIiIi_Class118(var8, var1.getItem()));
               }
            }
         }
      }
   }

   private void Iii_method_5e0c2a7f() {
      try {
         JsonArray var1 = new JsonArray();

         for (JsonObject var3 : this.I_field_a567c40b.values()) {
            var1.add(var3);
         }

         JsonObject var5 = new JsonObject();
         var5.addProperty("total", this.I_field_a567c40b.size());
         var5.add("items", var1);
         IiIIiIII_Class73.I_method_3b2973c6(I_field_3a58077, var5);
      } catch (Exception var4) {
         System.err.println("Error saving item dump: " + var4.getMessage());
      }
   }

   @Override
   public void onDisable() {
      if (!this.I_field_a567c40b.isEmpty()) {
         this.Iii_method_5e0c2a7f();
         iIIIIIIii_Class260.I_method_468cf607(
            Text.of(
               "\u0421\u043e\u0431\u0440\u0430\u043d\u043e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432: "
                  + this.I_field_a567c40b.size()
                  + " -> "
                  + I_field_3a58077.getPath()
            )
         );
      }

      super.onDisable();
   }

   @Generated
   public BooleanSetting I_method_da877ed5() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting i_method_f01cf2b5() {
      return this.i_field_ba20ca4c;
   }

   @Generated
   public Map<String, JsonObject> i_method_7f5681f4() {
      return this.I_field_a567c40b;
   }

   @Generated
   public iiIiIIiii_Class424 I_method_b982d315() {
      return this.I_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 i_method_cf1846f5() {
      return this.i_field_991c1e8c;
   }

   @Generated
   public boolean IiI_method_5dfd9ea3() {
      return this.I_field_5a;
   }
}
