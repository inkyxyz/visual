package rockstar.client;

import lombok.Generated;
import moscow.rockstar.mixin.accessors.EntityVelocityUpdateAccessor;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ExplosionS2CPacket;
import net.minecraft.util.math.Vec3d;
import pyrock.events.network.ReceivePacketEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Velocity",
   category = ModuleCategory.COMBAT,
   III_method_a89e5834 = "modules.descriptions.velocity"
)
public class VelocityModule extends Module {
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private SliderSetting II_field_73178e8c;
   private SliderSetting Ii_field_73178e8c;
   private final VelocityModule.Nested1_cd6920f3 I_field_5dc92ddc = new VelocityModule.Nested1_cd6920f3();
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null && !I_field_3a9bda27.player.isDead()) {
         Packet var2 = var1.getPacket();
         boolean var3 = var2 instanceof EntityVelocityUpdateS2CPacket var4 && var4.getEntityId() == I_field_3a9bda27.player.getId();
         boolean var11 = var2 instanceof ExplosionS2CPacket;
         if (this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627)) {
            if (var2 instanceof EntityVelocityUpdateS2CPacket var13 && var13.getEntityId() == I_field_3a9bda27.player.getId()) {
               this.I_field_5dc92ddc.i_method_acf5355c(this.I_field_5dc92ddc.i_method_68ad0e7a() + 1);
               int var15 = Math.max(1, (int)this.Ii_field_73178e8c.Ii_method_a20abcd2());
               if (this.I_field_5dc92ddc.i_method_68ad0e7a() > var15) {
                  var1.cancel();
                  this.I_field_5dc92ddc.i_method_acf5355c(0);
               }
            }
         } else {
            if (var3 || var11) {
               if (this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
                  && var2 instanceof EntityVelocityUpdateS2CPacket var5
                  && var5.getEntityId() == I_field_3a9bda27.player.getId()) {
                  var1.cancel();
               } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)
                  && var2 instanceof EntityVelocityUpdateS2CPacket var6
                  && var6.getEntityId() == I_field_3a9bda27.player.getId()) {
                  int var7 = (int)(var6.getVelocityX() * 8000.0 * this.I_field_73178e8c.Ii_method_a20abcd2() / 100.0);
                  int var8 = (int)(var6.getVelocityY() * 8000.0 * this.i_field_73178e8c.Ii_method_a20abcd2() / 100.0);
                  int var9 = (int)(var6.getVelocityZ() * 8000.0 * this.II_field_73178e8c.Ii_method_a20abcd2() / 100.0);
                  EntityVelocityUpdateAccessor var10 = (EntityVelocityUpdateAccessor)(Object)var6;
                  var10.setVelocityX(var7);
                  var10.setVelocityY(var8);
                  var10.setVelocityZ(var9);
               }
            }

            if (this.i_field_500d0627.isSelected()
               && var1.getPacket() instanceof EntityVelocityUpdateS2CPacket var12
               && var12.getEntityId() == I_field_3a9bda27.player.getId()) {
               this.I_field_5dc92ddc.I_field_5bba0d50 = new Vec3d(var12.getVelocityX() / 8000.0, var12.getVelocityY() / 8000.0, var12.getVelocityZ() / 8000.0);
               this.I_field_5dc92ddc.I_field_49 = 4 + I_field_3a9bda27.player.getRandom().nextInt(4);
            }
         }
      }
   };

   public VelocityModule() {
      this.IiI_method_7cdc3dec();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_7cdc3dec() {
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.velocity.mode");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.velocity.default");
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.velocity.compensation");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "Grim");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.velocity.modify");
      this.I_field_73178e8c = new SliderSetting(
            this, "modules.settings.velocity.velocity_x", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)
         )
         .I_method_d41e7abf("%")
         .Ii_method_4e0e6b54(50.0F)
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(100.0F)
         .II_method_b0f56334(1.0F);
      this.i_field_73178e8c = new SliderSetting(
            this, "modules.settings.velocity.velocity_y", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)
         )
         .I_method_d41e7abf("%")
         .Ii_method_4e0e6b54(50.0F)
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(100.0F)
         .II_method_b0f56334(1.0F);
      this.II_field_73178e8c = new SliderSetting(
            this, "modules.settings.velocity.velocity_z", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)
         )
         .I_method_d41e7abf("%")
         .Ii_method_4e0e6b54(50.0F)
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(100.0F)
         .II_method_b0f56334(1.0F);
      this.Ii_field_73178e8c = new SliderSetting(
            this, "modules.settings.velocity.grim_hits_before_cancel", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627)
         )
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(10.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(3.0F);
   }

   @Override
   public final void II_method_6642fd22() {
      if (I_field_3a9bda27.player == null || I_field_3a9bda27.player.isDead()) {
         this.I_field_5dc92ddc.I_method_689e82a7();
      } else if (this.i_field_500d0627.isSelected() && this.I_field_5dc92ddc.I_field_49 > 0) {
         Vec3d var1 = I_field_3a9bda27.player.getVelocity();
         double var2 = this.I_field_5dc92ddc.I_field_49 / 6.0;
         double var4 = 0.3 + (1.0 - var2) * 0.35;
         var4 += I_field_3a9bda27.player.getRandom().nextDouble() * 0.05;
         Vec3d var6 = new Vec3d(-this.I_field_5dc92ddc.I_field_5bba0d50.x * var4, 0.0, -this.I_field_5dc92ddc.I_field_5bba0d50.z * var4);
         Vec3d var7 = var1.add(var6);
         I_field_3a9bda27.player.setVelocity(var7);
         this.I_field_5dc92ddc.I_field_49--;
         super.II_method_6642fd22();
      }
   }

   @Override
   public void onDisable() {
      this.I_field_5dc92ddc.I_method_689e82a7();
   }

   static class Nested1_cd6920f3 {
      Vec3d I_field_5bba0d50 = Vec3d.ZERO;
      int I_field_49;
      private int i_field_49;

      void I_method_689e82a7() {
         this.I_field_5bba0d50 = Vec3d.ZERO;
         this.I_field_49 = 0;
         this.i_field_49 = 0;
      }

      @Generated
      public Vec3d I_method_2f306be1() {
         return this.I_field_5bba0d50;
      }

      @Generated
      public int I_method_689e829a() {
         return this.I_field_49;
      }

      @Generated
      public int i_method_68ad0e7a() {
         return this.i_field_49;
      }

      @Generated
      public void I_method_c9345603(Vec3d var1) {
         this.I_field_5bba0d50 = var1;
      }

      @Generated
      public void I_method_ab32453c(int var1) {
         this.I_field_49 = var1;
      }

      @Generated
      public void i_method_acf5355c(int var1) {
         this.i_field_49 = var1;
      }
   }
}
