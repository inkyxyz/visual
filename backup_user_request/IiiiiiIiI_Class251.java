package rockstar.client;

import java.util.List;
import lombok.Generated;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import pyrock.utility.render.ColorRGBA;

public final class IiiiiiIiI_Class251 implements iIIiIIiIi_Class294 {
   private static Vec3d I_field_5bba0d50;
   private static final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();

   public static void I_method_eda61835(boolean var0) {
      iIIiiIiII_Class309 var1 = iIIiiIiIi_Class310.I_method_6a489695();
      iIIiiiIii_Class316 var2 = var0
         ? (iIIiiiIii_Class316)var1.I_method_77fa4424(
            var0x -> ((net.minecraft.item.ItemStack)var0x).getItem() instanceof ArmorItem var1x && ((iIiIiiIIi_Class346)var1x).rockstar$getType() == EquipmentType.CHESTPLATE
         )
         : (iIIiiiIii_Class316)var1.I_method_5d34dd7d(Items.ELYTRA);
      if (var2 != null) {
         iIIiiiIii_Class316 var3 = iIIiIiIiI_Class299.I_method_d0256375();
         I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var2.II_method_b9cf08f5()));
         iIIiIiIiI_Class299.I_method_4c2ca067(var2);
         I_field_3a9bda27.interactionManager.interactItem(I_field_3a9bda27.player, Hand.MAIN_HAND);
         ((Slot)I_field_3a9bda27.player.currentScreenHandler.slots.get(6)).setStack(new ItemStack(var0 ? Items.NETHERITE_CHESTPLATE : Items.ELYTRA));
         iIIiIiIiI_Class299.I_method_4c2ca067(var3);
         I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(I_field_3a9bda27.player.getInventory().selectedSlot));
      }
   }

   public static void I_method_23c9a2f9(MatrixStack var0, BufferBuilder var1, Box var2, ColorRGBA var3) {
      iIiiIIiIi_Class358.Ii_method_c1caf816(var0, var1, var2, var3);
      iIiiIIiIi_Class358.II_method_fde357f6(var0, var1, var2, var3);
   }

   public static void I_method_eda5cd21(float var0) {
      iIIiiIiII_Class309 var1 = iIIiiIiIi_Class310.I_method_6a489695();
      iIIiiiIii_Class316 var2 = (iIIiiiIii_Class316)var1.I_method_5d34dd7d(Items.FIREWORK_ROCKET);
      if (var2 != null) {
         LivingEntity var5 = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
         iiIIiIIii_Class404 var6 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
         I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var2.II_method_b9cf08f5()));
         I_field_3a9bda27.interactionManager
            .sendSequencedPacket(
               I_field_3a9bda27.world, var1x -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, var1x, var6.I_method_14534e0f(), var6.i_method_1461d9ef())
            );
         I_field_3a9bda27.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(I_field_3a9bda27.player.getInventory().selectedSlot));
         I_field_991c1e8c.I_method_23e11e3f();
      } else {
         iIIiiIiII_Class309 var3 = iIIiiIiIi_Class310.i_method_7fde0a75();
         iIIiiiiII_Class317 var4 = (iIIiiiiII_Class317)var3.I_method_5d34dd7d(Items.FIREWORK_ROCKET);
         if (var4 != null) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(var4.I_method_dfe89252(), (int)(var0 - 1.0F));
            I_field_991c1e8c.I_method_23e11e3f();
         }
      }
   }

   public static Vec3d I_method_16ec94b8(LivingEntity var0) {
      return iiIIiIiIi_Class406.I_method_47b889e6(
         var0,
         RockstarClient.getInstance().getModuleManager().getModule(ElytraTargetModule.class).isEnabled() && var0 instanceof PlayerEntity var1
            ? iIIIiIIii_Class276.I_method_77201e0e(var1)
            : var0.getPos()
      );
   }

   public static Vec3d i_method_411e84d8(LivingEntity var0) {
      List var1 = List.of(
         new Vec3d(0.0, 20.0, 0.0),
         new Vec3d(0.0, -20.0, 0.0),
         new Vec3d(20.0, 0.0, 0.0),
         new Vec3d(-20.0, 0.0, 0.0),
         new Vec3d(0.0, 0.0, 20.0),
         new Vec3d(0.0, 0.0, -20.0)
      );
      if (IiiiiIiII_Class245.I_method_cca9db15() != null) {
         var1 = List.of(new Vec3d(0.0, 20.0, 0.0));
      }

      Vec3d var2 = Vec3d.ZERO;

      for (Vec3d var4 : (Iterable<Vec3d>)(Iterable<?>)var1) {
         if (iIIiiiiiI_Class319.I_method_de40276f(var0.getEyePos().add(var4)) && !var4.equals(I_field_5bba0d50)) {
            var2 = var4;
            break;
         }
      }

      return var2;
   }

   public static float[] I_method_c713d7e0(float var0) {
      float var1 = var0 - var0 % 360.0F;
      float var2 = var0 % 360.0F;
      if (var2 < 0.0F) {
         var2 += 360.0F;
         var1 -= 360.0F;
      }

      float var3 = Math.round(var2 / 45.0F) * 45.0F;
      float var4;
      float var5;
      if (var3 % 90.0F == 0.0F) {
         float var6 = (var3 - 45.0F) % 360.0F;
         float var7 = (var3 + 45.0F) % 360.0F;
         var4 = var6 < var2 ? var6 : var6 - 45.0F;
         var5 = var7 > var2 ? var7 : var7 + 45.0F;
      } else if (var3 < var2) {
         var4 = var3;
         var5 = var3 + 90.0F;
      } else {
         var4 = var3 - 90.0F;
         var5 = var3;
      }

      var4 += var1;
      var5 += var1;
      return new float[]{var4, var5};
   }

   @Generated
   private IiiiiiIiI_Class251() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   @Generated
   public static void I_method_6fc3f32b(Vec3d var0) {
      I_field_5bba0d50 = var0;
   }

   @Generated
   public static iiIiIIiii_Class424 I_method_eff3775() {
      return I_field_991c1e8c;
   }
}
