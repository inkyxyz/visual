package moscow.rockstar.mixin.minecraft.client.gui.screen.world;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.LevelLoadingScreen;
import net.minecraft.server.WorldGenerationProgressTracker;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.III;
import rockstar.client.WorldLoadingScreenHelper;

@Mixin(LevelLoadingScreen.class)
public abstract class LevelLoadingScreenMixin extends Screen {

    @Shadow
    @Final
    private WorldGenerationProgressTracker progressProvider;

    protected LevelLoadingScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void rockstar$renderCustomLoading(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        ci.cancel();

        III custom = III.I_method_5728d20f(context, mouseX, mouseY, delta);
        float progress = 0.0F;
        if (this.progressProvider != null) {
            progress = this.progressProvider.getProgressPercentage() / 100.0F;
        }

        WorldLoadingScreenHelper.renderLoadingScreen(
            custom,
            this.width,
            this.height,
            progress,
            "Генерация мира",
            "Подготовка местности и чанков"
        );
    }
}
