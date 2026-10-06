package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import moscow.rockstar.mixin.accessors.ItemCooldownEntryAccessor;
import moscow.rockstar.mixin.accessors.ItemCooldownManagerAccessor;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import org.joml.Matrix4f;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public class IiIiIiIii_Class172 extends IiIiIIiII_Class165 {
   private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(255.0F, 65.0F, 65.0F);
   private static final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(255.0F, 120.0F, 95.0F);
   private static final int I_field_49 = 96;
   private static final float I_field_46 = 0.5F;
   private final Map<Integer, IiiiIiIii_Class236> I_field_a567c40b = new HashMap<>();
   private final Map<Integer, IiiiIiIii_Class236> i_field_a567c40b = new HashMap<>();
   private final Map<Integer, BlockPos> II_field_a567c40b = new HashMap<>();
   private long I_field_4a;
   private final SliderSetting I_field_73178e8c = new SliderSetting(this, "hud.item_binds.per_row")
      .I_method_c8c9a7d7(1.0F)
      .i_method_65e2aff7(5.0F)
      .II_method_b0f56334(1.0F)
      .Ii_method_4e0e6b54(4.0F);
   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && I_field_3a9bda27.currentScreen == null) {
         AssistModule var2 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
         if (var2 != null && var2.isEnabled()) {
            if (var2.I_method_58a86ed5().i_method_9b12da03()) {
               this.Ii_method_90000f42(var1);
               iIiIIiII_Class165 var3 = null;
               iIiIIiII_Class165 var4 = null;

               for (iIiIIiII_Class165 var6 : var2.II_method_6ba8ace5()) {
                  if (var6.I_method_75fee910()
                     && (
                        var6 instanceof iIiiiiIi_Class190
                           || var6 instanceof iIiiIiiI_Class183
                           || var6 instanceof iIiIiiii_Class176
                           || var6 instanceof iIiiIiIi_Class182
                           || var6 instanceof iIiIiiII_Class173
                           || var6 instanceof iIiiiIii_Class188
                           || var6 instanceof iIiiiIiI_Class187
                           || var6 instanceof iIiIiIii_Class172
                     )) {
                     if (var3 == null && var6.I_method_75fee8ff() != -1 && this.I_method_1d761848(var6.I_method_75fee8ff())) {
                        var3 = var6;
                     } else if (var4 == null
                        && (
                           var6.I_method_b921bd52(I_field_3a9bda27.player.getMainHandStack())
                              || var6.I_method_b921bd52(I_field_3a9bda27.player.getOffHandStack())
                        )) {
                        var4 = var6;
                     }
                  }
               }

               iIiIIiII_Class165 var7 = var3 != null ? var3 : var4;
               if (var7 instanceof iIiiiiIi_Class190) {
                  this.I_method_d436dae9(var1, var7.I_method_db7f702c().getItem() == Items.POPPED_CHORUS_FRUIT ? "hw_trap_ender" : "ft_trap_default");
               } else if (var7 instanceof iIiiIiiI_Class183) {
                  this.ii_method_24056f62(var1);
               } else if (var7 instanceof iIiIiiii_Class176 || var7 instanceof iIiiIiIi_Class182) {
                  this.I_method_8c6c1cba(var1, 10, 10.0);
               } else if (var7 instanceof iIiIiiII_Class173) {
                  this.iI_method_40475382(var1);
               } else if (var7 instanceof iIiiiIii_Class188) {
                  this.I_method_15750adf(var1);
               } else if (var7 instanceof iIiiiIiI_Class187) {
                  if (!this.i_method_749eba83()) {
                     return;
                  }

                  this.I_field_4a = System.currentTimeMillis() + 2500L;
                  this.II_method_ac41f362(var1);
               } else if (var7 instanceof iIiIiIii_Class172) {
                  this.i_method_f93326bf(var1);
               }
            }
         }
      }
   };
   private static final int i_field_49 = 10;
   private final Mutable I_field_4adf8198 = new Mutable();
   private static final float i_field_46 = 8.0F;
   private static final float II_field_46 = 2.0F;
   private static final float Ii_field_46 = 7.5F;

   private static ColorRGBA I_method_3dce262f(ColorRGBA var0) {
      return new ColorRGBA(Math.min(255.0F, var0.getRed() + 55.0F), Math.min(255.0F, var0.getGreen() + 50.0F), Math.min(255.0F, var0.getBlue() + 40.0F));
   }

   public IiIiIiIii_Class172() {
      super("hud.item_binds", "hud/clock");
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   @Override
   public void renderComponent(III var1) {
      AssistModule var2 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
      boolean var3 = I_field_3a9bda27.currentScreen instanceof ChatScreen;
      if (var2 != null || var3) {
         Object var4 = var2 == null ? new ArrayList() : this.I_method_ad0c340(var2);
         if (((net.minecraft.item.ItemStack)var4).isEmpty() && var3) {
            var4 = this.I_method_696cb1c8();
         }

         if (!((net.minecraft.item.ItemStack)var4).isEmpty()) {
            this.I_method_36481d8(var1, (List<IiIiIiIII_Class169>)var4);
         }
      }
   }

   private void I_method_d436dae9(Render3DEvent var1, String var2) {
      BlockPos var3 = I_field_3a9bda27.player.getBlockPos();
      Box var4 = new Box(var3.getX() - 1, var3.getY(), var3.getZ() - 1, var3.getX() + 2, var3.getY() + 3, var3.getZ() + 2);
      this.I_method_c320711(var1, var2, var3, this.I_method_1ef91dbf(var4, var1.getTickDelta()));
   }

   private void I_method_c320711(Render3DEvent var1, String var2, BlockPos var3, boolean var4) {
      iIiiiIIii_Class372.I_method_9591a23f(var2).I_method_e1fc8da(var1, var3, var4 ? I_field_d0c8ec5 : ColorRGBA.WHITE, 0.5F);
   }

   private boolean I_method_1ef91dbf(Box var1, float var2) {
      for (AbstractClientPlayerEntity var4 : I_field_3a9bda27.world.getPlayers()) {
         if (var4 != I_field_3a9bda27.player
            && var4.isAlive()
            && !RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var4.getName().getString())) {
            Vec3d var5 = iIiiiiIII_Class377.I_method_689b1a13(var4, var2);
            Box var6 = var4.getBoundingBox().offset(var5.subtract(var4.getPos()));
            if (var1.intersects(var6)) {
               return true;
            }
         }
      }

      return false;
   }

   private void I_method_15750adf(Render3DEvent var1) {
      BlockPos var2 = I_field_3a9bda27.player.getBlockPos();
      Box var3 = new Box(var2.getX() - 15, var2.getY() - 15, var2.getZ() - 15, var2.getX() + 15, var2.getY() + 15, var2.getZ() + 15).expand(0.002);
      boolean var4 = this.I_method_1ef91dbf(var3, var1.getTickDelta());
      ColorRGBA var5 = IiiiiIIIi_Class242.i_method_5dfec6e();
      ColorRGBA var6 = var4 ? I_field_d0c8ec5 : var5;
      ColorRGBA var7 = var4 ? i_field_d0c8ec5 : I_method_3dce262f(var5);
      Vec3d var8 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
      Box var9 = var3.offset(-var8.x, -var8.y, -var8.z);
      var1.getMatrices().push();
      this.I_method_1d765815(false);
      BufferBuilder var10 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      iIiiIIiIi_Class358.I_method_b5d61e06(var1.getMatrices(), var10, var9, var6.withAlpha(8.0F), var7.withAlpha(20.0F));
      this.I_method_14404570(var10);
      RenderSystem.lineWidth(2.5F);
      BufferBuilder var11 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      iIiiIIiIi_Class358.i_method_c95b01e6(var1.getMatrices(), var11, var9, var6.withAlpha(95.0F), var7.withAlpha(170.0F));
      iIiiIIiIi_Class358.Ii_method_c1caf816(var1.getMatrices(), var11, var9.expand(-0.05), var7.withAlpha(40.0F));
      this.I_method_14404570(var11);
      RenderSystem.lineWidth(1.0F);
      this.I_method_74902e9f();
      var1.getMatrices().pop();
   }

   private void i_method_f93326bf(Render3DEvent var1) {
      if (this.I_method_74902ea3()) {
         this.I_method_c320711(
            var1, "explosion_trap_ground", I_field_3a9bda27.player.getBlockPos().up(3), this.i_method_34de1925(6.0, 1.0, var1.getTickDelta())
         );
      } else {
         this.I_method_d436dae9(var1, "explosion_trap_air");
      }
   }

   private boolean I_method_74902ea3() {
      if (I_field_3a9bda27.player.isTouchingWater()) {
         return false;
      } else if (I_field_3a9bda27.player.isOnGround()) {
         return true;
      } else {
         BlockPos var1 = I_field_3a9bda27.player.getBlockPos();
         return this.I_method_aec1965d(var1.down()) || this.I_method_aec1965d(var1.down(2));
      }
   }

   private boolean I_method_aec1965d(BlockPos var1) {
      return !I_field_3a9bda27.world.getBlockState(var1).getCollisionShape(I_field_3a9bda27.world, var1).isEmpty();
   }

   private void II_method_ac41f362(Render3DEvent var1) {
      if (this.i_method_749eba83()) {
         PredictionModule var2 = RockstarClient.getInstance().getModuleManager().getModule(PredictionModule.class);
         if (var2 != null) {
            Vec3d var3 = var2.I_method_3dbf0519();
            if (var3 != null) {
               this.I_method_c48eb0ca(var1, BlockPos.ofFloored(var3), 7, 7.0, 1.0);
            }
         }
      }
   }

   private void Ii_method_90000f42(Render3DEvent var1) {
      if (!this.i_method_749eba83()) {
         this.II_field_a567c40b.clear();
      } else {
         PredictionModule var2 = RockstarClient.getInstance().getModuleManager().getModule(PredictionModule.class);
         if (var2 != null) {
            this.I_method_c2be1be7(var2);

            for (BlockPos var4 : this.II_field_a567c40b.values()) {
               this.I_method_c48eb0ca(var1, var4, 7, 7.0, 1.0);
            }
         }
      }
   }

   private void I_method_c2be1be7(PredictionModule var1) {
      HashSet var2 = new HashSet();
      long var3 = System.currentTimeMillis();

      for (Entity var6 : I_field_3a9bda27.world.getEntities()) {
         if (var6 instanceof SnowballEntity var7 && !var7.isRemoved()) {
            int var8 = var7.getId();
            var2.add(var8);
            if (!this.II_field_a567c40b.containsKey(var8) && this.I_method_c987c484(var7, var3)) {
               Vec3d var9 = var1.I_method_fbda0dc1(var7);
               if (var9 != null) {
                  this.II_field_a567c40b.put(var8, BlockPos.ofFloored(var9));
               }
            }
         }
      }

      this.II_field_a567c40b.keySet().removeIf(var1x -> !var2.contains(var1x));
   }

   private boolean I_method_c987c484(SnowballEntity var1, long var2) {
      return var1.getOwner() == I_field_3a9bda27.player ? true : var2 <= this.I_field_4a && var1.squaredDistanceTo(I_field_3a9bda27.player) <= 64.0;
   }

   private boolean i_method_749eba83() {
      return iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iII_field_ac164e6c);
   }

   private void iI_method_40475382(Render3DEvent var1) {
      BlockPos var2 = I_field_3a9bda27.player.getBlockPos();
      Vec3d var3 = new Vec3d(var2.getX() + 0.5, var2.getY(), var2.getZ() + 0.5);
      boolean var4 = this.I_method_9816b105(2.0, 2.0, var1.getTickDelta());
      ColorRGBA var5 = IiiiiIIIi_Class242.i_method_5dfec6e();
      ColorRGBA var6 = var4 ? I_field_d0c8ec5 : var5;
      ColorRGBA var7 = var4 ? i_field_d0c8ec5 : I_method_3dce262f(var5);
      Vec3d var8 = var3.subtract(I_field_3a9bda27.gameRenderer.getCamera().getPos());
      var1.getMatrices().push();
      this.I_method_1d765815(false);
      BufferBuilder var9 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      this.I_method_4641deac(var9, var1.getMatrices().peek().getPositionMatrix(), var8, 2.0, 2.0, var6.withAlpha(14.0F), var7.withAlpha(32.0F));
      this.I_method_14404570(var9);
      RenderSystem.lineWidth(2.5F);
      BufferBuilder var10 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      this.i_method_1c1a4ecc(var10, var1.getMatrices().peek().getPositionMatrix(), var8, 2.0, 2.0, var6.withAlpha(120.0F), var7.withAlpha(200.0F));
      this.I_method_14404570(var10);
      RenderSystem.lineWidth(1.0F);
      this.I_method_74902e9f();
      var1.getMatrices().pop();
   }

   private boolean I_method_9816b105(double var1, double var3, float var5) {
      BlockPos var6 = I_field_3a9bda27.player.getBlockPos();
      Vec3d var7 = new Vec3d(var6.getX() + 0.5, var6.getY(), var6.getZ() + 0.5);
      double var8 = var1 * var1;

      for (AbstractClientPlayerEntity var11 : I_field_3a9bda27.world.getPlayers()) {
         if (var11 != I_field_3a9bda27.player
            && var11.isAlive()
            && RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var11.getName().getString())) {
            Vec3d var12 = iIiiiiIII_Class377.I_method_689b1a13(var11, var5);
            Box var13 = var11.getBoundingBox().offset(var12.subtract(var11.getPos()));
            double var14 = Math.clamp(var7.x, var13.minX, var13.maxX);
            double var16 = Math.clamp(var7.z, var13.minZ, var13.maxZ);
            boolean var18 = var13.maxY >= var7.y && var13.minY <= var7.y + var3;
            if (var18 && new Vec3d(var14, var7.y, var16).squaredDistanceTo(var7) <= var8) {
               return true;
            }
         }
      }

      return false;
   }

   private void I_method_4641deac(BufferBuilder var1, Matrix4f var2, Vec3d var3, double var4, double var6, ColorRGBA var8, ColorRGBA var9) {
      for (int var10 = 0; var10 < 96; var10++) {
         double var11 = (Math.PI * 2) * var10 / 96.0;
         double var13 = (Math.PI * 2) * (var10 + 1) / 96.0;
         Vec3d var15 = var3.add(Math.cos(var11) * var4, 0.0, Math.sin(var11) * var4);
         Vec3d var16 = var3.add(Math.cos(var13) * var4, 0.0, Math.sin(var13) * var4);
         Vec3d var17 = var15.add(0.0, var6, 0.0);
         Vec3d var18 = var16.add(0.0, var6, 0.0);
         this.I_method_512f5d15(var2, var1, var15, var8);
         this.I_method_512f5d15(var2, var1, var16, var8);
         this.I_method_512f5d15(var2, var1, var18, var9);
         this.I_method_512f5d15(var2, var1, var17, var9);
      }
   }

   private void i_method_1c1a4ecc(BufferBuilder var1, Matrix4f var2, Vec3d var3, double var4, double var6, ColorRGBA var8, ColorRGBA var9) {
      for (int var10 = 0; var10 < 96; var10++) {
         double var11 = (Math.PI * 2) * var10 / 96.0;
         double var13 = (Math.PI * 2) * (var10 + 1) / 96.0;
         Vec3d var15 = var3.add(Math.cos(var11) * var4, 0.0, Math.sin(var11) * var4);
         Vec3d var16 = var3.add(Math.cos(var13) * var4, 0.0, Math.sin(var13) * var4);
         Vec3d var17 = var15.add(0.0, var6, 0.0);
         Vec3d var18 = var16.add(0.0, var6, 0.0);
         this.I_method_512f5d15(var2, var1, var15, var8);
         this.I_method_512f5d15(var2, var1, var16, var8);
         this.I_method_512f5d15(var2, var1, var17, var9);
         this.I_method_512f5d15(var2, var1, var18, var9);
         if (var10 % 12 == 0) {
            this.I_method_512f5d15(var2, var1, var15, var8);
            this.I_method_512f5d15(var2, var1, var17, var9);
         }
      }
   }

   private void I_method_512f5d15(Matrix4f var1, BufferBuilder var2, Vec3d var3, ColorRGBA var4) {
      var2.vertex(var1, (float)var3.x, (float)var3.y, (float)var3.z)
         .color(var4.getRed() / 255.0F, var4.getGreen() / 255.0F, var4.getBlue() / 255.0F, var4.getAlpha() / 255.0F);
   }

   private void I_method_8c6c1cba(Render3DEvent var1, int var2, double var3) {
      this.I_method_117dac4(var1, var2, var3, 10.0);
   }

   private void I_method_117dac4(Render3DEvent var1, int var2, double var3, double var5) {
      this.I_method_c48eb0ca(var1, I_field_3a9bda27.player.getBlockPos(), var2, var3, var5);
   }

   private void I_method_c48eb0ca(Render3DEvent var1, BlockPos var2, int var3, double var4, double var6) {
      List var8 = this.I_method_bca5d3d(var2, var3);
      Vec3d var9 = new Vec3d(var2.getX() + 0.5, var2.getY(), var2.getZ() + 0.5);
      boolean var10 = this.I_method_9c9b4d19(var9, var4, var6, var1.getTickDelta());
      ColorRGBA var11 = IiiiiIIIi_Class242.i_method_5dfec6e();
      ColorRGBA var12 = var10 ? I_field_d0c8ec5 : var11;
      ColorRGBA var13 = var10 ? i_field_d0c8ec5 : I_method_3dce262f(var11);
      Vec3d var14 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
      var1.getMatrices().push();
      this.I_method_1d765815(this.I_method_9ee39d94(var8));
      BufferBuilder var15 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

      for (Box var17 : (Iterable<Box>)(Iterable<?>)var8) {
         iIiiIIiIi_Class358.I_method_b5d61e06(
            var1.getMatrices(), var15, var17.offset(-var14.x, -var14.y, -var14.z), var12.withAlpha(10.0F), var13.withAlpha(24.0F)
         );
      }

      this.I_method_14404570(var15);
      RenderSystem.lineWidth(2.5F);
      BufferBuilder var20 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

      for (Box var18 : (Iterable<Box>)(Iterable<?>)var8) {
         Box var19 = var18.offset(-var14.x, -var14.y, -var14.z);
         iIiiIIiIi_Class358.i_method_c95b01e6(var1.getMatrices(), var20, var19, var12.withAlpha(105.0F), var13.withAlpha(180.0F));
      }

      this.I_method_14404570(var20);
      RenderSystem.lineWidth(1.0F);
      this.I_method_74902e9f();
      var1.getMatrices().pop();
   }

   private List<Box> I_method_5fdba983(int var1) {
      return this.I_method_bca5d3d(I_field_3a9bda27.player.getBlockPos(), var1);
   }

   private List<Box> I_method_bca5d3d(BlockPos var1, int var2) {
      ArrayList var3 = new ArrayList();
      int var4 = Integer.MIN_VALUE;
      int var5 = Integer.MIN_VALUE;
      int var6 = Math.max(16, var2 * 8);

      for (int var7 = 0; var7 < var6; var7++) {
         double var8 = (Math.PI * 2) * var7 / var6;
         int var10 = (int)Math.round(Math.cos(var8) * var2);
         int var11 = (int)Math.round(Math.sin(var8) * var2);
         if (var10 != var4 || var11 != var5) {
            int var12 = var1.getX() + var10;
            int var13 = var1.getZ() + var11;
            int var14 = this.I_method_985f7797(var12, var13, var1.getY());
            var3.add(new Box(var12, var14, var13, var12 + 1, var14 + 1, var13 + 1).expand(0.002));
            var4 = var10;
            var5 = var11;
         }
      }

      return var3;
   }

   private int I_method_985f7797(int var1, int var2, int var3) {
      if (I_field_3a9bda27.world == null) {
         return var3;
      } else {
         for (int var4 = 0; var4 <= 10; var4++) {
            if (this.I_method_985f77a8(var1, var3 - var4, var2)) {
               return var3 - var4;
            }

            if (var4 != 0 && this.I_method_985f77a8(var1, var3 + var4, var2)) {
               return var3 + var4;
            }
         }

         return var3;
      }
   }

   private boolean I_method_985f77a8(int var1, int var2, int var3) {
      this.I_field_4adf8198.set(var1, var2 - 1, var3);
      if (I_field_3a9bda27.world.getBlockState(this.I_field_4adf8198).getCollisionShape(I_field_3a9bda27.world, this.I_field_4adf8198).isEmpty()) {
         return false;
      } else {
         this.I_field_4adf8198.set(var1, var2, var3);
         return I_field_3a9bda27.world.getBlockState(this.I_field_4adf8198).getCollisionShape(I_field_3a9bda27.world, this.I_field_4adf8198).isEmpty();
      }
   }

   private void ii_method_24056f62(Render3DEvent var1) {
      List var2 = this.I_method_12260326(var1.getTickDelta());
      boolean var3 = this.I_method_3d907c34(var2, var1.getTickDelta());
      ColorRGBA var4 = IiiiiIIIi_Class242.i_method_5dfec6e();
      ColorRGBA var5 = var3 ? I_field_d0c8ec5 : var4;
      ColorRGBA var6 = var3 ? i_field_d0c8ec5 : I_method_3dce262f(var4);
      Vec3d var7 = I_field_3a9bda27.gameRenderer.getCamera().getPos();
      var1.getMatrices().push();
      this.I_method_1d765815(this.I_method_9ee39d94(var2));
      BufferBuilder var8 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

      for (Box var10 : (Iterable<Box>)(Iterable<?>)var2) {
         iIiiIIiIi_Class358.I_method_b5d61e06(var1.getMatrices(), var8, var10.offset(-var7.x, -var7.y, -var7.z), var5.withAlpha(16.0F), var6.withAlpha(38.0F));
      }

      this.I_method_14404570(var8);
      RenderSystem.lineWidth(2.5F);
      BufferBuilder var13 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

      for (Box var11 : (Iterable<Box>)(Iterable<?>)var2) {
         Box var12 = var11.offset(-var7.x, -var7.y, -var7.z);
         iIiiIIiIi_Class358.i_method_c95b01e6(var1.getMatrices(), var13, var12, var5.withAlpha(125.0F), var6.withAlpha(205.0F));
         iIiiIIiIi_Class358.Ii_method_c1caf816(var1.getMatrices(), var13, var12.expand(-0.03), var6.withAlpha(55.0F));
      }

      this.I_method_14404570(var13);
      RenderSystem.lineWidth(1.0F);
      this.I_method_74902e9f();
      var1.getMatrices().pop();
   }

   private List<Box> I_method_12260326(float var1) {
      BlockPos var2 = I_field_3a9bda27.player.getBlockPos();
      float var3 = I_field_3a9bda27.player.getPitch(var1);
      int var4 = Math.floorMod(Math.round(I_field_3a9bda27.player.getYaw(var1) / 45.0F), 8);
      if (Math.abs(var3) >= 60.0F) {
         int var5 = var2.getY() + (var3 < 0.0F ? 3 : -2);
         return List.of(new Box(var2.getX() - 2, var5, var2.getZ() - 2, var2.getX() + 3, var5 + 2, var2.getZ() + 3).expand(0.002));
      } else {
         return var4 % 2 == 0 ? List.of(this.I_method_1a33ad5e(var2, var4).expand(0.002)) : this.i_method_4f3a311d(var2, var4);
      }
   }

   private Box I_method_1a33ad5e(BlockPos var1, int var2) {
      return switch (var2) {
         case 0 -> new Box(var1.getX() - 2, var1.getY() - 1, var1.getZ() + 2, var1.getX() + 3, var1.getY() + 4, var1.getZ() + 4);
         default -> new Box(var1);
         case 2 -> new Box(var1.getX() - 4, var1.getY() - 1, var1.getZ() - 2, var1.getX() - 2, var1.getY() + 4, var1.getZ() + 3);
         case 4 -> new Box(var1.getX() - 2, var1.getY() - 1, var1.getZ() - 4, var1.getX() + 3, var1.getY() + 4, var1.getZ() - 2);
         case 6 -> new Box(var1.getX() + 2, var1.getY() - 1, var1.getZ() - 2, var1.getX() + 4, var1.getY() + 4, var1.getZ() + 3);
      };
   }

   private List<Box> i_method_4f3a311d(BlockPos var1, int var2) {
      ArrayList var3 = new ArrayList();
      int[][] var4 = this.I_method_98513557(var2);

      for (int[] var8 : var4) {
         var3.add(
            new Box(var1.getX() + var8[0], var1.getY() - 1, var1.getZ() + var8[1], var1.getX() + var8[2], var1.getY() + 4, var1.getZ() + var8[3]).expand(0.002)
         );
      }

      return var3;
   }

   private int[][] I_method_98513557(int var1) {
      return switch (var1) {
         case 1 -> new int[][]{{-4, 0, -3, 1}, {-3, 1, -2, 2}, {-2, 2, -1, 3}, {-1, 3, 0, 4}, {0, 4, 1, 5}};
         default -> new int[0][0];
         case 3 -> new int[][]{{0, -4, 1, -3}, {-1, -3, 0, -2}, {-2, -2, -1, -1}, {-3, -1, -2, 0}, {-4, 0, -3, 1}};
         case 5 -> new int[][]{{4, 0, 5, 1}, {3, -1, 4, 0}, {2, -2, 3, -1}, {1, -3, 2, -2}, {0, -4, 1, -3}};
         case 7 -> new int[][]{{0, 4, 1, 5}, {1, 3, 2, 4}, {2, 2, 3, 3}, {3, 1, 4, 2}, {4, 0, 5, 1}};
      };
   }

   private boolean I_method_3d907c34(List<Box> var1, float var2) {
      for (AbstractClientPlayerEntity var4 : I_field_3a9bda27.world.getPlayers()) {
         if (var4 != I_field_3a9bda27.player
            && var4.isAlive()
            && !RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var4.getName().getString())) {
            Vec3d var5 = iIiiiiIII_Class377.I_method_689b1a13(var4, var2);
            Box var6 = var4.getBoundingBox().offset(var5.subtract(var4.getPos()));

            for (Box var8 : var1) {
               if (var8.intersects(var6)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean i_method_34de1925(double var1, double var3, float var5) {
      BlockPos var6 = I_field_3a9bda27.player.getBlockPos();
      Vec3d var7 = new Vec3d(var6.getX() + 0.5, var6.getY(), var6.getZ() + 0.5);
      return this.I_method_9c9b4d19(var7, var1, var3, var5);
   }

   private boolean I_method_9c9b4d19(Vec3d var1, double var2, double var4, float var6) {
      double var7 = var2 * var2;

      for (AbstractClientPlayerEntity var10 : I_field_3a9bda27.world.getPlayers()) {
         if (var10 != I_field_3a9bda27.player
            && var10.isAlive()
            && !RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var10.getName().getString())) {
            Vec3d var11 = iIiiiiIII_Class377.I_method_689b1a13(var10, var6);
            Box var12 = var10.getBoundingBox().offset(var11.subtract(var10.getPos()));
            double var13 = Math.clamp(var1.x, var12.minX, var12.maxX);
            double var15 = Math.clamp(var1.z, var12.minZ, var12.maxZ);
            boolean var17 = var12.maxY >= var1.y && var12.minY <= var1.y + var4;
            if (var17 && new Vec3d(var13, var1.y, var15).squaredDistanceTo(var1) <= var7) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean I_method_9ee39d94(List<Box> var1) {
      for (Box var3 : var1) {
         if (!I_field_3a9bda27.world.getFluidState(BlockPos.ofFloored(var3.getCenter())).isEmpty()) {
            return true;
         }
      }

      return false;
   }

   private void I_method_1d765815(boolean var1) {
      RenderSystem.enableBlend();
      if (!var1 && !I_field_3a9bda27.player.isTouchingWater()) {
         RenderSystem.enableDepthTest();
      } else {
         RenderSystem.disableDepthTest();
      }

      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
   }

   private void I_method_74902e9f() {
      RenderSystem.defaultBlendFunc();
      RenderSystem.depthMask(true);
      RenderSystem.enableDepthTest();
      RenderSystem.enableCull();
      RenderSystem.disableBlend();
   }

   private void I_method_14404570(BufferBuilder var1) {
      BuiltBuffer var2 = var1.endNullable();
      if (var2 != null) {
         BufferRenderer.drawWithGlobalProgram(var2);
      }
   }

   private List<IiIiIiIII_Class169> I_method_696cb1c8() {
      return List.of(
         iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c) && !iIIIiiiII_Class285.I_method_dbbac60d("holytime")
            ? new IiIiIiIII_Class169(Items.POPPED_CHORUS_FRUIT, -1)
            : new IiIiIiIII_Class169(Items.NETHERITE_SCRAP, -1),
         new IiIiIiIII_Class169(Items.ENDER_EYE, -1),
         new IiIiIiIII_Class169(Items.SUGAR, -1)
      );
   }

   private List<IiIiIiIII_Class169> I_method_ad0c340(AssistModule var1) {
      HashMap var2 = new HashMap();

      for (iIiIIiII_Class165 var4 : var1.II_method_6ba8ace5()) {
         if (var4.I_method_75fee910()) {
            int var5 = var4.I_method_75fee8ff();
            if (var5 != -1) {
               Item var6 = var4.I_method_db7f702c().getItem();
               var2.put(var5, new IiIiIiIII_Class169(var6, var5));
            }
         }
      }

      ArrayList var7 = new ArrayList(var2.values());
      HashSet var8 = new HashSet();

      for (IiIiIiIII_Class169 var10 : (Iterable<IiIiIiIII_Class169>)(Iterable<?>)var7) {
         var8.add(var10.I_method_ad8357d5());
      }

      this.I_method_f8a4af2f(var7, var8);
      return var7;
   }

   private void I_method_f8a4af2f(List<IiIiIiIII_Class169> var1, Set<Item> var2) {
      if (I_field_3a9bda27.player != null) {
         ItemCooldownManagerAccessor var3 = (ItemCooldownManagerAccessor)(Object)I_field_3a9bda27.player.getItemCooldownManager();

         for (Identifier var5 : var3.rockstar$getEntries().keySet()) {
            Item var6 = (Item)Registries.ITEM.get(var5);
            this.I_method_b2f29b37(var1, var2, var6);
         }

         for (int var7 = 0; var7 < I_field_3a9bda27.player.getInventory().size(); var7++) {
            this.I_method_864a4c51(var1, var2, I_field_3a9bda27.player.getInventory().getStack(var7));
         }

         this.I_method_864a4c51(var1, var2, I_field_3a9bda27.player.getOffHandStack());
      }
   }

   private void I_method_864a4c51(List<IiIiIiIII_Class169> var1, Set<Item> var2, ItemStack var3) {
      if (var3 != null && !var3.isEmpty()) {
         if (I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(var3)) {
            this.I_method_b2f29b37(var1, var2, var3.getItem());
         }
      }
   }

   private void I_method_b2f29b37(List<IiIiIiIII_Class169> var1, Set<Item> var2, Item var3) {
      if (var3 != Items.AIR && !var2.contains(var3)) {
         if (!(this.I_method_84b859b7(var3) <= 0.0F)) {
            if (this.I_method_84b859cb(var3)) {
               var1.add(new IiIiIiIII_Class169(var3, -1));
               var2.add(var3);
            }
         }
      }
   }

   private boolean I_method_84b859cb(Item var1) {
      if (I_field_3a9bda27.player == null) {
         return false;
      } else {
         for (int var2 = 0; var2 < I_field_3a9bda27.player.getInventory().size(); var2++) {
            if (I_field_3a9bda27.player.getInventory().getStack(var2).getItem() == var1) {
               return true;
            }
         }

         return I_field_3a9bda27.player.getOffHandStack().getItem() == var1;
      }
   }

   private void I_method_36481d8(III var1, List<IiIiIiIII_Class169> var2) {
      IIiIIi_Class10 var3 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F);
      byte var4 = 18;
      int var5 = Math.min((int)this.I_field_73178e8c.Ii_method_a20abcd2(), var2.size());
      int var6 = (var2.size() + var5 - 1) / var5;
      this.width = var5 * 26 - 5;
      this.height = var6 * 32 - 4;
      ArrayList var7 = new ArrayList(var2.size());

      for (int var8 = 0; var8 < var2.size(); var8++) {
         int var9 = var8 % var5;
         int var10 = var8 / var5;
         float var11 = var9 * 26;
         float var12 = var10 * 32;
         float var13 = this.x + var11;
         float var14 = this.y + var12;
         float var15 = var13 + 3.0F;
         float var16 = var14 + 3.5F;
         IiIiIiIII_Class169 var17 = (IiIiIiIII_Class169)var2.get(var8);
         var1.drawClientRect(
            var13,
            var14,
            22.0F,
            23.0F,
            255.0F * this.animation.I_method_6ac4da6f() * InterfaceModule.I_method_fdcdb22f(),
            this.dragAnim.I_method_6ac4da6f(),
            7.0F,
            4.0F
         );
         float var18 = this.I_method_1d761834(var17.I_method_a12db292());
         var7.add(new IiIiIiIii_Class172.Nested1_a49b4be0(var17.I_method_ad8357d5().getDefaultStack(), var15, var16, var18));
      }

      try (CustomDrawContext.Nested1_f061f568 var25 = var1.beginItemBatch()) {
         for (IiIiIiIii_Class172.Nested1_a49b4be0 var29 : (Iterable<IiIiIiIii_Class172.Nested1_a49b4be0>)(Iterable<?>)var7) {
            iIiiiIIiI_Class371.II_method_e18635ac(
               var1.getMatrices(), var29.I_method_80a323ca() + 8.0F, var29.i_method_80b1afaa() + 8.0F, var29.II_method_93d04eb7()
            );
            var1.drawBatchItem(var29.I_method_ad2f901e(), var29.I_method_80a323ca(), var29.i_method_80b1afaa(), 80);
            iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
         }
      }

      this.I_method_692c2c2b(var1, var2, var5);
      iiIIIIIii_Class388 var26 = new iiIIIIIii_Class388(VertexFormats.POSITION_COLOR, var1.getMatrices());
      this.I_method_50b1f00c(var1, var2, var4, var3);
      var26.II_method_ed687102();
      iiIIIIIIi_Class386 var28 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, IIiIiI_Class11.i_field_857c0621);
      this.I_method_211f4eb9(var1, var2, var3);
      var28.II_method_ed687102();

      for (int var30 = 0; var30 < var2.size(); var30++) {
         int var31 = var30 % var5;
         int var32 = var30 / var5;
         float var33 = var31 * 26;
         float var34 = var32 * 32;
         float var35 = this.x + var33 + 3.0F;
         float var36 = this.y + var34 + 3.5F;
         float var37 = 14.0F;
         IiIiIiIII_Class169 var38 = (IiIiIiIII_Class169)var2.get(var30);
         if (I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(var38.I_method_ad8357d5().getDefaultStack())) {
            float var19 = I_field_3a9bda27.player
               .getItemCooldownManager()
               .getCooldownProgress(var38.I_method_ad8357d5().getDefaultStack(), I_field_3a9bda27.getRenderTickCounter().getTickDelta(true));
            float var20 = var35 + 8.0F;
            float var21 = var36 + 8.0F;
            float var22 = var37 / 3.0F;
            var1.drawCircleProgress(var20, var21, var22, 1.35F, 0.999F, IiiiiIIIi_Class242.IiI_field_d0c8ec5.mulAlpha(1.0F));
            var1.drawCircleProgress(var20, var21, var22, 1.35F, Math.clamp(var19, 0.0F, 1.0F), IiiiiIIIi_Class242.i_method_5dfec6e());
         }
      }
   }

   private void I_method_692c2c2b(III var1, List<IiIiIiIII_Class169> var2, int var3) {
      if (I_field_3a9bda27.player != null) {
         for (int var4 = 0; var4 < var2.size(); var4++) {
            IiIiIiIII_Class169 var5 = (IiIiIiIII_Class169)var2.get(var4);
            if (I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(var5.I_method_ad8357d5().getDefaultStack())) {
               int var6 = var4 % var3;
               int var7 = var4 / var3;
               float var8 = this.x + var6 * 26 + 3.0F;
               float var9 = this.y + var7 * 32 + 3.5F;
               float var10 = 16.0F;
               float var11 = Math.clamp(
                  I_field_3a9bda27.player
                     .getItemCooldownManager()
                     .getCooldownProgress(var5.I_method_ad8357d5().getDefaultStack(), I_field_3a9bda27.getRenderTickCounter().getTickDelta(true)),
                  0.0F,
                  1.0F
               );
               float var12 = var9 + var10 * (1.0F - var11);
               float var13 = var10 * var11;
               var1.drawRoundedRect(
                  var8, var12, var10, var13, IIiii_Class8.I_method_893b2757(3.0F), ColorRGBA.BLACK.mulAlpha(0.48F * this.animation.I_method_6ac4da6f())
               );
            }
         }
      }
   }

   private void I_method_211f4eb9(III var1, List<IiIiIiIII_Class169> var2, IIiIIi_Class10 var3) {
      byte var4 = 18;
      int var5 = Math.min((int)this.I_field_73178e8c.Ii_method_a20abcd2(), var2.size());

      for (int var6 = 0; var6 < var2.size(); var6++) {
         int var7 = var6 % var5;
         int var8 = var6 / var5;
         float var9 = var7 * 26;
         float var10 = var8 * 32;
         float var11 = this.x + var9 + 3.5F;
         float var12 = this.y + var10 + 3.0F;
         IiIiIiIII_Class169 var13 = (IiIiIiIII_Class169)var2.get(var6);
         float var14 = this.I_method_84b859b7(var13.I_method_ad8357d5());
         boolean var15 = var14 > 0.0F;
         String var16;
         if (var15) {
            var16 = String.format("%.1f", var14);
         } else {
            if (var13.I_method_a12db292() == -1) {
               continue;
            }

            var16 = this.I_method_ea76ecdc(var13.I_method_a12db292());
            if (var16.length() > 3) {
               var16 = var16.substring(0, 3);
            }
         }

         float var17 = this.I_method_914bfacf(var11, var3.I_method_2c375926(var16));
         float var18 = this.I_method_914c0612(var12, var4);
         var1.drawText(var3, var16, var17 + 2.0F, var18 + Math.round((8.0F - var3.I_method_a649725c()) / 2.0F), IiiiiIIIi_Class242.III_method_e0a940ee());
      }
   }

   private float I_method_1d760cf1(float var1) {
      return Math.round(var1 / 2.0F) * 2.0F + 4.0F;
   }

   private float I_method_914bfacf(float var1, float var2) {
      return Math.round(var1 + 7.5F - this.I_method_1d760cf1(var2) / 2.0F);
   }

   private float I_method_914c0612(float var1, int var2) {
      return Math.round(var1 + var2 - 1.0F);
   }

   private void I_method_50b1f00c(III var1, List<IiIiIiIII_Class169> var2, int var3, IIiIIi_Class10 var4) {
      int var5 = Math.min((int)this.I_field_73178e8c.Ii_method_a20abcd2(), var2.size());

      for (int var6 = 0; var6 < var2.size(); var6++) {
         int var7 = var6 % var5;
         int var8 = var6 / var5;
         float var9 = var7 * 26;
         float var10 = var8 * 32;
         float var11 = this.x + var9 + 3.5F;
         float var12 = this.y + var10 + 3.0F;
         IiIiIiIII_Class169 var13 = (IiIiIiIII_Class169)var2.get(var6);
         float var14 = this.I_method_84b859b7(var13.I_method_ad8357d5());
         boolean var15 = var14 > 0.0F;
         String var16;
         if (var15) {
            var16 = String.format("%.1f", var14);
         } else {
            if (var13.I_method_a12db292() == -1) {
               continue;
            }

            var16 = this.I_method_ea76ecdc(var13.I_method_a12db292());
            if (var16.length() > 3) {
               var16 = var16.substring(0, 3);
            }
         }

         float var17 = var4.I_method_2c375926(var16);
         var1.drawRoundedRect(
            this.I_method_914bfacf(var11, var17),
            this.I_method_914c0612(var12, var3),
            this.I_method_1d760cf1(var17),
            8.0F,
            IIiii_Class8.I_method_893b2757(1.0F),
            IiiiiIIIi_Class242.i_method_5dfec6e()
         );
      }
   }

   private float I_method_84b859b7(Item var1) {
      if (I_field_3a9bda27.player == null) {
         return 0.0F;
      } else {
         ItemCooldownManagerAccessor var2 = (ItemCooldownManagerAccessor)(Object)I_field_3a9bda27.player.getItemCooldownManager();
         Identifier var3 = var2.rockstar$getGroup(var1.getDefaultStack());
         Object var4 = var2.rockstar$getEntries().get(var3);
         if (var4 == null) {
            return 0.0F;
         } else {
            int var5 = ((ItemCooldownEntryAccessor)(Object)var4).rockstar$getEndTick() - var2.rockstar$getTick();
            return Math.max(0.0F, var5 / 20.0F);
         }
      }
   }

   private String I_method_ea76ecdc(int var1) {
      if (iIIIIIIII_Class257.I_method_4da58c8(var1)) {
         int var2 = iIIIIIIII_Class257.I_method_4da58b7(var1) - 0 + 1;
         return iIIIIIIII_Class257.I_method_f90bbc5c(iIIIIIIII_Class257.i_method_69d48d7(var1)) + "M" + var2;
      } else {
         return iIIIIiIiI_Class267.I_method_a937749c(var1);
      }
   }

   private float I_method_1d761834(int var1) {
      if (var1 == -1) {
         return 1.0F;
      } else {
         boolean var2 = iIIIIIIII_Class257.I_method_4da58c8(var1);
         boolean var4 = this.I_method_1d761848(var1);
         IiiiIiIii_Class236 var3;
         if (var2) {
            var3 = this.i_field_a567c40b.computeIfAbsent(var1, var0 -> new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac));
         } else {
            var3 = this.I_field_a567c40b.computeIfAbsent(var1, var0 -> new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac));
         }

         var3.I_method_edd72835(var4);
         return 1.0F - 0.15F * var3.I_method_6ac4da6f();
      }
   }

   private boolean I_method_1d761848(int var1) {
      return iIIIIIIII_Class257.II_method_98333a25(var1);
   }

   static final class Nested1_a49b4be0 {
      private final ItemStack I_field_f2735522;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;

      Nested1_a49b4be0(ItemStack var1, float var2, float var3, float var4) {
         this.I_field_f2735522 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_a49b4be0[stack=" + this.I_field_f2735522 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", scale=" + this.II_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiIiIii_Class172.Nested1_a49b4be0 other = (IiIiIiIii_Class172.Nested1_a49b4be0) var1;
         return java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46);
      }

      public ItemStack I_method_ad2f901e() {
         return this.I_field_f2735522;
      }

      public float I_method_80a323ca() {
         return this.I_field_46;
      }

      public float i_method_80b1afaa() {
         return this.i_field_46;
      }

      public float II_method_93d04eb7() {
         return this.II_field_46;
      }
   }
}
