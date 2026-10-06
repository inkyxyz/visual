package moscow.rockstar.mixin.minecraft.client.gui.screen.world;

import java.util.ArrayList;
import java.util.List;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {SelectWorldScreen.class})
public abstract class SelectWorldScreenMixin extends Screen {
    protected SelectWorldScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void rockstar$repositionSelectWorldButtons(CallbackInfo ci) {
        if (this.client == null) return;
        List<Element> children = ((ScreenAccessor) this).getChildren();
        List<ClickableWidget> bottomButtons = new ArrayList<>();
        for (Element elem : children) {
            if (elem instanceof ClickableWidget widget && widget.getY() >= this.height - 65) {
                bottomButtons.add(widget);
            }
        }
        if (bottomButtons.size() >= 5) {
            bottomButtons.sort((a, b) -> {
                if (Math.abs(a.getY() - b.getY()) <= 6) {
                    return Integer.compare(a.getX(), b.getX());
                }
                return Integer.compare(a.getY(), b.getY());
            });

            int totalW = Math.min(this.width - 32, 540);
            int startX = (this.width - totalW) / 2;
            int gap = 8;
            int h = 25;

            // Row 1: Primary actions (Play Selected World, Create New World)
            int row1W = (totalW - gap) / 2;
            int row1Y = this.height - 58;
            if (bottomButtons.size() >= 2) {
                ClickableWidget b0 = bottomButtons.get(0);
                b0.setWidth(row1W);
                b0.setHeight(h);
                b0.setX(startX);
                b0.setY(row1Y);

                ClickableWidget b1 = bottomButtons.get(1);
                b1.setWidth(row1W);
                b1.setHeight(h);
                b1.setX(startX + row1W + gap);
                b1.setY(row1Y);
            }

            // Row 2: Secondary actions (Edit, Delete, Re-Create, Cancel)
            int remaining = bottomButtons.size() - 2;
            int countRow2 = Math.min(remaining, 4);
            int row2W = (totalW - gap * (countRow2 - 1)) / countRow2;
            int row2Y = this.height - 29;
            for (int i = 0; i < countRow2; i++) {
                ClickableWidget b = bottomButtons.get(2 + i);
                b.setWidth(row2W);
                b.setHeight(h);
                b.setX(startX + i * (row2W + gap));
                b.setY(row2Y);
            }
        }
    }
}
