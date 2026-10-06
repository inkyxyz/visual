package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.GameRendererEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Aim Bot",
   category = ModuleCategory.COMBAT,
   III_method_a89e5834 = "modules.descriptions.aim_bot"
)
public class AimBotModule extends Module {
   private static final float I_field_46 = 0.05F;
   private static final float i_field_46 = 0.99F;
   private static final float II_field_46 = 3.0F;
   private static final float Ii_field_46 = 3.15F;
   private static final float iI_field_46 = 2.5F;
   private static final int I_field_49 = 80;
   private static final int i_field_49 = 6;
   private static final int II_field_49 = 6;
   private static final float ii_field_46 = 0.08F;
   private static final float III_field_46 = 0.98F;
   private static final float IIi_field_46 = 1.0F;
   private static final double I_field_44 = 12.0;
   private static final double i_field_44 = 8.0;
   private static final double II_field_44 = 0.05;
   private static final double Ii_field_44 = 1000.0;
   private static final int Ii_field_49 = 3;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 IiI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Iii_field_51de8227;
   private boolean I_field_5a = false;
   private int iI_field_49 = 0;
   private iiIIiIIii_Class404 I_field_32e13e6c = new iiIIiIIii_Class404(0.0F, 0.0F);
   private iiIIiIIii_Class404 i_field_32e13e6c = null;
   private long I_field_4a = 0L;
   private int ii_field_49 = -1;
   private int III_field_49 = -1;
   private final Deque<Vec3d> I_field_db650847 = new ArrayDeque<>();
   private Box I_field_bdfefbea = null;
   private boolean i_field_5a = false;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         if (!this.IiI_method_86a79210()) {
            this.I_field_5a = false;
            this.iI_field_49 = 0;
            this.i_field_32e13e6c = null;
            this.I_field_bdfefbea = null;
            this.III_field_49 = -1;
         } else {
            boolean var2 = I_field_3a9bda27.player.isUsingItem();
            if (var2 && !this.I_field_5a) {
               this.iI_field_49 = 1;
               this.I_field_32e13e6c = new iiIIiIIii_Class404(I_field_3a9bda27.player.getYaw(), I_field_3a9bda27.player.getPitch());
            }

            this.I_field_5a = var2;
            if (this.iI_field_49 > 0) {
               this.iI_field_49--;
               this.I_method_19156dda(this.I_field_32e13e6c);
               this.I_field_bdfefbea = null;
            } else {
               IiIIIiIiI_Class139 var3 = new IiIIIiIiI_Class139.Nested1_a87537e0()
                  .I_method_1f3a928b(this.Ii_field_51de8227.isSelected())
                  .i_method_da3212ab(this.iI_field_51de8227.isSelected())
                  .II_method_9a5032be(this.ii_field_51de8227.isSelected())
                  .iI_method_3e48b69e(this.III_field_51de8227.isSelected())
                  .ii_method_f94036be(this.IIi_field_51de8227.isSelected())
                  .III_method_81ee98eb(this.IiI_field_51de8227.isSelected())
                  .Ii_method_5547b2de(this.Iii_field_51de8227.isSelected())
                  .I_method_7d0aed77(this.I_field_73178e8c.Ii_method_a20abcd2())
                  .I_method_7ebd8d70();
               AimBotModule.Nested1_30a1b8d3 var4 = this.I_method_7b026d78(var3);
               if (var4 == null) {
                  this.i_field_32e13e6c = null;
                  this.I_field_bdfefbea = null;
               } else {
                  this.I_method_19156dda(var4.I_field_32e13e6c);
               }
            }
         }
      }
   };
   private final IiIIIiII_Class69<GameRendererEvent> i_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null) {
         if (!this.II_field_ba20ca4c.i_method_9b12da03()) {
            if (this.i_field_32e13e6c == null) {
               this.I_field_4a = 0L;
            } else {
               long var2 = System.nanoTime();
               float var4;
               if (this.I_field_4a == 0L) {
                  var4 = 0.016666668F;
               } else {
                  var4 = MathHelper.clamp((float)(var2 - this.I_field_4a) / 1.0E9F, 0.004166667F, 0.1F);
               }

               this.I_field_4a = var2;
               float var5 = 20.0F;
               float var6 = MathHelper.clamp(1.0F - (float)Math.exp(-var5 * var4), 0.01F, 0.95F);
               float var7 = MathHelper.wrapDegrees(this.i_field_32e13e6c.I_method_14534e0f() - I_field_3a9bda27.player.getYaw());
               float var8 = MathHelper.clamp(this.i_field_32e13e6c.i_method_1461d9ef(), -89.9F, 89.9F) - I_field_3a9bda27.player.getPitch();
               float var9 = I_field_3a9bda27.player.getYaw() + var7 * var6;
               float var10 = MathHelper.clamp(I_field_3a9bda27.player.getPitch() + var8 * var6, -90.0F, 90.0F);
               I_field_3a9bda27.player.setYaw(var9);
               I_field_3a9bda27.player.setPitch(var10);
               I_field_3a9bda27.player.setHeadYaw(var9);
               I_field_3a9bda27.player.setBodyYaw(var9);
            }
         }
      }
   };
   private final IiIIIiII_Class69<Render3DEvent> II_field_3d936f41 = var1 -> {
      if (this.i_field_ba20ca4c.i_method_9b12da03() && this.I_field_ba20ca4c.i_method_9b12da03()) {
         if (this.I_field_bdfefbea != null && I_field_3a9bda27.player != null) {
            ColorRGBA var2 = IiiiiIIIi_Class242.i_method_5dfec6e();
            MatrixStack var3 = var1.getMatrices();
            var3.push();
            iIiiiIIiI_Class371.I_method_642c0895(true);
            iIiiiIIiI_Class371.i_method_49a476f1(var3);
            RenderSystem.enableDepthTest();
            RenderSystem.disableDepthTest();
            RenderSystem.enableBlend();
            RenderSystem.disableCull();
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
            Camera var4 = I_field_3a9bda27.gameRenderer.getCamera();
            Vec3d var5 = var4.getPos();
            Box var6 = this.I_field_bdfefbea.offset(-var5.getX(), -var5.getY(), -var5.getZ());
            var3.push();
            var3.translate(var5.getX(), var5.getY(), var5.getZ());
            BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            iIiiIIiIi_Class358.i_method_5e35f7b9(var3, var7, var6, var2.mulAlpha(0.25F));
            iIiiiIIiI_Class371.I_method_c59155f0(var7);
            BufferBuilder var8 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
            iIiiIIiIi_Class358.Ii_method_c1caf816(var3, var8, var6, var2);
            iIiiiIIiI_Class371.I_method_c59155f0(var8);
            var3.pop();
            iIiiiIIiI_Class371.I_method_a0226e1f();
            var3.pop();
         }
      }
   };

   public AimBotModule() {
      this.IiI_method_86a7920c();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_86a7920c() {
      MultiSelectSetting var1 = new MultiSelectSetting(this, "modules.settings.aim_bot.items");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var1, "modules.settings.aim_bot.bow").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var1, "modules.settings.aim_bot.crossbow").select();
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var1, "modules.settings.aim_bot.trident").select();
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aim_bot.predict").I_method_decd82b5();
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aim_bot.draw_predicted_box", () -> !this.I_field_ba20ca4c.i_method_9b12da03())
         .I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aim_bot.silent_aim");
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.aim_bot.distance")
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(100.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(30.0F);
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.aim_bot.fov")
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(180.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(90.0F);
      MultiSelectSetting var2 = new MultiSelectSetting(this, "targets");
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var2, "players").select();
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var2, "animals").select();
      this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var2, "mobs").select();
      this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var2, "invisibles").select();
      this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var2, "nakedPlayers").select();
      this.Iii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var2, "rockUsers");
      this.IiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(var2, "friends");
   }

   @Override
   public void onDisable() {
      super.onDisable();
      this.i_field_32e13e6c = null;
      this.I_field_bdfefbea = null;
      this.I_field_db650847.clear();
      this.ii_field_49 = -1;
      this.III_field_49 = -1;
      this.I_field_4a = 0L;
   }

   private AimBotModule.Nested1_30a1b8d3 I_method_7b026d78(IiIIIiIiI_Class139 var1) {
      float var2 = this.I_method_5450b8bc();
      if (var2 < 0.5F) {
         this.I_field_bdfefbea = null;
         return null;
      } else {
         List var3 = this.I_method_179590ad(var1);
         if (var3.isEmpty()) {
            this.III_field_49 = -1;
            this.I_field_bdfefbea = null;
            return null;
         } else {
            AimBotModule.Nested1_30a1b8d3 var4 = null;
            int var5 = Math.min(var3.size(), 3);

            for (int var6 = 0; var6 < var5; var6++) {
               LivingEntity var7 = (LivingEntity)var3.get(var6);
               boolean var8 = this.III_field_49 != -1 ? var7.getId() == this.III_field_49 : var6 == 0;
               AimBotModule.Nested1_30a1b8d3 var9 = this.I_method_70cd01cd(var7, var2, var8);
               if (var9 != null) {
                  if (var9.I_method_7269d6cb()) {
                     this.III_field_49 = var9.I_method_7269d6ba();
                     this.I_field_bdfefbea = var9.I_method_ee2faedb();
                     return var9;
                  }

                  if (var4 == null) {
                     var4 = var9;
                  }
               }
            }

            if (var4 == null) {
               this.I_field_bdfefbea = null;
               return null;
            } else {
               this.III_field_49 = var4.I_method_7269d6ba();
               this.I_field_bdfefbea = var4.I_method_ee2faedb();
               return var4;
            }
         }
      }
   }

   private List<LivingEntity> I_method_179590ad(IiIIIiIiI_Class139 var1) {
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      Vec3d var3 = I_field_3a9bda27.player.getRotationVec(1.0F).normalize();
      double var4 = MathHelper.clamp(this.i_field_73178e8c.Ii_method_a20abcd2(), 1.0F, 180.0F) * 0.5;
      IiIIIiIIi_Class138 var6 = RockstarClient.getInstance().I_method_9a638462();
      ArrayList var7 = new ArrayList();

      for (Entity var9 : I_field_3a9bda27.world.getEntities()) {
         if (var9 instanceof LivingEntity var10 && var1.I_method_b72bafcb(var9)) {
            boolean var11 = var10.getId() == this.III_field_49;
            double var12 = this.I_method_f81aca7f(var2, var3, var10);
            if (!(var12 > (var11 ? var4 + 12.0 : var4))) {
               double var14 = var12 + var2.distanceTo(var10.getBoundingBox().getCenter()) * 0.05;
               if (var11) {
                  var14 -= 8.0;
               }

               if (var6 != null && var6.I_method_9db25e6d(var10.getName().getString())) {
                  var14 -= 1000.0;
               }

               var7.add(new AimBotModule.Nested1_30a1b8f3(var10, var14));
            }
         }
      }

      var7.sort(Comparator.comparingDouble(AimBotModule.Nested1_30a1b8f3::I_method_a904ea95));
      ArrayList var16 = new ArrayList(var7.size());

      for (AimBotModule.Nested1_30a1b8f3 var18 : (Iterable<AimBotModule.Nested1_30a1b8f3>)(Iterable<?>)var7) {
         var16.add(var18.I_method_a8415db4());
      }

      return var16;
   }

   private double I_method_f81aca7f(Vec3d var1, Vec3d var2, LivingEntity var3) {
      Vec3d var4 = var3.getBoundingBox().getCenter().subtract(var1);
      double var5 = var4.length();
      if (var5 < 1.0E-4) {
         return 0.0;
      } else {
         double var7 = MathHelper.clamp(var2.dotProduct(var4.multiply(1.0 / var5)), -1.0, 1.0);
         double var9 = Math.toDegrees(Math.acos(var7));
         double var11 = Math.toDegrees(Math.atan2(Math.max(var3.getWidth() * 0.5, var3.getHeight() * 0.35), var5));
         return Math.max(0.0, var9 - var11);
      }
   }

   private AimBotModule.Nested1_30a1b8d3 I_method_70cd01cd(LivingEntity var1, float var2, boolean var3) {
      Vec3d var4 = I_field_3a9bda27.player.getEyePos();
      Vec3d var5 = this.I_field_ba20ca4c.i_method_9b12da03() ? this.I_method_773e9aa7(var1, var4, var2, var3).subtract(var1.getPos()) : Vec3d.ZERO;
      Box var6 = var1.getBoundingBox().offset(var5.x, var5.y, var5.z);
      iiIIiIIii_Class404 var7 = null;
      iiIIiIIii_Class404 var8 = null;
      double var9 = Double.MAX_VALUE;
      double var11 = Double.MAX_VALUE;
      List var13 = this.I_method_defce0e(var1, var5);

      for (int var14 = 0; var14 < var13.size(); var14++) {
         iiIIiIIii_Class404 var15 = this.I_method_c76cb34a(var4, (Vec3d)var13.get(var14), var2);
         if (var15 != null) {
            double var16 = this.I_method_19156dca(var15) + var14 * 0.75;
            if (var16 < var11) {
               var11 = var16;
               var8 = var15;
            }

            if (var16 < var9 && this.I_method_18404be9(var4, var15, var2, var1, var5)) {
               var9 = var16;
               var7 = var15;
            }
         }
      }

      if (var7 != null) {
         return new AimBotModule.Nested1_30a1b8d3(var7, var6, true, var1.getId());
      } else {
         return var8 != null ? new AimBotModule.Nested1_30a1b8d3(var8, var6, false, var1.getId()) : null;
      }
   }

   private Vec3d I_method_773e9aa7(LivingEntity var1, Vec3d var2, float var3, boolean var4) {
      Vec3d var5 = var4 ? this.I_method_4ec9780b(var1) : new Vec3d(var1.getX() - var1.prevX, var1.getY() - var1.prevY, var1.getZ() - var1.prevZ);
      Vec3d var6 = var1.getPos();
      boolean var7 = !var1.isOnGround() && !var1.isClimbing() && !var1.isTouchingWater() && !var1.hasNoGravity();
      double var8 = var4 ? this.I_method_5450b8ba() : 0.9;
      Vec3d var10 = new Vec3d(var5.x * var8, 0.0, var5.z * var8);
      double var11 = var5.y;
      double var13 = var2.distanceTo(var6) / var3;
      Vec3d var15 = var6;

      for (int var16 = 0; var16 < 6; var16++) {
         Vec3d var17 = this.I_method_541b81c7(var1, var6, var10, var13);
         double var18 = this.I_method_df26a6b6(var11, var13, var7);
         var15 = var6.add(var17.x, var18, var17.z);
         double var20 = this.I_method_544cc720(var2, var15, var3);
         if (!Double.isNaN(var20) && !(var20 < 0.0)) {
            if (Math.abs(var20 - var13) < 0.05) {
               break;
            }

            var13 = var20;
         } else {
            var13 = var2.distanceTo(var15) / var3;
         }
      }

      return var15;
   }

   private double I_method_5450b8ba() {
      if (this.i_field_5a) {
         return 0.9;
      } else {
         int var1 = this.I_field_db650847.size();
         if (var1 < 3) {
            return 0.9;
         } else {
            Vec3d[] var2 = this.I_field_db650847.toArray(new Vec3d[0]);
            double var3 = 0.0;

            for (int var5 = 1; var5 < var1; var5++) {
               double var6 = var2[var5].x - var2[var5 - 1].x;
               double var8 = var2[var5].z - var2[var5 - 1].z;
               var3 += Math.sqrt(var6 * var6 + var8 * var8);
            }

            double var11 = var2[var1 - 1].x - var2[0].x;
            double var7 = var2[var1 - 1].z - var2[0].z;
            double var9 = Math.sqrt(var11 * var11 + var7 * var7);
            return var3 < 0.05 ? 1.0 : MathHelper.clamp(var9 / var3, 0.2, 1.0);
         }
      }
   }

   private double I_method_df26a6b6(double var1, double var3, boolean var5) {
      if (!var5) {
         return var1 * var3;
      } else {
         int var6 = (int)Math.floor(var3);
         double var7 = var3 - var6;
         double var9 = var1;
         double var11 = 0.0;

         for (int var13 = 0; var13 < var6; var13++) {
            var9 -= 0.08F;
            var11 += var9;
            var9 *= 0.98F;
         }

         if (var7 > 0.001) {
            double var16 = var9 - 0.08F;
            var11 += var16 * var7;
         }

         return var11;
      }
   }

   private Vec3d I_method_541b81c7(LivingEntity var1, Vec3d var2, Vec3d var3, double var4) {
      double var6 = Math.sqrt(var3.x * var3.x + var3.z * var3.z) * var4;
      if (var6 < 0.05) {
         return new Vec3d(var3.x * var4, 0.0, var3.z * var4);
      } else {
         Vec3d var8 = var2.add(0.0, var1.getHeight() * 0.5, 0.0);
         Vec3d var9 = var8.add(var3.x * var4, 0.0, var3.z * var4);
         BlockHitResult var10 = I_field_3a9bda27.world.raycast(new RaycastContext(var8, var9, ShapeType.COLLIDER, FluidHandling.NONE, var1));
         if (var10.getType() == Type.BLOCK) {
            double var11 = var10.getPos().distanceTo(var8) - 0.3;
            if (var11 <= 0.0) {
               return Vec3d.ZERO;
            } else {
               double var13 = var11 / var6;
               return new Vec3d(var3.x * var4 * var13, 0.0, var3.z * var4 * var13);
            }
         } else {
            return new Vec3d(var3.x * var4, 0.0, var3.z * var4);
         }
      }
   }

   private Vec3d I_method_4ec9780b(LivingEntity var1) {
      if (this.ii_field_49 != var1.getId()) {
         this.I_field_db650847.clear();
         this.i_field_5a = false;
         this.ii_field_49 = var1.getId();
      }

      this.I_field_db650847.addLast(var1.getPos());

      while (this.I_field_db650847.size() > 6) {
         this.I_field_db650847.removeFirst();
      }

      if (this.I_field_db650847.size() < 2) {
         this.i_field_5a = false;
         return new Vec3d(var1.getX() - var1.prevX, var1.getY() - var1.prevY, var1.getZ() - var1.prevZ);
      } else {
         Vec3d[] var2 = this.I_field_db650847.toArray(new Vec3d[0]);
         int var3 = var2.length;
         Vec3d var4 = this.I_method_299d84db(var2);
         Vec3d var5 = var2[var3 - 1].subtract(var2[var3 - 2]);
         double var6 = var5.x * var5.x + var5.z * var5.z;
         double var8 = var4.x * var4.x + var4.z * var4.z;
         if (var6 > 0.005 && var8 > 0.0025) {
            double var10 = (var5.x * var4.x + var5.z * var4.z) / (Math.sqrt(var6) * Math.sqrt(var8));
            if (var10 < 0.3) {
               this.i_field_5a = true;
               return var5;
            }
         }

         this.i_field_5a = false;
         return var4;
      }
   }

   private Vec3d I_method_299d84db(Vec3d[] var1) {
      int var2 = var1.length;
      double var3 = 0.0;
      double var5 = 0.0;
      double var7 = 0.0;
      double var9 = 0.0;

      for (int var11 = 1; var11 < var2; var11++) {
         double var12 = var11;
         var3 += (var1[var11].x - var1[var11 - 1].x) * var12;
         var5 += (var1[var11].y - var1[var11 - 1].y) * var12;
         var7 += (var1[var11].z - var1[var11 - 1].z) * var12;
         var9 += var12;
      }

      if (var9 < 1.0E-6) {
         return Vec3d.ZERO;
      } else {
         double var14 = 1.0 / var9;
         return new Vec3d(var3 * var14, var5 * var14, var7 * var14);
      }
   }

   private double I_method_544cc720(Vec3d var1, Vec3d var2, double var3) {
      double var5 = var2.x - var1.x;
      double var7 = var2.z - var1.z;
      double var9 = var2.y - var1.y;
      double var11 = Math.sqrt(var5 * var5 + var7 * var7);
      if (var11 < 1.0E-4) {
         return Double.NaN;
      } else {
         double var13 = var3 * var3;
         double var15 = 0.05F;
         double var17 = var13 * var13 - var15 * (var15 * var11 * var11 + 2.0 * var9 * var13);
         if (var17 < 0.0) {
            return var11 / var3;
         } else {
            double var19 = (var13 - Math.sqrt(var17)) / (var15 * var11);
            double var21 = 1.0 / Math.sqrt(1.0 + var19 * var19);
            double var23 = var3 * var21;
            if (var23 < 1.0E-4) {
               return var11 / var3;
            } else {
               double var25 = 0.00999999F;
               double var27 = var11 * var25 / var23;
               return var27 >= 0.999 ? var11 / var23 * 1.5 : Math.log(1.0 - var27) / Math.log(0.99F);
            }
         }
      }
   }

   private iiIIiIIii_Class404 I_method_c76cb34a(Vec3d var1, Vec3d var2, float var3) {
      double var4 = var2.x - var1.x;
      double var6 = var2.z - var1.z;
      double var8 = var2.y - var1.y;
      double var10 = Math.sqrt(var4 * var4 + var6 * var6);
      if (var10 < 1.0E-4) {
         return null;
      } else {
         double var12 = var3 * var3;
         double var14 = 0.05F;
         double var16 = var12 * var12 - var14 * (var14 * var10 * var10 + 2.0 * var8 * var12);
         if (var16 < 0.0) {
            return null;
         } else {
            double var18 = (var12 - Math.sqrt(var16)) / (var14 * var10);
            float var20 = (float)(Math.toDegrees(Math.atan2(var6, var4)) - 90.0);
            float var21 = (float)(-Math.toDegrees(Math.atan(var18)));
            var21 = MathHelper.clamp(var21, -89.9F, 89.9F);
            return new iiIIiIIii_Class404(var20, var21);
         }
      }
   }

   private boolean I_method_18404be9(Vec3d var1, iiIIiIIii_Class404 var2, float var3, LivingEntity var4, Vec3d var5) {
      double var6 = Math.toRadians(var2.I_method_14534e0f());
      double var8 = Math.toRadians(var2.i_method_1461d9ef());
      double var10 = Math.cos(var8);
      Vec3d var12 = new Vec3d(-Math.sin(var6) * var10, -Math.sin(var8), Math.cos(var6) * var10).multiply(var3);
      Vec3d var13 = var1;
      Box var14 = var4.getBoundingBox().offset(var5.x, var5.y, var5.z).expand(0.1);
      int var15 = MathHelper.clamp((int)(var1.distanceTo(var14.getCenter()) / var3 * 3.0) + 10, 20, 80);
      double var16 = var14.minY - 5.0;

      for (int var18 = 0; var18 < var15; var18++) {
         Vec3d var19 = var13.add(var12);
         if (var19.y < var16 && var12.y < 0.0) {
            return false;
         }

         Optional var20 = var14.raycast(var13, var19);
         BlockHitResult var21 = I_field_3a9bda27.world
            .raycast(new RaycastContext(var13, var19, ShapeType.COLLIDER, FluidHandling.NONE, I_field_3a9bda27.player));
         if (var20.isPresent()) {
            if (var21.getType() == Type.BLOCK) {
               double var22 = var21.getPos().squaredDistanceTo(var13);
               double var24 = ((Vec3d)var20.get()).squaredDistanceTo(var13);
               if (var22 < var24) {
                  return false;
               }
            }

            return true;
         }

         if (var21.getType() == Type.BLOCK) {
            return false;
         }

         var13 = var19;
         var12 = var12.multiply(0.99F);
         var12 = new Vec3d(var12.x, var12.y - 0.05F, var12.z);
      }

      return false;
   }

   private List<Vec3d> I_method_defce0e(LivingEntity var1, Vec3d var2) {
      Box var3 = var1.getBoundingBox().offset(var2.x, var2.y, var2.z);
      Vec3d var4 = var3.getCenter();
      double var5 = var1.getY() + var2.y;
      double var7 = var1.getHeight();
      ArrayList var9 = new ArrayList(8);
      var9.add(new Vec3d(var4.x, var5 + var7 * 0.85, var4.z));
      var9.add(new Vec3d(var4.x, var5 + var7 * 0.65, var4.z));
      var9.add(new Vec3d(var4.x, var5 + var7 * 0.5, var4.z));
      var9.add(new Vec3d(var4.x, var5 + var7 * 0.3, var4.z));
      var9.add(new Vec3d(var3.minX + 0.1, var5 + var7 * 0.55, var4.z));
      var9.add(new Vec3d(var3.maxX - 0.1, var5 + var7 * 0.55, var4.z));
      var9.add(new Vec3d(var4.x, var5 + var7 * 0.55, var3.minZ + 0.1));
      var9.add(new Vec3d(var4.x, var5 + var7 * 0.55, var3.maxZ - 0.1));
      return var9;
   }

   private float I_method_19156dca(iiIIiIIii_Class404 var1) {
      double var2 = Math.toRadians(var1.I_method_14534e0f());
      double var4 = Math.toRadians(var1.i_method_1461d9ef());
      double var6 = Math.cos(var4);
      Vec3d var8 = new Vec3d(-Math.sin(var2) * var6, -Math.sin(var4), Math.cos(var2) * var6);
      Vec3d var9 = I_field_3a9bda27.player.getRotationVec(1.0F).normalize();
      double var10 = MathHelper.clamp(var9.dotProduct(var8), -1.0, 1.0);
      return (float)Math.toDegrees(Math.acos(var10));
   }

   private float I_method_5450b8bc() {
      Item var1 = I_field_3a9bda27.player.getMainHandStack().getItem();
      if (var1 == Items.BOW) {
         return 3.0F;
      } else if (var1 == Items.CROSSBOW) {
         return 3.15F;
      } else {
         return var1 == Items.TRIDENT ? 2.5F : 3.0F;
      }
   }

   private void I_method_19156dda(iiIIiIIii_Class404 var1) {
      float var2 = MathHelper.clamp(var1.i_method_1461d9ef(), -89.9F, 89.9F);
      if (this.II_field_ba20ca4c.i_method_9b12da03()) {
         float var3 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858().I_method_14534e0f();
         float var4 = var3 + MathHelper.wrapDegrees(var1.I_method_14534e0f() - var3);
         RockstarClient.getInstance()
            .I_method_58785402()
            .I_method_1acbf705(
               new iiIIiIIii_Class404(var4, var2), iiIIiIIIi_Class402.i_field_32e0c64c, 120.0F, 120.0F, 120.0F, iiIIiIiiI_Class407.II_field_32efc66c
            );
         this.i_field_32e13e6c = null;
      } else {
         this.i_field_32e13e6c = new iiIIiIIii_Class404(var1.I_method_14534e0f(), var2);
      }
   }

   private boolean IiI_method_86a79210() {
      ItemStack var1 = I_field_3a9bda27.player.getMainHandStack();
      Item var2 = var1.getItem();
      if (var2 == Items.BOW && this.I_field_51de8227.isSelected()) {
         return I_field_3a9bda27.player.isUsingItem();
      } else if (var2 == Items.CROSSBOW && this.i_field_51de8227.isSelected()) {
         return I_field_3a9bda27.player.isUsingItem() || CrossbowItem.isCharged(var1);
      } else {
         return var2 == Items.TRIDENT && this.II_field_51de8227.isSelected() ? I_field_3a9bda27.player.isUsingItem() : false;
      }
   }

   static final class Nested1_30a1b8d3 {
      final iiIIiIIii_Class404 I_field_32e13e6c;
      private final Box I_field_bdfefbea;
      private final boolean I_field_5a;
      private final int I_field_49;

      Nested1_30a1b8d3(iiIIiIIii_Class404 var1, Box var2, boolean var3, int var4) {
         this.I_field_32e13e6c = var1;
         this.I_field_bdfefbea = var2;
         this.I_field_5a = var3;
         this.I_field_49 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_30a1b8d3[rotation=" + this.I_field_32e13e6c + ", box=" + this.I_field_bdfefbea + ", hits=" + this.I_field_5a + ", targetId=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_32e13e6c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_bdfefbea);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         AimBotModule.Nested1_30a1b8d3 other = (AimBotModule.Nested1_30a1b8d3) var1;
         return java.util.Objects.equals(this.I_field_32e13e6c, other.I_field_32e13e6c)
            && java.util.Objects.equals(this.I_field_bdfefbea, other.I_field_bdfefbea)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public iiIIiIIii_Class404 I_method_14d3f99d() {
         return this.I_field_32e13e6c;
      }

      public Box I_method_ee2faedb() {
         return this.I_field_bdfefbea;
      }

      public boolean I_method_7269d6cb() {
         return this.I_field_5a;
      }

      public int I_method_7269d6ba() {
         return this.I_field_49;
      }
   }

   static final class Nested1_30a1b8f3 {
      private final LivingEntity I_field_966247a3;
      private final double I_field_44;

      Nested1_30a1b8f3(LivingEntity var1, double var2) {
         this.I_field_966247a3 = var1;
         this.I_field_44 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_30a1b8f3[entity=" + this.I_field_966247a3 + ", score=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_966247a3);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         AimBotModule.Nested1_30a1b8f3 other = (AimBotModule.Nested1_30a1b8f3) var1;
         return java.util.Objects.equals(this.I_field_966247a3, other.I_field_966247a3)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public LivingEntity I_method_a8415db4() {
         return this.I_field_966247a3;
      }

      public double I_method_a904ea95() {
         return this.I_field_44;
      }
   }
}
