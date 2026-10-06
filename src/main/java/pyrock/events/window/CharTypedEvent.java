package pyrock.events.window;

import lombok.Generated;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;
import rockstar.client.iIIiIIiIi_Class294;

@IiIIIIiI_Class67(I_method_80b3cd54="char_typed")
public class CharTypedEvent
extends EventCancellable
implements iIIiIIiIi_Class294 {
    private final int codePoint;
    private final int mods;

    public CharTypedEvent(int n, int n2) {
        this.codePoint = n;
        this.mods = n2;
    }

    public String getChar() {
        return new String(Character.toChars(this.codePoint));
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
        return CharTypedEvent.I_field_3a9bda27.currentScreen != null;
    }

    @Generated
    public int getCodePoint() {
        return this.codePoint;
    }

    @Generated
    public int getMods() {
        return this.mods;
    }
}

