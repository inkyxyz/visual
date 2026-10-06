package rockstar.client;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.AttackEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.window.KeyPressEvent;
import ua.mintantileak.spk.Compile;

public class IIiIiIii_Class44 implements iIIiIIiIi_Class294 {
   private IiiiiiiIi_Class254 I_field_4471226c;
   private float I_field_46;
   private float i_field_46;
   private final IiIIIiII_Class69<AttackEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_4471226c != null && var1.getEntity() == this.I_field_4471226c && this.I_field_4471226c.hurtTime == 0) {
         I_field_3a9bda27.world
            .playSound(
               I_field_3a9bda27.player,
               this.I_field_4471226c.getX(),
               this.I_field_4471226c.getY(),
               this.I_field_4471226c.getZ(),
               SoundEvents.ENTITY_PLAYER_HURT,
               SoundCategory.PLAYERS,
               1.0F,
               1.0F
            );
         if (I_field_3a9bda27.player.fallDistance > 0.0F) {
            I_field_3a9bda27.world
               .playSound(
                  I_field_3a9bda27.player,
                  this.I_field_4471226c.getX(),
                  this.I_field_4471226c.getY(),
                  this.I_field_4471226c.getZ(),
                  SoundEvents.ENTITY_PLAYER_ATTACK_CRIT,
                  SoundCategory.PLAYERS,
                  1.0F,
                  1.0F
               );
         } else {
            I_field_3a9bda27.world
               .playSound(
                  I_field_3a9bda27.player,
                  this.I_field_4471226c.getX(),
                  this.I_field_4471226c.getY(),
                  this.I_field_4471226c.getZ(),
                  SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP,
                  SoundCategory.PLAYERS,
                  1.0F,
                  1.0F
               );
         }

         this.I_field_4471226c.onDamaged(I_field_3a9bda27.world.getDamageSources().generic());
         this.I_field_4471226c.setHealth(this.I_field_4471226c.getHealth() + this.I_field_4471226c.getAbsorptionAmount() - 1.0F);
         if (this.I_field_4471226c.isDead()) {
            this.I_field_4471226c.setHealth(10.0F);
            new EntityStatusS2CPacket(this.I_field_4471226c, (byte)35).apply(I_field_3a9bda27.player.networkHandler);
         }
      }
   };
   private final IiIIIiII_Class69<KeyPressEvent> i_field_3d936f41 = var1 -> {
      if (this.I_field_4471226c != null && I_field_3a9bda27.currentScreen == null) {
         int var2 = var1.getKey();
         int var3 = var1.getAction();
         float var4 = 2.0F;
         if (var2 == 265) {
            this.I_field_46 = var3 != 1 && var3 != 2 ? 0.0F : var4;
         } else if (var2 == 264) {
            this.I_field_46 = var3 != 1 && var3 != 2 ? 0.0F : -var4;
         } else if (var2 == 263) {
            this.i_field_46 = var3 != 1 && var3 != 2 ? 0.0F : var4;
         } else if (var2 == 262) {
            this.i_field_46 = var3 != 1 && var3 != 2 ? 0.0F : -var4;
         }
      }
   };
   private final IiIIIiII_Class69<ClientPlayerTickEvent> II_field_3d936f41 = var1 -> {
      if (this.I_field_4471226c != null && I_field_3a9bda27.player != null) {
         if (I_field_3a9bda27.currentScreen != null) {
            this.I_field_46 = 0.0F;
            this.i_field_46 = 0.0F;
            this.I_field_4471226c.setSprinting(false);
         } else {
            if (this.I_field_46 == 0.0F && this.i_field_46 == 0.0F) {
               this.I_field_4471226c.setSprinting(false);
               this.I_field_4471226c.setVelocity(0.0, this.I_field_4471226c.getVelocity().y, 0.0);
               this.I_field_4471226c.limbAnimator.setSpeed(0.0F);
            } else {
               float var2 = I_field_3a9bda27.player.getYaw();
               double var3 = 0.2;
               double var5 = this.i_field_46 * Math.cos(Math.toRadians(var2)) - this.I_field_46 * Math.sin(Math.toRadians(var2));
               double var7 = this.I_field_46 * Math.cos(Math.toRadians(var2)) + this.i_field_46 * Math.sin(Math.toRadians(var2));
               Vec3d var9 = new Vec3d(var5 * var3, this.I_field_4471226c.getVelocity().y, var7 * var3);
               this.I_field_4471226c.move(MovementType.SELF, var9);
               this.I_field_4471226c.setSprinting(true);
            }
         }
      }
   };

   public IIIiiIIi_Class26 I_method_daf96f6b() {
      return IIIiiIiI_Class27.I_method_209cd841("fakeplayer")
         .I_method_b3f941e4("fp")
         .i_method_cfe1a061("commands.fakeplayer.description")
         .i_method_3d6e11d9("action", var0 -> {
            var0.I_method_a44fe164("add", "remove", "del");
            var0.I_method_f005ecf3("add", "remove");
         })
         .I_method_16f05c8a(this::I_method_3637a38d)
         .I_method_9111538b();
   }

   @Compile
   private void I_method_3637a38d(IIIiiIii_Class28 var1) {
      String var2 = (String)var1.I_method_557e5bfb().getFirst();
      String var3 = var2.toLowerCase();
      switch (var3) {
         case "add":
            this.I_method_2e2bf90c();
            break;
         case "remove":
         case "del":
            this.i_method_2e3a84ec();
      }
   }

   public void I_method_2e2bf90c() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
      if (this.I_field_4471226c != null) {
         this.I_field_4471226c.discard();
         this.I_field_4471226c = null;
      }

      this.I_field_4471226c = new IiiiiiiIi_Class254(
         I_field_3a9bda27.world, new GameProfile(UUID.fromString("66123666-6666-6666-6666-666666666600"), "FakePlayer")
      );
      this.I_field_4471226c.copyPositionAndRotation(I_field_3a9bda27.player);
      this.I_field_4471226c.setStackInHand(Hand.MAIN_HAND, I_field_3a9bda27.player.getMainHandStack().copy());
      this.I_field_4471226c.setStackInHand(Hand.OFF_HAND, I_field_3a9bda27.player.getOffHandStack().copy());
      this.I_field_4471226c.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 9999, 2));
      this.I_field_4471226c.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 9999, 4));
      this.I_field_4471226c.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 9999, 1));
      I_field_3a9bda27.world.addEntity(this.I_field_4471226c);
      RockstarClient.getInstance()
         .I_method_5cb1af22()
         .I_method_20d0f49b(
            iiiIIII_Class113.I_field_c11fcfcc,
            IiIiIIII_Class81.I_method_f25a980a("commands.fakeplayer.success"),
            IiIiIIII_Class81.I_method_f25a980a("commands.fakeplayer.added")
         );
   }

   public void i_method_2e3a84ec() {
      if (this.I_field_4471226c == null) {
         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_20d0f49b(
               iiiIIII_Class113.i_field_c11fcfcc,
               IiIiIIII_Class81.I_method_f25a980a("commands.fakeplayer.error"),
               IiIiIIII_Class81.I_method_f25a980a("commands.fakeplayer.not_exists")
            );
      } else {
         this.I_field_4471226c.discard();
         this.I_field_4471226c = null;
         RockstarClient.getInstance()
            .I_method_5cb1af22()
            .I_method_20d0f49b(
               iiiIIII_Class113.I_field_c11fcfcc,
               IiIiIIII_Class81.I_method_f25a980a("commands.fakeplayer.success"),
               IiIiIIII_Class81.I_method_f25a980a("commands.fakeplayer.removed")
            );
         RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this);
      }
   }
}
