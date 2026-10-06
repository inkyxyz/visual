package rockstar.client;

import java.util.List;
import java.util.Set;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import pyrock.events.game.FinishEatEvent;
import pyrock.events.network.ReceivePacketEvent;

@ModuleInfo(
   name = "Tracker",
   category = ModuleCategory.PLAYER
)
public class TrackerModule extends Module {
   private static final Set<Item> I_field_a56a8dc5 = Set.of(Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE, Items.CHORUS_FRUIT, Items.POTION);
   private final IiIIIiII_Class69<FinishEatEvent> I_field_3d936f41 = var1 -> {
      ItemStack var2 = var1.getStack();
      if (I_field_a56a8dc5.contains(var2.getItem()) && var1.getUser() != I_field_3a9bda27.player) {
         String var3 = var2.getItem() == Items.POTION ? this.I_method_3b94f75f(var2) : var2.getName().getString();
         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_67864747(
               new iiiIiIi_Class118(
                     var1.getUser().getName().getString()
                        + (var2.getItem() == Items.POTION ? " \u0432\u044b\u043f\u0438\u043b " : " \u0441\u044a\u0435\u043b ")
                        + var3,
                     var2
                  )
                  .I_method_7ab92a7f(var3)
            );
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41 = var0 -> {
      if (var0.getPacket() instanceof EntityStatusS2CPacket var1 && var1.getStatus() == 35) {
         Entity var8 = var1.getEntity(I_field_3a9bda27.world);
         if (var8 == null || var8 == I_field_3a9bda27.player || !(var8 instanceof PlayerEntity var3)) {
            return;
         }

         ItemStack var4 = var3.getOffHandStack().contains(DataComponentTypes.DEATH_PROTECTION)
            ? var3.getOffHandStack().copy()
            : (var3.getMainHandStack().contains(DataComponentTypes.DEATH_PROTECTION) ? var3.getMainHandStack().copy() : new ItemStack(Items.TOTEM_OF_UNDYING));
         IiiiiIiii_Class248.Nested1_95187080 var5 = IiiiiIiii_Class248.I_method_7613ca72(var4);
         String var6 = var5 != null ? var5.I_method_2310f504(var4) : var4.getName().getString();
         iiiIiIi_Class118 var7 = new iiiIiIi_Class118(var3.getName().getString() + " \u043f\u043e\u0442\u0435\u0440\u044f\u043b " + var6, var4)
            .I_method_7ab92a7f(var6);
         if (var5 != null) {
            var7.I_method_c9efc756(var5.I_method_40d7118b(var4));
         }

         RockstarClient.getInstance().I_method_5cb1af22().I_method_67864747(var7);
      }
   };

   private String I_method_3b94f75f(ItemStack var1) {
      List var2 = iIIIIIiII_Class261.I_method_2d41c106(var1);
      return var2.isEmpty()
         ? "\u0417\u0435\u043b\u044c\u0435"
         : "\u0417\u0435\u043b\u044c\u0435 "
            + ((StatusEffect)((StatusEffectInstance)var2.getFirst()).getEffectType().value()).getName().getString().toLowerCase();
   }
}
