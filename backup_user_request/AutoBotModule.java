package rockstar.client;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;

@ModuleInfo(
   name = "Auto Bot",
   category = ModuleCategory.PLAYER
)
public class AutoBotModule extends Module {
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private AutoBotModule.Nested1_bc0e7c20 I_field_978de67;

   public AutoBotModule() {
      this.I_field_978de67 = AutoBotModule.Nested1_bc0e7c20.I_field_978de67;
   }

   @Override
   public void onEnable() {
      this.I_field_978de67 = AutoBotModule.Nested1_bc0e7c20.I_field_978de67;
      iiIiiIIii_Class436.I_method_29e64b35().I_method_b0e9a63f();
   }

   @Override
   public void onDisable() {
      if (iiIiiIiIi_Class438.I_method_1047da03()) {
         this.I_method_51463775().I_method_1381fa5f();
      }

      iiIiiIIii_Class436.I_method_29e64b35().I_method_b0e9a63f();
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && iiIiiIiIi_Class438.I_method_1047da03()) {
         if (this.I_field_991c1e8c.I_method_58432069(200L)) {
            BlockPos var1 = I_field_3a9bda27.player.getBlockPos();
            byte var2 = 10;

            for (int var3 = 0; var3 < var2 * 2; var3++) {
               for (int var4 = 0; var4 < var2 * 2; var4++) {
                  for (int var5 = 0; var5 < var2 * 2; var5++) {
                     BlockPos var6 = new BlockPos((var3 % 2 == 0 ? -var3 : var3) / 2, (var5 % 2 == 0 ? -var5 : var5) / 2, (var4 % 2 == 0 ? -var4 : var4) / 2);
                     BlockPos var7 = var1.add(var6);
                     if (this.I_method_25338e1d(var7)) {
                        return;
                     }
                  }
               }
            }

            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private boolean I_method_25338e1d(BlockPos var1) {
      BlockPos var2 = var1.up();
      if (I_field_3a9bda27.world.getBlockState(var1).getBlock() == Blocks.OBSIDIAN
         && I_field_3a9bda27.world.getBlockState(var1.east()).getBlock() == Blocks.OBSIDIAN
         && I_field_3a9bda27.world.getBlockState(var1.north()).getBlock() == Blocks.OBSIDIAN
         && I_field_3a9bda27.world.getBlockState(var1.south()).getBlock() == Blocks.OBSIDIAN
         && I_field_3a9bda27.world.getBlockState(var1.west()).getBlock() == Blocks.OBSIDIAN
         && I_field_3a9bda27.world.getBlockState(var2.east()).getBlock() == Blocks.AIR
         && I_field_3a9bda27.world.getBlockState(var2.north()).getBlock() == Blocks.AIR
         && I_field_3a9bda27.world.getBlockState(var2.south()).getBlock() == Blocks.AIR
         && I_field_3a9bda27.world.getBlockState(var2.west()).getBlock() == Blocks.AIR) {
         if (var2.equals(I_field_3a9bda27.player.getBlockPos())) {
            if (I_field_3a9bda27.world.getBlockState(var2).getBlock() == Blocks.TORCH) {
               if (this.I_field_978de67 != AutoBotModule.Nested1_bc0e7c20.Ii_field_978de67) {
                  this.I_method_25338e19(var2);
                  this.I_method_2092066d("newton cleararea");
                  this.I_field_978de67 = AutoBotModule.Nested1_bc0e7c20.Ii_field_978de67;
                  this.I_field_991c1e8c.I_method_23e11e3f();
                  return true;
               }
            } else if (this.I_field_978de67 != AutoBotModule.Nested1_bc0e7c20.II_field_978de67) {
               this.I_method_25338e19(var2);
               this.I_method_2092066d("newton fill " + Registries.BLOCK.getId(Blocks.TORCH));
               this.I_field_978de67 = AutoBotModule.Nested1_bc0e7c20.II_field_978de67;
               this.I_field_991c1e8c.I_method_23e11e3f();
               return true;
            }
         } else if (this.I_field_978de67 != AutoBotModule.Nested1_bc0e7c20.i_field_978de67
               && this.I_field_978de67 != AutoBotModule.Nested1_bc0e7c20.II_field_978de67
            || this.I_field_978de67 == AutoBotModule.Nested1_bc0e7c20.i_field_978de67 && !this.I_method_51463775().I_method_1381fa63()) {
            this.I_method_51463775().I_method_54107219(var2);
            this.I_field_978de67 = AutoBotModule.Nested1_bc0e7c20.i_field_978de67;
            this.I_field_991c1e8c.I_method_23e11e3f();
            return true;
         }

         return false;
      } else {
         return false;
      }
   }

   private void I_method_25338e19(BlockPos var1) {
      iiIiiIIii_Class436 var2 = iiIiiIIii_Class436.I_method_29e64b35();
      var2.I_method_b0e9a63f();
      var2.I_method_9d7525f9(var1);
      var2.i_method_c7c8b9d9(var1);
   }

   private boolean I_method_2092066d(String var1) {
      return this.I_method_51463775().I_method_cdb6ea6d(var1);
   }

   private iiIiIiIIi_Class426 I_method_51463775() {
      return iiIiIiIii_Class428.I_method_483e9b95();
   }

   static enum Nested1_bc0e7c20 {
      I_field_978de67,
      i_field_978de67,
      II_field_978de67,
      Ii_field_978de67;
   }
}
