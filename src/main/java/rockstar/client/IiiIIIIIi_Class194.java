package rockstar.client;

import dev.redstones.mediaplayerinfo.IMediaSession;
import dev.redstones.mediaplayerinfo.MediaInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.util.Identifier;
import pyrock.events.window.MouseScrollEvent;
import pyrock.utility.render.ColorRGBA;

public class IiiIIIIIi_Class194 extends IiIiiIIii_Class180 implements iIIiIIiIi_Class294 {
   private static final float I_field_46 = 0.5F;
   private static final float i_field_46 = 164.0F;
   private static final float II_field_46 = 80.0F;
   private static final float Ii_field_46 = 125.0F;
   private static final float iI_field_46 = 15.0F;
   private static final float ii_field_46 = 144.0F;
   private static final float III_field_46 = 32.0F;
   private static final float IIi_field_46 = 0.7F;
   private static final float IiI_field_46 = 16.0F;
   private static final float Iii_field_46 = 8.0F;
   private static final float iII_field_46 = 3.0F;
   private static final String I_field_523beb0a = "lyrics-expansion";
   private static final float iIi_field_46 = 95.0F;
   private static final float iiI_field_46 = 7.0F;
   private static final long I_field_4a = 3000L;
   private static final float[] I_field_b4b = new float[]{1.0F, 2.0F, 0.5F, 1.5F};
   private static final float[] i_field_b4b = new float[]{3.0F, 1.5F, 2.5F, 4.0F};
   private static final float[] II_field_b4b = new float[]{0.0F, 1.9F, 4.2F, 2.7F};
   final float[] Ii_field_b4b = new float[4];
   private long i_field_4a = System.currentTimeMillis();
   final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(600L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
   float iii_field_46;
   int I_field_49 = 0;
   float IIII_field_46 = -1.0F;
   long II_field_4a;
   float IIIi_field_46;
   private iii_Class8 I_field_b584628c;
   private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(260L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
   int i_field_49 = -1;
   String i_field_523beb0a = "";
   float IIiI_field_46;
   private final IiIIIiII_Class69<MouseScrollEvent> I_field_3d936f41 = var1x -> {
      if (this.i_method_a8e7c603()) {
         IiIiiIIII_Class177 var2 = RockstarClient.getInstance().I_method_35687482().I_method_35128395();
         if (var2 != null && var2.I_method_fc091b55() == this && var2.II_method_97ffcce6()) {
            Vector2f var3 = iIIiIIIiI_Class291.I_method_81637b4f();
            if (iIIiIIIiI_Class291.I_method_c3f86263(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight(), var3.getX(), var3.getY())) {
               iiIiIIIii_Class420 var4 = this.I_method_8207af55().I_method_655c2f95();
               if (!var4.i_method_27ca0e43()) {
                  if (var1x.getVerticalAmount() < 0.0) {
                     this.I_field_49++;
                  } else {
                     if (!(var1x.getVerticalAmount() > 0.0)) {
                        return;
                     }

                     this.I_field_49--;
                  }

                  int var5 = Math.max(0, var4.I_method_13376608().size() - 6);
                  this.I_field_49 = Math.clamp((long)this.I_field_49, 0, var5);
               }
            }
         }
      }
   };

   public IiiIIIIIi_Class194(MultiSelectSetting var1) {
      super(var1, "music");
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   @Override
   public void prepare(IiIiiIIII_Class177 var1) {
      this.I_method_a8d93a1f();
   }

   @Override
   public iiI_Class7 content(IiIiiIIII_Class177 var1) {
      return this.I_method_31f4d89d(var1);
   }

   public iii_Class8 I_method_31f4d89d(IiIiiIIII_Class177 var1) {
      if (this.I_field_b584628c == null) {
         this.I_field_b584628c = new IiiIIIIIi_Class194.Nested1_cb9f6560(var1);
      }

      return this.I_field_b584628c;
   }

   public Identifier I_method_10b2192e() {
      Identifier var1 = this.I_method_8207af55().I_method_2b1658e();
      return var1 != null ? var1 : RockstarClient.id("icons/music/no_image.png");
   }

   public String I_method_28665c61() {
      float var1 = this.I_method_8207af55().I_method_f1206e6f();
      return var1 > 0.0F ? String.valueOf(Math.round(var1)) : "--";
   }

   public ColorRGBA I_method_e924648e() {
      return this.I_method_8207af55().I_method_588218ee();
   }

   public float[] I_method_724e0aa2() {
      this.i_method_a8e7c5ff();
      return this.Ii_field_b4b;
   }

   IiiIIIIIi_Class194.Nested1_cb9f61a0 I_method_48af91a6(BooleanSupplier var1, Runnable var2, IiiIIIIIi_Class194.Nested1_50e41be9 var3) {
      return this.I_method_4f3b2c08(16.0F, var1, var2, var3);
   }

   IiiIIIIIi_Class194.Nested1_cb9f61a0 I_method_4f3b2c08(float var1, BooleanSupplier var2, Runnable var3, IiiIIIIIi_Class194.Nested1_50e41be9 var4) {
      IiiIIIIIi_Class194.Nested1_cb9f61a0 var5 = new IiiIIIIIi_Class194.Nested1_cb9f61a0(var2);
      var5.size(var1, var1);
      var5.onClick(var3);
      var5.paint((var2x, var3x) -> var4.paint(var2x, var5));
      return var5;
   }

   @Override
   public boolean canShow() {
      IMediaSession var1 = this.I_method_be00a51b();
      if (var1 == null) {
         return false;
      } else {
         String var2 = var1.getOwner();
         return var2 == null || !var2.toLowerCase(Locale.ROOT).contains("gram");
      }
   }

   @Override
   public ColorRGBA getColor() {
      return IiiiiIIIi_Class242.I_method_5ac4a715().Iii_method_c52ede8f() == 1.0F
         ? super.getColor().mix(this.I_method_8207af55().I_method_588218ee(), 0.2F)
         : super.getColor();
   }

   iiIiIIIiI_Class419 I_method_8207af55() {
      return RockstarClient.getInstance().I_method_be969482();
   }

   IMediaSession I_method_be00a51b() {
      iiIiIIIiI_Class419 var1 = this.I_method_8207af55();
      return !var1.I_method_f1206e83() ? null : var1.I_method_9b92c97b();
   }

   MediaInfo I_method_329ae7e4() {
      IMediaSession var1 = this.I_method_be00a51b();
      return var1 == null ? null : var1.getMedia();
   }

   String I_method_a1d802ed(Function<MediaInfo, String> var1) {
      MediaInfo var2 = this.I_method_329ae7e4();
      if (var2 == null) {
         return "";
      } else {
         String var3 = (String)var1.apply(var2);
         return var3 == null ? "" : var3;
      }
   }

   float I_method_daf57506(MediaInfo var1) {
      float var2 = this.i_field_49 >= 0 ? 127.0F : 144.0F;
      return Math.max(48.0F, Math.min(this.i_method_2f0dc526(var1), var2));
   }

   private float i_method_2f0dc526(MediaInfo var1) {
      if (this.i_field_49 >= 0) {
         return 32.0F + IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F).I_method_2c375926(this.i_field_523beb0a) + 6.0F;
      } else {
         String var2 = var1.getTitle();
         return 32.0F + IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F).I_method_2c375926(var2 == null ? "" : var2);
      }
   }

   private void I_method_a8d93a1f() {
      MediaInfo var1 = this.I_method_329ae7e4();
      iiIiIIIii_Class420 var2 = this.I_method_8207af55().I_method_655c2f95();
      int var3 = -1;
      if (var1 != null && var1.isPlaying() && var2.i_method_27ca0e43() && this.i_method_a8e7c603()) {
         double var4 = this.I_method_8207af55().I_method_f1206e6d() * 1000.0 + 150.0;
         long var6 = var1.getDuration() * 1000L;
         var3 = var2.I_method_b7208e72(var4, var6, 3000L);
         if (var3 >= 0) {
            this.i_field_523beb0a = var2.I_method_13376608().get(var3).I_method_257c66();
            this.IIiI_field_46 = var2.i_method_542bb1da(var3, var4, var6);
         }
      }

      this.i_field_49 = var3;
      this.II_field_dc7facc.I_method_edd72835(var3 >= 0);
   }

   float I_method_a8d93a0f() {
      return this.II_field_dc7facc.I_method_6ac4da6f() * (1.0F - this.II_method_725d0112());
   }

   float i_method_a8e7c5ef() {
      return this.II_method_725d0126() ? 125.0F : 80.0F;
   }

   boolean I_method_a8d93a23() {
      return !this.I_method_8207af55().I_method_655c2f95().I_method_27bb8263();
   }

   boolean i_method_a8e7c603() {
      IiIiiIIII_Class177 var1 = RockstarClient.getInstance().I_method_35687482().I_method_35128395();
      return var1 == null || var1.I_method_6fa0d715().i_method_9b12da03();
   }

   void I_method_724ebc95(boolean var1) {
      IiIiiIIII_Class177 var2 = RockstarClient.getInstance().I_method_35687482().I_method_35128395();
      if (var2 != null) {
         var2.I_method_6fa0d715().I_method_4e1408b5(var1);
         if (var1) {
            this.I_field_49 = 0;
         }

         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
      }
   }

   boolean II_method_725d0126() {
      return this.i_method_a8e7c603() && this.I_method_a8d93a23();
   }

   float II_method_725d0112() {
      IiIiiIIII_Class177 var1 = RockstarClient.getInstance().I_method_35687482().I_method_35128395();
      return var1 == null ? 0.0F : var1.I_method_c3480795().I_method_6ac4da6f();
   }

   float Ii_method_726b8cf2() {
      return this.IIIi_field_46;
   }

   String i_method_bb850c81() {
      IMediaSession var1 = this.I_method_be00a51b();
      if (var1 != null && var1.getOwner() != null) {
         String var2 = var1.getOwner().toLowerCase(Locale.ROOT);
         if (var2.contains("yandex") || var2.contains("\u044f\u043d\u0434\u0435\u043a\u0441")) {
            return "yandex_music";
         } else if (var2.contains("edge")) {
            return "edge";
         } else {
            return var2.contains("spotify") ? "spotify" : null;
         }
      } else {
         return null;
      }
   }

   String II_method_e9bf1bbe() {
      return Math.round(this.iii_field_46 * this.i_field_dc7facc.I_method_6ac4da6f()) + " BPM";
   }

   float iI_method_741ff132() {
      MediaInfo var1 = this.I_method_329ae7e4();
      if (var1 != null && var1.isPlaying()) {
         float var2 = this.I_method_8207af55().I_method_f1206e6f();
         float var3 = var2 > 0.0F ? var2 : 120.0F;
         double var4 = this.I_method_8207af55().I_method_f1206e6d() * var3 / 60.0;
         return (float)Math.pow(1.0 - (var4 - Math.floor(var4)), 4.0);
      } else {
         return 0.0F;
      }
   }

   void i_method_a8e7c5ff() {
      MediaInfo var1 = this.I_method_329ae7e4();
      if (var1 != null) {
         float var2 = this.I_method_8207af55().I_method_f1206e6f();
         float var3 = var2 > 0.0F ? var2 : 120.0F;
         double var4 = this.I_method_8207af55().I_method_f1206e6d() * var3 / 60.0;
         long var6 = System.currentTimeMillis();
         float var8 = Math.min((float)(var6 - this.i_field_4a) / 1000.0F, 0.05F);
         this.i_field_4a = var6;

         for (int var9 = 0; var9 < this.Ii_field_b4b.length; var9++) {
            float var10;
            if (var1.isPlaying()) {
               double var11 = var4 - var9 * 0.05;
               float var13 = (float)(var11 - Math.floor(var11));
               float var14 = (float)Math.pow(1.0F - var13, 6.0) * 4.0F;
               float var15 = var13 >= 0.5F ? (float)Math.pow(1.0F - (var13 - 0.5F) * 2.0F, 6.0) * 1.6F : 0.0F;
               float var16 = (float)(
                  Math.abs(iIIiiiiiI_Class319.I_method_a586e9cd(var11 * Math.PI * I_field_b4b[var9] + II_field_b4b[var9])) * 0.65
                     + Math.abs(iIIiiiiiI_Class319.I_method_a586e9cd(var11 * Math.PI * i_field_b4b[var9] + II_field_b4b[var9] * 1.7)) * 0.35
               );
               float var17 = 0.5F + 0.5F * (float)iIIiiiiiI_Class319.I_method_a586e9cd(var11 * Math.PI * 0.25 + var9 * 2.1);
               var10 = Math.min(1.2F + var16 * (2.2F + 2.6F * var17) + (var14 + var15) * (0.7F + 0.3F * var17), 10.0F);
            } else {
               var10 = 3.0F;
            }

            float var18 = var10 > this.Ii_field_b4b[var9] ? 45.0F : 9.0F;
            this.Ii_field_b4b[var9] = this.Ii_field_b4b[var9] + (var10 - this.Ii_field_b4b[var9]) * Math.min(1.0F, var8 * var18);
         }
      }
   }

   static float I_method_18850d31(float var0, float var1, float var2) {
      if (var2 <= var1) {
         return var0 >= var2 ? 1.0F : 0.0F;
      } else {
         float var3 = I_method_724e7171((var0 - var1) / (var2 - var1));
         return IiiiIiiII_Class237.IIII_field_dd60aac.ease(var3, 0.0F, 1.0F, 1.0F);
      }
   }

   static float I_method_724e7171(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }

   static float i_method_b54c7551(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * I_method_724e7171(var2);
   }

   public static String I_method_d85eebb(long var0) {
      long var2 = var0 / 60L;
      long var4 = var0 % 60L;
      return String.format("%d:%02d", var2, var4);
   }

   interface Nested1_50e41be9 {
      void paint(III var1, IiiIIIIIi_Class194.Nested1_cb9f61a0 var2);
   }

   final class Nested1_50e41c09 extends iiI_Class7 {
      private static final float I_field_46 = 240.0F;
      private static final float i_field_46 = 16.0F;
      private static final float II_field_46 = 320.0F;
      private static final float Ii_field_46 = 0.13F;
      private static final float iI_field_46 = 3.0F;
      private static final float ii_field_46 = 0.42F;
      private static final float III_field_46 = 9.0F;
      private static final float IIi_field_46 = 5.0F;
      private static final float IiI_field_46 = 180.0F;
      private static final float Iii_field_46 = 220.0F;
      private static final float iII_field_46 = 6.0F;
      private static final float iIi_field_46 = 90.0F;
      private final IIiIIi_Class10 I_field_856d0221 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
      private IiiIIIIIi_Class194.Nested1_50e41fe9 I_field_fee2d0a6;
      private IiiIIIIIi_Class194.Nested1_50e41fe9 i_field_fee2d0a6;
      private int I_field_49 = -1;
      private String I_field_523beb0a = "";
      private long I_field_4a = System.currentTimeMillis();

      Nested1_50e41c09() {
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         long var3 = System.currentTimeMillis();
         float var5 = Math.min(0.05F, Math.max(0.0F, (float)(var3 - this.I_field_4a) / 1000.0F));
         this.I_field_4a = var3;
         this.I_method_730e1b93(var3);
         float var6 = IiiIIIIIi_Class194.this.I_method_a8d93a0f();
         if (!(var6 <= 0.003F)) {
            float var7 = Math.max(1.0F, this.w());
            if (this.i_field_fee2d0a6 != null) {
               if ((float)(var3 - this.i_field_fee2d0a6.i_field_4a) >= 400.0F) {
                  this.i_field_fee2d0a6 = null;
               } else {
                  this.I_method_274d1658(var1, this.i_field_fee2d0a6, -1, var6, var7, var3, true);
               }
            }

            if (this.I_field_fee2d0a6 != null) {
               int var8 = this.I_method_4927656a(this.I_field_fee2d0a6);
               this.I_method_9cf238d4(this.I_field_fee2d0a6, var8, var5);
               this.I_method_49276577(this.I_field_fee2d0a6);
               this.I_method_12c6006(this.I_field_fee2d0a6, var7, var8, var5);
               this.I_field_fee2d0a6.iI_field_46 = this.I_method_49276567(this.I_field_fee2d0a6);
               this.I_method_274d1658(var1, this.I_field_fee2d0a6, var8, var6, var7, var3, false);
            }
         }
      }

      private void I_method_274d1658(III var1, IiiIIIIIi_Class194.Nested1_50e41fe9 var2, int var3, float var4, float var5, long var6, boolean var8) {
         if (var2.I_method_141a6d64() != 0) {
            float var9 = Math.min(16.0F, (var8 ? 220.0F : 320.0F) / var2.I_field_6dccaaa5.length);
            float var10 = (float)(var6 - (var8 ? var2.i_field_4a : var2.I_field_4a));
            if (!(var10 <= 0.0F)) {
               iIiiiIiII_Class373.I_method_d5a5ee51(
                  var1.getMatrices(),
                  this.x() - 1.0F,
                  this.y() - 1.5F,
                  var5 + 2.0F,
                  this.I_field_856d0221.I_method_a649725c() + this.I_field_856d0221.Ii_method_23025e45() + 3.0F
               );

               for (int var11 = 0; var11 < var2.I_method_141a6d64(); var11++) {
                  this.I_method_b8247179(var1, var2, var11, var3, var4, var10, var9, var5, var8);
               }

               iIiiiIiII_Class373.I_method_ff80a1df();
            }
         }
      }

      private void I_method_b8247179(
         III var1, IiiIIIIIi_Class194.Nested1_50e41fe9 var2, int var3, int var4, float var5, float var6, float var7, float var8, boolean var9
      ) {
         float var10 = var2.Ii_field_b4b[var3];
         float var11 = var2.iI_field_b4b[var3];
         float var12 = (var10 - 1.0F) * 3.0F;
         boolean var13 = Math.abs(var10 - 1.0F) > 0.002F;
         if (var13) {
            iIiiiIIiI_Class371.II_method_e18635ac(
               var1.getMatrices(),
               this.x() - var2.II_field_46 + var11 + (var2.i_field_b4b[var3] + var2.II_field_b4b[var3]) / 2.0F,
               this.y() + this.I_field_856d0221.I_method_a649725c() / 2.0F,
               var10
            );
         }

         ColorRGBA var14 = IiiiiIIIi_Class242.iI_method_8e08d3b1();
         boolean var15 = var2.iI_field_46 <= var2.i_field_b4b[var3] || var2.iI_field_46 >= var2.II_field_b4b[var3];
         boolean var16 = !var9 && var6 - var2.i_field_b4e[var3] * var7 >= 240.0F;
         if (var15 && var16 && var2.I_field_46 <= var8) {
            float var25 = var2.iI_field_46 >= var2.II_field_b4b[var3] ? 1.0F : 0.42F;
            var1.drawText(
               this.I_field_856d0221,
               var2.i_field_6dccaaa5[var3],
               this.x() - var2.II_field_46 + var11 + var2.i_field_b4b[var3],
               this.y() - var12,
               var14.withAlpha(255.0F * var5 * var25)
            );
            if (var13) {
               iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            }
         } else {
            for (int var17 = var2.I_field_b4e[var3]; var17 <= var2.i_field_b4e[var3]; var17++) {
               float var18 = var9
                  ? 1.0F - IiiIIIIIi_Class194.I_method_724e7171((var6 - var17 * var7) / 180.0F)
                  : IiiIIIIIi_Class194.I_method_724e7171((var6 - var17 * var7) / 240.0F);
               if (!(var18 <= 0.001F)) {
                  float var19 = IiiiIiiII_Class237.IIII_field_dd60aac.ease(var18, 0.0F, 1.0F, 1.0F);
                  float var20 = this.x() - var2.II_field_46 + var11 + var2.I_field_b4b[var17];
                  float var21 = this.I_method_9cf0dba7(var2, var20, var8);
                  if (!(var21 <= 0.001F)) {
                     float var22 = IiiIIIIIi_Class194.I_method_724e7171(
                        (var2.iI_field_46 - var2.I_field_b4b[var17]) / Math.max(0.5F, var2.I_method_6f33b3a2(var17) * 0.55F)
                     );
                     float var23 = 0.42F + 0.58000004F * var22;
                     float var24 = (1.0F - var19) * (var9 ? -6.0F : 6.0F);
                     var1.drawText(
                        this.I_field_856d0221,
                        var2.I_field_6dccaaa5[var17],
                        var20,
                        this.y() - var12 + var24,
                        var14.withAlpha(255.0F * var5 * var23 * var19 * var21)
                     );
                  }
               }
            }

            if (var13) {
               iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            }
         }
      }

      private float I_method_49276567(IiiIIIIIi_Class194.Nested1_50e41fe9 var1) {
         float var2 = IiiIIIIIi_Class194.I_method_724e7171(IiiIIIIIi_Class194.this.IIiI_field_46) * var1.I_field_6dccaaa5.length;
         if (var2 >= var1.I_field_6dccaaa5.length) {
            return var1.I_field_46;
         } else {
            int var3 = (int)var2;
            return var1.I_field_b4b[var3] + var1.I_method_6f33b3a2(var3) * (var2 - var3);
         }
      }

      private void I_method_730e1b93(long var1) {
         if (IiiIIIIIi_Class194.this.i_field_49 >= 0
            && (IiiIIIIIi_Class194.this.i_field_49 != this.I_field_49 || !IiiIIIIIi_Class194.this.i_field_523beb0a.equals(this.I_field_523beb0a))) {
            this.I_field_49 = IiiIIIIIi_Class194.this.i_field_49;
            this.I_field_523beb0a = IiiIIIIIi_Class194.this.i_field_523beb0a;
            long var3 = var1;
            if (this.I_field_fee2d0a6 != null) {
               this.I_field_fee2d0a6.i_field_4a = var1;
               this.i_field_fee2d0a6 = this.I_field_fee2d0a6;
               var3 = var1 + 90L;
            }

            this.I_field_fee2d0a6 = new IiiIIIIIi_Class194.Nested1_50e41fe9(
               this.I_field_856d0221, iIIIIiIiI_Class267.i_method_e7444577(IiiIIIIIi_Class194.this.i_field_523beb0a), var3
            );
         }
      }

      private int I_method_4927656a(IiiIIIIIi_Class194.Nested1_50e41fe9 var1) {
         for (int var2 = var1.I_method_141a6d64() - 1; var2 > 0; var2--) {
            if (IiiIIIIIi_Class194.this.IIiI_field_46 * var1.I_field_6dccaaa5.length >= var1.I_field_b4e[var2]) {
               return var2;
            }
         }

         return 0;
      }

      private void I_method_9cf238d4(IiiIIIIIi_Class194.Nested1_50e41fe9 var1, int var2, float var3) {
         float var4 = Math.min(1.0F, var3 * 11.0F);

         for (int var5 = 0; var5 < var1.I_method_141a6d64(); var5++) {
            float var6 = var5 == var2 ? 1.13F : 1.0F;
            var1.Ii_field_b4b[var5] = var1.Ii_field_b4b[var5] + (var6 - var1.Ii_field_b4b[var5]) * var4;
         }
      }

      private void I_method_49276577(IiiIIIIIi_Class194.Nested1_50e41fe9 var1) {
         float var2 = 0.0F;

         for (int var3 = 0; var3 < var1.I_method_141a6d64(); var3++) {
            float var4 = (var1.Ii_field_b4b[var3] - 1.0F) * (var1.II_field_b4b[var3] - var1.i_field_b4b[var3] + 5.0F);
            var1.iI_field_b4b[var3] = var2 + var4 / 2.0F;
            var2 += var4;
         }

         var1.i_field_46 = var2;
      }

      private void I_method_12c6006(IiiIIIIIi_Class194.Nested1_50e41fe9 var1, float var2, int var3, float var4) {
         float var5 = Math.max(0.0F, var1.I_field_46 - var2);
         var1.Ii_field_46 = var5;
         if (var5 <= 0.5F) {
            var1.II_field_46 = var1.II_field_46 - var1.II_field_46 * Math.min(1.0F, var4 * 9.0F);
         } else {
            float var6 = Math.max(var5, var1.I_field_46 + var1.i_field_46 - var2);
            float var7 = Math.clamp(var1.II_field_b4b[var3] + var1.iI_field_b4b[var3] - var2 * 0.6F, 0.0F, var6);
            if (!(var7 <= var1.II_field_46)) {
               var1.II_field_46 = var1.II_field_46 + (var7 - var1.II_field_46) * (1.0F - (float)Math.exp(-9.0F * var4));
            }
         }
      }

      private float I_method_9cf0dba7(IiiIIIIIi_Class194.Nested1_50e41fe9 var1, float var2, float var3) {
         if (var1.I_field_46 <= var3) {
            return 1.0F;
         } else {
            float var4 = var2 - this.x();
            float var5 = 1.0F - (1.0F - IiiIIIIIi_Class194.I_method_724e7171(var4 / 9.0F)) * IiiIIIIIi_Class194.I_method_724e7171(var1.II_field_46 / 9.0F);
            float var6 = 1.0F
               - (1.0F - IiiIIIIIi_Class194.I_method_724e7171((var3 - var4) / 9.0F))
                  * IiiIIIIIi_Class194.I_method_724e7171((var1.Ii_field_46 - var1.II_field_46) / 9.0F);
            return Math.min(var5, var6);
         }
      }

      float I_method_77530541() {
         return this.I_field_856d0221.I_method_a649725c();
      }
   }

   final class Nested1_50e41fc9 extends iiI_Class7 {
      private final IIiIIi_Class10 I_field_856d0221;
      private final Supplier<String> I_field_11b14ee4;
      private final Supplier<ColorRGBA> i_field_11b14ee4;
      private final float I_field_46;
      private final float i_field_46;

      Nested1_50e41fc9(IIiIIi_Class10 var2, Supplier<String> var3, Supplier<ColorRGBA> var4, float var5, float var6) {
         this.I_field_856d0221 = var2;
         this.I_field_11b14ee4 = var3;
         this.i_field_11b14ee4 = var4;
         this.I_field_46 = var5;
         this.i_field_46 = var6;
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         String var3 = this.I_method_47d8cf2f();
         if (!var3.isEmpty()) {
            ColorRGBA var4 = this.i_field_11b14ee4.get();
            if (var4 != null) {
               float var5 = Math.max(0.0F, this.w());
               if (!(var5 <= 0.0F)) {
                  if (this.I_field_856d0221.I_method_2c375926(var3) <= var5) {
                     var1.drawText(this.I_field_856d0221, var3, this.x(), this.y(), var4);
                  } else {
                     iIiiiIiII_Class373.I_method_d5a5ee51(
                        var1.getMatrices(), this.x() - 1.0F, this.y() - 1.0F, var5 + 1.0F, this.I_field_856d0221.I_method_a649725c() + 2.0F
                     );

                     try {
                        var1.drawFadeoutText(
                           this.I_field_856d0221, var3, this.x(), this.y(), var4, Math.max(this.I_field_46, 0.84F), Math.max(this.i_field_46, 0.96F), var5
                        );
                     } finally {
                        iIiiiIiII_Class373.I_method_ff80a1df();
                     }
                  }
               }
            }
         }
      }

      private String I_method_47d8cf2f() {
         String var1 = this.I_field_11b14ee4.get();
         return var1 == null ? "" : var1;
      }

      float I_method_dd7f5981() {
         return this.I_field_856d0221.I_method_a649725c();
      }
   }

   static final class Nested1_50e41fe9 {
      final String[] I_field_6dccaaa5;
      final float[] I_field_b4b;
      final String[] i_field_6dccaaa5;
      final int[] I_field_b4e;
      final int[] i_field_b4e;
      final float[] i_field_b4b;
      final float[] II_field_b4b;
      final float[] Ii_field_b4b;
      final float[] iI_field_b4b;
      final float I_field_46;
      final long I_field_4a;
      float i_field_46;
      float II_field_46;
      float Ii_field_46;
      float iI_field_46;
      long i_field_4a;

      Nested1_50e41fe9(IIiIIi_Class10 var1, String var2, long var3) {
         this.I_field_4a = var3;
         int var5 = var2.length();
         this.I_field_6dccaaa5 = new String[var5];
         this.I_field_b4b = new float[var5];
         int var6 = 0;
         boolean var7 = false;

         for (int var8 = 0; var8 < var5; var8++) {
            boolean var9 = Character.isWhitespace(var2.charAt(var8));
            if (!var9 && !var7) {
               var6++;
            }

            var7 = !var9;
         }

         this.i_field_6dccaaa5 = new String[var6];
         this.I_field_b4e = new int[var6];
         this.i_field_b4e = new int[var6];
         this.i_field_b4b = new float[var6];
         this.II_field_b4b = new float[var6];
         this.Ii_field_b4b = new float[var6];
         this.iI_field_b4b = new float[var6];
         Arrays.fill(this.Ii_field_b4b, 1.0F);
         int var13 = -1;
         var7 = false;

         for (int var14 = 0; var14 < var5; var14++) {
            char var10 = var2.charAt(var14);
            this.I_field_6dccaaa5[var14] = String.valueOf(var10);
            this.I_field_b4b[var14] = var1.I_method_2c375926(var2.substring(0, var14));
            boolean var11 = Character.isWhitespace(var10);
            if (!var11) {
               if (!var7) {
                  this.I_field_b4e[++var13] = var14;
                  this.i_field_b4b[var13] = this.I_field_b4b[var14];
               }

               this.i_field_b4e[var13] = var14;
               this.II_field_b4b[var13] = this.I_field_b4b[var14] + var1.I_method_22e53781(var10);
            }

            var7 = !var11;
         }

         for (int var15 = 0; var15 < var6; var15++) {
            this.i_field_6dccaaa5[var15] = var2.substring(this.I_field_b4e[var15], this.i_field_b4e[var15] + 1);
         }

         this.I_field_46 = var1.I_method_2c375926(var2);
      }

      int I_method_141a6d64() {
         return this.i_field_6dccaaa5.length;
      }

      float I_method_6f33b3a2(int var1) {
         return (var1 + 1 < this.I_field_6dccaaa5.length ? this.I_field_b4b[var1 + 1] : this.I_field_46) - this.I_field_b4b[var1];
      }
   }

   final class Nested1_cb9f6180 extends iiI_Class7 {
      private static final int I_field_49 = 6;
      private static final float I_field_46 = 8.0F;
      private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(360L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
      private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(280L, -1.0F, IiiiIiiII_Class237.III_field_dd60aac);
      private iiIiIIIii_Class420 I_field_990d92ac;
      private int i_field_49 = -1;
      private String I_field_523beb0a = "";
      private float i_field_46;
      private long I_field_4a = System.currentTimeMillis();

      Nested1_cb9f6180() {
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         iiIiIIIii_Class420 var3 = IiiIIIIIi_Class194.this.I_method_8207af55().I_method_655c2f95();
         MediaInfo var4 = IiiIIIIIi_Class194.this.I_method_329ae7e4();
         float var5 = IiiIIIIIi_Class194.this.Ii_method_726b8cf2();
         if (IiiIIIIIi_Class194.this.i_method_a8e7c603() && !var3.I_method_27bb8263() && var4 != null && !(var5 <= 0.001F)) {
            List var6 = var3.I_method_13376608();
            int var7 = var6.size();
            double var8 = IiiIIIIIi_Class194.this.I_method_8207af55().I_method_f1206e6d() * 1000.0 + 150.0;
            int var10 = var3.i_method_27ca0e43() ? var3.I_method_cfb54038((long)var8) : -1;
            int var11 = Math.max(0, var7 - 6);
            int var12 = var3.i_method_27ca0e43() ? Math.clamp((long)(var10 - 2), 0, var11) : Math.clamp((long)IiiIIIIIi_Class194.this.I_field_49, 0, var11);
            IiiIIIIIi_Class194.this.I_field_49 = var12;
            this.I_method_3439794c(var3, var12, var10);
            float var13 = this.I_field_dc7facc.I_method_6ac4da6f();
            float var14 = this.i_field_dc7facc.I_method_6ac4da6f();
            int var15 = Math.max(0, (int)Math.floor(var13) - 1);
            int var16 = Math.min(var7 - 1, (int)Math.ceil(var13) + 6 + 1);
            int var17 = var3.i_method_27ca0e43() ? var10 : Math.clamp((long)Math.round(var13 + 2.0F), 0, var7 - 1);

            for (int var18 = var15; var18 <= var16; var18++) {
               float var19 = var18 - var13;
               float var20 = Math.min(IiiIIIIIi_Class194.I_method_724e7171(var19 + 1.0F), IiiIIIIIi_Class194.I_method_724e7171(6.0F - var19));
               if (!(var20 <= 0.001F)) {
                  float var21 = var3.i_method_27ca0e43() ? IiiIIIIIi_Class194.I_method_724e7171(1.0F - Math.abs(var18 - var14)) : 0.0F;
                  float var22 = var3.i_method_27ca0e43() ? Math.max(0.0F, IiiIIIIIi_Class194.I_method_724e7171(1.5F - Math.abs(var18 - var14)) - var21) : 0.0F;
                  float var23 = (var3.i_method_27ca0e43() ? 50.0F + 205.0F * var21 + 100.0F * var22 : 200.0F) * var5 * var20;
                  IIiIIi_Class10 var24 = var21 > 0.1F
                     ? IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(IiiIIIIIi_Class194.i_method_b54c7551(5.0F, 6.0F, var21))
                     : IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(5.0F);
                  float var25 = this.y() + var19 * 8.0F;
                  float var26 = var18 == var10 ? var3.I_method_b76449ba(var18, var8, (long)(var4.getDuration() * 1000.0)) : -1.0F;
                  ColorRGBA var27 = IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(var26 >= 0.0F ? var23 * 0.38F : var23);
                  this.I_method_17701028(
                     var1,
                     var24,
                     ((iiIiIIIii_Class420.Nested1_a969040)var6.get(var18)).I_method_257c66(),
                     var18,
                     var18 == var17,
                     this.x(),
                     var25,
                     Math.max(1.0F, this.w()),
                     var27,
                     ColorRGBA.WHITE.withAlpha(var23),
                     var26
                  );
               }
            }
         }
      }

      private void I_method_3439794c(iiIiIIIii_Class420 var1, int var2, int var3) {
         if (this.I_field_990d92ac != var1) {
            this.I_field_990d92ac = var1;
            this.I_field_dc7facc.I_method_edd6dd21(var2);
            this.i_field_dc7facc.I_method_edd6dd21(var3);
            this.I_method_2eb923a();
         } else {
            this.I_field_dc7facc.I_method_edd6dd11(var2);
            this.i_field_dc7facc.I_method_edd6dd11(var3);
         }
      }

      private void I_method_17701028(
         III var1, IIiIIi_Class10 var2, String var3, int var4, boolean var5, float var6, float var7, float var8, ColorRGBA var9, ColorRGBA var10, float var11
      ) {
         float var12 = var2.I_method_2c375926(var3);
         float var13 = this.I_method_54d59a2b(var2, var3, var11);
         if (var5 && !(var12 <= var8)) {
            this.I_method_7e7bc911(var4, var3, var12, var8, var13, var11, System.currentTimeMillis());
            float var14 = Math.max(0.0F, var12 - var8);
            this.i_field_46 = Math.min(this.i_field_46, var14);
            iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var6 - 2.5F, var7 - 3.0F, var8 + 5.0F, var2.i_method_a657fe3c() + 6.0F);
            var1.pushMatrix();
            var1.getMatrices().translate(-this.i_field_46, 0.0F, 0.0F);
            var1.drawText(var2, var3, var6, var7, var9);
            if (var11 >= 0.0F) {
               this.I_method_5cd002ac(var1, var2, var3, var6, var7, var13, var12, var10, var5x -> var1.drawText(var2, var3, var6, var7, var5x));
            }

            var1.popMatrix();
            iIiiiIiII_Class373.I_method_ff80a1df();
         } else {
            var1.drawFadeoutText(var2, var3, var6, var7, var9, 0.88F, 1.0F, var8);
            if (var11 >= 0.0F) {
               this.I_method_5cd002ac(
                  var1, var2, var3, var6, var7, var13, var8, var10, var6x -> var1.drawFadeoutText(var2, var3, var6, var7, var6x, 0.88F, 1.0F, var8)
               );
            }
         }
      }

      private void I_method_5cd002ac(
         III var1, IIiIIi_Class10 var2, String var3, float var4, float var5, float var6, float var7, ColorRGBA var8, Consumer<ColorRGBA> var9
      ) {
         if (!(var6 <= 0.0F) && !var3.isEmpty()) {
            this.I_method_94b31801(var1, var4, var5, Math.min(var7, var6 + 1.2F), var2.i_method_a657fe3c(), var8.mulAlpha(0.18F), var9);
            this.I_method_94b31801(var1, var4, var5, Math.min(var7, var6 + 0.55F), var2.i_method_a657fe3c(), var8.mulAlpha(0.38F), var9);
            this.I_method_94b31801(var1, var4, var5, Math.min(var7, var6), var2.i_method_a657fe3c(), var8, var9);
         }
      }

      private void I_method_94b31801(III var1, float var2, float var3, float var4, float var5, ColorRGBA var6, Consumer<ColorRGBA> var7) {
         if (!(var4 <= 0.0F) && !(var6.getAlpha() <= 0.0F)) {
            iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var2 - 2.0F, var3 - 3.0F, var4 + 2.0F, var5 + 6.0F);
            var7.accept(var6);
            iIiiiIiII_Class373.I_method_ff80a1df();
         }
      }

      private float I_method_54d59a2b(IIiIIi_Class10 var1, String var2, float var3) {
         int var4 = var2.codePointCount(0, var2.length());
         if (var4 == 0) {
            return 0.0F;
         } else {
            float var5 = IiiIIIIIi_Class194.I_method_724e7171(var3) * var4;
            int var6 = Math.min(var4, (int)var5);
            int var7 = var2.offsetByCodePoints(0, var6);
            float var8 = var1.I_method_2c375926(var2.substring(0, var7));
            if (var6 == var4) {
               return var8;
            } else {
               int var9 = var2.offsetByCodePoints(var7, 1);
               float var10 = var1.I_method_2c375926(var2.substring(0, var9));
               return var8 + (var10 - var8) * (var5 - var6);
            }
         }
      }

      private void I_method_7e7bc911(int var1, String var2, float var3, float var4, float var5, float var6, long var7) {
         if (this.i_field_49 == var1 && this.I_field_523beb0a.equals(var2)) {
            float var9 = Math.max(0.0F, var3 - var4);
            float var10 = Math.min(0.05F, Math.max(0.0F, (float)(var7 - this.I_field_4a) / 1000.0F));
            this.I_field_4a = var7;
            this.i_field_46 = Math.min(this.i_field_46, var9);
            if (!(var9 <= 0.0F)) {
               if (var6 < 0.0F) {
                  this.i_field_46 = Math.min(var9, this.i_field_46 + var10 * 24.0F);
               } else {
                  float var11 = Math.clamp(var5 - var4 * 0.62F, 0.0F, var9);
                  if (!(var11 <= this.i_field_46)) {
                     float var12 = 1.0F - (float)Math.exp(-14.0F * var10);
                     this.i_field_46 = Math.min(var11, this.i_field_46 + (var11 - this.i_field_46) * var12);
                  }
               }
            }
         } else {
            this.i_field_49 = var1;
            this.I_field_523beb0a = var2;
            this.i_field_46 = 0.0F;
            this.I_field_4a = var7;
         }
      }

      private void I_method_2eb923a() {
         this.i_field_49 = -1;
         this.I_field_523beb0a = "";
         this.i_field_46 = 0.0F;
         this.I_field_4a = System.currentTimeMillis();
      }
   }

