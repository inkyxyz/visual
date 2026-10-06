package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import globals.client.ui.RocknetMenu;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lombok.Generated;
import pyrock.utility.render.ColorRGBA;

public class IiIIiiIii_Class156 extends iI_Class3 {
   private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private boolean i_field_5a;
   private final float iI_field_46;
   private Runnable I_field_bac0a97e = () -> {};
   private boolean II_field_5a;
   private boolean Ii_field_5a = true;
   private boolean iI_field_5a;
   private boolean ii_field_5a;
   private float ii_field_46 = -1.0F;
   private long I_field_4a;
   private final Set<IIiiiIIiI_Class115> I_field_a56a8dc5 = new LinkedHashSet<>();
   private final iii_Class8 I_field_b584628c = new iii_Class8()
      .I_method_485bccf5()
      .I_method_7e2bb176(IIII.I_method_b1e865cb(4.0F, 0.0F))
      .Ii_method_bb38d618()
      .I_method_b65baecb(
         var0 -> var0.i_method_65326e43(2.0F)
            .I_method_4f0ff9cb(1.0F, 4.0F)
            .I_method_2a080a63(2.5F)
            .i_method_989a5f71(
               var0x -> ColorRGBA.BLACK
                  .mix(ColorRGBA.WHITE, 0.3F)
                  .withAlpha(255.0F * (0.32F + 0.28F * var0x.I_method_af833bdc() + 0.3F * var0x.i_method_af91c7bc()))
            )
      );
   public static final List<iiI_Class7> I_field_7865b31 = new LinkedList<>();
   public static boolean I_field_5a;

   public static <T extends iiI_Class7> T I_method_82b97efd(T var0) {
      I_field_7865b31.add(var0);
      return (T)var0;
   }

   public IiIIiiIii_Class156(float var1, float var2) {
      this(var1, var2, 90.0F);
   }

   public IiIIiiIii_Class156(float var1, float var2, float var3) {
      this(var1, var2, var3, 2.0F);
   }

   public IiIIiiIii_Class156(float var1, float var2, float var3, float var4) {
      this.I_field_46 = var1;
      this.i_field_46 = var2;
      this.II_field_46 = var3;
      this.iI_field_46 = var4;
      this.i_field_5a = true;
   }

