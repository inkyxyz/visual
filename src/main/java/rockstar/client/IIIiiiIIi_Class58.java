package rockstar.client;

import net.minecraft.client.gui.DrawContext;
import rockstar.client.III;
import rockstar.client.IIIiiiIII_Class57;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIiiIii_Class156;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.ii_Class4;

public class IIIiiiIIi_Class58
extends ii_Class4
implements iIIiIIiIi_Class294,
iIIiIIiiI_Class295 {
    private final IIIiiiIII_Class57 I_field_bfaf16ac;

    public IIIiiiIIi_Class58(IIIiiiIII_Class57 iIIiiiIII_Class57) {
        this.I_field_bfaf16ac = iIIiiiIII_Class57;
    }

    @Override
    public void render(III iII) {
        IiIIiiIii_Class156 iiIIiiIii_Class156 = this.I_field_bfaf16ac.I_method_1bef2775();
        if (iiIIiiIii_Class156 == null) {
            this.close();
            return;
        }
        iiIIiiIii_Class156.II_method_a9112b4b(170.0f);
        iiIIiiIii_Class156.I_method_81448f74(I_field_73c6d26c.I_method_804ee20f() / 2.0f - iiIIiiIii_Class156.II_method_c7206932() / 2.0f);
        iiIIiiIii_Class156.i_method_83077f94(I_field_73c6d26c.i_method_805d6def() / 2.0f - iiIIiiIii_Class156.Ii_method_2047ead7() / 2.0f);
        iiIIiiIii_Class156.I_method_7ae26dda(iII);
        if (!iiIIiiIii_Class156.II_method_c3e648e6() && iiIIiiIii_Class156.I_method_ea650b95().I_method_6ac4da6f() <= 0.02f) {
            this.I_field_bfaf16ac.II_method_e574bce2();
            this.close();
        }
    }

    @Override
    public void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
        IiIIiiIii_Class156 iiIIiiIii_Class156 = this.I_field_bfaf16ac.I_method_1bef2775();
        if (iiIIiiIii_Class156 != null) {
            iiIIiiIii_Class156.I_method_400ceaa7(d, d2, iiIII_Class9);
        }
    }

    @Override
    public void onMouseReleased(double d, double d2, IiIII_Class9 iiIII_Class9) {
        IiIIiiIii_Class156 iiIIiiIii_Class156 = this.I_field_bfaf16ac.I_method_1bef2775();
        if (iiIIiiIii_Class156 != null) {
            iiIIiiIii_Class156.i_method_6a097ac7(d, d2, iiIII_Class9);
        }
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        IiIIiiIii_Class156 iiIIiiIii_Class156 = this.I_field_bfaf16ac.I_method_1bef2775();
        if (iiIIiiIii_Class156 != null) {
            iiIIiiIii_Class156.I_method_6b0ad25f(mouseX, mouseY, horizontalAmount, verticalAmount);
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        IiIIiiIii_Class156 iiIIiiIii_Class156 = this.I_field_bfaf16ac.I_method_1bef2775();
        if (iiIIiiIii_Class156 != null) {
            iiIIiiIii_Class156.I_method_c1acbc24(keyCode, scanCode, modifiers);
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean charTyped(char chr, int modifiers) {
        IiIIiiIii_Class156 iiIIiiIii_Class156 = this.I_field_bfaf16ac.I_method_1bef2775();
        if (iiIIiiIii_Class156 != null) {
            iiIIiiIii_Class156.I_method_b71e84c9(chr, modifiers);
        }
        return super.charTyped(chr, modifiers);
    }

    public boolean shouldPause() {
        return false;
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }

    public void close() {
        super.close();
        if (!this.I_field_bfaf16ac.i_method_5a099243() && this.I_field_bfaf16ac.I_method_59fb0663()) {
            this.I_field_bfaf16ac.iI_method_8024b102();
        }
    }
}

