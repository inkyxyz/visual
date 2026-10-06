package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.SliderSetting;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiiiiIIIi_Class242;

public abstract class IiIiIIiII_Class165 implements IIiiiIIiI_Class115, iIIiIIiIi_Class294 {
   private static final float SNAP_DIST = 2.0F;
   protected float x;
   protected float y;
   protected float width;
   protected float height;
   protected final IiiiIiIii_Class236 animation = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   protected final IiiiIiIii_Class236 visible = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   protected final IiiiIiIii_Class236 selecting = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.Ii_field_dd60aac);
   protected final IiiiIiIii_Class236 dragAnim = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
   private final IiiiIiIii_Class236 blurAnim = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
   private final IiiiIiIii_Class236 loadingAnim = new IiiiIiIii_Class236(700L, 0.0F, IiiiIiiII_Class237.IIi_field_dd60aac);
   protected boolean showing;
   protected boolean select;
   private float lastWidth;
   private boolean widthTracked;
   private List<Setting> settings = new ArrayList<>();
   protected final IiIIiIIii_Class148 inertion = new IiIIiIIii_Class148();
   protected iii_Class8 flow;
   private long lastFrame;
   private boolean dragging;
   private float dragX;
   private float dragY;
   private float startDragX;
   private float startDragY;
   protected final String name;
   protected final String icon;
   private IiIiIIiII_Class165.Nested1_6fb42420 anchorX;
   private IiIiIIiII_Class165.Nested1_6fb42420 anchorY;
   private SliderSetting scaleSetting;
   private boolean resizing;

   public IiIiIIiII_Class165(String var1, String var2) {
      this.name = var1;
      this.icon = var2;
      this.scaleSetting = new SliderSetting(this, "Scale")
         .I_method_c8c9a7d7(0.4F)
         .i_method_65e2aff7(2.5F)
         .II_method_b0f56334(0.05F)
         .Ii_method_4e0e6b54(1.0F);
   }

   public float getScale() {
      return this.scaleSetting != null ? this.scaleSetting.Ii_method_a20abcd2() : 1.0F;
   }

   public void setScale(float s) {
      if (this.scaleSetting != null) {
         this.scaleSetting.Ii_method_4e0e6b54(Math.clamp(s, 0.4F, 2.5F));
      }
   }

   public void render(III var1) {
      this.render(var1, 1.0F);
   }

   public void render(III var1, float var2) {
      this.update(var1);
      float var3 = this.animation.I_method_6ac4da6f() * this.visible.I_method_6ac4da6f();
      float var4 = var3 * var2;
      if (var4 != 0.0F) {
         float s = this.getScale();
         boolean scaled = Math.abs(s - 1.0F) > 0.001F;
         if (scaled) {
            var1.getMatrices().push();
            var1.getMatrices().translate(this.x, this.y, 0.0F);
            var1.getMatrices().scale(s, s, 1.0F);
            var1.getMatrices().translate(-this.x, -this.y, 0.0F);
         }

         float alpha = Math.min(1.0F, var4);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
         float var5 = 0.5F + var3 * 0.5F - 0.05F * this.selecting.I_method_6ac4da6f();
         iIiiiIIiI_Class371.II_method_e18635ac(var1.getMatrices(), this.x + this.width / 2.0F, this.y + this.height / 2.0F, var5);
         this.renderComponent(var1);
         iIiiiIIiI_Class371.I_method_10503b11(var1.getMatrices());
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

         if (scaled) {
            var1.getMatrices().pop();
         }

         if (MinecraftClient.getInstance().currentScreen instanceof ChatScreen && this.showing) {
            float effW = this.width * s;
            float effH = this.height * s;
            float rx = this.x + effW - 6.0F;
            float ry = this.y + effH - 6.0F;
            boolean gripHover = iIIiIIIiI_Class291.I_method_c3f86263(rx - 2.0F, ry - 2.0F, 10.0F, 10.0F, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
            ColorRGBA gripCol = gripHover ? IiiiiIIIi_Class242.i_method_5dfec6e() : ColorRGBA.WHITE.withAlpha(150.0F);
            var1.drawRoundedRect(rx, ry, 5.0F, 5.0F, IIiii_Class8.I_method_893b2757(2.0F), gripCol);
         }
      }
   }

   protected iii_Class8 build() {
      return null;
   }

   public void rebuild() {
      this.flow = null;
      this.lastFrame = 0L;
      this.widthTracked = false;
   }

   public void renderComponent(III var1) {
      if (this.flow == null) {
         this.flow = this.build();
      }

      if (this.flow != null) {
         long var2 = System.currentTimeMillis();
         float var4 = this.lastFrame == 0L ? 16.0F : Math.min(64.0F, (float)(var2 - this.lastFrame));
         this.lastFrame = var2;
         this.flow.prepareRoot();
         this.flow.snapAt(this.x, this.y);
         this.flow.tick(var4, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
         this.width = this.flow.w();
         this.height = this.flow.h();
         if (this.syncWidth()) {
            this.flow.snapAt(this.x, this.y);
            this.flow.tick(0.0F, var1.I_method_b1c3e152(), var1.i_method_b1d26d32());
         }

         this.flow.draw(var1, Math.min(1.0F, this.animation.I_method_6ac4da6f() * this.visible.I_method_6ac4da6f()));
      }
   }

   private boolean syncWidth() {
      if (!this.widthTracked) {
         if (this.width <= 0.0F) {
            return false;
         } else {
            this.lastWidth = this.width;
            this.widthTracked = true;
            return false;
         }
      } else {
         float var1 = this.width - this.lastWidth;
         this.lastWidth = this.width;
         if (var1 != 0.0F && this.anchorsRightEdge()) {
            boolean var2 = this.x + this.width / 2.0F < iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() / 2.0F;
            this.pushNeighbours(var1, var2);
            if (!var2 && !this.dragging) {
               this.x -= var1;
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   protected boolean anchorsRightEdge() {
      return true;
   }

   private void pushNeighbours(float var1, boolean var2) {
      for (IiIiIIiII_Class165 var5 : RockstarClient.getInstance().I_method_35687482().III_method_812fc188()) {
         if (var5 != this && var5.isShowing()) {
            float var6 = Math.min(this.y + this.height, var5.y + var5.height) - Math.max(this.y, var5.y);
            if (!(var6 <= 0.0F)) {
               float var7 = var2 ? var5.x - (this.x + this.width) : this.x - (var5.x + var5.width);
               if (!(var7 < -5.0F) && !(var7 > 25.0F)) {
                  var5.x += var2 ? var1 : -var1;
                  var5.x = Math.max(0.0F, Math.min(var5.x, iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() - var5.width));
               }
            }
         }
      }
   }

   public void update(III var1) {
      this.syncWidth();
      this.dragAnim.I_method_edd72835(this.dragging);
      this.animation.I_method_df2f9087(this.showing ? IiiiIiiII_Class237.I_field_dd60aac : IiiiIiiII_Class237.iI_field_dd60aac);
      this.animation.I_method_edd72835(this.showing);
      this.visible.I_method_df2f9087(this.show() ? IiiiIiiII_Class237.I_field_dd60aac : IiiiIiiII_Class237.iI_field_dd60aac);
      this.visible.I_method_edd72835(this.show());
      this.selecting.I_method_edd72835(this.select);
      this.blurAnim.I_method_edd72835(this.animation.I_method_6ac4da6f() >= 0.6F);
      if (this.resizing) {
         float mx = (float)var1.I_method_b1c3e152();
         float my = (float)var1.i_method_b1d26d32();
         float newScale = Math.max(0.4F, Math.min(2.5F, Math.max((mx - this.x) / Math.max(12.0F, this.width), (my - this.y) / Math.max(12.0F, this.height))));
         this.setScale(newScale);
      }

      if (this.dragging) {
         float var2 = Math.max(0.0F, iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() - this.width);
         float var3 = Math.max(0.0F, iIIiIIiiI_Class295.I_field_73c6d26c.i_method_805d6def() - this.height);
         this.x = Math.clamp(var1.I_method_b1c3e152() - this.dragX, 0.0F, var2);
         this.y = Math.clamp(var1.i_method_b1d26d32() - this.dragY, 0.0F, var3);
         if (!(this instanceof IiIiiIIII_Class177) && !Screen.hasControlDown()) {
            this.x = Math.clamp(this.x + this.snapDelta(IiIiIIIiI_Class163.Nested1_6dffbfe0.i_field_95b012a7, this.x, this.width), 0.0F, var2);
            this.y = Math.clamp(this.y + this.snapDelta(IiIiIIIiI_Class163.Nested1_6dffbfe0.I_field_95b012a7, this.y, this.height), 0.0F, var3);
         }
      }

      if (this.isHovered(var1) && this.animation.I_method_6ac4da6f() >= 1.0F) {
         iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
      }
   }

   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (this.isHovered(var1, var3) && this.showing) {
         if (var5 == IiIII_Class9.I_field_2f4c8d6c) {
            this.beginDrag(var1, var3);
         } else if (var5 == IiIII_Class9.i_field_2f4c8d6c) {
            this.select = true;
            this.loadingAnim.I_method_edd6dd21(0.0F);
            String title = this.name != null && !this.name.isEmpty() ? IiIiIIII_Class81.I_method_f25a980a(this.name) : "Элемент";
            IiIIiiIii_Class156 var6 = new IiIIiiIii_Class156((float)var1, (float)var3, 130.0F, 6.0F)
               .i_method_a1faeedf(title)
               .I_method_88131b75();

            if (this.scaleSetting != null) {
               var6.I_method_cbb5737d(this.scaleSetting);
            }

            for (Setting var8 : this.settings) {
               var6.I_method_cbb5737d(var8);
            }

            var6.I_method_78c7e89("Сбросить позицию", "clean", var1x -> {
               this.x = 20.0F;
               this.y = 20.0F;
               RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            });

            var6.I_method_78c7e89("Сбросить масштаб", "clean", var1x -> {
               this.setScale(1.0F);
               RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            });

            var6.I_method_78c7e89(IiIiIIII_Class81.I_method_f25a980a("remove"), "trash", var1x -> {
               this.setShowing(false);
               var1x.I_method_c3d80455(false);
               RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            }).I_method_8f5bef3(() -> {
               this.select = false;
               RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
            });
            RockstarClient.getInstance().I_method_35687482().IIi_method_367bf9a8().add(var6);
         }
      }
   }

   protected void beginDrag(double var1, double var3) {
      float s = this.getScale();
      float effW = this.width * s;
      float effH = this.height * s;
      if (var1 >= this.x + effW - 9.0F && var3 >= this.y + effH - 9.0F) {
         this.resizing = true;
         return;
      }
      this.dragging = true;
      this.dragX = (float)(var1 - this.x);
      this.dragY = (float)(var3 - this.y);
      this.startDragX = this.x;
      this.startDragY = this.y;
   }

   public void onMouseReleased(double var1, double var3, IiIII_Class9 var5) {
      if (this.resizing && var5 == IiIII_Class9.I_field_2f4c8d6c) {
         this.resizing = false;
         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
      }
      if (this.dragging && var5 == IiIII_Class9.I_field_2f4c8d6c) {
         this.dragging = false;
         this.anchorX = this.anchorY = null;
         if (this.x != this.startDragX || this.y != this.startDragY) {
            RockstarClient.getInstance().I_method_35687482().I_method_fe8673b5().I_method_1bfadd07(this, this.startDragX, this.startDragY, this.x, this.y);
         }

         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
      }
   }

   private float snapDelta(IiIiIIIiI_Class163.Nested1_6dffbfe0 var1, float var2, float var3) {
      float var4 = 0.0F;
      float var5 = 3.0F;
      float[] var6 = anchors(var2, var3);

      for (IiIiIIIiI_Class163 var8 : RockstarClient.getInstance().I_method_35687482().I_method_fe777395().I_method_18838208()) {
         if (var8.I_method_9c247570() == var1) {
            for (float var12 : var6) {
               float var13 = var8.I_method_b5673a8f() - var12;
               float var14 = Math.abs(var13);
               if (!(var14 > 2.0F) && !(var14 >= var5)) {
                  var4 = var13;
                  var5 = var14;
               }
            }
         }
      }

      if (var5 > 2.0F) {
         return 0.0F;
      } else {
         for (IiIiIIIiI_Class163 var16 : RockstarClient.getInstance().I_method_35687482().I_method_fe777395().I_method_18838208()) {
            if (var16.I_method_9c247570() == var1) {
               for (float var20 : var6) {
                  if (Math.abs(var16.I_method_b5673a8f() - var20 - var4) <= 0.001F) {
                     var16.I_method_f780cc15(true);
                     return var4;
                  }
               }
            }
         }

         return var4;
      }
   }

   private static float[] anchors(float var0, float var1) {
      return new float[]{var0, var0 + var1 * 0.5F, var0 + var1};
   }

   public boolean show() {
      return true;
   }

   public boolean isHovered(float var1, float var2) {
      float s = this.getScale();
      return iIIiIIIiI_Class291.I_method_c3f86263(this.x, this.y, this.width * s, this.height * s, var1, var2);
   }

   public boolean isHovered(double var1, double var3) {
      float s = this.getScale();
      return iIIiIIIiI_Class291.I_method_c3f86263(this.x, this.y, this.width * s, this.height * s, var1, var3);
   }

   public boolean isHovered(III var1) {
      return this.isHovered((float)var1.I_method_b1c3e152(), (float)var1.i_method_b1d26d32());
   }

   public void pos(float var1, float var2) {
      this.x = var1;
      this.y = var2;
      this.anchorX = this.anchorY = null;
   }

   public void reanchor(float var1, float var2, float var3, float var4) {
      if (!this.dragging) {
         if (this.anchorX == null) {
            this.anchorX = zoneOf(this.x, this.width, var1);
         }

         if (this.anchorY == null) {
            this.anchorY = zoneOf(this.y, this.height, var2);
         }

         this.x = reanchorAxis(this.anchorX, this.x, this.width, var1, var3);
         this.y = reanchorAxis(this.anchorY, this.y, this.height, var2, var4);
      }
   }

   private static IiIiIIiII_Class165.Nested1_6fb42420 zoneOf(float var0, float var1, float var2) {
      float var3 = var0 + var1 / 2.0F;
      float var4 = var2 / 3.0F;
      if (var3 <= var4) {
         return IiIiIIiII_Class165.Nested1_6fb42420.I_field_ca883667;
      } else {
         return var3 >= var2 - var4 ? IiIiIIiII_Class165.Nested1_6fb42420.II_field_ca883667 : IiIiIIiII_Class165.Nested1_6fb42420.i_field_ca883667;
      }
   }

   private static float reanchorAxis(IiIiIIiII_Class165.Nested1_6fb42420 var0, float var1, float var2, float var3, float var4) {
      float var5 = switch (var0) {
         case I_field_ca883667 -> var1;
         case i_field_ca883667 -> var4 / 2.0F + (var1 + var2 / 2.0F - var3 / 2.0F) - var2 / 2.0F;
         case II_field_ca883667 -> var4 - var2 - (var3 - (var1 + var2));
      };
      return Math.clamp(var5, 0.0F, Math.max(0.0F, var4 - var2));
   }

   public void setShowing(boolean var1) {
      boolean var2 = this.showing;
      this.showing = var1;
      if (var1 && !var2) {
         this.rebuild();
      }

      if (var2 != var1) {
         IiIiIIIii_Class164 var3 = RockstarClient.getInstance().I_method_35687482();
         if (var3 != null) {
            var3.I_method_11341087(this);
         }
      }
   }

   @Generated
   public float getX() {
      return this.x;
   }

   @Generated
   public float getY() {
      return this.y;
   }

   @Generated
   public float getWidth() {
      return this.width;
   }

   @Generated
   public float getHeight() {
      return this.height;
   }

   @Generated
   public IiiiIiIii_Class236 getAnimation() {
      return this.animation;
   }

   @Generated
   public IiiiIiIii_Class236 getVisible() {
      return this.visible;
   }

   @Generated
   public IiiiIiIii_Class236 getSelecting() {
      return this.selecting;
   }

   @Generated
   public IiiiIiIii_Class236 getDragAnim() {
      return this.dragAnim;
   }

   @Generated
   public IiiiIiIii_Class236 getBlurAnim() {
      return this.blurAnim;
   }

   @Generated
   public IiiiIiIii_Class236 getLoadingAnim() {
      return this.loadingAnim;
   }

   @Generated
   public boolean isShowing() {
      return this.showing;
   }

   @Generated
   public boolean isSelect() {
      return this.select;
   }

   @Generated
   public float getLastWidth() {
      return this.lastWidth;
   }

   @Generated
   public boolean isWidthTracked() {
      return this.widthTracked;
   }

   @Generated
   @Override
   public List<Setting> getSettings() {
      return this.settings;
   }

   @Generated
   public IiIIiIIii_Class148 getInertion() {
      return this.inertion;
   }

   @Generated
   public iii_Class8 getFlow() {
      return this.flow;
   }

   @Generated
   public long getLastFrame() {
      return this.lastFrame;
   }

   @Generated
   public boolean isDragging() {
      return this.dragging;
   }

   @Generated
   public float getDragX() {
      return this.dragX;
   }

   @Generated
   public float getDragY() {
      return this.dragY;
   }

   @Generated
   public float getStartDragX() {
      return this.startDragX;
   }

   @Generated
   public float getStartDragY() {
      return this.startDragY;
   }

   @Generated
   public String getName() {
      return this.name;
   }

   @Generated
   public String getIcon() {
      return this.icon;
   }

   @Generated
   public IiIiIIiII_Class165.Nested1_6fb42420 getAnchorX() {
      return this.anchorX;
   }

   @Generated
   public IiIiIIiII_Class165.Nested1_6fb42420 getAnchorY() {
      return this.anchorY;
   }

   @Generated
   public void setX(float var1) {
      this.x = var1;
   }

   @Generated
   public void setY(float var1) {
      this.y = var1;
   }

   @Generated
   public void setWidth(float var1) {
      this.width = var1;
   }

   @Generated
   public void setHeight(float var1) {
      this.height = var1;
   }

   @Generated
   public void setSelect(boolean var1) {
      this.select = var1;
   }

   @Generated
   public void setLastWidth(float var1) {
      this.lastWidth = var1;
   }

   @Generated
   public void setWidthTracked(boolean var1) {
      this.widthTracked = var1;
   }

   @Generated
   public void setSettings(List<Setting> var1) {
      this.settings = var1;
   }

   @Generated
   public void setFlow(iii_Class8 var1) {
      this.flow = var1;
   }

   @Generated
   public void setLastFrame(long var1) {
      this.lastFrame = var1;
   }

   @Generated
   public void setDragging(boolean var1) {
      this.dragging = var1;
   }

   @Generated
   public void setDragX(float var1) {
      this.dragX = var1;
   }

   @Generated
   public void setDragY(float var1) {
      this.dragY = var1;
   }

   @Generated
   public void setStartDragX(float var1) {
      this.startDragX = var1;
   }

   @Generated
   public void setStartDragY(float var1) {
      this.startDragY = var1;
   }

   @Generated
   public void setAnchorX(IiIiIIiII_Class165.Nested1_6fb42420 var1) {
      this.anchorX = var1;
   }

   @Generated
   public void setAnchorY(IiIiIIiII_Class165.Nested1_6fb42420 var1) {
      this.anchorY = var1;
   }

   static enum Nested1_6fb42420 {
      I_field_ca883667,
      i_field_ca883667,
      II_field_ca883667;
   }
}