   @Override
   protected void i_method_bdd4e0ec(III var1) {
      this.I_field_dc7facc.I_method_df2f9087(this.i_field_5a ? IiiiIiiII_Class237.I_field_dd60aac : IiiiIiiII_Class237.iI_field_dd60aac);
      this.I_field_dc7facc.I_method_edd72835(this.i_field_5a);
      long var2 = System.currentTimeMillis();
      float var4 = this.I_field_4a == 0L ? 16.0F : Math.min(64.0F, (float)(var2 - this.I_field_4a));
      this.I_field_4a = var2;
      this.I_field_b584628c.IIi_method_4dfc88d7(this.II_field_46);
      if (this.iI_field_5a) {
         this.I_field_b584628c.Ii_method_81121d98(this.II_field_46, this.Ii_field_46);
      }

      this.I_field_b584628c.prepareRoot();
      if (this.ii_field_46 >= 0.0F) {
         float var5 = Math.max(this.ii_field_46, I_field_3a9bda27.getWindow().getScaledWidth() - this.ii_field_46 - this.II_field_46);
         float var6 = Math.max(this.ii_field_46, I_field_3a9bda27.getWindow().getScaledHeight() - this.ii_field_46 - this.I_field_b584628c.h());
         this.I_field_46 = Math.clamp(this.I_field_46, this.ii_field_46, var5);
         this.i_field_46 = Math.clamp(this.i_field_46, this.ii_field_46, var6);
      }

      this.I_field_b584628c.snapAt(this.I_field_46, this.i_field_46);
      if (this.I_field_dc7facc.I_method_6ac4da6f() < 0.999F) {
         this.I_field_b584628c.snapSubtree();
      }

      this.I_field_b584628c.tick(var4, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
      this.Ii_field_46 = this.I_field_b584628c.h();
      boolean var9 = true;

      for (iiI_Class7 var7 : this.I_field_b584628c.I_method_38e5328()) {
         if (var7.inFlow()) {
            var9 = false;
            break;
         }
      }

      float var11 = Math.min(1.0F, this.I_field_dc7facc.I_method_6ac4da6f());
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var11);
      iIiiiIIiI_Class371.II_method_e18635ac(
         var1.getMatrices(),
         this.I_field_46 + this.II_field_46 / this.iI_field_46,
         this.i_field_46 + this.Ii_field_46 / this.iI_field_46,
         0.5F + this.I_field_dc7facc.I_method_6ac4da6f() * 0.5F
      );
      if (this.Ii_field_5a && !var9) {
         if (this.ii_field_5a) {
            var1.drawShadow(
               this.I_field_46,
               this.i_field_46,
               this.II_field_46,
               this.Ii_field_46,
               25.0F,
               IIiii_Class8.I_method_893b2757(11.0F),
               IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F)
            );
            var1.drawBlurredRect(
               this.I_field_46,
               this.i_field_46,
               this.II_field_46,
               this.Ii_field_46,
               5.0F,
               3.0F,
               IIiii_Class8.I_method_893b2757(11.0F),
               IiiiiIIIi_Class242.Ii_field_d0c8ec5
            );
            var1.drawSquircle(
               this.I_field_46,
               this.i_field_46,
               this.II_field_46,
               this.Ii_field_46,
               3.0F,
               IIiii_Class8.I_method_893b2757(11.0F),
               IiiiiIIIi_Class242.III_field_d0c8ec5
            );
            var1.drawSquircleBorder(
               this.I_field_46,
               this.i_field_46,
               this.II_field_46,
               this.Ii_field_46,
               0.5F,
               3.0F,
               IIiii_Class8.I_method_893b2757(11.0F),
               IiiiiIIIi_Class242.IiI_field_d0c8ec5
            );
         } else {
            float popAlpha = this.I_field_dc7facc.I_method_6ac4da6f();
            IIiii_Class8 popupRad = IIiii_Class8.I_method_893b2757(8.0F);
            ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();

            // Soft deep double drop shadow for authentic floating panel
            var1.drawShadow(
               this.I_field_46,
               this.i_field_46,
               this.II_field_46,
               this.Ii_field_46,
               18.0F,
               popupRad,
               ColorRGBA.BLACK.withAlpha(160.0F * popAlpha)
            );
            var1.drawShadow(
               this.I_field_46,
               this.i_field_46 + 2.0F,
               this.II_field_46,
               this.Ii_field_46,
               28.0F,
               popupRad,
               ColorRGBA.BLACK.withAlpha(100.0F * popAlpha)
            );

            if (I_field_3a9bda27.currentScreen instanceof RocknetMenu) {
               var1.drawSquircle(
                  this.I_field_46,
                  this.i_field_46,
                  this.II_field_46,
                  this.Ii_field_46,
                  7.0F,
                  popupRad,
                  IiiiiIIIi_Class242.II_method_190e6391()
               );
            } else {
               if (InterfaceModule.iII_method_f9a41e83()) {
                  var1.drawBlurredRect(
                     this.I_field_46,
                     this.i_field_46,
                     this.II_field_46,
                     this.Ii_field_46,
                     35.0F,
                     4.0F,
                     popupRad,
                     ColorRGBA.WHITE.withAlpha(200.0F * popAlpha * InterfaceModule.i_method_fddc3e0f())
                  );
               }

               if (InterfaceModule.Iii_method_c4da86a3()) {
                  var1.drawLiquidGlass(
                     this.I_field_46,
                     this.i_field_46,
                     this.II_field_46,
                     this.Ii_field_46,
                     8.0F,
                     0.15F,
                     popupRad,
                     ColorRGBA.WHITE.withAlpha(255.0F * popAlpha * InterfaceModule.I_method_fdcdb22f())
                  );
               }

               // Deep Obsidian Glass base fill
               var1.drawSquircle(
                  this.I_field_46,
                  this.i_field_46,
                  this.II_field_46,
                  this.Ii_field_46,
                  3.0F,
                  popupRad,
                  new ColorRGBA(10.0F, 11.0F, 16.0F, 245.0F * popAlpha)
               );

               // Specular perimeter border highlight
               var1.drawSquircleBorder(
                  this.I_field_46,
                  this.i_field_46,
                  this.II_field_46,
                  this.Ii_field_46,
                  0.8F,
                  3.0F,
                  popupRad,
                  new ColorRGBA(255.0F, 255.0F, 255.0F, 45.0F * popAlpha)
               );

               // Themed glow edge accent
               var1.drawBlurredRect(
                  this.I_field_46,
                  this.i_field_46,
                  this.II_field_46,
                  this.Ii_field_46,
                  12.0F,
                  3.0F,
                  popupRad,
                  themeAccent.withAlpha(35.0F * popAlpha)
               );

               // Top specular reflection hairline
               var1.drawSquircle(
                  this.I_field_46 + 4.0F,
                  this.i_field_46 + 0.8F,
                  this.II_field_46 - 8.0F,
                  1.0F,
                  1.0F,
                  IIiii_Class8.I_method_893b2757(0.5F),
                  new ColorRGBA(255.0F, 255.0F, 255.0F, 70.0F * popAlpha)
               );
            }
         }
      }

