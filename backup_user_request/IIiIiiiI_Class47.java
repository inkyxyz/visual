package rockstar.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ItemPickupAnimationS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.world.GameMode;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.render.HudRenderEvent;
import ua.mintantileak.spk.Compile;

public class IIiIiiiI_Class47 implements iIIiIIiIi_Class294 {
   private PlayerEntity I_field_88955355;
   private final Map<UUID, IIiIiiiI_Class47.Nested1_1b0ad8b3> I_field_a567c40b = new HashMap<>();
   private final IiIIIiII_Class69<HudRenderEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.world != null) {
         for (AbstractClientPlayerEntity var3 : I_field_3a9bda27.world.getPlayers()) {
            this.i_method_53bde841(var3);
         }
      }

      if (this.I_field_88955355 != null) {
         this.I_method_24cc3461(this.I_field_88955355);
         this.I_field_88955355 = null;
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.world != null) {
         if (var1.getPacket() instanceof ItemPickupAnimationS2CPacket var2) {
            if (I_field_3a9bda27.world.getEntityById(var2.getCollectorEntityId()) instanceof PlayerEntity var4) {
               if (I_field_3a9bda27.world.getEntityById(var2.getEntityId()) instanceof ItemEntity var6) {
                  ItemStack var7 = var6.getStack();
                  if (!var7.isEmpty()) {
                     this.I_field_a567c40b.computeIfAbsent(var4.getUuid(), var1x -> new IIiIiiiI_Class47.Nested1_1b0ad8b3(var4)).I_method_8e23ee09(var7);
                  }
               }
            }
         }
      }
   };

   public IIiIiiiI_Class47() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   @Compile
   public IIIiiIIi_Class26 I_method_f8d7e76b() {
      return IIIiiIiI_Class27.I_method_209cd841("invsee")
         .I_method_b3f941e4("\u0438\u043d\u0432\u0441\u0438", "seeinv")
         .i_method_cfe1a061("commands.invsee.description")
         .i_method_3d6e11d9("player", var0 -> var0.I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a))
         .I_method_16f05c8a(this::I_method_d4282b8d)
         .I_method_9111538b();
   }

   @Compile
   private void I_method_d4282b8d(IIIiiIii_Class28 var1) {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         String var2 = (String)var1.I_method_557e5bfb().getFirst();
         if (var2 != null && !var2.trim().isEmpty()) {
            var2 = var2.trim();
            String var3 = var2.toLowerCase(Locale.ROOT);
            AbstractClientPlayerEntity var4 = null;

            for (AbstractClientPlayerEntity var6 : I_field_3a9bda27.world.getPlayers()) {
               String var7 = var6.getName().getString();
               if (var7.equalsIgnoreCase(var2)) {
                  var4 = var6;
                  break;
               }

               if (var4 == null && var7.toLowerCase(Locale.ROOT).startsWith(var3)) {
                  var4 = var6;
               }
            }

            if (var4 != null) {
               this.I_field_88955355 = var4;
            }
         }
      }
   }

   private void I_method_24cc3461(PlayerEntity var1) {
      IIiIiiiI_Class47.Nested1_1b0ad8b3 var2 = this.I_field_a567c40b.get(var1.getUuid());
      if (var2 == null) {
         var2 = new IIiIiiiI_Class47.Nested1_1b0ad8b3(var1);
         var2.I_method_19afd47c(var1);
         this.I_field_a567c40b.put(var1.getUuid(), var2);
      }

      boolean var3 = iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c);
      AbstractClientPlayerEntity var4 = new AbstractClientPlayerEntity(I_field_3a9bda27.world, var1.getGameProfile()) {
         public boolean isSpectator() {
            return false;
         }

         public boolean isCreative() {
            return iIIiIIiIi_Class294.I_field_3a9bda27.interactionManager != null
               && iIIiIIiIi_Class294.I_field_3a9bda27.interactionManager.getCurrentGameMode() == GameMode.CREATIVE;
         }
      };
      List var5 = var2.I_method_fe532480();
      int var6 = var4.getInventory().main.size();

      for (int var7 = 0; var7 < var6; var7++) {
         if (var7 < var5.size()) {
            ItemStack var8 = ((ItemStack)var5.get(var7)).copy();
            if (var3 && var7 == 0) {
               var8.setCount(1);
            }

            var4.getInventory().main.set(var7, var8);
         } else {
            var4.getInventory().main.set(var7, ItemStack.EMPTY);
         }
      }

      for (int var10 = 0; var10 < var4.getInventory().armor.size(); var10++) {
         ItemStack var12 = var2.I_method_8caef23c(var10);
         if (var12.isEmpty()) {
            var4.getInventory().armor.set(var10, ItemStack.EMPTY);
         } else {
            ItemStack var9 = var12.copy();
            if (var3) {
               var9.setCount(1);
            }

            var4.getInventory().armor.set(var10, var9);
         }
      }

      ItemStack var11 = var2.I_method_15622831();
      if (var11.isEmpty()) {
         var4.getInventory().offHand.set(0, ItemStack.EMPTY);
      } else {
         ItemStack var13 = var11.copy();
         if (var3) {
            var13.setCount(1);
         }

         var4.getInventory().offHand.set(0, var13);
      }

      var4.getInventory().selectedSlot = 0;
      I_field_3a9bda27.send(() -> I_field_3a9bda27.setScreen(new IIiIiiiI_Class47.Nested1_1b0ad893(var4)));
   }

   private void i_method_53bde841(PlayerEntity var1) {
      IIiIiiiI_Class47.Nested1_1b0ad8b3 var2 = this.I_field_a567c40b.computeIfAbsent(var1.getUuid(), var1x -> new IIiIiiiI_Class47.Nested1_1b0ad8b3(var1));
      var2.I_method_19afd47c(var1);
   }

   static String I_method_185d80f2(ItemStack var0) {
      return Registries.ITEM.getId(var0.getItem()).toString();
   }

   static final class Nested1_1b0ad893 extends InventoryScreen {
      private final AbstractClientPlayerEntity I_field_3fe81765;
      private float I_field_46;
      private float i_field_46;

      Nested1_1b0ad893(AbstractClientPlayerEntity var1) {
         super(var1);
         this.I_field_3fe81765 = var1;
      }

      public void render(DrawContext context, int mouseX, int mouseY, float delta) {
         this.I_field_46 = mouseX;
         this.i_field_46 = mouseY;
         super.render(context, mouseX, mouseY, delta);
      }

      protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
         context.drawTexture(RenderLayer::getGuiTextured, BACKGROUND_TEXTURE, this.x, this.y, 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, 256, 256);
         InventoryScreen.drawEntity(
            context, this.x + 26, this.y + 8, this.x + 75, this.y + 78, 30, 0.0625F, this.I_field_46, this.i_field_46, this.I_field_3fe81765
         );
      }
   }

   static final class Nested1_1b0ad8b3 {
      private final LinkedHashMap<String, ItemStack> I_field_95707c72 = new LinkedHashMap<>();
      private final ItemStack[] I_field_6132843d;
      private ItemStack I_field_f2735522 = ItemStack.EMPTY;
      private ItemStack i_field_f2735522 = ItemStack.EMPTY;

      Nested1_1b0ad8b3(PlayerEntity var1) {
         this.I_field_6132843d = new ItemStack[var1.getInventory().armor.size()];
         Arrays.fill(this.I_field_6132843d, ItemStack.EMPTY);
      }

      void I_method_19afd47c(PlayerEntity var1) {
         for (int var2 = 0; var2 < var1.getInventory().main.size(); var2++) {
            this.I_method_8e23ee09((ItemStack)var1.getInventory().main.get(var2));
         }

         ItemStack var5 = var1.getMainHandStack();
         if (!var5.isEmpty()) {
            this.I_method_8e23ee09(var5);
            this.i_field_f2735522 = var5.copy();
         }

         for (int var3 = 0; var3 < this.I_field_6132843d.length && var3 < var1.getInventory().armor.size(); var3++) {
            ItemStack var4 = (ItemStack)var1.getInventory().armor.get(var3);
            if (!var4.isEmpty()) {
               this.I_field_6132843d[var3] = var4.copy();
            }
         }

         ItemStack var6 = var1.getOffHandStack();
         if (!var6.isEmpty()) {
            this.I_field_f2735522 = var6.copy();
            this.I_method_8e23ee09(var6);
         }
      }

      void I_method_8e23ee09(ItemStack var1) {
         if (var1 != null && !var1.isEmpty()) {
            String var2 = IIiIiiiI_Class47.I_method_185d80f2(var1);
            ItemStack var3 = this.I_field_95707c72.get(var2);
            if (var3 == null) {
               this.I_field_95707c72.put(var2, var1.copy());
            } else if (var1.getCount() > var3.getCount()) {
               var3.setCount(var1.getCount());
            }
         }
      }

      List<ItemStack> I_method_fe532480() {
         ArrayList var1 = new ArrayList();
         String var2 = this.i_field_f2735522.isEmpty() ? null : IIiIiiiI_Class47.I_method_185d80f2(this.i_field_f2735522);
         if (var2 != null) {
            var1.add(this.i_field_f2735522.copy());
         }

         for (Entry var4 : this.I_field_95707c72.entrySet()) {
            if (!((String)var4.getKey()).equals(var2)) {
               var1.add(((ItemStack)var4.getValue()).copy());
            }
         }

         return var1;
      }

      ItemStack I_method_8caef23c(int var1) {
         return this.I_field_6132843d[var1] == null ? ItemStack.EMPTY : this.I_field_6132843d[var1];
      }

      ItemStack I_method_15622831() {
         return this.I_field_f2735522 == null ? ItemStack.EMPTY : this.I_field_f2735522;
      }
   }
}
