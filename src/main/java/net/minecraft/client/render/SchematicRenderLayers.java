package net.minecraft.client.render;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.TriState;

public final class SchematicRenderLayers {
    private static RenderLayer visible;
    private static RenderLayer hidden;

    private SchematicRenderLayers() {
    }

    public static RenderLayer visible() {
        if (visible == null) {
            visible = SchematicRenderLayers.create("rockstar_schematic", RenderPhase.LEQUAL_DEPTH_TEST, RenderPhase.ALL_MASK, RenderPhase.ENABLE_CULLING);
        }
        return visible;
    }

    public static RenderLayer hidden() {
        if (hidden == null) {
            hidden = SchematicRenderLayers.create("rockstar_schematic_hidden", RenderPhase.BIGGER_DEPTH_TEST, RenderPhase.COLOR_MASK, RenderPhase.ENABLE_CULLING);
        }
        return hidden;
    }

    private static RenderLayer create(String string, RenderPhase.DepthTest depthTest, RenderPhase.WriteMaskState writeMaskState, RenderPhase.Cull cull) {
        RenderLayer.MultiPhaseParameters multiPhaseParameters = RenderLayer.MultiPhaseParameters.builder().program(RenderPhase.ENTITY_TRANSLUCENT_PROGRAM).texture((RenderPhase.TextureBase)new RenderPhase.Texture(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, TriState.FALSE, true)).transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY).cull(cull).lightmap(RenderPhase.ENABLE_LIGHTMAP).overlay(RenderPhase.ENABLE_OVERLAY_COLOR).layering(RenderPhase.POLYGON_OFFSET_LAYERING).depthTest(depthTest).writeMaskState(writeMaskState).build(false);
        return RenderLayer.of((String)string, (VertexFormat)VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, (VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (int)1536, (boolean)true, (boolean)false, (RenderLayer.MultiPhaseParameters)multiPhaseParameters);
    }
}

