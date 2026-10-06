package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public class IiiIIIiii_Class200 extends IiIiIIiII_Class165 {
   private static final float I_field_46 = 16.0F;
   private static final float i_field_46 = 21.5F;
   private static final float II_field_46 = 6.0F;
   private static final float Ii_field_46 = 5.5F;
   private static final float iI_field_46 = 27.0F;
   private static final float ii_field_46 = 8.0F;
   private static final float III_field_46 = 1.5F;
   private final ModeSetting I_field_bbe33e6c = new ModeSetting(this, "hud.targethud.armor");
   private final ModeSetting.Nested1_42765c60 I_field_500d0627 = new ModeSetting.Nested1_42765c60(
         this.I_field_bbe33e6c, "hud.targethud.armor.number"
      )
      .select();
   private final ModeSetting.Nested1_42765c60 i_field_500d0627 = new ModeSetting.Nested1_42765c60(
      this.I_field_bbe33e6c, "hud.targethud.armor.icon"
   );
   private final ModeSetting i_field_bbe33e6c = new ModeSetting(this, "\u0424\u043e\u043d");
   private final ModeSetting.Nested1_42765c60 II_field_500d0627 = new ModeSetting.Nested1_42765c60(
      this.i_field_bbe33e6c, "\u0421\u0442\u0430\u0440\u044b\u0439"
   );
   private final ModeSetting.Nested1_42765c60 Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(
         this.i_field_bbe33e6c, "\u041d\u043e\u0432\u044b\u0439"
      )
      .select();
   private final ModeSetting II_field_bbe33e6c = new ModeSetting(this, "\u041f\u043e\u0437\u0438\u0446\u0438\u044f");
   private final ModeSetting.Nested1_42765c60 iI_field_500d0627 = new ModeSetting.Nested1_42765c60(
      this.II_field_bbe33e6c, "\u0413\u043e\u0440\u0438\u0437\u043e\u043d\u0442\u0430\u043b\u044c\u043d\u043e"
   );
   private final ModeSetting.Nested1_42765c60 ii_field_500d0627 = new ModeSetting.Nested1_42765c60(
      this.II_field_bbe33e6c, "\u0412\u0435\u0440\u0442\u0438\u043a\u0430\u043b\u044c\u043d\u043e"
   );
   private final ModeSetting.Nested1_42765c60 III_field_500d0627 = new ModeSetting.Nested1_42765c60(
         this.II_field_bbe33e6c, "\u0410\u0432\u0442\u043e"
      )
      .select();
   private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
   private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private final IiiiIiIii_Class236[] I_field_a8159991 = new IiiiIiIii_Class236[4];
   private static final ItemStack[][] I_field_ca593882 = new ItemStack[][]{
      {new ItemStack(Items.LEATHER_BOOTS), new ItemStack(Items.LEATHER_LEGGINGS), new ItemStack(Items.LEATHER_CHESTPLATE), new ItemStack(Items.LEATHER_HELMET)},
      {
            new ItemStack(Items.CHAINMAIL_BOOTS),
            new ItemStack(Items.CHAINMAIL_LEGGINGS),
            new ItemStack(Items.CHAINMAIL_CHESTPLATE),
            new ItemStack(Items.CHAINMAIL_HELMET)
      },
      {new ItemStack(Items.IRON_BOOTS), new ItemStack(Items.IRON_LEGGINGS), new ItemStack(Items.IRON_CHESTPLATE), new ItemStack(Items.IRON_HELMET)},
      {new ItemStack(Items.GOLDEN_BOOTS), new ItemStack(Items.GOLDEN_LEGGINGS), new ItemStack(Items.GOLDEN_CHESTPLATE), new ItemStack(Items.GOLDEN_HELMET)},
      {new ItemStack(Items.DIAMOND_BOOTS), new ItemStack(Items.DIAMOND_LEGGINGS), new ItemStack(Items.DIAMOND_CHESTPLATE), new ItemStack(Items.DIAMOND_HELMET)},
      {
            new ItemStack(Items.NETHERITE_BOOTS),
            new ItemStack(Items.NETHERITE_LEGGINGS),
            new ItemStack(Items.NETHERITE_CHESTPLATE),
            new ItemStack(Items.NETHERITE_HELMET)
      }
   };

   public IiiIIIiii_Class200() {
      super("modules.settings.name_tags.elementsToDisplay.armor", "hud/armor");

      for (int var1 = 0; var1 < this.I_field_a8159991.length; var1++) {
         this.I_field_a8159991[var1] = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
      }
   }

   @Override
   public void renderComponent(III var1) {
      float var2 = RenderSystem.getShaderColor()[3];
      if (this.II_field_500d0627.isSelected()) {
         this.I_method_431f9139(var1, var2);
      } else {
         this.i_method_7e49f519(var1, var2);
      }
   }

   private void I_method_431f9139(III var1, float var2) {
      boolean var3 = this.I_field_500d0627.isSelected();
      IIiIIi_Class10 var4 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(6.0F);
      ColorRGBA var5 = IiiiiIIIi_Class242.II_method_190e6391()
         .withAlpha(
            255.0F
               * iIIiiiiiI_Class319.I_method_5f7ff5cf(
                  IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(),
                  IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(),
                  InterfaceModule.I_method_fdcdb22f()
               )
         );
      this.i_field_dc7facc.I_method_edd72835(this.animation.I_method_6ac4da6f() * this.visible.I_method_6ac4da6f() >= 1.0F);
      float var6 = 0.0F;
      int var7 = 0;
      List var8 = this.I_method_1e65b248();

      for (IiiIIIiii_Class200.Nested1_fc2b6c60 var10 : (Iterable<IiiIIIiii_Class200.Nested1_fc2b6c60>)(Iterable<?>)var8) {
         this.I_field_a8159991[var7].I_method_edd72835(var10.i_method_d8a1df3e());
         var6 += (var3 ? 23 : 20) * this.I_field_a8159991[var7].I_method_6ac4da6f();
         var7++;
      }

      boolean var22 = this.I_method_431f913d(var1, this.I_method_f7023885(var3));
      this.width = this.I_method_7e094357(var1);
      this.height = this.i_method_412e377(var1);
      this.I_field_dc7facc.I_method_edd6dd11(var6);
      if (!(this.I_field_dc7facc.I_method_6ac4da6f() <= 0.001F) && !(this.i_field_dc7facc.I_method_6ac4da6f() <= 0.001F)) {
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         var1.drawItem(Items.DIAMOND_CHESTPLATE, -992.0F, 994.0F, 1.0F);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var2);
         float var23 = 0.0F;
         ArrayList var11 = new ArrayList();

         for (int var12 = 0; var12 < var8.size(); var12++) {
            int var13 = var22 ? var8.size() - 1 - var12 : var12;
            IiiIIIiii_Class200.Nested1_fc2b6c60 var14 = (IiiIIIiii_Class200.Nested1_fc2b6c60)var8.get(var13);
            IiiiIiIii_Class236 var15 = this.I_field_a8159991[var13];
            float var16 = this.i_field_dc7facc.I_method_6ac4da6f() * var15.I_method_6ac4da6f();
            String var17 = IiIiIiiiI_Class175.I_method_70579eff(var14.I_field_f2735522);
            float var18 = var3 ? 23.0F : 20.0F;
            float var19 = var22 ? this.x : this.x + (this.width - this.I_field_dc7facc.I_method_6ac4da6f()) / 2.0F + var23;
            float var20 = var22 ? this.y + (this.height - this.I_field_dc7facc.I_method_6ac4da6f()) / 2.0F + var23 : this.y;
            if (var16 <= 0.001F) {
               var23 += var18 * var15.I_method_6ac4da6f();
            } else {
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var2 * var16);
               var1.drawRoundedRect(
                  var19, var20, var3 ? 20.0F : 16.0F, var3 ? 9.0F : 16.0F, IIiii_Class8.I_method_893b2757(1.5F), var5.withAlpha(var5.getAlpha() * var16)
               );
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var2);
               iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var19, var20, 16.0F, var3 ? 8.5F : 16.0F);
               float var21 = var2 * var16 * (var3 ? 0.5F : 1.0F);
               if (!var14.I_field_5a || var14.I_field_46 < 1.0F) {
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var21 * (var14.I_field_5a ? 1.0F - var14.I_field_46 : 1.0F));
                  if (var3) {
                     this.I_method_f52a4897(var1, var14.I_field_f2735522, var19 + 2.0F, var20 - 4.0F, 1.0F);
                  } else {
                     this.I_method_f52a4897(var1, var14.I_field_f2735522, var19, var20, 1.0F);
                  }
               }

               if (var14.I_field_5a && var14.I_field_46 > 0.0F) {
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var21 * var14.I_field_46);
                  if (var3) {
                     this.I_method_f52a4897(var1, var14.i_field_f2735522, var19 + 2.0F, var20 - 4.0F, 1.0F);
                  } else {
                     this.I_method_f52a4897(var1, var14.i_field_f2735522, var19, var20, 1.0F);
                  }
               }

               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var2);
               if (this.i_field_500d0627.isSelected()) {
                  this.II_method_cbec475a(var1, var14.I_field_f2735522, var19, var20, var16);
               }

               iIiiiIiII_Class373.I_method_ff80a1df();
               if (var3) {
                  var11.add(new IiiIIIiii_Class200.Nested1_fc2b6c80(var17, var19 + 10.5F, var20 + 2.5F, 255.0F * var16));
               }

               var23 += var18 * var15.I_method_6ac4da6f();
            }
         }

         this.I_method_efb1039(var1, var4, var11);
      }
   }

   private void i_method_7e49f519(III var1, float var2) {
      boolean var3 = this.I_field_500d0627.isSelected();
      IIiIIi_Class10 var4 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(6.0F);
      this.i_field_dc7facc.I_method_edd72835(this.animation.I_method_6ac4da6f() * this.visible.I_method_6ac4da6f() >= 1.0F);
      float var5 = 0.0F;
      int var6 = 0;
      List var7 = this.I_method_1e65b248();

      for (IiiIIIiii_Class200.Nested1_fc2b6c60 var9 : (Iterable<IiiIIIiii_Class200.Nested1_fc2b6c60>)(Iterable<?>)var7) {
         this.I_field_a8159991[var6].I_method_edd72835(var9.i_method_d8a1df3e());
         var5 += 21.5F * this.I_field_a8159991[var6].I_method_6ac4da6f();
         var6++;
      }

      float var30 = var5 <= 0.0F ? 0.0F : var5 - 5.5F;
      boolean var31 = this.I_method_431f913d(var1, this.I_method_41c63e0f());
      this.width = this.I_method_7e094357(var1);
      this.height = this.i_method_412e377(var1);
      if (!(var30 <= 0.001F)) {
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         var1.drawItem(Items.DIAMOND_CHESTPLATE, -992.0F, 994.0F, 1.0F);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var2);
         float var10 = var31 ? 27.0F : Math.max(12.0F, 12.0F + var30);
         float var11 = var31 ? Math.max(12.0F, 12.0F + var30) : 27.0F;
         float var12 = this.x + (this.width - var10) / 2.0F;
         float var13 = this.y + (this.height - var11) / 2.0F;
         var1.drawClientRect(var12, var13, var10, var11, 1.0F, 0.0F, 7.0F, 8.0F);
         float var14 = 0.0F;
         ArrayList var15 = new ArrayList();
         ArrayList var16 = new ArrayList();

         try (CustomDrawContext.Nested1_f061f568 var17 = var1.beginItemBatch()) {
            for (int var18 = 0; var18 < var7.size(); var18++) {
               int var19 = var31 ? var7.size() - 1 - var18 : var18;
               IiiIIIiii_Class200.Nested1_fc2b6c60 var20 = (IiiIIIiii_Class200.Nested1_fc2b6c60)var7.get(var19);
               IiiiIiIii_Class236 var21 = this.I_field_a8159991[var19];
               float var22 = this.i_field_dc7facc.I_method_6ac4da6f() * var21.I_method_6ac4da6f();
               String var23 = IiIiIiiiI_Class175.I_method_70579eff(var20.I_field_f2735522);
               float var24 = var31 ? var12 + 5.5F : var12 + 6.0F + var14;
               float var25 = var31 ? var13 + 6.0F + var14 : var13 + 5.5F;
               float var26 = 0.12F * var21.I_method_6ac4da6f();
               if (var22 <= 0.001F) {
                  var14 += 21.5F * var21.I_method_6ac4da6f();
               } else {
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var2 * var22);
                  iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var24 + 8.0F, var25 + 8.0F, 1.0F + var26);
                  float var27 = var2 * var22;
                  if (!var20.I_field_5a || var20.I_field_46 < 1.0F) {
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var27 * (var20.I_field_5a ? 1.0F - var20.I_field_46 : 1.0F));
                     this.I_method_f52a4897(var1, var20.I_field_f2735522, var24, var25, 1.0F);
                  }

                  if (var20.I_field_5a && var20.I_field_46 > 0.0F) {
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var27 * var20.I_field_46);
                     this.I_method_f52a4897(var1, var20.i_field_f2735522, var24, var25, 1.0F);
                  }

                  iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
                  if (this.i_field_500d0627.isSelected() && var20.I_field_f2735522.isItemBarVisible()) {
                     var16.add(new IiiIIIiii_Class200.Nested1_89421fe9(var20.I_field_f2735522, var24, var25, var22));
                  }

                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var2);
                  if (var3) {
                     var15.add(new IiiIIIiii_Class200.Nested1_fc2b6c80(var23, var24 + 8.0F + 1.5F, var25 + 14.0F, 255.0F * var22));
                  }

                  var14 += 21.5F * var21.I_method_6ac4da6f();
               }
            }
         }

         for (IiiIIIiii_Class200.Nested1_89421fe9 var33 : (Iterable<IiiIIIiii_Class200.Nested1_89421fe9>)(Iterable<?>)var16) {
            this.i_method_92cd2c77(var1, var33.I_method_4c021e7(), var33.I_method_667c6d61(), var33.i_method_668af941(), var33.II_method_69203800());
         }

         this.I_method_efb1039(var1, var4, var15);
      }
   }

   private void I_method_f52a4897(III var1, ItemStack var2, float var3, float var4, float var5) {
      var1.drawBatchItem(var2, var3, var4, var5, 80);
   }

   private void I_method_efb1039(III var1, IIiIIi_Class10 var2, List<IiiIIIiii_Class200.Nested1_fc2b6c80> var3) {
      if (!var3.isEmpty()) {
         iiIIIIIIi_Class386 var4 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, IIiIiI_Class11.Ii_field_857c0621);

         for (IiiIIIiii_Class200.Nested1_fc2b6c80 var6 : var3) {
            var1.drawCenteredText(
               var2,
               var6.I_method_f6d3a8a6(),
               var6.I_method_f2e672a(),
               var6.i_method_f3cf30a(),
               IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(var6.II_method_d6ad7757())
            );
         }

         var4.II_method_ed687102();
      }
   }

   private boolean I_method_431f913d(III var1, float var2) {
      if (this.ii_field_500d0627.isSelected()) {
         return true;
      } else if (this.iI_field_500d0627.isSelected()) {
         return false;
      } else {
         float var3 = var1.getScaledWindowWidth();
         return this.x <= 8.0F || this.x + var2 >= var3 - 8.0F;
      }
   }

   @Override
   public void update(III var1) {
      this.width = this.I_method_7e094357(var1);
      this.height = this.i_method_412e377(var1);
      super.update(var1);
   }

   private float I_method_7e094357(III var1) {
      boolean var2 = this.I_field_500d0627.isSelected();
      if (this.II_field_500d0627.isSelected()) {
         return this.I_method_431f913d(var1, this.I_method_f7023885(var2)) ? (var2 ? 20 : 16) : this.I_method_f7023885(var2);
      } else {
         return this.I_method_431f913d(var1, this.I_method_41c63e0f()) ? 27.0F : this.I_method_41c63e0f();
      }
   }

   private float i_method_412e377(III var1) {
      boolean var2 = this.I_field_500d0627.isSelected();
      if (this.II_field_500d0627.isSelected()) {
         return this.I_method_431f913d(var1, this.I_method_f7023885(var2)) ? this.I_method_f7023885(var2) : (var2 ? 9 : 16);
      } else {
         return this.I_method_431f913d(var1, this.I_method_41c63e0f()) ? this.I_method_41c63e0f() : 27.0F;
      }
   }

   private float I_method_f7023885(boolean var1) {
      return Math.max(12, (var1 ? 23 : 20) * this.I_field_a8159991.length);
   }

   private float I_method_41c63e0f() {
      return 28.0F + 21.5F * (this.I_field_a8159991.length - 1);
   }

   private List<IiiIIIiii_Class200.Nested1_fc2b6c60> I_method_1e65b248() {
      ArrayList var1 = new ArrayList();
      I_field_3a9bda27.player.getArmorItems().forEach(var1::add);
      boolean var2 = var1.stream().allMatch(value -> ((ItemStack)value).isEmpty()) && I_field_3a9bda27.currentScreen instanceof ChatScreen;
      if (!var2) {
         ArrayList var6 = new ArrayList();

         for (ItemStack var8 : (Iterable<ItemStack>)(Iterable<?>)var1) {
            var6.add(new IiiIIIiii_Class200.Nested1_fc2b6c60(var8, ItemStack.EMPTY, 0.0F, false));
         }

         return var6;
      } else {
         IiiIIIiii_Class200.Nested1_89422009 var3 = this.I_method_9ab6775d();
         ArrayList var4 = new ArrayList();

         for (int var5 = 0; var5 < var3.I_method_20665bf8().length; var5++) {
            var4.add(new IiiIIIiii_Class200.Nested1_fc2b6c60(var3.I_method_20665bf8()[var5], var3.i_method_c45edfd8()[var5], var3.I_method_9d178141(), true));
         }

         return var4;
      }
   }

   private IiiIIIiii_Class200.Nested1_89422009 I_method_9ab6775d() {
      float var1 = (float)(System.currentTimeMillis() % (2200L * I_field_ca593882.length)) / (float)(2200L * I_field_ca593882.length);
      float var2 = var1 * I_field_ca593882.length;
      int var3 = (int)Math.floor(var2) % I_field_ca593882.length;
      int var4 = (var3 + 1) % I_field_ca593882.length;
      float var5 = MathHelper.clamp(var2 - (float)Math.floor(var2), 0.0F, 1.0F);
      float var6 = (float)(0.5 - 0.5 * Math.cos(Math.PI * var5));
      return new IiiIIIiii_Class200.Nested1_89422009(I_field_ca593882[var3], I_field_ca593882[var4], var6);
   }

   private void i_method_92cd2c77(III var1, ItemStack var2, float var3, float var4, float var5) {
      if (var2.isItemBarVisible()) {
         float var6 = var3 + 2.0F;
         float var7 = var4 + 13.0F;
         var1.getMatrices().push();
         var1.getMatrices().translate(0.0F, 0.0F, 200.0F);
         var1.drawRoundedRect(var6, var7, 13.0F, 1.5F, IIiii_Class8.I_method_893b2757(0.25F), ColorRGBA.WHITE.mulAlpha(0.25F * var5));
         var1.drawRoundedRect(
            var6, var7, var2.getItemBarStep(), 1.5F, IIiii_Class8.I_method_893b2757(0.25F), IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(var5)
         );
         var1.getMatrices().pop();
      }
   }

   private void II_method_cbec475a(III var1, ItemStack var2, float var3, float var4, float var5) {
      if (var2.isItemBarVisible()) {
         float var6 = var3 + 2.0F;
         float var7 = var4 + 13.0F;
         var1.getMatrices().push();
         var1.getMatrices().translate(0.0F, 0.0F, 200.0F);
         var1.drawRect(var6, var7, 13.0F, 2.0F, ColorRGBA.BLACK.withAlpha(255.0F * var5));
         var1.drawRect(var6, var7, var2.getItemBarStep(), 1.0F, ColorRGBA.fromInt(0xFF000000 | var2.getItemBarColor()).withAlpha(255.0F * var5));
         var1.getMatrices().pop();
      }
   }

   static final class Nested1_89421fe9 {
      private final ItemStack I_field_f2735522;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;

      Nested1_89421fe9(ItemStack var1, float var2, float var3, float var4) {
         this.I_field_f2735522 = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_89421fe9[stack=" + this.I_field_f2735522 + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", alpha=" + this.II_field_46 + "]";
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
         IiiIIIiii_Class200.Nested1_89421fe9 other = (IiiIIIiii_Class200.Nested1_89421fe9) var1;
         return java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46);
      }

      public ItemStack I_method_4c021e7() {
         return this.I_field_f2735522;
      }

      public float I_method_667c6d61() {
         return this.I_field_46;
      }

      public float i_method_668af941() {
         return this.i_field_46;
      }

      public float II_method_69203800() {
         return this.II_field_46;
      }
   }

   static final class Nested1_89422009 {
      private final ItemStack[] I_field_6132843d;
      private final ItemStack[] i_field_6132843d;
      private final float I_field_46;

      Nested1_89422009(ItemStack[] var1, ItemStack[] var2, float var3) {
         this.I_field_6132843d = var1;
         this.i_field_6132843d = var2;
         this.I_field_46 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_89422009[current=" + this.I_field_6132843d + ", next=" + this.i_field_6132843d + ", blend=" + this.I_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_6132843d);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_6132843d);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiIIIiii_Class200.Nested1_89422009 other = (IiiIIIiii_Class200.Nested1_89422009) var1;
         return java.util.Objects.equals(this.I_field_6132843d, other.I_field_6132843d)
            && java.util.Objects.equals(this.i_field_6132843d, other.i_field_6132843d)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46);
      }

      public ItemStack[] I_method_20665bf8() {
         return this.I_field_6132843d;
      }

      public ItemStack[] i_method_c45edfd8() {
         return this.i_field_6132843d;
      }

      public float I_method_9d178141() {
         return this.I_field_46;
      }
   }

   static final class Nested1_fc2b6c60 {
      final ItemStack I_field_f2735522;
      final ItemStack i_field_f2735522;
      final float I_field_46;
      final boolean I_field_5a;

      Nested1_fc2b6c60(ItemStack var1, ItemStack var2, float var3, boolean var4) {
         this.I_field_f2735522 = var1;
         this.i_field_f2735522 = var2;
         this.I_field_46 = var3;
         this.I_field_5a = var4;
      }

      boolean i_method_d8a1df3e() {
         return this.I_field_5a || !this.I_field_f2735522.isEmpty();
      }

      @Override
      public final String toString() {
         return "Nested1_fc2b6c60[primary=" + this.I_field_f2735522 + ", secondary=" + this.i_field_f2735522 + ", blend=" + this.I_field_46 + ", placeholder=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_f2735522);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiIIIiii_Class200.Nested1_fc2b6c60 other = (IiiIIIiii_Class200.Nested1_fc2b6c60) var1;
         return java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522)
            && java.util.Objects.equals(this.i_field_f2735522, other.i_field_f2735522)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public ItemStack I_method_a517909e() {
         return this.I_field_f2735522;
      }

      public ItemStack i_method_600f10be() {
         return this.i_field_f2735522;
      }

      public float I_method_d893534a() {
         return this.I_field_46;
      }

      public boolean I_method_d893535e() {
         return this.I_field_5a;
      }
   }

   static final class Nested1_fc2b6c80 {
      private final String I_field_523beb0a;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;

      Nested1_fc2b6c80(String var1, float var2, float var3, float var4) {
         this.I_field_523beb0a = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_fc2b6c80[text=" + this.I_field_523beb0a + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", alpha=" + this.II_field_46 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiIIIiii_Class200.Nested1_fc2b6c80 other = (IiiIIIiii_Class200.Nested1_fc2b6c80) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46);
      }

      public String I_method_f6d3a8a6() {
         return this.I_field_523beb0a;
      }

      public float I_method_f2e672a() {
         return this.I_field_46;
      }

      public float i_method_f3cf30a() {
         return this.i_field_46;
      }

      public float II_method_d6ad7757() {
         return this.II_field_46;
      }
   }
}
