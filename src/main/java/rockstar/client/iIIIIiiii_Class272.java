package rockstar.client;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.EquipmentSlot.Type;
import net.minecraft.entity.decoration.DisplayEntity.TextDisplayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.text.MutableText;
import net.minecraft.text.PlainTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public final class iIIIIiiii_Class272 implements iIIiIIiIi_Class294 {
   public static Text I_method_cf2d0707(Text var0, String var1) {
      return var0 instanceof MutableText var2 ? I_method_8fe1678d(var2.copy(), var1) : I_method_8fe1678d(var0.copy(), var1);
   }

   private static MutableText I_method_8fe1678d(MutableText var0, String var1) {
      if (var0 instanceof PlainTextContent var2) {
         String var3 = var2.string();
         if (var3.contains(var1)) {
            String var11 = var3.replace(var1, "");
            MutableText var14 = Text.literal(var11);
            var14.setStyle(var0.getStyle());

            for (Text var17 : var0.getSiblings()) {
               var14.append(I_method_cf2d0707(var17, var1));
            }

            return var14;
         }
      }

      MutableText var8 = Text.empty().setStyle(var0.getStyle());
      var8.append(var0.copy());
      ArrayList var9 = new ArrayList();

      for (Text var5 : var0.getSiblings()) {
         Text var6 = I_method_cf2d0707(var5, var1);
         if (!var6.getString().isEmpty()) {
            var9.add(var6);
         }
      }

      MutableText var10 = Text.empty().setStyle(var0.getStyle());
      String var12 = I_method_a20d6979(var0);
      if (!var12.isEmpty()) {
         var12 = var12.replace(var1, "");
         if (!var12.isEmpty()) {
            var10.append(Text.literal(var12).setStyle(var0.getStyle()));
         }
      }

      for (Text var7 : (Iterable<Text>)(Iterable<?>)var9) {
         var10.append(var7);
      }

      return var10;
   }

   private static String I_method_a20d6979(Text var0) {
      return var0 instanceof PlainTextContent var1 ? var1.string() : "";
   }

   public static void I_method_3f77d61f() {
      for (Entity var1 : I_field_3a9bda27.world.getPlayers()) {
         if (var1 instanceof PlayerEntity var2) {
            i_method_1be03594(var2);
         }
      }
   }

   private static void I_method_ecee81b4(PlayerEntity var0) {
      for (EquipmentSlot var4 : EquipmentSlot.values()) {
         if (var4.getType() == Type.HUMANOID_ARMOR || var4 == EquipmentSlot.MAINHAND || var4 == EquipmentSlot.OFFHAND) {
            ItemStack var5 = var0.getEquippedStack(var4);
            if (!var5.isEmpty()) {
               var0.getInventory().insertStack(var5.copy());
               var0.equipStack(var4, ItemStack.EMPTY);
            }
         }
      }
   }

   private static void i_method_1be03594(PlayerEntity var0) {
      for (EquipmentSlot var4 : EquipmentSlot.values()) {
         if (var4.getType() == Type.HUMANOID_ARMOR) {
            ItemStack var5 = var0.getEquippedStack(var4);
            if (!var5.isEmpty()) {
               var0.getInventory().insertStack(var5.copy());
               var0.equipStack(var4, ItemStack.EMPTY);
            }
         }
      }
   }

   public static boolean I_method_c7d5562d(String var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      ClientPlayNetworkHandler var2 = var1.getNetworkHandler();
      if (var2 == null) {
         return false;
      } else {
         for (PlayerListEntry var4 : var2.getPlayerList()) {
            if (var4.getProfile().getName().equals(var0)) {
               return true;
            }
         }

         return false;
      }
   }

   public static String I_method_3589597(String var0) {
      try {
         ResourceManager var1 = I_field_3a9bda27.getResourceManager();
         Identifier var2 = Identifier.of("minecraft", "models/item/" + var0.replace("minecraft:", "") + ".json");
         Optional var3 = var1.getResource(var2);
         if (var3.isPresent()) {
            String var5;
            try (BufferedReader var4 = ((Resource)var3.get()).getReader()) {
               var5 = var4.lines().collect(Collectors.joining("\n"));
            }

            return var5;
         } else {
            return null;
         }
      } catch (Exception var9) {
         System.err
            .println(
               "\u041e\u0448\u0438\u0431\u043a\u0430 \u043f\u0440\u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0438 \u0441\u0435\u0440\u0432\u0435\u0440\u043d\u043e\u0439 \u043c\u043e\u0434\u0435\u043b\u0438: "
                  + var9.getMessage()
            );
         return null;
      }
   }

   public static String I_method_aaee63d1(ItemStack var0, WrapperLookup var1) {
      if (var0.toNbtAllowEmpty(var1) instanceof NbtCompound var3 && var3.contains("components", 10)) {
         NbtCompound var4 = var3.getCompound("components");
         if (var4.contains("minecraft:item_model", 8)) {
            return var4.getString("minecraft:item_model");
         }
      }

      return null;
   }

   public static boolean I_method_807ce706(Entity var0, ClientWorld var1, double var2) {
      for (Entity var5 : var1.getEntities()) {
         if (var5 instanceof TextDisplayEntity var6 && var6.getText() != null && !var6.getText().getString().isEmpty() && var0.distanceTo(var6) < var2) {
            return true;
         }
      }

      return false;
   }

   public static iiIIiIIii_Class404 I_method_3a568961(Vec3d var0) {
      Vec3d var1 = I_field_3a9bda27.player.getEyePos();
      double var2 = var0.x - var1.x;
      double var4 = var0.y - var1.y;
      double var6 = var0.z - var1.z;
      double var8 = Math.sqrt(var2 * var2 + var6 * var6);
      float var10 = (float)(Math.toDegrees(Math.atan2(var6, var2)) - 90.0);
      float var11 = (float)(-Math.toDegrees(Math.atan2(var4, var8)));
      return new iiIIiIIii_Class404(var10, var11);
   }

   @Generated
   private iIIIIiiii_Class272() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
