package rockstar.client;

import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;

@ModuleInfo(
   name = "Clan Upgrade",
   category = ModuleCategory.PLAYER
)
public class ClanUpgradeModule extends Module {
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      iIIiiIiII_Class309 var2 = iIIiiIiIi_Class310.Ii_method_1c02fc38()
         .I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695())
         .I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75());
      iIIiIiIii_Class300 var3 = var2.I_method_5d34dd7d(Items.TORCH);
      iIIiIiIii_Class300 var4 = var2.I_method_5d34dd7d(Items.REDSTONE);
      if (I_field_3a9bda27.player.getMainHandStack().getItem() == Items.TORCH || var3 == null || var4 != null) {
         if (I_field_3a9bda27.player.getMainHandStack().getItem() != Items.REDSTONE && var3 == null && var4 != null) {
            if (var4 instanceof iIIiiiIii_Class316 var12 && iIIiIiIiI_Class299.I_method_d0256375().I_method_158af795() != Items.REDSTONE) {
               iIIiIiIiI_Class299.I_method_4c2ca067(var12);
            }
         } else if (var3 != null && var4 != null) {
            if (var3 instanceof iIIiiiIii_Class316 var11 && iIIiIiIiI_Class299.I_method_d0256375().I_method_158af795() != Items.TORCH) {
               iIIiIiIiI_Class299.I_method_4c2ca067(var11);
            }
         } else if (var3 == null && var4 == null) {
            return;
         }
      } else if (var3 instanceof iIIiiiIii_Class316 var5 && iIIiIiIiI_Class299.I_method_d0256375().I_method_158af795() != Items.TORCH) {
         iIIiIiIiI_Class299.I_method_4c2ca067(var5);
      }

      BlockPos var13 = I_field_3a9bda27.player.getBlockPos();
      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(
            new iiIIiIIii_Class404(I_field_3a9bda27.player.getYaw(), 88.0F),
            iiIIiIIIi_Class402.i_field_32e0c64c,
            180.0F,
            80.0F,
            80.0F,
            iiIIiIiiI_Class407.i_field_32efc66c
         );
      if (I_field_3a9bda27.player.getMainHandStack().getItem() == Items.TORCH && I_field_3a9bda27.world.getBlockState(var13).getBlock() != Blocks.TORCH
         || I_field_3a9bda27.player.getMainHandStack().getItem() == Items.REDSTONE
            && I_field_3a9bda27.world.getBlockState(var13).getBlock() != Blocks.REDSTONE_WIRE
            && I_field_3a9bda27.player.isOnGround()
            && this.I_field_991c1e8c.I_method_58432069(50L)
            && I_field_3a9bda27.world.getBlockState(var13.down()).isSolid()) {
         I_field_3a9bda27.interactionManager
            .sendSequencedPacket(
               I_field_3a9bda27.world,
               var1x -> new PlayerInteractBlockC2SPacket(
                  Hand.MAIN_HAND, new BlockHitResult(Vec3d.ofCenter(I_field_3a9bda27.player.getBlockPos()), Direction.UP, var13.down(), false), var1x
               )
            );
         I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
         this.I_field_991c1e8c.I_method_23e11e3f();
      }

      if ((
            I_field_3a9bda27.world.getBlockState(var13).getBlock() == Blocks.TORCH
               || I_field_3a9bda27.world.getBlockState(var13).getBlock() == Blocks.REDSTONE_WIRE
         )
         && this.I_field_991c1e8c.I_method_58432069(50L)) {
         Vec3d var6 = Vec3d.ofCenter(var13.down()).subtract(I_field_3a9bda27.player.getEyePos());
         double var7 = Math.sqrt(var6.x * var6.x + var6.z * var6.z);
         float var9 = (float)Math.toDegrees(Math.atan2(var6.z, var6.x)) - 90.0F + iIIiiiiiI_Class319.I_method_b56b22f(-2.0, 2.0);
         float var10 = (float)(-Math.toDegrees(Math.atan2(var6.y, var7))) + iIIiiiiiI_Class319.I_method_b56b22f(-1.0, 1.0);
         I_field_3a9bda27.player.networkHandler.sendPacket(new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, var9, var10));
         I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(var13, Direction.UP);
         I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
      }
   };
}
