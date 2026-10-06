package pyrock.events.newton;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="newton_node")
public class NewtonNodeEvent
extends IiIIIIIi_Class66 {
    private final String process;
    private final int x;
    private final int y;
    private final int z;
    private final int step;
    private final int steps;

    @Generated
    public String getProcess() {
        return this.process;
    }

    @Generated
    public int getX() {
        return this.x;
    }

    @Generated
    public int getY() {
        return this.y;
    }

    @Generated
    public int getZ() {
        return this.z;
    }

    @Generated
    public int getStep() {
        return this.step;
    }

    @Generated
    public int getSteps() {
        return this.steps;
    }

    @Generated
    public NewtonNodeEvent(String string, int n, int n2, int n3, int n4, int n5) {
        this.process = string;
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.step = n4;
        this.steps = n5;
    }
}

