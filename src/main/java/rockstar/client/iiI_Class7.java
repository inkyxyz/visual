package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import org.lwjgl.glfw.GLFW;
import pyrock.utility.render.ColorRGBA;

public abstract class iiI_Class7 {
   protected IIii_Class4 motion = IIii_Class4.I_field_f93678c1;
   final IiI_Class3 x = new IiI_Class3(this.motion);
   final IiI_Class3 y = new IiI_Class3(this.motion);
   final IiI_Class3 w = new IiI_Class3(this.motion);
   final IiI_Class3 h = new IiI_Class3(this.motion);
   protected float prefW;
   protected float prefH;
   protected float minW = 0.0F;
   protected float minH = 0.0F;
   protected float maxW = Float.MAX_VALUE;
   protected float maxH = Float.MAX_VALUE;
   protected boolean explicitW;
   protected boolean explicitH;
   protected boolean fillW;
   protected boolean fillH;
   protected iiI_Class7 parent;
   private final IiI_Class3 hover = new IiI_Class3(0.0F, IIii_Class4.I_method_3682ece9(300L, IiiiIiiII_Class237.III_field_dd60aac));
   private final IiI_Class3 press = new IiI_Class3(0.0F, IIii_Class4.iI_field_f93678c1);
   private Map<String, IiI_Class3> signals;
   private Map<String, iiI_Class7.Nested1_b540d40> bindings;
   protected boolean interactive = true;
   private boolean modal;
   private boolean pressed;
   private IiIII_Class9 pressedButton;
   private boolean hovered;
   boolean hoverable = true;
   protected iiI_Class7.Nested1_5f2d9729 phase = iiI_Class7.Nested1_5f2d9729.i_field_56fbb866;
   final IiI_Class3 appear = new IiI_Class3(1.0F, IIii_Class4.I_method_3682ece9(240L, IiiiIiiII_Class237.IIII_field_dd60aac));
   private IiiI_Class7 enterT = IiiI_Class7.II_field_f94500c1;
   private IiiI_Class7 exitT = IiiI_Class7.II_field_f94500c1;
   private float appearDelay;
   private float pendingTarget = 1.0F;
   private boolean lifeStarted = true;
   private final IiiI_Class7.Nested1_28a19593 tweak = new IiiI_Class7.Nested1_28a19593();
   private Runnable leftClick;
   private Consumer<IiIII_Class9> buttonClick;
   private iiI_Class7.Nested1_b540d20 posClick;
   public static boolean ANY_DRAGGING = false;
   static boolean DRAW_CLIP = false;
   static float DRAW_CLIP_MIN = 0.0F;
   static float DRAW_CLIP_MAX = 0.0F;
   private iIi_Class6 dragMode = iIi_Class6.I_field_b583ea6c;
   private boolean dragging;
   private iIi_Class6 dragAxis = iIi_Class6.i_field_b583ea6c;
   private float dragStartMx;
   private float dragStartMy;
   private float dragStartX;
   private float dragStartY;
   boolean manuallyPositioned;
   private iIIIiIIIi_Class274 cursor;
   private boolean centerX;
   private boolean centerY;
   private BooleanSupplier visibleWhen;
   private boolean visInit;
   private BooleanSupplier snapPosition;
   private BooleanSupplier snapSize;
   private boolean forcedSnap;
   private boolean snappedThisFrame;
   private boolean ignoreSnap;
   private BooleanSupplier stickyWhen;
   private boolean collapse;
   private static int layoutEpoch;
   private static iiI_Class7 spotlight;
   private IiI_Class3 spotlightAnim;
   private boolean onSpotlightPath;
   private int seenEpoch;
   private float shakeLeft;
   private float shakeElapsed;
   private float shakeAmp = 1.5F;
   private float shakeDur = 450.0F;
   private float blurAmount;
   private ColorRGBA blurTint;
   private float glassAlpha = -1.0F;
   private boolean glassOutline;

   public iiI_Class7 blur(float var1) {
      this.blurAmount = Math.max(0.0F, var1);
      return this;
   }

   public iiI_Class7 blur(float var1, ColorRGBA var2) {
      this.blurTint = var2;
      return this.blur(var1);
   }

   public iiI_Class7 glass() {
      return this.glass(1.0F, true);
   }

