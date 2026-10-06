package globals.shared.proto;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;

public final class Packets {
   public static final int MAX_MESSAGE_LENGTH = 200;
   public static final int MAX_PRIVATE_MESSAGE_LENGTH = 500;

   public static final class Nested1_14a1683a implements Packet {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_14a1683a(String var1, String var2, String var3, String var4) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.hash = var4;
      }

      @Override
      public String type() {
         return "admin_shutdown";
      }

      @Override
      public final String toString() {
         return "Nested1_14a1683a[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_14a1683a other = (Packets.Nested1_14a1683a) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_17a3bc2e implements Packet {
      private final String toUsername;

      public Nested1_17a3bc2e(String var1) {
         this.toUsername = var1;
      }

      @Override
      public String type() {
         return "friend_request_send";
      }

      @Override
      public final String toString() {
         return "Nested1_17a3bc2e[toUsername=" + this.toUsername() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_17a3bc2e other = (Packets.Nested1_17a3bc2e) var1;
         return java.util.Objects.equals(this.toUsername(), other.toUsername());
      }

      public String toUsername() {
         return this.toUsername;
      }
   }

   public static final class Nested1_1c5c530d implements Packet {
      private final String badge;
      private final String nickStyle;

      public Nested1_1c5c530d(String var1, String var2) {
         this.badge = var1;
         this.nickStyle = var2;
      }

      @Override
      public String type() {
         return "self_cosmetics";
      }

      @Override
      public final String toString() {
         return "Nested1_1c5c530d[badge=" + this.badge() + ", nickStyle=" + this.nickStyle() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.badge());
         result = 31 * result + java.util.Objects.hashCode(this.nickStyle());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_1c5c530d other = (Packets.Nested1_1c5c530d) var1;
         return java.util.Objects.equals(this.badge(), other.badge())
            && java.util.Objects.equals(this.nickStyle(), other.nickStyle());
      }

      public String badge() {
         return this.badge;
      }

