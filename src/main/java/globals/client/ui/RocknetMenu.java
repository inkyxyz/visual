package globals.client.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import globals.client.Activities;
import globals.client.Chat;
import globals.client.Cosmetics;
import globals.client.Information;
import globals.client.Mentions;
import globals.client.RocknetListener;
import globals.client.WorldKey;
import globals.client.messages.CordsMessage;
import globals.client.messages.Message;
import globals.client.messages.ReplyMessage;
import globals.client.messages.ShareMessage;
import globals.shared.proto.Packet;
import globals.shared.proto.Packets;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.network.ServerInfo.ServerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.Rect;
import rockstar.client.III;
import rockstar.client.IIII;
import rockstar.client.GlobalsMenuModule;
import rockstar.client.InventoryBuilderModule;
import rockstar.client.SoundsModule;
import rockstar.client.GuiMoveModule;
import rockstar.client.IIIi_Class2;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.MenuModule;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiIi_Class6;
import rockstar.client.IIi_Class2;
import rockstar.client.IIii_Class4;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIiIIIII_Class161;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiIIiI_Class83;
import rockstar.client.IiIi_Class6;
import rockstar.client.IiIiiIIiI_Class179;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIIiiiI_Class207;
import rockstar.client.IiiI_Class7;
import rockstar.client.Iii_Class4;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iIIiIIIii_Class292;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIi_Class6;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iIiiiiIii_Class380;
import rockstar.client.iiIIiIII_Class201;
import rockstar.client.iiIIiIIi_Class202;
import rockstar.client.iiI_Class7;
import rockstar.client.iiIiIIIII_Class417;
import rockstar.client.iii_Class8;
import ua.mintantileak.spk.Compile;

public class RocknetMenu extends IiiIIiiiI_Class207 implements iIIiIIiIi_Class294 {
   private static final float WINDOW_W = 500.0F;
   private static final float WINDOW_H = 320.0F;
   private static final float PAGE_PAD = 7.0F;
   private static final float GAP = 7.0F;
   private static final float SIDEBAR_W = 138.0F;
   private static final float R_WINDOW = 12.0F;
   private static final float R_CARD = 10.0F;
   private static final float R_ROW = 7.0F;
   private static final float R_PILL = 5.0F;
   private static final float R_BUBBLE = 8.0F;
   private static final float R_BUBBLE_TIGHT = 3.0F;
   private static final float HEAD_H = 32.0F;
   private static final float ROW_H = 28.0F;
   private static final float INPUT_H = 22.0F;
   private static final float SEARCH_H = 18.0F;
   private static final float TABS_H = 18.0F;
   private static final float LIST_PAD_X = 10.0F;
   private static final float LIST_PAD_Y = 8.0F;
   private static final float MENTION_ROW_H = 20.0F;
   private static final float MENTION_PAD = 3.0F;
   private static final float MENTION_GAP = 2.0F;
   private static final float MENTION_W = 150.0F;
   private static final int MENTION_LIMIT = 5;
   private static final float HEAD_CLICK_W = 130.0F;
   private static final float AVATAR = 18.0F;
   private static final float CHAT_BADGE_SIZE = 8.0F;
   private static final float OPEN_MS = 280.0F;
   private static final float CLOSE_MS = 200.0F;
   private static final float RECENTER_HIDDEN_FRACTION = 0.35F;
   private static final float HISTORY_TRIGGER = 60.0F;
   private static final long HISTORY_COOLDOWN = 1500L;
   private static final long PEOPLE_SEARCH_DELAY = 350L;
   private static final long LIST_REFRESH = 200L;
   private static final IiiiIiiII_Class237 CIRC_OUT = IiiiIiiII_Class237.I_method_ae57f375(0.0, 0.55, 0.45, 1.0);
   private static final IIii_Class4 STATE = IIii_Class4.I_method_3682ece9(150L, IiiiIiiII_Class237.III_field_dd60aac);
   private static final IIii_Class4 LIST = IIii_Class4.I_method_f17ae5cb(420.0F, 34.0F);
   private static final IIii_Class4 MOVE = IIii_Class4.I_method_3682ece9(260L, CIRC_OUT);
   private static final IIii_Class4 MENU_HOVER = IIii_Class4.I_method_3682ece9(120L, IiiiIiiII_Class237.III_field_dd60aac);
   private static final IIii_Class4 MENU_MOTION = IIii_Class4.I_method_3682ece9(160L, IiiiIiiII_Class237.I_method_ae57f375(0.0, 0.0, 0.58, 1.0));
   private static final IiiI_Class7 MENU_OPEN = (var0, var1, var2) -> {
      var2.I_field_46 = var0;
      var2.Ii_field_46 = 0.97F + 0.03F * var0;
      var2.II_field_46 = (1.0F - var2.Ii_field_46) * var1.h() / 2.0F - (1.0F - var0) * 3.0F;
   };
   private static final float R_MENU = 8.0F;
   private static final float MENU_PAD = 3.0F;
   private static final float MENU_GAP = 2.0F;
   private static final float MENU_ICON = 6.0F;
   private static final float MENU_ITEM_PAD = 4.0F;
   private static final float MENU_ITEM_H = 16.0F;
   private static final float MENU_TITLE_H = 14.0F;
   private static final float MENU_EMPTY_H = 22.0F;
   private static final float MENU_MIN_W = 84.0F;
   private static final float MENU_MAX_W = 150.0F;
   private static final float MENU_LIST_H = 96.0F;
   private static final ColorRGBA ONLINE = new ColorRGBA(90.0F, 200.0F, 96.0F);
   private static final ColorRGBA DANGER = new ColorRGBA(214.0F, 102.0F, 102.0F);
   private static final float PROFILE_W = 210.0F;
   private static final float PROFILE_VALUE_W = 70.0F;
   private static final float PROFILE_STACK = 40.32F;
   private static final float PROFILE_BLUR = 2.0F;
   private static final SimpleDateFormat DATE = new SimpleDateFormat("dd.MM.yyyy");
   private static final SimpleDateFormat TIME = new SimpleDateFormat("dd.MM HH:mm");
   private static final String GLOBAL_CHAT_ID = Information.GLOBAL_CHAT;
   private final Rect menuWindow = new Rect(0.0F, 0.0F, 500.0F, 320.0F);
   private final IiIiIIIII_Class161 sendField;
   private final IiIiIIIII_Class161 friendField;
   private final IiIiIIIII_Class161 searchField;
   private final IiIiIIIII_Class161 peopleField;
   private final AuthForm form = new AuthForm();
   private iii_Class8 activeMenu;
   private boolean peopleOpen;
   private iii_Class8 peopleList;
   private final Map<String, iii_Class8> personRows = new HashMap<>();
   private List<String> peopleSnapshot = List.of();
   private String muteTarget;
   private int muteDays;
   private int muteHours;
   private int muteMinutes = 30;
   private String pendingQuery = "";
   private long queryChangedAt;
   private RocknetMenu.Nested1_bc4301f2 tab = RocknetMenu.Nested1_bc4301f2.CHATS;
   Chat currentChat = Information.chats().isEmpty() ? Information.byName(GLOBAL_CHAT_ID) : Information.chats().getFirst();
   private long reply = -1L;
   private long lastReply = -1L;
   private List<String> mentionOptions = List.of();
   private List<String> mentionShown = List.of();
   private int mentionIndex;
   private String mentionDismissed;
   private String mentionPending;
   private final IiiiIiIii_Class236 mentionAppear = new IiiiIiIii_Class236(160L, IiiiIiiII_Class237.III_field_dd60aac);
   private iii_Class8 window;
   private iii_Class8 sidebarList;
   private Iii_Class4 messagesBox;
   private final Map<String, iii_Class8> userRows = new HashMap<>();
   private final Map<String, iii_Class8> requestRows = new HashMap<>();
   private final Map<String, Iii_Class4> placeholders = new HashMap<>();
   private iii_Class8 globalRow;
   private List<String> sidebarSnapshot = List.of();
   private long sidebarCheckedAt;
   private long peopleCheckedAt;
   private List<String> dialogs = List.of();
   private float windowX = Float.NaN;
   private float windowY = Float.NaN;
   private long openStart;
   private float lastMouseX;
   private float lastMouseY;

