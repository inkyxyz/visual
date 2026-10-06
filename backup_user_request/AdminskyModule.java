package rockstar.client;

import java.util.Locale;
import java.util.regex.Pattern;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import pyrock.events.game.WorldChangeEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Adminsky",
   category = ModuleCategory.OTHER,
   staffOnly = true,
   III_method_a89e5834 = "modules.descriptions.adminsky"
)
public class AdminskyModule extends Module {
   private static final String I_field_523beb0a = "shard.ac";
   private static final String i_field_523beb0a = "test bots";
   private static final String II_field_523beb0a = "sloth monitor";
   private static final Pattern I_field_5fd3861f = Pattern.compile(
      "\u0438\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u0435\\s*:\\s*\u0432\u043a\u043b\u044e\u0447\u0435\u043d\u043e"
   );
   private static final Pattern i_field_5fd3861f = Pattern.compile("\u0432\u0435\u0440\u043d\u0443\u0442\u044c\\s+\u0432\\s+\u0438\u0433\u0440\u0443");
   private static final double I_field_44 = 5.0;
   private static final long I_field_4a = 2000L;
   private static final long i_field_4a = 5000L;
   private static final long II_field_4a = 600L;
   private static final int I_field_49 = 3;
   private static final int i_field_49 = 20;
   private BooleanSetting I_field_ba20ca4c;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private AdminskyModule.Nested1_c98ebcd3 I_field_e6570dfc;
   private RegistryKey<World> I_field_b0c3452b;
   private Vec3d I_field_5bba0d50;
   private int II_field_49;
   private int Ii_field_49;
   private final IiIIIiII_Class69<WorldChangeEvent> I_field_3d936f41;

