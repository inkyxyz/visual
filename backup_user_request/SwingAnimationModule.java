package rockstar.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.UseAction;
import net.minecraft.util.Arm;
import org.joml.Quaternionf;
import pyrock.events.render.HandRenderEvent;
import rockstar.client.BooleanSetting;
import rockstar.client.ButtonSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iiIIIIII_Class193;
import rockstar.client.iiIIIiIi_Class198;
import rockstar.client.Module;
import rockstar.client.AuraModule;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Swing Animation", category=ModuleCategory.VISUALS, iI_method_476ab839=true, III_method_a89e5834="modules.descriptions.swing_animation")
public class SwingAnimationModule
extends Module {
    private BooleanSetting I_field_ba20ca4c;
    private ButtonSetting I_field_bbd4b28c;
    private final IiIIIiII_Class69<HandRenderEvent> I_field_3d936f41 = handRenderEvent -> {
        if (this.I_method_5f90eae5(handRenderEvent.getItemStack()) && handRenderEvent.getArm() == SwingAnimationModule.I_field_3a9bda27.options.getMainArm().getValue()) {
            MatrixStack matrixStack = handRenderEvent.getMatrices();
            float f = handRenderEvent.getSwingProgress();
            float f2 = handRenderEvent.getEquipProgress();
            iiIIIiIi_Class198 iiIIIiIi_Class1982 = RockstarClient.getInstance().I_method_11732eb().I_method_417b4cc3(f);
            if (handRenderEvent.getArm() == Arm.LEFT) {
                iiIIIiIi_Class1982 = this.I_method_b2b0c897(iiIIIiIi_Class1982);
            }
            matrixStack.translate(iiIIIiIi_Class1982.I_method_2efb707c(), iiIIIiIi_Class1982.i_method_2f09fc5c(), iiIIIiIi_Class1982.II_method_b0819845());
            matrixStack.translate(iiIIIiIi_Class1982.Ii_method_b0902425(), iiIIIiIi_Class1982.iI_method_b2448865(), iiIIIiIi_Class1982.ii_method_b2531445());
            matrixStack.multiply(new Quaternionf().rotationXYZ((float)Math.toRadians(iiIIIiIi_Class1982.III_method_5fc0699c()), (float)Math.toRadians(iiIIIiIi_Class1982.IIi_method_5fcef57c()), (float)Math.toRadians(iiIIIiIi_Class1982.IiI_method_618359bc())));
            matrixStack.translate(-iiIIIiIi_Class1982.I_method_2efb707c(), -iiIIIiIi_Class1982.i_method_2f09fc5c(), -iiIIIiIi_Class1982.II_method_b0819845());
            handRenderEvent.cancel();
        }
    };

    public SwingAnimationModule() {
        this.IiI_method_1f0a923f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_1f0a923f() {
        this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.swing_animation.only_aura");
        this.I_field_bbd4b28c = new ButtonSetting(this, "modules.settings.swing_animation.open_menu").I_method_f05556b3(() -> I_field_3a9bda27.setScreen((Screen)new iiIIIIII_Class193()));
    }

    private iiIIIiIi_Class198 I_method_b2b0c897(iiIIIiIi_Class198 iiIIIiIi_Class1982) {
        return new iiIIIiIi_Class198(-iiIIIiIi_Class1982.I_method_2efb707c(), iiIIIiIi_Class1982.i_method_2f09fc5c(), iiIIIiIi_Class1982.II_method_b0819845(), -iiIIIiIi_Class1982.Ii_method_b0902425(), iiIIIiIi_Class1982.iI_method_b2448865(), iiIIIiIi_Class1982.ii_method_b2531445(), iiIIIiIi_Class1982.III_method_5fc0699c(), -iiIIIiIi_Class1982.IIi_method_5fcef57c(), -iiIIIiIi_Class1982.IiI_method_618359bc());
    }

    public boolean I_method_5f90eae5(ItemStack itemStack) {
        AuraModule iiIiIIRockstarClient102 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
        Entity entity = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815();
        Item item = itemStack.getItem();
        if (this.I_field_ba20ca4c.i_method_9b12da03() && (iiIiIIRockstarClient102 == null || !iiIiIIRockstarClient102.isEnabled() || entity == null)) {
            return false;
        }
        return item != Items.AIR && item != Items.FILLED_MAP && item != Items.CROSSBOW && item != Items.BOW && item != Items.TRIDENT && item.getUseAction(itemStack) != UseAction.DRINK && item.getUseAction(itemStack) != UseAction.EAT;
    }
}

