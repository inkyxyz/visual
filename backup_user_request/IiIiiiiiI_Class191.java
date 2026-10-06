package rockstar.client;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.utility.render.ColorRGBA;

public class IiIiiiiiI_Class191 extends IiIiiiIiI_Class187 {
   private final List<IiIiiiiiI_Class191.Nested1_43252c00> I_field_7865b31 = new CopyOnWriteArrayList<>();
   private String I_field_523beb0a;
   private int I_field_49 = -1;
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = var1x -> {
      if (var1x.getPacket() instanceof GameMessageS2CPacket var2) {
         String var14 = var2.content().getString().replaceAll("\\n", " ").replaceAll("[^\\p{L}\\p{N}\\s\\[\\]:.-]", "").replaceAll("\\s{2,}", " ").trim();
         if (var2.content().getString().contains("\u041f\u043e\u044f\u0432\u0438\u043b\u0441\u044f")) {
            Matcher var4 = Pattern.compile("\\[([^\\]]+)\\]").matcher(var14);
            Matcher var5 = Pattern.compile("\u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430\u0445\\s+(-?\\d+)\\s+(-?\\d+)\\s+(-?\\d+)")
               .matcher(var14);
            Matcher var6 = Pattern.compile("\u0423\u0440\u043e\u0432\u0435\u043d\u044c \u043b\u0443\u0442\u0430:\\s*(\\S+)").matcher(var14);
            if (var4.find() && var5.find()) {
               String var7 = var4.group(1);
               String var8 = var6.find() ? var6.group(1) : null;

               for (IiIiiiiiI_Class191.Nested1_43252c20 var12 : IiIiiiiiI_Class191.Nested1_43252c20.values()) {
                  if (var7.toLowerCase().contains(var12.I_method_2d63f046().toLowerCase())) {
                     this.I_field_7865b31.removeIf(var1xx -> var1xx.I_field_65382e67 == var12);
                     if (var8 != null && !var8.isEmpty()) {
                        String var13 = var8 + " " + var12.I_method_2d63f046();
                        this.I_field_7865b31.add(new IiIiiiiiI_Class191.Nested1_43252c00(var13, System.currentTimeMillis() + var12.I_method_3a7b6b8e(), var12));
                        this.I_field_49 = iIIIiiiII_Class285.i_field_49;
                        if (this.I_field_49 == iIIIiiiII_Class285.i_field_49) {
                           RockstarClient.getInstance()
                              .I_method_cf3ba442()
                              .I_method_b71837ba(var13, Integer.parseInt(var5.group(1)), Integer.parseInt(var5.group(2)), Integer.parseInt(var5.group(3)));
                        }
                     }
                     break;
                  }
               }
            }
         } else {
            for (IiIiiiiiI_Class191.Nested1_43252c20 var21 : IiIiiiiiI_Class191.Nested1_43252c20.values()) {
               if (var14.equalsIgnoreCase(var21.I_method_2d63f046())) {
                  this.I_field_523beb0a = var21.I_method_2d63f046();
                  break;
               }
            }

            if (var14.toLowerCase().startsWith("\u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b")) {
               Matcher var16 = Pattern.compile("\u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b:?\\s*(-?\\d+)\\s+(-?\\d+)\\s+(-?\\d+)", 2)
                  .matcher(var14);
               if (var16.find() && this.I_field_523beb0a != null) {
                  for (IiIiiiiiI_Class191.Nested1_43252c20 var23 : IiIiiiiiI_Class191.Nested1_43252c20.values()) {
                     if (this.I_field_523beb0a.equalsIgnoreCase(var23.I_method_2d63f046())) {
                        this.I_field_7865b31.removeIf(var1xx -> var1xx.I_field_65382e67 == var23);
                        this.I_field_7865b31
                           .add(
                              new IiIiiiiiI_Class191.Nested1_43252c00(var23.I_method_2d63f046(), System.currentTimeMillis() + var23.I_method_3a7b6b8e(), var23)
                           );
                        this.I_field_49 = iIIIiiiII_Class285.i_field_49;
                        RockstarClient.getInstance()
                           .I_method_cf3ba442()
                           .I_method_b71837ba(
                              var23.I_method_2d63f046(), Integer.parseInt(var16.group(1)), Integer.parseInt(var16.group(2)), Integer.parseInt(var16.group(3))
                           );
                        break;
                     }
                  }

                  this.I_field_523beb0a = null;
               }
            }
         }
      }
   };
   private final IiIIIiII_Class69<WorldChangeEvent> i_field_3d936f41 = var1x -> {
      if (iIIIiiiII_Class285.i_field_49 != this.I_field_49) {
         this.I_field_7865b31.forEach(var0 -> RockstarClient.getInstance().I_method_cf3ba442().I_method_d7f5649(var0.I_method_e730c826()));
         this.I_field_7865b31.clear();
         this.I_field_523beb0a = null;
      }
   };

