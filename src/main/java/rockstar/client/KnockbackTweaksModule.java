package rockstar.client;

import net.minecraft.entity.Entity;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.LookAndOnGround;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.InternalAttackEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Knockback Tweaks",
   category = ModuleCategory.COMBAT,
   III_method_a89e5834 = "modules.descriptions.knockback_tweaks"
)
public class KnockbackTweaksModule extends Module {
   BooleanSetting I_field_ba20ca4c;
   private boolean I_field_5a;
   boolean i_field_5a;
   private Entity I_field_77e0818c;
   private int I_field_49;
   boolean II_field_5a;
   private final IiIIIiII_Class69<InternalAttackEvent> I_field_3d936f41 = new IiIIIiII_Class69<InternalAttackEvent>() {
      public void onEvent(InternalAttackEvent var1) {
         if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null && iIIiIIiIi_Class294.I_field_3a9bda27.world != null && var1.getEntity() != null) {
            if (!var1.isCancelled()) {
               if (KnockbackTweaksModule.this.I_field_ba20ca4c.i_method_9b12da03()) {
                  if (iIIiIIiIi_Class294.I_field_3a9bda27.player.isSprinting()) {
                     iIIiIIiIi_Class294.I_field_3a9bda27
                        .player
                        .networkHandler
                        .sendPacket(new ClientCommandC2SPacket(iIIiIIiIi_Class294.I_field_3a9bda27.player, Mode.STOP_SPRINTING));
                  }

                  iIIiIIiIi_Class294.I_field_3a9bda27
                     .player
                     .networkHandler
                     .sendPacket(new ClientCommandC2SPacket(iIIiIIiIi_Class294.I_field_3a9bda27.player, Mode.START_SPRINTING));
                  if (iIIiIIiIi_Class294.I_field_3a9bda27.player.isSprinting()) {
                     KnockbackTweaksModule.this.i_field_5a = true;
                  }
               } else {
                  boolean var2 = iIIiIIiIi_Class294.I_field_3a9bda27.player.isSprinting();
                  KnockbackTweaksModule.this.Iii_method_f45ce9ac();
                  if (!KnockbackTweaksModule.this.II_field_5a && !var2 && KnockbackTweaksModule.this.IiI_method_f44e5dd0()) {
                     KnockbackTweaksModule.this.i_method_344f011a(var1.getEntity());
                     var1.cancel();
                     return;
                  }

                  if (!iIIiIIiIi_Class294.I_field_3a9bda27.player.isSprinting()) {
                     return;
                  }
               }

               KnockbackTweaksModule.this.I_method_795780fa(var1.getEntity());
            }
         }
      }

      @Override
      public int I_method_f12c6485() {
         return -100;
      }
   };

   public KnockbackTweaksModule() {
      this.IiI_method_f44e5dcc();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_f44e5dcc() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.knockback_tweaks.fake_sprint");
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         if (!this.I_field_ba20ca4c.i_method_9b12da03()) {
            this.Iii_method_f45ce9ac();
            this.iII_method_2926818c();
         }

         if (this.I_field_5a) {
            this.I_field_5a = false;
            iiIIiIIii_Class404 var1 = this.I_method_3f893b22();
            I_field_3a9bda27.player
               .networkHandler
               .sendPacket(
                  new LookAndOnGround(
                     var1.I_method_14534e0f(), var1.i_method_1461d9ef(), I_field_3a9bda27.player.isOnGround(), I_field_3a9bda27.player.horizontalCollision
                  )
               );
         }

         if (this.i_field_5a) {
            this.i_field_5a = false;
            I_field_3a9bda27.player.networkHandler.sendPacket(new ClientCommandC2SPacket(I_field_3a9bda27.player, Mode.START_SPRINTING));
         }
      }
   }

   @Override
   public void onDisable() {
      this.I_field_5a = false;
      this.i_field_5a = false;
      this.I_field_77e0818c = null;
      this.I_field_49 = 0;
      this.II_field_5a = false;
   }

   void I_method_795780fa(Entity var1) {
      iiIIiIIii_Class404 var2 = this.I_method_5dc77a10(var1);
      I_field_3a9bda27.player
         .networkHandler
         .sendPacket(
            new LookAndOnGround(
               var2.I_method_14534e0f(), var2.i_method_1461d9ef(), I_field_3a9bda27.player.isOnGround(), I_field_3a9bda27.player.horizontalCollision
            )
         );
      this.I_field_5a = true;
   }

   private iiIIiIIii_Class404 I_method_5dc77a10(Entity var1) {
      Vec3d var2 = var1.getPos().subtract(I_field_3a9bda27.player.getPos());
      float var3 = MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(var2.z, var2.x)) + 90.0F);
      return new iiIIiIIii_Class404(var3, this.I_method_3f893b22().i_method_1461d9ef());
   }

   private iiIIiIIii_Class404 I_method_3f893b22() {
      iiIIiIiII_Class405 var1 = RockstarClient.getInstance().I_method_58785402();
      return var1.I_method_3d166e03() ? var1.I_method_fb1d7ad5() : var1.II_method_f098f858();
   }

   void Iii_method_f45ce9ac() {
      I_field_3a9bda27.options.sprintKey.setPressed(true);
      if (!I_field_3a9bda27.player.isSprinting() && this.IiI_method_f44e5dd0()) {
         I_field_3a9bda27.player.setSprinting(true);
      }
   }

   void i_method_344f011a(Entity var1) {
      this.I_field_77e0818c = var1;
      this.I_field_49 = 1;
   }

   private void iII_method_2926818c() {
      if (this.I_field_77e0818c != null && I_field_3a9bda27.interactionManager != null) {
         if (this.I_field_77e0818c.isRemoved() || !this.IiI_method_f44e5dd0()) {
            this.I_field_77e0818c = null;
            this.I_field_49 = 0;
         } else if (this.I_field_49 > 0) {
            this.I_field_49--;
         } else {
            Entity var1 = this.I_field_77e0818c;
            this.I_field_77e0818c = null;
            this.II_field_5a = true;

            try {
               I_field_3a9bda27.interactionManager.attackEntity(I_field_3a9bda27.player, var1);
               I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
            } finally {
               this.II_field_5a = false;
            }
         }
      }
   }

   boolean IiI_method_f44e5dd0() {
      return I_field_3a9bda27.player.input.hasForwardMovement()
         && !I_field_3a9bda27.player.horizontalCollision
         && !I_field_3a9bda27.player.isSneaking()
         && !I_field_3a9bda27.player.isTouchingWater()
         && !I_field_3a9bda27.player.isSubmergedInWater()
         && (I_field_3a9bda27.player.getHungerManager().getFoodLevel() > 6 || I_field_3a9bda27.player.getAbilities().allowFlying);
   }
}