      if (!var9) {
         this.I_field_b584628c.draw(var1, var11);
      }

      iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      if (!I_field_5a) {
         I_field_7865b31.removeIf(var0 -> !var0.alive());

         for (iiI_Class7 var8 : I_field_7865b31) {
            var8.prepareRoot();
            var8.tick(var4, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
         }

         for (iiI_Class7 var14 : I_field_7865b31) {
            var14.draw(var1, 1.0F);
         }

         I_field_5a = true;
      }
   }

   private IiIIiiIii_Class156 I_method_812bea3d(iiI_Class7 var1) {
      this.I_field_b584628c.I_method_8939bffd(var1);
      return this;
   }

   public IiIIiiIii_Class156 I_method_cbb5737d(Setting var1) {
      if (var1 instanceof AbstractSetting var2) {
         this.I_field_a56a8dc5.add(var2.I_method_3ac66f15());
      }

      return this.I_method_812bea3d(IiiIiiIIi_Class218.I_method_83bcc05d(var1));
   }

   public boolean I_method_6127fa63() {
      return IIiiiIIIi_Class114.I_method_84059a74(this.I_field_a56a8dc5);
   }

   public boolean i_method_61368643() {
      return IIiiiIIIi_Class114.i_method_bf2ffe54(this.I_field_a56a8dc5);
   }

   public IiIIiiIii_Class156 I_method_880b4e76(final iI_Class3 var1) {
      return this.I_method_812bea3d((new iii_Class8() {
         @Override
         public float desiredH() {
            return var1.Ii_method_2047ead7();
         }

         @Override
         protected void onTick(float var1x, float var2, float var3) {
         }

         @Override
         protected void drawSelf(III var1x, float var2) {
            var1.I_method_b043bcc(this.x(), this.y(), this.w(), var1.Ii_method_2047ead7());
            if (var1 instanceof IiiIiiIii_Class220 var3) {
               var3.iI_method_2b3782de(this.y());
               var3.ii_method_2cfa72fe(var1.Ii_method_2047ead7());
            }

            var1.I_method_7ae26dda(var1x);
            if (var1 instanceof IiiIiiIii_Class220 var4) {
               var4.Ii_method_6b12c484(var1x);
            }
         }

         @Override
         public boolean mouseClicked(float var1x, float var2, IiIII_Class9 var3) {
            if (!this.contains(var1x, var2)) {
               return false;
            } else {
               var1.I_method_400ceaa7(var1x, var2, var3);
               return true;
            }
         }

         @Override
         public void mouseReleased(float var1x, float var2, IiIII_Class9 var3) {
            var1.i_method_6a097ac7(var1x, var2, var3);
            super.mouseReleased(var1x, var2, var3);
         }

         @Override
         public boolean mouseScrolled(float var1x, float var2, float var3, float var4) {
            if (!this.contains(var1x, var2)) {
               return false;
            } else {
               var1.I_method_6b0ad25f(var1x, var2, var3, var4);
               return false;
            }
         }

         @Override
         public boolean keyPressed(int var1x, int var2, int var3) {
            var1.I_method_c1acbc24(var1x, var2, var3);
            return false;
         }

         @Override
         public boolean charTyped(char var1x, int var2) {
            return var1.I_method_b71e84c9(var1x, var2);
         }
      }).III_method_9dc17555());
   }

