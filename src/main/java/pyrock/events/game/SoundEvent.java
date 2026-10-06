package pyrock.events.game;

import lombok.Generated;
import net.minecraft.client.sound.SoundInstance;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="sound")
public class SoundEvent
extends IiIIIIIi_Class66 {
    public SoundInstance sound;

    public SoundEvent(SoundInstance soundInstance) {
        this.sound = soundInstance;
    }

    @Generated
    public SoundInstance getSound() {
        return this.sound;
    }
}

