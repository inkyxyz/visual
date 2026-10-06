package rockstar.client;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.List;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.BlockGhostLayers;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.SchematicRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.LightType;
import net.minecraft.world.biome.ColorResolver;
import net.minecraft.world.chunk.light.LightingProvider;
import org.jetbrains.annotations.Nullable;
import pyrock.events.render.Render3DEvent;

public final class iIiiIIIIi_Class354 implements iIIiIIiIi_Class294 {
   private static final float I_field_46 = 0.25F;
   private static final double I_field_44 = 1.5;
   private static final double i_field_44 = 1.0;
   private static final double II_field_44 = 2.4;
   private static final double Ii_field_44 = 0.6;
   private static final double iI_field_44 = 0.3;
   private static final long I_field_4a = 220L;
   private static final int I_field_49 = 256;
   private static final int i_field_49 = 3;
   private static final Long2ObjectOpenHashMap<iIiiIIIIi_Class354.Nested1_9e7c080> I_field_89963af3 = new Long2ObjectOpenHashMap();
   private static volatile LongOpenHashSet I_field_fc1c1fe6 = new LongOpenHashSet();
   private static volatile int II_field_49 = 15728880;
   private static volatile int Ii_field_49 = 15;
   private static volatile int iI_field_49 = 15;
   private static final iIiiIIIIi_Class354.Nested1_33104fc9 I_field_623c9cc6 = new iIiiIIIIi_Class354.Nested1_33104fc9();
   private static final iIiiIIIIi_Class354.Nested1_9e7c0a0 I_field_76c829e7 = new iIiiIIIIi_Class354.Nested1_9e7c0a0();

   private iIiiIIIIi_Class354() {
   }

   public static boolean I_method_b0c7f603() {
      return !I_field_fc1c1fe6.isEmpty();
   }

   public static boolean I_method_3769f448(int var0, int var1, int var2) {
      LongOpenHashSet var3 = I_field_fc1c1fe6;
      return !var3.isEmpty() && var3.contains(BlockPos.asLong(var0, var1, var2));
   }

   public static boolean I_method_2b8f85bd(BlockPos var0) {
      return I_method_3769f448(var0.getX(), var0.getY(), var0.getZ());
   }

   public static int I_method_4661a45d(BlockPos var0, int var1) {
      return I_method_2b8f85bd(var0) ? Math.max(var1, II_field_49) : var1;
   }

   public static int I_method_c65af053(LightType var0, int var1) {
      return Math.max(var1, var0 == LightType.SKY ? iI_field_49 : Ii_field_49);
   }

   public static void I_method_b0c7f5ff() {
      I_field_89963af3.clear();
      if (!I_field_fc1c1fe6.isEmpty()) {
         I_method_d6124c41(new LongOpenHashSet());
      }
   }

