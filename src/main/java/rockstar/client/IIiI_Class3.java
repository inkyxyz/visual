package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.Vector2f;
import rockstar.client.III;
import rockstar.client.IIiiiIIIi_Class114;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iIiiiiIii_Class380;
import rockstar.client.iiI_Class7;
import rockstar.client.ii_Class4;
import rockstar.client.iiiI_Class15;
import rockstar.client.iiii_Class16;

public abstract class IIiI_Class3
extends ii_Class4 {
    protected final List<iiI_Class7> roots = new ArrayList<iiI_Class7>();
    protected final List<iiI_Class7> overlays = new ArrayList<iiI_Class7>();
    private long lastTime = 0L;
    private static long renderClock = 0L;
    protected float contentAlpha = 1.0f;

    public static long renderClock() {
        return renderClock;
    }

    protected <T extends iiI_Class7> T add(T t) {
        this.roots.add(t);
        return t;
    }

    protected void clearRoots() {
        this.roots.clear();
    }

    protected void clearOverlays() {
        this.overlays.forEach(iiI_Class7::discard);
        this.overlays.clear();
    }

    public void init() {
        super.init();
        this.clearOverlays();
    }

    public <T extends iiI_Class7> T openWindow(T t) {
        this.overlays.add(t);
        return t;
    }

    @Override
    public void render(III iII) {
        long l;
        renderClock = l = System.currentTimeMillis();
        float f = this.lastTime == 0L ? 16.0f : Math.min(64.0f, (float)(l - this.lastTime));
        this.lastTime = l;
        float f2 = iII.I_method_b1c3e152();
        float f3 = iII.i_method_b1d26d32();
        try (iIiiiiIii_Class380 iIiiiiIii_Class3802 = this.lowDrawBatching() ? iIiiiiIii_Class380.i_method_9a230ed5() : iIiiiiIii_Class380.I_method_848d9af5();){
            for (iiI_Class7 iiI_Class73 : this.roots) {
                iiI_Class73.measure();
                iiI_Class73.primeSize();
                iiI_Class73.centerWithin(this.width, this.height);
                iiI_Class73.tick(f, f2, f3);
            }
            for (iiI_Class7 iiI_Class73 : this.roots) {
                iiI_Class73.draw(iII, this.contentAlpha);
            }
            this.overlays.removeIf(iiI_Class72 -> !iiI_Class72.alive());
            if (!this.overlays.isEmpty() && !iIiiiiIii_Class380.I_method_5f4b6223()) {
                iIiiiiIii_Class380.I_method_5f4b621f();
            }
            for (iiI_Class7 iiI_Class73 : this.overlays) {
                iiI_Class73.measure();
                iiI_Class73.primeSize();
                iiI_Class73.tick(f, f2, f3);
            }
            for (iiI_Class7 iiI_Class73 : this.overlays) {
                iiI_Class73.draw(iII, this.contentAlpha);
            }
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.afterRender(iII);
        }
    }

    protected boolean lowDrawBatching() {
        return false;
    }

    protected void afterRender(III iII) {
    }

    public void removed() {
        iiii_Class16.I_method_b289539a(null);
        Vector2f vector2f = iIIiIIIiI_Class291.I_method_81637b4f();
        for (iiI_Class7 iiI_Class72 : this.overlays) {
            iiI_Class72.mouseReleased(vector2f.getX(), vector2f.getY(), IiIII_Class9.I_field_2f4c8d6c);
        }
        for (iiI_Class7 iiI_Class72 : this.roots) {
            iiI_Class72.mouseReleased(vector2f.getX(), vector2f.getY(), IiIII_Class9.I_field_2f4c8d6c);
        }
        iiiI_Class15.i_method_d4e7100c();
        this.overlays.forEach(iiI_Class7::close);
        super.removed();
    }

    @Override
    public void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
        int n;
        IiIiIIIII_Class161 iiIiIIIII_Class161 = IiIiIIIII_Class161.I_field_fdef2cc;
        boolean bl = false;
        for (n = this.overlays.size() - 1; n >= 0; --n) {
            if (!this.overlays.get(n).mouseClicked((float)d, (float)d2, iiIII_Class9)) continue;
            bl = true;
            break;
        }
        if (!bl) {
            for (n = this.roots.size() - 1; n >= 0 && !this.roots.get(n).mouseClicked((float)d, (float)d2, iiIII_Class9); --n) {
            }
        }
        if (iiIiIIIII_Class161 != null && IiIiIIIII_Class161.I_field_fdef2cc == iiIiIIIII_Class161 && iiIiIIIII_Class161.I_method_189fd283() && !iiIiIIIII_Class161.I_method_a74cd690(d, d2)) {
            iiIiIIIII_Class161.I_method_fb5b3035(false);
        }
    }

    @Override
    public void onMouseReleased(double d, double d2, IiIII_Class9 iiIII_Class9) {
        for (iiI_Class7 iiI_Class72 : this.overlays) {
            iiI_Class72.mouseReleased((float)d, (float)d2, iiIII_Class9);
        }
        for (iiI_Class7 iiI_Class72 : this.roots) {
            iiI_Class72.mouseReleased((float)d, (float)d2, iiIII_Class9);
        }
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        int n;
        for (n = this.overlays.size() - 1; n >= 0; --n) {
            if (!this.overlays.get(n).mouseScrolled((float)mouseX, (float)mouseY, (float)horizontalAmount, (float)verticalAmount)) continue;
            return true;
        }
        for (n = this.roots.size() - 1; n >= 0; --n) {
            if (!this.roots.get(n).mouseScrolled((float)mouseX, (float)mouseY, (float)horizontalAmount, (float)verticalAmount)) continue;
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        int n;
        if (!iiiI_Class15.i_method_d4e71010()) {
            if (Screen.hasControlDown() && keyCode == 90 && IIiiiIIIi_Class114.I_method_fe3ce603()) {
                return true;
            }
            if (Screen.hasControlDown() && keyCode == 89 && IIiiiIIIi_Class114.i_method_fe4b71e3()) {
                return true;
            }
        }
        for (n = this.overlays.size() - 1; n >= 0; --n) {
            if (!this.overlays.get(n).keyPressed(keyCode, scanCode, modifiers)) continue;
            return true;
        }
        for (n = this.roots.size() - 1; n >= 0; --n) {
            if (!this.roots.get(n).keyPressed(keyCode, scanCode, modifiers)) continue;
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        int n;
        for (n = this.overlays.size() - 1; n >= 0; --n) {
            if (!this.overlays.get(n).keyReleased(keyCode, scanCode, modifiers)) continue;
            return true;
        }
        for (n = this.roots.size() - 1; n >= 0; --n) {
            if (!this.roots.get(n).keyReleased(keyCode, scanCode, modifiers)) continue;
            return true;
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    public boolean charTyped(char chr, int modifiers) {
        int n;
        for (n = this.overlays.size() - 1; n >= 0; --n) {
            if (!this.overlays.get(n).charTyped(chr, modifiers)) continue;
            return true;
        }
        for (n = this.roots.size() - 1; n >= 0; --n) {
            if (!this.roots.get(n).charTyped(chr, modifiers)) continue;
            return true;
        }
        return super.charTyped(chr, modifiers);
    }

    public boolean shouldPause() {
        return false;
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }
}

