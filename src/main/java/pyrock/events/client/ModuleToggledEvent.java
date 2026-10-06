package pyrock.events.client;

import lombok.Generated;
import pyrock.classes.PyModule;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="module_toggled")
public class ModuleToggledEvent
extends IiIIIIIi_Class66 {
    private final PyModule module;
    private final boolean state;

    @Generated
    public PyModule getModule() {
        return this.module;
    }

    @Generated
    public boolean isState() {
        return this.state;
    }

    @Generated
    public ModuleToggledEvent(PyModule pyModule, boolean bl) {
        this.module = pyModule;
        this.state = bl;
    }
}

