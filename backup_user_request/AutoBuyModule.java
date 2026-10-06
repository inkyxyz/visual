package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.render.ScreenRenderEvent;
import pyrock.utility.render.CustomDrawContext;

@ModuleInfo(
   name = "Auto Buy",
   category = ModuleCategory.OTHER,
   III_method_a89e5834 = "modules.descriptions.auto_buy"
)
public class AutoBuyModule extends Module {
   private AutoBuyModule.Nested1_61bab3c9 I_field_8deb8c6;
   private static final long I_field_4a = 3000L;
   private static final long i_field_4a = 90000L;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private long II_field_4a;
   private IiiIIiIi_Class102.Nested1_6cef9133 I_field_af10c59c;
   private final IiiIiIII_Class105 I_field_dc0f3ba1;
   private final IiiIIiiI_Class103 I_field_da5b4f81;
   private final IiiIiIIi_Class106 I_field_dc0f3f81;
   private final IiiIiIiI_Class107 I_field_dc0fb3c1;
   private final ButtonSetting I_field_bbd4b28c;
   private final ButtonSetting i_field_bbd4b28c;
   private final Pattern I_field_5fd3861f;
   private final List<AutoBuyModule.Nested1_ea60dca0> I_field_7865b31;
   private AutoBuyModule.Nested1_ea60dc80 I_field_a5728a07;
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ScreenRenderEvent> i_field_3d936f41;

