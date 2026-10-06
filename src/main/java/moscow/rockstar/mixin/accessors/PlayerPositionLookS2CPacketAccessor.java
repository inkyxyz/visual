package moscow.rockstar.mixin.accessors;

import java.util.Set;
import net.minecraft.entity.player.PlayerPosition;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={PlayerPositionLookS2CPacket.class})
public interface PlayerPositionLookS2CPacketAccessor {
    @Mutable
    @Accessor(value="change")
    public void setChange(PlayerPosition var1);

    @Mutable
    @Accessor(value="relatives")
    public void setRelatives(Set<PositionFlag> var1);
}

