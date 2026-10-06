package rockstar.client;

import java.util.Optional;
import org.jetbrains.annotations.Nullable;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiIiiIiiI_Class439;
import rockstar.client.iiiiIIiII_Class485;

public final class iiiiIIiIi_Class486 {
    @Nullable
    private iiiiIIiII_Class485 I_field_95413e6c;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (this.I_field_95413e6c == null) {
            return;
        }
        try {
            iiiiIIiII_Class485 iiiiIIiII_Class4852 = this.I_field_95413e6c;
            if (!iiiiIIiII_Class4852.I_method_8f3b7603()) {
                return;
            }
            if (this.I_field_95413e6c == iiiiIIiII_Class4852) {
                this.I_field_95413e6c = null;
            }
            if (iiiiIIiII_Class4852.II_method_58424146()) {
                iiIiiIiiI_Class439.i_method_cf6f3a29(iiiiIIiII_Class4852.I_method_31075c81());
            } else {
                String string = iiiiIIiII_Class4852.II_method_f53e1f9e();
                iiIiiIiiI_Class439.I_method_9b256fd3(iiiiIIiII_Class4852.I_method_31075c81(), string == null ? "\u043f\u0440\u0435\u0440\u0432\u0430\u043d" : string);
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            this.I_method_7d4e61ff();
        }
    };

    public void I_method_7bda9cc7(iiiiIIiII_Class485 iiiiIIiII_Class4852) {
        this.I_method_7d4e61ff();
        this.I_field_95413e6c = iiiiIIiII_Class4852;
        iiIiiIiiI_Class439.I_method_feb7e649(iiiiIIiII_Class4852.I_method_31075c81());
    }

    public void I_method_7d4e61ff() {
        if (this.I_field_95413e6c == null) {
            return;
        }
        iiiiIIiII_Class485 iiiiIIiII_Class4852 = this.I_field_95413e6c;
        this.I_field_95413e6c = null;
        try {
            iiiiIIiII_Class4852.I_method_8f3b75ff();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        iiIiiIiiI_Class439.I_method_9b256fd3(iiiiIIiII_Class4852.I_method_31075c81(), "\u043e\u0442\u043c\u0435\u043d\u0451\u043d");
    }

    public Optional<iiiiIIiII_Class485> I_method_82bc9266() {
        return Optional.ofNullable(this.I_field_95413e6c);
    }

    public boolean I_method_7d4e6203() {
        return this.I_field_95413e6c != null;
    }

    public static iiiiIIiIi_Class486 I_method_79402f5d(iiIiiIiIi_Class438 iiIiiIiIi_Class4382) {
        iiiiIIiIi_Class486 iiiiIIiIi_Class4862 = new iiiiIIiIi_Class486();
        iiIiiIiIi_Class4382.I_method_ab199998().I_method_2257cd48(iiiiIIiIi_Class4862);
        return iiiiIIiIi_Class4862;
    }
}