   public AutoBuyModule() {
      this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.I_field_8deb8c6;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.II_field_4a = System.currentTimeMillis();
      this.I_field_dc0f3ba1 = IiiIiIII_Class105.I_method_f24c7cb();
      this.I_field_da5b4f81 = new IiiIIiiI_Class103();
      this.I_field_dc0f3f81 = new IiiIiIIi_Class106();
      this.I_field_dc0fb3c1 = new IiiIiIiI_Class107();
      this.I_field_bbd4b28c = new ButtonSetting(this, "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u043c\u0435\u043d\u044e")
         .I_method_f05556b3(() -> I_field_3a9bda27.setScreen(new IiiIIIiI_Class99()));
      this.i_field_bbd4b28c = new ButtonSetting(this, "\u041f\u0430\u0440\u0441\u0438\u0442\u044c \u0446\u0435\u043d\u044b")
         .I_method_f05556b3(this::iiI_method_23b7c65f);
      this.I_field_5fd3861f = Pattern.compile(
         "\u0412\u044b \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u043a\u0443\u043f\u0438\u043b\u0438\\s+(.+?)(?:\\s+x(\\d+))?\\s+\u0437\u0430\\s+\\$([\\d,]+)!",
         66
      );
      this.I_field_7865b31 = new ArrayList<>();
      this.I_field_a5728a07 = AutoBuyModule.Nested1_ea60dc80.I_field_a5728a07;
      this.I_field_3d936f41 = var1 -> {
         if (var1.getPacket() instanceof GameMessageS2CPacket var2) {
            String var13 = var2.content().getString();
            this.I_field_dc0f3f81.I_method_88cd4b96(var13);
            this.I_field_da5b4f81.I_method_9fad5b96(var13);
            if (var13.contains("\u0423 \u0412\u0430\u0441 \u043a\u0443\u043f\u0438\u043b\u0438")) {
               String var4 = var13.substring(var13.indexOf("\u043a\u0443\u043f\u0438\u043b\u0438") + "\u043a\u0443\u043f\u0438\u043b\u0438".length()).trim();
               this.I_method_7173b21c(var4)
                  .ifPresent(var0 -> IiiIIiIi_Class102.i_method_e710ee8d(var0.i_method_29f1a539(), Math.max(1, var0.I_method_18d43a5a())));
            }

            if (var13.contains("\u0412\u044b \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u043a\u0443\u043f\u0438\u043b\u0438")) {
               this.II_field_4a = System.currentTimeMillis();
               Matcher var14 = this.I_field_5fd3861f.matcher(var13);
               if (var14.find()) {
                  String var5 = var14.group(1).trim();
                  String var6 = var14.group(2);
                  String var7 = var14.group(3);
                  int var8 = var6 != null ? Integer.parseInt(var6) : 1;
                  long var9 = Long.parseLong(var7.replace(",", ""));
                  IiiIIiIi_Class102.Nested1_6cef9133 var11 = this.I_field_af10c59c != null ? this.I_field_af10c59c : this.I_method_7173b21c(var5).orElse(null);
                  this.I_field_af10c59c = null;
                  ItemStack var12 = var11 != null ? var11.I_method_2478c0b1() : ItemStack.EMPTY;
                  if (var11 != null) {
                     IiiIIiIi_Class102.I_method_a0ddc66d(var11.i_method_29f1a539(), var8);
                  }

                  this.I_field_7865b31.add(new AutoBuyModule.Nested1_ea60dca0(var5, var8, var9, var12));
                  if (this.I_field_7865b31.size() > 10) {
                     this.I_field_7865b31.removeFirst();
                  }
               }

               this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.i_field_8deb8c6;
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      };
      this.i_field_3d936f41 = var1 -> {
         if (I_field_3a9bda27.currentScreen instanceof HandledScreen var2 && IiiiiIIii_Class244.II_method_6da14e50(var2.getTitle().getString())) {
            III var4 = III.I_method_5728d20f(
               var1.getContext(),
               I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getX(),
               I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getY(),
               MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false)
            );
            this.I_method_b35985fd(var4);
         }
      };
   }

   private void ii_method_23a981d2(boolean var1) {
      if (!IiiIIiII_Class101.I_method_c495e4b0()) {
         if (this.I_field_a5728a07 == AutoBuyModule.Nested1_ea60dc80.i_field_a5728a07) {
            this.IiI_method_ed1cb27f();
         }
      } else if (!var1) {
         if (this.I_field_a5728a07 == AutoBuyModule.Nested1_ea60dc80.I_field_a5728a07) {
            if (this.IiI_method_ed1cb283() && this.I_field_dc0f3f81.i_method_87a7c8b0()) {
               this.I_field_a5728a07 = AutoBuyModule.Nested1_ea60dc80.i_field_a5728a07;
               this.iII_method_21f4d63f();
            }
         } else {
            if (!this.I_field_dc0f3f81.i_method_87a7c8b0()) {
               this.IiI_method_ed1cb27f();
            }
         }
      }
   }

   private void IiI_method_ed1cb27f() {
      this.I_field_a5728a07 = AutoBuyModule.Nested1_ea60dc80.I_field_a5728a07;
      this.II_field_4a = System.currentTimeMillis();
      this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.i_field_8deb8c6;
      this.i_field_991c1e8c.I_method_23e11e3f();
   }

   private void Iii_method_ed2b3e5f() {
      for (IiiIIiIi_Class102.Nested1_6cef9133 var2 : IiiIIiIi_Class102.I_method_2a0b303b()) {
         if (var2.I_method_b49c50b() == IiiIIiIi_Class102.Nested1_6cef9113.i_field_af10c1bc
            && !(this.I_field_dc0f3ba1.I_method_89b6fa4(var2.i_method_29f1a539()) > 0.0)) {
            iIIIIIIii_Class260.i_method_70898627(
               Text.of(
                  IiiIIiIi_Class102.I_method_dcb516f8(var2)
                     + ": \u043d\u0435\u0442 \u0446\u0435\u043d\u044b \u0440\u044b\u043d\u043a\u0430 \u2014 \u00ab\u043d\u0438\u0436\u0435 \u0440\u044b\u043d\u043a\u0430\u00bb \u043d\u0435 \u0441\u0440\u0430\u0431\u043e\u0442\u0430\u0435\u0442, \u0441\u043f\u0430\u0440\u0441\u0438 \u0446\u0435\u043d\u044b"
               )
            );
         }
      }
   }

   private void iII_method_21f4d63f() {
      for (IiiIIiIi_Class102.Nested1_6cef9133 var2 : IiiIIiIi_Class102.I_method_2a0b303b()) {
         if (var2.i_method_18e2c63b() <= 0L
            && !(this.I_field_dc0f3ba1.I_method_89b6fa4(var2.i_method_29f1a539()) > 0.0)
            && IiiIIiIi_Class102.I_method_81b5829b(var2) > 0) {
            iIIIIIIii_Class260.i_method_70898627(
               Text.of(
                  IiiIIiIi_Class102.I_method_dcb516f8(var2)
                     + ": \u043d\u0435\u0442 \u0446\u0435\u043d\u044b \u043f\u0440\u043e\u0434\u0430\u0436\u0438 \u2014 \u0441\u043f\u0430\u0440\u0441\u0438 \u0446\u0435\u043d\u044b \u0438\u043b\u0438 \u0437\u0430\u0434\u0430\u0439 \u00ab\u0426\u0435\u043d\u0430 \u043f\u0440\u043e\u0434\u0430\u0436\u0438\u00bb"
               )
            );
         }
      }
   }

   private Optional<IiiIIiIi_Class102.Nested1_6cef9133> I_method_7173b21c(String var1) {
      String var2 = var1 == null ? "" : var1.trim();
      return var2.isEmpty()
         ? Optional.empty()
         : IiiIIiIi_Class102.I_method_2a0b303b()
            .stream()
            .filter(
               var1x -> var1x.I_method_96d2f519() != null
                  ? I_method_daffbb97(var1x.I_method_96d2f519(), var2)
                  : I_method_daffbb97(Iiiiiiiii_Class256.i_method_524c3f7f(var1x.I_method_2478c0b1()), var2)
                     || I_method_daffbb97(Iiiiiiiii_Class256.I_method_e0e8875f(var1x.I_method_2478c0b1()), var2)
            )
            .findFirst();
   }

   private static boolean I_method_daffbb97(String var0, String var1) {
      String var2 = var0 == null ? "" : var0.trim();
      return var2.isEmpty() ? false : var2.equalsIgnoreCase(var1) || var1.contains(var2) || var2.contains(var1);
   }

   private boolean IiI_method_ed1cb283() {
      List var1 = IiiIIiIi_Class102.I_method_2a0b303b();
      if (var1.isEmpty()) {
         return true;
      } else {
         for (IiiIIiIi_Class102.Nested1_6cef9133 var3 : (Iterable<IiiIIiIi_Class102.Nested1_6cef9133>)(Iterable<?>)var1) {
            if (!IiiIIiIi_Class102.I_method_81b582ac(var3)) {
               return System.currentTimeMillis() - this.II_field_4a >= 90000L;
            }
         }

         return true;
      }
   }

   private void iIi_method_2203621f() {
      if (this.I_field_da5b4f81.I_method_6bd1bfc6() != IiiIIiiI_Class103.Nested1_6cfda4d3.II_field_b0c525fc) {
         if (I_field_3a9bda27.currentScreen == null || I_field_3a9bda27.currentScreen instanceof HandledScreen) {
            if (this.i_field_991c1e8c.I_method_58432069(3000L)) {
               I_field_3a9bda27.player.networkHandler.sendChatCommand("ah");
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void iiI_method_23b7c65f() {
      if (this.I_field_dc0f3ba1.II_method_ced5ebf9()) {
         this.I_field_da5b4f81.I_method_ca4cff88(true);
      }
   }

   @Override
   public void II_method_6642fd22() {
      boolean var1 = this.I_field_dc0f3ba1.I_method_50fe28f0();
      this.ii_method_23a981d2(var1);
      boolean var2 = this.I_field_a5728a07 == AutoBuyModule.Nested1_ea60dc80.i_field_a5728a07;
      boolean var3 = var2 || var1;
      if (var3 != this.I_field_da5b4f81.I_method_615d4cd0()) {
         this.I_field_da5b4f81.I_method_ca4cff88(var3);
      }

      if (var2) {
         this.I_field_dc0f3f81.i_method_87a7c8ac();
      } else if (!var1) {
         if (this.I_field_dc0f3ba1.i_method_510cb4d0()) {
            this.Iii_method_ed2b3e5f();
            this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.i_field_8deb8c6;
            this.I_field_991c1e8c.I_method_23e11e3f();
            this.i_field_991c1e8c.I_method_23e11e3f();
         } else if (this.I_field_dc0f3ba1.Ii_method_cee477d9()) {
            this.I_field_da5b4f81.I_method_ca4cff88(true);
         } else {
            this.I_field_da5b4f81.I_method_615d4ccc();
            if (I_field_3a9bda27.currentScreen instanceof HandledScreen var4 && IiiiiIIii_Class244.II_method_6da14e50(var4.getTitle().getString())) {
               this.i_field_991c1e8c.I_method_23e11e3f();
               long var21 = (long)(
                  I_field_3a9bda27.player.networkHandler.getPlayerListEntry(I_field_3a9bda27.player.getUuid()).getLatency() * 2.5F
                     + iIIiiiiiI_Class319.I_method_b56b22f(24.0, 59.0)
               );
               IiiiiIIii_Class244.Nested1_93558060 var7 = IiiiiIIii_Class244.I_method_d5e31775(var4, false, null);
               IiiiiIIii_Class244.Nested1_93558040 var8 = null;

               for (IiiiiIIii_Class244.Nested1_93558040 var10 : var7.I_method_b92233ad()) {
                  long var11 = var10.I_method_15faab6e();
                  int var13 = Math.max(1, var10.i_method_1609374d());
                  long var14 = var11 / var13;
                  double var16 = var10.I_method_15faab68() / var13;
                  double var18 = this.I_field_dc0f3ba1.I_method_d70df8b().I_method_4c1122c3(var10);
                  if (this.I_field_dc0fb3c1.I_method_caed073c(var11)) {
                     IiiiiIIii_Class244.Nested1_93558040 var20 = new IiiiiIIii_Class244.Nested1_93558040(
                        var10.I_method_15faab6d(), var10.I_method_5a4ac7e(), var14, var13, var10.II_method_a969bb1a(), var10.Ii_method_a97846fa(), var16
                     );
                     if (IiiIIiIi_Class102.I_method_c11927ed(var20, var18) && (var8 == null || var20.I_method_15faab68() < var8.I_method_15faab68())) {
                        var8 = var20;
                     }
                  }
               }

               switch (this.I_field_8deb8c6) {
                  case I_field_8deb8c6:
                  default:
                     break;
                  case i_field_8deb8c6:
                     this.I_method_29206e9c(var4, var21, var8);
                     break;
                  case II_field_8deb8c6:
                     this.i_method_74834a7c(var4, var21, var8);
               }
            } else {
               this.iIi_method_2203621f();
            }
         }
      }
   }

   private void I_method_29206e9c(HandledScreen<?> var1, long var2, IiiiiIIii_Class244.Nested1_93558040 var4) {
      if (var4 != null) {
         this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.II_field_8deb8c6;
         this.I_field_991c1e8c.I_method_23e11e3f();
      } else {
         if (this.I_field_991c1e8c.I_method_58432069(var2 + 200L)) {
            I_field_3a9bda27.interactionManager.clickSlot(var1.getScreenHandler().syncId, 49, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void i_method_74834a7c(HandledScreen<?> var1, long var2, IiiiiIIii_Class244.Nested1_93558040 var4) {
      if (var4 == null) {
         this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.i_field_8deb8c6;
         this.I_field_991c1e8c.I_method_23e11e3f();
      } else if (!IiiIIiIi_Class102.I_method_c11927ed(var4, this.I_field_dc0f3ba1.I_method_d70df8b().I_method_4c1122c3(var4))) {
         this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.i_field_8deb8c6;
         this.I_field_991c1e8c.I_method_23e11e3f();
      } else if (!this.I_field_dc0fb3c1.I_method_caed073c(var4.I_method_15faab6e() * Math.max(1, var4.i_method_1609374d()))) {
         this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.i_field_8deb8c6;
         this.I_field_991c1e8c.I_method_23e11e3f();
      } else {
         if (this.I_field_991c1e8c.I_method_58432069(var2)) {
            this.I_field_af10c59c = IiiIIiIi_Class102.I_method_954f1204(var4.I_method_5a4ac7e());
            I_field_3a9bda27.interactionManager
               .clickSlot(var1.getScreenHandler().syncId, var4.I_method_15faab6d(), 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
            this.I_field_991c1e8c.I_method_23e11e3f();
            this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.i_field_8deb8c6;
         }
      }
   }

   private void I_method_b35985fd(CustomDrawContext var1) {
      List var2 = this.I_method_96b5a68();
      short var3 = 270;
      int var4 = (int)(I_field_73c6d26c.i_method_805d6def() / 2.0F) - 105;
      byte var5 = 16;
      var1.drawClientRect(var3, var4 - 5, 120.0F, var2.size() * 20 + 8, 255.0F, 1.0F, 7.0F, 6.0F);
      byte var6 = 0;

      for (AutoBuyModule.Nested1_ea60dca0 var8 : (Iterable<AutoBuyModule.Nested1_ea60dca0>)(Iterable<?>)var2) {
         var1.drawItem(var8.I_method_5020f0de(), (float)(var3 + 4), (float)(var4 + var6), 1.0F);
         var1.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), Text.of(var8.I_method_188840c6()), var3 + var5 + 6, var4 + var6 + 2);
         var1.drawText(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
            Text.of(iIIiiiiiI_Class319.I_method_10212adb(var8.I_method_f7a0b0e()) + " x" + var8.I_method_f7a0b0d()),
            var3 + var5 + 6,
            var4 + var6 + 10
         );
         var6 += 20;
      }
   }

   @Override
   public void onEnable() {
      this.I_field_dc0f3f81.I_method_4e8f29ef(var1 -> (long)this.I_field_dc0f3ba1.I_method_89b6fa4(var1.i_method_29f1a539()));
      this.II_field_4a = System.currentTimeMillis();
      this.i_field_991c1e8c.I_method_23e11e3f();
      this.I_field_a5728a07 = AutoBuyModule.Nested1_ea60dc80.I_field_a5728a07;
      this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.i_field_8deb8c6;
      this.Iii_method_ed2b3e5f();
      this.I_field_da5b4f81.II_method_ca5b4415();
      super.onEnable();
   }

   @Override
   public void onDisable() {
      this.I_field_da5b4f81.i_method_616bd8ac();
      this.I_field_dc0f3f81.I_method_87993ccc();
      this.I_field_dc0fb3c1.I_method_edc5910c();
      IiiIIiIi_Class102.i_method_fb3f846c();
      this.I_field_af10c59c = null;
      this.I_field_a5728a07 = AutoBuyModule.Nested1_ea60dc80.I_field_a5728a07;
      this.I_field_8deb8c6 = AutoBuyModule.Nested1_61bab3c9.I_field_8deb8c6;
      super.onDisable();
   }

   @Generated
   public List<AutoBuyModule.Nested1_ea60dca0> I_method_96b5a68() {
      return this.I_field_7865b31;
   }

   static enum Nested1_61bab3c9 {
      I_field_8deb8c6,
      i_field_8deb8c6,
      II_field_8deb8c6;
   }

   static enum Nested1_ea60dc80 {
      I_field_a5728a07,
      i_field_a5728a07;
   }

   public static final class Nested1_ea60dca0 {
      private final String I_field_523beb0a;
      private final int I_field_49;
      private final long I_field_4a;
      private final ItemStack I_field_f2735522;

      public Nested1_ea60dca0(String var1, int var2, long var3, ItemStack var5) {
         this.I_field_523beb0a = var1;
         this.I_field_49 = var2;
         this.I_field_4a = var3;
         this.I_field_f2735522 = var5;
      }

      @Override
      public final String toString() {
         return "Nested1_ea60dca0[name=" + this.I_field_523beb0a + ", amount=" + this.I_field_49 + ", price=" + this.I_field_4a + ", stack=" + this.I_field_f2735522 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         AutoBuyModule.Nested1_ea60dca0 other = (AutoBuyModule.Nested1_ea60dca0) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522);
      }

      public String I_method_188840c6() {
         return this.I_field_523beb0a;
      }

      public int I_method_f7a0b0d() {
         return this.I_field_49;
      }

      public long I_method_f7a0b0e() {
         return this.I_field_4a;
      }

      public ItemStack I_method_5020f0de() {
         return this.I_field_f2735522;
      }
   }
}