   public iiI_Class7 glass(float var1, boolean var2) {
      this.glassAlpha = Math.max(0.0F, var1);
      this.glassOutline = var2;
      return this;
   }

   protected IIiii_Class8 shapeRadius() {
      return IIiii_Class8.I_field_2d98a52c;
   }

   protected float shapeSquircle() {
      return 0.0F;
   }

   public iiI_Class7 motion(IIii_Class4 var1) {
      this.motion = var1;
      this.x.I_method_15cf9df6(var1);
      this.y.I_method_15cf9df6(var1);
      this.w.I_method_15cf9df6(var1);
      this.h.I_method_15cf9df6(var1);
      return this;
   }

   public iiI_Class7 width(float var1) {
      this.prefW = var1;
      this.explicitW = true;
      this.w.I_method_82de4e21(this.clampW(var1));
      return this;
   }

   public iiI_Class7 height(float var1) {
      this.prefH = var1;
      this.explicitH = true;
      this.h.I_method_82de4e21(this.clampH(var1));
      return this;
   }

   public iiI_Class7 size(float var1, float var2) {
      this.width(var1);
      this.height(var2);
      return this;
   }

   public iiI_Class7 minSize(float var1, float var2) {
      this.minW = var1;
      this.minH = var2;
      return this;
   }

   public iiI_Class7 maxSize(float var1, float var2) {
      this.maxW = var1;
      this.maxH = var2;
      return this;
   }

   public iiI_Class7 minWidth(float var1) {
      this.minW = var1;
      return this;
   }

   public iiI_Class7 minHeight(float var1) {
      this.minH = var1;
      return this;
   }

   public iiI_Class7 fillWidth() {
      this.fillW = true;
      return this;
   }

   public iiI_Class7 fillHeight() {
      this.fillH = true;
      return this;
   }

   public iiI_Class7 fill() {
      this.fillW = this.fillH = true;
      return this;
   }

   public iiI_Class7 at(float var1, float var2) {
      this.x.I_method_82de4e21(var1);
      this.y.I_method_82de4e21(var2);
      return this;
   }

   public iiI_Class7 snapAt(float var1, float var2) {
      this.x.i_method_84a13e41(var1);
      this.y.i_method_84a13e41(var2);
      return this;
   }

   public iiI_Class7 snapToSize(float var1, float var2) {
      this.prefW = var1;
      this.explicitW = true;
      this.w.i_method_84a13e41(this.clampW(var1));
      this.prefH = var2;
      this.explicitH = true;
      this.h.i_method_84a13e41(this.clampH(var2));
      return this;
   }

   final void rideWith(float var1, float var2) {
      if (!this.ignoreSnap) {
         this.x.II_method_daaf423e(var1);
         this.y.II_method_daaf423e(var2);
      }
   }

   public iiI_Class7 enter(IiiI_Class7 var1) {
      this.enterT = var1;
      return this;
   }

   public iiI_Class7 exit(IiiI_Class7 var1) {
      this.exitT = var1;
      return this;
   }

   public iiI_Class7 transition(IiiI_Class7 var1) {
      this.enterT = var1;
      this.exitT = var1;
      return this;
   }

   public iiI_Class7 lifeMotion(IIii_Class4 var1) {
      this.appear.I_method_15cf9df6(var1);
      return this;
   }

   public iiI_Class7 onClick(Runnable var1) {
      this.leftClick = var1;
      return this;
   }

   public iiI_Class7 onClick(Consumer<IiIII_Class9> var1) {
      this.buttonClick = var1;
      return this;
   }

   public iiI_Class7 onClick(iiI_Class7.Nested1_b540d20 var1) {
      this.posClick = var1;
      return this;
   }

   public iiI_Class7 interactive(boolean var1) {
      this.interactive = var1;
      return this;
   }

   public iiI_Class7 modal() {
      this.modal = true;
      return this;
   }

   boolean isModal() {
      return this.modal;
   }

   public iiI_Class7 draggable(iIi_Class6 var1) {
      this.dragMode = var1 == null ? iIi_Class6.I_field_b583ea6c : var1;
      return this;
   }

   public iiI_Class7 draggable(boolean var1) {
      this.dragMode = var1 ? iIi_Class6.i_field_b583ea6c : iIi_Class6.I_field_b583ea6c;
      return this;
   }

   public iiI_Class7 cursor(iIIIiIIIi_Class274 var1) {
      this.cursor = var1;
      return this;
   }

