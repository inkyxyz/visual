package rockstar.client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.PlayerListHudAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.network.ServerInfo.ServerType;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import pyrock.events.game.GameTickEvent;

public final class iIIIiiiII_Class285 implements iIIiIIiIi_Class294 {
   public static boolean I_field_5a;
   public static int I_field_49;
   public static int i_field_49 = -1;
   public static int II_field_49 = -1;
   public static int Ii_field_49 = -1;
   public static int iI_field_49 = -1;
   public static int ii_field_49 = -1;
   public static boolean i_field_5a;
   public static boolean II_field_5a;
   public static boolean Ii_field_5a;
   public static boolean iI_field_5a;
   public static String I_field_523beb0a = "";
   private static String i_field_523beb0a;
   private static String II_field_523beb0a;
   private static boolean ii_field_5a;
   private static iIIiIIIIi_Class290 I_field_107f3a6c;
   private static boolean III_field_5a;
   private static iIIiIIIII_Class289 I_field_107f368c = iIIiIIIII_Class289.I_field_107f368c;
   private static iIIIiiiiI_Class287 I_field_ac24d66c = iIIIiiiiI_Class287.I_field_ac24d66c;
   private static boolean IIi_field_5a;
   private static boolean IiI_field_5a;
   private static boolean Iii_field_5a;
   private static int III_field_49 = -1;
   private static int IIi_field_49 = -1;
   private static final List<Integer> I_field_7865b31 = new ArrayList<>();
   private static int IiI_field_49 = -1;
   private static int Iii_field_49 = -1;
   private static final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   static final IiIIIiII_Class69<GameTickEvent> I_field_3d936f41 = var0 -> {
      if (ii_field_5a && I_field_3a9bda27.player != null && i_method_ac7219ed(i_field_523beb0a)) {
         if (III_field_5a) {
            i_method_f55209df();
         } else {
            if (iI_method_b4fe2966()) {
               I_field_3a9bda27.player.networkHandler.sendChatCommand(II_field_523beb0a);
            }

            I_method_f5437dff();
         }
      }

      Text var1 = ((PlayerListHudAccessor)(Object)I_field_3a9bda27.inGameHud.getPlayerListHud()).getHeader();
      if (var1 != null) {
         String var2 = var1.getString();
         if (var2.contains("\u0433\u0440\u0438\u0444") && I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
            i_field_5a = true;
         } else if (var2.contains("\u0434\u0443\u044d\u043b\u0438") && I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)) {
            II_field_5a = true;
         } else if (var2.contains("1.21") && I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c)) {
            Ii_field_5a = true;
         } else if (var2.contains("\u0420\u0435\u0439\u0442\u0438\u043d\u0433") && I_method_456510cb(iIIIiiIii_Class284.Iii_field_ac164e6c)) {
            iI_field_5a = true;
         }

         if (I_method_456510cb(iIIIiiIii_Class284.Iii_field_ac164e6c)) {
            try {
               iI_field_49 = Integer.parseInt(var2.split("\u0410\u043d\u0430\u0440\u0445\u0438\u044f PvP #")[1].trim());
            } catch (Exception var6) {
            }
         }

