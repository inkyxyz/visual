package pyrock;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import jep.python.PyObject;
import net.fabricmc.loader.api.FabricLoader;
import rockstar.client.IIiiIiiIi_Class110;
import rockstar.client.RockstarClient;

public final class McBridge {
   private static final String RESOURCE = "/rockstar/mc-mappings.txt.gz";
   private static volatile boolean loaded;
   private static boolean identity;
   private static final Map<String, String> classN2I = new HashMap<>();
   private static final Map<String, Map<String, String>> fieldsByClass = new HashMap<>();
   private static final Map<String, Map<String, List<McBridge.Nested1_850b7189>>> methodsByClass = new HashMap<>();
   private static final Map<String, Class<?>> classCache = new ConcurrentHashMap<>();
   private static final Map<McBridge.Nested1_839632da, Object> methodCache = new ConcurrentHashMap<>();
   private static final Map<McBridge.Nested1_52a48269, Object> fieldCache = new ConcurrentHashMap<>();
   private static final Object MISS = new Object();

   private McBridge() {
   }

   private static synchronized void ensureLoaded() {
      if (!loaded) {
         try {
            String var0 = FabricLoader.getInstance().getMappingResolver().getCurrentRuntimeNamespace();
            identity = "named".equals(var0);
            if (!identity) {
               parse();
               RockstarClient.I_field_ab0f6068
                  .info(
                     "[McBridge] \u043c\u0430\u043f\u043f\u0438\u043d\u0433\u0438 \u0437\u0430\u0433\u0440\u0443\u0436\u0435\u043d\u044b: {} \u043a\u043b\u0430\u0441\u0441\u043e\u0432",
                     classN2I.size()
                  );
            } else {
               RockstarClient.I_field_ab0f6068
                  .info(
                     "[McBridge] dev-\u0440\u0435\u0436\u0438\u043c (named) \u2014 \u043f\u0435\u0440\u0435\u0432\u043e\u0434 \u043d\u0435 \u043d\u0443\u0436\u0435\u043d"
                  );
            }
         } catch (Throwable var1) {
            RockstarClient.I_field_ab0f6068
               .error("[McBridge] \u043e\u0448\u0438\u0431\u043a\u0430 \u0438\u043d\u0438\u0446\u0438\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u0438", var1);
            identity = true;
         }

         loaded = true;
      }
   }

   private static void parse() throws Exception {
      try (InputStream var0 = McBridge.class.getResourceAsStream("/rockstar/mc-mappings.txt.gz")) {
         if (var0 == null) {
            throw new IllegalStateException(
               "\u0440\u0435\u0441\u0443\u0440\u0441 /rockstar/mc-mappings.txt.gz \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d \u0432 jar"
            );
         }

         try (BufferedReader var1 = new BufferedReader(new InputStreamReader(new GZIPInputStream(var0), StandardCharsets.UTF_8))) {
            String var2 = null;
            HashMap<String, String> var3 = null;
            HashMap<String, List<McBridge.Nested1_850b7189>> var4 = null;

            String var5;
            while ((var5 = var1.readLine()) != null) {
               if (!var5.isEmpty()) {
                  char var6 = var5.charAt(0);
                  String[] var7 = var5.split("\t");
                  if (var6 == 'C') {
                     var2 = var7[1];
                     classN2I.put(var7[2], var7[1]);
                     var3 = new HashMap();
                     var4 = new HashMap();
                     fieldsByClass.put((String)var2, var3);
                     methodsByClass.put((String)var2, var4);
                  } else if (var6 == 'F' && var3 != null) {
                     var3.put(var7[1], var7[2]);
                  } else if (var6 == 'M' && var4 != null) {
                     var4.computeIfAbsent(var7[2], var0x -> new ArrayList<>()).add(new McBridge.Nested1_850b7189(var7[3], Integer.parseInt(var7[1])));
                  }
               }
            }
         }
      }
   }

