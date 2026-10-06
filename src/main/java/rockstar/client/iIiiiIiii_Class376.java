package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Generated;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

public class iIiiiIiii_Class376 implements iIIiIIiIi_Class294 {
   public static iIiiiIiii_Class376 I_field_434eee2c = new iIiiiIiii_Class376();
   private final List<iIiiiIiii_Class376.Nested1_a880a4c0> I_field_7865b31 = new CopyOnWriteArrayList<>();
   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null && !this.I_field_7865b31.isEmpty()) {
         MatrixStack var2 = var1.getMatrices();
         Vec3d var3 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
         var2.push();
         var2.translate(-var3.x, -var3.y, -var3.z);
         RenderSystem.enableBlend();
         RenderSystem.enableDepthTest();
         RenderSystem.depthFunc(515);
         RenderSystem.depthMask(false);
         RenderSystem.disableCull();
         RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder var4 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

         for (iIiiiIiii_Class376.Nested1_a880a4c0 var6 : this.I_field_7865b31) {
            float var7 = var6.I_method_cc9256ea();
            float var8 = var6.i_method_cca0e2ca();
            float var9 = var6.i_field_46;
            float var10 = var7 - var9;
            float var11 = var7 + var9;
            ColorRGBA var12 = var6.I_field_d0c8ec5;

            for (iIiiiIiii_Class376.Nested1_a880a4a0 var14 : var6.I_field_7865b31) {
               if (var14.I_field_44 >= var10 && var14.I_field_44 <= var11) {
                  float var15 = (float)Math.pow(Math.max(0.0F, Math.min(1.0F, 1.0F - Math.abs((float)(var14.I_field_44 - var7)) / var9)), 0.5);
                  float var16 = var8 * var15 * 0.15F;
                  if (var16 > 0.005F) {
                     iIiiIIiIi_Class358.i_method_5e35f7b9(var2, var4, var14.I_field_bdfefbea, var12.withAlpha(var16 * 255.0F));
                  }
               }
            }
         }

         BuiltBuffer var19 = var4.endNullable();
         if (var19 != null) {
            BufferRenderer.drawWithGlobalProgram(var19);
         }

         BufferBuilder var20 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

         for (iIiiiIiii_Class376.Nested1_a880a4c0 var23 : this.I_field_7865b31) {
            float var24 = var23.I_method_cc9256ea();
            float var25 = var23.i_method_cca0e2ca();
            float var26 = var23.i_field_46;
            float var27 = var24 - var26;
            float var28 = var24 + var26;
            ColorRGBA var29 = var23.I_field_d0c8ec5;

            for (iIiiiIiii_Class376.Nested1_a880a4a0 var31 : var23.I_field_7865b31) {
               if (var31.I_field_44 >= var27 && var31.I_field_44 <= var28) {
                  float var17 = (float)Math.pow(Math.max(0.0F, Math.min(1.0F, 1.0F - Math.abs((float)(var31.I_field_44 - var24)) / var26)), 0.5);
                  float var18 = var25 * var17 * 0.5F;
                  if (var18 > 0.005F) {
                     iIiiIIiIi_Class358.Ii_method_c1caf816(var2, var20, var31.I_field_bdfefbea, var29.withAlpha(var18 * 255.0F));
                  }
               }
            }
         }

         BuiltBuffer var22 = var20.endNullable();
         if (var22 != null) {
            BufferRenderer.drawWithGlobalProgram(var22);
         }

         RenderSystem.defaultBlendFunc();
         RenderSystem.depthMask(true);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
         var2.pop();
         this.I_field_7865b31.removeIf(iIiiiIiii_Class376.Nested1_a880a4c0::I_method_cc9256fe);
      }
   };
   private final IiIIIiII_Class69<WorldChangeEvent> i_field_3d936f41 = var1 -> this.I_field_7865b31.clear();

   private iIiiiIiii_Class376() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public void I_method_f7bf8415(Vec3d var1, float var2, float var3, float var4) {
      this.I_method_9b9d710a(var1, var2, var3, var4, IiiiiIIIi_Class242.i_method_5dfec6e());
   }

   public void I_method_9b9d710a(Vec3d var1, float var2, float var3, float var4, ColorRGBA var5) {
      if (I_field_3a9bda27.world != null) {
         BlockPos var6 = BlockPos.ofFloored(var1);
         int var7 = (int)Math.ceil(var2);
         HashSet var8 = new HashSet(var7 * var7 * var7 / 2);

         for (int var9 = -var7; var9 <= var7; var9++) {
            for (int var10 = -var7; var10 <= var7; var10++) {
               for (int var11 = -var7; var11 <= var7; var11++) {
                  BlockPos var12 = var6.add(var9, var10, var11);
                  if (I_field_3a9bda27.world.getBlockState(var12).getBlock() != Blocks.AIR
                     && !(I_field_3a9bda27.world.getBlockState(var12).getBlock() instanceof FlowerBlock)
                     && I_field_3a9bda27.world.getBlockState(var12).getBlock() != Blocks.SHORT_GRASS
                     && I_field_3a9bda27.world.getBlockState(var12).getBlock() != Blocks.TALL_GRASS) {
                     var8.add(var12);
                  }
               }
            }
         }

         ArrayList var17 = new ArrayList(var8.size() / 3);

         for (BlockPos var20 : (Iterable<BlockPos>)(Iterable<?>)var8) {
            boolean var22 = false;

            for (Direction var16 : Direction.values()) {
               if (!var8.contains(var20.offset(var16))) {
                  var22 = true;
                  break;
               }
            }

            if (var22) {
               double var24 = var1.distanceTo(var20.toCenterPos());
               var17.add(new iIiiiIiii_Class376.Nested1_a880a4a0(new Box(var20).expand(0.002), var24));
            }
         }

         if (var17.isEmpty()) {
            for (BlockPos var21 : (Iterable<BlockPos>)(Iterable<?>)var8) {
               double var23 = var1.distanceTo(var21.toCenterPos());
               var17.add(new iIiiiIiii_Class376.Nested1_a880a4a0(new Box(var21).expand(0.002), var23));
            }
         }

         this.I_field_7865b31.add(new iIiiiIiii_Class376.Nested1_a880a4c0(var17, (long)(var3 * 1000.0F), var2, var4, var5));
      }
   }

   @Generated
   public List<iIiiiIiii_Class376.Nested1_a880a4c0> I_method_ef755a88() {
      return this.I_field_7865b31;
   }

   @Generated
   public IiIIIiII_Class69<Render3DEvent> I_method_fbc86dd8() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<WorldChangeEvent> i_method_25c4fdf8() {
      return this.i_field_3d936f41;
   }

   static final class Nested1_a880a4a0 {
      final Box I_field_bdfefbea;
      final double I_field_44;

      Nested1_a880a4a0(Box var1, double var2) {
         this.I_field_bdfefbea = var1;
         this.I_field_44 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_a880a4a0[box=" + this.I_field_bdfefbea + ", distance=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_bdfefbea);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiIiii_Class376.Nested1_a880a4a0 other = (iIiiiIiii_Class376.Nested1_a880a4a0) var1;
         return java.util.Objects.equals(this.I_field_bdfefbea, other.I_field_bdfefbea)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public Box I_method_858a30ae() {
         return this.I_field_bdfefbea;
      }

      public double I_method_95f74308() {
         return this.I_field_44;
      }
   }

   static class Nested1_a880a4c0 {
      final List<iIiiiIiii_Class376.Nested1_a880a4a0> I_field_7865b31;
      private final long I_field_4a;
      private final float I_field_46;
      final float i_field_46;
      final ColorRGBA I_field_d0c8ec5;
      private final iiIiIIiii_Class424 I_field_991c1e8c;

      public Nested1_a880a4c0(List<iIiiiIiii_Class376.Nested1_a880a4a0> var1, long var2, float var4, float var5, ColorRGBA var6) {
         this.I_field_7865b31 = var1;
         this.I_field_4a = var2;
         this.I_field_46 = var4;
         this.i_field_46 = var5;
         this.I_field_d0c8ec5 = var6;
         this.I_field_991c1e8c = new iiIiIIiii_Class424();
      }

      public boolean I_method_cc9256fe() {
         return this.I_field_991c1e8c.I_method_23e11e33() >= this.I_field_4a;
      }

      public float I_method_cc9256ea() {
         float var1 = Math.min(1.0F, (float)this.I_field_991c1e8c.I_method_23e11e33() / (float)this.I_field_4a);
         return var1 * this.I_field_46;
      }

      public float i_method_cca0e2ca() {
         float var1 = Math.min(1.0F, (float)this.I_field_991c1e8c.I_method_23e11e33() / (float)this.I_field_4a);
         return (float)Math.pow(1.0F - var1, 2.5);
      }
   }
}