         if (I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c)) {
            String var3 = var2.split("\u25b6")[1].replace("\u0410\u043d\u0430\u0440\u0445\u0438\u044f", "").trim();

            try {
               ii_field_49 = Integer.parseInt(var3.split("#")[1].trim());
               I_field_523beb0a = var3.split("#")[0].trim();
            } catch (Exception var5) {
            }
         }
      }
   };
   private static final Object I_field_5f790d9c = new Object() {
      private final IiIIIiII_Class69<GameTickEvent> I_field_3d936f41;

      {
         this.I_field_3d936f41 = iIIIiiiII_Class285.I_field_3d936f41;
      }
   };

   public static boolean I_method_456510cb(iIIIiiIii_Class284 var0) {
      return var0.I_method_a6cbde2d(I_method_2b105481());
   }

   public static String I_method_2b105481() {
      return I_field_3a9bda27.player != null && I_field_3a9bda27.player.networkHandler.getServerInfo() != null
         ? I_field_3a9bda27.player.networkHandler.getServerInfo().address
         : "single";
   }

   public static String i_method_be2f04a1() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.player.networkHandler.getServerInfo() != null) {
         String var0 = I_field_3a9bda27.player.networkHandler.getServerInfo().address;

         try {
            InetAddress var1 = InetAddress.getByName(var0);
            return var1.getHostAddress();
         } catch (UnknownHostException var2) {
            return var0;
         }
      } else {
         return "single";
      }
   }

   public static boolean I_method_dbbac60d(String var0) {
      return I_method_2b105481().toLowerCase().contains(var0.toLowerCase());
   }

   public static boolean I_method_f5437e03() {
      if (!I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)) {
         return false;
      } else {
         if (I_field_3a9bda27.inGameHud != null) {
            Text var0 = ((PlayerListHudAccessor)(Object)I_field_3a9bda27.inGameHud.getPlayerListHud()).getHeader();
            if (var0 != null && var0.getString().toLowerCase(Locale.ROOT).contains("\u0434\u0443\u044d\u043b")) {
               return true;
            }
         }

         boolean var5 = false;
         boolean var1 = false;

         for (String var3 : I_method_a684b668()) {
            String var4 = var3.toLowerCase(Locale.ROOT);
            if (var4.contains("\u0434\u0443\u044d\u043b")) {
               return true;
            }

            if (var4.contains("\u0443\u0431\u0438\u0439\u0441\u0442\u0432")) {
               var5 = true;
            }

            if (var4.contains("\u0441\u043c\u0435\u0440\u0442")) {
               var1 = true;
            }
         }

         return var5 && var1;
      }
   }

   public static List<String> I_method_a684b668() {
      if (I_field_3a9bda27.world == null) {
         return List.of();
      } else {
         Scoreboard var0 = I_field_3a9bda27.world.getScoreboard();
         ScoreboardObjective var1 = var0.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
         if (var1 == null) {
            return List.of();
         } else {
            ArrayList var2 = new ArrayList();

            for (ScoreboardEntry var4 : var0.getScoreboardEntries(var1)) {
               String var5 = var4.owner();
               String var6 = var4.display() == null ? var5 : var4.display().getString();
               Team var7 = var0.getScoreHolderTeam(var5);
               if (var7 != null) {
                  var6 = var7.getPrefix().getString() + var6 + var7.getSuffix().getString();
               }

               var2.add(var6);
            }

            return var2;
         }
      }
   }

   public static boolean i_method_f55209e3() {
      if (I_field_3a9bda27.inGameHud == null) {
         return false;
      } else {
         Text var0 = ((PlayerListHudAccessor)(Object)I_field_3a9bda27.inGameHud.getPlayerListHud()).getHeader();
         if (var0 == null) {
            return false;
         } else {
            String var1 = var0.getString().toLowerCase(Locale.ROOT);
            return var1.contains("funtime") || var1.contains("fun time") || var1.contains("\u0444\u0430\u043d\u0442\u0430\u0439\u043c");
         }
      }
   }

   public static String I_method_da38608b(boolean var0) {
      return I_method_a5157a15(I_method_2b105481(), var0);
   }

   public static String I_method_a5157a15(String var0, boolean var1) {
      String[] var2 = var0.split("\\.");
      if (I_method_dbbac60d("liquidproxy")) {
         return var1 ? "LP" : "LiquidProxy";
      } else if (I_field_3a9bda27.isInSingleplayer()) {
         return i_method_88d395f5(var0, var1);
      } else if (var2.length == 3) {
         return i_method_88d395f5(var2[1], var1);
      } else if (var2.length == 2) {
         return i_method_88d395f5(var2[0], var1);
      } else {
         return var0.contains(":") ? var0.split(":")[0] : var0;
      }
   }

   private static String i_method_88d395f5(String var0, boolean var1) {
      var0 = var0.replace("-", "");
      ArrayList var2 = new ArrayList();
      String[] var3 = new String[]{
         "legacy",
         "bars",
         "world",
         "best",
         "times",
         "time",
         "shine",
         "sky",
         "lands",
         "land",
         "trainer",
         "server",
         "blaze",
         "mine",
         "lord",
         "cube",
         "grief",
         "craft",
         "rise",
         "force",
         "project",
         "lite",
         "client"
      };
      Arrays.stream(var3).forEach(var1x -> var2.add(I_method_f2f3b93a(var1x)));
      var2.addAll(
         Arrays.asList(
            new iIIIiiiII_Class285.Nested1_5a593880("mc", "MC", "-MC"),
            new iIIIiiiII_Class285.Nested1_5a593880("hvh", "HVH", "-HVH"),
            new iIIIiiiII_Class285.Nested1_5a593880("pvp", "PVP", "PVP")
         )
      );
      if (I_field_3a9bda27.isInSingleplayer() && !var1) {
         var0 = "LocalHost";
      }

      if (I_method_dbbac60d("sunmc")) {
         var0 = var1 ? "SR" : "SunRise";
      }

      if (I_method_dbbac60d("saturn")) {
         var0 = var1 ? "S-X" : "SaturnX";
      }

      if (I_method_dbbac60d("sunw")) {
         var0 = var1 ? "SW" : "SunWay";
      }

      for (iIIIiiiII_Class285.Nested1_5a593880 var5 : (Iterable<iIIIiiiII_Class285.Nested1_5a593880>)(Iterable<?>)var2) {
         if (var0.contains(var5.I_field_523beb0a)) {
            if (var1) {
               var0 = var0.substring(0, 1).toUpperCase() + var5.II_field_523beb0a;
            } else {
               var0 = var0.replace(var5.I_field_523beb0a, var5.i_field_523beb0a);
               var0 = var0.substring(0, 1).toUpperCase() + var0.substring(1);
            }

            return var0;
         }
      }

      return var0.substring(0, 1).toUpperCase() + var0.substring(1);
   }

   public static boolean II_method_b33b3946() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         BlockPos var0 = I_field_3a9bda27.player.getBlockPos();
         Block var1 = I_field_3a9bda27.world.getBlockState(var0.down(1)).getBlock();
         Block var2 = I_field_3a9bda27.world.getBlockState(new BlockPos(var0.getX(), 0, var0.getZ())).getBlock();
         Block var3 = I_field_3a9bda27.world.getBlockState(new BlockPos(var0.getX(), 6, var0.getZ())).getBlock();
         if (I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) && I_field_3a9bda27.world.getDifficulty() == Difficulty.NORMAL) {
            return false;
         } else if (I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) || I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)) {
            return var1 == Blocks.AIR || var2 == Blocks.AIR;
         } else if (I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c)) {
            return var3 == Blocks.SAND;
         } else {
            return I_field_3a9bda27.world.getRegistryKey() != World.OVERWORLD ? false : var2 == Blocks.BEDROCK || var1 == Blocks.BEDROCK;
         }
      } else {
         return false;
      }
   }

   private static iIIIiiiII_Class285.Nested1_5a593880 I_method_f2f3b93a(String var0) {
      return new iIIIiiiII_Class285.Nested1_5a593880(var0, var0.substring(0, 1).toUpperCase() + var0.substring(1), var0.substring(0, 1).toUpperCase());
   }

   public static int I_method_f5437df2() {
      if (I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
         if (i_field_5a) {
            return II_field_49;
         } else {
            return I_field_3a9bda27.world.getDifficulty() == Difficulty.EASY ? -1 : i_field_49;
         }
      } else if (I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c)) {
         return II_field_5a ? 1 : i_field_49;
      } else {
         return I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c) ? ii_field_49 : -1;
      }
   }

   public static void I_method_a697df93(String var0, String var1) {
      if (I_field_3a9bda27 != null) {
         i_field_523beb0a = I_method_d6c4e1b7(var0);
         String var2 = i_method_f6e3c9d7(var1);
         II_field_523beb0a = var2;
         II_method_b33b3942();
         boolean var3 = false;
         if (i_method_8a55fb77(i_field_523beb0a, var2)) {
            Integer var4 = I_method_b8d454f0(var2);
            int var5 = IiiiiiiiI_Class255.i_method_77f6a897(var4);
            if (var5 >= 0) {
               i_method_b4efa504(var5);
               var3 = true;
            }
         }

         if (!var3 && II_method_b17a755a(i_field_523beb0a, var2)) {
            Integer var8 = I_method_b8d454f0(var2);
            int var11 = IiiiiiiiI_Class255.I_method_7633b877(var8);
            if (var11 >= 0) {
               II_method_b42c6201(var11);
               var3 = true;
            }
         }

         if (!var3 && I_method_a697df97(i_field_523beb0a, var2)) {
            iIIiIIIIi_Class290 var9 = I_method_cd4c765f(var2);
            if (var9 != null) {
               I_method_3342fcc7(var9);
               var3 = true;
            }
         }

         ii_field_5a = true;
         boolean var10 = i_method_ac7219ed(i_field_523beb0a);
         if (!var10 && I_field_3a9bda27.getCurrentServerEntry() != null) {
            String var12 = I_field_3a9bda27.getCurrentServerEntry().address;
            if (var12 != null) {
               var10 = I_method_d6c4e1b7(var12).equals(i_field_523beb0a);
            }
         }

         if (var10) {
            if (I_field_3a9bda27.player != null && iI_method_b4fe2966()) {
               I_field_3a9bda27.player.networkHandler.sendChatCommand(II_field_523beb0a);
               I_method_f5437dff();
            }
         } else {
            String var13 = II_method_f8270794(i_field_523beb0a);
            ServerInfo var6 = new ServerInfo(var13, i_field_523beb0a, ServerType.OTHER);
            I_field_3a9bda27.disconnect();
            I_field_3a9bda27.execute(
               () -> ConnectScreen.connect(new MultiplayerScreen(new TitleScreen()), I_field_3a9bda27, ServerAddress.parse(i_field_523beb0a), var6, false, null)
            );
         }
      }
   }

   private static void I_method_f5437dff() {
      i_field_523beb0a = null;
      II_field_523beb0a = null;
      ii_field_5a = false;
      II_method_b33b3942();
   }

   private static boolean i_method_ac7219ed(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         String var1 = I_method_2b105481();
         return var1 != null && !var1.equals("single") ? I_method_d6c4e1b7(var1).equals(var0) : false;
      } else {
         return false;
      }
   }

   private static void i_method_f55209df() {
      if (III_field_5a && I_field_3a9bda27.player != null) {
         if (I_field_ac24d66c == iIIIiiiiI_Class287.I_field_ac24d66c) {
            I_method_f5437dff();
         } else if (I_field_ac24d66c == iIIIiiiiI_Class287.i_field_ac24d66c && I_field_107f3a6c == null) {
            I_method_f5437dff();
         } else if (I_field_ac24d66c == iIIIiiiiI_Class287.II_field_ac24d66c && IiI_field_49 < 0) {
            I_method_f5437dff();
         } else if (I_field_ac24d66c == iIIIiiiiI_Class287.Ii_field_ac24d66c && Iii_field_49 < 0) {
            I_method_f5437dff();
         } else if (!IIi_field_5a) {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("hub");
            IIi_field_5a = true;
            I_field_991c1e8c.I_method_23e11e3f();
         } else if (!IiI_field_5a) {
            if (I_field_991c1e8c.I_method_58432069(600L)) {
               I_field_3a9bda27.player.networkHandler.sendChatCommand("menu");
               IiI_field_5a = true;
               I_field_991c1e8c.I_method_23e11e3f();
            }
         } else if (I_field_3a9bda27.currentScreen == null) {
            iIIiIIIII_Class289 var5 = I_method_93b482f5();
            if (I_field_107f368c != var5) {
               I_field_107f368c = var5;
               Iii_field_5a = false;
            }

            if (I_field_991c1e8c.I_method_58432069(2000L)) {
               I_field_3a9bda27.player.networkHandler.sendChatCommand("menu");
               I_field_991c1e8c.I_method_23e11e3f();
            }
         } else if (I_field_3a9bda27.currentScreen instanceof HandledScreen var0) {
            if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var6) {
               String var7 = var0.getTitle().getString();
               if (I_field_ac24d66c == iIIIiiiiI_Class287.i_field_ac24d66c
                  && var7.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")
                  && I_field_107f368c != iIIiIIIII_Class289.i_field_107f368c) {
                  Iii_field_5a = false;
                  I_field_107f368c = iIIiIIIII_Class289.i_field_107f368c;
               }

               if (var7.contains("\u0412\u044b\u0431\u043e\u0440 \u041b\u0430\u0439\u0442 \u0430\u043d\u0430\u0440\u0445\u0438\u0438")
                  && I_field_107f368c == iIIiIIIII_Class289.i_field_107f368c) {
                  I_field_107f368c = iIIiIIIII_Class289.II_field_107f368c;
                  Iii_field_5a = false;
               }

               if (I_field_ac24d66c == iIIIiiiiI_Class287.i_field_ac24d66c) {
                  if (I_field_107f368c == iIIiIIIII_Class289.i_field_107f368c) {
                     if (var7.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
                        IiiiiiiiI_Class255.I_method_cc575c7a(var6, 12);
                        I_field_107f368c = iIIiIIIII_Class289.II_field_107f368c;
                        I_field_991c1e8c.I_method_23e11e3f();
                     }
                  } else if (I_field_107f368c == iIIiIIIII_Class289.II_field_107f368c) {
                     if (var7.contains("\u0412\u044b\u0431\u043e\u0440 \u041b\u0430\u0439\u0442 \u0430\u043d\u0430\u0440\u0445\u0438\u0438")) {
                        int var8 = IiiiiiiiI_Class255.I_method_25e29c23(var6, "", I_field_107f3a6c.I_method_ba934a12());
                        if (var8 >= 0) {
                           IiiiiiiiI_Class255.I_method_cc575c7a(var6, var8);
                           I_method_f5437dff();
                           return;
                        }

                        if (!Iii_field_5a) {
                           if (III_field_49 < 0) {
                              I_method_f5437dff();
                              return;
                           }

                           IiiiiiiiI_Class255.I_method_cc575c7a(var6, III_field_49);
                           I_field_7865b31.add(III_field_49);
                           Iii_field_5a = true;
                           I_field_107f368c = iIIiIIIII_Class289.Ii_field_107f368c;
                           I_field_991c1e8c.I_method_23e11e3f();
                        }
                     }
                  } else {
                     if (I_field_107f368c == iIIiIIIII_Class289.Ii_field_107f368c
                        && var7.contains("\u0412\u044b\u0431\u043e\u0440 \u041b\u0430\u0439\u0442 \u0430\u043d\u0430\u0440\u0445\u0438\u0438")) {
                        int var3 = IiiiiiiiI_Class255.I_method_25e29c23(var6, "", I_field_107f3a6c.I_method_ba934a12());
                        if (var3 >= 0) {
                           IiiiiiiiI_Class255.I_method_cc575c7a(var6, var3);
                           I_method_f5437dff();
                           return;
                        }

                        if (!I_field_991c1e8c.I_method_58432069(250L)) {
                           return;
                        }

                        int var4 = I_method_cc31f33c(var6);
                        if (var4 < 0) {
                           I_method_f5437dff();
                           return;
                        }

                        IiiiiiiiI_Class255.I_method_cc575c7a(var6, var4);
                        I_field_7865b31.add(var4);
                        I_field_991c1e8c.I_method_23e11e3f();
                     }
                  }
               } else if (I_field_ac24d66c == iIIIiiiiI_Class287.II_field_ac24d66c) {
                  if (I_field_107f368c == iIIiIIIII_Class289.iI_field_107f368c) {
                     if (var7.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
                        IiiiiiiiI_Class255.I_method_cc575c7a(var6, 10);
                        I_field_107f368c = iIIiIIIII_Class289.ii_field_107f368c;
                        I_field_991c1e8c.I_method_23e11e3f();
                     }
                  } else {
                     if (I_field_107f368c == iIIiIIIII_Class289.ii_field_107f368c
                        && var7.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0441\u0435\u0440\u0432\u0435\u0440 \u041b\u0430\u0439\u0442")) {
                        if (IiI_field_49 < 0) {
                           I_method_f5437dff();
                           return;
                        }

                        if (IiI_field_49 < var6.slots.size() && var6.getSlot(IiI_field_49).hasStack()) {
                           IiiiiiiiI_Class255.I_method_cc575c7a(var6, IiI_field_49);
                           I_method_f5437dff();
                        }
                     }
                  }
               } else {
                  if (I_field_ac24d66c == iIIIiiiiI_Class287.Ii_field_ac24d66c) {
                     if (I_field_107f368c == iIIiIIIII_Class289.III_field_107f368c) {
                        if (var7.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0440\u0435\u0436\u0438\u043c")) {
                           IiiiiiiiI_Class255.I_method_cc575c7a(var6, 15);
                           I_field_107f368c = iIIiIIIII_Class289.IIi_field_107f368c;
                           I_field_991c1e8c.I_method_23e11e3f();
                        }

                        return;
                     }

                     if (I_field_107f368c == iIIiIIIII_Class289.IIi_field_107f368c
                        && var7.contains("\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u041a\u043b\u0430\u0441\u0441\u0438\u043a")) {
                        if (Iii_field_49 < 0) {
                           I_method_f5437dff();
                           return;
                        }

                        if (Iii_field_49 < var6.slots.size() && var6.getSlot(Iii_field_49).hasStack()) {
                           IiiiiiiiI_Class255.I_method_cc575c7a(var6, Iii_field_49);
                           I_method_f5437dff();
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private static void II_method_b33b3942() {
      I_field_107f3a6c = null;
      III_field_5a = false;
      I_field_107f368c = iIIiIIIII_Class289.I_field_107f368c;
      IIi_field_5a = false;
      I_field_ac24d66c = iIIIiiiiI_Class287.I_field_ac24d66c;
      IiI_field_5a = false;
      Iii_field_5a = false;
      III_field_49 = -1;
      I_field_7865b31.clear();
      IiI_field_49 = -1;
      Iii_field_49 = -1;
      IIi_field_49 = -1;
      I_field_991c1e8c.I_method_23e11e3f();
   }

   private static iIIiIIIII_Class289 I_method_93b482f5() {
      return switch (I_field_ac24d66c) {
         case i_field_ac24d66c -> iIIiIIIII_Class289.i_field_107f368c;
         case II_field_ac24d66c -> iIIiIIIII_Class289.iI_field_107f368c;
         case Ii_field_ac24d66c -> iIIiIIIII_Class289.III_field_107f368c;
         default -> iIIiIIIII_Class289.I_field_107f368c;
      };
   }

   private static void I_method_3342fcc7(iIIiIIIIi_Class290 var0) {
      I_field_107f3a6c = var0;
      III_field_5a = true;
      I_field_107f368c = iIIiIIIII_Class289.i_field_107f368c;
      IIi_field_5a = false;
      IiI_field_5a = false;
      Iii_field_5a = false;
      I_field_ac24d66c = iIIIiiiiI_Class287.i_field_ac24d66c;
      III_field_49 = var0.i_method_baa1d5f2();
      IIi_field_49 = var0.II_method_97e4f115();
      I_field_7865b31.clear();
      I_field_991c1e8c.I_method_23e11e3f();
      II_field_523beb0a = null;
   }

   private static boolean I_method_a697df97(String var0, String var1) {
      return var0 != null && var1 != null ? II_method_f2f15690(var0) && var1.toLowerCase().startsWith("lite") : false;
   }

   private static iIIiIIIIi_Class290 I_method_cd4c765f(String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.replaceAll("[^0-9]", "");
         if (var1.isEmpty()) {
            return null;
         } else {
            int var2;
            try {
               var2 = Integer.parseInt(var1);
            } catch (NumberFormatException var6) {
               return null;
            }

            iIIIiiiii_Class288 var3 = I_method_4b0fd95a(var2);
            if (var3 == iIIIiiiii_Class288.iI_field_ac24da4c) {
               return null;
            } else {
               int var4 = IiiiiiiiI_Class255.I_method_ba23e03a(var3);
               int var5 = I_method_404e32f(var3, var2);
               return var4 >= 0 && var5 >= 0 ? new iIIiIIIIi_Class290(var2, var3, var4, var5) : null;
            }
         }
      }
   }

   private static iIIIiiiii_Class288 I_method_4b0fd95a(int var0) {
      return IiiiiiiiI_Class255.I_method_893394fa(var0);
   }

   private static int I_method_404e32f(iIIIiiiii_Class288 var0, int var1) {
      return IiiiiiiiI_Class255.I_method_8a589b8f(var0, var1);
   }

   private static int I_method_cc31f33c(GenericContainerScreenHandler var0) {
      for (int var2 : IiiiiiiiI_Class255.I_method_370f5f7e(var0)) {
         if (!I_field_7865b31.contains(var2)) {
            return var2;
         }
      }

      for (iIIIiiiii_Class288 var4 : iIIIiiiii_Class288.values()) {
         if (var4 != iIIIiiiii_Class288.iI_field_ac24da4c) {
            int var5 = IiiiiiiiI_Class255.I_method_ba23e03a(var4);
            if (!I_field_7865b31.contains(var5) && var5 < var0.slots.size() && var0.getSlot(var5).hasStack()) {
               return var5;
            }
         }
      }

      return -1;
   }

   private static boolean II_method_f2f15690(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         String var1 = II_method_f8270794(var0).toLowerCase();
         return var1.contains("holy") || var1.contains("holly") || var1.contains("playhw") || var1.equals("hw") || var1.startsWith("hw.");
      } else {
         return false;
      }
   }

   private static void i_method_b4efa504(int var0) {
      I_field_107f3a6c = null;
      III_field_5a = true;
      I_field_107f368c = iIIiIIIII_Class289.iI_field_107f368c;
      I_field_ac24d66c = iIIIiiiiI_Class287.II_field_ac24d66c;
      IIi_field_5a = false;
      IiI_field_5a = false;
      Iii_field_5a = false;
      III_field_49 = -1;
      IIi_field_49 = -1;
      IiI_field_49 = var0;
      Iii_field_49 = -1;
      I_field_991c1e8c.I_method_23e11e3f();
      II_field_523beb0a = null;
   }

   private static void II_method_b42c6201(int var0) {
      I_field_107f3a6c = null;
      III_field_5a = true;
      I_field_107f368c = iIIiIIIII_Class289.III_field_107f368c;
      I_field_ac24d66c = iIIIiiiiI_Class287.Ii_field_ac24d66c;
      IIi_field_5a = false;
      IiI_field_5a = false;
      Iii_field_5a = false;
      III_field_49 = -1;
      IIi_field_49 = -1;
      IiI_field_49 = -1;
      Iii_field_49 = var0;
      I_field_991c1e8c.I_method_23e11e3f();
      II_field_523beb0a = null;
   }

   private static String I_method_d6c4e1b7(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         String var1 = var0.trim().toLowerCase();
         if (!var1.contains(":")) {
            var1 = var1 + ":25565";
         }

         return var1;
      } else {
         return "";
      }
   }

   private static boolean i_method_8a55fb77(String var0, String var1) {
      if (var0 != null && var1 != null) {
         String var2 = var1.toLowerCase();
         return II_method_f2f15690(var0) && (var2.startsWith("lite120") || var2.startsWith("lite 120"));
      } else {
         return false;
      }
   }

   private static boolean II_method_b17a755a(String var0, String var1) {
      if (var0 != null && var1 != null) {
         String var2 = var1.toLowerCase();
         return II_method_f2f15690(var0) && (var2.startsWith("classik") || var2.startsWith("classic"));
      } else {
         return false;
      }
   }

   private static String i_method_f6e3c9d7(String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.trim();
         if (var1.startsWith("/")) {
            var1 = var1.substring(1);
         }

         return var1;
      }
   }

   private static boolean iI_method_b4fe2966() {
      return II_field_523beb0a != null
         && !II_field_523beb0a.isEmpty()
         && (I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) || I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c));
   }

   private static Integer I_method_b8d454f0(String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.replaceAll("[^0-9]", "");
         if (var1.isEmpty()) {
            return null;
         } else {
            try {
               return Integer.parseInt(var1);
            } catch (NumberFormatException var3) {
               return null;
            }
         }
      }
   }

   private static String II_method_f8270794(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         int var1 = var0.lastIndexOf(58);
         return var1 >= 0 ? var0.substring(0, var1) : var0;
      } else {
         return "";
      }
   }

   public static boolean Ii_method_b349c526() {
      Text var0 = ((PlayerListHudAccessor)(Object)I_field_3a9bda27.inGameHud.getPlayerListHud()).getHeader();
      String var1 = var0 != null ? var0.getString() : "\u0445\u0443\u0439";
      return I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c)
         || var1.toLowerCase().contains("holyworld")
         || var1.toLowerCase().contains("\u0440\u0435\u0436\u0438\u043cpvp");
   }

   @Generated
   private iIIIiiiII_Class285() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(I_field_5f790d9c);
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   @Generated
   public static void I_method_b32cf4b5(boolean var0) {
      I_field_5a = var0;
   }

   @Generated
   public static void I_method_b32cb4e4(int var0) {
      I_field_49 = var0;
   }

   static final class Nested1_5a593880 {
      final String I_field_523beb0a;
      final String i_field_523beb0a;
      final String II_field_523beb0a;

      Nested1_5a593880(String var1, String var2, String var3) {
         this.I_field_523beb0a = var1;
         this.i_field_523beb0a = var2;
         this.II_field_523beb0a = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_5a593880[orig=" + this.I_field_523beb0a + ", big=" + this.i_field_523beb0a + ", small=" + this.II_field_523beb0a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_523beb0a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIiiiII_Class285.Nested1_5a593880 other = (iIIIiiiII_Class285.Nested1_5a593880) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.i_field_523beb0a, other.i_field_523beb0a)
            && java.util.Objects.equals(this.II_field_523beb0a, other.II_field_523beb0a);
      }

      public String I_method_4b6074a6() {
         return this.I_field_523beb0a;
      }

      public String i_method_de7f24c6() {
         return this.i_field_523beb0a;
      }

      public String II_method_26080c19() {
         return this.II_field_523beb0a;
      }
   }
}
