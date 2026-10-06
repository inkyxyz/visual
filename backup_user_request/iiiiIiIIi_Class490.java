package rockstar.client;

import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iiIiiIIii_Class436;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiiiIIiiI_Class487;

public final class iiiiIiIIi_Class490 {
    private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = render3DEvent -> this.I_method_2e308eb2(render3DEvent.getMatrices(), render3DEvent.getCamera());

    public static iiiiIiIIi_Class490 I_method_b40e775d(iiIiiIiIi_Class438 iiIiiIiIi_Class4382) {
        iiiiIiIIi_Class490 iiiiIiIIi_Class4902 = new iiiiIiIIi_Class490();
        iiIiiIiIi_Class4382.I_method_ab199998().I_method_2257cd48(iiiiIiIIi_Class4902);
        return iiiiIiIIi_Class4902;
    }

    private void I_method_2e308eb2(MatrixStack matrixStack, Camera camera) {
        Box box = iiIiiIIii_Class436.I_method_29e64b35().I_method_7f661a53();
        if (box == null) {
            return;
        }
        ColorRGBA colorRGBA = IiiiiIIIi_Class242.i_method_5dfec6e();
        ColorRGBA colorRGBA2 = new ColorRGBA(colorRGBA.getRed(), colorRGBA.getGreen(), colorRGBA.getBlue()).withAlpha(40.0f);
        ColorRGBA colorRGBA3 = new ColorRGBA(colorRGBA.getRed(), colorRGBA.getGreen(), colorRGBA.getBlue()).withAlpha(220.0f);
        Vec3d vec3d = camera.getPos();
        matrixStack.push();
        matrixStack.translate(-vec3d.x, -vec3d.y, -vec3d.z);
        iiiiIIiiI_Class487.I_method_cba2798c(matrixStack, box, colorRGBA2);
        iiiiIIiiI_Class487.i_method_db052d6c(matrixStack, box, colorRGBA3);
        matrixStack.pop();
    }
}

