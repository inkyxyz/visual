package moscow.rockstar.mixin.accessors;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={BipedEntityModel.class})
public interface BipedEntityModelAccessor {
    @Accessor(value="head")
    public ModelPart rockstar$getHead();

    @Accessor(value="hat")
    public ModelPart rockstar$getHat();

    @Accessor(value="rightArm")
    public ModelPart rockstar$getRightArm();

    @Accessor(value="leftArm")
    public ModelPart rockstar$getLeftArm();

    @Accessor(value="body")
    public ModelPart rockstar$getBody();

    @Accessor(value="rightLeg")
    public ModelPart rockstar$getRightLeg();

    @Accessor(value="leftLeg")
    public ModelPart rockstar$getLeftLeg();
}

