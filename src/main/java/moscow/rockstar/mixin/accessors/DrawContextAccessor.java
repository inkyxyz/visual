package moscow.rockstar.mixin.accessors;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={DrawContext.class})
public interface DrawContextAccessor {
    @Accessor(value="vertexConsumers")
    public VertexConsumerProvider.Immediate getVertexConsumers();

    @Accessor(value="itemRenderState")
    public ItemRenderState getItemRenderState();
}

