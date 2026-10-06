package rockstar.client;

public class IIIiIiI_Class11<T> {
    private boolean I_field_5a = false;
    private T I_field_5f790d9c;

    public IIIiIiI_Class11() {
    }

    public IIIiIiI_Class11(T t) {
        this.I_method_357602fb(t);
    }

    public boolean I_method_4ee9ece3() {
        return this.I_field_5a;
    }

    public void I_method_4ee9ecdf() {
        this.I_field_5a = false;
        this.I_field_5f790d9c = null;
    }

    public T I_method_4e36a433() {
        if (!this.I_field_5a) {
            throw new IllegalStateException("Value is not set");
        }
        return this.I_field_5f790d9c;
    }

    public void I_method_357602fb(T t) {
        this.I_field_5f790d9c = t;
        this.I_field_5a = true;
    }
}

