package rockstar.client;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.SchematicRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.MatrixStack.Entry;
import net.minecraft.command.argument.BlockArgumentParser;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtSizeTracker;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.EmptyBlockView;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

public final class iIiiiIIii_Class372 implements iIIiIIiIi_Class294 {
   private static final Map<String, iIiiiIIii_Class372> I_field_a567c40b = new HashMap<>();
   private static final Direction[] I_field_8d7cb6fb = Direction.values();
   private static final float I_field_46 = 0.35F;
   private static final iIiiiIIii_Class372 I_field_4340624c = new iIiiiIIii_Class372(new iIiiiIIii_Class372.Nested1_a6bdb480[0], Set.of(), Vec3i.ZERO);
   private final iIiiiIIii_Class372.Nested1_a6bdb480[] I_field_b211b38c;
   private final Set<Integer> I_field_a56a8dc5;
   private final Vec3i I_field_5bba0deb;

   private iIiiiIIii_Class372(iIiiiIIii_Class372.Nested1_a6bdb480[] var1, Set<Integer> var2, Vec3i var3) {
      this.I_field_b211b38c = var1;
      this.I_field_a56a8dc5 = var2;
      this.I_field_5bba0deb = var3;
   }

   public static iIiiiIIii_Class372 I_method_9591a23f(String var0) {
      return I_field_a567c40b.computeIfAbsent(var0, iIiiiIIii_Class372::i_method_cee5de1f);
   }

   private static iIiiiIIii_Class372 i_method_cee5de1f(String var0) {
      try {
         iIiiiIIii_Class372 var28;
         try (InputStream var1 = iIiiiIIii_Class372.class.getResourceAsStream("/assets/rockstar/schematics/" + var0 + ".schem")) {
            if (var1 == null) {
               return I_field_4340624c;
            }

            NbtCompound var2 = NbtIo.readCompressed(var1, NbtSizeTracker.ofUnlimitedBytes()).getCompound("Schematic");
            int var3 = var2.getShort("Width") & '\uffff';
            int var4 = var2.getShort("Length") & '\uffff';
            int[] var5 = var2.getIntArray("Offset");
            NbtCompound var6 = var2.getCompound("Blocks");
            NbtCompound var7 = var6.getCompound("Palette");
            BlockState[] var8 = new BlockState[var7.getKeys().size()];

            for (String var10 : var7.getKeys()) {
               var8[var7.getInt(var10)] = BlockArgumentParser.block(Registries.BLOCK, var10, false).blockState();
            }

            byte[] var25 = var6.getByteArray("Data");
            ArrayList<iIiiiIIii_Class372.Nested1_a6bdb480> var26 = new ArrayList<>();
            HashSet var11 = new HashSet();
            int var12 = 0;

            for (int var13 = 0; var13 < var25.length; var12++) {
               int var14 = 0;
               byte var15 = 0;

               byte var16;
               do {
                  var16 = var25[var13++];
                  var14 |= (var16 & 127) << var15;
                  var15 += 7;
               } while ((var16 & 128) != 0);

               BlockState var17 = var14 < var8.length ? var8[var14] : null;
               if (var17 != null && !var17.isAir()) {
                  int var18 = var12 % var3;
                  int var19 = var12 / (var3 * var4);
                  int var20 = var12 / var3 % var4;
                  var26.add(new iIiiiIIii_Class372.Nested1_a6bdb480(var18, var19, var20, var17));
                  if (Block.isShapeFullCube(var17.getCollisionShape(EmptyBlockView.INSTANCE, BlockPos.ORIGIN))) {
                     var11.add(I_method_90f8e837(var18, var19, var20));
                  }
               }
            }

            iIiiiIIii_Class372.Nested1_a6bdb480[] var27 = var26.toArray(new iIiiiIIii_Class372.Nested1_a6bdb480[0]);
            var28 = var5.length == 3
               ? new iIiiiIIii_Class372(var27, var11, new Vec3i(var5[0], var5[1], var5[2]))
               : new iIiiiIIii_Class372(var27, var11, Vec3i.ZERO);
         }

         return var28;
      } catch (Exception var23) {
         return I_field_4340624c;
      }
   }

