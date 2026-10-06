package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import moscow.rockstar.mixin.accessors.DrawContextAccessor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

public class IiiIiIiII_Class213 extends IiiIIiiiI_Class207 {
   private static final IIii_Class4 I_field_f93678c1 = IIii_Class4.I_method_3682ece9(160L, IiiiIiiII_Class237.IIII_field_dd60aac);
   private static final float I_field_46 = 22.0F;
   private static final float i_field_46 = 14.0F;
   private static final float II_field_46 = 4.0F;
   private static final float Ii_field_46 = 50.0F;
   private static final float iI_field_46 = 4.0F;
   private static final float ii_field_46 = 11.0F;
   private static final float III_field_46 = 10.5F;
   private static final float IIi_field_46 = 118.0F;
   private static final float IiI_field_46 = 15.0F;
   private static final float Iii_field_46 = 5.0F;
   private static final float iII_field_46 = 12.0F;
   private static final float iIi_field_46 = 4.0F;
   private static final float iiI_field_46 = 3.5F;
   private static final float iii_field_46 = 7.5F;
   private static final int I_field_49 = 12;
   private static final int i_field_49 = 7;
   private static final float IIII_field_46 = 0.8F;
   private static final float IIIi_field_46 = 1.2F;
   private static final int II_field_49 = 9;
   private static final float IIiI_field_46 = 18.0F;
   private static final float IIii_field_46 = 2.0F;
   private static final float IiII_field_46 = 20.0F;
   private static final float IiIi_field_46 = 6.0F;
   private static final float IiiI_field_46 = 178.0F;
   private static final float Iiii_field_46 = 24.0F;
   private static final float iIII_field_46 = 88.0F;
   private static final float iIIi_field_46 = 106.0F;
   private float iIiI_field_46;
   private float iIii_field_46;
   private float iiII_field_46;
   private float iiIi_field_46;
   private float iiiI_field_46;
   InventoryBuilderModule.Nested1_210a0440 I_field_43ee5a47;
   InventoryBuilderModule.Nested1_210a0420 I_field_43ee5667;
   int Ii_field_49 = -1;
   int iI_field_49 = -1;
   private String I_field_523beb0a = "";
   private iii_Class8 I_field_b584628c;
   private iii_Class8 i_field_b584628c;
   private iii_Class8 II_field_b584628c;
   private IIiII_Class5 I_field_2d98292c;
   private iii_Class8 Ii_field_b584628c;
   private IiiIiIiII_Class213.Nested1_98e3d080 I_field_c74e1607;
   private final Map<InventoryBuilderModule.Nested1_210a0440, iii_Class8> I_field_a567c40b = new IdentityHashMap<>();
   private List<InventoryBuilderModule.Nested1_210a0440> I_field_7865b31 = List.of();
   private final List<Runnable> i_field_7865b31 = new ArrayList<>();
   private final List<IiIIiiIii_Class156> II_field_7865b31 = new ArrayList<>();
   private InventoryBuilderModule.Nested1_210a0420 i_field_43ee5667;
   private InventoryBuilderModule.Nested1_210a0420 II_field_43ee5667;
   private iii_Class8 iI_field_b584628c;
   private iii_Class8 ii_field_b584628c;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private List<InventoryBuilderModule.Nested1_210a0420> Ii_field_7865b31;
   private List<String> iI_field_7865b31;
   private String i_field_523beb0a;
   private List<InventoryBuilderModule.Nested1_210a0420> ii_field_7865b31 = new ArrayList<>();
   private final Map<InventoryBuilderModule.Nested1_210a0420, ItemStack> i_field_a567c40b = new IdentityHashMap<>();

   public IiiIiIiII_Class213() {
      InventoryBuilderModule.Iii_method_1629dabf();
      if (!InventoryBuilderModule.I_method_c735da08().isEmpty()) {
         this.I_field_43ee5a47 = InventoryBuilderModule.I_method_c735da08().getFirst();
      }
   }

   @Override
   protected boolean lowDrawBatching() {
      return true;
   }

