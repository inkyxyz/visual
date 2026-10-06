package rockstar.client;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.utility.render.ColorRGBA;

public class IiiIIIIII_Class193 extends IiIiiIiii_Class184 implements iIIiIIiIi_Class294 {
   private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(34.0F, 187.0F, 94.0F);
   private static final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(239.0F, 68.0F, 68.0F);
   private static final ColorRGBA II_field_d0c8ec5 = IiiiiIIIi_Class242.iI_field_d0c8ec5.mix(IiiiiIIIi_Class242.I_field_d0c8ec5, 0.5F);
   private static final ColorRGBA Ii_field_d0c8ec5 = new ColorRGBA(228.0F, 52.0F, 52.0F);
   private IiiIIIIII_Class193.Nested1_fa597840 I_field_948d6647;
   private int I_field_49;
   private ColorRGBA iI_field_d0c8ec5 = I_field_d0c8ec5;
   private int i_field_49;
   private int II_field_49;
   private float I_field_46 = 1.0F;
   private iiI_Class7 I_field_b5845eac;
   private iiI_Class7 i_field_b5845eac;
   private iiI_Class7 II_field_b5845eac;
   private iiI_Class7 Ii_field_b5845eac;

   public IiiIIIIII_Class193(MultiSelectSetting var1) {
      super(var1, "modules");
   }

   @Override
   public void prepare(IiIiiIIII_Class177 var1) {
      this.I_field_948d6647 = this.I_method_838904b0();
      if (this.I_field_948d6647 != null) {
         switch (this.I_field_948d6647) {
            case I_field_948d6647:
               this.Ii_method_d5a424e2();
               break;
            case i_field_948d6647:
               this.I_method_723e263f();
               break;
            case II_field_948d6647:
               this.i_method_724cb21f();
               break;
            case Ii_field_948d6647:
               this.II_method_d5959902();
         }
      }
   }

   @Override
   public iiI_Class7 content(IiIiiIIII_Class177 var1) {
      if (this.I_field_948d6647 == null) {
         return null;
      } else {
         return switch (this.I_field_948d6647) {
            case I_field_948d6647 -> this.Ii_method_b754c538();
            case i_field_948d6647 -> this.I_method_2f757615();
            case II_field_948d6647 -> this.i_method_afa751f5();
            case Ii_field_948d6647 -> this.II_method_3722e958();
         };
      }
   }

   @Override
   public boolean canShow() {
      return false;
   }

   private void I_method_723e263f() {
      FreeCameraModule var1 = this.I_method_6a523f35();
      Vec3d var2 = var1.I_method_a0ada979();
      Vec3d var3 = var1.i_method_44a62d59();
      this.I_field_49 = (int)var2.y - (int)var3.y;
      float var4 = MathHelper.clamp(Math.abs(this.I_field_49) / 35.0F, 0.0F, 1.0F);
      this.iI_field_d0c8ec5 = I_field_d0c8ec5.mix(i_field_d0c8ec5, var4);
   }

   private void i_method_724cb21f() {
   }

   private void II_method_d5959902() {
   }

   private void Ii_method_d5a424e2() {
      iiiIiIiI_Class235 var1 = this.I_method_6befb618();
      int var2 = var1 == null ? 0 : var1.II_method_6b4bba8() / 20;
      this.i_field_49 = var2 / 60;
      this.II_field_49 = var2 % 60;
      this.I_field_46 = 0.8F + 0.2F * (float)Math.sin(System.currentTimeMillis() / 260.0);
   }