   public IiIIiiIii_Class156 I_method_68a6b2ff(String var1) {
      return this.I_method_812bea3d(
         new iii_Class8()
            .IiI_method_31d4c97(14.0F)
            .III_method_9dc17555()
            .I_method_3301fdd(iII_Class5.II_field_b583e68c)
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
            .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
            .I_method_8939bffd(
               new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), () -> IiIiIIII_Class81.I_method_f25a980a(var1))
                  .I_method_6da713d1(var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75F))
                  .I_method_c8e402a3(0.75F)
                  .fill()
            )
      );
   }

   public IiIIiiIii_Class156 i_method_a1faeedf(String var1) {
      return this.I_method_c43e1b0(var1, 7, false);
   }

   public IiIIiiIii_Class156 I_method_c43e1b0(String var1, int var2, boolean var3) {
      iii_Class8 var4 = new iii_Class8()
         .IiI_method_31d4c97(16.0F)
         .III_method_9dc17555()
         .I_method_3301fdd(iII_Class5.II_field_b583e68c)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
         .I_method_8939bffd(
            new iiII_Class13(IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(var2), () -> IiIiIIII_Class81.I_method_f25a980a(var1))
               .I_method_6da713d1(var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5)
               .I_method_c8e402a3(0.75F)
               .fill()
         );
      if (var3) {
         var4.IIIi_method_128839b8();
      }

      return this.I_method_812bea3d(var4);
   }

   public IiIIiiIii_Class156 I_method_88131b75() {
      return this.I_method_812bea3d(
         new Iii_Class4()
            .fillWidth()
            .height(5.0F)
            .paint(
               (var0, var1) -> {
                  ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
                  var0.drawRect(var1.x() + 6.0F, var1.y() + var1.h() / 2.0F - 0.4F, var1.w() - 12.0F, 0.8F, themeAccent.withAlpha(70.0F));
               }
            )
      );
   }

   public IiIIiiIii_Class156 I_method_e1f57a1(String var1, boolean var2) {
      return this.I_method_a9dcf031(var1, var2, null);
   }

   public IiIIiiIii_Class156 I_method_a9dcf031(String var1, boolean var2, IiIIiiIiI_Class155 var3) {
      boolean[] var4 = new boolean[]{var2};
      return this.I_method_812bea3d(
         new iii_Class8()
            .IiI_method_31d4c97(17.0F)
            .III_method_9dc17555()
            .I_method_70a38517(5.0F)
            .I_method_3301fdd(iII_Class5.II_field_b583e68c)
            .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
            .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
            .I_method_8939bffd(
               new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), () -> var1)
                  .I_method_6da713d1(var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75F + 0.25F * var0.hover()))
                  .I_method_c8e402a3(0.75F)
                  .fill()
            )
            .I_method_8939bffd(new IIiiI_Class7(() -> var4[0]).i_method_c4678f15(() -> IiiiiIIIi_Class242.IIi_field_d0c8ec5).size(13.0F, 8.0F))
            .I_method_c0ca36f3(() -> {
               var4[0] = !var4[0];
               if (var3 != null) {
                  var3.handleAction(var4[0]);
               }
            })
            .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
      );
   }

   public IiIIiiIii_Class156 I_method_78c7e89(String var1, String var2, IiIIiiiII_Class157 var3) {
      boolean var4 = var1.equals(IiIiIIII_Class81.I_method_f25a980a("remove"));
      ColorRGBA var5 = var4 ? ColorRGBA.RED.mix(ColorRGBA.WHITE, 0.3F) : IiiiiIIIi_Class242.iII_field_d0c8ec5;
      return this.I_method_812bea3d(
         new iii_Class8()
            .IiI_method_31d4c97(17.0F)
            .III_method_9dc17555()
            .I_method_70a38517(5.0F)
            .I_method_3301fdd(iII_Class5.II_field_b583e68c)
            .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
            .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
            .I_method_8939bffd(
               new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), () -> var1)
                  .I_method_6da713d1(var1x -> var5.mulAlpha(0.75F + 0.25F * var1x.hover()))
                  .I_method_c8e402a3(0.75F)
                  .fill()
            )
            .I_method_8939bffd(
               new Iii_Class4()
                  .size(8.0F, 8.0F)
                  .interactive(false)
                  .paint((var2x, var3x) -> var2x.drawIcon(var2, var3x.x(), var3x.y(), var3x.w(), var5.mulAlpha(0.75F + 0.25F * var3x.hover())))
            )
            .I_method_c0ca36f3(() -> var3.run(this))
            .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
      );
   }

   public IiIIiiIii_Class156 I_method_4fd12b10(String var1, int var2) {
      return this.I_method_dbddb22(var1, var2, null);
   }

   public IiIIiiIii_Class156 I_method_dbddb22(String var1, int var2, IiIIiiIIi_Class154 var3) {
      int[] var4 = new int[]{var2};
      iiiI_Class15 var5 = new iiiI_Class15(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), () -> var4[0], var2x -> {
         var4[0] = var2x;
         if (var3 != null) {
            var3.handleAction(var2x);
         }
      });
      return this.I_method_812bea3d(
         new iii_Class8()
            .IiI_method_31d4c97(17.0F)
            .III_method_9dc17555()
            .I_method_70a38517(5.0F)
            .I_method_3301fdd(iII_Class5.II_field_b583e68c)
            .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
            .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
            .I_method_8939bffd(
               new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), () -> var1)
                  .I_method_6da713d1(var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75F + 0.25F * var0.hover()))
                  .I_method_c8e402a3(0.75F)
                  .fill()
            )
            .I_method_8939bffd(var5)
            .i_method_5db1deeb(var5::I_method_10341dfa)
            .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
      );
   }

   public IiIIiiIii_Class156 I_method_e752e33d(KeybindSetting var1) {
      return this.I_method_dbddb22(IiIiIIII_Class81.I_method_f25a980a(var1.getName()), var1.I_method_fa6281d2(), var1::I_method_51ee2d04);
   }

   public IiIIiiIii_Class156 I_method_c64be67f(String var1, float var2, float var3, float var4, float var5) {
      return this.I_method_3940273(var1, var2, var3, var4, var5, null);
   }

   public IiIIiiIii_Class156 I_method_3940273(String var1, float var2, float var3, float var4, float var5, IiIIiiiiI_Class159 var6) {
      float[] var7 = new float[]{var4};
      iii_Class8 var8 = new iii_Class8()
         .I_method_70a38517(6.0F)
         .I_method_3301fdd(iII_Class5.II_field_b583e68c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .III_method_9dc17555()
         .I_method_8939bffd(
            new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), () -> var1)
               .I_method_6da713d1(var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75F + 0.25F * var0.hover()))
               .I_method_c8e402a3(0.75F)
               .fill()
         )
         .I_method_8939bffd(new iiii_Class16(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), () -> var7[0], var2x -> {
            var7[0] = var2x;
            if (var6 != null) {
               var6.I_method_af9e3141(var2x);
            }
         }, var2, var3).I_method_c389f5c5(() -> iIIIIiIiI_Class267.I_method_230e44c1(var7[0])).I_method_46f30bd1(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5));
      return this.I_method_812bea3d(
         new iii_Class8()
            .I_method_3301fdd(iII_Class5.I_field_b583e68c)
            .III_method_9dc17555()
            .I_method_70a38517(5.0F)
            .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
            .I_method_8939bffd(var8)
            .I_method_8939bffd(
               new IIIii_Class4(() -> var7[0], var2x -> {
                     var7[0] = var2x;
                     if (var6 != null) {
                        var6.I_method_af9e3141(var2x);
                     }
                  }, var2, var3)
                  .I_method_ec139357(var5)
                  .I_method_d614f735()
                  .ii_method_626eab4(6.0F)
                  .i_method_1635ab77(3.0F)
                  .II_method_c1e3e6b4(3.0F)
                  .Ii_method_ec05fed4(1.5F)
                  .I_method_1f4f9269(var0 -> IiiiiIIIi_Class242.IIi_field_d0c8ec5)
                  .i_method_49da3a89(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(1.0F - 0.25F * var0.hover()))
                  .I_method_f6d86b76(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.II_field_dd60aac))
            )
      );
   }

   public IiIIiiIii_Class156 I_method_8f5bef3(Runnable var1) {
      this.I_field_bac0a97e = var1;
      return this;
   }

   public IiIIiiIii_Class156 I_method_dc3ffdeb(boolean var1) {
      this.Ii_field_5a = var1;
      return this;
   }

   public IiIIiiIii_Class156 i_method_9da88f55() {
      this.ii_field_5a = true;
      return this;
   }

   public IiIIiiIii_Class156 I_method_a20223d7(float var1) {
      this.ii_field_46 = Math.max(0.0F, var1);
      return this;
   }

   public IiIIiiIii_Class156 i_method_3f1b2bf7(float var1) {
      this.Ii_field_46 = var1;
      this.iI_field_5a = true;
      return this;
   }

   public void I_method_c3d80455(boolean var1) {
      this.i_field_5a = var1;
      if (!var1 && !this.II_field_5a) {
         this.I_field_bac0a97e.run();
         this.II_field_5a = true;
      }
   }

   @Override
   public void I_method_400ceaa7(double var1, double var3, IiIII_Class9 var5) {
      for (int var6 = I_field_7865b31.size() - 1; var6 >= 0; var6--) {
         if (I_field_7865b31.get(var6).mouseClicked((float)var1, (float)var3, var5)) {
            return;
         }
      }

      this.I_field_b584628c.mouseClicked((float)var1, (float)var3, var5);
      super.I_method_400ceaa7(var1, var3, var5);
   }

   @Override
   public void i_method_6a097ac7(double var1, double var3, IiIII_Class9 var5) {
      for (iiI_Class7 var7 : I_field_7865b31) {
         var7.mouseReleased((float)var1, (float)var3, var5);
      }

      this.I_field_b584628c.mouseReleased((float)var1, (float)var3, var5);
      super.i_method_6a097ac7(var1, var3, var5);
   }

   @Override
   public void I_method_6b0ad25f(double var1, double var3, double var5, double var7) {
      for (int var9 = I_field_7865b31.size() - 1; var9 >= 0; var9--) {
         if (I_field_7865b31.get(var9).mouseScrolled((float)var1, (float)var3, (float)var5, (float)var7)) {
            return;
         }
      }

      this.I_field_b584628c.mouseScrolled((float)var1, (float)var3, (float)var5, (float)var7);
      super.I_method_6b0ad25f(var1, var3, var5, var7);
   }

   @Override
   public void I_method_c1acbc24(int var1, int var2, int var3) {
      if (!this.I_method_2d0713e8(var1, var2, var3)) {
         super.I_method_c1acbc24(var1, var2, var3);
      }
   }

   public boolean I_method_2d0713e8(int var1, int var2, int var3) {
      for (int var4 = I_field_7865b31.size() - 1; var4 >= 0; var4--) {
         if (I_field_7865b31.get(var4).keyPressed(var1, var2, var3)) {
            return true;
         }
      }

      return this.I_field_b584628c.keyPressed(var1, var2, var3);
   }

   @Override
   public boolean I_method_b71e84c9(char var1, int var2) {
      for (int var3 = I_field_7865b31.size() - 1; var3 >= 0; var3--) {
         if (I_field_7865b31.get(var3).charTyped(var1, var2)) {
            return true;
         }
      }

      return this.I_field_b584628c.charTyped(var1, var2) ? true : super.I_method_b71e84c9(var1, var2);
   }

   @Generated
   public IiiiIiIii_Class236 I_method_ea650b95() {
      return this.I_field_dc7facc;
   }

   @Generated
   public boolean II_method_c3e648e6() {
      return this.i_field_5a;
   }
}