   public static Class<?> findClass(String var0) {
      ensureLoaded();
      IIiiIiiIi_Class110.I_method_7b55be29(var0);
      return classCache.computeIfAbsent(var0, var0x -> {
         String var1 = identity ? var0x : classN2I.getOrDefault(var0x, var0x);
         IIiiIiiIi_Class110.I_method_7b55be29(var1);

         try {
            return Class.forName(var1, false, McBridge.class.getClassLoader());
         } catch (ClassNotFoundException var3) {
            throw new RuntimeException("\u043a\u043b\u0430\u0441\u0441 \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d: " + var0x + " (" + var1 + ")", var3);
         }
      });
   }

   public static boolean isClass(Object var0) {
      return var0 instanceof Class;
   }

   public static boolean isInstance(Object var0, String var1) {
      Object var2 = unwrap(var0);
      return var2 != null && findClass(var1).isInstance(var2);
   }

   public static Object unwrap(Object var0) {
      if (var0 instanceof PyObject var1) {
         try {
            Object var2 = var1.getAttr("_obj");
            if (var2 != null) {
               return var2;
            }
         } catch (Throwable var3) {
         }
      }

      return var0;
   }

   public static boolean hasField(Object var0, String var1) {
      ensureLoaded();
      Object var2 = unwrap(var0);
      Class var3 = var2 instanceof Class var4 ? var4 : var2.getClass();
      return lookupField(var3, var1) != null;
   }

   public static Object getField(Object var0, String var1) {
      ensureLoaded();
      Object var2 = unwrap(var0);
      Class var3 = var2 instanceof Class var4 ? var4 : var2.getClass();
      Field var7 = lookupField(var3, var1);
      if (var7 == null) {
         throw new RuntimeException("\u043d\u0435\u0442 \u043f\u043e\u043b\u044f '" + var1 + "' \u0443 " + var3.getName());
      } else {
         try {
            Object var5 = var7.get(var2 instanceof Class ? null : var2);
            return var7.getType() == Object.class ? IIiiIiiIi_Class110.I_method_915a3057(var5) : var5;
         } catch (IllegalAccessException var6) {
            throw new RuntimeException(var6);
         }
      }
   }

   public static void setField(Object var0, String var1, Object var2) {
      ensureLoaded();
      Object var3 = unwrap(var0);
      Class var4 = var3 instanceof Class var5 ? var5 : var3.getClass();
      Field var8 = lookupField(var4, var1);
      if (var8 == null) {
         throw new RuntimeException("\u043d\u0435\u0442 \u043f\u043e\u043b\u044f '" + var1 + "' \u0443 " + var4.getName());
      } else {
         try {
            var8.set(var3 instanceof Class ? null : var3, coerce(var2, var8.getType()));
         } catch (IllegalAccessException var7) {
            throw new RuntimeException(var7);
         }
      }
   }

   public static Object invoke(Object var0, String var1, Object[] var2) {
      ensureLoaded();
      Object var3 = unwrap(var0);
      boolean var4 = var3 instanceof Class;
      Class var5 = var4 ? (Class)var3 : var3.getClass();
      int var6 = var2 == null ? 0 : var2.length;
      Method var7 = lookupMethod(var5, var1, var6);
      if (var7 == null) {
         throw new RuntimeException(
            "\u043d\u0435\u0442 \u043c\u0435\u0442\u043e\u0434\u0430 '" + var1 + "'(" + var6 + " \u0430\u0440\u0433.) \u0443 " + var5.getName()
         );
      } else {
         try {
            Object var8 = var7.invoke(var4 ? null : var3, coerceAll(var2, var7.getParameterTypes()));
            return var7.getReturnType() == Object.class ? IIiiIiiIi_Class110.I_method_915a3057(var8) : var8;
         } catch (IIiiIiiIi_Class110.Nested1_a5af6c60 var9) {
            throw var9;
         } catch (Exception var10) {
            throw new RuntimeException("\u043e\u0448\u0438\u0431\u043a\u0430 \u0432\u044b\u0437\u043e\u0432\u0430 " + var1 + ": " + var10.getMessage(), var10);
         }
      }
   }

   public static Object construct(String var0, Object[] var1) {
      return constructClass(findClass(var0), var1);
   }

