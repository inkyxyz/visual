package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.jetbrains.annotations.Nullable;

public final class iiiiIIIii_Class484 implements iiiiIIiII_Class485 {
   private static final int I_field_49 = 48;
   private static final double I_field_44 = 6.0;
   private final Block I_field_d9031850;
   private final Set<Item> I_field_a56a8dc5;
   @Nullable
   private BlockPos I_field_670402ba;
   @Nullable
   private iiiiIIIiI_Class483 I_field_95332aac;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private final iiiIIIIIi_Class450 I_field_f86b4e4c = new iiiIIIIIi_Class450();
   private boolean II_field_5a;
   private boolean Ii_field_5a;
   private int i_field_49;
   private final Set<BlockPos> i_field_a56a8dc5 = new HashSet<>();
   private final Set<Integer> II_field_a56a8dc5 = new HashSet<>();
   @Nullable
   private Integer I_field_ac3e75fd;

   public iiiiIIIii_Class484(Block var1) {
      this.I_field_d9031850 = var1;
      this.I_field_a56a8dc5 = I_method_78b89e1a(var1);
   }

   private static Set<Item> I_method_78b89e1a(Block var0) {
      HashSet var1 = new HashSet();
      Item var2 = var0.asItem();
      if (var2 != Items.AIR) {
         var1.add(var2);
      }

      if (var0 == Blocks.STONE) {
         var1.add(Items.COBBLESTONE);
      } else if (var0 == Blocks.DEEPSLATE) {
         var1.add(Items.COBBLED_DEEPSLATE);
      } else if (var0 == Blocks.GRASS_BLOCK || var0 == Blocks.DIRT_PATH || var0 == Blocks.FARMLAND) {
         var1.add(Items.DIRT);
      } else if (var0 == Blocks.COAL_ORE || var0 == Blocks.DEEPSLATE_COAL_ORE) {
         var1.add(Items.COAL);
      } else if (var0 == Blocks.IRON_ORE || var0 == Blocks.DEEPSLATE_IRON_ORE) {
         var1.add(Items.RAW_IRON);
      } else if (var0 == Blocks.COPPER_ORE || var0 == Blocks.DEEPSLATE_COPPER_ORE) {
         var1.add(Items.RAW_COPPER);
      } else if (var0 == Blocks.GOLD_ORE || var0 == Blocks.DEEPSLATE_GOLD_ORE) {
         var1.add(Items.RAW_GOLD);
      } else if (var0 == Blocks.NETHER_GOLD_ORE) {
         var1.add(Items.GOLD_NUGGET);
      } else if (var0 == Blocks.NETHER_QUARTZ_ORE) {
         var1.add(Items.QUARTZ);
      } else if (var0 == Blocks.DIAMOND_ORE || var0 == Blocks.DEEPSLATE_DIAMOND_ORE) {
         var1.add(Items.DIAMOND);
      } else if (var0 == Blocks.EMERALD_ORE || var0 == Blocks.DEEPSLATE_EMERALD_ORE) {
         var1.add(Items.EMERALD);
      } else if (var0 == Blocks.LAPIS_ORE || var0 == Blocks.DEEPSLATE_LAPIS_ORE) {
         var1.add(Items.LAPIS_LAZULI);
      } else if (var0 == Blocks.REDSTONE_ORE || var0 == Blocks.DEEPSLATE_REDSTONE_ORE) {
         var1.add(Items.REDSTONE);
      }

      return var1;
   }

   @Override
   public String I_method_31075c81() {
      return "mine " + Block.getRawIdFromState(this.I_field_d9031850.getDefaultState());
   }

   @Override
   public String i_method_c4260ca1() {
      if (this.II_field_5a) {
         return "\u043f\u0430\u0443\u0437\u0430";
      } else if (this.i_field_5a) {
         return "\u043a\u043e\u043f\u0430\u0435\u043c " + this.I_field_670402ba;
      } else if (this.I_field_5a) {
         return "\u043f\u043e\u0434\u0431\u0438\u0440\u0430\u0435\u043c \u0434\u0440\u043e\u043f\u044b";
      } else {
         return this.I_field_95332aac != null
            ? "\u0438\u0434\u0451\u043c \u043a " + this.I_field_670402ba + " (" + this.I_field_95332aac.i_method_c4260ca1() + ")"
            : "\u0438\u0449\u0435\u043c \u0431\u043b\u043e\u043a";
      }
   }

