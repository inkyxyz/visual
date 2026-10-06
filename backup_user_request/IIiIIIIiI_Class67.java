package rockstar.client;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import pyrock.events.game.BlockBreakEvent;
import pyrock.events.network.ReceivePacketEvent;
import rockstar.client.IIIiiiIii_Class60;
import rockstar.client.IIiIIIIii_Class68;
import rockstar.client.IIiIIIiII_Class69;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiiIiIiI_Class107;
import rockstar.client.iIIiIIiIi_Class294;

public class IIiIIIIiI_Class67
implements iIIiIIiIi_Class294 {
    private static final long I_field_4a = 5000L;
    public static final int I_field_49 = 36;
    private static final long i_field_4a = 1000L;
    private static final String I_field_523beb0a = "\u0423 \u0412\u0430\u0441 \u043a\u0443\u043f\u0438\u043b\u0438";
    private static final Pattern I_field_5fd3861f = Pattern.compile("(\\d[\\d.,\\u00A0]*\\d|\\d)\\s*(kkk|kk|k|\u043a\u043a\u043a|\u043a\u043a|\u043a|m|\u043c)?", 66);
    private final IiiIiIiI_Class107 I_field_dc0fb3c1 = new IiiIiIiI_Class107();
    private Supplier<IIIiiiIii_Class60> I_field_11b14ee4;
    private final long[] I_field_b4f = new long[36];
    private final long[] i_field_b4f = new long[36];
    private boolean I_field_5a;
    private long II_field_4a;
    private long Ii_field_4a;
    private long iI_field_4a;
    private long ii_field_4a;
    private long III_field_4a;
    private long IIi_field_4a = -1L;
    private long IiI_field_4a = -1L;
    private long Iii_field_4a;
    private int i_field_49;
    private int II_field_49;
    private long iII_field_4a;
    private final IiIIIiII_Class69<BlockBreakEvent> I_field_3d936f41 = blockBreakEvent -> {
        if (!this.I_field_5a) {
            return;
        }
        IIIiiiIii_Class60 iIIiiiIii_Class60 = this.I_field_11b14ee4.get();
        if (iIIiiiIii_Class60 == null || iIIiiiIii_Class60.I_method_5736ef15() != IIiIIIiII_Class69.I_field_e6bdd24c) {
            return;
        }
        this.Ii_method_96108ce2();
    };
    private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41 = receivePacketEvent -> {
        Object object;
        if (!this.I_field_5a || !((object = receivePacketEvent.getPacket()) instanceof GameMessageS2CPacket)) {
            return;
        }
        GameMessageS2CPacket gameMessageS2CPacket = (GameMessageS2CPacket)object;
        object = gameMessageS2CPacket.content().getString();
        if (!((String)object).contains(I_field_523beb0a)) {
            return;
        }
        long l = IIiIIIIiI_Class67.I_method_f1e4763d((String)object);
        if (l > 0L) {
            this.III_field_4a += l;
        }
    };

    public IIiIIIIiI_Class67(Supplier<IIIiiiIii_Class60> supplier) {
        this.I_field_11b14ee4 = supplier;
    }

    public void I_method_3ea4be3f() {
        this.I_field_5a = true;
        this.II_field_4a = System.currentTimeMillis();
        this.Ii_field_4a = 0L;
        this.iI_field_4a = 0L;
        this.ii_field_4a = 0L;
        this.III_field_4a = 0L;
        this.IIi_field_4a = -1L;
        this.IiI_field_4a = -1L;
        this.Iii_field_4a = 0L;
        this.I_field_dc0fb3c1.I_method_edc5910c();
        Arrays.fill(this.I_field_b4f, 0L);
        Arrays.fill(this.i_field_b4f, 0L);
        this.i_field_49 = 0;
        this.II_field_49 = 1;
        this.iII_field_4a = this.II_field_4a;
    }

    public void i_method_3eb34a1f() {
        this.I_field_5a = false;
        this.Ii_field_4a = System.currentTimeMillis();
    }

    public void II_method_96020102() {
        if (!this.I_field_5a) {
            return;
        }
        this.iI_method_97c4f122();
        this.ii_method_97d37d02();
    }

    public void Ii_method_96108ce2() {
        this.I_method_95f37ca4(1);
    }

    public void I_method_95f37ca4(int n) {
        if (!this.I_field_5a || n <= 0) {
            return;
        }
        this.iI_field_4a += (long)n;
        int n2 = this.i_field_49;
        this.I_field_b4f[n2] = this.I_field_b4f[n2] + (long)n;
    }

    public long I_method_3ea4be33() {
        if (this.II_field_4a == 0L) {
            return 0L;
        }
        return (this.I_field_5a ? System.currentTimeMillis() : this.Ii_field_4a) - this.II_field_4a;
    }

    public double I_method_3ea4be2d() {
        return this.I_method_95f369cd(this.iI_field_4a);
    }

    public double i_method_3eb34a0d() {
        return this.I_method_95f369cd(this.ii_field_4a);
    }

    private double I_method_95f369cd(double d) {
        long l = this.I_method_3ea4be33();
        if (l < 1000L) {
            return 0.0;
        }
        return d / ((double)l / 3600000.0);
    }

    public long[] I_method_59b9753e(IIiIIIIii_Class68 iIiIIIIii_Class68) {
        long[] lArray = iIiIIIIii_Class68 == IIiIIIIii_Class68.i_field_e6afc26c ? this.i_field_b4f : this.I_field_b4f;
        int n = Math.max(0, Math.min(this.II_field_49, 36) - 1);
        long[] lArray2 = new long[n];
        for (int i = 0; i < n; ++i) {
            int n2 = Math.floorMod(this.i_field_49 - n + i, 36);
            lArray2[i] = lArray[n2];
        }
        return lArray2;
    }

    public static float I_method_3ea4be2f() {
        return 5.0f;
    }

    private void iI_method_97c4f122() {
        long l = System.currentTimeMillis();
        while (l - this.iII_field_4a >= 5000L) {
            this.iII_field_4a += 5000L;
            this.i_field_49 = (this.i_field_49 + 1) % 36;
            this.I_field_b4f[this.i_field_49] = 0L;
            this.i_field_b4f[this.i_field_49] = 0L;
            if (this.II_field_49 >= 36) continue;
            ++this.II_field_49;
        }
    }

    private void ii_method_97d37d02() {
        long l = System.currentTimeMillis();
        if (l - this.Iii_field_4a < 1000L) {
            return;
        }
        this.Iii_field_4a = l;
        long l2 = this.I_field_dc0fb3c1.I_method_edc59100();
        if (l2 < 0L) {
            return;
        }
        if (this.IIi_field_4a < 0L) {
            this.IIi_field_4a = l2;
            this.IiI_field_4a = l2;
            return;
        }
        long l3 = l2 - this.IiI_field_4a;
        this.IiI_field_4a = l2;
        this.ii_field_4a = l2 - this.IIi_field_4a;
        if (l3 != 0L) {
            int n = this.i_field_49;
            this.i_field_b4f[n] = this.i_field_b4f[n] + l3;
        }
    }

    private static long I_method_f1e4763d(String string) {
        Matcher matcher = I_field_5fd3861f.matcher(string);
        long l = -1L;
        while (matcher.find()) {
            long l2;
            String string2 = matcher.group(1).replaceAll("[^\\d]", "");
            if (string2.isEmpty()) continue;
            try {
                l2 = Long.parseLong(string2);
            }
            catch (NumberFormatException numberFormatException) {
                continue;
            }
            String string3 = matcher.group(2);
            if (string3 != null) {
                l2 *= (switch (string3.toLowerCase(Locale.ROOT)) {
                    case "k", "\u043a" -> 1000L;
                    case "kk", "\u043a\u043a", "m", "\u043c" -> 1000000L;
                    case "kkk", "\u043a\u043a\u043a" -> 1000000000L;
                    default -> 1L;
                });
            }
            l = Math.max(l, l2);
        }
        return l;
    }

    public static String I_method_7644aadb(long l) {
        String string = l < 0L ? "-" : "+";
        return string + IIiIIIIiI_Class67.I_method_879a4a1(Math.abs(l));
    }

    public static String I_method_879a4a1(double d) {
        double d2 = Math.abs(d);
        if (d2 >= 1.0E9) {
            return IIiIIIIiI_Class67.i_method_d930f881(d / 1.0E9) + "kkk";
        }
        if (d2 >= 1000000.0) {
            return IIiIIIIiI_Class67.i_method_d930f881(d / 1000000.0) + "kk";
        }
        if (d2 >= 1000.0) {
            return IIiIIIIiI_Class67.i_method_d930f881(d / 1000.0) + "k";
        }
        return String.valueOf(Math.round(d));
    }

    private static String i_method_d930f881(double d) {
        String string = String.format(Locale.ROOT, "%.1f", d);
        return string.endsWith(".0") ? string.substring(0, string.length() - 2) : string;
    }

    public static String i_method_46fbfebb(long l) {
        long l2 = Math.max(0L, l) / 1000L;
        long l3 = l2 / 3600L;
        long l4 = l2 % 3600L / 60L;
        long l5 = l2 % 60L;
        return l3 > 0L ? String.format(Locale.ROOT, "%d:%02d:%02d", l3, l4, l5) : String.format(Locale.ROOT, "%d:%02d", l4, l5);
    }

    @Generated
    public IiiIiIiI_Class107 I_method_bf163df8() {
        return this.I_field_dc0fb3c1;
    }

    @Generated
    public Supplier<IIIiiiIii_Class60> I_method_47bf854d() {
        return this.I_field_11b14ee4;
    }

    @Generated
    public long[] I_method_95f30a86() {
        return this.I_field_b4f;
    }

    @Generated
    public long[] i_method_97b5faa6() {
        return this.i_field_b4f;
    }

    @Generated
    public boolean I_method_3ea4be43() {
        return this.I_field_5a;
    }

    @Generated
    public long i_method_3eb34a13() {
        return this.II_field_4a;
    }

    @Generated
    public long II_method_960200f6() {
        return this.Ii_field_4a;
    }

    @Generated
    public long Ii_method_96108cd6() {
        return this.iI_field_4a;
    }

    @Generated
    public long iI_method_97c4f116() {
        return this.ii_field_4a;
    }

    @Generated
    public long ii_method_97d37cf6() {
        return this.III_field_4a;
    }

    @Generated
    public long III_method_2a4d1693() {
        return this.IIi_field_4a;
    }

    @Generated
    public long IIi_method_2a5ba273() {
        return this.IiI_field_4a;
    }

    @Generated
    public long IiI_method_2c1006b3() {
        return this.Iii_field_4a;
    }

    @Generated
    public int I_method_3ea4be32() {
        return this.i_field_49;
    }

    @Generated
    public int i_method_3eb34a12() {
        return this.II_field_49;
    }

    @Generated
    public long Iii_method_2c1e9293() {
        return this.iII_field_4a;
    }

    @Generated
    public IiIIIiII_Class69<BlockBreakEvent> I_method_2099f978() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<ReceivePacketEvent> i_method_4a968998() {
        return this.i_field_3d936f41;
    }
}

