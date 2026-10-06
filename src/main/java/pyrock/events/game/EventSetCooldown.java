package pyrock.events.game;

import lombok.Generated;
import net.minecraft.util.Identifier;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="set_cooldown")
public class EventSetCooldown
extends IiIIIIIi_Class66 {
    private int cooldown;
    private Identifier cooldownGroup;

    @Generated
    public int getCooldown() {
        return this.cooldown;
    }

    @Generated
    public Identifier getCooldownGroup() {
        return this.cooldownGroup;
    }

    @Generated
    public void setCooldown(int n) {
        this.cooldown = n;
    }

    @Generated
    public void setCooldownGroup(Identifier identifier) {
        this.cooldownGroup = identifier;
    }

    @Generated
    public EventSetCooldown(int n, Identifier identifier) {
        this.cooldown = n;
        this.cooldownGroup = identifier;
    }
}

