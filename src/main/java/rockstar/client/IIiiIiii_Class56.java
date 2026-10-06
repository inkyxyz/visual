package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import moscow.rockstar.mixin.accessors.PlayerListHudAccessor;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.world.Difficulty;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import ua.mintantileak.spk.Compile;

public class IIiiIiii_Class56 implements iIIiIIiIi_Class294 {
   private static final iIIiiIiII_Class309<iIIiIiIii_Class300> I_field_4728d64c = iIIiiIiIi_Class310.i_method_7fde0a75()
      .I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695())
      .I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
   private final IIiiIiii_Class56.Nested1_8137a513 I_field_23cb2dbc = new IIiiIiii_Class56.Nested1_8137a513();
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_23cb2dbc.I_field_5a && I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         if (iIIIiiiII_Class285.Ii_method_b349c526()) {
            this.iI_method_351b2455();
         } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)
            || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
            this.I_method_2af1d8ac();
         } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c)) {
            this.i_method_2b00648c();
         }
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41 = var1 -> {
      if (this.I_field_23cb2dbc.I_field_5a && I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         if (iIIIiiiII_Class285.Ii_method_b349c526() && !(var1.getPacket() instanceof OpenScreenS2CPacket)) {
            iIIiIiIii_Class300 var2 = I_field_4728d64c.I_method_77fa4424(var0 -> var0.getItem() == Items.COMPASS);
            if (var2 != null) {
               if (this.I_field_23cb2dbc.I_field_23cb29dc == IIiiIiii_Class56.Nested1_8137a4f3.i_field_23cb29dc) {
                  if (!this.I_field_23cb2dbc.iI_field_5a) {
                     this.I_field_23cb2dbc.iI_field_5a = true;
                     this.Ii_method_3366c015();
                     I_field_3a9bda27.player.networkHandler.sendChatCommand("lite");
                  }
               } else if (!this.I_field_23cb2dbc.II_field_5a) {
                  this.I_field_23cb2dbc.II_field_5a = true;
                  I_field_3a9bda27.player.networkHandler.sendChatCommand("menu");
               }
            }
         }

         if (iIIIiiiII_Class285.Ii_method_b349c526() && var1.getPacket() instanceof OpenScreenS2CPacket var4) {
            String var5 = var4.getName().getString();
            if (this.I_field_23cb2dbc.I_field_23cb29dc == IIiiIiii_Class56.Nested1_8137a4f3.i_field_23cb29dc
               && var5.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
               this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.i_field_559a1391;
            } else if (this.I_field_23cb2dbc.I_field_23cb29dc == IIiiIiii_Class56.Nested1_8137a4f3.i_field_23cb29dc
               && var5.contains("\u0412\u044b\u0431\u043e\u0440 \u041b\u0430\u0439\u0442 \u0430\u043d\u0430\u0440\u0445\u0438\u0438")
               && this.I_field_23cb2dbc.I_field_559a1391 != IIiiIiii_Class56.Nested1_a5bcf9b6.II_field_559a1391) {
               this.Ii_method_3366c015();
            } else if (this.I_field_23cb2dbc.I_field_23cb29dc == IIiiIiii_Class56.Nested1_8137a4f3.II_field_23cb29dc
               && var5.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
               this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.Ii_field_559a1391;
            } else if (this.I_field_23cb2dbc.I_field_23cb29dc == IIiiIiii_Class56.Nested1_8137a4f3.II_field_23cb29dc
               && var5.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0441\u0435\u0440\u0432\u0435\u0440 \u041b\u0430\u0439\u0442")) {
               this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.iI_field_559a1391;
            } else if (this.I_field_23cb2dbc.I_field_23cb29dc == IIiiIiii_Class56.Nested1_8137a4f3.Ii_field_23cb29dc
               && var5.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
               this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.ii_field_559a1391;
            } else if (this.I_field_23cb2dbc.I_field_23cb29dc == IIiiIiii_Class56.Nested1_8137a4f3.Ii_field_23cb29dc
               && var5.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u041a\u043b\u0430\u0441\u0441\u0438\u0447")) {
               this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.III_field_559a1391;
            }
         }
      }
   };

   public IIiiIiii_Class56() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public final IIIiiIIi_Class26 I_method_cd1063cb() {
      return IIIiiIiI_Class27.I_method_209cd841("rct")
         .I_method_b3f941e4("reconnect")
         .i_method_cfe1a061("commands.rehub.description")
         .i_method_3d6e11d9("args", var0 -> var0.I_method_e930dfcb().i_method_132d6feb().I_method_2619a44a(IIiIIIIi_Class34::I_method_12fc454a))
         .I_method_16f05c8a(this::I_method_86ff3b2d)
         .I_method_9111538b();
   }

   @Compile
   private void I_method_86ff3b2d(IIIiiIii_Class28 var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         List var2 = var1.I_method_557e5bfb().isEmpty() ? List.of() : this.I_method_1a619bbf(var1.I_method_557e5bfb().getFirst());
         IIiiIiii_Class56.Nested1_a5bcf9d6 var3 = IIiiIiii_Class56.Nested1_a5bcf9d6.I_field_559a1771;
         Integer var4 = null;
         if (!var2.isEmpty()) {
            IIiiIiii_Class56.Nested1_a5bcf9d6 var5 = IIiiIiii_Class56.Nested1_a5bcf9d6.I_method_7f034b89((String)var2.getFirst());
            int var6 = 0;
            if (var5 != null) {
               var3 = var5;
               var6++;
            }

            if (var6 < var2.size()) {
               var4 = this.I_method_78479d1d((String)var2.get(var6));
               if (var4 == null) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.invalid_number")));
                  return;
               }
            }
         }

         if (!var1.I_method_557e5bfb().isEmpty() && var1.I_method_557e5bfb().getFirst() instanceof Integer var8) {
            var4 = var8;
         }

         KtLeaveModule varKtLeave = RockstarClient.getInstance().getModuleManager().getModule(KtLeaveModule.class);
         if (iIIIiiiII_Class285.I_field_5a && !(varKtLeave != null && varKtLeave.isEnabled())) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.ct")));
         } else {
            this.I_field_23cb2dbc.I_method_5bdd9287();
            this.I_field_23cb2dbc.I_field_559a1771 = this.I_method_3252f11a(var3);
            this.II_method_33583435();
            if (var4 != null) {
               if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c)) {
                  if (this.I_field_23cb2dbc.I_field_559a1771 == IIiiIiii_Class56.Nested1_a5bcf9d6.i_field_559a1771
                     || this.I_field_23cb2dbc.I_field_559a1771 == IIiiIiii_Class56.Nested1_a5bcf9d6.II_field_559a1771) {
                     this.I_field_23cb2dbc.I_field_49 = var4;
                  }
               } else if (iIIIiiiII_Class285.Ii_method_b349c526()) {
                  if (this.I_field_23cb2dbc.I_field_23cb29dc == IIiiIiii_Class56.Nested1_8137a4f3.I_field_23cb29dc) {
                     this.I_field_23cb2dbc.I_field_23cb29dc = IIiiIiii_Class56.Nested1_8137a4f3.i_field_23cb29dc;
                  }

                  if (!this.I_method_3349afdb(var4)) {
                     this.I_field_23cb2dbc.I_method_5bdd9287();
                     return;
                  }
               } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
                  this.I_field_23cb2dbc.I_field_49 = var4;
               } else {
                  this.I_field_23cb2dbc.I_field_49 = var4;
               }
            } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c)
               && this.I_field_23cb2dbc.I_field_559a1771 == IIiiIiii_Class56.Nested1_a5bcf9d6.i_field_559a1771) {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.invalid_number")));
               return;
            }

            if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)
               || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)) {
               this.I_field_23cb2dbc.I_field_49 = this.II_method_33583428();
               if (this.I_field_23cb2dbc.I_field_49 <= 0) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.invalid_number")));
                  this.I_field_23cb2dbc.I_method_5bdd9287();
                  return;
               }
            }

            this.I_field_991c1e8c.I_method_23e11e3f();
            I_field_3a9bda27.player.networkHandler.sendChatCommand("hub");
            this.I_field_23cb2dbc.I_field_5a = true;
         }
      }
   }

   private void I_method_2af1d8ac() {
      if (this.I_field_991c1e8c.I_method_58432069(1000L)) {
         int var1 = this.I_field_23cb2dbc.I_field_49 > 0 ? this.I_field_23cb2dbc.I_field_49 : this.II_method_33583428();
         if (var1 <= 0) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.invalid_number")));
            this.ii_method_3529b035();
         } else if (I_field_3a9bda27.world.getDifficulty() == Difficulty.EASY
            || iIIIiiiII_Class285.II_method_b33b3946()
            || this.I_field_991c1e8c.I_method_58432069(4000L)) {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("an" + var1);
            this.I_field_991c1e8c.I_method_23e11e3f();
            this.I_field_23cb2dbc.I_field_5a = false;
         }
      }
   }

   private void i_method_2b00648c() {
      if (this.I_field_991c1e8c.I_method_58432069(300L)) {
         if (!this.I_field_23cb2dbc.Ii_field_5a) {
            if (iIIIIIiIi_Class262.I_method_1a228de3()) {
               this.I_field_23cb2dbc.Ii_field_5a = true;
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         } else if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1 && I_field_3a9bda27.currentScreen != null) {
            String var6 = I_field_3a9bda27.currentScreen.getTitle().getString();
            boolean var3 = this.I_field_23cb2dbc.I_field_559a1771 == IIiiIiii_Class56.Nested1_a5bcf9d6.II_field_559a1771;
            if (iIIIIIiIi_Class262.I_method_17a99ded(var6)) {
               int var7 = iIIIIIiIi_Class262.I_method_d70844be(var1, var3);
               if (var7 != -1) {
                  iIIIIIiIi_Class262.I_method_d70804fa(var1, var7);
                  this.I_field_991c1e8c.I_method_23e11e3f();
               }
            } else if (iIIIIIiIi_Class262.I_method_dd8ad20f(var6, var3)) {
               int var4 = this.I_field_23cb2dbc.I_field_49 > 0 ? this.I_field_23cb2dbc.I_field_49 : this.I_method_2af1d89f();
               if (var4 <= 0) {
                  iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.invalid_number")));
                  this.ii_method_3529b035();
               } else {
                  iIIIIIiIi_Class262.Nested1_86f734a0 var5 = iIIIIIiIi_Class262.I_method_3309b8b5(var1, var6, var4, var3);
                  if (var5 == iIIIIIiIi_Class262.Nested1_86f734a0.II_field_9ba735e7) {
                     this.ii_method_3529b035();
                  } else if (var5 == iIIIIIiIi_Class262.Nested1_86f734a0.i_field_9ba735e7) {
                     this.I_field_991c1e8c.I_method_23e11e3f();
                  }
               }
            }
         }
      }
   }

   private void II_method_33583435() {
      this.I_field_23cb2dbc.I_field_23cb29dc = IIiiIiii_Class56.Nested1_8137a4f3.I_field_23cb29dc;
      this.I_field_23cb2dbc.I_field_523beb0a = "";
      this.I_field_23cb2dbc.I_field_49 = -1;
      if (iIIIiiiII_Class285.Ii_method_b349c526() && I_field_3a9bda27.player != null && I_field_3a9bda27.inGameHud != null) {
         Text var1 = null;

         try {
            var1 = ((PlayerListHudAccessor)(Object)I_field_3a9bda27.inGameHud.getPlayerListHud()).getHeader();
         } catch (RuntimeException var3) {
            RockstarClient.I_field_ab0f6068.debug("Failed to read tab header for reconnect mode detection", var3);
         }

         if ((var1 == null || var1.getString().isBlank())
            && I_field_3a9bda27.player.networkHandler != null
            && I_field_3a9bda27.player.networkHandler.getPlayerList() != null) {
            StringBuilder var2 = new StringBuilder();
            I_field_3a9bda27.player.networkHandler.getPlayerList().forEach(var1x -> {
               if (var1x.getProfile() != null && var1x.getProfile().getName() != null) {
                  var2.append(var1x.getProfile().getName()).append(" ");
               }
            });
            if (!var2.isEmpty()) {
               var1 = Text.of(var2.toString());
            }
         }

         if (var1 != null) {
            String var4 = var1.getString();
            if (!var4.isBlank()) {
               if (var4.contains("\u041a\u043b\u0430\u0441\u0441\u0438\u043a")) {
                  this.I_field_23cb2dbc.I_field_23cb29dc = IIiiIiii_Class56.Nested1_8137a4f3.Ii_field_23cb29dc;
                  this.I_method_660b27c0(var4, "\u041a\u043b\u0430\u0441\u0441\u0438\u043a");
               } else if (var4.contains("\u041b\u0430\u0439\u0442")
                  && !var4.contains("\u0421\u043e\u043b\u043e\u041b\u0430\u0439\u0442")
                  && !var4.contains("\u0414\u0443\u043e\u041b\u0430\u0439\u0442")
                  && !var4.contains("\u0422\u0440\u0438\u043e\u041b\u0430\u0439\u0442")
                  && !var4.contains("\u041a\u043b\u0430\u043d\u041b\u0430\u0439\u0442")) {
                  this.I_field_23cb2dbc.I_field_23cb29dc = IIiiIiii_Class56.Nested1_8137a4f3.II_field_23cb29dc;
                  this.I_method_660b27c0(var4, "\u041b\u0430\u0439\u0442");
               } else if (var4.contains("\u041b\u0430\u0439\u0442")) {
                  this.I_field_23cb2dbc.I_field_23cb29dc = IIiiIiii_Class56.Nested1_8137a4f3.i_field_23cb29dc;
                  this.I_method_660b27c0(var4, "\u041b\u0430\u0439\u0442");
               }
            }
         }
      }
   }

   private void I_method_660b27c0(String var1, String var2) {
      try {
         String[] var3 = var1.split("\u25b6");
         if (var3.length < 2) {
            return;
         }

         String var4 = var3[1].replace("\u0410\u043d\u0430\u0440\u0445\u0438\u044f", "").trim();
         String[] var5 = var4.split("#");
         if (var5.length < 2) {
            return;
         }

         this.I_field_23cb2dbc.I_field_523beb0a = var4.replace(var2, "").replaceAll("#\\d+", "").trim();
         String var6 = var5[1].replaceAll("[^0-9]", "").trim();
         if (var6.isEmpty()) {
            return;
         }

         this.I_field_23cb2dbc.I_field_49 = Integer.parseInt(var6);
      } catch (Exception var7) {
         this.I_field_23cb2dbc.I_field_523beb0a = "";
         this.I_field_23cb2dbc.I_field_49 = -1;
      }
   }

   private void Ii_method_3366c015() {
      this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.II_field_559a1391;
      this.I_field_23cb2dbc.i_field_5a = false;
      this.I_field_23cb2dbc.I_field_7865b31.clear();
      this.I_field_23cb2dbc.i_field_49 = 0;
   }

   private void iI_method_351b2455() {
      if (I_field_3a9bda27.currentScreen instanceof HandledScreen var1
         && I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var2) {
         String var5 = var1.getTitle().getString();
         switch (this.I_field_23cb2dbc.I_field_23cb29dc) {
            case i_field_23cb29dc:
               this.I_method_91d139c0(var2, var5);
               break;
            case II_field_23cb29dc:
               this.i_method_dff05da0(var2, var5);
               break;
            case Ii_field_23cb29dc:
               this.II_method_20d24289(var2, var5);
         }
      }
   }

   private void I_method_91d139c0(GenericContainerScreenHandler var1, String var2) {
      if (var2.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
         IiiiiiiiI_Class255.I_method_cc575c7a(var1, 12);
         this.Ii_method_3366c015();
      } else {
         if (this.I_field_23cb2dbc.I_field_559a1391 == IIiiIiii_Class56.Nested1_a5bcf9b6.II_field_559a1391
            && var2.contains("\u0412\u044b\u0431\u043e\u0440 \u041b\u0430\u0439\u0442 \u0430\u043d\u0430\u0440\u0445\u0438\u0438")) {
            int var3 = this.i_method_60bb9d49(var1);
            if (this.I_method_4376051(var1, var3)) {
               IiiiiiiiI_Class255.I_method_cc575c7a(var1, var3);
               this.ii_method_3529b035();
               return;
            }

            if (this.I_field_23cb2dbc.i_field_49 > 0) {
               this.I_field_23cb2dbc.i_field_49--;
               return;
            }

            int var4 = this.I_method_39f14169(var1);
            if (var4 == -1) {
               this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.I_field_559a1391;
               return;
            }

            if (!this.I_field_23cb2dbc.i_field_5a) {
               IiiiiiiiI_Class255.I_method_cc575c7a(var1, var4);
               this.I_field_23cb2dbc.i_field_5a = true;
               this.I_field_23cb2dbc.I_field_7865b31.add(var4);
               this.I_field_23cb2dbc.i_field_49 = 5;
               return;
            }

            this.I_field_23cb2dbc.i_field_5a = false;
         }
      }
   }

   private boolean I_method_3349afdb(int var1) {
      return switch (this.I_field_23cb2dbc.I_field_23cb29dc) {
         case I_field_23cb29dc -> {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.mode_unknown")));
            yield false;
         }
         case i_field_23cb29dc -> {
            iIIIiiiii_Class288 var2 = this.I_method_327b3a8d(var1);
            if (var2 == iIIIiiiii_Class288.iI_field_ac24da4c) {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.invalid_number")));
               yield false;
            } else {
               this.I_field_23cb2dbc.I_field_49 = var1;
               this.I_field_23cb2dbc.I_field_523beb0a = this.I_method_f7e39e06(var2);
               yield true;
            }
         }
         case II_field_23cb29dc -> {
            if (var1 >= 1 && var1 <= 3) {
               this.I_field_23cb2dbc.I_field_49 = var1;
               yield true;
            } else {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.invalid_number")));
               yield false;
            }
         }
         case Ii_field_23cb29dc -> {
            if (IiiiiiiiI_Class255.I_method_7633b877(var1) == -1) {
               iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("commands_rehub.invalid_number")));
               yield false;
            } else {
               this.I_field_23cb2dbc.I_field_49 = var1;
               yield true;
            }
         }
      };
   }

   private void i_method_dff05da0(GenericContainerScreenHandler var1, String var2) {
      if (this.I_field_23cb2dbc.I_field_559a1391 == IIiiIiii_Class56.Nested1_a5bcf9b6.Ii_field_559a1391
         && var2.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
         IiiiiiiiI_Class255.I_method_cc575c7a(var1, 10);
         this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.iI_field_559a1391;
      } else {
         if (this.I_field_23cb2dbc.I_field_559a1391 == IIiiIiii_Class56.Nested1_a5bcf9b6.iI_field_559a1391
            && var2.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0441\u0435\u0440\u0432\u0435\u0440 \u041b\u0430\u0439\u0442")) {
            int var3 = IiiiiiiiI_Class255.i_method_77f6a897(this.I_field_23cb2dbc.I_field_49);
            if (this.I_method_4376051(var1, var3)) {
               IiiiiiiiI_Class255.I_method_cc575c7a(var1, var3);
               this.ii_method_3529b035();
            }
         }
      }
   }

   private void II_method_20d24289(GenericContainerScreenHandler var1, String var2) {
      if (this.I_field_23cb2dbc.I_field_559a1391 == IIiiIiii_Class56.Nested1_a5bcf9b6.ii_field_559a1391
         && var2.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
         IiiiiiiiI_Class255.I_method_cc575c7a(var1, 15);
         this.I_field_23cb2dbc.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.III_field_559a1391;
      } else {
         if (this.I_field_23cb2dbc.I_field_559a1391 == IIiiIiii_Class56.Nested1_a5bcf9b6.III_field_559a1391
            && var2.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u041a\u043b\u0430\u0441\u0441\u0438\u0447")) {
            int var3 = IiiiiiiiI_Class255.I_method_7633b877(this.I_field_23cb2dbc.I_field_49);
            if (this.I_method_4376051(var1, var3)) {
               IiiiiiiiI_Class255.I_method_cc575c7a(var1, var3);
               this.ii_method_3529b035();
            }
         }
      }
   }

   private boolean I_method_4376051(GenericContainerScreenHandler var1, int var2) {
      return var2 >= 0 && var2 < var1.slots.size() && var1.getSlot(var2).hasStack();
   }

   private int I_method_39f14169(GenericContainerScreenHandler var1) {
      if (!this.I_field_23cb2dbc.I_field_523beb0a.isBlank()) {
         int var2 = IiiiiiiiI_Class255.I_method_53cd7d26(var1, this.I_field_23cb2dbc.I_field_523beb0a);
         if (var2 != -1 && !this.I_field_23cb2dbc.I_field_7865b31.contains(var2)) {
            return var2;
         }

         var2 = IiiiiiiiI_Class255.I_method_ba23e03a(this.I_method_54a4e16c(this.I_field_23cb2dbc.I_field_523beb0a));
         if (var2 != -1 && !this.I_field_23cb2dbc.I_field_7865b31.contains(var2)) {
            return var2;
         }
      }

      for (int var3 : IiiiiiiiI_Class255.I_method_370f5f7e(var1)) {
         if (!this.I_field_23cb2dbc.I_field_7865b31.contains(var3)) {
            return var3;
         }
      }

      return -1;
   }

   private int i_method_60bb9d49(GenericContainerScreenHandler var1) {
      return IiiiiiiiI_Class255.I_method_25e29c23(var1, "", this.I_field_23cb2dbc.I_field_49);
   }

   private iIIIiiiii_Class288 I_method_327b3a8d(int var1) {
      return IiiiiiiiI_Class255.I_method_893394fa(var1);
   }

   private iIIIiiiii_Class288 I_method_54a4e16c(String var1) {
      if (var1 == null) {
         return iIIIiiiii_Class288.iI_field_ac24da4c;
      } else if (var1.contains("\u0421\u043e\u043b\u043e")) {
         return iIIIiiiii_Class288.I_field_ac24da4c;
      } else if (var1.contains("\u0414\u0443\u043e")) {
         return iIIIiiiii_Class288.i_field_ac24da4c;
      } else if (var1.contains("\u0422\u0440\u0438\u043e")) {
         return iIIIiiiii_Class288.II_field_ac24da4c;
      } else {
         return var1.contains("\u041a\u043b\u0430\u043d") ? iIIIiiiii_Class288.Ii_field_ac24da4c : iIIIiiiii_Class288.iI_field_ac24da4c;
      }
   }

   private String I_method_f7e39e06(iIIIiiiii_Class288 var1) {
      return switch (var1) {
         case I_field_ac24da4c -> "\u0421\u043e\u043b\u043e";
         case i_field_ac24da4c -> "\u0414\u0443\u043e";
         case II_field_ac24da4c -> "\u0422\u0440\u0438\u043e";
         case Ii_field_ac24da4c -> "\u041a\u043b\u0430\u043d";
         default -> "";
      };
   }

   private void ii_method_3529b035() {
      this.I_field_23cb2dbc.I_method_5bdd9287();
      this.I_field_991c1e8c.I_method_23e11e3f();
   }

   private int I_method_2af1d89f() {
      return this.I_field_23cb2dbc.I_field_559a1771 == IIiiIiii_Class56.Nested1_a5bcf9d6.II_field_559a1771 ? iIIIiiiII_Class285.Ii_field_49 : -1;
   }

   private int i_method_2b00647f() {
      return this.I_field_23cb2dbc.I_field_559a1771 == IIiiIiii_Class56.Nested1_a5bcf9d6.II_field_559a1771
         ? iIIIiiiII_Class285.II_field_49
         : iIIIiiiII_Class285.i_field_49;
   }

   private int II_method_33583428() {
      if (this.I_field_23cb2dbc.I_field_49 > 0) {
         return this.I_field_23cb2dbc.I_field_49;
      } else {
         int var1 = iIIIiiiII_Class285.I_method_f5437df2();
         return var1 > 0 ? var1 : this.i_method_2b00647f();
      }
   }

   private IIiiIiii_Class56.Nested1_a5bcf9d6 I_method_3252f11a(IIiiIiii_Class56.Nested1_a5bcf9d6 var1) {
      if (var1 != IIiiIiii_Class56.Nested1_a5bcf9d6.I_field_559a1771) {
         return var1;
      } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c)) {
         return IIiiIiii_Class56.Nested1_a5bcf9d6.II_field_559a1771;
      } else {
         return (
                  iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)
                     || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)
               )
               && iIIIiiiII_Class285.i_field_5a
            ? IIiiIiii_Class56.Nested1_a5bcf9d6.II_field_559a1771
            : IIiiIiii_Class56.Nested1_a5bcf9d6.i_field_559a1771;
      }
   }

   private List<String> I_method_1a619bbf(Object var1) {
      return var1 == null ? List.of() : (List)var1;
   }

   private Integer I_method_78479d1d(String var1) {
      try {
         int var2 = Integer.parseInt(var1);
         return var2 > 0 ? var2 : null;
      } catch (NumberFormatException var3) {
         return null;
      }
   }

   static enum Nested1_8137a4f3 {
      I_field_23cb29dc,
      i_field_23cb29dc,
      II_field_23cb29dc,
      Ii_field_23cb29dc;
   }

   static class Nested1_8137a513 {
      boolean I_field_5a;
      IIiiIiii_Class56.Nested1_8137a4f3 I_field_23cb29dc;
      String I_field_523beb0a;
      int I_field_49;
      IIiiIiii_Class56.Nested1_a5bcf9b6 I_field_559a1391;
      boolean i_field_5a;
      int i_field_49;
      boolean II_field_5a;
      boolean Ii_field_5a;
      IIiiIiii_Class56.Nested1_a5bcf9d6 I_field_559a1771;
      boolean iI_field_5a;
      final List<Integer> I_field_7865b31;

      Nested1_8137a513() {
         this.I_field_23cb29dc = IIiiIiii_Class56.Nested1_8137a4f3.I_field_23cb29dc;
         this.I_field_523beb0a = "";
         this.I_field_49 = -1;
         this.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.I_field_559a1391;
         this.I_field_559a1771 = IIiiIiii_Class56.Nested1_a5bcf9d6.I_field_559a1771;
         this.I_field_7865b31 = new ArrayList<>();
      }

      final void I_method_5bdd9287() {
         this.I_field_5a = false;
         this.I_field_23cb29dc = IIiiIiii_Class56.Nested1_8137a4f3.I_field_23cb29dc;
         this.I_field_523beb0a = "";
         this.I_field_49 = -1;
         this.Ii_field_5a = false;
         this.I_field_559a1391 = IIiiIiii_Class56.Nested1_a5bcf9b6.I_field_559a1391;
         this.I_field_559a1771 = IIiiIiii_Class56.Nested1_a5bcf9d6.I_field_559a1771;
         this.i_field_5a = false;
         this.i_field_49 = 0;
         this.II_field_5a = false;
         this.I_field_7865b31.clear();
         this.iI_field_5a = false;
      }
   }

   static enum Nested1_a5bcf9b6 {
      I_field_559a1391,
      i_field_559a1391,
      II_field_559a1391,
      Ii_field_559a1391,
      iI_field_559a1391,
      ii_field_559a1391,
      III_field_559a1391;
   }

   static enum Nested1_a5bcf9d6 {
      I_field_559a1771,
      i_field_559a1771,
      II_field_559a1771;

      public static IIiiIiii_Class56.Nested1_a5bcf9d6 I_method_7f034b89(String var0) {
         if (var0 == null) {
            return null;
         } else {
            String var1 = var0.toLowerCase();
            if (var1.startsWith("an") || var1.contains("\u0430\u043d\u0430\u0440\u0445")) {
               return i_field_559a1771;
            } else {
               return !var1.startsWith("gr") && !var1.contains("\u0433\u0440\u0438\u0444") ? null : II_field_559a1771;
            }
         }
      }
   }
}