   public iiI_Class7 hoverMotion(IIii_Class4 var1) {
      if (var1 != null) {
         this.hover.I_method_15cf9df6(var1);
      }

      return this;
   }

   public iiI_Class7 center() {
      this.centerX = this.centerY = true;
      return this;
   }

   public iiI_Class7 centerX() {
      this.centerX = true;
      return this;
   }

   public iiI_Class7 centerY() {
      this.centerY = true;
      return this;
   }

   public iiI_Class7 manuallyPositioned(boolean var1) {
      this.manuallyPositioned = var1;
      return this;
   }

   public boolean isManuallyPositioned() {
      return this.manuallyPositioned;
   }

   public iiI_Class7 visibleWhen(BooleanSupplier var1) {
      this.visibleWhen = var1;
      return this;
   }

   public iiI_Class7 visibleWhen(BooleanSupplier var1, IIii_Class4 var2) {
      this.visibleWhen = var1;
      if (var2 != null) {
         this.appear.I_method_15cf9df6(var2);
      }

      return this;
   }

   public iiI_Class7 visibleWhen(BooleanSupplier var1, IiiiIiiII_Class237 var2, long var3) {
      return this.visibleWhen(var1, IIii_Class4.I_method_3682ece9(var3, var2));
   }

   public iiI_Class7 snapPosition(BooleanSupplier var1) {
      this.snapPosition = var1;
      return this;
   }

   public iiI_Class7 snapPosition() {
      this.snapPosition = () -> true;
      return this;
   }

   public iiI_Class7 animatePosition() {
      this.ignoreSnap = true;
      return this;
   }

   public iiI_Class7 snapSize(BooleanSupplier var1) {
      this.snapSize = var1;
      return this;
   }

   public iiI_Class7 snapSize() {
      this.snapSize = () -> true;
      return this;
   }

   public iiI_Class7 sticky(BooleanSupplier var1) {
      this.stickyWhen = var1;
      return this;
   }

   public iiI_Class7 sticky() {
      this.stickyWhen = () -> true;
      return this;
   }

   public iiI_Class7 collapse() {
      this.collapse = true;
      return this;
   }

   public iiI_Class7 collapse(boolean var1) {
      this.collapse = var1;
      return this;
   }

   public iiI_Class7 shakeConfig(float var1, float var2) {
      this.shakeAmp = var1;
      this.shakeDur = Math.max(1.0F, var2);
      return this;
   }

   public void shake() {
      this.shakeLeft = this.shakeDur;
      this.shakeElapsed = 0.0F;
   }

   public boolean shaking() {
      return this.shakeLeft > 0.0F;
   }

   public float shakeAmount() {
      return this.shakeLeft > 0.0F ? this.shakeLeft / this.shakeDur : 0.0F;
   }

   public iiI_Class7 bind(String var1, BooleanSupplier var2) {
      return this.bind(var1, () -> var2.getAsBoolean() ? 1.0F : 0.0F);
   }

   public iiI_Class7 bind(String var1, iiI_Class7.Nested1_b540d40 var2) {
      if (this.bindings == null) {
         this.bindings = new HashMap<>();
      }

      this.bindings.put(var1, var2);
      this.signal(var1);
      return this;
   }

   public iiI_Class7 bind(String var1, BooleanSupplier var2, IIii_Class4 var3) {
      return this.bind(var1, () -> var2.getAsBoolean() ? 1.0F : 0.0F, var3);
   }

   public iiI_Class7 bind(String var1, iiI_Class7.Nested1_b540d40 var2, IIii_Class4 var3) {
      this.bind(var1, var2);
      this.signalMotion(var1, var3);
      return this;
   }

   public iiI_Class7 bind(String var1, BooleanSupplier var2, long var3) {
      return this.bind(var1, () -> var2.getAsBoolean() ? 1.0F : 0.0F, var3);
   }

   public iiI_Class7 bind(String var1, iiI_Class7.Nested1_b540d40 var2, long var3) {
      this.bind(var1, var2);
      this.signalMotion(var1, IIii_Class4.I_method_48883e1f(var3));
      return this;
   }

   public iiI_Class7 signalMotion(String var1, IIii_Class4 var2) {
      if (var2 != null) {
         this.signal(var1).I_method_15cf9df6(var2);
      }

      return this;
   }

