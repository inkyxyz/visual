package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Random;
import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import org.joml.Matrix4f;
import rockstar.client.RockstarClient;
import rockstar.client.Iiiii_Class16;

public class iIiIiiiii_Class352 {
    private static final long I_field_4a = 1592635409L;
    private final Iiiii_Class16 I_field_2f5b954c = new Iiiii_Class16(RockstarClient.id("ambient_particles/data"));
    private final Iiiii_Class16.Nested1_eba0a780 I_field_c6cb2507 = new Iiiii_Class16.Nested1_eba0a780();
    private VertexBuffer I_field_b81f0491;
    private RenderLayer I_field_2aba9115;
    private RenderLayer i_field_2aba9115;
    private Identifier I_field_6a3d6525;
    private int I_field_49;
    private float I_field_46;
    private float i_field_46;
    private float II_field_46;

    public Iiiii_Class16.Nested1_eba0a780 I_method_f71fff90() {
        return this.I_field_c6cb2507;
    }

    public void I_method_8bb4fbf(Matrix4f matrix4f, int n, boolean bl, Identifier identifier) {
        if (n <= 0) {
            return;
        }
        if (!this.I_method_1c7a8908(n)) {
            return;
        }
        RenderLayer renderLayer = this.I_method_50d02d69(bl, identifier);
        this.I_field_2f5b954c.I_method_bbaf5552(matrix4f, this.I_field_c6cb2507);
        this.I_field_b81f0491.draw(renderLayer);
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public void I_method_bedaa5df() {
        if (this.I_field_b81f0491 != null && !this.I_field_b81f0491.isClosed()) {
            this.I_field_b81f0491.close();
        }
        this.I_field_b81f0491 = null;
        this.I_field_49 = 0;
    }

    private boolean I_method_1c7a8908(int n) {
        boolean bl;
        boolean bl2 = bl = this.I_field_46 == this.I_field_c6cb2507.iiI_field_46 && this.i_field_46 == this.I_field_c6cb2507.iii_field_46 && this.II_field_46 == this.I_field_c6cb2507.IIII_field_46;
        if (this.I_field_b81f0491 != null && !this.I_field_b81f0491.isClosed() && this.I_field_49 == n && bl) {
            return true;
        }
        this.I_method_bedaa5df();
        this.I_field_49 = n;
        this.I_field_46 = this.I_field_c6cb2507.iiI_field_46;
        this.i_field_46 = this.I_field_c6cb2507.iii_field_46;
        this.II_field_46 = this.I_field_c6cb2507.IIII_field_46;
        int n2 = n;
        float f = this.I_field_c6cb2507.iiI_field_46;
        float f2 = this.I_field_c6cb2507.iii_field_46;
        float f3 = this.I_field_c6cb2507.IIII_field_46;
        this.I_field_b81f0491 = VertexBuffer.createAndUpload((VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (VertexFormat)VertexFormats.POSITION_TEXTURE_COLOR, vertexConsumer -> iIiIiiiii_Class352.I_method_ca32bb08(vertexConsumer, n2, f, f2, f3));
        return this.I_field_b81f0491 != null;
    }

    private static void I_method_ca32bb08(VertexConsumer vertexConsumer, int n, float f, float f2, float f3) {
        Random random = new Random(1592635409L);
        for (int i = 0; i < n; ++i) {
            float f4 = random.nextFloat() * f;
            float f5 = random.nextFloat() * f2;
            float f6 = random.nextFloat() * f3;
            int n2 = (int)(random.nextFloat() * 255.0f);
            int n3 = (int)(random.nextFloat() * 255.0f);
            int n4 = (int)(random.nextFloat() * 255.0f);
            int n5 = 150 + (int)(random.nextFloat() * 105.0f);
            vertexConsumer.vertex(f4, f5, f6).texture(0.0f, 0.0f).color(n2, n3, n4, n5);
            vertexConsumer.vertex(f4, f5, f6).texture(0.0f, 1.0f).color(n2, n3, n4, n5);
            vertexConsumer.vertex(f4, f5, f6).texture(1.0f, 1.0f).color(n2, n3, n4, n5);
            vertexConsumer.vertex(f4, f5, f6).texture(1.0f, 0.0f).color(n2, n3, n4, n5);
        }
    }

    private RenderLayer I_method_50d02d69(boolean bl, Identifier identifier) {
        if (identifier == null || !identifier.equals((Object)this.I_field_6a3d6525)) {
            this.I_field_6a3d6525 = identifier;
            this.I_field_2aba9115 = null;
            this.i_field_2aba9115 = null;
        }
        if (bl) {
            if (this.i_field_2aba9115 == null) {
                this.i_field_2aba9115 = this.I_method_85fc7d86("rockstar_ambient_particles_additive", RenderPhase.ADDITIVE_TRANSPARENCY, identifier);
            }
            return this.i_field_2aba9115;
        }
        if (this.I_field_2aba9115 == null) {
            this.I_field_2aba9115 = this.I_method_85fc7d86("rockstar_ambient_particles", RenderPhase.TRANSLUCENT_TRANSPARENCY, identifier);
        }
        return this.I_field_2aba9115;
    }

    private RenderLayer I_method_85fc7d86(String string, RenderPhase.Transparency transparency, Identifier identifier) {
        RenderLayer.MultiPhaseParameters.Builder builder = RenderLayer.MultiPhaseParameters.builder().program(this.I_field_2f5b954c.I_method_bbcba39()).transparency(transparency).cull(RenderPhase.DISABLE_CULLING).writeMaskState(RenderPhase.COLOR_MASK);
        if (identifier != null) {
            builder.texture((RenderPhase.TextureBase)new RenderPhase.Texture(identifier, TriState.FALSE, false));
        }
        return RenderLayer.of((String)string, (VertexFormat)VertexFormats.POSITION_TEXTURE_COLOR, (VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (int)1536, (boolean)false, (boolean)true, (RenderLayer.MultiPhaseParameters)builder.build(false));
    }
}

