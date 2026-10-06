package rockstar.client;

import java.util.ArrayList;
import java.util.List;

public class IiiIIIiIi_Class198 extends IiIiIIiII_Class165 {
   protected final MultiSelectSetting I_field_bbe3ba6c = new MultiSelectSetting(this, "elements").I_method_bba86af5().I_method_702bd95a(1);

   public IiiIIIiIi_Class198(String var1, String var2) {
      super(var1, var2);
      this.height = 18.0F;
   }

   @Override
   protected iii_Class8 build() {
      ArrayList var1 = new ArrayList();

      for (MultiSelectSetting.Nested1_42856060 var3 : this.I_field_bbe3ba6c.I_method_45aaa648()) {
         var1.add((IiiIIIiiI_Class199)var3);
      }

      iii_Class8 var6 = new iii_Class8().i_method_c88da8d5().I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_70a38517(0.0F);

      for (int var7 = 0; var7 < var1.size(); var7++) {
         IiiIIIiiI_Class199 var4 = (IiiIIIiiI_Class199)var1.get(var7);
         int var5 = var7;
         var6.I_method_8939bffd(
            new Iii_Class4()
               .size(10.0F, 2.0F)
               .interactive(false)
               .visibleWhen(() -> var4.isSelected() && I_method_18198c17(var1, var5))
               .paint(
                  (var0, var1x) -> var0.drawRoundedRect(
                     var1x.x() + var1x.w() / 2.0F - 1.0F,
                     var1x.y() + var1x.h() / 2.0F - 1.0F,
                     2.0F,
                     2.0F,
                     IIiii_Class8.I_method_893b2757(1.0F),
                     IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.5F)
                  )
               )
         );
         var6.I_method_8939bffd(this.I_method_ef2b78bd(var4).visibleWhen(var4::isSelected));
      }

      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .IiI_method_31d4c97(15.0F)
         .I_method_70a38517(3.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 5.0F, 0.0F, 4.0F))
         .I_method_f136b1d8(
            (var1x, var2) -> {
               var1x.drawClientRect(var2.x(), var2.y(), var2.w(), var2.h(), this.animation.I_method_6ac4da6f(), this.dragAnim.I_method_6ac4da6f(), 3.0F, 5.0F);
               var1x.drawSquircle(
                  var2.x(),
                  var2.y(),
                  23.0F,
                  var2.h(),
                  3.0F,
                  IIiii_Class8.I_method_893b2757(5.0F),
                  new IiIii_Class12(IiiiiIIIi_Class242.Iii_field_d0c8ec5.mulAlpha(0.1F), IiiiiIIIi_Class242.Iii_field_d0c8ec5.mulAlpha(0.0F))
               );
            }
         )
         .I_method_8939bffd(
            new Iii_Class4().size(7.0F, 7.0F).interactive(false).icon(this.icon, 7.0F, var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.withAlpha(255.0F))
         )
         .I_method_8939bffd(var6);
   }

   private iiI_Class7 I_method_ef2b78bd(final IiiIIIiiI_Class199 var1) {
      final IIiIIi_Class10 var2 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
      final IIiIIi_Class10 var3 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
      return (new iiI_Class7() {
            @Override
            protected void measure() {
               float var1x = var1.i_method_7b8d6061().isEmpty() ? 0.0F : 8.0F * this.hover();
               float var2x = var1.II_method_2ac143de().isEmpty() ? 0.0F : var3.I_method_2c375926(var1.II_method_2ac143de());
               this.prefW = var1x + var2.I_method_2c375926(var1.I_method_e86eb041()) + var2x;
               this.prefH = var2.I_method_a649725c();
            }

            @Override
            protected void onTick(float var1x, float var2x, float var3x) {
               if (!this.hovered() || var1.I_method_dafe4735().I_method_58432069(1000L)) {
                  var1.I_method_e37401eb(false);
               }

               var1.i_method_653f9755().I_method_edd72835(var1.I_method_b2b2a43());
            }

            @Override
            protected void drawSelf(III var1x, float var2x) {
               float var3x = var1.i_method_7b8d6061().isEmpty() ? 0.0F : this.hover();
               float var4 = 8.0F * var3x;
               float var5 = var1.i_method_653f9755().I_method_6ac4da6f();
               float var6 = this.x();
               float var7 = this.y() + this.h() / 2.0F - 3.0F;
               float var8 = var3x * (1.0F - var5);
               if (var8 > 0.001F) {
                  iIiiiIIiI_Class371.I_method_6a1c0f0f(var1x.getMatrices(), var6 + 3.0F, var7 + 3.0F, 90.0F * var5);
                  var1x.drawIcon("copy", var6, var7, 6.0F, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(var8));
                  iIiiiIIiI_Class371.I_method_10503b11(var1x.getMatrices());
               }

               float var9 = var3x * var5;
               if (var9 > 0.001F) {
                  iIiiiIIiI_Class371.I_method_6a1c0f0f(var1x.getMatrices(), var6 + 3.0F, var7 + 3.0F, -90.0F + 90.0F * var5);
                  var1x.drawIcon("check", var6, var7, 6.0F, IiiiiIIIi_Class242.i_field_d0c8ec5.mulAlpha(var9));
                  iIiiiIIiI_Class371.I_method_10503b11(var1x.getMatrices());
               }

               float var10 = this.x() + var4;
               float var11 = this.y() + this.h() / 2.0F - var2.I_method_a649725c() / 2.0F;
               var1x.drawText(var2, var1.I_method_e86eb041(), var10, var11, IiiiiIIIi_Class242.iI_method_8e08d3b1());
               if (!var1.II_method_2ac143de().isEmpty()) {
                  var1x.drawText(
                     var3,
                     var1.II_method_2ac143de(),
                     var10 + var2.I_method_2c375926(var1.I_method_e86eb041()),
                     var11,
                     IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(0.5F)
                  );
               }
            }

            @Override
            public boolean mouseClicked(float var1x, float var2x, IiIII_Class9 var3x) {
               if (!this.interactive || !this.inFlow() || !this.contains(var1x, var2x)) {
                  return false;
               } else if (var3x == IiIII_Class9.I_field_2f4c8d6c && !var1.i_method_7b8d6061().isEmpty()) {
                  iIIIIiIiI_Class267.I_method_c791669(var1.i_method_7b8d6061());
                  var1.I_method_dafe4735().I_method_23e11e3f();
                  var1.I_method_e37401eb(true);
                  return true;
               } else {
                  return false;
               }
            }
         })
         .snapSize();
   }

   private static boolean I_method_18198c17(List<IiiIIIiiI_Class199> var0, int var1) {
      for (int var2 = 0; var2 < var1; var2++) {
         if (((IiiIIIiiI_Class199)var0.get(var2)).isSelected()) {
            return true;
         }
      }

      return false;
   }

   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (this.flow == null || !this.isShowing() || var5 != IiIII_Class9.I_field_2f4c8d6c || !this.flow.mouseClicked((float)var1, (float)var3, var5)) {
         super.onMouseClicked(var1, var3, var5);
      }
   }

   @Override
   public void onMouseReleased(double var1, double var3, IiIII_Class9 var5) {
      if (this.flow != null) {
         this.flow.mouseReleased((float)var1, (float)var3, var5);
      }

      super.onMouseReleased(var1, var3, var5);
   }
}