   @Override
   public boolean I_method_8f3b7603() {
      if (this.II_field_5a) {
         return false;
      } else if (this.Ii_field_5a) {
         return true;
      } else {
         MinecraftClient var1 = MinecraftClient.getInstance();
         if (var1.player != null && var1.world != null && var1.interactionManager != null) {
            iiIiiIiII_Class437.I_method_d9acc61f();
            if (this.i_field_5a && this.I_field_670402ba != null) {
               if (var1.world.getBlockState(this.I_field_670402ba).getBlock() != this.I_field_d9031850) {
                  this.i_field_5a = false;
                  this.I_field_670402ba = null;
                  this.Ii_method_a0331ce2();
                  return false;
               } else {
                  Vec3d var7 = Vec3d.ofCenter(this.I_field_670402ba);
                  double var11 = var1.player.getEyePos().distanceTo(var7);
                  if (var11 > 5.0) {
                     this.i_field_5a = false;
                     this.Ii_method_a0331ce2();
                     this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(this.I_field_670402ba, 2));
                     this.I_field_5a = false;
                     return false;
                  } else if (!I_method_9b1edb24(var1, this.I_field_670402ba)) {
                     this.i_field_5a = false;
                     this.Ii_method_a0331ce2();
                     this.i_field_49++;
                     if (this.i_field_49 >= 3) {
                        this.i_field_a56a8dc5.add(this.I_field_670402ba);
                        this.I_field_670402ba = null;
                        this.i_field_49 = 0;
                        return false;
                     } else {
                        this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(this.I_field_670402ba, 1));
                        this.I_field_5a = false;
                        return false;
                     }
                  } else {
                     this.i_field_49 = 0;
                     iiiIIIIII_Class449.I_method_98560fd8(var1.world.getBlockState(this.I_field_670402ba));
                     Direction var13 = this.I_method_48f35580(var1, this.I_field_670402ba);
                     if (!this.I_field_f86b4e4c.I_method_b97a0d1b(this.I_field_670402ba, var13)) {
                        return false;
                     } else {
                        var1.interactionManager.updateBlockBreakingProgress(this.I_field_670402ba, var13);
                        var1.player.swingHand(var1.player.getActiveHand());
                        return false;
                     }
                  }
               }
            } else if (this.I_field_95332aac != null) {
               boolean var6 = this.I_field_95332aac.I_method_8f3b7603();
               if (var6) {
                  this.I_field_95332aac = null;
                  if (this.I_field_5a) {
                     if (this.I_field_ac3e75fd != null && var1.world.getEntityById(this.I_field_ac3e75fd) instanceof ItemEntity var12 && var12.isAlive()) {
                        this.II_field_a56a8dc5.add(this.I_field_ac3e75fd);
                     }

                     this.I_field_ac3e75fd = null;
                     this.I_field_5a = false;
                  } else if (this.I_field_670402ba != null) {
                     double var10 = var1.player.getEyePos().distanceTo(Vec3d.ofCenter(this.I_field_670402ba));
                     if (var10 > 5.0) {
                        this.i_field_a56a8dc5.add(this.I_field_670402ba);
                        this.I_field_670402ba = null;
                     } else {
                        this.i_field_5a = true;
                     }
                  }
               }

               return false;
            } else {
               ItemEntity var2 = this.I_method_ba079dc9(var1);
               if (var2 != null) {
                  BlockPos var8 = var2.getBlockPos();
                  this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(var8, 1));
                  this.I_field_5a = true;
                  this.I_field_ac3e75fd = var2.getId();
                  return false;
               } else {
                  BlockPos var3 = this.I_method_bdd407ea(var1);
                  if (var3 == null) {
                     iiiIIIIii_Class452.I_method_15375629(
                        "\u0411\u043b\u043e\u043a "
                           + this.I_field_d9031850
                           + " \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d \u043f\u043e\u0431\u043b\u0438\u0437\u043e\u0441\u0442\u0438"
                     );
                     this.I_method_8f3b75ff();
                     this.Ii_field_5a = true;
                     return true;
                  } else {
                     this.I_field_670402ba = var3;
                     Vec3d var4 = Vec3d.ofCenter(var3);
                     boolean var5 = var1.player.getEyePos().distanceTo(var4) <= 4.5;
                     if (var5 && I_method_9b1edb24(var1, var3)) {
                        this.i_field_5a = true;
                     } else {
                        this.I_field_95332aac = new iiiiIIIiI_Class483(new iiiIIiiII_Class461(var3, 2));
                     }

                     return false;
                  }
               }
            }
         } else {
            return false;
         }
      }
   }

   private static boolean I_method_9b1edb24(MinecraftClient var0, BlockPos var1) {
      if (var0.world != null && var0.player != null) {
         Vec3d var2 = var0.player.getEyePos();
         Vec3d var3 = Vec3d.ofCenter(var1);
         Vec3d[] var4 = new Vec3d[]{
            var3,
            var3.add(0.49, 0.0, 0.0),
            var3.add(-0.49, 0.0, 0.0),
            var3.add(0.0, 0.49, 0.0),
            var3.add(0.0, -0.49, 0.0),
            var3.add(0.0, 0.0, 0.49),
            var3.add(0.0, 0.0, -0.49)
         };

         for (Vec3d var8 : var4) {
            RaycastContext var9 = new RaycastContext(var2, var8, ShapeType.COLLIDER, FluidHandling.NONE, var0.player);
            BlockHitResult var10 = var0.world.raycast(var9);
            if (var10.getType() != Type.BLOCK) {
               return true;
            }

            if (var10.getBlockPos().equals(var1)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   @Nullable
   private ItemEntity I_method_ba079dc9(MinecraftClient var1) {
      if (var1.world == null || var1.player == null) {
         return null;
      } else if (this.I_field_a56a8dc5.isEmpty()) {
         return null;
      } else {
         Vec3d var2 = var1.player.getPos();
         Box var3 = Box.of(var2, 12.0, 12.0, 12.0);
         List var4 = var1.world
            .getEntitiesByClass(
               ItemEntity.class,
               var3,
               var1x -> var1x.isAlive()
                  && !var1x.cannotPickup()
                  && !this.II_field_a56a8dc5.contains(var1x.getId())
                  && this.I_field_a56a8dc5.contains(var1x.getStack().getItem())
            );
         if (var4.isEmpty()) {
            return null;
         } else {
            var4.sort(Comparator.comparingDouble(var1x -> ((net.minecraft.entity.Entity)var1x).getPos().squaredDistanceTo(var2)));
            return (ItemEntity)var4.get(0);
         }
      }
   }

   private Direction I_method_48f35580(MinecraftClient var1, BlockPos var2) {
      Vec3d var3 = var1.player.getEyePos();
      Direction var4 = Direction.UP;
      double var5 = -1.0;

      for (Direction var10 : Direction.values()) {
         Vec3d var11 = Vec3d.ofCenter(var2).add(var10.getOffsetX() * 0.5, var10.getOffsetY() * 0.5, var10.getOffsetZ() * 0.5);
         Vec3d var12 = var11.subtract(var3).normalize();
         double var13 = var12.x * var10.getOffsetX() + var12.y * var10.getOffsetY() + var12.z * var10.getOffsetZ();
         double var15 = -var13;
         if (var15 > var5) {
            var5 = var15;
            var4 = var10;
         }
      }

      return var4;
   }

   private void Ii_method_a0331ce2() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.interactionManager != null) {
         var1.interactionManager.cancelBlockBreaking();
      }
   }

   @Nullable
   private BlockPos I_method_bdd407ea(MinecraftClient var1) {
      if (var1.world != null && var1.player != null) {
         BlockPos var2 = var1.player.getBlockPos();
         BlockPos var3 = var2.down();
         if (var1.world.getBlockState(var3).getBlock() == this.I_field_d9031850 && !this.i_field_a56a8dc5.contains(var3)) {
            return var3;
         } else {
            Mutable var4 = new Mutable();
            ArrayList<BlockPos> var5 = new ArrayList<>();

            for (int var6 = -48; var6 <= 48; var6++) {
               for (int var7 = -48; var7 <= 48; var7++) {
                  for (int var8 = -24; var8 <= 24; var8++) {
                     var4.set(var2.getX() + var6, var2.getY() + var8, var2.getZ() + var7);
                     if (var1.world.getBlockState(var4).getBlock() == this.I_field_d9031850 && !this.i_field_a56a8dc5.contains(var4)) {
                        var5.add(var4.toImmutable());
                     }
                  }
               }
            }

            if (var5.isEmpty()) {
               return null;
            } else {
               Vec3d var9 = var1.player.getEyePos();
               var5.sort(Comparator.comparingDouble(var1x -> Vec3d.ofCenter(var1x).squaredDistanceTo(var9)));
               return (BlockPos)var5.get(0);
            }
         }
      } else {
         return null;
      }
   }

   @Override
   public void I_method_8f3b75ff() {
      if (this.I_field_95332aac != null) {
         this.I_field_95332aac.I_method_8f3b75ff();
         this.I_field_95332aac = null;
      }

      this.Ii_method_a0331ce2();
      iiIiiiiii_Class448 var1 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
      var1.i_method_35abae1f();
      this.I_field_670402ba = null;
      this.i_field_5a = false;
      this.I_field_5a = false;
   }

   @Override
   public void i_method_8f4a01df() {
      this.II_field_5a = true;
      if (this.I_field_95332aac != null) {
         this.I_field_95332aac.i_method_8f4a01df();
      }

      this.Ii_method_a0331ce2();
      iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5().i_method_35abae1f();
   }

   @Override
   public void II_method_58424142() {
      this.II_field_5a = false;
      if (this.I_field_95332aac != null) {
         this.I_field_95332aac.II_method_58424142();
      }
   }

   @Override
   public boolean i_method_8f4a01e3() {
      return this.II_field_5a;
   }

   @Override
   public boolean II_method_58424146() {
      return this.Ii_field_5a;
   }

   @Generated
   public Block I_method_d5ad44f9() {
      return this.I_field_d9031850;
   }
}
