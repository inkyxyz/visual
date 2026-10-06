package rockstar.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import pyrock.events.window.MouseEvent;
import ua.mintantileak.spk.Compile;

public class iIIiIiiI_Class151 extends ii_Class4 implements iIIiIIiIi_Class294, iIIiIIiiI_Class295 {
   private static final float I_field_46 = 238.0F;
   private static final float i_field_46 = 223.0F;
   private static final float II_field_46 = 132.0F;
   private static final float Ii_field_46 = 5.0F;
   private int I_field_49;
   private int i_field_49;
   private iIIiIIii_Class148 I_field_88b781;
   private float iI_field_46;
   private float ii_field_46;
   private float III_field_46;
   private float IIi_field_46;
   private iIiIIiII_Class165 I_field_66c31ba1;
   private iIiIIiII_Class165 i_field_66c31ba1;
   private iIiIIiII_Class165 II_field_66c31ba1;
   private float IiI_field_46;
   private float Iii_field_46;
   private float iII_field_46;
   private float iIi_field_46;
   private float iiI_field_46;
   private float iii_field_46;
   private float IIII_field_46;
   private float IIIi_field_46;
   private float IIiI_field_46;
   private float IIii_field_46;
   private float IiII_field_46;
   private float IiIi_field_46;
   private float IiiI_field_46;
   private float Iiii_field_46;
   private final IiiiIiIii_Class236 I_field_dc7facc;
   private final IiiiIiIii_Class236 i_field_dc7facc;
   private final IiiiIiIii_Class236 II_field_dc7facc;
   private final IiiiIiIii_Class236 Ii_field_dc7facc;
   private final IiiiIiIii_Class236 iI_field_dc7facc;
   private final IiiiIiIii_Class236 ii_field_dc7facc;
   private final IiiiIiIii_Class236 III_field_dc7facc;
   private final IiiiIiIii_Class236 IIi_field_dc7facc;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private final List<iIIiiIii_Class156> I_field_7865b31;
   private final iIIiIIIii_Class292 I_field_107fb28c;
   private final iIIiIIIii_Class292 i_field_107fb28c;
   private final IiIiIIIII_Class161 I_field_fdef2cc;
   private final Map<iIiIIiII_Class165, iIIiiIIi_Class154> I_field_a567c40b;
   private final Map<iIiIIiII_Class165, IiiiIiIii_Class236> i_field_a567c40b;
   private final Map<iIIiIIii_Class148, IiiiIiIii_Class236> II_field_a567c40b;
   private final Map<iIiIIiII_Class165, iIIiIiii_Class152> Ii_field_a567c40b;
   private final Map<iIiIIiII_Class165, IiiiIiIii_Class236> iI_field_a567c40b;
   private final Map<iIiIIiII_Class165, IiiiIiIii_Class236> ii_field_a567c40b;
   private final Map<iIIiiIiI_Class155, IiiiIiIii_Class236> III_field_a567c40b;
   private final Map<iIiIIiII_Class165, IiiiIiIii_Class236> IIi_field_a567c40b;
   private final iIIiIIIi_Class146 I_field_883f61;
   private final iIIiIiIi_Class150 I_field_96cb41;
   private final iIIiiIII_Class153 I_field_24b2ba1;
   private final IiIIIiII_Class69<MouseEvent> I_field_3d936f41;

