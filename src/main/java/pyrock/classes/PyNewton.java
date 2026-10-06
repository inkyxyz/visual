package pyrock.classes;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IIIiiiIi_Class30;
import rockstar.client.iiIiIiIII_Class425;
import rockstar.client.iiIiiIIii_Class436;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiIiiiIII_Class441;
import rockstar.client.iiiIIIiii_Class456;
import rockstar.client.iiiIIiIIi_Class458;
import rockstar.client.iiiIIiIii_Class460;
import rockstar.client.iiiIIiiII_Class461;
import rockstar.client.iiiIIiiIi_Class462;
import rockstar.client.iiiIIiiiI_Class463;
import rockstar.client.iiiIIiiii_Class464;
import rockstar.client.iiiIiIIII_Class465;
import rockstar.client.iiiIiiiii_Class480;
import rockstar.client.iiiiIIIII_Class481;
import rockstar.client.iiiiIIIIi_Class482;
import rockstar.client.iiiiIIIiI_Class483;
import rockstar.client.iiiiIIIii_Class484;
import rockstar.client.iiiiIIiII_Class485;

public class PyNewton {
    public boolean ready() {
        return iiIiiIiIi_Class438.I_method_1047da03();
    }

    public boolean active() {
        return this.ready() && iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7d4e6203();
    }

    public boolean goTo(int n, int n2, int n3) {
        return this.start(new iiiiIIIiI_Class483(new iiiIIiIii_Class460(new BlockPos(n, n2, n3))));
    }

    public boolean goToNear(int n, int n2, int n3, int n4) {
        return this.start(new iiiiIIIiI_Class483(new iiiIIiiII_Class461(new BlockPos(n, n2, n3), Math.max(0, n4))));
    }

    public boolean goToXZ(int n, int n2) {
        return this.start(new iiiiIIIiI_Class483(new iiiIIiiIi_Class462(n, n2)));
    }

    public boolean goToY(int n) {
        return this.start(new iiiiIIIiI_Class483(new iiiIIiiiI_Class463(n)));
    }

    public boolean flyTo(int n, int n2, int n3, boolean bl) {
        return this.start(new iiiIiiiii_Class480(n, n2, n3, bl));
    }

    public boolean mine(String string) {
        Block block = iiIiiiIII_Class441.I_method_b7c8d0a3(string);
        if (block == null) {
            return false;
        }
        return this.start(new iiiiIIIii_Class484(block));
    }

    public boolean excavate(int n, int n2, int n3, int n4, int n5, int n6, @Nullable String string) {
        Block block = null;
        if (string != null && !string.isEmpty() && (block = iiIiiiIII_Class441.I_method_b7c8d0a3(string)) == null) {
            return false;
        }
        return this.start(new iiiiIIIII_Class481(PyNewton.min(n, n2, n3, n4, n5, n6), PyNewton.max(n, n2, n3, n4, n5, n6), block));
    }

    public boolean fill(int n, int n2, int n3, int n4, int n5, int n6, String string) {
        Block block = iiIiiiIII_Class441.I_method_b7c8d0a3(string);
        if (block == null) {
            return false;
        }
        return this.start(new iiiiIIIIi_Class482(PyNewton.min(n, n2, n3, n4, n5, n6), PyNewton.max(n, n2, n3, n4, n5, n6), block));
    }

    public void cancel() {
        if (!this.ready()) {
            return;
        }
        iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7d4e61ff();
        iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5().i_method_35abae1f();
    }

    public boolean pause() {
        iiiiIIiII_Class485 iiiiIIiII_Class4852 = this.current();
        if (iiiiIIiII_Class4852 == null) {
            return false;
        }
        iiiiIIiII_Class4852.i_method_8f4a01df();
        return true;
    }

    public boolean resume() {
        iiiiIIiII_Class485 iiiiIIiII_Class4852 = this.current();
        if (iiiiIIiII_Class4852 == null) {
            return false;
        }
        iiiiIIiII_Class4852.II_method_58424142();
        return true;
    }

    public boolean paused() {
        iiiiIIiII_Class485 iiiiIIiII_Class4852 = this.current();
        return iiiiIIiII_Class4852 != null && iiiiIIiII_Class4852.i_method_8f4a01e3();
    }

    @Nullable
    public String process() {
        iiiiIIiII_Class485 iiiiIIiII_Class4852 = this.current();
        return iiiiIIiII_Class4852 == null ? null : iiiiIIiII_Class4852.I_method_31075c81();
    }

    @Nullable
    public String status() {
        iiiiIIiII_Class485 iiiiIIiII_Class4852 = this.current();
        return iiiiIIiII_Class4852 == null ? null : iiiiIIiII_Class4852.i_method_c4260ca1();
    }