   public void I_method_e1fc8da(Render3DEvent var1, BlockPos var2, ColorRGBA var3, float var4) {
      if (this.I_field_b211b38c.length != 0 && I_field_3a9bda27.world != null) {
         Vec3d var5 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
         int var6 = var2.getX() + this.I_field_5bba0deb.getX();
         int var7 = var2.getY() + this.I_field_5bba0deb.getY();
         int var8 = var2.getZ() + this.I_field_5bba0deb.getZ();
         double var9 = var6 - var5.x;
         double var11 = var7 - var5.y;
         double var13 = var8 - var5.z;
         Arrays.sort(this.I_field_b211b38c, Comparator.comparingDouble(var6x -> {
            double var7x = var9 + var6x.I_method_cc91f2d() + 0.5;
            double var9x = var11 + var6x.i_method_cd7ab0d() + 0.5;
            double var11x = var13 + var6x.II_method_8c69bf5a() + 0.5;
            return var7x * var7x + var9x * var9x + var11x * var11x;
         }));
         Immediate var15 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
         RenderLayer var16 = SchematicRenderLayers.hidden();
         this.I_method_c4dbd564(var1, new iIiiiIIii_Class372.Nested1_a6bdb4a0(var15.getBuffer(var16), var3, 0.35F), true, var6, var7, var8, var9, var11, var13);
         var15.draw(var16);
         RenderLayer var17 = SchematicRenderLayers.visible();
         this.I_method_c4dbd564(var1, new iIiiiIIii_Class372.Nested1_a6bdb4a0(var15.getBuffer(var17), var3, var4), false, var6, var7, var8, var9, var11, var13);
         var15.draw(var17);
      }
   }

   private void I_method_c4dbd564(Render3DEvent var1, VertexConsumer var2, boolean var3, int var4, int var5, int var6, double var7, double var9, double var11) {
      MatrixStack var13 = var1.getMatrices();
      Mutable var14 = new Mutable();
      Random var15 = Random.create();

      for (iIiiiIIii_Class372.Nested1_a6bdb480 var19 : this.I_field_b211b38c) {
         var14.set(var4 + var19.I_method_cc91f2d(), var5 + var19.i_method_cd7ab0d(), var6 + var19.II_method_8c69bf5a());
         var13.push();
         var13.translate(var7 + var19.I_method_cc91f2d(), var9 + var19.i_method_cd7ab0d(), var11 + var19.II_method_8c69bf5a());
         this.I_method_aed086c0(
            var19,
            var13.peek(),
            var2,
            var14,
            var15,
            var3,
            var7 + var19.I_method_cc91f2d() + 0.5,
            var9 + var19.i_method_cd7ab0d() + 0.5,
            var11 + var19.II_method_8c69bf5a() + 0.5
         );
         var13.pop();
      }
   }

   private void I_method_aed086c0(
      iIiiiIIii_Class372.Nested1_a6bdb480 var1,
      Entry var2,
      VertexConsumer var3,
      Mutable var4,
      Random var5,
      boolean var6,
      double var7,
      double var9,
      double var11
   ) {
      BlockState var13 = var1.I_method_89c06b91();
      if (var13.getRenderType() == BlockRenderType.MODEL) {
         BakedModel var14 = I_field_3a9bda27.getBlockRenderManager().getModel(var13);
         int var15 = I_field_3a9bda27.getBlockColors().getColor(var13, I_field_3a9bda27.world, var4, 0);
         float var16 = (var15 >> 16 & 0xFF) / 255.0F;
         float var17 = (var15 >> 8 & 0xFF) / 255.0F;
         float var18 = (var15 & 0xFF) / 255.0F;

         for (Direction var22 : I_field_8d7cb6fb) {
            if (!this.I_method_d569494(var1, var22, var4, var6, var7, var9, var11)) {
               var5.setSeed(42L);
               this.I_method_9eec46a(var2, var3, var14.getQuads(var13, var22, var5), var16, var17, var18, false, var7, var9, var11);
            }
         }

         var5.setSeed(42L);
         this.I_method_9eec46a(var2, var3, var14.getQuads(var13, null, var5), var16, var17, var18, true, var7, var9, var11);
      }
   }

