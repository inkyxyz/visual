package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.window.KeyPressEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Inventory Builder",
   category = ModuleCategory.OTHER,
   III_method_a89e5834 = "modules.descriptions.inventory_builder"
)
public class InventoryBuilderModule extends Module {
   public static final int I_field_49 = 41;
   public static final int i_field_49 = 36;
   public static final int II_field_49 = 40;
   private static final List<String> I_field_7865b31 = List.of("gear", "spheres", "runes", "explosives", "potions", "backpacks", "other");
   private static final List<InventoryBuilderModule.Nested1_210a0440> i_field_7865b31 = new ArrayList<>();
   private static final File I_field_3a58077 = new File(new File(IiIIiIII_Class73.I_field_3a58077, "presets"), "invbuilder");
   private static final String I_field_523beb0a = ".rock";
   private static final File i_field_3a58077 = new File(IiIIiIII_Class73.I_field_3a58077, "loadouts.json");
   private static final Pattern I_field_5fd3861f = Pattern.compile("(?i)(con|prn|aux|nul|com\\d|lpt\\d)");
   private static boolean I_field_5a;
   private ButtonSetting I_field_bbd4b28c;
   private ButtonSetting i_field_bbd4b28c;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private SliderSetting II_field_73178e8c;
   private BooleanSetting I_field_ba20ca4c;
   private static final Pattern i_field_5fd3861f = Pattern.compile("\u0443\u0432\u0435\u043b\u0438\u0447\u0438\u0442\u044c\\D+(\\d+)");
   private static final Pattern II_field_5fd3861f = Pattern.compile("\u0443\u043c\u0435\u043d\u044c\u0448\u0438\u0442\u044c\\D+(\\d+)");
   private static final Pattern Ii_field_5fd3861f = Pattern.compile("\\((\\d{1,2}):(\\d{2})\\)");
   private static final Pattern iI_field_5fd3861f = Pattern.compile("\\((\\d+)\\s*/\\s*(\\d+)\\)");
   private static final long I_field_4a = 50L;
   private long i_field_4a;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private final Deque<int[]> I_field_db650847 = new ArrayDeque<>();
   private boolean i_field_5a;
   private int Ii_field_49;
   private int iI_field_49;
   private boolean II_field_5a;
   private int ii_field_49;
   private int III_field_49;
   private InventoryBuilderModule.Nested1_368029 I_field_39dc7866;
   private InventoryBuilderModule.Nested1_210a0440 I_field_43ee5a47;
   private int IIi_field_49;
   private int IiI_field_49;
   private int Iii_field_49;
   private int iII_field_49;
   private int iIi_field_49;
   private long II_field_4a;
   private static final int iiI_field_49 = 3;
   private static final int iii_field_49 = 8;
   private int IIII_field_49;
   private int IIIi_field_49;
   private int IIiI_field_49;
   private int IIii_field_49;
   private int IiII_field_49;
   private String i_field_523beb0a;
   private int IiIi_field_49;
   private final Set<Integer> I_field_a56a8dc5;
   private int IiiI_field_49;
   private final Set<String> i_field_a56a8dc5;
   private String II_field_523beb0a;
   private volatile boolean Ii_field_5a;
   private volatile String Ii_field_523beb0a;
   private int Iiii_field_49;
   private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41;
   private int iIII_field_49;
   private static final List<InventoryBuilderModule.Nested1_210a0420> II_field_7865b31 = new ArrayList<>();

   public static String i_method_9e3edd77(String var0) {
      return iIIIIiIiI_Class267.i_method_e7444577(var0);
   }

   public static int I_method_419b7e5c(String var0) {
      int var1 = var0 == null ? -1 : I_field_7865b31.indexOf(var0);
      return var1 < 0 ? I_field_7865b31.size() : var1;
   }

   public InventoryBuilderModule() {
      this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.I_field_39dc7866;
      this.iII_field_49 = -1;
      this.iIi_field_49 = -1;
      this.IIII_field_49 = -1;
      this.IIIi_field_49 = -1;
      this.IIiI_field_49 = 8;
      this.IiII_field_49 = -1;
      this.i_field_523beb0a = "";
      this.I_field_a56a8dc5 = new HashSet<>();
      this.i_field_a56a8dc5 = new HashSet<>();
      this.II_field_523beb0a = "";
      this.Ii_field_523beb0a = "";
      this.I_field_3d936f41 = var1 -> {
         if (this.IiI_method_161b4ee3() && I_field_3a9bda27.currentScreen != null) {
            if (var1.getKey() == 256 && var1.getAction() == 1) {
               this.I_method_419b7e69("\u043e\u0442\u043c\u0435\u043d\u0430 \u043f\u043e Esc");
            }
         }
      };
      this.i_field_3d936f41 = var1 -> {
         if (this.I_field_39dc7866 != InventoryBuilderModule.Nested1_368029.I_field_39dc7866) {
            if (var1.getPacket() instanceof GameMessageS2CPacket var2) {
               String var5 = var2.content().getString().toLowerCase(Locale.ROOT);
               if (this.I_field_39dc7866 == InventoryBuilderModule.Nested1_368029.II_field_39dc7866) {
                  if (var5.contains("\u043d\u0435 \u0431\u044b\u043b\u043e \u043d\u0430\u0439\u0434\u0435\u043d\u043e")
                     || var5.contains("\u043d\u0438\u0447\u0435\u0433\u043e \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e")) {
                     this.i_field_5a = true;
                  }
               } else if (this.I_field_39dc7866 == InventoryBuilderModule.Nested1_368029.Ii_field_39dc7866
                  || this.I_field_39dc7866 == InventoryBuilderModule.Nested1_368029.iI_field_39dc7866
                  || this.I_field_39dc7866 == InventoryBuilderModule.Nested1_368029.ii_field_39dc7866) {
                  if (!var5.contains("\u043d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e")
                        && !var5.contains("\u043d\u0435 \u0445\u0432\u0430\u0442\u0430\u0435\u0442")
                     || !var5.contains("\u0441\u0440\u0435\u0434\u0441\u0442\u0432")
                        && !var5.contains("\u0434\u0435\u043d\u0435\u0433")
                        && !var5.contains("\u043c\u043e\u043d\u0435\u0442")) {
                     boolean var4 = var5.contains("\u0443\u0436\u0435 \u043a\u0443\u043f")
                        || var5.contains("\u0443\u0436\u0435 \u043f\u0440\u043e\u0434\u0430")
                        || var5.contains("\u0443\u0441\u043f\u0435\u043b")
                        || var5.contains("\u043f\u0435\u0440\u0435\u043a\u0443\u043f")
                        || var5.contains("\u043b\u043e\u0442")
                           && (
                              var5.contains("\u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d")
                                 || var5.contains("\u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442")
                                 || var5.contains("\u0441\u043d\u044f\u0442")
                                 || var5.contains("\u0438\u0441\u0442\u0451\u043a")
                                 || var5.contains("\u0438\u0441\u0442\u0435\u043a")
                           );
                     if (var4) {
                        this.Ii_field_5a = true;
                        this.Ii_field_523beb0a = "\u041b\u043e\u0442 \u043f\u0435\u0440\u0435\u0445\u0432\u0430\u0442\u0438\u043b\u0438";
                     }
                  } else {
                     this.Iiii_field_49++;
                     this.Ii_field_5a = true;
                     this.Ii_field_523beb0a = "\u041d\u0435 \u0445\u0432\u0430\u0442\u0438\u043b\u043e \u0434\u0435\u043d\u0435\u0433 \u043d\u0430 \u043b\u043e\u0442";
                  }
               }
            }
         }
      };
      this.iII_method_4af3729f();
   }

