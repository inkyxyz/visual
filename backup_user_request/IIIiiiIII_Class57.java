package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;

public class IIIiiiIII_Class57 extends IIIiiiIii_Class60 {
   private final TextSetting I_field_731802cc;
   private final TextSetting i_field_731802cc;
   private final SliderSetting I_field_73178e8c;
   private final ButtonSetting I_field_bbd4b28c;
   private static final int I_field_49 = 8;
   private static final long I_field_4a = 350L;
   private static final long i_field_4a = 5000L;
   private static final float I_field_46 = 1.5F;
   private static final String I_field_523beb0a = "\u0423 \u0412\u0430\u0441 \u043a\u0443\u043f\u0438\u043b\u0438";
   private static final String i_field_523beb0a = "\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435";
   private static final int i_field_49 = 4;
   private IiIIiiIii_Class156 I_field_ab760aac;
   private IIIiiiIII_Class57.Nested1_b8258c40 I_field_9043d247;
   private Item I_field_3c05b08c;
   ItemStack I_field_f2735522;
   private boolean I_field_5a;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private final iiIiIIiii_Class424 II_field_991c1e8c;
   private boolean i_field_5a;
   private final Deque<BlockPos> I_field_db650847;
   private final Set<BlockPos> I_field_a56a8dc5;
   private final Set<Integer> i_field_a56a8dc5;
   private BlockPos I_field_670402ba;
   private int II_field_49;
   private ScreenHandler I_field_f1d52bc0;
   private String II_field_523beb0a;
   private boolean II_field_5a;
   private int Ii_field_49;
   private int iI_field_49;
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private int ii_field_49;
   private String Ii_field_523beb0a;
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41;

