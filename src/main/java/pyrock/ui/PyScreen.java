package pyrock.ui;

import jep.python.PyCallable;
import net.minecraft.client.gui.screen.Screen;
import pyrock.ui.Node;
import pyrock.ui.Ui;
import rockstar.client.III;
import rockstar.client.IIiI_Class3;
import rockstar.client.IiIII_Class9;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import ua.mintantileak.spk.Compile;

public class PyScreen
extends IIiI_Class3 {
    private final PyCallable builder;
    private PyCallable immediate;
    private PyCallable clickCb;
    private PyCallable releaseCb;
    private PyCallable keyCb;
    private PyCallable moveCb;
    private PyCallable onClose;

    public PyScreen(PyCallable pyCallable) {
        this.builder = pyCallable;
    }

    public PyScreen() {
        this.builder = null;
    }

    public PyScreen immediate(PyCallable pyCallable) {
        this.immediate = pyCallable;
        return this;
    }

    public PyScreen onClick(PyCallable pyCallable) {
        this.clickCb = pyCallable;
        return this;
    }

    public PyScreen onRelease(PyCallable pyCallable) {
        this.releaseCb = pyCallable;
        return this;
    }

    public PyScreen onKey(PyCallable pyCallable) {
        this.keyCb = pyCallable;
        return this;
    }

    public PyScreen onMouseMove(PyCallable pyCallable) {
        this.moveCb = pyCallable;
        return this;
    }

    public PyScreen onClose(PyCallable pyCallable) {
        this.onClose = pyCallable;
        return this;
    }

    public void open() {
        iIIiIIiIi_Class294.I_field_3a9bda27.setScreen((Screen)this);
    }

    public void closeScreen() {
        if (iIIiIIiIi_Class294.I_field_3a9bda27.currentScreen == this) {
            iIIiIIiIi_Class294.I_field_3a9bda27.setScreen(null);
        }
    }

    public void addRoot(Node node) {
        if (node != null) {
            this.add(node.element());
        }
    }

    @Override
    @Compile(obfuscation=4)
    public void init() {
        super.init();
        this.clearRoots();
        if (this.builder == null) {
            return;
        }
        try {
            this.builder.call(new Object[]{new Ui(this)});
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[PyScreen] build error", (Throwable)exception);
        }
    }

    @Override
    public void afterRender(III iII) {
        if (this.immediate == null) {
            return;
        }
        try {
            this.immediate.call(new Object[]{iII, Float.valueOf(this.width), Float.valueOf(this.height)});
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[PyScreen] immediate render error", (Throwable)exception);
        }
    }

    @Override
    public void onMouseClicked(double d, double d2, IiIII_Class9 iiIII_Class9) {
        super.onMouseClicked(d, d2, iiIII_Class9);
        if (this.clickCb != null) {
            try {
                this.clickCb.call(new Object[]{Float.valueOf((float)d), Float.valueOf((float)d2), iiIII_Class9.name().toLowerCase()});
            }
            catch (Exception exception) {
                RockstarClient.I_field_ab0f6068.error("[PyScreen] click error", (Throwable)exception);
            }
        }
    }

    @Override
    public void onMouseReleased(double d, double d2, IiIII_Class9 iiIII_Class9) {
        super.onMouseReleased(d, d2, iiIII_Class9);
        if (this.releaseCb != null) {
            try {
                this.releaseCb.call(new Object[]{Float.valueOf((float)d), Float.valueOf((float)d2), iiIII_Class9.name().toLowerCase()});
            }
            catch (Exception exception) {
                RockstarClient.I_field_ab0f6068.error("[PyScreen] release error", (Throwable)exception);
            }
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.keyCb == null) {
            return super.keyPressed(keyCode, scanCode, modifiers);
        }
        try {
            this.keyCb.call(new Object[]{keyCode, scanCode, modifiers, true});
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[PyScreen] key press error", (Throwable)exception);
        }
        return true;
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        if (this.keyCb == null) {
            return super.keyReleased(keyCode, scanCode, modifiers);
        }
        try {
            this.keyCb.call(new Object[]{keyCode, scanCode, modifiers, false});
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[PyScreen] key release error", (Throwable)exception);
        }
        return true;
    }

    public void mouseMoved(double mouseX, double mouseY) {
        super.mouseMoved(mouseX, mouseY);
        if (this.moveCb == null) {
            return;
        }
        try {
            this.moveCb.call(new Object[]{Float.valueOf((float)mouseX), Float.valueOf((float)mouseY)});
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("[PyScreen] mouse move error", (Throwable)exception);
        }
    }

    public void close() {
        if (this.onClose != null) {
            try {
                this.onClose.call(new Object[0]);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        super.close();
    }
}

