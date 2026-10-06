package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import pyrock.utility.render.ColorRGBA;

public class IiIiIiiiI_Class175 extends IiIiIIiII_Class165 {
   private final BooleanSetting I_field_ba20ca4c = new BooleanSetting(this, "hud.targethud.look");
   private final ModeSetting I_field_bbe33e6c = new ModeSetting(this, "hud.targethud.armor");
   private final ModeSetting.Nested1_42765c60 I_field_500d0627 = new ModeSetting.Nested1_42765c60(
      this.I_field_bbe33e6c, "hud.targethud.armor.none"
   );
   private final ModeSetting.Nested1_42765c60 i_field_500d0627 = new ModeSetting.Nested1_42765c60(
         this.I_field_bbe33e6c, "hud.targethud.armor.number"
      )
      .select();
   private final ModeSetting.Nested1_42765c60 II_field_500d0627 = new ModeSetting.Nested1_42765c60(
      this.I_field_bbe33e6c, "hud.targethud.armor.icon"
   );
   private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private final IiiiIiIii_Class236 Ii_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private final IiiiIiIii_Class236 iI_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private final IiiiIiIii_Class236 ii_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
   private final IiiiIiIii_Class236 III_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
   private final IiiiIiIii_Class236 IIi_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
   private final IiiiIiIii_Class236 IiI_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
   private final IiiiIiIii_Class236 Iii_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
   private final IiiiIiIii_Class236 iII_field_dc7facc = new IiiiIiIii_Class236(500L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private final IiiiIiIii_Class236 iIi_field_dc7facc = new IiiiIiIii_Class236(150L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
   private final IiiiIiIii_Class236 iiI_field_dc7facc = new IiiiIiIii_Class236(50L, 0.0F, IiiiIiiII_Class237.iIiI_field_dd60aac);
   private final IiiiIiIii_Class236[] I_field_a8159991 = new IiiiIiIii_Class236[4];
   private LivingEntity I_field_966247a3;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private boolean I_field_5a;
   private LivingEntity lastLingerTarget;
   private long lastLingerTime;
   private static final long LINGER_DURATION = 3000L;

   public IiIiIiiiI_Class175() {
      super("hud.targethud", "hud/target");

      for (int var1 = 0; var1 < this.I_field_a8159991.length; var1++) {
         this.I_field_a8159991[var1] = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
      }
   }

   @Override
   public void update(III var1) {
      super.update(var1);
      this.width = 110.0F;
      this.height = 36.0F;
   }

   @Override
   public void renderComponent(III var1) {
      LivingEntity var2 = this.I_method_361e2bac();
      if (var2 != null) {
         this.I_field_966247a3 = var2;
      }

      if (this.I_field_966247a3 != null) {
         IIiIIi_Class10 var3 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
         IIiIIi_Class10 var4 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(6.0F);
         IIiIIi_Class10 var5 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(7.0F);
         boolean var6 = RockstarClient.getInstance().I_method_9a720c62().I_method_ac8a0395() == IiIIIiIii_Class140.I_field_74daf6cc;
         ColorRGBA var7 = IiiiiIIIi_Class242.II_method_190e6391()
            .withAlpha(
               255.0F
                  * iIIiiiiiI_Class319.I_method_5f7ff5cf(
                     IiiiiIIIi_Class242.I_method_5ac4a715().II_method_b3b834f2(),
                     IiiiiIIIi_Class242.I_method_5ac4a715().Ii_method_b3c6c0d2(),
                     InterfaceModule.I_method_fdcdb22f()
                  )
            );
         boolean var8 = iIIiIIIiI_Class291.I_method_da20b32b(
            this.x + 36.0F,
            this.y + 2.0F + 6.0F * this.i_field_dc7facc.I_method_6ac4da6f(),
            Math.min(30.0F, IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F).I_method_2c375926(this.I_field_966247a3.getName().getString())),
            6.0,
            var1
         );
         if (!var8 || this.I_field_991c1e8c.I_method_58432069(1000L)) {
            this.I_field_5a = false;
         }

         boolean var9 = this.I_field_966247a3.isUsingItem() && this.I_field_966247a3.getActiveItem().contains(DataComponentTypes.FOOD);
         this.iIi_field_dc7facc.I_method_edd72835(var9);
         if (var9) {
            float var10 = (float)Math.sin(System.currentTimeMillis() / 100.0) * 0.5F + 0.5F;
            this.iiI_field_dc7facc.I_method_edd6dd21(var10);
         }

         this.Iii_field_dc7facc.I_method_edd72835(var8);
         this.iII_field_dc7facc.I_method_edd72835(this.I_field_5a);
         this.I_field_dc7facc.I_method_edd72835(this.animation.I_method_6ac4da6f() * this.visible.I_method_6ac4da6f() >= 1.0F);
         this.i_field_dc7facc.I_method_edd72835(this.I_field_dc7facc.I_method_6ac4da6f() >= 0.7F);
         this.II_field_dc7facc.I_method_edd72835(this.i_field_dc7facc.I_method_6ac4da6f() >= 0.7F);
         this.Ii_field_dc7facc.I_method_edd72835(this.II_field_dc7facc.I_method_6ac4da6f() >= 0.7F);
         this.iI_field_dc7facc.I_method_edd72835(this.I_field_dc7facc.I_method_6ac4da6f() >= 0.7F);
         this.ii_field_dc7facc
            .I_method_edd6dd11(
               (this.I_field_966247a3 instanceof PlayerEntity var29 ? IiiiiiiII_Class253.I_method_6c00a1c4(var29) : this.I_field_966247a3.getHealth())
                  / this.I_field_966247a3.getMaxHealth()
            );
         this.III_field_dc7facc.I_method_edd6dd11(this.I_field_966247a3.getAbsorptionAmount() / 20.0F);
         float var30 = this.I_field_966247a3 instanceof PlayerEntity var31 ? IiiiiiiII_Class253.I_method_6c00a1c4(var31) : this.I_field_966247a3.getHealth();
         this.IIi_field_dc7facc.I_method_edd6dd11(var30);
         if (this.animation.I_method_6ac4da6f() != 0.0F) {
            if (!this.I_field_500d0627.isSelected()) {
               float var32 = RenderSystem.getShaderColor()[3];
               ItemStack[] var34 = new ItemStack[]{this.I_field_966247a3.getMainHandStack(), this.I_field_966247a3.getOffHandStack()};
               boolean var13 = Arrays.stream(var34).anyMatch(var0 -> !var0.isEmpty());

               for (ItemStack var15 : this.I_field_966247a3.getArmorItems()) {
                  if (!var15.isEmpty()) {
                     var13 = true;
                     break;
                  }
               }

               if (var13) {
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                  var1.drawItem(Items.DIAMOND_CHESTPLATE, -992.0F, 994.0F, 1.0F);
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32);
               }

               float var37 = 0.0F;
               int var39 = 0;

               for (ItemStack var17 : this.I_field_966247a3.getArmorItems()) {
                  if (!var17.isEmpty()) {
                     var37 += (this.II_field_500d0627.isSelected() ? 11.0F : 5.0F + var4.I_method_2c375926(I_method_70579eff(var17))) + 2.0F;
                  }
               }

               float var42 = 11.0F;
               if (this.II_field_500d0627.isSelected()) {
                  for (ItemStack var20 : var34) {
                     if (!var20.isEmpty()) {
                        var37 += 13.0F;
                     }
                  }
               }

               this.IiI_field_dc7facc.I_method_edd6dd11(var37 - 2.0F);
               float var46 = -this.IiI_field_dc7facc.I_method_6ac4da6f() / 2.0F;
               ArrayList var48 = new ArrayList();

               for (ItemStack var54 : this.I_field_966247a3.getArmorItems()) {
                  this.I_field_a8159991[var39].I_method_edd72835(!var54.isEmpty());
                  float var21 = this.iI_field_dc7facc.I_method_6ac4da6f() * this.I_field_a8159991[var39].I_method_6ac4da6f();
                  if (var21 <= 0.001F) {
                     var39++;
                  } else {
                     String var22 = I_method_70579eff(var54);
                     boolean var23 = this.II_field_500d0627.isSelected();
                     float var24 = var23 ? 11.0F : 5.0F + var4.I_method_2c375926(var22);
                     float var25 = var23 ? 11.0F : 9.0F;
                     float var26 = this.x + this.width / 2.0F + var46;
                     float var27 = this.y + this.height - 4.0F + 6.0F * var21;
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32 * var21);
                     var1.drawBlurredRect(
                        var26,
                        var27,
                        var24,
                        var25,
                        5.0F,
                        IIiii_Class8.I_method_893b2757(1.5F),
                        ColorRGBA.WHITE.withAlpha(255.0F * this.animation.I_method_6ac4da6f())
                     );
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32);
                     var1.drawRoundedRect(var26, var27, var24, var25, IIiii_Class8.I_method_893b2757(1.5F), var7.withAlpha(var7.getAlpha() * var21));
                     iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var26, var27, var24, var25);
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32 * var21 * 0.5F);
                     if (this.i_field_500d0627.isSelected()) {
                        var1.drawItem(var54, var26 - 11.0F + var24 / 2.0F + 2.0F, var27 - 4.0F, 1.0F);
                     } else {
                        var1.drawItem(var54, var26 - 11.0F + var24 / 2.0F + 5.5F, var27, 0.7F);
                     }

                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32);
                     iIiiiIiII_Class373.I_method_ff80a1df();
                     if (this.i_field_500d0627.isSelected()) {
                        var48.add(new IiIiIiiiI_Class175.Nested1_a65dc3e0(var22, var26 + 3.0F, var27 + 2.5F, 255.0F * var21));
                     }

                     var46 += (var24 + 2.0F) * var21;
                     var39++;
                  }
               }

               if (!var48.isEmpty()) {
                  iiIIIIIIi_Class386 var51 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, IIiIiI_Class11.Ii_field_857c0621);

                  for (IiIiIiiiI_Class175.Nested1_a65dc3e0 var58 : (Iterable<IiIiIiiiI_Class175.Nested1_a65dc3e0>)(Iterable<?>)var48) {
                     var1.drawText(
                        var4,
                        var58.I_method_bd343806(),
                        var58.I_method_dababca(),
                        var58.i_method_dba37aa(),
                        IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(var58.II_method_a7d8c6b7())
                     );
                  }

                  var51.II_method_ed687102();
               }

               float var52 = Arrays.stream(var34).mapToInt(var1x -> var1x.isEmpty() ? 0 : (int)(var42 + 2.0F)).sum() - 2;
               float var56 = this.i_field_500d0627.isSelected() ? -var52 / 2.0F : var46;
               boolean var59 = false;

               for (ItemStack var64 : this.I_field_966247a3.getArmorItems()) {
                  if (!var64.isEmpty()) {
                     var59 = true;
                     break;
                  }
               }

               for (ItemStack var68 : var34) {
                  if (!var68.isEmpty()) {
                     float var69 = this.x + this.width / 2.0F + var56;
                     float var70 = this.y
                        + this.height
                        - 4.0F
                        + 6.0F * this.iI_field_dc7facc.I_method_6ac4da6f()
                        + (this.i_field_500d0627.isSelected() && var59 ? 12 : 0);
                     float var28 = this.iI_field_dc7facc.I_method_6ac4da6f()
                        * (var9 && this.I_field_966247a3.getActiveItem() == var68 ? 0.5F + 0.7F * this.iiI_field_dc7facc.I_method_6ac4da6f() : 1.0F);
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32 * var28);
                     var1.drawBlurredRect(
                        var69,
                        var70,
                        var42,
                        var42,
                        5.0F,
                        IIiii_Class8.I_method_893b2757(1.5F),
                        ColorRGBA.WHITE.withAlpha(255.0F * this.animation.I_method_6ac4da6f())
                     );
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32);
                     var1.drawRoundedRect(var69, var70, var42, var42, IIiii_Class8.I_method_893b2757(1.5F), var7.withAlpha(var7.getAlpha() * var28));
                     iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var69, var70, var42, var42);
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32 * var28);
                     var1.drawItem(var68, var69 - 11.0F + var42 / 2.0F + 5.5F, var70, 0.7F);
                     RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var32);
                     iIiiiIiII_Class373.I_method_ff80a1df();
                     var56 += var42 + 2.0F;
                     if (this.II_field_500d0627.isSelected()) {
                        var46 += (var42 + 2.0F) * this.iI_field_dc7facc.I_method_6ac4da6f();
                     }
                  }
               }
            }

            if (this.dragAnim.I_method_6ac4da6f() > 0.0F) {
               var1.drawShadow(
                  this.x - 5.0F,
                  this.y - 5.0F,
                  this.width + 10.0F,
                  this.height + 10.0F,
                  15.0F,
                  IIiii_Class8.I_method_893b2757(IiiiiIIIi_Class242.I_method_5ac4a715().I_method_37580a2f()),
                  ColorRGBA.BLACK.withAlpha(63.75F * this.dragAnim.I_method_6ac4da6f())
               );
            }

            var1.drawClientRect(this.x, this.y, this.width, this.height, this.animation.I_method_6ac4da6f(), this.dragAnim.I_method_6ac4da6f(), 7.0F);
            float var33 = 255.0F * this.I_field_dc7facc.I_method_6ac4da6f();
            float var35 = 255.0F * this.i_field_dc7facc.I_method_6ac4da6f();
            float var36 = 255.0F * this.Ii_field_dc7facc.I_method_6ac4da6f();
            float var38 = 255.0F * this.II_field_dc7facc.I_method_6ac4da6f();
            iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), this.x, this.y, this.width, this.height);
            if (this.I_field_966247a3 instanceof AbstractClientPlayerEntity var40) {
               var1.drawHead(
                  var40,
                  this.x + 5.0F * this.I_field_dc7facc.I_method_6ac4da6f(),
                  this.y + 5.0F,
                  26.0F,
                  IIiii_Class8.I_method_893b2757(5.0F),
                  IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(var33)
               );
            } else {
               var1.drawRoundedTexture(
                  RockstarClient.id(
                     InterfaceModule.IiI_method_c4cbfac3()
                        ? "icons/hud/whoglass.png"
                        : (
                           RockstarClient.getInstance().I_method_9a720c62().I_method_ac8a0395() == IiIIIiIii_Class140.I_field_74daf6cc
                              ? "icons/hud/whodark.png"
                              : "icons/hud/who.png"
                        )
                  ),
                  this.x + 5.0F * this.I_field_dc7facc.I_method_6ac4da6f(),
                  this.y + 5.0F,
                  26.0F,
                  26.0F,
                  IIiii_Class8.I_method_893b2757(5.0F),
                  IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(var33)
               );
            }

            NameProtectModule var41 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
            String var44 = this.I_field_966247a3.getName().getString();
            if (var41.isEnabled()) {
               var44 = var41.II_method_6ed9f394(var44);
            }

            String var47 = var30 == 1000.0F ? "?" : iIIIIiIiI_Class267.i_method_f3c598a1(this.IIi_field_dc7facc.I_method_6ac4da6f()).replace(",", ".");
            var1.drawFadeoutText(
               var3,
               var44,
               this.x + 36.0F + 8.0F * this.Iii_field_dc7facc.I_method_6ac4da6f(),
               this.y + 2.0F + 6.0F * this.i_field_dc7facc.I_method_6ac4da6f(),
               IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(var35),
               0.7F,
               1.0F,
               this.width - 45.0F - 8.0F * this.Iii_field_dc7facc.I_method_6ac4da6f() - var5.I_method_2c375926(var47)
            );
            float var49 = var35 * this.Iii_field_dc7facc.I_method_6ac4da6f() * (1.0F - this.iII_field_dc7facc.I_method_6ac4da6f());
            if (var49 > 0.5F) {
               iIiiiIIiI_Class371.I_method_6a1c0f0f(
                  var1.getMatrices(),
                  this.x + 34.0F + 5.0F * this.Iii_field_dc7facc.I_method_6ac4da6f(),
                  this.y + 5.0F + 6.0F * this.i_field_dc7facc.I_method_6ac4da6f(),
                  90.0F * this.iII_field_dc7facc.I_method_6ac4da6f()
               );
               var1.drawIcon(
                  "copy",
                  this.x + 31.0F + 5.0F * this.Iii_field_dc7facc.I_method_6ac4da6f(),
                  this.y + 2.0F + 6.0F * this.i_field_dc7facc.I_method_6ac4da6f(),
                  6.0F,
                  IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(var49)
               );
               iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            }

            float var53 = var35 * this.iII_field_dc7facc.I_method_6ac4da6f();
            if (var53 > 0.5F) {
               iIiiiIIiI_Class371.I_method_6a1c0f0f(
                  var1.getMatrices(),
                  this.x + 34.0F + 5.0F * this.Iii_field_dc7facc.I_method_6ac4da6f(),
                  this.y + 5.0F + 6.0F * this.i_field_dc7facc.I_method_6ac4da6f(),
                  -90.0F + 90.0F * this.iII_field_dc7facc.I_method_6ac4da6f()
               );
               var1.drawIcon(
                  "check",
                  this.x + 31.0F + 5.0F * this.Iii_field_dc7facc.I_method_6ac4da6f(),
                  this.y + 2.0F + 6.0F * this.i_field_dc7facc.I_method_6ac4da6f(),
                  6.0F,
                  IiiiiIIIi_Class242.i_field_d0c8ec5.withAlpha(var53)
               );
               iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            }

            float var57 = this.y + this.height - 7.0F - 6.0F * this.II_field_dc7facc.I_method_6ac4da6f();
            float barX = this.x + 36.0F;
            float barW = this.width - 43.0F;
            float barH = 5.5F;
            float var60 = barW * Math.clamp(this.ii_field_dc7facc.I_method_6ac4da6f(), 0.0F, 1.0F);
            float var63 = barW * Math.clamp(this.III_field_dc7facc.I_method_6ac4da6f(), 0.0F, 1.0F);
            iiIIIIiii_Class392 var66 = new iiIIIIiii_Class392(IIiIiI_Class11.Ii_field_857c0621, 1.5F);
            var66.I_method_2cf0d2ea(
               var1.getMatrices().peek().getPositionMatrix(),
               var47,
               var4.iI_method_24b6c285(),
               this.x + this.width - 7.0F - var4.I_method_2c375926(var47),
               this.y + 2.0F + 6.0F * this.Ii_field_dc7facc.I_method_6ac4da6f(),
               0.0F,
               IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(var36).getRGB()
            );
            var66.I_method_97950030(
               var1.getMatrices().peek().getPositionMatrix(),
               barX,
               var57,
               barW,
               barH,
               IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha(var38 * (1.0F - 0.7F * InterfaceModule.I_method_fdcdb22f()))
            );
            var66.I_method_97950030(
               var1.getMatrices().peek().getPositionMatrix(), barX, var57, var60, barH, IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(var38)
            );
            if (!iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) && var63 > 0.0F) {
               var66.I_method_97950030(
                  var1.getMatrices().peek().getPositionMatrix(), barX + barW - var63, var57, var63, barH, new ColorRGBA(255.0F, 220.0F, 81.0F, var38)
               );
            }

            var66.I_method_874ac61f();
            iIiiiIiII_Class373.I_method_ff80a1df();
         }
      }
   }

   public static String I_method_70579eff(ItemStack var0) {
      if (!var0.isEmpty() && var0.isDamageable()) {
         int var1 = var0.getMaxDamage();
         int var2 = var0.getDamage();
         if (var2 >= var1) {
            return "0%";
         } else {
            double var3 = 100.0 - (double)var2 / var1 * 100.0;
            return String.format("%.0f%%", var3);
         }
      } else {
         return "100%";
      }
   }

   private LivingEntity I_method_361e2bac() {
      LivingEntity active = null;
      LivingEntity var2 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var3 ? var3 : null;
      if (var2 != null) {
         if (!var2.isInvisible() && var2.isAlive()) {
            active = var2;
         }
      } else if (this.I_field_ba20ca4c.i_method_9b12da03() && I_field_3a9bda27.targetedEntity instanceof LivingEntity var5) {
         if (!var5.isInvisible() && var5.isAlive()) {
            active = var5;
         }
      } else if (I_field_3a9bda27.currentScreen instanceof ChatScreen) {
         active = I_field_3a9bda27.player;
      }

      if (active != null) {
         this.lastLingerTarget = active;
         this.lastLingerTime = System.currentTimeMillis();
         return active;
      }

      if (this.lastLingerTarget != null && this.lastLingerTarget.isAlive() && (System.currentTimeMillis() - this.lastLingerTime < LINGER_DURATION)) {
         return this.lastLingerTarget;
      }

      this.lastLingerTarget = null;
      return null;
   }

   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (this.I_field_966247a3 != null
         && iIIiIIIiI_Class291.I_method_c3f86263(
            this.x + 36.0F,
            this.y + 2.0F + 6.0F * this.i_field_dc7facc.I_method_6ac4da6f(),
            Math.min(30.0F, IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F).I_method_2c375926(this.I_field_966247a3.getName().getString())),
            6.0,
            var1,
            var3
         )) {
         iIIIIiIiI_Class267.I_method_c791669(I_field_3a9bda27.player.getName().getString());
         this.I_field_991c1e8c.I_method_23e11e3f();
         this.I_field_5a = true;
      } else {
         super.onMouseClicked(var1, var3, var5);
      }
   }

   @Override
   public boolean show() {
      return this.I_method_361e2bac() != null;
   }

   static final class Nested1_a65dc3e0 {
      private final String I_field_523beb0a;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;

      Nested1_a65dc3e0(String var1, float var2, float var3, float var4) {
         this.I_field_523beb0a = var1;
         this.I_field_46 = var2;
         this.i_field_46 = var3;
         this.II_field_46 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_a65dc3e0[text=" + this.I_field_523beb0a + ", x=" + this.I_field_46 + ", y=" + this.i_field_46 + ", alpha=" + this.II_field_46 + "]";
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
         IiIiIiiiI_Class175.Nested1_a65dc3e0 other = (IiIiIiiiI_Class175.Nested1_a65dc3e0) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46);
      }

      public String I_method_bd343806() {
         return this.I_field_523beb0a;
      }

      public float I_method_dababca() {
         return this.I_field_46;
      }

      public float i_method_dba37aa() {
         return this.i_field_46;
      }

      public float II_method_a7d8c6b7() {
         return this.II_field_46;
      }
   }
}
