package rockstar.client;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import rockstar.client.IIIIIIi_Class2;
import rockstar.client.IIIiiii_Class16;
import rockstar.client.IiiIiII_Class53;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iIIIiI_Class35;

public class iIiIIiI_Class83 {
    private static Duration I_field_af06f406 = null;

    public static synchronized Duration I_method_91aded3d() {
        if (I_field_af06f406 == null) {
            iIIIII_Class33 iIIIII_Class332 = IIIiiii_Class16.I_method_2f0917d8();
            iIIIII_Class332.I_method_75ebd022().I_method_edbb2fda(3);
            try {
                iIIIiI_Class35 iIIIiI_Class352 = iIIIII_Class332.I_method_7ad89d6a(new IIIIIIi_Class2(IiiIiII_Class53.I_field_c508bfcc.iI_method_836419fe()));
                Instant instant = Instant.now();
                Instant instant2 = iIIIiI_Class352.I_method_a5598def("Date").map(string -> DateTimeFormatter.RFC_1123_DATE_TIME.parse((CharSequence)string, Instant::from)).get();
                I_field_af06f406 = Duration.between(instant, instant2);
            }
            catch (Throwable throwable) {
                new RuntimeException("Failed to get client time offset. This may cause issues with authentication if the local clock is wrong", throwable).printStackTrace();
                I_field_af06f406 = Duration.ZERO;
            }
        }
        return I_field_af06f406;
    }
}

