package pyrock.events.client;

import lombok.Generated;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="language_changed")
public class LanguageChangedEvent
extends IiIIIIIi_Class66 {
    private final String code;

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    public LanguageChangedEvent(String string) {
        this.code = string;
    }
}

