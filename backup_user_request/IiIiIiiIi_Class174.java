package rockstar.client;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameMode;
import pyrock.utility.render.ColorRGBA;

public class IiIiIiiIi_Class174 extends IiIiIIiII_Class165 {
   private static final Set<String> I_field_a56a8dc5 = Set.of(
      "\u029c\u1d07\u029f\u1d18\u1d07\u0280",
      "developer",
      "moder",
      "moder+",
      "moderator",
      "ml.moder",
      "st.moder",
      "gl.moder",
      "admin",
      "administrator",
      "st helper",
      "d helper",
      "d.helper",
      "helper",
      "media",
      "owner",
      "staff",
      "support",
      "yt",
      "youtube",
      "youtuber",
      "tiktok",
      "\u0445\u0435\u043b\u043f\u0435\u0440",
      "\u0441\u0442. \u043c\u043e\u0434\u0435\u0440",
      "\u0441\u0442. \u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a",
      "\u0441\u0442. \u0441\u0442\u0430\u0436\u0435\u0440",
      "\u0433\u043b. \u043c\u043e\u0434\u0435\u0440",
      "\u0433\u043b. \u0430\u0434\u043c\u0438\u043d",
      "\u0441\u0442.\u043c\u043e\u0434\u0435\u0440",
      "\u0441\u0442.\u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a",
      "\u0441\u0442.\u0441\u0442\u0430\u0436\u0435\u0440",
      "\u0433\u043b.\u043c\u043e\u0434\u0435\u0440",
      "\u0433\u043b.\u0430\u0434\u043c\u0438\u043d",
      "\u0441\u0442. \u043c\u043e\u0434\u0451\u0440",
      "\u0441\u0442. \u0441\u0442\u0430\u0436\u0451\u0440",
      "\u0433\u043b. \u043c\u043e\u0434\u0451\u0440",
      "\u043c\u043e\u0434\u0435\u0440",
      "\u043co\u0434e\u0440",
      "\u0441\u0442\u0430\u0436\u0435\u0440",
      "\u0441\u0442\u0430\u0436\u0451\u0440",
      "\u0430\u0434\u043c\u0438\u043d",
      "\u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a",
      "\u043a\u0443\u0440\u0430\u0442\u043e\u0440",
      "\u043c\u043b.\u0441\u043e\u0442\u0440\u0443\u0434\u043d\u0438\u043a",
      "\u043f\u043e\u0434\u0434\u0435\u0440\u0436\u043a\u0430",
      "\u043c\u043e\u0434\u0435\u0440\u0430\u0442\u043e\u0440",
      "\u0441\u043f\u0435\u043a\u0442\u0430\u0442\u043e\u0440",
      "\ua509",
      "\ua513",
      "\ua517",
      "\ua521",
      "\ua525"
   );
   private final BooleanSetting I_field_ba20ca4c = new BooleanSetting(this, "hud.always_display");
   private final IiIIIIIII_Class129 I_field_73178aac = new IiIIIIIII_Class129(this, "hud.uniform_width");
   private final List<IiIiIiiIi_Class174.Nested1_a64fb040> I_field_7865b31 = new ArrayList<>();
   private final Map<String, IiIiIiiIi_Class174.Nested1_a64fb040> I_field_a567c40b = new HashMap<>();
   private final Map<String, iiI_Class7> i_field_a567c40b = new HashMap<>();
   private final Set<String> i_field_a56a8dc5 = new HashSet<>();
   private boolean I_field_5a;
   private iii_Class8 I_field_b584628c;
   private iiI_Class7 I_field_b5845eac;
   private final IiiI_Class7 I_field_f94500c1 = (var1, var2, var3) -> {
      var3.I_field_46 = var1;
      var3.i_field_46 = (this.I_field_5a ? 6.0F : -6.0F) * (1.0F - var1);
   };

   public IiIiIiiIi_Class174() {
      super("hud.staff_list", "hud/staff");
   }

