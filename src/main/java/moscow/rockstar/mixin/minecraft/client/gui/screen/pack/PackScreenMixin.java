package moscow.rockstar.mixin.minecraft.client.gui.screen.pack;

import java.util.ArrayList;
import java.util.List;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.pack.PackScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {PackScreen.class})
public abstract class PackScreenMixin extends Screen {
    protected PackScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void rockstar$repositionPackButtons(CallbackInfo ci) {
        if (this.client == null) return;
        List<Element> children = ((ScreenAccessor) this).getChildren();
        List<ClickableWidget> bottomButtons = new ArrayList<>();
        for (Element elem : children) {
            if (elem instanceof ClickableWidget widget && widget.getY() >= this.height - 48) {
                bottomButtons.add(widget);
            }
        }
        if (bottomButtons.size() >= 2) {
            bottomButtons.sort((a, b) -> Integer.compare(a.getX(), b.getX()));
            int totalW = Math.min(this.width - 40, 480);
            int startX = (this.width - totalW) / 2;
            int gap = 12;
            int btnW = (totalW - gap) / 2;
            int btnH = 26;
            int startY = this.height - 34;

            for (int i = 0; i < 2 && i < bottomButtons.size(); i++) {
                ClickableWidget b = bottomButtons.get(i);
                b.setWidth(btnW);
                b.setHeight(btnH);
                b.setX(startX + i * (btnW + gap));
                b.setY(startY);
            }
        }
    }
}
