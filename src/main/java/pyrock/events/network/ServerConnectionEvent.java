package pyrock.events.network;

import lombok.Generated;
import net.minecraft.client.network.CookieStorage;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import rockstar.client.IiIIIIIi_Class66;
import rockstar.client.IiIIIIiI_Class67;

@IiIIIIiI_Class67(I_method_80b3cd54="connect")
public class ServerConnectionEvent
extends IiIIIIIi_Class66 {
    private final ServerAddress address;
    private final ServerInfo info;
    private final CookieStorage cookieStorage;

    @Generated
    public ServerAddress getAddress() {
        return this.address;
    }

    @Generated
    public ServerInfo getInfo() {
        return this.info;
    }

    @Generated
    public CookieStorage getCookieStorage() {
        return this.cookieStorage;
    }

    @Generated
    public ServerConnectionEvent(ServerAddress serverAddress, ServerInfo serverInfo, CookieStorage cookieStorage) {
        this.address = serverAddress;
        this.info = serverInfo;
        this.cookieStorage = cookieStorage;
    }
}

