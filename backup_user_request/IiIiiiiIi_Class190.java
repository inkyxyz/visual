package rockstar.client;

import pyrock.utility.render.ColorRGBA;
import rockstar.client.IIII;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIi_Class2;
import rockstar.client.IIiii_Class8;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIIi_Class10;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIIiI_Class179;
import rockstar.client.IiIiiIiIi_Class182;
import rockstar.client.IiIiiIiii_Class184;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public class IiIiiiiIi_Class190
extends IiIiiIiii_Class184 {
    private iiI_Class7 I_field_b5845eac;

    public IiIiiiiIi_Class190(MultiSelectSetting iIiiiiiii_Class128) {
        super(iIiiiiiii_Class128, "default");
    }

    @Override
    public iiI_Class7 content(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        if (this.I_field_b5845eac == null) {
            iii_Class8 iii_Class83 = IiIiiIiIi_Class182.I_method_4b294f34(15.0f, IIII.I_method_12c9a0cb(0.0f, 5.0f, 0.0f, 4.0f), 4.0f).I_method_483797dd(IIi_Class2.i_field_b5755e8c).I_method_f136b1d8((iII, iii_Class82) -> {
                ColorRGBA colorRGBA = IiiiiIIIi_Class242.i_method_5dfec6e();
                ColorRGBA colorRGBA2 = colorRGBA.withAlpha(71.4f);
                ColorRGBA colorRGBA3 = colorRGBA.withAlpha(0.0f);
                float f = iiIiiIIII_Class177.i_method_d8dd7b75().I_method_6ac4da6f();
                iII.drawSquircle(iii_Class82.x(), iii_Class82.y(), iii_Class82.w() * 0.69f, iii_Class82.h(), 2.0f, IIiii_Class8.II_method_35289fb8(f, f), new IiIIi_Class10(colorRGBA2, colorRGBA2, colorRGBA3, colorRGBA3));
            });
            iii_Class83.I_method_8939bffd(IiIiiIiIi_Class182.I_method_5c799830("logo", 8.0f, IiiiiIIIi_Class242::i_method_5dfec6e, () -> -10.0f * (1.0f - this.animation.I_method_6ac4da6f())));
            iii_Class83.I_method_8939bffd(new IiIiiIIiI_Class179(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), iiIiiIIII_Class177::I_method_fc79a821, IiiiiIIIi_Class242::iI_method_8e08d3b1, () -> 10.0f * (1.0f - this.animation.I_method_6ac4da6f())));

            // Divider |
            iii_Class83.I_method_8939bffd(new IiIiiIIiI_Class179(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5f), () -> "|", () -> new ColorRGBA(255.0F, 255.0F, 255.0F, 60.0F)));

            // FPS Counter
            iii_Class83.I_method_8939bffd(new IiIiiIIiI_Class179(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), () -> net.minecraft.client.MinecraftClient.getInstance().getCurrentFps() + " FPS", () -> new ColorRGBA(90.0F, 245.0F, 160.0F, 235.0F)));

            // Divider |
            iii_Class83.I_method_8939bffd(new IiIiiIIiI_Class179(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5f), () -> "|", () -> new ColorRGBA(255.0F, 255.0F, 255.0F, 60.0F)));

            // Ping Counter
            iii_Class83.I_method_8939bffd(new IiIiiIIiI_Class179(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), () -> {
                net.minecraft.client.MinecraftClient mc = net.minecraft.client.MinecraftClient.getInstance();
                if (mc.player != null && mc.player.networkHandler != null) {
                    var entry = mc.player.networkHandler.getPlayerListEntry(mc.player.getUuid());
                    if (entry != null) {
                        return entry.getLatency() + " ms";
                    }
                }
                return "0 ms";
            }, IiiiiIIIi_Class242::I_method_7df8e08e));

            // Divider |
            iii_Class83.I_method_8939bffd(new IiIiiIIiI_Class179(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.5f), () -> "|", () -> new ColorRGBA(255.0F, 255.0F, 255.0F, 60.0F)));

            // Local Time
            iii_Class83.I_method_8939bffd(new IiIiiIIiI_Class179(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0f), () -> java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")), () -> new ColorRGBA(220.0F, 225.0F, 240.0F, 210.0F)));

            this.I_field_b5845eac = iii_Class83;
        }
        return this.I_field_b5845eac;
    }

    @Override
    public boolean canShow() {
        return true;
    }
}

