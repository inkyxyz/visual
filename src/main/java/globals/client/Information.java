package globals.client;

import globals.client.Chat;
import globals.client.GlobalsUser;
import globals.client.api.RockNetClient;
import globals.shared.proto.Packets;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import lombok.Generated;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIiiII_Class269;
import rockstar.client.iIIiIIiIi_Class294;

public class Information {
    public static final String GLOBAL_CHAT = IiIiIIII_Class81.I_method_f25a980a("rocknet.chat.global.id");
    private static GlobalsUser preferUser;
    private static GlobalsUser user;
    private static String result;
    private static final Object chatsLock;
    private static final Map<String, Chat> chats;
    private static List<String> requests;
    public static List<Packets.Nested1_1da0dac9> friends;
    private static volatile Map<String, Packets.Nested1_1da0dac9> friendIndex;
    private static volatile int friendsVersion;
    public static List<Packets.Nested1_1da0dac9> visiblePlayers;
    private static boolean freezed;
    private static Packets.Nested1_d4af9385 self;
    private static final List<Packets.Nested1_2dfe6b80> people;
    private static String peopleQuery;
    private static int peoplePage;
    private static boolean peopleMore;
    private static boolean peopleLoading;
    private static final long REQUEST_TIMEOUT = 8000L;
    private static long peopleRequestedAt;
    private static long profileRequestedAt;
    private static final Map<String, Packets.Nested1_2dfe6b80> peopleIndex;
    private static Packets.Nested1_a7cdbede profile;
    private static String profileLoading;
    private static final Map<String, Packets.Nested1_a7cdbede> peers;
    private static final Map<String, Long> peersAsked;
    private static final long PEER_TTL = 30000L;
    private static final long PEER_GAP = 1500L;
    private static long peerAskedAt;
    private static long muteUntil;
    private static String muteReason;
    private static final Map<String, Identifier> cache;
    private static final Set<String> loadingAvatars;
    private static final ExecutorService avatarLoader;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<Chat> chats() {
        Object object = chatsLock;
        synchronized (object) {
            return new ArrayList<Chat>(chats.values());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Chat byName(String string) {
        Object object = chatsLock;
        synchronized (object) {
            Chat chat = chats.get(string);
            if (chat == null) {
                chat = new Chat(string);
                chats.put(string, chat);
            }
            return chat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void moveToTop(String string) {
        Object object = chatsLock;
        synchronized (object) {
            if (!chats.containsKey(string)) {
                return;
            }
            Chat chat = chats.get(string);
            chats.remove(string);
            LinkedHashMap<String, Chat> linkedHashMap = new LinkedHashMap<String, Chat>();
            linkedHashMap.put(string, chat);
            linkedHashMap.putAll(chats);
            chats.clear();
            chats.putAll(linkedHashMap);
        }
    }

    public static List<String> dialogs() {
        List<Chat> list = Information.chats();
        list.removeIf(chat -> chat.getName().equals(GLOBAL_CHAT) || chat.getLatestMessage() == null);
        list.sort((chat, chat2) -> Long.compare(chat2.getLastMessageTime(), chat.getLastMessageTime()));
        ArrayList<String> arrayList = new ArrayList<String>(list.size());
        for (Chat chat3 : list) {
            arrayList.add(chat3.getName());
        }
        return arrayList;
    }

    public static void setFriends(List<Packets.Nested1_1da0dac9> arrayList) {
        friends = arrayList == null ? new ArrayList() : arrayList;
        HashMap<String, Packets.Nested1_1da0dac9> hashMap = new HashMap<String, Packets.Nested1_1da0dac9>();
        for (Packets.Nested1_1da0dac9 nested1_1da0dac9 : friends) {
            if (nested1_1da0dac9 == null || nested1_1da0dac9.username() == null) continue;
            hashMap.put(nested1_1da0dac9.username(), nested1_1da0dac9);
        }
        friendIndex = hashMap;
        ++friendsVersion;
    }

    public static Packets.Nested1_1da0dac9 friend(String string) {
        return string == null ? null : friendIndex.get(string);
    }

    public static List<Packets.Nested1_1da0dac9> getSortedFriends() {
        ArrayList<Packets.Nested1_1da0dac9> arrayList = new ArrayList<Packets.Nested1_1da0dac9>(friends);
        arrayList.sort((nested1_1da0dac9, nested1_1da0dac92) -> {
            Chat chat = Information.byName(nested1_1da0dac9.username());
            Chat chat2 = Information.byName(nested1_1da0dac92.username());
            return Long.compare(chat2.getLastMessageTime(), chat.getLastMessageTime());
        });
        return arrayList;
    }

    public static void setVisiblePlayers(List<Packets.Nested1_1da0dac9> list) {
        ArrayList<Packets.Nested1_1da0dac9> arrayList = new ArrayList<Packets.Nested1_1da0dac9>();
        for (Packets.Nested1_1da0dac9 nested1_1da0dac9 : list) {
            Packets.Nested1_242f4d2b nested1_242f4d2b = nested1_1da0dac9.gameInfo();
            if (nested1_242f4d2b != null && (nested1_242f4d2b.nickname() == null || nested1_242f4d2b.nickname().isBlank())) continue;
            arrayList.add(nested1_1da0dac9);
        }
        visiblePlayers = arrayList;
    }

    public static boolean staff() {
        return self != null && ("admin".equals(self.role()) || "moderator".equals(self.role()));
    }

    public static void requestPeople(String string, int n) {
        if (peopleLoading) {
            return;
        }
        peopleLoading = true;
        peopleRequestedAt = System.currentTimeMillis();
        peopleQuery = string == null ? "" : string;
        RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_6bdee275(peopleQuery, n));
    }

    public static boolean peopleFailed() {
        return peopleLoading && System.currentTimeMillis() - peopleRequestedAt > 8000L;
    }

    public static boolean profileFailed() {
        return profileLoading != null && System.currentTimeMillis() - profileRequestedAt > 8000L;
    }

    public static void onPeople(Packets.Nested1_e0d3a78 nested1_e0d3a78) {
        peopleLoading = false;
        if (!nested1_e0d3a78.query().equals(peopleQuery)) {
            return;
        }
        if (nested1_e0d3a78.page() == 0) {
            people.clear();
            peopleIndex.clear();
        }
        people.addAll(nested1_e0d3a78.people());
        for (Packets.Nested1_2dfe6b80 nested1_2dfe6b80 : nested1_e0d3a78.people()) {
            peopleIndex.put(nested1_2dfe6b80.username(), nested1_2dfe6b80);
        }
        peoplePage = nested1_e0d3a78.page();
        peopleMore = nested1_e0d3a78.more();
    }

    public static Packets.Nested1_2dfe6b80 person(String string) {
        return peopleIndex.get(string);
    }

    public static void resetPeople() {
        people.clear();
        peopleIndex.clear();
        peoplePage = 0;
        peopleMore = false;
        peopleLoading = false;
        peopleQuery = "";
    }

    public static void requestProfile(String string) {
        profile = null;
        profileLoading = string;
        profileRequestedAt = System.currentTimeMillis();
        RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_40acf5d1(string));
    }

    public static void closeProfile() {
        profile = null;
        profileLoading = null;
    }

    public static Packets.Nested1_a7cdbede peer(String string) {
        return string == null ? null : peers.get(string);
    }

    public static void cachePeer(Packets.Nested1_a7cdbede nested1_a7cdbede) {
        peers.put(nested1_a7cdbede.username(), nested1_a7cdbede);
    }

    public static void refreshPeer(String string) {
        if (string == null || string.isBlank() || string.equals(GLOBAL_CHAT)) {
            return;
        }
        long l = System.currentTimeMillis();
        Long l2 = peersAsked.get(string);
        if (l2 != null && l - l2 < 30000L) {
            return;
        }
        if (l - peerAskedAt < 1500L) {
            return;
        }
        peersAsked.put(string, l);
        peerAskedAt = l;
        RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_40acf5d1(string));
    }

    public static boolean muted() {
        if (muteUntil == 0L) {
            return false;
        }
        if (muteUntil < 0L) {
            return true;
        }
        if (System.currentTimeMillis() < muteUntil) {
            return true;
        }
        muteUntil = 0L;
        return false;
    }

    public static void clearAvatars() {
        cache.clear();
        loadingAvatars.clear();
    }

    public static Identifier getSelfAvatar() {
        return RockstarClient.id("rocknet/profile_avatar.png");
    }

    public static Identifier getAvatar(String string) {
        Identifier identifier = cache.get(string);
        if (identifier != null) {
            return identifier;
        }
        if (string == null || string.isBlank() || !loadingAvatars.add(string)) {
            return RockstarClient.id("rocknet/avatar.png");
        }
        avatarLoader.submit(() -> {
            try {
                RockNetClient rockNetClient = RockstarClient.getInstance().I_method_cd3d46d0();
                String string2 = rockNetClient.getHttpBase() + "/users/" + string + "/avatar";
                BufferedImage bufferedImage = ImageIO.read(URI.create(string2).toURL());
                if (bufferedImage == null) {
                    cache.put(string, RockstarClient.id("rocknet/avatar.png"));
                    return;
                }
                NativeImage nativeImage = iIIIIiiII_Class269.I_method_97bf3255(bufferedImage, false);
                Identifier avatarIdentifier = RockstarClient.id("temp/avatar/" + String.valueOf(UUID.randomUUID()));
                iIIiIIiIi_Class294.I_field_3a9bda27.execute(() -> {
                    iIIiIIiIi_Class294.I_field_3a9bda27.getTextureManager().registerTexture(avatarIdentifier, (AbstractTexture)new NativeImageBackedTexture(nativeImage));
                    cache.put(string, avatarIdentifier);
                });
            }
            catch (Exception exception) {
                cache.put(string, RockstarClient.id("rocknet/avatar.png"));
            }
        });
        return RockstarClient.id("rocknet/avatar.png");
    }

    @Generated
    public static void setPreferUser(GlobalsUser globalsUser) {
        preferUser = globalsUser;
    }

    @Generated
    public static void setUser(GlobalsUser globalsUser) {
        user = globalsUser;
    }

    @Generated
    public static GlobalsUser getPreferUser() {
        return preferUser;
    }

    @Generated
    public static GlobalsUser getUser() {
        return user;
    }

    @Generated
    public static void setResult(String string) {
        result = string;
    }

    @Generated
    public static String getResult() {
        return result;
    }

    @Generated
    public static void setRequests(List<String> list) {
        requests = list;
    }

    @Generated
    public static List<String> getRequests() {
        return requests;
    }

    @Generated
    public static List<Packets.Nested1_1da0dac9> getFriends() {
        return friends;
    }

    @Generated
    public static int getFriendsVersion() {
        return friendsVersion;
    }

    @Generated
    public static List<Packets.Nested1_1da0dac9> getVisiblePlayers() {
        return visiblePlayers;
    }

    @Generated
    public static void setFreezed(boolean bl) {
        freezed = bl;
    }

    @Generated
    public static boolean isFreezed() {
        return freezed;
    }

    @Generated
    public static void setSelf(Packets.Nested1_d4af9385 nested1_d4af9385) {
        self = nested1_d4af9385;
    }

    @Generated
    public static Packets.Nested1_d4af9385 getSelf() {
        return self;
    }

    @Generated
    public static List<Packets.Nested1_2dfe6b80> getPeople() {
        return people;
    }

    @Generated
    public static void setPeopleQuery(String string) {
        peopleQuery = string;
    }

    @Generated
    public static String getPeopleQuery() {
        return peopleQuery;
    }

    @Generated
    public static int getPeoplePage() {
        return peoplePage;
    }

    @Generated
    public static boolean isPeopleMore() {
        return peopleMore;
    }

    @Generated
    public static boolean isPeopleLoading() {
        return peopleLoading;
    }

    @Generated
    public static void setProfile(Packets.Nested1_a7cdbede nested1_a7cdbede) {
        profile = nested1_a7cdbede;
    }

    @Generated
    public static Packets.Nested1_a7cdbede getProfile() {
        return profile;
    }

    @Generated
    public static void setProfileLoading(String string) {
        profileLoading = string;
    }

    @Generated
    public static String getProfileLoading() {
        return profileLoading;
    }

    @Generated
    public static void setMuteUntil(long l) {
        muteUntil = l;
    }

    @Generated
    public static long getMuteUntil() {
        return muteUntil;
    }

    @Generated
    public static void setMuteReason(String string) {
        muteReason = string;
    }

    @Generated
    public static String getMuteReason() {
        return muteReason;
    }

    @Generated
    public static Map<String, Identifier> getCache() {
        return cache;
    }

    static {
        chatsLock = new Object();
        chats = new LinkedHashMap<String, Chat>();
        requests = new ArrayList<String>();
        friends = new ArrayList<Packets.Nested1_1da0dac9>();
        friendIndex = Map.of();
        visiblePlayers = new ArrayList<Packets.Nested1_1da0dac9>();
        people = new ArrayList<Packets.Nested1_2dfe6b80>();
        peopleQuery = "";
        peopleIndex = new HashMap<String, Packets.Nested1_2dfe6b80>();
        peers = new ConcurrentHashMap<String, Packets.Nested1_a7cdbede>();
        peersAsked = new ConcurrentHashMap<String, Long>();
        muteReason = "";
        cache = new ConcurrentHashMap<String, Identifier>();
        loadingAvatars = ConcurrentHashMap.newKeySet();
        avatarLoader = Executors.newFixedThreadPool(4, runnable -> {
            Thread thread = new Thread(runnable, "Rockstar-Worker-Avatar");
            thread.setDaemon(true);
            return thread;
        });
    }
}
