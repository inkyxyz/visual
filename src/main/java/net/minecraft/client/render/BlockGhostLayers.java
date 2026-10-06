package net.minecraft.client.render;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.TriState;
import rockstar.client.IiiIi_Class14;

public final class BlockGhostLayers {
    private static IiiIi_Class14 program;
    private static RenderLayer layer;

    private BlockGhostLayers() {
    }

    public static void initShader(IiiIi_Class14 iiiIi_Class14) {
        program = iiiIi_Class14;
        layer = null;
    }

    public static boolean ready() {
        return program != null && program.I_method_a04a46e3();
    }

    public static RenderLayer ghost() {
        if (layer == null) {
            layer = RenderLayer.of((String)"rockstar_block_ghost", (VertexFormat)VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, (VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (int)1536, (boolean)true, (boolean)false, (RenderLayer.MultiPhaseParameters)RenderLayer.MultiPhaseParameters.builder().program(program.I_method_bbcba39()).texture((RenderPhase.TextureBase)new RenderPhase.Texture(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, TriState.FALSE, true)).transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY).cull(RenderPhase.ENABLE_CULLING).lightmap(RenderPhase.ENABLE_LIGHTMAP).overlay(RenderPhase.DISABLE_OVERLAY_COLOR).layering(RenderPhase.POLYGON_OFFSET_LAYERING).depthTest(RenderPhase.LEQUAL_DEPTH_TEST).writeMaskState(RenderPhase.ALL_MASK).build(false));
        }
        return layer;
    }
}

