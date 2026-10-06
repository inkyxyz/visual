package rockstar.client;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import lombok.Generated;
import ua.mintantileak.spk.Compile;

public class IiIIiiIII_Class153 {
    public static final int I_field_49 = 0;
    public static final int i_field_49 = 1;
    public static final int II_field_49 = 2;
    protected BufferedInputStream I_field_43e9fad8;
    protected int Ii_field_49;
    protected int iI_field_49;
    protected int ii_field_49;
    protected boolean I_field_5a;
    protected int III_field_49;
    protected int IIi_field_49 = 1;
    protected int[] I_field_b4e;
    protected int[] i_field_b4e;
    protected int[] II_field_b4e;
    protected int IiI_field_49;
    protected int Iii_field_49;
    protected int iII_field_49;
    protected int iIi_field_49;
    protected boolean i_field_5a;
    protected boolean II_field_5a;
    protected int iiI_field_49;
    protected int iii_field_49;
    protected int IIII_field_49;
    protected int IIIi_field_49;
    protected int IIiI_field_49;
    protected Rectangle I_field_62d7bc3e;
    protected BufferedImage I_field_60c2b845;
    protected BufferedImage i_field_60c2b845;
    protected byte[] I_field_b47 = new byte[256];
    protected int IIii_field_49 = 0;
    protected int IiII_field_49 = 0;
    protected int IiIi_field_49 = 0;
    protected boolean Ii_field_5a = false;
    protected int IiiI_field_49 = 0;
    protected int Iiii_field_49;
    protected static final int iIII_field_49 = 4096;
    protected short[] I_field_b58;
    protected byte[] i_field_b47;
    protected byte[] II_field_b47;
    protected byte[] Ii_field_b47;
    protected ArrayList<Nested1_452e1420> I_field_294d5d30;
    protected int iIIi_field_49;

    public int I_method_2aeac077(int n) {
        this.IiiI_field_49 = -1;
        if (n >= 0 && n < this.iIIi_field_49) {
            this.IiiI_field_49 = this.I_field_294d5d30.get((int)n).I_field_49;
        }
        return this.IiiI_field_49;
    }

    public BufferedImage I_method_7a802dc() {
        return this.I_method_f5d6ced7(0);
    }

    protected void I_method_8dc57e5f() {
        int n = 0;
        int[] nArray = ((DataBufferInt)this.I_field_60c2b845.getRaster().getDataBuffer()).getData();
        if (this.IiIi_field_49 > 0) {
            if (this.IiIi_field_49 == 3) {
                n = this.iIIi_field_49 - 2;
                this.i_field_60c2b845 = n > 0 ? this.I_method_f5d6ced7(n - 1) : null;
            }
            if (this.i_field_60c2b845 != null) {
                int[] nArray2 = ((DataBufferInt)this.i_field_60c2b845.getRaster().getDataBuffer()).getData();
                System.arraycopy(nArray2, 0, nArray, 0, this.iI_field_49 * this.ii_field_49);
                if (this.IiIi_field_49 == 2) {
                    Graphics2D graphics2D = this.I_field_60c2b845.createGraphics();
                    Color color = this.Ii_field_5a ? new Color(0, 0, 0, 0) : new Color(this.iII_field_49);
                    graphics2D.setColor(color);
                    graphics2D.setComposite(AlphaComposite.Src);
                    graphics2D.fill(this.I_field_62d7bc3e);
                    graphics2D.dispose();
                }
            }
        }
        n = 1;
        int n2 = 8;
        int n3 = 0;
        for (int i = 0; i < this.IIiI_field_49; ++i) {
            int n4 = i;
            if (this.II_field_5a) {
                if (n3 >= this.IIiI_field_49) {
                    switch (++n) {
                        case 2: {
                            n3 = 4;
                            break;
                        }
                        case 3: {
                            n3 = 2;
                            n2 = 4;
                            break;
                        }
                        case 4: {
                            n3 = 1;
                            n2 = 2;
                        }
                    }
                }
                n4 = n3;
                n3 += n2;
            }
            if ((n4 += this.IIII_field_49) >= this.ii_field_49) continue;
            int n5 = n4 * this.iI_field_49;
            int n6 = n5 + this.iii_field_49;
            int n7 = n6 + this.IIIi_field_49;
            if (n5 + this.iI_field_49 < n7) {
                n7 = n5 + this.iI_field_49;
            }
            int n8 = i * this.IIIi_field_49;
            while (n6 < n7) {
                int n9;
                int n10;
                if ((n10 = this.II_field_b4e[n9 = this.Ii_field_b47[n8++] & 0xFF]) != 0) {
                    nArray[n6] = n10;
                }
                ++n6;
            }
        }
    }

