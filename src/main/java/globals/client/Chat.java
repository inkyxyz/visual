package globals.client;

import globals.client.messages.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import lombok.Generated;
import rockstar.client.iIIiIIIii_Class292;

public class Chat {
   public static final int MAX_MESSAGES = 400;
   public static final int HISTORY_PAGE = 100;
   private final String name;
   private final iIIiIIIii_Class292 scrollHandler = new iIIiIIIii_Class292();
   private final Object messagesLock = new Object();
   private final TreeMap<Long, Message> messages = new TreeMap<>();
   private volatile List<Long> idsCache = List.of();
   private volatile List<Message> messagesCache = List.of();
   private volatile List<Chat.Nested1_85f345cb> entriesCache = List.of();
   private volatile Set<Long> first = Set.of();
   private volatile long lastMessage;
   private volatile long lastMessageTime = 0L;
   private volatile boolean moreHistory = true;
   private volatile long historyRequestedAt = 0L;

   public Chat(String var1) {
      this.name = var1;
   }

   public List<Long> messageIdsSnapshot() {
      return this.idsCache;
   }

   public List<Message> messagesSnapshot() {
      return this.messagesCache;
   }

   public List<Chat.Nested1_85f345cb> entriesSnapshot() {
      return this.entriesCache;
   }

   public Message getMessage(long var1) {
      synchronized (this.messagesLock) {
         return this.messages.get(var1);
      }
   }

   public Message getLatestMessage() {
      synchronized (this.messagesLock) {
         return this.messages.isEmpty() ? null : this.messages.lastEntry().getValue();
      }
   }

   public long oldestId() {
      synchronized (this.messagesLock) {
         return this.messages.isEmpty() ? 0L : this.messages.firstKey();
      }
   }

   public int size() {
      synchronized (this.messagesLock) {
         return this.messages.size();
      }
   }

   public boolean hasMessage(long var1) {
      synchronized (this.messagesLock) {
         return this.messages.containsKey(var1);
      }
   }

   public boolean hasNonBlankMessage(long var1) {
      synchronized (this.messagesLock) {
         Message var4 = this.messages.get(var1);
         return var4 != null && !var4.text().isBlank();
      }
   }

   public boolean isFirstMessage(long var1) {
      return this.first.contains(var1);
   }

   public void appendMessage(long var1, Message var3) {
      synchronized (this.messagesLock) {
         this.messages.put(var1, var3);

         while (this.messages.size() > 400) {
            this.messages.pollFirstEntry();
            this.moreHistory = true;
         }

         this.rebuild();
      }
   }

   public void removeMessage(long var1) {
      synchronized (this.messagesLock) {
         if (this.messages.remove(var1) != null) {
            this.rebuild();
         }
      }
   }

   public void mergeHistory(Map<Long, Message> var1, boolean var2) {
      synchronized (this.messagesLock) {
         boolean var4 = false;
         List var5 = List.copyOf(var1.keySet());

         for (int var6 = var5.size() - 1; var6 >= 0; var6--) {
            if (this.messages.size() >= 400 && !this.messages.containsKey(var5.get(var6))) {
               var4 = true;
               break;
            }

            this.messages.putIfAbsent((Long)var5.get(var6), (Message)var1.get(var5.get(var6)));
         }

         this.moreHistory = var2 || var4;
         this.rebuild();
      }
   }

   public void scrollToBottom() {
      this.scrollHandler.i_method_57693e1f();
   }

   public void resetMessageAnimations() {
      synchronized (this.messagesLock) {
         for (Message var3 : this.messages.values()) {
            var3.animation().I_method_6ac4da7f();
         }
      }
   }

   private void rebuild() {
      HashSet var1 = new HashSet();
      ArrayList var2 = new ArrayList(this.messages.size());
      String var3 = null;

      for (Entry var5 : this.messages.entrySet()) {
         String var6 = ((Message)var5.getValue()).author().username();
         if (!var6.equals(var3)) {
            var1.add((Long)var5.getKey());
         }

         var3 = var6;
         var2.add(new Chat.Nested1_85f345cb((Long)var5.getKey(), (Message)var5.getValue()));
      }

      this.lastMessage = this.messages.isEmpty() ? 0L : this.messages.lastKey();
      this.first = Set.copyOf(var1);
      this.idsCache = List.copyOf(this.messages.keySet());
      this.messagesCache = List.copyOf(this.messages.values());
      this.entriesCache = List.copyOf(var2);
   }

   @Generated
   public String getName() {
      return this.name;
   }

   @Generated
   public iIIiIIIii_Class292 getScrollHandler() {
      return this.scrollHandler;
   }

   @Generated
   public long getLastMessage() {
      return this.lastMessage;
   }

   @Generated
   public void setLastMessage(long var1) {
      this.lastMessage = var1;
   }

   @Generated
   public long getLastMessageTime() {
      return this.lastMessageTime;
   }

   @Generated
   public void setLastMessageTime(long var1) {
      this.lastMessageTime = var1;
   }

   @Generated
   public boolean isMoreHistory() {
      return this.moreHistory;
   }

   @Generated
   public void setMoreHistory(boolean var1) {
      this.moreHistory = var1;
   }

   @Generated
   public long getHistoryRequestedAt() {
      return this.historyRequestedAt;
   }

   @Generated
   public void setHistoryRequestedAt(long var1) {
      this.historyRequestedAt = var1;
   }

   public static final class Nested1_85f345cb {
      private final long id;
      private final Message message;

      public Nested1_85f345cb(long var1, Message var3) {
         this.id = var1;
         this.message = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_85f345cb[id=" + this.id() + ", message=" + this.message() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.id());
         result = 31 * result + java.util.Objects.hashCode(this.message());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Chat.Nested1_85f345cb other = (Chat.Nested1_85f345cb) var1;
         return java.util.Objects.equals(this.id(), other.id())
            && java.util.Objects.equals(this.message(), other.message());
      }

      public long id() {
         return this.id;
      }

      public Message message() {
         return this.message;
      }
   }
}
