package rockstar.client;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import pyrock.utility.render.ColorRGBA;

public class IIiII_Class5 extends iiI_Class7 {
   private final IIiIIi_Class10 I_field_856d0221;
   private final IiIiIIIII_Class161 I_field_fdef2cc;
   private final Consumer<String> I_field_f9f609fa;
   private String I_field_523beb0a;
   private Supplier<String> I_field_11b14ee4 = () -> "";
   private Function<IIiII_Class5, ColorRGBA> I_field_aad1658;
   private Function<IIiII_Class5, ColorRGBA> i_field_aad1658;
   private float I_field_46 = 0.0F;
   private Function<IIiII_Class5, ColorRGBA> II_field_aad1658 = var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5;
   private float i_field_46 = 4.0F;
   private float II_field_46 = 0.0F;
   private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(0.0F, IIii_Class4.I_method_3682ece9(200L, IiiiIiiII_Class237.IIII_field_dd60aac));

   public IIiII_Class5(IIiIIi_Class10 var1, String var2, Consumer<String> var3) {
      this.I_field_856d0221 = var1;
      this.I_field_f9f609fa = var3;
      this.I_field_fdef2cc = new IiIiIIIII_Class161(var1);
      this.I_field_fdef2cc.I_method_1d5afa89(var2 == null ? "" : var2);
      this.I_field_523beb0a = this.I_field_fdef2cc.I_method_d2579001();
      this.I_method_e9500b35(120.0F, 15.0F);
   }

   public String I_method_a3badba1() {
      return this.I_field_fdef2cc.I_method_d2579001();
   }

   public IIiII_Class5 I_method_e80ecb7f(String var1) {
      String var2 = var1 == null ? "" : var1;
      if (var2.equals(this.I_field_fdef2cc.I_method_d2579001())) {
         return this;
      } else {
         this.I_field_fdef2cc.I_method_1d5afa89(var2);
         this.I_field_523beb0a = var2;
         return this;
      }
   }

   public IIiII_Class5 I_method_fc398af5(Supplier<String> var1) {
      if (var1 != null) {
         this.I_field_11b14ee4 = var1;
      }

      return this;
   }

   public IIiII_Class5 i_method_459bf75f(String var1) {
      this.I_field_11b14ee4 = () -> var1;
      return this;
   }

   public IIiII_Class5 I_method_9d6eab6b(boolean var1) {
      this.I_field_fdef2cc.i_method_fd1e2055(var1);
      return this;
   }

   public IIiII_Class5 I_method_d6398e5a(int var1) {
      this.I_field_fdef2cc.I_method_fb5af064(var1);
      return this;
   }

   public IIiII_Class5 I_method_a79afef5() {
      this.I_field_fdef2cc.I_method_3d77f3b5();
      return this;
   }

   public IIiII_Class5 I_method_6c6d30d6(ColorRGBA var1) {
      this.I_field_aad1658 = var1x -> var1;
      return this;
   }

   public IIiII_Class5 I_method_e5f33669(Function<IIiII_Class5, ColorRGBA> var1) {
      this.I_field_aad1658 = var1;
      return this;
   }

   public IIiII_Class5 I_method_3edd9cb4(float var1, ColorRGBA var2) {
      this.I_field_46 = var1;
      this.i_field_aad1658 = var1x -> var2;
      return this;
   }

   public IIiII_Class5 I_method_cdc04147(float var1, Function<IIiII_Class5, ColorRGBA> var2) {
      this.I_field_46 = var1;
      this.i_field_aad1658 = var2;
      return this;
   }

   public IIiII_Class5 I_method_49a8a757(float var1) {
      this.i_field_46 = var1;
      return this;
   }

   public IIiII_Class5 i_method_8326c8f6(ColorRGBA var1) {
      this.II_field_aad1658 = var1x -> var1;
      return this;
   }

   public IIiII_Class5 i_method_107dde89(Function<IIiII_Class5, ColorRGBA> var1) {
      this.II_field_aad1658 = var1;
      return this;
   }

   public IIiII_Class5 i_method_73cabf77(float var1) {
      this.II_field_46 = var1;
      return this;
   }