   public static Object constructClass(Class<?> var0, Object[] var1) {
      ensureLoaded();
      IIiiIiiIi_Class110.I_method_5f293afe(var0);
      int var2 = var1 == null ? 0 : var1.length;

      for (Constructor var6 : var0.getDeclaredConstructors()) {
         if (var6.getParameterCount() == var2) {
            try {
               var6.setAccessible(true);
               return var6.newInstance(coerceAll(var1, var6.getParameterTypes()));
            } catch (Exception var8) {
            }
         }
      }

      throw new RuntimeException(
         "\u043d\u0435\u0442 \u043a\u043e\u043d\u0441\u0442\u0440\u0443\u043a\u0442\u043e\u0440\u0430 "
            + var0.getName()
            + " \u0441 "
            + var2
            + " \u0430\u0440\u0433."
      );
   }

   public static Iterator<?> iterator(Object var0) {
      return unwrap(var0) instanceof Iterable var1 ? var1.iterator() : null;
   }

   private static Field lookupField(Class<?> var0, String var1) {
      McBridge.Nested1_52a48269 var2 = new McBridge.Nested1_52a48269(var0, var1);
      Object var3 = fieldCache.get(var2);
      if (var3 != null) {
         return var3 == MISS ? null : (Field)var3;
      } else {
         Field var4 = resolveField(var0, var1);
         IIiiIiiIi_Class110.I_method_3b535d4e(var4);
         if (var4 != null) {
            var4.setAccessible(true);
         }

         fieldCache.put(var2, var4 == null ? MISS : var4);
         return var4;
      }
   }

   private static Method lookupMethod(Class<?> var0, String var1, int var2) {
      McBridge.Nested1_839632da var3 = new McBridge.Nested1_839632da(var0, var1, var2);
      Object var4 = methodCache.get(var3);
      if (var4 != null) {
         return var4 == MISS ? null : (Method)var4;
      } else {
         Method var5 = resolveMethod(var0, var1, var2);
         IIiiIiiIi_Class110.I_method_b0ca9c87(var5);
         if (var5 != null) {
            var5.setAccessible(true);
         }

         methodCache.put(var3, var5 == null ? MISS : var5);
         return var5;
      }
   }

   private static Field resolveField(Class<?> var0, String var1) {
      for (Class var2 = var0; var2 != null; var2 = var2.getSuperclass()) {
         String var3 = mapFieldName(var2, var1);
         Field var4 = declaredField(var2, var3);
         if (var4 == null && !var1.equals(var3)) {
            var4 = declaredField(var2, var1);
         }

         if (var4 != null) {
            return var4;
         }
      }

      return null;
   }

   private static Field declaredField(Class<?> var0, String var1) {
      if (var1 == null) {
         return null;
      } else {
         try {
            return var0.getDeclaredField(var1);
         } catch (NoSuchFieldException var3) {
            return null;
         }
      }
   }

   private static String mapFieldName(Class<?> var0, String var1) {
      if (identity) {
         return var1;
      } else {
         Map var2 = fieldsByClass.get(var0.getName());
         return var2 == null ? null : (String)var2.get(var1);
      }
   }

   private static Method resolveMethod(Class<?> var0, String var1, int var2) {
      for (Class var3 = var0; var3 != null; var3 = var3.getSuperclass()) {
         Method var4 = findOnClass(var3, var1, var2);
         if (var4 != null) {
            return var4;
         }
      }

      for (Class var7 : allInterfaces(var0)) {
         Method var5 = findOnClass(var7, var1, var2);
         if (var5 != null) {
            return var5;
         }
      }

      return null;
   }

   private static Method findOnClass(Class<?> var0, String var1, int var2) {
      List var3 = mapMethodNames(var0, var1, var2);
      Method var4 = null;

      for (Method var8 : var0.getDeclaredMethods()) {
         if (var8.getParameterCount() == var2) {
            if (var3.contains(var8.getName())) {
               return var8;
            }

            if (var4 == null && var8.getName().equals(var1)) {
               var4 = var8;
            }
         }
      }

      return var4;
   }

   private static List<String> mapMethodNames(Class<?> var0, String var1, int var2) {
      if (identity) {
         return List.of(var1);
      } else {
         Map var3 = methodsByClass.get(var0.getName());
         if (var3 == null) {
            return List.of();
         } else {
            List var4 = (List)var3.get(var1);
            if (var4 == null) {
               return List.of();
            } else {
               ArrayList var5 = new ArrayList(2);

               for (McBridge.Nested1_850b7189 var7 : (Iterable<McBridge.Nested1_850b7189>)(Iterable<?>)var4) {
                  if (var7.argc == var2) {
                     var5.add(var7.inter);
                  }
               }

               return var5;
            }
         }
      }
   }

