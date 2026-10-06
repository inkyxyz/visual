package rockstar.client;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Auto Throw",
   category = ModuleCategory.COMBAT,
   III_method_a89e5834 = "modules.descriptions.auto_throw"
)
public class AutoThrowModule extends Module {
   private static final int I_field_49 = 8;
   private static final int i_field_49 = 10;
   private static final long I_field_4a = 5000L;
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private KeybindSetting I_field_ba20522c;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private iIIiIiIii_Class300 I_field_1242a2ac;
   private int II_field_49 = -1;
   private int Ii_field_49;
   private int iI_field_49 = -1;
   private boolean I_field_5a;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player != null
         && I_field_3a9bda27.world != null
         && I_field_3a9bda27.interactionManager != null
         && I_field_3a9bda27.getNetworkHandler() != null) {
         if (this.II_field_49 >= 0) {
            this.Iii_method_e05471ac();
         } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627) && this.I_field_991c1e8c.I_method_58432069(5000L)) {
            if (RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c() instanceof PlayerEntity var3 && var3.isAlive()) {
               if (this.I_method_26f17895(var3)) {
                  if (!(IiiiiiiII_Class253.I_method_6c00a1c4(var3) + var3.getAbsorptionAmount() >= this.I_field_73178e8c.Ii_method_a20abcd2())) {
                     if (!(I_field_3a9bda27.player.distanceTo(var3) > this.i_field_73178e8c.Ii_method_a20abcd2())) {
                        if (this.i_method_471060b5(var3)) {
                           this.ii_method_16d2b51f(false);
                        }
                     }
                  }
               }
            }
         }
      }
   };
   private final IiIIIiII_Class69<KeyPressEvent> i_field_3d936f41 = var1 -> {
      if (var1.getAction() == 1 && this.I_field_ba20522c.I_method_51ee2d08(var1.getKey())) {
         this.ii_method_16d2b51f(true);
      }
   };
   private final IiIIIiII_Class69<MouseEvent> II_field_3d936f41 = var1 -> {
      if (var1.getAction() == 1 && this.I_field_ba20522c.I_method_51ee2d08(var1.getButton())) {
         this.ii_method_16d2b51f(true);
      }
   };

   public AutoThrowModule() {
      this.IiI_method_e045e5cc();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_e045e5cc() {
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_throw.mode");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_throw.mode.automatic").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_throw.mode.bind");
      this.I_field_ba20522c = new KeybindSetting(
         this, "modules.settings.auto_throw.key", () -> this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
      );
      this.I_field_73178e8c = new SliderSetting(
            this, "modules.settings.auto_throw.health", () -> this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)
         )
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(20.0F)
         .II_method_b0f56334(0.5F)
         .Ii_method_4e0e6b54(15.0F);
      this.i_field_73178e8c = new SliderSetting(
            this, "modules.settings.auto_throw.distance", () -> this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)
         )
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(6.0F)
         .II_method_b0f56334(0.1F)
         .Ii_method_4e0e6b54(3.0F);
   }

   private void ii_method_16d2b51f(boolean var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.currentScreen == null && this.II_field_49 < 0) {
         if (var1 == this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
            if (this.I_method_9abbfe7e(RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class))) {
               iIIiIiIii_Class300 var2 = this.I_method_feca2762();
               if (var2 == null) {
                  if (var1) {
                     RockstarClient.getInstance()
                        .I_method_5cb1af22()
                        .I_method_20d0f49b(
                           iiiIIII_Class113.i_field_c11fcfcc,
                           IiIiIIII_Class81.I_method_f25a980a("swap.item_not_found"),
                           IiIiIIII_Class81.I_method_1410d1e5("swap.item_required", Items.SPLASH_POTION.getName().getString())
                        );
                  }
               } else {
                  this.I_field_1242a2ac = var2;
                  this.iI_field_49 = I_field_3a9bda27.player.getInventory().selectedSlot;
                  this.I_field_5a = false;
                  this.Ii_field_49 = 0;
                  this.II_field_49 = var2 instanceof iIIiiiIii_Class316 ? 2 : 0;
               }
            }
         }
      }
   }

   private void Iii_method_e05471ac() {
      if (this.I_field_1242a2ac != null && !I_field_3a9bda27.player.isDead() && ++this.Ii_field_49 <= 60) {
         GuiMoveModule var1 = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
         switch (this.II_field_49) {
            case 0:
               iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_1242a2ac.I_method_dfe89252(), 8);
               this.I_field_5a = true;
               this.II_field_49 = 1;
               break;
            case 1:
               if (this.I_method_9abbfe7e(var1)) {
                  this.II_field_49 = 2;
               }
               break;
            case 2:
               int var2 = this.I_field_1242a2ac instanceof iIIiiiIii_Class316 var3 ? var3.II_method_b9cf08f5() : 8;
               if (!I_method_f26298f2(iIIiIiIiI_Class299.I_method_6602651a(var2).I_method_7b7e0bb9())) {
                  this.iII_method_151e098c();
                  return;
               }

               this.II_method_de74714e(var2);
               I_field_3a9bda27.interactionManager.interactItem(I_field_3a9bda27.player, Hand.MAIN_HAND);
               this.I_field_991c1e8c.I_method_23e11e3f();
               this.II_field_49 = 3;
               break;
            case 3:
               if (this.I_method_9abbfe7e(var1)) {
                  this.iII_method_151e098c();
               }
         }
      } else {
         this.iII_method_151e098c();
      }
   }

   private void iII_method_151e098c() {
      if (this.I_field_5a && this.I_field_1242a2ac != null) {
         iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_1242a2ac.I_method_dfe89252(), 8);
      }

      if (this.iI_field_49 >= 0) {
         this.II_method_de74714e(this.iI_field_49);
      }

      this.I_field_1242a2ac = null;
      this.II_field_49 = -1;
      this.Ii_field_49 = 0;
      this.iI_field_49 = -1;
      this.I_field_5a = false;
   }

   private boolean I_method_9abbfe7e(GuiMoveModule var1) {
      if (var1 == null || !var1.isEnabled()) {
         return true;
      } else {
         return var1.Iii_method_d4cea6e3()
            ? !var1.iIi_method_9a6caa3() && !var1.IIiI_method_8e7a1886() && var1.iII_method_9983ec3()
            : var1.I_method_eb75c1e8().isEmpty() && !var1.IIiI_method_8e7a1886();
      }
   }

   private void II_method_de74714e(int var1) {
      if (I_field_3a9bda27.player.getInventory().selectedSlot != var1) {
         I_field_3a9bda27.player.getInventory().selectedSlot = var1;
         I_field_3a9bda27.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(var1));
      }
   }

   private iIIiIiIii_Class300 I_method_feca2762() {
      iIIiIiIii_Class300 var1 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(AutoThrowModule::I_method_f26298f2);
      return (iIIiIiIii_Class300)(var1 != null ? var1 : iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(AutoThrowModule::I_method_f26298f2));
   }

   private boolean I_method_26f17895(LivingEntity var1) {
      if (var1.isUsingItem() && var1.getItemUseTime() >= 10) {
         ItemStack var2 = var1.getActiveItem();
         return !(var2.getItem() instanceof SplashPotionItem) && iIIIIIiII_Class261.I_method_afec1b5a(var2, StatusEffects.INSTANT_HEALTH);
      } else {
         return false;
      }
   }

   private boolean i_method_471060b5(LivingEntity var1) {
      iiIIiIIii_Class404 var2 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
      Vec3d var3 = I_field_3a9bda27.player.getEyePos();
      Vec3d var4 = var3.add(
         iIIiiiiiI_Class319.I_method_dcd241b9(var2.i_method_1461d9ef(), var2.I_method_14534e0f()).multiply(this.i_field_73178e8c.Ii_method_a20abcd2() + 1.0F)
      );
      Box var5 = var1.getBoundingBox().expand(0.15);
      return var5.contains(var3) || var5.raycast(var3, var4).isPresent();
   }

   private static boolean I_method_f26298f2(ItemStack var0) {
      return !var0.isEmpty() && var0.getItem() instanceof SplashPotionItem && iIIIIIiII_Class261.I_method_afec1b5a(var0, StatusEffects.INSTANT_HEALTH);
   }

   @Override
   public void onEnable() {
      this.I_field_991c1e8c.I_method_58432065(0L);
      super.onEnable();
   }

   @Override
   public void onDisable() {
      if (this.II_field_49 >= 0) {
         this.iII_method_151e098c();
      }

      super.onDisable();
   }
}
