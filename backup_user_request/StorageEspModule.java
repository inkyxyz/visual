package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.block.entity.DropperBlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.block.entity.TrappedChestBlockEntity;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.ChestMinecartEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Storage ESP",
   category = ModuleCategory.VISUALS
)
public class StorageEspModule extends Module {
   private static final Box I_field_bdfefbea = new Box(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
   private static final Box i_field_bdfefbea = new Box(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
   private static final long I_field_4a = 1000L;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private volatile List<StorageEspModule.Nested1_fb5aca0> I_field_7865b31 = new ArrayList<>();
   private volatile List<StorageEspModule.Nested1_fb5acc0> i_field_7865b31 = new ArrayList<>();
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 IiI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Iii_field_51de8227;
   private MultiSelectSetting i_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 iII_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iIi_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iiI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iii_field_51de8227;
   private SliderSetting I_field_73178e8c;
   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         MatrixStack var2 = var1.getMatrices();
         Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
         Vec3d var4 = var3.getPos();
         List var5 = this.I_field_7865b31;
         List var6 = this.i_field_7865b31;
         RenderSystem.enableBlend();
         RenderSystem.disableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
         BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

         for (StorageEspModule.Nested1_fb5aca0 var9 : (Iterable<StorageEspModule.Nested1_fb5aca0>)(Iterable<?>)var5) {
            for (Box var11 : var9.I_field_7865b31) {
               if (this.iII_field_51de8227.isSelected()) {
                  iIiiIIiIi_Class358.i_method_5e35f7b9(
                     var2, var7, var11.offset(-var4.getX(), -var4.getY(), -var4.getZ()), var9.I_field_d0c8ec5.withAlpha(50.0F)
                  );
               }
            }
         }

         for (StorageEspModule.Nested1_fb5acc0 var15 : (Iterable<StorageEspModule.Nested1_fb5acc0>)(Iterable<?>)var6) {
            if (this.iII_field_51de8227.isSelected()) {
               iIiiIIiIi_Class358.i_method_5e35f7b9(
                  var2, var7, var15.I_field_bdfefbea.offset(-var4.getX(), -var4.getY(), -var4.getZ()), var15.I_field_d0c8ec5.withAlpha(50.0F)
               );
            }
         }

         iIiiiIIiI_Class371.I_method_c59155f0(var7);
         BufferBuilder var14 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

         for (StorageEspModule.Nested1_fb5aca0 var18 : (Iterable<StorageEspModule.Nested1_fb5aca0>)(Iterable<?>)var5) {
            for (Box var12 : var18.I_field_7865b31) {
               if (this.iiI_field_51de8227.isSelected()) {
                  iIiiIIiIi_Class358.II_method_fde357f6(
                     var2, var14, var12.offset(-var4.getX(), -var4.getY(), -var4.getZ()), var18.I_field_d0c8ec5.withAlpha(100.0F)
                  );
               }

               if (this.iIi_field_51de8227.isSelected()) {
                  iIiiIIiIi_Class358.Ii_method_c1caf816(
                     var2, var14, var12.offset(-var4.getX(), -var4.getY(), -var4.getZ()), var18.I_field_d0c8ec5.withAlpha(100.0F)
                  );
               }

               if (this.iii_field_51de8227.isSelected()) {
                  iIiiIIiIi_Class358.I_method_3f08a433(var2, var14, var18.I_field_5bba0d50, var18.I_field_d0c8ec5);
               }
            }
         }

         for (StorageEspModule.Nested1_fb5acc0 var19 : (Iterable<StorageEspModule.Nested1_fb5acc0>)(Iterable<?>)var6) {
            if (this.iiI_field_51de8227.isSelected()) {
               iIiiIIiIi_Class358.II_method_fde357f6(
                  var2, var14, var19.I_field_bdfefbea.offset(-var4.getX(), -var4.getY(), -var4.getZ()), var19.I_field_d0c8ec5.withAlpha(100.0F)
               );
            }

            if (this.iIi_field_51de8227.isSelected()) {
               iIiiIIiIi_Class358.Ii_method_c1caf816(
                  var2, var14, var19.I_field_bdfefbea.offset(-var4.getX(), -var4.getY(), -var4.getZ()), var19.I_field_d0c8ec5.withAlpha(100.0F)
               );
            }

            if (this.iii_field_51de8227.isSelected()) {
               iIiiIIiIi_Class358.I_method_3f08a433(var2, var14, var19.I_field_5bba0d50, var19.I_field_d0c8ec5);
            }
         }

         iIiiiIIiI_Class371.I_method_c59155f0(var14);
         RenderSystem.defaultBlendFunc();
         RenderSystem.enableCull();
         RenderSystem.enableDepthTest();
         RenderSystem.disableBlend();
      }
   };
   private final IiIIIiII_Class69<WorldChangeEvent> i_field_3d936f41 = var1 -> {
      iIIIIiiiI_Class271.I_method_8dcc23f();
      this.I_field_7865b31 = new ArrayList<>();
      this.i_field_7865b31 = new ArrayList<>();
   };
   private final IiIIIiII_Class69<ClientPlayerTickEvent> II_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         if (this.I_field_991c1e8c.I_method_58432069(1000L)) {
            ArrayList var2 = new ArrayList();

            for (BlockEntity var4 : iIIIIiiiI_Class271.I_method_ea43a7e8()) {
               if (this.I_method_aca69938(var4)) {
                  List var5 = this.I_method_f25b2a93(var4);
                  ColorRGBA var6 = this.I_method_da682fa3(var4);
                  Vec3d var7 = var4.getPos().toCenterPos();
                  var2.add(new StorageEspModule.Nested1_fb5aca0(var5, var6, var7));
               }
            }

            ArrayList var9 = new ArrayList();

            for (Entity var11 : I_field_3a9bda27.world.getEntities()) {
               if (this.I_method_4169248b(var11)) {
                  Box var12 = var11.getBoundingBox();
                  ColorRGBA var13 = this.I_method_d730aef6(var11);
                  Vec3d var8 = var11.getPos();
                  var9.add(new StorageEspModule.Nested1_fb5acc0(var12, var13, var8));
               }
            }

            this.I_field_7865b31 = var2;
            this.i_field_7865b31 = var9;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   };

