package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.screen.ingame.BrewingStandScreen;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.BrewingStandScreenHandler;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

public class IIIiiiiii_Class64 extends IIIiiiIii_Class60 {
   private final ModeSetting I_field_bbe33e6c;
   private final ModeSetting.Nested1_42765c60 I_field_500d0627;
   private final ModeSetting.Nested1_42765c60 i_field_500d0627;
   private final ModeSetting.Nested1_42765c60 II_field_500d0627;
   private final ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private final ModeSetting.Nested1_42765c60 iI_field_500d0627;
   private final ModeSetting.Nested1_42765c60 ii_field_500d0627;
   private final ModeSetting.Nested1_42765c60 III_field_500d0627;
   private final ModeSetting i_field_bbe33e6c;
   private final ModeSetting.Nested1_42765c60 IIi_field_500d0627;
   private final ModeSetting.Nested1_42765c60 IiI_field_500d0627;
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private static final int I_field_49 = 5;
   private static final int i_field_49 = 8;
   private static final int II_field_49 = 400;
   private static final float I_field_46 = 1.5F;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private final iiIiIIiii_Class424 II_field_991c1e8c = new iiIiIIiii_Class424();
   private IIIiiiiii_Class64.Nested1_b9f78040 I_field_c8b05e47;
   private BlockPos I_field_670402ba;
   private BlockPos i_field_670402ba;
   private final List<BlockPos> I_field_7865b31;
   private final Map<BlockPos, Long> I_field_a567c40b;
   private final Map<Item, BlockPos> i_field_a567c40b;
   private final Set<BlockPos> I_field_a56a8dc5;
   private Item I_field_3c05b08c;
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private int Ii_field_49;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;
   private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(99.0F, 196.0F, 255.0F);
   private static final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(255.0F, 196.0F, 64.0F);
   private final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41;

   public IIIiiiiii_Class64(AutoFarmModule var1, ModeSetting var2) {
      super(var1, var2, "modules.settings.auto_farm.modes.potion");
      this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.I_field_c8b05e47;
      this.I_field_7865b31 = new ArrayList<>();
      this.I_field_a567c40b = new HashMap<>();
      this.i_field_a567c40b = new HashMap<>();
      this.I_field_a56a8dc5 = new HashSet<>();
      this.I_field_3d936f41 = var1x -> {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            switch (this.I_field_c8b05e47) {
               case I_field_c8b05e47:
                  this.ii_method_8c11d02();
                  break;
               case i_field_c8b05e47:
                  this.III_method_d713769f();
                  break;
               case II_field_c8b05e47:
                  this.IIi_method_d722027f();
                  break;
               case Ii_field_c8b05e47:
                  this.I_method_6e15c75(true);
                  break;
               case iI_field_c8b05e47:
                  this.IiI_method_d8d666bf();
                  break;
               case ii_field_c8b05e47:
                  this.I_method_6e15c75(false);
                  break;
               case III_field_c8b05e47:
                  this.Iii_method_d8e4f29f();
                  break;
               case IIi_field_c8b05e47:
                  this.iII_method_dae8a7f();
            }
         }
      };
      this.i_field_3d936f41 = var1x -> {
         if (this.II_field_ba20ca4c.i_method_9b12da03()) {
            if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
               BlockPos var2x = this.I_field_c8b05e47 != IIIiiiiii_Class64.Nested1_b9f78040.i_field_c8b05e47
                     && this.I_field_c8b05e47 != IIIiiiiii_Class64.Nested1_b9f78040.II_field_c8b05e47
                  ? null
                  : this.I_field_670402ba;
               BlockPos var3 = this.I_field_c8b05e47 != IIIiiiiii_Class64.Nested1_b9f78040.Ii_field_c8b05e47
                     && this.I_field_c8b05e47 != IIIiiiiii_Class64.Nested1_b9f78040.iI_field_c8b05e47
                     && this.I_field_c8b05e47 != IIIiiiiii_Class64.Nested1_b9f78040.ii_field_c8b05e47
                     && this.I_field_c8b05e47 != IIIiiiiii_Class64.Nested1_b9f78040.III_field_c8b05e47
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
                        var4, var7, this.I_method_ecb0970d(var2x).offset(-var6.x, -var6.y, -var6.z), I_field_d0c8ec5.withAlpha(45.0F)
                     );
                  }

