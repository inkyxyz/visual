package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.gui.screen.ChatScreen;
import org.joml.Matrix4f;
import pyrock.utility.render.ColorRGBA;

public class IiIiiIIII_Class177 extends IiIiIIiII_Class165 implements iIIiIIiIi_Class294, iIIiIIiiI_Class295 {
   private static final float I_field_46 = 7.0F;
   private static final float i_field_46 = 125.0F;
   private static final int I_field_49 = 5;
   private static final long I_field_4a = 900L;
   private static final int[] I_field_b4e = new int[]{450, 300, 150, 75};
   private static final float II_field_46 = 25.5F;
   private static final float Ii_field_46 = 15.0F;
   private static final float iI_field_46 = 15.0F;
   private static final float ii_field_46 = 4.0F;
   private static final long i_field_4a = 210L;
   static final IiiI_Class7 I_field_f94500c1 = (var0, var1, var2) -> {
      var2.I_field_46 = var0;
      var2.Ii_field_46 = 0.9F + 0.1F * var0;
   };
   private final MultiSelectSetting I_field_bbe3ba6c = new MultiSelectSetting(this, "hud.dynamic_island.statuses").I_method_bba86af5();
   private final BooleanSetting I_field_ba20ca4c = new BooleanSetting(this, "hud.dynamic_island.song_lyrics", () -> true).I_method_a4d009eb(true);
   private final TextSetting I_field_731802cc = new TextSetting(this, "hud.dynamic_island.custom_text")
      .I_method_2dbacd5a(20)
      .I_method_104de33f("");
   private final IiIiiIiiI_Class183 I_field_46890aac = new IiIiiIiiI_Class183(48.0F, 15.0F, 7.0F);
   private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(200L, 0.0F, IiiiIiiII_Class237.Iii_field_dd60aac);
   private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(500L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   private final IiiiIiIii_Class236 II_field_dc7facc = new IiiiIiIii_Class236(500L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
   private final IiiiIiIii_Class236 Ii_field_dc7facc = new IiiiIiIii_Class236(260L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
   private final IiiiIiIii_Class236 iI_field_dc7facc = new IiiiIiIii_Class236(500L, 0.0F, IiiiIiiII_Class237.I_field_dd60aac);
   private final IiiiIiiIi_Class238 I_field_dd60e8c = new IiiiIiiIi_Class238(300L, new ColorRGBA(0.0F, 0.0F, 0.0F), IiiiIiiII_Class237.III_field_dd60aac);
   private final iIiiiiiiI_Class383 I_field_4511da6c = new iIiiiiiiI_Class383()
      .I_method_56782bd7(0.1F)
      .i_method_f39133f7(4.0F)
      .I_method_9ffcc735(0.3F, 0.44F)
      .I_method_1df27795(-1, -15856114);
   private IiIiiIiII_Class181 I_field_4688928c;
   private iii_Class8 I_field_b584628c;
   private IiIiiIiii_Class184 I_field_46890e8c;
   private IiIiiIiii_Class184 i_field_46890e8c;
   private IiIiiIIII_Class177.Nested1_ab89c20 I_field_9012be67;
   private boolean I_field_5a;
   private float III_field_46;
   private float IIi_field_46;
   private float IiI_field_46;
   private IiiIIIIIi_Class194 I_field_6f3d2a6c;
   private boolean i_field_5a;
   private long II_field_4a;
   private long Ii_field_4a;
   private boolean II_field_5a;
   private int i_field_49;
   private long iI_field_4a;
   private boolean customPos = false;
   private float customCenterX = -1.0F;
   private float customY = -1.0F;

   public IiIiiIIII_Class177() {
      super("hud.dynamic_island", "hud/island");
      this.showing = true;
      IiIiiiIIi_Class186.I_method_f1735467(this.I_field_bbe3ba6c);
      RockstarClient.getInstance().I_method_7a4c3f0b().I_method_de9edf96("client");
      this.I_method_a1cdf65f();
   }

   @Override
   protected iii_Class8 build() {
      this.I_field_4688928c = new IiIiiIiII_Class181(this);
      this.I_field_4688928c
         .iI_method_c1109a58()
         .I_method_84672d76(IIii_Class4.I_method_3682ece9(500L, IiiiIiiII_Class237.Ii_field_dd60aac))
         .i_method_8c7d3515(this.I_field_46890aac.I_field_46, this.I_field_46890aac.i_field_46);
      this.I_field_b584628c = new iii_Class8();
      this.I_field_b584628c.iI_method_c1109a58().IiI_method_23cb1575().iii_method_df275535().snapSize().interactive(false);
      this.I_field_4688928c.I_method_8939bffd(this.I_field_b584628c);
      return this.I_field_4688928c;
   }

   @Override
   protected boolean anchorsRightEdge() {
      return false;
   }

   @Override
   public void update(III var1) {
      super.update(var1);
      if (this.isDragging()) {
         this.customPos = true;
         this.customCenterX = this.x + this.width / 2.0F;
         this.customY = this.y;
      }
   }

   @Override
   public void pos(float var1, float var2) {
      super.pos(var1, var2);
      this.customPos = true;
      this.customCenterX = var1 + (this.width > 0.0F ? this.width / 2.0F : 24.0F);
      this.customY = var2;
   }

   @Override
   public void renderComponent(III var1) {
      this.i_method_a1dc823f();
      List var2 = this.II_method_2a3a6525();
      IiIiiIiii_Class184 var3 = this.I_method_12784f06(var2);
      this.I_method_f1523867(this.I_method_c267d70e(var3, var2));
      this.iI_method_99c2bd02();
      this.I_field_46890e8c = var3;
      if (var3 != null) {
         this.I_method_25359487(var3);
         this.i_method_c24e9ca7(var3);
         this.II_method_cf84c424(var3);
         float var4 = this.I_method_f7f33317(var1);
         this.Ii_method_980e58c2();
         this.I_method_6739979(var1, var4);
         this.Ii_method_6c9dcc44(var3);
      }
   }

   public <T extends IiIiiIiii_Class184> T I_method_79b1d77d(T var1) {
      return (T)var1;
   }

   public boolean I_method_2535948b(IiIiiIiii_Class184 var1) {
      return this.I_method_817daf31(var1, true);
   }

   public boolean i_method_c24e9cab(IiIiiIiii_Class184 var1) {
      return this.I_method_817daf31(var1, false);
   }

   private boolean I_method_817daf31(IiIiiIiii_Class184 var1, boolean var2) {
      if (var1 == null) {
         return false;
      } else {
         boolean var3 = this.I_field_bbe3ba6c.I_method_45aaa648().remove(var1);
         this.I_field_bbe3ba6c.i_method_faf6de68().remove(var1);
         if (var3) {
            this.II_field_5a = false;
            if (var1 == this.I_field_6f3d2a6c) {
               this.ii_method_99d148e2();
            }

            if (var1 == this.i_field_46890e8c) {
               this.i_field_46890e8c = null;
               this.I_field_46890e8c = null;
            }

            if (this.I_field_b584628c != null) {
               this.I_field_b584628c.I_method_814bf93f();
            }

            if (var2) {
               RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            }
         }

         return var3;
      }
   }

   public boolean I_method_377be66d(String var1) {
      IiIiiIiii_Class184 var2 = this.I_method_e055b2df(var1);
      return var2 != null && this.I_method_2535948b(var2);
   }

   public String I_method_fc79a821() {
      String var1 = this.I_field_731802cc.II_method_da016c1e();
      return var1 != null && !var1.isBlank() ? iIIIIiIiI_Class267.i_method_e7444577(var1.trim()) : "Agravity";
   }

   public IiIiiIiii_Class184 I_method_e055b2df(String var1) {
      if (var1 == null) {
         return null;
      } else {
         for (IiIiiIiii_Class184 var3 : this.I_method_b6e7208()) {
            if (var3.getName().equalsIgnoreCase(var1)) {
               return var3;
            }
         }

         return null;
      }
   }

   public List<IiIiiIiii_Class184> I_method_b6e7208() {
      ArrayList var1 = new ArrayList();

      for (MultiSelectSetting.Nested1_42856060 var3 : this.I_field_bbe3ba6c.I_method_45aaa648()) {
         if (var3 instanceof IiIiiIiii_Class184 var4) {
            var1.add(var4);
         }
      }

      return var1;
   }

   public IiIiiIiii_Class184 I_method_fc091b55() {
      return this.I_method_12784f06(this.II_method_2a3a6525());
   }

   private IiIiiIiii_Class184 I_method_12784f06(List<IiIiiIiii_Class184> var1) {
      if (this.I_field_6f3d2a6c != null) {
         if (var1.contains(this.I_field_6f3d2a6c)) {
            return this.I_field_6f3d2a6c;
         }

         this.ii_method_99d148e2();
         this.II_field_5a = false;
      }

      return var1.isEmpty() ? null : (IiIiiIiii_Class184)var1.getLast();
   }

   public List<IiIiiIiii_Class184> i_method_c0baaa28() {
      return this.II_method_2a3a6525();
   }

   private List<IiIiiIiii_Class184> II_method_2a3a6525() {
      return this.I_field_bbe3ba6c
         .I_method_45aaa648()
         .stream()
         .filter(var0 -> var0 instanceof IiIiiIiii_Class184)
         .map(var0 -> (IiIiiIiii_Class184)var0)
         .filter(var0 -> var0.canShow() && var0.isSelected())
         .toList()
         .reversed();
   }

   private void I_method_a1cdf65f() {
      IiiIIIIII_Class193 var1 = null;
      IiIiiiiIi_Class190 var2 = null;
      IiiIIIIiI_Class195 var3 = null;

      for (IiIiiIiii_Class184 var5 : this.I_method_b6e7208()) {
         if (var5 instanceof IiiIIIIII_Class193 var6) {
            var1 = var6;
         }

         if (var5 instanceof IiIiiiiIi_Class190 var11) {
            var2 = var11;
         }

         if (var5 instanceof IiiIIIIiI_Class195 var12) {
            var3 = var12;
         }
      }

      if (var1 != null && var2 != null) {
         List var9 = this.I_field_bbe3ba6c.I_method_45aaa648();
         int var10 = var9.indexOf(var1);
         int var13 = var9.indexOf(var2);
         if (var10 >= 0 && var13 >= 0 && var10 >= var13) {
            var9.remove(var1);
            int var7 = var3 == null ? -1 : var9.indexOf(var3);
            int var8 = var7 >= 0 ? var7 + 1 : 0;
            var9.add(Math.min(var8, var9.size()), var1);
            this.I_field_bbe3ba6c.i_method_bff19e42(var1);
         }
      }
   }

   private void i_method_a1dc823f() {
      if (this.flow == null) {
         this.flow = this.build();
      }
   }

   private void I_method_25359487(IiIiiIiii_Class184 var1) {
      if (var1 == this.I_field_6f3d2a6c && this.i_field_5a && System.currentTimeMillis() - this.II_field_4a >= 210L) {
         this.i_field_5a = false;
         this.II_field_5a = true;
      }

      if (!var1.isExpandable() || !this.Ii_method_980e58c6() && var1 != this.I_field_6f3d2a6c) {
         this.II_field_5a = false;
      }

      this.I_field_dc7facc.I_method_edd72835(this.II_field_5a);
   }

   private boolean Ii_method_980e58c6() {
      return (I_field_3a9bda27.currentScreen != null || I_field_3a9bda27.player == null) && !this.select;
   }

   private void i_method_c24e9ca7(IiIiiIiii_Class184 var1) {
      for (MultiSelectSetting.Nested1_42856060 var3 : this.I_field_bbe3ba6c.I_method_45aaa648()) {
         if (var3 instanceof IiIiiIiii_Class184 var4) {
            var4.getAnimation().I_method_edd6dd11(var4 == var1 ? 1.0F : 0.0F);
         }
      }
   }

   private void II_method_cf84c424(IiIiiIiii_Class184 var1) {
      var1.prepare(this);
      iiI_Class7 var2 = var1.element(this);
      var2.prepareRoot();
      IiIiiIiiI_Class183 var3 = var1.getSize();
      this.I_field_dd60e8c.I_method_8895420(var1.getColor());
      this.i_field_dc7facc.I_method_edd6dd11(var1.radius(this));
      if (this.width <= 0.0F) {
         this.width = var3.I_field_46;
      }

      if (this.height <= 0.0F) {
         this.height = var3.i_field_46;
      }

      if (!this.isDragging()) {
         this.x = this.I_method_97f13d31(this.width);
         this.y = this.iI_method_99c2bcf2();
      }
      this.I_field_4688928c.i_method_8c7d3515(var3.I_field_46, var3.i_field_46);
      if (this.i_field_46890e8c != var1 || var2.parent() != this.I_field_b584628c) {
         this.I_field_b584628c.II_method_244860a9(List.of(var2));
         this.i_field_46890e8c = var1;
      }
   }

   private float I_method_f7f33317(III var1) {
      long var2 = System.currentTimeMillis();
      float var4 = this.Ii_field_4a == 0L ? 16.0F : Math.min(64.0F, (float)(var2 - this.Ii_field_4a));
      this.Ii_field_4a = var2;
      this.flow.prepareRoot();
      this.II_method_97ffcce2();
      this.flow.tick(var4, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
      this.II_method_97ffcce2();
      this.flow.tick(0.0F, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
      this.flow.draw(var1, this.Ii_method_980e58b2());
      return var4;
   }

   private void II_method_97ffcce2() {
      if (this.isDragging()) {
         this.flow.snapAt(this.x, this.y);
      } else {
         float var1 = this.flow.w() > 0.0F ? this.flow.w() : this.width;
         this.flow.snapAt(this.I_method_97f13d31(var1), this.iI_method_99c2bcf2());
      }
   }

   private void Ii_method_980e58c2() {
      this.width = this.flow.w();
      this.height = this.flow.h();
      this.x = this.flow.x();
      this.y = this.flow.y();
      this.I_field_46890aac.I_method_86686501(this.width, this.height, this.i_field_dc7facc.I_method_6ac4da6f());
   }

   private void Ii_method_6c9dcc44(IiIiiIiii_Class184 var1) {
      if (!this.II_field_5a
         && var1.isExpandable()
         && iIIiIIIiI_Class291.I_method_c3f86263(
            this.x, this.y, this.width, this.height, iIIiIIIiI_Class291.I_method_81637b4f().getX(), iIIiIIIiI_Class291.I_method_81637b4f().getY()
         )) {
         iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
      }
   }

   private float Ii_method_980e58b2() {
      return Math.min(1.0F, this.animation.I_method_6ac4da6f() * this.visible.I_method_6ac4da6f());
   }

   private float I_method_97f13d31(float var1) {
      if (this.isDragging()) {
         return this.x;
      }
      if (this.customPos && this.customCenterX >= 0.0F) {
         return this.customCenterX - var1 / 2.0F;
      }
      float var2 = 9.5F * this.Ii_field_dc7facc.I_method_6ac4da6f();
      return I_field_73c6d26c.I_method_804ee20f() / 2.0F - var1 / 2.0F - var2;
   }

   private float iI_method_99c2bcf2() {
      if (this.isDragging()) {
         return this.y;
      }
      if (this.customPos && this.customY >= 0.0F) {
         return this.customY;
      }
      return I_field_3a9bda27.currentScreen instanceof IiIiiiIii_Class188 ? I_field_73c6d26c.i_method_805d6def() / 2.0F - 125.0F : 7.0F;
   }

   void I_method_a5bd20e1(III var1, IiIiiIiII_Class181 var2, float var3) {
      float var4 = var2.x();
      float var5 = var2.y();
      float var6 = var2.w();
      float var7 = var2.h();
      this.I_method_38001739(var1, var4, var5, var6);
      this.I_method_386424f9(var1, var4, var5, var6, var7, var3);
   }

   private void I_method_386424f9(III var1, float var2, float var3, float var4, float var5, float var6) {
      float rad = Math.min(var5 / 2.0F, this.i_field_dc7facc.I_method_6ac4da6f() + 11.0F * this.I_field_dc7facc.I_method_6ac4da6f());
      IIiii_Class8 var7 = IIiii_Class8.I_method_893b2757(rad);
      ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();

      // Dual soft drop shadow (Apple floating island elevation)
      var1.drawShadow(var2, var3, var4, var5, 14.0F, var7, new ColorRGBA(0.0F, 0.0F, 0.0F, 160.0F * var6));
      var1.drawShadow(var2, var3 + 1.5F, var4, var5, 22.0F, var7, new ColorRGBA(0.0F, 0.0F, 0.0F, 90.0F * var6));

      if (InterfaceModule.IiI_method_c4cbfac3()) {
         // Liquid glass chromatic refraction pass
         var1.drawLiquidGlass(var2, var3, var4, var5, rad, 0.18F, var7, ColorRGBA.WHITE.withAlpha(255.0F * var6));
         // Deep obsidian OLED black capsule body
         var1.drawSquircle(var2, var3, var4, var5, 2.0F, var7, new ColorRGBA(7.0F, 8.0F, 13.0F, 245.0F * var6));
         // Sleek bezel perimeter stroke
         var1.drawSquircleBorder(var2, var3, var4, var5, 0.8F, 2.0F, var7, new ColorRGBA(255.0F, 255.0F, 255.0F, 35.0F * var6));
         // Themed ambient glow perimeter
         var1.drawBlurredRect(var2, var3, var4, var5, 12.0F, 2.0F, var7, themeAccent.withAlpha(45.0F * var6));
      } else {
         var1.drawRoundedRect(var2, var3, var4, var5, var7, this.I_field_dd60e8c.I_method_915b8ae().withAlpha(216.75F * var6));
      }

      // Apple TrueDepth Sensor Notch (Left side camera lens dot)
      boolean hasMusic = this.I_field_46890e8c instanceof IiiIIIIIi_Class194 || this.I_field_6f3d2a6c != null;
      if (var4 > 32.0F && !hasMusic && !this.II_field_5a) {
         float lensY = var3 + var5 / 2.0F;
         float lensX = var2 + 6.5F;
         var1.drawSquircle(lensX - 2.5F, lensY - 2.5F, 5.0F, 5.0F, 2.5F, IIiii_Class8.I_method_893b2757(2.5F), new ColorRGBA(3.0F, 3.0F, 6.0F, 230.0F * var6));
         var1.drawSquircle(lensX - 1.8F, lensY - 1.8F, 3.6F, 3.6F, 1.8F, IIiii_Class8.I_method_893b2757(1.8F), new ColorRGBA(12.0F, 22.0F, 48.0F, 190.0F * var6));
         var1.drawSquircle(lensX - 1.0F, lensY - 1.0F, 1.2F, 1.2F, 0.6F, IIiii_Class8.I_method_893b2757(0.6F), new ColorRGBA(150.0F, 210.0F, 255.0F, 190.0F * var6));
      }

   }

   private void I_method_38001739(III var1, float var2, float var3, float var4) {
      if (I_field_3a9bda27.player != null && !(I_field_3a9bda27.currentScreen instanceof IiIiiiIii_Class188)) {
         float var5 = 1.0F - this.I_field_dc7facc.I_method_6ac4da6f();
         Matrix4f var6 = var1.getMatrices().peek().getPositionMatrix();
         IIiIIi_Class10 var7 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
         String var8 = iIIIIiIiI_Class267.i_method_8e352841();
         this.I_field_4511da6c
            .I_method_2aebfd1e(
               var7.I_method_36d49b4b(),
               var8,
               var7.iI_method_24b6c285(),
               var6,
               var2 - IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F).I_method_2c375926(var8) - 4.0F,
               var3 + 5.0F,
               var5
            );
         float var9 = 19.0F * this.iI_field_dc7facc.I_method_6ac4da6f();
         if (!I_field_3a9bda27.isInSingleplayer() && I_field_3a9bda27.player.networkHandler.getPlayerListEntry(I_field_3a9bda27.player.getUuid()) != null) {
            this.I_method_58a034b9(var1, var6, var2 + var4 + var9, var3, var5);
         } else {
            this.I_field_4511da6c.I_method_694f063b("plane", var6, var2 + var4 + var9 + 8.0F, var3 + 3.5F, 8.0F, var5);
         }

         this.I_field_4511da6c.I_method_24d5ea1f();
      }
   }

   private IiiIIIIIi_Class194 I_method_c267d70e(IiIiiIiii_Class184 var1, List<IiIiiIiii_Class184> var2) {
      if (!(var1 instanceof IiiIIIIII_Class193)) {
         return null;
      } else {
         for (IiIiiIiii_Class184 var4 : var2) {
            if (var4 instanceof IiiIIIIIi_Class194 var5) {
               return var5;
            }
         }

         return null;
      }
   }

   private void I_method_f1523867(IiiIIIIIi_Class194 var1) {
      boolean var2 = var1 != null;
      this.Ii_field_dc7facc.I_method_edd72835(var2);
      if (!var2) {
         if (this.I_field_9012be67 != null
            && (
               this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.I_field_56fbb866
                  || this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.i_field_56fbb866
            )) {
            this.I_field_9012be67.beginExit(0.0F);
         }
      } else {
         if (this.I_field_9012be67 == null) {
            this.I_field_9012be67 = new IiIiiIIII_Class177.Nested1_ab89c20();
            this.I_field_9012be67.beginEnter(0.0F);
         } else if (this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866
            || this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866
            || this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
            this.I_field_9012be67.beginEnter(0.0F);
         }

         this.I_field_9012be67.I_method_7ae3c64c(var1);
      }
   }

   private void iI_method_99c2bd02() {
      boolean var1 = this.I_field_9012be67 != null
         && (
            this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.I_field_56fbb866
               || this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.i_field_56fbb866
         );
      this.iI_field_dc7facc.I_method_edd72835(var1);
      this.I_field_5a = this.iI_field_dc7facc.I_method_6ac4da6f() > 0.004F
         || this.I_field_9012be67 != null && this.I_field_9012be67.phase() != iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866;
   }

   private void i_method_4df998d9(III var1, float var2, float var3, float var4, float var5, float var6) {
      this.I_method_386424f9(var1, var2, var3, var4, var5, var6);
   }

   private void I_method_d420e1e7(III var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      var1.drawBlurredRect(var2, var3, var4, var5, 45.0F, 2.0F, IIiii_Class8.I_method_893b2757(var6), ColorRGBA.WHITE.withAlpha(255.0F * var7));
   }

   private void I_method_6739979(III var1, float var2) {
      if (this.I_field_9012be67 != null && this.I_field_9012be67.phase() != iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866) {
         this.I_field_9012be67.snapAt(this.III_field_46 - 7.5F, this.IIi_field_46 - 7.5F);
         this.I_field_9012be67.prepareRoot();
         this.I_field_9012be67.tick(var2, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
         this.I_field_9012be67.draw(var1, this.Ii_method_980e58b2());
      }
   }

   private void II_method_fbd20dbc(III var1, float var2, float var3, float var4, float var5, float var6) {
      IIiii_Class8 var7 = IIiii_Class8.I_method_893b2757(var5 / 2.0F);
      ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
      var1.drawShadow(var2, var3, var4, var5, 12.0F, var7, new ColorRGBA(0.0F, 0.0F, 0.0F, 150.0F * var6));
      if (InterfaceModule.IiI_method_c4cbfac3()) {
         var1.drawLiquidGlass(
            var2 - 1.0F,
            var3 - 1.0F,
            var4 + 2.0F,
            var5 + 2.0F,
            var5 / 2.0F,
            0.15F,
            var7,
            ColorRGBA.WHITE.withAlpha(255.0F * this.animation.I_method_6ac4da6f() * InterfaceModule.I_method_fdcdb22f() * var6)
         );
         var1.drawSquircle(var2, var3, var4, var5, 2.0F, var7, new ColorRGBA(7.0F, 8.0F, 13.0F, 245.0F * var6));
         var1.drawSquircleBorder(var2, var3, var4, var5, 0.8F, 2.0F, var7, new ColorRGBA(255.0F, 255.0F, 255.0F, 40.0F * var6));
         var1.drawBlurredRect(var2, var3, var4, var5, 10.0F, 2.0F, var7, themeAccent.withAlpha(35.0F * var6));
      } else if (InterfaceModule.iII_method_f9a41e83()) {
         var1.drawSquircle(var2 - 1.0F, var3 - 1.0F, var4 + 2.0F, var5 + 2.0F, 2.0F, var7, IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(25.5F * var6));
         var1.drawBlurredRect(var2, var3, var4, var5, 45.0F, 2.0F, var7, ColorRGBA.WHITE.withAlpha(255.0F * var6));
         var1.drawSquircle(var2, var3, var4, var5, 2.0F, var7, this.I_field_dd60e8c.I_method_915b8ae().withAlpha(216.75F * var6));
      } else {
         var1.drawRoundedRect(var2, var3, var4, var5, var7, IiiiiIIIi_Class242.iI_field_d0c8ec5.withAlpha(235.0F * var6));
      }
   }

   private void I_method_58a034b9(III var1, Matrix4f var2, float var3, float var4, float var5) {
      this.II_field_dc7facc
         .I_method_edd72835(iIIiIIIiI_Class291.I_method_da20b32b(var3 + 4.0F + 4.0F * this.II_field_dc7facc.I_method_6ac4da6f(), var4 + 5.0F, 12.8F, 7.0, var1));
      this.I_field_4511da6c.I_method_8cf520c5(var2, var3 + 10.0F, var4 + 8.0F);
      int var6 = I_field_3a9bda27.player.networkHandler.getPlayerListEntry(I_field_3a9bda27.player.getUuid()).getLatency();
      IIiIIi_Class10 var7 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
      this.I_field_4511da6c
         .I_method_2aebfd1e(
            var7.I_method_36d49b4b(),
            var6 + " ms",
            var7.iI_method_24b6c285(),
            var2,
            var3 + 4.0F + 4.0F * this.II_field_dc7facc.I_method_6ac4da6f(),
            var4 + 5.0F,
            var5 * this.II_field_dc7facc.I_method_6ac4da6f()
         );
      float var8 = 1.0F - this.II_field_dc7facc.I_method_6ac4da6f();
      if (var8 > 0.0F) {
         float var9 = var5 * 0.2F * var8;
         float var10 = var5 * var8;
         float var11 = var10 + var9 * (1.0F - var10);

         for (int var12 = 0; var12 < I_field_b4e.length; var12++) {
            float var13 = var6 < I_field_b4e[var12] ? var11 : var9;
            this.I_field_4511da6c
               .I_method_59318fc7(
                  var2, var3 + 9.0F + var12 * 2.7F + 4.0F * this.II_field_dc7facc.I_method_6ac4da6f(), var4 + 8.0F - var12, 2.0F, 3 + var12, var13
               );
         }
      }

      this.I_field_4511da6c.I_method_228caaf5();
   }

   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (I_field_3a9bda27.currentScreen instanceof ChatScreen && this.isHovered(var1, var3)) {
         if (var5 == IiIII_Class9.i_field_2f4c8d6c) {
            super.onMouseClicked(var1, var3, var5);
            return;
         } else if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
            this.beginDrag(var1, var3);
            this.customPos = true;
            this.customCenterX = this.x + this.width / 2.0F;
            this.customY = this.y;
            return;
         }
      }

      if (I_field_3a9bda27.currentScreen != null && this.isHovered(var1, var3)) {
         if (var5 == IiIII_Class9.i_field_2f4c8d6c) {
            this.customPos = false;
            this.customCenterX = -1.0F;
            this.customY = -1.0F;
            IiIIiIiI_Class75.I_method_6a4509fa(this);
            return;
         } else if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
            IiIiiIiii_Class184 activeModule = this.I_method_fc091b55();
            if (activeModule != null && this.II_field_5a) {
               iiI_Class7 elem = activeModule.element(this);
               if (elem != null && elem.mouseClicked((float)var1, (float)var3, var5)) {
                  return;
               }
            }
            this.beginDrag(var1, var3);
            this.customPos = true;
            this.customCenterX = this.x + this.width / 2.0F;
            this.customY = this.y;
            this.I_method_60a3f448((float)var1, (float)var3, var5.I_method_6d899712());
            return;
         }
      }
      if (var5 != IiIII_Class9.I_field_2f4c8d6c || !this.I_method_6636d2a3((float)var1, (float)var3)) {
         this.I_method_60a3f448((float)var1, (float)var3, var5.I_method_6d899712());
      }
   }

   @Override
   public void onMouseReleased(double var1, double var3, IiIII_Class9 var5) {
      super.onMouseReleased(var1, var3, var5);
      if (this.customPos) {
         this.customCenterX = this.x + this.width / 2.0F;
         this.customY = this.y;
         IiIIiIiI_Class75.I_method_6a4509fa(this);
      }
   }

   public boolean I_method_60a3f448(float var1, float var2, int var3) {
      boolean var4 = iIIiIIIiI_Class291.I_method_c3f86263(this.x, this.y, this.width, this.height, var1, var2);
      if (var4 && var3 == 0 && this.iI_method_99c2bd06()) {
         return true;
      } else {
         IiIiiIiii_Class184 var5 = this.I_method_fc091b55();
         if (var5 == null) {
            return false;
         } else if (this.II_field_5a) {
            if (!var4) {
               this.II_field_5a = false;
               this.ii_method_99d148e2();
            } else {
               this.I_method_17c1c51c(var5, var1, var2, var3);
            }

            return true;
         } else if (!var4) {
            return false;
         } else {
            if (var5.isExpandable()) {
               this.II_field_5a = true;
               if (var5 == this.I_field_6f3d2a6c) {
                  this.i_field_5a = false;
               }
            } else {
               this.I_method_17c1c51c(var5, var1, var2, var3);
            }

            return true;
         }
      }
   }

   private boolean I_method_6636d2a3(float var1, float var2) {
      if (this.I_field_9012be67 != null
         && (
            this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.I_field_56fbb866
               || this.I_field_9012be67.phase() == iiI_Class7.Nested1_5f2d9729.i_field_56fbb866
         )
         && this.I_field_9012be67.contains(var1, var2)) {
         IiiIIIIIi_Class194 var3 = this.I_field_9012be67.I_method_737fd8b0();
         if (var3 == null) {
            return false;
         } else {
            this.I_field_6f3d2a6c = var3;
            this.i_field_5a = true;
            this.II_field_4a = System.currentTimeMillis();
            this.II_field_5a = false;
            return true;
         }
      } else {
         return false;
      }
   }

   private void ii_method_99d148e2() {
      this.I_field_6f3d2a6c = null;
      this.i_field_5a = false;
      this.II_field_4a = 0L;
   }

   private void I_method_17c1c51c(IiIiiIiii_Class184 var1, float var2, float var3, int var4) {
      iiI_Class7 var5 = var1.element(this);
      if (!var5.mouseClicked(var2, var3, IiIII_Class9.I_method_40dce65a(var4))) {
         var1.click(var2, var3, var4);
      }
   }

   private boolean iI_method_99c2bd06() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.iI_field_4a > 900L) {
         this.i_field_49 = 0;
      }

      this.iI_field_4a = var1;
      this.i_field_49++;
      if (this.i_field_49 >= 5 && !this.II_method_2a3a6525().stream().noneMatch(var0 -> var0 instanceof IiIiiiiIi_Class190)) {
         this.i_field_49 = 0;
         this.II_field_5a = false;
         if (!InterfaceModule.iII_method_f9a41e83()) {
            I_field_3a9bda27.setScreen(new IiIiiiIii_Class188());
         }

         return true;
      } else {
         return false;
      }
   }

