package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;
import rockstar.client.IiIIiI_Class19;
import rockstar.client.IiIiII_Class21;
import rockstar.client.iIiiIiiII_Class365;

public final class IiIiIi_Class22 {
    private static final IiIiIi_Class22 I_field_ba53b1c1 = new IiIiIi_Class22();
    private final IiIiII_Class21 I_field_ba53ade1 = new IiIiII_Class21();
    private int I_field_49;
    private int i_field_49;
    private int II_field_49;
    private int Ii_field_49;
    private int iI_field_49;
    private int ii_field_49;
    private boolean I_field_5a;

    private IiIiIi_Class22() {
    }

    public static IiIiIi_Class22 I_method_bdb4d34b() {
        return I_field_ba53b1c1;
    }

    public synchronized int I_method_5c3c5ae0(IiIIiI_Class19 iiIIiI_Class19) {
        int n = this.I_field_ba53ade1.I_method_46a6e700(iiIIiI_Class19);
        this.I_field_5a = true;
        return n;
    }

    public int I_method_a30f51ff() {
        return this.I_field_49;
    }

    public int i_method_a31ddddf() {
        return this.i_field_49;
    }

    public int II_method_bee9e6c8() {
        return this.II_field_49;
    }

    public synchronized void I_method_a30f520c() {
        if (!this.I_field_5a || !RenderSystem.isOnRenderThread()) {
            return;
        }
        this.I_field_5a = false;
        int n = GlStateManager._getInteger((int)32873);
        this.I_field_49 = this.I_method_d8047fe3(this.I_field_49, this.Ii_field_49, this.I_field_ba53ade1.i_method_6c82c9ff(), 4096, 34842, this.I_field_ba53ade1.I_method_22138835(), this.I_field_ba53ade1.iI_method_23e56ec8(), this.I_field_ba53ade1.I_method_6c743e30(), 4);
        this.Ii_field_49 = this.I_field_ba53ade1.i_method_6c82c9ff();
        this.i_field_49 = this.I_method_94344149(this.i_field_49, this.iI_field_49, this.I_field_ba53ade1.II_method_22227ea8(), this.I_field_ba53ade1.I_method_22138838(), this.I_field_ba53ade1.ii_method_23f3faa8(), this.I_field_ba53ade1.i_method_6c82ca10());
        this.iI_field_49 = this.I_field_ba53ade1.II_method_22227ea8();
        this.II_field_49 = this.I_method_d8047fe3(this.II_field_49, this.ii_field_49, this.I_field_ba53ade1.Ii_method_22310a88(), 2048, 34836, this.I_field_ba53ade1.i_method_23d67855(), this.I_field_ba53ade1.III_method_223c4f3f(), this.I_field_ba53ade1.II_method_22227eb9(), 4);
        this.ii_field_49 = this.I_field_ba53ade1.Ii_method_22310a88();
        this.I_field_ba53ade1.I_method_6c743e2c();
        GlStateManager._bindTexture((int)n);
    }

    private int I_method_d8047fe3(int n, int n2, int n3, int n4, int n5, float[] fArray, int n6, boolean bl, int n7) {
        boolean bl2;
        if (n6 <= 0 && n != 0 && !bl) {
            return n;
        }
        boolean bl3 = bl2 = n == 0 || bl || n2 != n3;
        if (n == 0) {
            n = GlStateManager._genTexture();
        }
        GlStateManager._bindTexture((int)n);
        iIiiIiiII_Class365.i_method_feeee9ff();
        if (bl2) {
            this.i_method_a31dddec();
            FloatBuffer floatBuffer = MemoryUtil.memAllocFloat((int)(n4 * n3 * n7));
            floatBuffer.put(fArray, 0, Math.min(fArray.length, floatBuffer.remaining()));
            while (floatBuffer.hasRemaining()) {
                floatBuffer.put(0.0f);
            }
            floatBuffer.flip();
            GL11.glTexImage2D((int)3553, (int)0, (int)n5, (int)n4, (int)n3, (int)0, (int)6408, (int)5126, (FloatBuffer)floatBuffer);
            MemoryUtil.memFree((Buffer)floatBuffer);
            return n;
        }
        int n8 = Math.min(n6, n3);
        if ((n8 = Math.min(n8, fArray.length / (n4 * n7))) <= 0) {
            return n;
        }
        FloatBuffer floatBuffer = MemoryUtil.memAllocFloat((int)(n4 * n8 * n7));
        floatBuffer.put(fArray, 0, n4 * n8 * n7).flip();
        GL11.glTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)n4, (int)n8, (int)6408, (int)5126, (FloatBuffer)floatBuffer);
        MemoryUtil.memFree((Buffer)floatBuffer);
        return n;
    }

    private int I_method_94344149(int n, int n2, int n3, int[] nArray, int n4, boolean bl) {
        int n5;
        boolean bl2;
        if (n4 <= 0 && n != 0 && !bl) {
            return n;
        }
        boolean bl3 = bl2 = n == 0 || bl || n2 != n3;
        if (n == 0) {
            n = GlStateManager._genTexture();
        }
        GlStateManager._bindTexture((int)n);
        iIiiIiiII_Class365.i_method_feeee9ff();
        int n6 = n5 = bl2 ? n3 : Math.min(n4, n3);
        if (n5 <= 0) {
            return n;
        }
        ShortBuffer shortBuffer = MemoryUtil.memAllocShort((int)(4096 * n5 * 2));
        int n7 = Math.min(nArray.length, 4096 * n5 * 2);
        for (int i = 0; i < n7; ++i) {
            shortBuffer.put((short)nArray[i]);
        }
        while (shortBuffer.hasRemaining()) {
            shortBuffer.put((short)0);
        }
        shortBuffer.flip();
        if (bl2) {
            this.i_method_a31dddec();
            GL11.glTexImage2D((int)3553, (int)0, (int)33338, (int)4096, (int)n3, (int)0, (int)33320, (int)5123, (ShortBuffer)shortBuffer);
        } else {
            GL11.glTexSubImage2D((int)3553, (int)0, (int)0, (int)0, (int)4096, (int)n5, (int)33320, (int)5123, (ShortBuffer)shortBuffer);
        }
        MemoryUtil.memFree((Buffer)shortBuffer);
        return n;
    }

    private void i_method_a31dddec() {
        GL11.glTexParameteri((int)3553, (int)10241, (int)9728);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
        GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
        GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
        GL11.glTexParameteri((int)3553, (int)33084, (int)0);
        GL11.glTexParameteri((int)3553, (int)33085, (int)0);
    }
}

