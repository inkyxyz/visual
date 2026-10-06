package rockstar.client;

import java.util.function.Function;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import rockstar.client.iiIIIiiii_Class400;

@Environment(value=EnvType.CLIENT)
public class iiIIiIIII_Class401
extends Model {
    private final ModelPart I_field_aa804e69;
    private final ModelPart i_field_aa804e69;
    private final ModelPart II_field_aa804e69;
    private final ModelPart Ii_field_aa804e69;
    private final ModelPart iI_field_aa804e69;
    private final ModelPart ii_field_aa804e69;
    private final ModelPart III_field_aa804e69;
    private final ModelPart IIi_field_aa804e69;

    public iiIIiIIII_Class401(ModelPart modelPart) {
        this(modelPart, RenderLayer::getEntityTranslucent);
    }

    public iiIIiIIII_Class401(ModelPart modelPart, Function<Identifier, RenderLayer> function) {
        super(modelPart, function);
        this.I_field_aa804e69 = modelPart.getChild("head");
        this.i_field_aa804e69 = modelPart.getChild("neck");
        this.II_field_aa804e69 = modelPart.getChild("body");
        this.Ii_field_aa804e69 = modelPart.getChild("front_left_leg");
        this.iI_field_aa804e69 = modelPart.getChild("front_right_leg");
        this.ii_field_aa804e69 = modelPart.getChild("left_back_leg");
        this.III_field_aa804e69 = modelPart.getChild("right_back_leg");
        this.IIi_field_aa804e69 = modelPart.getChild("tail");
    }

    public static TexturedModelData I_method_5dbc5bf2() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0f, -3.0f, -4.0f, 6.0f, 6.0f, 4.0f, Dilation.NONE).uv(21, 0).cuboid(-1.5f, 0.0f, -7.0f, 3.0f, 3.0f, 3.0f, Dilation.NONE), ModelTransform.pivot((float)0.0f, (float)10.5f, (float)-6.8f));
        modelPartData2.addChild("left_ear", ModelPartBuilder.create().uv(32, 4).cuboid(0.0f, -5.0f, -1.5f, 1.0f, 3.0f, 3.0f, Dilation.NONE).uv(34, 1).cuboid(0.0f, -5.5f, -0.75f, 1.0f, 1.0f, 2.0f, Dilation.NONE), ModelTransform.pivot((float)3.0f, (float)3.0f, (float)-2.0f));
        modelPartData2.addChild("right_ear", ModelPartBuilder.create().uv(32, 4).mirrored().cuboid(-1.0f, -5.0f, -1.5f, 1.0f, 3.0f, 3.0f, Dilation.NONE).uv(34, 1).mirrored().cuboid(-1.0f, -5.5f, -0.75f, 1.0f, 1.0f, 2.0f, Dilation.NONE), ModelTransform.pivot((float)-3.0f, (float)3.0f, (float)-2.0f));
        modelPartData.addChild("neck", ModelPartBuilder.create().uv(15, 7).cuboid(-2.95f, -1.0f, -4.0f, 5.9f, 5.0f, 6.0f, Dilation.NONE), ModelTransform.of((float)0.0f, (float)10.5f, (float)-5.0f, (float)((float)Math.toRadians(-25.0)), (float)0.0f, (float)0.0f));
        ModelPartData modelPartData3 = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot((float)0.0f, (float)13.5f, (float)-5.0f));
        modelPartData3.addChild("chest", ModelPartBuilder.create().uv(32, 13).cuboid(-4.0f, -3.5f, -3.0f, 8.0f, 7.0f, 6.0f, Dilation.NONE), ModelTransform.pivot((float)0.0f, (float)0.0f, (float)3.0f));
        modelPartData3.addChild("back", ModelPartBuilder.create().uv(3, 19).cuboid(-3.0f, -3.0f, -0.5f, 6.0f, 6.0f, 11.0f, Dilation.NONE), ModelTransform.pivot((float)0.0f, (float)-0.5f, (float)5.5f));
        modelPartData.addChild("front_left_leg", ModelPartBuilder.create().uv(42, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, Dilation.NONE), ModelTransform.pivot((float)1.5f, (float)16.0f, (float)-3.0f));
        modelPartData.addChild("front_right_leg", ModelPartBuilder.create().uv(42, 0).mirrored().cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, Dilation.NONE), ModelTransform.pivot((float)-1.5f, (float)16.0f, (float)-3.0f));
        modelPartData.addChild("left_back_leg", ModelPartBuilder.create().uv(52, 0).cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, Dilation.NONE), ModelTransform.pivot((float)1.5f, (float)16.0f, (float)9.0f));
        modelPartData.addChild("right_back_leg", ModelPartBuilder.create().uv(52, 0).mirrored().cuboid(-1.0f, 0.0f, -1.0f, 2.0f, 5.0f, 2.0f, Dilation.NONE), ModelTransform.pivot((float)-1.5f, (float)16.0f, (float)9.0f));
        modelPartData.addChild("tail", ModelPartBuilder.create().uv(2, 12).cuboid(-1.0f, 2.0f, -1.0f, 2.0f, 8.0f, 2.0f, Dilation.NONE), ModelTransform.of((float)0.0f, (float)9.0f, (float)10.0f, (float)((float)Math.toRadians(22.5)), (float)0.0f, (float)0.0f));
        return TexturedModelData.of((ModelData)modelData, (int)60, (int)36);
    }

    public void I_method_c8f6425(float f, iiIIIiiii_Class400 iiIIIiiii_Class4002) {
        super.resetTransforms();
        this.I_field_aa804e69.yaw = iiIIIiiii_Class4002.i_method_fe7320f() * ((float)Math.PI / 180);
        this.I_field_aa804e69.pitch = iiIIIiiii_Class4002.II_method_eb4b18f2() * ((float)Math.PI / 180);
        this.Ii_field_aa804e69.pitch = MathHelper.cos((float)(iiIIIiiii_Class4002.II_field_46 * 0.6662f)) * 1.4f * iiIIIiiii_Class4002.i_field_46;
        this.iI_field_aa804e69.pitch = MathHelper.cos((float)(iiIIIiiii_Class4002.II_field_46 * 0.6662f + (float)Math.PI)) * 1.4f * iiIIIiiii_Class4002.i_field_46;
        this.ii_field_aa804e69.pitch = MathHelper.cos((float)(iiIIIiiii_Class4002.II_field_46 * 0.6662f + (float)Math.PI)) * 1.4f * iiIIIiiii_Class4002.i_field_46;
        this.III_field_aa804e69.pitch = MathHelper.cos((float)(iiIIIiiii_Class4002.II_field_46 * 0.6662f)) * 1.4f * iiIIIiiii_Class4002.i_field_46;
        if (iiIIIiiii_Class4002.I_method_fd8a643()) {
            this.Ii_field_aa804e69.pitch = (float)Math.toRadians(-90.0);
            this.iI_field_aa804e69.pitch = (float)Math.toRadians(-90.0);
            this.ii_field_aa804e69.pitch = (float)Math.toRadians(90.0);
            this.III_field_aa804e69.pitch = (float)Math.toRadians(90.0);
            this.Ii_field_aa804e69.yaw = (float)Math.toRadians(-22.0);
            this.iI_field_aa804e69.yaw = (float)Math.toRadians(22.0);
            this.ii_field_aa804e69.yaw = (float)Math.toRadians(22.0);
            this.III_field_aa804e69.yaw = (float)Math.toRadians(-22.0);
        } else {
            this.Ii_field_aa804e69.yaw = 0.0f;
            this.iI_field_aa804e69.yaw = 0.0f;
            this.ii_field_aa804e69.yaw = 0.0f;
            this.III_field_aa804e69.yaw = 0.0f;
        }
        this.IIi_field_aa804e69.pitch = (float)Math.toRadians(iiIIIiiii_Class4002.I_method_fd8a643() ? 45.0 : 22.0);
        float f2 = iiIIIiiii_Class4002.II_method_eb4b1906() ? 0.5f : (iiIIIiiii_Class4002.i_method_fe73223() ? 0.3f : 0.15f);
        float f3 = iiIIIiiii_Class4002.II_method_eb4b1906() ? 0.5f : 0.3f;
        this.IIi_field_aa804e69.roll = (float)(Math.toRadians(-22.5) + Math.toRadians(22.5) + (double)(MathHelper.cos((float)(f * f2)) * f3));
    }

    public void I_method_3542feb7(MatrixStack matrixStack, VertexConsumer vertexConsumer, int n, int n2, iiIIIiiii_Class400 iiIIIiiii_Class4002, float f) {
        this.I_method_c8f6425(f, iiIIIiiii_Class4002);
        matrixStack.push();
        float f2 = 1.0f;
        matrixStack.scale(f2, f2, f2);
        matrixStack.translate(0.0, 1.3 - (iiIIIiiii_Class4002.I_method_fd8a643() ? 0.3 : 0.0), 0.0);
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(iiIIIiiii_Class4002.I_method_fd8a62f()));
        this.root.render(matrixStack, vertexConsumer, n, n2);
        matrixStack.pop();
    }
}

