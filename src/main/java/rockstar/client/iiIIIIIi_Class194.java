package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import rockstar.client.Vector2Setting;
import rockstar.client.BooleanSetting;
import rockstar.client.SliderSetting;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIIIIiI_Class195;
import rockstar.client.iiIIIiII_Class197;
import rockstar.client.iiIIIiIi_Class198;
import rockstar.client.iiIIIiii_Class200;
import rockstar.client.iiIIiIIi_Class202;

public class iiIIIIIi_Class194 {
    private final List<iiIIIiii_Class200> I_field_7865b31 = new ArrayList<iiIIIiii_Class200>();
    private String I_field_523beb0a = "autosave";
    private final iiIIIiII_Class197 I_field_c6214f61 = new iiIIIiII_Class197();
    private final iiIIIIiI_Class195 I_field_c6133ba1 = new iiIIIIiI_Class195();
    private final iiIIIIiI_Class195 i_field_c6133ba1 = new iiIIIIiI_Class195();
    private final Vector2Setting I_field_ba204e4c = new Vector2Setting(this.I_field_c6214f61, "animation").I_method_d8522ef5(0.5f, 1.0f).i_method_de5a2ad5(0.5f, 0.0f);
    private final BooleanSetting I_field_ba20ca4c = new BooleanSetting(this.I_field_c6214f61, "swing.back").I_method_decd82b5();
    private final SliderSetting I_field_73178e8c = new SliderSetting(this.I_field_c6214f61, "swing.wing_speed").II_method_b0f56334(0.5f).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(5.0f).Ii_method_4e0e6b54(2.0f);

    private void I_method_32d5d4ac() {
        this.I_field_7865b31.add(new iiIIIiii_Class200("swings.block_hit", new Vec2f(0.5f, 1.0f), new Vec2f(0.5f, 0.0f), true, 2.0f, new iiIIIiIi_Class198(0.0f, -0.05f, -0.7f, 1.0500001f, -0.7f, -1.1f, -120.0f, -135.0f, -60.0f), new iiIIIiIi_Class198(0.0f, -0.05f, -0.7f, 1.0500001f, -0.7f, -1.1f, -120.0f, -180.0f, -60.0f)));
        this.I_field_7865b31.add(new iiIIIiii_Class200("swings.bonk", new Vec2f(0.40131578f, 0.53543305f), new Vec2f(0.0f, -0.24409449f), true, 2.0f, new iiIIIiIi_Class198(0.0f, -0.4f, -0.65000004f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f), new iiIIIiIi_Class198(0.0f, -0.4f, -0.65000004f, 0.0f, 0.0f, 0.0f, -45.0f, 0.0f, 0.0f)));
        this.I_field_7865b31.add(new iiIIIiii_Class200("swings.rotate_360", new Vec2f(0.43421054f, 0.61417323f), new Vec2f(0.04605263f, -0.26771653f), false, 2.0f, new iiIIIiIi_Class198(0.0f, -0.4f, -0.65000004f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f), new iiIIIiIi_Class198(0.0f, -0.4f, -0.65000004f, 0.0f, 0.0f, 0.0f, -360.0f, 0.0f, 0.0f)));
        this.I_field_7865b31.add(new iiIIIiii_Class200("swings.from_me", new Vec2f(0.42105263f, 0.87401575f), new Vec2f(0.3881579f, -0.4566929f), true, 2.0f, new iiIIIiIi_Class198(0.0f, 0.0f, -1.1f, 0.2f, 0.0f, -0.1f, -135.0f, 45.0f, 60.0f), new iiIIIiIi_Class198(0.0f, 0.0f, -1.1f, 0.2f, 0.0f, -0.3f, -180.0f, 45.0f, 60.0f)));
    }

    public iiIIIIIi_Class194() {
        this.I_method_32d5d4ac();
        if (!this.I_field_7865b31.isEmpty()) {
            this.I_method_3912c30d(this.I_field_7865b31.getFirst());
        }
    }

    public iiIIIiIi_Class198 I_method_417b4cc3(float f) {
        f = this.I_field_ba204e4c.I_method_71834715().ease(f, 0.0f, 1.0f, 1.0f);
        if (this.I_field_ba20ca4c.i_method_9b12da03()) {
            f = MathHelper.sin((float)(MathHelper.sqrt((float)f) * (float)Math.PI));
        }
        return new iiIIIiIi_Class198(this.I_method_3450544(this.I_field_c6133ba1.I_method_2db787a2(), this.i_field_c6133ba1.I_method_2db787a2(), f), this.I_method_3450544(this.I_field_c6133ba1.i_method_434cfb82(), this.i_field_c6133ba1.i_method_434cfb82(), f), this.I_method_3450544(this.I_field_c6133ba1.II_method_8ae3216b(), this.i_field_c6133ba1.II_method_8ae3216b(), f), this.I_method_3450544(this.I_field_c6133ba1.Ii_method_a078954b(), this.i_field_c6133ba1.Ii_method_a078954b(), f), this.I_method_3450544(this.I_field_c6133ba1.iI_method_27fc298b(), this.i_field_c6133ba1.iI_method_27fc298b(), f), this.I_method_3450544(this.I_field_c6133ba1.ii_method_3d919d6b(), this.i_field_c6133ba1.ii_method_3d919d6b(), f), this.I_method_3450544(this.I_field_c6133ba1.III_method_d32ac0c2(), this.i_field_c6133ba1.III_method_d32ac0c2(), f), this.I_method_3450544(this.I_field_c6133ba1.IIi_method_e8c034a2(), this.i_field_c6133ba1.IIi_method_e8c034a2(), f), this.I_method_3450544(this.I_field_c6133ba1.IiI_method_7043c8e2(), this.i_field_c6133ba1.IiI_method_7043c8e2(), f));
    }