   public IIIiiiIII_Class57(AutoFarmModule var1, ModeSetting var2) {
      super(var1, var2, "modules.settings.auto_farm.modes.auto_sell");
      this.I_field_9043d247 = IIIiiiIII_Class57.Nested1_b8258c40.I_field_9043d247;
      this.I_field_f2735522 = ItemStack.EMPTY;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.II_field_991c1e8c = new iiIiIIiii_Class424();
      this.I_field_db650847 = new ArrayDeque<>();
      this.I_field_a56a8dc5 = new HashSet<>();
      this.i_field_a56a8dc5 = new HashSet<>();
      this.II_field_523beb0a = "";
      this.Ii_field_49 = -1;
      this.I_field_3d936f41 = var1x -> {
         if (var1x.getPacket() instanceof GameMessageS2CPacket var2x) {
            if (var2x.content().getString().contains("\u0423 \u0412\u0430\u0441 \u043a\u0443\u043f\u0438\u043b\u0438")) {
               this.i_field_5a = true;
               this.I_method_18285755().Ii_method_96108ce2();
            }

            if (var2x.content()
               .getString()
               .contains("\u0441\u043b\u0438\u0448\u043a\u043e\u043c \u0434\u043e\u0440\u043e\u0433\u043e. \u0412\u0432\u0435\u0434\u0438\u0442\u0435")) {
               I_field_3a9bda27.player.networkHandler.sendChatCommand(this.Ii_field_523beb0a);
               this.II_field_49 = 0;
               this.i_field_a56a8dc5.clear();
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.III_field_9043d247);
            }
         }
      };
      this.i_field_3d936f41 = var1x -> {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            if (this.I_field_5a) {
               switch (this.I_field_9043d247) {
                  case i_field_9043d247:
                     this.IIi_method_c940629f();
                     break;
                  case II_field_9043d247:
                     this.IiI_method_caf4c6df();
                     break;
                  case Ii_field_9043d247:
                     this.Iii_method_cb0352bf();
                     break;
                  case iI_field_9043d247:
                     this.iII_method_ffccea9f();
                     break;
                  case ii_field_9043d247:
                     this.iIi_method_ffdb767f();
                     break;
                  case III_field_9043d247:
                     this.iiI_method_18fdabf();
                     break;
                  case IIi_field_9043d247:
                     this.iii_method_19e669f();
                     break;
                  case IiI_field_9043d247:
                     this.IIII_method_5d17f882();
                     break;
                  case Iii_field_9043d247:
                     this.IIIi_method_5d268462();
                     break;
                  case iII_field_9043d247:
                     this.IIiI_method_5edae8a2();
                     break;
                  case iIi_field_9043d247:
                     this.IIii_method_5ee97482();
                     break;
                  case iiI_field_9043d247:
                     this.IiII_method_93b30c62();
               }
            }
         }
      };
      this.I_field_731802cc = new TextSetting(var1, "modules.settings.auto_sell.quantity", () -> !this.isSelected() || !this.II_method_e574bce6())
         .I_method_104de33f("64")
         .I_method_ec08f9eb(true);
      this.i_field_731802cc = new TextSetting(var1, "modules.settings.auto_sell.price", () -> !this.isSelected() || !this.II_method_e574bce6())
         .I_method_104de33f("10000")
         .I_method_ec08f9eb(true);
      this.I_field_73178e8c = new SliderSetting(var1, "modules.settings.auto_sell.relist_cooldown", () -> !this.isSelected() || !this.II_method_e574bce6())
         .II_method_b0f56334(5.0F)
         .I_method_c8c9a7d7(5.0F)
         .i_method_65e2aff7(300.0F)
         .Ii_method_4e0e6b54(60.0F)
         .I_method_d41e7abf("sec");
      this.I_field_bbd4b28c = new ButtonSetting(var1, "modules.settings.auto_sell.confirm", () -> !this.isSelected() || !this.II_method_e574bce6())
         .I_method_f05556b3(this::III_method_c931d6bf);
   }

   @Override
   public void I_method_a0f53e1f() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         ItemStack var1 = I_field_3a9bda27.player.getMainHandStack();
         if (var1.isEmpty()) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("modules.auto_sell.no_item_in_hand")));
            this.iI_method_8024b102();
         } else {
            this.I_field_3c05b08c = var1.getItem();
            this.I_field_f2735522 = var1.copy();
            this.I_field_5a = false;
            this.i_field_5a = false;
            this.I_field_db650847.clear();
            this.I_field_a56a8dc5.clear();
            this.I_field_670402ba = null;
            this.I_field_f1d52bc0 = null;
            this.II_field_49 = 0;
            this.II_field_5a = false;
            this.Ii_field_49 = -1;
            this.iI_field_49 = 0;
            this.I_field_32e13e6c = null;
            this.ii_field_49 = 0;
            this.I_field_991c1e8c.I_method_23e11e3f();
            this.ii_method_e74638e2();
            this.I_field_9043d247 = IIIiiiIII_Class57.Nested1_b8258c40.I_field_9043d247;
            I_field_3a9bda27.setScreen(new IIIiiiIIi_Class58(this));
         }
      } else {
         this.iI_method_8024b102();
      }
   }

   @Override
   public void i_method_a103c9ff() {
      this.I_field_9043d247 = IIIiiiIII_Class57.Nested1_b8258c40.I_field_9043d247;
      this.I_field_5a = false;
      this.IiiI_method_9575fc82();
      if (I_field_3a9bda27.currentScreen instanceof IIIiiiIIi_Class58) {
         I_field_3a9bda27.setScreen(null);
      }
   }

   public boolean I_method_59fb0663() {
      return this.I_field_22f63e4c.isEnabled();
   }

   private boolean II_method_e574bce6() {
      return I_field_3a9bda27.currentScreen instanceof IIIiiiIIi_Class58;
   }

   private void ii_method_e74638e2() {
      this.I_field_ab760aac = new IiIIiiIii_Class156(0.0F, 0.0F, 170.0F);
      this.I_field_ab760aac.i_method_a1faeedf("modules.settings.auto_sell.title");
      this.I_field_ab760aac.I_method_880b4e76(new IIIiiiIII_Class57.Nested1_b8258c20());
      this.I_field_ab760aac.I_method_cbb5737d(this.I_field_731802cc);
      this.I_field_ab760aac.I_method_cbb5737d(this.i_field_731802cc);
      this.I_field_ab760aac.I_method_cbb5737d(this.I_field_73178e8c);
      this.I_field_ab760aac.I_method_cbb5737d(this.I_field_bbd4b28c);
      this.I_field_ab760aac.I_method_8f5bef3(() -> {});
   }

   private void III_method_c931d6bf() {
      if (this.I_field_ab760aac != null) {
         this.I_field_ab760aac.I_method_c3d80455(false);
      }
   }

   public void II_method_e574bce2() {
      if (!this.I_field_5a) {
         this.I_field_5a = true;
         this.I_field_9043d247 = IIIiiiIII_Class57.Nested1_b8258c40.i_field_9043d247;
         this.I_field_991c1e8c.I_method_23e11e3f();
         this.i_field_991c1e8c.I_method_23e11e3f();
      }
   }

   public boolean i_method_5a099243() {
      return this.I_field_5a;
   }

   @Override
   public IIiIIIIIi_Class66 I_method_57286715() {
      return switch (this.I_field_9043d247) {
         case I_field_9043d247, i_field_9043d247 -> IIiIIIIIi_Class66.I_field_e6af4a4c;
         case II_field_9043d247, Ii_field_9043d247, iI_field_9043d247 -> IIiIIIIIi_Class66.ii_field_e6af4a4c;
         case ii_field_9043d247, III_field_9043d247, IIi_field_9043d247, IiI_field_9043d247, Iii_field_9043d247, iII_field_9043d247, iIi_field_9043d247, iiI_field_9043d247 -> IIiIIIIIi_Class66.IIi_field_e6af4a4c;
      };
   }

   @Override
   public IIiIIIiII_Class69 I_method_5736ef15() {
      return IIiIIIiII_Class69.II_field_e6bdd24c;
   }

   @Override
   public ItemStack I_method_907017b9() {
      return this.I_field_f2735522 != null && !this.I_field_f2735522.isEmpty() ? this.I_field_f2735522 : new ItemStack(Items.EMERALD);
   }

   private boolean Ii_method_e58348c6() {
      int var1 = this.I_field_f2735522.isEmpty() ? 64 : Math.max(1, this.I_field_f2735522.getMaxCount());
      return this.i_method_5a099232() >= 4 * var1;
   }

   private void IIi_method_c940629f() {
      this.I_field_db650847.clear();
      this.I_field_a56a8dc5.clear();
      this.I_field_670402ba = null;
      if (this.Ii_method_e58348c6()) {
         this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.ii_field_9043d247);
      } else {
         BlockPos var1 = BlockPos.ofFloored(I_field_3a9bda27.player.getPos());

         for (BlockPos var3 : BlockPos.iterateOutwards(var1, 8, 8, 8)) {
            if (I_field_3a9bda27.world.getBlockEntity(var3) instanceof ChestBlockEntity) {
               BlockPos var4 = var3.toImmutable();
               if (!this.I_field_a56a8dc5.contains(var4)) {
                  this.I_field_a56a8dc5.add(var4);
                  BlockPos var5 = this.I_method_d4738957(var4);
                  if (var5 != null) {
                     this.I_field_a56a8dc5.add(var5);
                  }

                  this.I_field_db650847.add(var4);
               }
            }
         }

         this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.II_field_9043d247);
      }
   }

   private void IiI_method_caf4c6df() {
      if (this.Ii_method_e58348c6()) {
         this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.iI_field_9043d247);
      } else {
         if (this.I_field_670402ba == null) {
            this.I_field_670402ba = this.I_field_db650847.poll();
            if (this.I_field_670402ba == null) {
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.iI_field_9043d247);
               return;
            }

            this.I_field_32e13e6c = null;
            this.ii_field_49 = 0;
         }

         if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler) {
            this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.Ii_field_9043d247);
         } else if (!this.I_method_e5467e1d(this.I_field_670402ba)
            || !(I_field_3a9bda27.world.getBlockEntity(this.I_field_670402ba) instanceof ChestBlockEntity)) {
            this.I_field_670402ba = null;
         } else if (this.I_method_3fb55b4f(Vec3d.ofCenter(this.I_field_670402ba))) {
            if (this.I_field_991c1e8c.I_method_58432069(350L)) {
               this.I_method_e5467e19(this.I_field_670402ba);
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void Iii_method_cb0352bf() {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1) {
         if (this.I_field_991c1e8c.I_method_58432069(350L)) {
            if (this.Ii_method_e58348c6()) {
               this.IiiI_method_9575fc82();
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.iI_field_9043d247);
            } else {
               for (int var4 = 0; var4 < var1.slots.size(); var4++) {
                  Slot var3 = (Slot)var1.slots.get(var4);
                  if (var3.inventory != I_field_3a9bda27.player.getInventory() && this.I_method_74d3ef85(var3.getStack())) {
                     I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var4, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                     this.I_field_991c1e8c.I_method_23e11e3f();
                     return;
                  }
               }

               this.IiiI_method_9575fc82();
               this.I_field_670402ba = null;
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.II_field_9043d247);
            }
         }
      } else {
         this.I_field_670402ba = null;
         this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.II_field_9043d247);
      }
   }

   private void iII_method_ffccea9f() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         this.IiiI_method_9575fc82();
         this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.ii_field_9043d247);
      }
   }

   private int I_method_b22c230f(TextSetting var1, int var2) {
      try {
         String var3 = var1.II_method_da016c1e();
         return var3 != null && !var3.isBlank() ? Math.max(1, Integer.parseInt(var3.trim().replaceAll("[^0-9]", ""))) : var2;
      } catch (NumberFormatException var4) {
         return var2;
      }
   }

   private int I_method_59fb0652() {
      return this.I_method_b22c230f(this.I_field_731802cc, 64);
   }

   private void iIi_method_ffdb767f() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         int var1 = this.I_method_59fb0652();
         if (this.i_method_5a099232() < var1) {
            if (this.II_field_5a) {
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.Iii_field_9043d247);
            } else {
               this.IiIi_method_93c19842();
            }
         } else {
            String var2 = String.valueOf(this.I_method_b22c230f(this.i_field_731802cc, 10000));
            this.Ii_field_523beb0a = "ah sellgui " + var2;
            I_field_3a9bda27.player.networkHandler.sendChatCommand(this.Ii_field_523beb0a);
            this.II_field_49 = 0;
            this.i_field_a56a8dc5.clear();
            this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.III_field_9043d247);
         }
      }
   }

   private void iiI_method_18fdabf() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         ScreenHandler var1 = this.I_method_cf856117();
         if (var1 == null) {
            if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.ii_field_9043d247);
            }
         } else {
            int var2 = this.I_method_59fb0652();
            int var3 = this.iI_method_991f235(var1);
            if (var3 == -1 && this.II_field_49 == 0) {
               this.II_field_5a = true;
               this.IiiI_method_9575fc82();
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.Iii_field_9043d247);
            } else if (var3 != -1 && this.i_method_f712bcf2(var1) >= var2) {
               this.i_field_a56a8dc5.add(var3);
               int var4 = this.i_method_f712bcf2(var1);
               this.I_method_90bf35bf(var1, var3, var2);
               if (this.i_method_f712bcf2(var1) < var4) {
                  this.II_field_49++;
               }

               this.I_field_991c1e8c.I_method_23e11e3f();
            } else {
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IIi_field_9043d247);
            }
         }
      }
   }

   private void I_method_90bf35bf(ScreenHandler var1, int var2, int var3) {
      int var4 = var3;

      for (int var5 = var3 + 64; var4 > 0 && var5-- > 0; var4--) {
         ItemStack var6 = var1.getCursorStack();
         if (!this.I_method_74d3ef85(var6)) {
            int var7 = this.II_method_758c9215(var1);
            if (var7 == -1) {
               break;
            }

            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var7, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
            var6 = var1.getCursorStack();
            if (var6.isEmpty()) {
               break;
            }
         }

         I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 1, SlotActionType.PICKUP, I_field_3a9bda27.player);
      }

      ItemStack var9 = var1.getCursorStack();
      if (!var9.isEmpty()) {
         int var10 = this.Ii_method_594aadf5(var1);
         if (var10 == -1) {
            var10 = this.II_method_758c9215(var1);
         }

         if (var10 != -1) {
            I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var10, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
         }
      }
   }

   private void iii_method_19e669f() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         if (this.II_field_49 == 0) {
            this.IiiI_method_9575fc82();
            if (this.II_field_5a) {
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247);
            } else {
               this.IiIi_method_93c19842();
            }
         } else {
            ScreenHandler var1 = this.I_method_cf856117();
            if (var1 == null) {
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.ii_field_9043d247);
            } else {
               int var2 = this.I_method_fe21b73a(var1, Items.LIME_DYE);
               if (var2 == -1) {
                  if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                     iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("modules.auto_sell.no_lime_dye")));
                     this.iI_method_8024b102();
                  }
               } else {
                  I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
                  this.II_field_5a = true;
                  this.i_field_5a = false;
                  this.II_field_991c1e8c.I_method_23e11e3f();
                  this.IiiI_method_9575fc82();
                  this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247);
               }
            }
         }
      }
   }

   private void IIII_method_5d17f882() {
      if (this.i_field_5a) {
         this.i_field_5a = false;
         this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.i_field_9043d247);
      } else {
         if (this.II_field_991c1e8c.I_method_58432069((long)this.I_field_73178e8c.Ii_method_a20abcd2() * 1000L)) {
            this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.Iii_field_9043d247);
         }
      }
   }

   private void IIIi_method_5d268462() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         this.IiiI_method_9575fc82();
         this.I_field_f1d52bc0 = null;
         this.Ii_field_49 = -1;
         this.iI_field_49 = 0;
         I_field_3a9bda27.player.networkHandler.sendChatCommand("ah");
         this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.iII_field_9043d247);
      }
   }

   private void IIiI_method_5edae8a2() {
      if (this.I_field_991c1e8c.I_method_58432069(650L)) {
         ScreenHandler var1 = this.I_method_cf856117();
         if (var1 == null) {
            if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247);
            }
         } else {
            int var2 = this.I_method_f835611c(var1, "\u0425\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435");
            if (var2 == -1) {
               if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                  this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247);
               }
            } else {
               this.I_field_f1d52bc0 = var1;
               this.II_field_523beb0a = I_field_3a9bda27.currentScreen != null ? I_field_3a9bda27.currentScreen.getTitle().getString() : "";
               I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.iIi_field_9043d247);
            }
         }
      }
   }

   private void IIii_method_5ee97482() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         ScreenHandler var1 = this.I_method_cf856117();
         if (var1 == null) {
            if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
               this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247);
            }
         } else {
            String var2 = I_field_3a9bda27.currentScreen != null ? I_field_3a9bda27.currentScreen.getTitle().getString() : "";
            boolean var3 = var1 == this.I_field_f1d52bc0 && var2.equals(this.II_field_523beb0a);
            if (var3) {
               if (this.i_field_991c1e8c.I_method_58432069(5000L)) {
                  this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247);
               }
            } else {
               int var4 = this.I_method_1354a112(var1);
               if (var4 == 0) {
                  this.II_field_5a = false;
                  this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.iiI_field_9043d247);
               } else {
                  if (this.Ii_field_49 != -1 && var4 >= this.Ii_field_49) {
                     this.iI_field_49++;
                     if (this.iI_field_49 >= 4) {
                        this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247);
                        return;
                     }
                  } else {
                     this.iI_field_49 = 0;
                  }

                  this.Ii_field_49 = var4;

                  for (int var5 = 0; var5 < var1.slots.size(); var5++) {
                     Slot var6 = (Slot)var1.slots.get(var5);
                     if (var6.inventory != I_field_3a9bda27.player.getInventory() && this.I_method_74d3ef85(var6.getStack())) {
                        I_field_3a9bda27.interactionManager.clickSlot(var1.syncId, var5, 0, SlotActionType.QUICK_MOVE, I_field_3a9bda27.player);
                        this.I_field_991c1e8c.I_method_23e11e3f();
                        return;
                     }
                  }

                  this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247);
               }
            }
         }
      }
   }

   private int I_method_1354a112(ScreenHandler var1) {
      int var2 = 0;

      for (Slot var4 : var1.slots) {
         if (var4.inventory != I_field_3a9bda27.player.getInventory() && this.I_method_74d3ef85(var4.getStack())) {
            var2 += Math.max(1, var4.getStack().getCount());
         }
      }

      return var2;
   }

   private void IiII_method_93b30c62() {
      if (this.I_field_991c1e8c.I_method_58432069(350L)) {
         this.IiiI_method_9575fc82();
         this.I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40.ii_field_9043d247);
      }
   }

   private void IiIi_method_93c19842() {
      iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_f25a980a("modules.auto_sell.done")));
      this.iI_method_8024b102();
   }

   private void I_method_d34d1202(IIIiiiIII_Class57.Nested1_b8258c40 var1) {
      this.I_field_9043d247 = var1;
      this.I_field_991c1e8c.I_method_23e11e3f();
      this.i_field_991c1e8c.I_method_23e11e3f();
      this.I_field_32e13e6c = null;
      this.ii_field_49 = 0;
      if (var1 == IIIiiiIII_Class57.Nested1_b8258c40.IiI_field_9043d247) {
         this.II_field_991c1e8c.I_method_23e11e3f();
         this.i_field_5a = false;
      }
   }

   private boolean I_method_74d3ef85(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (var1.getItem() != this.I_field_3c05b08c) {
            return false;
         } else if (this.I_field_3c05b08c != Items.POTION
            && this.I_field_3c05b08c != Items.SPLASH_POTION
            && this.I_field_3c05b08c != Items.LINGERING_POTION
            && this.I_field_3c05b08c != Items.TIPPED_ARROW) {
            return true;
         } else {
            PotionContentsComponent var2 = (PotionContentsComponent)var1.get(DataComponentTypes.POTION_CONTENTS);
            PotionContentsComponent var3 = (PotionContentsComponent)this.I_field_f2735522.get(DataComponentTypes.POTION_CONTENTS);
            return Objects.equals(var2, var3);
         }
      } else {
         return false;
      }
   }

   private int i_method_5a099232() {
      if (I_field_3a9bda27.player == null) {
         return 0;
      } else {
         int var1 = 0;

         for (iIIiiiiII_Class317 var3 : iIIiiIiIi_Class310.i_method_7fde0a75().I_method_617d3e68()) {
            if (!var3.I_method_dfe89263() && this.I_method_74d3ef85(var3.I_method_7b7e0bb9())) {
               var1 += var3.I_method_7b7e0bb9().getCount();
            }
         }

         for (iIIiiiIii_Class316 var5 : iIIiiIiIi_Class310.I_method_6a489695().I_method_617d3e68()) {
            if (!var5.I_method_dfe89263() && this.I_method_74d3ef85(var5.I_method_7b7e0bb9())) {
               var1 += var5.I_method_7b7e0bb9().getCount();
            }
         }

         return var1;
      }
   }

   private int i_method_f712bcf2(ScreenHandler var1) {
      int var2 = 0;

      for (Slot var4 : var1.slots) {
         if (var4.inventory == I_field_3a9bda27.player.getInventory() && this.I_method_74d3ef85(var4.getStack())) {
            var2 += var4.getStack().getCount();
         }
      }

      return var2;
   }

   private int II_method_758c9215(ScreenHandler var1) {
      for (int var2 = 0; var2 < var1.slots.size(); var2++) {
         Slot var3 = (Slot)var1.slots.get(var2);
         if (var3.inventory == I_field_3a9bda27.player.getInventory() && this.I_method_74d3ef85(var3.getStack())) {
            return var2;
         }
      }

      return -1;
   }

   private int Ii_method_594aadf5(ScreenHandler var1) {
      for (int var2 = 0; var2 < var1.slots.size(); var2++) {
         Slot var3 = (Slot)var1.slots.get(var2);
         if (var3.inventory == I_field_3a9bda27.player.getInventory() && var3.getStack().isEmpty()) {
            return var2;
         }
      }

      return -1;
   }

   private int iI_method_991f235(ScreenHandler var1) {
      for (int var2 = 0; var2 < var1.slots.size(); var2++) {
         Slot var3 = (Slot)var1.slots.get(var2);
         if (var3.inventory != I_field_3a9bda27.player.getInventory() && !this.i_field_a56a8dc5.contains(var2) && var3.getStack().isEmpty()) {
            return var2;
         }
      }

      return -1;
   }

   private int I_method_fe21b73a(ScreenHandler var1, Item var2) {
      for (int var3 = 0; var3 < var1.slots.size(); var3++) {
         Slot var4 = (Slot)var1.slots.get(var3);
         if (var4.inventory != I_field_3a9bda27.player.getInventory() && var4.getStack().getItem() == var2) {
            return var3;
         }
      }

      return -1;
   }

   private int I_method_f835611c(ScreenHandler var1, String var2) {
      for (int var3 = 0; var3 < var1.slots.size(); var3++) {
         Slot var4 = (Slot)var1.slots.get(var3);
         if (var4.inventory != I_field_3a9bda27.player.getInventory()) {
            ItemStack var5 = var4.getStack();
            if (!var5.isEmpty() && var5.getName().getString().contains(var2)) {
               return var3;
            }
         }
      }

      return -1;
   }

   private ScreenHandler I_method_cf856117() {
      if (!(I_field_3a9bda27.currentScreen instanceof HandledScreen)) {
         return null;
      } else if (I_field_3a9bda27.player == null) {
         return null;
      } else {
         ScreenHandler var1 = I_field_3a9bda27.player.currentScreenHandler;
         return var1 == I_field_3a9bda27.player.playerScreenHandler ? null : var1;
      }
   }

   private void IiiI_method_9575fc82() {
      if (I_field_3a9bda27.player != null) {
         if (I_field_3a9bda27.player.currentScreenHandler != null
            && I_field_3a9bda27.player.currentScreenHandler != I_field_3a9bda27.player.playerScreenHandler) {
            I_field_3a9bda27.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(I_field_3a9bda27.player.currentScreenHandler.syncId));
         }

         if (I_field_3a9bda27.currentScreen instanceof HandledScreen) {
            I_field_3a9bda27.player.closeHandledScreen();
         }
      }
   }

   private void I_method_e5467e19(BlockPos var1) {
      Vec3d var2 = Vec3d.ofCenter(var1);
      BlockHitResult var3 = new BlockHitResult(var2, Direction.UP, var1, false);
      I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, Hand.MAIN_HAND, var3);
      I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
   }

   private boolean I_method_e5467e1d(BlockPos var1) {
      double var2 = I_field_3a9bda27.player.getBlockInteractionRange() + 0.5;
      return I_field_3a9bda27.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) <= var2 * var2;
   }

   private BlockPos I_method_d4738957(BlockPos var1) {
      if (var1 != null && I_field_3a9bda27.world != null) {
         BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
         if (!(var2.getBlock() instanceof ChestBlock)) {
            return null;
         } else {
            ChestType var3 = (ChestType)var2.get(ChestBlock.CHEST_TYPE);
            if (var3 == ChestType.SINGLE) {
               return null;
            } else {
               Direction var4 = (Direction)var2.get(ChestBlock.FACING);
               Direction var5 = var3 == ChestType.LEFT ? var4.rotateYClockwise() : var4.rotateYCounterclockwise();
               return var1.offset(var5);
            }
         }
      } else {
         return null;
      }
   }

   private boolean I_method_3fb55b4f(Vec3d var1) {
      iiIIiIIii_Class404 var2 = iiIIiIiIi_Class406.I_method_bc8095a1(var1);
      if (this.I_field_32e13e6c == null || this.I_field_32e13e6c.I_method_24e31c97(var2) > 0.5F) {
         this.I_field_32e13e6c = var2;
         this.ii_field_49 = 0;
      }

      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(var2, iiIIiIIIi_Class402.Ii_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.iI_field_32efc66c);
      iiIIiIIii_Class404 var3 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      if (var3 != null && var3.I_method_24e31c97(var2) <= 1.5F) {
         this.ii_field_49++;
         return this.ii_field_49 >= 1;
      } else {
         return false;
      }
   }

   @Generated
   public IiIIiiIii_Class156 I_method_1bef2775() {
      return this.I_field_ab760aac;
   }

   class Nested1_b8258c20 extends IiIIiiiIi_Class158 {
      @Override
      protected void i_method_bdd4e0ec(III var1) {
         float var2 = 8.0F;
         var1.drawItem(IIIiiiIII_Class57.this.I_field_f2735522, this.I_field_46 + var2, this.i_field_46 + (this.Ii_field_46 - 16.0F) / 2.0F, 1.0F);
         IIiIIi_Class10 var3 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
         String var4 = IIIiiiIII_Class57.this.I_field_f2735522.isEmpty() ? "" : IIIiiiIII_Class57.this.I_field_f2735522.getName().getString();
         var1.drawFadeoutText(
            var3,
            var4,
            this.I_field_46 + var2 + 20.0F,
            this.i_field_46 + iIIiIIIiI_Class291.I_method_ef5e7a8f(var3.I_method_a649725c(), this.Ii_field_46),
            IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(RenderSystem.getShaderColor()[3] * 255.0F),
            0.8F,
            1.0F,
            this.II_field_46 - 28.0F
         );
      }

      @Override
      public float Ii_method_2047ead7() {
         return this.Ii_field_46 = 22.0F;
      }
   }

   static enum Nested1_b8258c40 {
      I_field_9043d247,
      i_field_9043d247,
      II_field_9043d247,
      Ii_field_9043d247,
      iI_field_9043d247,
      ii_field_9043d247,
      III_field_9043d247,
      IIi_field_9043d247,
      IiI_field_9043d247,
      Iii_field_9043d247,
      iII_field_9043d247,
      iIi_field_9043d247,
      iiI_field_9043d247;
   }
}
