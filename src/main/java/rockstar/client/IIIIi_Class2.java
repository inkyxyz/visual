package rockstar.client;

import globals.client.Information;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.profile.Profile;

public class IIIIi_Class2 extends iii_Class8 implements IIiiiIIiI_Class115 {
   private static final float I_field_46 = 94.0F;
   private static final float i_field_46 = 24.0F;
   private static final float II_field_46 = 207.0F;
   private static final float Ii_field_46 = 24.0F;
   private static final float iI_field_46 = 4.0F;
   private static final float ii_field_46 = 18.0F;
   private static final float III_field_46 = 10.0F;
   private static final float IIi_field_46 = 150.0F;
   private static final float IiI_field_46 = 6.0F;
   private static final float Iii_field_46 = 6.0F;
   private static final float iII_field_46 = 115.0F;
   private static final float iIi_field_46 = 1.0F;
   private static final float iiI_field_46 = 16.0F;
   private static final long I_field_4a = 400L;
   private static final IIiIIi_Class10 I_field_856d0221 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F);
   private final IiI_Class3 I_field_b575d2cc = new IiI_Class3(IIii_Class4.I_method_f17ae5cb(300.0F, 28.0F));
   private final iiI_Class7 I_field_b5845eac;
   private final BiConsumer<ModuleEntry, Setting> I_field_17cc1433;
   private final iiI_Class7 i_field_b5845eac;
   private final iiI_Class7 II_field_b5845eac;
   private final iiI_Class7 Ii_field_b5845eac;
   private final iiI_Class7 iI_field_b5845eac;
   private final iiI_Class7 ii_field_b5845eac;
   private final iii_Class8 I_field_b584628c;
   private final List<Setting> I_field_7865b31 = new ArrayList<>();
   private final ModeSetting I_field_bbe33e6c;
   private final ColorSetting I_field_bbd4b66c;
   private final BooleanSetting I_field_ba20ca4c;
   private final iii_Class8 i_field_b584628c;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private iiI_Class7 III_field_b5845eac;
   private int I_field_49;
   private long i_field_4a;
   private long II_field_4a;
   private static final float iii_field_46 = 207.0F;
   private static final float IIII_field_46 = 14.0F;
   private static final float IIIi_field_46 = 18.0F;
   private static final float IIiI_field_46 = 150.0F;
   private static final float IIii_field_46 = 7.0F;
   private static final float IiII_field_46 = 0.0F;
   private static final float IiIi_field_46 = 9.0F;
   private static final float IiiI_field_46 = 2.0F;
   private static final float Iiii_field_46 = 6.0F;
   private static final long Ii_field_4a = 300L;
   private static final IiiI_Class7 I_field_f94500c1 = (var0, var1, var2) -> {
      var2.I_field_46 = Math.min(1.0F, Math.max(0.0F, var0));
      var2.Ii_field_46 = 0.7F + 0.3F * var0;
   };
   private final iiI_Class7 IIi_field_b5845eac;
   private final iiI_Class7 IiI_field_b5845eac;
   private final iii_Class8 II_field_b584628c;
   private final iii_Class8 Ii_field_b584628c;
   private boolean II_field_5a;
   private final List<IIIIi_Class2.Nested1_b33417a0> i_field_7865b31 = new ArrayList<>();
   private IiIiIIIII_Class161 I_field_fdef2cc;
   private boolean Ii_field_5a;
   private long iI_field_4a;
   private boolean iI_field_5a;
   private String I_field_523beb0a = null;
   private int i_field_49;
   private iiI_Class7 Iii_field_b5845eac;
   private IIiIIi_Class10 i_field_856d0221;
   private final List<IIIIi_Class2.Nested1_b33417c0> II_field_7865b31 = new ArrayList<>();
   private static final String i_field_523beb0a = "qwertyuiop[]asdfghjkl;'zxcvbnm,./";
   private static final String II_field_523beb0a = "\u0439\u0446\u0443\u043a\u0435\u043d\u0433\u0448\u0449\u0437\u0445\u044a\u0444\u044b\u0432\u0430\u043f\u0440\u043e\u043b\u0434\u0436\u044d\u044f\u0447\u0441\u043c\u0438\u0442\u044c\u0431\u044e.";

   private static String I_method_63e463a1() {
      return "LEEK";
   }

   public IIIIi_Class2(iiI_Class7 var1, BiConsumer<ModuleEntry, Setting> var2) {
      this.I_field_b5845eac = var1;
      this.I_field_17cc1433 = var2;
      Iii_Class4 var3 = new Iii_Class4()
         .size(12.0F, 12.0F)
         .interactive(false)
         .paint(
            (var0, var1x) -> {
               float var2x = var1x.w() / 2.0F;
               var0.drawRoundedTexture(
                  Information.getSelfAvatar(),
                  var1x.x(),
                  var1x.y(),
                  var1x.w(),
                  var1x.h(),
                  IIiii_Class8.I_method_893b2757(var2x),
                  IiiiiIIIi_Class242.Ii_field_d0c8ec5
               );
            }
         );
      iii_Class8 var4 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(2.0F)
         .I_method_483797dd(IIi_Class2.I_field_b5755e8c)
         .Ii_method_25479968(false)
         .I_method_8939bffd(
            new Iii_Class4()
               .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), Profile::getUsername, var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5)
               .interactive(false)
         )
         .I_method_8939bffd(
            new Iii_Class4()
               .text(
                  IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F),
                  IIIIi_Class2::I_method_63e463a1,
                  var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F)
               )
               .interactive(false)
         );
      this.i_field_b5845eac = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(4.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(var3)
         .I_method_8939bffd(var4);
      this.II_field_b5845eac = this.I_method_ce3fdabd("setting", this::IiI_method_94b16b5f);
      this.Ii_field_b5845eac = this.I_method_ce3fdabd("search", () -> this.II_method_92e036b2(true));
      this.ii_field_b5845eac = this.I_method_ce3fdabd("xmark", () -> this.II_method_92e036b2(false));
      this.iI_field_b5845eac = new Iii_Class4()
         .fillWidth()
         .height(24.0F)
         .cursor(iIIIiIIIi_Class274.iI_field_aa52e62c)
         .onClick((var1x, var2x, var3x) -> this.i_method_f524a7f5().I_method_400ceaa7(var2x, var3x, var1x))
         .paint((var1x, var2x) -> {
            IiIiIIIII_Class161 var3x = this.i_method_f524a7f5();
            var3x.I_method_b043bcc(var2x.x() - 4.0F, var2x.y(), var2x.w() + 4.0F, var2x.h());
            var3x.I_method_13a617e0(IiiiiIIIi_Class242.iII_field_d0c8ec5);
            var3x.iI_method_a8609f1e(1.0F);
            var3x.I_method_7ae26dda(var1x);
         });
      this.i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.I_field_f93600a1)
         .I_method_70a38517(6.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 8.0F, 0.0F, 6.0F))
         .IIi_method_4dfc88d7(94.0F)
         .IiI_method_31d4c97(24.0F)
         .I_method_c0ca36f3(() -> {})
         .I_method_8939bffd(this.i_field_b5845eac)
         .I_method_8939bffd(this.II_field_b5845eac)
         .I_method_8939bffd(this.Ii_field_b5845eac)
         .I_method_f136b1d8(
            (var1x, var2x) -> {
               this.IIi_method_92fd071f();
               if (!this.i_field_5a) {
                  var1x.drawShadow(
                     var2x.x(),
                     var2x.y(),
                     var2x.w(),
                     var2x.h(),
                     10.0F,
                     IIiii_Class8.I_method_893b2757(5.0F),
                     IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.15F)
                  );
                  this.I_method_e39567c1(var1x, var2x, 8.0F);
               }
            }
         );
      I_method_24f232a7(this);
      this.i_field_b5845eac.snapPosition();
      this.II_field_b5845eac.snapPosition();
      this.Ii_field_b5845eac.snapPosition(() -> !this.Ii_field_5a);
      this.iI_field_b5845eac.exit(IiiI_Class7.i_field_f94500c1).lifeMotion(IIii_Class4.I_method_3682ece9(160L, IiiiIiiII_Class237.IIII_field_dd60aac));
      this.ii_field_b5845eac.exit(IiiI_Class7.i_field_f94500c1).lifeMotion(IIii_Class4.I_method_3682ece9(160L, IiiiIiiII_Class237.IIII_field_dd60aac));
      this.I_field_b584628c = (new iii_Class8() {
            @Override
            public boolean mouseScrolled(float var1, float var2x, float var3x, float var4x) {
               return super.mouseScrolled(var1, var2x, var3x, var4x) || this.inFlow() && this.contains(var1, var2x);
            }
         })
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(207.0F)
         .Ii_method_81121d98(207.0F, 150.0F)
         .I_method_c0ca36f3(() -> {})
         .Ii_method_bb38d618()
         .I_method_b65baecb(
            var0 -> var0.i_method_65326e43(3.0F)
               .I_method_4f0ff9cb(7.0F, 6.0F)
               .I_method_2a080a63(2.5F)
               .i_method_989a5f71(
                  var0x -> ColorRGBA.BLACK
                     .mix(ColorRGBA.WHITE, 0.3F)
                     .withAlpha(255.0F * (0.32F + 0.28F * var0x.I_method_af833bdc() + 0.3F * var0x.i_method_af91c7bc()))
               )
         )
         .I_method_e16e9925(() -> this.Ii_field_5a && this.iI_field_5a && !this.II_field_7865b31.isEmpty(), IiiiIiiII_Class237.IIii_field_dd60aac, 240L)
         .IIiI_method_185ffdf8()
         .I_method_f136b1d8(
            (var1x, var2x) -> {
               if (this.i_field_5a) {
                  var1x.drawShadow(
                     var2x.x(),
                     var2x.y(),
                     var2x.w(),
                     var2x.h(),
                     10.0F,
                     IIiii_Class8.I_method_893b2757(11.0F),
                     IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F)
                  );
                  this.i_method_92da2fe1(var1x, var2x, 11.0F);
               } else {
                  var1x.drawShadow(
                     var2x.x(),
                     var2x.y(),
                     var2x.w(),
                     var2x.h(),
                     10.0F,
                     IIiii_Class8.I_method_893b2757(11.0F),
                     IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F)
                  );
                  this.I_method_e39567c1(var1x, var2x, 11.0F);
               }
            }
         );
      this.I_field_ba20ca4c = new BooleanSetting(this, "configs.autosave").I_method_a4d009eb(I_method_88a1a938().I_method_7ce4a4f0());
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.interface.language");
      new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "\u0420\u0443\u0441\u0441\u043a\u0438\u0439");
      new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "English");
      new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "\u0423\u043a\u0440\u0430\u0457\u043d\u0441\u044c\u043a\u0430");
      new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "polski");
      this.I_field_49 = I_method_3439f73(IiIiIIII_Class81.I_method_21a4cfeb());
      this.I_field_bbe33e6c.i_method_89901e42(this.I_field_bbe33e6c.I_method_e1d4a248().get(this.I_field_49));
      this.I_field_bbd4b66c = new ColorSetting(this, "theme.colors.accent")
         .I_method_af5a85eb(false)
         .I_method_a62f5dd6(IiiiiIIIi_Class242.I_method_7df8e08e());
      IiiI_Class7 var5 = (var0, var1x, var2x) -> {
         var2x.I_field_46 = 1.0F;
         float var3x = Math.max(0.0F, var0);
         var2x.Ii_field_46 = var3x;
         var2x.i_field_46 = -(1.0F - var3x) * var1x.w() / 2.0F;
         var2x.II_field_46 = (1.0F - var3x) * var1x.h() / 2.0F;
      };
      this.i_field_b584628c = (new iii_Class8() {
            @Override
            public boolean mouseScrolled(float var1, float var2, float var3, float var4) {
               return super.mouseScrolled(var1, var2, var3, var4) || this.inFlow() && this.contains(var1, var2);
            }

            @Override
            protected void drawChildren(III var1, float var2x) {
               iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), this.x(), this.y(), this.w(), this.h());
               super.drawChildren(var1, var2x);
               iIiiiIiII_Class373.I_method_ff80a1df();
            }
         })
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(115.0F)
         .I_method_7e2bb176(IIII.I_method_b1e865cb(6.0F, 0.0F))
         .I_method_c0ca36f3(() -> {})
         .I_method_879bc687(() -> this.I_field_5a && !this.Ii_field_5a)
         .II_method_32b63e79(var5)
         .i_method_b358e156(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.I_field_dd60aac))
         .I_method_8939bffd(this.IiIi_method_86c5f7f8())
         .I_method_8939bffd(IiiIiiIIi_Class218.I_method_83bcc05d(this.I_field_ba20ca4c))
         .I_method_8939bffd(IiiIiiIIi_Class218.I_method_83bcc05d(this.I_field_bbd4b66c))
         .I_method_8939bffd(IiiIiiIIi_Class218.I_method_83bcc05d(this.I_field_bbe33e6c))
         .I_method_f136b1d8(
            (var1x, var2x) -> {
               var1x.drawShadow(
                  var2x.x(), var2x.y(), var2x.w(), var2x.h(), 10.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F)
               );
               this.I_method_e39567c1(var1x, var2x, 11.0F);
            }
         );
      this.IIi_field_b5845eac = new Iii_Class4()
         .text(
            IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
            () -> IiIiIIII_Class81.I_method_f25a980a("profile.binds.title"),
            var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5
         )
         .interactive(false);
      this.IiI_field_b5845eac = this.I_method_ce3fdabd("xmark", () -> this.i_method_590633f5(false));
      iii_Class8 var6 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .III_method_9dc17555()
         .IiI_method_31d4c97(14.0F)
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
         .I_method_8939bffd(this.IIi_field_b5845eac)
         .I_method_8939bffd(this.IiI_field_b5845eac);
      this.Ii_field_b584628c = (new iii_Class8() {
            @Override
            public boolean mouseScrolled(float var1, float var2, float var3, float var4) {
               return super.mouseScrolled(var1, var2, var3, var4) || this.inFlow() && this.contains(var1, var2);
            }
         })
         .I_method_485bccf5()
         .III_method_9dc17555()
         .Ii_method_81121d98(207.0F, 150.0F)
         .I_method_c0ca36f3(() -> {})
         .Ii_method_bb38d618()
         .I_method_b65baecb(
            var0 -> var0.i_method_65326e43(3.0F)
               .I_method_4f0ff9cb(1.0F, 6.0F)
               .I_method_2a080a63(2.5F)
               .i_method_989a5f71(
                  var0x -> ColorRGBA.BLACK
                     .mix(ColorRGBA.WHITE, 0.3F)
                     .withAlpha(255.0F * (0.32F + 0.28F * var0x.I_method_af833bdc() + 0.3F * var0x.i_method_af91c7bc()))
               )
         );
      this.II_field_b584628c = (new iii_Class8() {
            @Override
            protected void drawChildren(III var1, float var2) {
               iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), this.x(), this.y(), this.w(), this.h());
               super.drawChildren(var1, var2);
               iIiiiIiII_Class373.I_method_ff80a1df();
            }
         })
         .I_method_485bccf5()
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(7.0F, 0.0F, 0.0F, 0.0F))
         .I_method_70a38517(2.0F)
         .I_method_3f5fb576(IiiI_Class7.II_field_f94500c1)
         .i_method_6e516956(IiiI_Class7.i_field_f94500c1)
         .i_method_b358e156(IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.IIII_field_dd60aac))
         .I_method_8939bffd(var6)
         .I_method_8939bffd(this.Ii_field_b584628c);
      this.II_field_b584628c
         .I_method_f136b1d8(
            (var1x, var2x) -> {
               if (this.i_field_5a) {
                  boolean var3x = RockstarClient.getInstance().I_method_9a720c62().I_method_ac8a0395() == IiIIIiIii_Class140.I_field_74daf6cc;
                  ColorRGBA var4x = (var3x ? IiiiiIIIi_Class242.II_method_190e6391() : IiiiiIIIi_Class242.Ii_method_a0f56f71()).withAlpha(255.0F);
                  var1x.drawShadow(
                     var2x.x(),
                     var2x.y(),
                     var2x.w(),
                     var2x.h(),
                     10.0F,
                     IIiii_Class8.I_method_893b2757(8.0F),
                     IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.15F)
                  );
                  var1x.drawRoundedRect(var2x.x(), var2x.y(), var2x.w(), var2x.h(), IIiii_Class8.I_method_893b2757(8.0F), var4x);
                  var1x.drawRoundedBorder(
                     var2x.x(),
                     var2x.y(),
                     var2x.w(),
                     var2x.h(),
                     0.5F,
                     IIiii_Class8.I_method_893b2757(8.0F),
                     IiiiiIIIi_Class242.IiI_field_d0c8ec5.withAlpha(89.25F)
                  );
               }
            }
         );
      i_method_aafbd2c7(this.II_field_b584628c);
   }

   private iii_Class8 IiIi_method_86c5f7f8() {
      iii_Class8 var1 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(6.0F)
         .III_method_9dc17555()
         .IiI_method_31d4c97(20.0F)
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c);
      Iii_Class4 var2 = new Iii_Class4()
         .size(8.0F, 8.0F)
         .icon("keyboard", 8.0F, var1x -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F + 0.4F * var1.hover()))
         .interactive(false);
      Iii_Class4 var3 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
            () -> IiIiIIII_Class81.I_method_f25a980a("profile.binds.title"),
            var1x -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75F + 0.25F * var1.hover())
         )
         .fill()
         .interactive(false);
      return var1.I_method_8939bffd(var2).I_method_8939bffd(var3).I_method_c0ca36f3(() -> {
         this.I_method_574343d5(false);
         this.i_method_590633f5(true);
      });
   }

   public iii_Class8 IIii_method_d1a53438() {
      return this.I_field_b584628c;
   }

   public iii_Class8 IiII_method_6941c18() {
      return this.i_field_b584628c;
   }

   public IIIIi_Class2 I_method_5a9bd0bd(iiI_Class7 var1) {
      this.i_field_5a = true;
      this.III_field_b5845eac = var1;
      this.i_method_d2e03546(List.of());
      this.II_field_b584628c.II_method_32b63e79(I_field_f94500c1);
      return this;
   }

   public IIIIi_Class2 I_method_562751de(iiI_Class7 var1, IIiIIi_Class10 var2) {
      this.Iii_field_b5845eac = var1;
      this.i_field_856d0221 = var2;
      return this;
   }

   public IiIiIIIII_Class161 I_method_df8f3415() {
      return this.i_method_f524a7f5();
   }

   private static ColorRGBA I_method_e36ef54e() {
      ColorRGBA var0 = IiiiiIIIi_Class242.II_method_190e6391().withAlpha(173.40001F);
      return var0.mix(IiiiiIIIi_Class242.iII_field_d0c8ec5.withAlpha(var0.getAlpha()), 0.035F);
   }

   private void IIi_method_92fd071f() {
      if (this.I_field_b5845eac != null && this.iI_method_59147886()) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         iIiiIIiii_Class360.I_field_6424b12c.I_method_8b2cf43c(1, 1.0F);
      }
   }

   private boolean iI_method_59147886() {
      boolean var1 = this.Ii_field_5a || this.I_field_5a || !this.i_field_5a && this.II_field_5a;
      long var2 = System.currentTimeMillis();
      if (var1) {
         this.II_field_4a = var2 + 400L;
      }

      return var2 < this.II_field_4a;
   }

   private void I_method_e39567c1(III var1, iiI_Class7 var2, float var3) {
      IIiii_Class8 var4 = IIiii_Class8.I_method_893b2757(var3);
      boolean var5 = this.iI_method_59147886();
      if (var5) {
         iIiiIIiii_Class360.I_method_eceab8e4(1);
      }

      try {
         var1.drawBlurredRect(var2.x(), var2.y(), var2.w(), var2.h(), 5.0F, 3.0F, var4, IiiiiIIIi_Class242.Ii_field_d0c8ec5);
         var1.drawClientRect(var2.x(), var2.y(), var2.w(), var2.h(), 1.0F, 0.0F, 3.0F, var3, true);
      } finally {
         if (var5) {
            iIiiIIiii_Class360.I_method_49b4f9ff();
         }
      }
   }

   private void i_method_92da2fe1(III var1, iiI_Class7 var2, float var3) {
      IIiii_Class8 var4 = IIiii_Class8.I_method_893b2757(var3);
      boolean var5 = this.I_field_b5845eac != null
         && this.iI_method_59147886()
         && !iIiiiiIii_Class380.I_field_5a
         && iIiiIIiii_Class360.I_field_6424b12c.I_method_5711f408(1);
      if (var5) {
         iIiiiiIii_Class380.I_method_5f4b621f();
         float var6 = 16.0F;
         var1.I_method_b16fbb95(
            1,
            var2.x(),
            var2.y(),
            var2.w(),
            var2.h(),
            1.5F,
            1.0F,
            1.2F,
            this.I_field_b5845eac.x() + var6,
            this.I_field_b5845eac.y() + var6,
            this.I_field_b5845eac.w() - 2.0F * var6,
            this.I_field_b5845eac.h() - 2.0F * var6,
            var4,
            IiiiiIIIi_Class242.Ii_field_d0c8ec5
         );
      }

      var1.drawRoundedRect(var2.x(), var2.y(), var2.w(), var2.h(), var4, var5 ? I_method_e36ef54e() : I_method_e36ef54e().withAlpha(255.0F));
      var1.drawRoundedBorder(var2.x(), var2.y(), var2.w(), var2.h(), 0.5F, var4, IiiiiIIIi_Class242.IiI_field_d0c8ec5.withAlpha(89.25F));
   }

   public void II_method_57518862() {
      this.II_method_92e036b2(true);
   }

   public void Ii_method_57601442() {
      this.II_method_92e036b2(false);
   }

   public void iI_method_59147882() {
      this.IiI_method_94b16b5f();
   }

   @Override
   public List<Setting> getSettings() {
      return this.I_field_7865b31;
   }

   private static int I_method_3439f73(IiIIiiii_Class80 var0) {
      return switch (var0) {
         case I_field_3f56db61 -> 1;
         case II_field_3f56db61 -> 2;
         case Ii_field_3f56db61 -> 3;
         default -> 0;
      };
   }

   private void IiI_method_94b16b5f() {
      this.I_method_574343d5(!this.I_field_5a);
   }

   private void I_method_574343d5(boolean var1) {
      if (this.I_field_5a != var1) {
         this.i_field_b584628c
            .i_method_b358e156(IIii_Class4.I_method_3682ece9(300L, var1 ? IiiiIiiII_Class237.I_field_dd60aac : IiiiIiiII_Class237.iI_field_dd60aac));
         this.I_field_5a = var1;
         if (!var1) {
            this.I_field_bbd4b66c.i_method_86d951ff();
         } else {
            this.I_field_bbd4b66c.I_method_edc01840(IiiiiIIIi_Class242.I_method_7df8e08e());
            this.I_field_49 = I_method_3439f73(IiIiIIII_Class81.I_method_21a4cfeb());
            this.I_field_bbe33e6c.i_method_89901e42(this.I_field_bbe33e6c.I_method_e1d4a248().get(this.I_field_49));
            this.I_field_ba20ca4c.I_method_4e1408b5(I_method_88a1a938().I_method_7ce4a4f0());
         }
      }
   }

   public void I_method_911c871f(float var1, float var2) {
      boolean var3 = !this.i_field_5a && this.contains(var1, var2)
         || this.i_field_5a && this.III_field_b5845eac != null && this.III_field_b5845eac.contains(var1, var2);
      if (this.I_field_5a && !var3 && !this.i_field_b584628c.contains(var1, var2)) {
         this.I_method_574343d5(false);
      }

      if (this.II_field_5a && !this.contains(var1, var2)) {
         this.i_method_590633f5(false);
      }

      if (this.Ii_field_5a
         && this.Iii_field_b5845eac != null
         && !this.Iii_field_b5845eac.contains(var1, var2)
         && (!this.I_field_b584628c.inFlow() || !this.I_field_b584628c.contains(var1, var2))) {
         this.II_method_92e036b2(false);
      }
   }

   public void ii_method_59230462() {
      this.i_method_590633f5(true);
   }

   public boolean i_method_1ba556c3() {
      return this.II_field_5a || this.ii_method_59230466();
   }

   private boolean ii_method_59230466() {
      return this.i_field_5a && this.II_field_b584628c.phase() == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866;
   }

   private void i_method_590633f5(boolean var1) {
      if (this.II_field_5a != var1) {
         this.II_field_5a = var1;
         IIii_Class4 var2 = var1 ? IIii_Class4.i_field_f93678c1 : IIii_Class4.I_method_3682ece9(320L, IiiiIiiII_Class237.IIii_field_dd60aac);
         this.I_method_84672d76(var2);
         if (var1) {
            this.I_method_574343d5(false);
            this.II_method_92e036b2(false);
            this.Iii_method_94bff73f();
            float var3 = Math.min(150.0F, Math.max(1, this.i_field_7865b31.size()) * 18.0F + 6.0F);
            float var4 = 23.0F + var3;
            this.IIi_method_4dfc88d7(207.0F).IiI_method_31d4c97(var4).I_method_7e2bb176(IIII.I_field_f935fcc1);
            if (this.i_field_5a) {
               Window var5 = MinecraftClient.getInstance().getWindow();
               this.snapToSize(207.0F, var4);
               this.snapAt((var5.getScaledWidth() - 207.0F) / 2.0F, (var5.getScaledHeight() - var4) / 2.0F);
               this.II_field_b584628c.i_method_b358e156(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.I_field_dd60aac));
            }

            this.II_method_244860a9(List.of(this.II_field_b584628c));
         } else if (this.i_field_5a) {
            this.II_field_b584628c.i_method_b358e156(IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.iI_field_dd60aac));
            this.II_method_244860a9(List.of());
         } else {
            this.i_field_b5845eac.enter(IiiI_Class7.II_field_f94500c1).lifeMotion(IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.IIII_field_dd60aac));
            this.II_field_b5845eac.enter(IiiI_Class7.II_field_f94500c1).lifeMotion(IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.IIII_field_dd60aac));
            this.Ii_field_b5845eac.enter(IiiI_Class7.II_field_f94500c1).lifeMotion(IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.IIII_field_dd60aac));
            this.IIi_method_4dfc88d7(94.0F).IiI_method_31d4c97(24.0F).I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 8.0F, 0.0F, 6.0F));
            this.II_method_244860a9(List.of(this.i_field_b5845eac, this.II_field_b5845eac, this.Ii_field_b5845eac));
         }
      }
   }

   private void Iii_method_94bff73f() {
      this.i_field_7865b31.clear();

      for (ModuleEntry var3 : RockstarClient.getInstance()
         .getModuleManager()
         .getModules()
         .stream()
         .filter(ModuleEntry::isAvailable)
         .sorted(Comparator.comparing(ModuleEntry::getName))
         .toList()) {
         if (var3.getKeybind() != -1) {
            this.i_field_7865b31.add(new IIIIi_Class2.Nested1_b33417a0(List.of(var3.getName()), var3::getKeybind, var1 -> {
               var3.setKeybind(var1);
               iII_method_c9898f1f();
            }));
         }

         for (Setting var5 : var3.getSettings()) {
            if (var5 instanceof KeybindSetting var6 && var6.isVisible() && var6.I_method_fa6281d2() != -1) {
               this.i_field_7865b31
                  .add(
                     new IIIIi_Class2.Nested1_b33417a0(
                        List.of(var3.getName(), IiIiIIII_Class81.I_method_f25a980a(var5.getName())), var6::I_method_fa6281d2, var1 -> {
                           var6.I_method_51ee2d04(var1);
                           iII_method_c9898f1f();
                        }
                     )
                  );
            }
         }
      }

      AssistModule var7 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
      if (var7 != null) {
         for (iIiIIiII_Class165 var10 : var7.i_method_78846a68()) {
            if (var10.I_method_75fee8ff() != -1) {
               this.i_field_7865b31
                  .add(
                     new IIIIi_Class2.Nested1_b33417a0(
                        List.of("Assist", "\u041c\u0430\u043a\u0440\u043e\u0441\u044b", IiIiIIII_Class81.I_method_f25a980a(var10.I_method_cca0c514())),
                        var10::I_method_75fee8ff,
                        var1 -> {
                           var10.I_method_49deab77(var1);
                           iII_method_c9898f1f();
                        }
                     )
                  );
            }
         }
      }

      IiIiIiII_Class85 var9 = RockstarClient.getInstance().I_method_af32eeab();
      if (var9 != null) {
         for (IiIiIIii_Class84 var13 : var9.I_method_e1cbbc5b()) {
            if (var13.I_method_886a907f() != -1) {
               String var16 = var13.I_method_f1090d94();
               this.i_field_7865b31
                  .add(new IIIIi_Class2.Nested1_b33417a0(List.of(var16), () -> I_method_bd689adc(var16), var1 -> I_method_efab353a(var16, var1)));
            }
         }
      }

      ArrayList var12 = new ArrayList(this.i_field_7865b31.size() + 1);
      if (this.i_field_7865b31.isEmpty()) {
         var12.add(this.IiiI_method_8c9dbc38());
      }

      for (IIIIi_Class2.Nested1_b33417a0 var17 : this.i_field_7865b31) {
         var12.add(this.I_method_58106758(var17));
      }

      Iii_Class4 var15 = new Iii_Class4().fillWidth().height(6.0F).interactive(false);
      i_method_aafbd2c7(var15);
      var12.add(var15);
      this.Ii_field_b584628c.II_method_244860a9(var12);
   }

   private static IIiiiiiI_Class63 I_method_88a1a938() {
      return RockstarClient.getInstance().I_method_5198232b();
   }

   private static void iII_method_c9898f1f() {
      I_method_88a1a938().II_method_1fbeeff5();
   }

   private static void iIi_method_c9981aff() {
      RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
   }

   private static int I_method_bd689adc(String var0) {
      IiIiIiII_Class85 var1 = RockstarClient.getInstance().I_method_af32eeab();
      if (var1 != null) {
         for (IiIiIIii_Class84 var3 : var1.I_method_e1cbbc5b()) {
            if (var3.I_method_f1090d94().equalsIgnoreCase(var0)) {
               return var3.I_method_886a907f();
            }
         }
      }

      return -1;
   }

   private static void I_method_efab353a(String var0, int var1) {
      IiIiIiII_Class85 var2 = RockstarClient.getInstance().I_method_af32eeab();
      if (var2 != null) {
         var2.I_method_9c8173a(var0);
         if (var1 != -1) {
            var2.I_method_2f3b428d(var0, var1);
         }

         iIi_method_c9981aff();
      }
   }

   private iii_Class8 IiiI_method_8c9dbc38() {
      Iii_Class4 var1 = new Iii_Class4()
         .fill()
         .interactive(false)
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
            () -> IiIiIIII_Class81.I_method_f25a980a("commands.bind.list_empty"),
            var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F)
         );
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .IiI_method_31d4c97(18.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
         .I_method_8939bffd(var1);
      i_method_aafbd2c7(var2);
      return var2;
   }

   private iii_Class8 I_method_58106758(IIIIi_Class2.Nested1_b33417a0 var1) {
      iiiI_Class15 var2 = new iiiI_Class15(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), var1.I_method_2c442d67(), var1.I_method_1488e87d());
      Iii_Class4 var3 = new Iii_Class4().fill().interactive(false).paint((var2x, var3x) -> this.I_method_8fcee2d0(var2x, var3x, var1.I_method_9d0caaed()));
      iii_Class8 var4 = new iii_Class8()
         .IiI_method_31d4c97(18.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
         .I_method_8939bffd(var3)
         .I_method_8939bffd(var2)
         .I_method_70a38517(5.0F)
         .I_method_3301fdd(iII_Class5.II_field_b583e68c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .i_method_5db1deeb(var2::I_method_10341dfa)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c);
      i_method_aafbd2c7(var4);
      return var4;
   }

   private void I_method_8fcee2d0(III var1, Iii_Class4 var2, List<String> var3) {
      IIiIIi_Class10 var4 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
      float var5 = var2.y() + var2.h() / 2.0F - var4.I_method_a649725c() / 2.0F;
      float var6 = var2.x();

      for (int var7 = 0; var7 < var3.size(); var7++) {
         boolean var8 = var7 == var3.size() - 1;
         String var9 = (String)var3.get(var7);
         var1.drawText(var4, var9, var6, var5, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(var8 ? 1.0F : 0.5F));
         var6 += var4.I_method_2c375926(var9);
         if (!var8) {
            float var10 = var6 + 3.0F;
            var1.drawRoundedRect(
               var10, var2.y() + var2.h() / 2.0F - 1.0F, 2.0F, 2.0F, IIiii_Class8.I_method_893b2757(1.0F), IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F)
            );
            var6 = var10 + 2.0F + 4.0F;
         }
      }
   }

   public boolean II_method_57518866() {
      return this.Ii_field_5a;
   }

   private boolean III_method_92ee7b43() {
      return this.Iii_field_b5845eac != null && this.I_field_b584628c.phase() == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866;
   }

   private Iii_Class4 I_method_ce3fdabd(String var1, Runnable var2) {
      return new Iii_Class4()
         .size(8.0F, 8.0F)
         .textInset(1.0F)
         .icon(var1, 8.0F, var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F + 0.4F * var0.hover()))
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick(var2);
   }

   private static void I_method_24f232a7(iiI_Class7 var0) {
      var0.enter(IiiI_Class7.I_field_f94500c1);
      if (var0 instanceof iii_Class8 var1) {
         for (iiI_Class7 var3 : var1.I_method_38e5328()) {
            I_method_24f232a7(var3);
         }
      }
   }

   private static void i_method_aafbd2c7(iiI_Class7 var0) {
      var0.snapPosition().snapSize();
      if (var0 instanceof iii_Class8 var1) {
         for (iiI_Class7 var3 : var1.I_method_38e5328()) {
            i_method_aafbd2c7(var3);
         }
      }
   }

   @Override
   protected void drawChildren(III var1, float var2) {
      if (!this.i_field_5a || this.II_field_5a || this.Ii_field_5a || this.ii_method_59230466() || this.III_method_92ee7b43()) {
         if (!this.i_field_5a && this.II_field_5a) {
            MatrixStack var3 = var1.getMatrices();
            iIiiiIiII_Class373.I_method_d5a5ee51(var3, this.x(), this.y(), this.w(), this.h());
            super.drawChildren(var1, var2);
            iIiiiIiII_Class373.I_method_ff80a1df();
         } else {
            super.drawChildren(var1, var2);
         }
      }
   }

   @Override
   public boolean mouseClicked(float var1, float var2, IiIII_Class9 var3) {
      return this.i_field_5a && !this.II_field_5a ? false : super.mouseClicked(var1, var2, var3);
   }

   private void II_method_92e036b2(boolean var1) {
      if (this.Ii_field_5a != var1) {
         this.Ii_field_5a = var1;
         IIii_Class4 var2 = var1 ? IIii_Class4.i_field_f93678c1 : IIii_Class4.I_method_3682ece9(320L, IiiiIiiII_Class237.IIii_field_dd60aac);
         if (this.Iii_field_b5845eac == null) {
            this.I_method_84672d76(var2);
         }

         this.Ii_field_b5845eac.motion(var2);
         this.I_field_b584628c
            .i_method_b358e156(
               var1
                  ? IIii_Class4.I_method_3682ece9(180L, IiiiIiiII_Class237.IIii_field_dd60aac)
                  : IIii_Class4.I_method_3682ece9(260L, IiiiIiiII_Class237.IIii_field_dd60aac)
            );
         if (var1) {
            this.I_method_574343d5(false);
            this.i_method_590633f5(false);
            this.iI_field_4a = System.currentTimeMillis();
            if (this.Iii_field_b5845eac == null) {
               this.IIi_method_4dfc88d7(207.0F).IiI_method_31d4c97(24.0F).I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 10.0F));
               this.II_method_244860a9(List.of(this.Ii_field_b5845eac, this.iI_field_b5845eac, this.ii_field_b5845eac));
            }

            this.i_method_f524a7f5().II_method_fb6974c2();
            this.i_method_f524a7f5().I_method_1d5afa89("");
            this.i_method_f524a7f5().II_method_e557b20c("\u041f\u043e\u0438\u0441\u043a");
            this.i_method_f524a7f5().I_method_fb5b3035(true);
            this.i_field_49 = 0;
            this.iiI_method_cb4c7f3f();
            this.I_field_523beb0a = "";
         } else if (this.Iii_field_b5845eac != null) {
            this.i_method_f524a7f5().II_method_fb6974c2();
            this.i_method_f524a7f5().I_method_1d5afa89("");
            this.i_method_f524a7f5().I_method_fb5b3035(false);
         } else {
            this.i_field_b5845eac.enter(IiiI_Class7.II_field_f94500c1).lifeMotion(IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.IIII_field_dd60aac));
            this.II_field_b5845eac.enter(IiiI_Class7.II_field_f94500c1).lifeMotion(IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.IIII_field_dd60aac));
            this.IIi_method_4dfc88d7(94.0F).IiI_method_31d4c97(24.0F).I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 8.0F, 0.0F, 6.0F));
            this.II_method_244860a9(List.of(this.i_field_b5845eac, this.II_field_b5845eac, this.Ii_field_b5845eac));
            this.i_method_f524a7f5().I_method_fb5b3035(false);
         }
      }
   }

   private IiIiIIIII_Class161 i_method_f524a7f5() {
      if (this.I_field_fdef2cc == null) {
         this.I_field_fdef2cc = new IiIiIIIII_Class161(this.i_field_856d0221 != null ? this.i_field_856d0221 : I_field_856d0221);
      }

      return this.I_field_fdef2cc;
   }

   private String i_method_f70313c1() {
      String var1 = this.i_method_f524a7f5().I_method_d2579001();
      return var1 == null ? "" : var1.trim();
   }

   private static String I_method_b39f68d7(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());

      for (char var5 : var0.toCharArray()) {
         int var6 = "\u0439\u0446\u0443\u043a\u0435\u043d\u0433\u0448\u0449\u0437\u0445\u044a\u0444\u044b\u0432\u0430\u043f\u0440\u043e\u043b\u0434\u0436\u044d\u044f\u0447\u0441\u043c\u0438\u0442\u044c\u0431\u044e."
            .indexOf(var5);
         if (var6 >= 0) {
            var1.append("qwertyuiop[]asdfghjkl;'zxcvbnm,./".charAt(var6));
         } else {
            var6 = "qwertyuiop[]asdfghjkl;'zxcvbnm,./".indexOf(var5);
            var1.append(
               var6 >= 0
                  ? "\u0439\u0446\u0443\u043a\u0435\u043d\u0433\u0448\u0449\u0437\u0445\u044a\u0444\u044b\u0432\u0430\u043f\u0440\u043e\u043b\u0434\u0436\u044d\u044f\u0447\u0441\u043c\u0438\u0442\u044c\u0431\u044e."
                     .charAt(var6)
                  : var5
            );
         }
      }

      return var1.toString();
   }

   private static int I_method_52c64f70(String var0, String var1, String var2) {
      String var3 = IiiIiiIiI_Class219.I_method_12a37157(var0);
      return Math.min(IiiIiiIiI_Class219.i_method_ca495fc6(var3, var1), IiiIiiIiI_Class219.i_method_ca495fc6(var3, var2));
   }

   private void iiI_method_cb4c7f3f() {
      String var1 = this.i_method_f70313c1();
      String var2 = IiiIiiIiI_Class219.I_method_12a37157(var1);
      String var3 = IiiIiiIiI_Class219.I_method_12a37157(I_method_b39f68d7(var1.toLowerCase()));
      this.II_field_7865b31.clear();
      List var4 = RockstarClient.getInstance()
         .getModuleManager()
         .getModules()
         .stream()
         .filter(ModuleEntry::isAvailable)
         .sorted(Comparator.comparing(ModuleEntry::getName, String.CASE_INSENSITIVE_ORDER))
         .toList();
      if (var2.isEmpty()) {
         for (ModuleEntry var17 : (Iterable<ModuleEntry>)(Iterable<?>)var4) {
            this.II_field_7865b31.add(new IIIIi_Class2.Nested1_b33417c0(var17, null, var17.getName(), 0));
         }

         this.iii_method_cb5b0b1f();
      } else {
         ModuleEntry var5 = null;
         int var6 = Integer.MAX_VALUE;

         for (ModuleEntry var8 : (Iterable<ModuleEntry>)(Iterable<?>)var4) {
            int var9 = I_method_52c64f70(var8.getName(), var2, var3);
            if (var9 <= 10 && var9 < var6) {
               var5 = var8;
               var6 = var9;
            }
         }

         if (var5 != null) {
            this.II_field_7865b31.add(new IIIIi_Class2.Nested1_b33417c0(var5, null, var5.getName(), var6));
            int var19 = 0;

            for (Setting var23 : var5.getSettings()) {
               if (var23.isVisible()) {
                  this.II_field_7865b31
                     .add(new IIIIi_Class2.Nested1_b33417c0(var5, var23, IiIiIIII_Class81.I_method_f25a980a(var23.getName()), 100 + var19++));
               }
            }

            this.iii_method_cb5b0b1f();
         } else {
            for (ModuleEntry var20 : (Iterable<ModuleEntry>)(Iterable<?>)var4) {
               int var22 = I_method_52c64f70(var20.getName(), var2, var3);
               boolean var10 = var22 != Integer.MAX_VALUE;
               if (var10) {
                  this.II_field_7865b31.add(new IIIIi_Class2.Nested1_b33417c0(var20, null, var20.getName(), var22));
               }

               int var11 = 0;

               for (Setting var13 : var20.getSettings()) {
                  if (var13.isVisible()) {
                     String var14 = IiIiIIII_Class81.I_method_f25a980a(var13.getName());
                     int var15 = I_method_52c64f70(var14, var2, var3);
                     if (var15 != Integer.MAX_VALUE) {
                        this.II_field_7865b31.add(new IIIIi_Class2.Nested1_b33417c0(var20, var13, var14, 1000 + var15));
                     } else if (var10) {
                        this.II_field_7865b31.add(new IIIIi_Class2.Nested1_b33417c0(var20, var13, var14, 2000 + var22 + var11));
                     }

                     var11++;
                  }
               }
            }

            this.II_field_7865b31
               .sort(
                  Comparator.comparingInt(IIIIi_Class2.Nested1_b33417c0::I_method_b70ec3ed)
                     .thenComparing(var0 -> var0.I_method_e41f403d().getName(), String.CASE_INSENSITIVE_ORDER)
                     .thenComparing(IIIIi_Class2.Nested1_b33417c0::I_method_e5a063e6, String.CASE_INSENSITIVE_ORDER)
               );
            this.iii_method_cb5b0b1f();
         }
      }
   }

   private void iii_method_cb5b0b1f() {
      if (this.i_field_49 >= this.II_field_7865b31.size()) {
         this.i_field_49 = Math.max(0, this.II_field_7865b31.size() - 1);
      }

      ArrayList var1 = new ArrayList(this.II_field_7865b31.size() + 2);
      var1.add(I_method_999f02b5());

      for (int var2 = 0; var2 < this.II_field_7865b31.size(); var2++) {
         var1.add(this.I_method_bc121717(this.II_field_7865b31.get(var2), var2));
      }

      var1.add(I_method_999f02b5());
      this.I_field_b584628c.II_method_244860a9(var1);
   }

   private static Iii_Class4 I_method_999f02b5() {
      return new Iii_Class4().fillWidth().height(6.0F).interactive(false);
   }

   private Iii_Class4 I_method_bc121717(IIIIi_Class2.Nested1_b33417c0 var1, int var2) {
      return new Iii_Class4()
         .fillWidth()
         .height(18.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .hoverMotion(IIii_Class4.I_method_48883e1f(70L))
         .bind("sel", () -> var2 == this.i_field_49, IIii_Class4.I_method_3682ece9(160L, IiiiIiiII_Class237.IIii_field_dd60aac))
         .onClick(() -> this.I_method_442a412(var1, true))
         .paint((var3, var4) -> this.I_method_e2c84d41(var3, var4, var1, var2));
   }

   private void I_method_e2c84d41(III var1, Iii_Class4 var2, IIIIi_Class2.Nested1_b33417c0 var3, int var4) {
      if (var2.hover() > 0.5F) {
         this.i_field_49 = var4;
      }

      IIiIIi_Class10 var5 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
      IIiIIi_Class10 var6 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      String var7 = "TAB - \u041e\u0442\u043a\u0440\u044b\u0442\u044c";
      float var8 = 5.0F;
      float var9 = var2.x() + var2.w() - 10.0F - var8;
      float var10 = var9 - 3.0F - var6.I_method_2c375926(var7);
      float var11 = var2.y() + var2.h() / 2.0F - var5.I_method_a649725c() / 2.0F;
      float var12 = var2.x() + 10.0F;
      float var13;
      if (var3.I_method_b70ec3fe()) {
         String var14 = var3.I_method_e41f403d().getName();
         var1.drawText(var5, var14, var12, var11, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F));
         float var15 = var12 + var5.I_method_2c375926(var14) + 2.0F;
         var1.drawRoundedRect(
            var15, var2.y() + var2.h() / 2.0F - 1.0F, 2.0F, 2.0F, IIiii_Class8.I_method_893b2757(1.0F), IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F)
         );
         var13 = var15 + 2.0F + 4.0F;
      } else {
         var13 = var12;
      }

      String var21 = var3.I_method_e5a063e6();
      float var22 = var2.sig("sel");
      float var16 = var2.x() + var2.w() - 10.0F - var13;
      float var17 = var10 - 6.0F - var13;
      float var18 = var16 + (var17 - var16) * var22;
      if (var5.I_method_2c375926(var21) > var18) {
         var1.drawFadeText(var5, var21, var13, var11, IiiiiIIIi_Class242.iII_field_d0c8ec5, 0.0F, 8.0F, var18);
      } else {
         var1.drawText(var5, var21, var13, var11, IiiiiIIIi_Class242.iII_field_d0c8ec5);
      }

      if (var4 == this.i_field_49) {
         this.I_field_b575d2cc.I_method_82de4e21(var2.y());
         float var19 = this.I_field_b575d2cc.I_method_4e8b496f();
         ColorRGBA var20 = IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F);
         var1.drawText(var6, var7, var10, var19 + var2.h() / 2.0F - var6.I_method_a649725c() / 2.0F, var20);
         var1.drawIcon("arrows", var9, var19 + var2.h() / 2.0F - var8 / 2.0F, var8, var20);
      }
   }

   private void I_method_57430404(int var1) {
      if (!this.II_field_7865b31.isEmpty()) {
         this.i_field_49 = Math.max(0, Math.min(this.II_field_7865b31.size() - 1, this.i_field_49 + var1));
      }
   }

   private void I_method_442a412(IIIIi_Class2.Nested1_b33417c0 var1, boolean var2) {
      if (var2) {
         if (this.I_field_17cc1433 != null) {
            this.I_field_17cc1433.accept(var1.I_method_e41f403d(), var1.I_method_13518110());
         }

         this.II_method_92e036b2(false);
      } else if (var1.I_method_13518110() == null) {
         var1.I_method_e41f403d().toggle();
      } else if (var1.I_method_13518110() instanceof BooleanSetting var3) {
         var3.toggle();
      }
   }

   private void Ii_method_94a326d2(boolean var1) {
      if (!this.II_field_7865b31.isEmpty()) {
         this.I_method_442a412(this.II_field_7865b31.get(this.i_field_49), var1);
      }
   }

   @Override
   public boolean keyPressed(int var1, int var2, int var3) {
      if (this.II_field_5a) {
         if (super.keyPressed(var1, var2, var3)) {
            return true;
         } else {
            if (var1 == 256) {
               this.i_method_590633f5(false);
            }

            return true;
         }
      } else if (!this.Ii_field_5a) {
         if (var1 == 70 && (var3 & 2) != 0 && !iiiI_Class15.i_method_d4e71010()) {
            this.II_method_92e036b2(true);
            return true;
         } else if (this.I_field_5a && var1 == 256) {
            this.I_method_574343d5(false);
            return true;
         } else {
            return false;
         }
      } else {
         switch (var1) {
            case 256:
               this.II_method_92e036b2(false);
               break;
            case 257:
            case 335:
               this.Ii_method_94a326d2(false);
               break;
            case 258:
               this.Ii_method_94a326d2(true);
               break;
            case 264:
               this.I_method_57430404(1);
               break;
            case 265:
               this.I_method_57430404(-1);
               break;
            default:
               this.i_method_f524a7f5().I_method_c1acbc24(var1, var2, var3);
         }

         return true;
      }
   }

   @Override
   public boolean charTyped(char var1, int var2) {
      if (!this.Ii_field_5a) {
         return false;
      } else {
         this.i_method_f524a7f5().I_method_b71e84c9(var1, var2);
         return true;
      }
   }

   @Override
   public boolean mouseScrolled(float var1, float var2, float var3, float var4) {
      return super.mouseScrolled(var1, var2, var3, var4) || this.contains(var1, var2);
   }

   @Override
   public void mouseReleased(float var1, float var2, IiIII_Class9 var3) {
      super.mouseReleased(var1, var2, var3);
      if (this.I_field_fdef2cc != null) {
         this.I_field_fdef2cc.i_method_6a097ac7(var1, var2, var3);
      }
   }

   @Override
   protected void onTick(float var1, float var2, float var3) {
      super.onTick(var1, var2, var3);
      this.I_field_b575d2cc.Ii_method_dc72325e(var1);
      float var4 = this.desiredW();
      float var5 = this.desiredH();
      this.iI_field_5a = this.Ii_field_5a && System.currentTimeMillis() - this.iI_field_4a > 140L;
      if ((this.Ii_field_5a || this.III_method_92ee7b43()) && this.Iii_field_b5845eac == null) {
         Window var9 = MinecraftClient.getInstance().getWindow();
         float var7 = this.II_field_7865b31.isEmpty() ? 0.0F : Math.min(150.0F, this.II_field_7865b31.size() * 18.0F + 12.0F);
         float var8 = var5 + (var7 > 0.0F ? 6.0F + var7 : 0.0F);
         this.iI_method_7009d1d8((var9.getScaledWidth() - var4) / 2.0F, (var9.getScaledHeight() - var8) / 2.0F);
      } else if (!this.II_field_5a && !this.ii_method_59230466()) {
         this.iI_method_7009d1d8(
            this.I_field_b5845eac.x() + (this.I_field_b5845eac.w() - var4) / 2.0F, this.I_field_b5845eac.y() + this.I_field_b5845eac.h() + 10.0F
         );
      } else {
         Window var6 = MinecraftClient.getInstance().getWindow();
         this.iI_method_7009d1d8((var6.getScaledWidth() - var4) / 2.0F, (var6.getScaledHeight() - var5) / 2.0F);
      }

      if (this.Iii_field_b5845eac != null) {
         this.I_field_b584628c
            .snapAt(
               this.I_field_b5845eac.x() + (this.I_field_b5845eac.w() - 207.0F) / 2.0F,
               this.I_field_b5845eac.y() + (this.I_field_b5845eac.h() - this.I_field_b584628c.h()) / 2.0F
            );
      } else {
         this.I_field_b584628c.snapAt(this.x(), this.y() + this.h() + 6.0F);
      }

      if (this.I_field_5a) {
         iiI_Class7 var10 = this.III_field_b5845eac != null ? this.III_field_b5845eac : this.II_field_b5845eac;
         if (this.i_field_5a && this.III_field_b5845eac != null) {
            this.i_field_b584628c.snapAt(var10.x() + var10.w() + 5.0F, var10.y() + var10.h() - this.i_field_b584628c.h());
         } else {
            this.i_field_b584628c.snapAt(var10.x(), var10.y() + var10.h() / 2.0F - this.i_field_b584628c.h() / 2.0F);
         }
      }

      this.IIII_method_caefe402();
      if (this.Ii_field_5a) {
         if (!this.i_method_f524a7f5().I_method_189fd283()) {
            this.i_method_f524a7f5().I_method_fb5b3035(true);
         }

         String var11 = this.i_method_f524a7f5().I_method_d2579001();
         if (!var11.equals(this.I_field_523beb0a)) {
            this.I_field_523beb0a = var11;
            this.iiI_method_cb4c7f3f();
         }

         if (this.i_field_49 >= this.II_field_7865b31.size()) {
            this.i_field_49 = Math.max(0, this.II_field_7865b31.size() - 1);
         }
      }
   }

   private void IIII_method_caefe402() {
      int var1 = this.I_field_bbe33e6c.I_method_e1d4a248().indexOf(this.I_field_bbe33e6c.i_method_f85f3850());
      if (var1 != this.I_field_49 && var1 >= 0) {
         this.I_field_49 = var1;

         IiIiIIII_Class81.I_method_9b03faed(switch (var1) {
            case 1 -> IiIIiiii_Class80.I_field_3f56db61;
            case 2 -> IiIIiiii_Class80.II_field_3f56db61;
            case 3 -> IiIIiiii_Class80.Ii_field_3f56db61;
            default -> IiIIiiii_Class80.i_field_3f56db61;
         });
         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
      }

      if (this.I_field_ba20ca4c.i_method_9b12da03() != I_method_88a1a938().I_method_7ce4a4f0()) {
         I_method_88a1a938().I_method_1fb0ab68(this.I_field_ba20ca4c.i_method_9b12da03());
         iIi_method_c9981aff();
      }

      ColorRGBA var2 = this.I_field_bbd4b66c.I_method_bde5f08e() == null ? null : this.I_field_bbd4b66c.I_method_bde5f08e().withAlpha(255.0F);
      if (var2 != null && !var2.equals(IiiiiIIIi_Class242.I_method_7df8e08e())) {
         IiiiiIIIi_Class242.I_method_300b2840(var2);
         this.i_field_4a = System.currentTimeMillis();
      }

      if (this.i_field_4a != 0L && System.currentTimeMillis() - this.i_field_4a > 600L) {
         this.i_field_4a = 0L;
         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
      }
   }

   public static Identifier I_method_79e9d9ee() {
      return Information.getSelfAvatar();
   }

   public static boolean Ii_method_57601446() {
      return true;
   }

   public static void III_method_92ee7b3f() {
      Information.getSelfAvatar();
   }

   static final class Nested1_b33417a0 {
      private final List<String> I_field_7865b31;
      private final IntSupplier I_field_ba7cd5ab;
      private final IntConsumer I_field_a2c190c1;

      Nested1_b33417a0(List<String> var1, IntSupplier var2, IntConsumer var3) {
         this.I_field_7865b31 = var1;
         this.I_field_ba7cd5ab = var2;
         this.I_field_a2c190c1 = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_b33417a0[segments=" + this.I_field_7865b31 + ", get=" + this.I_field_ba7cd5ab + ", set=" + this.I_field_a2c190c1 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7865b31);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_ba7cd5ab);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_a2c190c1);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIIi_Class2.Nested1_b33417a0 other = (IIIIi_Class2.Nested1_b33417a0) var1;
         return java.util.Objects.equals(this.I_field_7865b31, other.I_field_7865b31)
            && java.util.Objects.equals(this.I_field_ba7cd5ab, other.I_field_ba7cd5ab)
            && java.util.Objects.equals(this.I_field_a2c190c1, other.I_field_a2c190c1);
      }

      public List<String> I_method_9d0caaed() {
         return this.I_field_7865b31;
      }

      public IntSupplier I_method_2c442d67() {
         return this.I_field_ba7cd5ab;
      }

      public IntConsumer I_method_1488e87d() {
         return this.I_field_a2c190c1;
      }
   }

   static final class Nested1_b33417c0 {
      private final ModuleEntry I_field_75e36361;
      private final Setting I_field_ba11c26c;
      private final String I_field_523beb0a;
      private final int I_field_49;

      Nested1_b33417c0(ModuleEntry var1, Setting var2, String var3, int var4) {
         this.I_field_75e36361 = var1;
         this.I_field_ba11c26c = var2;
         this.I_field_523beb0a = var3;
         this.I_field_49 = var4;
      }

      boolean I_method_b70ec3fe() {
         return this.I_field_ba11c26c != null;
      }

      @Override
      public final String toString() {
         return "Nested1_b33417c0[module=" + this.I_field_75e36361 + ", setting=" + this.I_field_ba11c26c + ", display=" + this.I_field_523beb0a + ", score=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_75e36361);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_ba11c26c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIIi_Class2.Nested1_b33417c0 other = (IIIIi_Class2.Nested1_b33417c0) var1;
         return java.util.Objects.equals(this.I_field_75e36361, other.I_field_75e36361)
            && java.util.Objects.equals(this.I_field_ba11c26c, other.I_field_ba11c26c)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public ModuleEntry I_method_e41f403d() {
         return this.I_field_75e36361;
      }

      public Setting I_method_13518110() {
         return this.I_field_ba11c26c;
      }

      public String I_method_e5a063e6() {
         return this.I_field_523beb0a;
      }

      public int I_method_b70ec3ed() {
         return this.I_field_49;
      }
   }
}