   @Override
   protected iii_Class8 build() {
      this.i_field_a567c40b.clear();
      this.i_field_a56a8dc5.clear();
      this.I_field_b584628c = new iii_Class8().I_method_485bccf5().I_method_483797dd(this.I_method_45bf6215()).I_method_70a38517(1.0F);
      this.I_field_b5845eac = new iii_Class8()
         .i_method_c88da8d5()
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_70a38517(3.0F)
         .IiI_method_31d4c97(11.0F)
         .I_method_7e2bb176(IIII.i_method_4f8e6e83(3.0F))
         .I_method_f136b1d8(
            (var1, var2) -> {
               var1.drawClientRect(var2.x(), var2.y(), var2.w(), var2.h(), this.animation.I_method_6ac4da6f(), this.dragAnim.I_method_6ac4da6f(), 3.0F, 3.0F);
               var1.drawSquircle(
                  var2.x(),
                  var2.y(),
                  23.0F,
                  var2.h(),
                  3.0F,
                  IIiii_Class8.I_method_893b2757(3.0F),
                  new IiIii_Class12(IiiiiIIIi_Class242.Iii_field_d0c8ec5.mulAlpha(0.1F), IiiiiIIIi_Class242.Iii_field_d0c8ec5.mulAlpha(0.0F))
               );
            }
         )
         .I_method_8939bffd(new Iii_Class4().size(7.0F, 7.0F).interactive(false).icon("hud/staff", 7.0F, IiiiiIIIi_Class242.ii_field_d0c8ec5))
         .I_method_8939bffd(
            new Iii_Class4()
               .interactive(false)
               .text(
                  IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(6.0F),
                  () -> IiIiIIII_Class81.I_method_f25a980a(this.name),
                  var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5
               )
         );
      this.I_field_b584628c.I_method_8939bffd(this.I_field_b5845eac);
      this.I_method_d3ee625f();
      return this.I_field_b584628c;
   }