    public boolean command(String string) {
        if (!this.ready() || string == null || string.isBlank()) {
            return false;
        }
        try {
            IIIiiiIi_Class30 iIIiiiIi_Class30 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_e75201b8();
            return iIIiiiIi_Class30.I_method_9e86975a(iIIiiiIi_Class30.I_method_80ea594() + " newton " + string);
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public int pathSteps() {
        iiiIIIiii_Class456 iiiIIIiii_Class4562 = this.executor();
        return iiiIIIiii_Class4562 == null ? 0 : iiiIIIiii_Class4562.I_method_24228ed5().i_method_6a8fca68().size();
    }

    public int pathStep() {
        iiiIIIiii_Class456 iiiIIIiii_Class4562 = this.executor();
        return iiiIIIiii_Class4562 == null ? 0 : iiiIIIiii_Class4562.I_method_7d7f71f2();
    }

    public int @Nullable [] nextNode() {
        iiiIIIiii_Class456 iiiIIIiii_Class4562 = this.executor();
        if (iiiIIIiii_Class4562 == null) {
            return null;
        }
        List<iiiIiIIII_Class465> list = iiiIIIiii_Class4562.I_method_24228ed5().i_method_6a8fca68();
        int n = iiiIIIiii_Class4562.I_method_7d7f71f2();
        if (n >= list.size()) {
            return null;
        }
        iiiIIiIIi_Class458 iiiIIiIIi_Class4582 = list.get(n).i_method_5e5afeb5();
        return new int[]{iiiIIiIIi_Class4582.I_method_6d204e12(), iiiIIiIIi_Class4582.i_method_6d2ed9f2(), iiiIIiIIi_Class4582.II_method_36f86d15()};
    }

    public double @Nullable [] goalPos() {
        double[] dArray;
        iiiIIiiii_Class464 iiiIIiiii_Class4642;
        iiiIIIiii_Class456 iiiIIIiii_Class4562 = this.executor();
        iiiIIiiii_Class464 iiiIIiiii_Class4643 = iiiIIiiii_Class4642 = iiiIIIiii_Class4562 == null ? null : iiiIIIiii_Class4562.I_method_25e582d5();
        if (iiiIIiiii_Class4642 == null) {
            return null;
        }
        Vec3d vec3d = iiiIIiiii_Class4642.I_method_f4d54579();
        if (vec3d == null) {
            dArray = null;
        } else {
            double[] dArray2 = new double[3];
            dArray2[0] = vec3d.x;
            dArray2[1] = vec3d.y;
            dArray = dArray2;
            dArray2[2] = vec3d.z;
        }
        return dArray;
    }

    public void select(int n, int n2, int n3) {
        iiIiiIIii_Class436.I_method_29e64b35().I_method_9d7525ec(new BlockPos(n, n2, n3));
    }

    public void selectClear() {
        iiIiiIIii_Class436.I_method_29e64b35().I_method_b0e9a63f();
    }

    public int @Nullable [] selection() {
        iiIiiIIii_Class436 iiIiiIIii_Class4362 = iiIiiIIii_Class436.I_method_29e64b35();
        if (!iiIiiIIii_Class4362.I_method_b0e9a643()) {
            return null;
        }
        BlockPos blockPos = iiIiiIIii_Class4362.II_method_79a4af8e();
        BlockPos blockPos2 = iiIiiIIii_Class4362.Ii_method_ee9f1fae();
        return new int[]{blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ()};
    }

    public boolean excavateSelection(@Nullable String string) {
        iiIiiIIii_Class436 iiIiiIIii_Class4362 = iiIiiIIii_Class436.I_method_29e64b35();
        if (!iiIiiIIii_Class4362.I_method_b0e9a643()) {
            return false;
        }
        BlockPos blockPos = iiIiiIIii_Class4362.II_method_79a4af8e();
        BlockPos blockPos2 = iiIiiIIii_Class4362.Ii_method_ee9f1fae();
        return this.excavate(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), string);
    }

    public boolean fillSelection(String string) {
        iiIiiIIii_Class436 iiIiiIIii_Class4362 = iiIiiIIii_Class436.I_method_29e64b35();
        if (!iiIiiIIii_Class4362.I_method_b0e9a643()) {
            return false;
        }
        BlockPos blockPos = iiIiiIIii_Class4362.II_method_79a4af8e();
        BlockPos blockPos2 = iiIiiIIii_Class4362.Ii_method_ee9f1fae();
        return this.fill(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), string);
    }

    public boolean safewalk() {
        return iiIiIiIII_Class425.I_field_5a;
    }

    public void setSafewalk(boolean bl) {
        iiIiIiIII_Class425.I_field_5a = bl;
    }

    public boolean logging() {
        return iiIiIiIII_Class425.II_field_5a;
    }

    public void setLogging(boolean bl) {
        iiIiIiIII_Class425.II_field_5a = bl;
    }

    private boolean start(iiiiIIiII_Class485 iiiiIIiII_Class4852) {
        if (!this.ready()) {
            return false;
        }
        try {
            iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(iiiiIIiII_Class4852);
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    @Nullable
    private iiiiIIiII_Class485 current() {
        return this.ready() ? (iiiiIIiII_Class485)iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_82bc9266().orElse(null) : null;
    }

    @Nullable
    private iiiIIIiii_Class456 executor() {
        return this.ready() ? iiIiiIiIi_Class438.I_method_12f562b5().I_method_3bb8fab5() : null;
    }

    private static BlockPos min(int n, int n2, int n3, int n4, int n5, int n6) {
        return new BlockPos(Math.min(n, n4), Math.min(n2, n5), Math.min(n3, n6));
    }

    private static BlockPos max(int n, int n2, int n3, int n4, int n5, int n6) {
        return new BlockPos(Math.max(n, n4), Math.max(n2, n5), Math.max(n3, n6));
    }
}

