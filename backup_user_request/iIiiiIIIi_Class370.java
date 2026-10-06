package rockstar.client;

import net.minecraft.client.render.Camera;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import rockstar.client.IIIIII;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.Iiiii_Class16;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiIiiiii_Class352;
import rockstar.client.iIiiiIIII_Class369;

public class iIiiiIIIi_Class370
implements iIIiIIiIi_Class294 {
    private static final float I_field_46 = 24.0f;
    private static final float i_field_46 = 0.034f;
    private static final float II_field_46 = 17.0f;
    private static final float Ii_field_46 = 42.0f;
    private static final float iI_field_46 = 30.0f;
    private static final float ii_field_46 = 0.0f;
    private static final int I_field_49 = 4000;
    private static final int i_field_49 = 178;
    private static final int II_field_49 = 196;
    private static final int Ii_field_49 = 214;
    private final iIiIiiiii_Class352 I_field_a84a762c = new iIiIiiiii_Class352();
    private final iIiiiIIII_Class369 I_field_433fe64c = new iIiiiIIII_Class369();
    private final IIIIII I_field_83aa0e21 = new IIIIII(RockstarClient.id("rain_screen/data"));
    private final IIIIII.Nested1_b340d733 I_field_415ebc9c = new IIIIII.Nested1_b340d733();
    private final Matrix4f I_field_d754d74 = new Matrix4f();
    private final Matrix4f i_field_d754d74 = new Matrix4f();
    private final Vector3f I_field_63d378f1 = new Vector3f();
    private final Vector3f i_field_63d378f1 = new Vector3f();
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(350L, 1.0f, IiiiIiiII_Class237.Iii_field_dd60aac);

    public void I_method_c1ac83a0(Camera camera, Matrix4f matrix4f, Matrix4f matrix4f2, float f, float f2, float f3, float f4) {
        if (iIiiiIIIi_Class370.I_field_3a9bda27.world == null || iIiiiIIIi_Class370.I_field_3a9bda27.player == null) {
            return;
        }
        Vec3d vec3d = camera.getPos();
        this.I_field_433fe64c.I_method_7ef4161f(vec3d.x, vec3d.y, vec3d.z);
        this.I_method_3f588d60(camera, f2);
        this.I_field_d754d74.set((Matrix4fc)matrix4f2).mul((Matrix4fc)matrix4f);
        this.I_field_a84a762c.I_method_8bb4fbf(this.I_field_d754d74, this.I_method_4cd89b4(f), false, this.I_field_433fe64c.I_method_35b0603() ? this.I_field_433fe64c.I_method_b5eddd0e() : null);
        float f5 = this.I_field_dc7facc.I_method_edd6dd11(iIiiiIIIi_Class370.I_field_3a9bda27.world.isSkyVisible(BlockPos.ofFloored((Position)iIiiiIIIi_Class370.I_field_3a9bda27.player.getEyePos())) ? 1.0f : 0.0f);
        float f6 = f3 * f5;
        if (f6 <= 0.01f && f4 <= 0.01f) {
            return;
        }
        Iiiii_Class16.Nested1_eba0a780 nested1_eba0a780 = this.I_field_a84a762c.I_method_f71fff90();
        this.I_field_415ebc9c.I_field_46 = nested1_eba0a780.I_field_46;
        this.I_field_415ebc9c.i_field_46 = nested1_eba0a780.i_field_46;
        this.I_field_415ebc9c.II_field_46 = nested1_eba0a780.II_field_46;
        this.I_field_415ebc9c.Ii_field_46 = 0.69803923f;
        this.I_field_415ebc9c.iI_field_46 = 0.76862746f;
        this.I_field_415ebc9c.ii_field_46 = 0.8392157f;
        this.I_field_415ebc9c.III_field_46 = nested1_eba0a780.IiIi_field_46;
        this.I_field_415ebc9c.IIi_field_46 = f6;
        this.I_field_415ebc9c.IiI_field_46 = f4;
        this.I_field_415ebc9c.Iii_field_46 = this.I_field_433fe64c.I_method_35b05ef();
        this.I_field_415ebc9c.iII_field_46 = this.I_field_433fe64c.i_method_36991cf();
        this.I_field_415ebc9c.iIi_field_46 = this.I_field_433fe64c.II_method_6814b132();
        this.I_field_415ebc9c.iii_field_46 = 192.0f;
        this.I_field_415ebc9c.iiI_field_46 = this.I_field_433fe64c.I_method_35b0603() ? 1.0f : 0.0f;
        this.I_field_415ebc9c.I_field_49 = this.I_field_433fe64c.I_method_35b05f2();
        this.i_field_d754d74.set((Matrix4fc)this.I_field_d754d74).invert();
        this.I_field_83aa0e21.I_method_44cfaf9e(this.i_field_d754d74, this.I_field_415ebc9c);
    }

    public void I_method_39f619df() {
        this.I_field_a84a762c.I_method_bedaa5df();
        this.I_field_433fe64c.I_method_35b05ff();
    }

    private int I_method_4cd89b4(float f) {
        return Math.max(1, Math.round(4000.0f * f));
    }

    private void I_method_3f588d60(Camera camera, float f) {
        Iiiii_Class16.Nested1_eba0a780 nested1_eba0a780 = this.I_field_a84a762c.I_method_f71fff90();
        Vec3d vec3d = camera.getPos();
        nested1_eba0a780.I_field_46 = (float)vec3d.x;
        nested1_eba0a780.i_field_46 = (float)vec3d.y;
        nested1_eba0a780.II_field_46 = (float)vec3d.z;
        Quaternionf quaternionf = camera.getRotation();
        quaternionf.transform(this.I_field_63d378f1.set(1.0f, 0.0f, 0.0f));
        quaternionf.transform(this.i_field_63d378f1.set(0.0f, 1.0f, 0.0f));
        nested1_eba0a780.Ii_field_46 = this.I_field_63d378f1.x;
        nested1_eba0a780.iI_field_46 = this.I_field_63d378f1.y;
        nested1_eba0a780.ii_field_46 = this.I_field_63d378f1.z;
        nested1_eba0a780.III_field_46 = this.i_field_63d378f1.x;
        nested1_eba0a780.IIi_field_46 = this.i_field_63d378f1.y;
        nested1_eba0a780.IiI_field_46 = this.i_field_63d378f1.z;
        nested1_eba0a780.Iii_field_46 = 0.0f;
        nested1_eba0a780.iII_field_46 = -24.0f;
        nested1_eba0a780.iIi_field_46 = 0.0f;
        nested1_eba0a780.iiI_field_46 = 42.0f;
        nested1_eba0a780.iii_field_46 = 30.0f;
        nested1_eba0a780.IIII_field_46 = 42.0f;
        nested1_eba0a780.IiiI_field_46 = 0.034f;
        nested1_eba0a780.iIIi_field_46 = 17.0f;
        nested1_eba0a780.Iiii_field_46 = 0.05f;
        nested1_eba0a780.iIII_field_46 = 0.0f;
        nested1_eba0a780.IIIi_field_46 = 0.69803923f;
        nested1_eba0a780.IIiI_field_46 = 0.76862746f;
        nested1_eba0a780.IIii_field_46 = 0.8392157f;
        nested1_eba0a780.IiII_field_46 = f;
        nested1_eba0a780.iIiI_field_46 = this.I_field_433fe64c.I_method_35b05ef();
        nested1_eba0a780.iIii_field_46 = this.I_field_433fe64c.i_method_36991cf();
        nested1_eba0a780.iiII_field_46 = this.I_field_433fe64c.II_method_6814b132();
        nested1_eba0a780.iiiI_field_46 = 192.0f;
        nested1_eba0a780.iiIi_field_46 = this.I_field_433fe64c.I_method_35b0603() ? 1.0f : 0.0f;
        nested1_eba0a780.IiIi_field_46 = (float)(System.currentTimeMillis() % 3600000L) / 1000.0f;
    }
}

