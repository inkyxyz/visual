package rockstar.client;

import pyrock.events.player.ClientPlayerTickEvent;

public class iiIIiiII_Class205 implements IiIIIiII_Class69<ClientPlayerTickEvent> {
   public void onEvent(ClientPlayerTickEvent var1) {
      for (ModuleEntry var3 : RockstarClient.getInstance().getModuleManager().getModules()) {
         if (var3.isEnabled()) {
            var3.II_method_6642fd22();
         }
      }

      IIIIIIIi_Class2.I_method_70b3dfcb().i_method_6c4ee48c();
   }
}
