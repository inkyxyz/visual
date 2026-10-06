package rockstar.client;

import globals.client.Information;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import pyrock.events.game.InternalAttackEvent;
import pyrock.events.game.SendMessageEvent;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.network.ServerConnectionEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import ua.mintantileak.profile.Profile;

public class iiIIiiIii_Class412 {
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private int I_field_49;
   private boolean I_field_5a;
   private final List<ModeSetting.Nested1_42765c60> I_field_7865b31 = new ArrayList<>();
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      AuraModule var2 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
      if (this.I_field_500d0627 != var2.I_method_497abf22().i_method_f85f3850()) {
         this.I_field_49++;
         this.I_field_5a = false;
         if (!this.I_field_7865b31.contains(var2.I_method_497abf22().i_method_f85f3850())) {
            this.I_field_7865b31.add(var2.I_method_497abf22().i_method_f85f3850());
         }

         if (this.I_field_500d0627 != null && !this.I_field_7865b31.contains(this.I_field_500d0627)) {
            this.I_field_7865b31.add(this.I_field_500d0627);
         }
      }
   };
   private final IiIIIiII_Class69<ServerConnectionEvent> i_field_3d936f41 = var1 -> {
      this.I_field_49 = 0;
      this.I_field_7865b31.clear();
      iiIIiiiII_Class413.I_method_78d3ce29(
         String.format(
            "\ud83e\uddd4 %s(%s) \u0437\u0430\u0448\u0451\u043b \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440 %s(%s) \u0441 \u044e\u0437\u0435\u0440\u043d\u0435\u0439\u043c\u043e\u043c %s",
            Profile.getUsername(),
            this.i_method_141fdc61(),
            iIIIiiiII_Class285.I_method_a5157a15(var1.getAddress().getAddress(), false),
            var1.getAddress().getAddress(),
            iIIiIIiIi_Class294.I_field_3a9bda27.getSession().getUsername()
         )
      );
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> II_field_3d936f41 = var1 -> {
      if (var1.getPacket() instanceof GameMessageS2CPacket var2 && iIIiIIiIi_Class294.I_field_3a9bda27.player != null) {
         for (String var6 : this.I_method_17af904e()) {
            if (var2.content().getString().contains(var6)) {
               iiIIiiiII_Class413.I_method_78d3ce29(
                  String.format(
                     "@ConeTin \u26a0\ufe0f %s(%s) \u043f\u043e\u043b\u0443\u0447\u0438\u043b \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 %s (\u043d\u0438\u043a\u043d\u0435\u0439\u043c \u044e\u0437\u0435\u0440\u0430 %s)",
                     Profile.getUsername(),
                     this.i_method_141fdc61(),
                     var2.content().getString(),
                     iIIiIIiIi_Class294.I_field_3a9bda27.getSession().getUsername()
                  )
               );
            }
         }
      }
   };
   private final IiIIIiII_Class69<SendMessageEvent> Ii_field_3d936f41 = var1 -> {
      for (String var5 : this.I_method_17af904e()) {
         if (var1.getMessage().contains(var5)) {
            iiIIiiiII_Class413.I_method_78d3ce29(
               String.format(
                  "@ConeTin \u26a0\ufe0f %s(%s) \u043e\u0442\u043f\u0440\u0430\u0432\u0438\u043b \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 %s (\u043d\u0438\u043a\u043d\u0435\u0439\u043c \u044e\u0437\u0435\u0440\u0430 %s)",
                  Profile.getUsername(),
                  this.i_method_141fdc61(),
                  var1.getMessage(),
                  iIIiIIiIi_Class294.I_field_3a9bda27.getSession().getUsername()
               )
            );
         }
      }
   };
   private final IiIIIiII_Class69<InternalAttackEvent> iI_field_3d936f41 = var1 -> {
      AuraModule var2 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
      this.I_field_500d0627 = var2.I_method_497abf22().i_method_f85f3850();
      if (this.I_field_49 > 3 && !this.I_field_5a && this.I_field_7865b31.size() >= 3) {
         iiIIiiiII_Class413.I_method_78d3ce29(
            String.format(
               "@ConeTin \u26a0\ufe0f %s(%s) \u0442\u0435\u0441\u0442\u0438\u0442 \u0440\u043e\u0442\u0430\u0446\u0438\u0438 (%s) \u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u0435 %s (\u043d\u0438\u043a\u043d\u0435\u0439\u043c \u044e\u0437\u0435\u0440\u0430 %s)",
               Profile.getUsername(),
               this.i_method_141fdc61(),
               this.I_method_81012c41(),
               var1.getEntity().getName().getString(),
               iIIiIIiIi_Class294.I_field_3a9bda27.getSession().getUsername()
            )
         );
         this.I_field_5a = true;
      }

      for (String var6 : this.I_method_17af904e()) {
         if (var1.getEntity().getName().getString().contains(var6)) {
            iiIIiiiII_Class413.I_method_78d3ce29(
               String.format(
                  "@ConeTin \u26a0\ufe0f %s(%s) \u0430\u0442\u0430\u043a\u0443\u0435\u0442 %s (\u043d\u0438\u043a\u043d\u0435\u0439\u043c \u044e\u0437\u0435\u0440\u0430 %s)",
                  Profile.getUsername(),
                  this.i_method_141fdc61(),
                  var1.getEntity().getName().getString(),
                  iIIiIIiIi_Class294.I_field_3a9bda27.getSession().getUsername()
               )
            );
         }
      }
   };
   private final IiIIIiII_Class69<SendPacketEvent> ii_field_3d936f41 = var0 -> {};

   public iiIIiiIii_Class412() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public String I_method_81012c41() {
      StringBuilder var1 = new StringBuilder();

      for (ModeSetting.Nested1_42765c60 var3 : this.I_field_7865b31) {
         var1.append(IiIiIIII_Class81.I_method_f25a980a(var3.getName()));
         if (var3 != this.I_field_7865b31.getLast()) {
            var1.append(", ");
         }
      }

      return var1.toString();
   }

   public String i_method_141fdc61() {
      String var1 = "null";
      if (Information.getPreferUser() != null) {
         var1 = Information.getPreferUser().username();
      }

      return var1;
   }

   public String[] I_method_17af904e() {
      return new String[]{"postmarketOS"};
   }
}
