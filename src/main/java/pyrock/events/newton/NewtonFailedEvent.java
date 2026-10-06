package pyrock.events.newton;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="newton_failed")
public class NewtonFailedEvent
extends IiIIIIIi_Class66 {
    private final String process;
    private final String reason;

    @Generated
    public String getProcess() {
        return this.process;
    }

    @Generated
    public String getReason() {
        return this.reason;
    }

    @Generated
    public NewtonFailedEvent(String string, String string2) {
        this.process = string;
        this.reason = string2;
    }
}

