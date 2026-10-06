package rockstar.client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lombok.Generated;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.screen.slot.SlotActionType;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.InputEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Gui Move",
   category = ModuleCategory.PLAYER,
   iI_method_476ab839 = true
)
public class GuiMoveModule extends Module {
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private ModeSetting.Nested1_42765c60 iI_field_500d0627;
   private final List<Packet<?>> I_field_7865b31 = new ArrayList<>();
   private int i_field_49;
   private boolean i_field_5a;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private int II_field_49;
   private boolean II_field_5a;
   private boolean Ii_field_5a;
   private boolean iI_field_5a;
   private int Ii_field_49;
   private boolean ii_field_5a;
   private boolean III_field_5a;
   public int I_field_49;
   public boolean I_field_5a;
   private final Queue<ClickSlotC2SPacket> I_field_f2700bf6 = new LinkedList<>();
   private final IiIIIiII_Class69<SendPacketEvent> I_field_3d936f41 = var1 -> {
      if (!this.Ii_field_5a) {
         if (this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627) && var1.getPacket() instanceof ClickSlotC2SPacket var6) {
            if (!this.I_field_5a && this.Iiii_method_c523b846() && var6.getSlot() != -1) {
               this.I_method_13e0ff7e(var6.getActionType());
               if (!this.ii_field_5a && this.I_method_a023834e(var6)) {
                  this.I_field_49 = 0;
                  this.iI_field_5a = true;
                  this.I_field_991c1e8c.I_method_23e11e3f();
                  var1.cancel();
               }
            }
         } else {
            if (var1.getPacket() instanceof ClickSlotC2SPacket var2) {
               if (!this.IiIi_method_c360c826()) {
                  return;
               }

               if (this.I_field_5a) {
                  return;
               }

               if (I_field_3a9bda27.currentScreen == null) {
                  this.I_field_7865b31.add(var2);
                  var1.cancel();
                  this.i_field_5a = true;
                  if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
                     this.I_field_991c1e8c.I_method_23e11e3f();
                  } else if (this.IiiI_method_c5152c66()) {
                     this.II_field_49 = 2;
                     this.II_field_5a = true;
                     this.I_field_991c1e8c.I_method_23e11e3f();
                  } else if (this.Ii_field_500d0627.isSelected()) {
                     this.iI_field_5a = true;
                  } else {
                     this.i_field_49 = 3;
                  }
               }

               if (I_field_3a9bda27.currentScreen instanceof InventoryScreen && IiiiiiiII_Class253.I_method_1cb61e43()) {
                  this.I_field_7865b31.add(var2);
                  var1.cancel();
               }

               if (var2.getStack().getItem() instanceof BlockItem var8
                  && var8.getBlock() instanceof ShulkerBoxBlock
                  && iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iII_field_ac164e6c)) {
                  I_field_3a9bda27.player.currentScreenHandler.setCursorStack(ItemStack.EMPTY);
               }
            }

            if (var1.getPacket() instanceof CloseHandledScreenC2SPacket) {
               if (!this.IiIi_method_c360c826()) {
                  return;
               }

               if (this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627)) {
                  return;
               }

               boolean var5 = IiiiiiiII_Class253.I_method_1cb61e43();
               if (var5) {
                  if (!this.I_field_7865b31.isEmpty()) {
                     this.i_field_5a = true;
                     if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
                        this.I_field_991c1e8c.I_method_23e11e3f();
                     } else if (this.IiiI_method_c5152c66()) {
                        this.II_field_49 = 2;
                        this.II_field_5a = true;
                        this.I_field_991c1e8c.I_method_23e11e3f();
                     } else {
                        this.i_field_49 = 3;
                     }
                  }