   private boolean I_method_d569494(iIiiiIIii_Class372.Nested1_a6bdb480 var1, Direction var2, Mutable var3, boolean var4, double var5, double var7, double var9) {
      Vec3i var11 = var2.getVector();
      if (var11.getX() * (var5 + var11.getX() * 0.5) + var11.getY() * (var7 + var11.getY() * 0.5) + var11.getZ() * (var9 + var11.getZ() * 0.5) >= 0.0) {
         return true;
      } else if (this.I_field_a56a8dc5
         .contains(I_method_90f8e837(var1.I_method_cc91f2d() + var11.getX(), var1.i_method_cd7ab0d() + var11.getY(), var1.II_method_8c69bf5a() + var11.getZ()))
         )
       {
         return true;
      } else if (var4) {
         return false;
      } else {
         var3.move(var2);
         boolean var12 = I_field_3a9bda27.world.getBlockState(var3).isOpaqueFullCube();
         var3.move(var2.getOpposite());
         return var12;
      }
   }

   private void I_method_9eec46a(
      Entry var1, VertexConsumer var2, List<BakedQuad> var3, float var4, float var5, float var6, boolean var7, double var8, double var10, double var12
   ) {
      for (BakedQuad var15 : var3) {
         if (!var7 || !this.I_method_8c9d2763(var15, var8, var10, var12)) {
            boolean var16 = var15.hasTint();
            var2.quad(var1, var15, var16 ? var4 : 1.0F, var16 ? var5 : 1.0F, var16 ? var6 : 1.0F, 1.0F, 15728880, OverlayTexture.DEFAULT_UV);
         }
      }
   }

   private boolean I_method_8c9d2763(BakedQuad var1, double var2, double var4, double var6) {
      int[] var8 = var1.getVertexData();
      int var9 = var8.length / 4;
      float var10 = Float.intBitsToFloat(var8[0]);
      float var11 = Float.intBitsToFloat(var8[1]);
      float var12 = Float.intBitsToFloat(var8[2]);
      float var13 = Float.intBitsToFloat(var8[var9]);
      float var14 = Float.intBitsToFloat(var8[var9 + 1]);
      float var15 = Float.intBitsToFloat(var8[var9 + 2]);
      float var16 = Float.intBitsToFloat(var8[var9 * 2]);
      float var17 = Float.intBitsToFloat(var8[var9 * 2 + 1]);
      float var18 = Float.intBitsToFloat(var8[var9 * 2 + 2]);
      float var19 = Float.intBitsToFloat(var8[var9 * 3]);
      float var20 = Float.intBitsToFloat(var8[var9 * 3 + 1]);
      float var21 = Float.intBitsToFloat(var8[var9 * 3 + 2]);
      float var22 = var13 - var10;
      float var23 = var14 - var11;
      float var24 = var15 - var12;
      float var25 = var16 - var10;
      float var26 = var17 - var11;
      float var27 = var18 - var12;
      double var28 = var23 * var27 - var24 * var26;
      double var30 = var24 * var25 - var22 * var27;
      double var32 = var22 * var26 - var23 * var25;
      return var28 == 0.0 && var30 == 0.0 && var32 == 0.0
         ? false
         : var28 * (var2 - 0.5 + (var10 + var13 + var16 + var19) / 4.0)
               + var30 * (var4 - 0.5 + (var11 + var14 + var17 + var20) / 4.0)
               + var32 * (var6 - 0.5 + (var12 + var15 + var18 + var21) / 4.0)
            >= 0.0;
   }

