package rockstar.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Optional;
import moscow.rockstar.mixin.minecraft.client.IMinecraftClient;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.fabricmc.loader.impl.ModContainerImpl;
import net.minecraft.client.util.Icons;
import net.minecraft.resource.ResourcePack;
import rockstar.client.ModuleEntry;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIIiI_Class259;
import rockstar.client.iIIIIiIii_Class268;
import rockstar.client.Module;

@ModuleInfo(name="Panic", category=ModuleCategory.OTHER, III_method_a89e5834="modules.descriptions.panic")
public class PanicModule
extends Module {
    @Override
    public final void onEnable() {
        iIIIIiIii_Class268.i_method_4360c61f();
        RockstarClient.getInstance().I_method_21e6a6c8(true);
        RockstarClient.getInstance().I_method_7a4c3f0b().II_method_d8a14015();
        for (ModuleEntry object : RockstarClient.getInstance().getModuleManager().getModules()) {
            object.setKeybind(-1);
            object.disable();
        }
        try {
            I_field_3a9bda27.getWindow().setIcon((ResourcePack)I_field_3a9bda27.getDefaultResourcePack(), Icons.RELEASE);
        }
        catch (Exception exception) {
            // empty catch block
        }
        ModContainerImpl modContainerImpl = this.I_method_5016471c();
        if (modContainerImpl != null) {
            for (Path path : modContainerImpl.getOrigin().getPaths()) {
                path.toFile().delete();
            }
            FabricLoaderImpl.INSTANCE.getModsInternal().remove(modContainerImpl);
        }
        this.IiI_method_e3515e5f();
        super.onEnable();
    }

    private void IiI_method_e3515e5f() {
        Optional<Path> optional = iIIIIIIiI_Class259.I_method_5504c626();
        if (optional.isEmpty()) {
            RockstarClient.I_field_ab0f6068.warn("Legacy Launcher game directory was not found; Minecraft directory was not changed for Panic");
            return;
        }
        Path path = optional.get().toAbsolutePath().normalize();
        Path path2 = path.resolve("resourcepacks");
        try {
            Files.createDirectories(path2, new FileAttribute[0]);
            IMinecraftClient iMinecraftClient = (IMinecraftClient)I_field_3a9bda27;
            iMinecraftClient.setRunDirectory(path.toFile());
            iMinecraftClient.setResourcePackDir(path2);
            RockstarClient.I_field_ab0f6068.info("Panic changed Minecraft directory to Legacy Launcher path: {}", (Object)path);
        }
        catch (IOException iOException) {
            RockstarClient.I_field_ab0f6068.warn("Failed to prepare Legacy Launcher resourcepacks directory: {}", (Object)path2, (Object)iOException);
        }
        catch (RuntimeException runtimeException) {
            RockstarClient.I_field_ab0f6068.warn("Failed to change Minecraft directory for Panic: {}", (Object)path, (Object)runtimeException);
        }
    }

    private ModContainerImpl I_method_5016471c() {
        return (ModContainerImpl)FabricLoaderImpl.INSTANCE.getAllMods().stream().filter(modContainer -> modContainer.getMetadata().getId().equals(RockstarClient.II_field_523beb0a)).findFirst().orElse(null);
    }
}
