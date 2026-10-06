package rockstar.client;

import java.util.concurrent.ThreadLocalRandom;
import lombok.Generated;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import rockstar.client.ModeSetting;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.iiiIIIIi_Class226;
import rockstar.client.iiiIiIIi_Class234;
import rockstar.client.iiiIiIiI_Class235;
import rockstar.client.iiiIiiII_Class237;

public class iiiIIiii_Class232
extends iiiIIIIi_Class226 {
    private static final float I_field_46 = 0.45f;
    private static final float i_field_46 = 0.7f;
    private static final int I_field_49 = 4;
    private static final float II_field_46 = 1.1f;
    private static final float Ii_field_46 = 0.8f;
    private static final int i_field_49 = 12;
    private static final float iI_field_46 = 0.5f;
    private static final int II_field_49 = 30;
    private static final float ii_field_46 = 3.0f;
    private static final float III_field_46 = 5.0f;
    private static final float IIi_field_46 = 15.0f;
    private static final float IiI_field_46 = 3.0f;
    private final iiiIiIIi_Class234 I_field_649d1fa1 = new iiiIiIIi_Class234();
    private final iiiIiIIi_Class234 i_field_649d1fa1 = new iiiIiIIi_Class234();
    private final float[] I_field_b4b = new float[2];
    private final iiiIiIiI_Class235 I_field_649d93e1 = new iiiIiIiI_Class235();
    private int Ii_field_49 = -1;
    private int iI_field_49;
    private boolean I_field_5a;
    private boolean i_field_5a;

    public iiiIIiii_Class232(ModeSetting iIiiiiiII_Class125) {
        super(iIiiiiiII_Class125, "\u041d\u0435\u0439\u0440\u043e");
    }

    @Override
    public void rotate(iiIIiIiII_Class405 iiIIiIiII_Class4052, float f, boolean bl, boolean bl2, iiIIiIIIi_Class402 iiIIiIIIi_Class4022, LivingEntity livingEntity) {
        if (iiiIIiii_Class232.I_field_3a9bda27.player == null || livingEntity == null) {
            return;
        }
        iiiIiiII_Class237 iiiIiiII_Class2372 = iiiIiiII_Class237.I_method_7d0c47cb();
        if (iiiIiiII_Class2372 == null) {
            this.I_method_685930cc();
            iiIIiIiII_Class4052.I_method_1acbf705(iiIIiIiIi_Class406.I_method_bc8095a1(livingEntity.getBoundingBox().getCenter()), iiIIiIIIi_Class4022, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.II_field_32efc66c);
            return;
        }
        Box box = livingEntity.getBoundingBox();
        Vec3d vec3d = iiiIIiii_Class232.I_field_3a9bda27.player.getEyePos();
        Vec3d vec3d2 = box.getCenter().subtract(vec3d);
        double d = Math.max(Math.hypot(vec3d2.x, vec3d2.z), 0.05);
        float f2 = (float)Math.toDegrees(Math.atan2(vec3d2.z, vec3d2.x)) - 90.0f;
        float f3 = (float)(-Math.toDegrees(Math.atan2(vec3d2.y, d)));
        float f4 = Math.max((float)Math.toDegrees(Math.atan2(box.getLengthX() / 2.0, d)), 0.5f);
        float f5 = Math.max((float)Math.toDegrees(Math.atan2(box.getLengthY() / 2.0, d)), 0.5f);
        double d2 = iiiIIiii_Class232.I_method_60b14254(vec3d, box);
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiII_Class4052.i_method_10b2eeb5();
        if (livingEntity.getId() != this.Ii_field_49 || !this.I_field_649d1fa1.I_method_57fa0cf0()) {
            this.I_field_649d1fa1.I_method_e9d4590d(iiiIiiII_Class2372, iiIIiIIii_Class4042.I_method_14534e0f(), iiIIiIIii_Class4042.i_method_1461d9ef(), f2, f3);
            this.Ii_field_49 = livingEntity.getId();
        }
        this.iI_field_49 = 0;
        float f6 = 0.45f * iiiIiiII_Class2372.I_method_930e7044(ThreadLocalRandom.current().nextFloat());
        if (!this.I_field_649d1fa1.I_method_5863bed8(iiiIiiII_Class2372, iiIIiIIii_Class4042.I_method_14534e0f(), iiIIiIIii_Class4042.i_method_1461d9ef(), f2, f3, f4, f5, d2, f6, 12, 0.7f, 4, this.i_method_6867bc9c(), this.I_field_b4b)) {
            return;
        }
        iiIIiIiII_Class4052.I_method_1acbf705(new iiIIiIIii_Class404(iiIIiIIii_Class4042.I_method_14534e0f() + this.I_field_b4b[0], MathHelper.clamp((float)(iiIIiIIii_Class4042.i_method_1461d9ef() + this.I_field_b4b[1]), (float)-90.0f, (float)90.0f)), iiIIiIIIi_Class4022, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.II_field_32efc66c);
        if (this.I_field_5a) {
            this.I_field_5a = false;
            this.I_field_649d1fa1.i_method_580898cc();
        } else {
            this.I_field_649d1fa1.II_method_a75687f5();
        }
    }

    public iiIIiIIii_Class404 I_method_adc0dea2(iiIIiIIii_Class404 iiIIiIIii_Class4042, iiIIiIIii_Class404 iiIIiIIii_Class4043) {
        iiiIiiII_Class237 iiiIiiII_Class2372 = iiiIiiII_Class237.I_method_7d0c47cb();
        if (iiiIiiII_Class2372 == null || iiiIIiii_Class232.I_field_3a9bda27.player == null) {
            return null;
        }
        float f = Math.max(3.0f, iiIIiIiIi_Class406.I_method_73b181cf());
        if (Math.abs(MathHelper.wrapDegrees((float)(iiIIiIIii_Class4043.I_method_14534e0f() - iiIIiIIii_Class4042.I_method_14534e0f()))) <= f && Math.abs(iiIIiIIii_Class4043.i_method_1461d9ef() - iiIIiIIii_Class4042.i_method_1461d9ef()) <= f) {
            this.i_field_649d1fa1.I_method_57fa0cec();
            this.iI_field_49 = 0;
            return null;
        }
        if (++this.iI_field_49 > 30) {
            this.i_field_649d1fa1.I_method_57fa0cec();
            return null;
        }
        if (!this.i_field_649d1fa1.I_method_57fa0cf0()) {
            this.i_field_649d1fa1.I_method_e9d4590d(iiiIiiII_Class2372, iiIIiIIii_Class4042.I_method_14534e0f(), iiIIiIIii_Class4042.i_method_1461d9ef(), iiIIiIIii_Class4043.I_method_14534e0f(), iiIIiIIii_Class4043.i_method_1461d9ef());
        }
        if (!this.i_field_649d1fa1.I_method_5863bed8(iiiIiiII_Class2372, iiIIiIIii_Class4042.I_method_14534e0f(), iiIIiIIii_Class4042.i_method_1461d9ef(), iiIIiIIii_Class4043.I_method_14534e0f(), iiIIiIIii_Class4043.i_method_1461d9ef(), 5.0f, 15.0f, 3.0, 0.0f, 12, 0.7f, 4, 1.1f, this.I_field_b4b)) {
            return null;
        }
        this.i_field_649d1fa1.II_method_a75687f5();
        return new iiIIiIIii_Class404(iiIIiIIii_Class4042.I_method_14534e0f() + this.I_field_b4b[0], MathHelper.clamp((float)(iiIIiIIii_Class4042.i_method_1461d9ef() + this.I_field_b4b[1]), (float)-90.0f, (float)90.0f));
    }

    private float i_method_6867bc9c() {
        return iiiIIiii_Class232.I_field_3a9bda27.player != null && iiiIIiii_Class232.I_field_3a9bda27.player.isSubmergedInWater() && iIIIiiiII_Class285.Ii_method_b349c526() ? 0.8f : 1.1f;
    }

    @Override
    public void attack() {
        this.I_field_5a = true;
    }

    @Override
    public void enabled() {
        iiiIiiII_Class237.I_method_1d8494ec();
        this.I_field_649d1fa1.I_method_57fa0cec();
        this.i_field_649d1fa1.I_method_57fa0cec();
        this.Ii_field_49 = -1;
        this.i_field_5a = false;
    }

    @Override
    public void targetNull() {
        this.I_field_649d1fa1.I_method_57fa0cec();
        this.Ii_field_49 = -1;
        this.I_field_5a = false;
    }

    public boolean I_method_685930d0() {
        return iiiIiiII_Class237.I_method_7d0c47cb() != null;
    }

    private void I_method_685930cc() {
        if (this.i_field_5a) {
            return;
        }
        this.i_field_5a = true;
        iIIIIIIii_Class260.II_method_e8fd4864((Text)Text.literal((String)("\u041c\u043e\u0434\u0435\u043b\u044c " + iiiIiiII_Class237.I_method_f16c5534() + " \u043d\u0435 \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u043b\u0430\u0441\u044c \u2014 \u043e\u0431\u0443\u0447\u0438 \u0447\u0435\u0440\u0435\u0437 .neuro train \u0438\u043b\u0438 \u0432\u044b\u0431\u0435\u0440\u0438 \u0434\u0440\u0443\u0433\u0443\u044e: .neuro list")));
    }

    public static float I_method_685930bc() {
        return 0.7f;
    }

    public static double I_method_60b14254(Vec3d vec3d, Box box) {
        double d = Math.max(Math.max(box.minX - vec3d.x, 0.0), vec3d.x - box.maxX);
        double d2 = Math.max(Math.max(box.minY - vec3d.y, 0.0), vec3d.y - box.maxY);
        double d3 = Math.max(Math.max(box.minZ - vec3d.z, 0.0), vec3d.z - box.maxZ);
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    @Generated
    public iiiIiIiI_Class235 I_method_7c26b42b() {
        return this.I_field_649d93e1;
    }
}

