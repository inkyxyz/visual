package pyrock.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import jep.python.PyCallable;
import lombok.Generated;
import net.minecraft.text.Text;
import pyrock.events.PyEvent;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IIiiIiIIi_Class106;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;

public class PyEvents {
    private final IIiiIIiii_Class104 owner;
    private final Map<String, List<PyCallable>> listeners = new HashMap<String, List<PyCallable>>();
    private final Map<String, PyEvent> eventObjects = new HashMap<String, PyEvent>();
    private final Map<Class<?>, String> eventNameCache = new ConcurrentHashMap();
    private Consumer<Exception> errorHandler;
    private volatile boolean disposed;

    public PyEvents() {
        this(null);
    }

    public PyEvents(IIiiIIiii_Class104 iIiiIIiii_Class104) {
        this.owner = iIiiIIiii_Class104;
    }

    public void register(String string2, PyCallable pyCallable) {
        if (this.disposed) {
            return;
        }
        this.listeners.computeIfAbsent(string2.toLowerCase(), string -> new ArrayList()).add(pyCallable);
    }

    public void fire(IiIIIIIi_Class66 iiIIIIIi_Class66) {
        if (!this.isAlive()) {
            return;
        }
        String string = this.getEventName(iiIIIIIi_Class66.getClass());
        if (string == null) {
            return;
        }
        List<PyCallable> list = this.listeners.get(string);
        if (list == null || list.isEmpty()) {
            return;
        }
        if (!IIiiIiIIi_Class106.Ii_method_b61528e6()) {
            iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> {
                if (this.isAlive()) {
                    this.fireOnOwnerThread(string, iiIIIIIi_Class66);
                }
            });
            return;
        }
        this.fireOnOwnerThread(string, iiIIIIIi_Class66);
    }

    private void fireOnOwnerThread(String string, IiIIIIIi_Class66 iiIIIIIi_Class66) {
        if (!this.isAlive()) {
            return;
        }
        List<PyCallable> list = this.listeners.get(string);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (PyCallable pyCallable : list) {
            try {
                AutoCloseable autoCloseable = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner);
                try {
                    pyCallable.call(new Object[]{iiIIIIIi_Class66});
                }
                finally {
                    if (autoCloseable == null) continue;
                    autoCloseable.close();
                }
            }
            catch (Exception exception) {
                String string2 = exception.getMessage();
                if (string2 != null && string2.contains(":")) {
                    string2 = string2.substring(string2.indexOf(":") + 1).trim();
                }
                iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)("[Python Error] " + string2)));
                RockstarClient.I_field_ab0f6068.error("Python error in event '" + string + "':", (Throwable)exception);
                if (this.errorHandler == null) break;
                this.errorHandler.accept(exception);
                break;
            }
        }
    }

    private String getEventName(Class<?> clazz) {
        String string = this.eventNameCache.get(clazz);
        if (string != null) {
            return string.isEmpty() ? null : string;
        }
        IiIIIIiI_Class67 iiIIIIiI_Class67 = clazz.getAnnotation(IiIIIIiI_Class67.class);
        String string2 = iiIIIIiI_Class67 == null ? "" : iiIIIIiI_Class67.I_method_80b3cd54().toLowerCase();
        this.eventNameCache.put(clazz, string2);
        return string2.isEmpty() ? null : string2;
    }

    public PyEvent getEvent(String string2) {
        return this.eventObjects.computeIfAbsent(string2, string -> new PyEvent((String)string, this));
    }

    public void dispose() {
        this.disposed = true;
        this.listeners.clear();
        this.eventObjects.clear();
        this.errorHandler = null;
    }

    private boolean isAlive() {
        return !this.disposed && (this.owner == null || this.owner.II_method_b18bf526());
    }

    @Generated
    public void setErrorHandler(Consumer<Exception> consumer) {
        this.errorHandler = consumer;
    }
}