   @Compile(
      obfuscation = 4
   )
   private void iII_method_4af3729f() {
      this.I_field_bbd4b28c = new ButtonSetting(this, "modules.settings.inventory_builder.open")
         .I_method_f05556b3(() -> I_field_3a9bda27.setScreen(new IiiIiIiII_Class213()));
      this.i_field_bbd4b28c = new ButtonSetting(this, "modules.settings.inventory_builder.stop", () -> !this.IiI_method_161b4ee3())
         .I_method_f05556b3(
            () -> this.I_method_419b7e69("\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e \u0432\u0440\u0443\u0447\u043d\u0443\u044e")
         );
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.inventory_builder.delay")
         .I_method_c8c9a7d7(100.0F)
         .i_method_65e2aff7(1500.0F)
         .II_method_b0f56334(50.0F)
         .Ii_method_4e0e6b54(300.0F)
         .I_method_d41e7abf("ms");
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.inventory_builder.attempts")
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(15.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(6.0F);
      this.II_field_73178e8c = new SliderSetting(this, "modules.settings.inventory_builder.pages")
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(30.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(6.0F);
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.inventory_builder.sort");
   }

   public boolean IiI_method_161b4ee3() {
      return this.I_field_39dc7866 != InventoryBuilderModule.Nested1_368029.I_field_39dc7866;
   }

   public void I_method_3f7a1202(InventoryBuilderModule.Nested1_210a0440 var1) {
      if (I_field_3a9bda27.player != null && var1 != null) {
         if (var1.I_method_3878a76d() == 0) {
            iIIIIIIii_Class260.i_method_70898627(Text.of("\u041f\u0440\u0435\u0441\u0435\u0442 \u043f\u0443\u0441\u0442\u043e\u0439"));
         } else {
            this.I_field_43ee5a47 = var1;
            this.IIi_field_49 = 0;
            this.IiI_field_49 = 0;
            this.IiiI_field_49 = 0;
            this.II_field_4a = 0L;
            this.I_field_db650847.clear();
            this.I_field_a56a8dc5.clear();
            this.i_field_a56a8dc5.clear();
            this.II_field_523beb0a = "";
            this.Ii_field_5a = false;
            this.Iiii_field_49 = 0;
            this.IiIi_field_49 = 0;
            this.IiII_field_49 = -1;
            this.IIii_field_49 = 0;
            this.i_field_5a = false;
            this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
            this.i_field_991c1e8c.I_method_23e11e3f();
            this.I_field_991c1e8c.I_method_23e11e3f();
            if (!this.isEnabled()) {
               this.enable();
            }

            iIIIIIIii_Class260.I_method_468cf607(
               Text.of(
                  "\u0421\u0431\u043e\u0440\u043a\u0430 \u00ab"
                     + var1.I_field_523beb0a
                     + "\u00bb \u0437\u0430\u043f\u0443\u0449\u0435\u043d\u0430: "
                     + var1.I_method_3878a76d()
                     + " "
                     + I_method_de59dc9c(var1.I_method_3878a76d())
                     + ". \u041e\u0442\u043c\u0435\u043d\u0430 \u2014 Esc"
               )
            );
         }
      }
   }

   public void I_method_419b7e69(String var1) {
      if (this.I_field_39dc7866 != InventoryBuilderModule.Nested1_368029.I_field_39dc7866) {
         this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.I_field_39dc7866;
         this.I_field_43ee5a47 = null;
         this.I_field_db650847.clear();
         iIIIIIIii_Class260.I_method_468cf607(
            Text.of(
               "\u0421\u0431\u043e\u0440\u043a\u0430 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u0430: "
                  + var1
                  + " (\u043a\u0443\u043f\u043b\u0435\u043d\u043e "
                  + this.IiiI_field_49
                  + ")"
            )
         );
      }
   }

   private void iIi_method_4b01fe7f() {
      if (this.I_field_39dc7866 != InventoryBuilderModule.Nested1_368029.I_field_39dc7866) {
         String var1 = this.I_field_43ee5a47 == null ? "" : this.I_field_43ee5a47.I_field_523beb0a;
         this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.I_field_39dc7866;
         this.I_field_43ee5a47 = null;
         this.I_field_db650847.clear();
         iIIIIIIii_Class260.I_method_468cf607(
            Text.of(
               "\u0421\u0431\u043e\u0440\u043a\u0430 \u00ab"
                  + var1
                  + "\u00bb \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u0430: \u043a\u0443\u043f\u043b\u0435\u043d\u043e "
                  + this.IiiI_field_49
                  + " "
                  + i_method_af11307c(this.IiiI_field_49)
            )
         );
      }
   }

   private static String I_method_de59dc9c(int var0) {
      int var1 = var0 % 100;
      int var2 = var0 % 10;
      if (var1 >= 11 && var1 <= 14) {
         return "\u0441\u043b\u043e\u0442\u043e\u0432";
      } else {
         return var2 == 1 ? "\u0441\u043b\u043e\u0442" : (var2 >= 2 && var2 <= 4 ? "\u0441\u043b\u043e\u0442\u0430" : "\u0441\u043b\u043e\u0442\u043e\u0432");
      }
   }

   private static String i_method_af11307c(int var0) {
      int var1 = var0 % 100;
      int var2 = var0 % 10;
      if (var1 >= 11 && var1 <= 14) {
         return "\u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432";
      } else {
         return var2 == 1
            ? "\u043f\u0440\u0435\u0434\u043c\u0435\u0442"
            : (var2 >= 2 && var2 <= 4 ? "\u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430" : "\u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432");
      }
   }

   @Override
   public void II_method_6642fd22() {
      if (this.I_field_39dc7866 != InventoryBuilderModule.Nested1_368029.I_field_39dc7866) {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            if (this.I_field_991c1e8c.I_method_58432069(Math.max(50L, (long)this.I_field_73178e8c.Ii_method_a20abcd2() + this.i_field_4a))) {
               this.I_field_991c1e8c.I_method_23e11e3f();
               this.i_field_4a = ThreadLocalRandom.current().nextLong(-50L, 51L);
               if (this.Ii_field_5a) {
                  this.Ii_field_5a = false;
                  if (this.Iiii_field_49 >= 3) {
                     this.I_method_419b7e69("\u043d\u0435 \u0445\u0432\u0430\u0442\u0430\u0435\u0442 \u0434\u0435\u043d\u0435\u0433");
                     return;
                  }

                  if (this.I_field_39dc7866 == InventoryBuilderModule.Nested1_368029.Ii_field_39dc7866
                     || this.I_field_39dc7866 == InventoryBuilderModule.Nested1_368029.iI_field_39dc7866
                     || this.I_field_39dc7866 == InventoryBuilderModule.Nested1_368029.ii_field_39dc7866) {
                     this.II_method_4927aa2c(
                        this.Ii_field_523beb0a.isEmpty() ? "\u041b\u043e\u0442 \u043d\u0435 \u043a\u0443\u043f\u043b\u0435\u043d" : this.Ii_field_523beb0a
                     );
                     return;
                  }
               }

               switch (this.I_field_39dc7866) {
                  case i_field_39dc7866:
                     this.iiI_method_4cb662bf();
                     break;
                  case II_field_39dc7866:
                     this.iii_method_4cc4ee9f();
                     break;
                  case Ii_field_39dc7866:
                     this.IIII_method_76c27082();
                     break;
                  case iI_field_39dc7866:
                     this.IIIi_method_76d0fc62();
                     break;
                  case ii_field_39dc7866:
                     this.IIiI_method_788560a2();
                     break;
                  case III_field_39dc7866:
                     this.IiIi_method_ad6c1042();
               }
            }
         } else {
            this.I_method_419b7e69("\u043d\u0435\u0442 \u0438\u0433\u0440\u043e\u043a\u0430");
         }
      }
   }

   private void iiI_method_4cb662bf() {
      while (this.IIi_field_49 < 41 && (this.I_field_43ee5a47.I_field_814f57ec[this.IIi_field_49] == null || this.I_method_d74eb088(this.IIi_field_49))) {
         this.IIi_field_49++;
      }

      if (this.IIi_field_49 >= 41) {
         if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.III_field_39dc7866;
            this.I_field_db650847.clear();
            this.iIi_field_49 = -1;
            this.III_field_49 = 0;
            this.i_field_991c1e8c.I_method_23e11e3f();
            this.IiiI_method_af207482();
         } else {
            this.iIi_method_4b01fe7f();
         }
      } else {
         InventoryBuilderModule.Nested1_210a0420 var1 = this.I_field_43ee5a47.I_field_814f57ec[this.IIi_field_49];
         int var2 = this.I_method_3f6b8615(var1) - this.i_method_fa630635(var1);
         if (var2 <= 0) {
            this.IiII_method_ad5d8462();
         } else if (this.IiI_field_49 >= (int)this.i_field_73178e8c.Ii_method_a20abcd2()) {
            iIIIIIIii_Class260.i_method_70898627(
               Text.of(
                  "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043a\u0443\u043f\u0438\u0442\u044c: "
                     + var1.i_method_34b57866()
                     + ", \u043d\u0435 \u0445\u0432\u0430\u0442\u0430\u0435\u0442 "
                     + var2
               )
            );
            this.IiII_method_ad5d8462();
         } else {
            this.IiiI_method_af207482();
            this.ii_field_49 = 0;
            this.Ii_field_49 = 0;
            this.iI_field_49 = 0;
            this.II_field_5a = false;
            I_field_3a9bda27.player.networkHandler.sendChatCommand("ah search " + this.I_method_e4eb36be(var1));
            this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.II_field_39dc7866;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void iii_method_4cc4ee9f() {
      if (this.i_field_5a) {
         this.i_field_5a = false;
         InventoryBuilderModule.Nested1_210a0420 var18 = this.I_field_43ee5a47.I_field_814f57ec[this.IIi_field_49];
         if (var18 != null) {
            iIIIIIIii_Class260.i_method_70898627(
               Text.of(
                  "\u041d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e \u043d\u0430 \u0430\u0443\u043a\u0446\u0438\u043e\u043d\u0435: "
                     + var18.i_method_34b57866()
               )
            );
         }

         this.IiII_method_ad5d8462();
         this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
      } else if (this.i_field_991c1e8c.I_method_58432069(6000L)) {
         this.IiI_field_49++;
         this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
      } else {
         ScreenHandler var1 = this.I_method_e14fd917();
         if (var1 != null) {
            if (this.ii_method_60ae3fe().contains("\u043f\u043e\u043a\u0443\u043f\u043a")) {
               this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.Ii_field_39dc7866;
               this.i_field_991c1e8c.I_method_23e11e3f();
            } else {
               int[] var2 = this.I_method_d74e3e65();
               if (this.Ii_field_49 > 0) {
                  boolean var3 = var2[1] > 0;
                  if (var3 && var2[0] != this.Ii_field_49) {
                     return;
                  }

                  if (!var3 && !this.i_field_991c1e8c.I_method_58432069(700L)) {
                     return;
                  }

                  this.Ii_field_49 = 0;
                  this.II_field_5a = false;
                  this.i_field_991c1e8c.I_method_23e11e3f();
               }

               InventoryBuilderModule.Nested1_210a0420 var19 = this.I_field_43ee5a47.I_field_814f57ec[this.IIi_field_49];
               int var4 = this.I_method_3f6b8615(var19) - this.i_method_fa630635(var19);
               if (var4 <= 0) {
                  this.IiiI_method_af207482();
                  this.IiII_method_ad5d8462();
                  this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
               } else {
                  int var5 = var1.slots.size() - 36;
                  if (!this.II_field_5a) {
                     boolean var6 = true;
                     int var7 = 0;

                     while (true) {
                        if (var7 < var5) {
                           if (var1.getSlot(var7).getStack().isEmpty()) {
                              var7++;
                              continue;
                           }

                           var6 = false;
                        }

                        if (var6 || !this.i_field_991c1e8c.I_method_58432069(Math.max(400L, (long)this.I_field_73178e8c.Ii_method_a20abcd2()))) {
                           return;
                        }

                        this.II_field_5a = true;
                        break;
                     }
                  }

                  if (var19.i_field_49 > 1 && this.iI_field_49 < 8) {
                     int var20 = this.I_method_204c6db7(var1, var5);
                     if (var20 >= 0 && !this.I_method_9c5e7785(var1.getSlot(var20).getStack())) {
                        this.iI_field_49++;
                        I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var20, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
                        this.II_field_5a = false;
                        this.i_field_991c1e8c.I_method_23e11e3f();
                        return;
                     }

                     if (var20 >= 0) {
                        this.iI_field_49 = 0;
                     }
                  }

                  int var21 = -1;
                  int var22 = 0;
                  long var8 = Long.MAX_VALUE;
                  String var10 = "";

                  for (int var11 = 0; var11 < var5; var11++) {
                     ItemStack var12 = var1.getSlot(var11).getStack();
                     if (this.I_method_f1940844(var12, var19)) {
                        List var13 = this.I_method_150b48a6(var12);
                        if (this.I_method_8f186ef3(var12, var13, var19)) {
                           int var14 = Math.max(1, var12.getCount());
                           long var15 = this.I_method_4db09fa7(var13, var14);
                           if (var15 >= 0L && (var19.I_field_4a <= 0L || var15 <= var19.I_field_4a)) {
                              String var17 = this.I_method_76a8484e(var12, var13, var15);
                              if (!this.i_field_a56a8dc5.contains(var17) && var15 < var8) {
                                 var8 = var15;
                                 var21 = var11;
                                 var22 = var14;
                                 var10 = var17;
                              }
                           }
                        }
                     }
                  }

                  if (var21 >= 0) {
                     this.Iii_field_49 = this.i_method_fa630635(var19);
                     this.iII_field_49 = -1;
                     this.iIII_field_49 = 0;
                     this.II_field_4a = var8;
                     this.II_field_523beb0a = var10;
                     this.Ii_field_5a = false;
                     this.I_field_db650847.clear();
                     if (var22 <= var4) {
                        I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var21, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
                     } else {
                        I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var21, 1, SlotActionType.PICKUP, I_field_3a9bda27.player);
                        this.iIII_field_49 = var4;
                     }

                     this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.Ii_field_39dc7866;
                     this.i_field_991c1e8c.I_method_23e11e3f();
                  } else {
                     int var23 = this.i_method_b451cdd7(var1, var5);
                     if (var23 < 0 || this.ii_field_49 + 1 >= (int)this.II_field_73178e8c.Ii_method_a20abcd2() || var2[1] > 0 && var2[0] >= var2[1]) {
                        iIIIIIIii_Class260.i_method_70898627(
                           Text.of(
                              (
                                    this.i_field_a56a8dc5.isEmpty()
                                       ? "\u041d\u0435\u0442 \u043f\u043e\u0434\u0445\u043e\u0434\u044f\u0449\u0438\u0445 \u043b\u043e\u0442\u043e\u0432: "
                                       : "\u0412\u0441\u0435 \u043f\u043e\u0434\u0445\u043e\u0434\u044f\u0449\u0438\u0435 \u043b\u043e\u0442\u044b \u0440\u0430\u0437\u043e\u0431\u0440\u0430\u043b\u0438: "
                                 )
                                 + var19.i_method_34b57866()
                           )
                        );
                        this.IiiI_method_af207482();
                        this.IiII_method_ad5d8462();
                        this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
                     } else {
                        this.ii_field_49++;
                        this.Ii_field_49 = var2[0] + 1;
                        I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var23, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
                        this.i_field_991c1e8c.I_method_23e11e3f();
                     }
                  }
               }
            }
         }
      }
   }

   private void IIII_method_76c27082() {
      if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
         this.II_method_4927aa2c("\u041b\u043e\u0442 \u043f\u0435\u0440\u0435\u0445\u0432\u0430\u0442\u0438\u043b\u0438");
      } else {
         ScreenHandler var1 = this.I_method_e14fd917();
         if (var1 != null && this.ii_method_60ae3fe().contains("\u043f\u043e\u043a\u0443\u043f\u043a")) {
            int var2 = var1.slots.size() - 36;
            int var3 = -1;
            int var4 = -1;
            int var5 = -1;
            int var6 = -1;
            int var7 = Integer.MAX_VALUE;
            int var8 = -1;
            boolean[] var9 = new boolean[var2];

            for (int var10 = 0; var10 < var2; var10++) {
               ItemStack var11 = var1.getSlot(var10).getStack();
               if (!var11.isEmpty()) {
                  String var12 = var11.getName().getString().toLowerCase(Locale.ROOT);
                  Matcher var13 = i_field_5fd3861f.matcher(var12);
                  Matcher var14 = II_field_5fd3861f.matcher(var12);
                  boolean var15 = false;
                  if (var13.find()) {
                     int var16 = Integer.parseInt(var13.group(1));
                     if (var16 == 1) {
                        var3 = var10;
                     } else if (var16 == 10) {
                        var4 = var10;
                     }

                     var15 = true;
                  } else if (var14.find()) {
                     if (Integer.parseInt(var14.group(1)) == 1) {
                        var5 = var10;
                     }

                     var15 = true;
                  } else if (var12.contains("\u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0434")
                     || var12.contains("\u043a\u0443\u043f\u0438\u0442\u044c")
                     || var12.contains("\u043f\u0440\u0438\u043e\u0431\u0440\u0435\u0441\u0442")) {
                     var6 = var10;
                  }

                  if (var15) {
                     var9[var10] = true;
                     var7 = Math.min(var7, var10);
                     var8 = Math.max(var8, var10);
                  }
               }
            }

            if (var6 == -1 && var8 != -1) {
               for (int var17 = var7 + 1; var17 < var8; var17++) {
                  if (!var9[var17] && !var1.getSlot(var17).getStack().isEmpty()) {
                     var6 = var17;
                     break;
                  }
               }
            }

            if (var6 == -1) {
               this.I_method_aa232e8e(
                  var1,
                  var2,
                  "\u043d\u0435 \u043d\u0430\u0448\u0451\u043b \u043a\u043d\u043e\u043f\u043a\u0443 \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u044f"
               );
            } else if (this.iIII_field_49 > 1 && var3 == -1 && var4 == -1) {
               this.I_method_aa232e8e(
                  var1,
                  var2,
                  "\u043d\u0435 \u043d\u0430\u0448\u0451\u043b \u043a\u043d\u043e\u043f\u043a\u0438 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u0430, \u043d\u0435 \u0431\u0443\u0434\u0443 \u0431\u0440\u0430\u0442\u044c \u0432\u0435\u0441\u044c \u043b\u043e\u0442"
               );
            } else {
               this.iII_field_49 = var6;
               if (this.iIII_field_49 > 1) {
                  this.I_method_8fed6f9f(this.iIII_field_49 - 1, var3, var4, var5);
                  this.iIII_field_49 = 0;
                  this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.iI_field_39dc7866;
                  this.i_field_991c1e8c.I_method_23e11e3f();
               } else {
                  this.iIII_field_49 = 0;
                  I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, this.iII_field_49, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
                  this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.ii_field_39dc7866;
                  this.i_field_991c1e8c.I_method_23e11e3f();
               }
            }
         }
      }
   }

   private void I_method_aa232e8e(ScreenHandler var1, int var2, String var3) {
      StringBuilder var4 = new StringBuilder();

      for (int var5 = 0; var5 < var2; var5++) {
         ItemStack var6 = var1.getSlot(var5).getStack();
         if (!var6.isEmpty()) {
            var4.append(var5).append('=').append(var6.getName().getString()).append("; ");
         }
      }

      RockstarClient.I_field_ab0f6068
         .warn("[InventoryBuilder] \u043c\u0435\u043d\u044e \u043f\u043e\u043a\u0443\u043f\u043a\u0438: {} | \u0441\u043b\u043e\u0442\u044b: {}", var3, var4);
      iIIIIIIii_Class260.i_method_70898627(
         Text.of(
            "\u041c\u0435\u043d\u044e \u043f\u043e\u043a\u0443\u043f\u043a\u0438: "
               + var3
               + " \u2014 \u043b\u043e\u0442 \u043f\u0440\u043e\u043f\u0443\u0449\u0435\u043d"
         )
      );
      this.IiI_field_49++;
      this.iIII_field_49 = 0;
      this.I_field_db650847.clear();
      this.IiiI_method_af207482();
      this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
      this.i_field_991c1e8c.I_method_23e11e3f();
   }

   private void I_method_8fed6f9f(int var1, int var2, int var3, int var4) {
      if (var1 > 0) {
         if (var3 == -1) {
            for (int var12 = 0; var12 < var1 && var2 != -1; var12++) {
               this.I_field_db650847.add(new int[]{var2, 0});
            }
         } else {
            int var5 = var1 / 10;
            int var6 = var1 % 10;
            boolean var7 = var6 > 0 && var4 != -1;
            boolean var8 = var6 == 0 || var2 != -1;
            int var9 = var7 ? var5 + 1 + (10 - var6) : Integer.MAX_VALUE;
            int var10 = var8 ? var5 + var6 : Integer.MAX_VALUE;
            if (var9 <= var10) {
               for (int var14 = 0; var14 <= var5; var14++) {
                  this.I_field_db650847.add(new int[]{var3, 0});
               }

               for (int var15 = 0; var15 < 10 - var6; var15++) {
                  this.I_field_db650847.add(new int[]{var4, 0});
               }
            } else {
               for (int var11 = 0; var11 < var5; var11++) {
                  this.I_field_db650847.add(new int[]{var3, 0});
               }

               for (int var13 = 0; var13 < var6 && var2 != -1; var13++) {
                  this.I_field_db650847.add(new int[]{var2, 0});
               }
            }
         }
      }
   }

   private void IIIi_method_76d0fc62() {
      ScreenHandler var1 = this.I_method_e14fd917();
      if (var1 != null && this.ii_method_60ae3fe().contains("\u043f\u043e\u043a\u0443\u043f\u043a")) {
         int[] var2 = this.I_field_db650847.poll();
         if (var2 != null) {
            this.I_method_e949ec6d(var1, var2);
         } else {
            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, this.iII_field_49, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
            this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.ii_field_39dc7866;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      } else {
         this.I_field_db650847.clear();
         this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.ii_field_39dc7866;
         this.i_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void IIiI_method_788560a2() {
      if (this.i_field_991c1e8c.I_method_58432069(1200L)) {
         InventoryBuilderModule.Nested1_210a0420 var1 = this.I_field_43ee5a47.I_field_814f57ec[this.IIi_field_49];
         int var2 = this.i_method_fa630635(var1);
         if (var2 <= this.Iii_field_49) {
            if (this.i_field_991c1e8c.I_method_58432069(2500L)) {
               this.II_method_4927aa2c("\u041b\u043e\u0442 \u043f\u0435\u0440\u0435\u0445\u0432\u0430\u0442\u0438\u043b\u0438");
            }
         } else {
            this.IiI_field_49 = 0;
            this.Iiii_field_49 = 0;
            this.IiiI_field_49 = this.IiiI_field_49 + (var2 - this.Iii_field_49);
            iIIIIIIii_Class260.I_method_468cf607(
               Text.of(
                  "\u041a\u0443\u043f\u043b\u0435\u043d\u043e "
                     + (var2 - this.Iii_field_49)
                     + "\u00d7 "
                     + var1.i_method_34b57866()
                     + (this.II_field_4a > 0L ? " \u043f\u043e " + iIIiiiiiI_Class319.I_method_10212adb(this.II_field_4a) : "")
               )
            );
            this.II_field_4a = 0L;
            this.II_field_523beb0a = "";
            if (this.I_method_3f6b8615(var1) - var2 > 0
               && this.I_method_e14fd917() != null
               && !this.ii_method_60ae3fe().contains("\u043f\u043e\u043a\u0443\u043f\u043a")) {
               this.IIii_method_7893ec82();
            } else {
               this.IiiI_method_af207482();
               this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void II_method_4927aa2c(String var1) {
      this.IiI_field_49++;
      this.iIII_field_49 = 0;
      this.I_field_db650847.clear();
      if (!this.II_field_523beb0a.isEmpty()) {
         this.i_field_a56a8dc5.add(this.II_field_523beb0a);
      }

      this.II_field_523beb0a = "";
      this.II_field_4a = 0L;
      InventoryBuilderModule.Nested1_210a0420 var2 = this.I_field_43ee5a47 != null && this.IIi_field_49 >= 0 && this.IIi_field_49 < 41
         ? this.I_field_43ee5a47.I_field_814f57ec[this.IIi_field_49]
         : null;
      String var3 = var2 == null ? "" : ": " + var2.i_method_34b57866();
      if (this.IiI_field_49 >= (int)this.i_field_73178e8c.Ii_method_a20abcd2()) {
         iIIIIIIii_Class260.i_method_70898627(
            Text.of(var1 + var3 + " \u2014 \u043f\u0440\u043e\u043f\u0443\u0441\u043a\u0430\u044e \u043f\u0440\u0435\u0434\u043c\u0435\u0442")
         );
         this.IiiI_method_af207482();
         this.IiII_method_ad5d8462();
         this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else {
         iIIIIIIii_Class260.i_method_70898627(Text.of(var1 + var3 + " \u2014 \u0431\u0435\u0440\u0443 \u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0438\u0439"));
         if (this.I_method_e14fd917() != null && !this.ii_method_60ae3fe().contains("\u043f\u043e\u043a\u0443\u043f\u043a")) {
            this.IIii_method_7893ec82();
         } else {
            this.IiiI_method_af207482();
            this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.i_field_39dc7866;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void IIii_method_7893ec82() {
      this.ii_field_49 = 0;
      this.Ii_field_49 = 0;
      this.II_field_5a = false;
      this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.II_field_39dc7866;
      this.i_field_991c1e8c.I_method_23e11e3f();
   }

   private void IiII_method_ad5d8462() {
      this.IIi_field_49++;
      this.IiI_field_49 = 0;
      this.i_field_a56a8dc5.clear();
      this.II_field_523beb0a = "";
   }

   private String I_method_76a8484e(ItemStack var1, List<Text> var2, long var3) {
      StringBuilder var5 = new StringBuilder(Iiiiiiiii_Class256.i_method_524c3f7f(var1).trim().toLowerCase(Locale.ROOT));
      var5.append('|').append(var1.getCount()).append('|').append(var3);

      for (Text var7 : var2) {
         String var8 = var7.getString();
         String var9 = var8.toLowerCase(Locale.ROOT);
         if (var9.contains("\u043f\u0440\u043e\u0434\u0430\u0432") || var9.contains("\u0432\u043b\u0430\u0434\u0435\u043b")) {
            var5.append('|').append(var8.trim());
            break;
         }
      }

      return var5.toString();
   }

   private void IiIi_method_ad6c1042() {
      if (!this.i_field_991c1e8c.I_method_58432069(20000L) && this.III_field_49 <= 400) {
         if (this.I_method_e14fd917() != null) {
            this.IiiI_method_af207482();
         } else {
            PlayerScreenHandler var1 = I_field_3a9bda27.player.playerScreenHandler;
            if (this.IIii_field_49 > 0) {
               this.I_method_3ad9291f(var1);
            } else if (!var1.getCursorStack().isEmpty()) {
               this.i_method_1e9744ff(var1);
            } else {
               for (int var2 = 0; var2 < 41; var2++) {
                  InventoryBuilderModule.Nested1_210a0420 var3 = this.I_field_43ee5a47.I_field_814f57ec[var2];
                  if (var3 != null) {
                     int var4 = this.I_method_d74eb077(var2);
                     if (!this.I_field_a56a8dc5.contains(var4)) {
                        ItemStack var5 = var1.getSlot(var4).getStack();
                        boolean var6 = this.I_method_f1940844(var5, var3);
                        int var7 = var6 ? var5.getCount() : 0;
                        if (!var6 || var7 != var3.i_field_49) {
                           if (!var6) {
                              int var8 = this.I_method_35d56d17(var1, var3, var4, 0, var5);
                              if (var8 >= 0) {
                                 this.I_method_e941bdbf(var1, var8, var4);
                                 return;
                              }
                           } else if (this.I_method_6bbf4de4(var1, var3, var4, var5, var7)) {
                              return;
                           }
                        }
                     }
                  }
               }

               this.iIi_method_4b01fe7f();
            }
         }
      } else {
         this.I_method_419b7e69(
            this.III_field_49 > 400
               ? "\u0440\u0430\u0441\u043a\u043b\u0430\u0434\u043a\u0430 \u043d\u0435 \u0441\u0445\u043e\u0434\u0438\u0442\u0441\u044f"
               : "\u0440\u0430\u0441\u043a\u043b\u0430\u0434\u043a\u0430 \u0437\u0430\u0432\u0438\u0441\u043b\u0430"
         );
      }
   }

   private void I_method_e941bdbf(ScreenHandler var1, int var2, int var3) {
      this.III_field_49++;
      this.I_method_204c6dc4(var1, var3);
      if (var3 >= 36 && var3 <= 44) {
         this.i_method_d5e8619f(var1, var2, var3 - 36);
      } else if (var2 >= 36 && var2 <= 44) {
         this.i_method_d5e8619f(var1, var3, var2 - 36);
      } else {
         this.IIII_field_49 = var2;
         this.IIIi_field_49 = var3;
         this.IIiI_field_49 = this.I_method_e941bdb2(var1, var2, var3);
         this.IIii_field_49 = 1;
         this.i_method_d5e8619f(var1, this.IIII_field_49, this.IIiI_field_49);
      }
   }

   private void I_method_3ad9291f(ScreenHandler var1) {
      this.III_field_49++;
      if (this.IIii_field_49 == 1) {
         this.IIii_field_49 = 2;
         this.i_method_d5e8619f(var1, this.IIIi_field_49, this.IIiI_field_49);
      } else {
         this.IIii_field_49 = 0;
         this.i_method_d5e8619f(var1, this.IIII_field_49, this.IIiI_field_49);
      }
   }

   private void i_method_d5e8619f(ScreenHandler var1, int var2, int var3) {
      I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, var3, SlotActionType.SWAP, I_field_3a9bda27.player);
      this.i_field_991c1e8c.I_method_23e11e3f();
   }

   private int I_method_e941bdb2(ScreenHandler var1, int var2, int var3) {
      for (int var4 = 44; var4 >= 36; var4--) {
         if (var4 != var2 && var4 != var3 && !this.i_method_d911a0a8(var4) && var1.getSlot(var4).getStack().isEmpty()) {
            return var4 - 36;
         }
      }

      for (int var5 = 44; var5 >= 36; var5--) {
         if (var5 != var2 && var5 != var3 && !this.i_method_d911a0a8(var5)) {
            return var5 - 36;
         }
      }

      return 8;
   }

   private boolean I_method_6bbf4de4(ScreenHandler var1, InventoryBuilderModule.Nested1_210a0420 var2, int var3, ItemStack var4, int var5) {
      if (var5 > var2.i_field_49) {
         this.III_field_49++;
         this.I_method_204c6dc4(var1, var3);
         this.II_method_fc8d6a02(var1, var3, 0);
         return true;
      } else {
         int var6 = this.I_method_35d56d17(var1, var2, var3, var5, var4);
         if (var6 < 0) {
            return false;
         } else {
            this.III_field_49++;
            this.I_method_204c6dc4(var1, var3);
            this.II_method_fc8d6a02(var1, var6, 0);
            return true;
         }
      }
   }

   private void i_method_1e9744ff(ScreenHandler var1) {
      ItemStack var2 = var1.getCursorStack();

      for (int var3 = 0; var3 < 41; var3++) {
         InventoryBuilderModule.Nested1_210a0420 var4 = this.I_field_43ee5a47.I_field_814f57ec[var3];
         if (var4 != null) {
            int var5 = this.I_method_d74eb077(var3);
            if (!this.I_field_a56a8dc5.contains(var5) && this.I_method_f1940844(var2, var4)) {
               ItemStack var6 = var1.getSlot(var5).getStack();
               int var7 = this.I_method_f1940844(var6, var4) ? var6.getCount() : 0;
               if (var7 < var4.i_field_49 && (var6.isEmpty() || var7 != 0) && (var7 <= 0 || ItemStack.areItemsAndComponentsEqual(var6, var2))) {
                  boolean var8 = var7 + var2.getCount() <= var4.i_field_49;
                  this.II_method_fc8d6a02(var1, var5, var8 ? 0 : 1);
                  return;
               }
            }
         }
      }

      int var9 = this.I_method_3ad92912(var1);
      if (var9 < 0) {
         this.I_method_419b7e69("\u043d\u0435\u0442 \u0441\u0432\u043e\u0431\u043e\u0434\u043d\u043e\u0433\u043e \u0441\u043b\u043e\u0442\u0430");
      } else {
         this.II_method_fc8d6a02(var1, var9, 0);
      }
   }

   private int I_method_35d56d17(ScreenHandler var1, InventoryBuilderModule.Nested1_210a0420 var2, int var3, int var4, ItemStack var5) {
      for (int var6 = 5; var6 <= 45; var6++) {
         if (var6 != var3) {
            ItemStack var7 = var1.getSlot(var6).getStack();
            if (this.I_method_f1940844(var7, var2) && !this.I_method_204c6dc8(var1, var6) && (var4 <= 0 || ItemStack.areItemsAndComponentsEqual(var5, var7))) {
               return var6;
            }
         }
      }

      return -1;
   }

   private void II_method_fc8d6a02(ScreenHandler var1, int var2, int var3) {
      if (this.IiII_field_49 != var2 || !this.I_method_e766475c(var1, var2).equals(this.i_field_523beb0a)) {
         this.IiIi_field_49 = 0;
      } else if (++this.IiIi_field_49 >= 3) {
         iIIIIIIii_Class260.i_method_70898627(
            Text.of(
               "\u0421\u043b\u043e\u0442 "
                  + var2
                  + " \u043d\u0435 \u043e\u0442\u0432\u0435\u0447\u0430\u0435\u0442, \u043f\u0440\u043e\u043f\u0443\u0441\u043a\u0430\u044e"
            )
         );
         this.I_field_a56a8dc5.add(var2);
         this.IiIi_field_49 = 0;
      }

      this.IiII_field_49 = var2;
      this.i_field_523beb0a = this.I_method_e766475c(var1, var2);
      I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, var3, SlotActionType.PICKUP, I_field_3a9bda27.player);
      this.i_field_991c1e8c.I_method_23e11e3f();
   }

   private String I_method_e766475c(ScreenHandler var1, int var2) {
      ItemStack var3 = var1.getSlot(var2).getStack();
      return var3.isEmpty() ? "-" : Registries.ITEM.getId(var3.getItem()) + "x" + var3.getCount();
   }

   private void I_method_204c6dc4(ScreenHandler var1, int var2) {
      this.IiII_field_49 = var2;
      this.i_field_523beb0a = this.I_method_e766475c(var1, var2);
   }

   private void I_method_e949ec6d(ScreenHandler var1, int[] var2) {
      SlotActionType var3 = var2.length > 2 && var2[2] == 1 ? SlotActionType.SWAP : SlotActionType.PICKUP;
      I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2[0], var2[1], var3, I_field_3a9bda27.player);
   }

   private int I_method_d74eb077(int var1) {
      if (var1 < 27) {
         return 9 + var1;
      } else if (var1 < 36) {
         return 36 + (var1 - 27);
      } else {
         return var1 < 40 ? 5 + (var1 - 36) : 45;
      }
   }

   private boolean I_method_204c6dc8(ScreenHandler var1, int var2) {
      for (int var3 = 0; var3 < 41; var3++) {
         InventoryBuilderModule.Nested1_210a0420 var4 = this.I_field_43ee5a47.I_field_814f57ec[var3];
         if (var4 != null && this.I_method_d74eb077(var3) == var2) {
            ItemStack var5 = var1.getSlot(var2).getStack();
            if (this.I_method_f1940844(var5, var4) && var5.getCount() == var4.i_field_49) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean I_method_c3a1a943(InventoryBuilderModule.Nested1_210a0420 var1, InventoryBuilderModule.Nested1_210a0420 var2) {
      return var1.I_field_6a3d6525.equals(var2.I_field_6a3d6525) && var1.I_method_a196c846().equalsIgnoreCase(var2.I_method_a196c846());
   }

   private int I_method_3f6b8615(InventoryBuilderModule.Nested1_210a0420 var1) {
      int var2 = 0;

      for (InventoryBuilderModule.Nested1_210a0420 var6 : this.I_field_43ee5a47.I_field_814f57ec) {
         if (var6 != null && this.I_method_c3a1a943(var6, var1)) {
            var2 += var6.i_field_49;
         }
      }

      return var2;
   }

   private boolean I_method_d74eb088(int var1) {
      InventoryBuilderModule.Nested1_210a0420 var2 = this.I_field_43ee5a47.I_field_814f57ec[var1];

      for (int var3 = 0; var3 < var1; var3++) {
         InventoryBuilderModule.Nested1_210a0420 var4 = this.I_field_43ee5a47.I_field_814f57ec[var3];
         if (var4 != null && this.I_method_c3a1a943(var4, var2)) {
            return true;
         }
      }

      return false;
   }

   private int I_method_3ad92912(ScreenHandler var1) {
      for (int var2 = 9; var2 <= 44; var2++) {
         if (var1.getSlot(var2).getStack().isEmpty() && !this.i_method_d911a0a8(var2)) {
            return var2;
         }
      }

      for (int var3 = 9; var3 <= 44; var3++) {
         if (var1.getSlot(var3).getStack().isEmpty()) {
            return var3;
         }
      }

      return -1;
   }

   private boolean i_method_d911a0a8(int var1) {
      for (int var2 = 0; var2 < 41; var2++) {
         if (this.I_field_43ee5a47.I_field_814f57ec[var2] != null && this.I_method_d74eb077(var2) == var1) {
            return true;
         }
      }

      return false;
   }

   private int I_method_204c6db7(ScreenHandler var1, int var2) {
      for (int var3 = 0; var3 < var2; var3++) {
         ItemStack var4 = var1.getSlot(var3).getStack();
         if (!var4.isEmpty() && var4.getName().getString().toLowerCase(Locale.ROOT).contains("\u0441\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u043a\u0430")) {
            return var3;
         }
      }

      return -1;
   }

   private boolean I_method_9c5e7785(ItemStack var1) {
      for (Text var3 : this.I_method_150b48a6(var1)) {
         String var4 = var3.getString().trim();
         String var5 = var4.toLowerCase(Locale.ROOT);
         if (var5.contains("\u0434\u0435\u0448\u0435\u0432") && var5.contains("\u0435\u0434")) {
            return var4.startsWith("\u2713") || var4.startsWith("\u2714");
         }
      }

      return false;
   }

   private int[] I_method_d74e3e65() {
      Matcher var1 = iI_field_5fd3861f.matcher(this.ii_method_60ae3fe());
      return var1.find() ? new int[]{Integer.parseInt(var1.group(1)), Integer.parseInt(var1.group(2))} : new int[]{1, 0};
   }

   private int i_method_b451cdd7(ScreenHandler var1, int var2) {
      for (int var3 = 0; var3 < var2; var3++) {
         ItemStack var4 = var1.getSlot(var3).getStack();
         if (!var4.isEmpty()
            && var4.getName()
               .getString()
               .toLowerCase(Locale.ROOT)
               .contains("\u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0430\u044f \u0441\u0442\u0440\u0430\u043d\u0438\u0446\u0430")) {
            return var3;
         }
      }

      return -1;
   }

   private String I_method_e4eb36be(InventoryBuilderModule.Nested1_210a0420 var1) {
      if (!var1.ii_field_523beb0a.isBlank()) {
         return var1.ii_field_523beb0a;
      } else {
         if (!var1.iI_field_523beb0a.isBlank()) {
            Identifier var2 = Identifier.tryParse(var1.iI_field_523beb0a);
            Potion var3 = var2 == null ? null : (Potion)Registries.POTION.get(var2);
            if (var3 != null && !var3.getEffects().isEmpty()) {
               String var4 = ((StatusEffect)((StatusEffectInstance)var3.getEffects().getFirst()).getEffectType().value()).getName().getString();
               if (!var4.isBlank()) {
                  return "\u0417\u0435\u043b\u044c\u0435 " + var4.toLowerCase(Locale.ROOT);
               }
            }
         }

         String var5 = var1.i_method_34b57866().trim();
         return !var5.isBlank() ? var5 : Text.translatable(((Item)Registries.ITEM.get(var1.I_field_6a3d6525)).getTranslationKey()).getString();
      }
   }

   private int i_method_fa630635(InventoryBuilderModule.Nested1_210a0420 var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < I_field_3a9bda27.player.getInventory().size(); var3++) {
         ItemStack var4 = I_field_3a9bda27.player.getInventory().getStack(var3);
         if (this.I_method_f1940844(var4, var1) && this.I_method_8f186ef3(var4, this.I_method_150b48a6(var4), var1)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   private boolean I_method_f1940844(ItemStack var1, InventoryBuilderModule.Nested1_210a0420 var2) {
      if (var1 != null && !var1.isEmpty()) {
         if (var1.getItem() != Registries.ITEM.get(var2.I_field_6a3d6525)) {
            return false;
         } else {
            String var3 = Iiiiiiiii_Class256.i_method_524c3f7f(var1).trim().toLowerCase(Locale.ROOT);
            if (var2.i_field_5a) {
               return var3.equals(var2.I_method_a196c846().trim().toLowerCase(Locale.ROOT));
            } else {
               String var4 = var2.II_method_969c2c79();
               return var4.isBlank() || var3.contains(var4.toLowerCase(Locale.ROOT));
            }
         }
      } else {
         return false;
      }
   }

   private int I_method_823df30d(List<Text> var1, String var2) {
      String var3 = var2.toLowerCase(Locale.ROOT);

      for (Text var5 : var1) {
         String var6 = var5.getString().trim();
         int var7 = var6.toLowerCase(Locale.ROOT).indexOf(var3);
         if (var7 >= 0) {
            String var8 = var6.substring(var7 + var2.length()).trim();
            int var9 = var8.indexOf(32);
            if (var9 > 0) {
               var8 = var8.substring(0, var9);
            }

            var8 = var8.replaceAll("[^IVX]", "");
            return var8.isEmpty() ? 0 : this.i_method_1252d23c(var8);
         }
      }

      return -1;
   }

   private int i_method_1252d23c(String var1) {
      int var2 = 0;
      int var3 = 0;

      for (int var4 = var1.length() - 1; var4 >= 0; var4--) {
         byte var5 = switch (var1.charAt(var4)) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            default -> 0;
         };
         var2 += var5 < var3 ? -var5 : var5;
         var3 = Math.max(var3, var5);
      }

      return var2;
   }

   private int I_method_fa3f7d43(List<Text> var1) {
      int var2 = 0;
      Matcher var3 = Ii_field_5fd3861f.matcher("");

      for (Text var5 : var1) {
         var3.reset(var5.getString());

         while (var3.find()) {
            var2 = Math.max(var2, Integer.parseInt(var3.group(1)) * 60 + Integer.parseInt(var3.group(2)));
         }
      }

      return var2;
   }

   private boolean I_method_8f186ef3(ItemStack var1, List<Text> var2, InventoryBuilderModule.Nested1_210a0420 var3) {
      if (var3.II_field_49 > 0 && var1.isDamageable() && var1.getMaxDamage() > 0) {
         float var4 = (var1.getMaxDamage() - var1.getDamage()) * 100.0F / var1.getMaxDamage();
         if (var4 < var3.II_field_49) {
            return false;
         }
      }

      for (Entry var5 : var3.I_field_a567c40b.entrySet()) {
         int var6 = this.I_method_823df30d(var2, (String)var5.getKey());
         if (var6 < 0 || var6 < (Integer)var5.getValue()) {
            return false;
         }
      }

      return var3.Ii_field_49 <= 0 || this.I_method_fa3f7d43(var2) >= var3.Ii_field_49;
   }

   private long I_method_4db09fa7(List<Text> var1, int var2) {
      long var3 = -1L;
      long var5 = -1L;

      for (Text var8 : var1) {
         String var9 = var8.getString();
         String var10 = var9.toLowerCase(Locale.ROOT);
         if (var10.contains("\u0446\u0435\u043d\u0430") || var10.contains("\u0441\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c")) {
            int var11 = var9.indexOf(58);
            long var12 = this.I_method_419b7e5d(var11 < 0 ? var9 : var9.substring(var11 + 1));
            if (var12 >= 0L) {
               if (var10.contains("\u0435\u0434")) {
                  var3 = var12;
               } else {
                  var5 = var12;
               }
            }
         }
      }

      if (var3 >= 0L) {
         return var3;
      } else if (var5 >= 0L) {
         return var2 > 1 ? var5 / var2 : var5;
      } else {
         return -1L;
      }
   }

   private long I_method_419b7e5d(String var1) {
      StringBuilder var2 = new StringBuilder();

      for (char var6 : var1.toCharArray()) {
         if (Character.isDigit(var6)) {
            var2.append(var6);
         }
      }

      if (var2.isEmpty()) {
         return -1L;
      } else {
         try {
            return Long.parseLong(var2.toString());
         } catch (NumberFormatException var7) {
            return -1L;
         }
      }
   }

   private List<Text> I_method_150b48a6(ItemStack var1) {
      return var1.getTooltip(TooltipContext.create(I_field_3a9bda27.world), I_field_3a9bda27.player, TooltipType.BASIC);
   }

   private String ii_method_60ae3fe() {
      return I_field_3a9bda27.currentScreen == null ? "" : I_field_3a9bda27.currentScreen.getTitle().getString().toLowerCase(Locale.ROOT);
   }

   private ScreenHandler I_method_e14fd917() {
      if (!(I_field_3a9bda27.currentScreen instanceof HandledScreen)) {
         return null;
      } else {
         ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
         return var1 != null && var1 != I_field_3a9bda27.player.playerScreenHandler ? var1 : null;
      }
   }

   private void IiiI_method_af207482() {
      ScreenHandler var1 = this.I_method_e14fd917();
      if (var1 != null) {
         I_field_3a9bda27.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(var1.syncId));
         I_field_3a9bda27.player.closeHandledScreen();
      }
   }

   @Override
   public void onDisable() {
      this.I_field_39dc7866 = InventoryBuilderModule.Nested1_368029.I_field_39dc7866;
      this.I_field_43ee5a47 = null;
      this.I_field_db650847.clear();
      super.onDisable();
   }

   public static void IiI_method_161b4edf() {
      if (II_field_7865b31.isEmpty()) {
         try {
            try (InputStream var0 = InventoryBuilderModule.class.getResourceAsStream("/assets/rockstar/auction_items.json")) {
               if (var0 == null) {
                  return;
               }

               JsonObject var1 = (JsonObject)IiIIiIII_Class73.I_field_fbd77e28.fromJson(new InputStreamReader(var0, StandardCharsets.UTF_8), JsonObject.class);
               if (var1 != null && var1.has("items")) {
                  for (JsonElement var3 : var1.getAsJsonArray("items")) {
                     JsonObject var4 = var3.getAsJsonObject();
                     Identifier var5 = Identifier.tryParse(var4.get("id").getAsString());
                     if (var5 != null) {
                        InventoryBuilderModule.Nested1_210a0420 var6 = new InventoryBuilderModule.Nested1_210a0420(var5, var4.get("query").getAsString());
                        var6.I_field_523beb0a = var4.has("category") ? var4.get("category").getAsString() : "";
                        var6.II_field_523beb0a = var4.has("match") ? var4.get("match").getAsString() : "";
                        var6.Ii_field_523beb0a = var4.has("texture") ? var4.get("texture").getAsString() : "";
                        var6.I_field_49 = var4.has("color") ? var4.get("color").getAsInt() : -1;
                        var6.iI_field_49 = var4.has("duration") ? var4.get("duration").getAsInt() : 0;
                        var6.i_field_5a = !var4.has("exact") || var4.get("exact").getAsBoolean();
                        var6.ii_field_49 = var4.has("budget") ? var4.get("budget").getAsInt() : 0;
                        var6.III_field_49 = var4.has("stack") ? var4.get("stack").getAsInt() : 0;
                        var6.ii_field_523beb0a = var4.has("search") ? var4.get("search").getAsString() : "";
                        var6.I_field_5a = true;
                        if (var4.has("traits")) {
                           for (JsonElement var8 : var4.getAsJsonArray("traits")) {
                              JsonObject var9 = var8.getAsJsonObject();
                              var6.I_field_7865b31.add(new InventoryBuilderModule.Nested1_368049(var9.get("name").getAsString(), var9.get("max").getAsInt()));
                           }
                        }

                        if (var4.has("variants")) {
                           for (JsonElement var16 : var4.getAsJsonArray("variants")) {
                              LinkedHashMap var17 = new LinkedHashMap();

                              for (Entry var11 : var16.getAsJsonObject().entrySet()) {
                                 var17.put((String)var11.getKey(), ((JsonElement)var11.getValue()).getAsInt());
                              }

                              if (!var17.isEmpty()) {
                                 var6.i_field_7865b31.add(var17);
                              }
                           }
                        }

                        I_method_3f6b8622(var6);
                        II_field_7865b31.add(var6);
                     }
                  }

                  return;
               }
            }
         } catch (Exception var14) {
            System.err.println("Error reading auction catalog: " + var14.getMessage());
         }
      }
   }

   private static void I_method_3f6b8622(InventoryBuilderModule.Nested1_210a0420 var0) {
      if (var0.i_field_7865b31.size() == 1) {
         var0.I_field_a567c40b.putAll(var0.i_field_7865b31.getFirst());
      }
   }

   private static void i_method_fa630642(InventoryBuilderModule.Nested1_210a0420 var0) {
      for (InventoryBuilderModule.Nested1_210a0420 var2 : II_field_7865b31) {
         if (var2.I_field_6a3d6525.equals(var0.I_field_6a3d6525) && var2.I_method_a196c846().equalsIgnoreCase(var0.I_method_a196c846())) {
            var0.i_field_523beb0a = var2.i_field_523beb0a;
            var0.II_field_523beb0a = var2.II_field_523beb0a;
            var0.I_field_5a = var2.I_field_5a;
            var0.i_field_5a = var2.i_field_5a;
            var0.Ii_field_523beb0a = var2.Ii_field_523beb0a;
            var0.iI_field_523beb0a = var2.iI_field_523beb0a;
            var0.I_field_49 = var2.I_field_49;
            var0.iI_field_49 = var2.iI_field_49;
            var0.ii_field_49 = var2.ii_field_49;
            var0.III_field_49 = var2.III_field_49;
            var0.ii_field_523beb0a = var2.ii_field_523beb0a;
            var0.I_field_7865b31.clear();
            var0.I_field_7865b31.addAll(var2.I_field_7865b31);
            var0.i_field_7865b31.clear();

            for (Map var4 : var2.i_field_7865b31) {
               var0.i_field_7865b31.add(new LinkedHashMap<>(var4));
            }

            var0.I_field_a567c40b.keySet().removeIf(var1 -> var2.I_field_7865b31.stream().noneMatch(var1x -> var1x.I_method_7fefcfaf().equals(var1)));
            I_method_3f6b8622(var0);
            return;
         }
      }
   }

   public static void Iii_method_1629dabf() {
      IiI_method_161b4edf();
      if (!I_field_5a) {
         I_field_5a = true;
         i_field_7865b31.clear();
         File[] var0 = I_field_3a58077.listFiles((var0x, var1x) -> var1x.toLowerCase(Locale.ROOT).endsWith(".rock"));
         if (var0 != null && var0.length != 0) {
            LinkedHashMap<String, Integer> var1 = new LinkedHashMap<>();
            ArrayList<InventoryBuilderModule.Nested1_210a0440> var2 = new ArrayList<>();

            for (File var6 : var0) {
               String var7 = var6.getName();

               try (FileReader var8 = new FileReader(var6, StandardCharsets.UTF_8)) {
                  JsonObject var9 = (JsonObject)IiIIiIII_Class73.I_field_fbd77e28.fromJson(var8, JsonObject.class);
                  InventoryBuilderModule.Nested1_210a0440 var10 = I_method_e21d2406(var9, var7.substring(0, var7.length() - ".rock".length()));
                  if (var10 != null) {
                     var10.i_field_523beb0a = var7;
                     var1.put(var7, var9.has("order") ? var9.get("order").getAsInt() : Integer.MAX_VALUE);
                     var2.add(var10);
                  }
               } catch (Exception var13) {
                  RockstarClient.I_field_ab0f6068
                     .warn(
                        "[InventoryBuilder] \u043f\u0440\u0435\u0441\u0435\u0442 {} \u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f: {}",
                        var7,
                        var13.getMessage()
                     );
               }
            }

            var2.sort(
               Comparator.<InventoryBuilderModule.Nested1_210a0440>comparingInt(var1x -> var1.getOrDefault(var1x.i_field_523beb0a, Integer.MAX_VALUE))
                  .thenComparing(var0x -> var0x.i_field_523beb0a, String.CASE_INSENSITIVE_ORDER)
            );
            i_field_7865b31.addAll(var2);
         } else {
            Iiii_method_af2f0062();
         }
      }
   }

   private static void Iiii_method_af2f0062() {
      if (i_field_3a58077.exists()) {
         ArrayList var0 = new ArrayList();

         try (FileReader var1 = new FileReader(i_field_3a58077, StandardCharsets.UTF_8)) {
            JsonObject var2 = (JsonObject)IiIIiIII_Class73.I_field_fbd77e28.fromJson(var1, JsonObject.class);
            if (var2 != null && var2.has("presets")) {
               for (JsonElement var4 : var2.getAsJsonArray("presets")) {
                  InventoryBuilderModule.Nested1_210a0440 var5 = I_method_e21d2406(var4.getAsJsonObject(), "\u041f\u0440\u0435\u0441\u0435\u0442");
                  if (var5 != null) {
                     var0.add(var5);
                  }
               }
            }
         } catch (Exception var8) {
            RockstarClient.I_field_ab0f6068
               .warn(
                  "[InventoryBuilder] \u0441\u0442\u0430\u0440\u044b\u0435 \u043f\u0440\u0435\u0441\u0435\u0442\u044b \u043d\u0435 \u0447\u0438\u0442\u0430\u044e\u0442\u0441\u044f: {}",
                  var8.getMessage()
               );
            return;
         }

         i_field_7865b31.addAll(var0);
         if (Iii_method_1629dac3()) {
            File[] var9 = I_field_3a58077.listFiles((var0x, var1x) -> var1x.toLowerCase(Locale.ROOT).endsWith(".rock"));
            if (var9 != null && var9.length >= var0.size()) {
               if (!i_field_3a58077.delete()) {
                  i_field_3a58077.deleteOnExit();
               }

               RockstarClient.I_field_ab0f6068
                  .info(
                     "[InventoryBuilder] \u043f\u0440\u0435\u0441\u0435\u0442\u044b \u043f\u0435\u0440\u0435\u043d\u0435\u0441\u0435\u043d\u044b \u0432 {} ({} \u0448\u0442.)",
                     I_field_3a58077,
                     var0.size()
                  );
            } else {
               RockstarClient.I_field_ab0f6068
                  .warn(
                     "[InventoryBuilder] \u043f\u0435\u0440\u0435\u043d\u043e\u0441 \u043f\u0440\u0435\u0441\u0435\u0442\u043e\u0432 \u043d\u0435 \u0443\u0434\u0430\u043b\u0441\u044f, \u0441\u0442\u0430\u0440\u044b\u0439 \u0444\u0430\u0439\u043b \u043e\u0441\u0442\u0430\u0432\u043b\u0435\u043d"
                  );
            }
         }
      }
   }

   public static boolean Iii_method_1629dac3() {
      if (!I_field_5a) {
         return false;
      } else {
         try {
            Files.createDirectories(I_field_3a58077.toPath());
            HashSet var0 = new HashSet();

            for (int var1 = 0; var1 < i_field_7865b31.size(); var1++) {
               InventoryBuilderModule.Nested1_210a0440 var2 = i_field_7865b31.get(var1);
               String var3 = I_method_9149d5c3(var2, var0);
               var0.add(var3.toLowerCase(Locale.ROOT));
               if (!var2.i_field_523beb0a.isEmpty() && !var2.i_field_523beb0a.equalsIgnoreCase(var3)) {
                  new File(I_field_3a58077, var2.i_field_523beb0a).delete();
               }

               var2.i_field_523beb0a = var3;
               JsonObject var4 = I_method_33d95000(var2);
               var4.addProperty("order", var1);
               IiIIiIII_Class73.I_method_3b2973c6(new File(I_field_3a58077, var3), var4);
            }

            File[] var7 = I_field_3a58077.listFiles((var0x, var1x) -> var1x.toLowerCase(Locale.ROOT).endsWith(".rock"));
            if (var7 != null) {
               for (File var5 : var7) {
                  if (!var0.contains(var5.getName().toLowerCase(Locale.ROOT))) {
                     var5.delete();
                  }
               }
            }

            return true;
         } catch (Exception var6) {
            RockstarClient.I_field_ab0f6068
               .warn(
                  "[InventoryBuilder] \u043f\u0440\u0435\u0441\u0435\u0442\u044b \u043d\u0435 \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u043b\u0438\u0441\u044c: {}",
                  var6.getMessage()
               );
            return false;
         }
      }
   }

   public static String I_method_7809e6de(InventoryBuilderModule.Nested1_210a0440 var0) {
      return I_method_33d95000(var0).toString();
   }

   public static boolean I_method_ea9f3ff7(String var0, String var1) {
      if (var1 != null && !var1.isBlank()) {
         try {
            Iii_method_1629dabf();
            String var2 = var0 != null && !var0.isBlank() ? var0.trim() : "\u041f\u0440\u0435\u0441\u0435\u0442";
            InventoryBuilderModule.Nested1_210a0440 var3 = I_method_e21d2406((JsonObject)IiIIiIII_Class73.I_field_fbd77e28.fromJson(var1, JsonObject.class), var2);
            if (var3 != null && var3.I_method_3878a76d() != 0) {
               var3.I_field_523beb0a = II_method_3c2e67f4(var2);
               var3.i_field_523beb0a = "";
               i_field_7865b31.add(var3);
               return Iii_method_1629dac3();
            } else {
               return false;
            }
         } catch (Exception var4) {
            RockstarClient.I_field_ab0f6068
               .warn(
                  "[InventoryBuilder] \u0447\u0443\u0436\u043e\u0439 \u043f\u0440\u0435\u0441\u0435\u0442 \u043d\u0435 \u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f: {}",
                  var4.getMessage()
               );
            return false;
         }
      } else {
         return false;
      }
   }

   private static String II_method_3c2e67f4(String var0) {
      String var1 = var0;

      for (int var2 = 2; I_method_419b7e6d(var1) && var2 < 100; var2++) {
         var1 = var0 + " " + var2;
      }

      return var1;
   }

   private static boolean I_method_419b7e6d(String var0) {
      for (InventoryBuilderModule.Nested1_210a0440 var2 : i_field_7865b31) {
         if (var2.I_field_523beb0a.equalsIgnoreCase(var0)) {
            return true;
         }
      }

      return false;
   }

   private static InventoryBuilderModule.Nested1_210a0440 I_method_e21d2406(JsonObject var0, String var1) {
      if (var0 != null && var0.has("slots")) {
         String var2 = var0.has("name") ? var0.get("name").getAsString() : "";
         InventoryBuilderModule.Nested1_210a0440 var3 = new InventoryBuilderModule.Nested1_210a0440(var2.isBlank() ? var1 : var2);

         for (JsonElement var5 : var0.getAsJsonArray("slots")) {
            JsonObject var6 = var5.getAsJsonObject();
            int var7 = var6.get("slot").getAsInt();
            if (var7 >= 0 && var7 < 41) {
               InventoryBuilderModule.Nested1_210a0420 var8 = new InventoryBuilderModule.Nested1_210a0420();
               Identifier var9 = Identifier.tryParse(var6.get("item").getAsString());
               if (var9 != null) {
                  var8.I_field_6a3d6525 = var9;
                  var8.i_field_523beb0a = var6.has("query") ? var6.get("query").getAsString() : "";
                  var8.II_field_523beb0a = var6.has("match") ? var6.get("match").getAsString() : "";
                  var8.I_field_5a = var6.has("custom") && var6.get("custom").getAsBoolean();
                  var8.i_field_49 = var6.has("amount") ? var6.get("amount").getAsInt() : 1;
                  var8.II_field_49 = var6.has("durability") ? var6.get("durability").getAsInt() : 0;
                  var8.Ii_field_49 = var6.has("minDuration") ? var6.get("minDuration").getAsInt() : 0;
                  var8.I_field_4a = var6.has("price") ? var6.get("price").getAsLong() : 0L;
                  var8.Ii_field_523beb0a = var6.has("texture") ? var6.get("texture").getAsString() : "";
                  var8.I_field_49 = var6.has("color") ? var6.get("color").getAsInt() : -1;
                  var8.iI_field_523beb0a = var6.has("potion") ? var6.get("potion").getAsString() : "";
                  var8.i_field_5a = var6.has("exact") && var6.get("exact").getAsBoolean();
                  var8.iI_field_49 = var6.has("duration") ? var6.get("duration").getAsInt() : 0;
                  var8.ii_field_49 = var6.has("budget") ? var6.get("budget").getAsInt() : 0;
                  var8.III_field_49 = var6.has("stack") ? var6.get("stack").getAsInt() : 0;
                  var8.ii_field_523beb0a = var6.has("search") ? var6.get("search").getAsString() : "";
                  if (var6.has("variants")) {
                     for (JsonElement var11 : var6.getAsJsonArray("variants")) {
                        LinkedHashMap var12 = new LinkedHashMap();

                        for (Entry var14 : var11.getAsJsonObject().entrySet()) {
                           var12.put((String)var14.getKey(), ((JsonElement)var14.getValue()).getAsInt());
                        }

                        if (!var12.isEmpty()) {
                           var8.i_field_7865b31.add(var12);
                        }
                     }
                  }

                  if (var6.has("required")) {
                     for (Entry var17 : var6.getAsJsonObject("required").entrySet()) {
                        var8.I_field_a567c40b.put((String)var17.getKey(), ((JsonElement)var17.getValue()).getAsInt());
                     }
                  }

                  if (var6.has("options")) {
                     for (JsonElement var18 : var6.getAsJsonArray("options")) {
                        JsonObject var19 = var18.getAsJsonObject();
                        var8.I_field_7865b31.add(new InventoryBuilderModule.Nested1_368049(var19.get("name").getAsString(), var19.get("max").getAsInt()));
                     }
                  }

                  i_method_fa630642(var8);
                  var8.i_field_49 = Math.max(1, Math.min(var8.i_field_49, var8.I_method_1dd938d()));
                  var3.I_field_814f57ec[var7] = var8;
               }
            }
         }

         return var3;
      } else {
         return null;
      }
   }

   private static JsonObject I_method_33d95000(InventoryBuilderModule.Nested1_210a0440 var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("name", var0.I_field_523beb0a);
      JsonArray var2 = new JsonArray();

      for (int var3 = 0; var3 < 41; var3++) {
         InventoryBuilderModule.Nested1_210a0420 var4 = var0.I_field_814f57ec[var3];
         if (var4 != null) {
            JsonObject var5 = new JsonObject();
            var5.addProperty("slot", var3);
            var5.addProperty("item", var4.I_field_6a3d6525.toString());
            var5.addProperty("query", var4.i_field_523beb0a);
            var5.addProperty("match", var4.II_field_523beb0a);
            var5.addProperty("custom", var4.I_field_5a);
            var5.addProperty("amount", var4.i_field_49);
            var5.addProperty("durability", var4.II_field_49);
            var5.addProperty("minDuration", var4.Ii_field_49);
            var5.addProperty("price", var4.I_field_4a);
            var5.addProperty("texture", var4.Ii_field_523beb0a);
            var5.addProperty("color", var4.I_field_49);
            var5.addProperty("potion", var4.iI_field_523beb0a);
            var5.addProperty("exact", var4.i_field_5a);
            var5.addProperty("duration", var4.iI_field_49);
            var5.addProperty("budget", var4.ii_field_49);
            var5.addProperty("stack", var4.III_field_49);
            var5.addProperty("search", var4.ii_field_523beb0a);
            JsonObject var6 = new JsonObject();
            var4.I_field_a567c40b.forEach(var6::addProperty);
            var5.add("required", var6);
            JsonArray var7 = new JsonArray();

            for (Map<String, Integer> var9 : var4.i_field_7865b31) {
               JsonObject var10 = new JsonObject();
               var9.forEach(var10::addProperty);
               var7.add(var10);
            }

            var5.add("variants", var7);
            JsonArray var12 = new JsonArray();

            for (InventoryBuilderModule.Nested1_368049 var14 : var4.I_field_7865b31) {
               JsonObject var11 = new JsonObject();
               var11.addProperty("name", var14.I_method_7fefcfaf());
               var11.addProperty("max", var14.I_method_9d154904());
               var12.add(var11);
            }

            var5.add("options", var12);
            var2.add(var5);
         }
      }

      var1.add("slots", var2);
      return var1;
   }

   private static String I_method_9149d5c3(InventoryBuilderModule.Nested1_210a0440 var0, Set<String> var1) {
      String var2 = Ii_method_5c4d5014(var0.I_field_523beb0a);
      String var3 = var2 + ".rock";

      for (int var4 = 2; var1.contains(var3.toLowerCase(Locale.ROOT)); var4++) {
         var3 = var2 + "-" + var4 + ".rock";
      }

      return var3;
   }

   private static String Ii_method_5c4d5014(String var0) {
      StringBuilder var1 = new StringBuilder();

      for (char var5 : (var0 == null ? "" : var0).trim().toCharArray()) {
         boolean var6 = var5 == ' ';
         if (!var6 || !var1.isEmpty() && var1.charAt(var1.length() - 1) != ' ') {
            boolean var7 = var6 || var5 == '-' || var5 == '_' || Character.isLetterOrDigit(var5);
            var1.append(var7 ? var5 : '_');
            if (var1.length() >= 48) {
               break;
            }
         }
      }

      String var8 = var1.toString().trim();
      if (var8.isEmpty()) {
         var8 = "preset";
      }

      return I_field_5fd3861f.matcher(var8).matches() ? var8 + "_" : var8;
   }

   @Generated
   public ButtonSetting I_method_8e5c5755() {
      return this.I_field_bbd4b28c;
   }

   @Generated
   public ButtonSetting i_method_a3f1cb35() {
      return this.i_field_bbd4b28c;
   }

   @Generated
   public SliderSetting I_method_459f3355() {
      return this.I_field_73178e8c;
   }

   @Generated
   public SliderSetting i_method_5b34a735() {
      return this.i_field_73178e8c;
   }

   @Generated
   public SliderSetting II_method_6ff0ec18() {
      return this.II_field_73178e8c;
   }

   @Generated
   public BooleanSetting I_method_8ca86f15() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public long I_method_cd238e53() {
      return this.i_field_4a;
   }

   @Generated
   public iiIiIIiii_Class424 I_method_6ba3c355() {
      return this.I_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 i_method_81393735() {
      return this.i_field_991c1e8c;
   }

   @Generated
   public Deque<int[]> I_method_11a56450() {
      return this.I_field_db650847;
   }

   @Generated
   public boolean iII_method_4af372a3() {
      return this.i_field_5a;
   }

   @Generated
   public int II_method_d75d34d5() {
      return this.Ii_field_49;
   }

   @Generated
   public int Ii_method_d76bc0b5() {
      return this.iI_field_49;
   }

   @Generated
   public boolean iIi_method_4b01fe83() {
      return this.II_field_5a;
   }

   @Generated
   public int iI_method_d92024f5() {
      return this.ii_field_49;
   }

   @Generated
   public int ii_method_d92eb0d5() {
      return this.III_field_49;
   }

   @Generated
   public InventoryBuilderModule.Nested1_368029 I_method_d0ddb2fd() {
      return this.I_field_39dc7866;
   }

   @Generated
   public InventoryBuilderModule.Nested1_210a0440 I_method_931ff0d0() {
      return this.I_field_43ee5a47;
   }

   @Generated
   public int III_method_14585eb2() {
      return this.IIi_field_49;
   }

   @Generated
   public int IIi_method_1466ea92() {
      return this.IiI_field_49;
   }

   @Generated
   public int IiI_method_161b4ed2() {
      return this.Iii_field_49;
   }

   @Generated
   public int Iii_method_1629dab2() {
      return this.iII_field_49;
   }

   @Generated
   public int iII_method_4af37292() {
      return this.iIi_field_49;
   }

   @Generated
   public long i_method_cd321a33() {
      return this.II_field_4a;
   }

   @Generated
   public int iIi_method_4b01fe72() {
      return this.IIII_field_49;
   }

   @Generated
   public int iiI_method_4cb662b2() {
      return this.IIIi_field_49;
   }

   @Generated
   public int iii_method_4cc4ee92() {
      return this.IIiI_field_49;
   }

   @Generated
   public int IIII_method_76c27075() {
      return this.IIii_field_49;
   }

   @Generated
   public int IIIi_method_76d0fc55() {
      return this.IiII_field_49;
   }

   @Generated
   public String II_method_a234dffe() {
      return this.i_field_523beb0a;
   }

   @Generated
   public int IIiI_method_78856095() {
      return this.IiIi_field_49;
   }

   @Generated
   public Set<Integer> I_method_16f4580e() {
      return this.I_field_a56a8dc5;
   }

   @Generated
   public int IIii_method_7893ec75() {
      return this.IiiI_field_49;
   }

   @Generated
   public Set<String> i_method_a9309bee() {
      return this.i_field_a56a8dc5;
   }

   @Generated
   public String Ii_method_3553901e() {
      return this.II_field_523beb0a;
   }

   @Generated
   public boolean iiI_method_4cb662c3() {
      return this.Ii_field_5a;
   }

   @Generated
   public String iI_method_72ec33de() {
      return this.Ii_field_523beb0a;
   }

   @Generated
   public int IiII_method_ad5d8455() {
      return this.Iiii_field_49;
   }

   @Generated
   public IiIIIiII_Class69<KeyPressEvent> I_method_a8f8d58() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ReceivePacketEvent> i_method_348c1d78() {
      return this.i_field_3d936f41;
   }

   @Generated
   public int IiIi_method_ad6c1035() {
      return this.iIII_field_49;
   }

   @Generated
   public static List<InventoryBuilderModule.Nested1_210a0440> I_method_c735da08() {
      return i_field_7865b31;
   }

   @Generated
   public static List<InventoryBuilderModule.Nested1_210a0420> i_method_7c821228() {
      return II_field_7865b31;
   }

   public static class Nested1_210a0420 {
      public Identifier I_field_6a3d6525 = Identifier.ofVanilla("stone");
      public String I_field_523beb0a = "";
      public String i_field_523beb0a = "";
      public String II_field_523beb0a = "";
      public String Ii_field_523beb0a = "";
      public String iI_field_523beb0a = "";
      public int I_field_49 = -1;
      public boolean I_field_5a;
      public boolean i_field_5a;
      public int i_field_49 = 1;
      public int II_field_49 = 75;
      public int Ii_field_49;
      public long I_field_4a;
      public final Map<String, Integer> I_field_a567c40b = new LinkedHashMap<>();
      public final List<InventoryBuilderModule.Nested1_368049> I_field_7865b31 = new ArrayList<>();
      public int iI_field_49;
      public int ii_field_49;
      public final List<Map<String, Integer>> i_field_7865b31 = new ArrayList<>();
      public int III_field_49;
      public String ii_field_523beb0a = "";

      public Nested1_210a0420(Identifier var1, String var2) {
         this.I_field_6a3d6525 = var1;
         this.i_field_523beb0a = var2;
      }

      public Nested1_210a0420() {
      }

      public String I_method_a196c846() {
         return this.II_field_523beb0a.isBlank() ? this.i_field_523beb0a : this.i_field_523beb0a + " " + this.II_field_523beb0a;
      }

      public String i_method_34b57866() {
         return InventoryBuilderModule.i_method_9e3edd77(this.I_method_a196c846());
      }

      public String II_method_969c2c79() {
         if (!this.II_field_523beb0a.isBlank()) {
            return this.II_field_523beb0a;
         } else {
            return this.I_field_5a ? this.i_field_523beb0a : "";
         }
      }

      public ItemStack I_method_e20385e() {
         Item var1 = (Item)Registries.ITEM.get(this.I_field_6a3d6525);
         ItemStack var2 = var1.getDefaultStack();
         var2.setCount(Math.max(1, Math.min(this.i_field_49, var1.getMaxCount())));
         if (!this.Ii_field_523beb0a.isBlank()) {
            PropertyMap var3 = new PropertyMap();
            var3.put("textures", new Property("textures", this.Ii_field_523beb0a));
            var2.set(
               DataComponentTypes.PROFILE,
               new ProfileComponent(Optional.empty(), Optional.of(UUID.nameUUIDFromBytes(this.Ii_field_523beb0a.getBytes(StandardCharsets.UTF_8))), var3)
            );
         }

         if (!this.iI_field_523beb0a.isBlank()) {
            Identifier var5 = Identifier.tryParse(this.iI_field_523beb0a);
            Potion var4 = var5 == null ? null : (Potion)Registries.POTION.get(var5);
            if (var4 != null) {
               var2.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Registries.POTION.getEntry(var4)));
            }
         } else if (this.I_field_49 >= 0) {
            var2.set(
               DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.empty(), Optional.of(this.I_field_49), List.of(), Optional.empty())
            );
         }

         return var2;
      }

      public boolean I_method_1dd939e() {
         return ((Item)Registries.ITEM.get(this.I_field_6a3d6525)).getDefaultStack().isDamageable();
      }

      public int I_method_1dd938d() {
         if (this.III_field_49 > 0) {
            return this.III_field_49;
         } else {
            ItemStack var1 = ((Item)Registries.ITEM.get(this.I_field_6a3d6525)).getDefaultStack();
            return var1.isOf(Items.POTION) ? 64 : var1.getMaxCount();
         }
      }

      public InventoryBuilderModule.Nested1_210a0420 I_method_e1ba1bab() {
         InventoryBuilderModule.Nested1_210a0420 var1 = new InventoryBuilderModule.Nested1_210a0420(this.I_field_6a3d6525, this.i_field_523beb0a);
         var1.I_field_523beb0a = this.I_field_523beb0a;
         var1.II_field_523beb0a = this.II_field_523beb0a;
         var1.Ii_field_523beb0a = this.Ii_field_523beb0a;
         var1.iI_field_523beb0a = this.iI_field_523beb0a;
         var1.I_field_49 = this.I_field_49;
         var1.I_field_5a = this.I_field_5a;
         var1.i_field_5a = this.i_field_5a;
         var1.i_field_49 = this.i_field_49;
         var1.II_field_49 = this.II_field_49;
         var1.Ii_field_49 = this.Ii_field_49;
         var1.I_field_4a = this.I_field_4a;
         var1.iI_field_49 = this.iI_field_49;
         var1.ii_field_49 = this.ii_field_49;
         var1.III_field_49 = this.III_field_49;
         var1.ii_field_523beb0a = this.ii_field_523beb0a;
         var1.I_field_a567c40b.putAll(this.I_field_a567c40b);
         var1.I_field_7865b31.addAll(this.I_field_7865b31);

         for (Map var3 : this.i_field_7865b31) {
            var1.i_field_7865b31.add(new LinkedHashMap<>(var3));
         }

         return var1;
      }
   }

   public static class Nested1_210a0440 {
      public String I_field_523beb0a;
      public final InventoryBuilderModule.Nested1_210a0420[] I_field_814f57ec = new InventoryBuilderModule.Nested1_210a0420[41];
      public String i_field_523beb0a = "";

      public Nested1_210a0440(String var1) {
         this.I_field_523beb0a = var1;
      }

      public int I_method_3878a76d() {
         int var1 = 0;

         for (InventoryBuilderModule.Nested1_210a0420 var5 : this.I_field_814f57ec) {
            if (var5 != null) {
               var1++;
            }
         }

         return var1;
      }

      public InventoryBuilderModule.Nested1_210a0440 I_method_f2a22fb5(String var1) {
         InventoryBuilderModule.Nested1_210a0440 var2 = new InventoryBuilderModule.Nested1_210a0440(var1);

         for (int var3 = 0; var3 < 41; var3++) {
            if (this.I_field_814f57ec[var3] != null) {
               var2.I_field_814f57ec[var3] = this.I_field_814f57ec[var3].I_method_e1ba1bab();
            }
         }

         return var2;
      }

      public void I_method_3878a77a() {
         for (int var1 = 0; var1 < 41; var1++) {
            this.I_field_814f57ec[var1] = null;
         }
      }
   }

   static enum Nested1_368029 {
      I_field_39dc7866,
      i_field_39dc7866,
      II_field_39dc7866,
      Ii_field_39dc7866,
      iI_field_39dc7866,
      ii_field_39dc7866,
      III_field_39dc7866;
   }

   public static final class Nested1_368049 {
      private final String I_field_523beb0a;
      private final int I_field_49;

      public Nested1_368049(String var1, int var2) {
         this.I_field_523beb0a = var1;
         this.I_field_49 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_368049[name=" + this.I_field_523beb0a + ", max=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         InventoryBuilderModule.Nested1_368049 other = (InventoryBuilderModule.Nested1_368049) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public String I_method_7fefcfaf() {
         return this.I_field_523beb0a;
      }

      public int I_method_9d154904() {
         return this.I_field_49;
      }
   }
}