   @Generated
   public MultiSelectSetting I_method_7163c735() {
      return this.I_field_bbe3ba6c;
   }

   @Generated
   public BooleanSetting I_method_6fa0d715() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public TextSetting I_method_28980f95() {
      return this.I_field_731802cc;
   }

   @Generated
   public IiIiiIiiI_Class183 I_method_fc091775() {
      return this.I_field_46890aac;
   }

   @Generated
   public IiiiIiIii_Class236 I_method_c3480795() {
      return this.I_field_dc7facc;
   }

   @Generated
   public IiiiIiIii_Class236 i_method_d8dd7b75() {
      return this.i_field_dc7facc;
   }

   @Generated
   public IiiiIiIii_Class236 II_method_86b5f058() {
      return this.II_field_dc7facc;
   }

   @Generated
   public IiiiIiIii_Class236 Ii_method_9c4b6438() {
      return this.Ii_field_dc7facc;
   }

   @Generated
   public IiiiIiIii_Class236 iI_method_23cef878() {
      return this.iI_field_dc7facc;
   }

   @Generated
   public IiiiIiiIi_Class238 I_method_c3561b55() {
      return this.I_field_dd60e8c;
   }

   @Generated
   public iIiiiiiiI_Class383 I_method_fa91e735() {
      return this.I_field_4511da6c;
   }

