package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.HandledScreenAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.LingeringPotionItem;
import net.minecraft.item.PotionItem;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.render.ScreenRenderEvent;
import pyrock.events.window.ContainerClickEvent;
import pyrock.events.window.ContainerReleaseEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Auction",
   category = ModuleCategory.OTHER
)
public class AuctionModule extends Module {
   private final List<AuctionModule.Nested1_e8ac0040> I_field_7865b31 = new ArrayList<>();
   private double I_field_44 = 0.0;
   private double i_field_44 = Double.MAX_VALUE;
   private static final long I_field_4a = 100L;
   private static final long i_field_4a = 5000L;
   private static final double II_field_44 = 1.6;
   private static final Pattern I_field_5fd3861f = Pattern.compile("\\b(\\d+)\\s*/\\s*(\\d+)\\b");
   private static final String I_field_523beb0a = "/ah search auto confirm";
   private static final long II_field_4a = 3000L;
   private String i_field_523beb0a = "";
   private int I_field_49 = -1;
   private double Ii_field_44 = -1.0;
   private long Ii_field_4a = -1L;
   private long iI_field_4a = -1L;
   private ColorSetting I_field_bbd4b66c;
   private ColorSetting i_field_bbd4b66c;
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private KeybindSetting I_field_ba20522c;
   private BooleanSetting II_field_ba20ca4c;
   private BooleanSetting Ii_field_ba20ca4c;
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private TextSetting I_field_731802cc;
   private KeybindSetting i_field_ba20522c;
   private ModeSetting i_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private SliderSetting I_field_73178e8c;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private MultiSelectSetting i_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 IiI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Iii_field_51de8227;
   private MultiSelectSetting II_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 iII_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iIi_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iiI_field_51de8227;
   private boolean I_field_5a = false;
   private boolean i_field_5a = false;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 II_field_991c1e8c = new iiIiIIiii_Class424();
   private final List<AuctionModule.Nested1_2cd40809> i_field_7865b31 = new ArrayList<>();
   private AuctionModule.Nested1_2cd40429 I_field_a0ef7466;
   private Item I_field_3c05b08c;
   private ItemStack I_field_f2735522;
   private String II_field_523beb0a;
   private int i_field_49;
   private int II_field_49;
   private int Ii_field_49;
   private static final Item[] I_field_e4463c91 = new Item[]{
      Items.TRIDENT,
      Items.DIAMOND_SWORD,
      Items.NETHERITE_AXE,
      Items.GOLDEN_APPLE,
      Items.TOTEM_OF_UNDYING,
      Items.ENDER_PEARL,
      Items.ELYTRA,
      Items.SHIELD,
      Items.BOW,
      Items.CROSSBOW,
      Items.FIREWORK_ROCKET,
      Items.ENCHANTED_GOLDEN_APPLE
   };
   private final IiIIiiIii_Class156 I_field_ab760aac;
   private boolean II_field_5a;
   private AuctionModule.Nested1_e8ac0020 I_field_708bda67;
   private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41;
   private final IiIIIiII_Class69<HudRenderEvent> II_field_3d936f41;
   private final IiIIIiII_Class69<ScreenRenderEvent> Ii_field_3d936f41;
   private final IiIIIiII_Class69<ContainerClickEvent> iI_field_3d936f41;
   private final IiIIIiII_Class69<ContainerReleaseEvent> ii_field_3d936f41;

