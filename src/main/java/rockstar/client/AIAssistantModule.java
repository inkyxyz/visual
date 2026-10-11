package rockstar.client;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

@ModuleInfo(
    name = "AI Chat",
    category = ModuleCategory.INTERFACE,
    iI_method_476ab839 = false,
    defaultKey = GLFW.GLFW_KEY_H,
    III_method_a89e5834 = "modules.descriptions.ai_assistant"
)
public class AIAssistantModule extends Module {

    public AIAssistantModule() {
    }

    @Override
    public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            mc.setScreen(new AIAssistantScreen());
        }
        this.setEnabled(false, false);
    }
}
