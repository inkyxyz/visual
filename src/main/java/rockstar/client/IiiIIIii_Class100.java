package rockstar.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import rockstar.client.III;
import rockstar.client.GuiMoveModule;
import rockstar.client.IiIII_Class9;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIIiIi_Class102;
import rockstar.client.IiiIiIii_Class108;
import rockstar.client.IiiIiiII_Class109;
import rockstar.client.IiiIiiIi_Class110;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.ii_Class4;
import ua.mintantileak.spk.Compile;

public class IiiIIIii_Class100
extends ii_Class4
implements iIIiIIiIi_Class294,
iIIiIIiiI_Class295 {
    private final IiiIiIii_Class108 I_field_dc0fb7a1 = new IiiIiIii_Class108();
    private final IiiIiiIi_Class110 I_field_dc1dcb61 = new IiiIiiIi_Class110();
    private final IiiIiiII_Class109 I_field_dc1dc781 = new IiiIiiII_Class109();

    @Compile(obfuscation=4)
    protected final void init() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    @Override
    public void render(III iII) {
        float f;
        float f2;
        float f3;
        boolean bl;
        float f4 = this.I_field_dc0fb7a1.I_method_2460a4dc();
        float f5 = 160.0f;
        float f6 = 223.0f;
        float f7 = 10.0f;
        this.I_field_dc1dc781.I_method_4d23c4cc();
        float f8 = this.I_field_dc1dc781.I_method_4d23c4bc();
        float f9 = this.I_field_dc1dc781.I_method_57553c64(f6);
        if (this.I_field_dc0fb7a1.I_method_ad31c04c() != null) {
            this.I_field_dc1dcb61.I_method_a5a07d0e(this.I_field_dc0fb7a1.I_method_ad31c04c());
            this.I_field_dc1dcb61.I_method_c3f7af76(this.I_field_dc0fb7a1.I_method_1c324534());
        }
        boolean bl2 = this.I_field_dc1dcb61.i_method_553ca4ac() != null;
        float f10 = f8 + f7 + f4;
        if (bl2) {
            f10 += f7 + f5;
        }
        if (bl = this.I_field_dc1dc781.I_method_c0b98dde(iII, f3 = (f2 = I_field_73c6d26c.I_method_804ee20f() / 2.0f - f10 / 2.0f), f = I_field_73c6d26c.i_method_805d6def() / 2.0f - f6 / 2.0f, f8, f9)) {
            f3 += f8 + f7;
        } else {
            f10 = f4;
            if (bl2) {
                f10 += f7 + f5;
            }
            f3 = f2 = I_field_73c6d26c.I_method_804ee20f() / 2.0f - f10 / 2.0f;
        }
        this.I_field_dc0fb7a1.I_method_a8e311ba(iII, f3, f, f4, f6);
        f3 += f4 + f7;
        if (bl2) {
            this.I_field_dc1dcb61.I_method_5dd295fa(iII, f3, f, f5, f6);
            if (this.I_field_dc1dcb61.I_method_83bed8b0()) {
                ItemStack itemStack = this.I_field_dc1dcb61.I_method_9a45248c();
                IiiIIiIi_Class102.I_method_d70ad618(itemStack, this.I_field_dc1dcb61.I_method_83bed8a0(), this.I_field_dc1dcb61.I_method_220a0974(), this.I_field_dc0fb7a1.i_method_af50f554(), this.I_field_dc1dcb61.I_method_90363a6(), this.I_field_dc1dcb61.I_method_83bed89a());
                this.I_field_dc1dc781.I_method_4d23c4cc();
                this.I_field_dc0fb7a1.I_method_f047594e(itemStack);
                this.I_field_dc0fb7a1.I_method_2460a4ec();
                this.I_field_dc1dcb61.I_method_a5a07d0e(null);
                this.I_field_dc1dcb61.I_method_c3f7af76(null);
            }
        }
    }

    @Override
    public void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_dc1dc781.I_method_5b2cc9a(d, d2, iiIII_Class9);
        this.I_field_dc0fb7a1.I_method_eddc507a(d, d2, iiIII_Class9);
        this.I_field_dc1dcb61.i_method_ccc864da(d, d2, iiIII_Class9);
        this.I_field_dc1dc781.I_method_4d23c4cc();
        super.onMouseClicked(d, d2, iiIII_Class9);
    }

    @Override
    public void onMouseReleased(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.I_field_dc0fb7a1.i_method_17d8e09a(d, d2, iiIII_Class9);
        this.I_field_dc1dcb61.I_method_a2cbd4ba(d, d2, iiIII_Class9);
        super.onMouseReleased(d, d2, iiIII_Class9);
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        this.I_field_dc1dc781.I_method_d6e7c832(mouseX, mouseY, verticalAmount);
        this.I_field_dc0fb7a1.I_method_4c0d7412(mouseX, mouseY, verticalAmount);
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        this.I_field_dc0fb7a1.I_method_4c564237(keyCode, scanCode, modifiers);
        this.I_field_dc1dcb61.I_method_5fbe7677(keyCode, scanCode, modifiers);
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean charTyped(char chr, int modifiers) {
        this.I_field_dc0fb7a1.I_method_8ed6c012(chr, modifiers);
        this.I_field_dc1dcb61.I_method_8f7703d2(chr, modifiers);
        return super.charTyped(chr, modifiers);
    }

    public void close() {
        RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this);
        super.close();
        I_field_3a9bda27.setScreen((Screen)RockstarClient.getInstance().I_method_96982062());
    }

    public void tick() {
        GuiMoveModule.iII_method_9983ebf();
        super.tick();
    }

    public boolean shouldPause() {
        return false;
    }

    public boolean shouldCloseOnEsc() {
        return true;
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }
}

