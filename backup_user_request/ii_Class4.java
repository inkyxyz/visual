package rockstar.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import rockstar.client.III;
import rockstar.client.IiIII_Class9;
import rockstar.client.iIiiIIiiI_Class359;

public abstract class ii_Class4
extends Screen {
    protected ii_Class4() {
        super((Text)Text.empty());
    }

    public abstract void render(III var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        III iII = III.I_method_5728d20f(context, mouseX, mouseY, delta);
        iIiiIIiiI_Class359.II_method_5031d522();
        try {
            this.render(iII);
        }
        finally {
            iIiiIIiiI_Class359.Ii_method_50406102();
        }
    }

    public final boolean mouseClicked(double mouseX, double mouseY, int button) {
        IiIII_Class9 iiIII_Class9 = IiIII_Class9.I_method_40dce65a(button);
        this.onMouseClicked(mouseX, mouseY, iiIII_Class9);
        return super.mouseClicked(mouseX, mouseY, button);
    }

    public final boolean mouseReleased(double mouseX, double mouseY, int button) {
        IiIII_Class9 iiIII_Class9 = IiIII_Class9.I_method_40dce65a(button);
        this.onMouseReleased(mouseX, mouseY, iiIII_Class9);
        return super.mouseReleased(mouseX, mouseY, button);
    }

    public final boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        IiIII_Class9 iiIII_Class9 = IiIII_Class9.I_method_40dce65a(button);
        this.onMouseDragged(mouseX, mouseY, iiIII_Class9, deltaX, deltaY);
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    public void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
    }

    public void onMouseReleased(double d, double d2, IiIII_Class9 iiIII_Class9) {
    }

    public void onMouseDragged(double d, double d2, IiIII_Class9 iiIII_Class9, double d3, double d4) {
    }
}

