package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Stealer",
   category = ModuleCategory.PLAYER
)
public class StealerModule extends Module {
   private BooleanSetting I_field_ba20ca4c;
   private SliderSetting I_field_73178e8c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private BooleanSetting Ii_field_ba20ca4c;
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private final List<EnderChestBlockEntity> I_field_7865b31 = new ArrayList<>();
   private EnderChestBlockEntity I_field_a76901ce;

   public StealerModule() {
      this.IiI_method_b78c929f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_b78c929f() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.stealer.instant");
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.stealer.delay", this.I_field_ba20ca4c::i_method_9b12da03)
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(1000.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(400.0F);
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.stealer.close", "modules.settings.stealer.close.description");
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.stealer.off", "modules.settings.stealer.off.description");
      this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.stealer.open_mystic", "modules.settings.stealer.open_mystic.description");
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.stealer.mode");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.stealer.mode.up").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.stealer.mode.down");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.stealer.mode.center");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.stealer.mode.random");
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.currentScreen instanceof GenericContainerScreen
         && I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var7) {
         int var9 = var7.getInventory().size();
         if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            for (int var10 = 0; var10 < var9; var10++) {
               if (!var7.getSlot(var10).getStack().isEmpty()) {
                  I_field_3a9bda27.interactionManager.clickSlot(var7.syncId, var10, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
               }
            }
         } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)) {
            for (int var11 = 0;
               var11 < var9
                  && this.I_field_991c1e8c
                     .I_method_58432069((long)(this.I_field_73178e8c.Ii_method_a20abcd2() + iIIiiiiiI_Class319.I_method_b56b22f(-100.0, 100.0)));
               var11++
            ) {
               if (!var7.getSlot(var11).getStack().isEmpty()) {
                  I_field_3a9bda27.interactionManager.clickSlot(var7.syncId, var11, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                  this.I_field_991c1e8c.I_method_23e11e3f();
               }
            }
         } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
            for (int var12 = var9 - 1;
               var12 >= 0
                  && this.I_field_991c1e8c
                     .I_method_58432069((long)(this.I_field_73178e8c.Ii_method_a20abcd2() + iIIiiiiiI_Class319.I_method_b56b22f(-100.0, 100.0)));
               var12--
            ) {
               if (!var7.getSlot(var12).getStack().isEmpty()) {
                  I_field_3a9bda27.interactionManager.clickSlot(var7.syncId, var12, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                  this.I_field_991c1e8c.I_method_23e11e3f();
               }
            }
         } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627)) {
            int var13 = var9 / 2;

            for (int var15 = 0;
               var15 <= var13
                  && this.I_field_991c1e8c
                     .I_method_58432069((long)(this.I_field_73178e8c.Ii_method_a20abcd2() + iIIiiiiiI_Class319.I_method_b56b22f(-100.0, 100.0)));
               var15++
            ) {
               int var5 = var13 - var15;
               int var6 = var13 + var15;
               if (var5 >= 0 && !var7.getSlot(var5).getStack().isEmpty()) {
                  I_field_3a9bda27.interactionManager.clickSlot(var7.syncId, var5, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                  this.I_field_991c1e8c.I_method_23e11e3f();
               } else if (var6 < var9 && !var7.getSlot(var6).getStack().isEmpty()) {
                  I_field_3a9bda27.interactionManager.clickSlot(var7.syncId, var6, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                  this.I_field_991c1e8c.I_method_23e11e3f();
               }
            }
         } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)
            && this.I_field_991c1e8c.I_method_58432069((long)(this.I_field_73178e8c.Ii_method_a20abcd2() + iIIiiiiiI_Class319.I_method_b56b22f(-100.0, 100.0)))
            )
          {
            int var14 = (int)iIIiiiiiI_Class319.I_method_b56b22f(0.0, var9);
            if (!var7.getSlot(var14).getStack().isEmpty()) {
               I_field_3a9bda27.interactionManager.clickSlot(var7.syncId, var14, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }

         if (this.I_method_a97d676d(var7)) {
            if (this.I_field_a76901ce != null && this.Ii_field_ba20ca4c.i_method_9b12da03()) {
               this.I_field_7865b31.add(this.I_field_a76901ce);
            }

            if (this.II_field_ba20ca4c.i_method_9b12da03()) {
               this.toggle();
            }

            if (this.i_field_ba20ca4c.i_method_9b12da03()) {
               I_field_3a9bda27.player.closeHandledScreen();
            }
         }
      } else if (this.Ii_field_ba20ca4c.i_method_9b12da03()) {
         if (this.I_field_a76901ce == null || !this.I_method_8839eff1(this.I_field_a76901ce)) {
            this.I_field_a76901ce = this.I_method_dc87cf25();
            this.i_field_991c1e8c.I_method_23e11e3f();
         }

         if (this.I_field_a76901ce != null && this.i_field_991c1e8c.I_method_58432069(200L)) {
            BlockPos var1 = this.I_field_a76901ce.getPos();
            Vec3d var8 = Vec3d.ofCenter(var1);
            iiIIiIIii_Class404 var3 = iiIIiIiIi_Class406.I_method_bc8095a1(var8);
            RockstarClient.getInstance()
               .I_method_58785402()
               .I_method_1acbf705(var3, iiIIiIIIi_Class402.I_field_32e0c64c, 22.0F, 22.0F, 22.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
            BlockHitResult var4 = new BlockHitResult(var8, Direction.UP, var1, false);
            I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var4);
            I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private boolean I_method_8839eff1(EnderChestBlockEntity var1) {
      return I_field_3a9bda27.player.squaredDistanceTo(var1.getPos().toCenterPos()) < 16.0 && !this.I_field_7865b31.contains(var1);
   }

   private EnderChestBlockEntity I_method_dc87cf25() {
      for (BlockEntity var2 : iIIIIiiiI_Class271.I_method_ea43a7e8()) {
         if (var2 instanceof EnderChestBlockEntity var3 && this.I_method_8839eff1(var3)) {
            return var3;
         }
      }

      return null;
   }

   private boolean I_method_a97d676d(GenericContainerScreenHandler var1) {
      Inventory var2 = var1.getInventory();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         if (!var2.getStack(var3).isEmpty()) {
            return false;
         }
      }

      return true;
   }
}
