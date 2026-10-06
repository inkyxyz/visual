package rockstar.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.EntityS2CPacketAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommonNetworkHandler.ConfirmServerResourcePackScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket.Status;
import net.minecraft.network.packet.s2c.play.EntityS2CPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import pyrock.events.game.AttackEvent;
import pyrock.events.game.EventSetCooldown;
import pyrock.events.game.FinishEatEvent;
import pyrock.events.game.SendMessageEvent;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.InputEvent;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import pyrock.utility.render.CustomDrawContext;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Assist",
   category = ModuleCategory.OTHER,
   III_method_a89e5834 = "modules.descriptions.assist"
)
public class AssistModule extends Module {
   private final BooleanSupplier I_field_7bf34412 = () -> this.IiiI_method_1bb52cc6()
      && !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iiI_field_ac164e6c);
   private final BooleanSupplier i_field_7bf34412 = () -> this.IiiI_method_1bb52cc6()
      && !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iII_field_ac164e6c);
   private final BooleanSupplier II_field_7bf34412 = () -> this.IiiI_method_1bb52cc6()
      && !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iIi_field_ac164e6c);
   private ButtonSetting I_field_bbd4b28c;
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private BooleanSetting Ii_field_ba20ca4c;
   private BooleanSetting iI_field_ba20ca4c;
   private BooleanSetting ii_field_ba20ca4c;
   private BooleanSetting III_field_ba20ca4c;
   private BooleanSetting IIi_field_ba20ca4c;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private BooleanSetting IiI_field_ba20ca4c;
   private BooleanSetting Iii_field_ba20ca4c;
   private BooleanSetting iII_field_ba20ca4c;
   private BooleanSetting iIi_field_ba20ca4c;
   private BooleanSetting iiI_field_ba20ca4c;
   private BooleanSetting iii_field_ba20ca4c;
   private BooleanSetting IIII_field_ba20ca4c;
   private BooleanSetting IIIi_field_ba20ca4c;
   private BooleanSetting IIiI_field_ba20ca4c;
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   private final List<iIiIIiII_Class165> I_field_7865b31 = iIiIIiiI_Class167.I_method_57a2a7bb();
   private final List<iIiIIiII_Class165> i_field_7865b31 = new ArrayList<>();
   private final Set<String> I_field_a56a8dc5 = new HashSet<>(
      Arrays.asList(
         "\u0430\u043a\u0440\u0438\u0435\u043d(\u0430|\u0443|\u043e\u043c|\u0435|\u0447\u0438\u043a)?",
         "\u0440\u0438\u0447(\u0430|\u0443|\u043e\u043c|\u0435\u0439|\u0435)?",
         "\u043d\u044c\u044e\u043a\u043e\u0434(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0438\u043a|\u0435)?",
         "\u044d\u043a\u0441\u043f\u0435\u043d\u0441\u0438\u0432(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0435)?",
         "\u0438\u043c\u043f\u0430\u043a\u0442(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0438\u043a|\u0435)?",
         "\u044d\u043a\u0441\u0435\u043b\u043b\u0435\u043d\u0442(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0438\u043a|\u0435)?",
         "\u044d\u043a\u0441\u0435\u043b\u0435\u043d\u0442(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0438\u043a)?",
         "\u043a\u0430\u0442\u043b\u0430\u0432\u0430\u043d(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0447\u0438\u043a)?",
         "\u043a\u0430\u0442\u043b\u043e\u0432\u0430\u043d(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0447\u0438\u043a)?",
         "\u0446\u0435\u043b\u0435\u0441\u0442\u0438\u0430\u043b(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0435)?",
         "\u0446\u0435\u043b\u043a(\u043e\u0439|\u0430|\u0443|\u0430\u043c\u0438|\u043e\u0447\u043a\u0430|\u0435)?",
         "\u043c\u0430\u0442\u0438\u043a\u0441(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0435)?",
         "\u0438\u043d\u0435\u0440\u0442\u0438(\u044f|\u0435\u0439|\u044e|\u044f\u043c\u0438|\u0435)?",
         "\u044d\u043a\u0441\u043f(\u0430|\u043e\u0439|\u043e\u044e|\u0443|\u0443\u043b\u0438\u0447\u043a\u0430|\u0435)?",
         "\u0444\u043b\u044e\u0433\u0435\u0440(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438)?",
         "\u0440\u0438\u043a\u0435\u0440(\u0430|\u0443|\u043e\u043c|\u043e\u0447\u0435\u043a)?",
         "\u0444\u0430\u043d\u043f\u0435(\u0439|\u044e|\u044f|\u0435\u043c|\u0435|\u0439\u0447\u0438\u043a)?",
         "\u0432\u0435\u043a\u0441\u0430\u0439\u0434(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0438\u043a|\u0435)?",
         "\u043d\u0443\u0440\u0441\u0443\u043b\u0442\u0430\u043d(\u0430|\u0443|\u0435|\u043e\u043c|\u0447\u0438\u043a)?",
         "\u043d\u0443\u0440\u0438\u043a(\u0430|\u0443|\u043e\u043c|\u0435)?",
         "\u043d\u0443\u0440\u043b\u0430\u043d(\u0430|\u0443|\u043e\u043c|\u0447\u0438\u043a|\u0435)?",
         "\u0432\u0435\u043a\u0441(\u043e\u043c|\u0443|\u0430|\u0430\u043c\u0438|\u0438\u043a|\u0435)?",
         "\u0440\u0435\u043b\u0435\u0439\u043a(\u043e\u043c|\u0443|\u0430|\u0430\u043c\u0438|\u0435)?",
         "\u0430\u0440\u0431\u0443\u0437(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0438\u043a|\u0435)?",
         "\u0432\u0438\u043b\u0434(\u043e\u043c|\u0443|\u0430|\u0430\u043c\u0438|\u0438\u043a|\u0435)?",
         "\u0444\u0430\u043d\u0442\u0430\u0439\u043c(\u0435|\u0430|\u0443)?",
         "\u0445\u043e\u043b\u0438\u043a(\u0435|\u0430|\u0443)?",
         "\u0445\u043e\u043b\u0438\u0432\u043e\u0440\u043b\u0434(\u0430|\u0443|\u0435)?",
         "\u0440\u043e\u043a\u0441\u0442\u0430\u0440(\u043e\u043c|\u0430|\u0443|\u0430\u043c\u0438|\u0447\u0438\u043a|\u0435)?",
         "\u0440\u043e\u0433\u0430\u043b\u0438\u043a(\u0430|\u0443|\u043e\u043c|\u0435)?",
         "\u0442\u0430\u043d\u0434\u0435\u0440\u0445\u0430\u043a(\u043e\u043c|\u0443|\u0438|\u0430\u043c\u0438|\u0430|\u0435)?",
         "\u043b\u0438\u043a\u0432\u0438\u0434\u0431\u0430\u0443\u043d\u0441(\u0430|\u0443|\u0430\u043c\u0438|\u0435)?",
         "expensive",
         "celestial",
         "newcode",
         "arbuz",
         "akrien",
         "nursultan",
         "relake",
         "wild",
         "wurst",
         "catlovan",
         "excellent",
         "rockstar",
         "catlavan",
         "impact",
         "matix",
         "inertia",
         "wex",
         "wexside",
         "nurik",
         "nurlan",
         "rich",
         "funpay",
         "fluger",
         "riker",
         "funtime",
         "holyworld",
         "wwe",
         "hvh",
         "rogalik",
         "thunderhack",
         "liquidbounce"
      )
   );
   private final List<Pattern> II_field_7865b31 = new ArrayList<>();
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private final iiIiIIiii_Class424 II_field_991c1e8c;
   private final iiIiIIiii_Class424 Ii_field_991c1e8c;
   private final iiIiIIiii_Class424 iI_field_991c1e8c;
   private final iiIiIIiii_Class424 ii_field_991c1e8c;
   private final IiiiIiIi_Class118 I_field_10f5ef21;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private boolean II_field_5a;
   private boolean Ii_field_5a;
   private int I_field_49;
   private boolean iI_field_5a;
   private boolean ii_field_5a;
   private int i_field_49;
   private iIIiiiIii_Class316 I_field_48ddb68c;
   private boolean III_field_5a;
   private boolean IIi_field_5a;
   private final Set<Integer> i_field_a56a8dc5;
   private final IiIIIiII_Class69<MouseEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<KeyPressEvent> i_field_3d936f41;
   private final IiIIIiII_Class69<EventSetCooldown> II_field_3d936f41;
   private final IiIIIiII_Class69<ReceivePacketEvent> Ii_field_3d936f41;
   private final IiIIIiII_Class69<SendMessageEvent> iI_field_3d936f41;
   private final IiIIIiII_Class69<AttackEvent> ii_field_3d936f41;
   private final IiIIIiII_Class69<FinishEatEvent> III_field_3d936f41;
   private final IiIIIiII_Class69<FinishEatEvent> IIi_field_3d936f41;
   private final IiIIIiII_Class69<InputEvent> IiI_field_3d936f41;
   private iIIiIiIii_Class300 I_field_1242a2ac;
   private boolean IiI_field_5a;
   private boolean Iii_field_5a;
   private final iiIiIIiii_Class424 III_field_991c1e8c;
   private final IiIIIiII_Class69<HudRenderEvent> Iii_field_3d936f41;
   private final IiIIIiII_Class69<FinishEatEvent> iII_field_3d936f41;

   public AssistModule() {
      for (String var2 : this.I_field_a56a8dc5) {
         try {
            this.II_field_7865b31.add(Pattern.compile("\\b" + var2 + "\\b", 322));
         } catch (Exception var4) {
            this.II_field_7865b31.add(Pattern.compile(Pattern.quote(var2), 258));
         }
      }

      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.II_field_991c1e8c = new iiIiIIiii_Class424();
      this.Ii_field_991c1e8c = new iiIiIIiii_Class424();
      this.iI_field_991c1e8c = new iiIiIIiii_Class424();
      this.ii_field_991c1e8c = new iiIiIIiii_Class424();
      this.I_field_10f5ef21 = new IiiiIiIi_Class118();
      this.i_field_5a = true;
      this.II_field_5a = true;
      this.i_field_49 = -1;
      this.i_field_a56a8dc5 = new HashSet<>();
      this.I_field_3d936f41 = var1 -> {
         if (var1.getAction() == 1) {
            if (I_field_3a9bda27.currentScreen == null) {
               this.II_method_621d1a21(var1.getButton());
            }
         }
      };
      this.i_field_3d936f41 = var1 -> {
         if (var1.getAction() == 1) {
            if (I_field_3a9bda27.currentScreen == null) {
               this.II_method_621d1a21(var1.getKey());
            }
         }
      };
      this.II_field_3d936f41 = var1 -> {
         if (this.ii_field_ba20ca4c.i_method_9b12da03()) {
            Item var2x = (Item)Registries.ITEM.get(var1.getCooldownGroup());
            if (var2x == Items.ENCHANTED_GOLDEN_APPLE || var2x == Items.GOLDEN_APPLE || var2x == Items.POTION || var2x == Items.CHORUS_FRUIT) {
               var1.setCooldown(var1.getCooldown() - 32);
            }
         }
      };
      this.Ii_field_3d936f41 = var1 -> {
         if (this.IiI_field_ba20ca4c.i_method_9b12da03() && var1.getPacket() instanceof GameMessageS2CPacket var2x) {
            String var9 = var2x.content().getString().toLowerCase();
            if (var9.contains("10,000 \u0431\u044b\u043b\u043e \u043d\u0430\u0447\u0438\u0441\u043b\u0435\u043d\u043e \u0432\u0430\u043c")
               || var9.contains("\u043f\u043e\u0432\u0442\u043e\u0440\u0438\u0442\u0435 \u0442\u0435\u043a\u0441\u0442 \u0435\u0449\u0435 \u0440\u0430\u0437")) {
               this.II_field_5a = false;
               this.I_field_991c1e8c.I_method_23e11e3f();
            }
         }

         if (this.Iii_field_ba20ca4c.i_method_9b12da03() && var1.getPacket() instanceof GameMessageS2CPacket var4x) {
            this.I_field_10f5ef21.I_method_b3f68336(var4x.content().getString());
         }

         if (this.iIi_field_ba20ca4c.i_method_9b12da03() && var1.getPacket() instanceof GameMessageS2CPacket var5) {
            String var12 = var5.content().getString();
            if (var12.contains(
               "\u0412\u044b \u0443\u0436\u0435 \u0430\u043a\u0442\u0438\u0432\u0438\u0440\u043e\u0432\u0430\u043b\u0438 \u044d\u0442\u043e\u0442 \u043f\u0440\u043e\u043c\u043e\u043a\u043e\u0434"
            )) {
               this.i_field_5a = false;
               this.I_field_991c1e8c.I_method_23e11e3f();
            } else if (var12.contains(
               "\u041f\u0440\u044f\u043c\u043e \u0441\u0435\u0439\u0447\u0430\u0441 \u0438\u0434\u0435\u0442 \u043d\u0430\u0431\u043e\u0440"
            )) {
               this.i_field_5a = true;
            }
         }

         if (this.iiI_field_ba20ca4c.i_method_9b12da03() && var1.getPacket() instanceof GameMessageS2CPacket var6) {
            String var14 = var6.content().getString();
            if (var14.contains("\u041d\u0435 \u0434\u0432\u0438\u0433\u0430\u0439\u0442\u0435\u0441\u044c")) {
               this.I_field_5a = true;
               this.i_field_991c1e8c.I_method_23e11e3f();
               System.out.println("stop");
            }
         }

         if (this.II_field_ba20ca4c.i_method_9b12da03() && var1.getPacket() instanceof OpenScreenS2CPacket var7) {
            String var16 = var7.getName().getString();
            if (var16.contains("\u041c\u0435\u043d\u044e") || var16.contains("\ua201\ua000\ua202\ua301\ua202\ua001")) {
               I_field_3a9bda27.player.closeScreen();
               var1.cancel();
            }
         }

         if (this.iII_field_ba20ca4c.i_method_9b12da03() && this.iI_field_5a && var1.getPacket() instanceof EntityS2CPacket var8) {
            LivingEntity var18 = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
            if (var18 != null && ((EntityS2CPacketAccessor)(Object)var8).getId() == var18.getId()) {
               this.iI_field_991c1e8c.I_method_23e11e3f();
            }
         }
      };
      this.iI_field_3d936f41 = var1 -> {
         if (this.I_method_d6773e2d(var1.getMessage())) {
            var1.cancel();
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of(IiIiIIII_Class81.I_method_f25a980a("assist.ct_command_blocked")));
         } else if (this.iI_field_ba20ca4c.i_method_9b12da03()) {
            for (Pattern var3 : this.II_field_7865b31) {
               if (var3.matcher(var1.getMessage()).find()) {
                  var1.cancel();
                  iIIIIIIii_Class260.II_method_e8fd4864(
                     Text.of(
                        "\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043d\u0435 \u0431\u044b\u043b\u043e \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e \u0442.\u043a. \u0432 \u043d\u0435\u043c \u043f\u0440\u0438\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u0435\u0442 \u0437\u0430\u043f\u0440\u0435\u0449\u0435\u043d\u043d\u043e\u0435 \u0441\u043b\u043e\u0432\u043e"
                     )
                  );
                  return;
               }
            }
         }
      };
      this.ii_field_3d936f41 = var1 -> {
         if (this.iII_field_ba20ca4c.i_method_9b12da03() && this.iI_field_5a) {
            var1.cancel();
         }
      };
      this.III_field_3d936f41 = var1 -> {
         if (this.iII_field_ba20ca4c.i_method_9b12da03()) {
            if (this.iI_field_5a) {
               if (var1.getUser() == I_field_3a9bda27.player) {
                  if (var1.getStack().getItem() == Items.CHORUS_FRUIT) {
                     this.IIII_method_e35728c2();
                  }
               }
            }
         }
      };
      this.IIi_field_3d936f41 = var1 -> {
         if (this.IIIi_field_ba20ca4c.i_method_9b12da03()
            && iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Ii_field_ac164e6c)
            && !iIIIiiiII_Class285.I_field_5a) {
            if (var1.getUser() == I_field_3a9bda27.player) {
               if (var1.getStack().isOf(Items.ENCHANTED_GOLDEN_APPLE)) {
                  IIIiiiIi_Class30 var2x = RockstarClient.getInstance().I_method_b4d046cb();
                  if (var2x != null) {
                     var2x.I_method_9e86975a(var2x.I_method_80ea594() + "rct");
                  }
               }
            }
         }
      };
      this.IiI_field_3d936f41 = var1 -> {
         if (this.iiI_field_ba20ca4c.i_method_9b12da03() && this.I_field_5a && !this.i_field_991c1e8c.I_method_58432069(4000L)) {
            var1.setForward(0.0F);
            var1.setJump(false);
            var1.setStrafe(0.0F);
            var1.setSprint(false);
         }
      };
      this.I_field_1242a2ac = null;
      this.IiI_field_5a = false;
      this.Iii_field_5a = false;
      this.III_field_991c1e8c = new iiIiIIiii_Class424();
      this.Iii_field_3d936f41 = var1 -> {
         if (iIIIiiiII_Class285.I_field_5a && this.iii_field_ba20ca4c.i_method_9b12da03()) {
            CustomDrawContext var2x = var1.getContext();
            if (!I_field_3a9bda27.player.hasStatusEffect(StatusEffects.STRENGTH)) {
               iIiiiIIiI_Class371.I_method_54c364d7(
                  var2x,
                  var0 -> var0.getItem() == Items.POTION && iIIIIIiII_Class261.I_method_afec1b5a(var0, StatusEffects.STRENGTH),
                  IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.85F)
               );
            }

            if (!(I_field_3a9bda27.player.getHealth() + I_field_3a9bda27.player.getAbsorptionAmount() > 19.0F)) {
               if (this.III_field_991c1e8c.I_method_58432069(iIIIiiiII_Class285.Ii_method_b349c526() ? 10000L : 20000L)) {
                  iIiiiIIiI_Class371.I_method_54c364d7(
                     var2x,
                     var0 -> var0.getItem() == Items.POTION && iIIIIIiII_Class261.I_method_afec1b5a(var0, StatusEffects.INSTANT_HEALTH),
                     IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.85F)
                  );
               } else if (I_field_3a9bda27.player.getHungerManager().getFoodLevel() < 20) {
                  iIiiiIIiI_Class371.I_method_9d0fd75a(var2x, Items.GOLDEN_CARROT, IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.85F));
               } else if (!I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(Items.GOLDEN_APPLE.getDefaultStack())) {
                  iIiiiIIiI_Class371.I_method_9d0fd75a(var2x, Items.GOLDEN_APPLE, IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.85F));
               } else {
                  iIiiiIIiI_Class371.I_method_9d0fd75a(var2x, Items.ENCHANTED_GOLDEN_APPLE, IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.85F));
               }
            }
         }
      };
      this.iII_field_3d936f41 = var1 -> {
         if (var1.getUser() == I_field_3a9bda27.player) {
            if (iIIIIIiII_Class261.I_method_afec1b5a(var1.getStack(), StatusEffects.INSTANT_HEALTH)) {
               this.III_field_991c1e8c.I_method_23e11e3f();
            }
         }
      };
      this.Iii_method_63fd1a7f();
   }

   @Compile(
      obfuscation = 4
   )
   private void Iii_method_63fd1a7f() {
      this.I_field_bbd4b28c = new ButtonSetting(this, "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u043c\u0430\u043a\u0440\u043e\u0441\u044b")
         .I_method_f05556b3(() -> I_field_3a9bda27.setScreen(new iIIiIiiI_Class151()));
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.show_radius").I_method_decd82b5();
      this.i_field_ba20ca4c = new BooleanSetting(
         this, "modules.settings.assist.spoof_rp", "modules.settings.assist.spoof_rp.description", this.I_field_7bf34412
      );
      this.II_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.assist.close_menu", "modules.settings.assist.close_menu.description", this.I_field_7bf34412
         )
         .I_method_decd82b5();
      this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.auto_fix", this.I_field_7bf34412);
      this.iI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.chat_filter", this.I_field_7bf34412);
      this.ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.reduce_cooldown");
      this.III_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.warn_armor", "modules.settings.assist.warn_armor.description");
      this.IIi_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.dragon_fly", "modules.settings.assist.dragon_fly.description")
         .I_method_decd82b5();
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.assist.fly_speed_xz", () -> !this.IIi_field_ba20ca4c.i_method_9b12da03())
         .Ii_method_4e0e6b54(1.0F)
         .i_method_65e2aff7(5.0F)
         .I_method_c8c9a7d7(1.0F)
         .II_method_b0f56334(0.5F)
         .Ii_method_4e0e6b54(5.0F);
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.assist.fly_speed_y", () -> !this.IIi_field_ba20ca4c.i_method_9b12da03())
         .Ii_method_4e0e6b54(1.0F)
         .i_method_65e2aff7(5.0F)
         .I_method_c8c9a7d7(1.0F)
         .II_method_b0f56334(0.5F)
         .Ii_method_4e0e6b54(5.0F);
      this.IiI_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.assist.auto_piona", "modules.settings.assist.auto_piona.description", this.i_field_7bf34412
         )
         .I_method_decd82b5();
      this.Iii_field_ba20ca4c = new BooleanSetting(
         this, "modules.settings.assist.auto_captcha", "modules.settings.assist.auto_captcha.description", this.i_field_7bf34412
      );
      this.iII_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.auto_chorus");
      this.iIi_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.auto_zako", this.II_field_7bf34412);
      this.iiI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.auto_stop", this.II_field_7bf34412);
      this.iii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.heal_helper");
      this.IIII_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.ct_commands", "modules.settings.assist.ct_commands.description")
         .I_method_decd82b5();
      this.IIIi_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.auto_rct", this.II_field_7bf34412);
      this.IIiI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.assist.buffs_loop");
      this.I_field_bbe33e6c = new ModeSetting(
         this, "modules.settings.assist.hand_mode", () -> iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)
      );
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.assist.hand_mode.left");
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.assist.hand_mode.right");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.assist.hand_mode.packet");
   }

   private void II_method_621d1a21(int var1) {
      for (iIiIIiII_Class165 var3 : this.i_field_7865b31) {
         if (var3.I_method_75fee910() && !var3.i_method_9ed094d0() && iIIIIIIII_Class257.I_method_967132c3(var3.I_method_75fee8ff(), var1)) {
            if (this.I_method_cf783304(var3)) {
               this.i_field_a56a8dc5.add(var1);
               return;
            }

            this.I_method_cf783300(var3);
            return;
         }
      }
   }

   private void iII_method_98c6b25f() {
      Iterator var1 = this.i_field_a56a8dc5.iterator();

      while (var1.hasNext()) {
         int var2 = (Integer)var1.next();
         if (!this.I_method_663478c8(var2)) {
            var1.remove();
            if (I_field_3a9bda27.currentScreen == null) {
               for (iIiIIiII_Class165 var4 : this.i_field_7865b31) {
                  if (this.I_method_cf783304(var4)
                     && var4.I_method_75fee910()
                     && !var4.i_method_9ed094d0()
                     && iIIIIIIII_Class257.I_method_4da58b7(var4.I_method_75fee8ff()) == var2) {
                     this.I_method_cf783300(var4);
                     break;
                  }
               }
            }
         }
      }
   }

   private boolean I_method_cf783304(iIiIIiII_Class165 var1) {
      return var1 instanceof iIiiiiIi_Class190
         || var1 instanceof iIiiIiiI_Class183
         || var1 instanceof iIiIiiii_Class176
         || var1 instanceof iIiiIiIi_Class182
         || var1 instanceof iIiIiiII_Class173
         || var1 instanceof iIiiiIii_Class188
         || var1 instanceof iIiiiIiI_Class187
         || var1 instanceof iIiIiIii_Class172;
   }

   private void I_method_cf783300(iIiIIiII_Class165 var1) {
      var1.I_method_75fee90c();
      if (!var1.II_method_398e0bf9()) {
         if (var1 instanceof iIiIiIIi_Class170 var2) {
            var2.II_method_d6f5b7d5();
         } else {
            IiIIIIii_Class68.I_field_108dc26c.I_method_a4f79a60(var1.I_method_db7f702c().getItem(), var1::I_method_b921bd52, var1.i_method_1f641154());
         }
      }
   }

   private boolean I_method_663478c8(int var1) {
      return iIIIIIIII_Class257.II_method_98333a25(var1);
   }

   public final void i_method_72c2f8f0(List<iIiIIiII_Class165> var1) {
      this.i_field_7865b31.clear();
      this.i_field_7865b31.addAll(var1);
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && I_field_3a9bda27.interactionManager != null) {
         this.iII_method_98c6b25f();

         for (iIiIIiII_Class165 var2 : this.i_field_7865b31) {
            var2.i_method_9ed094cc();
         }

         this.iiI_method_9a89a27f();
         if (this.Iii_field_ba20ca4c.i_method_9b12da03()) {
            this.I_field_10f5ef21.I_method_845f1c6c();
         } else {
            this.I_field_10f5ef21.i_method_846da84c();
         }

         if (this.iII_field_ba20ca4c.i_method_9b12da03() && RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() != null) {
            LivingEntity var6 = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
            if (I_field_3a9bda27.player.distanceTo(var6) < 5.0F && !var6.getActiveItem().isOf(Items.CHORUS_FRUIT)) {
               this.Ii_field_991c1e8c.I_method_23e11e3f();
            }
         }

         if (this.IIiI_field_ba20ca4c.i_method_9b12da03()) {
            if (this.I_field_49 == 0) {
               I_field_3a9bda27.player.networkHandler.sendChatMessage("\u041a\u0442\u043e \u0445\u043e\u0447\u0435\u0442 \u0431\u0430\u0444\u044b?");
               this.II_field_991c1e8c.I_method_23e11e3f();
               this.I_field_49 = 1;
            } else if (this.I_field_49 == 1 && this.II_field_991c1e8c.I_method_58432069(1000L)) {
               I_field_3a9bda27.player.networkHandler.sendChatMessage("\u041a\u0442\u043e \u0441\u043e\u0441\u0430\u043b?");
               this.II_field_991c1e8c.I_method_23e11e3f();
               this.I_field_49 = 2;
            } else if (this.I_field_49 == 2 && this.II_field_991c1e8c.I_method_58432069(10000L)) {
               this.I_field_49 = 0;
            }
         } else {
            this.I_field_49 = 0;
         }

         if (this.III_field_ba20ca4c.i_method_9b12da03()) {
            float var7 = 1.0F;

            for (ItemStack var3 : I_field_3a9bda27.player.getAllArmorItems()) {
               if (!var3.isEmpty()) {
                  float var4 = var3.getMaxDamage();
                  float var5 = var4 - var3.getDamage();
                  var7 = var5 / var4;
               }
            }

            if (var7 < 0.36) {
               if (this.Ii_field_5a) {
                  RockstarClient.getInstance()
                     .I_method_5cb1af22()
                     .I_method_20d0f49b(
                        iiiIIII_Class113.II_field_c11fcfcc,
                        IiIiIIII_Class81.I_method_f25a980a("assist.break"),
                        IiIiIIII_Class81.I_method_f25a980a("assist.armor_almost_broken")
                     );
                  this.Ii_field_5a = false;
               }
            } else {
               this.Ii_field_5a = true;
            }
         }

         if (this.IIi_field_ba20ca4c.i_method_9b12da03()
            && I_field_3a9bda27.player.getAbilities().allowFlying
            && I_field_3a9bda27.player.getAbilities().flying
            && !RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class).isEnabled()) {
            if (!I_field_3a9bda27.player.isSneaking() && I_field_3a9bda27.options.jumpKey.isPressed()) {
               I_field_3a9bda27.player
                  .setVelocity(I_field_3a9bda27.player.getVelocity().x, this.i_field_73178e8c.Ii_method_a20abcd2(), I_field_3a9bda27.player.getVelocity().z);
            } else if (I_field_3a9bda27.options.sneakKey.isPressed()) {
               I_field_3a9bda27.player
                  .setVelocity(I_field_3a9bda27.player.getVelocity().x, -this.i_field_73178e8c.Ii_method_a20abcd2(), I_field_3a9bda27.player.getVelocity().z);
            }

            IiiiiiiII_Class253.I_method_c7b3e4d5(this.I_field_73178e8c.Ii_method_a20abcd2(), false);
         }

         if (this.Ii_field_ba20ca4c.i_method_9b12da03()) {
            PlayerInventory var8 = I_field_3a9bda27.player.getInventory();
            boolean var10 = this.I_method_de07cfe1(var8);
            if (iIIIiiiII_Class285.I_field_5a && var10) {
               this.IIi_field_5a = true;
            }

            if (!iIIIiiiII_Class285.I_field_5a && var10) {
               if (this.IIi_field_5a) {
                  this.iIi_method_98d53e3f();
                  this.IIi_field_5a = false;
                  this.ii_field_991c1e8c.I_method_23e11e3f();
               }
            } else if (!var10) {
               this.IIi_field_5a = false;
            }
         } else {
            this.IIi_field_5a = false;
         }

         if (this.i_field_ba20ca4c.i_method_9b12da03()
            && this.i_field_ba20ca4c.isVisible()
            && I_field_3a9bda27.player.age > 20
            && I_field_3a9bda27.currentScreen instanceof ConfirmServerResourcePackScreen) {
            I_field_3a9bda27.player.networkHandler.sendPacket(new ResourcePackStatusC2SPacket(I_field_3a9bda27.player.getUuid(), Status.ACCEPTED));
            I_field_3a9bda27.player.networkHandler.sendPacket(new ResourcePackStatusC2SPacket(I_field_3a9bda27.player.getUuid(), Status.SUCCESSFULLY_LOADED));
            I_field_3a9bda27.player.closeScreen();
         }

         if (this.IiI_field_ba20ca4c.i_method_9b12da03()) {
            if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler
               && I_field_3a9bda27.currentScreen.getTitle().getString().contains("\u0412\u0430\u043c \u043f\u043e\u0434\u0430\u0440\u043e\u043a")) {
               I_field_3a9bda27.interactionManager
                  .clickSlot(I_field_3a9bda27.player.currentScreenHandler.syncId, 13, 0, SlotActionType.PICKUP, I_field_3a9bda27.player);
            }

            if (this.I_field_991c1e8c.I_method_58432069(1000L) && !this.II_field_5a) {
               this.II_field_5a = true;
               I_field_3a9bda27.player.networkHandler.sendChatCommand("piona");
            }
         }

         if (this.iIi_field_ba20ca4c.i_method_9b12da03() && this.I_field_991c1e8c.I_method_58432069(500L) && this.i_field_5a) {
            this.i_field_5a = false;
            I_field_3a9bda27.player.networkHandler.sendChatCommand("zako");
         }

         super.II_method_6642fd22();
      }
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.I_field_49 = 0;
   }

   @Override
   public void onDisable() {
      super.onDisable();
      this.I_field_49 = 0;
      this.i_field_a56a8dc5.clear();
      this.IIII_method_e35728c2();
      this.I_field_10f5ef21.i_method_846da84c();
   }

   private void iIi_method_98d53e3f() {
      I_field_3a9bda27.player.networkHandler.sendChatCommand("fix all");
   }

   private boolean I_method_de07cfe1(PlayerInventory var1) {
      for (int var2 = 0; var2 < var1.size(); var2++) {
         ItemStack var3 = var1.getStack(var2);
         if (!var3.isEmpty() && var3.isDamageable()) {
            float var4 = var3.getMaxDamage();
            float var5 = var4 - var3.getDamage();
            if (var5 / var4 > 0.5F) {
               return true;
            }
         }
      }

      return false;
   }

   private void iiI_method_9a89a27f() {
      if (!this.iII_field_ba20ca4c.i_method_9b12da03()) {
         if (this.iI_field_5a) {
            this.IIII_method_e35728c2();
         }

         this.Ii_field_991c1e8c.I_method_23e11e3f();
      } else if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         LivingEntity var1 = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
         if (var1 == null) {
            this.Ii_field_991c1e8c.I_method_23e11e3f();
            if (this.iI_field_5a && !I_field_3a9bda27.player.isUsingItem()) {
               this.IIII_method_e35728c2();
            }
         } else if (!var1.isAlive()) {
            this.Ii_field_991c1e8c.I_method_23e11e3f();
         } else {
            double var2 = I_field_3a9bda27.player.squaredDistanceTo(var1);
            boolean var4 = var1.isUsingItem() && var1.getActiveItem().getItem() == Items.CHORUS_FRUIT;
            if (!var4 || var2 > 25.0) {
               this.Ii_field_991c1e8c.I_method_23e11e3f();
            } else if (!this.iI_field_5a
               && I_field_3a9bda27.currentScreen == null
               && !I_field_3a9bda27.player.isUsingItem()
               && this.Ii_field_991c1e8c.I_method_58432069(200L)) {
               this.iii_method_9a982e5f();
            }

            if (this.iI_field_5a) {
               if (I_field_3a9bda27.player.isUsingItem()) {
                  this.III_field_5a = true;
               } else if (this.III_field_5a) {
                  this.IIII_method_e35728c2();
                  return;
               }

               if (this.iI_field_991c1e8c.I_method_58432069(2500L)) {
                  this.IIII_method_e35728c2();
               }
            }
         }
      } else {
         if (this.iI_field_5a) {
            this.IIII_method_e35728c2();
         }

         this.Ii_field_991c1e8c.I_method_23e11e3f();
      }
   }

   private void iii_method_9a982e5f() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.interactionManager != null && I_field_3a9bda27.options != null) {
         iIIiiIiII_Class309 var1 = iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75());
         iIIiIiIii_Class300 var2 = var1.I_method_5d34dd7d(Items.CHORUS_FRUIT);
         if (var2 != null) {
            iIIiiiIii_Class316 var3 = iIIiIiIiI_Class299.I_method_d0256375();
            this.I_field_48ddb68c = var3;
            this.ii_field_5a = false;
            this.i_field_49 = -1;
            if (var2 instanceof iIIiiiIii_Class316 var4) {
               if (var4.II_method_b9cf08f5() != var3.II_method_b9cf08f5()) {
                  iIIiIiIiI_Class299.I_method_4c2ca067(var4);
               }
            } else {
               this.ii_field_5a = true;
               this.i_field_49 = var2.I_method_dfe89252();
               iIIiIiIiI_Class299.iI_method_c617e8c2(this.i_field_49, var3.II_method_b9cf08f5());
            }

            I_field_3a9bda27.options.useKey.setPressed(true);
            this.iI_field_5a = true;
            this.iI_field_991c1e8c.I_method_23e11e3f();
            this.III_field_5a = false;
         }
      }
   }

   private void IIII_method_e35728c2() {
      if (!this.iI_field_5a) {
         this.ii_field_5a = false;
         this.I_field_48ddb68c = null;
         this.i_field_49 = -1;
         this.III_field_5a = false;
      } else {
         if (I_field_3a9bda27.options != null) {
            I_field_3a9bda27.options.useKey.setPressed(false);
         }

         if (I_field_3a9bda27.player != null && I_field_3a9bda27.interactionManager != null) {
            if (this.ii_field_5a && this.I_field_48ddb68c != null && this.i_field_49 != -1) {
               iIIiIiIiI_Class299.iI_method_c617e8c2(this.i_field_49, this.I_field_48ddb68c.II_method_b9cf08f5());
            }

            if (this.I_field_48ddb68c != null) {
               iIIiIiIiI_Class299.I_method_4c2ca067(this.I_field_48ddb68c);
            }
         }

         this.iI_field_5a = false;
         this.ii_field_5a = false;
         this.I_field_48ddb68c = null;
         this.i_field_49 = -1;
         this.III_field_5a = false;
         this.Ii_field_991c1e8c.I_method_23e11e3f();
         this.iI_field_991c1e8c.I_method_23e11e3f();
      }
   }

   public void IiI_method_63ee8e9f() {
      if (this.IiI_field_5a) {
         MinecraftClient.getInstance().options.useKey.setPressed(false);
         this.IiI_field_5a = false;
      }

      if (this.I_field_1242a2ac != null && this.I_field_1242a2ac instanceof iIIiiiIii_Class316 var1) {
         iIIiIiIiI_Class299.I_method_4c2ca067(var1);
         this.I_field_1242a2ac = null;
      }

      this.Iii_field_5a = false;
   }

   private boolean IiiI_method_1bb52cc6() {
      return iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iiI_field_ac164e6c)
         || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iII_field_ac164e6c)
         || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iIi_field_ac164e6c);
   }

   private boolean I_method_d6773e2d(String var1) {
      if (this.IIII_field_ba20ca4c.i_method_9b12da03() && iIIIiiiII_Class285.I_field_5a) {
         String var2 = this.i_method_3fe295b7(var1);
         if (var2 == null) {
            return false;
         } else {
            String[] var3 = new String[]{"hub", "an", "grief", "leave", "limbo", "lobby"};

            for (String var7 : var3) {
               if (var2.equals(var7.toLowerCase(Locale.ROOT))) {
                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }

   private String i_method_3fe295b7(String var1) {
      if (var1 == null) {
         return null;
      } else {
         String var2 = var1.trim();
         if (!var2.startsWith("/")) {
            return null;
         } else {
            var2 = var2.substring(1).trim();
            if (var2.isEmpty()) {
               return null;
            } else {
               int var3 = var2.indexOf(32);
               if (var3 != -1) {
                  var2 = var2.substring(0, var3);
               }

               return var2.toLowerCase(Locale.ROOT);
            }
         }
      }
   }

   public boolean IiI_method_63ee8ea3() {
      return this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627);
   }

   public boolean Iii_method_63fd1a83() {
      return this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627);
   }

   @Generated
   public BooleanSupplier I_method_d11a9a9() {
      return this.I_field_7bf34412;
   }

   @Generated
   public BooleanSupplier i_method_2d3091c9() {
      return this.i_field_7bf34412;
   }

   @Generated
   public BooleanSupplier II_method_bc4fb3c6() {
      return this.II_field_7bf34412;
   }

   @Generated
   public ButtonSetting I_method_5a5c5715() {
      return this.I_field_bbd4b28c;
   }

   @Generated
   public BooleanSetting I_method_58a86ed5() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting i_method_6e3de2b5() {
      return this.i_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting II_method_6afa2018() {
      return this.II_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting Ii_method_808f93f8() {
      return this.Ii_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting iI_method_8132838() {
      return this.iI_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting ii_method_1da89c18() {
      return this.ii_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting III_method_a2de9735() {
      return this.III_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting IIi_method_b8740b15() {
      return this.IIi_field_ba20ca4c;
   }

   @Generated
   public SliderSetting I_method_119f3315() {
      return this.I_field_73178e8c;
   }

   @Generated
   public SliderSetting i_method_2734a6f5() {
      return this.i_field_73178e8c;
   }

   @Generated
   public BooleanSetting IiI_method_3ff79f55() {
      return this.IiI_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting Iii_method_558d1335() {
      return this.Iii_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting iII_method_a8e69315() {
      return this.iII_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting iIi_method_be7c06f5() {
      return this.iIi_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting iiI_method_45ff9b35() {
      return this.iiI_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting iii_method_5b950f15() {
      return this.iii_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting IIII_method_678903b8() {
      return this.IIII_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting IIIi_method_7d1e7798() {
      return this.IIIi_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting IIiI_method_4a20bd8() {
      return this.IIiI_field_ba20ca4c;
   }

   @Generated
   public ModeSetting I_method_5a6ae2f5() {
      return this.I_field_bbe33e6c;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 I_method_6b3dac70() {
      return this.I_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 i_method_7145a850() {
      return this.i_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 II_method_2fe818f3() {
      return this.II_field_500d0627;
   }

   @Generated
   public Set<String> I_method_6125f7ce() {
      return this.I_field_a56a8dc5;
   }

   @Generated
   public List<Pattern> I_method_c3383248() {
      return this.II_field_7865b31;
   }

   @Generated
   public iiIiIIiii_Class424 I_method_37a3c315() {
      return this.I_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 i_method_4d3936f5() {
      return this.i_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 II_method_49f57458() {
      return this.II_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 Ii_method_5f8ae838() {
      return this.Ii_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 iI_method_e70e7c78() {
      return this.iI_field_991c1e8c;
   }

   @Generated
   public iiIiIIiii_Class424 ii_method_fca3f058() {
      return this.ii_field_991c1e8c;
   }

   @Generated
   public IiiiIiIi_Class118 I_method_16131578() {
      return this.I_field_10f5ef21;
   }

   @Generated
   public boolean iII_method_98c6b263() {
      return this.I_field_5a;
   }

   @Generated
   public boolean iIi_method_98d53e43() {
      return this.i_field_5a;
   }

   @Generated
   public boolean iiI_method_9a89a283() {
      return this.II_field_5a;
   }

   @Generated
   public boolean iii_method_9a982e63() {
      return this.Ii_field_5a;
   }

   @Generated
   public int II_method_6642fd15() {
      return this.I_field_49;
   }

   @Generated
   public boolean IIII_method_e35728c6() {
      return this.iI_field_5a;
   }

   @Generated
   public boolean IIIi_method_e365b4a6() {
      return this.ii_field_5a;
   }

   @Generated
   public int Ii_method_665188f5() {
      return this.i_field_49;
   }

   @Generated
   public iIIiiiIii_Class316 I_method_e7655b15() {
      return this.I_field_48ddb68c;
   }

   @Generated
   public boolean IIiI_method_e51a18e6() {
      return this.III_field_5a;
   }

   @Generated
   public boolean IIii_method_e528a4c6() {
      return this.IIi_field_5a;
   }

   @Generated
   public Set<Integer> i_method_f3623bae() {
      return this.i_field_a56a8dc5;
   }

   @Generated
   public IiIIIiII_Class69<MouseEvent> I_method_42b09598() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<KeyPressEvent> i_method_6cad25b8() {
      return this.i_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<EventSetCooldown> II_method_6c922ff5() {
      return this.II_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ReceivePacketEvent> Ii_method_968ec015() {
      return this.Ii_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<SendMessageEvent> iI_method_8227a3d5() {
      return this.iI_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<AttackEvent> ii_method_ac2433f5() {
      return this.ii_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<FinishEatEvent> III_method_7ee3e138() {
      return this.III_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<FinishEatEvent> IIi_method_a8e07158() {
      return this.IIi_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<InputEvent> IiI_method_94795518() {
      return this.IiI_field_3d936f41;
   }

   @Generated
   public iIIiIiIii_Class300 I_method_b0ca4735() {
      return this.I_field_1242a2ac;
   }

   @Generated
   public boolean IiII_method_19f23ca6() {
      return this.IiI_field_5a;
   }

   @Generated
   public boolean IiIi_method_1a00c886() {
      return this.Iii_field_5a;
   }

   @Generated
   public iiIiIIiii_Class424 III_method_81d9eb75() {
      return this.III_field_991c1e8c;
   }

   @Generated
   public IiIIIiII_Class69<HudRenderEvent> Iii_method_be75e538() {
      return this.Iii_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<FinishEatEvent> iII_method_1bfce958() {
      return this.iII_field_3d936f41;
   }

   @Generated
   public List<iIiIIiII_Class165> i_method_78846a68() {
      return this.I_field_7865b31;
   }

   @Generated
   public List<iIiIIiII_Class165> II_method_6ba8ace5() {
      return this.i_field_7865b31;
   }
}
