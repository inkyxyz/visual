package rockstar.client;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import rockstar.client.IIIiiiIi_Class30;
import rockstar.client.iiIiIiIIi_Class426;
import rockstar.client.iiIiIiIiI_Class427;
import rockstar.client.iiIiIiiII_Class429;
import rockstar.client.iiIiIiiIi_Class430;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiiIIiIii_Class460;
import rockstar.client.iiiIIiiii_Class464;
import rockstar.client.iiiIiiiii_Class480;
import rockstar.client.iiiiIIIiI_Class483;
import rockstar.client.iiiiIIIii_Class484;
import rockstar.client.iiiiIIiII_Class485;

public final class iiIiiIIiI_Class435
implements iiIiIiIIi_Class426 {
    private final List<iiIiIiiII_Class429> I_field_7865b31 = new CopyOnWriteArrayList<iiIiIiiII_Class429>();

    @Override
    public void I_method_54107219(BlockPos blockPos) {
        this.I_method_1e95cc67(new iiiIIiIii_Class460(blockPos));
    }

    @Override
    public void I_method_2dfe83db(BlockPos blockPos, boolean bl) {
        if (bl) {
            this.i_method_7e6405f9(blockPos);
        } else {
            this.I_method_54107219(blockPos);
        }
    }

    @Override
    public void I_method_1e95cc67(iiiIIiiii_Class464 iiiIIiiii_Class4642) {
        iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(new iiiiIIIiI_Class483(iiiIIiiii_Class4642));
    }

    @Override
    public void i_method_7e6405f9(BlockPos blockPos) {
        iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(new iiiIiiiii_Class480(blockPos));
    }

    @Override
    public void I_method_4d5c9de0(Identifier identifier) {
        Block block = (Block)Registries.BLOCK.get(identifier);
        iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(new iiiiIIIii_Class484(block));
    }

    @Override
    public void I_method_1381fa5f() {
        iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7d4e61ff();
    }

    @Override
    public boolean I_method_1381fa63() {
        return iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7d4e6203();
    }

    @Override
    public Optional<iiIiIiIiI_Class427> I_method_d5a25e06() {
        return iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_82bc9266().map(this::I_method_6235cbbd);
    }

    @Override
    public boolean I_method_cdb6ea6d(String string) {
        IIIiiiIi_Class30 iIIiiiIi_Class30 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_e75201b8();
        return iIIiiiIi_Class30.I_method_9e86975a(iIIiiiIi_Class30.I_method_80ea594() + " " + string);
    }

    @Override
    public void I_method_1c240ca7(iiIiIiiII_Class429 iiIiIiiII_Class4292) {
        this.I_field_7865b31.add(iiIiIiiII_Class4292);
    }

    @Override
    public void i_method_b93d14c7(iiIiIiiII_Class429 iiIiIiiII_Class4292) {
        this.I_field_7865b31.remove(iiIiIiiII_Class4292);
    }

    public void I_method_f2470087(iiIiIiiIi_Class430 iiIiIiiIi_Class4302) {
        for (iiIiIiiII_Class429 iiIiIiiII_Class4292 : this.I_field_7865b31) {
            try {
                iiIiIiiII_Class4292.I_method_3c531087(iiIiIiiIi_Class4302);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private iiIiIiIiI_Class427 I_method_6235cbbd(final iiiiIIiII_Class485 iiiiIIiII_Class4852) {
        return new iiIiIiIiI_Class427(){

            @Override
            public String I_method_2accd7e1() {
                return iiiiIIiII_Class4852.I_method_31075c81();
            }

            @Override
            public String i_method_bdeb8801() {
                return iiiiIIiII_Class4852.i_method_c4260ca1();
            }

            @Override
            public boolean I_method_79ae4ea3() {
                return iiiiIIiII_Class4852.i_method_8f4a01e3();
            }

            @Override
            public void I_method_79ae4e9f() {
                iiiiIIiII_Class4852.i_method_8f4a01df();
            }

            @Override
            public void i_method_79bcda7f() {
                iiiiIIiII_Class4852.II_method_58424142();
            }

            @Override
            public void II_method_bc2a7ca2() {
                iiiiIIiII_Class4852.I_method_8f3b75ff();
            }
        };
    }
}

