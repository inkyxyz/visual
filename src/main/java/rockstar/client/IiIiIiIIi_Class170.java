package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Generated;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public class IiIiIiIIi_Class170 extends IiIiIIiII_Class165 implements iIIiIIiIi_Class294, iIIiIIiiI_Class295 {
   private static final Identifier I_field_6a3d6525 = Identifier.ofVanilla("hud/air");
   private static final Identifier i_field_6a3d6525 = Identifier.ofVanilla("hud/air_bursting");
   private static final Identifier II_field_6a3d6525 = Identifier.ofVanilla("hud/air_empty");
   private final Random I_field_c3bd15e6 = Random.create();
   private int I_field_49;
   private long I_field_4a = -1L;
   private int i_field_49;
   private int II_field_49;
   private long i_field_4a;
   private long II_field_4a;
   private int Ii_field_49;
   private static final int iI_field_49 = 40;
   private final IiiiIiIii_Class236[] I_field_a8159991 = new IiiiIiIii_Class236[40];
   private final int[] I_field_b4e = new int[40];
   private final IiiiIiIii_Class236[] i_field_a8159991 = new IiiiIiIii_Class236[9];
   private final IiiiIiIii_Class236[] II_field_a8159991 = new IiiiIiIii_Class236[9];
   private static final float I_field_46 = 29.0F;

   public IiIiIiIIi_Class170() {
      super("hud.custom_hotbar", "hud/hotbar");
      this.y = -1.0F;

      for (int var1 = 0; var1 < this.i_field_a8159991.length; var1++) {
         this.i_field_a8159991[var1] = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.I_field_dd60aac);
         this.II_field_a8159991[var1] = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.I_field_dd60aac);
      }

      for (int var2 = 0; var2 < this.I_field_a8159991.length; var2++) {
         this.I_field_a8159991[var2] = new IiiiIiIii_Class236(700L, 0.0F, IiiiIiiII_Class237.iIi_field_dd60aac);
      }
   }

   @Override
   protected boolean anchorsRightEdge() {
      return false;
   }

   @Override
   public void update(III var1) {
      boolean var2 = !this.I_method_d7c8c683();
      if (this.y < 0.0F) {
         this.y = I_field_73c6d26c.i_method_805d6def() - 29.0F;
      }

      if (var2 && !this.isDragging()) {
         this.I_method_d7c8c67f();
      }

      super.update(var1);
      if (this.isDragging()) {
         this.x = I_field_73c6d26c.I_method_804ee20f() / 2.0F - (var2 ? 91 : 100);
         this.y = Math.min(this.y, I_field_73c6d26c.i_method_805d6def() - 29.0F);
      }

      if (var2 && this.isHovered(var1)) {
         iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
      }
   }

   @Override
   public void pos(float var1, float var2) {
      super.pos(var1, var2);
      if (!this.isShowing()) {
         this.y = -1.0F;
      }
   }

   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (this.I_method_d7c8c683()) {
         super.onMouseClicked(var1, var3, var5);
      } else {
         if (var5 == IiIII_Class9.I_field_2f4c8d6c && this.isHovered(var1, var3)) {
            this.beginDrag(var1, var3);
         }
      }
   }

   private boolean I_method_d7c8c683() {
      return this.isShowing() && this.show();
   }

   private void I_method_d7c8c67f() {
      this.width = 182.0F;
      this.height = 29.0F;
      this.x = I_field_73c6d26c.I_method_804ee20f() / 2.0F - 91.0F;
   }

   public static float I_method_d7c8c66f() {
      IiIiIIIii_Class164 var0 = RockstarClient.getInstance() == null ? null : RockstarClient.getInstance().I_method_35687482();
      IiIiIiIIi_Class170 var1 = var0 == null ? null : var0.I_method_3a63b5();
      return var1 != null && !(var1.y < 0.0F) ? I_field_73c6d26c.i_method_805d6def() - 29.0F - var1.y : 0.0F;
   }

   @Override
   public void renderComponent(III var1) {
      this.width = 200.0F;
      this.height = 27.0F;
      ItemStack var2 = I_field_3a9bda27.player.getOffHandStack();
      Arm var3 = I_field_3a9bda27.player.getMainArm().getOpposite();
      boolean var4 = false;
      boolean var5 = false;
      if (!var2.isEmpty()) {
         if (var3 == Arm.LEFT) {
            var4 = true;
         } else {
            var5 = true;
         }
      }

      this.x = I_field_73c6d26c.I_method_804ee20f() / 2.0F - 100.0F;
      if (I_field_3a9bda27.player != null) {
         if (I_field_3a9bda27.world != null) {
            long var6 = I_field_3a9bda27.world.getTime();
            if (var6 != this.I_field_4a) {
               this.I_field_4a = var6;
               this.I_field_49++;
            }
         }

         int var25 = (int)this.x;
         int var7 = (int)this.y;
         int var8 = I_field_3a9bda27.player.getInventory().selectedSlot;
         if (I_field_3a9bda27.interactionManager.hasStatusBars()) {
            this.I_method_9a91b707(var1);
         }

         int var9 = (int)(I_field_73c6d26c.I_method_804ee20f() / 2.0F - 91.0F);
         this.I_method_7870bfa4(var1, I_field_3a9bda27.getRenderTickCounter());
         var1.drawClientRect(var25 - (var4 ? 30.0F : 0.0F), var7, !var5 && !var4 ? 200.0F : 230.0F, 27.0F, 1.0F, 0.0F, 7.0F, 8.0F);
         float var10 = RenderSystem.getShaderColor()[3];
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         IiIiIiIIi_Class170.Nested1_a48cc020[] var11 = new IiIiIiIIi_Class170.Nested1_a48cc020[9];

         try (
            iIiiiIiiI_Class375.Nested1_a8802c80 var12 = iIiiiIiiI_Class375.I_method_a04b9c30();
            CustomDrawContext.Nested1_f061f568 var13 = var1.beginItemBatch();
         ) {
            for (int var14 = 0; var14 < 9; var14++) {
               IiiiIiIii_Class236 var15 = this.i_field_a8159991[var14];
               IiiiIiIii_Class236 var16 = this.II_field_a8159991[var14];
               var15.I_method_edd72835(var8 == var14);
               var16.I_method_edd72835(Math.abs(var8 - var14) <= 1);
               ItemStack var17 = (ItemStack)I_field_3a9bda27.player.getInventory().main.get(var14);
               float var18 = 0.1F * var16.I_method_6ac4da6f() + 0.25F * var15.I_method_6ac4da6f();
               float var19 = var25 + 6 + var14 * 21.5F;
               float var20 = var7 + 5.5F - 12.0F * var18;
               var11[var14] = new IiIiIiIIi_Class170.Nested1_a48cc020(var17, var19, var20, var18);
               if (!var17.isEmpty()) {
                  iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var19 + 8.0F, var20 + 8.0F, 1.0F + var18);
                  var1.drawBatchItem(var17, var19, var20, 1);
                  iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
               }
            }

            if (var4) {
               float var27 = var25 + 6 - 30.0F;
               float var29 = var7 + 5.5F;
               var1.drawBatchItem(var2, var27, var29, 1);
            } else if (var5) {
               float var28 = var25 + 6 + 172.0F + 30.0F;
               float var30 = var7 + 5.5F;
               var1.drawBatchItem(var2, var28, var30, 1);
            }
         }

         IiIiIiIIi_Class170.Nested1_a48cc020 var26 = null;
         if (var4) {
            var26 = new IiIiIiIIi_Class170.Nested1_a48cc020(var2, var25 + 6 - 30.0F, var7 + 5.5F, 0.0F);
         } else if (var5) {
            var26 = new IiIiIiIIi_Class170.Nested1_a48cc020(var2, var25 + 6 + 172.0F + 30.0F, var7 + 5.5F, 0.0F);
         }

         this.I_method_fab98669(var1, var11);
         this.I_method_6dab0658(var1, var11, var26);
         this.i_method_9a9a2238(var1, var11, var26);
         this.II_method_5151031b(var1, var11, var26);
         this.i_method_707ede89(var1, var11);
         if (var4 && var26 != null) {
            var1.drawRoundedRect(
               var26.I_method_2eb0578a() + 22.5F,
               var26.i_method_2ebee36a(),
               0.5F,
               16.0F,
               IIiii_Class8.I_field_2d98a52c,
               IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.5F)
            );
         } else if (var5 && var26 != null) {
            var1.drawRoundedRect(
               var26.I_method_2eb0578a() - 7.5F,
               var26.i_method_2ebee36a(),
               0.5F,
               16.0F,
               IIiii_Class8.I_field_2d98a52c,
               IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.5F)
            );
         }

         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var10);
      }
   }

   private void I_method_fab98669(CustomDrawContext var1, IiIiIiIIi_Class170.Nested1_a48cc020[] var2) {
      boolean var3 = false;

      for (IiIiIiIIi_Class170.Nested1_a48cc020 var7 : var2) {
         if (var7.I_method_5df3f45e().isEmpty()) {
            var3 = true;
            break;
         }
      }

      if (var3) {
         iiIIIIIIi_Class386 var9 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, IIiIiI_Class11.ii_field_857c0621);

         for (int var10 = 0; var10 < var2.length; var10++) {
            IiIiIiIIi_Class170.Nested1_a48cc020 var11 = var2[var10];
            if (var11.I_method_5df3f45e().isEmpty()) {
               float var12 = 1.0F + var11.II_method_a76992f7();
               String var8 = String.valueOf(var10 + 1);
               iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var11.Ii_method_a7781ed7(), var11.iI_method_a92c8317(), var12);
               var1.drawText(
                  IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(10.0F),
                  var8,
                  var11.I_method_2eb0578a() + 8.5F - IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(10.0F).I_method_2c375926(var8) / 2.0F,
                  var11.i_method_2ebee36a() + 4.5F,
                  IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.5F + var11.II_method_a76992f7() * 1.5F)
               );
               iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            }
         }

         var9.II_method_ed687102();
      }
   }

   private void I_method_6dab0658(CustomDrawContext var1, IiIiIiIIi_Class170.Nested1_a48cc020[] var2, @Nullable IiIiIiIIi_Class170.Nested1_a48cc020 var3) {
      for (IiIiIiIIi_Class170.Nested1_a48cc020 var7 : var2) {
         if (!var7.I_method_5df3f45e().isEmpty()) {
            iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var7.Ii_method_a7781ed7(), var7.iI_method_a92c8317(), 1.0F + var7.II_method_a76992f7());
            this.i_method_3752067f(var1, var7.I_method_5df3f45e(), var7.I_method_2eb0578a(), var7.i_method_2ebee36a());
            iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
         }
      }

      if (var3 != null) {
         this.i_method_3752067f(var1, var3.I_method_5df3f45e(), var3.I_method_2eb0578a(), var3.i_method_2ebee36a());
      }
   }

   private void i_method_9a9a2238(CustomDrawContext var1, IiIiIiIIi_Class170.Nested1_a48cc020[] var2, @Nullable IiIiIiIIi_Class170.Nested1_a48cc020 var3) {
      boolean var4 = false;

      for (IiIiIiIIi_Class170.Nested1_a48cc020 var8 : var2) {
         if (this.I_method_c12ab7a5(var8.I_method_5df3f45e())) {
            var4 = true;
            break;
         }
      }

      if (var4 || var3 != null && this.I_method_c12ab7a5(var3.I_method_5df3f45e())) {
         iiIIIIIIi_Class386 var10 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, IIiIiI_Class11.ii_field_857c0621);

         for (IiIiIiIIi_Class170.Nested1_a48cc020 var9 : var2) {
            if (this.I_method_c12ab7a5(var9.I_method_5df3f45e())) {
               iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var9.Ii_method_a7781ed7(), var9.iI_method_a92c8317(), 1.0F + var9.II_method_a76992f7());
               this.II_method_70ae6f7c(var1, var9.I_method_5df3f45e(), var9.I_method_2eb0578a(), var9.i_method_2ebee36a());
               iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            }
         }

         if (var3 != null && this.I_method_c12ab7a5(var3.I_method_5df3f45e())) {
            this.II_method_70ae6f7c(var1, var3.I_method_5df3f45e(), var3.I_method_2eb0578a(), var3.i_method_2ebee36a());
         }

         var10.II_method_ed687102();
      }
   }

   private void II_method_5151031b(CustomDrawContext var1, IiIiIiIIi_Class170.Nested1_a48cc020[] var2, @Nullable IiIiIiIIi_Class170.Nested1_a48cc020 var3) {
      for (IiIiIiIIi_Class170.Nested1_a48cc020 var7 : var2) {
         if (!var7.I_method_5df3f45e().isEmpty()) {
            iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var7.Ii_method_a7781ed7(), var7.iI_method_a92c8317(), 1.0F + var7.II_method_a76992f7());
            this.Ii_method_8a7e3f9c(var1, var7.I_method_5df3f45e(), var7.I_method_2eb0578a(), var7.i_method_2ebee36a());
            iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
         }
      }

      if (var3 != null) {
         this.Ii_method_8a7e3f9c(var1, var3.I_method_5df3f45e(), var3.I_method_2eb0578a(), var3.i_method_2ebee36a());
      }
   }

   private void i_method_707ede89(CustomDrawContext var1, IiIiIiIIi_Class170.Nested1_a48cc020[] var2) {
      boolean var3 = false;

      for (IiiiIiIii_Class236 var7 : this.i_field_a8159991) {
         if (var7.I_method_6ac4da6f() > 0.001F) {
            var3 = true;
            break;
         }
      }

      if (var3) {
         iiIIIIiII_Class389 var8 = new iiIIIIiII_Class389();

         for (int var9 = 0; var9 < var2.length; var9++) {
            IiIiIiIIi_Class170.Nested1_a48cc020 var10 = var2[var9];
            float var11 = this.i_field_a8159991[var9].I_method_6ac4da6f();
            var1.drawRoundedRect(
               var10.I_method_2eb0578a() + 7.5F,
               var10.i_method_2ebee36a() + 21.0F - var11,
               2.0F,
               2.0F,
               IIiii_Class8.I_method_893b2757(0.5F),
               IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(var11)
            );
         }

         var8.II_method_ed687102();
      }
   }

   private boolean I_method_c12ab7a5(ItemStack var1) {
      return !var1.isEmpty() && var1.getCount() != 1;
   }

   public void I_method_1d82365f(CustomDrawContext var1, ItemStack var2, float var3, float var4) {
      if (!var2.isEmpty()) {
         var1.getMatrices().push();
         this.i_method_3752067f(var1, var2, var3, var4);
         this.II_method_70ae6f7c(var1, var2, var3, var4);
         this.Ii_method_8a7e3f9c(var1, var2, var3, var4);
         var1.getMatrices().pop();
      }
   }

   private void i_method_3752067f(CustomDrawContext var1, ItemStack var2, float var3, float var4) {
      if (var2.isItemBarVisible()) {
         float var5 = var3 + 2.0F;
         float var6 = var4 + 13.0F;
         var1.drawRoundedRect(var5, var6, 13.0F, 1.5F, IIiii_Class8.I_method_893b2757(0.25F), ColorRGBA.WHITE.mulAlpha(0.25F));
         var1.drawRoundedRect(var5, var6, (float)var2.getItemBarStep(), 1.5F, IIiii_Class8.I_method_893b2757(0.25F), IiiiiIIIi_Class242.i_method_5dfec6e());
      }
   }

   private void II_method_70ae6f7c(CustomDrawContext var1, ItemStack var2, float var3, float var4) {
      if (var2.getCount() != 1) {
         String var5 = String.valueOf(var2.getCount());
         var1.getMatrices().push();
         var1.getMatrices().translate(0.0F, 0.0F, 200.0F);
         var1.drawText(
            IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(8.0F),
            var5,
            var3 + 19.0F + 0.5F - 2.0F - IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(8.0F).I_method_2c375926(var5),
            var4 + 6.0F + 3.5F,
            IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.4F)
         );
         var1.drawText(
            IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(8.0F),
            var5,
            var3 + 19.0F - 2.0F - IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(8.0F).I_method_2c375926(var5),
            var4 + 6.0F + 3.0F,
            IiiiiIIIi_Class242.Ii_field_d0c8ec5
         );
         var1.getMatrices().pop();
      }
   }

   private void Ii_method_8a7e3f9c(CustomDrawContext var1, ItemStack var2, float var3, float var4) {
      ClientPlayerEntity var5 = I_field_3a9bda27.player;
      float var6 = var5 == null ? 0.0F : var5.getItemCooldownManager().getCooldownProgress(var2, I_field_3a9bda27.getRenderTickCounter().getTickDelta(true));
      if (var6 > 0.0F) {
         float var7 = var4 + MathHelper.floor(16.0F * (1.0F - var6));
         float var8 = MathHelper.ceil(16.0F * var6);
         var1.drawRoundedRect(var3, var7, 16.0F, var8, IIiii_Class8.I_method_893b2757(0.5F), ColorRGBA.WHITE.mulAlpha(0.35F));
      }
   }

   private void I_method_7870bfa4(CustomDrawContext var1, RenderTickCounter var2) {
      int var3 = I_field_3a9bda27.player.experienceLevel;
      if (this.i_method_d7d75263() && var3 > 0) {
         String var4 = var3 + "";
         float var5 = (var1.getScaledWindowWidth() - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_2c375926(var4)) / 2.0F;
         int var6 = (int)this.y - 8;
         iiIIIIIIi_Class386 var7 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, IIiIiI_Class11.II_field_857c0621);
         var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var4, var5 + 1.0F, var6, IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F));
         var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var4, var5 - 1.0F, var6, IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F));
         var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var4, var5, var6 + 1, IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F));
         var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var4, var5, var6 - 1, IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F));
         var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var4, var5, var6, new ColorRGBA(126.0F, 252.0F, 32.0F));
         var7.II_method_ed687102();
      }
   }

   private boolean i_method_d7d75263() {
      return I_field_3a9bda27.player.getJumpingMount() == null && I_field_3a9bda27.interactionManager.hasExperienceBar();
   }

   private void I_method_9a91b707(III var1) {
      PlayerEntity var2 = this.I_method_8818cf4c();
      if (var2 != null) {
         int var3 = MathHelper.ceil(var2.getHealth());
         boolean var4 = this.II_field_4a > this.I_field_49 && (this.II_field_4a - this.I_field_49) / 3L % 2L == 1L;
         long var5 = Util.getMeasuringTimeMs();
         if (var3 < this.i_field_49 && var2.timeUntilRegen > 0) {
            this.i_field_4a = var5;
            this.II_field_4a = this.I_field_49 + 20;
         } else if (var3 > this.i_field_49 && var2.timeUntilRegen > 0) {
            this.i_field_4a = var5;
            this.II_field_4a = this.I_field_49 + 10;
         }

         if (var5 - this.i_field_4a > 1000L) {
            this.II_field_49 = var3;
            this.i_field_4a = var5;
         }

         if (var3 < this.i_field_49) {
            for (int var7 = 0; var7 < 40 && var7 * 2 < this.i_field_49; var7++) {
               int var8 = MathHelper.clamp(this.i_field_49 - var7 * 2, 0, 2);
               int var9 = MathHelper.clamp(var3 - var7 * 2, 0, 2);
               if (var8 > var9) {
                  this.I_field_b4e[var7] = var8 - var9 == 2 ? 3 : (var8 == 2 ? 2 : 1);
                  this.I_field_a8159991[var7].I_method_edd6dd21(1.0F);
                  this.I_field_a8159991[var7].I_method_edd6dd11(0.0F);
               }
            }
         } else if (var3 > this.i_field_49) {
            for (int var19 = 0; var19 < 40 && var19 * 2 < var3; var19++) {
               this.I_field_a8159991[var19].I_method_6ac4da7f();
               this.I_field_b4e[var19] = 0;
            }
         }

         this.i_field_49 = var3;
         int var20 = this.II_field_49;
         this.I_field_c3bd15e6.setSeed(this.I_field_49 * 312871);
         int var21 = var1.getScaledWindowWidth() / 2 - 100;
         int var22 = var1.getScaledWindowWidth() / 2 + 100;
         int var10 = (int)this.y - 11;
         float var11 = Math.max((float)var2.getAttributeValue(EntityAttributes.MAX_HEALTH), (float)Math.max(var20, var3));
         int var12 = MathHelper.ceil(var2.getAbsorptionAmount());
         int var13 = MathHelper.ceil((var11 + var12) / 2.0F / 10.0F);
         int var14 = Math.max(10 - (var13 - 2), 3);
         int var15 = var10 - 10;
         int var16 = -1;
         if (var2.hasStatusEffect(StatusEffects.REGENERATION)) {
            var16 = this.I_field_49 % MathHelper.ceil(var11 + 5.0F);
         }

         I_method_4f393b5c(var1, var2, var10, var13, var14, var21);
         this.I_method_835e6e75(var1, var2, var21, var10, var14, var16, var11, var3, var20, var12, var4);
         LivingEntity var17 = this.I_method_9930438c();
         int var18 = this.I_method_b7ff91b1(var17);
         if (var18 == 0) {
            this.I_method_10dd69fc(var1, var2, var10, var22);
            var15 -= 10;
         }

         this.I_method_ad04887(var1, var2, var18, var15, var22);
      }
   }

   private static void I_method_4f393b5c(III var0, PlayerEntity var1, int var2, int var3, int var4, int var5) {
      ColorRGBA var6 = new ColorRGBA(223.0F, 223.0F, 223.0F);
      int var7 = var1.getArmor();
      if (var7 > 0) {
         int var8 = var2 - (var3 - 1) * var4 - 10;

         for (int var9 = 0; var9 < 10; var9++) {
            int var10 = var5 + var9 * 9;
            if (var9 * 2 + 1 < var7) {
               var0.drawRoundedRect(var10, var8, 8.0F, 8.0F, IIiii_Class8.I_method_893b2757(1.5F), var6);
            }

            if (var9 * 2 + 1 > var7) {
               var0.drawRoundedRect(
                  var10,
                  var8,
                  8.0F,
                  8.0F,
                  IIiii_Class8.I_method_893b2757(1.5F),
                  IiiiiIIIi_Class242.II_method_190e6391()
                     .mulAlpha(
                        iIIiiiiiI_Class319.I_method_5f7ff5cf(
                           IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(),
                           IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(),
                           InterfaceModule.I_method_fdcdb22f()
                        )
                     )
               );
            }
         }

         for (int var11 = 0; var11 < 10; var11++) {
            int var12 = var5 + var11 * 9;
            if (var11 * 2 + 1 == var7) {
               var0.drawRoundedRect(
                  var12 + 4,
                  var8,
                  4.0F,
                  8.0F,
                  new IIiii_Class8(0.0F, 1.5F, 1.5F, 0.0F),
                  IiiiiIIIi_Class242.II_method_190e6391()
                     .mulAlpha(
                        iIIiiiiiI_Class319.I_method_5f7ff5cf(
                           IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(),
                           IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(),
                           InterfaceModule.I_method_fdcdb22f()
                        )
                     )
               );
               var0.drawRoundedRect(var12, var8, 4.0F, 8.0F, new IIiii_Class8(1.5F, 0.0F, 0.0F, 1.5F), var6);
            }
         }
      }
   }

   private void I_method_835e6e75(III var1, PlayerEntity var2, int var3, int var4, int var5, int var6, float var7, int var8, int var9, int var10, boolean var11) {
      IiIiIiIIi_Class170.Nested1_a48cc000 var12 = IiIiIiIIi_Class170.Nested1_a48cc000.I_method_c7d13440(var2);
      boolean var13 = var2.getWorld().getLevelProperties().isHardcore();
      int var14 = MathHelper.ceil(var7 / 2.0);
      int var15 = MathHelper.ceil(var10 / 2.0);
      int var16 = var14 * 2;

      for (int var17 = var14 + var15 - 1; var17 >= 0; var17--) {
         int var18 = var17 / 10;
         int var19 = var17 % 10;
         int var20 = var3 + var19 * 9;
         int var21 = var4 - var18 * var5;
         if (var8 + var10 <= 4) {
            var21 += this.I_field_c3bd15e6.nextInt(2);
         }

         if (var17 < var14 && var17 == var6) {
            var21 -= 2;
         }

         this.I_method_f48c699a(var1, IiIiIiIIi_Class170.Nested1_a48cc000.I_field_30c31687, var20, var21, false);
         int var22 = var17 * 2;
         boolean var23 = var17 >= var14;
         if (var23) {
            int var24 = var22 - var16;
            if (var24 < var10) {
               boolean var25 = var24 + 1 == var10;
               this.I_method_f48c699a(
                  var1,
                  var12 == IiIiIiIIi_Class170.Nested1_a48cc000.Ii_field_30c31687 ? var12 : IiIiIiIIi_Class170.Nested1_a48cc000.iI_field_30c31687,
                  var20,
                  var21,
                  var25
               );
            }
         }

         if (var22 < var8) {
            this.I_method_f48c699a(var1, var12, var20, var21, var22 + 1 == var8);
         }

         if (var17 < 40) {
            float var27 = this.I_field_a8159991[var17].I_method_edd6dd11(0.0F);
            if (var27 > 0.001F) {
               float var28 = 1.0F + (1.0F - var27);
               iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var20 + 4.0F, var21 + 4.0F, var28);
               ColorRGBA var26 = ColorRGBA.WHITE.mulAlpha(var27);
               if (this.I_field_b4e[var17] == 1) {
                  var1.drawRoundedRect(var20, var21, 4.0F, 8.0F, new IIiii_Class8(2.0F, 0.0F, 0.0F, 2.0F), var26);
               } else if (this.I_field_b4e[var17] == 2) {
                  var1.drawRoundedRect(var20 + 4, var21, 4.0F, 8.0F, new IIiii_Class8(0.0F, 2.0F, 2.0F, 0.0F), var26);
               } else {
                  var1.drawRoundedRect(var20, var21, 8.0F, 8.0F, IIiii_Class8.I_method_893b2757(2.0F), var26);
               }

               iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            }
         }
      }
   }

   private void I_method_f48c699a(III var1, IiIiIiIIi_Class170.Nested1_a48cc000 var2, int var3, int var4, boolean var5) {
      var2.I_method_eac48d72(var1, var3, var4, 8.0F, 8.0F, var5);
   }

   private void I_method_ad04887(III var1, PlayerEntity var2, int var3, int var4, int var5) {
      int var6 = var2.getMaxAir();
      int var7 = Math.clamp((long)var2.getAir(), 0, var6);
      boolean var8 = var2.isSubmergedIn(FluidTags.WATER);
      if (var8 || var7 < var6) {
         var4 = this.I_method_8bf8312(var3, var4);
         int var9 = I_method_f3153b7(var7, var6, -2);
         int var10 = I_method_f3153b7(var7, var6, 0);
         int var11 = 10 - I_method_f3153b7(var7, var6, I_method_8bfc2e3(var7, var8));
         boolean var12 = var9 != var10;
         if (!var8) {
            this.Ii_field_49 = 0;
         }

         for (int var13 = 1; var13 <= 10; var13++) {
            int var14 = var5 - (var13 - 1) * 9 - 10;
            if (var13 <= var9) {
               var1.drawGuiTexture(RenderLayer::getGuiTextured, I_field_6a3d6525, var14, var4, 9, 9);
            } else if (var12 && var13 == var10 && var8) {
               var1.drawGuiTexture(RenderLayer::getGuiTextured, i_field_6a3d6525, var14, var4, 9, 9);
               this.I_method_ee16286a(var13, var2, var11);
            } else if (var13 > 10 - var11) {
               int var15 = var11 == 10 && this.I_field_49 % 2 == 0 ? this.I_field_c3bd15e6.nextInt(2) : 0;
               var1.drawGuiTexture(RenderLayer::getGuiTextured, II_field_6a3d6525, var14, var4 + var15, 9, 9);
            }
         }
      }
   }

   private int I_method_8bf8312(int var1, int var2) {
      return var2 - (this.I_method_21507c57(var1) - 1) * 10;
   }

   private static int I_method_f3153b7(int var0, int var1, int var2) {
      return MathHelper.ceil((float)((var0 + var2) * 10) / var1);
   }

   private static int I_method_8bfc2e3(int var0, boolean var1) {
      return var0 != 0 && var1 ? 1 : 0;
   }

   private void I_method_ee16286a(int var1, PlayerEntity var2, int var3) {
      if (this.Ii_field_49 != var1) {
         float var4 = 0.5F + 0.1F * Math.max(0, var3 - 3 + 1);
         float var5 = 1.0F + 0.1F * Math.max(0, var3 - 5 + 1);
         var2.playSound(SoundEvents.UI_HUD_BUBBLE_POP, var4, var5);
         this.Ii_field_49 = var1;
      }
   }

   private void I_method_10dd69fc(III var1, PlayerEntity var2, int var3, int var4) {
      ColorRGBA var5 = new ColorRGBA(184.0F, 132.0F, 88.0F);
      HungerManager var6 = var2.getHungerManager();
      int var7 = var6.getFoodLevel();
      int[] var8 = new int[10];

      for (int var9 = 0; var9 < 10; var9++) {
         int var10 = var3;
         if (var6.getSaturationLevel() <= 0.0F && this.I_field_49 % (var7 * 3 + 1) == 0) {
            var10 = var3 + (this.I_field_c3bd15e6.nextInt(3) - 1);
         }

         var8[var9] = var10;
      }

      for (int var14 = 0; var14 < 10; var14++) {
         int var18 = var4 - var14 * 9 - 10;
         var1.drawRoundedRect(
            var18,
            var8[var14],
            8.0F,
            8.0F,
            IIiii_Class8.I_method_893b2757(1.5F),
            IiiiiIIIi_Class242.II_method_190e6391()
               .mulAlpha(
                  iIIiiiiiI_Class319.I_method_5f7ff5cf(
                     IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(),
                     IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(),
                     InterfaceModule.I_method_fdcdb22f()
                  )
               )
         );
      }

      for (int var15 = 0; var15 < 10; var15++) {
         if (var15 * 2 + 1 < var7) {
            int var19 = var4 - var15 * 9 - 10;
            var1.drawRoundedRect(var19, var8[var15], 8.0F, 8.0F, IIiii_Class8.I_method_893b2757(1.5F), var5);
         }
      }

      for (int var16 = 0; var16 < 10; var16++) {
         if (var16 * 2 + 1 == var7) {
            int var20 = var4 - var16 * 9 - 10;
            var1.drawRoundedRect(var20 + 4, var8[var16], 4.0F, 8.0F, new IIiii_Class8(0.0F, 1.5F, 1.5F, 0.0F), var5);
         }
      }

      var5 = new ColorRGBA(251.0F, 170.0F, 56.0F);
      int var17 = (int)var6.getSaturationLevel();
      int[] var21 = new int[10];

      for (int var11 = 0; var11 < 10; var11++) {
         int var12 = var3;
         if (var6.getSaturationLevel() <= 0.0F && this.I_field_49 % (var17 * 3 + 1) == 0) {
            var12 = var3 + (this.I_field_c3bd15e6.nextInt(3) - 1);
         }

         var21[var11] = var12;
      }

      for (int var22 = 0; var22 < 10; var22++) {
         int var24 = var4 - var22 * 9 - 10;
         if (var22 * 2 + 1 < var17) {
            var1.drawRoundedRect(var24, var21[var22], 8.0F, 8.0F, IIiii_Class8.I_method_893b2757(1.5F), var5);
         }
      }

      for (int var23 = 0; var23 < 10; var23++) {
         if (var23 * 2 + 1 == var17) {
            int var25 = var4 - var23 * 9 - 10;
            var1.drawRoundedRect(var25 + 4, var21[var23], 4.0F, 8.0F, new IIiii_Class8(0.0F, 1.5F, 1.5F, 0.0F), var5);
         }
      }
   }

   @Nullable
   private PlayerEntity I_method_8818cf4c() {
      return I_field_3a9bda27.getCameraEntity() instanceof PlayerEntity var2 ? var2 : null;
   }

   @Nullable
   private LivingEntity I_method_9930438c() {
      PlayerEntity var1 = this.I_method_8818cf4c();
      if (var1 == null) {
         return null;
      } else {
         return var1.getVehicle() instanceof LivingEntity var3 ? var3 : null;
      }
   }

   private int I_method_b7ff91b1(@Nullable LivingEntity var1) {
      if (var1 != null && var1.isLiving()) {
         int var2 = (int)(var1.getMaxHealth() + 0.5F) / 2;
         return Math.min(var2, 30);
      } else {
         return 0;
      }
   }

   private int I_method_21507c57(int var1) {
      return (int)Math.ceil(var1 / 10.0);
   }

   static enum Nested1_a48cc000 {
      I_field_30c31687(new ColorRGBA(200.0F, 200.0F, 200.0F, 200.0F)),
      i_field_30c31687(new ColorRGBA(255.0F, 81.0F, 81.0F)),
      II_field_30c31687(new ColorRGBA(169.0F, 202.0F, 23.0F)),
      Ii_field_30c31687(new ColorRGBA(66.0F, 66.0F, 66.0F)),
      iI_field_30c31687(new ColorRGBA(251.0F, 170.0F, 56.0F)),
      ii_field_30c31687(new ColorRGBA(163.0F, 246.0F, 255.0F));

      private final ColorRGBA I_field_d0c8ec5;

      public void I_method_eac48d72(CustomDrawContext var1, float var2, float var3, float var4, float var5, boolean var6) {
         if (var6) {
            var1.drawRoundedRect(
               var2,
               var3,
               var4 / 2.0F,
               var5,
               new IIiii_Class8(2.0F, 0.0F, 0.0F, 2.0F),
               this == I_field_30c31687
                  ? IiiiiIIIi_Class242.II_method_190e6391()
                     .mulAlpha(
                        iIIiiiiiI_Class319.I_method_5f7ff5cf(
                           IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(),
                           IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(),
                           InterfaceModule.I_method_fdcdb22f()
                        )
                     )
                  : this.I_field_d0c8ec5
            );
         } else {
            var1.drawRoundedRect(
               var2,
               var3,
               var4,
               var5,
               IIiii_Class8.I_method_893b2757(2.0F),
               this == I_field_30c31687
                  ? IiiiiIIIi_Class242.II_method_190e6391()
                     .mulAlpha(
                        iIIiiiiiI_Class319.I_method_5f7ff5cf(
                           IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(),
                           IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(),
                           InterfaceModule.I_method_fdcdb22f()
                        )
                     )
                  : this.I_field_d0c8ec5
            );
         }
      }

      static IiIiIiIIi_Class170.Nested1_a48cc000 I_method_c7d13440(PlayerEntity var0) {
         if (var0.hasStatusEffect(StatusEffects.POISON)) {
            return II_field_30c31687;
         } else if (var0.hasStatusEffect(StatusEffects.WITHER)) {
            return Ii_field_30c31687;
         } else {
            return var0.isFrozen() ? ii_field_30c31687 : i_field_30c31687;
         }
      }

      @Generated
      private Nested1_a48cc000(ColorRGBA var3) {
         this.I_field_d0c8ec5 = var3;
      }
   }

   static final class Nested1_a48cc020 {
      private final ItemStack I_field_f2735522;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;

      Nested1_a48cc020(ItemStack var1, float var2, float var3, float var4) {
         this.I_field_f2735522 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
      }

      float Ii_method_a7781ed7() {
         return this.I_field_46 + 8.0F;
      }

      float iI_method_a92c8317() {
         return this.i_field_46 + 8.0F;
      }

      @Override
      public final String toString() {
         return "Nested1_a48cc020[stack=" + this.I_field_f2735522 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", scaleFactor=" + this.II_field_46 + "]";
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
         IiIiIiIIi_Class170.Nested1_a48cc020 other = (IiIiIiIIi_Class170.Nested1_a48cc020) var1;
         return java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46);
      }

      public ItemStack I_method_5df3f45e() {
         return this.I_field_f2735522;
      }

      public float I_method_2eb0578a() {
         return this.I_field_46;
      }

      public float i_method_2ebee36a() {
         return this.i_field_46;
      }

      public float II_method_a76992f7() {
         return this.II_field_46;
      }
   }
}
