package rockstar.client;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import rockstar.client.III;
import rockstar.client.IiIIiiIII_Class153;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iI_Class3;

public class IiIIiIiii_Class152
extends iI_Class3
implements iIIiIIiIi_Class294 {
    private final int I_field_49;
    private int i_field_49 = 0;
    private long I_field_4a = 0L;
    private final IiIIiiIII_Class153 I_field_ab758eac = new IiIIiiIII_Class153();
    private final Map<Integer, Integer> I_field_a567c40b = new HashMap<Integer, Integer>();
    private NativeImageBackedTexture I_field_d7800ed2;
    private final Identifier I_field_6a3d6525;
    private float iI_field_46 = 1.0f;
    private final NativeImage I_field_cb9f726f;

    public IiIIiIiii_Class152(Identifier identifier, float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
        try {
            Resource resource = I_field_3a9bda27.getResourceManager().getResourceOrThrow(identifier);
            this.I_field_ab758eac.I_method_eadb4d87(resource.getInputStream());
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.I_field_49 = this.I_field_ab758eac.Ii_method_2b07d0b5();
        for (int i = 0; i < this.I_field_49; ++i) {
            this.I_field_a567c40b.put(i, this.I_field_ab758eac.I_method_2aeac077(i));
        }
        BufferedImage bufferedImage = this.I_field_ab758eac.I_method_f5d6ced7(0);
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        this.I_field_cb9f726f = new NativeImage(NativeImage.Format.RGBA, n, n2, false);
        this.I_field_d7800ed2 = new NativeImageBackedTexture(this.I_field_cb9f726f);
        this.I_field_6a3d6525 = RockstarClient.id("gif_texture_" + identifier.getPath().hashCode());
        I_field_3a9bda27.getTextureManager().registerTexture(this.I_field_6a3d6525, (AbstractTexture)this.I_field_d7800ed2);
    }

    private void I_method_c33780c4(int n) {
        BufferedImage bufferedImage = this.I_field_ab758eac.I_method_f5d6ced7(n);
        for (int i = 0; i < bufferedImage.getHeight(); ++i) {
            for (int j = 0; j < bufferedImage.getWidth(); ++j) {
                int n2 = bufferedImage.getRGB(j, i);
                this.I_field_cb9f726f.setColorArgb(j, i, n2);
            }
        }
        this.I_field_d7800ed2.upload();
    }

    @Override
    public void II_method_b98d0c44(III iII) {
        long l = System.currentTimeMillis();
        if (l - this.I_field_4a > (long)this.I_field_a567c40b.get(this.i_field_49).intValue()) {
            this.I_field_4a = l;
            this.i_field_49 = (this.i_field_49 + 1) % this.I_field_49;
            this.I_method_c33780c4(this.i_field_49);
        }
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        iII.drawTexture(this.I_field_6a3d6525, this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46, IiiiiIIIi_Class242.Ii_field_d0c8ec5.mulAlpha(this.iI_field_46));
    }

    public void i_method_d4ce41ff() {
        if (this.I_field_d7800ed2 != null) {
            I_field_3a9bda27.getTextureManager().destroyTexture(this.I_field_6a3d6525);
            this.I_field_d7800ed2.close();
            this.I_field_d7800ed2 = null;
        }
    }

    @Generated
    public void iI_method_dc161abe(float f) {
        this.iI_field_46 = f;
    }
}

