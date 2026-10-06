package rockstar.client;

import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.InputEvent;
import pyrock.events.player.TraceEvent;
import pyrock.events.render.Render3DEvent;
import ua.mintantileak.spk.Compile;

public class iiIIiiIiI_Class411 implements iIIiIIiIi_Class294 {
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var0 -> {
      iiIIiIIii_Class404 var1 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858() != null
         ? RockstarClient.getInstance().I_method_58785402().II_method_f098f858()
         : new iiIIiIIii_Class404(0.0F, 0.0F);
      RockstarClient.getInstance().I_method_58785402().I_method_3d166dff();
      if (RockstarClient.getInstance().I_method_58785402().II_method_f098f858() != null) {
         iiIIiIIii_Class404 var2 = var1.I_method_327fa77d(RockstarClient.getInstance().I_method_58785402().II_method_f098f858());
      }
   };
   private final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41 = var1 -> {
      iiIIiIiII_Class405 var2 = RockstarClient.getInstance().I_method_58785402();
      var2.I_method_65b7b9a1(var1.getTickDelta());
      this.I_method_269c4047(var2);
   };
   private final IiIIIiII_Class69<InputEvent> II_field_3d936f41 = var0 -> {
      AuraModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
      iiIIiIiII_Class405 var2 = RockstarClient.I_field_502d1741.I_method_58785402();
      iiIIiiIIi_Class410 var3 = var2.I_method_fcdff2d5();
      LivingEntity var5 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var6 ? var6 : null;
      if (!var2.I_method_3d166e03() && var3 != null) {
         iiIIiIIIi_Class402 var12 = var3.I_method_384472d5();
         iiIIiIIii_Class404 var7 = var2.II_method_f098f858();
         if (var12.II_method_79ffd146()) {
            var0.setYaw(var7.I_method_14534e0f());
         }

         if (var12.Ii_method_7a0e5d26()) {
            var0.setYawSmooth(var7.I_method_14534e0f());
         }

         if (var12 == iiIIiIIIi_Class402.III_field_32e0c64c && var5 != null) {
            SpeedModule var8 = RockstarClient.getInstance().getModuleManager().getModule(SpeedModule.class);
            if (var8.isEnabled() && var8.I_method_d9d4a17d().isSelected()) {
               Vec3d var9 = var5.getPos()
                  .add(var5.getPos().subtract(new Vec3d(var5.prevX, var5.prevY, var5.prevZ)).multiply(var8.I_method_139a0762().Ii_method_a20abcd2()));
               var0.setYaw(var7.I_method_14534e0f(), iiIIiIiIi_Class406.I_method_bc8095a1(var9).I_method_14534e0f());
            } else {
               var0.setYaw(var7.I_method_14534e0f(), iiIIiIiIi_Class406.I_method_bc8095a1(var5.getPos()).I_method_14534e0f());
            }

            if (I_field_3a9bda27.player.isSwimming()) {
               if (var5.getY() > I_field_3a9bda27.player.getY()) {
                  var0.setJump(true);
                  var0.setSneak(false);
               } else {
                  var0.setSneak(true);
                  var0.setJump(false);
               }
            }
         }
      }

      if (!var2.I_method_3d166e03()
         && var3 != null
         && var3.I_method_384472d5() == iiIIiIIIi_Class402.III_field_32e0c64c
         && var1.isEnabled()
         && var5 != null) {
         if (var1.iII_method_3620590() && var1.i_method_5d4dbee2().i_method_9b12da03()) {
            double var13 = Math.toDegrees(Math.atan2(I_field_3a9bda27.player.getZ() - var5.getZ(), I_field_3a9bda27.player.getX() - var5.getX()));
            float var14 = var5.getYaw() + 180.0F;
            float var15 = MathHelper.wrapDegrees((float)(var13 - var14));
            float var10 = MathHelper.clamp(-var15 / 90.0F, -1.0F, 1.0F);
            float var11 = Math.abs(var15) < 15.0F ? 0.6F : 1.0F;
            var0.setForward(var11);
            var0.setStrafe(var10);
         }

         var0.setSprint(true);
      }

      if (var1.I_method_497abf22().i_method_f85f3850() instanceof iiiIIIii_Class228
         && var1.Iii_method_ce986db0()
         && var5 != null
         && !I_field_3a9bda27.player.isOnGround()
         && iIIIiIiiI_Class279.I_method_5a6fa1f8(I_field_3a9bda27.player).I_method_9e608586(IiiiiIiII_Class245.I_method_71f7f60e(var5), 2)
         && var1.I_method_921cfc95(var5)
         && I_field_3a9bda27.player.fallDistance < 0.4F) {
         var0.setForward(0.0F);
         var0.setStrafe(0.0F);
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> Ii_field_3d936f41 = var0 -> {
      if (var0.getPacket() instanceof PlayerPositionLookS2CPacket var2) {
         iiIIiIiII_Class405 var3 = RockstarClient.getInstance().I_method_58785402();
         iiIIiIIii_Class404 var4 = var3.II_method_f098f858();
         float var5 = var2.change().yaw();
         if (var4 != null) {
            var5 = var4.I_method_14534e0f() + MathHelper.wrapDegrees(var5 - var4.I_method_14534e0f());
         }

         var3.i_method_3e2418e7(new iiIIiIIii_Class404(var5, var2.change().pitch()));
      }
   };
   private final IiIIIiII_Class69<TraceEvent> iI_field_3d936f41 = var0 -> {
      iiIIiIiII_Class405 var1 = RockstarClient.I_field_502d1741.I_method_58785402();
      iiIIiiIIi_Class410 var2 = var1.I_method_fcdff2d5();
      if (!var1.I_method_3d166e03() && var2 != null) {
         var0.setYaw(var1.II_method_f098f858().I_method_14534e0f());
         var0.setPitch(var1.II_method_f098f858().i_method_1461d9ef());
         var0.cancel();
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> ii_field_3d936f41 = var0 -> {};

   public iiIIiiIiI_Class411() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   @Compile(
      obfuscation = 1
   )
   private void I_method_269c4047(iiIIiIiII_Class405 var1) {
      if (I_field_3a9bda27.player != null && !var1.I_method_3d166e03()) {
         iiIIiiIIi_Class410 var2 = var1.I_method_fcdff2d5();
         if (var2 != null && var2.I_method_384472d5().iI_method_7bc2c166()) {
            iiIIiIIii_Class404 var3 = var1.ii_method_a3477458();
            iiIIiIiII_Class405.I_method_513fe22f(var3.I_method_14534e0f(), var3.i_method_1461d9ef());
         }
      }
   }
}
