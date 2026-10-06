package rockstar.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import lombok.Generated;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.TntBlock;
import net.minecraft.block.TripwireBlock;
import net.minecraft.block.TripwireHookBlock;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Direction.Type;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

@ModuleInfo(
   name = "Trap ESP",
   category = ModuleCategory.VISUALS
)
public class TrapEspModule extends Module {
   private volatile List<TrapEspModule.Nested1_448dd060> I_field_7865b31 = Collections.emptyList();
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final Deque<BlockPos> I_field_db650847 = new ConcurrentLinkedDeque<>();
   private final Set<BlockPos> I_field_a56a8dc5 = Collections.newSetFromMap(new ConcurrentHashMap<>());
   private final Map<Long, TrapEspModule.Nested1_448dd060> I_field_a567c40b = new ConcurrentHashMap<>();
   private static final long I_field_4a = 5000L;
   private static final int I_field_49 = 64;
   private static final int i_field_49 = 96;
   private static final int II_field_49 = 24;
   private static final int Ii_field_49 = 5;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         if (this.I_field_991c1e8c.I_method_58432069(5000L) && this.I_field_db650847.isEmpty()) {
            this.Iii_method_365bb67f();
            this.I_field_991c1e8c.I_method_23e11e3f();
         }

         int var2 = 0;
         long var3 = 2000000L;
         long var5 = System.nanoTime();

         BlockPos var7;
         while (var2 < 96 && (var7 = this.I_field_db650847.poll()) != null) {
            this.I_field_a56a8dc5.remove(var7);
            var2++;
            TrapEspModule.Nested1_448dd060 var8 = this.I_method_583a612a(var7);
            long var9 = I_method_32b9aeb3(var7.getX(), var7.getZ());
            if (var8 != null) {
               this.I_field_a567c40b.put(var9, var8);
            } else {
               this.I_field_a567c40b.remove(var9);
            }

            if (System.nanoTime() - var5 > var3) {
               break;
            }
         }

