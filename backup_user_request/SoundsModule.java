package rockstar.client;

import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import pyrock.events.game.EntityDeathEvent;
import pyrock.events.network.ReceivePacketEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Sounds",
   category = ModuleCategory.UTILS,
   iI_method_476ab839 = true,
   III_method_a89e5834 = "modules.descriptions.sounds"
)
public class SoundsModule extends Module {
   private SliderSetting I_field_73178e8c;
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private LivingEntity I_field_966247a3;
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = var1 -> {
      if (var1.getPacket() instanceof GameMessageS2CPacket var2) {
         String var5 = var2.content().getString();
         if (var5.contains("\u0412\u044b \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u043a\u0443\u043f\u0438\u043b\u0438")
            || var5.contains("\u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e \u0438\u0433\u0440\u043e\u043a\u0443")) {
            iiIiIIIII_Class417.II_field_34b2ba6c.I_method_87d2e181(this.I_method_45ee5ef());
         }
      }

      if (var1.getPacket() instanceof EntityStatusS2CPacket var4 && I_field_3a9bda27.world != null) {
         Entity var7 = var4.getEntity(I_field_3a9bda27.world);
         if (var7 != null && var4.getStatus() == 35 && I_field_3a9bda27.player.distanceTo(var7) < 6.0F && this.i_field_51de8227.isSelected()) {
            iiIIiiiIi_Class414.Ii_method_8bca6122();
         }
      }
   };
   private final IiIIIiII_Class69<EntityDeathEvent> i_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player == var1.getEntity() && this.iI_field_51de8227.isSelected()) {
         iiIIiiiIi_Class414.I_method_fc3f61ff();
         this.I_field_966247a3 = null;
      }
   };

   public SoundsModule() {
      this.IiI_method_6bdf3e7f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_6bdf3e7f() {
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.sounds.volume")
         .II_method_b0f56334(5.0F)
         .I_method_c8c9a7d7(10.0F)
         .i_method_65e2aff7(100.0F)
         .Ii_method_4e0e6b54(80.0F)
         .I_method_d41e7abf("%");
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.sounds.voice");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.sounds.voice.kill");
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.sounds.voice.totem");
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.sounds.voice.start");
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.sounds.voice.leave");
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.sounds.voice.death");
   }

   public float I_method_45ee5ef() {
      return this.I_field_73178e8c.Ii_method_a20abcd2() / 100.0F;
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && !I_field_3a9bda27.player.isDead()) {
         if (this.I_field_966247a3 != null) {
            if (I_field_3a9bda27.player.distanceTo(this.I_field_966247a3) > 6.0F) {
               this.I_field_966247a3 = null;
               return;
            }

            if ((!this.I_field_966247a3.isAlive() || !I_field_3a9bda27.world.hasEntity(this.I_field_966247a3)) && this.I_field_51de8227.isSelected()) {
               iiIIiiiIi_Class414.II_method_8bbbd542();
               this.I_field_966247a3 = null;
            }
         }

         LivingEntity var2 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var3 ? var3 : null;
         if (var2 != null) {
            this.I_field_966247a3 = var2;
         }
      } else {
         this.I_field_966247a3 = null;
      }
   }

   @Generated
   public MultiSelectSetting I_method_41426ed5() {
      return this.I_field_bbe3ba6c;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 I_method_fa61c050() {
      return this.I_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 i_method_69bc30() {
      return this.i_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 II_method_4eb9f913() {
      return this.II_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 Ii_method_54c1f4f3() {
      return this.Ii_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 iI_method_9b17933() {
      return this.iI_field_51de8227;
   }

   @Generated
   public LivingEntity I_method_cbde830c() {
      return this.I_field_966247a3;
   }

   @Generated
   public IiIIIiII_Class69<ReceivePacketEvent> I_method_dec809b8() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<EntityDeathEvent> i_method_8c499d8() {
      return this.i_field_3d936f41;
   }
}
