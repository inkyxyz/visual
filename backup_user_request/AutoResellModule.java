package rockstar.client;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.slot.SlotActionType;
import org.jetbrains.annotations.NotNull;
import pyrock.events.network.ReceivePacketEvent;

@ModuleInfo(
   name = "Auto Resell",
   category = ModuleCategory.OTHER,
   III_method_a89e5834 = "modules.descriptions.auto_resell"
)
public class AutoResellModule extends Module {
   private AutoResellModule.Nested1_1f388820 I_field_b905267 = AutoResellModule.Nested1_1f388820.i_field_b905267;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private long I_field_4a = 60000L;
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = var1 -> {
      if (var1.getPacket() instanceof GameMessageS2CPacket var2) {
         String var8 = var2.content().getString();
         if (var8.contains(
            "\u041f\u0440\u0435\u0434\u043c\u0435\u0442\u044b \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u043f\u0435\u0440\u0435\u0432\u044b\u0441\u0442\u0430\u0432\u043b\u0435\u043d\u044b"
         )) {
            this.I_field_4a = 60000L;
            this.I_field_b905267 = AutoResellModule.Nested1_1f388820.Ii_field_b905267;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }

         if (var8.contains("\u041f\u043e\u0434\u043e\u0436\u0434\u0438\u0442\u0435") && var8.contains("\u0441\u0435\u043a")) {
            for (String var7 : var8.split(" ")) {
               if (var7.matches("\\d+")) {
                  this.I_field_4a = Integer.parseInt(var7) * 1000L + 500L;
                  this.I_field_b905267 = AutoResellModule.Nested1_1f388820.I_field_b905267;
                  this.I_field_991c1e8c.I_method_23e11e3f();
                  break;
               }
            }
         }
      }
   };

   @Override
   public void II_method_6642fd22() {
      long var1 = (long)(
         I_field_3a9bda27.player.networkHandler.getPlayerListEntry(I_field_3a9bda27.player.getUuid()).getLatency() * 2.5F
            + iIIiiiiiI_Class319.I_method_b56b22f(24.0, 59.0)
      );
      switch (this.I_field_b905267) {
         case I_field_b905267:
            this.IiI_method_45f4adf();
            break;
         case i_field_b905267:
            this.I_method_529b3845(var1);
            break;
         case II_field_b905267:
            this.i_method_545e2865(var1);
            break;
         case Ii_field_b905267:
            this.Iii_method_46dd6bf();
      }
   }

   private void IiI_method_45f4adf() {
      if (this.I_field_991c1e8c.I_method_58432069(this.I_field_4a)) {
         this.I_field_b905267 = AutoResellModule.Nested1_1f388820.i_field_b905267;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void Iii_method_46dd6bf() {
      if (this.I_field_991c1e8c.I_method_58432069(500L)) {
         I_field_3a9bda27.player.closeHandledScreen();
         this.I_field_b905267 = AutoResellModule.Nested1_1f388820.I_field_b905267;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void I_method_529b3845(long var1) {
      if (I_field_3a9bda27.currentScreen instanceof HandledScreen var3) {
         if (var3.getTitle().getString().contains("\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435")) {
            this.I_field_b905267 = AutoResellModule.Nested1_1f388820.II_field_b905267;
            this.I_field_991c1e8c.I_method_23e11e3f();
         } else if (this.I_method_80677a6d(var3.getTitle().getString())) {
            if (this.I_field_991c1e8c.I_method_58432069(var1 + 200L)) {
               I_field_3a9bda27.interactionManager.clickSlot(var3.getScreenHandler().syncId, 46, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         } else {
            if (this.I_field_991c1e8c.I_method_58432069(var1 + 200L)) {
               I_field_3a9bda27.player.closeHandledScreen();
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      } else {
         if (this.I_field_991c1e8c.I_method_58432069(var1 + 200L)) {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("ah");
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void i_method_545e2865(long var1) {
      if (I_field_3a9bda27.currentScreen instanceof HandledScreen var3
         && var3.getTitle().getString().contains("\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435")) {
         if (this.I_field_991c1e8c.I_method_58432069(var1 + 200L)) {
            I_field_3a9bda27.interactionManager.clickSlot(var3.getScreenHandler().syncId, 52, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   public boolean I_method_80677a6d(@NotNull String var1) {
      return IiiiiIIii_Class244.II_method_6da14e50(var1);
   }

   static enum Nested1_1f388820 {
      I_field_b905267,
      i_field_b905267,
      II_field_b905267,
      Ii_field_b905267;
   }
}