   @Generated
   public IiIiiIiII_Class181 I_method_fc089f55() {
      return this.I_field_4688928c;
   }

   @Generated
   public iii_Class8 I_method_dc1bfa15() {
      return this.I_field_b584628c;
   }

   @Generated
   public IiIiiIiii_Class184 i_method_119e8f35() {
      return this.I_field_46890e8c;
   }

   @Generated
   public IiIiiIiii_Class184 II_method_bf770418() {
      return this.i_field_46890e8c;
   }

   @Generated
   public IiIiiIIII_Class177.Nested1_ab89c20 I_method_e5c2bcf0() {
      return this.I_field_9012be67;
   }

   @Generated
   public boolean I_method_a1cdf663() {
      return this.I_field_5a;
   }

   @Generated
   public float I_method_a1cdf64f() {
      return this.III_field_46;
   }

   @Generated
   public float i_method_a1dc822f() {
      return this.IIi_field_46;
   }

   @Generated
   public float II_method_97ffccd2() {
      return this.IiI_field_46;
   }

   @Generated
   public IiiIIIIIi_Class194 I_method_24bd3735() {
      return this.I_field_6f3d2a6c;
   }

   @Generated
   public boolean i_method_a1dc8243() {
      return this.i_field_5a;
   }

   @Generated
   public long I_method_a1cdf653() {
      return this.II_field_4a;
   }