   public float hover() {
      return this.hover.I_method_4e8b496f();
   }

   public boolean hovered() {
      return this.hovered;
   }

   public float press() {
      return this.press.I_method_4e8b496f();
   }

   public float appear() {
      return this.appear.I_method_4e8b496f();
   }

   public boolean dragging() {
      return this.dragging;
   }

   public boolean pressed() {
      return this.pressed;
   }

   public float sig(String var1) {
      IiI_Class3 var2 = this.signals == null ? null : this.signals.get(var1);
      return var2 == null ? 0.0F : var2.I_method_4e8b496f();
   }

   public float sig(String var1, IiiiIiiII_Class237 var2) {
      float var3 = this.sig(var1);
      return var2 == null ? var3 : var2.ease(var3, 0.0F, 1.0F, 1.0F);
   }

   public IiI_Class3 signal(String var1) {
      if (this.signals == null) {
         this.signals = new HashMap<>();
      }

      return this.signals.computeIfAbsent(var1, var0 -> new IiI_Class3(0.0F, IIii_Class4.iI_field_f93678c1));
   }

   public float x() {
      return this.x.I_method_4e8b496f();
   }

   public float y() {
      return this.y.I_method_4e8b496f();
   }

   public float w() {
      return this.w.I_method_4e8b496f();
   }

   public float h() {
      return this.h.I_method_4e8b496f();
   }

   public iiI_Class7 parent() {
      return this.parent;
   }

   public iiI_Class7.Nested1_5f2d9729 phase() {
      return this.phase;
   }

   public boolean alive() {
      return this.phase != iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866;
   }

   public void close() {
      this.pressed = false;
      this.pressedButton = null;
      if (this.dragging) {
         this.dragging = false;
         ANY_DRAGGING = false;
      }

      this.beginExit(0.0F);
   }

   public void discard() {
      this.phase = iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866;
      this.appear.i_method_84a13e41(0.0F);
      this.pressed = false;
      this.pressedButton = null;
      this.hovered = false;
      this.spotlightAnim = null;
      this.onSpotlightPath = false;
      if (spotlight == this) {
         spotlight = null;
      }

      if (this.dragging) {
         this.dragging = false;
         ANY_DRAGGING = false;
      }
   }

   public float life() {
      float var1 = this.appear.I_method_4e8b496f();
      return var1 < 0.0F ? 0.0F : (var1 > 1.0F ? 1.0F : var1);
   }

   public boolean inFlow() {
      if (this.phase == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866 || this.phase == iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
         return false;
      } else {
         return this.phase == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866 ? this.collapse : true;
      }
   }

   protected float clampW(float var1) {
      return Math.max(this.minW, Math.min(this.maxW, var1));
   }

   protected float clampH(float var1) {
      return Math.max(this.minH, Math.min(this.maxH, var1));
   }

   protected float collapseScale() {
      if (!this.collapse) {
         return 1.0F;
      } else {
         float var1 = this.appear.I_method_4e8b496f();
         return var1 < 0.0F ? 0.0F : (var1 > 1.0F ? 1.0F : var1);
      }
   }

   protected float rawDesiredH() {
      return this.clampH(this.prefH);
   }

   public float desiredW() {
      return this.clampW(this.prefW);
   }

   public float desiredH() {
      return this.rawDesiredH() * this.collapseScale();
   }

   public void setSlot(float var1, float var2, float var3, float var4) {
      boolean var5 = this.epochSnap();
      boolean var6 = var5 || !this.ignoreSnap && (this.forcedSnap || this.snapPosition != null && this.snapPosition.getAsBoolean());
      this.forcedSnap = false;
      this.snappedThisFrame = var6;
      if (var6) {
         this.x.i_method_84a13e41(var1);
         this.y.i_method_84a13e41(var2);
      } else {
         this.x.I_method_82de4e21(var1);
         this.y.I_method_82de4e21(var2);
      }

      boolean var7 = var5 || this.snapSize != null && this.snapSize.getAsBoolean();
      if (var7) {
         this.w.i_method_84a13e41(this.clampW(var3));
      } else {
         this.w.I_method_82de4e21(this.clampW(var3));
      }

      if (!this.collapse || this.phase != iiI_Class7.Nested1_5f2d9729.I_field_56fbb866 && this.phase != iiI_Class7.Nested1_5f2d9729.II_field_56fbb866) {
         if (var7) {
            this.h.i_method_84a13e41(this.clampH(var4));
         } else {
            this.h.I_method_82de4e21(this.clampH(var4));
         }
      } else {
         this.h.i_method_84a13e41(this.rawDesiredH());
      }
   }