   private static List<Class<?>> allInterfaces(Class<?> var0) {
      ArrayList var1 = new ArrayList();

      for (Class var2 = var0; var2 != null; var2 = var2.getSuperclass()) {
         collectInterfaces(var2, var1);
      }

      return var1;
   }

   private static void collectInterfaces(Class<?> var0, List<Class<?>> var1) {
      for (Class var5 : var0.getInterfaces()) {
         if (!var1.contains(var5)) {
            var1.add(var5);
            collectInterfaces(var5, var1);
         }
      }
   }

   private static Object[] coerceAll(Object[] var0, Class<?>[] var1) {
      if (var0 == null) {
         return new Object[0];
      } else {
         Object[] var2 = new Object[var0.length];

         for (int var3 = 0; var3 < var0.length; var3++) {
            var2[var3] = coerce(var0[var3], var3 < var1.length ? var1[var3] : Object.class);
         }

         return var2;
      }
   }

   private static Object coerce(Object var0, Class<?> var1) {
      Object var2 = unwrap(var0);
      if (var2 == null) {
         return null;
      } else {
         if (var2 instanceof Number var3) {
            if (var1 == int.class || var1 == Integer.class) {
               return var3.intValue();
            }

            if (var1 == long.class || var1 == Long.class) {
               return var3.longValue();
            }

            if (var1 == float.class || var1 == Float.class) {
               return var3.floatValue();
            }

            if (var1 == double.class || var1 == Double.class) {
               return var3.doubleValue();
            }

            if (var1 == short.class || var1 == Short.class) {
               return var3.shortValue();
            }

            if (var1 == byte.class || var1 == Byte.class) {
               return var3.byteValue();
            }
         }

         return var2;
      }
   }

   static final class Nested1_52a48269 {
      private final Class<?> owner;
      private final String name;

      Nested1_52a48269(Class<?> var1, String var2) {
         this.owner = var1;
         this.name = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_52a48269[owner=" + this.owner() + ", name=" + this.name() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.owner());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         McBridge.Nested1_52a48269 other = (McBridge.Nested1_52a48269) var1;
         return java.util.Objects.equals(this.owner(), other.owner())
            && java.util.Objects.equals(this.name(), other.name());
      }

      public Class<?> owner() {
         return this.owner;
      }

      public String name() {
         return this.name;
      }
   }

   static final class Nested1_839632da {
      private final Class<?> owner;
      private final String name;
      private final int argc;

      Nested1_839632da(Class<?> var1, String var2, int var3) {
         this.owner = var1;
         this.name = var2;
         this.argc = var3;
      }

      @Override
      public final String toString() {
         return "Nested1_839632da[owner=" + this.owner() + ", name=" + this.name() + ", argc=" + this.argc() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.owner());
         result = 31 * result + java.util.Objects.hashCode(this.name());
         result = 31 * result + java.util.Objects.hashCode(this.argc());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         McBridge.Nested1_839632da other = (McBridge.Nested1_839632da) var1;
         return java.util.Objects.equals(this.owner(), other.owner())
            && java.util.Objects.equals(this.name(), other.name())
            && java.util.Objects.equals(this.argc(), other.argc());
      }

      public Class<?> owner() {
         return this.owner;
      }

      public String name() {
         return this.name;
      }

      public int argc() {
         return this.argc;
      }
   }

   static final class Nested1_850b7189 {
      final String inter;
      final int argc;

      Nested1_850b7189(String var1, int var2) {
         this.inter = var1;
         this.argc = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_850b7189[inter=" + this.inter() + ", argc=" + this.argc() + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.inter());
         result = 31 * result + java.util.Objects.hashCode(this.argc());
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         McBridge.Nested1_850b7189 other = (McBridge.Nested1_850b7189) var1;
         return java.util.Objects.equals(this.inter(), other.inter())
            && java.util.Objects.equals(this.argc(), other.argc());
      }

      public String inter() {
         return this.inter;
      }

      public int argc() {
         return this.argc;
      }
   }
}
