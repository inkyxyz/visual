package rockstar.client;

import it.unimi.dsi.fastutil.longs.Long2ByteOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.EmptyBlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public final class iiiIIIiIi_Class454 {
   private static final double i_field_44 = 1.0E-7;
   private static final double II_field_44 = 0.3;
   private static final double Ii_field_44 = 1.8;
   private static final double iI_field_44 = 0.6;
   private static final double ii_field_44 = 1.05;
   public static final double I_field_44 = Double.NaN;
   private static final byte I_field_42 = 1;
   private static final byte i_field_42 = 2;
   private static final byte II_field_42 = 4;
   private static final byte Ii_field_42 = 8;
   private static final byte iI_field_42 = 16;
   private static final byte ii_field_42 = 32;
   private static final byte III_field_42 = 64;
   @Nullable
   private final World I_field_99614b46;
   private final BlockView I_field_58aeb386;
   private final iiiIIIiIi_Class454.Nested1_98b338a0 I_field_c16bb1e7;
   private final boolean I_field_5a;
   private final Mutable I_field_4adf8198 = new Mutable();
   private final Long2ObjectOpenHashMap<BlockState> I_field_89963af3 = new Long2ObjectOpenHashMap(4096);
   private final Long2ByteOpenHashMap I_field_7ed9367c = new Long2ByteOpenHashMap(4096);
   private final Long2DoubleOpenHashMap I_field_cac2c885 = new Long2DoubleOpenHashMap(4096);

   public iiiIIIiIi_Class454() {
      ClientWorld var1 = MinecraftClient.getInstance().world;
      if (var1 == null) {
         throw new IllegalStateException("Pathfinder cannot run without a loaded world");
      } else {
         this.I_field_99614b46 = var1;
         this.I_field_58aeb386 = var1;
         Mutable var2 = new Mutable();
         this.I_field_c16bb1e7 = (var2x, var3, var4) -> var1.getBlockState(var2.set(var2x, var3, var4));
         this.I_field_5a = true;
         this.I_field_cac2c885.defaultReturnValue(Double.MAX_VALUE);
      }
   }

   public iiiIIIiIi_Class454(iiiIIIiIi_Class454.Nested1_98b338a0 var1) {
      this.I_field_99614b46 = null;
      this.I_field_58aeb386 = EmptyBlockView.INSTANCE;
      this.I_field_c16bb1e7 = var1;
      this.I_field_5a = false;
      this.I_field_cac2c885.defaultReturnValue(Double.MAX_VALUE);
   }

   public boolean I_method_e0b809e3() {
      return this.I_field_5a;
   }

   @Nullable
   public World I_method_a120b8f() {
      return this.I_field_99614b46;
   }

   public BlockState I_method_c9fa9127(int var1, int var2, int var3) {
      long var4 = BlockPos.asLong(var1, var2, var3);
      BlockState var6 = (BlockState)this.I_field_89963af3.get(var4);
      if (var6 != null) {
         return var6;
      } else {
         BlockState var7 = this.I_field_c16bb1e7.state(var1, var2, var3);
         this.I_field_89963af3.put(var4, var7);
         return var7;
      }
   }

   private byte I_method_ca82d450(int var1, int var2, int var3) {
      long var4 = BlockPos.asLong(var1, var2, var3);
      byte var6 = this.I_field_7ed9367c.get(var4);
      if ((var6 & 1) != 0) {
         return var6;
      } else {
         BlockState var7 = this.I_method_c9fa9127(var1, var2, var3);
         var6 = 1;
         FluidState var8 = var7.getFluidState();
         Fluid var9 = var8.getFluid();
         boolean var10 = var9 == Fluids.WATER || var9 == Fluids.FLOWING_WATER;
         boolean var11 = var9 == Fluids.LAVA || var9 == Fluids.FLOWING_LAVA;
         if (var10) {
            var6 = (byte)(var6 | 8);
         }

         if (I_method_a667bf98(var7)) {
            var6 = (byte)(var6 | 16);
         }

         if (var11
            || var7.isOf(Blocks.LAVA)
            || var7.isOf(Blocks.FIRE)
            || var7.isOf(Blocks.SOUL_FIRE)
            || var7.isOf(Blocks.MAGMA_BLOCK)
            || var7.isOf(Blocks.CACTUS)
            || var7.isOf(Blocks.CAMPFIRE)
            || var7.isOf(Blocks.SOUL_CAMPFIRE)) {
            var6 = (byte)(var6 | 32);
         }

         if (var7.isOf(Blocks.COBWEB) || var7.isOf(Blocks.POWDER_SNOW) || var7.isOf(Blocks.SWEET_BERRY_BUSH) || var7.isOf(Blocks.WITHER_ROSE)) {
            var6 = (byte)(var6 | 64);
         }

         this.I_field_4adf8198.set(var1, var2, var3);
         VoxelShape var12 = var7.getCollisionShape(this.I_field_58aeb386, this.I_field_4adf8198);
         if (var12.isEmpty()) {
            var6 = (byte)(var6 | 2);
         } else if (Block.isShapeFullCube(var12)) {
            var6 = (byte)(var6 | 4);
         }

         this.I_field_7ed9367c.put(var4, var6);
         return var6;
      }
   }

   private static boolean I_method_a667bf98(BlockState var0) {
      if (!var0.isOf(Blocks.LADDER)
         && !var0.isOf(Blocks.VINE)
         && !var0.isOf(Blocks.SCAFFOLDING)
         && !var0.isOf(Blocks.TWISTING_VINES)
         && !var0.isOf(Blocks.TWISTING_VINES_PLANT)
         && !var0.isOf(Blocks.WEEPING_VINES)
         && !var0.isOf(Blocks.WEEPING_VINES_PLANT)
         && !var0.isOf(Blocks.CAVE_VINES)
         && !var0.isOf(Blocks.CAVE_VINES_PLANT)) {
         try {
            return var0.isIn(BlockTags.CLIMBABLE);
         } catch (Throwable var2) {
            return false;
         }
      } else {
         return true;
      }
   }

   public boolean I_method_ca82d468(int var1, int var2, int var3) {
      byte var4 = this.I_method_ca82d450(var1, var2, var3);
      if ((var4 & 2) == 0) {
         return false;
      } else {
         return (var4 & 96) != 0 ? false : (var4 & 8) == 0 && this.I_method_c9fa9127(var1, var2, var3).getFluidState().isEmpty();
      }
   }

   public boolean i_method_674a3c88(int var1, int var2, int var3) {
      byte var4 = this.I_method_ca82d450(var1, var2, var3);
      return (var4 & 2) != 0 ? false : !this.I_method_c9fa9127(var1, var2, var3).isOf(Blocks.LAVA);
   }

   public boolean II_method_1f35e205(int var1, int var2, int var3) {
      return (this.I_method_ca82d450(var1, var2, var3) & 8) != 0;
   }

   public boolean Ii_method_bbfd4a25(int var1, int var2, int var3) {
      if ((this.I_method_ca82d450(var1, var2, var3) & 8) == 0) {
         return false;
      } else {
         return (this.I_method_ca82d450(var1, var2 + 1, var3) & 8) != 0 ? true : this.I_method_c9fa9127(var1, var2, var3).getFluidState().getLevel() >= 7;
      }
   }

   public boolean iI_method_1b5b7de5(int var1, int var2, int var3) {
      return (this.I_method_ca82d450(var1, var2, var3) & 16) != 0;
   }

   public boolean ii_method_b822e605(int var1, int var2, int var3) {
      return (this.I_method_ca82d450(var1, var2, var3) & 32) != 0;
   }

   public boolean III_method_60e48808(int var1, int var2, int var3) {
      return (this.I_method_ca82d450(var1, var2, var3) & 64) != 0;
   }

   public boolean IIi_method_fdabf028(int var1, int var2, int var3) {
      byte var4 = this.I_method_ca82d450(var1, var2, var3);
      return (var4 & 96) != 0 ? false : (var4 & 10) != 0 || (var4 & 16) != 0;
   }

   public double I_method_ca82d452(int var1, int var2, int var3) {
      long var4 = BlockPos.asLong(var1, var2, var3);
      double var6 = this.I_field_cac2c885.get(var4);
      if (var6 != Double.MAX_VALUE) {
         return var6;
      } else {
         double var8 = this.II_method_1f35e1ef(var1, var2, var3);
         this.I_field_cac2c885.put(var4, var8);
         return var8;
      }
   }

   private double II_method_1f35e1ef(int var1, int var2, int var3) {
      byte var4 = this.I_method_ca82d450(var1, var2, var3);
      if ((var4 & 96) != 0) {
         return Double.NaN;
      } else {
         boolean var7 = (var4 & 2) == 0 && (var4 & 16) == 0;
         double var5;
         if (var7) {
            double var8 = this.Ii_method_bbfd4a0f(var1, var2, var3);
            if (var8 > 0.6) {
               return Double.NaN;
            }

            var5 = var2 + var8;
         } else {
            byte var12 = this.I_method_ca82d450(var1, var2 - 1, var3);
            if ((var12 & 32) != 0) {
               return Double.NaN;
            }

            if ((var12 & 2) != 0 || (var12 & 16) != 0) {
               return Double.NaN;
            }

            double var9;
            if ((var12 & 4) != 0) {
               var9 = 1.0;
            } else {
               var9 = this.Ii_method_bbfd4a0f(var1, var2 - 1, var3);
               if (var9 <= 0.6 || var9 > 1.05) {
                  return Double.NaN;
               }
            }

            var5 = var2 - 1 + Math.min(var9, 1.0);
         }

         double var13 = var1 + 0.5;
         double var10 = var3 + 0.5;
         return !this.I_method_c9a00b69(new Box(var13 - 0.3, var5 + 0.02, var10 - 0.3, var13 + 0.3, var5 + 1.8, var10 + 0.3)) ? Double.NaN : var5;
      }
   }

   private double Ii_method_bbfd4a0f(int var1, int var2, int var3) {
      this.I_field_4adf8198.set(var1, var2, var3);
      VoxelShape var4 = this.I_method_c9fa9127(var1, var2, var3).getCollisionShape(this.I_field_58aeb386, this.I_field_4adf8198);
      return var4.isEmpty() ? 0.0 : var4.getMax(Axis.Y);
   }

   public boolean IiI_method_5d0a23e8(int var1, int var2, int var3) {
      return !Double.isNaN(this.I_method_ca82d452(var1, var2, var3));
   }

   public boolean Iii_method_f9d18c08(int var1, int var2, int var3) {
      if (!this.iI_method_1b5b7de5(var1, var2, var3)) {
         return false;
      } else {
         double var4 = var1 + 0.5;
         double var6 = var3 + 0.5;
         return this.I_method_c9a00b69(new Box(var4 - 0.3, var2 + 0.02, var6 - 0.3, var4 + 0.3, var2 + 1.8, var6 + 0.3));
      }
   }

   public iiiIIIiIi_Class454.Nested1_98b338c0 I_method_8708d5(int var1, int var2, int var3) {
      if (this.IiI_method_5d0a23e8(var1, var2, var3)) {
         return iiiIIIiIi_Class454.Nested1_98b338c0.i_field_c16bb5c7;
      } else if (this.Iii_method_f9d18c08(var1, var2, var3)) {
         return iiiIIIiIi_Class454.Nested1_98b338c0.II_field_c16bb5c7;
      } else {
         return this.Ii_method_bbfd4a25(var1, var2, var3)
            ? iiiIIIiIi_Class454.Nested1_98b338c0.Ii_field_c16bb5c7
            : iiiIIIiIi_Class454.Nested1_98b338c0.I_field_c16bb5c7;
      }
   }

   public boolean I_method_c9a00b69(Box var1) {
      int var2 = I_method_36499232(var1.minX);
      int var3 = I_method_36499232(var1.minY);
      int var4 = I_method_36499232(var1.minZ);
      int var5 = i_method_380c8252(var1.maxX);
      int var6 = i_method_380c8252(var1.maxY);
      int var7 = i_method_380c8252(var1.maxZ);

      for (int var8 = var2; var8 <= var5; var8++) {
         for (int var9 = var3; var9 <= var6; var9++) {
            for (int var10 = var4; var10 <= var7; var10++) {
               byte var11 = this.I_method_ca82d450(var8, var9, var10);
               if ((var11 & 96) != 0) {
                  return false;
               }

               if ((var11 & 2) == 0 && (var11 & 16) == 0) {
                  if ((var11 & 4) != 0) {
                     return false;
                  }

                  this.I_field_4adf8198.set(var8, var9, var10);
                  BlockState var12 = this.I_method_c9fa9127(var8, var9, var10);

                  for (Box var14 : var12.getCollisionShape(this.I_field_58aeb386, this.I_field_4adf8198).getBoundingBoxes()) {
                     if (var14.offset(var8, var9, var10).intersects(var1)) {
                        return false;
                     }
                  }
               }
            }
         }
      }

      return true;
   }

   public boolean I_method_7085e723(int var1, int var2, int var3, int var4, double var5, double var7) {
      double var9 = var1 + 0.5;
      double var11 = var2 + 0.5;
      double var13 = var3 + 0.5;
      double var15 = var4 + 0.5;
      return this.I_method_c9a00b69(
         new Box(Math.min(var9, var13) - 0.3, var5, Math.min(var11, var15) - 0.3, Math.max(var9, var13) + 0.3, var7, Math.max(var11, var15) + 0.3)
      );
   }

   public double i_method_674a3c72(int var1, int var2, int var3) {
      for (int var4 = -1; var4 <= 1; var4++) {
         for (int var5 = -1; var5 <= 1; var5++) {
            if ((var4 != 0 || var5 != 0)
               && (this.ii_method_b822e605(var1 + var4, var2, var3 + var5) || this.ii_method_b822e605(var1 + var4, var2 - 1, var3 + var5))) {
               return 8.0;
            }
         }
      }

      return !this.ii_method_b822e605(var1, var2 - 1, var3) && !this.ii_method_b822e605(var1, var2 - 2, var3) ? 0.0 : 8.0;
   }

   public boolean iII_method_e9726828(int var1, int var2, int var3) {
      for (int var4 = -1; var4 <= 1; var4++) {
         for (int var5 = -1; var5 <= 1; var5++) {
            for (int var6 = -1; var6 <= 1; var6++) {
               if ((var4 != 0 || var5 != 0 || var6 != 0) && this.ii_method_b822e605(var1 + var4, var2 + var5, var3 + var6)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public int I_method_ca82d457(int var1, int var2, int var3) {
      if (!this.I_field_5a) {
         return Integer.MAX_VALUE;
      } else {
         BlockState var4 = this.I_method_c9fa9127(var1, var2, var3);
         if (var4.isAir()) {
            return 0;
         } else if (this.ii_method_b822e605(var1, var2, var3)) {
            return Integer.MAX_VALUE;
         } else if (var4.isReplaceable() && var4.getFluidState().isEmpty()) {
            return 0;
         } else if (!var4.getFluidState().isEmpty()) {
            return Integer.MAX_VALUE;
         } else {
            this.I_field_4adf8198.set(var1, var2, var3);
            if (var4.getCollisionShape(this.I_field_58aeb386, this.I_field_4adf8198).isEmpty() && !this.III_method_60e48808(var1, var2, var3)) {
               return 0;
            } else {
               int var5 = iiiIIIIiI_Class451.I_method_b874f7e7(var4);
               return var5 > 200 ? Integer.MAX_VALUE : var5;
            }
         }
      }
   }

   public int I_method_70883fb2(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (!this.I_field_5a) {
         return Integer.MAX_VALUE;
      } else {
         BlockState var7 = this.I_method_c9fa9127(var4, var5, var6);
         if (var7.isAir()) {
            return 0;
         } else if (this.ii_method_b822e605(var4, var5, var6)) {
            return Integer.MAX_VALUE;
         } else if (var7.isReplaceable() && var7.getFluidState().isEmpty()) {
            return 0;
         } else if (!var7.getFluidState().isEmpty()) {
            return Integer.MAX_VALUE;
         } else {
            this.I_field_4adf8198.set(var4, var5, var6);
            if (!i_method_f310c457(this.I_field_99614b46, var7, this.I_field_4adf8198, var1, var2, var3) && !this.III_method_60e48808(var4, var5, var6)) {
               return 0;
            } else {
               int var8 = iiiIIIIiI_Class451.I_method_b874f7e7(var7);
               return var8 > 200 ? Integer.MAX_VALUE : var8;
            }
         }
      }
   }

   public boolean iIi_method_8639d048(int var1, int var2, int var3) {
      Box var4 = I_method_fd1a4ef8(var1, var2, var3);
      int var5 = I_method_36499232(var4.minX);
      int var6 = I_method_36499232(var4.minY);
      int var7 = I_method_36499232(var4.minZ);
      int var8 = i_method_380c8252(var4.maxX);
      int var9 = i_method_380c8252(var4.maxY);
      int var10 = i_method_380c8252(var4.maxZ);

      for (int var11 = var5; var11 <= var8; var11++) {
         for (int var12 = var6; var12 <= var9; var12++) {
            for (int var13 = var7; var13 <= var10; var13++) {
               this.I_field_4adf8198.set(var11, var12, var13);
               BlockState var14 = this.I_method_c9fa9127(var11, var12, var13);
               if (!var14.isAir() && !var14.isReplaceable()) {
                  if (!var14.getFluidState().isEmpty()) {
                     return false;
                  }

                  if (I_method_d95ddab8(this.I_field_58aeb386, var14, this.I_field_4adf8198, var4)) {
                     return false;
                  }
               }
            }
         }
      }

      return true;
   }

   public static boolean I_method_c621a877(BlockView var0, BlockState var1, BlockPos var2, int var3, int var4, int var5) {
      if (var1.isAir()) {
         return true;
      } else if (var1.isReplaceable()) {
         return true;
      } else {
         return !var1.getFluidState().isEmpty() ? false : !i_method_f310c457(var0, var1, var2, var3, var4, var5);
      }
   }

   public static boolean i_method_f310c457(BlockView var0, BlockState var1, BlockPos var2, int var3, int var4, int var5) {
      return I_method_d95ddab8(var0, var1, var2, I_method_fd1a4ef8(var3, var4, var5));
   }

   private static boolean I_method_d95ddab8(BlockView var0, BlockState var1, BlockPos var2, Box var3) {
      for (Box var5 : var1.getCollisionShape(var0, var2).getBoundingBoxes()) {
         if (var5.offset(var2).intersects(var3)) {
            return true;
         }
      }

      return false;
   }

   private static Box I_method_fd1a4ef8(int var0, int var1, int var2) {
      double var3 = var0 + 0.5;
      double var5 = var2 + 0.5;
      return new Box(var3 - 0.3, var1, var5 - 0.3, var3 + 0.3, var1 + 1.8, var5 + 0.3);
   }

   private static int I_method_36499232(double var0) {
      return (int)Math.floor(var0);
   }

   private static int i_method_380c8252(double var0) {
      return (int)Math.floor(var0 - 1.0E-7);
   }

   public interface Nested1_98b338a0 {
      BlockState state(int var1, int var2, int var3);
   }

   public static enum Nested1_98b338c0 {
      I_field_c16bb5c7,
      i_field_c16bb5c7,
      II_field_c16bb5c7,
      Ii_field_c16bb5c7;

      public static iiiIIIiIi_Class454.Nested1_98b338c0[] I_method_b64da728() {
         return values();
      }

      public static iiiIIIiIi_Class454.Nested1_98b338c0 I_method_6d7f06b5(String var0) {
         return Enum.valueOf(iiiIIIiIi_Class454.Nested1_98b338c0.class, var0);
      }
   }
}
