package rockstar.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.texture.Sprite;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import pyrock.utility.render.ColorRGBA;

public class IiIiIiIiI_Class171 extends IiIiIIiII_Class165 {
   private final BooleanSetting I_field_ba20ca4c = new BooleanSetting(this, "hud.always_display");
   private final BooleanSetting i_field_ba20ca4c = new BooleanSetting(this, "hud.effects.grouping");
   private final BooleanSetting II_field_ba20ca4c = new BooleanSetting(this, "hud.effects.alert");
   private final IiIIIIIII_Class129 I_field_73178aac = new IiIIIIIII_Class129(this, "hud.uniform_width");
   final Map<String, List<StatusEffectInstance>> I_field_a567c40b = new LinkedHashMap<>();
   private final List<String> I_field_7865b31 = new ArrayList<>();
   private Map<String, StatusEffectInstance> i_field_a567c40b = new HashMap<>();
   private final Map<String, iiI_Class7> II_field_a567c40b = new HashMap<>();
   private final Set<String> I_field_a56a8dc5 = new HashSet<>();
   private boolean I_field_5a;
   private iii_Class8 I_field_b584628c;
   private iiI_Class7 I_field_b5845eac;
   private final IiiI_Class7 I_field_f94500c1 = (var1, var2, var3) -> {
      var3.I_field_46 = var1;
      var3.i_field_46 = (this.I_field_5a ? 6.0F : -6.0F) * (1.0F - var1);
   };

   public IiIiIiIiI_Class171() {
      super("hud.effects", "hud/potion");
   }

   @Override
   protected iii_Class8 build() {
      this.II_field_a567c40b.clear();
      this.I_field_a56a8dc5.clear();
      this.I_field_b584628c = new iii_Class8().I_method_485bccf5().I_method_483797dd(this.I_method_1a962a75()).I_method_70a38517(1.0F);
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
         .I_method_8939bffd(new Iii_Class4().size(7.0F, 7.0F).interactive(false).icon("hud/potion", 7.0F, IiiiiIIIi_Class242.ii_field_d0c8ec5))
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
      this.I_method_3df51abf();
      return this.I_field_b584628c;
   }

