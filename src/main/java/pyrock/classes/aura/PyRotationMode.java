package pyrock.classes.aura;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import jep.python.PyCallable;
import jep.python.PyObject;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import pyrock.classes.PyRotations;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IIiiIiIIi_Class106;
import rockstar.client.ModeSetting;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.iiiIIIIi_Class226;

public class PyRotationMode extends iiiIIIIi_Class226 {
   private final PyCallable rotateFn;
   private final PyCallable attackFn;
   private final PyCallable canAttackFn;
   private final PyCallable targetNullFn;
   private final PyCallable updateFn;
   private final IIiiIIiii_Class104 owner;
   private boolean errored;

   public PyRotationMode(ModeSetting var1, String var2, PyCallable var3, PyCallable var4, PyCallable var5, PyCallable var6, PyCallable var7) {
      super(var1, var2);
      this.rotateFn = var3;
      this.attackFn = var4;
      this.canAttackFn = var5;
      this.targetNullFn = var6;
      this.updateFn = var7;
      this.owner = IIiiIIiii_Class104.I_method_204b62f5();
   }

   @Override
   public void rotate(iiIIiIiII_Class405 var1, float var2, boolean var3, boolean var4, iiIIiIIIi_Class402 var5, LivingEntity var6) {
      if (this.rotateFn != null && !this.errored && IIiiIiIIi_Class106.Ii_method_b61528e6()) {
         try (AutoCloseable var7 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
            Object var8 = this.rotateFn.call(new Object[]{var1, var2, var3, var4, var5, var6});
            PyRotationMode.Nested1_e473fc99 var9 = this.parseRotationRequest(var8, var5);
            if (var9 != null) {
               var1.I_method_3eb39c6f(
                  var9.rotation(), var9.moveCorrection(), var9.yawSpeed(), var9.pitchSpeed(), var9.returnSpeed(), var9.priority(), var9.correctGcd()
               );
            }
         } catch (Exception var12) {
            this.fail("rotate", var12);
            this.applyDefault(var1, var5, var6);
         }
      } else {
         this.applyDefault(var1, var5, var6);
      }
   }

   private void applyDefault(iiIIiIiII_Class405 var1, iiIIiIIIi_Class402 var2, LivingEntity var3) {
      if (var3 != null) {
         iiIIiIIii_Class404 var4 = iiIIiIiIi_Class406.I_method_a2bb2af5(var3, this.aura());
         var1.I_method_1acbf705(var4, var2, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.II_field_32efc66c);
      }
   }

   private PyRotationMode.Nested1_e473fc99 parseRotationRequest(Object var1, iiIIiIIIi_Class402 var2) {
      if (var1 == null) {
         return null;
      } else if (var1 instanceof iiIIiIIii_Class404 var11) {
         return this.request(var11, var2);
      } else if (var1 instanceof List var10) {
         return this.request(this.rotationFromList(var10), var2);
      } else if (var1 instanceof Map var9) {
         return this.requestFromMap(var9, var2);
      } else if (var1 instanceof PyObject var8) {
         PyRotationMode.Nested1_e473fc99 var4;
         try {
            var4 = this.requestFromPyObject(var8, var2);
         } finally {
            this.closeQuietly(var8);
         }

         return var4;
      } else {
         iiIIiIIii_Class404 var3 = this.rotationFromObject(var1);
         if (var3 != null) {
            return this.request(var3, var2);
         } else {
            throw new IllegalArgumentException("rotate returned unsupported value: " + var1.getClass().getName());
         }
      }
   }

   private PyRotationMode.Nested1_e473fc99 requestFromPyObject(PyObject var1, iiIIiIIIi_Class402 var2) {
      iiIIiIIii_Class404 var3 = this.pyAs(var1, iiIIiIIii_Class404.class);
      if (var3 != null) {
         return this.request(var3, var2);
      } else {
         List var4 = this.pyAs(var1, List.class);
         if (var4 != null) {
            return this.request(this.rotationFromList(var4), var2);
         } else {
            Map var5 = this.pyAs(var1, Map.class);
            if (var5 != null) {
               return this.requestFromMap(var5, var2);
            } else {
               Object var6 = this.pyAttr(var1, "yaw");
               Object var7 = this.pyAttr(var1, "pitch");
               if (var6 != null && var7 != null) {
                  return this.request(new iiIIiIIii_Class404(this.asFloat(var6, "yaw"), this.asFloat(var7, "pitch")), var2);
               } else {
                  throw new IllegalArgumentException("rotate returned unsupported python object: " + var1);
               }
            }
         }
      }
   }

