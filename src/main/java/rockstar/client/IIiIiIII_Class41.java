package rockstar.client;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import javax.imageio.ImageIO;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import pyrock.events.render.PreHudRenderEvent;
import rockstar.client.IIIiiIIi_Class26;
import rockstar.client.IIIiiIiI_Class27;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiiII_Class269;
import rockstar.client.iIIiIIiIi_Class294;

public class IIiIiIII_Class41
implements iIIiIIiIi_Class294 {
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(1000L, IiiiIiiII_Class237.IIIi_field_dd60aac);
    private boolean I_field_5a = false;
    private Identifier I_field_6a3d6525 = null;
    private boolean i_field_5a = false;
    private final IiIIIiII_Class69<PreHudRenderEvent> I_field_3d936f41 = preHudRenderEvent -> {
        if (this.I_field_6a3d6525 == null) {
            return;
        }
        if ((double)this.I_field_dc7facc.I_method_6ac4da6f() == 1.0 && !this.I_field_5a) {
            this.I_field_5a = true;
        }
        this.I_field_dc7facc.I_method_edd6dd11(this.I_field_5a ? 0.0f : 1.0f);
        if (this.I_field_dc7facc.I_method_6ac4da6f() == 0.0f && this.I_field_5a) {
            return;
        }
        float f = 200.0f;
        float f2 = ((float)I_field_3a9bda27.getWindow().getScaledWidth() - f) / 2.0f;
        float f3 = ((float)I_field_3a9bda27.getWindow().getScaledHeight() - f) / 2.0f;
        preHudRenderEvent.getContext().drawTexture(this.I_field_6a3d6525, f2, f3, f, f, IiiiiIIIi_Class242.Ii_field_d0c8ec5.withAlpha(255.0f * this.I_field_dc7facc.I_method_6ac4da6f()));
    };

    public IIiIiIII_Class41() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    public IIIiiIIi_Class26 I_method_37d86b6b() {
        return IIIiiIiI_Class27.I_method_fa8865f9("cat", iIIiiIiI_Class27 -> iIIiiIiI_Class27.I_method_b3f941e4("kitty").i_method_cfe1a061("commands.cat.description").I_method_16f05c8a(iIIiiIii_Class28 -> this.I_method_5ac97d0c())).I_method_9111538b();
    }

    private void I_method_5ac97d0c() {
        if (this.i_field_5a) {
            return;
        }
        this.i_field_5a = true;
        CompletableFuture.supplyAsync(() -> {
            try {
                String string = iIIIIiiII_Class269.I_method_82ac9197("https://api.thecatapi.com/v1/images/search");
                String string2 = iIIIIiiII_Class269.i_method_a2cb79b7(string);
                if (string2 == null) {
                    return null;
                }
                BufferedImage bufferedImage = ImageIO.read(URI.create(string2).toURL());
                if (bufferedImage == null) {
                    return null;
                }
                return iIIIIiiII_Class269.I_method_97bf3255(bufferedImage, false);
            }
            catch (IOException iOException) {
                return null;
            }
        }).thenAccept(nativeImage -> I_field_3a9bda27.execute(() -> {
            if (nativeImage != null) {
                if (this.I_field_6a3d6525 != null) {
                    I_field_3a9bda27.getTextureManager().destroyTexture(this.I_field_6a3d6525);
                }
                Identifier identifier = RockstarClient.id("temp/cat/" + String.valueOf(UUID.randomUUID()));
                I_field_3a9bda27.getTextureManager().registerTexture(identifier, (AbstractTexture)new NativeImageBackedTexture(nativeImage));
                this.I_field_6a3d6525 = identifier;
                this.I_field_dc7facc.I_method_edd6dd11(1.0f);
                this.I_field_5a = false;
            }
            this.i_field_5a = false;
        }));
    }
}

