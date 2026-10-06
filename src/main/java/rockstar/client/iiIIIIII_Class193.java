package rockstar.client;

import java.util.Collection;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import rockstar.client.III;
import rockstar.client.MenuModule;
import rockstar.client.Setting;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIiiIii_Class156;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.iIiiiiii_Class192;
import rockstar.client.iiIIIIIi_Class194;
import rockstar.client.iiIIIIii_Class196;
import rockstar.client.iiIIIiiI_Class199;
import rockstar.client.iiIIIiii_Class200;
import rockstar.client.iiIIiIIi_Class202;
import rockstar.client.ii_Class4;

public class iiIIIIII_Class193
extends ii_Class4
implements iIIiIIiIi_Class294,
iIIiIIiiI_Class295 {
    private final IiIIiiIii_Class156 I_field_ab760aac = new IiIIiiIii_Class156(100.0f, 100.0f).i_method_a1faeedf("presets").i_method_9da88f55();
    private final IiIIiiIii_Class156 i_field_ab760aac = new IiIIiiIii_Class156(100.0f, 100.0f).i_method_a1faeedf("shared").i_method_9da88f55();
    private final iiIIIIii_Class196 I_field_c6133f81 = new iiIIIIii_Class196();

    public iiIIIIII_Class193() {
        iiIIIIIi_Class194 iiIIIIIi_Class1942 = RockstarClient.getInstance().I_method_11732eb();
        RockstarClient.getInstance().I_method_2da230b().Ii_method_b13067f5();
        this.I_field_ab760aac.I_method_880b4e76(new iiIIIiiI_Class199());
        this.I_method_28cacec9(iiIIIIIi_Class1942.I_method_94c3e7cb().I_field_7865b31, this.i_field_ab760aac);
        iiIIIIIi_Class194 iiIIIIIi_Class1943 = RockstarClient.getInstance().I_method_11732eb();
        String string = iiIIIIIi_Class1943.I_method_5c4a8d74();
        for (iiIIIiii_Class200 iiIIIiii_Class2002 : RockstarClient.getInstance().I_method_11732eb().I_method_c2ce901b()) {
            if (!iiIIIiii_Class2002.I_method_62860974().equals(string)) continue;
            iiIIIIIi_Class1943.I_method_3912c30d(iiIIIiii_Class2002);
        }
    }

    @Override
    public void render(III iII) {
        float f = 210.0f;
        float f2 = 230.0f;
        float f3 = 360.0f + f;
        float f4 = iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() / 2.0f - f3 / 2.0f;
        float f5 = I_field_73c6d26c.i_method_805d6def() / 2.0f;
        float f6 = f5 - f2 / 2.0f;
        this.I_field_ab760aac.II_method_a9112b4b(170.0f);
        this.i_field_ab760aac.II_method_a9112b4b(170.0f);
        this.I_field_ab760aac.I_method_81448f74(f4);
        this.i_field_ab760aac.I_method_81448f74(f4 + 180.0f);
        this.I_field_ab760aac.i_method_83077f94(f6);
        this.i_field_ab760aac.i_method_83077f94(f6);
        this.I_field_ab760aac.I_method_7ae26dda(iII);
        this.i_field_ab760aac.I_method_7ae26dda(iII);
        this.I_field_c6133f81.I_method_b043bcc(f4 + 360.0f, f6, f, f2);
        this.I_field_c6133f81.I_method_7ae26dda(iII);
    }

    @Override
    public void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_method_cb57876d(iiIIiiIii_Class156 -> iiIIiiIii_Class156.I_method_400ceaa7(d, d2, iiIII_Class9));
        this.I_field_c6133f81.I_method_400ceaa7(d, d2, iiIII_Class9);
    }

    @Override
    public void onMouseReleased(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_method_cb57876d(iiIIiiIii_Class156 -> iiIIiiIii_Class156.i_method_6a097ac7(d, d2, iiIII_Class9));
        this.I_field_c6133f81.i_method_6a097ac7(d, d2, iiIII_Class9);
    }

    @Override
    public void onMouseDragged(double d, double d2, IiIII_Class9 iiIII_Class9, double d3, double d4) {
        this.I_field_c6133f81.I_method_19999dda(d, d2, iiIII_Class9, d3, d4);
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        this.I_method_cb57876d(iiIIiiIii_Class156 -> iiIIiiIii_Class156.I_method_6b0ad25f(mouseX, mouseY, horizontalAmount, verticalAmount));
        this.I_field_c6133f81.I_method_6b0ad25f(mouseX, mouseY, horizontalAmount, verticalAmount);
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (Screen.hasControlDown() && (keyCode == 90 || keyCode == 89)) {
            boolean bl;
            boolean bl2 = bl = keyCode == 89;
            if (bl ? this.I_field_ab760aac.i_method_61368643() : this.I_field_ab760aac.I_method_6127fa63()) {
                return true;
            }
            if (bl ? this.i_field_ab760aac.i_method_61368643() : this.i_field_ab760aac.I_method_6127fa63()) {
                return true;
            }
            this.I_field_c6133f81.I_method_c1acbc24(keyCode, scanCode, modifiers);
            return true;
        }
        this.I_method_cb57876d(iiIIiiIii_Class156 -> iiIIiiIii_Class156.I_method_c1acbc24(keyCode, scanCode, modifiers));
        this.I_field_c6133f81.I_method_c1acbc24(keyCode, scanCode, modifiers);
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean charTyped(char chr, int modifiers) {
        this.I_method_cb57876d(iiIIiiIii_Class156 -> iiIIiiIii_Class156.I_method_b71e84c9(chr, modifiers));
        return super.charTyped(chr, modifiers);
    }

    private void I_method_28cacec9(Collection<Setting> collection, IiIIiiIii_Class156 iiIIiiIii_Class156) {
        for (Setting iIiiiIIII_Class113 : collection) {
            iiIIiiIii_Class156.I_method_cbb5737d(iIiiiIIII_Class113);
        }
    }

    private void I_method_cb57876d(iIiiiiii_Class192 iIiiiiii_Class1922) {
        iIiiiiii_Class1922.call(this.I_field_ab760aac);
        iIiiiiii_Class1922.call(this.i_field_ab760aac);
    }

    public boolean shouldPause() {
        return false;
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }

    public void close() {
        iiIIiIIi_Class202 iiIIiIRockstarClient022 = RockstarClient.getInstance().I_method_2da230b();
        if (iiIIiIRockstarClient022.i_method_646d600b() != null) {
            iiIIiIRockstarClient022.i_method_646d600b().i_method_84d72ccc();
        }
        if (IiIiIIIII_Class161.I_field_fdef2cc != null) {
            IiIiIIIII_Class161.I_field_fdef2cc.I_method_fb5b3035(false);
        }
        super.close();
        MenuModule.IiI_method_c56c3e7f();
    }
}

