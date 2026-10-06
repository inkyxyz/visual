package pyrock.classes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.minecraft.client.util.SkinTextures.Model;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import pyrock.utility.render.PyAssets;
import pyrock.utility.render.PyDynamicTexture;
import rockstar.client.IIiiIIiii_Class104;
import rockstar.client.IiIIIIiIi_Class134;
import rockstar.client.IiIIIIiiI_Class135;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIiIi_Class294;

public class PySkins implements iIIiIIiIi_Class294 {
   private final IIiiIIiii_Class104 creator = IIiiIIiii_Class104.I_method_204b62f5();

   public void set(Object var1, Object var2, Object var3, Object var4, Object var5) {
      if (var2 != null) {
         this.skin(var1, var2);
      }

      if (var3 != null) {
         this.cape(var1, var3);
      }

      if (var4 != null) {
         this.elytra(var1, var4);
      }

      if (var5 != null) {
         this.model(var1, var5);
      }
   }

   public void skin(Object var1, Object var2) {
      String var3 = this.target(var1);
      if (var2 == null) {
         IiIIIIiiI_Class135.Nested1_739d1420 var6 = IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3);
         var6.I_method_cf37ad45(null);
         var6.I_method_7b2fc652(null);
         IiIIIIiiI_Class135.I_method_b4926e69(var3);
      } else {
         Identifier var4 = this.texture(var2);
         if (var4 != null) {
            IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).I_method_cf37ad45(var4);
         } else {
            String var5 = String.valueOf(var2);
            if (this.isPath(var5)) {
               this.await(
                  IiIIIIiIi_Class134.i_method_2cd18e4b(this.file(var5)),
                  var2x -> IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).I_method_cf37ad45(var2x),
                  var5
               );
            } else {
               this.await(IiIIIIiIi_Class134.I_method_de1d7e2b(var5), var3x -> {
                  if (var3x == null) {
                     throw new IllegalStateException("\u043d\u0435\u0442 \u0438\u0433\u0440\u043e\u043a\u0430 \u0441 \u043d\u0438\u043a\u043e\u043c " + var5);
                  } else {
                     IiIIIIiiI_Class135.Nested1_739d1420 var4x = IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3);
                     var4x.I_method_cf37ad45(var3x.texture());
                     var4x.I_method_7b2fc652(var3x.model());
                  }
               }, var5);
            }
         }
      }
   }

   public void cape(Object var1, Object var2) {
      String var3 = this.target(var1);
      if (var2 == null) {
         IiIIIIiiI_Class135.Nested1_739d1420 var7 = IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3);
         var7.I_method_75dca27a(false);
         var7.i_method_aa4fa565(null);
         IiIIIIiiI_Class135.I_method_b4926e69(var3);
      } else if (Boolean.FALSE.equals(var2)) {
         IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).I_method_75dca27a(true);
      } else {
         Identifier var4 = this.texture(var2);
         if (var4 != null) {
            IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).i_method_aa4fa565(var4);
         } else {
            String var5 = String.valueOf(var2);
            if (var5.toLowerCase(Locale.ROOT).startsWith("optifine:")) {
               String var6 = var5.substring("optifine:".length()).trim();
               this.await(
                  IiIIIIiIi_Class134.Ii_method_e896cca8(var6), var2x -> IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).i_method_aa4fa565(var2x), var5
               );
            } else if (this.isPath(var5)) {
               this.await(
                  IiIIIIiIi_Class134.II_method_99e2bc88(this.file(var5)),
                  var2x -> IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).i_method_aa4fa565(var2x),
                  var5
               );
            } else {
               this.await(
                  IiIIIIiIi_Class134.I_method_de1d7e2b(var5),
                  var3x -> {
                     if (var3x != null && var3x.capeTexture() != null) {
                        IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).i_method_aa4fa565(var3x.capeTexture());
                     } else {
                        throw new IllegalStateException(
                           "\u0443 \u0438\u0433\u0440\u043e\u043a\u0430 " + var5 + " \u043d\u0435\u0442 \u043f\u043b\u0430\u0449\u0430"
                        );
                     }
                  },
                  var5
               );
            }
         }
      }
   }

   public void elytra(Object var1, Object var2) {
      String var3 = this.target(var1);
      if (var2 == null) {
         IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).II_method_78801c38(null);
         IiIIIIiiI_Class135.I_method_b4926e69(var3);
      } else {
         Identifier var4 = this.texture(var2);
         if (var4 != null) {
            IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).II_method_78801c38(var4);
         } else {
            String var5 = String.valueOf(var2);
            if (this.isPath(var5)) {
               this.await(
                  IiIIIIiIi_Class134.II_method_99e2bc88(this.file(var5)),
                  var2x -> IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).II_method_78801c38(var2x),
                  var5
               );
            } else {
               this.await(
                  IiIIIIiIi_Class134.I_method_de1d7e2b(var5),
                  var3x -> {
                     if (var3x != null && var3x.elytraTexture() != null) {
                        IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).II_method_78801c38(var3x.elytraTexture());
                     } else {
                        throw new IllegalStateException(
                           "\u0443 \u0438\u0433\u0440\u043e\u043a\u0430 "
                              + var5
                              + " \u043d\u0435\u0442 \u0441\u0432\u043e\u0435\u0439 \u044d\u043b\u0438\u0442\u0440\u044b"
                        );
                     }
                  },
                  var5
               );
            }
         }
      }
   }

   public void model(Object var1, Object var2) {
      String var3 = this.target(var1);
      if (var2 == null) {
         IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).I_method_7b2fc652(null);
         IiIIIIiiI_Class135.I_method_b4926e69(var3);
      } else {
         String var4 = String.valueOf(var2).trim().toLowerCase(Locale.ROOT);

         Model var5 = switch (var4) {
            case "slim", "alex", "thin" -> Model.SLIM;
            case "wide", "steve", "classic", "default" -> Model.WIDE;
            default -> throw new IllegalArgumentException(
               "\u043c\u043e\u0434\u0435\u043b\u044c \u0431\u044b\u0432\u0430\u0435\u0442 slim \u0438\u043b\u0438 wide, \u0430 \u043d\u0435 " + var2
            );
         };
         IiIIIIiiI_Class135.I_method_13950f16(this.owner(), var3).I_method_7b2fc652(var5);
      }
   }

   public void reset(Object var1) {
      IiIIIIiiI_Class135.i_method_8549c249(this.target(var1));
   }

   public void clear() {
      IiIIIIiiI_Class135.I_method_6711347b(this.owner());
   }

   public List<String> targets() {
      return IiIIIIiiI_Class135.I_method_6124ea08();
   }

   public Map<String, Object> get(Object var1) {
      HashMap var2 = new HashMap();
      IiIIIIiiI_Class135.Nested1_739d1420 var3 = IiIIIIiiI_Class135.I_method_ae6ca9fa(this.target(var1));
      if (var3 == null) {
         return var2;
      } else {
         if (var3.I_method_843fd969() != null) {
            var2.put("skin", var3.I_method_843fd969().toString());
         }

         if (var3.i_method_28385d49() != null) {
            var2.put("cape", var3.i_method_28385d49().toString());
         }

         if (var3.II_method_c3844016() != null) {
            var2.put("elytra", var3.II_method_c3844016().toString());
         }

         if (var3.I_method_b4023ab4() != null) {
            var2.put("model", var3.I_method_b4023ab4().getName());
         }

         var2.put("hide_cape", var3.I_method_a0b4839e());
         return var2;
      }
   }

   private String target(Object var1) {
      if (var1 == null) {
         return this.self();
      } else if (var1 instanceof PlayerEntity var4) {
         return var4.getGameProfile().getName();
      } else if (var1 instanceof Entity var3) {
         return var3.getName().getString();
      } else {
         String var2 = String.valueOf(var1).trim();
         if (var2.isEmpty() || var2.equalsIgnoreCase("self") || var2.equalsIgnoreCase("me")) {
            return this.self();
         } else {
            return !var2.equals("*") && !var2.equalsIgnoreCase("all") ? var2 : "*";
         }
      }
   }

   private String self() {
      return I_field_3a9bda27.player != null ? I_field_3a9bda27.player.getGameProfile().getName() : I_field_3a9bda27.getSession().getUsername();
   }

   private Identifier texture(Object var1) {
      if (var1 instanceof Identifier var3) {
         return var3;
      } else {
         return var1 instanceof PyDynamicTexture var2 ? var2.identifier() : null;
      }
   }

   private boolean isPath(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);
      return var2.startsWith("http://") || var2.startsWith("https://") || var2.contains("/") || var2.contains("\\") || var2.endsWith(".png");
   }

   private String file(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);
      if (!var2.startsWith("http://") && !var2.startsWith("https://")) {
         Path var3 = PyAssets.resolve(var1);
         if (!Files.isRegularFile(var3)) {
            throw new IllegalArgumentException("\u0444\u0430\u0439\u043b\u0430 \u043d\u0435\u0442: " + var3);
         } else {
            return var3.toString();
         }
      } else {
         return var1;
      }
   }

   private <T> void await(CompletableFuture<T> var1, Consumer<T> var2, String var3) {
      var1.thenAccept(var2)
         .exceptionally(
            var1x -> {
               Throwable var2x = var1x.getCause() != null ? var1x.getCause() : var1x;
               RockstarClient.I_field_ab0f6068
                  .warn(
                     "\u0421\u043a\u0438\u043d\u044b: \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0432\u0437\u044f\u0442\u044c \u043e\u0431\u043b\u0438\u043a \u0438\u0437 {}: {}",
                     var3,
                     var2x.getMessage()
                  );
               return null;
            }
         );
   }

   private Object owner() {
      IIiiIIiii_Class104 var1 = IIiiIIiii_Class104.I_method_204b62f5();
      if (var1 != null) {
         return var1;
      } else {
         return this.creator != null ? this.creator : this;
      }
   }
}
