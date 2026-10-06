package net.minecraft.client.render;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import rockstar.client.IiiIi_Class14;

public final class SmoothItemLayers {
    private static final Map<String, RenderLayer> CACHE = new HashMap<String, RenderLayer>();
    private static IiiIi_Class14 translucentProgram;
    private static IiiIi_Class14 cutoutProgram;

    private SmoothItemLayers() {
    }

    public static void initShaders(IiiIi_Class14 iiiIi_Class14, IiiIi_Class14 iiiIi_Class142) {
        translucentProgram = iiiIi_Class14;
        cutoutProgram = iiiIi_Class142;
        CACHE.clear();
    }

    public static boolean ready() {
        return translucentProgram != null && translucentProgram.I_method_a04a46e3() && cutoutProgram != null && cutoutProgram.I_method_a04a46e3();
    }

    public static RenderLayer cutout(Identifier identifier) {
        return CACHE.computeIfAbsent("cutout|" + String.valueOf(identifier), string -> RenderLayer.of((String)"rockstar_item_cutout", (VertexFormat)VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, (VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (int)1536, (boolean)true, (boolean)false, (RenderLayer.MultiPhaseParameters)RenderLayer.MultiPhaseParameters.builder().program(cutoutProgram.I_method_bbcba39()).texture((RenderPhase.TextureBase)new Nested1_2b2fd555(identifier)).transparency(RenderPhase.NO_TRANSPARENCY).lightmap(RenderPhase.ENABLE_LIGHTMAP).overlay(RenderPhase.ENABLE_OVERLAY_COLOR).build(true)));
    }

    public static RenderLayer translucent(Identifier identifier) {
        return CACHE.computeIfAbsent("translucent|" + String.valueOf(identifier), string -> RenderLayer.of((String)"rockstar_item_translucent", (VertexFormat)VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, (VertexFormat.DrawMode)VertexFormat.DrawMode.QUADS, (int)1536, (boolean)true, (boolean)true, (RenderLayer.MultiPhaseParameters)RenderLayer.MultiPhaseParameters.builder().program(translucentProgram.I_method_bbcba39()).texture((RenderPhase.TextureBase)new Nested1_2b2fd555(identifier)).transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY).target(RenderPhase.ITEM_ENTITY_TARGET).lightmap(RenderPhase.ENABLE_LIGHTMAP).overlay(RenderPhase.ENABLE_OVERLAY_COLOR).writeMaskState(RenderPhase.ALL_MASK).build(true)));
    }

    static final class Nested1_2b2fd555
    extends RenderPhase.Texture {
        private final Identifier atlas;

        Nested1_2b2fd555(Identifier identifier) {
            super(identifier, TriState.TRUE, false);
            this.atlas = identifier;
        }

        public void endDrawing() {
            super.endDrawing();
            MinecraftClient.getInstance().getTextureManager().getTexture(this.atlas).setFilter(false, false);
        }
    }
}

