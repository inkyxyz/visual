package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

public class IIIiiiIiI_Class59 extends IIIiiiIii_Class60 {
   private final ModeSetting I_field_bbe33e6c;
   private final ModeSetting.Nested1_42765c60 I_field_500d0627;
   private final ModeSetting.Nested1_42765c60 i_field_500d0627;
   private final ModeSetting.Nested1_42765c60 II_field_500d0627;
   private final ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private final ModeSetting.Nested1_42765c60 iI_field_500d0627;
   private final ModeSetting.Nested1_42765c60 ii_field_500d0627;
   private final SliderSetting I_field_73178e8c;
   private final SliderSetting i_field_73178e8c;
   private final BooleanSetting I_field_ba20ca4c;
   private final BooleanSetting i_field_ba20ca4c;
   private final BooleanSetting II_field_ba20ca4c;
   private final BooleanSetting Ii_field_ba20ca4c;
   private BooleanSetting iI_field_ba20ca4c;
   private final SliderSetting II_field_73178e8c;
   private static final float I_field_46 = 1.5F;
   private static final int I_field_49 = 3;
   private static final float i_field_46 = 0.05F;
   private static final double I_field_44 = 1.9599999999999997;
   private final List<BlockPos> I_field_7865b31 = new ArrayList<>();
   private final List<BlockPos> i_field_7865b31 = new ArrayList<>();
   private final Map<BlockPos, Integer> I_field_a567c40b = new HashMap<>();
   private final List<ItemEntity> II_field_7865b31 = new ArrayList<>();
   private final Set<BlockPos> I_field_a56a8dc5 = new HashSet<>();
   private BlockPos I_field_670402ba;
   private ItemEntity I_field_e08508f9;
   private BlockPos i_field_670402ba;
   private int i_field_49 = -1;
   private int II_field_49 = -1;
   private IIIiiiIiI_Class59.Nested1_b8341800 I_field_9206be87;
   private boolean I_field_5a;
   private long I_field_4a;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private int Ii_field_49;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;
   private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(120.0F, 220.0F, 96.0F);
   private static final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(255.0F, 196.0F, 64.0F);
   private final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41;

