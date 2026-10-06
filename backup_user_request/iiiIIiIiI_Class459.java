package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import rockstar.client.iiiIIIiIi_Class454;
import rockstar.client.iiiIIiIIi_Class458;

public final class iiiIIiIiI_Class459 {
    private iiiIIiIiI_Class459() {
    }

    public static iiiIIiIIi_Class458 I_method_cae0235c(MinecraftClient minecraftClient) {
        iiiIIIiIi_Class454 iiiIIIiIi_Class4542;
        if (minecraftClient.player == null) {
            return new iiiIIiIIi_Class458(0, 0, 0);
        }
        BlockPos blockPos = minecraftClient.player.getBlockPos();
        int n = blockPos.getX();
        int n2 = blockPos.getY();
        int n3 = blockPos.getZ();
        try {
            iiiIIIiIi_Class4542 = new iiiIIIiIi_Class454();
        }
        catch (IllegalStateException illegalStateException) {
            return new iiiIIiIIi_Class458(n, n2, n3);
        }
        if (minecraftClient.player.isTouchingWater() && iiiIIIiIi_Class4542.II_method_1f35e205(n, n2, n3) && !iiiIIIiIi_Class4542.IiI_method_5d0a23e8(n, n2, n3)) {
            return new iiiIIiIIi_Class458(n, n2, n3);
        }
        if (minecraftClient.player.isClimbing() && !iiiIIIiIi_Class4542.IiI_method_5d0a23e8(n, n2, n3)) {
            return new iiiIIiIIi_Class458(n, n2, n3);
        }
        if (iiiIIIiIi_Class4542.i_method_674a3c88(n, n2, n3) && iiiIIIiIi_Class4542.IiI_method_5d0a23e8(n, n2 + 1, n3)) {
            return new iiiIIiIIi_Class458(n, n2 + 1, n3);
        }
        if (iiiIIIiIi_Class4542.IiI_method_5d0a23e8(n, n2, n3)) {
            return new iiiIIiIIi_Class458(n, n2, n3);
        }
        iiiIIiIIi_Class458 iiiIIiIIi_Class4582 = iiiIIiIiI_Class459.I_method_4af4050b(iiiIIIiIi_Class4542, minecraftClient, n2);
        if (iiiIIiIIi_Class4582 != null) {
            return iiiIIiIIi_Class4582;
        }
        iiiIIiIIi_Class458 iiiIIiIIi_Class4583 = iiiIIiIiI_Class459.I_method_4af4050b(iiiIIIiIi_Class4542, minecraftClient, n2 + 1);
        return iiiIIiIIi_Class4583 != null ? iiiIIiIIi_Class4583 : new iiiIIiIIi_Class458(n, n2, n3);
    }

    @Nullable
    public static iiiIIiIIi_Class458 i_method_589faf3c(MinecraftClient minecraftClient) {
        iiiIIIiIi_Class454 iiiIIIiIi_Class4542;
        if (minecraftClient.player == null) {
            return null;
        }
        BlockPos blockPos = minecraftClient.player.getBlockPos();
        int n = blockPos.getX();
        int n2 = blockPos.getY();
        int n3 = blockPos.getZ();
        try {
            iiiIIIiIi_Class4542 = new iiiIIIiIi_Class454();
        }
        catch (IllegalStateException illegalStateException) {
            return null;
        }
        if (iiiIIIiIi_Class4542.i_method_674a3c88(n, n2, n3) && iiiIIIiIi_Class4542.IiI_method_5d0a23e8(n, n2 + 1, n3)) {
            return null;
        }
        if (iiiIIIiIi_Class4542.IiI_method_5d0a23e8(n, n2, n3)) {
            return null;
        }
        iiiIIiIIi_Class458 iiiIIiIIi_Class4582 = iiiIIiIiI_Class459.I_method_4af4050b(iiiIIIiIi_Class4542, minecraftClient, n2);
        return iiiIIiIIi_Class4582 != null ? iiiIIiIIi_Class4582 : iiiIIiIiI_Class459.I_method_4af4050b(iiiIIIiIi_Class4542, minecraftClient, n2 + 1);
    }

    @Nullable
    private static iiiIIiIIi_Class458 I_method_4af4050b(iiiIIIiIi_Class454 iiiIIIiIi_Class4542, MinecraftClient minecraftClient, int n) {
        double d = minecraftClient.player.getX();
        double d2 = minecraftClient.player.getZ();
        double d3 = (double)minecraftClient.player.getWidth() * 0.5;
        int n2 = (int)Math.floor(d - d3);
        int n3 = (int)Math.floor(d + d3);
        int n4 = (int)Math.floor(d2 - d3);
        int n5 = (int)Math.floor(d2 + d3);
        iiiIIiIIi_Class458 iiiIIiIIi_Class4582 = null;
        double d4 = 0.0;
        for (int i = n2; i <= n3; ++i) {
            for (int j = n4; j <= n5; ++j) {
                double d5;
                double d6;
                double d7;
                if (!iiiIIIiIi_Class4542.IiI_method_5d0a23e8(i, n, j) || !((d7 = (d6 = Math.min((double)(i + 1), d + d3) - Math.max((double)i, d - d3)) * (d5 = Math.min((double)(j + 1), d2 + d3) - Math.max((double)j, d2 - d3))) > d4)) continue;
                d4 = d7;
                iiiIIiIIi_Class4582 = new iiiIIiIIi_Class458(i, n, j);
            }
        }
        return iiiIIiIIi_Class4582;
    }
}

