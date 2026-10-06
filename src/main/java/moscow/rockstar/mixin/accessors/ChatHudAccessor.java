package moscow.rockstar.mixin.accessors;

import java.util.List;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={ChatHud.class})
public interface ChatHudAccessor {
    @Accessor(value="visibleMessages")
    public List<ChatHudLine.Visible> getVisibleMessages();

    @Accessor(value="messages")
    public List<ChatHudLine> getMessages();

    @Invoker(value="getMessageLineIndex")
    public int invokeGetMessageLineIndex(double var1, double var3);

    @Invoker(value="toChatLineX")
    public double invokeToChatLineX(double var1);

    @Invoker(value="toChatLineY")
    public double invokeToChatLineY(double var1);
}