         this.I_field_7865b31 = new ArrayList<>(this.I_field_a567c40b.values());
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         try {
            Packet var2 = var1.getPacket();
            if (var2 instanceof ChunkDataS2CPacket var3) {
               this.I_method_742657b9(new ChunkPos(var3.getChunkX(), var3.getChunkZ()));
            }

            if (var2 instanceof ChunkDeltaUpdateS2CPacket var6) {
               var6.visitUpdates((var1x, var2x) -> this.I_method_32b9aebf(var1x.getX(), var1x.getZ()));
            }

            if (var2 instanceof BlockUpdateS2CPacket var7) {
               BlockPos var4 = var7.getPos();
               this.I_method_32b9aebf(var4.getX(), var4.getZ());
            }
         } catch (Throwable var5) {
         }
      }
   };
   private final IiIIIiII_Class69<WorldChangeEvent> II_field_3d936f41 = var1 -> this.IiI_method_364d2a9f();
   private final IiIIIiII_Class69<PreHudRenderEvent> Ii_field_3d936f41 = var1 -> {
      CustomDrawContext var2 = var1.getContext();
      MatrixStack var3 = var2.getMatrices();
      IIiIIi_Class10 var4 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F);
      int var5 = (int)var4.I_method_a649725c();

      for (TrapEspModule.Nested1_448dd060 var7 : this.I_field_7865b31) {
         Vec2f var8 = iIiiiiIII_Class377.I_method_211fc242(var7.I_field_670402ba.toCenterPos().add(0.0, 0.5, 0.0));
         if (var8 != null) {
            String var9 = IiIiIIII_Class81.I_method_f25a980a("modules.trap_esp.label");
            String var10 = IiIiIIII_Class81.I_method_1410d1e5("modules.trap_esp.depth", var7.I_field_49);
            String var11 = var7.I_field_5a
               ? IiIiIIII_Class81.I_method_f25a980a("modules.trap_esp.private")
               : IiIiIIII_Class81.I_method_f25a980a("modules.trap_esp.no_private");
            byte var12 = 9;
            byte var13 = 6;
            int var14 = (int)(var4.I_method_2c375926(var10) + var13);
            float var15 = var4.I_method_2c375926(var9) + 6.0F + var12 + 2.0F;
            float var16 = var5 * 2;
            float var17 = var16 * 3.0F;
            var2.pushMatrix();
            var3.translate(var8.x, var8.y - var17, 0.0F);
            var2.drawRect(-var15 / 2.0F, 0.0F, var15, var16, ColorRGBA.BLACK.withAlpha(150.0F));
            var2.drawText(var4, var9, -var15 / 2.0F + var12 + 5.0F, 3.0F, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
            var2.drawTexture(
               RockstarClient.id("icons/trap.png"), -var15 / 2.0F + 2.0F, var5 - var12 / 2.0F, var12, var12, IiiiiIIIi_Class242.Ii_field_d0c8ec5
            );
            var2.drawRect(-var14 / 2.0F, var16, var14, var16, ColorRGBA.BLACK.withAlpha(150.0F));
            var2.drawText(var4, var10, -var14 / 2.0F + 2.0F, var16 + 3.0F, IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(200.0F));
            var2.drawRect(
               -(var4.I_method_2c375926(var11) + 6.0F) / 2.0F, var16 * 2.0F, var4.I_method_2c375926(var11) + 6.0F, var16, ColorRGBA.BLACK.withAlpha(150.0F)
            );
            var2.drawText(var4, var11, -var4.I_method_2c375926(var11) / 2.0F, var16 * 2.0F + 3.0F, IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(200.0F));
            var2.popMatrix();
         }
      }
   };

   @Override
   public void onDisable() {
      this.IiI_method_364d2a9f();
      super.onDisable();
   }

   @Override
   public void onEnable() {
      this.IiI_method_364d2a9f();
      this.Iii_method_365bb67f();
      super.onEnable();
   }

   public void IiI_method_364d2a9f() {
      this.I_field_db650847.clear();
      this.I_field_a56a8dc5.clear();
      this.I_field_a567c40b.clear();
      this.I_field_7865b31 = Collections.emptyList();
      this.I_field_991c1e8c.I_method_23e11e3f();
   }

   private void Iii_method_365bb67f() {
      if (I_field_3a9bda27.player != null) {
         BlockPos var1 = I_field_3a9bda27.player.getBlockPos();
         ArrayList var2 = new ArrayList(16641);

         for (int var3 = -64; var3 <= 64; var3++) {
            for (int var4 = -64; var4 <= 64; var4++) {
               BlockPos var5 = new BlockPos(var1.getX() + var3, var1.getY(), var1.getZ() + var4);
               if (this.I_field_a56a8dc5.add(var5)) {
                  var2.add(var5);
               }
            }
         }

         var2.sort(Comparator.comparingDouble(var1x -> ((net.minecraft.util.math.BlockPos)var1x).getSquaredDistance(var1)));
         this.I_field_db650847.addAll(var2);
      }
   }

   private void I_method_742657b9(ChunkPos var1) {
      if (I_field_3a9bda27.player != null) {
         int var2 = I_field_3a9bda27.player.getBlockPos().getY();
         int var3 = var1.getStartX();
         int var4 = var1.getStartZ();

         for (int var5 = var3; var5 < var3 + 16; var5++) {
            for (int var6 = var4; var6 < var4 + 16; var6++) {
               BlockPos var7 = new BlockPos(var5, var2, var6);
               if (this.I_field_a56a8dc5.add(var7)) {
                  this.I_field_db650847.add(var7);
               }
            }
         }
      }
   }

   private void I_method_32b9aebf(int var1, int var2) {
      if (I_field_3a9bda27.player != null) {
         int var3 = I_field_3a9bda27.player.getBlockPos().getY();
         BlockPos var4 = new BlockPos(var1, var3, var2);
         if (this.I_field_a56a8dc5.add(var4)) {
            this.I_field_db650847.add(var4);
         }
      }
   }

   private TrapEspModule.Nested1_448dd060 I_method_583a612a(BlockPos var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         int var2 = var1.getY();

         for (int var3 = 20; var3 >= -20; var3--) {
            BlockPos var4 = new BlockPos(var1.getX(), var2 + var3, var1.getZ());
            if (this.I_method_c01fe1dd(var4)) {
               int var5 = 0;
               boolean var6 = false;

               for (int var7 = 0; var7 < 24; var7++) {
                  BlockPos var8 = var4.down(var7);
                  BlockState var9 = I_field_3a9bda27.world.getBlockState(var8);
                  if (var9.isAir() && I_field_3a9bda27.world.getFluidState(var8).isEmpty()) {
                     int var10 = 0;

                     for (Direction var12 : Type.HORIZONTAL) {
                        BlockPos var13 = var8.offset(var12);
                        BlockState var14 = I_field_3a9bda27.world.getBlockState(var13);
                        if (!var14.isAir() && !var14.getCollisionShape(I_field_3a9bda27.world, var13).isEmpty()) {
                           var10++;
                        }
                     }

                     if (var10 < 4) {
                        if (var6) {
                           break;
                        }
                     } else {
                        if (!var6) {
                           var6 = true;
                        }

                        var5++;
                     }
                  } else if (var6) {
                     break;
                  }
               }

               if (var5 >= 5) {
                  BlockPos var15 = var4.down(var5);
                  BlockState var16 = I_field_3a9bda27.world.getBlockState(var15);
                  if (!var16.isAir() && !var16.getCollisionShape(I_field_3a9bda27.world, var15).isEmpty() && this.I_method_43dccc4e(var4, var5)) {
                     boolean var17 = this.i_method_63fbb46e(var4, 6);
                     return new TrapEspModule.Nested1_448dd060(var4, var5, var17);
                  }
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private boolean I_method_c01fe1dd(BlockPos var1) {
      if (I_field_3a9bda27.world == null) {
         return false;
      } else {
         int var2 = 0;

         for (int var3 = -1; var3 <= 1; var3++) {
            for (int var4 = -1; var4 <= 1; var4++) {
               if (var3 != 0 || var4 != 0) {
                  for (int var5 = 0; var5 <= 3; var5++) {
                     BlockPos var6 = var1.add(var3, var5, var4);
                     BlockState var7 = I_field_3a9bda27.world.getBlockState(var6);
                     if (!var7.isAir() && !var7.getCollisionShape(I_field_3a9bda27.world, var6).isEmpty()) {
                        var2++;
                        break;
                     }
                  }
               }
            }
         }

         return var2 >= 4;
      }
   }

   private boolean I_method_43dccc4e(BlockPos var1, int var2) {
      if (I_field_3a9bda27.world == null) {
         return false;
      } else {
         int var3 = 0;
         int var4 = 0;

         for (int var5 = -2; var5 <= 2; var5++) {
            for (int var6 = -2; var6 <= 2; var6++) {
               if (Math.abs(var5) > 1 || Math.abs(var6) > 1) {
                  var4++;
                  BlockPos var7 = var1.add(var5, 0, var6);
                  BlockState var8 = I_field_3a9bda27.world.getBlockState(var7);
                  if (!var8.isAir() && !var8.getCollisionShape(I_field_3a9bda27.world, var7).isEmpty()) {
                     Block var9 = var8.getBlock();
                     if (var9.getDefaultState().isOpaque()) {
                        var3++;
                     }
                  }
               }
            }
         }

         return var3 >= var4 * 0.6;
      }
   }

   private boolean i_method_63fbb46e(BlockPos var1, int var2) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         BlockPos var3 = var1.add(-var2, -var2, -var2);
         BlockPos var4 = var1.add(var2, var2, var2);

         for (BlockPos var6 : BlockPos.iterate(var3, var4)) {
            BlockState var7 = I_field_3a9bda27.world.getBlockState(var6);
            if (!var7.isAir()) {
               Block var8 = var7.getBlock();
               if (var8 instanceof TntBlock
                  || var8 instanceof PressurePlateBlock
                  || var8 instanceof TripwireBlock
                  || var8 instanceof TripwireHookBlock
                  || var8 instanceof HopperBlock
                  || var8 instanceof ChestBlock) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private static long I_method_32b9aeb3(int var0, int var1) {
      return (long)var0 << 32 ^ var1 & 4294967295L;
   }

   static class Nested1_448dd060 {
      BlockPos I_field_670402ba;
      int I_field_49;
      boolean I_field_5a;

      @Generated
      public Nested1_448dd060(BlockPos var1, int var2, boolean var3) {
         this.I_field_670402ba = var1;
         this.I_field_49 = var2;
         this.I_field_5a = var3;
      }
   }
}
