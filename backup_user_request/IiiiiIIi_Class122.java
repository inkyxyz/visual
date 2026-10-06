package rockstar.client;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.joml.Quaternionf;
import org.lwjgl.opengl.GL11;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

public class IiiiiIIi_Class122 extends IIiI_Class3 implements iIIiIIiIi_Class294, iIIiIIiiI_Class295, iIIiIIiii_Class296 {
   private static final float I_field_46 = 447.0F;
   private static final float i_field_46 = 223.0F;
   private static final float II_field_46 = 165.0F;
   private static final float Ii_field_46 = 13.0F;
   private static final int I_field_49 = 7;
   private static final int i_field_49 = 15728880;
   private static final float iI_field_46 = 288.0F;
   private static final float ii_field_46 = 142.0F;
   private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0F);
   private final iIiiI_Class23 I_field_6433b52c = iIiiI_Class23.I_method_e3b16f5();
   private IiiiiIiI_Class123 I_field_12aac7a1;
   private IiiiiIiI_Class123 i_field_12aac7a1;
   private IiiiiIII_Class121 I_field_12aa4f81;
   private IiiiIiii_Class120 I_field_10f66741;
   private int II_field_49;
   private int Ii_field_49;
   private boolean I_field_5a;
   private ZombieEntity I_field_ac3ceeb7;
   private ItemEntity I_field_e08508f9;
   private Entity I_field_77e0818c;
   private LivingEntity I_field_966247a3;
   private final IiiiIiIii_Class236 I_field_dc7facc;
   private boolean i_field_5a;
   private Entity i_field_77e0818c;
   private iii_Class8 I_field_b584628c;
   private iii_Class8 i_field_b584628c;
   private iii_Class8 II_field_b584628c;
   private KeybindSetting I_field_ba20522c;
   private static float III_field_46 = 45.0F;
   private static float IIi_field_46 = 0.0F;
   private static float IiI_field_46 = 50.0F;
   private static float Iii_field_46 = 0.0F;
   private float iII_field_46;
   private float iIi_field_46;
   private float iiI_field_46;
   private boolean II_field_5a;
   private int iI_field_49;
   private int ii_field_49;
   private float iii_field_46;
   private float IIII_field_46;
   private float IIIi_field_46;
   private float IIiI_field_46;
   private final IiiiIiIii_Class236 i_field_dc7facc;
   private final IiiiIiIii_Class236 II_field_dc7facc;
   private final IiiiIiIii_Class236 Ii_field_dc7facc;
   private final IiiiIiIii_Class236 iI_field_dc7facc;
   private final IiiiIiIii_Class236 ii_field_dc7facc;
   private static final float IIii_field_46 = 300.0F;
   private float IiII_field_46;
   private long I_field_4a;

   public IiiiiIIi_Class122() {
      this.I_field_12aac7a1 = IiiiiIiI_Class123.I_field_12aac7a1;
      this.i_field_12aac7a1 = IiiiiIiI_Class123.I_field_12aac7a1;
      this.I_field_12aa4f81 = IiiiiIII_Class121.I_field_12aa4f81;
      this.I_field_10f66741 = IiiiIiii_Class120.i_field_10f66741;
      this.I_field_dc7facc = new IiiiIiIii_Class236(400L, 1.0F, IiiiIiiII_Class237.IIIi_field_dd60aac);
      this.i_field_5a = true;
      this.i_field_77e0818c = null;
      this.iII_field_46 = 45.0F;
      this.iIi_field_46 = 0.0F;
      this.iiI_field_46 = 0.0F;
      this.II_field_5a = false;
      this.i_field_dc7facc = new IiiiIiIii_Class236(400L, IiiiIiiII_Class237.I_field_dd60aac);
      this.II_field_dc7facc = new IiiiIiIii_Class236(400L, IiiiIiiII_Class237.I_field_dd60aac);
      this.Ii_field_dc7facc = new IiiiIiIii_Class236(400L, 200.0F, IiiiIiiII_Class237.I_field_dd60aac);
      this.iI_field_dc7facc = new IiiiIiIii_Class236(400L, 50.0F, IiiiIiiII_Class237.I_field_dd60aac);
      this.ii_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.I_field_dd60aac);
   }

   @Compile(
      obfuscation = 4
   )
   @Override
   public void init() {
      super.init();
      this.clearRoots();
      this.I_field_6433b52c.I_method_716dedf();
      this.i_field_b584628c = new iii_Class8().I_method_485bccf5().I_method_70a38517(4.0F).IIi_method_4dfc88d7(142.0F);
      this.II_field_b584628c = new iii_Class8().I_method_485bccf5().I_method_70a38517(4.0F).IIi_method_4dfc88d7(142.0F);
      this.I_field_b584628c = new iii_Class8()
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(288.0F)
         .Ii_method_bb38d618()
         .I_method_b65baecb(
            var0 -> var0.i_method_65326e43(-5.0F)
               .I_method_4f0ff9cb(1.0F, 6.0F)
               .I_method_2a080a63(2.5F)
               .i_method_989a5f71(
                  var0x -> ColorRGBA.BLACK
                     .mix(ColorRGBA.WHITE, 0.3F)
                     .withAlpha(255.0F * (0.32F + 0.28F * var0x.I_method_af833bdc() + 0.3F * var0x.i_method_af91c7bc()))
               )
         )
         .I_method_8939bffd(
            new iii_Class8()
               .i_method_c88da8d5()
               .I_method_70a38517(4.0F)
               .III_method_9dc17555()
               .I_method_8939bffd(this.i_field_b584628c)
               .I_method_8939bffd(this.II_field_b584628c)
         );
      this.I_field_b584628c.snapSize();
      this.add(this.I_field_b584628c);
      this.I_method_10c760ac();
   }

   private void I_method_10c760ac() {
      List var1 = this.I_method_ea13841b();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var1.size(); var4++) {
         (var4 % 2 == 0 ? var2 : var3).add(this.I_method_b0e8c7c3((IiiiIiiI_Class119)var1.get(var4)));
      }

      this.i_field_b584628c.II_method_244860a9(var2);
      this.II_field_b584628c.II_method_244860a9(var3);
      this.I_field_b584628c.i_method_815a851f();
   }

   private iii_Class8 I_method_b0e8c7c3(IiiiIiiI_Class119 var1) {
      BooleanSetting var2 = this.I_method_cd5c2a43(var1);
      KeybindSetting var3 = this.I_method_cd5bb223(var1);
      Iii_Class4 var4 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F),
            () -> var3 == null ? "" : iIIIIiIiI_Class267.I_method_a937749c(var3.I_method_fa6281d2()),
            var2x -> (var3 != null && this.I_field_ba20522c == var3 ? IiiiiIIIi_Class242.ii_field_d0c8ec5 : IiiiiIIIi_Class242.iII_field_d0c8ec5)
               .mulAlpha(0.75F)
         )
         .textInset(3.0F)
         .height(10.0F)
         .radius(2.5F)
         .background(var0 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5)
         .visibleWhen(() -> var3 != null && var3.I_method_fa6281d2() != -1)
         .interactive(false);
      iii_Class8 var5 = new iii_Class8()
         .IiI_method_31d4c97(18.0F)
         .I_method_70a38517(5.0F)
         .I_method_3301fdd(iII_Class5.II_field_b583e68c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
         .III_method_9dc17555()
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(
            new iiII_Class13(
                  IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
                  () -> var3 != null && this.I_field_ba20522c == var3
                     ? (
                        iIIIIIIII_Class257.I_method_e761de12() != 0
                           ? iIIIIIIII_Class257.I_method_f90bbc5c(iIIIIIIII_Class257.I_method_e761de12()) + "..."
                           : IiIiIIII_Class81.I_method_f25a980a("menu.binding")
                     )
                     : (var2 == null ? var1.I_method_4b007174() : IiIiIIII_Class81.I_method_f25a980a(var2.getName()))
               )
               .I_method_6da713d1(
                  var2x -> (var3 != null && this.I_field_ba20522c == var3 ? IiiiiIIIi_Class242.ii_field_d0c8ec5 : IiiiiIIIi_Class242.iII_field_d0c8ec5)
                     .mulAlpha(0.75F + 0.25F * var2x.hover())
               )
               .I_method_c8e402a3(0.75F)
               .fill()
         )
         .I_method_8939bffd(var4)
         .I_method_8939bffd(
            new IIiiI_Class7(() -> var2 != null && var2.i_method_9b12da03())
               .i_method_c4678f15(() -> IiiiiIIIi_Class242.IIi_field_d0c8ec5)
               .size(13.0F, 8.0F)
               .minSize(13.0F, 8.0F)
               .snapSize()
               .transition(IiiI_Class7.I_field_f94500c1)
         )
         .I_method_b60c4df8((var3x, var4x, var5x) -> {
            if (var3x == IiIII_Class9.I_field_2f4c8d6c) {
               if (var2 != null) {
                  var2.toggle();
               }

               if (this.I_field_ba20522c == var3) {
                  this.I_field_ba20522c = null;
               }
            } else if (var3 != null) {
               this.I_field_ba20522c = this.I_field_ba20522c == var3 ? null : var3;
            }
         });
      iii_Class8 var6 = new iii_Class8().I_method_485bccf5().III_method_9dc17555();

      for (Setting var8 : this.I_method_5c74f9a(var1)) {
         var6.I_method_8939bffd(IiiIiiIIi_Class218.I_method_83bcc05d(var8));
      }

      return new iii_Class8()
         .I_method_485bccf5()
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(3.0F, 0.0F, 3.0F, 0.0F))
         .II_method_77bdb679(IIii_Class4.I_method_48883e1f(60L))
         .I_method_f136b1d8(
            (var1x, var2x) -> {
               var1x.drawRoundedRect(
                  var2x.x(), var2x.y(), var2x.w(), var2x.h(), IIiii_Class8.I_method_893b2757(5.0F), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.3F)
               );
               if (var1 instanceof iIIIIIIi_Class130) {
                  iIIIIIIi_Class130.i_method_594793a8(var2x.hover() > 0.05F);
               }
            }
         )
         .I_method_8939bffd(var5)
         .I_method_8939bffd(var6);
   }

   public void tick() {
      GuiMoveModule.iII_method_9983ebf();
      if (!this.II_field_5a && this.iIi_field_46 != 0.0F) {
         this.iIi_field_46 *= 0.85F;
         if (Math.abs(this.iIi_field_46) < 0.5F) {
            this.iIi_field_46 = 0.0F;
         }
      }

      this.iiI_field_46 += 3.0F;
      if (this.iiI_field_46 >= 360.0F) {
         this.iiI_field_46 -= 360.0F;
      }

      super.tick();
   }

   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (this.I_field_ba20522c != null && var5 != IiIII_Class9.I_field_2f4c8d6c) {
         this.I_field_ba20522c.I_method_51ee2d04(iIIIIIIII_Class257.Ii_method_99f62a34(var5.I_method_6d899712()));
         this.I_field_ba20522c = null;
      } else {
         if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
            this.I_field_5a = true;
            if (this.I_method_fc7eddb0((float)var1, (float)var3)) {
               this.II_field_5a = true;
               this.iI_field_49 = (int)var1;
               this.ii_field_49 = (int)var3;
            }
         }

         super.onMouseClicked(var1, var3, var5);
      }
   }

   @Override
   public void onMouseReleased(double var1, double var3, IiIII_Class9 var5) {
      if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
         this.II_field_5a = false;
      }

      super.onMouseReleased(var1, var3, var5);
   }

   private void I_method_fc80460c(int var1, int var2) {
      if (this.II_field_5a) {
         float var3 = var1 - this.iI_field_49;
         float var4 = var2 - this.ii_field_49;
         this.iII_field_46 -= var3 * 1.5F;
         this.iIi_field_46 -= var4 * 0.3F;
         this.iIi_field_46 = Math.max(-60.0F, Math.min(60.0F, this.iIi_field_46));
         this.iI_field_49 = var1;
         this.ii_field_49 = var2;
      }
   }

   private boolean I_method_fc7eddb0(float var1, float var2) {
      return var1 >= this.iii_field_46
         && var1 <= this.iii_field_46 + this.IIIi_field_46
         && var2 >= this.IIII_field_46
         && var2 <= this.IIII_field_46 + this.IIiI_field_46;
   }

   @Override
   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
      if (this.I_field_ba20522c == null && !iiiI_Class15.i_method_d4e71010()) {
         if (Screen.hasControlDown() && keyCode == 90 && IIiiiIIIi_Class114.I_method_fe3ce603()) {
            return true;
         }

         if (Screen.hasControlDown() && keyCode == 89 && IIiiiIIIi_Class114.i_method_fe4b71e3()) {
            return true;
         }
      }

      return this.I_method_fc804610(keyCode, modifiers) ? true : super.keyPressed(keyCode, scanCode, modifiers);
   }

   @Override
   public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
      if (this.I_field_ba20522c != null) {
         int var4 = iIIIIIIII_Class257.II_method_6e347cf5(keyCode, modifiers);
         if (var4 != Integer.MIN_VALUE) {
            this.I_field_ba20522c.I_method_51ee2d04(var4);
            this.I_field_ba20522c = null;
            return true;
         }
      }

      return super.keyReleased(keyCode, scanCode, modifiers);
   }

   private boolean I_method_fc804610(int var1, int var2) {
      if (this.I_field_ba20522c == null) {
         return false;
      } else {
         if (var1 != 256 && var1 != 261) {
            int var3 = iIIIIIIII_Class257.i_method_cd0c4692(var1, var2);
            if (var3 == Integer.MIN_VALUE) {
               return true;
            }

            this.I_field_ba20522c.I_method_51ee2d04(var3);
         } else {
            this.I_field_ba20522c.I_method_51ee2d04(-1);
         }

         this.I_field_ba20522c = null;
         return true;
      }
   }

   private void i_method_10d5ec8c() {
      long var1 = System.currentTimeMillis();
      float var3 = this.I_field_4a == 0L ? 16.0F : Math.min(64.0F, (float)(var1 - this.I_field_4a));
      this.I_field_4a = var1;
      MenuModule var4 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
      int var5 = var4 != null && var4.I_method_20c0695() != null ? var4.I_method_20c0695().I_method_fa6281d2() : -1;
      float var6 = I_method_82527db(var5) ? 1.0F : 0.0F;
      float var7 = var3 / 300.0F;
      if (this.IiII_field_46 < var6) {
         this.IiII_field_46 = Math.min(var6, this.IiII_field_46 + var7);
      } else if (this.IiII_field_46 > var6) {
         this.IiII_field_46 = Math.max(var6, this.IiII_field_46 - var7);
      }

      this.contentAlpha = 1.0F - IiiiIiiII_Class237.III_field_dd60aac.ease(this.IiII_field_46, 0.0F, 1.0F, 1.0F);
   }

   private static boolean I_method_82527db(int var0) {
      return iIIIIIIII_Class257.II_method_98333a25(var0);
   }

   @Override
   public void render(III var1) {
      this.i_method_10d5ec8c();
      this.II_field_49 = var1.I_method_b1c3e152();
      this.Ii_field_49 = var1.i_method_b1d26d32();
      this.I_method_fc80460c(this.II_field_49, this.Ii_field_49);
      float var2 = I_field_73c6d26c.I_method_804ee20f() / 2.0F - 223.5F;
      float var3 = I_field_73c6d26c.i_method_805d6def() / 2.0F - 111.5F;
      boolean var4 = this.contentAlpha > 0.01F;
      if (var4) {
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.contentAlpha);
      }

      if (var4) {
         this.I_method_7df30dfa(var1, var2, var3, 302.0F, 223.0F);
      }

      iIIIIIIi_Class130 var5 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIIi_Class130.class);
      boolean var6 = this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1
         && this.I_field_12aa4f81 == IiiiiIII_Class121.II_field_12aa4f81
         && var5 != null
         && var5.i_method_3cafb4b0()
         && iIIIIIIi_Class130.Ii_method_57a173f9();
      this.i_field_dc7facc.I_method_edd72835(var6);
      float var7 = 1.8F;
      Entity var8 = this.I_method_feaea4e2();
      float var9 = var8 != null ? var8.getHeight() : var7;
      float var10 = var9 / var7;
      float var11 = 200.0F;
      float var12 = var6 ? 223.0F : var11 * var10;
      if (this.I_field_12aac7a1 == IiiiiIiI_Class123.II_field_12aac7a1) {
         var12 += 50.0F;
      }

      if (this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1) {
         var12 += 100.0F;
      }

      this.II_field_dc7facc.I_method_edd6dd11(var6 ? 1.4F : (this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1 ? 0.3F : 0.0F));
      this.Ii_field_dc7facc.I_method_edd6dd11(var12);
      float var13 = 132.0F;
      float var14 = var13 + 20.0F;
      float var15 = var13 + (var14 - var13) * this.i_field_dc7facc.I_method_6ac4da6f();
      float var16 = this.Ii_field_dc7facc.I_method_6ac4da6f();
      float var17 = this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1 ? 70.0F : 50.0F;
      this.iI_field_dc7facc.I_method_edd6dd11(var17);
      int var18 = (int)this.iI_field_dc7facc.I_method_6ac4da6f();
      if (var4) {
         this.I_method_7df30dfa(var1, var2 + 245.0F + 65.0F, var3, var15, var16);
      }

      this.iii_field_46 = var2 + 245.0F + 65.0F;
      this.IIII_field_46 = var3;
      this.IIIi_field_46 = var15;
      this.IIiI_field_46 = var16;
      float var19 = this.II_field_dc7facc.I_method_6ac4da6f();
      if (var4) {
         iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), this.iii_field_46, this.IIII_field_46, var15, var16);
         this.I_method_a914d557(var1, (int)this.iii_field_46, (int)this.IIII_field_46, (int)var15, (int)var16, var18, var19);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.contentAlpha);
         this.I_method_833d46ba(var1, (int)this.iii_field_46, (int)this.IIII_field_46, (int)var15, (int)var16);
         iIiiiIiII_Class373.I_method_ff80a1df();
         this.I_method_2874c7a(var1, var2, var3);
      }

      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      this.ii_field_dc7facc.I_method_edd6dd11(this.I_field_12aac7a1.I_method_76f3b4f0() ? 1.0F : 0.0F);
      float var20 = var3 + 24.0F + 16.0F * this.ii_field_dc7facc.I_method_6ac4da6f();
      float var21 = 185.0F - 10.0F * this.ii_field_dc7facc.I_method_6ac4da6f();
      this.I_field_b584628c.snapAt(var2 + 7.0F, var20);
      this.I_field_b584628c.IiI_method_31d4c97(var21);
      super.render(var1);
      this.I_field_5a = false;
   }

   private boolean I_method_d84b1ab0(float var1, float var2, float var3, float var4) {
      return this.II_field_49 >= var1 && this.II_field_49 <= var1 + var3 && this.Ii_field_49 >= var2 && this.Ii_field_49 <= var2 + var4;
   }

   private void I_method_2874c7a(III var1, float var2, float var3) {
      float var4 = var2 + 7.0F;
      float var5 = var3 + 7.0F;

      for (IiiiiIiI_Class123 var9 : IiiiiIiI_Class123.values()) {
         var4 = this.I_method_25f1a1fe(var1, var4, var5, var9.i_method_933fe554(), this.I_field_12aac7a1 == var9, () -> {
            if (this.I_field_12aac7a1 != var9) {
               this.i_field_77e0818c = this.I_method_feaea4e2();
               this.i_field_5a = var9.ordinal() > this.I_field_12aac7a1.ordinal();
               this.I_field_dc7facc.I_method_edd6dd21(0.0F);
               this.I_field_ba20522c = null;
               this.I_field_12aac7a1 = var9;
               if (var9 == IiiiiIiI_Class123.I_field_12aac7a1) {
                  this.I_field_12aa4f81 = IiiiiIII_Class121.I_field_12aa4f81;
               }

               if (var9 == IiiiiIiI_Class123.Ii_field_12aac7a1) {
                  this.I_field_10f66741 = IiiiIiii_Class120.i_field_10f66741;
               }

               this.I_method_10c760ac();
            }
         });
      }

      if (this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1) {
         var4 = var2 + 7.0F;
         var5 = var3 + 24.0F;

         for (IiiiiIII_Class121 var20 : IiiiiIII_Class121.values()) {
            var4 = this.I_method_25f1a1fe(var1, var4, var5, var20.i_method_130e0974(), this.I_field_12aa4f81 == var20, () -> {
               if (this.I_field_12aa4f81 != var20) {
                  this.I_field_ba20522c = null;
                  this.I_field_12aa4f81 = var20;
                  this.I_method_10c760ac();
               }
            });
         }
      } else if (this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1) {
         var4 = var2 + 7.0F;
         var5 = var3 + 24.0F;

         for (IiiiIiii_Class120 var21 : IiiiIiii_Class120.values()) {
            var4 = this.I_method_25f1a1fe(var1, var4, var5, var21.i_method_245249b4(), this.I_field_10f66741 == var21, () -> {
               if (this.I_field_10f66741 != var21) {
                  this.I_field_ba20522c = null;
                  this.I_field_10f66741 = var21;
                  this.I_method_10c760ac();
               }
            });
         }
      }
   }

   private float I_method_25f1a1fe(III var1, float var2, float var3, String var4, boolean var5, Runnable var6) {
      String var7 = IiIiIIII_Class81.I_method_f25a980a(var4);
      float var8 = IIiIiI_Class11.II_field_857c0621.I_method_c000b13a(var7, 7.0F);
      float var9 = var8 + 8.0F;
      boolean var10 = this.I_method_d84b1ab0(var2, var3, var9, 13.0F);
      float var11 = var5 ? 1.0F : (var10 ? 0.8F : 0.4F);
      var1.drawRoundedRect(var2, var3, var9, 13.0F, IIiii_Class8.I_method_893b2757(3.0F), IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(var11));
      var1.drawText(
         IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
         var7,
         var2 + 4.0F,
         var3 + 4.0F,
         var5 ? IiiiiIIIi_Class242.iI_method_8e08d3b1() : IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.75F)
      );
      if (var10 && this.I_field_5a) {
         var6.run();
      }

      return var2 + var9 + 4.0F;
   }

   private List<IiiiIiiI_Class119> I_method_ea13841b() {
      ArrayList var1 = new ArrayList();

      for (IiiiIiiI_Class119 var3 : IiiiiiiI_Class127.I_method_e1e653cb().I_method_6ddf4ffb()) {
         if (var3.I_method_bcf84b51(this.I_field_12aac7a1)
            && (this.I_field_12aac7a1 != IiiiiIiI_Class123.I_field_12aac7a1 || var3.I_method_bb355b31(this.I_field_12aa4f81))
            && (
               this.I_field_12aac7a1 != IiiiiIiI_Class123.Ii_field_12aac7a1
                  || (
                     var3.II_method_b2127764().isEmpty()
                        ? this.I_field_10f66741 == IiiiIiii_Class120.i_field_10f66741
                        : var3.I_method_56da82f1(this.I_field_10f66741)
                  )
            )) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private List<Setting> I_method_5c74f9a(IiiiIiiI_Class119 var1) {
      ArrayList var2 = new ArrayList();
      if (this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1) {
         var2.addAll(var1.I_method_9533177a(this.I_field_12aa4f81));
         var2.addAll(var1.I_method_896de35a(this.I_field_12aac7a1));
      } else if (this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !var1.II_method_b2127764().isEmpty()) {
         var2.addAll(var1.I_method_12177ba(this.I_field_10f66741));
         var2.addAll(var1.I_method_896de35a(this.I_field_12aac7a1));
      } else {
         var2.addAll(var1.i_method_dd86337a(this.I_field_12aac7a1));
         var2.addAll(var1.I_method_896de35a(this.I_field_12aac7a1));
      }

      return var2;
   }

   private BooleanSetting I_method_cd5c2a43(IiiiIiiI_Class119 var1) {
      if (this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1) {
         return var1.I_method_d00eb663(this.I_field_12aa4f81);
      } else {
         return this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !var1.II_method_b2127764().isEmpty()
            ? var1.I_method_cdcdae23(this.I_field_10f66741)
            : var1.I_method_6d27be83(this.I_field_12aac7a1);
      }
   }

   private KeybindSetting I_method_cd5bb223(IiiiIiiI_Class119 var1) {
      if (this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1) {
         return var1.I_method_d00e3e43(this.I_field_12aa4f81);
      } else {
         return this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !var1.II_method_b2127764().isEmpty()
            ? var1.I_method_cdcd3603(this.I_field_10f66741)
            : var1.I_method_6d274663(this.I_field_12aac7a1);
      }
   }

   private void I_method_a914d557(III var1, int var2, int var3, int var4, int var5, int var6, float var7) {
      this.I_field_dc7facc.I_method_edd6dd11(1.0F);
      float var8 = this.I_field_dc7facc.I_method_6ac4da6f();
      float var9 = var4 * 1.5F;
      if (var8 < 1.0F && this.i_field_77e0818c != null) {
         float var10 = this.i_field_5a ? -var9 * var8 : var9 * var8;
         this.I_method_b8e53191(var1, var2, var3, var4, var5, var6, var7, this.i_field_77e0818c, var10);
      }

      Entity var12 = this.I_method_feaea4e2();
      if (var12 != null) {
         float var11 = 0.0F;
         if (var8 < 1.0F) {
            var11 = this.i_field_5a ? var9 * (1.0F - var8) : -var9 * (1.0F - var8);
         }

         this.I_method_b8e53191(var1, var2, var3, var4, var5, var6, var7, var12, var11);
      }
   }

   private void I_method_b8e53191(III var1, int var2, int var3, int var4, int var5, int var6, float var7, Entity var8, float var9) {
      iIIIIIiI_Class131 var10 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
      boolean var11;
      if (var10 == null) {
         var11 = false;
      } else if (this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1) {
         var11 = var10.i_method_d0cacf11(this.I_field_12aa4f81);
      } else if (this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1) {
         var11 = var10.i_method_6c6ff6d1(this.I_field_10f66741);
      } else {
         var11 = var10.i_method_d28dbf31(this.I_field_12aac7a1);
      }

      float var12 = var2 + var4 / 2.0F + var9;
      float var13 = var3 + var5 / 2.0F;
      float var14 = var6;
      Quaternionf var15 = new Quaternionf().rotateZ((float) Math.PI);
      var15.rotateX((float)Math.toRadians(this.iIi_field_46));
      III_field_46 = this.iII_field_46;
      IIi_field_46 = this.iIi_field_46;
      IiI_field_46 = var14;
      Iii_field_46 = var7;
      if (var8 instanceof LivingEntity var16) {
         float[] var17 = this.I_method_c3ac6e90(var16);
         float var18 = 180.0F + this.iII_field_46;
         this.I_method_c3acd56f(var16, var18);
         if (this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1) {
            iIIIIIiI_Class131.I_method_1026af8d(this.I_field_12aa4f81);
         }

         if (this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1) {
            iIIIIIiI_Class131.I_method_abcbd74d(this.I_field_10f66741);
         }

         iIIIIIiI_Class131.I_method_11e99fad(this.I_field_12aac7a1);
         iIIIIIIi_Class130 var19 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIIi_Class130.class);
         boolean var20 = this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1
            && this.I_field_12aa4f81 == IiiiiIII_Class121.II_field_12aa4f81
            && var19 != null
            && var19.i_method_3cafb4b0()
            && iIIIIIIi_Class130.Ii_method_57a173f9();
         if (var20) {
            iIIIIIIi_Class130.I_method_5784a388(true);
         }

         this.I_method_17166b4f(var1.getMatrices(), var12, var13, var14, var15, var7, 1.0F, 0.0F, var8);
         if (var20) {
            iIIIIIIi_Class130.I_method_5784a388(false);
         }

         iIIIIIiI_Class131.I_method_11e99fad(null);
         iIIIIIiI_Class131.I_method_1026af8d(null);
         iIIIIIiI_Class131.I_method_abcbd74d(null);
         if (var11 && var9 == 0.0F) {
            this.I_method_edeffd33(var1, var12, var13, var14, var15, var7, var8);
         }

         this.I_method_b1f7cbfc(var16, var17);
      } else {
         Quaternionf var21 = new Quaternionf().rotateZ((float) Math.PI);
         var21.rotateY((float)Math.toRadians(this.iiI_field_46));
         this.I_method_17166b4f(var1.getMatrices(), var12, var13, var14, var21, var7, 1.0F, 0.0F, var8);
      }
   }

   private float[] I_method_c3ac6e90(LivingEntity var1) {
      return new float[]{var1.bodyYaw, var1.prevBodyYaw, var1.getYaw(), var1.prevYaw, var1.getPitch(), var1.prevPitch, var1.prevHeadYaw, var1.headYaw};
   }

   private void I_method_c3acd56f(LivingEntity var1, float var2) {
      var1.bodyYaw = var1.prevBodyYaw = var2;
      var1.setYaw(var2);
      var1.prevYaw = var2;
      var1.setPitch(0.0F);
      var1.prevPitch = 0.0F;
      var1.headYaw = var1.prevHeadYaw = var2;
   }

   private void I_method_b1f7cbfc(LivingEntity var1, float[] var2) {
      var1.bodyYaw = var2[0];
      var1.prevBodyYaw = var2[1];
      var1.setYaw(var2[2]);
      var1.prevYaw = var2[3];
      var1.setPitch(var2[4]);
      var1.prevPitch = var2[5];
      var1.prevHeadYaw = var2[6];
      var1.headYaw = var2[7];
   }

   private void I_method_edeffd33(III var1, float var2, float var3, float var4, Quaternionf var5, float var6, Entity var7) {
      boolean var8 = GL11.glIsEnabled(3089);
      if (var8) {
         GL11.glDisable(3089);
      }

      this.I_field_cb35e4c.I_method_53fdf4b5(true);
      if (var8) {
         GL11.glEnable(3089);
      }

      iIIIIIiI_Class131.I_field_5a = true;
      iIIIIIiI_Class131.I_field_77e0818c = var7;
      if (this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1) {
         iIIIIIiI_Class131.I_method_1026af8d(this.I_field_12aa4f81);
      }

      if (this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1) {
         iIIIIIiI_Class131.I_method_abcbd74d(this.I_field_10f66741);
      }

      iIIIIIiI_Class131.I_method_11e99fad(this.I_field_12aac7a1);
      this.I_method_17166b4f(var1.getMatrices(), var2, var3, var4, var5, var6, 1.0F, 0.0F, var7);
      iIIIIIiI_Class131.I_method_11e99fad(null);
      iIIIIIiI_Class131.I_method_1026af8d(null);
      iIIIIIiI_Class131.I_method_abcbd74d(null);
      iIIIIIiI_Class131.I_field_77e0818c = null;
      iIIIIIiI_Class131.I_field_5a = false;
      this.I_field_cb35e4c.i_method_766109df();
      iIIIIIiI_Class131 var9 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIIiI_Class131.class);
      this.I_field_6433b52c.i_method_dd886024((int)var9.I_method_363f3c2().Ii_method_a20abcd2());
      this.I_field_6433b52c.i_method_dd8854e1(7.0F);
      this.I_field_6433b52c.Ii_method_a06defbe(1.0F);
      this.I_field_6433b52c.II_method_9eaaff9e(1.0F);
      if (var8) {
         GL11.glDisable(3089);
      }

      this.I_field_6433b52c.I_method_6119a907(this.I_field_cb35e4c, -1, -1, -1, -1);
      if (var8) {
         GL11.glEnable(3089);
      }

      int var10 = this.I_field_6433b52c.I_method_716ded2();
      if (var10 != 0) {
         RenderSystem.setShaderTexture(0, var10);
         RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
         RenderSystem.enableBlend();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.contentAlpha);
         RenderSystem.blendFunc(SrcFactor.ONE, DstFactor.ONE);
         iIiiIIiii_Class360.I_method_4355d27f(0.0F, -0.5F, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
         iIiiIIiii_Class360.I_method_4355d27f(0.0F, -0.5F, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
         RenderSystem.depthMask(true);
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.disableDepthTest();
      }
   }

   private void I_method_833d46ba(III var1, int var2, int var3, int var4, int var5) {
      Entity var6 = this.I_method_feaea4e2();
      if (var6 != null) {
         float var7 = var2 + var4 / 2.0F;
         float var8 = var3 + var5 / 2.0F - 35.0F;

         for (IiiiIiiI_Class119 var10 : IiiiiiiI_Class127.I_method_e1e653cb().I_method_6ddf4ffb()) {
            if (var10.I_method_bcf84b51(this.I_field_12aac7a1)) {
               boolean var11;
               if (this.I_field_12aac7a1 == IiiiiIiI_Class123.I_field_12aac7a1) {
                  var11 = var10.i_method_d0cacf11(this.I_field_12aa4f81);
               } else if (this.I_field_12aac7a1 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !var10.II_method_b2127764().isEmpty()) {
                  var11 = var10.i_method_6c6ff6d1(this.I_field_10f66741);
               } else {
                  var11 = var10.i_method_d28dbf31(this.I_field_12aac7a1);
               }

               if (var11) {
                  var10.I_method_d9976c2e(var1, var6, var7, var8, this.I_field_12aac7a1, this.I_field_12aa4f81);
               }
            }
         }
      }
   }

   private Entity I_method_feaea4e2() {
      if (I_field_3a9bda27.world == null) {
         return null;
      } else {
         return (Entity)(switch (this.I_field_12aac7a1) {
            case I_field_12aac7a1 -> this.I_method_8a221279();
            case i_field_12aac7a1 -> this.I_method_d2cf5e8d();
            case II_field_12aac7a1 -> this.i_method_4b6a0c2();
            case Ii_field_12aac7a1 -> this.I_method_4245914f();
         });
      }
   }

   private LivingEntity I_method_8a221279() {
      if (this.I_field_966247a3 == null && I_field_3a9bda27.world != null) {
         GameProfile var1 = new GameProfile(UUID.randomUUID(), "Preview");
         OtherClientPlayerEntity var2 = new OtherClientPlayerEntity(I_field_3a9bda27.world, var1);
         var2.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
         var2.equipStack(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
         var2.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
         this.I_field_966247a3 = var2;
      }

      return this.I_field_966247a3;
   }

   private ZombieEntity I_method_d2cf5e8d() {
      if (this.I_field_ac3ceeb7 == null && I_field_3a9bda27.world != null) {
         this.I_field_ac3ceeb7 = new ZombieEntity(EntityType.ZOMBIE, I_field_3a9bda27.world);
      }

      return this.I_field_ac3ceeb7;
   }

   private Entity i_method_4b6a0c2() {
      if (this.I_field_77e0818c == null && I_field_3a9bda27.world != null) {
         this.I_field_77e0818c = new PigEntity(EntityType.PIG, I_field_3a9bda27.world);
      }

      return this.I_field_77e0818c;
   }

   private ItemEntity I_method_4245914f() {
      if (this.I_field_e08508f9 == null && I_field_3a9bda27.world != null) {
         this.I_field_e08508f9 = new ItemEntity(EntityType.ITEM, I_field_3a9bda27.world);
         this.I_field_e08508f9.setStack(new ItemStack(Items.NETHERITE_SWORD));
      }

      return this.I_field_e08508f9;
   }

   private void I_method_17166b4f(MatrixStack var1, float var2, float var3, float var4, Quaternionf var5, float var6, float var7, float var8, Entity var9) {
      var1.push();
      var1.translate(var2, var3, 50.0F);
      var1.scale(var4, var4, -var4);
      var1.multiply(var5);
      var1.translate(0.0F, -var9.getHeight() / 2.0F - var6 * var7, 0.0F);
      RenderSystem.disableDepthTest();
      RenderSystem.enableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.contentAlpha);
      EntityRenderDispatcher var10 = I_field_3a9bda27.getEntityRenderDispatcher();
      Immediate var11 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
      EntityRenderer var12 = var10.getRenderer(var9);

      try {
         var10.render(var9, 0.0, 0.0, 0.0, var8, var1, var11, 15728880, var12);
         var11.draw();
      } catch (Exception var14) {
      }

      RenderSystem.enableDepthTest();
      var1.pop();
   }

   private void I_method_7df30dfa(III var1, float var2, float var3, float var4, float var5) {
      var1.drawShadow(var2, var3, var4, var5, 25.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F));
      var1.drawBlurredRect(var2, var3, var4, var5, 5.0F, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
      var1.drawSquircle(var2, var3, var4, var5, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.III_field_d0c8ec5);
      var1.drawSquircleBorder(var2, var3, var4, var5, 0.5F, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.IiI_field_d0c8ec5);
   }

   public void close() {
      this.I_field_ba20522c = null;
      super.close();
      MenuModule.IiI_method_c56c3e7f();
   }

   @Generated
   public static float I_method_10c7609c() {
      return III_field_46;
   }

   @Generated
   public static float i_method_10d5ec7c() {
      return IIi_field_46;
   }

   @Generated
   public static float II_method_833ac25() {
      return IiI_field_46;
   }

   @Generated
   public static float Ii_method_8423805() {
      return Iii_field_46;
   }
}
