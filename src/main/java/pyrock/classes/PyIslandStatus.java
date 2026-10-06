package pyrock.classes;

import jep.python.PyCallable;
import net.minecraft.text.Text;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIiii_Class184;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIIIii_Class260;

public class PyIslandStatus
extends IiIiiIiii_Class184 {
    private final IIiiIIiii_Class104 owner;
    private PyCallable visibleWhen;
    private PyCallable measureCallback;
    private PyCallable renderCallback;
    private PyCallable clickCallback;
    private PyCallable colorCallback;
    private ColorRGBA color = IiiiiIIIi_Class242.II_method_190e6391();
    private boolean expandable;
    private boolean disposed;
    private boolean errored;
    private IiIiiIIII_Class177 island;
    private float x;
    private float y;
    private float width;
    private float height;
    private float alpha;

    public PyIslandStatus(IIiiIIiii_Class104 iIiiIIiii_Class104, MultiSelectSetting iIiiiiiii_Class128, String string, float f, float f2, float f3) {
        super(iIiiiiiii_Class128, string, false);
        this.owner = iIiiIIiii_Class104;
        this.size.I_method_86686501(Math.max(1.0f, f), Math.max(1.0f, f2), Math.max(0.0f, f3));
    }

    public PyIslandStatus visibleWhen(PyCallable pyCallable) {
        this.visibleWhen = pyCallable;
        this.errored = false;
        return this;
    }

    public PyIslandStatus showWhen(PyCallable pyCallable) {
        return this.visibleWhen(pyCallable);
    }

    public PyIslandStatus measure(PyCallable pyCallable) {
        this.measureCallback = pyCallable;
        this.errored = false;
        return this;
    }

    public PyIslandStatus renderer(PyCallable pyCallable) {
        this.renderCallback = pyCallable;
        this.errored = false;
        return this;
    }

    public PyIslandStatus render(PyCallable pyCallable) {
        return this.renderer(pyCallable);
    }

    public PyIslandStatus onClick(PyCallable pyCallable) {
        this.clickCallback = pyCallable;
        this.errored = false;
        return this;
    }

    public PyIslandStatus clickCallback(PyCallable pyCallable) {
        return this.onClick(pyCallable);
    }

    public PyIslandStatus colorFn(PyCallable pyCallable) {
        this.colorCallback = pyCallable;
        this.errored = false;
        return this;
    }

    public PyIslandStatus color(ColorRGBA colorRGBA) {
        this.color = colorRGBA == null ? IiiiiIIIi_Class242.II_method_190e6391() : colorRGBA;
        this.colorCallback = null;
        return this;
    }

    public PyIslandStatus color(double d, double d2, double d3) {
        return this.color(d, d2, d3, 255.0);
    }

    public PyIslandStatus color(double d, double d2, double d3, double d4) {
        return this.color(new ColorRGBA((float)d, (float)d2, (float)d3, (float)d4));
    }

    public PyIslandStatus size(double d, double d2) {
        return this.size(d, d2, this.size.II_field_46);
    }

    public PyIslandStatus size(double d, double d2, double d3) {
        this.size.I_method_86686501(Math.max(1.0f, (float)d), Math.max(1.0f, (float)d2), Math.max(0.0f, (float)d3));
        return this;
    }

    public PyIslandStatus width(double d) {
        this.size.I_field_46 = Math.max(1.0f, (float)d);
        return this;
    }

    public PyIslandStatus height(double d) {
        this.size.i_field_46 = Math.max(1.0f, (float)d);
        return this;
    }

    public PyIslandStatus radius(double d) {
        this.size.II_field_46 = Math.max(0.0f, (float)d);
        return this;
    }

    public PyIslandStatus expandable(boolean bl) {
        this.expandable = bl;
        return this;
    }

    public PyIslandStatus selected(boolean bl) {
        if (bl) {
            this.getParent().i_method_bff19e42(this);
        } else {
            this.getParent().i_method_faf6de68().remove(this);
        }
        RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
        return this;
    }

    public boolean selected() {
        return this.isSelected();
    }

    @Override
    public boolean isExpandable() {
        return this.expandable;
    }

    @Override
    public float radius(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        return this.size.II_field_46;
    }

    @Override
    public void prepare(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        this.island = iiIiiIIII_Class177;
        if (!this.alive() || this.measureCallback == null) {
            return;
        }
        try (AutoCloseable autoCloseable = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner);){
            this.measureCallback.call(new Object[]{this});
        }
        catch (Throwable throwable) {
            this.handleError("measure", throwable);
        }
    }

    @Override
    public void render(III iII, IiIiiIIII_Class177 iiIiiIIII_Class177, float f, float f2, float f3, float f4, float f5) {
        this.island = iiIiiIIII_Class177;
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
        this.alpha = f5;
        if (!this.alive() || this.renderCallback == null) {
            return;
        }
        try (AutoCloseable autoCloseable = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner);){
            this.renderCallback.call(new Object[]{iII, this});
        }
        catch (Throwable throwable) {
            this.handleError("render", throwable);
        }
    }

    @Override
    public void click(float f, float f2, int n) {
        if (!this.alive() || this.clickCallback == null) {
            return;
        }
        try (AutoCloseable autoCloseable = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner);){
            this.clickCallback.call(new Object[]{Float.valueOf(f), Float.valueOf(f2), n, this});
        }
        catch (Throwable throwable) {
            this.handleError("click", throwable);
        }
    }

    @Override
    public boolean canShow() {
        if (!this.alive()) {
            return false;
        }
        if (this.visibleWhen == null) {
            return true;
        }
        try (AutoCloseable ignored = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
            return PyIslandStatus.truthy(this.visibleWhen.call(new Object[]{this}));
        } catch (Throwable throwable) {
            this.handleError("visible", throwable);
            return false;
        }
    }

    @Override
    public ColorRGBA getColor() {
        if (!this.alive() || this.colorCallback == null) {
            return this.color;
        }
        try (AutoCloseable ignored = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
            Object value = this.colorCallback.call(new Object[]{this});
            return value instanceof ColorRGBA ? (ColorRGBA)value : this.color;
        } catch (Throwable throwable) {
            this.handleError("color", throwable);
            return this.color;
        }
    }

    public boolean ownedBy(IIiiIIiii_Class104 iIiiIIiii_Class104) {
        return this.owner == iIiiIIiii_Class104;
    }

    public boolean remove() {
        this.dispose();
        IiIiiIIII_Class177 iiIiiIIII_Class177 = RockstarClient.getInstance().I_method_35687482().I_method_35128395();
        return iiIiiIIII_Class177 != null && iiIiiIIII_Class177.I_method_2535948b(this);
    }

    public void dispose() {
        this.disposed = true;
        this.visibleWhen = null;
        this.measureCallback = null;
        this.renderCallback = null;
        this.clickCallback = null;
        this.colorCallback = null;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float renderAlpha() {
        return this.alpha;
    }

    public float dragAlpha() {
        return 0.0f;
    }

    public boolean extended() {
        return this.island != null && this.island.II_method_97ffcce6();
    }

    public float extending() {
        return this.island == null ? 0.0f : this.island.I_method_c3480795().I_method_6ac4da6f();
    }

    private boolean alive() {
        return !this.disposed && !this.errored && (this.owner == null || this.owner.II_method_b18bf526());
    }

    private void handleError(String string, Throwable throwable) {
        int n;
        if (this.errored) {
            return;
        }
        this.errored = true;
        this.visibleWhen = null;
        this.measureCallback = null;
        this.renderCallback = null;
        this.clickCallback = null;
        this.colorCallback = null;
        this.getParent().i_method_faf6de68().remove(this);
        String string2 = throwable.getMessage();
        if (string2 == null || string2.isBlank()) {
            string2 = throwable.getClass().getSimpleName();
        }
        if ((n = string2.indexOf(58)) >= 0 && n + 1 < string2.length()) {
            string2 = string2.substring(n + 1).trim();
        }
        iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)("[Python Island Error] " + this.getName() + " (" + string + "): " + string2)));
        RockstarClient.I_field_ab0f6068.error("Python island status error in '{}' during {}", new Object[]{this.getName(), string, throwable});
    }

    private static boolean truthy(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof Boolean) {
            Boolean bl = (Boolean)object;
            return bl;
        }
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.doubleValue() != 0.0;
        }
        if (object instanceof CharSequence) {
            CharSequence charSequence = (CharSequence)object;
            return !charSequence.isEmpty();
        }
        return true;
    }
}