   private iiI_Class7 I_method_2f757615() {
      if (this.I_field_b5845eac == null) {
         iii_Class8 var1 = IiIiiIiIi_Class182.I_method_4b294f34(15.0F, IIII.I_method_12c9a0cb(0.0F, 4.5F, 0.0F, 6.0F), 2.0F)
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c);
         iii_Class8 var2 = IiIiiIiIi_Class182.I_method_936430f8(() -> -14.0F * (1.0F - this.animation.I_method_6ac4da6f()))
            .i_method_c88da8d5()
            .IiI_method_31d4c97(8.0F)
            .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 2.5F, 0.0F, 3.0F))
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
            .I_method_f136b1d8(
               (var1x, var2x) -> var1x.drawRoundedRect(
                  var2x.x(),
                  var2x.y(),
                  var2x.w(),
                  var2x.h(),
                  IIiii_Class8.I_method_893b2757(3.0F),
                  this.iI_field_d0c8ec5.withAlpha(255.0F * this.animation.I_method_6ac4da6f())
               )
            );
         var2.I_method_8939bffd(
            IiIiiIiIi_Class182.I_method_76baf816(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F),
               () -> this.I_field_49 < 0 ? "-" : "",
               () -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(255.0F * this.animation.I_method_6ac4da6f())
            )
         );
         var2.I_method_8939bffd(
            new Iiii_Class8(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F), () -> Math.abs(this.I_field_49))
               .I_method_6e260263(5.0F)
               .I_method_124306cb()
               .I_method_ab0d6d85(() -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(255.0F * this.animation.I_method_6ac4da6f()))
               .interactive(false)
         );
         var1.I_method_8939bffd(
            IiIiiIiIi_Class182.I_method_923ba5d7(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
               () -> IiIiIIII_Class81.I_method_f25a980a("hud.dynamic_island.modules.freecam_height"),
               () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F * this.animation.I_method_6ac4da6f()),
               () -> -6.0F * (1.0F - this.animation.I_method_6ac4da6f())
            )
         );
         var1.I_method_8939bffd(var2);
         this.I_field_b5845eac = var1;
      }

      return this.I_field_b5845eac;
   }

   private iiI_Class7 i_method_afa751f5() {
      if (this.i_field_b5845eac == null) {
         iii_Class8 var1 = IiIiiIiIi_Class182.I_method_4b294f34(15.0F, IIII.I_method_12c9a0cb(0.0F, 5.0F, 0.0F, 6.0F), 3.0F)
            .IIi_method_4dfc88d7(80.0F)
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c);
         var1.I_method_8939bffd(
            IiIiiIiIi_Class182.I_method_923ba5d7(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
               () -> "Blink",
               () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F * this.animation.I_method_6ac4da6f()),
               () -> -10.0F * (1.0F - this.animation.I_method_6ac4da6f())
            )
         );
         var1.I_method_8939bffd(new IiiIIIIII_Class193.Nested1_fa597860().fillWidth());
         this.i_field_b5845eac = var1;
      }

      return this.i_field_b5845eac;
   }

   private iiI_Class7 II_method_3722e958() {
      if (this.II_field_b5845eac == null) {
         iii_Class8 var1 = IiIiiIiIi_Class182.I_method_4b294f34(15.0F, IIII.I_method_12c9a0cb(0.0F, 5.0F, 0.0F, 4.0F), 4.0F)
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c);
         var1.I_method_8939bffd(
            IiIiiIiIi_Class182.I_method_131f6edb(
               7.0F,
               7.0F,
               (var1x, var2, var3) -> {
                  float var4 = this.animation.I_method_6ac4da6f();
                  ColorRGBA var5 = II_field_d0c8ec5.mix(IiiiiIIIi_Class242.Ii_field_d0c8ec5, 0.25F);
                  ColorRGBA var6 = II_field_d0c8ec5.mix(IiiiiIIIi_Class242.Ii_field_d0c8ec5, 0.5F);
                  var1x.drawRoundedRect(
                     var2.x() - 10.0F * (1.0F - var4),
                     var2.y(),
                     var2.w(),
                     var2.h(),
                     IIiii_Class8.I_method_893b2757(3.0F),
                     new IiIIi_Class10(II_field_d0c8ec5, var6, var6, var5)
                  );
               }
            )
         );
         var1.I_method_8939bffd(
            IiIiiIiIi_Class182.I_method_923ba5d7(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
               () -> IiIiIIII_Class81.I_method_f25a980a("modules.settings.auto_swap.auto_cerber"),
               () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F * this.animation.I_method_6ac4da6f()),
               () -> 10.0F * (1.0F - this.animation.I_method_6ac4da6f())
            )
         );
         this.II_field_b5845eac = var1;
      }

      return this.II_field_b5845eac;
   }

   private iiI_Class7 Ii_method_b754c538() {
      if (this.Ii_field_b5845eac == null) {
         iii_Class8 var1 = IiIiiIiIi_Class182.I_method_4b294f34(15.0F, IIII.I_method_12c9a0cb(0.0F, 4.0F, 0.0F, 4.0F), 3.5F)
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c);
         iii_Class8 var2 = IiIiiIiIi_Class182.I_method_936430f8(() -> -20.0F * (1.0F - this.animation.I_method_6ac4da6f()))
            .i_method_c88da8d5()
            .IiI_method_31d4c97(8.0F)
            .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 2.5F, 0.0F, 3.0F))
            .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
            .I_method_f136b1d8(
               (var1x, var2x) -> var1x.drawRoundedRect(
                  var2x.x(),
                  var2x.y(),
                  var2x.w(),
                  var2x.h(),
                  IIiii_Class8.I_method_893b2757(3.0F),
                  Ii_field_d0c8ec5.withAlpha(255.0F * this.animation.I_method_6ac4da6f() * this.I_field_46)
               )
            );
         var2.I_method_8939bffd(
            IiIiiIiIi_Class182.I_method_76baf816(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F),
               () -> this.i_field_49 + ":",
               () -> IiiiiIIIi_Class242.I_method_35ed8eaf(Ii_field_d0c8ec5).withAlpha(255.0F * this.animation.I_method_6ac4da6f())
            )
         );
         var2.I_method_8939bffd(
            new Iiii_Class8(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F), () -> this.II_field_49)
               .I_method_6e260263(5.0F)
               .I_method_124306cb()
               .I_method_ab0d6d85(() -> IiiiiIIIi_Class242.I_method_35ed8eaf(Ii_field_d0c8ec5).withAlpha(255.0F * this.animation.I_method_6ac4da6f()))
               .interactive(false)
         );
         var1.I_method_8939bffd(var2);
         var1.I_method_8939bffd(
            IiIiiIiIi_Class182.I_method_923ba5d7(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
               () -> IiIiIIII_Class81.I_method_f25a980a("hud.dynamic_island.modules.neuro_record"),
               () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F * this.animation.I_method_6ac4da6f()),
               () -> 10.0F * (1.0F - this.animation.I_method_6ac4da6f())
            )
         );
         this.Ii_field_b5845eac = var1;
      }

      return this.Ii_field_b5845eac;
   }

   private IiiIIIIII_Class193.Nested1_fa597840 I_method_838904b0() {
      return null;
   }

   private boolean I_method_723e2643() {
      return I_field_3a9bda27.player != null && this.I_method_6a523f35().isEnabled();
   }

   private boolean i_method_724cb223() {
      return this.I_method_6a43af75().isEnabled() && IiiiiiiII_Class253.i_method_1cc4aa23();
   }

   private boolean II_method_d5959906() {
      return this.I_method_6a433b35().Iii_method_345deaa3() && IiiiiiiII_Class253.i_method_1cc4aa23();
   }

   private boolean Ii_method_d5a424e6() {
      iiiIiIiI_Class235 var1 = this.I_method_6befb618();
      return var1 != null && var1.I_method_be266130() && IiiiiiiII_Class253.i_method_1cc4aa23();
   }

   private iiiIiIiI_Class235 I_method_6befb618() {
      AuraModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
      return var1 != null && var1.I_method_ca3c40b() != null ? var1.I_method_ca3c40b().I_method_7c26b42b() : null;
   }

   private FreeCameraModule I_method_6a523f35() {
      return RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class);
   }

   BlinkModule I_method_6a43af75() {
      return RockstarClient.getInstance().getModuleManager().getModule(BlinkModule.class);
   }

   private AutoSwapModule I_method_6a433b35() {
      return RockstarClient.getInstance().getModuleManager().getModule(AutoSwapModule.class);
   }

   static enum Nested1_fa597840 {
      I_field_948d6647,
      i_field_948d6647,
      II_field_948d6647,
      Ii_field_948d6647;
   }

   final class Nested1_fa597860 extends iiI_Class7 {
      Nested1_fa597860() {
         this.height(6.0F);
         this.interactive(false);
      }

      @Override
      protected void measure() {
         this.prefW = 0.0F;
         this.prefH = 6.0F;
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         BlinkModule var3 = IiiIIIIII_Class193.this.I_method_6a43af75();
         IIiIIi_Class10 var4 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
         float var5 = IiiIIIIII_Class193.this.animation.I_method_6ac4da6f();
         if (!var3.I_method_82926335().i_method_9b12da03()) {
            String var7 = iIIIIiIiI_Class267.i_method_f3c598a1((float)var3.I_method_618db775().I_method_23e11e33() / 1000.0F)
               + " "
               + IiIiIIII_Class81.I_method_f25a980a("sec");
            var1.drawRightText(
               var4,
               var7,
               this.x() + this.w() - 1.0F,
               this.y() + this.h() / 2.0F - var4.I_method_a649725c() / 2.0F,
               IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F * var5)
            );
         } else {
            float var6 = this.w()
               * (
                  (var3.I_method_3b892775().Ii_method_a20abcd2() * 50.0F - (float)var3.I_method_618db775().I_method_23e11e33())
                     / (var3.I_method_3b892775().Ii_method_a20abcd2() * 50.0F)
               );
            var1.drawRoundedRect(
               this.x(), this.y(), this.w(), this.h(), IIiii_Class8.I_method_893b2757(2.5F), IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha(255.0F * var5)
            );
            var1.drawRoundedRect(
               this.x() + this.w() - var6,
               this.y(),
               var6,
               this.h(),
               IIiii_Class8.I_method_893b2757(2.5F),
               IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(255.0F * var5)
            );
         }
      }
   }
}
