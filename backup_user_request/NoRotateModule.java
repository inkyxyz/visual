package rockstar.client;

import java.util.EnumSet;
import java.util.Set;
import moscow.rockstar.mixin.accessors.PlayerPositionLookS2CPacketAccessor;
import moscow.rockstar.mixin.accessors.PlayerRotationS2CPacketAccessor;
import net.minecraft.entity.player.PlayerPosition;
import net.minecraft.network.packet.s2c.play.LookAtS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRotationS2CPacket;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import pyrock.events.network.ReceivePacketEvent;

@ModuleInfo(
   name = "No Rotate",
   category = ModuleCategory.PLAYER,
   III_method_a89e5834 = "modules.descriptions.no_rotate"
)
public class NoRotateModule extends Module {
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = new IiIIIiII_Class69<ReceivePacketEvent>() {
      public void onEvent(ReceivePacketEvent var1) {
         if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null && iIIiIIiIi_Class294.I_field_3a9bda27.world != null) {
            if (var1.getPacket() instanceof PlayerPositionLookS2CPacket var2) {
               NoRotateModule.this.I_method_f830737d(var2);
            } else if (var1.getPacket() instanceof PlayerRotationS2CPacket var3) {
               NoRotateModule.this.I_method_ef20f13(var3);
            } else if (var1.getPacket() instanceof LookAtS2CPacket) {
               var1.cancel();
            }
         }
      }

      @Override
      public int I_method_f12c6485() {
         return 100;
      }
   };

   void I_method_f830737d(PlayerPositionLookS2CPacket var1) {
      PlayerPosition var2 = var1.change();
      PlayerPositionLookS2CPacketAccessor var3 = (PlayerPositionLookS2CPacketAccessor)(Object)var1;
      var3.setChange(new PlayerPosition(var2.position(), var2.deltaMovement(), I_field_3a9bda27.player.getYaw(), I_field_3a9bda27.player.getPitch()));
      var3.setRelatives(this.I_method_1390968f(var1.relatives()));
   }

   void I_method_ef20f13(PlayerRotationS2CPacket var1) {
      PlayerRotationS2CPacketAccessor var2 = (PlayerRotationS2CPacketAccessor)(Object)var1;
      var2.setYRot(I_field_3a9bda27.player.getYaw());
      var2.setXRot(I_field_3a9bda27.player.getPitch());
   }

   private Set<PositionFlag> I_method_1390968f(Set<PositionFlag> var1) {
      EnumSet var2 = var1.isEmpty() ? EnumSet.noneOf(PositionFlag.class) : EnumSet.copyOf(var1);
      var2.remove(PositionFlag.Y_ROT);
      var2.remove(PositionFlag.X_ROT);
      return var2;
   }
}