    public BufferedImage I_method_f5d6ced7(int n) {
        BufferedImage bufferedImage = null;
        if (n >= 0 && n < this.iIIi_field_49) {
            bufferedImage = this.I_field_294d5d30.get((int)n).I_field_60c2b845;
        }
        return bufferedImage;
    }

    public Dimension I_method_79f8467e() {
        return new Dimension(this.iI_field_49, this.ii_field_49);
    }

    public int I_method_3ef3e246(BufferedInputStream bufferedInputStream) {
        this.II_method_2af944e2();
        if (bufferedInputStream != null) {
            this.I_field_43e9fad8 = bufferedInputStream;
            this.ii_method_2ccac0e2();
            if (!this.I_method_8dc57e63()) {
                this.Ii_method_2b07d0c2();
                if (this.iIIi_field_49 < 0) {
                    this.Ii_field_49 = 1;
                }
            }
        } else {
            this.Ii_field_49 = 2;
        }
        try {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return this.Ii_field_49;
    }

    public int I_method_eadb4d87(InputStream inputStream) {
        this.II_method_2af944e2();
        if (inputStream != null) {
            if (!(inputStream instanceof BufferedInputStream)) {
                inputStream = new BufferedInputStream(inputStream);
            }
            this.I_field_43e9fad8 = (BufferedInputStream)inputStream;
            this.ii_method_2ccac0e2();
            if (!this.I_method_8dc57e63()) {
                this.Ii_method_2b07d0c2();
                if (this.iIIi_field_49 < 0) {
                    this.Ii_field_49 = 1;
                }
            }
        } else {
            this.Ii_field_49 = 2;
        }
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return this.Ii_field_49;
    }

    public int I_method_37a16e5c(String string) {
        this.Ii_field_49 = 0;
        try {
            string = string.trim().toLowerCase();
            if (string.contains("file:") || string.indexOf(":/") > 0) {
                URL uRL = new URL(string);
                this.I_field_43e9fad8 = new BufferedInputStream(uRL.openStream());
            } else {
                this.I_field_43e9fad8 = new BufferedInputStream(new FileInputStream(string));
            }
            this.Ii_field_49 = this.I_method_3ef3e246(this.I_field_43e9fad8);
        }
        catch (IOException iOException) {
            this.Ii_field_49 = 2;
        }
        return this.Ii_field_49;
    }

    protected void i_method_8dd40a3f() {
        int n;
        int n2 = -1;
        int n3 = this.IIIi_field_49 * this.IIiI_field_49;
        if (this.Ii_field_b47 == null || this.Ii_field_b47.length < n3) {
            this.Ii_field_b47 = new byte[n3];
        }
        if (this.I_field_b58 == null) {
            this.I_field_b58 = new short[4096];
        }
        if (this.i_field_b47 == null) {
            this.i_field_b47 = new byte[4096];
        }
        if (this.II_field_b47 == null) {
            this.II_field_b47 = new byte[4097];
        }
        int n4 = this.I_method_8dc57e52();
        int n5 = 1 << n4;
        int n6 = n5 + 1;
        int n7 = n5 + 2;
        int n8 = n2;
        int n9 = n4 + 1;
        int n10 = (1 << n9) - 1;
        for (n = 0; n < n5; ++n) {
            this.I_field_b58[n] = 0;
            this.i_field_b47[n] = (byte)n;
        }
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        while (n18 < n3) {
            if (n13 == 0) {
                if (n16 < n9) {
                    if (n15 == 0) {
                        n15 = this.i_method_8dd40a32();
                        if (n15 <= 0) break;
                        n11 = 0;
                    }
                    n17 += (this.I_field_b47[n11] & 0xFF) << n16;
                    n16 += 8;
                    ++n11;
                    --n15;
                    continue;
                }
                n = n17 & n10;
                n17 >>= n9;
                n16 -= n9;
                if (n > n7 || n == n6) break;
                if (n == n5) {
                    n9 = n4 + 1;
                    n10 = (1 << n9) - 1;
                    n7 = n5 + 2;
                    n8 = n2;
                    continue;
                }
                if (n8 == n2) {
                    this.II_field_b47[n13++] = this.i_field_b47[n];
                    n8 = n;
                    n14 = n;
                    continue;
                }
                int n19 = n;
                if (n == n7) {
                    this.II_field_b47[n13++] = (byte)n14;
                    n = n8;
                }
                while (n > n5) {
                    this.II_field_b47[n13++] = this.i_field_b47[n];
                    n = this.I_field_b58[n];
                }
                n14 = this.i_field_b47[n] & 0xFF;
                if (n7 >= 4096) {
                    this.II_field_b47[n13++] = (byte)n14;
                    continue;
                }
                this.II_field_b47[n13++] = (byte)n14;
                this.I_field_b58[n7] = (short)n8;
                this.i_field_b47[n7] = (byte)n14;
                if ((++n7 & n10) == 0 && n7 < 4096) {
                    ++n9;
                    n10 += n7;
                }
                n8 = n19;
            }
            this.Ii_field_b47[n12++] = this.II_field_b47[--n13];
            ++n18;
        }
        for (n18 = n12; n18 < n3; ++n18) {
            this.Ii_field_b47[n18] = 0;
        }
    }

    protected boolean I_method_8dc57e63() {
        return this.Ii_field_49 != 0;
    }

    @Compile(obfuscation=4)
    protected void II_method_2af944e2() {
        this.Ii_field_49 = 0;
        this.iIIi_field_49 = 0;
        this.I_field_294d5d30 = new ArrayList();
        this.I_field_b4e = null;
        this.i_field_b4e = null;
    }

    protected int I_method_8dc57e52() {
        int n = 0;
        try {
            n = this.I_field_43e9fad8.read();
        }
        catch (IOException iOException) {
            this.Ii_field_49 = 1;
        }
        return n;
    }

    protected int i_method_8dd40a32() {
        int n = 0;
        this.IIii_field_49 = this.I_method_8dc57e52();
        if (this.IIii_field_49 > 0) {
            try {
                int n2;
                for (n = 0; n < this.IIii_field_49 && (n2 = this.I_field_43e9fad8.read(this.I_field_b47, n, this.IIii_field_49 - n)) != -1; n += n2) {
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
            if (n < this.IIii_field_49) {
                this.Ii_field_49 = 1;
            }
        }
        return n;
    }

    protected int[] I_method_326d50e0(int n) {
        int n2 = 3 * n;
        int[] nArray = null;
        byte[] byArray = new byte[n2];
        int n3 = 0;
        try {
            n3 = this.I_field_43e9fad8.read(byArray);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (n3 < n2) {
            this.Ii_field_49 = 1;
        } else {
            nArray = new int[256];
            int n4 = 0;
            int n5 = 0;
            while (n4 < n) {
                int n6 = byArray[n5++] & 0xFF;
                int n7 = byArray[n5++] & 0xFF;
                int n8 = byArray[n5++] & 0xFF;
                nArray[n4++] = 0xFF000000 | n6 << 16 | n7 << 8 | n8;
            }
        }
        return nArray;
    }

    protected void Ii_method_2b07d0c2() {
        boolean bl = false;
        block10: while (!bl && !this.I_method_8dc57e63()) {
            int n = this.I_method_8dc57e52();
            switch (n) {
                case 44: {
                    this.III_method_343e4ebf();
                    continue block10;
                }
                case 33: {
                    n = this.I_method_8dc57e52();
                    switch (n) {
                        case 249: {
                            this.iI_method_2cbc3502();
                            continue block10;
                        }
                        case 255: {
                            this.i_method_8dd40a32();
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i = 0; i < 11; ++i) {
                                stringBuilder.append((char)this.I_field_b47[i]);
                            }
                            if (stringBuilder.toString().equals("NETSCAPE2.0")) {
                                this.IiI_method_36013edf();
                                continue block10;
                            }
                            this.iII_method_6ad9629f();
                            continue block10;
                        }
                    }
                    this.iII_method_6ad9629f();
                    continue block10;
                }
                case 59: {
                    bl = true;
                    continue block10;
                }
                case 0: {
                    continue block10;
                }
            }
            this.Ii_field_49 = 1;
        }
    }

    protected void iI_method_2cbc3502() {
        this.I_method_8dc57e52();
        int n = this.I_method_8dc57e52();
        this.IiII_field_49 = (n & 0x1C) >> 2;
        if (this.IiII_field_49 == 0) {
            this.IiII_field_49 = 1;
        }
        this.Ii_field_5a = (n & 1) != 0;
        this.IiiI_field_49 = this.II_method_2af944d5() * 10;
        this.Iiii_field_49 = this.I_method_8dc57e52();
        this.I_method_8dc57e52();
    }

    protected void ii_method_2ccac0e2() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            stringBuilder.append((char)this.I_method_8dc57e52());
        }
        if (!stringBuilder.toString().startsWith("GIF")) {
            this.Ii_field_49 = 1;
            return;
        }
        this.IIi_method_344cda9f();
        if (this.I_field_5a && !this.I_method_8dc57e63()) {
            this.I_field_b4e = this.I_method_326d50e0(this.III_field_49);
            this.Iii_field_49 = this.I_field_b4e[this.IiI_field_49];
        }
    }

    protected void III_method_343e4ebf() {
        this.iii_field_49 = this.II_method_2af944d5();
        this.IIII_field_49 = this.II_method_2af944d5();
        this.IIIi_field_49 = this.II_method_2af944d5();
        this.IIiI_field_49 = this.II_method_2af944d5();
        int n = this.I_method_8dc57e52();
        this.i_field_5a = (n & 0x80) != 0;
        this.II_field_5a = (n & 0x40) != 0;
        this.iiI_field_49 = 2 << (n & 7);
        if (this.i_field_5a) {
            this.i_field_b4e = this.I_method_326d50e0(this.iiI_field_49);
            this.II_field_b4e = this.i_field_b4e;
        } else {
            this.II_field_b4e = this.I_field_b4e;
            if (this.IiI_field_49 == this.Iiii_field_49) {
                this.Iii_field_49 = 0;
            }
        }
        int n2 = 0;
        if (this.Ii_field_5a) {
            n2 = this.II_field_b4e[this.Iiii_field_49];
            this.II_field_b4e[this.Iiii_field_49] = 0;
        }
        if (this.II_field_b4e == null) {
            this.Ii_field_49 = 1;
        }
        if (this.I_method_8dc57e63()) {
            return;
        }
        this.i_method_8dd40a3f();
        this.iII_method_6ad9629f();
        if (this.I_method_8dc57e63()) {
            return;
        }
        ++this.iIIi_field_49;
        this.I_field_60c2b845 = new BufferedImage(this.iI_field_49, this.ii_field_49, 3);
        this.I_method_8dc57e5f();
        this.I_field_294d5d30.add(new Nested1_452e1420(this.I_field_60c2b845, this.IiiI_field_49));
        if (this.Ii_field_5a) {
            this.II_field_b4e[this.Iiii_field_49] = n2;
        }
        this.Iii_method_360fcabf();
    }

    protected void IIi_method_344cda9f() {
        this.iI_field_49 = this.II_method_2af944d5();
        this.ii_field_49 = this.II_method_2af944d5();
        int n = this.I_method_8dc57e52();
        this.I_field_5a = (n & 0x80) != 0;
        this.III_field_49 = 2 << (n & 7);
        this.IiI_field_49 = this.I_method_8dc57e52();
        this.iIi_field_49 = this.I_method_8dc57e52();
    }

    protected void IiI_method_36013edf() {
        do {
            this.i_method_8dd40a32();
            if (this.I_field_b47[0] != 1) continue;
            int n = this.I_field_b47[1] & 0xFF;
            int n2 = this.I_field_b47[2] & 0xFF;
            this.IIi_field_49 = n2 << 8 | n;
        } while (this.IIii_field_49 > 0 && !this.I_method_8dc57e63());
    }

    protected int II_method_2af944d5() {
        return this.I_method_8dc57e52() | this.I_method_8dc57e52() << 8;
    }

    protected void Iii_method_360fcabf() {
        this.IiIi_field_49 = this.IiII_field_49;
        this.I_field_62d7bc3e = new Rectangle(this.iii_field_49, this.IIII_field_49, this.IIIi_field_49, this.IIiI_field_49);
        this.i_field_60c2b845 = this.I_field_60c2b845;
        this.iII_field_49 = this.Iii_field_49;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        this.i_field_b4e = null;
    }

    protected void iII_method_6ad9629f() {
        do {
            this.i_method_8dd40a32();
        } while (this.IIii_field_49 > 0 && !this.I_method_8dc57e63());
    }

    @Generated
    public int Ii_method_2b07d0b5() {
        return this.iIIi_field_49;
    }

    public static class Nested1_452e1420 {
        public BufferedImage I_field_60c2b845;
        public int I_field_49;

        public Nested1_452e1420(BufferedImage bufferedImage, int n) {
            this.I_field_60c2b845 = bufferedImage;
            this.I_field_49 = n;
        }
    }
}
