package rockstar.client;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.DiscordBuild;
import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.entities.User;
import globals.shared.proto.Packets;
import java.time.OffsetDateTime;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;
import ua.mintantileak.profile.Profile;

public class IiIIIIII_Class65
implements iIIiIIiIi_Class294 {
    private final IPCClient I_field_69c5846c = new IPCClient(1517438618715820073L);
    private volatile String I_field_523beb0a;
    private volatile String i_field_523beb0a;
    private volatile String II_field_523beb0a;
    volatile boolean I_field_5a;

    RichPresence.Builder I_method_5d4623e1() {
        return new RichPresence.Builder().setDetails("UID: " + Profile.getUid()).setState(String.format("Role: %s", IiIIIIII_Class65.I_method_9e4247ea(Profile.getRole().name()))).setStartTimestamp(OffsetDateTime.now()).setLargeImage("animlogo", "t.me/rockclient").setSmallImage(Profile.getAvatarUrl() == null ? "animlogo" : Profile.getAvatarUrl(), Profile.getUsername()).setButton1Text("Telegram").setButton1Url("https://t.me/rockclient").setButton2Text("Discord").setButton2Url("https://dsc.gg/rockclient");
    }

    public final void I_method_2bd9f0ac() {
        if (!this.I_field_5a) {
            return;
        }
        try {
            this.I_field_69c5846c.sendRichPresence(this.I_method_5d4623e1().build());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void i_method_2be87c8c() {
        try {
            this.I_field_69c5846c.setListener(new IPCListener(){

                public void onReady(IPCClient iPCClient) {
                    IiIIIIII_Class65.this.I_field_5a = true;
                    iPCClient.sendRichPresence(IiIIIIII_Class65.this.I_method_5d4623e1().build());
                    IiIIIIII_Class65.this.I_method_6847c306(iPCClient.getDiscordUser());
                }

                public void onCurrentUserUpdate(IPCClient iPCClient, User user) {
                    IiIIIIII_Class65.this.I_method_6847c306(user);
                }
            });
            this.I_field_69c5846c.connect(new DiscordBuild[0]);
        }
        catch (Exception | LinkageError throwable) {
            RockstarClient.I_field_ab0f6068.warn("Discord RPC connection failed", throwable);
        }
    }

    void I_method_6847c306(User user) {
        if (user == null) {
            return;
        }
        try {
            this.I_field_523beb0a = user.getUsername();
            String string = user.getGlobalName();
            this.i_field_523beb0a = string == null || string.isBlank() ? user.getName() : string;
            this.II_field_523beb0a = user.getEffectiveAvatarUrl();
            this.II_method_4f731c35();
        }
        catch (Exception | LinkageError throwable) {
            RockstarClient.I_field_ab0f6068.warn("Discord user capture failed", throwable);
        }
    }

    public void II_method_4f731c35() {
        String string = this.I_field_523beb0a;
        if (string == null || string.isBlank()) {
            return;
        }
        try {
            RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_4acf32af(string, this.i_field_523beb0a, this.II_field_523beb0a));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static String I_method_9e4247ea(String string) {
        String[] stringArray = string.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : stringArray) {
            if (string2.isEmpty()) continue;
            stringBuilder.append(Character.toUpperCase(string2.charAt(0))).append(string2.substring(1).toLowerCase()).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}

