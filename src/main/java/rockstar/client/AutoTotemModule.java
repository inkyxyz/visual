package rockstar.client;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import pyrock.events.player.ClientPlayerTickEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Auto Totem",
   category = ModuleCategory.COMBAT,
   III_method_a89e5834 = "modules.descriptions.auto_totem"
)
public class AutoTotemModule extends Module {
   private static final int I_field_49 = 20;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private BooleanSetting I_field_ba20ca4c;
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private SliderSetting II_field_73178e8c;
   private SliderSetting Ii_field_73178e8c;
   private final iIIiIiiii_Class304 I_field_12512e8c = new iIIiIiiii_Class304(new iIIiIiiiI_Class303(), new iIIiiIIII_Class305());
   private int i_field_49;
   private int II_field_49;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         if (!(I_field_3a9bda27.player.getMaxHealth() <= 2.0F)) {
            this.Iii_method_6f0929ec();
            this.I_field_12512e8c.I_method_83d381eb(false);
            boolean var2 = this.Iii_method_6f0929f0();
            boolean var3 = this.iIi_method_a3e14db0();
            boolean var4 = I_field_3a9bda27.player.getOffHandStack().getItem() == Items.TOTEM_OF_UNDYING;
            boolean var5 = var2 && (!var3 || var4);
            if (!var5 && this.II_field_49 > 0) {
               this.II_field_49--;
            }

            if (var5) {
               this.II_field_49 = 20;
            }

            boolean var6 = var5 || this.II_field_49 > 0;
            if (!var2 || !var3 || var4) {
               if (this.i_field_49 > 0) {
                  this.I_field_12512e8c.I_method_2fdedaee(Items.TOTEM_OF_UNDYING, var6, var0 -> true, this::iII_method_a3d2c1d0);
               } else if (!var2) {
                  this.I_field_12512e8c.I_method_2fdedaee(Items.TOTEM_OF_UNDYING, false, var0 -> true, this::iII_method_a3d2c1d0);
               }
            }
         }
      }
   };

   public AutoTotemModule() {
      this.IiI_method_6efa9e0c();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_6efa9e0c() {
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.auto_totem.health")
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(20.0F)
         .II_method_b0f56334(0.5F)
         .Ii_method_4e0e6b54(6.0F);
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.auto_totem.elytra_health")
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(20.0F)
         .II_method_b0f56334(0.5F)
         .Ii_method_4e0e6b54(6.0F);
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.auto_totem.stop_using");
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.auto_totem.select_with");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_totem.select_with.fall").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_totem.select_with.crystal");
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_totem.select_with.tnt");
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_totem.select_with.trident");
      this.II_field_73178e8c = new SliderSetting(this, "modules.settings.auto_totem.tnt_distance", () -> !this.II_field_51de8227.isSelected())
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(40.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(19.0F);
      this.Ii_field_73178e8c = new SliderSetting(this, "modules.settings.auto_totem.crystal_distance", () -> !this.i_field_51de8227.isSelected())
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(40.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(19.0F);
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.I_field_12512e8c.I_method_b55a1222(new iIIiIiiii_Class304.Nested1_b9c67040() {
         @Override
         public void I_method_13581b86(float var1) {
         }

         @Override
         public void I_method_ae9b035c(ItemStack var1) {
         }
      });
   }

   private boolean iII_method_a3d2c1d0() {
      return this.I_field_ba20ca4c.i_method_9b12da03() || !I_field_3a9bda27.player.isUsingItem();
   }

   public boolean IiI_method_6efa9e10() {
      if (I_field_3a9bda27.player == null || !this.isEnabled()) {
         return false;
      } else {
         return this.Iii_method_6f0929f0()
            ? true
            : this.I_field_12512e8c.I_method_dc0e2e43() && I_field_3a9bda27.player.getOffHandStack().getItem() == Items.TOTEM_OF_UNDYING;
      }
   }

   public boolean Iii_method_6f0929f0() {
      if (I_field_3a9bda27.player == null) {
         return false;
      } else if (this.iiI_method_a595b1f0()) {
         return true;
      } else if (this.i_field_51de8227.isSelected() && this.iii_method_a5a43dd0()) {
         return true;
      } else if (this.II_field_51de8227.isSelected() && this.IIII_method_39cd06f9()) {
         return true;
      } else {
         return this.Ii_field_51de8227.isSelected() && this.IIiI_method_3b8ff719() ? true : this.I_field_51de8227.isSelected() && this.IIIi_method_39db92d9();
      }
   }

   private boolean iIi_method_a3e14db0() {
      if (!iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
         return false;
      } else {
         return I_field_3a9bda27.player != null && I_field_3a9bda27.player.getItemCooldownManager() != null
            ? I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(Items.TOTEM_OF_UNDYING.getDefaultStack())
            : false;
      }
   }

   private boolean iiI_method_a595b1f0() {
      float var1 = I_field_3a9bda27.player.getHealth() + I_field_3a9bda27.player.getAbsorptionAmount();
      float var2 = I_field_3a9bda27.player.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.ELYTRA
         ? this.i_field_73178e8c.Ii_method_a20abcd2()
         : this.I_field_73178e8c.Ii_method_a20abcd2();
      return var1 <= var2;
   }

   private boolean iii_method_a5a43dd0() {
      double var1 = this.Ii_field_73178e8c.Ii_method_a20abcd2();
      return !I_field_3a9bda27.world.getEntitiesByClass(EndCrystalEntity.class, I_field_3a9bda27.player.getBoundingBox().expand(var1), var0 -> true).isEmpty();
   }

   private boolean IIII_method_39cd06f9() {
      double var1 = this.II_field_73178e8c.Ii_method_a20abcd2();
      return !I_field_3a9bda27.world.getEntitiesByClass(TntEntity.class, I_field_3a9bda27.player.getBoundingBox().expand(var1), var0 -> true).isEmpty();
   }

   private boolean IIIi_method_39db92d9() {
      if (!I_field_3a9bda27.player.isOnGround()
         && !I_field_3a9bda27.player.isGliding()
         && !I_field_3a9bda27.player.isTouchingWater()
         && !I_field_3a9bda27.player.isClimbing()
         && !I_field_3a9bda27.player.isInLava()) {
         float var1 = I_field_3a9bda27.player.getHealth() + I_field_3a9bda27.player.getAbsorptionAmount();
         float var2 = iIIIiIiIi_Class278.I_method_67f0481f(I_field_3a9bda27.player, 30);
         return var2 >= var1;
      } else {
         return false;
      }
   }

   private boolean IIiI_method_3b8ff719() {
      return I_field_3a9bda27.world
         .getEntitiesByClass(
            TridentEntity.class, I_field_3a9bda27.player.getBoundingBox().expand(5.0), var0 -> var0.isAlive() && var0.getOwner() != I_field_3a9bda27.player
         )
         .stream()
         .anyMatch(var0 -> var0.getVelocity().lengthSquared() > 0.1);
   }

   private void Iii_method_6f0929ec() {
      this.i_field_49 = iIIiiIiIi_Class310.i_method_7fde0a75()
         .I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695())
         .I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38())
         .I_method_fdeecb5d(iIIiiIiIi_Class310.II_method_66d8858())
         .I_method_fe8cb900(Items.TOTEM_OF_UNDYING)
         .size();
   }

   @Override
   public void onDisable() {
      this.I_field_12512e8c.I_method_b55a1222(null);
      super.onDisable();
      this.I_field_12512e8c.I_method_dc0e2e3f();
      this.II_field_49 = 0;
   }
}
