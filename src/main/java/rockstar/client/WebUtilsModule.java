package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.jetbrains.annotations.NotNull;
import pyrock.events.player.ClientPlayerTickEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Web Utils",
   category = ModuleCategory.OTHER
)
public class WebUtilsModule extends Module {
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting i_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private SliderSetting II_field_73178e8c;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         if (this.I_field_51de8227.isSelected()) {
            this.Iii_method_f6c81e7f();
         }

         if (this.i_field_51de8227.isSelected()) {
            LivingEntity var2 = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
            if (var2 != null
               && I_field_3a9bda27.player.getPos().distanceTo(var2.getPos())
                  <= RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class).I_method_af0f42().Ii_method_a20abcd2()) {
               if (this.I_method_a3d1f222(var2)) {
                  return;
               }

               List var3 = this.I_method_b369a069(var2);
               int var4 = Math.min((int)this.I_field_73178e8c.Ii_method_a20abcd2(), var3.size());
               int var5 = 0;

               for (BlockPos var7 : (Iterable<BlockPos>)(Iterable<?>)var3) {
                  if (var5 >= var4) {
                     break;
                  }

                  var5++;
                  WebUtilsModule.Nested1_bc006860 var8 = this.I_method_ebb312a(var7);
                  if (var8 != null) {
                     this.I_method_910e28a7(var8.I_method_9bf29870());
                     if (this.I_method_910e28ab(var8.I_method_9bf29870()) && this.I_field_991c1e8c.I_method_58432069(this.I_method_f3ffc213())) {
                        if (this.I_method_a19230db(var8) == null) {
                           return;
                        }

                        WebUtilsModule.Nested1_bc006880 var9 = this.I_method_c2432850();
                        if (var9 == null) {
                           return;
                        }

                        try {
                           if (this.I_method_cbedb85e(var9.I_method_815bf890(), var8)) {
                              this.I_field_991c1e8c.I_method_23e11e3f();
                           }
                        } finally {
                           this.I_method_64abaa02(var9);
                        }

                        return;
                     }

                     return;
                  }
               }
            }
         }
      }
   };

   public WebUtilsModule() {
      this.IiI_method_f6b9929f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_f6b9929f() {
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.web_utils");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.web_utils.no_web");
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.web_utils.trap_web");
      this.i_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.web_utils.placement_mode", () -> !this.i_field_51de8227.isSelected());
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.web_utils.placement_mode.default").select();
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.web_utils.placement_mode.full_body");
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.web_utils.placement_mode.sides");
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.web_utils.count", () -> !this.i_field_51de8227.isSelected())
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(6.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(1.0F);
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.web_utils.delay", () -> !this.i_field_51de8227.isSelected())
         .I_method_c8c9a7d7(100.0F)
         .i_method_65e2aff7(1000.0F)
         .II_method_b0f56334(50.0F)
         .Ii_method_4e0e6b54(150.0F)
         .I_method_d41e7abf("ms");
      this.II_field_73178e8c = new SliderSetting(this, "modules.settings.web_utils.no_web_speed", () -> !this.I_field_51de8227.isSelected())
         .I_method_c8c9a7d7(0.1F)
         .i_method_65e2aff7(1.0F)
         .II_method_b0f56334(0.01F)
         .Ii_method_4e0e6b54(0.57F);
   }

   private void Iii_method_f6c81e7f() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && this.IiI_method_f6b992a3()) {
         double var1 = I_field_3a9bda27.options.jumpKey.isPressed() ? 1.3 : (I_field_3a9bda27.options.sneakKey.isPressed() ? -1.3 : 0.0);
         float var3 = I_field_3a9bda27.player.getYaw() * (float) (Math.PI / 180.0);
         float var4 = this.II_field_73178e8c.Ii_method_a20abcd2();
         float var5 = I_field_3a9bda27.player.forwardSpeed * var4;
         float var6 = I_field_3a9bda27.player.sidewaysSpeed * var4;
         if (var5 == 0.0F && var6 == 0.0F) {
            I_field_3a9bda27.player.setVelocity(0.0, var1, 0.0);
         } else {
            I_field_3a9bda27.player
               .setVelocity(-MathHelper.sin(var3) * var5 + MathHelper.cos(var3) * var6, var1, MathHelper.cos(var3) * var5 + MathHelper.sin(var3) * var6);
         }
      }
   }

   private boolean IiI_method_f6b992a3() {
      return this.I_method_a3d1f222(I_field_3a9bda27.player);
   }

   private boolean I_method_a3d1f222(LivingEntity var1) {
      Box var2 = var1.getBoundingBox();
      int var3 = MathHelper.floor(var2.minX);
      int var4 = MathHelper.floor(var2.minY);
      int var5 = MathHelper.floor(var2.minZ);
      int var6 = MathHelper.ceil(var2.maxX);
      int var7 = MathHelper.ceil(var2.maxY);
      int var8 = MathHelper.ceil(var2.maxZ);
      Mutable var9 = new Mutable();

      for (int var10 = var3; var10 < var6; var10++) {
         for (int var11 = var4; var11 < var7; var11++) {
            for (int var12 = var5; var12 < var8; var12++) {
               if (I_field_3a9bda27.world.getBlockState(var9.set(var10, var11, var12)).isOf(Blocks.COBWEB)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private WebUtilsModule.Nested1_bc006880 I_method_c2432850() {
      int var1 = I_field_3a9bda27.player.getInventory().selectedSlot;
      iIIiiiiIi_Class318 var2 = iIIiiIiIi_Class310.Ii_method_1c02fc38().I_method_77fa4424(var0 -> var0.getItem() == Items.COBWEB);
      if (var2 != null) {
         return new WebUtilsModule.Nested1_bc006880(var2, -1, -1);
      } else {
         iIIiiiIii_Class316 var3 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(var0 -> var0.getItem() == Items.COBWEB);
         if (var3 != null) {
            iIIiIiIiI_Class299.i_method_8225b484(var3.II_method_b9cf08f5());
            return new WebUtilsModule.Nested1_bc006880(var3, var1, -1);
         } else {
            iIIiiiiII_Class317 var4 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(var0 -> var0.getItem() == Items.COBWEB);
            if (var4 != null) {
               iIIiIiIiI_Class299.iI_method_c617e8c2(var4.I_method_dfe89252(), I_field_3a9bda27.player.getInventory().selectedSlot);
               return new WebUtilsModule.Nested1_bc006880(new iIIiiiIii_Class316(var1), var1, var4.I_method_dfe89252());
            } else {
               return null;
            }
         }
      }
   }

   private void I_method_64abaa02(WebUtilsModule.Nested1_bc006880 var1) {
      if (I_field_3a9bda27.player != null && var1 != null) {
         if (var1.i_method_1925770d() != -1) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(var1.i_method_1925770d(), var1.I_method_1916eb2d());
         } else {
            if (var1.I_method_1916eb2d() != -1) {
               iIIiIiIiI_Class299.i_method_8225b484(var1.I_method_1916eb2d());
            }
         }
      }
   }

   private boolean I_method_cbedb85e(iIIiIiIii_Class300 var1, WebUtilsModule.Nested1_bc006860 var2) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.interactionManager != null && I_field_3a9bda27.world != null) {
         Hand var3 = this.I_method_b74df5f0(var1);
         if (var3 == null) {
            return false;
         } else {
            BlockHitResult var4 = this.I_method_a19230db(var2);
            if (var4 == null) {
               return false;
            } else {
               ActionResult var5 = I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, var3, var4);
               if (!var5.isAccepted()) {
                  return false;
               } else {
                  I_field_3a9bda27.player.swingHand(var3);
                  return true;
               }
            }
         }
      } else {
         return false;
      }
   }

   private Hand I_method_b74df5f0(iIIiIiIii_Class300 var1) {
      if (var1 instanceof iIIiiiiIi_Class318) {
         return Hand.OFF_HAND;
      } else if (var1 instanceof iIIiiiIii_Class316 var2) {
         iIIiIiIiI_Class299.i_method_8225b484(var2.II_method_b9cf08f5());
         return Hand.MAIN_HAND;
      } else {
         return null;
      }
   }

   private WebUtilsModule.Nested1_bc006860 I_method_ebb312a(BlockPos var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && this.I_method_74ec49dd(var1)) {
         Vec3d var2 = I_field_3a9bda27.player.getEyePos();
         double var3 = I_field_3a9bda27.player.getBlockInteractionRange();

         for (Direction var8 : Direction.values()) {
            BlockPos var9 = var1.offset(var8);
            Direction var10 = var8.getOpposite();
            if (this.i_method_9f3fddbd(var9)) {
               Vec3d var11 = this.I_method_2ac04a31(var9, var10);
               if (!(var2.squaredDistanceTo(var11) > var3 * var3)) {
                  iiIIiIIii_Class404 var12 = this.I_method_433c1975(var2, var11);
                  return new WebUtilsModule.Nested1_bc006860(var1, var9, var10, var12);
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private boolean I_method_74ec49dd(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      return var2.isAir() || var2.getCollisionShape(I_field_3a9bda27.world, var1).isEmpty() && I_field_3a9bda27.world.getFluidState(var1).isEmpty();
   }

   private boolean i_method_9f3fddbd(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      return !var2.isAir();
   }

   private Vec3d I_method_2ac04a31(BlockPos var1, Direction var2) {
      return var1.toCenterPos().add(var2.getOffsetX() * 0.5, var2.getOffsetY() * 0.5, var2.getOffsetZ() * 0.5);
   }

   private iiIIiIIii_Class404 I_method_433c1975(Vec3d var1, Vec3d var2) {
      double var3 = var2.x - var1.x;
      double var5 = var2.y - var1.y;
      double var7 = var2.z - var1.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      return new iiIIiIIii_Class404((float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F, (float)(-Math.toDegrees(Math.atan2(var5, var9))));
   }

   private void I_method_910e28a7(iiIIiIIii_Class404 var1) {
      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(var1, iiIIiIIIi_Class402.Ii_field_32e0c64c, 90.0F, 90.0F, 75.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
   }

   private boolean I_method_910e28ab(iiIIiIIii_Class404 var1) {
      iiIIiIIii_Class404 var2 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      float var3 = Math.abs(MathHelper.wrapDegrees(var2.I_method_14534e0f() - var1.I_method_14534e0f()));
      float var4 = Math.abs(var2.i_method_1461d9ef() - var1.i_method_1461d9ef());
      return var3 <= 5.0F && var4 <= 5.0F;
   }

   private BlockHitResult I_method_a19230db(WebUtilsModule.Nested1_bc006860 var1) {
      iiIIiIIii_Class404 var2 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      BlockHitResult var3 = this.I_method_686c2fa0(var2);
      return !this.I_method_8584779b(var3, var1) ? null : var3;
   }

   private BlockHitResult I_method_686c2fa0(iiIIiIIii_Class404 var1) {
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      Vec3d var3 = var2.add(
         I_field_3a9bda27.player
            .getRotationVector(var1.i_method_1461d9ef(), var1.I_method_14534e0f())
            .multiply(I_field_3a9bda27.player.getBlockInteractionRange())
      );
      return I_field_3a9bda27.world.raycast(new RaycastContext(var2, var3, ShapeType.OUTLINE, FluidHandling.NONE, I_field_3a9bda27.player));
   }

   private boolean I_method_8584779b(BlockHitResult var1, WebUtilsModule.Nested1_bc006860 var2) {
      return var1 != null && var1.getType() == Type.BLOCK
         ? var1.getBlockPos().equals(var2.i_method_17188c56())
            && var1.getSide() == var2.I_method_632cc33a()
            && var1.getBlockPos().offset(var1.getSide()).equals(var2.I_method_a21e1c36())
            && this.I_method_74ec49dd(var2.I_method_a21e1c36())
            && this.i_method_9f3fddbd(var2.i_method_17188c56())
         : false;
   }

   private long I_method_f3ffc213() {
      return Math.max(100L, (long)this.i_field_73178e8c.Ii_method_a20abcd2());
   }

   @NotNull
   private List<BlockPos> I_method_b369a069(LivingEntity var1) {
      BlockPos var2 = var1.getBlockPos();
      ArrayList var3 = new ArrayList();
      if (this.II_field_51de8227.isSelected()) {
         this.I_method_c619bc8a(var3, var2);
      }

      if (this.Ii_field_51de8227.isSelected()) {
         this.I_method_c619bc8a(var3, var2);
         this.I_method_c619bc8a(var3, var2.up());
      }

      if (this.iI_field_51de8227.isSelected()) {
         this.I_method_c619bc8a(var3, var2.north());
         this.I_method_c619bc8a(var3, var2.south());
         this.I_method_c619bc8a(var3, var2.east());
         this.I_method_c619bc8a(var3, var2.west());
         this.I_method_c619bc8a(var3, var2.north().up());
         this.I_method_c619bc8a(var3, var2.south().up());
      }

      return var3;
   }

   private void I_method_c619bc8a(List<BlockPos> var1, BlockPos var2) {
      if (!var1.contains(var2)) {
         var1.add(var2);
      }
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 I_method_c5d2c70() {
      return this.I_field_51de8227;
   }

   static final class Nested1_bc006860 {
      private final BlockPos I_field_670402ba;
      private final BlockPos i_field_670402ba;
      private final Direction I_field_3b03ad36;
      private final iiIIiIIii_Class404 I_field_32e13e6c;

      Nested1_bc006860(BlockPos var1, BlockPos var2, Direction var3, iiIIiIIii_Class404 var4) {
         this.I_field_670402ba = var1;
         this.i_field_670402ba = var2;
         this.I_field_3b03ad36 = var3;
         this.I_field_32e13e6c = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_bc006860[placePos=" + this.I_field_670402ba + ", support=" + this.i_field_670402ba + ", side=" + this.I_field_3b03ad36 + ", rotation=" + this.I_field_32e13e6c + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_670402ba);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_670402ba);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_3b03ad36);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_32e13e6c);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         WebUtilsModule.Nested1_bc006860 other = (WebUtilsModule.Nested1_bc006860) var1;
         return java.util.Objects.equals(this.I_field_670402ba, other.I_field_670402ba)
            && java.util.Objects.equals(this.i_field_670402ba, other.i_field_670402ba)
            && java.util.Objects.equals(this.I_field_3b03ad36, other.I_field_3b03ad36)
            && java.util.Objects.equals(this.I_field_32e13e6c, other.I_field_32e13e6c);
      }

      public BlockPos I_method_a21e1c36() {
         return this.I_field_670402ba;
      }

      public BlockPos i_method_17188c56() {
         return this.i_field_670402ba;
      }

      public Direction I_method_632cc33a() {
         return this.I_field_3b03ad36;
      }

      public iiIIiIIii_Class404 I_method_9bf29870() {
         return this.I_field_32e13e6c;
      }
   }

   static final class Nested1_bc006880 {
      private final iIIiIiIii_Class300 I_field_1242a2ac;
      private final int I_field_49;
      private final int i_field_49;

      Nested1_bc006880(iIIiIiIii_Class300 var1, int var2, int var3) {
         this.I_field_1242a2ac = var1;
         this.I_field_49 = var2;
         this.i_field_49 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_bc006880[slot=" + this.I_field_1242a2ac + ", previousHotbarSlot=" + this.I_field_49 + ", swappedInventorySlot=" + this.i_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_1242a2ac);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         WebUtilsModule.Nested1_bc006880 other = (WebUtilsModule.Nested1_bc006880) var1;
         return java.util.Objects.equals(this.I_field_1242a2ac, other.I_field_1242a2ac)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49);
      }

      public iIIiIiIii_Class300 I_method_815bf890() {
         return this.I_field_1242a2ac;
      }

      public int I_method_1916eb2d() {
         return this.I_field_49;
      }

      public int i_method_1925770d() {
         return this.i_field_49;
      }
   }
}