   public iIIiIiiI_Class151() {
      this.I_field_88b781 = iIIiIIii_Class148.I_field_88b781;
      this.I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
      this.i_field_dc7facc = new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
      this.II_field_dc7facc = new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
      this.Ii_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.IIIi_field_dd60aac);
      this.iI_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.IIIi_field_dd60aac);
      this.ii_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.IIIi_field_dd60aac);
      this.III_field_dc7facc = new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
      this.IIi_field_dc7facc = new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
      this.i_field_5a = true;
      this.I_field_7865b31 = new ArrayList<>();
      this.I_field_107fb28c = new iIIiIIIii_Class292();
      this.i_field_107fb28c = new iIIiIIIii_Class292();
      this.I_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F));
      this.I_field_a567c40b = new HashMap<>();
      this.i_field_a567c40b = new HashMap<>();
      this.II_field_a567c40b = new HashMap<>();
      this.Ii_field_a567c40b = new HashMap<>();
      this.iI_field_a567c40b = new HashMap<>();
      this.ii_field_a567c40b = new HashMap<>();
      this.III_field_a567c40b = new HashMap<>();
      this.IIi_field_a567c40b = new HashMap<>();
      this.I_field_883f61 = new iIIiIIIi_Class146();
      this.I_field_96cb41 = new iIIiIiIi_Class150();
      this.I_field_24b2ba1 = new iIIiiIII_Class153();
      this.I_field_3d936f41 = var1 -> {
         if (var1.getAction() == 1) {
            int var2 = var1.getButton();
            if (var2 >= 3) {
               if (this.II_field_66c31ba1 != null) {
                  this.II_field_66c31ba1.I_method_49deab77(iIIIIIIII_Class257.Ii_method_99f62a34(var2));
                  this.II_field_66c31ba1 = null;
               } else {
                  if (this.I_field_66c31ba1 != null) {
                     iIIiIiii_Class152 var3 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
                     if (var3 != null && var3.I_method_5ebc50b0()) {
                        var3.I_method_78ce37d7(iIIIIIIII_Class257.Ii_method_99f62a34(var2));
                        var3.I_method_78ce77a8(false);
                        return;
                     }
                  }

                  if (!this.I_field_5a) {
                     iIIiIiII_Class149 var4 = this.I_field_96cb41
                        .I_method_e1908d4b(
                           this.I_field_49,
                           this.i_field_49,
                           this.IiI_field_46,
                           this.Iii_field_46,
                           238.0F,
                           223.0F,
                           this.i_field_107fb28c,
                           this.I_field_88b781,
                           this.i_method_57ce1c1b()
                        );
                     if (var4 != null
                        && iIIiIIIiI_Class291.I_method_c3fabb03(
                           var4.iI_method_e1b2a845(),
                           var4.ii_method_e1c13425(),
                           var4.III_method_1e1645bc(),
                           var4.IIi_method_1e24d19c(),
                           this.I_field_49,
                           this.i_field_49
                        )) {
                        var4.I_method_b961b40b().I_method_49deab77(iIIIIIIII_Class257.Ii_method_99f62a34(var2));
                     }
                  }
               }
            }
         }
      };
   }

   private List<iIiIIiII_Class165> I_method_a281e3fb() {
      AssistModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
      return var1 == null ? List.of() : var1.II_method_6ba8ace5();
   }

   @Compile(
      obfuscation = 4
   )
   protected final void init() {
      this.I_field_5a = false;
      this.i_field_5a = true;
      this.I_field_fdef2cc.II_method_e557b20c("\u041f\u043e\u0438\u0441\u043a");
      this.I_method_28213ccc();
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
      super.init();
   }

   @Override
   public void render(III var1) {
      this.I_field_49 = var1.I_method_b1c3e152();
      this.i_field_49 = var1.i_method_b1d26d32();
      this.I_field_dc7facc.I_method_edd72835(true);
      this.i_method_282fc8ac();
      this.II_method_dc155415();
      this.ii_field_dc7facc.I_method_edd72835(this.I_field_5a);
      if (this.I_field_5a) {
         this.I_field_107fb28c.I_method_575ab23f();
      } else {
         this.i_field_107fb28c.I_method_575ab23f();
      }

      boolean var2 = this.I_field_66c31ba1 != null && !this.I_field_5a;
      this.Ii_field_dc7facc.I_method_edd72835(var2);
      if (this.I_field_66c31ba1 != null) {
         this.i_field_66c31ba1 = this.I_field_66c31ba1;
      }

      float var3 = 238.0F;
      if (var2 || this.Ii_field_dc7facc.I_method_6ac4da6f() > 0.01F) {
         var3 += 137.0F * this.Ii_field_dc7facc.I_method_6ac4da6f();
      }

      if (this.i_field_5a) {
         this.iI_field_dc7facc.I_method_edd6dd21(var3);
         this.i_field_5a = false;
      } else {
         this.iI_field_dc7facc.I_method_edd6dd11(var3);
      }

      float var4 = I_field_73c6d26c.I_method_804ee20f() / 2.0F;
      float var5 = this.iI_field_dc7facc.I_method_6ac4da6f();
      this.IiI_field_46 = var4 - var5 / 2.0F;
      this.Iii_field_46 = I_field_73c6d26c.i_method_805d6def() / 2.0F - 111.5F;
      iIiiiIIiI_Class371.II_method_e18635ac(
         var1.getMatrices(), this.IiI_field_46 + 119.0F, this.Iii_field_46 + 111.5F, 0.5F + 0.5F * this.I_field_dc7facc.I_method_6ac4da6f()
      );
      this.I_method_32f226a6(var1, this.IiI_field_46, this.Iii_field_46, 223.0F);
      float var6 = this.ii_field_dc7facc.I_method_6ac4da6f();
      float var7 = 1.0F - var6;
      if (var7 > 0.01F) {
         iIIiIiIi_Class150.Nested1_e31a113 var8 = this.I_field_96cb41
            .I_method_5a1b20c4(
               var1,
               this.IiI_field_46,
               this.Iii_field_46,
               238.0F,
               var7,
               this.I_field_dc7facc,
               this.I_field_88b781,
               this.II_field_a567c40b,
               this.i_field_dc7facc
            );
         this.iI_field_46 = var8.I_method_7c11677();
         this.ii_field_46 = var8.i_method_7cfa257();
         this.III_field_46 = var8.II_method_f070b1aa();
         this.IIi_field_46 = var8.Ii_method_f07f3d8a();
         this.I_field_96cb41
            .I_method_414139bb(
               var1,
               this.IiI_field_46,
               this.Iii_field_46,
               238.0F,
               223.0F,
               var7,
               this.I_field_dc7facc,
               this.i_field_107fb28c,
               this.I_field_88b781,
               this.i_method_57ce1c1b(),
               this.I_field_66c31ba1,
               this.II_field_66c31ba1,
               this.I_field_49,
               this.i_field_49,
               this.I_field_a567c40b,
               this.i_field_a567c40b,
               this.IIi_field_a567c40b,
               var1x -> this.I_method_ed1c835d(var1x) * this.i_method_2b1f73d(var1x)
            );
      }

      if (var6 > 0.01F) {
         iIIiIIIi_Class146.Nested1_c6eb0f3 var9 = this.I_field_883f61
            .I_method_ef600438(
               var1,
               this.IiI_field_46,
               this.Iii_field_46,
               238.0F,
               var6,
               this.I_field_dc7facc,
               this.IIi_field_dc7facc,
               this.III_field_dc7facc,
               this.I_field_fdef2cc
            );
         this.IiII_field_46 = var9.I_method_7e92f297();
         this.IiIi_field_46 = var9.i_method_7ea17e77();
         this.IiiI_field_46 = var9.II_method_53da598a();
         this.Iiii_field_46 = var9.Ii_method_53e8e56a();
         this.I_field_883f61
            .I_method_11523625(
               var1,
               this.IiI_field_46,
               this.Iii_field_46,
               238.0F,
               223.0F,
               var6,
               this.I_field_dc7facc,
               this.I_field_7865b31,
               this.I_field_107fb28c,
               this.III_field_a567c40b,
               this.I_field_fdef2cc,
               this::I_method_c8a38391
            );
      }

      iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
      if (this.Ii_field_dc7facc.I_method_6ac4da6f() > 0.01F) {
         this.I_method_8b7822da(var1);
      }
   }

   private void I_method_32f226a6(III var1, float var2, float var3, float var4) {
      float var5 = this.I_field_dc7facc.I_method_6ac4da6f();
      var1.drawShadow(var2, var3, 238.0F, var4, 25.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F * var5));
      var1.drawBlurredRect(var2, var3, 238.0F, var4, 5.0F, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(var5));
      var1.drawSquircle(var2, var3, 238.0F, var4, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(var5));
      var1.drawSquircleBorder(var2, var3, 238.0F, var4, 0.5F, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.IiI_field_d0c8ec5.mulAlpha(var5));
   }

   private void I_method_8b7822da(III var1) {
      if (!(this.Ii_field_dc7facc.I_method_6ac4da6f() <= 0.01F)) {
         iIiIIiII_Class165 var2 = this.I_field_66c31ba1 != null ? this.I_field_66c31ba1 : this.i_field_66c31ba1;
         if (var2 != null) {
            iIIiIiii_Class152 var3 = this.Ii_field_a567c40b.computeIfAbsent(var2, var1x -> new iIIiIiii_Class152(var1x, () -> this.II_method_78afa176(var1x)));
            iIIiiIII_Class153.Nested1_43094cd3 var4 = this.I_field_24b2ba1
               .I_method_c0d27454(
                  var1,
                  this.IiI_field_46,
                  this.Iii_field_46,
                  238.0F,
                  5.0F,
                  132.0F,
                  18.0F,
                  5.0F,
                  this.I_field_dc7facc,
                  this.Ii_field_dc7facc,
                  this.II_field_dc7facc,
                  var3,
                  var2,
                  this.I_method_ed1c835d(var2)
               );
            this.iII_field_46 = var4.I_method_559ec2b7();
            this.iIi_field_46 = var4.i_method_55ad4e97();
            this.iiI_field_46 = var4.II_method_5e488d6a();
            this.iii_field_46 = var4.Ii_method_5e57194a();
            this.IIII_field_46 = var4.iI_method_600b7d8a();
            this.IIIi_field_46 = var4.ii_method_601a096a();
            this.IIiI_field_46 = var4.III_method_6ad81917();
            this.IIii_field_46 = var4.IIi_method_6ae6a4f7();
         }
      }
   }

   public void tick() {
      GuiMoveModule.iII_method_9983ebf();
      super.tick();
   }

   public boolean shouldPause() {
      return false;
   }

   public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
   }

   public void close() {
      RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this);
      RockstarClient.getInstance().I_method_5198232b().II_method_1fbeeff5();
      super.close();
      MenuModule.IiI_method_c56c3e7f();
   }

   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (this.II_field_66c31ba1 != null) {
         this.II_field_66c31ba1.I_method_49deab77(iIIIIIIII_Class257.Ii_method_99f62a34(var5.I_method_6d899712()));
         this.II_field_66c31ba1 = null;
      } else {
         if (this.I_field_66c31ba1 != null) {
            iIIiIiii_Class152 var6 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
            if (var6 != null && var6.I_method_5ebc50b0()) {
               var6.I_method_78ce37d7(iIIIIIIII_Class257.Ii_method_99f62a34(var5.I_method_6d899712()));
               var6.I_method_78ce77a8(false);
               return;
            }
         }

         if (this.I_field_5a) {
            this.I_field_fdef2cc.I_method_400ceaa7(var1, var3, var5);
            if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
               if (iIIiIIIiI_Class291.I_method_c3fabb03(this.IiII_field_46, this.IiIi_field_46, this.IiiI_field_46, this.Iiii_field_46, (int)var1, (int)var3)) {
                  this.I_field_5a = false;
                  return;
               }

               iIIiiiII_Class157 var15 = this.I_field_883f61
                  .I_method_194485ed(
                     (float)var1,
                     (float)var3,
                     this.IiI_field_46,
                     this.Iii_field_46,
                     238.0F,
                     223.0F,
                     this.I_field_107fb28c,
                     this.I_field_7865b31,
                     this.I_field_fdef2cc,
                     this::I_method_c8a38391
                  );
               if (var15 != null) {
                  iIiIIiII_Class165 var16 = var15.I_method_f8e2c00b().I_method_a86ab3ab();
                  if (var16 != null && this.I_method_a281e3fb().stream().noneMatch(var1x -> var1x.I_method_cca0c514().equals(var16.I_method_cca0c514()))) {
                     this.I_method_a281e3fb().add(var16);
                     this.I_method_ed1c836d(var16);
                  }
               }
            }
         } else {
            IIiIIi_Class10 var14 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
            float var7 = this.IiI_field_46 + 7.0F;
            float var8 = this.Iii_field_46 + 24.0F;

            for (iIIiIIii_Class148 var12 : iIIiIIii_Class148.values()) {
               float var13 = var14.I_method_2c375926(var12.I_method_dca1f154()) + 8.0F;
               if (iIIiIIIiI_Class291.I_method_c3fabb03(var7, var8, var13, 13.0, (int)var1, (int)var3)) {
                  this.I_field_88b781 = var12;
                  this.i_field_107fb28c.II_method_ed47737c(0.0);
                  this.I_field_66c31ba1 = null;
                  break;
               }

               var7 += var13 + 4.0F;
            }

            if (var5 == IiIII_Class9.i_field_2f4c8d6c) {
               iIIiIiII_Class149 var17 = this.I_field_96cb41
                  .I_method_e1908d4b(
                     (float)var1,
                     (float)var3,
                     this.IiI_field_46,
                     this.Iii_field_46,
                     238.0F,
                     223.0F,
                     this.i_field_107fb28c,
                     this.I_field_88b781,
                     this.i_method_57ce1c1b()
                  );
               if (var17 != null) {
                  if (iIIiIIIiI_Class291.I_method_c3f86263(
                     var17.iI_method_e1b2a845(), var17.ii_method_e1c13425(), var17.III_method_1e1645bc(), var17.IIi_method_1e24d19c(), var1, var3
                  )) {
                     var17.I_method_b961b40b().I_method_49deab77(-1);
                     return;
                  }

                  this.i_method_2b1f74d(var17.I_method_b961b40b());
                  return;
               }
            }

            if (this.I_field_66c31ba1 != null
               && iIIiIIIiI_Class291.I_method_c3f86263(this.iII_field_46, this.iIi_field_46, this.iiI_field_46, this.iii_field_46, var1, var3)) {
               iIIiIiii_Class152 var19 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
               if (var19 != null) {
                  if (var5 == IiIII_Class9.I_field_2f4c8d6c
                     && iIIiIIIiI_Class291.I_method_c3f86263(this.IIII_field_46, this.IIIi_field_46, this.IIiI_field_46, this.IIii_field_46, var1, var3)) {
                     var19.I_method_78ce77a8(true);
                     return;
                  }

                  if (var5 == IiIII_Class9.i_field_2f4c8d6c
                     && iIIiIIIiI_Class291.I_method_c3f86263(this.IIII_field_46, this.IIIi_field_46, this.IIiI_field_46, this.IIii_field_46, var1, var3)) {
                     var19.I_method_78ce37d7(-1);
                     var19.I_method_78ce77a8(false);
                     return;
                  }

                  for (IiiIiiIii_Class220 var21 : var19.I_method_35a0941b()) {
                     var21.I_method_400ceaa7(var1, var3, var5);
                  }
               }
            } else {
               iIIiIiII_Class149 var18 = this.I_field_96cb41
                  .I_method_e1908d4b(
                     (float)var1,
                     (float)var3,
                     this.IiI_field_46,
                     this.Iii_field_46,
                     238.0F,
                     223.0F,
                     this.i_field_107fb28c,
                     this.I_field_88b781,
                     this.i_method_57ce1c1b()
                  );
               if (var18 != null) {
                  if (iIIiIIIiI_Class291.I_method_c3f86263(
                     var18.iI_method_e1b2a845(), var18.ii_method_e1c13425(), var18.III_method_1e1645bc(), var18.IIi_method_1e24d19c(), var1, var3
                  )) {
                     if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
                        this.II_field_66c31ba1 = var18.I_method_b961b40b();
                     } else if (var5 != IiIII_Class9.i_field_2f4c8d6c) {
                        var18.I_method_b961b40b().I_method_49deab77(iIIIIIIII_Class257.Ii_method_99f62a34(var5.I_method_6d899712()));
                     }
                  } else {
                     if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
                        this.i_method_2b1f74d(var18.I_method_b961b40b());
                     }
                  }
               } else if (var5 == IiIII_Class9.I_field_2f4c8d6c
                  && iIIiIIIiI_Class291.I_method_c3fabb03(this.iI_field_46, this.ii_field_46, this.III_field_46, this.IIi_field_46, (int)var1, (int)var3)) {
                  this.I_field_66c31ba1 = null;
                  this.I_field_5a = true;
                  this.I_field_107fb28c.II_method_ed47737c(0.0);
                  this.I_field_fdef2cc.I_method_1d5afa89("");
                  this.I_method_28213ccc();
               } else {
                  super.onMouseClicked(var1, var3, var5);
               }
            }
         }
      }
   }

   @Override
   public void onMouseReleased(double var1, double var3, IiIII_Class9 var5) {
      if (this.I_field_5a) {
         this.I_field_fdef2cc.i_method_6a097ac7(var1, var3, var5);
      }

      if (this.I_field_66c31ba1 != null) {
         iIIiIiii_Class152 var6 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
         if (var6 != null) {
            for (IiiIiiIii_Class220 var8 : var6.I_method_35a0941b()) {
               var8.i_method_6a097ac7(var1, var3, var5);
            }
         }
      }

      super.onMouseReleased(var1, var3, var5);
   }

   public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
      if (this.I_field_5a) {
         this.I_field_107fb28c.I_method_93fbf5df(verticalAmount);
         return true;
      } else if (iIIiIIIiI_Class291.I_method_c3fabb03(this.IiI_field_46, this.Iii_field_46, 238.0, 223.0, (int)mouseX, (int)mouseY)) {
         this.i_field_107fb28c.I_method_93fbf5df(verticalAmount);
         return true;
      } else {
         if (this.I_field_66c31ba1 != null
            && iIIiIIIiI_Class291.I_method_c3f86263(this.iII_field_46, this.iIi_field_46, this.iiI_field_46, this.iii_field_46, mouseX, mouseY)) {
            iIIiIiii_Class152 var9 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
            if (var9 != null) {
               for (IiiIiiIii_Class220 var11 : var9.I_method_35a0941b()) {
                  var11.I_method_6b0ad25f(mouseX, mouseY, horizontalAmount, verticalAmount);
               }

               return true;
            }
         }

         return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
      }
   }

   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
      if (this.II_field_66c31ba1 == null && !this.I_method_28213cd0()) {
         if (Screen.hasControlDown() && keyCode == 90 && IIiiiIIIi_Class114.I_method_fe3ce603()) {
            return true;
         }

         if (Screen.hasControlDown() && keyCode == 89 && IIiiiIIIi_Class114.i_method_fe4b71e3()) {
            return true;
         }
      }

      if (this.II_field_66c31ba1 != null) {
         if (keyCode == 256) {
            this.II_field_66c31ba1 = null;
         } else if (keyCode == 261) {
            this.II_field_66c31ba1.I_method_49deab77(-1);
            this.II_field_66c31ba1 = null;
         } else {
            int var7 = iIIIIIIII_Class257.i_method_cd0c4692(keyCode, modifiers);
            if (var7 == Integer.MIN_VALUE) {
               return true;
            }

            this.II_field_66c31ba1.I_method_49deab77(var7);
            this.II_field_66c31ba1 = null;
         }

         return true;
      } else if (this.I_field_5a) {
         if (this.I_field_fdef2cc.I_method_189fd283()) {
            if (keyCode == 256) {
               this.I_field_fdef2cc.I_method_fb5b3035(false);
               return true;
            } else {
               this.I_field_fdef2cc.I_method_c1acbc24(keyCode, scanCode, modifiers);
               return true;
            }
         } else if (keyCode == 256) {
            this.I_field_5a = false;
            return true;
         } else {
            return super.keyPressed(keyCode, scanCode, modifiers);
         }
      } else {
         if (this.I_field_66c31ba1 != null) {
            iIIiIiii_Class152 var4 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
            if (var4 != null && var4.I_method_5ebc50b0()) {
               if (keyCode == 256) {
                  var4.I_method_78ce77a8(false);
               } else if (keyCode == 261) {
                  var4.I_method_78ce37d7(-1);
                  var4.I_method_78ce77a8(false);
               } else {
                  int var8 = iIIIIIIII_Class257.i_method_cd0c4692(keyCode, modifiers);
                  if (var8 == Integer.MIN_VALUE) {
                     return true;
                  }

                  var4.I_method_78ce37d7(var8);
                  var4.I_method_78ce77a8(false);
               }

               return true;
            }

            if (var4 != null) {
               for (IiiIiiIii_Class220 var6 : var4.I_method_35a0941b()) {
                  var6.I_method_c1acbc24(keyCode, scanCode, modifiers);
               }
            }
         }

         return super.keyPressed(keyCode, scanCode, modifiers);
      }
   }

   public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
      int var4 = iIIIIIIII_Class257.II_method_6e347cf5(keyCode, modifiers);
      if (var4 != Integer.MIN_VALUE) {
         if (this.II_field_66c31ba1 != null) {
            this.II_field_66c31ba1.I_method_49deab77(var4);
            this.II_field_66c31ba1 = null;
            return true;
         }

         if (this.I_field_66c31ba1 != null) {
            iIIiIiii_Class152 var5 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
            if (var5 != null && var5.I_method_5ebc50b0()) {
               var5.I_method_78ce37d7(var4);
               var5.I_method_78ce77a8(false);
               return true;
            }
         }
      }

      return super.keyReleased(keyCode, scanCode, modifiers);
   }

   private boolean I_method_28213cd0() {
      if (this.I_field_66c31ba1 == null) {
         return false;
      } else {
         iIIiIiii_Class152 var1 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
         return var1 != null && var1.I_method_5ebc50b0();
      }
   }

   public boolean charTyped(char chr, int modifiers) {
      if (this.I_field_5a && this.I_field_fdef2cc.I_method_b71e84c9(chr, modifiers)) {
         return true;
      } else {
         if (this.I_field_66c31ba1 != null) {
            iIIiIiii_Class152 var3 = this.Ii_field_a567c40b.get(this.I_field_66c31ba1);
            if (var3 != null) {
               for (IiiIiiIii_Class220 var5 : var3.I_method_35a0941b()) {
                  if (var5.I_method_b71e84c9(chr, modifiers)) {
                     return true;
                  }
               }
            }
         }

         return super.charTyped(chr, modifiers);
      }
   }

   private List<iIiIIiII_Class165> i_method_57ce1c1b() {
      ArrayList<iIiIIiII_Class165> var1 = new ArrayList<>(this.I_method_a281e3fb());
      var1.removeIf(var0 -> !var0.I_method_75fee910());
      return var1;
   }

   private boolean I_method_c8a38391(iIIiiIiI_Class155 var1) {
      iIiIIiII_Class165 var2 = var1.I_method_a86ab3ab();
      return var2 == null ? false : this.I_method_a281e3fb().stream().anyMatch(var1x -> var1x.I_method_cca0c514().equals(var2.I_method_cca0c514()));
   }

   private void I_method_28213ccc() {
      this.I_field_7865b31.clear();
      AssistModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AssistModule.class);
      Object var2 = var1 == null ? new ArrayList() : var1.i_method_78846a68();

      for (iIIiIIii_Class148 var6 : iIIiIIii_Class148.values()) {
         if (var6 != iIIiIIii_Class148.I_field_88b781) {
            ArrayList var7 = new ArrayList();

            for (iIiIIiII_Class165 var9 : (Iterable<iIiIIiII_Class165>)(Iterable<?>)var2) {
               if (var9.I_method_e81fe78b() == var6 && var9.I_method_75fee910()) {
                  var7.add(
                     new iIIiiIiI_Class155(
                        var9, IiIiIIII_Class81.I_method_f25a980a(var9.I_method_cca0c514()), var9.I_method_db7f702c(), var9.I_method_75fee8ff()
                     )
                  );
               }
            }

            if (!var7.isEmpty()) {
               this.I_field_7865b31.add(new iIIiiIii_Class156(var6.I_method_dca1f154(), var7));
            }
         }
      }
   }

   private void i_method_2b1f74d(iIiIIiII_Class165 var1) {
      this.I_field_66c31ba1 = var1;
      this.Ii_field_a567c40b.computeIfAbsent(var1, var1x -> new iIIiIiii_Class152(var1x, () -> this.II_method_78afa176(var1x)));
   }

   private void II_method_78afa176(iIiIIiII_Class165 var1) {
      if (var1 != null) {
         IiiiIiIii_Class236 var2 = this.iI_field_a567c40b
            .computeIfAbsent(var1, var0 -> new IiiiIiIii_Class236(200L, 1.0F, IiiiIiiII_Class237.III_field_dd60aac));
         var2.I_method_edd6dd21(1.0F);
         var2.I_method_edd6dd11(0.0F);
      }
   }

   private void i_method_282fc8ac() {
      if (!this.iI_field_a567c40b.isEmpty()) {
         ArrayList var1 = new ArrayList();

         for (Entry var3 : this.iI_field_a567c40b.entrySet()) {
            IiiiIiIii_Class236 var4 = (IiiiIiIii_Class236)var3.getValue();
            var4.I_method_edd6dd11(0.0F);
            if (var4.I_method_6ac4da83() && var4.I_method_6ac4da6f() <= 0.01F) {
               var1.add((iIiIIiII_Class165)var3.getKey());
            }
         }

         for (iIiIIiII_Class165 var6 : (Iterable<iIiIIiII_Class165>)(Iterable<?>)var1) {
            this.I_method_a281e3fb().remove(var6);
            this.Ii_field_a567c40b.remove(var6);
            this.i_field_a567c40b.remove(var6);
            this.I_field_a567c40b.remove(var6);
            this.iI_field_a567c40b.remove(var6);
            if (this.I_field_66c31ba1 == var6) {
               this.I_field_66c31ba1 = null;
               IiiiIiIII_Class233.i_method_9770ea5f();
            }
         }
      }
   }

   private float I_method_ed1c835d(iIiIIiII_Class165 var1) {
      IiiiIiIii_Class236 var2 = this.iI_field_a567c40b.get(var1);
      return var2 == null ? 1.0F : var2.I_method_6ac4da6f();
   }

   private void II_method_dc155415() {
      if (!this.ii_field_a567c40b.isEmpty()) {
         ArrayList var1 = new ArrayList();

         for (Entry var3 : this.ii_field_a567c40b.entrySet()) {
            IiiiIiIii_Class236 var4 = (IiiiIiIii_Class236)var3.getValue();
            var4.I_method_edd6dd11(1.0F);
            if (var4.I_method_6ac4da83() && var4.I_method_6ac4da6f() >= 0.99F) {
               var1.add((iIiIIiII_Class165)var3.getKey());
            }
         }

         for (iIiIIiII_Class165 var6 : (Iterable<iIiIIiII_Class165>)(Iterable<?>)var1) {
            this.ii_field_a567c40b.remove(var6);
         }
      }
   }

   private float i_method_2b1f73d(iIiIIiII_Class165 var1) {
      IiiiIiIii_Class236 var2 = this.ii_field_a567c40b.get(var1);
      return var2 == null ? 1.0F : var2.I_method_6ac4da6f();
   }

   public void I_method_ed1c836d(iIiIIiII_Class165 var1) {
      IiiiIiIii_Class236 var2 = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.IIIi_field_dd60aac);
      this.ii_field_a567c40b.put(var1, var2);
      this.I_method_28213ccc();
   }
}
