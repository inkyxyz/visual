package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult.Success;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEndEvent;
import pyrock.events.player.EventOnMovePost;
import pyrock.events.player.InputEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Speed",
   category = ModuleCategory.MOVEMENT,
   III_method_a89e5834 = "modules.descriptions.speed"
)
public class SpeedModule extends Module {
   private int I_field_49;
   private final List<SpeedModule.Nested1_92e4a4f3> I_field_7865b31 = new ArrayList<>();
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private ModeSetting.Nested1_42765c60 iI_field_500d0627;
   private ModeSetting.Nested1_42765c60 ii_field_500d0627;
   private ModeSetting.Nested1_42765c60 III_field_500d0627;
   private SliderSetting I_field_73178e8c;
   private SectionSetting I_field_bbd52e8c;
   private SliderSetting i_field_73178e8c;
   private SliderSetting II_field_73178e8c;
   private SliderSetting Ii_field_73178e8c;
   private SliderSetting iI_field_73178e8c;
   private SliderSetting ii_field_73178e8c;
   private SliderSetting III_field_73178e8c;
   private BooleanSetting I_field_ba20ca4c;
   private int i_field_49;
   private int II_field_49;
   private boolean I_field_5a;
   private static final long I_field_4a = 500L;
   private final iiiiiIiI_Class251 I_field_9b38a7c1 = new iiiiiIiI_Class251();
   private final iiiiiiII_Class253 I_field_9b46bb81 = iiiiiiII_Class253.I_method_8ebf53cb();
   private final IiIIIiII_Class69<EventOnMovePost> I_field_3d936f41 = var1 -> {
      if (this.ii_field_500d0627.isSelected() && I_field_3a9bda27.player != null) {
         this.I_method_a676a494(1.7F);
         if (this.i_field_49 > 3) {
            double var2 = 0.03;
            if (this.i_field_49 % 2 == 0) {
               I_field_3a9bda27.player.addVelocity(0.0, 0.03F, 0.0);
               var2 = I_field_3a9bda27.player.isOnGround() ? 0.085 : 0.03;
            }

            Vec3d var4 = this.I_method_92082b26();
            I_field_3a9bda27.player.addVelocity(var4.x * var2, 0.0, var4.z * var2);
         }

         this.i_field_49++;
      }
   };
   private final IiIIIiII_Class69<InputEvent> i_field_3d936f41 = var1 -> {
      if (this.III_field_500d0627.isSelected()) {
         this.I_field_9b38a7c1.I_method_57d50c0c(var1);
      }

      if (this.ii_field_500d0627.isSelected()) {
         if (I_field_3a9bda27.player == null) {
            return;
         }

         if (I_field_3a9bda27.player.verticalCollision) {
            this.II_field_49++;
         } else {
            this.II_field_49 = 0;
         }

         if (this.II_field_49 >= 1) {
            I_field_3a9bda27.player.jump();
         }
      }

      if (this.Ii_field_500d0627.isSelected()) {
         LivingEntity var3 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var4 ? var4 : null;
         if (var3 == null) {
            return;
         }

         AuraModule var9 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
         Vec3d var5 = var3.getPos()
            .add(var3.getPos().subtract(new Vec3d(var3.prevX, var3.prevY, var3.prevZ)).multiply(this.III_field_73178e8c.Ii_method_a20abcd2()));
         if ((
               IiiiiiiII_Class253.I_method_211f8586(var3, this.ii_field_73178e8c.Ii_method_a20abcd2())
                  || IiiiiiiII_Class253.I_method_6e525578(var3, IiiiiiIii_Class252.I_method_34ed4d41(var3), this.ii_field_73178e8c.Ii_method_a20abcd2())
            )
            && I_field_3a9bda27.options.forwardKey.isPressed()
            && I_field_3a9bda27.player.hurtTime <= 0
            && RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class).I_method_eb75c1e8().isEmpty()) {
            iiIIiIiII_Class405 var6 = RockstarClient.getInstance().I_method_58785402();
            float var7 = iiIIiIiIi_Class406.II_method_95f3d8d2(var6.II_method_f098f858().I_method_14534e0f(), var6.iI_method_8db20078().I_method_14534e0f());
            Vec3d var8 = I_field_3a9bda27.player.getPos();
            if (I_field_3a9bda27.world
                  .raycast(new RaycastContext(I_field_3a9bda27.player.getPos(), var5, ShapeType.COLLIDER, FluidHandling.NONE, I_field_3a9bda27.player))
                  .getType()
               != Type.MISS) {
               return;
            }

            I_field_3a9bda27.options.sprintKey.setPressed(false);
            var1.setSprint(false);
            I_field_3a9bda27.player.setSprinting(false);
         }
      }
   };
   private final IiIIIiII_Class69<ClientPlayerTickEndEvent> II_field_3d936f41 = var1 -> {
      if (this.ii_field_500d0627.isSelected() && I_field_3a9bda27.player != null && I_field_3a9bda27.player.networkHandler != null) {
         if (this.i_field_49 % 2 == 0) {
            this.I_method_a676a494(0.3F);
            I_field_3a9bda27.player.networkHandler.sendPacket(new ClientCommandC2SPacket(I_field_3a9bda27.player, Mode.START_FALL_FLYING));
         }
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> Ii_field_3d936f41 = var1 -> {
      if (this.ii_field_500d0627.isSelected()) {
         if (var1.getPacket() instanceof PlayerPositionLookS2CPacket) {
            if (this.i_field_49 % 2 == 1) {
               this.i_field_49++;
            }

            this.I_method_a676a494(1.0F);
         }
      }
   };

   public SpeedModule() {
      this.IiI_method_2bf339ec();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_2bf339ec() {
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.speed.mode");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.speed.vanilla");
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.speed.spooky_elytra");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.speed.collision");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.speed.collision_target");
      this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.speed.ice");
      this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "ReallyWorld");
      this.III_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "HolyWorld");
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.speed.distance", () -> !this.II_field_500d0627.isSelected())
         .I_method_c8c9a7d7(0.05F)
         .i_method_65e2aff7(2.0F)
         .II_method_b0f56334(0.05F)
         .Ii_method_4e0e6b54(0.3F);
      this.I_field_bbd52e8c = new SectionSetting(this, "modules.settings.speed.speed_info", () -> !this.II_field_500d0627.isSelected());
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.speed.on_ground", () -> !this.II_field_500d0627.isSelected())
         .I_method_c8c9a7d7(0.5F)
         .i_method_65e2aff7(3.0F)
         .II_method_b0f56334(0.05F)
         .Ii_method_4e0e6b54(1.1F);
      this.II_field_73178e8c = new SliderSetting(this, "modules.settings.speed.on_jump", () -> !this.II_field_500d0627.isSelected())
         .I_method_c8c9a7d7(0.5F)
         .i_method_65e2aff7(3.0F)
         .II_method_b0f56334(0.05F)
         .Ii_method_4e0e6b54(1.1F);
      this.Ii_field_73178e8c = new SliderSetting(this, "modules.settings.speed.on_fall", () -> !this.II_field_500d0627.isSelected())
         .I_method_c8c9a7d7(0.5F)
         .i_method_65e2aff7(3.0F)
         .II_method_b0f56334(0.05F)
         .Ii_method_4e0e6b54(1.1F);
      this.iI_field_73178e8c = new SliderSetting(this, "modules.settings.speed.power", () -> !this.Ii_field_500d0627.isSelected())
         .I_method_c8c9a7d7(0.01F)
         .i_method_65e2aff7(0.1F)
         .II_method_b0f56334(0.01F)
         .Ii_method_4e0e6b54(0.06F);
      this.ii_field_73178e8c = new SliderSetting(this, "modules.settings.speed.boost_range", () -> !this.Ii_field_500d0627.isSelected())
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(2.0F)
         .II_method_b0f56334(0.1F)
         .Ii_method_4e0e6b54(1.0F);
      this.III_field_73178e8c = new SliderSetting(this, "\u041f\u0440\u0435\u0434\u0438\u043a\u0442", () -> !this.Ii_field_500d0627.isSelected())
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(10.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(5.0F);
      this.I_field_ba20ca4c = new BooleanSetting(
            this, "\u0421\u0432\u0430\u043f \u044d\u043b\u0438\u0442\u0440\u044b", () -> !this.III_field_500d0627.isSelected()
         )
         .I_method_decd82b5();
   }

   @Override
   public void II_method_6642fd22() {
      if (this.I_field_5a && !this.ii_field_500d0627.isSelected()) {
         this.Iii_method_2c01c5cc();
      }

      if (this.III_field_500d0627.isSelected()) {
         this.iII_method_60cb5dac();
      } else if (this.I_field_ba20ca4c.i_method_9b12da03()
         && I_field_3a9bda27.player != null
         && iIIiIiIiI_Class299.i_method_e5bad375().I_method_158af795() == Items.ELYTRA) {
         this.I_field_9b46bb81.i_method_a6c144ac();
      }

      if (this.iI_field_500d0627.isSelected() && iIIiIiIiI_Class299.I_method_d0256375().I_method_158af795() == Items.ICE) {
         RockstarClient.getInstance()
            .I_method_58785402()
            .I_method_1acbf705(
               new iiIIiIIii_Class404(I_field_3a9bda27.player.getYaw(), 90.0F),
               iiIIiIIIi_Class402.i_field_32e0c64c,
               180.0F,
               180.0F,
               180.0F,
               iiIIiIiiI_Class407.ii_field_32efc66c
            );
         BlockHitResult var1 = (BlockHitResult)iIIiiiiiI_Class319.I_method_3191983(10.0, I_field_3a9bda27.player.getYaw(), 90.0F, I_field_3a9bda27.player);
         ActionResult var2 = I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var1);
         if (var2 instanceof Success) {
            I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
         }
      }

      if (this.II_field_500d0627.isSelected()) {
         for (Entity var23 : I_field_3a9bda27.world.getEntities()) {
            if (var23 instanceof LivingEntity var3
               && var3.isAlive()
               && !var3.isSpectator()
               && var3 != I_field_3a9bda27.player
               && IiiiiiiII_Class253.I_method_211f8586(var3, this.I_field_73178e8c.Ii_method_a20abcd2())) {
               float var4 = I_field_3a9bda27.world
                  .getBlockState(
                     I_field_3a9bda27.player
                        .getBlockPos()
                        .add(
                           (int)I_field_3a9bda27.player.getVelocity().x,
                           (int)I_field_3a9bda27.player.getVelocity().y,
                           (int)I_field_3a9bda27.player.getVelocity().z
                        )
                  )
                  .getBlock()
                  .getSlipperiness();
               if (I_field_3a9bda27.player.isOnGround()) {
                  float var10000 = var4 * 0.91F;
               } else {
                  float var41 = 0.51F;
               }

               float var6 = I_field_3a9bda27.player.isOnGround() ? var4 : 0.57F;
               float var7 = I_field_3a9bda27.player.isOnGround()
                  ? this.i_field_73178e8c.Ii_method_a20abcd2()
                  : (I_field_3a9bda27.player.fallDistance > 0.0F ? this.Ii_field_73178e8c.Ii_method_a20abcd2() : this.II_field_73178e8c.Ii_method_a20abcd2());
               I_field_3a9bda27.player
                  .setVelocity(
                     I_field_3a9bda27.player.getVelocity().x * var7, I_field_3a9bda27.player.getVelocity().y, I_field_3a9bda27.player.getVelocity().z * var7
                  );
               break;
            }
         }
      }

      if (this.I_field_500d0627.isSelected()) {
         BlockPos var20 = I_field_3a9bda27.player.getBlockPos().add(0, -1, 0);
         I_field_3a9bda27.options.sneakKey.setPressed(false);
         RockstarClient.getInstance().I_method_58785402().I_method_a10b10c7(new iiIIiIIii_Class404(I_field_3a9bda27.player.getYaw(), 90.0F));
         if (I_field_3a9bda27.player.isOnGround() && !I_field_3a9bda27.options.jumpKey.isPressed()) {
            I_field_3a9bda27.player.jump();
            Vec3d var24 = I_field_3a9bda27.player.getVelocity();
            I_field_3a9bda27.player.setVelocity(var24.x, var24.y - 0.085F, var24.z);
            BlockPos var27 = I_field_3a9bda27.player.getBlockPos().add(0, 1, 0);
            BlockPos var31 = I_field_3a9bda27.player.getBlockPos();
            BlockPos var5 = I_field_3a9bda27.player.getBlockPos().add(0, -1, 0);
            BlockPos var34 = I_field_3a9bda27.player.getBlockPos().add(0, -2, 0);
            I_field_3a9bda27.world.setBlockState(var5, Blocks.BLUE_ICE.getDefaultState());
            Vec3d var36 = new Vec3d(var31.getX(), var31.getY(), var31.getZ());
            new BlockHitResult(var36, Direction.UP, var31, false);
            Vec3d var9 = new Vec3d(var5.getX(), var5.getY(), var5.getZ());
            BlockHitResult var10 = new BlockHitResult(var9, Direction.UP, var5, false);
            Vec3d var11 = new Vec3d(var34.getX(), var34.getY(), var34.getZ());
            new BlockHitResult(var11, Direction.UP, var34, false);
            I_field_3a9bda27.player.networkHandler.sendPacket(new PlayerInteractBlockC2SPacket(Hand.OFF_HAND, var10, 0));
         }
      } else if (this.i_field_500d0627.isSelected()) {
         iIIiiIiII_Class309 var21 = iIIiiIiIi_Class310.I_method_6a489695();
         iIIiiiIii_Class316 var25 = (iIIiiiIii_Class316)var21.I_method_5d34dd7d(Items.ELYTRA);
         if (var25 != null && I_field_3a9bda27.player.fallDistance > 1.0F) {
            iIIiiiIii_Class316 var28 = iIIiIiIiI_Class299.I_method_d0256375();
            I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var25.II_method_b9cf08f5()));
            iIIiIiIiI_Class299.I_method_4c2ca067(var25);
            I_field_3a9bda27.interactionManager.interactItem(I_field_3a9bda27.player, Hand.MAIN_HAND);
            ((Slot)I_field_3a9bda27.player.currentScreenHandler.slots.get(6)).setStack(new ItemStack(Items.ELYTRA));
            if (I_field_3a9bda27.player.isSprinting() && I_field_3a9bda27.player.input.hasForwardMovement() && I_field_3a9bda27.player.checkGliding()) {
               I_field_3a9bda27.player.networkHandler.sendPacket(new ClientCommandC2SPacket(I_field_3a9bda27.player, Mode.START_FALL_FLYING));
            }

            iIIiIiIiI_Class299.I_method_4c2ca067(var28);
            I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(I_field_3a9bda27.player.getInventory().selectedSlot));
         }
      } else if (this.Ii_field_500d0627.isSelected()) {
         LivingEntity var26 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var29 ? var29 : null;
         if (var26 == null) {
            return;
         }

         AuraModule var30 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
         Vec3d var32 = var26.getPos()
            .add(var26.getPos().subtract(new Vec3d(var26.prevX, var26.prevY, var26.prevZ)).multiply(this.III_field_73178e8c.Ii_method_a20abcd2()));
         if ((
               IiiiiiiII_Class253.I_method_211f8586(var26, this.ii_field_73178e8c.Ii_method_a20abcd2())
                  || IiiiiiiII_Class253.I_method_6e525578(var26, IiiiiiIii_Class252.I_method_34ed4d41(var26), this.ii_field_73178e8c.Ii_method_a20abcd2())
            )
            && I_field_3a9bda27.options.forwardKey.isPressed()
            && I_field_3a9bda27.player.hurtTime <= 0
            && RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class).I_method_eb75c1e8().isEmpty()) {
            iiIIiIiII_Class405 var33 = RockstarClient.getInstance().I_method_58785402();
            float var35 = iiIIiIiIi_Class406.II_method_95f3d8d2(var33.II_method_f098f858().I_method_14534e0f(), var33.iI_method_8db20078().I_method_14534e0f());
            Vec3d var37 = I_field_3a9bda27.player.getPos();
            if (I_field_3a9bda27.world
                  .raycast(new RaycastContext(I_field_3a9bda27.player.getPos(), var32, ShapeType.COLLIDER, FluidHandling.NONE, I_field_3a9bda27.player))
                  .getType()
               != Type.MISS) {
               return;
            }

            Vec3d var8 = var32.subtract(var37).normalize();
            float var38 = I_field_3a9bda27.world
               .getBlockState(
                  BlockPos.ofFloored(
                     I_field_3a9bda27.player
                        .getPos()
                        .add(I_field_3a9bda27.player.getVelocity().x, I_field_3a9bda27.player.getVelocity().y, I_field_3a9bda27.player.getVelocity().z)
                  )
               )
               .getBlock()
               .getSlipperiness();
            float var39 = I_field_3a9bda27.player.isOnGround() ? var38 : 0.79F;
            float var40 = I_field_3a9bda27.player.isOnGround() ? var38 : 0.99F;
            double var12 = I_field_3a9bda27.player.getVelocity().y;
            float var14 = this.iI_field_73178e8c.Ii_method_a20abcd2() * 3.0F;
            double var15 = var8.x * var14 * var40 / var39;
            double var17 = var8.z * var14 * var40 / var39;
            I_field_3a9bda27.player.setVelocity(I_field_3a9bda27.player.getVelocity().x + var15, var12, I_field_3a9bda27.player.getVelocity().z + var17);
         }
      }
   }

   private Vec3d I_method_92082b26() {
      if (I_field_3a9bda27.player.input == null) {
         return Vec3d.ZERO;
      } else {
         float var1 = I_field_3a9bda27.player.input.movementForward;
         float var2 = I_field_3a9bda27.player.input.movementSideways;
         if (var1 == 0.0F && var2 == 0.0F) {
            return Vec3d.ZERO;
         } else {
            double var3 = IiiiiiiII_Class253.I_method_2edb44cf(I_field_3a9bda27.player.getYaw(), var1, var2);
            return new Vec3d(-Math.sin(var3), 0.0, Math.cos(var3));
         }
      }
   }

   private void I_method_a676a494(float var1) {
      IiiiiiiII_Class253.I_method_7a0e1161(var1);
      this.I_field_5a = true;
   }

   private void Iii_method_2c01c5cc() {
      this.i_field_49 = 0;
      this.II_field_49 = 0;
      this.I_field_5a = false;
      IiiiiiiII_Class253.I_method_1cb61e3f();
   }

   private void iII_method_60cb5dac() {
      if (I_field_3a9bda27.player != null) {
         boolean var1 = !RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class).I_method_eb75c1e8().isEmpty();
         if (!this.I_field_9b46bb81.I_method_a6b2b8d0() && !var1 && this.I_field_9b46bb81.I_method_2fa4d77c(500L)) {
            this.I_field_9b38a7c1.I_method_4754850c();
         } else {
            this.I_field_9b38a7c1.i_method_476310ec();
         }
      }
   }

   public static boolean I_method_dbdeabf9(ClientPlayerEntity var0) {
      SpeedModule var1 = RockstarClient.getInstance().getModuleManager().getModule(SpeedModule.class);
      return var1 != null && var1.isEnabled() && var1.III_field_500d0627.isSelected() && var1.I_field_9b38a7c1.I_method_edcacb99(var0);
   }

   public static boolean IiI_method_2bf339f0() {
      SpeedModule var0 = RockstarClient.getInstance().getModuleManager().getModule(SpeedModule.class);
      return var0 != null && var0.isEnabled() && var0.III_field_500d0627.isSelected();
   }

   public static boolean Iii_method_2c01c5d0() {
      SpeedModule var0 = RockstarClient.getInstance().getModuleManager().getModule(SpeedModule.class);
      return var0 != null && var0.isEnabled() && var0.III_field_500d0627.isSelected();
   }

   private void iIi_method_60d9e98c() {
      this.I_field_9b38a7c1.II_method_a34b13d5();
   }

   @Override
   public void onEnable() {
      this.iIi_method_60d9e98c();
      if (this.III_field_500d0627.isSelected() && this.I_field_ba20ca4c.i_method_9b12da03()) {
         this.I_field_9b46bb81.I_method_a6b2b8cc();
      }

      super.onEnable();
   }

   @Override
   public void onDisable() {
      this.Iii_method_2c01c5cc();
      this.iIi_method_60d9e98c();
      if (this.III_field_500d0627.isSelected() && this.I_field_ba20ca4c.i_method_9b12da03()) {
         this.I_field_9b46bb81.i_method_a6c144ac();
      }

      super.onDisable();
   }

   @Generated
   public ModeSetting.Nested1_42765c60 I_method_d9d4a17d() {
      return this.Ii_field_500d0627;
   }

   @Generated
   public SliderSetting I_method_139a0762() {
      return this.III_field_73178e8c;
   }

   static class Nested1_92e4a4f3 {
      private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
      private final Vec3d I_field_5bba0d50;

      @Generated
      public Nested1_92e4a4f3(Vec3d var1) {
         this.I_field_5bba0d50 = var1;
      }
   }
}
