package moscow.rockstar.mixin.minecraft.client.gui.screen.option;

import java.util.ArrayList;
import java.util.List;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;

import rockstar.client.OptionsScreenCards;

@Mixin(value = {OptionsScreen.class})
public abstract class OptionsScreenMixin extends Screen {
    protected OptionsScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void rockstar$onInit(CallbackInfo ci) {
        this.rockstar$repositionOptionsButtons();
    }

    @Inject(method = "refreshWidgetPositions", at = @At("TAIL"))
    private void rockstar$onRefreshPositions(CallbackInfo ci) {
        this.rockstar$repositionOptionsButtons();
    }

    @Inject(method = "removed", at = @At("HEAD"))
    private void rockstar$onRemoved(CallbackInfo ci) {
        OptionsScreenCards.hasLayout = false;
    }

    @Unique
    private void rockstar$repositionOptionsButtons() {
        if (this.client == null) return;

        List<Element> children = ((ScreenAccessor) this).getChildren();
        List<ClickableWidget> allWidgets = new ArrayList<>();
        ClickableWidget doneBtn = null;
        ClickableWidget lockBtn = null;

        for (Element elem : children) {
            if (elem instanceof net.minecraft.client.gui.widget.LockButtonWidget lock) {
                lockBtn = lock;
            } else if (elem instanceof ClickableWidget widget) {
                String txt = widget.getMessage().getString().toLowerCase();
                if (txt.contains("done") || txt.contains("\u0433\u043e\u0442\u043e\u0432")) {
                    doneBtn = widget;
                } else {
                    allWidgets.add(widget);
                }
            }
        }

        int gap = 16;
        int maxCardW = 230;
        int cardWVal = Math.min(maxCardW, (this.width - 48 - gap) / 2);
        int totalW = cardWVal * 2 + gap;
        int startX = (this.width - totalW) / 2;

        List<ClickableWidget> leftCol = new ArrayList<>();
        List<ClickableWidget> rightCol = new ArrayList<>();

        for (ClickableWidget w : allWidgets) {
            String txt = w.getMessage().getString().toLowerCase();
            // Right column: ОСНОВНЫЕ НАСТРОЙКИ (Графика, Звук, Музыка, Скин, Ресурспаки, Авторы)
            if (txt.contains("video") || txt.contains("\u0433\u0440\u0430\u0444\u0438\u043a") || txt.contains("\u0432\u0438\u0434\u0435\u043e") ||
                txt.contains("sound") || txt.contains("music") || txt.contains("\u0437\u0432\u0443\u043a") || txt.contains("\u043c\u0443\u0437\u044b\u043a") ||
                txt.contains("skin") || txt.contains("\u0441\u043a\u0438\u043d") || txt.contains("\u0432\u043d\u0435\u0448\u043d") ||
                txt.contains("resource") || txt.contains("\u043f\u0430\u043a\u0435\u0442") || txt.contains("\u0442\u0435\u043a\u0441\u0442\u0443\u0440") || txt.contains("pack") ||
                txt.contains("credit") || txt.contains("attribution") || txt.contains("\u0430\u0432\u0442\u043e\u0440") || txt.contains("\u0431\u043b\u0430\u0433\u043e\u0434\u0430\u0440\u043d\u043e\u0441\u0442")) {
                rightCol.add(w);
            } else {
                // Left column: НАСТРОЙКИ ИГРЫ (Управление, Чат, Доступность, Язык, Телеметрия, Сложность)
                leftCol.add(w);
            }
        }

        int maxRows = Math.max(leftCol.size(), rightCol.size());
        if (maxRows == 0) return;

        int availH = this.height - 44 - 38; // space between top header and done button
        int itemH = Math.min(24, Math.max(18, (availH - (maxRows - 1) * 4) / maxRows));
        int rowGap = Math.min(5, Math.max(2, (availH - maxRows * itemH) / (maxRows + 1)));
        int totalContentH = maxRows * itemH + (maxRows - 1) * rowGap;
        int startY = Math.max(40, (this.height - 34 - totalContentH) / 2);

        for (int i = 0; i < leftCol.size(); i++) {
            ClickableWidget w = leftCol.get(i);
            String txt = w.getMessage().getString().toLowerCase();
            boolean isDiff = (txt.contains("difficulty") || txt.contains("\u0441\u043b\u043e\u0436\u043d\u043e\u0441\u0442")) && lockBtn != null;
            int btnW = isDiff ? (cardWVal - 24) : cardWVal;
            w.setWidth(btnW);
            w.setHeight(itemH);
            w.setX(startX);
            w.setY(startY + i * (itemH + rowGap));

            if (isDiff && lockBtn != null) {
                lockBtn.setWidth(20);
                lockBtn.setHeight(itemH);
                lockBtn.setX(startX + cardWVal - 20);
                lockBtn.setY(w.getY());
            }
        }

        for (int i = 0; i < rightCol.size(); i++) {
            ClickableWidget w = rightCol.get(i);
            w.setWidth(cardWVal);
            w.setHeight(itemH);
            w.setX(startX + cardWVal + gap);
            w.setY(startY + i * (itemH + rowGap));
        }

        OptionsScreenCards.cardLeftX = startX;
        OptionsScreenCards.cardRightX = startX + cardWVal + gap;
        OptionsScreenCards.cardTopY = startY;
        OptionsScreenCards.cardW = cardWVal;
        OptionsScreenCards.cardLeftH = leftCol.isEmpty() ? 0 : (leftCol.get(leftCol.size() - 1).getY() + leftCol.get(leftCol.size() - 1).getHeight()) - leftCol.get(0).getY();
        OptionsScreenCards.cardRightH = rightCol.isEmpty() ? 0 : (rightCol.get(rightCol.size() - 1).getY() + rightCol.get(rightCol.size() - 1).getHeight()) - rightCol.get(0).getY();
        OptionsScreenCards.hasLayout = true;

        if (doneBtn != null) {
            int doneW = Math.min(200, this.width - 32);
            doneBtn.setWidth(doneW);
            doneBtn.setHeight(24);
            doneBtn.setX((this.width - doneW) / 2);
            doneBtn.setY(this.height - 32);
        }
    }
}
