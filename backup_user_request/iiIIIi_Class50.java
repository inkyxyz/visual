package rockstar.client;

import java.lang.reflect.Constructor;

public enum iiIIIi_Class50 {
   I_field_570c8e01 {
      @Override
      public iiIIii_Class52 i_method_30b561f7(iIIIII_Class33 var1) {
         for (int var2 = values().length - 1; var2 >= 0; var2--) {
            iiIIIi_Class50 var3 = values()[var2];
            if (!I_field_570c8e01.equals(var3) && var3.I_method_43800e50()) {
               iiIIii_Class52 var4 = var3.I_method_ea5cf54a(var1);
               if (var4 != null) {
                  return var4;
               }
            }
         }

         throw new IllegalStateException("Failed to find a suitable executor. This should never happen. Please report this to the developer.");
      }
   },
   i_field_570c8e01 {
      @Override
      public iiIIii_Class52 i_method_30b561f7(iIIIII_Class33 var1) {
         return new iiIiII_Class53(var1);
      }
   },
   II_field_570c8e01 {
      private Constructor<?> I_field_dcdd2cd3;

      @Override
      protected void I_method_2d8f2e9d() throws Throwable {
         Class.forName("reactor.netty.http.client.HttpClient");
         Class var1 = Class.forName("rockstar.client.iiIiIi");
         this.I_field_dcdd2cd3 = var1.getDeclaredConstructor(iIIIII_Class33.class);
      }

      @Override
      protected iiIIii_Class52 i_method_30b561f7(iIIIII_Class33 var1) throws Throwable {
         return (iiIIii_Class52)this.I_field_dcdd2cd3.newInstance(var1);
      }
   },
   Ii_field_570c8e01 {
      private Constructor<?> I_field_dcdd2cd3;

      @Override
      protected void I_method_2d8f2e9d() throws Throwable {
         Class.forName("java.net.http.HttpClient");
         Class var1 = Class.forName("rockstar.client.iiIIiI");
         this.I_field_dcdd2cd3 = var1.getDeclaredConstructor(iIIIII_Class33.class);
      }

      @Override
      protected iiIIii_Class52 i_method_30b561f7(iIIIII_Class33 var1) throws Throwable {
         return (iiIIii_Class52)this.I_field_dcdd2cd3.newInstance(var1);
      }
   };

   private boolean I_field_5a;

   private iiIIIi_Class50() {
      try {
         this.I_method_2d8f2e9d();
         this.I_field_5a = true;
      } catch (Throwable var4) {
         this.I_field_5a = false;
      }
   }

   public final boolean I_method_43800e50() {
      return this.I_field_5a;
   }

   public final iiIIii_Class52 I_method_ea5cf54a(iIIIII_Class33 var1) {
      try {
         return this.i_method_30b561f7(var1);
      } catch (Throwable var3) {
         return null;
      }
   }

   protected void I_method_2d8f2e9d() throws Throwable {
   }

   protected abstract iiIIii_Class52 i_method_30b561f7(iIIIII_Class33 var1) throws Throwable;
}
