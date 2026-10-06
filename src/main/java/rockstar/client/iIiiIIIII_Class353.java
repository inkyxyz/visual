package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIi_Class18;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIiI_Class27;
import ua.mintantileak.spk.Compile;

public class iIiiIIIII_Class353
implements iIIiIIiIi_Class294 {
    public static final iIiiIIIII_Class353 I_field_ca4d26c = new iIiiIIIII_Class353();
    private final CopyOnWriteArrayList<Nested1_9e74860> I_field_4588d803 = new CopyOnWriteArrayList();
    private final iIIIi_Class18 I_field_6424b50c = new iIIIi_Class18();
    private final IiIIIiII_Class69<WorldChangeEvent> I_field_3d936f41 = worldChangeEvent -> this.I_field_4588d803.clear();
    private final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41 = render3DEvent -> {
        if (this.I_field_4588d803.isEmpty()) {
            return;
        }
        List<iiIiI_Class27.Nested1_86a4a760> list = this.I_method_704d6a08((Render3DEvent)render3DEvent);
        if (list.isEmpty()) {
            return;
        }
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)render3DEvent.getProjectionMatrix()).mul((Matrix4fc)render3DEvent.getPositionMatrix()).invert();
        this.I_field_6424b50c.I_method_7d5e4200(matrix4f, list);
    };

    private iIiiIIIII_Class353() {
        this.I_field_6424b50c.I_method_a4c4eebf();
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    @Compile(obfuscation=4)
    public void I_method_7a2ce21f() {
    }

    public void I_method_966148cb(Vec3d vec3d, float f, float f2) {
        this.I_method_9f5a2f2c(vec3d, f, f2, null, 1.0f);
    }

    public void I_method_dbd99b14(Vec3d vec3d, float f, float f2, ColorRGBA colorRGBA) {
        this.I_method_9f5a2f2c(vec3d, f, f2, colorRGBA, 1.0f);
    }

    public void I_method_9f5a2f2c(Vec3d vec3d, float f, float f2, ColorRGBA colorRGBA, float f3) {
        if (iIiiIIIII_Class353.I_field_3a9bda27.world == null) {
            return;
        }
        long l = (long)(f2 * 1000.0f);
        long l2 = (long)((float)l * 0.3f);
        long l3 = Math.max(1L, l - l2);
        this.I_field_4588d803.add(new Nested1_9e74860(vec3d.x, vec3d.y, vec3d.z, f, l2, l3, f3));
    }

    private List<iiIiI_Class27.Nested1_86a4a760> I_method_704d6a08(Render3DEvent render3DEvent) {
        ArrayList<iiIiI_Class27.Nested1_86a4a760> arrayList = new ArrayList<iiIiI_Class27.Nested1_86a4a760>();
        long l = System.currentTimeMillis();
        Vec3d vec3d = render3DEvent.getCamera().getPos();
        this.I_field_4588d803.removeIf(nested1_9e74860 -> l - nested1_9e74860.II_field_4a > nested1_9e74860.I_field_4a + nested1_9e74860.i_field_4a);
        for (Nested1_9e74860 nested1_9e748602 : this.I_field_4588d803) {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            if (arrayList.size() >= 12) break;
            long l2 = l - nested1_9e748602.II_field_4a;
            long l3 = nested1_9e748602.I_field_4a + nested1_9e748602.i_field_4a;
            if (l3 <= 0L || (f5 = nested1_9e748602.I_field_46 * (f4 = (float)Math.pow(f3 = MathHelper.clamp((float)((float)l2 / (float)l3), (float)0.0f, (float)1.0f), 0.6f))) <= 0.001f || (f2 = (f = 1.0f - MathHelper.clamp((float)((f3 - 0.4f) / 0.6f), (float)0.0f, (float)1.0f)) * nested1_9e748602.i_field_46) <= 0.001f) continue;
            float f6 = MathHelper.clamp((float)(f5 * 0.12f), (float)0.5f, (float)1.2f);
            arrayList.add(new iiIiI_Class27.Nested1_86a4a760((float)(nested1_9e748602.I_field_44 - vec3d.x), (float)(nested1_9e748602.i_field_44 - vec3d.y), (float)(nested1_9e748602.II_field_44 - vec3d.z), f5, f6, 1.0f, 1.0f, 1.0f, f, f2));
        }
        return arrayList;
    }

    static final class Nested1_9e74860 {
        final double I_field_44;
        final double i_field_44;
        final double II_field_44;
        final float I_field_46;
        final long I_field_4a;
        final long i_field_4a;
        final float i_field_46;
        final long II_field_4a;

        Nested1_9e74860(double d, double d2, double d3, float f, long l, long l2, float f2) {
            this.I_field_44 = d;
            this.i_field_44 = d2;
            this.II_field_44 = d3;
            this.I_field_46 = f;
            this.I_field_4a = l;
            this.i_field_4a = l2;
            this.i_field_46 = f2;
            this.II_field_4a = System.currentTimeMillis();
        }
    }
}

