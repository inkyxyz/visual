package rockstar.client;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.window.KeyPressEvent;

public class IIiIiIiI_Class43 implements iIIiIIiIi_Class294 {
   private static final long I_field_4a = 150L;
   private static final long i_field_4a = 900L;
   private static final long II_field_4a = 1200L;
   private static final long Ii_field_4a = 8000L;
   private static final int I_field_49 = 4;
   private static final int i_field_49 = 3;
   private static final int II_field_49 = 2;
   private static final int Ii_field_49 = 64;
   private static final int iI_field_49 = 0;
   private static final int ii_field_49 = 1;
   private static final int III_field_49 = 13;
   private static final int[][] I_field_160e9 = new int[][]{{17, 50}, {16, 25}, {15, 10}, {14, 5}};
   private static final int IIi_field_49 = 66;
   private static final Pattern I_field_5fd3861f = Pattern.compile("\u0412\u0430\u0448 \u0431\u0430\u043b\u0430\u043d\u0441\\D*(\\d[\\d\\s.,]*)", 66);
   private static final Pattern i_field_5fd3861f = Pattern.compile(
      "\u041e\u0436\u0438\u0434\u0430\u0435\u0442\u0441\u044f \u043a\u043e\u0438\u043d\u043e\u0432\\D*(\\d[\\d\\s.,]*)", 66
   );
   private static final Pattern II_field_5fd3861f = Pattern.compile("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c\\D*(\\d[\\d\\s.,]*)", 66);
   private boolean I_field_5a;
   private int IiI_field_49;
   private int Iii_field_49;
   private int iII_field_49;
   private int iIi_field_49;
   private int iiI_field_49;
   private int iii_field_49;
   private int IIII_field_49;
   private int IIIi_field_49;
   private boolean i_field_5a;
   private boolean II_field_5a;
   private int IIiI_field_49;
   private int IIii_field_49;
   private int IiII_field_49;
   private int IiIi_field_49;
   private int IiiI_field_49;
   private int Iiii_field_49;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_5a) {
         if (var1.getAction() == 1 && var1.getKey() == 256) {
            this.I_method_7731a4d3("commands.exchange.cancelled", false, this.Iii_field_49);
         }
      }
   };
   private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41 = var1 -> {
      if (this.I_field_5a) {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && I_field_3a9bda27.interactionManager != null) {
            GenericContainerScreenHandler var2 = I_field_3a9bda27.currentScreen != null
                  && I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var3
               ? var3
               : null;
            if (var2 != null) {
               String var5 = this.i_method_8841eb8a(I_field_3a9bda27.currentScreen.getTitle().getString());
               if (var5.contains("\u0431\u0438\u0440\u0436\u0430")) {
                  this.IiiI_field_49 = 0;
                  this.I_method_a2bb0df6(var2);
               } else if (var5.contains("\u043f\u043e\u043a\u0443\u043f\u043a\u0430")) {
                  this.IiiI_field_49 = 0;
                  this.i_method_c98569d6(var2);
               } else if (this.i_field_991c1e8c.I_method_58432069(8000L)) {
                  this.I_method_7731a4d3("commands.exchange.no_menu", true);
               }
            } else if (!this.II_field_5a && this.IiI_field_49 > 0 && this.Iii_field_49 >= this.IiI_field_49) {
               this.I_method_f790e52c();
            } else if (this.i_field_991c1e8c.I_method_58432069(1200L)) {
               if (this.IiiI_field_49 >= 3) {
                  if (this.Iii_field_49 > 0) {
                     this.I_method_f790e52c();
                  } else {
                     this.I_method_7731a4d3("commands.exchange.no_menu", true);
                  }
               } else {
                  this.IiiI_field_49++;
                  this.i_field_991c1e8c.I_method_23e11e3f();
                  this.I_field_991c1e8c.I_method_23e11e3f();
                  I_field_3a9bda27.player.networkHandler.sendChatCommand("exchange");
               }
            }
         } else {
            this.I_field_5a = false;
         }
      }
   };

   public IIiIiIiI_Class43() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public IIIiiIIi_Class26 I_method_3de0674b() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "exchange", var1 -> var1.I_method_b3f941e4("exc").i_method_cfe1a061("commands.exchange.description").i_method_3d6e11d9("args", var0 -> {
               var0.I_method_e930dfcb().i_method_132d6feb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a);
               var0.I_method_f005ecf3("stop", "dump");
            }).I_method_16f05c8a(this::I_method_302fa7ad)
         )
         .I_method_9111538b();
   }

   private void I_method_302fa7ad(IIIiiIii_Class28 var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         List var2 = !var1.I_method_557e5bfb().isEmpty() && var1.I_method_557e5bfb().getFirst() != null ? (List)var1.I_method_557e5bfb().getFirst() : List.of();
         String var3 = var2.isEmpty() ? "" : ((String)var2.getFirst()).toLowerCase(Locale.ROOT);
         if (!var3.equals("stop") && !var3.equals("cancel")) {
            if (var3.equals("dump")) {
               this.i_method_f79f710c();
            } else {
               int var4 = 0;
               if (!var3.isEmpty()) {
                  try {
                     var4 = Integer.parseInt(var3);
                  } catch (NumberFormatException var6) {
                     var4 = -1;
                  }

                  if (var4 <= 0) {
                     iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.exchange.usage")));
                     return;
                  }
               }

               if (!iIIIiiiII_Class285.Ii_method_b349c526()) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.exchange.only_hw")));
               } else {
                  this.I_method_fa8c3357(var4);
               }
            }
         } else {
            if (this.I_field_5a) {
               this.I_method_7731a4d3("commands.exchange.cancelled", false, this.Iii_field_49);
            } else {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.exchange.not_active")));
            }
         }
      }
   }

   private void I_method_fa8c3357(int var1) {
      this.I_field_5a = true;
      this.IiI_field_49 = var1;
      this.Iii_field_49 = 0;
      this.iII_field_49 = 0;
      this.iIi_field_49 = 0;
      this.iiI_field_49 = -1;
      this.iii_field_49 = 0;
      this.IIII_field_49 = 0;
      this.IIIi_field_49 = 0;
      this.i_field_5a = false;
      this.II_field_5a = false;
      this.IIiI_field_49 = 0;
      this.IIii_field_49 = 0;
      this.IiII_field_49 = 0;
      this.IiIi_field_49 = 0;
      this.IiiI_field_49 = 0;
      this.Iiii_field_49 = 0;
      this.I_field_991c1e8c.I_method_23e11e3f();
      this.i_field_991c1e8c.I_method_23e11e3f();
      I_field_3a9bda27.player.networkHandler.sendChatCommand("exchange");
      iIIIIIIii_Class260.I_method_468cf607(
         Text.of(
            this.IiI_field_49 > 0
               ? IiIiIIII_Class81.I_method_1410d1e5("commands.exchange.started_limit", this.IiI_field_49)
               : IiIiIIII_Class81.I_method_f25a980a("commands.exchange.started")
         )
      );
   }

   private void I_method_a2bb0df6(GenericContainerScreenHandler var1) {
      int var2 = this.I_method_a2bb0de9(var1);
      int var3 = -1;
      Integer var4 = null;
      this.iii_field_49 = 0;

      for (int var5 = 0; var5 < var2; var5++) {
         ItemStack var6 = var1.getSlot(var5).getStack();
         if (!var6.isEmpty()) {
            String var7 = this.I_method_6823036a(var6.getName().getString());
            if (var4 == null) {
               Integer var8 = this.I_method_d67809e(I_field_5fd3861f, var7);
               if (var8 != null) {
                  var4 = var8;
                  var3 = var5;
                  continue;
               }
            }

            Integer var12 = this.I_method_d67809e(i_field_5fd3861f, var7);
            if (var12 != null) {
               this.iii_field_49 = var12;
            }
         }
      }

      if (var4 == null) {
         if (this.i_field_991c1e8c.I_method_58432069(8000L)) {
            this.I_method_7731a4d3("commands.exchange.no_balance", true);
         }
      } else {
         int var9 = var4;
         if (this.II_field_5a) {
            if (var9 != this.iiI_field_49) {
               int var10 = Math.max(0, this.iiI_field_49 - var9);
               this.Iii_field_49 += var10;
               if (var10 > 0) {
                  this.iII_field_49++;
                  this.Iiii_field_49 = 0;
               } else {
                  this.Iiii_field_49++;
               }

               this.II_field_5a = false;
               this.IiIi_field_49 = 0;
               this.i_field_991c1e8c.I_method_23e11e3f();
            } else {
               if (!this.I_field_991c1e8c.I_method_58432069(900L)) {
                  return;
               }

               if (this.IiIi_field_49 < 4 && var3 >= 0) {
                  this.IiIi_field_49++;
                  this.I_method_e03dc8d6(var1, var3, 0);
                  return;
               }

               this.II_field_5a = false;
               this.IiIi_field_49 = 0;
               this.Iiii_field_49++;
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         }

         this.iIi_field_49 = var9;
         if (this.Iiii_field_49 >= 2) {
            this.I_method_7731a4d3("commands.exchange.stalled", true, this.Iii_field_49);
         } else {
            int var11 = this.IiI_field_49 > 0 ? Math.min(this.IiI_field_49 - this.Iii_field_49, this.iIi_field_49) : this.iIi_field_49;
            if (this.iii_field_49 > 0 && (this.IIII_field_49 <= 0 || this.iii_field_49 >= this.IIII_field_49)) {
               var11 = Math.min(var11, this.iii_field_49);
            }

            if (this.IIIi_field_49 > 1) {
               var11 -= var11 % this.IIIi_field_49;
            }

            if (var11 <= 0 || this.IIII_field_49 > 0 && var11 < this.IIII_field_49) {
               this.I_method_f790e52c();
            } else if (this.I_field_991c1e8c.I_method_58432069(150L)) {
               if (!this.i_field_5a || this.i_field_991c1e8c.I_method_58432069(8000L)) {
                  this.i_field_5a = false;
                  if (var1.getSlot(0).hasStack()) {
                     this.IiIi_field_49 = 0;
                     this.iiI_field_49 = this.iIi_field_49;
                     this.IIii_field_49 = var11;
                     this.IIiI_field_49 = 0;
                     this.IiII_field_49 = 0;
                     this.i_field_5a = true;
                     this.I_method_e03dc8d6(var1, 0, 1);
                  } else if (this.IiIi_field_49 < 4 && var3 >= 0) {
                     this.IiIi_field_49++;
                     this.I_method_e03dc8d6(var1, var3, 0);
                  } else {
                     this.I_method_7731a4d3("commands.exchange.empty", false, this.Iii_field_49);
                  }
               }
            }
         }
      }
   }

   private void i_method_c98569d6(GenericContainerScreenHandler var1) {
      this.i_field_5a = false;
      if (this.II_field_5a) {
         if (this.i_field_991c1e8c.I_method_58432069(8000L)) {
            this.i_field_991c1e8c.I_method_23e11e3f();
            I_field_3a9bda27.player.closeHandledScreen();
         }
      } else if (this.I_field_991c1e8c.I_method_58432069(150L)) {
         int var2 = this.I_method_a2bb0de9(var1);
         int var3 = this.IIii_field_49 - this.IIiI_field_49;
         int var4 = -1;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         boolean var8 = false;

         for (int var9 = 0; var9 < var2; var9++) {
            ItemStack var10 = var1.getSlot(var9).getStack();
            if (!var10.isEmpty()) {
               Integer var11 = this.I_method_d67809e(II_field_5fd3861f, this.I_method_6823036a(var10.getName().getString()));
               if (var11 != null && var11 > 0) {
                  var8 = true;
                  var7 = this.I_method_56faaa7f(var7, var11);
                  if (var6 == 0 || var11 < var6) {
                     var6 = var11;
                  }

                  if (var11 <= var3 && var11 > var5) {
                     var5 = var11;
                     var4 = var9;
                  }
               }
            }
         }

         if (!var8) {
            for (int[] var12 : I_field_160e9) {
               int var13 = var12[0];
               int var14 = var12[1];
               if (var13 < var2 && var1.getSlot(var13).hasStack()) {
                  var7 = this.I_method_56faaa7f(var7, var14);
                  if (var6 == 0 || var14 < var6) {
                     var6 = var14;
                  }

                  if (var14 <= var3 && var14 > var5) {
                     var5 = var14;
                     var4 = var13;
                  }
               }
            }
         }

         if (var6 > 0) {
            this.IIII_field_49 = var6;
            this.IIIi_field_49 = var7;
         }

         if (var4 >= 0 && this.IiII_field_49 < 64) {
            this.IIiI_field_49 += var5;
            this.IiII_field_49++;
            this.I_method_e03dc8d6(var1, var4, 0);
         } else if (this.IIiI_field_49 <= 0) {
            this.I_method_7731a4d3("commands.exchange.empty", false, this.Iii_field_49);
            I_field_3a9bda27.player.closeHandledScreen();
         } else {
            int var16 = this.I_method_b4a723c0(var1, var2);
            if (var16 < 0) {
               this.I_method_7731a4d3("commands.exchange.no_confirm", true, this.Iii_field_49);
            } else {
               this.II_field_5a = true;
               this.I_method_e03dc8d6(var1, var16, 0);
            }
         }
      }
   }

   private int I_method_b4a723c0(GenericContainerScreenHandler var1, int var2) {
      if (13 < var2 && var1.getSlot(13).hasStack()) {
         return 13;
      } else {
         for (int var3 = 0; var3 < var2; var3++) {
            ItemStack var4 = var1.getSlot(var3).getStack();
            if (!var4.isEmpty()) {
               String var5 = this.i_method_8841eb8a(var4.getName().getString());
               if (var5.contains("\u043a\u0443\u043f\u0438\u0442\u044c")
                  || var5.contains("\u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c")
                  || var5.contains("\u043e\u0431\u043c\u0435\u043d\u044f\u0442\u044c")
                  || var5.contains("\u043e\u0444\u043e\u0440\u043c\u0438\u0442\u044c")) {
                  return var3;
               }
            }
         }

         return -1;
      }
   }

   private void I_method_e03dc8d6(GenericContainerScreenHandler var1, int var2, int var3) {
      if (I_field_3a9bda27.interactionManager != null && var2 >= 0 && var2 < var1.slots.size()) {
         I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, var3, SlotActionType.PICKUP, I_field_3a9bda27.player);
         this.I_field_991c1e8c.I_method_23e11e3f();
         this.i_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void I_method_f790e52c() {
      if (this.IiI_field_49 > 0) {
         this.I_method_7731a4d3("commands.exchange.finished_limit", false, this.Iii_field_49, this.IiI_field_49, this.iII_field_49);
      } else {
         this.I_method_7731a4d3("commands.exchange.finished", false, this.Iii_field_49, this.iII_field_49);
      }
   }

   private void I_method_7731a4d3(String var1, boolean var2, Object... var3) {
      this.I_field_5a = false;
      Text var4 = Text.of(var3.length == 0 ? IiIiIIII_Class81.I_method_f25a980a(var1) : IiIiIIII_Class81.I_method_1410d1e5(var1, var3));
      if (var2) {
         iIIIIIIii_Class260.II_method_e8fd4864(var4);
      } else {
         iIIIIIIii_Class260.I_method_468cf607(var4);
      }
   }

   private int I_method_a2bb0de9(GenericContainerScreenHandler var1) {
      return Math.max(0, var1.slots.size() - 36);
   }

   private Integer I_method_d67809e(Pattern var1, String var2) {
      if (var2 == null) {
         return null;
      } else {
         Matcher var3 = var1.matcher(var2);
         if (!var3.find()) {
            return null;
         } else {
            String var4 = var3.group(1).replaceAll("\\D", "");
            return !var4.isEmpty() && var4.length() <= 9 ? Integer.parseInt(var4) : null;
         }
      }
   }

   private int I_method_56faaa7f(int var1, int var2) {
      while (var2 != 0) {
         int var3 = var1 % var2;
         var1 = var2;
         var2 = var3;
      }

      return var1;
   }

   private String I_method_6823036a(String var1) {
      return var1 == null ? "" : var1.replaceAll("\u00a7.", "");
   }

   private String i_method_8841eb8a(String var1) {
      return this.I_method_6823036a(var1).replace('\u0451', '\u0435').replace('\u0401', '\u0415').toLowerCase(Locale.ROOT);
   }

   private void i_method_f79f710c() {
      if (I_field_3a9bda27.currentScreen != null && I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1) {
         RockstarClient.I_field_ab0f6068
            .info("[Exchange] '{}', \u0441\u043b\u043e\u0442\u043e\u0432 {}", I_field_3a9bda27.currentScreen.getTitle().getString(), var1.slots.size());
         int var9 = this.I_method_a2bb0de9(var1);

         for (int var3 = 0; var3 < var9; var3++) {
            ItemStack var4 = var1.getSlot(var3).getStack();
            if (!var4.isEmpty()) {
               StringBuilder var5 = new StringBuilder();

               try {
                  for (Text var7 : var4.getTooltip(TooltipContext.create(I_field_3a9bda27.world), I_field_3a9bda27.player, TooltipType.BASIC)) {
                     var5.append(" | ").append(var7.getString());
                  }
               } catch (Exception var8) {
               }

               RockstarClient.I_field_ab0f6068.info("[Exchange] {} x{} {}{}", new Object[]{var3, var4.getCount(), var4.getName().getString(), var5});
            }
         }

         iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.exchange.dumped")));
      } else {
         iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands.exchange.no_screen")));
      }
   }
}
