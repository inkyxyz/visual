package rockstar.client;

import java.util.function.BiConsumer;
import lombok.Generated;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiii_Class136;
import rockstar.client.iIIIiIII_Class137;
import rockstar.client.iIIIiiII_Class141;
import rockstar.client.iIIIiiii_Class144;
import rockstar.client.iIIiIIII_Class145;

public class iIIIiiIi_Class142
implements iIIIiiII_Class141,
iIIIiiii_Class144 {
    private final String I_field_523beb0a;
    private final RegistryEntry<StatusEffect> I_field_3b804775;
    private final iIIIIiii_Class136 I_field_c9fc2f81;
    private final iIIIIiii_Class136 i_field_c9fc2f81;
    private final BiConsumer<Integer, Integer> I_field_17cc1433;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private int I_field_49;
    private int i_field_49;

    public iIIIiiIi_Class142(String string, RegistryEntry<StatusEffect> registryEntry, int n, int n2, BiConsumer<Integer, Integer> biConsumer) {
        this.I_field_523beb0a = string;
        this.I_field_3b804775 = registryEntry;
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.I_field_17cc1433 = biConsumer;
        this.I_field_5a = n >= 0 && n2 > 0;
        this.I_field_c9fc2f81 = new iIIIIiii_Class136("");
        this.I_field_c9fc2f81.I_method_7d663b96(String.valueOf(Math.max(0, n + 1)));
        this.i_field_c9fc2f81 = new iIIIIiii_Class136("");
        this.i_field_c9fc2f81.I_method_7d663b96(String.valueOf(n2));
    }

    @Override
    public float I_method_c52f08dc() {
        if (!this.I_field_5a || !this.i_field_5a) {
            return 20.0f;
        }
        return 56.0f;
    }

    @Override
    public void I_method_bc6592c6(III iII, float f, float f2, float f3) {
        ColorRGBA colorRGBA = this.I_field_5a ? IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(50.0f) : IiiiiIIIi_Class242.Ii_method_a0f56f71();
        iII.drawRoundedRect(f, f2, f3, 17.0f, IIiii_Class8.I_method_893b2757(3.0f), colorRGBA);
        iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), this.I_field_523beb0a, f + 6.0f, f2 + 6.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1());
        if (this.I_field_5a && this.i_field_5a) {
            float f4 = f2 + 20.0f;
            iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), "\u0423\u0440\u043e\u0432\u0435\u043d\u044c", f + 4.0f, f4 + 4.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(180.0f));
            this.I_field_c9fc2f81.I_method_ed5425da(iII, f + f3 - 30.0f, f4, 26.0f, 14.0f);
            iII.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), "\u0414\u043b\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c", f + 4.0f, (f4 += 18.0f) + 4.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(180.0f));
            this.i_field_c9fc2f81.I_method_ed5425da(iII, f + f3 - 30.0f, f4, 26.0f, 14.0f);
        }
    }

    @Override
    public boolean I_method_dd6e4c7a(iIIIiIII_Class137 iIIIiIII_Class1372, double d, double d2, int n) {
        if (this.i_field_5a) {
            if (this.I_field_c9fc2f81.I_method_aac23190(d, d2)) {
                this.I_field_c9fc2f81.I_method_dc381f88(true);
                this.i_field_c9fc2f81.I_method_dc381f88(false);
                return true;
            }
            if (this.i_field_c9fc2f81.I_method_aac23190(d, d2)) {
                this.i_field_c9fc2f81.I_method_dc381f88(true);
                this.I_field_c9fc2f81.I_method_dc381f88(false);
                return true;
            }
        }
        if (n == 1) {
            if (!this.I_field_5a) {
                return false;
            }
            if (this.i_field_5a) {
                this.I_method_c154a4cc();
            }
            this.i_field_5a = !this.i_field_5a;
            return true;
        }
        if (n == 0) {
            if (this.i_field_5a) {
                this.I_method_c154a4cc();
                this.i_field_5a = false;
            }
            if (this.I_field_5a) {
                this.I_field_5a = false;
                this.I_field_49 = -1;
                this.i_field_49 = 0;
                this.I_field_17cc1433.accept(-1, 0);
            } else {
                this.I_field_5a = true;
                this.I_field_49 = 0;
                this.i_field_49 = 600;
                this.I_field_c9fc2f81.I_method_7d663b96("1");
                this.i_field_c9fc2f81.I_method_7d663b96("600");
                this.I_field_17cc1433.accept(this.I_field_49, this.i_field_49);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean I_method_2b5b5d30() {
        return this.I_field_c9fc2f81.I_method_d58e2cd0() || this.i_field_c9fc2f81.I_method_d58e2cd0();
    }

    @Override
    public void i_method_2b69e90c() {
        if (this.I_method_2b5b5d30()) {
            this.I_method_c154a4cc();
            this.I_field_17cc1433.accept(this.I_field_49, this.i_field_49);
            this.I_field_c9fc2f81.I_method_dc381f88(false);
            this.i_field_c9fc2f81.I_method_dc381f88(false);
        }
    }

    public void I_method_c154a4cc() {
        iIIiIIII_Class145.I_method_cd62d617(this.I_field_c9fc2f81, this.I_field_49, iIIiIIII_Class145.I_method_b6bb3a42(1, 256), iIIiIIII_Class145.i_method_60c1ae6d(0), n -> {
            this.I_field_49 = n - 1;
        });
        iIIiIIII_Class145.I_method_38600fd1(this.i_field_c9fc2f81, this.i_field_49, iIIiIIII_Class145.I_method_ccbc4e4d(1), n -> {
            this.i_field_49 = n;
        });
    }

    @Generated
    public String I_method_f3820154() {
        return this.I_field_523beb0a;
    }

    @Generated
    public RegistryEntry<StatusEffect> I_method_ba25b53f() {
        return this.I_field_3b804775;
    }

    @Generated
    public iIIIIiii_Class136 I_method_82945bcb() {
        return this.I_field_c9fc2f81;
    }

    @Generated
    public iIIIIiii_Class136 i_method_ac90ebeb() {
        return this.i_field_c9fc2f81;
    }

    @Generated
    public BiConsumer<Integer, Integer> I_method_91b60629() {
        return this.I_field_17cc1433;
    }

    @Generated
    public boolean i_method_c16330b0() {
        return this.I_field_5a;
    }

    @Generated
    public boolean II_method_694eec19() {
        return this.i_field_5a;
    }

    @Generated
    public int I_method_c154a4bf() {
        return this.I_field_49;
    }

    @Generated
    public int i_method_c163309f() {
        return this.i_field_49;
    }
}