   private static int I_method_90f8e837(int var0, int var1, int var2) {
      return ((var0 + 1) * 512 + var1 + 1) * 512 + var2 + 1;
   }

   static final class Nested1_a6bdb480 {
      private final int I_field_49;
      private final int i_field_49;
      private final int II_field_49;
      private final BlockState I_field_fd3466f5;

      Nested1_a6bdb480(int var1, int var2, int var3, BlockState var4) {
         this.I_field_49 = var1;
         this.i_field_49 = var2;
         this.II_field_49 = var3;
         this.I_field_fd3466f5 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_a6bdb480[x=" + this.I_field_49 + ", y=" + this.i_field_49 + ", z=" + this.II_field_49 + ", state=" + this.I_field_fd3466f5 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_fd3466f5);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiIIii_Class372.Nested1_a6bdb480 other = (iIiiiIIii_Class372.Nested1_a6bdb480) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.II_field_49, other.II_field_49)
            && java.util.Objects.equals(this.I_field_fd3466f5, other.I_field_fd3466f5);
      }

      public int I_method_cc91f2d() {
         return this.I_field_49;
      }

      public int i_method_cd7ab0d() {
         return this.i_field_49;
      }

      public int II_method_8c69bf5a() {
         return this.II_field_49;
      }

      public BlockState I_method_89c06b91() {
         return this.I_field_fd3466f5;
      }
   }

   static final class Nested1_a6bdb4a0 implements VertexConsumer {
      private final VertexConsumer I_field_5707ecc;
      private final ColorRGBA I_field_d0c8ec5;
      private final float I_field_46;

      Nested1_a6bdb4a0(VertexConsumer var1, ColorRGBA var2, float var3) {
         this.I_field_5707ecc = var1;
         this.I_field_d0c8ec5 = var2;
         this.I_field_46 = var3;
      }

      public VertexConsumer vertex(float x, float y, float z) {
         this.I_field_5707ecc.vertex(x, y, z);
         return this;
      }

      public VertexConsumer color(int red, int green, int blue, int alpha) {
         this.I_field_5707ecc
            .color(
               (int)(red * this.I_field_d0c8ec5.getRed() / 255.0F),
               (int)(green * this.I_field_d0c8ec5.getGreen() / 255.0F),
               (int)(blue * this.I_field_d0c8ec5.getBlue() / 255.0F),
               (int)(alpha * this.I_field_46)
            );
         return this;
      }

      public VertexConsumer texture(float u, float v) {
         this.I_field_5707ecc.texture(u, v);
         return this;
      }

      public VertexConsumer overlay(int u, int v) {
         this.I_field_5707ecc.overlay(u, v);
         return this;
      }

      public VertexConsumer light(int u, int v) {
         this.I_field_5707ecc.light(u, v);
         return this;
      }

      public VertexConsumer normal(float x, float y, float z) {
         this.I_field_5707ecc.normal(x, y, z);
         return this;
      }

      @Override
      public final String toString() {
         return "Nested1_a6bdb4a0[delegate=" + this.I_field_5707ecc + ", tint=" + this.I_field_d0c8ec5 + ", alpha=" + this.I_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5707ecc);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d0c8ec5);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIiiiIIii_Class372.Nested1_a6bdb4a0 other = (iIiiiIIii_Class372.Nested1_a6bdb4a0) var1;
         return java.util.Objects.equals(this.I_field_5707ecc, other.I_field_5707ecc)
            && java.util.Objects.equals(this.I_field_d0c8ec5, other.I_field_d0c8ec5)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46);
      }

      public VertexConsumer I_method_7521b988() {
         return this.I_field_5707ecc;
      }

      public ColorRGBA I_method_3c54b189() {
         return this.I_field_d0c8ec5;
      }

      public float I_method_4364330a() {
         return this.I_field_46;
      }
   }
}