   public IiIiiiiiI_Class191(MultiSelectSetting var1) {
      super(var1, "events");
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   @Override
   public void prepare(IiIiiIIII_Class177 var1) {
      long var2 = System.currentTimeMillis();
      this.I_method_a5d2ec25(var2);
      if (!this.I_field_7865b31.isEmpty()) {
         IiIiiiiiI_Class191.Nested1_43252c00 var4 = this.I_field_7865b31.getFirst();
         long var5 = var4.I_method_3e057ae() - var2;
         if (var5 > 0L) {
            int var7 = (int)(var5 / 1000L);
            int var8 = var7 / 60;
            int var9 = var7 % 60;
            String var10 = String.format("%d:%02d", var8, var9);
            ColorRGBA var11 = this.I_method_aacde471(var4.I_field_65382e67);
            this.I_method_44ddbec5(
               Integer.parseInt(var10.split(":")[0]) + ":", "", Integer.parseInt(var10.split(":")[1]), var4.I_field_65382e67.I_field_523beb0a, var11
            );
         }
      }

      super.prepare(var1);
   }

   private ColorRGBA I_method_aacde471(IiIiiiiiI_Class191.Nested1_43252c20 var1) {
      return switch (var1) {
         case I_field_65382e67 -> new ColorRGBA(138.0F, 43.0F, 226.0F);
         case i_field_65382e67 -> new ColorRGBA(255.0F, 69.0F, 0.0F);
         case II_field_65382e67 -> new ColorRGBA(255.0F, 140.0F, 0.0F);
         case Ii_field_65382e67 -> new ColorRGBA(70.0F, 130.0F, 180.0F);
         case iI_field_65382e67 -> new ColorRGBA(243.0F, 196.0F, 82.0F);
         case ii_field_65382e67 -> new ColorRGBA(139.0F, 222.0F, 221.0F);
         case III_field_65382e67 -> new ColorRGBA(141.0F, 99.0F, 184.0F);
         case IIi_field_65382e67 -> new ColorRGBA(41.0F, 253.0F, 5.0F);
         case IiI_field_65382e67 -> new ColorRGBA(90.0F, 158.0F, 152.0F);
      };
   }

   @Override
   public boolean canShow() {
      this.I_method_a5d2ec25(System.currentTimeMillis());
      return !this.I_field_7865b31.isEmpty();
   }

   private void I_method_a5d2ec25(long var1) {
      this.I_field_7865b31.removeIf(var2 -> {
         if (var1 < var2.I_method_3e057ae()) {
            return false;
         } else {
            RockstarClient.getInstance().I_method_cf3ba442().I_method_d7f5649(var2.I_method_e730c826());
            return true;
         }
      });
   }

   static final class Nested1_43252c00 {
      private final String I_field_523beb0a;
      private final long I_field_4a;
      final IiIiiiiiI_Class191.Nested1_43252c20 I_field_65382e67;

      Nested1_43252c00(String var1, long var2, IiIiiiiiI_Class191.Nested1_43252c20 var4) {
         this.I_field_523beb0a = var1;
         this.I_field_4a = var2;
         this.I_field_65382e67 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_43252c00[waypointName=" + this.I_field_523beb0a + ", expiresAt=" + this.I_field_4a + ", type=" + this.I_field_65382e67 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_65382e67);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiiiiiI_Class191.Nested1_43252c00 other = (IiIiiiiiI_Class191.Nested1_43252c00) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a)
            && java.util.Objects.equals(this.I_field_65382e67, other.I_field_65382e67);
      }

      public String I_method_e730c826() {
         return this.I_field_523beb0a;
      }

      public long I_method_3e057ae() {
         return this.I_field_4a;
      }

      public IiIiiiiiI_Class191.Nested1_43252c20 I_method_22f547cb() {
         return this.I_field_65382e67;
      }
   }

   static enum Nested1_43252c20 {
      I_field_65382e67("\u041c\u0438\u0441\u0442\u0438\u0447\u0435\u0441\u043a\u0438\u0439 \u0410\u043b\u0442\u0430\u0440\u044c", 360000L),
      i_field_65382e67("\u041c\u0430\u044f\u043a \u0423\u0431\u0438\u0439\u0446\u0430", 360000L),
      II_field_65382e67("\u0412\u0443\u043b\u043a\u0430\u043d", 300000L),
      Ii_field_65382e67("\u041c\u0435\u0442\u0435\u043e\u0440\u0438\u0442\u043d\u044b\u0439 \u0434\u043e\u0436\u0434\u044c", 180000L),
      iI_field_65382e67("\u041f\u043e\u0441\u044b\u043b\u043a\u0430", 180000L),
      ii_field_65382e67("\u0411\u043e\u0441\u0441", 180000L),
      III_field_65382e67("\u041a\u043e\u043d\u0442\u0435\u0439\u043d\u0435\u0440", 180000L),
      IIi_field_65382e67("\u0413\u0440\u0443\u0437", 180000L),
      IiI_field_65382e67("\u0422\u0430\u0438\u043d\u0441\u0442\u0432\u0435\u043d\u043d\u044b\u0439 \u043a\u043e\u0440\u0430\u0431\u043b\u044c", 300000L);

      final String I_field_523beb0a;
      final long I_field_4a;

      @Generated
      public String I_method_2d63f046() {
         return this.I_field_523beb0a;
      }

      @Generated
      public long I_method_3a7b6b8e() {
         return this.I_field_4a;
      }

      @Generated
      private Nested1_43252c20(String var3, long var4) {
         this.I_field_523beb0a = var3;
         this.I_field_4a = var4;
      }
   }
}
