package rockstar.client;

import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import rockstar.client.RockstarClient;

public class iiIIiiiii_Class416
extends PositionedSoundInstance {
    private static final float I_field_46 = 1.0f;
    private final String I_field_523beb0a;

    public iiIIiiiii_Class416(String string, float f) {
        super(Identifier.of((String)(RockstarClient.II_field_523beb0a + ":" + string)), SoundCategory.MASTER, f, 1.0f, SoundInstance.createRandom(), false, 0, SoundInstance.AttenuationType.NONE, 0.0, 0.0, 0.0, true);
        this.I_field_523beb0a = string;
    }

    public iiIIiiiii_Class416(String string, float f, float f2) {
        super(Identifier.of((String)(RockstarClient.II_field_523beb0a + ":" + string)), SoundCategory.MASTER, f, f2, SoundInstance.createRandom(), false, 0, SoundInstance.AttenuationType.NONE, 0.0, 0.0, 0.0, true);
        this.I_field_523beb0a = string;
    }

    public void I_method_87d2e181(float f) {
        MinecraftClient.getInstance().getSoundManager().play((SoundInstance)new iiIIiiiii_Class416(this.I_field_523beb0a, f));
    }

    public void I_method_7289b65f(float f, float f2) {
        MinecraftClient.getInstance().getSoundManager().play((SoundInstance)new iiIIiiiii_Class416(this.I_field_523beb0a, f, f2));
    }

    @Generated
    public String I_method_70acc61() {
        return this.I_field_523beb0a;
    }
}

