package rockstar.client;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.world.ClientChunkManager;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.LightType;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.WorldChunk;
import pyrock.events.game.WorldChangeEvent;

@ModuleInfo(
   name = "Base Finder",
   category = ModuleCategory.OTHER
)
public class BaseFinderModule extends Module {
   private static final int I_field_49 = 7;
   private static final int i_field_49 = 2;
   private static final int II_field_49 = 10;
   private static final int Ii_field_49 = 2;
   private static final int iI_field_49 = 48;
   private static final int ii_field_49 = 2304;
   private static final int III_field_49 = 4;
   private static final int IIi_field_49 = 6;
   private static final Set<Block> I_field_a56a8dc5 = Set.of(
      Blocks.AMETHYST_CLUSTER,
      Blocks.LARGE_AMETHYST_BUD,
      Blocks.MEDIUM_AMETHYST_BUD,
      Blocks.SMALL_AMETHYST_BUD,
      Blocks.GLOW_LICHEN,
      Blocks.REDSTONE_TORCH,
      Blocks.REDSTONE_WALL_TORCH
   );
   private final ArrayDeque<Long> I_field_f27e4628 = new ArrayDeque<>();
   private final Set<Long> i_field_a56a8dc5 = new HashSet<>();
   private final Set<Long> II_field_a56a8dc5 = new HashSet<>();
   private final List<BaseFinderModule.Nested1_1f390040> I_field_7865b31 = new ArrayList<>();
   private int IiI_field_49;
   private int Iii_field_49 = 1;
   private final IiIIIiII_Class69<WorldChangeEvent> I_field_3d936f41 = var1 -> {
      this.IiI_method_84e6bf();
      this.II_method_ef7120f5();
   };