                  var1.cancel();
               }
            }
         }
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41 = var1 -> {
      if ((this.IiI_method_d4c01b03() || this.Iii_method_d4cea6e3())
         && this.iI_field_5a
         && !this.I_field_991c1e8c.I_method_58432069(2000L)
         && (var1.getPacket() instanceof ScreenHandlerSlotUpdateS2CPacket || var1.getPacket() instanceof InventoryS2CPacket)) {
         this.iI_field_5a = false;
         var1.cancel();
      }
   };
   private final IiIIIiII_Class69<InputEvent> II_field_3d936f41 = var1 -> {
      if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627) && !this.I_field_991c1e8c.I_method_58432069(190L)) {
         var1.setForward(0.0F);
         var1.setStrafe(0.0F);
         var1.setJump(false);
         var1.setSneak(false);
         var1.setSprint(false);
      }

      if (this.IiiI_method_c5152c66() && this.II_field_49 > 0 && !this.I_field_991c1e8c.I_method_58432069(195L)) {
         var1.setForward(0.0F);
         var1.setStrafe(0.0F);
         var1.setJump(false);
         var1.setSneak(false);
         var1.setSprint(false);
      }

      if (this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627) && this.ii_field_5a) {
         var1.setForward(0.0F);
         var1.setStrafe(0.0F);
         var1.setJump(false);
         var1.setSneak(false);
         var1.setSprint(false);
      }
   };
   private final IiIIIiII_Class69<ClientPlayerTickEvent> Ii_field_3d936f41 = var1 -> {
      if (this.i_field_49 > 0) {
         this.i_field_49--;
      }

      if (this.II_field_49 > 0) {
         this.II_field_49--;
      }

      if (this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627)) {
         if (this.III_field_5a && this.ii_field_5a && this.Ii_field_49 > 0) {
            this.iiI_method_b5b2edf();
         }

         this.III_field_5a = this.ii_field_5a;
         if (this.iIII_method_297e9086()) {
            this.I_method_13e0ff7e(null);
         } else if (this.Ii_field_49 > 0) {
            this.Ii_field_49--;
         }

         this.ii_field_5a = this.Ii_field_49 > 0;
         this.I_field_49++;
         if (this.ii_field_5a) {
            this.I_field_49 = 0;
         }
      }

      if (!this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627) || this.I_field_991c1e8c.I_method_58432069(100L)) {
         if (!this.IiiI_method_c5152c66()
            || this.II_field_49 <= 0
            || this.I_field_991c1e8c.I_method_58432069(iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) ? 120L : 99L)) {
            if (!this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627) || !this.ii_field_5a) {
               if (this.I_field_500d0627.isSelected()
                  || this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627)
                  || I_field_3a9bda27.currentScreen == null
                  || I_field_3a9bda27.currentScreen instanceof InventoryScreen
                  || I_field_3a9bda27.currentScreen instanceof CreativeInventoryScreen) {
                  iII_method_9983ebf();
                  if (this.i_field_5a && this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
                     I_field_3a9bda27.setScreen(new InventoryScreen(I_field_3a9bda27.player));
                     this.iii_method_b69babf();
                     this.i_field_5a = false;
                     I_field_3a9bda27.setScreen(null);
                  }

                  if (this.II_field_5a && this.IiiI_method_c5152c66() && this.II_field_49 == 0) {
                     this.iii_method_b69babf();
                     this.II_field_5a = false;
                     this.i_field_5a = false;
                  }
               }
            }
         }
      }
   };

   public GuiMoveModule() {
      this.iIi_method_9a6ca9f();
   }

   @Compile(
      obfuscation = 4
   )
   private void iIi_method_9a6ca9f() {
      this.I_field_bbe33e6c = new ModeSetting(this, "\u041e\u0431\u0445\u043e\u0434");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "Vanilla").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "Lony/Cake");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "HW&RW");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "FunTime");
      this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "SpookyTime");
   }

   private boolean IiIi_method_c360c826() {
      return this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)
         || this.IiiI_method_c5152c66()
         || this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627);
   }

   private boolean IiiI_method_c5152c66() {
      return this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627) || this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627);
   }

   public boolean IiI_method_d4c01b03() {
      return this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627);
   }

   public boolean Iii_method_d4cea6e3() {
      return this.isEnabled() && this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627);
   }

   public boolean iII_method_9983ec3() {
      return !this.isEnabled() || this.I_field_49 > 0;
   }

   public boolean iIi_method_9a6caa3() {
      return !this.I_field_f2700bf6.isEmpty();
   }

   private boolean Iiii_method_c523b846() {
      return I_field_3a9bda27.player.input.movementForward != 0.0F || I_field_3a9bda27.player.input.movementSideways != 0.0F || this.ii_field_5a;
   }

   private int I_method_13e0ff71(SlotActionType var1) {
      return var1 == SlotActionType.PICKUP ? 1 : (this.Ii_field_49 > 1 ? 2 : 3);
   }

   private void I_method_13e0ff7e(SlotActionType var1) {
      if (this.isEnabled() && this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627)) {
         this.Ii_field_49 = this.I_method_13e0ff71(var1 == null ? SlotActionType.PICKUP : var1) + 1;
      }
   }

   public void IiI_method_d4c01aff() {
      if (this.isEnabled() && this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627)) {
         this.Ii_field_49 = 8;
      }
   }

   private boolean iIII_method_297e9086() {
      if (!(I_field_3a9bda27.currentScreen instanceof HandledScreen)) {
         return false;
      } else {
         return !this.Iiii_method_c523b846() ? false : !I_field_3a9bda27.player.currentScreenHandler.getCursorStack().isEmpty();
      }
   }

   private void iiI_method_b5b2edf() {
      if (!this.I_field_f2700bf6.isEmpty()) {
         this.Ii_field_5a = true;

         while (!this.I_field_f2700bf6.isEmpty()) {
            ClickSlotC2SPacket var1 = this.I_field_f2700bf6.poll();
            if (var1 != null) {
               I_field_3a9bda27.player.networkHandler.sendPacket(var1);
            }
         }

         this.Ii_field_5a = false;
         this.I_field_49 = 0;
      }
   }

   private boolean I_method_a023834e(ClickSlotC2SPacket var1) {
      return !this.I_field_f2700bf6.contains(var1) && this.I_field_f2700bf6.add(var1);
   }

   public void Iii_method_d4cea6df() {
      if (this.IiIi_method_c360c826() && !this.I_field_7865b31.isEmpty()) {
         if (!this.I_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627)) {
            this.i_field_5a = true;
            if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
               this.I_field_991c1e8c.I_method_23e11e3f();
            } else if (this.IiiI_method_c5152c66()) {
               this.II_field_49 = 2;
               this.II_field_5a = true;
               this.I_field_991c1e8c.I_method_23e11e3f();
            } else {
               this.i_field_49 = 3;
            }
         }
      }
   }

   private void iii_method_b69babf() {
      if (!this.I_field_7865b31.isEmpty()) {
         this.Ii_field_5a = true;

         for (Packet var2 : this.I_field_7865b31) {
            I_field_3a9bda27.player.networkHandler.sendPacket(var2);
         }

         I_field_3a9bda27.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(I_field_3a9bda27.player.currentScreenHandler.syncId));
         this.I_field_7865b31.clear();
         this.Ii_field_5a = false;
      }
   }

   @Override
   public void onDisable() {
      this.iiI_method_b5b2edf();
      this.I_field_49 = 1;
      this.I_field_f2700bf6.clear();
      this.Ii_field_49 = 0;
      this.ii_field_5a = false;
      this.III_field_5a = false;
      this.I_field_7865b31.clear();
      this.i_field_49 = 0;
      this.II_field_49 = 0;
      this.i_field_5a = false;
      this.II_field_5a = false;
      this.I_field_5a = false;
      this.Ii_field_5a = false;
      super.onDisable();
   }

   @Override
   public void onEnable() {
      this.iiI_method_b5b2edf();
      this.I_field_f2700bf6.clear();
      this.I_field_49 = 1;
      super.onEnable();
   }

   public static void iII_method_9983ebf() {
      KeyBinding[] var0 = new KeyBinding[]{
         I_field_3a9bda27.options.forwardKey,
         I_field_3a9bda27.options.backKey,
         I_field_3a9bda27.options.leftKey,
         I_field_3a9bda27.options.rightKey,
         I_field_3a9bda27.options.jumpKey
      };
      if (!iIIi_method_298d1c66()) {
         for (KeyBinding var4 : var0) {
            int var5 = InputUtil.fromTranslationKey(var4.getBoundKeyTranslationKey()).getCode();
            boolean var6 = InputUtil.isKeyPressed(I_field_3a9bda27.getWindow().getHandle(), var5);
            var4.setPressed(var6);
         }
      }
   }

   private static boolean iIIi_method_298d1c66() {
      return I_field_3a9bda27.currentScreen instanceof ChatScreen
         || I_field_3a9bda27.currentScreen != null && IiIiIIIII_Class161.I_field_fdef2cc != null && IiIiIIIII_Class161.I_field_fdef2cc.I_method_189fd283()
         || I_field_3a9bda27.currentScreen instanceof SignEditScreen
         || I_field_3a9bda27.currentScreen instanceof AnvilScreen
         || I_field_3a9bda27.currentScreen instanceof CreativeInventoryScreen && CreativeInventoryScreen.selectedTab == ItemGroups.getSearchGroup();
   }

   @Generated
   public ModeSetting I_method_a4754f55() {
      return this.I_field_bbe33e6c;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 I_method_5c5e80d0() {
      return this.I_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 i_method_62667cb0() {
      return this.i_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 II_method_62e1d093() {
      return this.II_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 Ii_method_68e9cc73() {
      return this.Ii_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 iI_method_1dd950b3() {
      return this.iI_field_500d0627;
   }

   @Generated
   public List<Packet<?>> I_method_eb75c1e8() {
      return this.I_field_7865b31;
   }

   @Generated
   public int II_method_48de64b5() {
      return this.i_field_49;
   }

   @Generated
   public boolean iiI_method_b5b2ee3() {
      return this.i_field_5a;
   }

   @Generated
   public iiIiIIiii_Class424 I_method_81ae2f75() {
      return this.I_field_991c1e8c;
   }

   @Generated
   public int Ii_method_48ecf095() {
      return this.II_field_49;
   }

   @Generated
   public boolean iii_method_b69bac3() {
      return this.II_field_5a;
   }

   @Generated
   public boolean IIII_method_8cb72866() {
      return this.Ii_field_5a;
   }

   @Generated
   public boolean IIIi_method_8cc5b446() {
      return this.iI_field_5a;
   }

   @Generated
   public int iI_method_4aa154d5() {
      return this.Ii_field_49;
   }

   @Generated
   public boolean IIiI_method_8e7a1886() {
      return this.ii_field_5a;
   }

   @Generated
   public boolean IIii_method_8e88a466() {
      return this.III_field_5a;
   }

   @Generated
   public int ii_method_4aafe0b5() {
      return this.I_field_49;
   }

   @Generated
   public boolean IiII_method_c3523c46() {
      return this.I_field_5a;
   }

   @Generated
   public Queue<ClickSlotC2SPacket> I_method_8c6d7c1f() {
      return this.I_field_f2700bf6;
   }

   @Generated
   public IiIIIiII_Class69<SendPacketEvent> I_method_d1771d38() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ReceivePacketEvent> i_method_fb73ad58() {
      return this.i_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<InputEvent> II_method_b69c9c55() {
      return this.II_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ClientPlayerTickEvent> Ii_method_e0992c75() {
      return this.Ii_field_3d936f41;
   }
}
