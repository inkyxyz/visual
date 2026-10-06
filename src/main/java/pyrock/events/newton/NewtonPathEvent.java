package pyrock.events.newton;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="newton_path")
public class NewtonPathEvent
extends IiIIIIIi_Class66 {
    private final String process;
    private final int steps;

    @Generated
    public String getProcess() {
        return this.process;
    }

    @Generated
    public int getSteps() {
        return this.steps;
    }

    @Generated
    public NewtonPathEvent(String string, int n) {
        this.process = string;
        this.steps = n;
    }
}