   private iiI_Class7 I_method_bfdae93f(String var1) {
      iiI_Class7 var2 = this.i_field_a567c40b
         .computeIfAbsent(
            var1,
            var1x -> {
               IIiIIi_Class10 var2x = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F);
               return new iii_Class8()
                  .i_method_c88da8d5()
                  .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
                  .I_method_70a38517(1.0F)
                  .II_method_32b63e79(this.I_field_f94500c1)
                  .I_method_8939bffd(
                     new Iii_Class4()
                        .interactive(false)
                        .height(10.0F)
                        .radius(2.0F)
                        .padding(IIII.i_method_4f8e6e83(3.0F))
                        .background(var0 -> IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.889F))
                        .text(var2x, () -> this.I_method_8dc4a157(var1x), var2xx -> this.I_method_dd20d4d8(var1x))
                        .visibleWhen(() -> !this.I_method_8dc4a157(var1x).isEmpty())
                  )
                  .I_method_8939bffd(
                     new Iii_Class4()
                        .interactive(false)
                        .fillWidth()
                        .height(10.0F)
                        .radius(2.0F)
                        .padding(IIII.i_method_4f8e6e83(3.0F))
                        .background(var0 -> IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.94F))
                        .text(var2x, () -> this.i_method_ade38977(var1x), var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5)
                  )
                  .I_method_8939bffd(
                     new Iii_Class4()
                        .size(10.0F, 10.0F)
                        .interactive(false)
                        .radius(2.0F)
                        .background(var0 -> IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.94F))
                        .paint(
                           (var2xx, var3) -> {
                              IiIiIiiIi_Class174.Nested1_a64fb040 var4 = this.I_field_a567c40b.get(var1x);
                              ColorRGBA var5 = var4 != null && var4.I_method_b7de7b7e()
                                 ? new ColorRGBA(220.0F, 70.0F, 70.0F)
                                 : new ColorRGBA(70.0F, 210.0F, 120.0F);
                              float var6 = 4.0F;
                              var2xx.drawRoundedRect(
                                 var3.x() + var3.w() / 2.0F - var6 / 2.0F,
                                 var3.y() + var3.h() / 2.0F - var6 / 2.0F,
                                 var6,
                                 var6,
                                 IIiii_Class8.I_method_893b2757(var6 / 2.0F),
                                 var5
                              );
                           }
                        )
                  );
            }
         );
      if (var2.phase() == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866
         || var2.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866
         || var2.phase() == iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
         var2.beginEnter(0.0F);
      }

      return var2;
   }

   private void I_method_d3ee625f() {
      HashSet var1 = new HashSet();

      for (IiIiIiiIi_Class174.Nested1_a64fb040 var3 : this.I_field_7865b31) {
         var1.add(var3.I_method_4e469c66());
      }

      if (!var1.equals(this.i_field_a56a8dc5)) {
         this.i_field_a56a8dc5.clear();
         this.i_field_a56a8dc5.addAll(var1);
         IIiIIi_Class10 var9 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F);
         HashMap var10 = new HashMap();

         for (IiIiIiiIi_Class174.Nested1_a64fb040 var5 : this.I_field_7865b31) {
            var10.put(
               var5.I_method_4e469c66(),
               var9.I_method_2c375926(this.I_method_e852c213(var5).I_method_8137446()) + var9.I_method_2c375926(this.I_method_4ab966de(var5))
            );
         }

         ArrayList var11 = new ArrayList<>(this.I_field_7865b31);
         var11.sort(
            Comparator.<IiIiIiiIi_Class174.Nested1_a64fb040>comparingDouble(var1x -> ((Float)var10.get(var1x.I_method_4e469c66())).floatValue()).reversed()
         );
         ArrayList var12 = new ArrayList();
         var12.add(this.I_field_b5845eac);
         HashSet var6 = new HashSet();

         for (IiIiIiiIi_Class174.Nested1_a64fb040 var8 : (Iterable<IiIiIiiIi_Class174.Nested1_a64fb040>)(Iterable<?>)var11) {
            if (var6.add(var8.I_method_4e469c66())) {
               var12.add(this.I_method_bfdae93f(var8.I_method_4e469c66()));
            }
         }

         this.I_field_b584628c.II_method_244860a9(var12);
      }
   }

   @Override
   public void update(III var1) {
      this.I_field_5a = this.x + this.width / 2.0F >= iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() / 2.0F;
      this.i_method_d3fcee3f();
      if (this.I_field_b584628c != null) {
         this.I_field_b584628c.I_method_483797dd(this.I_method_45bf6215());
         this.I_method_d3ee625f();
      }

      super.update(var1);
   }

   private IIi_Class2 I_method_45bf6215() {
      return this.I_field_73178aac.i_method_9b12da03()
         ? IIi_Class2.Ii_field_b5755e8c
         : (this.I_field_5a ? IIi_Class2.II_field_b5755e8c : IIi_Class2.I_field_b5755e8c);
   }

   private void i_method_d3fcee3f() {
      this.I_field_7865b31.clear();
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.player.networkHandler != null) {
         if (I_field_3a9bda27.player.networkHandler.getServerInfo() == null) {
            this.I_field_7865b31
               .add(
                  new IiIiIiiIi_Class174.Nested1_a64fb040(
                     Text.literal("[ADMIN] ").setStyle(Style.EMPTY.withColor(Formatting.RED)), IiIiIIII_Class81.I_method_f25a980a("staff.herobrine"), false
                  )
               );
         } else {
            I_field_3a9bda27.player.networkHandler.getPlayerList().forEach(var1 -> {
               Team var2x = I_field_3a9bda27.world.getScoreboard().getScoreHolderTeam(var1.getProfile().getName());
               if (var2x != null) {
                  MutableText var3x = var2x.getPrefix().copy();
                  String var4x = var1.getProfile().getName().replace("\u26a1 ", "");
                  boolean var5 = var1.getGameMode() == GameMode.SPECTATOR;
                  String var6x = this.II_method_211f3bf4(var3x.getString());
                  if (var6x != null && !var4x.isBlank()) {
                     MutableText var7 = Text.literal(var6x).setStyle(Style.EMPTY.withColor(var3x.getStyle().getColor()));
                     this.I_field_7865b31.add(new IiIiIiiIi_Class174.Nested1_a64fb040(var7, var4x.trim(), var5));
                  }
               }
            });
         }

         for (IiIIIIiii_Class136.Nested1_739d8c40 var2 : RockstarClient.getInstance().I_method_98af9842().I_method_f4439a28()) {
            if (!var2.I_method_13877866().isBlank()) {
               String var3 = var2.i_method_a6a62886().isBlank() ? "MODER" : var2.i_method_a6a62886().trim();
               MutableText var4 = Text.literal("[" + var3 + "] ").setStyle(Style.EMPTY.withColor(Formatting.BLUE));
               this.I_field_7865b31.add(new IiIiIiiIi_Class174.Nested1_a64fb040(var4, var2.I_method_13877866(), false));
            }
         }

         this.I_field_a567c40b.clear();

         for (IiIiIiiIi_Class174.Nested1_a64fb040 var6 : this.I_field_7865b31) {
            this.I_field_a567c40b.put(var6.I_method_4e469c66(), var6);
         }
      } else {
         this.I_field_a567c40b.clear();
      }
   }

   private String I_method_8dc4a157(String var1) {
      IiIiIiiIi_Class174.Nested1_a64fb040 var2 = this.I_field_a567c40b.get(var1);
      return var2 == null ? "" : this.I_method_e852c213(var2).I_method_8137446();
   }

   private ColorRGBA I_method_dd20d4d8(String var1) {
      IiIiIiiIi_Class174.Nested1_a64fb040 var2 = this.I_field_a567c40b.get(var1);
      return var2 == null ? IiiiiIIIi_Class242.iI_method_8e08d3b1() : this.I_method_e852c213(var2).I_method_fc41e609();
   }

   private String i_method_ade38977(String var1) {
      IiIiIiiIi_Class174.Nested1_a64fb040 var2 = this.I_field_a567c40b.get(var1);
      return var2 == null ? "" : this.I_method_4ab966de(var2);
   }

   @Override
   public boolean show() {
      return !this.I_field_7865b31.isEmpty() || I_field_3a9bda27.currentScreen instanceof ChatScreen || this.I_field_ba20ca4c.i_method_9b12da03();
   }

   private String II_method_211f3bf4(String var1) {
      if (var1 == null) {
         return null;
      } else {
         String var2 = Normalizer.normalize(var1, Form.NFKC).toLowerCase(Locale.ROOT).trim();
         int var3 = 0;
         int var4 = var2.length();

         while (var3 < var4) {
            int var5 = var2.codePointAt(var3);
            if (Character.isLetterOrDigit(var5)) {
               break;
            }

            var3 += Character.charCount(var5);
         }

         while (var4 > var3) {
            int var9 = var2.codePointBefore(var4);
            if (Character.isLetterOrDigit(var9) || var9 == 43) {
               break;
            }

            var4 -= Character.charCount(var9);
         }

         StringBuilder var10 = new StringBuilder(var4 - var3);
         boolean var6 = false;
         int var7 = var3;

         while (var7 < var4) {
            int var8 = var2.codePointAt(var7);
            var7 += Character.charCount(var8);
            if (!Character.isWhitespace(var8) && !Character.isSpaceChar(var8)) {
               if (var6) {
                  var10.append(' ');
               }

               var10.appendCodePoint(var8);
               var6 = false;
            } else {
               var6 = var10.length() > 0;
            }
         }

         String var11 = var10.toString();
         return !I_field_a56a8dc5.contains(var11)
            ? null
            : var11.replace("\ua509", "helper")
               .replace("\ua513", "ml.moder")
               .replace("\ua517", "moder")
               .replace("\ua521", "moder+")
               .replace("\ua525", "st.moder");
      }
   }

   private IiIiIiiIi_Class174.Nested1_a64fb020 I_method_e852c213(IiIiIiiIi_Class174.Nested1_a64fb040 var1) {
      Text var2 = this.I_method_5bacc5f8(var1);
      String var3 = var2.getString().trim().toUpperCase();
      TextColor var4 = var2.getStyle().getColor();
      ColorRGBA var5 = var4 != null ? I_method_e33eb2f3(var4.getRgb()) : IiiiiIIIi_Class242.iI_method_8e08d3b1();
      return new IiIiIiiIi_Class174.Nested1_a64fb020(var3, var5);
   }

   private static ColorRGBA I_method_e33eb2f3(int var0) {
      return new ColorRGBA(var0 >> 16 & 0xFF, var0 >> 8 & 0xFF, var0 & 0xFF);
   }

   private Text I_method_5bacc5f8(IiIiIiiIi_Class174.Nested1_a64fb040 var1) {
      String var2 = var1.I_method_7d69c770().getString();
      String var3 = var2.toLowerCase()
         .replace("\ua509", "HELPER")
         .replace("\ua513", "ML.MODER")
         .replace("\ua517", "MODER")
         .replace("\ua521", "MODER+")
         .replace("\ua525", "st.MODER")
         .trim();
      boolean var4 = var2.contains("\ua509") || var2.contains("\ua513") || var2.contains("\ua517") || var2.contains("\ua521") || var2.contains("\ua525");
      TextColor var5 = var1.I_method_7d69c770().getStyle().getColor();
      TextColor var6 = var5;
      if (var4 || var5 == null) {
         Formatting var7;
         if (var3.contains("HELPER")) {
            var7 = Formatting.YELLOW;
         } else if (var3.contains("MODER")) {
            var7 = Formatting.BLUE;
         } else {
            var7 = Formatting.GRAY;
         }

         var6 = TextColor.fromFormatting(var7);
      }

      return Text.literal(var3).setStyle(Style.EMPTY.withColor(var6));
   }

   private String I_method_4ab966de(IiIiIiiIi_Class174.Nested1_a64fb040 var1) {
      NameProtectModule var2 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
      return var2.isEnabled() ? var2.II_method_6ed9f394(var1.I_method_4e469c66()) : var1.I_method_4e469c66();
   }

   static final class Nested1_a64fb020 {
      private final String I_field_523beb0a;
      private final ColorRGBA I_field_d0c8ec5;

      Nested1_a64fb020(String var1, ColorRGBA var2) {
         this.I_field_523beb0a = var1;
         this.I_field_d0c8ec5 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_a64fb020[text=" + this.I_field_523beb0a + ", color=" + this.I_field_d0c8ec5 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_d0c8ec5);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiIiiIi_Class174.Nested1_a64fb020 other = (IiIiIiiIi_Class174.Nested1_a64fb020) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_d0c8ec5, other.I_field_d0c8ec5);
      }

      public String I_method_8137446() {
         return this.I_field_523beb0a;
      }

      public ColorRGBA I_method_fc41e609() {
         return this.I_field_d0c8ec5;
      }
   }

   static final class Nested1_a64fb040 {
      private final Text I_field_33c1784c;
      private final String I_field_523beb0a;
      private final boolean I_field_5a;

      Nested1_a64fb040(Text var1, String var2, boolean var3) {
         this.I_field_33c1784c = var1;
         this.I_field_523beb0a = var2;
         this.I_field_5a = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_a64fb040[prefix=" + this.I_field_33c1784c + ", name=" + this.I_field_523beb0a + ", isSpec=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_33c1784c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiIiIiiIi_Class174.Nested1_a64fb040 other = (IiIiIiiIi_Class174.Nested1_a64fb040) var1;
         return java.util.Objects.equals(this.I_field_33c1784c, other.I_field_33c1784c)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public Text I_method_7d69c770() {
         return this.I_field_33c1784c;
      }

      public String I_method_4e469c66() {
         return this.I_field_523beb0a;
      }

      public boolean I_method_b7de7b7e() {
         return this.I_field_5a;
      }
   }
}
