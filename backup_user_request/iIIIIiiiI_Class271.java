package rockstar.client;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public final class iIIIIiiiI_Class271 {
    private static final Map<BlockPos, BlockEntity> I_field_a567c40b = new ConcurrentHashMap<BlockPos, BlockEntity>();

    public static void I_method_a0466594(BlockEntity blockEntity) {
        if (blockEntity != null) {
            I_field_a567c40b.put(blockEntity.getPos(), blockEntity);
        }
    }

    public static void I_method_eda141f9(BlockPos blockPos) {
        if (blockPos != null) {
            I_field_a567c40b.remove(blockPos);
        }
    }

    public static BlockEntity I_method_2e3e4b92(BlockPos blockPos) {
        return I_field_a567c40b.get(blockPos);
    }

    public static Collection<BlockEntity> I_method_ea43a7e8() {
        return I_field_a567c40b.values();
    }

    public static void I_method_8dcc23f() {
        I_field_a567c40b.clear();
    }

    @Generated
    private iIIIIiiiI_Class271() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

