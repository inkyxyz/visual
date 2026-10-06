package rockstar.client;

import java.util.List;
import java.util.Locale;
import lombok.Generated;

public class IiiIIiiI_Class103 implements iIIiIIiIi_Class294 {
   private static final long I_field_4a = 1500L;
   private IiiIIiiI_Class103.Nested1_6cfda4d3 I_field_b0c525fc;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private long i_field_4a;
   private int I_field_49;
   private int i_field_49;
   private boolean I_field_5a;

   public IiiIIiiI_Class103() {
      this.I_field_b0c525fc = IiiIIiiI_Class103.Nested1_6cfda4d3.I_field_b0c525fc;
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.i_field_4a = System.currentTimeMillis();
      this.I_field_49 = 0;
      this.i_field_49 = 0;
      this.I_field_5a = false;
   }

   public void I_method_615d4ccc() {
      if (!this.I_field_5a) {
         List var1 = IiiIIiII_Class101.I_method_96ec801b();
         if (!var1.isEmpty()) {
            if (this.I_field_b0c525fc == IiiIIiiI_Class103.Nested1_6cfda4d3.I_field_b0c525fc
               && System.currentTimeMillis() - this.i_field_4a >= IiiIIiII_Class101.I_method_c495e4a0()) {
               this.i_field_49 = 0;
               this.I_field_b0c525fc = IiiIIiiI_Class103.Nested1_6cfda4d3.i_field_b0c525fc;
               this.I_field_991c1e8c.I_method_23e11e3f();
            }

            switch (this.I_field_b0c525fc) {
               case I_field_b0c525fc:
               default:
                  break;
               case i_field_b0c525fc:
                  if (!this.I_field_991c1e8c.I_method_58432069(1500L)) {
                     return;
                  }

                  I_field_3a9bda27.player.networkHandler.sendChatCommand("an" + var1.get(this.I_field_49 % var1.size()));
                  this.I_field_b0c525fc = IiiIIiiI_Class103.Nested1_6cfda4d3.II_field_b0c525fc;
                  this.I_field_991c1e8c.I_method_23e11e3f();
                  break;
               case II_field_b0c525fc:
                  if (this.I_field_991c1e8c.I_method_58432069(IiiIIiII_Class101.i_method_c4a47080())) {
                     this.I_field_b0c525fc = IiiIIiiI_Class103.Nested1_6cfda4d3.Ii_field_b0c525fc;
                  }
                  break;
               case Ii_field_b0c525fc:
                  I_field_3a9bda27.player.networkHandler.sendChatCommand("ah");
                  this.I_field_b0c525fc = IiiIIiiI_Class103.Nested1_6cfda4d3.I_field_b0c525fc;
                  this.I_field_49 = (this.I_field_49 + 1) % var1.size();
                  this.i_field_49 = 0;
                  this.i_field_4a = System.currentTimeMillis();
            }
         }
      }
   }

   public void I_method_9fad5b96(String var1) {
      if (this.I_field_b0c525fc == IiiIIiiI_Class103.Nested1_6cfda4d3.i_field_b0c525fc
         || this.I_field_b0c525fc == IiiIIiiI_Class103.Nested1_6cfda4d3.II_field_b0c525fc) {
         if (this.I_method_9fad5b9a(var1)) {
            List var2 = IiiIIiII_Class101.I_method_96ec801b();
            if (!var2.isEmpty()) {
               if (++this.i_field_49 >= var2.size()) {
                  this.i_field_49 = 0;
                  this.I_field_b0c525fc = IiiIIiiI_Class103.Nested1_6cfda4d3.I_field_b0c525fc;
                  this.i_field_4a = System.currentTimeMillis();
               } else {
                  this.I_field_49 = (this.I_field_49 + 1) % var2.size();
                  this.I_field_b0c525fc = IiiIIiiI_Class103.Nested1_6cfda4d3.i_field_b0c525fc;
                  this.I_field_991c1e8c.I_method_23e11e3f();
               }
            }
         }
      }
   }

   private boolean I_method_9fad5b9a(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);
      return var2.contains("\u0441\u0435\u0440\u0432\u0435\u0440 \u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d")
         || var2.contains("\u043a\u0438\u043a\u043d\u0443\u0442\u044b \u043f\u0440\u0438 \u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0438")
         || var2.contains("\u0441\u0435\u0440\u0432\u0435\u0440 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u0435\u043d");
   }

   public void I_method_ca4cff88(boolean var1) {
      this.I_field_5a = var1;
   }

   public void i_method_616bd8ac() {
   }

   public void II_method_ca5b4415() {
      this.i_field_4a = System.currentTimeMillis();
      this.i_field_49 = 0;
   }

   @Generated
   public IiiIIiiI_Class103.Nested1_6cfda4d3 I_method_6bd1bfc6() {
      return this.I_field_b0c525fc;
   }

   @Generated
   public boolean I_method_615d4cd0() {
      return this.I_field_5a;
   }

   public static enum Nested1_6cfda4d3 {
      I_field_b0c525fc,
      i_field_b0c525fc,
      II_field_b0c525fc,
      Ii_field_b0c525fc;
   }
}