   public StorageEspModule() {
      this.IiI_method_22e4f65f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_22e4f65f() {
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.storage_esp.blocks");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.chests").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.ender_chests").select();
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.trapped_chests");
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.furnaces");
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.barrels").select();
      this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.minecart").select();
      this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.shulkers").select();
      this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.droppers");
      this.IiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.dispensers");
      this.Iii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.storage_esp.blocks.hoppers");
      this.i_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.storage_esp.render");
      this.iII_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.storage_esp.render.fill").select();
      this.iIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.storage_esp.render.outline").select();
      this.iiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.storage_esp.render.diagonals").select();
      this.iii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.storage_esp.render.lines");
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.storage_esp.max_distance", "modules.settings.storage_esp.max_distance.description")
         .I_method_c8c9a7d7(5.0F)
         .i_method_65e2aff7(128.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(128.0F);
   }

   private List<Box> I_method_f25b2a93(BlockEntity var1) {
      if (I_field_3a9bda27.world == null) {
         return List.of(i_field_bdfefbea);
      } else {
         BlockPos var2 = var1.getPos();
         BlockState var3 = I_field_3a9bda27.world.getBlockState(var2);
         VoxelShape var4 = var3.getOutlineShape(I_field_3a9bda27.world, var2);
         return var4.isEmpty() ? List.of(I_field_bdfefbea.offset(var2)) : var4.getBoundingBoxes().stream().map(var1x -> var1x.offset(var2)).toList();
      }
   }

   private boolean I_method_aca69938(BlockEntity var1) {
      double var2 = this.I_field_73178e8c.Ii_method_a20abcd2() * this.I_field_73178e8c.Ii_method_a20abcd2();
      if (I_field_3a9bda27.player == null || I_field_3a9bda27.player.squaredDistanceTo(var1.getPos().toCenterPos()) > var2) {
         return false;
      } else if (var1 instanceof ChestBlockEntity && this.I_field_51de8227.isSelected()) {
         return true;
      } else if (var1 instanceof EnderChestBlockEntity && this.i_field_51de8227.isSelected()) {
         return true;
      } else if (var1 instanceof TrappedChestBlockEntity && this.II_field_51de8227.isSelected()) {
         return true;
      } else if (var1 instanceof FurnaceBlockEntity && this.Ii_field_51de8227.isSelected()) {
         return true;
      } else if (var1 instanceof BarrelBlockEntity && this.iI_field_51de8227.isSelected()) {
         return true;
      } else if (var1 instanceof ShulkerBoxBlockEntity && this.III_field_51de8227.isSelected()) {
         return true;
      } else if (var1 instanceof DropperBlockEntity && this.IIi_field_51de8227.isSelected()) {
         return true;
      } else {
         return var1 instanceof DispenserBlockEntity && this.IiI_field_51de8227.isSelected()
            ? true
            : var1 instanceof HopperBlockEntity && this.Iii_field_51de8227.isSelected();
      }
   }

   private ColorRGBA I_method_da682fa3(BlockEntity var1) {
      if (var1 instanceof ChestBlockEntity) {
         return new ColorRGBA(255.0F, 131.0F, 54.0F);
      } else if (var1 instanceof EnderChestBlockEntity) {
         return new ColorRGBA(121.0F, 54.0F, 255.0F);
      } else if (var1 instanceof TrappedChestBlockEntity) {
         return new ColorRGBA(255.0F, 101.0F, 54.0F);
      } else if (var1 instanceof FurnaceBlockEntity) {
         return new ColorRGBA(126.0F, 126.0F, 126.0F);
      } else if (var1 instanceof BarrelBlockEntity) {
         return new ColorRGBA(255.0F, 185.0F, 54.0F);
      } else if (var1 instanceof ShulkerBoxBlockEntity) {
         if (var1.getCachedState().getBlock() instanceof ShulkerBoxBlock var2) {
            DyeColor var4 = var2.getColor();
            if (var4 != null) {
               return ColorRGBA.fromInt(var4.getEntityColor());
            }
         }

         return new ColorRGBA(181.0F, 54.0F, 255.0F);
      } else if (var1 instanceof DropperBlockEntity) {
         return new ColorRGBA(100.0F, 100.0F, 100.0F);
      } else if (var1 instanceof DispenserBlockEntity) {
         return new ColorRGBA(100.0F, 100.0F, 100.0F);
      } else {
         return var1 instanceof HopperBlockEntity ? new ColorRGBA(100.0F, 100.0F, 100.0F) : IiiiiIIIi_Class242.Ii_field_d0c8ec5;
      }
   }

   private ColorRGBA I_method_d730aef6(Entity var1) {
      return var1 instanceof ChestMinecartEntity ? new ColorRGBA(255.0F, 200.0F, 100.0F) : IiiiiIIIi_Class242.Ii_field_d0c8ec5;
   }

   private boolean I_method_4169248b(Entity var1) {
      double var2 = this.I_field_73178e8c.Ii_method_a20abcd2() * this.I_field_73178e8c.Ii_method_a20abcd2();
      return I_field_3a9bda27.player != null && !(I_field_3a9bda27.player.squaredDistanceTo(var1.getPos()) > var2)
         ? var1 instanceof ChestMinecartEntity && this.ii_field_51de8227.isSelected()
         : false;
   }

   static final class Nested1_fb5aca0 {
      final List<Box> I_field_7865b31;
      final ColorRGBA I_field_d0c8ec5;
      final Vec3d I_field_5bba0d50;

      Nested1_fb5aca0(List<Box> var1, ColorRGBA var2, Vec3d var3) {
         this.I_field_7865b31 = var1;
         this.I_field_d0c8ec5 = var2;
         this.I_field_5bba0d50 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_fb5aca0[boundingBoxes=" + this.I_field_7865b31 + ", color=" + this.I_field_d0c8ec5 + ", centerPos=" + this.I_field_5bba0d50 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d0c8ec5);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         StorageEspModule.Nested1_fb5aca0 other = (StorageEspModule.Nested1_fb5aca0) var1;
         return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_d0c8ec5, other.I_field_d0c8ec5)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50);
      }

      public List<Box> I_method_b5f1bfed() {
         return this.I_field_7865b31;
      }

      public ColorRGBA I_method_f977b989() {
         return this.I_field_d0c8ec5;
      }

      public Vec3d I_method_4bb91914() {
         return this.I_field_5bba0d50;
      }
   }

