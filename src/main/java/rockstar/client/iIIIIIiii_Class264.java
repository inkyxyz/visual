package rockstar.client;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public final class iIIIIIiii_Class264 {
    public static boolean I_method_7b8ac998(PlayerEntity playerEntity) {
        if (playerEntity == null) {
            return false;
        }
        if (playerEntity.getAbilities().flying) {
            return false;
        }
        if (playerEntity.hasStatusEffect(StatusEffects.BLINDNESS) || playerEntity.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
            return false;
        }
        return !playerEntity.isSubmergedInWater() && !playerEntity.isInLava();
    }

    public static boolean i_method_aa7c7d78(PlayerEntity playerEntity) {
        if (playerEntity == null || !playerEntity.isSprinting()) {
            return false;
        }
        if (playerEntity.getAttackCooldownProgress(1.0f) < 0.75f) {
            return false;
        }
        if (!iIIIIIiii_Class264.I_method_7b8ac998(playerEntity)) {
            return false;
        }
        if (playerEntity.isOnGround()) {
            return false;
        }
        return playerEntity.getVelocity().y < 0.0;
    }
}