   private iiI_Class7 I_method_8774599f(String var1) {
      iiI_Class7 var2 = this.II_field_a567c40b
         .computeIfAbsent(
            var1,
            var1x -> {
               IIiIIi_Class10 var2x = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F);
               boolean var3 = var1x.startsWith("g:");
               IiIiIiIiI_Class171.Nested1_a49ad3c0 var4 = new IiIiIiIiI_Class171.Nested1_a49ad3c0(var1x);
               if (var3) {
                  var4.fillWidth();
               }

               iii_Class8 var5 = new iii_Class8()
                  .i_method_c88da8d5()
                  .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
                  .I_method_70a38517(1.0F)
                  .II_method_32b63e79(this.I_field_f94500c1)
                  .I_method_8939bffd(var4);
               if (!var3) {
                  var5.I_method_8939bffd(
                     new Iii_Class4()
                        .interactive(false)
                        .fillWidth()
                        .height(10.0F)
                        .radius(2.0F)
                        .padding(IIII.i_method_4f8e6e83(3.0F))
                        .background(var0 -> IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.889F))
                        .text(var2x, () -> this.I_method_3e380cf7(var1x), var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5)
                  );
               }

               var5.I_method_8939bffd(
                  new Iii_Class4()
                     .interactive(false)
                     .height(10.0F)
                     .minWidth(18.0F)
                     .radius(2.0F)
                     .padding(IIII.i_method_4f8e6e83(3.0F))
                     .background(var0 -> IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.94F))
                     .textAlign(IIi_Class2.i_field_b5755e8c)
                     .text(var2x, () -> this.i_method_5e56f517(var1x), var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75F))
               );
               return var5;
            }
         );
      if (var2.phase() == iiI_Class7.Nested1_5f2d9729.II_field_56fbb866
         || var2.phase() == iiI_Class7.Nested1_5f2d9729.Ii_field_56fbb866
         || var2.phase() == iiI_Class7.Nested1_5f2d9729.iI_field_56fbb866) {
         var2.beginEnter(0.0F);
      }

      return var2;
   }

   private void I_method_3df51abf() {
      HashSet var1 = new HashSet<>(this.I_field_7865b31);
      if (!var1.equals(this.I_field_a56a8dc5)) {
         this.I_field_a56a8dc5.clear();
         this.I_field_a56a8dc5.addAll(var1);
         IIiIIi_Class10 var2 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(6.0F);
         HashMap var3 = new HashMap();

         for (String var5 : this.I_field_7865b31) {
            var3.put(var5, this.I_method_a529fc9a(var5, var2));
         }

         ArrayList var8 = new ArrayList<>(this.I_field_7865b31);
         var8.sort(Comparator.<String>comparingDouble(var1x -> ((Float)var3.get(var1x)).floatValue()).reversed());
         ArrayList var9 = new ArrayList();
         var9.add(this.I_field_b5845eac);

         for (String var7 : (Iterable<String>)(Iterable<?>)var8) {
            var9.add(this.I_method_8774599f(var7));
         }

         this.I_field_b584628c.II_method_244860a9(var9);
      }
   }

   private float I_method_a529fc9a(String var1, IIiIIi_Class10 var2) {
      List var3 = this.I_field_a567c40b.get(var1);
      int var4 = var3 != null && !var3.isEmpty() ? var3.size() : 1;
      float var5 = 4.0F + var4 * 10.0F;
      float var6 = var1.startsWith("g:") ? 0.0F : var2.I_method_2c375926(this.I_method_3e380cf7(var1));
      float var7 = Math.max(18.0F, var2.I_method_2c375926("00:00"));
      return var5 + var6 + var7;
   }

   @Override
   public void update(III var1) {
      this.I_field_5a = this.x + this.width / 2.0F >= iIIiIIiiI_Class295.I_field_73c6d26c.I_method_804ee20f() / 2.0F;
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         this.i_method_3e03a69f();
      }

      if (this.I_field_b584628c != null) {
         this.I_field_b584628c.I_method_483797dd(this.I_method_1a962a75());
         this.I_method_3df51abf();
      }

      super.update(var1);
   }

   private IIi_Class2 I_method_1a962a75() {
      return this.I_field_73178aac.i_method_9b12da03()
         ? IIi_Class2.Ii_field_b5755e8c
         : (this.I_field_5a ? IIi_Class2.II_field_b5755e8c : IIi_Class2.I_field_b5755e8c);
   }

   private void i_method_3e03a69f() {
      Collection<StatusEffectInstance> var1 = I_field_3a9bda27.player.getStatusEffects();
      TreeMap<String, StatusEffectInstance> var2 = new TreeMap<>();

      for (StatusEffectInstance var4 : var1) {
         StatusEffect var5 = (StatusEffect)var4.getEffectType().value();
         String var6 = var5.getName().getString();
         if (var6 != null && !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iI_field_ac164e6c) && !IiiiiiiII_Class253.I_method_d4e81454(var4)) {
            var2.put(var5.getTranslationKey() + ":" + var4.getAmplifier(), var4);
         }
      }

      if (this.II_field_ba20ca4c.i_method_9b12da03()) {
         this.i_field_a567c40b
            .forEach(
               (var1x, var2x) -> {
                  if (!var2.containsKey(var1x)) {
                     StatusEffect var3 = (StatusEffect)var2x.getEffectType().value();
                     if (!var3.getCategory().equals(StatusEffectCategory.HARMFUL)) {
                        String var4x = var3.getName().getString() + " " + (var2x.getAmplifier() > 0 ? var2x.getAmplifier() + 1 : "");
                        RockstarClient.getInstance()
                           .I_method_5cb1af22()
                           .I_method_67864747(
                              new iiiIiII_Class117(IiIiIIII_Class81.I_method_1410d1e5("hud.effects.ended", var4x), var2x.getEffectType())
                                 .I_method_4164eabf(var4x)
                           );
                     }
                  }
               }
            );
      }

      this.I_field_a567c40b.clear();
      this.I_field_7865b31.clear();
      if (this.i_field_ba20ca4c.i_method_9b12da03()) {
         Map<Integer, List<StatusEffectInstance>> var7 = var2.values().stream().collect(Collectors.groupingBy(var0 -> var0.getDuration() * 50, LinkedHashMap::new, Collectors.toList()));

         for (List var11 : (Iterable<List>)(Iterable<?>)var7.values()) {
            String var12 = "g:"
               + var11.stream()
                  .map(var0 -> ((StatusEffect)((net.minecraft.entity.effect.StatusEffectInstance)var0).getEffectType().value()).getTranslationKey() + ":" + ((net.minecraft.entity.effect.StatusEffectInstance)var0).getAmplifier())
                  .sorted()
                  .collect(Collectors.joining(","));
            this.I_field_a567c40b.put(var12, var11);
            this.I_field_7865b31.add(var12);
         }
      } else {
         for (Entry var10 : (Iterable<Entry>)(Iterable<?>)var2.entrySet()) {
            this.I_field_a567c40b.put((String)var10.getKey(), List.of((StatusEffectInstance)var10.getValue()));
            this.I_field_7865b31.add((String)var10.getKey());
         }
      }

      this.i_field_a567c40b = var2;
   }

   private String I_method_3e380cf7(String var1) {
      List var2 = this.I_field_a567c40b.get(var1);
      if (var2 != null && !var2.isEmpty()) {
         StatusEffectInstance var3 = (StatusEffectInstance)var2.getFirst();
         StatusEffect var4 = (StatusEffect)var3.getEffectType().value();
         int var5 = var3.getAmplifier();
         return var4.getName().getString() + (var5 > 0 ? " " + (var5 + 1) : "");
      } else {
         return "";
      }
   }

   private String i_method_5e56f517(String var1) {
      List var2 = this.I_field_a567c40b.get(var1);
      if (var2 != null && !var2.isEmpty()) {
         StatusEffectInstance var3 = (StatusEffectInstance)var2.getFirst();
         if (!var3.isInfinite() && var3.getDuration() < 999999999) {
            int var4 = var3.getDuration() / 20;
            return String.format("%02d:%02d", var4 / 60, var4 % 60);
         } else {
            return "**:**";
         }
      } else {
         return "";
      }
   }

   @Override
   public boolean show() {
      if (I_field_3a9bda27.player == null) {
         return false;
      } else {
         boolean var1 = I_field_3a9bda27.player
            .getStatusEffects()
            .stream()
            .anyMatch(
               var0 -> !IiiiiiiII_Class253.I_method_d4e81454(var0)
                  && var0.getEffectType() != null
                  && !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iI_field_ac164e6c)
            );
         return (var1 || I_field_3a9bda27.currentScreen instanceof ChatScreen || this.I_field_ba20ca4c.i_method_9b12da03())
            && !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iI_field_ac164e6c);
      }
   }

   final class Nested1_a49ad3c0 extends iiI_Class7 {
      private final String I_field_523beb0a;

      Nested1_a49ad3c0(String var2) {
         this.I_field_523beb0a = var2;
         this.interactive(false);
      }

      private List<StatusEffectInstance> I_method_c6dc170d() {
         return IiIiIiIiI_Class171.this.I_field_a567c40b.getOrDefault(this.I_field_523beb0a, List.of());
      }

      @Override
      protected void measure() {
         int var1 = Math.max(1, this.I_method_c6dc170d().size());
         this.prefW = 4 + var1 * 10;
         this.prefH = 10.0F;
      }

      @Override
      protected void drawSelf(III var1, float var2) {
         var1.drawRoundedRect(
            this.x(), this.y(), this.w(), this.h(), IIiii_Class8.I_method_893b2757(2.0F), IiiiiIIIi_Class242.III_field_d0c8ec5.mulAlpha(0.94F)
         );
         float var3 = this.x() + 3.0F;
         float var4 = this.y() + this.h() / 2.0F - 4.0F;

         for (StatusEffectInstance var6 : this.I_method_c6dc170d()) {
            Sprite var7 = iIIiIIiIi_Class294.I_field_3a9bda27.getStatusEffectSpriteManager().getSprite(var6.getEffectType());
            var1.drawTexture(var7.getAtlasId(), var3, var4, 8.0F, 8.0F, var7.getMinU(), var7.getMaxU(), var7.getMinV(), var7.getMaxV(), ColorRGBA.WHITE);
            var3 += 10.0F;
         }
      }
   }
}