   public IIiII_Class5 i_method_5ba67a(int var1) {
      this.I_field_fdef2cc.I_method_fb5af064(var1);
      return this;
   }

   public boolean I_method_e12152e3() {
      return this.I_field_fdef2cc.I_method_189fd283();
   }

   public float I_method_e12152cf() {
      return this.I_field_b575d2cc.I_method_4e8b496f();
   }

   public IIiII_Class5 II_method_154b7674(float var1) {
      super.width(var1);
      return this;
   }

   public IIiII_Class5 Ii_method_3f6d8e94(float var1) {
      super.height(var1);
      return this;
   }

   public IIiII_Class5 I_method_e9500b35(float var1, float var2) {
      super.size(var1, var2);
      return this;
   }

   public IIiII_Class5 i_method_e2c562d5() {
      super.fillWidth();
      return this;
   }

   public IIiII_Class5 II_method_9035838() {
      super.fillHeight();
      return this;
   }

   private void I_method_e12152df() {
      this.I_field_fdef2cc.I_method_b043bcc(this.x() + this.II_field_46, this.y(), this.w() - this.II_field_46 * 2.0F, this.h());
   }

   @Override
   public boolean mouseClicked(float var1, float var2, IiIII_Class9 var3) {
      if (!this.inFlow()) {
         return false;
      } else {
         this.I_method_e12152df();
         this.I_field_fdef2cc.I_method_400ceaa7(var1, var2, var3);
         return this.contains(var1, var2);
      }
   }

   @Override
   public void mouseReleased(float var1, float var2, IiIII_Class9 var3) {
      this.I_field_fdef2cc.i_method_6a097ac7(var1, var2, var3);
      super.mouseReleased(var1, var2, var3);
   }

   @Override
   public boolean keyPressed(int var1, int var2, int var3) {
      if (!this.I_field_fdef2cc.I_method_189fd283()) {
         return false;
      } else {
         this.I_field_fdef2cc.I_method_c1acbc24(var1, var2, var3);
         return true;
      }
   }

   @Override
   public boolean charTyped(char var1, int var2) {
      return !this.I_field_fdef2cc.I_method_189fd283() ? false : this.I_field_fdef2cc.I_method_b71e84c9(var1, var2);
   }

   @Override
   protected void onTick(float var1, float var2, float var3) {
      this.I_field_b575d2cc.I_method_82de4e21(this.I_field_fdef2cc.I_method_189fd283() ? 1.0F : 0.0F);
      this.I_field_b575d2cc.Ii_method_dc72325e(var1);
   }

   @Override
   protected void drawSelf(III var1, float var2) {
      if (this.I_field_aad1658 != null) {
         ColorRGBA var3 = this.I_field_aad1658.apply(this);
         if (var3 != null && var3.getAlpha() > 0.0F) {
            var1.drawRoundedRect(this.x(), this.y(), this.w(), this.h(), IIiii_Class8.I_method_893b2757(this.i_field_46), var3);
         }
      }

      if (this.i_field_aad1658 != null && this.I_field_46 > 0.0F) {
         ColorRGBA var4 = this.i_field_aad1658.apply(this);
         if (var4 != null && var4.getAlpha() > 0.0F) {
            var1.drawRoundedBorder(this.x(), this.y(), this.w(), this.h(), this.I_field_46, IIiii_Class8.I_method_893b2757(this.i_field_46), var4);
         }
      }

      this.I_method_e12152df();
      this.I_field_fdef2cc.iI_method_a8609f1e(1.0F);
      this.I_field_fdef2cc.II_method_e557b20c(this.I_field_11b14ee4.get());
      this.I_field_fdef2cc.I_method_13a617e0(this.II_field_aad1658.apply(this));
      this.I_field_fdef2cc.I_method_7ae26dda(var1);
      String var5 = this.I_field_fdef2cc.I_method_d2579001();
      if (!var5.equals(this.I_field_523beb0a)) {
         this.I_field_523beb0a = var5;
         this.I_field_f9f609fa.accept(var5);
      }
   }
}
