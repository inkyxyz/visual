package moscow.rockstar.mixin.accessors;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Entity.class})
public interface EntityMovementMultiplierAccessor {
    @Accessor(value="movementMultiplier")
    public Vec3d getMovementMultiplier();
}