   boolean snappedThisFrame() {
      return this.snappedThisFrame;
   }

   void forceSnap() {
      this.forcedSnap = true;
   }

   public void snapSubtree() {
      this.forceSnap();
   }

   public static void invalidateLayout() {
      layoutEpoch++;
   }

   public static void spotlight(iiI_Class7 var0) {
      if (spotlight != var0) {
         iiI_Class7 var1 = spotlight;
         spotlight = var0;
         if (var1 != null) {
            var1.spotlightAnim().I_method_82de4e21(0.0F);
         }

         if (var0 != null) {
            var0.spotlightAnim().I_method_82de4e21(1.0F);

            for (iiI_Class7 var2 = var0; var2 != null; var2 = var2.parent) {
               var2.onSpotlightPath = true;
            }
         }
      }
   }

   public static iiI_Class7 spotlight() {
      return spotlight;
   }

   private IiI_Class3 spotlightAnim() {
      if (this.spotlightAnim == null) {
         this.spotlightAnim = new IiI_Class3(0.0F, IIii_Class4.I_method_3682ece9(200L, IiiiIiiII_Class237.IIii_field_dd60aac));
      }

      return this.spotlightAnim;
   }

   public float spotlightAmount() {
      if (this.spotlightAnim == null) {
         return 0.0F;
      } else {
         float var1 = this.spotlightAnim.I_method_4e8b496f();
         return var1 < 0.0F ? 0.0F : (var1 > 1.0F ? 1.0F : var1);
      }
   }

   private void stepSpotlight(float var1) {
      if (this.spotlightAnim != null) {
         this.spotlightAnim.Ii_method_dc72325e(var1);
         if (this != spotlight && !(this.spotlightAnim.I_method_4e8b496f() > 0.002F)) {
            this.spotlightAnim = null;

            for (iiI_Class7 var2 = this; var2 != null; var2 = var2.parent) {
               var2.onSpotlightPath = false;
            }

            for (iiI_Class7 var3 = spotlight; var3 != null; var3 = var3.parent) {
               var3.onSpotlightPath = true;
            }
         }
      }
   }

   protected final boolean epochSnap() {
      return this.seenEpoch != layoutEpoch;
   }

   public boolean isSticky() {
      return this.stickyWhen != null && this.stickyWhen.getAsBoolean();
   }

   protected void measure() {
   }

   final void primeSize() {
      if (!this.w.I_field_5a) {
         this.w.i_method_84a13e41(this.clampW(this.desiredW()));
      }

      if (!this.h.I_field_5a) {
         this.h.i_method_84a13e41(this.clampH(this.desiredH()));
      }
   }

   public final void prepareRoot() {
      this.measure();
      this.primeSize();
   }

   final void centerWithin(float var1, float var2) {
      if (!this.manuallyPositioned) {
         boolean var3 = this.epochSnap();
         if (this.centerX) {
            float var4 = (var1 - this.desiredW()) / 2.0F;
            if (var3) {
               this.x.i_method_84a13e41(var4);
            } else {
               this.x.I_method_82de4e21(var4);
            }
         }

         if (this.centerY) {
            float var5 = (var2 - this.desiredH()) / 2.0F;
            if (var3) {
               this.y.i_method_84a13e41(var5);
            } else {
               this.y.I_method_82de4e21(var5);
            }
         }
      }
   }

   public void beginEnter(float var1) {
      this.phase = iiI_Class7.Nested1_5f2d9729.I_field_56fbb866;
      this.appear.i_method_84a13e41(0.0F);
      this.appearDelay = Math.max(0.0F, var1);
      this.pendingTarget = 1.0F;
      this.lifeStarted = var1 <= 0.0F;
      if (this.lifeStarted) {
         this.appear.I_method_82de4e21(1.0F);
      }

      this.forceSnap();
   }

   public void beginExit(float var1) {
      this.phase = iiI_Class7.Nested1_5f2d9729.II_field_56fbb866;
      this.appearDelay = Math.max(0.0F, var1);
      this.pendingTarget = 0.0F;
      this.lifeStarted = var1 <= 0.0F;
      if (this.lifeStarted) {
         this.appear.I_method_82de4e21(0.0F);
      }
   }

