package rockstar.client;

import java.io.IOException;
import java.net.CookieManager;
import java.net.ProtocolException;
import java.net.UnknownHostException;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

public class iIIIII_Class33 extends Iiiiii_Class32<iIIIII_Class33> implements iIIIIi_Class34 {
   private iiIIii_Class52 I_field_570d0621;
   @Nullable
   private CookieManager I_field_aba732c5 = new CookieManager();
   private boolean I_field_5a = true;
   private int I_field_49 = 10000;
   private int i_field_49 = 10000;
   private IIIIiiI_Class7 I_field_f1a6bbec = new IIIIiiI_Class7();
   private iiiIiI_Class59 I_field_58cff261 = new iiiIiI_Class59();
   private boolean i_field_5a = false;

   public iIIIII_Class33() {
      this(iiIIIi_Class50.I_field_570c8e01);
   }

   public iIIIII_Class33(@Nonnull iiIIIi_Class50 var1) {
      this(var1::I_method_ea5cf54a);
   }

   public iIIIII_Class33(@Nonnull Function<iIIIII_Class33, iiIIii_Class52> var1) {
      this.I_method_df0c07d1(var1);
   }

   public iIIIII_Class33 I_method_df0c07d1(@Nonnull Function<iIIIII_Class33, iiIIii_Class52> var1) {
      iiIIii_Class52 var2 = (iiIIii_Class52)var1.apply(this);
      if (var2 == null) {
         throw new NullPointerException("The executor supplier returned null");
      } else {
         this.I_field_570d0621 = var2;
         return this;
      }
   }

   @Nullable
   public CookieManager I_method_d0f3bfcf() {
      return this.I_field_aba732c5;
   }

   public iIIIII_Class33 I_method_f16eb526(@Nullable CookieManager var1) {
      this.I_field_aba732c5 = var1;
      return this;
   }

   public boolean I_method_83b6d690() {
      return this.I_field_5a;
   }

   public iIIIII_Class33 I_method_2b0bc88f(boolean var1) {
      this.I_field_5a = var1;
      return this;
   }

   public int I_method_83b6d67f() {
      return this.I_field_49;
   }

   public iIIIII_Class33 I_method_b9d4380(int var1) {
      this.I_field_49 = var1;
      return this;
   }

   public int i_method_83c5625f() {
      return this.i_field_49;
   }

   public iIIIII_Class33 i_method_25be2f60(int var1) {
      this.i_field_49 = var1;
      return this;
   }

   @Nonnull
   public IIIIiiI_Class7 I_method_75ebd022() {
      return this.I_field_f1a6bbec;
   }

   public iIIIII_Class33 I_method_ea5c83d(@Nonnull IIIIiiI_Class7 var1) {
      this.I_field_f1a6bbec = var1;
      return this;
   }

   @Deprecated
   @ScheduledForRemoval
   public iIIIII_Class33 i_method_c9b9141d(@Nonnull IIIIiiI_Class7 var1) {
      this.I_field_f1a6bbec = var1;
      return this;
   }

   @Nonnull
   public iiiIiI_Class59 I_method_7e1c7f6b() {
      return this.I_field_58cff261;
   }

   public iIIIII_Class33 I_method_26b97d0a(@Nonnull iiiIiI_Class59 var1) {
      this.I_field_58cff261 = var1;
      return this;
   }

   public boolean i_method_83c56270() {
      return this.i_field_5a;
   }

   public iIIIII_Class33 i_method_452cb46f(boolean var1) {
      this.i_field_5a = var1;
      return this;
   }

   public <T extends iiiiii_Class64 & iiIiiI_Class55<R>, R> R I_method_fc2df765(T var1) throws IOException {
      return this.I_method_9ec8aba4(var1, (iiIiiI_Class55<R>)var1);
   }

   public <R> R I_method_9ec8aba4(iiiiii_Class64 var1, iiIiiI_Class55<R> var2) throws IOException {
      return (R)var2.handle(this.I_method_7ad89d6a(var1));
   }

   public iIIIiI_Class35 I_method_7ad89d6a(iiiiii_Class64 var1) throws IOException {
      IIIIiiI_Class7 var2 = var1.iI_method_3c354299() ? var1.I_method_8d924c02() : this.I_field_f1a6bbec;

      for (int var3 = 0; var3 <= var2.I_method_c281a892(); var3++) {
         try {
            iIIIiI_Class35 var4 = null;

            for (int var5 = 0; var5 <= var2.i_method_c2903472(); var5++) {
               var4 = this.I_field_570d0621.I_method_70c9916a(var1);
               IIIIiIi_Class6 var6 = var2.I_method_e5765d15().I_method_ef0329f6(var4);
               if (!var6.I_method_5c555463()) {
                  return var4;
               }

               var6.I_method_5c55545f();
            }

            if (var4 == null) {
               throw new IllegalStateException("Response not received but no exception was thrown");
            }

            if (var2.i_method_c2903472() == 0) {
               return var4;
            }

            throw new iiIIII_Class49(var4);
         } catch (InterruptedException var7) {
            throw new IOException(var7);
         } catch (SSLException | ProtocolException | UnknownHostException var8) {
            throw var8;
         } catch (IOException var9) {
            if (var3 >= var2.I_method_c281a892()) {
               throw var9;
            }
         }
      }

      throw new IllegalStateException("Connect retry failed but no exception was thrown");
   }

   @Override
   public <T extends iiiiii_Class64> T I_method_b345312a(T var1) {
      var1.I_method_80f3492a(this);
      return (T)var1;
   }

   @Override
   public String toString() {
      return "HttpClient#" + this.I_field_570d0621.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this));
   }
}