   @Compile(
      obfuscation = 4
   )
   @Override
   public void init() {
      super.init();
      this.clearRoots();
      this.overlays.clear();
      this.iiiI_field_46 = 200.0F;
      this.iIiI_field_46 = 118.0F + this.iiiI_field_46;
      this.iIii_field_46 = 149.0F;
      this.iiII_field_46 = Math.round((this.width - this.iIiI_field_46) / 2.0F);
      this.iiIi_field_46 = Math.round((this.height - this.iIii_field_46) / 2.0F);
      this.II_field_b584628c = (new iii_Class8() {
            @Override
            protected void drawChildren(III var1, float var2) {
               iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), this.x(), this.y(), this.w(), this.h());
               super.drawChildren(var1, var2);
               iIiiiIiII_Class373.I_method_ff80a1df();
            }
         })
         .i_method_c88da8d5()
         .I_method_84672d76(IIii_Class4.II_field_f93678c1)
         .i_method_8c7d3515(this.iIiI_field_46, this.iIii_field_46)
         .I_method_f136b1d8((var1, var2) -> this.I_method_d4e03adf(var1, var2));
      this.II_field_b584628c.iii_method_df275535();
      this.II_field_b584628c.snapSize();
      this.II_field_b584628c.snapAt(this.iiII_field_46, this.iiIi_field_46);
      this.II_field_b584628c.I_method_8939bffd(this.I_method_5f2bd9b5());
      this.II_field_b584628c.I_method_8939bffd(this.i_method_df5db595());
      this.add(this.II_field_b584628c);
      this.I_field_7865b31 = List.of();
      this.I_method_faab8cb5(true);
      this.i_method_f7a071df();
   }

   private float I_method_f791e5ef() {
      return this.II_field_b584628c == null ? this.iiII_field_46 : this.II_field_b584628c.x();
   }

   private float i_method_f7a071cf() {
      return this.II_field_b584628c == null ? this.iiIi_field_46 : this.II_field_b584628c.y();
   }

   private void I_method_d4e03adf(III var1, iii_Class8 var2) {
      float var3 = var2.x();
      float var4 = var2.y();
      float var5 = var2.w();
      float var6 = var2.h();
      ColorRGBA var7 = this.iI_method_a4621fd1();
      var1.drawClientRect(var3, var4, var5, var6, 1.0F, 0.0F, 2.0F, 12.0F, false, true);
      float var8 = var3 + 118.0F - 1.0F;
      var1.drawRect(var8, var4 + 1.0F, 1.0F, var6 - 2.0F, var7);
      var1.drawRect(var3 + 1.0F, var4 + 22.0F - 1.0F, 116.0F, 1.0F, var7);
      var1.drawRect(var8 + 1.0F, var4 + 22.0F - 1.0F, var5 - 118.0F - 1.0F, 1.0F, var7);
      var1.drawRoundedBorder(var3, var4, var5, var6, 0.5F, IIiii_Class8.I_method_893b2757(12.0F), var7);
   }

   private iii_Class8 I_method_5f2bd9b5() {
      Iii_Class4 var1 = new Iii_Class4()
         .height(22.0F)
         .fillWidth()
         .padding(IIII.I_method_b1e865cb(0.0F, 7.5F))
         .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), "\u041f\u0440\u0435\u0441\u0435\u0442\u044b", var1x -> this.I_method_8f35906e())
         .draggable(iIi_Class6.i_field_b583ea6c);
      float var2 = 23.0F;
      this.I_field_b584628c = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(2.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(4.0F, 5.0F, 0.0F, 4.0F))
         .IIi_method_4dfc88d7(118.0F)
         .IiI_method_31d4c97(Math.max(0.0F, this.iIii_field_46 - 22.0F - var2))
         .Ii_method_bb38d618()
         .I_method_3987f136(IiIi_Class6.I_field_f9448c81)
         .I_method_b65baecb(this::I_method_3bab58e0);
      iii_Class8 var3 = new iii_Class8()
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(118.0F)
         .IiI_method_31d4c97(var2)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 4.0F, 4.0F, 4.0F))
         .I_method_8939bffd(
            new Iii_Class4()
               .height(15.0F)
               .fillWidth()
               .radius(3.0F)
               .text(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
                  "\u041d\u043e\u0432\u044b\u0439 \u043f\u0440\u0435\u0441\u0435\u0442",
                  var1x -> this.I_method_8f35906e().mix(IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.6F).mulAlpha(0.75F + 0.25F * var1x.hover())
               )
               .textAlign(IIi_Class2.i_field_b5755e8c)
               .background(var1x -> I_method_452f57f0(this.Ii_method_b74ebb91(), IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.05F + 0.045F * var1x.hover()))
               .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
               .onClick(this::I_method_f791e5ff)
         );
      return new iii_Class8()
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(118.0F)
         .IiI_method_31d4c97(this.iIii_field_46)
         .I_method_8939bffd(var1)
         .I_method_8939bffd(this.I_field_b584628c)
         .I_method_8939bffd(var3);
   }

   private iii_Class8 i_method_df5db595() {
      IIiII_Class5 var1 = this.I_field_2d98292c = new IIiII_Class5(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), this.I_field_43ee5a47 == null ? "" : this.I_field_43ee5a47.I_field_523beb0a, var1x -> {
               if (this.I_field_43ee5a47 != null) {
                  this.I_field_43ee5a47.I_field_523beb0a = var1x.isBlank() ? "\u041f\u0440\u0435\u0441\u0435\u0442" : var1x;
                  InventoryBuilderModule.Iii_method_1629dac3();
               }
            }
         )
         .i_method_459bf75f("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435")
         .II_method_154b7674(this.iiiI_field_46 - 8.0F - 50.0F - 4.0F)
         .Ii_method_3f6d8e94(14.0F);
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(4.0F)
         .I_method_8939bffd(this.I_method_2590246a("plus", IiiiiIIIi_Class242.ii_field_d0c8ec5, () -> {
            if (this.I_field_43ee5a47 != null) {
               this.II_method_fab9d142();
            }
         }))
         .I_method_8939bffd(this.I_method_2590246a("play", new ColorRGBA(96.0F, 208.0F, 118.0F), () -> {
            InventoryBuilderModule var1x = this.I_method_fb2d5315();
            if (var1x != null && this.I_field_43ee5a47 != null) {
               this.close();
               var1x.I_method_3f7a1202(this.I_field_43ee5a47);
            }
         }).visibleWhen(() -> !this.I_method_f791e603()))
         .I_method_8939bffd(this.I_method_2590246a("xmark", new ColorRGBA(228.0F, 92.0F, 92.0F), () -> {
            InventoryBuilderModule var1x = this.I_method_fb2d5315();
            if (var1x != null) {
               var1x.I_method_419b7e69("\u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e \u0432\u0440\u0443\u0447\u043d\u0443\u044e");
            }
         }).visibleWhen(this::I_method_f791e603))
         .I_method_8939bffd(this.I_method_2590246a("trash", new ColorRGBA(228.0F, 92.0F, 92.0F), () -> {
            if (this.I_field_43ee5a47 != null) {
               this.I_field_a567c40b.remove(this.I_field_43ee5a47);
               InventoryBuilderModule.I_method_c735da08().remove(this.I_field_43ee5a47);
               this.I_field_43ee5a47 = InventoryBuilderModule.I_method_c735da08().isEmpty() ? null : InventoryBuilderModule.I_method_c735da08().getFirst();
               this.Ii_field_49 = -1;
               this.I_field_43ee5667 = null;
               InventoryBuilderModule.Iii_method_1629dac3();
               this.I_field_5a = true;
            }
         }));
      var2.snapSize();
      iii_Class8 var3 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .I_method_7e2bb176(IIII.I_method_14640aa3(4.0F))
         .IiI_method_31d4c97(22.0F)
         .IIi_method_4dfc88d7(this.iiiI_field_46)
         .I_method_8939bffd(var1)
         .I_method_8939bffd(var2);
      var3.snapSize();
      this.i_field_b584628c = new iii_Class8()
         .I_method_485bccf5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.i_field_f93600a1)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(10.5F, 11.0F, 10.5F, 11.0F))
         .i_method_8c7d3515(this.iiiI_field_46, Math.max(0.0F, this.iIii_field_46 - 22.0F));
      this.i_field_b584628c.snapSize();
      iii_Class8 var4 = new iii_Class8()
         .I_method_485bccf5()
         .i_method_8c7d3515(this.iiiI_field_46, this.iIii_field_46)
         .I_method_8939bffd(var3)
         .I_method_8939bffd(this.i_field_b584628c);
      var4.snapSize();
      return var4;
   }

   private Iii_Class4 I_method_2590246a(String var1, ColorRGBA var2, Runnable var3) {
      return new Iii_Class4()
         .size(14.0F, 14.0F)
         .padding(3.0F)
         .radius(3.0F)
         .icon(var1, 8.0F, var2x -> this.I_method_8f35906e().mix(var2, 0.6F).mulAlpha(0.72F + 0.28F * var2x.hover()))
         .background(var2x -> I_method_452f57f0(this.II_method_2f67afb1(), var2, 0.05F + 0.05F * var2x.hover() + 0.03F * var2x.press()))
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick(var3);
   }

   private void I_method_f791e5ff() {
      InventoryBuilderModule.Nested1_210a0440 var1 = new InventoryBuilderModule.Nested1_210a0440(
         "\u041f\u0440\u0435\u0441\u0435\u0442 " + (InventoryBuilderModule.I_method_c735da08().size() + 1)
      );
      InventoryBuilderModule.I_method_c735da08().add(var1);
      this.I_field_43ee5a47 = var1;
      this.Ii_field_49 = -1;
      InventoryBuilderModule.Iii_method_1629dac3();
      this.I_field_5a = true;
   }

   private void I_method_faab8cb5(boolean var1) {
      if (this.I_field_b584628c != null) {
         List var2 = InventoryBuilderModule.I_method_c735da08();
         if (var1 || !I_method_57d141e5(this.I_field_7865b31, var2)) {
            ArrayList var3 = new ArrayList();

            for (InventoryBuilderModule.Nested1_210a0440 var5 : (Iterable<InventoryBuilderModule.Nested1_210a0440>)(Iterable<?>)var2) {
               var3.add(this.I_field_a567c40b.computeIfAbsent(var5, this::I_method_3bdf4298));
            }

            this.I_field_b584628c.II_method_244860a9(var3);
            this.I_field_7865b31 = new ArrayList<>(var2);
         }
      }
   }

   private iii_Class8 I_method_3bdf4298(InventoryBuilderModule.Nested1_210a0440 var1) {
      Iii_Class4 var2 = new Iii_Class4()
         .fill()
         .fade()
         .text(
            IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
            () -> var1.I_field_523beb0a,
            var1x -> this.I_method_8f35906e().mix(IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.5F * var1x.sig("active")).mulAlpha(0.6F + 0.4F * var1x.sig("active"))
         )
         .bind("active", () -> this.I_field_43ee5a47 == var1, I_field_f93678c1)
         .interactive(false);
      Iii_Class4 var3 = new Iii_Class4()
         .width(18.0F)
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
            () -> String.valueOf(var1.I_method_3878a76d()),
            var1x -> this.I_method_8f35906e().mulAlpha(0.42F)
         )
         .textAlign(IIi_Class2.II_field_b5755e8c)
         .interactive(false);
      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .IiI_method_31d4c97(15.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 3.5F))
         .iI_method_e886414(3.0F)
         .I_method_e53800a9(
            var1x -> I_method_452f57f0(this.Ii_method_b74ebb91(), IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.05F * var1x.sig("active") + 0.025F * var1x.hover())
         )
         .I_method_350d9c12("active", () -> this.I_field_43ee5a47 == var1, I_field_f93678c1)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(var2)
         .I_method_8939bffd(var3)
         .I_method_b60c4df8((var2x, var3x, var4) -> {
            if (var2x == IiIII_Class9.i_field_2f4c8d6c) {
               this.I_method_d4f945e2(var1, var3x, var4);
            } else if (this.I_field_43ee5a47 != var1) {
               this.I_field_43ee5a47 = var1;
               this.Ii_field_49 = -1;
               this.I_field_5a = true;
            }
         });
   }

   private void I_method_d4f945e2(InventoryBuilderModule.Nested1_210a0440 var1, float var2, float var3) {
      IiIIiiIii_Class156 var4 = new IiIIiiIii_Class156(var2, var3, 108.0F)
         .i_method_a1faeedf("\u041f\u0440\u0435\u0441\u0435\u0442")
         .I_method_88131b75()
         .I_method_78c7e89("\u0414\u0443\u0431\u043b\u0438\u0440\u043e\u0432\u0430\u0442\u044c", "copy", var2x -> {
            InventoryBuilderModule.Nested1_210a0440 var3x = var1.I_method_f2a22fb5(var1.I_field_523beb0a + " (\u043a\u043e\u043f\u0438\u044f)");
            List var4x = InventoryBuilderModule.I_method_c735da08();
            var4x.add(var4x.indexOf(var1) + 1, var3x);
            this.I_field_43ee5a47 = var3x;
            this.Ii_field_49 = -1;
            InventoryBuilderModule.Iii_method_1629dac3();
            this.I_field_5a = true;
            var2x.I_method_c3d80455(false);
         })
         .I_method_78c7e89("\u041e\u0447\u0438\u0441\u0442\u0438\u0442\u044c", "xmark", var2x -> {
            var1.I_method_3878a77a();
            if (this.I_field_43ee5a47 == var1) {
               this.Ii_field_49 = -1;
            }

            InventoryBuilderModule.Iii_method_1629dac3();
            var2x.I_method_c3d80455(false);
         })
         .I_method_78c7e89("\u0423\u0434\u0430\u043b\u0438\u0442\u044c", "trash", var2x -> {
            this.I_field_a567c40b.remove(var1);
            InventoryBuilderModule.I_method_c735da08().remove(var1);
            if (this.I_field_43ee5a47 == var1) {
               this.I_field_43ee5a47 = InventoryBuilderModule.I_method_c735da08().isEmpty() ? null : InventoryBuilderModule.I_method_c735da08().getFirst();
               this.Ii_field_49 = -1;
               this.I_field_43ee5667 = null;
               this.I_field_5a = true;
            }

            InventoryBuilderModule.Iii_method_1629dac3();
            var2x.I_method_c3d80455(false);
         });
      this.II_field_7865b31.add(var4);
   }

   private void i_method_f7a071df() {
      if (this.I_field_2d98292c != null) {
         this.I_field_2d98292c.I_method_e80ecb7f(this.I_field_43ee5a47 == null ? "" : this.I_field_43ee5a47.I_field_523beb0a);
      }

      if (this.i_field_b584628c != null) {
         if (this.I_field_43ee5a47 == null) {
            this.I_field_c74e1607 = null;
            this.i_field_b584628c
               .i_method_d2e03546(
                  List.of(
                     new Iii_Class4()
                        .fill()
                        .text(
                           IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
                           "\u0421\u043e\u0437\u0434\u0430\u0439 \u043f\u0440\u0435\u0441\u0435\u0442",
                           var1 -> this.I_method_8f35906e().mulAlpha(0.38F)
                        )
                        .textAlign(IIi_Class2.i_field_b5755e8c)
                        .interactive(false)
                  )
               );
         } else {
            this.I_field_c74e1607 = new IiiIiIiII_Class213.Nested1_98e3d080().I_method_48931aeb();
            this.i_field_b584628c.i_method_d2e03546(List.of(this.I_field_c74e1607));
         }
      }
   }

   private iii_Class8 I_method_f452adf5(float var1, float var2) {
      iii_Class8 var3 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(9.0F, 9.0F, 9.0F, 9.0F))
         .I_method_70a38517(6.0F)
         .iI_method_e886414(11.0F)
         .i_method_8c7d3515(var1, var2)
         .I_method_8361fbbd(iIi_Class6.i_field_b583ea6c)
         .I_method_f136b1d8(
            (var1x, var2x) -> {
               var1x.drawShadow(
                  var2x.x(), var2x.y(), var2x.w(), var2x.h(), 10.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F)
               );
               var1x.drawRoundedRect(var2x.x(), var2x.y(), var2x.w(), var2x.h(), IIiii_Class8.I_method_893b2757(11.0F), this.i_method_171c9c4e());
               var1x.drawRoundedBorder(var2x.x(), var2x.y(), var2x.w(), var2x.h(), 0.5F, IIiii_Class8.I_method_893b2757(11.0F), this.iI_method_a4621fd1());
               iIiiiiIii_Class380.I_method_5f4b621f();
            }
         )
         .I_method_3f5fb576(IiiI_Class7.Iii_field_f94500c1)
         .i_method_6e516956(IiiI_Class7.II_field_f94500c1);
      var3.iii_method_df275535();
      var3.snapSize();
      var3.snapAt(
         Math.max(4.0F, Math.min(this.width - var1 - 4.0F, this.I_method_f791e5ef() + (this.iIiI_field_46 - var1) / 2.0F)),
         Math.max(4.0F, Math.min(this.height - var2 - 4.0F, this.i_method_f7a071cf() + (this.iIii_field_46 - var2) / 2.0F))
      );
      return var3;
   }

   private Iii_Class4 I_method_30502cdf(String var1) {
      return new Iii_Class4()
         .fillWidth()
         .height(9.0F)
         .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), var1, var1x -> this.I_method_8f35906e().mulAlpha(0.85F))
         .interactive(false);
   }

   private void II_method_fab9d142() {
      this.I_field_523beb0a = "";
      iii_Class8 var1 = this.I_method_f452adf5(214.0F, 206.0F);
      var1.I_method_8939bffd(this.I_method_30502cdf("\u0412\u044b\u0431\u043e\u0440 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u0430"));
      var1.I_method_8939bffd(
         new IIiII_Class5(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), "", var1x -> this.I_field_523beb0a = var1x == null ? "" : var1x)
            .i_method_459bf75f("\u041f\u043e\u0438\u0441\u043a")
            .I_method_e5f33669(var1x -> this.Ii_method_b74ebb91())
            .I_method_49a8a757(3.0F)
            .i_method_e2c562d5()
            .Ii_method_3f6d8e94(15.0F)
      );
      var1.I_method_8939bffd(
         new iIIi_Class10<>(this::I_method_40994e68, this::I_method_ecce4276, var0 -> false, var2 -> {
               this.I_field_43ee5667 = var2.I_method_e1ba1bab();
               this.II_field_43ee5667 = null;
               this.Ii_field_b584628c = null;
               var1.beginExit(0.0F);
            })
            .I_method_4a1219ef(var1x -> this.II_field_43ee5667 = var1x)
            .I_method_c1659f40(500)
            .I_method_cd60f2a3(18.0F)
            .I_method_f6c003d1(var1x -> this.Ii_method_b74ebb91())
            .I_method_e56eeacb()
            .IIi_method_bdbfd7a3(150.0F)
      );
      this.Ii_field_b584628c = this.openWindow(var1);
   }

   void I_method_2dfbd282(InventoryBuilderModule.Nested1_210a0420 var1) {
      this.i_field_43ee5667 = var1;
      this.i_field_7865b31.clear();
      ArrayList var2 = new ArrayList();
      IIiiiIIiI_Class115 var3 = () -> var2;
      int var4 = this.I_method_2dfbd275(var1);
      if (var4 <= 1) {
         var1.i_field_49 = 1;
      } else {
         SliderSetting var5 = new SliderSetting(var3, "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e")
            .I_method_c8c9a7d7(1.0F)
            .i_method_65e2aff7(var4)
            .II_method_b0f56334(1.0F)
            .Ii_method_4e0e6b54(var1.i_field_49);
         this.i_field_7865b31.add(() -> var1.i_field_49 = (int)var5.Ii_method_a20abcd2());
      }

      TextSetting var16 = new TextSetting(var3, "\u041c\u0430\u043a\u0441. \u0446\u0435\u043d\u0430 \u0437\u0430 \u0448\u0442\u0443\u043a\u0443")
         .I_method_104de33f(String.valueOf(var1.I_field_4a))
         .I_method_ec08f9eb(true);
      this.i_field_7865b31.add(() -> var1.I_field_4a = Math.max(0, this.I_method_69a7060d(var16.II_method_da016c1e(), 0)));
      if (var1.I_method_1dd939e()) {
         SliderSetting var6 = new SliderSetting(var3, "\u041c\u0438\u043d. \u043f\u0440\u043e\u0447\u043d\u043e\u0441\u0442\u044c")
            .I_method_c8c9a7d7(0.0F)
            .i_method_65e2aff7(100.0F)
            .II_method_b0f56334(1.0F)
            .Ii_method_4e0e6b54(var1.II_field_49)
            .I_method_d41e7abf("%");
         this.i_field_7865b31.add(() -> var1.II_field_49 = (int)var6.Ii_method_a20abcd2());
      }

      if (var1.iI_field_49 > 0) {
         TimeSetting var17 = new TimeSetting(var3, "\u041c\u0438\u043d. \u0434\u043b\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c")
            .I_method_a7007deb(false)
            .i_method_85cb597a(13)
            .I_method_694e679d(var0 -> Math.min(var0, 720))
            .II_method_7fd80f7(var1.Ii_field_49);
         this.i_field_7865b31.add(() -> var1.Ii_field_49 = var17.III_method_2626c6b2());
      }

      boolean var18 = var1.I_method_e20385e().isEnchantable();
      String var7 = var18 ? "\u0417\u0430\u0447\u0430\u0440\u043e\u0432\u0430\u043d\u0438\u0435" : "\u042d\u0444\u0444\u0435\u043a\u0442";
      String var8 = var18 ? "\u0417\u0430\u0447\u0430\u0440\u043e\u0432\u0430\u043d\u0438\u044f" : "\u042d\u0444\u0444\u0435\u043a\u0442\u044b";
      MultiSelectSetting var9 = null;

      for (InventoryBuilderModule.Nested1_368049 var11 : var1.I_field_7865b31) {
         if (var11.I_method_9d154904() <= 0) {
            String var12 = var11.I_method_7fefcfaf();
            if (var9 == null) {
               var9 = new MultiSelectSetting(var3, var8);
            }

            MultiSelectSetting.Nested1_42856060 var13 = new MultiSelectSetting.Nested1_42856060(var9, var12);
            if (var1.I_field_a567c40b.containsKey(var12)) {
               var13.select();
            }

            this.i_field_7865b31.add(() -> {
               if (var13.isSelected()) {
                  var1.I_field_a567c40b.put(var12, 0);
               } else {
                  var1.I_field_a567c40b.remove(var12);
               }
            });
         }
      }

      ArrayList<InventoryBuilderModule.Nested1_368049> var19 = new ArrayList<>();

      for (InventoryBuilderModule.Nested1_368049 var22 : var1.I_field_7865b31) {
         if (var22.I_method_9d154904() > 0) {
            var19.add(var22);
         }
      }

      boolean var21 = var1.i_field_7865b31.size() == 1;

      for (InventoryBuilderModule.Nested1_368049 var25 : var21 ? List.<InventoryBuilderModule.Nested1_368049>of() : var19) {
         String var14 = var25.I_method_7fefcfaf();
         if (var1.I_field_a567c40b.containsKey(var14)) {
            SliderSetting var15 = new SliderSetting(var3, var14)
               .I_method_c8c9a7d7(0.0F)
               .i_method_65e2aff7(var25.I_method_9d154904())
               .II_method_b0f56334(1.0F)
               .Ii_method_4e0e6b54(Math.max(1, var1.I_field_a567c40b.get(var14)));
            this.i_field_7865b31.add(() -> {
               int var5x = this.I_method_1a0e4caa(var1, var14, var25.I_method_9d154904());
               int var6x = Math.min(var5x, (int)var15.Ii_method_a20abcd2());
               if (var6x != (int)var15.Ii_method_a20abcd2()) {
                  var15.Ii_method_4e0e6b54(var6x);
               }

               if (var6x <= 0) {
                  var1.I_field_a567c40b.remove(var14);
                  this.i_field_5a = true;
               } else {
                  var1.I_field_a567c40b.put(var14, var6x);
               }
            });
         }
      }

      IiIIiiIii_Class156 var24 = new IiIIiiIii_Class156(this.I_method_f791e5ef() + this.iIiI_field_46 + 8.0F, this.i_method_f7a071cf(), 150.0F)
         .i_method_a1faeedf(var1.i_method_34b57866())
         .I_method_88131b75();

      for (Setting var28 : (Iterable<Setting>)(Iterable<?>)var2) {
         var24.I_method_cbb5737d(var28);
      }

      boolean var27 = !var21
         && var19.stream()
            .anyMatch(
               var2x -> !var1.I_field_a567c40b.containsKey(var2x.I_method_7fefcfaf())
                  && this.I_method_1a0e4caa(var1, var2x.I_method_7fefcfaf(), var2x.I_method_9d154904()) > 0
            );
      boolean var29 = !var21 && var19.stream().anyMatch(var1x -> var1.I_field_a567c40b.containsKey(var1x.I_method_7fefcfaf()));
      if (var27 || var29) {
         var24.I_method_88131b75();
      }

      if (var27) {
         var24.I_method_78c7e89("+ " + var7, "plus", var4x -> this.I_method_7701021d(var1, var19, var4x, var7));
      }

      if (var29) {
         var24.I_method_78c7e89(
            "\u0423\u0431\u0440\u0430\u0442\u044c " + var7.toLowerCase(Locale.ROOT), "trash", var4x -> this.i_method_6f0775fd(var1, var19, var4x, var7)
         );
      }

      this.II_field_7865b31.add(var24);
      this.ii_field_b584628c = null;
   }

   private void I_method_7701021d(InventoryBuilderModule.Nested1_210a0420 var1, List<InventoryBuilderModule.Nested1_368049> var2, IiIIiiIii_Class156 var3, String var4) {
      ArrayList var5 = new ArrayList();

      for (InventoryBuilderModule.Nested1_368049 var7 : var2) {
         if (!var1.I_field_a567c40b.containsKey(var7.I_method_7fefcfaf())
            && this.I_method_1a0e4caa(var1, var7.I_method_7fefcfaf(), var7.I_method_9d154904()) > 0) {
            var5.add(var7);
         }
      }

      if (!var5.isEmpty()) {
         IiIIiiIii_Class156 var10 = new IiIIiiIii_Class156(var3.I_method_4e7e11bc() + 154.0F, var3.i_method_4e8c9d9c(), 130.0F)
            .i_method_a1faeedf(var4)
            .I_method_88131b75();

         for (InventoryBuilderModule.Nested1_368049 var8 : (Iterable<InventoryBuilderModule.Nested1_368049>)(Iterable<?>)var5) {
            int var9 = this.I_method_1a0e4caa(var1, var8.I_method_7fefcfaf(), var8.I_method_9d154904());
            var10.I_method_78c7e89(var8.I_method_7fefcfaf() + "  " + var9, "check", var5x -> {
               var1.I_field_a567c40b.put(var8.I_method_7fefcfaf(), var9);
               InventoryBuilderModule.Iii_method_1629dac3();
               var5x.I_method_c3d80455(false);
               var3.I_method_c3d80455(false);
               this.i_field_5a = true;
            });
         }

         this.II_field_7865b31.add(var10);
      }
   }

   private void i_method_6f0775fd(InventoryBuilderModule.Nested1_210a0420 var1, List<InventoryBuilderModule.Nested1_368049> var2, IiIIiiIii_Class156 var3, String var4) {
      ArrayList var5 = new ArrayList();

      for (InventoryBuilderModule.Nested1_368049 var7 : var2) {
         if (var1.I_field_a567c40b.containsKey(var7.I_method_7fefcfaf())) {
            var5.add(var7);
         }
      }

      if (!var5.isEmpty()) {
         IiIIiiIii_Class156 var9 = new IiIIiiIii_Class156(var3.I_method_4e7e11bc() + 154.0F, var3.i_method_4e8c9d9c(), 130.0F)
            .i_method_a1faeedf(var4)
            .I_method_88131b75();

         for (InventoryBuilderModule.Nested1_368049 var8 : (Iterable<InventoryBuilderModule.Nested1_368049>)(Iterable<?>)var5) {
            var9.I_method_78c7e89(var8.I_method_7fefcfaf() + "  " + var1.I_field_a567c40b.get(var8.I_method_7fefcfaf()), "trash", var4x -> {
               var1.I_field_a567c40b.remove(var8.I_method_7fefcfaf());
               InventoryBuilderModule.Iii_method_1629dac3();
               var4x.I_method_c3d80455(false);
               var3.I_method_c3d80455(false);
               this.i_field_5a = true;
            });
         }

         this.II_field_7865b31.add(var9);
      }
   }

   private void Ii_method_fac85d22() {
      this.Ii_field_7865b31 = new ArrayList<>();
      this.iI_field_7865b31 = new ArrayList<>();
      ArrayList<InventoryBuilderModule.Nested1_210a0420> var1 = new ArrayList<>(InventoryBuilderModule.i_method_7c821228());
      var1.sort(Comparator.comparingInt(var0 -> InventoryBuilderModule.I_method_419b7e5c(var0.I_field_523beb0a)));

      for (InventoryBuilderModule.Nested1_210a0420 var3 : (Iterable<InventoryBuilderModule.Nested1_210a0420>)(Iterable<?>)var1) {
         this.Ii_field_7865b31.add(var3);
         this.iI_field_7865b31.add((var3.I_method_a196c846() + " " + var3.i_method_34b57866()).toLowerCase(Locale.ROOT));
      }

      LinkedHashSet var8 = new LinkedHashSet();

      for (Potion var4 : Registries.POTION) {
         Identifier var5 = Registries.POTION.getId(var4);
         if (var5 != null) {
            InventoryBuilderModule.Nested1_210a0420 var6 = new InventoryBuilderModule.Nested1_210a0420(Registries.ITEM.getId(Items.POTION), "");
            var6.iI_field_523beb0a = var5.toString();
            var6.i_field_523beb0a = this.I_method_c93328c6(var4, var6);
            var6.I_field_5a = true;
            if (var8.add(var6.i_field_523beb0a.toLowerCase(Locale.ROOT))) {
               this.Ii_field_7865b31.add(var6);
               this.iI_field_7865b31.add((var6.i_field_523beb0a + " " + var5).toLowerCase(Locale.ROOT));
            }
         }
      }

      LinkedHashSet var10 = new LinkedHashSet();

      for (InventoryBuilderModule.Nested1_210a0420 var13 : InventoryBuilderModule.i_method_7c821228()) {
         var10.add(var13.I_method_a196c846().toLowerCase(Locale.ROOT));
      }

      for (Item var14 : Registries.ITEM) {
         if (var14 != Items.POTION && !var14.getDefaultStack().isEmpty()) {
            Identifier var15 = Registries.ITEM.getId(var14);
            String var7 = Text.translatable(var14.getTranslationKey()).getString();
            if (!var10.contains(var7.toLowerCase(Locale.ROOT))) {
               this.Ii_field_7865b31.add(new InventoryBuilderModule.Nested1_210a0420(var15, var7));
               this.iI_field_7865b31.add((var7 + " " + var15).toLowerCase(Locale.ROOT));
            }
         }
      }
   }

   private List<InventoryBuilderModule.Nested1_210a0420> I_method_40994e68() {
      if (this.Ii_field_7865b31 == null) {
         this.Ii_method_fac85d22();
      }

      String var1 = this.I_field_523beb0a.trim().toLowerCase(Locale.ROOT);
      if (var1.equals(this.i_field_523beb0a)) {
         return this.ii_field_7865b31;
      } else {
         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < this.Ii_field_7865b31.size(); var3++) {
            if (var1.isEmpty() || this.iI_field_7865b31.get(var3).contains(var1)) {
               var2.add(this.Ii_field_7865b31.get(var3));
            }
         }

         this.i_field_523beb0a = var1;
         this.ii_field_7865b31 = var2;
         return var2;
      }
   }

   private ItemStack I_method_ecce4276(InventoryBuilderModule.Nested1_210a0420 var1) {
      return this.i_field_a567c40b.computeIfAbsent(var1, InventoryBuilderModule.Nested1_210a0420::I_method_e20385e);
   }

   private InventoryBuilderModule I_method_fb2d5315() {
      return RockstarClient.getInstance().getModuleManager().getModule(InventoryBuilderModule.class);
   }

   private boolean I_method_f791e603() {
      InventoryBuilderModule var1 = this.I_method_fb2d5315();
      return var1 != null && var1.IiI_method_161b4ee3();
   }

   private String I_method_c93328c6(Potion var1, InventoryBuilderModule.Nested1_210a0420 var2) {
      List var3 = var1.getEffects();
      if (!var3.isEmpty()) {
         String var4 = ((StatusEffect)((StatusEffectInstance)var3.getFirst()).getEffectType().value()).getName().getString();
         if (!var4.isBlank()) {
            return "\u0417\u0435\u043b\u044c\u0435 " + var4.toLowerCase(Locale.ROOT);
         }
      }

      return var2.I_method_e20385e().getName().getString();
   }

   private int I_method_1a0e4caa(InventoryBuilderModule.Nested1_210a0420 var1, String var2, int var3) {
      if (var1.i_field_7865b31.isEmpty()) {
         if (var1.ii_field_49 > 0) {
            int var10 = 0;

            for (Entry var12 : var1.I_field_a567c40b.entrySet()) {
               if (!((String)var12.getKey()).equals(var2)) {
                  var10 += Math.max(0, (Integer)var12.getValue());
               }
            }

            return Math.max(0, Math.min(var3, var1.ii_field_49 - var10));
         } else {
            return var3;
         }
      } else {
         int var4 = 0;

         for (Map<String, Integer> var6 : var1.i_field_7865b31) {
            boolean var7 = true;

            for (Entry var9 : var1.I_field_a567c40b.entrySet()) {
               if (!((String)var9.getKey()).equals(var2) && (Integer)var9.getValue() > 0 && var6.getOrDefault(var9.getKey(), 0) < (Integer)var9.getValue()) {
                  var7 = false;
                  break;
               }
            }

            if (var7) {
               var4 = Math.max(var4, var6.getOrDefault(var2, 0));
            }
         }

         return Math.min(var3, var4);
      }
   }

   boolean I_method_a2c538e3(InventoryBuilderModule.Nested1_210a0420 var1, InventoryBuilderModule.Nested1_210a0420 var2) {
      return var1.I_field_6a3d6525.equals(var2.I_field_6a3d6525) && var1.I_method_a196c846().equalsIgnoreCase(var2.I_method_a196c846());
   }

   int I_method_2dfbd275(InventoryBuilderModule.Nested1_210a0420 var1) {
      return var1.I_method_1dd938d();
   }

   private int I_method_69a7060d(String var1, int var2) {
      try {
         return Integer.parseInt(var1.trim());
      } catch (Exception var4) {
         return var2;
      }
   }

   private static boolean I_method_80075703(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      return var0 < var4 + var6 && var4 < var0 + var2 && var1 < var5 + var7 && var5 < var1 + var3;
   }

   private static boolean I_method_57d141e5(List<?> var0, List<?> var1) {
      if (var0.size() != var1.size()) {
         return false;
      } else {
         for (int var2 = 0; var2 < var0.size(); var2++) {
            if (var0.get(var2) != var1.get(var2)) {
               return false;
            }
         }

         return true;
      }
   }

   private ColorRGBA I_method_8f35906e() {
      return IiiiiIIIi_Class242.iI_method_8e08d3b1();
   }

   private ColorRGBA i_method_171c9c4e() {
      return IiiiiIIIi_Class242.II_method_190e6391().withAlpha(242.25F);
   }

   private ColorRGBA II_method_2f67afb1() {
      return IiiiiIIIi_Class242.II_method_190e6391().withAlpha(102.0F);
   }

   ColorRGBA Ii_method_b74ebb91() {
      return this.II_method_2f67afb1();
   }

   ColorRGBA iI_method_a4621fd1() {
      return IiiiiIIIi_Class242.IiI_field_d0c8ec5.withAlpha(89.25F);
   }

   static ColorRGBA I_method_452f57f0(ColorRGBA var0, ColorRGBA var1, float var2) {
      return var0.mix(var1.withAlpha(var0.getAlpha()), var2);
   }

   private void I_method_3bab58e0(IiII_Class5 var1) {
      var1.i_method_65326e43(-3.0F)
         .II_method_e6aaaac(2.0F)
         .I_method_2a080a63(2.0F)
         .Ii_method_49950e8c(18.0F)
         .iI_method_388cc2cc(1.0F)
         .ii_method_73b726ac(1100.0F)
         .i_method_989a5f71(
            var1x -> this.I_method_8f35906e().withAlpha(255.0F * (0.28F + 0.24F * var1x.I_method_af833bdc() + 0.28F * var1x.i_method_af91c7bc()))
         );
   }

   @Override
   public void render(III var1) {
      this.I_method_faab8cb5(false);
      if (this.I_field_5a) {
         this.I_field_5a = false;
         this.i_method_f7a071df();
      }

      if (this.i_field_5a) {
         this.i_field_5a = false;
         InventoryBuilderModule.Nested1_210a0420 var2 = this.i_field_43ee5667;
         this.i_field_7865b31.clear();
         this.II_field_7865b31.forEach(var0 -> var0.I_method_c3d80455(false));
         if (var2 != null) {
            this.I_method_2dfbd282(var2);
         }
      }

      if (!this.II_field_7865b31.isEmpty() && !this.i_field_7865b31.isEmpty()) {
         this.i_field_7865b31.forEach(Runnable::run);
      }

      super.render(var1);
   }

   @Override
   protected void afterRender(III var1) {
      this.II_field_7865b31.removeIf(var0 -> !var0.II_method_c3e648e6() && var0.I_method_ea650b95().I_method_6ac4da6f() <= 0.01F);

      for (IiIIiiIii_Class156 var3 : this.II_field_7865b31) {
         var3.I_method_7ae26dda(var1);
      }

      IIiIIi_Class10 var18 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F);
      String var19 = "\u041b\u041a\u041c - \u0432\u0437\u044f\u0442\u044c   \u041f\u041a\u041c - \u043f\u043e\u043b\u043e\u0432\u0438\u043d\u0430   \u0421\u041a\u041c - \u0443\u0441\u043b\u043e\u0432\u0438\u044f   \u041a\u043e\u043b\u0435\u0441\u043e - \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438   Shift+\u041b\u041a\u041c - \u0443\u0431\u0440\u0430\u0442\u044c";
      float var4 = var18.I_method_2c375926(var19);
      float var5 = var18.I_method_a649725c();
      float var6 = this.I_method_f791e5ef() + (this.iIiI_field_46 - var4) / 2.0F;
      float var7 = this.i_method_f7a071cf() + this.iIii_field_46 + 9.0F;
      boolean var8 = this.Ii_field_b584628c != null
         && this.Ii_field_b584628c.alive()
         && I_method_80075703(
            var6, var7, var4, var5, this.Ii_field_b584628c.x(), this.Ii_field_b584628c.y(), this.Ii_field_b584628c.w(), this.Ii_field_b584628c.h()
         );

      for (IiIIiiIii_Class156 var10 : this.II_field_7865b31) {
         if (var8) {
            break;
         }

         var8 = I_method_80075703(
            var6, var7, var4, var5, var10.I_method_4e7e11bc(), var10.i_method_4e8c9d9c(), var10.II_method_c7206932(), var10.Ii_method_2047ead7()
         );
      }

      if (!var8) {
         var1.drawText(var18, var19, var6, var7, this.I_method_8f35906e().mulAlpha(0.6F));
      }

      float var20 = var1.I_method_b1c3e152();
      float var21 = var1.i_method_b1d26d32();
      InventoryBuilderModule.Nested1_210a0420 var11 = this.II_field_43ee5667 != null && this.Ii_field_b584628c != null && this.Ii_field_b584628c.alive()
         ? this.II_field_43ee5667
         : this.I_method_e5249490();
      if (var11 != null && this.I_field_43ee5667 == null) {
         IIiIIi_Class10 var12 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
         String var13 = var11.i_method_34b57866();
         float var14 = var12.I_method_2c375926(var13) + 10.0F;
         float var15 = 13.0F;
         float var16 = Math.min(var20 + 9.0F, this.width - var14 - 3.0F);
         float var17 = Math.max(3.0F, var21 - var15 - 3.0F);
         var1.drawShadow(var16, var17, var14, var15, 8.0F, IIiii_Class8.I_method_893b2757(4.0F), IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.45F));
         var1.drawRoundedRect(var16, var17, var14, var15, IIiii_Class8.I_method_893b2757(4.0F), this.i_method_171c9c4e());
         var1.drawRoundedBorder(var16, var17, var14, var15, 0.5F, IIiii_Class8.I_method_893b2757(4.0F), this.iI_method_a4621fd1());
         var1.drawText(var12, var13, var16 + 5.0F, var17 + var15 / 2.0F - var12.I_method_a649725c() / 2.0F, this.I_method_8f35906e().mulAlpha(0.9F));
      }

      if (this.I_field_43ee5667 != null) {
         ItemStack var22 = this.I_field_43ee5667.I_method_e20385e();
         var1.drawItem(var22, var20 - 8.0F, var21 - 8.0F, 1.0F);
         if (this.I_field_43ee5667.i_field_49 > 1) {
            IIiIIi_Class10 var23 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
            String var24 = String.valueOf(this.I_field_43ee5667.i_field_49);
            var1.drawTextWithShadow(
               var23,
               var24,
               var20 + 7.0F - var23.I_method_2c375926(var24),
               var21 + 7.0F - var23.I_method_a649725c(),
               IiiiiIIIi_Class242.Ii_field_d0c8ec5,
               IiiiiIIIi_Class242.iI_field_d0c8ec5,
               0.8F,
               0.8F,
               1.2F
            );
         }
      }
   }

   private InventoryBuilderModule.Nested1_210a0420 I_method_e5249490() {
      return this.I_field_43ee5a47 != null && this.iI_field_49 >= 0 && this.iI_field_49 < 41 ? this.I_field_43ee5a47.I_field_814f57ec[this.iI_field_49] : null;
   }

   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      float var6 = (float)var1;
      float var7 = (float)var3;
      if (!this.II_field_7865b31.isEmpty()) {
         for (IiIIiiIii_Class156 var9 : new ArrayList<>(this.II_field_7865b31)) {
            var9.I_method_400ceaa7(var1, var3, var5);
            if (!var9.I_method_a74cd690(var1, var3)) {
               var9.I_method_c3d80455(false);
            }
         }
      } else if (!this.I_method_5abd5a43(var6, var7)) {
         if (this.I_field_43ee5667 == null
            || var5 != IiIII_Class9.I_field_2f4c8d6c
            || this.I_field_c74e1607 != null && this.I_field_c74e1607.contains(var6, var7)) {
            super.onMouseClicked(var1, var3, var5);
         } else {
            this.I_field_43ee5667 = null;
            InventoryBuilderModule.Iii_method_1629dac3();
         }
      }
   }

   private void iI_method_fc7cc162() {
      this.ii_field_b584628c = null;
      this.iI_field_b584628c = null;
      this.i_field_43ee5667 = null;
      this.i_field_7865b31.clear();
   }

   @Override
   public void onMouseReleased(double var1, double var3, IiIII_Class9 var5) {
      for (IiIIiiIii_Class156 var7 : this.II_field_7865b31) {
         var7.i_method_6a097ac7(var1, var3, var5);
      }

      super.onMouseReleased(var1, var3, var5);
   }

   private boolean I_method_5abd5a43(float var1, float var2) {
      if (this.Ii_field_b584628c == null) {
         return false;
      } else if (!this.Ii_field_b584628c.alive()) {
         this.Ii_field_b584628c = null;
         return false;
      } else if (this.Ii_field_b584628c.contains(var1, var2)) {
         return false;
      } else {
         this.Ii_field_b584628c.beginExit(0.0F);
         if (this.Ii_field_b584628c == this.ii_field_b584628c) {
            this.iI_method_fc7cc162();
         }

         this.Ii_field_b584628c = null;
         InventoryBuilderModule.Iii_method_1629dac3();
         return true;
      }
   }

   @Override
   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
      if (keyCode == 256) {
         if (this.Ii_field_b584628c != null && this.Ii_field_b584628c.alive()) {
            this.Ii_field_b584628c.beginExit(0.0F);
            if (this.Ii_field_b584628c == this.ii_field_b584628c) {
               this.iI_method_fc7cc162();
            }

            this.Ii_field_b584628c = null;
            InventoryBuilderModule.Iii_method_1629dac3();
            return true;
         }

         if (this.I_field_43ee5667 != null) {
            this.I_field_43ee5667 = null;
            return true;
         }
      }

      return super.keyPressed(keyCode, scanCode, modifiers);
   }

   @Override
   public boolean shouldPause() {
      return false;
   }

   @Override
   public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
   }

   public void close() {
      this.I_field_43ee5667 = null;
      InventoryBuilderModule.Iii_method_1629dac3();
      super.close();
      MenuModule.IiI_method_c56c3e7f();
   }

   class Nested1_98e3d080 extends iiI_Class7 {
      private IiIII_Class9 I_field_2f4c8d6c;
      private final Set<Integer> I_field_a56a8dc5 = new LinkedHashSet<>();

      Nested1_98e3d080() {
         this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      }

      IiiIiIiII_Class213.Nested1_98e3d080 I_method_48931aeb() {
         this.size(178.0F, 106.0F);
         this.snapSize();
         return this;
      }

      private float I_method_f87c56f9(int var1) {
         if (var1 >= 36) {
            int var2 = var1 - 36;
            return this.x() + (var2 == 4 ? 5 : var2) * 20.0F;
         } else {
            return this.x() + var1 % 9 * 20.0F;
         }
      }

      private float i_method_fa3f4719(int var1) {
         if (var1 >= 36) {
            return this.y();
         } else {
            return var1 < 27 ? this.y() + 24.0F + var1 / 9 * 20.0F : this.y() + 88.0F;
         }
      }

      private int I_method_170d94ad(float var1, float var2) {
         for (int var3 = 0; var3 < 41; var3++) {
            float var4 = this.I_method_f87c56f9(var3);
            float var5 = this.i_method_fa3f4719(var3);
            if (var1 >= var4 && var1 <= var4 + 18.0F && var2 >= var5 && var2 <= var5 + 18.0F) {
               return var3;
            }
         }

         return -1;
      }

      @Override
      protected void onTick(float var1, float var2, float var3) {
         IiiIiIiII_Class213.this.iI_field_49 = this.inFlow() && this.contains(var2, var3) ? this.I_method_170d94ad(var2, var3) : -1;
         if (this.I_field_2f4c8d6c == IiIII_Class9.i_field_2f4c8d6c
            && IiiIiIiII_Class213.this.I_field_43ee5667 != null
            && IiiIiIiII_Class213.this.I_field_43ee5a47 != null) {
            int var4 = this.I_method_170d94ad(var2, var3);
            if (var4 >= 0 && !this.I_field_a56a8dc5.contains(var4)) {
               InventoryBuilderModule.Nested1_210a0420 var5 = IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4];
               if (var5 == null) {
                  InventoryBuilderModule.Nested1_210a0420 var6 = IiiIiIiII_Class213.this.I_field_43ee5667.I_method_e1ba1bab();
                  var6.i_field_49 = 1;
                  IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4] = var6;
               } else {
                  if (!IiiIiIiII_Class213.this.I_method_a2c538e3(var5, IiiIiIiII_Class213.this.I_field_43ee5667)
                     || var5.i_field_49 >= IiiIiIiII_Class213.this.I_method_2dfbd275(var5)) {
                     return;
                  }

                  var5.i_field_49++;
               }

               this.I_field_a56a8dc5.add(var4);
               if (--IiiIiIiII_Class213.this.I_field_43ee5667.i_field_49 <= 0) {
                  IiiIiIiII_Class213.this.I_field_43ee5667 = null;
               }

               InventoryBuilderModule.Iii_method_1629dac3();
            }
         }
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         IIiii_Class8 var3 = IIiii_Class8.I_method_893b2757(3.0F);
         ColorRGBA var4 = IiiIiIiII_Class213.this.iI_method_a4621fd1();
         MatrixStack var5 = var1.getMatrices();

         for (int var6 = 0; var6 < 41; var6++) {
            float var7 = this.I_method_f87c56f9(var6);
            float var8 = this.i_method_fa3f4719(var6);
            boolean var9 = IiiIiIiII_Class213.this.Ii_field_49 == var6;
            float var10 = 0.05F * (var9 ? 1.0F : 0.0F) + 0.03F * (IiiIiIiII_Class213.this.iI_field_49 == var6 ? 1.0F : 0.0F);
            var1.drawRoundedRect(
               var7,
               var8,
               18.0F,
               18.0F,
               var3,
               IiiIiIiII_Class213.I_method_452f57f0(IiiIiIiII_Class213.this.Ii_method_b74ebb91(), IiiiiIIIi_Class242.ii_field_d0c8ec5, var10).mulAlpha(var2)
            );
            var1.drawRoundedBorder(var7, var8, 18.0F, 18.0F, 0.5F, var3, (var9 ? IiiiiIIIi_Class242.ii_field_d0c8ec5.withAlpha(140.25F) : var4).mulAlpha(var2));
         }

         iIiiiiIii_Class380.I_method_5f4b621f();

         for (int var11 = 0; var11 < 41; var11++) {
            InventoryBuilderModule.Nested1_210a0420 var13 = IiiIiIiII_Class213.this.I_field_43ee5a47 == null
               ? null
               : IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var11];
            if (var13 != null) {
               float var15 = this.I_method_f87c56f9(var11) + 9.0F;
               float var17 = this.i_method_fa3f4719(var11) + 9.0F;
               iIiiiIIiI_Class371.II_method_e18635ac(var5, var15, var17, var2);
               var1.drawBatchItem(var13.I_method_e20385e(), var15 - 8.0F, var17 - 8.0F);
               iIiiiIIiI_Class371.I_method_10503b11(var5);
               DiffuseLighting.disableGuiDepthLighting();
            }
         }

         ((DrawContextAccessor)(Object)var1).getVertexConsumers().draw();
         IIiIIi_Class10 var12 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);

         for (int var14 = 0; var14 < 41; var14++) {
            InventoryBuilderModule.Nested1_210a0420 var16 = IiiIiIiII_Class213.this.I_field_43ee5a47 == null
               ? null
               : IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var14];
            if (var16 != null && var16.i_field_49 > 1) {
               String var18 = String.valueOf(var16.i_field_49);
               var1.drawTextWithShadow(
                  var12,
                  var18,
                  this.I_method_f87c56f9(var14) + 18.0F - 1.5F - var12.I_method_2c375926(var18),
                  this.i_method_fa3f4719(var14) + 18.0F - 1.5F - var12.I_method_a649725c(),
                  IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(var2),
                  IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(var2),
                  0.8F,
                  0.8F,
                  1.2F
               );
            }
         }
      }

      @Override
      public boolean mouseClicked(float var1, float var2, IiIII_Class9 var3) {
         if (this.inFlow() && this.contains(var1, var2) && IiiIiIiII_Class213.this.I_field_43ee5a47 != null) {
            int var4 = this.I_method_170d94ad(var1, var2);
            if (var4 < 0) {
               return false;
            } else {
               InventoryBuilderModule.Nested1_210a0420 var5 = IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4];
               if (var3 == IiIII_Class9.II_field_2f4c8d6c) {
                  if (var5 != null) {
                     IiiIiIiII_Class213.this.Ii_field_49 = var4;
                     IiiIiIiII_Class213.this.I_method_2dfbd282(var5);
                  }

                  return true;
               } else if (Screen.hasShiftDown()) {
                  if (var5 == null) {
                     return true;
                  } else {
                     IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4] = null;
                     if (IiiIiIiII_Class213.this.Ii_field_49 == var4) {
                        IiiIiIiII_Class213.this.Ii_field_49 = -1;
                     }

                     InventoryBuilderModule.Iii_method_1629dac3();
                     return true;
                  }
               } else if (var3 == IiIII_Class9.I_field_2f4c8d6c) {
                  if (IiiIiIiII_Class213.this.I_field_43ee5667 == null) {
                     if (var5 == null) {
                        return true;
                     }

                     IiiIiIiII_Class213.this.I_field_43ee5667 = var5;
                     IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4] = null;
                     IiiIiIiII_Class213.this.Ii_field_49 = -1;
                  } else if (var5 == null) {
                     IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4] = IiiIiIiII_Class213.this.I_field_43ee5667;
                     IiiIiIiII_Class213.this.Ii_field_49 = var4;
                     IiiIiIiII_Class213.this.I_field_43ee5667 = null;
                  } else if (IiiIiIiII_Class213.this.I_method_a2c538e3(var5, IiiIiIiII_Class213.this.I_field_43ee5667)) {
                     int var8 = Math.min(IiiIiIiII_Class213.this.I_field_43ee5667.i_field_49, IiiIiIiII_Class213.this.I_method_2dfbd275(var5) - var5.i_field_49);
                     var5.i_field_49 += var8;
                     IiiIiIiII_Class213.this.I_field_43ee5667.i_field_49 -= var8;
                     if (IiiIiIiII_Class213.this.I_field_43ee5667.i_field_49 <= 0) {
                        IiiIiIiII_Class213.this.I_field_43ee5667 = null;
                     }

                     IiiIiIiII_Class213.this.Ii_field_49 = var4;
                  } else {
                     IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4] = IiiIiIiII_Class213.this.I_field_43ee5667;
                     IiiIiIiII_Class213.this.I_field_43ee5667 = var5;
                     IiiIiIiII_Class213.this.Ii_field_49 = var4;
                  }

                  InventoryBuilderModule.Iii_method_1629dac3();
                  return true;
               } else if (var3 == IiIII_Class9.i_field_2f4c8d6c) {
                  if (IiiIiIiII_Class213.this.I_field_43ee5667 == null) {
                     if (var5 == null) {
                        return true;
                     }

                     if (var5.i_field_49 <= 1) {
                        IiiIiIiII_Class213.this.I_field_43ee5667 = var5;
                        IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4] = null;
                        IiiIiIiII_Class213.this.Ii_field_49 = -1;
                     } else {
                        int var6 = (var5.i_field_49 + 1) / 2;
                        IiiIiIiII_Class213.this.I_field_43ee5667 = var5.I_method_e1ba1bab();
                        IiiIiIiII_Class213.this.I_field_43ee5667.i_field_49 = var6;
                        var5.i_field_49 -= var6;
                     }
                  } else if (var5 == null) {
                     InventoryBuilderModule.Nested1_210a0420 var7 = IiiIiIiII_Class213.this.I_field_43ee5667.I_method_e1ba1bab();
                     var7.i_field_49 = 1;
                     IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var4] = var7;
                     if (--IiiIiIiII_Class213.this.I_field_43ee5667.i_field_49 <= 0) {
                        IiiIiIiII_Class213.this.I_field_43ee5667 = null;
                     }

                     IiiIiIiII_Class213.this.Ii_field_49 = var4;
                  } else if (IiiIiIiII_Class213.this.I_method_a2c538e3(var5, IiiIiIiII_Class213.this.I_field_43ee5667)
                     && var5.i_field_49 < IiiIiIiII_Class213.this.I_method_2dfbd275(var5)) {
                     var5.i_field_49++;
                     if (--IiiIiIiII_Class213.this.I_field_43ee5667.i_field_49 <= 0) {
                        IiiIiIiII_Class213.this.I_field_43ee5667 = null;
                     }

                     IiiIiIiII_Class213.this.Ii_field_49 = var4;
                  }

                  this.I_field_2f4c8d6c = IiIII_Class9.i_field_2f4c8d6c;
                  this.I_field_a56a8dc5.clear();
                  this.I_field_a56a8dc5.add(var4);
                  InventoryBuilderModule.Iii_method_1629dac3();
                  return true;
               } else {
                  return false;
               }
            }
         } else {
            return false;
         }
      }

      @Override
      public void mouseReleased(float var1, float var2, IiIII_Class9 var3) {
         this.I_field_2f4c8d6c = null;
         this.I_field_a56a8dc5.clear();
      }

      @Override
      public boolean mouseScrolled(float var1, float var2, float var3, float var4) {
         if (this.inFlow() && this.contains(var1, var2) && IiiIiIiII_Class213.this.I_field_43ee5a47 != null) {
            int var5 = this.I_method_170d94ad(var1, var2);
            if (var5 < 0) {
               return false;
            } else {
               InventoryBuilderModule.Nested1_210a0420 var6 = IiiIiIiII_Class213.this.I_field_43ee5a47.I_field_814f57ec[var5];
               if (var6 == null) {
                  return false;
               } else {
                  int var7 = Screen.hasShiftDown() ? 10 : 1;
                  var6.i_field_49 = Math.max(1, Math.min(IiiIiIiII_Class213.this.I_method_2dfbd275(var6), var6.i_field_49 + (var4 > 0.0F ? var7 : -var7)));
                  IiiIiIiII_Class213.this.Ii_field_49 = var5;
                  InventoryBuilderModule.Iii_method_1629dac3();
                  return true;
               }
            }
         } else {
            return false;
         }
      }
   }
}
