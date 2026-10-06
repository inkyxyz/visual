package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IIIiiIii_Class28;
import rockstar.client.IIiIIIIi_Class34;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.iIIiIIiIi_Class294;
import ua.mintantileak.spk.Compile;

public class IIiiiIii_Class60
implements iIIiIIiIi_Class294 {
    private Vec3d I_field_5bba0d50;

    @Compile
    public IIIiiIIi_Class26 I_method_b611678b() {
        return IIIiiIiI_Class27.I_method_fa8865f9("vclip", iIIiiIiI_Class27 -> iIIiiIiI_Class27.I_method_b3f941e4("v", "verticalclip").i_method_cfe1a061("commands.vclip.description").i_method_3d6e11d9("distance", iIIiiiii_Class32 -> iIIiiiii_Class32.I_method_2619a44a(string -> {
            try {
                return IIiIIIIi_Class34.I_method_12fc454a(Double.parseDouble(string));
            }
            catch (NumberFormatException numberFormatException) {
                return IIiIIIIi_Class34.I_method_c9d442bc(IiIiIIII_Class81.I_method_f25a980a("commands.vclip.invalid"));
            }
        })).I_method_16f05c8a(this::I_method_be1eaf6d)).I_method_9111538b();
    }

    @Compile
    private void I_method_be1eaf6d(IIIiiIii_Class28 iIIiiIii_Class28) {
        double d = (Double)iIIiiIii_Class28.I_method_557e5bfb().getFirst();
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Vec3d vec3d = minecraftClient.player.getPos();
        minecraftClient.player.setPosition(vec3d.add(0.0, d, 0.0));
    }
}

