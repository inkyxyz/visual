package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

public class IiiIiIiii_Class216 extends IIiI_Class3 implements IiiIiIIiI_Class211 {
   private static final IIii_Class4 I_field_f93678c1 = IIii_Class4.I_method_3682ece9(140L, IiiiIiiII_Class237.IIII_field_dd60aac);
   private static final long I_field_4a = 140L;
   private static final IiiiIiiII_Class237 I_field_dd60aac = IiiiIiiII_Class237.IIII_field_dd60aac;
   private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(255.0F, 120.0F, 120.0F);
   private IntConsumer I_field_a2c190c1;
   private IIIIi_Class2 I_field_2d89a12c;
   private final Map<ModuleEntry, iiI_Class7> I_field_a567c40b = new HashMap<>();
   private final Map<Setting, iiI_Class7> i_field_a567c40b = new HashMap<>();
   private final Map<ModuleCategory, iii_Class8> II_field_a567c40b = new HashMap<>();
   private final Map<ModuleCategory, Float> Ii_field_a567c40b = new HashMap<>();
   private final Map<ModuleCategory, float[]> iI_field_a567c40b = new HashMap<>();
   private final Map<ModuleEntry, IiiIiIiii_Class216.Nested1_8567bbe9> ii_field_a567c40b = new HashMap<>();
   private final Map<ModuleCategory, ModuleEntry[]> III_field_a567c40b = new HashMap<>();
   private final Map<ModuleCategory, iiI_Class7> IIi_field_a567c40b = new HashMap<>();
   private final Map<ModuleCategory, List<ModuleEntry>> IiI_field_a567c40b = new HashMap<>();
   private final Map<ModuleEntry, List<Setting>> Iii_field_a567c40b = new HashMap<>();
   private boolean I_field_5a = true;
   private int I_field_49 = -1;
   private Runnable I_field_bac0a97e;
   private iiI_Class7 I_field_b5845eac;
   private long i_field_4a;
   private IiiIiIiii_Class216.Nested1_8567bbc9 I_field_5ad2b0c6;
   private ModuleEntry I_field_75e36361;
   private static final float I_field_46 = 300.0F;
   private long II_field_4a;
   private static final float i_field_46 = 300.0F;
   private float II_field_46;
   private long Ii_field_4a;
   private boolean i_field_5a;
   private static final float Ii_field_46 = 1600.0F;
   private static final float iI_field_46 = 0.4F;
   private boolean II_field_5a;
   private long iI_field_4a;
   Vec3d I_field_5bba0d50;
   private Vec3d i_field_5bba0d50;
   Vec3d II_field_5bba0d50;
   Vec3d Ii_field_5bba0d50;
   static IiiIiIiii_Class216 I_field_a5e7424c;
   private final List<IiiIiIiii_Class216.Nested1_98f2d4a0> I_field_7865b31 = new ArrayList<>();
   private final IiIIiIiiI_Class151 I_field_a9c1a28c = new IiIIiIiiI_Class151(
         IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F), 10.0F, 300L, IiiiIiiII_Class237.I_field_dd60aac
      )
      .I_method_49374335();
   static final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(false).I_method_cc37aab5();
   static boolean Ii_field_5a;
   static boolean iI_field_5a;

   @Override
   protected boolean lowDrawBatching() {
      return true;
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (iiiI_Class15.i_method_3a56361e(var5)) {
         this.i_method_cb02eddf();
      } else {
         if (this.I_field_75e36361 != null) {
            if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
               this.I_field_75e36361 = null;
               return;
            }

            if (var5 != IiIII_Class9.II_field_2f4c8d6c) {
               this.I_field_75e36361.setKeybind(iIIIIIIII_Class257.Ii_method_99f62a34(var5.I_method_6d899712()));
               this.I_field_75e36361 = null;
               this.i_method_cb02eddf();
               return;
            }
         }

         if (this.I_field_a2c190c1 == null || var5 != IiIII_Class9.Ii_field_2f4c8d6c && var5 != IiIII_Class9.iI_field_2f4c8d6c) {
            if (this.I_field_2d89a12c != null && this.overlays.stream().noneMatch(var4 -> var4.alive() && var4.contains((float)var1, (float)var3))) {
               this.I_field_2d89a12c.I_method_911c871f((float)var1, (float)var3);
            }

            super.onMouseClicked(var1, var3, var5);
         } else {
            this.I_field_a2c190c1.accept(var5 == IiIII_Class9.Ii_field_2f4c8d6c ? -1 : 1);
         }
      }
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
      if (this.I_field_75e36361 == null && !iiiI_Class15.i_method_d4e71010()) {
         if (Screen.hasControlDown() && keyCode == 90 && IIiiiIIIi_Class114.I_method_fe3ce603()) {
            return true;
         }

         if (Screen.hasControlDown() && keyCode == 89 && IIiiiIIIi_Class114.i_method_fe4b71e3()) {
            return true;
         }
      }

      if (this.I_field_75e36361 != null) {
         if (keyCode != 256 && keyCode != 261) {
            int var4 = iIIIIIIII_Class257.i_method_cd0c4692(keyCode, modifiers);
            if (var4 == Integer.MIN_VALUE) {
               return true;
            } else {
               this.I_field_75e36361.setKeybind(var4);
               this.I_field_75e36361 = null;
               this.i_method_cb02eddf();
               return true;
            }
         } else {
            this.I_field_75e36361.setKeybind(-1);
            this.I_field_75e36361 = null;
            this.i_method_cb02eddf();
            return true;
         }
      } else if (super.keyPressed(keyCode, scanCode, modifiers)) {
         return true;
      } else if (MenuModule.I_method_48514ce8(keyCode)) {
         this.close();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
      if (this.I_field_75e36361 != null) {
         int var4 = iIIIIIIII_Class257.II_method_6e347cf5(keyCode, modifiers);
         if (var4 != Integer.MIN_VALUE) {
            this.I_field_75e36361.setKeybind(var4);
            this.I_field_75e36361 = null;
            this.i_method_cb02eddf();
            return true;
         }
      }

      return super.keyReleased(keyCode, scanCode, modifiers);
   }

   private void i_method_cb02eddf() {
      RockstarClient.getInstance().I_method_5198232b().II_method_1fbeeff5();
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   public void render(III var1) {
      this.II_method_93a6d542();
      this.Ii_method_93b56122();
      GuiMoveModule.iII_method_9983ebf();
      if (!this.II_field_5a) {
         this.iI_method_9569c562();
      }

      float var2 = this.II_field_5a ? 1.0F : 0.7F + 0.3F * this.ii_method_95785132();
      boolean var3 = Math.abs(var2 - 1.0F) > 1.0E-4F;
      if (var3) {
         var1.getMatrices().push();
         var1.getMatrices().translate(this.width / 2.0F, this.height / 2.0F, 0.0F);
         var1.getMatrices().scale(var2, var2, 1.0F);
         var1.getMatrices().translate(-this.width / 2.0F, -this.height / 2.0F, 0.0F);
      }

      IiiIiIIIi_Class210.I_method_bd87019f(this, var1);
      super.render(var1);
      IiiIiIIIi_Class210.i_method_789a4d7f(this, var1);
      if (var3) {
         var1.getMatrices().pop();
      }
   }

   @Override
   public String I_method_8c872841() {
      return "panel";
   }

   @Override
   public float I_method_9833b22f() {
      return this.ii_method_95785132();
   }

   @Override
   public float i_method_98423e0f() {
      return this.II_field_5a ? this.III_method_e142ca4f() : 0.0F;
   }

   @Override
   public boolean I_method_9833b243() {
      return this.II_field_5a;
   }

   @Override
   public float II_method_6e518cf2() {
      return this.contentAlpha;
   }

   @Override
   public float Ii_method_6e6018d2() {
      return this.II_field_5a ? 1.0F : 0.7F + 0.3F * this.ii_method_95785132();
   }

   @Override
   public List<IiiIiIIiI_Class211.Nested1_972f6c40> I_method_cb1d7a28() {
      ArrayList var1 = new ArrayList(this.II_field_a567c40b.size());

      for (ModuleCategory var5 : ModuleCategory.values()) {
         iii_Class8 var6 = this.II_field_a567c40b.get(var5);
         if (var6 != null) {
            var1.add(new IiiIiIIiI_Class211.Nested1_972f6c40(var5.name().toLowerCase(Locale.ROOT), var6.x(), var6.y(), var6.w(), var6.h()));
         }
      }

      return var1;
   }

   public static IiiIiIiii_Class216 I_method_75b872b5() {
      return I_field_a5e7424c;
   }

   private float ii_method_95785132() {
      float var1 = Math.min(1.0F, Math.max(0.0F, (float)(System.currentTimeMillis() - this.II_field_4a) / 300.0F));
      return IiiiIiiII_Class237.I_field_dd60aac.ease(var1, 0.0F, 1.0F, 1.0F);
   }

   private void II_method_93a6d542() {
      long var1 = System.currentTimeMillis();
      if (this.II_field_5a) {
         this.II_field_46 = 0.0F;
         this.Ii_field_4a = var1;
         this.contentAlpha = 1.0F;
      } else {
         float var3 = this.Ii_field_4a == 0L ? 16.0F : Math.min(64.0F, (float)(var1 - this.Ii_field_4a));
         this.Ii_field_4a = var1;
         int var4 = RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class).I_method_20c0695().I_method_fa6281d2();
         float var5 = I_method_939850e8(var4) ? 1.0F : 0.0F;
         float var6 = var3 / 300.0F;
         if (this.II_field_46 < var5) {
            this.II_field_46 = Math.min(var5, this.II_field_46 + var6);
         } else if (this.II_field_46 > var5) {
            this.II_field_46 = Math.max(var5, this.II_field_46 - var6);
         }

         this.contentAlpha = 1.0F - IiiiIiiII_Class237.III_field_dd60aac.ease(this.II_field_46, 0.0F, 1.0F, 1.0F);
      }
   }

   private void Ii_method_93b56122() {
      if (!this.II_field_5a && !(this.contentAlpha >= 0.999F)) {
         long var1 = MinecraftClient.getInstance().getWindow().getHandle();
         boolean var3 = GLFW.glfwGetMouseButton(var1, 0) == 1;
         if (!var3 || iiI_Class7.spotlight() == null) {
            iiI_Class7 var4 = null;

            for (Entry var6 : this.i_field_a567c40b.entrySet()) {
               iiI_Class7 var7 = (iiI_Class7)var6.getValue();
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

   private static boolean I_method_939850e8(int var0) {
      return iIIIIIIII_Class257.II_method_98333a25(var0);
   }

   @Override
   public void removed() {
      this.I_method_caf461ff();
      super.removed();
   }

   @Compile(
      obfuscation = 1
   )
   public void I_method_caf461ff() {
      if (!this.II_field_5a) {
         this.II_field_5a = true;
         iiI_Class7.spotlight(null);
         RockstarClient.getInstance().I_method_5198232b().II_method_1fbeeff5();
         this.iI_field_4a = System.currentTimeMillis();
         Ii_field_5a = false;
         iI_field_5a = false;
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

         I_field_a5e7424c = this;
      }
   }

   float III_method_e142ca4f() {
      return Math.min(1.0F, Math.max(0.0F, (float)(System.currentTimeMillis() - this.iI_field_4a) / 1600.0F));
   }

   static void I_method_33e0a711(HudRenderEvent var0) {
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

   @Compile(
      obfuscation = 4
   )
   @Override
   public void init() {
      super.init();
      this.II_field_4a = System.currentTimeMillis();
      this.II_field_5a = false;
      this.I_field_75e36361 = null;
      iiiI_Class15.i_method_d4e7100c();
      this.II_field_46 = 0.0F;
      this.Ii_field_4a = 0L;
      this.contentAlpha = 1.0F;
      this.I_field_5a = true;
      if (!this.i_field_5a) {
         this.i_field_5a = true;
         this.clearRoots();
         this.I_field_a567c40b.clear();
         this.i_field_a567c40b.clear();
         this.II_field_a567c40b.clear();
         this.ii_field_a567c40b.clear();
         this.III_field_a567c40b.clear();
         this.IIi_field_a567c40b.clear();
         this.IiI_field_a567c40b.clear();
         this.Iii_field_a567c40b.clear();
         this.I_field_7865b31.clear();
         this.I_field_b5845eac = null;
         this.I_field_5ad2b0c6 = null;
         HashMap var1 = new HashMap();
         iii_Class8 var2 = new iii_Class8()
            .I_method_3301fdd(iII_Class5.II_field_b583e68c)
            .I_method_70a38517(10.0F)
            .IiI_method_31d4c97(243.0F)
            .iII_method_d8ebd935()
            .I_method_f136b1d8(
               (var2x, var3x) -> {
                  for (iiI_Class7 var5x : var3x.I_method_38e5328()) {
                     var2x.drawShadow(
                        var5x.x(),
                        var5x.y(),
                        var5x.w(),
                        var5x.h(),
                        25.0F,
                        IIiii_Class8.I_method_893b2757(11.0F),
                        IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.15F)
                     );
                  }

                  for (iiI_Class7 var10x : var3x.I_method_38e5328()) {
                     var2x.drawBlurredRect(
                        var10x.x(), var10x.y(), var10x.w(), var10x.h(), 5.0F, 3.0F, IIiii_Class8.I_method_893b2757(11.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5
                     );
                  }

                  for (iiI_Class7 var11x : var3x.I_method_38e5328()) {
                     if (var11x instanceof iii_Class8 var6) {
                        ModuleCategory var7 = (ModuleCategory)var1.get(var6);
                        if (var7 != null) {
                           this.I_method_7aab2760(var2x, var6, var7);
                        }
                     }
                  }
               }
            );
         ArrayList var3 = new ArrayList();
         ArrayList var4 = new ArrayList();
         int[] var5 = new int[]{-1};
         this.I_field_bac0a97e = () -> {
            this.I_field_5a = true;
            ModuleEntry[] var4x = new ModuleEntry[var3.size()];

            for (int var5x = 0; var5x < var3.size(); var5x++) {
               var4x[var5x] = ((ModuleEntry[])var3.get(var5x))[0];
            }

            while (var4.size() > var5[0] + 1) {
               var4.remove(var4.size() - 1);
            }

            var4.add(var4x);
            var5[0] = var4.size() - 1;
         };

         for (ModuleCategory var9 : ModuleCategory.values()) {
            iii_Class8 var10 = new iii_Class8()
               .IIi_method_4dfc88d7(115.0F)
               .I_method_b65baecb(
                  var0 -> var0.i_method_65326e43(3.0F)
                     .I_method_4f0ff9cb(1.0F, 6.0F)
                     .I_method_2a080a63(2.5F)
                     .i_method_989a5f71(
                        var0x -> ColorRGBA.BLACK
                           .mix(ColorRGBA.WHITE, 0.3F)
                           .withAlpha(255.0F * (0.32F + 0.28F * var0x.I_method_af833bdc() + 0.3F * var0x.i_method_af91c7bc()))
                     )
               )
               .I_method_7e2bb176(IIII.I_method_12c9a0cb(25.0F, 0.0F, 1.0F, 0.0F))
               .Ii_method_bb38d618()
               .IIi_method_1df35135();
            ModuleEntry[] var11 = new ModuleEntry[]{null};
            var3.add(var11);
            this.III_field_a567c40b.put(var9, var11);
            this.II_field_a567c40b.put(var9, var10);
            var1.put(var10, var9);
            List var12 = RockstarClient.getInstance()
               .getModuleManager()
               .getModules()
               .stream()
               .sorted(Comparator.comparing(ModuleEntry::getName))
               .filter(var1x -> var1x.getCategory() == var9 && var1x.isAvailable())
               .toList();
            Iii_Class4 var13 = new Iii_Class4().height(2.0F).visibleWhen(() -> var11[0] == null);
            this.IIi_field_a567c40b.put(var9, var13);
            var10.I_method_8939bffd(var13);

            for (ModuleEntry var15 : (Iterable<ModuleEntry>)(Iterable<?>)var12) {
               IiiIiIiii_Class216.Nested1_8567bbe9 var16 = this.I_method_69d5f4fb(var9, var15);
               this.ii_field_a567c40b.put(var15, var16);
               var10.I_method_8939bffd(var16.I_method_70cc1827());
               var10.I_method_8939bffd(var16.I_method_70bd8c47());
               var10.I_method_8939bffd(var16.i_method_f0fdf407());
            }

            this.IiI_field_a567c40b.put(var9, var12);
            var2.I_method_8939bffd(var10);
         }

         this.I_field_bac0a97e.run();
         this.I_field_a2c190c1 = var4x -> {
            int var5x = var5[0] + var4x;
            if (var5x >= 0 && var5x < var4.size()) {
               var5[0] = var5x;
               this.I_field_5a = true;
               ModuleEntry[] var6 = (ModuleEntry[])var4.get(var5x);

               for (int var7 = 0; var7 < var3.size(); var7++) {
                  ((ModuleEntry[])var3.get(var7))[0] = var6[var7];
               }
            }
         };
         BiConsumer<ModuleEntry, Setting> var17 = (var1x, var2x) -> {
            if (this.III_field_a567c40b.containsKey(var1x.getCategory())) {
               this.I_method_f4344fe1(var1x.getCategory(), var1x);
               this.I_field_5ad2b0c6 = new IiiIiIiii_Class216.Nested1_8567bbc9(var1x, var2x);
            }
         };
         this.I_field_2d89a12c = new IIIIi_Class2(var2, var17);
         this.add(var2);
         this.add(this.I_field_2d89a12c);
         this.add(this.I_field_2d89a12c.IIii_method_d1a53438());
         this.add(this.I_field_2d89a12c.IiII_method_6941c18());
      }
   }

   @Compile(
      obfuscation = 1
   )
   private IiiIiIiii_Class216.Nested1_8567bbe9 I_method_69d5f4fb(ModuleCategory var1, ModuleEntry var2) {
      ModuleEntry[] var3 = this.III_field_a567c40b.get(var1);
      Iii_Class4 var4 = new Iii_Class4()
         .text(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
            () -> {
               if (this.I_field_75e36361 != var2) {
                  return var2.getName();
               } else {
                  int var2x = iIIIIIIII_Class257.I_method_e761de12();
                  if (var2x != 0) {
                     return IiIiIIII_Class81.I_method_f25a980a("key") + ": " + iIIIIIIII_Class257.I_method_f90bbc5c(var2x) + "...";
                  } else {
                     int var3x = var2.getKeybind();
                     return var3x == -1
                        ? IiIiIIII_Class81.I_method_f25a980a("menu.binding")
                        : IiIiIIII_Class81.I_method_f25a980a("key") + ": " + iIIIIiIiI_Class267.I_method_a937749c(var3x);
                  }
               }
            },
            var0 -> {
               ColorRGBA var1x = IiiiiIIIi_Class242.iII_field_d0c8ec5
                  .mix(IiiiiIIIi_Class242.ii_field_d0c8ec5, var0.sig("enabled", I_field_dd60aac) * (1.0F - var0.sig("open", I_field_dd60aac)))
                  .mulAlpha(0.75F + 0.25F * var0.sig("enabled", I_field_dd60aac));
               float var2x = var0.shakeAmount();
               return var2x > 0.0F ? var1x.mix(I_field_d0c8ec5.withAlpha(var1x.getAlpha()), var2x) : var1x;
            }
         )
         .bind("enabled", var2::isEnabled, 140L)
         .bind("open", () -> var3[0] == var2, 140L)
         .height(6.0F)
         .animatePosition()
         .motion(I_field_f93678c1)
         .interactive(false);
      Iii_Class4 var5 = new Iii_Class4()
         .size(18.0F, 18.0F)
         .icon("back", 6.0F, IiiiiIIIi_Class242.iII_field_d0c8ec5)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick(() -> this.I_method_ff8a2a80(var1))
         .visibleWhen(() -> var3[0] == var2);
      Iii_Class4 var6 = new Iii_Class4()
         .size(6.0F, 6.0F)
         .icon("check", 6.0F, var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(var0.sig("enabled", I_field_dd60aac)))
         .bind("enabled", () -> var2.isEnabled() && this.I_field_75e36361 != var2, 140L)
         .visibleWhen(() -> var3[0] != var2)
         .interactive(false);
      Iii_Class4 var7 = new IIiiI_Class7(var2::isEnabled)
         .i_method_c4678f15(() -> IiiiiIIIi_Class242.IIi_field_d0c8ec5)
         .size(13.0F, 8.0F)
         .onClick(var2::toggle)
         .visibleWhen(() -> var3[0] == var2);
      iii_Class8 var8 = new iii_Class8()
         .I_method_485bccf5()
         .III_method_9dc17555()
         .I_method_84672d76(I_field_f93678c1)
         .iii_method_df275535()
         .I_method_3f5fb576(IiiI_Class7.I_method_540512a3(20.0F));
      var8.I_method_879bc687(() -> var3[0] == var2);
      iii_Class8 var9 = new iii_Class8()
         .I_method_3301fdd(iII_Class5.II_field_b583e68c)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 9.0F, 0.0F, 9.0F))
         .IiI_method_31d4c97(18.0F)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(
            new iii_Class8()
               .I_method_3301fdd(iII_Class5.II_field_b583e68c)
               .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
               .I_method_70a38517(-9.0F)
               .I_method_8939bffd(var5)
               .I_method_8939bffd(var4)
         )
         .I_method_8939bffd(var6)
         .I_method_8939bffd(var7);
      var9.I_method_b60c4df8((var6x, var7x, var8x) -> {
         if (var6x == IiIII_Class9.II_field_2f4c8d6c) {
            this.I_field_75e36361 = this.I_field_75e36361 == var2 ? null : var2;
         } else if (var6x == IiIII_Class9.i_field_2f4c8d6c) {
            if (var3[0] != var2) {
               if (var2.getSettings().isEmpty()) {
                  this.I_method_53804f87(var4);
               } else {
                  this.I_method_f4344fe1(var1, var2);
               }
            }
         } else if (var6x == IiIII_Class9.I_field_2f4c8d6c) {
            if (var3[0] == var2) {
               if (var7x < var9.x() + var9.w() / 2.0F) {
                  this.I_method_ff8a2a80(var1);
               } else {
                  var2.toggle();
               }
            } else {
               var2.toggle();
            }
         }
      });
      var9.III_method_9dc17555().I_method_879bc687(() -> var3[0] == null || var3[0] == var2).iii_method_df275535().II_method_65e0ce4a(() -> var3[0] == var2);
      Iii_Class4 var10 = new Iii_Class4()
         .fillWidth()
         .height(1.0F)
         .background(IiiiiIIIi_Class242.IiI_field_d0c8ec5)
         .visibleWhen(() -> var3[0] == var2)
         .snapPosition()
         .sticky(() -> var3[0] == var2);
      this.I_field_a567c40b.put(var2, var9);
      this.I_field_7865b31.add(new IiiIiIiii_Class216.Nested1_98f2d4a0(var9, var2::i_method_bf522194));
      return new IiiIiIiii_Class216.Nested1_8567bbe9(var9, var10, var8);
   }

   @Compile(
      obfuscation = 1
   )
   private void iI_method_9569c562() {
      if (this.i_field_5a) {
         int var1 = ModuleManager.I_method_7056a45f();
         if (var1 != this.I_field_49) {
            this.I_field_49 = var1;
            this.I_field_5a = true;
         }

         if (this.I_field_5a) {
            this.I_field_5a = false;
            ModuleManager var2 = RockstarClient.getInstance().getModuleManager();
            if (this.I_field_75e36361 != null && !var2.getModules().contains(this.I_field_75e36361)) {
               this.I_field_75e36361 = null;
            }

            for (ModuleCategory var6 : ModuleCategory.values()) {
               iii_Class8 var7 = this.II_field_a567c40b.get(var6);
               ModuleEntry[] var8 = this.III_field_a567c40b.get(var6);
               if (var7 != null && var8 != null) {
                  List var9 = var2.getModules()
                     .stream()
                     .sorted(Comparator.comparing(ModuleEntry::getName))
                     .filter(var1x -> var1x.getCategory() == var6 && var1x.isAvailable())
                     .toList();
                  if (!I_method_a243bde5(this.IiI_field_a567c40b.get(var6), var9)) {
                     if (var8[0] != null && !var9.contains(var8[0])) {
                        ModuleEntry var10 = I_method_de60f9c6(var9, var8[0]);
                        var8[0] = var10;
                        if (var10 == null) {
                           this.i_method_151f9e60(var6);
                        }
                     }

                     List var16 = this.IiI_field_a567c40b.get(var6);
                     if (var16 != null) {
                        for (ModuleEntry var12 : (Iterable<ModuleEntry>)(Iterable<?>)var16) {
                           if (!var9.contains(var12)) {
                              IiiIiIiii_Class216.Nested1_8567bbe9 var13 = this.ii_field_a567c40b.get(var12);
                              if (var13 != null) {
                                 var7.I_method_38e5328().removeAll(List.of(var13.I_method_70cc1827(), var13.I_method_70bd8c47(), var13.i_method_f0fdf407()));
                              }

                              this.I_method_c8ef16a0(var12);
                           }
                        }
                     }

                     ArrayList var18 = new ArrayList();
                     iiI_Class7 var19 = this.IIi_field_a567c40b.get(var6);
                     if (var19 != null) {
                        var18.add(var19);
                     }

                     for (ModuleEntry var14 : (Iterable<ModuleEntry>)(Iterable<?>)var9) {
                        IiiIiIiii_Class216.Nested1_8567bbe9 var15 = this.ii_field_a567c40b.computeIfAbsent(var14, var2x -> this.I_method_69d5f4fb(var6, var2x));
                        var18.add(var15.I_method_70cc1827());
                        var18.add(var15.I_method_70bd8c47());
                        var18.add(var15.i_method_f0fdf407());
                     }

                     var7.II_method_244860a9(var18);
                     this.IiI_field_a567c40b.put(var6, var9);
                  }

                  if (var8[0] != null) {
                     IiiIiIiii_Class216.Nested1_8567bbe9 var17 = this.ii_field_a567c40b.get(var8[0]);
                     if (var17 != null) {
                        this.I_method_57270566(var8[0], var17.i_method_f0fdf407());
                     }
                  }
               }
            }
         }
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_57270566(ModuleEntry var1, iii_Class8 var2) {
      List var3 = var1.getSettings();
      List var4 = this.Iii_field_a567c40b.get(var1);
      if (!I_method_a243bde5(var4, var3)) {
         ArrayList var5 = new ArrayList();

         for (Setting var7 : (Iterable<Setting>)(Iterable<?>)var3) {
            Object var8 = this.i_field_a567c40b.get(var7);
            if (var8 == null) {
               iii_Class8 var9 = IiiIiiIIi_Class218.I_method_83bcc05d(var7);
               this.i_field_a567c40b.put(var7, var9);
               this.I_field_7865b31.add(new IiiIiIiii_Class216.Nested1_98f2d4a0(var9, () -> IiIiIIII_Class81.i_method_1279802a(var7.getDescriptionKey())));
               var8 = var9;
            }

            var5.add(var8);
         }

         if (var4 != null) {
            for (Setting var11 : (Iterable<Setting>)(Iterable<?>)var4) {
               if (!var3.contains(var11)) {
                  iiI_Class7 var12 = this.i_field_a567c40b.remove(var11);
                  if (var12 != null) {
                     var2.I_method_38e5328().remove(var12);
                     this.I_field_7865b31.removeIf(var1x -> var1x.I_method_91c66770() == var12);
                  }
               }
            }
         }

         var2.II_method_244860a9(var5);
         this.Iii_field_a567c40b.put(var1, new ArrayList<>(var3));
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_c8ef16a0(ModuleEntry var1) {
      IiiIiIiii_Class216.Nested1_8567bbe9 var2 = this.ii_field_a567c40b.remove(var1);
      this.I_field_a567c40b.remove(var1);
      if (var2 != null) {
         this.I_field_7865b31.removeIf(var1x -> var1x.I_method_91c66770() == var2.I_method_70cc1827());
      }

      List var3 = this.Iii_field_a567c40b.remove(var1);
      if (var3 != null) {
         for (Setting var5 : (Iterable<Setting>)(Iterable<?>)var3) {
            iiI_Class7 var6 = this.i_field_a567c40b.remove(var5);
            if (var6 != null) {
               this.I_field_7865b31.removeIf(var1x -> var1x.I_method_91c66770() == var6);
            }
         }
      }
   }

   private static ModuleEntry I_method_de60f9c6(List<ModuleEntry> var0, ModuleEntry var1) {
      for (ModuleEntry var3 : var0) {
         if (var3.getName().equals(var1.getName())) {
            return var3;
         }
      }

      return null;
   }

   private static boolean I_method_a243bde5(List<?> var0, List<?> var1) {
      if (var0 == null) {
         return var1.isEmpty();
      } else if (var0.size() != var1.size()) {
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

   @Compile(
      obfuscation = 1
   )
   private void I_method_1b224b87(III var1) {
      if (!(this.contentAlpha <= 0.01F)) {
         float var2 = var1.I_method_b1c3e152();
         float var3 = var1.i_method_b1d26d32();
         String var4 = "";
         boolean var5 = this.I_field_2d89a12c != null
               && (
                  this.I_field_2d89a12c.contains(var2, var3)
                     || this.I_field_2d89a12c.IIii_method_d1a53438().inFlow() && this.I_field_2d89a12c.IIii_method_d1a53438().contains(var2, var3)
                     || this.I_field_2d89a12c.IiII_method_6941c18().inFlow() && this.I_field_2d89a12c.IiII_method_6941c18().contains(var2, var3)
               )
            || this.overlays.stream().anyMatch(var2x -> var2x.alive() && var2x.contains(var2, var3));
         if (!var5) {
            for (IiiIiIiii_Class216.Nested1_98f2d4a0 var7 : this.I_field_7865b31) {
               if (var7.I_method_91c66770().hovered()) {
                  var4 = var7.I_method_33d053a8().get();
                  break;
               }
            }
         }

         this.I_field_a9c1a28c.I_method_a74dc6cc(this.width / 2.0F, this.height / 2.0F - 145.0F);
         if (!var4.contains(".description")) {
            this.I_field_a9c1a28c.I_method_ceb35a49(var4);
            this.I_field_a9c1a28c.I_method_7ae26dda(var1);
         }
      }
   }

   private void I_method_7aab2760(III var1, iii_Class8 var2, ModuleCategory var3) {
      var1.drawClientRect(var2.x(), var2.y(), var2.w(), var2.h(), 1.0F, 0.0F, 3.0F, 11.0F, !this.II_field_5a);
      float var4 = 9.0F;
      float var5 = var2.x() + 8.0F;
      float var6 = var2.y() + 8.0F;
      var1.drawShadow(var5, var6, var4, var4, 11.0F, IIiii_Class8.I_method_893b2757(var4 / 2.0F), IiiiiIIIi_Class242.Iii_field_d0c8ec5);
      var1.drawIcon("category/" + var3.I_method_b23d1194().toLowerCase(), var5, var6, var4, IiiiiIIIi_Class242.ii_field_d0c8ec5);
      var1.drawText(
         IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F),
         var3.I_method_b23d1194(),
         var2.x() + 21.0F,
         var2.y() + 9.5F,
         IiiiiIIIi_Class242.iII_field_d0c8ec5
      );
      var1.drawRect(var2.x() + 1.0F, var2.y() + 24.0F, var2.w() - 2.0F, 1.0F, IiiiiIIIi_Class242.IiI_field_d0c8ec5);
      this.I_method_ff67b6df(var1, var2);
   }

   private void I_method_f4344fe1(ModuleCategory var1, ModuleEntry var2) {
      ModuleEntry[] var3 = this.III_field_a567c40b.get(var1);
      if (var3 != null && var3[0] != var2) {
         iii_Class8 var4 = this.II_field_a567c40b.get(var1);
         if (var4 != null && var3[0] == null) {
            this.Ii_field_a567c40b.put(var1, var4.Iii_method_61e30d8f());
         }

         this.iI_field_a567c40b.remove(var1);
         var3[0] = var2;
         this.I_field_bac0a97e.run();
      }
   }

   private void I_method_ff8a2a80(ModuleCategory var1) {
      ModuleEntry[] var2 = this.III_field_a567c40b.get(var1);
      if (var2 != null && var2[0] != null) {
         var2[0] = null;
         this.I_field_bac0a97e.run();
         this.i_method_151f9e60(var1);
      }
   }

   private void i_method_151f9e60(ModuleCategory var1) {
      Float var2 = this.Ii_field_a567c40b.remove(var1);
      if (var2 != null && var2 > 0.5F) {
         this.iI_field_a567c40b.put(var1, new float[]{var2, 6.0F});
      }
   }

   private void ii_method_95785142() {
      if (!this.iI_field_a567c40b.isEmpty()) {
         Iterator var1 = this.iI_field_a567c40b.entrySet().iterator();

         while (var1.hasNext()) {
            Entry var2 = (Entry)var1.next();
            iii_Class8 var3 = this.II_field_a567c40b.get(var2.getKey());
            float[] var4 = (float[])var2.getValue();
            if (var3 != null && !(var3.Iii_method_61e30d8f() >= var4[0] - 0.5F)) {
               if (--var4[1] <= 0.0F) {
                  var1.remove();
               }

               var3.i_method_a9f68681(var4[0]);
            } else {
               var1.remove();
            }
         }
      }
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   protected void afterRender(III var1) {
      this.I_method_1b224b87(var1);
      this.ii_method_95785142();
      IiiIiIiii_Class216.Nested1_8567bbc9 var2 = this.I_field_5ad2b0c6;
      if (var2 != null) {
         iiI_Class7 var3 = var2.I_field_ba11c26c != null ? this.i_field_a567c40b.get(var2.I_field_ba11c26c) : this.I_field_a567c40b.get(var2.I_field_75e36361);
         if (var3 == null) {
            if (--var2.i_field_49 <= 0) {
               this.I_field_5ad2b0c6 = null;
            }
         } else if (--var2.I_field_49 <= 0) {
            iii_Class8 var4 = this.II_field_a567c40b.get(var2.I_field_75e36361.getCategory());
            if (var4 != null) {
               if (var2.I_field_ba11c26c != null) {
                  var4.I_method_356cb059(var3, 5.0F);
               } else {
                  var4.i_method_815a851f();
               }
            }

            this.I_field_b5845eac = var3;
            this.i_field_4a = System.currentTimeMillis() + 1600L;
            this.I_field_5ad2b0c6 = null;
         }
      }
   }

   private void I_method_ff67b6df(III var1, iii_Class8 var2) {
      if (this.I_field_b5845eac != null) {
         long var3 = this.i_field_4a - System.currentTimeMillis();
         if (var3 <= 0L) {
            this.I_field_b5845eac = null;
         } else if (this.I_field_b5845eac.inFlow() && I_method_64a5a703(this.I_field_b5845eac, var2)) {
            float var5 = Math.min(1.0F, (float)var3 / 400.0F);
            float var6 = this.I_field_b5845eac.isSticky() ? 0.0F : var2.Iii_method_61e30d8f();
            float var7 = this.I_field_b5845eac.y() - var6;
            float var8 = this.I_field_b5845eac.h();
            float var9 = var2.y() + 25.0F;
            float var10 = var2.y() + var2.h() - 1.0F;
            if (var7 < var9) {
               var8 -= var9 - var7;
               var7 = var9;
            }

            if (var7 + var8 > var10) {
               var8 = var10 - var7;
            }

            if (!(var8 <= 0.0F)) {
               var1.drawRoundedRect(
                  var2.x() + 2.0F,
                  var7,
                  var2.w() - 4.0F,
                  var8,
                  IIiii_Class8.I_method_893b2757(4.0F),
                  IiiiiIIIi_Class242.ii_field_d0c8ec5.mulAlpha(0.18F * var5)
               );
            }
         }
      }
   }

   private static boolean I_method_64a5a703(iiI_Class7 var0, iiI_Class7 var1) {
      for (iiI_Class7 var2 = var0; var2 != null; var2 = var2.parent()) {
         if (var2 == var1) {
            return true;
         }
      }

      return false;
   }

   private void I_method_53804f87(iiI_Class7 var1) {
      if (!var1.shaking()) {
         var1.shake();
         if (RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class).isEnabled()) {
            iiIiIIIII_Class417.ii_field_34b2ba6c.I_method_7289b65f(1.0F, 1.0F);
         }
      }
   }

   static {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(new IiiIiIiii_Class216.Nested1_98f2d480());
   }

   static final class Nested1_8567bbc9 {
      final ModuleEntry I_field_75e36361;
      final Setting I_field_ba11c26c;
      int I_field_49 = 2;
      int i_field_49 = 40;

      Nested1_8567bbc9(ModuleEntry var1, Setting var2) {
         this.I_field_75e36361 = var1;
         this.I_field_ba11c26c = var2;
      }
   }

   static final class Nested1_8567bbe9 {
      private final iii_Class8 I_field_b584628c;
      private final Iii_Class4 I_field_b575d6ac;
      private final iii_Class8 i_field_b584628c;

      Nested1_8567bbe9(iii_Class8 var1, Iii_Class4 var2, iii_Class8 var3) {
         this.I_field_b584628c = var1;
         this.I_field_b575d6ac = var2;
         this.i_field_b584628c = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_8567bbe9[header=" + this.I_field_b584628c + ", divider=" + this.I_field_b575d6ac + ", settings=" + this.i_field_b584628c + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_b584628c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_b575d6ac);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_b584628c);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiIiIiii_Class216.Nested1_8567bbe9 other = (IiiIiIiii_Class216.Nested1_8567bbe9) var1;
         return java.util.Objects.equals(this.I_field_b584628c, other.I_field_b584628c)
            && java.util.Objects.equals(this.I_field_b575d6ac, other.I_field_b575d6ac)
            && java.util.Objects.equals(this.i_field_b584628c, other.i_field_b584628c);
      }

      public iii_Class8 I_method_70cc1827() {
         return this.I_field_b584628c;
      }

      public Iii_Class4 I_method_70bd8c47() {
         return this.I_field_b575d6ac;
      }

      public iii_Class8 i_method_f0fdf407() {
         return this.i_field_b584628c;
      }
   }

   static final class Nested1_98f2d480 {
      final IiIIIiII_Class69<HudRenderEvent> I_field_3d936f41 = var0 -> {
         IiiIiIiii_Class216 var1 = IiiIiIiii_Class216.I_field_a5e7424c;
         if (var1 != null) {
            MinecraftClient var2 = MinecraftClient.getInstance();
            if (var1.III_method_e142ca4f() >= 1.0F) {
               IiiIiIiii_Class216.I_field_a5e7424c = null;
               IiiIiIiii_Class216.Ii_field_5a = false;
               IiiIiIiii_Class216.iI_field_5a = false;
            } else if (var2.currentScreen != null) {
               IiiIiIiii_Class216.iI_field_5a = false;
            } else {
               if (!IiiIiIiii_Class216.Ii_field_5a) {
                  IiiIiIiii_Class216.I_field_cb35e4c.setClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                  IiiIiIiii_Class216.I_field_cb35e4c.I_method_53fdf4b5(true);
                  iIiiiiIii_Class380.I_field_5a = true;

                  try {
                     var1.render(III.I_method_5728d20f(var0.getContext(), -1, -1, var0.getTickDelta()));
                  } finally {
                     iIiiiiIii_Class380.I_field_5a = false;
                     IiiIiIiii_Class216.I_field_cb35e4c.i_method_766109df();
                  }

                  IiiIiIiii_Class216.Ii_field_5a = true;
               }

               if (!IiiIiIiii_Class216.iI_field_5a) {
                  IiiIiIiii_Class216.I_method_33e0a711(var0);
               }

               IiiIiIiii_Class216.iI_field_5a = false;
            }
         }
      };
      final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41 = IiIIIiII_Class69.I_method_aec3ff5f(
         Integer.MIN_VALUE,
         var0 -> {
            IiiIiIiii_Class216 var1 = IiiIiIiii_Class216.I_field_a5e7424c;
            if (var1 != null && IiiIiIiii_Class216.Ii_field_5a && var1.I_field_5bba0d50 != null) {
               MinecraftClient var2 = MinecraftClient.getInstance();
               float var3 = var1.III_method_e142ca4f();
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
               RenderSystem.setShaderTexture(0, IiiIiIiii_Class216.I_field_cb35e4c.getColorAttachment());
               Matrix4f var21 = var0.getMatrices().peek().getPositionMatrix();
               int var22 = ColorRGBA.WHITE.withAlpha(255.0F * var7).getRGB();
               BufferBuilder var23 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               var23.vertex(var21, (float)var17.x, (float)var17.y, (float)var17.z).texture(0.0F, 1.0F).color(var22);
               var23.vertex(var21, (float)var18.x, (float)var18.y, (float)var18.z).texture(0.0F, 0.0F).color(var22);
               var23.vertex(var21, (float)var19.x, (float)var19.y, (float)var19.z).texture(1.0F, 0.0F).color(var22);
               var23.vertex(var21, (float)var20.x, (float)var20.y, (float)var20.z).texture(1.0F, 1.0F).color(var22);
               BufferRenderer.drawWithGlobalProgram(var23.end());
               IiiIiIiii_Class216.iI_field_5a = true;
               RenderSystem.enableDepthTest();
               RenderSystem.enableCull();
               RenderSystem.disableBlend();
               RenderSystem.setShaderTexture(0, 0);
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               if (var3 >= 1.0F) {
                  IiiIiIiii_Class216.I_field_a5e7424c = null;
                  IiiIiIiii_Class216.Ii_field_5a = false;
               }
            }
         }
      );
   }

   static final class Nested1_98f2d4a0 {
      private final iiI_Class7 I_field_b5845eac;
      private final Supplier<String> I_field_11b14ee4;

      Nested1_98f2d4a0(iiI_Class7 var1, Supplier<String> var2) {
         this.I_field_b5845eac = var1;
         this.I_field_11b14ee4 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_98f2d4a0[view=" + this.I_field_b5845eac + ", text=" + this.I_field_11b14ee4 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_b5845eac);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_11b14ee4);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiIiIiii_Class216.Nested1_98f2d4a0 other = (IiiIiIiii_Class216.Nested1_98f2d4a0) var1;
         return java.util.Objects.equals(this.I_field_b5845eac, other.I_field_b5845eac)
            && java.util.Objects.equals(this.I_field_11b14ee4, other.I_field_11b14ee4);
      }

      public iiI_Class7 I_method_91c66770() {
         return this.I_field_b5845eac;
      }

      public Supplier<String> I_method_33d053a8() {
         return this.I_field_11b14ee4;
      }
   }
}
