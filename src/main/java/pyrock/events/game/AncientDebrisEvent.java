package pyrock.events.game;

import java.util.Collections;
import java.util.List;
import lombok.Generated;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IiIIIIIi_Class66;

public class AncientDebrisEvent
extends IiIIIIIi_Class66 {
    private final List<BlockPos> positions;
    private final Vec3d explosionCenter;

    public AncientDebrisEvent(List<BlockPos> list, Vec3d vec3d) {
        this.positions = Collections.unmodifiableList(list);
        this.explosionCenter = vec3d;
    }

    @Generated
    public List<BlockPos> getPositions() {
        return this.positions;
    }

    @Generated
    public Vec3d getExplosionCenter() {
        return this.explosionCenter;
    }
}