   private PyRotationMode.Nested1_e473fc99 requestFromMap(Map<?, ?> var1, iiIIiIIIi_Class402 var2) {
      iiIIiIIii_Class404 var3 = null;
      Object var4 = this.first(var1, "rotation", "rot");
      if (var4 != null) {
         PyRotationMode.Nested1_e473fc99 var5 = this.parseRotationRequest(var4, var2);
         if (var5 != null) {
            var3 = var5.rotation();
         }
      }

      if (var3 == null) {
         var3 = new iiIIiIIii_Class404(this.asFloat(this.first(var1, "yaw", "x"), "yaw"), this.asFloat(this.first(var1, "pitch", "y"), "pitch"));
      }

      iiIIiIIIi_Class402 var11 = this.parseCorrection(this.first(var1, "correction", "moveCorrection", "move_correction"), var2);
      iiIIiIiiI_Class407 var6 = this.parsePriority(this.first(var1, "priority", "prio"), iiIIiIiiI_Class407.II_field_32efc66c);
      float var7 = this.asFloat(this.first(var1, "yawSpeed", "yaw_speed"), 180.0F);
      float var8 = this.asFloat(this.first(var1, "pitchSpeed", "pitch_speed"), 180.0F);
      float var9 = this.asFloat(this.first(var1, "returnSpeed", "return_speed"), 180.0F);
      boolean var10 = this.parseCorrectGcd(var1);
      return new PyRotationMode.Nested1_e473fc99(var3, var11, var7, var8, var9, var6, var10);
   }

   private iiIIiIIii_Class404 rotationFromList(List<?> var1) {
      if (var1.size() < 2) {
         throw new IllegalArgumentException("rotation list must contain yaw and pitch");
      } else {
         return new iiIIiIIii_Class404(this.asFloat(var1.get(0), "yaw"), this.asFloat(var1.get(1), "pitch"));
      }
   }

   private iiIIiIIii_Class404 rotationFromObject(Object var1) {
      Object var2 = this.property(var1, "yaw", "getYaw");
      Object var3 = this.property(var1, "pitch", "getPitch");
      return var2 != null && var3 != null ? new iiIIiIIii_Class404(this.asFloat(var2, "yaw"), this.asFloat(var3, "pitch")) : null;
   }

   private PyRotationMode.Nested1_e473fc99 request(iiIIiIIii_Class404 var1, iiIIiIIIi_Class402 var2) {
      return new PyRotationMode.Nested1_e473fc99(var1, var2, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.II_field_32efc66c, true);
   }

   private Object first(Map<?, ?> var1, String... var2) {
      for (String var6 : var2) {
         if (var1.containsKey(var6)) {
            return var1.get(var6);
         }
      }

      return null;
   }

   private Object pyAttr(PyObject var1, String var2) {
      try {
         return var1.getAttr(var2);
      } catch (Exception var4) {
         return null;
      }
   }

   private <T> T pyAs(PyObject var1, Class<T> var2) {
      try {
         return (T)var1.as(var2);
      } catch (Exception var4) {
         return null;
      }
   }

   private Object property(Object var1, String var2, String var3) {
      try {
         Method var9 = var1.getClass().getMethod(var3);
         return var9.invoke(var1);
      } catch (Exception var7) {
         try {
            Method var8 = var1.getClass().getMethod(var2);
            return var8.invoke(var1);
         } catch (Exception var6) {
            try {
               Field var4 = var1.getClass().getField(var2);
               return var4.get(var1);
            } catch (Exception var5) {
               return null;
            }
         }
      }
   }

