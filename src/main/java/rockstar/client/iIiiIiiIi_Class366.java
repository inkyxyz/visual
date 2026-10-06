package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiiIiiII_Class365;

public class iIiiIiiIi_Class366
implements iIIiIIiIi_Class294 {
    private static final int I_field_49 = 8;
    private static final int i_field_49 = 16;
    private static final int II_field_49 = 128;
    private NativeImage I_field_cb9f726f;
    private NativeImageBackedTexture I_field_d7800ed2;
    private final Map<Identifier, Integer> I_field_a567c40b = new HashMap<Identifier, Integer>();
    private int Ii_field_49 = 0;
    private boolean I_field_5a = false;
    private boolean i_field_5a = false;

    private void i_method_3589fddf() {
        if (this.I_field_d7800ed2 == null) {
            this.I_field_cb9f726f = new NativeImage(128, 128, true);
            this.I_field_d7800ed2 = new NativeImageBackedTexture(this.I_field_cb9f726f);
            this.I_field_d7800ed2.setFilter(false, false);
        }
    }

    public int I_method_b81c3233(Identifier identifier) {
        this.i_method_3589fddf();
        Integer n = this.I_field_a567c40b.get(identifier);
        if (n != null) {
            return n;
        }
        if (this.I_field_a567c40b.size() >= 256) {
            this.I_field_a567c40b.clear();
            this.Ii_field_49 = 0;
        }
        if (!this.I_method_4b6a88c7(identifier, n = Integer.valueOf(this.Ii_field_49++))) {
            this.I_field_a567c40b.remove(identifier);
            --this.Ii_field_49;
            return -1;
        }
        this.I_field_a567c40b.put(identifier, n);
        this.I_field_5a = true;
        return n;
    }

    public void I_method_357b71ff() {
        if (this.I_field_d7800ed2 == null) {
            return;
        }
        if (this.I_field_5a || !this.i_field_5a) {
            this.I_field_d7800ed2.upload();
            this.I_field_5a = false;
            this.i_field_5a = true;
        }
    }

    public int I_method_357b71f2() {
        this.i_method_3589fddf();
        return this.I_field_d7800ed2.getGlId();
    }

    public float I_method_79f340d4(int n) {
        return (float)(n % 16 * 8) / 128.0f;
    }

    public float i_method_7bb630f4(int n) {
        return (float)(n / 16 * 8) / 128.0f;
    }

    public float I_method_357b71ef() {
        return 0.0625f;
    }

    private boolean I_method_4b6a88c7(Identifier identifier, int n) {
        AbstractTexture abstractTexture = I_field_3a9bda27.getTextureManager().getTexture(identifier);
        int n2 = abstractTexture.getGlId();
        if (n2 <= 0) {
            return false;
        }
        GlStateManager._bindTexture((int)n2);
        int n3 = GL11.glGetTexLevelParameteri((int)3553, (int)0, (int)4096);
        int n4 = GL11.glGetTexLevelParameteri((int)3553, (int)0, (int)4097);
        if (n3 < 64 || n4 < 64) {
            return false;
        }
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer((int)(n3 * n4 * 4));
        iIiiIiiII_Class365.I_method_fee05e1f();
        GL11.glGetTexImage((int)3553, (int)0, (int)6408, (int)5121, (ByteBuffer)byteBuffer);
        int n5 = n % 16 * 8;
        int n6 = n / 16 * 8;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                int n7 = this.I_method_22b010a4(byteBuffer, n3, 8 + j, 8 + i);
                int n8 = this.I_method_22b010a4(byteBuffer, n3, 40 + j, 8 + i);
                this.I_field_cb9f726f.setColorArgb(n5 + j, n6 + i, this.I_method_c4754e92(n8, n7));
            }
        }
        return true;
    }

    private int I_method_22b010a4(ByteBuffer byteBuffer, int n, int n2, int n3) {
        int n4 = (n3 * n + n2) * 4;
        int n5 = byteBuffer.get(n4) & 0xFF;
        int n6 = byteBuffer.get(n4 + 1) & 0xFF;
        int n7 = byteBuffer.get(n4 + 2) & 0xFF;
        int n8 = byteBuffer.get(n4 + 3) & 0xFF;
        return n8 << 24 | n5 << 16 | n6 << 8 | n7;
    }

    private int I_method_c4754e92(int n, int n2) {
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f3 = f + f2 * (1.0f - f);
        if (f3 <= 0.0f) {
            return 0;
        }
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        int n6 = n2 >> 16 & 0xFF;
        int n7 = n2 >> 8 & 0xFF;
        int n8 = n2 & 0xFF;
        int n9 = Math.round(((float)n3 * f + (float)n6 * f2 * (1.0f - f)) / f3);
        int n10 = Math.round(((float)n4 * f + (float)n7 * f2 * (1.0f - f)) / f3);
        int n11 = Math.round(((float)n5 * f + (float)n8 * f2 * (1.0f - f)) / f3);
        int n12 = Math.round(f3 * 255.0f);
        return n12 << 24 | n9 << 16 | n10 << 8 | n11;
    }
}

