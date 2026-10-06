package pyrock.events.newton;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="newton_started")
public class NewtonStartedEvent
extends IiIIIIIi_Class66 {
    private final String process;

    @Generated
    public String getProcess() {
        return this.process;
    }

    @Generated
    public NewtonStartedEvent(String string) {
        this.process = string;
    }
}

