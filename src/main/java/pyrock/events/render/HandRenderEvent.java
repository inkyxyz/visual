package pyrock.events.render;

import lombok.Generated;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import pyrock.events.EventCancellable;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="hand_render")
public class HandRenderEvent
extends EventCancellable {
    private final Arm arm;
    private final float swingProgress;
    private final ItemStack itemStack;
    private final float equipProgress;
    private final MatrixStack matrices;

    @Generated
    public Arm getArm() {
        return this.arm;
    }

    @Generated
    public float getSwingProgress() {
        return this.swingProgress;
    }

    @Generated
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Generated
    public float getEquipProgress() {
        return this.equipProgress;
    }

    @Generated
    public MatrixStack getMatrices() {
        return this.matrices;
    }

    @Generated
    public HandRenderEvent(Arm arm, float f, ItemStack itemStack, float f2, MatrixStack matrixStack) {
        this.arm = arm;
        this.swingProgress = f;
        this.itemStack = itemStack;
        this.equipProgress = f2;
        this.matrices = matrixStack;
    }
}

