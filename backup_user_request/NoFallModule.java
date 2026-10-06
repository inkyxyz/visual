package rockstar.client;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="No Fall", category=ModuleCategory.PLAYER)
public class NoFallModule
extends Module {
    @Override
    @Compile
    public void II_method_6642fd22() {
        if ((double)NoFallModule.I_field_3a9bda27.player.fallDistance > 2.5) {
            Vec3d vec3d = NoFallModule.I_field_3a9bda27.player.getPos();
            NoFallModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.Full(vec3d.x, vec3d.y, vec3d.z, NoFallModule.I_field_3a9bda27.player.getYaw(), NoFallModule.I_field_3a9bda27.player.getPitch(), true, true));
            NoFallModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, NoFallModule.I_field_3a9bda27.player.getYaw(), NoFallModule.I_field_3a9bda27.player.getPitch()));
            NoFallModule.I_field_3a9bda27.player.fallDistance = 0.0f;
        }
    }
}