   final class Nested1_cb9f61a0 extends Iii_Class4 {
      private final BooleanSupplier I_field_7bf34412;

      Nested1_cb9f61a0(BooleanSupplier var2) {
         this.I_field_7bf34412 = var2;
         this.snapPosition();
         this.snapSize();
         this.cursor(iIIIiIIIi_Class274.i_field_aa52e62c);
      }

      @Override
      public boolean contains(float var1, float var2) {
         return this.I_field_7bf34412.getAsBoolean() && super.contains(var1, var2);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         if (this.I_field_7bf34412.getAsBoolean()) {
            super.drawSelf(var1, var2);
         }
      }
   }

   final class Nested1_cb9f6560 extends iii_Class8 {
      private final IiIiiIIII_Class177 I_field_467a06ac;
      private final IiiIIIIIi_Class194.Nested1_fa59f060 I_field_949bf227 = IiiIIIIIi_Class194.this.new Nested1_fa59f060();
      private final IiiIIIIIi_Class194.Nested1_50e41fc9 I_field_fee2ccc6 = IiiIIIIIi_Class194.this.new Nested1_50e41fc9(
         IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
         () -> IiiIIIIIi_Class194.this.I_method_a1d802ed(MediaInfo::getTitle),
         () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F * (1.0F - IiiIIIIIi_Class194.this.I_method_a8d93a0f())),
         0.3F,
         0.7F
      );
      private final IiiIIIIIi_Class194.Nested1_50e41c09 I_field_fee25886 = IiiIIIIIi_Class194.this.new Nested1_50e41c09();
      private final IiiIIIIIi_Class194.Nested1_50e41fc9 i_field_fee2ccc6 = IiiIIIIIi_Class194.this.new Nested1_50e41fc9(
         IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
         () -> IiiIIIIIi_Class194.this.I_method_a1d802ed(MediaInfo::getArtist),
         () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(178.5F * this.iII_method_290cf90a()),
         0.3F,
         0.7F
      );
      private final IiiIIIIIi_Class194.Nested1_cb9fd9a0 I_field_dd76cde7 = IiiIIIIIi_Class194.this.new Nested1_cb9fd9a0(
         IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(5.0F),
         () -> IiiIIIIIi_Class194.I_method_d85eebb(
            IiiIIIIIi_Class194.this.I_method_329ae7e4() == null ? 0L : IiiIIIIIi_Class194.this.I_method_329ae7e4().getPosition()
         ),
         () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F)
      );
      private final IiiIIIIIi_Class194.Nested1_cb9fd9a0 i_field_dd76cde7 = IiiIIIIIi_Class194.this.new Nested1_cb9fd9a0(
         IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(5.0F),
         () -> IiiIIIIIi_Class194.I_method_d85eebb(
            IiiIIIIIi_Class194.this.I_method_329ae7e4() == null ? 0L : IiiIIIIIi_Class194.this.I_method_329ae7e4().getDuration()
         ),
         () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F)
      );
      private final IiiIIIIIi_Class194.Nested1_cb9fd9c0 I_field_dd76d1c7 = IiiIIIIIi_Class194.this.new Nested1_cb9fd9c0();
      private final IiiIIIIIi_Class194.Nested1_cb9f61a0 I_field_dd6845e7 = IiiIIIIIi_Class194.this.I_method_48af91a6(
         this::Ii_method_56c9d42b,
         () -> {
            java.util.concurrent.CompletableFuture.runAsync(() -> {
               try {
                  IMediaSession var1x = IiiIIIIIi_Class194.this.I_method_be00a51b();
                  if (var1x != null) {
                     var1x.previous();
                  }
               } catch (Throwable ignored) {}
            });
         },
         (var0, var1x) -> var0.drawIcon(
            "music/previous", var1x.x(), var1x.y(), var1x.w(), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F - 100.0F * var1x.hover())
         )
      );
      private final IiiIIIIIi_Class194.Nested1_cb9f61a0 i_field_dd6845e7 = IiiIIIIIi_Class194.this.I_method_48af91a6(this::Ii_method_56c9d42b, () -> {
         IMediaSession var1x = IiiIIIIIi_Class194.this.I_method_be00a51b();
         if (var1x != null) {
            MediaInfo var2x = var1x.getMedia();
            float var3 = var2x != null && var2x.isPlaying() ? 0.0F : 1.0F;
            java.util.concurrent.CompletableFuture.runAsync(() -> {
               try {
                  var1x.playPause();
               } catch (Throwable ignored) {}
            });
            IiiIIIIIi_Class194.this.IIII_field_46 = var3;
            IiiIIIIIi_Class194.this.II_field_4a = System.currentTimeMillis() + 1000L;
            IiiIIIIIi_Class194.this.I_field_dc7facc.I_method_edd6ec25(600L);
            IiiIIIIIi_Class194.this.I_field_dc7facc.I_method_edd6dd11(var3);
         }
      }, this::I_method_d07190d5);
      private final IiiIIIIIi_Class194.Nested1_cb9f61a0 II_field_dd6845e7 = IiiIIIIIi_Class194.this.I_method_48af91a6(
         this::Ii_method_56c9d42b,
         () -> {
            java.util.concurrent.CompletableFuture.runAsync(() -> {
               try {
                  IMediaSession var1x = IiiIIIIIi_Class194.this.I_method_be00a51b();
                  if (var1x != null) {
                     var1x.next();
                  }
               } catch (Throwable ignored) {}
            });
         },
         (var0, var1x) -> var0.drawIcon(
            "music/next", var1x.x(), var1x.y(), var1x.w(), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F - 100.0F * var1x.hover())
         )
      );
      private final IiiIIIIIi_Class194.Nested1_cb9f6580 I_field_dd68be07 = IiiIIIIIi_Class194.this.new Nested1_cb9f6580();
      private final IiiIIIIIi_Class194.Nested1_fa59f080 I_field_949bf607 = IiiIIIIIi_Class194.this.new Nested1_fa59f080();
      private final IiiIIIIIi_Class194.Nested1_cb9f61a0 Ii_field_dd6845e7 = IiiIIIIIi_Class194.this.I_method_4f3b2c08(
         8.0F,
         this::iI_method_587e386b,
         () -> {
            if (IiiIIIIIi_Class194.this.I_method_a8d93a23()) {
               IiiIIIIIi_Class194.this.I_method_724ebc95(!IiiIIIIIi_Class194.this.i_method_a8e7c603());
            }
         },
         (var0, var1x) -> var0.drawIcon(
            "music/text", var1x.x(), var1x.y(), var1x.w(), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0F - 100.0F * var1x.hover())
         )
      );
      private final IiiIIIIIi_Class194.Nested1_cb9f6180 I_field_dd684207 = IiiIIIIIi_Class194.this.new Nested1_cb9f6180();
      private final IiiIIIIIi_Class194.Nested1_cb9fdd80 I_field_dd774607 = IiiIIIIIi_Class194.this.new Nested1_cb9fdd80();

      Nested1_cb9f6560(IiIiiIIII_Class177 var2) {
         this.I_field_467a06ac = var2;
         this.i_method_8c7d3515(48.0F, 15.0F);
         this.Ii_method_25479968(false);
         this.I_method_350d9c12("lyrics-expansion", IiiIIIIIi_Class194.this::II_method_725d0126, IIii_Class4.I_method_f17ae5cb(300.0F, 30.0F));
         this.iii_method_df275535();
         this.snapSize();
         this.I_method_b9da0e0c(this.I_field_949bf227);
         this.I_method_b9da0e0c(this.I_field_fee2ccc6);
         this.I_method_b9da0e0c(this.I_field_fee25886);
         this.I_method_b9da0e0c(this.i_field_fee2ccc6);
         this.I_method_b9da0e0c(this.I_field_dd76cde7);
         this.I_method_b9da0e0c(this.i_field_dd76cde7);
         this.I_method_b9da0e0c(this.I_field_dd76d1c7);
         this.I_method_b9da0e0c(this.I_field_dd6845e7);
         this.I_method_b9da0e0c(this.i_field_dd6845e7);
         this.I_method_b9da0e0c(this.II_field_dd6845e7);
         this.I_method_b9da0e0c(this.I_field_dd68be07);
         this.I_method_b9da0e0c(this.I_field_949bf607);
         this.I_method_b9da0e0c(this.Ii_field_dd6845e7);
         this.I_method_b9da0e0c(this.I_field_dd684207);
         this.I_method_b9da0e0c(this.I_field_dd774607);
      }

      @Override
      protected void measure() {
         MediaInfo var1 = IiiIIIIIi_Class194.this.I_method_329ae7e4();
         this.prefW = this.I_method_4866f32b(var1);
         this.prefH = this.iIi_method_b76657aa();
      }

      @Override
      protected void onTick(float var1, float var2, float var3) {
         this.I_method_38e5328().removeIf(var0 -> var0.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866);
         this.Ii_method_57601442();
         this.II_method_57518862();

         for (iiI_Class7 var5 : this.I_method_38e5328()) {
            var5.tick(var1, var2, var3);
         }
      }

      @Override
      protected void drawChildren(III var1, float var2) {
         this.iI_method_59147882();
         IiiIIIIIi_Class194.this.i_method_a8e7c5ff();
         this.II_method_57518862();

         for (iiI_Class7 var4 : this.I_method_38e5328()) {
            if (var4.inFlow()) {
               var4.draw(var1, var2);
            }
         }
      }

      private void II_method_57518862() {
         MediaInfo var1 = IiiIIIIIi_Class194.this.I_method_329ae7e4();
         float var2 = this.iII_method_290cf90a();
         boolean var3 = this.i_method_9fc1863e();
         float var4 = var1 == null ? 48.0F : IiiIIIIIi_Class194.this.I_method_daf57506(var1);
         if (!var3 && this.w() > 1.0F) {
            var4 = this.w();
         }

         float var5 = this.x();
         float var6 = this.x() + (var3 ? 82.0F : var4 / 2.0F);
         float var7 = this.x() + (var3 ? 164.0F : var4);
         float var8 = IiiIIIIIi_Class194.this.i_method_a8e7c5ef();
         float var9 = 4.0F + 6.0F * var2;
         float var10 = 7.0F + 19.0F * var2;
         float var11 = this.y() + (this.I_field_467a06ac.II_method_97ffcce6() ? var9 : (this.I_field_467a06ac.I_method_fc091775().i_field_46 - var10) / 2.0F);
         this.I_field_949bf227.setSlot(var5 + var9 - 10.0F + 10.0F * IiiIIIIIi_Class194.this.animation.I_method_6ac4da6f(), var11, var10, var10);
         float var12 = var3 ? var7 - 22.0F : var5 + var4 - 12.0F;
         float var13 = var5 - 5.0F + 20.0F * IiiIIIIIi_Class194.this.animation.I_method_6ac4da6f() + 29.0F * var2;
         float var14 = Math.max(0.0F, var12 - 3.0F - var13);
         this.I_field_fee2ccc6.setSlot(var13, this.y() + 5.0F + 11.0F * var2, var14, this.I_field_fee2ccc6.I_method_dd7f5981());
         this.I_field_fee25886.setSlot(var13, this.y() + 5.0F, var14, this.I_field_fee25886.I_method_77530541());
         this.i_field_fee2ccc6.setSlot(var5 + 20.0F + 24.0F * var2, this.y() + 5.0F + 19.0F * var2, var14, this.i_field_fee2ccc6.I_method_dd7f5981());
         String var15 = var1 == null ? "0:00" : IiiIIIIIi_Class194.I_method_d85eebb(var1.getDuration());
         float var16 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(5.0F).I_method_2c375926(var15);
         this.I_field_dd76cde7
            .setSlot(
               var6 - 82.0F + 11.0F * var2,
               this.y() + 43.0F * var2,
               IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(5.0F).I_method_2c375926(this.I_field_dd76cde7.I_method_5bbb7dc6()),
               this.I_field_dd76cde7.I_method_ff112e0a()
            );
         this.i_field_dd76cde7.setSlot(var6 + 82.0F - (9.5F + var16 * var2), this.y() + 43.0F * var2, var16, this.i_field_dd76cde7.I_method_ff112e0a());
         float var17 = 115.0F
            + IIiIiI_Class11.II_field_857c0621.I_method_c000b13a("0:00", 5.0F)
            - IIiIiI_Class11.II_field_857c0621.I_method_c000b13a(var15, 5.0F);
         this.I_field_dd76d1c7
            .setSlot(var6 - var17 / 2.0F, this.y() + var8 - (IiiIIIIIi_Class194.this.II_method_725d0126() ? 45.0F : 0.0F) - 36.5F * var2, var17, 3.0F);
         float var18 = this.y() + var8 - 25.0F * var2;
         this.I_field_dd6845e7.setSlot(var6 - 40.0F, var18, 16.0F, 16.0F);
         this.i_field_dd6845e7.setSlot(var6 - 8.0F, var18, 16.0F, 16.0F);
         this.II_field_dd6845e7.setSlot(var6 + 24.0F, var18, 16.0F, 16.0F);
         this.I_field_dd68be07.setSlot(var7 - 22.0F, this.y() + var8 - 21.0F, 8.0F, 8.0F);
         String var19 = IiiIIIIIi_Class194.this.II_method_e9bf1bbe();
         IIiIIi_Class10 var20 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(4.5F);
         float var21 = var20.I_method_2c375926(var19);
         this.I_field_949bf607.setSlot(var7 - 18.0F - var21, this.y() + 25.0F, var21, var20.I_method_a649725c());
         this.Ii_field_dd6845e7.setSlot(var5 + 14.0F, this.y() + var8 - 21.0F, 8.0F, 8.0F);
         this.I_field_dd684207.setSlot(var5 + 10.0F, this.y() + 55.0F, 144.0F, 45.0F);
         this.I_field_dd774607.setSlot(var12, this.y() + iIIiiiiiI_Class319.I_method_5f7ff5cf(4.25, 14.0, var2), 14.0F, 10.0F);
      }

      private boolean i_method_9fc1863e() {
         return this.I_field_467a06ac.II_method_97ffcce6() || this.iII_method_290cf90a() > 0.001F;
      }

      private void Ii_method_57601442() {
         float var1 = IiiIIIIIi_Class194.I_method_724e7171((this.h() - 80.0F) / 45.0F);
         IiiIIIIIi_Class194.this.IIIi_field_46 = IiiIIIIIi_Class194.I_method_18850d31(
            Math.min(IiiIIIIIi_Class194.I_method_724e7171(this.sig("lyrics-expansion")), var1), 0.1F, 0.7F
         );
      }

      private boolean II_method_56bb484b() {
         return this.iII_method_290cf90a() != 0.0F;
      }

      private boolean Ii_method_56c9d42b() {
         return (this.I_field_467a06ac.II_method_97ffcce6() || this.iII_method_290cf90a() > 0.2F) && IiiIIIIIi_Class194.this.I_method_be00a51b() != null;
      }

      private boolean iI_method_587e386b() {
         return this.II_method_56bb484b() && IiiIIIIIi_Class194.this.I_method_a8d93a23();
      }

      private void I_method_b9da0e0c(iiI_Class7 var1) {
         var1.lifeMotion(IIii_Class4.I_method_48883e1f(1L));
         this.I_method_8939bffd(var1);
      }

      private float iII_method_290cf90a() {
         return this.I_field_467a06ac.I_method_c3480795().I_method_6ac4da6f();
      }

      private float I_method_4866f32b(MediaInfo var1) {
         if (var1 == null) {
            return 48.0F;
         } else {
            return this.I_field_467a06ac.II_method_97ffcce6() ? 164.0F : IiiIIIIIi_Class194.this.I_method_daf57506(var1);
         }
      }

      private float iIi_method_b76657aa() {
         return this.I_field_467a06ac.II_method_97ffcce6() ? IiiIIIIIi_Class194.this.i_method_a8e7c5ef() : 15.0F;
      }

      private void iI_method_59147882() {
         MediaInfo var1 = IiiIIIIIi_Class194.this.I_method_329ae7e4();
         if (var1 != null && this.II_method_56bb484b()) {
            float var2 = var1.isPlaying() ? 1.0F : 0.0F;
            long var3 = System.currentTimeMillis();
            if (IiiIIIIIi_Class194.this.IIII_field_46 >= 0.0F) {
               if (var2 != IiiIIIIIi_Class194.this.IIII_field_46 && var3 < IiiIIIIIi_Class194.this.II_field_4a) {
                  var2 = IiiIIIIIi_Class194.this.IIII_field_46;
               } else {
                  IiiIIIIIi_Class194.this.IIII_field_46 = -1.0F;
               }
            }

            IiiIIIIIi_Class194.this.I_field_dc7facc.I_method_edd6ec25(600L);
            IiiIIIIIi_Class194.this.I_field_dc7facc.I_method_edd6dd11(var2);
         }

         iiIiIIIiI_Class419 var5 = IiiIIIIIi_Class194.this.I_method_8207af55();
         float var6 = var5.I_method_f1206e6f();
         boolean var4 = var6 > 0.0F;
         if (var4) {
            IiiIIIIIi_Class194.this.iii_field_46 = var6;
         }

         IiiIIIIIi_Class194.this.i_field_dc7facc.I_method_edd6dd11(var4 ? 1.0F : 0.0F);
      }

      private void I_method_d07190d5(III var1, IiiIIIIIi_Class194.Nested1_cb9f61a0 var2) {
         float var3 = IiiIIIIIi_Class194.this.I_field_dc7facc.I_method_6ac4da6f();
         float var4 = var2.x() + var2.w() / 2.0F;
         float var5 = var2.y() + var2.h() / 2.0F;
         float var6 = 255.0F * (1.0F - var3) - 100.0F * var2.hover();
         float var7 = 255.0F * var3 - 100.0F * var2.hover();
         if (var6 > 0.5F) {
            iIiiiIIiI_Class371.I_method_6a1c0f0f(var1.getMatrices(), var4, var5, 90.0F * var3);
            iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var4, var5, 1.0F - var3);
            var1.drawIcon("music/play", var2.x(), var2.y(), var2.w(), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(var6));
            iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
         }

         if (var7 > 0.5F) {
            iIiiiIIiI_Class371.I_method_6a1c0f0f(var1.getMatrices(), var4, var5, -90.0F + 90.0F * var3);
            iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), var4, var5, var3);
            var1.drawIcon("music/pause", var2.x(), var2.y(), var2.w(), IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(var7));
            iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
            iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
         }
      }
   }

   final class Nested1_cb9f6580 extends iiI_Class7 {
      Nested1_cb9f6580() {
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         if (IiiIIIIIi_Class194.this.II_method_725d0112() != 0.0F) {
            String var3 = IiiIIIIIi_Class194.this.i_method_bb850c81();
            if (var3 != null) {
               var1.drawTexture(RockstarClient.id("icons/media/" + var3 + ".png"), this.x(), this.y(), this.w(), this.h(), ColorRGBA.WHITE);
            }
         }
      }
   }

   final class Nested1_cb9fd9a0 extends iiI_Class7 {
      private final IIiIIi_Class10 I_field_856d0221;
      private final Supplier<String> I_field_11b14ee4;
      private final Supplier<ColorRGBA> i_field_11b14ee4;

      Nested1_cb9fd9a0(IIiIIi_Class10 var2, Supplier<String> var3, Supplier<ColorRGBA> var4) {
         this.I_field_856d0221 = var2;
         this.I_field_11b14ee4 = var3;
         this.i_field_11b14ee4 = var4;
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         if (IiiIIIIIi_Class194.this.II_method_725d0112() != 0.0F) {
            String var3 = this.I_method_5bbb7dc6();
            if (!var3.isEmpty()) {
               var1.drawText(this.I_field_856d0221, var3, this.x(), this.y(), this.i_field_11b14ee4.get());
            }
         }
      }

      String I_method_5bbb7dc6() {
         String var1 = this.I_field_11b14ee4.get();
         return var1 == null ? "" : var1;
      }

      float I_method_ff112e0a() {
         return this.I_field_856d0221.I_method_a649725c();
      }
   }

   final class Nested1_cb9fd9c0 extends iiI_Class7 {
      Nested1_cb9fd9c0() {
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         MediaInfo var3 = IiiIIIIIi_Class194.this.I_method_329ae7e4();
         if (var3 != null && IiiIIIIIi_Class194.this.II_method_725d0112() != 0.0F) {
            ColorRGBA var4 = IiiiiIIIi_Class242.iI_method_8e08d3b1();
            var1.drawRoundedRect(this.x(), this.y(), this.w(), this.h(), IIiii_Class8.I_method_893b2757(0.5F), var4.withAlpha(63.75F));
            float var5 = (float)var3.getDuration();
            float var6 = var5 <= 0.0F ? 0.0F : this.w() * Math.min(1.0F, (float)var3.getPosition() / var5);
            var1.drawRoundedRect(this.x(), this.y(), var6, this.h(), IIiii_Class8.I_method_893b2757(0.5F), var4.withAlpha(150.0F));
         }
      }
   }

   final class Nested1_cb9fdd80 extends iiI_Class7 {
      Nested1_cb9fdd80() {
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         iiIiIIIiI_Class419 var3 = IiiIIIIIi_Class194.this.I_method_8207af55();
         float var4 = IiiIIIIIi_Class194.this.II_method_725d0112();

         for (int var5 = 0; var5 < IiiIIIIIi_Class194.this.Ii_field_b4b.length; var5++) {
            var1.drawRoundedRect(
               this.x() + var5 * (2.0F + var4),
               this.y() + (7.0F - IiiIIIIIi_Class194.this.Ii_field_b4b[var5]) / 2.0F,
               1.0F + var4,
               IiiIIIIIi_Class194.this.Ii_field_b4b[var5],
               IIiii_Class8.I_method_893b2757(0.5F),
               var3.I_method_588218ee()
            );
         }
      }
   }

   final class Nested1_fa59f060 extends iiI_Class7 {
      Nested1_fa59f060() {
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         Identifier var3 = IiiIIIIIi_Class194.this.I_method_10b2192e();
         float var4 = IiiIIIIIi_Class194.this.II_method_725d0112();
         var1.drawRoundedTexture(var3, this.x(), this.y(), this.w(), this.h(), IIiii_Class8.I_method_893b2757(1.0F + 5.0F * var4));
      }
   }

   final class Nested1_fa59f080 extends iiI_Class7 {
      Nested1_fa59f080() {
         this.snapPosition();
         this.snapSize();
         this.interactive(false);
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         if (IiiIIIIIi_Class194.this.II_method_725d0112() != 0.0F
            && !(IiiIIIIIi_Class194.this.i_field_dc7facc.I_method_6ac4da6f() <= 0.02F)
            && !(IiiIIIIIi_Class194.this.iii_field_46 <= 0.0F)) {
            String var3 = IiiIIIIIi_Class194.this.II_method_e9bf1bbe();
            float var4 = IiiIIIIIi_Class194.this.iI_method_741ff132();
            float var5 = (140.0F + 90.0F * var4) * IiiIIIIIi_Class194.this.II_method_725d0112() * IiiIIIIIi_Class194.this.i_field_dc7facc.I_method_6ac4da6f();
            IIiIIi_Class10 var6 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(4.5F);
            iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), this.x() + this.w() / 2.0F, this.y() + 2.5F, 1.0F + 0.1F * var4);
            var1.drawText(var6, var3, this.x(), this.y(), IiiIIIIIi_Class194.this.I_method_8207af55().I_method_588218ee().withAlpha(var5));
            iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
         }
      }
   }
}
