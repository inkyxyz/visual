package rockstar.client;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moscow.rockstar.mixin.accessors.ChatHudAccessor;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.text.MutableText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import pyrock.events.render.ChatRenderEvent;
import pyrock.events.window.ChatClickEvent;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIIiIIII_Class145;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;

public class IiIIIiiiI_Class143
implements iIIiIIiIi_Class294 {
    private static final Pattern I_field_5fd3861f = Pattern.compile("(-?\\d{1,8})(?:\\s*,\\s*|\\s+)(-?\\d{1,8})(?:\\s*,\\s*|\\s+)(-?\\d{1,8})");
    private static final Pattern i_field_5fd3861f = Pattern.compile("(-?\\d{1,8})(?:\\s*,\\s*|\\s+)(-?\\d{1,8})");
    private static final String I_field_523beb0a = "ChatWaypoint";
    private static final MutableText I_field_c0ce3bca = Text.literal((String)IiIiIIII_Class81.I_method_f25a980a("chat_waypoint.hover"));
    private static final int I_field_49 = 70;
    private final IiIIIiII_Class69<ChatRenderEvent> I_field_3d936f41 = this::I_method_523955c6;
    private final IiIIIiII_Class69<ChatClickEvent> i_field_3d936f41 = this::I_method_5f054b0e;

    public IiIIIiiiI_Class143() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    private void I_method_523955c6(ChatRenderEvent chatRenderEvent) {
        if (!(IiIIIiiiI_Class143.I_field_3a9bda27.currentScreen instanceof ChatScreen) || IiIIIiiiI_Class143.I_field_3a9bda27.inGameHud == null) {
            return;
        }
        double d = IiIIIiiiI_Class143.I_field_3a9bda27.mouse.getX() * (double)I_field_3a9bda27.getWindow().getScaledWidth() / (double)I_field_3a9bda27.getWindow().getWidth();
        double d2 = IiIIIiiiI_Class143.I_field_3a9bda27.mouse.getY() * (double)I_field_3a9bda27.getWindow().getScaledHeight() / (double)I_field_3a9bda27.getWindow().getHeight();
        ChatHud chatHud = IiIIIiiiI_Class143.I_field_3a9bda27.inGameHud.getChatHud();
        ChatHudAccessor chatHudAccessor = (ChatHudAccessor)(Object)chatHud;
        double d3 = chatHudAccessor.invokeToChatLineX(d);
        double d4 = chatHudAccessor.invokeToChatLineY(d2);
        if (d3 < 0.0 || d4 < 0.0) {
            return;
        }
        int n = chatHudAccessor.invokeGetMessageLineIndex(d3, d4);
        List<ChatHudLine.Visible> list = chatHudAccessor.getVisibleMessages();
        if (n < 0 || n >= list.size()) {
            return;
        }
        ChatHudLine.Visible visible = list.get(n);
        String string = this.I_method_47f2b43e(visible.content());
        if (string.isBlank()) {
            return;
        }
        if (this.I_method_f7dcaad9(string, d3)) {
            chatRenderEvent.getContext().drawTooltip(IiIIIiiiI_Class143.I_field_3a9bda27.textRenderer, List.of(I_field_c0ce3bca), (int)d, (int)d2);
        }
    }

    private void I_method_5f054b0e(ChatClickEvent chatClickEvent) {
        if (chatClickEvent.getButton() != 0) {
            return;
        }
        if (!(IiIIIiiiI_Class143.I_field_3a9bda27.currentScreen instanceof ChatScreen) || IiIIIiiiI_Class143.I_field_3a9bda27.inGameHud == null) {
            return;
        }
        ChatHud chatHud = IiIIIiiiI_Class143.I_field_3a9bda27.inGameHud.getChatHud();
        ChatHudAccessor chatHudAccessor = (ChatHudAccessor)(Object)chatHud;
        double d = chatHudAccessor.invokeToChatLineX(chatClickEvent.getX());
        double d2 = chatHudAccessor.invokeToChatLineY(chatClickEvent.getY());
        if (d < 0.0 || d2 < 0.0) {
            return;
        }
        int n = chatHudAccessor.invokeGetMessageLineIndex(d, d2);
        List<ChatHudLine.Visible> list = chatHudAccessor.getVisibleMessages();
        if (n < 0 || n >= list.size()) {
            return;
        }
        ChatHudLine.Visible visible = list.get(n);
        String string = this.I_method_47f2b43e(visible.content());
        if (string.isBlank()) {
            return;
        }
        Matcher matcher = I_field_5fd3861f.matcher(string);
        while (matcher.find()) {
            if (!this.I_method_e3260bcd(d, string, matcher.start(), matcher.end())) continue;
            this.I_method_429ceb1d(matcher.group(1), matcher.group(2), matcher.group(3));
            return;
        }
        Matcher matcher2 = i_field_5fd3861f.matcher(string);
        while (matcher2.find()) {
            if (!this.I_method_e3260bcd(d, string, matcher2.start(), matcher2.end())) continue;
            this.I_method_429ceb1d(matcher2.group(1), String.valueOf(70), matcher2.group(2));
            return;
        }
    }

    private boolean I_method_f7dcaad9(String string, double d) {
        Matcher matcher = I_field_5fd3861f.matcher(string);
        while (matcher.find()) {
            if (!this.I_method_e3260bcd(d, string, matcher.start(), matcher.end())) continue;
            return true;
        }
        Matcher matcher2 = i_field_5fd3861f.matcher(string);
        while (matcher2.find()) {
            if (!this.I_method_e3260bcd(d, string, matcher2.start(), matcher2.end())) continue;
            return true;
        }
        return false;
    }

    private boolean I_method_e3260bcd(double d, String string, int n, int n2) {
        int n3 = IiIIIiiiI_Class143.I_field_3a9bda27.textRenderer.getWidth(string.substring(0, n));
        int n4 = IiIIIiiiI_Class143.I_field_3a9bda27.textRenderer.getWidth(string.substring(0, n2));
        return d >= (double)n3 && d <= (double)n4;
    }

    private void I_method_429ceb1d(String string, String string2, String string3) {
        int n;
        int n2;
        int n3;
        try {
            n3 = Integer.parseInt(string);
            n2 = Integer.parseInt(string2);
            n = Integer.parseInt(string3);
        }
        catch (NumberFormatException numberFormatException) {
            n = 0;
            n2 = 0;
            n3 = 0;
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("waypoints.error_coords")));
        }
        IiIIiIIII_Class145 iiIIiIIII_Class145 = RockstarClient.getInstance().I_method_cf3ba442();
        if (iiIIiIIII_Class145.I_method_d7f564d(I_field_523beb0a)) {
            iiIIiIIII_Class145.I_method_d7f5649(I_field_523beb0a);
        }
        iiIIiIIII_Class145.I_method_b71837ba(I_field_523beb0a, n3, n2, n);
    }

    private String I_method_47f2b43e(OrderedText orderedText) {
        StringBuilder stringBuilder = new StringBuilder();
        orderedText.accept((n, style, n2) -> {
            stringBuilder.appendCodePoint(n2);
            return true;
        });
        return stringBuilder.toString();
    }
}

