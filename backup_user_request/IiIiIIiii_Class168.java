package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import pyrock.utility.render.ColorRGBA;

public abstract class IiIiIIiii_Class168 extends IiIiIIiII_Class165 {
   public IiIiIIiii_Class168(String var1, String var2) {
      super(var1, var2);
   }

   @Override
   public void render(III var1) {
      this.update(var1);
      float var2 = this.animation.I_method_6ac4da6f() * this.visible.I_method_6ac4da6f();
      if (var2 != 0.0F) {
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, Math.min(1.0F, var2));
         float var3 = this.inertion.getX();
         float var4 = this.inertion.getY();
         float var5 = this.inertion.getWidth();
         float var6 = this.inertion.getHeight();
         float var7 = 0.5F + var2 * 0.5F - 0.05F * this.selecting.I_method_6ac4da6f();
         iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var3 + var5 / 2.0F, var4 + var6 / 2.0F, var7);
         var1.drawShadow(
            var3 - 5.0F,
            var4 - 5.0F,
            var5 + 10.0F,
            var6 + 10.0F,
            15.0F,
            IIiii_Class8.I_method_893b2757(6.0F),
            ColorRGBA.BLACK.withAlpha(63.75F * this.dragAnim.I_method_6ac4da6f())
         );
         iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var3, var4, var5, Math.max(20.0F, var6));
         this.renderComponent(var1);
         iIiiiIiII_Class373.I_method_ff80a1df();
         iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   @Override
   public void renderComponent(III var1) {
      IIiIIi_Class10 var2 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      if (InterfaceModule.IiI_method_c4cbfac3()) {
         this.inertion.I_method_27ea37f5(this.x, this.y, this.width, this.height, this.isDragging());
      } else {
         this.inertion.set(this.x, this.y, this.width, this.height);
      }

      float var3 = this.inertion.getX();
      float var4 = this.inertion.getY();
      float var5 = this.inertion.getWidth();
      float var6 = this.inertion.getHeight();
      var1.drawClientRect(var3, var4, var5, Math.max(20.0F, var6), this.animation.I_method_6ac4da6f(), this.dragAnim.I_method_6ac4da6f(), 7.0F);
      float var7 = 8.0F;
      var1.drawText(
         IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
         IiIiIIII_Class81.I_method_f25a980a(this.name),
         var3 + 7.0F,
         var4 + iIIiIIIiI_Class291.I_method_ef5e7a8f(var2.I_method_a649725c(), 18.0F) + 0.5F,
         IiiiiIIIi_Class242.iI_method_8e08d3b1()
      );
      var1.drawIcon(this.icon, var3 + var5 - var7 - 7.0F, var4 + 6.0F, var7, IiiiiIIIi_Class242.iII_field_d0c8ec5);
      if (var6 >= 23.0F) {
         var1.drawRect(var3, var4 + 18.0F, var5, 4.0F, IiiiiIIIi_Class242.IIi_method_68904cce());
      }
   }
}
