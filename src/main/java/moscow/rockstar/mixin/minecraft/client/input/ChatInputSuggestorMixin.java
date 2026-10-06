package moscow.rockstar.mixin.minecraft.client.input;

import com.mojang.brigadier.suggestion.Suggestions;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import net.minecraft.client.gui.screen.ChatInputSuggestor;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.RockstarClient;

@Mixin(value={ChatInputSuggestor.class})
public abstract class ChatInputSuggestorMixin {
    @Shadow
    @Final
    TextFieldWidget field_21599;
    @Shadow
    private CompletableFuture<Suggestions> field_21611;
    @Shadow
    @Nullable
    private ChatInputSuggestor.SuggestionWindow field_21612;

    @Shadow
    public abstract void method_23920(boolean var1);

    @Inject(method={"refresh"}, at={@At(value="INVOKE", target="Lcom/mojang/brigadier/StringReader;canRead()Z", remap=false)}, cancellable=true)
    private void injectAutoCompletion(CallbackInfo callbackInfo) {
        String string;
        String string2 = this.field_21599.getText();
        if (string2.startsWith(string = RockstarClient.getInstance().I_method_b4d046cb().I_method_80ea594())) {
            this.field_21611 = RockstarClient.getInstance().I_method_b4d046cb().I_method_c497dd67(string2, this.field_21599.getCursor());
            this.field_21611.thenRun(() -> {
                try {
                    if (this.field_21611.isDone() && !this.field_21611.get().isEmpty() && this.field_21612 == null) {
                        this.method_23920(false);
                        callbackInfo.cancel();
                    }
                }
                catch (InterruptedException | ExecutionException exception) {
                    // empty catch block
                }
            });
        }
    }
}

