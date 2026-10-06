package rockstar.client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;

public final class iIIIiiIII_Class281 {
    private static final int IIi_field_49 = 1347375950;
    public final int I_field_49;
    public final int i_field_49;
    public final int II_field_49;
    public final int Ii_field_49;
    public final int iI_field_49;
    public final int ii_field_49;
    public final int III_field_49;
    private final float[] I_field_b4b;
    private final float[] i_field_b4b;
    private final float[] II_field_b4b;
    private final float[] Ii_field_b4b;
    private final float[] iI_field_b4b;
    private final float[] ii_field_b4b;
    private final float[] III_field_b4b;
    private final float[] IIi_field_b4b;
    private final float[] IiI_field_b4b;
    private final float[] Iii_field_b4b;
    private final float[] iII_field_b4b;
    private final float[] iIi_field_b4b;
    private final float[] iiI_field_b4b;
    private final float[] iii_field_b4b;
    private final float[] IIII_field_b4b;
    private final float[] IIIi_field_b4b;
    private final float[] IIiI_field_b4b;
    private final float[] IIii_field_b4b;
    private final float[] IiII_field_b4b;

    private iIIIiiIII_Class281(int n, int n2, int n3, int n4, int n5, int n6, int n7, float[] fArray, float[] fArray2, float[] fArray3, float[] fArray4, float[] fArray5, float[] fArray6, float[] fArray7, float[] fArray8, float[] fArray9, float[] fArray10, float[] fArray11, float[] fArray12, float[] fArray13, float[] fArray14, float[] fArray15, float[] fArray16, float[] fArray17, float[] fArray18, float[] fArray19) {
        this.I_field_49 = n;
        this.i_field_49 = n2;
        this.II_field_49 = n3;
        this.Ii_field_49 = n4;
        this.iI_field_49 = n5;
        this.ii_field_49 = n6;
        this.III_field_49 = n7;
        this.I_field_b4b = fArray;
        this.i_field_b4b = fArray2;
        this.II_field_b4b = fArray3;
        this.Ii_field_b4b = fArray4;
        this.iI_field_b4b = fArray5;
        this.ii_field_b4b = fArray6;
        this.III_field_b4b = fArray7;
        this.IIi_field_b4b = fArray8;
        this.IiI_field_b4b = fArray9;
        this.Iii_field_b4b = fArray10;
        this.iII_field_b4b = fArray11;
        this.iIi_field_b4b = fArray12;
        this.iiI_field_b4b = fArray13;
        this.iii_field_b4b = fArray14;
        this.IIII_field_b4b = fArray15;
        this.IIIi_field_b4b = fArray16;
        this.IIiI_field_b4b = fArray17;
        this.IIii_field_b4b = fArray18;
        this.IiII_field_b4b = fArray19;
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static iIIIiiIII_Class281 I_method_d792ae54(Path path) {
        if (path == null || !Files.isRegularFile(path, new LinkOption[0])) {
            return null;
        }
        try (InputStream inputStream = Files.newInputStream(path, new OpenOption[0]);){
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            DataInputStream dataInputStream;
            block19: {
                block18: {
                    iIIIiiIII_Class281 iIIIiiIII_Class2812;
                    dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
                    try {
                        if (dataInputStream.readInt() == 1347375950) break block18;
                        iIIIiiIII_Class2812 = null;
                    }
                    catch (Throwable throwable) {
                        try {
                            dataInputStream.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                        throw throwable;
                    }
                    dataInputStream.close();
                    return iIIIiiIII_Class2812;
                }
                dataInputStream.readInt();
                n7 = dataInputStream.readInt();
                n6 = dataInputStream.readInt();
                n5 = dataInputStream.readInt();
                n4 = dataInputStream.readInt();
                n3 = dataInputStream.readInt();
                n2 = dataInputStream.readInt();
                n = dataInputStream.readInt();
                if (n7 > 0 && n6 > 0 && n5 > 0 && n4 > 0 && n3 > 0) break block19;
                iIIIiiIII_Class281 iIIIiiIII_Class2813 = null;
                dataInputStream.close();
                return iIIIiiIII_Class2813;
            }
            float[] fArray = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, n7);
            float[] fArray2 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, n7);
            float[] fArray3 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3);
            float[] fArray4 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3);
            float[] fArray5 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n6 * n7);
            float[] fArray6 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n6 * n6);
            float[] fArray7 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n6);
            float[] fArray8 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n6);
            float[] fArray9 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, n5 * n6);
            float[] fArray10 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, n5);
            float[] fArray11 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, n3 * n4);
            int n8 = 3 + n4;
            float[] fArray12 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n5 * n8);
            float[] fArray13 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n5 * n5);
            float[] fArray14 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n5);
            float[] fArray15 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n5);
            float[] fArray16 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3 * n5);
            float[] fArray17 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, 3);
            float[] fArray18 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, n3 * n6);
            float[] fArray19 = iIIIiiIII_Class281.I_method_7b605fdc(dataInputStream, n3);
            iIIIiiIII_Class281 iIIIiiIII_Class2814 = new iIIIiiIII_Class281(n7, n6, n5, n4, n3, n2, n, fArray, fArray2, fArray3, fArray4, fArray5, fArray6, fArray7, fArray8, fArray9, fArray10, fArray11, fArray12, fArray13, fArray14, fArray15, fArray16, fArray17, fArray18, fArray19);
            dataInputStream.close();
            return iIIIiiIII_Class2814;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private static float[] I_method_7b605fdc(DataInputStream dataInputStream, int n) throws IOException {
        float[] fArray = new float[n];
        for (int i = 0; i < n; ++i) {
            fArray[i] = dataInputStream.readFloat();
        }
        return fArray;
    }

    public Nested1_58964860 I_method_a8c54853(float[][] fArray, int n) {
        int n2;
        if (n <= 0) {
            n = Math.max(1, this.III_field_49);
        }
        float[] fArray2 = this.I_method_eacaf660(fArray);
        double[] dArray = iIIIiiIII_Class281.I_method_ff46ebf5(iIIIiiIII_Class281.I_method_97af7681(this.IIii_field_b4b, this.IiII_field_b4b, fArray2, this.iI_field_49, this.i_field_49));
        float[] fArray3 = iIIIiiIII_Class281.I_method_97af7681(this.IiI_field_b4b, this.Iii_field_b4b, fArray2, this.II_field_49, this.i_field_49);
        for (n2 = 0; n2 < this.II_field_49; ++n2) {
            fArray3[n2] = iIIIiiIII_Class281.i_method_2c61b991(fArray3[n2]);
        }
        n2 = this.II_field_49;
        int n3 = this.Ii_field_49;
        int n4 = 3 + n3;
        float[][][] fArray4 = new float[this.iI_field_49][n][3];
        float[] fArray5 = new float[n4];
        for (int i = 0; i < this.iI_field_49; ++i) {
            int n5;
            float[] fArray6 = (float[])fArray3.clone();
            fArray5[0] = 0.0f;
            fArray5[1] = 0.0f;
            fArray5[2] = 0.0f;
            for (n5 = 0; n5 < n3; ++n5) {
                fArray5[3 + n5] = this.iII_field_b4b[i * n3 + n5];
            }
            for (n5 = 0; n5 < n; ++n5) {
                fArray6 = iIIIiiIII_Class281.I_method_7d5cafc0(fArray6, fArray5, this.iIi_field_b4b, this.iiI_field_b4b, this.iii_field_b4b, this.IIII_field_b4b, n2, n4);
                float[] fArray7 = iIIIiiIII_Class281.I_method_97af7681(this.IIIi_field_b4b, this.IIiI_field_b4b, fArray6, 3, n2);
                for (int j = 0; j < 3; ++j) {
                    fArray4[i][n5][j] = fArray7[j] * this.Ii_field_b4b[j] + this.II_field_b4b[j];
                    fArray5[j] = fArray7[j];
                }
            }
        }
        return new Nested1_58964860(fArray4, dArray);
    }

    private float[] I_method_eacaf660(float[][] fArray) {
        int n = this.i_field_49;
        int n2 = this.I_field_49;
        float[] fArray2 = new float[n];
        float[] fArray3 = new float[n2];
        for (float[] fArray4 : fArray) {
            for (int i = 0; i < n2; ++i) {
                float f = this.i_field_b4b[i];
                fArray3[i] = (fArray4[i] - this.I_field_b4b[i]) / (f == 0.0f ? 1.0f : f);
            }
            fArray2 = iIIIiiIII_Class281.I_method_7d5cafc0(fArray2, fArray3, this.iI_field_b4b, this.ii_field_b4b, this.III_field_b4b, this.IIi_field_b4b, n, n2);
        }
        return fArray2;
    }

    private static float[] I_method_7d5cafc0(float[] fArray, float[] fArray2, float[] fArray3, float[] fArray4, float[] fArray5, float[] fArray6, int n, int n2) {
        float f;
        float[] fArray7 = new float[3 * n];
        float[] fArray8 = new float[3 * n];
        for (int i = 0; i < 3 * n; ++i) {
            float f2 = fArray5[i];
            int n3 = i * n2;
            for (int j = 0; j < n2; ++j) {
                f2 += fArray3[n3 + j] * fArray2[j];
            }
            fArray7[i] = f2;
            f = fArray6[i];
            int n4 = i * n;
            for (int j = 0; j < n; ++j) {
                f += fArray4[n4 + j] * fArray[j];
            }
            fArray8[i] = f;
        }
        float[] fArray9 = new float[n];
        for (int i = 0; i < n; ++i) {
            float f3 = iIIIiiIII_Class281.I_method_2a9ec971(fArray7[i] + fArray8[i]);
            f = iIIIiiIII_Class281.I_method_2a9ec971(fArray7[n + i] + fArray8[n + i]);
            float f4 = iIIIiiIII_Class281.i_method_2c61b991(fArray7[2 * n + i] + f3 * fArray8[2 * n + i]);
            fArray9[i] = (1.0f - f) * f4 + f * fArray[i];
        }
        return fArray9;
    }

    private static float[] I_method_97af7681(float[] fArray, float[] fArray2, float[] fArray3, int n, int n2) {
        float[] fArray4 = new float[n];
        for (int i = 0; i < n; ++i) {
            float f = fArray2[i];
            int n3 = i * n2;
            for (int j = 0; j < n2; ++j) {
                f += fArray[n3 + j] * fArray3[j];
            }
            fArray4[i] = f;
        }
        return fArray4;
    }

    private static double[] I_method_ff46ebf5(float[] fArray) {
        int n;
        int n2 = fArray.length;
        double d = Double.NEGATIVE_INFINITY;
        for (float f : fArray) {
            if (!((double)f > d)) continue;
            d = f;
        }
        double d2 = 0.0;
        double[] dArray = new double[n2];
        for (n = 0; n < n2; ++n) {
            dArray[n] = Math.exp((double)fArray[n] - d);
            d2 += dArray[n];
        }
        n = 0;
        while (n < n2) {
            int n3 = n++;
            dArray[n3] = dArray[n3] / d2;
        }
        return dArray;
    }

    private static float I_method_2a9ec971(float f) {
        return (float)(1.0 / (1.0 + Math.exp(-f)));
    }

    private static float i_method_2c61b991(float f) {
        return (float)Math.tanh(f);
    }

    public static final class Nested1_58964860 {
        public final float[][][] I_field_2abeab;
        public final double[] I_field_b49;

        Nested1_58964860(float[][][] fArray, double[] dArray) {
            this.I_field_2abeab = fArray;
            this.I_field_b49 = dArray;
        }
    }
}