   public static void I_method_9eafb553(float var0, boolean var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         boolean var2 = var1 && !I_field_3a9bda27.options.getPerspective().isFirstPerson();
         LongOpenHashSet var3 = var2 ? I_method_4026ccb1(var0) : new LongOpenHashSet();
         LongIterator var4 = var3.iterator();

         while (var4.hasNext()) {
            long var5 = (Long)var4.next();
            I_field_89963af3.computeIfAbsent(var5, var0x -> new iIiiIIIIi_Class354.Nested1_9e7c080());
         }

         LongOpenHashSet var9 = new LongOpenHashSet();
         ObjectIterator var10 = I_field_89963af3.long2ObjectEntrySet().fastIterator();

         while (var10.hasNext()) {
            Entry var6 = (Entry)var10.next();
            iIiiIIIIi_Class354.Nested1_9e7c080 var7 = (iIiiIIIIi_Class354.Nested1_9e7c080)var6.getValue();
            boolean var8 = var3.contains(var6.getLongKey());
            if (var7.I_field_5a) {
               if (!var8) {
                  if (--var7.I_field_49 <= 0) {
                     var10.remove();
                  }
                  continue;
               }

               var7.I_field_5a = false;
               var7.I_field_49 = 3;
            }

            if (var7.I_field_49 > 0) {
               var7.I_field_49--;
            } else if (var8) {
               var7.I_field_dc7facc.I_method_edd72835(true);
            } else if (var7.I_field_dc7facc.I_method_edd6dd11(0.0F) <= 0.001F) {
               var7.I_field_5a = true;
               var7.I_field_49 = 3;
               continue;
            }

            var9.add(var6.getLongKey());
         }

         if (!var9.equals(I_field_fc1c1fe6)) {
            I_method_d6124c41(var9);
         }
      } else {
         I_method_b0c7f5ff();
      }
   }

   private static LongOpenHashSet I_method_4026ccb1(float var0) {
      Vec3d var1 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
      Vec3d var2 = iIiiiiIII_Class377.I_method_689b1a13(I_field_3a9bda27.player, var0);
      Box var3 = I_field_3a9bda27.player.getBoundingBox().offset(var2.subtract(I_field_3a9bda27.player.getPos())).expand(0.05);
      BlockPos var4 = BlockPos.ofFloored(var2.add(0.0, I_field_3a9bda27.player.getStandingEyeHeight(), 0.0));
      BlockPos var5 = BlockPos.ofFloored(var1);
      Ii_field_49 = Math.max(I_field_3a9bda27.world.getLightLevel(LightType.BLOCK, var4), I_field_3a9bda27.world.getLightLevel(LightType.BLOCK, var5));
      iI_field_49 = Math.max(I_field_3a9bda27.world.getLightLevel(LightType.SKY, var4), I_field_3a9bda27.world.getLightLevel(LightType.SKY, var5));
      II_field_49 = LightmapTextureManager.pack(Ii_field_49, iI_field_49);
      List var6 = I_method_2f12c62(var3);
      if (var6.isEmpty()) {
         return new LongOpenHashSet();
      } else {
         LongOpenHashSet var7 = new LongOpenHashSet();
         Mutable var8 = new Mutable();
         int var9 = (int)Math.ceil(2.4) + 1;
         int var10 = (int)Math.floor(Math.min(var1.x, var3.minX)) - var9;
         int var11 = (int)Math.floor(Math.min(var1.y, var3.minY)) - var9;
         int var12 = (int)Math.floor(Math.min(var1.z, var3.minZ)) - var9;
         int var13 = (int)Math.floor(Math.max(var1.x, var3.maxX)) + var9;
         int var14 = (int)Math.floor(Math.max(var1.y, var3.maxY)) + var9;
         int var15 = (int)Math.floor(Math.max(var1.z, var3.maxZ)) + var9;
         boolean var16 = var1.y > var3.minY;

         for (int var17 = var10; var17 <= var13 && var7.size() < 256; var17++) {
            for (int var18 = var11; var18 <= var14 && var7.size() < 256; var18++) {
               if (!var16 || !(var18 + 1 <= var3.minY + 0.02)) {
                  for (int var19 = var12; var19 <= var15 && var7.size() < 256; var19++) {
                     if (I_method_3f4231bb(var17, var18, var19, var1, var6)) {
                        var8.set(var17, var18, var19);
                        if (I_method_16bf2bb8(I_field_3a9bda27.world.getBlockState(var8))) {
                           var7.add(var8.asLong());
                        }
                     }
                  }
               }
            }
         }

         return var7;
      }
   }

   private static boolean I_method_16bf2bb8(BlockState var0) {
      return var0.getRenderType() == BlockRenderType.MODEL;
   }

   private static List<Vec3d> I_method_2f12c62(Box var0) {
      Vec3d var1 = var0.getCenter();
      return List.of(new Vec3d(var1.x, var0.minY + 0.3, var1.z), var1, new Vec3d(var1.x, var0.maxY, var1.z));
   }

   private static boolean I_method_3f4231bb(int var0, int var1, int var2, Vec3d var3, List<Vec3d> var4) {
      double var5 = var0 + 0.5;
      double var7 = var1 + 0.5;
      double var9 = var2 + 0.5;

      for (Vec3d var12 : var4) {
         double var13 = var12.x - var3.x;
         double var15 = var12.y - var3.y;
         double var17 = var12.z - var3.z;
         double var19 = var13 * var13 + var15 * var15 + var17 * var17;
         if (!(var19 < 0.01)) {
            double var21 = Math.clamp(((var5 - var3.x) * var13 + (var7 - var3.y) * var15 + (var9 - var3.z) * var17) / var19, 0.0, 1.0);
            double var23 = var3.x + var13 * var21 - var5;
            double var25 = var3.y + var15 * var21 - var7;
            double var27 = var3.z + var17 * var21 - var9;
            double var29 = 2.4 + -1.7999999999999998 * var21;
            if (var23 * var23 + var25 * var25 + var27 * var27 <= var29 * var29) {
               return true;
            }
         }
      }

      return false;
   }

   private static void I_method_d6124c41(LongOpenHashSet var0) {
      LongOpenHashSet var1 = I_field_fc1c1fe6;
      I_field_fc1c1fe6 = var0;
      if (I_field_3a9bda27.worldRenderer != null && I_field_3a9bda27.world != null) {
         for (LongOpenHashSet var3 : List.of(var1, var0)) {
            LongIterator var4 = var3.iterator();

            while (var4.hasNext()) {
               long var5 = (Long)var4.next();
               if (!var1.contains(var5) || !var0.contains(var5)) {
                  BlockPos var7 = BlockPos.fromLong(var5);
                  BlockState var8 = I_field_3a9bda27.world.getBlockState(var7);
                  I_field_3a9bda27.worldRenderer.updateBlock(I_field_3a9bda27.world, var7, var8, var8, 3);
               }
            }
         }
      }
   }

   public static void I_method_9684a23f(Render3DEvent var0) {
      if (!I_field_89963af3.isEmpty() && I_field_3a9bda27.world != null) {
         Vec3d var1 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
         Immediate var2 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
         RenderLayer var3 = BlockGhostLayers.ready() ? BlockGhostLayers.ghost() : SchematicRenderLayers.visible();
         I_field_76c829e7.I_field_5707ecc = var2.getBuffer(var3);
         MatrixStack var4 = var0.getMatrices();
         Random var5 = Random.create();
         ObjectIterator var6 = I_field_89963af3.long2ObjectEntrySet().fastIterator();

         while (var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            BlockPos var8 = BlockPos.fromLong(var7.getLongKey());
            BlockState var9 = I_field_3a9bda27.world.getBlockState(var8);
            if (var9.getRenderType() == BlockRenderType.MODEL) {
               double var10 = var8.getX() + 0.5 - var1.x;
               double var12 = var8.getY() + 0.5 - var1.y;
               double var14 = var8.getZ() + 0.5 - var1.z;
               double var16 = Math.sqrt(var10 * var10 + var12 * var12 + var14 * var14);
               float var18 = (float)Math.clamp((var16 - 1.5) / 1.0, 0.0, 1.0);
               float var19 = 1.0F - (1.0F - 0.25F * var18) * ((iIiiIIIIi_Class354.Nested1_9e7c080)var7.getValue()).I_field_dc7facc.I_method_6ac4da6f();
               if (!(var19 <= 0.004F)) {
                  I_field_76c829e7.I_field_46 = var19;
                  I_field_623c9cc6.I_field_4a = var7.getLongKey();
                  var4.push();
                  var4.translate(var8.getX() - var1.x, var8.getY() - var1.y, var8.getZ() - var1.z);
                  I_field_3a9bda27.getBlockRenderManager().renderBlock(var9, var8, I_field_623c9cc6, var4, I_field_76c829e7, true, var5);
                  var4.pop();
               }
            }
         }

         I_field_76c829e7.I_field_5707ecc = null;
         var2.draw(var3);
      }
   }

   static final class Nested1_33104fc9 implements BlockRenderView {
      long I_field_4a;

      public BlockState getBlockState(BlockPos pos) {
         return pos.asLong() != this.I_field_4a && iIiiIIIIi_Class354.I_method_2b8f85bd(pos)
            ? Blocks.AIR.getDefaultState()
            : iIIiIIiIi_Class294.I_field_3a9bda27.world.getBlockState(pos);
      }

      public FluidState getFluidState(BlockPos pos) {
         return this.getBlockState(pos).getFluidState();
      }

      @Nullable
      public BlockEntity getBlockEntity(BlockPos pos) {
         return iIIiIIiIi_Class294.I_field_3a9bda27.world.getBlockEntity(pos);
      }

      public float getBrightness(Direction direction, boolean shaded) {
         return iIIiIIiIi_Class294.I_field_3a9bda27.world.getBrightness(direction, shaded);
      }

      public LightingProvider getLightingProvider() {
         return iIIiIIiIi_Class294.I_field_3a9bda27.world.getLightingProvider();
      }

      public int getColor(BlockPos pos, ColorResolver colorResolver) {
         return iIIiIIiIi_Class294.I_field_3a9bda27.world.getColor(pos, colorResolver);
      }

      public int getHeight() {
         return iIIiIIiIi_Class294.I_field_3a9bda27.world.getHeight();
      }

      public int getBottomY() {
         return iIIiIIiIi_Class294.I_field_3a9bda27.world.getBottomY();
      }
   }

   static final class Nested1_9e7c080 {
      final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(220L, 0.0F, IiiiIiiII_Class237.Iii_field_dd60aac);
      int I_field_49 = 3;
      boolean I_field_5a;
   }

   static final class Nested1_9e7c0a0 implements VertexConsumer {
      VertexConsumer I_field_5707ecc;
      float I_field_46 = 1.0F;

      public VertexConsumer vertex(float x, float y, float z) {
         return this.I_field_5707ecc.vertex(x, y, z);
      }

      public VertexConsumer color(int red, int green, int blue, int alpha) {
         return this.I_field_5707ecc.color(red, green, blue, (int)(alpha * this.I_field_46));
      }

      public VertexConsumer texture(float u, float v) {
         return this.I_field_5707ecc.texture(u, v);
      }

      public VertexConsumer overlay(int u, int v) {
         return this.I_field_5707ecc.overlay(u, v);
      }

      public VertexConsumer light(int u, int v) {
         return this.I_field_5707ecc.light(u, v);
      }

      public VertexConsumer normal(float x, float y, float z) {
         return this.I_field_5707ecc.normal(x, y, z);
      }

      public void vertex(float x, float y, float z, int color, float u, float v, int overlay, int light, float normalX, float normalY, float normalZ) {
         int var12 = ColorHelper.withAlpha((int)(ColorHelper.getAlpha(color) * this.I_field_46), color);
         this.I_field_5707ecc.vertex(x, y, z, var12, u, v, overlay, light, normalX, normalY, normalZ);
      }
   }
}
