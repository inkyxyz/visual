package rockstar.client;

import lombok.Generated;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iiIiiIiIi_Class438;
import rockstar.client.iiiIiiiii_Class480;
import ua.mintantileak.spk.Compile;

public class IIiIIiII_Class37 {
    private static IIiIIiII_Class37 I_field_de353b81;
    private iiiIiiiii_Class480 I_field_30d8564c;
    private boolean I_field_5a;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (!this.I_field_5a || this.I_field_30d8564c == null) {
            return;
        }
        if (this.I_field_30d8564c.II_method_58424146()) {
            this.I_field_5a = false;
            this.I_field_30d8564c = null;
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.autopilot.stopped")));
            return;
        }
        if (iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_82bc9266().orElse(null) != this.I_field_30d8564c) {
            this.I_field_5a = false;
            this.I_field_30d8564c = null;
        }
    };

    private void I_method_ce6138cc() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    public IIiIIiII_Class37() {
        I_field_de353b81 = this;
        this.I_method_ce6138cc();
    }

    public void I_method_27941b3e(Vec3d vec3d) {
        if (vec3d == null || !iiIiiIiIi_Class438.I_method_1047da03()) {
            return;
        }
        this.i_method_ce6fc4ac();
        BlockPos blockPos = BlockPos.ofFloored((Position)vec3d);
        this.I_field_30d8564c = new iiiIiiiii_Class480(blockPos);
        this.I_field_5a = true;
        iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(this.I_field_30d8564c);
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.autopilot.start", vec3d.getX(), vec3d.getY(), vec3d.getZ())));
    }

    public IIIiiIIi_Class26 I_method_4ed767ab() {
        return IIIiiIiI_Class27.I_method_209cd841("autopilot").I_method_b3f941e4("ap", "pilot", "\u0430\u0432\u0442\u043e\u043f\u0438\u043b\u043e\u0442", "\u043f\u0438\u043b\u043e\u0442").i_method_cfe1a061("commands.autopilot.description").i_method_3d6e11d9("x", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIiIIiII_Class37::I_method_a23b1441)).i_method_3d6e11d9("y", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIiIIiII_Class37::I_method_a23b1441)).i_method_3d6e11d9("z", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_e930dfcb().I_method_2619a44a(IIiIIiII_Class37::I_method_a23b1441)).I_method_16f05c8a(this::I_method_3e18b34d).I_method_9111538b();
    }

    private static IIiIIIIi_Class34 I_method_a23b1441(String string) {
        try {
            Double.parseDouble(string);
            return IIiIIIIi_Class34.I_method_12fc454a(string);
        }
        catch (NumberFormatException numberFormatException) {
            return IIiIIIIi_Class34.I_method_c9d442bc(IiIiIIII_Class81.I_method_f25a980a("commands.autopilot.invalid"));
        }
    }

    @Compile
    private void I_method_3e18b34d(IIIiiIii_Class28 iIIiiIii_Class28) {
        String string = (String)iIIiiIii_Class28.I_method_557e5bfb().get(0);
        String string2 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(1);
        String string3 = (String)iIIiiIii_Class28.I_method_557e5bfb().get(2);
        if (string == null || string2 == null || string3 == null) {
            if (this.I_field_5a) {
                this.i_method_ce6fc4ac();
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.autopilot.stopping")));
            } else {
                iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.autopilot.not_active")));
            }
            return;
        }
        try {
            this.I_method_27941b3e(new Vec3d(Double.parseDouble(string), Double.parseDouble(string2), Double.parseDouble(string3)));
        }
        catch (NumberFormatException numberFormatException) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.autopilot.invalid")));
        }
    }

    private void i_method_ce6fc4ac() {
        iiiIiiiii_Class480 iiiIiiiii_Class4802 = this.I_field_30d8564c;
        this.I_field_30d8564c = null;
        this.I_field_5a = false;
        if (iiiIiiiii_Class4802 != null && iiIiiIiIi_Class438.I_method_1047da03() && iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_82bc9266().orElse(null) == iiiIiiiii_Class4802) {
            iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7d4e61ff();
        }
    }

    @Generated
    public static IIiIIiII_Class37 I_method_b34f53cb() {
        return I_field_de353b81;
    }
}