   private void advanceLife(float var1) {
      if (!this.lifeStarted) {
         this.appearDelay -= var1;
         if (this.appearDelay <= 0.0F) {
            this.lifeStarted = true;
            this.appear.I_method_82de4e21(this.pendingTarget);
         }
      }

      if (this.phase == iiI_Class7.Nested1_5f2d9729.I_field_56fbb866 && this.appear.I_method_4e8b496f() >= 0.999F) {
         this.phase = iiI_Class7.Nested1_5f2d9729.i_field_56fbb866;
      }

      if (this.phase == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866 && this.lifeStarted && this.appear.I_method_4e8b496f() <= 0.001F) {
         this.phase = this.visibleWhen != null ? iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866 : iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866;
      }
   }

   private void applyVisibility() {
      boolean var1 = this.visibleWhen.getAsBoolean();
      if (!this.visInit) {
         this.visInit = true;
         if (!var1) {
            this.phase = iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866;
            this.appear.i_method_84a13e41(0.0F);
         }
      } else {
         boolean var2 = this.phase == iiI_Class7.Nested1_5f2d9729.I_field_56fbb866 || this.phase == iiI_Class7.Nested1_5f2d9729.i_field_56fbb866;
         if (var1 && !var2) {
            this.beginEnter(0.0F);
         } else if (!var1 && var2) {
            this.beginExit(0.0F);
         }
      }
   }

   public final void tick(float var1, float var2, float var3) {
      this.dropLostPress(var2, var3);
      if (this.visibleWhen != null) {
         this.applyVisibility();
      }

      if (this.dragging) {
         this.applyDrag(var2, var3);
      }

      this.hovered = this.hoverable && this.interactive && this.inFlow() && this.contains(var2, var3);
      this.hover.I_method_82de4e21(this.hovered ? 1.0F : 0.0F);
      this.press.I_method_82de4e21(this.pressed && this.hovered ? 1.0F : 0.0F);
      if (this.hovered && this.cursor != null) {
         iIIIiIIiI_Class275.I_method_e7d43867(this.cursor);
      }

      if (this.bindings != null) {
         for (Entry var5 : this.bindings.entrySet()) {
            this.signal((String)var5.getKey()).I_method_82de4e21(((iiI_Class7.Nested1_b540d40)var5.getValue()).get());
         }
      }

      this.advanceLife(var1);
      this.x.Ii_method_dc72325e(var1);
      this.y.Ii_method_dc72325e(var1);
      this.w.Ii_method_dc72325e(var1);
      this.h.Ii_method_dc72325e(var1);
      this.hover.Ii_method_dc72325e(var1);
      this.press.Ii_method_dc72325e(var1);
      this.appear.Ii_method_dc72325e(var1);
      this.stepSpotlight(var1);
      if (this.signals != null) {
         for (IiI_Class3 var7 : this.signals.values()) {
            var7.Ii_method_dc72325e(var1);
         }
      }

      if (this.shakeLeft > 0.0F) {
         this.shakeLeft -= var1;
         this.shakeElapsed += var1;
      }

      this.onTick(var1, var2, var3);
      this.seenEpoch = layoutEpoch;
      this.hoverable = true;
   }

   protected void onTick(float var1, float var2, float var3) {
   }

