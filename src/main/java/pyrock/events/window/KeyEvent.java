package pyrock.events.window;

import lombok.Generated;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;
import rockstar.client.iIIIIiIiI_Class267;
import rockstar.client.iIIiIIiIi_Class294;

@IiIIIIiI_Class67(I_method_80b3cd54="key")
public class KeyEvent
extends EventCancellable
implements iIIiIIiIi_Class294 {
    private final int key;
    private final int scancode;
    private final int action;
    private final int mods;

    public KeyEvent(int n, int n2, int n3, int n4) {
        this.key = n;
        this.scancode = n2;
        this.action = n3;
        this.mods = n4;
    }

    public String getName() {
        return iIIIIiIiI_Class267.I_method_a937749c(this.key);
    }

    public boolean isPress() {
        return this.action == 1;
    }

    public boolean isRelease() {
        return this.action == 0;
    }

    public boolean isRepeat() {
        return this.action == 2;
    }

    public boolean isShift() {
        return (this.mods & 1) != 0;
    }

    public boolean isCtrl() {
        return (this.mods & 2) != 0;
    }

    public boolean isAlt() {
        return (this.mods & 4) != 0;
    }

    public boolean isScreenOpen() {
        return KeyEvent.I_field_3a9bda27.currentScreen != null;
    }

    @Generated
    public int getKey() {
        return this.key;
    }

    @Generated
    public int getScancode() {
        return this.scancode;
    }

    @Generated
    public int getAction() {
        return this.action;
    }

    @Generated
    public int getMods() {
        return this.mods;
    }
}

