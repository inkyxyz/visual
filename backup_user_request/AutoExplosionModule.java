package rockstar.client;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.window.MouseEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Auto Explosion",
   III_method_a89e5834 = "modules.descriptions.auto_explosion",
   category = ModuleCategory.COMBAT
)
public class AutoExplosionModule extends Module {
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private BlockPos I_field_670402ba;
   private BlockPos i_field_670402ba;
   private int I_field_49 = -1;
   private final IiIIIiII_Class69<MouseEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         if (I_field_3a9bda27.currentScreen == null) {
            if (var1.getButton() == 1 && var1.getAction() == 1) {
               if (I_field_3a9bda27.player.getMainHandStack().isEmpty() || I_field_3a9bda27.player.getMainHandStack().getItem() instanceof SwordItem) {
                  if (I_field_3a9bda27.crosshairTarget instanceof BlockHitResult var2) {
                     if (I_field_3a9bda27.world.getBlockState(var2.getBlockPos()).isOf(Blocks.OBSIDIAN)) {
                        BlockPos var4 = var2.getBlockPos().up();
                        if (I_field_3a9bda27.world.getBlockState(var4).isAir()) {
                           if (!this.I_method_b041f136(var4.getY())) {
                              this.I_field_670402ba = var4.toImmutable();
                              this.I_field_991c1e8c.I_method_23e11e3f();
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   };

   public AutoExplosionModule() {
      this.IiI_method_5b9269cc();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_5b9269cc() {
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "\u041d\u0435 \u0432\u0437\u0440\u044b\u0432\u0430\u0442\u044c");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "\u0421\u0435\u0431\u044f").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "\u0414\u0440\u0443\u0437\u0435\u0439").select();
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "\u041f\u0440\u0435\u0434\u043c\u0435\u0442\u044b").select();
   }

   @Override
   public void onDisable() {
      this.I_field_670402ba = null;
      this.i_field_670402ba = null;
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         iIIiiIiII_Class309 var1 = iIIiiIiIi_Class310.I_method_6a489695();
         iIIiiiIii_Class316 var2 = (iIIiiiIii_Class316)var1.I_method_5d34dd7d(Items.END_CRYSTAL);
         if (var2 == null) {
            this.I_field_670402ba = null;
            this.i_field_670402ba = null;
         } else {
            if (this.I_field_670402ba != null && this.I_field_991c1e8c.I_method_58432069(1L)) {
               if (!this.I_method_b041f136(this.I_field_670402ba.getY())) {
                  this.I_method_704015b1(var2.I_method_dfe89252(), this.I_field_670402ba);
                  this.i_field_670402ba = this.I_field_670402ba;
               }

               this.I_field_670402ba = null;
               this.I_field_991c1e8c.I_method_23e11e3f();
            }

            EndCrystalEntity var3 = this.I_method_c883c77a(this.i_field_670402ba);
            if (var3 != null) {
               Vec3d var4 = var3.getPos().add(0.0, 0.5, 0.0);
               float[] var5 = this.I_method_c10d9523(var4);
               RockstarClient.getInstance().I_method_58785402().I_method_a10b10c7(new iiIIiIIii_Class404(var5[0], var5[1]));
               this.I_method_7d886e76(var3);
            }

            super.II_method_6642fd22();
         }
      }
   }

   private void I_method_704015b1(int var1, BlockPos var2) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         int var3 = var1 - 36;
         if (var3 >= 0 && var3 <= 8) {
            BlockPos var4 = var2.down();
            Vec3d var5 = new Vec3d(var4.getX() + 0.5, var4.getY() + 1.0, var4.getZ() + 0.5);
            float[] var6 = this.I_method_c10d9523(var5);
            RockstarClient.getInstance().I_method_58785402().I_method_a10b10c7(new iiIIiIIii_Class404(var6[0], var6[1]));
            int var7 = I_field_3a9bda27.player.getInventory().selectedSlot;
            I_field_3a9bda27.player.getInventory().selectedSlot = var3;
            BlockHitResult var8 = new BlockHitResult(var5, Direction.UP, var4, false);
            I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var8);
            I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
            I_field_3a9bda27.player.getInventory().selectedSlot = var7;

            for (Entity var10 : I_field_3a9bda27.world.getEntities()) {
               if (var10 instanceof EndCrystalEntity var11 && var11.squaredDistanceTo(var5) < 1.0) {
                  return;
               }
            }
         }
      }
   }

   private EndCrystalEntity I_method_c883c77a(BlockPos var1) {
      if (var1 == null) {
         return null;
      } else {
         Box var2 = new Box(var1.getX(), var1.getY(), var1.getZ(), var1.getX() + 1.0, var1.getY() + 2.0, var1.getZ() + 1.0);

         for (Entity var4 : I_field_3a9bda27.world.getOtherEntities(null, var2)) {
            if (var4 instanceof EndCrystalEntity var5 && var5.isAlive()) {
               return var5;
            }
         }

         return null;
      }
   }

   private void I_method_7d886e76(EndCrystalEntity var1) {
      if (this.I_method_7d886e7a(var1)) {
         if (this.i_field_991c1e8c.I_method_58432069(80L)) {
            I_field_3a9bda27.interactionManager.attackEntity(I_field_3a9bda27.player, var1);
            I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
            this.I_field_49 = var1.getId();
            this.i_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private boolean I_method_7d886e7a(EndCrystalEntity var1) {
      if (var1 == null || !var1.isAlive()) {
         return false;
      } else if (this.i_method_c0f8425a(var1)) {
         return false;
      } else if (I_field_3a9bda27.player.distanceTo(var1) > 4.0) {
         return false;
      } else {
         return this.I_field_49 == var1.getId() && !this.i_field_991c1e8c.I_method_58432069(300L)
            ? false
            : I_field_3a9bda27.player.getAttackCooldownProgress(1.0F) >= 1.0F;
      }
   }

   private boolean i_method_c0f8425a(EndCrystalEntity var1) {
      if (this.I_method_b041f136(var1.getY())) {
         return true;
      } else {
         return this.i_field_51de8227.isSelected() && this.II_method_8dd51203(var1)
            ? true
            : this.II_field_51de8227.isSelected() && this.Ii_method_d144e5e3(var1);
      }
   }

   private boolean I_method_b041f136(double var1) {
      return this.I_field_51de8227.isSelected() && var1 <= I_field_3a9bda27.player.getY() + 0.1;
   }

   private boolean II_method_8dd51203(EndCrystalEntity var1) {
      Box var2 = var1.getBoundingBox().expand(6.0);

      for (PlayerEntity var4 : I_field_3a9bda27.world.getEntitiesByClass(PlayerEntity.class, var2, var0 -> var0 != I_field_3a9bda27.player)) {
         if (var4.isAlive() && RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var4.getName().getString())) {
            return true;
         }
      }

      return false;
   }

   private boolean Ii_method_d144e5e3(EndCrystalEntity var1) {
      Box var2 = var1.getBoundingBox().expand(6.0);

      for (ItemEntity var4 : I_field_3a9bda27.world.getEntitiesByClass(ItemEntity.class, var2, var0 -> true)) {
         if (var4 != null && var4.getStack() != null) {
            Item var5 = var4.getStack().getItem();
            if (var5 == Items.TOTEM_OF_UNDYING
               || var5 == Items.END_CRYSTAL
               || var5 == Items.ENCHANTED_GOLDEN_APPLE
               || var5 == Items.NETHERITE_HELMET
               || var5 == Items.NETHERITE_CHESTPLATE
               || var5 == Items.NETHERITE_LEGGINGS
               || var5 == Items.NETHERITE_BOOTS
               || var5 == Items.NETHERITE_SWORD
               || var5 == Items.DIAMOND_SWORD
               || var5 == Items.ELYTRA
               || var5 == Items.TRIDENT) {
               return true;
            }
         }
      }

      return false;
   }

   private float[] I_method_c10d9523(Vec3d var1) {
      Vec3d var2 = new Vec3d(
         I_field_3a9bda27.player.getX(),
         I_field_3a9bda27.player.getY() + I_field_3a9bda27.player.getEyeHeight(I_field_3a9bda27.player.getPose()),
         I_field_3a9bda27.player.getZ()
      );
      double var3 = var1.x - var2.x;
      double var5 = var1.y - var2.y;
      double var7 = var1.z - var2.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F;
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      return new float[]{
         I_field_3a9bda27.player.getYaw() + MathHelper.wrapDegrees(var11 - I_field_3a9bda27.player.getYaw()),
         I_field_3a9bda27.player.getPitch() + MathHelper.wrapDegrees(var12 - I_field_3a9bda27.player.getPitch())
      };
   }
}