   public IIIiiiIiI_Class59(AutoFarmModule var1, ModeSetting var2) {
      super(var1, var2, "modules.settings.auto_farm.modes.crop");
      this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.I_field_9206be87;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.I_field_3d936f41 = var1x -> {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            switch (this.I_field_9206be87) {
               case I_field_9206be87:
                  this.III_method_51bfb6df();
                  break;
               case i_field_9206be87:
                  this.IIi_method_51ce42bf();
                  break;
               case II_field_9206be87:
                  this.IiI_method_5382a6ff();
                  break;
               case Ii_field_9206be87:
                  this.Iii_method_539132df();
                  break;
               case iI_field_9206be87:
                  this.iii_method_8a2c46bf();
                  break;
               case ii_field_9206be87:
                  this.IiiI_method_1ea42062();
                  break;
               case III_field_9206be87:
                  this.Iiii_method_1eb2ac42();
                  break;
               case IIi_field_9206be87:
                  this.iIII_method_830d8482();
                  break;
               case IiI_field_9206be87:
                  this.ii_method_e36bd4c2();
            }
         }
      };
      this.i_field_3d936f41 = var1x -> {
         if (this.iI_field_ba20ca4c.i_method_9b12da03()) {
            if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
               BlockPos var2x = this.I_field_9206be87 != IIIiiiIiI_Class59.Nested1_b8341800.i_field_9206be87
                     && this.I_field_9206be87 != IIIiiiIiI_Class59.Nested1_b8341800.II_field_9206be87
                     && this.I_field_9206be87 != IIIiiiIiI_Class59.Nested1_b8341800.Ii_field_9206be87
                  ? null
                  : this.I_field_670402ba;
               BlockPos var3 = this.I_field_9206be87 != IIIiiiIiI_Class59.Nested1_b8341800.ii_field_9206be87
                     && this.I_field_9206be87 != IIIiiiIiI_Class59.Nested1_b8341800.III_field_9206be87
                     && this.I_field_9206be87 != IIIiiiIiI_Class59.Nested1_b8341800.IIi_field_9206be87
                  ? null
                  : this.i_field_670402ba;
               if (var2x != null || var3 != null) {
                  MatrixStack var4 = var1x.getMatrices();
                  Camera var5 = I_field_3a9bda27.gameRenderer.getCamera();
                  Vec3d var6 = var5.getPos();
                  RenderSystem.enableBlend();
                  RenderSystem.disableDepthTest();
                  RenderSystem.disableCull();
                  RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
                  RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
                  BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
                  if (var2x != null) {
                     iIiiIIiIi_Class358.i_method_5e35f7b9(
                        var4, var7, this.I_method_42e4f74d(var2x).offset(-var6.x, -var6.y, -var6.z), I_field_d0c8ec5.withAlpha(45.0F)
                     );
                  }

                  if (var3 != null) {
                     iIiiIIiIi_Class358.i_method_5e35f7b9(
                        var4, var7, this.I_method_42e4f74d(var3).offset(-var6.x, -var6.y, -var6.z), i_field_d0c8ec5.withAlpha(45.0F)
                     );
                  }

                  iIiiiIIiI_Class371.I_method_c59155f0(var7);
                  BufferBuilder var8 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
                  if (var2x != null) {
                     iIiiIIiIi_Class358.Ii_method_c1caf816(
                        var4, var8, this.I_method_42e4f74d(var2x).offset(-var6.x, -var6.y, -var6.z), I_field_d0c8ec5.withAlpha(180.0F)
                     );
                  }

                  if (var3 != null) {
                     iIiiIIiIi_Class358.Ii_method_c1caf816(
                        var4, var8, this.I_method_42e4f74d(var3).offset(-var6.x, -var6.y, -var6.z), i_field_d0c8ec5.withAlpha(180.0F)
                     );
                  }

                  iIiiiIIiI_Class371.I_method_c59155f0(var8);
                  RenderSystem.defaultBlendFunc();
                  RenderSystem.enableCull();
                  RenderSystem.enableDepthTest();
                  RenderSystem.disableBlend();
               }
            }
         }
      };
      this.I_field_bbe33e6c = new ModeSetting(var1, "modules.settings.crop_farm.crop", () -> !this.isSelected());
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.crop_farm.crop.nether_wart").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.crop_farm.crop.wheat");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.crop_farm.crop.carrots");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.crop_farm.crop.potatoes");
      this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.crop_farm.crop.beetroots");
      this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.crop_farm.crop.sugar_cane");
      this.I_field_73178e8c = new SliderSetting(var1, "modules.settings.crop_farm.scan_radius", () -> !this.isSelected())
         .II_method_b0f56334(2.0F)
         .I_method_c8c9a7d7(8.0F)
         .i_method_65e2aff7(64.0F)
         .Ii_method_4e0e6b54(24.0F);
      this.i_field_73178e8c = new SliderSetting(var1, "modules.settings.crop_farm.vertical_range", () -> !this.isSelected())
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(8.0F)
         .Ii_method_4e0e6b54(3.0F);
      this.I_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.crop_farm.replant", () -> !this.isSelected()).I_method_decd82b5();
      this.i_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.crop_farm.use_hoe", () -> !this.isSelected()).I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.crop_farm.pickup", () -> !this.isSelected()).I_method_decd82b5();
      this.Ii_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.crop_farm.auto_deposit", () -> !this.isSelected()).I_method_decd82b5();
      this.iI_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.crop_farm.target_esp", () -> !this.isSelected()).I_method_decd82b5();
      this.II_field_73178e8c = new SliderSetting(var1, "modules.settings.crop_farm.action_delay", () -> !this.isSelected())
         .II_method_b0f56334(10.0F)
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(500.0F)
         .Ii_method_4e0e6b54(80.0F)
         .I_method_d41e7abf("ms");
   }

   @Override
   public void I_method_a0f53e1f() {
      if (I_field_3a9bda27.player == null || I_field_3a9bda27.world == null) {
         this.iI_method_8024b102();
      } else if (!iiIiIiIii_Class428.I_method_b0496283()) {
         this.I_method_cac07269("modules.crop_farm.newton_missing");
         this.iI_method_8024b102();
      } else {
         this.II_method_e19a58c2();
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.I_field_9206be87;
      }
   }

   @Override
   public void i_method_a103c9ff() {
      this.IIIi_method_e654a842();
      this.II_method_e19a58c2();
      this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.IiI_field_9206be87;
   }

   @Override
   public IIiIIIIIi_Class66 I_method_57286715() {
      return switch (this.I_field_9206be87) {
         case I_field_9206be87, IiI_field_9206be87 -> IIiIIIIIi_Class66.I_field_e6af4a4c;
         case i_field_9206be87, ii_field_9206be87 -> IIiIIIIIi_Class66.II_field_e6af4a4c;
         case II_field_9206be87 -> IIiIIIIIi_Class66.i_field_e6af4a4c;
         case Ii_field_9206be87 -> IIiIIIIIi_Class66.Ii_field_e6af4a4c;
         case iI_field_9206be87 -> IIiIIIIIi_Class66.ii_field_e6af4a4c;
         case III_field_9206be87, IIi_field_9206be87 -> IIiIIIIIi_Class66.III_field_e6af4a4c;
      };
   }

   @Override
   public ItemStack I_method_907017b9() {
      Item var1 = this.I_method_799a73b5();
      return new ItemStack(var1 == null ? Items.WHEAT : var1);
   }

   private void II_method_e19a58c2() {
      this.I_field_7865b31.clear();
      this.i_field_7865b31.clear();
      this.I_field_a567c40b.clear();
      this.II_field_7865b31.clear();
      this.I_field_a56a8dc5.clear();
      this.I_field_670402ba = null;
      this.I_field_e08508f9 = null;
      this.i_field_670402ba = null;
      this.i_field_49 = -1;
      this.II_field_49 = -1;
      this.I_field_5a = false;
      this.IiII_method_1ce13042();
   }

   private void ii_method_e36bd4c2() {
      if (this.i_field_991c1e8c.I_method_58432069(1500L)) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.I_field_9206be87;
      }
   }

   private void III_method_51bfb6df() {
      this.I_field_7865b31.clear();
      this.i_field_7865b31.clear();
      this.I_field_a567c40b.clear();
      this.IIiI_method_e8090c82();
      if (this.I_field_7865b31.isEmpty() && this.i_field_7865b31.isEmpty()) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.IiI_field_9206be87;
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else {
         this.IIii_method_e8179862();
         this.iII_method_885acabf();
      }
   }

   private void IIi_method_51ce42bf() {
      if (this.I_field_670402ba == null || !this.i_method_a39f721d(this.I_field_670402ba)) {
         this.IIIi_method_e654a842();
         this.iII_method_885acabf();
      } else if (this.ii_method_42d5f3c0(this.I_field_670402ba)) {
         this.IIIi_method_e654a842();
         this.I_field_9206be87 = this.Ii_method_22b70ba0(this.I_field_670402ba)
            ? IIIiiiIiI_Class59.Nested1_b8341800.II_field_9206be87
            : IIIiiiIiI_Class59.Nested1_b8341800.Ii_field_9206be87;
         this.IiII_method_1ce13042();
         this.I_field_991c1e8c.I_method_23e11e3f();
      } else if (!this.I_field_5a) {
         int var1 = this.I_field_a567c40b.getOrDefault(this.I_field_670402ba, 0);
         if (var1 >= 3) {
            this.iII_method_885acabf();
         } else {
            BlockPos var2 = this.I_method_2292ad37(this.I_field_670402ba);
            if (var2 == null) {
               this.I_field_a567c40b.put(this.I_field_670402ba, 3);
               this.iII_method_885acabf();
            } else {
               iiIiIiIii_Class428.I_method_483e9b95().I_method_1e95cc67(new iiiIIiiII_Class461(var2, 1));
               this.I_field_a567c40b.put(this.I_field_670402ba, var1 + 1);
               this.I_field_5a = true;
               this.I_field_4a = System.currentTimeMillis();
            }
         }
      } else if (!iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
         this.I_field_5a = false;
      } else {
         if (System.currentTimeMillis() - this.I_field_4a > 20000L) {
            this.IIIi_method_e654a842();
            this.iII_method_885acabf();
         }
      }
   }

   private void IiI_method_5382a6ff() {
      if (this.I_field_670402ba == null) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.I_field_9206be87;
      } else if (!this.Ii_method_22b70ba0(this.I_field_670402ba)) {
         BlockState var3 = I_field_3a9bda27.world.getBlockState(this.I_field_670402ba);
         if (var3.isAir() && this.I_field_ba20ca4c.i_method_9b12da03() && this.iI_method_18825fe0(this.I_field_670402ba)) {
            this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.Ii_field_9206be87;
            this.IiII_method_1ce13042();
            this.I_field_991c1e8c.I_method_23e11e3f();
         } else {
            this.iII_method_885acabf();
         }
      } else if (!this.ii_method_42d5f3c0(this.I_field_670402ba)) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.i_field_9206be87;
         this.I_field_5a = false;
      } else {
         if (this.i_field_ba20ca4c.i_method_9b12da03()) {
            this.I_method_b7a434(I_field_3a9bda27.world.getBlockState(this.I_field_670402ba));
         }

         Direction var1 = this.I_method_f14a5259(this.I_field_670402ba);
         Vec3d var2 = this.I_method_76c641d1(this.I_field_670402ba, var1);
         if (this.I_method_6a08ef2f(var2)) {
            if (this.I_field_991c1e8c.I_method_58432069((long)this.II_field_73178e8c.Ii_method_a20abcd2())) {
               I_field_3a9bda27.interactionManager.attackBlock(this.I_field_670402ba, var1);
               I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(this.I_field_670402ba, var1);
               I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void Iii_method_539132df() {
      if (this.I_field_670402ba == null) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.I_field_9206be87;
      } else {
         BlockState var1 = I_field_3a9bda27.world.getBlockState(this.I_field_670402ba);
         if (!var1.isAir()) {
            this.iII_method_885acabf();
         } else if (!this.iI_method_18825fe0(this.I_field_670402ba)) {
            this.iII_method_885acabf();
         } else {
            Item var2 = this.I_method_799a73b5();
            if (var2 == null || !this.I_method_9863b5eb(var2)) {
               this.iII_method_885acabf();
            } else if (!this.ii_method_42d5f3c0(this.I_field_670402ba)) {
               this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.i_field_9206be87;
               this.I_field_5a = false;
            } else {
               BlockPos var3 = this.I_field_670402ba.down();
               Vec3d var4 = new Vec3d(var3.getX() + 0.5, var3.getY() + 1.0, var3.getZ() + 0.5);
               if (this.I_method_6a08ef2f(var4)) {
                  if (this.I_field_991c1e8c.I_method_58432069((long)this.II_field_73178e8c.Ii_method_a20abcd2())) {
                     BlockHitResult var5 = new BlockHitResult(var4, Direction.UP, var3, false);
                     I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var5);
                     I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                     this.I_field_991c1e8c.I_method_23e11e3f();
                     this.iII_method_885acabf();
                  }
               }
            }
         }
      }
   }

   private void iII_method_885acabf() {
      this.I_field_a567c40b.remove(this.I_field_670402ba);
      this.I_field_670402ba = null;
      if (this.I_method_f6c26e83()) {
         this.IiIi_method_1cefbc22();
      } else {
         Vec3d var1 = I_field_3a9bda27.player.getPos();
         int var2 = -1;
         boolean var3 = false;
         double var4 = Double.MAX_VALUE;

         for (int var6 = 0; var6 < this.I_field_7865b31.size(); var6++) {
            BlockPos var7 = this.I_field_7865b31.get(var6);
            if (this.Ii_method_22b70ba0(var7)) {
               double var8 = Vec3d.ofCenter(var7).squaredDistanceTo(var1);
               if (var8 < var4) {
                  var4 = var8;
                  var2 = var6;
                  var3 = false;
               }
            }
         }

         for (int var10 = 0; var10 < this.i_field_7865b31.size(); var10++) {
            BlockPos var11 = this.i_field_7865b31.get(var10);
            if (this.I_method_794bde3d(var11)) {
               double var12 = Vec3d.ofCenter(var11).squaredDistanceTo(var1);
               if (var12 < var4) {
                  var4 = var12;
                  var2 = var10;
                  var3 = true;
               }
            }
         }

         if (var2 >= 0) {
            this.I_field_670402ba = var3 ? this.i_field_7865b31.remove(var2) : this.I_field_7865b31.remove(var2);
         } else {
            this.I_field_7865b31.clear();
            this.i_field_7865b31.clear();
         }

         if (this.I_field_670402ba == null) {
            this.iIi_method_8869569f();
         } else {
            this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.i_field_9206be87;
            this.I_field_5a = false;
            this.IiII_method_1ce13042();
         }
      }
   }

   private boolean I_method_794bde3d(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      return var2.isAir() && this.iI_method_18825fe0(var1);
   }

   private boolean i_method_a39f721d(BlockPos var1) {
      return this.Ii_method_22b70ba0(var1) || this.I_method_794bde3d(var1);
   }

   private void iIi_method_8869569f() {
      this.I_field_5a = false;
      this.IiII_method_1ce13042();
      if (!this.II_field_ba20ca4c.i_method_9b12da03()) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.IiI_field_9206be87;
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else {
         this.IIII_method_e6461c62();
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.iI_field_9206be87;
         this.iiI_method_8a1dbadf();
      }
   }

   private void iiI_method_8a1dbadf() {
      this.I_field_e08508f9 = null;
      this.I_field_5a = false;
      if (this.I_method_f6c26e83()) {
         this.IiIi_method_1cefbc22();
      } else {
         while (!this.II_field_7865b31.isEmpty()) {
            ItemEntity var1 = this.II_field_7865b31.removeFirst();
            if (var1 != null && !var1.isRemoved() && var1.isAlive()) {
               this.I_field_e08508f9 = var1;
               return;
            }
         }

         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.IiI_field_9206be87;
         this.i_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void iii_method_8a2c46bf() {
      if (this.I_field_e08508f9 == null) {
         this.iiI_method_8a1dbadf();
      } else if (!this.I_field_e08508f9.isRemoved() && this.I_field_e08508f9.isAlive()) {
         Vec3d var1 = this.I_field_e08508f9.getPos();
         if (I_field_3a9bda27.player.getPos().squaredDistanceTo(var1) <= 1.9599999999999997) {
            this.IIIi_method_e654a842();
            this.iiI_method_8a1dbadf();
         } else if (!this.I_field_5a) {
            iiIiIiIii_Class428.I_method_483e9b95().I_method_1e95cc67(new iiiIIiiII_Class461(BlockPos.ofFloored(var1), 1));
            this.I_field_5a = true;
            this.I_field_4a = System.currentTimeMillis();
         } else if (!iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
            this.I_field_5a = false;
         } else {
            if (System.currentTimeMillis() - this.I_field_4a > 10000L) {
               this.IIIi_method_e654a842();
               this.iiI_method_8a1dbadf();
            }
         }
      } else {
         this.IIIi_method_e654a842();
         this.iiI_method_8a1dbadf();
      }
   }

   private void IIII_method_e6461c62() {
      this.II_field_7865b31.clear();
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         Vec3d var1 = I_field_3a9bda27.player.getPos();
         double var2 = this.I_field_73178e8c.Ii_method_a20abcd2() + 4.0F;
         double var4 = var2 * var2;
         ArrayList var6 = new ArrayList();

         for (Entity var8 : I_field_3a9bda27.world.getEntities()) {
            if (var8 instanceof ItemEntity var9
               && !var9.isRemoved()
               && var9.isAlive()
               && !(var1.squaredDistanceTo(var9.getPos()) > var4)
               && this.I_method_e9ce5fa5(var9.getStack())) {
               var6.add(var9);
            }
         }

         var6.sort(Comparator.comparingDouble(var1x -> var1.squaredDistanceTo(((net.minecraft.entity.Entity)var1x).getPos())));
         this.II_field_7865b31.addAll(var6);
      }
   }

   private boolean I_method_e9ce5fa5(ItemStack var1) {
      Item var2 = var1.getItem();
      if (this.I_field_500d0627.isSelected()) {
         return var2 == Items.NETHER_WART;
      } else if (this.i_field_500d0627.isSelected()) {
         return var2 == Items.WHEAT || var2 == Items.WHEAT_SEEDS;
      } else if (this.II_field_500d0627.isSelected()) {
         return var2 == Items.CARROT;
      } else if (this.Ii_field_500d0627.isSelected()) {
         return var2 == Items.POTATO || var2 == Items.POISONOUS_POTATO;
      } else if (!this.iI_field_500d0627.isSelected()) {
         return this.ii_field_500d0627.isSelected() ? var2 == Items.SUGAR_CANE : false;
      } else {
         return var2 == Items.BEETROOT || var2 == Items.BEETROOT_SEEDS;
      }
   }

   private void IIIi_method_e654a842() {
      if (iiIiIiIii_Class428.I_method_b0496283() && iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
         iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa5f();
      }

      this.I_field_5a = false;
   }

   private void IIiI_method_e8090c82() {
      BlockPos var1 = I_field_3a9bda27.player.getBlockPos();
      int var2 = (int)this.I_field_73178e8c.Ii_method_a20abcd2();
      int var3 = (int)this.i_field_73178e8c.Ii_method_a20abcd2();
      Predicate var4 = this.I_method_b9c62b86();
      boolean var5 = this.I_field_ba20ca4c.i_method_9b12da03() && !this.ii_field_500d0627.isSelected();

      for (int var6 = -var3; var6 <= var3; var6++) {
         for (int var7 = -var2; var7 <= var2; var7++) {
            for (int var8 = -var2; var8 <= var2; var8++) {
               BlockPos var9 = var1.add(var7, var6, var8);
               BlockState var10 = I_field_3a9bda27.world.getBlockState(var9);
               if (var4.test(var10) && this.I_method_1883abf2(var9, var10)) {
                  this.I_field_7865b31.add(var9.toImmutable());
               } else if (var5 && var10.isAir() && this.iI_method_18825fe0(var9)) {
                  this.i_field_7865b31.add(var9.toImmutable());
               }
            }
         }
      }
   }

   private void IIii_method_e8179862() {
      if (!this.I_field_7865b31.isEmpty()) {
         int var1 = this.I_method_bea4357(this.I_field_7865b31, true);
         int var2 = this.I_method_bea4357(this.I_field_7865b31, false);
         boolean var3 = var1 >= var2;
         Comparator var4 = var3 ? Comparator.comparingInt(Vec3i::getZ) : Comparator.comparingInt(Vec3i::getX);
         Comparator var5 = var3 ? Comparator.comparingInt(Vec3i::getX) : Comparator.comparingInt(Vec3i::getZ);
         this.I_field_7865b31.sort(var4.thenComparingInt(value -> ((Vec3i)value).getY()).thenComparing(var5));
         ArrayList var6 = new ArrayList(this.I_field_7865b31.size());
         int var7 = 0;
         int var8 = 0;

         while (var7 < this.I_field_7865b31.size()) {
            int var9 = var3 ? this.I_field_7865b31.get(var7).getZ() : this.I_field_7865b31.get(var7).getX();
            int var10 = this.I_field_7865b31.get(var7).getY();

            int var11;
            for (var11 = var7; var11 < this.I_field_7865b31.size(); var11++) {
               BlockPos var12 = this.I_field_7865b31.get(var11);
               int var13 = var3 ? var12.getZ() : var12.getX();
               if (var13 != var9 || var12.getY() != var10) {
                  break;
               }
            }

            ArrayList var14 = new ArrayList<>(this.I_field_7865b31.subList(var7, var11));
            if ((var8 & 1) == 1) {
               Collections.reverse(var14);
            }

            var6.addAll(var14);
            var8++;
            var7 = var11;
         }

         this.I_field_7865b31.clear();
         this.I_field_7865b31.addAll(var6);
      }
   }

   private int I_method_bea4357(List<BlockPos> var1, boolean var2) {
      HashMap var3 = new HashMap();

      for (BlockPos var5 : var1) {
         int var6 = var2 ? var5.getZ() : var5.getX();
         var3.merge(var6, 1, (left, right) -> (Integer)left + (Integer)right);
      }

      int var7 = 0;

      for (int var9 : (Iterable<Integer>)(Iterable<?>)var3.values()) {
         if (var9 > var7) {
            var7 = var9;
         }
      }

      return var7;
   }

   private BlockPos I_method_2292ad37(BlockPos var1) {
      Direction[] var2 = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
      BlockPos var3 = null;
      Vec3d var4 = I_field_3a9bda27.player.getPos();
      double var5 = Double.MAX_VALUE;

      for (Direction var10 : var2) {
         BlockPos var11 = var1.offset(var10);
         if (this.II_method_f86377c0(var11)) {
            double var12 = Vec3d.ofCenter(var11).squaredDistanceTo(var4);
            if (var12 < var5) {
               var5 = var12;
               var3 = var11;
            }
         }
      }

      return var3;
   }

   private boolean II_method_f86377c0(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1.down());
      BlockState var3 = I_field_3a9bda27.world.getBlockState(var1);
      BlockState var4 = I_field_3a9bda27.world.getBlockState(var1.up());
      if (var2.isAir()) {
         return false;
      } else {
         return !var3.getCollisionShape(I_field_3a9bda27.world, var1).isEmpty() ? false : var4.getCollisionShape(I_field_3a9bda27.world, var1.up()).isEmpty();
      }
   }

   private Predicate<BlockState> I_method_b9c62b86() {
      if (this.I_field_500d0627.isSelected()) {
         return var0 -> var0.getBlock() == Blocks.NETHER_WART;
      } else if (this.i_field_500d0627.isSelected()) {
         return var0 -> var0.getBlock() == Blocks.WHEAT;
      } else if (this.II_field_500d0627.isSelected()) {
         return var0 -> var0.getBlock() == Blocks.CARROTS;
      } else if (this.Ii_field_500d0627.isSelected()) {
         return var0 -> var0.getBlock() == Blocks.POTATOES;
      } else if (this.iI_field_500d0627.isSelected()) {
         return var0 -> var0.getBlock() == Blocks.BEETROOTS;
      } else {
         return this.ii_field_500d0627.isSelected() ? var0 -> var0.getBlock() == Blocks.SUGAR_CANE : var0 -> false;
      }
   }

   private boolean Ii_method_22b70ba0(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      return this.I_method_b9c62b86().test(var2) && this.I_method_1883abf2(var1, var2);
   }

   private boolean I_method_1883abf2(BlockPos var1, BlockState var2) {
      Block var3 = var2.getBlock();
      if (var3 instanceof CropBlock var4) {
         return var4.isMature(var2);
      } else if (var3 == Blocks.NETHER_WART) {
         return (Integer)var2.get(NetherWartBlock.AGE) >= 3;
      } else {
         return var3 == Blocks.SUGAR_CANE ? I_field_3a9bda27.world.getBlockState(var1.down()).getBlock() == Blocks.SUGAR_CANE : false;
      }
   }

   private boolean iI_method_18825fe0(BlockPos var1) {
      if (this.ii_field_500d0627.isSelected()) {
         return false;
      } else {
         Block var2 = I_field_3a9bda27.world.getBlockState(var1.down()).getBlock();
         return this.I_field_500d0627.isSelected() ? var2 == Blocks.SOUL_SAND : var2 == Blocks.FARMLAND;
      }
   }

   private Item I_method_799a73b5() {
      if (this.I_field_500d0627.isSelected()) {
         return Items.NETHER_WART;
      } else if (this.i_field_500d0627.isSelected()) {
         return Items.WHEAT_SEEDS;
      } else if (this.II_field_500d0627.isSelected()) {
         return Items.CARROT;
      } else if (this.Ii_field_500d0627.isSelected()) {
         return Items.POTATO;
      } else if (this.iI_field_500d0627.isSelected()) {
         return Items.BEETROOT_SEEDS;
      } else {
         return this.ii_field_500d0627.isSelected() ? Items.SUGAR_CANE : null;
      }
   }

   private boolean ii_method_42d5f3c0(BlockPos var1) {
      double var2 = I_field_3a9bda27.player.getBlockInteractionRange();
      return I_field_3a9bda27.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) <= var2 * var2;
   }

   private Direction I_method_f14a5259(BlockPos var1) {
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      Vec3d var3 = Vec3d.ofCenter(var1);
      double var4 = var2.x - var3.x;
      double var6 = var2.y - var3.y;
      double var8 = var2.z - var3.z;
      double var10 = Math.abs(var4);
      double var12 = Math.abs(var6);
      double var14 = Math.abs(var8);
      if (var12 >= var10 && var12 >= var14) {
         return var6 >= 0.0 ? Direction.UP : Direction.DOWN;
      } else if (var10 >= var14) {
         return var4 >= 0.0 ? Direction.EAST : Direction.WEST;
      } else {
         return var8 >= 0.0 ? Direction.SOUTH : Direction.NORTH;
      }
   }

   private Vec3d I_method_76c641d1(BlockPos var1, Direction var2) {
      return Vec3d.ofCenter(var1).add(var2.getOffsetX() * 0.5, var2.getOffsetY() * 0.5, var2.getOffsetZ() * 0.5);
   }

   private boolean I_method_6a08ef2f(Vec3d var1) {
      iiIIiIIii_Class404 var2 = iiIIiIiIi_Class406.I_method_bc8095a1(var1);
      if (this.I_field_32e13e6c == null || this.I_field_32e13e6c.I_method_24e31c97(var2) > 0.5F) {
         this.I_field_32e13e6c = var2;
         this.Ii_field_49 = 0;
      }

      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(var2, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
      iiIIiIIii_Class404 var3 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      if (var3 != null && var3.I_method_24e31c97(var2) <= 1.5F) {
         this.Ii_field_49++;
         return this.Ii_field_49 >= 1;
      } else {
         return false;
      }
   }

   private void IiII_method_1ce13042() {
      this.I_field_32e13e6c = null;
      this.Ii_field_49 = 0;
   }

   private void I_method_b7a434(BlockState var1) {
      Predicate<ItemStack> var2 = var0 -> var0.getItem() instanceof HoeItem && i_method_8dc6e385(var0);
      this.I_method_d4db2b47(var1, var2);
   }

   private boolean I_method_d4db2b47(BlockState var1, Predicate<ItemStack> var2) {
      ItemStack var3 = I_field_3a9bda27.player.getMainHandStack();
      IIIiiiIiI_Class59.Nested1_b8341820 var4 = this.I_method_aa845276(var3, var1, var2);
      iIIiIiIii_Class300 var5 = null;

      for (iIIiIiIii_Class300 var7 : iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_617d3e68()) {
         ItemStack var8 = var7.I_method_7b7e0bb9();
         IIIiiiIiI_Class59.Nested1_b8341820 var9 = this.I_method_aa845276(var8, var1, var2);
         if (var9.I_method_2969aecb(var4)) {
            var4 = var9;
            var5 = var7;
         }
      }

      if (!var4.I_method_75dfff9e()) {
         return false;
      } else {
         if (var5 instanceof iIIiiiIii_Class316 var10) {
            iIIiIiIiI_Class299.I_method_4c2ca067(var10);
         } else if (var5 instanceof iIIiiiiII_Class317 var11) {
            int var12 = I_field_3a9bda27.player.getInventory().selectedSlot;
            iIIiIiIiI_Class299.iI_method_c617e8c2(var11.I_method_dfe89252(), var12);
         }

         return true;
      }
   }

   private IIIiiiIiI_Class59.Nested1_b8341820 I_method_aa845276(ItemStack var1, BlockState var2, Predicate<ItemStack> var3) {
      if (var1 != null && !var1.isEmpty() && var3.test(var1)) {
         float var4 = var1.getMiningSpeedMultiplier(var2);
         int var5 = iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.EFFICIENCY);
         int var6 = iIIiIiIIi_Class298.I_method_7ea237bf(var1, Enchantments.FORTUNE);
         float var7 = I_method_e9ce5f91(var1);
         return new IIIiiiIiI_Class59.Nested1_b8341820(var4, var5, var6, var7);
      } else {
         return new IIIiiiIiI_Class59.Nested1_b8341820(-1.0F, -1, -1, -1.0F);
      }
   }

   private static float I_method_e9ce5f91(ItemStack var0) {
      if (!var0.isEmpty() && var0.isDamageable()) {
         int var1 = var0.getMaxDamage();
         return var1 <= 0 ? 1.0F : (float)(var1 - var0.getDamage()) / var1;
      } else {
         return 1.0F;
      }
   }

   private static boolean i_method_8dc6e385(ItemStack var0) {
      return I_method_e9ce5f91(var0) > 0.05F;
   }

   private boolean I_method_f6c26e83() {
      if (!this.Ii_field_ba20ca4c.i_method_9b12da03()) {
         return false;
      } else if (I_field_3a9bda27.player == null) {
         return false;
      } else {
         PlayerInventory var1 = I_field_3a9bda27.player.getInventory();
         return var1.getEmptySlot() != -1 ? false : this.i_method_f6d0fa63();
      }
   }

   private boolean i_method_f6d0fa63() {
      Item var1 = this.I_method_799a73b5();
      PlayerInventory var2 = I_field_3a9bda27.player.getInventory();
      int var3 = 0;

      for (int var4 = 0; var4 < var2.size(); var4++) {
         ItemStack var5 = var2.getStack(var4);
         if (!var5.isEmpty() && this.I_method_e9ce5fa5(var5)) {
            if (var1 == null || var5.getItem() != var1) {
               return true;
            }

            var3 += var5.getCount();
         }
      }

      return var3 > this.I_method_f6c26e72();
   }

   private int I_method_f6c26e72() {
      Item var1 = this.I_method_799a73b5();
      return var1 != null ? var1.getDefaultStack().getMaxCount() : 64;
   }

   private void IiIi_method_1cefbc22() {
      this.IIIi_method_e654a842();
      this.IiII_method_1ce13042();
      this.I_field_5a = false;
      this.i_field_49 = -1;
      this.II_field_49 = -1;
      BlockPos var1 = this.I_method_40ddbdb1();
      if (var1 == null) {
         this.i_method_9b77c649("modules.crop_farm.no_chest");
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.IiI_field_9206be87;
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else {
         this.i_field_670402ba = var1;
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.ii_field_9206be87;
      }
   }

   private BlockPos I_method_40ddbdb1() {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         BlockPos var1 = I_field_3a9bda27.player.getBlockPos();
         int var2 = (int)this.I_field_73178e8c.Ii_method_a20abcd2() + 4;
         BlockPos var3 = null;
         double var4 = Double.MAX_VALUE;

         for (BlockPos var7 : BlockPos.iterateOutwards(var1, var2, var2, var2)) {
            BlockPos var8 = var7.toImmutable();
            if (!this.I_field_a56a8dc5.contains(var8) && I_field_3a9bda27.world.getBlockEntity(var8) instanceof ChestBlockEntity) {
               double var9 = var7.getSquaredDistance(I_field_3a9bda27.player.getPos());
               if (var9 < var4) {
                  var4 = var9;
                  var3 = var8;
               }
            }
         }

         return var3;
      } else {
         return null;
      }
   }

   private void IiiI_method_1ea42062() {
      if (this.i_field_670402ba == null) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.I_field_9206be87;
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else if (this.ii_method_42d5f3c0(this.i_field_670402ba)) {
         this.IIIi_method_e654a842();
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.III_field_9206be87;
         this.IiII_method_1ce13042();
         this.I_field_991c1e8c.I_method_23e11e3f();
      } else if (!this.I_field_5a) {
         iiIiIiIii_Class428.I_method_483e9b95().I_method_1e95cc67(new iiiIIiiII_Class461(this.i_field_670402ba, 2));
         this.I_field_5a = true;
         this.I_field_4a = System.currentTimeMillis();
      } else if (!iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63()) {
         this.I_field_5a = false;
      } else {
         if (System.currentTimeMillis() - this.I_field_4a > 20000L) {
            this.IIIi_method_e654a842();
            this.I_field_a56a8dc5.add(this.i_field_670402ba);
            this.i_field_670402ba = null;
            this.IiIi_method_1cefbc22();
         }
      }
   }

   private void Iiii_method_1eb2ac42() {
      if (this.i_field_670402ba == null) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.I_field_9206be87;
         this.i_field_991c1e8c.I_method_23e11e3f();
      } else if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.IIi_field_9206be87;
         this.I_field_991c1e8c.I_method_23e11e3f();
         this.i_field_49 = -1;
         this.II_field_49 = -1;
      } else if (!this.ii_method_42d5f3c0(this.i_field_670402ba)) {
         this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.ii_field_9206be87;
         this.I_field_5a = false;
      } else {
         Vec3d var1 = Vec3d.ofCenter(this.i_field_670402ba);
         if (this.I_method_6a08ef2f(var1)) {
            if (this.I_field_991c1e8c.I_method_58432069((long)this.II_field_73178e8c.Ii_method_a20abcd2())) {
               BlockHitResult var2 = new BlockHitResult(var1, Direction.UP, this.i_field_670402ba, false);
               I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var2);
               I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void iIII_method_830d8482() {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1) {
         if (this.I_field_991c1e8c.I_method_58432069((long)this.II_field_73178e8c.Ii_method_a20abcd2())) {
            if (this.i_field_49 != -1) {
               ItemStack var7 = ((Slot)var1.slots.get(this.i_field_49)).getStack();
               if (!var7.isEmpty() && var7.getCount() >= this.II_field_49 && this.I_method_e9ce5fa5(var7)) {
                  this.iIIi_method_831c1062();
                  return;
               }
            }

            int var8 = this.i_method_f6d0fa52();
            DefaultedList var3 = var1.slots;

            for (int var4 = 0; var4 < var3.size(); var4++) {
               Slot var5 = (Slot)var3.get(var4);
               if (var5.inventory == I_field_3a9bda27.player.getInventory() && var5.getIndex() != var8) {
                  ItemStack var6 = var5.getStack();
                  if (!var6.isEmpty() && this.I_method_e9ce5fa5(var6)) {
                     iIIiIiIiI_Class299.I_method_8062c464(var4);
                     this.i_field_49 = var4;
                     this.II_field_49 = var6.getCount();
                     this.I_field_991c1e8c.I_method_23e11e3f();
                     return;
                  }
               }
            }

            this.I_method_e18c1435(true);
         }
      } else {
         this.I_method_e18c1435(false);
      }
   }

   private void iIIi_method_831c1062() {
      if (this.i_field_670402ba != null) {
         this.I_field_a56a8dc5.add(this.i_field_670402ba);
      }

      I_field_3a9bda27.player.closeHandledScreen();
      this.i_field_670402ba = null;
      this.i_field_49 = -1;
      this.II_field_49 = -1;
      this.IiIi_method_1cefbc22();
   }

   private void I_method_e18c1435(boolean var1) {
      if (var1 && I_field_3a9bda27.currentScreen != null) {
         I_field_3a9bda27.player.closeHandledScreen();
      }

      this.i_field_670402ba = null;
      this.i_field_49 = -1;
      this.II_field_49 = -1;
      this.I_field_9206be87 = IIIiiiIiI_Class59.Nested1_b8341800.I_field_9206be87;
      this.i_field_991c1e8c.I_method_23e11e3f();
      this.I_field_5a = false;
      this.IiII_method_1ce13042();
   }

   private int i_method_f6d0fa52() {
      Item var1 = this.I_method_799a73b5();
      if (var1 == null) {
         return -1;
      } else {
         PlayerInventory var2 = I_field_3a9bda27.player.getInventory();
         int var3 = -1;
         int var4 = -1;

         for (int var5 = 0; var5 < var2.size(); var5++) {
            ItemStack var6 = var2.getStack(var5);
            if (!var6.isEmpty() && var6.getItem() == var1 && var6.getCount() > var4) {
               var4 = var6.getCount();
               var3 = var5;
            }
         }

         return var3;
      }
   }

   private Box I_method_42e4f74d(BlockPos var1) {
      return new Box(var1).contract(0.02);
   }

   private boolean I_method_9863b5eb(Item var1) {
      if (I_field_3a9bda27.player.getMainHandStack().getItem() == var1) {
         return true;
      } else {
         Predicate<ItemStack> var2 = var1x -> var1x.getItem() == var1;
         iIIiiiIii_Class316 var3 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(var2);
         if (var3 != null) {
            iIIiIiIiI_Class299.I_method_4c2ca067(var3);
            return true;
         } else {
            iIIiiiiII_Class317 var4 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(var2);
            if (var4 != null) {
               int var5 = I_field_3a9bda27.player.getInventory().selectedSlot;
               iIIiIiIiI_Class299.iI_method_c617e8c2(var4.I_method_dfe89252(), var5);
               return true;
            } else {
               return false;
            }
         }
      }
   }

   static enum Nested1_b8341800 {
      I_field_9206be87,
      i_field_9206be87,
      II_field_9206be87,
      Ii_field_9206be87,
      iI_field_9206be87,
      ii_field_9206be87,
      III_field_9206be87,
      IIi_field_9206be87,
      IiI_field_9206be87;
   }

   static final class Nested1_b8341820 {
      private final float I_field_46;
      private final int I_field_49;
      private final int i_field_49;
      private final float i_field_46;

      Nested1_b8341820(float var1, int var2, int var3, float var4) {
         this.I_field_46 = var1;
         this.I_field_49 = var2;
         this.i_field_49 = var3;
         this.i_field_46 = var4;
      }

      boolean I_method_75dfff9e() {
         return this.I_field_46 >= 0.0F;
      }

      boolean I_method_2969aecb(IIIiiiIiI_Class59.Nested1_b8341820 var1) {
         if (this.i_field_49 != var1.i_field_49) {
            return this.i_field_49 > var1.i_field_49;
         } else if (this.I_field_46 != var1.I_field_46) {
            return this.I_field_46 > var1.I_field_46;
         } else {
            return this.I_field_49 != var1.I_field_49 ? this.I_field_49 > var1.I_field_49 : this.i_field_46 > var1.i_field_46;
         }
      }

      @Override
      public final String toString() {
         return "Nested1_b8341820[miningSpeed=" + this.I_field_46 + ", efficiency=" + this.I_field_49 + ", fortune=" + this.i_field_49 + ", durability=" + this.i_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiiiIiI_Class59.Nested1_b8341820 other = (IIIiiiIiI_Class59.Nested1_b8341820) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46);
      }

      public float I_method_75dfff8a() {
         return this.I_field_46;
      }

      public int I_method_75dfff8d() {
         return this.I_field_49;
      }

      public int i_method_75ee8b6d() {
         return this.i_field_49;
      }

      public float i_method_75ee8b6a() {
         return this.i_field_46;
      }
   }
}