   public final void draw(III var1, float var2) {
      this.tweak.I_method_5395f207();
      IiiI_Class7 var3 = this.phase == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866 ? this.exitT : this.enterT;
      if (var3 != null) {
         var3.apply(this.appear.I_method_4e8b496f(), this, this.tweak);
      }

      float var4 = this.spotlightAmount();
      float var5 = (var2 + (1.0F - var2) * var4) * this.tweak.I_field_46;
      if (!(var5 <= 0.003F) || this.onSpotlightPath) {
         if (DRAW_CLIP) {
            float var6 = this.y.I_method_4e8b496f();
            if (var6 + this.h.I_method_4e8b496f() < DRAW_CLIP_MIN || var6 > DRAW_CLIP_MAX) {
               return;
            }
         }

         MatrixStack var13 = var1.getMatrices();
         boolean var7 = this.collapse && this.appear.I_method_4e8b496f() < 0.999F;
         if (var7) {
            iIiiiIiII_Class373.I_method_d5a5ee51(
               var13, this.x.I_method_4e8b496f(), this.y.I_method_4e8b496f(), this.w.I_method_4e8b496f(), Math.max(0.0F, this.desiredH())
            );
         }

         float var8 = var7 ? (1.0F - this.collapseScale()) * this.h.I_method_4e8b496f() : 0.0F;
         float var9 = 0.0F;
         if (this.shakeLeft > 0.0F) {
            var9 = (float)Math.sin(this.shakeElapsed * 0.05F) * this.shakeAmp * (this.shakeLeft / this.shakeDur);
         }

         boolean var10 = this.tweak.i_field_46 != 0.0F || this.tweak.II_field_46 != 0.0F || this.tweak.Ii_field_46 != 1.0F || var8 != 0.0F || var9 != 0.0F;
         if (var10) {
            var13.push();
            if (var9 != 0.0F) {
               var13.translate(var9, 0.0F, 0.0F);
            }

            if (this.tweak.i_field_46 != 0.0F || this.tweak.II_field_46 != 0.0F) {
               var13.translate(this.tweak.i_field_46, this.tweak.II_field_46, 0.0F);
            }

            if (var8 != 0.0F) {
               var13.translate(0.0F, -var8, 0.0F);
            }

            if (this.tweak.Ii_field_46 != 1.0F) {
               float var11 = this.x.I_method_4e8b496f() + this.w.I_method_4e8b496f() / 2.0F;
               float var12 = this.y.I_method_4e8b496f() + this.h.I_method_4e8b496f() / 2.0F;
               var13.translate(var11, var12, 0.0F);
               var13.scale(this.tweak.Ii_field_46, this.tweak.Ii_field_46, 1.0F);
               var13.translate(-var11, -var12, 0.0F);
            }
         }

         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var5);
         if (var4 > 0.0F) {
            this.drawSpotlightBackdrop(var1, (1.0F - var2) * var4);
         }

         if (this.blurAmount > 0.0F || this.glassAlpha >= 0.0F) {
            this.drawBackdrop(var1);
         }

         this.drawSelf(var1, var5);
         this.drawChildren(var1, var5);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var2);
         if (var10) {
            var13.pop();
         }