   static final class Nested1_fb5acc0 {
      final Box I_field_bdfefbea;
      final ColorRGBA I_field_d0c8ec5;
      final Vec3d I_field_5bba0d50;

      Nested1_fb5acc0(Box var1, ColorRGBA var2, Vec3d var3) {
         this.I_field_bdfefbea = var1;
         this.I_field_d0c8ec5 = var2;
         this.I_field_5bba0d50 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_fb5acc0[boundingBox=" + this.I_field_bdfefbea + ", color=" + this.I_field_d0c8ec5 + ", pos=" + this.I_field_5bba0d50 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_bdfefbea);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d0c8ec5);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         StorageEspModule.Nested1_fb5acc0 other = (StorageEspModule.Nested1_fb5acc0) var1;
         return java.util.Objects.equals(this.I_field_bdfefbea, other.I_field_bdfefbea)
            && java.util.Objects.equals(this.I_field_d0c8ec5, other.I_field_d0c8ec5)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50);
      }

      public Box I_method_3b0eac8e() {
         return this.I_field_bdfefbea;
      }

      public ColorRGBA I_method_23cb4d69() {
         return this.I_field_d0c8ec5;
      }

      public Vec3d I_method_d3a024f4() {
         return this.I_field_5bba0d50;
      }
   }
}
