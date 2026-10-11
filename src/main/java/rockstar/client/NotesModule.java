package rockstar.client;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

@ModuleInfo(
    name = "Notes",
    category = ModuleCategory.INTERFACE,
    iI_method_476ab839 = false,
    defaultKey = GLFW.GLFW_KEY_N,
    III_method_a89e5834 = "modules.descriptions.notes"
)
public class NotesModule extends Module {

    public NotesModule() {
    }

    @Override
    public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            mc.setScreen(new NotesScreen());
        }
        this.setEnabled(false, false);
    }
}
