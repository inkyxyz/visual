package moscow.rockstar.mixin.minecraft.client.gui.screen;

import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.resource.ResourceReload;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.III;
import rockstar.client.IiIIiIiii_Class152;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.iIiiIIiiI_Class359;

@Mixin(value={SplashOverlay.class})
public class SplashOverlayMixin
implements iIIiIIiIi_Class294,
iIIiIIiiI_Class295 {
    @Unique
    private IiIIiIiii_Class152 daunGif;
    @Unique
    private IiiiIiIii_Class236 fadeOutAnimation;
    @Shadow
    private long field_17771;
    @Final
    @Shadow
    private Consumer<Optional<Throwable>> field_18218;
    @Shadow
    @Final
    private ResourceReload field_17767;
    @Shadow
    @Final
    private boolean field_18219;
    @Shadow
    private long field_18220;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    public void init(MinecraftClient minecraftClient, ResourceReload resourceReload, Consumer<Optional<Throwable>> consumer, boolean bl, CallbackInfo callbackInfo) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void replaceRendering(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        // Disabled custom R folding animation so Minecraft loads cleanly and instantly
    }
}

