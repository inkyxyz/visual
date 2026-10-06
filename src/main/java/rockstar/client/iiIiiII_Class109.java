package rockstar.client;

import globals.shared.proto.Packets;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class iiIiiII_Class109 extends Screen {
   private static final int I_field_49 = 176;
   private static final int i_field_49 = 166;
   private static final int II_field_49 = 18;
   private static final int Ii_field_49 = 10;
   private static final int iI_field_49 = 200;
   private final String I_field_523beb0a;
   private final String i_field_523beb0a;
   private final String II_field_523beb0a;
   private final String Ii_field_523beb0a;
   private String iI_field_523beb0a;
   private iiIiIii_Class108 I_field_8c48280c;
   private int ii_field_49;

   private iiIiiII_Class109(String var1, String var2, String var3, String var4) {
      super(Text.literal("invsee"));
      this.I_field_523beb0a = var1;
      this.i_field_523beb0a = var2;
      this.II_field_523beb0a = var3;
      this.Ii_field_523beb0a = var4;
   }

   public static void I_method_66200dc7(String var0, String var1, String var2, String var3) {
      MinecraftClient var4 = MinecraftClient.getInstance();
      var4.send(() -> var4.setScreen(new iiIiiII_Class109(var0, var1, var2, var3)));
   }

   public static void I_method_4f2a187e(Packets.Nested1_f7e89650 var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      var1.execute(() -> {
         if (var1.currentScreen instanceof iiIiiII_Class109 var2) {
            if (var0.from().equalsIgnoreCase(var2.I_field_523beb0a) || var0.nickname().equalsIgnoreCase(var2.I_field_523beb0a)) {
               if (var2.iI_field_523beb0a == null) {
                  var2.iI_field_523beb0a = var0.from();
               } else if (!var2.iI_field_523beb0a.equals(var0.from())) {
                  return;
               }

               iiIiIii_Class108 var4 = iiIiIii_Class108.I_method_e8c19054(var0);
               if (var4 != null) {
                  var2.I_field_8c48280c = var4;
               }
            }
         }
      });
   }

   public void init() {
      this.I_method_2ef9d149(0, 0, "");
   }

   public void tick() {
      this.ii_field_49++;
      if (this.ii_field_49 % 10 == 0) {
         this.I_method_2ef9d149(0, 0, "");
      }
   }

   public boolean shouldPause() {
      return false;
   }

   public void render(DrawContext context, int mouseX, int mouseY, float delta) {
      super.render(context, mouseX, mouseY, delta);
      int var5 = (this.width - 176) / 2;
      int var6 = (this.height - 166) / 2;
      context.drawTexture(RenderLayer::getGuiTextured, HandledScreen.BACKGROUND_TEXTURE, var5, var6, 0.0F, 0.0F, 176, 166, 256, 256);
      String var7 = this.I_field_8c48280c != null ? this.I_field_8c48280c.I_method_cb4a25c1() : this.I_field_523beb0a;
      String var8 = this.iI_field_523beb0a != null && !this.iI_field_523beb0a.equalsIgnoreCase(var7) ? var7 + " (" + this.iI_field_523beb0a + ")" : var7;
      context.drawCenteredTextWithShadow(this.textRenderer, Text.literal(var8), this.width / 2, var6 - 12, -1);
      this.I_method_52d12347(context, var5, var6, mouseX, mouseY);
      if (this.I_field_8c48280c == null) {
         MutableText var13 = Text.literal(
               IiIiIIII_Class81.I_method_f25a980a(this.ii_field_49 > 200 ? "commands.admin.invsee.timeout" : "commands.admin.invsee.waiting")
            )
            .formatted(this.ii_field_49 > 200 ? Formatting.RED : Formatting.GRAY);
         context.drawCenteredTextWithShadow(this.textRenderer, var13, this.width / 2, var6 + 166 + 6, -1);
      } else {
         for (int var9 = 0; var9 < 46; var9++) {
            int var10 = I_method_e151e237(var9);
            if (var10 != Integer.MIN_VALUE) {
               this.I_method_58442349(context, this.I_field_8c48280c.I_method_34ae8a14(var9), var5 + var10, var6 + i_method_e314d257(var9));
            }
         }

         int var12 = this.I_method_48ead932(mouseX - var5, mouseY - var6);
         if (var12 >= 0) {
            context.fill(
               var5 + I_method_e151e237(var12),
               var6 + i_method_e314d257(var12),
               var5 + I_method_e151e237(var12) + 16,
               var6 + i_method_e314d257(var12) + 16,
               -2130706433
            );
         }

         ItemStack var14 = this.I_field_8c48280c.I_method_75a43559();
         if (!var14.isEmpty()) {
            context.drawItem(var14, mouseX - 8, mouseY - 8);
            context.drawStackOverlay(this.textRenderer, var14, mouseX - 8, mouseY - 8);
         } else if (var12 >= 0) {
            ItemStack var11 = this.I_field_8c48280c.I_method_34ae8a14(var12);
            if (!var11.isEmpty()) {
               context.drawItemTooltip(this.textRenderer, var11, mouseX, mouseY);
            }
         }
      }
   }

   private void I_method_52d12347(DrawContext var1, int var2, int var3, int var4, int var5) {
      if (this.client != null && this.client.world != null) {
         String var6 = this.I_field_8c48280c != null ? this.I_field_8c48280c.I_method_cb4a25c1() : this.I_field_523beb0a;

         for (AbstractClientPlayerEntity var8 : this.client.world.getPlayers()) {
            if (var8.getName().getString().equalsIgnoreCase(var6)) {
               InventoryScreen.drawEntity(var1, var2 + 26, var3 + 8, var2 + 75, var3 + 78, 30, 0.0625F, var4, var5, var8);
               return;
            }
         }
      }
   }

   private void I_method_58442349(DrawContext var1, ItemStack var2, int var3, int var4) {
      if (!var2.isEmpty()) {
         var1.drawItem(var2, var3, var4);
         var1.drawStackOverlay(this.textRenderer, var2, var3, var4);
      }
   }

   public boolean mouseClicked(double mouseX, double mouseY, int button) {
      if (this.I_field_8c48280c != null && (button == 0 || button == 1)) {
         int var6 = (this.width - 176) / 2;
         int var7 = (this.height - 166) / 2;
         int var8 = this.I_method_48ead932((int)mouseX - var6, (int)mouseY - var7);
         if (var8 < 0) {
            if (!this.I_field_8c48280c.I_method_75a43559().isEmpty()) {
               this.I_method_2ef9d149(-999, button, SlotActionType.PICKUP.name());
            }

            return true;
         } else {
            this.I_method_2ef9d149(var8, button, hasShiftDown() ? SlotActionType.QUICK_MOVE.name() : SlotActionType.PICKUP.name());
            return true;
         }
      } else {
         return super.mouseClicked(mouseX, mouseY, button);
      }
   }

   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
      if (this.client == null) {
         return super.keyPressed(keyCode, scanCode, modifiers);
      } else if (keyCode != 256 && !this.client.options.inventoryKey.matchesKey(keyCode, scanCode)) {
         if (this.I_field_8c48280c == null) {
            return super.keyPressed(keyCode, scanCode, modifiers);
         } else {
            int var4 = (int)(this.client.mouse.getX() * this.client.getWindow().getScaledWidth() / this.client.getWindow().getWidth());
            int var5 = (int)(this.client.mouse.getY() * this.client.getWindow().getScaledHeight() / this.client.getWindow().getHeight());
            int var6 = this.I_method_48ead932(var4 - (this.width - 176) / 2, var5 - (this.height - 166) / 2);
            if (var6 < 0) {
               return super.keyPressed(keyCode, scanCode, modifiers);
            } else if (this.client.options.dropKey.matchesKey(keyCode, scanCode)) {
               this.I_method_2ef9d149(var6, hasControlDown() ? 1 : 0, SlotActionType.THROW.name());
               return true;
            } else {
               for (int var7 = 0; var7 < this.client.options.hotbarKeys.length; var7++) {
                  if (this.client.options.hotbarKeys[var7].matchesKey(keyCode, scanCode)) {
                     this.I_method_2ef9d149(var6, var7, SlotActionType.SWAP.name());
                     return true;
                  }
               }

               return super.keyPressed(keyCode, scanCode, modifiers);
            }
         }
      } else {
         this.close();
         return true;
      }
   }

   private void I_method_2ef9d149(int var1, int var2, String var3) {
      RockstarClient.getInstance()
         .I_method_cd3d46d0()
         .send(new Packets.Nested1_42226586(this.I_field_523beb0a, this.i_field_523beb0a, this.II_field_523beb0a, this.Ii_field_523beb0a, var1, var2, var3));
   }

   private int I_method_48ead932(int var1, int var2) {
      for (int var3 = 0; var3 < 46; var3++) {
         int var4 = I_method_e151e237(var3);
         if (var4 != Integer.MIN_VALUE) {
            int var5 = i_method_e314d257(var3);
            if (var1 >= var4 && var1 < var4 + 16 && var2 >= var5 && var2 < var5 + 16) {
               return var3;
            }
         }
      }

      return -1;
   }

   private static int I_method_e151e237(int var0) {
      if (var0 == 0) {
         return 154;
      } else if (var0 <= 4) {
         return 98 + (var0 - 1) % 2 * 18;
      } else if (var0 <= 8) {
         return 8;
      } else if (var0 <= 35) {
         return 8 + (var0 - 9) % 9 * 18;
      } else if (var0 <= 44) {
         return 8 + (var0 - 36) * 18;
      } else {
         return var0 == 45 ? 77 : Integer.MIN_VALUE;
      }
   }

   private static int i_method_e314d257(int var0) {
      if (var0 == 0) {
         return 28;
      } else if (var0 <= 4) {
         return 18 + (var0 - 1) / 2 * 18;
      } else if (var0 <= 8) {
         return 8 + (var0 - 5) * 18;
      } else if (var0 <= 35) {
         return 84 + (var0 - 9) / 9 * 18;
      } else if (var0 <= 44) {
         return 142;
      } else {
         return var0 == 45 ? 62 : Integer.MIN_VALUE;
      }
   }
}
