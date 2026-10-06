package moscow.rockstar.mixin.accessors;

import net.minecraft.network.packet.s2c.play.EntitySetHeadYawS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EntitySetHeadYawS2CPacket.class})
public interface EntitySetHeadYawS2CPacketAccessor {
    @Accessor(value="entityId")
    public int getEntityId();
}

