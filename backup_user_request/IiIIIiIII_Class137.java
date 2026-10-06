package rockstar.client;

import java.util.Comparator;
import java.util.function.Function;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import rockstar.client.iIIiIIiIi_Class294;

public class IiIIIiIII_Class137
implements iIIiIIiIi_Class294 {
    public static final Comparator<Entity> I_field_c8f916f9 = Comparator.comparingDouble(entity -> entity.distanceTo((Entity)IiIIIiIII_Class137.I_field_3a9bda27.player));
    public static final Comparator<Entity> i_field_c8f916f9 = Comparator.comparingDouble(entity -> {
        double d;
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            d = livingEntity.getHealth();
        } else {
            d = 0.0;
        }
        return d;
    });
    public static final Comparator<Entity> II_field_c8f916f9 = Comparator.comparingDouble(entity -> {
        if (IiIIIiIII_Class137.I_field_3a9bda27.player == null) {
            return Double.MAX_VALUE;
        }
        Vec3d vec3d = IiIIIiIII_Class137.I_field_3a9bda27.player.getPos();
        Vec3d vec3d2 = entity.getPos();
        Vec3d vec3d3 = IiIIIiIII_Class137.I_field_3a9bda27.player.getRotationVec(1.0f);
        Vec3d vec3d4 = vec3d2.subtract(vec3d).normalize();
        double d = vec3d3.dotProduct(vec3d4);
        return Math.acos(MathHelper.clamp((double)d, (double)-1.0, (double)1.0)) * 57.29577951308232;
    });
    public static final Comparator<Entity> Ii_field_c8f916f9 = Comparator.comparingDouble(entity -> {
        if (!(entity instanceof PlayerEntity)) {
            return Double.MAX_VALUE;
        }
        PlayerEntity playerEntity = (PlayerEntity)entity;
        double d = 0.0;
        for (ItemStack itemStack : playerEntity.getAllArmorItems()) {
            if (itemStack == null || itemStack.isEmpty()) continue;
            d += (double)itemStack.getItem().getDefaultStack().getCount();
        }
        return d;
    });
    public static final Comparator<Entity> iI_field_c8f916f9 = Ii_field_c8f916f9.reversed();

    public static Comparator<Entity> I_method_a351cdbc(Function<Entity, Double> function) {
        return Comparator.comparingDouble(function::apply);
    }

    public static Comparator<Entity> i_method_e6c1a19c(Function<Entity, Double> function) {
        return Comparator.comparingDouble(function::apply).reversed();
    }
}