   private iiIIiIIIi_Class402 parseCorrection(Object var1, iiIIiIIIi_Class402 var2) {
      if (var1 == null) {
         return var2;
      } else if (var1 instanceof iiIIiIIIi_Class402 var5) {
         return var5;
      } else {
         if (var1 instanceof PyObject var3) {
            iiIIiIIIi_Class402 var4 = this.pyAs(var3, iiIIiIIIi_Class402.class);
            if (var4 != null) {
               return var4;
            }
         }

         return PyRotations.parseCorrection(String.valueOf(var1));
      }
   }

   private iiIIiIiiI_Class407 parsePriority(Object var1, iiIIiIiiI_Class407 var2) {
      if (var1 == null) {
         return var2;
      } else if (var1 instanceof iiIIiIiiI_Class407 var5) {
         return var5;
      } else {
         if (var1 instanceof PyObject var3) {
            iiIIiIiiI_Class407 var4 = this.pyAs(var3, iiIIiIiiI_Class407.class);
            if (var4 != null) {
               return var4;
            }
         }

         return PyRotations.parsePriority(String.valueOf(var1));
      }
   }

   private float asFloat(Object var1, String var2) {
      if (var1 instanceof Number var10) {
         return var10.floatValue();
      } else {
         if (var1 instanceof PyObject var3) {
            Number var4 = this.pyAs(var3, Number.class);
            if (var4 != null) {
               return var4.floatValue();
            }

            Double var5 = this.pyAs(var3, Double.class);
            if (var5 != null) {
               return var5.floatValue();
            }

            Float var6 = this.pyAs(var3, Float.class);
            if (var6 != null) {
               return var6;
            }

            Integer var7 = this.pyAs(var3, Integer.class);
            if (var7 != null) {
               return var7.floatValue();
            }

            String var8 = this.pyAs(var3, String.class);
            if (var8 != null) {
               return Float.parseFloat(var8);
            }
         }

         if (var1 instanceof String var9) {
            return Float.parseFloat(var9);
         } else if (var1 == null) {
            throw new IllegalArgumentException(var2 + " is required");
         } else {
            throw new IllegalArgumentException(var2 + " must be a number");
         }
      }
   }

   private float asFloat(Object var1, float var2) {
      return var1 == null ? var2 : this.asFloat(var1, "rotation option");
   }

   private boolean parseCorrectGcd(Map<?, ?> var1) {
      Object var2 = this.first(var1, "rawGcd", "raw_gcd");
      if (var2 != null) {
         return !this.asBoolean(var2);
      } else {
         Object var3 = this.first(var1, "correctGcd", "correct_gcd", "vanillaGcd", "vanilla_gcd", "handlerGcd", "handler_gcd");
         return var3 == null || this.asBoolean(var3);
      }
   }

   private boolean asBoolean(Object var1) {
      if (var1 instanceof Boolean var5) {
         return var5;
      } else {
         if (var1 instanceof PyObject var2) {
            Boolean var3 = this.pyAs(var2, Boolean.class);
            if (var3 != null) {
               return var3;
            }

            String var4 = this.pyAs(var2, String.class);
            if (var4 != null) {
               return Boolean.parseBoolean(var4);
            }
         }

         return Boolean.parseBoolean(String.valueOf(var1));
      }
   }

   private void closeQuietly(PyObject var1) {
      try {
         var1.close();
      } catch (Exception var3) {
      }
   }

   @Override
   public void attack() {
      this.invoke(this.attackFn, "attack");
   }

   @Override
   public void targetNull() {
      this.invoke(this.targetNullFn, "target_null");
   }

   @Override
   public void update() {
      this.invoke(this.updateFn, "update");
   }

   @Override
   public boolean canAttack() {
      if (this.canAttackFn != null && !this.errored && IIiiIiIIi_Class106.Ii_method_b61528e6()) {
         try {
            boolean var7;
            try (AutoCloseable var1 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
               var7 = !(this.canAttackFn.call(new Object[0]) instanceof Boolean var3 && !var3);
            }

            return var7;
         } catch (Exception var6) {
            this.fail("can_attack", var6);
            return true;
         }
      } else {
         return true;
      }
   }

