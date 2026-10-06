package rockstar.client;

import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class IiiIiIIi_Class106 implements iIIiIIiIi_Class294 {
   private static final long I_field_4a = 5000L;
   private static final long i_field_4a = 8000L;
   private static final long II_field_4a = 900L;
   private static final int I_field_49 = 3;
   private static final long Ii_field_4a = 60000L;
   private static final String I_field_523beb0a = "\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435";
   private ToLongFunction<IiiIIiIi_Class102.Nested1_6cef9133> I_field_c687f0c1 = var0 -> 0L;
   private IiiIiIIi_Class106.Nested1_a1c7b4d3 I_field_153d15fc;
   private IiiIIiIi_Class102.Nested1_6cef9133 I_field_af10c59c;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private int i_field_49;
   private int II_field_49;
   private boolean II_field_5a;
   private boolean Ii_field_5a;
   private long iI_field_4a;
   private long ii_field_4a;
   private long III_field_4a;
   private long IIi_field_4a;
   private static final Pattern I_field_5fd3861f = Pattern.compile("\\$([\\d.,]+)");

   public IiiIiIIi_Class106() {
      this.I_field_153d15fc = IiiIiIIi_Class106.Nested1_a1c7b4d3.I_field_153d15fc;
      this.IIi_field_4a = System.currentTimeMillis();
   }

   public void I_method_4e8f29ef(ToLongFunction<IiiIIiIi_Class102.Nested1_6cef9133> var1) {
      if (var1 != null) {
         this.I_field_c687f0c1 = var1;
      }
   }

   public boolean I_method_87993cd0() {
      return this.I_field_153d15fc != IiiIiIIi_Class106.Nested1_a1c7b4d3.I_field_153d15fc;
   }

   public boolean i_method_87a7c8b0() {
      return this.I_method_87993cd0() || this.I_method_2deb6f66() != null || this.II_method_6b9d5419();
   }

   private boolean II_method_6b9d5419() {
      return this.II_field_5a && System.currentTimeMillis() - this.IIi_field_4a >= 60000L;
   }

   public void I_method_87993ccc() {
      this.IiI_method_9df160c();
      this.I_field_af10c59c = null;
      this.i_field_5a = false;
      this.Ii_field_5a = false;
      this.II_field_5a = false;
      this.II_field_49 = 0;
      this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.I_field_153d15fc);
   }

   public void i_method_87a7c8ac() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && I_field_3a9bda27.interactionManager != null) {
         try {
            this.II_method_6b9d5415();
         } catch (Exception var2) {
            this.I_method_87993ccc();
         }
      }
   }

   private void II_method_6b9d5415() {
      switch (this.I_field_153d15fc) {
         case I_field_153d15fc:
            IiiIIiIi_Class102.Nested1_6cef9133 var3 = this.I_method_2deb6f66();
            if (var3 != null) {
               this.I_field_af10c59c = var3;
               this.i_field_5a = false;
               this.IiI_method_9df160c();
               this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.i_field_153d15fc);
               return;
            }

            if (this.II_method_6b9d5419()) {
               this.IIi_field_4a = this.II_method_6b9d5409();
               this.Ii_field_5a = true;
               this.I_field_af10c59c = null;
               this.i_field_5a = false;
               this.IiI_method_9df160c();
               this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.III_field_153d15fc);
               return;
            }

            this.Ii_field_5a = false;
            this.I_field_af10c59c = null;
            break;
         case i_field_153d15fc:
            if (!this.I_method_6b8ed37c(this.i_method_87a7c8a0())) {
               return;
            }

            if (this.I_method_6ec8e6db(this.I_field_af10c59c) <= 0) {
               if (this.i_field_5a) {
                  this.ii_field_4a = this.II_method_6b9d5409();
                  this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.ii_field_153d15fc);
               } else {
                  this.IIi_method_82ab1cc();
               }

               return;
            }

            if (!this.I_method_88cd4b9a("ah sellgui " + this.I_method_87993cc0())) {
               return;
            }

            this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.II_field_153d15fc);
            break;
         case II_field_153d15fc:
            if (this.I_method_1f51b3ea() != null) {
               this.II_field_49 = 0;
               this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.Ii_field_153d15fc);
            } else if (this.I_method_6b8ed37c(5000L)) {
               if (++this.II_field_49 <= 3) {
                  this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.i_field_153d15fc);
               } else {
                  this.II_field_49 = 0;
                  this.ii_field_4a = this.II_method_6b9d5409();
                  this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.ii_field_153d15fc);
               }
            }
            break;
         case Ii_field_153d15fc:
            this.Ii_method_6babdff5();
            break;
         case iI_field_153d15fc:
            this.iI_method_6d604435();
            break;
         case ii_field_153d15fc:
            if (this.I_field_5a) {
               this.I_field_5a = false;
               this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.i_field_153d15fc);
            } else if (this.II_method_6b9d5409() - this.ii_field_4a >= 8000L) {
               this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.III_field_153d15fc);
            }
            break;
         case III_field_153d15fc:
            if (!this.I_method_6b8ed37c(this.i_method_87a7c8a0())) {
               return;
            }

            if (!this.I_method_88cd4b9a("ah")) {
               return;
            }

            this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.IIi_field_153d15fc);
            break;
         case IIi_field_153d15fc:
            HandledScreen var1 = this.I_method_1f51b3ea();
            if (var1 != null) {
               int var2 = this.I_method_663763c9(var1.getScreenHandler(), "\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435");
               if (var2 != -1) {
                  if (this.I_method_6b8ed37c(this.i_method_87a7c8a0())) {
                     I_field_3a9bda27.interactionManager.clickSlot(var1.getScreenHandler().syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
                     this.i_field_49 = 0;
                     this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.IiI_field_153d15fc);
                  }
               } else if (this.I_method_6b8ed37c(5000L)) {
                  this.III_method_81c25ec();
               }
            } else if (this.I_method_6b8ed37c(5000L)) {
               this.III_method_81c25ec();
            }
            break;
         case IiI_field_153d15fc:
            this.ii_method_6d6ed015();
      }
   }

   private void Ii_method_6babdff5() {
      HandledScreen var1 = this.I_method_1f51b3ea();
      if (var1 == null) {
         this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.i_field_153d15fc);
      } else if (this.I_method_6b8ed37c(this.i_method_87a7c8a0())) {
         ScreenHandler var2 = var1.getScreenHandler();
         int var3 = this.I_method_f04e4ff(var2);
         if (var3 != -1 && this.II_method_efe4cbc8(var2) != -1) {
            this.I_method_616e326c(var2, var3, Math.max(1, this.I_field_af10c59c.I_method_18d43a5a()));
            this.Iii_method_9eda1ec();
         } else {
            this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.iI_field_153d15fc);
         }
      }
   }

   private void I_method_616e326c(ScreenHandler var1, int var2, int var3) {
      int var4 = var3;

      for (int var5 = var3 + 64; var4 > 0 && var5-- > 0; var4--) {
         ItemStack var6 = var1.getCursorStack();
         if (!this.I_method_7b4ce932(var6)) {
            int var7 = this.II_method_efe4cbc8(var1);
            if (var7 == -1) {
               break;
            }

            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var7, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
            var6 = var1.getCursorStack();
            if (var6.isEmpty()) {
               break;
            }
         }

         I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 1, SlotActionType.PICKUP, I_field_3a9bda27.player);
      }

      if (!var1.getCursorStack().isEmpty()) {
         int var9 = this.i_method_f2c300df(var1);
         if (var9 == -1) {
            var9 = this.II_method_efe4cbc8(var1);
         }

         if (var9 != -1) {
            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var9, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
         }
      }
   }

   private void iI_method_6d604435() {
      HandledScreen var1 = this.I_method_1f51b3ea();
      if (var1 == null) {
         this.i_field_5a = true;
         this.II_field_5a = true;
         this.ii_field_4a = this.II_method_6b9d5409();
         this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.ii_field_153d15fc);
      } else if (this.I_method_6b8ed37c(this.i_method_87a7c8a0())) {
         int var2 = this.I_method_1f64c7ed(var1.getScreenHandler(), Items.LIME_DYE);
         if (var2 != -1) {
            I_field_3a9bda27.interactionManager.clickSlot(var1.getScreenHandler().syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
            this.i_field_5a = true;
            this.II_field_5a = true;
            this.IiI_method_9df160c();
            this.ii_field_4a = this.II_method_6b9d5409();
            this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.ii_field_153d15fc);
         } else if (this.I_method_6b8ed37c(5000L)) {
            this.i_field_5a = true;
            this.II_field_5a = true;
            this.IiI_method_9df160c();
            this.ii_field_4a = this.II_method_6b9d5409();
            this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.ii_field_153d15fc);
         }
      }
   }

   private void ii_method_6d6ed015() {
      HandledScreen var1 = this.I_method_1f51b3ea();
      if (var1 == null) {
         this.I_method_fb229f48(
            this.I_field_af10c59c == null ? IiiIiIIi_Class106.Nested1_a1c7b4d3.I_field_153d15fc : IiiIiIIi_Class106.Nested1_a1c7b4d3.i_field_153d15fc
         );
      } else if (this.I_method_6b8ed37c(this.i_method_87a7c8a0())) {
         int var2 = this.Ii_method_d3a2e7a8(var1.getScreenHandler());
         if (var2 != -1) {
            I_field_3a9bda27.interactionManager.clickSlot(var1.getScreenHandler().syncId, var2, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
            this.i_field_49++;
            this.Iii_method_9eda1ec();
         } else {
            this.IiI_method_9df160c();
            if (this.I_field_af10c59c == null) {
               this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.I_field_153d15fc);
            } else if (this.i_field_49 == 0 && this.I_method_6ec8e6db(this.I_field_af10c59c) <= 0) {
               this.IIi_method_82ab1cc();
            } else {
               this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.i_field_153d15fc);
            }
         }
      }
   }

   private void III_method_81c25ec() {
      if (this.I_field_af10c59c != null) {
         this.ii_field_4a = this.II_method_6b9d5409();
         this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.ii_field_153d15fc);
      } else {
         this.IIi_method_82ab1cc();
      }
   }

   private void IIi_method_82ab1cc() {
      this.I_field_af10c59c = null;
      this.i_field_5a = false;
      this.I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3.I_field_153d15fc);
   }

   private IiiIIiIi_Class102.Nested1_6cef9133 I_method_2deb6f66() {
      for (IiiIIiIi_Class102.Nested1_6cef9133 var2 : IiiIIiIi_Class102.I_method_2a0b303b()) {
         int var3 = this.Ii_field_5a ? 1 : var2.i_method_18e2c63a();
         if (this.I_method_6ec8e6dc(var2) > 0L && this.I_method_6ec8e6db(var2) >= var3) {
            return var2;
         }
      }

      return null;
   }

   private long I_method_87993cc0() {
      return Math.max(1L, this.I_method_6ec8e6dc(this.I_field_af10c59c));
   }

   private long I_method_6ec8e6dc(IiiIIiIi_Class102.Nested1_6cef9133 var1) {
      if (var1 == null) {
         return 0L;
      } else if (var1.i_method_18e2c63b() > 0L) {
         return var1.i_method_18e2c63b();
      } else {
         long var2 = this.I_field_c687f0c1.applyAsLong(var1);
         return var2 > 0L ? var2 : 0L;
      }
   }

   public void I_method_88cd4b96(String var1) {
      if (var1.contains("\u0423 \u0412\u0430\u0441 \u043a\u0443\u043f\u0438\u043b\u0438")) {
         this.I_field_5a = true;
      } else if (var1.contains("\u0441\u043b\u0438\u0448\u043a\u043e\u043c \u0434\u043e\u0440\u043e\u0433\u043e")) {
         this.IIi_method_82ab1cc();
      }
   }

   private boolean I_method_7b4ce932(ItemStack var1) {
      if (var1 == null || var1.isEmpty()) {
         return false;
      } else {
         return this.I_field_af10c59c == null
            ? IiiIIiIi_Class102.I_method_954f1204(var1) != null
            : IiiIIiIi_Class102.I_method_f3d9980e(var1, this.I_field_af10c59c);
      }
   }

   private int I_method_6ec8e6db(IiiIIiIi_Class102.Nested1_6cef9133 var1) {
      PlayerInventory var2 = I_field_3a9bda27.player.getInventory();
      int var3 = 0;

      for (int var4 = 0; var4 < var2.size(); var4++) {
         ItemStack var5 = var2.getStack(var4);
         if (IiiIIiIi_Class102.I_method_f3d9980e(var5, var1)) {
            var3 += var5.getCount();
         }
      }

      return var3;
   }

   private int I_method_f04e4ff(ScreenHandler var1) {
      for (Slot var3 : var1.slots) {
         if (var3.inventory != I_field_3a9bda27.player.getInventory() && !var3.hasStack()) {
            return var3.id;
         }
      }

      return -1;
   }

   private int i_method_f2c300df(ScreenHandler var1) {
      for (Slot var3 : var1.slots) {
         if (var3.inventory == I_field_3a9bda27.player.getInventory() && !var3.hasStack()) {
            return var3.id;
         }
      }

      return -1;
   }

   private int II_method_efe4cbc8(ScreenHandler var1) {
      for (Slot var3 : var1.slots) {
         if (var3.inventory == I_field_3a9bda27.player.getInventory() && this.I_method_7b4ce932(var3.getStack())) {
            return var3.id;
         }
      }

      return -1;
   }

   private int Ii_method_d3a2e7a8(ScreenHandler var1) {
      for (Slot var3 : var1.slots) {
         if (var3.inventory != I_field_3a9bda27.player.getInventory() && this.I_method_7b4ce932(var3.getStack())) {
            return var3.id;
         }
      }

      return -1;
   }

   private int I_method_1f64c7ed(ScreenHandler var1, Item var2) {
      for (Slot var4 : var1.slots) {
         if (var4.inventory != I_field_3a9bda27.player.getInventory() && var4.getStack().isOf(var2)) {
            return var4.id;
         }
      }

      return -1;
   }

   private int I_method_663763c9(ScreenHandler var1, String var2) {
      for (Slot var4 : var1.slots) {
         if (var4.inventory != I_field_3a9bda27.player.getInventory() && var4.hasStack() && var4.getStack().getName().getString().contains(var2)) {
            return var4.id;
         }
      }

      return -1;
   }

   private HandledScreen<?> I_method_1f51b3ea() {
      return I_field_3a9bda27.currentScreen instanceof HandledScreen var1 ? var1 : null;
   }

   private void IiI_method_9df160c() {
      if (I_field_3a9bda27.currentScreen != null && I_field_3a9bda27.player != null) {
         I_field_3a9bda27.player.closeHandledScreen();
      }
   }

   private boolean I_method_88cd4b9a(String var1) {
      if (this.II_method_6b9d5409() - this.III_field_4a < 900L) {
         return false;
      } else {
         this.IiI_method_9df160c();
         I_field_3a9bda27.player.networkHandler.sendChatCommand(var1);
         this.III_field_4a = this.II_method_6b9d5409();
         return true;
      }
   }

   private long i_method_87a7c8a0() {
      return (long)(
         I_field_3a9bda27.player.networkHandler.getPlayerListEntry(I_field_3a9bda27.player.getUuid()).getLatency() * 2.5F
            + iIIiiiiiI_Class319.I_method_b56b22f(24.0, 59.0)
      );
   }

   private long II_method_6b9d5409() {
      return System.currentTimeMillis();
   }

   private boolean I_method_6b8ed37c(long var1) {
      return this.II_method_6b9d5409() - this.iI_field_4a >= var1;
   }

   private void Iii_method_9eda1ec() {
      this.iI_field_4a = this.II_method_6b9d5409();
   }

   private void I_method_fb229f48(IiiIiIIi_Class106.Nested1_a1c7b4d3 var1) {
      this.I_field_153d15fc = var1;
      this.Iii_method_9eda1ec();
   }

   private static long I_method_88cd4b8a(String var0) {
      Matcher var1 = I_field_5fd3861f.matcher(var0);
      if (var1.find()) {
         String var2 = var1.group(1).replaceAll("[^\\d]", "");
         if (!var2.isEmpty()) {
            try {
               return Long.parseLong(var2);
            } catch (NumberFormatException var4) {
               return 0L;
            }
         }
      }

      return 0L;
   }

   private boolean Ii_method_6babdff9() {
      HandledScreen var1 = this.I_method_1f51b3ea();
      return var1 != null && IiiiiIIii_Class244.II_method_6da14e50(var1.getTitle().getString());
   }

   @Generated
   public IiiIiIIi_Class106.Nested1_a1c7b4d3 I_method_9417bfc6() {
      return this.I_field_153d15fc;
   }

   static enum Nested1_a1c7b4d3 {
      I_field_153d15fc,
      i_field_153d15fc,
      II_field_153d15fc,
      Ii_field_153d15fc,
      iI_field_153d15fc,
      ii_field_153d15fc,
      III_field_153d15fc,
      IIi_field_153d15fc,
      IiI_field_153d15fc;
   }
}
