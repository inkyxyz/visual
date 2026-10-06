package pyrock.classes;

import java.util.Objects;
import jep.python.PyCallable;
import lombok.Generated;
import net.minecraft.text.Text;
import pyrock.ui.Node;
import pyrock.ui.Ui;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IiIIiIiI_Class75;
import rockstar.client.IiIiIIiII_Class165;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iii_Class8;

public class PyHudElement extends IiIiIIiII_Class165 {
   private final IIiiIIiii_Class104 owner;
   private PyCallable renderer;
   private PyCallable layoutBuilder;
   private PyCallable signatureFn;
   private Object lastSig;
   private PyCallable visibleWhen;
   private boolean disposed;
   private boolean errored;

   public PyHudElement(IIiiIIiii_Class104 var1, String var2, String var3, float var4, float var5, float var6, float var7) {
      super(var2, var3);
      this.owner = var1;
      this.width = Math.max(1.0F, var4);
      this.height = Math.max(1.0F, var5);
      this.pos(var6, var7);
   }

   public PyHudElement renderer(PyCallable var1) {
      this.renderer = var1;
      this.errored = false;
      this.rebuild();
      return this;
   }

   public PyHudElement render(PyCallable var1) {
      return this.renderer(var1);
   }

   public PyHudElement layout(PyCallable var1) {
      this.layoutBuilder = var1;
      this.renderer = null;
      this.errored = false;
      this.rebuild();
      return this;
   }

   public PyHudElement signature(PyCallable var1) {
      this.signatureFn = var1;
      this.lastSig = null;
      return this;
   }

   @Override
   public iii_Class8 build() {
      if (this.layoutBuilder == null) {
         return null;
      } else {
         try (AutoCloseable var1 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
            Ui var2 = new Ui();
            this.layoutBuilder.call(new Object[]{var2});
            Node var3 = var2.firstRoot();
            return var3 != null && var3.element() instanceof iii_Class8 var4 ? var4 : null;
         } catch (Throwable var8) {
            this.handleError("layout", var8);
            return null;
         }
      }
   }

   public PyHudElement visibleWhen(PyCallable var1) {
      this.visibleWhen = var1;
      this.errored = false;
      return this;
   }

   public PyHudElement size(double var1, double var3) {
      this.width = Math.max(1.0F, (float)var1);
      this.height = Math.max(1.0F, (float)var3);
      return this;
   }

   public PyHudElement width(double var1) {
      this.width = Math.max(1.0F, (float)var1);
      return this;
   }

   public PyHudElement height(double var1) {
      this.height = Math.max(1.0F, (float)var1);
      return this;
   }

   public PyHudElement position(double var1, double var3) {
      this.pos((float)var1, (float)var3);
      return this;
   }

   public PyHudElement shown(boolean var1) {
      this.setShowing(var1);
      return this;
   }

   public float renderAlpha() {
      return this.animation.I_method_6ac4da6f() * this.visible.I_method_6ac4da6f();
   }

   public float dragAlpha() {
      return this.dragAnim.I_method_6ac4da6f();
   }

   public boolean ownedBy(IIiiIIiii_Class104 var1) {
      return this.owner == var1;
   }

   public boolean remove() {
      this.dispose();
      IiIIiIiI_Class75.I_method_64a87fb6(this.getName());
      boolean var1 = RockstarClient.getInstance().I_method_35687482().III_method_812fc188().remove(this);
      if (var1) {
         RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
      }

      return var1;
   }

   public void dispose() {
      this.disposed = true;
      this.renderer = null;
      this.layoutBuilder = null;
      this.signatureFn = null;
      this.visibleWhen = null;
      this.setShowing(false);
   }

   @Override
   public boolean show() {
      if (!this.alive()) {
         return false;
      } else if (this.visibleWhen == null) {
         return true;
      } else {
         try {
            boolean var2;
            try (AutoCloseable var1 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
               var2 = truthy(this.visibleWhen.call(new Object[0]));
            }

            return var2;
         } catch (Throwable var6) {
            this.handleError("visible", var6);
            return false;
         }
      }
   }

   @Override
   public void renderComponent(III var1) {
      if (this.alive()) {
         if (this.layoutBuilder != null) {
            if (this.signatureFn != null) {
               try (AutoCloseable var11 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
                  Object var3 = this.signatureFn.call(new Object[0]);
                  if (!Objects.equals(var3, this.lastSig)) {
                     this.lastSig = var3;
                     this.rebuild();
                  }
               } catch (Throwable var8) {
                  this.handleError("signature", var8);
               }
            }

            super.renderComponent(var1);
         } else if (this.renderer == null) {
            this.renderFallback(var1);
         } else {
            try (AutoCloseable var2 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
               this.renderer.call(new Object[]{var1, this});
            } catch (Throwable var10) {
               this.handleError("render", var10);
            }
         }
      }
   }

   private boolean alive() {
      return !this.disposed && !this.errored && (this.owner == null || this.owner.II_method_b18bf526());
   }

   private void renderFallback(III var1) {
      var1.drawClientRect(this.x, this.y, this.width, this.height, this.renderAlpha(), this.dragAlpha(), 3.0F);
      IIiIIi_Class10 var2 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
      var1.drawText(var2, this.getName(), this.x + 6.0F, this.y + this.height / 2.0F - var2.I_method_a649725c() / 2.0F, IiiiiIIIi_Class242.iI_method_8e08d3b1());
   }

   private void handleError(String var1, Throwable var2) {
      if (!this.errored) {
         this.errored = true;
         this.renderer = null;
         this.visibleWhen = null;
         this.setShowing(false);
         String var3 = var2.getMessage();
         if (var3 == null || var3.isBlank()) {
            var3 = var2.getClass().getSimpleName();
         }

         int var4 = var3.indexOf(58);
         if (var4 >= 0 && var4 + 1 < var3.length()) {
            var3 = var3.substring(var4 + 1).trim();
         }

         iIIIIIIii_Class260.II_method_e8fd4864(Text.of("[Python HUD Error] " + this.getName() + " (" + var1 + "): " + var3));
         RockstarClient.I_field_ab0f6068.error("Python HUD error in '{}' during {}", new Object[]{this.getName(), var1, var2});
      }
   }

   private static boolean truthy(Object var0) {
      if (var0 == null) {
         return false;
      } else if (var0 instanceof Boolean var3) {
         return var3;
      } else if (var0 instanceof Number var2) {
         return var2.doubleValue() != 0.0;
      } else {
         return var0 instanceof CharSequence var1 ? !var1.isEmpty() : true;
      }
   }

   @Generated
   public IIiiIIiii_Class104 getOwner() {
      return this.owner;
   }

   @Generated
   public PyCallable getRenderer() {
      return this.renderer;
   }

   @Generated
   public PyCallable getLayoutBuilder() {
      return this.layoutBuilder;
   }

   @Generated
   public PyCallable getSignatureFn() {
      return this.signatureFn;
   }

   @Generated
   public Object getLastSig() {
      return this.lastSig;
   }

   @Generated
   public PyCallable getVisibleWhen() {
      return this.visibleWhen;
   }

   @Generated
   public boolean isDisposed() {
      return this.disposed;
   }

   @Generated
   public boolean isErrored() {
      return this.errored;
   }
}
