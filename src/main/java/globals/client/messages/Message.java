package globals.client.messages;

import globals.shared.proto.Packets;
import java.util.List;
import lombok.Generated;
import pyrock.utility.render.Rect;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;

public class Message {
   private final Packets.Nested1_e38dcab6 author;
   private final String text;
   private final boolean self;
   private Rect rect = Rect.EMPTY;
   private Rect avatarRect = Rect.EMPTY;
   private Rect nameRect = Rect.EMPTY;
   private List<Message.Nested1_d637502f> mentions = List.of();
   private Message.Nested1_1dc6ec45 layout;
   private float nameWidth = -1.0F;
   private static final IiiiIiiII_Class237 APPEAR = IiiiIiiII_Class237.I_method_ae57f375(0.0, 0.55, 0.45, 1.0);
   private final IiiiIiIii_Class236 animation = new IiiiIiIii_Class236(260L, APPEAR);

   @Generated
   public Packets.Nested1_e38dcab6 author() {
      return this.author;
   }

   @Generated
   public String text() {
      return this.text;
   }

   @Generated
   public boolean self() {
      return this.self;
   }

   @Generated
   public Rect rect() {
      return this.rect;
   }

   @Generated
   public Rect avatarRect() {
      return this.avatarRect;
   }

   @Generated
   public Rect nameRect() {
      return this.nameRect;
   }

   @Generated
   public List<Message.Nested1_d637502f> mentions() {
      return this.mentions;
   }

   @Generated
   public Message.Nested1_1dc6ec45 layout() {
      return this.layout;
   }

   @Generated
   public float nameWidth() {
      return this.nameWidth;
   }

   @Generated
   public IiiiIiIii_Class236 animation() {
      return this.animation;
   }

   @Generated
   public Message(Packets.Nested1_e38dcab6 var1, String var2, boolean var3) {
      this.author = var1;
      this.text = var2;
      this.self = var3;
   }

   @Generated
   public Message rect(Rect var1) {
      this.rect = var1;
      return this;
   }

   @Generated
   public Message avatarRect(Rect var1) {
      this.avatarRect = var1;
      return this;
   }

   @Generated
   public Message nameRect(Rect var1) {
      this.nameRect = var1;
      return this;
   }

   @Generated
   public Message mentions(List<Message.Nested1_d637502f> var1) {
      this.mentions = var1;
      return this;
   }

   @Generated
   public Message layout(Message.Nested1_1dc6ec45 var1) {
      this.layout = var1;
      return this;
   }

   @Generated
   public Message nameWidth(float var1) {
      this.nameWidth = var1;
      return this;
   }

   public static final class Nested1_1dc6ec45 {
      private final float maxWidth;
      private final List<String> lines;
      private final float width;

      public Nested1_1dc6ec45(float var1, List<String> var2, float var3) {
         this.maxWidth = var1;
         this.lines = var2;
         this.width = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_1dc6ec45[maxWidth=" + this.maxWidth() + ", lines=" + this.lines() + ", width=" + this.width() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.maxWidth());
         result = 31 * result + java.util.Objects.hashCode(this.lines());
         result = 31 * result + java.util.Objects.hashCode(this.width());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Message.Nested1_1dc6ec45 other = (Message.Nested1_1dc6ec45) var1;
         return java.util.Objects.equals(this.maxWidth(), other.maxWidth())
            && java.util.Objects.equals(this.lines(), other.lines())
            && java.util.Objects.equals(this.width(), other.width());
      }

      public float maxWidth() {
         return this.maxWidth;
      }

      public List<String> lines() {
         return this.lines;
      }

      public float width() {
         return this.width;
      }
   }

   public static final class Nested1_d637502f {
      private final String username;
      private final Rect rect;

      public Nested1_d637502f(String var1, Rect var2) {
         this.username = var1;
         this.rect = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_d637502f[username=" + this.username() + ", rect=" + this.rect() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.username());
         result = 31 * result + java.util.Objects.hashCode(this.rect());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         Message.Nested1_d637502f other = (Message.Nested1_d637502f) var1;
         return java.util.Objects.equals(this.username(), other.username())
            && java.util.Objects.equals(this.rect(), other.rect());
      }

      public String username() {
         return this.username;
      }

      public Rect rect() {
         return this.rect;
      }
   }
}
