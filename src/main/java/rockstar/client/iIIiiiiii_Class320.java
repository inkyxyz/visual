package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.ModelPartAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import pyrock.utility.render.ColorRGBA;

public final class iIIiiiiii_Class320 {
   public static List<iIIiiiiii_Class320.Nested1_568dd860> I_method_1e623069(LivingEntity var0) {
      ArrayList var1 = new ArrayList();
      MinecraftClient var2 = MinecraftClient.getInstance();
      EntityRenderDispatcher var3 = var2.getEntityRenderDispatcher();
      if (!(var3.getRenderer(var0) instanceof LivingEntityRenderer var5)) {
         return var1;
      } else {
         EntityModel var6 = var5.getModel();
         MatrixStack var7 = new MatrixStack();
         float var8 = var2.getRenderTickCounter().getTickDelta(true);
         Vec3d var9 = var0.getLerpedPos(var8);
         var7.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-var0.bodyYaw + 180.0F));
         var6.getParts().forEach(var3x -> I_method_58fb8709(var3x, var7, var1, var9, "root"));
         return var1;
      }
   }

   private static void I_method_58fb8709(ModelPart var0, MatrixStack var1, List<iIIiiiiii_Class320.Nested1_568dd860> var2, Vec3d var3, String var4) {
      var1.push();
      var0.rotate(var1);
      var0.forEachCuboid(
         var1,
         (var2x, var3x, var4x, var5x) -> {
            Matrix4f var6 = var2x.getPositionMatrix();
            Vec3d[] var7x = new Vec3d[8];
            Vector3f[] var8 = new Vector3f[]{
               new Vector3f(var5x.minX, var5x.minY, var5x.minZ),
               new Vector3f(var5x.maxX, var5x.minY, var5x.minZ),
               new Vector3f(var5x.minX, var5x.maxY, var5x.minZ),
               new Vector3f(var5x.maxX, var5x.maxY, var5x.minZ),
               new Vector3f(var5x.minX, var5x.minY, var5x.maxZ),
               new Vector3f(var5x.maxX, var5x.minY, var5x.maxZ),
               new Vector3f(var5x.minX, var5x.maxY, var5x.maxZ),
               new Vector3f(var5x.maxX, var5x.maxY, var5x.maxZ)
            };

            for (int var9 = 0; var9 < 8; var9++) {
               Vector3f var10 = new Vector3f(var8[var9]);
               var6.transformPosition(var10);
               double var11 = 0.0625;
               var7x[var9] = new Vec3d(var3.x + var10.x * var11, var3.y + var10.y * var11, var3.z + var10.z * var11);
            }

            var2.add(new iIIiiiiii_Class320.Nested1_568dd860(var7x, var3x));
         }
      );
      ModelPartAccessor var5 = (ModelPartAccessor)(Object)var0;

      for (Entry var7 : var5.rockstar$getChildren().entrySet()) {
         I_method_58fb8709((ModelPart)var7.getValue(), var1, var2, var3, var4 + "." + (String)var7.getKey());
      }

      var1.pop();
   }

   public static void I_method_2f6a399f(iIIiiiiii_Class320.Nested1_568dd860 var0, VertexConsumer var1, MatrixStack var2, ColorRGBA var3) {
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[0], var0.I_field_c4e0c195[1], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[1], var0.I_field_c4e0c195[3], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[3], var0.I_field_c4e0c195[2], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[2], var0.I_field_c4e0c195[0], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[4], var0.I_field_c4e0c195[5], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[5], var0.I_field_c4e0c195[7], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[7], var0.I_field_c4e0c195[6], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[6], var0.I_field_c4e0c195[4], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[0], var0.I_field_c4e0c195[4], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[1], var0.I_field_c4e0c195[5], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[2], var0.I_field_c4e0c195[6], var3);
      I_method_db06ef42(var2, var1, var0.I_field_c4e0c195[3], var0.I_field_c4e0c195[7], var3);
   }

   private static void I_method_db06ef42(MatrixStack var0, VertexConsumer var1, Vec3d var2, Vec3d var3, ColorRGBA var4) {
      iIiiIIiIi_Class358.I_method_e94f782(var0, var1, var2, var3, var4);
   }

   @Generated
   private iIIiiiiii_Class320() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static class Nested1_568dd860 {
      public Vec3d[] I_field_c4e0c195;
      public String I_field_523beb0a;

      public Nested1_568dd860(Vec3d[] var1, String var2) {
         this.I_field_c4e0c195 = var1;
         this.I_field_523beb0a = var2;
      }

      public Vec3d I_method_a3c35554() {
         double var1 = 0.0;
         double var3 = 0.0;
         double var5 = 0.0;

         for (Vec3d var10 : this.I_field_c4e0c195) {
            var1 += var10.x;
            var3 += var10.y;
            var5 += var10.z;
         }

         return new Vec3d(var1 / 8.0, var3 / 8.0, var5 / 8.0);
      }

      public boolean I_method_e6fe9af4(Vec3d var1) {
         double var2 = Double.MAX_VALUE;
         double var4 = Double.MAX_VALUE;
         double var6 = Double.MAX_VALUE;
         double var8 = -Double.MAX_VALUE;
         double var10 = -Double.MAX_VALUE;
         double var12 = -Double.MAX_VALUE;

         for (Vec3d var17 : this.I_field_c4e0c195) {
            var2 = Math.min(var2, var17.x);
            var4 = Math.min(var4, var17.y);
            var6 = Math.min(var6, var17.z);
            var8 = Math.max(var8, var17.x);
            var10 = Math.max(var10, var17.y);
            var12 = Math.max(var12, var17.z);
         }

         return var1.x >= var2 && var1.x <= var8 && var1.y >= var4 && var1.y <= var10 && var1.z >= var6 && var1.z <= var12;
      }
   }
}