   @Generated
   public long i_method_a1dc8233() {
      return this.Ii_field_4a;
   }

   @Generated
   public boolean II_method_97ffcce6() {
      return this.II_field_5a;
   }

   @Generated
   public int I_method_a1cdf652() {
      return this.i_field_49;
   }

   @Generated
   public long II_method_97ffccd6() {
      return this.iI_field_4a;
   }

   final class Nested1_ab89c20 extends iiI_Class7 {
      private static final int I_field_49 = 4;
      private IiiIIIIIi_Class194 I_field_6f3d2a6c;

      Nested1_ab89c20() {
         this.size(15.0F, 15.0F);
         this.motion(IIii_Class4.I_method_3682ece9(260L, IiiiIiiII_Class237.III_field_dd60aac));
         this.lifeMotion(IIii_Class4.I_method_3682ece9(260L, IiiiIiiII_Class237.III_field_dd60aac));
         this.transition(IiIiiIIII_Class177.I_field_f94500c1);
         this.interactive(false);
      }

      void I_method_7ae3c64c(IiiIIIIIi_Class194 var1) {
         this.I_field_6f3d2a6c = var1;
      }

      IiiIIIIIi_Class194 I_method_737fd8b0() {
         return this.I_field_6f3d2a6c;
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         if (this.I_field_6f3d2a6c != null) {
            this.I_method_7ba03074(var1, var2);
         }
      }

      private void I_method_7ba03074(III var1, float var2) {
         float var3 = 1.0F;
         float var4 = 0.9F;
         float var5 = 4.0F * var3 + 3.0F * var4;
         float var6 = this.x() + (this.w() - var5) / 2.0F;
         float[] var7 = this.I_field_6f3d2a6c.I_method_724e0aa2();
         ColorRGBA var8 = this.I_field_6f3d2a6c.I_method_e924648e().withAlpha(255.0F * var2);

         for (int var9 = 0; var9 < 4; var9++) {
            float var10 = Math.clamp(1.5F + var7[var9] * 0.75F, 2.5F, 9.5F);
            float var11 = var6 + var9 * (var3 + var4);
            var1.drawRoundedRect(var11, this.y() + (this.h() - var10) / 2.0F, var3, var10, IIiii_Class8.I_method_893b2757(var3 / 2.0F), var8);
         }
      }
   }
}