   public AdminskyModule() {
      this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.I_field_e6570dfc;
      this.I_field_5bba0d50 = Vec3d.ZERO;
      this.I_field_3d936f41 = var1 -> {
         if (this.I_field_e6570dfc == AdminskyModule.Nested1_c98ebcd3.II_field_e6570dfc) {
            this.iiI_method_83d821ec();
         } else {
            this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.I_field_e6570dfc;
         }
      };
      this.IiI_method_4d3d0e0c();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_4d3d0e0c() {
      this.I_field_ba20ca4c = new BooleanSetting(this, this.I_method_b5cfb3aa("auto_sloth"));
   }

   @Override
   public void II_method_6642fd22() {
      if (!this.I_field_ba20ca4c.i_method_9b12da03()) {
         this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.I_field_e6570dfc;
      } else if (I_field_3a9bda27.player != null
         && I_field_3a9bda27.world != null
         && I_field_3a9bda27.interactionManager != null
         && iIIIiiiII_Class285.I_method_dbbac60d("shard.ac")) {
         switch (this.I_field_e6570dfc) {
            case I_field_e6570dfc:
               this.Iii_method_4d4b99ec();
               break;
            case i_field_e6570dfc:
               this.iII_method_821531cc();
               break;
            case II_field_e6570dfc:
               this.iIi_method_8223bdac();
               break;
            case Ii_field_e6570dfc:
               this.iii_method_83e6adcc();
               break;
            case iI_field_e6570dfc:
               this.IIII_method_23d896f5();
               break;
            case ii_field_e6570dfc:
               this.IIIi_method_23e722d5();
               break;
            case III_field_e6570dfc:
               this.IIiI_method_259b8715();
            case IIi_field_e6570dfc:
         }
      }
   }

   private void Iii_method_4d4b99ec() {
      this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.i_field_e6570dfc;
      this.II_field_49 = 0;
      this.Ii_field_49 = 0;
      this.I_field_991c1e8c.I_method_23e11e3f();
   }

   private void iII_method_821531cc() {
      if (this.I_field_991c1e8c.I_method_58432069(2000L)) {
         Entity var1 = this.I_method_f5b30902();
         if (var1 != null) {
            if (I_field_3a9bda27.targetedEntity != var1 && this.Ii_field_49++ < 20) {
               this.i_method_9ff428da(var1);
            } else {
               this.I_field_b0c3452b = I_field_3a9bda27.world.getRegistryKey();
               this.I_field_5bba0d50 = I_field_3a9bda27.player.getPos();
               this.I_method_e4fca8ba(var1);
               RockstarClient.I_field_ab0f6068
                  .info(
                     "[Adminsky] \u043a\u043b\u0438\u043a \u043f\u043e NPC {} \u0432 {} \u0431\u043b\u043e\u043a\u0430\u0445",
                     var1.getName().getString(),
                     I_field_3a9bda27.player.distanceTo(var1)
                  );
               this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.II_field_e6570dfc;
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void I_method_e4fca8ba(Entity var1) {
      EntityHitResult var2 = new EntityHitResult(var1, var1.getBoundingBox().getCenter());
      if (!I_field_3a9bda27.interactionManager.interactEntityAtLocation(I_field_3a9bda27.player, var1, var2, Hand.MAIN_HAND).isAccepted()) {
         I_field_3a9bda27.interactionManager.interactEntity(I_field_3a9bda27.player, var1, Hand.MAIN_HAND);
      }
   }

   private void i_method_9ff428da(Entity var1) {
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      Vec3d var3 = var1.getBoundingBox().getCenter();
      double var4 = var3.x - var2.x;
      double var6 = var3.y - var2.y;
      double var8 = var3.z - var2.z;
      I_field_3a9bda27.player.setYaw((float)(Math.toDegrees(Math.atan2(var8, var4)) - 90.0));
      I_field_3a9bda27.player.setPitch((float)(-Math.toDegrees(Math.atan2(var6, Math.sqrt(var4 * var4 + var8 * var8)))));
   }

   private void iIi_method_8223bdac() {
      if (I_field_3a9bda27.world.getRegistryKey().equals(this.I_field_b0c3452b)
         && !(I_field_3a9bda27.player.getPos().squaredDistanceTo(this.I_field_5bba0d50) > 4096.0)) {
         if (this.I_field_991c1e8c.I_method_58432069(5000L)) {
            this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.i_field_e6570dfc;
            this.Ii_field_49 = 0;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      } else {
         this.iiI_method_83d821ec();
      }
   }

   private void iiI_method_83d821ec() {
      this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.Ii_field_e6570dfc;
      this.II_field_49 = 0;
      this.I_field_991c1e8c.I_method_23e11e3f();
   }

   private void iii_method_83e6adcc() {
      if (this.I_field_991c1e8c.I_method_58432069(2000L)) {
         if (this.II_field_49++ >= 3) {
            this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.IIi_field_e6570dfc;
         } else {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("test bots");
            RockstarClient.I_field_ab0f6068.info("[Adminsky] \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e /{}", "test bots");
            this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.iI_field_e6570dfc;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void IIII_method_23d896f5() {
      ScreenHandler var1 = this.I_method_4437738a();
      if (var1 == null) {
         if (this.I_field_991c1e8c.I_method_58432069(5000L)) {
            this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.Ii_field_e6570dfc;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      } else {
         int var2 = this.I_method_34e4dcff(var1);
         if (var2 < 0) {
            if (this.I_field_991c1e8c.I_method_58432069(5000L)) {
               this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.IIi_field_e6570dfc;
            }
         } else {
            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
            RockstarClient.I_field_ab0f6068
               .info("[Adminsky] \u0432\u044b\u0431\u0440\u0430\u043d \u0431\u043e\u0442 \u0432 \u0441\u043b\u043e\u0442\u0435 {}", var2);
            this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.ii_field_e6570dfc;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   private void IIIi_method_23e722d5() {
      ScreenHandler var1 = this.I_method_4437738a();
      int var2 = var1 == null ? -1 : this.i_method_18a2f8df(var1);
      if (var2 < 0) {
         if (this.I_field_991c1e8c.I_method_58432069(5000L)) {
            this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.III_field_e6570dfc;
            this.I_field_991c1e8c.I_method_23e11e3f();
         }
      } else {
         I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
         RockstarClient.I_field_ab0f6068
            .info(
               "[Adminsky] \u043a\u043d\u043e\u043f\u043a\u0430 \u00ab\u0412\u0435\u0440\u043d\u0443\u0442\u044c \u0432 \u0438\u0433\u0440\u0443\u00bb \u0432 \u0441\u043b\u043e\u0442\u0435 {}",
               var2
            );
         this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.III_field_e6570dfc;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void IIiI_method_259b8715() {
      if (this.I_field_991c1e8c.I_method_58432069(600L)) {
         I_field_3a9bda27.player.networkHandler.sendChatCommand("sloth monitor");
         RockstarClient.I_field_ab0f6068.info("[Adminsky] \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e /{}", "sloth monitor");
         this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.IIi_field_e6570dfc;
      }
   }

   private Entity I_method_f5b30902() {
      Entity var1 = I_field_3a9bda27.targetedEntity;
      if (var1 != null && var1 != I_field_3a9bda27.player && !this.I_method_e4fca8be(var1)) {
         return var1;
      } else {
         PlayerEntity var2 = this.I_method_95cd7c63(true);
         return var2 != null ? var2 : this.I_method_95cd7c63(false);
      }
   }

   private PlayerEntity I_method_95cd7c63(boolean var1) {
      AbstractClientPlayerEntity var2 = null;
      double var3 = 25.0;

      for (AbstractClientPlayerEntity var6 : I_field_3a9bda27.world.getPlayers()) {
         if (var6 != I_field_3a9bda27.player && (!var1 || !this.I_method_e4fca8be(var6))) {
            double var7 = I_field_3a9bda27.player.squaredDistanceTo(var6);
            if (!(var7 >= var3)) {
               var2 = var6;
               var3 = var7;
            }
         }
      }

      return var2;
   }

   private boolean I_method_e4fca8be(Entity var1) {
      return var1 instanceof PlayerEntity
         && var1.getUuid().version() != 2
         && I_field_3a9bda27.getNetworkHandler() != null
         && I_field_3a9bda27.getNetworkHandler().getPlayerListEntry(var1.getUuid()) != null;
   }

   private ScreenHandler I_method_4437738a() {
      if (!(I_field_3a9bda27.currentScreen instanceof HandledScreen)) {
         return null;
      } else {
         ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
         return !(var1 instanceof PlayerScreenHandler) && var1.slots.size() > 36 ? var1 : null;
      }
   }

   private int I_method_34e4dcff(ScreenHandler var1) {
      int var2 = -1;

      for (int var3 = 0; var3 < var1.slots.size() - 36; var3++) {
         ItemStack var4 = var1.getSlot(var3).getStack();
         if (var4.isOf(Items.PLAYER_HEAD)) {
            if (var2 < 0) {
               var2 = var3;
            }

            if (I_field_5fd3861f.matcher(this.I_method_4967d532(var4)).find()) {
               return var3;
            }
         }
      }

      return var2;
   }

   private int i_method_18a2f8df(ScreenHandler var1) {
      int var2 = -1;

      for (int var3 = 0; var3 < var1.slots.size() - 36; var3++) {
         ItemStack var4 = var1.getSlot(var3).getStack();
         if (!var4.isEmpty()) {
            if (i_field_5fd3861f.matcher(this.I_method_4967d532(var4)).find()) {
               return var3;
            }

            if (var2 < 0 && var4.isOf(Items.ORANGE_DYE)) {
               var2 = var3;
            }
         }
      }

      return var2;
   }

   private String I_method_4967d532(ItemStack var1) {
      StringBuilder var2 = new StringBuilder(var1.getName().getString());

      try {
         for (Text var4 : var1.getTooltip(TooltipContext.create(I_field_3a9bda27.world), I_field_3a9bda27.player, TooltipType.BASIC)) {
            var2.append(' ').append(var4.getString());
         }
      } catch (Exception var5) {
      }

      return var2.toString().replaceAll("\u00a7.", "").replace('\u0451', '\u0435').toLowerCase(Locale.ROOT);
   }

   @Override
   public void onEnable() {
      this.I_field_e6570dfc = AdminskyModule.Nested1_c98ebcd3.I_field_e6570dfc;
      this.II_field_49 = 0;
      this.I_field_991c1e8c.I_method_23e11e3f();
   }

   static enum Nested1_c98ebcd3 {
      I_field_e6570dfc,
      i_field_e6570dfc,
      II_field_e6570dfc,
      Ii_field_e6570dfc,
      iI_field_e6570dfc,
      ii_field_e6570dfc,
      III_field_e6570dfc,
      IIi_field_e6570dfc;
   }
}
