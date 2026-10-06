package rockstar.client;

import rockstar.client.IiIIIIIi_Class66;

public interface IiIIIiII_Class69<T extends IiIIIIIi_Class66> {
    public void onEvent(T var1);

    default public int I_method_f12c6485() {
        return 0;
    }

    public static <T extends IiIIIIIi_Class66> IiIIIiII_Class69<T> I_method_aec3ff5f(final int n, final IiIIIiII_Class69<T> iiIIIiII_Class69) {
        return new IiIIIiII_Class69<T>(){

            @Override
            public void onEvent(T t) {
                iiIIIiII_Class69.onEvent(t);
            }

            @Override
            public int I_method_f12c6485() {
                return n;
            }
        };
    }
}

