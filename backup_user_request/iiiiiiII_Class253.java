package rockstar.client;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import pyrock.events.player.ClientPlayerTickEvent;

public final class iiiiiiII_Class253 implements iIIiIIiIi_Class294 {
   private static final long I_field_4a = 400L;
   private static iiiiiiII_Class253 I_field_9b46bb81;
   private iiiiiiII_Class253.Nested1_c97fb8d3 I_field_e48591fc;
   private iiiiiiII_Class253.Nested1_c97fb8f3 I_field_e48595dc;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;

   private iiiiiiII_Class253() {
      this.I_field_e48591fc = iiiiiiII_Class253.Nested1_c97fb8d3.I_field_e48591fc;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.I_field_3d936f41 = var1 -> {
         this.II_method_2fb35815();
         if (this.I_field_e48595dc == null && this.I_field_e48591fc != iiiiiiII_Class253.Nested1_c97fb8d3.I_field_e48591fc && I_field_3a9bda27.player != null) {
            if (I_field_3a9bda27.currentScreen == null) {
               GuiMoveModule varGuiMove = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
               if (varGuiMove == null || varGuiMove.I_method_eb75c1e8().isEmpty()) {
                  if (this.I_field_991c1e8c.I_method_58432069(400L)) {
                     iIIiiiIiI_Class315 var2 = iIIiIiIiI_Class299.i_method_e5bad375();
                     boolean var3 = var2.I_method_158af795() == Items.ELYTRA;
                     boolean var4 = this.I_field_e48591fc == iiiiiiII_Class253.Nested1_c97fb8d3.i_field_e48591fc ? var3 : !var3;
                     if (var4) {
                        this.I_field_e48591fc = iiiiiiII_Class253.Nested1_c97fb8d3.I_field_e48591fc;
                     } else {
                        iIIiiIiII_Class309 var5 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
                        iIIiIiIii_Class300 var6 = this.I_field_e48591fc == iiiiiiII_Class253.Nested1_c97fb8d3.i_field_e48591fc
                           ? this.I_method_7d5b7b10(var5)
                           : this.i_method_2fdc9b30(var5);
                        if (var6 == null) {
                           this.I_field_e48591fc = iiiiiiII_Class253.Nested1_c97fb8d3.I_field_e48591fc;
                        } else {
                           this.I_field_e48595dc = new iiiiiiII_Class253.Nested1_c97fb8f3(var6, var2);
                           this.I_field_991c1e8c.I_method_23e11e3f();
                        }
                     }
                  }
               }
            }
         }
      };
   }

   public static iiiiiiII_Class253 I_method_8ebf53cb() {
      if (I_field_9b46bb81 == null) {
         I_field_9b46bb81 = new iiiiiiII_Class253();
         RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(I_field_9b46bb81);
      }

      return I_field_9b46bb81;
   }

   public boolean I_method_a6b2b8d0() {
      return this.I_field_e48595dc != null || this.I_field_e48591fc != iiiiiiII_Class253.Nested1_c97fb8d3.I_field_e48591fc;
   }

   public boolean I_method_2fa4d77c(long var1) {
      return this.i_field_991c1e8c.I_method_58432069(var1);
   }

   public void I_method_a6b2b8cc() {
      this.I_field_e48591fc = iiiiiiII_Class253.Nested1_c97fb8d3.i_field_e48591fc;
      this.I_field_991c1e8c.I_method_58432065(0L);
   }

   public void i_method_a6c144ac() {
      this.I_field_e48591fc = iiiiiiII_Class253.Nested1_c97fb8d3.II_field_e48591fc;
      this.I_field_991c1e8c.I_method_58432065(0L);
   }

   private void II_method_2fb35815() {
      if (this.I_field_e48595dc != null && I_field_3a9bda27.player != null) {
         int var1 = this.I_field_e48595dc.I_field_1242a2ac.I_method_dfe89252();
         if (var1 >= 36 && var1 <= 44) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_e48595dc.i_field_1242a2ac.I_method_dfe89252(), var1 - 36);
            this.I_field_e48595dc = null;
            this.i_field_991c1e8c.I_method_23e11e3f();
         } else if (RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class) == null
            || RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class).I_method_eb75c1e8().isEmpty()) {
            if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
               if (this.I_field_e48595dc.I_field_49 == 0) {
                  iIIiIiIiI_Class299.iI_method_c617e8c2(var1, 8);
                  iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_e48595dc.i_field_1242a2ac.I_method_dfe89252(), 8);
                  iIIiIiIiI_Class299.iI_method_c617e8c2(var1, 8);
               }
            } else if (this.I_field_e48595dc.I_field_49 == 0) {
               iIIiIiIiI_Class299.iI_method_c617e8c2(var1, 8);
            } else if (this.I_field_e48595dc.I_field_49 == 1) {
               iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_e48595dc.i_field_1242a2ac.I_method_dfe89252(), 8);
            } else if (this.I_field_e48595dc.I_field_49 == 2) {
               iIIiIiIiI_Class299.iI_method_c617e8c2(var1, 8);
            }

            if (++this.I_field_e48595dc.I_field_49 >= 3) {
               this.I_field_e48595dc = null;
               this.i_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private iIIiIiIii_Class300 I_method_7d5b7b10(iIIiiIiII_Class309<iIIiIiIii_Class300> var1) {
      return var1.I_method_77fa4424(var0 -> var0.getItem() == Items.ELYTRA && !var0.willBreakNextUse());
   }

   private iIIiIiIii_Class300 i_method_2fdc9b30(iIIiiIiII_Class309<iIIiIiIii_Class300> var1) {
      iIIiIiIii_Class300 var2 = null;
      double var3 = -1.0;

      for (iIIiIiIii_Class300 var6 : var1.I_method_617d3e68()) {
         ItemStack var7 = var6.I_method_7b7e0bb9();
         if (!var7.isEmpty() && var7.getItem() != Items.ELYTRA) {
            EquippableComponent var8 = (EquippableComponent)var7.get(DataComponentTypes.EQUIPPABLE);
            if (var8 != null && var8.slot() == EquipmentSlot.CHEST) {
               double var9 = this.I_method_a9a5651c(var7) + iIIiIiIIi_Class298.I_method_7ea237bf(var7, Enchantments.PROTECTION) * 0.6;
               if (var9 > var3) {
                  var3 = var9;
                  var2 = var6;
               }
            }
         }
      }

      return var2;
   }

   private double I_method_a9a5651c(ItemStack var1) {
      AttributeModifiersComponent var2 = (AttributeModifiersComponent)var1.get(DataComponentTypes.ATTRIBUTE_MODIFIERS);
      if (var2 == null) {
         return 0.0;
      } else {
         double var3 = 0.0;

         for (Entry var6 : var2.modifiers()) {
            if (var6.attribute() == EntityAttributes.ARMOR || var6.attribute() == EntityAttributes.ARMOR_TOUGHNESS) {
               var3 += var6.modifier().value();
            }
         }

         return var3;
      }
   }

   static enum Nested1_c97fb8d3 {
      I_field_e48591fc,
      i_field_e48591fc,
      II_field_e48591fc;
   }

   static final class Nested1_c97fb8f3 {
      int I_field_49;
      final iIIiIiIii_Class300 I_field_1242a2ac;
      final iIIiIiIii_Class300 i_field_1242a2ac;

      Nested1_c97fb8f3(iIIiIiIii_Class300 var1, iIIiIiIii_Class300 var2) {
         this.I_field_1242a2ac = var1;
         this.i_field_1242a2ac = var2;
      }
   }
}
