package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.EnumSet;
import java.util.function.BooleanSupplier;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;

public class TimeSetting extends AbstractSetting {
   final EnumSet<TimeSetting.Nested1_71da9c20> I_field_e0987866 = EnumSet.allOf(TimeSetting.Nested1_71da9c20.class);
   private int I_field_49 = 24;
   private int i_field_49 = 60;
   private int II_field_49;
   private IIiiIiiii_Class112<Integer> I_field_8548a68c = var0 -> var0;

   public TimeSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, String var3, @NotNull BooleanSupplier var4) {
      super(var1, var2, var4);
   }

   public TimeSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, @NotNull BooleanSupplier var3) {
      super(var1, var2, var3);
   }

   public TimeSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, String var3) {
      super(var1, var2);
   }

   public TimeSetting(@NotNull IIiiiIIiI_Class115 var1, String var2) {
      super(var1, var2);
   }

   public TimeSetting I_method_8013ade1(TimeSetting.Nested1_71da9c20... var1) {
      this.I_field_e0987866.clear();
      if (var1 != null) {
         for (TimeSetting.Nested1_71da9c20 var5 : var1) {
            if (var5 != null) {
               this.I_field_e0987866.add(var5);
            }
         }
      }

      if (this.I_field_e0987866.isEmpty()) {
         this.I_field_e0987866.add(TimeSetting.Nested1_71da9c20.II_field_d30be67);
      }

      this.I_method_9e134884(this.II_field_49);
      return this;
   }

   public TimeSetting I_method_a7007deb(boolean var1) {
      return this.I_method_4b9f2c48(TimeSetting.Nested1_71da9c20.I_field_d30be67, var1);
   }

   public TimeSetting i_method_4419860b(boolean var1) {
      return this.I_method_4b9f2c48(TimeSetting.Nested1_71da9c20.i_field_d30be67, var1);
   }

   public TimeSetting II_method_c64bad88(boolean var1) {
      return this.I_method_4b9f2c48(TimeSetting.Nested1_71da9c20.II_field_d30be67, var1);
   }

   private TimeSetting I_method_4b9f2c48(TimeSetting.Nested1_71da9c20 var1, boolean var2) {
      if (var2) {
         this.I_field_e0987866.add(var1);
      } else if (this.I_field_e0987866.size() > 1) {
         this.I_field_e0987866.remove(var1);
      }

      this.I_method_9e134884(this.II_field_49);
      return this;
   }

   public TimeSetting I_method_e8b2515a(int var1) {
      this.I_field_49 = Math.max(1, var1);
      this.I_method_9e134884(this.II_field_49);
      return this;
   }

   public TimeSetting i_method_85cb597a(int var1) {
      this.i_field_49 = Math.max(1, Math.min(60, var1));
      this.I_method_9e134884(this.II_field_49);
      return this;
   }

   public TimeSetting II_method_7fd80f7(int var1) {
      this.I_method_9e134884(var1);
      return this;
   }

   public TimeSetting I_method_694e679d(IIiiIiiii_Class112<Integer> var1) {
      if (var1 != null) {
         this.I_field_8548a68c = var1;
      }

      return this;
   }

   public void I_method_9e134884(int var1) {
      int var2 = this.I_method_9e134877(this.I_field_8548a68c.changed(Math.max(0, var1)));
      if (this.II_field_49 != var2) {
         this.notifyChanged();
         this.II_field_49 = var2;
      }
   }

   public boolean I_method_ea248626(TimeSetting.Nested1_71da9c20 var1) {
      return this.I_field_e0987866.contains(var1);
   }

   public int I_method_4f6bf652() {
      return this.I_method_ea248626(TimeSetting.Nested1_71da9c20.I_field_d30be67) ? this.II_field_49 / 3600 % this.I_field_49 : 0;
   }

   public int i_method_4f7a8232() {
      return this.I_method_ea248626(TimeSetting.Nested1_71da9c20.i_field_d30be67) ? this.II_field_49 / 60 % this.i_field_49 : 0;
   }

   public int II_method_9e21ccd5() {
      return this.I_method_ea248626(TimeSetting.Nested1_71da9c20.II_field_d30be67) ? this.II_field_49 % 60 : 0;
   }

   public void i_method_9fd638a4(int var1) {
      this.I_method_9e134884(Math.floorMod(var1, this.I_field_49) * 3600 + this.i_method_4f7a8232() * 60 + this.II_method_9e21ccd5());
   }

   public void II_method_26184261(int var1) {
      this.I_method_9e134884(this.I_method_4f6bf652() * 3600 + Math.floorMod(var1, this.i_field_49) * 60 + this.II_method_9e21ccd5());
   }

   public void Ii_method_27db3281(int var1) {
      this.I_method_9e134884(this.I_method_4f6bf652() * 3600 + this.i_method_4f7a8232() * 60 + Math.floorMod(var1, 60));
   }

   public long I_method_4f6bf653() {
      return this.II_field_49 * 1000L;
   }

   public int Ii_method_9e3058b5() {
      return this.II_field_49 * 20;
   }

   public String II_method_5a3347fe() {
      StringBuilder var1 = new StringBuilder();

      for (TimeSetting.Nested1_71da9c20 var3 : this.I_field_e0987866) {
         int var4 = switch (var3) {
            case I_field_d30be67 -> this.I_method_4f6bf652();
            case i_field_d30be67 -> this.i_method_4f7a8232();
            case II_field_d30be67 -> this.II_method_9e21ccd5();
         };
         if (var1.isEmpty()) {
            var1.append(var4);
         } else {
            var1.append(':').append(var4 < 10 ? "0" + var4 : String.valueOf(var4));
         }
      }

      return var1.toString();
   }

   private int I_method_9e134877(int var1) {
      var1 = Math.max(0, var1);
      int var2 = this.I_method_ea248626(TimeSetting.Nested1_71da9c20.I_field_d30be67) ? var1 / 3600 % this.I_field_49 : 0;
      int var3 = this.I_method_ea248626(TimeSetting.Nested1_71da9c20.i_field_d30be67) ? var1 / 60 % this.i_field_49 : 0;
      int var4 = this.I_method_ea248626(TimeSetting.Nested1_71da9c20.II_field_d30be67) ? var1 % 60 : 0;
      return var2 * 3600 + var3 * 60 + var4;
   }

   @Override
   public JsonElement toJson() {
      return new JsonPrimitive(this.II_field_49);
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isNumber()) {
         double var2 = var1.getAsDouble();
         if (Double.isFinite(var2) && var2 >= 0.0 && var2 <= 2.147483647E9) {
            this.I_method_9e134884((int)var2);
         }
      }
   }

   @Override
   public boolean isValidJson(JsonElement var1) {
      if (var1 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isNumber()) {
         double var2 = var1.getAsDouble();
         return Double.isFinite(var2) && var2 >= 0.0 && var2 <= 2.147483647E9;
      } else {
         return false;
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
            new iiII_Class13(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(7.0F), this::II_method_5a3347fe)
               .I_method_6da713d1(var0 -> IiiiiIIIi_Class242.ii_field_d0c8ec5)
         )
         .I_method_70a38517(6.0F)
         .I_method_3301fdd(iII_Class5.II_field_b583e68c)
         .I_method_fe5d8d56(IIIi_Class2.Ii_field_f93600a1)
         .I_method_483797dd(IIi_Class2.i_field_b5755e8c)
         .I_method_7e2bb176(IIII.I_method_12c9a0cb(6.0F, 0.0F, 0.0F, 0.0F))
         .III_method_9dc17555();
      IIiIi_Class6 var2 = new IIiIi_Class6() {
         private final EnumSet<TimeSetting.Nested1_71da9c20> I_field_e0987866 = EnumSet.noneOf(TimeSetting.Nested1_71da9c20.class);

         {
            this.I_method_eab7acb2();
         }

         private void I_method_eab7acb2() {
            this.I_field_e0987866.clear();
            this.I_field_e0987866.addAll(TimeSetting.this.I_field_e0987866);
            TimeSetting.this.I_method_e0121a07(this);
         }

         @Override
         protected void onTick(float var1, float var2x, float var3) {
            if (!this.I_field_e0987866.equals(TimeSetting.this.I_field_e0987866)) {
               this.I_method_eab7acb2();
            }

            super.onTick(var1, var2x, var3);
         }
      };
      return new iii_Class8()
         .I_method_3301fdd(iII_Class5.I_field_b583e68c)
         .I_method_70a38517(5.0F)
         .I_method_8939bffd(var1)
         .I_method_8939bffd(
            new iii_Class8()
               .I_method_3301fdd(iII_Class5.I_field_b583e68c)
               .III_method_9dc17555()
               .I_method_7e2bb176(IIII.I_method_12c9a0cb(0.0F, 0.0F, 4.0F, 0.0F))
               .I_method_8939bffd(var2.I_method_73a53b57(12.5F).I_method_36225a(5).i_method_fce65295())
         );
   }

   void I_method_e0121a07(IIiIi_Class6 var1) {
      var1.Ii_method_6e2a5018();
      if (this.I_method_ea248626(TimeSetting.Nested1_71da9c20.I_field_d30be67)) {
         var1.I_method_b95e284(
            this.I_field_49, this::I_method_4f6bf652, this::i_method_9fd638a4, TimeSetting.Nested1_71da9c20.I_field_d30be67::I_method_e9656046
         );
      }

      if (this.I_method_ea248626(TimeSetting.Nested1_71da9c20.i_field_d30be67)) {
         var1.I_method_b95e284(
            this.i_field_49, this::i_method_4f7a8232, this::II_method_26184261, TimeSetting.Nested1_71da9c20.i_field_d30be67::I_method_e9656046
         );
      }

      if (this.I_method_ea248626(TimeSetting.Nested1_71da9c20.II_field_d30be67)) {
         var1.I_method_b95e284(60, this::II_method_9e21ccd5, this::Ii_method_27db3281, TimeSetting.Nested1_71da9c20.II_field_d30be67::I_method_e9656046);
      }
   }

   @Generated
   public EnumSet<TimeSetting.Nested1_71da9c20> I_method_40305e2f() {
      return this.I_field_e0987866;
   }

   @Generated
   public int iI_method_9fe4bcf5() {
      return this.I_field_49;
   }

   @Generated
   public int ii_method_9ff348d5() {
      return this.i_field_49;
   }

   @Generated
   public int III_method_2626c6b2() {
      return this.II_field_49;
   }

   @Generated
   public IIiiIiiii_Class112<Integer> I_method_fee6b355() {
      return this.I_field_8548a68c;
   }

   public static enum Nested1_71da9c20 {
      I_field_d30be67(3600, "time.unit.hours"),
      i_field_d30be67(60, "time.unit.minutes"),
      II_field_d30be67(1, "time.unit.seconds");

      private final int I_field_49;
      private final String I_field_523beb0a;

      private Nested1_71da9c20(int var3, String var4) {
         this.I_field_49 = var3;
         this.I_field_523beb0a = var4;
      }

      public int I_method_13abfb8d() {
         return this.I_field_49;
      }

      public String I_method_e9656046() {
         return IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a);
      }
   }
}