   public RocknetMenu() {
      this.sendField = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F));
      this.sendField.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("message") + "...");
      this.friendField = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F));
      this.friendField.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.friend_placeholder"));
      this.searchField = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F));
      this.searchField.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.search_placeholder"));
      this.peopleField = new IiIiIIIII_Class161(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F));
      this.peopleField.II_method_e557b20c(IiIiIIII_Class81.I_method_f25a980a("rocknet.people.search"));
      this.setReply(-1L);
   }

   @Compile(
      obfuscation = 4
   )
   @Override
   public void init() {
      super.init();
      this.closing = false;
      this.contentAlpha = 1.0F;
      this.openStart = System.currentTimeMillis();
      this.clearRoots();
      this.overlays.clear();
      this.activeMenu = null;
      this.userRows.clear();
      this.requestRows.clear();
      this.placeholders.clear();
      this.sidebarSnapshot = List.of();
      this.personRows.clear();
      this.peopleSnapshot = List.of();
      this.mentionOptions = List.of();
      this.mentionShown = List.of();
      this.mentionDismissed = null;
      this.mentionPending = null;
      this.mentionAppear.I_method_edd6dd21(0.0F);
      this.peopleOpen = false;
      this.muteTarget = null;
      Information.closeProfile();
      if (Float.isNaN(this.windowX)) {
         this.windowX = Math.round((this.width - 500.0F) / 2.0F);
         this.windowY = Math.round((this.height - 320.0F) / 2.0F);
      }

      this.windowX = Math.max(-460.0F, Math.min(this.width - 40.0F, this.windowX));
      this.windowY = Math.max(0.0F, Math.min(Math.max(0.0F, this.height - 40.0F), this.windowY));
      this.build();
      this.rebuildSidebar(true);
   }

   private void build() {
      iii_Class8 var1 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_70a38517(7.0F)
         .IiI_method_23cb1575()
         .I_method_879bc687(() -> Information.getUser() != null)
         .I_method_8939bffd(this.buildSidebar())
         .I_method_8939bffd(this.buildContent());
      iii_Class8 var2 = new iii_Class8().IiI_method_23cb1575().I_method_879bc687(() -> Information.getUser() == null).I_method_f136b1d8((var1x, var2x) -> {
         float var3 = 160.0F;
         float var4 = this.form.isLogin() ? 109.0F : 132.0F;
         this.form.set(var2x.x() + var2x.w() / 2.0F - var3 / 2.0F, var2x.y() + var2x.h() / 2.0F - var4 / 2.0F, var3, var4);
         this.form.render(var1x);
      });
      this.window = new iii_Class8()
         .iI_method_c1109a58()
         .i_method_f6ad2537(7.0F)
         .i_method_8c7d3515(500.0F, 320.0F)
         .I_method_84672d76(IIii_Class4.II_field_f93678c1)
         .I_method_8361fbbd(iIi_Class6.i_field_b583ea6c)
         .I_method_f136b1d8((var0, var1x) -> {
            var0.drawShadow(var1x.x(), var1x.y(), var1x.w(), var1x.h(), 26.0F, IIiii_Class8.I_method_893b2757(12.0F), ColorRGBA.BLACK.withAlpha(45.9F));
            var0.drawRoundedRect(var1x.x(), var1x.y(), var1x.w(), var1x.h(), IIiii_Class8.I_method_893b2757(12.0F), page());
         })
         .I_method_8939bffd(var1)
         .I_method_8939bffd(var2)
         .I_method_8939bffd(this.buildProfileCard());
      this.window.iii_method_df275535();
      this.window.snapSize();
      this.window.snapAt(this.windowX, this.windowY);
      applyMotion(this.window);
      this.add(this.window);
   }

   private static void applyMotion(iiI_Class7 var0) {
      var0.motion(MOVE);
      if (var0 instanceof iii_Class8 var1) {
         var1.I_method_38e5328().forEach(RocknetMenu::applyMotion);
      }
   }

   private iii_Class8 buildSidebar() {
      this.sidebarList = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(2.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(5.0F, 4.0F, 5.0F, 4.0F))
         .IIi_method_4dfc88d7(138.0F)
         .IIi_method_1df35135()
         .Ii_method_5967a054(120.0F)
         .Ii_method_bb38d618()
         .I_method_3987f136(IiIi_Class6.I_field_f9448c81)
         .I_method_b65baecb(
            var0 -> var0.i_method_65326e43(-2.0F)
               .II_method_e6aaaac(3.0F)
               .I_method_2a080a63(2.5F)
               .Ii_method_49950e8c(16.0F)
               .iI_method_388cc2cc(1.25F)
               .ii_method_73b726ac(1000.0F)
               .i_method_989a5f71(var0x -> stroke().mix(second(), var0x.I_method_af833bdc() + var0x.i_method_af91c7bc()))
         );
      iii_Class8 var1 = new iii_Class8()
         .I_method_485bccf5()
         .IIi_method_4dfc88d7(138.0F)
         .IIi_method_1df35135()
         .iI_method_e886414(10.0F)
         .I_method_e53800a9(var0 -> card())
         .I_method_8939bffd(this.sidebarList);
      return new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(7.0F)
         .IIi_method_4dfc88d7(138.0F)
         .IIi_method_1df35135()
         .I_method_8939bffd(this.buildTabs())
         .I_method_8939bffd(this.buildSearchRow())
         .I_method_8939bffd(var1)
         .I_method_8939bffd(this.buildSelfCard());
   }

   private iii_Class8 buildTabs() {
      iii_Class8 var1 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_70a38517(2.0F)
         .i_method_f6ad2537(2.0F)
         .IiI_method_31d4c97(18.0F)
         .III_method_9dc17555()
         .iI_method_e886414(7.0F)
         .I_method_e53800a9(var0 -> card());

      for (RocknetMenu.Nested1_bc4301f2 var5 : RocknetMenu.Nested1_bc4301f2.values()) {
         var1.I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fillHeight()
               .radius(5.0F)
               .text(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
                  () -> this.tabTitle(var5),
                  var0 -> second().mix(text(), var0.hover()).mix(onAccent(), var0.sig("active"))
               )
               .textAlign(IIi_Class2.i_field_b5755e8c)
               .background(var0 -> accent().mulAlpha(var0.sig("active")))
               .bind("active", () -> this.tab == var5, STATE)
               .hoverMotion(STATE)
               .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
               .onClick(() -> this.selectTab(var5))
         );
      }

      return var1;
   }

   private String tabTitle(RocknetMenu.Nested1_bc4301f2 var1) {
      return switch (var1) {
         case CHATS -> IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.chats");
         case FRIENDS -> Information.getRequests().isEmpty()
            ? IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.tab_friends")
            : IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.tab_friends") + " " + Information.getRequests().size();
      };
   }

   private void selectTab(RocknetMenu.Nested1_bc4301f2 var1) {
      if (this.tab != var1) {
         this.tab = var1;
         if (this.sidebarList != null) {
            this.sidebarList.i_method_815a851f();
         }

         this.rebuildSidebar(true);
      }
   }

   private iii_Class8 buildSelfCard() {
      iii_Class8 var1 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(3.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(
            this.nickBox(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F),
               9.0F,
               () -> Information.getUser() == null ? "" : Information.getUser().username(),
               Cosmetics::selfNick,
               Cosmetics::selfBadge,
               var0 -> text()
            )
         )
         .I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fade()
               .text(
                  IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
                  () -> Activities.translate(RockstarClient.getInstance().I_method_cd3d46d0().getActivity()),
                  var0 -> second()
               )
               .interactive(false)
         );
      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .IiI_method_31d4c97(32.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 7.0F))
         .iI_method_e886414(10.0F)
         .I_method_e53800a9(var0 -> card())
         .I_method_8361fbbd(iIi_Class6.i_field_b583ea6c)
         .I_method_8939bffd(this.avatarBox(18.0F, Information::getSelfAvatar, () -> true))
         .I_method_8939bffd(var1);
   }

   private iii_Class8 buildSearchRow() {
      Iii_Class4 var1 = new Iii_Class4()
         .height(18.0F)
         .fillWidth()
         .radius(7.0F)
         .background(var0 -> card())
         .cursor(iIIIiIIIi_Class274.iI_field_aa52e62c)
         .onClick(() -> this.activeField().I_method_fb5b3035(true))
         .paint(
            (var1x, var2x) -> {
               float var3 = (var2x.h() - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_a649725c()) / 2.0F;
               var1x.drawIcon(
                  this.tab == RocknetMenu.Nested1_bc4301f2.FRIENDS ? "plus" : "search", var2x.x() + var3, var2x.y() + var2x.h() / 2.0F - 3.0F, 6.0F, second()
               );
               IiIiIIIII_Class161 var4 = this.activeField();
               (var4 == this.friendField ? this.searchField : this.friendField).I_method_b043bcc(0.0F, 0.0F, 0.0F, 0.0F);
               var4.I_method_b043bcc(var2x.x() + 10.0F, var2x.y(), var2x.w() - 14.0F, var2x.h());
               var4.I_method_13a617e0(text());
               var4.I_method_7ae26dda(var1x);
            }
         );
      Iii_Class4 var2 = this.iconButton("plus", 18.0F, 7.0F, this::sendFriendRequest);
      var2.visibleWhen(() -> this.tab == RocknetMenu.Nested1_bc4301f2.FRIENDS);
      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(5.0F)
         .IiI_method_31d4c97(18.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(var1)
         .I_method_8939bffd(var2);
   }

   private IiIiIIIII_Class161 activeField() {
      return this.tab == RocknetMenu.Nested1_bc4301f2.FRIENDS ? this.friendField : this.searchField;
   }

   private void rebuildSidebar(boolean var1) {
      if (this.sidebarList != null && Information.getUser() != null) {
         long var2 = System.currentTimeMillis();
         if (var1 || var2 - this.sidebarCheckedAt >= 200L) {
            this.sidebarCheckedAt = var2;
            String var4 = this.searchField.I_method_d2579001().trim().toLowerCase();
            ArrayList var5 = new ArrayList();
            var5.add(this.tab.name() + ":" + var4);
            List var6 = List.of();
            List var7 = List.of();
            if (this.tab == RocknetMenu.Nested1_bc4301f2.CHATS) {
               this.dialogs = this.openDialogs();

               for (String var9 : this.dialogs) {
                  var5.add("c:" + var9);
               }
            } else {
               var6 = Information.getRequests();
               var7 = Information.getSortedFriends();

               for (String var14 : (Iterable<String>)(Iterable<?>)var6) {
                  var5.add("r:" + var14);
               }

               for (Packets.Nested1_1da0dac9 var15 : (Iterable<Packets.Nested1_1da0dac9>)(Iterable<?>)var7) {
                  var5.add("f:" + var15.username());
               }
            }

            if (var1 || !var5.equals(this.sidebarSnapshot)) {
               this.sidebarSnapshot = var5;
               ArrayList var13 = new ArrayList();
               switch (this.tab) {
                  case CHATS:
                     if (this.globalRow == null) {
                        this.globalRow = this.buildGlobalRow();
                     }

                     if (var4.isEmpty() || IiIiIIII_Class81.I_method_f25a980a("rocknet.chat.global.name").toLowerCase().contains(var4)) {
                        var13.add(this.globalRow);
                     }

                     for (String var20 : this.dialogs) {
                        if (var4.isEmpty() || var20.toLowerCase().contains(var4)) {
                           var13.add(this.userRows.computeIfAbsent(var20, this::buildUserRow));
                        }
                     }

                     if (var13.isEmpty()) {
                        var13.add(this.placeholder("rocknet.menu.nothing_found"));
                     }
                     break;
                  case FRIENDS:
                     for (String var10 : (Iterable<String>)(Iterable<?>)var6) {
                        var13.add(this.requestRows.computeIfAbsent(var10, this::buildRequestRow));
                     }

                     for (Packets.Nested1_1da0dac9 var19 : (Iterable<Packets.Nested1_1da0dac9>)(Iterable<?>)var7) {
                        var13.add(this.userRows.computeIfAbsent(var19.username(), this::buildUserRow));
                     }

                     if (var13.isEmpty()) {
                        var13.add(this.placeholder("rocknet.menu.no_friends"));
                     }
               }

               this.sidebarList.II_method_244860a9(var13);
            }
         }
      }
   }

   private List<String> openDialogs() {
      List var1 = Information.dialogs();
      String var2 = this.currentChat.getName();
      if (!var2.equals(GLOBAL_CHAT_ID) && !var1.contains(var2)) {
         var1.add(0, var2);
      }

      return var1;
   }

   private void syncPeers() {
      String var1 = this.currentChat.getName();
      if (!var1.equals(GLOBAL_CHAT_ID) && this.friend(var1) == null) {
         Information.refreshPeer(var1);
      }

      if (this.tab == RocknetMenu.Nested1_bc4301f2.CHATS) {
         for (String var3 : this.dialogs) {
            if (this.friend(var3) == null) {
               Information.refreshPeer(var3);
            }
         }
      }
   }

   private Iii_Class4 placeholder(String var1) {
      return this.placeholders
         .computeIfAbsent(
            var1,
            var0 -> new Iii_Class4()
               .height(28.0F)
               .fillWidth()
               .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), () -> IiIiIIII_Class81.I_method_f25a980a(var0), var0x -> second())
               .textAlign(IIi_Class2.i_field_b5755e8c)
               .motion(MOVE)
               .interactive(false)
         );
   }

   private iii_Class8 buildGlobalRow() {
      return this.chatRow(
         () -> RockstarClient.id("rocknet/avatar.png"),
         null,
         () -> IiIiIIII_Class81.I_method_f25a980a("rocknet.chat.global.name"),
         () -> null,
         () -> null,
         this::globalPreview,
         () -> this.currentChat.getName().equals(GLOBAL_CHAT_ID),
         var1 -> this.openChat(GLOBAL_CHAT_ID)
      );
   }

   private iii_Class8 buildUserRow(String var1) {
      return this.chatRow(
         () -> Information.getAvatar(var1),
         () -> this.online(var1),
         () -> var1,
         () -> this.nickStyle(var1),
         () -> this.badge(var1),
         () -> this.rowStatus(var1),
         () -> this.currentChat.getName().equals(var1),
         var2 -> {
            if (var2 == IiIII_Class9.i_field_2f4c8d6c) {
               this.openFriendMenu(var1);
            } else {
               this.openChat(var1);
            }
         }
      );
   }

   private iii_Class8 chatRow(
      Supplier<Identifier> var1,
      BooleanSupplier var2,
      Supplier<String> var3,
      Supplier<String> var4,
      Supplier<String> var5,
      Supplier<String> var6,
      BooleanSupplier var7,
      Consumer<IiIII_Class9> var8
   ) {
      Iii_Class4 var9 = this.nickBox(
         IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), 8.0F, var3, var4, var5, var0 -> text().mulAlpha(0.72F + 0.28F * var0.sig("active"))
      );
      var9.bind("active", var7, STATE);
      iii_Class8 var10 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(3.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(var9)
         .I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fade()
               .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), throttled(var6), var0 -> second())
               .interactive(false)
         );
      iii_Class8 var11 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .IiI_method_31d4c97(28.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 5.0F))
         .iI_method_e886414(7.0F)
         .I_method_e53800a9(var0 -> highlight(0.05F * var0.sig("active") + 0.03F * var0.hover()))
         .I_method_350d9c12("active", var7, STATE)
         .II_method_77bdb679(STATE)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(this.avatarBox(18.0F, var1, var2))
         .I_method_8939bffd(var10)
         .i_method_5db1deeb(var8);
      applyMotion(var11);
      var11.II_method_32b63e79(IiiI_Class7.IiI_field_f94500c1).i_method_b358e156(LIST).I_method_84672d76(LIST);
      return var11;
   }

   private static Supplier<String> throttled(final Supplier<String> var0) {
      return new Supplier<String>() {
         private String value;
         private long at;

         public String get() {
            long var1 = System.currentTimeMillis();
            if (this.value == null || var1 - this.at >= 200L) {
               this.value = (String)var0.get();
               this.at = var1;
            }

            return this.value;
         }
      };
   }

   private iii_Class8 buildRequestRow(String var1) {
      Iii_Class4 var2 = this.iconButton("check", 14.0F, 7.0F, () -> {
         RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_9ecd102e(var1));
         this.dropRequest(var1);
      });
      Iii_Class4 var3 = this.iconButton("xmark", 14.0F, 7.0F, () -> {
         RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_bbeecec5(var1));
         this.dropRequest(var1);
      });
      var3.icon("xmark", 7.0F, var0 -> DANGER.mulAlpha(0.75F + 0.25F * var0.hover()));
      iii_Class8 var4 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .IiI_method_31d4c97(28.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 5.0F))
         .iI_method_e886414(7.0F)
         .I_method_e53800a9(var0 -> highlight(0.03F * var0.hover()))
         .II_method_77bdb679(STATE)
         .I_method_8939bffd(this.avatarBox(18.0F, () -> Information.getAvatar(var1), null))
         .I_method_8939bffd(
            this.nickBox(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), 8.0F, () -> var1, () -> null, () -> null, var0 -> text()).fillWidth()
         )
         .I_method_8939bffd(var2)
         .I_method_8939bffd(var3);
      applyMotion(var4);
      var4.II_method_32b63e79(IiiI_Class7.IiI_field_f94500c1).i_method_b358e156(LIST).I_method_84672d76(LIST);
      return var4;
   }

   private void dropRequest(String var1) {
      ArrayList var2 = new ArrayList<>(Information.getRequests());
      if (var2.remove(var1)) {
         Information.setRequests(var2);
         this.rebuildSidebar(true);
      }
   }

   private iii_Class8 buildContent() {
      iii_Class8 var1 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(7.0F)
         .IiI_method_23cb1575()
         .I_method_8939bffd(this.buildChatHeader())
         .I_method_8939bffd(this.buildChatBody())
         .I_method_8939bffd(this.buildComposer());
      return new iii_Class8().iI_method_c1109a58().IiI_method_23cb1575().I_method_8939bffd(var1).I_method_8939bffd(this.buildPeoplePanel());
   }

   private iii_Class8 buildChatHeader() {
      iii_Class8 var1 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(3.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(
            this.nickBox(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F),
               9.0F,
               this::chatTitle,
               () -> this.currentChat.getName().equals(GLOBAL_CHAT_ID) ? null : this.nickStyle(this.currentChat.getName()),
               () -> this.currentChat.getName().equals(GLOBAL_CHAT_ID) ? null : this.badge(this.currentChat.getName()),
               var0 -> text()
            )
         )
         .I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fade()
               .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), this::chatSubtitle, var0 -> second())
               .interactive(false)
         );
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .IIi_method_4dfc88d7(130.0F)
         .IIi_method_1df35135()
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(this.avatarBox(18.0F, this::chatAvatar, null))
         .I_method_8939bffd(var1)
         .i_method_5db1deeb(var1x -> {
            if (var1x == IiIII_Class9.I_field_2f4c8d6c) {
               if (this.currentChat.getName().equals(GLOBAL_CHAT_ID)) {
                  this.togglePeople();
               } else {
                  this.openProfile(this.currentChat.getName());
               }
            }
         });
      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .IiI_method_31d4c97(32.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
         .iI_method_e886414(10.0F)
         .I_method_e53800a9(var0 -> card())
         .I_method_8361fbbd(iIi_Class6.i_field_b583ea6c)
         .I_method_8939bffd(var2);
   }

   private iii_Class8 buildPeoplePanel() {
      this.peopleList = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(2.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(4.0F, 4.0F, 4.0F, 4.0F))
         .IiI_method_23cb1575()
         .Ii_method_5967a054(120.0F)
         .Ii_method_bb38d618()
         .I_method_3987f136(IiIi_Class6.I_field_f9448c81)
         .I_method_b65baecb(
            var0 -> var0.i_method_65326e43(-2.0F)
               .II_method_e6aaaac(3.0F)
               .I_method_2a080a63(2.5F)
               .Ii_method_49950e8c(16.0F)
               .iI_method_388cc2cc(1.25F)
               .ii_method_73b726ac(1000.0F)
               .i_method_989a5f71(var0x -> stroke().mix(second(), var0x.I_method_af833bdc() + var0x.i_method_af91c7bc()))
         );
      Iii_Class4 var1 = new Iii_Class4()
         .height(18.0F)
         .fillWidth()
         .radius(7.0F)
         .background(var0 -> highlight(0.04F))
         .cursor(iIIIiIIIi_Class274.iI_field_aa52e62c)
         .onClick(() -> this.peopleField.I_method_fb5b3035(true))
         .paint((var1x, var2x) -> {
            float var3x = (var2x.h() - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_a649725c()) / 2.0F;
            var1x.drawIcon("search", var2x.x() + var3x, var2x.y() + var2x.h() / 2.0F - 3.0F, 6.0F, second());
            this.peopleField.I_method_b043bcc(var2x.x() + 10.0F, var2x.y(), var2x.w() - 14.0F, var2x.h());
            this.peopleField.I_method_13a617e0(text());
            this.peopleField.I_method_7ae26dda(var1x);
         });
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .IiI_method_31d4c97(32.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 9.0F))
         .I_method_8939bffd(
            new iii_Class8()
               .I_method_485bccf5()
               .I_method_70a38517(3.0F)
               .III_method_9dc17555()
               .I_method_8939bffd(
                  new Iii_Class4()
                     .fillWidth()
                     .fade()
                     .text(
                        IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F),
                        () -> IiIiIIII_Class81.I_method_f25a980a("rocknet.people.title"),
                        var0 -> text()
                     )
                     .interactive(false)
               )
               .I_method_8939bffd(
                  new Iii_Class4()
                     .fillWidth()
                     .fade()
                     .text(
                        IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
                        () -> IiIiIIII_Class81.I_method_1410d1e5("rocknet.menu.subtitle_online", RocknetListener.getSiteOnline(), RocknetListener.getOnline()),
                        var0 -> second()
                     )
                     .interactive(false)
               )
         )
         .I_method_8939bffd(this.iconButton("xmark", 14.0F, 7.0F, this::togglePeople));
      iii_Class8 var3 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(4.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(5.0F, 5.0F, 5.0F, 5.0F))
         .IiI_method_23cb1575()
         .iI_method_e886414(10.0F)
         .I_method_e53800a9(var0 -> card())
         .i_method_5db1deeb(var0 -> {})
         .I_method_8939bffd(var2)
         .I_method_8939bffd(var1)
         .I_method_8939bffd(this.peopleList);
      var3.Iii_method_a3fcf155().I_method_879bc687(() -> this.peopleOpen).II_method_32b63e79(IiiI_Class7.II_field_f94500c1);
      applyMotion(var3);
      return var3;
   }

   private void togglePeople() {
      this.peopleOpen = !this.peopleOpen;
      this.closeMenu();
      if (this.peopleOpen) {
         this.peopleField.II_method_fb6974c2();
         this.personRows.clear();
         this.peopleSnapshot = List.of();
         this.peopleCheckedAt = 0L;
         Information.resetPeople();
         Information.requestPeople("", 0);
      } else {
         this.peopleField.I_method_fb5b3035(false);
      }
   }

   private void rebuildPeople() {
      if (this.peopleList != null && this.peopleOpen) {
         long var1 = System.currentTimeMillis();
         if (var1 - this.peopleCheckedAt >= 200L) {
            this.peopleCheckedAt = var1;
            List var3 = Information.getPeople();
            ArrayList var4 = new ArrayList();

            for (Packets.Nested1_2dfe6b80 var6 : (Iterable<Packets.Nested1_2dfe6b80>)(Iterable<?>)var3) {
               var4.add(var6.username());
            }

            var4.add(Information.isPeopleMore() ? "+" : "-");
            var4.add(this.peopleState());
            if (!var4.equals(this.peopleSnapshot)) {
               this.peopleSnapshot = var4;
               ArrayList var8 = new ArrayList();

               for (Packets.Nested1_2dfe6b80 var7 : (Iterable<Packets.Nested1_2dfe6b80>)(Iterable<?>)var3) {
                  var8.add(this.personRows.computeIfAbsent(var7.username(), this::buildPersonRow));
               }

               if (var3.isEmpty()) {
                  var8.add(this.placeholder(this.peopleState()));
               } else if (Information.isPeopleMore()) {
                  var8.add(this.moreRow());
               }

               this.peopleList.II_method_244860a9(var8);
            }
         }
      }
   }

   private String peopleState() {
      if (Information.peopleFailed()) {
         return "rocknet.people.failed";
      } else {
         return Information.isPeopleLoading() ? "rocknet.people.loading" : "rocknet.menu.nothing_found";
      }
   }

   private Iii_Class4 moreRow() {
      return new Iii_Class4()
         .height(20.0F)
         .fillWidth()
         .radius(7.0F)
         .text(
            IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
            () -> IiIiIIII_Class81.I_method_f25a980a(Information.isPeopleLoading() ? "rocknet.people.loading" : "rocknet.people.more"),
            var0 -> second().mix(text(), var0.hover())
         )
         .textAlign(IIi_Class2.i_field_b5755e8c)
         .background(var0 -> highlight(0.03F * var0.hover()))
         .hoverMotion(STATE)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick(() -> Information.requestPeople(Information.getPeopleQuery(), Information.getPeoplePage() + 1));
   }

   private iii_Class8 buildPersonRow(String var1) {
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .IiI_method_31d4c97(28.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 5.0F))
         .iI_method_e886414(7.0F)
         .I_method_e53800a9(var0 -> highlight(0.03F * var0.hover()))
         .II_method_77bdb679(STATE)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c)
         .I_method_8939bffd(
            this.avatarBox(18.0F, () -> Information.getAvatar(var1), () -> Information.person(var1) != null && Information.person(var1).online())
         )
         .I_method_8939bffd(
            new iii_Class8()
               .I_method_485bccf5()
               .I_method_70a38517(3.0F)
               .III_method_9dc17555()
               .I_method_8939bffd(
                  this.nickBox(
                     IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
                     8.0F,
                     () -> var1,
                     () -> Information.person(var1) == null ? null : Information.person(var1).nickStyle(),
                     () -> Information.person(var1) == null ? null : Information.person(var1).badge(),
                     var0 -> text()
                  )
               )
               .I_method_8939bffd(
                  new Iii_Class4()
                     .fillWidth()
                     .fade()
                     .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), throttled(() -> this.personStatus(var1)), var0 -> second())
                     .interactive(false)
               )
         )
         .i_method_5db1deeb(var2x -> {
            if (var2x == IiIII_Class9.i_field_2f4c8d6c) {
               this.openModerationMenu(var1);
            } else {
               this.openProfile(var1);
            }
         });
      applyMotion(var2);
      var2.II_method_32b63e79(IiiI_Class7.IiI_field_f94500c1).i_method_b358e156(LIST).I_method_84672d76(LIST);
      return var2;
   }

   private void syncPeopleQuery() {
      if (this.peopleOpen) {
         String var1 = this.peopleField.I_method_d2579001().trim();
         if (!var1.equals(this.pendingQuery)) {
            this.pendingQuery = var1;
            this.queryChangedAt = System.currentTimeMillis();
         } else if (!var1.equals(Information.getPeopleQuery()) && this.queryChangedAt != 0L) {
            if (System.currentTimeMillis() - this.queryChangedAt >= 350L) {
               this.queryChangedAt = 0L;
               this.personRows.clear();
               this.peopleCheckedAt = 0L;
               Information.resetPeople();
               Information.requestPeople(var1, 0);
               if (this.peopleList != null) {
                  this.peopleList.i_method_815a851f();
               }
            }
         }
      }
   }

   private String personStatus(String var1) {
      Packets.Nested1_2dfe6b80 var2 = Information.person(var1);
      if (var2 == null) {
         return "";
      } else if (var2.online()) {
         return IiIiIIII_Class81.I_method_f25a980a("rocknet.people.online");
      } else {
         return var2.lastSeen() > 0L ? IiIiIIiI_Class83.I_method_d9078808(var2.lastSeen()) : IiIiIIII_Class81.I_method_f25a980a("rocknet.status.offline");
      }
   }

   private iii_Class8 buildChatBody() {
      this.messagesBox = new Iii_Class4() {
         @Override
         public boolean mouseScrolled(float var1, float var2, float var3, float var4) {
            if (!this.contains(var1, var2)) {
               return false;
            } else {
               RocknetMenu.this.currentChat.getScrollHandler().I_method_93fbf5df(-var4 * 2.5);
               return true;
            }
         }
      };
      this.messagesBox.fill().paint(this::paintMessages).onClick(this::clickMessages);
      return new iii_Class8()
         .I_method_485bccf5()
         .IiI_method_23cb1575()
         .iI_method_e886414(10.0F)
         .I_method_e53800a9(var0 -> card())
         .I_method_8939bffd(this.messagesBox);
   }

   private iii_Class8 buildComposer() {
      IIiIIi_Class10 var1 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
      Iii_Class4 var2 = new Iii_Class4()
         .height(var1.I_method_a649725c())
         .fillWidth()
         .paint(
            (var2x, var3x) -> {
               Message var4x = this.currentChat.getMessage(this.lastReply);
               if (var4x != null) {
                  CosmeticRender.draw(
                     var2x,
                     var1,
                     IiIiIIII_Class81.I_method_1410d1e5("rocknet.menu.reply_to", var4x.author().username()),
                     var3x.x(),
                     var3x.y(),
                     null,
                     null,
                     text(),
                     0.0F,
                     var3x.w()
                  );
               }
            }
         )
         .interactive(false);
      Iii_Class4 var3 = new Iii_Class4().fillWidth().fade().text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), () -> {
         Message var1x = this.currentChat.getMessage(this.lastReply);
         return var1x == null ? "" : var1x.text();
      }, var0 -> second()).interactive(false);
      iii_Class8 var4 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(6.0F)
         .IiI_method_31d4c97(22.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 7.0F))
         .iI_method_e886414(7.0F)
         .I_method_e53800a9(var0 -> card())
         .I_method_8939bffd(new iii_Class8().I_method_485bccf5().I_method_70a38517(3.0F).III_method_9dc17555().I_method_8939bffd(var2).I_method_8939bffd(var3))
         .I_method_8939bffd(this.iconButton("xmark", 12.0F, 6.0F, () -> this.setReply(-1L)));
      var4.I_method_e16e9925(() -> this.reply != -1L, IiiiIiiII_Class237.III_field_dd60aac, 260L)
         .IIiI_method_185ffdf8()
         .II_method_32b63e79(IiiI_Class7.II_field_f94500c1);
      Iii_Class4 var5 = new Iii_Class4()
         .height(22.0F)
         .fillWidth()
         .radius(7.0F)
         .background(var0 -> card())
         .cursor(iIIIiIIIi_Class274.iI_field_aa52e62c)
         .onClick(() -> this.sendField.I_method_fb5b3035(!Information.muted()))
         .paint((var1x, var2x) -> {
            if (Information.muted()) {
               this.sendField.I_method_b043bcc(0.0F, 0.0F, 0.0F, 0.0F);
               float var3x = (var2x.h() - IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F).I_method_a649725c()) / 2.0F;
               var1x.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), this.muteNotice(), var2x.x() + var3x, var2x.y() + var3x, second());
            } else {
               this.sendField.I_method_b043bcc(var2x.x(), var2x.y(), var2x.w() - 4.0F, var2x.h());
               this.sendField.I_method_13a617e0(text());
               this.sendField.I_method_7ae26dda(var1x);
            }
         });
      Iii_Class4 var6 = this.iconButton("plus", 22.0F, 8.0F, this::openActionsMenu);
      Iii_Class4 var7 = new Iii_Class4()
         .size(22.0F, 22.0F)
         .padding(7.0F)
         .radius(7.0F)
         .icon("play", 8.0F, var0 -> second().mix(onAccent(), var0.sig("ready")))
         .background(var0 -> card().mix(accent().mix(accentHover(), var0.hover()), var0.sig("ready")))
         .bind("ready", () -> !this.sendField.I_method_d2579001().isBlank(), STATE)
         .hoverMotion(STATE)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick(this::sendMessage);
      iii_Class8 var8 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(5.0F)
         .IiI_method_31d4c97(22.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(var6)
         .I_method_8939bffd(var5)
         .I_method_8939bffd(var7);
      iii_Class8 var9 = new iii_Class8().I_method_485bccf5().I_method_70a38517(4.0F).III_method_9dc17555().I_method_8939bffd(var4).I_method_8939bffd(var8);
      var9.I_method_879bc687(() -> !this.peopleOpen).IIiI_method_185ffdf8().II_method_32b63e79(IiiI_Class7.II_field_f94500c1);
      return var9;
   }

   private void syncMentions() {
      if (this.mentionPending != null) {
         this.applyMention(this.mentionPending);
         this.mentionPending = null;
      }

      String var1 = this.sendField.I_method_189fd283() && !Information.muted() ? Mentions.typed(this.sendField.I_method_d2579001()) : null;
      if (var1 == null) {
         this.mentionDismissed = null;
         this.setMentionOptions(List.of());
      } else if (!var1.equals(this.mentionDismissed)) {
         this.mentionDismissed = null;
         this.setMentionOptions(this.mentionCandidates(var1));
      }
   }

   private List<String> mentionCandidates(String var1) {
      int var2 = this.mentionFit();
      String var3 = Information.getPreferUser() == null ? "" : Information.getPreferUser().username();
      LinkedHashSet var4 = new LinkedHashSet();
      List var5 = this.currentChat.messagesSnapshot();

      for (int var6 = var5.size() - 1; var6 >= 0; var6--) {
         var4.add(((Message)var5.get(var6)).author().username());
      }

      for (Packets.Nested1_1da0dac9 var7 : Information.getFriends()) {
         var4.add(var7.username());
      }

      for (Packets.Nested1_2dfe6b80 var12 : Information.getPeople()) {
         var4.add(var12.username());
      }

      ArrayList var11 = new ArrayList();

      for (String var8 : (Iterable<String>)(Iterable<?>)var4) {
         if (var8 != null && !var8.equalsIgnoreCase(var3) && (var1.isEmpty() || var8.regionMatches(true, 0, var1, 0, var1.length()))) {
            var11.add(var8);
            if (var11.size() >= var2) {
               break;
            }
         }
      }

      return List.copyOf(var11);
   }

   private int mentionFit() {
      if (this.messagesBox != null && !(this.messagesBox.h() <= 0.0F)) {
         float var1 = this.messagesBox.h() - 16.0F - 6.0F;
         int var2 = (int)((var1 + 2.0F) / 22.0F);
         return Math.max(1, Math.min(5, var2));
      } else {
         return 5;
      }
   }

   private void setMentionOptions(List<String> var1) {
      if (!var1.equals(this.mentionOptions)) {
         this.mentionOptions = var1;
         this.mentionIndex = 0;
         if (!var1.isEmpty()) {
            this.mentionShown = var1;
         }
      }
   }

   private Rect mentionArea() {
      float var1 = Math.min(150.0F, this.messagesBox.w() - 20.0F);
      float var2 = 6.0F + this.mentionShown.size() * 20.0F + Math.max(0, this.mentionShown.size() - 1) * 2.0F;
      return new Rect(this.messagesBox.x() + 10.0F, this.messagesBox.y() + this.messagesBox.h() - 8.0F - var2, var1, var2);
   }

   private boolean mentionsVisible() {
      return !this.mentionShown.isEmpty() && this.mentionAppear.I_method_6ac4da6f() > 0.01F;
   }

   private void drawMentions(III var1) {
      this.mentionAppear.I_method_edd6dd11(this.mentionOptions.isEmpty() ? 0.0F : 1.0F);
      if (this.mentionsVisible()) {
         Rect var2 = this.mentionArea();
         float var3 = RenderSystem.getShaderColor()[3];
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.mentionAppear.I_method_6ac4da6f() * var3);
         var1.drawShadow(
            var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight(), 20.0F, IIiii_Class8.I_method_893b2757(8.0F), ColorRGBA.BLACK.withAlpha(191.25F)
         );
         var1.drawRoundedRect(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight(), IIiii_Class8.I_method_893b2757(8.0F), inset());
         IIiIIi_Class10 var4 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
         float var5 = var2.getWidth() - 6.0F;
         float var6 = 12.0F;
         float var7 = var2.getY() + 3.0F;

         for (int var8 = 0; var8 < this.mentionShown.size(); var8++) {
            String var9 = this.mentionShown.get(var8);
            boolean var10 = iIIiIIIiI_Class291.I_method_da20b32b(var2.getX() + 3.0F, var7, var5, 20.0, var1);
            float var11 = var8 == this.mentionIndex ? 0.07F : (var10 ? 0.04F : 0.0F);
            if (var11 > 0.0F) {
               var1.drawRoundedRect(var2.getX() + 3.0F, var7, var5, 20.0F, IIiii_Class8.I_method_893b2757(5.0F), highlight(var11));
            }

            if (var10) {
               iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }

            var1.drawRoundedTexture(
               Information.getAvatar(var9),
               var2.getX() + 3.0F + 4.0F,
               var7 + (20.0F - var6) / 2.0F,
               var6,
               var6,
               IIiii_Class8.I_method_893b2757(var6 / 2.0F),
               ColorRGBA.WHITE
            );
            CosmeticRender.draw(
               var1,
               var4,
               "@" + var9,
               var2.getX() + 3.0F + 4.0F + var6 + 5.0F,
               var7 + (20.0F - var4.I_method_a649725c()) / 2.0F,
               null,
               null,
               text(),
               0.0F,
               var5 - var6 - 13.0F
            );
            var7 += 22.0F;
         }

         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var3);
      }
   }

   private boolean clickMentions(IiIII_Class9 var1, float var2, float var3) {
      if (this.mentionsVisible() && !this.mentionOptions.isEmpty()) {
         Rect var4 = this.mentionArea();
         if (!iIIiIIIiI_Class291.I_method_4667d3d9(var4, var2, var3)) {
            return false;
         } else if (var1 != IiIII_Class9.I_field_2f4c8d6c) {
            return true;
         } else {
            int var5 = (int)((var3 - var4.getY() - 3.0F) / 22.0F);
            if (var5 >= 0 && var5 < this.mentionShown.size()) {
               this.mentionPending = this.mentionShown.get(var5);
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private void applyMention(String var1) {
      String var2 = Mentions.complete(this.sendField.I_method_d2579001(), var1);
      if (var2 != null) {
         this.sendField.I_method_1d5afa89(var2);
         this.sendField.I_method_fb5b3035(true);
         this.setMentionOptions(List.of());
         this.mentionDismissed = null;
         this.mentionPending = null;
      }
   }

   private iii_Class8 buildProfileCard() {
      iii_Class8 var1 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(6.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(9.0F, 9.0F, 9.0F, 9.0F))
         .IIi_method_4dfc88d7(210.0F)
         .iI_method_e886414(10.0F)
         .I_method_e53800a9(var0 -> inset())
         .i_method_5db1deeb(var0 -> {})
         .I_method_8939bffd(this.profileHead())
         .I_method_8939bffd(this.profileMutual())
         .I_method_8939bffd(this.profileRow("rocknet.profile.status", this::profileStatus))
         .I_method_8939bffd(this.profileRow("rocknet.profile.playtime", this::profilePlaytime))
         .I_method_8939bffd(this.profileRow("rocknet.profile.registered", this::profileRegistered))
         .I_method_8939bffd(this.profileMuteRow())
         .I_method_8939bffd(this.profileActions());
      iii_Class8 var2 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_fe5d8d56(IIIi_Class2.i_field_f93600a1)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .IiI_method_23cb1575()
         .I_method_f136b1d8(this::paintProfileBackdrop)
         .i_method_5db1deeb(var1x -> this.closeProfile())
         .Iii_method_a3fcf155()
         .I_method_8939bffd(var1);
      var2.I_method_879bc687(this::profileOpen).II_method_32b63e79(IiiI_Class7.II_field_f94500c1);
      applyMotion(var2);
      return var2;
   }

   private void paintProfileBackdrop(III var1, iii_Class8 var2) {
      float var3 = var2.x() - 7.0F;
      float var4 = var2.y() - 7.0F;
      float var5 = var2.w() + 14.0F;
      float var6 = var2.h() + 14.0F;
      IIiii_Class8 var7 = IIiii_Class8.I_method_893b2757(12.0F);
      iIiiiiIii_Class380.I_method_5f4b621f();
      iIiiIIiii_Class360.I_field_6424b12c.I_method_8b2cf43c(1, 2.0F);
      iIiiIIiii_Class360.I_method_eceab8e4(1);

      try {
         var1.drawBlurredRect(var3, var4, var5, var6, 8.0F, var7, ColorRGBA.WHITE);
      } finally {
         iIiiIIiii_Class360.I_method_49b4f9ff();
      }

      var1.drawRoundedRect(var3, var4, var5, var6, var7, page().mulAlpha(0.55F));
   }

   private iii_Class8 profileHead() {
      iii_Class8 var1 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(3.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(
            this.nickBox(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(10.0F),
               10.0F,
               this::profileName,
               () -> this.profile() == null ? null : this.profile().nickStyle(),
               () -> this.profile() == null ? null : this.profile().badge(),
               var0 -> text()
            )
         )
         .I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fade()
               .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), this::profileTitleLine, var0 -> second())
               .interactive(false)
         );
      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(
            this.avatarBox(
               24.0F, () -> Information.getAvatar(this.profileTarget()), () -> this.profile() != null && this.profile().online(), RocknetMenu::inset
            )
         )
         .I_method_8939bffd(var1);
   }

   private iii_Class8 profileMutual() {
      Iii_Class4 var1 = new Iii_Class4()
         .size(40.32F, 18.0F)
         .interactive(false)
         .paint(
            (var1x, var2x) -> {
               Packets.Nested1_a7cdbede var3 = this.profile();
               if (var3 != null) {
                  float var4 = 11.16F;

                  for (int var5 = 0; var5 < var3.mutual().size(); var5++) {
                     float var6 = var2x.x() + var5 * var4;
                     var1x.drawRoundedRect(var6 - 1.0F, var2x.y() - 1.0F, 20.0F, 20.0F, IIiii_Class8.I_method_893b2757(10.0F), inset());
                     var1x.drawRoundedTexture(
                        Information.getAvatar(var3.mutual().get(var5)), var6, var2x.y(), 18.0F, 18.0F, IIiii_Class8.I_method_893b2757(9.0F), ColorRGBA.WHITE
                     );
                  }
               }
            }
         );
      iii_Class8 var2 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(7.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(var1)
         .I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fade()
               .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), this::profileMutualText, var0 -> second())
               .interactive(false)
         );
      var2.I_method_879bc687(() -> this.profile() != null && this.profile().mutualCount() > 0).IIiI_method_185ffdf8();
      return var2;
   }

   private iii_Class8 profileRow(String var1, Supplier<String> var2) {
      return new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(5.0F)
         .IiI_method_31d4c97(14.0F)
         .III_method_9dc17555()
         .I_method_f136b1d8(
            (var0, var1x) -> var0.drawRoundedRect(var1x.x(), var1x.y() + var1x.h() - 1.0F, var1x.w(), 1.0F, IIiii_Class8.I_field_2d98a52c, stroke10())
         )
         .I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fade()
               .text(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), () -> IiIiIIII_Class81.I_method_f25a980a(var1), var0 -> second())
               .interactive(false)
         )
         .I_method_8939bffd(
            new Iii_Class4()
               .height(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F).I_method_a649725c())
               .width(70.0F)
               .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), var2, var0 -> text())
               .textAlign(IIi_Class2.II_field_b5755e8c)
               .interactive(false)
         );
   }

   private iii_Class8 profileMuteRow() {
      iii_Class8 var1 = this.profileRow("rocknet.mod.title", () -> {
         Packets.Nested1_a7cdbede var1x = this.profile();
         if (var1x == null) {
            return "";
         } else {
            return var1x.mutedUntil() < 0L ? IiIiIIII_Class81.I_method_f25a980a("rocknet.mod.forever") : TIME.format(new Date(var1x.mutedUntil()));
         }
      });
      var1.I_method_879bc687(() -> this.profile() != null && this.profile().mutedUntil() != 0L).IIiI_method_185ffdf8();
      return var1;
   }

   private iii_Class8 profileActions() {
      iii_Class8 var1 = this.profileButton("plane", "rocknet.profile.message", false, () -> {
         String var1x = this.profileTarget();
         this.closeProfile();
         if (this.peopleOpen) {
            this.togglePeople();
         }

         this.openChat(var1x);
      });
      var1.I_method_879bc687(() -> this.profile() != null && !this.isSelfProfile()).IIiI_method_185ffdf8();
      iii_Class8 var2 = this.profileButton("plus", "rocknet.profile.add_friend", false, () -> {
         RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_17a3bc2e(this.profileTarget()));
         this.closeProfile();
      });
      var2.I_method_879bc687(() -> this.profile() != null && !this.isSelfProfile() && "none".equals(this.profile().relationship())).IIiI_method_185ffdf8();
      iii_Class8 var3 = this.profileButton("trash", "remove", true, () -> {
         RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_8e89c4ad(this.profileTarget()));
         this.closeProfile();
      });
      var3.I_method_879bc687(() -> this.profile() != null && "friends".equals(this.profile().relationship())).IIiI_method_185ffdf8();
      iii_Class8 var4 = this.profileButton("path", "rocknet.profile.site", false, () -> {
         Util.getOperatingSystem().open("https://rockstar.pub/users/" + this.profileTarget());
         this.closeProfile();
      });
      iii_Class8 var5 = this.profileButton("hud/handcuffs", "rocknet.mod.title", false, () -> this.openModerationMenu(this.profileTarget()));
      var5.I_method_879bc687(() -> Information.staff() && this.profile() != null && !this.isSelfProfile()).IIiI_method_185ffdf8();
      return new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(2.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(var1)
         .I_method_8939bffd(var2)
         .I_method_8939bffd(var3)
         .I_method_8939bffd(var4)
         .I_method_8939bffd(var5);
   }

   private iii_Class8 profileButton(String var1, String var2, boolean var3, Runnable var4) {
      iii_Class8 var5 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(5.0F)
         .IiI_method_31d4c97(16.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 4.0F))
         .iI_method_e886414(5.0F)
         .II_method_77bdb679(MENU_HOVER)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c);
      var5.I_method_e53800a9(var0 -> highlight(0.04F * var0.hover()))
         .I_method_8939bffd(new Iii_Class4().size(6.0F, 6.0F).icon(var1, 6.0F, var2x -> menuItemColor(var5, var3)).interactive(false))
         .I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fade()
               .text(
                  IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), () -> IiIiIIII_Class81.I_method_f25a980a(var2), var2x -> menuItemColor(var5, var3)
               )
               .interactive(false)
         )
         .I_method_c0ca36f3(var4);
      return var5;
   }

   private Packets.Nested1_a7cdbede profile() {
      return Information.getProfile();
   }

   private String profileTarget() {
      Packets.Nested1_a7cdbede var1 = this.profile();
      if (var1 != null) {
         return var1.username();
      } else {
         String var2 = Information.getProfileLoading();
         return var2 == null ? "" : var2;
      }
   }

   private boolean isSelfProfile() {
      return Information.getUser() != null && Information.getUser().username().equals(this.profileTarget());
   }

   private String profileName() {
      return this.profileTarget();
   }

   private String profileTitleLine() {
      Packets.Nested1_a7cdbede var1 = this.profile();
      return var1 == null
         ? IiIiIIII_Class81.I_method_f25a980a(Information.profileFailed() ? "rocknet.profile.failed" : "rocknet.people.loading")
         : "#" + var1.uid() + " \u2022 " + IiIiIIII_Class81.I_method_f25a980a("rocknet.role." + var1.role());
   }

   private String profileMutualText() {
      Packets.Nested1_a7cdbede var1 = this.profile();
      return var1 == null ? "" : IiIiIIII_Class81.I_method_1410d1e5("rocknet.profile.mutual", var1.mutualCount());
   }

   private String profilePlaytime() {
      Packets.Nested1_a7cdbede var1 = this.profile();
      if (var1 == null) {
         return "\u2014";
      } else {
         long var2 = var1.playtime();
         long var4 = var2 / 3600L;
         long var6 = var2 % 3600L / 60L;
         if (var4 >= 24L) {
            return var4 / 24L
               + IiIiIIII_Class81.I_method_f25a980a("time.short.days")
               + " "
               + var4 % 24L
               + IiIiIIII_Class81.I_method_f25a980a("time.short.hours");
         } else {
            return var4 > 0L
               ? var4 + IiIiIIII_Class81.I_method_f25a980a("time.short.hours") + " " + var6 + IiIiIIII_Class81.I_method_f25a980a("time.short.minutes")
               : var6 + IiIiIIII_Class81.I_method_f25a980a("time.short.minutes");
         }
      }
   }

   private String profileStatus() {
      Packets.Nested1_a7cdbede var1 = this.profile();
      return var1 == null ? "\u2014" : this.peerStatus(var1, false);
   }

   private String profileRegistered() {
      Packets.Nested1_a7cdbede var1 = this.profile();
      return var1 != null && var1.registered() > 0L ? DATE.format(new Date(var1.registered())) : "\u2014";
   }

   private boolean profileOpen() {
      return Information.getProfile() != null || Information.getProfileLoading() != null;
   }

   private void openProfile(String var1) {
      if (var1 != null && !var1.isBlank() && !var1.equals(GLOBAL_CHAT_ID)) {
         this.closeMenu();
         this.sendField.I_method_fb5b3035(false);
         this.friendField.I_method_fb5b3035(false);
         this.searchField.I_method_fb5b3035(false);
         this.peopleField.I_method_fb5b3035(false);
         Information.requestProfile(var1);
      }
   }

   private void closeProfile() {
      Information.closeProfile();
   }

   private void openModerationMenu(String var1) {
      if (Information.staff() && var1 != null && !var1.isBlank()) {
         if (Information.getUser() == null || !Information.getUser().username().equals(var1)) {
            ArrayList var2 = new ArrayList();
            var2.add(
               new RocknetMenu.Nested1_b9d18778("hud/player", IiIiIIII_Class81.I_method_f25a980a("rocknet.profile.title"), false, () -> this.openProfile(var1))
            );
            var2.add(new RocknetMenu.Nested1_b9d18778("plane", IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.open_chat"), false, () -> this.openChat(var1)));
            var2.add(
               new RocknetMenu.Nested1_b9d18778("hud/handcuffs", IiIiIIII_Class81.I_method_f25a980a("rocknet.mod.mute"), false, () -> this.openMutePicker(var1))
            );
            var2.add(
               new RocknetMenu.Nested1_b9d18778(
                  "check",
                  IiIiIIII_Class81.I_method_f25a980a("rocknet.mod.unmute"),
                  false,
                  () -> RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_9448f1c9(var1))
               )
            );
            this.showMenu(var1, var2);
         }
      }
   }

   private void openMutePicker(String var1) {
      this.muteTarget = var1;
      IIiIi_Class6 var2 = new IIiIi_Class6()
         .I_method_cab8a7d6(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F))
         .i_method_ffed6bb6(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F))
         .I_method_73a53b57(11.0F)
         .I_method_36225a(3)
         .I_method_98745a69(var0 -> highlight(0.06F))
         .i_method_d1dadcf6(text())
         .II_method_6a5243b3(text().mulAlpha(0.35F))
         .Ii_method_810bdbd3(second());
      var2.I_method_b95e284(31, () -> this.muteDays, var1x -> this.muteDays = var1x, () -> IiIiIIII_Class81.I_method_f25a980a("time.unit.days"));
      var2.I_method_b95e284(24, () -> this.muteHours, var1x -> this.muteHours = var1x, () -> IiIiIIII_Class81.I_method_f25a980a("time.unit.hours"));
      var2.I_method_b95e284(60, () -> this.muteMinutes, var1x -> this.muteMinutes = var1x, () -> IiIiIIII_Class81.I_method_f25a980a("time.unit.minutes"));
      var2.i_method_fce65295().iI_method_4501da14(38.0F);
      iii_Class8 var3 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_70a38517(4.0F)
         .III_method_9dc17555()
         .I_method_8939bffd(
            this.muteButton("rocknet.mod.mute_apply", false, () -> this.applyMute(this.muteDays * 86400L + this.muteHours * 3600L + this.muteMinutes * 60L))
         )
         .I_method_8939bffd(this.muteButton("rocknet.mod.forever", true, () -> this.applyMute(0L)))
         .I_method_8939bffd(this.muteButton("cancel", false, this::closeMutePicker));
      iii_Class8 var4 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(6.0F)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(9.0F, 9.0F, 9.0F, 9.0F))
         .IIi_method_4dfc88d7(210.0F)
         .iI_method_e886414(10.0F)
         .I_method_e53800a9(var0 -> inset())
         .i_method_5db1deeb(var0 -> {})
         .I_method_8939bffd(
            new Iii_Class4()
               .fillWidth()
               .fade()
               .text(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(9.0F),
                  () -> IiIiIIII_Class81.I_method_1410d1e5("rocknet.mod.mute_title", var1),
                  var0 -> text()
               )
               .interactive(false)
         )
         .I_method_8939bffd(var2)
         .I_method_8939bffd(var3);
      iii_Class8 var5 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_fe5d8d56(IIIi_Class2.i_field_f93600a1)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .i_method_8c7d3515(this.window.w(), this.window.h())
         .I_method_f136b1d8(
            (var0, var1x) -> var0.drawRoundedRect(var1x.x(), var1x.y(), var1x.w(), var1x.h(), IIiii_Class8.I_method_893b2757(12.0F), page().mulAlpha(0.7F))
         )
         .i_method_5db1deeb(var1x -> this.closeMutePicker())
         .I_method_8939bffd(var4);
      var5.snapAt(this.window.x(), this.window.y());
      this.closeMenu();
      var5.beginEnter(0.0F);
      this.activeMenu = this.openWindow(var5);
   }

   private Iii_Class4 muteButton(String var1, boolean var2, Runnable var3) {
      ColorRGBA var4 = var2 ? DANGER : null;
      return new Iii_Class4()
         .height(16.0F)
         .fillWidth()
         .radius(7.0F)
         .text(
            IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
            () -> IiIiIIII_Class81.I_method_f25a980a(var1),
            var1x -> second().mix(var4 == null ? onAccent() : text(), var1x.hover())
         )
         .textAlign(IIi_Class2.i_field_b5755e8c)
         .background(var1x -> card().mix(var4 == null ? accent() : var4, var1x.hover()))
         .hoverMotion(STATE)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick(var3);
   }

   private void applyMute(long var1) {
      if (this.muteTarget != null) {
         RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_3565170(this.muteTarget, var1, ""));
      }

      this.closeMutePicker();
   }

   private void closeMutePicker() {
      this.muteTarget = null;
      this.closeMenu();
   }

   private void paintMessages(III var1, Iii_Class4 var2) {
      Chat var3 = this.currentChat;
      iIIiIIIii_Class292 var4 = var3.getScrollHandler();
      var4.I_method_575ab23f();
      float var5 = 10.0F;
      float var6 = 8.0F;
      float var7 = var2.x() + var5;
      float var8 = var2.x() + var2.w() - var5;
      float var9 = var2.y() + var2.h() - var6;
      float var10 = var2.h() - var6 * 2.0F;
      float var11 = (var8 - var7) * 0.66F;
      IIiIIi_Class10 var12 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F);
      IIiIIi_Class10 var13 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F);
      float var14 = 3.0F;
      iIiiiIiII_Class373.I_method_d5a5ee51(var1.getMatrices(), var2.x(), var2.y(), var2.w(), var2.h());
      float var15 = (float)var4.I_method_575ab22d();
      float var16 = 0.0F;
      String var17 = "";
      float var18 = RenderSystem.getShaderColor()[3];
      List var19 = var3.entriesSnapshot();
      if (var19.isEmpty()) {
         var1.drawCenteredText(
            IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F),
            IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.no_messages"),
            var2.x() + var2.w() / 2.0F,
            var2.y() + var2.h() / 2.0F - 3.0F,
            second()
         );
      }

      for (int var20 = var19.size() - 1; var20 >= 0; var20--) {
         Chat.Nested1_85f345cb var21 = (Chat.Nested1_85f345cb)var19.get(var20);
         long var22 = var21.id();
         Message var24 = var21.message();
         var24.animation().I_method_edd6dd11(1.0F);
         float var25 = var24.animation().I_method_6ac4da6f();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var25 * var18);
         boolean var26 = var24.self();
         boolean var27 = var17.isEmpty() || !var17.equals(var24.author().username());
         boolean var28 = var3.isFirstMessage(var22);
         boolean var29 = var28 && !var26;
         if (var24 instanceof ShareMessage var46) {
            String var48 = IiIiIIII_Class81.I_method_f25a980a(var46.titleKey());
            float var51 = Math.max(120.0F, Math.min(var11, Math.max(var12.I_method_2c375926(var46.text()), var12.I_method_2c375926(var48)) + 16.0F));
            float var53 = 49.0F;
            float var55 = var9 - var53 * var25 - var16 + var15;
            float var57 = var26 ? var8 - var51 : var7 + 18.0F + 5.0F;
            boolean var59 = var55 + var53 > var2.y() && var55 < var2.y() + var2.h();
            float var61 = var57 + 8.0F;
            Rect var63 = new Rect(var61, var55 + 29.0F, var51 - 16.0F, 13.0F);
            var46.actionRect(var63);
            if (var59) {
               this.drawBubble(var1, var57, var55, var51, var53, var26, var28, var27);
               if (!var26 && var27) {
                  var1.drawRoundedTexture(
                     Information.getAvatar(var24.author().username()),
                     var7,
                     var55 + var53 - 18.0F,
                     18.0F,
                     18.0F,
                     IIiii_Class8.I_method_893b2757(9.0F),
                     ColorRGBA.WHITE
                  );
               }

               ColorRGBA var66 = this.bubbleText(var26);
               var1.drawIcon(var46.icon(), var61, var55 + 7.0F, 6.0F, var66);
               var1.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F), var48, var61 + 9.0F, var55 + 7.0F, var66);
               var1.drawFadeoutText(var12, var46.text(), var61, var55 + 18.0F, var66.mulAlpha(0.7F), 0.9F, 1.0F, var51 - 16.0F);
               boolean var67 = iIIiIIIiI_Class291.I_method_da20b32b(var63.getX(), var63.getY(), var63.getWidth(), var63.getHeight(), var1);
               var1.drawRoundedRect(
                  var63.getX(), var63.getY(), var63.getWidth(), var63.getHeight(), IIiii_Class8.I_method_893b2757(4.0F), var66.mulAlpha(var67 ? 0.22F : 0.14F)
               );
               var1.drawCenteredText(
                  IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
                  IiIiIIII_Class81.I_method_f25a980a("rocknet.share.add"),
                  var63.getX() + var63.getWidth() / 2.0F,
                  var63.getY() + 4.0F,
                  var66
               );
               if (var67) {
                  iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
               }
            }

            var24.rect(new Rect(var57, var55, var51, var53));
            var24.avatarRect(!var26 && var27 ? new Rect(var7, var55 + var53 - 18.0F, 18.0F, 18.0F) : Rect.EMPTY);
            var24.nameRect(Rect.EMPTY);
            var16 += (var53 + 2.0F) * var25;
            var17 = var24.author().username();
         } else {
            if (var24 instanceof CordsMessage var30) {
               String var31 = IiIiIIII_Class81.I_method_1410d1e5("rocknet.menu.coordinates", var30.pos().getX(), var30.pos().getY(), var30.pos().getZ());
               float var32 = Math.max(120.0F, Math.min(var11, var12.I_method_2c375926(var31) + 16.0F));
               float var33 = 49.0F;
               float var34 = var9 - var33 * var25 - var16 + var15;
               float var35 = var26 ? var8 - var32 : var7 + 18.0F + 5.0F;
               boolean var36 = var34 + var33 > var2.y() && var34 < var2.y() + var2.h();
               if (var36) {
                  this.drawBubble(var1, var35, var34, var32, var33, var26, var28, var27);
                  if (!var26 && var27) {
                     var1.drawRoundedTexture(
                        Information.getAvatar(var24.author().username()),
                        var7,
                        var34 + var33 - 18.0F,
                        18.0F,
                        18.0F,
                        IIiii_Class8.I_method_893b2757(9.0F),
                        ColorRGBA.WHITE
                     );
                  }

                  float var37 = var35 + 8.0F;
                  ColorRGBA var38 = this.bubbleText(var26);
                  var1.drawIcon("hud/world", var37, var34 + 7.0F, 6.0F, var38);
                  var1.drawText(
                     IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(8.0F),
                     IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.geolocation"),
                     var37 + 9.0F,
                     var34 + 7.0F,
                     var38
                  );
                  var1.drawText(var12, var31, var37, var34 + 18.0F, var38.mulAlpha(0.7F));
                  boolean var39 = iIIiIIIiI_Class291.I_method_da20b32b(var37, var34 + 29.0F, var32 - 16.0F, 13.0, var1);
                  var1.drawRoundedRect(var37, var34 + 29.0F, var32 - 16.0F, 13.0F, IIiii_Class8.I_method_893b2757(4.0F), var38.mulAlpha(var39 ? 0.22F : 0.14F));
                  var1.drawCenteredText(
                     IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
                     IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.create_waypoint"),
                     var37 + (var32 - 16.0F) / 2.0F,
                     var34 + 33.0F,
                     var38
                  );
                  if (var39) {
                     iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
                  }
               }

               var24.rect(new Rect(var35, var34, var32, var33));
               var16 += (var33 + 2.0F) * var25;
               var17 = var24.author().username();
               if (var24.text().isBlank()) {
                  continue;
               }

               var27 = false;
               var28 = var3.isFirstMessage(var22);
               var29 = var28 && !var26;
            }

            Message.Nested1_1dc6ec45 var45 = layout(var24, var12, var11 - 16.0F);
            List var47 = var45.lines();
            float var49 = var45.width() + 16.0F;
            float var52 = var29 ? nameWidth(var24, var13) : 0.0F;
            if (var29) {
               var49 = Math.max(var49, var52 + 16.0F);
            }

            if (var24 instanceof ReplyMessage) {
               var49 = Math.max(var49, 120.0F);
            }

            var49 = Math.min(var49, var11);
            float var54 = 14.0F
               + (var12.I_method_a649725c() + var14) * var47.size()
               - (var47.isEmpty() ? 0.0F : var14)
               + (var29 ? var13.I_method_a649725c() + 4.0F : 0.0F)
               + (var24 instanceof ReplyMessage ? 27.0F : 0.0F);
            float var56 = var9 - var54 * var25 - var16 + var15;
            float var58 = var26 ? var8 - var49 : var7 + 18.0F + 5.0F;
            boolean var60 = var56 + var54 > var2.y() && var56 < var2.y() + var2.h();
            float var62 = var58 + 8.0F;
            if (var60) {
               this.drawBubble(var1, var58, var56, var49, var54, var26, var28, var27);
               if (!var26 && var27) {
                  var1.drawRoundedTexture(
                     Information.getAvatar(var24.author().username()),
                     var7,
                     var56 + var54 - 18.0F,
                     18.0F,
                     18.0F,
                     IIiii_Class8.I_method_893b2757(9.0F),
                     ColorRGBA.WHITE
                  );
               }
            }

            var24.avatarRect(!var26 && var27 ? new Rect(var7, var56 + var54 - 18.0F, 18.0F, 18.0F) : Rect.EMPTY);
            var24.nameRect(var29 ? new Rect(var62, var56 + 7.0F, Math.min(var49 - 16.0F, var52), var13.I_method_a649725c()) : Rect.EMPTY);
            if (!(var24 instanceof CordsMessage)) {
               var24.rect(new Rect(var58, var56, var49, var54));
            }

            if (var24 instanceof ReplyMessage var64) {
               var64.quoteRect(new Rect(var62, var56 + 7.0F + (var29 ? var13.I_method_a649725c() + 4.0F : 0.0F), var49 - 16.0F, 23.0F));
            }

            if (var60) {
               ColorRGBA var65 = this.bubbleText(var26);
               float var40 = var56 + 7.0F;
               if (var29) {
                  CosmeticRender.draw(var1, var13, var24.author().username(), var62, var40, var24.author().nickStyle(), var24.author().badge(), var65, 8.0F);
                  var40 += var13.I_method_a649725c() + 4.0F;
               }

               if (var24 instanceof ReplyMessage var41) {
                  Message var42 = this.currentChat.getMessage(var41.reply());
                  if (var42 != null) {
                     Rect var43 = var41.quoteRect();
                     boolean var44 = iIIiIIIiI_Class291.I_method_da20b32b(var43.getX(), var43.getY(), var43.getWidth(), var43.getHeight(), var1);
                     var1.drawRoundedRect(var62, var40, var49 - 16.0F, 23.0F, IIiii_Class8.I_method_893b2757(5.0F), var65.mulAlpha(var44 ? 0.18F : 0.1F));
                     CosmeticRender.draw(
                        var1,
                        IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
                        var42.author().username(),
                        var62 + 5.0F,
                        var40 + 6.0F,
                        null,
                        null,
                        var65,
                        0.0F,
                        var49 - 26.0F
                     );
                     var1.drawFadeoutText(
                        IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
                        var42.text(),
                        var62 + 5.0F,
                        var40 + 13.0F,
                        var65.mulAlpha(0.5F),
                        0.9F,
                        1.0F,
                        var49 - 26.0F
                     );
                     if (var44) {
                        iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
                     }
                  }

                  var40 += 27.0F;
               }

               List var68 = null;

               for (String var70 : (Iterable<String>)(Iterable<?>)var47) {
                  var68 = this.drawMessageLine(var1, var12, var70, var62, var40, var65, var26, var68);
                  var40 += var12.I_method_a649725c() + var14;
               }

               var24.mentions(var68 == null ? List.of() : var68);
            }

            var16 += (var54 + 2.0F) * var25;
            var17 = var24.author().username();
         }
      }

      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var18);
      this.drawMentions(var1);
      var4.i_method_95bee5ff(var10 - var16);
      iIiiiIiII_Class373.I_method_ff80a1df();
      this.requestHistoryIfNeeded(var3, var16, var10);
   }

   private List<Message.Nested1_d637502f> drawMessageLine(
      III var1, IIiIIi_Class10 var2, String var3, float var4, float var5, ColorRGBA var6, boolean var7, List<Message.Nested1_d637502f> var8
   ) {
      if (!Mentions.possible(var3)) {
         IiIiiIIiI_Class179.I_method_d5fb8067(var1, var2, var3, var4, var5, var2.I_method_a649725c(), var6);
         return (List<Message.Nested1_d637502f>)var8;
      } else {
         ColorRGBA var9 = var7 ? var6 : accent();
         boolean var10 = var1.i_method_b1d26d32() >= this.messagesBox.y() && var1.i_method_b1d26d32() <= this.messagesBox.y() + this.messagesBox.h();
         float var11 = var4;

         for (Mentions.Nested1_b5df6429 var13 : Mentions.split(var3)) {
            float var14 = IiIiiIIiI_Class179.I_method_cc1ab81a(var2, var13.text());
            if (!var13.isMention()) {
               IiIiiIIiI_Class179.I_method_d5fb8067(var1, var2, var13.text(), var11, var5, var2.I_method_a649725c(), var6);
               var11 += var14;
            } else {
               boolean var15 = Mentions.isMe(var13.mention());
               var1.drawRoundedRect(
                  var11 - 1.5F,
                  var5 - 1.5F,
                  var14 + 3.0F,
                  var2.I_method_a649725c() + 3.0F,
                  IIiii_Class8.I_method_893b2757(3.0F),
                  var9.mulAlpha(var15 ? 0.32F : 0.16F)
               );
               IiIiiIIiI_Class179.I_method_d5fb8067(var1, var2, var13.text(), var11, var5, var2.I_method_a649725c(), var9);
               Rect var16 = new Rect(var11, var5, var14, var2.I_method_a649725c());
               if (var8 == null) {
                  var8 = new ArrayList(2);
               }

               var8.add(new Message.Nested1_d637502f(var13.mention(), var16));
               if (var10 && iIIiIIIiI_Class291.I_method_4667d3d9(var16, var1.I_method_b1c3e152(), var1.i_method_b1d26d32())) {
                  iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
               }

               var11 += var14;
            }
         }

         return (List<Message.Nested1_d637502f>)var8;
      }
   }

   private static Message.Nested1_1dc6ec45 layout(Message var0, IIiIIi_Class10 var1, float var2) {
      Message.Nested1_1dc6ec45 var3 = var0.layout();
      if (var3 != null && Math.abs(var3.maxWidth() - var2) < 0.01F) {
         return var3;
      } else {
         List var4 = wrapText(var0.text(), var2);
         float var5 = 0.0F;

         for (String var7 : (Iterable<String>)(Iterable<?>)var4) {
            var5 = Math.max(var5, lineWidth(var1, var7));
         }

         Message.Nested1_1dc6ec45 var8 = new Message.Nested1_1dc6ec45(var2, var4, var5);
         var0.layout(var8);
         return var8;
      }
   }

   private static float nameWidth(Message var0, IIiIIi_Class10 var1) {
      float var2 = var0.nameWidth();
      if (var2 >= 0.0F) {
         return var2;
      } else {
         float var3 = CosmeticRender.width(var1, var0.author().username(), var0.author().badge(), 8.0F);
         var0.nameWidth(var3);
         return var3;
      }
   }

   private static float lineWidth(IIiIIi_Class10 var0, String var1) {
      if (!Mentions.possible(var1)) {
         return IiIiiIIiI_Class179.I_method_cc1ab81a(var0, var1);
      } else {
         float var2 = 0.0F;

         for (Mentions.Nested1_b5df6429 var4 : Mentions.split(var1)) {
            var2 += IiIiiIIiI_Class179.I_method_cc1ab81a(var0, var4.text());
         }

         return var2;
      }
   }

   private void requestHistoryIfNeeded(Chat var1, float var2, float var3) {
      if (var1.isMoreHistory() && var1.size() < 400) {
         boolean var4 = var2 <= var3 || var1.getScrollHandler().I_method_575ab22d() >= var2 - var3 - 60.0F;
         if (var4) {
            long var5 = System.currentTimeMillis();
            if (var5 - var1.getHistoryRequestedAt() >= 1500L) {
               var1.setHistoryRequestedAt(var5);
               long var7 = var1.oldestId();
               RockstarClient.getInstance()
                  .I_method_cd3d46d0()
                  .send(
                     (Packet)(var1.getName().equals(GLOBAL_CHAT_ID) ? new Packets.Nested1_756a47e(var7) : new Packets.Nested1_37631c33(var1.getName(), var7))
                  );
            }
         }
      }
   }

   private void drawBubble(III var1, float var2, float var3, float var4, float var5, boolean var6, boolean var7, boolean var8) {
      float var9 = 8.0F;
      float var10 = 3.0F;
      IIiii_Class8 var11 = var6
         ? new IIiii_Class8(var9, var7 ? var9 : var10, var8 ? var9 : var10, var9)
         : new IIiii_Class8(var7 ? var9 : var10, var9, var9, var8 ? var9 : var10);
      var1.drawRoundedRect(var2, var3, var4, var5, var11, var6 ? accent() : inset());
   }

   private ColorRGBA bubbleText(boolean var1) {
      return var1 ? onAccent() : text();
   }

   private void clickMessages(IiIII_Class9 var1, float var2, float var3) {
      if (!this.clickMentions(var1, var2, var3)) {
         List var4 = this.currentChat.messageIdsSnapshot();

         for (int var5 = var4.size() - 1; var5 >= 0; var5--) {
            long var6 = (Long)var4.get(var5);
            Message var8 = this.currentChat.getMessage(var6);
            if (var8 != null) {
               Rect var9 = var8.rect();
               if (!(var9.getY() + var9.getHeight() < this.messagesBox.y()) && !(var9.getY() > this.messagesBox.y() + this.messagesBox.h())) {
                  if (var1 == IiIII_Class9.I_field_2f4c8d6c) {
                     for (Message.Nested1_d637502f var11 : var8.mentions()) {
                        if (iIIiIIIiI_Class291.I_method_4667d3d9(var11.rect(), var2, var3)) {
                           this.openProfile(var11.username());
                           return;
                        }
                     }
                  }

                  if (iIIiIIIiI_Class291.I_method_4667d3d9(var8.avatarRect(), var2, var3) || iIIiIIIiI_Class291.I_method_4667d3d9(var8.nameRect(), var2, var3)) {
                     String var16 = var8.author().username();
                     if (var1 == IiIII_Class9.i_field_2f4c8d6c) {
                        this.openModerationMenu(var16);
                     } else if (var1 == IiIII_Class9.I_field_2f4c8d6c) {
                        this.openProfile(var16);
                     }

                     return;
                  }

                  if (var8 instanceof CordsMessage var12
                     && var1 == IiIII_Class9.I_field_2f4c8d6c
                     && iIIiIIIiI_Class291.I_method_c3f86263(var9.getX() + 8.0F, var9.getY() + 29.0F, var9.getWidth() - 16.0F, 13.0, var2, var3)) {
                     RockstarClient.getInstance()
                        .I_method_cf3ba442()
                        .I_method_b71837ba(var12.author().username(), var12.pos().getX(), var12.pos().getY(), var12.pos().getZ());
                     return;
                  }

                  if (var8 instanceof ReplyMessage var13
                     && var1 == IiIII_Class9.I_field_2f4c8d6c
                     && iIIiIIIiI_Class291.I_method_4667d3d9(var13.quoteRect(), var2, var3)) {
                     this.scrollToMessage(var13.reply());
                     return;
                  }

                  if (var8 instanceof ShareMessage var14
                     && var1 == IiIII_Class9.I_field_2f4c8d6c
                     && iIIiIIIiI_Class291.I_method_4667d3d9(var14.actionRect(), var2, var3)) {
                     RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_55703e48(var14.shareId()));
                     return;
                  }

                  if (var1 == IiIII_Class9.i_field_2f4c8d6c && iIIiIIIiI_Class291.I_method_4667d3d9(var9, var2, var3) && !var8.text().isBlank()) {
                     ArrayList var15 = new ArrayList();
                     var15.add(new RocknetMenu.Nested1_b9d18778("back", IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.reply_button"), false, () -> {
                        this.setReply(var6);
                        this.lastReply = var6;
                     }));
                     if (Information.staff()) {
                        var15.add(
                           new RocknetMenu.Nested1_b9d18778(
                              "trash",
                              IiIiIIII_Class81.I_method_f25a980a("rocknet.mod.delete"),
                              true,
                              () -> RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_bc77be65(var6))
                           )
                        );
                     }

                     this.showMenu(var8.text(), var15);
                     return;
                  }
               }
            }
         }
      }
   }

   private void scrollToMessage(long var1) {
      Message var3 = this.currentChat.getMessage(var1);
      if (var3 != null && this.messagesBox != null) {
         Rect var4 = var3.rect();
         if (var4 != null && !(var4.getHeight() <= 0.0F)) {
            iIIiIIIii_Class292 var5 = this.currentChat.getScrollHandler();
            float var6 = this.messagesBox.y() + (this.messagesBox.h() - var4.getHeight()) / 2.0F;
            double var7 = -var5.I_method_575ab22d() - (var6 - var4.getY());
            var5.II_method_ed47737c(Math.max(var5.i_method_57693e0d(), Math.min(0.0, var7)));
            var5.Ii_method_ef0a639c(0.0);
         }
      }
   }

   private String muteNotice() {
      long var1 = Information.getMuteUntil();
      return var1 < 0L
         ? IiIiIIII_Class81.I_method_f25a980a("rocknet.mod.muted_forever")
         : IiIiIIII_Class81.I_method_1410d1e5("rocknet.mod.muted_until", TIME.format(new Date(var1)));
   }

   private void sendMessage() {
      if (!Information.muted()) {
         String var1 = renderable(this.sendField.I_method_d2579001());
         if (!var1.isBlank()) {
            String var2 = this.reply == -1L ? var1 : replyPrefix(this.reply) + var1;
            if (var2.length() <= this.chatLimit()) {
               this.setReply(-1L);
               this.send(var2);
               this.sendField.II_method_fb6974c2();
            }
         }
      }
   }

   private void send(String var1) {
      try {
         RockstarClient.getInstance()
            .I_method_cd3d46d0()
            .send(
               (Packet)(this.currentChat.getName().equals(GLOBAL_CHAT_ID)
                  ? new Packets.Nested1_3c7c7ae4(var1)
                  : new Packets.Nested1_d3b0d257(this.currentChat.getName(), var1))
            );
      } catch (RuntimeException var3) {
         RockstarClient.I_field_ab0f6068
            .warn(
               "Globals: \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043d\u0435 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e",
               var3
            );
         return;
      }

      this.currentChat.scrollToBottom();
   }

   private int chatLimit() {
      return this.currentChat.getName().equals(GLOBAL_CHAT_ID) ? 200 : 500;
   }

   private static String replyPrefix(long var0) {
      return "${reply=" + var0 + "}";
   }

   private void setReply(long var1) {
      this.reply = var1;
      int var3 = this.chatLimit() - (var1 == -1L ? 0 : replyPrefix(var1).length());
      this.sendField.I_method_fb5af064(Math.max(1, var3));
   }

   private static String renderable(String var0) {
      return var0 == null ? "" : var0.trim();
   }

   private void sendFriendRequest() {
      if (!this.friendField.I_method_d2579001().isBlank()) {
         RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_17a3bc2e(this.friendField.I_method_d2579001().trim()));
         this.friendField.II_method_fb6974c2();
      }
   }

   private void openChat(String var1) {
      Chat var2 = Information.byName(var1);
      if (var2 != this.currentChat) {
         this.currentChat = var2;
         this.currentChat.resetMessageAnimations();
         this.currentChat.getScrollHandler().i_method_57693e1f();
         this.setReply(-1L);
         this.rebuildSidebar(true);
      }
   }

   private void openActionsMenu() {
      this.showMenu(
         IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.actions"),
         List.of(
            new RocknetMenu.Nested1_b9d18778(
               "hud/world",
               IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.coordinates_button"),
               false,
               () -> {
                  this.send(
                     String.format(
                           "${cords=%s,%s,%s}",
                           I_field_3a9bda27.player.getBlockPos().getX(),
                           I_field_3a9bda27.player.getBlockPos().getY(),
                           I_field_3a9bda27.player.getBlockPos().getZ()
                        )
                        + this.sendField.I_method_d2579001()
                  );
                  this.sendField.II_method_fb6974c2();
               }
            ),
            new RocknetMenu.Nested1_b9d18778("setting", IiIiIIII_Class81.I_method_f25a980a("rocknet.share.config"), false, this::openConfigPicker),
            new RocknetMenu.Nested1_b9d18778("hud/target", IiIiIIII_Class81.I_method_f25a980a("rocknet.share.swing"), false, this::openSwingPicker),
            new RocknetMenu.Nested1_b9d18778("menu/builder", IiIiIIII_Class81.I_method_f25a980a("rocknet.share.invbuilder"), false, this::openInvBuilderPicker)
         )
      );
   }

   private void openConfigPicker() {
      ArrayList var1 = new ArrayList();

      for (Packets.Nested1_f320330b var3 : RockstarClient.getInstance().I_method_5198232b().I_method_43bd37db()) {
         var1.add(
            new RocknetMenu.Nested1_b9d18778(
               "setting",
               var3.name(),
               false,
               () -> RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_3b6ca75e(var3.id(), this.shareTarget()))
            )
         );
      }

      this.showMenu(IiIiIIII_Class81.I_method_f25a980a("rocknet.share.config"), var1);
   }

   private void openSwingPicker() {
      iiIIiIIi_Class202 var1 = RockstarClient.getInstance().I_method_2da230b();
      var1.Ii_method_b13067f5();
      ArrayList var2 = new ArrayList();

      for (iiIIiIII_Class201 var4 : var1.I_method_43006bfb()) {
         if (!var4.I_method_5141c934().equals("autosave")) {
            var2.add(new RocknetMenu.Nested1_b9d18778("hud/target", var4.I_method_5141c934(), false, () -> this.sendSwingPreset(var4)));
         }
      }

      this.showMenu(IiIiIIII_Class81.I_method_f25a980a("rocknet.share.swing"), var2);
   }

   private void openInvBuilderPicker() {
      InventoryBuilderModule.Iii_method_1629dabf();
      ArrayList var1 = new ArrayList();

      for (InventoryBuilderModule.Nested1_210a0440 var3 : InventoryBuilderModule.I_method_c735da08()) {
         if (var3.I_method_3878a76d() != 0) {
            var1.add(
               new RocknetMenu.Nested1_b9d18778(
                  "menu/builder",
                  var3.I_field_523beb0a,
                  false,
                  () -> RockstarClient.getInstance()
                     .I_method_cd3d46d0()
                     .send(new Packets.Nested1_3a3c486(var3.I_field_523beb0a, InventoryBuilderModule.I_method_7809e6de(var3), this.shareTarget()))
               )
            );
         }
      }

      this.showMenu(IiIiIIII_Class81.I_method_f25a980a("rocknet.share.invbuilder"), var1);
   }

   private void sendSwingPreset(iiIIiIII_Class201 var1) {
      try {
         String var2 = Files.readString(var1.I_method_79d503a1().toPath(), StandardCharsets.UTF_8);
         RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_f59883b2(var1.I_method_5141c934(), var2, this.shareTarget()));
      } catch (IOException var3) {
         RockstarClient.I_field_ab0f6068
            .error(
               "rocknet: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0442\u044c \u043f\u0440\u0435\u0441\u0435\u0442 \u2014 {}",
               var3.getMessage()
            );
      }
   }

   private String shareTarget() {
      return this.currentChat.getName().equals(GLOBAL_CHAT_ID) ? "" : this.currentChat.getName();
   }

   private void openFriendMenu(String var1) {
      Packets.Nested1_1da0dac9 var2 = this.friend(var1);
      if (var2 != null) {
         ArrayList var3 = new ArrayList();
         var3.add(new RocknetMenu.Nested1_b9d18778("plane", IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.open_chat"), false, () -> this.openChat(var1)));
         String var4 = this.serverAddress(var2);
         if (var4 != null && !WorldKey.sameWorld(var2.gameInfo())) {
            var3.add(
               new RocknetMenu.Nested1_b9d18778(
                  "hud/world",
                  IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.connect"),
                  false,
                  () -> {
                     ServerInfo var2x = new ServerInfo(var2.gameInfo().ip(), var4, ServerType.OTHER);
                     I_field_3a9bda27.disconnect();
                     I_field_3a9bda27.execute(
                        () -> ConnectScreen.connect(new MultiplayerScreen(new TitleScreen()), I_field_3a9bda27, ServerAddress.parse(var4), var2x, false, null)
                     );
                  }
               )
            );
         }

         var3.add(
            new RocknetMenu.Nested1_b9d18778(
               "trash",
               IiIiIIII_Class81.I_method_f25a980a("remove"),
               true,
               () -> RockstarClient.getInstance().I_method_cd3d46d0().send(new Packets.Nested1_8e89c4ad(var1))
            )
         );
         this.showMenu(var1, var3);
      }
   }

   private String serverAddress(Packets.Nested1_1da0dac9 var1) {
      if (Activities.onServer(var1.activity()) && var1.gameInfo() != null) {
         String var2 = var1.gameInfo().ip();
         if (var2 != null && !var2.isBlank() && !var2.equals("single") && !var2.equals("???")) {
            return var2.indexOf(58) < 0 ? var2 + ":25565" : var2;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private void showMenu(String var1, List<RocknetMenu.Nested1_b9d18778> var2) {
      IIiIIi_Class10 var3 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F);
      float var4 = 84.0F;

      for (RocknetMenu.Nested1_b9d18778 var6 : var2) {
         var4 = Math.max(var4, 25.0F + var3.I_method_2c375926(var6.label()) + 4.0F);
      }

      if (var1 != null) {
         var4 = Math.max(var4, 14.0F + IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F).I_method_2c375926(var1) + 4.0F);
      }

      var4 = Math.min(150.0F, var4);
      float var17 = var2.isEmpty() ? 22.0F : var2.size() * 16.0F + (var2.size() - 1) * 2.0F;
      int var18 = Math.max(1, 5);
      float var7 = Math.min(var18 * 18.0F - 2.0F, var17);
      float var8 = 6.0F + var7 + (var1 == null ? 0.0F : 16.0F);
      iii_Class8 var9 = new iii_Class8().I_method_485bccf5().I_method_70a38517(2.0F).III_method_9dc17555().IiI_method_31d4c97(var7);
      if (var17 > var7) {
         var9.Ii_method_bb38d618()
            .I_method_3987f136(IiIi_Class6.i_field_f9448c81)
            .I_method_b65baecb(
               var0 -> var0.i_method_65326e43(-1.0F)
                  .II_method_e6aaaac(2.0F)
                  .I_method_2a080a63(2.0F)
                  .Ii_method_49950e8c(12.0F)
                  .iI_method_388cc2cc(1.0F)
                  .ii_method_73b726ac(1000.0F)
                  .i_method_989a5f71(var0x -> stroke().mix(second(), var0x.I_method_af833bdc() + var0x.i_method_af91c7bc()))
            );
      }

      if (var2.isEmpty()) {
         var9.I_method_8939bffd(
            new Iii_Class4()
               .height(22.0F)
               .fillWidth()
               .text(var3, () -> IiIiIIII_Class81.I_method_f25a980a("rocknet.share.empty"), var0 -> second())
               .textAlign(IIi_Class2.i_field_b5755e8c)
               .interactive(false)
         );
      }

      for (RocknetMenu.Nested1_b9d18778 var11 : var2) {
         var9.I_method_8939bffd(this.menuItem(var11, var3));
      }

      iii_Class8 var19 = new iii_Class8()
         .I_method_485bccf5()
         .I_method_70a38517(2.0F)
         .i_method_f6ad2537(3.0F)
         .i_method_8c7d3515(var4, var8)
         .I_method_f136b1d8((var0, var1x) -> {
            var0.drawShadow(var1x.x(), var1x.y(), var1x.w(), var1x.h(), 20.0F, IIiii_Class8.I_method_893b2757(8.0F), ColorRGBA.BLACK.withAlpha(191.25F));
            var0.drawRoundedRect(var1x.x(), var1x.y(), var1x.w(), var1x.h(), IIiii_Class8.I_method_893b2757(8.0F), inset());
         })
         .II_method_32b63e79(MENU_OPEN)
         .i_method_b358e156(MENU_MOTION);
      if (var1 != null) {
         var19.I_method_8939bffd(
            new Iii_Class4()
               .height(14.0F)
               .fillWidth()
               .padding(0.0F, 4.0F)
               .text(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F), var1, var0 -> second())
               .fade()
               .interactive(false)
         );
      }

      var19.I_method_8939bffd(var9);
      float var20 = this.window.x() + 4.0F;
      float var12 = this.window.y() + 4.0F;
      float var13 = this.window.x() + this.window.w() - var4 - 4.0F;
      float var14 = this.window.y() + this.window.h() - var8 - 4.0F;
      float var15 = this.lastMouseY > var14 ? this.lastMouseY - var8 : this.lastMouseY;
      var19.snapAt(Math.max(var20, Math.min(var13, this.lastMouseX)), Math.max(var12, Math.min(Math.max(var12, var14), var15)));
      this.closeMenu();
      var19.beginEnter(0.0F);
      this.activeMenu = this.openWindow(var19);
   }

   private iii_Class8 menuItem(RocknetMenu.Nested1_b9d18778 var1, IIiIIi_Class10 var2) {
      iii_Class8 var3 = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(5.0F)
         .IiI_method_31d4c97(16.0F)
         .III_method_9dc17555()
         .I_method_7e2bb176(IIII.I_method_b1e865cb(0.0F, 4.0F))
         .iI_method_e886414(5.0F)
         .II_method_77bdb679(MENU_HOVER)
         .I_method_9680b4fd(iIIIiIIIi_Class274.i_field_aa52e62c);
      var3.I_method_e53800a9(var0 -> highlight(0.04F * var0.hover()))
         .I_method_8939bffd(new Iii_Class4().size(6.0F, 6.0F).icon(var1.icon(), 6.0F, var2x -> menuItemColor(var3, var1.danger())).interactive(false))
         .I_method_8939bffd(new Iii_Class4().fillWidth().fade().text(var2, var1.label(), var2x -> menuItemColor(var3, var1.danger())).interactive(false))
         .I_method_c0ca36f3(() -> {
            this.closeMenu();
            var1.run().run();
         });
      return var3;
   }

   private static ColorRGBA menuItemColor(iii_Class8 var0, boolean var1) {
      return second().mix(var1 ? DANGER : text(), var0.hover());
   }

   private void closeMenu() {
      if (this.activeMenu != null) {
         this.activeMenu.beginExit(0.0F);
         this.activeMenu = null;
      }
   }

   private boolean closeMenuIfOutside(float var1, float var2) {
      if (this.activeMenu == null) {
         return false;
      } else if (!this.activeMenu.alive()) {
         this.activeMenu = null;
         return false;
      } else if (this.activeMenu.contains(var1, var2)) {
         return false;
      } else {
         this.closeMenu();
         return true;
      }
   }

   public void tick() {
      GuiMoveModule.iII_method_9983ebf();
      super.tick();
   }

   @Override
   public void render(III var1) {
      if (this.window != null) {
         this.lastMouseX = var1.I_method_b1c3e152();
         this.lastMouseY = var1.i_method_b1d26d32();
         if (!this.closing) {
            this.rebuildSidebar(false);
            this.syncPeers();
            this.syncPeopleQuery();
            this.rebuildPeople();
            this.syncMentions();
         }

         this.windowX = this.window.x();
         this.windowY = this.window.y();
         this.menuWindow.set(this.windowX, this.windowY, this.window.w(), this.window.h());
         this.menuAnimation.I_method_df2f9087(CIRC_OUT);
         this.menuAnimation.I_method_edd6ec25((long)(this.closing ? 200.0F : 280.0F));
         this.menuAnimation.I_method_edd6dd11(this.closing ? 0.0F : 1.0F);
         float var2 = Math.max(0.0F, Math.min(1.0F, this.menuAnimation.I_method_6ac4da6f()));
         this.contentAlpha = var2;
         float var3 = this.closing ? 0.96F : 0.93F;
         float var4 = this.closing ? 10.0F : 14.0F;
         float var5 = var3 + (1.0F - var3) * var2;
         float var6 = (1.0F - var2) * var4;
         boolean var7 = Math.abs(var5 - 1.0F) > 1.0E-4F || Math.abs(var6) > 1.0E-4F;
         if (var7) {
            float var8 = this.windowX + this.window.w() / 2.0F;
            float var9 = this.windowY + this.window.h() / 2.0F;
            var1.getMatrices().push();
            var1.getMatrices().translate(var8, var9 + var6, 0.0F);
            var1.getMatrices().scale(var5, var5, 1.0F);
            var1.getMatrices().translate(-var8, -var9, 0.0F);
         }

         super.render(var1);
         if (var7) {
            var1.getMatrices().pop();
         }
      }
   }

   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      this.lastMouseX = (float)var1;
      this.lastMouseY = (float)var3;
      if (Information.getUser() == null) {
         this.form.onMouseClicked(var1, var3, var5);
         super.onMouseClicked(var1, var3, var5);
      } else if (!this.closeMenuIfOutside((float)var1, (float)var3)) {
         if (this.activeMenu != null) {
            super.onMouseClicked(var1, var3, var5);
         } else {
            if (var5 != IiIII_Class9.II_field_2f4c8d6c) {
               this.sendField.I_method_400ceaa7(var1, var3, var5);
               this.friendField.I_method_400ceaa7(var1, var3, var5);
               this.searchField.I_method_400ceaa7(var1, var3, var5);
               this.peopleField.I_method_400ceaa7(var1, var3, var5);
            }

            super.onMouseClicked(var1, var3, var5);
         }
      }
   }

   @Override
   public void onMouseReleased(double var1, double var3, IiIII_Class9 var5) {
      boolean var6 = var5 == IiIII_Class9.I_field_2f4c8d6c && this.window != null && this.window.dragging();
      if (Information.getUser() == null) {
         this.form.onMouseReleased(var1, var3, var5);
         super.onMouseReleased(var1, var3, var5);
         if (var6) {
            this.returnWindowToCenterIfOutside();
         }
      } else {
         if (this.sendField.I_method_189fd283()) {
            this.sendField.i_method_6a097ac7(var1, var3, var5);
         }

         if (this.friendField.I_method_189fd283()) {
            this.friendField.i_method_6a097ac7(var1, var3, var5);
         }

         if (this.searchField.I_method_189fd283()) {
            this.searchField.i_method_6a097ac7(var1, var3, var5);
         }

         if (this.peopleField.I_method_189fd283()) {
            this.peopleField.i_method_6a097ac7(var1, var3, var5);
         }

         super.onMouseReleased(var1, var3, var5);
         if (var6) {
            this.returnWindowToCenterIfOutside();
         }
      }
   }

   private void returnWindowToCenterIfOutside() {
      float var1 = this.window.x();
      float var2 = this.window.y();
      float var3 = this.window.w();
      float var4 = this.window.h();
      float var5 = Math.max(0.0F, Math.min((float)this.width, var1 + var3) - Math.max(0.0F, var1));
      float var6 = Math.max(0.0F, Math.min((float)this.height, var2 + var4) - Math.max(0.0F, var2));
      if (!(1.0F - var5 * var6 / Math.max(1.0F, var3 * var4) < 0.35F)) {
         this.window.iI_method_7009d1d8(Math.round((this.width - var3) / 2.0F), Math.round((this.height - var4) / 2.0F));
      }
   }

   @Override
   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
      if (keyCode == 256 && this.activeMenu != null && this.activeMenu.alive()) {
         this.closeMutePicker();
         return true;
      } else if (keyCode == 256 && this.profileOpen()) {
         this.closeProfile();
         return true;
      } else if (this.profileOpen()) {
         return true;
      } else if (keyCode == 256 && this.peopleOpen) {
         this.togglePeople();
         return true;
      } else if (Information.getUser() == null) {
         this.form.keyPressed(keyCode, scanCode, modifiers);
         return super.keyPressed(keyCode, scanCode, modifiers);
      } else {
         if (!this.mentionOptions.isEmpty() && this.sendField.I_method_189fd283()) {
            if (keyCode == 256) {
               this.mentionDismissed = Mentions.typed(this.sendField.I_method_d2579001());
               this.setMentionOptions(List.of());
               return true;
            }

            if (keyCode == 264 || keyCode == 265) {
               int var4 = keyCode == 264 ? 1 : -1;
               this.mentionIndex = (this.mentionIndex + var4 + this.mentionOptions.size()) % this.mentionOptions.size();
               return true;
            }

            if (keyCode == 258 || keyCode == 257) {
               this.applyMention(this.mentionOptions.get(Math.min(this.mentionIndex, this.mentionOptions.size() - 1)));
               return true;
            }
         }

         if (keyCode == 257 && this.sendField.I_method_189fd283() && !this.sendField.I_method_d2579001().isBlank()) {
            this.sendMessage();
         } else if (this.sendField.I_method_189fd283()) {
            this.sendField.I_method_c1acbc24(keyCode, scanCode, modifiers);
         }

         if (keyCode == 257 && this.friendField.I_method_189fd283() && !this.friendField.I_method_d2579001().isBlank()) {
            this.sendFriendRequest();
         } else if (this.friendField.I_method_189fd283()) {
            this.friendField.I_method_c1acbc24(keyCode, scanCode, modifiers);
         }

         if (this.searchField.I_method_189fd283()) {
            this.searchField.I_method_c1acbc24(keyCode, scanCode, modifiers);
         }

         if (this.peopleField.I_method_189fd283()) {
            this.peopleField.I_method_c1acbc24(keyCode, scanCode, modifiers);
         }

         this.currentChat.getScrollHandler().I_method_93fc08a4(keyCode);
         return super.keyPressed(keyCode, scanCode, modifiers);
      }
   }

   @Compile
   @Override
   public boolean charTyped(char chr, int modifiers) {
      if (Information.getUser() == null) {
         this.form.charTyped(chr, modifiers);
         return false;
      } else if (this.profileOpen()) {
         return false;
      } else {
         if (this.sendField.I_method_189fd283()) {
            this.sendField.I_method_b71e84c9(chr, modifiers);
         }

         if (this.friendField.I_method_189fd283()) {
            this.friendField.I_method_b71e84c9(chr, modifiers);
         }

         if (this.searchField.I_method_189fd283()) {
            this.searchField.I_method_b71e84c9(chr, modifiers);
         }

         if (this.peopleField.I_method_189fd283()) {
            this.peopleField.I_method_b71e84c9(chr, modifiers);
         }

         return false;
      }
   }

   @Compile
   public void close() {
      this.closing = true;
      RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class).disable();
      RockstarClient.getInstance().getModuleManager().getModule(GlobalsMenuModule.class).disable();
      SoundsModule var1 = RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class);
      if (var1.isEnabled()) {
         iiIiIIIII_Class417.I_field_34b2ba6c.I_method_7289b65f(var1.I_method_45ee5ef(), 1.0F);
      }

      RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
      RockstarClient.getInstance().I_method_5198232b().II_method_1fbeeff5();
      if (IiIiIIIII_Class161.I_field_fdef2cc != null) {
         IiIiIIIII_Class161.I_field_fdef2cc.I_method_fb5b3035(false);
      }

      super.close();
   }

   public boolean shouldCloseOnEsc() {
      return true;
   }

   private Iii_Class4 avatarBox(float var1, Supplier<Identifier> var2, BooleanSupplier var3) {
      return this.avatarBox(var1, var2, var3, RocknetMenu::card);
   }

   private Iii_Class4 avatarBox(float var1, Supplier<Identifier> var2, BooleanSupplier var3, Supplier<ColorRGBA> var4) {
      return new Iii_Class4().size(var1, var1).interactive(false).paint((var4x, var5) -> {
         var4x.drawRoundedTexture((Identifier)var2.get(), var5.x(), var5.y(), var1, var1, IIiii_Class8.I_method_893b2757(var1 / 2.0F), ColorRGBA.WHITE);
         if (var3 != null && var3.getAsBoolean()) {
            float var6 = var1 * 0.26F;
            float var7 = 2.0F;
            float var8 = var6 + var7 * 2.0F;
            float var9 = var5.x() + var1 - var6;
            float var10 = var5.y() + var1 - var6;
            var4x.drawRoundedRect(var9 - var7, var10 - var7, var8, var8, IIiii_Class8.I_method_893b2757(var8 / 2.0F), (ColorRGBA)var4.get());
            var4x.drawRoundedRect(var9, var10, var6, var6, IIiii_Class8.I_method_893b2757(var6 / 2.0F), ONLINE);
         }
      });
   }

   private Iii_Class4 nickBox(
      IIiIIi_Class10 var1, float var2, Supplier<String> var3, Supplier<String> var4, Supplier<String> var5, Function<Iii_Class4, ColorRGBA> var6
   ) {
      return new Iii_Class4()
         .height(var1.I_method_a649725c())
         .fillWidth()
         .interactive(false)
         .paint(
            (var6x, var7) -> CosmeticRender.draw(
               var6x, var1, (String)var3.get(), var7.x(), var7.y(), (String)var4.get(), (String)var5.get(), (ColorRGBA)var6.apply(var7), var2, var7.w()
            )
         );
   }

   private Iii_Class4 iconButton(String var1, float var2, float var3, Runnable var4) {
      return new Iii_Class4()
         .size(var2, var2)
         .padding((var2 - var3) / 2.0F)
         .radius(7.0F)
         .icon(var1, var3, var0 -> second().mix(onAccent(), var0.hover()))
         .background(var0 -> card().mix(accent(), var0.hover()))
         .hoverMotion(STATE)
         .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
         .onClick(var4);
   }

   static ColorRGBA page() {
      return new ColorRGBA(8.0F, 8.0F, 11.0F);
   }

   static ColorRGBA card() {
      return new ColorRGBA(12.0F, 12.0F, 15.0F);
   }

   static ColorRGBA inset() {
      return new ColorRGBA(19.0F, 19.0F, 21.0F);
   }

   static ColorRGBA stroke() {
      return new ColorRGBA(113.0F, 113.0F, 123.0F, 63.75F);
   }

   static ColorRGBA stroke10() {
      return new ColorRGBA(113.0F, 113.0F, 123.0F, 25.5F);
   }

   static ColorRGBA text() {
      return new ColorRGBA(231.0F, 231.0F, 253.0F);
   }

   static ColorRGBA second() {
      return new ColorRGBA(113.0F, 113.0F, 123.0F);
   }

   static ColorRGBA accent() {
      return IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(255.0F);
   }

   static ColorRGBA accentHover() {
      return accent().mix(ColorRGBA.BLACK, 0.34F);
   }

   static ColorRGBA onAccent() {
      return IiiiiIIIi_Class242.I_method_85e10a8f(accent(), text(), page());
   }

   static ColorRGBA highlight(float var0) {
      return ColorRGBA.WHITE.withAlpha(255.0F * var0);
   }

   private Packets.Nested1_1da0dac9 friend(String var1) {
      return Information.friend(var1);
   }

   private Identifier chatAvatar() {
      return this.currentChat.getName().equals(GLOBAL_CHAT_ID)
         ? RockstarClient.id("rocknet/avatar.png")
         : Information.getAvatar(this.currentChat.getName());
   }

   private String chatTitle() {
      return this.currentChat.getName().equals(GLOBAL_CHAT_ID) ? IiIiIIII_Class81.I_method_f25a980a("rocknet.chat.global.name") : this.currentChat.getName();
   }

   private String chatSubtitle() {
      return !this.currentChat.getName().equals(GLOBAL_CHAT_ID)
         ? this.headStatus(this.currentChat.getName())
         : IiIiIIII_Class81.I_method_1410d1e5("rocknet.menu.subtitle_online", RocknetListener.getSiteOnline(), RocknetListener.getOnline());
   }

   private String globalPreview() {
      String var1 = this.lastMessagePreview(GLOBAL_CHAT_ID);
      return var1.isEmpty() ? IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.no_messages") : var1;
   }

   private String friendStatus(Packets.Nested1_1da0dac9 var1) {
      return this.lastSeenKnown(var1) ? IiIiIIiI_Class83.I_method_d9078808(var1.lastSeen()) : Activities.translate(var1.activity());
   }

   private String chatStatus(Packets.Nested1_1da0dac9 var1) {
      return this.lastSeenKnown(var1)
         ? IiIiIIII_Class81.I_method_1410d1e5("rocknet.status.last_seen", IiIiIIiI_Class83.I_method_d9078808(var1.lastSeen()))
         : Activities.translate(var1.activity());
   }

   private String rowStatus(String var1) {
      Packets.Nested1_1da0dac9 var2 = this.friend(var1);
      if (var2 != null) {
         return this.friendStatus(var2);
      } else {
         Packets.Nested1_a7cdbede var3 = Information.peer(var1);
         return var3 == null ? this.lastMessagePreview(var1) : this.peerStatus(var3, false);
      }
   }

   private String headStatus(String var1) {
      Packets.Nested1_1da0dac9 var2 = this.friend(var1);
      if (var2 != null) {
         return this.chatStatus(var2);
      } else {
         Packets.Nested1_a7cdbede var3 = Information.peer(var1);
         return var3 == null ? IiIiIIII_Class81.I_method_f25a980a("rocknet.people.loading") : this.peerStatus(var3, true);
      }
   }

   private String peerStatus(Packets.Nested1_a7cdbede var1, boolean var2) {
      if (!var1.status().isBlank()) {
         return Activities.translate(var1.status());
      } else if (var1.inGame()) {
         return IiIiIIII_Class81.I_method_f25a980a("rocknet.people.online");
      } else if (var1.online()) {
         return IiIiIIII_Class81.I_method_f25a980a("rocknet.status.website");
      } else if (var1.lastSeen() <= 0L) {
         return IiIiIIII_Class81.I_method_f25a980a("rocknet.status.offline");
      } else {
         return var2
            ? IiIiIIII_Class81.I_method_1410d1e5("rocknet.status.last_seen", IiIiIIiI_Class83.I_method_d9078808(var1.lastSeen()))
            : IiIiIIiI_Class83.I_method_d9078808(var1.lastSeen());
      }
   }

   private boolean online(String var1) {
      Packets.Nested1_1da0dac9 var2 = this.friend(var1);
      if (var2 != null) {
         return !Activities.offline(var2.activity());
      } else {
         Packets.Nested1_a7cdbede var3 = Information.peer(var1);
         return var3 != null && var3.online();
      }
   }

   private String nickStyle(String var1) {
      Packets.Nested1_1da0dac9 var2 = this.friend(var1);
      if (var2 != null) {
         return var2.nickStyle();
      } else {
         Packets.Nested1_a7cdbede var3 = Information.peer(var1);
         return var3 == null ? null : var3.nickStyle();
      }
   }

   private String badge(String var1) {
      Packets.Nested1_1da0dac9 var2 = this.friend(var1);
      if (var2 != null) {
         return var2.badge();
      } else {
         Packets.Nested1_a7cdbede var3 = Information.peer(var1);
         return var3 == null ? null : var3.badge();
      }
   }

   private String lastMessagePreview(String var1) {
      Message var2 = Information.byName(var1).getLatestMessage();
      if (var2 == null) {
         return "";
      } else {
         String var3 = var2.self() ? IiIiIIII_Class81.I_method_f25a980a("rocknet.menu.you") : var2.author().username();
         return IiIiIIII_Class81.I_method_1410d1e5("rocknet.menu.last_message", var3, var2.text());
      }
   }

   private boolean lastSeenKnown(Packets.Nested1_1da0dac9 var1) {
      return Activities.offline(var1.activity()) && var1.lastSeen() > 0L;
   }

   public static List<String> wrapText(String var0, float var1) {
      ArrayList var2 = new ArrayList();
      String[] var3 = var0.split(" ");
      String var4 = "";

      for (String var8 : var3) {
         String var9 = var4.isEmpty() ? var8 : var4 + " " + var8;
         float var10 = IiIiiIIiI_Class179.I_method_cc1ab81a(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var9);
         if (var10 <= var1) {
            var4 = var9;
         } else {
            if (!var4.isEmpty()) {
               var2.add(var4);
               var4 = "";
            }

            float var11 = IiIiiIIiI_Class179.I_method_cc1ab81a(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var8);
            if (var11 <= var1) {
               var4 = var8;
            } else {
               String var12 = "";
               Matcher var13 = Pattern.compile("\\X").matcher(var8);

               while (var13.find()) {
                  String var14 = var13.group();
                  String var15 = var12 + var14;
                  float var16 = IiIiiIIiI_Class179.I_method_cc1ab81a(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), var15);
                  if (var16 <= var1) {
                     var12 = var15;
                  } else {
                     if (!var12.isEmpty()) {
                        var2.add(var12);
                     }

                     var12 = var14;
                  }
               }

               if (!var12.isEmpty()) {
                  var4 = var12;
               }
            }
         }
      }

      if (!var4.isEmpty()) {
         var2.add(var4);
      }

      if (var2.isEmpty()) {
         var2.add("");
      }

      return var2;
   }

   @Generated
   public Rect getMenuWindow() {
      return this.menuWindow;
   }

   static final class Nested1_b9d18778 {
      private final String icon;
      private final String label;
      private final boolean danger;
      private final Runnable run;

      Nested1_b9d18778(String var1, String var2, boolean var3, Runnable var4) {
         this.icon = var1;
         this.label = var2;
         this.danger = var3;
         this.run = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_b9d18778[icon=" + this.icon() + ", label=" + this.label() + ", danger=" + this.danger() + ", run=" + this.run() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.icon());
         result = 31 * result + java.util.Objects.hashCode(this.label());
         result = 31 * result + java.util.Objects.hashCode(this.danger());
         result = 31 * result + java.util.Objects.hashCode(this.run());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         RocknetMenu.Nested1_b9d18778 other = (RocknetMenu.Nested1_b9d18778) var1;
         return java.util.Objects.equals(this.icon(), other.icon())
            && java.util.Objects.equals(this.label(), other.label())
            && java.util.Objects.equals(this.danger(), other.danger())
            && java.util.Objects.equals(this.run(), other.run());
      }

      public String icon() {
         return this.icon;
      }

      public String label() {
         return this.label;
      }

      public boolean danger() {
         return this.danger;
      }

      public Runnable run() {
         return this.run;
      }
   }

   static enum Nested1_bc4301f2 {
      CHATS,
      FRIENDS;
   }
}
