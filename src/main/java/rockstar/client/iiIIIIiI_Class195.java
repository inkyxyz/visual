package rockstar.client;

import lombok.Generated;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
import rockstar.client.Setting;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.SliderSetting;
import rockstar.client.RockstarClient;
import rockstar.client.iiIIIIII_Class193;
import rockstar.client.iiIIIiII_Class197;

public class iiIIIIiI_Class195
extends iiIIIiII_Class197 {
    private final SliderSetting I_field_73178e8c = new Nested1_f8433cb3(this, "swing.anchorX").II_method_b0f56334(0.05f).I_method_c8c9a7d7(-5.0f).i_method_65e2aff7(5.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting i_field_73178e8c = new Nested1_f8433cb3(this, "swing.anchorY").II_method_b0f56334(0.05f).I_method_c8c9a7d7(-5.0f).i_method_65e2aff7(5.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting II_field_73178e8c = new Nested1_f8433cb3(this, "swing.anchorZ").II_method_b0f56334(0.05f).I_method_c8c9a7d7(-5.0f).i_method_65e2aff7(5.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting Ii_field_73178e8c = new Nested1_f8433cb3(this, "swing.moveX").II_method_b0f56334(0.05f).I_method_c8c9a7d7(-5.0f).i_method_65e2aff7(5.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting iI_field_73178e8c = new Nested1_f8433cb3(this, "swing.moveY").II_method_b0f56334(0.05f).I_method_c8c9a7d7(-5.0f).i_method_65e2aff7(5.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting ii_field_73178e8c = new Nested1_f8433cb3(this, "swing.moveZ").II_method_b0f56334(0.05f).I_method_c8c9a7d7(-3.0f).i_method_65e2aff7(3.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting III_field_73178e8c = new Nested1_f8433cb3(this, "swing.rotateX").II_method_b0f56334(15.0f).I_method_c8c9a7d7(-360.0f).i_method_65e2aff7(360.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting IIi_field_73178e8c = new Nested1_f8433cb3(this, "swing.rotateY").II_method_b0f56334(15.0f).I_method_c8c9a7d7(-360.0f).i_method_65e2aff7(360.0f).Ii_method_4e0e6b54(0.0f);
    private final SliderSetting IiI_field_73178e8c = new Nested1_f8433cb3(this, "swing.rotateZ").II_method_b0f56334(15.0f).I_method_c8c9a7d7(-360.0f).i_method_65e2aff7(360.0f).Ii_method_4e0e6b54(0.0f);

    @Generated
    public SliderSetting I_method_2db787a2() {
        return this.I_field_73178e8c;
    }

    @Generated
    public SliderSetting i_method_434cfb82() {
        return this.i_field_73178e8c;
    }

    @Generated
    public SliderSetting II_method_8ae3216b() {
        return this.II_field_73178e8c;
    }

    @Generated
    public SliderSetting Ii_method_a078954b() {
        return this.Ii_field_73178e8c;
    }

    @Generated
    public SliderSetting iI_method_27fc298b() {
        return this.iI_field_73178e8c;
    }

    @Generated
    public SliderSetting ii_method_3d919d6b() {
        return this.ii_field_73178e8c;
    }

    @Generated
    public SliderSetting III_method_d32ac0c2() {
        return this.III_field_73178e8c;
    }

    @Generated
    public SliderSetting IIi_method_e8c034a2() {
        return this.IIi_field_73178e8c;
    }

    @Generated
    public SliderSetting IiI_method_7043c8e2() {
        return this.IiI_field_73178e8c;
    }

    public static class Nested1_f8433cb3
    extends SliderSetting {
        public Nested1_f8433cb3(@NotNull IIiiiIIiI_Class115 iIiiiIIiI_Class115, String string) {
            super(iIiiiIIiI_Class115, string);
        }

        @Override
        public void I_method_a1eda161(float f) {
            super.I_method_a1eda161(f);
            if (iiIIIIII_Class193.hasShiftDown()) {
                Nested1_f8433cb3 nested1_f8433cb3;
                for (Setting iIiiiIIII_Class113 : RockstarClient.getInstance().I_method_11732eb().I_method_94b5d40b().getSettings()) {
                    if (!iIiiiIIII_Class113.getName().equals(this.getName()) || !(iIiiiIIII_Class113 instanceof Nested1_f8433cb3)) continue;
                    nested1_f8433cb3 = (Nested1_f8433cb3)iIiiiIIII_Class113;
                    nested1_f8433cb3.i_method_c13b75d9(f);
                }
                for (Setting iIiiiIIII_Class113 : RockstarClient.getInstance().I_method_11732eb().i_method_beb2642b().getSettings()) {
                    if (!iIiiiIIII_Class113.getName().equals(this.getName()) || !(iIiiiIIII_Class113 instanceof Nested1_f8433cb3)) continue;
                    nested1_f8433cb3 = (Nested1_f8433cb3)iIiiiIIII_Class113;
                    nested1_f8433cb3.i_method_c13b75d9(f);
                }
            }
        }

        private void i_method_c13b75d9(float f) {
            this.Ii_field_46 = MathHelper.clamp((float)((float)((double)Math.round((double)f * (1.0 / (double)this.II_field_46)) / (1.0 / (double)this.II_field_46))), (float)this.I_field_46, (float)this.i_field_46);
        }
    }
}

