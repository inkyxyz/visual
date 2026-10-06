package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.block.entity.SmokerBlockEntity;
import net.minecraft.client.gui.screen.ingame.BlastFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.BrewingStandScreen;
import net.minecraft.client.gui.screen.ingame.FurnaceScreen;
import net.minecraft.client.gui.screen.ingame.SmokerScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.BrewingStandScreenHandler;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Pots Timer",
   category = ModuleCategory.VISUALS,
   III_method_a89e5834 = "modules.descriptions.pots_timer"
)
public class PotsTimerModule extends Module {
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private BooleanSetting Ii_field_ba20ca4c;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private final Map<BlockPos, PotsTimerModule.Nested1_df2bc80> I_field_a567c40b = new ConcurrentHashMap<>();
   private final LinkedHashSet<BlockPos> I_field_9573462c = new LinkedHashSet<>();
   private PotsTimerModule.Nested1_b064d3c9 I_field_8f7898c6;
   private BlockPos I_field_670402ba;
   private long I_field_4a;
   private long i_field_4a;
   private int I_field_49;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final IiIIIiII_Class69<WorldChangeEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41;
   private final IiIIIiII_Class69<PreHudRenderEvent> II_field_3d936f41;

   public PotsTimerModule() {
      this.I_field_8f7898c6 = PotsTimerModule.Nested1_b064d3c9.I_field_8f7898c6;
      this.I_field_49 = -1;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.I_field_3d936f41 = var1 -> {
         this.iIi_method_ce9d821f();
         this.I_field_a567c40b.clear();
         this.I_field_9573462c.clear();
      };
      this.i_field_3d936f41 = var1 -> {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            if (this.I_field_991c1e8c.I_method_58432069(800L)) {
               this.Iii_method_99c55e5f();
               this.I_field_991c1e8c.I_method_23e11e3f();
            }

            long var2 = System.currentTimeMillis();
            long var4 = 20000L;

            for (Entry var7 : this.I_field_a567c40b.entrySet()) {
               PotsTimerModule.Nested1_df2bc80 var8 = (PotsTimerModule.Nested1_df2bc80)var7.getValue();
               var8.I_method_29aa46ca(var2);
               if (var2 - var8.I_field_4a > var4) {
                  this.I_field_9573462c.add((BlockPos)var7.getKey());
               }
            }

            this.iII_method_ce8ef63f();
         }
      };
      this.II_field_3d936f41 = var1 -> {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            CustomDrawContext var2 = var1.getContext();

            for (Entry var4 : this.I_field_a567c40b.entrySet()) {
               BlockPos var5 = (BlockPos)var4.getKey();
               PotsTimerModule.Nested1_df2bc80 var6 = (PotsTimerModule.Nested1_df2bc80)var4.getValue();
               this.I_method_7ccfb8ea(var2, var5, var6);
            }
         }
      };
      this.IiI_method_99b6d27f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_99b6d27f() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.pots_timer.furnaces").I_method_decd82b5();
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.pots_timer.blast_furnaces").I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.pots_timer.smokers").I_method_decd82b5();
      this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.pots_timer.brewing").I_method_decd82b5();
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.pots_timer.range")
         .I_method_c8c9a7d7(4.0F)
         .i_method_65e2aff7(32.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(16.0F);
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.pots_timer.scale")
         .I_method_c8c9a7d7(0.3F)
         .i_method_65e2aff7(1.3F)
         .II_method_b0f56334(0.05F)
         .Ii_method_4e0e6b54(0.4F);
   }

   @Override
   public final void onDisable() {
      super.onDisable();
      this.iIi_method_ce9d821f();
      this.I_field_a567c40b.clear();
      this.I_field_9573462c.clear();
   }

   private void Iii_method_99c55e5f() {
      int var1 = (int)Math.ceil(this.I_field_73178e8c.Ii_method_a20abcd2());
      BlockPos var2 = I_field_3a9bda27.player.getBlockPos();
      double var3 = this.I_field_73178e8c.Ii_method_a20abcd2() * this.I_field_73178e8c.Ii_method_a20abcd2();
      ArrayList var5 = new ArrayList();

      for (int var6 = -var1; var6 <= var1; var6++) {
         for (int var7 = -var1; var7 <= var1; var7++) {
            for (int var8 = -var1; var8 <= var1; var8++) {
               BlockPos var9 = var2.add(var6, var7, var8);
               if (!(var2.getSquaredDistance(var9) > var3)) {
                  BlockEntity var10 = I_field_3a9bda27.world.getBlockEntity(var9);
                  if (this.I_method_73525d58(var10)) {
                     var5.add(var9);
                     if (!this.I_field_a567c40b.containsKey(var9)) {
                        PotsTimerModule.Nested1_df2bc80 var11 = new PotsTimerModule.Nested1_df2bc80(this.I_method_cbd1c1e5(var10));
                        this.I_field_a567c40b.put(var9, var11);
                        this.I_field_9573462c.add(var9);
                     }
                  }
               }
            }
         }
      }

      this.I_field_a567c40b.keySet().removeIf(var2x -> {
         if (var5.contains(var2x)) {
            return false;
         } else {
            this.I_field_9573462c.remove(var2x);
            return true;
         }
      });
   }

   private boolean I_method_73525d58(BlockEntity var1) {
      if (var1 == null) {
         return false;
      } else if (var1 instanceof FurnaceBlockEntity) {
         return this.I_field_ba20ca4c.i_method_9b12da03();
      } else if (var1 instanceof BlastFurnaceBlockEntity) {
         return this.i_field_ba20ca4c.i_method_9b12da03();
      } else if (var1 instanceof SmokerBlockEntity) {
         return this.II_field_ba20ca4c.i_method_9b12da03();
      } else {
         return var1 instanceof BrewingStandBlockEntity ? this.Ii_field_ba20ca4c.i_method_9b12da03() : false;
      }
   }

   private PotsTimerModule.Nested1_df2bca0 I_method_cbd1c1e5(BlockEntity var1) {
      if (var1 instanceof BlastFurnaceBlockEntity) {
         return PotsTimerModule.Nested1_df2bca0.i_field_f41cade7;
      } else if (var1 instanceof SmokerBlockEntity) {
         return PotsTimerModule.Nested1_df2bca0.II_field_f41cade7;
      } else {
         return var1 instanceof BrewingStandBlockEntity
            ? PotsTimerModule.Nested1_df2bca0.Ii_field_f41cade7
            : PotsTimerModule.Nested1_df2bca0.I_field_f41cade7;
      }
   }

   private void iII_method_ce8ef63f() {
      long var1 = System.currentTimeMillis();
      int var3 = -1;
      switch (this.I_field_8f7898c6) {
         case I_field_8f7898c6:
            if (I_field_3a9bda27.currentScreen != null) {
               return;
            }

            if (I_field_3a9bda27.player.currentScreenHandler != I_field_3a9bda27.player.playerScreenHandler) {
               return;
            }

            if (this.I_field_9573462c.isEmpty()) {
               return;
            }

            BlockPos var11 = this.I_field_9573462c.getFirst();
            this.I_field_9573462c.remove(var11);
            PotsTimerModule.Nested1_df2bc80 var12 = this.I_field_a567c40b.get(var11);
            if (var12 == null) {
               return;
            }

            if (!this.I_method_17f209bd(var11)) {
               return;
            }
            Class<? extends net.minecraft.client.gui.screen.Screen> var6 = switch (var12.I_field_f41cade7) {
               case I_field_f41cade7 -> FurnaceScreen.class;
               case i_field_f41cade7 -> BlastFurnaceScreen.class;
               case II_field_f41cade7 -> SmokerScreen.class;
               case Ii_field_f41cade7 -> BrewingStandScreen.class;
            };
            iIIiIiiII_Class301.I_method_c9363664(var11, var6);
            this.I_field_670402ba = var11;
            this.I_field_4a = var1;
            this.i_field_4a = 0L;
            this.I_field_49 = -1;
            byte var10 = -1;
            Vec3d var7 = Vec3d.ofCenter(var11);
            BlockHitResult var8 = new BlockHitResult(var7, Direction.UP, var11, false);
            I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var8);
            this.I_field_8f7898c6 = PotsTimerModule.Nested1_b064d3c9.i_field_8f7898c6;
            break;
         case i_field_8f7898c6:
            if (var1 - this.I_field_4a > 1500L) {
               this.ii_method_d043a1d2(false);
               return;
            }

            if (this.IiI_method_99b6d283()) {
               this.I_field_49 = this.II_method_3672bd35();
               this.i_field_4a = var1;
               this.I_field_8f7898c6 = PotsTimerModule.Nested1_b064d3c9.II_field_8f7898c6;
            }
            break;
         case II_field_8f7898c6:
            if (var1 - this.I_field_4a > 1500L) {
               this.ii_method_d043a1d2(this.I_field_49 != -1);
               return;
            }

            if (!this.IiI_method_99b6d283()) {
               this.ii_method_d043a1d2(false);
               return;
            }

            if (var1 - this.i_field_4a < 220L) {
               return;
            }

            var3 = this.II_method_3672bd35();
            ItemStack var4 = this.I_method_1663c819();
            PotsTimerModule.Nested1_df2bc80 var5 = this.I_field_a567c40b.get(this.I_field_670402ba);
            if (var5 != null) {
               var5.I_method_7d545548(this.I_field_49, var3, var4, var1);
            }

            this.I_field_8f7898c6 = PotsTimerModule.Nested1_b064d3c9.Ii_field_8f7898c6;
            break;
         case Ii_field_8f7898c6:
            if (I_field_3a9bda27.player.networkHandler != null) {
               I_field_3a9bda27.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(I_field_3a9bda27.player.currentScreenHandler.syncId));
               I_field_3a9bda27.player.currentScreenHandler = I_field_3a9bda27.player.playerScreenHandler;
            }

            iIIiIiiII_Class301.I_method_8abb23f();
            this.I_field_8f7898c6 = PotsTimerModule.Nested1_b064d3c9.I_field_8f7898c6;
            this.I_field_670402ba = null;
      }
   }

   private boolean IiI_method_99b6d283() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.player.currentScreenHandler != null) {
         PotsTimerModule.Nested1_df2bc80 var1 = this.I_field_a567c40b.get(this.I_field_670402ba);
         if (var1 == null) {
            return false;
         } else {
            return switch (var1.I_field_f41cade7) {
               case I_field_f41cade7, i_field_f41cade7, II_field_f41cade7 -> I_field_3a9bda27.player.currentScreenHandler instanceof AbstractFurnaceScreenHandler;
               case Ii_field_f41cade7 -> I_field_3a9bda27.player.currentScreenHandler instanceof BrewingStandScreenHandler;
            };
         }
      } else {
         return false;
      }
   }

   private int II_method_3672bd35() {
      PotsTimerModule.Nested1_df2bc80 var1 = this.I_field_a567c40b.get(this.I_field_670402ba);
      if (var1 == null) {
         return -1;
      } else {
         return switch (var1.I_field_f41cade7) {
            case I_field_f41cade7, i_field_f41cade7, II_field_f41cade7 -> I_field_3a9bda27.player.currentScreenHandler instanceof AbstractFurnaceScreenHandler var4
               ? Math.round(var4.getCookProgress() * var1.I_field_49)
               : -1;
            case Ii_field_f41cade7 -> I_field_3a9bda27.player.currentScreenHandler instanceof BrewingStandScreenHandler var2 ? var2.getBrewTime() : -1;
         };
      }
   }

   private ItemStack I_method_1663c819() {
      PotsTimerModule.Nested1_df2bc80 var1 = this.I_field_a567c40b.get(this.I_field_670402ba);
      if (var1 == null) {
         return ItemStack.EMPTY;
      } else {
         try {
            return switch (var1.I_field_f41cade7) {
               case I_field_f41cade7, i_field_f41cade7, II_field_f41cade7 -> {
                  if (I_field_3a9bda27.player.currentScreenHandler instanceof AbstractFurnaceScreenHandler var5) {
                     ItemStack var8 = var5.getSlot(0).getStack();
                     yield !var8.isEmpty() ? var8.copy() : var5.getSlot(2).getStack().copy();
                  } else {
                     yield ItemStack.EMPTY;
                  }
               }
               case Ii_field_f41cade7 -> {
                  if (I_field_3a9bda27.player.currentScreenHandler instanceof BrewingStandScreenHandler var2) {
                     ItemStack var6 = var2.getSlot(3).getStack();
                     yield !var6.isEmpty() ? var6.copy() : var2.getSlot(0).getStack().copy();
                  } else {
                     yield ItemStack.EMPTY;
                  }
               }
            };
         } catch (Exception var4) {
            return ItemStack.EMPTY;
         }
      }
   }

   private void ii_method_d043a1d2(boolean var1) {
      if (this.I_field_8f7898c6 != PotsTimerModule.Nested1_b064d3c9.I_field_8f7898c6) {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.player.currentScreenHandler != I_field_3a9bda27.player.playerScreenHandler) {
            if (I_field_3a9bda27.player.networkHandler != null) {
               I_field_3a9bda27.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(I_field_3a9bda27.player.currentScreenHandler.syncId));
            }

            I_field_3a9bda27.player.currentScreenHandler = I_field_3a9bda27.player.playerScreenHandler;
         }

         if (!var1 && this.I_field_670402ba != null) {
            PotsTimerModule.Nested1_df2bc80 var2 = this.I_field_a567c40b.get(this.I_field_670402ba);
            if (var2 != null) {
               var2.I_field_4a = System.currentTimeMillis();
               var2.I_field_5a = true;
            }
         }

         iIIiIiiII_Class301.I_method_8abb23f();
         this.I_field_8f7898c6 = PotsTimerModule.Nested1_b064d3c9.I_field_8f7898c6;
         this.I_field_670402ba = null;
      }
   }

   private void iIi_method_ce9d821f() {
      if (this.I_field_8f7898c6 != PotsTimerModule.Nested1_b064d3c9.I_field_8f7898c6) {
         this.ii_method_d043a1d2(false);
      }

      this.I_field_8f7898c6 = PotsTimerModule.Nested1_b064d3c9.I_field_8f7898c6;
      this.I_field_670402ba = null;
   }

   private boolean I_method_17f209bd(BlockPos var1) {
      double var2 = I_field_3a9bda27.player.getBlockInteractionRange();
      return I_field_3a9bda27.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) <= var2 * var2;
   }

   private void I_method_7ccfb8ea(CustomDrawContext var1, BlockPos var2, PotsTimerModule.Nested1_df2bc80 var3) {
      boolean var4 = var3.I_method_8579173e();
      if (var4 && !var3.I_field_5a) {
         Vec3d var5 = Vec3d.ofCenter(var2).add(0.0, 1.1, 0.0);
         Vec2f var6 = iIiiiiIII_Class377.I_method_211fc242(var5);
         if (var6 != null) {
            float var7 = (float)I_field_3a9bda27.player.getPos().distanceTo(Vec3d.ofCenter(var2));
            float var8 = MathHelper.clamp(1.0F - var7 / 24.0F, 0.45F, 1.0F) * this.i_field_73178e8c.Ii_method_a20abcd2();
            float var9 = var3.I_method_8579172a();
            long var10 = var3.I_method_8579172e();
            long var12 = var10 / 60L;
            long var14 = var10 % 60L;
            String var16 = String.format("%02d:%02d", var12, var14);
            float var17 = 110.0F;
            float var18 = 110.0F;
            MatrixStack var19 = var1.getMatrices();
            var19.push();
            var19.translate(var6.x - var17 / 2.0F, var6.y - var18 / 2.0F, 0.0F);
            iIiiiIIiI_Class371.II_method_e18635ac(var19, var17 / 2.0F, var18 / 2.0F, var8);
            ColorRGBA var20 = IiiiiIIIi_Class242.i_method_5dfec6e();
            ColorRGBA var21 = new ColorRGBA(9.0F, 9.0F, 11.0F).mulAlpha(0.55F);
            var1.drawBlurredRect(
               0.0F, 0.0F, var17, var18, 35.0F, 5.0F, IIiii_Class8.I_method_893b2757(22.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.35F)
            );
            var1.drawSquircle(0.0F, 0.0F, var17, var18, 5.0F, IIiii_Class8.I_method_893b2757(22.0F), var21);
            var1.drawCircleProgress(var17 / 2.0F, var18 / 2.0F, 40.0F, 5.0F, 1.0F, new ColorRGBA(255.0F, 255.0F, 255.0F).mulAlpha(0.12F));
            var1.drawCircleProgress(var17 / 2.0F, var18 / 2.0F, 40.0F, 5.0F, MathHelper.clamp(var9, 0.0F, 1.0F), var20);
            ItemStack var22 = var3.I_field_f2735522;
            if (var22 != null && !var22.isEmpty()) {
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               var1.drawItem(var22, var17 / 2.0F - 8.0F, var18 / 2.0F - 12.0F, 1.0F);
            } else {
               Item var23 = var3.I_field_f41cade7.I_method_1db6cf50();
               var1.drawItem(var23, var17 / 2.0F - 8.0F, var18 / 2.0F - 12.0F, 1.0F);
            }

            var1.drawCenteredText(
               IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(13.0F), var16, var17 / 2.0F, var18 / 2.0F + 10.0F, IiiiiIIIi_Class242.iI_method_8e08d3b1()
            );
            iIiiiIIiI_Class371.I_method_10503b11(var19);
            var19.pop();
         }
      }
   }

   static enum Nested1_b064d3c9 {
      I_field_8f7898c6,
      i_field_8f7898c6,
      II_field_8f7898c6,
      Ii_field_8f7898c6;
   }

   static final class Nested1_df2bc80 {
      final PotsTimerModule.Nested1_df2bca0 I_field_f41cade7;
      final int I_field_49;
      ItemStack I_field_f2735522 = ItemStack.EMPTY;
      long I_field_4a;
      long i_field_4a;
      float I_field_46;
      float i_field_46;
      boolean I_field_5a = true;

      Nested1_df2bc80(PotsTimerModule.Nested1_df2bca0 var1) {
         this.I_field_f41cade7 = var1;
         this.I_field_49 = var1.I_field_49;
      }

      void I_method_7d545548(int var1, int var2, ItemStack var3, long var4) {
         int var6 = var2 >= 0 ? var2 : var1;
         if (var6 < 0) {
            var6 = 0;
         }

         this.I_field_46 = var6;
         if (var1 >= 0 && var2 >= 0) {
            int var7 = var2 - var1;
            if (this.I_field_f41cade7 == PotsTimerModule.Nested1_df2bca0.Ii_field_f41cade7) {
               this.i_field_46 = var7 < 0 ? -1.0F : 0.0F;
            } else {
               this.i_field_46 = var7 > 0 ? 1.0F : 0.0F;
            }

            this.I_field_5a = this.I_field_f41cade7 == PotsTimerModule.Nested1_df2bca0.Ii_field_f41cade7 ? var2 == 0 || var7 >= 0 : var6 == 0 || var7 <= 0;
         } else {
            this.i_field_46 = this.I_field_f41cade7 == PotsTimerModule.Nested1_df2bca0.Ii_field_f41cade7 ? -1.0F : 1.0F;
            this.I_field_5a = var6 == 0;
         }

         if (var3 != null && !var3.isEmpty()) {
            this.I_field_f2735522 = var3;
         }

         this.I_field_4a = var4;
         this.i_field_4a = var4;
      }

      void I_method_29aa46ca(long var1) {
         if (!this.I_field_5a && this.i_field_46 != 0.0F) {
            float var3 = (float)(var1 - this.i_field_4a) / 50.0F;
            this.I_field_46 = this.I_field_46 + this.i_field_46 * var3;
            this.I_field_46 = MathHelper.clamp(this.I_field_46, 0.0F, this.I_field_49);
            if (this.I_field_f41cade7 == PotsTimerModule.Nested1_df2bca0.Ii_field_f41cade7 && this.I_field_46 <= 0.0F) {
               this.I_field_5a = true;
            } else if (this.I_field_f41cade7 != PotsTimerModule.Nested1_df2bca0.Ii_field_f41cade7 && this.I_field_46 >= this.I_field_49) {
               this.I_field_46 = 0.0F;
            }

            this.i_field_4a = var1;
         } else {
            this.i_field_4a = var1;
         }
      }

      float I_method_8579172a() {
         if (this.I_field_49 <= 0) {
            return 0.0F;
         } else {
            return this.I_field_f41cade7 == PotsTimerModule.Nested1_df2bca0.Ii_field_f41cade7
               ? 1.0F - this.I_field_46 / this.I_field_49
               : this.I_field_46 / this.I_field_49;
         }
      }

      long I_method_8579172e() {
         float var1;
         if (this.I_field_f41cade7 == PotsTimerModule.Nested1_df2bca0.Ii_field_f41cade7) {
            var1 = this.I_field_46;
         } else {
            var1 = this.I_field_49 - this.I_field_46;
         }

         return Math.max(0L, (long)Math.round(var1 / 20.0F));
      }

      boolean I_method_8579173e() {
         return !this.I_field_5a && this.i_field_46 != 0.0F;
      }
   }

   static enum Nested1_df2bca0 {
      I_field_f41cade7(200, Items.FURNACE),
      i_field_f41cade7(100, Items.BLAST_FURNACE),
      II_field_f41cade7(100, Items.SMOKER),
      Ii_field_f41cade7(400, Items.BREWING_STAND);

      final int I_field_49;
      final Item I_field_3c05b08c;

      private Nested1_df2bca0(int var3, Item var4) {
         this.I_field_49 = var3;
         this.I_field_3c05b08c = var4;
      }

      Item I_method_1db6cf50() {
         return this.I_field_3c05b08c;
      }
   }
}
