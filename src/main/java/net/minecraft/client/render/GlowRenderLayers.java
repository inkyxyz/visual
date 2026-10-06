package net.minecraft.client.render;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import rockstar.client.iIiIi_Class22;

public final class GlowRenderLayers {
    private static final Map<Identifier, RenderLayer> CACHE = new HashMap<Identifier, RenderLayer>();
    private static RenderPhase.ShaderProgram glowProgram;

    private GlowRenderLayers() {
    }

    public static void initShader(iIiIi_Class22 iIiRockstarClient22) {
        glowProgram = iIiRockstarClient22.I_method_bbcba39();
        CACHE.clear();
    }

    public static RenderLayer get(Identifier identifier) {
        if (glowProgram == null) {
            return RenderLayer.getEntityCutoutNoCull((Identifier)identifier);
        }
        return CACHE.computeIfAbsent(identifier, GlowRenderLayers::create);
    }

    private static RenderLayer create(Identifier identifier) {
        RenderLayer.MultiPhaseParameters multiPhaseParameters = RenderLayer.MultiPhaseParameters.builder().program(glowProgram).texture((RenderPhase.TextureBase)new RenderPhase.Texture(identifier, TriState.FALSE, false)).transparency(RenderPhase.NO_TRANSPARENCY).cull(RenderPhase.DISABLE_CULLING).lightmap(RenderPhase.DISABLE_LIGHTMAP).overlay(RenderPhase.DISABLE_OVERLAY_COLOR).writeMaskState(RenderPhase.ALL_MASK).build(false);
        return RenderLayer.of((String)"rockstar_glow_entity", (VertexFormat)VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, (VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (int)1536, (boolean)true, (boolean)false, (RenderLayer.MultiPhaseParameters)multiPhaseParameters);
    }
}

