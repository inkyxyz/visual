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
        List<ClickableWidget> bottomWidgets = new java.util.ArrayList<>();

        for (Element elem : children) {
            if (elem instanceof ClickableWidget widget && widget.visible) {
                if (widget.getY() >= this.height - 45) {
                    bottomWidgets.add(widget);
                }
            }
        }

        if (bottomWidgets.isEmpty()) {
            return;
        }

        // Sort by X coordinate to preserve left-to-right logical ordering
        bottomWidgets.sort(java.util.Comparator.comparingInt(ClickableWidget::getX));

        int count = bottomWidgets.size();
        int gap = 10;
        int btnH = 24;
        int btnY = this.height - 32;

        if (count == 1) {
            ClickableWidget single = bottomWidgets.get(0);
            int btnW = Math.min(200, this.width - 32);
            single.setWidth(btnW);
            single.setHeight(btnH);
            single.setX((this.width - btnW) / 2);
            single.setY(btnY);
        } else {
            int maxTotalW = this.width - 32;
            int totalGaps = gap * (count - 1);
            int idealBtnW = 150;
            int btnW = Math.min(idealBtnW, (maxTotalW - totalGaps) / count);
            int totalW = btnW * count + totalGaps;
            int startX = (this.width - totalW) / 2;

            for (int i = 0; i < count; i++) {
                ClickableWidget w = bottomWidgets.get(i);
                w.setWidth(btnW);
                w.setHeight(btnH);
                w.setX(startX + i * (btnW + gap));
                w.setY(btnY);
            }
        }
    }
}
