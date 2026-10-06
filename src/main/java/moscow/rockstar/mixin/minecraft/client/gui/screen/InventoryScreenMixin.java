package moscow.rockstar.mixin.minecraft.client.gui.screen;

import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiIiiI_Class311;

@Mixin({InventoryScreen.class})
public abstract class InventoryScreenMixin extends RecipeBookScreen<PlayerScreenHandler> implements iIIiIIiIi_Class294 {
   public InventoryScreenMixin(PlayerScreenHandler var1, RecipeBookWidget<?> var2, PlayerInventory var3, Text var4) {
      super(var1, var2, var3, var4);
   }

   @Inject(
      method = {"init"},
      at = {@At("TAIL")}
   )
   private void dropButton(CallbackInfo var1) {
      if (!RockstarClient.I_field_502d1741.i_method_e8604970()) {
         Text var2 = Text.of(IiIiIIII_Class81.I_method_f25a980a("inventory.button.drop_all"));
         Text var3 = Text.of(IiIiIIII_Class81.I_method_f25a980a("\u041e\u0447\u0438\u0449\u0430\u0442\u044c \u0432\u0441\u0435"));
         int var4 = I_field_3a9bda27.textRenderer.getWidth(var2) + 20;
         int var5 = I_field_3a9bda27.textRenderer.getWidth(var2) + 20;
         byte var6 = 80;
         short var7 = 200;
         int var8 = Math.max(var6, Math.min(var7, var4));
         int var9 = Math.max(var6, Math.min(var7, var5));
         ButtonWidget var10 = ButtonWidget.builder(var2, var1x -> this.dropAll())
            .dimensions(this.x + this.backgroundWidth / 2 - var8 / 2, this.y - 20, var8, 18)
            .build();
         ButtonWidget var11 = ButtonWidget.builder(var3, var1x -> this.clearAll())
            .dimensions(this.x + this.backgroundWidth / 2 - var9 / 2, this.y - 40, var9, 18)
            .build();
         ((ScreenAccessor)(Object)this).invokeAddDrawableChild(var10);
         ((ScreenAccessor)(Object)this).invokeAddDrawableChild(var11);
      }
   }

   @Unique
   private void dropAll() {
      iIIiiIiII_Class309 var1 = iIIiiIiIi_Class310.i_method_7fde0a75()
         .I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695())
         .I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38())
         .I_method_fdeecb5d(new iIIiiIiiI_Class311());

      for (iIIiIiIii_Class300 var3 : (Iterable<iIIiIiIii_Class300>)(Iterable<?>)var1.I_method_617d3e68()) {
         if (!var3.I_method_dfe89263()) {
            I_field_3a9bda27.interactionManager
               .clickSlot(I_field_3a9bda27.player.currentScreenHandler.syncId, var3.I_method_dfe89252(), 1, SlotActionType.THROW, I_field_3a9bda27.player);
         }
      }
   }

   @Unique
   private void clearAll() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.interactionManager != null) {
         iIIiiIiII_Class309 var1 = iIIiiIiIi_Class310.i_method_7fde0a75()
            .I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695())
            .I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38())
            .I_method_fdeecb5d(iIIiiIiIi_Class310.II_method_66d8858());
         int var2 = I_field_3a9bda27.player.currentScreenHandler.syncId;

         for (iIIiIiIii_Class300 var4 : (Iterable<iIIiIiIii_Class300>)(Iterable<?>)var1.I_method_617d3e68()) {
            if (!var4.I_method_dfe89263()) {
               if (iIIIiiiII_Class285.Ii_method_b349c526()) {
                  iIIiIiIiI_Class299.iI_method_c617e8c2(var4.I_method_dfe89252(), 45);
               } else {
                  I_field_3a9bda27.interactionManager.clickSlot(var2, var4.I_method_dfe89252(), 1, SlotActionType.THROW, I_field_3a9bda27.player);
               }
            }
         }
      }
   }
}
