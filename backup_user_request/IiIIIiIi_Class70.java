package rockstar.client;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import pyrock.events.render.ChatRenderEvent;
import pyrock.events.render.GameRendererEvent;
import pyrock.events.render.HandRenderEvent;
import pyrock.events.render.HudLayerRenderEvent;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.render.MenuRenderEvent;
import pyrock.events.render.PostHudLayerRenderEvent;
import pyrock.events.render.PostHudRenderEvent;
import pyrock.events.render.PostMenuRenderEvent;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.events.render.ScreenRenderEvent;

public class IiIIIiIi_Class70 {
   private final ConcurrentHashMap<Type, CopyOnWriteArrayList<IiIIIiII_Class69<?>>> I_field_3cacdad0 = new ConcurrentHashMap<>();
   private final Map<Class<?>, Field[]> I_field_a567c40b = new HashMap<>();
   private final Comparator<IiIIIiII_Class69<?>> I_field_c8f916f9 = Comparator.<IiIIIiII_Class69<?>>comparingInt(var0 -> var0.I_method_f12c6485()).reversed();
   private final BiConsumer<List<IiIIIiII_Class69<?>>, Comparator<IiIIIiII_Class69<?>>> I_field_17cc1433 = List::sort;
   private final Consumer<Throwable> I_field_f9f609fa = Throwable::printStackTrace;

   public void I_method_2257cd48(Object var1) {
      this.I_method_b0d5d165(var1, (var1x, var2) -> {
         this.I_field_3cacdad0.computeIfAbsent(var1x, var0 -> new CopyOnWriteArrayList<>()).add(var2);
         this.I_field_17cc1433.accept(this.I_field_3cacdad0.get(var1x), this.I_field_c8f916f9);
      });
   }

   public void i_method_f30f2128(Object var1) {
      this.I_method_b0d5d165(var1, (var1x, var2) -> {
         CopyOnWriteArrayList var3 = this.I_field_3cacdad0.get(var1x);
         if (var3 != null) {
            var3.remove(var2);
            if (var3.isEmpty()) {
               this.I_field_3cacdad0.remove(var1x);
            }
         }
      });
   }

   public <T extends IiIIIIIi_Class66> void I_method_e7f802ad(T var1) {
      Class var2 = var1.getClass();
      List var3 = this.I_field_3cacdad0.get(var2);
      boolean var4 = this.I_method_e7f802b1(var1);
      if (var4) {
         iIiiIIiiI_Class359.II_method_5031d522();
      }

      try {
         RockstarClient.getInstance().I_method_a90eb842().I_method_f52ba2c0(var1);
         if (var3 != null && !RockstarClient.I_field_502d1741.i_method_e8604970()) {
            for (IiIIIiII_Class69 var6 : (Iterable<IiIIIiII_Class69>)(Iterable<?>)var3) {
               try {
                  var6.onEvent(var1);
               } catch (Throwable var11) {
                  this.I_field_f9f609fa.accept(var11);
               }
            }
         }
      } finally {
         if (var4) {
            iIiiIIiiI_Class359.Ii_method_50406102();
         }
      }
   }

   private boolean I_method_e7f802b1(IiIIIIIi_Class66 var1) {
      return var1 instanceof PreHudRenderEvent
         || var1 instanceof HudRenderEvent
         || var1 instanceof PostHudRenderEvent
         || var1 instanceof ScreenRenderEvent
         || var1 instanceof MenuRenderEvent
         || var1 instanceof PostMenuRenderEvent
         || var1 instanceof HudLayerRenderEvent
         || var1 instanceof PostHudLayerRenderEvent
         || var1 instanceof ChatRenderEvent
         || var1 instanceof Render3DEvent
         || var1 instanceof HandRenderEvent
         || var1 instanceof GameRendererEvent;
   }

   private void I_method_b0d5d165(Object var1, BiConsumer<Type, IiIIIiII_Class69<?>> var2) {
      for (Field var6 : this.I_method_7cacb9bd(var1.getClass())) {
         if (var6.getType() == IiIIIiII_Class69.class) {
            IiIIIiII_Class69 var7 = this.I_method_3a43ac32(var1, var6);
            if (var7 != null) {
               Type var8 = ((ParameterizedType)var6.getGenericType()).getActualTypeArguments()[0];
               var2.accept(var8, var7);
            }
         }
      }
   }

   private Field[] I_method_7cacb9bd(Class<?> var1) {
      return this.I_field_a567c40b.computeIfAbsent(var1, Class::getDeclaredFields);
   }

   private IiIIIiII_Class69<?> I_method_3a43ac32(Object var1, Field var2) {
      boolean var3 = var2.canAccess(var1);
      var2.setAccessible(true);

      Object var5;
      try {
         return (IiIIIiII_Class69<?>)var2.get(var1);
      } catch (IllegalAccessException var9) {
         this.I_field_f9f609fa.accept(var9);
         var5 = null;
      } finally {
         var2.setAccessible(var3);
      }

      return (IiIIIiII_Class69<?>)var5;
   }
}
