package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.profile.Profile;
import ua.mintantileak.spk.Compile;

public class IiiIiIiiI_Class215 extends IiiIIiiiI_Class207 implements IiiIiIIiI_Class211 {
   private static final IIii_Class4 I_field_f93678c1 = IIii_Class4.I_method_3682ece9(160L, IiiiIiiII_Class237.IIII_field_dd60aac);
   private static final float I_field_46 = 488.0F;
   private static final float i_field_46 = 318.0F;
   private static final float II_field_46 = 33.0F;
   private static final float Ii_field_46 = 101.0F;
   private static final float iI_field_46 = 24.0F;
   private static final float ii_field_46 = 11.0F;
   private static final float III_field_46 = 10.5F;
   private static final float IIi_field_46 = 2.0F;
   private static final float IiI_field_46 = 2.0F;
   private static final float Iii_field_46 = 22.0F;
   private static final float iII_field_46 = 5.5F;
   private static final float iIi_field_46 = 5.0F;
   private static final float iiI_field_46 = 72.0F;
   private static final float iii_field_46 = 5.0F;
   private static final float IIII_field_46 = 1.0F;
   private static final float IIIi_field_46 = 3.0F;
   private static final float IIiI_field_46 = 0.68F;
   private static final float IIii_field_46 = 5.0F;
   private static final float IiII_field_46 = 2.0F;
   private static final float IiIi_field_46 = -3.0F;
   private static final float IiiI_field_46 = -9.0F;
   private static final float Iiii_field_46 = 7.0F;
   private static final float iIII_field_46 = 5.0F;
   private static final float iIIi_field_46 = 90.0F;
   private static final float iIiI_field_46 = 17.0F;
   private static final float iIii_field_46 = 5.0F;
   private static final float iiII_field_46 = 7.0F;
   private static final float iiIi_field_46 = 6.0F;
   private static final float iiiI_field_46 = 300.0F;
   private static final float iiii_field_46 = 0.35F;
   private static final float IIIII_field_46 = 12.0F;
   private static final float IIIIi_field_46 = 300.0F;
   private static final float IIIiI_field_46 = 1600.0F;
   private static final float IIIii_field_46 = 0.4F;
   private final Map<ModuleEntry, iii_Class8> I_field_a567c40b = new IdentityHashMap<>();
   private final Map<Setting, iii_Class8> i_field_a567c40b = new IdentityHashMap<>();
   private ModuleCategory I_field_75f1ef41;
   private ModuleEntry I_field_75e36361;
   private ModuleEntry i_field_75e36361;
   private iii_Class8 I_field_b584628c;
   private float IIiII_field_46;
   private iii_Class8 i_field_b584628c;
   private iii_Class8 II_field_b584628c;
   private iii_Class8 Ii_field_b584628c;
   private iii_Class8 iI_field_b584628c;
   private Iii_Class4 I_field_b575d6ac;
   private Iii_Class4 i_field_b575d6ac;
   private IiIiIIIII_Class161 I_field_fdef2cc;
   private iiiI_Class15 I_field_fb07f0e1;
   private IIIIi_Class2 I_field_2d89a12c;
   private iiI_Class7 I_field_b5845eac;
   private iii_Class8 ii_field_b584628c;
   private long I_field_4a;
   private float IIiIi_field_46;
   private float IIiiI_field_46;
   private float IIiii_field_46;
   private float IiIII_field_46;
   private List<ModuleEntry> I_field_7865b31;
   private List<Setting> i_field_7865b31;
   private int I_field_49;
   private ModuleEntry II_field_75e36361;
   private String I_field_523beb0a;
   private float IiIIi_field_46;
   private long i_field_4a;
   private long II_field_4a;
   private long Ii_field_4a;
   Vec3d I_field_5bba0d50;
   private Vec3d i_field_5bba0d50;
   Vec3d II_field_5bba0d50;
   Vec3d Ii_field_5bba0d50;
   private float IiIiI_field_46;
   private float IiIii_field_46;
   private float IiiII_field_46;
   private float IiiIi_field_46;
   private float IiiiI_field_46;
   private float Iiiii_field_46;
   private float iIIII_field_46;
   private float iIIIi_field_46;
   static final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
   static boolean I_field_5a;
   static boolean i_field_5a;
   static IiiIiIiiI_Class215 I_field_a5e73e6c;

   private boolean floatingSearchOpen = false;
   private float floatingSearchX = -1.0F;
   private float floatingSearchY = -1.0F;
   private float floatingSearchW = 320.0F;
   private float floatingSearchH = 240.0F;
   private boolean floatingSearchDragging = false;
   private float floatingSearchDragOffsetX = 0.0F;
   private float floatingSearchDragOffsetY = 0.0F;
   private String floatingSearchQuery = "";
   private float floatingSearchScroll = 0.0F;

   public static float guiPosX = -1.0F;
   public static float guiPosY = -1.0F;
   private boolean guiDragging = false;
   private float guiDragOffsetX = 0.0F;
   private float guiDragOffsetY = 0.0F;
   private final ClickBubbleEffect clickBubbleEffect = new ClickBubbleEffect();

   private String toastTitle = null;
   private String toastDesc = null;
   private long toastStartTime = 0L;
   private float toastAnimProgress = 0.0F;



   public void showToastNotification(String title, String desc) {
      this.toastTitle = title;
      this.toastDesc = desc != null && !desc.isEmpty() ? desc : "Описание отсутствует";
      this.toastStartTime = System.currentTimeMillis();
      if (MinecraftClient.getInstance().player != null) {
         MinecraftClient.getInstance().player.playSound(net.minecraft.sound.SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, 0.4F, 1.3F);
      }
   }



   public void toggleFloatingSearch() {
      this.floatingSearchOpen = !this.floatingSearchOpen;
      if (this.floatingSearchOpen) {
         if (this.floatingSearchX < 0.0F || this.floatingSearchY < 0.0F) {
            this.floatingSearchX = Math.round((this.width - this.floatingSearchW) / 2.0F);
            this.floatingSearchY = Math.round((this.height - this.floatingSearchH) / 2.0F);
         }
         this.floatingSearchScroll = 0.0F;
      }
   }

   @Override
   protected boolean lowDrawBatching() {
      return true;
   }

   public IiiIiIiiI_Class215() {
      this.I_field_75f1ef41 = ModuleCategory.VISUALS;
      this.IIiiI_field_46 = Float.NaN;
      this.IIiii_field_46 = Float.NaN;
      this.IiIII_field_46 = Float.NaN;
      this.I_field_7865b31 = List.of();
      this.i_field_7865b31 = List.of();
      this.I_field_49 = -1;
      this.I_field_523beb0a = "";
      IIIIi_Class2.III_method_92ee7b3f();
   }

