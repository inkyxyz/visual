package rockstar.client;

import rockstar.client.IIiiIiiIi_Class110;

public final class IIiiIiiII_Class109
extends ClassLoader {
    public IIiiIiiII_Class109(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    protected Class<?> loadClass(String string, boolean bl) throws ClassNotFoundException {
        try {
            IIiiIiiIi_Class110.I_method_7b55be29(string);
        }
        catch (IIiiIiiIi_Class110.Nested1_a5af6c60 nested1_a5af6c60) {
            throw new ClassNotFoundException(nested1_a5af6c60.getMessage(), nested1_a5af6c60);
        }
        return super.loadClass(string, bl);
    }
}

