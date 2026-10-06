package rockstar.client;

import globals.shared.proto.Packets;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtSizeTracker;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;

public final class iiIiIii_Class108 {
   public static final int I_field_49 = 46;
   public static final int i_field_49 = -999;
   private static final long I_field_4a = 8388608L;
   private final String I_field_523beb0a;
   private final ItemStack[] I_field_6132843d;
   private final ItemStack I_field_f2735522;

   private iiIiIii_Class108(String var1, ItemStack[] var2, ItemStack var3) {
      this.I_field_523beb0a = var1;
      this.I_field_6132843d = var2;
      this.I_field_f2735522 = var3;
   }

   public String I_method_cb4a25c1() {
      return this.I_field_523beb0a;
   }

   public ItemStack I_method_34ae8a14(int var1) {
      return var1 >= 0 && var1 < this.I_field_6132843d.length ? this.I_field_6132843d[var1] : ItemStack.EMPTY;
   }

   public ItemStack I_method_75a43559() {
      return this.I_field_f2735522;
   }

   public static void I_method_f5c7f419(Packets.Nested1_4eb70229 var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      var1.execute(
         () -> {
            try {
               if (var1.player == null || var1.world == null || var1.interactionManager == null) {
                  return;
               }

               if (!var0.action().isBlank()) {
                  I_method_1c54d412(var1, var0);
               }

               I_method_e0d4cba6(var1);
            } catch (Throwable var3) {
               RockstarClient.I_field_ab0f6068
                  .error("[Admin] invsee: \u0437\u0430\u043f\u0440\u043e\u0441 \u043d\u0435 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d", var3);
            }
         }
      );
   }

   private static void I_method_1c54d412(MinecraftClient var0, Packets.Nested1_4eb70229 var1) {
      SlotActionType var2;
      try {
         var2 = SlotActionType.valueOf(var1.action());
      } catch (IllegalArgumentException var5) {
         return;
      }

      PlayerScreenHandler var3 = var0.player.playerScreenHandler;
      int var4 = var1.slot();
      if (var4 == -999 || var4 >= 0 && var4 < var3.slots.size()) {
         if (var0.player.currentScreenHandler != var3) {
            var0.player.closeHandledScreen();
         }

         var0.interactionManager.clickSlot(var3.syncId, var4, var1.button(), var2, var0.player);
      }
   }

   private static void I_method_e0d4cba6(MinecraftClient var0) throws Exception {
      PlayerScreenHandler var1 = var0.player.playerScreenHandler;
      DynamicRegistryManager var2 = var0.world.getRegistryManager();
      NbtCompound var3 = new NbtCompound();
      var3.putString("nick", var0.player.getGameProfile().getName());
      NbtList var4 = new NbtList();

      for (int var5 = 0; var5 < 46; var5++) {
         ItemStack var6 = var5 < var1.slots.size() ? var1.getSlot(var5).getStack() : ItemStack.EMPTY;
         var4.add(var6.toNbtAllowEmpty(var2));
      }

      var3.put("slots", var4);
      var3.put("cursor", var1.getCursorStack().toNbtAllowEmpty(var2));
      ByteArrayOutputStream var7 = new ByteArrayOutputStream(8192);
      NbtIo.writeCompressed(var3, var7);
      RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_f7ef762e(Base64.getEncoder().encodeToString(var7.toByteArray())));
   }

   public static iiIiIii_Class108 I_method_e8c19054(Packets.Nested1_f7e89650 var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.world != null && var0.data() != null && !var0.data().isBlank()) {
         try {
            byte[] var2 = Base64.getDecoder().decode(var0.data());

            NbtCompound var3;
            try (ByteArrayInputStream var4 = new ByteArrayInputStream(var2)) {
               var3 = NbtIo.readCompressed(var4, NbtSizeTracker.of(8388608L));
            }

            DynamicRegistryManager var12 = var1.world.getRegistryManager();
            NbtList var5 = var3.getList("slots", 10);
            ItemStack[] var6 = new ItemStack[46];

            for (int var7 = 0; var7 < 46; var7++) {
               var6[var7] = var7 < var5.size() ? ItemStack.fromNbtOrEmpty(var12, var5.getCompound(var7)) : ItemStack.EMPTY;
            }

            ItemStack var13 = ItemStack.fromNbtOrEmpty(var12, var3.getCompound("cursor"));
            String var8 = var3.getString("nick");
            if (var8.isBlank()) {
               var8 = var0.nickname();
            }

            return new iiIiIii_Class108(var8, var6, var13);
         } catch (Throwable var11) {
            RockstarClient.I_field_ab0f6068
               .error(
                  "[Admin] invsee: \u0441\u043d\u0438\u043c\u043e\u043a \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044f \u043d\u0435 \u0440\u0430\u0437\u043e\u0431\u0440\u0430\u043d",
                  var11
               );
            return null;
         }
      } else {
         return null;
      }
   }
}
