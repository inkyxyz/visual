package rockstar.client;

import lombok.Generated;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIiIIi_Class298;

public final class iIIIiIiIi_Class278
implements iIIiIIiIi_Class294 {
    private static RegistryEntry<Enchantment> I_field_3b804775 = null;
    private static final double I_field_44 = 0.08;
    private static final double i_field_44 = 0.98;

    public static float I_method_67f0481f(PlayerEntity playerEntity, int n) {
        float f;
        Vec3d vec3d = playerEntity.getPos();
        Vec3d vec3d2 = playerEntity.getVelocity();
        Box box = playerEntity.getBoundingBox().offset(0.0, 0.0, 0.0);
        double d = 0.0;
        for (int i = 0; i < n; ++i) {
            vec3d2 = vec3d2.add(0.0, -0.08, 0.0).multiply(0.98, 0.98, 0.98);
            vec3d = vec3d.add(vec3d2);
            if (!iIIIiIiIi_Class278.I_field_3a9bda27.world.isSpaceEmpty((box = box.offset(vec3d2)).offset(0.0, -0.001, 0.0))) break;
            if (!(vec3d2.y < 0.0)) continue;
            d -= vec3d2.y;
        }
        if ((f = (float)d) <= 3.0f) {
            return 0.0f;
        }
        int n2 = MathHelper.floor((float)(f - 3.0f));
        float f2 = n2;
        ItemStack itemStack = playerEntity.getInventory().getArmorStack(0);
        int n3 = iIIiIiIIi_Class298.I_method_7ea237bf(itemStack, (RegistryKey<Enchantment>)Enchantments.FEATHER_FALLING);
        if (n3 > 0) {
            f2 = Math.max(f2 - f2 * 0.15f * (float)n3, 0.0f);
        }
        if (playerEntity.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
            return 0.0f;
        }
        return f2;
    }

    @Generated
    private iIIIiIiIi_Class278() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