   @Compile(
      obfuscation = 4
   )
   @Override
   public void init() {
      super.init();
      this.closing = false;
      this.contentAlpha = 1.0F;
      this.i_field_75e36361 = null;
      this.IiIIi_field_46 = 0.0F;
      this.i_field_4a = 0L;
      this.II_field_4a = System.currentTimeMillis();
      this.IIiiI_field_46 = Float.NaN;
      iIiiIIiii_Class360.I_field_6424b12c.i_method_6e3866bf();
      this.clearRoots();
      this.IiiII_field_46 = Math.min(488.0F, Math.max(360.0F, this.width - 12.0F));
      this.IiiIi_field_46 = Math.min(318.0F, Math.max(235.0F, this.height - 12.0F));
      if (guiPosX < 0.0F || guiPosY < 0.0F || guiPosX > this.width || guiPosY > this.height) {
         guiPosX = Math.round((this.width - this.IiiII_field_46) / 2.0F);
         guiPosY = Math.round((this.height - this.IiiIi_field_46) / 2.0F);
      }
      this.IiIiI_field_46 = guiPosX;
      this.IiIii_field_46 = guiPosY;
      this.iIIIi_field_46 = 28.0F;
      this.Iiiii_field_46 = 135.0F;
      this.iIIII_field_46 = this.IiiII_field_46 - this.Iiiii_field_46;
      this.IIiII_field_46 = Math.max(80.0F, (this.iIIII_field_46 - 22.0F - 5.0F - 5.0F) / 2.0F);
      if (this.I_field_fdef2cc == null) {
         this.I_field_fdef2cc = new IiIiIIIII_Class161(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F));
         this.I_field_fdef2cc.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("search"));
      }

      iii_Class8 var1 = (new iii_Class8() {
            @Override
            protected void drawChildren(III var1, float var2) {
               iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), this.x(), this.y(), this.w(), this.h());
               super.drawChildren(var1, var2);
               iIiiiIiII_Class373.I_method_ff80a1df();
            }
         })
         .I_method_485bccf5()
         .I_method_84672d76(IIii_Class4.II_field_f93678c1)
         .i_method_8c7d3515(this.IiiII_field_46, this.IiiIi_field_46)
         .I_method_f136b1d8((var1x, var2) -> this.I_method_c6137aff(var1x, var2));
      var1.iii_method_df275535();
      var1.snapSize();
      var1.snapAt(this.IiIiI_field_46, this.IiIii_field_46);
      var1.manuallyPositioned(true);
      var1.I_method_8939bffd(this.I_method_894df1d5());
      iii_Class8 bodyRow = new iii_Class8()
         .i_method_c88da8d5()
         .i_method_8c7d3515(this.IiiII_field_46, this.IiiIi_field_46 - this.iIIIi_field_46);
      bodyRow.I_method_8939bffd(this.i_method_97fcdb5());
      this.iI_field_b584628c = this.II_method_18597158();
      bodyRow.I_method_8939bffd(this.iI_field_b584628c);
      var1.I_method_8939bffd(bodyRow);
      this.Ii_field_b584628c = var1;
      this.add(var1);
      this.I_field_2d89a12c = new IIIIi_Class2(var1, this::I_method_74e4f766)
         .I_method_5a9bd0bd(this.i_field_b575d6ac)
         .I_method_562751de(this.I_field_b575d6ac, IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F));
      this.add(this.I_field_2d89a12c);
      this.add(this.I_field_2d89a12c.IIii_method_d1a53438());
      this.add(this.I_field_2d89a12c.IiII_method_6941c18());
      this.I_field_7865b31 = List.of();
      this.i_field_7865b31 = List.of();
      this.I_field_523beb0a = "\u0000";
      this.I_method_f6d12895(true);
      this.i_method_f89418b5(true);
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 I_method_894df1d5() {
      // Apple macOS Traffic Lights with real functionality:
      // Red: Close screen, Yellow: Decrease GUI scale, Green: Increase GUI scale
      // Pure sleek hover glow without +/-/x glyphs
      Iii_Class4 btnClose = new Iii_Class4()
         .size(10.0F, 10.0F)
         .radius(5.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick((Runnable)this::close)
         .paint((var0, var1x) -> {
            float x = var1x.x();
            float y = var1x.y();
            float w = var1x.w();
            float h = var1x.h();
            float r = w / 2.0F;
            float hov = var1x.hover();
            IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(r);
            if (hov > 0.01F) {
               var0.drawBlurredRect(x - 2.5F, y - 2.5F, w + 5.0F, h + 5.0F, 8.0F, IIiii_Class8.I_method_893b2757(r + 2.5F), new ColorRGBA(255.0F, 70.0F, 70.0F, 140.0F * hov));
            }
            var0.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(255.0F, 95.0F + 35.0F * hov, 86.0F + 25.0F * hov, 255.0F));
            var0.drawRoundedBorder(x, y, w, h, 0.75F, rad, new ColorRGBA(224.0F, 68.0F + 30.0F * hov, 62.0F, 220.0F));
         });

      Iii_Class4 btnMinimize = new Iii_Class4()
         .size(10.0F, 10.0F)
         .radius(5.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick((Runnable)() -> {
            MenuModule menuMod = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
            if (menuMod != null && menuMod.getGuiScaleSetting() != null) {
               float cur = menuMod.getGuiScale();
               float next = Math.max(0.70F, Math.round((cur - 0.10F) * 100.0F) / 100.0F);
               menuMod.getGuiScaleSetting().Ii_method_4e0e6b54(next);
               this.init();
            }
         })
         .paint((var0, var1x) -> {
            float x = var1x.x();
            float y = var1x.y();
            float w = var1x.w();
            float h = var1x.h();
            float r = w / 2.0F;
            float hov = var1x.hover();
            IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(r);
            if (hov > 0.01F) {
               var0.drawBlurredRect(x - 2.5F, y - 2.5F, w + 5.0F, h + 5.0F, 8.0F, IIiii_Class8.I_method_893b2757(r + 2.5F), new ColorRGBA(255.0F, 195.0F, 45.0F, 140.0F * hov));
            }
            var0.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(255.0F, 189.0F + 30.0F * hov, 46.0F + 30.0F * hov, 255.0F));
            var0.drawRoundedBorder(x, y, w, h, 0.75F, rad, new ColorRGBA(222.0F, 161.0F + 30.0F * hov, 35.0F, 220.0F));
         });

      Iii_Class4 btnMaximize = new Iii_Class4()
         .size(10.0F, 10.0F)
         .radius(5.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick((Runnable)() -> {
            MenuModule menuMod = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
            if (menuMod != null && menuMod.getGuiScaleSetting() != null) {
               float cur = menuMod.getGuiScale();
               float next = Math.min(1.40F, Math.round((cur + 0.10F) * 100.0F) / 100.0F);
               menuMod.getGuiScaleSetting().Ii_method_4e0e6b54(next);
               this.init();
            }
         })
         .paint((var0, var1x) -> {
            float x = var1x.x();
            float y = var1x.y();
            float w = var1x.w();
            float h = var1x.h();
            float r = w / 2.0F;
            float hov = var1x.hover();
            IIiii_Class8 rad = IIiii_Class8.I_method_893b2757(r);
            if (hov > 0.01F) {
               var0.drawBlurredRect(x - 2.5F, y - 2.5F, w + 5.0F, h + 5.0F, 8.0F, IIiii_Class8.I_method_893b2757(r + 2.5F), new ColorRGBA(40.0F, 230.0F, 75.0F, 140.0F * hov));
            }
            var0.drawRoundedRect(x, y, w, h, rad, new ColorRGBA(39.0F + 25.0F * hov, 201.0F + 30.0F * hov, 63.0F + 25.0F * hov, 255.0F));
            var0.drawRoundedBorder(x, y, w, h, 0.75F, rad, new ColorRGBA(26.0F, 171.0F + 30.0F * hov, 41.0F, 220.0F));
         });

      Iii_Class4 brandTitle = new Iii_Class4()
         .size(46.0F, this.iIIIi_field_46)
         .paint((var0, var1x) -> {
            var0.drawText(
               IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
               "Agravity",
               var1x.x() + 3.0F,
               var1x.y() + (this.iIIIi_field_46 - 8.0F) / 2.0F + 1.0F,
               new ColorRGBA(235.0F, 240.0F, 255.0F, 230.0F)
            );
         })
         .draggable(iIi_Class6.i_field_b583ea6c);

      iii_Class8 leftBox = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(4.5F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 0.0F, 0.0F, 9.0F))
         .IIi_method_4dfc88d7(86.0F)
         .IiI_method_31d4c97(this.iIIIi_field_46);
      leftBox.I_method_8939bffd(btnClose);
      leftBox.I_method_8939bffd(btnMinimize);
      leftBox.I_method_8939bffd(btnMaximize);
      leftBox.I_method_8939bffd(brandTitle);

      iii_Class8 catTabs = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(3.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(2.0F, 0.0F, 2.0F, 0.0F));

      for (ModuleCategory cat : new ModuleCategory[]{
         ModuleCategory.VISUALS,
         ModuleCategory.PLAYER,
         ModuleCategory.INTERFACE,
         ModuleCategory.UTILS
      }) {
         Iii_Class4 tab = new Iii_Class4()
            .height(18.0F)
            .padding(IIII.I_method_12c9a0cb(2.0F, 5.0F, 2.0F, 5.0F))
            .icon(
               "category/" + cat.I_method_b23d1194().toLowerCase(),
               8.0F,
               var1x -> this.I_method_af54788e()
                  .mix(IiiiiIIIi_Class242.ii_field_d0c8ec5, var1x.sig("selected"))
                  .mulAlpha(0.65F + 0.35F * var1x.sig("selected"))
            )
            .text(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
               () -> cat.I_method_b23d1194(),
               var1x -> this.I_method_af54788e()
                  .mix(IiiiiIIIi_Class242.ii_field_d0c8ec5, var1x.sig("selected"))
                  .mulAlpha(0.70F + 0.30F * var1x.sig("selected"))
            )
            .background(var1x -> {
               float sel = var1x.sig("selected");
               float hov = var1x.hover();
               if (sel > 0.01F) {
                  return IiiiiIIIi_Class242.ii_field_d0c8ec5.withAlpha(50.0F * sel);
               }
               return I_method_f2c6fbd0(this.i_method_373b846e(), IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.035F * hov);
            })
            .radius(4.0F)
            .bind("selected", () -> this.I_field_75f1ef41 == cat, I_field_f93678c1)
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
            .onClick(() -> this.I_method_f9822ea0(cat));
         catTabs.I_method_8939bffd(tab);
      }

      Iii_Class4 searchBtn = new Iii_Class4()
         .size(56.0F, 17.0F)
         .radius(4.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick((Runnable)this::toggleFloatingSearch)
         .paint((var1x, var2x) -> {
            var1x.drawRoundedRect(
               var2x.x(), var2x.y(), var2x.w(), var2x.h(),
               IIiii_Class8.I_method_893b2757(4.0F),
               I_method_f2c6fbd0(this.II_method_1325cb91().withAlpha(165.0F), this.I_method_af54788e(), 0.04F + 0.04F * var2x.hover())
            );
            var1x.drawIcon("search", var2x.x() + 4.5F, var2x.y() + 4.5F, 8.0F, IiiiiIIIi_Class242.ii_field_d0c8ec5);
            var1x.drawText(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F),
               "Поиск",
               var2x.x() + 15.0F,
               var2x.y() + 5.0F,
               this.I_method_af54788e().mulAlpha(0.9F)
            );
         });

      this.i_field_b575d6ac = new Iii_Class4()
         .size(17.0F, 17.0F)
         .padding(4.0F)
         .icon("setting", 9.0F, var1x -> this.I_method_af54788e().mulAlpha(0.58F + 0.35F * var1x.hover()))
         .background(var1x -> I_method_f2c6fbd0(this.i_method_373b846e(), IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.025F * var1x.hover()))
         .radius(4.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick(this::i_method_9467d9ff);

      iii_Class8 rightBox = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(4.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 7.0F, 0.0F, 0.0F))
         .I_method_8939bffd(searchBtn)
         .I_method_8939bffd(this.i_field_b575d6ac);

      iii_Class8 header = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .IIi_method_4dfc88d7(this.IiiII_field_46)
         .IiI_method_31d4c97(this.iIIIi_field_46);
      header.I_method_8939bffd(leftBox);
      header.I_method_8939bffd(catTabs);
      header.I_method_8939bffd(rightBox);
      header.draggable(iIi_Class6.i_field_b583ea6c);
      return header;
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 i_method_97fcdb5() {
      float bodyH = Math.max(0.0F, this.IiiIi_field_46 - this.iIIIi_field_46);
      this.I_field_b584628c = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(2.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(4.0F, 5.0F, 5.0F, 4.0F))
         .IIi_method_4dfc88d7(this.Iiiii_field_46)
         .IiI_method_31d4c97(bodyH)
         .Ii_method_bb38d618()
         .I_method_3987f136(IiIi_Class6.I_field_f9448c81)
         .I_method_b65baecb(this::I_method_65a7e900);
      return new iii_Class8()
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(this.Iiiii_field_46)
         .IiI_method_31d4c97(bodyH)
         .I_method_8939bffd(this.I_field_b584628c);
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 II_method_18597158() {
      this.I_field_b575d6ac = new Iii_Class4()
         .size(81.0F, 12.0F)
         .radius(3.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick((var1x, var2x, var3x) -> {
            if (var1x == IiIII_Class9.I_field_2f4c8d6c) {
               this.toggleFloatingSearch();
            }
         })
         .paint(
            (var1x, var2x) -> {
               var1x.drawRoundedRect(
                  var2x.x(),
                  var2x.y(),
                  var2x.w(),
                  12.0F,
                  IIiii_Class8.I_method_893b2757(3.0F),
                  I_method_f2c6fbd0(this.II_method_1325cb91().withAlpha(173.40001F), this.I_method_af54788e(), 0.035F + 0.035F * var2x.hover())
               );
               var1x.drawIcon("search", var2x.x() + 3.5F, var2x.y() + 3.5F, 5.0F, IiiiiIIIi_Class242.ii_field_d0c8ec5);
               var1x.drawText(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.5F),
                  "Поиск [Ctrl+F]",
                  var2x.x() + 11.5F,
                  var2x.y() + 3.0F,
                  this.I_method_af54788e().mulAlpha(0.85F)
               );
            }
         );
      iii_Class8 var1 = (new iii_Class8() {
            @Override
            protected void drawChildren(III var1, float var2) {
               iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), this.x(), this.y() - 1.0F, this.w(), this.h() + 2.0F);
               super.drawChildren(var1, var2);
               iIiiiIiII_Class373.I_method_ff80a1df();
            }
         })
         .I_method_485bccf5()
         .I_method_483797dd(IIi_Class2.II_field_b5755e8c)
         .I_method_70a38517(1.0F)
         .i_method_8c7d3515(72.0F, 11.0F)
         .I_method_8939bffd(
            new Iii_Class4()
               .height(5.0F)
               .fillWidth()
               .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F), this::Ii_method_d800dfde, var1x -> this.I_method_af54788e())
               .textAlign(IIi_Class2.II_field_b5755e8c)
               .interactive(false)
         )
         .I_method_8939bffd(
            new Iii_Class4()
               .height(5.0F)
               .fillWidth()
               .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F), this::iI_method_1599839e, var1x -> this.I_method_af54788e().mulAlpha(0.52F))
               .textAlign(IIi_Class2.II_field_b5755e8c)
               .interactive(false)
         );
      Iii_Class4 var2 = new Iii_Class4()
         .size(12.0F, 12.0F)
         .interactive(false)
         .paint(
            (var0, var1x) -> var0.drawRoundedTexture(
               IIIIi_Class2.I_method_79e9d9ee(),
               var1x.x(),
               var1x.y(),
               var1x.w(),
               var1x.h(),
               IIiii_Class8.I_method_893b2757(var1x.w() / 2.0F),
               IiiiiIIIi_Class242.Ii_field_d0c8ec5
            )
         );
      iii_Class8 var3 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(3.0F)
         .I_method_8939bffd(var1)
         .I_method_8939bffd(var2);
      iii_Class8 var4 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 7.0F, 0.0F, 5.0F))
         .IiI_method_31d4c97(this.iIIIi_field_46)
         .III_method_9dc17555()
         .I_method_8361fbbd(iIi_Class6.i_field_b583ea6c);
      var4.snapSize();
      Iii_Class4 var5 = new Iii_Class4()
         .height(13.0F)
         .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(13.0F), this::i_method_a5af7881, var1x -> this.I_method_af54788e())
         .interactive(false);
      this.I_field_fb07f0e1 = new iiiI_Class15(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), this::I_method_94594e12, this::I_method_f6d0e8c4);
      iii_Class8 var6 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .IiI_method_31d4c97(12.0F)
         .I_method_879bc687(() -> this.I_field_75e36361 != null)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(this.I_field_fb07f0e1)
         .i_method_5db1deeb(this.I_field_fb07f0e1::I_method_10341dfa);

      Iii_Class4 infoBtn = new Iii_Class4()
         .size(13.0F, 13.0F)
         .radius(6.5F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .visibleWhen(() -> this.I_field_75e36361 != null)
         .onClick(() -> {
            if (this.I_field_75e36361 != null) {
               showToastNotification(this.I_field_75e36361.getName(), this.I_field_75e36361.i_method_bf522194());
            }
         })
         .paint((ctx, rect) -> {
            float hov = rect.hover();
            ColorRGBA accent = IiiiiIIIi_Class242.I_method_7df8e08e();
            ctx.drawRoundedRect(rect.x(), rect.y(), rect.w(), rect.h(), IIiii_Class8.I_method_893b2757(rect.w() / 2.0F), accent.withAlpha(45.0F + 55.0F * hov));
            ctx.drawRoundedBorder(rect.x(), rect.y(), rect.w(), rect.h(), 0.9F, IIiii_Class8.I_method_893b2757(rect.w() / 2.0F), accent.withAlpha(180.0F + 75.0F * hov));
            IIiIIi_Class10 iFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F);
            String iChar = "i";
            float iw = iFont.I_method_2c375926(iChar);
            ctx.drawText(iFont, iChar, rect.x() + (rect.w() - iw) / 2.0F, rect.y() + 2.5F, ColorRGBA.WHITE);
         });

      iii_Class8 var7 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(4.0F)
         .IiI_method_23cb1575()
         .I_method_8939bffd(var5)
         .I_method_8939bffd(infoBtn)
         .I_method_8939bffd(var6);
      Iii_Class4 var8 = new Iii_Class4()
         .size(16.0F, 16.0F)
         .padding(3.5F)
         .icon("xmark", 9.0F, var1x -> this.I_method_af54788e().mulAlpha(0.8F + 0.2F * var1x.hover()))
         .radius(4.0F)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .visibleWhen(() -> this.I_field_75e36361 != null)
         .onClick(() -> this.I_method_c2e71ac0(null));
      iii_Class8 var9 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .IiI_method_31d4c97(12.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(var7)
         .I_method_8939bffd(var8);
      iii_Class8 var11 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(1.0F)
         .IiI_method_31d4c97(14.0F)
         .III_method_9dc17555()
         .I_method_f136b1d8((var1x, var2x) -> this.i_method_f5052edf(var1x, var2x))
         .I_method_8939bffd(var9);
      this.i_field_b584628c = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(5.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(27.5F, 0.0F, 2.0F, 0.0F))
         .III_method_9dc17555();
      this.i_field_b584628c.snapSize();
      float var12 = Math.max(0.0F, this.IiiIi_field_46 - this.iIIIi_field_46 - 18.0F);
      float var13 = Math.max(80.0F, var12 - 10.5F - 2.0F);
      this.II_field_b584628c = new iii_Class8()
         .I_method_485bccf5()
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 5.0F, 0.0F, 0.0F))
         .IIi_method_4dfc88d7(this.iIIII_field_46 - 22.0F)
         .IiI_method_31d4c97(var13)
         .Ii_method_bb38d618()
         .II_method_d35e0034(80.0F)
         .I_method_3987f136(IiIi_Class6.I_field_f9448c81)
         .I_method_b65baecb(var1x -> {
            this.I_method_65a7e900(var1x);
            var1x.i_method_65326e43(-9.0F).I_method_4f0ff9cb(2.0F, 5.0F);
         })
         .I_method_8939bffd(this.i_field_b584628c);
      this.II_field_b584628c.snapSize();
      iii_Class8 var14 = new iii_Class8()
         .iI_method_c1109a58()
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(10.5F, 11.0F, 2.0F, 11.0F))
         .i_method_8c7d3515(this.iIIII_field_46, var12)
         .I_method_8939bffd(this.II_field_b584628c)
         .I_method_8939bffd(this.Ii_method_988b4d38())
         .I_method_8939bffd(this.iI_method_9e631178())
         .I_method_8939bffd(var11);
      var14.snapSize();
      iii_Class8 varBottom = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(10.5F, 2.0F, 4.0F, 0.0F))
         .IiI_method_31d4c97(16.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(this.I_field_b575d6ac);
      varBottom.snapSize();
      iii_Class8 var15 = new iii_Class8()
         .I_method_485bccf5()
         .i_method_8c7d3515(this.iIIII_field_46, this.IiiIi_field_46)
         .I_method_8939bffd(var4)
         .I_method_8939bffd(var14)
         .I_method_8939bffd(varBottom);
      var15.snapSize();
      return var15;
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 Ii_method_988b4d38() {
      iii_Class8 var1 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_4f3850da(1)
         .I_method_70a38517(5.0F)
         .I_method_8939bffd(this.I_method_358d385f("menu/swing", () -> "Swing Animations", iiIIIIII_Class193::new));
      var1.snapSize();
      IIiIIi_Class10 var2 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(9.0F);
      Iii_Class4 var3 = new Iii_Class4()
         .text(var2, () -> IiIiIIII_Class81.I_method_f25a980a("menu.modern.shortcuts"), var1x -> this.I_method_af54788e().mulAlpha(0.9F))
         .interactive(false);
      return new iii_Class8()
         .I_method_485bccf5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.i_field_f93600a1)
         .I_method_70a38517(6.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 0.0F, this.iIIIi_field_46 + 10.5F - 2.0F + var2.I_method_a649725c() + 6.0F, 0.0F))
         .IiI_method_23cb1575()
         .Ii_method_25479968(false)
         .I_method_e16e9925(() -> this.I_field_75e36361 == null, IiiiIiiII_Class237.IIii_field_dd60aac, 220L)
         .I_method_8939bffd(var3)
         .I_method_8939bffd(var1);
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 iI_method_9e631178() {
      Iii_Class4 var1 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(9.0F),
            () -> IiIiIIII_Class81.I_method_f25a980a("menu.modern.no_settings"),
            var1x -> this.I_method_af54788e().mulAlpha(0.55F)
         )
         .interactive(false);
      return new iii_Class8()
         .I_method_485bccf5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.i_field_f93600a1)
         .IiI_method_23cb1575()
         .Ii_method_25479968(false)
         .I_method_e16e9925(this::i_method_9467da03, IiiiIiiII_Class237.IIii_field_dd60aac, 220L)
         .I_method_8939bffd(var1);
   }

   private boolean i_method_9467da03() {
      if (this.I_field_75e36361 == null) {
         return false;
      } else {
         for (Setting var2 : this.I_field_75e36361.getSettings()) {
            if (var2.isVisible()) {
               return false;
            }
         }

         return true;
      }
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 I_method_358d385f(String var1, Supplier<String> var2, Supplier<Screen> var3) {
      iii_Class8 var4 = new iii_Class8();
      Iii_Class4 var5 = new Iii_Class4()
         .fill()
         .fade()
         .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), var2, var2x -> this.I_method_af54788e().mulAlpha(0.72F + 0.28F * var4.hover()))
         .interactive(false);
      Iii_Class4 var6 = new Iii_Class4()
         .size(7.0F, 7.0F)
         .icon(var1, 7.0F, var2x -> this.I_method_af54788e().mulAlpha(0.62F + 0.38F * var4.hover()))
         .interactive(false);
      return var4.i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .i_method_8c7d3515(90.0F, 17.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 5.0F, 0.0F, 6.0F))
         .iI_method_e886414(4.0F)
         .I_method_e53800a9(
            var0 -> I_method_f2c6fbd0(IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.4F), IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.05F * var0.hover())
         )
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(var5)
         .I_method_8939bffd(var6)
         .I_method_c0ca36f3(() -> this.I_method_24b192a3((Screen)var3.get()));
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_24b192a3(Screen var1) {
      if (var1 != null) {
         if (this.I_field_fb07f0e1 != null) {
            this.I_field_fb07f0e1.I_method_d4d8842c();
         }

         MinecraftClient.getInstance().setScreen(var1);
      }
   }

   private void I_method_c6137aff(III var1, iii_Class8 var2) {
      float var3 = var2.x();
      float var4 = var2.y();
      float var5 = var2.w();
      float var6 = var2.h();
      IIiii_Class8 rad12 = IIiii_Class8.I_method_893b2757(12.0F);
      ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
      boolean isCyber = "Tactical Cyber".equalsIgnoreCase(InterfaceModule.getVisualStyle()) || InterfaceModule.isCyberHud();

      // Deep frosted ambient drop shadow
      var1.drawShadow(var3, var4, var5, var6, 28.0F, rad12, ColorRGBA.BLACK.withAlpha(165.0F));

      if (isCyber) {
         var1.drawSquircle(var3, var4, var5, var6, 2.0F, rad12, new ColorRGBA(10.0F, 12.0F, 18.0F, 240.0F));
         var1.drawSquircleBorder(var3, var4, var5, var6, 1.2F, 2.0F, rad12, themeAccent.withAlpha(140.0F));
         var1.drawBlurredRect(var3, var4, var5, var6, 16.0F, 2.0F, rad12, themeAccent.withAlpha(45.0F));
      } else {
         // Authentic luxury Liquid Glass window body
         var1.drawBlurredRect(var3, var4, var5, var6, 32.0F, 12.0F, rad12, ColorRGBA.WHITE.withAlpha(200.0F));
         var1.drawLiquidGlass(var3, var4, var5, var6, 12.0F, 0.12F, rad12, ColorRGBA.WHITE);
         var1.drawRoundedRect(var3, var4, var5, var6, rad12, new ColorRGBA(14.0F, 16.0F, 22.0F, 175.0F));
         var1.drawRoundedBorder(var3, var4, var5, var6, 1.0F, rad12, new ColorRGBA(255.0F, 255.0F, 255.0F, 75.0F));
         var1.drawBlurredRect(var3, var4, var5, var6, 18.0F, 12.0F, rad12, themeAccent.withAlpha(45.0F));
      }

      // Sleek luminous division lines
      ColorRGBA divCol = isCyber ? themeAccent.withAlpha(90.0F) : new ColorRGBA(255.0F, 255.0F, 255.0F, 30.0F);
      var1.drawRect(var3 + 1.0F, var4 + this.iIIIi_field_46, var5 - 2.0F, 1.0F, divCol);
      var1.drawRect(var3 + this.Iiiii_field_46, var4 + this.iIIIi_field_46 + 1.0F, 1.0F, var6 - this.iIIIi_field_46 - 2.0F, divCol);
   }

   @Compile(
      obfuscation = 1
   )
   private void i_method_f5052edf(III var1, iii_Class8 var2) {
      // Intentionally empty: no obstructive backdrop box or blur over settings
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_f9822ea0(ModuleCategory var1) {
      if (this.I_field_75f1ef41 != var1) {
         if (this.I_field_fb07f0e1 != null) {
            this.I_field_fb07f0e1.I_method_d4d8842c();
         }

         this.I_field_75f1ef41 = var1;
         this.I_field_75e36361 = null;
         this.i_field_75e36361 = null;
         this.I_field_7865b31 = List.of();
         this.i_field_7865b31 = List.of();
         this.I_method_f6d12895(true);
         this.i_method_f89418b5(true);
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void i_method_9467d9ff() {
      if (this.I_field_2d89a12c != null) {
         this.I_field_2d89a12c.iI_method_59147882();
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_74e4f766(ModuleEntry var1, Setting var2) {
      if (var1 != null) {
         if (this.I_field_fb07f0e1 != null) {
            this.I_field_fb07f0e1.I_method_d4d8842c();
         }

         this.I_field_75f1ef41 = var1.getCategory();
         this.I_field_75e36361 = var1;
         this.I_field_7865b31 = List.of();
         this.i_field_7865b31 = List.of();
         this.I_method_f6d12895(true);
         this.i_method_f89418b5(true);
         if (this.II_field_b584628c != null) {
            this.II_field_b584628c.i_method_815a851f();
         }

         iiI_Class7 var3 = var2 != null ? this.i_field_a567c40b.get(var2) : this.I_field_a567c40b.get(var1);
         this.I_field_b5845eac = var3;
         this.ii_field_b584628c = var2 != null ? this.II_field_b584628c : this.I_field_b584628c;
         this.IIiIi_field_46 = var2 != null ? 7.0F : 3.0F;
         this.I_field_4a = var3 == null ? 0L : System.currentTimeMillis() + 1600L;
      }
   }

   @Override
   protected void afterRender(III var1) {
      this.I_method_f1003367(var1);
      if (this.floatingSearchOpen) {
         this.renderFloatingSearch(var1, (int)var1.I_method_b1c3e152(), (int)var1.i_method_b1d26d32());
      }
      this.renderToastNotification(var1);
      this.clickBubbleEffect.render(var1);
   }

   private void renderToastNotification(III ctx) {
      if (this.toastTitle == null) return;
      MenuModule menuMod = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
      float durationSec = menuMod != null ? menuMod.getToastDuration() : 4.0F;
      long elapsed = System.currentTimeMillis() - this.toastStartTime;
      long totalMs = (long) (durationSec * 1000.0F);

      if (elapsed > totalMs + 400L) {
         this.toastTitle = null;
         this.toastDesc = null;
         return;
      }

      float enterExit = 1.0F;
      if (elapsed < 300L) {
         enterExit = (float) elapsed / 300.0F;
      } else if (elapsed > totalMs) {
         enterExit = 1.0F - (float)(elapsed - totalMs) / 400.0F;
      }
      this.toastAnimProgress += (enterExit - this.toastAnimProgress) * 0.3F;

      float toastW = 240.0F;
      float toastH = 46.0F;
      float toastX = this.width - toastW - 16.0F;
      float toastY = 16.0F + (1.0F - this.toastAnimProgress) * -50.0F;

      ColorRGBA theme = IiiiiIIIi_Class242.I_method_7df8e08e();
      IIiii_Class8 rad8 = IIiii_Class8.I_method_893b2757(8.0F);

      ctx.drawBlurredRect(toastX, toastY, toastW, toastH, 18.0F, 4.0F, rad8, theme.withAlpha(90.0F * this.toastAnimProgress));
      ctx.drawRoundedRect(toastX, toastY, toastW, toastH, rad8, new ColorRGBA(12.0F, 14.0F, 22.0F, 235.0F * this.toastAnimProgress));
      ctx.drawRoundedBorder(toastX, toastY, toastW, toastH, 1.2F, rad8, theme.withAlpha(180.0F * this.toastAnimProgress));

      float iconSize = 18.0F;
      float iconX = toastX + 9.0F;
      float iconY = toastY + 9.0F;
      ctx.drawRoundedRect(iconX, iconY, iconSize, iconSize, IIiii_Class8.I_method_893b2757(iconSize / 2.0F), theme.withAlpha(60.0F * this.toastAnimProgress));
      ctx.drawRoundedBorder(iconX, iconY, iconSize, iconSize, 1.0F, IIiii_Class8.I_method_893b2757(iconSize / 2.0F), theme.withAlpha(200.0F * this.toastAnimProgress));
      IIiIIi_Class10 bFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(10.0F);
      float iw = bFont.I_method_2c375926("ℹ");
      ctx.drawText(bFont, "ℹ", iconX + (iconSize - iw) / 2.0F, iconY + 3.0F, ColorRGBA.WHITE.withAlpha(255.0F * this.toastAnimProgress));

      IIiIIi_Class10 titleFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.5F);
      IIiIIi_Class10 descFont = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5F);
      ctx.drawText(titleFont, this.toastTitle, toastX + 34.0F, toastY + 8.0F, ColorRGBA.WHITE.withAlpha(255.0F * this.toastAnimProgress));

      String desc = this.toastDesc;
      if (descFont.I_method_2c375926(desc) > toastW - 42.0F) {
         while (desc.length() > 3 && descFont.I_method_2c375926(desc + "...") > toastW - 42.0F) {
            desc = desc.substring(0, desc.length() - 1);
         }
         desc = desc + "...";
      }
      ctx.drawText(descFont, desc, toastX + 34.0F, toastY + 22.0F, new ColorRGBA(200.0F, 205.0F, 220.0F, 220.0F * this.toastAnimProgress));

      float pBarW = (toastW - 16.0F) * Math.max(0.0F, 1.0F - (float)elapsed / (float)totalMs);
      float pBarH = 2.0F;
      float pBarX = toastX + 8.0F;
      float pBarY = toastY + toastH - 5.0F;
      ctx.drawRoundedRect(pBarX, pBarY, pBarW, pBarH, IIiii_Class8.I_method_893b2757(1.0F), theme.withAlpha(220.0F * this.toastAnimProgress));
   }



   @Compile(
      obfuscation = 1
   )
   private void I_method_f1003367(III var1) {
      if (this.I_field_b5845eac != null) {
         long var2 = this.I_field_4a - System.currentTimeMillis();
         if (var2 > 0L && this.I_field_b5845eac.inFlow()) {
            float var4 = this.ii_field_b584628c == null ? 0.0F : this.ii_field_b584628c.Iii_method_61e30d8f();
            float var5 = this.I_field_b5845eac.x();
            float var6 = this.I_field_b5845eac.y() - var4;
            float var7 = this.I_field_b5845eac.w();
            float var8 = this.I_field_b5845eac.h();
            if (this.ii_field_b584628c != null) {
               float var9 = this.ii_field_b584628c.y();
               float var10 = this.ii_field_b584628c.y() + this.ii_field_b584628c.h();
               if (var6 < var9) {
                  var8 -= var9 - var6;
                  var6 = var9;
               }

               if (var6 + var8 > var10) {
                  var8 = var10 - var6;
               }
            }

            if (!(var7 <= 0.0F) && !(var8 <= 0.0F)) {
               float var11 = Math.min(1.0F, (float)var2 / 400.0F);
               var1.drawRoundedRect(
                  var5, var6, var7, var8, IIiii_Class8.I_method_893b2757(this.IIiIi_field_46), IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.18F * var11)
               );
            }
         } else {
            this.I_field_b5845eac = null;
         }
      }
   }

   private List<ModuleEntry> I_method_3cc8fa7(ModuleCategory var1) {
      return this.i_method_c69cda68().stream().filter(var1x -> var1x.getCategory() == var1).toList();
   }

   private List<ModuleEntry> i_method_c69cda68() {
      return RockstarClient.getInstance()
         .getModuleManager()
         .getModules()
         .stream()
         .filter(ModuleEntry::isAvailable)
         .sorted(Comparator.comparing(ModuleEntry::getName, String.CASE_INSENSITIVE_ORDER))
         .toList();
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_f6d12895(boolean var1) {
      if (this.I_field_b584628c != null) {
         this.II_method_f6df6d22();
         String var2 = IiiIiiIiI_Class219.I_method_12a37157(this.I_field_fdef2cc == null ? "" : this.I_field_fdef2cc.I_method_d2579001());
         List var3 = var2.isEmpty() ? this.I_method_3cc8fa7(this.I_field_75f1ef41) : this.i_method_c69cda68();
         if (var1 || !I_method_77f02a05(this.I_field_7865b31, var3) || !var2.equals(this.I_field_523beb0a)) {
            ArrayList var4 = new ArrayList(var3);
            if (!var2.isEmpty()) {
               IdentityHashMap var5 = new IdentityHashMap();

               for (ModuleEntry var7 : (Iterable<ModuleEntry>)(Iterable<?>)var4) {
                  var5.put(var7, IiiIiiIiI_Class219.i_method_ca495fc6(IiiIiiIiI_Class219.I_method_12a37157(var7.getName()), var2));
               }

               var4.removeIf(var1x -> (Integer)var5.get(var1x) == Integer.MAX_VALUE);
               var4.sort(
                  Comparator.<ModuleEntry>comparingInt(var1x -> (Integer)var5.get(var1x))
                     .thenComparing(ModuleEntry::getName, String.CASE_INSENSITIVE_ORDER)
               );
            }

            this.I_method_9b0fe91a(var2, var4);
            ArrayList var8 = new ArrayList();

            for (ModuleEntry var10 : (Iterable<ModuleEntry>)(Iterable<?>)var4) {
               var8.add(this.I_field_a567c40b.computeIfAbsent(var10, this::I_method_bf3023f6));
            }

            this.I_field_b584628c.II_method_244860a9(var8);
            this.I_field_7865b31 = new ArrayList<>(var3);
            this.I_field_523beb0a = var2;
         }
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_9b0fe91a(String var1, List<ModuleEntry> var2) {
      boolean var3 = !this.I_field_523beb0a.isEmpty() && !this.I_field_523beb0a.equals("\u0000");
      if (var1.isEmpty()) {
         if (var3 && this.II_field_75e36361 != null && this.I_field_75e36361 != this.II_field_75e36361) {
            this.I_method_c2e71ac0(this.II_field_75e36361);
         }

         this.II_field_75e36361 = null;
      } else {
         if (!var3) {
            this.II_field_75e36361 = this.I_field_75e36361;
         }

         ModuleEntry var4 = var2.isEmpty() ? null : (ModuleEntry)var2.getFirst();
         if (this.I_field_75e36361 != var4) {
            this.I_method_c2e71ac0(var4);
         }
      }
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 I_method_bf3023f6(ModuleEntry var1) {
      IIiii_Class8 rad4 = IIiii_Class8.I_method_893b2757(4.0F);
      Iii_Class4 card = new Iii_Class4()
         .fill()
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .paint((ctx, rect) -> {
            boolean enabled = var1.isEnabled();
            boolean selected = this.I_field_75e36361 == var1;
            float hov = rect.hover();
            ColorRGBA accent = IiiiiIIIi_Class242.I_method_7df8e08e();

            float cx = rect.x() + rect.w() / 2.0F;
            float cy = rect.y() + rect.h() / 2.0F;
            boolean tilted = hov > 0.01F;

            if (tilted) {
               float mx = (float)ctx.I_method_b1c3e152() - cx;
               float my = (float)ctx.i_method_b1d26d32() - cy;
               float normX = Math.max(-1.0F, Math.min(1.0F, mx / (rect.w() * 0.5F)));
               float normY = Math.max(-1.0F, Math.min(1.0F, my / (rect.h() * 0.5F)));
               float tiltPitch = -normY * 4.5F * hov;
               float tiltYaw = normX * 4.5F * hov;
               float scale = 1.0F + 0.015F * hov;

               ctx.pushMatrix();
               ctx.getMatrices().translate(cx, cy, 0.0F);
               ctx.getMatrices().multiply(RotationAxis.POSITIVE_X.rotationDegrees(tiltPitch));
               ctx.getMatrices().multiply(RotationAxis.POSITIVE_Y.rotationDegrees(tiltYaw));
               ctx.getMatrices().scale(scale, scale, 1.0F);
               ctx.getMatrices().translate(-cx, -cy, 0.0F);
            }

            try {
               // Card background
               ColorRGBA bg = selected
                  ? accent.withAlpha(55.0F)
                  : (enabled
                     ? accent.withAlpha(30.0F + 15.0F * hov)
                     : (hov > 0.5F ? new ColorRGBA(36.0F, 40.0F, 52.0F, 190.0F) : new ColorRGBA(20.0F, 22.0F, 30.0F, 160.0F)));
               ctx.drawRoundedRect(rect.x(), rect.y(), rect.w(), rect.h(), rad4, bg);

               // Card border / specular highlight
               if (selected) {
                  ctx.drawRoundedBorder(rect.x(), rect.y(), rect.w(), rect.h(), 1.0F, rad4, accent);
               } else if (enabled) {
                  ctx.drawRoundedBorder(rect.x(), rect.y(), rect.w(), rect.h(), 0.8F, rad4, accent.withAlpha(120.0F));
                  ctx.drawRect(rect.x() + 0.5F, rect.y() + 3.0F, 2.0F, rect.h() - 6.0F, accent);
               } else if (hov > 0.05F) {
                  ctx.drawRoundedBorder(rect.x(), rect.y(), rect.w(), rect.h(), 0.8F, rad4, new ColorRGBA(255.0F, 255.0F, 255.0F, 50.0F * hov));
               }

               // Specular glare highlight near cursor
               if (hov > 0.05F) {
                  float glareX = (float)ctx.I_method_b1c3e152();
                  float glareY = (float)ctx.i_method_b1d26d32();
                  float gSize = 14.0F;
                  ctx.drawRoundedRect(glareX - gSize, glareY - gSize, gSize * 2.0F, gSize * 2.0F, IIiii_Class8.I_method_893b2757(gSize), new ColorRGBA(255.0F, 255.0F, 255.0F, 18.0F * hov));
               }

               // Module Name Text
               ColorRGBA textCol = selected || enabled ? ColorRGBA.WHITE : new ColorRGBA(190.0F, 195.0F, 210.0F, 255.0F);
               ctx.drawText(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F),
                  this.I_method_f93b1e0(var1),
                  rect.x() + 8.0F,
                  rect.y() + (rect.h() - 8.0F) / 2.0F,
                  textCol
               );

               // Toggle switch pill on right
               float pillW = 14.0F;
               float pillH = 7.5F;
               float pillX = rect.x() + rect.w() - pillW - 6.0F;
               float pillY = rect.y() + (rect.h() - pillH) / 2.0F;
               float pillR = pillH / 2.0F;
               IIiii_Class8 pillRad = IIiii_Class8.I_method_893b2757(pillR);

               ctx.drawRoundedRect(pillX, pillY, pillW, pillH, pillRad, enabled ? accent.withAlpha(210.0F) : new ColorRGBA(45.0F, 50.0F, 65.0F, 190.0F));
               float dotSize = pillH - 2.0F;
               float dotX = enabled ? (pillX + pillW - dotSize - 1.0F) : (pillX + 1.0F);
               float dotY = pillY + 1.0F;
               ctx.drawRoundedRect(dotX, dotY, dotSize, dotSize, IIiii_Class8.I_method_893b2757(dotSize / 2.0F), ColorRGBA.WHITE);
            } finally {
               if (tilted) {
                  ctx.popMatrix();
               }
            }
         });

      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .IiI_method_31d4c97(20.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 5.0F))
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(card)
         .I_method_b60c4df8((var2x, var3, var4) -> this.I_method_cd0360e6(var1, var2x));
   }

   private String I_method_f93b1e0(ModuleEntry var1) {
      if (this.i_field_75e36361 != var1) {
         return var1.getName();
      } else {
         int var2 = iIIIIIIII_Class257.I_method_e761de12();
         if (var2 != 0) {
            return IiIiIIII_Class81.I_method_f25a980a("key") + ": " + iIIIIIIII_Class257.I_method_f90bbc5c(var2) + "...";
         } else {
            return var1.getKeybind() == -1
               ? IiIiIIII_Class81.I_method_f25a980a("menu.binding")
               : IiIiIIII_Class81.I_method_f25a980a("key") + ": " + iIIIIiIiI_Class267.I_method_a937749c(var1.getKeybind());
         }
      }
   }

   private void I_method_cd0360e6(ModuleEntry var1, IiIII_Class9 var2) {
      switch (var2) {
         case I_field_2f4c8d6c:
            var1.toggle();
            break;
         case i_field_2f4c8d6c:
            if (this.I_field_75e36361 != var1) {
               this.I_method_c2e71ac0(var1);
            }
            break;
         case II_field_2f4c8d6c:
            this.i_field_75e36361 = this.i_field_75e36361 == var1 ? null : var1;
      }
   }

   private void I_method_c2e71ac0(ModuleEntry var1) {
      if (this.I_field_fb07f0e1 != null) {
         this.I_field_fb07f0e1.I_method_d4d8842c();
      }

      this.I_field_75e36361 = var1;
      this.i_field_75e36361 = null;
      this.i_field_7865b31 = List.of();
      this.i_method_f89418b5(true);
      if (this.II_field_b584628c != null) {
         this.II_field_b584628c.i_method_815a851f();
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void II_method_f6df6d22() {
      int var1 = ModuleManager.I_method_7056a45f();
      if (var1 != this.I_field_49) {
         this.I_field_49 = var1;
         List var2 = RockstarClient.getInstance().getModuleManager().getModules();
         if (this.i_field_75e36361 != null && !I_method_878ece75(var2, this.i_field_75e36361)) {
            this.i_field_75e36361 = null;
         }

         if (this.II_field_75e36361 != null && !I_method_878ece75(var2, this.II_field_75e36361)) {
            this.II_field_75e36361 = I_method_fce419a6(var2, this.II_field_75e36361);
         }

         IdentityHashMap var3 = new IdentityHashMap();

         for (ModuleEntry var5 : (Iterable<ModuleEntry>)(Iterable<?>)var2) {
            var3.put(var5, Boolean.TRUE);
         }

         this.I_field_a567c40b.keySet().removeIf(var1x -> !var3.containsKey(var1x));
         if (this.I_field_75e36361 != null && !var3.containsKey(this.I_field_75e36361)) {
            for (Setting var7 : this.i_field_7865b31) {
               this.i_field_a567c40b.remove(var7);
            }

            this.I_method_c2e71ac0(I_method_fce419a6(var2, this.I_field_75e36361));
         }
      }
   }

   private static boolean I_method_878ece75(List<ModuleEntry> var0, ModuleEntry var1) {
      for (ModuleEntry var3 : var0) {
         if (var3 == var1) {
            return true;
         }
      }

      return false;
   }

   private static ModuleEntry I_method_fce419a6(List<ModuleEntry> var0, ModuleEntry var1) {
      for (ModuleEntry var3 : var0) {
         if (var3.getCategory() == var1.getCategory() && var3.getName().equals(var1.getName())) {
            return var3;
         }
      }

      return null;
   }

   @Compile(
      obfuscation = 1
   )
   private void i_method_f89418b5(boolean var1) {
      if (this.i_field_b584628c != null) {
         List var2 = this.I_field_75e36361 == null ? List.of() : this.I_field_75e36361.getSettings();
         if (var1 || !I_method_77f02a05(this.i_field_7865b31, var2)) {
            if (!this.i_field_7865b31.isEmpty()) {
               IdentityHashMap var3 = new IdentityHashMap();

               for (Setting var5 : (Iterable<Setting>)(Iterable<?>)var2) {
                  var3.put(var5, Boolean.TRUE);
               }

               for (Setting var13 : this.i_field_7865b31) {
                  if (!var3.containsKey(var13)) {
                     this.i_field_a567c40b.remove(var13);
                  }
               }
            }

            ArrayList var10 = new ArrayList();
            ArrayList var12 = new ArrayList();
            ArrayList var14 = new ArrayList();
            ArrayList var6 = new ArrayList();
            int var7 = 0;

            for (Setting var9 : (Iterable<Setting>)(Iterable<?>)var2) {
               if (var9 instanceof SectionSetting) {
                  this.I_method_29cefde3(var10, var12, var14, var6);
                  var7 = 0;
                  var10.add(this.i_field_a567c40b.computeIfAbsent(var9, this::I_method_2396b05d));
               } else {
                  (var7++ % 2 == 0 ? var12 : var14).add(this.i_field_a567c40b.computeIfAbsent(var9, this::I_method_2396b05d));
                  var6.add(var9);
               }
            }

            this.I_method_29cefde3(var10, var12, var14, var6);
            this.i_field_b584628c.i_method_d2e03546(var10);
            this.i_field_7865b31 = new ArrayList<>(var2);
            iIiiIIiii_Class360.I_field_6424b12c.i_method_6e3866bf();
         }
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_29cefde3(List<iiI_Class7> var1, List<iiI_Class7> var2, List<iiI_Class7> var3, List<Setting> var4) {
      if (!var2.isEmpty() || !var3.isEmpty()) {
         List var5 = List.copyOf(var4);
         iii_Class8 var6 = new iii_Class8().I_method_485bccf5().I_method_70a38517(5.0F).IIi_method_4dfc88d7(this.IIiII_field_46).I_method_ef221966(var2);
         iii_Class8 var7 = new iii_Class8().I_method_485bccf5().I_method_70a38517(5.0F).IIi_method_4dfc88d7(this.IIiII_field_46).I_method_ef221966(var3);
         var6.snapSize();
         var7.snapSize();
         iii_Class8 var8 = new iii_Class8()
            .i_method_c88da8d5()
            .I_method_70a38517(5.0F)
            .I_method_483797dd(IIi_Class2.I_field_b5755e8c)
            .III_method_9dc17555()
            .I_method_e16e9925(() -> I_method_f37dbd14(var5), IiiiIiiII_Class237.IIii_field_dd60aac, 220L)
            .IIiI_method_185ffdf8()
            .I_method_8939bffd(var6)
            .I_method_8939bffd(var7);
         var8.snapSize();
         var1.add(var8);
         var2.clear();
         var3.clear();
         var4.clear();
      }
   }

   private static boolean I_method_f37dbd14(List<Setting> var0) {
      for (Setting var2 : var0) {
         if (var2.isVisible()) {
            return true;
         }
      }

      return false;
   }

   private iii_Class8 I_method_2396b05d(Setting var1) {
      return var1 instanceof SectionSetting ? this.i_method_94fa687d(var1) : this.II_method_734a96fa(var1);
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 i_method_94fa687d(Setting var1) {
      iii_Class8 var2 = IiiIiiIIi_Class218.i_method_f520787d(var1);
      var2.I_method_7e2bb176(IIII.I_field_f935fcc1);
      var2.snapSize();
      iii_Class8 var3 = new iii_Class8()
         .I_method_485bccf5()
         .III_method_9dc17555()
         .I_method_e16e9925(var1::isVisible, IiiiIiiII_Class237.IIii_field_dd60aac, 220L)
         .IIiI_method_185ffdf8()
         .I_method_8939bffd(var2);
      var3.snapSize();
      return var3;
   }

   @Compile(
      obfuscation = 1
   )
   private iii_Class8 II_method_734a96fa(Setting var1) {
      iii_Class8 var2 = IiiIiiIIi_Class218.i_method_f520787d(var1);
      var2.snapSize();
      iii_Class8 var3 = new iii_Class8()
         .I_method_485bccf5()
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.II_method_714316ac(4.0F))
         .iI_method_e886414(7.0F)
         .I_method_e53800a9(var0 -> IiiiiIIIi_Class242.Ii_method_a0f56f71().mulAlpha(0.4F))
         .I_method_e16e9925(var1::isVisible, IiiiIiiII_Class237.IIii_field_dd60aac, 220L)
         .IIiI_method_185ffdf8()
         .I_method_8939bffd(var2);
      var3.snapSize();
      return var3;
   }

   private String i_method_a5af7881() {
      return this.I_field_75e36361 == null ? "" : IiIiIIII_Class81.I_method_1410d1e5("menu.modern.settings", this.I_field_75e36361.getName());
   }

   private String II_method_44e22fbe() {
      return this.I_field_75e36361 == null ? "" : this.I_field_75e36361.i_method_bf522194();
   }

   private String Ii_method_d800dfde() {
      String var1 = Profile.getUsername();
      return var1 == null ? "" : var1;
   }

   private String iI_method_1599839e() {
      return "LEEK";
   }

   private int I_method_94594e12() {
      return this.I_field_75e36361 == null ? -1 : this.I_field_75e36361.getKeybind();
   }

   private void I_method_f6d0e8c4(int var1) {
      if (this.I_field_75e36361 != null) {
         this.I_field_75e36361.setKeybind(var1);
         this.III_method_e51d2e7f();
      }
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   public void render(III var1) {
      this.Ii_method_f6edf902();
      this.iI_method_f8a25d42();
      GuiMoveModule.iII_method_9983ebf();
      if (!this.closing) {
         this.I_method_f6d12895(false);
         this.i_method_f89418b5(false);
      }

      if (this.II_field_b584628c != null) {
         float var2 = this.II_field_b584628c.Iii_method_61e30d8f();
         if (var2 != this.IIiiI_field_46) {
            this.IIiiI_field_46 = var2;
            iIiiIIiii_Class360.I_field_6424b12c.i_method_6e3866bf();
         }
      }

      if (System.currentTimeMillis() - this.II_field_4a < 400L) {
         iIiiIIiii_Class360.I_field_6424b12c.i_method_6e3866bf();
      }

      if (this.Ii_field_b584628c != null) {
         this.IiIiI_field_46 = this.Ii_field_b584628c.x();
         this.IiIii_field_46 = this.Ii_field_b584628c.y();
         if (this.IiIiI_field_46 != this.IIiii_field_46 || this.IiIii_field_46 != this.IiIII_field_46) {
            this.IIiii_field_46 = this.IiIiI_field_46;
            this.IiIII_field_46 = this.IiIii_field_46;
            iIiiIIiii_Class360.I_field_6424b12c.i_method_6e3866bf();
         }
      }

      MenuModule varMenu = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
      float userScale = varMenu != null ? varMenu.getGuiScale() : 1.0F;
      float var4 = (this.closing ? 1.0F : 0.7F + 0.3F * this.ii_method_f8b0e912()) * userScale;
      boolean var3 = Math.abs(var4 - 1.0F) > 1.0E-4F;
      if (var3) {
         var1.getMatrices().push();
         var1.getMatrices().translate(this.width / 2.0F, this.height / 2.0F, 0.0F);
         var1.getMatrices().scale(var4, var4, 1.0F);
         var1.getMatrices().translate(-this.width / 2.0F, -this.height / 2.0F, 0.0F);
      }

      int origMx = var1.I_method_b1c3e152();
      int origMy = var1.i_method_b1d26d32();
      if (var3 && var4 > 0.001F) {
         float cx = this.width / 2.0F;
         float cy = this.height / 2.0F;
         int mappedMx = Math.round((float)(cx + (origMx - cx) / var4));
         int mappedMy = Math.round((float)(cy + (origMy - cy) / var4));
         var1.setMousePos(mappedMx, mappedMy);
      }

      try {
         IiiIiIIIi_Class210.I_method_bd87019f(this, var1);
         super.render(var1);
         IiiIiIIIi_Class210.i_method_789a4d7f(this, var1);
      } finally {
         var1.setMousePos(origMx, origMy);
         if (var3) {
            var1.getMatrices().pop();
         }
      }

      if (this.floatingSearchOpen) {
         this.renderFloatingSearch(var1, origMx, origMy);
      }
   }

   @Override
   public String I_method_8c872841() {
      return "modern";
   }

   @Override
   public float I_method_9833b22f() {
      return this.ii_method_f8b0e912();
   }

   @Override
   public float i_method_98423e0f() {
      return this.closing ? this.III_method_e51d2e6f() : 0.0F;
   }

   @Override
   public boolean I_method_9833b243() {
      return this.closing;
   }

   @Override
   public float II_method_6e518cf2() {
      return this.contentAlpha;
   }

   @Override
   public float Ii_method_6e6018d2() {
      return this.closing ? 1.0F : 0.7F + 0.3F * this.ii_method_f8b0e912();
   }

   @Override
   public List<IiiIiIIiI_Class211.Nested1_972f6c40> I_method_cb1d7a28() {
      return List.of(new IiiIiIIiI_Class211.Nested1_972f6c40("window", this.IiIiI_field_46, this.IiIii_field_46, this.IiiII_field_46, this.IiiIi_field_46));
   }

   public static IiiIiIiiI_Class215 I_method_6fb072f5() {
      return I_field_a5e73e6c;
   }

   private float ii_method_f8b0e912() {
      float var1 = Math.min(1.0F, Math.max(0.0F, (float)(System.currentTimeMillis() - this.II_field_4a) / 300.0F));
      return IiiiIiiII_Class237.I_field_dd60aac.ease(var1, 0.0F, 1.0F, 1.0F);
   }

   private void Ii_method_f6edf902() {
      long var1 = System.currentTimeMillis();
      if (this.closing) {
         this.IiIIi_field_46 = 0.0F;
         this.i_field_4a = var1;
         this.contentAlpha = 1.0F;
      } else {
         float var3 = this.i_field_4a == 0L ? 16.0F : Math.min(64.0F, (float)(var1 - this.i_field_4a));
         this.i_field_4a = var1;
         MenuModule var4 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
         int var5 = var4 != null && var4.I_method_20c0695() != null ? var4.I_method_20c0695().I_method_fa6281d2() : -1;
         float var6 = I_method_f6d0e8c8(var5) ? 1.0F : 0.0F;
         float var7 = var3 / 300.0F;
         if (this.IiIIi_field_46 < var6) {
            this.IiIIi_field_46 = Math.min(var6, this.IiIIi_field_46 + var7);
         } else if (this.IiIIi_field_46 > var6) {
            this.IiIIi_field_46 = Math.max(var6, this.IiIIi_field_46 - var7);
         }

         this.contentAlpha = 1.0F - IiiiIiiII_Class237.III_field_dd60aac.ease(this.IiIIi_field_46, 0.0F, 1.0F, 1.0F);
      }
   }

   private void iI_method_f8a25d42() {
      if (!this.closing && !(this.contentAlpha >= 0.999F)) {
         long var1 = MinecraftClient.getInstance().getWindow().getHandle();
         boolean var3 = GLFW.glfwGetMouseButton(var1, 0) == 1;
         if (!var3 || iiI_Class7.spotlight() == null) {
            iii_Class8 var4 = null;

            for (Entry var6 : this.i_field_a567c40b.entrySet()) {
               iii_Class8 var7 = (iii_Class8)var6.getValue();
               if (var7.inFlow() && var7.hovered() && IiiIiiIIi_Class218.I_method_120ab0ab((Setting)var6.getKey())) {
                  var4 = var7;
                  break;
               }
            }

            iiI_Class7.spotlight(var4);
         }
      } else {
         iiI_Class7.spotlight(null);
      }
   }

   private static boolean I_method_f6d0e8c8(int var0) {
      return iIIIIIIII_Class257.II_method_98333a25(var0);
   }

   public void tick() {
      GuiMoveModule.iII_method_9983ebf();
      super.tick();
   }

   private double mapCoordX(double mx) {
      MenuModule varMenu = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
      float userScale = varMenu != null ? varMenu.getGuiScale() : 1.0F;
      if (Math.abs(userScale - 1.0F) > 1.0E-4F && userScale > 0.001F) {
         float cx = this.width / 2.0F;
         return cx + (mx - cx) / userScale;
      }
      return mx;
   }

   private double mapCoordY(double my) {
      MenuModule varMenu = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
      float userScale = varMenu != null ? varMenu.getGuiScale() : 1.0F;
      if (Math.abs(userScale - 1.0F) > 1.0E-4F && userScale > 0.001F) {
         float cy = this.height / 2.0F;
         return cy + (my - cy) / userScale;
      }
      return my;
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   public void onMouseClicked(double origVar1, double origVar3, IiIII_Class9 var5) {
      if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
         float topX = this.Ii_field_b584628c != null ? this.Ii_field_b584628c.x() : guiPosX;
         float topY = this.Ii_field_b584628c != null ? this.Ii_field_b584628c.y() : guiPosY;
         float cy = topY + this.iIIIi_field_46 / 2.0F;
         float d1X = topX + 11.0F;
         float d2X = topX + 23.5F;
         float d3X = topX + 36.0F;

         // Red: Close
         double dSq1 = (origVar1 - d1X) * (origVar1 - d1X) + (origVar3 - cy) * (origVar3 - cy);
         if (dSq1 <= 7.0 * 7.0) {
            this.close();
            return;
         }

         // Yellow: Minimize / Reset window position to center
         double dSq2 = (origVar1 - d2X) * (origVar1 - d2X) + (origVar3 - cy) * (origVar3 - cy);
         if (dSq2 <= 7.0 * 7.0) {
            guiPosX = (this.width - this.IiiII_field_46) / 2.0F;
            guiPosY = (this.height - this.IiiIi_field_46) / 2.0F;
            if (this.Ii_field_b584628c != null) {
               this.Ii_field_b584628c.snapAt(guiPosX, guiPosY);
               this.Ii_field_b584628c.manuallyPositioned(true);
            }
            return;
         }

         // Green: Maximize / Toggle fullscreen
         double dSq3 = (origVar1 - d3X) * (origVar1 - d3X) + (origVar3 - cy) * (origVar3 - cy);
         if (dSq3 <= 7.0 * 7.0) {
            net.minecraft.client.MinecraftClient.getInstance().getWindow().toggleFullscreen();
            return;
         }
      }
      this.clickBubbleEffect.addBubble((float)origVar1, (float)origVar3, IiiiiIIIi_Class242.I_method_7df8e08e());
      if (this.floatingSearchOpen) {
         if (this.handleFloatingSearchClick(origVar1, origVar3, var5)) {
            return;
         }
      }
      double var1 = this.mapCoordX(origVar1);
      double var3 = this.mapCoordY(origVar3);
      if (iiiI_Class15.i_method_3a56361e(var5)) {
         this.III_method_e51d2e7f();
      } else {
         boolean var6 = this.overlays.stream().anyMatch(var4 -> var4.alive() && var4.contains((float)var1, (float)var3));
         if (this.I_field_2d89a12c != null && !var6) {
            this.I_field_2d89a12c.I_method_911c871f((float)var1, (float)var3);
         }

         if (this.i_field_75e36361 != null) {
            if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
               this.i_field_75e36361 = null;
               return;
            }

            if (var5 != IiIII_Class9.II_field_2f4c8d6c) {
               this.i_field_75e36361.setKeybind(iIIIIIIII_Class257.Ii_method_99f62a34(var5.I_method_6d899712()));
               this.i_field_75e36361 = null;
               this.III_method_e51d2e7f();
               return;
            }
         }

         super.onMouseClicked(var1, var3, var5);
         if (var5 == IiIII_Class9.I_field_2f4c8d6c && (this.Ii_field_b584628c == null || !this.Ii_field_b584628c.dragging())) {
            float topX = this.Ii_field_b584628c != null ? this.Ii_field_b584628c.x() : guiPosX;
            float topY = this.Ii_field_b584628c != null ? this.Ii_field_b584628c.y() : guiPosY;
            if (origVar1 >= topX && origVar1 <= topX + this.IiiII_field_46 && origVar3 >= topY && origVar3 <= topY + this.iIIIi_field_46) {
               this.guiDragging = true;
               this.guiDragOffsetX = (float)origVar1 - topX;
               this.guiDragOffsetY = (float)origVar3 - topY;
            }
         }
      }
   }

   @Override
   public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
      if (this.i_field_75e36361 != null) {
         int var4 = iIIIIIIII_Class257.II_method_6e347cf5(keyCode, modifiers);
         if (var4 != Integer.MIN_VALUE) {
            this.i_field_75e36361.setKeybind(var4);
            this.i_field_75e36361 = null;
            this.III_method_e51d2e7f();
            return true;
         }
      }

      return super.keyReleased(keyCode, scanCode, modifiers);
   }

   @Override
   public void onMouseReleased(double origVar1, double origVar3, IiIII_Class9 var5) {
      this.floatingSearchDragging = false;
      this.guiDragging = false;
      double var1 = this.mapCoordX(origVar1);
      double var3 = this.mapCoordY(origVar3);
      boolean var6 = var5 == IiIII_Class9.I_field_2f4c8d6c && this.Ii_field_b584628c != null && this.Ii_field_b584628c.dragging();
      if (this.I_field_fdef2cc != null) {
         this.I_field_fdef2cc.i_method_6a097ac7(var1, var3, var5);
      }

      super.onMouseReleased(var1, var3, var5);
      if (var6) {
         this.ii_method_f8b0e922();
      } else if (this.Ii_field_b584628c != null) {
         guiPosX = this.Ii_field_b584628c.x();
         guiPosY = this.Ii_field_b584628c.y();
      }
   }

   @Override
   public void onMouseDragged(double origVar1, double origVar3, IiIII_Class9 var5, double var6, double var8) {
      if (this.guiDragging) {
         guiPosX = (float)origVar1 - this.guiDragOffsetX;
         guiPosY = (float)origVar3 - this.guiDragOffsetY;
         guiPosX = Math.max(0.0F, Math.min(this.width - this.IiiII_field_46, guiPosX));
         guiPosY = Math.max(0.0F, Math.min(this.height - this.IiiIi_field_46, guiPosY));
         if (this.Ii_field_b584628c != null) {
            this.Ii_field_b584628c.snapAt(guiPosX, guiPosY);
            this.Ii_field_b584628c.manuallyPositioned(true);
         }
         return;
      }
      double var1 = this.mapCoordX(origVar1);
      double var3 = this.mapCoordY(origVar3);
      super.onMouseDragged(var1, var3, var5, var6, var8);
      if (this.Ii_field_b584628c != null && this.Ii_field_b584628c.dragging()) {
         guiPosX = this.Ii_field_b584628c.x();
         guiPosY = this.Ii_field_b584628c.y();
      }
   }

   @Override
   public boolean mouseScrolled(double origMouseX, double origMouseY, double horizontalAmount, double verticalAmount) {

      if (this.floatingSearchOpen) {
         if (origMouseX >= this.floatingSearchX && origMouseX <= this.floatingSearchX + this.floatingSearchW
             && origMouseY >= this.floatingSearchY && origMouseY <= this.floatingSearchY + this.floatingSearchH) {
            this.floatingSearchScroll = Math.max(0.0F, this.floatingSearchScroll - (float)verticalAmount * 24.0F);
            return true;
         }
      }
      double mouseX = this.mapCoordX(origMouseX);
      double mouseY = this.mapCoordY(origMouseY);
      return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
   }

   @Override
   public boolean charTyped(char chr, int modifiers) {

      if (this.floatingSearchOpen) {
         if (chr >= 32 && chr != 127) {
            this.floatingSearchQuery += chr;
            this.floatingSearchScroll = 0.0F;
            return true;
         }
      }
      return super.charTyped(chr, modifiers);
   }

   private void ii_method_f8b0e922() {
      float var1 = this.Ii_field_b584628c.x();
      float var2 = this.Ii_field_b584628c.y();
      float var3 = this.Ii_field_b584628c.w();
      float var4 = this.Ii_field_b584628c.h();
      float var5 = Math.max(0.0F, var1);
      float var6 = Math.max(0.0F, var2);
      float var7 = Math.min((float)this.width, var1 + var3);
      float var8 = Math.min((float)this.height, var2 + var4);
      float var9 = Math.max(0.0F, var7 - var5);
      float var10 = Math.max(0.0F, var8 - var6);
      float var11 = Math.max(1.0F, var3 * var4);
      float var12 = 1.0F - var9 * var10 / var11;
      if (!(var12 < 0.35F)) {
         float var13 = Math.round((this.width - var3) / 2.0F);
         float var14 = Math.round((this.height - var4) / 2.0F);
         this.Ii_field_b584628c.iI_method_7009d1d8(var13, var14);
         guiPosX = var13;
         guiPosY = var14;
      } else {
         guiPosX = var1;
         guiPosY = var2;
      }
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {

      if (this.floatingSearchOpen) {
         if (keyCode == 256) {
            this.floatingSearchOpen = false;
            return true;
         }
         if (keyCode == 259) {
            if (!this.floatingSearchQuery.isEmpty()) {
               this.floatingSearchQuery = this.floatingSearchQuery.substring(0, this.floatingSearchQuery.length() - 1);
               this.floatingSearchScroll = 0.0F;
            }
            return true;
         }
         if (keyCode == 65 && Screen.hasControlDown()) {
            this.floatingSearchQuery = "";
            this.floatingSearchScroll = 0.0F;
            return true;
         }
         return true;
      }

      if (Screen.hasControlDown() && keyCode == 70) {
         this.toggleFloatingSearch();
         return true;
      }

      if (this.i_field_75e36361 == null && !iiiI_Class15.i_method_d4e71010()) {
         if (Screen.hasControlDown() && keyCode == 90 && IIiiiIIIi_Class114.I_method_fe3ce603()) {
            return true;
         }

         if (Screen.hasControlDown() && keyCode == 89 && IIiiiIIIi_Class114.i_method_fe4b71e3()) {
            return true;
         }
      }

      if (this.i_field_75e36361 != null) {
         if (keyCode != 256 && keyCode != 261) {
            int var4 = iIIIIIIII_Class257.i_method_cd0c4692(keyCode, modifiers);
            if (var4 == Integer.MIN_VALUE) {
               return true;
            } else {
               this.i_field_75e36361.setKeybind(var4);
               this.i_field_75e36361 = null;
               this.III_method_e51d2e7f();
               return true;
            }
         } else {
            this.i_field_75e36361.setKeybind(-1);
            this.i_field_75e36361 = null;
            this.III_method_e51d2e7f();
            return true;
         }
      } else if (this.I_field_2d89a12c != null && !this.I_field_2d89a12c.II_method_57518866() && Screen.hasControlDown() && keyCode == 70) {
         this.toggleFloatingSearch();
         return true;
      } else if (super.keyPressed(keyCode, scanCode, modifiers)) {
         return true;
      } else if (MenuModule.I_method_48514ce8(keyCode)) {
         this.close();
         return true;
      } else {
         return false;
      }
   }

   private boolean handleFloatingSearchClick(double mx, double my, IiIII_Class9 button) {
      float fx = this.floatingSearchX;
      float fy = this.floatingSearchY;
      float fw = this.floatingSearchW;
      float fh = this.floatingSearchH;

      if (mx >= fx && mx <= fx + fw && my >= fy && my <= fy + fh) {
         if (button == IiIII_Class9.I_field_2f4c8d6c) {
            if (mx >= fx + fw - 24.0F && my <= fy + 26.0F) {
               this.floatingSearchOpen = false;
               return true;
            }
            if (my <= fy + 26.0F) {
               this.floatingSearchDragging = true;
               this.floatingSearchDragOffsetX = (float)mx - fx;
               this.floatingSearchDragOffsetY = (float)my - fy;
               return true;
            }
            float listX = fx + 10.0F;
            float listY = fy + 56.0F;
            float listW = fw - 20.0F;
            float listH = fh - 64.0F;
            if (mx >= listX && mx <= listX + listW && my >= listY && my <= listY + listH) {
               List<ModuleEntry> allMods = RockstarClient.getInstance().getModuleManager().getModules();
               String q = this.floatingSearchQuery.trim().toLowerCase();
               List<ModuleEntry> matched = allMods.stream()
                  .filter(m -> q.isEmpty() || m.getName().toLowerCase().contains(q) || (m.getCategory() != null && m.getCategory().name().toLowerCase().contains(q)))
                  .toList();
               for (int i = 0; i < matched.size(); i++) {
                  float rowY = listY - this.floatingSearchScroll + i * 24.0F;
                  if (my >= rowY && my <= rowY + 22.0F) {
                     matched.get(i).toggle();
                     return true;
                  }
               }
            }
         }
         return true;
      }
      this.floatingSearchOpen = false;
      return false;
   }

   private void renderFloatingSearch(III var1, int mx, int my) {
      if (this.floatingSearchDragging) {
         this.floatingSearchX = mx - this.floatingSearchDragOffsetX;
         this.floatingSearchY = my - this.floatingSearchDragOffsetY;
         this.floatingSearchX = Math.max(0.0F, Math.min(this.width - this.floatingSearchW, this.floatingSearchX));
         this.floatingSearchY = Math.max(0.0F, Math.min(this.height - this.floatingSearchH, this.floatingSearchY));
      }

      float fx = this.floatingSearchX;
      float fy = this.floatingSearchY;
      float fw = this.floatingSearchW;
      float fh = this.floatingSearchH;

      var1.drawClientRect(fx, fy, fw, fh, 1.0F, 0.0F, 2.0F, 12.0F, true, false);
      boolean isCyberSearch = "Tactical Cyber".equalsIgnoreCase(InterfaceModule.getVisualStyle()) || InterfaceModule.isCyberHud();
      if (!isCyberSearch) {
         var1.drawBlurredRect(fx, fy, fw, fh, 12.0F, 2.0F, IIiii_Class8.I_method_893b2757(12.0F), IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(30.0F));
      }

      var1.drawIcon("search", fx + 10.0F, fy + 8.0F, 11.0F, IiiiiIIIi_Class242.ii_field_d0c8ec5);
      var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), "Поиск модулей", fx + 26.0F, fy + 9.0F, ColorRGBA.WHITE);

      boolean closeHover = mx >= fx + fw - 22.0F && mx <= fx + fw - 6.0F && my >= fy + 6.0F && my <= fy + 22.0F;
      var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(9.0F), "✕", fx + fw - 18.0F, fy + 7.5F, closeHover ? IiiiiIIIi_Class242.ii_field_d0c8ec5 : ColorRGBA.WHITE.withAlpha(140.0F));

      var1.drawRoundedRect(fx + 10.0F, fy + 28.0F, fw - 20.0F, 22.0F, IIiii_Class8.I_method_893b2757(4.0F), new ColorRGBA(24.0F, 21.0F, 29.0F, 220.0F));
      var1.drawRoundedBorder(fx + 10.0F, fy + 28.0F, fw - 20.0F, 22.0F, 0.5F, IIiii_Class8.I_method_893b2757(4.0F), IiiiiIIIi_Class242.ii_field_d0c8ec5);
      var1.drawIcon("search", fx + 16.0F, fy + 34.0F, 9.0F, IiiiiIIIi_Class242.ii_field_d0c8ec5);

      if (this.floatingSearchQuery.isEmpty()) {
         var1.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), "Введите название модуля...", fx + 30.0F, fy + 35.0F, ColorRGBA.WHITE.withAlpha(100.0F));
      } else {
         String cursor = System.currentTimeMillis() % 1000L < 500L ? "|" : "";
         var1.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), this.floatingSearchQuery + cursor, fx + 30.0F, fy + 35.0F, ColorRGBA.WHITE);
      }

      float listX = fx + 10.0F;
      float listY = fy + 56.0F;
      float listW = fw - 20.0F;
      float listH = fh - 64.0F;

      List<ModuleEntry> allMods = RockstarClient.getInstance().getModuleManager().getModules();
      String q = this.floatingSearchQuery.trim().toLowerCase();
      List<ModuleEntry> matched = allMods.stream()
         .filter(m -> q.isEmpty() || m.getName().toLowerCase().contains(q) || (m.getCategory() != null && m.getCategory().name().toLowerCase().contains(q)))
         .toList();

      float maxScroll = Math.max(0.0F, matched.size() * 24.0F - listH);
      this.floatingSearchScroll = Math.max(0.0F, Math.min(maxScroll, this.floatingSearchScroll));

      iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), listX, listY, listW, listH);

      if (matched.isEmpty()) {
         var1.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.5F), "Ничего не найдено", listX + listW / 2.0F - 40.0F, listY + listH / 2.0F - 4.0F, ColorRGBA.WHITE.withAlpha(120.0F));
      } else {
         for (int i = 0; i < matched.size(); i++) {
            float rowY = listY - this.floatingSearchScroll + i * 24.0F;
            if (rowY + 22.0F < listY || rowY > listY + listH) {
               continue;
            }
            ModuleEntry m = matched.get(i);
            boolean rowHover = mx >= listX && mx <= listX + listW && my >= rowY && my <= rowY + 22.0F;
            ColorRGBA rowBg = m.isEnabled()
               ? IiiiiIIIi_Class242.ii_field_d0c8ec5.withAlpha(rowHover ? 55.0F : 38.0F)
               : (rowHover ? new ColorRGBA(45.0F, 40.0F, 55.0F, 160.0F) : new ColorRGBA(30.0F, 26.0F, 36.0F, 120.0F));
            var1.drawRoundedRect(listX, rowY, listW, 22.0F, IIiii_Class8.I_method_893b2757(4.0F), rowBg);
            if (m.isEnabled()) {
               var1.drawRoundedBorder(listX, rowY, listW, 22.0F, 0.5F, IIiii_Class8.I_method_893b2757(4.0F), IiiiiIIIi_Class242.ii_field_d0c8ec5.withAlpha(140.0F));
            }

            var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F), m.getName(), listX + 8.0F, rowY + 6.5F, m.isEnabled() ? IiiiiIIIi_Class242.ii_field_d0c8ec5 : ColorRGBA.WHITE);

            if (m.getCategory() != null) {
               float nw = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.5F).I_method_2c375926(m.getName());
               var1.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F), "[" + m.getCategory().name() + "]", listX + 8.0F + nw + 6.0F, rowY + 7.5F, ColorRGBA.WHITE.withAlpha(100.0F));
            }

            float togW = 24.0F;
            float togH = 12.0F;
            float togX = listX + listW - togW - 6.0F;
            float togY = rowY + 5.0F;
            var1.drawRoundedRect(togX, togY, togW, togH, IIiii_Class8.I_method_893b2757(6.0F), m.isEnabled() ? IiiiiIIIi_Class242.ii_field_d0c8ec5.withAlpha(180.0F) : new ColorRGBA(50.0F, 46.0F, 60.0F, 180.0F));
            float knobX = m.isEnabled() ? togX + togW - 10.0F : togX + 2.0F;
            var1.drawRoundedRect(knobX, togY + 2.0F, 8.0F, 8.0F, IIiii_Class8.I_method_893b2757(4.0F), ColorRGBA.WHITE);
         }
      }

      iIiiiIiII_Class373.I_method_ff80a1df();
   }



   @Compile(
      obfuscation = 1
   )
   public void close() {
      if (!this.closing) {
         if (this.I_field_fdef2cc != null) {
            this.I_field_fdef2cc.I_method_fb5b3035(false);
         }

         SoundsModule var1 = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
         if (var1 != null && var1.isEnabled()) {
            iiIiIIIII_Class417.I_field_34b2ba6c.I_method_7289b65f(var1.I_method_45ee5ef(), 1.0F);
         }

         MenuModule var2 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class);
         if (var2 != null && var2.isEnabled()) {
            var2.disable();
         }

         super.close();
      }
   }

   @Override
   public void removed() {
      this.I_method_94594e1f();
      super.removed();
   }

   @Compile(
      obfuscation = 1
   )
   public void I_method_94594e1f() {
      if (!this.closing) {
         this.closing = true;
         iiI_Class7.spotlight(null);
         this.III_method_e51d2e7f();
         this.Ii_field_4a = System.currentTimeMillis();
         I_field_5a = false;
         i_field_5a = false;
         MinecraftClient var1 = MinecraftClient.getInstance();
         Camera var2 = var1.gameRenderer.getCamera();
         if (var2 != null && var1.player != null) {
            double var3 = Math.toRadians(var2.getYaw());
            double var5 = Math.toRadians(var2.getPitch());
            Vec3d var7 = new Vec3d(-Math.sin(var3) * Math.cos(var5), -Math.sin(var5), Math.cos(var3) * Math.cos(var5)).normalize();
            this.i_field_5bba0d50 = var7;
            this.II_field_5bba0d50 = var7.crossProduct(new Vec3d(0.0, 1.0, 0.0)).normalize();
            this.Ii_field_5bba0d50 = this.II_field_5bba0d50.crossProduct(var7).normalize();
            this.I_field_5bba0d50 = var2.getPos().add(var7.multiply(1.5));
         }

         I_field_a5e73e6c = this;
      }
   }

   float III_method_e51d2e6f() {
      return Math.min(1.0F, Math.max(0.0F, (float)(System.currentTimeMillis() - this.Ii_field_4a) / 1600.0F));
   }

   static void I_method_8bb2cef1(HudRenderEvent var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      float var2 = var1.getWindow().getScaledWidth();
      float var3 = var1.getWindow().getScaledHeight();
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      RenderSystem.setShaderTexture(0, I_field_cb35e4c.getColorAttachment());
      Matrix4f var4 = var0.getContext().getMatrices().peek().getPositionMatrix();
      int var5 = ColorRGBA.WHITE.getRGB();
      BufferBuilder var6 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      var6.vertex(var4, 0.0F, 0.0F, 0.0F).texture(0.0F, 1.0F).color(var5);
      var6.vertex(var4, 0.0F, var3, 0.0F).texture(0.0F, 0.0F).color(var5);
      var6.vertex(var4, var2, var3, 0.0F).texture(1.0F, 0.0F).color(var5);
      var6.vertex(var4, var2, 0.0F, 0.0F).texture(1.0F, 1.0F).color(var5);
      BufferRenderer.drawWithGlobalProgram(var6.end());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void III_method_e51d2e7f() {
      RockstarClient.getInstance().I_method_5198232b().II_method_1fbeeff5();
      RockstarClient.getInstance().I_method_7a4c3f0b().II_method_d8a14015();
   }

   private ColorRGBA I_method_af54788e() {
      return IiiiiIIIi_Class242.iI_method_8e08d3b1();
   }

   private ColorRGBA i_method_373b846e() {
      return IiiiiIIIi_Class242.II_method_190e6391().withAlpha(102.0F);
   }

   private ColorRGBA II_method_1325cb91() {
      return this.i_method_373b846e();
   }

   private ColorRGBA Ii_method_9b0cd771() {
      return IiiiiIIIi_Class242.IiI_field_d0c8ec5.withAlpha(89.25F);
   }

   private void I_method_65a7e900(IiII_Class5 var1) {
      var1.i_method_65326e43(-3.0F)
         .II_method_e6aaaac(2.0F)
         .I_method_2a080a63(2.0F)
         .Ii_method_49950e8c(18.0F)
         .iI_method_388cc2cc(1.0F)
         .ii_method_73b726ac(1100.0F)
         .i_method_989a5f71(
            var1x -> this.I_method_af54788e().withAlpha(255.0F * (0.28F + 0.24F * var1x.I_method_af833bdc() + 0.28F * var1x.i_method_af91c7bc()))
         );
   }

   private static ColorRGBA I_method_f2c6fbd0(ColorRGBA var0, ColorRGBA var1, float var2) {
      return var0.mix(var1.withAlpha(var0.getAlpha()), var2);
   }

   private static boolean I_method_77f02a05(List<?> var0, List<?> var1) {
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

   private static String I_method_5d441d97(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.toLowerCase();
         return Character.toUpperCase(var1.charAt(0)) + var1.substring(1);
      } else {
         return "";
      }
   }

   @Override
   public boolean shouldPause() {
      return false;
   }

   @Override
   public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
   }

   static {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(new IiiIiIiiI_Class215.Nested1_98f25c60());
   }

   static final class Nested1_98f25c60 {
      final IiIIIiII_Class69<HudRenderEvent> I_field_3d936f41 = var0 -> {
         IiiIiIiiI_Class215 var1 = IiiIiIiiI_Class215.I_field_a5e73e6c;
         if (var1 != null) {
            MinecraftClient var2 = MinecraftClient.getInstance();
            if (var1.III_method_e51d2e6f() >= 1.0F) {
               IiiIiIiiI_Class215.I_field_a5e73e6c = null;
               IiiIiIiiI_Class215.I_field_5a = false;
               IiiIiIiiI_Class215.i_field_5a = false;
            } else if (var2.currentScreen == null) {
               if (!IiiIiIiiI_Class215.I_field_5a) {
                  IiiIiIiiI_Class215.I_field_cb35e4c.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                  IiiIiIiiI_Class215.I_field_cb35e4c.I_method_53fdf4b5(true);
                  iIiiiiIii_Class380.I_field_5a = true;

                  try {
                     var1.render(III.I_method_5728d20f(var0.getContext(), -1, -1, var0.getTickDelta()));
                  } finally {
                     iIiiiiIii_Class380.I_field_5a = false;
                     IiiIiIiiI_Class215.I_field_cb35e4c.i_method_766109df();
                  }

                  IiiIiIiiI_Class215.I_field_5a = true;
               }

               if (!IiiIiIiiI_Class215.i_field_5a) {
                  IiiIiIiiI_Class215.I_method_8bb2cef1(var0);
               }
            }
         }
      };
      final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41 = IiIIIiII_Class69.I_method_aec3ff5f(
         Integer.MIN_VALUE,
         var0 -> {
            IiiIiIiiI_Class215 var1 = IiiIiIiiI_Class215.I_field_a5e73e6c;
            if (var1 != null && IiiIiIiiI_Class215.I_field_5a && var1.I_field_5bba0d50 != null) {
               MinecraftClient var2 = MinecraftClient.getInstance();
               float var3 = var1.III_method_e51d2e6f();
               float var4 = Math.min(1.0F, var3 / 0.4F);
               float var5 = var3 <= 0.4F ? 0.0F : (var3 - 0.4F) / 0.6F;
               float var6 = IiiiIiiII_Class237.iI_field_dd60aac.ease(var4, 0.0F, 1.0F, 1.0F);
               float var7 = 1.0F - var6;
               float var8 = Math.min(1.0F, Math.max(0.0F, (var5 - 0.15F) / 0.85F));
               float var10 = (float)(
                  Math.tan(Math.toRadians(((Integer)var2.options.getFov().getValue()).intValue()) / 2.0) / Math.tan(Math.toRadians(110.0) / 2.0)
               );
               float var11 = (3.3F + var7) * var10;
               float var12 = var11 * ((float)var2.getWindow().getFramebufferWidth() / var2.getWindow().getFramebufferHeight());
               Vec3d var13 = var2.gameRenderer.getCamera().getPos();
               Vec3d var14 = var1.I_field_5bba0d50;
               Vec3d var15 = var1.II_field_5bba0d50.multiply(var12 / 2.0);
               Vec3d var16 = var1.Ii_field_5bba0d50.multiply(var11 / 2.0);
               Vec3d var17 = var14.subtract(var15).add(var16).subtract(var13);
               Vec3d var18 = var14.subtract(var15).subtract(var16).subtract(var13);
               Vec3d var19 = var14.add(var15).subtract(var16).subtract(var13);
               Vec3d var20 = var14.add(var15).add(var16).subtract(var13);
               RenderSystem.enableBlend();
               RenderSystem.defaultBlendFunc();
               RenderSystem.disableDepthTest();
               RenderSystem.disableCull();
               RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
               RenderSystem.setShaderTexture(0, IiiIiIiiI_Class215.I_field_cb35e4c.getColorAttachment());
               Matrix4f var21 = var0.getMatrices().peek().getPositionMatrix();
               int var22 = ColorRGBA.WHITE.withAlpha(255.0F * var7).getRGB();
               BufferBuilder var23 = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_TEXTURE_COLOR);
               float shatterProgress = var3 * var3;

               // Center impact point
               float cx = 0.50F, cy = 0.48F;

               // Inner ring of irregular fracture points
               int N1 = 8;
               float[][] r1 = new float[N1][2];
               for (int i = 0; i < N1; i++) {
                  double a = (Math.PI * 2.0 * i) / N1 + 0.18 * Math.sin(i * 4.3);
                  float r = 0.16F + 0.04F * (float)Math.sin(i * 6.7);
                  r1[i][0] = cx + (float)Math.cos(a) * r * 1.25F;
                  r1[i][1] = cy + (float)Math.sin(a) * r;
               }

               // Mid ring of irregular fracture points
               int N2 = 12;
               float[][] r2 = new float[N2][2];
               for (int i = 0; i < N2; i++) {
                  double a = (Math.PI * 2.0 * i) / N2 + 0.15 * Math.cos(i * 3.1);
                  float r = 0.36F + 0.07F * (float)Math.cos(i * 5.2);
                  r2[i][0] = Math.max(0.04F, Math.min(0.96F, cx + (float)Math.cos(a) * r * 1.25F));
                  r2[i][1] = Math.max(0.04F, Math.min(0.96F, cy + (float)Math.sin(a) * r));
               }

               // Outer perimeter points
               float[][] border = new float[][]{
                  {0.0F, 0.0F}, {0.25F, 0.0F}, {0.50F, 0.0F}, {0.75F, 0.0F}, {1.0F, 0.0F},
                  {1.0F, 0.33F}, {1.0F, 0.66F}, {1.0F, 1.0F},
                  {0.75F, 1.0F}, {0.50F, 1.0F}, {0.25F, 1.0F}, {0.0F, 1.0F},
                  {0.0F, 0.66F}, {0.0F, 0.33F}
               };

               // Layer 1: Central shards (Impact point to Inner Ring)
               for (int i = 0; i < N1; i++) {
                  int next = (i + 1) % N1;
                  drawGlassShard(var23, var21, var1, var13, var17, var18, var19, shatterProgress, var22,
                     cx, cy, r1[i][0], r1[i][1], r1[next][0], r1[next][1]);
               }

               // Layer 2: Mid shards (Inner Ring to Mid Ring)
               for (int i = 0; i < N1; i++) {
                  int next1 = (i + 1) % N1;
                  int m0 = (i * N2) / N1;
                  int m1 = ((i + 1) * N2) / N1;
                  drawGlassShard(var23, var21, var1, var13, var17, var18, var19, shatterProgress, var22,
                     r1[i][0], r1[i][1], r2[m0 % N2][0], r2[m0 % N2][1], r2[m1 % N2][0], r2[m1 % N2][1]);
                  drawGlassShard(var23, var21, var1, var13, var17, var18, var19, shatterProgress, var22,
                     r1[i][0], r1[i][1], r2[m1 % N2][0], r2[m1 % N2][1], r1[next1][0], r1[next1][1]);
               }

               // Layer 3: Outer perimeter shards (Mid Ring to Border)
               int NB = border.length;
               for (int i = 0; i < NB; i++) {
                  int nextB = (i + 1) % NB;
                  int m = (i * N2) / NB;
                  int mNext = ((i + 1) * N2) / NB;
                  drawGlassShard(var23, var21, var1, var13, var17, var18, var19, shatterProgress, var22,
                     border[i][0], border[i][1], border[nextB][0], border[nextB][1], r2[m % N2][0], r2[m % N2][1]);
                  if (m != mNext) {
                     drawGlassShard(var23, var21, var1, var13, var17, var18, var19, shatterProgress, var22,
                        border[nextB][0], border[nextB][1], r2[m % N2][0], r2[m % N2][1], r2[mNext % N2][0], r2[mNext % N2][1]);
                  }
               }
               BufferRenderer.drawWithGlobalProgram(var23.end());
               IiiIiIiiI_Class215.i_field_5a = true;
               RenderSystem.enableDepthTest();
               RenderSystem.enableCull();
               RenderSystem.disableBlend();
               RenderSystem.setShaderTexture(0, 0);
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               if (var3 >= 1.0F) {
                  IiiIiIiiI_Class215.I_field_a5e73e6c = null;
                  IiiIiIiiI_Class215.I_field_5a = false;
               }
            }
         }
      );
   }

   private static void drawGlassShard(
      BufferBuilder buf,
      Matrix4f mat,
      IiiIiIiiI_Class215 screen,
      Vec3d camPos,
      Vec3d pTopLeft,
      Vec3d pBottomLeft,
      Vec3d pBottomRight,
      float progress,
      int color,
      float u1, float v1,
      float u2, float v2,
      float u3, float v3
   ) {
      float uMid = (u1 + u2 + u3) / 3.0F;
      float vMid = (v1 + v2 + v3) / 3.0F;

      float seed = (float)(Math.sin(uMid * 127.1 + vMid * 311.7) * 43758.5453);
      seed = seed - (float)Math.floor(seed);
      float randRot = (seed - 0.5F) * 2.8F;
      float randX = (float)Math.sin(seed * 23.4) * 0.8F;
      float randZ = (float)Math.cos(seed * 41.2) * 0.6F;

      // High-velocity physical 3D dispersion with gravity, lateral blast, and forward tumble
      Vec3d gravity = screen.Ii_field_5bba0d50.multiply(-4.8 * progress * (1.0 + progress * 0.85));
      Vec3d blast = screen.II_field_5bba0d50.multiply((uMid - 0.5F + randX * 0.22F) * 2.8 * progress)
                   .add(screen.Ii_field_5bba0d50.multiply((vMid - 0.5F + randZ * 0.22F) * 2.2 * progress))
                   .add(screen.I_field_5bba0d50.subtract(camPos).normalize().multiply((randZ * 1.8F - 0.35F) * progress));
      Vec3d disp = blast.add(gravity);

      float rot = randRot * 2.6F * progress;
      float cos = (float)Math.cos(rot);
      float sin = (float)Math.sin(rot);

      float[] us = new float[]{u1, u2, u3};
      float[] vs = new float[]{v1, v2, v3};

      for (int i = 0; i < 3; i++) {
         float du = us[i] - uMid;
         float dv = vs[i] - vMid;
         float ru = uMid + du * cos - dv * sin;
         float rv = vMid + du * sin + dv * cos;

         Vec3d pt = pBottomLeft.add(pBottomRight.subtract(pBottomLeft).multiply(ru))
                               .add(pTopLeft.subtract(pBottomLeft).multiply(rv))
                               .add(disp);

         buf.vertex(mat, (float)pt.x, (float)pt.y, (float)pt.z)
            .texture(us[i], vs[i])
            .color(color);
      }
   }
}