                  if (var3 != null) {
                     iIiiIIiIi_Class358.i_method_5e35f7b9(
                        var4, var7, this.I_method_ecb0970d(var3).offset(-var6.x, -var6.y, -var6.z), i_field_d0c8ec5.withAlpha(45.0F)
                     );
                  }

                  iIiiiIIiI_Class371.I_method_c59155f0(var7);
                  BufferBuilder var8 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
                  if (var2x != null) {
                     iIiiIIiIi_Class358.Ii_method_c1caf816(
                        var4, var8, this.I_method_ecb0970d(var2x).offset(-var6.x, -var6.y, -var6.z), I_field_d0c8ec5.withAlpha(180.0F)
                     );
                  }

                  if (var3 != null) {
                     iIiiIIiIi_Class358.Ii_method_c1caf816(
                        var4, var8, this.I_method_ecb0970d(var3).offset(-var6.x, -var6.y, -var6.z), i_field_d0c8ec5.withAlpha(180.0F)
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
      this.I_field_bbe33e6c = new ModeSetting(var1, "modules.settings.potion_farm.brew", () -> !this.isSelected());
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_farm.potion.strength").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_farm.potion.speed");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_farm.potion.fire_resistance");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_farm.potion.invisibility");
      this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_farm.potion.regen");
      this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_farm.potion.healing");
      this.III_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.potion_farm.potion.strong_healing");
      this.i_field_bbe33e6c = new ModeSetting(var1, "modules.settings.potion_farm.stack_mode", () -> !this.isSelected());
      this.IIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.potion_farm.stack_mode.multiple").select();
      this.IiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.potion_farm.stack_mode.single");
      this.I_field_ba20ca4c = new BooleanSetting(
         var1, "modules.settings.potion_farm.enhance", () -> !this.isSelected() || !this.Ii_field_500d0627.isSelected()
      );
      this.i_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.potion_farm.use_chests", () -> !this.isSelected()).I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.potion_farm.target_esp", () -> !this.isSelected()).I_method_decd82b5();
      this.I_field_73178e8c = new SliderSetting(
            var1, "modules.settings.potion_farm.delay", "modules.settings.potion_farm.delay.description", () -> !this.isSelected()
         )
         .II_method_b0f56334(10.0F)
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(1500.0F)
         .Ii_method_4e0e6b54(250.0F);
      this.i_field_73178e8c = new SliderSetting(
            var1,
            "modules.settings.potion_farm.single_stack_delay",
            "modules.settings.potion_farm.single_stack_delay.description",
            () -> !this.isSelected() || !this.IiI_field_500d0627.isSelected()
         )
         .II_method_b0f56334(10.0F)
         .I_method_c8c9a7d7(50.0F)
         .i_method_65e2aff7(2000.0F)
         .Ii_method_4e0e6b54(250.0F);
   }

   @Override
   public void I_method_a0f53e1f() {
      this.II_method_6efa102();
   }

   @Override
   public void i_method_a103c9ff() {
      this.II_method_6efa102();
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.currentScreen instanceof BrewingStandScreen) {
         I_field_3a9bda27.player.closeHandledScreen();
      }
   }

   private void II_method_6efa102() {
      this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.I_field_c8b05e47;
      this.I_field_670402ba = null;
      this.i_field_670402ba = null;
      this.I_field_7865b31.clear();
      this.I_field_a56a8dc5.clear();
      this.I_field_3c05b08c = null;
      this.I_field_991c1e8c.I_method_23e11e3f();
      this.I_field_32e13e6c = null;
      this.Ii_field_49 = 0;
      this.II_field_991c1e8c.I_method_23e11e3f();
   }

   @Override
   public IIiIIIIIi_Class66 I_method_57286715() {
      return switch (this.I_field_c8b05e47) {
         case I_field_c8b05e47, IIi_field_c8b05e47 -> IIiIIIIIi_Class66.I_field_e6af4a4c;
         case i_field_c8b05e47, II_field_c8b05e47 -> IIiIIIIIi_Class66.i_field_e6af4a4c;
         case Ii_field_c8b05e47, iI_field_c8b05e47 -> IIiIIIIIi_Class66.III_field_e6af4a4c;
         case ii_field_c8b05e47, III_field_c8b05e47 -> IIiIIIIIi_Class66.iIi_field_e6af4a4c;
      };
   }

   @Override
   public IIiIIIiII_Class69 I_method_5736ef15() {
      return IIiIIIiII_Class69.i_field_e6bdd24c;
   }

   @Override
   public ItemStack I_method_907017b9() {
      return new ItemStack(Items.POTION);
   }

   private void ii_method_8c11d02() {
      if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
         if (this.I_field_7865b31.isEmpty()) {
            this.I_field_7865b31.addAll(this.I_method_1b888e28());
            if (this.I_field_7865b31.isEmpty()) {
               return;
            }
         }

         long var1 = System.currentTimeMillis();
         BlockPos var3 = null;

         for (BlockPos var5 : this.I_field_7865b31) {
            Long var6 = this.I_field_a567c40b.get(var5);
            if (var6 == null || var6 <= var1) {
               var3 = var5;
               break;
            }
         }

         if (var3 == null) {
            if (this.I_field_991c1e8c.I_method_58432069(2000L)) {
               this.I_field_7865b31.clear();
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         } else {
            this.I_field_7865b31.remove(var3);
            this.I_field_670402ba = var3;
            this.iIi_method_dbd165f();
            this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.i_field_c8b05e47;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void III_method_d713769f() {
      if (this.I_field_670402ba == null) {
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.I_field_c8b05e47;
      } else if (I_field_3a9bda27.currentScreen instanceof BrewingStandScreen) {
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.II_field_c8b05e47;
         this.I_field_991c1e8c.I_method_23e11e3f();
      } else if (!this.i_method_740431dd(this.I_field_670402ba)) {
         this.I_field_a567c40b.put(this.I_field_670402ba, System.currentTimeMillis() + 5000L);
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.I_field_c8b05e47;
      } else if (this.I_method_ff22476f(Vec3d.ofCenter(this.I_field_670402ba))) {
         if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
            this.i_method_740431d9(this.I_field_670402ba);
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void IIi_method_d722027f() {
      if (!(I_field_3a9bda27.player.currentScreenHandler instanceof BrewingStandScreenHandler var1)) {
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.I_field_c8b05e47;
      } else if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2() / 2L)) {
         if (var1.getBrewTime() > 0) {
            long var8 = (long)(var1.getBrewTime() / 20.0 * 1000.0);
            this.I_field_a567c40b.put(this.I_field_670402ba, System.currentTimeMillis() + var8 + 250L);
            this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
            this.I_field_991c1e8c.I_method_23e11e3f();
         } else {
            Potion var7 = this.I_method_7bc11df5();

            for (int var3 = 0; var3 < 3; var3++) {
               ItemStack var4 = var1.getSlot(var3).getStack();
               if (!var4.isEmpty() && this.I_method_352f8849(var4, var7)) {
                  iIIiIiIiI_Class299.I_method_8062c464(var3);
                  this.I_method_18285755().I_method_95f37ca4(Math.max(1, var4.getCount()));
                  this.I_field_991c1e8c.I_method_23e11e3f();
                  return;
               }
            }

            if (var1.getFuel() == 0 && var1.getSlot(4).getStack().isEmpty()) {
               if (!this.I_method_1e13f9c0(Items.BLAZE_POWDER, 4)) {
                  this.I_method_f0743e27(Items.BLAZE_POWDER);
               }
            } else {
               if (this.IiI_field_500d0627.isSelected()) {
                  int[] var9 = new int[3];
                  int var12 = 0;

                  for (int var5 = 0; var5 < 3; var5++) {
                     if (var1.getSlot(var5).getStack().isEmpty()) {
                        var9[var12++] = var5;
                     }
                  }

                  if (var12 > 0) {
                     if (!this.II_field_991c1e8c.I_method_58432069((long)this.i_field_73178e8c.Ii_method_a20abcd2())) {
                        return;
                     }

                     int var14 = this.I_method_f7a3f5a8(var1);
                     if (var14 == -1) {
                        this.I_method_f0743e27(Items.POTION);
                        return;
                     }

                     int[] var6 = new int[var12];
                     System.arraycopy(var9, 0, var6, 0, var12);
                     this.I_method_d32312b2(var14, var6);
                     this.II_field_991c1e8c.I_method_23e11e3f();
                     this.I_field_991c1e8c.I_method_23e11e3f();
                     return;
                  }
               } else {
                  for (int var10 = 0; var10 < 3; var10++) {
                     if (var1.getSlot(var10).getStack().isEmpty()) {
                        int var13 = this.I_method_f7a3f5a8(var1);
                        if (var13 == -1) {
                           this.I_method_f0743e27(Items.POTION);
                           return;
                        }

                        iIIiIiIiI_Class299.I_method_8062c464(var13);
                        this.I_field_991c1e8c.I_method_23e11e3f();
                        return;
                     }
                  }
               }

               if (var1.getSlot(3).getStack().isEmpty()) {
                  Item var11 = this.I_method_824738eb(var1);
                  if (var11 == null) {
                     this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
                     this.I_field_991c1e8c.I_method_23e11e3f();
                     return;
                  }

                  if (!this.I_method_1e13f9c0(var11, 3)) {
                     this.I_method_f0743e27(var11);
                     return;
                  }

                  this.I_field_a567c40b.put(this.I_field_670402ba, System.currentTimeMillis() + 20000L + 500L);
                  this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
                  this.I_field_991c1e8c.I_method_23e11e3f();
               }
            }
         }
      }
   }

   private void I_method_6e15c75(boolean var1) {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof BrewingStandScreenHandler) {
         I_field_3a9bda27.player.closeHandledScreen();
         this.I_field_991c1e8c.I_method_23e11e3f();
      } else {
         if (this.i_field_670402ba == null) {
            this.i_field_670402ba = var1 ? this.i_method_69fc7611() : this.I_method_f50205f1();
            this.iIi_method_dbd165f();
            if (this.i_field_670402ba == null) {
               RockstarClient.getInstance()
                  .I_method_5cb1af22()
                  .I_method_20d0f49b(
                     iiiIIII_Class113.i_field_c11fcfcc,
                     var1 ? IiIiIIII_Class81.I_method_f25a980a("potion_farm.no_chest_title") : IiIiIIII_Class81.I_method_f25a980a("potion_farm.no_item_title"),
                     var1
                        ? IiIiIIII_Class81.I_method_f25a980a("potion_farm.no_chest")
                        : IiIiIIII_Class81.I_method_1410d1e5("potion_farm.no_item", this.I_method_1642e959(this.I_field_3c05b08c))
                  );
               if (!var1) {
                  this.I_field_3c05b08c = null;
               }

               this.I_field_a56a8dc5.clear();
               this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
               this.I_field_991c1e8c.I_method_23e11e3f();
               return;
            }
         }

         if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler) {
            this.I_field_c8b05e47 = var1 ? IIIiiiiii_Class64.Nested1_b9f78040.iI_field_c8b05e47 : IIIiiiiii_Class64.Nested1_b9f78040.III_field_c8b05e47;
            this.I_field_991c1e8c.I_method_23e11e3f();
         } else if (!this.i_method_740431dd(this.i_field_670402ba)) {
            if (var1) {
               this.i_field_670402ba = null;
               this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
            } else {
               this.I_method_49b09df9(this.i_field_670402ba);
               this.i_field_670402ba = null;
               this.iIi_method_dbd165f();
            }
         } else if (this.I_method_ff22476f(Vec3d.ofCenter(this.i_field_670402ba))) {
            if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
               this.i_method_740431d9(this.i_field_670402ba);
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void IiI_method_d8d666bf() {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1) {
         if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
            DefaultedList var6 = var1.slots;

            for (int var3 = 0; var3 < var6.size(); var3++) {
               Slot var4 = (Slot)var6.get(var3);
               if (var4.inventory == I_field_3a9bda27.player.getInventory()) {
                  ItemStack var5 = var4.getStack();
                  if (!var5.isEmpty() && this.I_method_9c08ff65(var5)) {
                     iIIiIiIiI_Class299.I_method_8062c464(var3);
                     this.I_field_991c1e8c.I_method_23e11e3f();
                     return;
                  }
               }
            }

            this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      } else {
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
      }
   }

   private void I_method_f0743e27(Item var1) {
      if (!this.i_field_ba20ca4c.i_method_9b12da03()) {
         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_20d0f49b(
               iiiIIII_Class113.i_field_c11fcfcc,
               IiIiIIII_Class81.I_method_f25a980a("potion_farm.no_item_title"),
               IiIiIIII_Class81.I_method_1410d1e5("potion_farm.no_item", this.I_method_1642e959(var1))
            );
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
      } else {
         this.I_field_3c05b08c = var1;
         this.I_field_a56a8dc5.clear();
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.ii_field_c8b05e47;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private String I_method_1642e959(Item var1) {
      if (var1 == null) {
         return "";
      } else {
         return var1 == Items.POTION ? IiIiIIII_Class81.I_method_f25a980a("potion_farm.item.water_bottle") : var1.getName().getString();
      }
   }

   private void Iii_method_d8e4f29f() {
      if (!(I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1)) {
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
      } else if (this.I_field_3c05b08c == null) {
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
      } else if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
         DefaultedList var6 = var1.slots;

         for (int var3 = 0; var3 < var6.size(); var3++) {
            Slot var4 = (Slot)var6.get(var3);
            if (var4.inventory != I_field_3a9bda27.player.getInventory()) {
               ItemStack var5 = var4.getStack();
               if (!var5.isEmpty() && this.I_method_2e7a8749(var5, this.I_field_3c05b08c)) {
                  iIIiIiIiI_Class299.I_method_8062c464(var3);
                  if (this.i_field_670402ba != null) {
                     this.i_field_a567c40b.put(this.I_field_3c05b08c, this.i_field_670402ba);
                  }

                  this.I_field_3c05b08c = null;
                  this.I_field_a56a8dc5.clear();
                  this.I_field_991c1e8c.I_method_23e11e3f();
                  this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.IIi_field_c8b05e47;
                  return;
               }
            }
         }

         if (this.i_field_670402ba != null) {
            this.I_method_49b09df9(this.i_field_670402ba);
            BlockPos var7 = this.i_field_a567c40b.get(this.I_field_3c05b08c);
            if (this.i_field_670402ba.equals(var7) || this.i_field_670402ba.equals(this.I_method_79d4e577(var7))) {
               this.i_field_a567c40b.remove(this.I_field_3c05b08c);
            }
         }

         I_field_3a9bda27.player.closeHandledScreen();
         this.i_field_670402ba = null;
         this.iIi_method_dbd165f();
         this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.ii_field_c8b05e47;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private BlockPos I_method_f50205f1() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && this.I_field_3c05b08c != null) {
         BlockPos var1 = this.i_field_a567c40b.get(this.I_field_3c05b08c);
         if (var1 != null && !this.I_method_49b09dfd(var1) && I_field_3a9bda27.world.getBlockEntity(var1) instanceof ChestBlockEntity) {
            return var1;
         } else {
            BlockPos var2 = BlockPos.ofFloored(I_field_3a9bda27.player.getPos());
            BlockPos var3 = null;
            double var4 = Double.MAX_VALUE;

            for (BlockPos var7 : BlockPos.iterateOutwards(var2, 8, 8, 8)) {
               if (I_field_3a9bda27.world.getBlockEntity(var7) instanceof ChestBlockEntity) {
                  BlockPos var8 = var7.toImmutable();
                  if (!this.I_method_49b09dfd(var8)) {
                     double var9 = var7.getSquaredDistance(I_field_3a9bda27.player.getPos());
                     if (var9 < var4) {
                        var4 = var9;
                        var3 = var8;
                     }
                  }
               }
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   private void I_method_49b09df9(BlockPos var1) {
      this.I_field_a56a8dc5.add(var1);
      BlockPos var2 = this.I_method_79d4e577(var1);
      if (var2 != null) {
         this.I_field_a56a8dc5.add(var2);
      }
   }

   private boolean I_method_49b09dfd(BlockPos var1) {
      if (this.I_field_a56a8dc5.contains(var1)) {
         return true;
      } else {
         BlockPos var2 = this.I_method_79d4e577(var1);
         return var2 != null && this.I_field_a56a8dc5.contains(var2);
      }
   }

   private BlockPos I_method_79d4e577(BlockPos var1) {
      if (var1 != null && I_field_3a9bda27.world != null) {
         BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
         if (!(var2.getBlock() instanceof ChestBlock)) {
            return null;
         } else {
            ChestType var3 = (ChestType)var2.get(ChestBlock.CHEST_TYPE);
            if (var3 == ChestType.SINGLE) {
               return null;
            } else {
               Direction var4 = (Direction)var2.get(ChestBlock.FACING);
               Direction var5 = var3 == ChestType.LEFT ? var4.rotateYClockwise() : var4.rotateYCounterclockwise();
               return var1.offset(var5);
            }
         }
      } else {
         return null;
      }
   }

   private boolean I_method_2e7a8749(ItemStack var1, Item var2) {
      if (var2 != Items.POTION) {
         return var1.getItem() == var2;
      } else {
         PotionContentsComponent var3 = (PotionContentsComponent)var1.get(DataComponentTypes.POTION_CONTENTS);
         return var1.getItem() == Items.POTION
            && var3 != null
            && var3.potion().isPresent()
            && ((RegistryEntry)var3.potion().get()).value() == Potions.WATER.value();
      }
   }

   private void iII_method_dae8a7f() {
      if (I_field_3a9bda27.currentScreen != null) {
         I_field_3a9bda27.player.closeHandledScreen();
      }

      if (this.I_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2())) {
         if (this.i_field_ba20ca4c.i_method_9b12da03() && this.I_method_29831e43()) {
            this.i_field_670402ba = null;
            this.iIi_method_dbd165f();
            this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.Ii_field_c8b05e47;
            this.I_field_991c1e8c.I_method_23e11e3f();
         } else {
            this.I_field_670402ba = null;
            this.i_field_670402ba = null;
            this.iIi_method_dbd165f();
            this.I_field_c8b05e47 = IIIiiiiii_Class64.Nested1_b9f78040.I_field_c8b05e47;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void iIi_method_dbd165f() {
      this.I_field_32e13e6c = null;
      this.Ii_field_49 = 0;
   }

   private boolean I_method_ff22476f(Vec3d var1) {
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
         return this.Ii_field_49 >= 2;
      } else {
         return false;
      }
   }

   private boolean I_method_29831e43() {
      for (int var1 = 0; var1 < I_field_3a9bda27.player.getInventory().size(); var1++) {
         ItemStack var2 = I_field_3a9bda27.player.getInventory().getStack(var1);
         if (this.I_method_9c08ff65(var2)) {
            return true;
         }
      }

      return false;
   }

   private boolean I_method_9c08ff65(ItemStack var1) {
      if (var1.getItem() != Items.POTION) {
         return false;
      } else {
         PotionContentsComponent var2 = (PotionContentsComponent)var1.get(DataComponentTypes.POTION_CONTENTS);
         return var2 != null && !var2.potion().isEmpty() ? ((RegistryEntry)var2.potion().get()).value() == this.I_method_7bc11df5() : false;
      }
   }

   private Potion I_method_7bc11df5() {
      if (this.I_field_500d0627.isSelected()) {
         return (Potion)Potions.STRONG_STRENGTH.value();
      } else if (this.i_field_500d0627.isSelected()) {
         return (Potion)Potions.STRONG_SWIFTNESS.value();
      } else if (this.II_field_500d0627.isSelected()) {
         return (Potion)Potions.LONG_FIRE_RESISTANCE.value();
      } else if (this.iI_field_500d0627.isSelected()) {
         return (Potion)Potions.STRONG_REGENERATION.value();
      } else if (this.ii_field_500d0627.isSelected()) {
         return (Potion)Potions.HEALING.value();
      } else if (this.III_field_500d0627.isSelected()) {
         return (Potion)Potions.STRONG_HEALING.value();
      } else {
         return this.Ii_field_500d0627.isSelected() && this.I_field_ba20ca4c.i_method_9b12da03()
            ? (Potion)Potions.LONG_INVISIBILITY.value()
            : (Potion)Potions.INVISIBILITY.value();
      }
   }

   private Item I_method_824738eb(BrewingStandScreenHandler var1) {
      if (this.I_method_1d68a275(var1, (Potion)Potions.WATER.value())) {
         return Items.NETHER_WART;
      } else {
         if (this.I_method_1d68a275(var1, (Potion)Potions.AWKWARD.value())) {
            if (this.I_field_500d0627.isSelected()) {
               return Items.BLAZE_POWDER;
            }

            if (this.i_field_500d0627.isSelected()) {
               return Items.SUGAR;
            }

            if (this.II_field_500d0627.isSelected()) {
               return Items.MAGMA_CREAM;
            }

            if (this.Ii_field_500d0627.isSelected()) {
               return Items.GOLDEN_CARROT;
            }

            if (this.iI_field_500d0627.isSelected()) {
               return Items.GHAST_TEAR;
            }

            if (this.ii_field_500d0627.isSelected() || this.III_field_500d0627.isSelected()) {
               return Items.GLISTERING_MELON_SLICE;
            }
         }

         if (this.I_method_1d68a275(var1, (Potion)Potions.NIGHT_VISION.value()) && this.Ii_field_500d0627.isSelected()) {
            return Items.FERMENTED_SPIDER_EYE;
         } else if (this.I_method_1d68a275(var1, (Potion)Potions.STRENGTH.value()) || this.I_method_1d68a275(var1, (Potion)Potions.SWIFTNESS.value())) {
            return Items.GLOWSTONE_DUST;
         } else if (this.I_method_1d68a275(var1, (Potion)Potions.FIRE_RESISTANCE.value())) {
            return Items.REDSTONE;
         } else if (this.Ii_field_500d0627.isSelected()
            && this.I_field_ba20ca4c.i_method_9b12da03()
            && this.I_method_1d68a275(var1, (Potion)Potions.INVISIBILITY.value())) {
            return Items.REDSTONE;
         } else if (this.III_field_500d0627.isSelected() && this.I_method_1d68a275(var1, (Potion)Potions.HEALING.value())) {
            return Items.GLOWSTONE_DUST;
         } else {
            return this.iI_field_500d0627.isSelected() && this.I_method_1d68a275(var1, (Potion)Potions.REGENERATION.value()) ? Items.GLOWSTONE_DUST : null;
         }
      }
   }

   private boolean I_method_1d68a275(BrewingStandScreenHandler var1, Potion var2) {
      boolean var3 = false;

      for (int var4 = 0; var4 < 3; var4++) {
         ItemStack var5 = var1.getSlot(var4).getStack();
         if (!var5.isEmpty()) {
            if (var5.getItem() != Items.POTION) {
               return false;
            }

            PotionContentsComponent var6 = (PotionContentsComponent)var5.get(DataComponentTypes.POTION_CONTENTS);
            if (var6 == null || var6.potion().isEmpty()) {
               return false;
            }

            if (((RegistryEntry)var6.potion().get()).value() != var2) {
               return false;
            }

            var3 = true;
         }
      }

      return var3;
   }

   private boolean I_method_352f8849(ItemStack var1, Potion var2) {
      if (var1.getItem() != Items.POTION) {
         return false;
      } else {
         PotionContentsComponent var3 = (PotionContentsComponent)var1.get(DataComponentTypes.POTION_CONTENTS);
         return var3 != null && !var3.potion().isEmpty() ? ((RegistryEntry)var3.potion().get()).value() == var2 : false;
      }
   }

   private boolean I_method_1e13f9c0(Item var1, int var2) {
      if (!this.i_field_991c1e8c.I_method_58432069((long)(this.I_field_73178e8c.Ii_method_a20abcd2() * 1.2))) {
         return true;
      } else {
         int var3 = this.I_method_f0743e1a(var1);
         if (var3 == -1) {
            return false;
         } else {
            if (this.IiI_field_500d0627.isSelected()) {
               this.I_method_d32312b2(var3, var2);
            } else {
               iIIiIiIiI_Class299.Ii_method_5feb9482(var3, var2);
            }

            this.i_field_991c1e8c.I_method_23e11e3f();
            return true;
         }
      }
   }

   private void I_method_d32312b2(int var1, int... var2) {
      int var3 = I_field_3a9bda27.player.currentScreenHandler.syncId;
      I_field_3a9bda27.interactionManager.clickSlot(var3, var1, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
      I_field_3a9bda27.interactionManager.clickSlot(var3, -999, 4, SlotActionType.QUICK_CRAFT, I_field_3a9bda27.player);

      for (int var7 : var2) {
         I_field_3a9bda27.interactionManager.clickSlot(var3, var7, 5, SlotActionType.QUICK_CRAFT, I_field_3a9bda27.player);
      }

      I_field_3a9bda27.interactionManager.clickSlot(var3, -999, 6, SlotActionType.QUICK_CRAFT, I_field_3a9bda27.player);
      I_field_3a9bda27.interactionManager.clickSlot(var3, var1, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
   }

   private int I_method_f0743e1a(Item var1) {
      for (int var2 = 5; var2 < 41; var2++) {
         if (((Slot)I_field_3a9bda27.player.currentScreenHandler.slots.get(var2)).getStack().getItem() == var1) {
            return var2;
         }
      }

      return -1;
   }

   private int I_method_f7a3f5a8(BrewingStandScreenHandler var1) {
      for (int var2 = 5; var2 < 41; var2++) {
         ItemStack var3 = ((Slot)var1.slots.get(var2)).getStack();
         if (var3.getItem() == Items.POTION) {
            PotionContentsComponent var4 = (PotionContentsComponent)var3.get(DataComponentTypes.POTION_CONTENTS);
            if (var4 != null && !var4.potion().isEmpty() && ((RegistryEntry)var4.potion().get()).value() == Potions.WATER.value()) {
               return var2;
            }
         }
      }

      return -1;
   }

   private List<BlockPos> I_method_1b888e28() {
      ArrayList var1 = new ArrayList();
      BlockPos var2 = BlockPos.ofFloored(I_field_3a9bda27.player.getPos());

      for (BlockPos var4 : BlockPos.iterateOutwards(var2, 5, 5, 5)) {
         if (I_field_3a9bda27.world.getBlockEntity(var4) instanceof BrewingStandBlockEntity) {
            var1.add(var4.toImmutable());
         }
      }

      var1.sort(Comparator.comparingDouble(var0 -> ((net.minecraft.util.math.BlockPos)var0).getSquaredDistance(I_field_3a9bda27.player.getPos())));
      return var1;
   }

   private BlockPos i_method_69fc7611() {
      BlockPos var1 = BlockPos.ofFloored(I_field_3a9bda27.player.getPos());
      BlockPos var2 = null;
      double var3 = Double.MAX_VALUE;

      for (BlockPos var6 : BlockPos.iterateOutwards(var1, 8, 8, 8)) {
         if (I_field_3a9bda27.world.getBlockEntity(var6) instanceof ChestBlockEntity) {
            double var7 = var6.getSquaredDistance(I_field_3a9bda27.player.getPos());
            if (var7 < var3) {
               var3 = var7;
               var2 = var6.toImmutable();
            }
         }
      }

      return var2;
   }

   private boolean i_method_740431dd(BlockPos var1) {
      double var2 = I_field_3a9bda27.player.getBlockInteractionRange();
      return I_field_3a9bda27.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) <= var2 * var2;
   }

   private void i_method_740431d9(BlockPos var1) {
      Vec3d var2 = Vec3d.ofCenter(var1);
      BlockHitResult var3 = new BlockHitResult(var2, Direction.UP, var1, false);
      I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var3);
      I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
   }

   private Box I_method_ecb0970d(BlockPos var1) {
      return new Box(var1).contract(0.02);
   }

   static enum Nested1_b9f78040 {
      I_field_c8b05e47,
      i_field_c8b05e47,
      II_field_c8b05e47,
      Ii_field_c8b05e47,
      iI_field_c8b05e47,
      ii_field_c8b05e47,
      III_field_c8b05e47,
      IIi_field_c8b05e47;
   }
}
