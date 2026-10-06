package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import lombok.Generated;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.AbstractSignBlock;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BeaconBlock;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BellBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BrewingStandBlock;
import net.minecraft.block.CartographyTableBlock;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.CobwebBlock;
import net.minecraft.block.CommandBlock;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.DropperBlock;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.LecternBlock;
import net.minecraft.block.LoomBlock;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.SmithingTableBlock;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.block.TripwireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.vehicle.ChestMinecartEntity;
import net.minecraft.entity.vehicle.CommandBlockMinecartEntity;
import net.minecraft.entity.vehicle.FurnaceMinecartEntity;
import net.minecraft.entity.vehicle.HopperMinecartEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "No Interact",
   category = ModuleCategory.PLAYER
)
public class NoInteractModule extends Module {
   RegistryListSetting I_field_ba20c66c;
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;

   public NoInteractModule() {
      this.IiI_method_e67c1eff();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_e67c1eff() {
      this.I_field_ba20c66c = new RegistryListSetting(this, "modules.settings.no_interact.blocks")
         .I_method_3d51a98a(
            Blocks.CRAFTING_TABLE,
            Blocks.ENCHANTING_TABLE,
            Blocks.RED_BED,
            Blocks.CHEST,
            Blocks.ENDER_CHEST,
            Blocks.TRAPPED_CHEST,
            Blocks.FURNACE,
            Blocks.BARREL,
            Blocks.SHULKER_BOX,
            Blocks.DROPPER,
            Blocks.DISPENSER,
            Blocks.HOPPER,
            Blocks.ANVIL,
            Blocks.CAULDRON,
            Blocks.OAK_SIGN,
            Blocks.BELL,
            Blocks.COMPOSTER,
            Blocks.BREWING_STAND,
            Blocks.JUKEBOX,
            Blocks.COMMAND_BLOCK,
            Blocks.BEACON,
            Blocks.RESPAWN_ANCHOR,
            Blocks.GRINDSTONE,
            Blocks.LECTERN,
            Blocks.CARTOGRAPHY_TABLE,
            Blocks.LOOM,
            Blocks.COBWEB,
            Blocks.TRIPWIRE,
            Blocks.SMITHING_TABLE,
            Blocks.STONECUTTER,
            Blocks.PLAYER_HEAD,
            Blocks.OAK_TRAPDOOR
         )
         .I_method_5cb76d1d(Items.ARMOR_STAND)
         .I_method_5cb76d1d(Items.MINECART)
         .I_method_5cb76d1d(Items.CHEST_MINECART)
         .I_method_5cb76d1d(Items.FURNACE_MINECART)
         .I_method_5cb76d1d(Items.TNT_MINECART)
         .I_method_5cb76d1d(Items.HOPPER_MINECART)
         .I_method_5cb76d1d(Items.COMMAND_BLOCK_MINECART);
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.no_interact.onlyAura");
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.no_interact.onlyUtilityItems");
      this.II_field_ba20ca4c = new BooleanSetting(this, "\u0410\u0440\u043c\u043e\u0440 \u0441\u0442\u0435\u043d\u0434", () -> true) {
         @Override
         public JsonElement toJson() {
            return new JsonPrimitive(false);
         }

         @Override
         public void fromJson(JsonElement var1) {
            super.fromJson(var1);
            if (this.i_method_9b12da03()) {
               NoInteractModule.this.I_field_ba20c66c.I_method_568307b6(Registries.ITEM.getId(Items.ARMOR_STAND));
            }
         }
      };
   }

   public boolean I_method_11083551(Block var1, ItemStack var2) {
      if (!this.i_method_d45c5b85(var2)) {
         return false;
      } else if (var1 instanceof CraftingTableBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.CRAFTING_TABLE)) {
         return true;
      } else if (var1 instanceof EnchantingTableBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.ENCHANTING_TABLE)) {
         return true;
      } else if (var1 instanceof BedBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.RED_BED)) {
         return true;
      } else if (var1 instanceof TrapdoorBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.OAK_TRAPDOOR)) {
         return true;
      } else if (var1 instanceof ChestBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.CHEST)) {
         return true;
      } else if (var1 instanceof EnderChestBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.ENDER_CHEST)) {
         return true;
      } else if (var1 instanceof TrappedChestBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.TRAPPED_CHEST)) {
         return true;
      } else if (var1 instanceof AbstractFurnaceBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.FURNACE)) {
         return true;
      } else if (var1 instanceof BarrelBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.BARREL)) {
         return true;
      } else if (var1 instanceof ShulkerBoxBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.SHULKER_BOX)) {
         return true;
      } else if (var1 instanceof DropperBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.DROPPER)) {
         return true;
      } else if (var1 instanceof DispenserBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.DISPENSER)) {
         return true;
      } else if (var1 instanceof HopperBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.HOPPER)) {
         return true;
      } else if (var1 instanceof AnvilBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.ANVIL)) {
         return true;
      } else if (var1 instanceof AbstractCauldronBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.CAULDRON)) {
         return true;
      } else if (var1 instanceof AbstractSignBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.OAK_SIGN)) {
         return true;
      } else if (var1 instanceof BellBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.BELL)) {
         return true;
      } else if (var1 instanceof ComposterBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.COMPOSTER)) {
         return true;
      } else if (var1 instanceof BrewingStandBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.BREWING_STAND)) {
         return true;
      } else if (var1 instanceof JukeboxBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.JUKEBOX)) {
         return true;
      } else if (var1 instanceof CommandBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.COMMAND_BLOCK)) {
         return true;
      } else if (var1 instanceof BeaconBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.BEACON)) {
         return true;
      } else if (var1 instanceof RespawnAnchorBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.RESPAWN_ANCHOR)) {
         return true;
      } else if (var1 instanceof GrindstoneBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.GRINDSTONE)) {
         return true;
      } else if (var1 instanceof LecternBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.LECTERN)) {
         return true;
      } else if (var1 instanceof CobwebBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.COBWEB)) {
         return true;
      } else if (var1 instanceof TripwireBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.TRIPWIRE)) {
         return true;
      } else if (var1 instanceof CartographyTableBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.CARTOGRAPHY_TABLE)) {
         return true;
      } else if (var1 instanceof LoomBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.LOOM)) {
         return true;
      } else {
         return var1 instanceof SmithingTableBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.SMITHING_TABLE)
            ? true
            : var1 instanceof StonecutterBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.STONECUTTER);
      }
   }

   public boolean I_method_13ad230d(Entity var1, ItemStack var2) {
      if (!this.i_method_d45c5b85(var2)) {
         return false;
      } else if (var1 instanceof ArmorStandEntity && this.I_field_ba20c66c.I_method_c9a44a24(Registries.ITEM.getId(Items.ARMOR_STAND))) {
         return true;
      } else if (var1 instanceof MinecartEntity && this.I_field_ba20c66c.I_method_c9a44a24(Registries.ITEM.getId(Items.MINECART))) {
         return true;
      } else if (var1 instanceof ChestMinecartEntity && this.I_field_ba20c66c.I_method_c9a44a24(Registries.ITEM.getId(Items.CHEST_MINECART))) {
         return true;
      } else if (var1 instanceof FurnaceMinecartEntity && this.I_field_ba20c66c.I_method_c9a44a24(Registries.ITEM.getId(Items.FURNACE_MINECART))) {
         return true;
      } else if (var1 instanceof TntMinecartEntity && this.I_field_ba20c66c.I_method_c9a44a24(Registries.ITEM.getId(Items.TNT_MINECART))) {
         return true;
      } else {
         return var1 instanceof HopperMinecartEntity && this.I_field_ba20c66c.I_method_c9a44a24(Registries.ITEM.getId(Items.HOPPER_MINECART))
            ? true
            : var1 instanceof CommandBlockMinecartEntity && this.I_field_ba20c66c.I_method_c9a44a24(Registries.ITEM.getId(Items.COMMAND_BLOCK_MINECART));
      }
   }

   public boolean I_method_3063d7a5(ItemStack var1) {
      if (!this.i_method_d45c5b85(var1)) {
         return false;
      } else {
         if (var1.getItem() instanceof BlockItem var2) {
            if (var2.getBlock() instanceof SkullBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.PLAYER_HEAD)) {
               return true;
            }

            if (var2.getBlock() instanceof CobwebBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.COBWEB)) {
               return true;
            }

            if (var2.getBlock() instanceof TripwireBlock && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.TRIPWIRE)) {
               return true;
            }
         }

         return var1.getItem() == Items.STRING && this.I_field_ba20c66c.I_method_bcc5858f(Blocks.TRIPWIRE);
      }
   }

   private boolean i_method_d45c5b85(ItemStack var1) {
      return this.I_field_ba20ca4c.i_method_9b12da03()
            && !RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class).isEnabled()
         ? false
         : !this.i_field_ba20ca4c.i_method_9b12da03() || this.II_method_4e76baa8(var1);
   }

   private boolean II_method_4e76baa8(ItemStack var1) {
      return var1 != null && !var1.isEmpty()
         ? var1.isOf(Items.ENDER_PEARL)
            || var1.isOf(Items.CHORUS_FRUIT)
            || var1.isOf(Items.FIREWORK_ROCKET)
            || var1.isOf(Items.WIND_CHARGE)
            || var1.isOf(Items.EXPERIENCE_BOTTLE)
            || var1.isOf(Items.POTION)
            || var1.isOf(Items.SPLASH_POTION)
            || var1.isOf(Items.LINGERING_POTION)
            || var1.isOf(Items.SNOWBALL)
            || var1.isOf(Items.EGG)
         : false;
   }

   @Generated
   public RegistryListSetting I_method_1a2db55() {
      return this.I_field_ba20c66c;
   }

   @Generated
   public BooleanSetting I_method_1a2df35() {
      return this.I_field_ba20ca4c;
   }
}
