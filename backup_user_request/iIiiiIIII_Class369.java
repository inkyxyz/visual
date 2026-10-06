package rockstar.client;

import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;

public class iIiiiIIII_Class369
implements iIIiIIiIi_Class294 {
    public static final int I_field_49 = 96;
    public static final float I_field_46 = 2.0f;
    public static final float i_field_46 = 192.0f;
    private static final long I_field_4a = 500L;
    private static final float II_field_46 = 8.0f;
    private static final int i_field_49 = 128;
    private final Identifier I_field_6a3d6525 = RockstarClient.id("dynamic/rain_heightmap");
    private NativeImageBackedTexture I_field_d7800ed2;
    private boolean I_field_5a;
    private float Ii_field_46;
    private float iI_field_46;
    private float ii_field_46;
    private long i_field_4a;
    private boolean i_field_5a;

    public Identifier I_method_b5eddd0e() {
        return this.I_field_6a3d6525;
    }

    public boolean I_method_35b0603() {
        return this.i_field_5a;
    }

    public int I_method_35b05f2() {
        return this.I_field_d7800ed2 == null ? 0 : this.I_field_d7800ed2.getGlId();
    }

    public float I_method_35b05ef() {
        return this.Ii_field_46;
    }

    public float i_method_36991cf() {
        return this.iI_field_46;
    }

    public float II_method_6814b132() {
        return this.ii_field_46;
    }

    public void I_method_7ef4161f(double d, double d2, double d3) {
        boolean bl;
        ClientWorld clientWorld = iIiiiIIII_Class369.I_field_3a9bda27.world;
        if (clientWorld == null) {
            return;
        }
        long l = System.currentTimeMillis();
        float f = (float)d - 96.0f;
        float f2 = (float)d3 - 96.0f;
        boolean bl2 = bl = Math.abs(f - this.Ii_field_46) > 8.0f || Math.abs(f2 - this.iI_field_46) > 8.0f;
        if (this.i_field_5a && !bl && l - this.i_field_4a < 500L) {
            return;
        }
        this.i_field_4a = l;
        this.Ii_field_46 = f;
        this.iI_field_46 = f2;
        this.ii_field_46 = (float)d2;
        this.i_method_36991df();
        NativeImage nativeImage = this.I_field_d7800ed2.getImage();
        if (nativeImage == null) {
            return;
        }
        for (int i = 0; i < 96; ++i) {
            int n = (int)Math.floor(this.iI_field_46 + (float)i * 2.0f);
            for (int j = 0; j < 96; ++j) {
                int n2 = (int)Math.floor(this.Ii_field_46 + (float)j * 2.0f);
                int n3 = clientWorld.getTopY(Heightmap.Type.MOTION_BLOCKING, n2, n);
                int n4 = MathHelper.clamp((int)(Math.round((float)n3 - this.ii_field_46) + 128), (int)0, (int)255);
                nativeImage.setColor(j, i, 0xFF000000 | n4 << 16 | n4 << 8 | n4);
            }
        }
        this.I_field_d7800ed2.upload();
        this.i_field_5a = true;
    }

    private void i_method_36991df() {
        if (this.I_field_d7800ed2 == null) {
            this.I_field_d7800ed2 = new NativeImageBackedTexture(96, 96, false);
        }
        if (!this.I_field_5a) {
            I_field_3a9bda27.getTextureManager().registerTexture(this.I_field_6a3d6525, (AbstractTexture)this.I_field_d7800ed2);
            this.I_field_5a = true;
        }
    }

    public void I_method_35b05ff() {
        if (this.I_field_d7800ed2 != null) {
            this.I_field_d7800ed2.close();
            this.I_field_d7800ed2 = null;
        }
        if (this.I_field_5a) {
            I_field_3a9bda27.getTextureManager().destroyTexture(this.I_field_6a3d6525);
            this.I_field_5a = false;
        }
        this.i_field_5a = false;
    }

    public static int i_method_36991d2() {
        return 128;
    }
}