   private void invoke(PyCallable var1, String var2) {
      if (var1 != null && !this.errored && IIiiIiIIi_Class106.Ii_method_b61528e6()) {
         try (AutoCloseable var3 = IIiiIIiii_Class104.I_method_5edeb6c9(this.owner)) {
            var1.call(new Object[0]);
         } catch (Exception var8) {
            this.fail(var2, var8);
         }
      }
   }

   private void fail(String var1, Exception var2) {
      this.errored = true;
      String var3 = var2.getMessage() == null ? var2.getClass().getSimpleName() : var2.getMessage();
      iIIIIIIii_Class260.II_method_e8fd4864(Text.of("[rotation:" + this.getName() + "] " + var1 + ": " + var3));
      RockstarClient.I_field_ab0f6068
         .error(
            "[PyRotation] \u043e\u0448\u0438\u0431\u043a\u0430 \u0432 '"
               + this.getName()
               + "' ("
               + var1
               + "), \u043e\u0442\u043a\u0430\u0442 \u043d\u0430 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u0443\u044e \u043d\u0430\u0432\u043e\u0434\u043a\u0443",
            var2
         );
   }

   static final class Nested1_e473fc99 {
      private final iiIIiIIii_Class404 rotation;
      private final iiIIiIIIi_Class402 moveCorrection;
      private final float yawSpeed;
      private final float pitchSpeed;
      private final float returnSpeed;
      private final iiIIiIiiI_Class407 priority;
      private final boolean correctGcd;

      Nested1_e473fc99(iiIIiIIii_Class404 var1, iiIIiIIIi_Class402 var2, float var3, float var4, float var5, iiIIiIiiI_Class407 var6, boolean var7) {
         this.rotation = var1;
         this.moveCorrection = var2;
         this.yawSpeed = var3;
         this.pitchSpeed = var4;
         this.returnSpeed = var5;
         this.priority = var6;
         this.correctGcd = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_e473fc99[rotation=" + this.rotation() + ", moveCorrection=" + this.moveCorrection() + ", yawSpeed=" + this.yawSpeed() + ", pitchSpeed=" + this.pitchSpeed() + ", returnSpeed=" + this.returnSpeed() + ", priority=" + this.priority() + ", correctGcd=" + this.correctGcd() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.rotation());
         result = 31 * result + java.util.Objects.hashCode(this.moveCorrection());
         result = 31 * result + java.util.Objects.hashCode(this.yawSpeed());
         result = 31 * result + java.util.Objects.hashCode(this.pitchSpeed());
         result = 31 * result + java.util.Objects.hashCode(this.returnSpeed());
         result = 31 * result + java.util.Objects.hashCode(this.priority());
         result = 31 * result + java.util.Objects.hashCode(this.correctGcd());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         PyRotationMode.Nested1_e473fc99 other = (PyRotationMode.Nested1_e473fc99) var1;
         return java.util.Objects.equals(this.rotation(), other.rotation())
            && java.util.Objects.equals(this.moveCorrection(), other.moveCorrection())
            && java.util.Objects.equals(this.yawSpeed(), other.yawSpeed())
            && java.util.Objects.equals(this.pitchSpeed(), other.pitchSpeed())
            && java.util.Objects.equals(this.returnSpeed(), other.returnSpeed())
            && java.util.Objects.equals(this.priority(), other.priority())
            && java.util.Objects.equals(this.correctGcd(), other.correctGcd());
      }

      public iiIIiIIii_Class404 rotation() {
         return this.rotation;
      }

      public iiIIiIIIi_Class402 moveCorrection() {
         return this.moveCorrection;
      }

      public float yawSpeed() {
         return this.yawSpeed;
      }

      public float pitchSpeed() {
         return this.pitchSpeed;
      }

      public float returnSpeed() {
         return this.returnSpeed;
      }

      public iiIIiIiiI_Class407 priority() {
         return this.priority;
      }

      public boolean correctGcd() {
         return this.correctGcd;
      }
   }
}