   public AuctionModule() {
      this.I_field_a0ef7466 = AuctionModule.Nested1_2cd40429.I_field_a0ef7466;
      this.I_field_f2735522 = ItemStack.EMPTY;
      this.II_field_523beb0a = "";
      this.i_field_49 = 1;
      this.Ii_field_49 = -1;
      this.I_field_ab760aac = new IiIIiiIii_Class156(0.0F, 0.0F);
      this.I_field_708bda67 = AuctionModule.Nested1_e8ac0020.I_field_708bda67;
      this.I_field_3d936f41 = var1 -> {
         int var2 = var1.getKey();
         int var3 = var1.getAction();
         this.I_field_5a = var2 == 340 && (var3 == 2 || var3 == 1 || var3 == 0);
         if (this.i_field_ba20522c.I_method_51ee2d08(var2) && var3 == 1 && I_field_3a9bda27.currentScreen == null) {
            this.iII_method_252ef69f();
         } else {
            if (this.I_field_ba20522c.I_method_51ee2d08(var2) && var3 == 1 && I_field_3a9bda27.currentScreen == null) {
               ItemStack var4 = I_field_3a9bda27.player.getMainHandStack();
               if (var4.isEmpty()) {
                  RockstarClient.getInstance()
                     .I_method_5cb1af22()
                     .I_method_67864747(
                        new iiiIiIi_Class118(
                           "\u0412\u0430\u043c \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u0438\u043c\u0435\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u0432 \u043f\u0440\u0430\u0432\u043e\u0439 \u0440\u0443\u043a\u0435!",
                           I_field_e4463c91[iIIiiiiiI_Class319.I_field_ec5bca73.nextInt(I_field_e4463c91.length)]
                        )
                     );
                  return;
               }

               IiiiiIiii_Class248.Nested1_95187080 var5 = IiiiiIiii_Class248.I_method_7613ca72(var4);
               String var6 = var5 != null ? var5.I_method_2310f504(var4) : Iiiiiiiii_Class256.i_method_524c3f7f(var4);
               I_field_3a9bda27.player.networkHandler.sendChatCommand("ah search " + var6);
            }
         }
      };
      this.i_field_3d936f41 = var1 -> {
         if (this.II_field_ba20ca4c.i_method_9b12da03() && I_field_3a9bda27.player != null) {
            if (var1.getPacket() instanceof GameMessageS2CPacket var2) {
               if (this.I_method_9b5655b9(var2.content()).contains("/ah search auto confirm")) {
                  if (this.I_field_991c1e8c.I_method_58432069(3000L)) {
                     this.I_field_991c1e8c.I_method_23e11e3f();
                     I_field_3a9bda27.player.networkHandler.sendChatCommand("/ah search auto confirm".substring(1));
                  }
               }
            }
         }
      };
      this.II_field_3d936f41 = var1 -> {
         if (I_field_3a9bda27.currentScreen == null) {
            this.i_field_523beb0a = "";
            this.I_field_ab760aac.I_method_c3d80455(false);
            if (this.I_field_ab760aac.I_method_ea650b95().I_method_6ac4da6f() > 0.0F) {
               this.I_method_4c35b99d(var1.getContext());
            }
         }
      };
      this.Ii_field_3d936f41 = var1 -> {
         if (I_field_3a9bda27.currentScreen instanceof HandledScreen var2) {
            if (this.I_method_dc4f026d(var2.getTitle().getString())) {
               String var14 = this.i_field_523beb0a.toLowerCase(Locale.ROOT);
               boolean var4 = this.I_method_68cdf01a(var14, "\u0438\u043d\u0432\u0438\u0437", "\u043d\u0435\u0432\u0438\u0434", "invis");
               boolean var5 = !var4 && this.iIi_method_253d8283();
               this.I_field_ab760aac.I_method_c3d80455(var5);
               HandledScreenAccessor var6 = (HandledScreenAccessor)(Object)var2;

               try {
                  for (AuctionModule.Nested1_e8ac0040 var8 : this.I_field_7865b31) {
                     if (this.I_field_ba20ca4c.i_method_9b12da03() || !(var8.I_field_44 > this.I_field_44)) {
                        Slot var9 = var2.getScreenHandler().getSlot(var8.I_field_49);
                        if (var9 != null) {
                           int var10 = var6.getX() + var9.x;
                           int var11 = var6.getY() + var9.y;
                           ColorRGBA var12 = this.I_method_9777442e(var8.I_field_44);
                           var1.getContext()
                              .drawRoundedRect(
                                 (float)var10,
                                 (float)var11,
                                 16.0F,
                                 16.0F,
                                 IIiii_Class8.I_method_893b2757(1.0F),
                                 new IiiII_Class13(var12.withAlpha(0.0F), var12.withAlpha(0.8F * var12.getAlpha()))
                              );
                        }
                     }
                  }

                  if (this.i_method_ad06564d(this.i_field_523beb0a) && this.I_field_49 != -1 && this.Ii_field_4a != -1L && this.Ii_field_4a >= this.Ii_field_44
                     )
                   {
                     Slot var15 = var2.getScreenHandler().getSlot(this.I_field_49);
                     if (var15 != null) {
                        int var16 = var6.getX() + var15.x;
                        int var17 = var6.getY() + var15.y;
                        ColorRGBA var18 = new ColorRGBA(60.0F, 255.0F, 120.0F, 220.0F);
                        var1.getContext()
                           .drawRoundedRect(
                              (float)var16,
                              (float)var17,
                              16.0F,
                              16.0F,
                              IIiii_Class8.I_method_893b2757(1.0F),
                              new IiiII_Class13(var18.withAlpha(0.0F), var18.withAlpha(0.85F * var18.getAlpha()))
                           );
                     }
                  }
               } catch (Exception var13) {
                  this.IIii_method_e5c8e882();
               }

               if (var5 || this.I_field_ab760aac.I_method_ea650b95().I_method_6ac4da6f() > 0.0F) {
                  this.I_method_4c35b99d(var1.getContext());
               }
            }
         }
      };
      this.iI_field_3d936f41 = var1 -> {
         this.I_field_ab760aac.I_method_400ceaa7(var1.getX(), var1.getY(), IiIII_Class9.I_method_40dce65a(var1.getButton()));
         if (this.i_field_ba20ca4c.i_method_9b12da03()
            && this.I_field_5a
            && I_field_3a9bda27.currentScreen instanceof HandledScreen var2
            && this.I_method_dc4f026d(this.i_field_523beb0a)) {
            HandledScreenAccessor var8 = (HandledScreenAccessor)(Object)var2;
            Slot var4 = var8.getFocusedSlot();
            if (var4 != null && var4.hasStack()) {
               AuctionModule.Nested1_e8ac0040 var5 = this.I_field_7865b31.stream().filter(var1x -> var1x.I_field_49 == var4.id).findFirst().orElse(null);
               if (var5 == null) {
                  return;
               }

               double var6 = this.i_field_44 * 2.0;
               if (var5.I_field_44 > var6) {
                  RockstarClient.getInstance()
                     .I_method_5cb1af22()
                     .I_method_67864747(
                        new iiiIiIi_Class118(
                           "\u0426\u0435\u043d\u0430 \u0431\u043e\u043b\u044c\u0448\u0435 \u043c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u0439 \u043d\u0430 100%+",
                           I_field_e4463c91[iIIiiiiiI_Class319.I_field_ec5bca73.nextInt(I_field_e4463c91.length)]
                        )
                     );
                  return;
               }

               this.i_field_5a = true;
            }
         }
      };
      this.ii_field_3d936f41 = var1 -> this.I_field_ab760aac.i_method_6a097ac7(var1.getX(), var1.getY(), IiIII_Class9.I_method_40dce65a(var1.getButton()));
      this.IiI_method_f056d2df();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_f056d2df() {
      this.I_field_bbd4b66c = new ColorSetting(this, "modules.settings.auction.low_price_color")
         .I_method_a62f5dd6(new ColorRGBA(60.0F, 255.0F, 60.0F, 250.0F));
      this.i_field_bbd4b66c = new ColorSetting(this, "modules.settings.auction.high_price_color")
         .I_method_a62f5dd6(new ColorRGBA(255.0F, 255.0F, 60.0F, 250.0F));
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auction.show_yellow");
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auction.fast_buy");
      this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.auction.search");
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auction.auto_confirm");
      this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auction.auto_sell");
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auction.auto_sell.mode", () -> !this.Ii_field_ba20ca4c.i_method_9b12da03());
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auction.auto_sell.mode.funtime").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auction.auto_sell.mode.holyworld");
      this.I_field_731802cc = new TextSetting(this, "modules.settings.auction.auto_sell.pages", () -> !this.Ii_field_ba20ca4c.i_method_9b12da03())
         .I_method_104de33f("1")
         .I_method_ec08f9eb(true);
      this.i_field_ba20522c = new KeybindSetting(this, "modules.settings.auction.auto_sell.bind", () -> !this.Ii_field_ba20ca4c.i_method_9b12da03());
      this.i_field_bbe33e6c = new ModeSetting(this, "modules.settings.auction.price_mode");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auction.price_mode.per_unit");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auction.price_mode.total");
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.auction.armor", () -> !this.iiI_method_26f1e6c3());
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auction.armor.no_spike").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auction.armor.no_prot5").select();
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auction.armor.no_durability");
      this.I_field_73178e8c = new SliderSetting(
            this, "modules.settings.auction.armor.min_durability", () -> !this.II_field_51de8227.isSelected() || !this.iiI_method_26f1e6c3()
         )
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(100.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(100.0F)
         .I_method_d41e7abf("%");
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auction.armor.no_repair");
      this.i_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.auction.pickaxe", () -> !this.iii_method_270072a3());
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.auction.pickaxe.silk_touch");
      this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.auction.pickaxe.noMega");
      this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.auction.pickaxe.noMiner");
      this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.auction.armor.no_repair");
      this.IiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.auction.pickaxe.noMagnit");
      this.Iii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.auction.pickaxe.noExp");
      this.II_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.auction.potions", () -> !this.IIII_method_e3f76c86());
      this.iII_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.II_field_bbe3ba6c, "modules.settings.auction.potions.no_level3");
      this.iIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.II_field_bbe3ba6c, "modules.settings.auction.potions.no_combined");
      this.iiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.II_field_bbe3ba6c, "modules.settings.auction.potions.no_under_6min");
   }

   private void Iii_method_f0655ebf() {
      if (!this.II_field_5a) {
         this.II_field_5a = true;

         for (Setting var2 : this.getSettings()) {
            if (var2 instanceof MultiSelectSetting var3) {
               this.I_field_ab760aac.I_method_cbb5737d(var3);
            }
         }
      }
   }

   @Override
   public void II_method_6642fd22() {
      if (this.I_field_a0ef7466 != AuctionModule.Nested1_2cd40429.I_field_a0ef7466) {
         this.iIi_method_253d827f();
      } else if (I_field_3a9bda27.currentScreen instanceof HandledScreen var1) {
         String var5 = var1.getTitle().getString();
         this.i_field_523beb0a = var5;
         if (this.i_field_5a && this.I_method_eba93b83(var1)) {
            if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var3) {
               I_field_3a9bda27.interactionManager.clickSlot(var3.syncId, 11, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.i_field_5a = false;
            }
         } else if (!this.I_method_dc4f026d(var5)) {
            this.IIii_method_e5c8e882();
         } else {
            this.I_method_dc4f0269(var5);
            this.I_method_eba93b7f(var1);
            super.II_method_6642fd22();
         }
      } else {
         this.IIii_method_e5c8e882();
         this.i_field_5a = false;
      }
   }

   private String I_method_9b5655b9(Text var1) {
      return var1.getString().replaceAll("(?i)\u00a7[0-9a-fk-or]", "").replaceAll("\\s+", " ").toLowerCase(Locale.ROOT);
   }

   private boolean iIi_method_253d8283() {
      for (Setting var2 : this.getSettings()) {
         if (var2 instanceof MultiSelectSetting var3 && var3.isVisible()) {
            return true;
         }
      }

      return false;
   }

   private void I_method_4c35b99d(CustomDrawContext var1) {
      this.Iii_method_f0655ebf();
      III var2 = III.I_method_5728d20f(
         var1,
         I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getX(),
         I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getY(),
         MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false)
      );
      this.I_field_ab760aac.II_method_a9112b4b(120.0F);
      this.I_field_ab760aac.I_method_a74dc6cc(10.0F, I_field_73c6d26c.i_method_805d6def() / 2.0F - this.I_field_ab760aac.Ii_method_2047ead7() / 2.0F);
      this.I_field_ab760aac.I_method_7ae26dda(var2);
   }

   private ColorRGBA I_method_9777442e(double var1) {
      double var3 = this.I_field_44 - this.i_field_44;
      float var5 = var3 > 0.0 ? (float)((var1 - this.i_field_44) / var3) : 0.0F;
      var5 = Math.max(0.0F, Math.min(1.0F, var5));
      ColorRGBA var6 = this.I_field_bbd4b66c.I_method_bde5f08e();
      ColorRGBA var7 = this.i_field_bbd4b66c.I_method_bde5f08e();
      ColorRGBA var8 = var6.mix(var7, var5);
      float var9 = 1.0F - var5 * 0.6F;
      return var8.mulAlpha(var9);
   }

   private boolean I_method_eba93b83(HandledScreen<?> var1) {
      String var2 = IiiiiIIii_Class244.I_method_780d5977(var1.getTitle().getString());
      return !var2.contains("\u043f\u043e\u043a\u0443\u043f\u043a") && !var2.contains("\u043f\u043e\u0434\u0442\u0432\u0435\u0440")
         ? !IiiiiIIiI_Class243.i_method_cb7c1763(var1) && !this.I_method_dc4f026d(var1.getTitle().getString())
         : true;
   }

   private boolean I_method_dc4f026d(String var1) {
      return IiiiiIIii_Class244.II_method_6da14e50(var1)
         ? true
         : this.I_method_68cdf01a(
            IiiiiIIii_Class244.I_method_780d5977(var1),
            "\u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a",
            "\u0448\u043b\u0435\u043c",
            "\u043f\u043e\u043d\u043e\u0436",
            "\u0431\u043e\u0442\u0438\u043d",
            "\u043a\u0438\u0440\u043a",
            "\u0437\u0435\u043b\u044c"
         );
   }

   private boolean i_method_ad06564d(String var1) {
      return IiiiiIIii_Class244.Ii_method_3e58a230(var1);
   }

   @Override
   public void onDisable() {
      this.IIiI_method_e5ba5ca2();
      this.IIii_method_e5c8e882();
      super.onDisable();
   }

   private void iII_method_252ef69f() {
      if (this.Ii_field_ba20ca4c.i_method_9b12da03() && I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         ItemStack var1 = I_field_3a9bda27.player.getMainHandStack();
         if (var1.isEmpty()) {
            RockstarClient.getInstance()
               .I_method_5cb1af22()
               .I_method_67864747(
                  new iiiIiIi_Class118(
                     "\u0412\u043e\u0437\u044c\u043c\u0438\u0442\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u0432 \u0440\u0443\u043a\u0443",
                     I_field_e4463c91[iIIiiiiiI_Class319.I_field_ec5bca73.nextInt(I_field_e4463c91.length)]
                  )
               );
         } else {
            this.I_field_3c05b08c = var1.getItem();
            this.I_field_f2735522 = var1.copy();
            this.II_field_523beb0a = Iiiiiiiii_Class256.i_method_524c3f7f(var1).trim();
            if (this.II_field_523beb0a.isEmpty()) {
               RockstarClient.getInstance()
                  .I_method_5cb1af22()
                  .I_method_67864747(
                     new iiiIiIi_Class118(
                        "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430",
                        I_field_e4463c91[iIIiiiiiI_Class319.I_field_ec5bca73.nextInt(I_field_e4463c91.length)]
                     )
                  );
            } else {
               this.i_field_49 = this.III_method_ee93e2b2();
               this.II_field_49 = 0;
               this.Ii_field_49 = -1;
               this.i_field_7865b31.clear();
               this.I_field_a0ef7466 = AuctionModule.Nested1_2cd40429.i_field_a0ef7466;
               this.i_field_991c1e8c.I_method_23e11e3f();
               this.II_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void iIi_method_253d827f() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         switch (this.I_field_a0ef7466) {
            case i_field_a0ef7466:
               this.iiI_method_26f1e6bf();
               break;
            case II_field_a0ef7466:
               this.iii_method_2700729f();
               break;
            case Ii_field_a0ef7466:
               this.IIII_method_e3f76c82();
         }
      } else {
         this.IIiI_method_e5ba5ca2();
      }
   }

   private void iiI_method_26f1e6bf() {
      if (this.i_field_991c1e8c.I_method_58432069(100L)) {
         this.IiII_method_1a928062();
         I_field_3a9bda27.player.networkHandler.sendChatCommand("ah search " + this.II_field_523beb0a);
         this.I_method_51dd59c5(AuctionModule.Nested1_2cd40429.II_field_a0ef7466);
      }
   }

   private void iii_method_2700729f() {
      ScreenHandler var1 = this.I_method_db94d517();
      if (var1 == null) {
         if (this.II_field_991c1e8c.I_method_58432069(5000L)) {
            iIIIIIIii_Class260.i_method_70898627(
               Text.literal(
                  "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0430\u0443\u043a\u0446\u0438\u043e\u043d"
               )
            );
            this.IIiI_method_e5ba5ca2();
         }
      } else if (this.i_field_991c1e8c.I_method_58432069(100L)) {
         this.II_field_49++;
         this.i_field_7865b31.addAll(this.I_method_ae8c6348(var1));
         if (this.II_field_49 >= this.i_field_49) {
            this.IIIi_method_e405f862();
         } else {
            AuctionModule.Nested1_2cd40449 var2 = this.I_method_737e0c1d(var1);
            if (var2 != null && var2.I_field_49 >= var2.i_field_49) {
               this.IIIi_method_e405f862();
            } else {
               int var3 = this.I_method_8933ad12(var1);
               if (var3 == -1) {
                  this.IIIi_method_e405f862();
               } else {
                  this.Ii_field_49 = var2 == null ? -1 : var2.I_field_49 + 1;
                  I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var3, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
                  this.I_method_51dd59c5(AuctionModule.Nested1_2cd40429.Ii_field_a0ef7466);
               }
            }
         }
      }
   }

   private void IIII_method_e3f76c82() {
      ScreenHandler var1 = this.I_method_db94d517();
      if (var1 == null) {
         this.IIIi_method_e405f862();
      } else {
         AuctionModule.Nested1_2cd40449 var2 = this.I_method_737e0c1d(var1);
         if (var2 != null && this.Ii_field_49 != -1 && var2.I_field_49 >= this.Ii_field_49) {
            this.I_method_51dd59c5(AuctionModule.Nested1_2cd40429.II_field_a0ef7466);
         } else if (this.Ii_field_49 == -1 && this.i_field_991c1e8c.I_method_58432069(100L)) {
            this.I_method_51dd59c5(AuctionModule.Nested1_2cd40429.II_field_a0ef7466);
         } else {
            if (this.II_field_991c1e8c.I_method_58432069(5000L)) {
               this.IIIi_method_e405f862();
            }
         }
      }
   }

   private void IIIi_method_e405f862() {
      AuctionModule.Nested1_2cd40829 var1 = this.I_method_840b89ac(this.i_field_7865b31);
      if (var1.i_field_49 > 0) {
         long var2 = Math.round(var1.I_method_a711ad1f());
         int var4 = Math.max(1, this.I_field_f2735522.getCount());
         long var5 = var2 * var4;
         this.IiII_method_1a928062();
         I_field_3a9bda27.player.networkHandler.sendChatCommand("ah sell " + var5);
         iIIIIIIii_Class260.I_method_468cf607(
            Text.literal(
               "\u0412\u044b\u0441\u0442\u0430\u0432\u0438\u043b "
                  + this.I_field_3c05b08c.getName().getString()
                  + " x"
                  + var4
                  + " \u0437\u0430 $"
                  + this.I_method_60af36fb(var5)
                  + " ("
                  + this.I_method_60af36fb(var2)
                  + "$ \u0437\u0430 1 \u0448\u0442.)"
            )
         );
      } else {
         iIIIIIIii_Class260.i_method_70898627(
            Text.literal(
               "\u0426\u0435\u043d\u044b \u0434\u043b\u044f \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430 \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u044b"
            )
         );
         this.IiII_method_1a928062();
      }

      this.IIiI_method_e5ba5ca2();
   }

   private void I_method_51dd59c5(AuctionModule.Nested1_2cd40429 var1) {
      this.I_field_a0ef7466 = var1;
      this.i_field_991c1e8c.I_method_23e11e3f();
      this.II_field_991c1e8c.I_method_23e11e3f();
   }

   private void IIiI_method_e5ba5ca2() {
      this.I_field_a0ef7466 = AuctionModule.Nested1_2cd40429.I_field_a0ef7466;
      this.I_field_3c05b08c = null;
      this.I_field_f2735522 = ItemStack.EMPTY;
      this.II_field_523beb0a = "";
      this.i_field_49 = 1;
      this.II_field_49 = 0;
      this.Ii_field_49 = -1;
      this.i_field_7865b31.clear();
   }

   private boolean I_method_51ebfb85(ItemStack var1) {
      EquippableComponent var2 = (EquippableComponent)var1.get(DataComponentTypes.EQUIPPABLE);
      if (var2 != null && var1.getMaxDamage() > 0) {
         return switch (var2.slot()) {
            case HEAD, CHEST, LEGS, FEET -> true;
            default -> false;
         };
      } else {
         return false;
      }
   }

   private boolean I_method_f91d6676(ItemStack var1, List<Text> var2) {
      Item var3 = var1.getItem();
      if (this.I_field_708bda67 == AuctionModule.Nested1_e8ac0020.i_field_708bda67 && this.I_method_51ebfb85(var1)) {
         if (this.I_field_51de8227.isSelected() && iIIiIiIIi_Class298.I_method_42348643(var1, Enchantments.THORNS)) {
            return true;
         }

         if (this.i_field_51de8227.isSelected() && iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.PROTECTION) < 5) {
            return true;
         }

         if (this.II_field_51de8227.isSelected() && var1.getMaxDamage() > 0) {
            double var4 = (double)(var1.getMaxDamage() - var1.getDamage()) / var1.getMaxDamage() * 100.0;
            if (var4 < this.I_field_73178e8c.Ii_method_a20abcd2()) {
               return true;
            }
         }

         if (this.Ii_field_51de8227.isSelected() && !iIIiIiIIi_Class298.I_method_42348643(var1, Enchantments.MENDING)) {
            return true;
         }
      }

      if (this.I_field_708bda67 == AuctionModule.Nested1_e8ac0020.II_field_708bda67 && var3.getTranslationKey().contains("pickaxe")) {
         if (this.iI_field_51de8227.isSelected() && !iIIiIiIIi_Class298.I_method_42348643(var1, Enchantments.SILK_TOUCH)) {
            return true;
         }

         if (this.IIi_field_51de8227.isSelected() && !iIIiIiIIi_Class298.I_method_42348643(var1, Enchantments.MENDING)) {
            return true;
         }

         if (this.IiI_field_51de8227.isSelected() && !iIIiIiIIi_Class298.I_method_72bc96fe(var2, "\u043c\u0430\u0433\u043d\u0438\u0442")) {
            return true;
         }

         if (this.ii_field_51de8227.isSelected()
            && !iIIiIiIIi_Class298.I_method_72bc96fe(var2, "\u043c\u0435\u0433\u0430-\u0431\u0443\u043b\u044c\u0434\u043e\u0437\u0435\u0440")) {
            return true;
         }

         if (this.Iii_field_51de8227.isSelected() && !iIIiIiIIi_Class298.I_method_e4d6bb4d(var2, "\u043e\u043f\u044b\u0442\u043d\u044b\u0439", 3)) {
            return true;
         }

         if (this.III_field_51de8227.isSelected() && !iIIiIiIIi_Class298.I_method_e4d6bb4d(var2, "\u0431\u0443\u043b\u044c\u0434\u043e\u0437\u0435\u0440", 2)) {
            return true;
         }
      }

      if (this.I_field_708bda67 == AuctionModule.Nested1_e8ac0020.Ii_field_708bda67
         && (var3 instanceof PotionItem || var3 instanceof SplashPotionItem || var3 instanceof LingeringPotionItem)) {
         List var7 = var2.stream().map(var0 -> var0.getString().toLowerCase(Locale.ROOT)).toList();
         boolean var5 = this.II_method_1e25b9d7(var7);
         if (!var5) {
            boolean var6 = this.I_method_f4040154(var7);
            if (this.iII_field_51de8227.isSelected() && var6 && !this.i_method_e83ecd34(var7)) {
               return true;
            }

            if (this.iIi_field_51de8227.isSelected() && var6 && !this.Ii_method_126085b7(var7)) {
               return true;
            }

            return this.iiI_field_51de8227.isSelected() && this.iI_method_b14469f7(var7);
         }
      }

      return false;
   }

   private boolean I_method_f4040154(List<String> var1) {
      for (String var3 : var1) {
         String var4 = var3.toLowerCase(Locale.ROOT);
         if ((!var4.contains("\u0441\u0438\u043b\u0430") || var4.contains("\u0443\u0440\u043e\u043d"))
            && (!var4.contains("\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c") || var4.contains("\u0430\u0442\u0430\u043a\u0438"))) {
            if (!var4.contains("strength") && (!var4.contains("speed") || var4.contains("attack"))) {
               continue;
            }

            return true;
         }

         return true;
      }

      return false;
   }

   private boolean iiI_method_26f1e6c3() {
      return this.I_field_708bda67 == AuctionModule.Nested1_e8ac0020.i_field_708bda67
         || I_field_3a9bda27.currentScreen == RockstarClient.getInstance().I_method_96982062();
   }

   private boolean iii_method_270072a3() {
      return this.I_field_708bda67 == AuctionModule.Nested1_e8ac0020.II_field_708bda67
         || I_field_3a9bda27.currentScreen == RockstarClient.getInstance().I_method_96982062();
   }

   private boolean IIII_method_e3f76c86() {
      if (this.I_field_708bda67 == AuctionModule.Nested1_e8ac0020.Ii_field_708bda67) {
         String var1 = this.i_field_523beb0a.toLowerCase(Locale.ROOT);
         return !this.I_method_68cdf01a(var1, "\u0438\u043d\u0432\u0438\u0437", "\u043d\u0435\u0432\u0438\u0434", "invis");
      } else {
         return I_field_3a9bda27.currentScreen == RockstarClient.getInstance().I_method_96982062();
      }
   }

   private boolean I_method_68cdf01a(String var1, String... var2) {
      for (String var6 : var2) {
         if (var1.contains(var6)) {
            return true;
         }
      }

      return false;
   }

   private void I_method_dc4f0269(String var1) {
      if (!this.II_method_4e4a630(IiiiiIIii_Class244.I_method_780d5977(var1))) {
         if (!this.II_method_4e4a630(IiiiiIIiI_Class243.I_method_a6a81421().toLowerCase(Locale.ROOT))) {
            this.I_field_708bda67 = AuctionModule.Nested1_e8ac0020.I_field_708bda67;
         }
      }
   }

   private boolean II_method_4e4a630(String var1) {
      if (var1.isEmpty()) {
         return false;
      } else if (this.I_method_68cdf01a(
         var1,
         "\u0437\u0435\u043b\u044c",
         "\u0431\u0430\u0444",
         "\u0431\u0430\u0444\u0444",
         "\u0441\u0438\u043b\u0430",
         "\u0441\u0438\u043b\u044b",
         "\u0441\u0438\u043b\u043a\u0430",
         "\u0441\u0438\u043b\u044c\u043a\u0430",
         "\u0441\u043a\u043e\u0440\u043e\u0441\u0442",
         "\u0438\u043d\u0432\u0438\u0437",
         "\u0438\u043d\u0432\u0438\u0437\u043a",
         "\u043d\u0435\u0432\u0438\u0434"
      )) {
         this.I_field_708bda67 = AuctionModule.Nested1_e8ac0020.Ii_field_708bda67;
         return true;
      } else if (this.I_method_68cdf01a(
         var1,
         "\u0448\u043b\u0435\u043c",
         "\u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a",
         "\u043f\u043e\u043d\u043e\u0436",
         "\u0431\u043e\u0442\u0438\u043d",
         "\u0431\u0440\u043e\u043d"
      )) {
         this.I_field_708bda67 = AuctionModule.Nested1_e8ac0020.i_field_708bda67;
         return true;
      } else if (this.I_method_68cdf01a(
         var1,
         "\u043a\u0438\u0440\u043a",
         "\u043a\u0438\u0440\u043a\u0430",
         "\u043a\u0438\u0440\u043a\u0438",
         "\u043a\u0438\u0440\u043e\u043a",
         "\u0448\u0430\u0445\u0442",
         "\u0431\u0443\u0440"
      )) {
         this.I_field_708bda67 = AuctionModule.Nested1_e8ac0020.II_field_708bda67;
         return true;
      } else {
         return false;
      }
   }

   private boolean i_method_e83ecd34(List<String> var1) {
      int var2 = 0;

      for (String var4 : var1) {
         var4 = var4.toLowerCase(Locale.ROOT);
         if (++var2 <= 2) {
            if ((var4.contains("\u0441\u0438\u043b") || var4.contains("\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c"))
               && !var4.contains("iii")
               && !var4.contains("\u0443\u0441\u0438\u043b\u0435\u043d\u043d")) {
               continue;
            }

            return true;
         }
         break;
      }

      return false;
   }

   private boolean II_method_1e25b9d7(List<String> var1) {
      for (String var3 : var1) {
         if (var3.contains("\u0438\u043d\u0432\u0438\u0437") || var3.contains("\u043d\u0435\u0432\u0438\u0434")) {
            return true;
         }
      }

      return false;
   }

   private boolean Ii_method_126085b7(List<String> var1) {
      boolean var2 = var1.stream().anyMatch(var0 -> var0.contains("\u0441\u0438\u043b\u0430"));
      boolean var3 = var1.stream().anyMatch(var0 -> var0.contains("\u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c"));
      return var2 && var3;
   }

   private boolean iI_method_b14469f7(List<String> var1) {
      for (String var3 : var1) {
         if (var3.contains("\u0441\u0438\u043b\u0430")) {
            int var4 = this.I_method_dc4f025c(var3);
            if (var4 != -1 && var4 < 6) {
               return true;
            }
         }
      }

      return false;
   }

   private int I_method_dc4f025c(String var1) {
      try {
         Pattern var2 = Pattern.compile("(\\d+):(\\d+)");
         Matcher var3 = var2.matcher(var1);
         if (var3.find()) {
            return Integer.parseInt(var3.group(1));
         }
      } catch (Exception var4) {
      }

      return -1;
   }

   private void I_method_eba93b7f(HandledScreen<?> var1) {
      this.I_field_7865b31.clear();
      this.i_field_44 = Double.MAX_VALUE;
      this.I_field_44 = 0.0;
      boolean var2 = this.i_method_ad06564d(this.i_field_523beb0a);
      this.I_field_49 = -1;
      this.Ii_field_44 = -1.0;
      double var3 = 0.0;
      int var5 = 0;
      int var6 = var1.getScreenHandler().slots.size() - 36;

      for (int var7 = 0; var7 < var6; var7++) {
         Slot var8 = var1.getScreenHandler().getSlot(var7);
         if (var8 != null && var8.hasStack()) {
            ItemStack var9 = var8.getStack();
            List var10 = var9.getTooltip(
               TooltipContext.create(I_field_3a9bda27.world),
               I_field_3a9bda27.player,
               I_field_3a9bda27.options.advancedItemTooltips ? TooltipType.ADVANCED : TooltipType.BASIC
            );
            if (!this.I_method_f91d6676(var9, var10)) {
               long var11 = -1L;
               long var13 = -1L;
               long var15 = -1L;
               long var17 = -1L;
               if (var2) {
                  for (Text var20 : (Iterable<Text>)(Iterable<?>)var10) {
                     String var21 = IiiiiIIii_Class244.i_method_982c4197(var20.getString());
                     String var22 = var21.toLowerCase(Locale.ROOT);
                     if (var22.contains("\u0431\u0438\u0440\u0436\u0430 \u0431\u0430\u043b\u0430\u043d\u0441")) {
                        var15 = this.i_method_ad06563d(var21);
                     } else if (var22.contains("\u043c\u043e\u043d\u0435\u0442")) {
                        var17 = this.i_method_ad06563d(var21);
                     } else if (var22.contains("\u043a\u0443\u0440\u0441")) {
                        var13 = this.i_method_ad06563d(var21);
                     }
                  }
               } else {
                  var11 = IiiiiIIii_Class244.I_method_6e254d24(var10);
               }

               if (var15 != -1L) {
                  this.Ii_field_4a = var15;
               }

               if (var17 != -1L) {
                  this.iI_field_4a = var17;
               }

               Double var29 = null;
               long var30 = -1L;
               if (var2) {
                  if (var13 > 0L) {
                     var29 = (double)(-var13);
                     var30 = var13;
                     if (this.Ii_field_4a != -1L && this.Ii_field_4a < var13) {
                        continue;
                     }

                     if (var13 > this.Ii_field_44) {
                        this.Ii_field_44 = var13;
                        this.I_field_49 = var8.id;
                     }
                  }
               } else if (var11 > 0L) {
                  int var31 = Math.max(1, var9.getCount());
                  int var23 = var9.getMaxDamage();
                  int var24 = var23 - var9.getDamage();
                  double var25 = this.i_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627) ? (double)var11 / var31 : var11;
                  double var27 = 1.0;
                  if (var23 > 0) {
                     var27 = (double)var24 / var23;
                     var27 = Math.max(0.1, var27);
                  }

                  var29 = var25 / var27;
                  var30 = var11;
               }

               if (var29 != null) {
                  int var32 = var9.getCount();
                  int var33 = var9.getMaxDamage();
                  int var34 = var33 - var9.getDamage();
                  this.I_field_7865b31.add(new AuctionModule.Nested1_e8ac0040(var8.id, var30, var32, var33, var34, var29));
                  var3 += var29;
                  var5++;
                  if (var29 < this.i_field_44) {
                     this.i_field_44 = var29;
                  }
               }
            }
         }
      }

      if (var5 > 0) {
         this.I_field_44 = var3 / var5;
      } else {
         this.IIii_method_e5c8e882();
      }
   }

   private void IIii_method_e5c8e882() {
      this.I_field_7865b31.clear();
      this.I_field_44 = 0.0;
      this.i_field_44 = Double.MAX_VALUE;
      this.I_field_708bda67 = AuctionModule.Nested1_e8ac0020.I_field_708bda67;
      this.I_field_49 = -1;
      this.Ii_field_44 = -1.0;
      this.Ii_field_4a = -1L;
      this.iI_field_4a = -1L;
   }

   private List<AuctionModule.Nested1_2cd40809> I_method_ae8c6348(ScreenHandler var1) {
      ArrayList var2 = new ArrayList();
      int var3 = Math.max(0, var1.slots.size() - 36);

      for (int var4 = 0; var4 < var3; var4++) {
         Slot var5 = (Slot)var1.slots.get(var4);
         if (var5 != null && var5.hasStack()) {
            ItemStack var6 = var5.getStack();
            if (var6.getItem() == this.I_field_3c05b08c) {
               int var7 = Math.max(1, var6.getCount());
               double var8 = this.I_method_eb93e790(var6, var7);
               if (!(var8 <= 0.0)) {
                  var2.add(new AuctionModule.Nested1_2cd40809(Math.round(var8 * var7), var7, var8));
               }
            }
         }
      }

      return var2;
   }

   private AuctionModule.Nested1_2cd40829 I_method_840b89ac(List<AuctionModule.Nested1_2cd40809> var1) {
      if (var1.isEmpty()) {
         return new AuctionModule.Nested1_2cd40829(0, 0, 0L, 0);
      } else {
         List var2 = var1.stream().sorted(Comparator.comparingDouble(AuctionModule.Nested1_2cd40809::I_method_7076993f)).toList();
         double var3 = ((AuctionModule.Nested1_2cd40809)var2.getFirst()).I_field_44;
         double var5 = var3 * 1.6;
         long var7 = 0L;
         int var9 = 0;
         int var10 = 0;

         for (AuctionModule.Nested1_2cd40809 var12 : (Iterable<AuctionModule.Nested1_2cd40809>)(Iterable<?>)var2) {
            if (var12.I_field_44 > var5 && var10 > 0) {
               break;
            }

            var7 += var12.I_field_4a;
            var9 += var12.I_field_49;
            var10++;
         }

         if (var10 == 1 && var2.size() > 1) {
            AuctionModule.Nested1_2cd40809 var13 = (AuctionModule.Nested1_2cd40809)var2.get(1);
            var7 += var13.I_field_4a;
            var9 += var13.I_field_49;
            var10++;
         }

         return new AuctionModule.Nested1_2cd40829(var10, var9, var7, var1.size() - var10);
      }
   }

   private double I_method_eb93e790(ItemStack var1, int var2) {
      if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
         double var3 = this.I_method_51ebfb6f(var1);
         if (var3 > 0.0) {
            return var3;
         }
      }

      for (Text var4 : this.I_method_2a4544a6(var1)) {
         String var5 = var4.getString();
         if (var5.contains("$") && !var5.contains("%")) {
            long var6 = this.i_method_ad06563d(var5);
            if (var6 > 0L) {
               return (double)var6 / var2;
            }
         }
      }

      return -1.0;
   }

   private double I_method_51ebfb6f(ItemStack var1) {
      for (Text var3 : this.I_method_2a4544a6(var1)) {
         String var4 = var3.getString();
         String var5 = var4.toLowerCase(Locale.ROOT);
         if (var5.contains("\u0446\u0435\u043d\u0430 \u0437\u0430 1") || var5.contains("price per 1")) {
            long var6 = this.I_method_dc4f025d(var4);
            if (var6 > 0L) {
               return var6;
            }
         }
      }

      return -1.0;
   }

   private int I_method_8933ad12(ScreenHandler var1) {
      int var2 = Math.max(0, var1.slots.size() - 36);

      for (int var3 = 0; var3 < var2; var3++) {
         Slot var4 = (Slot)var1.slots.get(var3);
         if (var4 != null && var4.hasStack()) {
            ItemStack var5 = var4.getStack();
            if (this.i_method_f5e47f65(var5)) {
               return var3;
            }
         }
      }

      return -1;
   }

   private AuctionModule.Nested1_2cd40449 I_method_737e0c1d(ScreenHandler var1) {
      if (I_field_3a9bda27.currentScreen != null) {
         AuctionModule.Nested1_2cd40449 var2 = this.I_method_a1287313(I_field_3a9bda27.currentScreen.getTitle().getString());
         if (var2 != null) {
            return var2;
         }
      }

      int var6 = Math.max(0, var1.slots.size() - 36);

      for (int var3 = 0; var3 < var6; var3++) {
         Slot var4 = (Slot)var1.slots.get(var3);
         if (var4 != null && var4.hasStack()) {
            AuctionModule.Nested1_2cd40449 var5 = this.I_method_e42a30fb(var4.getStack());
            if (var5 != null) {
               return var5;
            }
         }
      }

      return null;
   }

   private AuctionModule.Nested1_2cd40449 I_method_e42a30fb(ItemStack var1) {
      for (Text var3 : this.I_method_2a4544a6(var1)) {
         AuctionModule.Nested1_2cd40449 var4 = this.I_method_a1287313(var3.getString());
         if (var4 != null) {
            return var4;
         }
      }

      return null;
   }

   private AuctionModule.Nested1_2cd40449 I_method_a1287313(String var1) {
      Matcher var2 = I_field_5fd3861f.matcher(var1);
      if (!var2.find()) {
         return null;
      } else {
         try {
            return new AuctionModule.Nested1_2cd40449(Integer.parseInt(var2.group(1)), Integer.parseInt(var2.group(2)));
         } catch (NumberFormatException var4) {
            return null;
         }
      }
   }

   private boolean i_method_f5e47f65(ItemStack var1) {
      String var2 = var1.getName().getString().toLowerCase(Locale.ROOT);

      for (Text var4 : this.I_method_2a4544a6(var1)) {
         var2 = var2 + " " + var4.getString().toLowerCase(Locale.ROOT);
      }

      return var2.contains("\u0441\u043b\u0435\u0434")
         || var2.contains("\u0434\u0430\u043b\u0435\u0435")
         || var2.contains("\u0432\u043f\u0435\u0440")
         || var2.contains("next");
   }

   private List<Text> I_method_2a4544a6(ItemStack var1) {
      return var1.getTooltip(
         TooltipContext.create(I_field_3a9bda27.world),
         I_field_3a9bda27.player,
         I_field_3a9bda27.options.advancedItemTooltips ? TooltipType.ADVANCED : TooltipType.BASIC
      );
   }

   private long I_method_dc4f025d(String var1) {
      int var2 = var1.lastIndexOf(58);
      return this.i_method_ad06563d(var2 == -1 ? var1 : var1.substring(var2 + 1));
   }

   private int III_method_ee93e2b2() {
      try {
         String var1 = this.I_field_731802cc.II_method_da016c1e();
         if (var1 != null && !var1.isBlank()) {
            String var2 = var1.replaceAll("[^\\d]", "");
            return var2.isEmpty() ? 1 : Math.max(1, Integer.parseInt(var2));
         } else {
            return 1;
         }
      } catch (NumberFormatException var3) {
         return 1;
      }
   }

   private ScreenHandler I_method_db94d517() {
      if (!(I_field_3a9bda27.currentScreen instanceof HandledScreen)) {
         return null;
      } else if (I_field_3a9bda27.player == null) {
         return null;
      } else {
         ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
         return var1 == I_field_3a9bda27.player.playerScreenHandler ? null : var1;
      }
   }

   private void IiII_method_1a928062() {
      if (I_field_3a9bda27.player != null) {
         if (I_field_3a9bda27.player.currentScreenHandler != null
            && I_field_3a9bda27.player.currentScreenHandler != I_field_3a9bda27.player.playerScreenHandler) {
            I_field_3a9bda27.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(I_field_3a9bda27.player.currentScreenHandler.syncId));
         }

         if (I_field_3a9bda27.currentScreen instanceof HandledScreen) {
            I_field_3a9bda27.player.closeHandledScreen();
         }
      }
   }

   private String I_method_60af36fb(long var1) {
      return String.format(Locale.US, "%,d", var1);
   }

   private long i_method_ad06563d(String var1) {
      return IiiiiIIii_Class244.I_method_534cd63d(var1);
   }

   @Generated
   public List<AuctionModule.Nested1_e8ac0040> I_method_d0d608() {
      return this.I_field_7865b31;
   }

   @Generated
   public double I_method_4870124d() {
      return this.I_field_44;
   }

   @Generated
   public double i_method_487e9e2d() {
      return this.i_field_44;
   }

   @Generated
   public String II_method_3ce863fe() {
      return this.i_field_523beb0a;
   }

   @Generated
   public int II_method_c5a130d5() {
      return this.I_field_49;
   }

   @Generated
   public double II_method_c5a130d0() {
      return this.Ii_field_44;
   }

   @Generated
   public long I_method_48701253() {
      return this.Ii_field_4a;
   }

   @Generated
   public long i_method_487e9e33() {
      return this.iI_field_4a;
   }

   @Generated
   public ColorSetting I_method_f4bdf35() {
      return this.I_field_bbd4b66c;
   }

   @Generated
   public ColorSetting i_method_24e15315() {
      return this.i_field_bbd4b66c;
   }

   @Generated
   public BooleanSetting I_method_d97f315() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting i_method_232d66f5() {
      return this.i_field_ba20ca4c;
   }

   @Generated
   public KeybindSetting I_method_d977af5() {
      return this.I_field_ba20522c;
   }

   @Generated
   public BooleanSetting II_method_53fb23d8() {
      return this.II_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting Ii_method_699097b8() {
      return this.Ii_field_ba20ca4c;
   }

   @Generated
   public ModeSetting I_method_f5a6735() {
      return this.I_field_bbe33e6c;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 I_method_a25d20b0() {
      return this.I_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 i_method_a8651c90() {
      return this.i_field_500d0627;
   }

   @Generated
   public TextSetting I_method_c68f2b95() {
      return this.I_field_731802cc;
   }

   @Generated
   public KeybindSetting i_method_232ceed5() {
      return this.i_field_ba20522c;
   }

   @Generated
   public ModeSetting i_method_24efdb15() {
      return this.i_field_bbe33e6c;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 II_method_dcb72cb3() {
      return this.II_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 Ii_method_e2bf2893() {
      return this.Ii_field_500d0627;
   }

   @Generated
   public MultiSelectSetting I_method_f5ae335() {
      return this.I_field_bbe3ba6c;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 I_method_a42e9cb0() {
      return this.I_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 i_method_aa369890() {
      return this.i_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 II_method_de88a8b3() {
      return this.II_field_51de8227;
   }

   @Generated
   public SliderSetting I_method_c68eb755() {
      return this.I_field_73178e8c;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 Ii_method_e490a493() {
      return this.Ii_field_51de8227;
   }

   @Generated
   public MultiSelectSetting i_method_24f05715() {
      return this.i_field_bbe3ba6c;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 iI_method_998028d3() {
      return this.iI_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 ii_method_9f8824b3() {
      return this.ii_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 III_method_ef701d10() {
      return this.III_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 IIi_method_f57818f0() {
      return this.IIi_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 IiI_method_aa679d30() {
      return this.IiI_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 Iii_method_b06f9910() {
      return this.Iii_field_51de8227;
   }

   @Generated
   public MultiSelectSetting II_method_55be13f8() {
      return this.II_field_bbe3ba6c;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 iII_method_9368a0f0() {
      return this.iII_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 iIi_method_99709cd0() {
      return this.iIi_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 iiI_method_4e602110() {
      return this.iiI_field_51de8227;
   }

   @Generated
   public boolean IiI_method_f056d2e3() {
      return this.I_field_5a;
   }

   @Generated
   public boolean Iii_method_f0655ec3() {
      return this.i_field_5a;
   }

   @Generated
   public iiIiIIiii_Class424 I_method_ec934755() {
      return this.I_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 i_method_228bb35() {
      return this.i_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 II_method_32f67818() {
      return this.II_field_991c1e8c;
   }

   @Generated
   public List<AuctionModule.Nested1_2cd40809> i_method_b61d0e28() {
      return this.i_field_7865b31;
   }

   @Generated
   public AuctionModule.Nested1_2cd40429 I_method_98a2aafd() {
      return this.I_field_a0ef7466;
   }

   @Generated
   public Item I_method_3f927795() {
      return this.I_field_3c05b08c;
   }

   @Generated
   public ItemStack I_method_ea268bb9() {
      return this.I_field_f2735522;
   }

   @Generated
   public String Ii_method_d007141e() {
      return this.II_field_523beb0a;
   }

   @Generated
   public int Ii_method_c5afbcb5() {
      return this.i_field_49;
   }

   @Generated
   public int iI_method_c76420f5() {
      return this.II_field_49;
   }

   @Generated
   public int ii_method_c772acd5() {
      return this.Ii_field_49;
   }

   @Generated
   public IiIIiiIii_Class156 I_method_feed3375() {
      return this.I_field_ab760aac;
   }

   @Generated
   public boolean iII_method_252ef6a3() {
      return this.II_field_5a;
   }

   @Generated
   public AuctionModule.Nested1_e8ac0020 I_method_c2dbf4f0() {
      return this.I_field_708bda67;
   }

   @Generated
   public IiIIIiII_Class69<KeyPressEvent> I_method_ab9f8958() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ReceivePacketEvent> i_method_d59c1978() {
      return this.i_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<HudRenderEvent> II_method_2181b435() {
      return this.II_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ScreenRenderEvent> Ii_method_4b7e4455() {
      return this.Ii_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ContainerClickEvent> iI_method_37172815() {
      return this.iI_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ContainerReleaseEvent> ii_method_6113b835() {
      return this.ii_field_3d936f41;
   }

   static enum Nested1_2cd40429 {
      I_field_a0ef7466,
      i_field_a0ef7466,
      II_field_a0ef7466,
      Ii_field_a0ef7466;
   }

   static final class Nested1_2cd40449 {
      final int I_field_49;
      final int i_field_49;

      Nested1_2cd40449(int var1, int var2) {
         this.I_field_49 = var1;
         this.i_field_49 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_2cd40449[current=" + this.I_field_49 + ", total=" + this.i_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         AuctionModule.Nested1_2cd40449 other = (AuctionModule.Nested1_2cd40449) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49);
      }

      public int I_method_a4a4504() {
         return this.I_field_49;
      }

      public int i_method_a58d0e4() {
         return this.i_field_49;
      }
   }

   static final class Nested1_2cd40809 {
      final long I_field_4a;
      final int I_field_49;
      final double I_field_44;

      Nested1_2cd40809(long var1, int var3, double var4) {
         this.I_field_4a = var1;
         this.I_field_49 = var3;
         this.I_field_44 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_2cd40809[totalPrice=" + this.I_field_4a + ", count=" + this.I_field_49 + ", unitPrice=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         AuctionModule.Nested1_2cd40809 other = (AuctionModule.Nested1_2cd40809) var1;
         return java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public long I_method_70769945() {
         return this.I_field_4a;
      }

      public int I_method_70769944() {
         return this.I_field_49;
      }

      public double I_method_7076993f() {
         return this.I_field_44;
      }
   }

   static final class Nested1_2cd40829 {
      private final int I_field_49;
      final int i_field_49;
      private final long I_field_4a;
      private final int II_field_49;

      Nested1_2cd40829(int var1, int var2, long var3, int var5) {
         this.I_field_49 = var1;
         this.i_field_49 = var2;
         this.I_field_4a = var3;
         this.II_field_49 = var5;
      }

      double I_method_a711ad1f() {
         return this.i_field_49 <= 0 ? 0.0 : (double)this.I_field_4a / this.i_field_49;
      }

      @Override
      public final String toString() {
         return "Nested1_2cd40829[lots=" + this.I_field_49 + ", units=" + this.i_field_49 + ", totalPrice=" + this.I_field_4a + ", skippedLots=" + this.II_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         AuctionModule.Nested1_2cd40829 other = (AuctionModule.Nested1_2cd40829) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49);
      }

      public int I_method_a711ad24() {
         return this.I_field_49;
      }

      public int i_method_a7203904() {
         return this.i_field_49;
      }

      public long I_method_a711ad25() {
         return this.I_field_4a;
      }

      public int II_method_3b32f043() {
         return this.II_field_49;
      }
   }

   static enum Nested1_e8ac0020 {
      I_field_708bda67,
      i_field_708bda67,
      II_field_708bda67,
      Ii_field_708bda67;
   }

   public static final class Nested1_e8ac0040 {
      final int I_field_49;
      private final long I_field_4a;
      private final int i_field_49;
      private final int II_field_49;
      private final int Ii_field_49;
      final double I_field_44;

      public Nested1_e8ac0040(int var1, long var2, int var4, int var5, int var6, double var7) {
         this.I_field_49 = var1;
         this.I_field_4a = var2;
         this.i_field_49 = var4;
         this.II_field_49 = var5;
         this.Ii_field_49 = var6;
         this.I_field_44 = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_e8ac0040[slotId=" + this.I_field_49 + ", totalPrice=" + this.I_field_4a + ", count=" + this.i_field_49 + ", maxDurability=" + this.II_field_49 + ", currentDurability=" + this.Ii_field_49 + ", effectivePrice=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         AuctionModule.Nested1_e8ac0040 other = (AuctionModule.Nested1_e8ac0040) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49)
            && java.util.Objects.equals(this.Ii_field_49, other.Ii_field_49)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public int I_method_12b42b6d() {
         return this.I_field_49;
      }

      public long I_method_12b42b6e() {
         return this.I_field_4a;
      }

      public int i_method_12c2b74d() {
         return this.i_field_49;
      }

      public int II_method_43e03b1a() {
         return this.II_field_49;
      }

      public int Ii_method_43eec6fa() {
         return this.Ii_field_49;
      }

      public double I_method_12b42b68() {
         return this.I_field_44;
      }
   }
}
