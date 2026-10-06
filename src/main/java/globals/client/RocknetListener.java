package globals.client;

import globals.client.api.RockNetClient;
import globals.shared.proto.Packet;

public class RocknetListener implements RockNetClient.Nested1_fb6c9cf {
    private static int siteOnline = 0;
    private static int online = 0;

    public static int getSiteOnline() {
        return siteOnline;
    }

    public static int getOnline() {
        return online;
    }

    public static void setSiteOnline(int count) {
        siteOnline = count;
    }

    public static void setOnline(int count) {
        online = count;
    }

    @Override
    public void onPacket(Packet packet) {
    }

    @Override
    public void onError(Exception exception) {
    }

    @Override
    public void onClosed() {
    }
}
