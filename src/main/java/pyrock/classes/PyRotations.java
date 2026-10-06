package pyrock.classes;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import rockstar.client.RockstarClient;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.AuraModule;

public class PyRotations {
    private iiIIiIiII_Class405 handler() {
        return RockstarClient.getInstance().I_method_58785402();
    }

    private AuraModule aura() {
        return RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
    }

    private iiIIiIIii_Class404 defaultRotation(Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            return iiIIiIiIi_Class406.I_method_a2bb2af5(livingEntity, this.aura());
        }
        if (entity == null) {
            return this.handler().i_method_10b2eeb5();
        }
        Vec3d vec3d = iiIIiIiIi_Class406.I_method_396699c1(entity);
        return iiIIiIiIi_Class406.I_method_bc8095a1(vec3d);
    }

    public List<Double> defaultAngles(Entity entity) {
        return this.angles(this.defaultRotation(entity));
    }

    public List<Double> current() {
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = this.handler().i_method_10b2eeb5();
        return this.angles(iiIIiIIii_Class4042);
    }

    public List<Double> player() {
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = this.handler().I_method_fb1d7ad5();
        return this.angles(iiIIiIIii_Class4042);
    }

    public boolean idling() {
        return this.handler().I_method_3d166e03();
    }

    public List<Double> toPoint(double d, double d2, double d3) {
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_bc8095a1(new Vec3d(d, d2, d3));
        return this.angles(iiIIiIIii_Class4042);
    }

    public List<Double> to(Entity entity) {
        if (entity == null) {
            return this.current();
        }
        Vec3d vec3d = iiIIiIiIi_Class406.I_method_396699c1(entity);
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_bc8095a1(vec3d);
        return this.angles(iiIIiIIii_Class4042);
    }

    public List<Double> gcd(double d, double d2, double d3, double d4) {
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiIi_Class406.I_method_565091b5(new iiIIiIIii_Class404(d, d2), new iiIIiIIii_Class404(d3, d4));
        return this.angles(iiIIiIIii_Class4042);
    }

    public List<Double> gcdStep(double d, double d2, double d3, double d4, double d5) {
        return this.gcdSteps(d, d2, d3, d4, d5, d5);
    }

    public List<Double> gcdSteps(double d, double d2, double d3, double d4, double d5, double d6) {
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = new iiIIiIIii_Class404(this.snapDelta((float)d, (float)d3, (float)d5, true), MathHelper.clamp((float)this.snapDelta((float)d2, (float)d4, (float)d6, false), (float)-90.0f, (float)90.0f));
        return this.angles(iiIIiIIii_Class4042);
    }

    public float vanillaStep() {
        return iiIIiIiIi_Class406.I_method_73b181cf();
    }

    public void apply(double d, double d2) {
        this.apply(d, d2, "silent", "normal", 180.0, 180.0);
    }

    public void apply(double d, double d2, String string, String string2) {
        this.apply(d, d2, string, string2, 180.0, 180.0);
    }

    public void apply(double d, double d2, String string, String string2, double d3, double d4) {
        this.apply(d, d2, string, string2, d3, d4, 180.0, true);
    }

    public void apply(double d, double d2, String string, String string2, double d3, double d4, double d5, boolean bl) {
        this.handler().I_method_3eb39c6f(new iiIIiIIii_Class404(d, d2), PyRotations.parseCorrection(string), (float)d3, (float)d4, (float)d5, PyRotations.parsePriority(string2), bl);
    }

    public static iiIIiIIIi_Class402 parseCorrection(String string) {
        if (string == null) {
            return iiIIiIIIi_Class402.Ii_field_32e0c64c;
        }
        return switch (string.toLowerCase()) {
            case "none", "off" -> iiIIiIIIi_Class402.I_field_32e0c64c;
            case "direct" -> iiIIiIIIi_Class402.i_field_32e0c64c;
            case "strict" -> iiIIiIIIi_Class402.II_field_32e0c64c;
            case "smooth", "smooth_silent" -> iiIIiIIIi_Class402.iI_field_32e0c64c;
            case "change_look", "changelook", "change-look" -> iiIIiIIIi_Class402.ii_field_32e0c64c;
            case "targeted" -> iiIIiIIIi_Class402.III_field_32e0c64c;
            default -> iiIIiIIIi_Class402.Ii_field_32e0c64c;
        };
    }

    public static iiIIiIiiI_Class407 parsePriority(String string) {
        if (string == null) {
            return iiIIiIiiI_Class407.i_field_32efc66c;
        }
        return switch (string.toLowerCase()) {
            case "target", "to_target" -> iiIIiIiiI_Class407.II_field_32efc66c;
            case "override" -> iiIIiIiiI_Class407.Ii_field_32efc66c;
            case "use_item" -> iiIIiIiiI_Class407.iI_field_32efc66c;
            case "max" -> iiIIiIiiI_Class407.ii_field_32efc66c;
            case "low", "not_important" -> iiIIiIiiI_Class407.I_field_32efc66c;
            default -> iiIIiIiiI_Class407.i_field_32efc66c;
        };
    }

    private List<Double> angles(iiIIiIIii_Class404 iiIIiIIii_Class4042) {
        return List.of(Double.valueOf(iiIIiIIii_Class4042.I_method_14534e0f()), Double.valueOf(iiIIiIIii_Class4042.i_method_1461d9ef()));
    }

    private float snapDelta(float f, float f2, float f3, boolean bl) {
        float f4;
        float f5 = f4 = bl ? MathHelper.wrapDegrees((float)(f2 - f)) : f2 - f;
        if (f3 <= 0.0f || Float.isNaN(f3) || Float.isInfinite(f3)) {
            return f + f4;
        }
        return f + (float)Math.round(f4 / f3) * f3;
    }
}

