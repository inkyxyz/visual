package pyrock.events.game;

import lombok.Generated;
import net.minecraft.client.gui.screen.Screen;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="close_screen")
public class CloseScreenEvent
extends IiIIIIIi_Class66 {
    private final Screen screen;

    @Generated
    public Screen getScreen() {
        return this.screen;
    }

    @Generated
    public CloseScreenEvent(Screen screen) {
        this.screen = screen;
    }
}

