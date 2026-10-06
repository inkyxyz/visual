package pyrock.events;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;

public class EventCancellable
extends IiIIIIIi_Class66 {
    private boolean cancelled;

    public final void cancel() {
        this.cancelled = true;
    }

    @Generated
    public boolean isCancelled() {
        return this.cancelled;
    }
}

