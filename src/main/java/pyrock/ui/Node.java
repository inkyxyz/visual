package pyrock.ui;

import java.util.function.BooleanSupplier;
import jep.python.PyCallable;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiI_Class3;
import rockstar.client.IIi_Class2;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIi_Class6;
import rockstar.client.RockstarClient;
import rockstar.client.IiiI_Class7;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iII_Class5;
import rockstar.client.iIi_Class6;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public class Node {
    private static final ColorRGBA TRANSPARENT = new ColorRGBA(0.0f, 0.0f, 0.0f, 0.0f);
    private final iiI_Class7 el;
    private static final long VIS_THROTTLE_MS = 50L;
    private static long visStagger = 0L;

    Node(iiI_Class7 iiI_Class72) {
        this.el = iiI_Class72;
    }

    public iiI_Class7 element() {
        return this.el;
    }

    public Node add(Node node) {
        iiI_Class7 iiI_Class72;
        if (node != null && (iiI_Class72 = this.el) instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_8939bffd(node.el);
        }
        return this;
    }

    public Node clear() {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_814bf93f();
        }
        return this;
    }

    public Node width(float f) {
        this.el.width(f);
        return this;
    }

    public Node height(float f) {
        this.el.height(f);
        return this;
    }

    public Node size(float f, float f2) {
        this.el.size(f, f2);
        return this;
    }

    public Node minSize(float f, float f2) {
        this.el.minSize(f, f2);
        return this;
    }

    public Node maxSize(float f, float f2) {
        this.el.maxSize(f, f2);
        return this;
    }

    public Node minWidth(float f) {
        this.el.minWidth(f);
        return this;
    }

    public Node minHeight(float f) {
        this.el.minHeight(f);
        return this;
    }

    public Node fill() {
        this.el.fill();
        return this;
    }

    public Node fillWidth() {
        this.el.fillWidth();
        return this;
    }

    public Node fillHeight() {
        this.el.fillHeight();
        return this;
    }

    public Node at(float f, float f2) {
        this.el.at(f, f2);
        return this;
    }

    public Node center() {
        this.el.center();
        return this;
    }

    public Node centerX() {
        this.el.centerX();
        return this;
    }

    public Node centerY() {
        this.el.centerY();
        return this;
    }

    public Node animatePosition() {
        this.el.animatePosition();
        return this;
    }

    public Node snapPosition() {
        this.el.snapPosition();
        return this;
    }

    public Node direction(String string) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_3301fdd(Node.parseDir(string));
        }
        return this;
    }

    public Node column() {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_485bccf5();
        }
        return this;
    }

    public Node row() {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.i_method_c88da8d5();
        }
        return this;
    }

    public Node gap(float f) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_70a38517(f);
        }
        return this;
    }

    public Node columns(int n) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_4f3850da(n);
        }
        return this;
    }

    public Node wrap() {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.II_method_3b06fa38();
        }
        return this;
    }

    public Node align(String string) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_483797dd(Node.parseAlign(string));
        }
        return this;
    }

    public Node justify(String string) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_fe5d8d56(Node.parseJustify(string));
        }
        return this;
    }

    public Node scrollable() {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.Ii_method_bb38d618();
        }
        return this;
    }

    public Node stack() {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.iI_method_c1109a58();
        }
        return this;
    }

    public Node scrollbar(String string) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_3987f136(Node.parseScroll(string));
        }
        return this;
    }

    public Node stagger(float f) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.Ii_method_5967a054(f);
        }
        return this;
    }

    public Node pad(float f) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.i_method_f6ad2537(f);
        } else {
            iiI_Class72 = this.el;
            if (iiI_Class72 instanceof Iii_Class4) {
                Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
                iii_Class4.padding(f);
            }
        }
        return this;
    }

    public Node pad(float f, float f2) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.I_method_5152d135(f, f2);
        } else {
            iiI_Class72 = this.el;
            if (iiI_Class72 instanceof Iii_Class4) {
                Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
                iii_Class4.padding(f, f2);
            }
        }
        return this;
    }

    public Node color(ColorRGBA colorRGBA) {
        if (colorRGBA == null) {
            return this;
        }
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.background(colorRGBA);
        } else {
            iiI_Class72 = this.el;
            if (iiI_Class72 instanceof iii_Class8) {
                iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
                iii_Class82.I_method_56ebe256(colorRGBA);
            }
        }
        return this;
    }

    public Node colorFn(PyCallable pyCallable) {
        if (pyCallable == null) {
            return this;
        }
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class42 = (Iii_Class4)iiI_Class72;
            iii_Class42.background(iii_Class4 -> Node.safeColor(pyCallable));
        } else {
            iiI_Class72 = this.el;
            if (iiI_Class72 instanceof iii_Class8) {
                iii_Class8 iii_Class83 = (iii_Class8)iiI_Class72;
                iii_Class83.I_method_e53800a9(iii_Class82 -> Node.safeColor(pyCallable));
            }
        }
        return this;
    }

    public Node radius(float f) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.radius(f);
        } else {
            iiI_Class72 = this.el;
            if (iiI_Class72 instanceof iii_Class8) {
                iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
                iii_Class82.iI_method_e886414(f);
            }
        }
        return this;
    }

    public Node squircle(float f) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.squircle(f);
        } else {
            iiI_Class72 = this.el;
            if (iiI_Class72 instanceof iii_Class8) {
                iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
                iii_Class82.ii_method_94920434(f);
            }
        }
        return this;
    }

    public Node radiusBottom(float f) {
        IIiii_Class8 iIiii_Class8 = IIiii_Class8.i_method_b61fef15(f, f);
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.radius(iIiii_Class8);
        } else {
            iiI_Class72 = this.el;
            if (iiI_Class72 instanceof iii_Class8) {
                iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
                iii_Class82.I_method_ce2a4afd(iIiii_Class8);
            }
        }
        return this;
    }

    public Node blur(float f) {
        this.el.blur(f);
        return this;
    }

    public Node blur(float f, ColorRGBA colorRGBA) {
        this.el.blur(f, colorRGBA);
        return this;
    }

    public Node glass() {
        this.el.glass();
        return this;
    }

    public Node glass(float f, boolean bl) {
        this.el.glass(f, bl);
        return this;
    }

    public Node border(float f, ColorRGBA colorRGBA) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.border(f, colorRGBA);
        }
        return this;
    }

    public Node textAlign(String string) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.textAlign(Node.parseAlign(string));
        }
        return this;
    }

    public Node textShadow(ColorRGBA colorRGBA, float f, float f2, float f3) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.textShadow(colorRGBA, f, f2, f3);
        }
        return this;
    }

    public Node icon(String string, float f, ColorRGBA colorRGBA) {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.icon(string, f, colorRGBA != null ? colorRGBA : IiiiiIIIi_Class242.iII_field_d0c8ec5);
        }
        return this;
    }

    public Node fade() {
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof Iii_Class4) {
            Iii_Class4 iii_Class4 = (Iii_Class4)iiI_Class72;
            iii_Class4.fade();
        }
        return this;
    }

    public Node onClick(PyCallable pyCallable) {
        if (pyCallable != null) {
            this.el.onClick(() -> {
                try {
                    pyCallable.call(new Object[0]);
                }
                catch (Exception exception) {
                    RockstarClient.I_field_ab0f6068.error("[PyUi] onClick", (Throwable)exception);
                }
            });
        }
        return this;
    }

    public Node onClickPos(PyCallable pyCallable) {
        if (pyCallable != null) {
            this.el.onClick((IiIII_Class9 iiIII_Class9, float f, float f2) -> {
                try {
                    pyCallable.call(new Object[]{Float.valueOf(f), Float.valueOf(f2), iiIII_Class9.name().toLowerCase()});
                }
                catch (Exception exception) {
                    RockstarClient.I_field_ab0f6068.error("[PyUi] onClick", (Throwable)exception);
                }
            });
        }
        return this;
    }

    public Node interactive(boolean bl) {
        this.el.interactive(bl);
        return this;
    }

    public Node cursor(String string) {
        this.el.cursor(Node.parseCursor(string));
        return this;
    }

    public Node draggable() {
        this.el.draggable(iIi_Class6.i_field_b583ea6c);
        return this;
    }

    public Node draggable(String string) {
        this.el.draggable(Node.parseDrag(string));
        return this;
    }

    public Node visibleWhen(PyCallable pyCallable) {
        if (pyCallable != null) {
            this.el.visibleWhen(Node.throttledBool(pyCallable));
        }
        return this;
    }

    public Node enter(String string) {
        this.el.enter(Node.parseTransition(string));
        return this;
    }

    public Node exit(String string) {
        this.el.exit(Node.parseTransition(string));
        return this;
    }

    public Node enterSlide(float f) {
        this.el.enter(IiiI_Class7.I_method_540512a3(f));
        return this;
    }

    public Node exitSlide(float f) {
        this.el.exit(IiiI_Class7.I_method_540512a3(f));
        return this;
    }

    public Node motion(String string) {
        this.el.motion(Node.parseMotion(string));
        return this;
    }

    public Node sticky() {
        this.el.sticky();
        return this;
    }

    public Node collapse() {
        this.el.collapse();
        return this;
    }

    public Node bind(String string, PyCallable pyCallable) {
        if (pyCallable != null) {
            this.el.bind(string, Node.boolSupplier(pyCallable));
        }
        return this;
    }

    public Node window(float f, float f2, String string) {
        this.el.size(f, f2).center().draggable(iIi_Class6.i_field_b583ea6c);
        iiI_Class7 iiI_Class72 = this.el;
        if (iiI_Class72 instanceof iii_Class8) {
            iii_Class8 iii_Class82 = (iii_Class8)iiI_Class72;
            iii_Class82.i_method_f6ad2537(10.0f).I_method_70a38517(8.0f).iI_method_e886414(10.0f).ii_method_94920434(6.0f).I_method_56ebe256(IiiiiIIIi_Class242.II_method_190e6391().withAlpha(235.0f));
        }
        return this;
    }

    public float w() {
        return this.el.w();
    }

    public float h() {
        return this.el.h();
    }

    public boolean hovered() {
        return this.el.hovered();
    }

    private static BooleanSupplier boolSupplier(PyCallable pyCallable) {
        return () -> {
            try {
                return Boolean.TRUE.equals(pyCallable.call(new Object[0]));
            }
            catch (Exception exception) {
                return false;
            }
        };
    }

    private static BooleanSupplier throttledBool(final PyCallable pyCallable) {
        final long l = visStagger++ * 7L % 50L;
        return new BooleanSupplier(){
            boolean cached;
            boolean inited;
            long nextEval;

            @Override
            public boolean getAsBoolean() {
                long l2 = IIiI_Class3.renderClock();
                if (!this.inited) {
                    this.inited = true;
                    this.cached = this.eval();
                    this.nextEval = l2 + l;
                } else if (l2 >= this.nextEval) {
                    this.cached = this.eval();
                    this.nextEval = l2 + 50L;
                }
                return this.cached;
            }

            private boolean eval() {
                try {
                    return Boolean.TRUE.equals(pyCallable.call(new Object[0]));
                }
                catch (Exception exception) {
                    return false;
                }
            }
        };
    }

    private static ColorRGBA safeColor(PyCallable pyCallable) {
        try {
            ColorRGBA colorRGBA;
            Object object = pyCallable.call(new Object[0]);
            return object instanceof ColorRGBA ? (colorRGBA = (ColorRGBA)object) : TRANSPARENT;
        }
        catch (Exception exception) {
            return TRANSPARENT;
        }
    }

    private static IIi_Class2 parseAlign(String string) {
        if (string == null) {
            return IIi_Class2.I_field_b5755e8c;
        }
        return switch (string.toLowerCase()) {
            case "center" -> IIi_Class2.i_field_b5755e8c;
            case "end" -> IIi_Class2.II_field_b5755e8c;
            case "stretch" -> IIi_Class2.Ii_field_b5755e8c;
            default -> IIi_Class2.I_field_b5755e8c;
        };
    }

    private static IIIi_Class2 parseJustify(String string) {
        if (string == null) {
            return IIIi_Class2.I_field_f93600a1;
        }
        return switch (string.toLowerCase()) {
            case "center" -> IIIi_Class2.i_field_f93600a1;
            case "end" -> IIIi_Class2.II_field_f93600a1;
            case "between", "space_between" -> IIIi_Class2.Ii_field_f93600a1;
            case "around", "space_around" -> IIIi_Class2.iI_field_f93600a1;
            case "evenly", "space_evenly" -> IIIi_Class2.ii_field_f93600a1;
            default -> IIIi_Class2.I_field_f93600a1;
        };
    }

    private static iII_Class5 parseDir(String string) {
        if (string == null) {
            return iII_Class5.I_field_b583e68c;
        }
        return switch (string.toLowerCase()) {
            case "up" -> iII_Class5.i_field_b583e68c;
            case "right", "row", "horizontal" -> iII_Class5.II_field_b583e68c;
            case "left" -> iII_Class5.Ii_field_b583e68c;
            default -> iII_Class5.I_field_b583e68c;
        };
    }

    private static IiIi_Class6 parseScroll(String string) {
        if (string == null) {
            return IiIi_Class6.I_field_f9448c81;
        }
        return switch (string.toLowerCase()) {
            case "always" -> IiIi_Class6.i_field_f9448c81;
            case "never" -> IiIi_Class6.II_field_f9448c81;
            default -> IiIi_Class6.I_field_f9448c81;
        };
    }

    private static iIi_Class6 parseDrag(String string) {
        if (string == null) {
            return iIi_Class6.i_field_b583ea6c;
        }
        return switch (string.toLowerCase()) {
            case "x", "horizontal" -> iIi_Class6.II_field_b583ea6c;
            case "y", "vertical" -> iIi_Class6.Ii_field_b583ea6c;
            case "none" -> iIi_Class6.I_field_b583ea6c;
            default -> iIi_Class6.i_field_b583ea6c;
        };
    }

    private static iIIIiIIIi_Class274 parseCursor(String string) {
        if (string == null) {
            return iIIIiIIIi_Class274.I_field_aa52e62c;
        }
        return switch (string.toLowerCase()) {
            case "hand", "pointer" -> iIIIiIIIi_Class274.i_field_aa52e62c;
            case "text", "ibeam" -> iIIIiIIIi_Class274.iI_field_aa52e62c;
            case "crosshair" -> iIIIiIIIi_Class274.ii_field_aa52e62c;
            case "hresize", "horizontal" -> iIIIiIIIi_Class274.II_field_aa52e62c;
            case "vresize", "vertical" -> iIIIiIIIi_Class274.Ii_field_aa52e62c;
            case "block", "notallowed" -> iIIIiIIIi_Class274.III_field_aa52e62c;
            case "resize", "resizeall" -> iIIIiIIIi_Class274.IIi_field_aa52e62c;
            default -> iIIIiIIIi_Class274.I_field_aa52e62c;
        };
    }

    private static IIii_Class4 parseMotion(String string) {
        if (string == null) {
            return IIii_Class4.I_field_f93678c1;
        }
        return switch (string.toLowerCase()) {
            case "fast" -> IIii_Class4.Ii_field_f93678c1;
            case "smooth" -> IIii_Class4.II_field_f93678c1;
            case "signal" -> IIii_Class4.iI_field_f93678c1;
            case "spring" -> IIii_Class4.ii_field_f93678c1;
            case "spring_snap" -> IIii_Class4.III_field_f93678c1;
            case "soft", "bakek_soft" -> IIii_Class4.i_field_f93678c1;
            default -> IIii_Class4.I_field_f93678c1;
        };
    }

    private static IiiI_Class7 parseTransition(String string) {
        if (string == null) {
            return IiiI_Class7.II_field_f94500c1;
        }
        return switch (string.toLowerCase()) {
            case "none" -> IiiI_Class7.I_field_f94500c1;
            case "vanish" -> IiiI_Class7.i_field_f94500c1;
            case "fade_slide" -> IiiI_Class7.Ii_field_f94500c1;
            case "up", "slide_up" -> IiiI_Class7.iI_field_f94500c1;
            case "down", "slide_down" -> IiiI_Class7.ii_field_f94500c1;
            case "left", "slide_left" -> IiiI_Class7.III_field_f94500c1;
            case "right", "slide_right" -> IiiI_Class7.IIi_field_f94500c1;
            case "pop" -> IiiI_Class7.IiI_field_f94500c1;
            case "fade_pop" -> IiiI_Class7.Iii_field_f94500c1;
            default -> IiiI_Class7.II_field_f94500c1;
        };
    }
}

