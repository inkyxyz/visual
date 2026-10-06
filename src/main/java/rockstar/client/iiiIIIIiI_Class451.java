package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import rockstar.client.iiiIIIIII_Class449;

public final class iiiIIIIiI_Class451 {
    public static final int I_field_49 = 200;

    private iiiIIIIiI_Class451() {
    }

    public static int I_method_4e2bca61(BlockState blockState, BlockPos blockPos) {
        boolean bl;
        float f;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null || minecraftClient.player == null) {
            return Integer.MAX_VALUE;
        }
        if (blockState.isAir()) {
            return 0;
        }
        float f2 = blockState.getHardness((BlockView)minecraftClient.world, blockPos);
        if (f2 < 0.0f) {
            return Integer.MAX_VALUE;
        }
        if (f2 == 0.0f) {
            return 1;
        }
        iiiIIIIII_Class449.Nested1_96efd060 nested1_96efd060 = iiiIIIIII_Class449.I_method_e9ce18a5(blockState);
        ItemStack itemStack = nested1_96efd060 != null ? minecraftClient.player.getInventory().getStack(nested1_96efd060.I_method_fced6f4d()) : ItemStack.EMPTY;
        float f3 = iiiIIIIII_Class449.I_method_22b4e0e6(itemStack, blockState);
        float f4 = f3 / f2 / (f = (bl = iiiIIIIiI_Class451.I_method_4ce6d11a(itemStack, blockState)) ? 30.0f : 100.0f);
        if (f4 <= 0.0f) {
            return Integer.MAX_VALUE;
        }
        int n = (int)Math.ceil(1.0 / (double)f4);
        return n;
    }

    public static int I_method_b874f7e7(BlockState blockState) {
        return iiiIIIIiI_Class451.I_method_4e2bca61(blockState, BlockPos.ORIGIN);
    }

    public static boolean I_method_4ce6d11a(ItemStack itemStack, BlockState blockState) {
        if (!blockState.isToolRequired()) {
            return true;
        }
        return itemStack.isSuitableFor(blockState);
    }
}

