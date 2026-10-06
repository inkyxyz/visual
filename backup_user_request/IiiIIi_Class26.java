package rockstar.client;

import java.util.function.Function;
import java.util.stream.Collector;
import rockstar.client.IiiIii_Class28;
import rockstar.client.IiiiII_Class29;
import rockstar.client.IiiiIi_Class30;

public class IiiIIi_Class26 {
    public static <T extends IiiiII_Class29> Collector<T, ?, IiiIii_Class28> I_method_91a06d9b() {
        return Collector.of(IiiIii_Class28::new, IiiIii_Class28::I_method_f292d96a, (iiiIii_Class28, iiiIii_Class282) -> {
            if (iiiIii_Class28.I_method_cc3efe70()) {
                return iiiIii_Class282;
            }
            if (iiiIii_Class282.I_method_cc3efe70()) {
                return iiiIii_Class28;
            }
            IiiIii_Class28 iiiIii_Class283 = new IiiIii_Class28();
            iiiIii_Class283.I_method_cd94d4a((IiiIii_Class28)iiiIii_Class28);
            iiiIii_Class283.I_method_cd94d4a((IiiIii_Class28)iiiIii_Class282);
            return iiiIii_Class283;
        }, new Collector.Characteristics[0]);
    }

    public static <P, V extends IiiiII_Class29> Collector<P, ?, IiiiIi_Class30> I_method_231135b(Function<P, String> function, Function<P, V> function2) {
        return Collector.of(IiiiIi_Class30::new, (iiiiIi_Class30, object) -> iiiiIi_Class30.I_method_b1b74560((String)function.apply(object), (IiiiII_Class29)function2.apply(object)), (iiiiIi_Class30, iiiiIi_Class302) -> {
            if (iiiiIi_Class30.I_method_2b9d3230()) {
                return iiiiIi_Class302;
            }
            if (iiiiIi_Class302.I_method_2b9d3230()) {
                return iiiiIi_Class30;
            }
            IiiiIi_Class30 iiiiIi_Class303 = new IiiiIi_Class30();
            iiiiIi_Class303.I_method_3ddd98a((IiiiIi_Class30)iiiiIi_Class30);
            iiiiIi_Class303.I_method_3ddd98a((IiiiIi_Class30)iiiiIi_Class302);
            return iiiiIi_Class303;
        }, new Collector.Characteristics[0]);
    }
}

