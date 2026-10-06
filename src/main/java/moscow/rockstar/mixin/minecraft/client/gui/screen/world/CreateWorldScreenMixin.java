package moscow.rockstar.mixin.minecraft.client.gui.screen.world;

import java.util.ArrayList;
import java.util.List;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {CreateWorldScreen.class})
public abstract class CreateWorldScreenMixin extends Screen {
    protected CreateWorldScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = {"init"}, at = {@At(value = "TAIL")})
    private void rockstar$repositionCreateWorldButtons(CallbackInfo callbackInfo) {
        if (this.client == null) {
            return;
        }
        List<Element> children = ((ScreenAccessor) this).getChildren();
        List<ClickableWidget> bottomButtons = new ArrayList<>();
        for (Element elem : children) {
            if (elem instanceof ClickableWidget widget && widget.getY() >= this.height - 45) {
                bottomButtons.add(widget);
            }
        }
        if (bottomButtons.size() >= 2) {
            bottomButtons.sort((a, b) -> Integer.compare(a.getX(), b.getX()));
            int btnW = 160;
            int btnH = 24;
            int gap = 12;
            int totalW = btnW * 2 + gap;
            int startX = (this.width - totalW) / 2;
            int startY = this.height - 32;

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