    public final void I_method_3912c30d(iiIIIiii_Class200 iiIIIiii_Class2002) {
        if (iiIIIiii_Class2002 == null) {
            return;
        }
        this.I_field_ba204e4c.I_method_f4aeac5e(iiIIIiii_Class2002.I_method_172627a3()).i_method_4362bc7e(iiIIIiii_Class2002.i_method_bb1eab83());
        this.I_field_ba20ca4c.I_method_a4d009eb(iiIIIiii_Class2002.I_method_cbc2d8b0());
        this.I_field_73178e8c.I_method_a1eda161(iiIIIiii_Class2002.I_method_cbc2d89c());
        this.I_method_a4392a4e(this.I_field_c6133ba1, iiIIIiii_Class2002.I_method_55c367ab());
        this.I_method_a4392a4e(this.i_field_c6133ba1, iiIIIiii_Class2002.i_method_7fbff7cb());
        this.I_method_d1c7ab76(iiIIIiii_Class2002.I_method_62860974());
        iiIIiIIi_Class202 iiIIiIRockstarClient022 = RockstarClient.getInstance().I_method_2da230b();
        if (iiIIiIRockstarClient022 != null) {
            iiIIiIRockstarClient022.I_method_7885936d(null);
        }
    }

    private void I_method_a4392a4e(iiIIIIiI_Class195 iiIIIIiI_Class1952, iiIIIiIi_Class198 iiIIIiIi_Class1982) {
        iiIIIIiI_Class1952.I_method_2db787a2().I_method_a1eda161(iiIIIiIi_Class1982.I_method_2efb707c());
        iiIIIIiI_Class1952.i_method_434cfb82().I_method_a1eda161(iiIIIiIi_Class1982.i_method_2f09fc5c());
        iiIIIIiI_Class1952.II_method_8ae3216b().I_method_a1eda161(iiIIIiIi_Class1982.II_method_b0819845());
        iiIIIIiI_Class1952.Ii_method_a078954b().I_method_a1eda161(iiIIIiIi_Class1982.Ii_method_b0902425());
        iiIIIIiI_Class1952.iI_method_27fc298b().I_method_a1eda161(iiIIIiIi_Class1982.iI_method_b2448865());
        iiIIIIiI_Class1952.ii_method_3d919d6b().I_method_a1eda161(iiIIIiIi_Class1982.ii_method_b2531445());
        iiIIIIiI_Class1952.III_method_d32ac0c2().I_method_a1eda161(iiIIIiIi_Class1982.III_method_5fc0699c());
        iiIIIIiI_Class1952.IIi_method_e8c034a2().I_method_a1eda161(iiIIIiIi_Class1982.IIi_method_5fcef57c());
        iiIIIIiI_Class1952.IiI_method_7043c8e2().I_method_a1eda161(iiIIIiIi_Class1982.IiI_method_618359bc());
    }

    private float I_method_3450544(SliderSetting iiIIIIIIi_Class130, SliderSetting iiIIIIIIi_Class1302, float f) {
        return iIIiiiiiI_Class319.I_method_5f7ff5cf(iiIIIIIIi_Class130.Ii_method_a20abcd2(), iiIIIIIIi_Class1302.Ii_method_a20abcd2(), f);
    }

    public String I_method_5c4a8d74() {
        iiIIiIIi_Class202 iiIIiIRockstarClient022 = RockstarClient.getInstance().I_method_2da230b();
        return iiIIiIRockstarClient022.i_method_646d600b() != null ? iiIIiIRockstarClient022.i_method_646d600b().I_method_5141c934() : this.I_field_523beb0a;
    }

    @Generated
    public List<iiIIIiii_Class200> I_method_c2ce901b() {
        return this.I_field_7865b31;
    }

    @Generated
    public iiIIIiII_Class197 I_method_94c3e7cb() {
        return this.I_field_c6214f61;
    }

    @Generated
    public iiIIIIiI_Class195 I_method_94b5d40b() {
        return this.I_field_c6133ba1;
    }

    @Generated
    public iiIIIIiI_Class195 i_method_beb2642b() {
        return this.i_field_c6133ba1;
    }

    @Generated
    public Vector2Setting I_method_bfd0c322() {
        return this.I_field_ba204e4c;
    }

    @Generated
    public BooleanSetting I_method_bfd13f22() {
        return this.I_field_ba20ca4c;
    }

    @Generated
    public SliderSetting I_method_78c80362() {
        return this.I_field_73178e8c;
    }

    @Generated
    public void I_method_d1c7ab76(String string) {
        this.I_field_523beb0a = string;
    }
}

