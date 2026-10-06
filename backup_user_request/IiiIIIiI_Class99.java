package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.ItemEnchantmentsComponent.Builder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.RotationAxis;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

public class IiiIIIiI_Class99 extends IIiI_Class3 {
   private static final float I_field_46 = 11.0F;
   private static final float i_field_46 = 7.0F;
   private static final float II_field_46 = 10.0F;
   private static final float Ii_field_46 = 25.0F;
   private static final float iI_field_46 = 236.0F;
   private static final float ii_field_46 = 32.0F;
   private static final float III_field_46 = 11.0F;
   private static final float IIi_field_46 = 193.0F;
   private static final float IiI_field_46 = 154.0F;
   private static final float Iii_field_46 = 40.0F;
   private static final float iII_field_46 = 30.0F;
   private static final float iIi_field_46 = 19.0F;
   private static final float iiI_field_46 = 9.0F;
   private static final float iii_field_46 = 8.0F;
   private static final float IIII_field_46 = 562.0F;
   private static final IIii_Class4 I_field_f93678c1 = IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.IIII_field_dd60aac);
   private static final IiiI_Class7 I_field_f94500c1 = (var0, var1, var2) -> {
      var2.I_field_46 = var0;
      var2.II_field_46 = (1.0F - var0) * 6.0F;
   };
   private static boolean I_field_5a;
   private IiiIIIiI_Class99.Nested1_6b3ab4b3 I_field_7a2a121c;
   private IiiIIIiI_Class99.Nested1_6b3ab4b3 i_field_7a2a121c;
   private IiiiIIii_Class116.Nested1_80294f3 I_field_765e39dc;
   private IiiiIIii_Class116.Nested1_8029513 I_field_765e3dbc;
   private String I_field_523beb0a;
   private long I_field_4a;
   private boolean i_field_5a;
   private double I_field_44;
   private long i_field_4a;
   private int I_field_49;
   private int i_field_49;
   private String i_field_523beb0a;
   private final LinkedHashMap<RegistryEntry<Enchantment>, Integer> I_field_95707c72;
   private final LinkedHashMap<RegistryEntry<StatusEffect>, Integer> i_field_95707c72;
   private boolean II_field_5a;
   private boolean Ii_field_5a;
   private String II_field_523beb0a;
   private iii_Class8 I_field_b584628c;
   private iii_Class8 i_field_b584628c;
   private iii_Class8 II_field_b584628c;
   private iii_Class8 Ii_field_b584628c;
   private iii_Class8 iI_field_b584628c;
   private iii_Class8 ii_field_b584628c;
   private iii_Class8 III_field_b584628c;
   private iii_Class8 IIi_field_b584628c;
   private String Ii_field_523beb0a;
   private String iI_field_523beb0a;
   private String ii_field_523beb0a;
   private String III_field_523beb0a;
   private String IIi_field_523beb0a;
   private String IiI_field_523beb0a;
   private String Iii_field_523beb0a;

   public IiiIIIiI_Class99() {
      this.I_field_7a2a121c = IiiIIIiI_Class99.Nested1_6b3ab4b3.I_field_7a2a121c;
      this.I_field_765e39dc = IiiiIIii_Class116.Nested1_80294f3.i_field_765e39dc;
      this.I_field_523beb0a = "";
      this.I_field_4a = 25000L;
      this.I_field_44 = 20.0;
      this.I_field_49 = 1;
      this.i_field_49 = 10;
      this.i_field_523beb0a = "";
      this.I_field_95707c72 = new LinkedHashMap<>();
      this.i_field_95707c72 = new LinkedHashMap<>();
      this.II_field_523beb0a = "";
      this.Ii_field_523beb0a = "";
      this.iI_field_523beb0a = "";
      this.ii_field_523beb0a = "";
      this.III_field_523beb0a = "";
      this.IIi_field_523beb0a = "";
      this.IiI_field_523beb0a = "";
      this.Iii_field_523beb0a = "";
   }

   @Compile(
      obfuscation = 4
   )
   @Override
   public void init() {
      if (!I_field_5a) {
         IiiiIIii_Class116.I_method_2500e8ac();
         I_field_5a = true;
      }

      super.init();
      this.clearRoots();
      this.i_field_7a2a121c = null;
      iii_Class8 var1 = new iii_Class8().I_method_485bccf5().I_method_70a38517(9.0F).I_method_483797dd(IIi_Class2.i_field_b5755e8c).iII_method_d8ebd935();
      var1.I_method_8939bffd(this.I_method_e3a3ec22());
      this.I_field_b584628c = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_70a38517(10.0F)
         .IiI_method_31d4c97(236.0F)
         .IIi_method_4dfc88d7(562.0F)
         .I_method_fe5d8d56(IIIi_Class2.i_field_f93600a1);
      var1.I_method_8939bffd(this.I_field_b584628c);
      this.add(var1);
      this.overlays.clear();
      this.openWindow(this.ii_method_efe3cab());
   }

   @Override
   public void render(III var1) {
      this.II_method_41cd63f5();
      super.render(var1);
   }

   private iii_Class8 I_method_e3a3ec22() {
      iii_Class8 var1 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_70a38517(2.0F)
         .I_method_7e2bb176(IIII.I_method_14640aa3(2.0F))
         .iI_method_e886414(7.0F)
         .I_method_f136b1d8(
            (var0, var1x) -> {
               var0.drawBlurredRect(
                  var1x.x(), var1x.y(), var1x.w(), var1x.h(), 5.0F, 3.0F, IIiii_Class8.I_method_893b2757(7.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5
               );
               var0.drawSquircle(
                  var1x.x(), var1x.y(), var1x.w(), var1x.h(), 3.0F, IIiii_Class8.I_method_893b2757(7.0F), IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.55F)
               );
            }
         );
      var1.I_method_8939bffd(this.I_method_75452ba8("\u0417\u0430\u043a\u0443\u043f\u043a\u0430", IiiIIIiI_Class99.Nested1_6b3ab4b3.I_field_7a2a121c));
      var1.I_method_8939bffd(
         this.I_method_75452ba8("\u0410\u043a\u0442\u0438\u0432\u043d\u043e\u0441\u0442\u044c", IiiIIIiI_Class99.Nested1_6b3ab4b3.i_field_7a2a121c)
      );
      var1.I_method_8939bffd(
         this.I_method_75452ba8("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438", IiiIIIiI_Class99.Nested1_6b3ab4b3.II_field_7a2a121c)
      );
      return var1;
   }

   private Iii_Class4 I_method_75452ba8(String var1, IiiIIIiI_Class99.Nested1_6b3ab4b3 var2) {
      Iii_Class4 var3 = new Iii_Class4()
         .text(
            IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F),
            var1,
            var2x -> this.I_field_7a2a121c == var2 ? IiiiiIIIi_Class242.iII_field_d0c8ec5 : IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F)
         )
         .padding(IIII.I_method_b1e865cb(4.0F, 10.0F))
         .radius(5.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      var3.background(
         var2x -> this.I_field_7a2a121c == var2 ? IiiiiIIIi_Class242.IIi_field_d0c8ec5 : IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.05F * var2x.hover())
      );
      var3.onClick(() -> this.I_field_7a2a121c = var2);
      return var3;
   }

   private iii_Class8 I_method_1cbb3f54(float var1, String var2) {
      return new iii_Class8()
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(var1)
         .IIi_method_1df35135()
         .I_method_70a38517(4.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(32.0F, 11.0F, 11.0F, 11.0F))
         .II_method_32b63e79(I_field_f94500c1)
         .i_method_b358e156(I_field_f93678c1)
         .iii_method_df275535()
         .I_method_f136b1d8((var2x, var3) -> this.I_method_70e66c56(var2x, var3, var2));
   }

   private void I_method_70e66c56(III var1, iii_Class8 var2, String var3) {
      float var4 = var2.x();
      float var5 = var2.y();
      float var6 = var2.w();
      float var7 = var2.h();
      var1.drawShadow(var4, var5, var6, var7, 25.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.15F));
      var1.drawBlurredRect(var4, var5, var6, var7, 5.0F, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
      var1.drawClientRect(var4, var5, var6, var7, 1.0F, 0.0F, 3.0F, 11.0F, true);
      var1.drawText(IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F), var3, var4 + 11.0F, var5 + 9.5F, IiiiiIIIi_Class242.iII_field_d0c8ec5);
      var1.drawRect(var4 + 1.0F, var5 + 25.0F - 1.0F, var6 - 2.0F, 1.0F, IiiiiIIIi_Class242.IiI_field_d0c8ec5);
   }

   private iii_Class8 I_method_3e5f4b8a(float var1) {
      return new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(4.0F)
         .III_method_9dc17555()
         .IiI_method_31d4c97(var1)
         .Ii_method_bb38d618()
         .I_method_b65baecb(
            var0 -> var0.i_method_65326e43(2.0F)
               .I_method_4f0ff9cb(1.0F, 4.0F)
               .I_method_2a080a63(2.0F)
               .i_method_989a5f71(
                  var0x -> ColorRGBA.BLACK
                     .mix(ColorRGBA.WHITE, 0.3F)
                     .withAlpha(255.0F * (0.3F + 0.3F * var0x.I_method_af833bdc() + 0.3F * var0x.i_method_af91c7bc()))
               )
         );
   }

   private List<iiI_Class7> I_method_ad4cb9bf(IiiIIIiI_Class99.Nested1_6b3ab4b3 var1) {
      this.i_field_b584628c = this.II_field_b584628c = this.Ii_field_b584628c = this.iI_field_b584628c = this.ii_field_b584628c = this.III_field_b584628c = null;
      ArrayList var2 = new ArrayList();
      switch (var1) {
         case I_field_7a2a121c:
            var2.add(this.i_method_63d5c802());
            var2.add(this.II_method_8c2c0ab());
            var2.add(this.iI_method_8ecc60cb());
            break;
         case i_field_7a2a121c:
            var2.add(this.III_method_877e7d42());
            break;
         case II_field_7a2a121c:
            var2.add(this.IIi_method_7b05922());
      }

      return var2;
   }

   private iii_Class8 i_method_63d5c802() {
      iii_Class8 var1 = this.I_method_1cbb3f54(160.0F, "\u0417\u0430\u043a\u0443\u043f\u043a\u0430");
      this.II_field_b584628c = this.I_method_3e5f4b8a(193.0F);
      var1.I_method_8939bffd(this.II_field_b584628c);
      return var1;
   }

   private iii_Class8 I_method_c0b4003e(IiiIIiIi_Class102.Nested1_6cef9133 var1) {
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(6.0F)
         .III_method_9dc17555()
         .IiI_method_31d4c97(26.0F)
         .I_method_7e2bb176(IIII.i_method_4f8e6e83(1.0F))
         .iI_method_e886414(5.0F)
         .I_method_e53800a9(var0 -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.04F * var0.hover()));
      var2.I_method_8939bffd(
         new Iii_Class4()
            .size(17.0F, 17.0F)
            .paint(
               (var1x, var2x) -> I_method_205a7fa4(
                  var1x, var1.I_method_2478c0b1(), var2x.x() + var2x.w() / 2.0F - 6.8F, var2x.y() + var2x.h() / 2.0F - 6.8F, 0.85F
               )
            )
      );
      iii_Class8 var3 = new iii_Class8().I_method_485bccf5().I_method_70a38517(1.0F).III_method_9dc17555();
      var3.I_method_8939bffd(
         new Iii_Class4()
            .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), I_method_7f0e7a98(var1), IiiiiIIIi_Class242.iII_field_d0c8ec5)
            .fillWidth()
            .height(9.0F)
            .fade()
      );
      var3.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
               () -> i_method_7041bab8(var1),
               var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F)
            )
            .fillWidth()
            .height(7.0F)
            .fade()
      );
      var2.I_method_8939bffd(var3);
      var2.I_method_8939bffd(
         new Iii_Class4()
            .size(14.0F, 14.0F)
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
            .onClick(() -> IiiIIiIi_Class102.I_method_99d59756(var1.i_method_29f1a539()))
            .paint((var0, var1x) -> I_method_7240ad53(var0, var1x, 3.5F, 1.4F, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.35F + 0.4F * var1x.hover())))
      );
      return var2;
   }

   private iii_Class8 II_method_8c2c0ab() {
      iii_Class8 var1 = this.I_method_1cbb3f54(216.0F, "\u041a\u0430\u0442\u0430\u043b\u043e\u0433");
      var1.I_method_8939bffd(
         new IIiII_Class5(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), this.I_field_523beb0a, var1x -> this.I_field_523beb0a = var1x)
            .i_method_459bf75f("\u041f\u043e\u0438\u0441\u043a\u2026")
            .i_method_e2c562d5()
            .Ii_method_3f6d8e94(15.0F)
            .I_method_49a8a757(4.0F)
            .I_method_e5f33669(var0 -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.07F))
            .i_method_73cabf77(3.0F)
            .i_method_8326c8f6(IiiiiIIIi_Class242.iII_field_d0c8ec5)
      );
      var1.I_method_8939bffd(this.Ii_method_88f49c8b());
      this.i_field_b584628c = this.I_method_3e5f4b8a(154.0F);
      var1.I_method_8939bffd(this.i_field_b584628c);
      return var1;
   }

   private iii_Class8 Ii_method_88f49c8b() {
      iii_Class8 var1 = new iii_Class8().i_method_c88da8d5().I_method_70a38517(3.0F).IiI_method_31d4c97(16.0F);

      for (IiiiIIii_Class116.Nested1_80294f3 var5 : IiiiIIii_Class116.Nested1_80294f3.values()) {
         Iii_Class4 var6 = new Iii_Class4()
            .text(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
               var5.i_method_1ec358f9(),
               var2 -> this.I_field_765e39dc == var5 ? IiiiiIIIi_Class242.iIi_field_d0c8ec5 : IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.45F)
            )
            .padding(IIII.I_method_b1e865cb(3.0F, 7.0F))
            .radius(4.0F)
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
         var6.background(
            var2 -> this.I_field_765e39dc == var5 ? IiiiiIIIi_Class242.ii_field_d0c8ec5 : IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.05F * var2.hover())
         );
         var6.onClick(() -> this.I_field_765e39dc = var5);
         var1.I_method_8939bffd(var6);
      }

      return var1;
   }

   private List<iiI_Class7> I_method_2170abdb() {
      ArrayList var1 = new ArrayList();
      String var2 = this.I_field_523beb0a.trim().toLowerCase();

      for (IiiiIIii_Class116.Nested1_f85009b6 var4 : IiiiIIii_Class116.I_method_5efe7a3f(this.I_field_765e39dc)) {
         List var5 = var4.I_method_f3e0b603().stream().filter(var1x -> var2.isEmpty() || I_method_a358ce78(var1x).toLowerCase().contains(var2)).toList();
         if (!var5.isEmpty()) {
            var1.add(
               new Iii_Class4()
                  .text(
                     IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(7.0F),
                     var4.i_method_2489897c().toUpperCase(),
                     var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.45F)
                  )
                  .fillWidth()
                  .height(10.0F)
                  .textInset(1.0F)
            );
            iii_Class8 var6 = new iii_Class8().I_method_4f3850da(5).I_method_70a38517(3.0F).III_method_9dc17555();

            for (IiiiIIii_Class116.Nested1_8029513 var8 : (Iterable<IiiiIIii_Class116.Nested1_8029513>)(Iterable<?>)var5) {
               var6.I_method_8939bffd(this.I_method_e64aa05e(var8));
            }

            var1.add(var6);
         }
      }

      if (var1.isEmpty()) {
         var1.add(
            this.I_method_13335e0c(
               var2.isEmpty()
                  ? "\u041d\u0435\u0442 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432."
                  : "\u041d\u0438\u0447\u0435\u0433\u043e \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e."
            )
         );
      }

      return var1;
   }

   private iii_Class8 I_method_e64aa05e(IiiiIIii_Class116.Nested1_8029513 var1) {
      iii_Class8 var2 = new iii_Class8()
         .I_method_485bccf5()
         .III_method_9dc17555()
         .IiI_method_31d4c97(40.0F)
         .iI_method_e886414(7.0F)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0F, 2.0F, 4.0F, 2.0F))
         .i_method_b358e156(I_field_f93678c1);
      var2.I_method_e53800a9(
         var2x -> this.I_method_5abddb2c(var1)
            ? IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.22F)
            : IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.04F + 0.05F * var2x.hover())
      );
      var2.I_method_f136b1d8(
         (var2x, var3x) -> {
            if (this.i_method_60c5d70c(var1)) {
               var2x.drawRoundedRect(
                  var3x.x() + var3x.w() - 7.0F, var3x.y() + 5.0F, 3.0F, 3.0F, IIiii_Class8.I_method_893b2757(1.5F), IiiiiIIIi_Class242.ii_field_d0c8ec5
               );
            }
         }
      );
      var2.I_method_8939bffd(
         new Iii_Class4()
            .fillWidth()
            .height(18.0F)
            .paint(
               (var1x, var2x) -> I_method_205a7fa4(
                  var1x, var1.I_method_c2b2cc91(), var2x.x() + var2x.w() / 2.0F - 8.0F, var2x.y() + var2x.h() / 2.0F - 8.0F, 1.0F
               )
            )
      );
      Iii_Class4 var3 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F),
            I_method_a358ce78(var1),
            var2x -> this.I_method_5abddb2c(var1) ? IiiiiIIIi_Class242.iII_field_d0c8ec5 : IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.8F)
         )
         .textAlign(IIi_Class2.i_field_b5755e8c)
         .fillWidth()
         .fillHeight()
         .textInset(1.0F);
      if (IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F).I_method_2c375926(I_method_a358ce78(var1)) > 30.0F) {
         var3.fade();
      }

      var2.I_method_8939bffd(var3);
      var2.I_method_c0ca36f3(() -> {
         this.I_field_765e3dbc = var1;
         this.I_field_4a = 25000L;
         this.i_field_4a = 0L;
         this.I_field_49 = 1;
         this.i_field_49 = 10;
         this.I_field_95707c72.clear();
         this.i_field_95707c72.clear();

         for (StatusEffectInstance var3x : iIIIIIiII_Class261.I_method_2d41c106(var1.I_method_c2b2cc91())) {
            this.i_field_95707c72.put(var3x.getEffectType(), var3x.getAmplifier() + 1);
         }

         this.II_field_5a = false;
         this.Ii_field_5a = false;
      });
      return var2;
   }

   private iii_Class8 iI_method_8ecc60cb() {
      iii_Class8 var1 = this.I_method_1cbb3f54(166.0F, "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430");
      iii_Class8 var2 = this.I_method_3e5f4b8a(193.0F);
      var1.I_method_8939bffd(var2);
      Iii_Class4 var3 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
            "\u0412\u044b\u0431\u0435\u0440\u0438 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u0432 \u043a\u0430\u0442\u0430\u043b\u043e\u0433\u0435",
            var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.4F)
         )
         .textAlign(IIi_Class2.i_field_b5755e8c)
         .fillWidth()
         .height(60.0F);
      var3.visibleWhen(() -> this.I_field_765e3dbc == null);
      var2.I_method_8939bffd(var3);
      iii_Class8 var4 = new iii_Class8().I_method_485bccf5().I_method_70a38517(6.0F).III_method_9dc17555();
      var4.I_method_879bc687(() -> this.I_field_765e3dbc != null);
      iii_Class8 var5 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .III_method_9dc17555()
         .IiI_method_31d4c97(16.0F);
      var5.I_method_8939bffd(new Iii_Class4().size(14.0F, 16.0F).paint((var1x, var2x) -> {
         if (this.I_field_765e3dbc != null) {
            I_method_205a7fa4(var1x, this.I_field_765e3dbc.I_method_c2b2cc91(), var2x.x(), var2x.y() + var2x.h() / 2.0F - 6.8F, 0.85F);
         }
      }));
      var5.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
               () -> this.I_field_765e3dbc == null ? "" : I_method_a358ce78(this.I_field_765e3dbc),
               var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5
            )
            .fillWidth()
            .height(10.0F)
            .fade()
      );
      var4.I_method_8939bffd(var5);
      var4.I_method_8939bffd(this.I_method_e3956042());
      var4.I_method_8939bffd(
         this.I_method_15843366(
            "\u041d\u0438\u0436\u0435 \u0440\u044b\u043d\u043a\u0430",
            new IIiiI_Class7(() -> this.i_field_5a).size(15.0F, 9.0F).onClick(() -> this.i_field_5a = !this.i_field_5a)
         )
      );
      iii_Class8 var6 = this.I_method_15843366(
         "\u041c\u0430\u043a\u0441. \u0446\u0435\u043d\u0430",
         new iiii_Class16(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), () -> (float)this.I_field_4a, var1x -> this.I_field_4a = (long)var1x, 0.0F, 1.0E9F
            )
            .i_method_6f9c9a5(() -> "$")
            .i_method_5040b524(IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F))
            .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
      );
      var6.I_method_879bc687(() -> !this.i_field_5a);
      var4.I_method_8939bffd(var6);
      iii_Class8 var7 = this.I_method_15843366(
         "\u041f\u0440\u043e\u0446\u0435\u043d\u0442 \u043d\u0438\u0436\u0435",
         new iiii_Class16(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), () -> (float)this.I_field_44, var1x -> this.I_field_44 = var1x, 0.0F, 95.0F)
            .i_method_6f9c9a5(() -> "%")
            .i_method_5040b524(IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F))
            .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
      );
      var7.I_method_879bc687(() -> this.i_field_5a);
      var4.I_method_8939bffd(var7);
      this.III_field_b584628c = new iii_Class8().I_method_485bccf5().I_method_70a38517(3.0F).III_method_9dc17555();
      this.III_field_b584628c.I_method_879bc687(this::I_method_6537b0f0);
      var4.I_method_8939bffd(this.III_field_b584628c);
      Iii_Class4 var8 = new Iii_Class4()
         .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), "+ \u042d\u0444\u0444\u0435\u043a\u0442", var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5)
         .textAlign(IIi_Class2.i_field_b5755e8c)
         .fillWidth()
         .height(15.0F)
         .radius(5.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      var8.background(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.12F + 0.1F * var0.hover()));
      var8.onClick(() -> {
         this.II_field_523beb0a = "";
         this.Ii_field_5a = true;
      });
      var8.visibleWhen(this::I_method_6537b0f0);
      var4.I_method_8939bffd(var8);
      iii_Class8 var9 = this.I_method_15843366(
         "\u0421\u0442\u0440\u043e\u0433\u0438\u0435 \u0437\u0430\u0447\u0430\u0440\u044b",
         new IIiiI_Class7(() -> this.II_field_5a).size(15.0F, 9.0F).onClick(() -> this.II_field_5a = !this.II_field_5a)
      );
      var9.I_method_879bc687(this::i_method_65463cd0);
      var4.I_method_8939bffd(var9);
      this.ii_field_b584628c = new iii_Class8().I_method_485bccf5().I_method_70a38517(3.0F).III_method_9dc17555();
      this.ii_field_b584628c.I_method_879bc687(this::i_method_65463cd0);
      var4.I_method_8939bffd(this.ii_field_b584628c);
      Iii_Class4 var10 = new Iii_Class4()
         .text(
            IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
            "+ \u0417\u0430\u0447\u0430\u0440\u043e\u0432\u0430\u043d\u0438\u0435",
            var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5
         )
         .textAlign(IIi_Class2.i_field_b5755e8c)
         .fillWidth()
         .height(15.0F)
         .radius(5.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      var10.background(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.12F + 0.1F * var0.hover()));
      var10.onClick(() -> {
         this.II_field_523beb0a = "";
         this.Ii_field_5a = true;
      });
      var10.visibleWhen(this::i_method_65463cd0);
      var4.I_method_8939bffd(var10);
      var4.I_method_8939bffd(this.I_method_e3956042());
      var4.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(7.0F),
               "\u041f\u0420\u041e\u0414\u0410\u0416\u0410",
               var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.45F)
            )
            .fillWidth()
            .height(9.0F)
            .textInset(1.0F)
      );
      var4.I_method_8939bffd(
         this.I_method_15843366(
            "\u0426\u0435\u043d\u0430 \u043f\u0440\u043e\u0434\u0430\u0436\u0438",
            new iiii_Class16(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), () -> (float)this.i_field_4a, var1x -> this.i_field_4a = (long)var1x, 0.0F, 1.0E9F
               )
               .i_method_6f9c9a5(() -> this.i_field_4a > 0L ? "$" : "")
               .i_method_5040b524(IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F))
               .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
               .I_method_c389f5c5(() -> this.i_field_4a > 0L ? iIIIIiIiI_Class267.I_method_230e44c1((float)this.i_field_4a) : "\u0440\u044b\u043d\u043e\u043a")
         )
      );
      var4.I_method_8939bffd(
         this.I_method_15843366(
            "\u041a\u043e\u043b-\u0432\u043e \u0432 \u043b\u043e\u0442\u0435",
            new iiii_Class16(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
                  () -> this.I_field_49,
                  var1x -> this.I_field_49 = Math.max(1, (int)var1x),
                  1.0F,
                  64.0F
               )
               .i_method_6f9c9a5(() -> " \u0448\u0442")
               .i_method_5040b524(IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F))
               .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
         )
      );
      var4.I_method_8939bffd(
         this.I_method_15843366(
            "\u041f\u043e\u0440\u043e\u0433 \u043f\u0435\u0440\u0435\u043f\u0440\u043e\u0434\u0430\u0436\u0438",
            new iiii_Class16(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
                  () -> this.i_field_49,
                  var1x -> this.i_field_49 = Math.max(1, (int)var1x),
                  1.0F,
                  999.0F
               )
               .i_method_6f9c9a5(() -> " \u0448\u0442")
               .i_method_5040b524(IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F))
               .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
         )
      );
      var4.I_method_8939bffd(this.I_method_e3956042());
      Iii_Class4 var11 = new Iii_Class4()
         .text(
            IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F),
            "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432 \u0437\u0430\u043a\u0443\u043f\u043a\u0443",
            IiiiiIIIi_Class242.iIi_field_d0c8ec5
         )
         .textAlign(IIi_Class2.i_field_b5755e8c)
         .fillWidth()
         .height(20.0F)
         .radius(6.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      var11.background(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(var0.hovered() ? 1.0F : 0.85F));
      var11.onClick(this::I_method_6537b0ec);
      var4.I_method_8939bffd(var11);
      var2.I_method_8939bffd(var4);
      return var1;
   }

   private iii_Class8 I_method_15843366(String var1, iiI_Class7 var2) {
      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .III_method_9dc17555()
         .IiI_method_31d4c97(14.0F)
         .I_method_8939bffd(
            new Iii_Class4().text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var1, var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.6F))
         )
         .I_method_8939bffd(var2);
   }

   private void I_method_6537b0ec() {
      if (this.I_field_765e3dbc != null) {
         ItemStack var1 = this.I_field_765e3dbc.I_method_c2b2cc91().copy();
         if (var1.getItem() instanceof PotionItem && !this.i_field_95707c72.isEmpty()) {
            ArrayList var2 = new ArrayList();
            this.i_field_95707c72.forEach((var1x, var2x) -> var2.add(new StatusEffectInstance(var1x, 3600, Math.max(0, var2x - 1))));
            var1.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.empty(), Optional.empty(), var2, Optional.empty()));
         }

         if (!this.I_field_95707c72.isEmpty()) {
            Builder var3 = new Builder(ItemEnchantmentsComponent.DEFAULT);
            this.I_field_95707c72.forEach(var3::set);
            var1.set(var1.isOf(Items.ENCHANTED_BOOK) ? DataComponentTypes.STORED_ENCHANTMENTS : DataComponentTypes.ENCHANTMENTS, var3.build());
         }

         IiiIIiIi_Class102.I_method_5e18ace8(
            var1,
            this.I_field_4a,
            this.I_field_765e3dbc.I_method_d1d7d0f9(),
            this.I_field_765e3dbc.i_method_64f68119(),
            this.i_field_5a ? IiiIIiIi_Class102.Nested1_6cef9113.i_field_af10c1bc : IiiIIiIi_Class102.Nested1_6cef9113.I_field_af10c1bc,
            this.I_field_44,
            this.II_field_5a,
            this.i_field_4a,
            this.I_field_49,
            this.i_field_49
         );
         this.I_field_765e3dbc = null;
      }
   }

   private boolean I_method_6537b0f0() {
      return this.I_field_765e3dbc != null && this.I_field_765e3dbc.I_method_c2b2cc91().getItem() instanceof PotionItem;
   }

   private boolean i_method_65463cd0() {
      if (this.I_field_765e3dbc == null) {
         return false;
      } else {
         ItemStack var1 = this.I_field_765e3dbc.I_method_c2b2cc91();
         return var1.isDamageable() || var1.isOf(Items.ENCHANTED_BOOK) || var1.isOf(Items.BOOK);
      }
   }

   private static String I_method_93f06e1f(RegistryEntry<Enchantment> var0) {
      return ((Enchantment)var0.value()).description().getString();
   }

   private List<RegistryEntry<Enchantment>> i_method_d6bce3fb() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.world == null) {
         return List.of();
      } else {
         ArrayList var2 = new ArrayList();
         var1.world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT).streamEntries().forEach(var2::add);
         return var2;
      }
   }

   private iii_Class8 ii_method_efe3cab() {
      iii_Class8 var1 = new iii_Class8()
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(190.0F)
         .IiI_method_31d4c97(190.0F)
         .iI_method_e886414(9.0F)
         .I_method_70a38517(7.0F)
         .I_method_7e2bb176(IIII.I_method_14640aa3(9.0F))
         .iI_method_7009d1d8((this.width - 190) / 2.0F, (this.height - 190) / 2.0F)
         .I_method_879bc687(() -> this.Ii_field_5a)
         .I_method_f136b1d8(
            (var0, var1x) -> {
               var0.drawShadow(
                  var1x.x(), var1x.y(), var1x.w(), var1x.h(), 25.0F, IIiii_Class8.I_method_893b2757(9.0F), IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.2F)
               );
               var0.drawBlurredRect(
                  var1x.x(), var1x.y(), var1x.w(), var1x.h(), 5.0F, 3.0F, IIiii_Class8.I_method_893b2757(9.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5
               );
               var0.drawClientRect(var1x.x(), var1x.y(), var1x.w(), var1x.h(), 1.0F, 0.0F, 3.0F, 9.0F, true);
            }
         );
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .III_method_9dc17555()
         .IiI_method_31d4c97(12.0F);
      var2.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F),
               () -> this.I_method_6537b0f0() ? "\u042d\u0444\u0444\u0435\u043a\u0442" : "\u0417\u0430\u0447\u0430\u0440\u043e\u0432\u0430\u043d\u0438\u0435",
               var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5
            )
      );
      var2.I_method_8939bffd(
         new Iii_Class4()
            .size(11.0F, 11.0F)
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
            .onClick(() -> this.Ii_field_5a = false)
            .paint((var0, var1x) -> I_method_7240ad53(var0, var1x, 3.0F, 1.3F, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.45F + 0.4F * var1x.hover())))
      );
      var1.I_method_8939bffd(var2);
      var1.I_method_8939bffd(
         new IIiII_Class5(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), "", var1x -> this.II_field_523beb0a = var1x)
            .i_method_459bf75f("\u041f\u043e\u0438\u0441\u043a\u2026")
            .i_method_e2c562d5()
            .Ii_method_3f6d8e94(15.0F)
            .I_method_49a8a757(4.0F)
            .I_method_e5f33669(var0 -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.07F))
            .i_method_73cabf77(5.0F)
            .i_method_8326c8f6(IiiiiIIIi_Class242.iII_field_d0c8ec5)
      );
      this.IIi_field_b584628c = this.I_method_3e5f4b8a(131.0F);
      var1.I_method_8939bffd(this.IIi_field_b584628c);
      return var1;
   }

   private Iii_Class4 I_method_e2d7ff77(RegistryEntry<Enchantment> var1) {
      Iii_Class4 var2 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
            I_method_93f06e1f(var1),
            var2x -> this.I_field_95707c72.containsKey(var1) ? IiiiiIIIi_Class242.ii_field_d0c8ec5 : IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.85F)
         )
         .fillWidth()
         .height(14.0F)
         .radius(4.0F)
         .textInset(4.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      var2.background(var0 -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.05F * var0.hover()));
      var2.onClick(() -> {
         this.I_field_95707c72.putIfAbsent(var1, 1);
         this.Ii_field_5a = false;
      });
      return var2;
   }

   private iii_Class8 I_method_e2e68b57(RegistryEntry<Enchantment> var1) {
      int var2 = Math.max(1, ((Enchantment)var1.value()).getMaxLevel());
      iii_Class8 var3 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .III_method_9dc17555()
         .IiI_method_31d4c97(13.0F);
      var3.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), I_method_93f06e1f(var1), var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.85F)
            )
            .fillWidth()
            .height(9.0F)
            .fade()
      );
      iii_Class8 var4 = new iii_Class8().i_method_c88da8d5().I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_70a38517(5.0F);
      var4.I_method_8939bffd(
         new iiii_Class16(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
               () -> this.I_field_95707c72.getOrDefault(var1, 1).intValue(),
               var3x -> this.I_field_95707c72.put(var1, Math.max(1, Math.min(var2, (int)var3x))),
               1.0F,
               var2
            )
            .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
      );
      var4.I_method_8939bffd(
         new Iii_Class4()
            .size(9.0F, 11.0F)
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
            .onClick(() -> this.I_field_95707c72.remove(var1))
            .paint((var0, var1x) -> I_method_7240ad53(var0, var1x, 2.6F, 1.2F, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.4F + 0.4F * var1x.hover())))
      );
      var3.I_method_8939bffd(var4);
      return var3;
   }

   private List<RegistryEntry<StatusEffect>> II_method_d47f65b2() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.world == null) {
         return List.of();
      } else {
         ArrayList var2 = new ArrayList();
         var1.world.getRegistryManager().getOrThrow(RegistryKeys.STATUS_EFFECT).streamEntries().forEach(var2::add);
         return var2;
      }
   }

   private static String i_method_4bdf6e3f(RegistryEntry<StatusEffect> var0) {
      return ((StatusEffect)var0.value()).getName().getString();
   }

   private Iii_Class4 i_method_70978b57(RegistryEntry<StatusEffect> var1) {
      Iii_Class4 var2 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
            i_method_4bdf6e3f(var1),
            var2x -> this.i_field_95707c72.containsKey(var1) ? IiiiiIIIi_Class242.ii_field_d0c8ec5 : IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.85F)
         )
         .fillWidth()
         .height(14.0F)
         .radius(4.0F)
         .textInset(4.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      var2.background(var0 -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.05F * var0.hover()));
      var2.onClick(() -> {
         this.i_field_95707c72.putIfAbsent(var1, 1);
         this.Ii_field_5a = false;
      });
      return var2;
   }

   private iii_Class8 i_method_70a61737(RegistryEntry<StatusEffect> var1) {
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .III_method_9dc17555()
         .IiI_method_31d4c97(13.0F);
      var2.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), i_method_4bdf6e3f(var1), var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.85F)
            )
            .fillWidth()
            .height(9.0F)
            .fade()
      );
      iii_Class8 var3 = new iii_Class8().i_method_c88da8d5().I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_70a38517(5.0F);
      var3.I_method_8939bffd(
         new iiii_Class16(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
               () -> this.i_field_95707c72.getOrDefault(var1, 1).intValue(),
               var2x -> this.i_field_95707c72.put(var1, Math.max(1, Math.min(255, (int)var2x))),
               1.0F,
               255.0F
            )
            .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
      );
      var3.I_method_8939bffd(
         new Iii_Class4()
            .size(9.0F, 11.0F)
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
            .onClick(() -> this.i_field_95707c72.remove(var1))
            .paint((var0, var1x) -> I_method_7240ad53(var0, var1x, 2.6F, 1.2F, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.4F + 0.4F * var1x.hover())))
      );
      var2.I_method_8939bffd(var3);
      return var2;
   }

   private iii_Class8 III_method_877e7d42() {
      iii_Class8 var1 = this.I_method_1cbb3f54(300.0F, "\u0410\u043a\u0442\u0438\u0432\u043d\u043e\u0441\u0442\u044c");
      this.Ii_field_b584628c = this.I_method_3e5f4b8a(193.0F);
      var1.I_method_8939bffd(this.Ii_field_b584628c);
      return var1;
   }

   private iii_Class8 I_method_ff093eeb(AutoBuyModule.Nested1_ea60dca0 var1) {
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .III_method_9dc17555()
         .IiI_method_31d4c97(24.0F)
         .I_method_7e2bb176(IIII.i_method_4f8e6e83(1.0F));
      var2.I_method_8939bffd(
         new Iii_Class4()
            .size(17.0F, 17.0F)
            .paint(
               (var1x, var2x) -> I_method_205a7fa4(
                  var1x, var1.I_method_5020f0de(), var2x.x() + var2x.w() / 2.0F - 6.8F, var2x.y() + var2x.h() / 2.0F - 6.8F, 0.85F
               )
            )
      );
      var2.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
               var1.I_method_188840c6() + (var1.I_method_f7a0b0d() > 1 ? " x" + var1.I_method_f7a0b0d() : ""),
               IiiiiIIIi_Class242.iII_field_d0c8ec5
            )
            .fillWidth()
            .height(9.0F)
            .fade()
      );
      var2.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F),
               "-" + iIIiiiiiI_Class319.I_method_10212adb(var1.I_method_f7a0b0e()),
               var0 -> new ColorRGBA(255.0F, 105.0F, 105.0F)
            )
            .textAlign(IIi_Class2.II_field_b5755e8c)
            .width(58.0F)
            .height(9.0F)
      );
      return var2;
   }

   private iii_Class8 IIi_method_7b05922() {
      iii_Class8 var1 = this.I_method_1cbb3f54(264.0F, "\u0410\u043d\u0430\u0440\u0445\u0438\u0438 \u0438 \u0442\u0430\u0439\u043c\u0438\u043d\u0433\u0438");
      iii_Class8 var2 = this.I_method_3e5f4b8a(193.0F).I_method_70a38517(8.0F);
      var2.I_method_8939bffd(
         this.I_method_15843366(
            "\u0410\u0432\u0442\u043e\u043f\u0440\u043e\u0434\u0430\u0436\u0430 \u043a\u0443\u043f\u043b\u0435\u043d\u043d\u043e\u0433\u043e",
            new IIiiI_Class7(IiiIIiII_Class101::I_method_c495e4b0)
               .size(15.0F, 9.0F)
               .onClick(() -> IiiIIiII_Class101.I_method_ce2763a8(!IiiIIiII_Class101.I_method_c495e4b0()))
         )
      );
      var2.I_method_8939bffd(
         this.I_method_15843366(
            "\u0410\u0432\u0442\u043e\u043f\u0430\u0440\u0441 \u0446\u0435\u043d",
            new IIiiI_Class7(IiiIIiII_Class101::i_method_c4a47090)
               .size(15.0F, 9.0F)
               .onClick(() -> IiiIIiII_Class101.i_method_cfea53c8(!IiiIIiII_Class101.i_method_c4a47090()))
         )
      );
      iii_Class8 var3 = this.I_method_15843366(
         "\u041f\u0435\u0440\u0438\u043e\u0434 \u043f\u0430\u0440\u0441\u0430",
         new iiii_Class16(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
               () -> (float)IiiIIiII_Class101.II_method_ce35a829() / 60000.0F,
               var0 -> IiiIIiII_Class101.II_method_f87fd52f((long)(var0 * 60000.0F)),
               1.0F,
               120.0F
            )
            .i_method_6f9c9a5(() -> " \u043c\u0438\u043d")
            .i_method_5040b524(IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F))
            .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
      );
      var3.I_method_879bc687(IiiIIiII_Class101::i_method_c4a47090);
      var2.I_method_8939bffd(var3);
      Iii_Class4 var4 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
            IiiIIIiI_Class99::I_method_9ad4b934,
            var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F)
         )
         .fillWidth()
         .height(9.0F)
         .fade();
      var4.visibleWhen(IiiIIiII_Class101::i_method_c4a47090);
      var2.I_method_8939bffd(var4);
      var2.I_method_8939bffd(this.I_method_e3956042());
      this.iI_field_b584628c = new iii_Class8().i_method_c88da8d5().II_method_3b06fa38().I_method_70a38517(4.0F).III_method_9dc17555();
      var2.I_method_8939bffd(this.iI_field_b584628c);
      IIiIIi_Class10 var5 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F);
      float var6 = Math.max(0.0F, 9.0F - (19.0F - var5.I_method_a649725c()) / 2.0F);
      iii_Class8 var7 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(6.0F)
         .III_method_9dc17555()
         .IiI_method_31d4c97(19.0F);
      var7.I_method_8939bffd(
         new IIiII_Class5(var5, "", var1x -> this.i_field_523beb0a = var1x)
            .i_method_459bf75f("\u043d\u0430\u043f\u0440. 208")
            .I_method_9d6eab6b(true)
            .I_method_d6398e5a(4)
            .i_method_e2c562d5()
            .Ii_method_3f6d8e94(19.0F)
            .I_method_49a8a757(6.0F)
            .I_method_e5f33669(var0 -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.07F))
            .i_method_73cabf77(var6)
            .i_method_8326c8f6(IiiiiIIIi_Class242.iII_field_d0c8ec5)
      );
      var7.I_method_8939bffd(
         new Iii_Class4()
            .text(
               IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F),
               "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c",
               IiiiiIIIi_Class242.iIi_field_d0c8ec5
            )
            .textAlign(IIi_Class2.i_field_b5755e8c)
            .height(19.0F)
            .padding(IIII.i_method_4f8e6e83(12.0F))
            .radius(6.0F)
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
            .background(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(var0.hovered() ? 1.0F : 0.85F))
            .onClick(this::i_method_65463ccc)
      );
      var2.I_method_8939bffd(var7);
      var2.I_method_8939bffd(this.I_method_e3956042());
      var2.I_method_8939bffd(
         this.I_method_15843366(
            "\u041f\u0435\u0440\u0438\u043e\u0434 \u0441\u043c\u0435\u043d\u044b",
            new iiii_Class16(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
                  () -> (float)IiiIIiII_Class101.I_method_c495e4a0() / 60000.0F,
                  var0 -> IiiIIiII_Class101.I_method_ce272798((long)(var0 * 60000.0F)),
                  1.0F,
                  60.0F
               )
               .i_method_6f9c9a5(() -> " \u043c\u0438\u043d")
               .i_method_5040b524(IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F))
               .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
         )
      );
      var2.I_method_8939bffd(
         this.I_method_15843366(
            "\u041f\u0430\u0443\u0437\u0430 \u043f\u0440\u043e\u0433\u0440\u0443\u0437\u043a\u0438",
            new iiii_Class16(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
                  () -> (float)IiiIIiII_Class101.i_method_c4a47080() / 1000.0F,
                  var0 -> IiiIIiII_Class101.i_method_cfea17b8((long)(var0 * 1000.0F)),
                  1.0F,
                  60.0F
               )
               .i_method_6f9c9a5(() -> " \u0441")
               .i_method_5040b524(IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.5F))
               .I_method_b29dd144(IiiiiIIIi_Class242.iII_field_d0c8ec5)
         )
      );
      var1.I_method_8939bffd(var2);
      return var1;
   }

   private static String I_method_9ad4b934() {
      AutoBuyModule var0 = RockstarClient.getInstance().getModuleManager().getModule(AutoBuyModule.class);
      if (var0 == null || !var0.isEnabled()) {
         return "\u0421\u0440\u0430\u0431\u043e\u0442\u0430\u0435\u0442 \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u0440\u0438 \u0432\u043a\u043b\u044e\u0447\u0451\u043d\u043d\u043e\u0439 \u0430\u0432\u0442\u043e\u0437\u0430\u043a\u0443\u043f\u043a\u0435.";
      } else if (IiiIiIII_Class105.I_method_f24c7cb().I_method_50fe28f0()) {
         return "\u041f\u0430\u0440\u0441\u0438\u043d\u0433 \u0438\u0434\u0451\u0442\u2026";
      } else if (IiiIIiIi_Class102.I_method_2a0b303b().isEmpty()) {
         return "\u0421\u043f\u0438\u0441\u043e\u043a \u0437\u0430\u043a\u0443\u043f\u043a\u0438 \u043f\u0443\u0441\u0442 \u2014 \u043f\u0430\u0440\u0441\u0438\u0442\u044c \u043d\u0435\u0447\u0435\u0433\u043e.";
      } else {
         long var1 = IiiIiIII_Class105.I_method_f24c7cb().I_method_50fe28e0() / 1000L;
         return "\u0421\u043b\u0435\u0434\u0443\u044e\u0449\u0438\u0439 \u043f\u0430\u0440\u0441 \u0447\u0435\u0440\u0435\u0437 "
            + var1 / 60L
            + ":"
            + String.format("%02d", var1 % 60L);
      }
   }

   private void i_method_65463ccc() {
      try {
         IiiIIiII_Class101.I_method_ce2723d7(Integer.parseInt(this.i_field_523beb0a.trim()));
      } catch (NumberFormatException var2) {
      }
   }

   private iii_Class8 I_method_1cf4174d(int var1) {
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(3.0F)
         .IiI_method_31d4c97(19.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 7.0F, 0.0F, 9.0F))
         .iI_method_e886414(6.0F)
         .I_method_e53800a9(var0 -> IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(0.07F));
      var2.I_method_8939bffd(new Iii_Class4().text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), "an" + var1, IiiiiIIIi_Class242.iII_field_d0c8ec5));
      var2.I_method_8939bffd(
         new Iii_Class4()
            .size(9.0F, 11.0F)
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
            .onClick(() -> IiiIIiII_Class101.i_method_cfea13f7(var1))
            .paint((var0, var1x) -> I_method_7240ad53(var0, var1x, 2.8F, 1.3F, IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.4F + 0.45F * var1x.hover())))
      );
      return var2;
   }

   private static void I_method_205a7fa4(III var0, ItemStack var1, float var2, float var3, float var4) {
      float var5 = RenderSystem.getShaderColor()[3];
      if (var5 >= 0.999F) {
         var0.drawItem(var1, var2, var3, var4);
      } else {
         iIiiIiIiI_Class363.I_method_5e6be269(var0, var1, var2, var3, var4, var5);
      }
   }

   private static void I_method_7240ad53(III var0, Iii_Class4 var1, float var2, float var3, ColorRGBA var4) {
      MatrixStack var5 = var0.getMatrices();
      var5.push();
      var5.translate(var1.x() + var1.w() / 2.0F, var1.y() + var1.h() / 2.0F, 0.0F);
      var5.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45.0F));
      var0.drawRect(-var2, -var3 / 2.0F, var2 * 2.0F, var3, var4);
      var0.drawRect(-var3 / 2.0F, -var2, var3, var2 * 2.0F, var4);
      var5.pop();
   }

   private void II_method_41cd63f5() {
      if (this.I_field_7a2a121c != this.i_field_7a2a121c) {
         this.i_field_7a2a121c = this.I_field_7a2a121c;
         this.I_field_b584628c.II_method_244860a9(this.I_method_ad4cb9bf(this.I_field_7a2a121c));
         this.Ii_field_523beb0a = this.iI_field_523beb0a = this.ii_field_523beb0a = this.III_field_523beb0a = this.IIi_field_523beb0a = this.IiI_field_523beb0a = "";
      }

      if (this.i_field_b584628c != null) {
         String var1 = this.I_field_765e39dc.name() + "|" + this.I_field_523beb0a;
         if (!var1.equals(this.Ii_field_523beb0a)) {
            this.Ii_field_523beb0a = var1;
            this.i_field_b584628c.II_method_244860a9(this.I_method_2170abdb());
         }
      }

      if (this.II_field_b584628c != null) {
         List var6 = IiiIIiIi_Class102.I_method_2a0b303b();
         String var2 = (String)var6.stream().map(value -> ((IiiIIiIi_Class102.Nested1_6cef9133)value).i_method_29f1a539()).reduce("", (var0, var1x) -> var0 + "," + var1x);
         if (!var2.equals(this.iI_field_523beb0a)) {
            this.iI_field_523beb0a = var2;
            ArrayList var3 = new ArrayList();
            if (var6.isEmpty()) {
               var3.add(
                  this.I_method_13335e0c(
                     "\u041f\u0443\u0441\u0442\u043e. \u0412\u044b\u0431\u0435\u0440\u0438 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u2192"
                  )
               );
            } else {
               for (IiiIIiIi_Class102.Nested1_6cef9133 var5 : (Iterable<IiiIIiIi_Class102.Nested1_6cef9133>)(Iterable<?>)var6) {
                  var3.add(this.I_method_c0b4003e(var5));
               }
            }

            this.II_field_b584628c.II_method_244860a9(var3);
         }
      }

      if (this.Ii_field_b584628c != null) {
         List var7 = Ii_method_89cb9dd2();
         String var12 = var7.size() + "|" + (var7.isEmpty() ? "" : ((AutoBuyModule.Nested1_ea60dca0)var7.get(var7.size() - 1)).I_method_188840c6());
         if (!var12.equals(this.ii_field_523beb0a)) {
            this.ii_field_523beb0a = var12;
            ArrayList var17 = new ArrayList();
            if (var7.isEmpty()) {
               var17.add(this.I_method_13335e0c("\u041f\u043e\u043a\u0443\u043f\u043e\u043a \u043f\u043e\u043a\u0430 \u043d\u0435\u0442."));
            } else {
               for (int var22 = var7.size() - 1; var22 >= 0; var22--) {
                  var17.add(this.I_method_ff093eeb((AutoBuyModule.Nested1_ea60dca0)var7.get(var22)));
               }
            }

            this.Ii_field_b584628c.II_method_244860a9(var17);
         }
      }

      if (this.iI_field_b584628c != null) {
         List var8 = IiiIIiII_Class101.I_method_96ec801b();
         String var13 = var8.toString();
         if (!var13.equals(this.III_field_523beb0a)) {
            this.III_field_523beb0a = var13;
            ArrayList var18 = new ArrayList();

            for (int var28 : (Iterable<Integer>)(Iterable<?>)var8) {
               var18.add(this.I_method_1cf4174d(var28));
            }

            this.iI_field_b584628c.II_method_244860a9(var18);
         }
      }

      if (this.ii_field_b584628c != null) {
         String var9 = this.I_field_95707c72.keySet().toString();
         if (!var9.equals(this.IIi_field_523beb0a)) {
            this.IIi_field_523beb0a = var9;
            ArrayList var14 = new ArrayList();

            for (RegistryEntry var24 : this.I_field_95707c72.keySet()) {
               var14.add(this.I_method_e2e68b57(var24));
            }

            this.ii_field_b584628c.II_method_244860a9(var14);
         }
      }

      if (this.III_field_b584628c != null) {
         String var10 = this.i_field_95707c72.keySet().toString();
         if (!var10.equals(this.IiI_field_523beb0a)) {
            this.IiI_field_523beb0a = var10;
            ArrayList var15 = new ArrayList();

            for (RegistryEntry var25 : this.i_field_95707c72.keySet()) {
               var15.add(this.i_method_70a61737(var25));
            }

            this.III_field_b584628c.II_method_244860a9(var15);
         }
      }

      if (this.IIi_field_b584628c != null) {
         String var11 = this.Ii_field_5a + "|" + this.I_method_6537b0f0() + "|" + this.II_field_523beb0a;
         if (!var11.equals(this.Iii_field_523beb0a)) {
            this.Iii_field_523beb0a = var11;
            ArrayList var16 = new ArrayList();
            if (this.Ii_field_5a) {
               String var21 = this.II_field_523beb0a.trim().toLowerCase();
               if (this.I_method_6537b0f0()) {
                  for (RegistryEntry var30 : this.II_method_d47f65b2()) {
                     if (var21.isEmpty() || i_method_4bdf6e3f(var30).toLowerCase().contains(var21)) {
                        var16.add(this.i_method_70978b57(var30));
                     }
                  }
               } else {
                  for (RegistryEntry var29 : this.i_method_d6bce3fb()) {
                     if (var21.isEmpty() || I_method_93f06e1f(var29).toLowerCase().contains(var21)) {
                        var16.add(this.I_method_e2d7ff77(var29));
                     }
                  }
               }
            }

            this.IIi_field_b584628c.II_method_244860a9(var16);
         }
      }
   }

   private Iii_Class4 I_method_e3956042() {
      return new Iii_Class4()
         .fillWidth()
         .height(1.0F)
         .paint((var0, var1) -> var0.drawRect(var1.x() - 11.0F, var1.y(), var1.w() + 22.0F, 1.0F, IiiiiIIIi_Class242.IiI_field_d0c8ec5));
   }

   private Iii_Class4 I_method_13335e0c(String var1) {
      return new Iii_Class4()
         .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var1, var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.4F))
         .textAlign(IIi_Class2.i_field_b5755e8c)
         .fillWidth()
         .height(40.0F);
   }

   private boolean I_method_5abddb2c(IiiiIIii_Class116.Nested1_8029513 var1) {
      return this.I_field_765e3dbc != null && this.I_field_765e3dbc.i_method_64f68119().equals(var1.i_method_64f68119());
   }

   private boolean i_method_60c5d70c(IiiiIIii_Class116.Nested1_8029513 var1) {
      for (IiiIIiIi_Class102.Nested1_6cef9133 var3 : IiiIIiIi_Class102.I_method_2a0b303b()) {
         if (var3.i_method_29f1a539().equals(var1.i_method_64f68119())) {
            return true;
         }
      }

      return false;
   }

   private static String I_method_a358ce78(IiiiIIii_Class116.Nested1_8029513 var0) {
      return var0.I_method_d1d7d0f9() != null ? var0.I_method_d1d7d0f9() : var0.I_method_c2b2cc91().getName().getString();
   }

   private static String I_method_7f0e7a98(IiiIIiIi_Class102.Nested1_6cef9133 var0) {
      return var0.I_method_96d2f519() != null ? var0.I_method_96d2f519() : var0.I_method_2478c0b1().getName().getString();
   }

   private static String i_method_7041bab8(IiiIIiIi_Class102.Nested1_6cef9133 var0) {
      String var1 = var0.I_method_b49c50b() == IiiIIiIi_Class102.Nested1_6cef9113.i_field_af10c1bc
         ? "-" + (int)var0.I_method_18d43a55() + "% \u0440\u044b\u043d\u043a\u0430"
         : "\u0434\u043e " + iIIiiiiiI_Class319.I_method_10212adb(var0.I_method_18d43a5b());
      long var2 = (long)IiiIiIII_Class105.I_method_f24c7cb().I_method_89b6fa4(var0.i_method_29f1a539());
      return var2 > 0L ? var1 + " \u00b7 \u0440\u044b\u043d\u043e\u043a " + iIIiiiiiI_Class319.I_method_10212adb(var2) : var1;
   }

   private static String I_method_1f8f6f77(IIiIIi_Class10 var0, String var1, float var2) {
      if (var0.I_method_2c375926(var1) <= var2) {
         return var1;
      } else {
         while (var1.length() > 1 && var0.I_method_2c375926(var1 + "\u2026") > var2) {
            var1 = var1.substring(0, var1.length() - 1);
         }

         return var1 + "\u2026";
      }
   }

   private static List<AutoBuyModule.Nested1_ea60dca0> Ii_method_89cb9dd2() {
      AutoBuyModule var0 = RockstarClient.getInstance().getModuleManager().getModule(AutoBuyModule.class);
      return var0 == null ? List.of() : var0.I_method_96b5a68();
   }

   public void tick() {
      GuiMoveModule.iII_method_9983ebf();
      super.tick();
   }

   public boolean shouldCloseOnEsc() {
      return true;
   }

   public void close() {
      super.close();
      MinecraftClient.getInstance().setScreen(RockstarClient.getInstance().I_method_96982062());
   }

   static enum Nested1_6b3ab4b3 {
      I_field_7a2a121c,
      i_field_7a2a121c,
      II_field_7a2a121c;
   }
}
