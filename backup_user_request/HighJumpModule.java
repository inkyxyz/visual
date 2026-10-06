package rockstar.client;

import java.util.Map;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.WorldChunk;

@ModuleInfo(
   name = "High Jump",
   category = ModuleCategory.MOVEMENT
)
public class HighJumpModule extends Module {
   private boolean I_field_5a;
   private int I_field_49;

   @Override
   public void II_method_6642fd22() {
      if (this.I_field_5a) {
         this.I_field_49++;
         double var24 = Math.min(this.I_field_49 / 12.0, 1.5);
         Vec3d var25 = I_field_3a9bda27.player.getVelocity();
         I_field_3a9bda27.player.setVelocity(var25.x, 1.0, var25.z);
         if (this.I_field_49 > 4) {
            this.I_field_5a = false;
         }
      } else {
         Vec3d var1 = I_field_3a9bda27.player.getPos();
         int var2 = MathHelper.floor(var1.x) >> 4;
         int var3 = MathHelper.floor(var1.z) >> 4;

         for (int var4 = var2 - 1; var4 <= var2 + 1; var4++) {
            for (int var5 = var3 - 1; var5 <= var3 + 1; var5++) {
               WorldChunk var6 = I_field_3a9bda27.world.getChunkManager().getWorldChunk(var4, var5);
               if (var6 != null) {
                  Map var7 = var6.getBlockEntities();

                  for (BlockEntity var9 : (Iterable<BlockEntity>)(Iterable<?>)var7.values()) {
                     if (var9 instanceof ShulkerBoxBlockEntity var10) {
                        BlockPos var11 = var9.getPos();
                        double var12 = var1.x - (var11.getX() + 0.5);
                        double var14 = var1.z - (var11.getZ() + 0.5);
                        double var16 = Math.sqrt(var12 * var12 + var14 * var14);
                        double var18 = Math.abs(var1.y - (var11.getY() + 0.5));
                        double var20 = I_field_3a9bda27.player.getVelocity().y > 1.0 ? 30.0 : 2.0;
                        if (var16 <= 1.5 && var18 <= var20 && I_field_3a9bda27.player.fallDistance == 0.0F) {
                           float var22 = var10.getAnimationProgress(1.0F);
                           if (var22 > 0.0F && var22 != 1.0F) {
                              this.I_field_5a = true;
                              this.I_field_49 = 0;
                              Vec3d var23 = I_field_3a9bda27.player.getVelocity();
                              I_field_3a9bda27.player.setVelocity(var23.x, 1.0, var23.z);
                              I_field_3a9bda27.setScreen(null);
                              return;
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public void onEnable() {
   }

   @Override
   public void onDisable() {
      this.I_field_5a = false;
      this.I_field_49 = 0;
   }
}
