package moscow.rockstar.mixin.minecraft.client.gui.screen.option;

import java.util.List;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {GameOptionsScreen.class})
public abstract class GameOptionsScreenMixin extends Screen {
    protected GameOptionsScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void rockstar$centerBottomButtons(CallbackInfo ci) {
        if (this.client == null) return;

        List<Element> children = ((ScreenAccessor) this).getChildren();
        ClickableWidget doneBtn = null;
        ClickableWidget cancelBtn = null;

        for (Element elem : children) {
            if (elem instanceof ClickableWidget widget) {
                String txt = widget.getMessage().getString().toLowerCase();
                if (txt.contains("done") || txt.contains("\u0433\u043e\u0442\u043e\u0432")) {
                    doneBtn = widget;
                } else if (txt.contains("cancel") || txt.contains("\u043e\u0442\u043c\u0435\u043d") || txt.contains("back") || txt.contains("\u043d\u0430\u0437\u0430\u0434")) {
                    cancelBtn = widget;
                }
            }
        }

        if (doneBtn != null && cancelBtn != null) {
            int btnW = Math.min(150, (this.width - 32 - 12) / 2);
            int startX = (this.width - (btnW * 2 + 12)) / 2;
            cancelBtn.setWidth(btnW);
            cancelBtn.setHeight(24);
            cancelBtn.setX(startX);
            cancelBtn.setY(this.height - 32);

            doneBtn.setWidth(btnW);
            doneBtn.setHeight(24);
            doneBtn.setX(startX + btnW + 12);
            doneBtn.setY(this.height - 32);
        } else if (doneBtn != null) {
            int doneW = Math.min(200, this.width - 32);
            doneBtn.setWidth(doneW);
            doneBtn.setHeight(24);
            doneBtn.setX((this.width - doneW) / 2);
            doneBtn.setY(this.height - 32);
        }
    }
}