   @Override
   public void onEnable() {
      this.IiI_method_84e6bf();
      super.onEnable();
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         int var1 = I_field_3a9bda27.player.getChunkPos().x;
         int var2 = I_field_3a9bda27.player.getChunkPos().z;
         int var3 = this.Ii_method_ef7facd5();
         if (this.IiI_field_49++ % 5 == 0 || this.I_field_f27e4628.isEmpty()) {
            this.I_method_a13c6404(var1, var2, var3);
            this.II_method_1fae4661(var1, var2, var3 + 2);
         }

         this.i_method_3e03cc24(var1, var2, var3 + 2);
         super.II_method_6642fd22();
      }
   }

   public List<BaseFinderModule.Nested1_1f390040> I_method_436a0e28() {
      synchronized (this.I_field_7865b31) {
         return List.copyOf(this.I_field_7865b31);
      }
   }

   public int II_method_ef7120f5() {
      synchronized (this.I_field_7865b31) {
         int var2 = this.I_field_7865b31.size();
         this.I_field_7865b31.clear();
         this.Iii_field_49 = 1;
         return var2;
      }
   }

   public BaseFinderModule.Nested1_1f390040 I_method_5a6c99ba(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String var2 = this.i_method_9d6fc197(var1);
         synchronized (this.I_field_7865b31) {
            for (int var4 = 0; var4 < this.I_field_7865b31.size(); var4++) {
               BaseFinderModule.Nested1_1f390040 var5 = this.I_field_7865b31.get(var4);
               if (this.i_method_9d6fc197(var5.I_method_c253ec66()).equals(var2)) {
                  return this.I_field_7865b31.remove(var4);
               }
            }

            return null;
         }
      } else {
         return null;
      }
   }

   public BaseFinderModule.Nested1_1f390040 I_method_c93ef96a(BlockPos var1) {
      if (var1 == null) {
         return null;
      } else {
         synchronized (this.I_field_7865b31) {
            for (int var3 = 0; var3 < this.I_field_7865b31.size(); var3++) {
               BaseFinderModule.Nested1_1f390040 var4 = this.I_field_7865b31.get(var3);
               if (var4.I_method_4e05cc16().equals(var1)) {
                  return this.I_field_7865b31.remove(var3);
               }
            }

            return null;
         }
      }
   }

   private void I_method_a13c6404(int var1, int var2, int var3) {
      if (I_field_3a9bda27.world != null) {
         ClientChunkManager var4 = I_field_3a9bda27.world.getChunkManager();

         for (int var5 = 0; var5 <= var3; var5++) {
            for (int var6 = -var5; var6 <= var5; var6++) {
               for (int var7 = -var5; var7 <= var5; var7++) {
                  if (Math.max(Math.abs(var6), Math.abs(var7)) == var5) {
                     this.I_method_6a6d1aa(var4, var1 + var6, var2 + var7);
                  }
               }
            }
         }
      }
   }

   private void I_method_6a6d1aa(ClientChunkManager var1, int var2, int var3) {
      long var4 = ChunkPos.toLong(var2, var3);
      if (!this.II_field_a56a8dc5.contains(var4) && !this.i_field_a56a8dc5.contains(var4)) {
         if (I_field_3a9bda27.world.isChunkLoaded(var2, var3)) {
            if (var1.getChunk(var2, var3, ChunkStatus.FULL, false) != null) {
               this.I_field_f27e4628.addLast(var4);
               this.i_field_a56a8dc5.add(var4);
            }
         }
      }
   }

   private void i_method_3e03cc24(int var1, int var2, int var3) {
      if (I_field_3a9bda27.world != null) {
         ClientChunkManager var4 = I_field_3a9bda27.world.getChunkManager();
         int var5 = 0;

         while (var5 < 2 && !this.I_field_f27e4628.isEmpty()) {
            long var6 = this.I_field_f27e4628.removeFirst();
            this.i_field_a56a8dc5.remove(var6);
            if (this.I_method_88056822(var6, var1, var2, var3)) {
               int var8 = ChunkPos.getPackedX(var6);
               int var9 = ChunkPos.getPackedZ(var6);
               WorldChunk var10 = var4.getChunk(var8, var9, ChunkStatus.FULL, false);
               if (var10 != null) {
                  this.I_method_83f44500(var10);
                  this.II_field_a56a8dc5.add(var6);
                  var5++;
               }
            }
         }
      }
   }

   private void I_method_83f44500(WorldChunk var1) {
      if (I_field_3a9bda27.world != null) {
         int var2 = var1.getPos().getStartX();
         int var3 = var1.getPos().getStartZ();
         int var4 = var1.getBottomY();
         int var5 = var4 + var1.getHeight();
         Mutable var6 = new Mutable();

         for (int var7 = var2; var7 < var2 + 16; var7++) {
            for (int var8 = var3; var8 < var3 + 16; var8++) {
               for (int var9 = var4; var9 < var5; var9++) {
                  var6.set(var7, var9, var8);
                  if (this.I_method_7dc0d47e(var1, var6)) {
                     this.I_method_175f1df9(var6.toImmutable());
                  }
               }
            }
         }
      }
   }

   private boolean I_method_7dc0d47e(WorldChunk var1, BlockPos var2) {
      if (this.I_method_175f1dec(var2) != 7) {
         return false;
      } else {
         BlockState var3 = var1.getBlockState(var2);
         return var3.isOf(Blocks.ENDER_CHEST) ? true : this.I_method_6817a672(var3, var2) && !this.I_method_175f1dfd(var2) && this.i_method_41b2b1dd(var2);
      }
   }

   private boolean I_method_6817a672(BlockState var1, BlockPos var2) {
      return !var1.isAir() && var1.getLuminance() <= 0 ? var1.isOpaqueFullCube() || var1.isFullCube(I_field_3a9bda27.world, var2) : false;
   }

   private boolean I_method_175f1dfd(BlockPos var1) {
      Mutable var2 = new Mutable();

      for (int var3 = -7; var3 <= 7; var3++) {
         for (int var4 = -7; var4 <= 7; var4++) {
            for (int var5 = -7; var5 <= 7; var5++) {
               int var6 = Math.abs(var3) + Math.abs(var4) + Math.abs(var5);
               if (var6 != 0 && var6 <= 7) {
                  var2.set(var1.getX() + var3, var1.getY() + var4, var1.getZ() + var5);
                  if (!I_field_3a9bda27.world.isChunkLoaded(var2.getX() >> 4, var2.getZ() >> 4)) {
                     return true;
                  }

                  BlockState var7 = I_field_3a9bda27.world.getBlockState(var2);
                  if (!var7.isOf(Blocks.ENDER_CHEST) && (var7.getLuminance() > 0 || I_field_a56a8dc5.contains(var7.getBlock()))) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private boolean i_method_41b2b1dd(BlockPos var1) {
      Mutable var2 = new Mutable();
      int var3 = 0;
      int var4 = 0;

      for (int var5 = -7; var5 <= 7; var5++) {
         for (int var6 = -7; var6 <= 7; var6++) {
            for (int var7 = -7; var7 <= 7; var7++) {
               int var8 = Math.abs(var5) + Math.abs(var6) + Math.abs(var7);
               if (var8 != 0 && var8 <= 7) {
                  var2.set(var1.getX() + var5, var1.getY() + var6, var1.getZ() + var7);
                  if (!I_field_3a9bda27.world.isChunkLoaded(var2.getX() >> 4, var2.getZ() >> 4)) {
                     return false;
                  }

                  int var9 = this.I_method_175f1dec(var2);
                  int var10 = 7 - var8;
                  if (var9 > var10) {
                     return false;
                  }

                  if (var8 == 1 && var9 == var10) {
                     var3++;
                  } else if (var8 == 2 && var9 == var10) {
                     var4++;
                  }
               }
            }
         }
      }

      return var3 >= 4 && var4 >= 6;
   }

   private int I_method_175f1dec(BlockPos var1) {
      return I_field_3a9bda27.world == null ? 0 : I_field_3a9bda27.world.getLightLevel(LightType.BLOCK, var1);
   }

   private void I_method_175f1df9(BlockPos var1) {
      synchronized (this.I_field_7865b31) {
         if (!this.II_method_1cb83000(var1)) {
            BaseFinderModule.Nested1_1f390040 var3 = new BaseFinderModule.Nested1_1f390040("\u0411\u0430\u0437\u0430-" + this.Iii_field_49++, var1);
            this.I_field_7865b31.add(var3);
            iIIIIIIii_Class260.I_method_468cf607(Text.of(I_method_f5302abe(var3)));
         }
      }
   }

   private boolean II_method_1cb83000(BlockPos var1) {
      for (BaseFinderModule.Nested1_1f390040 var3 : this.I_field_7865b31) {
         long var4 = (long)var1.getX() - var3.I_method_4e05cc16().getX();
         long var6 = (long)var1.getY() - var3.I_method_4e05cc16().getY();
         long var8 = (long)var1.getZ() - var3.I_method_4e05cc16().getZ();
         if (var4 * var4 + var6 * var6 + var8 * var8 <= 2304L) {
            return true;
         }
      }

      return false;
   }

   private void II_method_1fae4661(int var1, int var2, int var3) {
      this.II_field_a56a8dc5.removeIf(var4 -> !this.I_method_88056822(var4, var1, var2, var3));
   }

   private boolean I_method_88056822(long var1, int var3, int var4, int var5) {
      return Math.abs(ChunkPos.getPackedX(var1) - var3) <= var5 && Math.abs(ChunkPos.getPackedZ(var1) - var4) <= var5;
   }

   private int Ii_method_ef7facd5() {
      int var1 = I_field_3a9bda27.options != null ? (Integer)I_field_3a9bda27.options.getViewDistance().getValue() : 8;
      return Math.max(1, Math.min(var1, 10));
   }

   private void IiI_method_84e6bf() {
      this.IiI_field_49 = 0;
      this.I_field_f27e4628.clear();
      this.i_field_a56a8dc5.clear();
      this.II_field_a56a8dc5.clear();
   }

   private String i_method_9d6fc197(String var1) {
      String var2 = var1.trim().toLowerCase();
      return var2.matches("\\d+") ? "base-" + var2 : var2.replace("\u0431\u0430\u0437\u0430", "base").replace("baza", "base").replace(" ", "");
   }

   public static String I_method_f5302abe(BaseFinderModule.Nested1_1f390040 var0) {
      return I_method_7880b77d(var0.I_method_c253ec66(), var0.I_method_4e05cc16());
   }

   public static String I_method_7880b77d(String var0, BlockPos var1) {
      return var0 + " - \u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b: " + var1.getX() + " " + var1.getY() + " " + var1.getZ();
   }

   public static final class Nested1_1f390040 {
      private final String I_field_523beb0a;
      private final BlockPos I_field_670402ba;

      public Nested1_1f390040(String var1, BlockPos var2) {
         this.I_field_523beb0a = var1;
         this.I_field_670402ba = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_1f390040[name=" + this.I_field_523beb0a + ", pos=" + this.I_field_670402ba + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_670402ba);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         BaseFinderModule.Nested1_1f390040 other = (BaseFinderModule.Nested1_1f390040) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_670402ba, other.I_field_670402ba);
      }

      public String I_method_c253ec66() {
         return this.I_field_523beb0a;
      }

      public BlockPos I_method_4e05cc16() {
         return this.I_field_670402ba;
      }
   }
}
