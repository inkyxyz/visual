package rockstar.client;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.util.Identifier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIII;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIi_Class2;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiiI_Class7;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIi_Class6;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iiI_Class7;

public class Iii_Class4
extends iiI_Class7 {
    private Function<Iii_Class4, ColorRGBA> bg;
    private IIiii_Class8 radius = IIiii_Class8.I_field_2d98a52c;
    private float squircle = 0.0f;
    private IIII padding = IIII.I_field_f935fcc1;
    private float borderWidth = 0.0f;
    private Function<Iii_Class4, ColorRGBA> border;
    private Supplier<String> text;
    private IIiIIi_Class10 font;
    private Function<Iii_Class4, ColorRGBA> textColor;
    private IIi_Class2 textAlign = IIi_Class2.I_field_b5755e8c;
    private float textInset = 0.0f;
    private boolean textFade = false;
    private float marqueeOffset = 0.0f;
    private boolean marqueeForward = true;
    private float marqueeHold = 0.0f;
    private ColorRGBA shadowColor;
    private float shadowOffX;
    private float shadowOffY;
    private float shadowBlur;
    private String iconName;
    private float iconSize = 0.0f;
    private Function<Iii_Class4, ColorRGBA> iconColor;
    private Identifier image;
    private float imageSize = 0.0f;
    private float imageRadius = 0.0f;
    private Function<Iii_Class4, ColorRGBA> imageColor;
    private Nested1_9919520 painter;

    public Iii_Class4 background(Function<Iii_Class4, ColorRGBA> function) {
        this.bg = function;
        return this;
    }

    public Iii_Class4 background(ColorRGBA colorRGBA) {
        this.bg = iii_Class4 -> colorRGBA;
        return this;
    }

    public Iii_Class4 radius(float f) {
        this.radius = IIiii_Class8.I_method_893b2757(f);
        return this;
    }

    public Iii_Class4 radius(IIiii_Class8 iIiii_Class8) {
        this.radius = iIiii_Class8 == null ? IIiii_Class8.I_field_2d98a52c : iIiii_Class8;
        return this;
    }

    public Iii_Class4 squircle(float f) {
        this.squircle = f;
        return this;
    }

    @Override
    protected float backdropRadius() {
        return this.radius.I_method_b483cecf();
    }

    @Override
    protected IIiii_Class8 shapeRadius() {
        return this.radius;
    }

    @Override
    protected float shapeSquircle() {
        return this.squircle;
    }

    @Override
    public Iii_Class4 blur(float f) {
        super.blur(f);
        return this;
    }

    @Override
    public Iii_Class4 blur(float f, ColorRGBA colorRGBA) {
        super.blur(f, colorRGBA);
        return this;
    }

    @Override
    public Iii_Class4 glass() {
        super.glass();
        return this;
    }

    @Override
    public Iii_Class4 glass(float f, boolean bl) {
        super.glass(f, bl);
        return this;
    }

    public Iii_Class4 border(float f, Function<Iii_Class4, ColorRGBA> function) {
        this.borderWidth = f;
        this.border = function;
        return this;
    }

    public Iii_Class4 border(float f, ColorRGBA colorRGBA) {
        this.borderWidth = f;
        this.border = iii_Class4 -> colorRGBA;
        return this;
    }

    public Iii_Class4 padding(IIII iIII) {
        this.padding = iIII == null ? IIII.I_field_f935fcc1 : iIII;
        return this;
    }

    public Iii_Class4 padding(float f) {
        this.padding = IIII.I_method_14640aa3(f);
        return this;
    }

    public Iii_Class4 padding(float f, float f2) {
        this.padding = IIII.I_method_b1e865cb(f, f2);
        return this;
    }

    public Iii_Class4 text(IIiIIi_Class10 iIiIIi_Class10, String string, Function<Iii_Class4, ColorRGBA> function) {
        this.font = iIiIIi_Class10;
        this.text = () -> string;
        this.textColor = function;
        return this;
    }

    public Iii_Class4 text(IIiIIi_Class10 iIiIIi_Class10, Supplier<String> supplier, Function<Iii_Class4, ColorRGBA> function) {
        this.font = iIiIIi_Class10;
        this.text = supplier;
        this.textColor = function;
        return this;
    }

    public Iii_Class4 text(IIiIIi_Class10 iIiIIi_Class10, String string, ColorRGBA colorRGBA) {
        return this.text(iIiIIi_Class10, string, (Iii_Class4 iii_Class4) -> colorRGBA);
    }

    public Iii_Class4 textAlign(IIi_Class2 iRockstarClient) {
        this.textAlign = iRockstarClient;
        return this;
    }

    public Iii_Class4 textInset(float f) {
        this.textInset = f;
        return this;
    }

    public Iii_Class4 fade() {
        this.textFade = true;
        return this;
    }

    public Iii_Class4 fade(boolean bl) {
        this.textFade = bl;
        return this;
    }

    public Iii_Class4 textShadow(ColorRGBA colorRGBA, float f, float f2, float f3) {
        this.shadowColor = colorRGBA;
        this.shadowOffX = f;
        this.shadowOffY = f2;
        this.shadowBlur = f3;
        return this;
    }

    public Iii_Class4 icon(String string, float f, Function<Iii_Class4, ColorRGBA> function) {
        this.iconName = string;
        this.iconSize = f;
        this.iconColor = function;
        return this;
    }

    public Iii_Class4 icon(String string, float f, ColorRGBA colorRGBA) {
        return this.icon(string, f, (Iii_Class4 iii_Class4) -> colorRGBA);
    }

    public Iii_Class4 image(Identifier identifier, float f, float f2, Function<Iii_Class4, ColorRGBA> function) {
        this.image = identifier;
        this.imageSize = f;
        this.imageRadius = f2;
        this.imageColor = function;
        return this;
    }

    public Iii_Class4 image(Identifier identifier, float f, float f2, ColorRGBA colorRGBA) {
        return this.image(identifier, f, f2, (Iii_Class4 iii_Class4) -> colorRGBA);
    }

    public Iii_Class4 paint(Nested1_9919520 nested1_9919520) {
        this.painter = nested1_9919520;
        return this;
    }

    @Override
    public Iii_Class4 motion(IIii_Class4 iIii_Class4) {
        super.motion(iIii_Class4);
        return this;
    }

    @Override
    public Iii_Class4 width(float f) {
        super.width(f);
        return this;
    }

    @Override
    public Iii_Class4 height(float f) {
        super.height(f);
        return this;
    }

    @Override
    public Iii_Class4 size(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    @Override
    public Iii_Class4 minSize(float f, float f2) {
        super.minSize(f, f2);
        return this;
    }

    @Override
    public Iii_Class4 maxSize(float f, float f2) {
        super.maxSize(f, f2);
        return this;
    }

    @Override
    public Iii_Class4 minWidth(float f) {
        super.minWidth(f);
        return this;
    }

    @Override
    public Iii_Class4 minHeight(float f) {
        super.minHeight(f);
        return this;
    }

    @Override
    public Iii_Class4 fillWidth() {
        super.fillWidth();
        return this;
    }

    @Override
    public Iii_Class4 fillHeight() {
        super.fillHeight();
        return this;
    }

    @Override
    public Iii_Class4 fill() {
        super.fill();
        return this;
    }

    @Override
    public Iii_Class4 at(float f, float f2) {
        super.at(f, f2);
        return this;
    }

    @Override
    public Iii_Class4 enter(IiiI_Class7 iiiI_Class7) {
        super.enter(iiiI_Class7);
        return this;
    }

    @Override
    public Iii_Class4 exit(IiiI_Class7 iiiI_Class7) {
        super.exit(iiiI_Class7);
        return this;
    }

    @Override
    public Iii_Class4 transition(IiiI_Class7 iiiI_Class7) {
        super.transition(iiiI_Class7);
        return this;
    }

    @Override
    public Iii_Class4 lifeMotion(IIii_Class4 iIii_Class4) {
        super.lifeMotion(iIii_Class4);
        return this;
    }

    @Override
    public Iii_Class4 onClick(Runnable runnable) {
        super.onClick(runnable);
        return this;
    }

    @Override
    public Iii_Class4 onClick(Consumer<IiIII_Class9> consumer) {
        super.onClick(consumer);
        return this;
    }

    @Override
    public Iii_Class4 onClick(iiI_Class7.Nested1_b540d20 nested1_b540d20) {
        super.onClick(nested1_b540d20);
        return this;
    }

    @Override
    public Iii_Class4 interactive(boolean bl) {
        super.interactive(bl);
        return this;
    }

    @Override
    public Iii_Class4 draggable(iIi_Class6 iIi_Class62) {
        super.draggable(iIi_Class62);
        return this;
    }

    @Override
    public Iii_Class4 draggable(boolean bl) {
        super.draggable(bl);
        return this;
    }

    @Override
    public Iii_Class4 cursor(iIIIiIIIi_Class274 iIIIiIIRockstarClient742) {
        super.cursor(iIIIiIIRockstarClient742);
        return this;
    }

    @Override
    public Iii_Class4 hoverMotion(IIii_Class4 iIii_Class4) {
        super.hoverMotion(iIii_Class4);
        return this;
    }

    @Override
    public Iii_Class4 center() {
        super.center();
        return this;
    }

    @Override
    public Iii_Class4 centerX() {
        super.centerX();
        return this;
    }

    @Override
    public Iii_Class4 centerY() {
        super.centerY();
        return this;
    }

    @Override
    public Iii_Class4 visibleWhen(BooleanSupplier booleanSupplier) {
        super.visibleWhen(booleanSupplier);
        return this;
    }

    @Override
    public Iii_Class4 visibleWhen(BooleanSupplier booleanSupplier, IIii_Class4 iIii_Class4) {
        super.visibleWhen(booleanSupplier, iIii_Class4);
        return this;
    }

    @Override
    public Iii_Class4 visibleWhen(BooleanSupplier booleanSupplier, IiiiIiiII_Class237 iiiiIiiII_Class237, long l) {
        super.visibleWhen(booleanSupplier, iiiiIiiII_Class237, l);
        return this;
    }

    @Override
    public Iii_Class4 snapPosition(BooleanSupplier booleanSupplier) {
        super.snapPosition(booleanSupplier);
        return this;
    }

    @Override
    public Iii_Class4 snapPosition() {
        super.snapPosition();
        return this;
    }

    @Override
    public Iii_Class4 animatePosition() {
        super.animatePosition();
        return this;
    }

    @Override
    public Iii_Class4 sticky(BooleanSupplier booleanSupplier) {
        super.sticky(booleanSupplier);
        return this;
    }

    @Override
    public Iii_Class4 sticky() {
        super.sticky();
        return this;
    }

    @Override
    public Iii_Class4 collapse() {
        super.collapse();
        return this;
    }

    @Override
    public Iii_Class4 collapse(boolean bl) {
        super.collapse(bl);
        return this;
    }

    @Override
    public Iii_Class4 bind(String string, BooleanSupplier booleanSupplier) {
        super.bind(string, booleanSupplier);
        return this;
    }

    @Override
    public Iii_Class4 bind(String string, iiI_Class7.Nested1_b540d40 nested1_b540d40) {
        super.bind(string, nested1_b540d40);
        return this;
    }

    @Override
    public Iii_Class4 bind(String string, BooleanSupplier booleanSupplier, IIii_Class4 iIii_Class4) {
        super.bind(string, booleanSupplier, iIii_Class4);
        return this;
    }

    @Override
    public Iii_Class4 bind(String string, iiI_Class7.Nested1_b540d40 nested1_b540d40, IIii_Class4 iIii_Class4) {
        super.bind(string, nested1_b540d40, iIii_Class4);
        return this;
    }

    @Override
    public Iii_Class4 bind(String string, BooleanSupplier booleanSupplier, long l) {
        super.bind(string, booleanSupplier, l);
        return this;
    }

    @Override
    public Iii_Class4 bind(String string, iiI_Class7.Nested1_b540d40 nested1_b540d40, long l) {
        super.bind(string, nested1_b540d40, l);
        return this;
    }

    @Override
    public Iii_Class4 signalMotion(String string, IIii_Class4 iIii_Class4) {
        super.signalMotion(string, iIii_Class4);
        return this;
    }

    @Override
    protected void onTick(float f, float f2, float f3) {
        if (!this.textFade || this.font == null || this.text == null) {
            return;
        }
        String string = this.text.get();
        if (string == null || string.isEmpty()) {
            this.marqueeOffset = 0.0f;
            this.marqueeForward = true;
            this.marqueeHold = 0.0f;
            return;
        }
        float f4 = Math.max(1.0f, this.w.I_method_4e8b496f() - this.padding.I_method_b35d9ffc() - this.textInset * 2.0f);
        float f5 = Math.max(0.0f, this.font.I_method_2c375926(string) - f4);
        if (f5 <= 0.0f) {
            this.marqueeOffset = 0.0f;
            this.marqueeForward = true;
            this.marqueeHold = 0.0f;
            return;
        }
        if (this.contains(f2, f3) && !ANY_DRAGGING) {
            this.marqueeOffset = Math.min(this.marqueeOffset, f5);
            if (this.marqueeHold > 0.0f) {
                this.marqueeHold -= f;
            } else {
                float f6 = f / 1000.0f * 35.0f;
                if (this.marqueeForward) {
                    this.marqueeOffset = Math.min(this.marqueeOffset + f6, f5);
                    if (this.marqueeOffset >= f5) {
                        this.marqueeForward = false;
                        this.marqueeHold = 600.0f;
                    }
                } else {
                    this.marqueeOffset = Math.max(this.marqueeOffset - f6, 0.0f);
                    if (this.marqueeOffset <= 0.0f) {
                        this.marqueeForward = true;
                        this.marqueeHold = 600.0f;
                    }
                }
            }
        } else if (this.marqueeOffset > 0.0f) {
            this.marqueeOffset = Math.max(0.0f, this.marqueeOffset - f / 1000.0f * 35.0f);
        }
    }

    @Override
    protected void measure() {
        float f;
        if (this.image != null && this.imageSize > 0.0f) {
            if (!this.explicitW) {
                this.prefW = this.imageSize + this.padding.I_method_b35d9ffc();
            }
            if (!this.explicitH) {
                this.prefH = this.imageSize + this.padding.i_method_b36c2bdc();
            }
        }
        if (this.text == null || this.font == null) {
            return;
        }
        String string = this.text.get();
        float f2 = f = string == null || string.isEmpty() ? 0.0f : this.font.I_method_2c375926(string);
        float iconExtra = (this.iconName != null && this.iconSize > 0.0f) ? (this.iconSize + 5.0f) : 0.0f;
        if (!this.explicitW) {
            this.prefW = (this.textFade ? 0.0f : f) + iconExtra + this.textInset * 2.0f + this.padding.I_method_b35d9ffc();
        }
        if (!this.explicitH) {
            this.prefH = this.font.I_method_a649725c() + this.padding.i_method_b36c2bdc();
        }
    }

    @Override
    protected void drawSelf(III iII, float f) {
        float f2;
        Object object;
        ColorRGBA colorRGBA;
        float f3 = this.x.I_method_4e8b496f();
        float f4 = this.y.I_method_4e8b496f();
        float f5 = this.w.I_method_4e8b496f();
        float f6 = this.h.I_method_4e8b496f();
        if (this.bg != null && (colorRGBA = this.bg.apply(this)) != null && colorRGBA.getAlpha() > 0.0f) {
            if (this.squircle > 0.0f) {
                iII.drawSquircle(f3, f4, f5, f6, this.squircle, this.radius, colorRGBA);
            } else {
                iII.drawRoundedRect(f3, f4, f5, f6, this.radius, colorRGBA);
            }
        }
        if (this.border != null && this.borderWidth > 0.0f && (colorRGBA = this.border.apply(this)) != null && colorRGBA.getAlpha() > 0.0f) {
            if (this.squircle > 0.0f) {
                iII.drawSquircleBorder(f3, f4, f5, f6, this.borderWidth, this.squircle, this.radius, colorRGBA);
            } else {
                iII.drawRoundedBorder(f3, f4, f5, f6, this.borderWidth, this.radius, colorRGBA);
            }
        }
        float f7 = f3 + this.padding.Ii_field_46;
        float f8 = f4 + this.padding.I_field_46;
        float f9 = f5 - this.padding.I_method_b35d9ffc();
        float f10 = f6 - this.padding.i_method_b36c2bdc();
        if (this.iconName != null && this.iconSize > 0.0f) {
            object = this.iconColor != null ? this.iconColor.apply(this) : ColorRGBA.WHITE;
            iII.drawIcon(this.iconName, f7 + this.textInset, f8 + f10 / 2.0f - this.iconSize / 2.0f, this.iconSize, (ColorRGBA)object);
        }
        if (this.image != null && this.imageSize > 0.0f) {
            Object object2 = object = this.imageColor != null ? this.imageColor.apply(this) : ColorRGBA.WHITE;
            if (object == null) {
                object = ColorRGBA.WHITE;
            }
            float f11 = f7 + f9 / 2.0f - this.imageSize / 2.0f;
            f2 = f8 + f10 / 2.0f - this.imageSize / 2.0f;
            if (this.imageRadius > 0.0f) {
                iII.drawRoundedTexture(this.image, f11, f2, this.imageSize, this.imageSize, IIiii_Class8.I_method_893b2757(this.imageRadius), (ColorRGBA)object);
            } else {
                iII.drawTexture(this.image, f11, f2, this.imageSize, this.imageSize, (ColorRGBA)object);
            }
        }
        if (this.text != null && this.font != null && (object = this.text.get()) != null && !((String)object).isEmpty()) {
            ColorRGBA colorRGBA2 = this.textColor != null ? this.textColor.apply(this) : ColorRGBA.WHITE;
            f2 = f8 + f10 / 2.0f - this.font.I_method_a649725c() / 2.0f;
            float iconExtra = (this.iconName != null && this.iconSize > 0.0f) ? (this.iconSize + 5.0f) : 0.0f;
            float textX = f7 + this.textInset + iconExtra;
            if (this.textFade) {
                boolean bl;
                float f12 = Math.max(1.0f, f9 - this.textInset * 2.0f - iconExtra);
                boolean bl2 = bl = this.marqueeOffset > 0.01f;
                if (bl) {
                    float f13 = Math.max(f6, this.font.I_method_a649725c() + 4.0f);
                    iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), textX - 3.0f, f4 - 3.0f, f12 + 6.0f, f13 + 6.0f);
                    iII.pushMatrix();
                    iII.getMatrices().translate(-this.marqueeOffset, 0.0f, 0.0f);
                }
                iII.drawFadeoutText(this.font, (String)object, textX, f2, colorRGBA2, 0.95f, 1.0f, f12);
                if (bl) {
                    iII.popMatrix();
                    iIiiiIiII_Class373.I_method_ff80a1df();
                }
                if (this.painter != null) {
                    this.painter.paint(iII, this);
                }
                return;
            }
            boolean bl = this.shadowColor != null && this.shadowColor.getAlpha() > 0.0f;
            switch (this.textAlign) {
                case i_field_b5755e8c: {
                    if (bl) {
                        iII.drawCenteredTextWithShadow(this.font, (String)object, f7 + f9 / 2.0f, f2, colorRGBA2, this.shadowColor, this.shadowOffX, this.shadowOffY, this.shadowBlur);
                        break;
                    }
                    iII.drawCenteredText(this.font, (String)object, f7 + f9 / 2.0f, f2, colorRGBA2);
                    break;
                }
                case II_field_b5755e8c: {
                    iII.drawRightText(this.font, (String)object, f7 + f9 - this.textInset, f2, colorRGBA2);
                    break;
                }
                default: {
                    if (bl) {
                        iII.drawTextWithShadow(this.font, (String)object, textX, f2, colorRGBA2, this.shadowColor, this.shadowOffX, this.shadowOffY, this.shadowBlur);
                        break;
                    }
                    iII.drawText(this.font, (String)object, textX, f2, colorRGBA2);
                }
            }
        }
        if (this.painter != null) {
            this.painter.paint(iII, this);
        }
    }

    public static interface Nested1_9919520 {
        public void paint(III var1, Iii_Class4 var2);
    }
}

