package moscow.rockstar.mixin.minecraft.client.gui.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.DownloadingTerrainScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.III;
import rockstar.client.WorldLoadingScreenHelper;

@Mixin(DownloadingTerrainScreen.class)
public abstract class DownloadingTerrainScreenMixin extends Screen {

    protected DownloadingTerrainScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void rockstar$renderCustomTerrainLoading(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ci.cancel();

        III custom = III.I_method_5728d20f(context, mouseX, mouseY, delta);
        WorldLoadingScreenHelper.renderLoadingScreen(
            custom,
            this.width,
            this.height,
            -1.0F, // smooth indeterminate
            "Загрузка мира",
            "Синхронизация чанков местности"
        );
    }
}