      public String nickStyle() {
         return this.nickStyle;
      }
   }

   public static final class Nested1_1d3d88d1 implements Packet {
      private final List<Packets.Nested1_5af299fe> messages;
      private final long beforeId;
      private final boolean more;

      public Nested1_1d3d88d1(List<Packets.Nested1_5af299fe> var1, long var2, boolean var4) {
         this.messages = var1;
         this.beforeId = var2;
         this.more = var4;
      }

      @Override
      public String type() {
         return "chat_history";
      }

      @Override
      public final String toString() {
         return "Nested1_1d3d88d1[messages=" + this.messages() + ", beforeId=" + this.beforeId() + ", more=" + this.more() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.messages());
         result = 31 * result + java.util.Objects.hashCode(this.beforeId());
         result = 31 * result + java.util.Objects.hashCode(this.more());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_1d3d88d1 other = (Packets.Nested1_1d3d88d1) var1;
         return java.util.Objects.equals(this.messages(), other.messages())
            && java.util.Objects.equals(this.beforeId(), other.beforeId())
            && java.util.Objects.equals(this.more(), other.more());
      }

      public List<Packets.Nested1_5af299fe> messages() {
         return this.messages;
      }

      public long beforeId() {
         return this.beforeId;
      }

      public boolean more() {
         return this.more;
      }
   }

   public static final class Nested1_1da0dac9 {
      private final String username;
      private final String role;
      private final String activity;
      private final Packets.Nested1_242f4d2b gameInfo;
      private final String client;
      private final String visibility;
      private final String badge;
      private final String nickStyle;
      private final long lastSeen;

      public Nested1_1da0dac9(
         String var1, String var2, String var3, Packets.Nested1_242f4d2b var4, String var5, String var6, String var7, String var8, long var9
      ) {
         this.username = var1;
         this.role = var2;
         this.activity = var3;
         this.gameInfo = var4;
         this.client = var5;
         this.visibility = var6;
         this.badge = var7;
         this.nickStyle = var8;
         this.lastSeen = var9;
      }

      @Override
      public final String toString() {
         return "Nested1_1da0dac9[username=" + this.username() + ", role=" + this.role() + ", activity=" + this.activity() + ", gameInfo=" + this.gameInfo() + ", client=" + this.client() + ", visibility=" + this.visibility() + ", badge=" + this.badge() + ", nickStyle=" + this.nickStyle() + ", lastSeen=" + this.lastSeen() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.role());
         result = 31 * result + java.util.Objects.hashCode(this.activity());
         result = 31 * result + java.util.Objects.hashCode(this.gameInfo());
         result = 31 * result + java.util.Objects.hashCode(this.client());
         result = 31 * result + java.util.Objects.hashCode(this.visibility());
         result = 31 * result + java.util.Objects.hashCode(this.badge());
         result = 31 * result + java.util.Objects.hashCode(this.nickStyle());
         result = 31 * result + java.util.Objects.hashCode(this.lastSeen());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_1da0dac9 other = (Packets.Nested1_1da0dac9) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.role(), other.role())
            && java.util.Objects.equals(this.activity(), other.activity())
            && java.util.Objects.equals(this.gameInfo(), other.gameInfo())
            && java.util.Objects.equals(this.client(), other.client())
            && java.util.Objects.equals(this.visibility(), other.visibility())
            && java.util.Objects.equals(this.badge(), other.badge())
            && java.util.Objects.equals(this.nickStyle(), other.nickStyle())
            && java.util.Objects.equals(this.lastSeen(), other.lastSeen());
      }

      public String username() {
         return this.username;
      }

      public String role() {
         return this.role;
      }

      public String activity() {
         return this.activity;
      }

      public Packets.Nested1_242f4d2b gameInfo() {
         return this.gameInfo;
      }

      public String client() {
         return this.client;
      }

      public String visibility() {
         return this.visibility;
      }

      public String badge() {
         return this.badge;
      }

      public String nickStyle() {
         return this.nickStyle;
      }

      public long lastSeen() {
         return this.lastSeen;
      }
   }

   public static final class Nested1_1db1e4fc implements Packet {
      private final String name;
      private final String data;

      public Nested1_1db1e4fc(String var1, String var2) {
         this.name = var1;
         this.data = var2;
      }

      @Override
      public String type() {
         return "swing_preset";
      }

      @Override
      public final String toString() {
         return "Nested1_1db1e4fc[name=" + this.name() + ", data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_1db1e4fc other = (Packets.Nested1_1db1e4fc) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.data(), other.data());
      }

      public String name() {
         return this.name;
      }

      public String data() {
         return this.data;
      }
   }

   public static final class Nested1_242f4d2b {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String ip;
      private final String hash;
      private final String visibility;
      private final String clientName;

      public Nested1_242f4d2b(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.ip = var4;
         this.hash = var5;
         this.visibility = var6;
         this.clientName = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_242f4d2b[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", ip=" + this.ip() + ", hash=" + this.hash() + ", visibility=" + this.visibility() + ", clientName=" + this.clientName() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.ip());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         result = 31 * result + java.util.Objects.hashCode(this.visibility());
         result = 31 * result + java.util.Objects.hashCode(this.clientName());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_242f4d2b other = (Packets.Nested1_242f4d2b) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.ip(), other.ip())
            && java.util.Objects.equals(this.hash(), other.hash())
            && java.util.Objects.equals(this.visibility(), other.visibility())
            && java.util.Objects.equals(this.clientName(), other.clientName());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String ip() {
         return this.ip;
      }

      public String hash() {
         return this.hash;
      }

      public String visibility() {
         return this.visibility;
      }

      public String clientName() {
         return this.clientName;
      }
   }

   public static final class Nested1_24ba7b4c implements Packet {
      private final JsonObject payload;

      public Nested1_24ba7b4c(JsonObject var1) {
         this.payload = var1;
      }

      @Override
      public String type() {
         return "autofarm_inventory";
      }

      @Override
      public final String toString() {
         return "Nested1_24ba7b4c[payload=" + this.payload() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.payload());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_24ba7b4c other = (Packets.Nested1_24ba7b4c) var1;
         return java.util.Objects.equals(this.payload(), other.payload());
      }

      public JsonObject payload() {
         return this.payload;
      }
   }

   public static final class Nested1_25729f58 implements Packet {
      private final String name;
      private final String language;
      private final String blob;
      private final List<String> libraries;

      public Nested1_25729f58(String var1, String var2, String var3, List<String> var4) {
         this.name = var1;
         this.language = var2;
         this.blob = var3;
         this.libraries = var4;
      }

      @Override
      public String type() {
         return "script_protected";
      }

      @Override
      public final String toString() {
         return "Nested1_25729f58[name=" + this.name() + ", language=" + this.language() + ", blob=" + this.blob() + ", libraries=" + this.libraries() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.language());
         result = 31 * result + java.util.Objects.hashCode(this.blob());
         result = 31 * result + java.util.Objects.hashCode(this.libraries());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_25729f58 other = (Packets.Nested1_25729f58) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.language(), other.language())
            && java.util.Objects.equals(this.blob(), other.blob())
            && java.util.Objects.equals(this.libraries(), other.libraries());
      }

      public String name() {
         return this.name;
      }

      public String language() {
         return this.language;
      }

      public String blob() {
         return this.blob;
      }

      public List<String> libraries() {
         return this.libraries;
      }
   }

   public static final class Nested1_27110241 implements Packet {
      private final String name;

      public Nested1_27110241(String var1) {
         this.name = var1;
      }

      @Override
      public String type() {
         return "script_delete";
      }

      @Override
      public final String toString() {
         return "Nested1_27110241[name=" + this.name() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_27110241 other = (Packets.Nested1_27110241) var1;
         return java.util.Objects.equals(this.name(), other.name());
      }

      public String name() {
         return this.name;
      }
   }

   public static final class Nested1_274d161e implements Packet {
      private final String name;
      private final String data;

      public Nested1_274d161e(String var1, String var2) {
         this.name = var1;
         this.data = var2;
      }

      @Override
      public String type() {
         return "invbuilder_preset";
      }

      @Override
      public final String toString() {
         return "Nested1_274d161e[name=" + this.name() + ", data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_274d161e other = (Packets.Nested1_274d161e) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.data(), other.data());
      }

      public String name() {
         return this.name;
      }

      public String data() {
         return this.data;
      }
   }

   public static final class Nested1_288d22d3 implements Packet {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_288d22d3(String var1, String var2, String var3, String var4) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.hash = var4;
      }

      @Override
      public String type() {
         return "admin_drop";
      }

      @Override
      public final String toString() {
         return "Nested1_288d22d3[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_288d22d3 other = (Packets.Nested1_288d22d3) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_2a2d6379 implements Packet {
      private final Packets.Nested1_1da0dac9 author;
      private final Packets.Nested1_3834b16e position;
      private final Packets.Nested1_3834b16e direction;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_2a2d6379(
         Packets.Nested1_1da0dac9 var1, Packets.Nested1_3834b16e var2, Packets.Nested1_3834b16e var3, String var4, String var5, String var6
      ) {
         this.author = var1;
         this.position = var2;
         this.direction = var3;
         this.anarchy = var4;
         this.server = var5;
         this.hash = var6;
      }

      @Override
      public String type() {
         return "snowball_throw";
      }

      @Override
      public final String toString() {
         return "Nested1_2a2d6379[author=" + this.author() + ", position=" + this.position() + ", direction=" + this.direction() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.author());
         result = 31 * result + java.util.Objects.hashCode(this.position());
         result = 31 * result + java.util.Objects.hashCode(this.direction());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_2a2d6379 other = (Packets.Nested1_2a2d6379) var1;
         return java.util.Objects.equals(this.author(), other.author())
            && java.util.Objects.equals(this.position(), other.position())
            && java.util.Objects.equals(this.direction(), other.direction())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public Packets.Nested1_1da0dac9 author() {
         return this.author;
      }

      public Packets.Nested1_3834b16e position() {
         return this.position;
      }

      public Packets.Nested1_3834b16e direction() {
         return this.direction;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_2dfe6b80 {
      private final String username;
      private final String role;
      private final String badge;
      private final String nickStyle;
      private final boolean online;
      private final long lastSeen;

      public Nested1_2dfe6b80(String var1, String var2, String var3, String var4, boolean var5, long var6) {
         this.username = var1;
         this.role = var2;
         this.badge = var3;
         this.nickStyle = var4;
         this.online = var5;
         this.lastSeen = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_2dfe6b80[username=" + this.username() + ", role=" + this.role() + ", badge=" + this.badge() + ", nickStyle=" + this.nickStyle() + ", online=" + this.online() + ", lastSeen=" + this.lastSeen() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.role());
         result = 31 * result + java.util.Objects.hashCode(this.badge());
         result = 31 * result + java.util.Objects.hashCode(this.nickStyle());
         result = 31 * result + java.util.Objects.hashCode(this.online());
         result = 31 * result + java.util.Objects.hashCode(this.lastSeen());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_2dfe6b80 other = (Packets.Nested1_2dfe6b80) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.role(), other.role())
            && java.util.Objects.equals(this.badge(), other.badge())
            && java.util.Objects.equals(this.nickStyle(), other.nickStyle())
            && java.util.Objects.equals(this.online(), other.online())
            && java.util.Objects.equals(this.lastSeen(), other.lastSeen());
      }

      public String username() {
         return this.username;
      }

      public String role() {
         return this.role;
      }

      public String badge() {
         return this.badge;
      }

      public String nickStyle() {
         return this.nickStyle;
      }

      public boolean online() {
         return this.online;
      }

      public long lastSeen() {
         return this.lastSeen;
      }
   }

   public static final class Nested1_33f3cc0 implements Packet {
      private final JsonObject data;

      public Nested1_33f3cc0(JsonObject var1) {
         this.data = var1;
      }

      @Override
      public String type() {
         return "client_data";
      }

      @Override
      public final String toString() {
         return "Nested1_33f3cc0[data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_33f3cc0 other = (Packets.Nested1_33f3cc0) var1;
         return java.util.Objects.equals(this.data(), other.data());
      }

      public JsonObject data() {
         return this.data;
      }
   }

   public static final class Nested1_3422a40 implements Packet {
      private final String server;
      private final String ip;
      private final String host;
      private final String nickname;
      private final String clientName;

      public Nested1_3422a40(String var1, String var2, String var3, String var4, String var5) {
         this.server = var1;
         this.ip = var2;
         this.host = var3;
         this.nickname = var4;
         this.clientName = var5;
      }

      @Override
      public String type() {
         return "client_join";
      }

      @Override
      public final String toString() {
         return "Nested1_3422a40[server=" + this.server() + ", ip=" + this.ip() + ", host=" + this.host() + ", nickname=" + this.nickname() + ", clientName=" + this.clientName() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.ip());
         result = 31 * result + java.util.Objects.hashCode(this.host());
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.clientName());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3422a40 other = (Packets.Nested1_3422a40) var1;
         return java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.ip(), other.ip())
            && java.util.Objects.equals(this.host(), other.host())
            && java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.clientName(), other.clientName());
      }

      public String server() {
         return this.server;
      }

      public String ip() {
         return this.ip;
      }

      public String host() {
         return this.host;
      }

      public String nickname() {
         return this.nickname;
      }

      public String clientName() {
         return this.clientName;
      }
   }

   public static final class Nested1_3565170 implements Packet {
      private final String username;
      private final long seconds;
      private final String reason;

      public Nested1_3565170(String var1, long var2, String var4) {
         this.username = var1;
         this.seconds = var2;
         this.reason = var4;
      }

      @Override
      public String type() {
         return "mod_mute";
      }

      @Override
      public final String toString() {
         return "Nested1_3565170[username=" + this.username() + ", seconds=" + this.seconds() + ", reason=" + this.reason() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.seconds());
         result = 31 * result + java.util.Objects.hashCode(this.reason());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3565170 other = (Packets.Nested1_3565170) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.seconds(), other.seconds())
            && java.util.Objects.equals(this.reason(), other.reason());
      }

      public String username() {
         return this.username;
      }

      public long seconds() {
         return this.seconds;
      }

      public String reason() {
         return this.reason;
      }
   }

   public static final class Nested1_35ee7690 implements Packet {
      private final String text;

      public Nested1_35ee7690(String var1) {
         this.text = var1;
      }

      @Override
      public String type() {
         return "auth_result";
      }

      @Override
      public final String toString() {
         return "Nested1_35ee7690[text=" + this.text() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.text());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_35ee7690 other = (Packets.Nested1_35ee7690) var1;
         return java.util.Objects.equals(this.text(), other.text());
      }

      public String text() {
         return this.text;
      }
   }

   public static final class Nested1_3630dbf0 implements Packet {
      private final String name;
      private final Packets.Nested1_3834b16e vector;
      private final String anarchy;
      private final String server;
      private final String hash;
      private final long livingTime;
      private final int color;

      public Nested1_3630dbf0(String var1, Packets.Nested1_3834b16e var2, String var3, String var4, String var5, long var6, int var8) {
         this.name = var1;
         this.vector = var2;
         this.anarchy = var3;
         this.server = var4;
         this.hash = var5;
         this.livingTime = var6;
         this.color = var8;
      }

      @Override
      public String type() {
         return "create_way_send";
      }

      @Override
      public final String toString() {
         return "Nested1_3630dbf0[name=" + this.name() + ", vector=" + this.vector() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + ", livingTime=" + this.livingTime() + ", color=" + this.color() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.vector());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         result = 31 * result + java.util.Objects.hashCode(this.livingTime());
         result = 31 * result + java.util.Objects.hashCode(this.color());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3630dbf0 other = (Packets.Nested1_3630dbf0) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.vector(), other.vector())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash())
            && java.util.Objects.equals(this.livingTime(), other.livingTime())
            && java.util.Objects.equals(this.color(), other.color());
      }

      public String name() {
         return this.name;
      }

      public Packets.Nested1_3834b16e vector() {
         return this.vector;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }

      public long livingTime() {
         return this.livingTime;
      }

      public int color() {
         return this.color;
      }
   }

   public static final class Nested1_37631c33 implements Packet {
      private final String withUsername;
      private final long beforeId;

      public Nested1_37631c33(String var1, long var2) {
         this.withUsername = var1;
         this.beforeId = var2;
      }

      @Override
      public String type() {
         return "private_history_request";
      }

      @Override
      public final String toString() {
         return "Nested1_37631c33[withUsername=" + this.withUsername() + ", beforeId=" + this.beforeId() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.withUsername());
         result = 31 * result + java.util.Objects.hashCode(this.beforeId());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_37631c33 other = (Packets.Nested1_37631c33) var1;
         return java.util.Objects.equals(this.withUsername(), other.withUsername())
            && java.util.Objects.equals(this.beforeId(), other.beforeId());
      }

      public String withUsername() {
         return this.withUsername;
      }

      public long beforeId() {
         return this.beforeId;
      }
   }

   public static final class Nested1_3834b16e {
      private final double x;
      private final double y;
      private final double z;

      public Nested1_3834b16e(double var1, double var3, double var5) {
         this.x = var1;
         this.y = var3;
         this.z = var5;
      }

      @Override
      public final String toString() {
         return "Nested1_3834b16e[x=" + this.x() + ", y=" + this.y() + ", z=" + this.z() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.x());
         result = 31 * result + java.util.Objects.hashCode(this.y());
         result = 31 * result + java.util.Objects.hashCode(this.z());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3834b16e other = (Packets.Nested1_3834b16e) var1;
         return java.util.Objects.equals(this.x(), other.x())
            && java.util.Objects.equals(this.y(), other.y())
            && java.util.Objects.equals(this.z(), other.z());
      }

      public double x() {
         return this.x;
      }

      public double y() {
         return this.y;
      }

      public double z() {
         return this.z;
      }
   }

   public static final class Nested1_3a3c486 implements Packet {
      private final String name;
      private final String data;
      private final String toUsername;

      public Nested1_3a3c486(String var1, String var2, String var3) {
         this.name = var1;
         this.data = var2;
         this.toUsername = var3;
      }

      @Override
      public String type() {
         return "share_invbuilder_send";
      }

      @Override
      public final String toString() {
         return "Nested1_3a3c486[name=" + this.name() + ", data=" + this.data() + ", toUsername=" + this.toUsername() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.data());
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3a3c486 other = (Packets.Nested1_3a3c486) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.data(), other.data())
            && java.util.Objects.equals(this.toUsername(), other.toUsername());
      }

      public String name() {
         return this.name;
      }

      public String data() {
         return this.data;
      }

      public String toUsername() {
         return this.toUsername;
      }
   }

   public static final class Nested1_3b6ca75e implements Packet {
      private final long configId;
      private final String toUsername;

      public Nested1_3b6ca75e(long var1, String var3) {
         this.configId = var1;
         this.toUsername = var3;
      }

      @Override
      public String type() {
         return "share_config_send";
      }

      @Override
      public final String toString() {
         return "Nested1_3b6ca75e[configId=" + this.configId() + ", toUsername=" + this.toUsername() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.configId());
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3b6ca75e other = (Packets.Nested1_3b6ca75e) var1;
         return java.util.Objects.equals(this.configId(), other.configId())
            && java.util.Objects.equals(this.toUsername(), other.toUsername());
      }

      public long configId() {
         return this.configId;
      }

      public String toUsername() {
         return this.toUsername;
      }
   }

   public static final class Nested1_3c7c7ae4 implements Packet {
      private final String message;

      public Nested1_3c7c7ae4(String var1) {
         if (var1 != null && var1.length() > 200) {
            throw new IllegalArgumentException("Message cannot be longer than 200 characters");
         } else {
            this.message = var1;
         }
      }

      @Override
      public String type() {
         return "message_send";
      }

      @Override
      public final String toString() {
         return "Nested1_3c7c7ae4[message=" + this.message() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.message());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3c7c7ae4 other = (Packets.Nested1_3c7c7ae4) var1;
         return java.util.Objects.equals(this.message(), other.message());
      }

      public String message() {
         return this.message;
      }
   }

   public static final class Nested1_3d34c57b implements Packet {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_3d34c57b(String var1, String var2, String var3, String var4) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.hash = var4;
      }

      @Override
      public String type() {
         return "admin_freeze";
      }

      @Override
      public final String toString() {
         return "Nested1_3d34c57b[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3d34c57b other = (Packets.Nested1_3d34c57b) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_3eeaa41e implements Packet {
      private final long id;

      public Nested1_3eeaa41e(long var1) {
         this.id = var1;
      }

      @Override
      public String type() {
         return "config_duplicate";
      }

      @Override
      public final String toString() {
         return "Nested1_3eeaa41e[id=" + this.id() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3eeaa41e other = (Packets.Nested1_3eeaa41e) var1;
         return java.util.Objects.equals(this.id(), other.id());
      }

      public long id() {
         return this.id;
      }
   }

   public static final class Nested1_3ef5751a implements Packet {
      private final String name;

      public Nested1_3ef5751a(String var1) {
         this.name = var1;
      }

      @Override
      public String type() {
         return "script_remove";
      }

      @Override
      public final String toString() {
         return "Nested1_3ef5751a[name=" + this.name() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3ef5751a other = (Packets.Nested1_3ef5751a) var1;
         return java.util.Objects.equals(this.name(), other.name());
      }

      public String name() {
         return this.name;
      }
   }

   public static final class Nested1_3ef5b3d4 implements Packet {
      private final String from;
      private final String to;

      public Nested1_3ef5b3d4(String var1, String var2) {
         this.from = var1;
         this.to = var2;
      }

      @Override
      public String type() {
         return "script_rename";
      }

      @Override
      public final String toString() {
         return "Nested1_3ef5b3d4[from=" + this.from() + ", to=" + this.to() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.from());
         result = 31 * result + java.util.Objects.hashCode(this.to());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_3ef5b3d4 other = (Packets.Nested1_3ef5b3d4) var1;
         return java.util.Objects.equals(this.from(), other.from())
            && java.util.Objects.equals(this.to(), other.to());
      }

      public String from() {
         return this.from;
      }

      public String to() {
         return this.to;
      }
   }

   public static final class Nested1_40acf5d1 implements Packet {
      private final String username;

      public Nested1_40acf5d1(String var1) {
         this.username = var1;
      }

      @Override
      public String type() {
         return "profile_request";
      }

      @Override
      public final String toString() {
         return "Nested1_40acf5d1[username=" + this.username() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_40acf5d1 other = (Packets.Nested1_40acf5d1) var1;
         return java.util.Objects.equals(this.username(), other.username());
      }

      public String username() {
         return this.username;
      }
   }

   public static final class Nested1_42226586 implements Packet {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String hash;
      private final int slot;
      private final int button;
      private final String action;

      public Nested1_42226586(String var1, String var2, String var3, String var4, int var5, int var6, String var7) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.hash = var4;
         this.slot = var5;
         this.button = var6;
         this.action = var7;
      }

      @Override
      public String type() {
         return "admin_invsee";
      }

      @Override
      public final String toString() {
         return "Nested1_42226586[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + ", slot=" + this.slot() + ", button=" + this.button() + ", action=" + this.action() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         result = 31 * result + java.util.Objects.hashCode(this.slot());
         result = 31 * result + java.util.Objects.hashCode(this.button());
         result = 31 * result + java.util.Objects.hashCode(this.action());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_42226586 other = (Packets.Nested1_42226586) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash())
            && java.util.Objects.equals(this.slot(), other.slot())
            && java.util.Objects.equals(this.button(), other.button())
            && java.util.Objects.equals(this.action(), other.action());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }

      public int slot() {
         return this.slot;
      }

      public int button() {
         return this.button;
      }

      public String action() {
         return this.action;
      }
   }

   public static final class Nested1_42aed157 implements Packet {
      private final String username;

      public Nested1_42aed157(String var1) {
         this.username = var1;
      }

      @Override
      public String type() {
         return "friend_removed";
      }

      @Override
      public final String toString() {
         return "Nested1_42aed157[username=" + this.username() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_42aed157 other = (Packets.Nested1_42aed157) var1;
         return java.util.Objects.equals(this.username(), other.username());
      }

      public String username() {
         return this.username;
      }
   }

   public static final class Nested1_4acf32af implements Packet {
      private final String username;
      private final String globalName;
      private final String avatarUrl;

      public Nested1_4acf32af(String var1, String var2, String var3) {
         this.username = var1;
         this.globalName = var2;
         this.avatarUrl = var3;
      }

      @Override
      public String type() {
         return "discord_info";
      }

      @Override
      public final String toString() {
         return "Nested1_4acf32af[username=" + this.username() + ", globalName=" + this.globalName() + ", avatarUrl=" + this.avatarUrl() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.globalName());
         result = 31 * result + java.util.Objects.hashCode(this.avatarUrl());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_4acf32af other = (Packets.Nested1_4acf32af) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.globalName(), other.globalName())
            && java.util.Objects.equals(this.avatarUrl(), other.avatarUrl());
      }

      public String username() {
         return this.username;
      }

      public String globalName() {
         return this.globalName;
      }

      public String avatarUrl() {
         return this.avatarUrl;
      }
   }

   public static final class Nested1_4af0fc48 implements Packet {
      private final Packets.Nested1_1da0dac9 author;
      private final String name;
      private final Packets.Nested1_3834b16e vector;
      private final String anarchy;
      private final String server;
      private final String hash;
      private final long livingTime;
      private final int color;

      public Nested1_4af0fc48(
         Packets.Nested1_1da0dac9 var1, String var2, Packets.Nested1_3834b16e var3, String var4, String var5, String var6, long var7, int var9
      ) {
         this.author = var1;
         this.name = var2;
         this.vector = var3;
         this.anarchy = var4;
         this.server = var5;
         this.hash = var6;
         this.livingTime = var7;
         this.color = var9;
      }

      @Override
      public String type() {
         return "create_way";
      }

      @Override
      public final String toString() {
         return "Nested1_4af0fc48[author=" + this.author() + ", name=" + this.name() + ", vector=" + this.vector() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + ", livingTime=" + this.livingTime() + ", color=" + this.color() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.author());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.vector());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         result = 31 * result + java.util.Objects.hashCode(this.livingTime());
         result = 31 * result + java.util.Objects.hashCode(this.color());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_4af0fc48 other = (Packets.Nested1_4af0fc48) var1;
         return java.util.Objects.equals(this.author(), other.author())
            && java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.vector(), other.vector())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash())
            && java.util.Objects.equals(this.livingTime(), other.livingTime())
            && java.util.Objects.equals(this.color(), other.color());
      }

      public Packets.Nested1_1da0dac9 author() {
         return this.author;
      }

      public String name() {
         return this.name;
      }

      public Packets.Nested1_3834b16e vector() {
         return this.vector;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }

      public long livingTime() {
         return this.livingTime;
      }

      public int color() {
         return this.color;
      }
   }

   public static final class Nested1_4eb70229 implements Packet {
      private final String requester;
      private final int slot;
      private final int button;
      private final String action;

      public Nested1_4eb70229(String var1, int var2, int var3, String var4) {
         this.requester = var1;
         this.slot = var2;
         this.button = var3;
         this.action = var4;
      }

      @Override
      public String type() {
         return "admin_invsee_request";
      }

      @Override
      public final String toString() {
         return "Nested1_4eb70229[requester=" + this.requester() + ", slot=" + this.slot() + ", button=" + this.button() + ", action=" + this.action() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.requester());
         result = 31 * result + java.util.Objects.hashCode(this.slot());
         result = 31 * result + java.util.Objects.hashCode(this.button());
         result = 31 * result + java.util.Objects.hashCode(this.action());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_4eb70229 other = (Packets.Nested1_4eb70229) var1;
         return java.util.Objects.equals(this.requester(), other.requester())
            && java.util.Objects.equals(this.slot(), other.slot())
            && java.util.Objects.equals(this.button(), other.button())
            && java.util.Objects.equals(this.action(), other.action());
      }

      public String requester() {
         return this.requester;
      }

      public int slot() {
         return this.slot;
      }

      public int button() {
         return this.button;
      }

      public String action() {
         return this.action;
      }
   }

   public static final class Nested1_50fe5301 implements Packet {
      private final String action;
      private final String nickname;
      private final int count;

      public Nested1_50fe5301(String var1, String var2, int var3) {
         this.action = var1;
         this.nickname = var2;
         this.count = var3;
      }

      @Override
      public String type() {
         return "admin_result";
      }

      @Override
      public final String toString() {
         return "Nested1_50fe5301[action=" + this.action() + ", nickname=" + this.nickname() + ", count=" + this.count() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.action());
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.count());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_50fe5301 other = (Packets.Nested1_50fe5301) var1;
         return java.util.Objects.equals(this.action(), other.action())
            && java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.count(), other.count());
      }

      public String action() {
         return this.action;
      }

      public String nickname() {
         return this.nickname;
      }

      public int count() {
         return this.count;
      }
   }

   public static final class Nested1_53e3ad0b implements Packet {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_53e3ad0b(String var1, String var2, String var3, String var4) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.hash = var4;
      }

      @Override
      public String type() {
         return "admin_off";
      }

      @Override
      public final String toString() {
         return "Nested1_53e3ad0b[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_53e3ad0b other = (Packets.Nested1_53e3ad0b) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_55703e48 implements Packet {
      private final long shareId;

      public Nested1_55703e48(long var1) {
         this.shareId = var1;
      }

      @Override
      public String type() {
         return "share_claim";
      }

      @Override
      public final String toString() {
         return "Nested1_55703e48[shareId=" + this.shareId() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.shareId());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_55703e48 other = (Packets.Nested1_55703e48) var1;
         return java.util.Objects.equals(this.shareId(), other.shareId());
      }

      public long shareId() {
         return this.shareId;
      }
   }

   public static final class Nested1_569722bc implements Packet {
      private final String with;
      private final List<Packets.Nested1_5af299fe> messages;
      private final long beforeId;
      private final boolean more;

      public Nested1_569722bc(String var1, List<Packets.Nested1_5af299fe> var2, long var3, boolean var5) {
         this.with = var1;
         this.messages = var2;
         this.beforeId = var3;
         this.more = var5;
      }

      @Override
      public String type() {
         return "private_history";
      }

      @Override
      public final String toString() {
         return "Nested1_569722bc[with=" + this.with() + ", messages=" + this.messages() + ", beforeId=" + this.beforeId() + ", more=" + this.more() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.with());
         result = 31 * result + java.util.Objects.hashCode(this.messages());
         result = 31 * result + java.util.Objects.hashCode(this.beforeId());
         result = 31 * result + java.util.Objects.hashCode(this.more());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_569722bc other = (Packets.Nested1_569722bc) var1;
         return java.util.Objects.equals(this.with(), other.with())
            && java.util.Objects.equals(this.messages(), other.messages())
            && java.util.Objects.equals(this.beforeId(), other.beforeId())
            && java.util.Objects.equals(this.more(), other.more());
      }

      public String with() {
         return this.with;
      }

      public List<Packets.Nested1_5af299fe> messages() {
         return this.messages;
      }

      public long beforeId() {
         return this.beforeId;
      }

      public boolean more() {
         return this.more;
      }
   }

   public static final class Nested1_571f5383 implements Packet {
      private final String name;
      private final Packets.Nested1_3834b16e vector;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_571f5383(String var1, Packets.Nested1_3834b16e var2, String var3, String var4, String var5) {
         this.name = var1;
         this.vector = var2;
         this.anarchy = var3;
         this.server = var4;
         this.hash = var5;
      }

      @Override
      public String type() {
         return "update_way_send";
      }

      @Override
      public final String toString() {
         return "Nested1_571f5383[name=" + this.name() + ", vector=" + this.vector() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.vector());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_571f5383 other = (Packets.Nested1_571f5383) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.vector(), other.vector())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public String name() {
         return this.name;
      }

      public Packets.Nested1_3834b16e vector() {
         return this.vector;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_57f4c35d implements Packet {
      private final String message;

      public Nested1_57f4c35d(String var1) {
         this.message = var1;
      }

      @Override
      public String type() {
         return "admin_broadcast";
      }

      @Override
      public final String toString() {
         return "Nested1_57f4c35d[message=" + this.message() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.message());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_57f4c35d other = (Packets.Nested1_57f4c35d) var1;
         return java.util.Objects.equals(this.message(), other.message());
      }

      public String message() {
         return this.message;
      }
   }

   public static final class Nested1_58423e2f implements Packet {
      private final long id;
      private final Packets.Nested1_e38dcab6 author;
      private final String toUsername;
      private final String message;

      public Nested1_58423e2f(long var1, Packets.Nested1_e38dcab6 var3, String var4, String var5) {
         this.id = var1;
         this.author = var3;
         this.toUsername = var4;
         this.message = var5;
      }

      @Override
      public String type() {
         return "private_message";
      }

      @Override
      public final String toString() {
         return "Nested1_58423e2f[id=" + this.id() + ", author=" + this.author() + ", toUsername=" + this.toUsername() + ", message=" + this.message() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.author());
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         result = 31 * result + java.util.Objects.hashCode(this.message());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_58423e2f other = (Packets.Nested1_58423e2f) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.author(), other.author())
            && java.util.Objects.equals(this.toUsername(), other.toUsername())
            && java.util.Objects.equals(this.message(), other.message());
      }

      public long id() {
         return this.id;
      }

      public Packets.Nested1_e38dcab6 author() {
         return this.author;
      }

      public String toUsername() {
         return this.toUsername;
      }

      public String message() {
         return this.message;
      }
   }

   public static final class Nested1_5af299fe {
      private final long id;
      private final Packets.Nested1_e38dcab6 author;
      private final String toUsername;
      private final String message;
      private final long timestamp;

      public Nested1_5af299fe(long var1, Packets.Nested1_e38dcab6 var3, String var4, String var5, long var6) {
         this.id = var1;
         this.author = var3;
         this.toUsername = var4;
         this.message = var5;
         this.timestamp = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_5af299fe[id=" + this.id() + ", author=" + this.author() + ", toUsername=" + this.toUsername() + ", message=" + this.message() + ", timestamp=" + this.timestamp() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.author());
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         result = 31 * result + java.util.Objects.hashCode(this.message());
         result = 31 * result + java.util.Objects.hashCode(this.timestamp());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_5af299fe other = (Packets.Nested1_5af299fe) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.author(), other.author())
            && java.util.Objects.equals(this.toUsername(), other.toUsername())
            && java.util.Objects.equals(this.message(), other.message())
            && java.util.Objects.equals(this.timestamp(), other.timestamp());
      }

      public long id() {
         return this.id;
      }

      public Packets.Nested1_e38dcab6 author() {
         return this.author;
      }

      public String toUsername() {
         return this.toUsername;
      }

      public String message() {
         return this.message;
      }

      public long timestamp() {
         return this.timestamp;
      }
   }

   public static final class Nested1_5bf41c18 implements Packet {
      private final String name;
      private final String language;
      private final String source;
      private final List<String> libraries;

      public Nested1_5bf41c18(String var1, String var2, String var3, List<String> var4) {
         this.name = var1;
         this.language = var2;
         this.source = var3;
         this.libraries = var4;
      }

      @Override
      public String type() {
         return "script_apply";
      }

      @Override
      public final String toString() {
         return "Nested1_5bf41c18[name=" + this.name() + ", language=" + this.language() + ", source=" + this.source() + ", libraries=" + this.libraries() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.language());
         result = 31 * result + java.util.Objects.hashCode(this.source());
         result = 31 * result + java.util.Objects.hashCode(this.libraries());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_5bf41c18 other = (Packets.Nested1_5bf41c18) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.language(), other.language())
            && java.util.Objects.equals(this.source(), other.source())
            && java.util.Objects.equals(this.libraries(), other.libraries());
      }

      public String name() {
         return this.name;
      }

      public String language() {
         return this.language;
      }

      public String source() {
         return this.source;
      }

      public List<String> libraries() {
         return this.libraries;
      }
   }

   public static final class Nested1_6483a00e implements Packet {
      private final String username;
      private final String email;
      private final String password;
      private final String client;

      public Nested1_6483a00e(String var1, String var2, String var3, String var4) {
         this.username = var1;
         this.email = var2;
         this.password = var3;
         this.client = var4;
      }

      @Override
      public String type() {
         return "register";
      }

      @Override
      public final String toString() {
         return "Nested1_6483a00e[username=" + this.username() + ", email=" + this.email() + ", password=" + this.password() + ", client=" + this.client() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.email());
         result = 31 * result + java.util.Objects.hashCode(this.password());
         result = 31 * result + java.util.Objects.hashCode(this.client());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_6483a00e other = (Packets.Nested1_6483a00e) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.email(), other.email())
            && java.util.Objects.equals(this.password(), other.password())
            && java.util.Objects.equals(this.client(), other.client());
      }

      public String username() {
         return this.username;
      }

      public String email() {
         return this.email;
      }

      public String password() {
         return this.password;
      }

      public String client() {
         return this.client;
      }
   }

   public static final class Nested1_65841a0c implements Packet {
      private final String clientName;
      private final String version;

      public Nested1_65841a0c(String var1, String var2) {
         this.clientName = var1;
         this.version = var2;
      }

      @Override
      public String type() {
         return "client_start";
      }

      @Override
      public final String toString() {
         return "Nested1_65841a0c[clientName=" + this.clientName() + ", version=" + this.version() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.clientName());
         result = 31 * result + java.util.Objects.hashCode(this.version());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_65841a0c other = (Packets.Nested1_65841a0c) var1;
         return java.util.Objects.equals(this.clientName(), other.clientName())
            && java.util.Objects.equals(this.version(), other.version());
      }

      public String clientName() {
         return this.clientName;
      }

      public String version() {
         return this.version;
      }
   }

   public static final class Nested1_6bdee275 implements Packet {
      private final String query;
      private final int page;

      public Nested1_6bdee275(String var1, int var2) {
         this.query = var1;
         this.page = var2;
      }

      @Override
      public String type() {
         return "people_request";
      }

      @Override
      public final String toString() {
         return "Nested1_6bdee275[query=" + this.query() + ", page=" + this.page() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.query());
         result = 31 * result + java.util.Objects.hashCode(this.page());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_6bdee275 other = (Packets.Nested1_6bdee275) var1;
         return java.util.Objects.equals(this.query(), other.query())
            && java.util.Objects.equals(this.page(), other.page());
      }

      public String query() {
         return this.query;
      }

      public int page() {
         return this.page;
      }
   }

   public static final class Nested1_6f871387 implements Packet {
      private final String fromUsername;

      public Nested1_6f871387(String var1) {
         this.fromUsername = var1;
      }

      @Override
      public String type() {
         return "friend_request_received";
      }

      @Override
      public final String toString() {
         return "Nested1_6f871387[fromUsername=" + this.fromUsername() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.fromUsername());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_6f871387 other = (Packets.Nested1_6f871387) var1;
         return java.util.Objects.equals(this.fromUsername(), other.fromUsername());
      }

      public String fromUsername() {
         return this.fromUsername;
      }
   }

   public static final class Nested1_71d5f391 implements Packet {
      private final String shareKind;
      private final String name;
      private final boolean ok;
      private final String error;

      public Nested1_71d5f391(String var1, String var2, boolean var3, String var4) {
         this.shareKind = var1;
         this.name = var2;
         this.ok = var3;
         this.error = var4;
      }

      @Override
      public String type() {
         return "share_result";
      }

      @Override
      public final String toString() {
         return "Nested1_71d5f391[shareKind=" + this.shareKind() + ", name=" + this.name() + ", ok=" + this.ok() + ", error=" + this.error() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.shareKind());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.ok());
         result = 31 * result + java.util.Objects.hashCode(this.error());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_71d5f391 other = (Packets.Nested1_71d5f391) var1;
         return java.util.Objects.equals(this.shareKind(), other.shareKind())
            && java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.ok(), other.ok())
            && java.util.Objects.equals(this.error(), other.error());
      }

      public String shareKind() {
         return this.shareKind;
      }

      public String name() {
         return this.name;
      }

      public boolean ok() {
         return this.ok;
      }

      public String error() {
         return this.error;
      }
   }

   public static final class Nested1_756a47e implements Packet {
      private final long beforeId;

      public Nested1_756a47e(long var1) {
         this.beforeId = var1;
      }

      @Override
      public String type() {
         return "chat_history_request";
      }

      @Override
      public final String toString() {
         return "Nested1_756a47e[beforeId=" + this.beforeId() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.beforeId());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_756a47e other = (Packets.Nested1_756a47e) var1;
         return java.util.Objects.equals(this.beforeId(), other.beforeId());
      }

      public long beforeId() {
         return this.beforeId;
      }
   }

   public static final class Nested1_789f34d6 implements Packet {
      private final List<String> requests;

      public Nested1_789f34d6(List<String> var1) {
         this.requests = var1;
      }

      @Override
      public String type() {
         return "friend_requests_update";
      }

      @Override
      public final String toString() {
         return "Nested1_789f34d6[requests=" + this.requests() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.requests());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_789f34d6 other = (Packets.Nested1_789f34d6) var1;
         return java.util.Objects.equals(this.requests(), other.requests());
      }

      public List<String> requests() {
         return this.requests;
      }
   }

   public static final class Nested1_78bb0ab4 implements Packet {
      private final List<Packets.Nested1_1da0dac9> players;

      public Nested1_78bb0ab4(List<Packets.Nested1_1da0dac9> var1) {
         this.players = var1;
      }

      @Override
      public String type() {
         return "visible_players_update";
      }

      @Override
      public final String toString() {
         return "Nested1_78bb0ab4[players=" + this.players() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.players());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_78bb0ab4 other = (Packets.Nested1_78bb0ab4) var1;
         return java.util.Objects.equals(this.players(), other.players());
      }

      public List<Packets.Nested1_1da0dac9> players() {
         return this.players;
      }
   }

   public static final class Nested1_7dbcd17e implements Packet {
      private final String client;
      private final String username;
      private final String role;
      private final String activity;

      public Nested1_7dbcd17e(String var1, String var2, String var3, String var4) {
         this.client = var1;
         this.username = var2;
         this.role = var3;
         this.activity = var4;
      }

      @Override
      public String type() {
         return "user_auth";
      }

      @Override
      public final String toString() {
         return "Nested1_7dbcd17e[client=" + this.client() + ", username=" + this.username() + ", role=" + this.role() + ", activity=" + this.activity() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.client());
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.role());
         result = 31 * result + java.util.Objects.hashCode(this.activity());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_7dbcd17e other = (Packets.Nested1_7dbcd17e) var1;
         return java.util.Objects.equals(this.client(), other.client())
            && java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.role(), other.role())
            && java.util.Objects.equals(this.activity(), other.activity());
      }

      public String client() {
         return this.client;
      }

      public String username() {
         return this.username;
      }

      public String role() {
         return this.role;
      }

      public String activity() {
         return this.activity;
      }
   }

   public static final class Nested1_8149454 implements Packet {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_8149454(String var1, String var2, String var3, String var4) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.hash = var4;
      }

      @Override
      public String type() {
         return "admin_unfreeze";
      }

      @Override
      public final String toString() {
         return "Nested1_8149454[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_8149454 other = (Packets.Nested1_8149454) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_86da80e8 implements Packet {
      private final long until;
      private final String reason;

      public Nested1_86da80e8(long var1, String var3) {
         this.until = var1;
         this.reason = var3;
      }

      @Override
      public String type() {
         return "chat_muted";
      }

      @Override
      public final String toString() {
         return "Nested1_86da80e8[until=" + this.until() + ", reason=" + this.reason() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.until());
         result = 31 * result + java.util.Objects.hashCode(this.reason());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_86da80e8 other = (Packets.Nested1_86da80e8) var1;
         return java.util.Objects.equals(this.until(), other.until())
            && java.util.Objects.equals(this.reason(), other.reason());
      }

      public long until() {
         return this.until;
      }

      public String reason() {
         return this.reason;
      }
   }

   public static final class Nested1_8aa53931 implements Packet {
      private final int total;
      private final int guests;
      private final int site;

      public Nested1_8aa53931(int var1, int var2, int var3) {
         this.total = var1;
         this.guests = var2;
         this.site = var3;
      }

      @Override
      public String type() {
         return "online_count";
      }

      @Override
      public final String toString() {
         return "Nested1_8aa53931[total=" + this.total() + ", guests=" + this.guests() + ", site=" + this.site() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.total());
         result = 31 * result + java.util.Objects.hashCode(this.guests());
         result = 31 * result + java.util.Objects.hashCode(this.site());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_8aa53931 other = (Packets.Nested1_8aa53931) var1;
         return java.util.Objects.equals(this.total(), other.total())
            && java.util.Objects.equals(this.guests(), other.guests())
            && java.util.Objects.equals(this.site(), other.site());
      }

      public int total() {
         return this.total;
      }

      public int guests() {
         return this.guests;
      }

      public int site() {
         return this.site;
      }
   }

   public static final class Nested1_8daaedde implements Packet {
      private final String username;
      private final String password;
      private final String client;

      public Nested1_8daaedde(String var1, String var2, String var3) {
         this.username = var1;
         this.password = var2;
         this.client = var3;
      }

      @Override
      public String type() {
         return "login";
      }

      @Override
      public final String toString() {
         return "Nested1_8daaedde[username=" + this.username() + ", password=" + this.password() + ", client=" + this.client() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.password());
         result = 31 * result + java.util.Objects.hashCode(this.client());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_8daaedde other = (Packets.Nested1_8daaedde) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.password(), other.password())
            && java.util.Objects.equals(this.client(), other.client());
      }

      public String username() {
         return this.username;
      }

      public String password() {
         return this.password;
      }

      public String client() {
         return this.client;
      }
   }

   public static final class Nested1_8e89c4ad implements Packet {
      private final String username;

      public Nested1_8e89c4ad(String var1) {
         this.username = var1;
      }

      @Override
      public String type() {
         return "friend_remove";
      }

      @Override
      public final String toString() {
         return "Nested1_8e89c4ad[username=" + this.username() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_8e89c4ad other = (Packets.Nested1_8e89c4ad) var1;
         return java.util.Objects.equals(this.username(), other.username());
      }

      public String username() {
         return this.username;
      }
   }

   public static final class Nested1_8eae4db4 implements Packet {
      private final String action;
      private final String username;
      private final boolean ok;

      public Nested1_8eae4db4(String var1, String var2, boolean var3) {
         this.action = var1;
         this.username = var2;
         this.ok = var3;
      }

      @Override
      public String type() {
         return "mod_result";
      }

      @Override
      public final String toString() {
         return "Nested1_8eae4db4[action=" + this.action() + ", username=" + this.username() + ", ok=" + this.ok() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.action());
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.ok());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_8eae4db4 other = (Packets.Nested1_8eae4db4) var1;
         return java.util.Objects.equals(this.action(), other.action())
            && java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.ok(), other.ok());
      }

      public String action() {
         return this.action;
      }

      public String username() {
         return this.username;
      }

      public boolean ok() {
         return this.ok;
      }
   }

   public static final class Nested1_8f5e2529 {
      private final String name;
      private final String language;
      private final String source;
      private final List<String> libraries;

      public Nested1_8f5e2529(String var1, String var2, String var3, List<String> var4) {
         this.name = var1;
         this.language = var2;
         this.source = var3;
         this.libraries = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_8f5e2529[name=" + this.name() + ", language=" + this.language() + ", source=" + this.source() + ", libraries=" + this.libraries() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.language());
         result = 31 * result + java.util.Objects.hashCode(this.source());
         result = 31 * result + java.util.Objects.hashCode(this.libraries());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_8f5e2529 other = (Packets.Nested1_8f5e2529) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.language(), other.language())
            && java.util.Objects.equals(this.source(), other.source())
            && java.util.Objects.equals(this.libraries(), other.libraries());
      }

      public String name() {
         return this.name;
      }

      public String language() {
         return this.language;
      }

      public String source() {
         return this.source;
      }

      public List<String> libraries() {
         return this.libraries;
      }
   }

   public static final class Nested1_8f61585b implements Packet {
      @Override
      public String type() {
         return "script_pull";
      }

      @Override
      public final String toString() {
         return "Nested1_8f61585b[]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_8f61585b other = (Packets.Nested1_8f61585b) var1;
         return true;
      }
   }

   public static final class Nested1_8f626b93 implements Packet {
      private final String name;
      private final String language;
      private final String source;

      public Nested1_8f626b93(String var1, String var2, String var3) {
         this.name = var1;
         this.language = var2;
         this.source = var3;
      }

      @Override
      public String type() {
         return "script_save";
      }

      @Override
      public final String toString() {
         return "Nested1_8f626b93[name=" + this.name() + ", language=" + this.language() + ", source=" + this.source() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.language());
         result = 31 * result + java.util.Objects.hashCode(this.source());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_8f626b93 other = (Packets.Nested1_8f626b93) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.language(), other.language())
            && java.util.Objects.equals(this.source(), other.source());
      }

      public String name() {
         return this.name;
      }

      public String language() {
         return this.language;
      }

      public String source() {
         return this.source;
      }
   }

   public static final class Nested1_91e2bf78 implements Packet {
      private final long id;

      public Nested1_91e2bf78(long var1) {
         this.id = var1;
      }

      @Override
      public String type() {
         return "config_delete";
      }

      @Override
      public final String toString() {
         return "Nested1_91e2bf78[id=" + this.id() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_91e2bf78 other = (Packets.Nested1_91e2bf78) var1;
         return java.util.Objects.equals(this.id(), other.id());
      }

      public long id() {
         return this.id;
      }
   }

   public static final class Nested1_9204be60 implements Packet {
      private final List<Packets.Nested1_d6cfc997> styles;

      public Nested1_9204be60(List<Packets.Nested1_d6cfc997> var1) {
         this.styles = var1;
      }

      @Override
      public String type() {
         return "cosmetics_catalog";
      }

      @Override
      public final String toString() {
         return "Nested1_9204be60[styles=" + this.styles() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.styles());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_9204be60 other = (Packets.Nested1_9204be60) var1;
         return java.util.Objects.equals(this.styles(), other.styles());
      }

      public List<Packets.Nested1_d6cfc997> styles() {
         return this.styles;
      }
   }

   public static final class Nested1_9448f1c9 implements Packet {
      private final String username;

      public Nested1_9448f1c9(String var1) {
         this.username = var1;
      }

      @Override
      public String type() {
         return "mod_unmute";
      }

      @Override
      public final String toString() {
         return "Nested1_9448f1c9[username=" + this.username() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_9448f1c9 other = (Packets.Nested1_9448f1c9) var1;
         return java.util.Objects.equals(this.username(), other.username());
      }

      public String username() {
         return this.username;
      }
   }

   public static final class Nested1_9addad72 implements Packet {
      private final String name;
      private final JsonObject data;

      public Nested1_9addad72(String var1, JsonObject var2) {
         this.name = var1;
         this.data = var2;
      }

      @Override
      public String type() {
         return "config_import";
      }

      @Override
      public final String toString() {
         return "Nested1_9addad72[name=" + this.name() + ", data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_9addad72 other = (Packets.Nested1_9addad72) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.data(), other.data());
      }

      public String name() {
         return this.name;
      }

      public JsonObject data() {
         return this.data;
      }
   }

   public static final class Nested1_9be45457 implements Packet {
      private final String payload;

      public Nested1_9be45457(String var1) {
         this.payload = var1;
      }

      @Override
      public String type() {
         return "key_exchange";
      }

      @Override
      public final String toString() {
         return "Nested1_9be45457[payload=" + this.payload() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.payload());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_9be45457 other = (Packets.Nested1_9be45457) var1;
         return java.util.Objects.equals(this.payload(), other.payload());
      }

      public String payload() {
         return this.payload;
      }
   }

   public static final class Nested1_9ecd102e implements Packet {
      private final String username;

      public Nested1_9ecd102e(String var1) {
         this.username = var1;
      }

      @Override
      public String type() {
         return "friend_request_accept";
      }

      @Override
      public final String toString() {
         return "Nested1_9ecd102e[username=" + this.username() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_9ecd102e other = (Packets.Nested1_9ecd102e) var1;
         return java.util.Objects.equals(this.username(), other.username());
      }

      public String username() {
         return this.username;
      }
   }

   public static final class Nested1_a1aa2919 implements Packet {
      private final String toUsername;
      private final String error;

      public Nested1_a1aa2919(String var1, String var2) {
         this.toUsername = var1;
         this.error = var2;
      }

      @Override
      public String type() {
         return "private_message_error";
      }

      @Override
      public final String toString() {
         return "Nested1_a1aa2919[toUsername=" + this.toUsername() + ", error=" + this.error() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         result = 31 * result + java.util.Objects.hashCode(this.error());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_a1aa2919 other = (Packets.Nested1_a1aa2919) var1;
         return java.util.Objects.equals(this.toUsername(), other.toUsername())
            && java.util.Objects.equals(this.error(), other.error());
      }

      public String toUsername() {
         return this.toUsername;
      }

      public String error() {
         return this.error;
      }
   }

   public static final class Nested1_a3fa125d implements Packet {
      private final JsonObject data;

      public Nested1_a3fa125d(JsonObject var1) {
         this.data = var1;
      }

      @Override
      public String type() {
         return "client_data_save";
      }

      @Override
      public final String toString() {
         return "Nested1_a3fa125d[data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_a3fa125d other = (Packets.Nested1_a3fa125d) var1;
         return java.util.Objects.equals(this.data(), other.data());
      }

      public JsonObject data() {
         return this.data;
      }
   }

   public static final class Nested1_a3fa6b7b implements Packet {
      @Override
      public String type() {
         return "client_data_sync";
      }

      @Override
      public final String toString() {
         return "Nested1_a3fa6b7b[]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_a3fa6b7b other = (Packets.Nested1_a3fa6b7b) var1;
         return true;
      }
   }

   public static final class Nested1_a4f5c5e3 implements Packet {
      private final String activity;

      public Nested1_a4f5c5e3(String var1) {
         this.activity = var1;
      }

      @Override
      public String type() {
         return "activity_update";
      }

      @Override
      public final String toString() {
         return "Nested1_a4f5c5e3[activity=" + this.activity() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.activity());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_a4f5c5e3 other = (Packets.Nested1_a4f5c5e3) var1;
         return java.util.Objects.equals(this.activity(), other.activity());
      }

      public String activity() {
         return this.activity;
      }
   }

   public static final class Nested1_a7cdbede implements Packet {
      private final String username;
      private final int uid;
      private final String role;
      private final String badge;
      private final String nickStyle;
      private final boolean online;
      private final boolean inGame;
      private final String status;
      private final long lastSeen;
      private final long registered;
      private final long playtime;
      private final int friendCount;
      private final List<String> mutual;
      private final int mutualCount;
      private final String relationship;
      private final long mutedUntil;

      public Nested1_a7cdbede(
         String var1,
         int var2,
         String var3,
         String var4,
         String var5,
         boolean var6,
         boolean var7,
         String var8,
         long var9,
         long var11,
         long var13,
         int var15,
         List<String> var16,
         int var17,
         String var18,
         long var19
      ) {
         this.username = var1;
         this.uid = var2;
         this.role = var3;
         this.badge = var4;
         this.nickStyle = var5;
         this.online = var6;
         this.inGame = var7;
         this.status = var8;
         this.lastSeen = var9;
         this.registered = var11;
         this.playtime = var13;
         this.friendCount = var15;
         this.mutual = var16;
         this.mutualCount = var17;
         this.relationship = var18;
         this.mutedUntil = var19;
      }

      @Override
      public String type() {
         return "profile";
      }

      @Override
      public final String toString() {
         return "Nested1_a7cdbede[username=" + this.username() + ", uid=" + this.uid() + ", role=" + this.role() + ", badge=" + this.badge() + ", nickStyle=" + this.nickStyle() + ", online=" + this.online() + ", inGame=" + this.inGame() + ", status=" + this.status() + ", lastSeen=" + this.lastSeen() + ", registered=" + this.registered() + ", playtime=" + this.playtime() + ", friendCount=" + this.friendCount() + ", mutual=" + this.mutual() + ", mutualCount=" + this.mutualCount() + ", relationship=" + this.relationship() + ", mutedUntil=" + this.mutedUntil() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.uid());
         result = 31 * result + java.util.Objects.hashCode(this.role());
         result = 31 * result + java.util.Objects.hashCode(this.badge());
         result = 31 * result + java.util.Objects.hashCode(this.nickStyle());
         result = 31 * result + java.util.Objects.hashCode(this.online());
         result = 31 * result + java.util.Objects.hashCode(this.inGame());
         result = 31 * result + java.util.Objects.hashCode(this.status());
         result = 31 * result + java.util.Objects.hashCode(this.lastSeen());
         result = 31 * result + java.util.Objects.hashCode(this.registered());
         result = 31 * result + java.util.Objects.hashCode(this.playtime());
         result = 31 * result + java.util.Objects.hashCode(this.friendCount());
         result = 31 * result + java.util.Objects.hashCode(this.mutual());
         result = 31 * result + java.util.Objects.hashCode(this.mutualCount());
         result = 31 * result + java.util.Objects.hashCode(this.relationship());
         result = 31 * result + java.util.Objects.hashCode(this.mutedUntil());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_a7cdbede other = (Packets.Nested1_a7cdbede) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.uid(), other.uid())
            && java.util.Objects.equals(this.role(), other.role())
            && java.util.Objects.equals(this.badge(), other.badge())
            && java.util.Objects.equals(this.nickStyle(), other.nickStyle())
            && java.util.Objects.equals(this.online(), other.online())
            && java.util.Objects.equals(this.inGame(), other.inGame())
            && java.util.Objects.equals(this.status(), other.status())
            && java.util.Objects.equals(this.lastSeen(), other.lastSeen())
            && java.util.Objects.equals(this.registered(), other.registered())
            && java.util.Objects.equals(this.playtime(), other.playtime())
            && java.util.Objects.equals(this.friendCount(), other.friendCount())
            && java.util.Objects.equals(this.mutual(), other.mutual())
            && java.util.Objects.equals(this.mutualCount(), other.mutualCount())
            && java.util.Objects.equals(this.relationship(), other.relationship())
            && java.util.Objects.equals(this.mutedUntil(), other.mutedUntil());
      }

      public String username() {
         return this.username;
      }

      public int uid() {
         return this.uid;
      }

      public String role() {
         return this.role;
      }

      public String badge() {
         return this.badge;
      }

      public String nickStyle() {
         return this.nickStyle;
      }

      public boolean online() {
         return this.online;
      }

      public boolean inGame() {
         return this.inGame;
      }

      public String status() {
         return this.status;
      }

      public long lastSeen() {
         return this.lastSeen;
      }

      public long registered() {
         return this.registered;
      }

      public long playtime() {
         return this.playtime;
      }

      public int friendCount() {
         return this.friendCount;
      }

      public List<String> mutual() {
         return this.mutual;
      }

      public int mutualCount() {
         return this.mutualCount;
      }

      public String relationship() {
         return this.relationship;
      }

      public long mutedUntil() {
         return this.mutedUntil;
      }
   }

   public static final class Nested1_a9c7710b implements Packet {
      private final long id;
      private final String name;

      public Nested1_a9c7710b(long var1, String var3) {
         this.id = var1;
         this.name = var3;
      }

      @Override
      public String type() {
         return "config_rename";
      }

      @Override
      public final String toString() {
         return "Nested1_a9c7710b[id=" + this.id() + ", name=" + this.name() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_a9c7710b other = (Packets.Nested1_a9c7710b) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.name(), other.name());
      }

      public long id() {
         return this.id;
      }

      public String name() {
         return this.name;
      }
   }

   public static final class Nested1_b318355b implements Packet {
      private final Packets.Nested1_1da0dac9 author;
      private final String name;
      private final Packets.Nested1_3834b16e vector;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_b318355b(Packets.Nested1_1da0dac9 var1, String var2, Packets.Nested1_3834b16e var3, String var4, String var5, String var6) {
         this.author = var1;
         this.name = var2;
         this.vector = var3;
         this.anarchy = var4;
         this.server = var5;
         this.hash = var6;
      }

      @Override
      public String type() {
         return "update_way";
      }

      @Override
      public final String toString() {
         return "Nested1_b318355b[author=" + this.author() + ", name=" + this.name() + ", vector=" + this.vector() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.author());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.vector());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_b318355b other = (Packets.Nested1_b318355b) var1;
         return java.util.Objects.equals(this.author(), other.author())
            && java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.vector(), other.vector())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public Packets.Nested1_1da0dac9 author() {
         return this.author;
      }

      public String name() {
         return this.name;
      }

      public Packets.Nested1_3834b16e vector() {
         return this.vector;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_b32e23fa implements Packet {
      private final String from;
      private final String to;

      public Nested1_b32e23fa(String var1, String var2) {
         this.from = var1;
         this.to = var2;
      }

      @Override
      public String type() {
         return "script_rename_apply";
      }

      @Override
      public final String toString() {
         return "Nested1_b32e23fa[from=" + this.from() + ", to=" + this.to() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.from());
         result = 31 * result + java.util.Objects.hashCode(this.to());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_b32e23fa other = (Packets.Nested1_b32e23fa) var1;
         return java.util.Objects.equals(this.from(), other.from())
            && java.util.Objects.equals(this.to(), other.to());
      }

      public String from() {
         return this.from;
      }

      public String to() {
         return this.to;
      }
   }

   public static final class Nested1_bbeecec5 implements Packet {
      private final String username;

      public Nested1_bbeecec5(String var1) {
         this.username = var1;
      }

      @Override
      public String type() {
         return "friend_request_reject";
      }

      @Override
      public final String toString() {
         return "Nested1_bbeecec5[username=" + this.username() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_bbeecec5 other = (Packets.Nested1_bbeecec5) var1;
         return java.util.Objects.equals(this.username(), other.username());
      }

      public String username() {
         return this.username;
      }
   }

   public static final class Nested1_bc77be65 implements Packet {
      private final long id;

      public Nested1_bc77be65(long var1) {
         this.id = var1;
      }

      @Override
      public String type() {
         return "mod_delete";
      }

      @Override
      public final String toString() {
         return "Nested1_bc77be65[id=" + this.id() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_bc77be65 other = (Packets.Nested1_bc77be65) var1;
         return java.util.Objects.equals(this.id(), other.id());
      }

      public long id() {
         return this.id;
      }
   }

   public static final class Nested1_bdbb1f3d {
      private final double offset;
      private final int color;

      public Nested1_bdbb1f3d(double var1, int var3) {
         this.offset = var1;
         this.color = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_bdbb1f3d[offset=" + this.offset() + ", color=" + this.color() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.offset());
         result = 31 * result + java.util.Objects.hashCode(this.color());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_bdbb1f3d other = (Packets.Nested1_bdbb1f3d) var1;
         return java.util.Objects.equals(this.offset(), other.offset())
            && java.util.Objects.equals(this.color(), other.color());
      }

      public double offset() {
         return this.offset;
      }

      public int color() {
         return this.color;
      }
   }

   public static final class Nested1_bed2a5d4 implements Packet {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String ip;
      private final String hash;
      private final String visibility;
      private final String clientName;

      public Nested1_bed2a5d4(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.ip = var4;
         this.hash = var5;
         this.visibility = var6;
         this.clientName = var7;
      }

      @Override
      public String type() {
         return "game_info_update";
      }

      @Override
      public final String toString() {
         return "Nested1_bed2a5d4[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", ip=" + this.ip() + ", hash=" + this.hash() + ", visibility=" + this.visibility() + ", clientName=" + this.clientName() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.ip());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         result = 31 * result + java.util.Objects.hashCode(this.visibility());
         result = 31 * result + java.util.Objects.hashCode(this.clientName());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_bed2a5d4 other = (Packets.Nested1_bed2a5d4) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.ip(), other.ip())
            && java.util.Objects.equals(this.hash(), other.hash())
            && java.util.Objects.equals(this.visibility(), other.visibility())
            && java.util.Objects.equals(this.clientName(), other.clientName());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String ip() {
         return this.ip;
      }

      public String hash() {
         return this.hash;
      }

      public String visibility() {
         return this.visibility;
      }

      public String clientName() {
         return this.clientName;
      }
   }

   public static final class Nested1_c049773d implements Packet {
      private final long id;
      private final String toUsername;

      public Nested1_c049773d(long var1, String var3) {
         this.id = var1;
         this.toUsername = var3;
      }

      @Override
      public String type() {
         return "message_deleted";
      }

      @Override
      public final String toString() {
         return "Nested1_c049773d[id=" + this.id() + ", toUsername=" + this.toUsername() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_c049773d other = (Packets.Nested1_c049773d) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.toUsername(), other.toUsername());
      }

      public long id() {
         return this.id;
      }

      public String toUsername() {
         return this.toUsername;
      }
   }

   public static final class Nested1_c1986bb7 implements Packet {
      private final String username;

      public Nested1_c1986bb7(String var1) {
         this.username = var1;
      }

      @Override
      public String type() {
         return "friend_added";
      }

      @Override
      public final String toString() {
         return "Nested1_c1986bb7[username=" + this.username() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_c1986bb7 other = (Packets.Nested1_c1986bb7) var1;
         return java.util.Objects.equals(this.username(), other.username());
      }

      public String username() {
         return this.username;
      }
   }

   public static final class Nested1_c489107f implements Packet {
      private final String reqId;
      private final String action;
      private final String key;
      private final String option;
      private final JsonElement value;

      public Nested1_c489107f(String var1, String var2, String var3, String var4, JsonElement var5) {
         this.reqId = var1;
         this.action = var2;
         this.key = var3;
         this.option = var4;
         this.value = var5;
      }

      @Override
      public String type() {
         return "autofarm_request";
      }

      @Override
      public final String toString() {
         return "Nested1_c489107f[reqId=" + this.reqId() + ", action=" + this.action() + ", key=" + this.key() + ", option=" + this.option() + ", value=" + this.value() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.reqId());
         result = 31 * result + java.util.Objects.hashCode(this.action());
         result = 31 * result + java.util.Objects.hashCode(this.key());
         result = 31 * result + java.util.Objects.hashCode(this.option());
         result = 31 * result + java.util.Objects.hashCode(this.value());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_c489107f other = (Packets.Nested1_c489107f) var1;
         return java.util.Objects.equals(this.reqId(), other.reqId())
            && java.util.Objects.equals(this.action(), other.action())
            && java.util.Objects.equals(this.key(), other.key())
            && java.util.Objects.equals(this.option(), other.option())
            && java.util.Objects.equals(this.value(), other.value());
      }

      public String reqId() {
         return this.reqId;
      }

      public String action() {
         return this.action;
      }

      public String key() {
         return this.key;
      }

      public String option() {
         return this.option;
      }

      public JsonElement value() {
         return this.value;
      }
   }

   public static final class Nested1_c59442a1 implements Packet {
      private final Packets.Nested1_3834b16e position;
      private final Packets.Nested1_3834b16e direction;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_c59442a1(Packets.Nested1_3834b16e var1, Packets.Nested1_3834b16e var2, String var3, String var4, String var5) {
         this.position = var1;
         this.direction = var2;
         this.anarchy = var3;
         this.server = var4;
         this.hash = var5;
      }

      @Override
      public String type() {
         return "snowball_throw_send";
      }

      @Override
      public final String toString() {
         return "Nested1_c59442a1[position=" + this.position() + ", direction=" + this.direction() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.position());
         result = 31 * result + java.util.Objects.hashCode(this.direction());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_c59442a1 other = (Packets.Nested1_c59442a1) var1;
         return java.util.Objects.equals(this.position(), other.position())
            && java.util.Objects.equals(this.direction(), other.direction())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public Packets.Nested1_3834b16e position() {
         return this.position;
      }

      public Packets.Nested1_3834b16e direction() {
         return this.direction;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_cff648e6 implements Packet {
      private final String visibility;

      public Nested1_cff648e6(String var1) {
         this.visibility = var1;
      }

      @Override
      public String type() {
         return "visibility_update";
      }

      @Override
      public final String toString() {
         return "Nested1_cff648e6[visibility=" + this.visibility() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.visibility());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_cff648e6 other = (Packets.Nested1_cff648e6) var1;
         return java.util.Objects.equals(this.visibility(), other.visibility());
      }

      public String visibility() {
         return this.visibility;
      }
   }

   public static final class Nested1_d3b0d257 implements Packet {
      private final String toUsername;
      private final String message;

      public Nested1_d3b0d257(String var1, String var2) {
         if (var2 != null && var2.length() > 500) {
            throw new IllegalArgumentException("Private message cannot be longer than 500 characters");
         } else if (var1 != null && !var1.isBlank()) {
            this.toUsername = var1;
            this.message = var2;
         } else {
            throw new IllegalArgumentException("Recipient username cannot be empty");
         }
      }

      @Override
      public String type() {
         return "private_message_send";
      }

      @Override
      public final String toString() {
         return "Nested1_d3b0d257[toUsername=" + this.toUsername() + ", message=" + this.message() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         result = 31 * result + java.util.Objects.hashCode(this.message());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_d3b0d257 other = (Packets.Nested1_d3b0d257) var1;
         return java.util.Objects.equals(this.toUsername(), other.toUsername())
            && java.util.Objects.equals(this.message(), other.message());
      }

      public String toUsername() {
         return this.toUsername;
      }

      public String message() {
         return this.message;
      }
   }

   public static final class Nested1_d4af9385 implements Packet {
      private final String username;
      private final int uid;
      private final String role;

      public Nested1_d4af9385(String var1, int var2, String var3) {
         this.username = var1;
         this.uid = var2;
         this.role = var3;
      }

      @Override
      public String type() {
         return "self_info";
      }

      @Override
      public final String toString() {
         return "Nested1_d4af9385[username=" + this.username() + ", uid=" + this.uid() + ", role=" + this.role() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.uid());
         result = 31 * result + java.util.Objects.hashCode(this.role());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_d4af9385 other = (Packets.Nested1_d4af9385) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.uid(), other.uid())
            && java.util.Objects.equals(this.role(), other.role());
      }

      public String username() {
         return this.username;
      }

      public int uid() {
         return this.uid;
      }

      public String role() {
         return this.role;
      }
   }

   public static final class Nested1_d522beaf implements Packet {
      @Override
      public String type() {
         return "chat_unmuted";
      }

      @Override
      public final String toString() {
         return "Nested1_d522beaf[]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_d522beaf other = (Packets.Nested1_d522beaf) var1;
         return true;
      }
   }

   public static final class Nested1_d6cfc997 {
      private final String type;
      private final String key;
      private final List<Packets.Nested1_bdbb1f3d> stops;
      private final String effect;
      private final String glow;

      public Nested1_d6cfc997(String var1, String var2, List<Packets.Nested1_bdbb1f3d> var3, String var4, String var5) {
         this.type = var1;
         this.key = var2;
         this.stops = var3;
         this.effect = var4;
         this.glow = var5;
      }

      @Override
      public final String toString() {
         return "Nested1_d6cfc997[type=" + this.type() + ", key=" + this.key() + ", stops=" + this.stops() + ", effect=" + this.effect() + ", glow=" + this.glow() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.type());
         result = 31 * result + java.util.Objects.hashCode(this.key());
         result = 31 * result + java.util.Objects.hashCode(this.stops());
         result = 31 * result + java.util.Objects.hashCode(this.effect());
         result = 31 * result + java.util.Objects.hashCode(this.glow());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_d6cfc997 other = (Packets.Nested1_d6cfc997) var1;
         return java.util.Objects.equals(this.type(), other.type())
            && java.util.Objects.equals(this.key(), other.key())
            && java.util.Objects.equals(this.stops(), other.stops())
            && java.util.Objects.equals(this.effect(), other.effect())
            && java.util.Objects.equals(this.glow(), other.glow());
      }

      public String type() {
         return this.type;
      }

      public String key() {
         return this.key;
      }

      public List<Packets.Nested1_bdbb1f3d> stops() {
         return this.stops;
      }

      public String effect() {
         return this.effect;
      }

      public String glow() {
         return this.glow;
      }
   }

   public static final class Nested1_e0d3a78 implements Packet {
      private final String query;
      private final int page;
      private final boolean more;
      private final List<Packets.Nested1_2dfe6b80> people;

      public Nested1_e0d3a78(String var1, int var2, boolean var3, List<Packets.Nested1_2dfe6b80> var4) {
         this.query = var1;
         this.page = var2;
         this.more = var3;
         this.people = var4;
      }

      @Override
      public String type() {
         return "people_list";
      }

      @Override
      public final String toString() {
         return "Nested1_e0d3a78[query=" + this.query() + ", page=" + this.page() + ", more=" + this.more() + ", people=" + this.people() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.query());
         result = 31 * result + java.util.Objects.hashCode(this.page());
         result = 31 * result + java.util.Objects.hashCode(this.more());
         result = 31 * result + java.util.Objects.hashCode(this.people());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_e0d3a78 other = (Packets.Nested1_e0d3a78) var1;
         return java.util.Objects.equals(this.query(), other.query())
            && java.util.Objects.equals(this.page(), other.page())
            && java.util.Objects.equals(this.more(), other.more())
            && java.util.Objects.equals(this.people(), other.people());
      }

      public String query() {
         return this.query;
      }

      public int page() {
         return this.page;
      }

      public boolean more() {
         return this.more;
      }

      public List<Packets.Nested1_2dfe6b80> people() {
         return this.people;
      }
   }

   public static final class Nested1_e23f67fb implements Packet {
      private final List<Packets.Nested1_8f5e2529> scripts;

      public Nested1_e23f67fb(List<Packets.Nested1_8f5e2529> var1) {
         this.scripts = var1;
      }

      @Override
      public String type() {
         return "script_sync";
      }

      @Override
      public final String toString() {
         return "Nested1_e23f67fb[scripts=" + this.scripts() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.scripts());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_e23f67fb other = (Packets.Nested1_e23f67fb) var1;
         return java.util.Objects.equals(this.scripts(), other.scripts());
      }

      public List<Packets.Nested1_8f5e2529> scripts() {
         return this.scripts;
      }
   }

   public static final class Nested1_e38dcab6 {
      private final String username;
      private final String role;
      private final String activity;
      private final String client;
      private final String badge;
      private final String nickStyle;

      public Nested1_e38dcab6(String var1, String var2, String var3, String var4, String var5, String var6) {
         this.username = var1;
         this.role = var2;
         this.activity = var3;
         this.client = var4;
         this.badge = var5;
         this.nickStyle = var6;
      }

      @Override
      public final String toString() {
         return "Nested1_e38dcab6[username=" + this.username() + ", role=" + this.role() + ", activity=" + this.activity() + ", client=" + this.client() + ", badge=" + this.badge() + ", nickStyle=" + this.nickStyle() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.role());
         result = 31 * result + java.util.Objects.hashCode(this.activity());
         result = 31 * result + java.util.Objects.hashCode(this.client());
         result = 31 * result + java.util.Objects.hashCode(this.badge());
         result = 31 * result + java.util.Objects.hashCode(this.nickStyle());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_e38dcab6 other = (Packets.Nested1_e38dcab6) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.role(), other.role())
            && java.util.Objects.equals(this.activity(), other.activity())
            && java.util.Objects.equals(this.client(), other.client())
            && java.util.Objects.equals(this.badge(), other.badge())
            && java.util.Objects.equals(this.nickStyle(), other.nickStyle());
      }

      public String username() {
         return this.username;
      }

      public String role() {
         return this.role;
      }

      public String activity() {
         return this.activity;
      }

      public String client() {
         return this.client;
      }

      public String badge() {
         return this.badge;
      }

      public String nickStyle() {
         return this.nickStyle;
      }
   }

   public static final class Nested1_e7eebdca implements Packet {
      private final String username;
      private final String error;

      public Nested1_e7eebdca(String var1, String var2) {
         this.username = var1;
         this.error = var2;
      }

      @Override
      public String type() {
         return "profile_error";
      }

      @Override
      public final String toString() {
         return "Nested1_e7eebdca[username=" + this.username() + ", error=" + this.error() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.error());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_e7eebdca other = (Packets.Nested1_e7eebdca) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.error(), other.error());
      }

      public String username() {
         return this.username;
      }

      public String error() {
         return this.error;
      }
   }

   public static final class Nested1_e8939e81 implements Packet {
      private final JsonObject payload;

      public Nested1_e8939e81(JsonObject var1) {
         this.payload = var1;
      }

      @Override
      public String type() {
         return "autofarm_state";
      }

      @Override
      public final String toString() {
         return "Nested1_e8939e81[payload=" + this.payload() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.payload());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_e8939e81 other = (Packets.Nested1_e8939e81) var1;
         return java.util.Objects.equals(this.payload(), other.payload());
      }

      public JsonObject payload() {
         return this.payload;
      }
   }

   public static final class Nested1_e908ec43 implements Packet {
      private final String nickname;
      private final String anarchy;
      private final String server;
      private final String hash;

      public Nested1_e908ec43(String var1, String var2, String var3, String var4) {
         this.nickname = var1;
         this.anarchy = var2;
         this.server = var3;
         this.hash = var4;
      }

      @Override
      public String type() {
         return "admin_crash";
      }

      @Override
      public final String toString() {
         return "Nested1_e908ec43[nickname=" + this.nickname() + ", anarchy=" + this.anarchy() + ", server=" + this.server() + ", hash=" + this.hash() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.anarchy());
         result = 31 * result + java.util.Objects.hashCode(this.server());
         result = 31 * result + java.util.Objects.hashCode(this.hash());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_e908ec43 other = (Packets.Nested1_e908ec43) var1;
         return java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.anarchy(), other.anarchy())
            && java.util.Objects.equals(this.server(), other.server())
            && java.util.Objects.equals(this.hash(), other.hash());
      }

      public String nickname() {
         return this.nickname;
      }

      public String anarchy() {
         return this.anarchy;
      }

      public String server() {
         return this.server;
      }

      public String hash() {
         return this.hash;
      }
   }

   public static final class Nested1_f31938b7 implements Packet {
      private final long id;
      private final String name;
      private final boolean active;
      private final JsonObject data;

      public Nested1_f31938b7(long var1, String var3, boolean var4, JsonObject var5) {
         this.id = var1;
         this.name = var3;
         this.active = var4;
         this.data = var5;
      }

      @Override
      public String type() {
         return "config_data";
      }

      @Override
      public final String toString() {
         return "Nested1_f31938b7[id=" + this.id() + ", name=" + this.name() + ", active=" + this.active() + ", data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.active());
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f31938b7 other = (Packets.Nested1_f31938b7) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.active(), other.active())
            && java.util.Objects.equals(this.data(), other.data());
      }

      public long id() {
         return this.id;
      }

      public String name() {
         return this.name;
      }

      public boolean active() {
         return this.active;
      }

      public JsonObject data() {
         return this.data;
      }
   }

   public static final class Nested1_f31cf9ab implements Packet {
      private final List<Packets.Nested1_f320330b> slots;

      public Nested1_f31cf9ab(List<Packets.Nested1_f320330b> var1) {
         this.slots = var1;
      }

      @Override
      public String type() {
         return "config_list";
      }

      @Override
      public final String toString() {
         return "Nested1_f31cf9ab[slots=" + this.slots() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.slots());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f31cf9ab other = (Packets.Nested1_f31cf9ab) var1;
         return java.util.Objects.equals(this.slots(), other.slots());
      }

      public List<Packets.Nested1_f320330b> slots() {
         return this.slots;
      }
   }

   public static final class Nested1_f3200a8a implements Packet {
      private final Long id;
      private final String name;
      private final JsonObject data;

      public Nested1_f3200a8a(Long var1, String var2, JsonObject var3) {
         this.id = var1;
         this.name = var2;
         this.data = var3;
      }

      @Override
      public String type() {
         return "config_save";
      }

      @Override
      public final String toString() {
         return "Nested1_f3200a8a[id=" + this.id() + ", name=" + this.name() + ", data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f3200a8a other = (Packets.Nested1_f3200a8a) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.data(), other.data());
      }

      public Long id() {
         return this.id;
      }

      public String name() {
         return this.name;
      }

      public JsonObject data() {
         return this.data;
      }
   }

   public static final class Nested1_f320330b {
      private final long id;
      private final String name;
      private final boolean active;

      public Nested1_f320330b(long var1, String var3, boolean var4) {
         this.id = var1;
         this.name = var3;
         this.active = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_f320330b[id=" + this.id() + ", name=" + this.name() + ", active=" + this.active() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.active());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f320330b other = (Packets.Nested1_f320330b) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.active(), other.active());
      }

      public long id() {
         return this.id;
      }

      public String name() {
         return this.name;
      }

      public boolean active() {
         return this.active;
      }
   }

   public static final class Nested1_f32063a8 implements Packet {
      @Override
      public String type() {
         return "config_sync";
      }

      @Override
      public final String toString() {
         return "Nested1_f32063a8[]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f32063a8 other = (Packets.Nested1_f32063a8) var1;
         return true;
      }
   }

   public static final class Nested1_f32121f1 implements Packet {
      private final long id;

      public Nested1_f32121f1(long var1) {
         this.id = var1;
      }

      @Override
      public String type() {
         return "config_undo";
      }

      @Override
      public final String toString() {
         return "Nested1_f32121f1[id=" + this.id() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f32121f1 other = (Packets.Nested1_f32121f1) var1;
         return java.util.Objects.equals(this.id(), other.id());
      }

      public long id() {
         return this.id;
      }
   }

   public static final class Nested1_f32a353c implements Packet {
      private final long id;
      private final Packets.Nested1_e38dcab6 author;
      private final String message;

      public Nested1_f32a353c(long var1, Packets.Nested1_e38dcab6 var3, String var4) {
         this.id = var1;
         this.author = var3;
         this.message = var4;
      }

      @Override
      public String type() {
         return "message";
      }

      @Override
      public final String toString() {
         return "Nested1_f32a353c[id=" + this.id() + ", author=" + this.author() + ", message=" + this.message() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.author());
         result = 31 * result + java.util.Objects.hashCode(this.message());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f32a353c other = (Packets.Nested1_f32a353c) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.author(), other.author())
            && java.util.Objects.equals(this.message(), other.message());
      }

      public long id() {
         return this.id;
      }

      public Packets.Nested1_e38dcab6 author() {
         return this.author;
      }

      public String message() {
         return this.message;
      }
   }

   public static final class Nested1_f59883b2 implements Packet {
      private final String name;
      private final String data;
      private final String toUsername;

      public Nested1_f59883b2(String var1, String var2, String var3) {
         this.name = var1;
         this.data = var2;
         this.toUsername = var3;
      }

      @Override
      public String type() {
         return "share_swing_send";
      }

      @Override
      public final String toString() {
         return "Nested1_f59883b2[name=" + this.name() + ", data=" + this.data() + ", toUsername=" + this.toUsername() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.data());
         result = 31 * result + java.util.Objects.hashCode(this.toUsername());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f59883b2 other = (Packets.Nested1_f59883b2) var1;
         return java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.data(), other.data())
            && java.util.Objects.equals(this.toUsername(), other.toUsername());
      }

      public String name() {
         return this.name;
      }

      public String data() {
         return this.data;
      }

      public String toUsername() {
         return this.toUsername;
      }
   }

   public static final class Nested1_f7e89650 implements Packet {
      private final String from;
      private final String nickname;
      private final String data;

      public Nested1_f7e89650(String var1, String var2, String var3) {
         this.from = var1;
         this.nickname = var2;
         this.data = var3;
      }

      @Override
      public String type() {
         return "admin_invsee_data";
      }

      @Override
      public final String toString() {
         return "Nested1_f7e89650[from=" + this.from() + ", nickname=" + this.nickname() + ", data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.from());
         result = 31 * result + java.util.Objects.hashCode(this.nickname());
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f7e89650 other = (Packets.Nested1_f7e89650) var1;
         return java.util.Objects.equals(this.from(), other.from())
            && java.util.Objects.equals(this.nickname(), other.nickname())
            && java.util.Objects.equals(this.data(), other.data());
      }

      public String from() {
         return this.from;
      }

      public String nickname() {
         return this.nickname;
      }

      public String data() {
         return this.data;
      }
   }

   public static final class Nested1_f7ef762e implements Packet {
      private final String data;

      public Nested1_f7ef762e(String var1) {
         this.data = var1;
      }

      @Override
      public String type() {
         return "admin_invsee_send";
      }

      @Override
      public final String toString() {
         return "Nested1_f7ef762e[data=" + this.data() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.data());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f7ef762e other = (Packets.Nested1_f7ef762e) var1;
         return java.util.Objects.equals(this.data(), other.data());
      }

      public String data() {
         return this.data;
      }
   }

   public static final class Nested1_f933e433 implements Packet {
      private final List<Packets.Nested1_1da0dac9> friends;

      public Nested1_f933e433(List<Packets.Nested1_1da0dac9> var1) {
         this.friends = var1;
      }

      @Override
      public String type() {
         return "friends_update";
      }

      @Override
      public final String toString() {
         return "Nested1_f933e433[friends=" + this.friends() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.friends());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_f933e433 other = (Packets.Nested1_f933e433) var1;
         return java.util.Objects.equals(this.friends(), other.friends());
      }

      public List<Packets.Nested1_1da0dac9> friends() {
         return this.friends;
      }
   }

   public static final class Nested1_fac62d1b implements Packet {
      private final long id;

      public Nested1_fac62d1b(long var1) {
         this.id = var1;
      }

      @Override
      public String type() {
         return "config_set_active";
      }

      @Override
      public final String toString() {
         return "Nested1_fac62d1b[id=" + this.id() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Packets.Nested1_fac62d1b other = (Packets.Nested1_fac62d1b) var1;
         return java.util.Objects.equals(this.id(), other.id());
      }

      public long id() {
         return this.id;
      }
   }
}
