package globals.client.net;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import globals.client.net.Gz;
import globals.shared.proto.Packet;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class PacketCodec {
    private static final int MAX_STR = 8192;
    private static final int MAX_ARRAY = 4096;
    private static final int MAX_SOURCE = 0x400000;
    private static final int GZIP_FROM = 65536;
    private static final String NICK_PLAIN = "plain";

    private PacketCodec() {
    }

    public static JsonObject toOp(Packet packet) {
        JsonObject jsonObject = new JsonObject();
        if (packet instanceof Packets.Nested1_3c7c7ae4) {
            Packets.Nested1_3c7c7ae4 nested1_3c7c7ae4 = (Packets.Nested1_3c7c7ae4)packet;
            jsonObject.addProperty("op", "chat");
            jsonObject.addProperty("message", nested1_3c7c7ae4.message());
        } else if (packet instanceof Packets.Nested1_d3b0d257) {
            Packets.Nested1_d3b0d257 nested1_d3b0d257 = (Packets.Nested1_d3b0d257)packet;
            jsonObject.addProperty("op", "pm");
            jsonObject.addProperty("toUsername", nested1_d3b0d257.toUsername());
            jsonObject.addProperty("message", nested1_d3b0d257.message());
        } else if (packet instanceof Packets.Nested1_3b6ca75e) {
            Packets.Nested1_3b6ca75e nested1_3b6ca75e = (Packets.Nested1_3b6ca75e)packet;
            jsonObject.addProperty("op", "share-config");
            jsonObject.addProperty("id", (Number)nested1_3b6ca75e.configId());
            jsonObject.addProperty("toUsername", nested1_3b6ca75e.toUsername() == null ? "" : nested1_3b6ca75e.toUsername());
        } else if (packet instanceof Packets.Nested1_f59883b2) {
            Packets.Nested1_f59883b2 nested1_f59883b2 = (Packets.Nested1_f59883b2)packet;
            jsonObject.addProperty("op", "share-swing");
            jsonObject.addProperty("name", nested1_f59883b2.name());
            jsonObject.addProperty("data", nested1_f59883b2.data() == null ? "" : nested1_f59883b2.data());
            jsonObject.addProperty("toUsername", nested1_f59883b2.toUsername() == null ? "" : nested1_f59883b2.toUsername());
        } else if (packet instanceof Packets.Nested1_3a3c486) {
            Packets.Nested1_3a3c486 nested1_3a3c486 = (Packets.Nested1_3a3c486)packet;
            jsonObject.addProperty("op", "share-invbuilder");
            jsonObject.addProperty("name", nested1_3a3c486.name());
            jsonObject.addProperty("data", nested1_3a3c486.data() == null ? "" : nested1_3a3c486.data());
            jsonObject.addProperty("toUsername", nested1_3a3c486.toUsername() == null ? "" : nested1_3a3c486.toUsername());
        } else if (packet instanceof Packets.Nested1_55703e48) {
            Packets.Nested1_55703e48 nested1_55703e48 = (Packets.Nested1_55703e48)packet;
            jsonObject.addProperty("op", "share-claim");
            jsonObject.addProperty("shareId", (Number)nested1_55703e48.shareId());
        } else if (packet instanceof Packets.Nested1_756a47e) {
            Packets.Nested1_756a47e nested1_756a47e = (Packets.Nested1_756a47e)packet;
            jsonObject.addProperty("op", "chat-history");
            jsonObject.addProperty("beforeId", (Number)nested1_756a47e.beforeId());
        } else if (packet instanceof Packets.Nested1_37631c33) {
            Packets.Nested1_37631c33 nested1_37631c33 = (Packets.Nested1_37631c33)packet;
            jsonObject.addProperty("op", "pm-history");
            jsonObject.addProperty("withUsername", nested1_37631c33.withUsername());
            jsonObject.addProperty("beforeId", (Number)nested1_37631c33.beforeId());
        } else if (packet instanceof Packets.Nested1_6bdee275) {
            Packets.Nested1_6bdee275 nested1_6bdee275 = (Packets.Nested1_6bdee275)packet;
            jsonObject.addProperty("op", "people-list");
            jsonObject.addProperty("query", nested1_6bdee275.query() == null ? "" : nested1_6bdee275.query());
            jsonObject.addProperty("page", (Number)nested1_6bdee275.page());
        } else if (packet instanceof Packets.Nested1_40acf5d1) {
            Packets.Nested1_40acf5d1 nested1_40acf5d1 = (Packets.Nested1_40acf5d1)packet;
            jsonObject.addProperty("op", "profile");
            jsonObject.addProperty("username", nested1_40acf5d1.username());
        } else if (packet instanceof Packets.Nested1_3565170) {
            Packets.Nested1_3565170 nested1_3565170 = (Packets.Nested1_3565170)packet;
            jsonObject.addProperty("op", "mod-mute");
            jsonObject.addProperty("username", nested1_3565170.username());
            jsonObject.addProperty("seconds", (Number)nested1_3565170.seconds());
            jsonObject.addProperty("reason", nested1_3565170.reason() == null ? "" : nested1_3565170.reason());
        } else if (packet instanceof Packets.Nested1_9448f1c9) {
            Packets.Nested1_9448f1c9 nested1_9448f1c9 = (Packets.Nested1_9448f1c9)packet;
            jsonObject.addProperty("op", "mod-unmute");
            jsonObject.addProperty("username", nested1_9448f1c9.username());
        } else if (packet instanceof Packets.Nested1_bc77be65) {
            Packets.Nested1_bc77be65 nested1_bc77be65 = (Packets.Nested1_bc77be65)packet;
            jsonObject.addProperty("op", "mod-delete");
            jsonObject.addProperty("id", (Number)nested1_bc77be65.id());
        } else if (packet instanceof Packets.Nested1_17a3bc2e) {
            Packets.Nested1_17a3bc2e nested1_17a3bc2e = (Packets.Nested1_17a3bc2e)packet;
            jsonObject.addProperty("op", "friend-request");
            jsonObject.addProperty("username", nested1_17a3bc2e.toUsername());
        } else if (packet instanceof Packets.Nested1_9ecd102e) {
            Packets.Nested1_9ecd102e nested1_9ecd102e = (Packets.Nested1_9ecd102e)packet;
            jsonObject.addProperty("op", "friend-accept");
            jsonObject.addProperty("username", nested1_9ecd102e.username());
        } else if (packet instanceof Packets.Nested1_bbeecec5) {
            Packets.Nested1_bbeecec5 nested1_bbeecec5 = (Packets.Nested1_bbeecec5)packet;
            jsonObject.addProperty("op", "friend-reject");
            jsonObject.addProperty("username", nested1_bbeecec5.username());
        } else if (packet instanceof Packets.Nested1_8e89c4ad) {
            Packets.Nested1_8e89c4ad nested1_8e89c4ad = (Packets.Nested1_8e89c4ad)packet;
            jsonObject.addProperty("op", "friend-remove");
            jsonObject.addProperty("username", nested1_8e89c4ad.username());
        } else if (packet instanceof Packets.Nested1_bed2a5d4) {
            Packets.Nested1_bed2a5d4 nested1_bed2a5d4 = (Packets.Nested1_bed2a5d4)packet;
            jsonObject.addProperty("op", "game-info");
            jsonObject.addProperty("nickname", nested1_bed2a5d4.nickname());
            jsonObject.addProperty("anarchy", nested1_bed2a5d4.anarchy());
            jsonObject.addProperty("server", nested1_bed2a5d4.server());
            jsonObject.addProperty("ip", nested1_bed2a5d4.ip());
            jsonObject.addProperty("hash", nested1_bed2a5d4.hash());
            jsonObject.addProperty("visibility", nested1_bed2a5d4.visibility());
            jsonObject.addProperty("clientName", nested1_bed2a5d4.clientName());
        } else if (packet instanceof Packets.Nested1_3422a40) {
            Packets.Nested1_3422a40 nested1_3422a40 = (Packets.Nested1_3422a40)packet;
            jsonObject.addProperty("op", "client-join");
            jsonObject.addProperty("server", nested1_3422a40.server());
            jsonObject.addProperty("ip", nested1_3422a40.ip());
            jsonObject.addProperty("host", nested1_3422a40.host());
            jsonObject.addProperty("nickname", nested1_3422a40.nickname());
            jsonObject.addProperty("clientName", nested1_3422a40.clientName());
        } else if (packet instanceof Packets.Nested1_65841a0c) {
            Packets.Nested1_65841a0c nested1_65841a0c = (Packets.Nested1_65841a0c)packet;
            jsonObject.addProperty("op", "client-start");
            jsonObject.addProperty("clientName", nested1_65841a0c.clientName());
            jsonObject.addProperty("version", nested1_65841a0c.version());
        } else if (packet instanceof Packets.Nested1_4acf32af) {
            Packets.Nested1_4acf32af nested1_4acf32af = (Packets.Nested1_4acf32af)packet;
            jsonObject.addProperty("op", "discord");
            jsonObject.addProperty("username", nested1_4acf32af.username());
            jsonObject.addProperty("globalName", nested1_4acf32af.globalName());
            jsonObject.addProperty("avatarUrl", nested1_4acf32af.avatarUrl());
        } else if (packet instanceof Packets.Nested1_cff648e6) {
            Packets.Nested1_cff648e6 nested1_cff648e6 = (Packets.Nested1_cff648e6)packet;
            jsonObject.addProperty("op", "visibility");
            jsonObject.addProperty("visibility", nested1_cff648e6.visibility());
        } else if (packet instanceof Packets.Nested1_a4f5c5e3) {
            Packets.Nested1_a4f5c5e3 nested1_a4f5c5e3 = (Packets.Nested1_a4f5c5e3)packet;
            jsonObject.addProperty("op", "activity");
            jsonObject.addProperty("activity", nested1_a4f5c5e3.activity());
        } else if (packet instanceof Packets.Nested1_3630dbf0) {
            Packets.Nested1_3630dbf0 nested1_3630dbf0 = (Packets.Nested1_3630dbf0)packet;
            jsonObject.addProperty("op", "create-way");
            jsonObject.addProperty("name", nested1_3630dbf0.name());
            jsonObject.add("vector", (JsonElement)PacketCodec.vec(nested1_3630dbf0.vector()));
            jsonObject.addProperty("anarchy", nested1_3630dbf0.anarchy());
            jsonObject.addProperty("server", nested1_3630dbf0.server());
            jsonObject.addProperty("hash", nested1_3630dbf0.hash());
            jsonObject.addProperty("livingTime", (Number)nested1_3630dbf0.livingTime());
            jsonObject.addProperty("color", (Number)nested1_3630dbf0.color());
        } else if (packet instanceof Packets.Nested1_571f5383) {
            Packets.Nested1_571f5383 nested1_571f5383 = (Packets.Nested1_571f5383)packet;
            jsonObject.addProperty("op", "update-way");
            jsonObject.addProperty("name", nested1_571f5383.name());
            jsonObject.add("vector", (JsonElement)PacketCodec.vec(nested1_571f5383.vector()));
            jsonObject.addProperty("anarchy", nested1_571f5383.anarchy());
            jsonObject.addProperty("server", nested1_571f5383.server());
            jsonObject.addProperty("hash", nested1_571f5383.hash());
        } else if (packet instanceof Packets.Nested1_c59442a1) {
            Packets.Nested1_c59442a1 nested1_c59442a1 = (Packets.Nested1_c59442a1)packet;
            jsonObject.addProperty("op", "snowball");
            jsonObject.add("position", (JsonElement)PacketCodec.vec(nested1_c59442a1.position()));
            jsonObject.add("direction", (JsonElement)PacketCodec.vec(nested1_c59442a1.direction()));
            jsonObject.addProperty("anarchy", nested1_c59442a1.anarchy());
            jsonObject.addProperty("server", nested1_c59442a1.server());
            jsonObject.addProperty("hash", nested1_c59442a1.hash());
        } else if (packet instanceof Packets.Nested1_57f4c35d) {
            Packets.Nested1_57f4c35d nested1_57f4c35d = (Packets.Nested1_57f4c35d)packet;
            jsonObject.addProperty("op", "admin-broadcast");
            jsonObject.addProperty("message", nested1_57f4c35d.message());
        } else if (packet instanceof Packets.Nested1_e908ec43) {
            Packets.Nested1_e908ec43 nested1_e908ec43 = (Packets.Nested1_e908ec43)packet;
            PacketCodec.adminTarget(jsonObject, "admin-crash", nested1_e908ec43.nickname(), nested1_e908ec43.anarchy(), nested1_e908ec43.server(), nested1_e908ec43.hash());
        } else if (packet instanceof Packets.Nested1_3d34c57b) {
            Packets.Nested1_3d34c57b nested1_3d34c57b = (Packets.Nested1_3d34c57b)packet;
            PacketCodec.adminTarget(jsonObject, "admin-freeze", nested1_3d34c57b.nickname(), nested1_3d34c57b.anarchy(), nested1_3d34c57b.server(), nested1_3d34c57b.hash());
        } else if (packet instanceof Packets.Nested1_8149454) {
            Packets.Nested1_8149454 nested1_8149454 = (Packets.Nested1_8149454)packet;
            PacketCodec.adminTarget(jsonObject, "admin-unfreeze", nested1_8149454.nickname(), nested1_8149454.anarchy(), nested1_8149454.server(), nested1_8149454.hash());
        } else if (packet instanceof Packets.Nested1_53e3ad0b) {
            Packets.Nested1_53e3ad0b nested1_53e3ad0b = (Packets.Nested1_53e3ad0b)packet;
            PacketCodec.adminTarget(jsonObject, "admin-off", nested1_53e3ad0b.nickname(), nested1_53e3ad0b.anarchy(), nested1_53e3ad0b.server(), nested1_53e3ad0b.hash());
        } else if (packet instanceof Packets.Nested1_288d22d3) {
            Packets.Nested1_288d22d3 nested1_288d22d3 = (Packets.Nested1_288d22d3)packet;
            PacketCodec.adminTarget(jsonObject, "admin-drop", nested1_288d22d3.nickname(), nested1_288d22d3.anarchy(), nested1_288d22d3.server(), nested1_288d22d3.hash());
        } else if (packet instanceof Packets.Nested1_14a1683a) {
            Packets.Nested1_14a1683a nested1_14a1683a = (Packets.Nested1_14a1683a)packet;
            PacketCodec.adminTarget(jsonObject, "admin-shutdown", nested1_14a1683a.nickname(), nested1_14a1683a.anarchy(), nested1_14a1683a.server(), nested1_14a1683a.hash());
        } else if (packet instanceof Packets.Nested1_42226586) {
            Packets.Nested1_42226586 nested1_42226586 = (Packets.Nested1_42226586)packet;
            PacketCodec.adminTarget(jsonObject, "admin-invsee", nested1_42226586.nickname(), nested1_42226586.anarchy(), nested1_42226586.server(), nested1_42226586.hash());
            jsonObject.addProperty("slot", (Number)nested1_42226586.slot());
            jsonObject.addProperty("button", (Number)nested1_42226586.button());
            jsonObject.addProperty("action", nested1_42226586.action());
        } else if (packet instanceof Packets.Nested1_f7ef762e) {
            Packets.Nested1_f7ef762e nested1_f7ef762e = (Packets.Nested1_f7ef762e)packet;
            jsonObject.addProperty("op", "admin-invsee-data");
            jsonObject.addProperty("data", nested1_f7ef762e.data());
        } else if (packet instanceof Packets.Nested1_f32063a8) {
            jsonObject.addProperty("op", "config-sync");
        } else if (packet instanceof Packets.Nested1_f3200a8a) {
            Packets.Nested1_f3200a8a nested1_f3200a8a = (Packets.Nested1_f3200a8a)packet;
            jsonObject.addProperty("op", "config-save");
            if (nested1_f3200a8a.id() != null) {
                jsonObject.addProperty("id", (Number)nested1_f3200a8a.id());
            }
            if (nested1_f3200a8a.name() != null) {
                jsonObject.addProperty("name", nested1_f3200a8a.name());
            }
            if (nested1_f3200a8a.data() != null) {
                jsonObject.add("data", (JsonElement)nested1_f3200a8a.data());
            }
        } else if (packet instanceof Packets.Nested1_9addad72) {
            Packets.Nested1_9addad72 nested1_9addad72 = (Packets.Nested1_9addad72)packet;
            jsonObject.addProperty("op", "config-import");
            jsonObject.addProperty("name", nested1_9addad72.name());
            if (nested1_9addad72.data() != null) {
                jsonObject.add("data", (JsonElement)nested1_9addad72.data());
            }
        } else if (packet instanceof Packets.Nested1_fac62d1b) {
            Packets.Nested1_fac62d1b nested1_fac62d1b = (Packets.Nested1_fac62d1b)packet;
            jsonObject.addProperty("op", "config-set-active");
            jsonObject.addProperty("id", (Number)nested1_fac62d1b.id());
        } else if (packet instanceof Packets.Nested1_a9c7710b) {
            Packets.Nested1_a9c7710b nested1_a9c7710b = (Packets.Nested1_a9c7710b)packet;
            jsonObject.addProperty("op", "config-rename");
            jsonObject.addProperty("id", (Number)nested1_a9c7710b.id());
            jsonObject.addProperty("name", nested1_a9c7710b.name());
        } else if (packet instanceof Packets.Nested1_3eeaa41e) {
            Packets.Nested1_3eeaa41e nested1_3eeaa41e = (Packets.Nested1_3eeaa41e)packet;
            jsonObject.addProperty("op", "config-duplicate");
            jsonObject.addProperty("id", (Number)nested1_3eeaa41e.id());
        } else if (packet instanceof Packets.Nested1_91e2bf78) {
            Packets.Nested1_91e2bf78 nested1_91e2bf78 = (Packets.Nested1_91e2bf78)packet;
            jsonObject.addProperty("op", "config-delete");
            jsonObject.addProperty("id", (Number)nested1_91e2bf78.id());
        } else if (packet instanceof Packets.Nested1_f32121f1) {
            Packets.Nested1_f32121f1 nested1_f32121f1 = (Packets.Nested1_f32121f1)packet;
            jsonObject.addProperty("op", "config-undo");
            jsonObject.addProperty("id", (Number)nested1_f32121f1.id());
        } else if (packet instanceof Packets.Nested1_8f61585b) {
            jsonObject.addProperty("op", "script-pull");
            jsonObject.addProperty("gz", Boolean.valueOf(true));
        } else if (packet instanceof Packets.Nested1_8f626b93) {
            Packets.Nested1_8f626b93 nested1_8f626b93 = (Packets.Nested1_8f626b93)packet;
            jsonObject.addProperty("op", "script-save");
            jsonObject.addProperty("name", nested1_8f626b93.name());
            if (nested1_8f626b93.language() != null) {
                jsonObject.addProperty("language", nested1_8f626b93.language());
            }
            PacketCodec.putSource(jsonObject, "source", nested1_8f626b93.source() == null ? "" : nested1_8f626b93.source());
        } else if (packet instanceof Packets.Nested1_27110241) {
            Packets.Nested1_27110241 nested1_27110241 = (Packets.Nested1_27110241)packet;
            jsonObject.addProperty("op", "script-delete");
            jsonObject.addProperty("name", nested1_27110241.name());
        } else if (packet instanceof Packets.Nested1_3ef5b3d4) {
            Packets.Nested1_3ef5b3d4 nested1_3ef5b3d4 = (Packets.Nested1_3ef5b3d4)packet;
            jsonObject.addProperty("op", "script-rename");
            jsonObject.addProperty("from", nested1_3ef5b3d4.from());
            jsonObject.addProperty("to", nested1_3ef5b3d4.to());
        } else if (packet instanceof Packets.Nested1_a3fa6b7b) {
            jsonObject.addProperty("op", "client-data-sync");
        } else if (packet instanceof Packets.Nested1_a3fa125d) {
            Packets.Nested1_a3fa125d nested1_a3fa125d = (Packets.Nested1_a3fa125d)packet;
            jsonObject.addProperty("op", "client-data-save");
            if (nested1_a3fa125d.data() != null) {
                jsonObject.add("data", (JsonElement)nested1_a3fa125d.data());
            }
        } else if (packet instanceof Packets.Nested1_e8939e81) {
            Packets.Nested1_e8939e81 nested1_e8939e81 = (Packets.Nested1_e8939e81)packet;
            jsonObject.addProperty("op", "autofarm-state");
            PacketCodec.merge(jsonObject, nested1_e8939e81.payload());
        } else if (packet instanceof Packets.Nested1_24ba7b4c) {
            Packets.Nested1_24ba7b4c nested1_24ba7b4c = (Packets.Nested1_24ba7b4c)packet;
            jsonObject.addProperty("op", "autofarm-inventory");
            PacketCodec.merge(jsonObject, nested1_24ba7b4c.payload());
        } else {
            return null;
        }
        return jsonObject;
    }

    public static Packet fromMessage(JsonObject jsonObject) {
        switch (PacketCodec.str(jsonObject, "kind")) {
            case "online_count": {
                return new Packets.Nested1_8aa53931(PacketCodec.intv(jsonObject, "total"), PacketCodec.intv(jsonObject, "guests"), PacketCodec.intv(jsonObject, "site"));
            }
            case "friends_update": {
                return new Packets.Nested1_f933e433(PacketCodec.friends(jsonObject.getAsJsonArray("friends")));
            }
            case "visible_players_update": {
                return new Packets.Nested1_78bb0ab4(PacketCodec.friends(jsonObject.getAsJsonArray("players")));
            }
            case "friend_requests_update": {
                return new Packets.Nested1_789f34d6(PacketCodec.strings(jsonObject.getAsJsonArray("requests")));
            }
            case "message": {
                return new Packets.Nested1_f32a353c(PacketCodec.longv(jsonObject, "id"), PacketCodec.user(PacketCodec.obj(jsonObject, "author")), PacketCodec.str(jsonObject, "message"));
            }
            case "private_message": {
                return new Packets.Nested1_58423e2f(PacketCodec.longv(jsonObject, "id"), PacketCodec.user(PacketCodec.obj(jsonObject, "author")), PacketCodec.str(jsonObject, "toUsername"), PacketCodec.str(jsonObject, "message"));
            }
            case "swing_preset": {
                return new Packets.Nested1_1db1e4fc(PacketCodec.str(jsonObject, "name"), PacketCodec.src(jsonObject, "data"));
            }
            case "invbuilder_preset": {
                return new Packets.Nested1_274d161e(PacketCodec.str(jsonObject, "name"), PacketCodec.src(jsonObject, "data"));
            }
            case "share_result": {
                return new Packets.Nested1_71d5f391(PacketCodec.str(jsonObject, "shareKind"), PacketCodec.str(jsonObject, "name"), PacketCodec.boolv(jsonObject, "ok"), PacketCodec.str(jsonObject, "error"));
            }
            case "chat_history": {
                return new Packets.Nested1_1d3d88d1(PacketCodec.historyMessages(PacketCodec.arr(jsonObject, "messages")), PacketCodec.longv(jsonObject, "beforeId"), PacketCodec.boolv(jsonObject, "more"));
            }
            case "pm_history": {
                return new Packets.Nested1_569722bc(PacketCodec.str(jsonObject, "with"), PacketCodec.historyMessages(PacketCodec.arr(jsonObject, "messages")), PacketCodec.longv(jsonObject, "beforeId"), PacketCodec.boolv(jsonObject, "more"));
            }
            case "create_way": {
                return new Packets.Nested1_4af0fc48(PacketCodec.friend(PacketCodec.obj(jsonObject, "author")), PacketCodec.str(jsonObject, "name"), PacketCodec.vector(PacketCodec.obj(jsonObject, "vector")), PacketCodec.str(jsonObject, "anarchy"), PacketCodec.str(jsonObject, "server"), PacketCodec.str(jsonObject, "hash"), PacketCodec.longv(jsonObject, "livingTime"), PacketCodec.intv(jsonObject, "color"));
            }
            case "update_way": {
                return new Packets.Nested1_b318355b(PacketCodec.friend(PacketCodec.obj(jsonObject, "author")), PacketCodec.str(jsonObject, "name"), PacketCodec.vector(PacketCodec.obj(jsonObject, "vector")), PacketCodec.str(jsonObject, "anarchy"), PacketCodec.str(jsonObject, "server"), PacketCodec.str(jsonObject, "hash"));
            }
            case "snowball_throw": {
                return new Packets.Nested1_2a2d6379(PacketCodec.friend(PacketCodec.obj(jsonObject, "author")), PacketCodec.vector(PacketCodec.obj(jsonObject, "position")), PacketCodec.vector(PacketCodec.obj(jsonObject, "direction")), PacketCodec.str(jsonObject, "anarchy"), PacketCodec.str(jsonObject, "server"), PacketCodec.str(jsonObject, "hash"));
            }
            case "admin_broadcast": {
                return new Packets.Nested1_57f4c35d(PacketCodec.str(jsonObject, "message"));
            }
            case "admin_crash": {
                return new Packets.Nested1_e908ec43("", "", "", "");
            }
            case "admin_freeze": {
                return new Packets.Nested1_3d34c57b("", "", "", "");
            }
            case "admin_unfreeze": {
                return new Packets.Nested1_8149454("", "", "", "");
            }
            case "admin_off": {
                return new Packets.Nested1_53e3ad0b("", "", "", "");
            }
            case "admin_drop": {
                return new Packets.Nested1_288d22d3("", "", "", "");
            }
            case "admin_shutdown": {
                return new Packets.Nested1_14a1683a("", "", "", "");
            }
            case "admin_result": {
                return new Packets.Nested1_50fe5301(PacketCodec.str(jsonObject, "action"), PacketCodec.str(jsonObject, "nickname"), PacketCodec.intv(jsonObject, "count"));
            }
            case "admin_invsee": {
                return new Packets.Nested1_4eb70229(PacketCodec.str(jsonObject, "requester"), PacketCodec.intv(jsonObject, "slot"), PacketCodec.intv(jsonObject, "button"), PacketCodec.str(jsonObject, "action"));
            }
            case "admin_invsee_data": {
                return new Packets.Nested1_f7e89650(PacketCodec.str(jsonObject, "from"), PacketCodec.str(jsonObject, "nickname"), PacketCodec.src(jsonObject, "data"));
            }
            case "config_list": {
                return new Packets.Nested1_f31cf9ab(PacketCodec.slots(jsonObject.getAsJsonArray("configs")));
            }
            case "config_data": {
                return new Packets.Nested1_f31938b7(PacketCodec.longv(jsonObject, "id"), PacketCodec.str(jsonObject, "name"), PacketCodec.boolv(jsonObject, "active"), PacketCodec.obj(jsonObject, "data"));
            }
            case "script_sync": {
                return new Packets.Nested1_e23f67fb(PacketCodec.scriptItems(jsonObject.getAsJsonArray("scripts")));
            }
            case "script_apply": {
                return new Packets.Nested1_5bf41c18(PacketCodec.str(jsonObject, "name"), PacketCodec.str(jsonObject, "language"), PacketCodec.src(jsonObject, "source"), PacketCodec.strList(jsonObject, "libraries"));
            }
            case "script_remove": {
                return new Packets.Nested1_3ef5751a(PacketCodec.str(jsonObject, "name"));
            }
            case "script_rename": {
                return new Packets.Nested1_b32e23fa(PacketCodec.str(jsonObject, "from"), PacketCodec.str(jsonObject, "to"));
            }
            case "script_protected": {
                return new Packets.Nested1_25729f58(PacketCodec.str(jsonObject, "name"), PacketCodec.str(jsonObject, "language"), PacketCodec.src(jsonObject, "blob"), PacketCodec.strList(jsonObject, "libraries"));
            }
            case "client_data": {
                return new Packets.Nested1_33f3cc0(PacketCodec.obj(jsonObject, "data"));
            }
            case "autofarm_request": {
                return new Packets.Nested1_c489107f(PacketCodec.str(jsonObject, "reqId"), PacketCodec.str(jsonObject, "action"), PacketCodec.str(jsonObject, "key"), PacketCodec.str(jsonObject, "option"), jsonObject.get("value"));
            }
            case "cosmetics_catalog": {
                return new Packets.Nested1_9204be60(PacketCodec.cosmeticStyles(PacketCodec.arr(jsonObject, "styles")));
            }
            case "self_cosmetics": {
                return new Packets.Nested1_1c5c530d(PacketCodec.str(jsonObject, "badge"), PacketCodec.nickStyle(jsonObject));
            }
            case "self_info": {
                return new Packets.Nested1_d4af9385(PacketCodec.str(jsonObject, "username"), PacketCodec.intv(jsonObject, "uid"), PacketCodec.str(jsonObject, "role"));
            }
            case "people_list": {
                return new Packets.Nested1_e0d3a78(PacketCodec.str(jsonObject, "query"), PacketCodec.intv(jsonObject, "page"), PacketCodec.boolv(jsonObject, "more"), PacketCodec.people(PacketCodec.arr(jsonObject, "people")));
            }
            case "profile": {
                return new Packets.Nested1_a7cdbede(PacketCodec.str(jsonObject, "username"), PacketCodec.intv(jsonObject, "uid"), PacketCodec.str(jsonObject, "role"), PacketCodec.str(jsonObject, "badge"), PacketCodec.nickStyle(jsonObject), PacketCodec.boolv(jsonObject, "online"), PacketCodec.boolv(jsonObject, "inGame"), PacketCodec.str(jsonObject, "status"), PacketCodec.lastSeen(jsonObject), PacketCodec.longv(jsonObject, "registered"), PacketCodec.longv(jsonObject, "playtime"), PacketCodec.intv(jsonObject, "friendCount"), PacketCodec.strings(PacketCodec.arr(jsonObject, "mutual")), PacketCodec.intv(jsonObject, "mutualCount"), PacketCodec.str(jsonObject, "relationship"), PacketCodec.longv(jsonObject, "mutedUntil"));
            }
            case "profile_error": {
                return new Packets.Nested1_e7eebdca(PacketCodec.str(jsonObject, "username"), PacketCodec.str(jsonObject, "error"));
            }
            case "mod_result": {
                return new Packets.Nested1_8eae4db4(PacketCodec.str(jsonObject, "action"), PacketCodec.str(jsonObject, "username"), PacketCodec.boolv(jsonObject, "ok"));
            }
            case "message_deleted": {
                return new Packets.Nested1_c049773d(PacketCodec.longv(jsonObject, "id"), PacketCodec.str(jsonObject, "toUsername"));
            }
            case "chat_muted": {
                return new Packets.Nested1_86da80e8(PacketCodec.longv(jsonObject, "until"), PacketCodec.str(jsonObject, "reason"));
            }
            case "chat_unmuted": {
                return new Packets.Nested1_d522beaf();
            }
        }
        return null;
    }

    private static List<Packets.Nested1_2dfe6b80> people(JsonArray jsonArray) {
        ArrayList<Packets.Nested1_2dfe6b80> arrayList = new ArrayList<Packets.Nested1_2dfe6b80>();
        if (jsonArray == null) {
            return arrayList;
        }
        int n = Math.min(jsonArray.size(), 4096);
        for (int i = 0; i < n; ++i) {
            if (!jsonArray.get(i).isJsonObject()) continue;
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            arrayList.add(new Packets.Nested1_2dfe6b80(PacketCodec.str(jsonObject, "username"), PacketCodec.str(jsonObject, "role"), PacketCodec.str(jsonObject, "badge"), PacketCodec.nickStyle(jsonObject), PacketCodec.boolv(jsonObject, "online"), PacketCodec.lastSeen(jsonObject)));
        }
        return arrayList;
    }

    private static long lastSeen(JsonObject jsonObject) {
        long l = jsonObject.has("lastSeenAgo") ? PacketCodec.longv(jsonObject, "lastSeenAgo") : -1L;
        return l < 0L ? 0L : System.currentTimeMillis() - l * 1000L;
    }

    private static List<Packets.Nested1_5af299fe> historyMessages(JsonArray jsonArray) {
        ArrayList<Packets.Nested1_5af299fe> arrayList = new ArrayList<Packets.Nested1_5af299fe>();
        if (jsonArray == null) {
            return arrayList;
        }
        int n = Math.min(jsonArray.size(), 4096);
        for (int i = 0; i < n; ++i) {
            if (!jsonArray.get(i).isJsonObject()) continue;
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            arrayList.add(new Packets.Nested1_5af299fe(PacketCodec.longv(jsonObject, "id"), PacketCodec.user(PacketCodec.obj(jsonObject, "author")), PacketCodec.str(jsonObject, "toUsername"), PacketCodec.str(jsonObject, "message"), PacketCodec.longv(jsonObject, "ts")));
        }
        return arrayList;
    }

    private static List<Packets.Nested1_8f5e2529> scriptItems(JsonArray jsonArray) {
        ArrayList<Packets.Nested1_8f5e2529> arrayList = new ArrayList<Packets.Nested1_8f5e2529>();
        if (jsonArray != null) {
            int n = Math.min(jsonArray.size(), 4096);
            for (int i = 0; i < n; ++i) {
                if (!jsonArray.get(i).isJsonObject()) continue;
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                arrayList.add(new Packets.Nested1_8f5e2529(PacketCodec.str(jsonObject, "name"), PacketCodec.str(jsonObject, "language"), PacketCodec.src(jsonObject, "source"), PacketCodec.strList(jsonObject, "libraries")));
            }
        }
        return arrayList;
    }

    private static String src(JsonObject jsonObject, String string) {
        String string2 = string + "Gz";
        if (jsonObject.has(string2) && !jsonObject.get(string2).isJsonNull()) {
            String string3 = Gz.inflateBase64(jsonObject.get(string2).getAsString(), 0x400000);
            if (string3 != null) {
                return string3;
            }
            return "";
        }
        if (!jsonObject.has(string) || jsonObject.get(string).isJsonNull()) {
            return "";
        }
        String string4 = jsonObject.get(string).getAsString();
        return string4.length() > 0x400000 ? string4.substring(0, 0x400000) : string4;
    }

    private static void putSource(JsonObject jsonObject, String string, String string2) {
        String string3;
        if (string2.length() >= 65536 && (string3 = Gz.deflateBase64(string2)) != null) {
            jsonObject.addProperty(string + "Gz", string3);
            return;
        }
        jsonObject.addProperty(string, string2);
    }

    private static List<Packets.Nested1_f320330b> slots(JsonArray jsonArray) {
        ArrayList<Packets.Nested1_f320330b> arrayList = new ArrayList<Packets.Nested1_f320330b>();
        if (jsonArray != null) {
            int n = Math.min(jsonArray.size(), 4096);
            for (int i = 0; i < n; ++i) {
                if (!jsonArray.get(i).isJsonObject()) continue;
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                arrayList.add(new Packets.Nested1_f320330b(PacketCodec.longv(jsonObject, "id"), PacketCodec.str(jsonObject, "name"), PacketCodec.boolv(jsonObject, "active")));
            }
        }
        return arrayList;
    }

    private static boolean boolv(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && !jsonObject.get(string).isJsonNull() && jsonObject.get(string).getAsBoolean();
    }

    private static void adminTarget(JsonObject jsonObject, String string, String string2, String string3, String string4, String string5) {
        jsonObject.addProperty("op", string);
        jsonObject.addProperty("nickname", string2);
        jsonObject.addProperty("anarchy", string3);
        jsonObject.addProperty("server", string4);
        jsonObject.addProperty("hash", string5);
    }

    private static void merge(JsonObject jsonObject, JsonObject jsonObject2) {
        if (jsonObject2 == null) {
            return;
        }
        for (Map.Entry entry : jsonObject2.entrySet()) {
            jsonObject.add((String)entry.getKey(), (JsonElement)entry.getValue());
        }
    }

    private static JsonObject vec(Packets.Nested1_3834b16e nested1_3834b16e) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("x", (Number)nested1_3834b16e.x());
        jsonObject.addProperty("y", (Number)nested1_3834b16e.y());
        jsonObject.addProperty("z", (Number)nested1_3834b16e.z());
        return jsonObject;
    }

    private static Packets.Nested1_3834b16e vector(JsonObject jsonObject) {
        if (jsonObject == null) {
            return new Packets.Nested1_3834b16e(0.0, 0.0, 0.0);
        }
        return new Packets.Nested1_3834b16e(PacketCodec.dbl(jsonObject, "x"), PacketCodec.dbl(jsonObject, "y"), PacketCodec.dbl(jsonObject, "z"));
    }

    private static Packets.Nested1_e38dcab6 user(JsonObject jsonObject) {
        if (jsonObject == null) {
            return new Packets.Nested1_e38dcab6("", "user", "", "", "", NICK_PLAIN);
        }
        return new Packets.Nested1_e38dcab6(PacketCodec.str(jsonObject, "username"), PacketCodec.str(jsonObject, "role"), PacketCodec.str(jsonObject, "activity"), PacketCodec.str(jsonObject, "client"), PacketCodec.str(jsonObject, "badge"), PacketCodec.nickStyle(jsonObject));
    }

    private static String nickStyle(JsonObject jsonObject) {
        String string = PacketCodec.str(jsonObject, "nickStyle");
        return string == null || string.isEmpty() ? NICK_PLAIN : string;
    }

    private static Packets.Nested1_242f4d2b gameInfo(JsonObject jsonObject) {
        if (jsonObject == null) {
            return new Packets.Nested1_242f4d2b("", "", "", "", "", "all", "");
        }
        return new Packets.Nested1_242f4d2b(PacketCodec.str(jsonObject, "nickname"), PacketCodec.str(jsonObject, "anarchy"), PacketCodec.str(jsonObject, "server"), PacketCodec.str(jsonObject, "ip"), PacketCodec.str(jsonObject, "hash"), PacketCodec.str(jsonObject, "visibility"), PacketCodec.str(jsonObject, "clientName"));
    }

    private static Packets.Nested1_1da0dac9 friend(JsonObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        JsonObject jsonObject2 = PacketCodec.obj(jsonObject, "gameInfo");
        Packets.Nested1_242f4d2b nested1_242f4d2b = PacketCodec.gameInfo(jsonObject2);
        String string = jsonObject2 != null ? PacketCodec.str(jsonObject2, "clientName") : "";
        long l = jsonObject.has("lastSeenAgo") ? PacketCodec.longv(jsonObject, "lastSeenAgo") : -1L;
        long l2 = l < 0L ? 0L : System.currentTimeMillis() - l * 1000L;
        return new Packets.Nested1_1da0dac9(PacketCodec.str(jsonObject, "username"), PacketCodec.str(jsonObject, "role"), PacketCodec.str(jsonObject, "activity"), nested1_242f4d2b, string, PacketCodec.str(jsonObject, "visibility"), PacketCodec.str(jsonObject, "badge"), PacketCodec.nickStyle(jsonObject), l2);
    }

    private static List<Packets.Nested1_d6cfc997> cosmeticStyles(JsonArray jsonArray) {
        ArrayList<Packets.Nested1_d6cfc997> arrayList = new ArrayList<Packets.Nested1_d6cfc997>();
        if (jsonArray == null) {
            return arrayList;
        }
        int n = Math.min(jsonArray.size(), 4096);
        for (int i = 0; i < n; ++i) {
            if (!jsonArray.get(i).isJsonObject()) continue;
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            arrayList.add(new Packets.Nested1_d6cfc997(PacketCodec.str(jsonObject, "type"), PacketCodec.str(jsonObject, "key"), PacketCodec.gradientStops(PacketCodec.arr(jsonObject, "stops")), PacketCodec.str(jsonObject, "effect"), PacketCodec.str(jsonObject, "glow")));
        }
        return arrayList;
    }

    private static List<Packets.Nested1_bdbb1f3d> gradientStops(JsonArray jsonArray) {
        ArrayList<Packets.Nested1_bdbb1f3d> arrayList = new ArrayList<Packets.Nested1_bdbb1f3d>();
        if (jsonArray == null) {
            return arrayList;
        }
        int n = Math.min(jsonArray.size(), 4096);
        for (int i = 0; i < n; ++i) {
            if (!jsonArray.get(i).isJsonObject()) continue;
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            arrayList.add(new Packets.Nested1_bdbb1f3d(PacketCodec.dbl(jsonObject, "o"), PacketCodec.hex(PacketCodec.str(jsonObject, "c"))));
        }
        return arrayList;
    }

    private static int hex(String string) {
        String string2;
        if (string == null) {
            return 0xFFFFFF;
        }
        String string3 = string2 = string.startsWith("#") ? string.substring(1) : string;
        if (string2.length() != 6) {
            return 0xFFFFFF;
        }
        try {
            return Integer.parseInt(string2, 16);
        }
        catch (NumberFormatException numberFormatException) {
            return 0xFFFFFF;
        }
    }

    private static List<Packets.Nested1_1da0dac9> friends(JsonArray jsonArray) {
        ArrayList<Packets.Nested1_1da0dac9> arrayList = new ArrayList<Packets.Nested1_1da0dac9>();
        if (jsonArray != null) {
            int n = Math.min(jsonArray.size(), 4096);
            for (int i = 0; i < n; ++i) {
                Packets.Nested1_1da0dac9 nested1_1da0dac9 = PacketCodec.friend(jsonArray.get(i).getAsJsonObject());
                if (nested1_1da0dac9 == null) continue;
                arrayList.add(nested1_1da0dac9);
            }
        }
        return arrayList;
    }

    private static List<String> strings(JsonArray jsonArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (jsonArray != null) {
            int n = Math.min(jsonArray.size(), 4096);
            for (int i = 0; i < n; ++i) {
                arrayList.add(jsonArray.get(i).getAsString());
            }
        }
        return arrayList;
    }

    private static List<String> strList(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && jsonObject.get(string).isJsonArray() ? PacketCodec.strings(jsonObject.getAsJsonArray(string)) : new ArrayList<String>();
    }

    private static JsonObject obj(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && jsonObject.get(string).isJsonObject() ? jsonObject.getAsJsonObject(string) : null;
    }

    private static JsonArray arr(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && jsonObject.get(string).isJsonArray() ? jsonObject.getAsJsonArray(string) : null;
    }

    private static String str(JsonObject jsonObject, String string) {
        if (!jsonObject.has(string) || jsonObject.get(string).isJsonNull()) {
            return "";
        }
        String string2 = jsonObject.get(string).getAsString();
        return string2.length() > 8192 ? string2.substring(0, 8192) : string2;
    }

    private static int intv(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && !jsonObject.get(string).isJsonNull() ? jsonObject.get(string).getAsInt() : 0;
    }

    private static long longv(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && !jsonObject.get(string).isJsonNull() ? jsonObject.get(string).getAsLong() : 0L;
    }

    private static double dbl(JsonObject jsonObject, String string) {
        return jsonObject.has(string) && !jsonObject.get(string).isJsonNull() ? jsonObject.get(string).getAsDouble() : 0.0;
    }
}

