package rockstar.client;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.XRayModule;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.IiIiiIIii_Class180;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiI_Class7;
import rockstar.client.iii_Class8;

public class IiiIIIiII_Class197
extends IiIiiIIii_Class180
implements iIIiIIiIi_Class294 {
    private static final float I_field_46 = 114.0f;
    private static final float i_field_46 = 15.0f;
    private static final float II_field_46 = 90.0f;
    private static final float Ii_field_46 = 32.0f;
    private static final float iI_field_46 = 25.0f;
    private static final float ii_field_46 = 15.0f;
    private static final float III_field_46 = 0.7f;
    static final Item[] I_field_e4463c91 = new Item[]{Items.ANCIENT_DEBRIS, Items.DIAMOND_ORE, Items.GOLD_ORE, Items.LAPIS_ORE};
    static final String[] I_field_6dccaaa5 = new String[]{IiIiIIII_Class81.I_method_f25a980a("hud.xray.ancient_debris") + ": ", IiIiIIII_Class81.I_method_f25a980a("hud.xray.diamond_ore") + ": ", IiIiIIII_Class81.I_method_f25a980a("hud.xray.gold_ore") + ": ", IiIiIIII_Class81.I_method_f25a980a("hud.xray.lapis_ore") + ": "};
    private iii_Class8 I_field_b584628c;

    public IiiIIIiII_Class197(MultiSelectSetting iIiiiiiii_Class128) {
        super(iIiiiiiii_Class128, "xray");
    }

    @Override
    public void prepare(IiIiiIIII_Class177 iiIiiIIII_Class177) {
    }

    public iii_Class8 I_method_b529509d(IiIiiIIII_Class177 iiIiiIIII_Class177) {
        if (this.I_field_b584628c == null) {
            this.I_field_b584628c = new Nested1_8770a409(iiIiiIIII_Class177);
        }
        return this.I_field_b584628c;
    }

    @Override
    public boolean canShow() {
        return this.I_method_802cd46b(this.I_method_a60682b5());
    }

    XRayModule I_method_a60682b5() {
        return RockstarClient.getInstance().getModuleManager().getModule(XRayModule.class);
    }

    int I_method_856e2b6f(XRayModule iModuleManager, int n) {
        return switch (n) {
            case 0 -> iModuleManager.Ii_method_e504b535();
            case 1 -> iModuleManager.II_method_e4f62955();
            case 2 -> iModuleManager.iI_method_e6b91975();
            case 3 -> iModuleManager.ii_method_e6c7a555();
            default -> 0;
        };
    }

    private int I_method_802cd45a(XRayModule iModuleManager) {
        int n = 0;
        if (iModuleManager.Ii_method_e504b535() > 0) {
            ++n;
        }
        if (iModuleManager.II_method_e4f62955() > 0) {
            ++n;
        }
        if (iModuleManager.iI_method_e6b91975() > 0) {
            ++n;
        }
        if (iModuleManager.ii_method_e6c7a555() > 0) {
            ++n;
        }
        return n;
    }

    private boolean I_method_802cd46b(XRayModule iModuleManager) {
        return (iModuleManager.Ii_method_e504b535() > 0 || iModuleManager.II_method_e4f62955() > 0 || iModuleManager.iI_method_e6b91975() > 0 || iModuleManager.ii_method_e6c7a555() > 0) && iModuleManager.isEnabled();
    }

    float I_method_802cd457(XRayModule iModuleManager) {
        String string = IiIiIIII_Class81.I_method_f25a980a("hud.xray.found_diamonds") + ": " + iModuleManager.II_method_e4f62955();
        return Math.min(32.0f + IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f).I_method_2c375926(string), 90.0f);
    }

    float i_method_1d45dc77(XRayModule iModuleManager) {
        return 25.0f + (float)this.I_method_802cd45a(iModuleManager) * 15.0f;
    }

    final class Nested1_8770a409
    extends iii_Class8 {
        private final IiIiiIIII_Class177 I_field_467a06ac;
        private final Nested1_fc1c6860 I_field_cb287a27;
        private final Nested1_8770a3e9 I_field_99e6cca6;
        private final Nested1_8770a3e9 i_field_99e6cca6;
        private final Nested1_fc1c6880[] I_field_8897f8c;

        Nested1_8770a409(IiIiiIIII_Class177 iiIiiIIII_Class177) {
            this.I_field_cb287a27 = new Nested1_fc1c6860();
            this.I_field_99e6cca6 = new Nested1_8770a3e9(IiiIIIiII_Class197.this, IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), () -> IiIiIIII_Class81.I_method_f25a980a("hud.xray.found_diamonds") + ": " + IiiIIIiII_Class197.this.I_method_a60682b5().II_method_e4f62955(), () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * IiiIIIiII_Class197.this.animation.I_method_6ac4da6f()), this::i_method_8b6a0935);
            this.i_field_99e6cca6 = new Nested1_8770a3e9(IiiIIIiII_Class197.this, IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), () -> IiIiIIII_Class81.I_method_f25a980a("hud.xray.found") + ": ", () -> IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * this.iII_method_290cf90a()), this::II_method_e0232434);
            this.I_field_8897f8c = new Nested1_fc1c6880[]{new Nested1_fc1c6880(0), new Nested1_fc1c6880(1), new Nested1_fc1c6880(2), new Nested1_fc1c6880(3)};
            this.I_field_467a06ac = iiIiiIIII_Class177;
            this.i_method_8c7d3515(48.0f, 15.0f);
            this.Ii_method_25479968(false);
            this.iii_method_df275535();
            this.snapSize();
            this.I_method_dafddb75(this.I_field_cb287a27);
            this.I_method_dafddb75(this.I_field_99e6cca6);
            this.I_method_dafddb75(this.i_field_99e6cca6);
            for (Nested1_fc1c6880 nested1_fc1c6880 : this.I_field_8897f8c) {
                this.I_method_dafddb75(nested1_fc1c6880);
            }
        }

        @Override
        protected void measure() {
            XRayModule iModuleManager = IiiIIIiII_Class197.this.I_method_a60682b5();
            this.prefW = this.I_field_467a06ac.II_method_97ffcce6() ? 114.0f : IiiIIIiII_Class197.this.I_method_802cd457(iModuleManager);
            this.prefH = this.I_field_467a06ac.II_method_97ffcce6() ? IiiIIIiII_Class197.this.i_method_1d45dc77(iModuleManager) : 15.0f;
        }

        @Override
        protected void onTick(float f, float f2, float f3) {
            this.I_method_38e5328().removeIf(iiI_Class72 -> iiI_Class72.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866);
            this.II_method_57518862();
            for (iiI_Class7 iiI_Class73 : this.I_method_38e5328()) {
                iiI_Class73.tick(f, f2, f3);
            }
        }

        @Override
        protected void drawChildren(III iII, float f) {
            for (iiI_Class7 iiI_Class72 : this.I_method_38e5328()) {
                if (!iiI_Class72.inFlow()) continue;
                iiI_Class72.draw(iII, f);
            }
        }

        private void II_method_57518862() {
            float f = IiiIIIiII_Class197.this.animation.I_method_6ac4da6f();
            float f2 = this.x() + 25.0f;
            this.I_field_cb287a27.setSlot(this.x() - 6.0f + 10.0f * f, this.y() + 4.0f, 7.0f, 7.0f);
            String string = IiIiIIII_Class81.I_method_f25a980a("hud.xray.found_diamonds") + ": " + IiiIIIiII_Class197.this.I_method_a60682b5().II_method_e4f62955();
            IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
            this.I_field_99e6cca6.setSlot(f2 - 10.0f * f, this.y() + 5.0f, iIiIIi_Class10.I_method_2c375926(string), iIiIIi_Class10.I_method_a649725c());
            IIiIIi_Class10 iIiIIi_Class102 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f);
            String string2 = IiIiIIII_Class81.I_method_f25a980a("hud.xray.found") + ": ";
            this.i_field_99e6cca6.setSlot(f2 - 11.0f * f, this.y() + 10.0f, iIiIIi_Class102.I_method_2c375926(string2), iIiIIi_Class102.I_method_a649725c());
            int n = 0;
            for (Nested1_fc1c6880 nested1_fc1c6880 : this.I_field_8897f8c) {
                int n2 = IiiIIIiII_Class197.this.I_method_856e2b6f(IiiIIIiII_Class197.this.I_method_a60682b5(), nested1_fc1c6880.I_field_49);
                float f3 = this.y() + 20.0f + (float)n * 15.0f;
                nested1_fc1c6880.setSlot(f2 - 11.0f * f, f3, 89.0f, 15.0f);
                if (n2 <= 0) continue;
                ++n;
            }
        }

        private boolean i_method_8b6a0935() {
            return this.iII_method_290cf90a() == 0.0f;
        }

        private boolean II_method_e0232434() {
            return this.iII_method_290cf90a() > 0.7f;
        }

        private float iII_method_290cf90a() {
            return this.I_field_467a06ac.I_method_c3480795().I_method_6ac4da6f();
        }

        private void I_method_dafddb75(iiI_Class7 iiI_Class72) {
            iiI_Class72.lifeMotion(IIii_Class4.I_method_48883e1f(1L));
            this.I_method_8939bffd(iiI_Class72);
        }
    }

    final class Nested1_fc1c6880
    extends iiI_Class7 {
        final int I_field_49;

        Nested1_fc1c6880(int n) {
            this.I_field_49 = n;
            this.snapPosition();
            this.snapSize();
            this.interactive(false);
        }

        @Override
        protected void drawSelf(III iII, float f) {
            IiIiiIIII_Class177 iiIiiIIII_Class177 = RockstarClient.getInstance().I_method_35687482().I_method_35128395();
            if (iiIiiIIII_Class177 == null || iiIiiIIII_Class177.I_method_c3480795().I_method_6ac4da6f() <= 0.7f) {
                return;
            }
            XRayModule iModuleManager = IiiIIIiII_Class197.this.I_method_a60682b5();
            int n = IiiIIIiII_Class197.this.I_method_856e2b6f(iModuleManager, this.I_field_49);
            if (n == 0) {
                return;
            }
            iII.drawItem(I_field_e4463c91[this.I_field_49], this.x() - 1.0f, this.y(), 0.75f);
            iII.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0f), I_field_6dccaaa5[this.I_field_49] + n, this.x() + 15.0f, this.y() + 3.0f, IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * iiIiiIIII_Class177.I_method_c3480795().I_method_6ac4da6f() * 0.7f));
        }
    }

    final class Nested1_8770a3e9
    extends iiI_Class7 {
        private final IIiIIi_Class10 I_field_856d0221;
        private final Supplier<String> I_field_11b14ee4;
        private final Supplier<ColorRGBA> i_field_11b14ee4;
        private final BooleanSupplier I_field_7bf34412;

        Nested1_8770a3e9(IiiIIIiII_Class197 iiiIIIiII_Class197, IIiIIi_Class10 iIiIIi_Class10, Supplier<String> supplier, Supplier<ColorRGBA> supplier2, BooleanSupplier booleanSupplier) {
            this.I_field_856d0221 = iIiIIi_Class10;
            this.I_field_11b14ee4 = supplier;
            this.i_field_11b14ee4 = supplier2;
            this.I_field_7bf34412 = booleanSupplier;
            this.snapPosition();
            this.snapSize();
            this.interactive(false);
        }

        @Override
        protected void drawSelf(III iII, float f) {
            if (!this.I_field_7bf34412.getAsBoolean()) {
                return;
            }
            String string = this.I_field_11b14ee4.get();
            if (string != null && !string.isEmpty()) {
                iII.drawText(this.I_field_856d0221, string, this.x(), this.y(), this.i_field_11b14ee4.get());
            }
        }
    }

    final class Nested1_fc1c6860
    extends iiI_Class7 {
        Nested1_fc1c6860() {
            this.snapPosition();
            this.snapSize();
            this.interactive(false);
        }

        @Override
        protected void drawSelf(III iII, float f) {
            IiIiiIIII_Class177 iiIiiIIII_Class177 = RockstarClient.getInstance().I_method_35687482().I_method_35128395();
            if (iiIiiIIII_Class177 != null && iiIiiIIII_Class177.I_method_c3480795().I_method_6ac4da6f() != 0.0f) {
                return;
            }
            iII.drawRoundedRect(this.x(), this.y(), this.w(), this.h(), IIiii_Class8.I_method_893b2757(3.0f), new ColorRGBA(115.0f, 0.0f, 255.0f).withAlpha(255.0f * IiiIIIiII_Class197.this.animation.I_method_6ac4da6f()));
        }
    }
}

