package moscow.rockstar.mixin.minecraft.util.profiling.jfr;

import java.util.Optional;
import net.minecraft.util.profiling.jfr.FlightProfiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={FlightProfiler.class})
public interface JvmProfilerMixin {
    @Redirect(method={"<clinit>"}, at=@At(value="INVOKE", target="Ljava/util/Optional;isPresent()Z"))
    private static boolean mint$disableJfr(Optional<?> optional) {
        return false;
    }
}

