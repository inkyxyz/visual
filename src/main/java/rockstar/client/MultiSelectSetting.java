package rockstar.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;
import pyrock.utility.render.ColorRGBA;

public class MultiSelectSetting extends AbstractSetting {
   final List<MultiSelectSetting.Nested1_42856060> I_field_7865b31 = new ArrayList<>();
   private List<MultiSelectSetting.Nested1_42856060> i_field_7865b31 = new ArrayList<>();
   private boolean I_field_5a;
   private int I_field_49;

   public MultiSelectSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, String var3, @NotNull BooleanSupplier var4) {
      super(var1, var2, var4);
   }

   public MultiSelectSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, @NotNull BooleanSupplier var3) {
      super(var1, var2, var3);
   }

   public MultiSelectSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, String var3) {
      super(var1, var2);
   }

   public MultiSelectSetting(@NotNull IIiiiIIiI_Class115 var1, String var2) {
      super(var1, var2);
   }

   public MultiSelectSetting I_method_bba86af5() {
      this.I_field_5a = true;
      return this;
   }

   public MultiSelectSetting I_method_702bd95a(int var1) {
      this.I_field_49 = Math.max(0, var1);
      return this;
   }

   public void I_method_4fa1e22(MultiSelectSetting.Nested1_42856060 var1) {
      this.I_field_7865b31.add(var1);
   }

   public void i_method_bff19e42(MultiSelectSetting.Nested1_42856060 var1) {
      this.I_method_9a4a58f2(var1, true);
   }

   void I_method_9a4a58f2(MultiSelectSetting.Nested1_42856060 var1, boolean var2) {
      if (var1 != null && this.i_field_7865b31.contains(var1) != var2) {
         this.notifyChanged();
         if (var2) {
            this.i_field_7865b31.add(var1);
         } else {
            this.i_field_7865b31.remove(var1);
         }
      }
   }

   void II_method_3a5cd9ff(MultiSelectSetting.Nested1_42856060 var1) {
      if (var1 != null && !var1.alwaysEnabled) {
         if (this.i_field_7865b31.contains(var1)) {
            if (this.i_field_7865b31.size() > this.I_field_49) {
               this.I_method_9a4a58f2(var1, false);
            }
         } else {
            this.I_method_9a4a58f2(var1, true);
         }
      }
   }

   @Override
   public JsonElement toJson() {
      JsonObject var1 = new JsonObject();
      JsonArray var2 = new JsonArray();

      for (MultiSelectSetting.Nested1_42856060 var4 : this.i_field_7865b31) {
         var2.add(new JsonPrimitive(var4.getName()));
      }

      var1.add("selected", var2);
      if (this.I_field_5a) {
         JsonArray var6 = new JsonArray();

         for (MultiSelectSetting.Nested1_42856060 var5 : this.I_field_7865b31) {
            var6.add(new JsonPrimitive(var5.getName()));
         }

         var1.add("order", var6);
      }

      return var1;
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null) {
         if (var1.isJsonObject()) {
            JsonObject var2 = var1.getAsJsonObject();
            if (this.I_field_5a && var2.has("order") && !this.i_method_14acac8e(var2.get("order"))) {
               return;
            }

            if (var2.has("selected") && !this.i_method_14acac8e(var2.get("selected"))) {
               return;
            }
         } else if (!this.i_method_14acac8e(var1)) {
            return;
         }

         this.i_field_7865b31.clear();
         if (var1.isJsonObject()) {
            JsonObject var8 = var1.getAsJsonObject();
            if (this.I_field_5a && var8.has("order")) {
               JsonArray var3 = var8.getAsJsonArray("order");
               ArrayList var4 = new ArrayList();

               for (JsonElement var6 : var3) {
                  String var7 = var6.getAsString();
                  this.I_field_7865b31.stream().filter(var1x -> var1x.getName().equalsIgnoreCase(var7)).findFirst().ifPresent(var4::add);
               }

               for (MultiSelectSetting.Nested1_42856060 var19 : this.I_field_7865b31) {
                  if (!var4.contains(var19)) {
                     var4.add(var19);
                  }
               }

               this.I_field_7865b31.clear();
               this.I_field_7865b31.addAll(var4);
            }

            if (var8.has("selected")) {
               for (JsonElement var17 : var8.getAsJsonArray("selected")) {
                  String var20 = var17.getAsString();
                  this.I_field_7865b31.stream().filter(var1x -> var1x.getName().equalsIgnoreCase(var20)).findFirst().ifPresent(this.i_field_7865b31::add);
               }
            }
         } else if (var1.isJsonArray()) {
            for (JsonElement var15 : var1.getAsJsonArray()) {
               String var18 = var15.getAsString();
               this.I_field_7865b31.stream().filter(var1x -> var1x.getName().equalsIgnoreCase(var18)).findFirst().ifPresent(this.i_field_7865b31::add);
            }
         }

         for (MultiSelectSetting.Nested1_42856060 var13 : this.I_field_7865b31) {
            if (var13.isAlwaysEnabled() && !this.i_field_7865b31.contains(var13)) {
               this.i_field_7865b31.add(var13);
            }
         }

         if (this.i_field_7865b31.size() < this.I_field_49) {
            this.I_field_7865b31
               .stream()
               .filter(var1x -> !this.i_field_7865b31.contains(var1x))
               .limit(this.I_field_49 - this.i_field_7865b31.size())
               .forEach(this.i_field_7865b31::add);
         }
      }
   }

   private boolean i_method_14acac8e(JsonElement var1) {
      if (var1 != null && var1.isJsonArray()) {
         for (JsonElement var3 : var1.getAsJsonArray()) {
            if (!var3.isJsonPrimitive() || !var3.getAsJsonPrimitive().isString()) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean isValidJson(JsonElement var1) {
      if (var1 == null) {
         return false;
      } else if (!var1.isJsonObject()) {
         return this.II_method_8f17e84b(var1);
      } else {
         JsonObject var2 = var1.getAsJsonObject();
         return var2.has("selected") && this.II_method_8f17e84b(var2.get("selected"))
            ? !this.I_field_5a || var2.has("order") && this.II_method_8f17e84b(var2.get("order"))
            : false;
      }
   }

   private boolean II_method_8f17e84b(JsonElement var1) {
      if (!this.i_method_14acac8e(var1)) {
         return false;
      } else {
         for (JsonElement var3 : var1.getAsJsonArray()) {
            if (this.I_field_7865b31.stream().noneMatch(var1x -> var1x.getName().equalsIgnoreCase(var3.getAsString()))) {
               return false;
            }
         }

         return true;
      }
   }

   @Override
   public iii_Class8 createComponent() {
      iii_Class8 var1 = new iii_Class8()
         .I_method_8939bffd(
            new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(8.0F), () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a))
               .I_method_6da713d1(var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.75F + 0.25F * var0.hover()))
               .i_method_6b618aeb()
               .fill()
         )
         .I_method_8939bffd(
            new iii_Class8()
               .I_method_3301fdd(iII_Class5.II_field_b583e68c)
               .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
               .I_method_8939bffd(
                  new Iiii_Class8(
                        IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
                        () -> Math.toIntExact(this.i_field_7865b31.stream().filter(var0 -> !var0.isHidden()).count())
                     )
                     .I_method_2e768391(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5)
               )
               .I_method_8939bffd(
                  new Iii_Class4()
                     .text(
                        IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
                        () -> " "
                           + IiIiIIII_Class81.I_method_f25a980a("setting_of")
                           + " "
                           + this.I_field_7865b31.stream().filter(var0 -> !var0.isHidden()).count(),
                        var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5
                     )
               )
         )
         .I_method_70a38517(6.0F)
         .I_method_3301fdd(iII_Class5.II_field_b583e68c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0F, 0.0F, 0.0F, 0.0F))
         .III_method_9dc17555();
      Object var2;
      if (this.I_field_5a) {
         var2 = this.I_method_d087e1f5();
      } else {
         var2 = (new iii_Class8() {
               private final IdentityHashMap<MultiSelectSetting.Nested1_42856060, iiI_Class7> I_field_af8d717 = new IdentityHashMap<>();
               private List<MultiSelectSetting.Nested1_42856060> I_field_7865b31;

               {
                  for (MultiSelectSetting.Nested1_42856060 var3 : MultiSelectSetting.this.I_field_7865b31) {
                     Iii_Class4 var4 = var3.buildComponent();
                     this.I_field_af8d717.put(var3, var4);
                     this.I_method_8939bffd(var4);
                  }

                  this.I_field_7865b31 = new ArrayList<>(MultiSelectSetting.this.I_field_7865b31);
               }

               @Override
               protected void onTick(float var1, float var2x, float var3) {
                  if (!MultiSelectSetting.I_method_8a5ea605(this.I_field_7865b31, MultiSelectSetting.this.I_field_7865b31)) {
                     ArrayList var4 = new ArrayList(MultiSelectSetting.this.I_field_7865b31.size());

                     for (MultiSelectSetting.Nested1_42856060 var6 : MultiSelectSetting.this.I_field_7865b31) {
                        var4.add(this.I_field_af8d717.computeIfAbsent(var6, MultiSelectSetting.Nested1_42856060::buildComponent));
                     }

                     this.I_field_af8d717.keySet().removeIf(var1x -> !MultiSelectSetting.this.I_field_7865b31.contains(var1x));
                     this.II_method_244860a9(var4);
                     this.I_field_7865b31 = new ArrayList<>(MultiSelectSetting.this.I_field_7865b31);
                  }

                  super.onTick(var1, var2x, var3);
               }
            })
            .I_method_3301fdd(iII_Class5.II_field_b583e68c)
            .I_method_70a38517(2.0F)
            .III_method_9dc17555()
            .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 0.0F, 5.0F, 0.0F))
            .II_method_3b06fa38();
      }

      return new iii_Class8().I_method_3301fdd(iII_Class5.I_field_b583e68c).I_method_70a38517(5.0F).I_method_8939bffd(var1).I_method_8939bffd((iiI_Class7)var2);
   }

   static boolean I_method_8a5ea605(List<?> var0, List<?> var1) {
      if (var0.size() != var1.size()) {
         return false;
      } else {
         for (int var2 = 0; var2 < var0.size(); var2++) {
            if (var0.get(var2) != var1.get(var2)) {
               return false;
            }
         }

         return true;
      }
   }

   int i_method_1fc655f2() {
      return (int)this.I_field_7865b31.stream().filter(var0 -> !var0.isHidden()).count();
   }

   private Iii_Class4 I_method_d087e1f5() {
      final iiIiIIiii_Class424 var1 = new iiIiIIiii_Class424();
      Iii_Class4 var2 = new Iii_Class4() {
         private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
         private float I_field_46;
         private float i_field_46;

         @Override
         public float desiredH() {
            return 8 + 12 * MultiSelectSetting.this.i_method_1fc655f2();
         }

         @Override
         protected void onTick(float var1x, float var2x, float var3) {
            this.I_field_46 = var2x;
            this.i_field_46 = var3;
         }

         @Override
         protected void drawSelf(III var1x, float var2x) {
            float var3 = this.x();
            float var4 = this.y();
            float var5 = this.w();
            var1x.drawRoundedRect(
               var3, var4, var5, this.h(), IIiii_Class8.I_method_893b2757(6.0F), IiiiiIIIi_Class242.II_method_190e6391().withAlpha(76.5F * var2x)
            );
            float var6 = 0.0F;

            for (MultiSelectSetting.Nested1_42856060 var8 : MultiSelectSetting.this.I_field_7865b31) {
               if (!var8.isHidden()) {
                  float var9 = this.I_field_51de8227 == var8
                     ? Math.clamp(this.i_field_46 - 2.0F, var4 + 1.0F, var4 + 3.0F + 12 * MultiSelectSetting.this.i_method_1fc655f2())
                     : var4 + 7.0F + var6;
                  boolean var10 = this.inFlow()
                     && this.I_field_46 >= var3 - 1.0F
                     && this.I_field_46 <= var3 + var5 + 1.0F
                     && this.i_field_46 >= var9 - 4.0F
                     && this.i_field_46 <= var9 + 8.0F;
                  var8.getYAnim().I_method_df2f9087(IiiiIiiII_Class237.i_field_dd60aac);
                  var8.getYAnim().I_method_edd6dd11(var9 - var4);
                  var8.setYFactor(var9);
                  if (var10 && this.I_field_51de8227 != var8 && !var8.isAlwaysEnabled()) {
                     iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
                  }

                  if (var10 && this.I_field_46 <= var3 + 17.0F || var8 == this.I_field_51de8227) {
                     iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.Ii_field_aa52e62c);
                  }

                  var8.getHoverAnimation().I_method_edd72835(var10);
                  var8.getActiveAnimation().I_method_df2f9087(IiiiIiiII_Class237.I_field_dd60aac);
                  var8.getActiveAnimation().I_method_edd72835(var8.isSelected());
                  float var11 = var8.getActiveAnimation().I_method_6ac4da6f();
                  float var12 = var4 + var8.getYAnim().I_method_6ac4da6f();
                  var1x.drawIcon("hud/drag", var3 + 7.0F, var12, 6.0F, IiiiiIIIi_Class242.iI_method_8e08d3b1().mulAlpha(var2x));
                  var1x.drawFadeoutText(
                     IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F),
                     IiIiIIII_Class81.I_method_f25a980a(var8.getName()),
                     var3 + 18.0F,
                     var12 + 0.5F,
                     IiiiiIIIi_Class242.iI_method_8e08d3b1()
                        .withAlpha(255.0F * var2x * (0.75F + 0.25F * var8.getHoverAnimation().I_method_6ac4da6f() + 0.25F * var11)),
                     0.8F,
                     1.0F,
                     var5 - 30.0F - var11 * 9.0F
                  );
                  if (var11 > 0.01F) {
                     float var13 = 0.5F + 0.5F * var11;
                     float var14 = 6.0F * var13;
                     var1x.drawIcon(
                        "check",
                        var3 + var5 - 8.0F - var11 * 2.0F - var14 / 2.0F,
                        var12 + 3.0F - var14 / 2.0F,
                        var14,
                        IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(var2x * Math.min(1.0F, var11))
                     );
                  }

                  var6 += 12.0F;
               }
            }

            if (this.I_field_51de8227 != null && var1.I_method_58432069(100L)) {
               MultiSelectSetting.this.notifyChanged();
               MultiSelectSetting.this.I_field_7865b31.sort(Comparator.comparingDouble(MultiSelectSetting.Nested1_42856060::getYFactor));
               var1.I_method_23e11e3f();
            }
         }

         @Override
         public boolean mouseClicked(float var1x, float var2x, IiIII_Class9 var3) {
            if (var3 == IiIII_Class9.I_field_2f4c8d6c && this.inFlow() && this.contains(var1x, var2x)) {
               float var4 = this.x();
               float var5 = this.y();
               float var6 = this.w();
               float var7 = 0.0F;

               for (MultiSelectSetting.Nested1_42856060 var9 : MultiSelectSetting.this.I_field_7865b31) {
                  if (!var9.isHidden()) {
                     boolean var10 = var1x >= var4 - 1.0F && var1x <= var4 + var6 + 1.0F && var2x >= var5 + 3.0F + var7 && var2x <= var5 + 15.0F + var7;
                     if (var10 && var1x <= var4 + 17.0F) {
                        this.I_field_51de8227 = var9;
                     } else if (var10) {
                        var9.toggle();
                     }

                     var7 += 12.0F;
                  }
               }

               return true;
            } else {
               return false;
            }
         }

         @Override
         public void mouseReleased(float var1x, float var2x, IiIII_Class9 var3) {
            this.I_field_51de8227 = null;
            super.mouseReleased(var1x, var2x, var3);
         }
      };
      return var2.fillWidth();
   }

   @Generated
   public List<MultiSelectSetting.Nested1_42856060> I_method_45aaa648() {
      return this.I_field_7865b31;
   }

   @Generated
   public List<MultiSelectSetting.Nested1_42856060> i_method_faf6de68() {
      return this.i_field_7865b31;
   }

   @Generated
   public boolean i_method_9b12da03() {
      return this.I_field_5a;
   }

   @Generated
   public int I_method_1fb7ca12() {
      return this.I_field_49;
   }

   public static class Nested1_42856060 {
      private final MultiSelectSetting parent;
      private final String name;
      private final String description;
      private final IiiiIiIii_Class236 hoverAnimation = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
      private final IiiiIiIii_Class236 activeAnimation = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
      private final IiiiIiIii_Class236 yAnim = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.I_field_dd60aac);
      private float yFactor;
      boolean alwaysEnabled;
      private final BooleanSupplier hideCondition;
      private iiIIIiiIi_Class398 enablePenis;
      private iiIIIiiIi_Class398 disablePenis;
      private iiIIIiiIi_Class398 currentPenis;
      private boolean lastState;

      public Nested1_42856060(MultiSelectSetting var1, String var2) {
         this(var1, var2, "", () -> false);
      }

      public Nested1_42856060(MultiSelectSetting var1, String var2, BooleanSupplier var3) {
         this(var1, var2, "", var3);
      }

      public Nested1_42856060(MultiSelectSetting var1, String var2, String var3) {
         this(var1, var2, var3, () -> false);
      }

      public Nested1_42856060(MultiSelectSetting var1, String var2, String var3, BooleanSupplier var4) {
         this.parent = var1;
         this.name = var2;
         this.description = var3;
         this.hideCondition = var4;
         var1.I_method_4fa1e22(this);
      }

      public boolean isHidden() {
         return this.hideCondition != null && this.hideCondition.getAsBoolean();
      }

      public MultiSelectSetting.Nested1_42856060 select() {
         this.parent.i_method_bff19e42(this);
         return this;
      }

      public MultiSelectSetting.Nested1_42856060 deselect() {
         if (!this.alwaysEnabled) {
            this.parent.I_method_9a4a58f2(this, false);
         }

         return this;
      }

      public MultiSelectSetting.Nested1_42856060 alwaysEnabled() {
         this.alwaysEnabled = true;
         this.parent.i_method_bff19e42(this);
         return this;
      }

      public MultiSelectSetting.Nested1_42856060 toggle() {
         this.parent.II_method_3a5cd9ff(this);
         return this;
      }

      public boolean isSelected() {
         return this.parent.i_method_faf6de68().contains(this);
      }

      public Iii_Class4 buildComponent() {
         return new Iii_Class4()
            .bind("selected", this::isSelected, IIii_Class4.I_method_3682ece9(220L, IiiiIiiII_Class237.III_field_dd60aac))
            .text(
               IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F),
               () -> IiIiIIII_Class81.I_method_f25a980a(this.name),
               var0 -> IiiiiIIIi_Class242.I_method_35ed8eaf(background(var0)).mulAlpha(0.75F + 0.25F * var0.sig("selected"))
            )
            .textAlign(IIi_Class2.i_field_b5755e8c)
            .background(MultiSelectSetting.Nested1_42856060::background)
            .radius(2.5F)
            .padding(IIII.I_method_14640aa3(3.0F))
            .cursor(iIIIiIIIi_Class274.i_field_aa52e62c)
            .onClick(this::toggle);
      }

      private static ColorRGBA background(Iii_Class4 var0) {
         return IiiiiIIIi_Class242.IIi_field_d0c8ec5
            .mix(IiiiiIIIi_Class242.ii_field_d0c8ec5, 0.2F * var0.hover())
            .mix(IiiiiIIIi_Class242.ii_field_d0c8ec5.mix(IiiiiIIIi_Class242.IIi_field_d0c8ec5, 0.2F * var0.hover()), var0.sig("selected"));
      }

      @Override
      public String toString() {
         return this.name;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (var1 != null && var1.getClass() == this.getClass()) {
            MultiSelectSetting.Nested1_42856060 var2 = (MultiSelectSetting.Nested1_42856060)var1;
            return Objects.equals(this.parent, var2.parent) && Objects.equals(this.name, var2.name) && Objects.equals(this.description, var2.description);
         } else {
            return false;
         }
      }

      @Override
      public int hashCode() {
         return Objects.hash(this.parent, this.name, this.description);
      }

      @Generated
      public MultiSelectSetting getParent() {
         return this.parent;
      }

      @Generated
      public String getName() {
         return this.name;
      }

      @Generated
      public String getDescription() {
         return this.description;
      }

      @Generated
      public IiiiIiIii_Class236 getHoverAnimation() {
         return this.hoverAnimation;
      }

      @Generated
      public IiiiIiIii_Class236 getActiveAnimation() {
         return this.activeAnimation;
      }

      @Generated
      public IiiiIiIii_Class236 getYAnim() {
         return this.yAnim;
      }

      @Generated
      public float getYFactor() {
         return this.yFactor;
      }

      @Generated
      public boolean isAlwaysEnabled() {
         return this.alwaysEnabled;
      }

      @Generated
      public BooleanSupplier getHideCondition() {
         return this.hideCondition;
      }

      @Generated
      public iiIIIiiIi_Class398 getEnablePenis() {
         return this.enablePenis;
      }

      @Generated
      public iiIIIiiIi_Class398 getDisablePenis() {
         return this.disablePenis;
      }

      @Generated
      public iiIIIiiIi_Class398 getCurrentPenis() {
         return this.currentPenis;
      }

      @Generated
      public boolean isLastState() {
         return this.lastState;
      }

      @Generated
      public void setYFactor(float var1) {
         this.yFactor = var1;
      }

      @Generated
      public void setAlwaysEnabled(boolean var1) {
         this.alwaysEnabled = var1;
      }

      @Generated
      public void setEnablePenis(iiIIIiiIi_Class398 var1) {
         this.enablePenis = var1;
      }

      @Generated
      public void setDisablePenis(iiIIIiiIi_Class398 var1) {
         this.disablePenis = var1;
      }

      @Generated
      public void setCurrentPenis(iiIIIiiIi_Class398 var1) {
         this.currentPenis = var1;
      }

      @Generated
      public void setLastState(boolean var1) {
         this.lastState = var1;
      }
   }
}