         if (var7) {
            iIiiiIiII_Class373.I_method_ff80a1df();
         }
      }
   }

   private void drawBackdrop(III var1) {
      float var2 = this.x.I_method_4e8b496f();
      float var3 = this.y.I_method_4e8b496f();
      float var4 = this.w.I_method_4e8b496f();
      float var5 = this.h.I_method_4e8b496f();
      if (!(var4 <= 0.0F) && !(var5 <= 0.0F)) {
         IIiii_Class8 var6 = this.shapeRadius();
         float var7 = this.shapeSquircle();
         if (this.glassAlpha >= 0.0F) {
            var1.drawClientRect(var2, var3, var4, var5, this.glassAlpha, 0.0F, var7, var6.I_method_b483cecf(), this.glassOutline);
         } else {
            ColorRGBA var8 = this.blurTint == null ? ColorRGBA.WHITE : this.blurTint;
            if (var7 > 0.0F) {
               var1.drawBlurredRect(var2, var3, var4, var5, this.blurAmount, var7, var6, var8);
            } else {
               var1.drawBlurredRect(var2, var3, var4, var5, this.blurAmount, var6, var8);
            }
         }
      }
   }

   protected float backdropRadius() {
      return 0.0F;
   }

   private void drawSpotlightBackdrop(III var1, float var2) {
      if (!(var2 <= 0.01F)) {
         float var3 = this.x.I_method_4e8b496f();
         float var4 = this.y.I_method_4e8b496f();
         float var5 = this.w.I_method_4e8b496f();
         float var6 = this.h.I_method_4e8b496f();
         if (!(var5 <= 0.0F) && !(var6 <= 0.0F)) {
            float var7 = this.backdropRadius();
            float var8 = Math.min(var7 > 0.0F ? var7 : 7.0F, Math.min(var5, var6) / 2.0F);
            var1.drawSquircle(
               var3, var4, var5, var6, 3.0F, IIiii_Class8.I_method_893b2757(var8), IiiiiIIIi_Class242.II_method_190e6391().mulAlpha(0.85F * var2)
            );
         }
      }
   }

   protected void drawSelf(III var1, float var2) {
   }

   protected void drawChildren(III var1, float var2) {
   }

   public boolean contains(float var1, float var2) {
      float var3 = this.x.I_method_4e8b496f();
      float var4 = this.y.I_method_4e8b496f();
      float var5 = this.h.I_method_4e8b496f();
      if (this.collapse && this.appear.I_method_4e8b496f() < 0.999F) {
         var5 = Math.max(0.0F, this.desiredH());
      }

      return var1 >= var3 && var1 <= var3 + this.w.I_method_4e8b496f() && var2 >= var4 && var2 <= var4 + var5;
   }

   private iiI_Class7 dragRoot() {
      iiI_Class7 var1 = this;

      while (var1.parent != null) {
         var1 = var1.parent;
      }

      return var1;
   }

   private void applyDrag(float var1, float var2) {
      if (this.dragAxis == iIi_Class6.i_field_b583ea6c || this.dragAxis == iIi_Class6.II_field_b583ea6c) {
         this.x.i_method_84a13e41(this.dragStartX + var1 - this.dragStartMx);
      }

      if (this.dragAxis == iIi_Class6.i_field_b583ea6c || this.dragAxis == iIi_Class6.Ii_field_b583ea6c) {
         this.y.i_method_84a13e41(this.dragStartY + var2 - this.dragStartMy);
      }
   }

   public boolean mouseClicked(float var1, float var2, IiIII_Class9 var3) {
      if (this.interactive && this.inFlow() && this.contains(var1, var2)) {
         iiii_Class16.I_method_b289539a(this);
         boolean var4 = this.dragMode != iIi_Class6.I_field_b583ea6c && var3 == IiIII_Class9.I_field_2f4c8d6c;
         if (var4) {
            iiI_Class7 var5 = this.dragRoot();
            var5.dragging = true;
            var5.dragAxis = this.dragMode;
            var5.dragStartMx = var1;
            var5.dragStartMy = var2;
            var5.dragStartX = var5.x.I_method_4e8b496f();
            var5.dragStartY = var5.y.I_method_4e8b496f();
            var5.manuallyPositioned = true;
            ANY_DRAGGING = true;
         }

         this.pressed = true;
         this.pressedButton = var3;

         try {
            if (var3 == IiIII_Class9.I_field_2f4c8d6c && this.leftClick != null) {
               this.leftClick.run();
            }

            if (this.buttonClick != null) {
               this.buttonClick.accept(var3);
            }

            if (this.posClick != null) {
               this.posClick.onClick(var3, var1, var2);
            }
         } catch (Throwable var6) {
            RockstarClient.I_field_ab0f6068.error("[ui] click handler failed on {}", this.getClass().getSimpleName(), var6);
         }

         return var4 || this.leftClick != null || this.buttonClick != null || this.posClick != null;
      } else {
         return false;
      }
   }

   public void mouseReleased(float var1, float var2, IiIII_Class9 var3) {
      this.pressed = false;
      this.pressedButton = null;
      if (this.dragging) {
         this.dragging = false;
         ANY_DRAGGING = false;
      }
   }

   private void dropLostPress(float var1, float var2) {
      IiIII_Class9 var3 = this.pressed ? this.pressedButton : (this.dragging ? IiIII_Class9.I_field_2f4c8d6c : null);
      if (var3 != null) {
         long var4 = MinecraftClient.getInstance().getWindow().getHandle();
         if (GLFW.glfwGetMouseButton(var4, var3.I_method_6d899712()) != 1) {
            this.mouseReleased(var1, var2, var3);
         }
      }
   }

   public boolean mouseScrolled(float var1, float var2, float var3, float var4) {
      return false;
   }

   public boolean keyPressed(int var1, int var2, int var3) {
      return false;
   }

   public boolean keyReleased(int var1, int var2, int var3) {
      return false;
   }

   public boolean charTyped(char var1, int var2) {
      return false;
   }

   public static enum Nested1_5f2d9729 {
      I_field_56fbb866,
      i_field_56fbb866,
      II_field_56fbb866,
      Ii_field_56fbb866,
      iI_field_56fbb866;
   }

   public interface Nested1_b540d20 {
      void onClick(IiIII_Class9 var1, float var2, float var3);
   }

   public interface Nested1_b540d40 {
      float get();
   }
}
